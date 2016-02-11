// Generated from C:/Users/anil.ozturk/IdeaProjects/untitled1/src\Kodkod.g4 by ANTLR 4.5.1
package eu.modelwriter.kodkod.core.recognizer;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KodkodParser extends Parser {
  public static class AcyclicContext extends FormulaContext {
    public AcyclicContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitAcyclic(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterAcyclic(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitAcyclic(this);
      }
    }

    public RelationContext relation() {
      return this.getRuleContext(RelationContext.class, 0);
    }
  }

  public static class AndContext extends FormulaContext {
    public FormulaContext left;
    public Token op;
    public FormulaContext right;

    public AndContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitAnd(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterAnd(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitAnd(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }
  }
  public static class ArityContext extends ParserRuleContext {
    public ArityContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitArity(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterArity(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitArity(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_arity;
    }

    public TerminalNode INT() {
      return this.getToken(KodkodParser.INT, 0);
    }
  }
  public static class AtomContext extends ParserRuleContext {
    public Token id;

    public AtomContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitAtom(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterAtom(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitAtom(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_atom;
    }

    public TerminalNode IDENTIFIER() {
      return this.getToken(KodkodParser.IDENTIFIER, 0);
    }

    public TerminalNode INT() {
      return this.getToken(KodkodParser.INT, 0);
    }
  }
  public static class BitWidthContext extends OptionContext {
    public BitWidthContext(final OptionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitBitWidth(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterBitWidth(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitBitWidth(this);
      }
    }

    public IntegerContext integer() {
      return this.getRuleContext(IntegerContext.class, 0);
    }
  }
  public static class BoxjoinContext extends ExpressionContext {
    public ExpressionContext right;
    public ExpressionContext left;

    public BoxjoinContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitBoxjoin(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterBoxjoin(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitBoxjoin(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }
  }

  public static class CartesianProductContext extends TypeContext {
    public TypeContext left;
    public Token leftMult;
    public Token rightMult;
    public TypeContext right;

    public CartesianProductContext(final TypeContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitCartesianProduct(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterCartesianProduct(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitCartesianProduct(this);
      }
    }

    public List<TypeContext> type() {
      return this.getRuleContexts(TypeContext.class);
    }

    public TypeContext type(final int i) {
      return this.getRuleContext(TypeContext.class, i);
    }
  }
  public static class ClosureContext extends ExpressionContext {
    public ClosureContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitClosure(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterClosure(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitClosure(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }
  public static class ComprehensionContext extends ExpressionContext {
    public ComprehensionContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitComprehension(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public ComprehensionDeclsContext comprehensionDecls() {
      return this.getRuleContext(ComprehensionDeclsContext.class, 0);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterComprehension(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitComprehension(this);
      }
    }

    public FormulaContext formula() {
      return this.getRuleContext(FormulaContext.class, 0);
    }
  }

  public static class ComprehensionDeclContext extends ParserRuleContext {
    public Token disj;
    public VariableContext variable;
    public List<VariableContext> vars = new ArrayList<VariableContext>();

    public ComprehensionDeclContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitComprehensionDecl(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterComprehensionDecl(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitComprehensionDecl(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_comprehensionDecl;
    }

    public List<VariableContext> variable() {
      return this.getRuleContexts(VariableContext.class);
    }

    public VariableContext variable(final int i) {
      return this.getRuleContext(VariableContext.class, i);
    }
  }
  public static class ComprehensionDeclsContext extends ParserRuleContext {
    public ComprehensionDeclsContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitComprehensionDecls(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public List<ComprehensionDeclContext> comprehensionDecl() {
      return this.getRuleContexts(ComprehensionDeclContext.class);
    }

    public ComprehensionDeclContext comprehensionDecl(final int i) {
      return this.getRuleContext(ComprehensionDeclContext.class, i);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterComprehensionDecls(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitComprehensionDecls(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_comprehensionDecls;
    }
  }

  public static class CountContext extends IntexpressionContext {
    public CountContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitCount(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterCount(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitCount(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }

  public static class DeclContext extends ParserRuleContext {
    public DeclContext() {}

    public DeclContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    public void copyFrom(final DeclContext ctx) {
      super.copyFrom(ctx);
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_decl;
    }
  }

  public static class DeclsContext extends ParserRuleContext {
    public DeclsContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitDecls(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public List<DeclContext> decl() {
      return this.getRuleContexts(DeclContext.class);
    }

    public DeclContext decl(final int i) {
      return this.getRuleContext(DeclContext.class, i);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterDecls(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitDecls(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_decls;
    }
  }

  public static class DifferenceContext extends ExpressionContext {
    public ExpressionContext left;
    public ExpressionContext right;

    public DifferenceContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitDifference(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterDifference(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitDifference(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }
  }

  public static class DivideContext extends IntexpressionContext {
    public IntexpressionContext left;
    public IntexpressionContext right;

    public DivideContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitDivide(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterDivide(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitDivide(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }

  public static class E_paranthesisContext extends ExpressionContext {
    public E_paranthesisContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitE_paranthesis(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterE_paranthesis(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitE_paranthesis(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }


  public static class EqContext extends FormulaContext {
    public IntexpressionContext left;
    public Token not;
    public IntexpressionContext right;

    public EqContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitEq(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterEq(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitEq(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }
  public static class EqualContext extends FormulaContext {
    public ExpressionContext left;
    public Token not;
    public ExpressionContext right;

    public EqualContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitEqual(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterEqual(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitEqual(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }
  }
  public static class ExpressionContext extends ParserRuleContext {
    public ExpressionContext() {}

    public ExpressionContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    public void copyFrom(final ExpressionContext ctx) {
      super.copyFrom(ctx);
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_expression;
    }
  }
  public static class F_paranthesisContext extends FormulaContext {
    public F_paranthesisContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitF_paranthesis(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterF_paranthesis(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitF_paranthesis(this);
      }
    }

    public FormulaContext formula() {
      return this.getRuleContext(FormulaContext.class, 0);
    }
  }
  public static class FalseContext extends FormulaContext {
    public FalseContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitFalse(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterFalse(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitFalse(this);
      }
    }
  }
  public static class ForAllContext extends FormulaContext {
    public ForAllContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitForAll(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public DeclsContext decls() {
      return this.getRuleContext(DeclsContext.class, 0);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterForAll(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitForAll(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }
  }

  public static class ForLoneContext extends FormulaContext {
    public ForLoneContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitForLone(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public DeclsContext decls() {
      return this.getRuleContext(DeclsContext.class, 0);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterForLone(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitForLone(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }
  }
  public static class FormulaContext extends ParserRuleContext {
    public int var = 0;;

    public FormulaContext() {}

    public FormulaContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    public void copyFrom(final FormulaContext ctx) {
      super.copyFrom(ctx);
      this.var = ctx.var;
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_formula;
    }
  }
  public static class ForNoContext extends FormulaContext {
    public ForNoContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitForNo(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public DeclsContext decls() {
      return this.getRuleContext(DeclsContext.class, 0);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterForNo(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitForNo(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }
  }
  public static class ForOneContext extends FormulaContext {
    public ForOneContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitForOne(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public DeclsContext decls() {
      return this.getRuleContext(DeclsContext.class, 0);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterForOne(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitForOne(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }
  }

  public static class ForSomeContext extends FormulaContext {
    public ForSomeContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitForSome(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public DeclsContext decls() {
      return this.getRuleContext(DeclsContext.class, 0);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterForSome(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitForSome(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }
  }
  public static class FunctionContext extends FormulaContext {
    public RelationContext rel;
    public ExpressionContext domain;
    public Token op;
    public ExpressionContext range;

    public FunctionContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitFunction(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterFunction(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitFunction(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }

    public RelationContext relation() {
      return this.getRuleContext(RelationContext.class, 0);
    }
  }

  public static class GtContext extends FormulaContext {
    public IntexpressionContext left;
    public Token not;
    public IntexpressionContext right;

    public GtContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitGt(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterGt(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitGt(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }

  public static class GteContext extends FormulaContext {
    public IntexpressionContext left;
    public Token not;
    public IntexpressionContext right;

    public GteContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitGte(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterGte(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitGte(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }

  public static class I_paranthesisContext extends IntexpressionContext {
    public I_paranthesisContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitI_paranthesis(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterI_paranthesis(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitI_paranthesis(this);
      }
    }

    public IntexpressionContext intexpression() {
      return this.getRuleContext(IntexpressionContext.class, 0);
    }
  }

  public static class IdenContext extends ExpressionContext {
    public IdenContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitIden(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterIden(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitIden(this);
      }
    }
  }
  public static class IfExpressionContext extends ExpressionContext {
    public Token op;
    public FormulaContext condition;
    public ExpressionContext thenExpr;
    public ExpressionContext elseExpr;

    public IfExpressionContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitIfExpression(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterIfExpression(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitIfExpression(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }

    public FormulaContext formula() {
      return this.getRuleContext(FormulaContext.class, 0);
    }
  }
  public static class IffContext extends FormulaContext {
    public FormulaContext left;
    public Token op;
    public FormulaContext right;

    public IffContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitIff(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterIff(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitIff(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }
  }
  public static class IfIntExpressionContext extends IntexpressionContext {
    public Token op;
    public FormulaContext condition;
    public IntexpressionContext thenExpr;
    public IntexpressionContext elseExpr;

    public IfIntExpressionContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitIfIntExpression(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterIfIntExpression(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitIfIntExpression(this);
      }
    }

    public FormulaContext formula() {
      return this.getRuleContext(FormulaContext.class, 0);
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }
  public static class ImpliesContext extends FormulaContext {
    public FormulaContext left;
    public Token op;
    public FormulaContext right;

    public ImpliesContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitImplies(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterImplies(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitImplies(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }
  }

  public static class InContext extends FormulaContext {
    public ExpressionContext left;
    public Token not;
    public ExpressionContext right;

    public InContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitIn(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterIn(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitIn(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }
  }

  public static class IntConstantContext extends IntexpressionContext {
    public Token sign;

    public IntConstantContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitIntConstant(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterIntConstant(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitIntConstant(this);
      }
    }

    public IntegerContext integer() {
      return this.getRuleContext(IntegerContext.class, 0);
    }
  }

  public static class IntegerContext extends ParserRuleContext {
    public IntegerContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitInteger(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterInteger(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitInteger(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_integer;
    }

    public TerminalNode INT() {
      return this.getToken(KodkodParser.INT, 0);
    }
  }

  public static class IntersectionContext extends ExpressionContext {
    public ExpressionContext left;
    public ExpressionContext right;

    public IntersectionContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitIntersection(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterIntersection(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitIntersection(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }
  }

  public static class IntexpressionContext extends ParserRuleContext {
    public IntexpressionContext() {}

    public IntexpressionContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    public void copyFrom(final IntexpressionContext ctx) {
      super.copyFrom(ctx);
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_intexpression;
    }
  }

  public static class IntsContext extends ExpressionContext {
    public IntsContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitInts(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterInts(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitInts(this);
      }
    }
  }
  public static class JoinContext extends ExpressionContext {
    public ExpressionContext left;
    public ExpressionContext right;

    public JoinContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitJoin(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterJoin(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitJoin(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }
  }
  public static class LetContext extends FormulaContext {
    public LetContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitLet(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterLet(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitLet(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }

    public LetDeclsContext letDecls() {
      return this.getRuleContext(LetDeclsContext.class, 0);
    }
  }
  public static class LetDeclContext extends ParserRuleContext {
    public VariableContext variable;
    public List<VariableContext> vars = new ArrayList<VariableContext>();

    public LetDeclContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitLetDecl(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterLetDecl(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitLetDecl(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_letDecl;
    }

    public List<VariableContext> variable() {
      return this.getRuleContexts(VariableContext.class);
    }

    public VariableContext variable(final int i) {
      return this.getRuleContext(VariableContext.class, i);
    }
  }
  public static class LetDeclsContext extends ParserRuleContext {
    public LetDeclsContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitLetDecls(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterLetDecls(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitLetDecls(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_letDecls;
    }

    public List<LetDeclContext> letDecl() {
      return this.getRuleContexts(LetDeclContext.class);
    }

    public LetDeclContext letDecl(final int i) {
      return this.getRuleContext(LetDeclContext.class, i);
    }
  }

  public static class LoneContext extends FormulaContext {
    public LoneContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitLone(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterLone(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitLone(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }

  public static class LoneOfContext extends DeclContext {
    public Token disj;
    public VariableContext variable;
    public List<VariableContext> vars = new ArrayList<VariableContext>();

    public LoneOfContext(final DeclContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitLoneOf(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterLoneOf(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitLoneOf(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }

    public List<VariableContext> variable() {
      return this.getRuleContexts(VariableContext.class);
    }

    public VariableContext variable(final int i) {
      return this.getRuleContext(VariableContext.class, i);
    }
  }

  public static class LtContext extends FormulaContext {
    public IntexpressionContext left;
    public Token not;
    public IntexpressionContext right;

    public LtContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitLt(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterLt(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitLt(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }

  public static class LteContext extends FormulaContext {
    public IntexpressionContext left;
    public Token not;
    public IntexpressionContext right;

    public LteContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitLte(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterLte(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitLte(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }

  public static class MinusContext extends IntexpressionContext {
    public IntexpressionContext left;
    public IntexpressionContext right;

    public MinusContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitMinus(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterMinus(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitMinus(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }

  public static class ModuloContext extends IntexpressionContext {
    public IntexpressionContext left;
    public IntexpressionContext right;

    public ModuloContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitModulo(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterModulo(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitModulo(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }

  public static class MultiplyContext extends IntexpressionContext {
    public IntexpressionContext left;
    public IntexpressionContext right;

    public MultiplyContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitMultiply(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterMultiply(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitMultiply(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }

  public static class NestedMultiplicityContext extends TypeContext {
    public NestedMultiplicityContext(final TypeContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitNestedMultiplicity(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterNestedMultiplicity(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitNestedMultiplicity(this);
      }
    }

    public TypeContext type() {
      return this.getRuleContext(TypeContext.class, 0);
    }
  }

  public static class NoContext extends FormulaContext {
    public NoContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitNo(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterNo(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitNo(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }

  public static class NoneContext extends ExpressionContext {
    public NoneContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitNone(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterNone(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitNone(this);
      }
    }
  }

  public static class NotContext extends FormulaContext {
    public Token op;

    public NotContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitNot(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterNot(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitNot(this);
      }
    }

    public FormulaContext formula() {
      return this.getRuleContext(FormulaContext.class, 0);
    }
  }

  public static class OneContext extends FormulaContext {
    public OneContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitOne(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterOne(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitOne(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }

  public static class OneOfContext extends DeclContext {
    public Token disj;
    public VariableContext variable;
    public List<VariableContext> vars = new ArrayList<VariableContext>();

    public OneOfContext(final DeclContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitOneOf(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterOneOf(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitOneOf(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }

    public List<VariableContext> variable() {
      return this.getRuleContexts(VariableContext.class);
    }

    public VariableContext variable(final int i) {
      return this.getRuleContext(VariableContext.class, i);
    }
  }

  public static class OptionContext extends ParserRuleContext {
    public OptionContext() {}

    public OptionContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    public void copyFrom(final OptionContext ctx) {
      super.copyFrom(ctx);
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_option;
    }
  }

  public static class OptionsContext extends ParserRuleContext {
    public OptionsContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitOptions(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterOptions(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitOptions(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_options;
    }

    public List<OptionContext> option() {
      return this.getRuleContexts(OptionContext.class);
    }

    public OptionContext option(final int i) {
      return this.getRuleContext(OptionContext.class, i);
    }
  }

  public static class OrContext extends FormulaContext {
    public FormulaContext left;
    public Token op;
    public FormulaContext right;

    public OrContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitOr(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterOr(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitOr(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }
  }

  public static class OverrideContext extends ExpressionContext {
    public ExpressionContext left;
    public ExpressionContext right;

    public OverrideContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitOverride(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterOverride(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitOverride(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }
  }
  public static class PlusContext extends IntexpressionContext {
    public IntexpressionContext left;
    public IntexpressionContext right;

    public PlusContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitPlus(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterPlus(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitPlus(this);
      }
    }

    public List<IntexpressionContext> intexpression() {
      return this.getRuleContexts(IntexpressionContext.class);
    }

    public IntexpressionContext intexpression(final int i) {
      return this.getRuleContext(IntexpressionContext.class, i);
    }
  }
  public static class ProblemContext extends ParserRuleContext {
    public FormulaContext formula;
    public List<FormulaContext> formulas = new ArrayList<FormulaContext>();

    public ProblemContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitProblem(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterProblem(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitProblem(this);
      }
    }

    public List<FormulaContext> formula() {
      return this.getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(final int i) {
      return this.getRuleContext(FormulaContext.class, i);
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_problem;
    }

    public OptionsContext options() {
      return this.getRuleContext(OptionsContext.class, 0);
    }

    public List<RelationsContext> relations() {
      return this.getRuleContexts(RelationsContext.class);
    }

    public RelationsContext relations(final int i) {
      return this.getRuleContext(RelationsContext.class, i);
    }

    public UniverseContext universe() {
      return this.getRuleContext(UniverseContext.class, 0);
    }
  }
  public static class ProductContext extends ExpressionContext {
    public ExpressionContext left;
    public ExpressionContext right;

    public ProductContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitProduct(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterProduct(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitProduct(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }
  }
  public static class ReflexiveContext extends ExpressionContext {
    public ReflexiveContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitReflexive(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterReflexive(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitReflexive(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }
  public static class RelationContext extends ParserRuleContext {
    public RelationContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitRelation(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterRelation(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitRelation(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_relation;
    }

    public TerminalNode IDENTIFIER() {
      return this.getToken(KodkodParser.IDENTIFIER, 0);
    }
  }
  public static class RelationsContext extends ParserRuleContext {
    public RelationContext relation;
    public ArityContext arity;
    public TupleSetContext lowerBound;
    public TupleSetContext upperBound;

    public RelationsContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitRelations(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public ArityContext arity() {
      return this.getRuleContext(ArityContext.class, 0);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterRelations(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitRelations(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_relations;
    }

    public RelationContext relation() {
      return this.getRuleContext(RelationContext.class, 0);
    }

    public List<TupleSetContext> tupleSet() {
      return this.getRuleContexts(TupleSetContext.class);
    }

    public TupleSetContext tupleSet(final int i) {
      return this.getRuleContext(TupleSetContext.class, i);
    }

    public TypeContext type() {
      return this.getRuleContext(TypeContext.class, 0);
    }
  }
  public static class RelContext extends ExpressionContext {
    public RelContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitRel(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterRel(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitRel(this);
      }
    }

    public RelationContext relation() {
      return this.getRuleContext(RelationContext.class, 0);
    }
  }
  public static class SetContext extends TypeContext {
    public SetContext(final TypeContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSet(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSet(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSet(this);
      }
    }

    public RelationContext relation() {
      return this.getRuleContext(RelationContext.class, 0);
    }
  }
  public static class SetOfContext extends DeclContext {
    public Token disj;
    public VariableContext variable;
    public List<VariableContext> vars = new ArrayList<VariableContext>();

    public SetOfContext(final DeclContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSetOf(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSetOf(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSetOf(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }

    public List<VariableContext> variable() {
      return this.getRuleContexts(VariableContext.class);
    }

    public VariableContext variable(final int i) {
      return this.getRuleContext(VariableContext.class, i);
    }
  }
  public static class SetOperationsOnTypesContext extends TypeContext {
    public TypeContext left;
    public Token op;
    public TypeContext right;

    public SetOperationsOnTypesContext(final TypeContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSetOperationsOnTypes(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSetOperationsOnTypes(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSetOperationsOnTypes(this);
      }
    }

    public List<TypeContext> type() {
      return this.getRuleContexts(TypeContext.class);
    }

    public TypeContext type(final int i) {
      return this.getRuleContext(TypeContext.class, i);
    }
  }
  public static class SharingContext extends OptionContext {
    public SharingContext(final OptionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSharing(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSharing(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSharing(this);
      }
    }

    public IntegerContext integer() {
      return this.getRuleContext(IntegerContext.class, 0);
    }
  }
  public static class SkolemDepthContext extends OptionContext {
    public SkolemDepthContext(final OptionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSkolemDepth(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSkolemDepth(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSkolemDepth(this);
      }
    }

    public IntegerContext integer() {
      return this.getRuleContext(IntegerContext.class, 0);
    }
  }
  public static class SomeContext extends FormulaContext {
    public SomeContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSome(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSome(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSome(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }
  public static class SomeOfContext extends DeclContext {
    public Token disj;
    public VariableContext variable;
    public List<VariableContext> vars = new ArrayList<VariableContext>();

    public SomeOfContext(final DeclContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSomeOf(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSomeOf(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSomeOf(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }

    public List<VariableContext> variable() {
      return this.getRuleContexts(VariableContext.class);
    }

    public VariableContext variable(final int i) {
      return this.getRuleContext(VariableContext.class, i);
    }
  }
  public static class SumContext extends IntexpressionContext {
    public SumContext(final IntexpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSum(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSum(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSum(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }
  public static class SumDeclarationContext extends FormulaContext {
    public SumDeclarationContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSumDeclaration(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public DeclsContext decls() {
      return this.getRuleContext(DeclsContext.class, 0);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSumDeclaration(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSumDeclaration(this);
      }
    }

    public IntexpressionContext intexpression() {
      return this.getRuleContext(IntexpressionContext.class, 0);
    }
  }
  public static class SymmetryBreakingContext extends OptionContext {
    public SymmetryBreakingContext(final OptionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitSymmetryBreaking(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterSymmetryBreaking(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitSymmetryBreaking(this);
      }
    }

    public IntegerContext integer() {
      return this.getRuleContext(IntegerContext.class, 0);
    }
  }
  public static class TotalOrderContext extends FormulaContext {
    public RelationContext rel;
    public RelationContext ordered;
    public RelationContext first;
    public RelationContext last;

    public TotalOrderContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitTotalOrder(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterTotalOrder(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitTotalOrder(this);
      }
    }

    public List<RelationContext> relation() {
      return this.getRuleContexts(RelationContext.class);
    }

    public RelationContext relation(final int i) {
      return this.getRuleContext(RelationContext.class, i);
    }
  }
  public static class TransposeContext extends ExpressionContext {
    public TransposeContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitTranspose(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterTranspose(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitTranspose(this);
      }
    }

    public ExpressionContext expression() {
      return this.getRuleContext(ExpressionContext.class, 0);
    }
  }
  public static class TrueContext extends FormulaContext {
    public TrueContext(final FormulaContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitTrue(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterTrue(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitTrue(this);
      }
    }
  }
  public static class TupleContext extends ParserRuleContext {
    public AtomContext atom;
    public List<AtomContext> atoms = new ArrayList<AtomContext>();

    public TupleContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitTuple(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public List<AtomContext> atom() {
      return this.getRuleContexts(AtomContext.class);
    }

    public AtomContext atom(final int i) {
      return this.getRuleContext(AtomContext.class, i);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterTuple(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitTuple(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_tuple;
    }
  }
  public static class TupleSetContext extends ParserRuleContext {
    public TupleContext tuple;
    public List<TupleContext> tuples = new ArrayList<TupleContext>();
    public ParserRuleContext left;
    public Token range;
    public ParserRuleContext right;

    public TupleSetContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitTupleSet(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterTupleSet(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitTupleSet(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_tupleSet;
    }

    public List<RelationContext> relation() {
      return this.getRuleContexts(RelationContext.class);
    }

    public RelationContext relation(final int i) {
      return this.getRuleContext(RelationContext.class, i);
    }

    public List<TupleContext> tuple() {
      return this.getRuleContexts(TupleContext.class);
    }

    public TupleContext tuple(final int i) {
      return this.getRuleContext(TupleContext.class, i);
    }
  }
  public static class TypeContext extends ParserRuleContext {
    public TypeContext() {}

    public TypeContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    public void copyFrom(final TypeContext ctx) {
      super.copyFrom(ctx);
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_type;
    }
  }
  public static class UnionContext extends ExpressionContext {
    public ExpressionContext left;
    public ExpressionContext right;

    public UnionContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitUnion(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterUnion(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitUnion(this);
      }
    }

    public List<ExpressionContext> expression() {
      return this.getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(final int i) {
      return this.getRuleContext(ExpressionContext.class, i);
    }
  }
  public static class UnivContext extends ExpressionContext {
    public UnivContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitUniv(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterUniv(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitUniv(this);
      }
    }
  }
  public static class UniverseContext extends ParserRuleContext {
    public AtomContext atom;
    public List<AtomContext> atoms = new ArrayList<AtomContext>();

    public UniverseContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitUniverse(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public List<AtomContext> atom() {
      return this.getRuleContexts(AtomContext.class);
    }

    public AtomContext atom(final int i) {
      return this.getRuleContext(AtomContext.class, i);
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterUniverse(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitUniverse(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_universe;
    }
  }
  public static class VarContext extends ExpressionContext {
    public VariableContext variable;

    public VarContext(final ExpressionContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitVar(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterVar(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitVar(this);
      }
    }

    public VariableContext variable() {
      return this.getRuleContext(VariableContext.class, 0);
    }
  }
  public static class VariableContext extends ParserRuleContext {
    public VariableContext(final ParserRuleContext parent, final int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(final ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof KodkodVisitor) {
        return ((KodkodVisitor<? extends T>) visitor).visitVariable(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).enterVariable(this);
      }
    }

    @Override
    public void exitRule(final ParseTreeListener listener) {
      if (listener instanceof KodkodListener) {
        ((KodkodListener) listener).exitVariable(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return KodkodParser.RULE_variable;
    }

    public TerminalNode IDENTIFIER() {
      return this.getToken(KodkodParser.IDENTIFIER, 0);
    }
  }

  static {
    RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;

  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();

  public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7,
      T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15,
      T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22,
      T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29,
      T__29 = 30, T__30 = 31, T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36,
      T__36 = 37, T__37 = 38, T__38 = 39, T__39 = 40, T__40 = 41, T__41 = 42, T__42 = 43,
      T__43 = 44, T__44 = 45, T__45 = 46, T__46 = 47, T__47 = 48, T__48 = 49, T__49 = 50,
      T__50 = 51, T__51 = 52, T__52 = 53, T__53 = 54, T__54 = 55, T__55 = 56, T__56 = 57,
      T__57 = 58, T__58 = 59, T__59 = 60, T__60 = 61, T__61 = 62, T__62 = 63, T__63 = 64,
      T__64 = 65, T__65 = 66, T__66 = 67, T__67 = 68, T__68 = 69, T__69 = 70, INT = 71,
      IDENTIFIER = 72, DIGIT = 73, APOSTROPHE = 74, MULTILINE_COMMENT = 75, SINGLELINE_COMMENT = 76,
      WS = 77;
  public static final int RULE_problem = 0, RULE_options = 1, RULE_option = 2, RULE_universe = 3,
      RULE_relations = 4, RULE_type = 5, RULE_tupleSet = 6, RULE_tuple = 7, RULE_atom = 8,
      RULE_relation = 9, RULE_variable = 10, RULE_integer = 11, RULE_arity = 12, RULE_formula = 13,
      RULE_expression = 14, RULE_intexpression = 15, RULE_decls = 16, RULE_decl = 17,
      RULE_letDecls = 18, RULE_letDecl = 19, RULE_comprehensionDecls = 20,
      RULE_comprehensionDecl = 21;
  public static final String[] ruleNames =
      {"problem", "options", "option", "universe", "relations", "type", "tupleSet", "tuple", "atom",
          "relation", "variable", "integer", "arity", "formula", "expression", "intexpression",
          "decls", "decl", "letDecls", "letDecl", "comprehensionDecls", "comprehensionDecl"};
  private static final String[] _LITERAL_NAMES = {null, "'Relations'", "'{'", "'}'", "'options'",
      "','", "'symmetry_breaking'", "':'", "'bit_width'", "'skolem_depth'", "'sharing'",
      "'universe'", "'['", "']'", "'set'", "'one'", "'lone'", "'some'", "'->'", "'+'", "'&'", "'-'",
      "'('", "')'", "'..'", "'no'", "'!'", "'not'", "'in'", "'='", "'<'", "'<='", "'>'", "'>='",
      "'sum'", "'|'", "'acyclic'", "'function'", "'ord'", "'&&'", "'and'", "'||'", "'or'", "'=>'",
      "'if'", "'<=>'", "'iff'", "'all'", "'let'", "'true'", "'false'", "'~'", "'^'", "'*'", "'.'",
      "'++'", "'then'", "'else'", "'iden'", "'none'", "'univ'", "'ints'", "'#'", "'plus'",
      "'minus'", "'mul'", "'/'", "'div'", "'%'", "'modulo'", "'disj'", null, null, null, "'''"};
  private static final String[] _SYMBOLIC_NAMES =
      {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
          null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
          null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
          null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
          null, null, null, null, null, null, null, null, null, null, null, "INT", "IDENTIFIER",
          "DIGIT", "APOSTROPHE", "MULTILINE_COMMENT", "SINGLELINE_COMMENT", "WS"};
  public static final Vocabulary VOCABULARY =
      new VocabularyImpl(KodkodParser._LITERAL_NAMES, KodkodParser._SYMBOLIC_NAMES);
  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;

  static {
    tokenNames = new String[KodkodParser._SYMBOLIC_NAMES.length];
    for (int i = 0; i < KodkodParser.tokenNames.length; i++) {
      KodkodParser.tokenNames[i] = KodkodParser.VOCABULARY.getLiteralName(i);
      if (KodkodParser.tokenNames[i] == null) {
        KodkodParser.tokenNames[i] = KodkodParser.VOCABULARY.getSymbolicName(i);
      }

      if (KodkodParser.tokenNames[i] == null) {
        KodkodParser.tokenNames[i] = "<INVALID>";
      }
    }
  }

  public static final String _serializedATN =
      "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3O\u02fc\4\2\t\2\4"
          + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
          + "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
          + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\5\2\60\n\2\3\2"
          + "\3\2\3\2\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\2\7\2?\n\2\f\2\16"
          + "\2B\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"
          + "\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4[\n\4\3\5\3\5\3\5\3\5\3\5\7\5b\n\5\f"
          + "\5\16\5e\13\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5m\n\5\f\5\16\5p\13\5\3\5\3\5"
          + "\5\5t\n\5\3\5\3\5\3\6\3\6\5\6z\n\6\3\6\3\6\5\6~\n\6\3\6\3\6\3\6\3\6\5"
          + "\6\u0084\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0090\n\7\3\7"
          + "\3\7\5\7\u0094\n\7\3\7\3\7\5\7\u0098\n\7\3\7\3\7\3\7\3\7\7\7\u009e\n\7"
          + "\f\7\16\7\u00a1\13\7\3\b\3\b\3\b\3\b\7\b\u00a7\n\b\f\b\16\b\u00aa\13\b"
          + "\5\b\u00ac\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u00b3\n\b\f\b\16\b\u00b6\13\b\5"
          + "\b\u00b8\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"
          + "\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00d3\n\b\3\t\3\t\3\t\3"
          + "\t\7\t\u00d9\n\t\f\t\16\t\u00dc\13\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00e4"
          + "\n\t\f\t\16\t\u00e7\13\t\3\t\3\t\5\t\u00eb\n\t\3\n\3\n\3\n\5\n\u00f0\n"
          + "\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"
          + "\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0107\n\17\3\17\3\17\3\17\3\17"
          + "\3\17\5\17\u010e\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u0115\n\17\3\17\3"
          + "\17\3\17\3\17\3\17\5\17\u011c\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u0123"
          + "\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u012a\n\17\3\17\3\17\3\17\3\17\3\17"
          + "\5\17\u0131\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"
          + "\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"
          + "\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"
          + "\3\17\3\17\3\17\3\17\3\17\7\17\u015f\n\17\f\17\16\17\u0162\13\17\3\17"
          + "\5\17\u0165\n\17\3\17\3\17\7\17\u0169\n\17\f\17\16\17\u016c\13\17\3\17"
          + "\5\17\u016f\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u017a"
          + "\n\17\f\17\16\17\u017d\13\17\3\17\5\17\u0180\n\17\3\17\3\17\7\17\u0184"
          + "\n\17\f\17\16\17\u0187\13\17\3\17\5\17\u018a\n\17\3\17\3\17\3\17\3\17"
          + "\3\17\3\17\3\17\3\17\3\17\7\17\u0195\n\17\f\17\16\17\u0198\13\17\3\17"
          + "\5\17\u019b\n\17\3\17\3\17\7\17\u019f\n\17\f\17\16\17\u01a2\13\17\3\17"
          + "\5\17\u01a5\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u01b0"
          + "\n\17\f\17\16\17\u01b3\13\17\3\17\5\17\u01b6\n\17\3\17\3\17\7\17\u01ba"
          + "\n\17\f\17\16\17\u01bd\13\17\3\17\5\17\u01c0\n\17\3\17\3\17\3\17\3\17"
          + "\3\17\3\17\3\17\3\17\3\17\7\17\u01cb\n\17\f\17\16\17\u01ce\13\17\3\17"
          + "\5\17\u01d1\n\17\3\17\3\17\7\17\u01d5\n\17\f\17\16\17\u01d8\13\17\3\17"
          + "\5\17\u01db\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u01e6"
          + "\n\17\f\17\16\17\u01e9\13\17\3\17\5\17\u01ec\n\17\3\17\3\17\7\17\u01f0"
          + "\n\17\f\17\16\17\u01f3\13\17\3\17\5\17\u01f6\n\17\3\17\3\17\3\17\3\17"
          + "\3\17\3\17\3\17\3\17\5\17\u0200\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"
          + "\3\17\3\17\3\17\3\17\3\17\7\17\u020e\n\17\f\17\16\17\u0211\13\17\3\20"
          + "\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"
          + "\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"
          + "\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0238\n\20\3\20\3\20\3\20"
          + "\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"
          + "\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0251\n\20\f\20\16\20\u0254\13\20"
          + "\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"
          + "\u0263\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u026a\n\21\3\21\3\21\3\21\3"
          + "\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u027b"
          + "\n\21\f\21\16\21\u027e\13\21\3\22\3\22\3\22\7\22\u0283\n\22\f\22\16\22"
          + "\u0286\13\22\3\23\5\23\u0289\n\23\3\23\3\23\3\23\7\23\u028e\n\23\f\23"
          + "\16\23\u0291\13\23\3\23\3\23\5\23\u0295\n\23\3\23\3\23\3\23\3\23\5\23"
          + "\u029b\n\23\3\23\3\23\3\23\7\23\u02a0\n\23\f\23\16\23\u02a3\13\23\3\23"
          + "\3\23\3\23\3\23\3\23\3\23\5\23\u02ab\n\23\3\23\3\23\3\23\7\23\u02b0\n"
          + "\23\f\23\16\23\u02b3\13\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u02bb\n"
          + "\23\3\23\3\23\3\23\7\23\u02c0\n\23\f\23\16\23\u02c3\13\23\3\23\3\23\3"
          + "\23\3\23\3\23\5\23\u02ca\n\23\3\24\3\24\3\24\7\24\u02cf\n\24\f\24\16\24"
          + "\u02d2\13\24\3\25\3\25\3\25\7\25\u02d7\n\25\f\25\16\25\u02da\13\25\3\25"
          + "\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u02e4\n\26\f\26\16\26\u02e7\13"
          + "\26\3\27\5\27\u02ea\n\27\3\27\3\27\3\27\7\27\u02ef\n\27\f\27\16\27\u02f2"
          + "\13\27\3\27\3\27\5\27\u02f6\n\27\3\27\3\27\3\27\3\27\3\27\2\6\f\34\36"
          + " \30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\17\3\2\20\23\3\2"
          + "\25\27\3\2\34\35\3\2\21\22\3\2)*\3\2+,\3\2-.\3\2/\60\4\2\25\25AA\4\2\27"
          + "\27BB\4\2\67\67CC\3\2DE\3\2FG\u036d\2/\3\2\2\2\4F\3\2\2\2\6Z\3\2\2\2\b"
          + "s\3\2\2\2\nw\3\2\2\2\f\u008f\3\2\2\2\16\u00d2\3\2\2\2\20\u00ea\3\2\2\2"
          + "\22\u00ef\3\2\2\2\24\u00f1\3\2\2\2\26\u00f3\3\2\2\2\30\u00f5\3\2\2\2\32"
          + "\u00f7\3\2\2\2\34\u01ff\3\2\2\2\36\u0237\3\2\2\2 \u0269\3\2\2\2\"\u027f"
          + "\3\2\2\2$\u02c9\3\2\2\2&\u02cb\3\2\2\2(\u02d3\3\2\2\2*\u02e0\3\2\2\2,"
          + "\u02e9\3\2\2\2.\60\5\4\3\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\5"
          + "\b\5\2\62\63\b\2\1\2\63\64\7\3\2\2\648\7\4\2\2\65\67\5\n\6\2\66\65\3\2"
          + "\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\b\2\1\2<"
          + "@\7\5\2\2=?\5\34\17\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2"
          + "\2B@\3\2\2\2CD\b\2\1\2DE\b\2\1\2E\3\3\2\2\2FG\7\6\2\2GH\7\4\2\2HI\5\6"
          + "\4\2IJ\7\7\2\2JK\5\6\4\2KL\3\2\2\2LM\7\5\2\2M\5\3\2\2\2NO\7\b\2\2OP\7"
          + "\t\2\2P[\5\30\r\2QR\7\n\2\2RS\7\t\2\2S[\5\30\r\2TU\7\13\2\2UV\7\t\2\2"
          + "V[\5\30\r\2WX\7\f\2\2XY\7\t\2\2Y[\5\30\r\2ZN\3\2\2\2ZQ\3\2\2\2ZT\3\2\2"
          + "\2ZW\3\2\2\2[\7\3\2\2\2\\]\7\r\2\2]^\7\4\2\2^c\5\22\n\2_`\7\7\2\2`b\5"
          + "\22\n\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg"
          + "\7\5\2\2gt\3\2\2\2hi\7\16\2\2in\5\22\n\2jk\7\7\2\2km\5\22\n\2lj\3\2\2"
          + "\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7\17\2\2rt\3\2"
          + "\2\2s\\\3\2\2\2sh\3\2\2\2tu\3\2\2\2uv\b\5\1\2v\t\3\2\2\2wy\5\24\13\2x"
          + "z\5\32\16\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{}\7\t\2\2|~\5\f\7\2}|\3\2\2"
          + "\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7\16\2\2\u0080\u0083\5\16\b\2\u0081"
          + "\u0082\7\7\2\2\u0082\u0084\5\16\b\2\u0083\u0081\3\2\2\2\u0083\u0084\3"
          + "\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\7\17\2\2\u0086\u0087\3\2\2\2\u0087"
          + "\u0088\b\6\1\2\u0088\13\3\2\2\2\u0089\u008a\b\7\1\2\u008a\u008b\7\30\2"
          + "\2\u008b\u008c\5\f\7\2\u008c\u008d\7\31\2\2\u008d\u0090\3\2\2\2\u008e"
          + "\u0090\5\24\13\2\u008f\u0089\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u009f\3"
          + "\2\2\2\u0091\u0093\f\6\2\2\u0092\u0094\t\2\2\2\u0093\u0092\3\2\2\2\u0093"
          + "\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\7\24\2\2\u0096\u0098\t"
          + "\2\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099"
          + "\u009e\5\f\7\6\u009a\u009b\f\5\2\2\u009b\u009c\t\3\2\2\u009c\u009e\5\f"
          + "\7\6\u009d\u0091\3\2\2\2\u009d\u009a\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"
          + "\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\r\3\2\2\2\u00a1\u009f\3\2\2\2"
          + "\u00a2\u00ab\7\4\2\2\u00a3\u00a8\5\20\t\2\u00a4\u00a5\7\7\2\2\u00a5\u00a7"
          + "\5\20\t\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2"
          + "\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00a3"
          + "\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00d3\7\5\2\2\u00ae"
          + "\u00b7\7\16\2\2\u00af\u00b4\5\20\t\2\u00b0\u00b1\7\7\2\2\u00b1\u00b3\5"
          + "\20\t\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"
          + "\u00b5\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00af\3\2"
          + "\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00d3\7\17\2\2\u00ba"
          + "\u00bb\7\4\2\2\u00bb\u00bc\5\20\t\2\u00bc\u00bd\7\32\2\2\u00bd\u00be\5"
          + "\20\t\2\u00be\u00bf\7\5\2\2\u00bf\u00d3\3\2\2\2\u00c0\u00c1\7\16\2\2\u00c1"
          + "\u00c2\5\20\t\2\u00c2\u00c3\7\32\2\2\u00c3\u00c4\5\20\t\2\u00c4\u00c5"
          + "\7\17\2\2\u00c5\u00d3\3\2\2\2\u00c6\u00c7\7\4\2\2\u00c7\u00c8\5\24\13"
          + "\2\u00c8\u00c9\7\24\2\2\u00c9\u00ca\5\24\13\2\u00ca\u00cb\7\5\2\2\u00cb"
          + "\u00d3\3\2\2\2\u00cc\u00cd\7\16\2\2\u00cd\u00ce\5\24\13\2\u00ce\u00cf"
          + "\7\24\2\2\u00cf\u00d0\5\24\13\2\u00d0\u00d1\7\17\2\2\u00d1\u00d3\3\2\2"
          + "\2\u00d2\u00a2\3\2\2\2\u00d2\u00ae\3\2\2\2\u00d2\u00ba\3\2\2\2\u00d2\u00c0"
          + "\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d2\u00cc\3\2\2\2\u00d3\17\3\2\2\2\u00d4"
          + "\u00d5\7\30\2\2\u00d5\u00da\5\22\n\2\u00d6\u00d7\7\7\2\2\u00d7\u00d9\5"
          + "\22\n\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"
          + "\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7\31"
          + "\2\2\u00de\u00eb\3\2\2\2\u00df\u00e0\7\16\2\2\u00e0\u00e5\5\22\n\2\u00e1"
          + "\u00e2\7\7\2\2\u00e2\u00e4\5\22\n\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3"
          + "\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7"
          + "\u00e5\3\2\2\2\u00e8\u00e9\7\17\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00d4\3"
          + "\2\2\2\u00ea\u00df\3\2\2\2\u00eb\21\3\2\2\2\u00ec\u00ed\7J\2\2\u00ed\u00f0"
          + "\b\n\1\2\u00ee\u00f0\7I\2\2\u00ef\u00ec\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0"
          + "\23\3\2\2\2\u00f1\u00f2\7J\2\2\u00f2\25\3\2\2\2\u00f3\u00f4\7J\2\2\u00f4"
          + "\27\3\2\2\2\u00f5\u00f6\7I\2\2\u00f6\31\3\2\2\2\u00f7\u00f8\7I\2\2\u00f8"
          + "\33\3\2\2\2\u00f9\u00fa\b\17\1\2\u00fa\u00fb\t\4\2\2\u00fb\u0200\5\34"
          + "\17\20\u00fc\u00fd\7\33\2\2\u00fd\u0200\5\36\20\2\u00fe\u00ff\7\22\2\2"
          + "\u00ff\u0200\5\36\20\2\u0100\u0101\7\21\2\2\u0101\u0200\5\36\20\2\u0102"
          + "\u0103\7\23\2\2\u0103\u0200\5\36\20\2\u0104\u0106\5\36\20\2\u0105\u0107"
          + "\t\4\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108"
          + "\u0109\7\36\2\2\u0109\u010a\5\36\20\2\u010a\u0200\3\2\2\2\u010b\u010d"
          + "\5\36\20\2\u010c\u010e\t\4\2\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2"
          + "\u010e\u010f\3\2\2\2\u010f\u0110\7\37\2\2\u0110\u0111\5\36\20\2\u0111"
          + "\u0200\3\2\2\2\u0112\u0114\5 \21\2\u0113\u0115\t\4\2\2\u0114\u0113\3\2"
          + "\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\37\2\2\u0117"
          + "\u0118\5 \21\2\u0118\u0200\3\2\2\2\u0119\u011b\5 \21\2\u011a\u011c\t\4"
          + "\2\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d"
          + "\u011e\7 \2\2\u011e\u011f\5 \21\2\u011f\u0200\3\2\2\2\u0120\u0122\5 \21"
          + "\2\u0121\u0123\t\4\2\2\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124"
          + "\3\2\2\2\u0124\u0125\7!\2\2\u0125\u0126\5 \21\2\u0126\u0200\3\2\2\2\u0127"
          + "\u0129\5 \21\2\u0128\u012a\t\4\2\2\u0129\u0128\3\2\2\2\u0129\u012a\3\2"
          + "\2\2\u012a\u012b\3\2\2\2\u012b\u012c\7\"\2\2\u012c\u012d\5 \21\2\u012d"
          + "\u0200\3\2\2\2\u012e\u0130\5 \21\2\u012f\u0131\t\4\2\2\u0130\u012f\3\2"
          + "\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\7#\2\2\u0133"
          + "\u0134\5 \21\2\u0134\u0200\3\2\2\2\u0135\u0136\b\17\1\2\u0136\u0137\7"
          + "$\2\2\u0137\u0138\5\"\22\2\u0138\u0139\7%\2\2\u0139\u013a\5 \21\2\u013a"
          + "\u013b\3\2\2\2\u013b\u013c\b\17\1\2\u013c\u0200\3\2\2\2\u013d\u013e\7"
          + "&\2\2\u013e\u013f\7\16\2\2\u013f\u0140\5\24\13\2\u0140\u0141\7\17\2\2"
          + "\u0141\u0200\3\2\2\2\u0142\u0143\7\'\2\2\u0143\u0144\7\16\2\2\u0144\u0145"
          + "\5\24\13\2\u0145\u0146\7\t\2\2\u0146\u0147\5\36\20\2\u0147\u0148\7\24"
          + "\2\2\u0148\u0149\t\5\2\2\u0149\u014a\5\36\20\2\u014a\u014b\7\17\2\2\u014b"
          + "\u0200\3\2\2\2\u014c\u014d\7(\2\2\u014d\u014e\7\16\2\2\u014e\u014f\5\24"
          + "\13\2\u014f\u0150\7\7\2\2\u0150\u0151\5\24\13\2\u0151\u0152\7\7\2\2\u0152"
          + "\u0153\5\24\13\2\u0153\u0154\7\7\2\2\u0154\u0155\5\24\13\2\u0155\u0156"
          + "\7\17\2\2\u0156\u0200\3\2\2\2\u0157\u0158\b\17\1\2\u0158\u0159\7\61\2"
          + "\2\u0159\u016e\5\"\22\2\u015a\u0164\7%\2\2\u015b\u0165\5\34\17\2\u015c"
          + "\u0160\7\4\2\2\u015d\u015f\5\34\17\2\u015e\u015d\3\2\2\2\u015f\u0162\3"
          + "\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0163\3\2\2\2\u0162"
          + "\u0160\3\2\2\2\u0163\u0165\7\5\2\2\u0164\u015b\3\2\2\2\u0164\u015c\3\2"
          + "\2\2\u0165\u016f\3\2\2\2\u0166\u016a\7\4\2\2\u0167\u0169\5\34\17\2\u0168"
          + "\u0167\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2"
          + "\2\2\u016b\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016f\7\5\2\2\u016e"
          + "\u015a\3\2\2\2\u016e\u0166\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\b\17"
          + "\1\2\u0171\u0200\3\2\2\2\u0172\u0173\b\17\1\2\u0173\u0174\7\23\2\2\u0174"
          + "\u0189\5\"\22\2\u0175\u017f\7%\2\2\u0176\u0180\5\34\17\2\u0177\u017b\7"
          + "\4\2\2\u0178\u017a\5\34\17\2\u0179\u0178\3\2\2\2\u017a\u017d\3\2\2\2\u017b"
          + "\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u017b\3\2"
          + "\2\2\u017e\u0180\7\5\2\2\u017f\u0176\3\2\2\2\u017f\u0177\3\2\2\2\u0180"
          + "\u018a\3\2\2\2\u0181\u0185\7\4\2\2\u0182\u0184\5\34\17\2\u0183\u0182\3"
          + "\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186"
          + "\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u018a\7\5\2\2\u0189\u0175\3\2"
          + "\2\2\u0189\u0181\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\b\17\1\2\u018c"
          + "\u0200\3\2\2\2\u018d\u018e\b\17\1\2\u018e\u018f\7\33\2\2\u018f\u01a4\5"
          + "\"\22\2\u0190\u019a\7%\2\2\u0191\u019b\5\34\17\2\u0192\u0196\7\4\2\2\u0193"
          + "\u0195\5\34\17\2\u0194\u0193\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3"
          + "\2\2\2\u0196\u0197\3\2\2\2\u0197\u0199\3\2\2\2\u0198\u0196\3\2\2\2\u0199"
          + "\u019b\7\5\2\2\u019a\u0191\3\2\2\2\u019a\u0192\3\2\2\2\u019b\u01a5\3\2"
          + "\2\2\u019c\u01a0\7\4\2\2\u019d\u019f\5\34\17\2\u019e\u019d\3\2\2\2\u019f"
          + "\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a3\3\2"
          + "\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a5\7\5\2\2\u01a4\u0190\3\2\2\2\u01a4"
          + "\u019c\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\b\17\1\2\u01a7\u0200\3"
          + "\2\2\2\u01a8\u01a9\b\17\1\2\u01a9\u01aa\7\21\2\2\u01aa\u01bf\5\"\22\2"
          + "\u01ab\u01b5\7%\2\2\u01ac\u01b6\5\34\17\2\u01ad\u01b1\7\4\2\2\u01ae\u01b0"
          + "\5\34\17\2\u01af\u01ae\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2"
          + "\u01b1\u01b2\3\2\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b6"
          + "\7\5\2\2\u01b5\u01ac\3\2\2\2\u01b5\u01ad\3\2\2\2\u01b6\u01c0\3\2\2\2\u01b7"
          + "\u01bb\7\4\2\2\u01b8\u01ba\5\34\17\2\u01b9\u01b8\3\2\2\2\u01ba\u01bd\3"
          + "\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd"
          + "\u01bb\3\2\2\2\u01be\u01c0\7\5\2\2\u01bf\u01ab\3\2\2\2\u01bf\u01b7\3\2"
          + "\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\b\17\1\2\u01c2\u0200\3\2\2\2\u01c3"
          + "\u01c4\b\17\1\2\u01c4\u01c5\7\22\2\2\u01c5\u01da\5\"\22\2\u01c6\u01d0"
          + "\7%\2\2\u01c7\u01d1\5\34\17\2\u01c8\u01cc\7\4\2\2\u01c9\u01cb\5\34\17"
          + "\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd"
          + "\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d1\7\5\2\2\u01d0"
          + "\u01c7\3\2\2\2\u01d0\u01c8\3\2\2\2\u01d1\u01db\3\2\2\2\u01d2\u01d6\7\4"
          + "\2\2\u01d3\u01d5\5\34\17\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6"
          + "\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d6\3\2"
          + "\2\2\u01d9\u01db\7\5\2\2\u01da\u01c6\3\2\2\2\u01da\u01d2\3\2\2\2\u01db"
          + "\u01dc\3\2\2\2\u01dc\u01dd\b\17\1\2\u01dd\u0200\3\2\2\2\u01de\u01df\b"
          + "\17\1\2\u01df\u01e0\7\62\2\2\u01e0\u01f5\5&\24\2\u01e1\u01eb\7%\2\2\u01e2"
          + "\u01ec\5\34\17\2\u01e3\u01e7\7\4\2\2\u01e4\u01e6\5\34\17\2\u01e5\u01e4"
          + "\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8"
          + "\u01ea\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea\u01ec\7\5\2\2\u01eb\u01e2\3\2"
          + "\2\2\u01eb\u01e3\3\2\2\2\u01ec\u01f6\3\2\2\2\u01ed\u01f1\7\4\2\2\u01ee"
          + "\u01f0\5\34\17\2\u01ef\u01ee\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01ef\3"
          + "\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4"
          + "\u01f6\7\5\2\2\u01f5\u01e1\3\2\2\2\u01f5\u01ed\3\2\2\2\u01f6\u01f7\3\2"
          + "\2\2\u01f7\u01f8\b\17\1\2\u01f8\u0200\3\2\2\2\u01f9\u0200\7\63\2\2\u01fa"
          + "\u0200\7\64\2\2\u01fb\u01fc\7\30\2\2\u01fc\u01fd\5\34\17\2\u01fd\u01fe"
          + "\7\31\2\2\u01fe\u0200\3\2\2\2\u01ff\u00f9\3\2\2\2\u01ff\u00fc\3\2\2\2"
          + "\u01ff\u00fe\3\2\2\2\u01ff\u0100\3\2\2\2\u01ff\u0102\3\2\2\2\u01ff\u0104"
          + "\3\2\2\2\u01ff\u010b\3\2\2\2\u01ff\u0112\3\2\2\2\u01ff\u0119\3\2\2\2\u01ff"
          + "\u0120\3\2\2\2\u01ff\u0127\3\2\2\2\u01ff\u012e\3\2\2\2\u01ff\u0135\3\2"
          + "\2\2\u01ff\u013d\3\2\2\2\u01ff\u0142\3\2\2\2\u01ff\u014c\3\2\2\2\u01ff"
          + "\u0157\3\2\2\2\u01ff\u0172\3\2\2\2\u01ff\u018d\3\2\2\2\u01ff\u01a8\3\2"
          + "\2\2\u01ff\u01c3\3\2\2\2\u01ff\u01de\3\2\2\2\u01ff\u01f9\3\2\2\2\u01ff"
          + "\u01fa\3\2\2\2\u01ff\u01fb\3\2\2\2\u0200\u020f\3\2\2\2\u0201\u0202\f\17"
          + "\2\2\u0202\u0203\t\6\2\2\u0203\u020e\5\34\17\17\u0204\u0205\f\16\2\2\u0205"
          + "\u0206\t\7\2\2\u0206\u020e\5\34\17\16\u0207\u0208\f\r\2\2\u0208\u0209"
          + "\t\b\2\2\u0209\u020e\5\34\17\r\u020a\u020b\f\f\2\2\u020b\u020c\t\t\2\2"
          + "\u020c\u020e\5\34\17\f\u020d\u0201\3\2\2\2\u020d\u0204\3\2\2\2\u020d\u0207"
          + "\3\2\2\2\u020d\u020a\3\2\2\2\u020e\u0211\3\2\2\2\u020f\u020d\3\2\2\2\u020f"
          + "\u0210\3\2\2\2\u0210\35\3\2\2\2\u0211\u020f\3\2\2\2\u0212\u0213\b\20\1"
          + "\2\u0213\u0214\7\65\2\2\u0214\u0238\5\36\20\23\u0215\u0216\7\66\2\2\u0216"
          + "\u0238\5\36\20\22\u0217\u0218\7\67\2\2\u0218\u0238\5\36\20\21\u0219\u021a"
          + "\t\b\2\2\u021a\u021b\5\34\17\2\u021b\u021c\7:\2\2\u021c\u021d\5\36\20"
          + "\2\u021d\u021e\7;\2\2\u021e\u021f\5\36\20\b\u021f\u0238\3\2\2\2\u0220"
          + "\u0221\6\20\b\2\u0221\u0222\5\26\f\2\u0222\u0223\b\20\1\2\u0223\u0238"
          + "\3\2\2\2\u0224\u0225\6\20\t\2\u0225\u0238\5\24\13\2\u0226\u0227\b\20\1"
          + "\2\u0227\u0228\7\4\2\2\u0228\u0229\5*\26\2\u0229\u022a\7%\2\2\u022a\u022b"
          + "\5\34\17\2\u022b\u022c\7\5\2\2\u022c\u022d\3\2\2\2\u022d\u022e\b\20\1"
          + "\2\u022e\u0238\3\2\2\2\u022f\u0238\7<\2\2\u0230\u0238\7=\2\2\u0231\u0238"
          + "\7>\2\2\u0232\u0238\7?\2\2\u0233\u0234\7\30\2\2\u0234\u0235\5\36\20\2"
          + "\u0235\u0236\7\31\2\2\u0236\u0238\3\2\2\2\u0237\u0212\3\2\2\2\u0237\u0215"
          + "\3\2\2\2\u0237\u0217\3\2\2\2\u0237\u0219\3\2\2\2\u0237\u0220\3\2\2\2\u0237"
          + "\u0224\3\2\2\2\u0237\u0226\3\2\2\2\u0237\u022f\3\2\2\2\u0237\u0230\3\2"
          + "\2\2\u0237\u0231\3\2\2\2\u0237\u0232\3\2\2\2\u0237\u0233\3\2\2\2\u0238"
          + "\u0252\3\2\2\2\u0239\u023a\f\20\2\2\u023a\u023b\7\25\2\2\u023b\u0251\5"
          + "\36\20\21\u023c\u023d\f\17\2\2\u023d\u023e\7\26\2\2\u023e\u0251\5\36\20"
          + "\20\u023f\u0240\f\16\2\2\u0240\u0241\7\27\2\2\u0241\u0251\5\36\20\17\u0242"
          + "\u0243\f\r\2\2\u0243\u0244\78\2\2\u0244\u0251\5\36\20\16\u0245\u0246\f"
          + "\13\2\2\u0246\u0247\7\24\2\2\u0247\u0251\5\36\20\f\u0248\u0249\f\n\2\2"
          + "\u0249\u024a\79\2\2\u024a\u0251\5\36\20\13\u024b\u024c\f\f\2\2\u024c\u024d"
          + "\7\16\2\2\u024d\u024e\5\36\20\2\u024e\u024f\7\17\2\2\u024f\u0251\3\2\2"
          + "\2\u0250\u0239\3\2\2\2\u0250\u023c\3\2\2\2\u0250\u023f\3\2\2\2\u0250\u0242"
          + "\3\2\2\2\u0250\u0245\3\2\2\2\u0250\u0248\3\2\2\2\u0250\u024b\3\2\2\2\u0251"
          + "\u0254\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\37\3\2\2"
          + "\2\u0254\u0252\3\2\2\2\u0255\u0256\b\21\1\2\u0256\u0257\t\b\2\2\u0257"
          + "\u0258\5\34\17\2\u0258\u0259\7:\2\2\u0259\u025a\5 \21\2\u025a\u025b\7"
          + ";\2\2\u025b\u025c\5 \21\f\u025c\u026a\3\2\2\2\u025d\u025e\7$\2\2\u025e"
          + "\u026a\5\36\20\2\u025f\u0260\7@\2\2\u0260\u026a\5\36\20\2\u0261\u0263"
          + "\7\27\2\2\u0262\u0261\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0264\3\2\2\2"
          + "\u0264\u026a\5\30\r\2\u0265\u0266\7\30\2\2\u0266\u0267\5 \21\2\u0267\u0268"
          + "\7\31\2\2\u0268\u026a\3\2\2\2\u0269\u0255\3\2\2\2\u0269\u025d\3\2\2\2"
          + "\u0269\u025f\3\2\2\2\u0269\u0262\3\2\2\2\u0269\u0265\3\2\2\2\u026a\u027c"
          + "\3\2\2\2\u026b\u026c\f\t\2\2\u026c\u026d\t\n\2\2\u026d\u027b\5 \21\n\u026e"
          + "\u026f\f\b\2\2\u026f\u0270\t\13\2\2\u0270\u027b\5 \21\t\u0271\u0272\f"
          + "\7\2\2\u0272\u0273\t\f\2\2\u0273\u027b\5 \21\b\u0274\u0275\f\6\2\2\u0275"
          + "\u0276\t\r\2\2\u0276\u027b\5 \21\7\u0277\u0278\f\5\2\2\u0278\u0279\t\16"
          + "\2\2\u0279\u027b\5 \21\6\u027a\u026b\3\2\2\2\u027a\u026e\3\2\2\2\u027a"
          + "\u0271\3\2\2\2\u027a\u0274\3\2\2\2\u027a\u0277\3\2\2\2\u027b\u027e\3\2"
          + "\2\2\u027c\u027a\3\2\2\2\u027c\u027d\3\2\2\2\u027d!\3\2\2\2\u027e\u027c"
          + "\3\2\2\2\u027f\u0284\5$\23\2\u0280\u0281\7\7\2\2\u0281\u0283\5$\23\2\u0282"
          + "\u0280\3\2\2\2\u0283\u0286\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0285\3\2"
          + "\2\2\u0285#\3\2\2\2\u0286\u0284\3\2\2\2\u0287\u0289\7H\2\2\u0288\u0287"
          + "\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028f\5\26\f\2"
          + "\u028b\u028c\7\7\2\2\u028c\u028e\5\26\f\2\u028d\u028b\3\2\2\2\u028e\u0291"
          + "\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0292\3\2\2\2\u0291"
          + "\u028f\3\2\2\2\u0292\u0294\7\t\2\2\u0293\u0295\7\21\2\2\u0294\u0293\3"
          + "\2\2\2\u0294\u0295\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0297\5\36\20\2\u0297"
          + "\u0298\b\23\1\2\u0298\u02ca\3\2\2\2\u0299\u029b\7H\2\2\u029a\u0299\3\2"
          + "\2\2\u029a\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u02a1\5\26\f\2\u029d"
          + "\u029e\7\7\2\2\u029e\u02a0\5\26\f\2\u029f\u029d\3\2\2\2\u02a0\u02a3\3"
          + "\2\2\2\u02a1\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a4\3\2\2\2\u02a3"
          + "\u02a1\3\2\2\2\u02a4\u02a5\7\t\2\2\u02a5\u02a6\7\22\2\2\u02a6\u02a7\5"
          + "\36\20\2\u02a7\u02a8\b\23\1\2\u02a8\u02ca\3\2\2\2\u02a9\u02ab\7H\2\2\u02aa"
          + "\u02a9\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02b1\5\26"
          + "\f\2\u02ad\u02ae\7\7\2\2\u02ae\u02b0\5\26\f\2\u02af\u02ad\3\2\2\2\u02b0"
          + "\u02b3\3\2\2\2\u02b1\u02af\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b4\3\2"
          + "\2\2\u02b3\u02b1\3\2\2\2\u02b4\u02b5\7\t\2\2\u02b5\u02b6\7\23\2\2\u02b6"
          + "\u02b7\5\36\20\2\u02b7\u02b8\b\23\1\2\u02b8\u02ca\3\2\2\2\u02b9\u02bb"
          + "\7H\2\2\u02ba\u02b9\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc"
          + "\u02c1\5\26\f\2\u02bd\u02be\7\7\2\2\u02be\u02c0\5\26\f\2\u02bf\u02bd\3"
          + "\2\2\2\u02c0\u02c3\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2"
          + "\u02c4\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c4\u02c5\7\t\2\2\u02c5\u02c6\7\20"
          + "\2\2\u02c6\u02c7\5\36\20\2\u02c7\u02c8\b\23\1\2\u02c8\u02ca\3\2\2\2\u02c9"
          + "\u0288\3\2\2\2\u02c9\u029a\3\2\2\2\u02c9\u02aa\3\2\2\2\u02c9\u02ba\3\2"
          + "\2\2\u02ca%\3\2\2\2\u02cb\u02d0\5(\25\2\u02cc\u02cd\7\7\2\2\u02cd\u02cf"
          + "\5(\25\2\u02ce\u02cc\3\2\2\2\u02cf\u02d2\3\2\2\2\u02d0\u02ce\3\2\2\2\u02d0"
          + "\u02d1\3\2\2\2\u02d1\'\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d3\u02d8\5\26\f"
          + "\2\u02d4\u02d5\7\7\2\2\u02d5\u02d7\5\26\f\2\u02d6\u02d4\3\2\2\2\u02d7"
          + "\u02da\3\2\2\2\u02d8\u02d6\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02db\3\2"
          + "\2\2\u02da\u02d8\3\2\2\2\u02db\u02dc\7\37\2\2\u02dc\u02dd\5\36\20\2\u02dd"
          + "\u02de\3\2\2\2\u02de\u02df\b\25\1\2\u02df)\3\2\2\2\u02e0\u02e5\5,\27\2"
          + "\u02e1\u02e2\7\7\2\2\u02e2\u02e4\5,\27\2\u02e3\u02e1\3\2\2\2\u02e4\u02e7"
          + "\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6+\3\2\2\2\u02e7"
          + "\u02e5\3\2\2\2\u02e8\u02ea\7H\2\2\u02e9\u02e8\3\2\2\2\u02e9\u02ea\3\2"
          + "\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02f0\5\26\f\2\u02ec\u02ed\7\7\2\2\u02ed"
          + "\u02ef\5\26\f\2\u02ee\u02ec\3\2\2\2\u02ef\u02f2\3\2\2\2\u02f0\u02ee\3"
          + "\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f3\3\2\2\2\u02f2\u02f0\3\2\2\2\u02f3"
          + "\u02f5\7\t\2\2\u02f4\u02f6\7\21\2\2\u02f5\u02f4\3\2\2\2\u02f5\u02f6\3"
          + "\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\5\36\20\2\u02f8\u02f9\3\2\2\2\u02f9"
          + "\u02fa\b\27\1\2\u02fa-\3\2\2\2T/8@Zcnsy}\u0083\u008f\u0093\u0097\u009d"
          + "\u009f\u00a8\u00ab\u00b4\u00b7\u00d2\u00da\u00e5\u00ea\u00ef\u0106\u010d"
          + "\u0114\u011b\u0122\u0129\u0130\u0160\u0164\u016a\u016e\u017b\u017f\u0185"
          + "\u0189\u0196\u019a\u01a0\u01a4\u01b1\u01b5\u01bb\u01bf\u01cc\u01d0\u01d6"
          + "\u01da\u01e7\u01eb\u01f1\u01f5\u01ff\u020d\u020f\u0237\u0250\u0252\u0262"
          + "\u0269\u027a\u027c\u0284\u0288\u028f\u0294\u029a\u02a1\u02aa\u02b1\u02ba"
          + "\u02c1\u02c9\u02d0\u02d8\u02e5\u02e9\u02f0\u02f5";
  public static final ATN _ATN =
      new ATNDeserializer().deserialize(KodkodParser._serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[KodkodParser._ATN.getNumberOfDecisions()];
    for (int i = 0; i < KodkodParser._ATN.getNumberOfDecisions(); i++) {
      KodkodParser._decisionToDFA[i] = new DFA(KodkodParser._ATN.getDecisionState(i), i);
    }
  }

  public java.util.Stack<String> declarations = new java.util.Stack<String>();
  public java.util.List<String> atoms = new java.util.ArrayList<String>();
  public java.util.List<kodkod.ast.Formula> formulas =
      new java.util.ArrayList<kodkod.ast.Formula>();
  public java.util.Map<String, kodkod.ast.Relation> relations =
      new java.util.HashMap<String, kodkod.ast.Relation>();
  public kodkod.instance.Universe universe = null;
  public kodkod.instance.Bounds bounds = null;
  private String context = null;

  public KodkodParser(final TokenStream input) {
    super(input);
    this._interp = new ParserATNSimulator(this, KodkodParser._ATN, KodkodParser._decisionToDFA,
        KodkodParser._sharedContextCache);
  }

  public final ArityContext arity() throws RecognitionException {
    final ArityContext _localctx = new ArityContext(this._ctx, this.getState());
    this.enterRule(_localctx, 24, KodkodParser.RULE_arity);
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(245);
        this.match(KodkodParser.INT);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final AtomContext atom() throws RecognitionException {
    final AtomContext _localctx = new AtomContext(this._ctx, this.getState());
    this.enterRule(_localctx, 16, KodkodParser.RULE_atom);
    try {
      this.setState(237);
      switch (this._input.LA(1)) {
        case IDENTIFIER:
          this.enterOuterAlt(_localctx, 1); {
          this.setState(234);
          _localctx.id = this.match(KodkodParser.IDENTIFIER);

          if (this.context != null && !this.context.isEmpty() && !this.context.equals("universe")) {
            System.out.print(
                "atom found: " + (_localctx.id != null ? _localctx.id.getText() : null) + "-> ");
            if (this.atoms.contains(_localctx.id != null ? _localctx.id.getText() : null)) {
              System.out.println("defined");
            } else {
              System.err.println(
                  "undefined atom found: '" + (_localctx.id != null ? _localctx.id.getText() : null)
                      + "' at " + this.getLocation());
            }
          }

        }
          break;
        case INT:
          this.enterOuterAlt(_localctx, 2); {
          this.setState(236);
          this.match(KodkodParser.INT);
        }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final ComprehensionDeclContext comprehensionDecl() throws RecognitionException {
    final ComprehensionDeclContext _localctx =
        new ComprehensionDeclContext(this._ctx, this.getState());
    this.enterRule(_localctx, 42, KodkodParser.RULE_comprehensionDecl);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(743);
        _la = this._input.LA(1);
        if (_la == KodkodParser.T__69) {
          {
            this.setState(742);
            _localctx.disj = this.match(KodkodParser.T__69);
          }
        }

        {
          this.setState(745);
          _localctx.variable = this.variable();
          _localctx.vars.add(_localctx.variable);
          this.setState(750);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
          while (_la == KodkodParser.T__4) {
            {
              {
                this.setState(746);
                this.match(KodkodParser.T__4);
                this.setState(747);
                _localctx.variable = this.variable();
                _localctx.vars.add(_localctx.variable);
              }
            }
            this.setState(752);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
          }
          this.setState(753);
          this.match(KodkodParser.T__6);
          this.setState(755);
          switch (this.getInterpreter().adaptivePredict(this._input, 81, this._ctx)) {
            case 1: {
              this.setState(754);
              this.match(KodkodParser.T__14);
            }
              break;
          }
          this.setState(757);
          this.expression(0);
        }
        ((FormulaContext) this.getInvokingContext(13)).var = this.declareVariables(_localctx.vars,
            ((FormulaContext) this.getInvokingContext(13)).var);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final ComprehensionDeclsContext comprehensionDecls() throws RecognitionException {
    final ComprehensionDeclsContext _localctx =
        new ComprehensionDeclsContext(this._ctx, this.getState());
    this.enterRule(_localctx, 40, KodkodParser.RULE_comprehensionDecls);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(734);
        this.comprehensionDecl();
        this.setState(739);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while (_la == KodkodParser.T__4) {
          {
            {
              this.setState(735);
              this.match(KodkodParser.T__4);
              this.setState(736);
              this.comprehensionDecl();
            }
          }
          this.setState(741);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        }
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final DeclContext decl() throws RecognitionException {
    DeclContext _localctx = new DeclContext(this._ctx, this.getState());
    this.enterRule(_localctx, 34, KodkodParser.RULE_decl);
    int _la;
    try {
      this.setState(711);
      switch (this.getInterpreter().adaptivePredict(this._input, 75, this._ctx)) {
        case 1:
          _localctx = new OneOfContext(_localctx);
          this.enterOuterAlt(_localctx, 1); {
          this.setState(646);
          _la = this._input.LA(1);
          if (_la == KodkodParser.T__69) {
            {
              this.setState(645);
              ((OneOfContext) _localctx).disj = this.match(KodkodParser.T__69);
            }
          }

          this.setState(648);
          ((OneOfContext) _localctx).variable = this.variable();
          ((OneOfContext) _localctx).vars.add(((OneOfContext) _localctx).variable);
          this.setState(653);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
          while (_la == KodkodParser.T__4) {
            {
              {
                this.setState(649);
                this.match(KodkodParser.T__4);
                this.setState(650);
                ((OneOfContext) _localctx).variable = this.variable();
                ((OneOfContext) _localctx).vars.add(((OneOfContext) _localctx).variable);
              }
            }
            this.setState(655);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
          }
          this.setState(656);
          this.match(KodkodParser.T__6);
          this.setState(658);
          switch (this.getInterpreter().adaptivePredict(this._input, 68, this._ctx)) {
            case 1: {
              this.setState(657);
              this.match(KodkodParser.T__14);
            }
              break;
          }
          this.setState(660);
          this.expression(0);
          ((FormulaContext) this.getInvokingContext(13)).var = this.declareVariables(
              ((OneOfContext) _localctx).vars, ((FormulaContext) this.getInvokingContext(13)).var);
        }
          break;
        case 2:
          _localctx = new LoneOfContext(_localctx);
          this.enterOuterAlt(_localctx, 2); {
          this.setState(664);
          _la = this._input.LA(1);
          if (_la == KodkodParser.T__69) {
            {
              this.setState(663);
              ((LoneOfContext) _localctx).disj = this.match(KodkodParser.T__69);
            }
          }

          this.setState(666);
          ((LoneOfContext) _localctx).variable = this.variable();
          ((LoneOfContext) _localctx).vars.add(((LoneOfContext) _localctx).variable);
          this.setState(671);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
          while (_la == KodkodParser.T__4) {
            {
              {
                this.setState(667);
                this.match(KodkodParser.T__4);
                this.setState(668);
                ((LoneOfContext) _localctx).variable = this.variable();
                ((LoneOfContext) _localctx).vars.add(((LoneOfContext) _localctx).variable);
              }
            }
            this.setState(673);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
          }
          this.setState(674);
          this.match(KodkodParser.T__6);
          this.setState(675);
          this.match(KodkodParser.T__15);
          this.setState(676);
          this.expression(0);
          ((FormulaContext) this.getInvokingContext(13)).var = this.declareVariables(
              ((LoneOfContext) _localctx).vars, ((FormulaContext) this.getInvokingContext(13)).var);
        }
          break;
        case 3:
          _localctx = new SomeOfContext(_localctx);
          this.enterOuterAlt(_localctx, 3); {
          this.setState(680);
          _la = this._input.LA(1);
          if (_la == KodkodParser.T__69) {
            {
              this.setState(679);
              ((SomeOfContext) _localctx).disj = this.match(KodkodParser.T__69);
            }
          }

          this.setState(682);
          ((SomeOfContext) _localctx).variable = this.variable();
          ((SomeOfContext) _localctx).vars.add(((SomeOfContext) _localctx).variable);
          this.setState(687);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
          while (_la == KodkodParser.T__4) {
            {
              {
                this.setState(683);
                this.match(KodkodParser.T__4);
                this.setState(684);
                ((SomeOfContext) _localctx).variable = this.variable();
                ((SomeOfContext) _localctx).vars.add(((SomeOfContext) _localctx).variable);
              }
            }
            this.setState(689);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
          }
          this.setState(690);
          this.match(KodkodParser.T__6);
          this.setState(691);
          this.match(KodkodParser.T__16);
          this.setState(692);
          this.expression(0);
          ((FormulaContext) this.getInvokingContext(13)).var = this.declareVariables(
              ((SomeOfContext) _localctx).vars, ((FormulaContext) this.getInvokingContext(13)).var);
        }
          break;
        case 4:
          _localctx = new SetOfContext(_localctx);
          this.enterOuterAlt(_localctx, 4); {
          this.setState(696);
          _la = this._input.LA(1);
          if (_la == KodkodParser.T__69) {
            {
              this.setState(695);
              ((SetOfContext) _localctx).disj = this.match(KodkodParser.T__69);
            }
          }

          this.setState(698);
          ((SetOfContext) _localctx).variable = this.variable();
          ((SetOfContext) _localctx).vars.add(((SetOfContext) _localctx).variable);
          this.setState(703);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
          while (_la == KodkodParser.T__4) {
            {
              {
                this.setState(699);
                this.match(KodkodParser.T__4);
                this.setState(700);
                ((SetOfContext) _localctx).variable = this.variable();
                ((SetOfContext) _localctx).vars.add(((SetOfContext) _localctx).variable);
              }
            }
            this.setState(705);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
          }
          this.setState(706);
          this.match(KodkodParser.T__6);
          this.setState(707);
          this.match(KodkodParser.T__13);
          this.setState(708);
          this.expression(0);
          ((FormulaContext) this.getInvokingContext(13)).var = this.declareVariables(
              ((SetOfContext) _localctx).vars, ((FormulaContext) this.getInvokingContext(13)).var);
        }
          break;
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  private int declareVariables(final java.util.List<VariableContext> vars, int var) {
    System.out.println("Quantifier context: ");
    for (final VariableContext vc : vars) {
      final String s = vc.getText();
      this.declarations.add(s);
      var++;
      System.out.println(s);
    }
    return var;
  }

  public final DeclsContext decls() throws RecognitionException {
    final DeclsContext _localctx = new DeclsContext(this._ctx, this.getState());
    this.enterRule(_localctx, 32, KodkodParser.RULE_decls);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(637);
        this.decl();
        this.setState(642);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while (_la == KodkodParser.T__4) {
          {
            {
              this.setState(638);
              this.match(KodkodParser.T__4);
              this.setState(639);
              this.decl();
            }
          }
          this.setState(644);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        }
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final ExpressionContext expression() throws RecognitionException {
    return this.expression(0);
  }

  private ExpressionContext expression(final int _p) throws RecognitionException {
    final ParserRuleContext _parentctx = this._ctx;
    final int _parentState = this.getState();
    ExpressionContext _localctx = new ExpressionContext(this._ctx, _parentState);
    ExpressionContext _prevctx = _localctx;
    final int _startState = 28;
    this.enterRecursionRule(_localctx, 28, KodkodParser.RULE_expression, _p);
    int _la;
    try {
      int _alt;
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(565);
        switch (this.getInterpreter().adaptivePredict(this._input, 58, this._ctx)) {
          case 1: {
            _localctx = new TransposeContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;

            this.setState(529);
            this.match(KodkodParser.T__50);
            this.setState(530);
            this.expression(17);
          }
            break;
          case 2: {
            _localctx = new ClosureContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(531);
            this.match(KodkodParser.T__51);
            this.setState(532);
            this.expression(16);
          }
            break;
          case 3: {
            _localctx = new ReflexiveContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(533);
            this.match(KodkodParser.T__52);
            this.setState(534);
            this.expression(15);
          }
            break;
          case 4: {
            _localctx = new IfExpressionContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(535);
            ((IfExpressionContext) _localctx).op = this._input.LT(1);
            _la = this._input.LA(1);
            if (!(_la == KodkodParser.T__42 || _la == KodkodParser.T__43)) {
              ((IfExpressionContext) _localctx).op = this._errHandler.recoverInline(this);
            } else {
              this.consume();
            }
            this.setState(536);
            ((IfExpressionContext) _localctx).condition = this.formula(0);
            this.setState(537);
            this.match(KodkodParser.T__55);
            this.setState(538);
            ((IfExpressionContext) _localctx).thenExpr = this.expression(0);
            this.setState(539);
            this.match(KodkodParser.T__56);
            this.setState(540);
            ((IfExpressionContext) _localctx).elseExpr = this.expression(6);
          }
            break;
          case 5: {
            _localctx = new VarContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(542);
            if (!!this.isRelation()) {
              throw new FailedPredicateException(this, "!isRelation()");
            }
            this.setState(543);
            ((VarContext) _localctx).variable = this.variable();

            System.out.print("variable found: " + (((VarContext) _localctx).variable != null
                ? this._input.getText(((VarContext) _localctx).variable.start,
                    ((VarContext) _localctx).variable.stop)
                : null) + "-> ");
            final String s = ((VarContext) _localctx).variable != null
                ? this._input.getText(((VarContext) _localctx).variable.start,
                    ((VarContext) _localctx).variable.stop)
                : null;
            if (this.declarations.contains(s)) {
              System.out.println("defined");
            } else {
              System.err.println("undefined variable found: '" + s + "' at " + this.getLocation());
            }

          }
            break;
          case 6: {
            _localctx = new RelContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(546);
            if (!this.isRelation()) {
              throw new FailedPredicateException(this, "isRelation()");
            }
            this.setState(547);
            this.relation();
          }
            break;
          case 7: {
            _localctx = new ComprehensionContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            ((FormulaContext) this.getInvokingContext(13)).var = 0;
            {
              this.setState(549);
              this.match(KodkodParser.T__1);
              this.setState(550);
              this.comprehensionDecls();
              this.setState(551);
              this.match(KodkodParser.T__34);
              this.setState(552);
              this.formula(0);
              this.setState(553);
              this.match(KodkodParser.T__2);
            }
            for (int i = 0; i < ((FormulaContext) this.getInvokingContext(13)).var; i++) {
              this.declarations.pop();
            }
          }
            break;
          case 8: {
            _localctx = new IdenContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(557);
            this.match(KodkodParser.T__57);
          }
            break;
          case 9: {
            _localctx = new NoneContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(558);
            this.match(KodkodParser.T__58);
          }
            break;
          case 10: {
            _localctx = new UnivContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(559);
            this.match(KodkodParser.T__59);
          }
            break;
          case 11: {
            _localctx = new IntsContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(560);
            this.match(KodkodParser.T__60);
          }
            break;
          case 12: {
            _localctx = new E_paranthesisContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(561);
            this.match(KodkodParser.T__21);
            this.setState(562);
            this.expression(0);
            this.setState(563);
            this.match(KodkodParser.T__22);
          }
            break;
        }
        this._ctx.stop = this._input.LT(-1);
        this.setState(592);
        this._errHandler.sync(this);
        _alt = this.getInterpreter().adaptivePredict(this._input, 60, this._ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (this._parseListeners != null) {
              this.triggerExitRuleEvent();
            }
            _prevctx = _localctx;
            {
              this.setState(590);
              switch (this.getInterpreter().adaptivePredict(this._input, 59, this._ctx)) {
                case 1: {
                  _localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
                  ((UnionContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_expression);
                  this.setState(567);
                  if (!this.precpred(this._ctx, 14)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 14)");
                  }
                  this.setState(568);
                  this.match(KodkodParser.T__18);
                  this.setState(569);
                  ((UnionContext) _localctx).right = this.expression(15);
                }
                  break;
                case 2: {
                  _localctx =
                      new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
                  ((IntersectionContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_expression);
                  this.setState(570);
                  if (!this.precpred(this._ctx, 13)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 13)");
                  }
                  this.setState(571);
                  this.match(KodkodParser.T__19);
                  this.setState(572);
                  ((IntersectionContext) _localctx).right = this.expression(14);
                }
                  break;
                case 3: {
                  _localctx =
                      new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
                  ((DifferenceContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_expression);
                  this.setState(573);
                  if (!this.precpred(this._ctx, 12)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                  }
                  this.setState(574);
                  this.match(KodkodParser.T__20);
                  this.setState(575);
                  ((DifferenceContext) _localctx).right = this.expression(13);
                }
                  break;
                case 4: {
                  _localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
                  ((JoinContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_expression);
                  this.setState(576);
                  if (!this.precpred(this._ctx, 11)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                  }
                  this.setState(577);
                  this.match(KodkodParser.T__53);
                  this.setState(578);
                  ((JoinContext) _localctx).right = this.expression(12);
                }
                  break;
                case 5: {
                  _localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
                  ((ProductContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_expression);
                  this.setState(579);
                  if (!this.precpred(this._ctx, 9)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                  }
                  this.setState(580);
                  this.match(KodkodParser.T__17);
                  this.setState(581);
                  ((ProductContext) _localctx).right = this.expression(10);
                }
                  break;
                case 6: {
                  _localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
                  ((OverrideContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_expression);
                  this.setState(582);
                  if (!this.precpred(this._ctx, 8)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                  }
                  this.setState(583);
                  this.match(KodkodParser.T__54);
                  this.setState(584);
                  ((OverrideContext) _localctx).right = this.expression(9);
                }
                  break;
                case 7: {
                  _localctx = new BoxjoinContext(new ExpressionContext(_parentctx, _parentState));
                  ((BoxjoinContext) _localctx).right = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_expression);
                  this.setState(585);
                  if (!this.precpred(this._ctx, 10)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                  }
                  this.setState(586);
                  this.match(KodkodParser.T__11);
                  this.setState(587);
                  ((BoxjoinContext) _localctx).left = this.expression(0);
                  this.setState(588);
                  this.match(KodkodParser.T__12);
                }
                  break;
              }
            }
          }
          this.setState(594);
          this._errHandler.sync(this);
          _alt = this.getInterpreter().adaptivePredict(this._input, 60, this._ctx);
        }
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  private boolean expression_sempred(final ExpressionContext _localctx, final int predIndex) {
    switch (predIndex) {
      case 6:
        return !this.isRelation();
      case 7:
        return this.isRelation();
      case 8:
        return this.precpred(this._ctx, 14);
      case 9:
        return this.precpred(this._ctx, 13);
      case 10:
        return this.precpred(this._ctx, 12);
      case 11:
        return this.precpred(this._ctx, 11);
      case 12:
        return this.precpred(this._ctx, 9);
      case 13:
        return this.precpred(this._ctx, 8);
      case 14:
        return this.precpred(this._ctx, 10);
    }
    return true;
  }

  public final FormulaContext formula() throws RecognitionException {
    return this.formula(0);
  }

  private FormulaContext formula(final int _p) throws RecognitionException {
    final ParserRuleContext _parentctx = this._ctx;
    final int _parentState = this.getState();
    FormulaContext _localctx = new FormulaContext(this._ctx, _parentState);
    FormulaContext _prevctx = _localctx;
    final int _startState = 26;
    this.enterRecursionRule(_localctx, 26, KodkodParser.RULE_formula, _p);
    int _la;
    try {
      int _alt;
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(509);
        switch (this.getInterpreter().adaptivePredict(this._input, 55, this._ctx)) {
          case 1: {
            _localctx = new NotContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;

            this.setState(248);
            ((NotContext) _localctx).op = this._input.LT(1);
            _la = this._input.LA(1);
            if (!(_la == KodkodParser.T__25 || _la == KodkodParser.T__26)) {
              ((NotContext) _localctx).op = this._errHandler.recoverInline(this);
            } else {
              this.consume();
            }
            this.setState(249);
            this.formula(14);
          }
            break;
          case 2: {
            _localctx = new NoContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(250);
            this.match(KodkodParser.T__24);
            this.setState(251);
            this.expression(0);
          }
            break;
          case 3: {
            _localctx = new LoneContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(252);
            this.match(KodkodParser.T__15);
            this.setState(253);
            this.expression(0);
          }
            break;
          case 4: {
            _localctx = new OneContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(254);
            this.match(KodkodParser.T__14);
            this.setState(255);
            this.expression(0);
          }
            break;
          case 5: {
            _localctx = new SomeContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(256);
            this.match(KodkodParser.T__16);
            this.setState(257);
            this.expression(0);
          }
            break;
          case 6: {
            _localctx = new InContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(258);
            ((InContext) _localctx).left = this.expression(0);
            this.setState(260);
            _la = this._input.LA(1);
            if (_la == KodkodParser.T__25 || _la == KodkodParser.T__26) {
              {
                this.setState(259);
                ((InContext) _localctx).not = this._input.LT(1);
                _la = this._input.LA(1);
                if (!(_la == KodkodParser.T__25 || _la == KodkodParser.T__26)) {
                  ((InContext) _localctx).not = this._errHandler.recoverInline(this);
                } else {
                  this.consume();
                }
              }
            }

            this.setState(262);
            this.match(KodkodParser.T__27);
            this.setState(263);
            ((InContext) _localctx).right = this.expression(0);
          }
            break;
          case 7: {
            _localctx = new EqualContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(265);
            ((EqualContext) _localctx).left = this.expression(0);
            this.setState(267);
            _la = this._input.LA(1);
            if (_la == KodkodParser.T__25 || _la == KodkodParser.T__26) {
              {
                this.setState(266);
                ((EqualContext) _localctx).not = this._input.LT(1);
                _la = this._input.LA(1);
                if (!(_la == KodkodParser.T__25 || _la == KodkodParser.T__26)) {
                  ((EqualContext) _localctx).not = this._errHandler.recoverInline(this);
                } else {
                  this.consume();
                }
              }
            }

            this.setState(269);
            this.match(KodkodParser.T__28);
            this.setState(270);
            ((EqualContext) _localctx).right = this.expression(0);
          }
            break;
          case 8: {
            _localctx = new EqContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(272);
            ((EqContext) _localctx).left = this.intexpression(0);
            this.setState(274);
            _la = this._input.LA(1);
            if (_la == KodkodParser.T__25 || _la == KodkodParser.T__26) {
              {
                this.setState(273);
                ((EqContext) _localctx).not = this._input.LT(1);
                _la = this._input.LA(1);
                if (!(_la == KodkodParser.T__25 || _la == KodkodParser.T__26)) {
                  ((EqContext) _localctx).not = this._errHandler.recoverInline(this);
                } else {
                  this.consume();
                }
              }
            }

            this.setState(276);
            this.match(KodkodParser.T__28);
            this.setState(277);
            ((EqContext) _localctx).right = this.intexpression(0);
          }
            break;
          case 9: {
            _localctx = new LtContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(279);
            ((LtContext) _localctx).left = this.intexpression(0);
            this.setState(281);
            _la = this._input.LA(1);
            if (_la == KodkodParser.T__25 || _la == KodkodParser.T__26) {
              {
                this.setState(280);
                ((LtContext) _localctx).not = this._input.LT(1);
                _la = this._input.LA(1);
                if (!(_la == KodkodParser.T__25 || _la == KodkodParser.T__26)) {
                  ((LtContext) _localctx).not = this._errHandler.recoverInline(this);
                } else {
                  this.consume();
                }
              }
            }

            this.setState(283);
            this.match(KodkodParser.T__29);
            this.setState(284);
            ((LtContext) _localctx).right = this.intexpression(0);
          }
            break;
          case 10: {
            _localctx = new LteContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(286);
            ((LteContext) _localctx).left = this.intexpression(0);
            this.setState(288);
            _la = this._input.LA(1);
            if (_la == KodkodParser.T__25 || _la == KodkodParser.T__26) {
              {
                this.setState(287);
                ((LteContext) _localctx).not = this._input.LT(1);
                _la = this._input.LA(1);
                if (!(_la == KodkodParser.T__25 || _la == KodkodParser.T__26)) {
                  ((LteContext) _localctx).not = this._errHandler.recoverInline(this);
                } else {
                  this.consume();
                }
              }
            }

            this.setState(290);
            this.match(KodkodParser.T__30);
            this.setState(291);
            ((LteContext) _localctx).right = this.intexpression(0);
          }
            break;
          case 11: {
            _localctx = new GtContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(293);
            ((GtContext) _localctx).left = this.intexpression(0);
            this.setState(295);
            _la = this._input.LA(1);
            if (_la == KodkodParser.T__25 || _la == KodkodParser.T__26) {
              {
                this.setState(294);
                ((GtContext) _localctx).not = this._input.LT(1);
                _la = this._input.LA(1);
                if (!(_la == KodkodParser.T__25 || _la == KodkodParser.T__26)) {
                  ((GtContext) _localctx).not = this._errHandler.recoverInline(this);
                } else {
                  this.consume();
                }
              }
            }

            this.setState(297);
            this.match(KodkodParser.T__31);
            this.setState(298);
            ((GtContext) _localctx).right = this.intexpression(0);
          }
            break;
          case 12: {
            _localctx = new GteContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(300);
            ((GteContext) _localctx).left = this.intexpression(0);
            this.setState(302);
            _la = this._input.LA(1);
            if (_la == KodkodParser.T__25 || _la == KodkodParser.T__26) {
              {
                this.setState(301);
                ((GteContext) _localctx).not = this._input.LT(1);
                _la = this._input.LA(1);
                if (!(_la == KodkodParser.T__25 || _la == KodkodParser.T__26)) {
                  ((GteContext) _localctx).not = this._errHandler.recoverInline(this);
                } else {
                  this.consume();
                }
              }
            }

            this.setState(304);
            this.match(KodkodParser.T__32);
            this.setState(305);
            ((GteContext) _localctx).right = this.intexpression(0);
          }
            break;
          case 13: {
            _localctx = new SumDeclarationContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            ((FormulaContext) this.getInvokingContext(13)).var = 0;
            {
              this.setState(308);
              this.match(KodkodParser.T__33);
              this.setState(309);
              this.decls();
              this.setState(310);
              this.match(KodkodParser.T__34);
              this.setState(311);
              this.intexpression(0);
            }
            for (int i = 0; i < ((FormulaContext) this.getInvokingContext(13)).var; i++) {
              this.declarations.pop();
            }
          }
            break;
          case 14: {
            _localctx = new AcyclicContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(315);
            this.match(KodkodParser.T__35);
            this.setState(316);
            this.match(KodkodParser.T__11);
            this.setState(317);
            this.relation();
            this.setState(318);
            this.match(KodkodParser.T__12);
          }
            break;
          case 15: {
            _localctx = new FunctionContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(320);
            this.match(KodkodParser.T__36);
            this.setState(321);
            this.match(KodkodParser.T__11);
            this.setState(322);
            ((FunctionContext) _localctx).rel = this.relation();
            this.setState(323);
            this.match(KodkodParser.T__6);
            this.setState(324);
            ((FunctionContext) _localctx).domain = this.expression(0);
            this.setState(325);
            this.match(KodkodParser.T__17);
            this.setState(326);
            ((FunctionContext) _localctx).op = this._input.LT(1);
            _la = this._input.LA(1);
            if (!(_la == KodkodParser.T__14 || _la == KodkodParser.T__15)) {
              ((FunctionContext) _localctx).op = this._errHandler.recoverInline(this);
            } else {
              this.consume();
            }
            this.setState(327);
            ((FunctionContext) _localctx).range = this.expression(0);
            this.setState(328);
            this.match(KodkodParser.T__12);
          }
            break;
          case 16: {
            _localctx = new TotalOrderContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(330);
            this.match(KodkodParser.T__37);
            this.setState(331);
            this.match(KodkodParser.T__11);
            this.setState(332);
            ((TotalOrderContext) _localctx).rel = this.relation();
            this.setState(333);
            this.match(KodkodParser.T__4);
            this.setState(334);
            ((TotalOrderContext) _localctx).ordered = this.relation();
            this.setState(335);
            this.match(KodkodParser.T__4);
            this.setState(336);
            ((TotalOrderContext) _localctx).first = this.relation();
            this.setState(337);
            this.match(KodkodParser.T__4);
            this.setState(338);
            ((TotalOrderContext) _localctx).last = this.relation();
            this.setState(339);
            this.match(KodkodParser.T__12);
          }
            break;
          case 17: {
            _localctx = new ForAllContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            ((FormulaContext) this.getInvokingContext(13)).var = 0;
            {
              this.setState(342);
              this.match(KodkodParser.T__46);
              this.setState(343);
              this.decls();
              this.setState(364);
              switch (this._input.LA(1)) {
                case T__34: {
                  this.setState(344);
                  this.match(KodkodParser.T__34);
                  this.setState(354);
                  switch (this.getInterpreter().adaptivePredict(this._input, 32, this._ctx)) {
                    case 1: {
                      this.setState(345);
                      this.formula(0);
                    }
                      break;
                    case 2: {
                      this.setState(346);
                      this.match(KodkodParser.T__1);
                      this.setState(350);
                      this._errHandler.sync(this);
                      _alt = this.getInterpreter().adaptivePredict(this._input, 31, this._ctx);
                      while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                          {
                            {
                              this.setState(347);
                              this.formula(0);
                            }
                          }
                        }
                        this.setState(352);
                        this._errHandler.sync(this);
                        _alt = this.getInterpreter().adaptivePredict(this._input, 31, this._ctx);
                      }
                      this.setState(353);
                      this.match(KodkodParser.T__2);
                    }
                      break;
                  }
                }
                  break;
                case T__1: {
                  this.setState(356);
                  this.match(KodkodParser.T__1);
                  this.setState(360);
                  this._errHandler.sync(this);
                  _alt = this.getInterpreter().adaptivePredict(this._input, 33, this._ctx);
                  while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                      {
                        {
                          this.setState(357);
                          this.formula(0);
                        }
                      }
                    }
                    this.setState(362);
                    this._errHandler.sync(this);
                    _alt = this.getInterpreter().adaptivePredict(this._input, 33, this._ctx);
                  }
                  this.setState(363);
                  this.match(KodkodParser.T__2);
                }
                  break;
                default:
                  throw new NoViableAltException(this);
              }
            }
            for (int i = 0; i < ((FormulaContext) this.getInvokingContext(13)).var; i++) {
              this.declarations.pop();
            }
          }
            break;
          case 18: {
            _localctx = new ForSomeContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            ((FormulaContext) this.getInvokingContext(13)).var = 0;
            {
              this.setState(369);
              this.match(KodkodParser.T__16);
              this.setState(370);
              this.decls();
              this.setState(391);
              switch (this._input.LA(1)) {
                case T__34: {
                  this.setState(371);
                  this.match(KodkodParser.T__34);
                  this.setState(381);
                  switch (this.getInterpreter().adaptivePredict(this._input, 36, this._ctx)) {
                    case 1: {
                      this.setState(372);
                      this.formula(0);
                    }
                      break;
                    case 2: {
                      this.setState(373);
                      this.match(KodkodParser.T__1);
                      this.setState(377);
                      this._errHandler.sync(this);
                      _alt = this.getInterpreter().adaptivePredict(this._input, 35, this._ctx);
                      while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                          {
                            {
                              this.setState(374);
                              this.formula(0);
                            }
                          }
                        }
                        this.setState(379);
                        this._errHandler.sync(this);
                        _alt = this.getInterpreter().adaptivePredict(this._input, 35, this._ctx);
                      }
                      this.setState(380);
                      this.match(KodkodParser.T__2);
                    }
                      break;
                  }
                }
                  break;
                case T__1: {
                  this.setState(383);
                  this.match(KodkodParser.T__1);
                  this.setState(387);
                  this._errHandler.sync(this);
                  _alt = this.getInterpreter().adaptivePredict(this._input, 37, this._ctx);
                  while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                      {
                        {
                          this.setState(384);
                          this.formula(0);
                        }
                      }
                    }
                    this.setState(389);
                    this._errHandler.sync(this);
                    _alt = this.getInterpreter().adaptivePredict(this._input, 37, this._ctx);
                  }
                  this.setState(390);
                  this.match(KodkodParser.T__2);
                }
                  break;
                default:
                  throw new NoViableAltException(this);
              }
            }
            for (int i = 0; i < ((FormulaContext) this.getInvokingContext(13)).var; i++) {
              this.declarations.pop();
            }
          }
            break;
          case 19: {
            _localctx = new ForNoContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            ((FormulaContext) this.getInvokingContext(13)).var = 0;
            {
              this.setState(396);
              this.match(KodkodParser.T__24);
              this.setState(397);
              this.decls();
              this.setState(418);
              switch (this._input.LA(1)) {
                case T__34: {
                  this.setState(398);
                  this.match(KodkodParser.T__34);
                  this.setState(408);
                  switch (this.getInterpreter().adaptivePredict(this._input, 40, this._ctx)) {
                    case 1: {
                      this.setState(399);
                      this.formula(0);
                    }
                      break;
                    case 2: {
                      this.setState(400);
                      this.match(KodkodParser.T__1);
                      this.setState(404);
                      this._errHandler.sync(this);
                      _alt = this.getInterpreter().adaptivePredict(this._input, 39, this._ctx);
                      while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                          {
                            {
                              this.setState(401);
                              this.formula(0);
                            }
                          }
                        }
                        this.setState(406);
                        this._errHandler.sync(this);
                        _alt = this.getInterpreter().adaptivePredict(this._input, 39, this._ctx);
                      }
                      this.setState(407);
                      this.match(KodkodParser.T__2);
                    }
                      break;
                  }
                }
                  break;
                case T__1: {
                  this.setState(410);
                  this.match(KodkodParser.T__1);
                  this.setState(414);
                  this._errHandler.sync(this);
                  _alt = this.getInterpreter().adaptivePredict(this._input, 41, this._ctx);
                  while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                      {
                        {
                          this.setState(411);
                          this.formula(0);
                        }
                      }
                    }
                    this.setState(416);
                    this._errHandler.sync(this);
                    _alt = this.getInterpreter().adaptivePredict(this._input, 41, this._ctx);
                  }
                  this.setState(417);
                  this.match(KodkodParser.T__2);
                }
                  break;
                default:
                  throw new NoViableAltException(this);
              }
            }
            for (int i = 0; i < ((FormulaContext) this.getInvokingContext(13)).var; i++) {
              this.declarations.pop();
            }
          }
            break;
          case 20: {
            _localctx = new ForOneContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            ((FormulaContext) this.getInvokingContext(13)).var = 0;
            {
              this.setState(423);
              this.match(KodkodParser.T__14);
              this.setState(424);
              this.decls();
              this.setState(445);
              switch (this._input.LA(1)) {
                case T__34: {
                  this.setState(425);
                  this.match(KodkodParser.T__34);
                  this.setState(435);
                  switch (this.getInterpreter().adaptivePredict(this._input, 44, this._ctx)) {
                    case 1: {
                      this.setState(426);
                      this.formula(0);
                    }
                      break;
                    case 2: {
                      this.setState(427);
                      this.match(KodkodParser.T__1);
                      this.setState(431);
                      this._errHandler.sync(this);
                      _alt = this.getInterpreter().adaptivePredict(this._input, 43, this._ctx);
                      while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                          {
                            {
                              this.setState(428);
                              this.formula(0);
                            }
                          }
                        }
                        this.setState(433);
                        this._errHandler.sync(this);
                        _alt = this.getInterpreter().adaptivePredict(this._input, 43, this._ctx);
                      }
                      this.setState(434);
                      this.match(KodkodParser.T__2);
                    }
                      break;
                  }
                }
                  break;
                case T__1: {
                  this.setState(437);
                  this.match(KodkodParser.T__1);
                  this.setState(441);
                  this._errHandler.sync(this);
                  _alt = this.getInterpreter().adaptivePredict(this._input, 45, this._ctx);
                  while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                      {
                        {
                          this.setState(438);
                          this.formula(0);
                        }
                      }
                    }
                    this.setState(443);
                    this._errHandler.sync(this);
                    _alt = this.getInterpreter().adaptivePredict(this._input, 45, this._ctx);
                  }
                  this.setState(444);
                  this.match(KodkodParser.T__2);
                }
                  break;
                default:
                  throw new NoViableAltException(this);
              }
            }
            for (int i = 0; i < ((FormulaContext) this.getInvokingContext(13)).var; i++) {
              this.declarations.pop();
            }
          }
            break;
          case 21: {
            _localctx = new ForLoneContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            ((FormulaContext) this.getInvokingContext(13)).var = 0;
            {
              this.setState(450);
              this.match(KodkodParser.T__15);
              this.setState(451);
              this.decls();
              this.setState(472);
              switch (this._input.LA(1)) {
                case T__34: {
                  this.setState(452);
                  this.match(KodkodParser.T__34);
                  this.setState(462);
                  switch (this.getInterpreter().adaptivePredict(this._input, 48, this._ctx)) {
                    case 1: {
                      this.setState(453);
                      this.formula(0);
                    }
                      break;
                    case 2: {
                      this.setState(454);
                      this.match(KodkodParser.T__1);
                      this.setState(458);
                      this._errHandler.sync(this);
                      _alt = this.getInterpreter().adaptivePredict(this._input, 47, this._ctx);
                      while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                          {
                            {
                              this.setState(455);
                              this.formula(0);
                            }
                          }
                        }
                        this.setState(460);
                        this._errHandler.sync(this);
                        _alt = this.getInterpreter().adaptivePredict(this._input, 47, this._ctx);
                      }
                      this.setState(461);
                      this.match(KodkodParser.T__2);
                    }
                      break;
                  }
                }
                  break;
                case T__1: {
                  this.setState(464);
                  this.match(KodkodParser.T__1);
                  this.setState(468);
                  this._errHandler.sync(this);
                  _alt = this.getInterpreter().adaptivePredict(this._input, 49, this._ctx);
                  while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                      {
                        {
                          this.setState(465);
                          this.formula(0);
                        }
                      }
                    }
                    this.setState(470);
                    this._errHandler.sync(this);
                    _alt = this.getInterpreter().adaptivePredict(this._input, 49, this._ctx);
                  }
                  this.setState(471);
                  this.match(KodkodParser.T__2);
                }
                  break;
                default:
                  throw new NoViableAltException(this);
              }
            }
            for (int i = 0; i < ((FormulaContext) this.getInvokingContext(13)).var; i++) {
              this.declarations.pop();
            }
          }
            break;
          case 22: {
            _localctx = new LetContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            ((FormulaContext) this.getInvokingContext(13)).var = 0;
            {
              this.setState(477);
              this.match(KodkodParser.T__47);
              this.setState(478);
              this.letDecls();
              this.setState(499);
              switch (this._input.LA(1)) {
                case T__34: {
                  this.setState(479);
                  this.match(KodkodParser.T__34);
                  this.setState(489);
                  switch (this.getInterpreter().adaptivePredict(this._input, 52, this._ctx)) {
                    case 1: {
                      this.setState(480);
                      this.formula(0);
                    }
                      break;
                    case 2: {
                      this.setState(481);
                      this.match(KodkodParser.T__1);
                      this.setState(485);
                      this._errHandler.sync(this);
                      _alt = this.getInterpreter().adaptivePredict(this._input, 51, this._ctx);
                      while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                          {
                            {
                              this.setState(482);
                              this.formula(0);
                            }
                          }
                        }
                        this.setState(487);
                        this._errHandler.sync(this);
                        _alt = this.getInterpreter().adaptivePredict(this._input, 51, this._ctx);
                      }
                      this.setState(488);
                      this.match(KodkodParser.T__2);
                    }
                      break;
                  }
                }
                  break;
                case T__1: {
                  this.setState(491);
                  this.match(KodkodParser.T__1);
                  this.setState(495);
                  this._errHandler.sync(this);
                  _alt = this.getInterpreter().adaptivePredict(this._input, 53, this._ctx);
                  while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                      {
                        {
                          this.setState(492);
                          this.formula(0);
                        }
                      }
                    }
                    this.setState(497);
                    this._errHandler.sync(this);
                    _alt = this.getInterpreter().adaptivePredict(this._input, 53, this._ctx);
                  }
                  this.setState(498);
                  this.match(KodkodParser.T__2);
                }
                  break;
                default:
                  throw new NoViableAltException(this);
              }
            }
            for (int i = 0; i < ((FormulaContext) this.getInvokingContext(13)).var; i++) {
              this.declarations.pop();
            }
          }
            break;
          case 23: {
            _localctx = new TrueContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(503);
            this.match(KodkodParser.T__48);
          }
            break;
          case 24: {
            _localctx = new FalseContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(504);
            this.match(KodkodParser.T__49);
          }
            break;
          case 25: {
            _localctx = new F_paranthesisContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(505);
            this.match(KodkodParser.T__21);
            this.setState(506);
            this.formula(0);
            this.setState(507);
            this.match(KodkodParser.T__22);
          }
            break;
        }
        this._ctx.stop = this._input.LT(-1);
        this.setState(525);
        this._errHandler.sync(this);
        _alt = this.getInterpreter().adaptivePredict(this._input, 57, this._ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (this._parseListeners != null) {
              this.triggerExitRuleEvent();
            }
            _prevctx = _localctx;
            {
              this.setState(523);
              switch (this.getInterpreter().adaptivePredict(this._input, 56, this._ctx)) {
                case 1: {
                  _localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
                  ((AndContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, KodkodParser.RULE_formula);
                  this.setState(511);
                  if (!this.precpred(this._ctx, 13)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 13)");
                  }
                  this.setState(512);
                  ((AndContext) _localctx).op = this._input.LT(1);
                  _la = this._input.LA(1);
                  if (!(_la == KodkodParser.T__38 || _la == KodkodParser.T__39)) {
                    ((AndContext) _localctx).op = this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(513);
                  ((AndContext) _localctx).right = this.formula(13);
                }
                  break;
                case 2: {
                  _localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
                  ((OrContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, KodkodParser.RULE_formula);
                  this.setState(514);
                  if (!this.precpred(this._ctx, 12)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                  }
                  this.setState(515);
                  ((OrContext) _localctx).op = this._input.LT(1);
                  _la = this._input.LA(1);
                  if (!(_la == KodkodParser.T__40 || _la == KodkodParser.T__41)) {
                    ((OrContext) _localctx).op = this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(516);
                  ((OrContext) _localctx).right = this.formula(12);
                }
                  break;
                case 3: {
                  _localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
                  ((ImpliesContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, KodkodParser.RULE_formula);
                  this.setState(517);
                  if (!this.precpred(this._ctx, 11)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                  }
                  this.setState(518);
                  ((ImpliesContext) _localctx).op = this._input.LT(1);
                  _la = this._input.LA(1);
                  if (!(_la == KodkodParser.T__42 || _la == KodkodParser.T__43)) {
                    ((ImpliesContext) _localctx).op = this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(519);
                  ((ImpliesContext) _localctx).right = this.formula(11);
                }
                  break;
                case 4: {
                  _localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
                  ((IffContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, KodkodParser.RULE_formula);
                  this.setState(520);
                  if (!this.precpred(this._ctx, 10)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                  }
                  this.setState(521);
                  ((IffContext) _localctx).op = this._input.LT(1);
                  _la = this._input.LA(1);
                  if (!(_la == KodkodParser.T__44 || _la == KodkodParser.T__45)) {
                    ((IffContext) _localctx).op = this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(522);
                  ((IffContext) _localctx).right = this.formula(10);
                }
                  break;
              }
            }
          }
          this.setState(527);
          this._errHandler.sync(this);
          _alt = this.getInterpreter().adaptivePredict(this._input, 57, this._ctx);
        }
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  private boolean formula_sempred(final FormulaContext _localctx, final int predIndex) {
    switch (predIndex) {
      case 2:
        return this.precpred(this._ctx, 13);
      case 3:
        return this.precpred(this._ctx, 12);
      case 4:
        return this.precpred(this._ctx, 11);
      case 5:
        return this.precpred(this._ctx, 10);
    }
    return true;
  }

  @Override
  public ATN getATN() {
    return KodkodParser._ATN;
  }

  @Override
  public String getGrammarFileName() {
    return "Kodkod.g4";
  }

  private String getLocation() {
    return "[" + this.getCurrentToken().getLine() + ","
        + this.getCurrentToken().getCharPositionInLine() + "]";
  }

  @Override
  public String[] getRuleNames() {
    return KodkodParser.ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return KodkodParser._serializedATN;
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return KodkodParser.tokenNames;
  }

  @Override

  public Vocabulary getVocabulary() {
    return KodkodParser.VOCABULARY;
  }

  public final IntegerContext integer() throws RecognitionException {
    final IntegerContext _localctx = new IntegerContext(this._ctx, this.getState());
    this.enterRule(_localctx, 22, KodkodParser.RULE_integer);
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(243);
        this.match(KodkodParser.INT);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final IntexpressionContext intexpression() throws RecognitionException {
    return this.intexpression(0);
  }

  private IntexpressionContext intexpression(final int _p) throws RecognitionException {
    final ParserRuleContext _parentctx = this._ctx;
    final int _parentState = this.getState();
    IntexpressionContext _localctx = new IntexpressionContext(this._ctx, _parentState);
    IntexpressionContext _prevctx = _localctx;
    final int _startState = 30;
    this.enterRecursionRule(_localctx, 30, KodkodParser.RULE_intexpression, _p);
    int _la;
    try {
      int _alt;
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(615);
        switch (this._input.LA(1)) {
          case T__42:
          case T__43: {
            _localctx = new IfIntExpressionContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;

            this.setState(596);
            ((IfIntExpressionContext) _localctx).op = this._input.LT(1);
            _la = this._input.LA(1);
            if (!(_la == KodkodParser.T__42 || _la == KodkodParser.T__43)) {
              ((IfIntExpressionContext) _localctx).op = this._errHandler.recoverInline(this);
            } else {
              this.consume();
            }
            this.setState(597);
            ((IfIntExpressionContext) _localctx).condition = this.formula(0);
            this.setState(598);
            this.match(KodkodParser.T__55);
            this.setState(599);
            ((IfIntExpressionContext) _localctx).thenExpr = this.intexpression(0);
            this.setState(600);
            this.match(KodkodParser.T__56);
            this.setState(601);
            ((IfIntExpressionContext) _localctx).elseExpr = this.intexpression(10);
          }
            break;
          case T__33: {
            _localctx = new SumContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(603);
            this.match(KodkodParser.T__33);
            this.setState(604);
            this.expression(0);
          }
            break;
          case T__61: {
            _localctx = new CountContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(605);
            this.match(KodkodParser.T__61);
            this.setState(606);
            this.expression(0);
          }
            break;
          case T__20:
          case INT: {
            _localctx = new IntConstantContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(608);
            _la = this._input.LA(1);
            if (_la == KodkodParser.T__20) {
              {
                this.setState(607);
                ((IntConstantContext) _localctx).sign = this.match(KodkodParser.T__20);
              }
            }

            this.setState(610);
            this.integer();
          }
            break;
          case T__21: {
            _localctx = new I_paranthesisContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(611);
            this.match(KodkodParser.T__21);
            this.setState(612);
            this.intexpression(0);
            this.setState(613);
            this.match(KodkodParser.T__22);
          }
            break;
          default:
            throw new NoViableAltException(this);
        }
        this._ctx.stop = this._input.LT(-1);
        this.setState(634);
        this._errHandler.sync(this);
        _alt = this.getInterpreter().adaptivePredict(this._input, 64, this._ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (this._parseListeners != null) {
              this.triggerExitRuleEvent();
            }
            _prevctx = _localctx;
            {
              this.setState(632);
              switch (this.getInterpreter().adaptivePredict(this._input, 63, this._ctx)) {
                case 1: {
                  _localctx = new PlusContext(new IntexpressionContext(_parentctx, _parentState));
                  ((PlusContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_intexpression);
                  this.setState(617);
                  if (!this.precpred(this._ctx, 7)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                  }
                  this.setState(618);
                  _la = this._input.LA(1);
                  if (!(_la == KodkodParser.T__18 || _la == KodkodParser.T__62)) {
                    this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(619);
                  ((PlusContext) _localctx).right = this.intexpression(8);
                }
                  break;
                case 2: {
                  _localctx = new MinusContext(new IntexpressionContext(_parentctx, _parentState));
                  ((MinusContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_intexpression);
                  this.setState(620);
                  if (!this.precpred(this._ctx, 6)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                  }
                  this.setState(621);
                  _la = this._input.LA(1);
                  if (!(_la == KodkodParser.T__20 || _la == KodkodParser.T__63)) {
                    this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(622);
                  ((MinusContext) _localctx).right = this.intexpression(7);
                }
                  break;
                case 3: {
                  _localctx =
                      new MultiplyContext(new IntexpressionContext(_parentctx, _parentState));
                  ((MultiplyContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_intexpression);
                  this.setState(623);
                  if (!this.precpred(this._ctx, 5)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                  }
                  this.setState(624);
                  _la = this._input.LA(1);
                  if (!(_la == KodkodParser.T__52 || _la == KodkodParser.T__64)) {
                    this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(625);
                  ((MultiplyContext) _localctx).right = this.intexpression(6);
                }
                  break;
                case 4: {
                  _localctx = new DivideContext(new IntexpressionContext(_parentctx, _parentState));
                  ((DivideContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_intexpression);
                  this.setState(626);
                  if (!this.precpred(this._ctx, 4)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                  }
                  this.setState(627);
                  _la = this._input.LA(1);
                  if (!(_la == KodkodParser.T__65 || _la == KodkodParser.T__66)) {
                    this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(628);
                  ((DivideContext) _localctx).right = this.intexpression(5);
                }
                  break;
                case 5: {
                  _localctx = new ModuloContext(new IntexpressionContext(_parentctx, _parentState));
                  ((ModuloContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState,
                      KodkodParser.RULE_intexpression);
                  this.setState(629);
                  if (!this.precpred(this._ctx, 3)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                  }
                  this.setState(630);
                  _la = this._input.LA(1);
                  if (!(_la == KodkodParser.T__67 || _la == KodkodParser.T__68)) {
                    this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(631);
                  ((ModuloContext) _localctx).right = this.intexpression(4);
                }
                  break;
              }
            }
          }
          this.setState(636);
          this._errHandler.sync(this);
          _alt = this.getInterpreter().adaptivePredict(this._input, 64, this._ctx);
        }
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  private boolean intexpression_sempred(final IntexpressionContext _localctx, final int predIndex) {
    switch (predIndex) {
      case 15:
        return this.precpred(this._ctx, 7);
      case 16:
        return this.precpred(this._ctx, 6);
      case 17:
        return this.precpred(this._ctx, 5);
      case 18:
        return this.precpred(this._ctx, 4);
      case 19:
        return this.precpred(this._ctx, 3);
    }
    return true;
  }

  private boolean isRelation() {
    return this.relations.containsKey(this.getCurrentToken().getText());
  }

  public final LetDeclContext letDecl() throws RecognitionException {
    final LetDeclContext _localctx = new LetDeclContext(this._ctx, this.getState());
    this.enterRule(_localctx, 38, KodkodParser.RULE_letDecl);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        {
          this.setState(721);
          _localctx.variable = this.variable();
          _localctx.vars.add(_localctx.variable);
          this.setState(726);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
          while (_la == KodkodParser.T__4) {
            {
              {
                this.setState(722);
                this.match(KodkodParser.T__4);
                this.setState(723);
                _localctx.variable = this.variable();
                _localctx.vars.add(_localctx.variable);
              }
            }
            this.setState(728);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
          }
          this.setState(729);
          this.match(KodkodParser.T__28);
          this.setState(730);
          this.expression(0);
        }
        ((FormulaContext) this.getInvokingContext(13)).var = this.declareVariables(_localctx.vars,
            ((FormulaContext) this.getInvokingContext(13)).var);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final LetDeclsContext letDecls() throws RecognitionException {
    final LetDeclsContext _localctx = new LetDeclsContext(this._ctx, this.getState());
    this.enterRule(_localctx, 36, KodkodParser.RULE_letDecls);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(713);
        this.letDecl();
        this.setState(718);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while (_la == KodkodParser.T__4) {
          {
            {
              this.setState(714);
              this.match(KodkodParser.T__4);
              this.setState(715);
              this.letDecl();
            }
          }
          this.setState(720);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        }
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final OptionContext option() throws RecognitionException {
    OptionContext _localctx = new OptionContext(this._ctx, this.getState());
    this.enterRule(_localctx, 4, KodkodParser.RULE_option);
    try {
      this.setState(88);
      switch (this._input.LA(1)) {
        case T__5:
          _localctx = new SymmetryBreakingContext(_localctx);
          this.enterOuterAlt(_localctx, 1); {
          this.setState(76);
          this.match(KodkodParser.T__5);
          this.setState(77);
          this.match(KodkodParser.T__6);
          this.setState(78);
          this.integer();
        }
          break;
        case T__7:
          _localctx = new BitWidthContext(_localctx);
          this.enterOuterAlt(_localctx, 2); {
          this.setState(79);
          this.match(KodkodParser.T__7);
          this.setState(80);
          this.match(KodkodParser.T__6);
          this.setState(81);
          this.integer();
        }
          break;
        case T__8:
          _localctx = new SkolemDepthContext(_localctx);
          this.enterOuterAlt(_localctx, 3); {
          this.setState(82);
          this.match(KodkodParser.T__8);
          this.setState(83);
          this.match(KodkodParser.T__6);
          this.setState(84);
          this.integer();
        }
          break;
        case T__9:
          _localctx = new SharingContext(_localctx);
          this.enterOuterAlt(_localctx, 4); {
          this.setState(85);
          this.match(KodkodParser.T__9);
          this.setState(86);
          this.match(KodkodParser.T__6);
          this.setState(87);
          this.integer();
        }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final OptionsContext options() throws RecognitionException {
    final OptionsContext _localctx = new OptionsContext(this._ctx, this.getState());
    this.enterRule(_localctx, 2, KodkodParser.RULE_options);
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(68);
        this.match(KodkodParser.T__3);
        this.setState(69);
        this.match(KodkodParser.T__1);
        this.setState(70);
        this.option();
        {
          this.setState(71);
          this.match(KodkodParser.T__4);
          this.setState(72);
          this.option();
        }
        this.setState(74);
        this.match(KodkodParser.T__2);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final ProblemContext problem() throws RecognitionException {
    final ProblemContext _localctx = new ProblemContext(this._ctx, this.getState());
    this.enterRule(_localctx, 0, KodkodParser.RULE_problem);
    int _la;
    try {
      int _alt;
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(45);
        _la = this._input.LA(1);
        if (_la == KodkodParser.T__3) {
          {
            this.setState(44);
            this.options();
          }
        }

        this.setState(47);
        this.universe();
        System.out.println(this.universe);
        this.setState(49);
        this.match(KodkodParser.T__0);
        this.setState(50);
        this.match(KodkodParser.T__1);
        this.setState(54);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while (_la == KodkodParser.IDENTIFIER) {
          {
            {
              this.setState(51);
              this.relations();
            }
          }
          this.setState(56);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        }
        System.out.println(this.bounds);
        this.setState(58);
        this.match(KodkodParser.T__2);
        this.setState(62);
        this._errHandler.sync(this);
        _alt = this.getInterpreter().adaptivePredict(this._input, 2, this._ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                this.setState(59);
                _localctx.formula = this.formula(0);
                _localctx.formulas.add(_localctx.formula);
              }
            }
          }
          this.setState(64);
          this._errHandler.sync(this);
          _alt = this.getInterpreter().adaptivePredict(this._input, 2, this._ctx);
        }


        System.out.println("declarations= " + this.declarations);
        this.declarations.clear();

      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final RelationContext relation() throws RecognitionException {
    final RelationContext _localctx = new RelationContext(this._ctx, this.getState());
    this.enterRule(_localctx, 18, KodkodParser.RULE_relation);
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(239);
        this.match(KodkodParser.IDENTIFIER);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final RelationsContext relations() throws RecognitionException {
    final RelationsContext _localctx = new RelationsContext(this._ctx, this.getState());
    this.enterRule(_localctx, 8, KodkodParser.RULE_relations);
    this.context = "relations";
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        {
          this.setState(117);
          _localctx.relation = this.relation();
          this.setState(119);
          _la = this._input.LA(1);
          if (_la == KodkodParser.INT) {
            {
              this.setState(118);
              _localctx.arity = this.arity();
            }
          }

          this.setState(121);
          this.match(KodkodParser.T__6);
          this.setState(123);
          _la = this._input.LA(1);
          if (_la == KodkodParser.T__21 || _la == KodkodParser.IDENTIFIER) {
            {
              this.setState(122);
              this.type(0);
            }
          }

          this.setState(125);
          this.match(KodkodParser.T__11);
          {
            this.setState(126);
            _localctx.lowerBound = this.tupleSet();
            this.setState(129);
            _la = this._input.LA(1);
            if (_la == KodkodParser.T__4) {
              {
                this.setState(127);
                this.match(KodkodParser.T__4);
                this.setState(128);
                _localctx.upperBound = this.tupleSet();
              }
            }

          }
          this.setState(131);
          this.match(KodkodParser.T__12);
        }

        final String name = _localctx.relation != null
            ? this._input.getText(_localctx.relation.start, _localctx.relation.stop) : null;
        System.out.println("relation " + name);
        if (this.relations.containsKey(name)) {
          System.err.println("duplicated relation found: '" + name + "' at " + this.getLocation());
        }

        kodkod.ast.Relation relation = null;
        int arity = 0;
        if ((_localctx.arity != null
            ? this._input.getText(_localctx.arity.start, _localctx.arity.stop) : null) != null
            && !(_localctx.arity != null
                ? this._input.getText(_localctx.arity.start, _localctx.arity.stop) : null)
                    .isEmpty()) {
          arity = Integer.parseInt(_localctx.arity != null
              ? this._input.getText(_localctx.arity.start, _localctx.arity.stop) : null);
        }

        kodkod.instance.TupleSet lowerBound = null;
        final java.util.List<kodkod.instance.Tuple> tuplesInLowerBound =
            new java.util.ArrayList<kodkod.instance.Tuple>();
        if (_localctx.lowerBound != null && !_localctx.lowerBound.tuples.isEmpty()) {
          if (arity == 0) {
            arity = _localctx.lowerBound.tuples.get(0).atoms.size();
          }
          for (final TupleContext tuple : _localctx.lowerBound.tuples) {
            final java.util.List<String> atoms = new java.util.ArrayList<String>();
            for (final AtomContext atom : tuple.atoms) {
              atoms.add(atom.getText());
            }
            tuplesInLowerBound.add(this.universe.factory().tuple(atoms));
          }
          lowerBound = this.universe.factory().setOf(tuplesInLowerBound);
          System.out.println("lb: " + lowerBound);
        }

        kodkod.instance.TupleSet upperBound = null;
        final java.util.List<kodkod.instance.Tuple> tuplesInUpperBound =
            new java.util.ArrayList<kodkod.instance.Tuple>();
        if (_localctx.upperBound != null && !_localctx.upperBound.tuples.isEmpty()) {
          if (lowerBound == null && arity == 0) {
            arity = _localctx.upperBound.tuples.get(0).atoms.size();
          }
          for (final TupleContext tuple : _localctx.upperBound.tuples) {
            final java.util.List<String> atoms = new java.util.ArrayList<String>();
            for (final AtomContext atom : tuple.atoms) {
              atoms.add(atom.getText());
            }
            tuplesInUpperBound.add(this.universe.factory().tuple(atoms));
          }
          upperBound = this.universe.factory().setOf(tuplesInUpperBound);
          System.out.println("up: " + upperBound);
        }

        if (lowerBound == null && upperBound == null && arity == 0) {
          arity = 1;
        }

        if (lowerBound == null) {
          lowerBound = this.universe.factory().noneOf(arity);
        }

        System.out.println(arity);
        if (arity == 0) {
          System.err
              .println("0 arity is detected on relation: '" + name + "' at " + this.getLocation());
        } else if (arity > 0) {
          relation = kodkod.ast.Relation.nary(name, arity);
        }

        if (upperBound == null) {
          this.bounds.boundExactly(relation, lowerBound);
        } else {
          this.bounds.bound(relation, lowerBound, upperBound);
        }
        this.relations.put(name, relation);

      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  @Override
  public boolean sempred(final RuleContext _localctx, final int ruleIndex, final int predIndex) {
    switch (ruleIndex) {
      case 5:
        return this.type_sempred((TypeContext) _localctx, predIndex);
      case 13:
        return this.formula_sempred((FormulaContext) _localctx, predIndex);
      case 14:
        return this.expression_sempred((ExpressionContext) _localctx, predIndex);
      case 15:
        return this.intexpression_sempred((IntexpressionContext) _localctx, predIndex);
    }
    return true;
  }

  public final TupleContext tuple() throws RecognitionException {
    final TupleContext _localctx = new TupleContext(this._ctx, this.getState());
    this.enterRule(_localctx, 14, KodkodParser.RULE_tuple);
    int _la;
    try {
      this.setState(232);
      switch (this._input.LA(1)) {
        case T__21:
          this.enterOuterAlt(_localctx, 1); {
          this.setState(210);
          this.match(KodkodParser.T__21);
          this.setState(211);
          _localctx.atom = this.atom();
          _localctx.atoms.add(_localctx.atom);
          this.setState(216);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
          while (_la == KodkodParser.T__4) {
            {
              {
                this.setState(212);
                this.match(KodkodParser.T__4);
                this.setState(213);
                _localctx.atom = this.atom();
                _localctx.atoms.add(_localctx.atom);
              }
            }
            this.setState(218);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
          }
          this.setState(219);
          this.match(KodkodParser.T__22);
        }
          break;
        case T__11:
          this.enterOuterAlt(_localctx, 2); {
          this.setState(221);
          this.match(KodkodParser.T__11);
          this.setState(222);
          _localctx.atom = this.atom();
          _localctx.atoms.add(_localctx.atom);
          this.setState(227);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
          while (_la == KodkodParser.T__4) {
            {
              {
                this.setState(223);
                this.match(KodkodParser.T__4);
                this.setState(224);
                _localctx.atom = this.atom();
                _localctx.atoms.add(_localctx.atom);
              }
            }
            this.setState(229);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
          }
          this.setState(230);
          this.match(KodkodParser.T__12);
        }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final TupleSetContext tupleSet() throws RecognitionException {
    final TupleSetContext _localctx = new TupleSetContext(this._ctx, this.getState());
    this.enterRule(_localctx, 12, KodkodParser.RULE_tupleSet);
    int _la;
    try {
      this.setState(208);
      switch (this.getInterpreter().adaptivePredict(this._input, 19, this._ctx)) {
        case 1:
          this.enterOuterAlt(_localctx, 1); {
          this.setState(160);
          this.match(KodkodParser.T__1);
          this.setState(169);
          _la = this._input.LA(1);
          if (_la == KodkodParser.T__11 || _la == KodkodParser.T__21) {
            {
              this.setState(161);
              _localctx.tuple = this.tuple();
              _localctx.tuples.add(_localctx.tuple);
              this.setState(166);
              this._errHandler.sync(this);
              _la = this._input.LA(1);
              while (_la == KodkodParser.T__4) {
                {
                  {
                    this.setState(162);
                    this.match(KodkodParser.T__4);
                    this.setState(163);
                    _localctx.tuple = this.tuple();
                    _localctx.tuples.add(_localctx.tuple);
                  }
                }
                this.setState(168);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
              }
            }
          }

          this.setState(171);
          this.match(KodkodParser.T__2);
        }
          break;
        case 2:
          this.enterOuterAlt(_localctx, 2); {
          this.setState(172);
          this.match(KodkodParser.T__11);
          this.setState(181);
          _la = this._input.LA(1);
          if (_la == KodkodParser.T__11 || _la == KodkodParser.T__21) {
            {
              this.setState(173);
              _localctx.tuple = this.tuple();
              _localctx.tuples.add(_localctx.tuple);
              this.setState(178);
              this._errHandler.sync(this);
              _la = this._input.LA(1);
              while (_la == KodkodParser.T__4) {
                {
                  {
                    this.setState(174);
                    this.match(KodkodParser.T__4);
                    this.setState(175);
                    _localctx.tuple = this.tuple();
                    _localctx.tuples.add(_localctx.tuple);
                  }
                }
                this.setState(180);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
              }
            }
          }

          this.setState(183);
          this.match(KodkodParser.T__12);
        }
          break;
        case 3:
          this.enterOuterAlt(_localctx, 3); {
          this.setState(184);
          this.match(KodkodParser.T__1);
          this.setState(185);
          _localctx.left = this.tuple();
          this.setState(186);
          _localctx.range = this.match(KodkodParser.T__23);
          this.setState(187);
          _localctx.right = this.tuple();
          this.setState(188);
          this.match(KodkodParser.T__2);
        }
          break;
        case 4:
          this.enterOuterAlt(_localctx, 4); {
          this.setState(190);
          this.match(KodkodParser.T__11);
          this.setState(191);
          _localctx.left = this.tuple();
          this.setState(192);
          _localctx.range = this.match(KodkodParser.T__23);
          this.setState(193);
          _localctx.right = this.tuple();
          this.setState(194);
          this.match(KodkodParser.T__12);
        }
          break;
        case 5:
          this.enterOuterAlt(_localctx, 5); {
          this.setState(196);
          this.match(KodkodParser.T__1);
          this.setState(197);
          _localctx.left = this.relation();
          this.setState(198);
          _localctx.range = this.match(KodkodParser.T__17);
          this.setState(199);
          _localctx.right = this.relation();
          this.setState(200);
          this.match(KodkodParser.T__2);
        }
          break;
        case 6:
          this.enterOuterAlt(_localctx, 6); {
          this.setState(202);
          this.match(KodkodParser.T__11);
          this.setState(203);
          _localctx.left = this.relation();
          this.setState(204);
          _localctx.range = this.match(KodkodParser.T__17);
          this.setState(205);
          _localctx.right = this.relation();
          this.setState(206);
          this.match(KodkodParser.T__12);
        }
          break;
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final TypeContext type() throws RecognitionException {
    return this.type(0);
  }

  private TypeContext type(final int _p) throws RecognitionException {
    final ParserRuleContext _parentctx = this._ctx;
    final int _parentState = this.getState();
    TypeContext _localctx = new TypeContext(this._ctx, _parentState);
    TypeContext _prevctx = _localctx;
    final int _startState = 10;
    this.enterRecursionRule(_localctx, 10, KodkodParser.RULE_type, _p);
    int _la;
    try {
      int _alt;
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(141);
        switch (this._input.LA(1)) {
          case T__21: {
            _localctx = new NestedMultiplicityContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;

            this.setState(136);
            this.match(KodkodParser.T__21);
            this.setState(137);
            this.type(0);
            this.setState(138);
            this.match(KodkodParser.T__22);
          }
            break;
          case IDENTIFIER: {
            _localctx = new SetContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(140);
            this.relation();
          }
            break;
          default:
            throw new NoViableAltException(this);
        }
        this._ctx.stop = this._input.LT(-1);
        this.setState(157);
        this._errHandler.sync(this);
        _alt = this.getInterpreter().adaptivePredict(this._input, 14, this._ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (this._parseListeners != null) {
              this.triggerExitRuleEvent();
            }
            _prevctx = _localctx;
            {
              this.setState(155);
              switch (this.getInterpreter().adaptivePredict(this._input, 13, this._ctx)) {
                case 1: {
                  _localctx =
                      new CartesianProductContext(new TypeContext(_parentctx, _parentState));
                  ((CartesianProductContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, KodkodParser.RULE_type);
                  this.setState(143);
                  if (!this.precpred(this._ctx, 4)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                  }
                  this.setState(145);
                  _la = this._input.LA(1);
                  if ((_la & ~0x3f) == 0
                      && (1L << _la & (1L << KodkodParser.T__13 | 1L << KodkodParser.T__14
                          | 1L << KodkodParser.T__15 | 1L << KodkodParser.T__16)) != 0) {
                    {
                      this.setState(144);
                      ((CartesianProductContext) _localctx).leftMult = this._input.LT(1);
                      _la = this._input.LA(1);
                      if (!((_la & ~0x3f) == 0
                          && (1L << _la & (1L << KodkodParser.T__13 | 1L << KodkodParser.T__14
                              | 1L << KodkodParser.T__15 | 1L << KodkodParser.T__16)) != 0)) {
                        ((CartesianProductContext) _localctx).leftMult =
                            this._errHandler.recoverInline(this);
                      } else {
                        this.consume();
                      }
                    }
                  }

                  this.setState(147);
                  this.match(KodkodParser.T__17);
                  this.setState(149);
                  _la = this._input.LA(1);
                  if ((_la & ~0x3f) == 0
                      && (1L << _la & (1L << KodkodParser.T__13 | 1L << KodkodParser.T__14
                          | 1L << KodkodParser.T__15 | 1L << KodkodParser.T__16)) != 0) {
                    {
                      this.setState(148);
                      ((CartesianProductContext) _localctx).rightMult = this._input.LT(1);
                      _la = this._input.LA(1);
                      if (!((_la & ~0x3f) == 0
                          && (1L << _la & (1L << KodkodParser.T__13 | 1L << KodkodParser.T__14
                              | 1L << KodkodParser.T__15 | 1L << KodkodParser.T__16)) != 0)) {
                        ((CartesianProductContext) _localctx).rightMult =
                            this._errHandler.recoverInline(this);
                      } else {
                        this.consume();
                      }
                    }
                  }

                  this.setState(151);
                  ((CartesianProductContext) _localctx).right = this.type(4);
                }
                  break;
                case 2: {
                  _localctx =
                      new SetOperationsOnTypesContext(new TypeContext(_parentctx, _parentState));
                  ((SetOperationsOnTypesContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, KodkodParser.RULE_type);
                  this.setState(152);
                  if (!this.precpred(this._ctx, 3)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                  }
                  this.setState(153);
                  ((SetOperationsOnTypesContext) _localctx).op = this._input.LT(1);
                  _la = this._input.LA(1);
                  if (!((_la & ~0x3f) == 0 && (1L << _la & (1L << KodkodParser.T__18
                      | 1L << KodkodParser.T__19 | 1L << KodkodParser.T__20)) != 0)) {
                    ((SetOperationsOnTypesContext) _localctx).op =
                        this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(154);
                  ((SetOperationsOnTypesContext) _localctx).right = this.type(4);
                }
                  break;
              }
            }
          }
          this.setState(159);
          this._errHandler.sync(this);
          _alt = this.getInterpreter().adaptivePredict(this._input, 14, this._ctx);
        }
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  private boolean type_sempred(final TypeContext _localctx, final int predIndex) {
    switch (predIndex) {
      case 0:
        return this.precpred(this._ctx, 4);
      case 1:
        return this.precpred(this._ctx, 3);
    }
    return true;
  }

  public final UniverseContext universe() throws RecognitionException {
    final UniverseContext _localctx = new UniverseContext(this._ctx, this.getState());
    this.enterRule(_localctx, 6, KodkodParser.RULE_universe);
    this.context = "universe";
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(113);
        switch (this._input.LA(1)) {
          case T__10: {
            this.setState(90);
            this.match(KodkodParser.T__10);
            {
              this.setState(91);
              this.match(KodkodParser.T__1);
              {
                this.setState(92);
                _localctx.atom = this.atom();
                _localctx.atoms.add(_localctx.atom);
                this.setState(97);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                while (_la == KodkodParser.T__4) {
                  {
                    {
                      this.setState(93);
                      this.match(KodkodParser.T__4);
                      this.setState(94);
                      _localctx.atom = this.atom();
                      _localctx.atoms.add(_localctx.atom);
                    }
                  }
                  this.setState(99);
                  this._errHandler.sync(this);
                  _la = this._input.LA(1);
                }
              }
              this.setState(100);
              this.match(KodkodParser.T__2);
            }
          }
            break;
          case T__11: {
            {
              this.setState(102);
              this.match(KodkodParser.T__11);
              {
                this.setState(103);
                _localctx.atom = this.atom();
                _localctx.atoms.add(_localctx.atom);
                this.setState(108);
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                while (_la == KodkodParser.T__4) {
                  {
                    {
                      this.setState(104);
                      this.match(KodkodParser.T__4);
                      this.setState(105);
                      _localctx.atom = this.atom();
                      _localctx.atoms.add(_localctx.atom);
                    }
                  }
                  this.setState(110);
                  this._errHandler.sync(this);
                  _la = this._input.LA(1);
                }
              }
              this.setState(111);
              this.match(KodkodParser.T__12);
            }
          }
            break;
          default:
            throw new NoViableAltException(this);
        }

        System.out.println("universe:");
        for (final AtomContext atom : _localctx.atoms) {
          final String s = atom.getText();
          System.out.println(s);
          if (this.atoms.contains(s)) {
            System.err.println("duplicated atom found: '" + s + "' at " + this.getLocation());
          } else {
            this.atoms.add(s);
          }
        }
        this.universe = new kodkod.instance.Universe(this.atoms);
        this.bounds = new kodkod.instance.Bounds(this.universe);
        this.context = null;

      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final VariableContext variable() throws RecognitionException {
    final VariableContext _localctx = new VariableContext(this._ctx, this.getState());
    this.enterRule(_localctx, 20, KodkodParser.RULE_variable);
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(241);
        this.match(KodkodParser.IDENTIFIER);
      }
    } catch (final RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }
}
