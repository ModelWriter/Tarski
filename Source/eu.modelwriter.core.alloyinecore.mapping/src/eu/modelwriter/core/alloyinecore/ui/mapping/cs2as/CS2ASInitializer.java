package eu.modelwriter.core.alloyinecore.ui.mapping.cs2as;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAttributeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EStructuralFeatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.ui.mapping.Module;

public class CS2ASInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final CS2ASInitializer instance = new CS2ASInitializer();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  public void initialize(final ModuleContext ctx) {
    visit(ctx);
  }

  @Override
  public Object visitPackageImport(final PackageImportContext ctx) {
    String path = null;
    if (ctx.ownedPathName != null) {
      path = ctx.ownedPathName.getText().replace("'", "");
    }
    EObject root = loadResource(path);

    if (root == null) {
      if (path.equals(Module.Ecore)) {
        root = EcorePackage.eINSTANCE;
      } else {
        return null;
      }
    }

    final String name = ctx.name != null ? ctx.name.getText()
        : root instanceof ENamedElement ? ((ENamedElement) root).getName()
            : null;

        final Module module = Module.newInstance().setName(name).setPath(path).setRoot(root);
        CS2ASRepository.name2Module.put(name, module);
        return null;
  }

  boolean isRoot = true;
  int pc = 0;

  @Override
  public EPackage visitEPackage(final EPackageContext ctx) {
    final EPackage ePackage = CS2ASRepository.factory.createEPackage();

    String name = "package" + ++pc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    ePackage.setName(name);

    CS2ASRepository.root = isRoot ? ePackage : CS2ASRepository.root;

    if (isRoot) {
      CS2ASRepository.name2Module.put(name,
          new Module().setName(name).setPath(ctx.nsURI.getText()).setRoot(ePackage));
    }

    isRoot = false;

    CS2ASInitializer.qualifiedNameStack.push(name);

    ctx.eSubPackages.forEach(sp -> {
      final EPackage subPackage = visitEPackage(sp);
      ePackage.getESubpackages().add(subPackage);
    });

    ctx.eClassifiers.forEach(c -> {
      final EClassifier classifier = visitEClassifier(c);
      ePackage.getEClassifiers().add(classifier);
    });

    CS2ASInitializer.qualifiedNameStack.pop();

    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEPackage and need to has a (complex) qualified name

    return ePackage;
  }

  @Override
  public EClassifier visitEClassifier(final EClassifierContext ctx) {
    return (EClassifier) super.visitEClassifier(ctx);
  }

  int cc = 0;

  @Override
  public EClass visitEClass(final EClassContext ctx) {
    final EClass eClass = CS2ASRepository.factory.createEClass();

    String name = "class" + ++cc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    eClass.setName(name);

    CS2ASInitializer.qualifiedNameStack.push(name);

    if (ctx.ownedSignature != null) {
      final List<ETypeParameter> eTypeParameters = visitTemplateSignature(ctx.ownedSignature);
      eClass.getETypeParameters().addAll(eTypeParameters);
    }

    ctx.eStructuralFeatures.forEach(esf -> {
      final EStructuralFeature eStructuralFeature = visitEStructuralFeature(esf);
      eClass.getEStructuralFeatures().add(eStructuralFeature);
      // TODO is it required to add eStructuralFeature to eClass.getEReferences() or to
      // eClass.getEAttributes() ? Discuss.
    });

    ctx.eOperations.forEach(eo -> {
      final EOperation eOperation = visitEOperation(eo);
      eClass.getEOperations().add(eOperation);
    });

    CS2ASInitializer.qualifiedNameStack.pop();

    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEClass and need to has a (complex) qualified name

    return eClass;
  }

  int dtc = 0;

  @Override
  public EDataType visitEDataType(final EDataTypeContext ctx) {
    final EDataType eDataType = CS2ASRepository.factory.createEDataType();

    String name = "datatype" + ++dtc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    eDataType.setName(name);

    if (ctx.ownedSignature != null) {
      final List<ETypeParameter> eTypeParameters = visitTemplateSignature(ctx.ownedSignature);
      eDataType.getETypeParameters().addAll(eTypeParameters);
    }

    // CS2ASInitializer.qualifiedNameStack.push(name);
    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEDataType and need to has a (complex) qualified name
    // CS2ASInitializer.qualifiedNameStack.pop();

    return eDataType;
  }

  int ec = 0;
  @Override
  public EEnum visitEEnum(final EEnumContext ctx) {
    final EEnum eEnum = CS2ASRepository.factory.createEEnum();

    String name = "enum" + ++ec;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    eEnum.setName(name);

    if (ctx.ownedSignature != null) {
      final List<ETypeParameter> eTypeParameters = visitTemplateSignature(ctx.ownedSignature);
      eEnum.getETypeParameters().addAll(eTypeParameters);
    }

    // CS2ASInitializer.qualifiedNameStack.push(name);
    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEEnum and need to has a (complex) qualified name
    // CS2ASInitializer.qualifiedNameStack.pop();

    return eEnum;
  }

  @Override
  public EStructuralFeature visitEStructuralFeature(final EStructuralFeatureContext ctx) {
    return (EStructuralFeature) super.visitEStructuralFeature(ctx);
  }

  int rc = 0;
  @Override
  public EReference visitEReference(final EReferenceContext ctx) {
    final EReference eReference = CS2ASRepository.factory.createEReference();

    String name = "reference" + ++rc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    eReference.setName(name);

    // CS2ASInitializer.qualifiedNameStack.push(name);
    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEReference and need to has a (complex) qualified name
    // CS2ASInitializer.qualifiedNameStack.pop();

    return eReference;
  }

  int ac = 0;
  @Override
  public EAttribute visitEAttribute(final EAttributeContext ctx) {
    final EAttribute eAttribute = CS2ASRepository.factory.createEAttribute();

    String name = "attribute" + ++ac;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    eAttribute.setName(name);

    // CS2ASInitializer.qualifiedNameStack.push(name);
    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEAttribute and need to has a (complex) qualified name
    // CS2ASInitializer.qualifiedNameStack.pop();

    return eAttribute;
  }

  int oc = 0;
  @Override
  public EOperation visitEOperation(final EOperationContext ctx) {
    final EOperation eOperation = CS2ASRepository.factory.createEOperation();

    String name = "attribute" + ++ac;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    eOperation.setName(name);

    if (ctx.ownedSignature != null) {
      final List<ETypeParameter> eTypeParameters = visitTemplateSignature(ctx.ownedSignature);
      eOperation.getETypeParameters().addAll(eTypeParameters);
    }

    // CS2ASInitializer.qualifiedNameStack.push(name);
    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEOperation and need to has a (complex) qualified name
    // CS2ASInitializer.qualifiedNameStack.pop();

    return eOperation;
  }

  @Override
  public List<ETypeParameter> visitTemplateSignature(final TemplateSignatureContext ctx) {
    return ctx.ownedTypeParameters.stream().map(op -> visitETypeParameter(op))
        .collect(Collectors.toList());
  }

  int tpc = 0;
  @Override
  public ETypeParameter visitETypeParameter(final ETypeParameterContext ctx) {
    final ETypeParameter eTypeParameter = CS2ASRepository.factory.createETypeParameter();

    String name = "typeparameter" + ++tpc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    eTypeParameter.setName(name);

    return eTypeParameter;
  }

  /**
   * @param path
   * @return
   *
   */
  private EObject loadResource(final String path) {
    try {
      final EObject root = EcoreUtilities.getRootObject(path);
      return root;
    } catch (final IOException e) {
      return null;
    }
  }

  public void clearInitializer() {
    pc = 0;
    cc = 0;
    ac = 0;
    rc = 0;
    oc = 0;
    dtc = 0;
    ec = 0;
    tpc = 0;
    CS2ASInitializer.qualifiedNameStack.clear();
    isRoot = true;
  }
}
