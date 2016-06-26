package eu.modelwriter.traceability.validation.editor.base.scanners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

import eu.modelwriter.traceability.validation.editor.base.ValidationWhitespaceDetector;
import eu.modelwriter.traceability.validation.editor.base.color.ColorManager;
import eu.modelwriter.traceability.validation.editor.base.color.IValidationColorConstants;
import eu.modelwriter.traceability.validation.editor.base.rules.BracketsRule;

public class ModelScanner extends RuleBasedScanner {

  public ModelScanner(final ColorManager colorManager) {

    final IToken bracketsToken =
        new Token(new TextAttribute(colorManager.getColor(IValidationColorConstants.BRACKETS)));
    final IToken commToken =
        new Token(new TextAttribute(colorManager.getColor(IValidationColorConstants.COMMENT)));

    final List<IRule> rules = new ArrayList<>();

    rules.add(new WhitespaceRule(new ValidationWhitespaceDetector()));
    rules.add(new BracketsRule(bracketsToken));
    rules.add(new MultiLineRule("/**", "**/", commToken));
    rules.add(new EndOfLineRule("--", commToken));

    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    this.setRules(result);
  }
}
