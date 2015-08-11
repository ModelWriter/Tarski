package eu.modelwriter.marker.typing.alloy;

import java.util.ArrayList;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4.SafeList;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.Field;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;

public class AlloyParser {

  private ArrayList<String> types = new ArrayList<String>();
  private ArrayList<String> rels = new ArrayList<String>();

  AlloyParser() {}

  public AlloyParser(String filename) {
    parse(filename);
  }

  public ArrayList<String> getTypes() {
    return types;
  }

  public ArrayList<String> getRels() {
    return rels;
  }

  private void parse(String filename) {
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
        String str = sig.toString().substring(sig.toString().indexOf("/")+1);
        types.add(str);

        SafeList<Field> fields = sig.getFields();;
        for (Field field : fields) {
          String str2 =
              field.decl().expr.toString().substring(0, field.decl().expr.toString().indexOf(" "));
          rels.add(str2);
        }

      }
    } catch (Err e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
