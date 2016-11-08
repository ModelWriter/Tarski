package eu.modelwriter.configuration.alloy.trace;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;

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

  public LoadItem(String alias, String modelFilePath, String instanceFilePath)
      throws TraceException {
    this.alias = alias;
    try {
      modelFile = Utilities.getIFileFromPath(modelFilePath);
      modelRoot = EcoreUtilities.getRootObject(modelFile.getFullPath().toString());
    } catch (IOException | IllegalArgumentException e) {
      System.err.println("Tarski: EMF Model file can't loaded, load alias: " + alias);
    }
    try {
      instanceFile = Utilities.getIFileFromPath(instanceFilePath);
      instanceRoot = EcoreUtilities.getRootObject(instanceFile.getFullPath().toString());
    } catch (IOException | IllegalArgumentException e) {
      System.err.println("Tarski: EMF Instance file can't loaded, load alias: " + alias);
    }

    if (modelRoot == null && instanceRoot == null) {
      throw new TraceException("Both model and instace files can't loaded for alias " + alias);
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


}
