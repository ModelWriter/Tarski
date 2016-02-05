package eu.modelwriter.kodkod.editor.scanners;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;

import eu.modelwriter.kodkod.editor.ColorManager;
import eu.modelwriter.kodkod.editor.IColorConstants;

public class UniverseScanner extends RuleBasedScanner {

	public UniverseScanner(ColorManager manager) {
		final IToken token = new Token(new TextAttribute(manager.getColor(IColorConstants.UNIVERSE)));
		setDefaultReturnToken(token);
	}
}
