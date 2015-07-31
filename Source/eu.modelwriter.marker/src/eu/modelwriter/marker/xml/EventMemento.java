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
