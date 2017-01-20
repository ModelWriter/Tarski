package eu.modelwriter.core.alloyinecore.ui.mapping.cs2as;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.BodyContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.DerivationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAttributeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumLiteralContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EExceptionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeArgumentContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeRefContext;
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
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeRefContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypedElementContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.FormulaContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InitialContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionsContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PathNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PostconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PreconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.WildcardTypeRefContext;
import eu.modelwriter.core.alloyinecore.ui.mapping.AIEConstants;
import eu.modelwriter.core.alloyinecore.ui.mapping.AnnotationSources;

public class CS2ASMapping extends AlloyInEcoreBaseVisitor<Object> {
  private static final CS2ASMapping instance = new CS2ASMapping();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  private String fileInput;

  private CS2ASMapping() {}

  public static CS2ASMapping getInstance() {
    return CS2ASMapping.instance;
  }

  private void clear() {
    pc = 0;
    cc = 0;
    ac = 0;
    rc = 0;
    oc = 0;
    dtc = 0;
    ec = 0;
    tpc = 0;
    CS2ASMapping.qualifiedNameStack.clear();
    CS2ASRepository.clearRepository();
    CS2ASInitializer.instance.clearInitializer();
  }

  /**
   *
   * @param fileInput : alloy in ecore program input.
   * @param savePath : save location for ecore file.
   */
  public void parseAndSave(final String fileInput, final URI saveURI) {
    this.fileInput = fileInput;
    clear();

    ANTLRInputStream inputStream = null;
    inputStream = new ANTLRInputStream(fileInput);

    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(inputStream);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
    final ParseTree tree = parser.module();

    try {
      visit(tree);
    } catch (final Exception e) {
      return;
    }

    saveResource(CS2ASRepository.root, saveURI);
  }

  @Override
  public Object visitModule(final ModuleContext ctx) {
    CS2ASInitializer.instance.initialize(ctx);

    final List<EAnnotation> importAnnotations = new ArrayList<>();
    ctx.ownedPackageImport.forEach(opi -> {
      final EAnnotation importAnnotation = visitPackageImport(opi);
      importAnnotations.add(importAnnotation);
    });

    if (ctx.ownedPackage != null) {
      final EPackage ePackage = visitEPackage(ctx.ownedPackage);
      CS2ASRepository.root = ePackage;
    }

    if (ctx.options() != null) {
      final EAnnotation optionsAnnotation = visitOptions(ctx.options());
      CS2ASRepository.root.getEAnnotations().add(optionsAnnotation);
    }

    if (ctx.identifier() != null) {
      final EAnnotation moduleAnnotation = createEAnnotation(AnnotationSources.MODULE);
      if (ctx.name != null) {
        moduleAnnotation.getDetails().put(AIEConstants.NAME.toString(), ctx.name.getText());
      }
      CS2ASRepository.root.getEAnnotations().add(moduleAnnotation);
    }

    CS2ASRepository.root.getEAnnotations().addAll(importAnnotations);

    return null;
  }

  @Override
  public EAnnotation visitOptions(final OptionsContext ctx) {
    final EAnnotation optionsAnnotation = createEAnnotation(AnnotationSources.OPTIONS);
    if (ctx.option() != null) {
      ctx.option().forEach(o -> {
        String key = null; // key of option
        if (o.getChild(0) != null) {
          key = o.getChild(0).getText();
        }
        String value = null; // value of option
        if (o.getChild(2) != null) {
          value = o.getChild(2).getText();
        }
        optionsAnnotation.getDetails().put(key, value);
      });
    }

    return optionsAnnotation;
  }

  @Override
  public EAnnotation visitPackageImport(final PackageImportContext ctx) {
    String name = null;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    String path = null;
    if (ctx.ownedPathName != null) {
      path = ctx.ownedPathName.getText().replace("'", "");
    }

    final EAnnotation importAnnotation = createEAnnotation(AnnotationSources.IMPORT);
    importAnnotation.getDetails().put(name, path);

    return importAnnotation;
  }

  int pc = 0;

