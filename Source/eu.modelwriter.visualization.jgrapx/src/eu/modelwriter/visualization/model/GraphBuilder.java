package eu.modelwriter.visualization.model;

import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
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

import com.mxgraph.io.mxCodecRegistry;
import com.mxgraph.io.mxObjectCodec;
import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxMultiplicity;

import eu.modelwriter.model.Atom;
import eu.modelwriter.model.ModelElement;
import eu.modelwriter.model.ModelElement.BOUND;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.RelationSet;
import eu.modelwriter.model.Tuple;
import eu.modelwriter.model.exception.InvalidArityException;
import eu.modelwriter.model.exception.NoSuchModelElementException;
import eu.modelwriter.model.observer.Observer;
import eu.modelwriter.model.observer.Subject;
import eu.modelwriter.model.observer.UpdateType;
import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.util.EdgeUtil;

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
   * Map for each {@linkplain Atom#getID() atomId} to {@linkplain mxCell vertex} <br>
   */
  private final Map<String, mxCell> atomId2Vertex = new TreeMap<>();

  /**
   * Map for each relation name to specific color.
   */
  private final Map<String, Color> relName2Color = new TreeMap<>();

  /**
   * List for each relation which has same target and source as unordered.
   */
  private final List<Object> parallelRelation = new ArrayList<>();

  /**
   * List for each {@linkplain mxCell vertex} which have self edges.
   */
  private final List<Object> selfEdges = new ArrayList<>();

  /**
   * List of unary relation names.
   */
  private final List<String> unaryRelationNames = new ArrayList<>();

  /**
   * List of n'ary relation names.
   */
  private final List<String> n_aryRelationNames = new ArrayList<>();

  private Object parent;

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

  public void addAtom(final List<String> relationSetsNames, final Serializable data,
      final BOUND bound) {
    try {
      final Atom atom =
          this.manager.addAtom(this.manager.getRelationSets(relationSetsNames), data, bound);
      this.createVertex(atom);
    } catch (final InvalidArityException e) {
      e.printStackTrace();
    }
  }

  public void addTuple(final String relationSetName, final Serializable data, final BOUND bound,
      final int arity, final Atom... atoms) {
    try {
      final Tuple tuple = this.manager.addTuple(this.manager.getRelationSet(relationSetName), data,
          bound, arity, atoms);
      this.createEdge(tuple);
    } catch (final InvalidArityException e) {
    }
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
   * Takes {@linkplain RelationSet relationSets} from {@linkplain ModelManager manager} and then
   * <br>
   * Creates {@linkplain Graph#insertVertex(Object, String, Object) vertices} for each
   * {@linkplain Atom atom} and {@linkplain Graph#insertEdge(Object, String, Object, Object, Object)
   * edges} for each {@linkplain Tuple tuple}. <br>
   * Sets style and color of each edge.
   */
  public void build() {
    this.setDefaultEdgeStyle();

    this.parent = StaticEditorManager.graph.getDefaultParent();

    final List<Atom> atoms = this.manager.getAllAtoms();
    final List<Tuple> tuples = this.manager.getAllTuples();

    this.unaryRelationNames.addAll(this.manager.getUnaryRelationSetNames());
    this.n_aryRelationNames.addAll(this.manager.getNaryRelationSetNames());

    mxCodecRegistry.addPackage("eu.modelwriter.model");
    mxCodecRegistry.register(new mxObjectCodec(new eu.modelwriter.model.ModelElement()));

    for (final Atom atom : atoms) {
      this.createVertex(atom);
    }

    for (final Tuple tuple : tuples) {
      if (tuple.getArity() == 2) {
        this.createEdge(tuple);
      }
    }

    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      for (final String edgeStyleName : this.n_aryRelationNames) {
        this.createSpecificEdgeStyle(edgeStyleName);
      }

      this.specifyEdgeStyle();
      this.specificEdgeStylesWithRandomColor();
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
    }
  }

  public void changeAtomType(final mxCell vertex, final List<String> selectedValuesList) {
    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      final Atom atom = (Atom) vertex.getValue();
      this.manager.changeRelationSetsOfAtom(atom.getID(), selectedValuesList);
      StaticEditorManager.graph.removeCells(StaticEditorManager.graph.getEdges(vertex));
    } catch (final InvalidArityException | NoSuchModelElementException e) {
      e.printStackTrace();
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
    }
  }

  private void createEdge(final Tuple tuple) {
    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      final String relationSetName = tuple.getRelationSetsNames().get(0);

      final ModelElement sourceAtom = tuple.getAtom(0);
      final mxCell sourceVertex = this.atomId2Vertex.get(sourceAtom.getID());

      final ModelElement targetAtom = tuple.getAtom(1);
      final mxCell targetVertex = this.atomId2Vertex.get(targetAtom.getID());

      boolean hasParallel = false;
      for (final Object object : StaticEditorManager.graph.getEdgesBetween(sourceVertex,
          targetVertex)) {
        final String edgeName = EdgeUtil.getInstance().getEdgeName((mxCell) object);
        if (edgeName.equals(relationSetName)) {
          this.parallelRelation.add(object);
          this.n_aryRelationNames.add(relationSetName + "$headed");
          hasParallel = true;
          break;
        }
      }

      if (!hasParallel) {
        final Object edge = StaticEditorManager.graph.insertEdge(this.parent, tuple.getID(), tuple,
            sourceVertex, targetVertex, relationSetName);
        if (sourceVertex.equals(targetVertex)) {
          this.selfEdges.add(edge);
        }
      }
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
    }
  }

  @SuppressWarnings("unused")
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

  private void createVertex(final Atom atom) {
    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      final String atomID = atom.getID();
      mxCell vertex = this.atomId2Vertex.get(atomID);

      if (vertex == null) {
        vertex =
            (mxCell) StaticEditorManager.graph.insertVertex(this.parent, null, atom, 0, 0, 0, 0);
        this.atomId2Vertex.put(atomID, vertex);
      }
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
    }
  }

  public Map<String, mxCell> getAtomId2Vertex() {
    return this.atomId2Vertex;
  }

  public ModelManager getManager() {
    return this.manager;
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

  private void specifyEdgeStyle() {
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_CLASSIC,
        this.parallelRelation.toArray());
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_EAST,
        this.selfEdges.toArray());
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_RIGHT,
        this.selfEdges.toArray());
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_BENDABLE, "0",
        this.selfEdges.toArray());
  }

  /**
   * If there is any update on the model, {@link ModelManager} class
   * {@linkplain ModelManager#notifyAllObservers(Object) notifies} {@linkplain GraphBuilder this}
   * {@linkplain Observer observer} class about {@linkplain UpdateType update type}
   */
  @Override
  public void update(final Object updatedObject, final Object updateType) {
    switch ((UpdateType) updateType) {
      case ADD_RELATION:
        System.out.println("ADD_RELATION : " + updatedObject.toString());
        break;
      case REMOVE_RELATION:
        System.out.println("REMOVE_RELATION : " + updatedObject.toString());
        break;
      case ADD_TUPLE:
        System.out.println("ADD_TUPLE : " + updatedObject.toString());
        break;
      case REMOVE_TUPLE:
        System.out.println("REMOVE_TUPLE : " + updatedObject.toString());
        break;
      case ADD_ATOM:
        System.out.println("ADD_ATOM : " + updatedObject.toString());
        break;
      case REMOVE_ATOM:
        System.out.println("REMOVE_ATOM : " + updatedObject.toString());
        break;
      case UPPER_BOUND:
        System.out.println("MOVE_TO_UPPER : " + updatedObject.toString());
        break;
      case LOWER_BOUND:
        System.out.println("MOVE_TO_LOWER : " + updatedObject.toString());
        break;
      case CHANGE_RELATION_SETS:
        System.out.println("CHANGE_RELATION_SETS : " + updatedObject.toString());
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
