package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.AbstractTextEditor;

public class AlloyInEcoreEditor extends AbstractTextEditor {

  private ColorManager colorManager;

  public AlloyInEcoreEditor() {
    super();
    colorManager = new ColorManager();
    setSourceViewerConfiguration(new ViewerConfiguration(colorManager));
    setDocumentProvider(new AlloyInEcoreDocumentProvider());
  }

  @Override
  public IEditorInput getEditorInput() {
    return super.getEditorInput();
  }

  @Override
  public void dispose() {
    colorManager.dispose();
    super.dispose();
  }

  @Override
  protected IVerticalRuler createVerticalRuler() {
    // TODO Auto-generated method stub
    return super.createVerticalRuler();
  }

  // @Override
  // protected IAnnotationAccess createAnnotationAccess() {
  // return null;
  // }
  //
  // @Override
  // protected IAnnotationAccess getAnnotationAccess() {
  // return null;
  // }
  //
  // @Override
  // protected IOverviewRuler createOverviewRuler(ISharedTextColors sharedColors) {
  // return null; // super.createOverviewRuler(sharedColors);
  // }

}
