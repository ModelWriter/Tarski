package eu.modelwriter.traceability.validation.editor.base.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class BracketsRule implements IRule {

  private final IToken token;

  public BracketsRule(final IToken bracketsToken) {
    this.token = bracketsToken;
  }

  @Override
  public IToken evaluate(final ICharacterScanner scanner) {
    final int c = scanner.read();
    if (c == '(' || c == ')') {
      return this.token;
    }
    scanner.unread();
    return Token.UNDEFINED;
  }
}
