package eu.modelwriter.visualization.jgraphx.model;

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

import eu.modelwriter.model.ModelElement;
import eu.modelwriter.model.ModelElement.BOUND;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.ModelUtil;
import eu.modelwriter.model.Relation;
import eu.modelwriter.model.exception.InvalidArityException;
import eu.modelwriter.model.exception.NoSuchModelElementException;
import eu.modelwriter.model.observer.Observer;
import eu.modelwriter.model.observer.Subject;
import eu.modelwriter.model.observer.UpdateType;
import eu.modelwriter.visualization.jgraphx.editor.StaticEditorManager;
import eu.modelwriter.visualization.jgraphx.editor.util.EdgeUtil;

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

  public void addAtom(final List<String> relationsNames, final Serializable data,
      final BOUND bound) {
    try {
      final List<String> relationsIDs = ModelUtil.instance.findRelationsIDs(relationsNames);
      final String atomID =
          manager.addAtom(relationsIDs, data, bound);
      createVertex(atomID);
    } catch (final InvalidArityException | NoSuchModelElementException e) {
      e.printStackTrace();
    }
  }

  public void addTuple(final String relationName, final Serializable data, final BOUND bound,
      final int arity, final String... atomIDs) {
    try {
      final String relationID = ModelUtil.instance.findRelationID(relationName);
      final String tupleID = manager.addTuple(relationID, data, bound, arity, atomIDs);
      createEdge(tupleID);
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
   * Takes {@linkplain Relation relationSets} from {@linkplain ModelManager manager} and then <br>
   * Creates {@linkplain Graph#insertVertex(Object, String, Object) vertices} for each
   * {@linkplain Atom atom} and {@linkplain Graph#insertEdge(Object, String, Object, Object, Object)
   * edges} for each {@linkplain Tuple tuple}. <br>
   * Sets style and color of each edge.
   */
  public void build() {
    setDefaultEdgeStyle();

    parent = StaticEditorManager.graph.getDefaultParent();

    final List<String> atomIDs = ModelUtil.instance.getAtomIDs();
    final List<String> tupleIDs = ModelUtil.instance.getTupleIDs();

    unaryRelationNames.addAll(ModelUtil.instance.getUnaryRelationNames());
    n_aryRelationNames.addAll(ModelUtil.instance.getNaryRelationNames());

    mxCodecRegistry.addPackage("eu.modelwriter.model");
    mxCodecRegistry.register(new mxObjectCodec(new eu.modelwriter.model.ModelElement()));

    for (final String atomID : atomIDs) {
      createVertex(atomID);
    }

    for (final String tupleID : tupleIDs) {
      int tupleArity = 0;
      try {
        tupleArity = ModelUtil.instance.getTuple(tupleID).getArity();
      } catch (final NoSuchModelElementException e) {
        e.printStackTrace();
      }
      if (tupleArity == 2) {
        createEdge(tupleID);
      }
    }

    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      for (final String edgeStyleName : n_aryRelationNames) {
        createSpecificEdgeStyle(edgeStyleName);
      }

      specifyEdgeStyle();
      specificEdgeStylesWithRandomColor();
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
    }
  }

  public void changeAtomType(final mxCell vertex, final List<String> selectedValuesList) {
    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      final ModelElement atom = (ModelElement) vertex.getValue();
      manager.changeRelationsInOfAtom(atom.getID(), selectedValuesList);
      StaticEditorManager.graph.removeCells(StaticEditorManager.graph.getEdges(vertex));
    } catch (final InvalidArityException | NoSuchModelElementException e) {
      e.printStackTrace();
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
    }
  }

  private void createEdge(final String tupleID) {
    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      final String relationName = ModelUtil.instance.getTuple(tupleID).getRelationIn().getName();
      final List<String> atomIDsOfTuple = ModelUtil.instance.getTuple(tupleID).getAtomsIDs();

      final mxCell sourceVertex = atomId2Vertex.get(atomIDsOfTuple.get(0));

      final mxCell targetVertex = atomId2Vertex.get(atomIDsOfTuple.get(1));

      boolean hasParallel = false;
      for (final Object object : StaticEditorManager.graph.getEdgesBetween(sourceVertex,
          targetVertex)) {
        final String edgeName = EdgeUtil.getInstance().getEdgeName((mxCell) object);
        if (edgeName.equals(relationName)) {
          parallelRelation.add(object);
          n_aryRelationNames.add(relationName + "$headed");
          hasParallel = true;
          break;
        }
      }

      if (!hasParallel) {
        final ModelElement tuple = ModelUtil.instance.getModelElement(tupleID);
        final Object edge = StaticEditorManager.graph.insertEdge(parent, tupleID, tuple,
            sourceVertex, targetVertex, relationName);
        if (sourceVertex.equals(targetVertex)) {
          selfEdges.add(edge);
        }
      }
    } catch (final Exception e) {
      e.printStackTrace();
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

  private void createVertex(final String atomID) {
    StaticEditorManager.graph.getModel().beginUpdate();
    try {
      mxCell vertex = atomId2Vertex.get(atomID);

      if (vertex == null) {
        final ModelElement atom = ModelUtil.instance.getModelElement(atomID);
        vertex = (mxCell) StaticEditorManager.graph.insertVertex(parent, null, atom, 0, 0, 0, 0);
        atomId2Vertex.put(atomID, vertex);
      }
    } catch (final NoSuchModelElementException e) {
      e.printStackTrace();
    } finally {
      StaticEditorManager.graph.getModel().endUpdate();
    }
  }

  public Map<String, mxCell> getAtomId2Vertex() {
    return atomId2Vertex;
  }

  public ModelManager getManager() {
    return manager;
  }

  /**
   * @return {@link GraphBuilder#n_aryRelationNames n_aryRelationNames}
   */
  public List<String> getN_aryRelationNames() {
    return n_aryRelationNames;
  }

  /**
   * @return {@linkplain GraphBuilder#relName2Color relName2Color}
   */
  public Map<String, Color> getRelName2Color() {
    return relName2Color;
  }

  /**
   * @return {@link GraphBuilder#unaryRelationNames unaryRelationNames}
   */
  public List<String> getUnaryRelationNames() {
    return unaryRelationNames;
  }

  /**
   * Generates random unique color for given relation name.
   *
   * @param relationName
   * @return generated random unique color.
   */
  private Color randomColor4Relation(final String relationName) {
    final Color oldColor = relName2Color.get(relationName);

    final Color color = UniqueColor.randomColor();
    relName2Color.put(relationName, color);

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
    for (final String edgeStyleName : n_aryRelationNames) {
      final Color color = randomColor4Relation(edgeStyleName);
      assignColor2EdgeStyle(edgeStyleName, color);
    }
  }

  private void specifyEdgeStyle() {
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_CLASSIC,
        parallelRelation.toArray());
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_EAST,
        selfEdges.toArray());
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_RIGHT,
        selfEdges.toArray());
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_BENDABLE, "0", selfEdges.toArray());
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
      case CHANGE_RELATION_IN:
        System.out.println("CHANGE_RELATION_IN : " + updatedObject.toString());
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
