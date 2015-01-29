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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	private Map<String, Pattern> patterns = new HashMap<String, Pattern>();
	public static RegexUtils INSTANCE = new RegexUtils();

	public Pattern compile(String regex) {
		Pattern result = patterns.get(regex);
		if (result == null) {
			result = Pattern.compile(regex,Pattern.MULTILINE | Pattern.DOTALL);
			patterns.put(regex, result);
		}
		return result;
	}

	/**
	 * Return the value analyzing group from the Matcher
	 * @@param m
	 * @@return
	 */
	public static String getValueManagingGroup(Matcher m) {
		List<String> result = getValuesManagingGroup(m);
		if (result != null && !result.isEmpty())
		{
			return result.get(0);
		}
		return "" ;
	}
	
	/**
	 * Return the value analyzing group from the Matcher
	 * @@param m
	 * @@return
	 */
	public static List<String> getValuesManagingGroup(Matcher m) {
		List<String> result = new LinkedList<String>();
		if (m.matches())
		{
			if (m.groupCount() > 0) {
				for (int i = 1 ; i <= m.groupCount() ; i++)
				{
					result.add(m.group(i));
				}
			}
			else
			{
				result.add(m.group());
			}
		}
		return result;
	}
}
@


1.1
log
@doc2model engine first commit
it understands a part of the action language and run a transformation from documents to models
@
text
@d16 2
a25 3
	private RegexUtils() {
	}

d29 1
a29 1
			result = Pattern.compile(regex);
d35 32
a66 6
	public static String getValueManagingGroup(Matcher m, String text) {
		String value = text;
		if (m.groupCount() > 0) {
			value = m.group(1);
			if (value == null) {
				value = m.group();
d69 1
a69 1
		return value;
@

