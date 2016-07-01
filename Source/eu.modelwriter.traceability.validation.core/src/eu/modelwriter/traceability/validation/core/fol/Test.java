package eu.modelwriter.traceability.validation.core.fol;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import eu.modelwriter.traceability.validation.core.fol.cnf.PrettyPrinter;
import eu.modelwriter.traceability.validation.core.fol.interpreter.Interpreter;
import eu.modelwriter.traceability.validation.core.fol.model.ModelBuilder;
import eu.modelwriter.traceability.validation.core.fol.model.Universe;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLLexer;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.EquivalenceTransformer;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.ImplicationTransformer;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.NegationTransformer;
import eu.modelwriter.traceability.validation.core.fol.semanticanalysis.ParenthesesTransformer;
import eu.modelwriter.traceability.validation.core.fol.typechecker.TypeCheck;

public class Test {

  private static List<ValidationError> errors;

  private static boolean result;

  private static TreeViewer viewer;

  public static ParseTree createNewTree(final StringBuilder builder) {
    final ANTLRInputStream input = new ANTLRInputStream(builder.toString());
    final FOLLexer lexer = new FOLLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final FOLParser parser = new FOLParser(tokens);
    final ParseTree tree = parser.specification();
    return tree;
  }

  public static void doParse(final String content) {
    errors = new ArrayList<>();
    result = false;

    final ANTLRInputStream input = new ANTLRInputStream(content);
    final FOLLexer lexer = new FOLLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final FOLParser parser = new FOLParser(tokens);
    parser.addErrorListener(new ANTLRErrorListener() {

      @Override
      public void reportAmbiguity(final Parser arg0, final DFA arg1, final int arg2, final int arg3,
          final boolean arg4, final BitSet arg5, final ATNConfigSet arg6) {}

      @Override
      public void reportAttemptingFullContext(final Parser arg0, final DFA arg1, final int arg2,
          final int arg3, final BitSet arg4, final ATNConfigSet arg5) {}

      @Override
      public void reportContextSensitivity(final Parser arg0, final DFA arg1, final int arg2,
          final int arg3, final int arg4, final ATNConfigSet arg5) {}

      @Override
      public void syntaxError(final Recognizer<?, ?> arg0, final Object arg1, final int arg2,
          final int arg3, final String arg4, final RecognitionException arg5) {
        final String error = "Syntax error:\nline " + arg2 + ":" + arg3 + " " + arg4 + "\n\n";
        errors.add(new ValidationError(arg2, arg3, error));
      }
    });
    final ParseTree tree = parser.specification();

    final ParseTreeWalker walker = new ParseTreeWalker();

    /** ----------Loader for Data Structure------------------------------- **/
    final ModelBuilder model = new ModelBuilder();
    walker.walk(model, tree);

    final TypeCheck typeCheck = new TypeCheck(model.getUniverse());
    typeCheck.visit(tree);
    final List<ValidationError> typeErrors = typeCheck.getErrors();
    for (final ValidationError typeError : typeErrors) {
      errors.add(typeError);
    }

    if (typeCheck.isErrState() || model.isErrState() || parser.getNumberOfSyntaxErrors() > 0) {
      viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
      viewer.setScale(0.8);
      return;
    }

    final PrettyPrinter printer = new PrettyPrinter();
    printer.visit(tree);
    // final List<String> sentences = printer.getSentences();

    final EquivalenceTransformer equivalanceTransformer = new EquivalenceTransformer();
    equivalanceTransformer.visit(tree);

    final ImplicationTransformer implicationTransformer = new ImplicationTransformer();
    implicationTransformer.visit(tree);

    final NegationTransformer negationTransformer = new NegationTransformer();
    negationTransformer.visit(tree);

    final ParenthesesTransformer parenthesesTransformer = new ParenthesesTransformer();
    parenthesesTransformer.visit(tree);

    viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
    viewer.setScale(0.8); // scale a little

    final Interpreter semanticProcess = new Interpreter(model.getUniverse());
    result = semanticProcess.visit(tree);
  }

  public static List<ValidationError> getErrors() {
    return errors;
  }

  public static boolean getResult() {
    return result;
  }

  public static Object getViewer() {
    return viewer;
  }

  public static void main(final String[] args) {
    ANTLRInputStream input = null;
    final File file =
        new File("../eu.modelwriter.traceability.validation.core/examples/fol/java.core");
    try {
      input = new ANTLRFileStream(file.getAbsolutePath());
    } catch (final IOException e) {
      e.printStackTrace();
    }
    final FOLLexer lexer = new FOLLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final FOLParser parser = new FOLParser(tokens);
    parser.addErrorListener(new ANTLRErrorListener() {

      @Override
      public void reportAmbiguity(final Parser arg0, final DFA arg1, final int arg2, final int arg3,
          final boolean arg4, final BitSet arg5, final ATNConfigSet arg6) {}

      @Override
      public void reportAttemptingFullContext(final Parser arg0, final DFA arg1, final int arg2,
          final int arg3, final BitSet arg4, final ATNConfigSet arg5) {}

      @Override
      public void reportContextSensitivity(final Parser arg0, final DFA arg1, final int arg2,
          final int arg3, final int arg4, final ATNConfigSet arg5) {}

      @Override
      public void syntaxError(final Recognizer<?, ?> arg0, final Object arg1, final int arg2,
          final int arg3, final String arg4, final RecognitionException arg5) {
        System.out.println("syntaxError:");
        System.out.println("line " + arg2 + ":" + arg3 + " " + arg4);
      }
    });

    final ParseTree tree = parser.specification();
    final ParseTreeWalker walker = new ParseTreeWalker();

    /** ----------Loader for Data Structure------------------------------- **/
    final ModelBuilder model = new ModelBuilder();
    walker.walk(model, tree);

    final TypeCheck typeCheck = new TypeCheck(model.getUniverse());
    typeCheck.visit(tree);

    if (typeCheck.isErrState() || model.isErrState()) {
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

    final Interpreter semanticProcess = new Interpreter(model.getUniverse());
    final boolean result = semanticProcess.visit(tree);
    System.out.println(result);
  }

  public static Universe parseAndGetUniverse(final String content) {
    final ANTLRInputStream input = new ANTLRInputStream(content);
    final FOLLexer lexer = new FOLLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final FOLParser parser = new FOLParser(tokens);
    final ParseTree tree = parser.specification();
    final ParseTreeWalker walker = new ParseTreeWalker();

    /** ----------Loader for Data Structure------------------------------- **/
    final ModelBuilder model = new ModelBuilder();
    walker.walk(model, tree);

    return model.getUniverse();
  }
}
