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
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.*;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;

public abstract class Formula<C extends FormulaContext> extends Element<C> {

    private Formula(C context) {
        super(context);
    }

    @Override
    public int getStop(){ return getContext().stop.getStopIndex(); }

    public static <C extends FormulaContext> Formula create(C ctx) {
        Formula formula = null;
        if (ctx instanceof NoContext) {
            formula = new No((NoContext) ctx);
            formula.addOwnedElement(((NoContext) ctx).expression().element);
        } else if (ctx instanceof LoneContext) {
            formula = new Lone((LoneContext) ctx);
            formula.addOwnedElement(((LoneContext) ctx).expression().element);
        } else if (ctx instanceof OneContext) {
            formula = new One((OneContext) ctx);
            formula.addOwnedElement(((OneContext) ctx).expression().element);
        } else if (ctx instanceof SomeContext) {
            formula = new Some((SomeContext) ctx);
            formula.addOwnedElement(((SomeContext) ctx).expression().element);
        } else if (ctx instanceof InContext) {
            if (((InContext) ctx).not != null)
                formula = new NotIn((InContext) ctx);
            else
                formula = new In((InContext) ctx);
            formula.addOwnedElements(((InContext) ctx).left.element, ((InContext) ctx).right.element);
        } else if (ctx instanceof EqualContext) {
            if (((EqualContext) ctx).not != null)
                formula = new NotEqual((EqualContext) ctx);
            else
                formula = new Equal((EqualContext) ctx);
            formula.addOwnedElements(((EqualContext) ctx).left.element, ((EqualContext) ctx).right.element);
        } else if (ctx instanceof EqContext) {
            if (((EqContext) ctx).not != null)
                formula = new NotEq((EqContext) ctx);
            else
                formula = new Eq((EqContext) ctx);
            formula.addOwnedElements(((EqContext) ctx).ileft.element, ((EqContext) ctx).iright.element);
        } else if (ctx instanceof LtContext) {
            if (((LtContext) ctx).not != null)
                formula = new NotLt((LtContext) ctx);
            else
                formula = new Lt((LtContext) ctx);
            formula.addOwnedElements(((LtContext) ctx).ileft.element, ((LtContext) ctx).iright.element);
        } else if (ctx instanceof LteContext) {
            if (((LteContext) ctx).not != null)
                formula = new NotLte((LteContext) ctx);
            else
                formula = new Lte((LteContext) ctx);
            formula.addOwnedElements(((LteContext) ctx).ileft.element, ((LteContext) ctx).iright.element);
        } else if (ctx instanceof GtContext) {
            if (((GtContext) ctx).not != null)
                formula = new NotGt((GtContext) ctx);
            else
                formula = new Gt((GtContext) ctx);
            formula.addOwnedElements(((GtContext) ctx).ileft.element, ((GtContext) ctx).iright.element);
        } else if (ctx instanceof GteContext) {
            if (((GteContext) ctx).not != null)
                formula = new NotGte((GteContext) ctx);
            else
                formula = new Gte((GteContext) ctx);
            formula.addOwnedElements(((GteContext) ctx).ileft.element, ((GteContext) ctx).iright.element);
        } else if (ctx instanceof SumDeclarationContext) {
            formula = new SumDeclaration((SumDeclarationContext) ctx);
            formula.addOwnedElements(((SumDeclarationContext) ctx).quantifierDeclarations().elements);
            formula.addOwnedElements(((SumDeclarationContext) ctx).intExpression().element);
        } else if (ctx instanceof AcyclicContext) {
            formula = new Acyclic((AcyclicContext) ctx);
        } else if (ctx instanceof FunctionContext) {
            if (((FunctionContext) ctx).partial != null)
                formula = new PartialFunction((FunctionContext) ctx);
            else
                formula = new Function((FunctionContext) ctx);
            formula.addOwnedElements(((FunctionContext) ctx).domain.element, ((FunctionContext) ctx).range.element);
        } else if (ctx instanceof TotalOrderContext) {
            formula = new TotalOrder((TotalOrderContext) ctx);
        } else if (ctx instanceof NotContext) {
            formula = new Not((NotContext) ctx);
            formula.addOwnedElements(((NotContext) ctx).formula.element);
        } else if (ctx instanceof AndContext) {
            formula = new And((AndContext) ctx);
            formula.addOwnedElements(((AndContext) ctx).fleft.element, ((AndContext) ctx).fright.element);
        } else if (ctx instanceof OrContext) {
            formula = new Or((OrContext) ctx);
            formula.addOwnedElements(((OrContext) ctx).fleft.element, ((OrContext) ctx).fright.element);
        } else if (ctx instanceof ImpliesContext) {
            formula = new Implies((ImpliesContext) ctx);
            formula.addOwnedElements(((ImpliesContext) ctx).fleft.element, ((ImpliesContext) ctx).fright.element);
        } else if (ctx instanceof IffContext) {
            formula = new Iff((IffContext) ctx);
            formula.addOwnedElements(((IffContext) ctx).fleft.element, ((IffContext) ctx).fright.element);
        } else if (ctx instanceof ForAllContext) {
            formula = new ForAll((ForAllContext) ctx);
            formula.addOwnedElements(((ForAllContext) ctx).quantifierDeclarations().elements);
            formula.addOwnedElements(((ForAllContext) ctx).formula.element);
        } else if (ctx instanceof ForSomeContext) {
            formula = new ForSome((ForSomeContext) ctx);
            formula.addOwnedElements(((ForSomeContext) ctx).quantifierDeclarations().elements);
            formula.addOwnedElements(((ForSomeContext) ctx).formula.element);
        } else if (ctx instanceof ForNoContext) {
            formula = new ForNo((ForNoContext) ctx);
            formula.addOwnedElements(((ForNoContext) ctx).quantifierDeclarations().elements);
            formula.addOwnedElements(((ForNoContext) ctx).formula.element);
        } else if (ctx instanceof ForOneContext) {
            formula = new ForOne((ForOneContext) ctx);
            formula.addOwnedElements(((ForOneContext) ctx).quantifierDeclarations().elements);
            formula.addOwnedElements(((ForOneContext) ctx).formula.element);
        } else if (ctx instanceof ForLoneContext) {
            formula = new ForLone((ForLoneContext) ctx);
            formula.addOwnedElements(((ForLoneContext) ctx).quantifierDeclarations().elements);
            formula.addOwnedElements(((ForLoneContext) ctx).formula.element);
        } else if (ctx instanceof TrueContext) {
            formula = new True((TrueContext) ctx);
        } else if (ctx instanceof FalseContext) {
            formula = new False((FalseContext) ctx);
        }

        return formula;
    }

