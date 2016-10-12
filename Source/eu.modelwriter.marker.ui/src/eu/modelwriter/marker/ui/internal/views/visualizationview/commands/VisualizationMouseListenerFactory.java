package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.Field;

import javax.swing.JComponent;
import javax.swing.JMenu;

import org.eclipse.core.resources.IMarker;

import edu.mit.csail.sdg.alloy4graph.GraphEdge;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.discovery.AlloyNextSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolutionReasoning;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VisualizationMouseListenerFactory {
  public static final VisualizationMouseListenerFactory instance =
      new VisualizationMouseListenerFactory();

  private VisualizationMouseListenerFactory() {}

  public MouseAdapter mouseAdapter() {
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

  public MouseMotionAdapter mouseMotionAdapter() {
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
}
