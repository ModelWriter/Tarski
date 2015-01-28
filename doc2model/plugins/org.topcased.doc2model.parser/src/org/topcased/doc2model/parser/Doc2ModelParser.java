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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.topcased.doc2model.documents.ParsingProcess;
import org.topcased.document.parser.Activator;
import org.topcased.document.parser.documents.Document;
import org.topcased.document.parser.documents.DocumentFactory;
import org.topcased.document.parser.documents.Document.PROPERTY;

import doc2modelMapping.doc2model;

/**
 * The Class Doc2ModelParser.
 * 
 * @author tristan.faure@atosorigin.com
 */
public class Doc2ModelParser
{
    /** The document file. */
    private File documentFile;

    /** The mapping file. */
    private File mappingFile;

    /** The process. */
    private ParsingProcess process;

    /** The doc. */
    private Document doc;

    /** The observer if the caller needs a progression. */
    private ProgressionObserver theObserver = null;

    /** The doc to count used for progression. */
    private Document docToCount;

    private URI uriMappingFile;

    /**
     * @param document the input document
     * @param mapping the mapping file path
     * @param target the target file
     * @param assignExtension specify if the extension has to be set
     * @throws FileNotFoundException
     */
    public Doc2ModelParser(String document, String mapping, String target, boolean assignExtension) throws FileNotFoundException
    {
        this(document, mapping, target, null, assignExtension);
    }
    
    /**
     * @param document, the input document
     * @param mapping, the doc2model mapping
     * @param target, the target file
     * @throws FileNotFoundException
     */
    public Doc2ModelParser(String document, doc2model mapping, String target) throws FileNotFoundException
    {
        this(document, mapping, target, null, true);
    }
    
    /**
     * Instantiates a new doc2 model parser.
     * 
     * @param document the file path to parse
     * @param mapping the file path to get de doc2model mapping
     * @param target path
     * @throws FileNotFoundException
     */
    public Doc2ModelParser(String document, String mapping, String target) throws FileNotFoundException
    {
        this(document, mapping, target, null);
    }

    /**
     * Instantiates a new doc2 model parser without creating a target file
     * in memory work
     * @param document the document
     * @param model the model
     * @param configuration the configuration
     * @param assignExtension the assign extension
     * 
     * @throws FileNotFoundException the file not found exception
     */
    public Doc2ModelParser(String document, doc2model model, Map<Document.CONFIGURATION, Boolean> configuration, boolean assignExtension) throws FileNotFoundException
    {
        initDocument(document);
        // get the factory depending of the file
        DocumentFactory factory = getFactory();
        if (factory != null)
        {
            if (model != null)
            {
                createProcess(model, null, configuration, factory,assignExtension);
            }
            else
            {
                throw new IllegalArgumentException("Please provide a doc 2 model");
            }
        }
        else
        {
            Activator.log(new IllegalArgumentException("Invalid document " + document), IStatus.ERROR);
        }
    }    
    /**
     * Instantiates a new doc2 model parser.
     * 
     * @param document the file path to parse
     * @param mapping the file path to get de doc2model mapping
     * @param target the target file
     * @param configuration specify configuration for keys please renseign static string beginning with CONFIG_ from
     *        Document
     * @throws FileNotFoundException the file not found exception
     */
    public Doc2ModelParser(String document, doc2model model, String target, Map<Document.CONFIGURATION, Boolean> configuration, boolean assignExtension) throws FileNotFoundException
    {
        initDocument(document);
        // get the factory depending of the file
        DocumentFactory factory = getFactory();
        if (factory != null)
        {
            if (model != null)
            {
                createProcess(model, target, configuration, factory,assignExtension);
            }
            else
            {
                throw new IllegalArgumentException("Please provide a doc 2 model");
            }
        }
        else
        {
            Activator.log(new IllegalArgumentException("Invalid document " + document), IStatus.ERROR);
        }
    }

