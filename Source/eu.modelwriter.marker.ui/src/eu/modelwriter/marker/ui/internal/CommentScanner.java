package eu.modelwriter.marker.ui.internal;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class CommentScanner extends RuleBasedScanner {

  public CommentScanner() {
    final IToken commentToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(204, 0, 0))));
    this.setDefaultReturnToken(commentToken);
  }
}
