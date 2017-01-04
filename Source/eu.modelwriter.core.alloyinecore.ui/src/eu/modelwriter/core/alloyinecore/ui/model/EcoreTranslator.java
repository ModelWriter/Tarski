package eu.modelwriter.core.alloyinecore.ui.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.ui.cs2as.AIEConstants;
import eu.modelwriter.core.alloyinecore.ui.cs2as.AnnotationSources;

public class EcoreTranslator implements AnnotationSources {

  private final Map<String, String> imports = new HashMap<>();
  private final Map<String, String> primitives = new HashMap<>();
  private final STGroup templateGroup;

  private EModelElement root;

  public EcoreTranslator() {
    templateGroup = new STGroupFile("stringtemplate/AlloyInEcore.stg");
    primitives.put("EString", "String");
    primitives.put("EBoolean", "Boolean");
    primitives.put("EBigDecimal", "Real");
    primitives.put("EInt", "Integer");
    primitives.put("EBigInteger", "UnlimitedNatural");
  }

  public String translate(String pathToEcore) throws IOException {
    return translate((EModelElement) EcoreUtilities.getRootObject(pathToEcore));
  }

  public String translate(EModelElement element) {
    imports.clear();
    StringBuilder builder = new StringBuilder();
    if (element != null) {
      root = element;
      collectImports(element);
      builder.append(eObjectToString(element));
      builder.insert(0, importsToString());
      builder.insert(0, moduleToString(element));
    }
    return builder.toString();
  }

  private void collectImports(EModelElement element) {
    AnnotationSources.getImports(element).forEach(anno -> {
      if (anno.getDetails().isEmpty()) {
        String name = anno.getDetails().get(0).getKey();
        String ns = anno.getDetails().get(0).getValue();
        imports.put(ns, name);
      }
    });
  }

  private String eObjectToString(EObject eObject) {
    if (eObject instanceof EPackage)
      return packageToString((EPackage) eObject);
    if (eObject instanceof EClassifier)
      return classifierToString((EClassifier) eObject);
    if (eObject instanceof EOperation)
      return operationToString((EOperation) eObject);
    if (eObject instanceof EAttribute)
      return attrToString((EAttribute) eObject);
    if (eObject instanceof EReference)
      return referenceToString((EReference) eObject);
    return "";
  }

  private String classifierToString(EClassifier eClassifier) {
    if (eClassifier instanceof EEnum)
      return enumToString((EEnum) eClassifier);
    if (eClassifier instanceof EClass)
      return classToString((EClass) eClassifier);
    if (eClassifier instanceof EDataType)
      return datatypeToString((EDataType) eClassifier);
    return "";
  }

  private String moduleToString(EModelElement element) {
    ST template = templateGroup.getInstanceOf("module");
    EAnnotation options = element.getEAnnotation(AnnotationSources.OPTIONS);
    if (options != null && !options.getDetails().isEmpty()) {
      options.getDetails().forEach(entry -> {
        template.add("option", entry.getKey() + " : " + entry.getValue());
      });
    }
    EAnnotation module = element.getEAnnotation(AnnotationSources.MODULE);
    if (module != null && module.getDetails().get("name") != null) {
      template.add("moduleName", module.getDetails().get("name"));
    }
    return template.render();
  }

  private void addAnnotations(ST template, EModelElement element) {
    AnnotationSources.getAnnotations(element).forEach(anno -> {
      template.add("subElement", annoToString(anno).trim());
    });
  }

  private Object invariantToString(EAnnotation invAnno) {
    ST template = templateGroup.getInstanceOf("inv");
    EMap<String, String> details = invAnno.getDetails();
    template.add("isCallable", Boolean.parseBoolean(AIEConstants.CALLABLE.toString()));
    template.add("name", details.get(AIEConstants.NAME.toString()));
    template.add("message", details.get(AIEConstants.MESSAGE.toString()));
    template.add("formula", details.get(AIEConstants.FORMULA.toString()));
    return template.render().trim();
  }

