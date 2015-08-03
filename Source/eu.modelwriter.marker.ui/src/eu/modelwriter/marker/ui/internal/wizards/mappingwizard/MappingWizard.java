package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.MarkerUtilities;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.mappingview.TargetView;

public class MappingWizard extends Wizard {

  public MarkerMatchPage page;
  public ArrayList<MarkElement> targetElementsOfSelected;
  public ArrayList<MarkElement> sourceElementsOfSelected;
  public static IMarker selectedMarker;
  public ArrayList<MarkElement> beforeCheckedElements;
  public ArrayList<MarkElement> checkedElements;

  public MappingWizard(IMarker selectedMarker) {
    super();
    MappingWizard.selectedMarker = selectedMarker;
    sourceElementsOfSelected = new ArrayList<MarkElement>();
    beforeCheckedElements = new ArrayList<MarkElement>();
    setNeedsProgressMonitor(true);
    beforeCheckedElements = MarkElement.getTargetList(selectedMarker);
    checkedElements = new ArrayList<MarkElement>();

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

  // su an checked element leader ise zaten yapiyor, break bozmustu.
  // TODO olarak selected element leader ise ne yapilacak o belirlenmeli.
  @Override
  public boolean performFinish() {
    try {
      Object[] checkedObjects = MarkerMatchPage.markTreeViewer.getCheckedElements();
      for (int i = 0; i < checkedObjects.length; i++) {
        if (checkedObjects[i] instanceof IMarker) {
          checkedElements.add(new MarkElement((IMarker) checkedObjects[i]));
        }
      }
      targetElementsOfSelected = MarkElement.getTargetList(selectedMarker);

      for (MarkElement checkedElement : checkedElements) {
        if (beforeCheckedElements.contains(checkedElement)) {
          continue;
        } else {
          if (MarkElement.getiMarker(checkedElement)
              .getAttribute(MarkerFactory.LEADER_ID) != null) {

            List<IMarker> groupMarkersOfCheckedElement = MarkerFactory.findMarkersByGroupId(
                MarkElement.getiMarker(checkedElement).getResource(), (String) MarkElement
                    .getiMarker(checkedElement).getAttribute(MarkerFactory.GROUP_ID));

            Iterator<IMarker> groupMarkersIteratorOfCheckedElement =
                groupMarkersOfCheckedElement.iterator();

            while (groupMarkersIteratorOfCheckedElement.hasNext()) {
              IMarker nextCheckedGroupElement =
                  (IMarker) groupMarkersIteratorOfCheckedElement.next();
              ArrayList<MarkElement> sourcesOfGroupElement =
                  MarkElement.getSourceList(nextCheckedGroupElement);
              sourcesOfGroupElement.add(new MarkElement(selectedMarker));
              MarkElement.setSourceList(nextCheckedGroupElement, sourcesOfGroupElement);
            }
          } else {
            ArrayList<MarkElement> sourceElementsOfChecked =
                MarkElement.getSourceList(MarkElement.getiMarker(checkedElement));
            sourceElementsOfChecked.add(new MarkElement(selectedMarker));
            MarkElement.setSourceList(MarkElement.getiMarker(checkedElement),
                sourceElementsOfChecked);
          }

          if (selectedMarker.getAttribute(MarkerFactory.LEADER_ID) != null) {
            List<IMarker> groupMarkersOfSelectedElement =
                MarkerFactory.findMarkersByGroupId(selectedMarker.getResource(),
                    (String) selectedMarker.getAttribute(MarkerFactory.GROUP_ID));

            Iterator<IMarker> groupMarkersIteratorOfSelectedElement =
                groupMarkersOfSelectedElement.iterator();

            while (groupMarkersIteratorOfSelectedElement.hasNext()) {
              IMarker nextSelectedGroupElement =
                  (IMarker) groupMarkersIteratorOfSelectedElement.next();

              ArrayList<MarkElement> targetElementsOfNextSelected =
                  MarkElement.getTargetList(nextSelectedGroupElement);

              targetElementsOfNextSelected.add(checkedElement);
              MarkElement.setTargetList(nextSelectedGroupElement, targetElementsOfNextSelected);
            }
          } else {
            targetElementsOfSelected.add(checkedElement);
            MarkElement.setTargetList(selectedMarker, targetElementsOfSelected);
          }
        }
      }

      for (MarkElement beforeCheckedElement : beforeCheckedElements) {
        if (checkedElements.contains(beforeCheckedElement)) {
          continue;
        } else {
          if (MarkElement.getiMarker(beforeCheckedElement)
              .getAttribute(MarkerFactory.LEADER_ID) != null) {

            List<IMarker> groupMarkersOfBeforeCheckedElement = MarkerFactory.findMarkersByGroupId(
                MarkElement.getiMarker(beforeCheckedElement).getResource(), (String) MarkElement
                    .getiMarker(beforeCheckedElement).getAttribute(MarkerFactory.GROUP_ID));

            Iterator<IMarker> groupMarkersIteratorOfBeforeCheckedElement =
                groupMarkersOfBeforeCheckedElement.iterator();

            while (groupMarkersIteratorOfBeforeCheckedElement.hasNext()) {
              IMarker nextBeforeCheckedGroupElement =
                  (IMarker) groupMarkersIteratorOfBeforeCheckedElement.next();
              ArrayList<MarkElement> sourceElementsOfBeforeChecked =
                  MarkElement.getSourceList(nextBeforeCheckedGroupElement);

              Iterator<MarkElement> sourceIteratorOfBeforeCheckedGroupElement =
                  sourceElementsOfBeforeChecked.iterator();

              while (sourceIteratorOfBeforeCheckedGroupElement.hasNext()) {
                MarkElement sourceElementOfBeforeCheckedElement =
                    (MarkElement) sourceIteratorOfBeforeCheckedGroupElement.next();
                if (sourceElementOfBeforeCheckedElement.getId()
                    .equals((String) selectedMarker.getAttribute(IMarker.SOURCE_ID))) {
                  sourceIteratorOfBeforeCheckedGroupElement.remove();
                  break;
                }
              }

              MarkElement.setSourceList(nextBeforeCheckedGroupElement,
                  sourceElementsOfBeforeChecked);
            }
          } else {
            ArrayList<MarkElement> sourceElementsOfBeforeChecked =
                MarkElement.getSourceList(MarkElement.getiMarker(beforeCheckedElement));

            Iterator<MarkElement> sourceIteratorOfBeforeChecked =
                sourceElementsOfBeforeChecked.iterator();

            while (sourceIteratorOfBeforeChecked.hasNext()) {
              MarkElement sourceElementOfBeforeCheckedElement =
                  (MarkElement) sourceIteratorOfBeforeChecked.next();
              if (sourceElementOfBeforeCheckedElement.getId()
                  .equals((String) selectedMarker.getAttribute(IMarker.SOURCE_ID))) {
                sourceIteratorOfBeforeChecked.remove();
                break;
              }
            }
            MarkElement.setSourceList(MarkElement.getiMarker(beforeCheckedElement),
                sourceElementsOfBeforeChecked);
          }

          if (selectedMarker.getAttribute(MarkerFactory.LEADER_ID) != null) {
            List<IMarker> groupMarkersOfSelectedElement =
                MarkerFactory.findMarkersByGroupId(selectedMarker.getResource(),
                    (String) selectedMarker.getAttribute(MarkerFactory.GROUP_ID));

            Iterator<IMarker> groupMarkersIteratorOfSelectedElement =
                groupMarkersOfSelectedElement.iterator();

            while (groupMarkersIteratorOfSelectedElement.hasNext()) {
              IMarker nextSelectedGroupElement =
                  (IMarker) groupMarkersIteratorOfSelectedElement.next();

              ArrayList<MarkElement> targetElementsOfNextSelected =
                  MarkElement.getTargetList(nextSelectedGroupElement);

              Iterator<MarkElement> targetIteratorOfSelectedGroupElement =
                  targetElementsOfNextSelected.iterator();

              while (targetIteratorOfSelectedGroupElement.hasNext()) {
                MarkElement targetElementOfNextSelectedElement =
                    (MarkElement) targetIteratorOfSelectedGroupElement.next();
                if (targetElementOfNextSelectedElement.getId()
                    .equals(beforeCheckedElement.getId())) {
                  targetIteratorOfSelectedGroupElement.remove();
                  break;
                }
              }
              MarkElement.setTargetList(nextSelectedGroupElement, targetElementsOfNextSelected);
            }
          } else {
            Iterator<MarkElement> targetIteratorOfSelected = targetElementsOfSelected.iterator();

            while (targetIteratorOfSelected.hasNext()) {
              MarkElement targetElementOfSelected = (MarkElement) targetIteratorOfSelected.next();
              if (targetElementOfSelected.getId().equals(beforeCheckedElement.getId())) {
                targetIteratorOfSelected.remove();
                break;
              }
            }
            MarkElement.setTargetList(selectedMarker, targetElementsOfSelected);
          }
        }
      }

      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
      TargetView.setColumns(targetElementsOfSelected);

      convertToMappingMarker();

    } catch (CoreException e) {
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
      if (MarkElement.getTargetList(selectedMarker).size() == 0) {
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

