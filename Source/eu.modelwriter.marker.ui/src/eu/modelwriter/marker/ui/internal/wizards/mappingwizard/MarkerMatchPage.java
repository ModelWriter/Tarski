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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
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

import eu.modelwriter.marker.internal.MarkElementUtilities;

public class MarkerMatchPage extends WizardPage {
  public static CheckboxTreeViewer markTreeViewer = null;

  public MarkerMatchPage() {
    super("Mapping Markers");
    setTitle("Map Markers");
  }

  @Override
  public void createControl(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));
    setControl(composite);

    markTreeViewer = new CheckboxTreeViewer(composite);
    markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    WizardTreeViewContentProvider treeViewerContentProvider = new WizardTreeViewContentProvider();

    markTreeViewer.setLabelProvider(new WizardTreeViewLabelProvider());
    markTreeViewer.setContentProvider(treeViewerContentProvider);
    ViewerFilter[] filter = new ViewerFilter[] {new WizardTreeViewFilter()};
    markTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());
    markTreeViewer.setFilters(filter);

    if (MappingWizard.beforeCheckedMarkers.size() != 0) {
      for (IMarker checkedMarker : MappingWizard.beforeCheckedMarkers) {
        markTreeViewer.setChecked(checkedMarker, true);
      }
    }

    markTreeViewer.addTreeListener(new ITreeViewerListener() {

      @Override
      public void treeExpanded(TreeExpansionEvent event) {

        final Object element = event.getElement();
        final Object[] children = treeViewerContentProvider.getChildren(element);
        for (Object child : children) {

          for (IMarker checkedMarker : MappingWizard.beforeCheckedMarkers) {
            if (child instanceof IMarker
                && MarkElementUtilities.compare(checkedMarker, (IMarker) child)) {
              markTreeViewer.setChecked(child, true);
            }
          }
        }
      }

      @Override
      public void treeCollapsed(TreeExpansionEvent event) {}
    });

    // When user checks a checkbox in the tree, check all its children
    setPageComplete(false);
    markTreeViewer.addCheckStateListener(new ICheckStateListener() {
      public void checkStateChanged(CheckStateChangedEvent event) {
        if (event.getChecked()) {
          // . . . check all its children
          if ((event.getElement() instanceof IProject && !((IProject) event.getElement()).isOpen()))
            return;
          markTreeViewer.setSubtreeChecked(event.getElement(), true);
        } else {
          if ((event.getElement() instanceof IProject && !((IProject) event.getElement()).isOpen()))
            return;
          markTreeViewer.setSubtreeChecked(event.getElement(), false);
          // if (event.getElement() instanceof IResource) {
          // IResource iResource = (IResource) event.getElement();
          // for (IMarker iMarker : MarkerFactory.findMarkers(iResource)) {
          // @SuppressWarnings("rawtypes")
          // Iterator iter = checkedElements.iterator();
          // while (iter.hasNext()) {
          // Object object = (Object) iter.next();
          // try {
          // if (((MarkElement) object).getiMarker().getAttribute(IMarker.SOURCE_ID)
          // .equals(iMarker.getAttribute(IMarker.SOURCE_ID))) {
          // iter.remove();
          // break;
          // }
          // } catch (CoreException e) {
          // e.printStackTrace();
          // }
          // }
          // }
          // } else if (event.getElement() instanceof IMarker) {
          // IMarker iMarker = (IMarker) event.getElement();
          // @SuppressWarnings("rawtypes")
          // Iterator iter = checkedElements.iterator();
          // while (iter.hasNext()) {
          // Object object = (Object) iter.next();
          // try {
          // if (((MarkElement) object).getiMarker().getAttribute(IMarker.SOURCE_ID)
          // .equals(iMarker.getAttribute(IMarker.SOURCE_ID))) {
          // iter.remove();
          // break;
          // }
          // } catch (CoreException e) {
          // e.printStackTrace();
          // }
          // }
          // }
        }
        setPageComplete(true);
      }
    });

    Button preserveCase_1 = new Button(composite, SWT.CHECK);
    preserveCase_1.setText("&Show only files that contain Marker(s)");
    preserveCase_1.setSelection(true);

    preserveCase_1.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        boolean preserveCase = ((Button) event.widget).getSelection();
        if (preserveCase) {
          markTreeViewer.setFilters(filter);
        } else {
          markTreeViewer.resetFilters();
        }
      }
    });
  }
}
