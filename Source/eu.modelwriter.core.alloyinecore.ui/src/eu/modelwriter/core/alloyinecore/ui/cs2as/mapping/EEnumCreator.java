package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcoreFactory;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;

public class EEnumCreator extends AlloyInEcoreBaseVisitor<Object> {
  public static final EEnumCreator instance = new EEnumCreator();

  private static final EcoreFactory factory = EcoreFactory.eINSTANCE;

  private static final Map<String, EEnum> name2eEnum = new HashMap<>();

  private EEnumCreator() {}

  @Override
  public Object visitEEnum(final EEnumContext ctx) {
    final EEnum eEnum = EEnumCreator.factory.createEEnum();

    final String name = ctx.name.getText();
    eEnum.setName(name);

    EEnumCreator.getName2eenum().put(name, eEnum);
    return super.visitEEnum(ctx);
  }

  public static Map<String, EEnum> getName2eenum() {
    return name2eEnum;
  }
}
