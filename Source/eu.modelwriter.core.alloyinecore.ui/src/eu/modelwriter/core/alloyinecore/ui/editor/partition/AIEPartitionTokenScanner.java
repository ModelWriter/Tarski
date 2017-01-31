package eu.modelwriter.core.alloyinecore.ui.editor.partition;

import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TypedPosition;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class AIEPartitionTokenScanner implements IPartitionTokenScanner {
  private int fCurrentOffset;
  private int fCurrentLength;
  private int fLastPositionIndex;
  private IDocument fDocument;
  private List<TypedPosition> positions;

  private void createAIEPositions() {
    if (!(fDocument.get().length() > 0)) {
      return;
    }
    final AIEPartitionerVisitor visitor = new AIEPartitionerVisitor(fDocument.get());
    positions = visitor.computePositions();
  }

  @Override
  public void setRange(final IDocument document, final int offset, final int length) {
    fLastPositionIndex = -1;
    fDocument = document;
    fCurrentOffset = offset;
    fCurrentLength = length;
    createAIEPositions();
  }

  @Override
  public IToken nextToken() {
    if (positions != null && positions.size() > 0) {
      for (int i = fLastPositionIndex + 1; i < positions.size(); i++) {
        final TypedPosition position = positions.get(i);
        if (position.overlapsWith(fCurrentOffset, fCurrentLength)) {
          fLastPositionIndex = i;
          return new Token(position.getType());
        }
      }
    }
    return Token.EOF;
  }

  @Override
  public int getTokenOffset() {
    return positions.get(fLastPositionIndex).getOffset();
  }

  @Override
  public int getTokenLength() {
    return positions.get(fLastPositionIndex).getLength();
  }

  @Override
  public void setPartialRange(final IDocument document, final int offset, final int length,
      final String contentType, final int partitionOffset) {
    fLastPositionIndex = -1;
    fDocument = document;
    fCurrentOffset = partitionOffset;
    fCurrentLength = length;
    createAIEPositions();
  }
}
