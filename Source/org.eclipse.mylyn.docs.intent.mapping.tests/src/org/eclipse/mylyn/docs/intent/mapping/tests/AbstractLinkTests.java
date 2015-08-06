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

import org.eclipse.mylyn.docs.intent.mapping.ILink;
import org.eclipse.mylyn.docs.intent.mapping.ILink.LinkStatus;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test {@link ILink}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractLinkTests extends AbstractMappingTests {

	@Test
	public void setDescriptionNull() {
		final TestLinkListener listener = new TestLinkListener();
		final TestLinkListener removedListener = new TestLinkListener();

		final ILink link = getFactory().createLink();
		link.addListener(listener);
		link.addListener(removedListener);
		link.removeListener(removedListener);
		link.setDescription(null);

		assertNull(link.getDescription());

		assertTestLinkListener(listener, 1, 0, 0, 0);
		assertTestLinkListener(removedListener, 0, 0, 0, 0);
	}

	@Test
	public void setDescription() {
		final TestLinkListener listener = new TestLinkListener();
		final TestLinkListener removedListener = new TestLinkListener();

		final ILink link = getFactory().createLink();
		link.addListener(listener);
		link.addListener(removedListener);
		link.removeListener(removedListener);
		link.setDescription("description");

		assertEquals("description", link.getDescription());

		assertTestLinkListener(listener, 1, 0, 0, 0);
		assertTestLinkListener(removedListener, 0, 0, 0, 0);
	}

	@Test
	public void getDescriptionDefault() {
		final ILink link = getFactory().createLink();

		assertNull(link.getDescription());
	}

	@Test
	public void markAsValid() {
		final TestLinkListener listener = new TestLinkListener();
		final TestLinkListener removedListener = new TestLinkListener();

		final ILink link = getFactory().createLink();
		link.addListener(listener);
		link.addListener(removedListener);
		link.removeListener(removedListener);
		link.markAsValid();

		assertEquals(LinkStatus.VALID, link.getLinkStatus());

		assertTestLinkListener(listener, 0, 1, 0, 0);
		assertTestLinkListener(removedListener, 0, 0, 0, 0);
	}

	@Test
	public void getLinkStatusDefault() {
		final ILink link = getFactory().createLink();

		assertEquals(LinkStatus.VALID, link.getLinkStatus());
	}

	@Test
	public void setSourceNull() {
		final TestLinkListener listener = new TestLinkListener();
		final TestLinkListener removedListener = new TestLinkListener();

		final ILink link = getFactory().createLink();
		link.addListener(listener);
		link.addListener(removedListener);
		link.removeListener(removedListener);
		link.setSource(null);

		assertNull(link.getSource());

		assertTestLinkListener(listener, 0, 0, 1, 0);
		assertTestLinkListener(removedListener, 0, 0, 0, 0);
	}

	@Test
	public void setSource() {
		final TestLinkListener listener = new TestLinkListener();
		final TestLinkListener removedListener = new TestLinkListener();

		final ILink link = getFactory().createLink();
		link.addListener(listener);
		link.addListener(removedListener);
		link.removeListener(removedListener);
		final ILocation source = getFactory().createLocation();

		link.setSource(source);

		assertEquals(source, link.getSource());

		assertTestLinkListener(listener, 0, 0, 1, 0);
		assertTestLinkListener(removedListener, 0, 0, 0, 0);
	}

	@Test
	public void getSourceDefault() {
		final ILink link = getFactory().createLink();

		assertNull(link.getSource());
	}

	@Test
	public void setTargetNull() {
		final TestLinkListener listener = new TestLinkListener();
		final TestLinkListener removedListener = new TestLinkListener();

		final ILink link = getFactory().createLink();
		link.addListener(listener);
		link.addListener(removedListener);
		link.removeListener(removedListener);
		link.setTarget(null);

		assertNull(link.getTarget());

		assertTestLinkListener(listener, 0, 0, 0, 1);
		assertTestLinkListener(removedListener, 0, 0, 0, 0);
	}

	@Test
	public void setTarget() {
		final TestLinkListener listener = new TestLinkListener();
		final TestLinkListener removedListener = new TestLinkListener();

		final ILink link = getFactory().createLink();
		link.addListener(listener);
		link.addListener(removedListener);
		link.removeListener(removedListener);
		final ILocation target = getFactory().createLocation();

		link.setTarget(target);

		assertEquals(target, link.getTarget());

		assertTestLinkListener(listener, 0, 0, 0, 1);
		assertTestLinkListener(removedListener, 0, 0, 0, 0);
	}

	@Test
	public void getTargetDefault() {
		final ILink link = getFactory().createLink();

		assertNull(link.getTarget());
	}

}
