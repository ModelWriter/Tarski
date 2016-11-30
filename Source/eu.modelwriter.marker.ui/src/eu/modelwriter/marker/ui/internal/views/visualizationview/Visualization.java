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
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.services.ISourceProviderService;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.OurBorder;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4graph.GraphEdge;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.alloy.analysis.discovering.Discovering;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.AnalysisState;
import eu.modelwriter.configuration.alloy.analysis.reasoning.Reasoning;
import eu.modelwriter.configuration.alloy.analysis.reasoningforatom.ReasoningForAtom;
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
  private static JScrollPane evaluatorPanel;
  public static boolean evaluatorOpen = false;

  public enum AnalysisMenuItems {
    validate("Check Consistency"),
    discoverRelation("Reason on Relations"),
    discoverRelationForAtom("Reasoning for Atom"),
    discoverAtom("Discover Atoms"),
    acceptReasonedRelation("Accept Reasoning"),
    acceptTracedRelation("Accept Reasoning"),
    interpretAtom("Interpret Atom"),
    interpretTracedAtom("Interpret Atom"),
    previousSolution("Previous Solution"),
    nextSolution("Next Solution"),
    stopAnalysis("Stop Analysis"),
    clearAllReasoned("Clear All Reasoned Tuples"),
    acceptAllReasoned("Accept All Reasoned Tuples");

    JMenuItem menuItem = null;

    AnalysisMenuItems(final String title) {
      menuItem = new JMenuItem(title);
    };

    void addToMenu(final JMenu menu) {
      menu.add(menuItem, ordinal());
    }

    JMenuItem getItem() {
      return menuItem;
    }
  };

  public enum ModelWriterMenuItems {
    addRemoveType("Change Type"),
    createNewAtom("Create New Atom"),
    createInstanceElement("Create New Atom"),
    deleteAtom("Delete Atom"),
    mapping("Map Atom"),
    removeRelation("Remove Relation"),
    resolve("Resolve");

    JMenuItem menuItem = null;

    ModelWriterMenuItems(final String title) {
      menuItem = new JMenuItem(title);
    };

    void addToMenu(final JMenu menu) {
      menu.add(menuItem, ordinal());
    }

    JMenuItem getItem() {
      return menuItem;
    }
  }

  public static final JMenu modelWriterMenu = new JMenu("Management");
  private static final JMenu analysisMenu = new JMenu("Analysis");
  private static final JMenuItem refreshMenuItem = new JMenuItem("Refresh");

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
            final Object curState = Visualization.sourceProvider.getCurrentState()
            .get(AnalysisSourceProvider.ANALYSIS_STATE);
            Visualization.rightClickedAnnotation =
                Visualization.viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
            AlloyTuple tuple = null;
            AlloyAtom atom = null;
            AlloyAtom leftAtom = null;
            AlloyAtom rightAtom = null;
            if (Visualization.rightClickedAnnotation instanceof AlloyAtom) {
              atom = (AlloyAtom) Visualization.rightClickedAnnotation;
            } else if (Visualization.rightClickedAnnotation instanceof AlloyTuple) {
              tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
              leftAtom = tuple.getStart();
              rightAtom = tuple.getEnd();

              try {
                final Field field = GraphViewer.class.getDeclaredField("selected");
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
            final boolean onAtom = atom != null;
            final boolean atomReasoned = onAtom && atom.isDashed;
            final boolean onRelation = tuple != null;
            final boolean relationReasoned = onRelation && tuple.isDashed;
            final boolean onEmptyArea = !onAtom && !onRelation;
            final boolean resolve =
                onRelation && leftAtom.changed && rightAtom.impacted.size() != 0;
            final boolean analysisActive = curState.equals(AnalysisState.ACTIVE.toString());
            final boolean hasSolution =
                Reasoning.getInstance().getCurrentSolution() != null
                || Discovering.getInstance().getCurrentSolution() != null
                || ReasoningForAtom.getInstance()
                .getCurrentSolution() != null;
            final boolean anyReasoned = AlloyUtilities.isAnyReasoned();

            Visualization.modelWriterMenu.setVisible(!atomReasoned || onRelation || onEmptyArea);
            ModelWriterMenuItems.addRemoveType.getItem().setVisible(onAtom);
            ModelWriterMenuItems.createNewAtom.getItem()
            .setVisible(onEmptyArea && !TraceManager.get().hasInstance());
            ModelWriterMenuItems.deleteAtom.getItem().setVisible(onAtom);
            ModelWriterMenuItems.mapping.getItem().setVisible(onAtom);
            ModelWriterMenuItems.removeRelation.getItem().setVisible(onRelation);
            ModelWriterMenuItems.resolve.getItem().setVisible(onAtom && atom.changed || resolve);
            ModelWriterMenuItems.createInstanceElement.getItem()
            .setVisible(onEmptyArea && TraceManager.get().hasInstance());

            Visualization.analysisMenu
            .setVisible(onAtom || onRelation && anyReasoned && relationReasoned || onEmptyArea);
            AnalysisMenuItems.validate.getItem().setVisible(onEmptyArea);
            AnalysisMenuItems.discoverRelation.getItem().setVisible(onEmptyArea && !analysisActive);
            AnalysisMenuItems.acceptReasonedRelation.getItem()
            .setVisible(relationReasoned && !TraceManager.get().hasInstance());
            AnalysisMenuItems.previousSolution.getItem()
            .setVisible(onEmptyArea && analysisActive && hasSolution);
            AnalysisMenuItems.nextSolution.getItem()
            .setVisible(onEmptyArea && analysisActive && hasSolution);
            AnalysisMenuItems.stopAnalysis.getItem().setVisible(onEmptyArea && analysisActive);
            AnalysisMenuItems.discoverAtom.getItem().setVisible(onEmptyArea && !analysisActive);
            AnalysisMenuItems.clearAllReasoned.getItem().setVisible(onEmptyArea && anyReasoned);
            AnalysisMenuItems.interpretAtom.getItem().setVisible(
                atomReasoned && !TraceManager.get().hasSigTrace(atom.getType().getName()));
            AnalysisMenuItems.interpretTracedAtom.getItem().setVisible(
                atomReasoned && TraceManager.get().hasSigTrace(atom.getType().getName()));
            AnalysisMenuItems.acceptTracedRelation.getItem()
            .setVisible(TraceManager.get().hasInstance() && relationReasoned);
            AnalysisMenuItems.acceptAllReasoned.getItem()
            .setVisible(TraceManager.get().hasInstance() && onEmptyArea && anyReasoned);
            AnalysisMenuItems.discoverRelationForAtom.getItem()
            .setVisible(onAtom && !analysisActive);

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
    } else {
      if (Visualization.frame == null) {
        Visualization.frame = SWT_AWT.new_Frame(Visualization.container);
      }
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

      JComponent frameInput;
      if (Visualization.evaluatorOpen) {
        final JSplitPane splitPane = new JSplitPane();
        splitPane.setRightComponent(Visualization.graph);
        splitPane.setLeftComponent(Visualization.evaluatorPanel);
        splitPane.setDividerLocation(400);
        Visualization.evaluatorPanel.requestFocusInWindow();
        Visualization.evaluatorPanel.setBorder(new OurBorder(false, false, false, false));

        frameInput = splitPane;
      } else {
        frameInput = Visualization.graph;
        Visualization.graph.requestFocusInWindow();
      }

      Visualization.frame.add(frameInput);
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

    Visualization.graph.alloyGetViewer().pop.add(Visualization.modelWriterMenu, 0);
    Visualization.graph.alloyGetViewer().pop.add(Visualization.analysisMenu, 1);
    Visualization.graph.alloyGetViewer().pop.add(Visualization.refreshMenuItem, 2);

    Visualization.graph.alloyGetViewer()
    .addMouseMotionListener(Visualization.getMouseMotionAdapter());
    Visualization.graphPanel.addMouseMotionListener(Visualization.getMouseMotionAdapter());
    Visualization.graph.alloyGetViewer().addMouseListener(Visualization.getMouseAdapter());
    Visualization.graphPanel.addMouseListener(Visualization.getMouseAdapter());
  }

  private static void createPopupMenu() {
    for (final ModelWriterMenuItems items : ModelWriterMenuItems.values()) {
      items.addToMenu(Visualization.modelWriterMenu);
    }

    for (final AnalysisMenuItems items : AnalysisMenuItems.values()) {
      items.addToMenu(Visualization.analysisMenu);
    }

    Visualization.refreshMenuItem
    .addActionListener(VisualizationActionListenerFactory.refreshActionListener());
    ModelWriterMenuItems.addRemoveType.getItem()
    .addActionListener(VisualizationActionListenerFactory.addRemoveTypeActionListener());
    ModelWriterMenuItems.createNewAtom.getItem()
    .addActionListener(VisualizationActionListenerFactory.createNewAtomActionListener());
    ModelWriterMenuItems.deleteAtom.getItem()
    .addActionListener(VisualizationActionListenerFactory.deleteAtomActionListener());
    ModelWriterMenuItems.mapping.getItem()
    .addActionListener(VisualizationActionListenerFactory.mappingActionListener());
    ModelWriterMenuItems.removeRelation.getItem()
    .addActionListener(VisualizationActionListenerFactory.removeRelationActionListener());
    ModelWriterMenuItems.resolve.getItem()
    .addActionListener(VisualizationActionListenerFactory.resolveActionListener());
    ModelWriterMenuItems.createInstanceElement.getItem().addActionListener(
        VisualizationActionListenerFactory.createInstanceElementActionListener());

    AnalysisMenuItems.validate.getItem()
    .addActionListener(VisualizationActionListenerFactory.validateActionListener());
    AnalysisMenuItems.discoverRelation.getItem()
    .addActionListener(VisualizationActionListenerFactory.discoverRelationActionListener());
    AnalysisMenuItems.acceptReasonedRelation.getItem().addActionListener(
        VisualizationActionListenerFactory.acceptReasonedRelationActionListener());
    AnalysisMenuItems.nextSolution.getItem()
    .addActionListener(VisualizationActionListenerFactory.nextSolutionActionListener());
    AnalysisMenuItems.previousSolution.getItem()
    .addActionListener(VisualizationActionListenerFactory.previousSolutionActionListener());
    AnalysisMenuItems.stopAnalysis.getItem()
    .addActionListener(VisualizationActionListenerFactory.stopAnalysisActionListener());
    AnalysisMenuItems.discoverAtom.getItem()
    .addActionListener(VisualizationActionListenerFactory.discoverAtomActionListener());
    AnalysisMenuItems.clearAllReasoned.getItem()
    .addActionListener(VisualizationActionListenerFactory.clearAllReasonedActionListener());
    AnalysisMenuItems.interpretAtom.getItem().addActionListener(
        VisualizationActionListenerFactory.interpretAtomMenuItemActionListener());
    AnalysisMenuItems.interpretTracedAtom.getItem().addActionListener(
        VisualizationActionListenerFactory.acceptAtomAsEMFMenuItemActionListener());
    AnalysisMenuItems.acceptTracedRelation.getItem().addActionListener(
        VisualizationActionListenerFactory.acceptRelationAsEMFMenuItemActionListener());
    AnalysisMenuItems.acceptAllReasoned.getItem()
    .addActionListener(VisualizationActionListenerFactory.acceptAllReasonedListener());
    AnalysisMenuItems.discoverRelationForAtom.getItem().addActionListener(
        VisualizationActionListenerFactory.discoverRelationForAtomActionListener());
  }

  @Override
  public void createPartControl(final Composite parent) {
    Visualization.container = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    Visualization.frame = null;
    Visualization.f = null;
    Visualization.graph = null;
    Visualization.myState = null;
    Visualization.evaluatorPanel = EvaluatorPanel.getInstance(Visualization.xmlFileName);
    Visualization.showViz();
    Visualization.createPopupMenu();
  }

  @Override
  public void setFocus() {}
}
