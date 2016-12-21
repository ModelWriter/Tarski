package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.io.IOException;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.BodyContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAttributeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumLiteralContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementRefContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ENamedElementContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPrimitiveTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EStructuralFeatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypedElementContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.FormulaContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionsContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PostconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PreconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.QualifiedNameContext;
import eu.modelwriter.core.alloyinecore.ui.cs2as.AnnotationSources;
import eu.modelwriter.core.alloyinecore.ui.cs2as.ImportedModule;
import eu.modelwriter.core.alloyinecore.ui.cs2as.Qualification;

public class CS2ASMapping extends AlloyInEcoreBaseVisitor<Object> {
  private static final CS2ASMapping instance = new CS2ASMapping();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  private String savePath;

  private CS2ASMapping() {}

  public static CS2ASMapping getInstance() {
    CS2ASRepository.clearRepository();
    return CS2ASMapping.instance;
  }

  /**
   *
   * @param fileInput : alloy in ecore program input.
   * @param savePath : save location for ecore file.
   */
  public void parseAndSave(final String fileInput, final String savePath) {
    this.savePath = savePath;

    ANTLRInputStream inputStream = null;
    inputStream = new ANTLRInputStream(fileInput);

    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(inputStream);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
    final ParseTree tree = parser.module();

    final CS2ASMapping code2Ecore = CS2ASMapping.getInstance();
    code2Ecore.visit(tree);
  }

  @Override
  public Object visitModule(final ModuleContext ctx) {
    CS2ASInitializer.instance.visit(ctx);

    if (ctx.identifier() != null) {
      final EAnnotation moduleAnnotation = createEAnnotation(AnnotationSources.MODULE);
      moduleAnnotation.getDetails().put(Qualification.NAME.toString(), ctx.identifier().getText());
      CS2ASRepository.root.getEAnnotations().add(moduleAnnotation);
    }

    ctx.ownedPackageImport.forEach(opi -> {
      visitPackageImport(opi);
    });

    ctx.ownedPackage.forEach(op -> {
      visitEPackage(op);
    });

    if (ctx.options() != null) {
      final EAnnotation optionsAnnotation = visitOptions(ctx.options());
      CS2ASRepository.root.getEAnnotations().add(optionsAnnotation);
    }

    CS2ASMapping.saveResource(CS2ASRepository.root, savePath);

    return null;
  }

  @Override
  public EAnnotation visitOptions(final OptionsContext ctx) {
    final EAnnotation optionsAnnotation = createEAnnotation(AnnotationSources.OPTIONS);

    // TODO after grammer updated, change to o.key.getText(), o.value.getText()
    ctx.option().forEach(o -> {
      final String key = o.getChild(0).getText();
      final String value = o.getChild(2).getText();
      optionsAnnotation.getDetails().put(key, value);
    });

    return optionsAnnotation;
  }

  @Override
  public Object visitPackageImport(final PackageImportContext ctx) {
    final String name = ctx.name != null ? ctx.name.getText() : null;
    final String path = ctx.ownedPathName.getText();

    final EAnnotation importAnnotation = createEAnnotation(AnnotationSources.IMPORT);
    importAnnotation.getDetails().put(name, path);

    CS2ASRepository.root.getEAnnotations().add(importAnnotation);
    return null;
  }

