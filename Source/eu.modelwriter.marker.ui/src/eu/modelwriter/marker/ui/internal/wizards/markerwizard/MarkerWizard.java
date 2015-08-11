package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.typing.internal.CreateMarkerWithType;

public class MarkerWizard extends Wizard {

  private MarkerPage page;
  private ISelection selection;
  private IFile file;

  public MarkerWizard(ISelection selection, IFile file) {
    super();
    this.selection = selection;
    this.file = file;
  }

  @Override
  public String getWindowTitle() {
    return "Marking with Tag";
  }

  @Override
  public void addPages() {
    page = new MarkerPage();
    super.addPages();
    this.addPage(page);
  }

  @Override
  public boolean performFinish() {
    if (MarkerPage.markTreeViewer.getTree().getSelection() != null
        && MarkerPage.markTreeViewer.getTree().getSelection().length > 1) {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
          "Marker Type Information", null, "Please select just one marker type",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
    } else {
      CreateMarkerWithType.createMarker(file, selection,
          MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
          "Marker Type Information", null, "Marker has been created with selected type",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
    }

    return true;
  }

}
