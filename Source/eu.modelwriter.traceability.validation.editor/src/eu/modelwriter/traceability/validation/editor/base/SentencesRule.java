package eu.modelwriter.traceability.validation.editor.base;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;

public class SentencesRule extends MultiLineRule {

  public SentencesRule(final IToken token) {
    super("Sentences:", "", token, (char) 0, true); // EOF will be successful
  }
}
