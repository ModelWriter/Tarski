package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;

public class DropDownCommandHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    // Sanity check.
    if (null == event) {
      return null;
    }

    // Class check.
    if (!(event.getTrigger() instanceof Event)) {
      return null;
    }

    final Event eventWidget = (Event) event.getTrigger();

    // Makes sure event came from a ToolItem.
    if (!(eventWidget.widget instanceof ToolItem)) {
      return null;
    }

    final ToolItem toolItem = (ToolItem) eventWidget.widget;

    // Creates fake selection event.
    final Event newEvent = new Event();
    newEvent.button = 1;
    newEvent.widget = toolItem;
    newEvent.detail = SWT.ARROW;
    newEvent.x = toolItem.getBounds().x;
    newEvent.y = toolItem.getBounds().y + toolItem.getBounds().height;

    // Dispatches the event.
    toolItem.notifyListeners(SWT.Selection, newEvent);

    return null;
  }
}
