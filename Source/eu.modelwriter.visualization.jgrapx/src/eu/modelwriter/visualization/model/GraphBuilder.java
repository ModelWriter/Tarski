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

import com.mxgraph.io.mxCodecRegistry;
import com.mxgraph.io.mxObjectCodec;
import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxMultiplicity;

import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.Relation;
import eu.modelwriter.model.Tuple;
import eu.modelwriter.model.observer.Observer;
import eu.modelwriter.model.observer.Subject;
import eu.modelwriter.model.observer.UpdateType;
import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.util.GraphUtil;

public class GraphBuilder implements Observer {
  private static final String EDGE_STYLE = "EDGE_STYLE";

  private final ModelManager manager;
  private final Map<String, mxCell> relName2Rel = new TreeMap<>();
  private final Map<String, mxCell> atomText2Atom = new TreeMap<>();
  private final Map<String, Color> relName2Color = new TreeMap<>();

  public GraphBuilder(final ModelManager manager) {
    this.manager = manager;
    this.manager.addObserver(this);
  }

  public void build() {
    final Object parent = StaticEditorManager.graph.getDefaultParent();
    final Document xmlDocument = mxDomUtils.createDocument();

    final Element universeElement = xmlDocument.createElement("Universe");
    xmlDocument.appendChild(universeElement);

    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      for (final Relation relation : this.manager.getRelations()) {

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

              vertex = (mxCell) StaticEditorManager.graph.insertVertex(parent, null, atomElement);
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
              sourceVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, sourceAtomElement);
              this.atomText2Atom.put(sourceAtomText, sourceVertex);
            }
            sourceVertex.setAttribute(GraphUtil.NAME, sourceAtomText);

            if (targetVertex == null) {
              targetVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, targetAtomElement);
              this.atomText2Atom.put(targetAtomText, targetVertex);
            }
            targetVertex.setAttribute(GraphUtil.NAME, targetAtomText);

            final String specificStyleName = this.specificEdgeStyleWithRandomColor(relationName,
                this.relName2Color.get(relationName));

            final mxCell edge = (mxCell) StaticEditorManager.graph.insertEdge(parent, null,
                relationName, sourceVertex, targetVertex, specificStyleName);
            this.relName2Rel.put(relationName, edge);
            edge.setAttribute(GraphUtil.NAME, relationName);
          }
        }
      }
      StaticEditorManager.graph.setMultiplicities(this.createMultiplicities());
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
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

  public void buildX() {
    final Object parent = StaticEditorManager.graph.getDefaultParent();

    mxCodecRegistry.addPackage("eu.modelwriter.visualization.model");
    mxCodecRegistry.register(new mxObjectCodec(new eu.modelwriter.visualization.model.OurObject()));

    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      for (final Relation relation : this.manager.getRelations()) {
        final String relationName = relation.getName();
        if (relation.getArity() == 1) {
          for (final Tuple tuple : relation.getTuples()) {
            final String atomText = tuple.getAtom(0).getText();
            mxCell vertex = this.atomText2Atom.get(atomText);
            if (vertex == null) {
              final OurObject object = new OurObject();
              object.setAttribute("name", atomText);
              vertex = (mxCell) StaticEditorManager.graph.insertVertex(parent, null, object);
              this.atomText2Atom.put(atomText, vertex);
            } else {
              final OurObject object = (OurObject) vertex.getValue();
              object.setAttribute("name", atomText);
            }
            vertex.setAttribute(GraphUtil.NAME, atomText);
            this.relName2Rel.put(relationName, vertex);
          }
        } else if (relation.getArity() == 2) {
          for (final Tuple tuple : relation.getTuples()) {
            final String sourceAtomText = tuple.getAtom(0).getText();
            final String targetAtomText = tuple.getAtom(1).getText();
            final OurObject sourceObject = new OurObject();
            sourceObject.setAttribute("name", sourceAtomText);
            final OurObject targetObject = new OurObject();
            targetObject.setAttribute("name", targetAtomText);
            mxCell sourceVertex = this.atomText2Atom.get(sourceAtomText);
            mxCell targetVertex = this.atomText2Atom.get(targetAtomText);
            if (sourceVertex == null) {
              sourceVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, sourceObject);
              this.atomText2Atom.put(sourceAtomText, sourceVertex);
            }
            sourceVertex.setAttribute(GraphUtil.NAME, sourceAtomText);
            if (targetVertex == null) {
              targetVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, targetObject);
              this.atomText2Atom.put(targetAtomText, targetVertex);
            }
            targetVertex.setAttribute(GraphUtil.NAME, targetAtomText);

            final String specificStyleName = this.specificEdgeStyleWithRandomColor(relationName,
                this.relName2Color.get(relationName));

            final mxCell edge = (mxCell) StaticEditorManager.graph.insertEdge(parent, null,
                relationName, sourceVertex, targetVertex, specificStyleName);
            this.relName2Rel.put(relationName, edge);
            edge.setAttribute(GraphUtil.NAME, relationName);
          }
        }
      }
      StaticEditorManager.graph.setMultiplicities(this.createMultiplicities());
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
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

  public ModelManager getManager() {
    return this.manager;
  }

  public Map<String, Color> getRelName2Color() {
    return this.relName2Color;
  }

  /**
   *
   * @param relationName
   * @return
   */
  private String specificEdgeStyleWithRandomColor(final String relationName, Color color) {
    final Hashtable<String, Object> specificEdgeStyle = new Hashtable<>(this.templateEdgeStyle());

    if (color == null) {
      color = EdgeColor.INSTANCE.randomUniqueColor();
      this.relName2Color.put(relationName, color);
    }

    specificEdgeStyle.put(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(color));

    final String styleName = "edgeStyle$" + relationName;

    StaticEditorManager.graph.getStylesheet().putCellStyle(styleName, specificEdgeStyle);

    return styleName;
  }

  private Hashtable<String, Object> templateEdgeStyle() {
    final Hashtable<String, Object> style = new Hashtable<String, Object>();

    style.put(mxConstants.STYLE_MOVABLE, "0");
    style.put(mxConstants.STYLE_ROUNDED, "1");
    style.put(mxConstants.STYLE_ENTRY_X, "0.5");
    style.put(mxConstants.STYLE_EXIT_X, "0.5");
    style.put(mxConstants.STYLE_ENTRY_Y, "0.5");
    style.put(mxConstants.STYLE_EXIT_Y, "0.5");
    style.put(mxConstants.STYLE_ARCSIZE, "100");
    style.put(mxConstants.STYLE_STROKEWIDTH, "2");
    style.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);

    StaticEditorManager.graph.getStylesheet().putCellStyle(GraphBuilder.EDGE_STYLE, style);

    return style;
  }

  @Override
  public void update(final Subject s, final Object updateType) {
    switch ((UpdateType) updateType) {
      case ADD_RELATION:
        System.out.println("ADD_RELATION : " + this.getClass().getName());
        break;
      case REMOVE_RELATION:
        System.out.println("REMOVE_RELATION : " + this.getClass().getName());
        break;
      case ADD_TUPLE:
        System.out.println("ADD_TUPLE : " + this.getClass().getName());
        break;
      case REMOVE_TUPLE:
        System.out.println("REMOVE_TUPLE : " + this.getClass().getName());
        break;
      case MOVE_TO_UPPER:
        System.out.println("MOVE_TO_UPPER : " + this.getClass().getName());
        break;
      case MOVE_TO_LOWER:
        System.out.println("MOVE_TO_LOWER : " + this.getClass().getName());
        break;
      default:
        break;
    }
  }
}
