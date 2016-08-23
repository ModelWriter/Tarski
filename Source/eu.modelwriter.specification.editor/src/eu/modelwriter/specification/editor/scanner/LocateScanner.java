package eu.modelwriter.specification.editor.scanner;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.specification.editor.RGBStorage;

public class LocateScanner extends RuleBasedScanner {

  public LocateScanner() {
    final IToken locateToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), RGBStorage.LOCATE_RGB)));
    this.setDefaultReturnToken(locateToken);
  }
}
