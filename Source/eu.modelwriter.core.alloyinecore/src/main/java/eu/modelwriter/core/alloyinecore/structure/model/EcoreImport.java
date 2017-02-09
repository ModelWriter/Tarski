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

package eu.modelwriter.core.alloyinecore.structure.model;

import eu.modelwriter.core.alloyinecore.packageimport.ImportsLexer;
import eu.modelwriter.core.alloyinecore.packageimport.ImportsParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.UnderlineErrorListener;
import eu.modelwriter.core.alloyinecore.structure.base.INamespace;
import eu.modelwriter.core.alloyinecore.structure.base.Repository;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import java.io.IOException;
import java.io.InputStream;

public final class EcoreImport extends Import{

    public EcoreImport(EObject eObject, PackageImportContext context) {
        super(eObject, context);
    }

    @Override
    public <T> T accept(IVisitor<? extends T> visitor) {
        return visitor.visitEcoreImport(this);
    }

    @Override
    public String getPath() {
        return "Ecore.recore";
    }

    @Override
    public void loadNamespace(Repository repository){
        //http://docs.oracle.com/javase/7/docs/technotes/guides/lang/resources.html
        if (getPath() != null) {

            Resource resource = getResource();

            ClassLoader classLoader = INamespace.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(getPath());

            if (resource.getURI().isFile()) {
                System.out.println("[" + getKey() +"] Resource is file in the classpath");
            } else if (resource.getURI().isPlatform()) {
                System.out.println("[" + getKey() +"] Resource is platform");
            } else if (resource.getURI().isPlatformPlugin()) {
                System.out.println("[" + getKey() +"] Resource is platform plugin");
            } else if (resource.getURI().isPlatformResource()) {
                System.out.println("[" + getKey() +"] Resource is platform resource");
            } else {
                System.out.println("[" + getKey() +"] Resource is file in the JAR");
            }

            System.out.print(" [" + classLoader.getResource(getPath()).getFile() + "]");
            System.out.println();

            ANTLRInputStream input = null;
            try {
                input = new ANTLRInputStream(inputStream);
            } catch (final IOException e) {
                e.printStackTrace();
            }
            final ImportsLexer lexer = new ImportsLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final ImportsParser parser = new ImportsParser(tokens);
            //    parser.removeErrorListeners();
            //    parser.addErrorListener(new UnderlineErrorListener());
            //    parser.importedFile();

            parser.getInterpreter().setPredictionMode(PredictionMode.SLL); // try with simpler/faster SLL(*)
            // we don't want error messages or recovery during first try
            parser.removeErrorListeners();
            parser.setErrorHandler(new BailErrorStrategy());
            try {
                parser.importedFile(this);
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
                    parser.importedFile(this);
                }
            }
        }
    }
}
