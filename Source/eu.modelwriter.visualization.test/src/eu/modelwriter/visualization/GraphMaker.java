package eu.modelwriter.visualization;

import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JPanel;

import edu.mit.csail.sdg.alloy4.ErrorFatal;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4graph.DotColor;
import edu.mit.csail.sdg.alloy4graph.DotDirection;
import edu.mit.csail.sdg.alloy4graph.DotPalette;
import edu.mit.csail.sdg.alloy4graph.DotShape;
import edu.mit.csail.sdg.alloy4graph.DotStyle;
import edu.mit.csail.sdg.alloy4graph.Graph;
import edu.mit.csail.sdg.alloy4graph.GraphEdge;
import edu.mit.csail.sdg.alloy4graph.GraphNode;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyModel;
import eu.modelwriter.visualization.model.Atom;
import eu.modelwriter.visualization.model.Relation;
import eu.modelwriter.visualization.model.Tuple;
import eu.modelwriter.visualization.model.Universe;

public class GraphMaker {
  private Universe universe;

  /** The theme customization. */
  private static State view;

  /** The projected instance for the graph currently being generated. */
  private AlloyInstance instance;

  /** The projected model for the graph currently being generated. */
  private AlloyModel model;

  /** The map that contains all edges and what the AlloyTuple that each edge corresponds to. */
  private final Map<GraphEdge, Tuple> edges = new LinkedHashMap<GraphEdge, Tuple>();

  /** The map that contains all nodes and what the AlloyAtom that each node corresponds to. */
  private final Map<GraphNode, Atom> nodes = new LinkedHashMap<GraphNode, Atom>();

  /**
   * This maps each atom to the node representing it; if an atom doesn't have a node, it won't be in
   * the map.
   */
  private final Map<Atom, GraphNode> atom2node = new LinkedHashMap<Atom, GraphNode>();

  /** This stores a set of additional labels we want to add to an existing node. */
  private final Map<GraphNode, Set<String>> attribs = new LinkedHashMap<GraphNode, Set<String>>();

  /** The resulting graph. */
  private Graph graph;

  public static JPanel produceGraph(Universe universe) throws ErrorFatal {
    view = new State(universe);
    // if (proj == null) proj = new AlloyProjection();
    Graph graph = new Graph(view.getFontSize() / 12.0D);
    new GraphMaker(graph, universe);
    if (graph.nodes.size() == 0)
      new GraphNode(graph, "", "Due to your theme settings, every atom is hidden.",
          "Please click Theme and adjust your settings.");
    return new GraphViewer(graph);
  }

  /** The list of colors, in order, to assign each legend. */
  private static final List<Color> colorsClassic =
      Util.asList(new Color(228, 26, 28), new Color(166, 86, 40), new Color(255, 127, 0),
          new Color(77, 175, 74), new Color(55, 126, 184), new Color(152, 78, 163));

  /** The list of colors, in order, to assign each legend. */
  private static final List<Color> colorsStandard = Util.asList(new Color(227, 26, 28),
      new Color(255, 127, 0), new Color(251 * 8 / 10, 154 * 8 / 10, 153 * 8 / 10),
      new Color(51, 160, 44), new Color(31, 120, 180));

  /** The list of colors, in order, to assign each legend. */
  private static final List<Color> colorsMartha =
      Util.asList(new Color(231, 138, 195), new Color(252, 141, 98), new Color(166, 216, 84),
          new Color(102, 194, 165), new Color(141, 160, 203));

  /** The list of colors, in order, to assign each legend. */
  private static final List<Color> colorsNeon =
      Util.asList(new Color(231, 41, 138), new Color(217, 95, 2), new Color(166, 118, 29),
          new Color(102, 166, 30), new Color(27, 158, 119), new Color(117, 112, 179));


