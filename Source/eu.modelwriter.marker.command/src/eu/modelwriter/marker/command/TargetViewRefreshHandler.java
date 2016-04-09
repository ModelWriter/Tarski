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
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ITreeSelection;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MappingUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.internal.views.mappingview.TargetView;
import eu.modelwriter.marker.ui.internal.views.masterview.MasterView;

public class TargetViewRefreshHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.targetviewrefresh";

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (MasterView.getTreeViewer() == null) {
      return null;
    }
    if (MasterView.getTreeViewer().getSelection().isEmpty()
        || ((ITreeSelection) MasterView.getTreeViewer().getSelection()).getFirstElement() == null) {
      TargetView.setColumns(new ArrayList<IMarker>());
      return null;
    }
    ITreeSelection treeSelection = (ITreeSelection) MasterView.getTreeViewer().getSelection();
    IMarker marker = (IMarker) treeSelection.getFirstElement();

    // if (MarkUtilities.getType(marker) != null) {
    // Map<IMarker, String> targets = AlloyUtilities.getRelationsOfFirstSideMarker(marker);
    // TargetView.setColumns(targets.keySet());
    // } else {
    ArrayList<IMarker> targets = MappingUtilities.getTargetsOfMarker(marker);
    // AlloyUtilities.getTargetsOfMarkerAtRelations(marker);
    // TargetView.setColumns(targets);
    // }
    return true;
  }
}
