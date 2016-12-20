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

package eu.modelwriter.core.alloyinecore;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;

//import eu.modelwriter.core.kodkod.recognizer.KodkodLexer;
//import eu.modelwriter.core.kodkod.recognizer.KodkodParser;
//import eu.modelwriter.core.kodkod.translator.KodkodTranslator;
//import kodkod.ast.Formula;
//import kodkod.engine.AbortedException;
//import kodkod.engine.Solution;
//import kodkod.engine.Solver;
//import kodkod.engine.fol2sat.HigherOrderDeclException;
//import kodkod.engine.fol2sat.UnboundLeafException;
//import kodkod.engine.satlab.SATFactory;
//import kodkod.util.nodes.PrettyPrinter;


public class AlloyInECoreFrontEnd_Test {

  public static void main(final String[] args) {
    ANTLRInputStream input = null;
    final File file = new File("programs/AlloyInECore/simple.recore");
    try {
      input = new ANTLRFileStream(file.getAbsolutePath());
    } catch (final IOException e) {
      e.printStackTrace();
    }
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
    final ParseTree tree = parser.module();
    Utilities.showParseTree(parser, tree);

//    try {
//      final KodkodTranslator translator = new KodkodTranslator(parser.bounds);
//      final Formula f = (Formula) translator.visit(tree);
//      final Solver solver = new Solver();
//      solver.options().setSolver(SATFactory.DefaultSAT4J);
//      solver.options().setSymmetryBreaking(20);
//      System.out.println("Symmetry Breaking is set to " + solver.options().symmetryBreaking());
//      System.out.println(PrettyPrinter.print(f, 2));
//      // final Solution s = solver.solve(f, parser.bounds);
//
//      final Iterator<Solution> solIter = solver.solveAll(f, parser.bounds);
//      int i = 1;
//      while (solIter.hasNext()) {
//        System.out.println("**SOLUTION " + i + " **");
//        Solution sol = solIter.next();
//        System.out.println(sol);
//        i++;
//      }
//
//      // System.out.println(s);
//    } catch (HigherOrderDeclException e) {
//      e.printStackTrace();
//    } catch (UnboundLeafException e) {
//      e.printStackTrace();
//    } catch (AbortedException e) {
//      e.printStackTrace();
//    }

    /***********************************/


  }


}
