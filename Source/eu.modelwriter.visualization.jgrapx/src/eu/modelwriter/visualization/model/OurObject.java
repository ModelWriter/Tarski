/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.visualization.model;

import java.io.Serializable;

public class OurObject implements Serializable {
  private static final long serialVersionUID = 1L;
  private String tagName;

  public OurObject() {}

  public OurObject(final String text) {
    this.tagName = text;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new OurObject(this.tagName);
  }

  public OurObject cloneNode(final boolean asd) {
    return new OurObject(this.tagName);
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj instanceof OurObject) {
      final OurObject obj2 = (OurObject) obj;
      if (obj2.getText().equals(this.tagName)) {
        return true;
      }
    }
    return false;
  }

  public String getAttribute(final String key) {
    if (key.equals("tagName")) {
      return this.tagName;
    }
    return null;
  }

  public String getText() {
    return this.tagName;
  }

  public void setAttribute(final String key, final String value) {
    if (key.equals("tagName")) {
      this.tagName = value;
    }
  }

  public void setText(final String text) {
    this.tagName = text;
  }

  @Override
  public String toString() {
    return this.tagName;
  }

}
