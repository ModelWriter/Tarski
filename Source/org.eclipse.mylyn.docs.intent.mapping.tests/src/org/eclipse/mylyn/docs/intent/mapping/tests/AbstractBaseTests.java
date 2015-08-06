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

import org.eclipse.mylyn.docs.intent.mapping.IBase;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test {@link IBase}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractBaseTests extends AbstractMappingTests {

	@Test
	public void setNameNull() {
		final TestBaseListener listener = new TestBaseListener();
		final TestBaseListener removedListener = new TestBaseListener();

		final IBase base = getFactory().createBase();
		base.addListener(listener);
		base.addListener(removedListener);
		base.removeListener(removedListener);
		base.setName(null);

		assertNull(base.getName());

		assertTestBaseListener(removedListener, 0, 0, 0);
		assertTestBaseListener(removedListener, 0, 0, 0);
	}

	@Test
	public void setName() {
		final TestBaseListener listener = new TestBaseListener();
		final TestBaseListener removedListener = new TestBaseListener();

		final IBase base = getFactory().createBase();
		base.addListener(listener);
		base.addListener(removedListener);
		base.removeListener(removedListener);

		base.setName("base");

		assertEquals("base", base.getName());

		assertTestBaseListener(listener, 1, 0, 0);
		assertTestBaseListener(removedListener, 0, 0, 0);
	}

	@Test
	public void getNameDefault() {
		final IBase base = getFactory().createBase();

		assertNull(base.getName());
	}

	@Test
	public void addRootLocation() {
		final TestBaseListener listener = new TestBaseListener();
		final TestBaseListener removedListener = new TestBaseListener();

		final IBase base = getFactory().createBase();
		base.addListener(listener);
		base.addListener(removedListener);
		base.removeListener(removedListener);
		final ILocation location = getFactory().createLocation();

		base.getRootLocations().add(location);

		assertEquals(1, base.getRootLocations().size());
		assertEquals(location, base.getRootLocations().get(0));

		assertTestBaseListener(listener, 0, 1, 0);
		assertTestBaseListener(removedListener, 0, 0, 0);
	}

	@Test
	public void addManyRootLocations() {
		final TestBaseListener listener = new TestBaseListener();
		final TestBaseListener removedListener = new TestBaseListener();

		final IBase base = getFactory().createBase();
		base.addListener(listener);
		base.addListener(removedListener);
		base.removeListener(removedListener);
		final ILocation location1 = getFactory().createLocation();
		final ILocation location2 = getFactory().createLocation();
		final List<ILocation> locations = new ArrayList<ILocation>();
		locations.add(location1);
		locations.add(location2);

		base.getRootLocations().addAll(locations);

		assertEquals(2, base.getRootLocations().size());
		assertEquals(location1, base.getRootLocations().get(0));
		assertEquals(location2, base.getRootLocations().get(1));

		assertTestBaseListener(listener, 0, 2, 0);
		assertTestBaseListener(removedListener, 0, 0, 0);
	}

	@Test
	public void removeRootLocation() {
		final TestBaseListener listener = new TestBaseListener();
		final TestBaseListener removedListener = new TestBaseListener();

		final IBase base = getFactory().createBase();
		base.addListener(listener);
		base.addListener(removedListener);
		base.removeListener(removedListener);
		final ILocation location = getFactory().createLocation();

		base.getRootLocations().add(location);

		assertEquals(1, base.getRootLocations().size());
		assertEquals(location, base.getRootLocations().get(0));

		base.getRootLocations().remove(location);

		assertEquals(0, base.getRootLocations().size());

		assertTestBaseListener(listener, 0, 1, 1);
		assertTestBaseListener(removedListener, 0, 0, 0);
	}

	@Test
	public void removeManyRootLocations() {
		final TestBaseListener listener = new TestBaseListener();
		final TestBaseListener removedListener = new TestBaseListener();

		final IBase base = getFactory().createBase();
		base.addListener(listener);
		base.addListener(removedListener);
		base.removeListener(removedListener);
		final ILocation location1 = getFactory().createLocation();
		final ILocation location2 = getFactory().createLocation();
		final List<ILocation> locations = new ArrayList<ILocation>();
		locations.add(location1);
		locations.add(location2);

		base.getRootLocations().addAll(locations);

		assertEquals(2, base.getRootLocations().size());
		assertEquals(location1, base.getRootLocations().get(0));
		assertEquals(location2, base.getRootLocations().get(1));

		base.getRootLocations().removeAll(locations);

		assertEquals(0, base.getRootLocations().size());

		assertTestBaseListener(listener, 0, 2, 2);
		assertTestBaseListener(removedListener, 0, 0, 0);
	}

}
