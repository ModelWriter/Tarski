/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.kodkod.visualization;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4graph.Graph;
import edu.mit.csail.sdg.alloy4graph.GraphEdge;
import edu.mit.csail.sdg.alloy4graph.GraphNode;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyRelation;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.kodkod.visualization.model.Universe;
import eu.modelwriter.kodkod.visualization.wizards.createatom.CreateAtom;
import eu.modelwriter.kodkod.visualization.wizards.mapping.MappingWizard;

public class Visualization {

  private static Visualization visualization;

  public static Visualization getInstance() {
    if (Visualization.visualization == null) {
      Visualization.visualization = new Visualization(null, XmlCreator.xmlfile);
    }

    return Visualization.visualization;
  }

  public static Visualization getInstance(final String xmlFile) {
    if (Visualization.visualization == null) {
      Visualization.visualization = new Visualization(null, xmlFile);
    } else if (xmlFile != null) {
      Visualization.visualization.setUniverse(null, xmlFile);
    }

    return Visualization.visualization;
  }

  public static Visualization getInstance(final Universe universe, final String xmlFile) {
    if (Visualization.visualization == null) {
      Visualization.visualization = new Visualization(universe, xmlFile);
    } else if (universe != null) {
      Visualization.visualization.setUniverse(universe, xmlFile);
    }

    return Visualization.visualization;
  }

  private String xmlfile;
  private Universe universe;
  private XmlCreator xmlCreator;
  private List<Notifier> notifierList;
  private VizGraphPanel graph;
  private JFrame frame;
  private JMenu universeMenu;
  private Object rightClickedAnnotation;
  private String relation;
  private final JPanel graphInPanel;
  private final JMenuBar menuBar;

  private final JToggleButton lowerButton;

  private final JToggleButton upperButton;

  private boolean isLower;

