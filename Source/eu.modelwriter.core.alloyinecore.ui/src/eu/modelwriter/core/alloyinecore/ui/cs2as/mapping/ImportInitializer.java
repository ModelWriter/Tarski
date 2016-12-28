package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.io.IOException;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.ui.cs2as.Module;

public class ImportInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final ImportInitializer instance = new ImportInitializer();

  @Override
  public Object visitPackageImport(final PackageImportContext ctx) {
    final String path = ctx.ownedPathName.getText().replace("'", "");
    EObject root = loadResource(path);

    if (root == null) {
      if (path.equals(Module.Ecore)) {
        root = EcorePackage.eINSTANCE;
      } else {
        return null;
      }
    }

    final String name = ctx.name != null ? ctx.name.getText()
        : root instanceof ENamedElement ? ((ENamedElement) root).getName() : null;

        final Module module =
            Module.newInstance().setName(name).setPath(path).setRoot(root);
        CS2ASRepository.name2Module.put(name, module);
        return null;
  }

  /**
   * @param path
   * @return
   *
   */
  private EObject loadResource(final String path) {
    try {
      final EObject root = EcoreUtilities.getRootObject(path);
      return root;
    } catch (final IOException e) {
      return null;
    }
  }
}