  private String packageToString(EPackage ePackage) {
    ST template = templateGroup.getInstanceOf("package");
    template.add("visibility", getVisibility(ePackage));
    template.add("name", ePackage.getName());
    template.add("prefix", ePackage.getNsPrefix());
    template.add("namespace", ePackage.getNsURI());
    for (EClassifier eClassifier : ePackage.getEClassifiers()) {
      template.add("subElement", classifierToString(eClassifier));
    }
    for (EPackage subPackage : ePackage.getESubpackages()) {
      template.add("subElement", packageToString(subPackage));
    }
    AnnotationSources.getInvariants(ePackage).forEach(invAnno -> {
      template.add("subElement", invariantToString(invAnno));
    });
    addAnnotations(template, ePackage);
    return template.render().trim();
  }

  private String datatypeToString(EDataType eDataType) {
    ST template = templateGroup.getInstanceOf("datatype");
    template.add("visibility", getVisibility(eDataType));
    template.add("isPrimitive", AnnotationSources.isPrimitive(eDataType));
    template.add("nullable", AnnotationSources.isNullable(eDataType));
    template.add("name", eDataType.getName());
    // TODO check instance names
    template.add("instanceName", eDataType.getInstanceClassName());
    if (eDataType.isSerializable())
      template.add("isSerializable", "serializable");
    AnnotationSources.getInvariants(eDataType).forEach(invAnno -> {
      template.add("subElement", invariantToString(invAnno));
    });
    addAnnotations(template, eDataType);
    return template.render().trim();
  }

  private String enumToString(EEnum eEnum) {
    ST template = templateGroup.getInstanceOf("enum");
    template.add("visibility", getVisibility(eEnum));
    template.add("name", eEnum.getName());
    template.add("instanceName", eEnum.getInstanceClassName());
    if (eEnum.isSerializable())
      template.add("isSerializable", "serializable");
    AnnotationSources.getInvariants(eEnum).forEach(invAnno -> {
      template.add("subElement", invariantToString(invAnno));
    });
    for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {
      template.add("subElement", enumLiteralToString(eEnumLiteral));
    }
    addAnnotations(template, eEnum);
    return template.render().trim();
  }

  private String enumLiteralToString(EEnumLiteral literal) {
    ST template = templateGroup.getInstanceOf("enumLiteral");
    template.add("name", literal.getName());
    template.add("enumValue", literal.getValue());
    addAnnotations(template, literal);
    return template.render().trim();
  }

  private String classToString(EClass eClass) {
    ST template = templateGroup.getInstanceOf("class");
    template.add("visibility", getVisibility(eClass));
    template.add("isAbstract", eClass.isAbstract());
    template.add("isInterface", eClass.isInterface());
    template.add("name", eClass.getName());
    template.add("instanceName", eClass.getInstanceClassName());
    for (EClass superClass : eClass.getESuperTypes()) {
      template.add("superClass", getQualifiedName(eClass, superClass));
    }

    eClass.getEAttributes().forEach(attr -> {
      template.add("subElement", attrToString(attr));
    });
    eClass.getEOperations().forEach(op -> {
      template.add("subElement", operationToString(op));
    });
    eClass.getEReferences().forEach(eRef -> {
      template.add("subElement", referenceToString(eRef));
    });
    AnnotationSources.getInvariants(eClass).forEach(invAnno -> {
      template.add("subElement", invariantToString(invAnno));
    });
    addAnnotations(template, eClass);
    return template.render().trim();
  }

  private String operationToString(EOperation op) {
    ST template = templateGroup.getInstanceOf("op");
    template.add("visibility", getVisibility(op));
    template.add("isStatic", AnnotationSources.isStatic(op));
    template.add("nullable", AnnotationSources.isNullable(op));
    template.add("name", op.getName());
    if (op.getEType() != null) {
      template.add("type", getTypeName(op, op.getEType()));
      template.add("multiplicity", getMultiplicity(op));
    }
    template.add("qualifier", getQualifiers(op));
    op.getEExceptions().forEach(eClassifier -> {
      template.add("throws", eClassifier.getName());
    });
    op.getEParameters().forEach(param -> {
      template.add("params", paramToString(param));
    });

    AnnotationSources.getPreconditions(op).forEach(anno -> {
      template.add("subElement", preconditionToString(anno));
    });
    AnnotationSources.getBodyExpressions(op).forEach(anno -> {
      template.add("subElement", bodyToString(anno));
    });
    AnnotationSources.getPostconditions(op).forEach(anno -> {
      template.add("subElement", postconditionToString(anno));
    });

    addAnnotations(template, op);
    return template.render().trim();
  }

