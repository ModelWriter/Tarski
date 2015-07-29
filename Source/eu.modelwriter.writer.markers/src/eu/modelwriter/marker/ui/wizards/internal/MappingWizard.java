package eu.modelwriter.marker.ui.wizards.internal;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.views.TargetView;

public class MappingWizard extends Wizard {

  public MarkerMatchPage page;
  public ArrayList<MarkElement> targetMarkElements;
  public ArrayList<MarkElement> sourceMarkElements;
  public static IMarker sourceMarker;
  public static ArrayList<MarkElement> checkTargetMarkElements;

  public MappingWizard(IMarker sourceMarker) {
    super();
    MappingWizard.sourceMarker = sourceMarker;
    targetMarkElements = new ArrayList<MarkElement>();
    sourceMarkElements = new ArrayList<MarkElement>();
    checkTargetMarkElements = new ArrayList<MarkElement>();
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
    Object[] object = checkTargetMarkElements.toArray();
    ArrayList<Object> checkedElements = new ArrayList<>();

    for (Object object2 : object) {
      try {
        if (object2 instanceof MarkElement) {
          MarkElement markObject = (MarkElement) object2;
          IMarker markedObject = MarkElement.getMarker(markObject);
          if (markedObject.getAttribute(MarkerFactory.LEADER_ID) != null) {
            checkedElements.addAll(MarkerFactory.findMarkersByGroupId(markedObject.getResource(),
                markedObject.getAttribute(MarkerFactory.GROUP_ID).toString()));
          } else {
            checkedElements.add(markedObject);
          }
        }
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    object = checkedElements.toArray();


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
      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
      TargetView.setColumns(targetMarkElements);
    } catch (PartInitException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }

}
