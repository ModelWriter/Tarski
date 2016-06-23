package eu.modelwriter.traceability.validation.editor.base;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class VerticalBarRule implements IRule {

  private final char specChar;

  private final IToken token;

  public VerticalBarRule(final char specChar, final IToken specCharToken) {
    this.specChar = specChar;
    this.token = specCharToken;
  }

  @Override
  public IToken evaluate(final ICharacterScanner scanner) {
    final int c = scanner.read();
    if (c == this.specChar) {
      return this.token;
    }
    scanner.unread();
    return Token.UNDEFINED;
  }
}
