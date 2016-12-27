package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPrimitiveTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.QualifiedNameContext;
import eu.modelwriter.core.alloyinecore.ui.cs2as.AIEConstants;
import eu.modelwriter.core.alloyinecore.ui.cs2as.Module;

public class ReferenceInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final ReferenceInitializer instance = new ReferenceInitializer();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  @Override
  public Object visitEPackage(final EPackageContext ctx) {
    final String name = ctx.name.getText();
    ReferenceInitializer.qualifiedNameStack.push(name);
    super.visitEPackage(ctx);
    ReferenceInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEClass(final EClassContext ctx) {
    final String name = ctx.name.getText();
    ReferenceInitializer.qualifiedNameStack.push(name);
    final String qualifiedName =
        String.join(AIEConstants.SEPARATOR_CLASSIFIER, ReferenceInitializer.qualifiedNameStack);

    final EClass eClass = CS2ASRepository.qname2eClass.get(qualifiedName);
    ctx.eStructuralFeatures.forEach(esf -> {
      final EStructuralFeature eStructuralFeature =
          (EStructuralFeature) visitEStructuralFeature(esf);
      if (eStructuralFeature != null) {
        eClass.getEStructuralFeatures().add(eStructuralFeature);
      }
    });
    super.visitEClass(ctx);
    ReferenceInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEDataType(final EDataTypeContext ctx) {
    final String name = ctx.name.getText();
    ReferenceInitializer.qualifiedNameStack.push(name);
    super.visitEDataType(ctx);
    ReferenceInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEEnum(final EEnumContext ctx) {
    final String name = ctx.name.getText();
    ReferenceInitializer.qualifiedNameStack.push(name);
    super.visitEEnum(ctx);
    ReferenceInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public EReference visitEReference(final EReferenceContext ctx) {
    final EReference eReference = CS2ASRepository.factory.createEReference();

    final String name = ctx.name.getText();
    eReference.setName(name);

    ReferenceInitializer.qualifiedNameStack.push(name);
    final String qualifiedName =
        String.join(AIEConstants.SEPARATOR_FEATURE, ReferenceInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eReference.put(qualifiedName, eReference);
    ReferenceInitializer.qualifiedNameStack.pop();

    if (ctx.eReferenceType != null) {
      final EClassifier eType = visitEType(ctx.eReferenceType);
      eReference.setEType(eType);
    }

    return eReference;
  }

  @Override
  public EClassifier visitEType(final ETypeContext ctx) {
    return (EClassifier) super.visitEType(ctx);
  }

  @Override
  public EDataType visitEPrimitiveType(final EPrimitiveTypeContext ctx) {
    switch (ctx.getText()) {
      case "Boolean": // EBoolean
        return EcorePackage.eINSTANCE.getEBoolean();
      case "Integer": // EBigInteger
        return EcorePackage.eINSTANCE.getEInt();
      case "String": // EString
        return EcorePackage.eINSTANCE.getEString();
      case "Real": // EBigDecimal
        return EcorePackage.eINSTANCE.getEBigDecimal();
      case "UnlimitedNatural": // EBigInteger
        return EcorePackage.eINSTANCE.getEBigInteger();
      default:
        return null;
    }
  }

  @Override
  public EObject visitQualifiedName(final QualifiedNameContext ctx) {
    final String moduleName = ctx.firstPart.getText();
    String objectName = null;
    final List<String> relativePathFragments = new ArrayList<>();

    if (ctx.midParts != null) {
      for (final IdentifierContext ic : ctx.midParts) {
        relativePathFragments.add(ic.getText());
      }
      if (ctx.classifier != null) {
        // we have : RootName.Some.Sub.Names.classifier || SiblingName.Some.Sub.Names.classifier
        objectName = ctx.classifier.getText();
      } else if (ctx.structuralFeature != null) {
        // we have : RootName.Some.Sub.Names.featureName || SiblingName.Some.Sub.Names.featureName
        objectName = ctx.structuralFeature.getText();
      } else if (ctx.operation != null) {
        // we have : RootName.Some.Sub.Names.operationName ||
        // SiblingName.Some.Sub.Names.operationName
        objectName = ctx.operation.getText();
      }
    } else {
      if (ctx.classifier != null) {
        // we have : RootName.classifier || SiblingName.classifier
        objectName = ctx.classifier.getText();
      } else if (ctx.structuralFeature != null) {
        // we have just : RootName.featureName || SiblingName.featureName
        // objectName = ctx.structuralFeature.getText();
        return null; // TODO relative path is not supported.
      } else if (ctx.operation != null) {
        // we have just : RootName.operationName || SiblingName.operationName
        // objectName = ctx.operation.getText();
        return null; // TODO relative path is not supported.
      } else {
        // we have : SiblingName or : RootName
        // objectName = ctx.firstPart.getText();
        return null; // TODO relative path is not supported.
      }
    }
    relativePathFragments.add(objectName);

    if (CS2ASRepository.name2Module.containsKey(moduleName)) {
      final Module module = CS2ASRepository.name2Module.get(moduleName);
      return module.getElement(relativePathFragments);
    } else {
      return null;
    }
  }

  public void clear() {
    ReferenceInitializer.qualifiedNameStack.clear();
  }
}
