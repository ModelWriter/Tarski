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

import javax.xml.stream.XMLStreamReader;

public class EventMemento {
  private int eventType;
  private int characterOffset;
  private int columnNumber;
  private int lineNumber;

  public int getEventType() {
    return eventType;
  }

  public int getCharacterOffset() {
    return characterOffset;
  }

  public int getColumnNumber() {
    return columnNumber;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public EventMemento(XMLStreamReader xmlr) {
    eventType = xmlr.getEventType();
    characterOffset = xmlr.getLocation().getCharacterOffset();
    columnNumber = xmlr.getLocation().getColumnNumber();
    lineNumber = xmlr.getLocation().getLineNumber();
  }
}
