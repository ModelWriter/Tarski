package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import eu.modelwriter.marker.ui.internal.views.visualizationview.TraceabilityViewJGraphx;

public class PopupMenuJGraphx {
  public PopupMenuJGraphx(final JPopupMenu menu) {
    final JMenu modelWriterMenu = TraceabilityViewJGraphx.modelWriterMenu = new JMenu("Management");
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

    final JMenu analysisMenu = TraceabilityViewJGraphx.analysisMenu = new JMenu("Analysis");
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

    refreshMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.refreshActionListener());
    addRemoveTypeMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.addRemoveTypeActionListener());
    createNewAtomMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.createNewAtomActionListener());
    deleteAtomMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.deleteAtomActionListener());
    mappingMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.mappingActionListener());
    removeRelationMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.removeRelationActionListener());
    resolveMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.resolveActionListener());
    validateMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.validateActionListener());
    discoverRelationMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.discoverRelationActionListener());
    acceptReasonedRelationMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.acceptReasonedRelationActionListener());
    discoverAtomMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.discoverAtomActionListener());
    nextSolution.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.nextSolutionActionListener());
    stopAnalysis.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.stopAnalysisActionListener());
    clearAllReasoned.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.clearAllReasonedActionListener());
    interpretAtomMenuItem.addActionListener(
        VisualizationActionListenerFactoryJGraphx.instance.interpretAtomMenuItemActionListener());
  }
}
