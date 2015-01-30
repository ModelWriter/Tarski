package org.eclipse.emf.doc2model.documents;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Logger {
	public static Logger INSTANCE = new Logger();

	private Logger() {
	}

	protected ILog getLogger() {
		return Documents.getDefault().getLog();
	}

	public void log(final Exception e) {
		log(e, IStatus.WARNING);
	}

	/**
	 * Log.
	 * 
	 * @param e
	 *            the exception
	 * @param severity
	 *            the severity
	 */
	public void log(Exception e, int severity) {
		IStatus status = new Status(severity, Documents.PLUGIN_ID, e
				.getMessage(), e);
		getLogger().log(status);
	}
}
