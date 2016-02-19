package eu.modelwriter.kodkod.core;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.core.recognizer.KodkodLexer;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ProblemContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.UniverseContext;

public class KodkodAnalyzer {
  public enum PARSE_AREA {
    FULL_DOCUMENT, OPTIONS, UNIVERSE, RELATION, FORMULAS
  }

  public static ProblemContext problem;

  public Universe parseKodkod(final String kodkodString, final PARSE_AREA area) {
    final ANTLRInputStream input = new ANTLRInputStream(kodkodString);
    final KodkodLexer lexer = new KodkodLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final KodkodParser parser = new KodkodParser(tokens);
    final ModelBuildVisitor mbv = new ModelBuildVisitor();

    ParseTree tree;
    switch (area) {
      case FULL_DOCUMENT:
        tree = KodkodAnalyzer.problem = parser.problem();
        break;
      case OPTIONS:
        tree = parser.options();
        return null;
      case UNIVERSE:
        tree = parser.universe();
        break;
      case RELATION:
        final UniverseContext universe = parser.universe();
        final RelationsContext relations = parser.relations();
        if (parser.getNumberOfSyntaxErrors() == 0) {
              mbv.visitUniverse(universe);
              mbv.visitRelations(relations);
          return mbv.getUniverse();
        }
      case FORMULAS:
        tree = KodkodAnalyzer.problem = parser.problem();
        return null;
      default:
        tree = KodkodAnalyzer.problem = parser.problem();
        break;
    }

    if (parser.getNumberOfSyntaxErrors() == 0) {
      mbv.visit(tree);
      return mbv.getUniverse();
    } else {
      return null;
    }
  }
}
