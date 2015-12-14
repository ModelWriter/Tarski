package eu.modelwriter.marker.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class CommentScanner extends RuleBasedPartitionScanner {

  public final static String META_MODEL_COMMENT = "__META_MODEL_COMMENT";
  public final static String[] PARTITION_TYPES =
      new String[] {IDocument.DEFAULT_CONTENT_TYPE, CommentScanner.META_MODEL_COMMENT};

  public CommentScanner() {
    final IToken commentToken = new Token(CommentScanner.META_MODEL_COMMENT);

    final List<IRule> rules = new ArrayList<IRule>();
    rules.add(new MultiLineRule("/*", "*/", commentToken));
    rules.add(new EndOfLineRule("--", commentToken));
    rules.add(new EndOfLineRule("//", commentToken));

    final IPredicateRule[] result = new IPredicateRule[rules.size()];
    rules.toArray(result);
    this.setPredicateRules(result);
  }
}
