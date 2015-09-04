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

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class XMLStreamHelper {

  public static void printEvent(XMLStreamReader xmlr, boolean showEvents) {
    if (showEvents) {
      System.out.print("EVENT:[" + xmlr.getLocation().getLineNumber() + "]["
          + xmlr.getLocation().getColumnNumber() + "] [" + getEventTypeName(xmlr.getEventType())
          + "]");
      System.out.print(" [");
    }
    switch (xmlr.getEventType()) {
      case XMLStreamConstants.START_ELEMENT:
        System.out.print("<");
        printName(xmlr);
        printNamespaces(xmlr);
        printAttributes(xmlr);
        System.out.print(">");
        break;
      case XMLStreamConstants.END_ELEMENT:
        System.out.print("</");
        printName(xmlr);
        System.out.print(">");
        break;
      case XMLStreamConstants.SPACE:
      case XMLStreamConstants.CHARACTERS:
        int start = xmlr.getTextStart();
        int length = xmlr.getTextLength();
        System.out.print(new String(xmlr.getTextCharacters(), start, length));
        break;
      case XMLStreamConstants.PROCESSING_INSTRUCTION:
        System.out.print("<?");
        if (xmlr.hasText())
          System.out.print(xmlr.getText());
        System.out.print("?>");
        break;
      case XMLStreamConstants.CDATA:
        System.out.print("<![CDATA[");
        start = xmlr.getTextStart();
        length = xmlr.getTextLength();
        System.out.print(new String(xmlr.getTextCharacters(), start, length));
        System.out.print("]]>");
        break;
      case XMLStreamConstants.COMMENT:
        System.out.print("<!--");
        if (xmlr.hasText())
          System.out.print(xmlr.getText());
        System.out.print("-->");
        break;
      case XMLStreamConstants.ENTITY_REFERENCE:
        System.out.print(xmlr.getLocalName() + "=");
        if (xmlr.hasText())
          System.out.print("[" + xmlr.getText() + "]");
        break;
      case XMLStreamConstants.START_DOCUMENT:
        System.out.print("<?xml");
        System.out.print(" version='" + xmlr.getVersion() + "'");
        System.out.print(" encoding='" + xmlr.getCharacterEncodingScheme() + "'");
        if (xmlr.isStandalone())
          System.out.print(" standalone='yes'");
        else
          System.out.print(" standalone='no'");
        System.out.print("?>");
        break;
    }
    System.out.println("]");
  }

  private static String getEventTypeName(int eventType) {
    switch (eventType) {
      case XMLStreamConstants.START_ELEMENT:
        return "START_ELEMENT";
      case XMLStreamConstants.END_ELEMENT:
        return "END_ELEMENT";
      case XMLStreamConstants.SPACE:
        return "SPACE";
      case XMLStreamConstants.CHARACTERS:
        return "CHARACTERS";
      case XMLStreamConstants.PROCESSING_INSTRUCTION:
        return "PROCESSING_INSTRUCTION";
      case XMLStreamConstants.CDATA:
        return "CDATA";
      case XMLStreamConstants.COMMENT:
        return "COMMENT";
      case XMLStreamConstants.ENTITY_REFERENCE:
        return "ENTITY_REFERENCE";
      case XMLStreamConstants.START_DOCUMENT:
        return "START_DOCUMENT";
      case XMLStreamConstants.END_DOCUMENT:
        return "END_DOCUMENT";
    }
    return null;
  }

  protected static void printName(XMLStreamReader xmlr) {
    if (xmlr.hasName()) {
      String prefix = xmlr.getPrefix();
      String uri = xmlr.getNamespaceURI();
      String localName = xmlr.getLocalName();
      printName(prefix, uri, localName);
    }
  }

  protected static void printName(String prefix, String uri, String localName) {
    if (uri != null && !("".equals(uri)))
      System.out.print("['" + uri + "']:");
    if (prefix != null)
      System.out.print(prefix + ":");
    if (localName != null)
      System.out.print(localName);
  }

  protected static void printAttributes(XMLStreamReader xmlr) {
    for (int i = 0; i < xmlr.getAttributeCount(); i++) {
      printAttribute(xmlr, i);
    }
  }

  protected static void printAttribute(XMLStreamReader xmlr, int index) {
    String prefix = xmlr.getAttributePrefix(index);
    String namespace = xmlr.getAttributeNamespace(index);
    String localName = xmlr.getAttributeLocalName(index);
    String value = xmlr.getAttributeValue(index);
    System.out.print(" ");
    printName(prefix, namespace, localName);
    System.out.print("='" + value + "'");
  }

  protected static void printNamespaces(XMLStreamReader xmlr) {
    for (int i = 0; i < xmlr.getNamespaceCount(); i++) {
      printNamespace(xmlr, i);
    }
  }

  protected static void printNamespace(XMLStreamReader xmlr, int index) {
    String prefix = xmlr.getNamespacePrefix(index);
    String uri = xmlr.getNamespaceURI(index);
    System.out.print(" ");
    if (prefix == null)
      System.out.print("xmlns='" + uri + "'");
    else
      System.out.print("xmlns:" + prefix + "='" + uri + "'");
  }
}
