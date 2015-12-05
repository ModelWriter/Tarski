package eu.modelwriter.marker.ui.internal;

import java.util.ArrayList;
import java.util.Arrays;

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
  private final ArrayList<Character> terminals = new ArrayList<Character>(Arrays.asList('~', '^',
      '*', '.', '[', ']', '<', ':', '>', '-', '&', '+', '#', '!', '=', '|', '(', ')', '{', '}'));

  private IRule[] createRules() {
    final IToken commentToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(204, 0, 0))));
    final IToken keywordToken =
        new Token(new TextAttribute(new Color(Display.getCurrent(), new RGB(65, 105, 225))));

    final WordRule keywordRule = new WordRule(new IWordDetector() {

      boolean ctrl = false; // this controls coloring when keyword unified with any letter character
      boolean first = true;

      @Override
      public boolean isWordPart(final char c) {
        return Character.isLetter(c);
      }

      @Override
      public boolean isWordStart(final char c) {
        if (this.first) { // document's first text -'module'- must be keyword
          this.first = false;
          return true;
        }
        if (Character.isWhitespace(c) || Character.isSpaceChar(c)
            || MetaModelEditorSourceViewerConfig.this.terminals.contains(c)) {
          this.ctrl = true;
        } else {
          for (int i = 0; i < MetaModelEditorSourceViewerConfig.this.keywords.length; i++) {
            if (this.ctrl && MetaModelEditorSourceViewerConfig.this.keywords[i].charAt(0) == c) {
              return true;
            }
          }
          this.ctrl = false;
        }
        return false;
      }
    });

    for (int i = 0; i < this.keywords.length; i++) {
      keywordRule.addWord(this.keywords[i], keywordToken);
    }

    return new IRule[] {new EndOfLineRule("//", commentToken),
        new EndOfLineRule("--", commentToken), new MultiLineRule("/*", "*/", commentToken),
        keywordRule, new WhitespaceRule(new IWhitespaceDetector() {

          @Override
          public boolean isWhitespace(final char c) {
            return Character.isWhitespace(c);
          }
        })};
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
    reconciler.setRepairer(repairer, IDocument.DEFAULT_CONTENT_TYPE);
    return reconciler;
  }
}
