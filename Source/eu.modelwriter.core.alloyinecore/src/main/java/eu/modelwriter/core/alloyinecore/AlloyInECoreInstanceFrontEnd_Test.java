/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
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

package eu.modelwriter.core.alloyinecore;/*
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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.UnderlineErrorListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class AlloyInECoreInstanceFrontEnd_Test {

    public static void main(final String[] args) {
//    Model trySinglemodule = new Model("programs/AlloyInECore/Templates.recore");
//    Model tryECoreModule = new Model("http://www.eclipse.org/emf/2002/Ecore");


        ANTLRInputStream input = null;
        final File file = new File("./src/test/resources/InstanceTestFolder/Instance.requirement");
        try {
            input = new ANTLRFileStream(file.getAbsolutePath());
        } catch (final IOException e) {
            e.printStackTrace();
        }
        final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new UnderlineErrorListener());
        parser.setErrorHandler(new DefaultErrorStrategy());
        parser.getInterpreter().setPredictionMode(PredictionMode.LL); // try full LL(*)
        parser.instance(null);

//        parser.getInterpreter().setPredictionMode(PredictionMode.SLL); // try with simpler/faster SLL(*)
//        // we don't want error messages or recovery during first try
//        parser.removeErrorListeners();
//        parser.setErrorHandler(new BailErrorStrategy());
//        try {
//            parser.model();
//            // if we get here, there was no syntax error and SLL(*) was enough;
//            // there is no need to try full LL(*)
//        } catch (RuntimeException ex) {
//            if (ex.getClass() == RuntimeException.class &&
//                    ex.getCause() instanceof RecognitionException) {
//                // The BailErrorStrategy wraps the RecognitionExceptions in
//                // RuntimeExceptions so we have to make sure we're detecting
//                // a true RecognitionException not some other kind
//                tokens.reset(); // rewind input stream
//                // back to standard listeners/handlers
//                parser.addErrorListener(new UnderlineErrorListener());
//                parser.setErrorHandler(new DefaultErrorStrategy());
//                parser.getInterpreter().setPredictionMode(PredictionMode.LL); // try full LL(*)
//                parser.model();
//            }
//        }
//        parser.saveResource(file.getName().substring(0, file.getName().indexOf(".")), "./src/test/resources/out/");

//    Utilities.showParseTree(parser, tree);

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

    public static class VerboseListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line, int charPositionInLine,
                                String msg,
                                RecognitionException e) {
            List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
            Collections.reverse(stack);
            System.err.println("rule stack: " + stack);
            System.err.println("line " + line + ":" + charPositionInLine + " at " +
                    offendingSymbol + ": " + msg);
        }
    }


}
