package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.Stack;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAttributeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EStructuralFeatureContext;

public class StructuralFeatureInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final StructuralFeatureInitializer instance = new StructuralFeatureInitializer();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  @Override
  public Object visitEPackage(final EPackageContext ctx) {
    final String name = ctx.name.getText();
    StructuralFeatureInitializer.qualifiedNameStack.push(name);
    super.visitEPackage(ctx);
    StructuralFeatureInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEClass(final EClassContext ctx) {
    final String name = ctx.name.getText();
    StructuralFeatureInitializer.qualifiedNameStack.push(name);
    final EClass eClass =
        (EClass) CS2ASRepository.getEObject(StructuralFeatureInitializer.qualifiedNameStack);

    ctx.eStructuralFeatures.forEach(esf -> {
      final EStructuralFeature eStructuralFeature = visitEStructuralFeature(esf);
      eClass.getEStructuralFeatures().add(eStructuralFeature);
      // TODO is it required to add eStructuralFeature to eClass.getEReferences() or to
      // eClass.getEAttributes() ? Discuss.
    });
    super.visitEClass(ctx);

    StructuralFeatureInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEDataType(final EDataTypeContext ctx) {
    final String name = ctx.name.getText();
    StructuralFeatureInitializer.qualifiedNameStack.push(name);
    super.visitEDataType(ctx);
    StructuralFeatureInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEEnum(final EEnumContext ctx) {
    final String name = ctx.name.getText();
    StructuralFeatureInitializer.qualifiedNameStack.push(name);
    super.visitEEnum(ctx);
    StructuralFeatureInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public EStructuralFeature visitEStructuralFeature(final EStructuralFeatureContext ctx) {
    return (EStructuralFeature) super.visitEStructuralFeature(ctx);
  }

  @Override
  public EReference visitEReference(final EReferenceContext ctx) {
    final EReference eReference = CS2ASRepository.factory.createEReference();

    final String name = ctx.name.getText();
    eReference.setName(name);

    // StructuralFeatureInitializer.qualifiedNameStack.push(name);
    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEReference and need to has a (complex) qualified name
    // StructuralFeatureInitializer.qualifiedNameStack.pop();

    return eReference;
  }

  @Override
  public EAttribute visitEAttribute(final EAttributeContext ctx) {
    final EAttribute eAttribute = CS2ASRepository.factory.createEAttribute();

    final String name = ctx.name.getText();
    eAttribute.setName(name);

    // StructuralFeatureInitializer.qualifiedNameStack.push(name);
    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEAttribute and need to has a (complex) qualified name
    // StructuralFeatureInitializer.qualifiedNameStack.pop();

    return eAttribute;
  }

  public void clear() {
    StructuralFeatureInitializer.qualifiedNameStack.clear();
  }
}
