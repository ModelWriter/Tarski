package eu.modelwriter.marker.ui.internal.views.visualizationview;

import java.awt.Cursor;
import java.awt.Frame;
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
import eu.modelwriter.configuration.alloy.discovery.AlloyNextSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolutionReasoning;
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
  private static JMenu modelWriterMenu;
  private static JMenu analysisMenu;
  private static File f = null;
  public static Object rightClickedAnnotation;
  final static String xmlFileName = Util.canon(AlloyUtilities.getLocation());
  public static Composite container;
  public static AnalysisSourceProvider sourceProvider;
  public static String relation;

  public static IMarker getMarker(final AlloyAtom highLightedAtom) {
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
            Visualization.rightClickedAnnotation =
            Visualization.viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
            if (Visualization.rightClickedAnnotation != null) {
              Visualization.modelWriterMenu.setVisible(true);
              if (Visualization.rightClickedAnnotation instanceof AlloyAtom) {
                final AlloyAtom atom = (AlloyAtom) Visualization.rightClickedAnnotation;

                Visualization.modelWriterMenu.getItem(0).setVisible(true);
                Visualization.modelWriterMenu.getItem(1).setVisible(false);
                Visualization.modelWriterMenu.getItem(2).setVisible(true);
                Visualization.modelWriterMenu.getItem(3).setVisible(true);
                Visualization.modelWriterMenu.getItem(4).setVisible(false);
                if (atom.changed) {
                  Visualization.modelWriterMenu.getItem(5).setVisible(true);
                } else {
                  Visualization.modelWriterMenu.getItem(5).setVisible(false);
                }

                Visualization.analysisMenu.getItem(0).setVisible(false);
                Visualization.analysisMenu.getItem(1).setVisible(false);
                Visualization.analysisMenu.getItem(2).setVisible(false);
                Visualization.analysisMenu.getItem(3).setVisible(false);
                Visualization.analysisMenu.getItem(4).setVisible(false);
                Visualization.analysisMenu.getItem(5).setVisible(false);
                Visualization.analysisMenu.getItem(6).setVisible(false);
                if (atom.isDashed) {
                  Visualization.analysisMenu.setVisible(true);
                  Visualization.analysisMenu.getItem(7).setVisible(true);
                  Visualization.modelWriterMenu.setVisible(false);
                } else {
                  Visualization.analysisMenu.setVisible(false);
                  Visualization.analysisMenu.getItem(7).setVisible(false);
                  Visualization.modelWriterMenu.setVisible(true);
                }

              } else if (Visualization.rightClickedAnnotation instanceof AlloyTuple) {
                final AlloyTuple tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
                final AlloyAtom leftAtom = tuple.getStart();
                final AlloyAtom rightAtom = tuple.getEnd();

                Visualization.modelWriterMenu.getItem(0).setVisible(false);
                Visualization.modelWriterMenu.getItem(1).setVisible(false);
                Visualization.modelWriterMenu.getItem(2).setVisible(false);
                Visualization.modelWriterMenu.getItem(3).setVisible(false);
                Visualization.modelWriterMenu.getItem(4).setVisible(true);
                if (leftAtom.changed && rightAtom.impacted.size() != 0) {
                  Visualization.modelWriterMenu.getItem(5).setVisible(true);
                } else {
                  Visualization.modelWriterMenu.getItem(5).setVisible(false);
                }

                Visualization.analysisMenu.getItem(0).setVisible(false);
                Visualization.analysisMenu.getItem(1).setVisible(false);
                if (tuple.isDashed) {
                  Visualization.analysisMenu.setVisible(true);
                  Visualization.analysisMenu.getItem(2).setVisible(true);
                } else {
                  Visualization.analysisMenu.setVisible(false);
                  Visualization.analysisMenu.getItem(2).setVisible(false);
                }
                Visualization.analysisMenu.getItem(3).setVisible(false);
                Visualization.analysisMenu.getItem(4).setVisible(false);
                Visualization.analysisMenu.getItem(5).setVisible(false);
                Visualization.analysisMenu.getItem(6).setVisible(false);
                Visualization.analysisMenu.getItem(7).setVisible(false);

                Field field;
                try {
                  field = GraphViewer.class.getDeclaredField("selected");
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
              } else {
                Visualization.modelWriterMenu.setVisible(false);
                Visualization.analysisMenu.setVisible(false);
              }
            } else {
              Visualization.modelWriterMenu.setVisible(true);
              Visualization.modelWriterMenu.getItem(0).setVisible(false);
              Visualization.modelWriterMenu.getItem(1).setVisible(true);
              Visualization.modelWriterMenu.getItem(2).setVisible(false);
              Visualization.modelWriterMenu.getItem(3).setVisible(false);
              Visualization.modelWriterMenu.getItem(4).setVisible(false);
              Visualization.modelWriterMenu.getItem(5).setVisible(false);

              Visualization.analysisMenu.setVisible(true);
              Visualization.analysisMenu.getItem(0).setVisible(true);

              final Object curState = Visualization.sourceProvider.getCurrentState()
                  .get(AnalysisSourceProvider.ANALYSIS_STATE);

              // STATE MACHINE
              if (curState.equals(AnalysisSourceProvider.ACTIVE)) {
                Visualization.analysisMenu.getItem(1).setVisible(false); // reason
                Visualization.analysisMenu.getItem(5).setVisible(false); // discover

                if (AlloyNextSolutionReasoning.getInstance().getAns() != null
                    || AlloyNextSolutionDiscovering.getInstance().getAns() != null) {
                  Visualization.analysisMenu.getItem(3).setVisible(true); // next
                  Visualization.analysisMenu.getItem(4).setVisible(true); // stop
                } else {
                  Visualization.analysisMenu.getItem(3).setVisible(false); // next
                  Visualization.analysisMenu.getItem(4).setVisible(false); // stop
                }
              } else if (curState.equals(AnalysisSourceProvider.PASSIVE)) {
                Visualization.analysisMenu.getItem(1).setVisible(true); // reason
                Visualization.analysisMenu.getItem(5).setVisible(true); // discover

                Visualization.analysisMenu.getItem(3).setVisible(false); // next
                Visualization.analysisMenu.getItem(4).setVisible(false); // stop
              }

              Visualization.analysisMenu.getItem(2).setVisible(false);

              if (AlloyUtilities.isAnyReasoned()) {
                Visualization.analysisMenu.getItem(6).setVisible(true);
              } else {
                Visualization.analysisMenu.getItem(6).setVisible(false);
              }
              Visualization.analysisMenu.getItem(7).setVisible(false);
            }

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
        final Object annotation = Visualization.viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
        final JComponent cmpnt = (JComponent) e.getComponent();
        String tooltip = null;

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

          tooltip = MarkUtilities.getText(markerStart) + " --> " + MarkUtilities.getText(markerEnd);
          Visualization.frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
          /**
           * when mouse exited from AlloyAtom or from AlloyTuple
           */
          Visualization.frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        cmpnt.setToolTipText(tooltip);
      }
    };
  }

  public static void showViz() {
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

    Visualization.createPopupMenu();


    Visualization.graph.alloyGetViewer()
    .addMouseMotionListener(Visualization.getMouseMotionAdapter());
    Visualization.graphPanel.addMouseMotionListener(Visualization.getMouseMotionAdapter());
    Visualization.graph.alloyGetViewer().addMouseListener(Visualization.getMouseAdapter());
    Visualization.graphPanel.addMouseListener(Visualization.getMouseAdapter());
  }

  private static void createPopupMenu() {
    final JMenu modelWriterMenu = Visualization.modelWriterMenu = new JMenu("Management");
    Visualization.graph.alloyGetViewer().pop.add(modelWriterMenu, 0);

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
    Visualization.graph.alloyGetViewer().pop.add(analysisMenu, 1);

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
    Visualization.graph.alloyGetViewer().pop.add(refreshMenuItem, 2);

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
    stopAnalysis.addActionListener(VisualizationActionListenerFactory.stopAnalysisActionListener());
    clearAllReasoned
    .addActionListener(VisualizationActionListenerFactory.clearAllReasonedActionListener());
    interpretAtomMenuItem.addActionListener(
        VisualizationActionListenerFactory.interpretAtomMenuItemActionListener());
  }

  @Override
  public void createPartControl(final Composite parent) {
    Visualization.container = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    Visualization.frame = null;
    Visualization.f = null;
    Visualization.graph = null;
    Visualization.myState = null;
    Visualization.showViz();
  }

  @Override
  public void setFocus() {}
}
