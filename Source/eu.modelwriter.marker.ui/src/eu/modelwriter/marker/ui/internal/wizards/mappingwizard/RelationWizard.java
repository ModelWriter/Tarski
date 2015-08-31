package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

import eu.modelwriter.marker.internal.Relation;

public class RelationWizard extends Wizard {

  private RelationsWizardPage relationWizardPage;
  public static String TEMP_RELATION = "tempRelation";

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
    MappingWizard.relationMap.put(selectedMarker, Relation.stringToRelation(relation));
    return true;
  }



}
