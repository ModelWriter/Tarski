package eu.modelwriter.specification.editor.scanner;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class LoadScanner extends RuleBasedScanner {

  public LoadScanner() {
    final IToken loadToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(153, 76, 0))));
    this.setDefaultReturnToken(loadToken);
  }
}
