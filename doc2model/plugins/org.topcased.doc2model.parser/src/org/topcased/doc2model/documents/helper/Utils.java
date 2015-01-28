/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.doc2model.documents.helper;

import java.util.regex.Matcher;

/**
 * The Class Utils.
 */
public final class Utils
{
    private Utils()
    {
        
    }
    
    public static String getValueManagingGroup(Matcher m, String text)
    {
        String value = text;
        if (m.groupCount() > 0)
        {
            value = m.group(1);
            if (value == null)
            {
                value = m.group();
            }
        }
        return value;
    }
}
