package scanner;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class FactScanner extends RuleBasedScanner {

  public FactScanner() {
    final IToken factToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(204, 0, 0))));
    this.setDefaultReturnToken(factToken);
  }
}
