package eu.modelwriter.traceability.validation.editor.base.launcher;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.traceability.validation.core.fol.Test;
import eu.modelwriter.traceability.validation.core.fol.ValidationError;
import eu.modelwriter.traceability.validation.editor.Activator;
import eu.modelwriter.traceability.validation.editor.base.view.ParseTreeView;

public class LaunchModel implements ILaunchShortcut {

  private MessageConsole findConsole(final String name) {
    final ConsolePlugin plugin = ConsolePlugin.getDefault();
    final IConsoleManager conMan = plugin.getConsoleManager();
    final IConsole[] existing = conMan.getConsoles();
    for (int i = 0; i < existing.length; i++) {
      if (name.equals(existing[i].getName())) {
        return (MessageConsole) existing[i];
      }
    }
    // no console found, so create a new one
    final MessageConsole myConsole = new MessageConsole(name, null);
    conMan.addConsoles(new IConsole[] {myConsole});
    return myConsole;
  }

  @Override
  public void launch(final IEditorPart editor, final String mode) {
    editor.doSave(new NullProgressMonitor());

    final ITextEditor textEditor = editor.getAdapter(ITextEditor.class);
    final IDocumentProvider provider = textEditor.getDocumentProvider();
    final IDocument document = provider.getDocument(editor.getEditorInput());

    final MessageConsole myConsole = LaunchModel.this.findConsole("Validation Console");
    final MessageConsoleStream out = myConsole.newMessageStream();
    myConsole.clearConsole();

    Test.doParse(document.get());

    if (Test.getErrors().size() > 0) {
      final List<ValidationError> errors = Test.getErrors();
      for (final ValidationError error : errors) {
        out.setColor(new Color(null, new RGB(255, 0, 0)));
        out.println(error.getMessage());
      }
    } else {
      final boolean result = Test.getResult();
      out.setColor(new Color(null, new RGB(0, 0, 0)));
      out.println(result ? "true" : "false");
    }

    ParseTreeView.refresh();

    final String id = IConsoleConstants.ID_CONSOLE_VIEW;
    IConsoleView view = null;
    try {
      view = (IConsoleView) Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
          .getActivePage().showView(id);
    } catch (final PartInitException e1) {
      e1.printStackTrace();
    }
    view.display(myConsole);
  }

  @Override
  public void launch(final ISelection selection, final String mode) {
    // if (selection instanceof ITreeSelection) {
    // final ITreeSelection treeSelection = (ITreeSelection) selection;
    // if (treeSelection.getFirstElement() instanceof IFile) {
    // final IFile iFile = (IFile) treeSelection.getFirstElement();
    // }
    // }
  }
}
