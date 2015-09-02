package eu.modelwriter.marker.typing.internal;

import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.alloyxmlapi.AlloyXSDFileFactory;
import eu.modelwriter.alloyxmlapi.AlloyXSDFilePackage;
import eu.modelwriter.alloyxmlapi.AtomType;
import eu.modelwriter.alloyxmlapi.DocumentRoot;
import eu.modelwriter.alloyxmlapi.FieldType;
import eu.modelwriter.alloyxmlapi.SigType;
import eu.modelwriter.alloyxmlapi.TupleType;
import eu.modelwriter.alloyxmlapi.util.AlloyXSDFileResourceFactoryImpl;
import eu.modelwriter.marker.internal.MarkElementUtilities;

public class AlloyUtilities {

  public static String xmlFileLocation = "alloyXml.xml";

  public static String getLocation() {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/" + xmlFileLocation;
  }

  public static void createXMLFromAlloy(String filename) {
    try {
      A4Reporter rep = new A4Reporter();

      Module world = CompUtil.parseEverything_fromFile(rep, null, filename);
      A4Options opt = new A4Options();
      opt.originalFilename = filename;
      opt.solver = A4Options.SatSolver.SAT4J;
      Command cmd = world.getAllCommands().get(0);
      A4Solution sol = TranslateAlloyToKodkod.execute_commandFromBook(rep,
          world.getAllReachableSigs(), cmd, opt);
      assert sol.satisfiable();
      sol.writeXML(getLocation());

      clearSigAndFields();

    } catch (Err e) {
      e.printStackTrace();
    }
  }

  private static void clearSigAndFields() {
    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);
    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (SigType sigType : sigs) {
      sigType.getAtom().clear();
    }

    EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();

    for (FieldType fieldType : fields) {
      fieldType.getTuple().clear();
    }

    saveResource(res, documentRoot);
  }

  public static Resource getResource() {
    ResourceSet resourceSet = new ResourceSetImpl();

    // Register the appropriate resource factory to handle all file extensions.
    //
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new AlloyXSDFileResourceFactoryImpl());

    // Register the package to ensure it is available during loading.
    //
    resourceSet.getPackageRegistry().put(AlloyXSDFilePackage.eNS_URI,
        AlloyXSDFilePackage.eINSTANCE);

    URI uri = URI.createFileURI(getLocation());

    return resourceSet.getResource(uri, true);

  }

  public static void saveResource(Resource res, DocumentRoot documentRoot) {
    res.getContents().clear();
    res.getContents().add(documentRoot);
    try {
      res.save(null);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  public static void addTypeToMarker(IMarker marker) {
    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);

    AtomType atom = AlloyXSDFileFactory.eINSTANCE.createAtomType();

    atom.setLabel(MarkElementUtilities.getSourceId(marker));
    atom.setLocation(MarkElementUtilities.getPath(marker));

    String type = "this/" + MarkElementUtilities.getType(marker);

    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (SigType sigType : sigs) {
      if (type.equals(sigType.getLabel())) {
        sigType.getAtom().add(atom);
        break;
      }
    }

    saveResource(res, documentRoot);
  }

  public static void addRelation2Markers(IMarker fromMarker, IMarker toMarker, String relation) {
    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);

    AtomType fromAtom = AlloyXSDFileFactory.eINSTANCE.createAtomType();
    fromAtom.setLabel(MarkElementUtilities.getSourceId(fromMarker));
    fromAtom.setLocation(MarkElementUtilities.getPath(fromMarker));

    AtomType toAtom = AlloyXSDFileFactory.eINSTANCE.createAtomType();
    toAtom.setLabel(MarkElementUtilities.getSourceId(toMarker));
    toAtom.setLocation(MarkElementUtilities.getPath(toMarker));

    TupleType tuple = AlloyXSDFileFactory.eINSTANCE.createTupleType();
    tuple.getAtom().add(fromAtom);
    tuple.getAtom().add(toAtom);

    EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();

    for (FieldType fieldType : fields) {
      if (relation.equals(fieldType.getLabel())) {
        fieldType.getTuple().add(tuple);
        break;
      }
    }

    saveResource(res, documentRoot);
  }



  public static void showViz() {
    final String xmlFileName = Util.canon(getLocation());
    File f = new File(xmlFileName);
    AlloyInstance myInstance = null;
    try {
      if (!f.exists())
        throw new IOException("File " + xmlFileName + " does not exist.");
      myInstance = StaticInstanceReader.parseInstance(f);
    } catch (Err e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    VizState myState = null;

    myState = new VizState(myInstance);

    VizGraphPanel graph = new VizGraphPanel(myState, false);
    JDialog dialog = new JDialog();
    dialog.add(graph);
    dialog.setVisible(true);
    dialog.pack();

  }

  public static void main(String[] args) {
    createXMLFromAlloy("C:\\Users\\3\\Desktop\\Ecore.als");
  }

}
