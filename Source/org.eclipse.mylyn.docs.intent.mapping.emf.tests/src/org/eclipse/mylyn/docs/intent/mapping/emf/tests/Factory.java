/*******************************************************************************
 * Copyright (c) 2015 {INITIAL COPYRIGHT OWNER} {OTHER COPYRIGHT OWNERS}.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    {INITIAL AUTHOR} - initial API and implementation and/or initial documentation
 *    ...
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.mapping.emf.tests;

import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.impl.MappingFactoryImpl;
import org.eclipse.mylyn.docs.intent.mapping.tests.IMappingFactory;
import org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestmappingPackage;

/**
 * The tested objects factory.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Factory extends MappingFactoryImpl implements IMappingFactory {

	/**
	 * The {@link Factory} instance.
	 */
	public static final Factory INSTANCE = new Factory();

	public ILocation createLocation() {
		return TestmappingPackage.eINSTANCE.getTestmappingFactory().createTestLocation();
	}

}
