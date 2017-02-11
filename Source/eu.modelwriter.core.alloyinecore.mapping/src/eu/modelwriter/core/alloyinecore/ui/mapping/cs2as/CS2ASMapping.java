package eu.modelwriter.core.alloyinecore.ui.mapping.cs2as;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
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
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericElementTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericExceptionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericSuperTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeArgumentContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericWildcardContext;
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
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypedElementContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.FormulaContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InitialContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModelContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionsContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PathNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PostconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PreconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.ui.mapping.AIEConstants;
import eu.modelwriter.core.alloyinecore.ui.mapping.AnnotationSources;

public class CS2ASMapping extends AlloyInEcoreBaseVisitor<Object> {

  private Stack<String> qualifiedNameStack;
  private CS2ASRepository repository;
  private CS2ASInitializer initializer;
  private String fileInput;
  private boolean anySyntacticError;

  private void init() {
    qualifiedNameStack = new Stack<>();
    repository = new CS2ASRepository();
    initializer = new CS2ASInitializer(repository);
    pc = 0;
    cc = 0;
    ac = 0;
    rc = 0;
    oc = 0;
    dtc = 0;
    ec = 0;
    tpc = 0;
  }

  /**
   *
   * @param fileInput : alloy in ecore program input.
   * @param savePath : save location for ecore file.
   */
  public void parseAndSave(final String fileInput, final URI saveURI) {
    init();

    this.fileInput = fileInput;
    anySyntacticError = false;

    final ANTLRInputStream inputStream = new ANTLRInputStream(fileInput);
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(inputStream);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens, saveURI);
    parser.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol,
          final int line, final int charPositionInLine, final String msg,
          final RecognitionException e) {
        anySyntacticError = true;
      }
    });
    final ParseTree tree = parser.model();

    // load old ecore root.
    final EModelElement oldRoot = (EModelElement) repository.loadAndClearAIEResource(saveURI);

    initializer.initialize(tree);
    try {
      visit(tree);

      if (anySyntacticError) {
        throw new Exception();
      }

      // if there is not any parse error,
      // then remove old source annotation and finally save ecore.
      repository.getRootPackage().getEAnnotations()
      .removeIf(ea -> ea.getSource().equals(AnnotationSources.SOURCE));

      repository.saveResource(repository.getRootPackage(), saveURI);
    } catch (final Exception e) {
      // if there exists any parse error,
      // then save aie source as annotation.

      // first remove old source annotation from old ecore root.
      oldRoot.getEAnnotations().removeIf(ea -> ea.getSource().equals(AnnotationSources.SOURCE));

      // add new source annotation to old ecore root and finally save old ecore.
      final EAnnotation sourceAnnotation = createEAnnotation(AnnotationSources.SOURCE);
      sourceAnnotation.getDetails().put(AIEConstants.SOURCE.toString(), fileInput);
      oldRoot.getEAnnotations().add(sourceAnnotation);

      repository.saveResource(oldRoot, saveURI);
    }
  }

  @Override
  public Object visitModel(final ModelContext ctx) {
    final List<EAnnotation> importAnnotations = new ArrayList<>();
    ctx.ownedPackageImport.forEach(opi -> {
      final EAnnotation importAnnotation = visitPackageImport(opi);
      importAnnotations.add(importAnnotation);
    });

    if (ctx.ownedPackage != null) {
      visitEPackage(ctx.ownedPackage);
    }

    if (ctx.options() != null) {
      final EAnnotation optionsAnnotation = visitOptions(ctx.options());
      repository.getRootPackage().getEAnnotations().add(optionsAnnotation);
    }

    if (ctx.identifier() != null) {
      final EAnnotation moduleAnnotation = createEAnnotation(AnnotationSources.MODULE);
      if (ctx.name != null) {
        moduleAnnotation.getDetails().put(AIEConstants.NAME.toString(), ctx.name.getText());
      }
      repository.getRootPackage().getEAnnotations().add(moduleAnnotation);
    }

    repository.getRootPackage().getEAnnotations().addAll(importAnnotations);

    // final Diagnostic diagnostic = Diagnostician.INSTANCE.validate(repository.getRootPackage());
    // visitDiagnostic(diagnostic);

    return null;
  }

  // private int level = 0;

  // public void visitDiagnostic(final Diagnostic diagnostic) throws Exception {
  // level++;
  // if (diagnostic.getSeverity() == Diagnostic.ERROR) {
  // System.err.println("(lvl:" + level + ")source : " + diagnostic.getSource());
  // System.err.println("(lvl:" + level + ")message: " + diagnostic.getMessage());
  // diagnostic.getData().forEach(d -> {
  // System.err.println(d.toString());
  // });
  // }
  // diagnostic.getChildren().forEach(c -> {
  // visitDiagnostic(c);
  // });
  // level--;
  // }

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

  private int pc = 0;

  @Override
  public EPackage visitEPackage(final EPackageContext ctx) {
    String name = "package" + ++pc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    qualifiedNameStack.push(name);
    final EPackage ePackage = (EPackage) repository.getEObject(qualifiedNameStack);

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

    qualifiedNameStack.pop();
    return ePackage;
  }

  @Override
  public EClassifier visitEClassifier(final EClassifierContext ctx) {
    if (ctx.eClass != null) {
      return visitEClass(ctx.eClass);
    }
    if (ctx.eDataType != null) {
      return visitEDataType(ctx.eDataType);
    }
    if (ctx.eEnum != null) {
      return visitEEnum(ctx.eEnum);
    }
    return null;
  }

  private int cc = 0;

  @Override
  public EClass visitEClass(final EClassContext ctx) {
    String name = "class" + ++cc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    qualifiedNameStack.push(name);
    final EClass eClass = (EClass) repository.getEObject(qualifiedNameStack);

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
        final EGenericType superType = visitEGenericSuperType(est);
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

    qualifiedNameStack.pop();
    return eClass;
  }

  @Override
  public EStructuralFeature visitEStructuralFeature(final EStructuralFeatureContext ctx) {
    if (ctx.eAttribute != null) {
      return visitEAttribute(ctx.eAttribute);
    }
    if (ctx.eReference != null) {
      return visitEReference(ctx.eReference);
    }
    return null;
  }

  private int ac = 0;

  @Override
  public EAttribute visitEAttribute(final EAttributeContext ctx) {
    String name = "attribute" + ++ac;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    qualifiedNameStack.push(name);
    final EAttribute eAttribute = (EAttribute) repository.getEObject(qualifiedNameStack);
    qualifiedNameStack.pop();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      eAttribute.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

    if (ctx.eAttributeType != null) {
      final EGenericType eGenericType = visitEGenericElementType(ctx.eAttributeType);
      if (eGenericType != null) {
        eAttribute.setEGenericType(eGenericType);
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
            int u = eAttribute.getUpperBound();
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

  private int rc = 0;

  @Override
  public EReference visitEReference(final EReferenceContext ctx) {
    String name = "reference" + ++rc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    qualifiedNameStack.push(name);
    final EReference eReference = (EReference) repository.getEObject(qualifiedNameStack);
    qualifiedNameStack.pop();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      eReference.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

    if (ctx.eReferenceType != null) {
      final EGenericType eGenericType = visitEGenericElementType(ctx.eReferenceType);
      // TODO should be visitEGenericType(ctx.eReferenceType)!
      if (eGenericType != null) {
        eReference.setEGenericType(eGenericType);
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
            int u = eReference.getUpperBound();
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

  private int oc = 0;

  @Override
  public EOperation visitEOperation(final EOperationContext ctx) {
    String name = "operation" + ++oc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    qualifiedNameStack.push(name);
    final EOperation eOperation = (EOperation) repository.getEObject(qualifiedNameStack);

    if (ctx.ownedSignature != null) {
      final List<ETypeParameter> eTypeParameters = visitTemplateSignature(ctx.ownedSignature);
      eOperation.getETypeParameters().addAll(eTypeParameters);
    }

    qualifiedNameStack.pop();

    if (ctx.visibility != null) {
      final EAnnotation visibilityAnnotation = createEAnnotation(AnnotationSources.VISIBILITY);
      visibilityAnnotation.getDetails().put(AIEConstants.VISIBILITY.toString(),
          ctx.visibility.getText());
      eOperation.getEAnnotations().add(visibilityAnnotation);
    } // DEFAULT PACKAGE

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
      final EGenericType eGenericType = visitEGenericElementType(ctx.eReturnType);
      if (eGenericType != null) {
        eOperation.setEGenericType(eGenericType);
      }
    }

    if (ctx.ownedException != null) {
      ctx.ownedException.forEach(oe -> {
        final EGenericType eException = visitEGenericException(oe);
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
            case ORDERED:
              int u = eOperation.getUpperBound();
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
  public EGenericType visitEGenericException(final EGenericExceptionContext ctx) {
    if (ctx.eGenericType != null) {
      return visitEGenericType(ctx.eGenericType);
    }
    return null;
  }

  @Override
  public EGenericType visitEGenericSuperType(final EGenericSuperTypeContext ctx) {
    if (ctx.eGenericType != null) {
      return visitEGenericType(ctx.eGenericType);
    }
    return null;
  }

  @Override
  public EParameter visitEParameter(final EParameterContext ctx) {
    final EParameter eParameter = repository.factory.createEParameter();

    if (ctx.name != null) {
      final String name = ctx.name.getText();
      eParameter.setName(name);
    }

    if (ctx.eParameterType != null) {
      final EGenericType eGenericType = visitEGenericElementType(ctx.eParameterType);
      if (eGenericType != null) {
        eParameter.setEGenericType(eGenericType);
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
          case ORDERED:
            int u = eParameter.getUpperBound();
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
    int lower = 1;
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
        if (ctx.upperBound.getText().equals("*")) {
          upper = -1;
        } else {
          upper = Integer.valueOf(ctx.upperBound.getText());
        }
      } else {
        upper = lower;
      }
    }
    // TODO ('|?' | isNullFree= '|1')? nullfree annotation will be added.
    return new int[] {lower, upper};
  }

  private int dtc = 0;

  @Override
  public EDataType visitEDataType(final EDataTypeContext ctx) {
    String name = "datatype" + ++dtc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    qualifiedNameStack.push(name);
    final EDataType eDataType = (EDataType) repository.getEObject(qualifiedNameStack);

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

    qualifiedNameStack.pop();
    return eDataType;
  }

  private int ec = 0;

  @Override
  public EEnum visitEEnum(final EEnumContext ctx) {
    String name = "enum" + ++ec;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    qualifiedNameStack.push(name);
    final EEnum eEnum = (EEnum) repository.getEObject(qualifiedNameStack);

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

    qualifiedNameStack.pop();
    return eEnum;
  }

  @Override
  public EEnumLiteral visitEEnumLiteral(final EEnumLiteralContext ctx) {
    final EEnumLiteral eEnumLiteral = repository.factory.createEEnumLiteral();

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
    final EAnnotation eAnnotation = repository.factory.createEAnnotation();

    eAnnotation.setSource(source);

    return eAnnotation;
  }

  @Override
  public EModelElement visitEModelElement(final EModelElementContext ctx) {
    if (ctx.eAnnotation != null) {
      return visitEAnnotation(ctx.eAnnotation);
    }
    if (ctx.eNamedElement != null) {
      return visitENamedElement(ctx.eNamedElement);
    }
    return null;
  }

  @Override
  public ENamedElement visitENamedElement(final ENamedElementContext ctx) {
    if (ctx.eTypedElement != null) {
      return visitETypedElement(ctx.eTypedElement);
    }
    if (ctx.eClassifier != null) {
      return visitEClassifier(ctx.eClassifier);
    }
    if (ctx.ePackage != null) {
      return visitEPackage(ctx.ePackage);
    }
    if (ctx.eEnumLiteral != null) {
      return visitEEnumLiteral(ctx.eEnumLiteral);
    }
    return null;
  }

  @Override
  public ETypedElement visitETypedElement(final ETypedElementContext ctx) {
    if (ctx.eOperation != null) {
      return visitEOperation(ctx.eOperation);
    }
    if (ctx.eParameter != null) {
      return visitEParameter(ctx.eParameter);
    }
    if (ctx.eStructuralFeature != null) {
      return visitEStructuralFeature(ctx.eStructuralFeature);
    }
    return null;
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

  private int tpc = 0;

  @Override
  public ETypeParameter visitETypeParameter(final ETypeParameterContext ctx) {
    String name = "typeparameter" + ++tpc;
    if (ctx.name != null) {
      name = ctx.name.getText();
    }
    qualifiedNameStack.push(name);
    final ETypeParameter eTypeParameter =
        (ETypeParameter) repository.getEObject(qualifiedNameStack);
    qualifiedNameStack.pop();

    if (ctx.ownedEBounds != null) {
      ctx.ownedEBounds.forEach(oe -> {
        final EGenericType eBound = visitEGenericType(oe);
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
  public EGenericType visitEGenericTypeArgument(final EGenericTypeArgumentContext ctx) {
    if (ctx.eGenericType != null) {
      return visitEGenericType(ctx.eGenericType);
    }
    if (ctx.eGenericWildcard != null) {
      return visitEGenericWildcard(ctx.eGenericWildcard);
    }
    return null;
  }

  @Override
  public EGenericType visitEGenericType(final EGenericTypeContext ctx) {
    final EGenericType eGenericType = repository.factory.createEGenericType();

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
  public EGenericType visitEGenericElementType(final EGenericElementTypeContext ctx) {
    if (ctx.eGenericType != null) {
      return visitEGenericType(ctx.eGenericType);
    }
    if (ctx.ePrimitiveType != null) {
      return visitEPrimitiveType(ctx.ePrimitiveType);
    }
    return null;
  }

  @Override
  public EGenericType visitEGenericWildcard(final EGenericWildcardContext ctx) {
    final EGenericType eGenericType = repository.factory.createEGenericType();

    if (ctx.ownedExtend != null) {
      final EGenericType boundType = visitEGenericType(ctx.ownedExtend);
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
    String rootElementName;
    final List<String> relativePathFragments =
        new ArrayList<>(Arrays.asList(ctx.getText().split(AIEConstants.SEPARATOR)));

    if (repository.name2Import.containsKey(ctx.firstSegment.getText())) { // full path
      rootElementName = ctx.firstSegment.getText();
      relativePathFragments.remove(0); // root is unnecessary.

      return repository.getEObject(rootElementName, relativePathFragments);
    } else { // relative path
      rootElementName = repository.getRootPackage().getName();

      final List<String> complementPathFragments =
          qualifiedNameStack.stream().collect(Collectors.toList());
      complementPathFragments.remove(0); // root is unnecessary.

      // 1. trying to find inner reference (like reference to TypeParameter):
      final List<String> tempFragments = new ArrayList<>(relativePathFragments);
      tempFragments.addAll(0, complementPathFragments);
      final EObject result = repository.getEObject(rootElementName, tempFragments);
      if (result != null) {
        return result;
      }

      // 2. trying to find outer reference (like reference to sibling et cetera.)
      complementPathFragments.remove(complementPathFragments.size() - 1);
      // first remove reference holder (last item of qualified name stack.).
      relativePathFragments.addAll(0, complementPathFragments);
      return repository.getEObject(rootElementName, relativePathFragments);
    }
  }

  @Override
  public EGenericType visitEPrimitiveType(final EPrimitiveTypeContext ctx) {
    EGenericType eGenericType = repository.factory.createEGenericType();
    switch (ctx.getText()) {
      case "Boolean": // EBoolean
        eGenericType.setEClassifier(EcorePackage.eINSTANCE.getEBoolean());
        break;
      case "Integer": // EBigInteger
        eGenericType.setEClassifier(EcorePackage.eINSTANCE.getEInt());
        break;
      case "String": // EString
        eGenericType.setEClassifier(EcorePackage.eINSTANCE.getEString());
        break;
      case "Real": // EBigDecimal
        eGenericType.setEClassifier(EcorePackage.eINSTANCE.getEBigDecimal());
        break;
      case "UnlimitedNatural": // EBigInteger
        eGenericType.setEClassifier(EcorePackage.eINSTANCE.getEBigInteger());
        break;
      default:
        eGenericType = null;
        break;
    }
    return eGenericType;
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
    return (element.getUpperBound() > 1 || element.getUpperBound() == -1) && ctx.nullable != null;
  }
}
