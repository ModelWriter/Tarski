package eu.modelwriter.kodkod.editor.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class BracketsRule implements IRule {
  private final IToken token;

  public BracketsRule(final IToken token) {
    this.token = token;
  }

  @Override
  public IToken evaluate(final ICharacterScanner scanner) {
    final int c = scanner.read();
    if (c == '[' || c == ']') {
      return this.token;
    }
    scanner.unread();
    return Token.UNDEFINED;
  }
}
