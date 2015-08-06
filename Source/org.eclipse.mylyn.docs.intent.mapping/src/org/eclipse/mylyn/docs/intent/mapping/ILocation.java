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
package org.eclipse.mylyn.docs.intent.mapping;

import java.util.List;

/**
 * Locate a part of a resource according to available {@link ILocationAdapter}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface ILocation extends IMappingElement {

	/**
	 * The name of the {@link ILocation}. It must be unique across any {@link ILocation}
	 * {@link ILocation#getContents() content}.
	 * 
	 * @return the name of the {@link ILocation}
	 */
	String getName();

	/**
	 * Gets the semantic name.
	 * 
	 * @return the semantic name
	 */
	String getSemanticName();

	/**
	 * Marks the location as changed. All {@link ILocation#getSourceLinks() source} must be
	 * {@link ILink#getStatus() marked} as
	 * {@link org.eclipse.mylyn.docs.intent.mapping.ILink.LinkStatus#CHANGED_TARGET CHANGED_TARGET} and
	 * {@link ILocation#getTargetLinks() target} must be {@link ILink#getStatus() marked} as
	 * {@link org.eclipse.mylyn.docs.intent.mapping.ILink.LinkStatus#CHANGED_SOURCE CHANGED_SOURCE}
	 */
	void markAsChanged();

	/**
	 * Marks the location as deleted. All {@link ILocation#getSourceLinks() source} must be
	 * {@link ILink#getStatus() marked} as
	 * {@link org.eclipse.mylyn.docs.intent.mapping.ILink.LinkStatus#DELETED_TARGET DELETED_TARGET} and
	 * {@link ILocation#getTargetLinks() target} must be {@link ILink#getStatus() marked} as
	 * {@link org.eclipse.mylyn.docs.intent.mapping.ILink.LinkStatus#DELETED_SOURCE DELETED_SOURCE}
	 */
	void markAsDeleted();

	/**
	 * Gets the {@link List} of {@link ILink} that have this {@link ILocation} as {@link ILink#getTarget()
	 * target}.
	 * 
	 * @return the {@link List} of {@link ILink} that have this {@link ILocation} as {@link ILink#getTarget()
	 *         target}
	 */
	List<ILink> getSourceLinks();

	/**
	 * Gets the {@link List} of {@link ILink} that have this {@link ILocation} as {@link ILink#getSource()
	 * source}.
	 * 
	 * @return the {@link List} of {@link ILink} that have this {@link ILocation} as {@link ILink#getSource()
	 *         source}
	 */
	List<ILink> getTargetLinks();

	/**
	 * Sets the {@link IScope} of the {@link ILocation}.
	 * 
	 * @param scope
	 *            the {@link IScope} of the {@link ILocation}
	 */
	void setScope(IScope scope);

	/**
	 * Gets the {@link IScope} of the {@link ILocation}.
	 * 
	 * @return the {@link IScope} of the {@link ILocation} if any, <code>null</code> otherwise
	 */
	IScope getScope();

	/**
	 * Sets the containing {@link ILocation}.
	 * 
	 * @param location
	 *            the containing {@link ILocation}
	 */
	void setContainer(ILocation location);

	/**
	 * Gets the containing {@link ILocation}.
	 * 
	 * @return the containing {@link ILocation} if any, <code>null</code> otherwise
	 */
	ILocation getContainer();

	/**
	 * Gets the {@link List} of contained {@link ILocation}.
	 * 
	 * @return the {@link List} of contained {@link ILocation}
	 */
	List<ILocation> getContents();

	/**
	 * Gets the {@link ILocation#getContents() content} {@link ILocation} by its {@link ILocation#getName()}.
	 * 
	 * @param name
	 *            the {@link ILocation} {@link ILocation#getName() name}
	 * @return the {@link ILocation#getContents() content} {@link ILocation} by its
	 *         {@link ILocation#getName()} if any, <code>null</code> otherwise
	 */
	ILocation getContentLocation(String name);

	/**
	 * Gets the {@link List} of {@link IScope} {@link IScope#getLocations() referencing} this
	 * {@link ILocation}.
	 * 
	 * @return the {@link List} of {@link IScope} {@link IScope#getLocations() referencing} this
	 *         {@link ILocation}
	 */
	List<IScope> getReferencingScopes();

	/**
	 * Adds a {@link ILocationListener}.
	 * 
	 * @param listener
	 *            the {@link ILocationListener} to add
	 */
	void addListener(ILocationListener listener);

	/**
	 * Removes a {@link ILocationListener}.
	 * 
	 * @param listener
	 *            the {@link ILocationListener} to remove
	 */
	void removeListener(ILocationListener listener);
}
