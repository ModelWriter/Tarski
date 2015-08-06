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
package org.eclipse.mylyn.docs.intent.mapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates instances of {@link ILocation}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class LocationFactory {

	/**
	 * Mapping from interfaces to instance classes.
	 */
	private final Map<Class<? extends ILocation>, Class<? extends ILocation>> classMapping = new HashMap<Class<? extends ILocation>, Class<? extends ILocation>>();

	/**
	 * Gets the instance {@link Class} of the given interface {@link Class} from the
	 * {@link LocationFactory#classMapping mapping}.
	 * 
	 * @param cls
	 *            the interface class
	 * @param <L>
	 *            the {@link ILocation} kind
	 * @return the instance {@link Class} of the given interface {@link Class} from the
	 *         {@link LocationFactory#classMapping mapping}
	 */
	@SuppressWarnings("unchecked")
	private <L extends ILocation> Class<L> getInstanceClass(Class<L> cls) {
		return (Class<L>)classMapping.get(cls);
	}

	/**
	 * Creates an instance of {@link ILocation} for the given interface {@link Class}.
	 * 
	 * @param interfaceCls
	 *            the interface class
	 * @param <L>
	 *            the {@link ILocation} kind
	 * @return the created instance of {@link ILocation} for the given interface {@link Class} if an instance
	 *         {@link Class} has been {@link LocationFactory#addClassInstance(Class, Class) added} for the
	 *         interface {@link Class}, <code>null</code> otherwise
	 * @throws IllegalAccessException
	 *             if the class or its nullary constructor is not accessible.
	 * @throws InstantiationException
	 *             if this Class represents an abstract class, an interface, an array class, a primitive type,
	 *             or void; or if the class has no nullary constructor; or if the instantiation fails for some
	 *             other reason.
	 */
	public <L extends ILocation> L createLocation(Class<L> interfaceCls) throws InstantiationException,
			IllegalAccessException {
		final L res;

		Class<L> instanceClass = getInstanceClass(interfaceCls);
		if (instanceClass != null) {
			res = instanceClass.newInstance();
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Add an instance {@link Class} for the given interface {@link Class}.
	 * 
	 * @param interfaceCls
	 *            the interface {@link Class}
	 * @param instanceCls
	 *            the instance {@link Class}
	 * @param <L>
	 *            the {@link ILocation} kind
	 */
	public <L extends ILocation> void addClassInstance(Class<L> interfaceCls, Class<? extends L> instanceCls) {
		classMapping.put(interfaceCls, instanceCls);
	}

	/**
	 * Removes the instance {@link Class} of the given interface {@link Class}.
	 * 
	 * @param interfaceCls
	 *            the interface {@link Class}
	 */
	public void removeClassInstance(Class<?> interfaceCls) {
		classMapping.remove(interfaceCls);
	}

}