  private GraphMaker(Graph graph, Universe universe) throws ErrorFatal {
    this.universe = universe;
    // final boolean hidePrivate = view.hidePrivate();
    // final boolean hideMeta = view.hideMeta();
    final Map<Relation, Color> magicColor = new TreeMap<Relation, Color>();
    final Map<Relation, Integer> rels = new TreeMap<Relation, Integer>();
    this.graph = graph;
    // this.view = view;
    // instance = StaticProjector.project(originalInstance, proj);
    // model = instance.model;
    for (Relation rel : universe.getRelations()) {
      if (rel.getArity() > 1)
        rels.put(rel, null);
    }
    List<Color> colors;
    if (view.getEdgePalette() == DotPalette.CLASSIC)
      colors = colorsClassic;
    else if (view.getEdgePalette() == DotPalette.STANDARD)
      colors = colorsStandard;
    else if (view.getEdgePalette() == DotPalette.MARTHA)
      colors = colorsMartha;
    else
      colors = colorsNeon;
    int ci = 0;
    for (Relation rel : universe.getRelations()) {
      if (rel.getArity() > 1) {
        DotColor c = view.edgeColor.resolve(rel);
        Color cc =
            /* (c == DotColor.MAGIC) ? */ colors.get(ci)/* : c.getColor(view.getEdgePalette()) */;
        int count = edgesAsArcs(rel, colors.get(ci));
        rels.put(rel, count);
        magicColor.put(rel, cc);
        if (count > 0)
          ci = (ci + 1) % (colors.size());
      }
    }
    for (Relation rel : universe.getRelations()) {
      if (rel.getArity() < 2) {
        if (rel.getTupleCount() > 0) {
          for (Tuple tuple : rel.getTuples()) {
            if (view.nodeVisible.resolve(tuple) && !view.hideUnconnected.resolve(tuple))
              createNode(tuple.getAtom(0));
          }
        }
        // else if (view.nodeVisible.resolve(atom.getType()) &&
        // !view.hideUnconnected.resolve(atom.getType())) {
        // createNode(hidePrivate, hideMeta, atom);
        // }
      }
    }

    for (Relation rel : universe.getRelations())
      if (rel.getArity() > 1)
        // if (!(hidePrivate && rel.isPrivate))
        if (view.attribute.resolve(rel))
          edgesAsAttribute(rel);
    for (Map.Entry<GraphNode, Set<String>> e : attribs.entrySet()) {
      Set<String> set = e.getValue();
      if (set != null)
        for (String s : set)
          if (s.length() > 0)
            e.getKey().addLabel(s);
    }
    for (Entry<Relation, Integer> e : rels.entrySet()) {
      Color c = magicColor.get(e.getKey());
      if (c == null)
        c = Color.BLACK;
      int n = e.getValue();
      if (n > 0)
        graph.addLegend(e.getKey(), e.getKey().getName() + ": " + n, c);
      else
        graph.addLegend(e.getKey(), e.getKey().getName(), null);
    }
  }


  private GraphNode createNode(Atom atom) {
    GraphNode node = atom2node.get(atom);
    if (node != null)
      return node;
    if (/*
         * (hidePrivate && atom.getType().isPrivate) || (hideMeta && atom.getType().isMeta) ||
         */!view.nodeVisible(atom))
      return null;

    DotColor color = view.nodeColor(atom);
    DotStyle style = view.nodeStyle(atom);
    DotShape shape = view.shape(atom);
    String label = atomname(atom);
    node = new GraphNode(graph, atom, label).set(shape).set(color.getColor(view.getNodePalette()))
        .set(style);

    // String setsLabel = "";
    // boolean showLabelByDefault = view.showAsLabel.get(null);
    // String x = view.label.get(atom.getLocatedIn());
    // Boolean showLabel = view.showAsLabel.get(atom.getLocatedIn());
    // if ((showLabel == null && showLabelByDefault)
    // || (showLabel != null && showLabel.booleanValue()))
    // setsLabel += ((setsLabel.length() > 0 ? ", " : "") + x);
    // if (setsLabel.length() > 0) {
    // Set<String> list = attribs.get(node);
    // if (list == null)
    // attribs.put(node, list = new TreeSet<String>());
    // list.add("(" + setsLabel + ")");
    // }

    nodes.put(node, atom);
    atom2node.put(atom, node);
    return node;
  }

