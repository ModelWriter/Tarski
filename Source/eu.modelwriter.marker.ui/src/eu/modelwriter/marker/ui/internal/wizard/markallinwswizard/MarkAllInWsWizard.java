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
package eu.modelwriter.marker.ui.internal.wizard.markallinwswizard;

import java.util.Scanner;
import java.util.UUID;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.IDE;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.typing.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.Activator;

public class MarkAllInWsWizard extends Wizard {

  private IFile file;
  private MarkAllInWsPage page;
  private ITextSelection textSelection;

  public MarkAllInWsWizard(ITextSelection textSelection, IFile file) {
    super();
    this.textSelection = textSelection;
    this.file = file;
  }

  @Override
  public void addPages() {
    page = new MarkAllInWsPage();
    super.addPages();
    this.addPage(page);
  }

  private void addToAlloyXML(IMarker mymarker) {
    if (AlloyUtilities.isExists()) {
      AlloyUtilities.addMarkerToRepository(mymarker);
    }
  }

  @Override
  public String getWindowTitle() {
    return "Mark All In Workspace";
  }

  @SuppressWarnings("static-access")
  @Override
  public boolean performFinish() {
    Object[] checkedElements = page.checkboxTreeViewer.getCheckedElements();
    String text = textSelection.getText();
    String leader_id = UUID.randomUUID().toString();
    boolean success = false;

    Image image = MarkerActivator.getDefault().getImageRegistry()
        .get(MarkerActivator.Images.IMAGE_MODELWRITER_ID);
    ProgressMonitorDialog pmd = new ProgressMonitorDialog(
        Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell());
    ProgressMonitorDialog.setDefaultImage(image);
    pmd.open();
    IProgressMonitor pmdmoni = pmd.getProgressMonitor();
    try {
      pmdmoni.beginTask("Marking", checkedElements.length);
      for (int i = 0; (i < checkedElements.length) && !pmdmoni.isCanceled(); i++) {
        try {
          if (checkedElements[i] instanceof IFile) {
            IFile iFile = (IFile) checkedElements[i];
            pmdmoni.subTask(iFile.getName());
            pmdmoni.worked(1);

            if (!iFile.getFileExtension().equals("xmi") && !iFile.getFileExtension().equals("ecore")
                && !iFile.getFileExtension().equals("reqif")) {
              String charSet = iFile.getCharset();
              Scanner scanner = new Scanner(iFile.getContents(), charSet);
              IDocument document = new Document(scanner.useDelimiter("\\A").next());
              scanner.close();

              String fullText = document.get();
              boolean hasLeader = false;
              int index = 0;
              int offset = 0;
              int lenght = textSelection.getLength();
              String id = UUID.randomUUID().toString();

              IEditorPart editor =
                  IDE.openEditor(Activator.getActiveWorkbenchWindow().getActivePage(), iFile);

              if (lenght != 0) {
                while ((offset = fullText.indexOf(text, index)) != -1) {
                  TextSelection nextSelection = new TextSelection(document, offset, lenght);
                  if (MarkerFactory.findMarkerByOffset(iFile, offset) == null) {
                    IMarker mymarker = MarkerFactory.createMarker(iFile, nextSelection);
                    MarkElementUtilities.setGroupId(mymarker, id);
                    if (!iFile.equals(this.file)) {
                      if (hasLeader == false) {
                        MarkElementUtilities.setLeaderId(mymarker, leader_id);
                        hasLeader = true;
                      }
                    } else {
                      if (textSelection.getOffset() == offset) {
                        MarkElementUtilities.setLeaderId(mymarker, leader_id);
                      }
                    }

                    addToAlloyXML(mymarker);
                    AnnotationFactory.addAnnotation(mymarker, editor,
                        AnnotationFactory.ANNOTATION_MARKING);
                  }
                  index = offset + lenght;
                }
              }
              success = true;
            } else {
              MessageDialog dialog =
                  new MessageDialog(MarkerActivator.getShell(), "Mark All In Workspace", null,
                      iFile.getName() + " doesn't supported for this command.",
                      MessageDialog.INFORMATION, new String[] {"OK"}, 0);
              dialog.open();
              page.checkboxTreeViewer.setChecked(iFile, false);
            }
          }
        } catch (CoreException e) {
          e.printStackTrace();
        }
      }
    } finally {
      pmdmoni.done();
    }
    pmd.close();

    if (success == true) {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark All In Workspace",
          null, "Selected project(s) have been marked by selected text", MessageDialog.INFORMATION,
          new String[] {"OK"}, 0);
      dialog.open();
      return true;
    } else {
      return false;
    }
  }
}
