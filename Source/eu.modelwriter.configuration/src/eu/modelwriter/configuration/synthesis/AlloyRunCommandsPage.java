package eu.modelwriter.configuration.synthesis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import edu.mit.csail.sdg.alloy4.ConstList;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import eu.modelwriter.configuration.alloy.trace.TraceException;

public class AlloyRunCommandsPage extends MWizardPage {

  private final ConstList<Command> commandList;
  private List list;

  public AlloyRunCommandsPage(final ConstList<Command> commands) {
    super("Run Commands");
    this.setTitle("Select Run Command");
    this.resetMessage();
    this.commandList = commands;
  }

  private void resetMessage() {
    this.setDescription("Select a command to start.");
  }

  @Override
  public void createControl(final Composite parent) {
    final Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    this.list =
        new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

    for (final Command command : this.commandList) {
      this.list.add(command.toString());
    }
    list.setSelection(0);
    list.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        setPageComplete(true);
        resetMessage();
      }

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {

      }
    });
    this.setControl(container);
  }

  @Override
  public boolean nextPressed() throws TraceException {
    AlloyToEMF alloyToEmf = ((AlloyToEMFWizard) getWizard()).getAlloyToEmf();

    if (alloyToEmf.executeCommand(getSelection())) {
      return true;
    } else {
      AlloyRunCommandsPage.this.setErrorMessage(
          "No counter example found. Please select a different command to try again");
      setPageComplete(false);
      return false;
    }
  }

  public Command getSelection() {
    return commandList.get(list.getSelectionIndex());
  }

}