  @Override
  public EPackage visitEPackage(final EPackageContext ctx) {
    String name = "package" + ++pc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    CS2ASMapping.qualifiedNameStack.push(name);
    final EPackage ePackage =
        (EPackage) CS2ASRepository.getEObject(CS2ASMapping.qualifiedNameStack);

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      ePackage.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

    if (ctx.nsPrefix != null) {
      final String nsPrefix = ctx.nsPrefix.getText();
      ePackage.setNsPrefix(nsPrefix);
    }

    if (ctx.nsURI != null) {
      final String nsURI = ctx.nsURI.getText().replace("'", "");
      ePackage.setNsURI(nsURI);
    }

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation eAnnotation = visitEAnnotation(oa);
        ePackage.getEAnnotations().add(eAnnotation);
      });
    }

    if (ctx.eSubPackages != null) {
      ctx.eSubPackages.forEach(esp -> {
        visitEPackage(esp);
      });
    }

    if (ctx.eClassifiers != null) {
      ctx.eClassifiers.forEach(ec -> {
        visitEClassifier(ec);
      });
    }

    if (ctx.eConstraints != null) {
      ctx.eConstraints.forEach(ec -> {
        final EAnnotation invariantAnnotation = visitInvariant(ec);
        ePackage.getEAnnotations().add(invariantAnnotation);
      });
    }

    if (ctx.name == null) {
      ePackage.setName(null);
    }

    CS2ASMapping.qualifiedNameStack.pop();
    return ePackage;
  }

  @Override
  public EClassifier visitEClassifier(final EClassifierContext ctx) {
    return (EClassifier) super.visitEClassifier(ctx);
  }

  int cc = 0;

  @Override
  public EClass visitEClass(final EClassContext ctx) {
    String name = "class" + ++cc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    CS2ASMapping.qualifiedNameStack.push(name);
    final EClass eClass = (EClass) CS2ASRepository.getEObject(CS2ASMapping.qualifiedNameStack);

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      eClass.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

    final boolean isInterface = ctx.isInterface != null ? true : false;
    // DEFAULT FALSE
    eClass.setInterface(isInterface);

    final boolean isAbstract = ctx.isAbstract != null ? true : isInterface ? true : false;
    // DEFAULT FALSE
    eClass.setAbstract(isAbstract);

    if (ctx.ownedSignature != null) {
      final List<ETypeParameter> eTypeParameters = visitTemplateSignature(ctx.ownedSignature);
      eClass.getETypeParameters().addAll(eTypeParameters);
    }

    if (ctx.eSuperTypes != null) {
      ctx.eSuperTypes.forEach(est -> {
        final EGenericType superType = visitEGenericTypeRef(est);
        if (superType != null) {
          eClass.getEGenericSuperTypes().add(superType);
        }
      });
    }

    if (ctx.instanceClassName != null) {
      final String instanceClassName = ctx.instanceClassName.getText().replace("'", "");
      eClass.setInstanceClassName(instanceClassName);
    }

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation eAnnotation = visitEAnnotation(oa);
        eClass.getEAnnotations().add(eAnnotation);
      });
    }

    if (ctx.eOperations != null) {
      ctx.eOperations.forEach(eo -> {
        final EOperation eOperation = visitEOperation(eo);
        if (eOperation != null) {
          final Iterator<EOperation> iterator = eClass.getEOperations().iterator();
          while (iterator.hasNext()) {
            final EOperation o = iterator.next();
            if (EcoreUtil.equals(o, eOperation)) {
              iterator.remove();
              // we create operation in OperationInitializer. So we should replace with new one.
              break;
            }
          }
          eClass.getEOperations().add(eOperation);
        }
      });
    }

    if (ctx.eStructuralFeatures != null) {
      ctx.eStructuralFeatures.forEach(esf -> {
        visitEStructuralFeature(esf);
      });
    }

    if (ctx.eConstraints != null) {
      ctx.eConstraints.forEach(ec -> {
        final EAnnotation invariantAnnotation = visitInvariant(ec);
        eClass.getEAnnotations().add(invariantAnnotation);
      });
    }

    if (ctx.name == null) {
      eClass.setName(null);
    }

    CS2ASMapping.qualifiedNameStack.pop();
    return eClass;
  }

  @Override
  public EStructuralFeature visitEStructuralFeature(final EStructuralFeatureContext ctx) {
    return (EStructuralFeature) super.visitEStructuralFeature(ctx);
  }

  int ac = 0;

  @Override
  public EAttribute visitEAttribute(final EAttributeContext ctx) {
    String name = "attribute" + ++ac;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    CS2ASMapping.qualifiedNameStack.push(name);
    final EAttribute eAttribute =
        (EAttribute) CS2ASRepository.getEObject(CS2ASMapping.qualifiedNameStack);
    CS2ASMapping.qualifiedNameStack.pop();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      eAttribute.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

    if (ctx.eAttributeType != null) {
      final EObject typedRef = visitETypeRef(ctx.eAttributeType);
      if (typedRef instanceof EClassifier) {
        eAttribute.setEType((EClassifier) typedRef);
      } else if (typedRef instanceof EGenericType) {
        eAttribute.setEGenericType((EGenericType) typedRef);
      }
    }

    if (ctx.ownedMultiplicity != null) {
      final int[] multiplicity = visitEMultiplicity(ctx.ownedMultiplicity);
      eAttribute.setLowerBound(multiplicity[0]);
      eAttribute.setUpperBound(multiplicity[1]);
      if (isCollection(eAttribute, ctx.ownedMultiplicity)) {
        final EAnnotation nullableAnnotation = createEAnnotation(AnnotationSources.NULLABLE);
        // DEFAULT NULL
        eAttribute.getEAnnotations().add(nullableAnnotation);
      }
    } else { // DEFAULT 1..1
      eAttribute.setLowerBound(1);
      eAttribute.setUpperBound(1);
    }

    if (ctx.defaultValue != null) {
      final String defaultValue = ctx.defaultValue.getText().replace("'", "");
      eAttribute.setDefaultValueLiteral(defaultValue);
    } // DEFAULT NULL

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation eAnnotation = visitEAnnotation(oa);
        eAttribute.getEAnnotations().add(eAnnotation);
      });
    }

    if (ctx.ownedInitial != null) {
      final EAnnotation initialAnnotation = visitInitial(ctx.ownedInitial);
      eAttribute.getEAnnotations().add(initialAnnotation);
    }

    if (ctx.ownedDerivation != null) {
      final EAnnotation derivedAnnotation = visitDerivation(ctx.ownedDerivation);
      eAttribute.getEAnnotations().add(derivedAnnotation);
    }

    eAttribute.setOrdered(false);
    if (ctx.qualifier != null) {
      for (final String q : ctx.qualifier.stream().map(Token::getText).distinct()
          .collect(Collectors.toList())) {
        switch (AIEConstants.getValue(q)) {
          case STATIC:
            final EAnnotation staticAnnotation = createEAnnotation(AnnotationSources.STATIC);
            // DEFAULT NULL
            eAttribute.getEAnnotations().add(staticAnnotation);
            break;
          case MODEL:
            final EAnnotation modelAnnotation = createEAnnotation(AnnotationSources.MODEL);
            // DEFAULT NULL
            eAttribute.getEAnnotations().add(modelAnnotation);
            break;
          case GHOST:
            final EAnnotation ghostAnnotation = createEAnnotation(AnnotationSources.GHOST);
            // DEFAULT NULL
            eAttribute.getEAnnotations().add(ghostAnnotation);
            break;
          case TRANSIENT:
            // DEFAULT FALSE
            eAttribute.setTransient(true);
            break;
          case VOLATILE:
            // DEFAULT FALSE
            eAttribute.setVolatile(true);
            break;
          case NULLABLE:
            int u = eAttribute.getUpperBound();
            if (u > 1 || u == -1 && eAttribute.getEAnnotation(AnnotationSources.NULLABLE) == null) {
              final EAnnotation nullableAnnotation = createEAnnotation(AnnotationSources.NULLABLE);
              // DEFAULT NULL
              eAttribute.getEAnnotations().add(nullableAnnotation);
            }
            break;
          case READONLY:
            // DEFAULT FALSE
            // readonly is opposite of changeable. so reverse the logic.
            eAttribute.setChangeable(false);
            break;
          case DERIVED:
            // DEFAULT FALSE
            eAttribute.setDerived(true);
            break;
          case ORDERED:
            u = eAttribute.getUpperBound();
            if (u > 1 || u == -1) {
              // DEFAULT FALSE
              eAttribute.setOrdered(true);
            }
            break;
          case NOT_UNIQUE:
            u = eAttribute.getUpperBound();
            if (u > 1 || u == -1) {
              // DEFAULT TRUE
              eAttribute.setUnique(false);
            }
            break;
          case UNSETTABLE:
            // DEFAULT FALSE
            eAttribute.setUnsettable(true);
            break;
          case ID:
            // DEFAULT FALSE
            eAttribute.setID(true);
            break;
          default:
            break;
        }
      }
    }

    if (ctx.name == null) {
      eAttribute.setName(null);
    }

    return eAttribute;
  }

  int rc = 0;

  @Override
  public EReference visitEReference(final EReferenceContext ctx) {
    String name = "reference" + ++rc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    CS2ASMapping.qualifiedNameStack.push(name);
    final EReference eReference =
        (EReference) CS2ASRepository.getEObject(CS2ASMapping.qualifiedNameStack);
    CS2ASMapping.qualifiedNameStack.pop();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      eReference.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

    if (ctx.eReferenceType != null) {
      final EGenericType eReferenceType = visitEGenericTypeRef(ctx.eReferenceType);
      if (eReferenceType != null) {
        eReference.setEGenericType(eReferenceType);
      }
    }

    if (ctx.ownedMultiplicity != null) {
      final int[] multiplicity = visitEMultiplicity(ctx.ownedMultiplicity);
      eReference.setLowerBound(multiplicity[0]);
      eReference.setUpperBound(multiplicity[1]);
      if (isCollection(eReference, ctx.ownedMultiplicity)) {
        final EAnnotation nullableAnnotation = createEAnnotation(AnnotationSources.NULLABLE);
        // DEFAULT NULL
        eReference.getEAnnotations().add(nullableAnnotation);
      }
    } else { // DEFAULT 1..1
      eReference.setLowerBound(1);
      eReference.setUpperBound(1);
    }

    final EClassifier eType = eReference.getEType();
    if (ctx.eOpposite != null) {
      final String oppositeName = ctx.eOpposite.getText();
      final EReference eOpposite = (EReference) EcoreUtil.getEObject(eType, oppositeName);
      if (eOpposite != null) {
        eReference.setEOpposite(eOpposite);
        eOpposite.setEOpposite(eReference);
      }
    }

    if (ctx.defaultValue != null) {
      final String defaultValue = ctx.defaultValue.getText().replace("'", "");
      eReference.setDefaultValueLiteral(defaultValue);
    } // DEFAULT NULL

    if (ctx.referredKeys != null) {
      ctx.referredKeys.forEach(rk -> {
        final String attributeName = rk.getText();
        final EAttribute eAttribute = (EAttribute) EcoreUtil.getEObject(eType, attributeName);
        if (eAttribute != null) {
          eReference.getEKeys().add(eAttribute);
        }
      });
    }

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation eAnnotation = visitEAnnotation(oa);
        eReference.getEAnnotations().add(eAnnotation);
      });
    }

    if (ctx.ownedInitial != null) {
      final EAnnotation initialAnnotation = visitInitial(ctx.ownedInitial);
      eReference.getEAnnotations().add(initialAnnotation);
    }

    if (ctx.ownedDerivation != null) {
      final EAnnotation derivedAnnotation = visitDerivation(ctx.ownedDerivation);
      eReference.getEAnnotations().add(derivedAnnotation);
    }

    eReference.setOrdered(false);
    if (ctx.qualifier != null) {
      for (final String q : ctx.qualifier.stream().map(Token::getText).distinct()
          .collect(Collectors.toList())) {
        switch (AIEConstants.getValue(q)) {
          case STATIC:
            final EAnnotation staticAnnotation = createEAnnotation(AnnotationSources.STATIC);
            // DEFAULT NULL
            eReference.getEAnnotations().add(staticAnnotation);
            break;
          case MODEL:
            final EAnnotation modelAnnotation = createEAnnotation(AnnotationSources.MODEL);
            // DEFAULT NULL
            eReference.getEAnnotations().add(modelAnnotation);
            break;
          case GHOST:
            final EAnnotation ghostAnnotation = createEAnnotation(AnnotationSources.GHOST);
            // DEFAULT NULL
            eReference.getEAnnotations().add(ghostAnnotation);
            break;
          case TRANSIENT:
            // DEFAULT FALSE
            eReference.setTransient(true);
            break;
          case VOLATILE:
            // DEFAULT FALSE
            eReference.setVolatile(true);
            break;
          case NULLABLE:
            int u = eReference.getUpperBound();
            if (u > 1 || u == -1 && eReference.getEAnnotation(AnnotationSources.NULLABLE) == null) {
              final EAnnotation nullableAnnotation = createEAnnotation(AnnotationSources.NULLABLE);
              // DEFAULT NULL
              eReference.getEAnnotations().add(nullableAnnotation);
            }
            break;
          case READONLY:
            // DEFAULT FALSE
            // readonly is opposite of changeable. so reverse the logic.
            eReference.setChangeable(false);
            break;
          case DERIVED:
            // DEFAULT FALSE
            eReference.setDerived(true);
            break;
          case ORDERED:
            u = eReference.getUpperBound();
            if (u > 1 || u == -1) {
              // DEFAULT FALSE
              eReference.setOrdered(true);
            }
            break;
          case NOT_UNIQUE:
            u = eReference.getUpperBound();
            if (u > 1 || u == -1) {
              // DEFAULT TRUE
              eReference.setUnique(false);
            }
            break;
          case COMPOSES:
            // DEFAULT FALSE
            eReference.setContainment(true);
            break;
          case NOT_RESOLVE:
            // DEFAULT TRUE
            eReference.setResolveProxies(false);
            break;
          case UNSETTABLE:
            // DEFAULT FALSE
            eReference.setUnsettable(true);
            break;
          default:
            break;
        }
      }
    }

    if (ctx.name == null) {
      eReference.setName(null);
    }

    return eReference;
  }

  int oc = 0;

  @Override
  public EOperation visitEOperation(final EOperationContext ctx) {
    String name = "operation" + ++oc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    CS2ASMapping.qualifiedNameStack.push(name);
    final EOperation eOperation =
        (EOperation) CS2ASRepository.getEObject(CS2ASMapping.qualifiedNameStack);
    CS2ASMapping.qualifiedNameStack.pop();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      eOperation.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

    if (ctx.ownedSignature != null) {
      final List<ETypeParameter> eTypeParameters = visitTemplateSignature(ctx.ownedSignature);
      eOperation.getETypeParameters().addAll(eTypeParameters);
    }

    if (ctx.eParameters != null) {
      ctx.eParameters.forEach(ep -> {
        final EParameter eParameter = visitEParameter(ep);
        eOperation.getEParameters().add(eParameter);
      });
    }

    if (ctx.ownedMultiplicity != null) {
      final int[] multiplicity = visitEMultiplicity(ctx.ownedMultiplicity);
      eOperation.setLowerBound(multiplicity[0]);
      eOperation.setUpperBound(multiplicity[1]);
      if (isCollection(eOperation, ctx.ownedMultiplicity)) {
        final EAnnotation nullableAnnotation = createEAnnotation(AnnotationSources.NULLABLE);
        // DEFAULT NULL
        eOperation.getEAnnotations().add(nullableAnnotation);
      }
    } else { // DEFAULT 1..1
      eOperation.setLowerBound(1);
      eOperation.setUpperBound(1);
    }

    if (ctx.eReturnType != null) {
      final EObject typedRef = visitETypeRef(ctx.eReturnType);
      if (typedRef instanceof EClassifier) {
        eOperation.setEType((EClassifier) typedRef);
      } else if (typedRef instanceof EGenericType) {
        eOperation.setEGenericType((EGenericType) typedRef);
      }
    }

    if (ctx.ownedException != null) {
      ctx.ownedException.forEach(oe -> {
        final EGenericType eException = visitEException(oe);
        if (eException != null) {
          eOperation.getEGenericExceptions().add(eException);
        }
      });
    }

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation eAnnotation = visitEAnnotation(oa);
        eOperation.getEAnnotations().add(eAnnotation);
      });
    }

    if (ctx.ownedPreconditions != null) {
      ctx.ownedPreconditions.forEach(opc -> {
        final EAnnotation preconditionAnnotation = visitPrecondition(opc);
        eOperation.getEAnnotations().add(preconditionAnnotation);
      });
    }

    if (ctx.ownedBodyExpression != null) {
      ctx.ownedBodyExpression.forEach(obe -> {
        final EAnnotation bodyAnnotation = visitBody(obe);
        eOperation.getEAnnotations().add(bodyAnnotation);
      });
    }

    if (ctx.ownedPostconditions != null) {
      ctx.ownedPostconditions.forEach(opc -> {
        final EAnnotation postconditionAnnotation = visitPostcondition(opc);
        eOperation.getEAnnotations().add(postconditionAnnotation);
      });
    }

    eOperation.setOrdered(false);
    if (ctx.eReturnType != null) {
      if (ctx.qualifier != null) {
        for (final String q : ctx.qualifier.stream().map(Token::getText).distinct()
            .collect(Collectors.toList())) {
          switch (AIEConstants.getValue(q)) {
            case STATIC:
              final EAnnotation staticAnnotation = createEAnnotation(AnnotationSources.STATIC);
              // DEFAULT NULL
              eOperation.getEAnnotations().add(staticAnnotation);
              break;
            case NULLABLE:
              int u = eOperation.getUpperBound();
              if (u > 1
                  || u == -1 && eOperation.getEAnnotation(AnnotationSources.NULLABLE) == null) {
                final EAnnotation nullableAnnotation =
                    createEAnnotation(AnnotationSources.NULLABLE);
                // DEFAULT NULL
                eOperation.getEAnnotations().add(nullableAnnotation);
              }
              break;
            case ORDERED:
              u = eOperation.getUpperBound();
              if (u > 1 || u == -1) {
                // DEFAULT FALSE
                eOperation.setOrdered(true);
              }
              break;
            case NOT_UNIQUE:
              u = eOperation.getUpperBound();
              if (u > 1 || u == -1) {
                // DEFAULT TRUE
                eOperation.setUnique(false);
              }
              break;
            default:
              break;
          }
        }
      }
    }

    if (ctx.name == null) {
      eOperation.setName(null);
    }

    return eOperation;
  }

  @Override
  public EGenericType visitEException(final EExceptionContext ctx) {
    if (ctx.eGenericTypeRef() == null) {
      return null;
    }
    return visitEGenericTypeRef(ctx.eGenericTypeRef());
  }

  @Override
  public EParameter visitEParameter(final EParameterContext ctx) {
    final EParameter eParameter = CS2ASRepository.factory.createEParameter();

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eParameter.setName(name);
    }

    if (ctx.eParameterType != null) {
      final EObject typedRef = visitETypeRef(ctx.eParameterType);
      if (typedRef instanceof EClassifier) {
        eParameter.setEType((EClassifier) typedRef);
      } else if (typedRef instanceof EGenericType) {
        eParameter.setEGenericType((EGenericType) typedRef);
      }
    }

    if (ctx.ownedMultiplicity != null) {
      final int[] multiplicity = visitEMultiplicity(ctx.ownedMultiplicity);
      eParameter.setLowerBound(multiplicity[0]);
      eParameter.setUpperBound(multiplicity[1]);
      if (isCollection(eParameter, ctx.ownedMultiplicity)) {
        final EAnnotation nullableAnnotation = createEAnnotation(AnnotationSources.NULLABLE);
        // DEFAULT NULL
        eParameter.getEAnnotations().add(nullableAnnotation);
      }
    } else { // DEFAULT 1..1
      eParameter.setLowerBound(1);
      eParameter.setUpperBound(1);
    }

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation eAnnotation = visitEAnnotation(oa);
        eParameter.getEAnnotations().add(eAnnotation);
      });
    }

    eParameter.setOrdered(false);
    if (ctx.qualifier != null) {
      for (final String q : ctx.qualifier.stream().map(Token::getText).distinct()
          .collect(Collectors.toList())) {
        switch (AIEConstants.getValue(q)) {
          case NULLABLE:
            int u = eParameter.getUpperBound();
            if (u > 1 || u == -1 && eParameter.getEAnnotation(AnnotationSources.NULLABLE) == null) {
              final EAnnotation nullableAnnotation = createEAnnotation(AnnotationSources.NULLABLE);
              // DEFAULT NULL
              eParameter.getEAnnotations().add(nullableAnnotation);
            }
            break;
          case ORDERED:
            u = eParameter.getUpperBound();
            if (u > 1 || u == -1) {
              // DEFAULT FALSE
              eParameter.setOrdered(true);
            }
            break;
          case NOT_UNIQUE:
            u = eParameter.getUpperBound();
            if (u > 1 || u == -1) {
              // DEFAULT TRUE
              eParameter.setUnique(false);
            }
            break;
          default:
            break;
        }
      }
    }

    return eParameter;
  }

  @Override
  public int[] visitEMultiplicity(final EMultiplicityContext ctx) {
    int lower = 0;
    int upper = 1;
    if (ctx.stringBound != null) {
      final String stringBound = ctx.stringBound.getText();
      switch (stringBound) {
        case "*":
          lower = 0;
          upper = -1;
          break;
        case "+":
          lower = 1;
          upper = -1;
          break;
        case "?":
          lower = 0;
          upper = 1;
          break;
        default:
          break;
      }
    } else {
      if (ctx.lowerBound != null) {
        lower = Integer.valueOf(ctx.lowerBound.getText());
      }
      if (ctx.upperBound != null) {
        upper = Integer.valueOf(ctx.upperBound.getText());
      } else {
        upper = lower;
      }
    }
    // TODO ('|?' | isNullFree= '|1')? nullfree annotation will be added.
    return new int[] {lower, upper};
  }

  int dtc = 0;

  @Override
  public EDataType visitEDataType(final EDataTypeContext ctx) {
    String name = "datatype" + ++dtc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    CS2ASMapping.qualifiedNameStack.push(name);
    final EDataType eDataType =
        (EDataType) CS2ASRepository.getEObject(CS2ASMapping.qualifiedNameStack);

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      eDataType.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

    if (ctx.ownedSignature != null) {
      final List<ETypeParameter> eTypeParameters = visitTemplateSignature(ctx.ownedSignature);
      eDataType.getETypeParameters().addAll(eTypeParameters);
    }

    if (ctx.instanceClassName != null) {
      final String instanceClassName = ctx.instanceClassName.getText().replace("'", "");
      eDataType.setInstanceClassName(instanceClassName);
    }

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation eAnnotation = visitEAnnotation(oa);
        eDataType.getEAnnotations().add(eAnnotation);
      });
    }

    if (ctx.ownedConstraints != null) {
      ctx.ownedConstraints.forEach(oc -> {
        final EAnnotation invariantAnnotation = visitInvariant(oc);
        eDataType.getEAnnotations().add(invariantAnnotation);
      });
    }

    if (ctx.qualifier != null) {
      for (final String q : ctx.qualifier.stream().map(Token::getText).distinct()
          .collect(Collectors.toList())) {
        switch (AIEConstants.getValue(q)) {
          case PRIMITIVE:
            final EAnnotation primitiveAnnotation =
            createEAnnotation(AnnotationSources.DATATYPE_PRIMITIVE);
            // DEFAULT NULL
            eDataType.getEAnnotations().add(primitiveAnnotation);
            break;
          case NULLABLE:
            final EAnnotation nullableAnnotation = createEAnnotation(AnnotationSources.NULLABLE);
            // DEFAULT NULL
            eDataType.getEAnnotations().add(nullableAnnotation);
            break;
          case NOT_SERIALIZABLE:
            // DEFAULT TRUE.
            eDataType.setSerializable(false);
            break;
          default:
            break;
        }
      }
    }

    if (ctx.name == null) {
      eDataType.setName(null);
    }

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

  int ec = 0;

  @Override
  public EEnum visitEEnum(final EEnumContext ctx) {
    String name = "enum" + ++ec;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    CS2ASMapping.qualifiedNameStack.push(name);
    final EEnum eEnum = (EEnum) CS2ASRepository.getEObject(CS2ASMapping.qualifiedNameStack);

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      eEnum.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

    if (ctx.ownedSignature != null) {
      final List<ETypeParameter> eTypeParameters = visitTemplateSignature(ctx.ownedSignature);
      eEnum.getETypeParameters().addAll(eTypeParameters);
    }

    if (ctx.instanceClassName != null) {
      final String instanceClassName = ctx.instanceClassName.getText().replace("'", "");
      eEnum.setInstanceClassName(instanceClassName);
    }

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation eAnnotation = visitEAnnotation(oa);
        eEnum.getEAnnotations().add(eAnnotation);
      });
    }

    if (ctx.ownedLiteral != null) {
      ctx.ownedLiteral.forEach(l -> {
        final EEnumLiteral eEnumLiteral = visitEEnumLiteral(l);
        eEnum.getELiterals().add(eEnumLiteral);
      });
    }

    if (ctx.ownedConstraint != null) {
      ctx.ownedConstraint.forEach(oc -> {
        final EAnnotation invariantAnnotation = visitInvariant(oc);
        eEnum.getEAnnotations().add(invariantAnnotation);
      });
    }

    if (ctx.qualifier != null) {
      for (final String q : ctx.qualifier.stream().map(Token::getText).distinct()
          .collect(Collectors.toList())) {
        switch (AIEConstants.getValue(q)) {
          case NOT_SERIALIZABLE:
            // DEFAULT TRUE.
            eEnum.setSerializable(false);
            break;
          default:
            break;
        }
      }
    }

    if (ctx.name == null) {
      eEnum.setName(null);
    }

    CS2ASMapping.qualifiedNameStack.pop();
    return eEnum;
  }

  @Override
  public EEnumLiteral visitEEnumLiteral(final EEnumLiteralContext ctx) {
    final EEnumLiteral eEnumLiteral = CS2ASRepository.factory.createEEnumLiteral();

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eEnumLiteral.setName(name);
    }

    if (ctx.value != null) {
      final int value = Integer.parseInt(ctx.value.getText());
      eEnumLiteral.setValue(value);
    }

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation eAnnotation = visitEAnnotation(oa);
        eEnumLiteral.getEAnnotations().add(eAnnotation);
      });
    }

    return eEnumLiteral;
  }

  @Override
  public EAnnotation visitEAnnotation(final EAnnotationContext ctx) {
    final String source = ctx.source != null ? ctx.source.getText().replace("'", "") : null;
    final EAnnotation eAnnotation = createEAnnotation(source);

    if (ctx.ownedDetails != null) {
      ctx.ownedDetails.forEach(od -> {
        final String key = od.key != null ? od.key.getText().replace("'", "") : null;
        final String value = od.value != null ? od.value.getText().replace("'", "") : null;
        eAnnotation.getDetails().put(key, value);
      });
    }

    if (ctx.ownedAnnotations != null) {
      ctx.ownedAnnotations.forEach(oa -> {
        final EAnnotation ownedAnnoation = visitEAnnotation(oa);
        eAnnotation.getEAnnotations().add(ownedAnnoation);
      });
    }

    if (ctx.ownedContents != null) {
      ctx.ownedContents.forEach(oc -> {
        final EModelElement eModelElement = visitEModelElement(oc);
        eAnnotation.getContents().add(eModelElement);
      });
    }

    if (ctx.ownedReferences != null) {
      ctx.ownedReferences.forEach(or -> {
        final EObject eModelElementRef = visitEModelElementRef(or);
        if (eModelElementRef != null) {
          eAnnotation.getReferences().add(eModelElementRef);
        }
      });
    }

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
    if (ctx.ownedPathName == null) {
      return null;
    }
    return visitPathName(ctx.ownedPathName);
  }

  @Override
  public List<ETypeParameter> visitTemplateSignature(final TemplateSignatureContext ctx) {
    if (ctx.ownedTypeParameters == null) {
      return new ArrayList<>();
    }
    return ctx.ownedTypeParameters.stream().map(op -> visitETypeParameter(op))
        .collect(Collectors.toList());
  }

  int tpc = 0;

  @Override
  public ETypeParameter visitETypeParameter(final ETypeParameterContext ctx) {
    String name = "typeparameter" + ++tpc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    CS2ASMapping.qualifiedNameStack.push(name);
    final ETypeParameter eTypeParameter =
        (ETypeParameter) CS2ASRepository.getEObject(CS2ASMapping.qualifiedNameStack);
    CS2ASMapping.qualifiedNameStack.pop();

    if (ctx.ownedEBounds != null) {
      ctx.ownedEBounds.forEach(oe -> {
        final EGenericType eBound = visitEGenericTypeRef(oe);
        if (eBound != null) {
          eTypeParameter.getEBounds().add(eBound);
        }
      });
    }

    if (ctx.name == null) {
      eTypeParameter.setName(null);
    }

    return eTypeParameter;
  }

  @Override
  public EObject visitETypeRef(final ETypeRefContext ctx) {
    return (EObject) super.visitETypeRef(ctx);
  }

  @Override
  public EGenericType visitEGenericTypeRef(final EGenericTypeRefContext ctx) {
    final EGenericType eGenericType = CS2ASRepository.factory.createEGenericType();

    if (ctx.ownedPathName == null) {
      return null;
    }

    final EObject object = visitPathName(ctx.ownedPathName);
    if (object instanceof EClassifier) {
      eGenericType.setEClassifier((EClassifier) object);
    } else if (object instanceof ETypeParameter) {
      eGenericType.setETypeParameter((ETypeParameter) object);
    } else {
      return null;
    }

    if (ctx.ownedETypeArguments != null) {
      if (object instanceof EClassifier) {
        ctx.ownedETypeArguments.forEach(eta -> {
          final EGenericType eGenericTypeArgument = visitEGenericTypeArgument(eta);
          if (eGenericTypeArgument != null) {
            eGenericType.getETypeArguments().add(eGenericTypeArgument);
          }
        });
      }
    }

    return eGenericType;
  }

  @Override
  public EGenericType visitEGenericTypeArgument(final EGenericTypeArgumentContext ctx) {
    return (EGenericType) super.visitEGenericTypeArgument(ctx);
  }

  @Override
  public EGenericType visitWildcardTypeRef(final WildcardTypeRefContext ctx) {
    final EGenericType eGenericType = CS2ASRepository.factory.createEGenericType();

    if (ctx.ownedExtends != null) {
      final EGenericType boundType = visitEGenericTypeRef(ctx.ownedExtends);
      if (boundType != null) {
        if (ctx.bound != null) {
          if (ctx.bound.getText().equals("extends")) {
            eGenericType.setEUpperBound(boundType);
          } else if (ctx.bound.getText().equals("super")) {
            eGenericType.setELowerBound(boundType);
          }
        }
      }
    }

    return eGenericType;
  }

  @Override
  public EObject visitPathName(final PathNameContext ctx) {
    String moduleName = null;
    String objectName = null;
    List<String> relativePathFragments = new ArrayList<>();

    if (ctx.ownedPathElements == null) {
      return null;
    }

    final UnrestrictedNameContext firstPart = ctx.ownedPathElements.get(0);
    final UnrestrictedNameContext lastPart = ctx.ownedPathElements.size() > 1
        ? ctx.ownedPathElements.get(ctx.ownedPathElements.size() - 1) : null;

        if (CS2ASRepository.name2Module.containsKey(firstPart.getText())) {
          moduleName = firstPart.getText();
        } else {
          moduleName = CS2ASRepository.root.getName();
          relativePathFragments.add(firstPart.getText());
        }

        if (ctx.ownedPathElements.size() > 2) {
          // we have : RootName.Some.Sub.Names.classifier || SiblingName.Some.Sub.Names.classifier
          // we have : RootName.Some.Sub.Names.featureName || SiblingName.Some.Sub.Names.featureName
          // we have : RootName.Some.Sub.Names.operationName ||
          // SiblingName.Some.Sub.Names.operationName
          relativePathFragments =
              ctx.ownedPathElements.stream().map(ope -> ope.getText()).collect(Collectors.toList());
          relativePathFragments.remove(0); // remove first part
          relativePathFragments.remove(relativePathFragments.size() - 1); // remove last part
        } else {
          if (lastPart == null) {
            // we have : SiblingName
            objectName = firstPart.getText();

            relativePathFragments =
                CS2ASMapping.qualifiedNameStack.stream().collect(Collectors.toList());
            relativePathFragments.remove(0);
            relativePathFragments.add(objectName);

            final EObject eObject = CS2ASRepository.getEObject(moduleName, relativePathFragments);
            if (eObject != null) { // GenericTypeArgument
              return eObject;
            }

            final String sibling = CS2ASMapping.qualifiedNameStack.pop();
            relativePathFragments =
                CS2ASMapping.qualifiedNameStack.stream().collect(Collectors.toList());
            relativePathFragments.remove(0);
            CS2ASMapping.qualifiedNameStack.push(sibling);
          }
        }

        if (lastPart != null) {
          objectName = lastPart.getText();
        }

        if (objectName != null) {
          relativePathFragments.add(objectName);
        }

        return CS2ASRepository.getEObject(moduleName, relativePathFragments);
  }

  @Override
  public EAnnotation visitBody(final BodyContext ctx) {
    final String source = AnnotationSources.BODY;
    final EAnnotation eAnnotation = createEAnnotation(source);

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eAnnotation.getDetails().put(AIEConstants.NAME.toString(), name);
    }

    if (ctx.ownedExpression != null) {
      final String expression = visitExpression(ctx.ownedExpression);
      eAnnotation.getDetails().put(AIEConstants.EXPRESSION.toString(), expression);
    }

    return eAnnotation;
  }

  @Override
  public EAnnotation visitInvariant(final InvariantContext ctx) {
    final String source = AnnotationSources.INVARIANT;
    final EAnnotation eAnnotation = createEAnnotation(source);

    final Boolean isCallable = ctx.isCallable != null ? true : false;
    eAnnotation.getDetails().put(AIEConstants.CALLABLE.toString(), isCallable.toString());

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eAnnotation.getDetails().put(AIEConstants.NAME.toString(), name);
    }

    if (ctx.message != null) {
      final String message = ctx.message.getText().replace("\"", "");
      eAnnotation.getDetails().put(AIEConstants.MESSAGE.toString(), message);
    }

    if (ctx.ownedSpecification != null) {
      final String formula = visitFormula(ctx.ownedSpecification);
      eAnnotation.getDetails().put(AIEConstants.FORMULA.toString(), formula);
    }

    return eAnnotation;
  }

  @Override
  public EAnnotation visitPrecondition(final PreconditionContext ctx) {
    final String source = AnnotationSources.PRECONDITION;
    final EAnnotation eAnnotation = createEAnnotation(source);

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eAnnotation.getDetails().put(AIEConstants.NAME.toString(), name);
    }

    if (ctx.message != null) {
      final String message = ctx.message.getText().replace("\"", "");
      eAnnotation.getDetails().put(AIEConstants.MESSAGE.toString(), message);
    }

    if (ctx.ownedSpecification != null) {
      final String formula = visitFormula(ctx.ownedSpecification);
      eAnnotation.getDetails().put(AIEConstants.FORMULA.toString(), formula);
    }

    return eAnnotation;
  }

  @Override
  public EAnnotation visitPostcondition(final PostconditionContext ctx) {
    final String source = AnnotationSources.POSTCONDITION;
    final EAnnotation eAnnotation = createEAnnotation(source);

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eAnnotation.getDetails().put(AIEConstants.NAME.toString(), name);
    }

    if (ctx.message != null) {
      final String message = ctx.message.getText().replace("\"", "");
      eAnnotation.getDetails().put(AIEConstants.MESSAGE.toString(), message);
    }

    if (ctx.ownedSpecification != null) {
      final String formula = visitFormula(ctx.ownedSpecification);
      eAnnotation.getDetails().put(AIEConstants.FORMULA.toString(), formula);
    }

    return eAnnotation;
  }

  @Override
  public EAnnotation visitInitial(final InitialContext ctx) {
    final EAnnotation initialAnnotation = createEAnnotation(AnnotationSources.INITIAL);

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      initialAnnotation.getDetails().put(AIEConstants.NAME.toString(), name);
    }

    if (ctx.ownedExpression != null) {
      final String expression = visitExpression(ctx.ownedExpression);
      initialAnnotation.getDetails().put(AIEConstants.EXPRESSION.toString(), expression);
    }

    return initialAnnotation;
  }

  @Override
  public EAnnotation visitDerivation(final DerivationContext ctx) {
    final EAnnotation derivedAnnotation = createEAnnotation(AnnotationSources.DERIVATION);

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      derivedAnnotation.getDetails().put(AIEConstants.NAME.toString(), name);
    }

    if (ctx.ownedExpression != null) {
      final String expression = visitExpression(ctx.ownedExpression);
      derivedAnnotation.getDetails().put(AIEConstants.EXPRESSION.toString(), expression);
    }

    return derivedAnnotation;
  }

  public String visitExpression(final ExpressionContext ctx) {
    if (ctx.start == null || ctx.stop == null) {
      return "";
    }
    return getTokenString(ctx.start.getStartIndex(), ctx.stop.getStopIndex() + 1);
  }

  public String visitFormula(final FormulaContext ctx) {
    if (ctx.start == null || ctx.stop == null) {
      return "";
    }
    return getTokenString(ctx.start.getStartIndex(), ctx.stop.getStopIndex() + 1);
  }

  private String getTokenString(final int start, final int end) {
    return fileInput.substring(start, end);
  }

  private boolean isCollection(final ETypedElement element, final EMultiplicityContext ctx) {
    return (element.getUpperBound() > 1 || element.getUpperBound() == -1) && ctx.isNullFree != null;
  }

  public void saveResource(final EObject root, final URI saveURI) {
    EcoreUtilities.saveResource(root, saveURI);
  }
}
