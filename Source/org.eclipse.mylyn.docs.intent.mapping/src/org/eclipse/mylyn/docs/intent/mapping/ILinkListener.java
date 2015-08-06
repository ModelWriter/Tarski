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

import org.eclipse.mylyn.docs.intent.mapping.ILink.LinkStatus;

/**
 * Listen to {@link ILink} changes.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface ILinkListener {

	/**
	 * Stub implementation.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static class Stub implements ILinkListener {

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILinkListener#descriptionChanged(java.lang.String)
		 */
		public void descriptionChanged(String description) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILinkListener#statusChanged(org.eclipse.mylyn.docs.intent.mapping.ILink.LinkStatus)
		 */
		public void statusChanged(LinkStatus status) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILinkListener#sourceChanged(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void sourceChanged(ILocation source) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILinkListener#targetChanged(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void targetChanged(ILocation target) {
			// nothing to do here
		}

	}

	/**
	 * Notifies when the {@link ILink#getDescription() description} is changed.
	 * 
	 * @param description
	 *            the new {@link ILink#getDescription() description}
	 */
	void descriptionChanged(String description);

	/**
	 * Notifies when the {@link ILink#getStatus() status} is changed.
	 * 
	 * @param status
	 *            the new {@link ILink#getStatus() status}
	 */
	void statusChanged(LinkStatus status);

	/**
	 * Notifies when the {@link ILink#getSource() source} is changed.
	 * 
	 * @param source
	 *            the new {@link ILink#getSource() source}
	 */
	void sourceChanged(ILocation source);

	/**
	 * Notifies when the {@link ILink#getTarget() target} is changed.
	 * 
	 * @param target
	 *            the new {@link ILink#getTarget() target}
	 */
	void targetChanged(ILocation target);

}
