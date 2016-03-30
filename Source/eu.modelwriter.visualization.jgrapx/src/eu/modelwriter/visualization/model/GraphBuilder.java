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

import eu.modelwriter.model.Atom;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.Relation;
import eu.modelwriter.model.Tuple;
import eu.modelwriter.model.observer.Observer;
import eu.modelwriter.model.observer.Subject;
import eu.modelwriter.model.observer.UpdateType;
import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.util.GraphUtil;

/**
 * {@link GraphBuilder#build() Builds} {@link Graph graph} with data which taken from
 * {@link ModelManager manager}. <br>
 * Implements {@link Observer} and be notified by {@link ModelManager} with {@link UpdateType
 * updates} which are occured in manager. So {@link GraphBuilder#update(Subject, Object) updates}
 * {@link Graph graph} according to notification.
 *
 */
public class GraphBuilder implements Observer {
  private final ModelManager manager;
  /**
   * Map for each {@linkplain Atom#getText() atomText} to {@linkplain mxCell vertex} <br>
   */
  private final Map<String, mxCell> atomText2Vertex = new TreeMap<>();
  /**
   * Map for each relation name to specific color.
   */
  private final Map<String, Color> relName2Color = new TreeMap<>();

  public GraphBuilder(final ModelManager manager) {
    this.manager = manager;
    this.manager.addObserver(this);
  }

