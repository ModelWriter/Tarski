package eu.modelwriter.marker.command;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.typing.alloy.AlloyModule;
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


    FileDialog dialog =
        new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
    dialog.setFilterExtensions(new String[] {"*.als"});
    String result = dialog.open();

    AlloyParser parser = new AlloyParser(result);
    ArrayList<MarkerTypeElement> roots = parser.getTypes();
    ArrayList<String> rels = parser.getRels();
    ArrayList<AlloyModule> alloyModuleList = parser.getAlloyModuleList();

    MarkerTypeElement systemRoot = new MarkerTypeElement("universe");
    for (MarkerTypeElement root : roots) {
      systemRoot.getChildren().add(root);
    }

    try {
      MarkerPage.settings.put("universe", Serialization.getInstance().toString(systemRoot));
      MarkerPage.settings.put("rels", Serialization.getInstance().toString(rels));
      MarkerPage.settings.addNewSection("alloyModuleSection");
      MarkerPage.settings.getSection("alloyModuleSection").put("alloyModuleList",
          Serialization.getInstance().toString(alloyModuleList));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return null;
  }
}
