package eu.modelwriter.marker.model;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.part.IDropActionDelegate;

/**
 * Adapter for handling the dropping of readme segments into another plugin. In this case, we expect
 * the segments to be dropped onto <code>IFile</code> object, or an adapter that supports
 * <code>IFile</code>.
 */
public class Ecore2TextEditorDropActionDelegate implements IDropActionDelegate {
  public static final String ID = "eu.modelwriter.model.ecore2texteditordropaction"; //$NON-NLS-1$

  /**
   * (non-Javadoc) Method declared on IDropActionDelegate
   */
  public boolean run(Object source, Object target) {
    if (source instanceof byte[] && target instanceof IFile) {
      IFile file = (IFile) target;
      try {
        file.appendContents(new ByteArrayInputStream((byte[]) source), false, true, null);
        System.out.print("My notice"); //$NON-NLS-1$
      } catch (CoreException e) {
        System.out.println("Exception in Ecore drop adapter" + e.getStatus().getMessage()); //$NON-NLS-1$
        return false;
      }
      return true;
    }
    return false;
  }
}
