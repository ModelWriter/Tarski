// package eu.modelwriter.visualization.wizards.createatom;
//
// import org.eclipse.jface.viewers.TreeSelection;
// import org.eclipse.jface.wizard.Wizard;
//
// import eu.modelwriter.visualization.Utility;
//
// public class CreateAtomWizard extends Wizard {
//
// TypeHierarchyPage typeHierarchyPage;
//
// @Override
// public void addPages() {
// typeHierarchyPage = new TypeHierarchyPage("Type Hierarchy");
// this.addPage(typeHierarchyPage);
// }
//
// @Override
// public boolean performFinish() {
// TreeSelection selection = (TreeSelection) typeHierarchyPage.treeViewer.getSelection();
// if (selection == null || selection.getFirstElement() == null)
// return false;
// String type = ((TypeElement) selection.getFirstElement()).getType();
// String name = typeHierarchyPage.text.getText();
// if (name == null || name.isEmpty())
// return false;
//
// Utility.addAtomToSigType(type, name);
//
// return true;
// }
//
// }
