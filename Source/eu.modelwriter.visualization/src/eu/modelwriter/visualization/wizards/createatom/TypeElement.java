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
package eu.modelwriter.visualization.wizards.createatom;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class TypeElement implements Serializable {

  private String type;
  private ArrayList<TypeElement> children = new ArrayList<TypeElement>();
  private boolean isTop = false;

  public TypeElement(String type) {
    this.type = type;
  }

  public TypeElement(String type, boolean isTop) {
    this.type = type;
    this.setTop(isTop);
  }

  public TypeElement(String type, ArrayList<TypeElement> children) {
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

  public ArrayList<TypeElement> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<TypeElement> children) {
    this.children = children;
  }


  @Override
  public String toString() {

    return type;
  }

  public boolean isTop() {
    return isTop;
  }

  public void setTop(boolean isTop) {
    this.isTop = isTop;
  }

}
