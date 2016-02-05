package eu.modelwriter.kodkod.core;

import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.visualization.model.Atom;
import eu.modelwriter.visualization.model.Universe;
import kodkod.ast.Relation;
import kodkod.instance.Tuple;
import kodkod.instance.TupleSet;

public class ParseTest {

  // It constructs the universe correctly but not capable of visualize atoms, we cannot add
  // dependency from eu.modelwriter.visualization
  public void parseKodkod(final String fullDocument) {
    final ANTLRInputStream input = new ANTLRInputStream(fullDocument);
    final KodkodLexer lexer = new KodkodLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final KodkodParser parser = new KodkodParser(tokens);
    final ParseTree tree = parser.problem();
    System.out.println(tree.toStringTree());

    final Universe universe = new Universe();
    for (final String atom : parser.atoms) {
      universe.addAtom(new Atom(atom));
    }

    parser.bounds.lowerBounds().get(parser.bounds.relations().iterator().next());
    final Set<Relation> relations = parser.bounds.relations();
    final Map<Relation, TupleSet> lowerBounds = parser.bounds.lowerBounds();
    for (final Relation r : relations) {
      final eu.modelwriter.visualization.model.Relation relation =
          new eu.modelwriter.visualization.model.Relation(r.name());
      final TupleSet tupleSet = lowerBounds.get(r);
      for (final Tuple t : tupleSet) {
        final Atom[] atoms = new Atom[t.arity()];
        for (int i = 0; i < t.arity(); i++) {
          final String atomName = t.universe().atom(t.atomIndex(i)).toString();
          final Atom atom = new Atom(atomName);
          atoms[i] = atom;
        }
        relation.addAtomWithTuple(atoms);
      }
      universe.addRelation(relation);
    }

    // final Visualization visualization = Visualization.getInstance(universe);
    // visualization.showModel();
  }
}
