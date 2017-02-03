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

import eu.modelwriter.core.alloyinecore.structure.*;
import eu.modelwriter.core.alloyinecore.structure.Class;
import eu.modelwriter.core.alloyinecore.visitor.BaseModuleVisitor;

public class DummyVisitor extends BaseModuleVisitor {

    @Override
    public Element visitImport(Import _import) {
        System.out.println(_import.getLabel());
        return super.visitImport(_import);
    }

    @Override
    public Element visitEcoreImport(EcoreImport ecoreImport) {
        System.out.println(ecoreImport.getLabel());
        return super.visitEcoreImport(ecoreImport);
    }

    @Override
    public Element visitClass(Class _class) {
        System.out.println(_class.getLabel());
        return super.visitClass(_class);
    }

    @Override
    public Element visitAttribute(Attribute attribute) {
        System.out.println(attribute.getLabel());
        return super.visitAttribute(attribute);
    }

    @Override
    public Element visitTranspose(Expression.Transpose transpose) {
        System.out.println(transpose.getLabel());
        return super.visitTranspose(transpose);
    }
}
