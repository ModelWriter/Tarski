/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 * 
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Tristan Faure (Atos Origin) tristan.faure@atosorigin.com -
 * Initial API and implementation
 * 
 *****************************************************************************/
package org.topcased.doc2model.introspection;

import org.eclipse.emf.ecore.EObject;

import doc2modelMapping.ReferenceInjection;

/**
 * The Class ReferenceUnassigned. used to store elements for unassigned
 * references
 * 
 * @author tristan.faure@atosorigin.com
 */
public class ReferenceUnassigned
{
    /** The my to assign. */
    private EObject myToAssign;

    /** The my value. */
    private String myValue;

    /** The injection. */
    private ReferenceInjection myInjection;

    /**
     * Instantiates a new reference unassigned.
     * 
     * @param injection the injection
     * @param toAssign the to assign
     * @param value the value
     */
    public ReferenceUnassigned(ReferenceInjection injection, EObject toAssign, String value)
    {

        myInjection = injection;
        myToAssign = toAssign;
        myValue = value;

    }

    /**
     * Gets the injection.
     * 
     * @return the injection
     */
    public ReferenceInjection getMyInjection()
    {

        return myInjection;

    }

    /**
     * Sets the injection.
     * 
     * @param myInjection the new injection
     */
    public void setMyInjection(ReferenceInjection myInjection)
    {

        this.myInjection = myInjection;

    }

    /**
     * Gets the to assign.
     * 
     * @return the to assign
     */
    public EObject getMyToAssign()
    {

        return myToAssign;

    }

    /**
     * Sets the to assign.
     * 
     * @param myToAssign the new my to assign
     */
    public void setMyToAssign(EObject myToAssign)
    {

        this.myToAssign = myToAssign;

    }

    /**
     * Gets the my value.
     * 
     * @return the my value
     */
    public String getMyValue()
    {

        return myValue;

    }

    /**
     * Sets the my value.
     * 
     * @param myValue the new my value
     */
    public void setMyValue(String myValue)
    {

        this.myValue = myValue;

    }

}
