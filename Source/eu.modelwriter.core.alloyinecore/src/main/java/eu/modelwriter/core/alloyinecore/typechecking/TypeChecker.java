package eu.modelwriter.core.alloyinecore.typechecking;

import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TypeChecker {

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
        generator = new JavaInterfaceGenerator(outDir, true);
    }

    public void check(Model model) {
        ClassVisitor classVisitor = new ClassVisitor(generator);
        classVisitor.visit(model);
        Set<JavaSourceFromString> generatedJavaFiles = generator.getGeneratedFiles();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        List<String> options = Arrays.asList("-d", outDir); // -d: output dir
        compiler.getTask(null, fileManager, diagnostics, options, null, generatedJavaFiles).call();
        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics())
            System.err.format("%s %nMapped to: %s %n%n", diagnostic.toString(), generator.getTokensAsString(diagnostic));

        try {
            // Try to close fileManager
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClassVisitor extends BaseVisitorImpl {
        JavaInterfaceGenerator generator;

        ClassVisitor(JavaInterfaceGenerator generator) {
            this.generator = generator;
        }

        @Override
        public Object visitClass(Class _class) {
            // TODO: Handle classes in annotations?
            if (_class.getOwner() instanceof Package) {
                JavaSourceFromString javaSource = generator.generate(_class);
                System.out.println(javaSource.code + "\n\n");
            }
            return null;
        }
    }
}
