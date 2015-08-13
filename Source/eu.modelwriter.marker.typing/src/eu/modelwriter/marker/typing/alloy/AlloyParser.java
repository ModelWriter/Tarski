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
  private ArrayList<AlloyModule> alloyModuleList = new ArrayList<AlloyModule>();

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

  public ArrayList<AlloyModule> getAlloyModuleList() {
    return alloyModuleList;
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

      for (Module module : world.getAllReachableModules()) {

        AlloyModule alloyModule = new AlloyModule(module.getModelName());
        alloyModuleList.add(alloyModule);

        AlloySig alloySig;

        SafeList<Sig> list = module.getAllSigs();

        for (Sig sig : list) {

          // if (sig.isAbstract != null)
          // alloySig =
          // new AlloySig(sig.toString().substring(sig.toString().lastIndexOf("/") + 1), true);
          // else
          // alloySig =
          // new AlloySig(sig.toString().substring(sig.toString().lastIndexOf("/") + 1), false);

          if (sig instanceof PrimSig) {
            PrimSig primSig = (PrimSig) sig;
            if (primSig.isTopLevel()) {
              alloySig = convertToMarkerType(primSig);
              alloyModule.addSig(alloySig);
              // types.add(convertToMarkerType(primSig));
            }
          } else if (sig instanceof SubsetSig) {
            SubsetSig subsetSig = (SubsetSig) sig;
            ConstList<Sig> listOfParents = subsetSig.parents;
          }

          // AlloyField alloyField;
          //
          // SafeList<Field> fields = sig.getFields();
          // for (Field field : fields) {
          // String expr = field.decl().expr.toString();
          //
          // alloyField = new AlloyField(field.label, expr.substring(expr.lastIndexOf("/") + 1),
          // field.decl().expr.mult().toString());
          //
          // alloySig.addField(alloyField);
          //
          // String str2 = field.label + " : "
          // + field.sig.toString().substring(field.sig.toString().indexOf("/") + 1) + " -> "
          // + field.decl().expr.toString().replace("this/", "of ");
          // rels.add(str2);
          // }


        }
      }

      MessageDialog messageDialog =
          new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
              "Information", null, "Alloy file has been parsed succesfully",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
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


  private AlloySig convertToMarkerType(Sig rootSig) {
    if (rootSig instanceof PrimSig) {
      PrimSig primSig = (PrimSig) rootSig;
      AlloySig rootType;


      if (primSig.isAbstract != null)
        rootType = new AlloySig(
            primSig.toString().substring(primSig.toString().lastIndexOf("/") + 1), true);
      else
        rootType = new AlloySig(
            primSig.toString().substring(primSig.toString().lastIndexOf("/") + 1), false);


      AlloyField alloyField;

      SafeList<Field> fields = primSig.getFields();
      for (Field field : fields) {
        String expr = field.decl().expr.toString();

        alloyField = new AlloyField(field.label, expr.substring(expr.lastIndexOf("/") + 1),
            field.decl().expr.mult().toString());

        rootType.addField(alloyField);

        // String str2 = field.label + " : "
        // + field.sig.toString().substring(field.sig.toString().indexOf("/") + 1) + " -> "
        // + field.decl().expr.toString().replace("this/", "of ");
        // rels.add(str2);
      }


      try {
        if (primSig.children().isEmpty()) {
          return rootType;
        } else {
          for (int i = 0; i < primSig.children().size(); i++) {
            rootType.addChild(convertToMarkerType(primSig.children().get(i)));
          }
          return rootType;
        }
      } catch (Err e) {
        MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Alloy Error Information", null,
                e.getMessage(), MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
    } else if (rootSig instanceof SubsetSig) {
      // SubsetSig subsetSig = (SubsetSig) rootSig;
      // subsetSig.parents
    }
    return null;
  }

  //
  // private MarkerTypeElement convertToMarkerType(Sig rootSig) {
  // if (rootSig instanceof PrimSig) {
  // PrimSig primSig = (PrimSig) rootSig;
  // MarkerTypeElement rootType;
  // if (primSig.isAbstract != null) {
  // rootType = new MarkerTypeElement(
  // primSig.toString().substring(primSig.toString().indexOf("/") + 1) + "{abs}");
  // } else {
  // rootType = new MarkerTypeElement(
  // primSig.toString().substring(primSig.toString().indexOf("/") + 1));
  // }
  // try {
  // if (primSig.children().isEmpty()) {
  // return rootType;
  // } else {
  // for (int i = 0; i < primSig.children().size(); i++) {
  // rootType.getChildren().add(convertToMarkerType(primSig.children().get(i)));
  // }
  // return rootType;
  // }
  // } catch (Err e) {
  // MessageDialog dialog =
  // new MessageDialog(MarkerActivator.getShell(), "Alloy Error Information", null,
  // e.getMessage(), MessageDialog.INFORMATION, new String[] {"OK"}, 0);
  // dialog.open();
  // }
  // } else if (rootSig instanceof SubsetSig) {
  // // SubsetSig subsetSig = (SubsetSig) rootSig;
  // // subsetSig.parents
  // }
  // return null;
  // }
}
