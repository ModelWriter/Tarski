package eu.modelwriter.specification.editor.scanner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class FactScanner extends RuleBasedScanner {

  public static final String[] keywords =
      new String[] {"fact", "none", "univ", "iden", "this", "not", "no", "lone", "some", "one",
          "set", "or", "and", "iff", "implies", "in", "else", "let", "all", "sum", "disj"};

  public FactScanner() {
    final IToken keywordToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(65, 105, 225))));
    final IToken defaultToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(0, 0, 0))));

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

    // add all keywords to keyword rule for keyword matching.
    for (int i = 0; i < FactScanner.keywords.length; i++) {
      keywordRule.addWord(FactScanner.keywords[i], keywordToken);
    }
    rules.add(keywordRule);

    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    this.setRules(result);
  }
}
