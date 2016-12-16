package eu.modelwriter.core.alloyinecore.ui.model;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;

public class EcoreTranslator {

  /**
   * Import Annonatation source
   * 
   */
  private final static String IMPORT_NAMESPACE = "http://www.eclipse.org/OCL/Import";

  private final static String REFERENCE_ANNO = "http://www.modelwriter.eu/AlloyInEcore/Reference";

  private final static String ATTRIBUTE_ANNO = "http://www.modelwriter.eu/AlloyInEcore/Attribute";

  private final static String OPERATION_ANNO = "http://www.modelwriter.eu/AlloyInEcore/Operation";

  private final static String ENUM_ANNO = "http://www.modelwriter.eu/AlloyInEcore/Enum";

  private final static String DATATYPE_PRIMITIVE_ANNO =
      "http://www.modelwriter.eu/AlloyInEcore/DataType/Primitive";

  private final static String DATATYPE_ANNO = "http://www.modelwriter.eu/AlloyInEcore/DataType";

  private final static String VISIBILTY_ANNO = "http://www.modelwriter.eu/AlloyInEcore/Visibility";

  private final static String QUALIFIER_ANNO = "http://www.modelwriter.eu/AlloyInEcore/Qualifier";

  private final static String CONSTRAIT_EXPS_ANNO =
      "http://www.modelwriter.eu/AlloyInEcore/ConstraitFormulas";

  private final static String IMPORT_PATTERN = "import %s : '%s';\n";
  private final static String PACKAGE_PATTERN = "%spackage %s : %s = '%s' \n%s";
  private final static String CLASS_PATTERN = "%sclass %s%s\n%s\n";
  private final static String ENUM_PATTERN = "%senum %s : %s { %s }%s\n";
  private final static String DATATYPE_PATTERN = "%sdatatype %s : %s { %s }%s\n";
  private final static String OP_PATTERN = "%soperation %s() : %s[%s];%s\n";
  private final static String ATTR_PATTERN = "%sattribute %s : %s[%s];\n";
  private final static String PROPERTY_PATTERN = "%sproperty %s%s : %s[%s]%s%s\n";
  private final static String INV_PATTERN = "invariant %s: %s;\n";

  public static StringBuilder translate(EPackage ePackage) {
    SubStringBuilder builder = new SubStringBuilder();
    appendImports(builder.withDepth(0), ePackage);
    // appendPackage(builder.withDepth(0), ePackage);
    recAppendPackage(builder, ePackage, 0);
    return builder.getStringBuilder();
  }

  private static void recAppendPackage(SubStringBuilder builder, EPackage ePackage, int depth) {
    appendPackage(builder.withDepth(depth), ePackage);
    for (EPackage subEPackage : ePackage.getESubpackages()) {
      recAppendPackage(builder, subEPackage, depth + 1);
    }
    builder.append("}\n", depth);
  }

  private static void appendImports(SubStringBuilder builder, EPackage ePackage) {
    List<EAnnotation> imports = ePackage.getEAnnotations().stream()
        .filter(e -> IMPORT_NAMESPACE.equals(e.getSource())).collect(Collectors.toList());
    for (EAnnotation eAnnotation : imports) {
      for (Entry<String, String> entry : eAnnotation.getDetails().entrySet())
        builder.append(String.format(IMPORT_PATTERN, entry.getKey(), entry.getValue()));
    }
  }

  private static void appendPackage(SubStringBuilder builder, EPackage ePackage) {
    builder.append(String.format(PACKAGE_PATTERN, getVisibility(ePackage), ePackage.getName(),
        ePackage.getNsPrefix(), ePackage.getNsURI(), getPackageContent(ePackage, builder.depth)));
  }

  private static String getPackageContent(EPackage ePackage, int depth) {
    SubStringBuilder subBuilder = new SubStringBuilder();
    subBuilder.setDepth(depth);
    subBuilder.append("{\n", depth);
    for (EObject eObject : ePackage.eContents()) {
      if (eObject instanceof EClass) {
        appendClass(subBuilder, (EClass) eObject);
      }
      if (eObject instanceof EEnum) {
        appendEnum(subBuilder, (EEnum) eObject);
      }
      if (eObject instanceof EDataType) {
        appenDataType(subBuilder, (EDataType) eObject);
      }
    }
    return subBuilder.toString();
  }

