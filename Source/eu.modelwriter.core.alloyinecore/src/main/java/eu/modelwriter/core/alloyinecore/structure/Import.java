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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.visitor.AlloyInEcoreVisitor;
import org.antlr.v4.runtime.Token;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.List;

public class Import extends Object<EObject, PackageImportContext> {

    public Import(EObject eObject, PackageImportContext context) {
        super(eObject, context);
    }

    public static final String Ecore = "http://www.eclipse.org/emf/2002/Ecore";

    public String getPath() {
        if (getContext().ownedPathName != null)
            return getContext().ownedPathName.getText().replace("'", "");
        else return null;
    }

    public Resource getResource() {
        return getEObject().eResource();
    }


    public EObject getRootObject() {
        return getEObject().eContents().get(0);
    }

    public EObject getElement(final List<String> relativePathFragments) {
        EObject result = null;
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

    String getName(){
        String name = "";
        if (this.getContext().name != null) {
            name = "::" + this.getContext().name.getText();
        }
        else if (this.getEObject() != null && this.getEObject() instanceof ENamedElement) {
            ENamedElement pack = (ENamedElement) this.getEObject();
            if (pack.getName() != null && !pack.getName().isEmpty())
                name = "::" + pack.getName();
        } else if (this.getURI() != null)
            name = this.getURI().lastSegment();
        return name;
    }

    @Override
    public Token getToken() {
        if (getContext().name != null)
            return getContext().name.start;
        else
            return super.getToken();
    }
    @Override
    public String getLabel() {
        int start;
        int stop;
        if (getContext().name != null) {
            start = getContext().name.start.getStartIndex();
        } else {
            start = getContext().start.getStartIndex();
        }

        if (getContext().ownedPathName != null) {
            stop = getContext().ownedPathName.getStopIndex();
        } else {
            stop = getContext().stop.getStopIndex();
        }
        return  Element.getNormalizedText(getContext(), start, stop);
    }

    @Override
    public int getLine() {
        if (getContext().name != null)
            return getContext().name.start.getLine();
        else return super.getLine();
    }

    @Override
    public int getStart() {
        if (getContext().name != null)
            return getContext().name.start.getStartIndex();
        else return super.getLine();
    }

    @Override
    public int getStop() {
        if (getContext().name != null)
            return getContext().name.start.getStopIndex();
        else return super.getLine();
    }

    @Override
    public <T> T accept(AlloyInEcoreVisitor<? extends T> visitor) {
        return visitor.visitImport(this);
    }
}
