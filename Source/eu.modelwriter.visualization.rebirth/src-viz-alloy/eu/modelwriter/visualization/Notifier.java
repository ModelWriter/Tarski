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
package eu.modelwriter.visualization;

import java.io.Serializable;
import java.util.List;

public interface Notifier {

  public void addTupleNotify(String relationName, List<String> tuple, String bound);

  public void addTupleNotify(String relationName, String inRelationName, List<String> tuple,
      String bound);

  public void moveToLower(String relationName, List<String> tuple);

  public void moveToLower(String relationName, String inRelationName, List<String> tuple);

  public void moveToUpper(String relationName, List<String> tuple);

  public void moveToUpper(String relationName, String inRelationName, List<String> tuple);

  public void notify(Serializable data);

  /**
   *
   * @param relationName
   * @param tuple : Atoms Name in removed tuple
   */
  public void removeTupleNotify(String relationName, List<String> tuple, String bound);

  public void removeTupleNotify(String relationName, String inRelationName, List<String> tuple,
      String bound);

}

