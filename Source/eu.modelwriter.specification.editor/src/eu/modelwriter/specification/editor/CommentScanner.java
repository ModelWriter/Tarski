package eu.modelwriter.specification.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/** We already define the comment rules in @MetaModelPartitionScanner
 *  In this class just provide token for that rules
 * @author anil.ozturk
 *
 */
public class CommentScanner extends RuleBasedScanner {
  
  public CommentScanner() {
    final IToken commentToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(204, 0, 0))));
    this.setDefaultReturnToken(commentToken);
  }
}
