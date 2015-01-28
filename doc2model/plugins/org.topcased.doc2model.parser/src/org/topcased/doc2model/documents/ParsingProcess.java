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
 *  Anass RADOUANI (AtoS) anass.radouani@atos.net - [#4361] Retrieve all style attribute when parsing
 *
 *****************************************************************************/
package org.topcased.doc2model.documents;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.topcased.doc2model.documents.helper.EMFHelper;
import org.topcased.doc2model.introspection.IntrospectionHelper;
import org.topcased.document.parser.documents.Document;
import org.topcased.document.parser.documents.Document.PROPERTY;

import doc2modelMapping.DocStyle;
import doc2modelMapping.Hierarchy;
import doc2modelMapping.InjectionElement;
import doc2modelMapping.LinkedElement;
import doc2modelMapping.StyleAttribute;
import doc2modelMapping.doc2model;

/**
 * The Class ParsingProcess.
 * 
 * @author tfaure
 */
public class ParsingProcess
{

    /** The document. */
    private Document document;

    /** The model. */
    private doc2model model;

    /** The emf helper. */
    private EMFHelper emfHelper = null;

    /** The introspection. */
    private IntrospectionHelper introspection = null;

    /** The root. */
    private EObject root = null;

    /** The current root element. It's a stack to push and pop some elements */
    private Stack<EObject> currentRootElement = new Stack<EObject>();

    /** The current hierarchy. */
    private Hierarchy currentHierarchy = null;

    /** The current style. */
    private String currentStyleHierarchy;

    private String currentStyle;

    /** The resource. */
    private XMIResource resource;

    /** The hierarchies. */
    private HashMap<EObject, Hierarchy> hierarchies = new HashMap<EObject, Hierarchy>();

    private String outputFile = null;

    private Checker[] checkers = null;

    private boolean saveAtFinish = true ;

    public ParsingProcess(Document doc, doc2model mappingFile, String target)
    {
        this(doc,mappingFile,target,true);
    }
    
    /**
     * Instantiates a new parsing process.
     * 
     * @param doc the doc
     * @param mappingFile the mapping file
     * @param isFolder 
     */
    public ParsingProcess(Document doc, doc2model mappingFile, String target, boolean assignExtension)
    {
        document = doc;
        model = mappingFile;
        emfHelper = new EMFHelper(mappingFile);
        introspection = new IntrospectionHelper(mappingFile,this);
        // initialize the output file
        // create the root element
        initializeOutput(target,assignExtension);
        checkers = getCheckers();
        for (Checker c : checkers)
        {
            c.initContext(this);
        }

    }

    protected Checker[] getCheckers()
    {
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.topcased.doc2model.parser.checker");
        Collection<Checker> check = new ArrayList<Checker>(elements.length);
        for (IConfigurationElement e : elements)
        {
            try
            {
                check.add((Checker) e.createExecutableExtension("instance"));
            }
            catch (CoreException e1)
            {
            }
        }
        return check.toArray(new Checker[]{});
    }

    /**
     * Initialize output (EMF).
     * 
     * @param target
     * @param isFolder 
     */
    private void initializeOutput(String target, boolean assignExtension)
    {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
        resourceSet.getPackageRegistry().put(introspection.getNSURi(), introspection.getEPackage());
        if (target == null)
        {
            target = model.eResource().getURI().toString();
            assignExtension = true ;
            saveAtFinish = false ;
        }
        if (assignExtension)
        {
            outputFile = target + "." + model.getExtension();
        }
        else
        {
            outputFile = target ;
        }
        resource = (XMIResource) resourceSet.createResource(URI.createURI(outputFile));
        Map<Object, Object> defaultLoadOptions = resource.getDefaultLoadOptions();

        defaultLoadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
        defaultLoadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
        defaultLoadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
        defaultLoadOptions.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);

        Map<Object, Object> defaultSaveOptions = resource.getDefaultSaveOptions();
        defaultSaveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
        defaultSaveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        defaultSaveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
        if (model.getProfileURI() != null && model.getProfileURI().length() > 0)
        {
            introspection.setProfile(model.getProfileURI());
        }
        root = (EObject) introspection.addElement(null, model.getInjection(), "",true);
//        root = (EObject) introspection.createObjectWithFactory(model.getInjection(), true);
//        
//        for (InjectionElement e : model.getInjection().getStandardOptionalInjections())
//        {
//            introspection.addElement(root, e, "");
//        }
        introspection.setCurrentID(root);
        currentRootElement.push(root);
        resource.getContents().add(root);
        // we fix a xmi to this element
        introspection.setId(root);
    }

    /**
     * check the text given from a node.
     * 
     * @param text the text
     */
    public void check(String text)
    {
        if (text != null)
        {
            for (Checker c : checkers)
            {
                c.check(text);
            }
        }
    }

    /**
     * Check style.
     * 
     * @param style the style
     */
    public void checkStyle(String style)
    {
        if (style != null)
        {
            currentStyle = style;
            // check for the hierarchy
            checkHierarchy(style);
            // check for identifying element from style
            checkDocStyle(style);
        }
    }
    
    /**
     * Return the last created object during analysis phase
     * @return
     */
    public EObject getLatestCreatedElement()
    {
        return introspection.getCurrentIDEobject();
    }

    /**
     * Check doc style.
     * 
     * @param style the style
     */
    private void checkDocStyle(String style)
    {
        // check if it is an identifiant
        if (emfHelper.isALinkedElement(style))
        {
            DocStyle doc = emfHelper.getDoc(style);
            EObject newElement = (EObject) introspection.addElement(currentRootElement.peek(), doc.getInjection(), document.getTextCorrespondingToCurrentStyle());
            if (newElement != null)
            {
                introspection.setCurrentID(newElement);
            }
        }
        else
        {
            LinkedElement currentID = introspection.getCurrentID();
            if (currentID != null && emfHelper.isAStyleAttribute(style, currentID))
            {
                Collection<StyleAttribute> att = emfHelper.getallStyleAttributes(style, currentID);
                for (StyleAttribute styleAttribute : att)
                {
                    if (styleAttribute != null)
                    {
                        introspection.addElement(currentRootElement.peek(), styleAttribute.getInjection(), document.getTextCorrespondingToCurrentStyle());
                    }
                }
            }
        }
    }

    /**
     * Check hierarchy. create the style if it is a hierarchy and add it int the final structure
     * 
     * @param style the style
     */
    private void checkHierarchy(String style)
    {
        // if the is a hierarchy
        if (emfHelper.isHierarchyReferencedStyle(style))
        {
            currentStyleHierarchy = style;
            boolean supEqual = false;
            // first time we create the root node
            if (currentHierarchy == null)
            {
                currentHierarchy = emfHelper.getHierarchy(style);
            }
            else
            {
                // we check if the current style is
                // higher than the previous style
                supEqual = emfHelper.supEqual((String) document.get(PROPERTY.style), currentHierarchy.getStyleValue());
            }
            EObject newElement = null;
            EObject currentRoot = null;
            if (hierarchies.isEmpty() || hierarchies.containsKey(currentRootElement.peek()))
            {
                currentRoot = getHierarchyInStack();
                if (supEqual)
                {
                    Hierarchy tmp = hierarchies.get(currentRoot);
                    while (currentRoot != null && tmp != null && emfHelper.sup((String) document.get(PROPERTY.style), tmp.getStyleValue()))
                    {
                        // currentRootElement.pop();
                        currentRoot = currentRoot.eContainer();
                        EObject backup = currentRoot;
                        while (currentRoot != null && hierarchies.get(currentRoot) == null)
                        {
                            currentRoot = currentRoot.eContainer();
                        }

                        tmp = hierarchies.get(currentRoot);

                    }
                    while (currentRoot != null && tmp != null && !emfHelper.supEqual((String) document.get(PROPERTY.style), tmp.getStyleValue()))
                    {
                        currentRoot = currentRoot.eContents().get(currentRoot.eContents().size() - 1);
                        tmp = hierarchies.get(currentRoot);
                    }
                    if (currentRoot != null && tmp != null)
                    {
                        newElement = (EObject) introspection.addElement(currentRoot.eContainer(), tmp.getInjection(), document.getTextCorrespondingToCurrentStyle());
                        currentHierarchy = emfHelper.getHierarchy(style);
                    }
                }
                else
                {
                    currentHierarchy = emfHelper.getHierarchy(style);
                    newElement = (EObject) introspection.addElement(currentRoot, currentHierarchy.getInjection(), document.getTextCorrespondingToCurrentStyle());
                }
            }
            else
            {
                currentRoot = currentRootElement.peek();
                currentHierarchy = emfHelper.getHierarchy(style);
                newElement = (EObject) introspection.addElement(currentRoot, currentHierarchy.getInjection(), document.getTextCorrespondingToCurrentStyle());
            }
            hierarchies.put(newElement, currentHierarchy);
            currentRootElement.push(newElement);
        }
    }

    private EObject getHierarchyInStack()
    {
        EObject rootTmp = currentRootElement.lastElement();
        if (rootTmp != root)
        {
            for (int i = currentRootElement.size() - 1; i >= 0; i--)
            {
                if (hierarchies.containsKey(currentRootElement.get(i)))
                {
                    rootTmp = currentRootElement.get(i);
                    break;
                }
            }
        }
        return rootTmp;
    }

    /**
     * Finish. The process is finish the resource is saved
     */
    public void finish()
    {
        try
        {
            if (saveAtFinish)
            {
                // if it is not an uri
                if (!outputFile.contains(":/"))
                {
                    File output = new File(outputFile.substring(0, outputFile.lastIndexOf(File.separator)));
                    output.mkdirs();
                    resource.save(new FileOutputStream(new File(outputFile)), Collections.EMPTY_MAP);
                }
                else
                {
                    resource.setURI(URI.createURI(outputFile));
                    resource.save(Collections.EMPTY_MAP);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public EObject getCurrentEObject()
    {
        return root;
    }

    public String getOuputModel()
    {
        return outputFile;
    }

    public EObject getCurrentRootElement()
    {
        return currentRootElement.peek();
    }

    public EMFHelper getEmfHelper()
    {
        return emfHelper;
    }

    public String getCurrentStyle()
    {
        return currentStyle;
    }

    public void setCurrentStyle(String string)
    {
        currentStyle = "";
    }

    public String getTextCorrespondingToCurrentStyle()
    {
        return document.getTextCorrespondingToCurrentStyle();
    }

    public boolean hierarchiesContainsCurrentRootElement()
    {
        return hierarchies.containsKey(getCurrentRootElement());
    }

    public void popCurrentRootElement()
    {
        currentRootElement.pop();
    }

    public void pushCurrentRootElement(EObject newElement)
    {
        currentRootElement.push(newElement);
    }

    public String getCurrentStyleHierarchy()
    {
        return currentStyleHierarchy;
    }

    public boolean isEmptyCurrentRootElement()
    {
        return currentRootElement.isEmpty();
    }

    public Hierarchy getInHierarchy(Object object)
    {
        return hierarchies.get(object);
    }

    public void putHierarchies(EObject newElement, Hierarchy htmp)
    {
        hierarchies.put(newElement, htmp);
    }

    public int getColumnNumber()
    {
        Object object = document.get(PROPERTY.column);
        if (object != null)
        {
            return (Integer) object;
        }
        else
        {
            return 0 ;
        }
    }

    public Object getCurrentRootElementStack()
    {
        return currentRootElement;
    }

    public EObject addElement(EObject rootElement, InjectionElement injection, String object)
    {
        return (EObject) introspection.addElement(rootElement, injection, object);
    }

    public void newTag()
    {
       introspection.newTag();
    }

    public void setCurrentID(EObject newElement)
    {
        introspection.setCurrentID(newElement);
    }

    public doc2model getDoc2Model()
    {
        return model;
    }
    
    public Document getDocument ()
    {
        return document;
    }
    
    public EObject getCurrentID()
    {
        return introspection.getCurrentID();
    }
    
    public String getCurrentIDString()
    {
        return introspection.getStringFromEobject(introspection.getCurrentIDEobject());
    }

}
