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

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import doc2modelMapping.ReferenceInjection;

/**
 * The Class ReferenceUnassignedHelper. manages all the unassigned references
 * 
 * @author tristan.faure@atosorigin.com
 */
public class ReferenceUnassignedHelper
{
    /** The references. */
    private HashMap < Class, LinkedList < ReferenceUnassigned >> references = new HashMap < Class, LinkedList < ReferenceUnassigned >>();

    /**
     * Need. an object need a reference and ask this class to remember its
     * needing
     * 
     * @param injection the injection
     * @param toAssign the to assign
     * @param value the value
     */
    public void need(ReferenceInjection injection, EObject toAssign, String value, Class theClass)
    {
        if (references.get(theClass) == null)
        {
            references.put(theClass, new LinkedList < ReferenceUnassigned >());
        }
        ReferenceUnassigned r = new ReferenceUnassigned(injection, toAssign, value);
        references.get(theClass).add(r);
    }

    /**
     * Assign. Assign a reference stored
     * 
     * @param newReference the new reference
     */
    public void assign(EObject newReference)
    {
        for (Class c : references.keySet())
        {
            if (c.isAssignableFrom(newReference.getClass()) || EClass.class.isAssignableFrom(c))
            {
                LinkedList < ReferenceUnassigned > unassigned = references.get(c);
                if (unassigned != null && !unassigned.isEmpty())
                {
                    boolean found = false;
                    for (Iterator < ReferenceUnassigned > i = unassigned.iterator(); !found && i.hasNext();)
                    {
                        ReferenceUnassigned element = i.next();
                        ReferenceInjection injection = element.getMyInjection();
                        if (injection.isIsStereotypeReference())
                        {
                            EObject newR = IntrospectionHelper.getStereotypeApplication(newReference);
                            if (newR != null)
                            {
                                newReference = newR;
                            }
                        }
                        Object fieldObject = IntrospectionHelper.getFieldObject(newReference, injection.getAttributeToFind());
                        if (fieldObject != null && fieldObject.equals(
                                element.getMyValue()))
                        {
                            IntrospectionHelper.assignReference(injection, element.getMyToAssign(), newReference);
                            i.remove();
                            found = true;
                        }
                    }
                }
            }
        }
    }
}
