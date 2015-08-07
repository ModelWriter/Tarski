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
package org.eclipse.mylyn.docs.intent.mapping.text;

import org.eclipse.mylyn.docs.intent.mapping.ILocation;

/**
 * An {@link ILocation} for text content.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface ITextLocation extends ILocation {

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the text
	 */
	void setText(String text);

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	String getText();

	/**
	 * Sets the offset of {@link ITextLocation#getText() text} in the surrounding text.
	 * 
	 * @param offset
	 *            the offset
	 */
	void setTextOffset(int offset);

	/**
	 * Gets the offset of {@link ITextLocation#getText() text} in the surrounding text.
	 * 
	 * @return the offset of {@link ITextLocation#getText() text} in the surrounding text
	 */
	int getTextOffset();

}
