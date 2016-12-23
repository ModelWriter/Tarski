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

package eu.modelwriter.core.alloyinecore.structure.node;

import eu.modelwriter.core.alloyinecore.structure.ModelElement;
import eu.modelwriter.core.alloyinecore.structure.graph.Vertex;

public abstract class NamedElement extends Vertex<ModelElement> {

    public abstract <T extends NamedElement> T getOwner();

    private static String getQualifiedName(Package p) {
        return p.getOwner() == null ? p.getName() : getQualifiedName(p.getOwner()) + "." + p.getName();
    }

    private static String getQualifiedName(Classifier c) {
        return getQualifiedName(c.getOwner()) + "." + c.getName();
    }

    private static String getQualifiedName(StructuralFeature f) {
        return getQualifiedName(f.getOwner()) + "::" + f.getName();
    }

    private static String getQualifiedName(EnumLiteral l) {
        return getQualifiedName(l.getOwner()) + "::" + l.getName();
    }

    private static String getQualifiedName(Operation o) {
        return getQualifiedName(o.getOwner()) + "::" + o.getName();
    }

    private static String getQualifiedName(Parameter p) {
        return getQualifiedName(p.getOwner()) + "::" + p.getName();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
