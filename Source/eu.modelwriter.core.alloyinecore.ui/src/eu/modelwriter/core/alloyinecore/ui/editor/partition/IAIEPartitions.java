package eu.modelwriter.core.alloyinecore.ui.editor.partition;

import org.eclipse.jface.text.IDocument;

/**
 * Definition of AlloyInEcore partitioning and its partitions.
 */
public interface IAIEPartitions {
  /**
   * The identifier of the AlloyInEcore partitioning.
   */
  String AIE_PARTITIONING = "___alloyinecore_partitioning";

  /**
   * The identifier of prefix for all partitions.
   */
  String AIE_PREFIX = "__alloyinecore";

  /**
   * The identifier of the single-line (EndOfLineComment) end comment partition content type.
   */
  String AIE_DEFAULT = IDocument.DEFAULT_CONTENT_TYPE;

  /**
   * The identifier of the single-line (EndOfLineComment) end comment partition content type.
   */
  String AIE_SINGLE_LINE_COMMENT = IAIEPartitions.AIE_PREFIX + "_singleline_comment";

  /**
   * The identifier multi-line (TraditionalComment) comment partition content type.
   */
  String AIE_MULTI_LINE_COMMENT = IAIEPartitions.AIE_PREFIX + "_multiline_comment";

  /**
   * The identifier of the AlloyInEcore string partition content type.
   */
  String AIE_DOUBLE_QUOTED_STRING = IAIEPartitions.AIE_PREFIX + "_single_quoted_string";

  /**
   * The identifier of the AlloyInEcore character partition content type.
   */
  String AIE_SINGLE_QUOTED_STRING = IAIEPartitions.AIE_PREFIX + "_single_quoted_string";

  /**
   * The identifier of the AlloyInEcore module partition content type.
   */
  String AIE_MODULE = IAIEPartitions.AIE_PREFIX + "_module";

  String AIE_OPTIONS = IAIEPartitions.AIE_PREFIX + "_options";

  String AIE_IMPORT = IAIEPartitions.AIE_PREFIX + "_import";
  /**
   * The identifier of the AlloyInEcore package partition content type.
   */
  String AIE_PACKAGE = IAIEPartitions.AIE_PREFIX + "_package";

  /**
   * The identifier of the AlloyInEcore class partition content type.
   */
  String AIE_CLASS = IAIEPartitions.AIE_PREFIX + "_class";

  String AIE_ATTRIBUTE = IAIEPartitions.AIE_PREFIX + "_attribute";

  String AIE_REFERENCE = IAIEPartitions.AIE_PREFIX + "_reference";

  String AIE_OPERATION = IAIEPartitions.AIE_PREFIX + "_operation";

  String AIE_EXCEPTION = IAIEPartitions.AIE_PREFIX + "_exception";

  String AIE_SUPERTYPE = IAIEPartitions.AIE_PREFIX + "_supertype";

  String AIE_PARAMETER = IAIEPartitions.AIE_PREFIX + "_parameter";

  String AIE_DATATYPE = IAIEPartitions.AIE_PREFIX + "_datatype";

  String AIE_ENUM = IAIEPartitions.AIE_PREFIX + "_enum";

  String AIE_ENUM_LITERAL = IAIEPartitions.AIE_PREFIX + IAIEPartitions.AIE_ENUM + "_literal";

  String AIE_ANNOTATION = IAIEPartitions.AIE_PREFIX + "_annotation";

  String AIE_MODEL_ELEMENT_REF = IAIEPartitions.AIE_PREFIX + "_model_element_ref";

  String AIE_TEMPLATE_SIGNATURE = IAIEPartitions.AIE_PREFIX + "_template_signature";

  String AIE_TYPE_PARAMETER = IAIEPartitions.AIE_PREFIX + "_type_parameter";

  String AIE_GENERIC_TYPE = IAIEPartitions.AIE_PREFIX + "_generic_type";

  String AIE_GENERIC_WILD_CARD = IAIEPartitions.AIE_PREFIX + "_generic_wild_card";

  String AIE_PRIMITIVE_TYPE = IAIEPartitions.AIE_PREFIX + "_primitive_type";

  String AIE_BODY = IAIEPartitions.AIE_PREFIX + "_body";

  String AIE_INVARIANT = IAIEPartitions.AIE_PREFIX + "_invariant";

  String AIE_PRECONDITION = IAIEPartitions.AIE_PREFIX + "_precondition";

  String AIE_POSTCONDITION = IAIEPartitions.AIE_PREFIX + "_postcondition";

  String AIE_INITIAL = IAIEPartitions.AIE_PREFIX + "_initial";

  String AIE_DERIVATION = IAIEPartitions.AIE_PREFIX + "_derivation";

  String AIE_EXPRESSION = IAIEPartitions.AIE_PREFIX + "_expression";

  String AIE_FORMULA = IAIEPartitions.AIE_PREFIX + "_formula";

  String[] ALL_PARTITIONS = new String[] {IAIEPartitions.AIE_DEFAULT,
      IAIEPartitions.AIE_SINGLE_LINE_COMMENT, IAIEPartitions.AIE_MULTI_LINE_COMMENT,
      IAIEPartitions.AIE_DOUBLE_QUOTED_STRING, IAIEPartitions.AIE_SINGLE_QUOTED_STRING,
      IAIEPartitions.AIE_MODULE, IAIEPartitions.AIE_OPTIONS, IAIEPartitions.AIE_IMPORT,
      IAIEPartitions.AIE_PACKAGE, IAIEPartitions.AIE_CLASS, IAIEPartitions.AIE_ATTRIBUTE,
      IAIEPartitions.AIE_REFERENCE, IAIEPartitions.AIE_OPERATION, IAIEPartitions.AIE_EXCEPTION,
      IAIEPartitions.AIE_SUPERTYPE, IAIEPartitions.AIE_PARAMETER, IAIEPartitions.AIE_DATATYPE,
      IAIEPartitions.AIE_ENUM, IAIEPartitions.AIE_ENUM_LITERAL, IAIEPartitions.AIE_ANNOTATION,
      IAIEPartitions.AIE_MODEL_ELEMENT_REF, IAIEPartitions.AIE_TEMPLATE_SIGNATURE,
      IAIEPartitions.AIE_TYPE_PARAMETER, IAIEPartitions.AIE_GENERIC_TYPE,
      IAIEPartitions.AIE_GENERIC_WILD_CARD, IAIEPartitions.AIE_PRIMITIVE_TYPE,
      IAIEPartitions.AIE_BODY, IAIEPartitions.AIE_INVARIANT, IAIEPartitions.AIE_PRECONDITION,
      IAIEPartitions.AIE_POSTCONDITION, IAIEPartitions.AIE_INITIAL, IAIEPartitions.AIE_DERIVATION,
      IAIEPartitions.AIE_EXPRESSION, IAIEPartitions.AIE_FORMULA};
}
