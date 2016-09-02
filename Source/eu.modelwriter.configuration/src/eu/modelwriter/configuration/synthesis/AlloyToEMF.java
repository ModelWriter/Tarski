package eu.modelwriter.configuration.synthesis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.ConstList;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprVar;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.Field;
import edu.mit.csail.sdg.alloy4compiler.parser.CompModule;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Tuple;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import eu.modelwriter.configuration.alloy.trace.LoadItem;
import eu.modelwriter.configuration.alloy.trace.RelationTrace;
import eu.modelwriter.configuration.alloy.trace.SigTrace;
import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceRepo;
import eu.modelwriter.configuration.internal.EcoreUtilities;


class AlloyToEMFItem {
  String saveLocation = null;
  String containerClassName;
  EObject container;
  EObject modelRoot;
}


public class AlloyToEMF {

  private final String alloyFilePath;
  private CompModule world = null;
  private A4Solution answer = null;
  private A4Reporter rep;
  private AlloyToEMFWizard alloyToEMFWizard;
  private MWizardDialog dialog;

  private final HashMap<String, AlloyToEMFItem> alias2Item = new HashMap<>();
  private final HashMap<String, EObject> atom2EClass = new HashMap<>();

  // states
  public final int RUNNING = 1, NOT_STARTED = 0, FINISHED = 2;
  public int state = NOT_STARTED;

  public AlloyToEMF(String alloyFilePath) {
    this.alloyFilePath = alloyFilePath;
  }

  /**
   * Starts the process
   * 
   * @throws TraceException
   * 
   */
  public void start() throws TraceException {
    if (TraceRepo.get().isEmpty())
      throw new TraceException("No trace has been found.");

    for (LoadItem load : TraceRepo.get().getLoads()) {
      if (load.getModelRoot() == null) {
        throw new TraceException("There is no loaded model for alias: " + load.getAlias());
      }
      AlloyToEMFItem alloyToEMFItem = new AlloyToEMFItem();
      alloyToEMFItem.modelRoot = load.getModelRoot();
      alias2Item.put(load.getAlias(), alloyToEMFItem);
    }

    setupAlloy();
    alloyToEMFWizard = new AlloyToEMFWizard(this);
    dialog = new MWizardDialog(null, alloyToEMFWizard);
    dialog.open();
  }

  /**
   * Setup the alloy for parsing and executing
   * 
   * @throws TraceException
   */
  private void setupAlloy() throws TraceException {
    rep = new A4Reporter() {
      @Override
      public void warning(final ErrorWarning msg) {
        System.out.println("Relevance Warning:\n" + msg.toString().trim() + "\n\n");
      }
    };

    try {
      world = CompUtil.parseEverything_fromFile(rep, null, alloyFilePath);
    } catch (final Err e) {
      e.printStackTrace();
      throw new TraceException("Alloy parsing failed! \n" + e.toString());
    }
  }

