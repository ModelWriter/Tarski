package eu.modelwriter.marker.command;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
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

public class RunAsAlloyContributionItem extends ContributionItem implements SelectionListener {

  private IEditorPart editor;
  private CompModule world = null;
  private A4Reporter rep;
  private final Map<String, Command> nameToCommands = new HashMap<String, Command>();

  public RunAsAlloyContributionItem() {}

  public RunAsAlloyContributionItem(String id) {
    super(id);
  }

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
  public void fill(Menu menu, int index) {
    super.fill(menu, index);
    int i = index;

    this.editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    editor.doSave(new NullProgressMonitor());

    rep = new A4Reporter() {
      @Override
      public void warning(final ErrorWarning msg) {
        final MessageConsole myConsole =
            RunAsAlloyContributionItem.this.findConsole("Specification Console");
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

    try {
      world = CompUtil.parseEverything_fromFile(rep, null,
          ((FileEditorInput) editor.getEditorInput()).getPath().toString());
    } catch (final Err e) {
      final MessageConsole myConsole =
          RunAsAlloyContributionItem.this.findConsole("Specification Console");
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

    final ConstList<Command> allCommands = world.getAllCommands();
    if (allCommands.size() > 0) {
      for (final Command com : allCommands) {
        nameToCommands.put(com.toString(), com);
        final MenuItem menuItem = new MenuItem(menu, SWT.PUSH, i++);
        menuItem.setText(com.toString());
        menuItem.addSelectionListener(this);
      }
    } else {
      final MenuItem menuItem = new MenuItem(menu, SWT.PUSH, i++);
      menuItem.setText("There is no command to execute");
      return;
    }
  }

  private void executeCommand(A4Reporter rep, CompModule world, Command command) {
    final A4Options options = new A4Options();
    options.solver = A4Options.SatSolver.SAT4J;

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
    } else {
      final MessageDialog warningDialog = new MessageDialog(Activator.getShell(), "Result", null,
          "No counterexample found. Assertion may be valid.", MessageDialog.WARNING,
          new String[] {"OK"}, 0);
      warningDialog.open();
    }

  }

  @Override
  public void widgetSelected(SelectionEvent e) {
    final MenuItem mi = (MenuItem) ((e.item != null) ? e.item : e.getSource());
    final Command command = nameToCommands.get(mi.getText());
    executeCommand(rep, world, command);
  }

  @Override
  public void widgetDefaultSelected(SelectionEvent e) {
  }

}