  @Override
  public EPackage visitEPackage(final EPackageContext ctx) {
    final String name = ctx.name.getText();
    CS2ASMapping.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", CS2ASMapping.qualifiedNameStack);

    final EPackage ePackage = CS2ASRepository.qname2ePackage.get(qualifiedName);

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          createEAnnotation(Qualification.VISIBILITY.getAnnotationSource());
      visibilityAnnotation.getDetails().put(Qualification.VISIBILITY.toString(),
          ctx.visibility.getText());
      ePackage.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    ePackage.setName(name);

    final String nsPrefix = ctx.nsPrefix.getText();
    ePackage.setNsPrefix(nsPrefix);

    final String nsURI = ctx.nsURI.getText();
    ePackage.setNsURI(nsURI);

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation eAnnotation = visitEAnnotation(oa);
      ePackage.getEAnnotations().add(eAnnotation);
    });

    ctx.eSubPackages.forEach(esp -> {
      final EPackage subPackage = visitEPackage(esp);
      ePackage.getESubpackages().add(subPackage);
    });

    ctx.eClassifiers.forEach(ec -> {
      final EClassifier eClassifier = visitEClassifier(ec);
      ePackage.getEClassifiers().add(eClassifier);
    });

    ctx.eConstraints.forEach(ec -> {
      final EAnnotation invariantAnnotation = visitInvariant(ec);
      ePackage.getEAnnotations().add(invariantAnnotation);
    });

    CS2ASMapping.qualifiedNameStack.pop();
    return ePackage;
  }

  @Override
  public EClassifier visitEClassifier(final EClassifierContext ctx) {
    return (EClassifier) super.visitEClassifier(ctx);
  }

  @Override
  public EClass visitEClass(final EClassContext ctx) {
    final String name = ctx.name.getText();
    CS2ASMapping.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", CS2ASMapping.qualifiedNameStack);

    final EClass eClass = CS2ASRepository.qname2eClass.get(qualifiedName);

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          createEAnnotation(Qualification.VISIBILITY.getAnnotationSource());
      visibilityAnnotation.getDetails().put(Qualification.VISIBILITY.toString(),
          ctx.visibility.getText());
      eClass.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final boolean isAbstract = ctx.isAbstract != null ? true : false;
    // DEFAULT FALSE
    eClass.setAbstract(isAbstract);

    eClass.setName(name);

    ctx.eSuperTypes.forEach(est -> {
      final EClass superType = (EClass) visitQualifiedName(est);
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

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation eAnnotation = visitEAnnotation(oa);
      eClass.getEAnnotations().add(eAnnotation);
    });

    ctx.eOperations.forEach(eo -> {
      final EOperation eOperation = visitEOperation(eo);
      eClass.getEOperations().add(eOperation);
    });

    ctx.eStructuralFeatures.forEach(esf -> {
      final EStructuralFeature eStructuralFeature = visitEStructuralFeature(esf);
      eClass.getEStructuralFeatures().add(eStructuralFeature);
    });

    ctx.eConstraints.forEach(ec -> {
      final EAnnotation invariantAnnotation = visitInvariant(ec);
      eClass.getEAnnotations().add(invariantAnnotation);
    });

    CS2ASMapping.qualifiedNameStack.pop();
    return eClass;
  }

  @Override
  public EStructuralFeature visitEStructuralFeature(final EStructuralFeatureContext ctx) {
    return (EStructuralFeature) super.visitEStructuralFeature(ctx);
  }

  @Override
  public EAttribute visitEAttribute(final EAttributeContext ctx) {
    final EAttribute eAttribute = CS2ASRepository.factory.createEAttribute();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          createEAnnotation(Qualification.VISIBILITY.getAnnotationSource());
      visibilityAnnotation.getDetails().put(Qualification.VISIBILITY.toString(),
          ctx.visibility.getText());
      eAttribute.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final boolean isStatic =
        ctx.qualifier.stream().anyMatch(q -> q.getText().equals(Qualification.STATIC.toString()));
    if (isStatic) {
      final EAnnotation staticAnnotation =
          createEAnnotation(Qualification.STATIC.getAnnotationSource());
      // DEFAULT NULL
      eAttribute.getEAnnotations().add(staticAnnotation);
    }

    final boolean isModel =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.MODEL.toString()));
    if (isModel) {
      final EAnnotation ghostAnnotation =
          createEAnnotation(Qualification.MODEL.getAnnotationSource());
      // DEFAULT NULL
      eAttribute.getEAnnotations().add(ghostAnnotation);
    }

    final boolean isGhost =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.GHOST.toString()));
    if (isGhost) {
      final EAnnotation ghostAnnotation =
          createEAnnotation(Qualification.GHOST.getAnnotationSource());
      // DEFAULT NULL
      eAttribute.getEAnnotations().add(ghostAnnotation);
    }

    final boolean isTransient = ctx.qualifier.stream()
        .anyMatch(p -> p.getText().equals(Qualification.TRANSIENT.toString()));
    // DEFAULT FALSE
    eAttribute.setTransient(isTransient);

    final boolean isVolatile =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.VOLATILE.toString()));
    // DEFAULT FALSE
    eAttribute.setVolatile(isVolatile);

    final boolean isNullable =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.NULLABLE.toString()));
    if (isNullable) {
      final EAnnotation nullableAnnotation =
          createEAnnotation(Qualification.NULLABLE.getAnnotationSource());
      // DEFAULT NULL
      eAttribute.getEAnnotations().add(nullableAnnotation);
    }

    final boolean isReadonly =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.READONLY.toString()));
    // DEFAULT FALSE
    final boolean changeable = !isReadonly;
    // readonly is opposite of changeable. so reverse the logic.
    eAttribute.setChangeable(changeable);

    final String name = ctx.name.getText();
    eAttribute.setName(name);

    if (ctx.defaultValue != null) {
      final String defaultValue = ctx.defaultValue.getText();
      eAttribute.setDefaultValue(defaultValue);
    } // DEFAULT NULL

    if (ctx.eAttributeType != null) {
      final EClassifier eType = visitEType(ctx.eAttributeType);
      eAttribute.setEType(eType);

      if (ctx.multiplicity != null) {
        final int[] multiplicity = visitEMultiplicity(ctx.multiplicity);
        eAttribute.setLowerBound(multiplicity[0]);
        eAttribute.setUpperBound(multiplicity[1]);
      } else { // DEFAULT 1
        eAttribute.setLowerBound(1);
        eAttribute.setUpperBound(1);
      }
    } // DEFAULT NULL


    final boolean isDerived =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.DERIVED.toString()));
    // DEFAULT FALSE
    eAttribute.setDerived(isDerived);

    final boolean isId =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.ID.toString()));
    // DEFAULT FALSE
    eAttribute.setID(isId);

    final boolean isOrdered =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.ORDERED.toString()));
    // DEFAULT FALSE
    eAttribute.setOrdered(isOrdered);

    final boolean isUnique = !ctx.qualifier.stream()
        .anyMatch(p -> p.getText().equals(Qualification.NOT_UNIQUE.toString()));
    // DEFAULT TRUE
    eAttribute.setUnique(isUnique);

    final boolean isUnsettable = ctx.qualifier.stream()
        .anyMatch(p -> p.getText().equals(Qualification.UNSETTABLE.toString()));
    // DEFAULT FALSE
    eAttribute.setUnsettable(isUnsettable);

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation eAnnotation = visitEAnnotation(oa);
      eAttribute.getEAnnotations().add(eAnnotation);
    });

    // ctx.ownedInitialExpression.forEach(oie -> {
    // final String expression = visitExpression(oie);
    // final EAnnotation initialExpressionAnnotation =
    // createEAnnotation(AnnotationSources.INITIAL_EXPRESSION);
    // initialExpressionAnnotation.getDetails().put(Qualification.EXPRESSION.toString(),
    // expression);
    // eAttribute.getEAnnotations().add(initialExpressionAnnotation);
    // });
    //
    // ctx.ownedDerivedExpression.forEach(ode -> {
    // final String expression = visitExpression(ode);
    // final EAnnotation derivedExpressionAnnotation =
    // createEAnnotation(AnnotationSources.DERIVED_EXPRESSION);
    // derivedExpressionAnnotation.getDetails().put(Qualification.EXPRESSION.toString(),
    // expression);
    // eAttribute.getEAnnotations().add(derivedExpressionAnnotation);
    // });

    return eAttribute;
  }

  @Override
  public EReference visitEReference(final EReferenceContext ctx) {
    final EReference eReference = CS2ASRepository.factory.createEReference();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          createEAnnotation(Qualification.VISIBILITY.getAnnotationSource());
      visibilityAnnotation.getDetails().put(Qualification.VISIBILITY.toString(),
          ctx.visibility.getText());
      eReference.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final boolean isStatic =
        ctx.qualifier.stream().anyMatch(q -> q.getText().equals(Qualification.STATIC.toString()));
    if (isStatic) {
      final EAnnotation staticAnnotation =
          createEAnnotation(Qualification.STATIC.getAnnotationSource());
      // DEFAULT NULL
      eReference.getEAnnotations().add(staticAnnotation);
    }

    final boolean isModel =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.MODEL.toString()));
    if (isModel) {
      final EAnnotation ghostAnnotation =
          createEAnnotation(Qualification.MODEL.getAnnotationSource());
      // DEFAULT NULL
      eReference.getEAnnotations().add(ghostAnnotation);
    }

    final boolean isGhost =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.GHOST.toString()));
    if (isGhost) {
      final EAnnotation ghostAnnotation =
          createEAnnotation(Qualification.GHOST.getAnnotationSource());
      // DEFAULT NULL
      eReference.getEAnnotations().add(ghostAnnotation);
    }

    final boolean isTransient = ctx.qualifier.stream()
        .anyMatch(p -> p.getText().equals(Qualification.TRANSIENT.toString()));
    // DEFAULT FALSE
    eReference.setTransient(isTransient);

    final boolean isVolatile =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.VOLATILE.toString()));
    // DEFAULT FALSE
    eReference.setVolatile(isVolatile);

    final boolean isNullable =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.NULLABLE.toString()));
    if (isNullable) {
      final EAnnotation nullableAnnotation =
          createEAnnotation(Qualification.NULLABLE.getAnnotationSource());
      // DEFAULT NULL
      eReference.getEAnnotations().add(nullableAnnotation);
    }

    final boolean isReadonly =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.READONLY.toString()));
    // DEFAULT FALSE
    final boolean changeable = !isReadonly;
    // readonly is opposite of changeable. so reverse the logic.
    eReference.setChangeable(changeable);

    final String name = ctx.name.getText();
    eReference.setName(name);

    if (ctx.eReferenceType != null) {
      final EClassifier eType = visitEType(ctx.eReferenceType);
      eReference.setEType(eType);

      if (ctx.opposite != null) {
        final String oppositeName = ctx.opposite.getText();
        final EClass oppositeType = (EClass) eType;
        final EReference eOpposite = oppositeType.getEReferences().stream()
            .filter(er -> er.getName().equals(oppositeName)).findFirst().orElse(null);
        eReference.setEOpposite(eOpposite);
      } // DEFAULT NULL
    }

    if (ctx.multiplicity != null) {
      final int[] multiplicity = visitEMultiplicity(ctx.multiplicity);
      eReference.setLowerBound(multiplicity[0]);
      eReference.setUpperBound(multiplicity[1]);
    } else { // DEFAULT 1
      eReference.setLowerBound(1);
      eReference.setUpperBound(1);
    }

    if (ctx.defaultValue != null) {
      final String defaultValue = ctx.defaultValue.getText();
      eReference.setDefaultValue(defaultValue);
    } // DEFAULT NULL

    final boolean isComposes =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.COMPOSES.toString()));
    // DEFAULT FALSE
    eReference.setContainment(isComposes);

    final boolean isDerived =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.DERIVED.toString()));
    // DEFAULT FALSE
    eReference.setDerived(isDerived);

    final boolean isOrdered =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.ORDERED.toString()));
    // DEFAULT FALSE
    eReference.setOrdered(isOrdered);

    final boolean isUnique = !ctx.qualifier.stream()
        .anyMatch(p -> p.getText().equals(Qualification.NOT_UNIQUE.toString()));
    // DEFAULT TRUE
    eReference.setUnique(isUnique);

    final boolean isResolve =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.RESOLVE.toString()));
    // DEFAULT FALSE
    eReference.setResolveProxies(isResolve);

    final boolean isUnsettable = ctx.qualifier.stream()
        .anyMatch(p -> p.getText().equals(Qualification.UNSETTABLE.toString()));
    // DEFAULT FALSE
    eReference.setUnsettable(isUnsettable);

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation eAnnotation = visitEAnnotation(oa);
      eReference.getEAnnotations().add(eAnnotation);
    });

    // TODO REFERRED KEYS ?

    ctx.ownedInitialExpression.forEach(oie -> {
      final String expression = visitExpression(oie);
      final EAnnotation initialExpressionAnnotation =
          createEAnnotation(AnnotationSources.INITIAL_EXPRESSION);
      initialExpressionAnnotation.getDetails().put(Qualification.EXPRESSION.toString(), expression);
      eReference.getEAnnotations().add(initialExpressionAnnotation);
    });

    ctx.ownedDerivedExpression.forEach(ode -> {
      final String expression = visitExpression(ode);
      final EAnnotation derivedExpressionAnnotation =
          createEAnnotation(AnnotationSources.DERIVED_EXPRESSION);
      derivedExpressionAnnotation.getDetails().put(Qualification.EXPRESSION.toString(), expression);
      eReference.getEAnnotations().add(derivedExpressionAnnotation);
    });

    return eReference;
  }

  @Override
  public EOperation visitEOperation(final EOperationContext ctx) {
    final EOperation eOperation = CS2ASRepository.factory.createEOperation();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          createEAnnotation(Qualification.VISIBILITY.getAnnotationSource());
      visibilityAnnotation.getDetails().put(Qualification.VISIBILITY.toString(),
          ctx.visibility.getText());
      eOperation.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    final boolean isStatic =
        ctx.qualifier.stream().anyMatch(q -> q.getText().equals(Qualification.STATIC.toString()));
    if (isStatic) {
      final EAnnotation staticAnnotation =
          createEAnnotation(Qualification.STATIC.getAnnotationSource());
      // DEFAULT NULL
      eOperation.getEAnnotations().add(staticAnnotation);
    }

    final String name = ctx.name.getText();
    eOperation.setName(name);

    ctx.eParameters.forEach(ep -> {
      final EParameter eParameter = visitEParameter(ep);
      eOperation.getEParameters().add(eParameter);
    });

    if (ctx.returnType != null) {
      final EClassifier returnType = visitEType(ctx.returnType);
      eOperation.setEType(returnType);

      final int[] multiplicity = visitEMultiplicity(ctx.multiplicity);
      eOperation.setLowerBound(multiplicity[0]);
      eOperation.setUpperBound(multiplicity[1]);
    }

    // TODO OWNED EXCEPTION (NOT IMPLEMENTED ON BNF)

    final boolean isOrdered =
        ctx.qualifier.stream().anyMatch(q -> q.getText().equals(Qualification.ORDERED.toString()));
    // DEFAULT FALSE
    eOperation.setOrdered(isOrdered);

    final boolean isUnique = !ctx.qualifier.stream()
        .anyMatch(q -> q.getText().equals(Qualification.NOT_UNIQUE.toString()));
    // DEFAULT TRUE
    eOperation.setUnique(isUnique);

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation eAnnotation = visitEAnnotation(oa);
      eOperation.getEAnnotations().add(eAnnotation);
    });

    ctx.ownedPreconditions.forEach(opc -> {
      final EAnnotation preconditionAnnotation = visitPrecondition(opc);
      eOperation.getEAnnotations().add(preconditionAnnotation);
    });

    ctx.ownedBodyExpression.forEach(obe -> {
      final EAnnotation bodyAnnotation = visitBody(obe);
      eOperation.getEAnnotations().add(bodyAnnotation);
    });

    ctx.ownedPostconditions.forEach(opc -> {
      final EAnnotation postconditionAnnotation = visitPostcondition(opc);
      eOperation.getEAnnotations().add(postconditionAnnotation);
    });

    return eOperation;
  }


  @Override
  public EParameter visitEParameter(final EParameterContext ctx) {
    final EParameter eParameter = CS2ASRepository.factory.createEParameter();

    final boolean isNullable =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.NULLABLE.toString()));
    if (isNullable) {
      final EAnnotation nullableAnnotation =
          createEAnnotation(Qualification.NULLABLE.getAnnotationSource());
      // DEFAULT NULL
      eParameter.getEAnnotations().add(nullableAnnotation);
    }

    final String name = ctx.name.getText();
    eParameter.setName(name);

    if (ctx.ownedType != null) {
      final EClassifier eType = visitEType(ctx.ownedType);
      eParameter.setEType(eType);

      if (ctx.ownedMultiplicity != null) {
        final int[] multiplicity = visitEMultiplicity(ctx.ownedMultiplicity);
        eParameter.setLowerBound(multiplicity[0]);
        eParameter.setUpperBound(multiplicity[1]);
      } else { // DEFAULT 1
        eParameter.setLowerBound(1);
        eParameter.setUpperBound(1);
      }
    } // DEFAULT NULL

    final boolean isOrdered =
        ctx.qualifier.stream().anyMatch(q -> q.getText().equals(Qualification.ORDERED.toString()));
    // DEFAULT FALSE
    eParameter.setOrdered(isOrdered);

    final boolean isUnique = !ctx.qualifier.stream()
        .anyMatch(q -> q.getText().equals(Qualification.NOT_UNIQUE.toString()));
    // DEFAULT TRUE
    eParameter.setUnique(isUnique);

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation eAnnotation = visitEAnnotation(oa);
      eParameter.getEAnnotations().add(eAnnotation);
    });

    return eParameter;
  }

  @Override
  public EClassifier visitEType(final ETypeContext ctx) {
    return (EClassifier) super.visitEType(ctx);
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
    } // TODO ('|?' | isNullFree= '|1')?
    return new int[] {lower, upper};
  }

  @Override
  public EDataType visitEDataType(final EDataTypeContext ctx) {
    final String name = ctx.name.getText();
    CS2ASMapping.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", CS2ASMapping.qualifiedNameStack);

    final EDataType eDataType = CS2ASRepository.qname2eDataType.get(qualifiedName);

    if (ctx.isPrimitive != null) {
      final EAnnotation primitiveAnnotation =
          createEAnnotation(Qualification.PRIMITIVE.getAnnotationSource());
      // DEFAULT NULL
      eDataType.getEAnnotations().add(primitiveAnnotation);
    }

    final boolean isNullable =
        ctx.qualifier.stream().anyMatch(p -> p.getText().equals(Qualification.NULLABLE.toString()));
    if (isNullable) {
      final EAnnotation nullableAnnotation =
          createEAnnotation(Qualification.NULLABLE.getAnnotationSource());
      // DEFAULT NULL
      eDataType.getEAnnotations().add(nullableAnnotation);
    }

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

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation eAnnotation = visitEAnnotation(oa);
      eDataType.getEAnnotations().add(eAnnotation);
    });

    ctx.ownedConstraints.forEach(oc -> {
      final EAnnotation invariantAnnotation = visitInvariant(oc);
      eDataType.getEAnnotations().add(invariantAnnotation);
    });

    CS2ASMapping.qualifiedNameStack.pop();
    return eDataType;
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
  public EEnum visitEEnum(final EEnumContext ctx) {
    final String name = ctx.name.getText();
    CS2ASMapping.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", CS2ASMapping.qualifiedNameStack);

    final EEnum eEnum = CS2ASRepository.qname2eEnum.get(qualifiedName);

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation =
          createEAnnotation(Qualification.VISIBILITY.getAnnotationSource());
      visibilityAnnotation.getDetails().put(Qualification.VISIBILITY.toString(),
          ctx.visibility.getText());
      eEnum.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT NULL

    eEnum.setName(name);

    // TODO OWNED SIGNATURE = TEMPLATE SIGNATURE

    if (ctx.instanceClassName != null) {
      final String instanceClassName = ctx.instanceClassName.getText();
      eEnum.setInstanceClassName(instanceClassName);
    }

    final boolean isSerializable = ctx.isSerializable != null
        && ctx.isSerializable.equals(Qualification.SERIALIZABLE.toString()) ? true : false;
    // TODO DEFAULT FALSE, ANCAK ECORE DA TRUE, TARTIS!.
    eEnum.setSerializable(isSerializable);

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation eAnnotation = visitEAnnotation(oa);
      eEnum.getEAnnotations().add(eAnnotation);
    });

    ctx.ownedLiteral.forEach(l -> {
      final EEnumLiteral eEnumLiteral = visitEEnumLiteral(l);
      eEnum.getELiterals().add(eEnumLiteral);
    });

    ctx.ownedConstraint.forEach(oc -> {
      final EAnnotation invariantAnnotation = visitInvariant(oc);
      eEnum.getEAnnotations().add(invariantAnnotation);
    });

    CS2ASMapping.qualifiedNameStack.pop();
    return eEnum;
  }

  @Override
  public EEnumLiteral visitEEnumLiteral(final EEnumLiteralContext ctx) {
    final EEnumLiteral eEnumLiteral = CS2ASRepository.factory.createEEnumLiteral();

    final String name = ctx.name.getText();
    eEnumLiteral.setName(name);

    if (ctx.value != null) {
      final int value = Integer.parseInt(ctx.value.getText());
      eEnumLiteral.setValue(value);
    }

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation eAnnotation = visitEAnnotation(oa);
      eEnumLiteral.getEAnnotations().add(eAnnotation);
    });

    return eEnumLiteral;
  }

  @Override
  public EAnnotation visitEAnnotation(final EAnnotationContext ctx) {
    final String source = ctx.name != null ? ctx.name.getText() : null;
    final EAnnotation eAnnotation = createEAnnotation(source);

    ctx.ownedDetails.forEach(od -> {
      final String key = od.name.getText();
      final String value = od.value.getText();
      eAnnotation.getDetails().put(key, value);
    });

    ctx.ownedAnnotations.forEach(oa -> {
      final EAnnotation ownedAnnoation = visitEAnnotation(oa);
      eAnnotation.getEAnnotations().add(ownedAnnoation);
    });

    ctx.ownedContents.forEach(oc -> {
      final EModelElement eModelElement = visitEModelElement(oc);
      eAnnotation.getContents().add(eModelElement);
    });

    ctx.ownedReferences.forEach(or -> {
      final EObject eModelElementRef = visitEModelElementRef(or);
      eAnnotation.getReferences().add(eModelElementRef);
    });

    return eAnnotation;
  }

  private EAnnotation createEAnnotation(final String source) {
    final EAnnotation eAnnotation = CS2ASRepository.factory.createEAnnotation();

    eAnnotation.setSource(source);

    return eAnnotation;
  }

  @Override
  public EModelElement visitEModelElement(final EModelElementContext ctx) {
    return (EModelElement) super.visitEModelElement(ctx);
  }

  @Override
  public ENamedElement visitENamedElement(final ENamedElementContext ctx) {
    return (ENamedElement) super.visitENamedElement(ctx);
  }

  @Override
  public ETypedElement visitETypedElement(final ETypedElementContext ctx) {
    return (ETypedElement) super.visitETypedElement(ctx);
  }

  @Override
  public EObject visitEModelElementRef(final EModelElementRefContext ctx) {
    return visitQualifiedName(ctx.ownedPathName);
  }

  @Override
  public EAnnotation visitBody(final BodyContext ctx) {
    final String source = AnnotationSources.BODY;
    final EAnnotation eAnnotation = createEAnnotation(source);

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eAnnotation.getDetails().put(Qualification.NAME.toString(), name);
    }

    if (ctx.ownedExpression != null) {
      final String expression = visitExpression(ctx.ownedExpression);
      eAnnotation.getDetails().put(Qualification.EXPRESSION.toString(), expression);
    }

    return eAnnotation;
  }

  @Override
  public EAnnotation visitInvariant(final InvariantContext ctx) {
    final String source = AnnotationSources.INVARIANT;
    final EAnnotation eAnnotation = createEAnnotation(source);

    final Boolean isCallable = ctx.isCallable != null ? true : false;
    eAnnotation.getDetails().put(Qualification.CALLABLE.toString(), isCallable.toString());

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eAnnotation.getDetails().put(Qualification.NAME.toString(), name);
    }

    if (ctx.message != null) {
      final String message = ctx.message.getText();
      eAnnotation.getDetails().put(Qualification.MESSAGE.toString(), message);
    }

    if (ctx.ownedSpecification != null) {
      final String formula = visitFormula(ctx.ownedSpecification);
      eAnnotation.getDetails().put(Qualification.FORMULA.toString(), formula);
    }

    return eAnnotation;
  }

  @Override
  public EAnnotation visitPrecondition(final PreconditionContext ctx) {
    final String source = AnnotationSources.PRECONDITION;
    final EAnnotation eAnnotation = createEAnnotation(source);

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eAnnotation.getDetails().put(Qualification.NAME.toString(), name);
    }

    if (ctx.message != null) {
      final String message = ctx.message.getText();
      eAnnotation.getDetails().put(Qualification.MESSAGE.toString(), message);
    }

    if (ctx.ownedSpecification != null) {
      final String formula = visitFormula(ctx.ownedSpecification);
      eAnnotation.getDetails().put(Qualification.FORMULA.toString(), formula);
    }

    return eAnnotation;
  }

  @Override
  public EAnnotation visitPostcondition(final PostconditionContext ctx) {
    final String source = AnnotationSources.POSTCONDITION;
    final EAnnotation eAnnotation = createEAnnotation(source);

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eAnnotation.getDetails().put(Qualification.NAME.toString(), name);
    }

    if (ctx.message != null) {
      final String message = ctx.message.getText();
      eAnnotation.getDetails().put(Qualification.MESSAGE.toString(), message);
    }

    if (ctx.ownedSpecification != null) {
      final String formula = visitFormula(ctx.ownedSpecification);
      eAnnotation.getDetails().put(Qualification.FORMULA.toString(), formula);
    }

    return eAnnotation;
  }

  public String visitExpression(final ExpressionContext ctx) {
    // TODO will be implemented when expressions are defined
    return ctx.getText();
  }

  public String visitFormula(final FormulaContext ctx) {
    // TODO will be implemented when formulas are defined
    return ctx.getText();
  }

  @Override
  public EObject visitQualifiedName(final QualifiedNameContext ctx) {
    String moduleName = null;
    final String objectName;
    String[] relativePathFragments = null;

    if (ctx.lastPart != null) {
      moduleName = ctx.firstPart.getText();
      objectName = ctx.lastPart.getText();

      if (ctx.midParts != null) {
        relativePathFragments = new String[ctx.midParts.size() + 2];
        relativePathFragments[0] = moduleName;
        relativePathFragments[relativePathFragments.length - 1] = objectName;
        for (int i = 1; i < ctx.midParts.size() + 1; i++) {
          relativePathFragments[i] = ctx.midParts.get(i).getText();
        }
      } else { // : importName::ObjectName ... ;
        relativePathFragments = new String[2];
        relativePathFragments[0] = moduleName;
        relativePathFragments[1] = objectName;
      }
    } else { // : ObjectName ... ;
      objectName = ctx.firstPart.getText();

      CS2ASMapping.qualifiedNameStack.push(objectName);
      relativePathFragments = new String[CS2ASMapping.qualifiedNameStack.size()];
      for (int i = 0; i < CS2ASMapping.qualifiedNameStack.size(); i++) {
        relativePathFragments[i] = CS2ASMapping.qualifiedNameStack.get(i);
      }
      CS2ASMapping.qualifiedNameStack.pop();
    }

    if (moduleName != null && CS2ASRepository.qname2importedModule.containsKey(moduleName)) {
      // imported module
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
      }
    }
    return null;
  }

  public static void saveResource(final EObject root, final String savePath) {
    final ResourceSet metaResourceSet = new ResourceSetImpl();

    /*
     * Register XML Factory implementation to handle .ecore files
     */
    metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
        new XMLResourceFactoryImpl());

    /*
     * Create empty resource with the given URI
     */
    final Resource metaResource =
        metaResourceSet.createResource(URI.createPlatformResourceURI(savePath, true));

    /*
     * Add bookStoreEPackage to contents list of the resource
     */
    metaResource.getContents().add(root);

    try {
      /*
       * Save the resource
       */
      metaResource.save(null);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
}
