/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation and/or initial documentation
 *    ...
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.mapping;

/**
 * Adapt an {@link Object} into an {@link ILocation} and vis versa.
 * 
 * @param <T>
 *            the {@link Object} kind
 * @param <LT>
 *            the {@link ILocation} kind
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface ILocationAdapter<T, LT extends ILocation> {

	/**
	 * Gets the {@link ILocation} from the given {@link Object}.
	 * 
	 * @param object
	 *            the {@link Object} to adapt
	 * @return the {@link ILocation} from the given {@link Object}
	 */
	LT getLocation(T object);

	/**
	 * Gets the {@link Object} from the given {@link ILocation}.
	 * 
	 * @param location
	 *            the {@link ILocation} to adapt
	 * @return the {@link Object} from the given {@link ILocation}
	 */
	T getObject(LT location);

}
