package eu.modelwriter.marker.typing.alloy;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4.SafeList;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.Field;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;

public class AlloyParser {

  public AlloyParser(String filename) {
    A4Reporter rep = new A4Reporter() {
      // For example, here we choose to display each "warning" by printing it to System.out
      @Override
      public void warning(ErrorWarning msg) {
        System.out.print("Relevance Warning:\n" + (msg.toString().trim()) + "\n\n");
        System.out.flush();
      }
    };
    
    // Parse+typecheck the model
    System.out.println("=========== Parsing+Typechecking " + filename + " =============");
    Module world;
    try {
      world = CompUtil.parseEverything_fromFile(rep, null, filename);

      SafeList<Sig> list = world.getAllSigs();
      
      for (Sig sig : list) {
        System.out.println(sig.toString());
        System.out.println("-----------------------------");
        SafeList<Field> fields = sig.getFields();
        for (Field field : fields) {
          System.out.println(field);
          System.out.println(field.decl().expr);
        }
//        System.out.println(sig.getFields().get(0));
//        System.out.println("+++++++++++++++++++++++++++++");
//        System.out.println(sig.getFields().get(0).type());
//        System.out.println("*****************************");
      }


//      // Choose some default options for how you want to execute the commands
//      A4Options options = new A4Options();
//      options.solver = A4Options.SatSolver.SAT4J;
//
//      for (Command command : world.getAllCommands()) {
//        // Execute the command
//        System.out.println("============ Command " + command + ": ============");
//        A4Solution ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(),
//            command, options);
//        // Print the outcome
//        System.out.println(ans);
//        // If satisfiable...
//        if (ans.satisfiable()) {
//          // You can query "ans" to find out the values of each set or type.
//          // This can be useful for debugging.
//          //
//          // You can also write the outcome to an XML file
//          ans.writeXML("alloy_example_output.xml");
//          //
//          // You can then visualize the XML file by calling this:
//          // if (viz == null) {
//          // viz = new VizGUI(false, "alloy_example_output.xml", null);
//          // } else {
//          // viz.loadXML("alloy_example_output.xml", true);
//          // }
//        }
//      }
    } catch (Err e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
