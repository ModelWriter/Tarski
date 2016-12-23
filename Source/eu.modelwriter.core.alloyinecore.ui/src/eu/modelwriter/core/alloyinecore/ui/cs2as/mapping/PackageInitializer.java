package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.Stack;

import org.eclipse.emf.ecore.EPackage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;

public class PackageInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final PackageInitializer instance = new PackageInitializer();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  boolean isRoot = true;

  @Override
  public Object visitEPackage(final EPackageContext ctx) {
    final EPackage ePackage = CS2ASRepository.factory.createEPackage();

    final String name = ctx.name.getText();
    ePackage.setName(name);

    CS2ASRepository.root = isRoot ? ePackage : CS2ASRepository.root;
    isRoot = false;

    PackageInitializer.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", PackageInitializer.qualifiedNameStack);
    CS2ASRepository.qname2ePackage.put(qualifiedName, ePackage);

    super.visitEPackage(ctx);

    PackageInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEClass(final EClassContext ctx) {
    final String name = ctx.name.getText();
    PackageInitializer.qualifiedNameStack.push(name);
    super.visitEClass(ctx);
    PackageInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEDataType(final EDataTypeContext ctx) {
    final String name = ctx.name.getText();
    PackageInitializer.qualifiedNameStack.push(name);
    super.visitEDataType(ctx);
    PackageInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEEnum(final EEnumContext ctx) {
    final String name = ctx.name.getText();
    PackageInitializer.qualifiedNameStack.push(name);
    super.visitEEnum(ctx);
    PackageInitializer.qualifiedNameStack.pop();
    return null;
  }
}