  /**
   * Create an edge for a given tuple from a relation (if neither start nor end node is explicitly
   * invisible)
   */
  private boolean createEdge(Relation rel, Tuple tuple, Color magicColor) {
    // This edge represents a given tuple from a given relation.
    //
    // If the tuple's arity==2, then the label is simply the label of the relation.
    //
    // If the tuple's arity>2, then we append the node labels for all the intermediate nodes.
    // eg. Say a given tuple is (A,B,C,D) from the relation R.
    // An edge will be drawn from A to D, with the label "R [B, C]"

    if (/*
         * (hidePrivate && tuple.getStart().getType().isPrivate) || (hideMeta &&
         * tuple.getStart().getType().isMeta) ||
         */!view.nodeVisible(tuple.getAtom(0)))
      return false;
    if (/*
         * (hidePrivate && tuple.getEnd().getType().isPrivate) || (hideMeta &&
         * tuple.getEnd().getType().isMeta) ||
         */!view.nodeVisible(tuple.getAtom(tuple.getAtomCount() - 1)))
      return false;
    GraphNode start = createNode(tuple.getAtom(0));
    GraphNode end = createNode(tuple.getAtom(tuple.getAtomCount() - 1));
    if (start == null || end == null)
      return false;
    boolean layoutBack = view.layoutBack.resolve(rel);
    String label = rel.getName();
    if (tuple.getArity() > 2) {
      StringBuilder moreLabel = new StringBuilder();
      List<Atom> atoms = tuple.getAtoms();
      for (int i = 1; i < atoms.size() - 1; i++) {
        if (i > 1)
          moreLabel.append(", ");
        moreLabel.append(atomname(atoms.get(i)));
      }
      if (label.length() == 0) {
        label = moreLabel.toString();
      } else {
        label = label + (" [" + moreLabel + "]");
      }
    }
    DotDirection dir = /* bidirectional ? DotDirection.BOTH : */(layoutBack ? DotDirection.BACK
        : DotDirection.FORWARD);
    DotStyle style = view.edgeStyle.resolve(rel);
    DotColor color = view.edgeColor.resolve(rel);
    int weight = view.weight.get(rel);
    GraphEdge e = new GraphEdge((start), (end), tuple, label, rel);

    e.set(magicColor);
    e.set(style);
    e.set(dir != DotDirection.FORWARD, dir != DotDirection.BACK);
    e.set(weight < 1 ? 1 : (weight > 100 ? 10000 : 100 * weight));
    edges.put(e, tuple);

    return true;
  }

  /** Create edges for every visible tuple in the given relation. */
  private int edgesAsArcs(Relation rel, Color magicColor) {
    int count = 0;
    if (!view.mergeArrows.resolve(rel)) {
      // If we're not merging bidirectional arrows, simply create an edge for each tuple.
      for (Tuple tuple : rel.getTuples())
        if (createEdge(rel, tuple, magicColor))
          count++;
      return count;
    }
    // Otherwise, find bidirectional arrows and only create one edge for each pair.
    List<Tuple> tuples = rel.getTuples();
    // Set<Tuple> ignore = new LinkedHashSet<Tuple>();
    for (Tuple tuple : tuples) {
      // if (!ignore.contains(tuple)) {
      // AlloyTuple reverse = tuple.getArity() > 2 ? null : tuple.reverse();
      // If the reverse tuple is in the same relation, and it is not a self-edge, then draw it as
      // a <-> arrow.
      // if (reverse != null && tuples.contains(reverse) && !reverse.equals(tuple)) {
      // ignore.add(reverse);
      createEdge(rel, tuple, magicColor);
      count = count + 1;
      // if (createEdge(hidePrivate, hideMeta, rel, tuple, true, magicColor))
      // count = count + 2;
      // } else {
      // if (createEdge(hidePrivate, hideMeta, rel, tuple, false, magicColor))
      // count = count + 1;
      // }
      // }
    }
    return count;
  }

