package eu.modelwriter.marker.ui.wizards.internal;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.Serialization;
import eu.modelwriter.marker.ui.views.TargetView;

public class MappingWizard extends Wizard {

  public MarkerMatchPage page;
  public ArrayList<MarkElement> targetMarkElements;
  public ArrayList<MarkElement> sourceMarkElements;
  private IMarker sourceMarker;
  public static ArrayList<MarkElement> checkTargetMarkElements;

  public MappingWizard(IMarker sourceMarker) {
    super();
    this.sourceMarker = sourceMarker;
    targetMarkElements = new ArrayList<MarkElement>();
    sourceMarkElements = new ArrayList<MarkElement>();
    setNeedsProgressMonitor(true);
    try {
      if (sourceMarker.getAttribute(MarkElement.getTargetAttributeName()) != null)
        checkTargetMarkElements = Serialization.getInstance()
            .fromString((String) (sourceMarker).getAttribute(MarkElement.getTargetAttributeName()));
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public String getWindowTitle() {

    return "Mapping Markers";
  }

  @Override
  public void addPages() {

    page = new MarkerMatchPage();
    super.addPages();
    this.addPage(page);
  }

  @Override
  public boolean performFinish() {
    Object[] object = this.page.markTreeViewer.getCheckedElements();

    for (Object object2 : object) {
      if (object2 instanceof IMarker) {

        targetMarkElements.add(new MarkElement((IMarker) object2));

        try {
          if (((IMarker) object2).getAttribute(MarkElement.getSourceAttributeName()) == null) {
            sourceMarkElements.add(new MarkElement((IMarker) sourceMarker));
            ((IMarker) object2).setAttribute(MarkElement.getSourceAttributeName(),
                Serialization.getInstance().toString(sourceMarkElements));
            sourceMarkElements.clear();
          } else {
            sourceMarkElements = Serialization.getInstance().fromString(
                (String) ((IMarker) object2).getAttribute(MarkElement.getSourceAttributeName()));
            sourceMarkElements.add(new MarkElement((IMarker) sourceMarker));
            ((IMarker) object2).setAttribute(MarkElement.getSourceAttributeName(),
                Serialization.getInstance().toString(sourceMarkElements));
            sourceMarkElements.clear();
          }
        } catch (CoreException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (ClassNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

      }
    }
    try {
      sourceMarker.setAttribute(MarkElement.getTargetAttributeName(),
          Serialization.getInstance().toString(targetMarkElements));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
          .showView("eu.modelwriter.writer.markers.views.targetview");
      TargetView.setColumns(targetMarkElements);
    } catch (PartInitException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }

}
