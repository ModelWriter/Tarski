package eu.modelwriter.kodkod.editor.scanners;

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

import eu.modelwriter.kodkod.editor.ColorManager;
import eu.modelwriter.kodkod.editor.IColorConstants;

public class OptionScanner extends RuleBasedScanner {

	private static final String[] optionKeywords = new String[] { "symmetry_breaking", "bit_width", "skolem_depth",
			"sharing" };

	public OptionScanner(ColorManager manager) {
		final IToken keywordToken = new Token(new TextAttribute(manager.getColor(IColorConstants.OPTIONS_KEYWORD)));
		final IToken defaultToken = new Token(new TextAttribute(manager.getColor(IColorConstants.OPTIONS_DEFAULT)));

		final List<IRule> rules = new ArrayList<IRule>();

		rules.add(new WhitespaceRule(new IWhitespaceDetector() {

			@Override
			public boolean isWhitespace(final char c) {
				return Character.isWhitespace(c);
			}
		}));

		final WordRule keywordRule = new WordRule(new IWordDetector() {

			@Override
			public boolean isWordPart(final char c) {
				return (Character.isLetter(c) | c == '_');
			}

			@Override
			public boolean isWordStart(final char c) {
				return Character.isLetter(c);
			}
		}, defaultToken);

		for (int i = 0; i < optionKeywords.length; i++) {
			keywordRule.addWord(optionKeywords[i], keywordToken);
		}
		rules.add(keywordRule);

		setDefaultReturnToken(defaultToken);

		final IRule[] result = new IRule[rules.size()];
		rules.toArray(result);
		this.setRules(result);
	}
}
