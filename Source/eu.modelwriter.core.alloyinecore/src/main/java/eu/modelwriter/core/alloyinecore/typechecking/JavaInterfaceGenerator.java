package eu.modelwriter.core.alloyinecore.typechecking;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedClass;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedPackage;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import javax.tools.Diagnostic;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaInterfaceGenerator {

    private JavaInterfaceGenerator importGenerator = null;

    protected Set<Trace> traces = new HashSet<>();
    protected Set<JavaSourceFromString> generatedFiles = new HashSet<>();
    protected int currentLineNumber = 0;
    protected String currentFileName = "";
    protected String outDir;
    protected boolean save;
    private String currentPackageName;

    public JavaInterfaceGenerator(String outDir, boolean save) {
        this.outDir = outDir;
        this.save = save;
    }

    public JavaInterfaceGenerator getImportGenerator() {
        if (importGenerator == null)
            importGenerator = new JavaInterfaceGenerator(outDir, save);
        return importGenerator;
    }

    public Set<JavaSourceFromString> getGeneratedFiles() {
        return generatedFiles;
    }

    public Set<Trace> getTokenTraces() {
        return traces;
    }

    public Set<Token> findTokens(Diagnostic diagnostic) {
        for (Trace trace : getTokenTraces()) {
            if (trace.overlaps(diagnostic))
                return trace.getTokens();
        }
        return new HashSet<>();
    }

    public String getTokensAsString(Diagnostic diagnostic) {
        return findTokens(diagnostic).stream().map(tk -> tk.getText() + " at line " + tk.getLine()).collect(Collectors.joining(", "));
    }

    public void clearTraces() {
        importGenerator.clearTraces();
        traces.clear();
    }

    public JavaSourceFromString generate(Element<? extends ParserRuleContext> claz) {
        currentLineNumber = 0;
        currentFileName = getJavaPath(claz, File.separator, true);
        currentPackageName = getJavaPath(claz, ".", false);
        StringBuilder builder = new StringBuilder();
        classToJavaInterface(builder, claz);
        String code2 = builder.toString();
        JavaSourceFromString generated = new JavaSourceFromString(currentFileName, code2);
        generatedFiles.add(generated);
        if (save) saveFile(generated);
        return generated;
    }

    protected void saveFile(JavaSourceFromString generated) {
        try {
            Path path = Paths.get(outDir + File.separator + generated.getRawName() + ".java");
            if (!Files.exists(path.getParent()))
                Files.createDirectories(path.getParent());
            Files.write(path, generated.code.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void classToJavaInterface(StringBuilder builder, Element<? extends ParserRuleContext> clazz) {
        appendPackage(builder, clazz);
        builder.append(newLine());
        appendImports(builder, clazz);
        builder.append(newLine());
        appendInterface(builder, clazz);
    }

    protected void appendPackage(StringBuilder builder, Element<? extends ParserRuleContext> clazz) {
        builder.append("package ");
        builder.append(getJavaPath(clazz, ".", false));
        builder.append(";");
        Trace packageTrace = new Trace(currentFileName, 0, 0, builder.length() - 1);
        packageTrace.addToken(clazz.getOwner().getToken());
        traces.add(packageTrace);
    }

    protected void appendImports(StringBuilder builder, Element<? extends ParserRuleContext> clazz) {
        clazz.getOwnedElements(GenericSuperType.class)
                .forEach(gst -> appendImport(builder, gst));
        clazz.getOwnedElements(TypeParameter.class)
                .forEach(gt -> appendImport(builder, gt));
        clazz.getOwnedElements(StructuralFeature.class).stream()
                .map(sfElement -> (GenericElementType) sfElement.getOwnedElement(GenericElementType.class))
                .forEach(get -> appendImport(builder, get));
    }

    protected void appendImport(StringBuilder builder, Element<? extends ParserRuleContext> element) {
        if (!element.getContext().getText().contains("::")) {
            String text = element.getContext().start.getText();
            // Skip primitives
            if (isPrimitive(text)) {
                return;
            }
            // Skip type parameters
            List<TypeParameter> typeParameters = element.getOwner(Class.class).getOwnedElements(TypeParameter.class);
            String finalText = text;
            if (typeParameters.stream().anyMatch(tp -> tp.getContext().start.getText().equals(finalText))) {
                return;
            }
            // Append element import
            Package containerPackage = element.getOwner(Package.class);
            if (containerPackage != null) text = containerPackage.getEObject().getName() + "." + text;
            builder.append("import ");
            appendWithToken(builder, text, element.getToken());
            builder.append(";");
            builder.append(newLine());
        } else {
            //TODO: find better way to handle aie imports
            String importText;
            // Check if its imported class
            ImportedClass importedClass = findImportedClass(element);
            if (importedClass != null) {
                // If so generate Java file
                JavaSourceFromString generated = getImportGenerator().generate(importedClass);
                generatedFiles.add(generated);
                traces.addAll(getImportGenerator().getTokenTraces());
                // And use its path for import
                importText = generated.getRawName().replaceAll(File.separator, ".");
            } else {
                // Else, assume this is a relative path
                // TODO: Gotta be sure, it is relative
                importText = currentPackageName + "." + element.getContext().getText().replaceAll("::", ".").replaceAll(":", ".");
            }
            builder.append("import ");
            appendWithToken(builder, importText, element.getToken());
            builder.append(";");
            builder.append(newLine());
        }
    }

    private ImportedClass findImportedClass(Element<? extends ParserRuleContext> element) {
        Element<? extends ParserRuleContext> model = element.getOwner(Model.class);
        assert model != null;
        List<ImportedClass> importedClasses = model.getOwnedElementsInDepth(ImportedClass.class);
        String text = element.getContext().getText();
        String midPart = text.substring(0, text.lastIndexOf("::"));
        String uniqueClassName = "Model::" + midPart + ":" + text.substring(text.lastIndexOf("::") + 2);
        ImportedClass importedClass = null;
        for (ImportedClass cls : importedClasses) {
            String finalName = "";
            String uniqueName = cls.getUniqueName();
            String[] first = uniqueName.split("::");
            String[] mid = first[2].split(":");
            if (mid.length == 2) {
                finalName = String.join("::", first[0], first[1]) + ":" + mid[1];
            } else {
                for (int i = 0; i < first.length; i++) {
                    if (i == 2)
                        continue;
                    finalName += first[i];
                    if (i != first.length - 1)
                        finalName += "::";
                }
            }
            if (finalName.equals(uniqueClassName)) {
                importedClass = cls;
                break;
            }
        }
        return importedClass;
    }

    protected void appendInterface(StringBuilder builder, Element<? extends ParserRuleContext> clazz) {
        appendVisibility(builder, clazz);
        builder.append("interface ");
        // Append Class label as interface name
        appendInterfaceName(builder, clazz);
        appendSuperTypes(builder, clazz);

        builder.append(newLine());
        builder.append("{");
        builder.append(newLine());

        appendStructuralFeatures(builder, clazz);
        builder.append("}");
    }

    protected void appendStructuralFeatures(StringBuilder builder, Element<? extends ParserRuleContext> clazz) {
        List<StructuralFeature> sfs = new ArrayList<>();
        sfs.addAll(clazz.getOwnedElements(Attribute.class));
        sfs.addAll(clazz.getOwnedElements(Reference.class));
        for (StructuralFeature sf : sfs) {
            builder.append("\t");
            appendVisibility(builder, sf);
            GenericElementType elementType = (GenericElementType) sf.getOwnedElement(GenericElementType.class);
            String typeName = elementType.getContext().getText();
            // Get last part of path
            if (typeName.contains("::"))
                typeName = typeName.substring(typeName.lastIndexOf("::") + 2);
            appendWithToken(builder, typeName, elementType.getToken());
            builder.append(" ");
            appendWithToken(builder, sf.getLabel(), sf.getToken());
            builder.append("();");
            builder.append(newLine());
        }
    }

    protected void appendInterfaceName(StringBuilder builder, Element<? extends ParserRuleContext> clazz) {
        int baseIndex = builder.length() - 1;
        String baseText = clazz.getLabel();
        builder.append(clazz.getLabel());
        // Trace of Class name
        addTrace(baseText, baseIndex, clazz.getToken().getText(), clazz.getToken());
        clazz.getOwnedElements(TypeParameter.class).forEach(tp -> {
            // Trace of TypeParameters
            addTrace(baseText, baseIndex, tp.getEObject().getName(), tp.getToken());
            tp.getOwnedElements(GenericType.class).forEach(gt -> {
                // Trace of GenericType
                addTrace(baseText, baseIndex, gt.getEObject().eClass().getName(), gt.getToken());
            });
        });
    }

    protected void appendVisibility(StringBuilder builder, Element element) {
        if (element instanceof IVisibility) {
            Visibility value = ((IVisibility) element).getVisibility();
            if (value == Visibility.PUBLIC || value == Visibility.PROTECTED) {
                appendWithToken(builder, value.name().toLowerCase(), element.getContext().getStart());
                builder.append(" ");
            }
        }
    }

    protected void appendSuperTypes(StringBuilder builder, Element<? extends ParserRuleContext> clazz) {
        List<GenericSuperType> supers = clazz.getOwnedElements(GenericSuperType.class);
        if (!supers.isEmpty())
            builder.append(" extends ");
        supers.forEach(sp -> {
            appendWithToken(builder, sp.getContext().getText(), sp.getToken());
            if (supers.indexOf(sp) != supers.size() - 1)
                builder.append(", ");
        });
    }

    protected void appendWithToken(StringBuilder builder, String text, Token token) {
        int start = builder.length() - 1;
        Trace trace = new Trace(currentFileName, currentLineNumber, start, start + text.length());
        trace.addToken(token);
        traces.add(trace);
        builder.append(text);
    }

    protected void addTrace(String baseText, int baseIndex, String text, Token token) {
        int start = baseIndex + baseText.indexOf(text);
        int end = start + text.length();
        Trace trace = new Trace(currentFileName, currentLineNumber, start, end);
        trace.addToken(token);
        traces.add(trace);
    }

    public boolean isPrimitive(String text) {
        return text.equals("String") || text.equals("Boolean") || text.equals("Integer") || text.equals("Real") || text.equals("BigInteger");
    }

    protected String newLine() {
        currentLineNumber++;
        return System.getProperty("line.separator");
    }

    protected String getJavaPath(Element<? extends ParserRuleContext> element, String separator, boolean includeItself) {
        Element ownerPackage = element.getOwner();
        String result = ownerPackage.getToken().getText();
        if (includeItself) result += separator + element.getToken().getText();
        while (ownerPackage.getOwner() != null &&
                (ownerPackage.getOwner() instanceof Package || ownerPackage.getOwner() instanceof ImportedPackage)) {
            ownerPackage = ownerPackage.getOwner();
            result = ownerPackage.getToken().getText() + separator + result;
        }
        return result;
    }
}
