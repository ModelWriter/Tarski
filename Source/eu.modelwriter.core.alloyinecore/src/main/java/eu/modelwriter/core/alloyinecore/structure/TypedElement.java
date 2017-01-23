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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.emf.ecore.ETypedElement;

public abstract class TypedElement<E extends ETypedElement, C extends ParserRuleContext> extends NamedElement<ETypedElement, C> {

    public TypedElement(ETypedElement eTypedElement, C context) {
        super(eTypedElement, context);
    }

    public TypedElement(C context) {
        super(context);
    }

    static String getMultiplicity(EMultiplicityContext ctx) {
        int l = 1;
        int u = 1;
        boolean nullable = false;

        if (ctx.stringBound != null) {
            switch (ctx.stringBound.getText()) {
                case "*": l = 0; u = -1; break;
                case "+": l = 1; u = -1; break;
                case "?": l = 0; u =  1; break;
                default: break;
            }
        } else {
            l = Integer.valueOf(ctx.lowerBound.getText());
            if (ctx.upperBound != null) {
                u = Integer.valueOf(ctx.upperBound.getText());
            } else { u = l;}
        }

        if ((u > 1 || u == -1) && ctx.nullable != null )
            nullable = true;

        String multiplicity;
        if (l==0 && u==-1) {
            multiplicity = "[*"+ (nullable ? "|?]" : "]");
        } else if (l==1 && u==-1) {
            multiplicity = "[+"+ (nullable ? "|?]" : "]");
        } else if (l==0 && u==1) {
            multiplicity = "[?]";
        } else if (l==1 && u==1)
            multiplicity = "[1]";
        else if (l==u) {
            multiplicity = "[" + l + (nullable ? "|?]" : "]");
        } else {
            multiplicity = "[" + l + ".." + u + (nullable ? "|?]" : "]");
        }
        return multiplicity;
    }
}
