package eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

import eu.modelwriter.core.alloyinecore.ui.editor.color.IAIEColorConstants;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IColorManager;
import eu.modelwriter.core.alloyinecore.ui.editor.scanner.AIECodeScanner;

public class AIEInstanceCodeScanner extends AIECodeScanner {

  protected IToken sfKeyword;

  public AIEInstanceCodeScanner(final IColorManager manager) {
    super(manager);
    sfKeyword =
        new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_INSTANCE_SF_KEYWORD),
            null, SWT.BOLD));
  }

  public void updateRules(Set<String> keywords, Set<String> sfKeywords) {
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
    keywords.forEach(k -> {
      keywordRule.addWord(k, keyword);
    });
    sfKeywords.forEach(k -> {
      keywordRule.addWord(k, sfKeyword);
    });
    keywordRule.addWord("import", keyword);
    keywordRule.addWord("model", keyword);

    rules.add(keywordRule);
    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    setRules(result);
  }
}
