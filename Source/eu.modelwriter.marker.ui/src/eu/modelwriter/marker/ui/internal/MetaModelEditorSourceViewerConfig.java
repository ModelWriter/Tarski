package eu.modelwriter.marker.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class MetaModelEditorSourceViewerConfig extends SourceViewerConfiguration {

  private final String[] keywords = new String[] {"abstract", "all", "and", "as", "assert", "but",
      "check", "disj", "else", "exactly", "extends", "fact", "for", "fun", "iden", "iff", "implies",
      "in", "Int", "let", "lone", "module", "no", "none", "not", "one", "open", "or", "pred", "run",
      "set", "sig", "some", "sum", "univ"};

  private IRule[] createRules() {
    final IToken commentToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(204, 0, 0))));
    final IToken keywordToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(65, 105, 225))));
    final IToken defaultToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(0, 0, 0))));

    final List<IRule> rules = new ArrayList<IRule>();
    rules.add(new EndOfLineRule("--", commentToken));
    rules.add(new EndOfLineRule("//", commentToken));
    rules.add(new MultiLineRule("/*", "*/", commentToken));
    rules.add(new WhitespaceRule(new IWhitespaceDetector() {

      @Override
      public boolean isWhitespace(final char c) {
        return Character.isWhitespace(c);
      }
    }));

    final WordRule keywordRule = new WordRule(new IWordDetector() {

      @Override
      public boolean isWordPart(final char c) {
        return Character.isLetter(c);
      }

      @Override
      public boolean isWordStart(final char c) {
        return Character.isLetter(c);
      }
    }, defaultToken);

    for (int i = 0; i < this.keywords.length; i++) {
      keywordRule.addWord(this.keywords[i], keywordToken);
    }
    rules.add(keywordRule);
    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    return result;
  }

  private ITokenScanner createTokenScanner() {
    final RuleBasedScanner scanner = new RuleBasedScanner();
    scanner.setRules(this.createRules());
    return scanner;
  }

  @Override
  public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
    final PresentationReconciler reconciler = new PresentationReconciler();
    final DefaultDamagerRepairer repairer = new DefaultDamagerRepairer(this.createTokenScanner());
    reconciler.setDamager(repairer, IDocument.DEFAULT_CONTENT_TYPE);
    reconciler.setRepairer(repairer, IDocument.DEFAULT_CONTENT_TYPE);
    return reconciler;
  }
}
