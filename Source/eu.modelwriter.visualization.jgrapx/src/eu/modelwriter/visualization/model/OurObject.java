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
import java.util.HashMap;
import java.util.Map;

public class OurObject implements Serializable {
  private static final long serialVersionUID = 1L;
  private String tagName;
  private final Map<String, String> attributes = new HashMap<String, String>();

  public OurObject() {}

  @Override
  public boolean equals(final Object obj) {
    if (obj instanceof OurObject) {
      final OurObject obj2 = (OurObject) obj;
      if (obj2.tagName.equals(this.tagName)) {
        return true;
      }
    }
    return false;
  }

  public String getAttribute(final String key) {
    return this.attributes.get(key);
  }

  public void setAttribute(final String key, final String value) {
    this.attributes.put(key, value);
    if (key.equals("name")) {
      this.tagName = key;
    }
  }
}
