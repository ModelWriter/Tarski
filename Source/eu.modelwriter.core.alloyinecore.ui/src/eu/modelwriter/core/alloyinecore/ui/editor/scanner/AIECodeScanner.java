package eu.modelwriter.core.alloyinecore.ui.editor.scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.Token;

import eu.modelwriter.core.alloyinecore.ui.editor.color.IAIEColorConstants;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IColorManager;

public class AIECodeScanner extends AbstractAIEScanner {

  public AIECodeScanner(final IColorManager colorManager, final IPreferenceStore fPreferenceStore) {
    super(colorManager);
    final List<IRule> rules = new ArrayList<IRule>(Arrays.asList(super.fRules));

    final IToken stringToken =
        new Token(new TextAttribute(colorManager.getColor(IAIEColorConstants.AIE_STRING)));

    rules.add(new MultiLineRule("\"", "\"", stringToken, '\\'));
    rules.add(new MultiLineRule("'", "'", stringToken, '\\'));

    final IToken singlelineToken = new Token(
        new TextAttribute(colorManager.getColor(IAIEColorConstants.AIE_SINGLE_LINE_COMMENT)));
    final IToken multilineToken = new Token(
        new TextAttribute(colorManager.getColor(IAIEColorConstants.AIE_MULTI_LINE_COMMENT)));

    // Add rules for multi-line comments.
    rules.add(new MultiLineRule("/*", "*/", multilineToken));
    // Add rule for single line comments.
    rules.add(new EndOfLineRule("--", singlelineToken));

    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    setRules(result);
  }
}
