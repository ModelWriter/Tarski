package eu.modelwriter.traceability.validation.core.crocopat.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.PatternRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class RelationModelPartitionScanner extends RuleBasedPartitionScanner {

	public final static String RELATION_MODEL_COMMENT = "__RELATION_MODEL_COMMENT";
	public final static String RELATION_MODEL_VALUES = "__RELATION_MODEL_VALUES";
	public final static String[] PARTITION_TYPES = new String[] { IDocument.DEFAULT_CONTENT_TYPE,
			RelationModelPartitionScanner.RELATION_MODEL_COMMENT, RelationModelPartitionScanner.RELATION_MODEL_VALUES };

	public RelationModelPartitionScanner() {
		final IToken commentPartition = new Token(RelationModelPartitionScanner.RELATION_MODEL_COMMENT);
		final IToken valuesPartition = new Token(RelationModelPartitionScanner.RELATION_MODEL_VALUES);

		final List<IRule> rules = new ArrayList<IRule>();
		rules.add(new MultiLineRule("/*", "*/", commentPartition));
		rules.add(new EndOfLineRule("//", commentPartition));
		rules.add(new PatternRule("\"", "\"", valuesPartition, (char) 0, true));

		final IPredicateRule[] result = new IPredicateRule[rules.size()];
		rules.toArray(result);
		this.setPredicateRules(result);
	}
}