  private static void appenDataType(SubStringBuilder subBuilder, EDataType eDataType) {
    EAnnotation anno = eDataType.getEAnnotation(DATATYPE_ANNO);
    String primitive = anno == null ? "" : "primitive ";
    subBuilder.append(
        String.format(DATATYPE_PATTERN, primitive, eDataType.getName(),
            eDataType.getInstanceTypeName(),
            eDataType.isSerializable() ? "serializable" : "!serializable",
            getExpressions(eDataType, DATATYPE_PRIMITIVE_ANNO, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static void appendEnum(SubStringBuilder subBuilder, EEnum eEnum) {
    subBuilder.append(String.format(ENUM_PATTERN, getVisibilityAndQualifier(eEnum), eEnum.getName(),
        eEnum.getInstanceTypeName(), eEnum.isSerializable() ? "serializable" : "!serializable",
        getLiterals(eEnum, subBuilder.depth + 1)), subBuilder.depth + 1);
  }

  private static String getLiterals(EEnum eEnum, int depth) {
    SubStringBuilder subBuilder = new SubStringBuilder();
    EAnnotation expressions = eEnum.getEAnnotation(ENUM_ANNO);
    if (expressions != null && !expressions.getDetails().isEmpty()
        || !eEnum.getELiterals().isEmpty()) {
      subBuilder.append("\n");
      subBuilder.append("{\n", depth);
      for (EEnumLiteral literal : eEnum.getELiterals()) {
        subBuilder.append("literal " + literal.getName() + " = " + literal.getValue() + ";",
            depth + 1);
      }
      if (expressions != null && !expressions.getDetails().isEmpty()) {
        for (Entry<String, String> entry : expressions.getDetails()) {
          subBuilder.append(entry.getKey() + ": " + entry.getValue() + ";", depth + 1);
        }
      }
      subBuilder.append("\n");
      subBuilder.append("}", depth);
    }
    return subBuilder.toString();
  }

  private static void appendClass(SubStringBuilder subBuilder, EClass eClass) {
    String supers = "";
    if (!eClass.getESuperTypes().isEmpty()) {
      supers += " extends ";
      for (EClass superEClass : eClass.getESuperTypes()) {
        supers += superEClass.getName() + ", ";
      }
      // FIXME remove last comma
      supers.replaceAll(",\\s*$", "");
    }
    subBuilder.append(String.format(CLASS_PATTERN, getVisibilityAndQualifier(eClass),
        eClass.getName(), supers, getClassContent(eClass, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static String getClassContent(EClass eClass, int depth) {
    SubStringBuilder subBuilder = new SubStringBuilder();
    subBuilder.setDepth(depth);
    subBuilder.append("{\n", depth);
    for (EObject eObject : eClass.eContents()) {
      if (eObject instanceof EOperation) {
        appendOperation(subBuilder, (EOperation) eObject);
      }
      if (eObject instanceof EAttribute) {
        appendAttribute(subBuilder, (EAttribute) eObject);
      }
      if (eObject instanceof EReference) {
        appendReference(subBuilder, (EReference) eObject);
      }
    }
    appenClassConstraits(subBuilder, eClass);
    subBuilder.append("}\n", depth);
    return subBuilder.toString();
  }

  private static void appenClassConstraits(SubStringBuilder subBuilder, EClass eClass) {
    EAnnotation constraitExpressions = eClass.getEAnnotation(CONSTRAIT_EXPS_ANNO);
    if (constraitExpressions != null) {
      for (Entry<String, String> entry : constraitExpressions.getDetails()) {
        subBuilder.append(String.format(INV_PATTERN, entry.getKey(), entry.getValue()),
            subBuilder.depth + 1);
      }
    }
  }

  private static void appendAttribute(SubStringBuilder subBuilder, EAttribute eAttribute) {
    subBuilder.append(
        String.format(ATTR_PATTERN, getVisibilityAndQualifier(eAttribute), eAttribute.getName(),
            eAttribute.getEAttributeType().getName(), getMultiplicity(eAttribute),
            getExpressions(eAttribute, ATTRIBUTE_ANNO, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static void appendReference(SubStringBuilder subBuilder, EReference eReference) {
    String opposite =
        eReference.getEOpposite() == null ? "" : "#" + eReference.getEOpposite().getName();
    subBuilder.append(
        String.format(PROPERTY_PATTERN, getVisibilityAndQualifier(eReference), eReference.getName(),
            opposite, eReference.getEReferenceType().getName(), getMultiplicity(eReference),
            getQualifiers(eReference),
            getExpressions(eReference, REFERENCE_ANNO, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static void appendOperation(SubStringBuilder subBuilder, EOperation eOperation) {
    subBuilder.append(
        String.format(OP_PATTERN, getVisibilityAndQualifier(eOperation), eOperation.getName(),
            eOperation.getEType().getName(), getMultiplicity(eOperation),
            getExpressions(eOperation, OPERATION_ANNO, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static String getExpressions(ENamedElement element, String annotationSource, int depth) {
    SubStringBuilder subBuilder = new SubStringBuilder();
    subBuilder.setDepth(depth);
    EAnnotation expressions = element.getEAnnotation(annotationSource);
    if (expressions != null && !expressions.getDetails().isEmpty()) {
      subBuilder.append("\n");
      subBuilder.append("{\n", depth);
      for (Entry<String, String> entry : expressions.getDetails()) {
        subBuilder.append(entry.getKey() + ": " + entry.getValue() + ";", depth + 1);
      }
      subBuilder.append("\n");
      subBuilder.append("}", depth);
    } else
      subBuilder.append(";", 0);
    return subBuilder.toString();
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

  private static String getVisibilityAndQualifier(ENamedElement element) {
    String visibility = getVisibility(element);
    String qualifier = getQualifier(element);
    return visibility + (qualifier.isEmpty() ? "" : (qualifier + " "));
  }

  private static String getVisibility(ENamedElement element) {
    String visibility = "";
    EAnnotation visibilityAnno = element.getEAnnotation(VISIBILTY_ANNO);
    if (visibilityAnno != null && !visibilityAnno.getDetails().isEmpty())
      visibility = visibilityAnno.getDetails().get("visibility");
    return visibility.isEmpty() ? "" : visibility + " ";
  }

  private static String getQualifier(ENamedElement element) {
    String qualifier = "";
    EAnnotation qualifierAnno = element.getEAnnotation(QUALIFIER_ANNO);
    if (qualifierAnno != null && !qualifierAnno.getDetails().isEmpty())
      qualifier = qualifierAnno.getDetails().get("qualifier");
    return qualifier;
  }

  private static String getQualifiers(EStructuralFeature eStructuralFeature) {
    StringBuilder subBuilder = new StringBuilder();
    subBuilder.append(" { ");
    if (!eStructuralFeature.isUnique())
      subBuilder.append("!unique ");
    if (eStructuralFeature.isDerived())
      subBuilder.append("derived ");
    if (eStructuralFeature.isVolatile())
      subBuilder.append("volatile ");
    if (eStructuralFeature.isUnsettable())
      subBuilder.append("unsettable ");
    if (eStructuralFeature.isTransient())
      subBuilder.append("transient ");
    if (eStructuralFeature.isOrdered())
      subBuilder.append("ordered ");
    if (!eStructuralFeature.isChangeable())
      subBuilder.append("readonly ");

    if (eStructuralFeature instanceof EAttribute && ((EAttribute) eStructuralFeature).isID())
      subBuilder.append("id ");
    if (eStructuralFeature instanceof EReference
        && ((EReference) eStructuralFeature).isContainment())
      subBuilder.append("composes ");

    // if there is no qualifier, delete curly bracket
    if (subBuilder.charAt(subBuilder.length() - 2) == '{')
      subBuilder.delete(subBuilder.length() - 3, subBuilder.length());
    else
      subBuilder.append("}");
    // TODO check other qualifiers, maybe?
    return subBuilder.toString();
  }

  public static class SubStringBuilder {
    StringBuilder builder;
    private int depth = 0;

    public SubStringBuilder() {
      builder = new StringBuilder();
    }

    public void setDepth(int depth2) {
      depth = depth2;
    }

    public StringBuilder getStringBuilder() {
      return builder;
    }

    public void append(String string) {
      append(string, depth);
    }

    public void append(String string, int depth) {
      for (int i = 0; i < depth; i++)
        builder.append("\t");
      builder.append(string);
    }

    public SubStringBuilder withDepth(int depth) {
      this.depth = depth;
      return this;
    }

    public SubStringBuilder in() {
      depth++;
      return this;
    }

    public SubStringBuilder out() {
      depth--;
      return this;
    }

    @Override
    public String toString() {
      return builder.toString();
    }
  }

}
