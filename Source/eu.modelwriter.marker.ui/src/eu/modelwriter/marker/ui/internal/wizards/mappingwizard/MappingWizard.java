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
  private IMarker selectedMarker;
  private boolean isIndirect;

  public MappingWizard(IMarker selectedMarker, boolean isIndirect) {
    super();
    this.selectedMarker = selectedMarker;
    this.isIndirect = isIndirect;
    if (this.isIndirect) {
      MappingWizard.beforeCheckedMarkers = AlloyUtilities.getSecondSideMarkerIdsByMarkerAndRelation(
          this.selectedMarker, RelationWizard.selectedRelation.substring(0,
              RelationWizard.selectedRelation.indexOf(" ")));
    } else {
      MappingWizard.beforeCheckedMarkers =
          AlloyUtilities.getSecondSideMarkerIdsByMarkerAndRelationV2(selectedMarker);
    }
    this.setNeedsProgressMonitor(true);
  }

  @Override
  public void addPages() {
    this.page = new MarkerMatchPage(selectedMarker, isIndirect);
    super.addPages();
    this.addPage(this.page);
  }

  public void convertToMappingMarker(int targetCount) throws CoreException {
    if ((targetCount > 0) && selectedMarker.getType().equals(MarkerFactory.MARKER_MARKING)) {
      Map<String, Object> attributes = selectedMarker.getAttributes();
      IResource res = selectedMarker.getResource();
      AnnotationFactory.removeAnnotation(selectedMarker, Activator.getEditor());
      selectedMarker.delete();
      MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MAPPING);
      IMarker newMarker =
          MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
      AnnotationFactory.addAnnotation(newMarker, Activator.getEditor(),
          AnnotationFactory.ANNOTATION_MAPPING);
    } else
      if ((targetCount == 0) && selectedMarker.getType().equals(MarkerFactory.MARKER_MAPPING)) {
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

  @Override
  public String getWindowTitle() {

    return "Mapping Markers";
  }

  @Override
  public boolean performFinish() {
    ArrayList<IMarker> listOfSome = MarkerMatchPage.checkedElements;
    int targetSize = listOfSome.size();

    Iterator<IMarker> listOfSomeIter = listOfSome.iterator();

    while (listOfSomeIter.hasNext()) {
      IMarker someMarker = listOfSomeIter.next();

      Iterator<IMarker> beforeMarkerIter = MappingWizard.beforeCheckedMarkers.iterator();
      while (beforeMarkerIter.hasNext()) {
        IMarker beforeMarker = beforeMarkerIter.next();
        if (MarkUtilities.compare(someMarker, beforeMarker)) {
          listOfSomeIter.remove();
          beforeMarkerIter.remove();
          break;
        }
      }
    }
    for (Object object : listOfSome) {
      IMarker checkedMarker = (IMarker) object;
      if (isIndirect) {
        AlloyUtilities.addRelation2Markers(selectedMarker, checkedMarker,
            RelationWizard.selectedRelation.substring(0,
                RelationWizard.selectedRelation.indexOf(" ")));
      } else {
        AlloyUtilities.addMapping2RelationType(selectedMarker, checkedMarker);
      }
    }

    for (IMarker unCheckedMarker : MappingWizard.beforeCheckedMarkers) {
      if (isIndirect) {
        AlloyUtilities.removeRelationOfMarkers(selectedMarker, unCheckedMarker,
            RelationWizard.selectedRelation.substring(0,
                RelationWizard.selectedRelation.indexOf(" ")));
      } else {
        AlloyUtilities.removeMappingFromRelationType(selectedMarker, unCheckedMarker);
      }
    }

    try {
      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
      if (isIndirect) {
        Map<IMarker, String> targets = AlloyUtilities.getRelationsOfFirstSideMarker(selectedMarker);
        TargetView.setColumns(targets);
      } else {
        ArrayList<IMarker> targets = AlloyUtilities.getTargetsOfRelationMarker(selectedMarker);
        TargetView.setColumns(targets);
      }
      this.convertToMappingMarker(targetSize);
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return true;
  }
}
