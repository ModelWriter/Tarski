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

import javax.management.relation.Relation;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

public class RelationWizard extends Wizard {

  private RelationsWizardPage relationWizardPage;

  @Override
  public void addPages() {
    relationWizardPage = new RelationsWizardPage();
    super.addPages();
    this.addPage(relationWizardPage);
  }

  @Override
  public boolean performFinish() {
    TreeSelection treeSelection = ((TreeSelection) MarkerMatchPage.markTreeViewer.getSelection());
    IMarker selectedMarker = (IMarker) treeSelection.getFirstElement();
    TableItem item = relationWizardPage.getTable().getSelection()[0];
    String relation = item.getText(0);
    MappingWizard.relationMap.put(selectedMarker, relation.substring(0, relation.indexOf(" ")));
    return true;
  }



}
