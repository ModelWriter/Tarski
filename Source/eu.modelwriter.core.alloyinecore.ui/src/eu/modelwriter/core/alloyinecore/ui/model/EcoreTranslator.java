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

  private final static String STATIC_ANNO = "http://www.modelwriter.eu/AlloyInEcore/Static";

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

  public static StringBuilder translate(final EPackage ePackage) {
    final SubStringBuilder builder = new SubStringBuilder();
    EcoreTranslator.appendImports(builder.withDepth(0), ePackage);
    // appendPackage(builder.withDepth(0), ePackage);
    EcoreTranslator.recAppendPackage(builder, ePackage, 0);
    return builder.getStringBuilder();
  }

  private static void recAppendPackage(final SubStringBuilder builder, final EPackage ePackage, final int depth) {
    EcoreTranslator.appendPackage(builder.withDepth(depth), ePackage);
    for (final EPackage subEPackage : ePackage.getESubpackages()) {
      EcoreTranslator.recAppendPackage(builder, subEPackage, depth + 1);
    }
    builder.append("}\n", depth);
  }

  private static void appendImports(final SubStringBuilder builder, final EPackage ePackage) {
    final List<EAnnotation> imports = ePackage.getEAnnotations().stream()
        .filter(e -> EcoreTranslator.IMPORT_NAMESPACE.equals(e.getSource())).collect(Collectors.toList());
    for (final EAnnotation eAnnotation : imports) {
      for (final Entry<String, String> entry : eAnnotation.getDetails().entrySet()) {
        builder.append(String.format(EcoreTranslator.IMPORT_PATTERN, entry.getKey(), entry.getValue()));
      }
    }
  }

  private static void appendPackage(final SubStringBuilder builder, final EPackage ePackage) {
    builder.append(String.format(EcoreTranslator.PACKAGE_PATTERN, EcoreTranslator.getVisibility(ePackage), ePackage.getName(),
        ePackage.getNsPrefix(), ePackage.getNsURI(), EcoreTranslator.getPackageContent(ePackage, builder.depth)));
  }

  private static String getPackageContent(final EPackage ePackage, final int depth) {
    final SubStringBuilder subBuilder = new SubStringBuilder();
    subBuilder.setDepth(depth);
    subBuilder.append("{\n", depth);
    for (final EObject eObject : ePackage.eContents()) {
      if (eObject instanceof EClass) {
        EcoreTranslator.appendClass(subBuilder, (EClass) eObject);
      }
      if (eObject instanceof EEnum) {
        EcoreTranslator.appendEnum(subBuilder, (EEnum) eObject);
      }
      if (eObject instanceof EDataType) {
        EcoreTranslator.appenDataType(subBuilder, (EDataType) eObject);
      }
    }
    return subBuilder.toString();
  }

  private static void appenDataType(final SubStringBuilder subBuilder, final EDataType eDataType) {
    final EAnnotation anno = eDataType.getEAnnotation(EcoreTranslator.DATATYPE_ANNO);
    final String primitive = anno == null ? "" : "primitive ";
    subBuilder.append(
        String.format(EcoreTranslator.DATATYPE_PATTERN, primitive, eDataType.getName(),
            eDataType.getInstanceTypeName(),
            eDataType.isSerializable() ? "serializable" : "!serializable",
                EcoreTranslator.getExpressions(eDataType, EcoreTranslator.DATATYPE_PRIMITIVE_ANNO, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static void appendEnum(final SubStringBuilder subBuilder, final EEnum eEnum) {
    subBuilder.append(String.format(EcoreTranslator.ENUM_PATTERN, EcoreTranslator.getVisibilityAndQualifier(eEnum), eEnum.getName(),
        eEnum.getInstanceTypeName(), eEnum.isSerializable() ? "serializable" : "!serializable",
            EcoreTranslator.getLiterals(eEnum, subBuilder.depth + 1)), subBuilder.depth + 1);
  }

  private static String getLiterals(final EEnum eEnum, final int depth) {
    final SubStringBuilder subBuilder = new SubStringBuilder();
    final EAnnotation expressions = eEnum.getEAnnotation(EcoreTranslator.ENUM_ANNO);
    if (expressions != null && !expressions.getDetails().isEmpty()
        || !eEnum.getELiterals().isEmpty()) {
      subBuilder.append("\n");
      subBuilder.append("{\n", depth);
      for (final EEnumLiteral literal : eEnum.getELiterals()) {
        subBuilder.append("literal " + literal.getName() + " = " + literal.getValue() + ";",
            depth + 1);
      }
      if (expressions != null && !expressions.getDetails().isEmpty()) {
        for (final Entry<String, String> entry : expressions.getDetails()) {
          subBuilder.append(entry.getKey() + ": " + entry.getValue() + ";", depth + 1);
        }
      }
      subBuilder.append("\n");
      subBuilder.append("}", depth);
    }
    return subBuilder.toString();
  }

  private static void appendClass(final SubStringBuilder subBuilder, final EClass eClass) {
    String supers = "";
    if (!eClass.getESuperTypes().isEmpty()) {
      supers += " extends ";
      for (final EClass superEClass : eClass.getESuperTypes()) {
        supers += superEClass.getName() + ", ";
      }
      // FIXME remove last comma
      supers.replaceAll(",\\s*$", "");
    }
    subBuilder.append(String.format(EcoreTranslator.CLASS_PATTERN, EcoreTranslator.getVisibilityAndQualifier(eClass),
        eClass.getName(), supers, EcoreTranslator.getClassContent(eClass, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static String getClassContent(final EClass eClass, final int depth) {
    final SubStringBuilder subBuilder = new SubStringBuilder();
    subBuilder.setDepth(depth);
    subBuilder.append("{\n", depth);
    for (final EObject eObject : eClass.eContents()) {
      if (eObject instanceof EOperation) {
        EcoreTranslator.appendOperation(subBuilder, (EOperation) eObject);
      }
      if (eObject instanceof EAttribute) {
        EcoreTranslator.appendAttribute(subBuilder, (EAttribute) eObject);
      }
      if (eObject instanceof EReference) {
        EcoreTranslator.appendReference(subBuilder, (EReference) eObject);
      }
    }
    EcoreTranslator.appenClassConstraits(subBuilder, eClass);
    subBuilder.append("}\n", depth);
    return subBuilder.toString();
  }

  private static void appenClassConstraits(final SubStringBuilder subBuilder, final EClass eClass) {
    final EAnnotation constraitExpressions = eClass.getEAnnotation(EcoreTranslator.CONSTRAIT_EXPS_ANNO);
    if (constraitExpressions != null) {
      for (final Entry<String, String> entry : constraitExpressions.getDetails()) {
        subBuilder.append(String.format(EcoreTranslator.INV_PATTERN, entry.getKey(), entry.getValue()),
            subBuilder.depth + 1);
      }
    }
  }

  private static void appendAttribute(final SubStringBuilder subBuilder, final EAttribute eAttribute) {
    subBuilder.append(
        String.format(EcoreTranslator.ATTR_PATTERN, EcoreTranslator.getVisibilityAndQualifier(eAttribute), eAttribute.getName(),
            eAttribute.getEAttributeType().getName(), EcoreTranslator.getMultiplicity(eAttribute),
            EcoreTranslator.getExpressions(eAttribute, EcoreTranslator.ATTRIBUTE_ANNO, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static void appendReference(final SubStringBuilder subBuilder, final EReference eReference) {
    final String opposite =
        eReference.getEOpposite() == null ? "" : "#" + eReference.getEOpposite().getName();
    subBuilder.append(
        String.format(EcoreTranslator.PROPERTY_PATTERN, EcoreTranslator.getVisibilityAndQualifier(eReference), eReference.getName(),
            opposite, eReference.getEReferenceType().getName(), EcoreTranslator.getMultiplicity(eReference),
            EcoreTranslator.getQualifiers(eReference),
            EcoreTranslator.getExpressions(eReference, EcoreTranslator.REFERENCE_ANNO, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static void appendOperation(final SubStringBuilder subBuilder, final EOperation eOperation) {
    subBuilder.append(
        String.format(EcoreTranslator.OP_PATTERN, EcoreTranslator.getVisibilityAndQualifier(eOperation), eOperation.getName(),
            eOperation.getEType().getName(), EcoreTranslator.getMultiplicity(eOperation),
            EcoreTranslator.getExpressions(eOperation, EcoreTranslator.OPERATION_ANNO, subBuilder.depth + 1)),
        subBuilder.depth + 1);
  }

  private static String getExpressions(final ENamedElement element, final String annotationSource, final int depth) {
    final SubStringBuilder subBuilder = new SubStringBuilder();
    subBuilder.setDepth(depth);
    final EAnnotation expressions = element.getEAnnotation(annotationSource);
    if (expressions != null && !expressions.getDetails().isEmpty()) {
      subBuilder.append("\n");
      subBuilder.append("{\n", depth);
      for (final Entry<String, String> entry : expressions.getDetails()) {
        subBuilder.append(entry.getKey() + ": " + entry.getValue() + ";", depth + 1);
      }
      subBuilder.append("\n");
      subBuilder.append("}", depth);
    } else {
      subBuilder.append(";", 0);
    }
    return subBuilder.toString();
  }

  private static String getMultiplicity(final ETypedElement eTypedElement) {
    final int l = eTypedElement.getLowerBound();
    final int u = eTypedElement.getUpperBound();
    if (l == 0 && u == 1) {
      return "?";
    }
    if (l == 0 && u == -1) {
      return "*";
    }
    if (l == 1 && u == 1) {
      return "1";
    }
    if (l == 1 && u == -1) {
      return "+";
    }

    return l + ".." + u;
  }

  private static String getVisibilityAndQualifier(final ENamedElement element) {
    final String visibility = EcoreTranslator.getVisibility(element);
    final String qualifier = EcoreTranslator.getQualifier(element);
    return visibility + (qualifier.isEmpty() ? "" : qualifier + " ");
  }

  private static String getVisibility(final ENamedElement element) {
    String visibility = "";
    final EAnnotation visibilityAnno = element.getEAnnotation(EcoreTranslator.VISIBILTY_ANNO);
    if (visibilityAnno != null && !visibilityAnno.getDetails().isEmpty()) {
      visibility = visibilityAnno.getDetails().get("visibility");
    }
    return visibility.isEmpty() ? "" : visibility + " ";
  }

  private static String getQualifier(final ENamedElement element) {
    String qualifier = "";
    final EAnnotation qualifierAnno = element.getEAnnotation(EcoreTranslator.QUALIFIER_ANNO);
    if (qualifierAnno != null && !qualifierAnno.getDetails().isEmpty()) {
      qualifier = qualifierAnno.getDetails().get("qualifier");
    }
    return qualifier;
  }

  private static String getQualifiers(final EStructuralFeature eStructuralFeature) {
    final StringBuilder subBuilder = new StringBuilder();
    subBuilder.append(" { ");
    if (!eStructuralFeature.isUnique()) {
      subBuilder.append("!unique ");
    }
    if (eStructuralFeature.isDerived()) {
      subBuilder.append("derived ");
    }
    if (eStructuralFeature.isVolatile()) {
      subBuilder.append("volatile ");
    }
    if (eStructuralFeature.isUnsettable()) {
      subBuilder.append("unsettable ");
    }
    if (eStructuralFeature.isTransient()) {
      subBuilder.append("transient ");
    }
    if (eStructuralFeature.isOrdered()) {
      subBuilder.append("ordered ");
    }
    if (!eStructuralFeature.isChangeable()) {
      subBuilder.append("readonly ");
    }

    if (eStructuralFeature instanceof EAttribute && ((EAttribute) eStructuralFeature).isID()) {
      subBuilder.append("id ");
    }
    if (eStructuralFeature instanceof EReference
        && ((EReference) eStructuralFeature).isContainment()) {
      subBuilder.append("composes ");
    }

    // if there is no qualifier, delete curly bracket
    if (subBuilder.charAt(subBuilder.length() - 2) == '{') {
      subBuilder.delete(subBuilder.length() - 3, subBuilder.length());
    } else {
      subBuilder.append("}");
    }
    // TODO check other qualifiers, maybe?
    return subBuilder.toString();
  }

  public static class SubStringBuilder {
    StringBuilder builder;
    private int depth = 0;

    public SubStringBuilder() {
      builder = new StringBuilder();
    }

    public void setDepth(final int depth2) {
      depth = depth2;
    }

    public StringBuilder getStringBuilder() {
      return builder;
    }

    public void append(final String string) {
      append(string, depth);
    }

    public void append(final String string, final int depth) {
      for (int i = 0; i < depth; i++) {
        builder.append("\t");
      }
      builder.append(string);
    }

    public SubStringBuilder withDepth(final int depth) {
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
