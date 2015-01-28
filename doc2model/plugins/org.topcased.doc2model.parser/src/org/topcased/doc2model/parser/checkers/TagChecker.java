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

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.topcased.doc2model.documents.Checker;
import org.topcased.doc2model.documents.ParsingProcess;
import org.topcased.document.parser.documents.helper.StringHelper;

import doc2modelMapping.Hierarchy;
import doc2modelMapping.NewClassInjection;
import doc2modelMapping.TagAttribute;
import doc2modelMapping.TagElement;

/**
 * The Class TagChecker.
 */
public class TagChecker implements Checker
{
    /** The regex split tag. */
    private static String regexSplitTAG = "[<>]";

    /** The regex to determine lists */
    private static Pattern regexForLists = Pattern.compile(".*,.*");

    /** The regex tag. */
    private static Pattern patternForRegexTAG = Pattern.compile(".*<.*>.*");

    /** The regex for end tag */
    private static Pattern patternForEndTags = Pattern.compile(".*</(.*)>.*");

    /** The tag corresponding to current Element */
    private Stack<String> currentTag = new Stack<String>();

    private ParsingProcess parsingProcess;

    private boolean isProcessingCutString;

    private String currentCutString;

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.doc2model.documents.Checker#check(java.lang.String)
     */
    public void check(String text)
    {
        String process = text;
        Vector<String> finalString = new Vector<String>();
        if (parsingProcess.getEmfHelper().containsTag())
        {
            process = getTagCut(text, process);
            if (patternForRegexTAG.matcher(process).matches() && !patternForEndTags.matcher(process).matches())
            {
                String[] stringSplit = process.split(regexSplitTAG);
                for (String s : stringSplit)
                {
                    if (parsingProcess.getEmfHelper().withoutSpacesLowerCase(process).contains("<" + parsingProcess.getEmfHelper().withoutSpacesLowerCase(s) + ">"))
                    {
                        finalString.add(s);
                    }
                }
            }
        }
        if (finalString.size() != 0)
        {
            // reinit the current style necessary for normal style
            if (parsingProcess.getCurrentStyle() != null && !parsingProcess.getCurrentStyle().equals(parsingProcess.getTextCorrespondingToCurrentStyle()))
            {
                parsingProcess.setCurrentStyle("");
            }
            chekTagString(finalString);
        }
        Matcher m = patternForEndTags.matcher(text);
        if (m.matches())
        {
            if (m.groupCount() > 0)
            {
                String tagName = m.group(1);
                // we are at end of tag so we pop
                if (!currentTag.isEmpty())
                {
                    if (parsingProcess.getEmfHelper().removeSpaces(tagName).equals(currentTag.peek()))
                    {
                        boolean found = false;
                        while (!found)
                        {
                            found = !parsingProcess.hierarchiesContainsCurrentRootElement();
                            parsingProcess.popCurrentRootElement();
                        }
                    }
                    currentTag.pop();
                }
            }
        }
    }

    /**
     * Chek tag in string format. We also clean tags not included in mapping file
     * 
     * @param finalString the final string
     */
    private void chekTagString(Collection<String> finalString)
    {
        // check the tag id
        for (Iterator<String> i = finalString.iterator(); i.hasNext();)
        {
            String stmp = i.next();
            if (!parsingProcess.getEmfHelper().isALinkedElement(stmp))
            {
                i.remove();
            }
            else
            {
                TagElement tag = parsingProcess.getEmfHelper().getTag(stmp);
                if (tag != null)
                {
                    // we reinit the introspection to create a new Tag
                    parsingProcess.newTag();
                    EObject newElement = (EObject) parsingProcess.addElement(parsingProcess.getCurrentRootElement(), tag.getInjection(), null);
                    if (newElement != null)
                    {
                        parsingProcess.setCurrentID(newElement);
                        if (!parsingProcess.getEmfHelper().withoutSpacesLowerCase(stmp).endsWith("/"))
                        {
                            parsingProcess.pushCurrentRootElement(newElement);
                            currentTag.push(tag.getTagValue());
                        }
                        checkContainer(newElement, tag);
                        // we drop the information about the tag and keep
                        // information about attributes
                        String drop = parsingProcess.getEmfHelper().keepAttributes(stmp);
                        HashMap<String, String> c = StringHelper.getAttributesInXMLString(drop, StringHelper.QUOTE, StringHelper.STRANGE_QUOTE);
                        insertAttributes(c, tag);
                    }
                }
            }
        }
    }

    /**
     * Insert attributes.
     * 
     * @param c the c
     * @param tag the tag
     */
    private void insertAttributes(HashMap<String, String> c, TagElement tag)
    {
        for (String s : c.keySet())
        {
            String key = s;
            String value = c.get(s);
            TagAttribute attribute = parsingProcess.getEmfHelper().getTagAttribute(key, tag);
            if (attribute != null)
            {
                if (regexForLists.matcher(value).matches())
                {
                    String[] values = value.split(",");
                    for (String valueTmp : values)
                    {
                        EObject newElement = (EObject) parsingProcess.addElement(null, attribute.getInjection(), valueTmp);
                    }
                }
                else
                {
                    EObject newElement = (EObject) parsingProcess.addElement(null, attribute.getInjection(), value);
                }
            }
        }
    }

    /**
     * Check if the currentRootElement has to be replaced by the newElement.
     * 
     * @param newElement the new element
     * @param tag the tag
     */
    private void checkContainer(EObject newElement, TagElement tag)
    {
        if (!parsingProcess.isEmptyCurrentRootElement() && parsingProcess.getCurrentStyleHierarchy() != null && tag.getInjection() instanceof NewClassInjection
                && parsingProcess.getCurrentRootElement() != null)
        {
            NewClassInjection injection = (NewClassInjection) tag.getInjection();
            if (parsingProcess.getCurrentRootElement().getClass().isAssignableFrom(newElement.getClass()) && parsingProcess.getCurrentStyleHierarchy().equals(parsingProcess.getCurrentStyle()))
            {
                EReference ref = parsingProcess.getCurrentRootElement().eContainmentFeature();
                if (parsingProcess.getCurrentRootElement().eContainer() != null)
                {
                    Object container = parsingProcess.getCurrentRootElement().eContainer().eGet(ref);
                    if (container instanceof EList)
                    {
                        Hierarchy htmp = parsingProcess.getInHierarchy(parsingProcess.getCurrentRootElement());
                        EList containerList = (EList) container;
                        int index = containerList.indexOf(parsingProcess.getCurrentRootElement());
                        containerList.remove(parsingProcess.getCurrentRootElement());
                        containerList.add(index, newElement);
                        parsingProcess.popCurrentRootElement();
                        parsingProcess.pushCurrentRootElement(newElement);
                        parsingProcess.putHierarchies(newElement, htmp);
                    }
                }
            }

        }
    }

    private String getTagCut(String text, String process)
    {
        if (process.contains("<") && !process.contains(">"))
        {
            registerString(process);
        }
        else if (!process.contains("<") && !process.contains(">") && isProcessingCutString)
        {
            currentCutString += process;
        }
        else if (process.contains(">") && !process.contains("<"))
        {
            process = currentCutString + text;
            isProcessingCutString = false;
            currentCutString = "";
        }
        return process;
    }

    private void registerString(String text)
    {
        currentCutString = text;
        isProcessingCutString = true;
    }

    public void initContext(ParsingProcess process)
    {
        parsingProcess = process;
    }

}
