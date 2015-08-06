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
package org.eclipse.mylyn.docs.intent.mapping.tests;

import org.eclipse.mylyn.docs.intent.mapping.IBase;
import org.eclipse.mylyn.docs.intent.mapping.ILink;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.IScope;

/**
 * A factory creating instances to test.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IMappingFactory {

	/**
	 * Creates an {@link IBase}.
	 * 
	 * @return a new {@link IBase}
	 */
	IBase createBase();

	/**
	 * Creates an {@link ILink}.
	 * 
	 * @return a new {@link ILink}
	 */
	ILink createLink();

	/**
	 * Creates an {@link ILocation}.
	 * 
	 * @return a new {@link ILocation}
	 */
	ILocation createLocation();

	/**
	 * Creates an {@link IScope}.
	 * 
	 * @return a new {@link IScope}
	 */
	IScope createScope();

}
