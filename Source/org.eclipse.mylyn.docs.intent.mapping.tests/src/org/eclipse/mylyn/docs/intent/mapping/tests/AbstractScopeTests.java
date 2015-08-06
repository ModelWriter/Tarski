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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.IScope;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test {@link IScope}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractScopeTests extends AbstractMappingTests {

	@Test
	public void setHolderNull() {
		final TestScopeListener listener = new TestScopeListener();
		final TestScopeListener removedListener = new TestScopeListener();

		final IScope scope = getFactory().createScope();
		scope.addListener(listener);
		scope.addListener(removedListener);
		scope.removeListener(removedListener);
		scope.setHolder(null);

		assertNull(scope.getHolder());

		assertTestScopeListener(listener, 1, 0, 0);
		assertTestScopeListener(removedListener, 0, 0, 0);
	}

	@Test
	public void setHolder() throws InstantiationException, IllegalAccessException {
		final TestScopeListener listener = new TestScopeListener();
		final TestScopeListener removedListener = new TestScopeListener();

		final IScope scope = getFactory().createScope();
		scope.addListener(listener);
		scope.addListener(removedListener);
		scope.removeListener(removedListener);
		final ILocation location = createLocation();

		scope.setHolder(location);

		assertEquals(location, scope.getHolder());

		assertTestScopeListener(listener, 1, 0, 0);
		assertTestScopeListener(removedListener, 0, 0, 0);
	}

	@Test
	public void getHoldereDefault() {
		final IScope scope = getFactory().createScope();

		assertNull(scope.getHolder());
	}

	@Test
	public void addLocations() throws InstantiationException, IllegalAccessException {
		final TestScopeListener listener = new TestScopeListener();
		final TestScopeListener removedListener = new TestScopeListener();

		final IScope scope = getFactory().createScope();
		scope.addListener(listener);
		scope.addListener(removedListener);
		scope.removeListener(removedListener);
		final ILocation location1 = createLocation();

		scope.getLocations().add(location1);

		assertEquals(1, scope.getLocations().size());
		assertEquals(location1, scope.getLocations().get(0));

		assertTestScopeListener(listener, 0, 1, 0);
		assertTestScopeListener(removedListener, 0, 0, 0);
	}

	@Test
	public void addManyLocations() throws InstantiationException, IllegalAccessException {
		final TestScopeListener listener = new TestScopeListener();
		final TestScopeListener removedListener = new TestScopeListener();

		final IScope scope = getFactory().createScope();
		scope.addListener(listener);
		scope.addListener(removedListener);
		scope.removeListener(removedListener);
		final ILocation location1 = createLocation();
		final ILocation location2 = createLocation();
		final List<ILocation> locations = new ArrayList<ILocation>();
		locations.add(location1);
		locations.add(location2);

		scope.getLocations().addAll(locations);

		assertEquals(2, scope.getLocations().size());
		assertEquals(location1, scope.getLocations().get(0));
		assertEquals(location2, scope.getLocations().get(1));

		assertTestScopeListener(listener, 0, 2, 0);
		assertTestScopeListener(removedListener, 0, 0, 0);
	}

	@Test
	public void removeLocations() throws InstantiationException, IllegalAccessException {
		final TestScopeListener listener = new TestScopeListener();
		final TestScopeListener removedListener = new TestScopeListener();

		final IScope scope = getFactory().createScope();
		scope.addListener(listener);
		scope.addListener(removedListener);
		scope.removeListener(removedListener);
		final ILocation location1 = createLocation();

		scope.getLocations().add(location1);

		assertEquals(1, scope.getLocations().size());
		assertEquals(location1, scope.getLocations().get(0));

		scope.getLocations().remove(location1);

		assertEquals(0, scope.getLocations().size());

		assertTestScopeListener(listener, 0, 1, 1);
		assertTestScopeListener(removedListener, 0, 0, 0);
	}

	@Test
	public void removeManyLocations() throws InstantiationException, IllegalAccessException {
		final TestScopeListener listener = new TestScopeListener();
		final TestScopeListener removedListener = new TestScopeListener();

		final IScope scope = getFactory().createScope();
		scope.addListener(listener);
		scope.addListener(removedListener);
		scope.removeListener(removedListener);
		final ILocation location1 = createLocation();
		final ILocation location2 = createLocation();
		final List<ILocation> locations = new ArrayList<ILocation>();
		locations.add(location1);
		locations.add(location2);

		scope.getLocations().addAll(locations);

		assertEquals(2, scope.getLocations().size());
		assertEquals(location1, scope.getLocations().get(0));
		assertEquals(location2, scope.getLocations().get(1));

		scope.getLocations().removeAll(locations);

		assertEquals(0, scope.getLocations().size());

		assertTestScopeListener(listener, 0, 2, 2);
		assertTestScopeListener(removedListener, 0, 0, 0);
	}

}
