package eu.modelwriter.core.alloyinecore.ui.model;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.ui.cs2as.mapping.CS2ASMapping;

public class AlloyInEcoreDocument extends Document {

  public static final String EDITOR_ID = "eu.modelwriter.core.alloyinecore.ui.editor";
  private EObject ecoreRoot;
  private IFile iFile;

  public AlloyInEcoreDocument() {
    super();
  }

  public AlloyInEcoreDocument(Object element) {
    if (element instanceof IFileEditorInput) {
      IFileEditorInput input = (IFileEditorInput) element;
      try {
        iFile = input.getFile();
        ecoreRoot = EcoreUtilities.getRootObject(input.getFile().getFullPath().toString());
        if (!refreshEditor()) {
          set("");
        }
      } catch (IOException e) {
        set("");
        e.printStackTrace();
      }
    }
  }


  /**
   * 
   * @return current ecore object
   */
  public EObject getEcoreRoot() {
    return ecoreRoot;
  }


  /**
   * Saves editor input to current ecore file.
   * 
   * @param overwrite
   * @param element
   * 
   * @return true if succeed.
   */
  public boolean saveInEcore(Object element, boolean overwrite) {
    if (overwrite) { // Save as
      if (element instanceof FileEditorInput) {
        CS2ASMapping.getInstance().parseAndSave(get(),
            ((FileEditorInput) element).getFile().getFullPath().toString());
      }
    } else { // Save
      CS2ASMapping.getInstance().parseAndSave(get(), iFile.getFullPath().toString());
    }
    return true;
  }

  /**
   * Refreshs the editor with current ecore file.
   * 
   * @return true if succeed.
   */
  public boolean refreshEditor() {
    if (ecoreRoot != null) {
      set(EcoreTranslator.translate((EPackage) ecoreRoot).toString());
      return true;
    } else
      return false;
  }

  @Override
  public void set(String text) {
    super.set(text);
  }
}
