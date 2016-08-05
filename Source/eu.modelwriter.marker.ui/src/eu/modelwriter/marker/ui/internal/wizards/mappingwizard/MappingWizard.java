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

import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolutionReasoning;
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
    AnnotationFactory.convertAnnotationType(this.selectedMarker, false, false,
        AlloyUtilities.getTotalTargetCount(this.selectedMarker));
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
      this.markerMatchPage.initCheckedElements();
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
    return "Create a trace relation";
  }

  @Override
  public boolean performFinish() {
    AlloyNextSolutionReasoning.getInstance().finishNext();

    this.listOfSome = MarkerMatchPage.checkedElements;

    this.findUnCheckedsAndNewCheckeds();
    this.addRelationsOfNewCheckeds(this.listOfSome);
    this.removeRelationsOfUncheckeds(MappingWizard.beforeCheckedMarkers);
    this.refreshUI();

    return true;
  }

  private void refreshUI() {
    AnnotationFactory.convertAnnotationType(this.selectedMarker, false, false,
        AlloyUtilities.getTotalTargetCount(this.selectedMarker));
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
