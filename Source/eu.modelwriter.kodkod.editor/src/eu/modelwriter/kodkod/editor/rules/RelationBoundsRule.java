package eu.modelwriter.kodkod.editor.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.Token;

public class RelationBoundsRule extends MultiLineRule {

  public RelationBoundsRule(final String startSequence, final String endSequence,
      final IToken token) {
    super(startSequence, endSequence, token);
  }

  @Override
  protected IToken doEvaluate(final ICharacterScanner scanner, final boolean resume) {

    if (resume) {
      if (this.endSequenceDetected(scanner)) {
        return this.fToken;
      }
    } else {
      final int c = scanner.read();
      if (c == this.fStartSequence[0]) {
        if (this.sequenceDetected(scanner, this.fStartSequence, false)) {
          if (this.endSequenceDetected(scanner)) {
            return this.fToken;
          }
        }
      }
    }

    scanner.unread();
    return Token.UNDEFINED;
  }

  @Override
  protected boolean endSequenceDetected(final ICharacterScanner scanner) {

    int readCount = 1;
    int c;
    int open = 0;
    while ((c = scanner.read()) != ICharacterScanner.EOF) {

      if (c == '{') {
        open++;
      } else if (c == '}') {
        open--;
        if (open == 0) {
          if (this.sequenceDetected(scanner, this.fEndSequence, this.fBreaksOnEOF)) {
            return true;
          }
        }
      }

      readCount++;
    }

    for (; readCount > 0; readCount--) {
      scanner.unread();
    }

    return false;
  }
}
