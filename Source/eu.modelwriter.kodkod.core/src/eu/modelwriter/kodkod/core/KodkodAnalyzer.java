package eu.modelwriter.kodkod.core;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.core.recognizer.KodkodLexer;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ProblemContext;

public class KodkodAnalyzer {
  public enum PARSE_AREA {
    FULL_DOCUMENT, OPTIONS, UNIVERSE, RELATION, FORMULAS
  }

  // private final ModelBuildParseTreeListener mbptl = new ModelBuildParseTreeListener();

  public Universe parseKodkod(final String kodkodString, final PARSE_AREA area) {
    final ANTLRInputStream input = new ANTLRInputStream(kodkodString);
    final KodkodLexer lexer = new KodkodLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final KodkodParser parser = new KodkodParser(tokens);
    // final ParseTreeWalker ptw = new ParseTreeWalker();
    // final ParseTree tree = null;
    final ProblemContext problem = parser.problem();
    if (parser.getNumberOfSyntaxErrors() == 0) {
      final ModelBuildVisitor mbv = new ModelBuildVisitor();
      return mbv.visitProblem(problem);
    }
    return null;

    // switch (area) {
    // case FULL_DOCUMENT:
    // tree = parser.problem();
    // if (parser.getNumberOfSyntaxErrors() == 0) {
    // ptw.walk(this.mbptl, tree);
    // } else {
    // return null;
    // }
    // break;
    // case OPTIONS:
    // tree = parser.options();
    // break;
    // case UNIVERSE:
    // tree = parser.universe();
    // if (parser.getNumberOfSyntaxErrors() == 0) {
    // ptw.walk(this.mbptl, tree);
    // } else {
    // return null;
    // }
    // break;
    // case RELATION:
    // tree = parser.relations();
    // if (parser.getNumberOfSyntaxErrors() == 0) {
    // ptw.walk(this.mbptl, tree);
    // } else {
    // return null;
    // }
    // break;
    // case FORMULAS:
    // tree = parser.formula();
    // break;
    // default:
    // tree = parser.problem();
    // break;
    // }

    // return this.mbptl.getUniverse();
  }
}
