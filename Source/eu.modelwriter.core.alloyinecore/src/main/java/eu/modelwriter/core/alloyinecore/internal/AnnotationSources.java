/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore.internal;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ETypedElement;

public interface AnnotationSources {

  String BASE = "http://www.modelwriter.eu/alloyinecore";
  String IMPORT = AnnotationSources.BASE + "/import";
  String MODULE = AnnotationSources.BASE + "/model";
  String OPTIONS = AnnotationSources.BASE + "/options";
  String SOURCE = AnnotationSources.BASE + "/source";

  String VISIBILITY = AnnotationSources.BASE + "/visibility";
  String STATIC = AnnotationSources.BASE + "/static";
  String QUALIFIER = AnnotationSources.BASE + "/qualifier";
  String NULLABLE = AnnotationSources.BASE + "/nullable";
  String MODEL = AnnotationSources.BASE + "/model";
  String GHOST = AnnotationSources.BASE + "/ghost";

  String ATTR_EXPRESSIONS = AnnotationSources.BASE + "/attribute/expressions";
  String REF_EXPRESSIONS = AnnotationSources.BASE + "/reference/expressions";

  String INVARIANT = AnnotationSources.BASE + "/expression/invariant";
  String INITIAL = AnnotationSources.BASE + "/expression/initial";
  String DERIVATION = AnnotationSources.BASE + "/expression/derivation";

  String PRECONDITION = AnnotationSources.BASE + "/operation/precondition";
  String POSTCONDITION = AnnotationSources.BASE + "/operation/postcondition";
  String BODY = AnnotationSources.BASE + "/operation/body";

  String DATATYPE_PRIMITIVE = AnnotationSources.BASE + "/datatype/primitive";

  static boolean isStatic(final EModelElement element) {
    return element.getEAnnotation(AnnotationSources.STATIC) != null;
  }

  static boolean isPrimitive(final EDataType dataType) {
    return dataType.getEAnnotation(AnnotationSources.DATATYPE_PRIMITIVE) != null;
  }

  static boolean isNullable(final ETypedElement element) {
    boolean canBe = element.getUpperBound() == -1 || element.getUpperBound() > 1;
    return canBe && element.getEAnnotation(AnnotationSources.NULLABLE) != null;
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return Filtered annotations of AlloyInEcore
   */
  static List<EAnnotation> filterAnnotations(final EModelElement element,
                                                    final String filter) {
    return element.getEAnnotations().stream().filter(anno -> filter.equals(anno.getSource()))
        .collect(Collectors.toList());
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return Invariant annotations of AlloyInEcore
   */
  static List<EAnnotation> getInvariants(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.INVARIANT);
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return Derivation annotations of AlloyInEcore
   */
  static List<EAnnotation> getDerivation(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.DERIVATION);
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return Initial annotations of AlloyInEcore
   */
  static List<EAnnotation> getInitial(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.INITIAL);
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return The Import annotations
   */
  static List<EAnnotation> getImports(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.IMPORT);
  }

  /**
   *
   * @param element @EModelElement to get annotations from
   * @return The annotations other than AlloyInEcore
   */
  static List<EAnnotation> getAnnotations(final EModelElement element) {
    return element.getEAnnotations().stream().filter(
        anno -> anno.getSource() == null || !anno.getSource().startsWith(AnnotationSources.BASE))
        .collect(Collectors.toList());
  }

  static List<EAnnotation> getPostconditions(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.POSTCONDITION);
  }

  static List<EAnnotation> getPreconditions(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.PRECONDITION);
  }

  static List<EAnnotation> getBodyExpressions(final EModelElement element) {
    return AnnotationSources.filterAnnotations(element, AnnotationSources.BODY);
  }
}
