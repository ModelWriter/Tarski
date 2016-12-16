package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcoreFactory;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;

public class EDataTypeCreator extends AlloyInEcoreBaseVisitor<Object> {
  public static final EDataTypeCreator instance = new EDataTypeCreator();

  private static final EcoreFactory factory = EcoreFactory.eINSTANCE;

  private static final Map<String, EDataType> name2eDataType = new HashMap<>();

  private EDataTypeCreator() {}

  @Override
  public Object visitEDataType(final EDataTypeContext ctx) {
    final EDataType eDataType = EDataTypeCreator.factory.createEDataType();

    final String name = ctx.name.getText();
    eDataType.setName(name);

    EDataTypeCreator.getName2edatatype().put(name, eDataType);
    return super.visitEDataType(ctx);
  }

  public static Map<String, EDataType> getName2edatatype() {
    return name2eDataType;
  };
}
