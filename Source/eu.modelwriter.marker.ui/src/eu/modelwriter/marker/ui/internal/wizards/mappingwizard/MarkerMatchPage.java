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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkerMatchPage extends WizardPage {
  public static ArrayList<IMarker> checkedElements;
  public static CheckboxTreeViewer markTreeViewer = null;
  public static IMarker selectedMarker;
  boolean isIndirect;

  public MarkerMatchPage(IMarker selectedMarker, boolean isIndirect) {
    super("Markers Page");
    this.setTitle("Markers");
    this.setDescription("\"" + MarkUtilities.getText(selectedMarker) + "\"");
    MarkerMatchPage.selectedMarker = selectedMarker;
    this.isIndirect = isIndirect;
  }

  @Override
  public void createControl(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));
    this.setControl(composite);

    this.initCheckedElements();

    MarkerMatchPage.markTreeViewer = new CheckboxTreeViewer(composite);
    MarkerMatchPage.markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    WizardTreeViewContentProvider treeViewerContentProvider = new WizardTreeViewContentProvider();

    MarkerMatchPage.markTreeViewer.setLabelProvider(new WizardTreeViewLabelProvider());
    MarkerMatchPage.markTreeViewer.setContentProvider(treeViewerContentProvider);
    ViewerFilter[] filter = new ViewerFilter[] {new WizardTreeViewFilter(this.isIndirect)};
    MarkerMatchPage.markTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());
    MarkerMatchPage.markTreeViewer.setFilters(filter);

    if (MappingWizard.beforeCheckedMarkers.size() != 0) {
      for (IMarker checkedMarker : MappingWizard.beforeCheckedMarkers) {
        MarkerMatchPage.markTreeViewer.setChecked(checkedMarker, true);
      }
    }

    MarkerMatchPage.markTreeViewer.addTreeListener(new ITreeViewerListener() {

      @Override
      public void treeCollapsed(TreeExpansionEvent event) {}

      @Override
      public void treeExpanded(TreeExpansionEvent event) {

        final Object element = event.getElement();
        final Object[] children = treeViewerContentProvider.getChildren(element);
        for (Object child : children) {

          for (IMarker checkedMarker : MarkerMatchPage.checkedElements) {
            if (child instanceof IMarker && MarkUtilities.compare(checkedMarker, (IMarker) child)) {
              MarkerMatchPage.markTreeViewer.setChecked(child, true);
            }
          }
        }
      }
    });

    // When user checks a checkbox in the tree, check all its children
    MarkerMatchPage.markTreeViewer.addCheckStateListener(new ICheckStateListener() {
      @Override
      public void checkStateChanged(CheckStateChangedEvent event) {
        if (event.getChecked()) {
          // . . . check all its children
          if (event.getElement() instanceof IProject && !((IProject) event.getElement()).isOpen()) {
            return;
          }
          MarkerMatchPage.markTreeViewer.setSubtreeChecked(event.getElement(), true);
          if (event.getElement() instanceof IResource) {
            IResource iResource = (IResource) event.getElement();
            for (IMarker iMarker : MarkerFactory.findMarkers(iResource)) {
              if (MarkUtilities.getGroupId(iMarker) != null
                  && MarkUtilities.getLeaderId(iMarker) == null) {
                continue;
              }
              if (MarkUtilities.getType(MarkerMatchPage.selectedMarker) != null) {
                if (MarkUtilities.getType(iMarker) != null) {
                  for (String type : WizardTreeViewFilter.suitableTypes) {
                    if (type.substring(type.indexOf("/") + 1)
                        .equals(MarkUtilities.getType(iMarker))) {
                      if (!MarkerMatchPage.checkedElements.contains(iMarker)
                          && !MarkUtilities.compare(iMarker, MarkerMatchPage.selectedMarker)) {
                        MarkerMatchPage.checkedElements.add(iMarker);
                      }
                    }
                  }
                }
              } else {
                if (!MarkerMatchPage.checkedElements.contains(iMarker)
                    && !MarkUtilities.compare(iMarker, MarkerMatchPage.selectedMarker)) {
                  MarkerMatchPage.checkedElements.add(iMarker);
                }
              }
            }
          } else if (event.getElement() instanceof IMarker) {
            IMarker iMarker = (IMarker) event.getElement();
            MarkerMatchPage.checkedElements.add(iMarker);
          }
        } else {
          if (event.getElement() instanceof IProject && !((IProject) event.getElement()).isOpen()) {
            return;
          }
          MarkerMatchPage.markTreeViewer.setSubtreeChecked(event.getElement(), false);
          if (event.getElement() instanceof IResource) {
            IResource iResource = (IResource) event.getElement();
            for (IMarker iMarker : MarkerFactory.findMarkers(iResource)) {
              Iterator<IMarker> iter = MarkerMatchPage.checkedElements.iterator();
              while (iter.hasNext()) {
                IMarker checkedMarker = iter.next();
                try {
                  if (checkedMarker.getAttribute(IMarker.SOURCE_ID)
                      .equals(iMarker.getAttribute(IMarker.SOURCE_ID))) {
                    iter.remove();
                    break;
                  }
                } catch (CoreException e) {
                  e.printStackTrace();
                }
              }
            }
          } else if (event.getElement() instanceof IMarker) {
            IMarker iMarker = (IMarker) event.getElement();
            Iterator<IMarker> iter = MarkerMatchPage.checkedElements.iterator();
            while (iter.hasNext()) {
              IMarker checkedMarker = iter.next();
              try {
                if (checkedMarker.getAttribute(IMarker.SOURCE_ID)
                    .equals(iMarker.getAttribute(IMarker.SOURCE_ID))) {
                  iter.remove();
                  break;
                }
              } catch (CoreException e) {
                e.printStackTrace();
              }
            }
          }
        }
        MarkerMatchPage.this.setPageComplete(true);
      }
    });

    markTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        Object firstElement = selection.getFirstElement();
        if (markTreeViewer.isExpandable(firstElement)) {
          boolean expanded = markTreeViewer.getExpandedState(firstElement);
          markTreeViewer.setExpandedState(firstElement, !expanded);
        }

      }
    });

    Button filterButton = new Button(composite, SWT.CHECK);
    filterButton.setText("&Show only files that contain Marker(s)");
    filterButton.setSelection(true);

    filterButton.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent event) {
        boolean isPressed = ((Button) event.widget).getSelection();
        if (isPressed) {
          MarkerMatchPage.markTreeViewer.setFilters(filter);
        } else {
          MarkerMatchPage.markTreeViewer.resetFilters();
        }
      }
    });
  }

  protected void initCheckedElements() {
    if (this.isIndirect) {
      MappingWizard.beforeCheckedMarkers = AlloyUtilities.getSecondSideMarkerIdsByMarkerAndRelation(
          selectedMarker, RelationsWizardPage.selectedRelation.substring(0,
              RelationsWizardPage.selectedRelation.indexOf(" ")));
    } else {
      MappingWizard.beforeCheckedMarkers =
          AlloyUtilities.getSecondSideMarkerIdsByMarkerAndRelationV2(selectedMarker);
    }
    MarkerMatchPage.checkedElements = new ArrayList<>(MappingWizard.beforeCheckedMarkers);
  }
}
