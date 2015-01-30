package org.eclipse.emf.doc2model.ui.actions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.doc2model.engine.Doc2ModelEngine;
import org.eclipse.emf.doc2model.ui.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;

/**
 * The Class ImportJob.
 */
public class ImportJob extends Job implements
		org.eclipse.emf.doc2model.engine.contracts.ProgressionObserver {

	/** The document. */
	protected String document;

	/** The mapping. */
	protected String mapping;

	/** The EMF file target. */
	protected String EMFFileTarget;

	/** The monitor. */
	protected IProgressMonitor theMonitor = null;

	/** The uri src model. */
	protected URI uriSrcModel;

	/** The uri tmp emf. */
	protected URI uriTmpEMF;

	/** The uri mapping. */
	protected URI uriMapping;

	/** The result. */
	private IStatus result;

	/**
	 * Instantiates a new import job.
	 * 
	 * @param name
	 *            the name
	 * @param inputDocument
	 *            the input document
	 * @param mappingFile
	 *            the mapping file
	 * @param EMFFolder
	 *            the eMF folder
	 */
	public ImportJob(String name, String inputDocument, String mappingFile,
			String EMFFolder) {
		this(name, inputDocument, mappingFile, EMFFolder, false);

	}

	/**
	 * Instantiates a new import job.
	 * 
	 * @param name
	 *            the name
	 * @param inputDocument
	 *            the input document
	 * @param mappingFile
	 *            the mapping file
	 * @param EMFoutput
	 *            the eMF output
	 */
	public ImportJob(String name, String inputDocument, String mappingFile,
			String EMFoutput, boolean isFile) {
		super(name);
		document = inputDocument;
		mapping = mappingFile;
		EMFFileTarget = EMFoutput;
		// if (isFile)
		// {
		// EMFFileTarget = EMFoutput;
		// }
		// else
		// {
		// EMFFileTarget = EMFoutput + File.separator +
		// getDocumentName(inputDocument);
		// }
	}

	/**
	 * Return the name of the document.
	 * 
	 * @param inputDocument
	 *            the input document
	 * 
	 * @return the document name
	 */
	protected String getDocumentName(String inputDocument) {
		if (inputDocument.contains(File.separator)) {
			return inputDocument.substring(inputDocument
					.lastIndexOf(File.separator) + 1, inputDocument.length());
		} else if (inputDocument.contains("/")) {
			return inputDocument.substring(inputDocument.lastIndexOf("/") + 1,
					inputDocument.length());
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	protected IStatus run(IProgressMonitor monitor) {
		theMonitor = monitor;
		IStatus result = jobProcess(monitor);
		return result;
	}

	/**
	 * Job process.
	 * 
	 * @param monitor
	 *            the monitor
	 * 
	 * @return the custom status
	 */
	protected IStatus jobProcess(IProgressMonitor monitor) {
		return jobProcess(monitor, null);
	}

	protected IStatus jobProcess(IProgressMonitor monitor,
			HashMap<String, Boolean> config) {
		try {
			monitor.subTask("Import From Document");
			Doc2ModelEngine engine = new Doc2ModelEngine(document,
					EMFFileTarget, URI.createURI(mapping));
			engine.run();
		} catch (Exception e) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"An exception has been raised during the import", e);
		}
		return Status.OK_STATUS;
	}

	// private void displayFileProblem(final FileNotFoundException e)
	// {
	// Display.getDefault().asyncExec(new Runnable()
	// {
	// public void run()
	// {
	// MessageBox message = new
	// MessageBox(Display.getDefault().getActiveShell(), SWT.OK |
	// SWT.ICON_ERROR);
	// message.setMessage(e.getMessage());
	// message.setText("Error");
	// message.open();
	// }
	// });
	// }

	/**
	 * Assign uris.
	 */
	protected void assignURIs() {
		uriSrcModel = createURI(document);
		uriTmpEMF = createURI(EMFFileTarget);
		uriMapping = createURI(mapping);
	}

	/**
	 * Gets the file.
	 * 
	 * @param uri
	 *            the uri
	 * 
	 * @return the file
	 */
	protected String getFile(URI uri) {
		String s = null;
		s = uri.toFileString();
		if (s == null) {
			try {
				s = FileLocator.toFileURL(new URL(uri.toString())).getFile();
			} catch (MalformedURLException e) {
			} catch (IOException e) {
			}
		}
		if (s == null) {
			s = uri.toString();
		}
		return s;
	}

	/**
	 * Creates the uri.
	 * 
	 * @param string
	 *            the string
	 * 
	 * @return the uRI
	 */
	protected URI createURI(String string) {
		URI tmp;
		if (new File(string).exists()) {
			tmp = URI.createFileURI(string);
		} else {
			tmp = URI.createURI(string);
		}
		return tmp;
	}

	/**
	 * Gets the output file.
	 * 
	 * @return the output file
	 */
	protected URI getOutputFile() {
		return uriTmpEMF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.topcased.doc2model.parser.ProgressionObserver#isCanceled()
	 */
	public boolean isCanceled() {
		boolean cancel = theMonitor != null && theMonitor.isCanceled();
		if (cancel) {
			result = Status.CANCEL_STATUS;
		}
		return cancel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.topcased.doc2model.parser.ProgressionObserver#setMax(int)
	 */
	public void setMax(int max) {
		theMonitor.beginTask("Import in process", max);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.topcased.doc2model.parser.ProgressionObserver#worked(int)
	 */
	public void worked(int i) {
		theMonitor.worked(i);
	}

	/**
	 * Gets the input document.
	 * 
	 * @return the input document
	 */
	public String getInputDocument() {
		return document;
	}

	/**
	 * {@inheritDoc}
	 */
	public void warningOrErrorsOccurs() {
		Display d = PlatformUI.getWorkbench().getDisplay();
		d.syncExec(new Runnable() {
			public void run() {
				Shell s = PlatformUI.getWorkbench().getDisplay()
						.getActiveShell();
				MessageBox message = new MessageBox(s, SWT.YES | SWT.NO
						| SWT.ICON_WARNING | SWT.PRIMARY_MODAL);
				message
						.setMessage("Problems detected\nSee Error log For details\nDo you want to open it now ?");
				message.setText("Information");
				int answer = message.open();
				if (answer == SWT.YES) {
					openErrorLog();
				}
			}
		});
	}

	/**
	 * Open error log.
	 */
	private void openErrorLog() {
		IWorkbenchPage page = Workbench.getInstance()
				.getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			try {
				page.showView("org.eclipse.pde.runtime.LogView");
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyNoElementsFounded() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageBox message = new MessageBox(Display.getDefault()
						.getActiveShell(), SWT.OK | SWT.ICON_INFORMATION);
				message
						.setMessage("Generation can't be done with input document\nPlease check your document");
				message.setText("Information");
				message.open();
			}
		});
	}
}
