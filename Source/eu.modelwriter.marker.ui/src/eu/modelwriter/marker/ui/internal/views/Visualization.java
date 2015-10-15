package eu.modelwriter.marker.ui.internal.views;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.services.IServiceLocator;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4graph.GraphEdge;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

public class Visualization extends ViewPart {

  private static VizState myState = null;
  private static VizGraphPanel graph;
  private static Frame frame;
  private static File f = null;
  private static Object rightClickedAnnotation;

  final static String xmlFileName = Util.canon(AlloyUtilities.getLocation());

  public static Composite container;

  static String relation;

  private static ActionListener createActionListenerByCommand(String commandId) {
    ActionListener acl = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MarkUtilities
            .focusMarker(Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation));

        Display.getDefault().syncExec(new Runnable() {

          @Override
          public void run() {
            IServiceLocator serviceLocator = PlatformUI.getWorkbench();

            ICommandService commandService = serviceLocator.getService(ICommandService.class);

            try {
              Command command = commandService.getCommand(commandId);

              // Optionally pass a ExecutionEvent instance, default no-param arg creates blank
              // event
              command.executeWithChecks(new ExecutionEvent());

            } catch (ExecutionException | NotDefinedException | NotEnabledException
                | NotHandledException e1) {
              // Replace with real-world exception handling
              e1.printStackTrace();
            }
          }
        });
        Visualization.showViz(Visualization.container);
        Visualization.rightClickedAnnotation = null;
      }
    };
    return acl;
  }

  private static IMarker getMarker(AlloyAtom highLightedAtom) {

    String atomType = highLightedAtom.getType().getName();
    String stringIndex = highLightedAtom.toString().substring(atomType.length());
    int index = 0;
    if (!stringIndex.isEmpty()) {
      index = Integer.parseInt(stringIndex);
    }

    IMarker marker = AlloyUtilities.findMarker(atomType, index);

    return marker;
  }

  protected static void removeRelation() {
    if (container == null) {
      return;
    }
    AlloyTuple tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
    AlloyAtom fromAtom = tuple.getStart();
    AlloyAtom toAtom = tuple.getEnd();
    IMarker fromMarker = getMarker(fromAtom);
    IMarker toMarker = getMarker(toAtom);
    AlloyUtilities.removeFieldOfMarkers(fromMarker, toMarker, relation);
    MappingWizard.convertAnnotationType(fromMarker, false, false);
  }

  public static void showViz(Composite container) {
    if (container == null) {
      return;
    }
    if (!AlloyUtilities.isExists()) {
      if (Visualization.frame != null) {
        if (Visualization.frame.getComponentCount() <= 0) {
          Visualization.frame.removeAll();
        }
        Visualization.frame.add(new JPanel());
      } else if (Visualization.frame == null) {
        Visualization.frame = SWT_AWT.new_Frame(container);
        Visualization.frame.add(new JPanel());
      }
      return;
    }
    Visualization.f = new File(Visualization.xmlFileName);
    try {
      if (!Visualization.f.exists()) {
        throw new IOException("File " + Visualization.xmlFileName + " does not exist.");
      }

      Visualization.myState = new VizState(StaticInstanceReader.parseInstance(Visualization.f));

      if (Visualization.frame == null) {
        Visualization.frame = SWT_AWT.new_Frame(container);
      }

      if (Visualization.graph != null && Visualization.frame.getComponent(0) != null) {
        Visualization.frame.remove(Visualization.graph);
      }

      Visualization.graph = new VizGraphPanel(Visualization.myState, false);
      Visualization.frame.add(Visualization.graph);
      Visualization.frame.setVisible(true);
      Visualization.frame.setAlwaysOnTop(true);
      Visualization.graph.alloyGetViewer().alloyRepaint();

    } catch (Err e1) {
      e1.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    JMenu modelWriterMenu = new JMenu("ModelWriter");
    JMenuItem refreshMenuItem = new JMenuItem("Refresh");
    JMenuItem deleteMarkerMenuItem = new JMenuItem("Delete Marker");
    JMenuItem addRemoveTypeMenuItem = new JMenuItem("Add/Remove Type");
    JMenuItem removeRelationMenuItem = new JMenuItem("Remove Relation");
    JMenuItem mapMarkerMenuItem = new JMenuItem("Map Marker");

    Visualization.graph.alloyGetViewer().pop.add(modelWriterMenu, 0);
    Visualization.graph.alloyGetViewer().pop.add(refreshMenuItem, 1);

    modelWriterMenu.add(deleteMarkerMenuItem, 0);
    modelWriterMenu.add(addRemoveTypeMenuItem, 1);
    modelWriterMenu.add(removeRelationMenuItem, 2);
    modelWriterMenu.add(mapMarkerMenuItem, 3);

    deleteMarkerMenuItem.addActionListener(
        Visualization.createActionListenerByCommand("eu.modelwriter.marker.command.delete"));
    addRemoveTypeMenuItem.addActionListener(
        Visualization.createActionListenerByCommand("eu.modelwriter.marker.command.addremovetype"));
    mapMarkerMenuItem.addActionListener(
        Visualization.createActionListenerByCommand("eu.modelwriter.marker.command.map"));

    refreshMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Visualization.showViz(Visualization.container);
      }
    });

    removeRelationMenuItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        Visualization.removeRelation();
        Visualization.showViz(Visualization.container);
      }
    });

    Visualization.graph.alloyGetViewer().addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        GraphViewer viewer = (GraphViewer) e.getSource();
        Object annotation = viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
        JComponent cmpnt = (JComponent) e.getComponent();
        String tooltip = null;

        if (annotation instanceof AlloyAtom) {
          IMarker marker = Visualization.getMarker((AlloyAtom) annotation);
          if (marker == null) {
            return;
          }

          Visualization.frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
          tooltip = MarkUtilities.getText(marker);
        } else if (annotation instanceof AlloyTuple) {
          AlloyTuple tuple = (AlloyTuple) annotation;

          AlloyAtom highLightedAtomStart = tuple.getStart();
          AlloyAtom highLightedAtomEnd = tuple.getEnd();

          IMarker markerStart = Visualization.getMarker(highLightedAtomStart);
          IMarker markerEnd = Visualization.getMarker(highLightedAtomEnd);

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
          if (!viewer.pop.isShowing()) {
            modelWriterMenu.setVisible(false);
          }
        }
        cmpnt.setToolTipText(tooltip);
      }
    });

    Visualization.graph.alloyGetViewer().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (e.getClickCount() > 1) {
          GraphViewer viewer = (GraphViewer) e.getSource();
          Object annotation = viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());

          if (annotation instanceof AlloyAtom) {
            IMarker marker = Visualization.getMarker((AlloyAtom) annotation);
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
      public void mouseExited(MouseEvent e) {
        Visualization.frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        GraphViewer viewer = (GraphViewer) e.getSource();
        Object annotation = viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
        if (annotation == null) {
          JMenu modelWriterMenu = (JMenu) viewer.pop.getComponent(0);
          if (!viewer.pop.isShowing()) {
            modelWriterMenu.setVisible(false);
          }
        }
      }

      @Override
      public void mousePressed(MouseEvent e) {
        GraphViewer viewer = (GraphViewer) e.getSource();
        JMenu modelWriterMenu = (JMenu) viewer.pop.getComponent(0);
        switch (e.getButton()) {
          case MouseEvent.BUTTON3: // right click
            Visualization.rightClickedAnnotation =
                viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
            if (Visualization.rightClickedAnnotation == null) {
              modelWriterMenu.setVisible(false);
            } else {
              modelWriterMenu.setVisible(true);
              if (Visualization.rightClickedAnnotation instanceof AlloyAtom) {
                modelWriterMenu.getItem(0).setVisible(true);
                modelWriterMenu.getItem(1).setVisible(true);
                modelWriterMenu.getItem(2).setVisible(false);
                modelWriterMenu.getItem(3).setVisible(true);
              } else if (Visualization.rightClickedAnnotation instanceof AlloyTuple) {
                modelWriterMenu.getItem(0).setVisible(false);
                modelWriterMenu.getItem(1).setVisible(false);
                modelWriterMenu.getItem(2).setVisible(true);
                modelWriterMenu.getItem(3).setVisible(false);

                Field field;
                try {
                  field = GraphViewer.class.getDeclaredField("selected");
                  field.setAccessible(true);
                  GraphEdge edge = (GraphEdge) field.get(viewer);
                  Visualization.relation = edge.label();
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                    | IllegalAccessException e1) {
                  e1.printStackTrace();
                }
              }
            }
          default:
            break;
        }
      }
    });
  }

  @Override
  public void createPartControl(Composite parent) {
    Visualization.container = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    Visualization.showViz(Visualization.container);
  }

  @Override
  public void setFocus() {}
}
