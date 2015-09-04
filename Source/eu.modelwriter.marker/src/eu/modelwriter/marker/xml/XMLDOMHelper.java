/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.marker.xml;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDOMHelper {

  public static String findNodeAndGetXPath(String qName, String fileName) {
    return getFullXPath(findNode(qName, fileName));
  }

  public static Node findNode(String qName, String fileName) {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setValidating(false);
    DocumentBuilder db;
    Document doc;
    try {
      db = dbf.newDocumentBuilder();
      doc = db.parse(new File(fileName));
      Node node = findNode(qName, doc);
      if (node != null) {
        return node;
      }

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Node findNodeByXpath(String xpathExpression, String fileName) {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setValidating(false);
    DocumentBuilder db;
    Document doc;
    try {
      db = dbf.newDocumentBuilder();
      doc = db.parse(new File(fileName));
      XPath xpath = XPathFactory.newInstance().newXPath();
      NodeList nodes = (NodeList) xpath.evaluate(xpathExpression, doc, XPathConstants.NODESET);
      for (int i = 0; i < nodes.getLength(); i++) {
        System.out.print(nodes.item(i).getNodeName() + " ");
      }
      if (nodes.getLength() > 1)
        return nodes.item(0);
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (XPathExpressionException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Constructs a XPath query to the supplied node.
   * 
   * {@code
   * <?xml version="1.0" encoding="iso-8859-1" ?>
   * <bookstore>
   *   <book id="1">
   *     <title>Harry Potter and the Philosopher's Stone</title>
   *     <isbn>0747532745</isbn>
   *     <tags>
   *       <tag>children</tag>
   *       <tag>stone</tag>
   *     </tags>
   *   </book>
   *   <book id="2">
   *     <title>Harry Potter and the Chamber of Secrets</title>
   *     <isbn>0747538484</isbn>
   *     <tags>
   *       <tag>children</tag>
   *       <tag>secrets</tag>
   *     </tags>
   *   </book>
   *   <book id="3">
   *     <title>Harry Potter and the Prisoner of Azkaban</title>
   *     <isbn>0747546290</isbn>
   *     <tags>
   *       <tag>children</tag>
   *       <tag>prisoner</tag>
   *     </tags>
   *   </book>
   * </bookstore>
   * }
   * 
   * Title node of "Harry Potter and the Chamber of Secrets": *
   * 
   * <pre>
   * bookstore/book[@id='2']/title[1]
   * </pre>
   * 
   * Second tag node of "Harry Potter and the Prisoner of Azkaban":
   * 
   * <pre>
   * bookstore/book[@id='3']/tags[1]/tag[2]
   * </pre>
   * 
   * @param n
   * @return
   */
  public static String getXPath(Node n) {
    // abort early
    if (null == n)
      return null;

    // declarations
    Node parent = null;
    Stack<Node> hierarchy = new Stack<Node>();
    StringBuffer buffer = new StringBuffer();

    // push element on stack
    hierarchy.push(n);

    parent = n.getParentNode();
    while (null != parent && parent.getNodeType() != Node.DOCUMENT_NODE) {
      // push on stack
      hierarchy.push(parent);

      // get parent of parent
      parent = parent.getParentNode();
    }

    // construct xpath
    Object obj = null;
    while (!hierarchy.isEmpty() && null != (obj = hierarchy.pop())) {
      Node node = (Node) obj;
      boolean handled = false;

      // only consider elements
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element e = (Element) node;

        // is this the root element?
        if (buffer.length() == 0) {
          // root element - simply append element name
          buffer.append(node.getLocalName());
        } else {
          // child element - append slash and element name
          buffer.append("/");
          buffer.append(node.getLocalName());

          if (node.hasAttributes()) {
            // see if the element has a name or id attribute
            if (e.hasAttribute("id")) {
              // id attribute found - use that
              buffer.append("[@id='" + e.getAttribute("id") + "']");
              handled = true;
            } else if (e.hasAttribute("name") && e.getAttribute("name") != null
                && !e.getAttribute("name").isEmpty()) {
              // name attribute found - use that
              buffer.append("[@name='" + e.getAttribute("name") + "']");
              handled = true;
            }
          }

          if (!handled) {
            // no known attribute we could use - get sibling index
            int prev_siblings = 1;
            Node prev_sibling = node.getPreviousSibling();
            while (null != prev_sibling) {
              if (prev_sibling.getNodeType() == node.getNodeType()) {
                if (prev_sibling.getLocalName().equalsIgnoreCase(node.getLocalName())) {
                  prev_siblings++;
                }
              }
              prev_sibling = prev_sibling.getPreviousSibling();
            }
            buffer.append("[" + prev_siblings + "]");
          }
        }
      }
    }

    // return buffer
    return buffer.toString();
  }

  public static String getFullXPath(Node n) {
    // abort early
    if (null == n)
      return null;

    // declarations
    Node parent = null;
    Stack<Node> hierarchy = new Stack<Node>();
    StringBuffer buffer = new StringBuffer();

    // push element on stack
    hierarchy.push(n);

    switch (n.getNodeType()) {
      case Node.ATTRIBUTE_NODE:
        parent = ((Attr) n).getOwnerElement();
        break;
      case Node.ELEMENT_NODE:
        parent = n.getParentNode();
        break;
      case Node.DOCUMENT_NODE:
        parent = n.getParentNode();
        break;
      default:
        throw new IllegalStateException("Unexpected Node type" + n.getNodeType());
    }

    while (null != parent && parent.getNodeType() != Node.DOCUMENT_NODE) {
      // push on stack
      hierarchy.push(parent);

      // get parent of parent
      parent = parent.getParentNode();
    }

    // construct xpath
    Object obj = null;
    while (!hierarchy.isEmpty() && null != (obj = hierarchy.pop())) {
      Node node = (Node) obj;
      boolean handled = false;

      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element e = (Element) node;

        // is this the root element?
        if (buffer.length() == 0) {
          // root element - simply append element name
          buffer.append(node.getNodeName());
        } else {
          // child element - append slash and element name
          buffer.append("/");
          buffer.append(node.getNodeName());

          if (node.hasAttributes()) {
            // see if the element has a name or id attribute
            if (e.hasAttribute("id")) {
              // id attribute found - use that
              buffer.append("[@id='" + e.getAttribute("id") + "']");
              handled = true;
            } else if (e.hasAttribute("name") && e.getAttribute("name") != null
                && !e.getAttribute("name").isEmpty()) {
              // name attribute found - use that
              buffer.append("[@name='" + e.getAttribute("name") + "']");
              handled = true;
            }
          }

          if (!handled) {
            // no known attribute we could use - get sibling index
            int prev_siblings = 1;
            Node prev_sibling = node.getPreviousSibling();
            while (null != prev_sibling) {
              if (prev_sibling.getNodeType() == node.getNodeType()) {
                if (prev_sibling.getNodeName().equalsIgnoreCase(node.getNodeName())) {
                  prev_siblings++;
                }
              }
              prev_sibling = prev_sibling.getPreviousSibling();
            }
            buffer.append("[" + prev_siblings + "]");
          }
        }
      } else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
        buffer.append("/@");
        buffer.append(node.getNodeName());
      }
    }
    // return buffer
    return buffer.toString();
  }

  public static void printlnCommon(Node n) {
    System.out.print(" nodeName=\"" + n.getNodeName() + "\"");

    String val = n.getNamespaceURI();
    if (val != null) {
      System.out.print(" uri=\"" + val + "\"");
    }

    val = n.getPrefix();

    if (val != null) {
      System.out.print(" pre=\"" + val + "\"");
    }

    val = n.getLocalName();
    if (val != null) {
      System.out.print(" local=\"" + val + "\"");
    }

    val = n.getNodeValue();
    if (val != null) {
      System.out.print(" nodeValue=");
      if (val.trim().equals("")) {
        // Whitespace
        System.out.print("[WS]");
      } else {
        System.out.print("\"" + n.getNodeValue() + "\"");
      }
    }
    System.out.println();
  }

  /**
   * Find the named subnode in a node's sublist.
   * <ul>
   * <li>Ignores comments and processing instructions.
   * <li>Ignores TEXT nodes (likely to exist and contain ignorable whitespace, if not validating.
   * <li>Ignores CDATA nodes and EntityRef nodes.
   * <li>Examines element nodes to find one with the specified name.
   * </ul>
   * 
   * @param name the tag name for the element to find
   * @param node the element node to start searching from
   * @return the Node found
   */
  public static Node findNode(String name, Node node) {
    // get all child nodes
    NodeList list = node.getChildNodes();

    for (int i = 0; i < list.getLength(); i++) {
      // get child node
      Node childNode = list.item(i);

      if (childNode.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) childNode;
        if (element.hasAttributes()) {
          if (element.hasAttribute("id") && element.getAttribute("id") != null
              && !element.getAttribute("id").isEmpty() && element.getAttribute("id").equals(name)) {
            return element;
          } else if (element.hasAttribute("name") && element.getAttribute("name") != null
              && !element.getAttribute("name").isEmpty()
              && element.getAttribute("name").equals(name)) {
            return element;
          }
        }
      }
      // visit child node
      Node temp = findNode(name, childNode);
      if (temp != null)
        return temp;
    }
    return null;
  }

  /**
   * Return the text that a node contains. This routine:
   * <ul>
   * <li>Ignores comments and processing instructions.
   * <li>Concatenates TEXT nodes, CDATA nodes, and the results of recursively processing EntityRef
   * nodes.
   * <li>Ignores any element nodes in the sublist. (Other possible options are to recurse into
   * element sublists or throw an exception.)
   * </ul>
   * 
   * @param node a DOM node
   * @return a String representing its contents
   */
  public static String getText(Node node) {
    StringBuffer result = new StringBuffer();
    if (!node.hasChildNodes())
      return "";

    NodeList list = node.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
      Node subnode = list.item(i);
      if (subnode.getNodeType() == Node.TEXT_NODE) {
        result.append(subnode.getNodeValue());
      } else if (subnode.getNodeType() == Node.CDATA_SECTION_NODE) {
        result.append(subnode.getNodeValue());
      } else if (subnode.getNodeType() == Node.ENTITY_REFERENCE_NODE) {
        // Recurse into the subtree for text
        // (and ignore comments)
        result.append(getText(subnode));
      }
    }

    return result.toString();
  }
}
