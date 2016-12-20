package eu.modelwriter.core.alloyinecore.ui.cs2as;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;

public interface AnnotationSources {

  public final static String BASE = "http://www.modelwriter.eu/AlloyInEcore/";
  public final static String IMPORT = BASE + "Import";

  public final static String VISIBILTY = BASE + "Visibility";
  public final static String STATIC = BASE + "Static";
  public final static String QUALIFIER = BASE + "Qualifier";
  public final static String NULLABLE = BASE + "Nullable";
  public final static String INVARIANT = BASE + "Invariant";

  public final static String ATTR_EXPRESSIONS = BASE + "Attribute/Expressions";
  public final static String REF_EXPRESSIONS = BASE + "Reference/Expressions";

  public final static String PRECONDITION = BASE + "Operation/Precondition";
  public final static String POSTCONDITION = BASE + "Operation/Postcondition";
  public final static String BODY = BASE + "Operation/Body";

  public final static String DATATYPE_PRIMITIVE = BASE + "DataType/Primitive";

  public static boolean isStatic(EModelElement element) {
    return element.getEAnnotation(STATIC) != null;
  }

  public static boolean isPrimitive(EDataType dataType) {
    return dataType.getEAnnotation(DATATYPE_PRIMITIVE) != null;
  }

  public static boolean isNullable(EModelElement element) {
    return element.getEAnnotation(NULLABLE) != null;
  }

  /**
   * 
   * @param element @EModelElement to get annotations from
   * @return Invariant annotations of AlloyInEcore
   */
  public static List<EAnnotation> getInvariants(EModelElement element) {
    return element.getEAnnotations().stream().filter(anno -> INVARIANT.equals(anno.getSource()))
        .collect(Collectors.toList());
  }

  /**
   * 
   * @param element @EModelElement to get annotations from
   * @return The annotations other than AlloyInEcore
   */
  public static List<EAnnotation> getAnnotations(EModelElement element) {
    return element.getEAnnotations().stream()
        .filter(anno -> anno.getSource() == null || !anno.getSource().startsWith(BASE))
        .collect(Collectors.toList());
  }

}
