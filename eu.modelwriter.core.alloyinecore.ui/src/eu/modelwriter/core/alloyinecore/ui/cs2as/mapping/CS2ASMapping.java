package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAttributeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumLiteralContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EStructuralFeatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.QualifiedNameContext;

enum Qualification {
  SERIALIZABLE,
  VISIBILITY,
  STATIC,
  DERIVED,
  ORDERED,
  UNIQUE,
  ID,
  READONLY,
  TRANSIENT,
  UNSETTABLE,
  VOLATILE,
  COMPOSES,
  RESOLVE,
  PRIMITIVE;
  @Override
  public String toString() {
    return super.toString().toLowerCase();
  }
}

public class CS2ASMapping extends AlloyInEcoreBaseVisitor<Object> {
  public static void main(final String[] args) {
    ANTLRInputStream input = null;
    final File file = new File(
        "/home/emrekirmizi/Documents/projects/git/WP3/Source/eu.modelwriter.core.alloyinecore/src/programs/tutorial.recore");
    try {
      input = new ANTLRFileStream(file.getAbsolutePath());
    } catch (final IOException e) {
      e.printStackTrace();
    }
    // final ANTLRInputStream input = new ANTLRInputStream(str);
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
    final ParseTree tree = parser.module();

    /** ----------Loader for Data Structure------------------------------- **/
    final CS2ASMapping code2Ecore = CS2ASMapping.getInstance();
    code2Ecore.visit(tree);
  }

  private static final CS2ASMapping instance = new CS2ASMapping();

  private static final EcoreFactory factory = EcoreFactory.eINSTANCE;

  private static final Map<String, String> name2packageImport = new HashMap<>();
  private static Map<String, EPackage> name2ePackage = new HashMap<>();
  private static Map<String, EClass> name2eClass = new HashMap<>();
  private static Map<String, EDataType> name2eDataType = new HashMap<>();
  private static Map<String, EEnum> name2eEnum = new HashMap<>();
  private static final Map<String, EEnumLiteral> name2eEnumLiteral = new HashMap<>();

  private CS2ASMapping() {}

  public static CS2ASMapping getInstance() {
    CS2ASMapping.name2packageImport.clear();
    CS2ASMapping.name2ePackage.clear();
    CS2ASMapping.name2eClass.clear();
    CS2ASMapping.name2eDataType.clear();
    CS2ASMapping.name2eEnum.clear();
    CS2ASMapping.name2eEnumLiteral.clear();
    return CS2ASMapping.instance;
  }

  @Override
  public Object visitModule(final ModuleContext ctx) {
    EPackageCreator.instance.visit(ctx);
    CS2ASMapping.name2ePackage = EPackageCreator.getName2epackage();

    EClassCreator.instance.visit(ctx);
    CS2ASMapping.name2eClass = EClassCreator.getName2eclass();

    EDataTypeCreator.instance.visit(ctx);
    CS2ASMapping.name2eDataType = EDataTypeCreator.getName2edatatype();

    EEnumCreator.instance.visit(ctx);
    CS2ASMapping.name2eEnum = EEnumCreator.getName2eenum();

    ctx.ownedPackageImport.forEach(opi -> {
      visitPackageImport(opi);
    });

    ctx.ownedPackage.forEach(op -> {
      visitEPackage(op);
    });

    CS2ASMapping.saveResource(CS2ASMapping.name2ePackage.get("tutorial"),
        "/home/emrekirmizi/Desktop/tutorial.ecore");

    return null;
  }

  @Override
  public Object visitPackageImport(final PackageImportContext ctx) {
    final String name = ctx.name.getText();
    final String pathName = ctx.ownedPathName.getText();

    CS2ASMapping.name2packageImport.put(name, pathName);
    return null;
  }

  @Override
  public EPackage visitEPackage(final EPackageContext ctx) {
    return createEPackage(ctx);
  }

