package eu.modelwriter.marker.model;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.ui.part.PluginTransfer;
import org.eclipse.ui.part.PluginTransferData;

/**
 * A drag listener for the readme editor's content outline page. Allows dragging of content segments
 * into views that support the <code>TextTransfer</code> or <code>PluginTransfer</code> transfer
 * types.
 */
public class EcoreEditorDragListener extends DragSourceAdapter {
  private EcoreEditor editor;

  /**
   * Creates a new drag listener for the given page.
   */
  public EcoreEditorDragListener(EcoreEditor editor) {
    this.editor = editor;
  }

  /*
   * (non-Javadoc) Method declared on DragSourceListener
   */
  public void dragSetData(DragSourceEvent event) {
    if (PluginTransfer.getInstance().isSupportedType(event.dataType)) {
      byte[] segmentData = getSegmentText().getBytes();
      event.data = new PluginTransferData(Ecore2TextEditorDropActionDelegate.ID, segmentData);
      return;
    }
    if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
      event.data = getSegmentText();
      return;
    }
  }

  /**
   * Returns the text of the currently selected readme segment.
   */
  private String getSegmentText() {
    StringBuffer result = new StringBuffer();
    ISelection selection = editor.getSelection();
    if (selection instanceof ITreeSelection) {
      Object[] selected = ((ITreeSelection) selection).toArray();
      result.append("\n"); //$NON-NLS-1$
      for (int i = 0; i < selected.length; i++) {
        if (selected[i] instanceof ENamedElement) {
          result.append(((ENamedElement) selected[i]).getName());
          result.append("\n"); //$NON-NLS-1$
        }
      }
    }
    return result.toString();
  }
}
