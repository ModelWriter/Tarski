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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.UnderlineErrorListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class VisitorTest {

    public static void main(final String[] args) {
        visit();
    }

    @Test
    public void testVisit() {
        visit();
    }

    private static void visit() {
        long start = System.currentTimeMillis();
        ANTLRInputStream input = null;
        final File file = new File("./src/test/resources/AlloyInECore/Generics1.recore");
        try {
            input = new ANTLRFileStream(file.getAbsolutePath());
        } catch (final IOException e) {
            e.printStackTrace();
        }
        final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL); // try with simpler/faster SLL(*)
        // we don't want error messages or recovery during first try
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());
        try {
            parser.model();
            // if we get here, there was no syntax error and SLL(*) was enough;
            // there is no need to try full LL(*)
        }
        catch (RuntimeException ex) {
            if (ex.getClass() == RuntimeException.class &&
                    ex.getCause() instanceof RecognitionException)
            {
                // The BailErrorStrategy wraps the RecognitionExceptions in
                // RuntimeExceptions so we have to make sure we're detecting
                // a true RecognitionException not some other kind
                tokens.reset(); // rewind input stream
                // back to standard listeners/handlers
                parser.addErrorListener(new UnderlineErrorListener());
                parser.setErrorHandler(new DefaultErrorStrategy());
                parser.getInterpreter().setPredictionMode(PredictionMode.LL); // try full LL(*)
                parser.model();
            }
        }
        DummyVisitor visitor = new DummyVisitor();
        System.out.println(visitor.visit(parser.model));
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

}
