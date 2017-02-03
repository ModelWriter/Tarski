package eu.modelwriter.core.alloyinecore.ui.editor.scanner;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;

public class AIEPartitionScanner extends RuleBasedPartitionScanner implements IAIEPartitions {

  /**
   * Detector for empty comments.
   */
  static class EmptyCommentDetector implements IWordDetector {

    /*
     * @see IWordDetector#isWordStart
     */
    @Override
    public boolean isWordStart(final char c) {
      return c == '/';
    }

    /*
     * @see IWordDetector#isWordPart
     */
    @Override
    public boolean isWordPart(final char c) {
      return c == '*' || c == '/';
    }
  }

  /**
   * Word rule for empty comments.
   */
  static class EmptyCommentRule extends WordRule implements IPredicateRule {

    private final IToken fSuccessToken;

    /**
     * Constructor for EmptyCommentRule.
     * 
     * @param successToken
     */
    public EmptyCommentRule(final IToken successToken) {
      super(new EmptyCommentDetector());
      fSuccessToken = successToken;
      addWord("/**/", fSuccessToken);
    }

    /*
     * @see IPredicateRule#evaluate(ICharacterScanner, boolean)
     */
    @Override
    public IToken evaluate(final ICharacterScanner scanner, final boolean resume) {
      return evaluate(scanner);
    }

    /*
     * @see IPredicateRule#getSuccessToken()
     */
    @Override
    public IToken getSuccessToken() {
      return fSuccessToken;
    }
  }

  /**
   * Creates the partitioner and sets up the appropriate rules.
   */
  public AIEPartitionScanner() {
    super();
    final IToken dq_string = new Token(IAIEPartitions.AIE_DOUBLE_QUOTED_STRING);
    final IToken sq_string = new Token(IAIEPartitions.AIE_SINGLE_QUOTED_STRING);
    final IToken multiLineComment = new Token(IAIEPartitions.AIE_MULTI_LINE_COMMENT);
    final IToken singleLineComment = new Token(IAIEPartitions.AIE_SINGLE_LINE_COMMENT);

    final List<IPredicateRule> rules = new ArrayList<>();

    // Add rule for single line comments.
    rules.add(new EndOfLineRule("--", singleLineComment));

    // Add rule for single line comments.
    rules.add(new EndOfLineRule("//", singleLineComment));

    // Add rule for double-quoted strings.
    rules.add(new SingleLineRule("\"", "\"", dq_string, '\\'));

    // Add rule for single-quoted strings.
    rules.add(new SingleLineRule("'", "'", sq_string, '\\'));

    // Add special case word rule.
    final EmptyCommentRule wordRule = new EmptyCommentRule(multiLineComment);
    rules.add(wordRule);

    // Add rules for multi-line comments.
    rules.add(new MultiLineRule("/*", "*/", multiLineComment));

    final IPredicateRule[] result = new IPredicateRule[rules.size()];
    rules.toArray(result);
    setPredicateRules(result);
  }
}
