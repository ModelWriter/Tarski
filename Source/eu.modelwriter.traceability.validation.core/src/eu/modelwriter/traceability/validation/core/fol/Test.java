package eu.modelwriter.traceability.validation.core.fol;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import eu.modelwriter.traceability.validation.core.fol.model.Builder;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLLexer;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.EquivalanceTransformer;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.ImplicationTransformer;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.Interpreter;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.NegationTransformer;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.ParenthesesTransformer;
import eu.modelwriter.traceability.validation.core.fol.typechecker.ArityCheck;

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

    ArityCheck myVisitor = new ArityCheck();
    myVisitor.visit(tree);

    // SentenceTransformer transformer = new SentenceTransformer();
    // transformer.visit(tree);

    /** ----------Loader for Data Structure------------------------------- **/
    Builder ldr = new Builder();
    ParseTreeWalker wlk = new ParseTreeWalker();
    wlk.walk(ldr, tree);
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

    SentencePrinter printer = new SentencePrinter();
    System.out.println(printer.visit(tree));

    EquivalanceTransformer equivalanceTransformer = new EquivalanceTransformer();
    equivalanceTransformer.visit(tree);

    ImplicationTransformer implicationTransformer = new ImplicationTransformer();
    implicationTransformer.visit(tree);

    NegationTransformer negationTransformer = new NegationTransformer();
    negationTransformer.visit(tree);

    ParenthesesTransformer parenthesesTransformer = new ParenthesesTransformer();
    parenthesesTransformer.visit(tree);

    // Utilities.showParseTree(parser, tree);

    Interpreter semanticProcess = new Interpreter(ldr.getModel());
    semanticProcess.visit(tree);

    /***********************************/


  }


}
