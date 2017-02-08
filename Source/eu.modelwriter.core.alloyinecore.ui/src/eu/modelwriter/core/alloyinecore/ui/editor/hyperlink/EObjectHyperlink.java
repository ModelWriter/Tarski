package eu.modelwriter.core.alloyinecore.ui.editor.hyperlink;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;

import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;

public class EObjectHyperlink implements IHyperlink {

  private Region region;
  private EObject eObject;
  private AIEEditor editor;

  public EObjectHyperlink(int start, int stop, EObject eObject, AIEEditor editor) {
    this.eObject = eObject;
    this.editor = editor;
    region = new Region(start, stop - start + 1);
  }

  @Override
  public IRegion getHyperlinkRegion() {
    return region;
  }

  @Override
  public String getTypeLabel() {
    return "EObjectHyperlink";
  }

  @Override
  public String getHyperlinkText() {
    return "Open in Ecore Editor";
  }

  @Override
  public void open() {
    editor.openEcoreEditorAndReveal(eObject);
    // EcoreEditor ecoreEditor = editor.openEcoreEditor();
    // URI uri = EcoreUtil.getURI(eObject);
    // ecoreEditor.setSelection(new StructuredSelection(eObject));
  }

}
