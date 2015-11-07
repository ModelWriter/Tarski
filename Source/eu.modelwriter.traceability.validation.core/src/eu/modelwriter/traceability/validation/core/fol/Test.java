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
    ANTLRInputStream input = new ANTLRInputStream(builder.toString());
    FOLLexer lexer = new FOLLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    FOLParser parser = new FOLParser(tokens);
    ParseTree tree = parser.specification();
    return tree;
  }

  public static void main(String[] args) {
    ANTLRInputStream input = null;
    File file = new File("../eu.modelwriter.traceability.validation.core/examples/fol/Set.core");
    try {
      input = new ANTLRFileStream(file.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
    FOLLexer lexer = new FOLLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    FOLParser parser = new FOLParser(tokens);
    ParseTree tree = parser.specification();
    ParseTreeWalker walker = new ParseTreeWalker();

    // SentenceTransformer transformer = new SentenceTransformer();
    // transformer.visit(tree);

    /** ----------Loader for Data Structure------------------------------- **/
    ModelBuilder model = new ModelBuilder();
    walker.walk(model, tree);
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

    PrettyPrinter printer = new PrettyPrinter();
    printer.visit(tree);
    printer.print();

    EquivalenceTransformer equivalanceTransformer = new EquivalenceTransformer();
    equivalanceTransformer.visit(tree);

    ImplicationTransformer implicationTransformer = new ImplicationTransformer();
    implicationTransformer.visit(tree);

    NegationTransformer negationTransformer = new NegationTransformer();
    negationTransformer.visit(tree);

    ParenthesesTransformer parenthesesTransformer = new ParenthesesTransformer();
    parenthesesTransformer.visit(tree);

    Utilities.showParseTree(parser, tree);

    Interpreter semanticProcess = new Interpreter(model.getUniverse());
    semanticProcess.visit(tree);

    /***********************************/


  }


}
