/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.MarkerUtilities;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.mappingview.TargetView;

public class MappingWizard extends Wizard {

  public static ArrayList<IMarker> beforeCheckedMarkers;
  public MarkerMatchPage page;

  public MappingWizard() {
    super();
    beforeCheckedMarkers = AlloyUtilities.getSecondSideMarkerIdsByMarkerAndRelation(
        RelationWizard.selectedMarker,
        RelationWizard.selectedRelation.substring(0, RelationWizard.selectedRelation.indexOf(" ")));
    setNeedsProgressMonitor(true);
  }

  @Override
  public void addPages() {
    page = new MarkerMatchPage();
    super.addPages();
    this.addPage(page);
  }

  public void convertToMappingMarker(int targetCount) throws CoreException {
    if ((targetCount > 0)
        && RelationWizard.selectedMarker.getType().equals(MarkerFactory.MARKER_MARKING)) {
      Map<String, Object> attributes = RelationWizard.selectedMarker.getAttributes();
      IResource res = RelationWizard.selectedMarker.getResource();
      AnnotationFactory.removeAnnotation(RelationWizard.selectedMarker, Activator.getEditor());
      RelationWizard.selectedMarker.delete();
      MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MAPPING);
      IMarker newMarker =
          MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
      AnnotationFactory.addAnnotation(newMarker, Activator.getEditor(),
          AnnotationFactory.ANNOTATION_MAPPING);
    } else if ((targetCount == 0)
        && RelationWizard.selectedMarker.getType().equals(MarkerFactory.MARKER_MAPPING)) {
      if (MarkUtilities.getTargetList(RelationWizard.selectedMarker).size() == 0) {
        Map<String, Object> attributes = RelationWizard.selectedMarker.getAttributes();
        IResource res = RelationWizard.selectedMarker.getResource();
        AnnotationFactory.removeAnnotation(RelationWizard.selectedMarker, Activator.getEditor());
        RelationWizard.selectedMarker.delete();
        MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MARKING);
        IMarker newMarker =
            MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
        AnnotationFactory.addAnnotation(newMarker, Activator.getEditor(),
            AnnotationFactory.ANNOTATION_MARKING);
      }
    }
  }

  @Override
  public String getWindowTitle() {

    return "Mapping Markers";
  }

  @Override
  public boolean performFinish() {
    Object[] checkedObjects = MarkerMatchPage.markTreeViewer.getCheckedElements();
    ArrayList<Object> checkedObjectsList = new ArrayList<Object>(Arrays.asList(checkedObjects));
    int checkObjectsListSize = checkedObjectsList.size();

    Iterator<Object> checkedObjectsIter = checkedObjectsList.iterator();

    while (checkedObjectsIter.hasNext()) {
      Object object = checkedObjectsIter.next();
      if (object instanceof IMarker) {
        IMarker checkedMarker = (IMarker) object;
        Iterator<IMarker> beforeMarkerIter = beforeCheckedMarkers.iterator();
        while (beforeMarkerIter.hasNext()) {
          IMarker beforeMarker = beforeMarkerIter.next();
          if (MarkUtilities.compare(checkedMarker, beforeMarker)) {
            checkedObjectsIter.remove();
            beforeMarkerIter.remove();
            break;
          }
        }
      } else {
        checkedObjectsIter.remove();
      }
    }

    for (Object object : checkedObjectsList) {
      IMarker checkedMarker = (IMarker) object;
      AlloyUtilities.addRelation2Markers(RelationWizard.selectedMarker, checkedMarker,
          RelationWizard.selectedRelation.substring(0,
              RelationWizard.selectedRelation.indexOf(" ")));
    }

    for (IMarker unCheckedMarker : beforeCheckedMarkers) {
      AlloyUtilities.removeRelationOfMarkers(RelationWizard.selectedMarker, unCheckedMarker,
          RelationWizard.selectedRelation.substring(0,
              RelationWizard.selectedRelation.indexOf(" ")));
    }

    try {
      Map<IMarker, String> targets =
          AlloyUtilities.getRelationsOfFirstSideMarker(RelationWizard.selectedMarker);
      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
      TargetView.setColumns(targets);
      convertToMappingMarker(checkObjectsListSize);
    } catch (CoreException e) {
      e.printStackTrace();
    }

    // AlloyUtilities.addRelation2Markers(selectedMarker, checkedObjects, relationMap);
    //
    // Iterator<Entry<IMarker, String>> iter = deleteRelationMap.entrySet().iterator();
    //
    // while (iter.hasNext()) {
    // Map.Entry pair = (Map.Entry) iter.next();
    // AlloyUtilities.removeRelationOfMarkers(selectedMarker, (IMarker) pair.getKey(),
    // (String) pair.getValue());
    // }

    return true;
  }
  //
  // @Override
  // public boolean performFinish() {
  // try {
  // Object[] checkedObjects = MarkerMatchPage.markTreeViewer.getCheckedElements();
  // ArrayList<MarkElement> listOfSome = MarkerMatchPage.checkedElements;
  //
  // for (int i = 0; i < checkedObjects.length; i++) {
  // if (checkedObjects[i] instanceof IMarker) {
  // checkedElements.add(new MarkElement((IMarker) checkedObjects[i]));
  // AlloyUtilities.addRelation2Markers(selectedMarker, (IMarker) checkedObjects[i], "refs");
  // }
  // }
  // targetElementsOfSelected = MarkElementUtilities.getTargetList(selectedMarker);
  //
  // for (MarkElement checkedElement : checkedElements) {
  // boolean flag = false;
  // @SuppressWarnings("rawtypes")
  // Iterator iter = beforeCheckedElements.iterator();
  // while (iter.hasNext()) {
  // MarkElement markElement = (MarkElement) iter.next();
  // if (MarkElementUtilities.compare(markElement.getiMarker(), checkedElement.getiMarker())) {
  // flag = true;
  // break;
  // }
  // }
  // if (flag == false) {
  // if (MarkElementUtilities.getLeaderId(checkedElement.getiMarker()) != null) {
  // List<IMarker> groupMarkersOfCheckedElement =
  // MarkerFactory.findMarkersByGroupId(checkedElement.getiMarker().getResource(),
  // MarkElementUtilities.getGroupId(checkedElement.getiMarker()));
  //
  // Iterator<IMarker> groupMarkersIteratorOfCheckedElement =
  // groupMarkersOfCheckedElement.iterator();
  //
  // while (groupMarkersIteratorOfCheckedElement.hasNext()) {
  // IMarker nextCheckedGroupElement =
  // (IMarker) groupMarkersIteratorOfCheckedElement.next();
  // ArrayList<MarkElement> sourcesOfGroupElement =
  // MarkElementUtilities.getSourceList(nextCheckedGroupElement);
  // sourcesOfGroupElement.add(new MarkElement(selectedMarker));
  // MarkElementUtilities.setSourceList(nextCheckedGroupElement, sourcesOfGroupElement);
  // }
  // } else {
  // ArrayList<MarkElement> sourceElementsOfChecked =
  // MarkElementUtilities.getSourceList(checkedElement.getiMarker());
  // sourceElementsOfChecked.add(new MarkElement(selectedMarker));
  // MarkElementUtilities.setSourceList(checkedElement.getiMarker(),
  // sourceElementsOfChecked);
  // }
  //
  // if (MarkElementUtilities.getLeaderId(selectedMarker) != null) {
  // List<IMarker> groupMarkersOfSelectedElement = MarkerFactory.findMarkersByGroupId(
  // selectedMarker.getResource(), MarkElementUtilities.getGroupId(selectedMarker));
  //
  // Iterator<IMarker> groupMarkersIteratorOfSelectedElement =
  // groupMarkersOfSelectedElement.iterator();
  //
  // while (groupMarkersIteratorOfSelectedElement.hasNext()) {
  // IMarker nextSelectedGroupElement =
  // (IMarker) groupMarkersIteratorOfSelectedElement.next();
  //
  // ArrayList<MarkElement> targetElementsOfNextSelected =
  // MarkElementUtilities.getTargetList(nextSelectedGroupElement);
  //
  // targetElementsOfNextSelected.add(checkedElement);
  // MarkElementUtilities.setTargetList(nextSelectedGroupElement,
  // targetElementsOfNextSelected);
  // }
  // } else {
  // targetElementsOfSelected.add(checkedElement);
  // MarkElementUtilities.setTargetList(selectedMarker, targetElementsOfSelected);
  // }
  // }
  // }
  //
  // for (MarkElement beforeCheckedElement : beforeCheckedElements) {
  // if (listOfSome.contains(beforeCheckedElement)) {
  // continue;
  // } else {
  // if (MarkElementUtilities.getLeaderId(beforeCheckedElement.getiMarker()) != null) {
  //
  // List<IMarker> groupMarkersOfBeforeCheckedElement =
  // MarkerFactory.findMarkersByGroupId(beforeCheckedElement.getiMarker().getResource(),
  // MarkElementUtilities.getGroupId(beforeCheckedElement.getiMarker()));
  //
  // Iterator<IMarker> groupMarkersIteratorOfBeforeCheckedElement =
  // groupMarkersOfBeforeCheckedElement.iterator();
  //
  // while (groupMarkersIteratorOfBeforeCheckedElement.hasNext()) {
  // IMarker nextBeforeCheckedGroupElement =
  // (IMarker) groupMarkersIteratorOfBeforeCheckedElement.next();
  // ArrayList<MarkElement> sourceElementsOfBeforeChecked =
  // MarkElementUtilities.getSourceList(nextBeforeCheckedGroupElement);
  //
  // Iterator<MarkElement> sourceIteratorOfBeforeCheckedGroupElement =
  // sourceElementsOfBeforeChecked.iterator();
  //
  // while (sourceIteratorOfBeforeCheckedGroupElement.hasNext()) {
  // MarkElement sourceElementOfBeforeCheckedElement =
  // (MarkElement) sourceIteratorOfBeforeCheckedGroupElement.next();
  // if (MarkElementUtilities.compare(sourceElementOfBeforeCheckedElement.getiMarker(),
  // selectedMarker)) {
  // sourceIteratorOfBeforeCheckedGroupElement.remove();
  // break;
  // }
  // }
  //
  // MarkElementUtilities.setSourceList(nextBeforeCheckedGroupElement,
  // sourceElementsOfBeforeChecked);
  // }
  // } else {
  // ArrayList<MarkElement> sourceElementsOfBeforeChecked =
  // MarkElementUtilities.getSourceList(beforeCheckedElement.getiMarker());
  //
  // Iterator<MarkElement> sourceIteratorOfBeforeChecked =
  // sourceElementsOfBeforeChecked.iterator();
  //
  // while (sourceIteratorOfBeforeChecked.hasNext()) {
  // MarkElement sourceElementOfBeforeCheckedElement =
  // (MarkElement) sourceIteratorOfBeforeChecked.next();
  // if (MarkElementUtilities.compare(sourceElementOfBeforeCheckedElement.getiMarker(),
  // selectedMarker)) {
  // sourceIteratorOfBeforeChecked.remove();
  // break;
  // }
  // }
  // MarkElementUtilities.setSourceList(beforeCheckedElement.getiMarker(),
  // sourceElementsOfBeforeChecked);
  // }
  //
  // if (MarkElementUtilities.getLeaderId(selectedMarker) != null) {
  // List<IMarker> groupMarkersOfSelectedElement = MarkerFactory.findMarkersByGroupId(
  // selectedMarker.getResource(), MarkElementUtilities.getGroupId(selectedMarker));
  //
  // Iterator<IMarker> groupMarkersIteratorOfSelectedElement =
  // groupMarkersOfSelectedElement.iterator();
  //
  // while (groupMarkersIteratorOfSelectedElement.hasNext()) {
  // IMarker nextSelectedGroupElement =
  // (IMarker) groupMarkersIteratorOfSelectedElement.next();
  //
  // ArrayList<MarkElement> targetElementsOfNextSelected =
  // MarkElementUtilities.getTargetList(nextSelectedGroupElement);
  //
  // Iterator<MarkElement> targetIteratorOfSelectedGroupElement =
  // targetElementsOfNextSelected.iterator();
  //
  // while (targetIteratorOfSelectedGroupElement.hasNext()) {
  // MarkElement targetElementOfNextSelectedElement =
  // (MarkElement) targetIteratorOfSelectedGroupElement.next();
  // if (MarkElementUtilities.compare(targetElementOfNextSelectedElement.getiMarker(),
  // beforeCheckedElement.getiMarker())) {
  // targetIteratorOfSelectedGroupElement.remove();
  // break;
  // }
  // }
  // MarkElementUtilities.setTargetList(nextSelectedGroupElement,
  // targetElementsOfNextSelected);
  // }
  // } else {
  // Iterator<MarkElement> targetIteratorOfSelected = targetElementsOfSelected.iterator();
  //
  // while (targetIteratorOfSelected.hasNext()) {
  // MarkElement targetElementOfSelected = (MarkElement) targetIteratorOfSelected.next();
  // if (MarkElementUtilities.compare(targetElementOfSelected.getiMarker(),
  // beforeCheckedElement.getiMarker())) {
  // targetIteratorOfSelected.remove();
  // break;
  // }
  // }
  // MarkElementUtilities.setTargetList(selectedMarker, targetElementsOfSelected);
  // }
  // }
  // }
  //
  // PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
  // TargetView.setColumns(targetElementsOfSelected);
  //
  // convertToMappingMarker();
  //
  // } catch (CoreException e) {
  // e.printStackTrace();
  // }
  // return true;
  // }
}
