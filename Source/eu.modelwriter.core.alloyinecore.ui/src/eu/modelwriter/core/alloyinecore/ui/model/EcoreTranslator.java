package eu.modelwriter.core.alloyinecore.ui.model;

import java.util.HashMap;
import java.util.Map;

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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import eu.modelwriter.core.alloyinecore.ui.cs2as.Qualification;

public class EcoreTranslator implements AnnotationSources {

  private static final Map<String, String> imports = new HashMap<>();

  // FIXME fix stringtemplate path
  // platform:/plugin/eu.modelwriter.core.alloyinecore.ui/stringtemplate/AlloyInEcore.stg
  private static STGroup TEMPLATE_GROUP = new STGroupFile("stringtemplate/AlloyInEcore.stg");

  public static String translate(EPackage ePackage) {
    imports.clear();
    String text = packageToString(ePackage);
    return getImports() + text;
  }

  private static void addAnnotations(ST template, EModelElement element) {
    AnnotationSources.getAnnotations(element).forEach(anno -> {
      template.add("subElement", annoToString(anno).trim());
    });
  }

  private static Object invariantToString(EAnnotation invAnno) {
    ST template = TEMPLATE_GROUP.getInstanceOf("inv");
    EMap<String, String> details = invAnno.getDetails();
    template.add("isCallable", Boolean.parseBoolean(Qualification.CALLABLE.toString()));
    template.add("name", details.get(Qualification.NAME.toString()));
    template.add("message", details.get(Qualification.MESSAGE.toString()));
    template.add("formula", details.get(Qualification.FORMULA.toString()));
    return template.render().trim();
  }

