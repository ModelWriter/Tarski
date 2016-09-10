package eu.modelwriter.configuration.alloy2emf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.MessageDialog;

import edu.mit.csail.sdg.alloy4.ConstList;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprVar;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.Field;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Tuple;
import eu.modelwriter.configuration.alloy.trace.LoadItem;
import eu.modelwriter.configuration.alloy.trace.RelationTrace;
import eu.modelwriter.configuration.alloy.trace.SigTrace;
import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceRepo;
import eu.modelwriter.configuration.generation.AbstractGeneration;
import eu.modelwriter.configuration.generation.GenerationWizardDialog;
import eu.modelwriter.configuration.internal.AlloyExecuter;
import eu.modelwriter.configuration.internal.EcoreUtilities;


class AlloyToEMFItem {
  String saveLocation = null;
  String containerClassName;
  EObject container;
  EObject modelRoot;
}


public class AlloyToEMF extends AbstractGeneration {

  private final String alloyFilePath;
  private A4Solution solution = null;
  private AlloyToEMFWizard alloyToEMFWizard;
  private GenerationWizardDialog dialog;
  private AlloyExecuter alloyExecuter;

  private final HashMap<String, AlloyToEMFItem> alias2Item = new HashMap<>();
  private final HashMap<String, EObject> atom2EClass = new HashMap<>();

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

    try {
      alloyExecuter = new AlloyExecuter(alloyFilePath);
    } catch (Err e) {
      throw new TraceException(e.getMessage());
    }

    alloyToEMFWizard = new AlloyToEMFWizard(this, "Alloy To EMF");
    dialog = new GenerationWizardDialog(null, alloyToEMFWizard);
    dialog.open();
  }

  /**
   * 
   * @return list of executable commands
   */
  public ConstList<Command> getRunCommands() {
    return alloyExecuter.getRunCommands();
  }

  /**
   * Disposes wizard
   */
  public void closeWizard() {
    alloyToEMFWizard.performCancel();
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
    setState(RUNNING);
    atom2EClass.clear();

    for (String alias : alias2Item.keySet()) {
      EObject eObject = alias2Item.get(alias).modelRoot;
      if (eObject instanceof EPackage) {
        EPackage ePackage = (EPackage) eObject;
        final String selectedClass = alias2Item.get(alias).containerClassName;
        EClass refClass = EcoreUtilities.findEClass(alias2Item.get(alias).modelRoot, selectedClass);
        if (refClass != null) {
          EObject container = ePackage.getEFactoryInstance().create(refClass);
          alias2Item.get(alias).container = container;
        }
      }
    }
    createEClassesFromAtoms();
    createEReferencesFromSigs();
    setState(FINISHED);
    return true;
  }

  private void createEReferencesFromSigs() throws TraceException {
    for (Sig sig : solution.getAllReachableSigs()) {
      for (Field field : sig.getFields()) {
        final String relName = field.label;
        SigTrace sigTrace = TraceRepo.get().getSigTraceByName(sig.label.replace("this/", ""));
        RelationTrace relTrace =
            TraceRepo.get().getRelationTrace2(sigTrace.getClassName(), relName);
        if (relTrace != null) {
          String refName = relTrace.getReferenceName();
          for (A4Tuple a4Tuple : solution.eval(field)) {
            String fromAtom = a4Tuple.atom(0);
            String toAtom = a4Tuple.atom(1);
            createEReferenceByAtoms(refName, fromAtom, toAtom);
          }
        } else {
          closeWizard();
          throw new TraceException("No trace has been found for the relation: " + relName);
        }
      }
    }
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  private void createEReferenceByAtoms(String refName, String fromAtom, String toAtom)
      throws TraceException {
    EObject sourceAtom = atom2EClass.get(fromAtom);
    EObject targetAtom = atom2EClass.get(toAtom);
    for (EReference eReference : sourceAtom.eClass().getEAllReferences()) {
      if (eReference.getName().equals(refName)) {
        if (eReference.isMany()) {
          ((List) sourceAtom.eGet(eReference)).add(targetAtom);
        } else {
          sourceAtom.eSet(eReference, targetAtom);
        }
        break;
      }
    }
  }

  private void createEClassesFromAtoms() throws TraceException {
    Iterator<ExprVar> it = solution.getAllAtoms().iterator();
    while (it.hasNext()) {
      ExprVar atom = it.next();
      String sigName = atom.label.substring(0, atom.label.indexOf("$"));
      SigTrace sigTrace = TraceRepo.get().getSigTraceByName(sigName);
      if (sigTrace != null) {
        EClass refClass = EcoreUtilities.findEClass(alias2Item.get(sigTrace.getAlias()).modelRoot,
            sigTrace.getClassName());
        EObject atomObject = refClass.getEPackage().getEFactoryInstance().create(refClass);
        EcoreUtilities.eSetAttributeByName(atomObject, "name", atom.label);
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
        if (eReference.isMany())
          ((List) container.eGet(eReference)).add(eObject);
        else
          container.eSet(eReference, eObject);
        break;
      }
    }
  }

  public void setSolution(A4Solution solution) {
    this.solution = solution;
  }

  public A4Solution getSolution() {
    return solution;
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
    for (AlloyToEMFItem item : alias2Item.values()) {
      EcoreUtilities.saveResource(item.container, item.saveLocation);
    }
    if (appendChecked) {
      appendNewFilesToAlloyFile();
    }
    return true;
  }

  private void appendNewFilesToAlloyFile() {
    // TODO Append new files
  }

  public void resetRun() {
    atom2EClass.clear();
    setState(NOT_STARTED);
  }

  public boolean executeCommand(Command selection) {
    try {
      A4Solution sol = alloyExecuter.executeCommand(selection);
      if (sol != null) {
        solution = sol;
        return true;
      }
    } catch (Err e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public void onException(Exception e) {

  }

}
