package eu.modelwriter.configuration.emf2alloy;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
import eu.modelwriter.configuration.alloy.trace.TraceRepo;
import eu.modelwriter.configuration.alloy2emf.AlloyToEMF;
import eu.modelwriter.configuration.converter.AbstractConverter;
import eu.modelwriter.configuration.converter.ConverterWizardDialog;
import eu.modelwriter.configuration.internal.EcoreUtilities;

public class EMFToAlloy extends AbstractConverter {

  public final int RUNNING = 1, NOT_STARTED = 0, FINISHED = 2;
  public int state = NOT_STARTED;

  private IFile ecoreFile = null;
  private EObject ecoreRoot = null;
  private StringBuilder builder;
  private String saveLocation = null;
  private String alias = null;
  private String containerClassName;
  private boolean ignoreContainer;
  private boolean startEmfInstanceGeneration;
  private ConverterWizardDialog dialog;
  private EClass containerClass = null;
  private List<String> facts = new ArrayList<>();
  private int intPower = 1;
  private HashMap<String, Integer> sig2UpperBound = new HashMap<>();

  public EMFToAlloy(IFile ecoreFile) {
    this.ecoreFile = ecoreFile;
  }

  public void start() throws IOException {
    try {
      ecoreRoot = EcoreUtilities.getRootObject(ecoreFile.getFullPath().toOSString());
    } catch (IOException e) {
      e.printStackTrace();
      throw new IOException("Error while loading Ecore file.");
    }
    builder = new StringBuilder();
    dialog = new ConverterWizardDialog(null, new EMFToAlloyWizard(this, "EMF to Alloy"));
    dialog.open();
  }

  public void run() {
    state = RUNNING;
    if (ecoreRoot != null) {
      appendModuleAndLoad(alias);
      for (EObject eObject : ecoreRoot.eContents()) {
        if (eObject instanceof EClass) {
          appendSig(alias, (EClass) eObject);
        }
      }
      appendFacts();
      appendPredAndRun();
    }
    state = FINISHED;
  }

  private void appendFacts() {
    for (String fact : facts) {
      builder.append("fact {\n");
      builder.append("\t");
      builder.append(fact);
      builder.append("\n}\n\n");
    }
  }

  private void appendPredAndRun() {
    builder.append("pred show{}\n");
    builder.append("run show");
    if (intPower > 1) {
      builder.append(" for " + (intPower + 1) + " Int\n");
    } else {
      builder.append("\n");
    }
  }

  private void appendModuleAndLoad(String alias) {
    builder.append("module " + getFileName() + "\n\n");
    builder.append("-- loadAlias@" + alias);
    builder.append("\n");
    builder.append("-- loadModel@" + ecoreFile.getFullPath().toOSString());
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
      if (eReference.isContainment()) {
        facts.add("all " + "x" + ":" + eReference.getEType().getName() + " | one "
            + eClass.getName() + "<:(x" + ".~" + eReference.getName() + ")");
      }

      // append trace
      builder.append(
          "\t-- trace@" + alias + "." + eClass.getName() + "." + eReference.getName() + "\n");

      String multiplicity = getMultiplicity(eReference);
      if (multiplicity.isEmpty()) {
        multiplicity = "set ";
        facts.add("all x:" + eReference.getEType().getName() + " | #x." + eReference.getName()
            + " > " + eReference.getLowerBound() + " and  #x." + eReference.getName() + " < "
            + eReference.getUpperBound());
        updateInt(eReference.getUpperBound());
      }

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
      intPower = upperBound == 0 ? 0 : 32 - Integer.numberOfLeadingZeros(upperBound - 1);
    }
  }

  private EClass findContainer(String className) {
    for (EObject eObject : ecoreRoot.eContents()) {
      if (eObject instanceof EClass) {
        EClass clas = (EClass) eObject;
        if (clas.getName().equals(className))
          return clas;
      }
    }
    return null;
  }

  private EReference getRefToContainer(EClass eClass) {
    for (EReference eReference : containerClass.getEAllReferences()) {
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
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveLocation))) {
      final int aLength = builder.length();
      final int aChunk = 1024;// 1 kb buffer to read data from
      final char[] aChars = new char[aChunk];

      for (int aPosStart = 0; aPosStart < aLength; aPosStart += aChunk) {
        final int aPosEnd = Math.min(aPosStart + aChunk, aLength);
        builder.getChars(aPosStart, aPosEnd, aChars, 0); // Create no new buffer
        bw.write(aChars, 0, aPosEnd - aPosStart);// This is faster than just copying one byte at the
                                                 // time
      }
      bw.flush();

      if (startEmfInstanceGeneration) {
        closeWizard();
        TraceRepo.get().loadSpec(saveLocation);
        AlloyToEMF alloyToEMF = new AlloyToEMF(saveLocation);
        alloyToEMF.start();
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (TraceException e) {
      e.printStackTrace();
    }
  }

  private void closeWizard() {
    // dialog.close();
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
    containerClass = findContainer(selectedClass);
  }

  public void setEmfInstanceStarter(boolean selection) {
    startEmfInstanceGeneration = selection;
  }

  public void reset() {
    state = NOT_STARTED;

  }

  public void updateBounds(String sigName, Object lowerVal, Object upperVal) {
    sig2UpperBound.put(sigName, (Integer) upperVal);
  }

  @Override
  public void onException(Exception e) {

  }
}
