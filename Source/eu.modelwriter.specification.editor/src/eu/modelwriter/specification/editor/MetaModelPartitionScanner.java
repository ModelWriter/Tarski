package eu.modelwriter.specification.editor;

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

public class MetaModelPartitionScanner extends RuleBasedPartitionScanner {

  public final static String META_MODEL_COMMENT = "__META_MODEL_COMMENT";
  public final static String[] PARTITION_TYPES =
      new String[] {IDocument.DEFAULT_CONTENT_TYPE, MetaModelPartitionScanner.META_MODEL_COMMENT};

  public MetaModelPartitionScanner() {
    final IToken commentPartition = new Token(MetaModelPartitionScanner.META_MODEL_COMMENT);

    final List<IRule> rules = new ArrayList<IRule>();
    rules.add(new MultiLineRule("/*", "*/", commentPartition));
    rules.add(new EndOfLineRule("--", commentPartition));
    rules.add(new EndOfLineRule("//", commentPartition));

    final IPredicateRule[] result = new IPredicateRule[rules.size()];
    rules.toArray(result);
    this.setPredicateRules(result);
  }
}