  /**
   * Takes {@linkplain Relation relations} from {@linkplain ModelManager manager} and then <br>
   * Creates {@linkplain Graph#insertVertex(Object, String, Object) vertices} for each
   * {@linkplain Atom atom} and {@linkplain Graph#insertEdge(Object, String, Object, Object, Object)
   * edges} for each {@linkplain Tuple tuple}. <br>
   * Sets style and color of each edge.
   */
  public void build() {
    this.setDefaultEdgeStyle();

    final Object parent = StaticEditorManager.graph.getDefaultParent();
    final Document xmlDocument = mxDomUtils.createDocument();

    final Element universeElement = xmlDocument.createElement("Universe");
    xmlDocument.appendChild(universeElement);

    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      for (final Relation relation : this.manager.getRelations()) {

        final String relationName = relation.getName();
        final String specificStyleName = this.specificEdgeStyleWithRandomColor(relationName);
        final Element relationElement = xmlDocument.createElement("Relation");
        relationElement.setAttribute("name", relationName);
        universeElement.appendChild(relationElement);

        if (relation.getArity() == 1) {
          for (final Tuple tuple : relation.getTuples()) {
            final Element tupleElement = xmlDocument.createElement("Tuple");
            relationElement.appendChild(tupleElement);

            final String atomText = tuple.getAtom(0).getText();
            mxCell vertex = this.atomText2Vertex.get(atomText);

            if (vertex == null) {
              final Element atomElement = xmlDocument.createElement("Atom");
              atomElement.setAttribute("name", atomText);
              tupleElement.appendChild(atomElement);

              vertex = (mxCell) StaticEditorManager.graph.insertVertex(parent, null, atomElement);
              this.atomText2Vertex.put(atomText, vertex);
            } else {
              final Element atomElement = (Element) vertex.getValue();
              atomElement.setAttribute("name", atomText);
              tupleElement.appendChild(atomElement);
            }
            vertex.setAttribute(GraphUtil.NAME, atomText);
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

            mxCell sourceVertex = this.atomText2Vertex.get(sourceAtomText);
            mxCell targetVertex = this.atomText2Vertex.get(targetAtomText);

            if (sourceVertex == null) {
              sourceVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, sourceAtomElement);
              this.atomText2Vertex.put(sourceAtomText, sourceVertex);
            }
            sourceVertex.setAttribute(GraphUtil.NAME, sourceAtomText);

            if (targetVertex == null) {
              targetVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, targetAtomElement);
              this.atomText2Vertex.put(targetAtomText, targetVertex);
            }
            targetVertex.setAttribute(GraphUtil.NAME, targetAtomText);

            final mxCell edge = (mxCell) StaticEditorManager.graph.insertEdge(parent, null,
                relationName, sourceVertex, targetVertex, specificStyleName);
            edge.setAttribute(GraphUtil.NAME, relationName);
          }
        }
      }
      StaticEditorManager.graph.setMultiplicities(this.createMultiplicities());
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
    }
    this.writeXml(xmlDocument);
  }

  /**
   * Takes {@linkplain Relation relations} from {@linkplain ModelManager manager} and then <br>
   * Creates {@linkplain Graph#insertVertex(Object, String, Object) vertices} for each
   * {@linkplain Atom atom} and {@linkplain Graph#insertEdge(Object, String, Object, Object, Object)
   * edges} for each {@linkplain Tuple tuple}. <br>
   * Sets style and color of each edge.
   */
  public void buildX() {
    this.setDefaultEdgeStyle();

    final Object parent = StaticEditorManager.graph.getDefaultParent();

    mxCodecRegistry.addPackage("eu.modelwriter.visualization.model");
    mxCodecRegistry.register(new mxObjectCodec(new eu.modelwriter.visualization.model.OurObject()));

    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      for (final Relation relation : this.manager.getRelations()) {
        final String relationName = relation.getName();
        final String specificStyleName = this.specificEdgeStyleWithRandomColor(relationName);
        if (relation.getArity() == 1) {
          for (final Tuple tuple : relation.getTuples()) {
            final String atomText = tuple.getAtom(0).getText();
            mxCell vertex = this.atomText2Vertex.get(atomText);
            if (vertex == null) {
              final OurObject object = new OurObject();
              object.setAttribute("name", atomText);
              vertex = (mxCell) StaticEditorManager.graph.insertVertex(parent, null, object);
              this.atomText2Vertex.put(atomText, vertex);
            } else {
              final OurObject object = (OurObject) vertex.getValue();
              object.setAttribute("name", atomText);
            }
            vertex.setAttribute(GraphUtil.NAME, atomText);
          }
        } else if (relation.getArity() == 2) {
          for (final Tuple tuple : relation.getTuples()) {
            final String sourceAtomText = tuple.getAtom(0).getText();
            final String targetAtomText = tuple.getAtom(1).getText();
            final OurObject sourceObject = new OurObject();
            sourceObject.setAttribute("name", sourceAtomText);
            final OurObject targetObject = new OurObject();
            targetObject.setAttribute("name", targetAtomText);
            mxCell sourceVertex = this.atomText2Vertex.get(sourceAtomText);
            mxCell targetVertex = this.atomText2Vertex.get(targetAtomText);
            if (sourceVertex == null) {
              sourceVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, sourceObject);
              this.atomText2Vertex.put(sourceAtomText, sourceVertex);
            }
            sourceVertex.setAttribute(GraphUtil.NAME, sourceAtomText);
            if (targetVertex == null) {
              targetVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, targetObject);
              this.atomText2Vertex.put(targetAtomText, targetVertex);
            }
            targetVertex.setAttribute(GraphUtil.NAME, targetAtomText);

            final mxCell edge = (mxCell) StaticEditorManager.graph.insertEdge(parent, null,
                relationName, sourceVertex, targetVertex, specificStyleName);
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

  /**
   * @return {@linkplain GraphBuilder#relName2Color relName2Color}
   */
  public Map<String, Color> getRelName2Color() {
    return this.relName2Color;
  }

  /**
   * Sets default edge style with some required parameters.
   */
  private void setDefaultEdgeStyle() {
    final Hashtable<String, Object> style =
        new Hashtable<>(StaticEditorManager.graph.getStylesheet().getDefaultEdgeStyle());

    style.put(mxConstants.STYLE_MOVABLE, "0");
    style.put(mxConstants.STYLE_ROUNDED, "1");
    style.put(mxConstants.STYLE_ENTRY_X, "0.5");
    style.put(mxConstants.STYLE_EXIT_X, "0.5");
    style.put(mxConstants.STYLE_ENTRY_Y, "0.5");
    style.put(mxConstants.STYLE_EXIT_Y, "0.5");
    style.put(mxConstants.STYLE_ARCSIZE, "100");
    style.put(mxConstants.STYLE_STROKEWIDTH, "2");
    style.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);

    StaticEditorManager.graph.getStylesheet().setDefaultEdgeStyle(style);
  }

  /**
   * @param RelationName is name which random unique color will be created for it.
   * @return New style-name which predicated on default edge style.
   */
  private String specificEdgeStyleWithRandomColor(final String relationName) {
    final Hashtable<String, Object> specificEdgeStyle =
        new Hashtable<>(StaticEditorManager.graph.getStylesheet().getDefaultEdgeStyle());

    Color color = this.relName2Color.get(relationName);
    if (color == null) {
      color = EdgeColor.INSTANCE.randomUniqueColor();
      this.relName2Color.put(relationName, color);
    }

    specificEdgeStyle.put(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(color));

    final String styleName = "edgeStyle$" + relationName;

    StaticEditorManager.graph.getStylesheet().putCellStyle(styleName, specificEdgeStyle);

    return styleName;
  }

  /**
   * If there is any update on the model, {@link ModelManager} class
   * {@linkplain ModelManager#notifyAllObservers(Object) notifies} {@linkplain GraphBuilder this}
   * {@linkplain Observer observer} class about {@linkplain UpdateType update type}
   */
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

  /**
   * Writes given xmlDocument to xml file.
   *
   * @param xmlDocument
   */
  private void writeXml(final Document xmlDocument) {
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
}
