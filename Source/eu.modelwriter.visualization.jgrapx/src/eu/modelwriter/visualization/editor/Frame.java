package eu.modelwriter.visualization.editor;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.view.mxMultiplicity;

import eu.modelwriter.visualization.editor.util.GraphUtil;
import eu.modelwriter.visualization.model.Relation;
import eu.modelwriter.visualization.model.Tuple;
import eu.modelwriter.visualization.model.Universe;

public class Frame extends JFrame {
  private static final long serialVersionUID = 1L;

  public static Frame getInstance(final Universe universe) {
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
    final Frame instance = new Frame(universe);
    return instance;
  }

  Graph graph;

  GraphComponent graphComponent;

  private final Map<String, mxCell> relName2Rel = new TreeMap<>();
  private final Map<String, mxCell> atomText2Atom = new TreeMap<>();

  public Frame(final Universe universe) {
    this.setTitle("Visualization");
    this.getContentPane().setLayout(new BorderLayout(0, 0));

    final GraphEditor vge = new GraphEditor();
    this.graph = vge.getGraph();
    this.graphComponent = vge.getGraphComponent();

    this.constructUniverse(universe);
    GraphUtil.getInstance(this.graph, this.graphComponent).layout();

    this.graph.setMultiplicities(this.createMultiplicities());

    // Initial validation
    this.graphComponent.validateGraph();

    this.addComponentListener(new ComponentListener() {

      @Override
      public void componentHidden(final ComponentEvent e) {}

      @Override
      public void componentMoved(final ComponentEvent e) {}

      @Override
      public void componentResized(final ComponentEvent e) {
        if (e.getID() == ComponentEvent.COMPONENT_RESIZED) {
          final Rectangle bounds = e.getComponent().getBounds();
          final JViewport viewport = Frame.this.graphComponent.getViewport();
        }
      }

      @Override
      public void componentShown(final ComponentEvent e) {}
    });

    this.getContentPane().add(vge, BorderLayout.CENTER);
  }

  private void constructUniverse(final Universe universe) {
    final Object parent = this.graph.getDefaultParent();
    final Document xmlDocument = mxDomUtils.createDocument();

    final Element universeElement = xmlDocument.createElement("Universe");
    xmlDocument.appendChild(universeElement);

    this.graph.getModel().beginUpdate();
    try {
      for (final Relation relation : universe.getRelations()) {
        final String relationName = relation.getName();
        final Element relationElement = xmlDocument.createElement("Relation");
        relationElement.setAttribute("name", relationName);
        universeElement.appendChild(relationElement);

        if (relation.getArity() == 1) {
          for (final Tuple tuple : relation.getTuples()) {
            final Element tupleElement = xmlDocument.createElement("Tuple");
            relationElement.appendChild(tupleElement);

            final String atomText = tuple.getAtom(0).getText();
            mxCell vertex = this.atomText2Atom.get(atomText);

            if (vertex == null) {
              final Element atomElement = xmlDocument.createElement("Atom");
              atomElement.setAttribute("name", atomText);
              tupleElement.appendChild(atomElement);

              vertex = (mxCell) this.graph.insertVertex(parent, null, atomElement);
              this.atomText2Atom.put(atomText, vertex);
            } else {
              final Element atomElement = (Element) vertex.getValue();
              atomElement.setAttribute("name", atomText);
              tupleElement.appendChild(atomElement);
            }

            this.relName2Rel.put(relationName, vertex);
          }
        } else if (relation.getArity() == 2) {
          for (final Tuple tuple : relation.getTuples()) {
            final Element tupleElement = xmlDocument.createElement("Tuple");
            relationElement.appendChild(tupleElement);

            final String sourceAtomText = tuple.getAtom(0).getText();
            final String targetAtomText = tuple.getAtom(1).getText();

            final Element sourceAtomElement = xmlDocument.createElement("Atom");
            sourceAtomElement.setAttribute("name", sourceAtomText);
            tupleElement.appendChild(sourceAtomElement);

            final Element targetAtomElement = xmlDocument.createElement("Atom");
            targetAtomElement.setAttribute("name", targetAtomText);
            tupleElement.appendChild(targetAtomElement);

            mxCell sourceVertex = this.atomText2Atom.get(sourceAtomText);
            mxCell targetVertex = this.atomText2Atom.get(targetAtomText);

            if (sourceVertex == null) {
              sourceVertex = (mxCell) this.graph.insertVertex(parent, null, sourceAtomElement);
              this.atomText2Atom.put(sourceAtomText, sourceVertex);
            }

            if (targetVertex == null) {
              targetVertex = (mxCell) this.graph.insertVertex(parent, null, targetAtomElement);
              this.atomText2Atom.put(targetAtomText, targetVertex);
            }

            final mxCell edge = (mxCell) this.graph.insertEdge(parent, null, relationName,
                sourceVertex, targetVertex, "movable=0;rounded=1;entryX=0.5;entryY=0;align=left");

            this.relName2Rel.put(relationName, edge);
          }
        }
      }
    } finally {
      this.graph.getModel().endUpdate();
    }

    Transformer transformer;
    try {
      transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
      final DOMSource source = new DOMSource(xmlDocument);
      // final StreamResult console =
      // new StreamResult(new File("C:/Users/emre.kirmizi/Desktop/out.xml"));
      final StreamResult console =
          new StreamResult(new File("C:/Users/anil.ozturk/Desktop/out.xml"));
      transformer.transform(source, console);
    } catch (TransformerFactoryConfigurationError | TransformerException e) {
      e.printStackTrace();
    }
  }

  private mxMultiplicity[] createMultiplicities() {
    final mxMultiplicity[] multiplicities = new mxMultiplicity[3];

    multiplicities[0] =
        new mxMultiplicity(true, "Alias", null, null, 0, String.valueOf(Integer.MAX_VALUE),
            Arrays.asList(new String[] {"Word"}), null, "Alias Must Connect to Word", true);

    multiplicities[1] =
        new mxMultiplicity(true, "Directory", null, null, 0, String.valueOf(Integer.MAX_VALUE),
            Arrays.asList(new String[] {"Word", "Alias", "Directory", "Root"}), null,
            "Directory Must Connect to Object", true);

    multiplicities[2] =
        new mxMultiplicity(true, "Root", null, null, 0, String.valueOf(Integer.MAX_VALUE),
            Arrays.asList(new String[] {"Word", "Alias", "Directory", "Root"}), null,
            "final Directory Must Connect final to Object", true);

    multiplicities[2] = new mxMultiplicity(true, "Word", null, null, 0, "0", null,
        "Word can not connect to any other", null, true);
    return multiplicities;
  }

  public void showModel() {
    this.setSize((int) GraphUtil.width, (int) GraphUtil.height);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
}
