package eu.modelwriter.projectmanagement.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import eu.modelwriter.projectmanagement.dialogs.PasswordDialog;
import eu.modelwriter.projectmanagement.github.Constants;
import eu.modelwriter.projectmanagement.github.deliverables.FetchSoftwareRequirements;
import eu.modelwriter.projectmanagement.github.deliverables.SoftwareRequirementDocument;

public class CreateSoftwareRequirementDocument extends AbstractHandler  {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		//Password Dialog
		PasswordDialog dialog = new PasswordDialog(window.getShell());
		// get the new values from the dialog
		if (dialog.open() == Window.OK) {
			Constants.USERNAME = dialog.getUser();
			Constants.PASSWORD = dialog.getPassword();	      
			
			//Progress Monitor Dialog 1
			ProgressMonitorDialog pmd = new ProgressMonitorDialog(window.getShell());
			pmd.setCancelable(true);
			pmd.create();

			try {
				pmd.run(true, true, FetchSoftwareRequirements.getInstance());
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				MessageDialogError(window);
			} catch (InterruptedException e) {
				e.printStackTrace();
				MessageDialogError(window);
			}	      
			
			//List Selection Dialog
			ListSelectionDialog lsd = new ListSelectionDialog(window.getShell(), 
					FetchSoftwareRequirements.getInstance().getIssues(), new ArrayContentProvider(), new LabelProvider(), 
					"Please select from software requirements to add in the document");
			lsd.setInitialSelections(FetchSoftwareRequirements.getInstance().getIssues().toArray());
			lsd.setTitle("Select Requirements :");

			List<Issue> selectedIssues = null;
			if (lsd.open() == Window.OK) {
				// Get the input children.
				Object[] res = lsd.getResult();
				// Build a list of selected children.
				if (res != null) {
					selectedIssues = new ArrayList<Issue>(res.length);
					  for (int i=0; i < res.length; i++) {
						  selectedIssues.add((Issue)res[i]);
					  }
				}else
					MessageDialogAborted(window);
			}else
				MessageDialogAborted(window);
			
			//Progress Monitor Dialog 2
			pmd = new ProgressMonitorDialog(window.getShell());
			pmd.setCancelable(true);
			pmd.create();

			try {
				pmd.run(true, true, new SoftwareRequirementDocument(selectedIssues));
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				MessageDialogError(window);
			} catch (InterruptedException e) {
				e.printStackTrace();
				MessageDialogError(window);
			}	
			
		}else
			MessageDialogAborted(window);	
	
		MessageDialogSuccessful(window);
		
		return null;
	}
	
	public void MessageDialogAborted(IWorkbenchWindow window){
		MessageDialog.openWarning(
				window.getShell(),
				"ModelWriter Project Management",
				"The user has aborted the document creation process");
	}
	public void MessageDialogSuccessful(IWorkbenchWindow window ){
		MessageDialog.openInformation(
				window.getShell(),
				"ModelWriter Project Management",
				"The SRD document has been created successfully");
	}
	public void MessageDialogError(IWorkbenchWindow window ){
		MessageDialog.openError(
				window.getShell(),
				"ModelWriter Project Management",
				"An error is occured");
	}

}
