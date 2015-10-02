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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.markdown.core.MarkdownLanguage;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkdownToReqIfDocumentBuilder;
import eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard.MarkdownToReqifWizard;

public class CreateReqifSpecFromMarkdownHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    if (selection instanceof ITextSelection) {
      ITextSelection textSelection = (ITextSelection) selection;
      MarkdownToReqIfDocumentBuilder builder = new MarkdownToReqIfDocumentBuilder();
      MarkupParser markupParser = new MarkupParser(new MarkdownLanguage());
      markupParser.setBuilder(builder);
      markupParser.parse(textSelection.getText());

      MarkdownToReqifWizard markdownToReqifWizard =
          new MarkdownToReqifWizard(builder.getRootSet(), builder.getNewlySpecObjects());

      WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), markdownToReqifWizard);

      if (dialog.open() == org.eclipse.jface.window.Window.OK) {
        System.out.println("Ok pressed");
      } else {
        System.out.println("Cancel pressed");
      }
    }
    return null;
  }
}
