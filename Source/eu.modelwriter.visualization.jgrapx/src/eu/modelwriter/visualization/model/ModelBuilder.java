package eu.modelwriter.visualization.model;

import java.awt.Color;
import java.io.File;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

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
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxMultiplicity;
import com.mxgraph.view.mxStylesheet;

import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.util.GraphUtil;

public class ModelBuilder {
  private static final String EDGE_STYLE = "EDGE_STYLE";
  private final Map<String, mxCell> relName2Rel = new TreeMap<>();
  private final Map<String, mxCell> atomText2Atom = new TreeMap<>();
  private final Map<String, Color> relName2Color = new TreeMap<>();
  private final Graph graph;
  private final Universe universe;

  public ModelBuilder(final Universe universe, final Graph graph) {
    this.universe = universe;
    this.graph = graph;
  }

  public void build() {
    final Object parent = this.graph.getDefaultParent();
    final Document xmlDocument = mxDomUtils.createDocument();

    final Element universeElement = xmlDocument.createElement("Universe");
    xmlDocument.appendChild(universeElement);

    this.graph.getModel().beginUpdate();
    try {
      for (final Relation relation : this.universe.getRelations()) {
        final Hashtable<String, Object> templateEdgeStyle = new Hashtable<>(this.setStyleSheet());

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
            vertex.setAttribute(GraphUtil.NAME, atomText);

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
            sourceVertex.setAttribute(GraphUtil.NAME, sourceAtomText);

            if (targetVertex == null) {
              targetVertex = (mxCell) this.graph.insertVertex(parent, null, targetAtomElement);
              this.atomText2Atom.put(targetAtomText, targetVertex);
            }
            targetVertex.setAttribute(GraphUtil.NAME, targetAtomText);

            final Color randomUniqueColor = EdgeColor.INSTANCE.getRandomUniqueColor();
            this.relName2Color.put(relationName, randomUniqueColor);

            templateEdgeStyle.put(mxConstants.STYLE_STROKECOLOR,
                mxUtils.getHexColorString(randomUniqueColor));
            this.graph.getStylesheet().putCellStyle(relationName + "$EdgeStyle", templateEdgeStyle);

            final mxCell edge = (mxCell) this.graph.insertEdge(parent, null, relationName,
                sourceVertex, targetVertex, relationName + "$EdgeStyle");
            this.relName2Rel.put(relationName, edge);
            edge.setAttribute(GraphUtil.NAME, relationName);
          }
        }
      }
      this.graph.setMultiplicities(this.createMultiplicities());
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

  private Hashtable<String, Object> setStyleSheet() {
    final Hashtable<String, Object> style = new Hashtable<String, Object>();
    final mxStylesheet stylesheet = this.graph.getStylesheet();

    style.put(mxConstants.STYLE_MOVABLE, String.valueOf(0));
    style.put(mxConstants.STYLE_ROUNDED, String.valueOf(1));
    style.put(mxConstants.STYLE_ENTRY_X, String.valueOf(0.5));
    style.put(mxConstants.STYLE_EXIT_X, String.valueOf(0.5));
    style.put(mxConstants.STYLE_ENTRY_Y, String.valueOf(0));
    style.put(mxConstants.STYLE_EXIT_Y, String.valueOf(1));
    style.put(mxConstants.STYLE_ARCSIZE, String.valueOf(100));
    style.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);

    stylesheet.putCellStyle(ModelBuilder.EDGE_STYLE, style);

    return style;
  }
}
