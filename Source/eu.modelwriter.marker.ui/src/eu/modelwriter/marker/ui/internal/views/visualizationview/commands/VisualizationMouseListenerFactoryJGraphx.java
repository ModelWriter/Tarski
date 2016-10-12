package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;
import javax.swing.JMenu;

import org.eclipse.core.resources.IMarker;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;

import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.discovery.AlloyNextSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolutionReasoning;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.internal.views.visualizationview.TraceabilityViewJGraphx;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VisualizationMouseListenerFactoryJGraphx {
  public static final VisualizationMouseListenerFactoryJGraphx instance =
      new VisualizationMouseListenerFactoryJGraphx();

  private VisualizationMouseListenerFactoryJGraphx() {}

  public MouseAdapter mouseAdapter() {
    return new MouseAdapter() {
      @Override
      public void mouseClicked(final MouseEvent e) {
        super.mouseClicked(e);
        if (e.getClickCount() > 1) {
          final Object annotation = TraceabilityViewJGraphx.graph.getComponentAt(e.getPoint());

          if (annotation instanceof mxCell) {
            if (((mxCell) annotation).isVertex()) {
              final IMarker marker = TraceabilityViewJGraphx.getMarker((mxCell) annotation);
              if (marker == null) {
                return;
              }
              MarkUtilities.focusMarker(marker);
            }
          }
        }
      }

      /**
       * when mouse exited from graph<br>
       * (not from AlloyAtom or not from AlloyTuple)
       */
      @Override
      public void mouseExited(final MouseEvent e) {
        TraceabilityViewJGraphx.frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        final Object annotation = TraceabilityViewJGraphx.graph.getComponentAt(e.getPoint());
        if (annotation == null) {
          final JMenu modelWriterMenu =
              (JMenu) TraceabilityViewJGraphx.graph.getComponentPopupMenu().getComponent(0);
          if (!modelWriterMenu.isShowing()) {
            modelWriterMenu.setVisible(false);
          }
        }
      }

      @Override
      public void mousePressed(final MouseEvent e) {
        switch (e.getButton()) {
          case MouseEvent.BUTTON3: // right click
            TraceabilityViewJGraphx.rightClickedAnnotation =
            TraceabilityViewJGraphx.graph.getComponentAt(e.getPoint());
            if (TraceabilityViewJGraphx.rightClickedAnnotation != null
                && TraceabilityViewJGraphx.rightClickedAnnotation instanceof mxCell) {
              TraceabilityViewJGraphx.modelWriterMenu.setVisible(true);
              final mxCell annotation = (mxCell) TraceabilityViewJGraphx.rightClickedAnnotation;
              if (annotation.isVertex()) {

                TraceabilityViewJGraphx.modelWriterMenu.getItem(0).setVisible(true);
                TraceabilityViewJGraphx.modelWriterMenu.getItem(1).setVisible(false);
                TraceabilityViewJGraphx.modelWriterMenu.getItem(2).setVisible(true);
                TraceabilityViewJGraphx.modelWriterMenu.getItem(3).setVisible(true);
                TraceabilityViewJGraphx.modelWriterMenu.getItem(4).setVisible(false);
                // if (atom.changed) {
                // TraceabilityViewJGraphx.modelWriterMenu.getItem(5).setVisible(true);
                // } else {
                // TraceabilityViewJGraphx.modelWriterMenu.getItem(5).setVisible(false);
                // }

                TraceabilityViewJGraphx.analysisMenu.getItem(0).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(1).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(2).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(3).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(4).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(5).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(6).setVisible(false);
                // if (atom.isDashed) {
                // TraceabilityViewJGraphx.analysisMenu.setVisible(true);
                // TraceabilityViewJGraphx.analysisMenu.getItem(7).setVisible(true);
                // TraceabilityViewJGraphx.modelWriterMenu.setVisible(false);
                // } else {
                // TraceabilityViewJGraphx.analysisMenu.setVisible(false);
                // TraceabilityViewJGraphx.analysisMenu.getItem(7).setVisible(false);
                // TraceabilityViewJGraphx.modelWriterMenu.setVisible(true);
                // }

              } else if (annotation.isEdge()) {
                //                final mxICell leftAtom = annotation.getSource();
                // final mxICell rightAtom = annotation.getTarget();

                TraceabilityViewJGraphx.modelWriterMenu.getItem(0).setVisible(false);
                TraceabilityViewJGraphx.modelWriterMenu.getItem(1).setVisible(false);
                TraceabilityViewJGraphx.modelWriterMenu.getItem(2).setVisible(false);
                TraceabilityViewJGraphx.modelWriterMenu.getItem(3).setVisible(false);
                TraceabilityViewJGraphx.modelWriterMenu.getItem(4).setVisible(true);
                //                if (leftAtom.changed && rightAtom.impacted.size() != 0) {
                //                  TraceabilityViewJGraphx.modelWriterMenu.getItem(5).setVisible(true);
                //                } else {
                //                  TraceabilityViewJGraphx.modelWriterMenu.getItem(5).setVisible(false);
                //                }

                TraceabilityViewJGraphx.analysisMenu.getItem(0).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(1).setVisible(false);
                //                if (tuple.isDashed) {
                //                  TraceabilityViewJGraphx.analysisMenu.setVisible(true);
                //                  TraceabilityViewJGraphx.analysisMenu.getItem(2).setVisible(true);
                //                } else {
                //                  TraceabilityViewJGraphx.analysisMenu.setVisible(false);
                //                  TraceabilityViewJGraphx.analysisMenu.getItem(2).setVisible(false);
                //                }
                TraceabilityViewJGraphx.analysisMenu.getItem(3).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(4).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(5).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(6).setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.getItem(7).setVisible(false);

                // Field field;
                // try {
                // field = GraphViewer.class.getDeclaredField("selected");
                // field.setAccessible(true);
                // if (field.get(TraceabilityViewJGraphx.graph) instanceof GraphEdge) {
                // final GraphEdge edge = (GraphEdge) field.get(TraceabilityViewJGraphx.graph);
                // // TODO attention!!
                // Visualization.relation = TraceabilityViewJGraphx.relation =
                // edge.group.toString().substring(0, edge.group.toString().indexOf(":") - 1);
                // }
                // } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                // | IllegalAccessException e1) {
                // e1.printStackTrace();
                // }
              } else {
                TraceabilityViewJGraphx.modelWriterMenu.setVisible(false);
                TraceabilityViewJGraphx.analysisMenu.setVisible(false);
              }
            } else {
              TraceabilityViewJGraphx.modelWriterMenu.setVisible(true);
              TraceabilityViewJGraphx.modelWriterMenu.getItem(0).setVisible(false);
              TraceabilityViewJGraphx.modelWriterMenu.getItem(1).setVisible(true);
              TraceabilityViewJGraphx.modelWriterMenu.getItem(2).setVisible(false);
              TraceabilityViewJGraphx.modelWriterMenu.getItem(3).setVisible(false);
              TraceabilityViewJGraphx.modelWriterMenu.getItem(4).setVisible(false);
              TraceabilityViewJGraphx.modelWriterMenu.getItem(5).setVisible(false);

              TraceabilityViewJGraphx.analysisMenu.setVisible(true);
              TraceabilityViewJGraphx.analysisMenu.getItem(0).setVisible(true);

              // TODO Attention !!!
              final Object curState = Visualization.sourceProvider.getCurrentState()
                  .get(AnalysisSourceProvider.ANALYSIS_STATE);

              // STATE MACHINE
              if (curState.equals(AnalysisSourceProvider.ACTIVE)) {
                TraceabilityViewJGraphx.analysisMenu.getItem(1).setVisible(false); // reason
                TraceabilityViewJGraphx.analysisMenu.getItem(5).setVisible(false); // discover

                if (AlloyNextSolutionReasoning.getInstance().getAns() != null
                    || AlloyNextSolutionDiscovering.getInstance().getAns() != null) {
                  TraceabilityViewJGraphx.analysisMenu.getItem(3).setVisible(true); // next
                  TraceabilityViewJGraphx.analysisMenu.getItem(4).setVisible(true); // stop
                } else {
                  TraceabilityViewJGraphx.analysisMenu.getItem(3).setVisible(false); // next
                  TraceabilityViewJGraphx.analysisMenu.getItem(4).setVisible(false); // stop
                }
              } else if (curState.equals(AnalysisSourceProvider.PASSIVE)) {
                TraceabilityViewJGraphx.analysisMenu.getItem(1).setVisible(true); // reason
                TraceabilityViewJGraphx.analysisMenu.getItem(5).setVisible(true); // discover

                TraceabilityViewJGraphx.analysisMenu.getItem(3).setVisible(false); // next
                TraceabilityViewJGraphx.analysisMenu.getItem(4).setVisible(false); // stop
              }

              TraceabilityViewJGraphx.analysisMenu.getItem(2).setVisible(false);

              // if (AlloyUtilities.isAnyReasoned()) {
              // TraceabilityViewJGraphx.analysisMenu.getItem(6).setVisible(true);
              // } else {
              // TraceabilityViewJGraphx.analysisMenu.getItem(6).setVisible(false);
              // }
              TraceabilityViewJGraphx.analysisMenu.getItem(7).setVisible(false);
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
        final Object annotation = TraceabilityViewJGraphx.graph.getComponentAt(e.getPoint());
        final JComponent cmpnt = (JComponent) e.getComponent();
        String tooltip = null;

        if (annotation instanceof mxCell) {
          if (((mxCell) annotation).isVertex()) {
            final IMarker marker = TraceabilityViewJGraphx.getMarker((mxCell) annotation);
            if (marker == null) {
              return;
            }

            TraceabilityViewJGraphx.frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
            tooltip = MarkUtilities.getText(marker);
          } else {
            final mxICell highLightedAtomStart = ((mxCell) annotation).getSource();
            final mxICell highLightedAtomEnd = ((mxCell) annotation).getTarget();

            final IMarker markerStart = TraceabilityViewJGraphx.getMarker(highLightedAtomStart);
            final IMarker markerEnd = TraceabilityViewJGraphx.getMarker(highLightedAtomEnd);

            if (markerStart == null || markerEnd == null) {
              return;
            }

            tooltip =
                MarkUtilities.getText(markerStart) + " --> " + MarkUtilities.getText(markerEnd);
            TraceabilityViewJGraphx.frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
          }
        } else {
          /**
           * when mouse exited from AlloyAtom or from AlloyTuple
           */
          TraceabilityViewJGraphx.frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        cmpnt.setToolTipText(tooltip);
      }
    };
  }
}
