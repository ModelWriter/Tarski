package eu.modelwriter.kodkod.editor.scanners;

import java.util.ArrayList;
import java.util.Arrays;
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

import eu.modelwriter.kodkod.editor.ColorManager;
import eu.modelwriter.kodkod.editor.IColorConstants;

public class FormulasScanner extends RuleBasedScanner {
  public static final String[] formulasKeywords =
      new String[] {"no", "lone", "one", "some", "not", "in", "sum", "acyclic", "function", "ord",
          "and", "or", "if", "iff", "all", "let", "true", "false", "then", "else", "iden", "none",
          "univ", "ints", "plus", "minus", "mul", "div", "modulo", "disj", "set"};

  public static final ArrayList<String> formulasSpecChars =
      new ArrayList<String>(Arrays.asList("!", "=", "<", "<=", ">", ">=", "->", "&&", "||", "=>",
          "<=>", "~", "^", "*", "+", "&", "-", ".", ".*", ".^", "++", "#", "/", "%"));

  public FormulasScanner(final ColorManager manager) {
    final IToken keywordToken =
        new Token(new TextAttribute(manager.getColor(IColorConstants.FORMULAS_KEYWORD)));
    final IToken specCharsToken =
        new Token(new TextAttribute(manager.getColor(IColorConstants.FORMULAS_SPECCHARS)));
    final IToken defaultToken =
        new Token(new TextAttribute(manager.getColor(IColorConstants.DEFAULT)));

    final List<IRule> rules = new ArrayList<IRule>();

    rules.add(new WhitespaceRule(new IWhitespaceDetector() {

      @Override
      public boolean isWhitespace(final char c) {
        return Character.isWhitespace(c);
      }
    }));

    final WordRule specCharsRule = new WordRule(new IWordDetector() {

      @Override
      public boolean isWordPart(final char c) {
        return FormulasScanner.formulasSpecChars.contains(String.valueOf(c));
      }

      @Override
      public boolean isWordStart(final char c) {
        return FormulasScanner.formulasSpecChars.contains(String.valueOf(c));
      }
    }, defaultToken);

    for (final String chars : FormulasScanner.formulasSpecChars) {
      specCharsRule.addWord(chars, specCharsToken);
    }
    rules.add(specCharsRule);

    final WordRule keywordRule = new WordRule(new IWordDetector() {

      @Override
      public boolean isWordPart(final char c) {
        return Character.isAlphabetic(c);
      }

      @Override
      public boolean isWordStart(final char c) {
        return Character.isAlphabetic(c);
      }
    }, defaultToken);

    for (int i = 0; i < FormulasScanner.formulasKeywords.length; i++) {
      keywordRule.addWord(FormulasScanner.formulasKeywords[i], keywordToken);
    }
    rules.add(keywordRule);

    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    this.setRules(result);
  }
}
