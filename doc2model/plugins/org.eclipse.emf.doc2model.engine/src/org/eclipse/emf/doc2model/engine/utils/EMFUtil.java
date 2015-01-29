head	1.2;
access;
symbols;
locks; strict;
comment	@# @;


1.2
date	2010.07.26.14.24.33;	author tfaure;	state Exp;
branches;
next	1.1;
commitid	3f85a4c4d9aa14567;

1.1
date	2010.03.02.22.34.53;	author tfaure;	state Exp;
branches;
next	;
commitid	7a6d4b8d92874567;


desc
@@


1.2
log
@NEW - bug 320747: Provide recognition by regular expression
https://bugs.eclipse.org/bugs/show_bug.cgi?id=320747

add regular expression.
The syntax in uri is
regex:myRegex(zoneGrouped)

or if you want to bufferize the document (be careful no performance test have been done)
regex:myRegex(zoneGrouped)#global
@
text
@/**
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@@atosorigin.com - Initial API and implementation
 */
package org.eclipse.emf.doc2model.engine.utils;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EMFUtil {
	public static EAttribute getEAttributeByName(EClass eclass,
			String attributeName) {
		for (EAttribute a : eclass.getEAllAttributes()) {
			if (attributeName.equals(a.getName())) {
				return a;
			}
		}
		return null;
	}

	public static EStructuralFeature getFeatureByName(EClass eclass,
			String attributeName) {
		for (EStructuralFeature a : eclass.getEAllStructuralFeatures()) {
			if (attributeName.equals(a.getName())) {
				return a;
			}
		}
		return null;
	}

	public static Object getCorrespondingValue4Type(EAttribute attr,
			String value) {
		String javaInstanceTypeName = EcoreUtil.toJavaInstanceTypeName(attr
				.getEGenericType());
		try {
			if ("boolean".equals(javaInstanceTypeName)
					|| "java.lang.Boolean".equals(javaInstanceTypeName)) {
				if ("false".equals(value.toLowerCase())
						|| "true".equals(value.toLowerCase())) {
					return Boolean.valueOf(value);
				} else {
					// Activator.log(new
					// Exception(String.format("The value %s can't be assigned in Boolean, false is setted by default",
					// value)));
					return false;
				}
			} else if ("integer".equals(javaInstanceTypeName)
					|| "java.lang.Integer".equals(javaInstanceTypeName)) {
				return Integer.valueOf(value);
			} else if ("double".equals(javaInstanceTypeName)
					|| "java.lang.Double".equals(javaInstanceTypeName)) {
				return Double.valueOf(value);
			} else if ("float".equals(javaInstanceTypeName)
					|| "java.lang.Float".equals(javaInstanceTypeName)) {
				return Float.valueOf(value);
			}
			if (attr.getEAttributeType() instanceof EEnum) {
				return getENumValue((EEnum) attr.getEAttributeType(), value);
			} else {
				return value;
			}
		} catch (NumberFormatException e) {
			// Activator.log(new
			// Exception(String.format("The value %s can't be assigned to this type : %s",
			// value, javaInstanceTypeName)));
			return null;
		}
	}

	protected static Object getENumValue(EEnum enumType, String value) {
		if (value == null) {
			return null;
		}
		String toLower = value.toLowerCase().trim();
		for (EEnumLiteral l : enumType.getELiterals()) {
			if (l.getName() != null
					&& l.getName().toLowerCase().trim().equals(toLower)) {
				return l.getInstance();
			}
		}
		return null;
	}
}
@


1.1
log
@doc2model engine first commit
it understands a part of the action language and run a transformation from documents to models
@
text
@d17 2
d68 3
d81 14
@

