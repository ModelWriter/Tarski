package eu.modelwriter.kodkod.editor;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.PatternRule;

public class RelationBoundsRule extends PatternRule {
	public RelationBoundsRule(String startSequence, String endSequence, IToken token, char escapeCharacter,
			boolean breaksOnEOL) {
		super(startSequence, endSequence, token, escapeCharacter, breaksOnEOL);
	}

	// buraya iyi bak sikintili bir durum olabilir eger olursa burdandir
	@Override
	protected boolean endSequenceDetected(ICharacterScanner scanner) {
		int c = scanner.read();
		if (c != ICharacterScanner.EOF) {
			do {
				boolean isEqualEndSeq = true;
				while (c != fEndSequence[0] && c != ICharacterScanner.EOF) {
					c = scanner.read();
				}
				for (int i = 1; i < fEndSequence.length; i++) {
					c = scanner.read();
					if (c != fEndSequence[i]) {
						isEqualEndSeq = false;
						break;
					}
				}
				if (isEqualEndSeq) {
					for (int i = 0; i < fEndSequence.length; i++) {
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
