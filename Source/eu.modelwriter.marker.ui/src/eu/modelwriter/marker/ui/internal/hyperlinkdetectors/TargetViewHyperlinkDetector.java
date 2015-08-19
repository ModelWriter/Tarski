package eu.modelwriter.marker.ui.internal.hyperlinkdetectors;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class TargetViewHyperlinkDetector extends AbstractHyperlinkDetector
    implements IHyperlinkDetector {

  @Override
  public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region,
      boolean canShowMultipleHyperlinks) {

    int offset = region.getOffset();
    int length = region.getLength();
    if (offset == 0 && length == 0)
      return null;

    if (MarkerActivator.getEditor() == null || MarkerActivator.getEditor().getEditorInput() == null)
      return null;

    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

    List<IMarker> markedList = MarkerFactory.findMarkers(file);
    for (IMarker iMarker : markedList) {
      // look for keyword
      // detect region containing keyword
      IRegion targetRegion = new Region(MarkElementUtilities.getStart(iMarker),
          MarkElementUtilities.getLength(iMarker));
      if ((targetRegion.getOffset() <= offset)
          && ((targetRegion.getOffset() + targetRegion.getLength()) > offset)) {
        // create link
        return new IHyperlink[] {new TargetViewHyperlink(targetRegion)};
      }
    }
    return null;
  }
}
