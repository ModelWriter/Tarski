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

import org.eclipse.mylyn.docs.intent.mapping.IConnector;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.MappingUtils;
import org.eclipse.mylyn.docs.intent.mapping.MappingUtils.DiffMatch;

/**
 * Text {@link IConnector}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TextConnector implements IConnector<ITextContainer> {

	/**
	 * Updates the given {@link ITextContainer} with the given {@link ITextContainer#getText() text}.
	 * 
	 * @param container
	 *            the {@link ITextContainer}
	 * @param text
	 *            the {@link ITextContainer#getText() text}
	 */
	public void update(ITextContainer container, String text) {
		final String oldText = container.getText();
		final DiffMatch diff = MappingUtils.getDiffMatch(oldText, text);
		for (ILocation child : container.getContents()) {
			if (child instanceof ITextLocation) {
				final ITextLocation location = (ITextLocation)child;
				final int oldLength = location.getText().length();
				int oldOffset = location.getTextOffset();
				int newStartOffset = diff.getIndex(oldOffset);
				int newEndOffset = diff.getIndex(oldOffset + oldLength);
				location.setText(text.substring(newStartOffset, newEndOffset));
				location.setTextOffset(newStartOffset);
			}
		}
	}

}
