package eu.modelwriter.specification.scanner;

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
  public final static String META_MODEL_REASON = "__META_MODEL_REASON";
  public final static String META_MODEL_LOCATE = "__META_MODEL_LOCATE";
  public final static String META_MODEL_TRACE = "__META_MODEL_TRACE";
  public final static String META_MODEL_LOAD = "__META_MODEL_LOAD";
  public final static String[] PARTITION_TYPES =
      new String[] {IDocument.DEFAULT_CONTENT_TYPE, MetaModelPartitionScanner.META_MODEL_COMMENT,
          MetaModelPartitionScanner.META_MODEL_REASON, MetaModelPartitionScanner.META_MODEL_LOCATE,
          MetaModelPartitionScanner.META_MODEL_TRACE, MetaModelPartitionScanner.META_MODEL_LOAD};

  public MetaModelPartitionScanner() {
    final IToken commentPartition = new Token(MetaModelPartitionScanner.META_MODEL_COMMENT);
    final IToken reasonPartition = new Token(MetaModelPartitionScanner.META_MODEL_REASON);
    final IToken locatePartition = new Token(MetaModelPartitionScanner.META_MODEL_LOCATE);
    final IToken tracePartition = new Token(MetaModelPartitionScanner.META_MODEL_TRACE);
    final IToken loadPartition = new Token(MetaModelPartitionScanner.META_MODEL_LOAD);

    final List<IRule> rules = new ArrayList<IRule>();
    rules.add(new MultiLineRule("/*", "*/", commentPartition));

    rules.add(new EndOfLineRule("-- Reason", reasonPartition));
    rules.add(new EndOfLineRule("--Reason", reasonPartition));
    rules.add(new EndOfLineRule("-- reason", reasonPartition));
    rules.add(new EndOfLineRule("--reason", reasonPartition));

    rules.add(new EndOfLineRule("-- Locate", locatePartition));
    rules.add(new EndOfLineRule("--locate", locatePartition));
    rules.add(new EndOfLineRule("--Locate", locatePartition));
    rules.add(new EndOfLineRule("-- locate", locatePartition));

    rules.add(new EndOfLineRule("--Trace", tracePartition));
    rules.add(new EndOfLineRule("-- Trace", tracePartition));
    rules.add(new EndOfLineRule("--trace", tracePartition));
    rules.add(new EndOfLineRule("-- trace", tracePartition));

    rules.add(new EndOfLineRule("--Load", loadPartition));
    rules.add(new EndOfLineRule("-- Load", loadPartition));
    rules.add(new EndOfLineRule("--load", loadPartition));
    rules.add(new EndOfLineRule("-- load", loadPartition));

    rules.add(new EndOfLineRule("--", commentPartition));
    rules.add(new EndOfLineRule("//", commentPartition));

    final IPredicateRule[] result = new IPredicateRule[rules.size()];
    rules.toArray(result);
    this.setPredicateRules(result);
  }
}
