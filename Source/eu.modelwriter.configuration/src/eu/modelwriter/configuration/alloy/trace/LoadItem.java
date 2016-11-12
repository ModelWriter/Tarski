package eu.modelwriter.configuration.alloy.trace;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.configuration.internal.Utilities;

public class LoadItem {
  /**
   * alias from -- loadAlias
   */
  private String alias;
  /**
   * Paths from -- loadModel & -- loadInstace
   */
  private IFile modelFile, instanceFile;
  /**
   * Root EObjects
   */
  private EObject modelRoot = null, instanceRoot = null;

  private Resource instanceResource = null;

  private Map<String, EClass> allEClasses;

  public LoadItem(String alias, String modelFilePath, String instanceFilePath)
      throws TraceException, NullPointerException {
    this.alias = alias;
    allEClasses = new HashMap<>();
    try {
      modelFile = Utilities.getIFileFromPath(modelFilePath);
      modelRoot = EcoreUtilities.getRootObject(modelFile.getFullPath().toString());
    } catch (IOException | IllegalArgumentException e) {
      System.err.println("Tarski: EMF Model file can't loaded, load alias: " + alias);
    }
    try {
      instanceFile = Utilities.getIFileFromPath(instanceFilePath);
      instanceResource = EcoreUtilities.loadInstanceRoot(instanceFile.getFullPath().toString());
      instanceRoot = instanceResource.getContents().get(0);
      for (Object pack : instanceResource.getResourceSet().getPackageRegistry().values()) {
        loadEClasses((EPackage) pack);
      }
    } catch (IOException | IllegalArgumentException e) {
      System.err.println("Tarski: EMF Instance file can't loaded, load alias: " + alias);
    }

    if (modelRoot == null && instanceRoot == null) {
      throw new TraceException("Both model and instace files can't loaded for alias " + alias);
    }
  }


  private void loadEClasses(EPackage packageee) {
    for (EClassifier classifier : packageee.getEClassifiers()) {
      allEClasses.put(classifier.getName(), (EClass) classifier);
    }
    for (EPackage subPackage : packageee.getESubpackages()) {
      loadEClasses(subPackage);
    }
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public IFile getModelFile() {
    return modelFile;
  }

  public void setModelFile(IFile modelFile) {
    this.modelFile = modelFile;
  }

  public IFile getInstanceFile() {
    return instanceFile;
  }

  public void setInstanceFile(IFile instanceFile) {
    this.instanceFile = instanceFile;
  }

  public EObject getModelRoot() {
    return modelRoot;
  }

  public void setModelRoot(EObject modelRoot) {
    this.modelRoot = modelRoot;
  }

  public EObject getInstanceRoot() {
    return instanceRoot;
  }

  public void setInstanceRoot(EObject instanceRoot) {
    this.instanceRoot = instanceRoot;
  }

  public Map<String, EClass> getAllEClasses() {
    return allEClasses;
  }

  public EClass getEClass(String eClassName) {
    return allEClasses.get(eClassName);
  }

}
