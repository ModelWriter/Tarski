package eu.modelwriter.writer.markers.wizards.internal;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.actions.NewWizardAction;
import org.eclipse.ui.internal.dialogs.WizardActivityFilter;
import org.eclipse.ui.texteditor.AbstractTextEditor;

import eu.modelwriter.writer.markers.MarkerActivator;

public class MarkerMappingAction implements IEditorActionDelegate {

	public MarkerMappingAction() {
		super();
	}

	@Override
	public void run(IAction action) {
		IWorkspace workSpace = ResourcesPlugin.getWorkspace();
		
		IEditorPart editorPart = MarkerActivator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editorPart instanceof AbstractTextEditor){
			IEditorSite editorSite = editorPart.getEditorSite();
			if (editorSite != null){
				ISelectionProvider selectionProvider = editorSite.getSelectionProvider();
				if (selectionProvider != null){
					ISelection selection = selectionProvider.getSelection();
					/*NewWizardAction wizard = new NewWizardAction(MarkerActivator.getActiveWorkbenchWindow());
					wizard.setWizardWindowTitle("abc");
					wizard.run();*/
					WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), new MappingWizard());
					
					if (dialog.open() == org.eclipse.jface.window.Window.OK){
						System.out.println("Ok pressed");
					}
					else{
						System.out.println("Cancel pressed");
					}
				}
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// TODO Auto-generated method stub

	}

}