  private String paramToString(EParameter param) {
    ST template = templateGroup.getInstanceOf("opParameter");
    template.add("nullable", AnnotationSources.isNullable(param));
    template.add("name", param.getName());
    if (param.getEType() != null) {
      template.add("type", getTypeName(param, param.getEType()));
      template.add("multiplicity", getMultiplicity(param));
    }
    template.add("qualifier", getQualifiers(param));
    addAnnotations(template, param);
    return template.render();
  }

  private String postconditionToString(EAnnotation eAnnotation) {
    ST template = templateGroup.getInstanceOf("postcondition");
    EMap<String, String> details = eAnnotation.getDetails();
    template.add("name", details.get(AIEConstants.NAME.toString()));
    template.add("message", details.get(AIEConstants.MESSAGE.toString()));
    template.add("formula", details.get(AIEConstants.FORMULA.toString()));
    return template.render().trim();
  }

  private Object bodyToString(EAnnotation eAnnotation) {
    ST template = templateGroup.getInstanceOf("body");
    EMap<String, String> details = eAnnotation.getDetails();
    template.add("name", details.get(AIEConstants.NAME.toString()));
    template.add("expression", details.get(AIEConstants.EXPRESSION.toString()));
    return template.render().replace("  ", "");
  }

  private String preconditionToString(EAnnotation invAnno) {
    ST template = templateGroup.getInstanceOf("precondition");
    EMap<String, String> details = invAnno.getDetails();
    template.add("name", details.get(AIEConstants.NAME.toString()));
    template.add("message", details.get(AIEConstants.MESSAGE.toString()));
    template.add("formula", details.get(AIEConstants.FORMULA.toString()));
    return template.render().trim();
  }

  private String referenceToString(EReference eRef) {
    ST template = templateGroup.getInstanceOf("ref");
    template.add("visibility", getVisibility(eRef));
    template.add("isStatic", AnnotationSources.isStatic(eRef));
    template.add("transient", eRef.isTransient());
    template.add("volatile", eRef.isVolatile());
    template.add("model", eRef.getEAnnotation(AnnotationSources.MODEL) != null);
    template.add("ghost", eRef.getEAnnotation(AnnotationSources.GHOST) != null);
    template.add("nullable", AnnotationSources.isNullable(eRef));
    template.add("readonly", !eRef.isChangeable());
    template.add("name", eRef.getName());
    if (eRef.getEOpposite() != null)
      template.add("opposite", eRef.getEOpposite().getName());
    template.add("defaultValue", eRef.getDefaultValue());
    if (eRef.getEType() != null) {
      template.add("type", getTypeName(eRef, eRef.getEType()));
      template.add("multiplicity", getMultiplicity(eRef));
    }
    template.add("qualifier", getQualifiers(eRef));
    addAnnotations(template, eRef);
    addReferenceKeys(template, eRef);
    addSFExpressions(template, eRef);
    return template.render().trim();
  }

  private void addReferenceKeys(ST refTemplate, EReference eRef) {
    if (eRef.getEKeys().isEmpty())
      return;
    ST template = templateGroup.getInstanceOf("referenceKey");
    eRef.getEKeys().forEach(attr -> {
      template.add("referredKeys", getQualifiedName(eRef, attr));
    });
    refTemplate.add("subElement", template.render());
  }

  private void addSFExpressions(ST template, EStructuralFeature sf) {
    for (EAnnotation eAnnotation : AnnotationSources.getInitial(sf)) {
      if (!eAnnotation.getDetails().isEmpty())
        template.add("subElement", initialToString(eAnnotation));
    }
    for (EAnnotation eAnnotation : AnnotationSources.getDerivation(sf)) {
      if (!eAnnotation.getDetails().isEmpty())
        template.add("subElement", derivationToString(eAnnotation));
    }
  }

  private Object initialToString(EAnnotation eAnnotation) {
    ST template = templateGroup.getInstanceOf("initial");
    template.add("name", eAnnotation.getDetails().get("name"));
    template.add("expression", eAnnotation.getDetails().get("expression"));
    return template.render();
  }

  private String derivationToString(EAnnotation eAnnotation) {
    ST template = templateGroup.getInstanceOf("derivation");
    template.add("name", eAnnotation.getDetails().get("name"));
    template.add("expression", eAnnotation.getDetails().get("expression"));
    return template.render();
  }

