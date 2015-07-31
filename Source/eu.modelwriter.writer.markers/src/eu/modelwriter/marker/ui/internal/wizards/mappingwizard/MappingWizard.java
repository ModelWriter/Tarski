package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.MarkerUtilities;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.views.TargetView;

public class MappingWizard extends Wizard {

  public MarkerMatchPage page;
  public ArrayList<MarkElement> targetElementsOfSelected;
  public ArrayList<MarkElement> sourceElementsOfSelected;
  public static IMarker selectedMarker;
  public ArrayList<MarkElement> beforeCheckedElements;

  public MappingWizard(IMarker selectedMarker) {
    super();
    MappingWizard.selectedMarker = selectedMarker;
    targetElementsOfSelected = new ArrayList<MarkElement>();
    sourceElementsOfSelected = new ArrayList<MarkElement>();
    beforeCheckedElements = new ArrayList<MarkElement>();
    setNeedsProgressMonitor(true);
    try {
      if (selectedMarker.getAttribute(MarkElement.getTargetAttributeName()) != null)
        beforeCheckedElements = Serialization.getInstance().fromString(
            (String) (selectedMarker).getAttribute(MarkElement.getTargetAttributeName()));
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

    page = new MarkerMatchPage(beforeCheckedElements);
    super.addPages();
    this.addPage(page);
  }

  @Override
  public boolean performFinish() {
    try {
      if (selectedMarker.getAttribute(MarkElement.getTargetAttributeName()) != null) {

        targetElementsOfSelected = Serialization.getInstance().fromString(
            (String) (selectedMarker).getAttribute(MarkElement.getTargetAttributeName()));
      }
      for (MarkElement checkedElement : MarkerMatchPage.checkedElements) {
        if (beforeCheckedElements.contains(checkedElement)) {
          continue;
        } else {
          if (MarkElement.getMarker(checkedElement).getAttribute(MarkerFactory.LEADER_ID) != null) {
            List<IMarker> listOfGroupMarkers = MarkerFactory.findMarkersByGroupId(
                MarkElement.getMarker(checkedElement).getResource(), (String) MarkElement
                    .getMarker(checkedElement).getAttribute(MarkerFactory.GROUP_ID));
            //TODO list of group markers in tum elemanlarinin source larina secileni ekle
            //TODO secilenin targetlarina da bu elemanlari ekle.
          } else {

          }
          targetElementsOfSelected.add(checkedElement);

          ArrayList<MarkElement> sourceElementsOfCheckedElement = new ArrayList<MarkElement>();
          if (MarkElement.getMarker(checkedElement)
              .getAttribute(MarkElement.getSourceAttributeName()) != null) {

            sourceElementsOfCheckedElement =
                Serialization.getInstance().fromString((String) MarkElement
                    .getMarker(checkedElement).getAttribute(MarkElement.getSourceAttributeName()));
          }

          sourceElementsOfCheckedElement.add(new MarkElement(selectedMarker));
          MarkElement.getMarker(checkedElement).setAttribute(MarkElement.getSourceAttributeName(),
              Serialization.getInstance().toString(sourceElementsOfCheckedElement));
        }
      }

      for (MarkElement beforeElement : beforeCheckedElements) {
        if (MarkerMatchPage.checkedElements.contains(beforeElement)) {
          continue;
        } else {
          Iterator<MarkElement> iter = targetElementsOfSelected.iterator();
          while (iter.hasNext()) {
            MarkElement markElement = (MarkElement) iter.next();
            if (markElement.getId().equals(beforeElement.getId())) {
              iter.remove();
              break;
            }
          }

          ArrayList<MarkElement> sourceElementsOfBeforeElement = new ArrayList<MarkElement>();
          if (MarkElement.getMarker(beforeElement)
              .getAttribute(MarkElement.getSourceAttributeName()) != null) {
            sourceElementsOfBeforeElement =
                Serialization.getInstance().fromString((String) MarkElement.getMarker(beforeElement)
                    .getAttribute(MarkElement.getSourceAttributeName()));
            Iterator<MarkElement> iter2 = sourceElementsOfBeforeElement.iterator();
            while (iter2.hasNext()) {
              MarkElement markElement = (MarkElement) iter2.next();
              if (markElement.getId().equals(selectedMarker.getAttribute(IMarker.SOURCE_ID))) {
                iter2.remove();
                break;
              }
            }
            MarkElement.getMarker(beforeElement).setAttribute(MarkElement.getSourceAttributeName(),
                Serialization.getInstance().toString(sourceElementsOfBeforeElement));
          }
        }
      }
      selectedMarker.setAttribute(MarkElement.getTargetAttributeName(),
          Serialization.getInstance().toString(targetElementsOfSelected));
    } catch (ClassNotFoundException | IOException | CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
      TargetView.setColumns(targetElementsOfSelected);
    } catch (PartInitException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      convertToMappingMarker();
    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return true;
  }

  public void convertToMappingMarker() throws CoreException {
    if (selectedMarker.getType().equals(MarkerFactory.MARKER_MARKING)) {
      Map<String, Object> attributes = selectedMarker.getAttributes();
      IResource res = selectedMarker.getResource();
      MarkerFactory.removeAnnotation(selectedMarker, Activator.getEditor());
      selectedMarker.delete();
      MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MAPPING);
      IMarker newMarker =
          MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
      MarkerFactory.addAnnotation(newMarker, Activator.getEditor(),
          MarkerFactory.ANNOTATION_MAPPING);
      // MarkerUtilities.createMarker(sourceMarker.getResource(), sourceMarker.getAttributes(),
      // MarkerFactory.MARKER_MAPPING);
      // // MarkerFactory.removeAnnotation(sourceMarker, Activator.getEditor());
      // MarkerFactory.addMapAnnotation(sourceMarker, Activator.getEditor());
      // sourceMarker.delete();
    } else if (selectedMarker.getType().equals(MarkerFactory.MARKER_MAPPING)) {
      if (targetElementsOfSelected.size() == 0) {
        Map<String, Object> attributes = selectedMarker.getAttributes();
        IResource res = selectedMarker.getResource();
        MarkerFactory.removeAnnotation(selectedMarker, Activator.getEditor());
        selectedMarker.delete();
        MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MARKING);
        IMarker newMarker =
            MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
        MarkerFactory.addAnnotation(newMarker, Activator.getEditor(),
            MarkerFactory.ANNOTATION_MARKING);
        // MarkerUtilities.createMarker(sourceMarker.getResource(), sourceMarker.getAttributes(),
        // MarkerFactory.MARKER_MARKING);
        // // MarkerFactory.removeAnnotation(sourceMarker, Activator.getEditor());
        // MarkerFactory.addAnnotation(sourceMarker, Activator.getEditor());
        // sourceMarker.delete();
      }
    }
  }
}
