package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import eu.modelwriter.marker.typing.internal.AlloyUtilities;

public class ShowMarkersHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    AlloyUtilities.showViz();

    return null;
  }

}
