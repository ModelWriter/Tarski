package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import eu.modelwriter.marker.ui.views.masterview.MasterView;

public class MasterViewRefreshHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    MasterView.refreshTree();
    return true;
  }

}
