package eu.modelwriter.marker.ui.internal.views.visualizationview;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.services.ISourceProviderService;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4graph.GraphEdge;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.discovery.AlloyOtherSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyOtherSolutionReasoning;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.commands.VisualizationActionListenerFactory;

public class Visualization extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.visualizationview";
  private static VizState myState = null;
  private static VizGraphPanel graph;
  private static JPanel graphPanel;
  private static GraphViewer viewer;
  private static Frame frame;
  private static File f = null;
  public static Object rightClickedAnnotation;
  final static String xmlFileName = Util.canon(AlloyUtilities.getLocation());
  public static Composite container;
  public static AnalysisSourceProvider sourceProvider;
  public static String relation;

  private static final JMenuItem refreshMenuItem = new JMenuItem("Refresh");
  private static final JMenu modelWriterMenu = new JMenu("Management");
  private static final JMenuItem deleteAtomMenuItem = new JMenuItem("Delete Atom");
  private static final JMenuItem addRemoveTypeMenuItem = new JMenuItem("Change Type");
  private static final JMenuItem removeRelationMenuItem = new JMenuItem("Remove Relation");
  private static final JMenuItem mappingMenuItem = new JMenuItem("Map Atom");
  private static final JMenuItem createNewAtomMenuItem = new JMenuItem("Create New Atom");
  private static final JMenuItem createInstanceElementMenuItem = new JMenuItem("Create New Atom");
  private static final JMenuItem resolveMenuItem = new JMenuItem("Resolve");

  private static final JMenu analysisMenu = new JMenu("Analysis");
  private static final JMenuItem validateMenuItem = new JMenuItem("Check Consistency");
  private static final JMenuItem discoverRelationMenuItem = new JMenuItem("Reason on Relations");
  private static final JMenuItem acceptReasonedRelationMenuItem = new JMenuItem("Accept Reasoning");
  private static final JMenuItem discoverAtomMenuItem = new JMenuItem("Discover Atoms");
  private static final JMenuItem interpretAtomMenuItem = new JMenuItem("Interpret Atom");
  private static final JMenuItem acceptRelationAsEMFMenuItem = new JMenuItem("Accept Reasoning");
  private static final JMenuItem acceptAtomAsEMFMenuItem = new JMenuItem("Interpret Atom");
  private static final JMenuItem discoverRelationForAtomMenuItem =
      new JMenuItem("Reasoning for Atom");
  private static final JMenuItem nextSolution = new JMenuItem("Next Solution");
  private static final JMenuItem previousSolution = new JMenuItem("Previous Solution");
  private static final JMenuItem stopAnalysis = new JMenuItem("Stop Analysis");
  private static final JMenuItem clearAllReasoned = new JMenuItem("Clear All Reasoned Tuples");
  private static final JMenuItem acceptAllReasoned = new JMenuItem("Accept All Reasoned Tuples");

  public static IMarker getMarker(final AlloyAtom highLightedAtom) {
    if (highLightedAtom.isDashed) {
      return null;
    }

    final String atomType = highLightedAtom.getType().getName();
    final String stringIndex = highLightedAtom.toString().substring(atomType.length());
    int index = 0;
    if (!stringIndex.isEmpty()) {
      index = Integer.parseInt(stringIndex);
    }

    final IMarker marker = AlloyUtilities.findMarker(atomType, index);

    return marker;
  }

  private static MouseAdapter getMouseAdapter() {
    return new MouseAdapter() {
      @Override
      public void mouseClicked(final MouseEvent e) {
        super.mouseClicked(e);
        if (e.getClickCount() > 1) {
          final Object annotation = Visualization.viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());

          if (annotation instanceof AlloyAtom) {
            final IMarker marker = Visualization.getMarker((AlloyAtom) annotation);
            if (marker == null) {
              return;
            }
            MarkUtilities.focusMarker(marker);
          }
        }
      }

      /**
       * when mouse exited from graph<br>
       * (not from AlloyAtom or not from AlloyTuple)
       */
      @Override
      public void mouseExited(final MouseEvent e) {
        Visualization.frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        final Object annotation = Visualization.viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
        if (annotation == null) {
          final JMenu modelWriterMenu = (JMenu) Visualization.viewer.pop.getComponent(0);
          if (!Visualization.viewer.pop.isShowing()) {
            modelWriterMenu.setVisible(false);
          }
        }
      }

      @Override
      public void mousePressed(final MouseEvent e) {
        switch (e.getButton()) {
          case MouseEvent.BUTTON3: // right click
            Object curState = Visualization.sourceProvider.getCurrentState()
                .get(AnalysisSourceProvider.ANALYSIS_STATE);
            Visualization.rightClickedAnnotation =
                Visualization.viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
            AlloyTuple tuple = null;
            AlloyAtom atom = null;
            AlloyAtom leftAtom = null;
            AlloyAtom rightAtom = null;
            if (Visualization.rightClickedAnnotation instanceof AlloyAtom)
              atom = (AlloyAtom) Visualization.rightClickedAnnotation;
            else if (Visualization.rightClickedAnnotation instanceof AlloyTuple) {
              tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
              leftAtom = tuple.getStart();
              rightAtom = tuple.getEnd();

              try {
                Field field = GraphViewer.class.getDeclaredField("selected");
                field.setAccessible(true);
                if (field.get(Visualization.viewer) instanceof GraphEdge) {
                  final GraphEdge edge = (GraphEdge) field.get(Visualization.viewer);
                  Visualization.relation =
                      edge.group.toString().substring(0, edge.group.toString().indexOf(":") - 1);
                }
              } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                  | IllegalAccessException e1) {
                e1.printStackTrace();
              }
            }
            boolean onAtom = atom != null;
            boolean atomReasoned = onAtom && atom.isDashed;
            boolean onRelation = tuple != null;
            boolean relationReasoned = onRelation && tuple.isDashed;
            boolean onEmptyArea = !onAtom && !onRelation;
            boolean resolve = onRelation && leftAtom.changed && rightAtom.impacted.size() != 0;
            boolean analysisActive = curState.equals(AnalysisSourceProvider.ACTIVE);
            boolean hasSolution;
            try {
              hasSolution = analysisActive
                  && AlloyOtherSolutionReasoning.getInstance().getCurrentSolution() != null
                  || AlloyOtherSolutionDiscovering.getInstance().getCurrentSolution() != null;
            } catch (Exception e2) {
              hasSolution = false;
              System.out.println("no solution on right click");
            }
            boolean anyReasoned = AlloyUtilities.isAnyReasoned();

            Visualization.modelWriterMenu.setVisible(!atomReasoned || onRelation || onEmptyArea);
            Visualization.modelWriterMenu.getItem(0).setVisible(onAtom);
            Visualization.modelWriterMenu.getItem(1)
                .setVisible(onEmptyArea && !TraceManager.get().hasInstance());
            Visualization.modelWriterMenu.getItem(2).setVisible(onAtom);
            Visualization.modelWriterMenu.getItem(3).setVisible(onAtom);
            Visualization.modelWriterMenu.getItem(4).setVisible(onRelation);
            Visualization.modelWriterMenu.getItem(5)
                .setVisible((onAtom && atom.changed) || resolve);
            Visualization.modelWriterMenu.getItem(6)
                .setVisible(onEmptyArea && TraceManager.get().hasInstance());

            Visualization.analysisMenu.setVisible(
                onAtom || (onRelation && (anyReasoned && relationReasoned)) || onEmptyArea);
            Visualization.analysisMenu.getItem(0).setVisible(onEmptyArea);
            Visualization.analysisMenu.getItem(1).setVisible(onEmptyArea && !analysisActive);
            Visualization.analysisMenu.getItem(2)
                .setVisible(relationReasoned && !TraceManager.get().hasInstance());
            Visualization.analysisMenu.getItem(3)
                .setVisible(onEmptyArea && analysisActive && hasSolution);
            Visualization.analysisMenu.getItem(4)
                .setVisible(onEmptyArea && analysisActive && hasSolution);
            Visualization.analysisMenu.getItem(5).setVisible(onEmptyArea && !analysisActive);
            Visualization.analysisMenu.getItem(6).setVisible(onEmptyArea && anyReasoned);
            Visualization.analysisMenu.getItem(7).setVisible(
                atomReasoned && !TraceManager.get().hasSigTrace(atom.getType().getName()));
            Visualization.analysisMenu.getItem(8).setVisible(
                atomReasoned && TraceManager.get().hasSigTrace(atom.getType().getName()));
            Visualization.analysisMenu.getItem(9)
                .setVisible(relationReasoned && TraceManager.get().hasInstance());
            Visualization.analysisMenu.getItem(10)
                .setVisible(onEmptyArea && anyReasoned && TraceManager.get().hasInstance());
            Visualization.analysisMenu.getItem(11).setVisible(onAtom && !analysisActive);
            Visualization.analysisMenu.getItem(12).setVisible(onEmptyArea && analysisActive);

            if (e.getSource() instanceof GraphViewer) {
              Visualization.viewer.alloyPopup(Visualization.viewer, e.getX(), e.getY());
            } else {
              Visualization.viewer.alloyPopup(Visualization.graphPanel, e.getX(), e.getY());
            }
          default:
            break;
        }
      }
    };
  }

  private static MouseMotionAdapter getMouseMotionAdapter() {
    return new MouseMotionAdapter() {
      @Override
      public void mouseMoved(final MouseEvent e) {
        JComponent cmpnt = null;
        String tooltip = null;
        try {
          final Object annotation = Visualization.viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
          cmpnt = (JComponent) e.getComponent();

          if (annotation instanceof AlloyAtom) {
            final IMarker marker = Visualization.getMarker((AlloyAtom) annotation);
            if (marker == null) {
              return;
            }

            Visualization.frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
            tooltip = MarkUtilities.getText(marker);
          } else if (annotation instanceof AlloyTuple) {
            final AlloyTuple tuple = (AlloyTuple) annotation;

            final AlloyAtom highLightedAtomStart = tuple.getStart();
            final AlloyAtom highLightedAtomEnd = tuple.getEnd();

            final IMarker markerStart = Visualization.getMarker(highLightedAtomStart);
            final IMarker markerEnd = Visualization.getMarker(highLightedAtomEnd);

            if (markerStart == null || markerEnd == null) {
              return;
            }

            tooltip =
                MarkUtilities.getText(markerStart) + " --> " + MarkUtilities.getText(markerEnd);
            Visualization.frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
          } else {
            /**
             * when mouse exited from AlloyAtom or from AlloyTuple
             */
            Visualization.frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          }

        } catch (final Exception ex) {
          System.err.println("onMouseMoved failed");
          // ex.printStackTrace();
        } finally {
          cmpnt.setToolTipText(tooltip);
        }
      }
    };
  }

  public static void showViz() {
    Point lastLocation = new Point(0, 0);
    if (Visualization.container == null) {
      return;
    }
    if (!AlloyUtilities.isExists()) {
      if (Visualization.frame != null) {
        if (Visualization.frame.getComponentCount() > 0) {
          Visualization.frame.removeAll();
        }
        Visualization.frame.add(new JPanel());
      } else if (Visualization.frame == null) {
        Visualization.frame = SWT_AWT.new_Frame(Visualization.container);
        Visualization.frame.add(new JPanel());
      }
      return;
    }
    Visualization.f = new File(Visualization.xmlFileName);
    try {
      if (!Visualization.f.exists()) {
        throw new IOException("File " + Visualization.xmlFileName + " does not exist.");
      }
      final AlloyInstance instance = StaticInstanceReader.parseInstance(Visualization.f);

      AlloyUtilities.setAllImpactsAndChanges(instance);
      AlloyUtilities.setAllReasonedTuples(instance);
      AlloyUtilities.setAllReasonedAtoms(instance);

      Visualization.myState = new VizState(instance);

      // FE
      Visualization.myState.mergeArrows.put(null, false);

      if (Visualization.graphPanel != null) {
        lastLocation = Visualization.graphPanel.getLocation();
      }

      if (Visualization.frame == null) {
        Visualization.frame = SWT_AWT.new_Frame(Visualization.container);
      }

      if (Visualization.graph != null && Visualization.frame.getComponent(0) != null) {
        Visualization.frame.remove(Visualization.graph);
      }

      try {
        /*
         * TODO BUG
         * 
         * A Fatal Error occurs while setting GTK look and feel on Ubuntu 16.04
         * (com.sun.java.swing.plaf.gtk.GTKLookAndFeel).
         * 
         */
        final String LaF = UIManager.getSystemLookAndFeelClassName();
        if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(LaF)) {
          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } else {
          UIManager.setLookAndFeel(LaF);
        }
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
          | UnsupportedLookAndFeelException e1) {

        e1.printStackTrace();
      }
      Visualization.graph = new VizGraphPanel(Visualization.myState, false);
      Visualization.graphPanel = Visualization.graph.getGraphPanel();
      Visualization.graphPanel.setLocation(lastLocation);
      Visualization.viewer = Visualization.graph.alloyGetViewer();
      Visualization.frame.removeAll();
      Visualization.frame.add(Visualization.graph);
      Visualization.frame.setVisible(true);
      Visualization.frame.setAlwaysOnTop(true);
      Visualization.graph.alloyGetViewer().alloyRepaint();

      final ISourceProviderService service =
          Activator.getDefault().getWorkbench().getService(ISourceProviderService.class);
      Visualization.sourceProvider =
          (AnalysisSourceProvider) service.getSourceProvider(AnalysisSourceProvider.ANALYSIS_STATE);
    } catch (final Err e1) {
      e1.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }

    Visualization.graph.alloyGetViewer().pop.add(modelWriterMenu, 0);
    Visualization.graph.alloyGetViewer().pop.add(analysisMenu, 1);
    Visualization.graph.alloyGetViewer().pop.add(refreshMenuItem, 2);

    Visualization.graph.alloyGetViewer()
        .addMouseMotionListener(Visualization.getMouseMotionAdapter());
    Visualization.graphPanel.addMouseMotionListener(Visualization.getMouseMotionAdapter());
    Visualization.graph.alloyGetViewer().addMouseListener(Visualization.getMouseAdapter());
    Visualization.graphPanel.addMouseListener(Visualization.getMouseAdapter());
  }

  private static void createPopupMenu() {
    modelWriterMenu.add(addRemoveTypeMenuItem, 0);
    modelWriterMenu.add(createNewAtomMenuItem, 1);
    modelWriterMenu.add(deleteAtomMenuItem, 2);
    modelWriterMenu.add(mappingMenuItem, 3);
    modelWriterMenu.add(removeRelationMenuItem, 4);
    modelWriterMenu.add(resolveMenuItem, 5);
    modelWriterMenu.add(createInstanceElementMenuItem, 6);

    analysisMenu.add(validateMenuItem, 0);
    analysisMenu.add(discoverRelationMenuItem, 1);
    analysisMenu.add(acceptReasonedRelationMenuItem, 2);
    analysisMenu.add(nextSolution, 3);
    analysisMenu.add(stopAnalysis, 4);
    analysisMenu.add(discoverAtomMenuItem, 5);
    analysisMenu.add(clearAllReasoned, 6);
    analysisMenu.add(interpretAtomMenuItem, 7);
    analysisMenu.add(acceptAtomAsEMFMenuItem, 8);
    analysisMenu.add(acceptRelationAsEMFMenuItem, 9);
    analysisMenu.add(acceptAllReasoned, 10);
    analysisMenu.add(discoverRelationForAtomMenuItem, 11);
    analysisMenu.add(previousSolution, 12);

    refreshMenuItem.addActionListener(VisualizationActionListenerFactory.refreshActionListener());
    addRemoveTypeMenuItem
        .addActionListener(VisualizationActionListenerFactory.addRemoveTypeActionListener());
    createNewAtomMenuItem
        .addActionListener(VisualizationActionListenerFactory.createNewAtomActionListener());
    deleteAtomMenuItem
        .addActionListener(VisualizationActionListenerFactory.deleteAtomActionListener());
    mappingMenuItem.addActionListener(VisualizationActionListenerFactory.mappingActionListener());
    removeRelationMenuItem
        .addActionListener(VisualizationActionListenerFactory.removeRelationActionListener());
    resolveMenuItem.addActionListener(VisualizationActionListenerFactory.resolveActionListener());
    validateMenuItem.addActionListener(VisualizationActionListenerFactory.validateActionListener());
    discoverRelationMenuItem
        .addActionListener(VisualizationActionListenerFactory.discoverRelationActionListener());
    acceptReasonedRelationMenuItem.addActionListener(
        VisualizationActionListenerFactory.acceptReasonedRelationActionListener());
    discoverAtomMenuItem
        .addActionListener(VisualizationActionListenerFactory.discoverAtomActionListener());
    nextSolution.addActionListener(VisualizationActionListenerFactory.nextSolutionActionListener());
    previousSolution
        .addActionListener(VisualizationActionListenerFactory.previousSolutionActionListener());
    stopAnalysis.addActionListener(VisualizationActionListenerFactory.stopAnalysisActionListener());
    clearAllReasoned
        .addActionListener(VisualizationActionListenerFactory.clearAllReasonedActionListener());
    interpretAtomMenuItem.addActionListener(
        VisualizationActionListenerFactory.interpretAtomMenuItemActionListener());
    acceptRelationAsEMFMenuItem.addActionListener(
        VisualizationActionListenerFactory.acceptRelationAsEMFMenuItemActionListener());
    acceptAtomAsEMFMenuItem.addActionListener(
        VisualizationActionListenerFactory.acceptAtomAsEMFMenuItemActionListener());
    acceptAllReasoned
        .addActionListener(VisualizationActionListenerFactory.acceptAllReasonedListener());
    discoverRelationForAtomMenuItem.addActionListener(
        VisualizationActionListenerFactory.discoverRelationForAtomActionListener());
    createInstanceElementMenuItem.addActionListener(
        VisualizationActionListenerFactory.createInstanceElementActionListener());
  }

  @Override
  public void createPartControl(final Composite parent) {
    Visualization.container = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    Visualization.frame = null;
    Visualization.f = null;
    Visualization.graph = null;
    Visualization.myState = null;
    Visualization.showViz();
    createPopupMenu();
  }

  @Override
  public void setFocus() {}
}
