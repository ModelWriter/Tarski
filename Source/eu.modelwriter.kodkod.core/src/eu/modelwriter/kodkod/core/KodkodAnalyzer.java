package eu.modelwriter.kodkod.core;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.core.recognizer.KodkodLexer;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.UniverseContext;

public class KodkodAnalyzer {
  public enum PARSE_AREA {
    FULL_DOCUMENT, OPTIONS, UNIVERSE, RELATION, FORMULAS
  }

  public static ParseTree tree;

  public Universe parseKodkod(final String kodkodString, final PARSE_AREA area) {
    final ANTLRInputStream input = new ANTLRInputStream(kodkodString);
    final KodkodLexer lexer = new KodkodLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final KodkodParser parser = new KodkodParser(tokens);
    final ModelBuildVisitor mbv = new ModelBuildVisitor();

    switch (area) {
      case FULL_DOCUMENT:
        KodkodAnalyzer.tree = parser.problem();
        break;
      case OPTIONS:
        KodkodAnalyzer.tree = parser.options();
        return null;
      case UNIVERSE:
        KodkodAnalyzer.tree = parser.universe();
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
        KodkodAnalyzer.tree = parser.problem();
        return null;
      default:
        KodkodAnalyzer.tree = parser.problem();
        break;
    }

    if (parser.getNumberOfSyntaxErrors() == 0) {
      mbv.visit(KodkodAnalyzer.tree);
      return mbv.getUniverse();
    } else {
      return null;
    }
  }
}