  /**
   * @param ctx
   * @return
   */
  private EPackage createEPackage(final EPackageContext ctx) {
    // final EPackage ePackage = Code2Ecore.factory.createEPackage();
    final EPackage ePackage = CS2ASMapping.name2ePackage.get(ctx.name.getText());
    ePackage.setEFactoryInstance(CS2ASMapping.factory);

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          visitQualifier(Qualification.VISIBILITY.toString(), ctx.visibility.getText());
      ePackage.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final String name = ctx.name.getText();
    ePackage.setName(name);

    final String nsPrefix = ctx.nsPrefix.getText();
    ePackage.setNsPrefix(nsPrefix);

    final String nsURI = ctx.nsURI.getText();
    ePackage.setNsURI(nsURI);

    ctx.eSubPackages.forEach(esp -> {
      final EPackage subPackage = visitEPackage(esp);
      ePackage.getESubpackages().add(subPackage);
    });

    ctx.eClassifiers.forEach(ec -> {
      final EClassifier eClassifier = visitEClassifier(ec);
      ePackage.getEClassifiers().add(eClassifier);
    });

    CS2ASMapping.name2ePackage.put(name, ePackage);
    return ePackage;
  }

  @Override
  public EClassifier visitEClassifier(final EClassifierContext ctx) {
    if (ctx.eClass() != null) {
      return visitEClass(ctx.eClass());
    } else if (ctx.eDataType() != null) {
      return visitEDataType(ctx.eDataType());
    } else if (ctx.eEnum() != null) {
      return visitEEnum(ctx.eEnum());
    }
    return null;
  }

  @Override
  public EClass visitEClass(final EClassContext ctx) {
    return createEClass(ctx);
  }

  /**
   * @param ctx
   * @return
   */
  private EClass createEClass(final EClassContext ctx) {
    // final EClass eClass = Code2Ecore.factory.createEClass();
    final EClass eClass = CS2ASMapping.name2eClass.get(ctx.name.getText());

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          visitQualifier(Qualification.VISIBILITY.toString(), ctx.visibility.getText());
      eClass.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final boolean isAbstract = ctx.isAbstract != null ? true : false;
    // DEFAULT FALSE
    eClass.setAbstract(isAbstract);

    final String name = ctx.name.getText();
    eClass.setName(name);

    ctx.eSuperTypes.forEach(est -> {
      final String superTypeName = est.getText();
      final EClass superType = CS2ASMapping.name2eClass.get(superTypeName);
      if (superType != null) {
        eClass.getESuperTypes().add(superType);
      }
    });

    if (ctx.instanceClassName != null) {
      final String instanceClassName = ctx.instanceClassName.getText();
      eClass.setInstanceClassName(instanceClassName);
    }

    final boolean isInterface = ctx.isInterface != null ? true : false;
    // DEFAULT FALSE
    eClass.setInterface(isInterface);

    ctx.eOperations.forEach(eo -> {
      final EOperation eOperation = visitEOperation(eo);
      eClass.getEOperations().add(eOperation);
    });

    ctx.eStructuralFeatures.forEach(esf -> {
      final EStructuralFeature eStructuralFeature = visitEStructuralFeature(esf);
      eClass.getEStructuralFeatures().add(eStructuralFeature);
    });

    // TODO ECONSTRAINTS

    CS2ASMapping.name2eClass.put(name, eClass);
    return eClass;
  }

  @Override
  public EOperation visitEOperation(final EOperationContext ctx) {
    return createEOperation(ctx);
  }

  /**
   * @param ctx
   * @return
   */
  private EOperation createEOperation(final EOperationContext ctx) {
    final EOperation eOperation = CS2ASMapping.factory.createEOperation();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          visitQualifier(Qualification.VISIBILITY.toString(), ctx.visibility.getText());
      eOperation.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final Boolean isStatic =
        ctx.qualifier.stream().anyMatch(q -> q.getText()
            .equals(Qualification.STATIC.toString()));
    final EAnnotation staticAnnotation =
        visitQualifier(Qualification.STATIC.toString(), isStatic.toString());
    // DEFAULT FALSE
    eOperation.getEAnnotations().add(staticAnnotation);

    final String name = ctx.name.getText();
    eOperation.setName(name);

    ctx.eParameters.forEach(ep -> {
      final EParameter eParameter = visitEParameter(ep);
      eOperation.getEParameters().add(eParameter);
    });

    final EClassifier returnType = visitEType(ctx.returnType);
    eOperation.setEType(returnType);

    final int[] multiplicity = visitEMultiplicity(ctx.multiplicity);
    eOperation.setLowerBound(multiplicity[0]);
    eOperation.setUpperBound(multiplicity[1]);

    // TODO OWNED EXCEPTION (NOT IMPLEMENTED ON BNF)

    final Boolean isDerived =
        ctx.qualifier.stream().anyMatch(q -> q.getText()
            .equals(Qualification.DERIVED.toString()));
    final EAnnotation derivedAnnotation =
        visitQualifier(Qualification.DERIVED.toString(), isDerived.toString());
    // DEFAULT FALSE
    eOperation.getEAnnotations().add(derivedAnnotation);

    final boolean isOrdered =
        ctx.qualifier.stream().anyMatch(q -> q.getText()
            .equals(Qualification.ORDERED.toString()));
    // DEFAULT FALSE
    eOperation.setOrdered(isOrdered);

    final boolean isUnique = !ctx.qualifier.stream()
        .anyMatch(q -> q.getText()
            .equals("!" + Qualification.UNIQUE.toString()));
    // DEFAULT TRUE
    eOperation.setUnique(isUnique);

    // TODO OWNED PRECONDITION (NOT IMPLEMENTED ON BNF)

    // TODO OWNED BODYEXPRESSION (NOT IMPLEMENTED ON BNF)

    // TODO OWNED POSTCONDITION (NOT IMPLEMENTED ON BNF)

    return eOperation;
  }

