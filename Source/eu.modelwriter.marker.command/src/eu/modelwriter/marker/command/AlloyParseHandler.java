package eu.modelwriter.marker.command;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.typing.alloy.AlloyParser;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AlloyParseHandler extends AbstractHandler {

  public AlloyParseHandler() {}

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    MessageDialog warningdialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
        null, "If new alloy file will be parsed , your all marker type will be lost !",
        MessageDialog.WARNING, new String[] {"OK", "Cancel"}, 0);
    if (warningdialog.open() == 1)
      return null;

    for (IResource iResource : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
      boolean isClosed = false;
      try {
        if (!((IProject) iResource).isOpen()) {
          isClosed = true;
          ((IProject) iResource).open(null);
        }
        for (IMarker iMarker : MarkerFactory.findMarkersAsArrayList(iResource)) {
          if (MarkElementUtilities.getType(iMarker) != null) {
            MarkElementUtilities.setType(iMarker, null);
          }
        }
        if (isClosed == true) {
          ((IProject) iResource).close(null);
        }
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    FileDialog dialog =
        new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
    dialog.setFilterExtensions(new String[] {"*.als"});
    String result = dialog.open();
    if (result == null) {
      return null;
    }

    AlloyParser parser = new AlloyParser(result);
    ArrayList<MarkerTypeElement> roots = parser.getTypes();
    ArrayList<String> rels = parser.getRels();

    MarkerTypeElement systemRoot = new MarkerTypeElement("universe");
    for (MarkerTypeElement root : roots) {
      systemRoot.getChildren().add(root);
    }

    try {
      MarkerPage.settings.put("universe", Serialization.getInstance().toString(systemRoot));
      MarkerPage.settings.put("rels", Serialization.getInstance().toString(rels));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return null;
  }
}
