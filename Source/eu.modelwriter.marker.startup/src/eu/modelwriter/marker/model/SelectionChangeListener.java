package eu.modelwriter.marker.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerUpdater;
import eu.modelwriter.marker.xml.XMLDOMHelper;

public class SelectionChangeListener implements ISelectionChangedListener {

  private static SelectionChangeListener listener;

  public static IMarker preMarker = null;
  public static ITreeSelection preSelection = null;
  private IFile eFile;

  public void seteFile(IFile eFile) {
    this.eFile = eFile;
  }

  public SelectionChangeListener(IFile eFile) {
    this.eFile = eFile;
  }

  public static SelectionChangeListener getInstance(IFile eFile) {
    if (listener == null)
      listener = new SelectionChangeListener(eFile);
    else
      listener.seteFile(eFile);
    return listener;
  }

  @Override
  public void selectionChanged(SelectionChangedEvent event) {
    if (preMarker != null && preMarker.exists()) {
      try {
        if (event.getSelection().isEmpty()) {
          preMarker.delete();
        } else {
          preMarker.setAttribute("uri",
              EcoreUtil.getURI((ENamedElement) preSelection.getFirstElement()).toString());

          String xpath = XMLDOMHelper.findNodeAndGetXPath(
              ((ENamedElement) preSelection.getFirstElement()).getName(),
              eFile.getLocation().toFile().getAbsolutePath());
          preMarker.setAttribute("xpath", xpath);

          preMarker.setAttribute(IMarker.TEXT,
              ((ENamedElement) preSelection.getFirstElement()).getName());
          preMarker.setAttribute(IMarker.MESSAGE,
              ((ENamedElement) preSelection.getFirstElement()).getName());
          MarkerUpdater.updateTargets(preMarker);
          MarkerUpdater.updateSources(preMarker);
          preMarker = null;
          preSelection = null;
        }
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    if (preSelection == null || preSelection.getFirstElement() instanceof ENamedElement) {
      preSelection = (ITreeSelection) event.getSelection();
      preMarker =
          MarkerFactory.findMarkerByTreeSelection((ITreeSelection) event.getSelection(), eFile);
    } else {
      preSelection = (ITreeSelection) event.getSelection();
    }

  }

}
