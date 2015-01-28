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
package org.topcased.doc2model.umlbundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.operations.ProfileOperations;
import org.topcased.doc2model.parser.Activator;
import org.topcased.doc2model.parser.UMLBundle;

@SuppressWarnings("restriction")
public class UMLBundleImpl implements UMLBundle
{

    private Collection<Profile> currentProfiles = null;

    private List<EPackage> thePackages = new ArrayList<EPackage>();

    public UMLBundleImpl()
    {
    }

    
//    private EObject applyTheStereotype(Element element, String stereotypeToApply)
//    {
//        if (stereotypeToApply.contains(";"))
//        {
//            String[] stereotypes = stereotypeToApply.split(";");
//            for (String stereotype : stereotypes)
//            {
//                return applyTheStereotype_(element, stereotype);
//            }
//        }
//        return applyTheStereotype_(element, stereotypeToApply);
//    }
    
//    private Collection<EObject> applyTheStereotype(Element element, String stereotypeToApply)
//    {
//        Collection<EObject> result = new ArrayList<EObject>();
//        if (stereotypeToApply.contains(";"))
//        {
//            String[] stereotypes = stereotypeToApply.split(";");
//            for (String stereotype : stereotypes)
//            {
//                result.add(applyTheStereotype_(element, stereotype));
//            }
//            return result;
//        }
//        return Arrays.asList(applyTheStereotype_(element, stereotypeToApply));
//    }
    
    private EObject applyTheStereotype(Element element, String stereotypeToApply)
    {
        if (stereotypeToApply != null)
        {
            for (Stereotype s : element.getApplicableStereotypes())
            {
                if (stereotypeToApply.equals(s.getName()))
                {
                    EObject created = element.applyStereotype(s);
                    return created;
                }
            }
        }
        return null;
    }

    /**
     * Use applyStereotypes instead 
     */
    @Deprecated
    public EObject applyStereotype(EObject eobject, String name)
    {
        Iterator<EObject> result = applyStereotypes(eobject, name).iterator();
        return result.hasNext()? result.next():null;
    }
    
    public Collection<EObject> applyStereotypes(EObject eobject, String name)
    {
        Collection<EObject> result = new ArrayList<EObject>();
        if (name != null && name.contains(";"))
        {
            String[] stereotypes = name.split(";");
            for (String stereotype : stereotypes)
            {
                result.add(applyStereotype_(eobject, stereotype));
            }
            return result;
        } 
        return Arrays.asList(applyStereotype_(eobject, name));
    }
    
    
    
    public EObject applyStereotype_(EObject eobject, String name)
    {
        if (eobject instanceof Element)
        {
            Element element = (Element) eobject;
            EObject created = applyTheStereotype(element, name);
            return created;
        }
        else if (name != null && name.length() > 0)
        {
            Activator.log(new Exception(String.format("element typed : %s can't have stereotypes it's not derived from UML Element", eobject.eClass().getName())));
        }
        return null;
    }
    
    
    public void applyProfiles(EObject object)
    {
        for (Profile profile : currentProfiles)
        {
            applyTheProfile(object, profile);
        }
    }
    
    private void applyTheProfile(EObject object, Profile profile)
    {
        if (profile != null)
        {
            if (object instanceof Package)
            {
                Package pack = (Package) object;
                // apply all the profile contained to manage nested profiles 
                pack.applyProfile(profile);
                for (Iterator<EObject> i = EcoreUtil.getAllProperContents(profile,false) ; i.hasNext() ; )
                {
                    EObject next = i.next();
                    if (next instanceof Profile)
                    {
                        Profile p = (Profile) next;
                        try {
                            pack.applyProfile(p);
                            thePackages.add(ProfileOperations.getDefinition(p));
                        }
                        catch (RuntimeException e){
                            Activator.log(new Exception(String.format("profile %s can't be applied to element typed : %s", p.getName(), object.eClass().getName())));
                        }
                    }
                }
                thePackages.add(ProfileOperations.getDefinition(profile));
            }
            else
            {
                Activator.log(new Exception(String.format("profile %s can't be applied to element typed : %s", profile.getName(), object.eClass().getName())));
            }
        }
    }

    /**
     * Use applyProfiles() instead
     */
    @SuppressWarnings("restriction")
    @Deprecated
    public void applyProfile(EObject object)
    {
        if (currentProfiles.iterator().hasNext())
        {
            applyTheProfile(object, currentProfiles.iterator().next());
        }
    }

