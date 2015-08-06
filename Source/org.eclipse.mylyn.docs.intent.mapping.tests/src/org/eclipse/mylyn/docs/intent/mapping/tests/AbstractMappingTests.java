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

import org.eclipse.mylyn.docs.intent.mapping.IBaseListener;
import org.eclipse.mylyn.docs.intent.mapping.ILink;
import org.eclipse.mylyn.docs.intent.mapping.ILink.LinkStatus;
import org.eclipse.mylyn.docs.intent.mapping.ILinkListener;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.ILocationListener;
import org.eclipse.mylyn.docs.intent.mapping.IScope;
import org.eclipse.mylyn.docs.intent.mapping.IScopeListener;
import org.eclipse.mylyn.docs.intent.mapping.text.ITextLocation;

import static org.junit.Assert.assertEquals;

/**
 * Abstract mapping tests.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractMappingTests {

	/**
	 * Test {@link IBaseListener}.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	protected final class TestBaseListener implements IBaseListener {

		/**
		 * Number of time {@link TestBaseListener#nameChanged(String)} has been called.
		 */
		private int nameChanged;

		/**
		 * Number of time {@link TestBaseListener#rootLocationAdded(ILocation)} has been called.
		 */
		private int rootLocationAdded;

		/**
		 * Number of time {@link TestBaseListener#rootLocationRemoved(ILocation)} has been called.
		 */
		private int rootLocationRemoved;

		public void nameChanged(String name) {
			nameChanged++;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.IBaseListener#rootLocationAdded(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void rootLocationAdded(ILocation location) {
			rootLocationAdded++;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.IBaseListener#rootLocationRemoved(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void rootLocationRemoved(ILocation location) {
			rootLocationRemoved++;
		}

	}

	/**
	 * Test {@link ILinkListener}.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	protected final class TestLinkListener implements ILinkListener {

		/**
		 * Number of time {@link TestLinkListener#targetChanged(ILocation)} has been called.
		 */
		private int targetChanged;

		/**
		 * Number of time {@link TestLinkListener#sourceChanged(ILocation)} has been called.
		 */
		private int sourceChanged;

		/**
		 * Number of time {@link TestLinkListener#statusChanged(LinkStatus)} has been called.
		 */
		private int statusChanged;

		/**
		 * Number of time {@link TestLinkListener#descriptionChanged(String)} has been called.
		 */
		private int descriptionChanged;

		public void descriptionChanged(String description) {
			descriptionChanged++;
		}

		public void statusChanged(LinkStatus status) {
			statusChanged++;
		}

		public void sourceChanged(ILocation source) {
			sourceChanged++;
		}

		public void targetChanged(ILocation target) {
			targetChanged++;
		}
	}

	/**
	 * Test {@link ILocationListener}.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	protected final class TestLocationListener implements ILocationListener {

		/**
		 * Number of time {@link TestLocationListener#contentLocationRemoved(ILocation)} has been called.
		 */
		private int contentLocationRemoved;

		/**
		 * Number of time {@link TestLocationListener#contentLocationAdded(ILocation)} has been called.
		 */
		private int contentLocationAdded;

		/**
		 * Number of time {@link TestLocationListener#scopeChanged(IScope)} has been called.
		 */
		private int scopeChanged;

		/**
		 * Number of time {@link TestLocationListener#targetLinkRemoved(ILink)} has been called.
		 */
		private int targetLinkRemoved;

		/**
		 * Number of time {@link TestLocationListener#targetLinkAdded(ILink)} has been called.
		 */
		private int targetLinkAdded;

		/**
		 * Number of time {@link TestLocationListener#sourceLinkRemoved(ILink)} has been called.
		 */
		private int sourceLinkRemoved;

		/**
		 * Number of time {@link TestLocationListener#sourceLinkAdded(ILink)} has been called.
		 */
		private int sourceLinkAdded;

		/**
		 * Number of time {@link TestLocationListener#nameChanged(String)} has been called.
		 */
		private int nameChanged;

		/**
		 * Number of time {@link TestLocationListener#referencingScopeRemoved(IScope)} has been called.
		 */
		private int referencingScopeRemoved;

		/**
		 * Number of time {@link TestLocationListener#referencingScopeAdded(IScope)} has been called.
		 */
		private int referencingScopeAdded;

		public void nameChanged(String name) {
			nameChanged++;
		}

		public void sourceLinkAdded(ILink link) {
			sourceLinkAdded++;
		}

		public void sourceLinkRemoved(ILink link) {
			sourceLinkRemoved++;
		}

		public void targetLinkAdded(ILink link) {
			targetLinkAdded++;
		}

		public void targetLinkRemoved(ILink link) {
			targetLinkRemoved++;
		}

		public void scopeChanged(IScope scope) {
			scopeChanged++;
		}

		public void contentLocationAdded(ILocation location) {
			contentLocationAdded++;
		}

		public void contentLocationRemoved(ILocation location) {
			contentLocationRemoved++;
		}

		public void referencingScopeAdded(IScope scope) {
			referencingScopeAdded++;
		}

		public void referencingScopeRemoved(IScope scope) {
			referencingScopeRemoved++;
		}

	}

	/**
	 * Test {@link IScopeListener}.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	protected final class TestScopeListener implements IScopeListener {

		/**
		 * Number of time {@link TestScopeListener#locationRemoved(ILocation)} has been called.
		 */
		private int contentLocationRemoved;

		/**
		 * Number of time {@link TestScopeListener#locationAdded(ILocation)} has been called.
		 */
		private int contentLocationAdded;

		/**
		 * Number of time {@link TestScopeListener#holderChanged(ILocation)} has been called.
		 */
		private int holderChanged;

		public void holderChanged(ILocation location) {
			holderChanged++;
		}

		public void locationAdded(ILocation location) {
			contentLocationAdded++;
		}

		public void locationRemoved(ILocation location) {
			contentLocationRemoved++;
		}

	}

	/**
	 * Gets the {@link IMappingFactory}.
	 * 
	 * @return the {@link IMappingFactory}
	 */
	protected abstract IMappingFactory getFactory();

	protected void assertTestBaseListener(TestBaseListener listener, int nameChanged, int rootLocationAdded,
			int rootLocationRemoved) {
		assertEquals(nameChanged, listener.nameChanged);
		assertEquals(rootLocationAdded, listener.rootLocationAdded);
		assertEquals(rootLocationRemoved, listener.rootLocationRemoved);
	}

	protected void assertTestLinkListener(TestLinkListener listener, int descriptionChanged,
			int statusChanged, int sourceChanged, int targetChanged) {
		assertEquals(descriptionChanged, listener.descriptionChanged);
		assertEquals(statusChanged, listener.statusChanged);
		assertEquals(sourceChanged, listener.sourceChanged);
		assertEquals(targetChanged, listener.targetChanged);
	}

	// CHECKSTYLE:OFF
	protected void assertTestLocationListener(TestLocationListener listener, int contentLocationRemoved,
			int contentLocationAdded, int scopeChanged, int targetLinkRemoved, int targetLinkAdded,
			int sourceLinkRemoved, int sourceLinkAdded, int nameChanged, int referencingScopeRemoved,
			int referencingScopeAdded) {
		assertEquals(nameChanged, listener.nameChanged);
		assertEquals(contentLocationRemoved, listener.contentLocationRemoved);
		assertEquals(contentLocationAdded, listener.contentLocationAdded);
		assertEquals(scopeChanged, listener.scopeChanged);
		assertEquals(targetLinkRemoved, listener.targetLinkRemoved);
		assertEquals(targetLinkAdded, listener.targetLinkAdded);
		assertEquals(sourceLinkRemoved, listener.sourceLinkRemoved);
		assertEquals(sourceLinkAdded, listener.sourceLinkAdded);
		assertEquals(referencingScopeRemoved, listener.referencingScopeRemoved);
		assertEquals(referencingScopeAdded, listener.referencingScopeAdded);
	}

	// CHECKSTYLE:ON
	protected void assertTestScopeListener(TestScopeListener listener, int holderChanged,
			int contentLocationAdded, int contentLocationRemoved) {
		assertEquals(holderChanged, listener.holderChanged);
		assertEquals(contentLocationAdded, listener.contentLocationAdded);
		assertEquals(contentLocationRemoved, listener.contentLocationRemoved);
	}

	protected ILocation createLocation() throws InstantiationException, IllegalAccessException {
		return getFactory().createBase().getLocationFactory().createLocation(ITextLocation.class);
	}

}
