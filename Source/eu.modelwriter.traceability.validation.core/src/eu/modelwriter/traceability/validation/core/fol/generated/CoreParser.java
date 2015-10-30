// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\Core.g4 by ANTLR 4.5.1
package eu.modelwriter.traceability.validation.core.fol.generated;

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
public class CoreParser extends Parser {
  public static class ConjunctionContext extends ExprContext {
    public ExprContext left;
    public Token op;
    public ExprContext right;

    public ConjunctionContext(ExprContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitConjunction(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterConjunction(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitConjunction(this);
      }
    }

    public List<ExprContext> expr() {
      return this.getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return this.getRuleContext(ExprContext.class, i);
    }
  }

  public static class DisjunctionContext extends ExprContext {
    public ExprContext left;
    public Token op;
    public ExprContext right;

    public DisjunctionContext(ExprContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitDisjunction(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterDisjunction(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitDisjunction(this);
      }
    }

    public List<ExprContext> expr() {
      return this.getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return this.getRuleContext(ExprContext.class, i);
    }
  }
  public static class EquivalanceContext extends ExprContext {
    public ExprContext left;
    public Token op;
    public ExprContext right;

    public EquivalanceContext(ExprContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitEquivalance(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterEquivalance(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitEquivalance(this);
      }
    }

    public List<ExprContext> expr() {
      return this.getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return this.getRuleContext(ExprContext.class, i);
    }
  }
  public static class ExprContext extends ParserRuleContext {
    public ExprContext() {}

    public ExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    public void copyFrom(ExprContext ctx) {
      super.copyFrom(ctx);
    }

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_expr;
    }
  }
  public static class ImplicationContext extends ExprContext {
    public ExprContext left;
    public Token op;
    public ExprContext right;

    public ImplicationContext(ExprContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitImplication(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterImplication(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitImplication(this);
      }
    }

    public List<ExprContext> expr() {
      return this.getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return this.getRuleContext(ExprContext.class, i);
    }
  }
  public static class NegationContext extends ExprContext {
    public Token op;

    public NegationContext(ExprContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitNegation(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterNegation(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitNegation(this);
      }
    }

    public ExprContext expr() {
      return this.getRuleContext(ExprContext.class, 0);
    }
  }

  public static class ParenthesesContext extends ExprContext {
    public ParenthesesContext(ExprContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitParentheses(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterParentheses(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitParentheses(this);
      }
    }

    public ExprContext expr() {
      return this.getRuleContext(ExprContext.class, 0);
    }
  }
  public static class QuantiferContext extends ParserRuleContext {
    public Token op;

