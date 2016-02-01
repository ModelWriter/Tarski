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
package eu.modelwriter.marker.ui.internal.wizards.markallinwswizard;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class MarkAllInWsPage extends WizardPage {

  public static CheckboxTreeViewer checkboxTreeViewer;
  private ArrayList<IProject> closedProjects;

  public MarkAllInWsPage() {
    super("Mark All In Workspace by Selection");
    this.closedProjects = new ArrayList<IProject>();
  }

  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    checkboxTreeViewer = new CheckboxTreeViewer(container, SWT.BORDER);

    MarkAllInWsContentProvider treeViewerContentProvider = new MarkAllInWsContentProvider();

    checkboxTreeViewer.setLabelProvider(new MarkAllInWsLabelProvider());
    checkboxTreeViewer.setContentProvider(treeViewerContentProvider);
    IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    for (IProject iProject : projects) {
      if (!iProject.isOpen()) {
        this.closedProjects.add(iProject);
      }
    }
    checkboxTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());
    checkboxTreeViewer.setGrayedElements(this.closedProjects.toArray());

    checkboxTreeViewer.addCheckStateListener(new ICheckStateListener() {

      @Override
      public void checkStateChanged(CheckStateChangedEvent event) {
        if (event.getChecked()) {
          if (((event.getElement() instanceof IProject)
              && !((IProject) event.getElement()).isOpen())) {
            return;
          }
          checkboxTreeViewer.setSubtreeChecked(event.getElement(), true);
        } else {
          if (((event.getElement() instanceof IProject)
              && !((IProject) event.getElement()).isOpen())) {
            return;
          }
          checkboxTreeViewer.setSubtreeChecked(event.getElement(), false);
        }
        setPageComplete(true);
      }
    });
  }
}
