package eu.modelwriter.configuration.alloy.trace;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.configuration.internal.EditorUtilities;

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
  private EObject modelRoot, instanceRoot;

  public LoadItem(String alias, String modelFilePath, String instanceFilePath) throws IOException {
    this.alias = alias;
    modelFile = EditorUtilities.getIFileFromPath(modelFilePath);
    instanceFile = EditorUtilities.getIFileFromPath(instanceFilePath);
    modelRoot = EcoreUtilities.getRootObject(modelFilePath);
    instanceRoot = EcoreUtilities.getRootObject(instanceFilePath);
  }

  public LoadItem(String alias, IFile modelFile, IFile instanceFile) throws IOException {
    this.alias = alias;
    this.modelFile = modelFile;
    this.instanceFile = instanceFile;
    modelRoot = EcoreUtilities.getRootObject(modelFile.getFullPath().toOSString());
    instanceRoot = EcoreUtilities.getRootObject(instanceFile.getFullPath().toOSString());
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
