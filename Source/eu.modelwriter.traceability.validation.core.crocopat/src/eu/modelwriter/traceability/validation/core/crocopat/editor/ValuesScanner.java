package eu.modelwriter.traceability.validation.core.crocopat.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class ValuesScanner extends RuleBasedScanner {
	public ValuesScanner() {
		final IToken valuesToken = new Token(
				new TextAttribute(new Color(Display.getCurrent(), new RGB(160, 160, 160))));
		this.setDefaultReturnToken(valuesToken);
	}
}
