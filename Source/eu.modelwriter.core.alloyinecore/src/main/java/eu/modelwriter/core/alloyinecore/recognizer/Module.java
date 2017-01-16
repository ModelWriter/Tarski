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

package eu.modelwriter.core.alloyinecore.recognizer;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.emf.ecore.*;

import java.io.File;
import java.io.IOException;

public class Module extends AlloyInEcoreParser {

//    private static final String ECORE_URI = "programs/AlloyInECore/Ecore.recore"; //"http://www.eclipse.org/emf/2002/Ecore";
//    private static final Module ECORE = new Module(Module.ECORE_URI);

//    private final List<Module> importedModules = new ArrayList<>();
//    private final Map<String, Element> imports = new HashMap<>();
//    private final EPackage ePackage;
//    private final AlloyInEcoreParser parser;
//
//    private final String uri;
//    public final ParseTree ast;

    public Module(TokenStream input, String filename, String path) {
        super(input, filename, path);
    }

//    public Module(String uri){
//        if (uri.equals(Module.ECORE_URI)){
//            this.uri = uri;
//            this.ast = Module.openModule(uri);
//            this.parser.module = this;
//        } else {
//            this.uri = uri;
//            this.qPathStore.putAll(Module.ECORE.qPathStore);
//            this.qPathQNamePairs.putAll(Module.ECORE.qPathQNamePairs);
//            this.ast = Module.openModule(uri);
//            this.parser.module = this;
//            this.ePackage = thi
//        }
//        //Create Parser
//    }

//    void addModule(Module module){
//        if (this.ePackage.getName().equals(module.ePackage.getNsURI())){
//            parser.notifyErrorListeners("");
//        }
//
//        this.importedModules.add(module);
//        this.qPathStore.putAll(module.qPathStore);
//        this.qPathQNamePairs.putAll(module.qPathQNamePairs);
//    }

    private static ParseTree openModule(String uri){
        ANTLRInputStream input = null;
        final File file = new File(uri);
        try {
            input = new ANTLRFileStream(file.getAbsolutePath());
        } catch (final IOException e) {
            e.printStackTrace();
        }
        final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens, file.getName().substring(0, file.getName().indexOf(".")), "./");
        parser.removeErrorListeners();
        parser.addErrorListener(new UnderlineErrorListener());
        return parser.module();
    }



    class AttributeType
    {
        EAttributeContext ownerContext;
        Token token;
        String targetQName = null;
    }

    class ReferenceType
    {
        EReference owner;
        EDataType targetElement;
        Token token;
        String targetQName = null;
    }

    class Opposite
    {
        EReference owner;
        EReference targetElement;
        Token token;
        String targetQName = null;
    }

    class SuperType
    {

    }

    public String getQualifiedName(EModelElement e) {
        String qName = null;
        if (e instanceof ENamedElement)
            qName = getQualifiedName((ENamedElement) e);
        else if (e instanceof AlloyInEcoreParser.EAnnotationContext)
            qName = getQualifiedName((EAnnotation) e);
        return qName;
    }

    private String getQualifiedName(ENamedElement e){
        String qname = null;
        if (e instanceof EPackage)
            qname = getQualifiedName((EPackage) e);
        else if (e instanceof EClassifier)
            qname = getQualifiedName((EClassifier) e);
        else if (e instanceof EStructuralFeature)
            qname = getQualifiedName((EStructuralFeature) e);
        else if (e instanceof EOperation)
            qname = getQualifiedName((EOperation) e);
        else if (e instanceof EParameter)
            qname = getQualifiedName((EParameter) e);
        else if (e instanceof EEnumLiteral)
            qname = getQualifiedName((EEnumLiteral) e);
        return qname;
    }

    private String getQualifiedName(EPackage p) {
        return p.getESuperPackage() == null ? p.getName() : getQualifiedName(p.getESuperPackage()) + "." + p.getName();
    }

    private String getQualifiedName(EClassifier c) {
        return getQualifiedName(c.getEPackage()) + ":" + c.getName();
    }

    private String getQualifiedName(EStructuralFeature f) {
        return getQualifiedName(f.getEContainingClass()) + "::" + f.getName();
    }

    private String getQualifiedName(EOperation o) {
        return getQualifiedName(o.getEContainingClass()) + "->" + o.getName();
    }

    private String getQualifiedName(EEnumLiteral l) {
        return getQualifiedName(l.getEEnum()) + "::" + l.getName();
    }

    private String getQualifiedName(EParameter p) {
        return getQualifiedName(p.getEOperation()) + "::" + p.getName();
    }

    private String getQualifiedName(EAnnotation a) {
        return getQualifiedName(a.getEModelElement()) + "@" + "annotation";
    }

    private EAnnotation createEAnnotation(EModelElement owner, final String source) {
        final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
        eAnnotation.setSource(source);
        owner.getEAnnotations().add(eAnnotation);
        return eAnnotation;
    }


}
