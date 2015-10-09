/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
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
  private ArrayList<SpecObject> specObjects = new ArrayList<SpecObject>();

  String blockSpec;

  SpecHierarchy specHierarchy = null;
  SpecObject specObject = null;

  @Override
  public void acronym(String text, String definition) {}

  @Override
  public void beginBlock(BlockType type, Attributes attributes) {
    this.blockSpec = "";
  }

  @Override
  public void beginDocument() {}

  @Override
  public void beginHeading(int level, Attributes attributes) {
    this.blockSpec = "";
    this.specHierarchy = ReqIF10Factory.eINSTANCE.createSpecHierarchy();
    this.specObject = ReqIF10Factory.eINSTANCE.createSpecObject();
    this.specObjects.add(this.specObject);
    this.specHierarchy.setObject(this.specObject);

    if (this.stack.isEmpty()) {// if the new coming is root push to stack
      this.startLevel = level;
      this.map.put(this.specHierarchy, level);
      this.stack.push(this.specHierarchy);
    } else if (this.beforeLevel == level) {// if the newcoming's level equals to before's , pop
      // before push new
      this.stack.pop();
      if (!this.stack.isEmpty()) {
        this.stack.peek().getChildren().add(this.specHierarchy);
      }
      this.map.put(this.specHierarchy, level);
      this.stack.push(this.specHierarchy);
    } else if (level > this.beforeLevel) {// if the new coming is before's child , set before's
      // child , and push new
      this.stack.peek().getChildren().add(this.specHierarchy);
      this.map.put(this.specHierarchy, level);
      this.stack.push(this.specHierarchy);
    } else if (level < this.beforeLevel && level >= this.startLevel) {// if the new coming is
                                                                      // child of
      // before any element except of
      // before element
      for (;;) {
        if (!this.stack.isEmpty() && this.map.get(this.stack.peek()) >= level) {
          this.stack.pop();
        } else {
          break;
        }
      }
      if (!this.stack.isEmpty()) {
        this.stack.peek().getChildren().add(this.specHierarchy);
      }
      this.map.put(this.specHierarchy, level);
      this.stack.push(this.specHierarchy);
    } else if (level < this.startLevel) {// if the new coming's level bigger than root
      throw new RuntimeErrorException(null, "Root must be lowest level.");
    }
    this.beforeLevel = level;
  }

  @Override
  public void beginSpan(SpanType type, Attributes attributes) {}

  @Override
  public void characters(String text) {
    this.blockSpec += text;
    if (!this.specObject.getValues().isEmpty()) {
      return;
    }
    AttributeValueString attribute = ReqIF10Factory.eINSTANCE.createAttributeValueString();
    attribute.setTheValue(text);
    this.specObject.getValues().add(attribute);
  }

  @Override
  public void charactersUnescaped(String literal) {}

  @Override
  public void endBlock() {
    if (!this.blockSpec.equals("")) {
      this.specHierarchy = ReqIF10Factory.eINSTANCE.createSpecHierarchy();
      this.specObject = ReqIF10Factory.eINSTANCE.createSpecObject();
      this.specObjects.add(this.specObject);
      this.specHierarchy.setObject(this.specObject);
      AttributeValueString attribute = ReqIF10Factory.eINSTANCE.createAttributeValueString();
      attribute.setTheValue(this.blockSpec);
      this.blockSpec = "";
      this.specObject.getValues().add(attribute);
      this.stack.peek().getChildren().add(this.specHierarchy); // paragraph has been set its own
                                                               // heading's child.
    }
  }

  @Override
  public void endDocument() {
    for (Map.Entry<SpecHierarchy, Integer> entry : this.map.entrySet()) {
      if (entry.getValue() == this.startLevel) {
        this.rootSet.add(entry.getKey());
      }
    }
  }

  @Override
  public void endHeading() {}

  @Override
  public void endSpan() {}

  @Override
  public void entityReference(String entity) {}

  public ArrayList<SpecObject> getNewlySpecObjects() {
    return this.specObjects;
  }

  public ArrayList<SpecHierarchy> getRootSet() {
    return this.rootSet;
  }

  @Override
  public void image(Attributes attributes, String url) {}

  @Override
  public void imageLink(Attributes linkAttributes, Attributes imageAttributes, String href,
      String imageUrl) {}

  @Override
  public void lineBreak() {}

  @Override
  public void link(Attributes attributes, String hrefOrHashName, String text) {}
}
