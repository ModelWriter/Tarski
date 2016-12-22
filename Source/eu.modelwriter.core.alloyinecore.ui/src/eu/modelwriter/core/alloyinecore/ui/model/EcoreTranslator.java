package eu.modelwriter.core.alloyinecore.ui.model;

import java.util.HashMap;
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

import eu.modelwriter.core.alloyinecore.ui.cs2as.AnnotationSources;
import eu.modelwriter.core.alloyinecore.ui.cs2as.Qualification;

public class EcoreTranslator implements AnnotationSources {

  private final Map<String, String> IMPORTS = new HashMap<>();
  private final Map<String, String> PRIMITIVES = new HashMap<>();
  private final STGroup TEMPLATE_GROUP;

  private URI rootURI;

  public EcoreTranslator() {
    TEMPLATE_GROUP = new STGroupFile("stringtemplate/AlloyInEcore.stg");
    PRIMITIVES.put("EString", "String");
    PRIMITIVES.put("EBoolean", "Boolean");
    PRIMITIVES.put("EBigDecimal", "Real");
    PRIMITIVES.put("EInt", "Integer");
    PRIMITIVES.put("EBigInteger", "UnlimitedNatural");
  }

  public String translate(EModelElement element) {
    IMPORTS.clear();
    String text = "";
    rootURI = EcoreUtil.getURI(element);
    findImports(element);
    if (element instanceof EPackage)
      text = packageToString((EPackage) element);

    return getModule(element) + prependImports() + text;
  }

  private void findImports(EModelElement element) {
    AnnotationSources.getImports(element).forEach(anno -> {
      if (anno.getDetails().isEmpty()) {
        String name = anno.getDetails().get("name");
        String ns = anno.getDetails().get("namespace");
        IMPORTS.put(ns, name);
      }
    });
  }

  private String getModule(EModelElement element) {
    ST template = TEMPLATE_GROUP.getInstanceOf("module");
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
    ST template = TEMPLATE_GROUP.getInstanceOf("inv");
    EMap<String, String> details = invAnno.getDetails();
    template.add("isCallable", Boolean.parseBoolean(Qualification.CALLABLE.toString()));
    template.add("name", details.get(Qualification.NAME.toString()));
    template.add("message", details.get(Qualification.MESSAGE.toString()));
    template.add("formula", details.get(Qualification.FORMULA.toString()));
    return template.render().trim();
  }