  private String attrToString(EAttribute eAttr) {
    ST template = templateGroup.getInstanceOf("attr");
    template.add("visibility", getVisibility(eAttr));
    template.add("isStatic", AnnotationSources.isStatic(eAttr));
    template.add("transient", eAttr.isTransient());
    template.add("volatile", eAttr.isVolatile());
    template.add("model", eAttr.getEAnnotation(AnnotationSources.MODEL) != null);
    template.add("ghost", eAttr.getEAnnotation(AnnotationSources.GHOST) != null);
    template.add("nullable", AnnotationSources.isNullable(eAttr));
    template.add("readonly", !eAttr.isChangeable());
    template.add("name", eAttr.getName());
    template.add("defaultValue", eAttr.getDefaultValue());
    if (eAttr.getEType() != null) {
      template.add("type", getTypeName(eAttr, eAttr.getEType()));
      template.add("multiplicity", getMultiplicity(eAttr));
    }
    template.add("qualifier", getQualifiers(eAttr));
    addAnnotations(template, eAttr);
    addSFExpressions(template, eAttr);
    return template.render().trim();
  }

  private String annoToString(EAnnotation eAnnotation) {
    ST template = templateGroup.getInstanceOf("anno");
    template.add("name", eAnnotation.getSource());
    eAnnotation.getDetails().forEach(entry -> {
      template.add("detail", edetailToString(entry.getKey(), entry.getValue()));
    });
    eAnnotation.getReferences().forEach(ref -> {
      if (!(ref instanceof EAnnotation))
        template.add("subElement", "reference " + getQualifiedName(eAnnotation, ref) + ";");
    });
    eAnnotation.getContents().forEach(eObject -> {
      String subElement = eObjectToString(eObject);
      template.add("subElement", subElement);
    });
    addAnnotations(template, eAnnotation);
    return template.render().trim();
  }


  private String edetailToString(String name, String value) {
    ST template = templateGroup.getInstanceOf("edetail");
    template.add("name", name);
    template.add("val", value);
    return template.render();
  }

  private String importsToString() {
    StringBuilder importsBuilder = new StringBuilder();
    imports.entrySet().forEach(entry -> {
      ST template = templateGroup.getInstanceOf("load");
      template.add("namespace", entry.getKey());
      template.add("name", entry.getValue());
      importsBuilder.append(template.render().trim());
      importsBuilder.append("\n");
    });
    if (importsBuilder.length() > 0)
      importsBuilder.append("\n");
    return importsBuilder.toString();
  }

  private boolean isInSamePackage(EObject obj1, EObject obj2) {
    EPackage pac1 = getContainerPackage(obj1);
    EPackage pac2 = getContainerPackage(obj2);
    return pac1 != null && pac2 != null && pac1.equals(pac2);
  }

  private EPackage getContainerPackage(EObject obj) {
    try {
      EObject container = obj;
      while (container.eContainer() != null && !(container instanceof EPackage)) {
        container = container.eContainer();
      }
      return (EPackage) container;
    } catch (ClassCastException e) {
      return null;
    }
  }

  private String getQualifiedName(EObject rel, EObject eObject) {
    if (eObject == null && !(eObject instanceof ENamedElement)) // No annotation allowed
      return "";

    if (!root.equals(EcoreUtil.getRootContainer(eObject, true)))
      return getImportedQualifiedName(eObject);

    // Annotation references must be fully qualified
    boolean relative = isInSamePackage(rel, eObject) && !(rel instanceof EAnnotation);
    ENamedElement element = (ENamedElement) eObject;
    EPackage relPackage = getContainerPackage(rel);

    String qualifiedName = "";
    ENamedElement container = (ENamedElement) eObject.eContainer();
    List<String> containerNames = new ArrayList<>();

    while (container != null) {
      if (relative && container.equals(relPackage))
        break;
      containerNames.add(container.getName());
      container = (ENamedElement) container.eContainer();
    }

    Collections.reverse(containerNames);
    for (String s : containerNames)
      qualifiedName += AIEConstants.SEPARATOR_PACKAGE + s;

    if (!qualifiedName.isEmpty())
      qualifiedName = qualifiedName.replaceFirst(".", "");

    String lastSeperator = getSeperator(eObject);
    qualifiedName +=
        qualifiedName.isEmpty() ? element.getName() : lastSeperator + element.getName();

    return qualifiedName;
  }

