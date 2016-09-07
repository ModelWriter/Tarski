package eu.modelwriter.marker.command;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import edu.mit.csail.sdg.alloy4.ConstList;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import eu.modelwriter.configuration.alloy2emf.AlloyExampleSelectionPage;
import eu.modelwriter.configuration.converter.ConverterWizard;
import eu.modelwriter.configuration.converter.ConverterWizardDialog;
import eu.modelwriter.configuration.internal.AlloyExecuter;

public class RunAsAlloyContributionItem extends ContributionItem implements SelectionListener {

  private static AlloyExecuter alloyExecuter = new AlloyExecuter();
  private IEditorPart editor;

  public RunAsAlloyContributionItem() {}

  public RunAsAlloyContributionItem(String id) {
    super(id);
  }

  public IFile getFile() {
    final ISelection selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    if (selection != null && selection instanceof TreeSelection) {
      final TreeSelection treeSelection = (TreeSelection) selection;
      final IFile file = (IFile) treeSelection.getFirstElement();
      return file;
    }
    return null;
  }

  @Override
  public void fill(Menu menu, int index) {
    super.fill(menu, index);
    int i = index;

    String filePath = "";
    IFile selectedFile = getFile();
    if (selectedFile == null) {
      editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      editor.doSave(new NullProgressMonitor());
      filePath = ((FileEditorInput) editor.getEditorInput()).getPath().toOSString();
    } else {
      filePath = selectedFile.getRawLocation().toOSString();
    }

    try {
      alloyExecuter.parse(filePath);
      final ConstList<Command> allCommands = alloyExecuter.getRunCommands();
      if (allCommands.size() > 0) {
        for (final Command com : allCommands) {
          final MenuItem menuItem = new MenuItem(menu, SWT.PUSH, i++);
          menuItem.setText(com.toString());
          menuItem.setData("command", com);
          menuItem.addSelectionListener(this);
        }
      } else {
        final MenuItem menuItem = new MenuItem(menu, SWT.PUSH, i++);
        menuItem.setText("There is no command to execute");
        return;
      }
    } catch (Err e) {
      e.printStackTrace();
      final MenuItem menuItem = new MenuItem(menu, SWT.PUSH, i++);
      menuItem.setText("There is no command to execute");
      menuItem.setData("command", null);
      return;
    }
  }

  @Override
  public void widgetSelected(SelectionEvent e) {
    final MenuItem mi = (MenuItem) ((e.item != null) ? e.item : e.getSource());
    Command command = (Command) mi.getData("command");
    if (command == null) {
      return;
    }
    try {
      A4Solution solution = alloyExecuter.executeCommand(command);
      if (solution != null) {
        solution.writeXML("alloy_example_output.xml");
        showWizard(solution, command.toString());
      } else {
        final MessageDialog warningDialog = new MessageDialog(Activator.getShell(), "Result", null,
            "No counterexample found. Assertion may be invalid.", MessageDialog.WARNING,
            new String[] {"OK"}, 0);
        warningDialog.open();
      }
    } catch (Err e1) {
      final MessageDialog warningDialog = new MessageDialog(Activator.getShell(), "Failed", null,
          "Execution failed! \n" + e1.msg, MessageDialog.WARNING, new String[] {"OK"}, 0);
      warningDialog.open();
      e1.printStackTrace();
    }
  }

  private void showWizard(A4Solution solution, String commandName) {
    ConverterWizard wizard = new ConverterWizard(null, commandName);
    AlloyExampleSelectionPage page = new AlloyExampleSelectionPage();
    wizard.addPage(page);
    page.setTitle("Alloy Solutions");
    // Display display = Display.getDefault();
    // Shell shell = new Shell(display);
    // shell.setMaximized(true);
    // shell.setVisible(false);
    // shell.pack();
    ConverterWizardDialog dialog = new ConverterWizardDialog(null, wizard);
    page.setFirstSolution(solution);
    dialog.open();
  }

  @Override
  public void widgetDefaultSelected(SelectionEvent e) {}

}
