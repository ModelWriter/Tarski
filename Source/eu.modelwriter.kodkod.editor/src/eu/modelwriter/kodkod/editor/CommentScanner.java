package eu.modelwriter.kodkod.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * We already define the comment rules in @MetaModelPartitionScanner In this
 * class just provide token for that rules
 * 
 * @author anil.ozturk
 *
 */
public class CommentScanner extends RuleBasedScanner {

	public CommentScanner(ColorManager manager) {
		final IToken commentToken = new Token(new TextAttribute(manager.getColor(IColorConstants.COMMENT)));
		this.setDefaultReturnToken(commentToken);
	}
}
