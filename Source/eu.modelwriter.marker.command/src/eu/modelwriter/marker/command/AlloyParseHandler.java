package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.typing.alloy.AlloyParser;

public class AlloyParseHandler extends AbstractHandler {

  public AlloyParseHandler() {}

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    FileDialog dialog =
        new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
    dialog.setFilterExtensions(new String[] {"*.als"});
    String result = dialog.open();

    AlloyParser ap = new AlloyParser(result);
    ap.parse();
    return null;
  }
}