    public QuantiferContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitQuantifer(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterQuantifer(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitQuantifer(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_quantifer;
    }

    public List<TerminalNode> IDENTIFIER() {
      return this.getTokens(CoreParser.IDENTIFIER);
    }

    public TerminalNode IDENTIFIER(int i) {
      return this.getToken(CoreParser.IDENTIFIER, i);
    }
  }
  public static class QuantificationContext extends ExprContext {
    public QuantificationContext(ExprContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitQuantification(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterQuantification(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitQuantification(this);
      }
    }

    public ExprContext expr() {
      return this.getRuleContext(ExprContext.class, 0);
    }

    public QuantiferContext quantifer() {
      return this.getRuleContext(QuantiferContext.class, 0);
    }
  }

  public static class RelationContext extends ExprContext {
    public RelationContext(ExprContext ctx) {
      this.copyFrom(ctx);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitRelation(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterRelation(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitRelation(this);
      }
    }

    public List<TerminalNode> IDENTIFIER() {
      return this.getTokens(CoreParser.IDENTIFIER);
    }

    public TerminalNode IDENTIFIER(int i) {
      return this.getToken(CoreParser.IDENTIFIER, i);
    }

    public TerminalNode RELATION_NAME() {
      return this.getToken(CoreParser.RELATION_NAME, 0);
    }
  }
  public static class SentenceContext extends ParserRuleContext {
    public SentenceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitSentence(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterSentence(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitSentence(this);
      }
    }

    public ExprContext expr() {
      return this.getRuleContext(ExprContext.class, 0);
    }

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_sentence;
    }
  }

  public static class SetContext extends ParserRuleContext {
    public SetContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitSet(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterSet(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitSet(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_set;
    }

    public TerminalNode RELATION_NAME() {
      return this.getToken(CoreParser.RELATION_NAME, 0);
    }

    public List<TupleContext> tuple() {
      return this.getRuleContexts(TupleContext.class);
    }

    public TupleContext tuple(int i) {
      return this.getRuleContext(TupleContext.class, i);
    }
  }

  public static class SpecificationContext extends ParserRuleContext {
    public SpecificationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitSpecification(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterSpecification(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitSpecification(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_specification;
    }

    public List<SentenceContext> sentence() {
      return this.getRuleContexts(SentenceContext.class);
    }

    public SentenceContext sentence(int i) {
      return this.getRuleContext(SentenceContext.class, i);
    }

    public List<SetContext> set() {
      return this.getRuleContexts(SetContext.class);
    }

    public SetContext set(int i) {
      return this.getRuleContext(SetContext.class, i);
    }
  }

  public static class TupleContext extends ParserRuleContext {
    public TupleContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitTuple(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterTuple(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitTuple(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_tuple;
    }

    public List<TerminalNode> IDENTIFIER() {
      return this.getTokens(CoreParser.IDENTIFIER);
    }

    public TerminalNode IDENTIFIER(int i) {
      return this.getToken(CoreParser.IDENTIFIER, i);
    }
  }

  static {
    RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;

  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();

  public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7,
      T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15,
      T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, ALL = 21, NO = 22, LONE = 23,
      SOME = 24, ONE = 25, IDENTIFIER = 26, RELATION_NAME = 27, SINGLELINE_COMMENT = 28,
      MULTILINE_COMMENT = 29, WS = 30;
  public static final int RULE_specification = 0, RULE_set = 1, RULE_tuple = 2, RULE_sentence = 3,
      RULE_expr = 4, RULE_quantifer = 5;

  public static final String[] ruleNames =
      {"specification", "set", "tuple", "sentence", "expr", "quantifer"};

  private static final String[] _LITERAL_NAMES = {null, "'Model:'", "'Sentences:'", "'='", "'{'",
      "','", "'}'", "';'", "'('", "')'", "'!'", "'not'", "'&&'", "'and'", "'||'", "'or'",
      "'implies'", "'->'", "'<->'", "'iff'", "'|'", "'all'", "'no'", "'lone'", "'some'", "'one'"};

  private static final String[] _SYMBOLIC_NAMES =
      {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
          null, null, null, null, null, null, "ALL", "NO", "LONE", "SOME", "ONE", "IDENTIFIER",
          "RELATION_NAME", "SINGLELINE_COMMENT", "MULTILINE_COMMENT", "WS"};

  public static final Vocabulary VOCABULARY =
      new VocabularyImpl(CoreParser._LITERAL_NAMES, CoreParser._SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;

  static {
    tokenNames = new String[CoreParser._SYMBOLIC_NAMES.length];
    for (int i = 0; i < CoreParser.tokenNames.length; i++) {
      CoreParser.tokenNames[i] = CoreParser.VOCABULARY.getLiteralName(i);
      if (CoreParser.tokenNames[i] == null) {
        CoreParser.tokenNames[i] = CoreParser.VOCABULARY.getSymbolicName(i);
      }

      if (CoreParser.tokenNames[i] == null) {
        CoreParser.tokenNames[i] = "<INVALID>";
      }
    }
  }

  public static final String _serializedATN =
      "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 o\4\2\t\2\4\3\t\3"
          + "\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\6\2\21\n\2\r\2\16\2\22\3\2\3"
          + "\2\6\2\27\n\2\r\2\16\2\30\3\3\3\3\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13"
          + "\3\5\3&\n\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4/\n\4\f\4\16\4\62\13\4\3\4"
          + "\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"
          + "\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\6\5\6N\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3"
          + "\6\3\6\3\6\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\3\7\3\7\3\7\3\7\5\7e\n"
          + "\7\3\7\7\7h\n\7\f\7\16\7k\13\7\3\7\3\7\3\7\2\3\n\b\2\4\6\b\n\f\2\b\3\2"
          + "\f\r\3\2\16\17\3\2\20\21\3\2\22\23\3\2\24\25\3\2\27\33w\2\16\3\2\2\2\4"
          + "\32\3\2\2\2\6*\3\2\2\2\b\65\3\2\2\2\nM\3\2\2\2\f`\3\2\2\2\16\20\7\3\2"
          + "\2\17\21\5\4\3\2\20\17\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2"
          + "\2\23\24\3\2\2\2\24\26\7\4\2\2\25\27\5\b\5\2\26\25\3\2\2\2\27\30\3\2\2"
          + "\2\30\26\3\2\2\2\30\31\3\2\2\2\31\3\3\2\2\2\32\33\7\35\2\2\33\34\7\5\2"
          + "\2\34%\7\6\2\2\35\"\5\6\4\2\36\37\7\7\2\2\37!\5\6\4\2 \36\3\2\2\2!$\3"
          + "\2\2\2\" \3\2\2\2\"#\3\2\2\2#&\3\2\2\2$\"\3\2\2\2%\35\3\2\2\2%&\3\2\2"
          + "\2&\'\3\2\2\2\'(\7\b\2\2()\7\t\2\2)\5\3\2\2\2*+\7\n\2\2+\60\7\34\2\2,"
          + "-\7\7\2\2-/\7\34\2\2.,\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61"
          + "\63\3\2\2\2\62\60\3\2\2\2\63\64\7\13\2\2\64\7\3\2\2\2\65\66\5\n\6\2\66"
          + "\67\7\t\2\2\67\t\3\2\2\289\b\6\1\29:\t\2\2\2:N\5\n\6\n;<\5\f\7\2<=\5\n"
          + "\6\5=N\3\2\2\2>?\7\n\2\2?@\5\n\6\2@A\7\13\2\2AN\3\2\2\2BC\7\35\2\2CD\7"
          + "\n\2\2DI\7\34\2\2EF\7\7\2\2FH\7\34\2\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2I"
          + "J\3\2\2\2JL\3\2\2\2KI\3\2\2\2LN\7\13\2\2M8\3\2\2\2M;\3\2\2\2M>\3\2\2\2"
          + "MB\3\2\2\2N]\3\2\2\2OP\f\t\2\2PQ\t\3\2\2Q\\\5\n\6\nRS\f\b\2\2ST\t\4\2"
          + "\2T\\\5\n\6\tUV\f\7\2\2VW\t\5\2\2W\\\5\n\6\7XY\f\6\2\2YZ\t\6\2\2Z\\\5"
          + "\n\6\6[O\3\2\2\2[R\3\2\2\2[U\3\2\2\2[X\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^"
          + "\3\2\2\2^\13\3\2\2\2_]\3\2\2\2`a\t\7\2\2ai\7\34\2\2bd\7\7\2\2ce\t\7\2"
          + "\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fh\7\34\2\2gb\3\2\2\2hk\3\2\2\2ig\3\2"
          + "\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2lm\7\26\2\2m\r\3\2\2\2\r\22\30\"%\60" + "IM[]di";

  public static final ATN _ATN =
      new ATNDeserializer().deserialize(CoreParser._serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[CoreParser._ATN.getNumberOfDecisions()];
    for (int i = 0; i < CoreParser._ATN.getNumberOfDecisions(); i++) {
      CoreParser._decisionToDFA[i] = new DFA(CoreParser._ATN.getDecisionState(i), i);
    }
  }

  public CoreParser(TokenStream input) {
    super(input);
    this._interp = new ParserATNSimulator(this, CoreParser._ATN, CoreParser._decisionToDFA,
        CoreParser._sharedContextCache);
  }

  public final ExprContext expr() throws RecognitionException {
    return this.expr(0);
  }

  private ExprContext expr(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = this._ctx;
    int _parentState = this.getState();
    ExprContext _localctx = new ExprContext(this._ctx, _parentState);
    ExprContext _prevctx = _localctx;
    int _startState = 8;
    this.enterRecursionRule(_localctx, 8, CoreParser.RULE_expr, _p);
    int _la;
    try {
      int _alt;
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(75);
        switch (this._input.LA(1)) {
          case T__9:
          case T__10: {
            _localctx = new NegationContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;

            this.setState(55);
            ((NegationContext) _localctx).op = this._input.LT(1);
            _la = this._input.LA(1);
            if (!(_la == CoreParser.T__9 || _la == CoreParser.T__10)) {
              ((NegationContext) _localctx).op = this._errHandler.recoverInline(this);
            } else {
              this.consume();
            }
            this.setState(56);
            this.expr(8);
          }
            break;
          case ALL:
          case NO:
          case LONE:
          case SOME:
          case ONE: {
            _localctx = new QuantificationContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(57);
            this.quantifer();
            this.setState(58);
            this.expr(3);
          }
            break;
          case T__7: {
            _localctx = new ParenthesesContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(60);
            this.match(CoreParser.T__7);
            this.setState(61);
            this.expr(0);
            this.setState(62);
            this.match(CoreParser.T__8);
          }
            break;
          case RELATION_NAME: {
            _localctx = new RelationContext(_localctx);
            this._ctx = _localctx;
            _prevctx = _localctx;
            this.setState(64);
            this.match(CoreParser.RELATION_NAME);
            this.setState(65);
            this.match(CoreParser.T__7);
            this.setState(66);
            this.match(CoreParser.IDENTIFIER);
            this.setState(71);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while (_la == CoreParser.T__4) {
              {
                {
                  this.setState(67);
                  this.match(CoreParser.T__4);
                  this.setState(68);
                  this.match(CoreParser.IDENTIFIER);
                }
              }
              this.setState(73);
              this._errHandler.sync(this);
              _la = this._input.LA(1);
            }
            this.setState(74);
            this.match(CoreParser.T__8);
          }
            break;
          default:
            throw new NoViableAltException(this);
        }
        this._ctx.stop = this._input.LT(-1);
        this.setState(91);
        this._errHandler.sync(this);
        _alt = this.getInterpreter().adaptivePredict(this._input, 8, this._ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (this._parseListeners != null) {
              this.triggerExitRuleEvent();
            }
            _prevctx = _localctx;
            {
              this.setState(89);
              switch (this.getInterpreter().adaptivePredict(this._input, 7, this._ctx)) {
                case 1: {
                  _localctx = new ConjunctionContext(new ExprContext(_parentctx, _parentState));
                  ((ConjunctionContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, CoreParser.RULE_expr);
                  this.setState(77);
                  if (!this.precpred(this._ctx, 7)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                  }
                  this.setState(78);
                  ((ConjunctionContext) _localctx).op = this._input.LT(1);
                  _la = this._input.LA(1);
                  if (!(_la == CoreParser.T__11 || _la == CoreParser.T__12)) {
                    ((ConjunctionContext) _localctx).op = this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(79);
                  ((ConjunctionContext) _localctx).right = this.expr(8);
                }
                  break;
                case 2: {
                  _localctx = new DisjunctionContext(new ExprContext(_parentctx, _parentState));
                  ((DisjunctionContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, CoreParser.RULE_expr);
                  this.setState(80);
                  if (!this.precpred(this._ctx, 6)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                  }
                  this.setState(81);
                  ((DisjunctionContext) _localctx).op = this._input.LT(1);
                  _la = this._input.LA(1);
                  if (!(_la == CoreParser.T__13 || _la == CoreParser.T__14)) {
                    ((DisjunctionContext) _localctx).op = this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(82);
                  ((DisjunctionContext) _localctx).right = this.expr(7);
                }
                  break;
                case 3: {
                  _localctx = new ImplicationContext(new ExprContext(_parentctx, _parentState));
                  ((ImplicationContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, CoreParser.RULE_expr);
                  this.setState(83);
                  if (!this.precpred(this._ctx, 5)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                  }
                  this.setState(84);
                  ((ImplicationContext) _localctx).op = this._input.LT(1);
                  _la = this._input.LA(1);
                  if (!(_la == CoreParser.T__15 || _la == CoreParser.T__16)) {
                    ((ImplicationContext) _localctx).op = this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(85);
                  ((ImplicationContext) _localctx).right = this.expr(5);
                }
                  break;
                case 4: {
                  _localctx = new EquivalanceContext(new ExprContext(_parentctx, _parentState));
                  ((EquivalanceContext) _localctx).left = _prevctx;
                  this.pushNewRecursionContext(_localctx, _startState, CoreParser.RULE_expr);
                  this.setState(86);
                  if (!this.precpred(this._ctx, 4)) {
                    throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                  }
                  this.setState(87);
                  ((EquivalanceContext) _localctx).op = this._input.LT(1);
                  _la = this._input.LA(1);
                  if (!(_la == CoreParser.T__17 || _la == CoreParser.T__18)) {
                    ((EquivalanceContext) _localctx).op = this._errHandler.recoverInline(this);
                  } else {
                    this.consume();
                  }
                  this.setState(88);
                  ((EquivalanceContext) _localctx).right = this.expr(4);
                }
                  break;
              }
            }
          }
          this.setState(93);
          this._errHandler.sync(this);
          _alt = this.getInterpreter().adaptivePredict(this._input, 8, this._ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  private boolean expr_sempred(ExprContext _localctx, int predIndex) {
    switch (predIndex) {
      case 0:
        return this.precpred(this._ctx, 7);
      case 1:
        return this.precpred(this._ctx, 6);
      case 2:
        return this.precpred(this._ctx, 5);
      case 3:
        return this.precpred(this._ctx, 4);
    }
    return true;
  }

  @Override
  public ATN getATN() {
    return CoreParser._ATN;
  }

  @Override
  public String getGrammarFileName() {
    return "Core.g4";
  }

  @Override
  public String[] getRuleNames() {
    return CoreParser.ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return CoreParser._serializedATN;
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return CoreParser.tokenNames;
  }

  @Override

  public Vocabulary getVocabulary() {
    return CoreParser.VOCABULARY;
  }

  public final QuantiferContext quantifer() throws RecognitionException {
    QuantiferContext _localctx = new QuantiferContext(this._ctx, this.getState());
    this.enterRule(_localctx, 10, CoreParser.RULE_quantifer);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        {
          this.setState(94);
          _localctx.op = this._input.LT(1);
          _la = this._input.LA(1);
          if (!((_la & ~0x3f) == 0 && (1L << _la & (1L << CoreParser.ALL | 1L << CoreParser.NO
              | 1L << CoreParser.LONE | 1L << CoreParser.SOME | 1L << CoreParser.ONE)) != 0)) {
            _localctx.op = this._errHandler.recoverInline(this);
          } else {
            this.consume();
          }
          this.setState(95);
          this.match(CoreParser.IDENTIFIER);
          this.setState(103);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
          while (_la == CoreParser.T__4) {
            {
              {
                this.setState(96);
                this.match(CoreParser.T__4);
                this.setState(98);
                _la = this._input.LA(1);
                if ((_la & ~0x3f) == 0 && (1L << _la & (1L << CoreParser.ALL | 1L << CoreParser.NO
                    | 1L << CoreParser.LONE | 1L << CoreParser.SOME | 1L << CoreParser.ONE)) != 0) {
                  {
                    this.setState(97);
                    _localctx.op = this._input.LT(1);
                    _la = this._input.LA(1);
                    if (!((_la & ~0x3f) == 0 && (1L << _la
                        & (1L << CoreParser.ALL | 1L << CoreParser.NO | 1L << CoreParser.LONE
                            | 1L << CoreParser.SOME | 1L << CoreParser.ONE)) != 0)) {
                      _localctx.op = this._errHandler.recoverInline(this);
                    } else {
                      this.consume();
                    }
                  }
                }

                this.setState(100);
                this.match(CoreParser.IDENTIFIER);
              }
            }
            this.setState(105);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
          }
          this.setState(106);
          this.match(CoreParser.T__19);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  @Override
  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
      case 4:
        return this.expr_sempred((ExprContext) _localctx, predIndex);
    }
    return true;
  }

  public final SentenceContext sentence() throws RecognitionException {
    SentenceContext _localctx = new SentenceContext(this._ctx, this.getState());
    this.enterRule(_localctx, 6, CoreParser.RULE_sentence);
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(51);
        this.expr(0);
        this.setState(52);
        this.match(CoreParser.T__6);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final SetContext set() throws RecognitionException {
    SetContext _localctx = new SetContext(this._ctx, this.getState());
    this.enterRule(_localctx, 2, CoreParser.RULE_set);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(24);
        this.match(CoreParser.RELATION_NAME);
        this.setState(25);
        this.match(CoreParser.T__2);
        this.setState(26);
        this.match(CoreParser.T__3);
        this.setState(35);
        _la = this._input.LA(1);
        if (_la == CoreParser.T__7) {
          {
            this.setState(27);
            this.tuple();
            this.setState(32);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while (_la == CoreParser.T__4) {
              {
                {
                  this.setState(28);
                  this.match(CoreParser.T__4);
                  this.setState(29);
                  this.tuple();
                }
              }
              this.setState(34);
              this._errHandler.sync(this);
              _la = this._input.LA(1);
            }
          }
        }

        this.setState(37);
        this.match(CoreParser.T__5);
        this.setState(38);
        this.match(CoreParser.T__6);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final SpecificationContext specification() throws RecognitionException {
    SpecificationContext _localctx = new SpecificationContext(this._ctx, this.getState());
    this.enterRule(_localctx, 0, CoreParser.RULE_specification);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(12);
        this.match(CoreParser.T__0);
        this.setState(14);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
          {
            {
              this.setState(13);
              this.set();
            }
          }
          this.setState(16);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        } while (_la == CoreParser.RELATION_NAME);
        this.setState(18);
        this.match(CoreParser.T__1);
        this.setState(20);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
          {
            {
              this.setState(19);
              this.sentence();
            }
          }
          this.setState(22);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        } while ((_la & ~0x3f) == 0 && (1L << _la & (1L << CoreParser.T__7 | 1L << CoreParser.T__9
            | 1L << CoreParser.T__10 | 1L << CoreParser.ALL | 1L << CoreParser.NO
            | 1L << CoreParser.LONE | 1L << CoreParser.SOME | 1L << CoreParser.ONE
            | 1L << CoreParser.RELATION_NAME)) != 0);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }

  public final TupleContext tuple() throws RecognitionException {
    TupleContext _localctx = new TupleContext(this._ctx, this.getState());
    this.enterRule(_localctx, 4, CoreParser.RULE_tuple);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(40);
        this.match(CoreParser.T__7);
        this.setState(41);
        this.match(CoreParser.IDENTIFIER);
        this.setState(46);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while (_la == CoreParser.T__4) {
          {
            {
              this.setState(42);
              this.match(CoreParser.T__4);
              this.setState(43);
              this.match(CoreParser.IDENTIFIER);
            }
          }
          this.setState(48);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        }
        this.setState(49);
        this.match(CoreParser.T__8);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      this._errHandler.reportError(this, re);
      this._errHandler.recover(this, re);
    } finally {
      this.exitRule();
    }
    return _localctx;
  }
}