  private static String packageToString(EPackage ePackage) {
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

  private static String classifierToString(EClassifier eClassifier) {
    if (eClassifier instanceof EEnum)
      return enumToString((EEnum) eClassifier);
    if (eClassifier instanceof EClass)
      return classToString((EClass) eClassifier);
    if (eClassifier instanceof EDataType)
      return datatypeToString((EDataType) eClassifier);
    return "";
  }

  private static String datatypeToString(EDataType eDataType) {
    ST template = TEMPLATE_GROUP.getInstanceOf("datatype");
    template.add("isPrimitive", AnnotationSources.isPrimitive(eDataType));
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

  private static String enumToString(EEnum eEnum) {
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

  private static String enumLiteralToString(EEnumLiteral literal) {
    ST template = TEMPLATE_GROUP.getInstanceOf("enumLiteral");
    template.add("name", literal.getName());
    template.add("enumValue", literal.getValue());
    addAnnotations(template, literal);
    return template.render().trim();
  }

  private static String classToString(EClass eClass) {
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

  private static String operationToString(EOperation op) {
    ST template = TEMPLATE_GROUP.getInstanceOf("op");
    template.add("visibility", getVisibility(op));
    template.add("isStatic", AnnotationSources.isStatic(op));
    template.add("name", op.getName());
    template.add("type", getName(op.getEType()));
    template.add("multiplicity", getMultiplicity(op));
    template.add("qualifier", getQualifiers(op));
    op.getEExceptions().forEach(e -> {
      template.add("throws", e.getName());
    });
    op.getEParameters().forEach(param -> {
      template.add("params", param.getName());
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

  private static Object postconditionToString(EAnnotation eAnnotation) {
    ST template = TEMPLATE_GROUP.getInstanceOf("postcondition");
    EMap<String, String> details = eAnnotation.getDetails();
    template.add("name", details.get(Qualification.NAME.toString()));
    template.add("message", details.get(Qualification.MESSAGE.toString()));
    template.add("formula", details.get(Qualification.FORMULA.toString()));
    return template.render().trim();
  }

  private static Object bodyToString(EAnnotation eAnnotation) {
    ST template = TEMPLATE_GROUP.getInstanceOf("body");
    EMap<String, String> details = eAnnotation.getDetails();
    template.add("name", details.get(Qualification.NAME.toString()));
    template.add("formula", details.get(Qualification.EXPRESSION.toString()));
    return template.render().replace("  ", "");
  }

  private static String preconditionToString(EAnnotation invAnno) {
    ST template = TEMPLATE_GROUP.getInstanceOf("precondition");
    EMap<String, String> details = invAnno.getDetails();
    template.add("name", details.get(Qualification.NAME.toString()));
    template.add("message", details.get(Qualification.MESSAGE.toString()));
    template.add("formula", details.get(Qualification.FORMULA.toString()));
    return template.render().trim();
  }

  private static String referenceToString(EReference eRef) {
    ST template = TEMPLATE_GROUP.getInstanceOf("ref");
    template.add("visibility", getVisibility(eRef));
    template.add("isStatic", AnnotationSources.isStatic(eRef));
    template.add("name", eRef.getName());
    if (eRef.getEOpposite() != null)
      template.add("opposite", getName(eRef.getEOpposite()));
    template.add("defaultValue", eRef.getDefaultValue());
    template.add("type", getName(eRef.getEType()));
    template.add("multiplicity", getMultiplicity(eRef));
    template.add("qualifier", getQualifiers(eRef));
    addAnnotations(template, eRef);
    return template.render().trim();
  }

  private static String attrToString(EAttribute eAttr) {
    ST template = TEMPLATE_GROUP.getInstanceOf("ref");
    template.add("visibility", getVisibility(eAttr));
    template.add("isStatic", AnnotationSources.isStatic(eAttr));
    template.add("name", eAttr.getName());
    template.add("defaultValue", eAttr.getDefaultValue());
    template.add("type", getName(eAttr.getEType()));
    template.add("multiplicity", getMultiplicity(eAttr));
    template.add("qualifier", getQualifiers(eAttr));
    addAnnotations(template, eAttr);
    return template.render().trim();
  }

  private static String annoToString(EAnnotation eAnnotation) {
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

  private static String edetailToString(String name, String value) {
    ST template = TEMPLATE_GROUP.getInstanceOf("edetail");
    template.add("name", name);
    template.add("value", value);
    return template.render();
  }

  private static String getImports() {
    StringBuilder importsBuilder = new StringBuilder();
    imports.entrySet().forEach(entry -> {
      ST template = TEMPLATE_GROUP.getInstanceOf("load");
      template.add("name", entry.getKey());
      template.add("namespace", entry.getValue());
      importsBuilder.append(template.render().trim());
      importsBuilder.append("\n");
    });
    importsBuilder.append("\n");
    return importsBuilder.toString();
  }

  private static String getName(EObject eObject) {
    String name = "null";
    if (eObject instanceof ENamedElement) {
      ENamedElement nElement = (ENamedElement) eObject;
      if (nElement.getName() == null) // its from another ecore
      {
        URI uri = EcoreUtil.getURI(eObject);
        imports.put(uri.trimFileExtension().lastSegment(), uri.toFileString());
        name = uri.toString().replaceAll("#//", "::").replace(".ecore", "");
      } else {
        name = nElement.getName();
      }
    }
    return name;
  }

  private static String getMultiplicity(ETypedElement eTypedElement) {
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

  private static String getVisibility(ENamedElement element) {
    String visibility = "";
    EAnnotation visibilityAnno = element.getEAnnotation(VISIBILTY);
    if (visibilityAnno != null && !visibilityAnno.getDetails().isEmpty())
      visibility = visibilityAnno.getDetails().get(Qualification.VISIBILITY.toString());
    return visibility;
  }

  private static String getQualifiers(ETypedElement element) {
    StringBuilder builder = new StringBuilder();
    builder.append(" { ");
    if (!element.isUnique())
      builder.append("!unique ");
    if (element.isOrdered())
      builder.append("ordered ");

    // if there is no qualifier, delete curly bracket
    if (builder.charAt(builder.length() - 2) == '{')
      builder.delete(builder.length() - 3, builder.length());
    else
      builder.append("}");
    // TODO check other qualifiers, maybe?
    return builder.toString();
  }

  private static String getQualifiers(EStructuralFeature eStructuralFeature) {
    StringBuilder builder = new StringBuilder();
    builder.append(" { ");
    if (!eStructuralFeature.isUnique())
      builder.append("!unique ");
    if (eStructuralFeature.isDerived())
      builder.append("derived ");
    if (eStructuralFeature.isVolatile())
      builder.append("volatile ");
    if (eStructuralFeature.isUnsettable())
      builder.append("unsettable ");
    if (eStructuralFeature.isTransient())
      builder.append("transient ");
    if (eStructuralFeature.isOrdered())
      builder.append("ordered ");
    if (!eStructuralFeature.isChangeable())
      builder.append("readonly ");

    if (eStructuralFeature instanceof EAttribute && ((EAttribute) eStructuralFeature).isID())
      builder.append("id ");
    if (eStructuralFeature instanceof EReference
        && ((EReference) eStructuralFeature).isContainment())
      builder.append("composes ");

    // if there is no qualifier, delete curly bracket
    if (builder.charAt(builder.length() - 2) == '{')
      builder.delete(builder.length() - 3, builder.length());
    else
      builder.append("}");
    // TODO check other qualifiers, maybe?
    return builder.toString();
  }

}