  /**
   * Executes given command
   * 
   * @param command to run
   * @return true if execution finds an answer
   * @throws TraceException
   */
  public boolean executeCommand(Command command) throws TraceException {
    final A4Options options = new A4Options();
    options.solver = A4Options.SatSolver.SAT4J;
    try {
      answer = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command,
          options);
      answer.writeXML("/home/y3seker/Desktop/answer.xml");
    } catch (final Err e) {
      throw new TraceException("Selected command can't executed. \n " + command.toString());
    }
    if (answer.satisfiable()) {
      return true;
    }
    return false;
  }

  /**
   * 
   * @return list of executable commands
   */
  public ConstList<Command> getRunCommands() {
    return world.getAllCommands();
  }

  /**
   * Disposes wizard
   */
  public void closeWizard() {
    if (alloyToEMFWizard.performCancel()) {
      dialog.close();
    }
  }

  /**
   * 
   * @param emfAlias alias to find emf model
   * @param selectedClass class name to create a instance
   */
  public void setSelectedEClass(String emfAlias, String selectedClass) {
    alias2Item.get(emfAlias).containerClassName = selectedClass;
  }

  /**
   * 
   * @param emfAlias
   * @return list of EClass names
   */
  public List<String> getEClasses(String emfAlias) {
    return EcoreUtilities.getEMFClassesFromEObject(alias2Item.get(emfAlias).modelRoot);
  }

  public Set<String> getAliases() {
    return alias2Item.keySet();
  }

  /**
   * Real job
   * 
   * @throws TraceException
   */
  public boolean run() throws TraceException {
    state = RUNNING;
    for (String alias : alias2Item.keySet()) {
      EObject eObject = alias2Item.get(alias).modelRoot;
      if (eObject instanceof EPackage) {
        EPackage ePackage = (EPackage) eObject;
        final String selectedClass = alias2Item.get(alias).containerClassName;
        EClass refClass = findEClass(alias, selectedClass);
        if (refClass != null) {
          EObject container = ePackage.getEFactoryInstance().create(refClass);
          alias2Item.get(alias).container = container;
        }
      }
    }
    createEClassesFromAtoms();
    createEReferencesFromSigs();
    state = FINISHED;
    return true;
  }

  private void createEReferencesFromSigs() throws TraceException {
    for (Sig sig : answer.getAllReachableSigs()) {
      for (Field field : sig.getFields()) {
        final String relName = field.label;
        for (A4Tuple a4Tuple : answer.eval(field)) {
          String fromAtom = a4Tuple.atom(0);
          String toAtom = a4Tuple.atom(1);
          createEReferenceBySigName(relName, fromAtom, toAtom);
        }
      }
    }
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  private void createEReferenceBySigName(String relName, String fromAtom, String toAtom)
      throws TraceException {
    EObject sourceAtom = atom2EClass.get(fromAtom);
    EObject targetAtom = atom2EClass.get(toAtom);
    RelationTrace relTrace = TraceRepo.get().getRelationTraceByRelationName(relName);
    if (relTrace != null) {
      for (EReference eReference : sourceAtom.eClass().getEAllReferences()) {
        if (eReference.getName().equals(relTrace.getReferenceName())) {
          if (eReference.isMany()) {
            ((List) sourceAtom.eGet(eReference)).add(targetAtom);
          } else {
            sourceAtom.eSet(eReference, targetAtom);
          }
          break;
        }
      }
    } else {
      closeWizard();
      throw new TraceException("No trace has been found for the relation: " + relName);
    }
  }

  private void createEClassesFromAtoms() throws TraceException {
    Iterator<ExprVar> it = answer.getAllAtoms().iterator();
    while (it.hasNext()) {
      ExprVar atom = it.next();
      String sigName = atom.label.substring(0, atom.label.indexOf("$"));
      SigTrace sigTrace = TraceRepo.get().getSigTraceByName(sigName);
      if (sigTrace != null) {
        EClass refClass = findEClass(sigTrace.getAlias(), sigTrace.getClassName());
        EObject atomObject = refClass.getEPackage().getEFactoryInstance().create(refClass);
        eSetAttributeByName(atomObject, "name", atom.label);
        putToContainer(alias2Item.get(sigTrace.getAlias()).container, atomObject);
        atom2EClass.put(atom.label, atomObject);
      } else {
        closeWizard();
        throw new TraceException("There is no trace for the sig: " + sigName);
      }
    }
  }

  /**
   * Puts given dynamic EObject to corresponding container
   * 
   * @param container
   * @param eObject
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public void putToContainer(EObject container, EObject eObject) {
    for (EReference eReference : container.eClass().getEAllReferences()) {
      if (eReference.getEReferenceType().getName().equals(eObject.eClass().getName())) {
        ((List) container.eGet(eReference)).add(eObject);
        break;
      }
    }
  }

  /**
   * 
   * @param eObject object to be set
   * @param name reference name
   * @param newVal new value
   */
  public void eSetAttributeByName(EObject eObject, String name, Object newVal) {
    for (EAttribute eAttribute : eObject.eClass().getEAllAttributes()) {
      if (eAttribute.getName().equals(name)) {
        eObject.eSet(eAttribute, newVal);
        break;
      }
    }
  }

  /**
   * 
   * @param eObject object to be set
   * @param name reference name
   * @param newVal new value
   */
  public void eSetReferenceByName(EObject eObject, String name, Object newVal) {
    for (EReference eReference : eObject.eClass().getEAllReferences()) {
      if (eReference.getName().equals(name)) {
        eObject.eSet(eReference, newVal);
        break;
      }
    }
  }

  /**
   * 
   * @param alias to find model root package
   * @param selectedClass class name to be find
   * @return
   */
  private EClass findEClass(String alias, String selectedClass) {
    EObject root = alias2Item.get(alias).modelRoot;
    for (EObject object : root.eContents()) {
      if (object instanceof EClass && ((EClass) object).getName().equals(selectedClass)) {
        return (EClass) object;
      }
    }
    return null;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public void saveResource(String alias) {
    ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",
        new XMLResourceFactoryImpl());
    Resource resource =
        resourceSet.createResource(URI.createFileURI(alias2Item.get(alias).saveLocation));
    resource.getContents().add(alias2Item.get(alias).container);

    XMLSave.XMLTypeInfo typeInfo = new XMLSave.XMLTypeInfo() {

      @Override
      public boolean shouldSaveType(EClass objectType, EClass featureType,
          EStructuralFeature feature) {
        return false;
      }

      @Override
      public boolean shouldSaveType(EClass objectType, EClassifier featureType,
          EStructuralFeature feature) {
        return false;
      }
    };

    Map options = new HashMap();
    options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
    options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, typeInfo);
    try {
      resource.save(options);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setAnswer(A4Solution answer) {
    this.answer = answer;
  }

  public A4Solution getAnswer() {
    return answer;
  }

  public void onException(TraceException e) {
    final MessageDialog warningdialog = new MessageDialog(null, "Alloy Example To EMF", null,
        e.getMessage(), MessageDialog.WARNING, new String[] {"OK"}, 0);
    warningdialog.open();
  }

  public void setSaveLocation(String alias, String selectedPath) {
    alias2Item.get(alias).saveLocation = selectedPath;
  }

  public boolean isAllLocationsSelected() {
    for (AlloyToEMFItem alloyToEMFItem : alias2Item.values()) {
      if (alloyToEMFItem.saveLocation == null)
        return false;
    }
    return true;
  }

  public boolean performFinish(boolean appendChecked) {
    for (String alias : alias2Item.keySet()) {
      saveResource(alias);
    }
    if (appendChecked) {
      appendNewFilesToAlloyFile();
    }
    return true;
  }

  private void appendNewFilesToAlloyFile() {
    // TODO Append new files

  }

}
