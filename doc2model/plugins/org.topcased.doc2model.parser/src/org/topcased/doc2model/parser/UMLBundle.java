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
package org.topcased.doc2model.parser;

import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * The Interface UMLBundle.
 * permits to manipulate profile operations on eobjects
 */
public interface UMLBundle
{
    
    /**
     * Sets the profile
     * 
     * @param uri the new profile
     */
    void setProfile(String uri) ;
    
    /**
     * Apply profile.
     * 
     * @param object the object
     */
    void applyProfile (EObject object);
    
    /**
     * Apply stereotypes
     * @param eobject the eobject to apply stereotypes to
     * @param name the stereotypes to apply qualified names separated by ";" if many 
     * @return the stereotype application
     */
    Collection<EObject> applyStereotypes(EObject eobject, String name);
    
    /**
     * Apply stereotype.
     * 
     * @param object the object
     * @param name the name
     * 
     * @return the e object
     */
    EObject applyStereotype (EObject object, String name); 
    
    /**
     * Assign stereotype value.
     * 
     * @param property the property
     * @param value the value
     * @param targetElement the target element
     */
    void assignStereotypeValue(String property, String value, Object targetElement);
    
    /**
     * Gets the e class.
     * 
     * @param instanceTarget the instance target
     * 
     * @return the e class
     */
    EClassifier getEClass (String instanceTarget) ;

    /**
     * Gets the stereotype application.
     * 
     * @param object the object
     * 
     * @return the stereotype application
     */
    EObject getStereotypeApplication(EObject object);

    /**
     * Apply profiles to the eobject
     * @param eobject the eobject ot apply profile to
     */
    void applyProfiles(EObject eobject);
}
