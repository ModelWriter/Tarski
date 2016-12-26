package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
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


public class Scanner extends RuleBasedScanner {

  public Scanner(ColorManager manager) {
    IToken aieKeyword =
        new Token(new TextAttribute(manager.getColor(ColorConstants.AIE_KEYWORD), null, SWT.BOLD));
    IToken keyword =
        new Token(new TextAttribute(manager.getColor(ColorConstants.KEYWORD), null, SWT.BOLD));
    IToken defaultToken = new Token(new TextAttribute(manager.getColor(ColorConstants.DEFAULT)));
    IToken stringToken = new Token(new TextAttribute(manager.getColor(ColorConstants.STRING)));
    final List<IRule> rules = new ArrayList<IRule>();
    // whitespace rule for skipping whitespaces.
    rules.add(new WhitespaceRule(new IWhitespaceDetector() {

      @Override
      public boolean isWhitespace(final char c) {
        return Character.isWhitespace(c);
      }
    }));

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

    Keywords.ALL_BUT_AIE.forEach(k -> {
      keywordRule.addWord(k, keyword);
    });

    for (int i = 0; i < Keywords.AIE.length; i++) {
      keywordRule.addWord(Keywords.AIE[i], aieKeyword);
    }
    rules.add(new MultiLineRule("\"", "\"", stringToken));
    rules.add(new MultiLineRule("\'", "\'", stringToken));
    rules.add(keywordRule);
    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    setRules(result);
  }
}
