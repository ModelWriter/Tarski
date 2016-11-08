package eu.modelwriter.configuration.emf2alloy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.alloy2emf.AlloyToEMF;
import eu.modelwriter.configuration.generation.AbstractGeneration;
import eu.modelwriter.configuration.generation.GenerationWizardDialog;
import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.configuration.internal.Utilities;

public class EMFToAlloy extends AbstractGeneration {

  class ContainmentFact {
    String sig;
    char shortName;
    List<String> conRels = new ArrayList<>();

    public ContainmentFact(String sig) {
      this.sig = sig;
      shortName = sig.toLowerCase().charAt(0);
    }

    public void addConRel(String domainName, String relName) {
      conRels.add(domainName + "<:(" + shortName + ".~" + relName + ")");
    }

    public String getFact() {
      String result = "";
      result += "all " + shortName + ":" + sig + " | ";
      result += "one " + getUnionSet(conRels);
      return result;
    }

    public String getUnionSet(List<String> rels) {
      String result = "(";
      for (Iterator<String> it = rels.iterator(); it.hasNext();) {
        result += it.next();
        if (it.hasNext())
          result += " + ";
      }
      result += ")";
      return result;
    }
  }

  private IFile ecoreFile = null;
  private EObject ecoreRoot = null;
  private StringBuilder builder;
  private String saveLocation = null;
  private String alias = null;
  private String containerClassName;
  private boolean ignoreContainer;
  private boolean startEmfInstanceGeneration;
  private GenerationWizardDialog dialog;
  private EClass containerClass = null;
  private List<String> facts = new ArrayList<>();
  private int intPower = 1;
  private HashMap<String, ContainmentFact> containmentFacts = new HashMap<>();

  public EMFToAlloy(IFile ecoreFile) {
    this.ecoreFile = ecoreFile;
  }

  public void start() throws IOException {
    try {
      ecoreRoot = EcoreUtilities.getRootObject(ecoreFile.getFullPath().toString());
    } catch (IOException e) {
      e.printStackTrace();
      throw new IOException("Error while loading Ecore file.");
    }
    builder = new StringBuilder();
    dialog = new GenerationWizardDialog(null, new EMFToAlloyWizard(this, "EMF to Alloy"));
    dialog.open();
  }

  public void run() {
    setState(RUNNING);
    if (ecoreRoot != null) {
      appendModuleAndLoad(alias);
      List<EClass> contents = EcoreUtilities.getAllEClass(ecoreRoot);
      for (EClass eClass : contents) {
        appendSig(alias, eClass);
      }
      appendFacts();
      appendPredAndRun();
    }
    setState(FINISHED);
  }

  public String getModelFilePath() {
    return ecoreFile.getLocation().toString();
  }

  private void appendFacts() {
    for (ContainmentFact fact : containmentFacts.values()) {
      builder.append("fact {\n");
      builder.append("\t" + fact.getFact());
      builder.append("\n}\n\n");
    }
    for (String fact : facts) {
      builder.append("fact {\n");
      builder.append("\t" + fact);
      builder.append("\n}\n\n");
    }
  }

  private void appendPredAndRun() {
    builder.append("pred show{}\n");
    builder.append("run show");

    if (intPower > 1)
      builder.append(" for " + (intPower + 1) + " Int");

    builder.append("\n");
  }

  private void appendModuleAndLoad(String alias) {
    builder.append("module " + getFileName() + "\n\n");
    builder.append("-- loadAlias@" + alias);
    builder.append("\n");
    builder.append("-- loadModel@" + ecoreFile.getFullPath().toString());
    builder.append("\n\n");
  }

