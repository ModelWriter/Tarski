package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class PartitionScanner extends RuleBasedPartitionScanner {

  public final static String PACKAGE = "__alloyinecore_package";
  public final static String CLASS = "__alloyinecore_class";
  public final static String COMMENT = "__alloyinecore_comment";
  // public final static String STRING = "__alloyinecore_string";

  public final static String[] ALL_PARTITIONS =
      new String[] {IDocument.DEFAULT_CONTENT_TYPE, PACKAGE, CLASS};

  public PartitionScanner() {
    IToken packageToken = new Token(PACKAGE);
    // IToken classToken = new Token(CLASS);
    // IToken stringToken = new Token(STRING);
    IToken commentToken = new Token(COMMENT);
    List<IPredicateRule> rulez = new ArrayList<>();
    rulez.add(new EndOfLineRule("--", commentToken));
    rulez.add(new MultiLineRule("package", "}", packageToken));
    final IPredicateRule[] result = new IPredicateRule[rulez.size()];
    rulez.toArray(result);
    setPredicateRules(result);
  }
}
