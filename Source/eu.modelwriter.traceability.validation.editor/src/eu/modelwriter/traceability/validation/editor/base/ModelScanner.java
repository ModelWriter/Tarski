package eu.modelwriter.traceability.validation.editor.base;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class ModelScanner extends RuleBasedScanner {

  public ModelScanner(final ColorManager colorManager) {

    final IToken bracketsToken = new Token(
        new TextAttribute(colorManager.getColor(IValidationColorConstants.MODEL_BRACKETS)));
    final IToken setToken =
        new Token(new TextAttribute(colorManager.getColor(IValidationColorConstants.MODEL_SET)));

    final List<IRule> rules = new ArrayList<>();

    rules.add(new WhitespaceRule(new ValidationWhitespaceDetector()));
    rules.add(new SingleLineRule("\n", "=", setToken));
    // rules.add(new SetRule(setToken));
    rules.add(new BracketsRule(bracketsToken));

    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    this.setRules(result);
  }
}
