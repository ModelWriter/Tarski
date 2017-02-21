package eu.modelwriter.core.alloyinecore.typechecking;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Interface;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TypeChecker {

    private Set<TypeErrorListener> errorListeners;
    private JavaInterfaceGenerator generator;
    private String outDir;

    public TypeChecker() {
        outDir = new File(".").getAbsolutePath() + File.separator + "target" + File.separator + "aie-typechecking";
        try {
            Files.createDirectories(Paths.get(outDir));
        } catch (IOException e) {
            outDir = "";
            e.printStackTrace();
        }
        errorListeners = new HashSet<>();
        generator = new JavaInterfaceGenerator(outDir, true);
    }

    public void addErrorListener(TypeErrorListener listener) {
        errorListeners.add(listener);
    }

    public void removeErrorListener(TypeErrorListener listener) {
        errorListeners.remove(listener);
    }

    public void check(Model model) {
        ClassVisitor classVisitor = new ClassVisitor();
        classVisitor.visit(model);
        Set<JavaSourceFromString> generatedJavaFiles = generator.getGeneratedFiles();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        List<String> options = Arrays.asList("-d", outDir); // -d: output dir
        compiler.getTask(null, fileManager, diagnostics, options, null, generatedJavaFiles).call();
        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
            Set<Element<?>> elements = generator.findTokens(diagnostic);
            for (TypeErrorListener listener : errorListeners) {
                String message = diagnostic.getMessage(Locale.getDefault());
                message += System.getProperty("line.separator") + "(" + diagnostic.getCode() + ")";
                if (diagnostic.getKind() == Diagnostic.Kind.ERROR)
                    listener.onTypeError(message, elements);
                else if (diagnostic.getKind() == Diagnostic.Kind.WARNING || diagnostic.getKind() == Diagnostic.Kind.MANDATORY_WARNING)
                    listener.onTypeWarning(message, elements);
            }
            System.err.format("%s %nMapped to: %s %n%n", diagnostic.toString(), generator.getTokensAsString(diagnostic));
        }
        try {
            // Try to close fileManager
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClassVisitor extends BaseVisitorImpl {

        @Override
        public Object visitClass(Class _class) {
            if (_class.getOwner() instanceof Package) {
                JavaSourceFromString javaSource = generator.generate(_class);
                System.out.println(javaSource.code + "\n\n");
            }
            return null;
        }

        @Override
        public Object visitInterface(Interface _interface) {
            if (_interface.getOwner() instanceof Package) {
                JavaSourceFromString javaSource = generator.generate(_interface);
                System.out.println(javaSource.code + "\n\n");
            }
            return null;
        }
    }
}
