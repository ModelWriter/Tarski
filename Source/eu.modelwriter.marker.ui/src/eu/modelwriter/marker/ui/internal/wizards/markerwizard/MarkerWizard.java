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
package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.internal.CreateMarkerWithType;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkerWizard extends Wizard {

  private MarkerPage page;
  private ISelection selection;
  private IFile file;
  private IMarker marker;

  public MarkerWizard(IMarker marker) {
    this.marker = marker;
  }

  public MarkerWizard(ISelection selection, IFile file) {
    super();
    this.selection = selection;
    this.file = file;
  }

  @Override
  public void addPages() {
    this.page = new MarkerPage();
    super.addPages();
    this.addPage(this.page);
  }

  @Override
  public String getWindowTitle() {
    return "Marking with Tag";
  }

  @Override
  public boolean performFinish() {
    if (MarkerPage.markTreeViewer.getTree().getSelection().length == 1) {
      if (MarkerPage.markTreeViewer.getTree().getSelection()[0].getText().endsWith("{abs}")) {
        MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Marker Type Information", null,
                "Selected type is not appropriate because it is marked as Abstact",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
        return false;
      }
      if (!MarkerPage.markTreeViewer.getTree().getItems()[0]
          .equals(MarkerPage.markTreeViewer.getTree().getSelection()[0])) {
        if (this.selection != null) {
          CreateMarkerWithType.createMarker(this.file, this.selection,
              MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
              "Marker Type Information", null, "Marker has been created with selected type",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        } else {
          try {
            AlloyUtilities.removeAllRelationsOfMarker(this.marker);
            AlloyUtilities.removeRelationOfMarker(this.marker);
            Object groupId = this.marker.getAttribute(MarkUtilities.GROUP_ID);
            if (groupId != null) {
              List<IMarker> list =
                  MarkerFactory.findMarkersByGroupId(this.marker.getResource(), (String) groupId);
              for (IMarker iMarker : list) {
                AlloyUtilities.removeTypeFromMarker(iMarker);
                MarkUtilities.setType(iMarker,
                    MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
                AlloyUtilities.addTypeToMarker(iMarker);
              }
            } else {
              AlloyUtilities.removeTypeFromMarker(this.marker);
              MarkUtilities.setType(this.marker,
                  MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
              AlloyUtilities.addTypeToMarker(this.marker);
            }
          } catch (CoreException e) {
            e.printStackTrace();
          }

          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
              "Marker Type Information", null, "Selected type added to selected marker",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        }
        return true;
      } else {
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
            "Marker Type Information", null, "Please select a valid marker type.",
            MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
        return false;
      }
    } else {
      MessageDialog dialog =
          new MessageDialog(MarkerActivator.getShell(), "Marker Type Information", null,
              "Please select one marker type.", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return false;
    }
  }
}
