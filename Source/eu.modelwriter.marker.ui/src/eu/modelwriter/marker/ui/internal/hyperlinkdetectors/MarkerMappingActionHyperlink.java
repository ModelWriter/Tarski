package eu.modelwriter.marker.ui.internal.hyperlinkdetectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MarkerMappingAction;

public class MarkerMappingActionHyperlink implements IHyperlink {

  private final IRegion fUrlRegion;

  public MarkerMappingActionHyperlink(IRegion urlRegion) {
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
    return "Open Mapping Wizard";
  }

  @Override
  public void open() {

    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

    IMarker beMapped = MarkerFactory.findMarkerByOffset(file, fUrlRegion.getOffset());

    if (beMapped != null) {
      MarkerMappingAction mappingAction = new MarkerMappingAction();
      mappingAction.run(null);
    } else {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "Something goes wrong with this text fragments", MessageDialog.WARNING,
          new String[] {"OK"}, 0);
      dialog.open();
    }
  }
}
