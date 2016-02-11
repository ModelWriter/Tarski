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
package eu.modelwriter.visualization;

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

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.visualization.model.Universe;
import eu.modelwriter.visualization.wizards.createatom.CreateAtom;
import eu.modelwriter.visualization.wizards.mapping.MappingWizard;

public class Visualization {

  private String xmlfile;
  private Universe universe;
  private XmlCreator xmlCreator;
  private List<Notifier> notifierList;
  private VizGraphPanel graph;
  private static Visualization visualization;
  private JFrame frame;
  private JMenu universeMenu;
  private Object rightClickedAnnotation;
  private String relation;
  private JPanel graphInPanel;

  private Visualization(final Universe universe, String xmlFile) {
    notifierList = new ArrayList<>();
    graphInPanel = new JPanel();
    graphInPanel.setLayout(new BorderLayout());
    setUniverse(universe, xmlFile);
  }

  public static Visualization getInstance(final Universe universe, String xmlFile) {
    if (visualization == null)
      visualization = new Visualization(universe, xmlFile);
    else if (universe != null)
      visualization.setUniverse(universe, xmlFile);

    return visualization;
  }

  public static Visualization getInstance(String xmlFile) {
    if (visualization == null)
      visualization = new Visualization(null, xmlFile);
    else if (xmlFile != null)
      visualization.setUniverse(null, xmlFile);

    return visualization;
  }

  public static Visualization getInstance() {
    if (visualization == null)
      visualization = new Visualization(null, XmlCreator.xmlfile);

    return visualization;
  }

  public List<Notifier> getNotifierList() {
    return notifierList;
  }

  public void setNotifierList(List<Notifier> notifierList) {
    this.notifierList = notifierList;
  }

  public JPanel getGraph() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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