  private void appendSig(String alias, EClass eClass) {
    if (eClass.getName().equals(containerClassName) && ignoreContainer)
      return;

    // append sig trace
    builder.append("-- trace@" + alias + "." + eClass.getName() + "\n");

    EReference containerRef = getRefToContainer(eClass);
    if (containerRef != null) {
      String mul = getMultiplicity(containerRef);
      if ("set ".equals(mul))
        mul = "";
      builder.append(mul);
    }

    // append sig
    if (eClass.isAbstract()) {
      builder.append("abstract sig " + eClass.getName());
    } else {
      builder.append("sig " + eClass.getName());
    }

    // extends parts
    if (!eClass.getESuperTypes().isEmpty()) {
      builder.append(" extends ");
    }
    for (Iterator<EClass> it = eClass.getESuperTypes().iterator(); it.hasNext();) {
      EClass superClass = it.next();
      builder.append(superClass.getName());
      if (it.hasNext())
        builder.append(", ");
    }
    builder.append(" {\n");

    // relations
    for (Iterator<EReference> iterator = eClass.getEReferences().iterator(); iterator.hasNext();) {
      EReference eReference = iterator.next();

      String sig = eReference.getEType().getName();
      if (eReference.isContainment()) {
        if (containmentFacts.get(sig) == null)
          containmentFacts.put(sig, new ContainmentFact(sig));
        containmentFacts.get(sig).addConRel(eClass.getName(), eReference.getName());
      }

      String multiplicity = getMultiplicity(eReference);
      if (multiplicity.isEmpty()) {
        multiplicity = "set ";
        char c = eClass.getName().toLowerCase().charAt(0);
        String fact = "all " + c + ":" + eClass.getName() + " | ";
        if (eReference.getLowerBound() != -1)
          fact += "#" + c + "." + eReference.getName() + " >= " + eReference.getLowerBound();
        if (eReference.getUpperBound() != -1) {
          fact += " and #" + c + "." + eReference.getName() + " <= " + eReference.getUpperBound();
        }
        facts.add(fact);
        updateInt(Math.max(eReference.getLowerBound(), eReference.getUpperBound()));
      }

      // append trace
      builder.append(
          "\t-- trace@" + alias + "." + eClass.getName() + "." + eReference.getName() + "\n");

      // append relation
      builder.append(
          "\t" + eReference.getName() + ": " + multiplicity + eReference.getEType().getName());
      if (iterator.hasNext())
        builder.append(",");
      builder.append("\n");
    }
    builder.append("}\n\n");
  }

  private void updateInt(int upperBound) {
    if (upperBound > Math.pow(2, intPower) - 1) {
      intPower = 32 - Integer.numberOfLeadingZeros(upperBound - 1);
    }
  }

  private EReference getRefToContainer(EClass eClass) {
    for (EReference eReference : containerClass.getEReferences()) {
      if (eReference.getEReferenceType().getName().equals(eClass.getName()))
        return eReference;
    }
    return null;
  }

  private String getMultiplicity(EReference eReference) {
    int l = eReference.getLowerBound();
    int u = eReference.getUpperBound();
    if (l == 0 && u == 1)
      return "lone ";
    if (l == 0 && u == -1)
      return "set ";
    if (l == 1 && u == 1)
      return "one ";
    if (l == 1 && u == -1)
      return "some ";

    return "";
  }

  public void save(String selectedPath) {
    saveLocation = selectedPath;
  }

  public boolean isSaveLocationSet() {
    return saveLocation != null;
  }

  public String getFileName() {
    return ecoreFile.getName().substring(0, ecoreFile.getName().indexOf("."));
  }

  public void performFinish() {
    try {
      Utilities.writeToFile(saveLocation, builder);

      if (startEmfInstanceGeneration) {
        hideWizard();
        TraceManager.get().loadSpec(saveLocation);
        AlloyToEMF alloyToEMF = new AlloyToEMF(saveLocation);
        alloyToEMF.start();
      }
    } catch (TraceException e) {
      e.printStackTrace();
    }
  }

  private void hideWizard() {
    dialog.getShell().setAlpha(0);
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getAlias() {
    return alias;
  }

  public EObject getEcoreRoot() {
    return ecoreRoot;
  }

  public void setContainerClass(String selectedClass, boolean ignore) {
    containerClassName = selectedClass;
    ignoreContainer = ignore;
    containerClass = EcoreUtilities.findEClass(ecoreRoot, selectedClass);
  }

  public void setEmfInstanceStarter(boolean selection) {
    startEmfInstanceGeneration = selection;
  }

  public void reset() {
    setState(NOT_STARTED);
  }

  @Override
  public void onException(Exception e) {

  }
}
