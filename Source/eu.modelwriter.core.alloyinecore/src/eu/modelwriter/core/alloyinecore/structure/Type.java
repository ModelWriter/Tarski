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

package eu.modelwriter.core.alloyinecore.structure;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeContext;

public abstract class Type<O extends NamedElement, T extends NamedElement> extends ModelElement<ETypeContext>{
    public T target = null;
    public final String targetLiteral;
    public final O owner;

    public Type(O owner, String targetLiteral, ETypeContext context) {
        super(context);
        this.owner = owner;
        this.targetLiteral = targetLiteral;
        this.token = context.start;
        Document.getInstance().addType(this);
    }

    public Type(O owner, String targetLiteral) {
        super();
        this.owner = owner;
        this.targetLiteral = targetLiteral;
        Document.getInstance().addType(this);
    }

    public T match(){
        T t = null;
        NamedElement e = Document.getInstance().getElement(this.targetLiteral);
        try {
            t = (T) e;
            target = t;
        } catch (ClassCastException ex) {
            Document.getInstance().parser.notifyErrorListeners(this.token, "This is a wrong type. It should be " + target.getClass().getName(), null);
        }
        return t;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Type{");
        sb.append("owner=").append(this.getClass().getName());
        sb.append(", ownerLiteral=").append(this.owner.qualifiedName);
        if (this.target != null)
            sb.append(", target=").append(this.target.getName());
        sb.append(", targetLiteral=").append(this.targetLiteral);
        sb.append('}');
        return sb.toString();
    }
}
