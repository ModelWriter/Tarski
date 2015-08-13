package eu.modelwriter.marker.typing.alloy;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

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
import eu.modelwriter.marker.MarkerActivator;
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
    try {
      A4Reporter rep = new A4Reporter() {
        // For example, here we choose to display each "warning" by printing it to System.out

        @Override
        public void warning(ErrorWarning msg) {
          MessageDialog dialog =
              new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                  "Alloy Error Information", null,
                  "Relevance Warning:\n" + (msg.toString().trim()) + "\n\n",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        }
      };

      // Parse+typecheck the model
      System.out.println("=========== Parsing+Typechecking " + filename + " =============");
      Module world;

      world = CompUtil.parseEverything_fromFile(rep, null, filename);


      SafeList<Sig> list = world.getAllSigs();
      for (Sig sig : list) {
        // String str = sig.toString().substring(sig.toString().indexOf("/")+1);

        if (sig instanceof PrimSig) {
          PrimSig primSig = (PrimSig) sig;
          // if (!primSig.children().isEmpty()){
          // convertToMarkerType(primSig);
          //// types.add(str);
          // }
          if (primSig.isTopLevel()) {
            types.add(convertToMarkerType(primSig));
          }
        } else if (sig instanceof SubsetSig) {
          SubsetSig subsetSig = (SubsetSig) sig;
          ConstList<Sig> listOfParents = subsetSig.parents;
        }
        SafeList<Field> fields = sig.getFields();
        for (Field field : fields) {
          String str2 =
        		  field.label+" : " + field.sig.toString().substring(field.sig.toString().indexOf("/")+1) +" -> "+field.decl().expr.toString().replace("this/","of ");
          rels.add(str2);
        }
      }
      
      MessageDialog messageDialog =
              new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                  "Information", null, "Alloy file has been parsed succesfully", MessageDialog.INFORMATION,
                  new String[] {"OK"}, 0);
      messageDialog.open();
    } catch (Err e) {
      // TODO Auto-generated catch block
      MessageDialog dialog =
          new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
              "Alloy Error Information", null, e.getMessage(), MessageDialog.INFORMATION,
              new String[] {"OK"}, 0);
      dialog.open();
    }
  }

  private MarkerTypeElement convertToMarkerType(Sig rootSig) {
    if (rootSig instanceof PrimSig) {
      PrimSig primSig = (PrimSig) rootSig;
      MarkerTypeElement rootType;
      if (primSig.isAbstract != null){
        rootType =
            new MarkerTypeElement(primSig.toString().substring(primSig.toString().indexOf("/") + 1) + "{abs}");
      }
      else {
        rootType =
            new MarkerTypeElement(primSig.toString().substring(primSig.toString().indexOf("/") + 1));
      }
      try {
        if (primSig.children().isEmpty()) {
          return rootType;
        } else {
          for (int i = 0; i < primSig.children().size(); i++) {
            rootType.getChildren().add(convertToMarkerType(primSig.children().get(i)));
          }
          return rootType;
        }
      } catch (Err e) {
        MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Alloy Error Information", null,
                e.getMessage(), MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
      // try {
      // PrimSig primSig = (PrimSig) rootSig;
      // MarkerTypeElement root = new MarkerTypeElement(primSig.toString());
      // SafeList<Sig.PrimSig> listOfChildren = primSig.children();
      // for (PrimSig childPrimSig : listOfChildren) {
      // MarkerTypeElement child = new MarkerTypeElement(childPrimSig.toString());
      // root.getChildren().add(child);
      // }
      // if (primSig.isTopLevel()){
      // types.add(root);
      // }
      // } catch (Err e) {
      // MessageDialog dialog =
      // new MessageDialog(MarkerActivator.getShell(), "Alloy Error Information", null,
      // e.getMessage(), MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      // dialog.open();
      // }
    } else if (rootSig instanceof SubsetSig) {
      // SubsetSig subsetSig = (SubsetSig) rootSig;
      // subsetSig.parents
    }
    return null;
  }
}
