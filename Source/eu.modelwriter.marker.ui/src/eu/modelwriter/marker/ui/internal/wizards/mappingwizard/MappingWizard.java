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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.MarkerUtilities;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.mappingview.TargetView;

public class MappingWizard extends Wizard {

  public static ArrayList<IMarker> beforeCheckedMarkers;

  /**
   * These type is referred to {@link MarkerFactory.ANNOTATION_MARKING} and
   * {@link MarkerFactory.ANNOTATION_MAPPING}
   *
   * @param marker this parameter has miscellaneous meanings.
   * @param beforeDelete this parameter is used for distinguish between add/remove type action and
   *        others.
   */
  public static void convertAnnotationType(IMarker marker, boolean beforeDelete,
      boolean isSelectedMarker) {
    try {
      IMarker leaderMarker = MarkUtilities.getLeaderOfMarker(marker);
      int targetCount = -1;

      if (isSelectedMarker) {
        targetCount = 0;
      } else {
        if (beforeDelete) {
          targetCount = MappingWizard.findTargetCount(marker) - 1;
        } else {
          targetCount = MappingWizard.findTargetCount(marker);
        }
      }

      IResource res = leaderMarker.getResource();
      // IEditorReference[] refs =
      // PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
      // .getEditorReferences();
      // IEditorPart part = null;
      // for (IEditorReference iEditorReference : refs) {
      // if (iEditorReference.getName().equals(res.getName())) {
      // part = iEditorReference.getEditor(false);
      // break;
      // }
      // }
      IEditorPart part = ResourceUtil.findEditor(
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), (IFile) res);
      if ((targetCount > 0) && leaderMarker.getType().equals(MarkerFactory.MARKER_MARKING)) {
        Map<String, Object> attributes = leaderMarker.getAttributes();
        AnnotationFactory.removeAnnotation(leaderMarker, part);
        leaderMarker.delete();
        MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MAPPING);
        IMarker newMarker =
            MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
        AnnotationFactory.addAnnotation(newMarker, part, AnnotationFactory.ANNOTATION_MAPPING);
      } else
        if ((targetCount == 0) && leaderMarker.getType().equals(MarkerFactory.MARKER_MAPPING)) {
        Map<String, Object> attributes = leaderMarker.getAttributes();
        AnnotationFactory.removeAnnotation(leaderMarker, part);
        leaderMarker.delete();
        MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MARKING);
        IMarker newMarker =
            MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
        AnnotationFactory.addAnnotation(newMarker, part, AnnotationFactory.ANNOTATION_MARKING);
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  private static int findTargetCount(IMarker marker) {
    Map<IMarker, String> fieldsTargets = AlloyUtilities.getRelationsOfFirstSideMarker(marker);
    ArrayList<IMarker> relationsTargets = AlloyUtilities.getTargetsOfMarkerAtRelations(marker);

    return fieldsTargets.size() + relationsTargets.size();
  }

  private ArrayList<IMarker> listOfSome;
  public MarkerMatchPage page;
  private IMarker selectedMarker;

  private boolean isIndirect;

  public MappingWizard(IMarker selectedMarker, boolean isIndirect) {
    super();
    this.selectedMarker = selectedMarker;
    this.isIndirect = isIndirect;
    if (isIndirect) {
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
    this.page = new MarkerMatchPage(this.selectedMarker, this.isIndirect);
    super.addPages();
    this.addPage(this.page);
  }

  private void addRelationsOfNewCheckeds(ArrayList<IMarker> newCheckeds) {
    for (IMarker checkedMarker : newCheckeds) {
      if (this.isIndirect) {
        AlloyUtilities.addRelation2Markers(this.selectedMarker, checkedMarker,
            RelationWizard.selectedRelation.substring(0,
                RelationWizard.selectedRelation.indexOf(" ")));
      } else {
        AlloyUtilities.addMapping2RelationType(this.selectedMarker, checkedMarker);
      }
    }
  }

  private void findUnCheckedsAndNewCheckeds() {
    Iterator<IMarker> listOfSomeIter = this.listOfSome.iterator();

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
  }

  @Override
  public String getWindowTitle() {

    return "Mapping Markers";
  }

  @Override
  public boolean performFinish() {
    this.listOfSome = MarkerMatchPage.checkedElements;
    int targetSize = this.listOfSome.size();

    this.findUnCheckedsAndNewCheckeds();
    this.addRelationsOfNewCheckeds(this.listOfSome);
    this.removeRelationsOfUncheckeds(MappingWizard.beforeCheckedMarkers);
    this.refreshUI(targetSize);

    return true;
  }

  private void refreshUI(int targetSize) {
    try {
      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
      if (this.isIndirect) {
        Map<IMarker, String> targets =
            AlloyUtilities.getRelationsOfFirstSideMarker(this.selectedMarker);
        TargetView.setColumns(targets);
      } else {
        ArrayList<IMarker> targets =
            AlloyUtilities.getTargetsOfMarkerAtRelations(this.selectedMarker);
        TargetView.setColumns(targets);
      }
      MappingWizard.convertAnnotationType(this.selectedMarker, false, false);
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  private void removeRelationsOfUncheckeds(ArrayList<IMarker> unCheckeds) {
    for (IMarker unCheckedMarker : unCheckeds) {
      if (this.isIndirect) {
        AlloyUtilities.removeFieldOfMarkers(this.selectedMarker, unCheckedMarker,
            RelationWizard.selectedRelation.substring(0,
                RelationWizard.selectedRelation.indexOf(" ")));
      } else {
        AlloyUtilities.removeMappingFromRelationType(this.selectedMarker, unCheckedMarker);
      }
    }
  }
}
