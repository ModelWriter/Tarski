package eu.modelwriter.kodkod.core;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.core.recognizer.KodkodLexer;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser;

public class KodkodAnalyzer {
  public static enum PARSE_AREA {
    FULL_DOCUMENT, OPTIONS, UNIVERSE, RELATION, FORMULAS
  }

  private static ModelBuildParseTreeListener mbptl = new ModelBuildParseTreeListener();
  private static Universe universe;

  public Universe parseKodkod(final String kodkodString, final PARSE_AREA area) {
    final ANTLRInputStream input = new ANTLRInputStream(kodkodString);
    final KodkodLexer lexer = new KodkodLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final KodkodParser parser = new KodkodParser(tokens);
    final ParseTreeWalker ptw = new ParseTreeWalker();
    ParseTree tree = null;
    switch (area) {
      case FULL_DOCUMENT:
        tree = parser.problem();
        ptw.walk(KodkodAnalyzer.mbptl, tree);
        break;
      case OPTIONS:
        tree = parser.options();
        break;
      case UNIVERSE:
        tree = parser.universe();
        ptw.walk(KodkodAnalyzer.mbptl, tree);
        break;
      case RELATION:
        tree = parser.relBound();
        ptw.walk(KodkodAnalyzer.mbptl, tree);
        break;
      case FORMULAS:
        tree = parser.formula();
        break;
      default:
        tree = parser.problem();
        break;
    }

    System.out.println(tree.toStringTree());

    // ptw.walk(?, tree);
    KodkodAnalyzer.universe = KodkodAnalyzer.mbptl.getUniverse();

    return KodkodAnalyzer.universe;
  }
}
