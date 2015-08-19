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

import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;
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
    beforeCheckedElements = MarkElementUtilities.getTargetList(selectedMarker);
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

  @Override
  public boolean performFinish() {
    try {
      Object[] checkedObjects = MarkerMatchPage.markTreeViewer.getCheckedElements();
      for (int i = 0; i < checkedObjects.length; i++) {
        if (checkedObjects[i] instanceof IMarker) {
          checkedElements.add(new MarkElement((IMarker) checkedObjects[i]));
        }
      }
      targetElementsOfSelected = MarkElementUtilities.getTargetList(selectedMarker);

      for (MarkElement checkedElement : checkedElements) {
        if (beforeCheckedElements.contains(checkedElement)) {
          continue;
        } else {
          if (MarkElementUtilities.getLeaderId(checkedElement.getiMarker()) != null) {

            List<IMarker> groupMarkersOfCheckedElement =
                MarkerFactory.findMarkersByGroupId(checkedElement.getiMarker().getResource(),
                    MarkElementUtilities.getGroupId(checkedElement.getiMarker()));

            Iterator<IMarker> groupMarkersIteratorOfCheckedElement =
                groupMarkersOfCheckedElement.iterator();

            while (groupMarkersIteratorOfCheckedElement.hasNext()) {
              IMarker nextCheckedGroupElement =
                  (IMarker) groupMarkersIteratorOfCheckedElement.next();
              ArrayList<MarkElement> sourcesOfGroupElement =
                  MarkElementUtilities.getSourceList(nextCheckedGroupElement);
              sourcesOfGroupElement.add(new MarkElement(selectedMarker));
              MarkElementUtilities.setSourceList(nextCheckedGroupElement, sourcesOfGroupElement);
            }
          } else {
            ArrayList<MarkElement> sourceElementsOfChecked =
                MarkElementUtilities.getSourceList(checkedElement.getiMarker());
            sourceElementsOfChecked.add(new MarkElement(selectedMarker));
            MarkElementUtilities.setSourceList(checkedElement.getiMarker(),
                sourceElementsOfChecked);
          }

          if (MarkElementUtilities.getLeaderId(selectedMarker) != null) {
            List<IMarker> groupMarkersOfSelectedElement = MarkerFactory.findMarkersByGroupId(
                selectedMarker.getResource(), MarkElementUtilities.getGroupId(selectedMarker));

            Iterator<IMarker> groupMarkersIteratorOfSelectedElement =
                groupMarkersOfSelectedElement.iterator();

            while (groupMarkersIteratorOfSelectedElement.hasNext()) {
              IMarker nextSelectedGroupElement =
                  (IMarker) groupMarkersIteratorOfSelectedElement.next();

              ArrayList<MarkElement> targetElementsOfNextSelected =
                  MarkElementUtilities.getTargetList(nextSelectedGroupElement);

              targetElementsOfNextSelected.add(checkedElement);
              MarkElementUtilities.setTargetList(nextSelectedGroupElement,
                  targetElementsOfNextSelected);
            }
          } else {
            targetElementsOfSelected.add(checkedElement);
            MarkElementUtilities.setTargetList(selectedMarker, targetElementsOfSelected);
          }
        }
      }

      for (MarkElement beforeCheckedElement : beforeCheckedElements) {
        if (checkedElements.contains(beforeCheckedElement)) {
          continue;
        } else {
          if (MarkElementUtilities.getLeaderId(beforeCheckedElement.getiMarker()) != null) {

            List<IMarker> groupMarkersOfBeforeCheckedElement =
                MarkerFactory.findMarkersByGroupId(beforeCheckedElement.getiMarker().getResource(),
                    MarkElementUtilities.getGroupId(beforeCheckedElement.getiMarker()));

            Iterator<IMarker> groupMarkersIteratorOfBeforeCheckedElement =
                groupMarkersOfBeforeCheckedElement.iterator();

            while (groupMarkersIteratorOfBeforeCheckedElement.hasNext()) {
              IMarker nextBeforeCheckedGroupElement =
                  (IMarker) groupMarkersIteratorOfBeforeCheckedElement.next();
              ArrayList<MarkElement> sourceElementsOfBeforeChecked =
                  MarkElementUtilities.getSourceList(nextBeforeCheckedGroupElement);

              Iterator<MarkElement> sourceIteratorOfBeforeCheckedGroupElement =
                  sourceElementsOfBeforeChecked.iterator();

              while (sourceIteratorOfBeforeCheckedGroupElement.hasNext()) {
                MarkElement sourceElementOfBeforeCheckedElement =
                    (MarkElement) sourceIteratorOfBeforeCheckedGroupElement.next();
                if (MarkElementUtilities
                    .getSourceId(sourceElementOfBeforeCheckedElement.getiMarker())
                    .equals(MarkElementUtilities.getSourceId(selectedMarker))) {
                  sourceIteratorOfBeforeCheckedGroupElement.remove();
                  break;
                }
              }

              MarkElementUtilities.setSourceList(nextBeforeCheckedGroupElement,
                  sourceElementsOfBeforeChecked);
            }
          } else {
            ArrayList<MarkElement> sourceElementsOfBeforeChecked =
                MarkElementUtilities.getSourceList(beforeCheckedElement.getiMarker());

            Iterator<MarkElement> sourceIteratorOfBeforeChecked =
                sourceElementsOfBeforeChecked.iterator();

            while (sourceIteratorOfBeforeChecked.hasNext()) {
              MarkElement sourceElementOfBeforeCheckedElement =
                  (MarkElement) sourceIteratorOfBeforeChecked.next();
              if (MarkElementUtilities.getSourceId(sourceElementOfBeforeCheckedElement.getiMarker())
                  .equals(MarkElementUtilities.getSourceId(selectedMarker))) {
                sourceIteratorOfBeforeChecked.remove();
                break;
              }
            }
            MarkElementUtilities.setSourceList(beforeCheckedElement.getiMarker(),
                sourceElementsOfBeforeChecked);
          }

          if (MarkElementUtilities.getLeaderId(selectedMarker) != null) {
            List<IMarker> groupMarkersOfSelectedElement = MarkerFactory.findMarkersByGroupId(
                selectedMarker.getResource(), MarkElementUtilities.getGroupId(selectedMarker));

            Iterator<IMarker> groupMarkersIteratorOfSelectedElement =
                groupMarkersOfSelectedElement.iterator();

            while (groupMarkersIteratorOfSelectedElement.hasNext()) {
              IMarker nextSelectedGroupElement =
                  (IMarker) groupMarkersIteratorOfSelectedElement.next();

              ArrayList<MarkElement> targetElementsOfNextSelected =
                  MarkElementUtilities.getTargetList(nextSelectedGroupElement);

              Iterator<MarkElement> targetIteratorOfSelectedGroupElement =
                  targetElementsOfNextSelected.iterator();

              while (targetIteratorOfSelectedGroupElement.hasNext()) {
                MarkElement targetElementOfNextSelectedElement =
                    (MarkElement) targetIteratorOfSelectedGroupElement.next();
                if (MarkElementUtilities
                    .getSourceId(targetElementOfNextSelectedElement.getiMarker())
                    .equals(MarkElementUtilities.getSourceId(beforeCheckedElement.getiMarker()))) {
                  targetIteratorOfSelectedGroupElement.remove();
                  break;
                }
              }
              MarkElementUtilities.setTargetList(nextSelectedGroupElement,
                  targetElementsOfNextSelected);
            }
          } else {
            Iterator<MarkElement> targetIteratorOfSelected = targetElementsOfSelected.iterator();

            while (targetIteratorOfSelected.hasNext()) {
              MarkElement targetElementOfSelected = (MarkElement) targetIteratorOfSelected.next();
              if (MarkElementUtilities.getSourceId(targetElementOfSelected.getiMarker())
                  .equals(MarkElementUtilities.getSourceId(beforeCheckedElement.getiMarker()))) {
                targetIteratorOfSelected.remove();
                break;
              }
            }
            MarkElementUtilities.setTargetList(selectedMarker, targetElementsOfSelected);
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
      AnnotationFactory.removeAnnotation(selectedMarker, Activator.getEditor());
      selectedMarker.delete();
      MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MAPPING);
      IMarker newMarker =
          MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
      AnnotationFactory.addAnnotation(newMarker, Activator.getEditor(),
          AnnotationFactory.ANNOTATION_MAPPING);
    } else if (selectedMarker.getType().equals(MarkerFactory.MARKER_MAPPING)) {
      if (MarkElementUtilities.getTargetList(selectedMarker).size() == 0) {
        Map<String, Object> attributes = selectedMarker.getAttributes();
        IResource res = selectedMarker.getResource();
        AnnotationFactory.removeAnnotation(selectedMarker, Activator.getEditor());
        selectedMarker.delete();
        MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MARKING);
        IMarker newMarker =
            MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
        AnnotationFactory.addAnnotation(newMarker, Activator.getEditor(),
            AnnotationFactory.ANNOTATION_MARKING);
      }
    }
  }
}
