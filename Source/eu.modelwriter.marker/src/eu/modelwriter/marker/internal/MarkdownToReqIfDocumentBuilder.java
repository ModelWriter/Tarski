package eu.modelwriter.marker.internal;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.management.RuntimeErrorException;

import org.eclipse.mylyn.wikitext.core.parser.Attributes;
import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.ReqIF10Factory;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;

public class MarkdownToReqIfDocumentBuilder extends DocumentBuilder {

  public StringWriter writer2 = new StringWriter();
  HashMap<SpecHierarchy, Integer> map = new HashMap<SpecHierarchy, Integer>();
  Stack<SpecHierarchy> stack = new Stack<SpecHierarchy>();
  int startLevel, beforeLevel;
  ArrayList<SpecHierarchy> rootSet = new ArrayList<SpecHierarchy>();
  
  public ArrayList<SpecHierarchy> getRootSet() {
    return rootSet;
  }

  String blockSpec;
  SpecHierarchy specHierarchy = null;
  SpecObject specObject = null;

  @Override
  public void link(Attributes attributes, String hrefOrHashName, String text) {

  }

  @Override
  public void lineBreak() {}

  @Override
  public void imageLink(Attributes linkAttributes, Attributes imageAttributes, String href,
      String imageUrl) {}

  @Override
  public void image(Attributes attributes, String url) {}

  @Override
  public void entityReference(String entity) {}

  @Override
  public void endSpan() {

  }

  @Override
  public void endHeading() {}

  @Override
  public void endDocument() {// TODO map ine g�re �ekelim
    for (Map.Entry<SpecHierarchy, Integer> entry : map.entrySet()) {
      if (entry.getValue() == startLevel) {
        rootSet.add(entry.getKey());
      }
    }
    // try {
    // while (!stack.isEmpty()) {
    // Iterator<AttributeValue> iter = stack.pop().getObject().getValues().iterator();
    // while (iter.hasNext()) {
    // AttributeValue attributeValue = (AttributeValue) iter.next();
    // if (attributeValue instanceof AttributeValueString) {
    // System.out.println(((AttributeValueString) attributeValue).getTheValue());
    // }
    // }
    // }
    // writer2.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
  }

  @Override
  public void endBlock() {

    specHierarchy = ReqIF10Factory.eINSTANCE.createSpecHierarchy();
    specObject = ReqIF10Factory.eINSTANCE.createSpecObject();
    specHierarchy.setObject(specObject);
    AttributeValueString attribute = ReqIF10Factory.eINSTANCE.createAttributeValueString();
    attribute.setTheValue(blockSpec);
    specObject.getValues().add(attribute);
    specObject.setIdentifier(ReqIF10Factory.eINSTANCE.createAlternativeID().toString());
    stack.peek().getChildren().add(specHierarchy); // paragraph has been set its own heading's
                                                   // child.

  }

  @Override
  public void charactersUnescaped(String literal) {}

  @Override
  public void characters(String text) {
    blockSpec += text;
    AttributeValueString attribute = ReqIF10Factory.eINSTANCE.createAttributeValueString();
    attribute.setTheValue(text);
    specObject.getValues().add(attribute);
    specObject.setIdentifier(ReqIF10Factory.eINSTANCE.createAlternativeID().toString());
  }

  @Override
  public void beginSpan(SpanType type, Attributes attributes) {

  }

  @Override
  public void beginHeading(int level, Attributes attributes) {
    specHierarchy = ReqIF10Factory.eINSTANCE.createSpecHierarchy();
    specObject = ReqIF10Factory.eINSTANCE.createSpecObject();
    specHierarchy.setObject(specObject);

    if (stack.isEmpty()) {// if the new coming is root push to stack
      startLevel = level;
      map.put(specHierarchy, level);
      stack.push(specHierarchy);
    } else if (beforeLevel == level) {// if the newcoming's level equals to before's , pop
                                      // before push new
      stack.pop();
      map.put(specHierarchy, level);
      stack.push(specHierarchy);
    } else if (level > beforeLevel) {// if the new coming is before's child , set before's
                                     // child , and push new
      stack.peek().getChildren().add(specHierarchy);
      map.put(specHierarchy, level);
      stack.push(specHierarchy);
    } else if (level < beforeLevel && level >= startLevel) {// if the new coming is child of
                                                            // before any element except of
                                                            // before element
      for (;;) {
        if (map.get(stack.peek()) >= level) {
          stack.pop();
        } else {
          break;
        }
      }
      map.put(specHierarchy, level);
      stack.push(specHierarchy);
    } else if (level < startLevel) {// if the new coming's level bigger than root
      throw new RuntimeErrorException(null, "Root must be lowest level.");
    }
    beforeLevel = level;
  }

  @Override
  public void beginDocument() {}

  @Override
  public void beginBlock(BlockType type, Attributes attributes) {
    blockSpec = "";
  }

  @Override
  public void acronym(String text, String definition) {}
}
