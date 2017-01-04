package eu.modelwriter.core.alloyinecore.ui.cs2as;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;

public interface AnnotationSources {

  public final static String BASE = "http://www.modelwriter.eu/AlloyInEcore";
  public final static String IMPORT = AnnotationSources.BASE + "/Import";
  public static final String MODULE = AnnotationSources.BASE + "/Module";
  public static final String OPTIONS = AnnotationSources.BASE + "/Options";

  public final static String VISIBILITY = AnnotationSources.BASE + "/Visibility";
  public final static String STATIC = AnnotationSources.BASE + "/Static";
  public final static String QUALIFIER = AnnotationSources.BASE + "/Qualifier";
  public final static String NULLABLE = AnnotationSources.BASE + "/Nullable";
  public final static String MODEL = AnnotationSources.BASE + "/Model";
  public final static String GHOST = AnnotationSources.BASE + "/Ghost";

  public final static String ATTR_EXPRESSIONS = AnnotationSources.BASE + "/Attribute/Expressions";
  public final static String REF_EXPRESSIONS = AnnotationSources.BASE + "/Reference/Expressions";

  public final static String INVARIANT = AnnotationSources.BASE + "/Expression/Invariant";
  public static final String INITIAL = AnnotationSources.BASE + "/Expression/Initial";
  public static final String DERIVATION = AnnotationSources.BASE + "/Expression/Derivation";

  public final static String PRECONDITION = AnnotationSources.BASE + "/Operation/Precondition";
  public final static String POSTCONDITION = AnnotationSources.BASE + "/Operation/Postcondition";
  public final static String BODY = AnnotationSources.BASE + "/Operation/Body";

  public final static String DATATYPE_PRIMITIVE = AnnotationSources.BASE + "/DataType/Primitive";

  public static final String EXCEPTION = AnnotationSources.BASE + "/Exception";

  public static boolean isStatic(final EModelElement element) {
    return element.getEAnnotation(AnnotationSources.STATIC) != null;
  }

  public static boolean isPrimitive(final EDataType dataType) {
    return dataType.getEAnnotation(AnnotationSources.DATATYPE_PRIMITIVE) != null;
  }

  public static boolean isNullable(final EModelElement element) {
    return element.getEAnnotation(AnnotationSources.NULLABLE) != null;
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return Filtered annotations of AlloyInEcore
   */
  public static List<EAnnotation> filterAnnotations(final EModelElement element,
      final String filter) {
    return element.getEAnnotations().stream().filter(anno -> filter.equals(anno.getSource()))
        .collect(Collectors.toList());
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return Invariant annotations of AlloyInEcore
   */
  public static List<EAnnotation> getInvariants(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.INVARIANT);
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return Derivation annotations of AlloyInEcore
   */
  public static List<EAnnotation> getDerivation(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.DERIVATION);
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return Initial annotations of AlloyInEcore
   */
  public static List<EAnnotation> getInitial(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.INITIAL);
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return The Import annotations
   */
  public static List<EAnnotation> getImports(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.IMPORT);
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return The annotations other than AlloyInEcore
   */
  public static List<EAnnotation> getAnnotations(final EModelElement element) {
    return element.getEAnnotations().stream().filter(
        anno -> anno.getSource() == null || !anno.getSource().startsWith(AnnotationSources.BASE))
        .collect(Collectors.toList());
  }

  public static List<EAnnotation> getPostconditions(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.POSTCONDITION);
  }

  public static List<EAnnotation> getPreconditions(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.PRECONDITION);
  }

  public static List<EAnnotation> getBodyExpressions(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.BODY);
  }
}
