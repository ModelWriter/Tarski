package eu.modelwriter.specification.editor.scanner;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.specification.editor.RGBStorage;

public class TraceScanner extends RuleBasedScanner {

  public TraceScanner() {
    final IToken traceToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), RGBStorage.TRACE_RGB)));
    this.setDefaultReturnToken(traceToken);
  }
}
