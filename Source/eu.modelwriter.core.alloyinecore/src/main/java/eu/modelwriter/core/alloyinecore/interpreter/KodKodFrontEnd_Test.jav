
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore.interpreter;

import Utilities;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import kodkod.ast.Formula;
import kodkod.engine.AbortedException;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.fol2sat.HigherOrderDeclException;
import kodkod.engine.fol2sat.UnboundLeafException;
import kodkod.engine.satlab.SATFactory;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class KodKodFrontEnd_Test {

  public static class VerboseListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e) {
      List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
      Collections.reverse(stack);
      System.err.println("rule stack: "+stack);
      System.err.println("line "+line+":"+charPositionInLine+" at "+
              offendingSymbol+": "+msg);
    }
  }

  public static class UnderlineListener extends BaseErrorListener {
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e) {
      underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine, msg);
    }

    protected void underlineError(Recognizer recognizer,
                                  Token offendingToken, int line,
                                  int charPositionInLine, String msg) {
      CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
      String input = tokens.getTokenSource().getInputStream().toString();
      String[] lines = input.split("\n");
      String errorLine = lines[line - 1];
      System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
      System.err.println(errorLine);


      for (int i = 0; i < charPositionInLine; i++) System.err.print(" ");

      int start = offendingToken.getStartIndex();
      int stop = offendingToken.getStopIndex();

      if (start >= 0 && stop >= 0) {
        for (int i = start; i <= stop; i++) System.err.print("^");
      }
      System.err.println();
    }
  }


  public static void main(final String[] args) {
    ANTLRInputStream input = null;
    final File file = new File("./src/test/resources/AlloyInECore/Filesystem.kodkod");
    try {
      input = new ANTLRFileStream(file.getAbsolutePath());
    } catch (final IOException e) {
      e.printStackTrace();
    }
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
    parser.removeErrorListeners(); // remove ConsoleErrorListener
//  parser.addErrorListener(new VerboseListener());
    parser.addErrorListener(new UnderlineListener());
    final ParseTree tree = parser.problem();
    Utilities.showParseTree(parser, tree);

    try {
      final KodkodTranslator translator = new KodkodTranslator(parser.bounds);
      final Formula f = (Formula) translator.visit(tree);
      final Solver solver = new Solver();
      solver.options().setSolver(SATFactory.MiniSat);
      solver.options().setSymmetryBreaking(20);
      System.out.println("Symmetry Breaking is set to " + solver.options().symmetryBreaking());
//    System.out.println(PrettyPrinter.print(f, 2));
      // final Solution s = solver.solve(f, parser.bounds);

      final Iterator<Solution> solIter = solver.solveAll(f, parser.bounds);
      int i = 1;
      while (solIter.hasNext()) {
        System.out.println("**SOLUTION " + i + " **");
        Solution sol = solIter.next();
        System.out.println(sol);
        i++;
      }

      // System.out.println(s);
    } catch (HigherOrderDeclException e) {
      e.printStackTrace();
    } catch (UnboundLeafException e) {
      e.printStackTrace();
    } catch (AbortedException e) {
      e.printStackTrace();
    }

    /***********************************/


  }


}
