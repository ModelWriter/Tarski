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
package eu.modelwriter.marker.ui.internal.hyperlinkdetectors;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class SourceViewHyperlinkDetector extends AbstractHyperlinkDetector
    implements IHyperlinkDetector {

  @Override
  public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region,
      boolean canShowMultipleHyperlinks) {

    int offset = region.getOffset();
    int length = region.getLength();
    if (offset == 0 && length == 0)
      return null;

    if (MarkerActivator.getEditor() == null || MarkerActivator.getEditor().getEditorInput() == null)
      return null;

    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);
    List<IMarker> markedList = MarkerFactory.findMarkers(file);

    for (IMarker iMarker : markedList) {
      // look for keyword
      // detect region containing keyword
      IRegion targetRegion = new Region(MarkUtilities.getStart(iMarker),
          MarkUtilities.getLength(iMarker));
      if ((targetRegion.getOffset() <= offset)
          && ((targetRegion.getOffset() + targetRegion.getLength()) > offset)) {
        // create link
        return new IHyperlink[] {new SourceViewHyperlink(targetRegion)};
      }
    }
    return null;
  }
}
