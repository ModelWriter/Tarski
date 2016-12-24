package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;

public class ClassifierInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final ClassifierInitializer instance = new ClassifierInitializer();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  @Override
  public Object visitEPackage(final EPackageContext ctx) {
    final String name = ctx.name.getText();
    ClassifierInitializer.qualifiedNameStack.push(name);
    super.visitEPackage(ctx);
    ClassifierInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEClass(final EClassContext ctx) {
    final EClass eClass = CS2ASRepository.factory.createEClass();

    final String name = ctx.name.getText();
    eClass.setName(name);

    ClassifierInitializer.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", ClassifierInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eClass.put(qualifiedName, eClass);

    super.visitEClass(ctx);

    ClassifierInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEDataType(final EDataTypeContext ctx) {
    final EDataType eDataType = CS2ASRepository.factory.createEDataType();

    final String name = ctx.name.getText();
    eDataType.setName(name);

    ClassifierInitializer.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", ClassifierInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eDataType.put(qualifiedName, eDataType);

    super.visitEDataType(ctx);

    ClassifierInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEEnum(final EEnumContext ctx) {
    final EEnum eEnum = CS2ASRepository.factory.createEEnum();

    final String name = ctx.name.getText();
    eEnum.setName(name);

    ClassifierInitializer.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", ClassifierInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eEnum.put(qualifiedName, eEnum);

    super.visitEEnum(ctx);

    ClassifierInitializer.qualifiedNameStack.pop();
    return null;
  }

  public void clear() {
    ClassifierInitializer.qualifiedNameStack.clear();
  }
}
