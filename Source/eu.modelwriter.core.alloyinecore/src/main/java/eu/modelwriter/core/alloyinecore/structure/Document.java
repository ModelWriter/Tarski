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
import org.eclipse.emf.ecore.*;

public class Document {

    protected static String getUniqueName(Element e) {
        String qName = null;
        if (e instanceof NamedElement)
            qName = getUniqueName((NamedElement) e);
        else if (e instanceof Annotation)
            qName = getUniqueName((Annotation) e);
        return qName;
    }

    private static String getUniqueName(NamedElement e){
        String qname = null;
        if (e instanceof Package)
            qname = getUniqueName((Package) e);
        else if (e instanceof Classifier)
            qname = getUniqueName((Classifier) e);
        else if (e instanceof StructuralFeature)
            qname = getUniqueName((StructuralFeature) e);
        else if (e instanceof Operation)
            qname = getUniqueName((Operation) e);
        else if (e instanceof Parameter)
            qname = getUniqueName((Parameter) e);
        else if (e instanceof EnumLiteral)
            qname = getUniqueName((EnumLiteral) e);
        return qname;
    }

    private static String getUniqueName(Package p) {
        return p.getOwner() == null ? p.getName() : getUniqueName(p.getOwner()) + "." + p.getName();
    }

    private static String getUniqueName(Classifier c) {
        return getUniqueName(c.getOwner()) + ":" + c.getName();
    }

    private static String getUniqueName(StructuralFeature f) {
        return getUniqueName(f.getOwner()) + "::" + f.getName();
    }

    private static String getUniqueName(Operation o) {
        return getUniqueName(o.getOwner()) + "->" + o.getName();
    }

    private static String getUniqueName(EnumLiteral l) {
        return getUniqueName(l.getOwner()) + "::" + l.getName();
    }

    private static String getUniqueName(Parameter p) {
        return getUniqueName(p.getOwner()) + "::" + p.getName();
    }

    private static String getUniqueName(Annotation a) {
        return getUniqueName(a.getOwner()) + "@" + "annotation";
    }
}
