package eu.modelwriter.marker.typing.alloy;

import java.util.ArrayList;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.ConstList;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4.SafeList;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.Field;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.PrimSig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.SubsetSig;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import eu.modelwriter.marker.internal.MarkerTypeElement;

public class AlloyParser {

  private ArrayList<MarkerTypeElement> types = new ArrayList<MarkerTypeElement>();
  private ArrayList<String> rels = new ArrayList<String>();

  AlloyParser() {}

  public AlloyParser(String filename) {
    parse(filename);
  }

  public ArrayList<MarkerTypeElement> getTypes() {
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
//        String str = sig.toString().substring(sig.toString().indexOf("/")+1);
        
        if (sig instanceof PrimSig){
          PrimSig primSig = (PrimSig) sig;
//          if (!primSig.children().isEmpty()){
//            convertToMarkerType(primSig);
////            types.add(str);
//          }
          if (primSig.isTopLevel()){
            types.add(convertToMarkerType(primSig));
          }
        } else if (sig instanceof SubsetSig){
          SubsetSig subsetSig = (SubsetSig) sig;
          ConstList<Sig> listOfParents = subsetSig.parents;
        }
        SafeList<Field> fields = sig.getFields();
        for (Field field : fields) {
          String str2 =
              field.decl().expr.toString().substring(0, field.decl().expr.toString().indexOf(" "));
          rels.add(str2);
        }

      }
    } catch (Err e) {
      // TODO hatayi yakala
      e.printStackTrace();
    }
  }
  
  private MarkerTypeElement convertToMarkerType(Sig rootSig){
    if (rootSig instanceof PrimSig){
      PrimSig primSig = (PrimSig) rootSig;
      MarkerTypeElement rootType = new MarkerTypeElement(primSig.toString().substring(primSig.toString().indexOf("/")+1));
      try {
        if (primSig.children().isEmpty()){
          return rootType;
        }
        else {
          for (int i=0; i<primSig.children().size(); i++) {
            rootType.getChildren().add(convertToMarkerType(primSig.children().get(i)));
          }
          return rootType;
        }
      } catch (Err e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
//      try {
//        PrimSig primSig = (PrimSig) rootSig;
//        MarkerTypeElement root = new MarkerTypeElement(primSig.toString());
//        SafeList<Sig.PrimSig> listOfChildren = primSig.children();
//        for (PrimSig childPrimSig : listOfChildren) {
//          MarkerTypeElement child = new MarkerTypeElement(childPrimSig.toString());
//          root.getChildren().add(child);
//        }
//        if (primSig.isTopLevel()){
//          types.add(root);
//        }
//      } catch (Err e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
    } else if (rootSig instanceof SubsetSig){
//      SubsetSig subsetSig = (SubsetSig) rootSig;
//      subsetSig.parents
    }
    return null;
  }
}
