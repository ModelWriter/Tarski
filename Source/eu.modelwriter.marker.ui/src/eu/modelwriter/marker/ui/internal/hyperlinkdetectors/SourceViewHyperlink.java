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
package eu.modelwriter.marker.ui.internal.hyperlinkdetectors;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.typing.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.internal.views.mappingview.SourceView;

public class SourceViewHyperlink implements IHyperlink {

  private final IRegion fUrlRegion;

  public SourceViewHyperlink(IRegion urlRegion) {
    fUrlRegion = urlRegion;
  }

  @Override
  public IRegion getHyperlinkRegion() {
    return fUrlRegion;
  }

  @Override
  public String getHyperlinkText() {
    return "Open Source Mappings";
  }

  @Override
  public String getTypeLabel() {
    return null;
  }

  @Override
  public void open() {
    try {
      IFile file = MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

      IMarker beMapped = MarkerFactory.findMarkerByOffset(file, fUrlRegion.getOffset());

      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(SourceView.ID);

      if ((beMapped != null)
          && (!AlloyUtilities.getRelationsOfSecondSideMarker(beMapped).isEmpty())) {

        Map<IMarker, String> sources = AlloyUtilities.getRelationsOfSecondSideMarker(beMapped);
        SourceView.setColumns(sources.keySet());
      } else {
        SourceView.setColumns(new ArrayList<IMarker>());
      }
    } catch (PartInitException e) {
      e.printStackTrace();
    }
  }
}
