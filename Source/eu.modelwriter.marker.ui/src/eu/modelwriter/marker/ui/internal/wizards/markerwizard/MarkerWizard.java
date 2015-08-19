package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.typing.internal.CreateMarkerWithType;

public class MarkerWizard extends Wizard {

  private MarkerPage page;
  private ISelection selection;
  private IFile file;
  private IMarker marker;

  public MarkerWizard(ISelection selection, IFile file) {
    super();
    this.selection = selection;
    this.file = file;
  }

  public MarkerWizard(IMarker marker) {
    this.marker = marker;
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
    if (MarkerPage.markTreeViewer.getTree().getSelection().length == 1) {
      if (MarkerPage.markTreeViewer.getTree().getSelection()[0].getText().endsWith("{abs}")) {
        MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Marker Type Information", null,
                "Selected type is not appropriate because it is marked as Abstact",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
        return false;
      }
      if (!MarkerPage.markTreeViewer.getTree().getItems()[0]
          .equals(MarkerPage.markTreeViewer.getTree().getSelection()[0])) {
        if (this.selection != null) {
          CreateMarkerWithType.createMarker(file, selection,
              MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
              "Marker Type Information", null, "Marker has been created with selected type",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        } else {
          try {
            Object groupId = marker.getAttribute(MarkElementUtilities.GROUP_ID);
            if (groupId != null) {
              List<IMarker> list =
                  MarkerFactory.findMarkersByGroupId(marker.getResource(), (String) groupId);
              for (IMarker iMarker : list) {
                MarkElementUtilities.setType(iMarker,
                    MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
              }
            } else {
              MarkElementUtilities.setType(marker,
                  MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
            }
          } catch (CoreException e) {
            e.printStackTrace();
          }
          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
              "Marker Type Information", null, "Selected type added to selected marker",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        }
        return true;
      } else {
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
            "Marker Type Information", null, "Please select a valid marker type.",
            MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
        return false;
      }
    } else {
      MessageDialog dialog =
          new MessageDialog(MarkerActivator.getShell(), "Marker Type Information", null,
              "Please select one marker type.", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return false;
    }
  }
}
