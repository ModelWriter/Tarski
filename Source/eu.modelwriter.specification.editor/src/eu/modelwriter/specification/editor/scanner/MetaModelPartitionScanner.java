package eu.modelwriter.specification.editor.scanner;

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
  public final static String META_MODEL_LOADALIAS = "__META_MODEL_LOADALIAS";
  public final static String META_MODEL_LOADMODEL = "__META_MODEL_LOADMODEL";
  public final static String META_MODEL_LOADINSTANCE = "__META_MODEL_LOADINSTANCE";
  public final static String META_MODEL_DISCOVER = "__META_MODEL_DISCOVER";
  public final static String META_MODEL_SIG = "__META_MODEL_SIG";
  public final static String META_MODEL_FACT = "__META_MODEL_FACT";
  public final static String[] PARTITION_TYPES = new String[] {IDocument.DEFAULT_CONTENT_TYPE,
      MetaModelPartitionScanner.META_MODEL_COMMENT, MetaModelPartitionScanner.META_MODEL_REASON,
      MetaModelPartitionScanner.META_MODEL_LOCATE, MetaModelPartitionScanner.META_MODEL_TRACE,
      MetaModelPartitionScanner.META_MODEL_LOADALIAS,
      MetaModelPartitionScanner.META_MODEL_LOADMODEL,
      MetaModelPartitionScanner.META_MODEL_LOADINSTANCE,
      MetaModelPartitionScanner.META_MODEL_DISCOVER, MetaModelPartitionScanner.META_MODEL_SIG,
      MetaModelPartitionScanner.META_MODEL_FACT};

  public MetaModelPartitionScanner() {
    final IToken commentPartition = new Token(MetaModelPartitionScanner.META_MODEL_COMMENT);
    final IToken reasonPartition = new Token(MetaModelPartitionScanner.META_MODEL_REASON);
    final IToken locatePartition = new Token(MetaModelPartitionScanner.META_MODEL_LOCATE);
    final IToken tracePartition = new Token(MetaModelPartitionScanner.META_MODEL_TRACE);
    final IToken loadAliasPartition = new Token(MetaModelPartitionScanner.META_MODEL_LOADALIAS);
    final IToken loadModelPartition = new Token(MetaModelPartitionScanner.META_MODEL_LOADMODEL);
    final IToken loadInstancePartition =
        new Token(MetaModelPartitionScanner.META_MODEL_LOADINSTANCE);
    final IToken discoverPartition = new Token(MetaModelPartitionScanner.META_MODEL_DISCOVER);
    final IToken sigPartition = new Token(MetaModelPartitionScanner.META_MODEL_SIG);
    final IToken factPartition = new Token(MetaModelPartitionScanner.META_MODEL_FACT);

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

    rules.add(new EndOfLineRule("--LoadAlias", loadAliasPartition));
    rules.add(new EndOfLineRule("-- LoadAlias", loadAliasPartition));
    rules.add(new EndOfLineRule("--loadAlias", loadAliasPartition));
    rules.add(new EndOfLineRule("-- loadAlias", loadAliasPartition));

    rules.add(new EndOfLineRule("--LoadModel", loadModelPartition));
    rules.add(new EndOfLineRule("-- LoadModel", loadModelPartition));
    rules.add(new EndOfLineRule("--loadModel", loadModelPartition));
    rules.add(new EndOfLineRule("-- loadModel", loadModelPartition));

    rules.add(new EndOfLineRule("--LoadInstance", loadInstancePartition));
    rules.add(new EndOfLineRule("-- LoadInstance", loadInstancePartition));
    rules.add(new EndOfLineRule("--loadInstance", loadInstancePartition));
    rules.add(new EndOfLineRule("-- loadInstance", loadInstancePartition));

    rules.add(new EndOfLineRule("--Discover", discoverPartition));
    rules.add(new EndOfLineRule("-- Discover", discoverPartition));
    rules.add(new EndOfLineRule("--discover", discoverPartition));
    rules.add(new EndOfLineRule("-- discover", discoverPartition));

    rules.add(new MultiLineRule("sig", "}", sigPartition));
    rules.add(new MultiLineRule("fact", "}", factPartition));

    rules.add(new EndOfLineRule("--", commentPartition));
    rules.add(new EndOfLineRule("//", commentPartition));

    final IPredicateRule[] result = new IPredicateRule[rules.size()];
    rules.toArray(result);
    setPredicateRules(result);
  }
}