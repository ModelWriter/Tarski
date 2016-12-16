package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;

public class EPackageCreator extends AlloyInEcoreBaseVisitor<Object> {
  public static final EPackageCreator instance = new EPackageCreator();

  private static final EcoreFactory factory = EcoreFactory.eINSTANCE;

  private static final Map<String, EPackage> name2ePackage = new HashMap<>();

  private EPackageCreator() {}

  @Override
  public Object visitEPackage(final EPackageContext ctx) {
    final EPackage ePackage = EPackageCreator.factory.createEPackage();
    ePackage.setEFactoryInstance(EPackageCreator.factory);

    final String name = ctx.name.getText();
    ePackage.setName(name);

    EPackageCreator.getName2epackage().put(name, ePackage);
    // Code2Ecore.saveResource(ePackage, "/home/emrekirmizi/Desktop/" + name + ".ecore");
    return super.visitEPackage(ctx);
  }

  public static Map<String, EPackage> getName2epackage() {
    return EPackageCreator.name2ePackage;
  }
}
