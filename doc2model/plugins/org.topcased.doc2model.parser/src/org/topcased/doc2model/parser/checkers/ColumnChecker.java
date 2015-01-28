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
package org.topcased.doc2model.parser.checkers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.topcased.doc2model.documents.Checker;
import org.topcased.doc2model.documents.ParsingProcess;
import org.topcased.doc2model.documents.helper.Utils;
import org.topcased.document.parser.Activator;

import doc2modelMapping.ColumnElement;
import doc2modelMapping.ColumnMatchAttribute;
import doc2modelMapping.ColumnMatchElement;
import doc2modelMapping.RegExMatchingElement;
import doc2modelMapping.doc2model;

/**
 * The Class ColumnChecker.
 */
public class ColumnChecker implements Checker
{
    /** the current column */
    private ColumnElement currentColumn = null;
    private ParsingProcess parsingProcess;
    private HashMap<RegExMatchingElement, Pattern> regexes = new HashMap<RegExMatchingElement, Pattern>();
    /**
     * Check the text if it can be matched by column injection.
     *
     * @param text the text
     */
    public void check(String text)
    {
        if (text != null && text.length() > 0)
        {
            int theColumn = parsingProcess.getColumnNumber();
            List<ColumnElement> injections = getElementsForColumn(theColumn, currentColumn);
            if (injections.size() > 0)
            {
                boolean found = false ;
                for (ColumnElement element : injections)
                {
                    if (element.getRegExToMatch() != null && element.getRegExToMatch().length() > 0)
                    {
                        Pattern p = regexes.get(element);
                        Matcher matcher = p.matcher(text);
                        if (matcher.matches())
                        {
                            manageColumn(element, Utils.getValueManagingGroup(matcher, text));
                            found = true ;
                            break;
                        }
                    }
                    else
                    {
                        manageColumn(element, text);
                        found = true ;
                        break;
                    }
                }
                if (!found)
                {
                    currentColumn = null ;
                }
            }

        }
    }

    /**
     * Manage column to create an eobject.
     *
     * @param element the element
     * @param text the text
     */
    private void manageColumn(ColumnElement element, String text)
    {
        EObject newElement = null;
        if (element instanceof ColumnMatchElement)
        {
            ColumnMatchElement column = (ColumnMatchElement) element;
            newElement = (EObject) parsingProcess.addElement(parsingProcess.getCurrentRootElement(), column.getInjection(), text);
        }
        else if (element instanceof ColumnMatchAttribute)
        {
            ColumnMatchAttribute attr = (ColumnMatchAttribute) element;
            newElement = (EObject) parsingProcess.addElement(parsingProcess.getCurrentRootElement(), attr.getInjection(), text);
        }
        if (newElement != null && element.eContainer() instanceof doc2model)
        {
            parsingProcess.setCurrentID(newElement);
            if (element instanceof ColumnMatchElement)
            {
                currentColumn = element;
                parsingProcess.pushCurrentRootElement(newElement);
            }
        }
    }
   
    public void initContext(ParsingProcess process)
    {
        parsingProcess = process ;
        initializeRegexes(parsingProcess.getDoc2Model());
    }
   
    private void initializeRegexes(doc2model model)
    {
        for (TreeIterator<EObject> i = model.eAllContents(); i.hasNext();)
        {
            try
            {
                EObject e = i.next();
                if (e instanceof ColumnElement)
                {
                    ColumnElement regex = (ColumnElement) e;
                    if (regex.getRegExToMatch() != null && regex.getRegExToMatch().length() > 0)
                    {
                        Pattern p = Pattern.compile(regex.getRegExToMatch(), Pattern.MULTILINE | Pattern.DOTALL);
                        regexes.put(regex, p);
                    }
                }
            }
            catch (PatternSyntaxException p)
            {
                Activator.log(new Exception(String.format("The regex : %s can't be compiled", p.getPattern()), p));
            }
        }
    }
   
    public List<ColumnElement> getElementsForColumn(int column, ColumnElement aColumn)
    {
        List<ColumnElement> elements = new LinkedList<ColumnElement>();
        for (TreeIterator<EObject> i = parsingProcess.getDoc2Model().eAllContents() ; i.hasNext() ;)
        {
            EObject o = i.next();
            if (o instanceof ColumnElement)
            {
                ColumnElement match = (ColumnElement) o;
                if (match.getNumColumn() == column)
                {
                    if (match instanceof ColumnMatchElement || match.eContainer() == aColumn)
                    {
                        elements.add(match);
                    }
                }
            }
        }
        return elements;
    }
  
}