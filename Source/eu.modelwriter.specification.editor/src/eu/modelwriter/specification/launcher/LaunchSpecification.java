package eu.modelwriter.specification.launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.part.FileEditorInput;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.ConstList;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.parser.CompModule;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import edu.mit.csail.sdg.alloy4viz.VizGUI;
import eu.modelwriter.marker.ui.internal.wizards.launchwizard.LaunchWizard;
import eu.modelwriter.specification.editor.Activator;

public class LaunchSpecification implements ILaunchShortcut {

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
    final List<String> commandStrings = new ArrayList<>();

    final A4Reporter rep = new A4Reporter() {
      @Override
      public void warning(final ErrorWarning msg) {
        final MessageConsole myConsole =
            LaunchSpecification.this.findConsole("Specification Console");
        final MessageConsoleStream out = myConsole.newMessageStream();
        out.println("Relevance Warning:\n" + msg.toString().trim() + "\n\n");

        final String id = IConsoleConstants.ID_CONSOLE_VIEW;
        IConsoleView view = null;
        try {
          view = (IConsoleView) Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
              .getActivePage().showView(id);
        } catch (final PartInitException e) {
          e.printStackTrace();
        }
        view.display(myConsole);
      }
    };

    CompModule world = null;
    try {
      world = CompUtil.parseEverything_fromFile(rep, null,
          ((FileEditorInput) editor.getEditorInput()).getPath().toString());
    } catch (final Err e) {
      final MessageConsole myConsole =
          LaunchSpecification.this.findConsole("Specification Console");
      final MessageConsoleStream out = myConsole.newMessageStream();
      out.println("Parse error:\n" + e.toString().trim() + "\n\n");

      final String id = IConsoleConstants.ID_CONSOLE_VIEW;
      IConsoleView view = null;
      try {
        view = (IConsoleView) Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
            .getActivePage().showView(id);
      } catch (final PartInitException e1) {
        e1.printStackTrace();
      }
      view.display(myConsole);

      return;
    }

    final A4Options options = new A4Options();
    options.solver = A4Options.SatSolver.SAT4J;

    final Map<String, Command> nameToCommands = new HashMap<String, Command>();
    final ConstList<Command> allCommands = world.getAllCommands();

    Command command = null;
    if (allCommands.size() > 1) {
      for (final Command com : allCommands) {
        commandStrings.add(com.toString());
        nameToCommands.put(com.toString(), com);
      }

      final LaunchWizard wizard = new LaunchWizard(commandStrings);
      final WizardDialog dialog = new WizardDialog(
          Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
      if (dialog.open() == 1) {
        return;
      }

      final String commandSelection = wizard.getSelection();
      command = nameToCommands.get(commandSelection);
    } else if (allCommands.size() == 1) {
      command = allCommands.get(0);
    } else {
      final MessageDialog warningDialog = new MessageDialog(new Shell(), "Warning!", null,
          "There is not any command on this specification editor", MessageDialog.WARNING,
          new String[] {"OK"}, 0);
      warningDialog.open();
      return;
    }

    System.out.println("============ Command " + command + ": ============");
    A4Solution ans = null;
    try {
      ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command,
          options);
    } catch (final Err e) {
      e.printStackTrace();
    }
    System.out.println(ans);

    if (ans.satisfiable()) {
      try {
        ans.writeXML("alloy_example_output.xml");
      } catch (final Err e) {
        e.printStackTrace();
      }

      new VizGUI(false, "alloy_example_output.xml", null);
    }
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
