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
package org.topcased.doc2model.resolvers;

import java.text.DateFormat;
import java.util.Date;

import org.topcased.doc2model.documents.ParsingProcess;
import org.topcased.doc2model.documents.VariableResolver;

/**
 * The Class DateResolver.
 */
public class DateResolver implements VariableResolver
{

    public DateResolver()
    {
    }

    public String getValue(ParsingProcess parser)
    {
        return DateFormat.getInstance().format(new Date());
    }

}
