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
package org.eclipse.mylyn.docs.intent.mapping.tests;

import org.eclipse.mylyn.docs.intent.mapping.text.ITextLocation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test {@link ITextLocation}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractTextLocationTests extends AbstractLocationTests {

	@Override
	protected ITextLocation createLocation() throws InstantiationException, IllegalAccessException {
		return getFactory().createBase().getLocationFactory().createLocation(ITextLocation.class);
	}

	@Test
	public void setTextNull() throws InstantiationException, IllegalAccessException {
		ITextLocation location = createLocation();

		location.setText(null);

		assertEquals(null, location.getText());
	}

	@Test
	public void setText() throws InstantiationException, IllegalAccessException {
		ITextLocation location = createLocation();

		location.setText("test text");

		assertEquals("test text", location.getText());
	}

	@Test
	public void getTextDefault() throws InstantiationException, IllegalAccessException {
		ITextLocation location = createLocation();

		assertEquals(null, location.getText());
	}

	@Test
	public void setTextOffset() throws InstantiationException, IllegalAccessException {
		ITextLocation location = createLocation();

		location.setTextOffset(50);

		assertEquals(50, location.getTextOffset());
	}

	@Test
	public void getTextOffsetDefault() throws InstantiationException, IllegalAccessException {
		ITextLocation location = createLocation();

		assertEquals(-1, location.getTextOffset());
	}

}
