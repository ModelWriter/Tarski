package eu.modelwriter.specification.scanner;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class TraceScanner extends RuleBasedScanner {

  public TraceScanner() {
    final IToken traceToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(153, 76, 0))));
    this.setDefaultReturnToken(traceToken);
  }
}
