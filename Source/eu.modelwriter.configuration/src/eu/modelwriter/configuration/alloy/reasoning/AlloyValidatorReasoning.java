package eu.modelwriter.configuration.alloy.reasoning;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import edu.mit.csail.sdg.alloy4viz.VizGUI;

public class AlloyValidatorReasoning {

  public static boolean validate() {
    InstanceTranslatorReasoning instanceTranslator = new InstanceTranslatorReasoning();
    instanceTranslator.translate();

    String filename = instanceTranslator.getBaseFileDirectory() + "reasoning.als";

    try {
      A4Reporter rep = new A4Reporter() {
        @Override
        public void warning(ErrorWarning msg) {
          System.out.print("Relevance Warning:\n" + (msg.toString().trim()) + "\n\n");
          System.out.flush();
        }
      };
      Module world = null;

      world = CompUtil.parseEverything_fromFile(rep, null, filename);

      A4Options options = new A4Options();
      options.solver = A4Options.SatSolver.SAT4J;

      for (Command command : world.getAllCommands()) {
        A4Solution ans = null;
        ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command,
            options);

        if (ans.satisfiable()) {
          return true;
        }
      }

    } catch (Err e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return false;
  }

  public static void main(String[] args) {
    if (AlloyValidatorReasoning.validate())
      System.out.println("Instance var");
    else
      System.out.println("Instance yok");
  }

}
