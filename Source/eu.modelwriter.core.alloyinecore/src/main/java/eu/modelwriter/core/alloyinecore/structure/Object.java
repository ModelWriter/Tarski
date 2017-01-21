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

package eu.modelwriter.core.alloyinecore.structure;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.List;


public abstract class Object<E extends EObject, C extends ParserRuleContext> extends Element<C> {
    private E eObject;

    public Object(E eObject, C context){
        super(context);
        this.eObject = eObject;
    }

    public Object(C context){
        super(context);
    }

    public void setEObject(E eObject) { this.eObject = eObject; }

    public E getEObject() { return eObject; }

    public String getURI() {
        return EcoreUtil.getURI(this.eObject).toString();
    }

    protected EObject getElement(EObject root, final List<String> relativePathFragments) {
        return relativePathFragments.size() == 0 ? root
                : EcoreUtil.getEObject(root, String.join("/", relativePathFragments));
    }

    public static String getQualifiedName(EModelElement e) {
        String qName = null;
        if (e instanceof ENamedElement)
            qName = getQualifiedName((ENamedElement) e);
        else if (e instanceof AlloyInEcoreParser.EAnnotationContext)
            qName = getQualifiedName((EAnnotation) e);
        return qName;
    }

    private static String getQualifiedName(ENamedElement e){
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

    private static String getQualifiedName(EPackage p) {
        return p.getESuperPackage() == null ? p.getName() : getQualifiedName(p.getESuperPackage()) + "." + p.getName();
    }

    private static String getQualifiedName(EClassifier c) {
        return getQualifiedName(c.getEPackage()) + ":" + c.getName();
    }

    private static String getQualifiedName(EStructuralFeature f) {
        return getQualifiedName(f.getEContainingClass()) + "::" + f.getName();
    }

    private static String getQualifiedName(EOperation o) {
        return getQualifiedName(o.getEContainingClass()) + "->" + o.getName();
    }

    private static String getQualifiedName(EEnumLiteral l) {
        return getQualifiedName(l.getEEnum()) + "::" + l.getName();
    }

    private static String getQualifiedName(EParameter p) {
        return getQualifiedName(p.getEOperation()) + "::" + p.getName();
    }

    private static String getQualifiedName(EAnnotation a) {
        return getQualifiedName(a.getEModelElement()) + "@" + "annotation";
    }


}
