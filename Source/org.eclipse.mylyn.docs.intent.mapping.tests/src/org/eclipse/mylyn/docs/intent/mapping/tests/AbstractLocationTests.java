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

import org.eclipse.mylyn.docs.intent.mapping.ILink;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.IScope;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test {@link ILocation}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractLocationTests extends AbstractMappingTests {

	@Test
	public void addSourceLinks() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILink link = getFactory().createLink();

		location.getSourceLinks().add(link);

		assertEquals(1, location.getSourceLinks().size());
		assertEquals(link, location.getSourceLinks().get(0));

		assertTestLocationListener(listener, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void addManySourceLinks() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILink link1 = getFactory().createLink();
		final ILink link2 = getFactory().createLink();
		final List<ILink> links = new ArrayList<ILink>();
		links.add(link1);
		links.add(link2);

		location.getSourceLinks().addAll(links);

		assertEquals(2, location.getSourceLinks().size());
		assertEquals(link1, location.getSourceLinks().get(0));
		assertEquals(link2, location.getSourceLinks().get(1));

		assertTestLocationListener(listener, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void removeSourceLinks() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILink link = getFactory().createLink();

		location.getSourceLinks().add(link);

		assertEquals(1, location.getSourceLinks().size());
		assertEquals(link, location.getSourceLinks().get(0));

		location.getSourceLinks().remove(link);

		assertEquals(0, location.getSourceLinks().size());

		assertTestLocationListener(listener, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void removeManySourceLinks() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILink link1 = getFactory().createLink();
		final ILink link2 = getFactory().createLink();
		final List<ILink> links = new ArrayList<ILink>();
		links.add(link1);
		links.add(link2);

		location.getSourceLinks().addAll(links);

		assertEquals(2, location.getSourceLinks().size());
		assertEquals(link1, location.getSourceLinks().get(0));
		assertEquals(link2, location.getSourceLinks().get(1));

		location.getSourceLinks().removeAll(links);

		assertEquals(0, location.getSourceLinks().size());

		assertTestLocationListener(listener, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void addTargetLinks() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILink link = getFactory().createLink();

		location.getTargetLinks().add(link);

		assertEquals(1, location.getTargetLinks().size());
		assertEquals(link, location.getTargetLinks().get(0));

		assertTestLocationListener(listener, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void addManyTargetLinks() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILink link1 = getFactory().createLink();
		final ILink link2 = getFactory().createLink();
		final List<ILink> links = new ArrayList<ILink>();
		links.add(link1);
		links.add(link2);

		location.getTargetLinks().addAll(links);

		assertEquals(2, location.getTargetLinks().size());
		assertEquals(link1, location.getTargetLinks().get(0));
		assertEquals(link2, location.getTargetLinks().get(1));

		assertTestLocationListener(listener, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void removeTargetLinks() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILink link = getFactory().createLink();

		location.getTargetLinks().add(link);

		assertEquals(1, location.getTargetLinks().size());
		assertEquals(link, location.getTargetLinks().get(0));

		location.getTargetLinks().remove(link);

		assertEquals(0, location.getTargetLinks().size());

		assertTestLocationListener(listener, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void removeManyTargetLinks() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILink link1 = getFactory().createLink();
		final ILink link2 = getFactory().createLink();
		final List<ILink> links = new ArrayList<ILink>();
		links.add(link1);
		links.add(link2);

		location.getTargetLinks().addAll(links);

		assertEquals(2, location.getTargetLinks().size());
		assertEquals(link1, location.getTargetLinks().get(0));
		assertEquals(link2, location.getTargetLinks().get(1));

		location.getTargetLinks().removeAll(links);

		assertEquals(0, location.getTargetLinks().size());

		assertTestLocationListener(listener, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void setScopeNull() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		location.setScope(null);

		assertNull(location.getName());

		assertTestLocationListener(listener, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void setScope() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final IScope scope = getFactory().createScope();

		location.setScope(scope);

		assertEquals(scope, location.getScope());

		assertTestLocationListener(listener, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void getScopeDefault() {
		final ILocation location = getFactory().createLocation();

		assertNull(location.getScope());
	}

	@Test
	public void addContentLocations() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILocation location1 = getFactory().createLocation();

		location.getContents().add(location1);

		assertEquals(1, location.getContents().size());
		assertEquals(location1, location.getContents().get(0));

		assertTestLocationListener(listener, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void addManyContentLocations() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILocation location1 = getFactory().createLocation();
		final ILocation location2 = getFactory().createLocation();
		final List<ILocation> locations = new ArrayList<ILocation>();
		locations.add(location1);
		locations.add(location2);

		location.getContents().addAll(locations);

		assertEquals(2, location.getContents().size());
		assertEquals(location1, location.getContents().get(0));
		assertEquals(location2, location.getContents().get(1));

		assertTestLocationListener(listener, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void removeContentLocations() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILocation location1 = getFactory().createLocation();

		location.getContents().add(location1);

		assertEquals(1, location.getContents().size());
		assertEquals(location1, location.getContents().get(0));

		location.getContents().remove(location1);

		assertEquals(0, location.getContents().size());

		assertTestLocationListener(listener, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void removeManyContentLocations() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final ILocation location1 = getFactory().createLocation();
		final ILocation location2 = getFactory().createLocation();
		final List<ILocation> locations = new ArrayList<ILocation>();
		locations.add(location1);
		locations.add(location2);

		location.getContents().addAll(locations);

		assertEquals(2, location.getContents().size());
		assertEquals(location1, location.getContents().get(0));
		assertEquals(location2, location.getContents().get(1));

		location.getContents().removeAll(locations);

		assertEquals(0, location.getContents().size());

		assertTestLocationListener(listener, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void addReferencingScopes() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final IScope scope = getFactory().createScope();

		location.getReferencingScopes().add(scope);

		assertEquals(1, location.getReferencingScopes().size());
		assertEquals(scope, location.getReferencingScopes().get(0));

		assertTestLocationListener(listener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void addManyReferencingScopes() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final IScope scope1 = getFactory().createScope();
		final IScope scope2 = getFactory().createScope();
		final List<IScope> scopes = new ArrayList<IScope>();
		scopes.add(scope1);
		scopes.add(scope2);

		location.getReferencingScopes().addAll(scopes);

		assertEquals(2, location.getReferencingScopes().size());
		assertEquals(scope1, location.getReferencingScopes().get(0));
		assertEquals(scope2, location.getReferencingScopes().get(1));

		assertTestLocationListener(listener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void removeReferencingScopes() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final IScope scope = getFactory().createScope();

		location.getReferencingScopes().add(scope);

		assertEquals(1, location.getReferencingScopes().size());
		assertEquals(scope, location.getReferencingScopes().get(0));

		location.getReferencingScopes().remove(scope);

		assertEquals(0, location.getReferencingScopes().size());

		assertTestLocationListener(listener, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	@Test
	public void removeManyReferencingScopes() {
		final TestLocationListener listener = new TestLocationListener();
		final TestLocationListener removedListener = new TestLocationListener();

		final ILocation location = getFactory().createLocation();
		location.addListener(listener);
		location.addListener(removedListener);
		location.removeListener(removedListener);
		final IScope scope1 = getFactory().createScope();
		final IScope scope2 = getFactory().createScope();
		final List<IScope> scopes = new ArrayList<IScope>();
		scopes.add(scope1);
		scopes.add(scope2);

		location.getReferencingScopes().addAll(scopes);

		assertEquals(2, location.getReferencingScopes().size());
		assertEquals(scope1, location.getReferencingScopes().get(0));
		assertEquals(scope2, location.getReferencingScopes().get(1));

		location.getReferencingScopes().removeAll(scopes);

		assertEquals(0, location.getReferencingScopes().size());

		assertTestLocationListener(listener, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2);
		assertTestLocationListener(removedListener, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

}
