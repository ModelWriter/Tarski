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

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.alloy.analysis.StaticAlloyAnalysisManager;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;

public class MappingWizard extends Wizard {

  public static ArrayList<IMarker> beforeCheckedMarkers;

  public IMarker selectedMarker;
  private MarkerMatchPage markerMatchPage;
  private RelationsWizardPage relationWizardPage;

  private ArrayList<IMarker> listOfSome;

  boolean isIndirect;

  public MappingWizard(final IMarker selectedMarker, final boolean isIndirect) {
    this.selectedMarker = selectedMarker;
    this.isIndirect = isIndirect;
    setNeedsProgressMonitor(true);
  }

  @Override
  public void addPages() {
    if (isIndirect) {
      relationWizardPage = new RelationsWizardPage(selectedMarker);
      addPage(relationWizardPage);
    }
    markerMatchPage = new MarkerMatchPage(selectedMarker, isIndirect);
    addPage(markerMatchPage);
  }

  private void addRelationsOfNewCheckeds(final ArrayList<IMarker> newCheckeds) {
    for (final IMarker checkedMarker : newCheckeds) {
      if (isIndirect) {
        AlloyUtilities.addRelation2Markers(selectedMarker, checkedMarker,
            RelationsWizardPage.selectedRelation.substring(0,
                RelationsWizardPage.selectedRelation.indexOf(" ")));
      } else {
        AlloyUtilities.addMapping2RelationType(selectedMarker, checkedMarker);
      }
    }
    AnnotationFactory.convertAnnotationType(selectedMarker, false, false,
        AlloyUtilities.getTotalTargetCount(selectedMarker));
  }

  @Override
  public boolean canFinish() {
    if (markerMatchPage.isPageComplete()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void createPageControls(final Composite pageContainer) {
    if (isIndirect) {
      relationWizardPage.setPageComplete(false);
    }
    markerMatchPage.setPageComplete(false);
  }

  private void findUnCheckedsAndNewCheckeds() {
    final Iterator<IMarker> listOfSomeIter = listOfSome.iterator();

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
      .setFilters(new ViewerFilter[] {new WizardTreeViewFilter(isIndirect)});
      // TODO Look here maybe there is a little bug
      markerMatchPage.initCheckedElements();
      MarkerMatchPage.markTreeViewer.collapseAll();
    }
    return markerMatchPage;
  }

  public RelationsWizardPage getRelationWizardPage() {
    return relationWizardPage;
  }

  @Override
  public IWizardPage getStartingPage() {
    if (isIndirect) {
      return relationWizardPage;
    } else {
      return markerMatchPage;
    }
  }

  @Override
  public String getWindowTitle() {
    return "Create a trace relation";
  }

  @Override
  public boolean performFinish() {
    StaticAlloyAnalysisManager.finishAnalysis();

    listOfSome = MarkerMatchPage.checkedElements;

    findUnCheckedsAndNewCheckeds();
    addRelationsOfNewCheckeds(listOfSome);
    removeRelationsOfUncheckeds(MappingWizard.beforeCheckedMarkers);
    refreshUI();

    return true;
  }

  private void refreshUI() {
    AnnotationFactory.convertAnnotationType(selectedMarker, false, false,
        AlloyUtilities.getTotalTargetCount(selectedMarker));
  }

  private void removeRelationsOfUncheckeds(final ArrayList<IMarker> unCheckeds) {
    for (final IMarker unCheckedMarker : unCheckeds) {
      if (isIndirect) {
        AlloyUtilities.removeFieldOfMarkers(selectedMarker, unCheckedMarker,
            RelationsWizardPage.selectedRelation.substring(0,
                RelationsWizardPage.selectedRelation.indexOf(" ")));
      } else {
        AlloyUtilities.removeMappingFromRelationType(selectedMarker, unCheckedMarker);
      }
    }
  }
}
