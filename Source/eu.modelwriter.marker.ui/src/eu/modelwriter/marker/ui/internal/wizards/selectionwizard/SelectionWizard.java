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
package eu.modelwriter.marker.ui.internal.wizards.selectionwizard;

import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

public class SelectionWizard extends Wizard {
  ArrayList<IMarker> candidateList;
  private IMarker selectedMarker;

  private SelectionWizardPage deletingWizardPage;

  public SelectionWizard() {
    this.candidateList = new ArrayList<IMarker>();
    setWindowTitle("Select Marker");
  }

  public SelectionWizard(ArrayList<IMarker> candidateList) {
    setWindowTitle("Select Marker");
    this.candidateList = candidateList;
  }

  @Override
  public void addPages() {
    deletingWizardPage = new SelectionWizardPage(candidateList);
    super.addPages();
    this.addPage(deletingWizardPage);
  }

  @Override
  public boolean performFinish() {
    TableItem selectedItem = deletingWizardPage.getTable().getSelection()[0];
    this.selectedMarker = (IMarker) selectedItem.getData();
    return true;
  }

  public IMarker getSelectedMarker() {
    return this.selectedMarker;
  }
}
