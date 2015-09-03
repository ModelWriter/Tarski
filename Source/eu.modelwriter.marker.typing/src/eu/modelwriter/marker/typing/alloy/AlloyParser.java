package eu.modelwriter.marker.typing.alloy;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.DateTime;
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
import edu.mit.csail.sdg.alloy4compiler.ast.Type;
import edu.mit.csail.sdg.alloy4compiler.ast.Type.ProductType;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;
import eu.modelwriter.traceability.core.persistence.persistencePackage;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.InstanceType;
import eu.modelwriter.traceability.core.persistence.RepositoryType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TypeType;
import eu.modelwriter.traceability.core.persistence.TypesType;
import eu.modelwriter.traceability.core.persistence.util.persistenceResourceFactoryImpl;
import eu.modelwriter.traceability.core.persistence.util.persistenceResourceImpl;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.typing.internal.AlloyUtilities;

public class AlloyParser {

  private ArrayList<MarkerTypeElement> types = new ArrayList<MarkerTypeElement>();
  private ArrayList<String> rels = new ArrayList<String>();
  private String filename;

  AlloyParser() {}

  public AlloyParser(String filename) {
    this.filename = filename;
    parse(filename);
  }

  public ArrayList<MarkerTypeElement> getTypes() {
    return types;
  }

  public ArrayList<String> getRels() {
    return rels;
  }

  private void parse(String filename) {
    // AlloyUtilities.createXMLFromAlloy(filename);
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

      DocumentRoot documentRoot = createBaseXmlFile();
      EList<SigType> xmlSigList = documentRoot.getAlloy().getInstance().getSig();
      EList<FieldType> xmlFieldList = documentRoot.getAlloy().getInstance().getField();

      int idIndex = 4;


      world = CompUtil.parseEverything_fromFile(rep, null, filename);
      for (Module modules : world.getAllReachableModules()) {
        SafeList<Sig> list = modules.getAllSigs();
        for (Sig sig : list) {
          if (sig instanceof PrimSig) {
            PrimSig primSig = (PrimSig) sig;

            xmlSigList.add(getSigType(primSig, idIndex, xmlSigList));
            idIndex++;

            if (primSig.children().size() == 0 && primSig.toString()
                .substring(primSig.toString().indexOf("/") + 1).equals("Univ")) {
              break;
            }
            if (primSig.isTopLevel()) {
              types.add(convertToMarkerType(primSig));
            }
          } else if (sig instanceof SubsetSig) {
            SubsetSig subsetSig = (SubsetSig) sig;
            @SuppressWarnings("unused")
            ConstList<Sig> listOfParents = subsetSig.parents;
          }
        }
      }

      for (Module modules : world.getAllReachableModules()) {
        SafeList<Sig> list = modules.getAllSigs();
        for (Sig sig : list) {
          SafeList<Field> fields = sig.getFields();
          for (Field field : fields) {

            xmlFieldList.add(getFieldType(field, idIndex, xmlFieldList, xmlSigList));
            idIndex++;

            String product = "";
            if (field.decl().expr.type().size() > 1) {
              Iterator<ProductType> iter = field.decl().expr.type().iterator();
              while (iter.hasNext()) {
                Type.ProductType productType = (Type.ProductType) iter.next();
                if (iter.hasNext())
                  product +=
                      productType.toString().substring(productType.toString().indexOf("/") + 1)
                          + ",";
                else
                  product +=
                      productType.toString().substring(productType.toString().indexOf("/") + 1);
              }
            } else {
              product = field.decl().expr.type().toExpr().toString()
                  .substring(field.decl().expr.type().toExpr().toString().indexOf("/") + 1);
            }
            String str2 = field.label + " : "
                + field.sig.toString().substring(field.sig.toString().indexOf("/") + 1) + " -> "
                + field.decl().expr.mult() + " " + product;
            rels.add(str2);
          }
        }
      }



      AlloyUtilities.saveResource(AlloyUtilities.getResource(), documentRoot);

      MessageDialog messageDialog =
          new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
              "Information", null, "Alloy file has been parsed succesfully",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      messageDialog.open();
    } catch (Err e) {
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
      if (primSig.isAbstract != null) {
        rootType = new MarkerTypeElement(
            primSig.toString().substring(primSig.toString().indexOf("/") + 1) + "{abs}");
      } else {
        rootType = new MarkerTypeElement(
            primSig.toString().substring(primSig.toString().indexOf("/") + 1));
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
    } else if (rootSig instanceof SubsetSig) {
      // SubsetSig subsetSig = (SubsetSig) rootSig;
      // subsetSig.parents
    }
    return null;
  }


