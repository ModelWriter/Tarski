package eu.modelwriter.core.alloyinecore.ui.editor.scanner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

import eu.modelwriter.core.alloyinecore.ui.editor.AIEKeywords;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IAIEColorConstants;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IColorManager;

public class AbstractAIEScanner extends RuleBasedScanner {

  public AbstractAIEScanner(final IColorManager manager) {
    final IToken aieKeyword = new Token(
        new TextAttribute(manager.getColor(IAIEColorConstants.AIE_KEYWORD), null, SWT.BOLD));
    final IToken keyword =
        new Token(new TextAttribute(manager.getColor(IAIEColorConstants.KEYWORD), null, SWT.BOLD));
    final IToken defaultToken =
        new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_DEFAULT)));

    final List<IRule> rules = new ArrayList<IRule>();

    // whitespace rule for skipping whitespaces.
    rules.add(new WhitespaceRule(new AIEWhitespaceDetector()));

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
}