  @Override
  public EParameter visitEParameter(final EParameterContext ctx) {
    return createEParameter(ctx);
  }

  /**
   * @param ctx
   * @return
   */
  private EParameter createEParameter(final EParameterContext ctx) {
    final EParameter eParameter = CS2ASMapping.factory.createEParameter();

    final String name = ctx.name.getText();
    eParameter.setName(name);

    if (ctx.ownedType != null) {
      final EClassifier eType = visitEType(ctx.ownedType);
      eParameter.setEType(eType);
    } // DEFAULT NULL

    if (ctx.ownedMultiplicity != null) {
      final int[] multiplicity = visitEMultiplicity(ctx.ownedMultiplicity);
      eParameter.setLowerBound(multiplicity[0]);
      eParameter.setUpperBound(multiplicity[1]);
    } else { // DEFAULT 1
      eParameter.setLowerBound(1);
      eParameter.setUpperBound(1);
    }

    final Boolean isOrdered =
        ctx.qualifier.stream().anyMatch(q -> q.getText()
            .equals(Qualification.ORDERED.toString()));
    // DEFAULT FALSE
    eParameter.setOrdered(isOrdered);

    final Boolean isUnique = !ctx.qualifier.stream()
        .anyMatch(q -> q.getText()
            .equals("!" + Qualification.UNIQUE.toString()));
    // DEFAULT TRUE
    eParameter.setUnique(isUnique);

    return eParameter;
  }

  @Override
  public EStructuralFeature visitEStructuralFeature(final EStructuralFeatureContext ctx) {
    if (ctx.eAttribute() != null) {
      return visitEAttribute(ctx.eAttribute());
    } else if (ctx.eReference() != null) {
      return visitEReference(ctx.eReference());
    }
    return null;
  }

  @Override
  public EAttribute visitEAttribute(final EAttributeContext ctx) {
    return createEAttribute(ctx);
  }

