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
package eu.modelwriter.marker.ui.internal.preferences;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.alloy.AlloyParser;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewContentProvider;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewLabelProvider;

public class MarkerTypePreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
  private Table table;

  Label lblNewLabel;

  public MarkerTypePreferencePage() {}

  @Override
  protected Control createContents(final Composite parent) {
    final Composite container = new Composite(parent, SWT.NULL);

    final TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
    final Tree tree = treeViewer.getTree();
    tree.setBounds(10, 32, 232, 265);

    final MarkerTreeViewContentProvider treeViewerContentProvider =
        new MarkerTreeViewContentProvider();

    treeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    treeViewer.setContentProvider(treeViewerContentProvider);

    final TableViewer tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
    this.table = tableViewer.getTable();
    this.table.setBounds(254, 32, 335, 265);

    tableViewer.setContentProvider(ArrayContentProvider.getInstance());
    new RefColumn().addColumnTo(tableViewer);

    final Button btnParseAlloy = new Button(container, SWT.NONE);
    btnParseAlloy.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {

        final MessageDialog warningdialog =
            new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
                "If new alloy file will be parsed , your all marker type will be lost !",
                MessageDialog.WARNING, new String[] {"OK", "Cancel"}, 0);
        if (warningdialog.open() == 1) {
          return;
        }

        final FileDialog dialog = new FileDialog(
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
        dialog.setFilterExtensions(new String[] {"*.mw", "*.als"});
        final String result = dialog.open();
        if (result == null) {
          return;
        }

        for (final IResource iResource : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
          boolean isClosed = false;
          try {
            if (!((IProject) iResource).isOpen()) {
              isClosed = true;
              ((IProject) iResource).open(new NullProgressMonitor());
            }
            for (final IMarker iMarker : MarkerFactory.findMarkersAsArrayList(iResource)) {
              if (MarkUtilities.getType(iMarker) != null) {
                MarkUtilities.setType(iMarker, null);
              }
            }
            if (isClosed == true) {
              ((IProject) iResource).close(new NullProgressMonitor());
            }
          } catch (final CoreException e1) {
            e1.printStackTrace();
          }
        }

        MarkerPage.settings.put("alloyFile", result);

        final AlloyParser parser = new AlloyParser(result);
        final ArrayList<MarkerTypeElement> roots = parser.getTypes();
        final ArrayList<String> rels = parser.getRels();

        final MarkerTypeElement systemRoot = new MarkerTypeElement("universe");
        for (final MarkerTypeElement root : roots) {
          systemRoot.getChildren().add(root);
        }

        try {
          MarkerPage.settings.put("universe", Serialization.getInstance().toString(systemRoot));
          final Object[] array = new Object[1];
          array[0] = systemRoot;
          treeViewer.setInput(array);
          treeViewer.expandAll();
          MarkerPage.settings.put("rels", Serialization.getInstance().toString(rels));
          tableViewer.setInput(rels);
          // auto size columns
          final TableColumn[] columns = tableViewer.getTable().getColumns();
          for (int i = 0; i < columns.length; i++) {
            columns[i].pack();
          }
          MarkerTypePreferencePage.this.lblNewLabel.setText(result);
          MarkerTypePreferencePage.this.lblNewLabel.setToolTipText(result);
        } catch (final IOException e1) {
          e1.printStackTrace();
        }
      }
    });
    btnParseAlloy.setBounds(10, 303, 75, 25);
    btnParseAlloy.setText("Specification");

    final Label lblMarkerTypes = new Label(container, SWT.NONE);
    lblMarkerTypes.setBounds(10, 10, 75, 15);
    lblMarkerTypes.setText("Marker Types");

    final Label lblRelations = new Label(container, SWT.NONE);
    lblRelations.setBounds(254, 10, 55, 15);
    lblRelations.setText("Relations");

    this.lblNewLabel = new Label(container, SWT.NONE);
    this.lblNewLabel.setBounds(91, 308, 498, 49);
    if (MarkerPage.settings.get("alloyFile") != null) {
      this.lblNewLabel.setText(MarkerPage.settings.get("alloyFile"));
    }
    this.lblNewLabel.setToolTipText(MarkerPage.settings.get("alloyFile"));

    try {
      final String savedTree = MarkerPage.settings.get("universe");
      if (savedTree != null) {
        final Object[] array = new Object[1];
        array[0] = Serialization.getInstance().fromString(savedTree);
        treeViewer.setInput(array);
        treeViewer.expandAll();
      }

      final String rels = MarkerPage.settings.get("rels");
      if (rels != null) {
        tableViewer.setInput(Serialization.getInstance().fromString(rels));
        // auto size columns
        final TableColumn[] columns = tableViewer.getTable().getColumns();
        for (int i = 0; i < columns.length; i++) {
          columns[i].pack();
        }
      }
    } catch (final IOException e1) {
      e1.printStackTrace();
    } catch (final ClassNotFoundException e) {
      e.printStackTrace();
    }

    return container;
  }

  @Override
  public void init(final IWorkbench workbench) {}
}
