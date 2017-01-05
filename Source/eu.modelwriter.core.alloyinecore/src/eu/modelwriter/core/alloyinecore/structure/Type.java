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
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Type<O extends NamedElement, T extends NamedElement> extends ModelElement<ETypeContext>{
    public T target = null;
    public String targetLiteral;
    public final O owner;

    public Type(O owner, ETypeContext context) {
        super(context);
        this.owner = owner;
        Document.getInstance().addType(this);
    }

    public Type(O owner, String targetLiteral) {
        super();
        this.owner = owner;
        this.targetLiteral = targetLiteral;
        Document.getInstance().addType(this);
    }

    public T match(){
        if (this.getContext().qualifiedName() != null){
            String rootName = Document.getInstance().getDocumentRoot().getName();
            String firstPart = this.getContext().qualifiedName().firstPart.getText();
            if (!firstPart.equals(rootName)) {
                String lastPart = null;
                if (this.getContext().qualifiedName().operation != null)
                    lastPart = this.getContext().qualifiedName().operation.getText();
                else if (this.getContext().qualifiedName().structuralFeature != null)
                    lastPart = this.getContext().qualifiedName().structuralFeature.getText();
                else if (this.getContext().qualifiedName().classifier != null)
                    lastPart = this.getContext().qualifiedName().classifier.getText();

                List<String> midParts = new ArrayList<>();
                if (this.getContext().qualifiedName().midParts.size() >= 0) {
                    for (IdentifierContext identifier : this.getContext().qualifiedName().midParts) {
                        midParts.add(identifier.getText());
                    }
                }

                if (!firstPart.equals(rootName) && this instanceof Opposite) {
                    this.targetLiteral = ((Reference) owner).getReferenceType().qualifiedName + "::" + firstPart;
                }
                else
                    this.targetLiteral =  owner.getOwner().getOwner().qualifiedName + "."+ firstPart;

            } else {
                this.targetLiteral = this.getContext().qualifiedName().getText();
            }
        } else if (this.getContext().ePrimitiveType() != null) {
            this.targetLiteral = this.getContext().ePrimitiveType().getText();
        } else {
            Document.getInstance().parser.notifyErrorListeners(this.token, "The reference type has not been declared", null);
        }
        //System.out.println("ref: " + this.targetLiteral);
        T t = null;
        NamedElement e = Document.getInstance().getElement(this.targetLiteral);
        if (e == null){
            Document.getInstance().parser.notifyErrorListeners(this.token, "The reference type does not exist in the current context: " + this.targetLiteral, null);
        } else {
            try {
                t = (T) e;
                target = t;
            } catch (ClassCastException ex) {
                Document.getInstance().parser.notifyErrorListeners(this.token, "This is a wrong type. It should be " + target.getClass().getName(), null);
            }
        }
        return t;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Type{");
        sb.append("owner=").append(this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.') + 1));
        sb.append(", ownerLiteral=").append(this.owner.qualifiedName);
        sb.append(", targetLiteral=").append(this.targetLiteral);
        sb.append('}');
        return sb.toString();
    }
}