  /**
   * @param ctx
   * @return
   */
  private EAttribute createEAttribute(final EAttributeContext ctx) {
    final EAttribute eAttribute = CS2ASMapping.factory.createEAttribute();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          visitQualifier(Qualification.VISIBILITY.toString(), ctx.visibility.getText());
      eAttribute.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final Boolean isStatic =
        ctx.qualifier.stream().anyMatch(q -> q.getText()
            .equals(Qualification.STATIC.toString()));
    final EAnnotation staticAnnotation =
        visitQualifier(Qualification.STATIC.toString(), isStatic.toString());
    // DEFAULT FALSE
    eAttribute.getEAnnotations().add(staticAnnotation);

    final String name = ctx.name.getText();
    eAttribute.setName(name);

    if (ctx.defaultValue != null) {
      final String defaultValue = ctx.defaultValue.getText();
      eAttribute.setDefaultValue(defaultValue);
    } // DEFAULT NULL

    if (ctx.eAttributeType != null) {
      final EClassifier eType = visitEType(ctx.eAttributeType);
      eAttribute.setEType(eType);
    } // DEFAULT NULL

    if (ctx.multiplicity != null) {
      final int[] multiplicity = visitEMultiplicity(ctx.multiplicity);
      eAttribute.setLowerBound(multiplicity[0]);
      eAttribute.setUpperBound(multiplicity[1]);
    } else { // DEFAULT 1
      eAttribute.setLowerBound(1);
      eAttribute.setUpperBound(1);
    }

    final boolean isDerived =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.DERIVED.toString()));
    // DEFAULT FALSE
    eAttribute.setDerived(isDerived);

    final boolean isId =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.ID.toString()));
    // DEFAULT FALSE
    eAttribute.setID(isId);

    final boolean isOrdered =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.ORDERED.toString()));
    // DEFAULT FALSE
    eAttribute.setOrdered(isOrdered);

    final Boolean isReadonly =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.READONLY.toString()));
    final EAnnotation readonlyAnnotation =
        visitQualifier(Qualification.READONLY.toString(), isReadonly.toString());
    // DEFAULT FALSE
    eAttribute.getEAnnotations().add(readonlyAnnotation);

    final boolean isTransient = ctx.qualifier.stream()
        .anyMatch(p -> p.getText()
            .equals(Qualification.TRANSIENT.toString()));
    // DEFAULT FALSE
    eAttribute.setTransient(isTransient);

    final boolean isUnique = !ctx.qualifier.stream()
        .anyMatch(p -> p.getText()
            .equals("!" + Qualification.UNIQUE.toString()));
    // DEFAULT TRUE
    eAttribute.setUnique(isUnique);

    final boolean isUnsettable = ctx.qualifier.stream()
        .anyMatch(p -> p.getText()
            .equals(Qualification.UNSETTABLE.toString()));
    // DEFAULT FALSE
    eAttribute.setUnsettable(isUnsettable);

    final boolean isVolatile =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.VOLATILE.toString()));
    // DEFAULT FALSE
    eAttribute.setVolatile(isVolatile);

    // TODO INITIAL EXPRESSION

    // TODO DERIVATION EXPRESSION

    return eAttribute;
  }

  @Override
  public EReference visitEReference(final EReferenceContext ctx) {
    return createEReference(ctx);
  }

  /**
   * @param ctx
   * @return
   */
  private EReference createEReference(final EReferenceContext ctx) {
    final EReference eReference = CS2ASMapping.factory.createEReference();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          visitQualifier(Qualification.VISIBILITY.toString(), ctx.visibility.getText());
      eReference.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final Boolean isStatic =
        ctx.qualifier.stream().anyMatch(q -> q.getText()
            .equals(Qualification.STATIC.toString()));
    final EAnnotation staticAnnotation =
        visitQualifier(Qualification.STATIC.toString(), isStatic.toString());
    // DEFAULT FALSE
    eReference.getEAnnotations().add(staticAnnotation);

    final String name = ctx.name.getText();
    eReference.setName(name);

    final EClassifier eType = visitEType(ctx.eReferenceType);
    eReference.setEType(eType);

    if (ctx.opposite != null) {
      final String oppositeName = ctx.opposite.getText();
      final EClass oppositeType = (EClass) eType;
      final EReference eOpposite = oppositeType.getEReferences().stream()
          .filter(er -> er.getName().equals(oppositeName)).findFirst().orElse(null);
      eReference.setEOpposite(eOpposite);
    } // DEFAULT NULL

    if (ctx.multiplicity != null) {
      final int[] multiplicity = visitEMultiplicity(ctx.multiplicity);
      eReference.setLowerBound(multiplicity[0]);
      eReference.setUpperBound(multiplicity[1]);
    } else { // DEFAULT 1
      eReference.setLowerBound(1);
      eReference.setUpperBound(1);
    }

    final Boolean isComposes =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.COMPOSES.toString()));
    final EAnnotation composesAnnotation =
        visitQualifier(Qualification.COMPOSES.toString(), isComposes.toString());
    // DEFAULT FALSE
    eReference.getEAnnotations().add(composesAnnotation);

    final boolean isDerived =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.DERIVED.toString()));
    // DEFAULT FALSE
    eReference.setDerived(isDerived);

    final boolean isOrdered =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.ORDERED.toString()));
    // DEFAULT FALSE
    eReference.setOrdered(isOrdered);

    final Boolean isReadonly =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.READONLY.toString()));
    final EAnnotation readonlyAnnotation =
        visitQualifier(Qualification.READONLY.toString(), isReadonly.toString());
    // DEFAULT FALSE
    eReference.getEAnnotations().add(readonlyAnnotation);

    final boolean isResolve =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.RESOLVE.toString()));
    // DEFAULT FALSE
    eReference.setResolveProxies(isResolve);

    final boolean isTransient = ctx.qualifier.stream()
        .anyMatch(p -> p.getText()
            .equals(Qualification.TRANSIENT.toString()));
    // DEFAULT FALSE
    eReference.setTransient(isTransient);

    final boolean isUnique = !ctx.qualifier.stream()
        .anyMatch(p -> p.getText()
            .equals("!" + Qualification.UNIQUE.toString()));
    // DEFAULT TRUE
    eReference.setUnique(isUnique);

    final boolean isUnsettable = ctx.qualifier.stream()
        .anyMatch(p -> p.getText()
            .equals(Qualification.UNSETTABLE.toString()));
    // DEFAULT FALSE
    eReference.setUnsettable(isUnsettable);

    final boolean isVolatile =
        ctx.qualifier.stream().anyMatch(p -> p.getText()
            .equals(Qualification.VOLATILE.toString()));
    // DEFAULT FALSE
    eReference.setVolatile(isVolatile);

    // TODO REFERRED KEYS ?

    // TODO INITIAL EXPRESSION

    // TODO DERIVATION EXPRESSION

    return eReference;
  }

  @Override
  public int[] visitEMultiplicity(final EMultiplicityContext ctx) {
    int lower = 0;
    int upper = 1;
    if (ctx.stringBounds != null) {
      final String stringBound = ctx.stringBounds.getText();
      switch (stringBound) {
        case "*":
          lower = 0;
          upper = -1;
          break;
        case "+":
          lower = 1;
          upper = -1;
        case "?":
          lower = 0;
          upper = 1;
        default:
          break;
      }
    } else {
      lower = Integer.valueOf(ctx.lowerBound.getText());
      if (ctx.upperBound != null) {
        upper = Integer.valueOf(ctx.upperBound.getText());
      } else {
        upper = lower;
      }
    }
    return new int[] {lower, upper};
  }

  @Override
  public EClassifier visitEType(final ETypeContext ctx) {
    if (ctx.ePrimitiveType() != null) {
      switch (ctx.ePrimitiveType().getText()) {
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
          break;
      }
    } else if (ctx.qualifiedName() != null) {
      final String classifierName = visitQualifiedName(ctx.qualifiedName());
      if (CS2ASMapping.name2eClass.containsKey(classifierName)) {
        return CS2ASMapping.name2eClass.get(classifierName);
      } else if (CS2ASMapping.name2eDataType.containsKey(classifierName)) {
        return CS2ASMapping.name2eDataType.get(classifierName);
      } else if (CS2ASMapping.name2eEnum.containsKey(classifierName)) {
        return CS2ASMapping.name2eEnum.get(classifierName);
      }
    }
    return null;
  }

  @Override
  public String visitQualifiedName(final QualifiedNameContext ctx) {
    if (ctx.lastPart != null) {
      return ctx.lastPart.getText();
    } else if (ctx.midPart != null && ctx.midPart.size() != 0) {
      return ctx.midPart.get(ctx.midPart.size() - 1).getText();
    } else {
      return ctx.firstPart.get(ctx.firstPart.size() - 1).getText();
    }
  }

  @Override
  public EDataType visitEDataType(final EDataTypeContext ctx) {
    return createEDataType(ctx);
  }

  /**
   * @param ctx
   * @return
   */
  private EDataType createEDataType(final EDataTypeContext ctx) {
    // final EDataType eDataType = Code2Ecore.factory.createEDataType();
    final EDataType eDataType = CS2ASMapping.name2eDataType.get(ctx.name.getText());

    final Boolean isPrimitive = ctx.isPrimitive != null ? true : false;
    final EAnnotation primitiveAnnotation =
        visitQualifier(Qualification.PRIMITIVE.toString(), isPrimitive.toString());
    // DEFAULT FALSE
    eDataType.getEAnnotations().add(primitiveAnnotation);

    final String name = ctx.name.getText();
    eDataType.setName(name);

    // TODO OWNED SIGNATURE = TEMPLATE SIGNATURE

    if (ctx.instanceClassName != null) {
      final String instanceClassName = ctx.instanceClassName.getText();
      eDataType.setInstanceClassName(instanceClassName);
    }

    final boolean isSerializable = ctx.isSerializable != null
        && ctx.isSerializable.equals(Qualification.SERIALIZABLE.toString()) ? true : false;
    // TODO DEFAULT FALSE, ANCAK ECORE DA TRUE, TARTIS!.
    eDataType.setSerializable(isSerializable);

    // OWNED CONSTRAINTS = INVARIANT CONSTRAINT*

    CS2ASMapping.name2eDataType.put(name, eDataType);
    return eDataType;
  }

  @Override
  public EEnum visitEEnum(final EEnumContext ctx) {
    return createEEnum(ctx);
  }

  /**
   * @param ctx
   * @return
   */
  private EEnum createEEnum(final EEnumContext ctx) {
    // final EEnum eEnum = Code2Ecore.factory.createEEnum();
    final EEnum eEnum = CS2ASMapping.name2eEnum.get(ctx.name.getText());

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          visitQualifier(Qualification.VISIBILITY.toString(), ctx.visibility.getText());
      eEnum.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final String name = ctx.name.getText();
    eEnum.setName(name);

    // OWNED SIGNATURE = TEMPLATE SIGNATURE

    if (ctx.instanceClassName != null) {
      final String instanceClassName = ctx.instanceClassName.getText();
      eEnum.setInstanceClassName(instanceClassName);
    }

    final boolean isSerializable = ctx.isSerializable != null
        && ctx.isSerializable.equals(Qualification.SERIALIZABLE.toString()) ? true : false;
    // TODO DEFAULT FALSE, ANCAK ECORE DA TRUE, TARTIS!.
    eEnum.setSerializable(isSerializable);

    ctx.ownedLiteral.forEach(l -> {
      final EEnumLiteral eEnumLiteral = visitEEnumLiteral(l);
      eEnum.getELiterals().add(eEnumLiteral);
    });

    // OWNED CONSTRAINTS = INVARIANT CONSTRAINT*

    CS2ASMapping.name2eEnum.put(name, eEnum);
    return eEnum;
  }

  @Override
  public EEnumLiteral visitEEnumLiteral(final EEnumLiteralContext ctx) {
    return createEEnumLiteral(ctx);
  }

  /**
   * @param ctx
   * @return
   */
  private EEnumLiteral createEEnumLiteral(final EEnumLiteralContext ctx) {
    final EEnumLiteral eEnumLiteral = CS2ASMapping.factory.createEEnumLiteral();

    final String name = ctx.name.getText();
    eEnumLiteral.setName(name);

    if (ctx.value != null) {
      final int value = Integer.parseInt(ctx.value.getText());
      eEnumLiteral.setValue(value);
    }

    CS2ASMapping.name2eEnumLiteral.put(name, eEnumLiteral);
    return eEnumLiteral;
  }

  private EAnnotation visitQualifier(final String qualifier, final String value) {
    return createEAnnotation(qualifier, value);
  }

  /**
   * @param qualifier
   * @param value
   * @return
   */
  private EAnnotation createEAnnotation(final String qualifier, final String value) {
    final EAnnotation eAnnotation = CS2ASMapping.factory.createEAnnotation();

    Map<String, String> map = eAnnotation.getDetails().map();
    if (map.size() == 0) {
      map = new HashMap<>();
    }
    map.put(qualifier, value);
    final EMap<String, String> eMap = eAnnotation.getDetails();
    eMap.putAll(map);

    return eAnnotation;
  }

  public static void saveResource(final EObject root, final String savePath) {
    final ResourceSet metaResourceSet = new ResourceSetImpl();

    /*
     * Register XML Factory implementation to handle .ecore files
     */
    metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
    .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new EcoreResourceFactoryImpl());

    /*
     * Create empty resource with the given URI
     */
    final Resource metaResource = metaResourceSet.createResource(URI.createURI("./tut.ecore"));

    /*
     * Add bookStoreEPackage to contents list of the resource
     */
    metaResource.getContents().add(root);

    final HashMap<Object, Object> options = new HashMap<>();
    try {
      /*
       * Save the resource
       */
      metaResource.save(options);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
}
