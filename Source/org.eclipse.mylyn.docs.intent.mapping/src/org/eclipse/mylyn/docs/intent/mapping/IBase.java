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

import java.util.List;

/**
 * A base stores root {@link ILocation}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IBase extends IMappingElement {

	/**
	 * Sets the {@link IBase#getName() name} of the {@link IBase}.
	 * 
	 * @param name
	 *            the name of the IBase
	 */
	void setName(String name);

	/**
	 * Gets the name of the {@link IBase}.
	 * 
	 * @return the name of the {@link IBase}
	 */
	String getName();

	/**
	 * Gets the {@link ILocation} with no {@link ILocation#getContainer() container}.
	 * 
	 * @return the {@link ILocation} with no {@link ILocation#getContainer() container}
	 */
	List<ILocation> getRootLocations();

	/**
	 * Adds a {@link IBaseListener}.
	 * 
	 * @param listener
	 *            the {@link IBaseListener} to add
	 */
	void addListener(IBaseListener listener);

	/**
	 * Removes a {@link IBaseListener}.
	 * 
	 * @param listener
	 *            the {@link IBaseListener} to remove
	 */
	void removeListener(IBaseListener listener);

	/**
	 * Gets the {@link LocationFactory} use to create instances of {@link ILocation} for this {@link IBase}.
	 * 
	 * @return the {@link LocationFactory} use to create instances of {@link ILocation} for this {@link IBase}
	 */
	LocationFactory getLocationFactory();

}
