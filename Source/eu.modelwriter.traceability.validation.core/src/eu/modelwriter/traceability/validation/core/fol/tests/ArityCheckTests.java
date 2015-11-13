package eu.modelwriter.traceability.validation.core.fol.tests;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;

import eu.modelwriter.traceability.validation.core.fol.model.ModelBuilder;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLLexer;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser;
import eu.modelwriter.traceability.validation.core.fol.typechecker.TypeCheck;

public class ArityCheckTests {

  private TypeCheck typeCheck;
  private FOLParser parser;

  @Before
  public void init() {
    ANTLRInputStream input = null;
    final File file =
        new File("../eu.modelwriter.traceability.validation.core/examples/fol/Set.core");
    try {
      input = new ANTLRFileStream(file.getAbsolutePath());
    } catch (final IOException e) {
      e.printStackTrace();
    }
    final FOLLexer lexer = new FOLLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    this.parser = new FOLParser(tokens);
    final ParseTree parseTree = this.parser.specification();
    final ParseTreeWalker walker = new ParseTreeWalker();

    final ModelBuilder model = new ModelBuilder();
    walker.walk(model, parseTree);

    this.typeCheck = new TypeCheck(model.getUniverse());
  }

  @Test
  public void testVisitQuantification() {
    System.out.println(this.typeCheck);
  }

  @Test
  public void testVisitQuantifier() {

  }

  @Test
  public void testVisitRelation() {

  }
}
