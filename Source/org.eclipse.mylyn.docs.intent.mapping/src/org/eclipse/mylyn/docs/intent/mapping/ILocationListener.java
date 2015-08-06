/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    {INITIAL AUTHOR} - initial API and implementation and/or initial documentation
 *    ...
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.mapping;

/**
 * Listen to {@link ILocation} changes.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface ILocationListener {

	/**
	 * Stub implementation.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static class Stub implements ILocationListener {

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#nameChanged(java.lang.String)
		 */
		public void nameChanged(String name) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#sourceLinkAdded(org.eclipse.mylyn.docs.intent.mapping.ILink)
		 */
		public void sourceLinkAdded(ILink link) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#sourceLinkRemoved(org.eclipse.mylyn.docs.intent.mapping.ILink)
		 */
		public void sourceLinkRemoved(ILink link) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#targetLinkAdded(org.eclipse.mylyn.docs.intent.mapping.ILink)
		 */
		public void targetLinkAdded(ILink link) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#targetLinkRemoved(org.eclipse.mylyn.docs.intent.mapping.ILink)
		 */
		public void targetLinkRemoved(ILink link) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#scopeChanged(org.eclipse.mylyn.docs.intent.mapping.IScope)
		 */
		public void scopeChanged(IScope scope) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#contentLocationAdded(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void contentLocationAdded(ILocation location) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#contentLocationRemoved(org.eclipse.mylyn.docs.intent.mapping.ILocation)
		 */
		public void contentLocationRemoved(ILocation location) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#referencingScopeAdded(org.eclipse.mylyn.docs.intent.mapping.IScope)
		 */
		public void referencingScopeAdded(IScope scope) {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see org.eclipse.mylyn.docs.intent.mapping.ILocationListener#referencingScopeRemoved(org.eclipse.mylyn.docs.intent.mapping.IScope)
		 */
		public void referencingScopeRemoved(IScope scope) {
			// nothing to do here
		}

	}

	/**
	 * Notifies when the {@link ILocation#getName() name} is changed.
	 * 
	 * @param name
	 *            the new {@link ILocation#getName() name}
	 */
	void nameChanged(String name);

	/**
	 * Notifies when the {@link ILocation#getSourceLinks() source} {@link ILink} is added.
	 * 
	 * @param link
	 *            the added {@link ILocation#getSourceLinks() source} {@link ILink}
	 */
	void sourceLinkAdded(ILink link);

	/**
	 * Notifies when the {@link ILocation#getSourceLinks() source} {@link ILink} is removed.
	 * 
	 * @param link
	 *            the removed {@link ILocation#getSourceLinks() source} {@link ILink}
	 */
	void sourceLinkRemoved(ILink link);

	/**
	 * Notifies when the {@link ILocation#getTargetLinks() target} {@link ILink} is added.
	 * 
	 * @param link
	 *            the added {@link ILocation#getTargetLinks() target} {@link ILink}
	 */
	void targetLinkAdded(ILink link);

	/**
	 * Notifies when the {@link ILocation#getTargetLinks() target} {@link ILink} is removed.
	 * 
	 * @param link
	 *            the removed {@link ILocation#getTargetLinks() target} {@link ILink}
	 */
	void targetLinkRemoved(ILink link);

	/**
	 * Notifies when the {@link ILocation#getScope() scope} is changed.
	 * 
	 * @param scope
	 *            the new {@link ILocation#getScope() scope}
	 */
	void scopeChanged(IScope scope);

	/**
	 * Notifies when the {@link ILocation#getContents() content} {@link ILocation} is added.
	 * 
	 * @param location
	 *            the added {@link ILocation#getContents() content} {@link ILocation}
	 */
	void contentLocationAdded(ILocation location);

	/**
	 * Notifies when the {@link ILocation#getContents() content} {@link ILocation} is removed.
	 * 
	 * @param location
	 *            the removed {@link ILocation#getContents() content} {@link ILocation}
	 */
	void contentLocationRemoved(ILocation location);

	/**
	 * Notifies when the {@link ILocation#getReferencingScopes() referencing} {@link IScope} is added.
	 * 
	 * @param scope
	 *            the added {@link ILocation#getReferencingScopes() referencing} {@link IScope}
	 */
	void referencingScopeAdded(IScope scope);

	/**
	 * Notifies when the {@link ILocation#getReferencingScopes() referencing} {@link IScope} is removed.
	 * 
	 * @param scope
	 *            the removed {@link ILocation#getReferencingScopes() referencing} {@link IScope}
	 */
	void referencingScopeRemoved(IScope scope);

}
