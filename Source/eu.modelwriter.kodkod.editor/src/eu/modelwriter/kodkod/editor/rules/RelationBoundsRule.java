package eu.modelwriter.kodkod.editor.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.PatternRule;

public class RelationBoundsRule extends PatternRule {
  public RelationBoundsRule(final String startSequence, final String endSequence,
      final IToken token, final char escapeCharacter, final boolean breaksOnEOL) {
    super(startSequence, endSequence, token, escapeCharacter, breaksOnEOL);
  }

  @Override
  protected boolean endSequenceDetected(final ICharacterScanner scanner) {
    int c = scanner.read();
    if (c != ICharacterScanner.EOF) {
      do {
        boolean isEqualEndSeq = true;
        while (c != this.fEndSequence[0] && c != ICharacterScanner.EOF) {
          c = scanner.read();
        }
        for (int i = 1; i < this.fEndSequence.length; i++) {
          c = scanner.read();
          if (c != this.fEndSequence[i]) {
            isEqualEndSeq = false;
            break;
          }
        }
        if (isEqualEndSeq) {
          for (int i = 0; i < this.fEndSequence.length; i++) {
            scanner.unread();
          }
          return true;
        }
        c = scanner.read();
      } while (c != ICharacterScanner.EOF);
    }
    return false;
  }
}