    public static final class No extends Formula<NoContext> {
        public No(NoContext context) { super(context);}

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNo(this);
        }
    }

    public static final class Lone extends Formula<LoneContext> {
        public Lone(AlloyInEcoreParser.LoneContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitLone(this);
        }
    }

    public static final class One extends Formula<OneContext> {
        public One(OneContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitOne(this);
        }
    }

    public static final class Some extends Formula<SomeContext> {
        public Some(SomeContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitSome(this);
        }
    }

    public static class In extends Formula<InContext> {
        public In(InContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitIn(this);
        }
    }

    public static final class NotIn extends In {
        public NotIn(InContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNotIn(this);
        }
    }

    public static class Equal extends Formula<EqualContext> {
        public Equal(EqualContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitEqual(this);
        }
    }

    public static final class NotEqual extends Equal {
        public NotEqual(EqualContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNotEqual(this);
        }
    }

    public static class Eq extends Formula<EqContext> {
        public Eq(EqContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitEq(this);
        }
    }

    public static final class NotEq extends Eq {
        public NotEq(EqContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNotEq(this);
        }
    }

    public static class Lt extends Formula<LtContext> {
        public Lt(LtContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitLt(this);
        }
    }

    public static final class NotLt extends Lt {
        public NotLt(LtContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNotLt(this);
        }
    }

    public static class Lte extends Formula<LteContext> {
        public Lte(LteContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitLte(this);
        }
    }

    public static final class NotLte extends Lte {
        public NotLte(LteContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNotLte(this);
        }
    }

    public static class Gt extends Formula<GtContext> {
        public Gt(GtContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitGt(this);
        }
    }

    public static final class NotGt extends Gt {
        public NotGt(GtContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNotGt(this);
        }
    }

    public static class Gte extends Formula<GteContext> {
        public Gte(GteContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitGte(this);
        }
    }

    public static final class NotGte extends Gte {
        public NotGte(GteContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNotGte(this);
        }
    }

    public static class SumDeclaration extends Formula<SumDeclarationContext> {
        public SumDeclaration(SumDeclarationContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitSumDeclaration(this);
        }
    }

    public static final class Acyclic extends Formula<AcyclicContext> {
        public Acyclic(AcyclicContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitAcyclic(this);
        }
    }

    public static class Function extends Formula<FunctionContext> {
        public Function(FunctionContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitFunction(this);
        }
    }

    public static final class PartialFunction extends Function {
        public PartialFunction(FunctionContext context) { super(context);}

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitPartialFunction(this);
        }
    }

    public static final class TotalOrder extends Formula<TotalOrderContext> {
        public TotalOrder(TotalOrderContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitTotalOrder(this);
        }
    }

    public static final class Not extends Formula<NotContext> {
        public Not(NotContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNot(this);
        }
    }

    public static final class And extends Formula<AndContext> {
        public And(AndContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitAnd(this);
        }
    }

    public static final class Or extends Formula<OrContext> {
        public Or(OrContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitOr(this);
        }
    }

    public static final class Implies extends Formula<ImpliesContext> {
        public Implies(ImpliesContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitImplies(this);
        }
    }

    public static final class Iff extends Formula<IffContext> {
        public Iff(IffContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitIff(this);
        }
    }

    public static final class ForAll extends Formula<ForAllContext> {
        public ForAll(ForAllContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitForAll(this);
        }
    }

    public static final class ForSome extends Formula<ForSomeContext> {
        public ForSome(ForSomeContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitForSome(this);
        }
    }

    public static final class ForNo extends Formula<ForNoContext> {
        public ForNo(ForNoContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitForNo(this);
        }
    }

    public static final class ForOne extends Formula<ForOneContext> {
        public ForOne(ForOneContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitForOne(this);
        }
    }

    public static final class ForLone extends Formula<ForLoneContext> {
        public ForLone(ForLoneContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitForLone(this);
        }
    }

    public static final class True extends Formula<TrueContext> {
        public True(TrueContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitTrue(this);
        }
    }

    public static final class False extends Formula<FalseContext> {
        public False(FalseContext context) {
            super(context);
        }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitFalse(this);
        }
    }

}
