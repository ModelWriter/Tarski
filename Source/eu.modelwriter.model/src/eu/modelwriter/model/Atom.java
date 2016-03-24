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
package eu.modelwriter.model;

import java.io.Serializable;

public class Atom {
  private final String text;
  private Serializable data;
  private String id;

  public Atom(final String text) {
    this.text = text;
  }

  public Serializable getData() {
    return this.data;
  }

  public String getId() {
    return this.id;
  }

  public String getText() {
    return this.text;
  }

  public void setData(final Serializable data) {
    this.data = data;
  }

  public void setId(final String id) {
    this.id = id;
  }

}
