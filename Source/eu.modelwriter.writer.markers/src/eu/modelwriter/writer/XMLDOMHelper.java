package eu.modelwriter.writer;

import java.util.Stack;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLDOMHelper {

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

}