      if (graphInPanel.getComponentCount() != 0)
        graphInPanel.remove(graph);

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
          CreateAtom wiz = new CreateAtom(null);
          wiz.setVisible(true);
        }
      });

      createMappingMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          final String stringIndex = ((AlloyAtom) rightClickedAnnotation).toString()
              .substring(((AlloyAtom) rightClickedAnnotation).getType().getName().length());
          int index = 0;
          if (!stringIndex.isEmpty()) {
            index = Integer.parseInt(stringIndex);
          }

          MappingWizard relationPage =
              new MappingWizard(((AlloyAtom) rightClickedAnnotation).getType().getName(), index);
          relationPage.setVisible(true);
        }
      });

      removeAtomMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          String id = Utility.itemIdByAlloyAtom((AlloyAtom) rightClickedAnnotation);
          String atomName = Utility.getAtomNameById(id);
          String relationName = ((AlloyAtom) rightClickedAnnotation).getType().getName();
          List<String> tuple = new ArrayList<>();
          tuple.add(atomName);
          for (Notifier notifier : notifierList) {
            notifier.removeTupleNotify(relationName, tuple);
          }
          Utility.removeAllRelationsOfAtom(id);
          revalidate();
        }
      });

      removeRelationMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          final AlloyTuple tuple = (AlloyTuple) rightClickedAnnotation;
          final AlloyAtom fromAtom = tuple.getStart();
          final AlloyAtom toAtom = tuple.getEnd();

          String fromAtomId = Utility.itemIdByAlloyAtom(fromAtom);
          String toAtomId = Utility.itemIdByAlloyAtom(toAtom);

          String fromAtomName = Utility.getAtomNameById(fromAtomId);
          String toAtomName = Utility.getAtomNameById(toAtomId);

          List<String> tupleList = new ArrayList<>();
          tupleList.add(fromAtomName);
          tupleList.add(toAtomName);

          for (Notifier notifier : notifierList) {
            notifier.removeTupleNotify(relation, tupleList);
          }

          Utility.removeRelation(fromAtomId, toAtomId, relation);
          revalidate();
        }
      });

      changeAtomTypeMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          CreateAtom wiz = new CreateAtom((AlloyAtom) rightClickedAnnotation);
          wiz.setVisible(true);
        }
      });

      moveToLowerMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          if (rightClickedAnnotation instanceof AlloyAtom)
            Utility.setBoundOfAtomType((AlloyAtom) rightClickedAnnotation, true);
          else if (rightClickedAnnotation instanceof AlloyTuple)
            Utility.setBoundOfTupleType((AlloyTuple) rightClickedAnnotation, relation, true);
          revalidate();
        }
      });

      moveToUpperMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          if (rightClickedAnnotation instanceof AlloyAtom)
            Utility.setBoundOfAtomType((AlloyAtom) rightClickedAnnotation, false);
          else if (rightClickedAnnotation instanceof AlloyTuple)
            Utility.setBoundOfTupleType((AlloyTuple) rightClickedAnnotation, relation, false);
          revalidate();
        }
      });

      refreshMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          revalidate();
        }
      });


      addMouseListner();
      addMouseMotionAdaper();


      graphInPanel.add(graph, BorderLayout.CENTER);
      graphInPanel.revalidate();

      return graphInPanel;
    } catch (IOException | Err e) {
      e.printStackTrace();
    }
    return null;
  }

  private void addMouseListner() {
    graph.alloyGetViewer().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(final MouseEvent e) {
        super.mouseClicked(e);
        Object annotation = graph.alloyGetViewer().alloyGetAnnotationAtXY(e.getX(), e.getY());
        if (annotation instanceof AlloyAtom) {
          AlloyAtom alloyAtom = (AlloyAtom) annotation;

          final String atomType = alloyAtom.getType().getName();
          final String stringIndex = alloyAtom.toString().substring(atomType.length());
          int index = 0;
          if (!stringIndex.isEmpty()) {
            index = Integer.parseInt(stringIndex);
          }
          String serilizatedData = Utility.getDataOfAtom(atomType, index);
          if (serilizatedData == null)
            return;
          Serializable deSerilizatedData = null;
          try {
            deSerilizatedData = Serialization.getInstance().fromString(serilizatedData);
          } catch (ClassNotFoundException | IOException e1) {
            e1.printStackTrace();
          }
          for (Notifier notifier : notifierList) {
            notifier.notify(deSerilizatedData);
          }
        }
      }

      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
          rightClickedAnnotation =
              graph.alloyGetViewer().alloyGetAnnotationAtXY(e.getX(), e.getY());


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
              universeMenu.getItem(2).setVisible(true);
              universeMenu.getItem(3).setVisible(false);
              universeMenu.getItem(4).setVisible(true);

              String id = Utility.itemIdByAlloyAtom((AlloyAtom) rightClickedAnnotation);
              String type = ((AlloyAtom) rightClickedAnnotation).getType().getName();
              AtomType atomType = Utility.getAtomTypeById(id, type);

              if (atomType.getBound() != null && atomType.getBound().equals("lower")) {
                universeMenu.getItem(5).setVisible(false);
                universeMenu.getItem(6).setVisible(true);
              } else {
                universeMenu.getItem(5).setVisible(true);
                universeMenu.getItem(6).setVisible(false);
              }
            } else if (rightClickedAnnotation instanceof AlloyTuple) {
              universeMenu.getItem(0).setVisible(false);
              universeMenu.getItem(1).setVisible(false);
              universeMenu.getItem(2).setVisible(false);
              universeMenu.getItem(3).setVisible(true);
              universeMenu.getItem(4).setVisible(false);
              universeMenu.getItem(5).setVisible(true);
              universeMenu.getItem(6).setVisible(true);

              Field field;
              try {
                field = GraphViewer.class.getDeclaredField("selected");
                field.setAccessible(true);
                if (field.get(graph.alloyGetViewer()) instanceof GraphEdge) {
                  final GraphEdge edge = (GraphEdge) field.get(graph.alloyGetViewer());
                  relation =
                      edge.group.toString().substring(0, edge.group.toString().indexOf(":") - 1);
                }
              } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                  | IllegalAccessException e1) {
                e1.printStackTrace();
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
          public void mousePressed(MouseEvent e) {
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
    MouseMotionAdapter adapter = new MouseMotionAdapter() {

      @Override
      public void mouseMoved(MouseEvent e) {
        Object annotation = graph.alloyGetViewer().alloyGetAnnotationAtXY(e.getX(), e.getY());
        JComponent cmpnt = (JComponent) e.getComponent();
        String tooltip = null;

        if (annotation instanceof AlloyAtom) {
          graphInPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

          String id = Utility.itemIdByAlloyAtom((AlloyAtom) annotation);
          String atomName = Utility.getAtomNameById(id);

          tooltip = atomName;
        } else if (annotation instanceof AlloyTuple) {
          AlloyTuple tuple = (AlloyTuple) annotation;

          AlloyAtom highLightedAtomStart = tuple.getStart();
          AlloyAtom highLightedAtomEnd = tuple.getEnd();

          String fromId = Utility.itemIdByAlloyAtom(highLightedAtomStart);
          String toId = Utility.itemIdByAlloyAtom(highLightedAtomEnd);
          if (fromId == null || toId == null)
            return;
          String fromAtomName = Utility.getAtomNameById(fromId);
          String toAtomName = Utility.getAtomNameById(toId);

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

  public void addNewAtom(String type, String name, Serializable data) {
    String sData = null;
    try {
      sData = Serialization.getInstance().toString(data);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Utility.addAtomToSigTypeWithData(type, name, sData);
  }

  public void addNewAtom(String type, String name) {
    Utility.addAtomToSigType(type, name);
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

  public void showMetamodel() {
    xmlCreator.setMetamodel(true);
    frame = new JFrame("Visualization");
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.add(getGraph(), BorderLayout.CENTER);
    frame.setVisible(true);
    frame.setSize(500, 500);
  }

  public Universe getUniverse() {
    return universe;
  }

  public void setUniverse(Universe universe, String xmlFile) {
    this.universe = universe;
    this.xmlfile = "temp\\" + xmlFile + ".xml";
    this.xmlCreator = new XmlCreator(universe, this.xmlfile);
  }

  public void revalidate() {
    // frame.remove(graph);
    getGraph();
    // frame.add(graph);
    // frame.revalidate();
  }

  public Universe getLastUniverse() {
    XmlToUniverse xmlToUniverse = new XmlToUniverse();
    return xmlToUniverse.getUniverse();
  }

  private void setColorOfNodes() {
    Field field;
    try {
      field = GraphViewer.class.getDeclaredField("graph");
      field.setAccessible(true);
      if (field.get(graph.alloyGetViewer()) instanceof Graph) {
        final Graph refGraph = (Graph) field.get(graph.alloyGetViewer());

        for (GraphNode graphNode : refGraph.nodes) {
          if (graphNode.uuid instanceof AlloyAtom) {
            AlloyAtom alloyAtom = (AlloyAtom) graphNode.uuid;
            String id = Utility.itemIdByAlloyAtom(alloyAtom);
            String type = alloyAtom.getType().getName();
            AtomType atomType = Utility.getAtomTypeById(id, type);
            if (atomType.getBound() != null && atomType.getBound().equals("lower"))
              graphNode.set(new Color(255, 255, 180));
          }
        }

        for (GraphEdge graphEdge : refGraph.edges) {
          if (graphEdge.uuid instanceof AlloyTuple) {
            AlloyTuple alloyTuple = (AlloyTuple) graphEdge.uuid;
            TupleType tupleType =
                Utility.getTupleTypeByAtoms(alloyTuple.getStart(), alloyTuple.getEnd());
            if (tupleType.getBound() != null && tupleType.getBound().equals("lower")) {
              int red = graphEdge.color().getRed() + 70;
              int green = graphEdge.color().getGreen() + 70;
              int blue = graphEdge.color().getBlue() + 70;
              graphEdge.set(new Color(red > 255 ? 255 : red, green > 255 ? 255 : green,
                  blue > 255 ? 255 : blue));
            }
          }
        }
      }
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
        | IllegalAccessException e1) {
      e1.printStackTrace();
    }
  }
}
