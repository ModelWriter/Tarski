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

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MarkerTypeElement implements Serializable {

  private String type;
  private ArrayList<MarkerTypeElement> children = new ArrayList<MarkerTypeElement>();

  public MarkerTypeElement(String type) {
    this.type = type;
  }

  public MarkerTypeElement(String type, ArrayList<MarkerTypeElement> children) {
    super();
    this.type = type;
    this.children = children;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ArrayList<MarkerTypeElement> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<MarkerTypeElement> children) {
    this.children = children;
  }
}
