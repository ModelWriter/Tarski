package com.mxgraph.examples.swing.viz;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.mxgraph.examples.swing.viz.model.Relation;
import com.mxgraph.examples.swing.viz.model.Tuple;
import com.mxgraph.examples.swing.viz.model.Universe;
import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.view.mxMultiplicity;

public class VisualizationFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  private static Map<String, mxCell> relName2Rel = new TreeMap<>();
  private static Map<String, mxCell> atomText2Atom = new TreeMap<>();

  private static void constructUniverse(final Universe universe, final VisualizationGraph graph) {
    final Object parent = graph.getDefaultParent();
    final Document xmlDocument = mxDomUtils.createDocument();

    final Element universeElement = xmlDocument.createElement("Universe");
    xmlDocument.appendChild(universeElement);

    graph.getModel().beginUpdate();
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
            mxCell vertex = VisualizationFrame.atomText2Atom.get(atomText);

            if (vertex == null) {
              final Element atomElement = xmlDocument.createElement("Atom");
              atomElement.setAttribute("name", atomText);
              tupleElement.appendChild(atomElement);

              vertex = (mxCell) graph.insertVertex(parent, null, atomElement);
              VisualizationFrame.atomText2Atom.put(atomText, vertex);
            } else {
              final Element atomElement = (Element) vertex.getValue();
              atomElement.setAttribute("name", atomText);
              tupleElement.appendChild(atomElement);
            }

            VisualizationFrame.relName2Rel.put(relationName, vertex);
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

            mxCell sourceVertex = VisualizationFrame.atomText2Atom.get(sourceAtomText);
            mxCell targetVertex = VisualizationFrame.atomText2Atom.get(targetAtomText);

            if (sourceVertex == null) {
              sourceVertex = (mxCell) graph.insertVertex(parent, null, sourceAtomElement);
              VisualizationFrame.atomText2Atom.put(sourceAtomText, sourceVertex);
            }

            if (targetVertex == null) {
              targetVertex = (mxCell) graph.insertVertex(parent, null, targetAtomElement);
              VisualizationFrame.atomText2Atom.put(targetAtomText, targetVertex);
            }

            final mxCell edge =
                (mxCell) graph.insertEdge(parent, null, relationName, sourceVertex, targetVertex);

            VisualizationFrame.relName2Rel.put(relationName, edge);
          }
        }
      }
    } finally {
      graph.getModel().endUpdate();
    }

    Transformer transformer;
    try {
      transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
      final DOMSource source = new DOMSource(xmlDocument);
      final StreamResult console =
          new StreamResult(new File("C:/Users/emre.kirmizi/Desktop/out.xml"));
      // final StreamResult console =
      // new StreamResult(new File("C:/Users/anil.ozturk/Desktop/out.xml"));
      transformer.transform(source, console);
    } catch (TransformerFactoryConfigurationError | TransformerException e) {
      e.printStackTrace();
    }
  }

  public static VisualizationFrame getInstance(final Universe universe) {
    final VisualizationFrame instance = new VisualizationFrame(universe);
    return instance;
  }

  public VisualizationFrame(final Universe universe) {
    super("Visualization");

    final VisualizationGraphEditor vge = new VisualizationGraphEditor();
    final VisualizationGraph graph = vge.getGraph();
    final VisualizationGraphComponent graphComponent = vge.getGraphComponent();

    VisualizationFrame.constructUniverse(universe, graph);
    ChengLayout.getInstance().setLayout(graphComponent);

    graph.setMultiplicities(this.createMultiplicities());

    // Initial validation
    graphComponent.validateGraph();

    this.getContentPane().add(graphComponent);
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
    JFrame.setDefaultLookAndFeelDecorated(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(870, 640);
    this.setVisible(true);
  }
}
