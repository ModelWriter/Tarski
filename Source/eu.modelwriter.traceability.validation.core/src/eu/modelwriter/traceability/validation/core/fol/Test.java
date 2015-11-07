package eu.modelwriter.traceability.validation.core.fol;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import eu.modelwriter.traceability.validation.core.fol.cnf.PrettyPrinter;
import eu.modelwriter.traceability.validation.core.fol.interpreter.Interpreter;
import eu.modelwriter.traceability.validation.core.fol.model.ModelBuilder;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLLexer;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.EquivalenceTransformer;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.ImplicationTransformer;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.NegationTransformer;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.ParenthesesTransformer;
import eu.modelwriter.traceability.validation.core.fol.typechecker.ArityCheck;
import eu.modelwriter.traceability.validation.core.fol.typechecker.TypeCheck;

public class Test {
  public static ParseTree createNewTree(StringBuilder builder) {
    final ANTLRInputStream input = new ANTLRInputStream(builder.toString());
    final FOLLexer lexer = new FOLLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final FOLParser parser = new FOLParser(tokens);
    final ParseTree tree = parser.specification();
    return tree;
  }

  public static void main(String[] args) {
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
    final FOLParser parser = new FOLParser(tokens);
    final ParseTree tree = parser.specification();
    final ParseTreeWalker walker = new ParseTreeWalker();

    // SentenceTransformer transformer = new SentenceTransformer();
    // transformer.visit(tree);

    /** ----------Loader for Data Structure------------------------------- **/
    final ModelBuilder model = new ModelBuilder();
    wlk.walk(model, tree);
    /** ------------------------------------------------------------------ **/
    /** ---------------------Cnf Conversion ------------------------------ **/
    // EquivalanceConverter ec = new EquivalanceConverter();
    // ec.visit(tree);
    // ImplicationConverter ic = new ImplicationConverter();
    // ic.visit(Test.createNewTree(ec.getBuilder()));
    // NegationConverter nc = new NegationConverter();
    // nc.visit(Test.createNewTree(ic.getBuilder()));
    // Test.showParseTree(parser, Test.createNewTree(nc.getBuilder()));
    /** ------------------------------------------------------------------ **/

    /***********************************/

    ArityCheck arityCheck = new ArityCheck();
    arityCheck.visit(tree);
    TypeCheck typeCheck = new TypeCheck(model.getUniverse());
    typeCheck.visit(tree);
    
    if (arityCheck.isErrState() || typeCheck.isErrState()) {
      System.exit(1);
    }

    final PrettyPrinter printer = new PrettyPrinter();
    printer.visit(tree);
    printer.print();

    final EquivalenceTransformer equivalanceTransformer = new EquivalenceTransformer();
    equivalanceTransformer.visit(tree);

    final ImplicationTransformer implicationTransformer = new ImplicationTransformer();
    implicationTransformer.visit(tree);

    final NegationTransformer negationTransformer = new NegationTransformer();
    negationTransformer.visit(tree);

    final ParenthesesTransformer parenthesesTransformer = new ParenthesesTransformer();
    parenthesesTransformer.visit(tree);

    Utilities.showParseTree(parser, tree);

    final Interpreter semanticProcess = new Interpreter(model.getModel());
    semanticProcess.visit(tree);

    /***********************************/


  }


}
