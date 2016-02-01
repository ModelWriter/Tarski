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
package eu.modelwriter.marker.command;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ITreeSelection;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.internal.views.mappingview.SourceView;
import eu.modelwriter.marker.ui.internal.views.masterview.MasterView;

public class SourceViewRefreshHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.sourceviewrefresh";

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (MasterView.getTreeViewer() == null) {
      return null;
    }
    if (MasterView.getTreeViewer().getSelection().isEmpty()
        || ((ITreeSelection) MasterView.getTreeViewer().getSelection()).getFirstElement() == null) {
      SourceView.setColumns(new ArrayList<IMarker>());
      return null;
    }
    ITreeSelection treeSelection = (ITreeSelection) MasterView.getTreeViewer().getSelection();
    IMarker marker = (IMarker) treeSelection.getFirstElement();

    if (MarkUtilities.getType(marker) != null) {
      ArrayList<IMarker> sources = AlloyUtilities.getSumSources(marker);
      SourceView.setColumns(sources);
    } else {
      ArrayList<IMarker> sources = AlloyUtilities.getSourcesOfMarkerAtRelations(marker);
      SourceView.setColumns(sources);
    }
    return true;
  }
}
