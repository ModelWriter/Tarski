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
  private String filename;

  public AlloyParser(String filename) {
    this.filename = filename;
  }

  public void parse() {
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
      }
    } catch (Err e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
