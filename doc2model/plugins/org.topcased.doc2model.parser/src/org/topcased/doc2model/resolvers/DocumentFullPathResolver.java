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

import org.topcased.doc2model.documents.ParsingProcess;
import org.topcased.doc2model.documents.VariableResolver;

/**
 * The Class DocumentFullPathResolver.
 */
public class DocumentFullPathResolver implements VariableResolver
{

    public DocumentFullPathResolver()
    {
    }

    public String getValue(ParsingProcess parser)
    {
        return parser.getDocument().getDocumentFile().getAbsolutePath();
    }

}
