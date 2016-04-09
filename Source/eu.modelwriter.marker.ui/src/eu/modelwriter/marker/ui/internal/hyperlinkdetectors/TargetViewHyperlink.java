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

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MappingUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.mappingview.TargetView;

public class TargetViewHyperlink implements IHyperlink {

  private final IRegion fUrlRegion;

  public TargetViewHyperlink(final IRegion urlRegion) {
    this.fUrlRegion = urlRegion;
  }

  @Override
  public IRegion getHyperlinkRegion() {
    return this.fUrlRegion;
  }

  @Override
  public String getHyperlinkText() {
    return "Open Target Mappings";
  }

  @Override
  public String getTypeLabel() {
    return null;
  }

  @Override
  public void open() {
    try {
      final IFile file = MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

      final IMarker beMapped = MarkerFactory.findMarkerByOffset(file, this.fUrlRegion.getOffset());

      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);

      // if (beMapped != null) {
      // if (MarkUtilities.getType(beMapped) != null
      // && !AlloyUtilities.getRelationsOfFirstSideMarker(beMapped).isEmpty()) {
      // final Map<IMarker, String> targets =
      // AlloyUtilities.getRelationsOfFirstSideMarker(beMapped);
      // TargetView.setColumns(targets.keySet());
      // } else if (MarkUtilities.getType(beMapped) == null
      // && !AlloyUtilities.getTargetsOfMarkerAtRelations(beMapped).isEmpty()) {
      // final ArrayList<IMarker> targets = AlloyUtilities.getTargetsOfMarkerAtRelations(beMapped);
      // TargetView.setColumns(targets);
      // }
      // } else {
      // TargetView.setColumns(new ArrayList<IMarker>());
      // }

      TargetView.setColumns(MappingUtilities.getTargetsOfMarker(beMapped));
    } catch (final PartInitException e) {
      e.printStackTrace();
    }
  }
}
