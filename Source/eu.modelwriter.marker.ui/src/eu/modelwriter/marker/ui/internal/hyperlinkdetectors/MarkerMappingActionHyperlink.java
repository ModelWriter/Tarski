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

  public MarkerMappingActionHyperlink(IRegion urlRegion) {
    fUrlRegion = urlRegion;
  }

  @Override
  public IRegion getHyperlinkRegion() {
    return fUrlRegion;
  }

  @Override
  public String getTypeLabel() {
    return null;
  }

  @Override
  public String getHyperlinkText() {
    return "Open Mapping Wizard";
  }

  @Override
  public void open() {

    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

    IMarker beMapped = MarkerFactory.findMarkerByOffset(file, fUrlRegion.getOffset());

    if (beMapped != null) {
      MarkerMapping.getInstance().run();
    } else {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "Something goes wrong with this text fragments", MessageDialog.WARNING,
          new String[] {"OK"}, 0);
      dialog.open();
    }
  }
}
