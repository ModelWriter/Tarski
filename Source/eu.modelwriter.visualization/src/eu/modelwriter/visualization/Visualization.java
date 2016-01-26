/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.visualization;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4graph.GraphEdge;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
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

  private Visualization(final Universe universe) {
    super();
    notifierList = new ArrayList<>();
    graphInPanel = new JPanel();
    graphInPanel.setLayout(new BorderLayout());
    setUniverse(universe);
  }

  public static Visualization getInstance(final Universe universe) {
    if (visualization == null && universe != null)
      visualization = new Visualization(universe);

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

      graph.alloyGetViewer().alloyRepaint();

      universeMenu = new JMenu("Universe");
      final JMenuItem createAtomMenuItem = new JMenuItem("Create Atom");
      final JMenuItem createMappingMenuItem = new JMenuItem("Create Mapping");
      final JMenuItem removeAtomMenuItem = new JMenuItem("Remove Atom");
      final JMenuItem removeRelationMenuItem = new JMenuItem("Remove Relation");
      final JMenuItem changeAtomTypeMenuItem = new JMenuItem("Change Atom Type");
      final JMenuItem refreshMenuItem = new JMenuItem("Refresh");

      graph.alloyGetViewer().pop.add(universeMenu, 0);

      universeMenu.add(createAtomMenuItem, 0);
      universeMenu.add(createMappingMenuItem, 1);
      universeMenu.add(removeAtomMenuItem, 2);
      universeMenu.add(removeRelationMenuItem, 3);
      universeMenu.add(changeAtomTypeMenuItem, 4);
      universeMenu.add(refreshMenuItem, 5);

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
          Utility.removeAllRelationsOfAtom(
              Utility.itemIdByAlloyAtom((AlloyAtom) rightClickedAnnotation));
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

      refreshMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          revalidate();
        }
      });


      addMouseListner();


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
          } else {
            universeMenu.setVisible(true);
            if (rightClickedAnnotation instanceof AlloyAtom) {
              universeMenu.getItem(0).setVisible(false);
              universeMenu.getItem(1).setVisible(true);
              universeMenu.getItem(2).setVisible(true);
              universeMenu.getItem(3).setVisible(false);
              universeMenu.getItem(4).setVisible(true);
            } else if (rightClickedAnnotation instanceof AlloyTuple) {
              universeMenu.getItem(0).setVisible(false);
              universeMenu.getItem(1).setVisible(false);
              universeMenu.getItem(2).setVisible(false);
              universeMenu.getItem(3).setVisible(true);
              universeMenu.getItem(4).setVisible(false);

              Field field;
              try {
                field = GraphViewer.class.getDeclaredField("selected");
                field.setAccessible(true);
                if (field.get(graph.alloyGetViewer()) instanceof GraphEdge) {
                  final GraphEdge edge = (GraphEdge) field.get(graph.alloyGetViewer());
                  relation = edge.label();
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

  public void setUniverse(Universe universe) {
    this.universe = universe;
    xmlfile = "temp\\" + /* UUID.randomUUID() */"universeTest" + ".xml";
    this.xmlCreator = new XmlCreator(universe, xmlfile);
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
}
