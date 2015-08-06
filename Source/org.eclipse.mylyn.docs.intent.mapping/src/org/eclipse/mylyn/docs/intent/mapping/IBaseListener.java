/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.mapping;

/**
 * Listen to {@link IBase} changes.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IBaseListener {

	/**
	 * Stub implementation.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static class Stub implements IBaseListener {

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.IBaseListener#nameChanged(java.lang.String)
		 */
		public void nameChanged(String name) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.IBaseListener#rootLocationAdded(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void rootLocationAdded(ILocation location) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.IBaseListener#rootLocationRemoved(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void rootLocationRemoved(ILocation location) {
			// nothing to do here
		}

	}

	/**
	 * Notifies when the {@link IBase#getName() name} has been changed.
	 * 
	 * @param name
	 *            the new {@link IBase#getName() name}
	 */
	void nameChanged(String name);

	/**
	 * Notifies when the {@link IBase#getRootLocations() root} {@link ILocation} is added.
	 * 
	 * @param location
	 *            the added {@link IBase#getRootLocations() root} {@link ILocation}
	 */
	void rootLocationAdded(ILocation location);

	/**
	 * Notifies when the {@link IBase#getRootLocations() root} {@link ILocation} is removed.
	 * 
	 * @param location
	 *            the removed {@link IBase#getRootLocations() root} {@link ILocation}
	 */
	void rootLocationRemoved(ILocation location);

}
