package eu.modelwriter.configuration.internal;

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

public class AlloyExecuter {

  private CompModule world = null;
  private A4Reporter rep = null;

  /**
   * 
   * @param filePath alloy file path to parse
   * @return
   * @throws Err
   */
  public AlloyExecuter(String filePath) throws Err {
    rep = new A4Reporter() {
      @Override
      public void warning(final ErrorWarning msg) {
        System.out.println("Relevance Warning:\n" + msg.toString().trim() + "\n\n");
      }
    };
    parse(filePath);
  }

  public AlloyExecuter() {
    rep = new A4Reporter() {
      @Override
      public void warning(final ErrorWarning msg) {
        System.out.println("Relevance Warning:\n" + msg.toString().trim() + "\n\n");
      }
    };
  }

  public void parse(String filePath) throws Err {
    world = CompUtil.parseEverything_fromFile(rep, null, filePath);
  }

  /**
   * Executes given command
   * 
   * @param command to run
   * @return solution if it is satisfiable else null
   * @throws Err
   */
  public A4Solution executeCommand(Command command) throws Err {
    if (world == null)
      return null;

    final A4Options options = new A4Options();
    options.solver = A4Options.SatSolver.SAT4J;
    A4Solution solution =
        TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
    if (solution.satisfiable()) {
      return solution;
    }

    return null;
  }

  /**
   * 
   * @return list of executable commands
   */
  public ConstList<Command> getRunCommands() {
    if (world == null)
      return null;
    return world.getAllCommands();
  }

  public CompModule getWorld() {
    return world;
  }
}
