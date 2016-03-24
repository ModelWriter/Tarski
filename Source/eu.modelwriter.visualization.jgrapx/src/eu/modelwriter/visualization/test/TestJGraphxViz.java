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
package eu.modelwriter.visualization.test;

import eu.modelwriter.model.example.ExampleGenerator;
import eu.modelwriter.visualization.editor.Frame;

public class TestJGraphxViz {
  public static void main(final String[] args) {
    final Frame visualization = Frame.getInstance(ExampleGenerator.createFileSystemExample());
    visualization.showModel();
  }
}
