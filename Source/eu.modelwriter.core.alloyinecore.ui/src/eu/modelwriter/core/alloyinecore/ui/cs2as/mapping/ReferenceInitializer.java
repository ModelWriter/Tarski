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
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.QualifiedNameContext;
import eu.modelwriter.core.alloyinecore.ui.cs2as.ImportedModule;

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
    final String qualifiedName = String.join("::", ReferenceInitializer.qualifiedNameStack);

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
    final String qualifiedName = String.join("::", ReferenceInitializer.qualifiedNameStack);
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
    String moduleName = null;
    final String objectName;
    List<String> relativePathFragments = new ArrayList<>();

    if (ctx.lastPart != null) {
      moduleName = ctx.firstPart.getText();
      objectName = ctx.lastPart.getText();

      if (ctx.midParts != null) {
        relativePathFragments = new ArrayList<>(ctx.midParts.size() + 2);
        relativePathFragments.add(moduleName);
        for (int i = 0; i < ctx.midParts.size(); i++) {
          relativePathFragments.add(ctx.midParts.get(i).getText());
        }
        relativePathFragments.add(objectName);
      } else { // : importName::ObjectName ... ;
        relativePathFragments = new ArrayList<>(2);
        relativePathFragments.add(moduleName);
        relativePathFragments.add(objectName);
      }
    } else { // : ObjectName ... ;
      objectName = ctx.firstPart.getText();

      final String sibling = ReferenceInitializer.qualifiedNameStack.pop();
      ReferenceInitializer.qualifiedNameStack.push(objectName);
      relativePathFragments = new ArrayList<>(ReferenceInitializer.qualifiedNameStack.size());
      for (int i = 0; i < ReferenceInitializer.qualifiedNameStack.size(); i++) {
        relativePathFragments.add(ReferenceInitializer.qualifiedNameStack.get(i));
      }
      ReferenceInitializer.qualifiedNameStack.pop();
      ReferenceInitializer.qualifiedNameStack.push(sibling);
    }

    if (moduleName != null && CS2ASRepository.qname2importedModule.containsKey(moduleName)) {
      final ImportedModule importedModule = CS2ASRepository.qname2importedModule.get(moduleName);
      return importedModule.getElement(relativePathFragments);
    } else { // current module
      final String qualifiedName = String.join("::", relativePathFragments);
      if (CS2ASRepository.qname2eClass.containsKey(qualifiedName)) {
        return CS2ASRepository.qname2eClass.get(qualifiedName);
      } else if (CS2ASRepository.qname2eDataType.containsKey(qualifiedName)) {
        return CS2ASRepository.qname2eDataType.get(qualifiedName);
      } else if (CS2ASRepository.qname2eEnum.containsKey(qualifiedName)) {
        return CS2ASRepository.qname2eEnum.get(qualifiedName);
      } else if (CS2ASRepository.qname2eReference.containsKey(qualifiedName)) {
        return CS2ASRepository.qname2eReference.get(qualifiedName);
      }
    }
    /*
     * Returns eobject as default, if qualified name is not resolved.
     */
    return null;
  }

  public void clear() {
    ReferenceInitializer.qualifiedNameStack.clear();
  }
}
