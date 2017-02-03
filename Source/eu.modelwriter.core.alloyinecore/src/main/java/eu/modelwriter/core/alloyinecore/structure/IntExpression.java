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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IntExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IfIntExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.SumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.CountContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PlusContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.MinusContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.MultiplyContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.DivideContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuloContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IntConstantContext;
import eu.modelwriter.core.alloyinecore.visitor.IAlloyInEcoreVisitor;

public abstract class IntExpression<C extends IntExpressionContext> extends Element<C> {

    private IntExpression(C context) {
        super(context);
    }

    @Override
    public int getStop(){ return getContext().stop.getStopIndex(); }

    public static <C extends IntExpressionContext> IntExpression create(C ctx) {
        IntExpression expression = null;
        if (ctx instanceof IfIntExpressionContext) {
            expression = new IfIntExpression((IfIntExpressionContext) ctx);
            expression.addOwnedElements(((IfIntExpressionContext) ctx).condition.element, ((IfIntExpressionContext) ctx).thenExpr.element, ((IfIntExpressionContext) ctx).elseExpr.element);
        } else if (ctx instanceof SumContext) {
            expression = new Sum((SumContext) ctx);
            expression.addOwnedElement(((SumContext) ctx).expression().element);
        }else if (ctx instanceof CountContext) {
            expression = new Count((CountContext) ctx);
            expression.addOwnedElement(((CountContext) ctx).expression().element);
        }else if (ctx instanceof PlusContext) {
            expression = new Plus((PlusContext) ctx);
            expression.addOwnedElements(((PlusContext) ctx).ileft.element, ((PlusContext) ctx).iright.element);
        }else if (ctx instanceof MinusContext) {
            expression = new Minus((MinusContext) ctx);
            expression.addOwnedElements(((MinusContext) ctx).ileft.element, ((MinusContext) ctx).iright.element);
        }else if (ctx instanceof MultiplyContext) {
            expression = new Multiply((MultiplyContext) ctx);
            expression.addOwnedElements(((MultiplyContext) ctx).ileft.element, ((MultiplyContext) ctx).iright.element);
        }else if (ctx instanceof DivideContext) {
            expression = new Divide((DivideContext) ctx);
            expression.addOwnedElements(((DivideContext) ctx).ileft.element, ((DivideContext) ctx).iright.element);
        }else if (ctx instanceof ModuloContext) {
            expression = new Modulo((ModuloContext) ctx);
            expression.addOwnedElements(((ModuloContext) ctx).ileft.element, ((ModuloContext) ctx).iright.element);
        }else if (ctx instanceof IntConstantContext) {
            expression = new IntConstant((IntConstantContext) ctx);
        }

        return expression;
    }

    public static class IfIntExpression extends IntExpression<IfIntExpressionContext>{
        public IfIntExpression(IfIntExpressionContext context) { super(context); }

        @Override
        public <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor) {
            return visitor.visitIfIntExpression(this);
        }
    }

    public static class Sum extends IntExpression<SumContext>{
        public Sum(SumContext context) { super(context); }

        @Override
        public <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor) {
            return visitor.visitSum(this);
        }
    }

    public static class Count extends IntExpression<CountContext>{
        public Count(CountContext context) { super(context); }

        @Override
        public <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor) {
            return visitor.visitCount(this);
        }
    }

    public static class Plus extends IntExpression<PlusContext>{
        public Plus(PlusContext context) { super(context); }

        @Override
        public <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor) {
            return visitor.visitPlus(this);
        }
    }

    public static class Minus extends IntExpression<MinusContext>{
        public Minus(MinusContext context) { super(context); }

        @Override
        public <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor) {
            return visitor.visitMinus(this);
        }
    }

    public static class Multiply extends IntExpression<MultiplyContext>{
        public Multiply(MultiplyContext context) { super(context); }

        @Override
        public <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor) {
            return visitor.visitMultiply(this);
        }
    }

    public static class Divide extends IntExpression<DivideContext>{
        public Divide(DivideContext context) { super(context); }

        @Override
        public <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor) {
            return visitor.visitDivide(this);
        }
    }

    public static class Modulo extends IntExpression<ModuloContext>{
        public Modulo(ModuloContext context) { super(context); }

        @Override
        public <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor) {
            return visitor.visitModulo(this);
        }
    }

    public static class IntConstant extends IntExpression<IntConstantContext>{
        public IntConstant(IntConstantContext context) { super(context); }

        @Override
        public <T> T accept(IAlloyInEcoreVisitor<? extends T> visitor) {
            return visitor.visitIntConstant(this);
        }
    }
}
