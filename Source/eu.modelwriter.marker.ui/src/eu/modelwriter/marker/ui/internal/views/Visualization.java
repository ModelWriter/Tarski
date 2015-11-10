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
import java.util.ArrayList;
import java.util.Iterator;

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
import org.eclipse.jface.wizard.WizardDialog;
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
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard.CreatingAtomWizard;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

public class Visualization extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.visualizationview";
  private static VizState myState = null;
  private static VizGraphPanel graph;
  private static Frame frame;
  private static File f = null;
  private static Object rightClickedAnnotation;

  final static String xmlFileName = Util.canon(AlloyUtilities.getLocation());

  public static Composite container;

  static String relation;

  private static ActionListener createActionListenerByCommand(final String commandId) {
    final ActionListener acl = new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        MarkUtilities
            .focusMarker(Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation));

        Display.getDefault().syncExec(new Runnable() {

          @Override
          public void run() {
            final IServiceLocator serviceLocator = PlatformUI.getWorkbench();
            final ICommandService commandService = serviceLocator.getService(ICommandService.class);

            try {
              final Command command = commandService.getCommand(commandId);
              command.executeWithChecks(new ExecutionEvent());
            } catch (ExecutionException | NotDefinedException | NotEnabledException
                | NotHandledException e1) {
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

  private static IMarker getMarker(final AlloyAtom highLightedAtom) {

    final String atomType = highLightedAtom.getType().getName();
    final String stringIndex = highLightedAtom.toString().substring(atomType.length());
    int index = 0;
    if (!stringIndex.isEmpty()) {
      index = Integer.parseInt(stringIndex);
    }

    final IMarker marker = AlloyUtilities.findMarker(atomType, index);

    return marker;
  }

  protected static void removeRelation() {
    if (Visualization.container == null) {
      return;
    }
    final AlloyTuple tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
    final AlloyAtom fromAtom = tuple.getStart();
    final AlloyAtom toAtom = tuple.getEnd();
    final IMarker fromMarker = Visualization.getMarker(fromAtom);
    final IMarker toMarker = Visualization.getMarker(toAtom);
    AlloyUtilities.removeFieldOfMarkers(fromMarker, toMarker, Visualization.relation);
    MappingWizard.convertAnnotationType(fromMarker, false, false);
  }

  public static void showViz(final Composite container) {
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
      final AlloyInstance instance = StaticInstanceReader.parseInstance(Visualization.f);

      final Iterator<AlloyAtom> iter = instance.atom2sets.keySet().iterator();

      final ArrayList<String> changedAtoms = AlloyUtilities.getChangedAtoms();
      final ArrayList<String> impactedAtoms = AlloyUtilities.getImpactedAtoms();
      while (iter.hasNext()) {
        final AlloyAtom alloyAtom = iter.next();
        final String alloyAtomName = alloyAtom.getOriginalName();
        if (changedAtoms.contains(alloyAtomName)) {
          alloyAtom.changed = true;
        }
        if (impactedAtoms.contains(alloyAtomName)) {
          alloyAtom.impacted = true;
        }
      }

      Visualization.myState = new VizState(instance);// YANLIS

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

    } catch (final Err e1) {
      e1.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }

    final JMenu modelWriterMenu = new JMenu("ModelWriter");
    final JMenuItem refreshMenuItem = new JMenuItem("Refresh");
    final JMenuItem deleteMarkerMenuItem = new JMenuItem("Delete Marker");
    final JMenuItem addRemoveTypeMenuItem = new JMenuItem("Add/Remove Type");
    final JMenuItem removeRelationMenuItem = new JMenuItem("Remove Relation");
    final JMenuItem mapMarkerMenuItem = new JMenuItem("Map Marker");
    final JMenuItem createNewAtomMenuItem = new JMenuItem("Create New Atom");
    final JMenuItem resolveMenuItem = new JMenuItem("Resolve");
    final JMenuItem validateMenuItem = new JMenuItem("Validate");

    Visualization.graph.alloyGetViewer().pop.add(modelWriterMenu, 0);
    Visualization.graph.alloyGetViewer().pop.add(validateMenuItem, 1);
    Visualization.graph.alloyGetViewer().pop.add(refreshMenuItem, 2);

    modelWriterMenu.add(addRemoveTypeMenuItem, 0);
    modelWriterMenu.add(createNewAtomMenuItem, 1);
    modelWriterMenu.add(deleteMarkerMenuItem, 2);
    modelWriterMenu.add(mapMarkerMenuItem, 3);
    modelWriterMenu.add(removeRelationMenuItem, 4);
    modelWriterMenu.add(resolveMenuItem, 5);

    deleteMarkerMenuItem.addActionListener(
        Visualization.createActionListenerByCommand("eu.modelwriter.marker.command.delete"));
    addRemoveTypeMenuItem.addActionListener(
        Visualization.createActionListenerByCommand("eu.modelwriter.marker.command.addremovetype"));
    mapMarkerMenuItem.addActionListener(
        Visualization.createActionListenerByCommand("eu.modelwriter.marker.command.map"));

    refreshMenuItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        Visualization.showViz(Visualization.container);
      }
    });

    removeRelationMenuItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        Visualization.removeRelation();
        Visualization.showViz(Visualization.container);
      }
    });

    createNewAtomMenuItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent arg0) {
        this.createNewAtom();
        Visualization.showViz(Visualization.container);
      }

      private void createNewAtom() {
        Display.getDefault().syncExec(new Runnable() {

          @Override
          public void run() {
            final CreatingAtomWizard wizard = new CreatingAtomWizard();
            final WizardDialog dialog = new WizardDialog(
                Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getShell(), wizard);
            dialog.open();
          }
        });
      }
    });

    resolveMenuItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        if (Visualization.container == null) {
          return;
        }
        final AlloyTuple tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
        final AlloyAtom fromAtom = tuple.getStart();
        final AlloyAtom toAtom = tuple.getEnd();
        AlloyUtilities.unsetImpactAndChanged(Visualization.getMarker(fromAtom),
            Visualization.getMarker(toAtom));
        Visualization.showViz(Visualization.container);
      }
    });

    Visualization.graph.alloyGetViewer().addMouseMotionListener(new MouseMotionAdapter() {

      @Override
      public void mouseMoved(final MouseEvent e) {
        final GraphViewer viewer = (GraphViewer) e.getSource();
        final Object annotation = viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
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
          if (!viewer.pop.isShowing()) {
            modelWriterMenu.setVisible(false);
          }
        }
        cmpnt.setToolTipText(tooltip);
      }
    });

    Visualization.graph.alloyGetViewer().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(final MouseEvent e) {
        super.mouseClicked(e);
        if (e.getClickCount() > 1) {
          final GraphViewer viewer = (GraphViewer) e.getSource();
          final Object annotation = viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());

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
        final GraphViewer viewer = (GraphViewer) e.getSource();
        final Object annotation = viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
        if (annotation == null) {
          final JMenu modelWriterMenu = (JMenu) viewer.pop.getComponent(0);
          if (!viewer.pop.isShowing()) {
            modelWriterMenu.setVisible(false);
          }
        }
      }

      @Override
      public void mousePressed(final MouseEvent e) {
        final GraphViewer viewer = (GraphViewer) e.getSource();
        final JMenu modelWriterMenu = (JMenu) viewer.pop.getComponent(0);
        switch (e.getButton()) {
          case MouseEvent.BUTTON3: // right click
            Visualization.rightClickedAnnotation =
                viewer.alloyGetAnnotationAtXY(e.getX(), e.getY());
            if (Visualization.rightClickedAnnotation == null) {
              modelWriterMenu.setVisible(true);
              modelWriterMenu.getItem(0).setVisible(false);
              modelWriterMenu.getItem(1).setVisible(true);
              modelWriterMenu.getItem(2).setVisible(false);
              modelWriterMenu.getItem(3).setVisible(false);
              modelWriterMenu.getItem(4).setVisible(false);
              modelWriterMenu.getItem(5).setVisible(false);
            } else {
              modelWriterMenu.setVisible(true);
              if (Visualization.rightClickedAnnotation instanceof AlloyAtom) {
                modelWriterMenu.getItem(0).setVisible(true);
                modelWriterMenu.getItem(1).setVisible(false);
                modelWriterMenu.getItem(2).setVisible(true);
                modelWriterMenu.getItem(3).setVisible(true);
                modelWriterMenu.getItem(4).setVisible(false);
                modelWriterMenu.getItem(5).setVisible(false);
              } else if (Visualization.rightClickedAnnotation instanceof AlloyTuple) {
                modelWriterMenu.getItem(0).setVisible(false);
                modelWriterMenu.getItem(1).setVisible(false);
                modelWriterMenu.getItem(2).setVisible(false);
                modelWriterMenu.getItem(3).setVisible(false);
                modelWriterMenu.getItem(4).setVisible(true);
                modelWriterMenu.getItem(5).setVisible(true);

                Field field;
                try {
                  field = GraphViewer.class.getDeclaredField("selected");
                  field.setAccessible(true);
                  if (field.get(viewer) instanceof GraphEdge) {
                    final GraphEdge edge = (GraphEdge) field.get(viewer);
                    Visualization.relation = edge.label();
                  }
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
  public void createPartControl(final Composite parent) {
    Visualization.container = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    Visualization.showViz(Visualization.container);
  }

  @Override
  public void setFocus() {}
}
