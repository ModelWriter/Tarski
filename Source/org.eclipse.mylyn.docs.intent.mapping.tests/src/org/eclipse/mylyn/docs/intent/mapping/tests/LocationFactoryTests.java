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

import java.util.List;

import org.eclipse.mylyn.docs.intent.mapping.ILink;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.ILocationListener;
import org.eclipse.mylyn.docs.intent.mapping.IScope;
import org.eclipse.mylyn.docs.intent.mapping.LocationFactory;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests {@link LocationFactory}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class LocationFactoryTests {

	/**
	 * A test location interface.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public interface ITestLocation extends ILocation {

	}

	/**
	 * A test location interface.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static class TestLocation implements ITestLocation {

		public String getName() {
			// nothing to do here
			return null;
		}

		public String getSemanticName() {
			// nothing to do here
			return null;
		}

		public void markAsChanged() {
			// nothing to do here
		}

		public void markAsDeleted() {
			// nothing to do here
		}

		public List<ILink> getSourceLinks() {
			// nothing to do here
			return null;
		}

		public List<ILink> getTargetLinks() {
			// nothing to do here
			return null;
		}

		public void setScope(IScope scope) {
			// nothing to do here
		}

		public IScope getScope() {
			// nothing to do here
			return null;
		}

		public void setContainer(ILocation location) {
			// nothing to do here
		}

		public ILocation getContainer() {
			// nothing to do here
			return null;
		}

		public List<ILocation> getContents() {
			// nothing to do here
			return null;
		}

		public ILocation getContentLocation(String name) {
			// nothing to do here
			return null;
		}

		public List<IScope> getReferencingScopes() {
			// nothing to do here
			return null;
		}

		public void addListener(ILocationListener listener) {
			// nothing to do here
		}

		public void removeListener(ILocationListener listener) {
			// nothing to do here
		}

	}

	@Test
	public void addClassInstance() throws InstantiationException, IllegalAccessException {
		final LocationFactory factory = new LocationFactory();

		factory.addClassInstance(ITestLocation.class, TestLocation.class);

		final ITestLocation location = factory.createLocation(ITestLocation.class);

		assertTrue(location instanceof TestLocation);
	}

	@Test
	public void removeClassInstance() throws InstantiationException, IllegalAccessException {
		final LocationFactory factory = new LocationFactory();

		factory.addClassInstance(ITestLocation.class, TestLocation.class);
		factory.removeClassInstance(ITestLocation.class);

		final ITestLocation location = factory.createLocation(ITestLocation.class);

		assertNull(location);
	}

}