  private String getImportedQualifiedName(EObject eObject) {
    String packageName = imports.get(getLocation(eObject));
    if (packageName == null) {
      // Use file name
      packageName = EcoreUtil.getURI(eObject).trimFileExtension().lastSegment();
      imports.put(getLocation(eObject), packageName);
    }
    return packageName + AIEConstants.SEPARATOR_PACKAGE
        + EcoreUtil.getURI(eObject).fragment().replace("//", "")
            .replaceAll("/([^/]*)$", getSeperator(eObject) + "$1")
            .replaceAll("/", AIEConstants.SEPARATOR_PACKAGE);
  }

  private String getSeperator(EObject eObject) {
    if (eObject instanceof EStructuralFeature)
      return AIEConstants.SEPARATOR_FEATURE;
    if (eObject instanceof EOperation)
      return AIEConstants.SEPARATOR_OPERATION;
    if (eObject instanceof EClassifier)
      return AIEConstants.SEPARATOR_CLASSIFIER;
    return AIEConstants.SEPARATOR_PACKAGE;
  }

  private String getLocation(EObject eObject) {
    URI uri = EcoreUtil.getURI(eObject).trimFragment();
    if (uri.isPlatform() || uri.isPlatformPlugin() || uri.isPlatformResource()) {
      List<String> list = uri.segmentsList();
      return String.join("/", list.subList(1, list.size()));
    } else if (uri.isFile())
      return uri.toFileString();
    else
      return uri.toString();
  }

  private String getTypeName(EObject rel, EClassifier eClassifier) {
    String type = getQualifiedName(rel, eClassifier);
    if (type != null) {
      for (Entry<String, String> e : primitives.entrySet()) {
        if (type.contains(e.getKey())) {
          return e.getValue();
        }
      }
    }
    return type;
  }

  private String getMultiplicity(ETypedElement eTypedElement) {
    int l = eTypedElement.getLowerBound();
    int u = eTypedElement.getUpperBound();
    if (l == 0 && u == 1)
      return "?";
    if (l == 0 && u == -1)
      return "*";
    if (l == 1 && u == 1)
      return "1";
    if (l == 1 && u == -1)
      return "+";

    return l + ".." + u;
  }

  private String getVisibility(ENamedElement element) {
    String visibility = "";
    EAnnotation visibilityAnno = element.getEAnnotation(VISIBILITY);
    if (visibilityAnno != null && !visibilityAnno.getDetails().isEmpty())
      visibility = visibilityAnno.getDetails().get(AIEConstants.VISIBILITY.toString());
    return visibility;
  }

  private String getQualifiers(ETypedElement element) {
    StringBuilder builder = new StringBuilder();
    if (!element.isUnique())
      builder.append(AIEConstants.NOT_UNIQUE + " ");
    if (element.isOrdered())
      builder.append(AIEConstants.ORDERED + " ");

    // Wrap with curly bracket
    if (builder.length() > 0) {
      builder.insert(0, " { ");
      builder.append("}");
    }
    return builder.toString();
  }

  private String getQualifiers(EStructuralFeature eStructuralFeature) {
    StringBuilder builder = new StringBuilder();
    if (!eStructuralFeature.isUnique())
      builder.append(AIEConstants.NOT_UNIQUE + " ");
    if (eStructuralFeature.isDerived())
      builder.append(AIEConstants.DERIVED + " ");
    if (eStructuralFeature.isUnsettable())
      builder.append(AIEConstants.UNSETTABLE + " ");
    if (eStructuralFeature.isOrdered())
      builder.append(AIEConstants.ORDERED + " ");

    if (eStructuralFeature instanceof EAttribute && ((EAttribute) eStructuralFeature).isID())
      builder.append(AIEConstants.ID + " ");

    if (eStructuralFeature instanceof EReference) {
      if (((EReference) eStructuralFeature).isResolveProxies())
        builder.append(AIEConstants.RESOLVE + " ");
      if (((EReference) eStructuralFeature).isContainment())
        builder.append(AIEConstants.COMPOSES + " ");
    }

    // Wrap with curly bracket
    if (builder.length() > 0) {
      builder.insert(0, " { ");
      builder.append("}");
    }
    return builder.toString();
  }


}