    public void setProfile(String profileURI)
    {
        currentProfiles = new ArrayList<Profile>();
        if (profileURI.contains(";"))
        {
            String[] profiles = profileURI.split(";");
            for (String profile : profiles)
            {
                setProfile_(profile);
            }
        }
        else
        {
            setProfile_(profileURI);
        }
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.doc2model.parser.UMLBundle#setProfile(java.lang.String)
     */
    public void setProfile_(String profileURI)
    {
        if (currentProfiles == null)
        {
            Activator.log(new Exception("a problem occurs during profile, current profile liste is null"));
            return;
        }
        
        try
        {
            ResourceSet resSet = new ResourceSetImpl();
            Resource res = resSet.getResource(URI.createURI(profileURI).trimFragment(), true);
//            currentProfile = (Profile) EcoreUtil.getObjectByType(res.getContents(), UMLPackage.Literals.PROFILE);
            currentProfiles.add((Profile) EcoreUtil.getObjectByType(res.getContents(), UMLPackage.Literals.PROFILE));
        }
        catch (Exception e)
        {
            Activator.log(new Exception(String.format("a problem occurs during profile loading please check uri : %s", profileURI)));
        }

    }

    public void assignStereotypeValue(String qualifiedPropertyName, String value, Object targetElement)
    {
        String propertyName = qualifiedPropertyName;
        String stereotypeQualifiedName = null;
        
        int index = qualifiedPropertyName.lastIndexOf("::");
        if (index >= 0) {
            propertyName = qualifiedPropertyName.substring(index+2);
            stereotypeQualifiedName = qualifiedPropertyName.substring(0, index);
        }

        if (targetElement instanceof Element)
        {
            Element element = (Element) targetElement;
            Stereotype stereotype = null;
            if (stereotypeQualifiedName != null) {
                stereotype = element.getAppliedStereotype(stereotypeQualifiedName);
            }
            if (stereotype == null && !element.getAppliedStereotypes().isEmpty()) {
                stereotype = element.getAppliedStereotypes().get(0);
            }
            // normally the element must have one stereotype applied
            if (stereotype != null)
            {
                
                Property theProperty = stereotype.getAttribute(propertyName, null);
                if (theProperty != null)
                {
                    if (theProperty.isMultivalued())
                    {
                        Collection elements = (Collection) element.getValue(stereotype, propertyName);
                        elements.add(getCorrespondingValue4UMLType(theProperty, value));
                    }
                    else
                    {
                        element.setValue(stereotype, propertyName, getCorrespondingValue4UMLType(theProperty, value));
                    }
                }
                else
                {
                    Activator.log(new Exception(String.format("the element typed %s doesn't have attributes named %s", targetElement.getClass().getName(), propertyName)));
                }
            }
            else
            {
                Activator.log(new Exception(String.format("the element typed %s can't have stereotype attribute %s it doesn't have stereotype applied", targetElement.getClass().getName(), value)));
            }

        }
        else
        {
            Activator.log(new Exception(String.format("the element typed %s can't have stereotype attributes it is not derived from UML Element", targetElement.getClass().getName())));
        }

    }

    /**
     * Gets the corresponding value for EMF type.
     * 
     * @param attr the attr
     * @param value the value
     * 
     * @return the corresponding value4 type
     */
    private Object getCorrespondingValue4UMLType(Property attr, String value)
    {
        if (attr.getType() != null)
        {
            String javaInstanceTypeName = attr.getType().getName();
            try
            {
                if (attr.getType() instanceof Enumeration)
                {
                    for (EnumerationLiteral l : ((Enumeration) attr.getType()).getOwnedLiterals())
                    {
                        if (value.equals(l.getName()))
                        {
                            return l ;
                        }
                    }
                }
                else if ("Boolean".equals(javaInstanceTypeName))
                {
                    if ("false".equals(value.toLowerCase()) || "true".equals(value.toLowerCase()))
                    {
                        return Boolean.valueOf(value);
                    }
                    else
                    {
                        Activator.log(new Exception(String.format("The value %s can't be assigned in Boolean, false is setted by default", value)));
                        return false;
                    }
                }
                else if ("Integer".equals(javaInstanceTypeName))
                {
                    return Integer.valueOf(value);
                }
                else
                {
                    return value;
                }
            }
            catch (NumberFormatException e)
            {
                Activator.log(new Exception(String.format("The value %s can't be assigned to this type : %s", value, javaInstanceTypeName)));
            }
        }
        return null;
    }

    public EClassifier getEClass(String instanceTarget)
    {
        if (thePackages != null && !thePackages.isEmpty())
        {
            for (EPackage p : thePackages)
            {
                EClassifier type = p.getEClassifier(instanceTarget);
                if (type != null)
                {
                    return type;
                }
            }
        }
        return null;
    }

    public EObject getStereotypeApplication(EObject object)
    {
        if (object instanceof Element)
        {
            Element element = (Element) object;
            if (element.getStereotypeApplications().size() > 0)
            {
                return element.getStereotypeApplications().get(0);
            }
        }
        return null;
    }

}
