package eu.modelwriter.specification.editor.scanner;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.specification.editor.RGBStorage;

public class ReasonScanner extends RuleBasedScanner {

  public ReasonScanner() {
    final IToken factToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), RGBStorage.REASON_RGB)));
    this.setDefaultReturnToken(factToken);
  }
}
