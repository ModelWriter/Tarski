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


import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericWildcardContext;
import eu.modelwriter.core.alloyinecore.structure.base.Object;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;
import org.eclipse.emf.ecore.EGenericType;

public class GenericWildcard extends Object<EGenericType, EGenericWildcardContext> {

    public GenericWildcard(EGenericType eObject, EGenericWildcardContext context) {
        super(eObject, context);
    }

    public GenericWildcard(EGenericWildcardContext context) {
        super(context);
    }

    @Override
    public String getLabel() {
        AlloyInEcoreParser.EGenericTypeContext ownedExtend= getContext().ownedExtend;
        return ownedExtend != null ? getNormalizedText(getContext(), ownedExtend.start.getStartIndex(), ownedExtend.stop.getStopIndex()) : "?";
    }

    @Override
    public int getLine(){
        AlloyInEcoreParser.EGenericTypeContext ownedExtend= getContext().ownedExtend;
        return ownedExtend != null ? ownedExtend.stop.getLine() : getContext().start.getLine();
    }

    @Override
    public int getStart() {
        AlloyInEcoreParser.EGenericTypeContext ownedExtend= getContext().ownedExtend;
        return ownedExtend != null ? ownedExtend.stop.getStartIndex() : getContext().start.getStartIndex();
    }

    @Override
    public int getStop(){
        AlloyInEcoreParser.EGenericTypeContext ownedExtend= getContext().ownedExtend;
        return ownedExtend != null ? ownedExtend.stop.getStopIndex() : getContext().start.getStopIndex();
    }

    @Override
    public <T> T accept(IVisitor<? extends T> visitor) {
        return visitor.visitGenericWildcard(this);
    }
}
