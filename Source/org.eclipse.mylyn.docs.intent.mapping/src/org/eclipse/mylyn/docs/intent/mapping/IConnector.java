/*******************************************************************************
 * Copyright (c) 2015 {INITIAL COPYRIGHT OWNER} {OTHER COPYRIGHT OWNERS}.
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
 * The connector is in charge of {@link ILocation}.
 *
 * @param <L>
 *            the kind of location
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IConnector<L extends ILocation> {

	/**
	 * Tells if the given {@link ILocation} is a perfect match.
	 * 
	 * @param location
	 *            the {@link ILocation}
	 * @return <code>true</code> if the given {@link ILocation} is a perfect match, <code>false</code>
	 *         otherwise
	 */
	boolean isPerfectMatch(L location);

	/**
	 * Tries to reconcile the given {@link ILocation}.
	 * 
	 * @param location
	 *            the {@link ILocation}
	 * @return <code>true</code> if the given {@link ILocation} had been reconcile
	 */
	boolean reconcile(L location);

}
