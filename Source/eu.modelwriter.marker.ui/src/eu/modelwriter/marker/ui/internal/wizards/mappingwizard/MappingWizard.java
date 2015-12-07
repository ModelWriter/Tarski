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
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
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
   * Note : if you send selected marker with candidateMarkersToTypeChanging array, you must get
   * selected marker from this method primarily.
   *
   * @param marker this parameter has miscellaneous meanings.
   * @param beforeDelete this parameter is used for distinguish between add/remove type action and
   *        others.
   */
  public static IMarker convertAnnotationType(final IMarker marker, final boolean beforeDelete,
      final boolean isSelectedMarker) {
    IMarker newMarker = marker;
    try {
      final IMarker leaderMarker = MarkUtilities.getLeaderOfMarker(marker);
      if (leaderMarker == null) {
        return null;
      }
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

      final IResource res = leaderMarker.getResource();
      if (targetCount > 0 && leaderMarker.getType().equals(MarkerFactory.MARKER_MARKING)) {
        final Map<String, Object> attributes = leaderMarker.getAttributes();
        AnnotationFactory.removeAnnotation(leaderMarker);
        leaderMarker.delete();
        MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MAPPING);
        newMarker =
            MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
        AnnotationFactory.addAnnotation(newMarker, AnnotationFactory.ANNOTATION_MAPPING);
      } else if (targetCount == 0 && leaderMarker.getType().equals(MarkerFactory.MARKER_MAPPING)) {
        final Map<String, Object> attributes = leaderMarker.getAttributes();
        AnnotationFactory.removeAnnotation(leaderMarker);
        leaderMarker.delete();
        MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MARKING);
        newMarker =
            MarkerFactory.findMarkerBySourceId(res, (String) attributes.get(IMarker.SOURCE_ID));
        AnnotationFactory.addAnnotation(newMarker, AnnotationFactory.ANNOTATION_MARKING);
      }
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return newMarker;
  }

  public static int findTargetCount(final IMarker marker) {
    final Map<IMarker, String> fieldsTargets = AlloyUtilities.getRelationsOfFirstSideMarker(marker);
    final ArrayList<IMarker> relationsTargets =
        AlloyUtilities.getTargetsOfMarkerAtRelations(marker);

    return fieldsTargets.size() + relationsTargets.size();
  }

  public IMarker selectedMarker;
  private MarkerMatchPage markerMatchPage;
  private RelationsWizardPage relationWizardPage;

  private ArrayList<IMarker> listOfSome;

  boolean isIndirect;

  public MappingWizard(final IMarker selectedMarker, final boolean isIndirect) {
    this.selectedMarker = selectedMarker;
    this.isIndirect = isIndirect;
    this.setNeedsProgressMonitor(true);
  }

  @Override
  public void addPages() {
    if (this.isIndirect) {
      this.relationWizardPage = new RelationsWizardPage(this.selectedMarker);
      this.addPage(this.relationWizardPage);
    }
    this.markerMatchPage = new MarkerMatchPage(this.selectedMarker, this.isIndirect);
    this.addPage(this.markerMatchPage);
  }

  private void addRelationsOfNewCheckeds(final ArrayList<IMarker> newCheckeds) {
    for (final IMarker checkedMarker : newCheckeds) {
      if (this.isIndirect) {
        AlloyUtilities.addRelation2Markers(this.selectedMarker, checkedMarker,
            RelationsWizardPage.selectedRelation.substring(0,
                RelationsWizardPage.selectedRelation.indexOf(" ")));
      } else {
        AlloyUtilities.addMapping2RelationType(this.selectedMarker, checkedMarker);
      }
    }
  }

  @Override
  public boolean canFinish() {
    if (this.markerMatchPage.isPageComplete()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void createPageControls(final Composite pageContainer) {
    if (this.isIndirect) {
      this.relationWizardPage.setPageComplete(false);
    }
    this.markerMatchPage.setPageComplete(false);
  }

  private void findUnCheckedsAndNewCheckeds() {
    final Iterator<IMarker> listOfSomeIter = this.listOfSome.iterator();

    while (listOfSomeIter.hasNext()) {
      final IMarker someMarker = listOfSomeIter.next();

      final Iterator<IMarker> beforeMarkerIter = MappingWizard.beforeCheckedMarkers.iterator();
      while (beforeMarkerIter.hasNext()) {
        final IMarker beforeMarker = beforeMarkerIter.next();
        if (MarkUtilities.compare(someMarker, beforeMarker)) {
          listOfSomeIter.remove();
          beforeMarkerIter.remove();
          break;
        }
      }
    }
  }

  public MarkerMatchPage getMarkerMatchPage() {
    if (MarkerMatchPage.markTreeViewer != null
        && !MarkerMatchPage.markTreeViewer.getTree().isDisposed()) {
      MarkerMatchPage.markTreeViewer
          .setFilters(new ViewerFilter[] {new WizardTreeViewFilter(this.isIndirect)});
      // TODO Look here maybe there is a little bug
      markerMatchPage.initCheckedElements();
      MarkerMatchPage.markTreeViewer.collapseAll();
    }
    return this.markerMatchPage;
  }

  public RelationsWizardPage getRelationWizardPage() {
    return this.relationWizardPage;
  }

  @Override
  public IWizardPage getStartingPage() {
    if (this.isIndirect) {
      return this.relationWizardPage;
    } else {
      return this.markerMatchPage;
    }
  }

  @Override
  public String getWindowTitle() {
    return "Mapping Action";
  }

  @Override
  public boolean performFinish() {
    this.listOfSome = MarkerMatchPage.checkedElements;
    final int targetSize = this.listOfSome.size();

    this.findUnCheckedsAndNewCheckeds();
    this.addRelationsOfNewCheckeds(this.listOfSome);
    this.removeRelationsOfUncheckeds(MappingWizard.beforeCheckedMarkers);
    this.refreshUI(targetSize);

    return true;
  }

  private void refreshUI(final int targetSize) {
    try {
      final IWorkbenchPage page =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
      final IViewPart targetView = page.findView(TargetView.ID);
      if (this.isIndirect) {
        final Map<IMarker, String> targets =
            AlloyUtilities.getRelationsOfFirstSideMarker(this.selectedMarker);
        if (targetView != null) {
          TargetView.setColumns(targets);
        }
      } else {
        final ArrayList<IMarker> targets =
            AlloyUtilities.getTargetsOfMarkerAtRelations(this.selectedMarker);
        page.showView(TargetView.ID);
        TargetView.setColumns(targets);
      }
      MappingWizard.convertAnnotationType(this.selectedMarker, false, false);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  private void removeRelationsOfUncheckeds(final ArrayList<IMarker> unCheckeds) {
    for (final IMarker unCheckedMarker : unCheckeds) {
      if (this.isIndirect) {
        AlloyUtilities.removeFieldOfMarkers(this.selectedMarker, unCheckedMarker,
            RelationsWizardPage.selectedRelation.substring(0,
                RelationsWizardPage.selectedRelation.indexOf(" ")));
      } else {
        AlloyUtilities.removeMappingFromRelationType(this.selectedMarker, unCheckedMarker);
      }
    }
  }
}
