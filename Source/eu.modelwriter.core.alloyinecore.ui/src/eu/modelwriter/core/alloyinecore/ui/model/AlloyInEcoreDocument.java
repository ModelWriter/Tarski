package eu.modelwriter.core.alloyinecore.ui.model;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.IFileEditorInput;

import eu.modelwriter.configuration.internal.EcoreUtilities;

public class AlloyInEcoreDocument extends Document {

  public static final String EDITOR_ID = "eu.modelwriter.core.alloyinecore.ui.editor";
  private EObject ecoreRoot;

  public AlloyInEcoreDocument() {
    super();
  }

  public AlloyInEcoreDocument(Object element) {
    if (element instanceof IFileEditorInput) {
      IFileEditorInput input = (IFileEditorInput) element;
      try {
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

  public EObject getEcoreRoot() {
    return ecoreRoot;
  }

  public boolean saveInEcore() {
    try {
      ecoreRoot.eResource().save(null);
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

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