    public Doc2ModelParser(String document, String mapping, String target, Map<Document.CONFIGURATION, Boolean> configuration) throws FileNotFoundException
    {
        this (document,mapping,target,configuration,true);
    }
    /**
     * Instantiates a new doc2 model parser.
     * 
     * @param document the file path to parse
     * @param mapping the file path to get de doc2model mapping
     * @param target the target folder
     * @param configuration specify configuration for keys please renseign static string beginning with CONFIG_ from
     *        Document
     * @throws FileNotFoundException the file not found exception
     */
    public Doc2ModelParser(String document, String mapping, String target, Map<Document.CONFIGURATION, Boolean> configuration, boolean assignExtension) throws FileNotFoundException
    {
        doc2model model = initMapping(mapping);
        initDocument(document);
        // get the factory depending of the file
        DocumentFactory factory = getFactory();
        if (factory != null)
        {
            createProcess(model, target, configuration, factory,assignExtension);
        }
        else
        {
            Activator.log(new IllegalArgumentException("Invalid document " + document), IStatus.ERROR);
        }
    }

    private doc2model initMapping(String mapping)
    {
        mappingFile = new File(mapping);
        if (!mappingFile.exists())
        {
            uriMappingFile = URI.createURI(mapping);
        }
        doc2model model = loadDoc2Model();
        if (model == null)
        {
            throw new IllegalArgumentException("Invalid document " + mapping);
        }
        return model;
    }

    private void initDocument(String document) throws FileNotFoundException
    {
        documentFile = new File(document);
        if (!documentFile.exists())
        {
            throw new FileNotFoundException(String.format("Input file located at :\n%s\ndoesn't exist", documentFile.getAbsolutePath()));
        }
    }

    private void createProcess(doc2model model, String target, Map<Document.CONFIGURATION, Boolean> configuration, DocumentFactory factory, boolean assignExtension)
    {
        doc = factory.loadDocument(documentFile, configuration);
        docToCount = factory.loadDocument(documentFile, configuration);
        process = new ParsingProcess(doc, model, target, assignExtension);
    }

    
    /**
     * Load doc2 model.
     * 
     * @return the doc2model
     */
    private doc2model loadDoc2Model()
    {
        ResourceSet resourceSet = new ResourceSetImpl();
        if (uriMappingFile == null)
        {
            uriMappingFile = URI.createFileURI(mappingFile.getAbsolutePath());
        }
        Resource resource = resourceSet.getResource(uriMappingFile, true);
        doc2model model = (doc2model) resource.getContents().get(0);
        return model;
    }

    /**
     * Gets the factory depending of file extension.
     * 
     * @return the factory
     */
    private DocumentFactory getFactory()
    {
        return Activator.getFactoryFromExtension(documentFile.getPath());
    }

    /**
     * Parses the Document.
     */
    public void parse()
    {
        parse(false);
    }

    /**
     * Parses the Document.
     * 
     * @param count determines if it is parsing for count or for checking
     */
    private void parse(boolean count)
    {
        try
        {
            doc.getXMLParser().init();
            boolean ok = false;
            Document docPointer = null;
            if (count)
            {
                docPointer = docToCount;
            }
            else
            {
                docPointer = doc;
            }
            if (docPointer != null)
            {
                ok = docPointer.next();
                int i = 1;
                // while there is elements in the xml
                while (ok)
                {
                    if (!count)
                    {
                        // check and manage the style in the current node
                        Object style = docPointer.get(PROPERTY.style);
                        process.checkStyle((String) style);
                        // check and manage the text in the current node
                        process.check((String) docPointer.get(PROPERTY.text));
                        // if there is observer we notify it
                        if (theObserver != null)
                        {
                            theObserver.worked(1);
                        }
                    }
                    ok = docPointer.next();
                    if (theObserver != null)
                    {
                        ok = ok && !theObserver.isCanceled();
                    }
                    i++;
                }
                if (count)
                {
                    theObserver.setMax(i);
                }
                else
                {
                    process.finish();
                    if (process.getCurrentEObject().eContents().size() == 0)
                    {
                        theObserver.notifyNoElementsFounded();
                    }
                    else if (Activator.logOccurs())
                    {
                        Activator.reinitLogs();
                        theObserver.warningOrErrorsOccurs();
                    }
                }
            }
        }
        catch (NullPointerException r)
        {
            Activator.log(r, IStatus.ERROR);
        }
    }

    /**
     * Parses the document using a ProgressionObserver.
     * 
     * @param observer the observer
     */
    public EObject parse(ProgressionObserver observer)
    {
        theObserver = observer;
        parse(true);
        parse(false);
        return process.getCurrentEObject();
    }

    // public EObject parse(ProgressionObserver observer, String target)
    // {
    // theObserver = observer;
    // parse(true);
    // parse(false);
    // return process.getCurrentEObject();
    // }

    public String getOutputModel()
    {
        return process.getOuputModel();
    }
}
