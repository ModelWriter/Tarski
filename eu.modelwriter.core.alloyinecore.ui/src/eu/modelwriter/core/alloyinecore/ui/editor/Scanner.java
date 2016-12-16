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

  public static final String[] keywords = new String[] {"package", "class", "extends", "import",
      "public", "final", "private", "static", "invariant", "attribute", "operation", "enum",
      "datatype", "body", "precondition", "postcondition", "property"};

  public Scanner(ColorManager manager) {
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

    // add all keywords to keyword rule for keyword matching.
    for (int i = 0; i < keywords.length; i++) {
      keywordRule.addWord(keywords[i], keyword);
    }
    rules.add(new MultiLineRule("\'", "\'", stringToken));
    rules.add(keywordRule);
    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    setRules(result);
  }
}
