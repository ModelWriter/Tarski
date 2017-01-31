package eu.modelwriter.core.alloyinecore.ui.editor.partition;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TypedPosition;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;

public class AIEFastPartitioner extends FastPartitioner {
  private final String category;

  public AIEFastPartitioner(final IPartitionTokenScanner scanner,
      final String[] legalContentTypes) {
    super(scanner, legalContentTypes);
    category = getManagingPositionCategories()[0];
  }

  @Override
  public IRegion documentChanged2(final DocumentEvent e) {
    try {
      final IRegion region = getPartition(e.getOffset());
      fDocument.removePositionCategory(category);
      fDocument.addPositionCategory(category);
      initialize();
      return region;
    } catch (final BadPositionCategoryException e1) {
      return null;
    }
  }

  @Override
  public ITypedRegion getPartition(final int offset) {
    TypedPosition candidatePosition = null;
    try {
      final Position[] positions = fDocument.getPositions(category);
      if (positions != null && positions.length > 0) {
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < positions.length; i++) {
          final TypedPosition position = (TypedPosition) positions[i];
          if (position.includes(offset)) {
            if (Math.abs(offset - position.getOffset()) < minGap) {
              minGap = Math.abs(offset - position.getOffset()) < minGap
                  ? Math.abs(offset - position.getOffset()) : minGap;
                  candidatePosition = position;
            }
          }
        }
      }
    } catch (final BadPositionCategoryException e) {
      new TypedRegion(offset, 0, IDocument.DEFAULT_CONTENT_TYPE);
    }
    if (candidatePosition != null) {
      System.err.println(candidatePosition.getType() + " : " + candidatePosition.getOffset());
      return new TypedRegion(candidatePosition.getOffset(), candidatePosition.getLength(),
          candidatePosition.getType());
    } else {
      return new TypedRegion(offset, 0, IDocument.DEFAULT_CONTENT_TYPE);
    }
  }

  @Override
  public ITypedRegion getPartition(final int offset, final boolean preferOpenPartitions) {
    return getPartition(offset);
  }

  @Override
  public String getContentType(final int offset) {
    return getPartition(offset).getType();
  }

  @Override
  public String getContentType(final int offset, final boolean preferOpenPartitions) {
    return getPartition(offset, preferOpenPartitions).getType();
  }

  @Override
  public ITypedRegion[] computePartitioning(final int offset, final int length,
      final boolean includeZeroLengthPartitions) {
    checkInitialization();
    final List<TypedRegion> list = new ArrayList<>();

    try {

      final int endOffset = offset + length;

      final Position[] category = getPositions();

      TypedPosition previous = null, current = null;
      int start, end, gapOffset;
      final Position gap = new Position(0);

      final int startIndex = getFirstIndexEndingAfterOffset(category, offset);
      final int endIndex = getFirstIndexStartingAfterOffset(category, endOffset);
      for (int i = startIndex; i < endIndex; i++) {

        current = (TypedPosition) category[i];

        gapOffset = previous != null ? previous.getOffset() + previous.getLength() : 0;
        gap.setOffset(gapOffset);
        gap.setLength(Math.abs(current.getOffset() - gapOffset));
        if (includeZeroLengthPartitions && overlapsOrTouches(gap, offset, length)
            || gap.getLength() > 0 && gap.overlapsWith(offset, length)) {
          start = Math.max(offset, gapOffset);
          end = Math.min(endOffset, gap.getOffset() + gap.getLength());
          list.add(new TypedRegion(start, end - start, IDocument.DEFAULT_CONTENT_TYPE));
        }

        if (current.overlapsWith(offset, length)) {
          start = Math.max(offset, current.getOffset());
          end = Math.min(endOffset, current.getOffset() + current.getLength());
          list.add(new TypedRegion(start, end - start, current.getType()));
        }

        previous = current;
      }

      if (previous != null) {
        gapOffset = previous.getOffset() + previous.getLength();
        gap.setOffset(gapOffset);
        gap.setLength(fDocument.getLength() - gapOffset);
        if (includeZeroLengthPartitions && overlapsOrTouches(gap, offset, length)
            || gap.getLength() > 0 && gap.overlapsWith(offset, length)) {
          start = Math.max(offset, gapOffset);
          end = Math.min(endOffset, fDocument.getLength());
          list.add(new TypedRegion(start, end - start, IDocument.DEFAULT_CONTENT_TYPE));
        }
      }

      if (list.isEmpty()) {
        list.add(new TypedRegion(offset, length, IDocument.DEFAULT_CONTENT_TYPE));
      }

    } catch (final BadPositionCategoryException ex) {
      // Make sure we clear the cache
      clearPositionCache();
    } catch (final RuntimeException ex) {
      // Make sure we clear the cache
      clearPositionCache();
      throw ex;
    }

    for (final TypedRegion typedRegion : list) {
      System.err.println("Partitioner: " + typedRegion.getType());
    }

    final TypedRegion[] result = new TypedRegion[list.size()];
    list.toArray(result);
    return result;
  }

  /**
   * Returns <code>true</code> if the given ranges overlap with or touch each other.
   *
   * @param gap the first range
   * @param offset the offset of the second range
   * @param length the length of the second range
   * @return <code>true</code> if the given ranges overlap with or touch each other
   */
  private boolean overlapsOrTouches(final Position gap, final int offset, final int length) {
    return gap.getOffset() <= offset + length && offset <= gap.getOffset() + gap.getLength();
  }

  /**
   * Returns the index of the first position which ends after the given offset.
   *
   * @param positions the positions in linear order
   * @param offset the offset
   * @return the index of the first position which ends after the offset
   */
  private int getFirstIndexEndingAfterOffset(final Position[] positions, final int offset) {
    int i = -1, j = positions.length;
    while (j - i > 1) {
      final int k = i + j >> 1;
    final Position p = positions[k];
    if (p.getOffset() + p.getLength() > offset) {
      j = k;
    } else {
      i = k;
    }
    }
    return j;
  }

  /**
   * Returns the index of the first position which starts at or after the given offset.
   *
   * @param positions the positions in linear order
   * @param offset the offset
   * @return the index of the first position which starts after the offset
   */
  private int getFirstIndexStartingAfterOffset(final Position[] positions, final int offset) {
    int i = -1, j = positions.length;
    while (j - i > 1) {
      final int k = i + j >> 1;
      final Position p = positions[k];
      if (p.getOffset() >= offset) {
        j = k;
      } else {
        i = k;
      }
    }
    return j;
  }
}
