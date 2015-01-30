package org.eclipse.emf.doc2model.engine.contracts;

/**
 * Interface to notify parsing progression
 * 
 * @author tristan.faure@atosorigin.com
 */
public interface ProgressionObserver {
	/**
	 * This method notify the maximum number of elements
	 * 
	 * @param max
	 *            the max
	 */
	void setMax(int max);

	/**
	 * This method notify the process progression
	 * 
	 * @param i
	 *            the i
	 */
	void worked(int i);

	/**
	 * isCanceled
	 * 
	 * @return true, if the process is canceled
	 */
	boolean isCanceled();

	/**
	 * warningOrErrorsOccurs
	 * 
	 * this method is called when some elements have been logged
	 */
	void warningOrErrorsOccurs();

	/**
	 * notifyNoElementsFounded
	 * 
	 * this method is called when the generated model is empty
	 */
	void notifyNoElementsFounded();
}
