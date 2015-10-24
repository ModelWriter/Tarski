// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\Core.g4 by ANTLR 4.5.1
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, IDENTIFIER=27, RELATION_NAME=28, LINE_COMMENT=29, 
		MULTILINE_COMMENT=30, WS=31;
	public static final int
		RULE_specification = 0, RULE_set = 1, RULE_tuple = 2, RULE_sentence = 3, 
		RULE_quantification = 4, RULE_expr = 5, RULE_relation = 6, RULE_quantifier = 7, 
		RULE_binaryOp = 8, RULE_unaryOp = 9;
	public static final String[] ruleNames = {
		"specification", "set", "tuple", "sentence", "quantification", "expr", 
		"relation", "quantifier", "binaryOp", "unaryOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Model:'", "'Sentences:'", "'='", "'{'", "','", "'}'", "';'", "'('", 
		"')'", "'|'", "'all'", "'no'", "'lone'", "'some'", "'one'", "'||'", "'or'", 
		"'&&'", "'and'", "'<=>'", "'iff'", "'=>'", "'implies'", "'in'", "'!'", 
		"'not'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "IDENTIFIER", "RELATION_NAME", "LINE_COMMENT", "MULTILINE_COMMENT", 
		"WS"
	};
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
	public String getGrammarFileName() { return "Core.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CoreParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SpecificationContext extends ParserRuleContext {
		public List<SetContext> set() {
			return getRuleContexts(SetContext.class);
		}
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public SpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(T__0);
			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21);
				set();
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RELATION_NAME );
			setState(26);
			match(T__1);
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				sentence();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__24) | (1L << T__25) | (1L << RELATION_NAME))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public TerminalNode RELATION_NAME() { return getToken(CoreParser.RELATION_NAME, 0); }
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(RELATION_NAME);
			setState(33);
			match(T__2);
			setState(34);
			match(T__3);
			setState(43);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(35);
				tuple();
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(36);
					match(T__4);
					setState(37);
					tuple();
					}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(45);
			match(T__5);
			setState(46);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TupleContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(CoreParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(CoreParser.IDENTIFIER, i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__7);
			setState(49);
			match(IDENTIFIER);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(50);
				match(T__4);
				setState(51);
				match(IDENTIFIER);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			expr(0);
			setState(60);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantificationContext extends ParserRuleContext {
		public List<QuantifierContext> quantifier() {
			return getRuleContexts(QuantifierContext.class);
		}
		public QuantifierContext quantifier(int i) {
			return getRuleContext(QuantifierContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(CoreParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(CoreParser.IDENTIFIER, i);
		}
		public QuantificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterQuantification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitQuantification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitQuantification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantificationContext quantification() throws RecognitionException {
		QuantificationContext _localctx = new QuantificationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quantification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(62);
			quantifier();
			setState(63);
			match(IDENTIFIER);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(64);
				match(T__4);
				setState(66);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) {
					{
					setState(65);
					quantifier();
					}
				}

				setState(68);
				match(IDENTIFIER);
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(T__9);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public QuantificationContext quantification() {
			return getRuleContext(QuantificationContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public BinaryOpContext binaryOp() {
			return getRuleContext(BinaryOpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
				{
				setState(77);
				quantification();
				setState(78);
				expr(5);
				}
				break;
			case T__24:
			case T__25:
				{
				setState(80);
				unaryOp();
				setState(81);
				expr(3);
				}
				break;
			case T__7:
				{
				setState(83);
				match(T__7);
				setState(84);
				expr(0);
				setState(85);
				match(T__8);
				}
				break;
			case RELATION_NAME:
				{
				setState(87);
				relation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(90);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(91);
					binaryOp();
					setState(92);
					expr(5);
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public TerminalNode RELATION_NAME() { return getToken(CoreParser.RELATION_NAME, 0); }
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(RELATION_NAME);
			setState(100);
			tuple();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierContext extends ParserRuleContext {
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_quantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryOpContext extends ParserRuleContext {
		public BinaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOpContext binaryOp() throws RecognitionException {
		BinaryOpContext _localctx = new BinaryOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_binaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOpContext extends ParserRuleContext {
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoreListener ) ((CoreListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoreVisitor ) return ((CoreVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !(_la==T__24 || _la==T__25) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!o\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3\2"+
		"\3\2\6\2\31\n\2\r\2\16\2\32\3\2\3\2\6\2\37\n\2\r\2\16\2 \3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\5\3.\n\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6E"+
		"\n\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7[\n\7\3\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7d\13\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\2\3\f\f\2\4\6\b\n\f\16\20\22"+
		"\24\2\5\3\2\r\21\4\2\5\5\22\32\3\2\33\34o\2\26\3\2\2\2\4\"\3\2\2\2\6\62"+
		"\3\2\2\2\b=\3\2\2\2\n@\3\2\2\2\fZ\3\2\2\2\16e\3\2\2\2\20h\3\2\2\2\22j"+
		"\3\2\2\2\24l\3\2\2\2\26\30\7\3\2\2\27\31\5\4\3\2\30\27\3\2\2\2\31\32\3"+
		"\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\34\3\2\2\2\34\36\7\4\2\2\35\37\5"+
		"\b\5\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\3\3\2\2\2\"#\7"+
		"\36\2\2#$\7\5\2\2$-\7\6\2\2%*\5\6\4\2&\'\7\7\2\2\')\5\6\4\2(&\3\2\2\2"+
		"),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+.\3\2\2\2,*\3\2\2\2-%\3\2\2\2-.\3\2\2\2"+
		"./\3\2\2\2/\60\7\b\2\2\60\61\7\t\2\2\61\5\3\2\2\2\62\63\7\n\2\2\638\7"+
		"\35\2\2\64\65\7\7\2\2\65\67\7\35\2\2\66\64\3\2\2\2\67:\3\2\2\28\66\3\2"+
		"\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\13\2\2<\7\3\2\2\2=>\5\f\7\2>?\7"+
		"\t\2\2?\t\3\2\2\2@A\5\20\t\2AI\7\35\2\2BD\7\7\2\2CE\5\20\t\2DC\3\2\2\2"+
		"DE\3\2\2\2EF\3\2\2\2FH\7\35\2\2GB\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2"+
		"\2JL\3\2\2\2KI\3\2\2\2LM\7\f\2\2M\13\3\2\2\2NO\b\7\1\2OP\5\n\6\2PQ\5\f"+
		"\7\7Q[\3\2\2\2RS\5\24\13\2ST\5\f\7\5T[\3\2\2\2UV\7\n\2\2VW\5\f\7\2WX\7"+
		"\13\2\2X[\3\2\2\2Y[\5\16\b\2ZN\3\2\2\2ZR\3\2\2\2ZU\3\2\2\2ZY\3\2\2\2["+
		"b\3\2\2\2\\]\f\6\2\2]^\5\22\n\2^_\5\f\7\7_a\3\2\2\2`\\\3\2\2\2ad\3\2\2"+
		"\2b`\3\2\2\2bc\3\2\2\2c\r\3\2\2\2db\3\2\2\2ef\7\36\2\2fg\5\6\4\2g\17\3"+
		"\2\2\2hi\t\2\2\2i\21\3\2\2\2jk\t\3\2\2k\23\3\2\2\2lm\t\4\2\2m\25\3\2\2"+
		"\2\13\32 *-8DIZb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}