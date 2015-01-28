/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 * 
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Tristan Faure (Atos Origin) tristan.faure@atosorigin.com -
 * Initial API and implementation
 * 
 *****************************************************************************/
package org.topcased.doc2model.launcher.importWizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.topcased.doc2model.launcher.Activator;

public class Doc2ModelImportWizard extends Wizard implements IImportWizard
{

    Doc2ModelImportWizardPage mainPage;

    private String folderPath = null;

    private String documentPath = null;

    private String mapping = null;

    public Doc2ModelImportWizard()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    public boolean performFinish()
    {
        mainPage.performProcess();
        return mainPage.isValid();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
     * org.eclipse.jface.viewers.IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection selection)
    {
        setWindowTitle("File Import Wizard"); // NON-NLS-1
        setNeedsProgressMonitor(true);
        mainPage = new Doc2ModelImportWizardPage("Import document", Activator.getDefault().getPluginPreferences()); // NON
        // -
        // NLS
        // -
        // 1
        if (selection.getFirstElement() instanceof IFolder)
        {
            IFolder folder = (IFolder) selection.getFirstElement();
            folderPath = folder.getLocationURI().toString();
        }
        else if (selection.getFirstElement() instanceof IProject)
        {
            IProject project = (IProject) selection.getFirstElement();
            folderPath = project.getLocationURI().toString();
        }
        else if (selection.getFirstElement() instanceof IFile)
        {
            IFile f = (IFile) selection.getFirstElement();
            if (org.topcased.document.parser.Activator.getAvailableExtensions().contains(f.getFileExtension()))
            {
                documentPath = f.getLocationURI().toString();
            }
            else if (f.getFileExtension().endsWith("doc2modelmapping"))
            {
                mapping = f.getLocationURI().toString();
            }
        }
    }

    @Override
    public void createPageControls(Composite pageContainer)
    {
        super.createPageControls(pageContainer);
        if (folderPath != null)
        {
            mainPage.textfields.get(mainPage.TEMPORARY_EMF_TARGET_FOLDER).setText(folderPath);
        }
        if (mapping != null)
        {
            mainPage.textfields.get(mainPage.MAPPING_FILE).setText(mapping);
        }
        if (documentPath != null)
        {
            mainPage.textfields.get(mainPage.DOCUMENT_NAME).setText(documentPath);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages()
    {
        super.addPages();
        addPage(mainPage);
    }

}
