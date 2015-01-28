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
package org.topcased.doc2model.introspection;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.topcased.doc2model.documents.ParsingProcess;
import org.topcased.doc2model.documents.VariableResolver;
import org.topcased.doc2model.documents.helper.Utils;
import org.topcased.doc2model.parser.Activator;
import org.topcased.doc2model.parser.UMLBundle;

import doc2modelMapping.AttributeInjection;
import doc2modelMapping.CompositionInjection;
import doc2modelMapping.DynamicElement;
import doc2modelMapping.ElementCreationInjection;
import doc2modelMapping.InjectionElement;
import doc2modelMapping.LinkedElement;
import doc2modelMapping.NewClassInjection;
import doc2modelMapping.NewClassInjectionComposite;
import doc2modelMapping.ReferenceInjection;
import doc2modelMapping.StereotpyeApplicableInjection;
import doc2modelMapping.TextFormatter;
import doc2modelMapping.doc2model;

/**
 * The Class IntrospectionHelper. manages all the operation using EMF reflexions
 * 
 * @author tristan.faure@atosorigin.com
 */
public class IntrospectionHelper
{
    /** The bundle uml permits to manages stereotypes and profiles it can be not loaded */
    private static UMLBundle uml = getUMLBundle();

    /** The instances for elements to create. */
    private HashMap<ElementCreationInjection, EObject> instancesForElementsToCreate = new HashMap<ElementCreationInjection, EObject>();

    /** The current id. */
    private EObject currentID;

    /** The objects created. */
    private HashMap<InjectionElement, EObject> objectsCreated = new HashMap<InjectionElement, EObject>();
    
    /** The all objects. */
    private HashMap<EObject, DynamicElement> allObjects = new HashMap<EObject, DynamicElement>();
    private HashMap<EObject, String> stringWhichCreatedEObjects = new HashMap<EObject, String>();

    /** The references unassigned. */
    private ReferenceUnassignedHelper referencesUnassigned = new ReferenceUnassignedHelper();

    /** Remember all the eclasses from name */
    private HashMap<String, EClass> eclasses = new HashMap<String, EClass>();

    /** The ns uri. */
    private String nsURI = null;

    /** all The package. */
    private HashMap<String, EPackage> packages = null;

    /** flag to know if the profile is applied */
    private boolean isApplyProfile = false;

    /** the uri of current profile */
    private String currentProfile;

    /** regexes caches */
    private HashMap<TextFormatter, Pattern> regexes = new HashMap<TextFormatter, Pattern>();

    /** The parsing process. */
    private ParsingProcess process = null;
    
    /** the variables registered */
    private HashMap<String,VariableResolver> variablesResolver = getVariablesResolver() ;

    /**
     * Instantiates a new introspection helper.
     * 
     * @param d the doc2model mapping file
     * @param parsingProcess 
     */
    public IntrospectionHelper(doc2model d, ParsingProcess parsingProcess)
    {
        process = parsingProcess ;
        nsURI = d.getMetamodelURI();
        if (nsURI == null || nsURI.length() == 0)
        {
            NullPointerException e = new NullPointerException("Your input doc2modelMapping is not filled correctly you can't use the parser, please renseign metamodel URI");
            Activator.log(e, IStatus.ERROR);
            throw e;
        }
        for (TreeIterator<EObject> i = d.eAllContents(); i.hasNext();)
        {
            EObject tmp = i.next();
            if (tmp instanceof TextFormatter)
            {
                TextFormatter formatter = (TextFormatter) tmp;
                if (formatter.getRegexForConditionOrGroup() != null && formatter.getRegexForConditionOrGroup().length() > 0)
                {
                    try
                    {
                        Pattern p = Pattern.compile(formatter.getRegexForConditionOrGroup(), Pattern.MULTILINE);
                        regexes.put(formatter, p);
                    }
                    catch (PatternSyntaxException p)
                    {
                        Activator.log(new Exception(String.format("The regex : %s can't be compiled", p.getPattern()), p));
                    }

                }
            }
        }
    }

