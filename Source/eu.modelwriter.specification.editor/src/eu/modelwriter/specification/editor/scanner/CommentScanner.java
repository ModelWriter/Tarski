package eu.modelwriter.specification.editor.scanner;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.specification.editor.RGBStorage;

/**
 * We already define the comment rules in @MetaModelPartitionScanner In this class just provide
 * token for that rules
 * 
 * @author anil.ozturk
 *
 */
public class CommentScanner extends RuleBasedScanner {

  public CommentScanner() {
    final IToken commentToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), RGBStorage.COMMENT_RGB)));
    this.setDefaultReturnToken(commentToken);
  }
}
