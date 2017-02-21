package eu.modelwriter.core.alloyinecore.typechecking;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.ITarget;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedClass;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedDataType;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedPackage;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import org.antlr.v4.runtime.ParserRuleContext;

import javax.tools.Diagnostic;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class JavaInterfaceGenerator {

    private JavaInterfaceGenerator importGenerator = null;

    private Set<JavaSourceFromString> generatedFiles = new HashSet<>();
    private Set<Trace> traces = new HashSet<>();
    private String currentFileName = "";
    private String outDir;
    private int currentLineNumber = 0;
    private boolean save;
    private String currentPackageName;

    public JavaInterfaceGenerator(String outDir, boolean save) {
        this.outDir = outDir;
        this.save = save;
    }

    public JavaInterfaceGenerator getImportGenerator() {
        if (importGenerator == null)
            importGenerator = new JavaInterfaceGenerator(outDir, save);
        importGenerator.clearTraces();
        return importGenerator;
    }

    public Set<JavaSourceFromString> getGeneratedFiles() {
        return generatedFiles;
    }

    public Set<Trace> getTraces() {
        return traces;
    }

    public Set<Element<?>> findTokens(Diagnostic diagnostic) {
        for (Trace trace : getTraces()) {
            if (trace.overlaps(diagnostic))
                return trace.getTokens();
        }
        return new HashSet<>();
    }

    public String getTokensAsString(Diagnostic diagnostic) {
        return findTokens(diagnostic).stream().map(tk -> tk.getToken().getText() + " at line " + tk.getLine()).collect(Collectors.joining(", "));
    }

    public void clearTraces() {
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

    private void saveFile(JavaSourceFromString generated) {
        try {
            Path path = Paths.get(outDir + File.separator + generated.getRawName() + ".java");
            if (!Files.exists(path.getParent()))
                Files.createDirectories(path.getParent());
            Files.write(path, generated.code.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void classToJavaInterface(StringBuilder builder, Element<? extends ParserRuleContext> element) {
        appendPackage(builder, element);
        builder.append(newLine());
        appendImports(builder, element);
        builder.append(newLine());
        appendInterface(builder, element);
    }

    private void appendPackage(StringBuilder builder, Element<? extends ParserRuleContext> element) {
        builder.append("package ");
        builder.append(getJavaPath(element, ".", false));
        builder.append(";");
        Trace packageTrace = new Trace(currentFileName, 0, 0, builder.length() - 1);
        packageTrace.addToken(element.getOwner());
        traces.add(packageTrace);
    }

    private void appendImports(StringBuilder builder, Element<? extends ParserRuleContext> element) {
        element.getAllOwnedElements(GenericSuperType.class, true)
                .forEach(gst -> appendImport(builder, gst));
        element.getAllOwnedElements(TypeParameter.class, true)
                .forEach(gt -> appendImport(builder, gt));
        element.getAllOwnedElements(GenericType.class, true)
                .forEach(gt -> appendImport(builder, gt));
        element.getAllOwnedElements(GenericElementType.class, true)
                .forEach(gt -> appendImport(builder, gt));
    }

    private void appendImport(StringBuilder builder, Element<? extends ParserRuleContext> element) {
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
            appendWithToken(builder, text, element);
            builder.append(";");
            builder.append(newLine());
        } else {
            String importText = "";
            Element<?> targetElement = findElementBySegment(element, element.getContext().getText());
            // Check if its imported class
            if (targetElement != null && targetElement instanceof ImportedClass || targetElement instanceof ImportedDataType) {
                // If so generate Java file
                JavaSourceFromString generated = getImportGenerator().generate(targetElement);
                generatedFiles.add(generated);
                traces.addAll(getImportGenerator().getTraces());
                // And use its path for import
                importText = generated.getRawName().replaceAll(File.separator, ".");
            } else if (targetElement != null) {
                // Get its package info and append it
                importText = getJavaPath(targetElement, ".", true);
            }
            // Else, assume this is a relative path
            // importText = currentPackageName + "." + element.getContext().getText().replaceAll("::", ".").replaceAll(":", ".");
            if (!importText.isEmpty()) {
                builder.append("import ");
                appendWithToken(builder, importText, element);
                builder.append(";");
                builder.append(newLine());
            }
        }
    }

    private Element findElementBySegment(Element element, String segmentsToFind) {
        Element result = null;
        Element parent = element.getOwner();
        while (result == null && parent != null) {
            List<Element> ownedElements = parent.getOwnedElements(ITarget.class);
            if (parent instanceof Package || parent instanceof ImportedPackage)
                ownedElements = parent.getAllOwnedElements(ITarget.class, true);
            if (parent instanceof Model) {
                ownedElements = parent.getAllOwnedElements(ImportedClass.class, true);
                ownedElements.addAll(parent.getAllOwnedElements(ImportedDataType.class, true));
            }

            result = ownedElements
                    .stream()
                    .filter(e -> ((ITarget) e).getRelativeSegment().equals(segmentsToFind))
                    .findFirst()
                    .orElse(null);
            parent = parent.getOwner();
        }
        return result;
    }

    @Deprecated
    private ImportedClass findImportedClass(Element<? extends ParserRuleContext> element) {
        Element<? extends ParserRuleContext> model = element.getOwner(Model.class);
        assert model != null;
        List<ImportedClass> importedClasses = model.getAllOwnedElements(ImportedClass.class, true);
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

    private void appendInterface(StringBuilder builder, Element<? extends ParserRuleContext> element) {
        appendVisibility(builder, element);
        builder.append("interface ");
        // Append Class label as interface name
        appendInterfaceName(builder, element);
        appendSuperTypes(builder, element);

        builder.append(newLine());
        builder.append("{");
        builder.append(newLine());

        appendStructuralFeatures(builder, element);
        appendOperations(builder, element);
        builder.append("}");
    }

    private void appendOperations(StringBuilder builder, Element<? extends ParserRuleContext> element) {
        for (Operation op : element.getOwnedElements(Operation.class)) {
            builder.append("\t");
            appendVisibility(builder, op);
            TypeParameter typeParameter = op.getOwnedElement(TypeParameter.class);
            if (typeParameter != null) {
                appendTypeParameters(builder, Collections.singletonList(typeParameter));
            }
            GenericElementType elementType = op.getOwnedElement(GenericElementType.class);
            if (elementType != null) {
                String typeName = elementType.getContext().getText();
                // Get last part of path
                if (typeName.contains("::")) {
                    typeName = typeName.substring(typeName.lastIndexOf("::") + 2);
                }
                appendWithToken(builder, typeName, elementType);
                Multiplicity mul = op.getOwnedElement(Multiplicity.class);
                if (mul != null && mul.isMany())
                    builder.append("[]");

            } else builder.append("void");
            builder.append(" ");
            appendWithToken(builder, op.getToken().getText(), op);
            builder.append("(");
            appendParameters(builder, op);
            builder.append(");");
            builder.append(newLine());
        }
    }

    private void appendTypeParameters(StringBuilder builder, List<TypeParameter> typeParameters) {
        builder.append("<");
        for (Iterator<TypeParameter> iterator = typeParameters.iterator(); iterator.hasNext(); ) {
            TypeParameter tp = iterator.next();
            int baseIndex = builder.length() - 1;
            String text = tp.getLabel();
            builder.append(text);
            addTrace(text, baseIndex, tp.getContext().start.getText(), tp);
            tp.getOwnedElements(GenericType.class)
                    .forEach(gt -> addTrace(text, baseIndex, gt.getToken().getText(), gt));
            if (iterator.hasNext()) builder.append(", ");
        }
        builder.append("> ");
    }

    private void appendParameters(StringBuilder builder, Operation op) {
        for (Iterator<Parameter> iterator = op.getOwnedElements(Parameter.class).iterator(); iterator.hasNext(); ) {
            Parameter param = iterator.next();
            GenericElementType type = param.getOwnedElement(GenericElementType.class);
            appendWithToken(builder, type.getLabel(), type);
            builder.append(" ");
            appendWithToken(builder, param.getToken().getText(), param);
            if (iterator.hasNext()) builder.append(", ");
        }
    }

    private void appendStructuralFeatures(StringBuilder builder, Element<? extends ParserRuleContext> element) {
        List<StructuralFeature> sfs = new ArrayList<>();
        sfs.addAll(element.getOwnedElements(Attribute.class));
        sfs.addAll(element.getOwnedElements(Reference.class));
        for (StructuralFeature<?, ?> sf : sfs) {
            builder.append("\t");
            appendVisibility(builder, sf);
            GenericElementType elementType = sf.getOwnedElement(GenericElementType.class);
            String typeName = elementType.getContext().getText();
            // Get last part of path
            if (typeName.contains("::"))
                typeName = typeName.substring(typeName.lastIndexOf("::") + 2);
            appendWithToken(builder, typeName, elementType);
            Multiplicity mul = sf.getOwnedElement(Multiplicity.class);
            if (mul != null && mul.isMany())
                builder.append("[]");
            builder.append(" ");
            appendWithToken(builder, sf.getLabel(), sf);
            builder.append("();");
            builder.append(newLine());
        }
    }

    private void appendInterfaceName(StringBuilder builder, Element<? extends ParserRuleContext> element) {
        int baseIndex = builder.length() - 1;
        String baseText = element.getLabel();
        builder.append(element.getLabel());
        // Trace of Class name
        addTrace(baseText, baseIndex, element.getToken().getText(), element);
        element.getOwnedElements(TypeParameter.class).forEach(tp -> {
            // Trace of TypeParameters
            addTrace(baseText, baseIndex, tp.getEObject().getName(), tp);
            tp.getOwnedElements(GenericType.class).forEach(gt -> {
                // Trace of GenericType
                addTrace(baseText, baseIndex, gt.getEObject().eClass().getName(), gt);
            });
        });
    }

    private void appendVisibility(StringBuilder builder, Element element) {
        if (element instanceof IVisibility) {
            Visibility value = ((IVisibility) element).getVisibility();
            if (value == Visibility.PUBLIC || value == Visibility.PROTECTED) {
                appendWithToken(builder, value.name().toLowerCase(), element);
                builder.append(" ");
            }
        }
    }

    private void appendSuperTypes(StringBuilder builder, Element<? extends ParserRuleContext> element) {
        List<GenericSuperType> supers = element.getOwnedElements(GenericSuperType.class);
        if (!supers.isEmpty())
            builder.append(" extends ");
        supers.forEach(sp -> {
            appendWithToken(builder, sp.getContext().getText(), sp);
            if (supers.indexOf(sp) != supers.size() - 1)
                builder.append(", ");
        });
    }

    private void appendWithToken(StringBuilder builder, String text, Element<?> token) {
        int start = builder.length() - 1;
        Trace trace = new Trace(currentFileName, currentLineNumber, start, start + text.length());
        trace.addToken(token);
        traces.add(trace);
        builder.append(text);
    }

    private void addTrace(String baseText, int baseIndex, String text, Element<?> token) {
        int start = baseIndex + baseText.indexOf(text);
        int end = start + text.length();
        Trace trace = new Trace(currentFileName, currentLineNumber, start, end);
        trace.addToken(token);
        traces.add(trace);
    }

    public boolean isPrimitive(String text) {
        return text.equals("String") || text.equals("Boolean") || text.equals("Integer") || text.equals("Real") || text.equals("BigInteger");
    }

    private String newLine() {
        currentLineNumber++;
        return System.getProperty("line.separator");
    }

    private String getJavaPath(Element<? extends ParserRuleContext> element, String separator, boolean includeItself) {
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
