package eu.modelwriter.marker.command;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.typing.alloy.AlloyParser;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AlloyParseHandler extends AbstractHandler {

  public AlloyParseHandler() {}

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    FileDialog dialog =
        new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
    dialog.setFilterExtensions(new String[] {"*.als"});
    String result = dialog.open();

    AlloyParser parser = new AlloyParser(result);
    ArrayList<String> types = parser.getTypes();

    MarkerTypeElement root = new MarkerTypeElement("root");
    for (String type : types) {
      root.getChildren().add(new MarkerTypeElement(type));
    }

    try {
      MarkerPage.settings.put("root", Serialization.getInstance().toString(root));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return null;
  }
}
