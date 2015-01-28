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
 * Anass RADOUANI (AtoS) anass.radouani@atos.net - [#4361] Add method getallStyleAttributes to retrieve all style attributes
 * 
 *****************************************************************************/
package org.topcased.doc2model.documents.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import doc2modelMapping.Attribute;
import doc2modelMapping.DocStyle;
import doc2modelMapping.Hierarchy;
import doc2modelMapping.LinkedElement;
import doc2modelMapping.StyleAttribute;
import doc2modelMapping.TagAttribute;
import doc2modelMapping.TagElement;
import doc2modelMapping.doc2model;

/**
 * The Class EMFHelper.
 * 
 * @author tristan.faure@atosorigin.com
 */
public class EMFHelper
{

    /** The model. */
    private doc2model model = null;

    /**
     * Instantiates a new eMF helper.
     * 
     * @param amodel the amodel
     */
    public EMFHelper(doc2model amodel)
    {
        model = amodel;
    }

    /**
     * Contains tag.
     * 
     * @return true, if the model contains tagElements
     */
    public boolean containsTag()
    {
        boolean find = false;
        if (model.getLinks() != null)
        {
            for (LinkedElement e : model.getLinks())
            {
                if (e instanceof TagElement)
                {
                    find = true;
                }
            }
        }
        return find;
    }

    /**
     * Checks if is a linked element.
     * 
     * @param stmp the strig to check
     * @return true, if stmp is a linked element
     */
    public boolean isALinkedElement(String stmp)
    {
        boolean find = false;
        if (model.getLinks() != null)
        {
            for (LinkedElement e : model.getLinks())
            {
                String s = null;
                if (e instanceof TagElement)
                {
                    s = ((TagElement) e).getTagValue();
                    if (s != null)
                    {
                        s = s.toLowerCase();
                        if (removeSpaces(stmp.toLowerCase()).startsWith(s))
                        {
                            find = true;
                        }
                    }
                }
                else if (e instanceof DocStyle)
                {
                    s = ((DocStyle) e).getStyleName();
                    if (s != null)
                    {
                        s = s.toLowerCase();
                        if (removeSpaces(stmp.toLowerCase()).equals(removeSpaces(s)))
                        {
                            find = true;
                        }
                    }
                }

            }
        }
        return find;
    }

    /**
     * Removes the spaces.
     * 
     * @param s the s
     * 
     * @return the string
     */
    public String removeSpaces(String s)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c != ' ' && (int) c != 32 && (int) c != 160)
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Keep attributes.
     * 
     * @param stmp the stmp
     * 
     * @return the string
     */
    public String keepAttributes(String stmp)
    {
        String stmp2 = stmp;
        if (model.getLinks() != null)
        {
            stmp2 = getAttribute(stmp);
            int i = 0;
            while (i < stmp2.length())
            {
                if (stmp2.charAt(i) == '=')
                {
                    break;
                }
                i++;
            }
            while (stmp2.charAt(i) == ' ')
            {
                i--;
            }
            while (i > 0 && stmp2.charAt(i) != ' ')
            {
                i--;
            }
            if (stmp2.endsWith("/"))
            {
                return stmp2.substring(i, stmp2.lastIndexOf("/"));
            }
            else
            {
                return stmp2.substring(i, stmp2.length());
            }
        }
        else
        {
            return null;
        }
    }

    private String getAttribute(String stmp)
    {
        String stmp2copy = "";
        for (LinkedElement e : model.getLinks())
        {
            if (e instanceof TagElement)
            {
                String s = ((TagElement) e).getTagValue();
                if (s != null)
                {
                    s = s.toLowerCase();
                    if (removeSpaces(stmp.toLowerCase()).startsWith(s))
                    {
                        stmp2copy = stmp.substring(stmp.toLowerCase().indexOf(s) + s.length(), stmp.length());
                    }
                }
            }
        }
        return stmp2copy;
    }

    /**
     * Checks if is hierarchy referenced style.
     * 
     * @param style the style
     * 
     * @return true, if is hierarchy referenced style
     */
    public boolean isHierarchyReferencedStyle(String style)
    {
        Hierarchy htmp = getHierarchy(style);
        return htmp != null;
    }

    /**
     * Gets the hierarchy.
     * 
     * @param style the style
     * 
     * @return the hierarchy
     */
    public Hierarchy getHierarchy(String style)
    {
        Hierarchy htmp = model.getHierarchy();
        while (htmp != null && !(equalsIgnoreCase(style, htmp.getStyleValue())))
        {
            htmp = htmp.getSubHierarchy();
        }
        return htmp;
    }

    private boolean equalsIgnoreCase(String style, EList<String> styleValue)
    {
        return equalsIgnoreCase(styleValue, style);
    }

    private boolean equalsIgnoreCase(EList<String> styleValue, String style)
    {
        for (String s : styleValue)
        {
            if (equalsIgnoreCase(style, s))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove spaces and returns the string in lower case
     * 
     * @param s the string
     * @return
     */
    public String withoutSpacesLowerCase(String s)
    {
        return removeSpaces(s.toLowerCase());
    }

    /**
     * Check if the strings are equals without spaces and without taking care about case
     * 
     * @param s1, string 1
     * @param s2, string 2
     * @return true if they are eqauls. Eg: "Heading 1" is equals to "heading1"
     */
    public boolean equalsIgnoreCase(String s1, String s2)
    {
        return withoutSpacesLowerCase(s1).equals(withoutSpacesLowerCase(s2));
    }

    /**
     * Return true if one is higher or equal than two.
     * 
     * @param one the one
     * @param two the two
     * 
     * @return true, if sup equal
     */
    public boolean supEqual(String one, String two)
    {
        int pos1 = 0;
        int pos2 = 0;
        int i = 0;
        Hierarchy current = model.getHierarchy();
        while (current != null)
        {
            if (equalsIgnoreCase(current.getStyleValue(), one))
            {
                pos2 = i;
            }
            if (equalsIgnoreCase(current.getStyleValue(), two))
            {
                pos1 = i;
            }
            current = current.getSubHierarchy();
            i++;
        }
        return pos1 >= pos2;
        // boolean oneFound = false;
        // boolean twoFound = false;
        // Hierarchy tmp = model.getHierarchy();
        // while ((!oneFound || !twoFound) && tmp != null)
        // {
        // if (equalsIgnoreCase(tmp.getStyleValue(),one))
        // {
        // oneFound = true;
        // }
        // if (equalsIgnoreCase(tmp.getStyleValue(),two))
        // {
        // if (!oneFound)
        // {
        // return false;
        // }
        //
        // return true;
        //
        // }
        // tmp = tmp.getSubHierarchy();
        // }
        // return false;
    }

    /**
     * Sup.Return true if one is higher than two.
     * 
     * @param one the one
     * @param two the two
     * 
     * @return true, if successful
     */
    public boolean sup(String one, String two)
    {
        int pos1 = 0;
        int pos2 = 0;
        int i = 0;
        Hierarchy current = model.getHierarchy();
        while (current != null)
        {
            if (equalsIgnoreCase(current.getStyleValue(), one))
            {
                pos2 = i;
            }
            if (equalsIgnoreCase(current.getStyleValue(), two))
            {
                pos1 = i;
            }
            current = current.getSubHierarchy();
            i++;
        }
        return pos1 > pos2;
        // boolean oneFound = false;
        // boolean twoFound = false;
        // Hierarchy tmp = model.getHierarchy();
        // while ((!oneFound || !twoFound) && tmp != null)
        // {
        // if (equalsIgnoreCase(tmp.getStyleValue(),one))
        // {
        // oneFound = true;
        // }
        // else if (equalsIgnoreCase(tmp.getStyleValue(),two))
        // {
        // if (!oneFound)
        // {
        // return false;
        // }
        // return true;
        //
        // }
        // tmp = tmp.getSubHierarchy();
        // }
        // return false;
    }

    /**
     * Gets the tag.
     * 
     * @param stmp the tag searched
     * 
     * @return the tag
     */
    public TagElement getTag(String stmp)
    {
        if (stmp != null)
        {
            String tagName = stmp.substring(0, stmp.indexOf(" "));
            for (LinkedElement l : model.getLinks())
            {
                if (l instanceof TagElement)
                {
                    TagElement tag = (TagElement) l;
                    tagName = removeSpaces(tagName).toLowerCase();
                    if (tagName.equals(tag.getTagValue().toLowerCase()))
                    {
                        return tag;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Gets the tag attribute.
     * 
     * @param key the attributeName
     * @param tag the TagName
     * 
     * @return the tag attribute
     */
    public TagAttribute getTagAttribute(String key, TagElement tag)
    {
        if (key != null)
        {
            for (LinkedElement l : model.getLinks())
            {
                if (l instanceof TagElement)
                {
                    TagElement t = (TagElement) l;
                    if (t == tag)
                    {
                        for (Attribute a : t.getAttributes())
                        {
                            if (a instanceof TagAttribute)
                            {
                                TagAttribute ta = (TagAttribute) a;
                                if (ta.getAttributeValue() != null && key.toLowerCase().equals(ta.getAttributeValue().toLowerCase()))
                                {
                                    return ta;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Gets the doc.
     * 
     * @param stmp the element name
     * 
     * @return the doc
     */
    public DocStyle getDoc(String stmp)
    {
        if (stmp != null)
        {
            String styleName = stmp;
            for (LinkedElement l : model.getLinks())
            {
                if (l instanceof DocStyle)
                {
                    DocStyle doc = (DocStyle) l;
                    if (styleName.toLowerCase().equals(doc.getStyleName().toLowerCase()))
                    {
                        return doc;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Checks if stmp is a style attribute.
     * 
     * @param stmp the attribute name
     * @param l the linkedElement
     * 
     * @return true, if is a style attribute
     */
    public boolean isAStyleAttribute(String stmp, LinkedElement l)
    {
        return getStyleAttribute(stmp, l) != null;
    }

    /**
     * Gets the style attribute. Use getallStyleAttributes instead because the element can have many style attributes with different associated regex
     * 
     * @param stmp the attribute name
     * @param li the linkedElement
     * 
     * @return the style attribute
     */
    @Deprecated
    public StyleAttribute getStyleAttribute(String stmp, LinkedElement li)
    {
        if (stmp != null)
        {
            String styleName = stmp;
            for (LinkedElement l : model.getLinks())
            {
                if (l == li)
                {
                    for (Attribute a : l.getAttributes())
                    {
                        if (a instanceof StyleAttribute)
                        {
                            StyleAttribute s = (StyleAttribute) a;
                            if (styleName.toLowerCase().equals(s.getAttributeValue().toLowerCase()))
                            {
                                return s;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * Gets all style attributes.
     * 
     * @param stmp the attribute name
     * @param li the linkedElement
     * 
     * @return collection of style attributes
     */
    public Collection<StyleAttribute> getallStyleAttributes(String stmp, LinkedElement li)
    {
        Collection<StyleAttribute> result = new ArrayList<StyleAttribute>();
        if (stmp != null)
        {
            String styleName = stmp;
            for (LinkedElement l : model.getLinks())
            {
                if (l == li)
                {
                    for (Attribute a : l.getAttributes())
                    {
                        if (a instanceof StyleAttribute)
                        {
                            StyleAttribute s = (StyleAttribute) a;
                            if (styleName.toLowerCase().equals(s.getAttributeValue().toLowerCase()))
                            {
                                result.add(s);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public boolean supEqual(String style, EList<String> styleValue)
    {
        for (String s : styleValue)
        {
            if (supEqual(style, s))
            {
                return true;
            }
        }
        return false;
    }

    public boolean sup(String style, EList<String> styleValue)
    {
        for (String s : styleValue)
        {
            if (sup(style, s))
            {
                return true;
            }
        }
        return false;
    }

}
