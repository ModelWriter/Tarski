package eu.modelwriter.kodkod.editor.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class BracketsRule implements IRule {

	private IToken token;

	public BracketsRule(IToken token) {
		this.token = token;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		int c = scanner.read();
		if (c == '[' || c == ']') {
			return token;
		}
		scanner.unread();
		return Token.UNDEFINED;
	}
}
