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

  String[] ALL_PARTITIONS = new String[] {IAIEPartitions.AIE_DEFAULT,
      IAIEPartitions.AIE_SINGLE_LINE_COMMENT, IAIEPartitions.AIE_MULTI_LINE_COMMENT,
      IAIEPartitions.AIE_DOUBLE_QUOTED_STRING, IAIEPartitions.AIE_SINGLE_QUOTED_STRING};
}
