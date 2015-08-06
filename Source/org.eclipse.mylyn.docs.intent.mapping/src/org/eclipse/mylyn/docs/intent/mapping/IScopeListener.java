/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    {INITIAL AUTHOR} - initial API and implementation and/or initial documentation
 *    ...
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.mapping;

/**
 * Listen to {@link IScope} changes.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IScopeListener {

	/**
	 * Stub implementation.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static class Stub implements IScopeListener {

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.IScopeListener#holderChanged(java.lang.String)
		 */
		public void holderChanged(ILocation location) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.IScopeListener#locationAdded(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void locationAdded(ILocation location) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.IScopeListener#locationRemoved(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void locationRemoved(ILocation location) {
			// nothing to do here
		}

	}

	/**
	 * Notifies when the {@link IScope#getHolder() holder} {@link ILocation} is changed.
	 * 
	 * @param location
	 *            the new {@link IScope#getHolder() holder} {@link ILocation}
	 */
	void holderChanged(ILocation location);

	/**
	 * Notifies when the {@link IScope#getLocations()} {@link ILocation} is added.
	 * 
	 * @param location
	 *            the added {@link IScope#getLocations()} {@link ILocation}
	 */
	void locationAdded(ILocation location);

	/**
	 * Notifies when the {@link IScope#getLocations()} {@link ILocation} is removed.
	 * 
	 * @param location
	 *            the removed {@link IScope#getLocations()} {@link ILocation}
	 */
	void locationRemoved(ILocation location);

}
