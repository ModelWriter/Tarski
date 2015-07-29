/**
 * 
 */
package eu.modelwriter.marker.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Ferhat Erata
 *
 */
public class MarkElement implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private static transient String targetAttributeName = "TARGET_MARKED_ELEMENT";
  private static transient String sourceAttributeName = "SOURCE_MARKED_ELEMENT";
  private static IMarker iMarker;

  public MarkElement(IMarker iMarker) {
    try {
      this.iMarker = iMarker;
      id = (String) iMarker.getAttribute(IMarker.SOURCE_ID);
      offset = (int) iMarker.getAttribute(IMarker.CHAR_START);
      length = (int) iMarker.getAttribute(IMarker.CHAR_END) - offset;
      message = (String) iMarker.getAttribute(IMarker.MESSAGE);
      linenumber = Integer.toString((int) iMarker.getAttribute(IMarker.LOCATION));
      path = iMarker.getResource().getFullPath().toString();

    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  private String id;

  private int offset;

  private int length;

  private String message;

  private String linenumber;

  public String getPath() {
    return path;
  }

  private String path;

  public String getId() {
    return id;
  }

  public int getOffset() {
    return offset;
  }

  public int getLength() {
    return length;
  }

  public String getMessage() {
    return message;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setLinenumber(String linenumber) {
    this.linenumber = linenumber;
  }

  public String getLinenumber() {
    return linenumber;
  }

  public static String getTargetAttributeName() {
    return targetAttributeName;
  }

  public static String getSourceAttributeName() {
    return sourceAttributeName;
  }

  // public boolean compareWith(IMarker compareWith) {
  // return this.id == Long.toString(compareWith.getId());
  // }

  public static IMarker getMarker(MarkElement markElement) {
    // IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new
    // Path(markElement.getPath()));
    //
    // ISelection selection =
    // PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    //
    // IEditorPart editor =
    // PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    //
    // IMarker marker = null;
    //
    // if (selection instanceof ITextSelection) {
    // TextSelection textSelection = (TextSelection) selection;
    //
    // marker = MarkerFactory.findMarkerByOffset(file, textSelection.getOffset());
    // } else if (selection instanceof ITreeSelection) {
    // try {
    // ITreeSelection treeSelection = (ITreeSelection) selection;
    // if (selection != null && editor instanceof EcoreEditor) {
    // if (treeSelection.getFirstElement() instanceof ENamedElement
    // && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
    // && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {
    //
    // URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());
    //
    // marker = MarkerFactory.findMarkersByUri(file, uri.toString());
    // } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
    // URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
    //
    // marker = MarkerFactory.findMarkersByUri(file, uri.toString());
    // }
    // }
    // } catch (CoreException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    return iMarker;
  }
}

