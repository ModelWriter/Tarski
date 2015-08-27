package eu.modelwriter.architecture.textconnectors.docx.command.ui;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.architecture.textconnectors.docx.usecase.UseCase2BusinessProcessModelConverter;

public class UseCase2BusinessProcessModelConverterHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelectionService service =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
    ISelection selection = service.getSelection();
    if (selection instanceof IStructuredSelection) {
      Object selected = ((IStructuredSelection) selection).getFirstElement();
      IFile file = (IFile) Platform.getAdapterManager().getAdapter(selected, IFile.class);
      try {
        // UseCase2BusinessProcessModelConverter
        // .convert(file.getLocation().toString().replaceAll("/", "\\\\\\\\\\\\\\\\"));
        UseCase2BusinessProcessModelConverter.convert(file.getLocationURI().toString(),
            file.getLocation().toString().replaceAll("/", "\\\\\\\\\\\\\\\\"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

}
