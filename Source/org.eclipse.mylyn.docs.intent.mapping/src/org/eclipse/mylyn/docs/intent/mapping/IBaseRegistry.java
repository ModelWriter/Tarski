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

import java.util.Set;

/**
 * The {@link IBase} registry maintains a set of active {@link IBase}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IBaseRegistry {

	/**
	 * Registers an {@link IBase}.
	 * 
	 * @param base
	 *            the {@link IBase} to register
	 */
	void register(IBase base);

	/**
	 * Unregisters an {@link IBase}.
	 * 
	 * @param base
	 *            the {@link IBase} to unregister
	 */
	void unregister(IBase base);

	/**
	 * Gets the {@link Set} of registered {@link IBase}.
	 * 
	 * @return the {@link Set} of registered {@link IBase}
	 */
	Set<IBase> getBases();

	/**
	 * Adds an {@link IBaseRegistryListener}.
	 * 
	 * @param listener
	 *            the {@link IBaseRegistryListener} to add
	 */
	void addListener(IBaseRegistryListener listener);

	/**
	 * Removes an {@link IBaseRegistryListener}.
	 * 
	 * @param listener
	 *            the {@link IBaseRegistryListener} to remove
	 */
	void removeListener(IBaseRegistryListener listener);
}
