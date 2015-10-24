// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\Core.g4 by ANTLR 4.5.1
package unit.verifier.core;

import java.util.List;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
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
  public static class BinaryOpContext extends ParserRuleContext {
    public BinaryOpContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitBinaryOp(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterBinaryOp(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitBinaryOp(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_binaryOp;
    }
  }

  public static class ExprContext extends ParserRuleContext {
    public ExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitExpr(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    public BinaryOpContext binaryOp() {
      return this.getRuleContext(BinaryOpContext.class, 0);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterExpr(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitExpr(this);
      }
    }

    public List<ExprContext> expr() {
      return this.getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return this.getRuleContext(ExprContext.class, i);
    }

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_expr;
    }

    public RelationContext relation() {
      return this.getRuleContext(RelationContext.class, 0);
    }

    public UnaryOpContext unaryOp() {
      return this.getRuleContext(UnaryOpContext.class, 0);
    }
  }
  public static class QuantificationContext extends ParserRuleContext {
    public QuantificationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
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

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_quantification;
    }
  }
  public static class RelationContext extends ParserRuleContext {
    public RelationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
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

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_relation;
    }

    public TerminalNode RELATION_NAME() {
      return this.getToken(CoreParser.RELATION_NAME, 0);
    }

    public TupleContext tuple() {
      return this.getRuleContext(TupleContext.class, 0);
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

    public List<TerminalNode> CONSTANT() {
      return this.getTokens(CoreParser.CONSTANT);
    }

    public TerminalNode CONSTANT(int i) {
      return this.getToken(CoreParser.CONSTANT, i);
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

    public List<QuantificationContext> quantification() {
      return this.getRuleContexts(QuantificationContext.class);
    }

    public QuantificationContext quantification(int i) {
      return this.getRuleContext(QuantificationContext.class, i);
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

    public List<TerminalNode> CONSTANT() {
      return this.getTokens(CoreParser.CONSTANT);
    }

    public TerminalNode CONSTANT(int i) {
      return this.getToken(CoreParser.CONSTANT, i);
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
  }
  public static class UnaryOpContext extends ParserRuleContext {
    public UnaryOpContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor) {
        return ((CoreVisitor<? extends T>) visitor).visitUnaryOp(this);
      } else {
        return visitor.visitChildren(this);
      }
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).enterUnaryOp(this);
      }
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener) {
        ((CoreListener) listener).exitUnaryOp(this);
      }
    }

    @Override
    public int getRuleIndex() {
      return CoreParser.RULE_unaryOp;
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
      T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, CONSTANT = 27, RELATION_NAME = 28,
      LINE_COMMENT = 29, MULTILINE_COMMENT = 30, WS = 31;

  public static final int RULE_specification = 0, RULE_set = 1, RULE_tuple = 2, RULE_sentence = 3,
      RULE_expr = 4, RULE_relation = 5, RULE_quantification = 6, RULE_binaryOp = 7,
      RULE_unaryOp = 8;

  public static final String[] ruleNames = {"specification", "set", "tuple", "sentence", "expr",
      "relation", "quantification", "binaryOp", "unaryOp"};

  private static final String[] _LITERAL_NAMES =
      {null, "'Model:'", "'Sentences:'", "'='", "'{'", "','", "'}'", "';'", "'('", "')'", "'|'",
          "'all'", "'no'", "'lone'", "'some'", "'one'", "'||'", "'or'", "'&&'", "'and'", "'<=>'",
          "'iff'", "'=>'", "'implies'", "'in'", "'!'", "'not'"};

  private static final String[] _SYMBOLIC_NAMES =
      {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
          null, null, null, null, null, null, null, null, null, null, null, null, "CONSTANT",
          "RELATION_NAME", "LINE_COMMENT", "MULTILINE_COMMENT", "WS"};

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
      "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!l\4\2\t\2\4\3\t\3"
          + "\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\6\2\27"
          + "\n\2\r\2\16\2\30\3\2\3\2\6\2\35\n\2\r\2\16\2\36\3\3\3\3\3\3\3\3\3\3\3"
          + "\3\7\3\'\n\3\f\3\16\3*\13\3\5\3,\n\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\65"
          + "\n\4\f\4\16\48\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5@\n\5\3\5\7\5C\n\5\f\5"
          + "\16\5F\13\5\3\5\3\5\5\5J\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"
          + "\6\3\6\5\6X\n\6\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\3\7\3\7\3\7\3"
          + "\b\3\b\3\t\3\t\3\n\3\n\3\n\2\3\n\13\2\4\6\b\n\f\16\20\22\2\5\3\2\r\21"
          + "\4\2\5\5\22\32\3\2\33\34m\2\24\3\2\2\2\4 \3\2\2\2\6\60\3\2\2\2\bI\3\2"
          + "\2\2\nW\3\2\2\2\fb\3\2\2\2\16e\3\2\2\2\20g\3\2\2\2\22i\3\2\2\2\24\26\7"
          + "\3\2\2\25\27\5\4\3\2\26\25\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3"
          + "\2\2\2\31\32\3\2\2\2\32\34\7\4\2\2\33\35\5\b\5\2\34\33\3\2\2\2\35\36\3"
          + "\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\3\3\2\2\2 !\7\36\2\2!\"\7\5\2\2"
          + "\"+\7\6\2\2#(\5\6\4\2$%\7\7\2\2%\'\5\6\4\2&$\3\2\2\2\'*\3\2\2\2(&\3\2"
          + "\2\2()\3\2\2\2),\3\2\2\2*(\3\2\2\2+#\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\b"
          + "\2\2./\7\t\2\2/\5\3\2\2\2\60\61\7\n\2\2\61\66\7\35\2\2\62\63\7\7\2\2\63"
          + "\65\7\35\2\2\64\62\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67"
          + "9\3\2\2\28\66\3\2\2\29:\7\13\2\2:\7\3\2\2\2;<\5\16\b\2<D\7\35\2\2=?\7"
          + "\7\2\2>@\5\16\b\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AC\7\35\2\2B=\3\2\2\2C"
          + "F\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\f\2\2HJ\3\2\2\2"
          + "I;\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\5\n\6\2LM\7\t\2\2M\t\3\2\2\2NO\b\6\1"
          + "\2OP\5\22\n\2PQ\5\n\6\5QX\3\2\2\2RS\7\n\2\2ST\5\n\6\2TU\7\13\2\2UX\3\2"
          + "\2\2VX\5\f\7\2WN\3\2\2\2WR\3\2\2\2WV\3\2\2\2X_\3\2\2\2YZ\f\6\2\2Z[\5\20"
          + "\t\2[\\\5\n\6\7\\^\3\2\2\2]Y\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\13"
          + "\3\2\2\2a_\3\2\2\2bc\7\36\2\2cd\5\6\4\2d\r\3\2\2\2ef\t\2\2\2f\17\3\2\2"
          + "\2gh\t\3\2\2h\21\3\2\2\2ij\t\4\2\2j\23\3\2\2\2\f\30\36(+\66?DIW_";

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

  public final BinaryOpContext binaryOp() throws RecognitionException {
    BinaryOpContext _localctx = new BinaryOpContext(this._ctx, this.getState());
    this.enterRule(_localctx, 14, CoreParser.RULE_binaryOp);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(101);
        _la = this._input.LA(1);
        if (!((_la & ~0x3f) == 0 && (1L << _la & (1L << CoreParser.T__2 | 1L << CoreParser.T__15
            | 1L << CoreParser.T__16 | 1L << CoreParser.T__17 | 1L << CoreParser.T__18
            | 1L << CoreParser.T__19 | 1L << CoreParser.T__20 | 1L << CoreParser.T__21
            | 1L << CoreParser.T__22 | 1L << CoreParser.T__23)) != 0)) {
          this._errHandler.recoverInline(this);
        } else {
          this.consume();
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
    try {
      int _alt;
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(85);
        switch (this._input.LA(1)) {
          case T__24:
          case T__25: {
            this.setState(77);
            this.unaryOp();
            this.setState(78);
            this.expr(3);
          }
            break;
          case T__7: {
            this.setState(80);
            this.match(CoreParser.T__7);
            this.setState(81);
            this.expr(0);
            this.setState(82);
            this.match(CoreParser.T__8);
          }
            break;
          case RELATION_NAME: {
            this.setState(84);
            this.relation();
          }
            break;
          default:
            throw new NoViableAltException(this);
        }
        this._ctx.stop = this._input.LT(-1);
        this.setState(93);
        this._errHandler.sync(this);
        _alt = this.getInterpreter().adaptivePredict(this._input, 9, this._ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (this._parseListeners != null) {
              this.triggerExitRuleEvent();
            }
            _prevctx = _localctx;
            {
              {
                _localctx = new ExprContext(_parentctx, _parentState);
                this.pushNewRecursionContext(_localctx, _startState, CoreParser.RULE_expr);
                this.setState(87);
                if (!this.precpred(this._ctx, 4)) {
                  throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                }
                this.setState(88);
                this.binaryOp();
                this.setState(89);
                this.expr(5);
              }
            }
          }
          this.setState(95);
          this._errHandler.sync(this);
          _alt = this.getInterpreter().adaptivePredict(this._input, 9, this._ctx);
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

  public final QuantificationContext quantification() throws RecognitionException {
    QuantificationContext _localctx = new QuantificationContext(this._ctx, this.getState());
    this.enterRule(_localctx, 12, CoreParser.RULE_quantification);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(99);
        _la = this._input.LA(1);
        if (!((_la & ~0x3f) == 0 && (1L << _la & (1L << CoreParser.T__10 | 1L << CoreParser.T__11
            | 1L << CoreParser.T__12 | 1L << CoreParser.T__13 | 1L << CoreParser.T__14)) != 0)) {
          this._errHandler.recoverInline(this);
        } else {
          this.consume();
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

  public final RelationContext relation() throws RecognitionException {
    RelationContext _localctx = new RelationContext(this._ctx, this.getState());
    this.enterRule(_localctx, 10, CoreParser.RULE_relation);
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(96);
        this.match(CoreParser.RELATION_NAME);
        this.setState(97);
        this.tuple();
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
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(71);
        _la = this._input.LA(1);
        if ((_la & ~0x3f) == 0 && (1L << _la & (1L << CoreParser.T__10 | 1L << CoreParser.T__11
            | 1L << CoreParser.T__12 | 1L << CoreParser.T__13 | 1L << CoreParser.T__14)) != 0) {
          {
            this.setState(57);
            this.quantification();
            this.setState(58);
            this.match(CoreParser.CONSTANT);
            this.setState(66);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while (_la == CoreParser.T__4) {
              {
                {
                  this.setState(59);
                  this.match(CoreParser.T__4);
                  this.setState(61);
                  _la = this._input.LA(1);
                  if ((_la & ~0x3f) == 0 && (1L << _la
                      & (1L << CoreParser.T__10 | 1L << CoreParser.T__11 | 1L << CoreParser.T__12
                          | 1L << CoreParser.T__13 | 1L << CoreParser.T__14)) != 0) {
                    {
                      this.setState(60);
                      this.quantification();
                    }
                  }

                  this.setState(63);
                  this.match(CoreParser.CONSTANT);
                }
              }
              this.setState(68);
              this._errHandler.sync(this);
              _la = this._input.LA(1);
            }
            this.setState(69);
            this.match(CoreParser.T__9);
          }
        }

        this.setState(73);
        this.expr(0);
        this.setState(74);
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
        this.setState(30);
        this.match(CoreParser.RELATION_NAME);
        this.setState(31);
        this.match(CoreParser.T__2);
        this.setState(32);
        this.match(CoreParser.T__3);
        this.setState(41);
        _la = this._input.LA(1);
        if (_la == CoreParser.T__7) {
          {
            this.setState(33);
            this.tuple();
            this.setState(38);
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while (_la == CoreParser.T__4) {
              {
                {
                  this.setState(34);
                  this.match(CoreParser.T__4);
                  this.setState(35);
                  this.tuple();
                }
              }
              this.setState(40);
              this._errHandler.sync(this);
              _la = this._input.LA(1);
            }
          }
        }

        this.setState(43);
        this.match(CoreParser.T__5);
        this.setState(44);
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
        this.setState(18);
        this.match(CoreParser.T__0);
        this.setState(20);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
          {
            {
              this.setState(19);
              this.set();
            }
          }
          this.setState(22);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        } while (_la == CoreParser.RELATION_NAME);
        this.setState(24);
        this.match(CoreParser.T__1);
        this.setState(26);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
          {
            {
              this.setState(25);
              this.sentence();
            }
          }
          this.setState(28);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        } while ((_la & ~0x3f) == 0 && (1L << _la & (1L << CoreParser.T__7 | 1L << CoreParser.T__10
            | 1L << CoreParser.T__11 | 1L << CoreParser.T__12 | 1L << CoreParser.T__13
            | 1L << CoreParser.T__14 | 1L << CoreParser.T__24 | 1L << CoreParser.T__25
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
        this.setState(46);
        this.match(CoreParser.T__7);
        this.setState(47);
        this.match(CoreParser.CONSTANT);
        this.setState(52);
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while (_la == CoreParser.T__4) {
          {
            {
              this.setState(48);
              this.match(CoreParser.T__4);
              this.setState(49);
              this.match(CoreParser.CONSTANT);
            }
          }
          this.setState(54);
          this._errHandler.sync(this);
          _la = this._input.LA(1);
        }
        this.setState(55);
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

  public final UnaryOpContext unaryOp() throws RecognitionException {
    UnaryOpContext _localctx = new UnaryOpContext(this._ctx, this.getState());
    this.enterRule(_localctx, 16, CoreParser.RULE_unaryOp);
    int _la;
    try {
      this.enterOuterAlt(_localctx, 1);
      {
        this.setState(103);
        _la = this._input.LA(1);
        if (!(_la == CoreParser.T__24 || _la == CoreParser.T__25)) {
          this._errHandler.recoverInline(this);
        } else {
          this.consume();
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
}
