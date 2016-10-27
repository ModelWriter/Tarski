package eu.modelwriter.marker.command;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;

import edu.mit.csail.sdg.alloy4.ConstList;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import eu.modelwriter.configuration.alloy2emf.AlloySolutionSelectionPage;
import eu.modelwriter.configuration.generation.GenerationWizard;
import eu.modelwriter.configuration.generation.GenerationWizardDialog;
import eu.modelwriter.configuration.internal.AlloyExecuter;

public class RunAsAlloyContributionItem extends ContributionItem implements SelectionListener {

  private static AlloyExecuter alloyExecuter = new AlloyExecuter();
  private IEditorPart editor;

  public RunAsAlloyContributionItem() {}

  public RunAsAlloyContributionItem(String id) {
    super(id);
  }

  @Override
  public void fill(Menu menu, int index) {
    super.fill(menu, index);
    int i = index;
    // FIXME y this works on Sirius editor?

    try {
      String filePath = "";
      IFile selectedFile = AlloyParseUtil.getSelectedFile();
      if (selectedFile == null) {
        editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        editor.doSave(new NullProgressMonitor());
        filePath = ((FileEditorInput) editor.getEditorInput()).getPath().toOSString();
      } else {
        filePath = selectedFile.getRawLocation().toOSString();
      }

      alloyExecuter.parse(filePath);
      final ConstList<Command> allCommands = alloyExecuter.getRunCommands();
      if (allCommands.size() > 0) {
        for (final Command com : allCommands) {
          final MenuItem menuItem = new MenuItem(menu, SWT.PUSH, i++);
          menuItem.setText(com.toString());
          menuItem.setData("command", com);
          menuItem.addSelectionListener(this);
        }
      }
    } catch (Exception e) {
      // e.printStackTrace();
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
        showWizard(solution, command.toString());
      } else {
        String message = "";
        if (command.check) {
          message = "No counterexample found. Assertion may be valid.";
        } else {
          message = "No instance found. Predicate may be inconsistent.";
        }
        final MessageDialog warningDialog = new MessageDialog(Activator.getShell(), "Result", null,
            message, MessageDialog.WARNING, new String[] {"OK"}, 0);
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
    GenerationWizard wizard = new GenerationWizard(null, commandName);
    AlloySolutionSelectionPage page = new AlloySolutionSelectionPage();
    wizard.addPage(page);
    page.setTitle("Alloy Solutions");
    GenerationWizardDialog dialog = new GenerationWizardDialog(null, wizard);
    // dialog maximized
    dialog.setPageSize(Display.getDefault().getBounds().width,
        Display.getDefault().getPrimaryMonitor().getBounds().height);
    // set the solution to show
    page.setFirstSolution(solution);
    dialog.open();
  }

  @Override
  public void widgetDefaultSelected(SelectionEvent e) {}

}
