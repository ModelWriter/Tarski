package eu.modelwriter.kodkod.editor;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class DefinitionRule implements IRule {

	private IToken defToken;

	public DefinitionRule(IToken defToken) {
		this.defToken = defToken;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		int c = scanner.read();
		while (c != ':') {
			if (c == '\n' || c == '\r' || c == ICharacterScanner.EOF) {
				return Token.UNDEFINED;
			}
			c = scanner.read();
		}
		return defToken;
	}
}
