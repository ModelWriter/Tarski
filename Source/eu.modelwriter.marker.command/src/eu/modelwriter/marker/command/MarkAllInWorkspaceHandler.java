package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizard.markallinwswizard.MarkAllInWsWizard;

public class MarkAllInWorkspaceHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    Job job = new Job("Mark All In Workspace") {
      // TODO job içinde bir progress bar oluşturulmalı
      @Override
      protected IStatus run(IProgressMonitor monitor) {
        // try {
        // SubMonitor subMonitor = SubMonitor.convert(monitor, "Preparing", 5000);
        // for (int i = 0; i < 50 && !subMonitor.isCanceled(); i++) {
        // if (i == 10) {
        // subMonitor.subTask("Doing smth");
        // } else if (i == 12) {
        // checkDozen(subMonitor.newChild(100));
        // continue;
        // } else if (i == 25) {
        // subMonitor.subTask("Doing smth else");
        // } else if (i == 40) {
        // subMonitor.subTask("Nearly there");
        // }
        //
        // if (monitor.isCanceled()) {
        // return Status.CANCEL_STATUS;
        // }
        // Thread.sleep(100);
        // subMonitor.worked(100);
        // }
        // } catch (InterruptedException e) {
        // System.out.println("Interrupted.");
        // e.printStackTrace();
        // } finally {
        // if (monitor != null) {
        // monitor.done();
        // }
        // }
        Display.getDefault().asyncExec(new Runnable() {

          @Override
          public void run() {
            MessageDialog.openInformation(null, "hello", "world");
          }
        });
        return Status.OK_STATUS;
      }
    };

    // job.addJobChangeListener(new JobChangeAdapter() {
    // @Override
    // public void done(IJobChangeEvent event) {
    // if (event.getResult().isOK()) {
    // System.out.println("Job completed successfully");
    // } else {
    // System.out.println("Job did not complete successfully");
    // }
    // }
    // });

    // job.setSystem(true);
    job.setPriority(Job.SHORT);
    job.schedule();

    ISelection selection = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
        .getSelectionService().getSelection();
    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);
    if (selection instanceof ITextSelection) {
      ITextSelection textSelection = (ITextSelection) selection;
      if (MarkerFactory.findMarkerWithAbsolutePosition(file, textSelection.getOffset(),
          textSelection.getOffset() + textSelection.getLength()) != null) {

        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
            null, "In these area, there is already a marker", MessageDialog.WARNING,
            new String[] {"OK"}, 0);
        dialog.open();

        return null;
      } else {
        MarkAllInWsWizard markAllWsWizard = new MarkAllInWsWizard(textSelection, file);
        WizardDialog selectionDialog =
            new WizardDialog(MarkerActivator.getShell(), markAllWsWizard);
        if (selectionDialog.open() == Window.CANCEL) {
          return null;
        }
      }
    }
    return null;
  }

  // private void checkDozen(IProgressMonitor monitor) {
  // if (monitor == null) {
  // monitor = new NullProgressMonitor();
  // }
  // try {
  // monitor.beginTask("Checking a dozen", 12);
  // for (int i = 0; i < 12; i++) {
  // Thread.sleep(10);
  // monitor.worked(i);
  // }
  // } catch (InterruptedException e) {
  // System.out.println("Interrupted.");
  // } finally {
  // monitor.done();
  // }
  // }
}
