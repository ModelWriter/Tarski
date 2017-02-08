package eu.modelwriter.core.alloyinecore.ui.editor.color;

/**
 * Color keys used for syntax highlighting AlloyInEcore code and comments. A
 * <code>IColorManager</code> is responsible for mapping concrete colors to these keys.
 * <p>
 * This interface declares static final fields only; it is not intended to be implemented.
 * </p>
 *
 * @see eu.modelwriter.core.alloyinecore.ui.editor.color.jdt.ui.text.IColorManager
 * @see eu.modelwriter.core.alloyinecore.ui.editor.color.jdt.ui.text.IColorManagerExtension
 *
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface IAIEColorConstants {

  /**
   * Note: This constant is for internal use only. Clients should not use this constant. The prefix
   * all color constants start with (value <code>"aie_"</code>).
   */
  String PREFIX = "aie_";

  /**
   * The color key for multi-line comments in AlloyInEcore code (value
   * <code>"aie_multi_line_comment"</code>).
   */
  String AIE_MULTI_LINE_COMMENT = "aie_multi_line_comment";

  /**
   * The color key for single-line comments in AlloyInEcore code (value
   * <code>"aie_single_line_comment"</code>).
   */
  String AIE_SINGLE_LINE_COMMENT = "aie_single_line_comment";

  /**
   * The color key for keywords in AlloyInEcore code (value <code>"keyword"</code>).
   */
  String KEYWORD = "keyword";

  /**
   * The color key for AlloyInEcore keywords in AlloyInEcore code (value
   * <code>"aie_keyword"</code>).
   */
  String AIE_KEYWORD = "aie_keyword";

  /**
   * The color key for AlloyInEcore keywords in AlloyInEcore code (value
   * <code>"aie_keyword"</code>).
   */
  String AIE_INSTANCE_SF_KEYWORD = "aie_instance_sf_keyword";

  /**
   * The color key for string and character literals in AlloyInEcore code (value
   * <code>"aie_string"</code>).
   */
  String AIE_STRING = "aie_string";

  /**
   * The color key for operators in AlloyInEcore code (value <code>"aie_operator"</code>).
   */
  String AIE_OPERATOR = "aie_operator";

  /**
   * The color key for brackets in AlloyInEcore code (value <code>"aie_bracket"</code>).
   */
  String AIE_BRACKET = "aie_bracket";

  /**
   * The color key for everything in AlloyInEcore code for which no other color is specified (value
   * <code>"aie_default"</code>).
   */
  String AIE_DEFAULT = "aie_default";

  /**
   * The color key for annotations (value <code>"aie_annotation"</code>).
   */
  String AIE_ANNOTATION = "aie_annotation";
}
