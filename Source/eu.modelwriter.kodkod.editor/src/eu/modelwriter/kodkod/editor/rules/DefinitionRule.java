package eu.modelwriter.kodkod.editor.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class DefinitionRule implements IRule {
  private final IToken defToken;

  public DefinitionRule(final IToken defToken) {
    this.defToken = defToken;
  }

  @Override
  public IToken evaluate(final ICharacterScanner scanner) {
    int c = scanner.read();
    while (c != ':') {
      if (c == '\n' || c == '\r' || c == ICharacterScanner.EOF) {
        return Token.UNDEFINED;
      }
      c = scanner.read();
    }
    return this.defToken;
  }
}