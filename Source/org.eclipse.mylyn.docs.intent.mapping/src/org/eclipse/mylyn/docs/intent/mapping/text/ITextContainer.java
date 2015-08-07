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
package org.eclipse.mylyn.docs.intent.mapping.text;

import org.eclipse.mylyn.docs.intent.mapping.ILocation;

/**
 * Text container.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface ITextContainer extends ILocation {

	/**
	 * Sets the text corresponding to the container.
	 * 
	 * @param text
	 *            the text corresponding to the container
	 */
	void setText(String text);

	/**
	 * Gets the text corresponding to the container.
	 * 
	 * @return the text corresponding to the container
	 */
	String getText();

}
