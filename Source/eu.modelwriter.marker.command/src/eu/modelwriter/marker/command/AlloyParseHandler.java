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
package eu.modelwriter.marker.command;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.alloy.AlloyParser;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AlloyParseHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.parsealloy";

  public AlloyParseHandler() {}

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {

    final MessageDialog warningdialog =
        new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
            "If new alloy file will be parsed , your all marker type will be lost !",
            MessageDialog.WARNING, new String[] {"OK", "Cancel"}, 0);
    if (warningdialog.open() != 0) {
      return null;
    }


    final String result;
    final ISelection selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    if (selection != null && selection instanceof TreeSelection) {
      final TreeSelection treeSelection = (TreeSelection) selection;
      final IFile file = (IFile) treeSelection.getFirstElement();
      result = file.getLocation().makeAbsolute().toOSString();
    } else {
      final FileDialog dialog =
          new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
      dialog.setFilterExtensions(new String[] {"*.mw", "*.als"});
      result = dialog.open();
      if (result == null) {
        return null;
      }
    }

    this.removeTypesFromMarkers();

    final AlloyParser parser = new AlloyParser(result);
    final ArrayList<MarkerTypeElement> roots = parser.getTypes();
    final ArrayList<String> rels = parser.getRels();

    MarkerPage.settings.put("alloyFile", result);
    final MarkerTypeElement systemRoot = new MarkerTypeElement("universe");
    for (final MarkerTypeElement root : roots) {
      systemRoot.getChildren().add(root);
    }

    try {
      MarkerPage.settings.put("universe", Serialization.getInstance().toString(systemRoot));
      MarkerPage.settings.put("rels", Serialization.getInstance().toString(rels));
    } catch (final IOException e1) {
      e1.printStackTrace();
    }
    if (Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getActivePage()
        .findView(Visualization.ID) != null) {
      Visualization.showViz(Visualization.container);
    }
    return null;
  }

  private void removeTypesFromMarkers() {
    for (final IResource iResource : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
      boolean isClosed = false;
      try {
        if (!((IProject) iResource).isOpen()) {
          isClosed = true;
          ((IProject) iResource).open(new NullProgressMonitor());
        }
        for (IMarker iMarker : MarkerFactory.findMarkersAsArrayList(iResource)) {
          if (MarkUtilities.getType(iMarker) != null) {
            if (MappingWizard.findTargetCount(iMarker) != 0) {
              iMarker = MappingWizard.convertAnnotationType(iMarker, false, true);
            }
            MarkUtilities.setType(iMarker, null);
            AlloyUtilities.removeTypeFromMarker(iMarker);
          }
        }
        if (isClosed == true) {
          ((IProject) iResource).close(new NullProgressMonitor());
        }
      } catch (final CoreException e) {
        e.printStackTrace();
      }
    }
  }
}
