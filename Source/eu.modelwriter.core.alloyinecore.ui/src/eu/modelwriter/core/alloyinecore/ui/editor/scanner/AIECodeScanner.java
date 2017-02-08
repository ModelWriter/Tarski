package eu.modelwriter.core.alloyinecore.ui.editor.scanner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

import eu.modelwriter.core.alloyinecore.ui.editor.AIEKeywords;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IAIEColorConstants;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IColorManager;

public class AIECodeScanner extends RuleBasedScanner {

  protected IToken defaultToken;
  protected IToken keyword;
  protected IToken stringToken;
  protected IToken singlelineToken;
  protected IToken multilineToken;
  protected IToken aieKeyword;

  public AIECodeScanner(final IColorManager manager) {
    defaultToken = new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_DEFAULT)));
    aieKeyword = new Token(
        new TextAttribute(manager.getColor(IAIEColorConstants.AIE_KEYWORD), null, SWT.BOLD));
    keyword =
        new Token(new TextAttribute(manager.getColor(IAIEColorConstants.KEYWORD), null, SWT.BOLD));
    stringToken = new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_STRING)));
    singlelineToken =
        new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_SINGLE_LINE_COMMENT)));
    multilineToken =
        new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_MULTI_LINE_COMMENT)));
    configureRules();
  }

  public void configureRules() {
    final List<IRule> rules = new ArrayList<IRule>();
    rules.addAll(getCommentRules());
    final WordRule keywordRule = new WordRule(new IWordDetector() {

      @Override
      public boolean isWordPart(final char c) {
        return Character.isLetter(c);
      }

      @Override
      public boolean isWordStart(final char c) {
        return Character.isLetter(c);
      }
    }, defaultToken);

    AIEKeywords.ALL_BUT_AIE.forEach(k -> {
      keywordRule.addWord(k, keyword);
    });

    for (int i = 0; i < AIEKeywords.AIE.length; i++) {
      keywordRule.addWord(AIEKeywords.AIE[i], aieKeyword);
    }
    rules.add(keywordRule);

    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    setRules(result);
  }

  protected List<IRule> getCommentRules() {
    final List<IRule> rules = new ArrayList<IRule>();

    rules.add(new MultiLineRule("\"", "\"", stringToken, '\\'));
    rules.add(new MultiLineRule("'", "'", stringToken, '\\'));

    // Add rules for multi-line comments.
    rules.add(new MultiLineRule("/*", "*/", multilineToken));
    // Add rule for single line comments.
    rules.add(new EndOfLineRule("--", singlelineToken));

    // whitespace rule for skipping whitespaces.
    rules.add(new WhitespaceRule(new IWhitespaceDetector() {

      @Override
      public boolean isWhitespace(final char c) {
        return Character.isWhitespace(c);
      }
    }));
    return rules;
  }
}
