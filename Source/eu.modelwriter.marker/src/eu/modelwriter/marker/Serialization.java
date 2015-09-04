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
package eu.modelwriter.marker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class Serialization {

  private static Serialization instance = null;

  protected Serialization() {
    // Exists only to defeat instantiation.
  }

  public static Serialization getInstance() {
    if (instance == null) {
      instance = new Serialization();
    }
    return instance;
  }

  /** Read the object from Base64 string. */
  @SuppressWarnings({"unchecked"})
  public <T> T fromString(String string) throws IOException, ClassNotFoundException {
    byte[] data = Base64.getDecoder().decode(string);
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
    T object = (T) ois.readObject();
    ois.close();
    return object;
  }

  /** Write the object to a Base64 string. */
  public <T extends Serializable> String toString(T object) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(object);
    oos.close();
    return Base64.getEncoder().encodeToString(baos.toByteArray());
  }
}
