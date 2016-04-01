package eu.modelwriter.visualization.model;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.mxgraph.io.mxCodecRegistry;
import com.mxgraph.io.mxObjectCodec;
import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
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
import eu.modelwriter.visualization.editor.util.EdgeUtil;
import eu.modelwriter.visualization.editor.util.GraphUtil;
import eu.modelwriter.visualization.editor.util.NodeUtil;

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

  /**
   * List for each relation which has same target and source as unordered.
   */
  private final List<Object> parallelRelation = new ArrayList<>();

  /**
   * List of unary relation names.
   */
  private final List<String> unaryRelationNames = new ArrayList<>();

  /**
   * List of n'ary relation names.
   */
  private final List<String> n_aryRelationNames = new ArrayList<>();

  /**
   * Sets the manager and then {@link ModelManager#addObserver(Observer) adds} itself to manager as
   * {@link Observer}.
   *
   * @param manager
   */
  public GraphBuilder(final ModelManager manager) {
    this.manager = manager;
    this.manager.addObserver(this);
  }

  /**
   * Assigns given color to style which is named styleName.
   *
   * @param styleName
   * @param color
   */
  private void assignColor2EdgeStyle(final String styleName, final Color color) {
    final Map<String, Object> specificEdgeStyle =
        StaticEditorManager.graph.getStylesheet().getCellStyle(styleName, null);

    specificEdgeStyle.put(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(color));

    StaticEditorManager.graph.getStylesheet().putCellStyle(styleName, specificEdgeStyle);
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
        String relationName = relation.getName();
        if (relation.getArity() == 1) {
          if (!this.unaryRelationNames.contains(relationName)) {
            if (relationName == null) {
              relationName = "Universe";
            }
            this.unaryRelationNames.add(relationName);
          }
          for (final Tuple tuple : relation.getTuples()) {
            String atomText = String.valueOf(relationName.charAt(0));
            do {
              atomText += new Random().nextInt(1000);
            } while (this.atomText2Vertex.containsKey(atomText));
            tuple.getAtom(0).setText(atomText);

            mxCell vertex = this.atomText2Vertex.get(atomText);
            if (vertex == null) {
              final OurObject object = new OurObject();
              object.setAttribute(GraphUtil.NAME, atomText);
              object.setAttribute(NodeUtil.TYPE, relationName);
              object.setAttribute(NodeUtil.BOUND, tuple.getBound());
              vertex = (mxCell) StaticEditorManager.graph.insertVertex(parent, null, object);
              this.atomText2Vertex.put(atomText, vertex);
            } else {
              final OurObject object = (OurObject) vertex.getValue();
              object.setAttribute(GraphUtil.NAME, atomText);
              object.setAttribute(NodeUtil.TYPE, relationName);
              object.setAttribute(NodeUtil.BOUND, tuple.getBound());
            }
          }
        } else if (relation.getArity() == 2) {
          if (!this.n_aryRelationNames.contains(relationName)) {
            this.n_aryRelationNames.add(relationName);
          }
          for (final Tuple tuple : relation.getTuples()) {
            final String sourceAtomText = tuple.getAtom(0).getText();
            final String targetAtomText = tuple.getAtom(1).getText();
            mxCell sourceVertex = this.atomText2Vertex.get(sourceAtomText);
            mxCell targetVertex = this.atomText2Vertex.get(targetAtomText);
            if (sourceVertex == null) {
              final OurObject sourceObject = new OurObject();
              sourceObject.setAttribute(GraphUtil.NAME, sourceAtomText);
              sourceVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, sourceObject);
              this.atomText2Vertex.put(sourceAtomText, sourceVertex);
            }
            if (targetVertex == null) {
              final OurObject targetObject = new OurObject();
              targetObject.setAttribute(GraphUtil.NAME, targetAtomText);
              targetVertex =
                  (mxCell) StaticEditorManager.graph.insertVertex(parent, null, targetObject);
              this.atomText2Vertex.put(targetAtomText, targetVertex);
            }

            boolean hasParallel = false;
            final Object[] edgesBetween =
                StaticEditorManager.graph.getEdgesBetween(sourceVertex, targetVertex);
            for (final Object object : edgesBetween) {
              final String edgeName = EdgeUtil.getInstance().getEdgeName((mxCell) object);
              if (edgeName.equals(relationName)) {
                this.parallelRelation.add(object);
                this.n_aryRelationNames.add(relationName + "$headed");
                hasParallel = true;
                break;
              }
            }

            if (!hasParallel) {
              final OurObject object = new OurObject();
              object.setAttribute(GraphUtil.NAME, relationName);
              object.setAttribute(NodeUtil.BOUND, tuple.getBound());
              StaticEditorManager.graph.insertEdge(parent, null, object, sourceVertex, targetVertex,
                  relationName);
            }
          }
        }
      }
      for (final String edgeStyleName : this.n_aryRelationNames) {
        this.createSpecificEdgeStyle(edgeStyleName);
      }

      this.specificEdgeStyleWithHeaded();
      this.specificEdgeStylesWithRandomColor();
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
   * Creates specific edge style with given unique style name.
   *
   * @param styleName must be unique.
   * @param headed
   * @param headed
   */
  private void createSpecificEdgeStyle(final String styleName) {
    final Hashtable<String, Object> specificEdgeStyle =
        new Hashtable<>(StaticEditorManager.graph.getStylesheet().getDefaultEdgeStyle());

    StaticEditorManager.graph.getStylesheet().putCellStyle(styleName, specificEdgeStyle);
  }

  public Map<String, mxCell> getAtomText2Vertex() {
    return this.atomText2Vertex;
  }

  /**
   * @return {@link GraphBuilder#n_aryRelationNames n_aryRelationNames}
   */
  public List<String> getN_aryRelationNames() {
    return this.n_aryRelationNames;
  }

  /**
   * @return {@linkplain GraphBuilder#relName2Color relName2Color}
   */
  public Map<String, Color> getRelName2Color() {
    return this.relName2Color;
  }

  /**
   * @return {@link GraphBuilder#unaryRelationNames unaryRelationNames}
   */
  public List<String> getUnaryRelationNames() {
    return this.unaryRelationNames;
  }

  /**
   * Generates random unique color for given relation name.
   *
   * @param relationName
   * @return generated random unique color.
   */
  private Color randomColor4Relation(final String relationName) {
    final Color oldColor = this.relName2Color.get(relationName);

    final Color color = UniqueColor.randomColor();
    this.relName2Color.put(relationName, color);

    if (oldColor != null) {
      UniqueColor.get(oldColor).setUsed(false);
    }

    return color;
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
   * Gives all edges specific edge style with random color, according to relation name.
   */
  public void specificEdgeStylesWithRandomColor() {
    for (final String edgeStyleName : this.n_aryRelationNames) {
      final Color color = this.randomColor4Relation(edgeStyleName);
      this.assignColor2EdgeStyle(edgeStyleName, color);
    }
  }

  private void specificEdgeStyleWithHeaded() {
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_CLASSIC,
        this.parallelRelation.toArray());
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
  @SuppressWarnings("unused")
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