  private Visualization(final Universe universe, final String xmlFile) {
    notifierList = new ArrayList<>();
    graphInPanel = new JPanel();
    graphInPanel.setLayout(new BorderLayout());

    menuBar = new JMenuBar();
    lowerButton = new JToggleButton("Lower Edit Mode");
    lowerButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        final AbstractButton abstractButton = (AbstractButton) e.getSource();
        final boolean selected = abstractButton.getModel().isSelected();
        upperButton.setSelected(!selected);
        isLower = selected;
      }
    });
    upperButton = new JToggleButton("Upper Edit Mode");
    upperButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        final AbstractButton abstractButton = (AbstractButton) e.getSource();
        final boolean selected = abstractButton.getModel().isSelected();
        lowerButton.setSelected(!selected);
        isLower = !selected;
      }
    });
    menuBar.add(lowerButton);
    menuBar.add(upperButton);
    graphInPanel.add(menuBar, BorderLayout.SOUTH);

    upperButton.setSelected(true);
    isLower = false;

    setUniverse(universe, xmlFile);
  }

  private void addMouseListener() {
    graph.alloyGetViewer().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(final MouseEvent e) {
        super.mouseClicked(e);
        final Object annotation =
            graph.alloyGetViewer().alloyGetAnnotationAtXY(e.getX(), e.getY());
        if (annotation instanceof AlloyAtom) {
          final AlloyAtom alloyAtom = (AlloyAtom) annotation;

          final String atomType = alloyAtom.getType().getName();
          final String stringIndex = alloyAtom.toString().substring(atomType.length());
          int index = 0;
          if (!stringIndex.isEmpty()) {
            index = Integer.parseInt(stringIndex);
          }
          final String serilizatedData = Utility.getDataOfAtom(atomType, index);
          if (serilizatedData == null) {
            return;
          }
          Serializable deSerilizatedData = null;
          try {
            deSerilizatedData = Serialization.getInstance().fromString(serilizatedData);
          } catch (ClassNotFoundException | IOException e1) {
            e1.printStackTrace();
          }
          for (final Notifier notifier : notifierList) {
            notifier.notify(deSerilizatedData);
          }
        }
      }

      @Override
      public void mousePressed(final MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
          rightClickedAnnotation =
              graph.alloyGetViewer().alloyGetAnnotationAtXY(e.getX(), e.getY());

          Field field;
          try {
            field = GraphViewer.class.getDeclaredField("selected");
            field.setAccessible(true);
            if (field.get(graph.alloyGetViewer()) instanceof GraphEdge) {
              final GraphEdge edge =
                  (GraphEdge) field.get(graph.alloyGetViewer());
              relation =
                  edge.group.toString().substring(0, edge.group.toString().indexOf(":") - 1);
            }
          } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
              | IllegalAccessException e1) {
            e1.printStackTrace();
          }

          if (rightClickedAnnotation == null) {
            universeMenu.setVisible(true);
            universeMenu.getItem(0).setVisible(true);
            universeMenu.getItem(1).setVisible(false);
            universeMenu.getItem(2).setVisible(false);
            universeMenu.getItem(3).setVisible(false);
            universeMenu.getItem(4).setVisible(false);
            universeMenu.getItem(5).setVisible(false);
            universeMenu.getItem(6).setVisible(false);
          } else {
            universeMenu.setVisible(true);
            if (rightClickedAnnotation instanceof AlloyAtom) {
              universeMenu.getItem(0).setVisible(false);
              universeMenu.getItem(1).setVisible(true);
              universeMenu.getItem(3).setVisible(false);
              universeMenu.getItem(4).setVisible(true);

              final AlloyAtom alloyAtom = (AlloyAtom) rightClickedAnnotation;
              final String bound = Utility.getBoundOfAtomType(alloyAtom);

              if (bound != null) {
                if (bound.equals("lower")) {
                  universeMenu.getItem(5).setVisible(false);
                  universeMenu.getItem(6).setVisible(true);
                  if (!isLower) {
                    universeMenu.getItem(2).setVisible(false);
                  } else {
                    universeMenu.getItem(2).setVisible(true);
                  }
                } else if (bound.equals("upper")) {
                  universeMenu.getItem(5).setVisible(true);
                  universeMenu.getItem(6).setVisible(false);
                }
              }
            } else if (rightClickedAnnotation instanceof AlloyTuple) {
              universeMenu.getItem(0).setVisible(false);
              universeMenu.getItem(1).setVisible(false);
              universeMenu.getItem(2).setVisible(false);
              universeMenu.getItem(4).setVisible(false);

              final AlloyTuple alloyTuple = (AlloyTuple) rightClickedAnnotation;
              final String bound =
                  Utility.getBoundOfTupleType(alloyTuple, relation);

              if (bound != null) {
                if (bound.equals("lower")) {
                  universeMenu.getItem(5).setVisible(false);
                  universeMenu.getItem(6).setVisible(true);
                  if (!isLower) {
                    universeMenu.getItem(3).setVisible(false);
                  } else {
                    universeMenu.getItem(3).setVisible(true);
                  }
                } else if (bound.equals("upper")) {
                  universeMenu.getItem(5).setVisible(true);
                  universeMenu.getItem(6).setVisible(false);
                }
              }
            }
          }
        }
      }
    });

    Field field;
    try {
      field = VizGraphPanel.class.getDeclaredField("graphPanel");
      field.setAccessible(true);
      if (field.get(graph) instanceof JPanel) {
        final JPanel graphPanel = (JPanel) field.get(graph);

        graphPanel.addMouseListener(new MouseAdapter() {
          @Override
          public void mousePressed(final MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {

              rightClickedAnnotation = null;

              universeMenu.setVisible(true);
              universeMenu.getItem(0).setVisible(true);
              universeMenu.getItem(1).setVisible(false);
              universeMenu.getItem(2).setVisible(false);
              universeMenu.getItem(3).setVisible(false);
              universeMenu.getItem(4).setVisible(false);

            }
          }
        });

      }
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
        | IllegalAccessException e1) {
      e1.printStackTrace();
    }
  }

  private void addMouseMotionAdaper() {
    final MouseMotionAdapter adapter = new MouseMotionAdapter() {

      @Override
      public void mouseMoved(final MouseEvent e) {
        final Object annotation =
            graph.alloyGetViewer().alloyGetAnnotationAtXY(e.getX(), e.getY());
        final JComponent cmpnt = (JComponent) e.getComponent();
        String tooltip = null;

        if (annotation instanceof AlloyAtom) {
          graphInPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

          final String id = Utility.itemIdByAlloyAtom((AlloyAtom) annotation);
          final String atomName = Utility.getAtomNameById(id);

          tooltip = atomName;
        } else if (annotation instanceof AlloyTuple) {
          final AlloyTuple tuple = (AlloyTuple) annotation;

          final AlloyAtom highLightedAtomStart = tuple.getStart();
          final AlloyAtom highLightedAtomEnd = tuple.getEnd();

          final String fromId = Utility.itemIdByAlloyAtom(highLightedAtomStart);
          final String toId = Utility.itemIdByAlloyAtom(highLightedAtomEnd);
          if (fromId == null || toId == null) {
            return;
          }
          final String fromAtomName = Utility.getAtomNameById(fromId);
          final String toAtomName = Utility.getAtomNameById(toId);

          tooltip = fromAtomName + " --> " + toAtomName;

          graphInPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
          graphInPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        cmpnt.setToolTipText(tooltip);

      }
    };
    graph.alloyGetViewer().addMouseMotionListener(adapter);
    graphInPanel.addMouseMotionListener(adapter);

  }

  public void addNewAtom(final String type, final String name) {
    Utility.addAtomToSigType(type, name);
  }

  public void addNewAtom(final String type, final String name, final Serializable data) {
    String sData = null;
    try {
      sData = Serialization.getInstance().toString(data);
    } catch (final IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Utility.addAtomToSigTypeWithData(type, name, sData);
  }

  public JPanel getGraph() {
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
    final File f = new File(xmlfile);
    try {
      if (!f.exists()) {
        throw new IOException("File " + xmlfile + " does not exist.");
      }

      final AlloyInstance instance = StaticInstanceReader.parseInstance(f);
      final VizState myState = new VizState(instance);

      if (graphInPanel.getComponentCount() > 1) {
        graphInPanel.remove(graph);
      }

      graph = new VizGraphPanel(myState, false);

      setColorOfNodes();

      graph.alloyGetViewer().alloyRepaint();

      universeMenu = new JMenu("Universe");
      final JMenuItem createAtomMenuItem = new JMenuItem("Create Atom");
      final JMenuItem createMappingMenuItem = new JMenuItem("Create Mapping");
      final JMenuItem removeAtomMenuItem = new JMenuItem("Remove Atom");
      final JMenuItem removeRelationMenuItem = new JMenuItem("Remove Relation");
      final JMenuItem changeAtomTypeMenuItem = new JMenuItem("Change Atom Type");
      final JMenuItem moveToLowerMenuItem = new JMenuItem("Move To Lower");
      final JMenuItem moveToUpperMenuItem = new JMenuItem("Move To Upper");
      final JMenuItem refreshMenuItem = new JMenuItem("Refresh");

      graph.alloyGetViewer().pop.add(universeMenu, 0);

      universeMenu.add(createAtomMenuItem, 0);
      universeMenu.add(createMappingMenuItem, 1);
      universeMenu.add(removeAtomMenuItem, 2);
      universeMenu.add(removeRelationMenuItem, 3);
      universeMenu.add(changeAtomTypeMenuItem, 4);
      universeMenu.add(moveToLowerMenuItem, 5);
      universeMenu.add(moveToUpperMenuItem, 6);
      universeMenu.add(refreshMenuItem, 7);

      createAtomMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          final CreateAtom wiz = new CreateAtom(null);
          wiz.setVisible(true);
        }
      });

      createMappingMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          final String stringIndex = ((AlloyAtom) rightClickedAnnotation)
              .toString().substring(((AlloyAtom) rightClickedAnnotation)
                  .getType().getName().length());
          int index = 0;
          if (!stringIndex.isEmpty()) {
            index = Integer.parseInt(stringIndex);
          }

          final MappingWizard relationPage = new MappingWizard(
              ((AlloyAtom) rightClickedAnnotation).getType().getName(), index);
          relationPage.setVisible(true);
        }
      });

      removeAtomMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          final AlloyAtom alloyAtom = (AlloyAtom) rightClickedAnnotation;
          final String atomLabel = Utility.itemIdByAlloyAtom(alloyAtom);
          final String atomName = Utility.getAtomNameById(atomLabel);
          final String relationName =
              ((AlloyAtom) rightClickedAnnotation).getType().getName();
          final String realTypeOfAtom = Utility.getRealTypeOfAtom(atomLabel, relationName);
          final List<String> tuple = new ArrayList<>();
          tuple.add(atomName);
          for (final Notifier notifier : notifierList) {
            if (realTypeOfAtom != null) {
              notifier.removeTupleNotify(realTypeOfAtom, relationName, tuple,
                  Visualization.getInstance().isLower() ? "lower" : "upper");
            } else {
              notifier.removeTupleNotify(relationName, tuple,
                  Visualization.getInstance().isLower() ? "lower" : "upper");
            }
          }
          Utility.removeAllRelationsOfAtom(atomLabel);
          Visualization.this.revalidate();
        }
      });

      removeRelationMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          final AlloyTuple tuple = (AlloyTuple) rightClickedAnnotation;
          final AlloyAtom fromAtom = tuple.getStart();
          final AlloyAtom toAtom = tuple.getEnd();

          final String fromAtomId = Utility.itemIdByAlloyAtom(fromAtom);
          final String toAtomId = Utility.itemIdByAlloyAtom(toAtom);

          final String fromAtomName = Utility.getAtomNameById(fromAtomId);
          final String toAtomName = Utility.getAtomNameById(toAtomId);

          final List<String> tupleList = new ArrayList<>();
          tupleList.add(fromAtomName);
          tupleList.add(toAtomName);

          for (final Notifier notifier : notifierList) {
            notifier.removeTupleNotify(relation, tupleList,
                Visualization.getInstance().isLower() ? "lower" : "upper");
          }

          Utility.removeRelation(fromAtomId, toAtomId, relation);
          Visualization.this.revalidate();
        }
      });

      changeAtomTypeMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          final CreateAtom wiz =
              new CreateAtom((AlloyAtom) rightClickedAnnotation);
          wiz.setVisible(true);
        }
      });

      moveToLowerMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          if (rightClickedAnnotation instanceof AlloyAtom) {
            Utility.setBoundOfAtomType((AlloyAtom) rightClickedAnnotation, true);
          } else if (rightClickedAnnotation instanceof AlloyTuple) {
            Utility.setBoundOfTupleType((AlloyTuple) rightClickedAnnotation,
                relation, true);
          }
          Visualization.this.revalidate();
        }
      });

      moveToUpperMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          if (rightClickedAnnotation instanceof AlloyAtom) {
            Utility.setBoundOfAtomType((AlloyAtom) rightClickedAnnotation,
                false);
          } else if (rightClickedAnnotation instanceof AlloyTuple) {
            Utility.setBoundOfTupleType((AlloyTuple) rightClickedAnnotation,
                relation, false);
          }
          Visualization.this.revalidate();
        }
      });

      refreshMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          Visualization.this.revalidate();
        }
      });


      addMouseListener();
      addMouseMotionAdaper();


      graphInPanel.add(graph, BorderLayout.CENTER);
      graphInPanel.revalidate();

      return graphInPanel;
    } catch (IOException | Err e) {
      e.printStackTrace();
    }
    return null;
  }

  public Universe getLastUniverse() {
    final XmlToUniverse xmlToUniverse = new XmlToUniverse();
    return xmlToUniverse.getUniverse();
  }

  public List<Notifier> getNotifierList() {
    return notifierList;
  }

  public Universe getUniverse() {
    return universe;
  }

  public boolean isLower() {
    return isLower;
  }

  public void revalidate() {
    // frame.remove(graph);
    getGraph();
    // frame.add(graph);
    // frame.revalidate();
  }

  private void setColorOfNodes() {
    Field field;
    try {
      field = GraphViewer.class.getDeclaredField("graph");
      field.setAccessible(true);
      if (field.get(graph.alloyGetViewer()) instanceof Graph) {
        final Graph refGraph = (Graph) field.get(graph.alloyGetViewer());

        for (final GraphNode graphNode : refGraph.nodes) {
          if (graphNode.uuid instanceof AlloyAtom) {
            final AlloyAtom alloyAtom = (AlloyAtom) graphNode.uuid;
            final String bound = Utility.getBoundOfAtomType(alloyAtom);
            if (bound != null) {
              if (bound.equals("lower")) {
                graphNode.set(new Color(255, 255, 180));
              }
            }
          }
        }

        for (final GraphEdge graphEdge : refGraph.edges) {
          if (graphEdge.uuid instanceof AlloyTuple) {
            final AlloyTuple alloyTuple = (AlloyTuple) graphEdge.uuid;
            final AlloyRelation relation = (AlloyRelation) graphEdge.group;
            final String relationName = relation.getName();
            final String bound = Utility.getBoundOfTupleType(alloyTuple, relationName);
            if (bound != null) {
              if (bound.equals("lower")) {
                final int red = graphEdge.color().getRed() + 70;
                final int green = graphEdge.color().getGreen() + 70;
                final int blue = graphEdge.color().getBlue() + 70;
                graphEdge.set(new Color(red > 255 ? 255 : red, green > 255 ? 255 : green,
                    blue > 255 ? 255 : blue));
              }
            }
          }
        }
      }
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
        | IllegalAccessException e1) {
      e1.printStackTrace();
    }
  }

  public void setNotifierList(final List<Notifier> notifierList) {
    this.notifierList = notifierList;
  }

  public void setUniverse(final Universe universe, final String xmlFile) {
    this.universe = universe;
    xmlfile = "temp" + System.getProperty("file.separator") + xmlFile + ".xml";
    xmlCreator = new XmlCreator(universe, xmlfile);
  }

  public void showMetamodel() {
    xmlCreator.setMetamodel(true);
    frame = new JFrame("Visualization");
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.add(getGraph(), BorderLayout.CENTER);
    frame.setVisible(true);
    frame.setSize(500, 500);
  }


  public void showModel() {
    xmlCreator.setMetamodel(false);
    frame = new JFrame("Visualization");
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.add(getGraph(), BorderLayout.CENTER);
    frame.setVisible(true);
    frame.setSize(500, 500);
  }
}
