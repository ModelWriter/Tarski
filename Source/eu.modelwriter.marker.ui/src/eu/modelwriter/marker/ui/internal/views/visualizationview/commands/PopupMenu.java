package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class PopupMenu {
  public PopupMenu(final JPopupMenu menu) {
    final JMenu modelWriterMenu = Visualization.modelWriterMenu = new JMenu("Management");
    menu.add(modelWriterMenu, 0);

    final JMenuItem deleteAtomMenuItem = new JMenuItem("Delete Atom");
    final JMenuItem addRemoveTypeMenuItem = new JMenuItem("Change Type");
    final JMenuItem removeRelationMenuItem = new JMenuItem("Remove Relation");
    final JMenuItem mappingMenuItem = new JMenuItem("Map Atom");
    final JMenuItem createNewAtomMenuItem = new JMenuItem("Create New Atom");
    final JMenuItem resolveMenuItem = new JMenuItem("Resolve");
    modelWriterMenu.add(addRemoveTypeMenuItem, 0);
    modelWriterMenu.add(createNewAtomMenuItem, 1);
    modelWriterMenu.add(deleteAtomMenuItem, 2);
    modelWriterMenu.add(mappingMenuItem, 3);
    modelWriterMenu.add(removeRelationMenuItem, 4);
    modelWriterMenu.add(resolveMenuItem, 5);

    final JMenu analysisMenu = Visualization.analysisMenu = new JMenu("Analysis");
    menu.add(analysisMenu, 1);

    final JMenuItem validateMenuItem = new JMenuItem("Check Consistency");
    final JMenuItem discoverRelationMenuItem = new JMenuItem("Reason on Relations");
    final JMenuItem acceptReasonedRelationMenuItem = new JMenuItem("Accept Reasoning");
    final JMenuItem discoverAtomMenuItem = new JMenuItem("Discover Atoms");
    final JMenuItem interpretAtomMenuItem = new JMenuItem("Interpret Atom");
    final JMenuItem nextSolution = new JMenuItem("Next Solution");
    final JMenuItem stopAnalysis = new JMenuItem("Stop Analysis");
    final JMenuItem clearAllReasoned = new JMenuItem("Clear All Reasoned Tuples");
    analysisMenu.add(validateMenuItem, 0);
    analysisMenu.add(discoverRelationMenuItem, 1);
    analysisMenu.add(acceptReasonedRelationMenuItem, 2);
    analysisMenu.add(nextSolution, 3);
    analysisMenu.add(stopAnalysis, 4);
    analysisMenu.add(discoverAtomMenuItem, 5);
    analysisMenu.add(clearAllReasoned, 6);
    analysisMenu.add(interpretAtomMenuItem, 7);

    final JMenuItem refreshMenuItem = new JMenuItem("Refresh");
    menu.add(refreshMenuItem, 2);

    refreshMenuItem
    .addActionListener(VisualizationActionListenerFactory.instance.refreshActionListener());
    addRemoveTypeMenuItem.addActionListener(
        VisualizationActionListenerFactory.instance.addRemoveTypeActionListener());
    createNewAtomMenuItem.addActionListener(
        VisualizationActionListenerFactory.instance.createNewAtomActionListener());
    deleteAtomMenuItem
    .addActionListener(VisualizationActionListenerFactory.instance.deleteAtomActionListener());
    mappingMenuItem
    .addActionListener(VisualizationActionListenerFactory.instance.mappingActionListener());
    removeRelationMenuItem.addActionListener(
        VisualizationActionListenerFactory.instance.removeRelationActionListener());
    resolveMenuItem
    .addActionListener(VisualizationActionListenerFactory.instance.resolveActionListener());
    validateMenuItem
    .addActionListener(VisualizationActionListenerFactory.instance.validateActionListener());
    discoverRelationMenuItem.addActionListener(
        VisualizationActionListenerFactory.instance.discoverRelationActionListener());
    acceptReasonedRelationMenuItem.addActionListener(
        VisualizationActionListenerFactory.instance.acceptReasonedRelationActionListener());
    discoverAtomMenuItem.addActionListener(
        VisualizationActionListenerFactory.instance.discoverAtomActionListener());
    nextSolution.addActionListener(
        VisualizationActionListenerFactory.instance.nextSolutionActionListener());
    stopAnalysis.addActionListener(
        VisualizationActionListenerFactory.instance.stopAnalysisActionListener());
    clearAllReasoned.addActionListener(
        VisualizationActionListenerFactory.instance.clearAllReasonedActionListener());
    interpretAtomMenuItem.addActionListener(
        VisualizationActionListenerFactory.instance.interpretAtomMenuItemActionListener());
  }
}
