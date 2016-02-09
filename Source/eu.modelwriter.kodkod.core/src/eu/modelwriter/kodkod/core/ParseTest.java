package eu.modelwriter.kodkod.core;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.core.recognizer.KodkodLexer;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser;

public class ParseTest {
  public void parseKodkod(final String fullDocument) {
    final ANTLRInputStream input = new ANTLRInputStream(fullDocument);
    final KodkodLexer lexer = new KodkodLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final KodkodParser parser = new KodkodParser(tokens);
    final ParseTree tree = parser.problem();
    System.out.println(tree.toStringTree());

    final ModelBuilder mb = new ModelBuilder();
    final ParseTreeWalker ptw = new ParseTreeWalker();
    ptw.walk(mb, tree);
    final Universe universe = mb.getUniverse();
  }
}
