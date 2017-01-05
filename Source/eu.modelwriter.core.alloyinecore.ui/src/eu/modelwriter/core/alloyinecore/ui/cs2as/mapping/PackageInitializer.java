package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.Stack;

import org.eclipse.emf.ecore.EPackage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.ui.cs2as.AIEConstants;
import eu.modelwriter.core.alloyinecore.ui.cs2as.Module;

public class PackageInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final PackageInitializer instance = new PackageInitializer();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  boolean isRoot = true;

  @Override
  public EPackage visitEPackage(final EPackageContext ctx) {
    final EPackage ePackage = CS2ASRepository.factory.createEPackage();

    final String name = ctx.name.getText();
    ePackage.setName(name);

    CS2ASRepository.root = isRoot ? ePackage : CS2ASRepository.root;

    if (isRoot) {
      CS2ASRepository.name2Module.put(name,
          new Module().setName(name).setPath(ctx.nsURI.getText()).setRoot(ePackage));
    }

    isRoot = false;

    PackageInitializer.qualifiedNameStack.push(name);
    final String qualifiedName =
        String.join(AIEConstants.SEPARATOR_PACKAGE, PackageInitializer.qualifiedNameStack);
    CS2ASRepository.qname2ePackage.put(qualifiedName, ePackage);

    ctx.eSubPackages.forEach(sp -> {
      final EPackage subPackage = visitEPackage(sp);
      ePackage.getESubpackages().add(subPackage);
    });

    PackageInitializer.qualifiedNameStack.pop();

    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEPackage and need to has a (complex) qualified name

    return ePackage;
  }

  public void clear() {
    PackageInitializer.qualifiedNameStack.clear();
    isRoot = true;
  }
}
