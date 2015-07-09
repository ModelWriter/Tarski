package eu.modelwriter.writer.markers.wizards.internal;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.texteditor.AbstractTextEditor;

import eu.modelwriter.writer.markers.MarkerActivator;

public class MarkerMappingAction implements IEditorActionDelegate {

	public MarkerMappingAction() {
		super();
	}

	@Override
	public void run(IAction action) {
		IEditorPart editorPart = MarkerActivator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		if (editorPart instanceof AbstractTextEditor) {
			IEditorSite editorSite = editorPart.getEditorSite();
			if (editorSite != null) {
				ISelectionProvider selectionProvider = editorSite.getSelectionProvider();
				if (selectionProvider != null) {
					MappingWizard mappingWizard = new MappingWizard();
					WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), mappingWizard);

					if (dialog.open() == org.eclipse.jface.window.Window.OK) {
						System.out.println("Ok pressed");
					} else {
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
