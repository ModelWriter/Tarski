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

package eu.modelwriter.core.alloyinecore.translator;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.*;
import kodkod.ast.Node;
import kodkod.ast.Variable;
import kodkod.util.nodes.PrettyPrinter;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class KodkodTranslator extends AlloyInEcoreBaseVisitor<Node> {

  public KodkodTranslator(kodkod.instance.Bounds bounds) {
    super();
    this.bounds = bounds;;
    for (kodkod.ast.Relation relation : bounds.relations()) {
      this.relations.put(relation.name(), relation);
    }
    this.universe = bounds.universe();
    System.out.println(this.bounds);
  }

  private java.util.Map<String, kodkod.ast.Relation> relations =
      new java.util.HashMap<String, kodkod.ast.Relation>();
  private kodkod.instance.Universe universe = null;
  private kodkod.instance.Bounds bounds = null;
  private java.util.Map<String, kodkod.ast.Node> declarations =
      new java.util.HashMap<String, kodkod.ast.Node>();
  private List<List<Variable>> setOfDisjVars =
      new ArrayList<>();

  public kodkod.instance.Universe getUniverse() {
    return universe;
  }

  public kodkod.instance.Bounds getBounds() {
    return bounds;
  }

  public java.util.Map<String, kodkod.ast.Relation> getRelations() {
    return relations;
  }

  private void reportError(ParserRuleContext ctx, String token, String text) {
    System.err.println(text + ": '" + token + "' at line " + ctx.start.getLine() + " - position["
        + ctx.start.getStartIndex() + "," + ctx.start.getStopIndex() + "]");
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitProblem(ProblemContext ctx) {
    final List<kodkod.ast.Formula> formulas = new ArrayList<kodkod.ast.Formula>();
    for (FormulaContext formula : ctx.formula()) {
      if (!declarations.isEmpty())
        declarations.clear();
      if (!setOfDisjVars.isEmpty())
        setOfDisjVars.clear();
      kodkod.ast.Node node = this.visit(formula);
      System.out.println("Declarations in the formula Context: " + declarations);
      System.out.println(node);
      formulas.add((kodkod.ast.Formula) node);
    }
    return kodkod.ast.Formula.and(formulas);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitUniverse(UniverseContext ctx) {
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitRelations(RelationsContext ctx) {
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitTupleSet(TupleSetContext ctx) {
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitTuple(TupleContext ctx) {
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitAtom(AtomContext ctx) {
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitRelation(RelationContext ctx) {
    kodkod.ast.Relation relation = null;
    String name = ctx.getText();
    if (ctx.getParent() instanceof FunctionContext) {
      if (relations.containsKey(name)) {
        relation = relations.get(name);
        return relation;
      }
    }
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitVariableId(VariableIdContext ctx) {
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitInteger(IntegerContext ctx) {
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitArity(ArityContext ctx) {
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitNo(NoContext ctx) {
    kodkod.ast.Expression expr = (kodkod.ast.Expression) this.visit(ctx.expression());
    return expr.no();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitSome(SomeContext ctx) {
    kodkod.ast.Expression expr = (kodkod.ast.Expression) this.visit(ctx.expression());
    return expr.some();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitForOne(ForOneContext ctx) {
    kodkod.ast.Decls decls = (kodkod.ast.Decls) this.visit(ctx.decls());
    Iterator<FormulaContext> iterator = ctx.formula().iterator();
    final java.util.Map<kodkod.ast.Node, kodkod.ast.Node> variableReplacement =
        new java.util.HashMap<kodkod.ast.Node, kodkod.ast.Node>();
    kodkod.ast.Formula formula = null;
    if (iterator.hasNext()) {
      formula = (kodkod.ast.Formula) this.visit(iterator.next());
      while (iterator.hasNext()) {
        formula = formula.and((kodkod.ast.Formula) this.visit(iterator.next()));
      }

      kodkod.ast.Decls primedDecls = null;
      List<kodkod.ast.Formula> andFormulas =
          new ArrayList<kodkod.ast.Formula>();
      Iterator<kodkod.ast.Decl> declIterator = decls.iterator();
      if (declIterator.hasNext()) {
        kodkod.ast.Decl decl = declIterator.next();
        Variable x = Variable.unary(decl.variable().name() + "'");
        variableReplacement.put(decl.variable(), x);
        // oneof?
        primedDecls = x.oneOf(decl.expression());
        andFormulas.add(x.eq(decl.variable()));
        while (declIterator.hasNext()) {
          decl = declIterator.next();
          x = Variable.unary(decl.variable().name() + "'");
          primedDecls = primedDecls.and(x.oneOf(decl.expression()));
          andFormulas.add(x.eq(decl.variable()));
        }
      }

      final kodkod.ast.visitor.AbstractReplacer replacer =
          new kodkod.ast.visitor.AbstractReplacer(variableReplacement.keySet()) {
            public kodkod.ast.Expression visit(Variable variable) {
              System.out.println(PrettyPrinter.print(variable, 2));
              return variableReplacement.containsKey(variable)
                  ? (Variable) variableReplacement.get(variable) : variable;
            }
          };

      formula = formula.accept(replacer).iff(kodkod.ast.Formula.and(andFormulas))
          .forAll(primedDecls).forSome(decls);;

    }
    return formula;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitSumDeclaration(SumDeclarationContext ctx) {
    // TODO visitSumDeclaration
    return visitChildren(ctx);
  }



  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitLone(LoneContext ctx) {
    kodkod.ast.Expression expr = (kodkod.ast.Expression) this.visit(ctx.expression());
    return expr.lone();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitLt(LtContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return ctx.not == null ? left.lt(right) : left.lt(right).not();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitForSome(ForSomeContext ctx) {
    kodkod.ast.Decls decls = (kodkod.ast.Decls) this.visit(ctx.decls());
    Iterator<FormulaContext> iterator = ctx.formula().iterator();
    kodkod.ast.Formula formula = null;
    if (iterator.hasNext()) {
      formula = (kodkod.ast.Formula) this.visit(iterator.next());
      while (iterator.hasNext()) {
        formula = formula.and((kodkod.ast.Formula) this.visit(iterator.next()));
      }
      if (!setOfDisjVars.isEmpty())
        formula = implementDisjOperatorOverFormula().and(formula).forSome(decls);
      else
        formula = formula.forSome(decls);
    }
    return formula;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitNot(NotContext ctx) {
    kodkod.ast.Formula formula = (kodkod.ast.Formula) this.visit(ctx.formula());
    return formula.not();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitF_paranthesis(F_paranthesisContext ctx) {
    return this.visit(ctx.formula());
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitAnd(AndContext ctx) {
    kodkod.ast.Formula left = (kodkod.ast.Formula) this.visit(ctx.fleft);
    kodkod.ast.Formula right = (kodkod.ast.Formula) this.visit(ctx.fright);
    return left.and(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitFunction(FunctionContext ctx) {
    kodkod.ast.Formula formula = null;
    kodkod.ast.Relation relation = (kodkod.ast.Relation) this.visit(ctx.relationId());
    kodkod.ast.Expression domain = (kodkod.ast.Expression) this.visit(ctx.domain);
    kodkod.ast.Expression range = (kodkod.ast.Expression) this.visit(ctx.range);
    if (ctx.op.getText().equals("one")) {
      formula = relation.function(domain, range);
    } else if (ctx.op.getText().equals("lone")) {
      formula = relation.partialFunction(domain, range);
    }
    return formula;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitGte(GteContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return ctx.not == null ? left.gte(right) : left.gte(right).not();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitAcyclic(AcyclicContext ctx) {
    kodkod.ast.Relation rel = (kodkod.ast.Relation) this.visit(ctx.relationId());
    return rel.acyclic();
  }



  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitLte(LteContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return ctx.not == null ? left.lte(right) : left.lte(right).not();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitOr(OrContext ctx) {
    kodkod.ast.Formula left = (kodkod.ast.Formula) this.visit(ctx.fleft);
    kodkod.ast.Formula right = (kodkod.ast.Formula) this.visit(ctx.fright);
    return left.or(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitIn(InContext ctx) {
    kodkod.ast.Expression left = (kodkod.ast.Expression) this.visit(ctx.left);
    kodkod.ast.Expression right = (kodkod.ast.Expression) this.visit(ctx.right);
    return ctx.not == null ? left.in(right) : left.in(right).not();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitOne(OneContext ctx) {
    kodkod.ast.Expression expr = (kodkod.ast.Expression) this.visit(ctx.expression());
    return expr.one();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitFalse(FalseContext ctx) {
    return kodkod.ast.Formula.FALSE;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitIff(IffContext ctx) {
    kodkod.ast.Formula left = (kodkod.ast.Formula) this.visit(ctx.fleft);
    kodkod.ast.Formula right = (kodkod.ast.Formula) this.visit(ctx.fright);
    return left.iff(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitEq(EqContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return ctx.not == null ? left.eq(right) : left.eq(right).not();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitGt(GtContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return ctx.not == null ? left.gt(right) : left.gt(right).not();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitEqual(EqualContext ctx) {
    kodkod.ast.Expression left = (kodkod.ast.Expression) this.visit(ctx.left);
    kodkod.ast.Expression right = (kodkod.ast.Expression) this.visit(ctx.right);
    return ctx.not == null ? left.eq(right) : left.eq(right).not();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitForLone(ForLoneContext ctx) {
    kodkod.ast.Decls decls = (kodkod.ast.Decls) this.visit(ctx.decls());
    Iterator<FormulaContext> iterator = ctx.formula().iterator();
    final java.util.Map<kodkod.ast.Node, kodkod.ast.Node> variableReplacement =
        new java.util.HashMap<kodkod.ast.Node, kodkod.ast.Node>();
    kodkod.ast.Formula formula = null;
    if (iterator.hasNext()) {
      formula = (kodkod.ast.Formula) this.visit(iterator.next());
      while (iterator.hasNext()) {
        formula = formula.and((kodkod.ast.Formula) this.visit(iterator.next()));
      }

      kodkod.ast.Decls primedDecls = null;
      List<kodkod.ast.Formula> andFormulas =
          new ArrayList<kodkod.ast.Formula>();
      Iterator<kodkod.ast.Decl> declIterator = decls.iterator();
      if (declIterator.hasNext()) {
        kodkod.ast.Decl decl = declIterator.next();
        Variable x = Variable.unary(decl.variable().name() + "'");
        variableReplacement.put(decl.variable(), x);
        // oneof?
        primedDecls = x.oneOf(decl.expression());
        andFormulas.add(x.eq(decl.variable()));
        while (declIterator.hasNext()) {
          decl = declIterator.next();
          x = Variable.unary(decl.variable().name() + "'");
          primedDecls = primedDecls.and(x.oneOf(decl.expression()));
          andFormulas.add(x.eq(decl.variable()));
        }
      }

      final kodkod.ast.visitor.AbstractReplacer replacer =
          new kodkod.ast.visitor.AbstractReplacer(variableReplacement.keySet()) {
            public kodkod.ast.Expression visit(Variable variable) {
              System.out.println(PrettyPrinter.print(variable, 2));
              return variableReplacement.containsKey(variable)
                  ? (Variable) variableReplacement.get(variable) : variable;
            }
          };

      formula = formula.and(formula.accept(replacer)).implies(kodkod.ast.Formula.and(andFormulas))
          .forAll(primedDecls).forAll(decls);;

    }
    return formula;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitTotalOrder(TotalOrderContext ctx) {
    kodkod.ast.Relation relation = (kodkod.ast.Relation) this.visit(ctx.rel);
    kodkod.ast.Relation ordered = (kodkod.ast.Relation) this.visit(ctx.ordered);
    kodkod.ast.Relation first = (kodkod.ast.Relation) this.visit(ctx.first);
    kodkod.ast.Relation last = (kodkod.ast.Relation) this.visit(ctx.last);
    return relation.totalOrder(ordered, first, last);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitTrue(TrueContext ctx) {
    return kodkod.ast.Formula.TRUE;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   *
   * no disj p1, p2: Pigeon | p1.hole = p2.hole
   *
   * @formatter:off
   * final Variable p1 = Variable.unary("p1");
   * final Variable p2 = Variable.unary("p2");
   * return (p1.eq(p2).not().
   *    implies(p1.join(hole).intersection(p2.join(hole))
   *        .no())).forAll(p1.oneOf(Pigeon).and(p2.oneOf(Pigeon)));
   *
   * @formatter:on
   * </p>
   */
  @Override
  public kodkod.ast.Node visitForNo(ForNoContext ctx) {
    kodkod.ast.Decls decls = (kodkod.ast.Decls) this.visit(ctx.decls());
    Iterator<FormulaContext> iterator = ctx.formula().iterator();
    kodkod.ast.Formula formula = null;
    if (iterator.hasNext()) {
      formula = (kodkod.ast.Formula) this.visit(iterator.next());
      while (iterator.hasNext()) {
        formula = formula.and((kodkod.ast.Formula) this.visit(iterator.next()));
      }
      if (!setOfDisjVars.isEmpty())
        formula = implementDisjOperatorOverFormula().implies(formula.not()).forAll(decls);
      else
        formula = formula.not().forAll(decls);
    }
    return formula;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitImplies(ImpliesContext ctx) {
    kodkod.ast.Formula left = (kodkod.ast.Formula) this.visit(ctx.fleft);
    kodkod.ast.Formula right = (kodkod.ast.Formula) this.visit(ctx.fright);
    return left.implies(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitProduct(ProductContext ctx) {
    kodkod.ast.Expression left = (kodkod.ast.Expression) this.visit(ctx.left);
    kodkod.ast.Expression right = (kodkod.ast.Expression) this.visit(ctx.right);
    return left.product(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitNone(NoneContext ctx) {
    return kodkod.ast.LeafExpression.NONE;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitUnion(UnionContext ctx) {
    kodkod.ast.Expression left = (kodkod.ast.Expression) this.visit(ctx.left);
    kodkod.ast.Expression right = (kodkod.ast.Expression) this.visit(ctx.right);
    return left.union(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitBoxjoin(BoxjoinContext ctx) {
    kodkod.ast.Expression left = (kodkod.ast.Expression) this.visit(ctx.left);
    kodkod.ast.Expression right = (kodkod.ast.Expression) this.visit(ctx.right);
    return left.join(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitComprehension(ComprehensionContext ctx) {
    // TODO visitComprehension
    return visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitUniv(UnivContext ctx) {
    return kodkod.ast.LeafExpression.UNIV;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitReflexive(ReflexiveContext ctx) {
    kodkod.ast.Expression expr = (kodkod.ast.Expression) this.visit(ctx.expression());
    return expr.reflexiveClosure();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitE_paranthesis(E_paranthesisContext ctx) {
    return this.visit(ctx.expression());
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitIden(IdenContext ctx) {
    return kodkod.ast.LeafExpression.IDEN;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitInts(IntsContext ctx) {
    return kodkod.ast.LeafExpression.INTS;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitIntersection(IntersectionContext ctx) {
    kodkod.ast.Expression left = (kodkod.ast.Expression) this.visit(ctx.left);
    kodkod.ast.Expression right = (kodkod.ast.Expression) this.visit(ctx.right);
    return left.intersection(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitRel(RelContext ctx) {
    String name = ctx.getText();
    kodkod.ast.Relation rel = null;
    if (relations.containsKey(name))
      rel = relations.get(name);
    else
      reportError(ctx, name, "Relation is undefined");
    return rel;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitDifference(DifferenceContext ctx) {
    kodkod.ast.Expression left = (kodkod.ast.Expression) this.visit(ctx.left);
    kodkod.ast.Expression right = (kodkod.ast.Expression) this.visit(ctx.right);
    return left.difference(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitTranspose(TransposeContext ctx) {
    kodkod.ast.Expression expr = (kodkod.ast.Expression) this.visit(ctx.expression());
    return expr.transpose();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitJoin(JoinContext ctx) {
    kodkod.ast.Expression left = (kodkod.ast.Expression) this.visit(ctx.left);
    kodkod.ast.Expression right = (kodkod.ast.Expression) this.visit(ctx.right);
    return left.join(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitOverride(OverrideContext ctx) {
    kodkod.ast.Expression left = (kodkod.ast.Expression) this.visit(ctx.left);
    kodkod.ast.Expression right = (kodkod.ast.Expression) this.visit(ctx.right);
    return left.override(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitIfExpression(IfExpressionContext ctx) {
    kodkod.ast.Formula condition = (kodkod.ast.Formula) this.visit(ctx.condition);
    kodkod.ast.Expression thenExpr = (kodkod.ast.Expression) this.visit(ctx.thenExpr);
    kodkod.ast.Expression elseExpr = (kodkod.ast.Expression) this.visit(ctx.elseExpr);
    return condition.thenElse(thenExpr, elseExpr);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitClosure(ClosureContext ctx) {
    kodkod.ast.Expression expr = (kodkod.ast.Expression) this.visit(ctx.expression());
    return expr.closure();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitMinus(MinusContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return left.minus(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitIntConstant(IntConstantContext ctx) {
    int integer = 0;
    if (ctx.sign != null || !ctx.sign.getText().isEmpty())
      integer = Integer.valueOf(ctx.integer().getText());
    else
      integer = Integer.valueOf("-" + ctx.integer().getText());
    return kodkod.ast.IntConstant.constant(integer);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitI_paranthesis(I_paranthesisContext ctx) {
    return this.visit(ctx.intexpression());
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitIfIntExpression(IfIntExpressionContext ctx) {
    kodkod.ast.Formula condition = (kodkod.ast.Formula) this.visit(ctx.condition);
    kodkod.ast.IntExpression thenExpr = (kodkod.ast.IntExpression) this.visit(ctx.thenExpr);
    kodkod.ast.IntExpression elseExpr = (kodkod.ast.IntExpression) this.visit(ctx.elseExpr);
    return condition.thenElse(thenExpr, elseExpr);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitCount(CountContext ctx) {
    kodkod.ast.Expression expr = (kodkod.ast.Expression) this.visit(ctx.expression());
    return expr.count();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitSum(SumContext ctx) {
    kodkod.ast.Expression expr = (kodkod.ast.Expression) this.visit(ctx.expression());
    return expr.sum();
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitDivide(DivideContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return left.divide(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitMultiply(MultiplyContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return left.multiply(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitModulo(ModuloContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return left.modulo(right);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitPlus(PlusContext ctx) {
    kodkod.ast.IntExpression left = (kodkod.ast.IntExpression) this.visit(ctx.ileft);
    kodkod.ast.IntExpression right = (kodkod.ast.IntExpression) this.visit(ctx.iright);
    return left.plus(right);
  }


  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitLet(LetContext ctx) {
    this.visit(ctx.letDecls());
    kodkod.ast.Formula formula = null;
    Iterator<FormulaContext> iterator = ctx.formula().iterator();
    if (iterator.hasNext()) {
      formula = (kodkod.ast.Formula) this.visit(iterator.next());
      while (iterator.hasNext()) {
        formula = formula.and((kodkod.ast.Formula) this.visit(iterator.next()));
      }
    }
    return formula;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitLetDecls(LetDeclsContext ctx) {
    Iterator<LetDeclContext> iterator = ctx.letDecl().iterator();
    while (iterator.hasNext()) {
      this.visit(iterator.next());
    }
    return null;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitLetDecl(LetDeclContext ctx) {
    kodkod.ast.Expression expression = (kodkod.ast.Expression) this.visit(ctx.expression());
    List<VariableIdContext> variableContexts = ctx.variableId();
    for (VariableIdContext variableContext : variableContexts) {
      String name = variableContext.getText();
      if (!declarations.containsKey(name))
        declarations.put(name, expression);
    }
    return null;
  }


  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitVar(VarContext ctx) {
    kodkod.ast.Node node = null;
    String name = ctx.variableId().getText();
    if (declarations.containsKey(name)) {
      if (declarations.get(name) instanceof Variable) {
        node = (Variable) declarations.get(name);
      } else if (declarations.get(name) instanceof kodkod.ast.Expression)
        node = (kodkod.ast.Expression) declarations.get(name);
    } else
      reportError(ctx.variableId(), name, "Variable is not declared in the context");
    return node;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitForAll(ForAllContext ctx) {
    kodkod.ast.Decls decls = (kodkod.ast.Decls) this.visit(ctx.decls());
    Iterator<FormulaContext> iterator = ctx.formula().iterator();
    kodkod.ast.Formula formula = null;
    if (iterator.hasNext()) {
      formula = (kodkod.ast.Formula) this.visit(iterator.next());
      while (iterator.hasNext()) {
        formula = formula.and((kodkod.ast.Formula) this.visit(iterator.next()));
      }
      if (!setOfDisjVars.isEmpty())
        formula = implementDisjOperatorOverFormula().implies(formula).forAll(decls);
      else
        formula = formula.forAll(decls);
    }
    return formula;
  }

  private kodkod.ast.Formula implementDisjOperatorOverFormula() {

    List<kodkod.ast.Formula> listOfDisjFormulas =
        new ArrayList<kodkod.ast.Formula>();

    for (List<Variable> disjVars : setOfDisjVars) {
      if (disjVars.size() > 1) {
        Iterator<Variable> iterator = disjVars.iterator();
        Variable var1 = iterator.next();
        Variable var2 = iterator.next();
        kodkod.ast.Formula formula = var1.eq(var2).not();
        while (iterator.hasNext()) {
          Variable var3 = iterator.next();
          formula = formula.and(var2.eq(var3).not());
          var2 = var3;
        }
        listOfDisjFormulas.add(formula);
      }
    }

    kodkod.ast.Formula andOfDisjFormula = null;
    if (!listOfDisjFormulas.isEmpty()) {
      Iterator<kodkod.ast.Formula> iterator = listOfDisjFormulas.iterator();
      if (iterator.hasNext()) {
        andOfDisjFormula = iterator.next();
        while (iterator.hasNext()) {
          andOfDisjFormula = andOfDisjFormula.and(iterator.next());
        }
      }
    }
    return andOfDisjFormula;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitDecls(DeclsContext ctx) {
    Iterator<DeclContext> iterator = ctx.decl().iterator();
    kodkod.ast.Decls decls = null;
    if (iterator.hasNext()) {
      decls = (kodkod.ast.Decls) this.visit(iterator.next());
      while (iterator.hasNext()) {
        decls = decls.and((kodkod.ast.Decls) this.visit(iterator.next()));
      }
    }
    return decls;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitOneOf(OneOfContext ctx) {
    kodkod.ast.Expression expression = (kodkod.ast.Expression) this.visit(ctx.expression());
    int arity = expression.arity();
    List<Variable> disjVars = new ArrayList<>();
    boolean isDisj = ctx.disj != null ? true : false;
    Iterator<VariableIdContext> iterator = ctx.variableId().iterator();
    kodkod.ast.Decls decls = null;
    if (iterator.hasNext()) {
      String name = iterator.next().getText();
      Variable var = null;
      if (arity == 1)
        var = Variable.unary(name);
      else
        var = Variable.nary(name, arity);
      decls = var.oneOf(expression);
      if (isDisj)
        disjVars.add(var);
      if (!declarations.containsKey(name))
        declarations.put(name, var);
      while (iterator.hasNext()) {
        name = iterator.next().getText();
        if (arity == 1)
          var = Variable.unary(name);
        else
          var = Variable.nary(name, arity);
        decls = decls.and(var.oneOf(expression));
        if (isDisj)
          disjVars.add(var);
        if (!declarations.containsKey(name))
          declarations.put(name, var);
      }
    }
    if (!disjVars.isEmpty())
      setOfDisjVars.add(disjVars);
    return decls;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitLoneOf(LoneOfContext ctx) {
    kodkod.ast.Expression expression = (kodkod.ast.Expression) this.visit(ctx.expression());
    int arity = expression.arity();
    List<Variable> disjVars = new ArrayList<>();
    boolean isDisj = ctx.disj != null ? true : false;
    Iterator<VariableIdContext> iterator = ctx.variableId().iterator();
    kodkod.ast.Decls decls = null;
    if (iterator.hasNext()) {
      String name = iterator.next().getText();
      Variable var = null;
      if (arity == 1)
        var = Variable.unary(name);
      else
        var = Variable.nary(name, arity);
      decls = var.oneOf(expression);
      if (isDisj)
        disjVars.add(var);
      if (!declarations.containsKey(name))
        declarations.put(name, var);
      while (iterator.hasNext()) {
        name = iterator.next().getText();
        if (arity == 1)
          var = Variable.unary(name);
        else
          var = Variable.nary(name, arity);
        decls = decls.and(var.loneOf(expression));
        if (isDisj)
          disjVars.add(var);
        if (!declarations.containsKey(name))
          declarations.put(name, var);
      }
    }
    if (!disjVars.isEmpty())
      setOfDisjVars.add(disjVars);
    return decls;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitSomeOf(SomeOfContext ctx) {
    kodkod.ast.Expression expression = (kodkod.ast.Expression) this.visit(ctx.expression());
    int arity = expression.arity();
    List<Variable> disjVars = new ArrayList<>();
    boolean isDisj = ctx.disj != null ? true : false;
    Iterator<VariableIdContext> iterator = ctx.variableId().iterator();
    kodkod.ast.Decls decls = null;
    if (iterator.hasNext()) {
      String name = iterator.next().getText();
      Variable var = null;
      if (arity == 1)
        var = Variable.unary(name);
      else
        var = Variable.nary(name, arity);
      decls = var.oneOf(expression);
      if (isDisj)
        disjVars.add(var);
      if (!declarations.containsKey(name))
        declarations.put(name, var);
      while (iterator.hasNext()) {
        name = iterator.next().getText();
        if (arity == 1)
          var = Variable.unary(name);
        else
          var = Variable.nary(name, arity);
        decls = decls.and(var.someOf(expression));
        if (isDisj)
          disjVars.add(var);
        if (!declarations.containsKey(name))
          declarations.put(name, var);
      }
    }
    if (!disjVars.isEmpty())
      setOfDisjVars.add(disjVars);
    return decls;
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public kodkod.ast.Node visitSetOf(SetOfContext ctx) {
    kodkod.ast.Expression expression = (kodkod.ast.Expression) this.visit(ctx.expression());
    int arity = expression.arity();
    List<Variable> disjVars = new ArrayList<>();
    boolean isDisj = ctx.disj != null ? true : false;
    Iterator<VariableIdContext> iterator = ctx.variableId().iterator();
    kodkod.ast.Decls decls = null;
    if (iterator.hasNext()) {
      String name = iterator.next().getText();
      Variable var = null;
      if (arity == 1)
        var = Variable.unary(name);
      else
        var = Variable.nary(name, arity);
      decls = var.oneOf(expression);
      if (isDisj)
        disjVars.add(var);
      if (!declarations.containsKey(name))
        declarations.put(name, var);
      while (iterator.hasNext()) {
        name = iterator.next().getText();
        if (arity == 1)
          var = Variable.unary(name);
        else
          var = Variable.nary(name, arity);
        decls = decls.and(var.setOf(expression));
        if (isDisj)
          disjVars.add(var);
        if (!declarations.containsKey(name))
          declarations.put(name, var);
      }
    }
    if (!disjVars.isEmpty())
      setOfDisjVars.add(disjVars);
    return decls;
  }
}


