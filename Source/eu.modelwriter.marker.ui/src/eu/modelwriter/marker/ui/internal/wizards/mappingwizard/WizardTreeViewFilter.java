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
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class WizardTreeViewFilter extends ViewerFilter {
  public static ArrayList<String> suitableTypes;
  private boolean isIndirect;

  public WizardTreeViewFilter(boolean isIndirect) {
    this.isIndirect = isIndirect;
    if (isIndirect) {
      WizardTreeViewFilter.suitableTypes = AlloyUtilities.getSuitableSecondSideTypesOfRelation(
          RelationsWizardPage.selectedRelation.substring(0,
              RelationsWizardPage.selectedRelation.indexOf(" ")),
          RelationsWizardPage.selectedRelation.substring(
              RelationsWizardPage.selectedRelation.indexOf(": ") + 2,
              RelationsWizardPage.selectedRelation.indexOf(" ->")));
    }
  }

  @Override
  public boolean select(Viewer viewer, Object parentElement, Object element) {
    String groupIdOfSelected = MarkUtilities.getGroupId(MarkerMatchPage.selectedMarker);
    if (element instanceof IResource) {
      if (element instanceof IProject) {
        IProject project = (IProject) element;
        if (!project.isOpen()) {
          return false;
        }
      }
      List<IMarker> list = MarkerFactory.findMarkers((IResource) element);
      if (list.isEmpty()) {
        return false;
      }
      // ikisinde de gecerli
      if (groupIdOfSelected != null) {
        if (MarkerFactory.findMarkerBySourceId((IResource) element,
            MarkUtilities.getSourceId(MarkerMatchPage.selectedMarker)) != null
            && MarkerFactory.findMarkersByGroupId((IResource) element, groupIdOfSelected)
                .size() == list.size()) {
          return false;
        }
      } else {
        if (MarkerFactory.findMarkerBySourceId((IResource) element,
            MarkUtilities.getSourceId(MarkerMatchPage.selectedMarker)) != null
            && list.size() == 1) {
          return false;
        }
      }
      if (this.isIndirect) { // selected marker tipli ise
        for (IMarker iMarker : list) {
          if (MarkUtilities.getType(iMarker) != null) { // hicbirinin tipi yoksa
            for (String type : WizardTreeViewFilter.suitableTypes) {
              if (type.substring(type.indexOf("/") + 1).equals(MarkUtilities.getType(iMarker))) {
                if (MarkUtilities.getGroupId(iMarker) != null) { // kendi grubundan degilse
                  if (MarkUtilities.getGroupId(MarkerMatchPage.selectedMarker) != null) {
                    if (!MarkUtilities.getGroupId(iMarker).equals(groupIdOfSelected)) {
                      return true;
                    }
                  } else if (!MarkUtilities.compare(iMarker, MarkerMatchPage.selectedMarker)) {
                    return true; // kendisi degilse
                  }
                } else if (!MarkUtilities.compare(iMarker, MarkerMatchPage.selectedMarker)) {
                  return true; // kendisi degilse
                }
              }
            }
          }
        }
      } else {
        return true;
      }
      return false;
    } else if (element instanceof IMarker) {
      IMarker marker = (IMarker) element;
      if (this.isIndirect) {
        if (MarkUtilities.getType(marker) == null) {
          return false;
        } else { // tipi varsa
          for (String type : WizardTreeViewFilter.suitableTypes) {
            if (type.substring(type.indexOf("/") + 1).equals(MarkUtilities.getType(marker))) {
              if (MarkUtilities.getGroupId(marker) != null) { // kendi grubundan degilse
                if (MarkUtilities.getGroupId(MarkerMatchPage.selectedMarker) != null) {
                  if (!MarkUtilities.getGroupId(marker).equals(groupIdOfSelected)) {
                    return true;
                  } else {
                    return false;
                  }
                } else if (!MarkUtilities.compare(marker, MarkerMatchPage.selectedMarker)) {
                  return true; // kendisi degilse
                }
              } else if (!MarkUtilities.compare(marker, MarkerMatchPage.selectedMarker)) {
                return true; // kendisi degilse
              }
            }
          }
          return false;
        }
      } else {
        if (groupIdOfSelected != null && MarkUtilities.getGroupId(marker) != null
            && groupIdOfSelected.equals(MarkUtilities.getGroupId(marker))) {
          return false; // kendi grubundan biriyse
        }
        if (MarkUtilities.compare(marker, MarkerMatchPage.selectedMarker)) {
          return false; // kendisiyse
        }
      }
    }
    return true;
  }
}
