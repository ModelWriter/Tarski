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
package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.TableItem;

import eu.modelwriter.marker.MarkerActivator;

public class RelationWizard extends Wizard {

  private RelationsWizardPage relationWizardPage;
  public static String selectedRelation;
  public static IMarker selectedMarker;

  public RelationWizard(IMarker selectedMarker) {
    RelationWizard.selectedMarker = selectedMarker;
  }

  @Override
  public void addPages() {
    relationWizardPage = new RelationsWizardPage();
    super.addPages();
    this.addPage(relationWizardPage);
  }

  @Override
  public boolean performFinish() {
    if (relationWizardPage.getTable().getSelection().length == 0)
      return false;
    TableItem item = relationWizardPage.getTable().getSelection()[0];
    selectedRelation = item.getText(0);

    MappingWizard mappingWizard = new MappingWizard();

    WizardDialog mappingDialog = new WizardDialog(MarkerActivator.getShell(), mappingWizard);
    mappingDialog.open();

    return true;
  }



}
