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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MarkerMapping;

public class MarkerMappingActionHyperlink implements IHyperlink {

  private final IRegion fUrlRegion;

  public MarkerMappingActionHyperlink(final IRegion urlRegion) {
    this.fUrlRegion = urlRegion;
  }

  @Override
  public IRegion getHyperlinkRegion() {
    return this.fUrlRegion;
  }

  @Override
  public String getHyperlinkText() {
    return "Open Mapping Wizard";
  }

  @Override
  public String getTypeLabel() {
    return null;
  }

  @Override
  public void open() {

    final IFile file = MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

    final int start = this.fUrlRegion.getOffset();
    final int end = this.fUrlRegion.getOffset() + this.fUrlRegion.getLength();
    final IMarker beMapped = MarkerFactory.findMarkerWithAbsolutePosition(file, start, end);

    if (beMapped != null) {
      MarkerMapping.getInstance().runWithMarker(beMapped);
    } else {
      final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
          null, "Something goes wrong with this text fragments", MessageDialog.WARNING,
          new String[] {"OK"}, 0);
      dialog.open();
    }
  }
}
