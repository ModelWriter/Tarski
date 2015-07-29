package eu.modelwriter.marker.text.internal.hyperlinkdetectors;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkerMappingActionHyperlinkDetector extends AbstractHyperlinkDetector
    implements IHyperlinkDetector {

  @Override
  public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region,
      boolean canShowMultipleHyperlinks) {

    int offset = region.getOffset();
    int length = region.getLength();
    if (offset == 0 && length == 0)
      return null;

    if (Activator.getEditor() == null || Activator.getEditor().getEditorInput() == null)
      return null;

    IFile file = (IFile) Activator.getEditor().getEditorInput().getAdapter(IFile.class);

    List<IMarker> markedList = MarkerFactory.findAllMarkers(file);
    for (IMarker iMarker : markedList) {
      try {
        // look for keyword
        // detect region containing keyword
        IRegion targetRegion = new Region((int) iMarker.getAttribute(IMarker.CHAR_START),
            (int) iMarker.getAttribute(IMarker.CHAR_END)
                - (int) iMarker.getAttribute(IMarker.CHAR_START));
        if ((targetRegion.getOffset() <= offset)
            && ((targetRegion.getOffset() + targetRegion.getLength()) > offset)) {
          // create link
          return new IHyperlink[] {new MarkerMappingActionHyperlink(targetRegion)};
        }

      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    return null;
  }
}
