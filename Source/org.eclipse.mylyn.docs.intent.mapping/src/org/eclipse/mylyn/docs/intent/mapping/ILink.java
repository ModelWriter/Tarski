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
 * Connect two {@link ILocation}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface ILink extends IMappingElement {

	/**
	 * Status a {@link ILink} can {@link ILink#getStatus() have}.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static enum LinkStatus {

		/**
		 * The {@link ILink} is valid.
		 */
		VALID,

		/**
		 * The {@link ILink} {@link ILink#getSource() source} has been changed.
		 */
		CHANGED_SOURCE,

		/**
		 * The {@link ILink} {@link ILink#getTarget() target} has been changed.
		 */
		CHANGED_TARGET,

		/**
		 * The {@link ILink} {@link ILink#getSource() source} has been deleted.
		 */
		DELETED_SOURCE,

		/**
		 * The {@link ILink} {@link ILink#getTarget() target} has been deleted.
		 */
		DELETED_TARGET
	}

	/**
	 * Sets the {@link ILink#getDescription(String) description} of the {@link ILink}.
	 * 
	 * @param description
	 *            the {@link ILink#getDescription(String) description}
	 */
	void setDescription(String description);

	/**
	 * Gets the description of the {@link ILink}.
	 * 
	 * @return the description of the {@link ILink}
	 */
	String getDescription();

	/**
	 * Gets the {@link LinkStatus} of the {@link ILink}.
	 * 
	 * @return the {@link LinkStatus} of the {@link ILink}
	 */
	LinkStatus getLinkStatus();

	/**
	 * Sets the {@link ILink#getSource() source} {@link ILocation} of the {@link ILink}.
	 * 
	 * @param location
	 *            the {@link ILink#getSource() source} {@link ILocation}
	 */
	void setSource(ILocation location);

	/**
	 * Gets the source {@link ILocation}.
	 * 
	 * @return the source {@link ILocation}s
	 */
	ILocation getSource();

	/**
	 * Sets the {@link ILink#getTarget() target} {@link ILocation} of the {@link ILink}.
	 * 
	 * @param location
	 *            the {@link ILink#getTarget() target} {@link ILocation}
	 */
	void setTarget(ILocation location);

	/**
	 * Gets the target {@link ILocation} if the {@link ILink}.
	 * 
	 * @return the target {@link ILocation} if the {@link ILink}
	 */
	ILocation getTarget();

	/**
	 * {@link ILink#getStatus() Marks} the {@link ILink} as {@link LinkStatus#VALID valid}.
	 */
	void markAsValid();

	/**
	 * Adds a {@link ILinkListener}.
	 * 
	 * @param listener
	 *            the {@link ILinkListener} to add
	 */
	void addListener(ILinkListener listener);

	/**
	 * Removes a {@link ILinkListener}.
	 * 
	 * @param listener
	 *            the {@link ILinkListener} to remove
	 */
	void removeListener(ILinkListener listener);

}
