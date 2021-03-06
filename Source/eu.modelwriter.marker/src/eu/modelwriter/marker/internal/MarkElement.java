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
/**
 * 
 */
package eu.modelwriter.marker.internal;

import org.eclipse.core.resources.IMarker;

/**
 * @author Ferhat Erata
 *
 */
public class MarkElement implements java.io.Serializable {

  private static final long serialVersionUID = 1L;
  private String sourceId;
  private String path;

  /**
   * this constructs mark element for given IMarker
   * 
   * @param iMarker
   */
  public MarkElement(IMarker iMarker) {
    this.sourceId = MarkUtilities.getSourceId(iMarker);
    this.path = MarkUtilities.getPath(iMarker);
  }

  /**
   * 
   * @return markElement as {@link IMarker}
   */
  public IMarker getiMarker() {
    return MarkUtilities.getiMarker(sourceId, path);
  }
}

