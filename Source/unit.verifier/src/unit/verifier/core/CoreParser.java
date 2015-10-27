package unit.verifier.core;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoreParser extends Parser {
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
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;

  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override

  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }

  @Override
  public String getGrammarFileName() {
    return "Core.g4";
  }

  @Override
  public String[] getRuleNames() {
    return ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return _serializedATN;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public CoreParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  public static class SpecificationContext extends ParserRuleContext {
    public List<SetContext> set() {
      return getRuleContexts(SetContext.class);
    }

    public SetContext set(int i) {
      return getRuleContext(SetContext.class, i);
    }

    public List<SentenceContext> sentence() {
      return getRuleContexts(SentenceContext.class);
    }

    public SentenceContext sentence(int i) {
      return getRuleContext(SentenceContext.class, i);
    }

    public SpecificationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_specification;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterSpecification(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitSpecification(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitSpecification(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final SpecificationContext specification() throws RecognitionException {
    SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_specification);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(12);
        match(T__0);
        setState(14);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(13);
              set();
            }
          }
          setState(16);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (_la == RELATION_NAME);
        setState(18);
        match(T__1);
        setState(20);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(19);
              sentence();
            }
          }
          setState(22);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la)
            & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << ALL) | (1L << NO) | (1L << LONE)
                | (1L << SOME) | (1L << ONE) | (1L << RELATION_NAME))) != 0));
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class SetContext extends ParserRuleContext {
    public TerminalNode RELATION_NAME() {
      return getToken(CoreParser.RELATION_NAME, 0);
    }

    public List<TupleContext> tuple() {
      return getRuleContexts(TupleContext.class);
    }

    public TupleContext tuple(int i) {
      return getRuleContext(TupleContext.class, i);
    }

    public SetContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_set;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterSet(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitSet(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitSet(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final SetContext set() throws RecognitionException {
    SetContext _localctx = new SetContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_set);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(24);
        match(RELATION_NAME);
        setState(25);
        match(T__2);
        setState(26);
        match(T__3);
        setState(35);
        _la = _input.LA(1);
        if (_la == T__7) {
          {
            setState(27);
            tuple();
            setState(32);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == T__4) {
              {
                {
                  setState(28);
                  match(T__4);
                  setState(29);
                  tuple();
                }
              }
              setState(34);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(37);
        match(T__5);
        setState(38);
        match(T__6);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class TupleContext extends ParserRuleContext {
    public List<TerminalNode> IDENTIFIER() {
      return getTokens(CoreParser.IDENTIFIER);
    }

    public TerminalNode IDENTIFIER(int i) {
      return getToken(CoreParser.IDENTIFIER, i);
    }

    public TupleContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_tuple;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterTuple(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitTuple(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitTuple(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final TupleContext tuple() throws RecognitionException {
    TupleContext _localctx = new TupleContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_tuple);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(40);
        match(T__7);
        setState(41);
        match(IDENTIFIER);
        setState(46);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == T__4) {
          {
            {
              setState(42);
              match(T__4);
              setState(43);
              match(IDENTIFIER);
            }
          }
          setState(48);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(49);
        match(T__8);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class SentenceContext extends ParserRuleContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public SentenceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_sentence;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterSentence(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitSentence(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitSentence(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final SentenceContext sentence() throws RecognitionException {
    SentenceContext _localctx = new SentenceContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_sentence);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(51);
        expr(0);
        setState(52);
        match(T__6);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ExprContext extends ParserRuleContext {
    public ExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expr;
    }

    public ExprContext() {}

    public void copyFrom(ExprContext ctx) {
      super.copyFrom(ctx);
    }
  }
  public static class ParenthesesContext extends ExprContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public ParenthesesContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterParentheses(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitParentheses(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitParentheses(this);
      else
        return visitor.visitChildren(this);
    }
  }
  public static class NegationContext extends ExprContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public NegationContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterNegation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitNegation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitNegation(this);
      else
        return visitor.visitChildren(this);
    }
  }
  public static class QuantificationContext extends ExprContext {
    public QuantiferContext quantifer() {
      return getRuleContext(QuantiferContext.class, 0);
    }

    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public QuantificationContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterQuantification(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitQuantification(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitQuantification(this);
      else
        return visitor.visitChildren(this);
    }
  }
  public static class ConjunctionContext extends ExprContext {
    public ExprContext left;
    public ExprContext right;

    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class, i);
    }

    public ConjunctionContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterConjunction(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitConjunction(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitConjunction(this);
      else
        return visitor.visitChildren(this);
    }
  }
  public static class DisjunctionContext extends ExprContext {
    public ExprContext left;
    public ExprContext right;

    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class, i);
    }

    public DisjunctionContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterDisjunction(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitDisjunction(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitDisjunction(this);
      else
        return visitor.visitChildren(this);
    }
  }
  public static class ImplicationContext extends ExprContext {
    public ExprContext left;
    public ExprContext right;

    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class, i);
    }

    public ImplicationContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterImplication(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitImplication(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitImplication(this);
      else
        return visitor.visitChildren(this);
    }
  }
  public static class EquivalanceContext extends ExprContext {
    public ExprContext left;
    public ExprContext right;

    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class, i);
    }

    public EquivalanceContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterEquivalance(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitEquivalance(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitEquivalance(this);
      else
        return visitor.visitChildren(this);
    }
  }
  public static class RelationContext extends ExprContext {
    public TerminalNode RELATION_NAME() {
      return getToken(CoreParser.RELATION_NAME, 0);
    }

    public List<TerminalNode> IDENTIFIER() {
      return getTokens(CoreParser.IDENTIFIER);
    }

    public TerminalNode IDENTIFIER(int i) {
      return getToken(CoreParser.IDENTIFIER, i);
    }

    public RelationContext(ExprContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterRelation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitRelation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitRelation(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final ExprContext expr() throws RecognitionException {
    return expr(0);
  }

  private ExprContext expr(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    ExprContext _localctx = new ExprContext(_ctx, _parentState);
    ExprContext _prevctx = _localctx;
    int _startState = 8;
    enterRecursionRule(_localctx, 8, RULE_expr, _p);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(75);
        switch (_input.LA(1)) {
          case T__9:
          case T__10: {
            _localctx = new NegationContext(_localctx);
            _ctx = _localctx;
            _prevctx = _localctx;

            setState(55);
            _la = _input.LA(1);
            if (!(_la == T__9 || _la == T__10)) {
              _errHandler.recoverInline(this);
            } else {
              consume();
            }
            setState(56);
            expr(8);
          }
            break;
          case ALL:
          case NO:
          case LONE:
          case SOME:
          case ONE: {
            _localctx = new QuantificationContext(_localctx);
            _ctx = _localctx;
            _prevctx = _localctx;
            setState(57);
            quantifer();
            setState(58);
            expr(3);
          }
            break;
          case T__7: {
            _localctx = new ParenthesesContext(_localctx);
            _ctx = _localctx;
            _prevctx = _localctx;
            setState(60);
            match(T__7);
            setState(61);
            expr(0);
            setState(62);
            match(T__8);
          }
            break;
          case RELATION_NAME: {
            _localctx = new RelationContext(_localctx);
            _ctx = _localctx;
            _prevctx = _localctx;
            setState(64);
            match(RELATION_NAME);
            setState(65);
            match(T__7);
            setState(66);
            match(IDENTIFIER);
            setState(71);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == T__4) {
              {
                {
                  setState(67);
                  match(T__4);
                  setState(68);
                  match(IDENTIFIER);
                }
              }
              setState(73);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
            setState(74);
            match(T__8);
          }
            break;
          default:
            throw new NoViableAltException(this);
        }
        _ctx.stop = _input.LT(-1);
        setState(91);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null)
              triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              setState(89);
              switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                case 1: {
                  _localctx = new ConjunctionContext(new ExprContext(_parentctx, _parentState));
                  ((ConjunctionContext) _localctx).left = _prevctx;
                  pushNewRecursionContext(_localctx, _startState, RULE_expr);
                  setState(77);
                  if (!(precpred(_ctx, 7)))
                    throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                  setState(78);
                  _la = _input.LA(1);
                  if (!(_la == T__11 || _la == T__12)) {
                    _errHandler.recoverInline(this);
                  } else {
                    consume();
                  }
                  setState(79);
                  ((ConjunctionContext) _localctx).right = expr(8);
                }
                  break;
                case 2: {
                  _localctx = new DisjunctionContext(new ExprContext(_parentctx, _parentState));
                  ((DisjunctionContext) _localctx).left = _prevctx;
                  pushNewRecursionContext(_localctx, _startState, RULE_expr);
                  setState(80);
                  if (!(precpred(_ctx, 6)))
                    throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                  setState(81);
                  _la = _input.LA(1);
                  if (!(_la == T__13 || _la == T__14)) {
                    _errHandler.recoverInline(this);
                  } else {
                    consume();
                  }
                  setState(82);
                  ((DisjunctionContext) _localctx).right = expr(7);
                }
                  break;
                case 3: {
                  _localctx = new ImplicationContext(new ExprContext(_parentctx, _parentState));
                  ((ImplicationContext) _localctx).left = _prevctx;
                  pushNewRecursionContext(_localctx, _startState, RULE_expr);
                  setState(83);
                  if (!(precpred(_ctx, 5)))
                    throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                  setState(84);
                  _la = _input.LA(1);
                  if (!(_la == T__15 || _la == T__16)) {
                    _errHandler.recoverInline(this);
                  } else {
                    consume();
                  }
                  setState(85);
                  ((ImplicationContext) _localctx).right = expr(5);
                }
                  break;
                case 4: {
                  _localctx = new EquivalanceContext(new ExprContext(_parentctx, _parentState));
                  ((EquivalanceContext) _localctx).left = _prevctx;
                  pushNewRecursionContext(_localctx, _startState, RULE_expr);
                  setState(86);
                  if (!(precpred(_ctx, 4)))
                    throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                  setState(87);
                  _la = _input.LA(1);
                  if (!(_la == T__17 || _la == T__18)) {
                    _errHandler.recoverInline(this);
                  } else {
                    consume();
                  }
                  setState(88);
                  ((EquivalanceContext) _localctx).right = expr(4);
                }
                  break;
              }
            }
          }
          setState(93);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  public static class QuantiferContext extends ParserRuleContext {
    public Token op;

    public List<TerminalNode> IDENTIFIER() {
      return getTokens(CoreParser.IDENTIFIER);
    }

    public TerminalNode IDENTIFIER(int i) {
      return getToken(CoreParser.IDENTIFIER, i);
    }

    public QuantiferContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_quantifer;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).enterQuantifer(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CoreListener)
        ((CoreListener) listener).exitQuantifer(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CoreVisitor)
        return ((CoreVisitor<? extends T>) visitor).visitQuantifer(this);
      else
        return visitor.visitChildren(this);
    }
  }

  public final QuantiferContext quantifer() throws RecognitionException {
    QuantiferContext _localctx = new QuantiferContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_quantifer);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        {
          setState(94);
          ((QuantiferContext) _localctx).op = _input.LT(1);
          _la = _input.LA(1);
          if (!((((_la) & ~0x3f) == 0 && ((1L << _la)
              & ((1L << ALL) | (1L << NO) | (1L << LONE) | (1L << SOME) | (1L << ONE))) != 0))) {
            ((QuantiferContext) _localctx).op = (Token) _errHandler.recoverInline(this);
          } else {
            consume();
          }
          setState(95);
          match(IDENTIFIER);
          setState(103);
          _errHandler.sync(this);
          _la = _input.LA(1);
          while (_la == T__4) {
            {
              {
                setState(96);
                match(T__4);
                setState(98);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << NO) | (1L << LONE)
                    | (1L << SOME) | (1L << ONE))) != 0)) {
                  {
                    setState(97);
                    ((QuantiferContext) _localctx).op = _input.LT(1);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << NO)
                        | (1L << LONE) | (1L << SOME) | (1L << ONE))) != 0))) {
                      ((QuantiferContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                    } else {
                      consume();
                    }
                  }
                }

                setState(100);
                match(IDENTIFIER);
              }
            }
            setState(105);
            _errHandler.sync(this);
            _la = _input.LA(1);
          }
          setState(106);
          match(T__19);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
      case 4:
        return expr_sempred((ExprContext) _localctx, predIndex);
    }
    return true;
  }

  private boolean expr_sempred(ExprContext _localctx, int predIndex) {
    switch (predIndex) {
      case 0:
        return precpred(_ctx, 7);
      case 1:
        return precpred(_ctx, 6);
      case 2:
        return precpred(_ctx, 5);
      case 3:
        return precpred(_ctx, 4);
    }
    return true;
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
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
