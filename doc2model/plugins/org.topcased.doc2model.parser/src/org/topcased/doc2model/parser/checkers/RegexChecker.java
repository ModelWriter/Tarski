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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.topcased.doc2model.documents.Checker;
import org.topcased.doc2model.documents.ParsingProcess;
import org.topcased.doc2model.documents.helper.Utils;
import org.topcased.document.parser.Activator;

import doc2modelMapping.DynamicElement;
import doc2modelMapping.GroupElement;
import doc2modelMapping.RegEx;
import doc2modelMapping.RegExAttribute;
import doc2modelMapping.RegExMatchingElement;
import doc2modelMapping.doc2model;

/**
 * The Class RegexChecker.
 */
public class RegexChecker implements Checker
{
    
    private StringBuffer currentTextForRegex = new StringBuffer("");
    private ParsingProcess parsingProcess;
    private HashMap<RegExMatchingElement, Pattern> regexes = new HashMap<RegExMatchingElement, Pattern>();
    private HashMap<RegExAttribute, Pattern> regexesAttributes = new HashMap<RegExAttribute, Pattern>();
    
    
    public void check(String text)
    {
        // to reinit the current total text if a regex has been found
        boolean found = false;
        if (text != null && text.length() > 0)
        {
            currentTextForRegex = new StringBuffer(text);
            for (RegExMatchingElement regex : regexes.keySet())
            {
                if (regex instanceof DynamicElement)
                {
                    found = manageCurrentRegex((DynamicElement) regex);
                    if (found)
                    {
                        break;
                    }
                }
            }
            for (RegExAttribute regexA : regexesAttributes.keySet())
            {
                found = manageCurrentRegex(regexA);
            }
            currentTextForRegex = new StringBuffer("");
        }        
    }
    
    private boolean manageCurrentRegex(DynamicElement regex)
    {
        Matcher m = getMatcher(regex);
        boolean result = false;
        if (m != null && m.matches())
        {
            String value = "";
            value = Utils.getValueManagingGroup(m,currentTextForRegex.toString());
            result = true;
            EObject newElement = (EObject) parsingProcess.addElement(parsingProcess.getCurrentRootElement(), regex.getInjection(), value);
            if (regex instanceof RegEx)
            {
                parsingProcess.setCurrentID(newElement);
            }
            if (regex instanceof GroupElement)
            {
                GroupElement element = (GroupElement)regex;
                if (element.getSecondaryInjectionsForGroups().size() > 0 && m.groupCount() > 1)
                {
                    for (int i = 0 ; i < element.getSecondaryInjectionsForGroups().size() && i+1 < m.groupCount(); i++)
                    {
                        parsingProcess.addElement(parsingProcess.getCurrentRootElement(), element.getSecondaryInjectionsForGroups().get(i), m.group(i+2));
                    }
                }
            }
            
        }
        return result;
    }
    
    private Matcher getMatcher(EObject regex)
    {
        Matcher m = null;
        if (regex instanceof RegEx)
        {
            RegEx regexX = (RegEx) regex;
            m = regexes.get(regexX).matcher(currentTextForRegex.toString());

        }
        else if (regex instanceof RegExAttribute)
        {
            m = regexesAttributes.get((RegExAttribute) regex).matcher(currentTextForRegex.toString());
        }
        return m;
    }
    

    public void initContext(ParsingProcess parsing)
    {
        parsingProcess = parsing;
        initializeRegexes(parsing.getDoc2Model());
    }
    
    private void initializeRegexes(doc2model model)
    {
        for (TreeIterator<EObject> i = model.eAllContents(); i.hasNext();)
        {
            try
            {
                EObject e = i.next();
                if (e instanceof RegEx)
                {
                    RegEx regex = (RegEx) e;
                    if (regex.getRegExToMatch() != null && regex.getRegExToMatch().length() > 0) 
                    {
                        Pattern p = Pattern.compile(regex.getRegExToMatch(), Pattern.MULTILINE);
                        regexes.put(regex, p);
                    }
                }
                else if (e instanceof RegExAttribute)
                {
                    RegExAttribute regexA = (RegExAttribute) e;
                    if (regexA.getAttributeValue() != null && regexA.getAttributeValue().length() > 0) 
                    {
                        Pattern p = Pattern.compile(regexA.getAttributeValue(), Pattern.MULTILINE);
                        regexesAttributes.put(regexA, p);
                    }
                }
            }
            catch (PatternSyntaxException p)
            {
                Activator.log(new Exception(String.format("The regex : %s can't be compiled", p.getPattern()), p));
            }
        }
    }

}
