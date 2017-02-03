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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TransposeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ClosureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ReflexiveContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IntersectionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.DifferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.JoinContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.BoxJoinContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ProductContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OverrideContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ComprehensionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IfExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdenContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.NoneContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnivContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IntsContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TypeRefContext;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;

public abstract class Expression<C extends ExpressionContext> extends Element<C> {

    private Expression(C context) { super(context); }

    @Override
    public int getStop(){ return getContext().stop.getStopIndex(); }

    public static <C extends ExpressionContext> Expression create(C ctx) {
        Expression expression = null;
        if (ctx instanceof TransposeContext) {
            expression = new Transpose((TransposeContext) ctx);
            expression.addOwnedElement(((TransposeContext) ctx).expression().element);
        } else if (ctx instanceof ClosureContext){
            expression = new Closure((ClosureContext) ctx);
            expression.addOwnedElement(((ClosureContext) ctx).expression().element);
        }else if (ctx instanceof ReflexiveContext){
            expression = new Reflexive((ReflexiveContext) ctx);
            expression.addOwnedElement(((ReflexiveContext) ctx).expression().element);
        }else if (ctx instanceof UnionContext){
            expression = new Union((UnionContext) ctx);
            expression.addOwnedElements(((UnionContext) ctx).left.element, ((UnionContext) ctx).right.element);
        }else if (ctx instanceof IntersectionContext){
            expression = new Intersection((IntersectionContext) ctx);
            expression.addOwnedElements(((IntersectionContext) ctx).left.element, ((IntersectionContext) ctx).right.element);
        }else if (ctx instanceof DifferenceContext){
            expression = new Difference((DifferenceContext) ctx);
            expression.addOwnedElements(((DifferenceContext) ctx).left.element, ((DifferenceContext) ctx).right.element);
        }else if (ctx instanceof JoinContext){
            expression = new Join((JoinContext) ctx);
            expression.addOwnedElements(((JoinContext) ctx).left.element, ((JoinContext) ctx).right.element);
        }else if (ctx instanceof BoxJoinContext){
            expression = new BoxJoin((BoxJoinContext) ctx);
            expression.addOwnedElements(((BoxJoinContext) ctx).right.element, ((BoxJoinContext) ctx).left.element);
        }else if (ctx instanceof ProductContext){
            expression = new Product((ProductContext) ctx);
            expression.addOwnedElements(((ProductContext) ctx).left.element, ((ProductContext) ctx).right.element);
        }else if (ctx instanceof OverrideContext){
            expression = new RelationalOverride((OverrideContext) ctx);
            expression.addOwnedElements(((OverrideContext) ctx).left.element, ((OverrideContext) ctx).right.element);
        }else if (ctx instanceof ComprehensionContext){
            expression = new Comprehension((ComprehensionContext) ctx);
            expression.addOwnedElements(((ComprehensionContext) ctx).comprehensionDeclarations().elements);
            expression.addOwnedElements(((ComprehensionContext) ctx).formula().element);
        }else if (ctx instanceof IfExpressionContext){
            expression = new IfExpression((IfExpressionContext) ctx);
            expression.addOwnedElements(((IfExpressionContext) ctx).condition.element, ((IfExpressionContext) ctx).thenExpr.element, ((IfExpressionContext) ctx).elseExpr.element);
        }else if (ctx instanceof IdenContext){
            expression = new Iden((IdenContext) ctx);
        }else if (ctx instanceof NoneContext){
            expression = new None((NoneContext) ctx);
        }else if (ctx instanceof UnivContext){
            expression = new Univ((UnivContext) ctx);
        }else if (ctx instanceof IntsContext){
            expression = new Ints((IntsContext) ctx);
        }else if (ctx instanceof TypeRefContext){
            expression = new Relation((TypeRefContext) ctx);
        }

        return expression;
    }

    public static final class Transpose extends Expression<TransposeContext> {
        public Transpose(TransposeContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitTranspose(this);
        }
    }

    public static final class Closure extends Expression<ClosureContext> {
        public Closure(ClosureContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitClosure(this);
        }
    }

    public static final class Reflexive extends Expression<ReflexiveContext> {
        public Reflexive(ReflexiveContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitReflexive(this);
        }
    }

    public static final class Union extends Expression<UnionContext> {
        public Union(UnionContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitUnion(this);
        }
    }

    public static final class Intersection extends Expression<IntersectionContext> {
        public Intersection(IntersectionContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitIntersection(this);
        }
    }

    public static final class Difference extends Expression<DifferenceContext> {
        public Difference(DifferenceContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitDifference(this);
        }
    }

    public static final class Join extends Expression<JoinContext> {
        public Join(JoinContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitJoin(this);
        }
    }

    public static final class BoxJoin extends Expression<BoxJoinContext> {
        public BoxJoin(BoxJoinContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitBoxJoin(this);
        }
    }

    public static final class Product extends Expression<ProductContext> {
        public Product(ProductContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitProduct(this);
        }
    }

    public static final class RelationalOverride extends Expression<OverrideContext> {
        public RelationalOverride(OverrideContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitRelationalOverride(this);
        }
    }

    public static final class Comprehension extends Expression<ComprehensionContext> {
        public Comprehension(ComprehensionContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitComprehension(this);
        }
    }

    public static final class IfExpression extends Expression<IfExpressionContext> {
        public IfExpression(IfExpressionContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitIfExpression(this);
        }
    }

    public static final class Iden extends Expression<IdenContext> {
        public Iden(IdenContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitIden(this);
        }
    }

    public static final class None extends Expression<NoneContext> {
        public None(NoneContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitNone(this);
        }
    }

    public static final class Univ extends Expression<UnivContext> {
        public Univ(UnivContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitUniv(this);
        }
    }

    public static final class Ints extends Expression<IntsContext> {
        public Ints(IntsContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitInts(this);
        }
    }

    public static final class Binding extends Expression<TypeRefContext> {
        public Binding(TypeRefContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitBinding(this);
        }
    }

    public static final class Relation extends Expression<TypeRefContext> {
        public Relation(TypeRefContext context) { super(context); }

        @Override
        public <T> T accept(IVisitor<? extends T> visitor) {
            return visitor.visitRelation(this);
        }
    }
}
