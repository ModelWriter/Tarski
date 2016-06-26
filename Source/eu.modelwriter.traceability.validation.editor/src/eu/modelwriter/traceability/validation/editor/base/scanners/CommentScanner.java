package eu.modelwriter.traceability.validation.editor.base.scanners;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;

import eu.modelwriter.traceability.validation.editor.base.color.ColorManager;
import eu.modelwriter.traceability.validation.editor.base.color.IValidationColorConstants;

public class CommentScanner extends RuleBasedScanner {

  public CommentScanner(final ColorManager colorManager) {
    final IToken commToken =
        new Token(new TextAttribute(colorManager.getColor(IValidationColorConstants.COMMENT)));
    this.setDefaultReturnToken(commToken);
  }
}