  private DocumentRoot createBaseXmlFile() {
    DocumentRoot documentRoot = persistenceFactory.eINSTANCE.createDocumentRoot();

    AlloyType alloyType = persistenceFactory.eINSTANCE.createAlloyType();
    documentRoot.setAlloy(alloyType);
    alloyType.setBuilddate("");

    InstanceType instanceType = persistenceFactory.eINSTANCE.createInstanceType();
    alloyType.setInstance(instanceType);
    instanceType.setBitwidth(0);
    instanceType.setFilename(filename);
    instanceType.setMaxseq(0);

    SigType sigSegInt = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigSegInt);
    sigSegInt.setID(0);
    sigSegInt.setLabel("seq/Int");
    sigSegInt.setParentID(1);
    sigSegInt.setBuiltin("yes");

    SigType sigInt = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigInt);
    sigInt.setID(1);
    sigInt.setLabel("Int");
    sigInt.setParentID((byte) 2);
    sigInt.setBuiltin("yes");

    SigType sigUniv = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigUniv);
    sigUniv.setID(2);
    sigUniv.setLabel("univ");
    sigUniv.setBuiltin("yes");

    SigType sigString = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigString);
    sigString.setID(3);
    sigString.setLabel("String");
    sigString.setParentID(2);
    sigString.setBuiltin("yes");

    RepositoryType repositoryType = persistenceFactory.eINSTANCE.createRepositoryType();
    alloyType.setRepository(repositoryType);

    // AlloyUtilities.saveResource(res, documentRoot);

    return documentRoot;
  }

  private SigType getSigType(PrimSig primSig, int idIndex, EList<SigType> sigTypeList) {
    String parentName = primSig.parent.toString();

    int parentId = parentId(parentName, sigTypeList);

    SigType sigType = persistenceFactory.eINSTANCE.createSigType();
    sigType.setID(idIndex);
    sigType.setLabel(primSig.label);
    sigType.setParentID(parentId);

    return sigType;
  }

  private int parentId(String parentName, EList<SigType> sigTypeList) {

    for (SigType sigType : sigTypeList) {
      if (sigType.getLabel().equals(parentName))
        return sigType.getID();
    }

    return -1;

  }

  private FieldType getFieldType(Field field, int idIndex, EList<FieldType> fieldTypeList,
      EList<SigType> sigTypeList) {
    FieldType fieldType = persistenceFactory.eINSTANCE.createFieldType();

    int fieldParentId = parentId(field.sig.label.toString(), sigTypeList);
    fieldType.setLabel(field.label);
    fieldType.setID(idIndex);
    fieldType.setParentID(fieldParentId);

    Iterator<ProductType> iter = field.decl().expr.type().iterator();
    while (iter.hasNext()) {
      Type.ProductType productType = (Type.ProductType) iter.next();

      TypesType typesType = persistenceFactory.eINSTANCE.createTypesType();
      fieldType.getTypes().add(typesType);

      TypeType firstTypeType = persistenceFactory.eINSTANCE.createTypeType();
      typesType.getType().add(firstTypeType);
      firstTypeType.setID(fieldParentId);

      TypeType secondTypeType = persistenceFactory.eINSTANCE.createTypeType();
      typesType.getType().add(secondTypeType);
      int secondTypeId = parentId(productType.toString(), sigTypeList);
      secondTypeType.setID(secondTypeId);
    }

    return fieldType;
  }


}
