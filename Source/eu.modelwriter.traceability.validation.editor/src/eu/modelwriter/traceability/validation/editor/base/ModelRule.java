package eu.modelwriter.traceability.validation.editor.base;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;

public class ModelRule extends MultiLineRule {

  public ModelRule(final IToken token) {
    super("Model:", "Sentences:", token);
  }
}
