package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.internal.MarkerFactory;

public class JavaOutlineTest extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final ISelection selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
    if (selection instanceof ITreeSelection) {
      final Object element = ((ITreeSelection) selection).getFirstElement();
      final IMember member = (IMember) element;
      final IFile file = member.getResource().getAdapter(IFile.class);
      MarkerFactory.createMarker(file, (ITreeSelection) selection);
    }
    return null;
  }
}
