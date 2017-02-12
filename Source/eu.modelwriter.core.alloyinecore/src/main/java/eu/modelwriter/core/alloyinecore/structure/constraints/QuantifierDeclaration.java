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

package eu.modelwriter.core.alloyinecore.structure.constraints;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.QuantifierDeclarationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OneOfContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.LoneOfContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.SomeOfContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.SetOfContext;
import eu.modelwriter.core.alloyinecore.structure.model.Declaration;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;

public abstract class QuantifierDeclaration<C extends QuantifierDeclarationContext> extends Declaration<C> {

    private QuantifierDeclaration(C context) { super(context); }

    public static <C extends QuantifierDeclarationContext> QuantifierDeclaration create(C ctx) {
        QuantifierDeclaration declaration = null;
        if (ctx instanceof OneOfContext) {
            declaration = new OneOf((OneOfContext) ctx);
            for(AlloyInEcoreParser.VariableContext varCtx: ((OneOfContext) ctx).variable()){
                declaration.addOwnedElement(varCtx.element);
            }
            declaration.addOwnedElement(((OneOfContext) ctx).expression().element);
        } else if (ctx instanceof LoneOfContext) {
            declaration = new LoneOf((LoneOfContext) ctx);
            declaration.addOwnedElement(((LoneOfContext) ctx).expression().element);
        } else if (ctx instanceof SomeOfContext) {
            declaration = new SomeOf((SomeOfContext) ctx);
            declaration.addOwnedElement(((SomeOfContext) ctx).expression().element);
        } else if (ctx instanceof SetOfContext) {
            declaration = new SetOf((SetOfContext) ctx);
            declaration.addOwnedElement(((SetOfContext) ctx).expression().element);
        }
        return  declaration;
    }

    public static final class OneOf extends QuantifierDeclaration<OneOfContext> {
        public OneOf(OneOfContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitOneOf(this);
        }
    }

    public static final class LoneOf extends QuantifierDeclaration<LoneOfContext> {
        public LoneOf(LoneOfContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitLoneOf(this);
        }
    }

    public static final class SomeOf extends QuantifierDeclaration<SomeOfContext> {
        public SomeOf(SomeOfContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitSomeOf(this);
        }
    }

    public static final class SetOf extends QuantifierDeclaration<SetOfContext> {
        public SetOf(SetOfContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitSetOf(this);
        }
    }
}
