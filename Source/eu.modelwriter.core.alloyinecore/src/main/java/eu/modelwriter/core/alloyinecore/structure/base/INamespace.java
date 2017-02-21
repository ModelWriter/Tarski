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

package eu.modelwriter.core.alloyinecore.structure.base;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.List;

public interface INamespace extends ISegment {

    String getKey();

    String getPath();

    EObject getEObject();

    void loadNamespace(Repository repository);

    default Resource getResource(){
        return getEObject().eResource();
    }

    default EObject getRootObject() {
        return getEObject().eContents().get(0);
    }

    default EObject getElement(final List<String> relativePathFragments) {
        EObject result;
        try {
            final String rootFragment = getResource().getURIFragment(getRootObject());
            relativePathFragments.add(0, rootFragment);
            result = getResource().getEObject(String.join("/", relativePathFragments));
            if (result == null) {
                throw new Exception();
            }
        } catch (final Exception e) {
            relativePathFragments.remove(0);
            result = getResource().getEObject(String.join("/", relativePathFragments));
        }
        return result;
    }

//    static <T extends Element & INamespace> void loadNamespace(final T namespace){
//        //http://docs.oracle.com/javase/7/docs/technotes/guides/lang/resources.html
//        if (namespace.getPath() != null) {
//
//            Resource resource = namespace.getResource();
//
//            final String loc = new File(".").getAbsolutePath()
//                    + namespace.getPath();
//
//            System.out.println(new File(".").getAbsolutePath());
//            System.out.println(loc);
//
//            ClassLoader classLoader = INamespace.class.getClassLoader();
//            InputStream inputStream = classLoader.getResourceAsStream(namespace.getPath());
//            System.out.println(inputStream);
//
//            if (resource.getURI().isFile()) {
//                System.out.println("Resource is file");
//            } else if (resource.getURI().isPlatform()) {
//                System.out.println("Resource is platform");
//            } else if (resource.getURI().isPlatformPlugin()) {
//                System.out.println("Resource is platform plugin");
//            } else if (resource.getURI().isPlatformResource()) {
//                System.out.println("Resource is platform resource");
//            } else {
//                System.out.println("Resource is ?");
//            }
//            ANTLRInputStream input = null;
//            try {
//                input = new ANTLRInputStream(inputStream);
//            } catch (final IOException e) {
//                e.printStackTrace();
//            }
//            final ImportsLexer lexer = new ImportsLexer(input);
//            final CommonTokenStream tokens = new CommonTokenStream(lexer);
//            final ImportsParser parser = new ImportsParser(tokens);
//            //    parser.removeErrorListeners();
//            //    parser.addErrorListener(new UnderlineErrorListener());
//            //    parser.importedFile();
//
//            parser.getInterpreter().setPredictionMode(PredictionMode.SLL); // try with simpler/faster SLL(*)
//            // we don't want error messages or recovery during first try
//            parser.removeErrorListeners();
//            parser.setErrorHandler(new BailErrorStrategy());
//            try {
//                parser.importedFile(namespace);
//                // if we get here, there was no syntax error and SLL(*) was enough;
//                // there is no need to try full LL(*)
//            }
//            catch (RuntimeException ex) {
//                if (ex.getClass() == RuntimeException.class &&
//                        ex.getCause() instanceof RecognitionException)
//                {
//                    // The BailErrorStrategy wraps the RecognitionExceptions in
//                    // RuntimeExceptions so we have to make sure we're detecting
//                    // a true RecognitionException not some other kind
//                    tokens.reset(); // rewind input stream
//                    // back to standard listeners/handlers
//                    parser.addErrorListener(new UnderlineErrorListener());
//                    parser.setErrorHandler(new DefaultErrorStrategy());
//                    parser.getInterpreter().setPredictionMode(PredictionMode.LL); // try full LL(*)
//                    parser.importedFile(namespace);
//                }
//            }
//        }
//    }


}