  private String packageToString(EPackage ePackage) {
    ST template = TEMPLATE_GROUP.getInstanceOf("package");
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

  private String classifierToString(EClassifier eClassifier) {
    if (eClassifier instanceof EEnum)
      return enumToString((EEnum) eClassifier);
    if (eClassifier instanceof EClass)
      return classToString((EClass) eClassifier);
    if (eClassifier instanceof EDataType)
      return datatypeToString((EDataType) eClassifier);
    return "";
  }

  private String datatypeToString(EDataType eDataType) {
    ST template = TEMPLATE_GROUP.getInstanceOf("datatype");
    template.add("isPrimitive", AnnotationSources.isPrimitive(eDataType));
    template.add("nullable", AnnotationSources.isNullable(eDataType));
    template.add("name", eDataType.getName());
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
    ST template = TEMPLATE_GROUP.getInstanceOf("enum");
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
    ST template = TEMPLATE_GROUP.getInstanceOf("enumLiteral");
    template.add("name", literal.getName());
    template.add("enumValue", literal.getValue());
    addAnnotations(template, literal);
    return template.render().trim();
  }

  private String classToString(EClass eClass) {
    ST template = TEMPLATE_GROUP.getInstanceOf("class");
    template.add("visibility", getVisibility(eClass));
    template.add("isAbstract", eClass.isAbstract());
    template.add("name", eClass.getName());
    template.add("instanceName", eClass.getInstanceClassName());
    for (EClass superClass : eClass.getESuperTypes()) {
      template.add("superClass", getName(superClass));
    }
    template.add("isInterface", eClass.isInterface());

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
    ST template = TEMPLATE_GROUP.getInstanceOf("op");
    template.add("visibility", getVisibility(op));
    template.add("isStatic", AnnotationSources.isStatic(op));
    template.add("nullable", AnnotationSources.isNullable(op));
    template.add("name", op.getName());
    template.add("type", getTypeName(op.getEType()));
    template.add("multiplicity", getMultiplicity(op));
    template.add("qualifier", getQualifiers(op));
    op.getEExceptions().forEach(e -> {
      template.add("throws", e.getName());
    });
    op.getEParameters().forEach(param -> {
      template.add("params", paramToString(param));
    });
    if (op.getEAnnotation(PRECONDITION) != null)
      template.add("subElement", preconditionToString(op.getEAnnotation(PRECONDITION)));
    if (op.getEAnnotation(BODY) != null)
      template.add("subElement", bodyToString(op.getEAnnotation(BODY)));
    if (op.getEAnnotation(POSTCONDITION) != null)
      template.add("subElement", postconditionToString(op.getEAnnotation(POSTCONDITION)));
    addAnnotations(template, op);
    return template.render().trim();
  }

  private String paramToString(EParameter param) {
    ST template = TEMPLATE_GROUP.getInstanceOf("opParameter");
    template.add("nullable", AnnotationSources.isNullable(param));
    template.add("name", param.getName());
    template.add("type", getTypeName(param.getEType()));
    template.add("multiplicity", getMultiplicity(param));
    template.add("qualifier", getQualifiers(param));
    addAnnotations(template, param);
    return template.render();
  }

  private String postconditionToString(EAnnotation eAnnotation) {
    ST template = TEMPLATE_GROUP.getInstanceOf("postcondition");
    EMap<String, String> details = eAnnotation.getDetails();
    template.add("name", details.get(Qualification.NAME.toString()));
    template.add("message", details.get(Qualification.MESSAGE.toString()));
    template.add("formula", details.get(Qualification.FORMULA.toString()));
    return template.render().trim();
  }

  private Object bodyToString(EAnnotation eAnnotation) {
    ST template = TEMPLATE_GROUP.getInstanceOf("body");
    EMap<String, String> details = eAnnotation.getDetails();
    template.add("name", details.get(Qualification.NAME.toString()));
    template.add("formula", details.get(Qualification.EXPRESSION.toString()));
    return template.render().replace("  ", "");
  }

  private String preconditionToString(EAnnotation invAnno) {
    ST template = TEMPLATE_GROUP.getInstanceOf("precondition");
    EMap<String, String> details = invAnno.getDetails();
    template.add("name", details.get(Qualification.NAME.toString()));
    template.add("message", details.get(Qualification.MESSAGE.toString()));
    template.add("formula", details.get(Qualification.FORMULA.toString()));
    return template.render().trim();
  }

  private String referenceToString(EReference eRef) {
    ST template = TEMPLATE_GROUP.getInstanceOf("ref");
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
      template.add("opposite", getName(eRef.getEOpposite()));
    template.add("defaultValue", eRef.getDefaultValue());
    template.add("type", getTypeName(eRef.getEType()));
    template.add("multiplicity", getMultiplicity(eRef));
    template.add("qualifier", getQualifiers(eRef));
    addAnnotations(template, eRef);
    return template.render().trim();
  }

  private String attrToString(EAttribute eAttr) {
    ST template = TEMPLATE_GROUP.getInstanceOf("ref");
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
    template.add("type", getTypeName(eAttr.getEType()));
    template.add("multiplicity", getMultiplicity(eAttr));
    template.add("qualifier", getQualifiers(eAttr));
    addAnnotations(template, eAttr);
    return template.render().trim();
  }

  private String annoToString(EAnnotation eAnnotation) {
    ST template = TEMPLATE_GROUP.getInstanceOf("anno");
    template.add("name", eAnnotation.getSource());
    eAnnotation.getDetails().forEach(entry -> {
      template.add("detail", edetailToString(entry.getKey(), entry.getValue()));
    });
    eAnnotation.getReferences().forEach(ref -> {
      template.add("subElement", "reference " + getName(ref) + ";");
    });
    eAnnotation.getContents().forEach(eObject -> {
      String subElement = "";
      if (eObject instanceof EPackage)
        subElement = packageToString((EPackage) eObject);
      if (eObject instanceof EClass)
        subElement = classToString((EClass) eObject);
      if (eObject instanceof EEnum)
        subElement = enumToString((EEnum) eObject);
      if (eObject instanceof EDataType)
        subElement = datatypeToString((EDataType) eObject);
      if (eObject instanceof EOperation)
        subElement = operationToString((EOperation) eObject);
      if (eObject instanceof EAttribute)
        subElement = attrToString((EAttribute) eObject);
      if (eObject instanceof EReference)
        subElement = referenceToString((EReference) eObject);
      template.add("subElement", subElement);
    });
    addAnnotations(template, eAnnotation);
    return template.render().trim();
  }

  private String edetailToString(String name, String value) {
    ST template = TEMPLATE_GROUP.getInstanceOf("edetail");
    template.add("name", name);
    template.add("val", value);
    return template.render();
  }

  private String prependImports() {
    StringBuilder importsBuilder = new StringBuilder();
    IMPORTS.entrySet().forEach(entry -> {
      ST template = TEMPLATE_GROUP.getInstanceOf("load");
      template.add("namespace", entry.getKey());
      template.add("name", entry.getValue());
      importsBuilder.append(template.render().trim());
      importsBuilder.append("\n");
    });
    if (importsBuilder.length() > 0)
      importsBuilder.append("\n");
    return importsBuilder.toString();
  }

  private String getQualifiedName(EObject eObject) {
    String name = "null";
    URI uri = EcoreUtil.getURI(eObject);

    if (!uri.toString().contains(rootURI.toString())) { // Check if its from another ecore
      String importNs =
          uri.isFile() ? uri.trimFragment().toFileString() : uri.trimFragment().toString();
      String importName = uri.trimFileExtension().lastSegment(); // File name as import name
      if (IMPORTS.get(importNs) != null) {
        importName = IMPORTS.get(importNs);
      } else {
        IMPORTS.put(importNs, importName);
      }
      name = importName + "::" + uri.fragment().replaceAll("//", "").replaceAll("/", "::");
    } else
      name = uri.fragment().replaceAll("//", "").replaceAll("/", "::");
    return name;
  }

  private String getName(EObject eObject) {
    return getQualifiedName(eObject);
  }

  private String getTypeName(EClassifier eType) {
    String type = getQualifiedName(eType);
    for (Entry<String, String> e : PRIMITIVES.entrySet()) {
      if (type.contains(e.getKey())) {
        return e.getValue();
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
    EAnnotation visibilityAnno = element.getEAnnotation(VISIBILTY);
    if (visibilityAnno != null && !visibilityAnno.getDetails().isEmpty())
      visibility = visibilityAnno.getDetails().get(Qualification.VISIBILITY.toString());
    return visibility;
  }

  private String getQualifiers(ETypedElement element) {
    StringBuilder builder = new StringBuilder();
    if (!element.isUnique())
      builder.append(Qualification.NOT_UNIQUE + " ");
    if (element.isOrdered())
      builder.append(Qualification.ORDERED + " ");

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
      builder.append(Qualification.NOT_UNIQUE + " ");
    if (eStructuralFeature.isDerived())
      builder.append(Qualification.DERIVED + " ");
    if (eStructuralFeature.isUnsettable())
      builder.append(Qualification.UNSETTABLE + " ");
    if (eStructuralFeature.isOrdered())
      builder.append(Qualification.ORDERED + " ");

    if (eStructuralFeature instanceof EAttribute && ((EAttribute) eStructuralFeature).isID())
      builder.append(Qualification.ID + " ");

    if (eStructuralFeature instanceof EReference) {
      if (((EReference) eStructuralFeature).isResolveProxies())
        builder.append(Qualification.RESOLVE + " ");
      if (((EReference) eStructuralFeature).isContainment())
        builder.append(Qualification.COMPOSES + " ");
    }

    // Wrap with curly bracket
    if (builder.length() > 0) {
      builder.insert(0, " { ");
      builder.append("}");
    }
    return builder.toString();
  }

}
