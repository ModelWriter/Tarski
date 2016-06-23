package eu.modelwriter.traceability.validation.editor.base;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;

public class SetRule implements IRule {

  private final IToken token;

  public SetRule(final IToken setToken) {
    this.token = setToken;
  }

  @Override
  public IToken evaluate(final ICharacterScanner scanner) {
    return this.token;
  }
}
