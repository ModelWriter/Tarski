package eu.modelwriter.marker.ui.internal.hyperlinkdetectors;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.mappingview.SourceView;

public class SourceViewHyperlink implements IHyperlink {

  private final IRegion fUrlRegion;

  public SourceViewHyperlink(IRegion urlRegion) {
    fUrlRegion = urlRegion;
  }

  @Override
  public IRegion getHyperlinkRegion() {
    return fUrlRegion;
  }

  @Override
  public String getTypeLabel() {
    return null;
  }

  @Override
  public String getHyperlinkText() {
    return "Open Source Mappings";
  }

  @Override
  public void open() {
    try {
      IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

      IMarker beMapped = MarkerFactory.findMarkerByOffset(file, fUrlRegion.getOffset());

      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(SourceView.ID);

      ArrayList<MarkElement> sourceElements = null;
      if ((beMapped != null) && (MarkElementUtilities.getSourceList(beMapped) != null)) {
        sourceElements = MarkElementUtilities.getSourceList(beMapped);
        SourceView.setColumns(sourceElements);
      } else {
        SourceView.setColumns(new ArrayList<MarkElement>());
      }
    } catch (PartInitException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