    private HashMap<String, VariableResolver> getVariablesResolver()
    {
        HashMap<String, VariableResolver> result = new HashMap<String, VariableResolver> ();
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.topcased.doc2model.parser.variable");
        for (IConfigurationElement element : elements)
        {
            try
            {
                String toReplace = element.getAttribute("stringToReplace");
                if (!toReplace.contains("{") && !toReplace.contains("}"))
                {
                    result.put(toReplace, (VariableResolver) element.createExecutableExtension("variableResolver"));
                }
                else
                {
                    Activator.log(new Exception(String.format("The variable %s is not well formed it is ignored. Please don't use {}", toReplace)));
                }
            }
            catch (InvalidRegistryObjectException e)
            {
                e.printStackTrace();
            }
            catch (CoreException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * get the uml bundle registered in the platform
     * 
     * @return the bundle
     */
    private static UMLBundle getUMLBundle()
    {
        UMLBundle umlB = null;
        IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor("org.topcased.doc2model.parser.umlbundle");
        for (IConfigurationElement conf : extensions)
        {
            try
            {
                umlB = (UMLBundle) conf.createExecutableExtension("class");
            }
            catch (CoreException e)
            {
                e.printStackTrace();
            }
        }
        return umlB;
    }

    /**
     * Gets the n s_ uri.
     * 
     * @return the n s_ uri
     */
    public String getNSURi()
    {
        return nsURI;
    }

    /**
     * Gets the e package.
     * 
     * @return the e package
     */
    public EPackage getEPackage()
    {
        if (packages == null)
        {
            packages = new HashMap<String, EPackage>();
            EPackage aPackage = ExtendedMetaData.INSTANCE.getPackage(nsURI);
            if (aPackage == null)
            {
                NullPointerException ex = new NullPointerException("can't find a package identified by URI : " + nsURI);
                Activator.log(ex, IStatus.ERROR);
                throw ex;
            }
            else
            {
                packages.put(nsURI, aPackage);
            }
        }
        return packages.get(nsURI);
    }

    private EPackage getEPackage(String specificURI)
    {
        if (specificURI == null)
        {
            return getEPackage();
        }
        EPackage result = null;
        if (packages == null)
        {
            packages = new HashMap<String, EPackage>();
        }
        result = packages.get(specificURI);
        if (result == null && specificURI != null && specificURI.length() > 0)
        {
            result = ExtendedMetaData.INSTANCE.getPackage(specificURI);
            if (result == null)
            {
                NullPointerException ex = new NullPointerException("can't find a package identified by URI : " + specificURI);
                Activator.log(ex, IStatus.ERROR);
                throw ex;
            }
            else
            {
                packages.put(specificURI, result);
            }
        }
        return result;

    }

    /**
     * create an object with factory and do not apply the profile
     * 
     * @param injectionElement
     * @return
     */
    public Object createObjectWithFactory(InjectionElement injectionElement)
    {
        return createObjectWithFactory(injectionElement, false);
    }

    /**
     * Creates the object with factory.
     * 
     * @param injectionElement the injection element
     * @parma applyCurrent profile, specifies if the profile has to be applied to the created element
     * @return the object
     */
    public Object createObjectWithFactory(InjectionElement injectionElement, boolean applyCurrentProfile)
    {
        Object result = null;
        String classToCreate = null;
        String specificUri = null;
        if (injectionElement instanceof NewClassInjection)
        {
            NewClassInjection newC = (NewClassInjection) injectionElement;
            classToCreate = newC.getInstanceTarget();
            specificUri = newC.getSpecificNamespaceURI();
        }
        else if (injectionElement instanceof CompositionInjection)
        {
            CompositionInjection compI = (CompositionInjection) injectionElement;
            classToCreate = compI.getOwningClass();
            specificUri = compI.getSpecificNamespaceURI();
        }
        if (classToCreate == null || classToCreate.length() == 0)
        {
            Exception e = new Exception(String.format("Injection '%s' doesn't reference class to create please check your doc2modelmapping", injectionElement.toString()));
            Activator.log(e);
        }
        else
        {
            EClass theClass = getEClass(classToCreate, specificUri);
            // if the class == null the user has filled a wrong class name we log to prevent him to check
            if (theClass == null)
            {
                logClassNotFound(classToCreate);
            }
            else
            {
                result = EcoreUtil.create(theClass);
                if (result != null && !isApplyProfile && currentProfile != null && applyCurrentProfile)
                {
                    applyProfile(result);
                    isApplyProfile = true;
                }
            }
        }
        return result;
    }

    /**
     * manage the stereotypes depending on injection element
     * 
     * @param result
     * @param injectionElement
     */
    private void manageStereotypes(Object result, InjectionElement injectionElement)
    {
        if (result instanceof EObject)
        {
            EObject eobject = (EObject) result;
            if (injectionElement instanceof StereotpyeApplicableInjection)
            {
                StereotpyeApplicableInjection stereo = (StereotpyeApplicableInjection) injectionElement;
                if (uml != null)
                {
                    Collection<EObject> objectsCreated = uml.applyStereotypes(eobject, stereo.getStereotypeToApply());
                    for (EObject object : objectsCreated)
                    {
                        if (object != null)
                        {
                            allObjects.put(object, (DynamicElement) injectionElement.eContainer());
                        }
                    }

                }
            }
        }
    }

    /**
     * delegate to uml bundle the profile application to the object
     * 
     * @param object
     */
    private void applyProfile(Object object)
    {
        if (uml == null)
        {
            Activator.log(new Exception("WARNING : your doc2modelmapping references a Profile and you don't have Doc2model UML Bundle in your platform"));
        }
        else
        {
            if (object instanceof EObject)
            {
                EObject eobject = (EObject) object;
                uml.applyProfiles(eobject);
            }
        }
    }

    /**
     * Gets the e class.
     * 
     * @param instanceTarget the instance target
     * 
     * @return the e class
     */
    public EClass getEClass(String instanceTarget, String specificURI)
    {
        if (specificURI == null || specificURI.length() == 0)
        {
            specificURI = nsURI;
        }
        String concat = specificURI + instanceTarget;
        EClass eclass = eclasses.get(concat);
        if (eclass == null && instanceTarget != null && instanceTarget.length() > 0)
        {
            EClassifier classifier = getEPackage(specificURI).getEClassifier(instanceTarget);
            if (classifier == null)
            {
                Iterator<EPackage> i = packages.values().iterator();
                do
                {
                    if (classifier == null && uml != null)
                    {
                        classifier = uml.getEClass(instanceTarget);
                    }
                    if (classifier == null)
                    {
                        classifier = i.next().getEClassifier(instanceTarget);
                    }
                }
                while (classifier == null && i.hasNext());
            }
            if (classifier instanceof EClass)
            {
                eclass = (EClass) classifier;
                eclasses.put(concat, eclass);
            }

        }
        return eclass;
    }

    /**
     * return the eobject corresponding to stereotype application of the current Eobject
     * 
     * @param object
     * @return
     */
    public static EObject getStereotypeApplication(EObject object)
    {
        if (uml != null)
        {
            return uml.getStereotypeApplication(object);
        }
        return null;
    }

    /**
     * Gets the Object in field.
     * 
     * @param toTake instance where the value has to be taken
     * @param name the name of the field
     * 
     * @return the value of the c field in object toTake
     */
    public static Object getFieldObject(EObject toTake, String name)
    {
        EAttribute att = getAttribute(toTake, name);
        if (att != null)
        {
            return toTake.eGet(att);
        }
        else
        {
            EReference ref = getReference(toTake, name);
            if (ref != null)
            {
                return toTake.eGet(ref);
            }
        }
        return null;
    }

    /**
     * Gets the reference.
     * 
     * @param o the eobject owning the EReference
     * @param referenceName the reference name
     * 
     * @return the reference
     */
    public static EReference getReference(EObject o, String referenceName)
    {
        if (o != null)
        {
            if (referenceName == null || referenceName.length() == 0)
            {
                Activator.log(new Exception(String.format("Your doc2modelmapping file doesn't contain the reference Name for EClass : '%s'", o.eClass().getName())));
            }
            else
            {
                for (EReference e : o.eClass().getEAllReferences())
                {
                    if (referenceName.toLowerCase().equals(e.getName().toLowerCase()))
                    {
                        return e;
                    }
                }
            }
        }
        // Activator.log(new
        // Exception(String.format("Your doc2modelmapping file doesn't contain the reference Name for EClass : '%s'",
        // referenceName)));
        return null;
    }

    /**
     * Gets the Eattribute in EOBject.
     * 
     * @param o the o
     * @param attributeName the attribute name
     * 
     * @return the attribute
     */
    public static EAttribute getAttribute(EObject o, String attributeName)
    {
        for (EAttribute e : o.eClass().getEAllAttributes())
        {
            if (attributeName.toLowerCase().equals(e.getName().toLowerCase()))
            {
                return e;
            }
        }
        return null;
    }

    public Object addElement(EObject currentRootElement, InjectionElement injection, String value2, boolean applyProfile)
    {
        return addElement(currentRootElement, injection, value2, true,applyProfile);
    }
    
    public Object addElement(EObject currentRootElement, InjectionElement injection, String value2)
    {
        return addElement(currentRootElement, injection, value2, true,false);
    }

    /**
     * Adds the element from an injection and set the value.
     * 
     * @param currentRootElement the current root element can be null if injection is not a NewClassInjection
     * @param injection the injection
     * @param value the value to assign
     * @param isId tells if the creation of element must be saved as id
     * 
     * @return the object created or the object modified
     */
    public Object addElement(EObject currentRootElement, InjectionElement injection, String value2, boolean isId,boolean applyProfile)
    {
        String value = value2; 
        Object result = null;
        if (injection == null)
        {
            Activator.log(new Exception(String.format("An element with value %s has no injection can't create this element", value)));
        }
        else
        {
            String oldValue = value ;
            value = manageFormatter(injection, value);
            // value == null if manageFormatter have filtered process
            if (value == null && oldValue != null)
            {
                return result ;
            }
            // delegate the call using the injection type
            if (injection instanceof NewClassInjection)
            {
                result = addElement(currentRootElement, (NewClassInjection) injection, value,applyProfile);
                if (isId)
                {
                    setId(result);
                }
            }
            else if (injection instanceof NewClassInjectionComposite)
            {
                result = addElement(currentRootElement, (NewClassInjectionComposite) injection, value,applyProfile);
                if (isId)
                {
                    setId(result);
                }
            }
            // if currentID == null it means no objects have been already
            // created
            // so managing injections is not necessary
            else if (currentID != null)
            {
                if (injection instanceof AttributeInjection && currentID != null)
                {
                    result = addElement((AttributeInjection) injection, value);
                }
                else if (injection instanceof CompositionInjection)
                {
                    result = addElement((CompositionInjection) injection, value);
                }
                else if (injection instanceof ReferenceInjection)
                {
                    result = addElement((ReferenceInjection) injection, value);
                }
            }
            for (InjectionElement e : injection.getStandardOptionalInjections())
            {
                EObject tmp = (EObject) (result == null ? currentRootElement : result) ;
                addElement(tmp,  e, value2,false);
            }
            // we check for the new element if another elements waited for it
            if (result != null && result instanceof EObject)
            {
                referencesUnassigned.assign((EObject) result);
            }
        }
        return result;
    }

    /**
     * Manage formatter for injection element.
     * 
     * @param injection the injection
     * @param value the value
     * 
     * @return the string
     */
    private String manageFormatter(InjectionElement injection, String value)
    {
        boolean continueProcess = true ;
        // we format the string via regex and stop the process if regex stops it
        if (value != null && injection != null && injection.getStringFormat() != null)
        {
            // regex managing
            if (injection.getStringFormat().getRegexForConditionOrGroup() != null && injection.getStringFormat().getRegexForConditionOrGroup().length() > 0)
            {
                String backup = value ;
                try 
                {
                    Pattern p = regexes.get(injection.getStringFormat());
                    if (p != null)
                    {
                        Matcher matcher = p.matcher(value);
                        if (matcher.matches())
                        {
                            value = Utils.getValueManagingGroup(matcher, value);
                        }
                        else
                        {
                            value = null ;
                            continueProcess = false ;
                        }
                    }
                }
                catch (Exception e) 
                {
                    value = backup ;
                }
            }
            //  we can continue  if regex passes
            if (continueProcess)
            {
                // format application
                if (injection.getStringFormat().getPattern() != null && injection.getStringFormat().getPattern().length() > 0)
                {
                    String backup = value ;
                    try 
                    {
                        value = MessageFormat.format(injection.getStringFormat().getPattern(), value);
                    }
                    catch (IllegalArgumentException e)
                    {
                        Activator.log(e);
                        value = backup;
                    }
                }
                // variable management we replace in the string a variable by its real content
                for (String s : variablesResolver.keySet())
                {
                    if (value.contains(s))
                    {
                        value = value.replace(s, variablesResolver.get(s).getValue(process));
                    }
                }
            }
        }
        return value;
    }

    /**
     * Assign an id to object if it is an eobject
     * Not designed to be called be careful !
     * @param result
     */
    public void setId(Object result)
    {
        if (result instanceof EObject)
        {
            EObject eobject = (EObject) result;
            if (eobject.eResource() != null && eobject.eResource() instanceof XMIResource)
            {
                ((XMIResource) eobject.eResource()).setID(eobject, EcoreUtil.generateUUID());
            }
        }
    }

    /**
     * Adds the element for a reference injection.
     * 
     * @param injection the ReferenceInjection
     * @param value the value
     * 
     * @return the object
     */
    private Object addElement(ReferenceInjection injection, String value)
    {
        EObject targetElement = objectsCreated.get(injection.getDependsWith());
        EObject targetElementRef = targetElement;
        EObject tmp = null;
        if (targetElement != null)
        {
            // we check if the reference references an already created element
            EClass eclass = getEClass(injection.getClassReferenced(), null);
            if (eclass == null)
            {
                logClassNotFound(injection.getClassReferenced());
            }
            else
            {
                for (EObject o : allObjects.keySet())
                {
                    // DynamicElement d = allObjects.get(o);
                    EObject object = o;
                    if (injection.isIsStereotypeReference() && uml != null)
                    {
                        object = uml.getStereotypeApplication(o);
                        targetElementRef = uml.getStereotypeApplication(targetElement);
                    }
                    if (eclass != null && object != null && isAsssignable(eclass, object))
                    {
                        // check the regex
                        Object fieldObject = getFieldObject(object, injection.getAttributeToFind());
                        if (fieldObject != null && fieldObject.equals(value))
                        {
                            tmp = object;
                            assignReference(injection, targetElementRef, tmp);
                        }
                    }
                    if (tmp != null)
                    {
                        break;
                    }
                }
            }
            // if the element is not created we register the element
            // to the referencesUnassignedHelper
            if (tmp == null && eclass != null)
            {
                if (injection.isIsStereotypeReference() && uml != null)
                {
                    referencesUnassigned.need(injection, targetElementRef, value, eclass.getClass());
                }
                else
                {
                    referencesUnassigned.need(injection, targetElementRef, value, eclass.getClass());
                }
            }
        }
        return targetElement;
    }

    private boolean isAsssignable(EClass eclass, EObject object)
    {
        if (eclass.getInstanceClass() != null)
        {
            return eclass.getInstanceClass().isAssignableFrom(object.getClass());
        }
        else
        {
            return eclass.equals(object.eClass());
        }
    }

    /**
     * Log that a class is not found
     * 
     * @param className
     */
    private void logClassNotFound(String className)
    {
        Exception e = new Exception(String.format("Can't create ECLASS : '%s', please check your metamodel identified by URI : '%s'", className, nsURI));
        Activator.log(e);
    }

    /**
     * Assign reference an EObject to other using a EReference.
     * 
     * @param injection the injection
     * @param targetElement the element owning the EReference
     * @param toAssign the element to assign to targetElement
     */
    public static void assignReference(ReferenceInjection injection, EObject targetElement, EObject toAssign)
    {
        EReference ref = getReference(targetElement, injection.getReferenceAttribute());
        // if ref == null maybe the reference is owned by stereotype
        if (ref == null && uml != null)
        {
            targetElement = uml.getStereotypeApplication(targetElement) ;
            ref = getReference(targetElement, injection.getReferenceAttribute());
        }
        if (ref != null)
        {
            if (ref.getUpperBound() == -1 || ref.getUpperBound() > 1)
            {
                Object list = targetElement.eGet(ref);
                if (list instanceof EList)
                {
                    EList Clist = (EList) list;
                    Clist.add(toAssign);
                }
            }
            else
            {
                targetElement.eSet(ref, toAssign);
            }
        }
    }

    /**
     * Adds the element to attribute of an object alreadu created.
     * 
     * @param injection the injection
     * @param value the value
     * 
     * @return the object
     */
    private Object addElement(AttributeInjection injection, String value)
    {
        Object targetElement = objectsCreated.get(injection.getDependsWith());
        if (targetElement != null)
        {
            setValueToField(injection.getInstanceAttribute(), value, targetElement);
            if (uml == null && injection.getStereotypeAttribute() != null && injection.getStereotypeAttribute().length() > 0)
            {
                Activator.log(new Exception(String.format("The stereotype : %s can't be applied the uml bundle is not contained the platform", injection.getStereotypeAttribute())));
            }
            else if (uml != null && injection.getStereotypeAttribute() != null && injection.getStereotypeAttribute().length() > 0)
            {
                assignStereotypeField(injection, value, targetElement);
            }
        }
        else
        {
            Activator.log(new Exception(String.format("Problem occurs, when the attribute %s with value %s tried to be injected", injection.getInstanceAttribute(), value)));
        }
        return targetElement;
    }

    /**
     * Assign attribute stereotype
     * 
     * @param injection
     * @param value
     * @param targetElement
     */
    private void assignStereotypeField(AttributeInjection injection, String value, Object targetElement)
    {
        assignStereotypeField(injection.getStereotypeAttribute(), value, targetElement);
    }

    /**
     * Assign attribute stereotype
     * 
     * @param attribute
     * @param value
     * @param targetElement
     */
    private void assignStereotypeField(String attribute, String value, Object targetElement)
    {
        if (uml != null)
        {
            uml.assignStereotypeValue(attribute, value, targetElement);
        }
    }

    /**
     * Adds the element filtering the good New Class Injection.
     * 
     * @param currentRootElement the current root element
     * @param injection the injection
     * @param value the value
     * 
     * @return the object
     */
    private Object addElement(EObject currentRootElement, NewClassInjectionComposite injection, String value,boolean applyProfile)
    {
        Object targetElement = null;
        boolean found = false;
        for (NewClassInjection currentInjection : injection.getInjections())
        {
            EClass eclass = getEClass(currentInjection.getOwningClass(), currentInjection.getSpecificNamespaceURI());
            if (currentRootElement != null && eclass.getInstanceClass().isAssignableFrom(currentRootElement.getClass()))
            {
                found = true;
                targetElement = addElement(currentRootElement, currentInjection, value,applyProfile);
                break;
            }
        }
        if (targetElement == null && !found)
        {
            Activator.log(new Exception(String.format("A new class injection composite %s contains no candidate for current tag with value %s", injection.toString(), value)));
        }
        return targetElement;
    }

    /**
     * Adds the element.
     * 
     * @param currentRootElement the current root element
     * @param injection the injection
     * @param value the value
     * 
     * @return the object
     */
    private Object addElement(EObject currentRootElement, NewClassInjection injection, String value, boolean applyProfile)
    {
        Object targetElement = createObjectWithFactory(injection,applyProfile);
        if (targetElement != null)
        {
            if (getDynamicElement(injection) instanceof DynamicElement && targetElement instanceof EObject)
            {
                saveObjectsCreated(injection, targetElement,value);
            }
            if (injection.getAttributeForValue() != null && injection.getAttributeForValue().length() != 0)
            {
                setValueToField(injection.getAttributeForValue(), value, targetElement);
            }
            EClass eclass = getEClass(injection.getOwningClass(), injection.getSpecificNamespaceURI());
            if (eclass == null && currentRootElement != null)
            {
                Exception e = new Exception(String.format("Can't find ECLASS : '%s' supposed to contain ECLASS : '%s', please check your metamodel identified by URI : '%s'",
                        injection.getOwningClass(), injection.getInstanceTarget(), nsURI));
                Activator.log(e);
            }
            // eclass exists we can continue the process
            else if (currentRootElement != null && eclass.getInstanceClass().isAssignableFrom(currentRootElement.getClass()))
            {
                if (!assignObjectsforNewClassInjection(currentRootElement, injection, value, targetElement))
                {
                    Activator.log(new Exception(String.format("Can't assign element of ECLASS : %s to eContainer by reference : %s", targetElement.getClass().getName(),
                            injection.getAssociationOwning())));
                }
            }
            else
            {
                // in some cases it's necesary to check if it's not owner which can contain object
                EObject tmp = currentRootElement;
                boolean found = false;
                if (injection.isBrowseTopContainersForOwner())
                {
                    while (tmp != null && tmp.eContainer() != null)
                    {
                        if (assignObjectsforNewClassInjection(tmp.eContainer(), injection, value, targetElement))
                        {
                            found = true;
                            break;
                        }
                        tmp = tmp.eContainer();
                    }
                }
                // we log only if the element is not the doc2model
                if (!found && !(injection.eContainer() instanceof doc2model))
                {
                    Activator.log(new Exception(String.format("An element with value %s of type : %s can't be contained by %s", value, injection.getInstanceTarget(),
                            currentRootElement != null ? currentRootElement.toString() : "null")));
                }
            }
        }
        return targetElement;
    }

    private boolean assignObjectsforNewClassInjection(EObject currentRootElement, NewClassInjection injection, String value, Object targetElement)
    {
        // reference the object created to its owning class
        EReference ref = getReference(currentRootElement, injection.getAssociationOwning());
        if (ref != null)
        {
            assignReferenceFromEObject(currentRootElement, targetElement, ref);
            manageStereotypes(targetElement, injection);
            if (injection.getStereotypeAttributeForValue() != null && injection.getStereotypeAttributeForValue().length() != 0)
            {
                assignStereotypeField(injection.getStereotypeAttributeForValue(), value, targetElement);
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    /**
     * Keeps a reference on objects created.
     * 
     * @param injection the injection
     * @param targetElement the target element
     * @param value 
     */
    private void saveObjectsCreated(InjectionElement injection, Object targetElement, String value)
    {
        if (injection.eContainer() != null && injection.eContainer() instanceof NewClassInjectionComposite)
        {
            objectsCreated.put((InjectionElement) injection.eContainer(), (EObject) targetElement);
        }
        else
        {
            objectsCreated.put(injection, (EObject) targetElement);
        }
        allObjects.put((EObject) targetElement, getDynamicElement(injection));
        stringWhichCreatedEObjects.put((EObject)targetElement, value);
    }

    private DynamicElement getDynamicElement(InjectionElement injection)
    {
        EObject current = injection.eContainer();
        while (current != null && !(current instanceof DynamicElement))
        {
            current = current.eContainer();
        }
        return (DynamicElement) current;
    }

    /**
     * New tag. Notify that a new Tag is already processed
     */
    public void newTag()
    {
        instancesForElementsToCreate.clear();
    }

    /**
     * Adds the element.
     * 
     * @param injection the injection to get information
     * @param value the value to assign
     * 
     * @return the object
     */
    private Object addElement(CompositionInjection injection, String value)
    {
        Object targetElement = null;
        if (injection.isNewInstanceForEachComposition() || instancesForElementsToCreate.get(injection.getDependsWith()) == null)
        {
            targetElement = createObjectWithFactory(injection);
            if (targetElement != null)
            {
                instancesForElementsToCreate.put(injection.getDependsWith(), (EObject) targetElement);
                if (injection.eContainer() instanceof DynamicElement && targetElement instanceof EObject)
                {
                    saveObjectsCreated(injection, targetElement,value);
                }
                EObject container = objectsCreated.get(injection.getDependsWith());
                if (container != null)
                {
                    EReference ref = getReference(container, injection.getAssociationName());
                    if (ref != null)
                    {
                        assignReferenceFromCompositionInjection(injection, targetElement, container, ref);
                    }
                }
            }
        }
        else
        {
            targetElement = instancesForElementsToCreate.get(injection.getDependsWith());
        }
        if (injection.getAttributeName() != null)
        {
            setValueToField(injection.getAttributeName(), value, targetElement);
        }
        return targetElement;
    }

    /**
     * Assign reference from EObject.
     * 
     * @param currentRootElement the current root element
     * @param targetElement the target element to assign
     * @param ref the reference to use
     */
    private void assignReferenceFromEObject(EObject currentRootElement, Object targetElement, EReference ref)
    {
        if (ref.getUpperBound() == -1 || ref.getUpperBound() > 1)
        {
            Object list = currentRootElement.eGet(ref);
            if (list != null && list instanceof EObjectContainmentEList)
            {
                EObjectContainmentEList Clist = (EObjectContainmentEList) list;
                try
                {
                    Clist.add(targetElement);
                }
                catch (Exception e)
                {
                }
            }
        }
        else
        {
            currentRootElement.eSet(ref, targetElement);
        }
    }

    /**
     * Assign reference from composition injection.
     * 
     * @param injection the injection to get information
     * @param targetElement the target element
     * @param container the container
     * @param ref the ref to use
     */
    private void assignReferenceFromCompositionInjection(CompositionInjection injection, Object targetElement, EObject container, EReference ref)
    {
        if (ref.getUpperBound() == -1 || ref.getUpperBound() > 1)
        {
            Object list = container.eGet(getReference(container, injection.getAssociationName()));
            if (list != null && list instanceof EObjectEList)
            {
                EObjectEList Clist = (EObjectEList) list;
                Clist.add(targetElement);
            }
        }
        else
        {
            container.eSet(ref, targetElement);
        }
    }

    /**
     * Sets the value to field. Set a determined value to a field
     * 
     * @param attributeName the attribute name
     * @param value the value
     * @param targetElement the element owning the field
     */
    private void setValueToField(String attributeName, String value, Object targetElement)
    {
        if (attributeName != null && attributeName.length() != 0 && targetElement instanceof EObject)
        {
            EObject target = (EObject) targetElement;
            EAttribute attr = getAttribute(target, attributeName);
            if (attr != null)
            {
                if (attr.getUpperBound() != 1)
                {
                    Collection collec = (Collection) target.eGet(attr);
                    if (collec != null)
                    {
                        collec.add(getCorrespondingValue4Type(attr, value));
                    }
                }
                else
                {
                    target.eSet(attr, getCorrespondingValue4Type(attr, value));
                }
            }
            else
            {
                Activator.log(new Exception(String.format("Attribute : '%s' can't be found in class : '%s'. Please check Metamodel identified by URI : '%s'", attributeName,
                        targetElement != null ? targetElement.getClass().getName() : "no class", nsURI)));
            }
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
    private Object getCorrespondingValue4Type(EAttribute attr, String value)
    {
        String javaInstanceTypeName = EcoreUtil.toJavaInstanceTypeName(attr.getEGenericType());
        try
        {
            if ("boolean".equals(javaInstanceTypeName) || "java.lang.Boolean".equals(javaInstanceTypeName))
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
            else if ("integer".equals(javaInstanceTypeName) || "java.lang.Integer".equals(javaInstanceTypeName))
            {
                return Integer.valueOf(value);
            }
            else if ("double".equals(javaInstanceTypeName) || "java.lang.Double".equals(javaInstanceTypeName))
            {
                return Double.valueOf(value);
            }
            else if ("float".equals(javaInstanceTypeName) || "java.lang.Float".equals(javaInstanceTypeName))
            {
                return Float.valueOf(value);
            }
            else
            {
                return value;
            }
        }
        catch (NumberFormatException e)
        {
            Activator.log(new Exception(String.format("The value %s can't be assigned to this type : %s", value, javaInstanceTypeName)));
            return null;
        }
    }

    /**
     * Sets the current id.
     * 
     * @param newElement the new current id
     */
    public void setCurrentID(EObject newElement)
    {
        this.currentID = newElement;
    }

    /**
     * Gets the current id.
     * 
     * @return the current id
     */
    public LinkedElement getCurrentID()
    {
        for (InjectionElement e : objectsCreated.keySet())
        {
            if (e.eContainer() instanceof LinkedElement && objectsCreated.get(e) == currentID)
            {
                return (LinkedElement) e.eContainer();
            }
        }
        return null;
    }
    
    public EObject getCurrentIDEobject()
    {
        return currentID;
    }

    public void setProfile(String profileURI)
    {
        if (uml != null)
        {
            currentProfile = profileURI;
            uml.setProfile(profileURI);
        }
    }
    
    public String getStringFromEobject(EObject e)
    {
        return stringWhichCreatedEObjects.get(e);
    }
}