  /** Attach tuple values as attributes to existing nodes. */
  private void edgesAsAttribute(Relation rel) {
    Map<GraphNode, String> map = new LinkedHashMap<GraphNode, String>();
    for (Tuple tuple : rel.getTuples()) {
      GraphNode start = atom2node.get(tuple.getAtoms().get(0));
      if (start == null)
        continue; // null means the node won't be shown, so we can't show any attributes
      String attr = "";
      List<Atom> atoms = tuple.getAtoms();
      for (int i = 1; i < atoms.size(); i++) {
        if (i > 1)
          attr += "->";
        attr += atomname(atoms.get(i));
      }
      if (attr.length() == 0)
        continue;
      String oldattr = map.get(start);
      if (oldattr != null && oldattr.length() > 0)
        attr = oldattr + ", " + attr;
      if (attr.length() > 0)
        map.put(start, attr);
    }
    for (Map.Entry<GraphNode, String> e : map.entrySet()) {
      GraphNode node = e.getKey();
      Set<String> list = attribs.get(node);
      if (list == null)
        attribs.put(node, list = new TreeSet<String>());
      String attr = e.getValue();
      if (rel.getName().length() > 0)
        attr = rel.getName() + ": " + attr;
      list.add(attr);
    }
  }

  /**
   * Return the label for an atom.
   * 
   * @param atom - the atom
   * @param showSets - whether the label should also show the sets that this atom belongs to
   *
   *        <p>
   *        eg. If atom A is the 3rd atom in type T, and T's label is "Person", then the return
   *        value would be "Person3".
   *
   *        <p>
   *        eg. If atom A is the only atom in type T, and T's label is "Person", then the return
   *        value would be "Person".
   *
   *        <p>
   *        eg. If atom A is the 3rd atom in type T, and T's label is "Person", and T belongs to the
   *        sets Set1, Set2, and Set3. However, only Set1 and Set2 have
   *        "show in relational attribute == on", then the return value would be
   *        "Person (Set1, Set2)".
   */
  private String atomname(Atom atom) {
    int index = 0;
    for (Tuple tuple : atom.getLocatedIn().getTuples()) {
      boolean found = false;
      for (Atom atomInTuple : tuple.getAtoms()) {
        if (atom.getText().equals(atomInTuple.getText())) {
          found = true;
          break;
        }
      }
      if (found)
        break;
      index++;
    }

    String label = atom.getLocatedIn().getName();
    if (atom.getLocatedIn().getArity() < 2)
      label += String.valueOf(index);
    return label;
    // String attr = "";
    // boolean showInAttrByDefault = view.showAsAttr.get(null);
    // String x = view.label.get(atom.getLocatedIn());
    // Boolean showAsAttr = view.showAsAttr.get(atom.getLocatedIn());
    // if ((showAsAttr == null && showInAttrByDefault) || (showAsAttr != null && showAsAttr))
    // attr += ((attr.length() > 0 ? ", " : "") + x);
    // if (label.length() == 0)
    // return (attr.length() > 0) ? ("(" + attr + ")") : "";
    // return (attr.length() > 0) ? (label + " (" + attr + ")") : label;
  }

  static String esc(String name) {
    if (name.indexOf('\"') < 0)
      return name;
    StringBuilder out = new StringBuilder();
    for (int i = 0; i < name.length(); i++) {
      char c = name.charAt(i);
      if (c == '\"')
        out.append('\\');
      out.append(c);
    }
    return out.toString();
  }


}
