package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;

public class EClassCreator extends AlloyInEcoreBaseVisitor<Object> {
  public static final EClassCreator instance = new EClassCreator();

  private static final EcoreFactory factory = EcoreFactory.eINSTANCE;

  private static final Map<String, EClass> name2eClass = new HashMap<>();

  private EClassCreator() {}

  @Override
  public Object visitEClass(final EClassContext ctx) {
    final EClass eClass = EClassCreator.factory.createEClass();

    final String name = ctx.name.getText();
    eClass.setName(name);

    EClassCreator.getName2eclass().put(name, eClass);
    return super.visitEClass(ctx);
  }

  public static Map<String, EClass> getName2eclass() {
    return EClassCreator.name2eClass;
  }
}
