// Generated from C:/Users/anil.ozturk/IdeaProjects/untitled1/src\Kodkod.g4 by ANTLR 4.5.1
package eu.modelwriter.kodkod.core.recognizer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KodkodParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, INT=71, IDENTIFIER=72, DIGIT=73, 
		APOSTROPHE=74, MULTILINE_COMMENT=75, SINGLELINE_COMMENT=76, WS=77;
	public static final int
		RULE_problem = 0, RULE_options = 1, RULE_option = 2, RULE_universe = 3, 
		RULE_relations = 4, RULE_relation = 5, RULE_tupleSet = 6, RULE_tuple = 7, 
		RULE_atom = 8, RULE_relationId = 9, RULE_variableId = 10, RULE_integer = 11, 
		RULE_arity = 12, RULE_formula = 13, RULE_expression = 14, RULE_intexpression = 15, 
		RULE_decls = 16, RULE_decl = 17, RULE_letDecls = 18, RULE_letDecl = 19, 
		RULE_comprehensionDecls = 20, RULE_comprehensionDecl = 21;
	public static final String[] ruleNames = {
		"problem", "options", "option", "universe", "relations", "relation", "tupleSet", 
		"tuple", "atom", "relationId", "variableId", "integer", "arity", "formula", 
		"expression", "intexpression", "decls", "decl", "letDecls", "letDecl", 
		"comprehensionDecls", "comprehensionDecl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'options'", "'{'", "','", "'}'", "'symmetry_breaking'", "':'", 
		"'bit_width'", "'skolem_depth'", "'sharing'", "'universe'", "'['", "']'", 
		"'relations'", "'..'", "'('", "')'", "'no'", "'lone'", "'one'", "'some'", 
		"'!'", "'not'", "'in'", "'='", "'<'", "'<='", "'>'", "'>='", "'sum'", 
		"'|'", "'acyclic'", "'function'", "'->'", "'ord'", "'&&'", "'and'", "'||'", 
		"'or'", "'=>'", "'if'", "'<=>'", "'iff'", "'all'", "'let'", "'true'", 
		"'false'", "'~'", "'^'", "'*'", "'+'", "'&'", "'-'", "'.'", "'set'", "'++'", 
		"'then'", "'else'", "'iden'", "'none'", "'univ'", "'ints'", "'#'", "'plus'", 
		"'minus'", "'mul'", "'/'", "'div'", "'%'", "'modulo'", "'disj'", null, 
		null, null, "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "INT", 
		"IDENTIFIER", "DIGIT", "APOSTROPHE", "MULTILINE_COMMENT", "SINGLELINE_COMMENT", 
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
	public String getGrammarFileName() { return "Kodkod.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public java.util.Stack<String> declarations = new java.util.Stack<String>();
	    public java.util.List<String> atoms = new java.util.ArrayList<String>();
	    public java.util.List<kodkod.ast.Formula> formulas = new java.util.ArrayList<kodkod.ast.Formula>();
	    public java.util.Map<String, kodkod.ast.Relation> relations = new java.util.HashMap<String, kodkod.ast.Relation>();
	    public kodkod.instance.Universe universe = null;
	    public kodkod.instance.Bounds bounds = null;

	    private boolean isRelation() { return this.relations.containsKey(getCurrentToken().getText()); }
	    private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}
	    private String context = null;
	    private int declareVariables(java.util.List<VariableIdContext> vars, int var) {
	        System.out.println("Quantifier context: ");
	        for (VariableIdContext vc : vars) {
	            String s = vc.getText(); declarations.add(s); var++; System.out.println(s);
	        }
	        return var;
	    }

	public KodkodParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProblemContext extends ParserRuleContext {
		public FormulaContext formula;
		public List<FormulaContext> formulas = new ArrayList<FormulaContext>();
		public UniverseContext universe() {
			return getRuleContext(UniverseContext.class,0);
		}
		public RelationsContext relations() {
			return getRuleContext(RelationsContext.class,0);
		}
		public OptionsContext options() {
			return getRuleContext(OptionsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ProblemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_problem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterProblem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitProblem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitProblem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProblemContext problem() throws RecognitionException {
		ProblemContext _localctx = new ProblemContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_problem);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(44);
				options();
				}
			}

			setState(47);
			universe();
			System.out.println(universe);
			setState(49);
			relations();
			System.out.println(bounds);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51);
					((ProblemContext)_localctx).formula = formula(0);
					((ProblemContext)_localctx).formulas.add(((ProblemContext)_localctx).formula);
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}


			    System.out.println("declarations= "+declarations);
			    declarations.clear();

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

	public static class OptionsContext extends ParserRuleContext {
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public OptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionsContext options() throws RecognitionException {
		OptionsContext _localctx = new OptionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_options);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__0);
			setState(61);
			match(T__1);
			setState(62);
			option();
			{
			setState(63);
			match(T__2);
			setState(64);
			option();
			}
			setState(66);
			match(T__3);
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

	public static class OptionContext extends ParserRuleContext {
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
	 
		public OptionContext() { }
		public void copyFrom(OptionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SymmetryBreakingContext extends OptionContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public SymmetryBreakingContext(OptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterSymmetryBreaking(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitSymmetryBreaking(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitSymmetryBreaking(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitWidthContext extends OptionContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public BitWidthContext(OptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterBitWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitBitWidth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitBitWidth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkolemDepthContext extends OptionContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public SkolemDepthContext(OptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterSkolemDepth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitSkolemDepth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitSkolemDepth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SharingContext extends OptionContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public SharingContext(OptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterSharing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitSharing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitSharing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_option);
		try {
			setState(80);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(T__4);
				setState(69);
				match(T__5);
				setState(70);
				integer();
				}
				break;
			case T__6:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(T__6);
				setState(72);
				match(T__5);
				setState(73);
				integer();
				}
				break;
			case T__7:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(T__7);
				setState(75);
				match(T__5);
				setState(76);
				integer();
				}
				break;
			case T__8:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				match(T__8);
				setState(78);
				match(T__5);
				setState(79);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class UniverseContext extends ParserRuleContext {
		public AtomContext atom;
		public List<AtomContext> atoms = new ArrayList<AtomContext>();
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public UniverseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_universe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterUniverse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitUniverse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitUniverse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UniverseContext universe() throws RecognitionException {
		UniverseContext _localctx = new UniverseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_universe);
		context="universe";
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__9);
			setState(105);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(83);
				match(T__1);
				{
				setState(84);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(85);
					match(T__2);
					setState(86);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(92);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				{
				setState(94);
				match(T__10);
				{
				setState(95);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(96);
					match(T__2);
					setState(97);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(103);
				match(T__11);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			    System.out.println("universe:");
			    for (AtomContext atom : ((UniverseContext)_localctx).atoms) {
			        String s = atom.getText(); System.out.println(s);
			        if (atoms.contains(s)) {System.err.println("duplicated atom found: '"+ s + "' at "+ getLocation());}
			        else {atoms.add(s);}
			    }
			    this.universe = new  kodkod.instance.Universe(this.atoms);
			    this.bounds = new  kodkod.instance.Bounds(this.universe);
			    context = null;

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

	public static class RelationsContext extends ParserRuleContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public RelationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterRelations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitRelations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitRelations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationsContext relations() throws RecognitionException {
		RelationsContext _localctx = new RelationsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_relations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__12);
			setState(110);
			match(T__1);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(111);
				relation();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(T__3);
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

	public static class RelationContext extends ParserRuleContext {
		public RelationIdContext relationId;
		public ArityContext arity;
		public TupleSetContext lowerBound;
		public TupleSetContext upperBound;
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public ArityContext arity() {
			return getRuleContext(ArityContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TupleSetContext> tupleSet() {
			return getRuleContexts(TupleSetContext.class);
		}
		public TupleSetContext tupleSet(int i) {
			return getRuleContext(TupleSetContext.class,i);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_relation);
		context="relations";
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(119);
			((RelationContext)_localctx).relationId = relationId();
			setState(121);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(120);
				((RelationContext)_localctx).arity = arity();
				}
			}

			setState(123);
			match(T__5);
			setState(125);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(124);
				expression(0);
				}
				break;
			}
			setState(127);
			match(T__10);
			{
			setState(128);
			((RelationContext)_localctx).lowerBound = tupleSet();
			setState(131);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(129);
				match(T__2);
				setState(130);
				((RelationContext)_localctx).upperBound = tupleSet();
				}
			}

			}
			setState(133);
			match(T__11);
			}

			    String name = (((RelationContext)_localctx).relationId!=null?_input.getText(((RelationContext)_localctx).relationId.start,((RelationContext)_localctx).relationId.stop):null);
			    System.out.println("relation " + name);
			    if (relations.containsKey(name)) {System.err.println("duplicated relation found: '"+ name + "' at "+ getLocation());}

			    kodkod.ast.Relation relation = null;
			    int arity = 0;
			    if ((((RelationContext)_localctx).arity!=null?_input.getText(((RelationContext)_localctx).arity.start,((RelationContext)_localctx).arity.stop):null) != null && !(((RelationContext)_localctx).arity!=null?_input.getText(((RelationContext)_localctx).arity.start,((RelationContext)_localctx).arity.stop):null).isEmpty()) {arity = Integer.parseInt((((RelationContext)_localctx).arity!=null?_input.getText(((RelationContext)_localctx).arity.start,((RelationContext)_localctx).arity.stop):null));}

			    kodkod.instance.TupleSet lowerBound = null;
			    java.util.List<kodkod.instance.Tuple> tuplesInLowerBound = new java.util.ArrayList<kodkod.instance.Tuple>();
			    if (((RelationContext)_localctx).lowerBound != null && !((RelationContext)_localctx).lowerBound.tuples.isEmpty()){
			        if (arity == 0) {arity = ((RelationContext)_localctx).lowerBound.tuples.get(0).atoms.size();}
			        for (TupleContext tuple : ((RelationContext)_localctx).lowerBound.tuples) {
			            java.util.List<String> atoms = new java.util.ArrayList<String>();
			            for (AtomContext atom : tuple.atoms) {
			                atoms.add(atom.getText());
			            }
			            tuplesInLowerBound.add(this.universe.factory().tuple(atoms));
			        }
			        lowerBound = this.universe.factory().setOf(tuplesInLowerBound);
			        System.out.println("lb: " +lowerBound);
			    }

			    kodkod.instance.TupleSet upperBound = null;
			    java.util.List<kodkod.instance.Tuple> tuplesInUpperBound = new java.util.ArrayList<kodkod.instance.Tuple>();
			    if (((RelationContext)_localctx).upperBound != null && !((RelationContext)_localctx).upperBound.tuples.isEmpty()){
			        if (lowerBound == null && arity == 0) {arity = ((RelationContext)_localctx).upperBound.tuples.get(0).atoms.size();}
			        for (TupleContext tuple : ((RelationContext)_localctx).upperBound.tuples) {
			            java.util.List<String> atoms = new java.util.ArrayList<String>();
			            for (AtomContext atom : tuple.atoms) {
			                atoms.add(atom.getText());
			            }
			            tuplesInUpperBound.add(this.universe.factory().tuple(atoms));
			        }
			        upperBound = this.universe.factory().setOf(tuplesInUpperBound);
			        System.out.println("up: " +upperBound);
			    }

			    if (lowerBound == null && upperBound == null && arity == 0) {arity = 1;}

			    if (lowerBound == null) {lowerBound = this.universe.factory().noneOf(arity);}

			    System.out.println(arity);
			    if (arity == 0) {
			        System.err.println("0 arity is detected on relation: '"+ name + "' at "+ getLocation());
			    } else if (arity > 0) {
			        relation = kodkod.ast.Relation.nary(name, arity);
			    }

			    if (upperBound == null) {this.bounds.boundExactly(relation, lowerBound);}
			    else {this.bounds.bound(relation, lowerBound, upperBound);}
			    this.relations.put(name, relation);

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

	public static class TupleSetContext extends ParserRuleContext {
		public TupleContext tuple;
		public List<TupleContext> tuples = new ArrayList<TupleContext>();
		public TupleContext left;
		public Token range;
		public TupleContext right;
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public TupleSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterTupleSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitTupleSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitTupleSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleSetContext tupleSet() throws RecognitionException {
		TupleSetContext _localctx = new TupleSetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tupleSet);
		int _la;
		try {
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(T__1);
				setState(146);
				_la = _input.LA(1);
				if (_la==T__10 || _la==T__14) {
					{
					setState(138);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(139);
						match(T__2);
						setState(140);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(145);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(148);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(T__10);
				setState(158);
				_la = _input.LA(1);
				if (_la==T__10 || _la==T__14) {
					{
					setState(150);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(151);
						match(T__2);
						setState(152);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(157);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(160);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				match(T__1);
				setState(162);
				((TupleSetContext)_localctx).left = tuple();
				setState(163);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(164);
				((TupleSetContext)_localctx).right = tuple();
				setState(165);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				match(T__10);
				setState(168);
				((TupleSetContext)_localctx).left = tuple();
				setState(169);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(170);
				((TupleSetContext)_localctx).right = tuple();
				setState(171);
				match(T__11);
				}
				break;
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
		public AtomContext atom;
		public List<AtomContext> atoms = new ArrayList<AtomContext>();
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tuple);
		int _la;
		try {
			setState(197);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(T__14);
				setState(176);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(177);
					match(T__2);
					setState(178);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				match(T__15);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(T__10);
				setState(187);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(188);
					match(T__2);
					setState(189);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(195);
				match(T__11);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AtomContext extends ParserRuleContext {
		public Token id;
		public TerminalNode IDENTIFIER() { return getToken(KodkodParser.IDENTIFIER, 0); }
		public TerminalNode INT() { return getToken(KodkodParser.INT, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_atom);
		try {
			setState(202);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				((AtomContext)_localctx).id = match(IDENTIFIER);

				    if (context != null && !context.isEmpty() && !context.equals("universe")) {
				        System.out.print("atom found: " + (((AtomContext)_localctx).id!=null?((AtomContext)_localctx).id.getText():null) + "-> ");
				        if ( atoms.contains((((AtomContext)_localctx).id!=null?((AtomContext)_localctx).id.getText():null)) ) {System.out.println("defined");}
				        else {System.err.println("undefined atom found: '" +(((AtomContext)_localctx).id!=null?((AtomContext)_localctx).id.getText():null)  + "' at " + getLocation());}
				    }

				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class RelationIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(KodkodParser.IDENTIFIER, 0); }
		public RelationIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterRelationId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitRelationId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitRelationId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationIdContext relationId() throws RecognitionException {
		RelationIdContext _localctx = new RelationIdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(IDENTIFIER);
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

	public static class VariableIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(KodkodParser.IDENTIFIER, 0); }
		public VariableIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterVariableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitVariableId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitVariableId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableIdContext variableId() throws RecognitionException {
		VariableIdContext _localctx = new VariableIdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(IDENTIFIER);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(KodkodParser.INT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(INT);
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

	public static class ArityContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(KodkodParser.INT, 0); }
		public ArityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterArity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitArity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitArity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArityContext arity() throws RecognitionException {
		ArityContext _localctx = new ArityContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(INT);
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

	public static class FormulaContext extends ParserRuleContext {
		public int var =  0;;
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
			this.var = ctx.var;
		}
	}
	public static class NoContext extends FormulaContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NoContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterNo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitNo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitNo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomeContext extends FormulaContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SomeContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitSome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitSome(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForOneContext extends FormulaContext {
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForOneContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterForOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitForOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitForOne(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumDeclarationContext extends FormulaContext {
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public IntexpressionContext intexpression() {
			return getRuleContext(IntexpressionContext.class,0);
		}
		public SumDeclarationContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterSumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitSumDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitSumDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForAllContext extends FormulaContext {
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForAllContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterForAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitForAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitForAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoneContext extends FormulaContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoneContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterLone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitLone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitLone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtContext extends FormulaContext {
		public IntexpressionContext left;
		public Token not;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public LtContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitLt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitLt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForSomeContext extends FormulaContext {
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForSomeContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterForSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitForSome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitForSome(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends FormulaContext {
		public Token op;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NotContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class F_paranthesisContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public F_paranthesisContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterF_paranthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitF_paranthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitF_paranthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends FormulaContext {
		public FormulaContext left;
		public Token op;
		public FormulaContext right;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public AndContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionContext extends FormulaContext {
		public RelationIdContext rel;
		public ExpressionContext domain;
		public Token op;
		public ExpressionContext range;
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GteContext extends FormulaContext {
		public IntexpressionContext left;
		public Token not;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public GteContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterGte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitGte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitGte(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AcyclicContext extends FormulaContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public AcyclicContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterAcyclic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitAcyclic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitAcyclic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetContext extends FormulaContext {
		public LetDeclsContext letDecls() {
			return getRuleContext(LetDeclsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public LetContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LteContext extends FormulaContext {
		public IntexpressionContext left;
		public Token not;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public LteContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterLte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitLte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitLte(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends FormulaContext {
		public FormulaContext left;
		public Token op;
		public FormulaContext right;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public OrContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InContext extends FormulaContext {
		public ExpressionContext left;
		public Token not;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitIn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OneContext extends FormulaContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OneContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitOne(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends FormulaContext {
		public FalseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IffContext extends FormulaContext {
		public FormulaContext left;
		public Token op;
		public FormulaContext right;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public IffContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterIff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitIff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitIff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqContext extends FormulaContext {
		public IntexpressionContext left;
		public Token not;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public EqContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GtContext extends FormulaContext {
		public IntexpressionContext left;
		public Token not;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public GtContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitGt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitGt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualContext extends FormulaContext {
		public ExpressionContext left;
		public Token not;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForLoneContext extends FormulaContext {
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForLoneContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterForLone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitForLone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitForLone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TotalOrderContext extends FormulaContext {
		public RelationIdContext rel;
		public RelationIdContext ordered;
		public RelationIdContext first;
		public RelationIdContext last;
		public List<RelationIdContext> relationId() {
			return getRuleContexts(RelationIdContext.class);
		}
		public RelationIdContext relationId(int i) {
			return getRuleContext(RelationIdContext.class,i);
		}
		public TotalOrderContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterTotalOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitTotalOrder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitTotalOrder(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends FormulaContext {
		public TrueContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForNoContext extends FormulaContext {
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForNoContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterForNo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitForNo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitForNo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImpliesContext extends FormulaContext {
		public FormulaContext left;
		public Token op;
		public FormulaContext right;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ImpliesContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitImplies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitImplies(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(213);
				((NotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__21) ) {
					((NotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(214);
				formula(14);
				}
				break;
			case 2:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(T__16);
				setState(216);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(T__17);
				setState(218);
				expression(0);
				}
				break;
			case 4:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(T__18);
				setState(220);
				expression(0);
				}
				break;
			case 5:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(T__19);
				setState(222);
				expression(0);
				}
				break;
			case 6:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				((InContext)_localctx).left = expression(0);
				setState(225);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(224);
					((InContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((InContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(227);
				match(T__22);
				setState(228);
				((InContext)_localctx).right = expression(0);
				}
				break;
			case 7:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				((EqualContext)_localctx).left = expression(0);
				setState(232);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(231);
					((EqualContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((EqualContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(234);
				match(T__23);
				setState(235);
				((EqualContext)_localctx).right = expression(0);
				}
				break;
			case 8:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				((EqContext)_localctx).left = intexpression(0);
				setState(239);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(238);
					((EqContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((EqContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(241);
				match(T__23);
				setState(242);
				((EqContext)_localctx).right = intexpression(0);
				}
				break;
			case 9:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				((LtContext)_localctx).left = intexpression(0);
				setState(246);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(245);
					((LtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((LtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(248);
				match(T__24);
				setState(249);
				((LtContext)_localctx).right = intexpression(0);
				}
				break;
			case 10:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				((LteContext)_localctx).left = intexpression(0);
				setState(253);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(252);
					((LteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((LteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(255);
				match(T__25);
				setState(256);
				((LteContext)_localctx).right = intexpression(0);
				}
				break;
			case 11:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				((GtContext)_localctx).left = intexpression(0);
				setState(260);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(259);
					((GtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((GtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(262);
				match(T__26);
				setState(263);
				((GtContext)_localctx).right = intexpression(0);
				}
				break;
			case 12:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				((GteContext)_localctx).left = intexpression(0);
				setState(267);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(266);
					((GteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((GteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(269);
				match(T__27);
				setState(270);
				((GteContext)_localctx).right = intexpression(0);
				}
				break;
			case 13:
				{
				_localctx = new SumDeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(13)).var =  0;
				{
				setState(273);
				match(T__28);
				setState(274);
				decls();
				setState(275);
				match(T__29);
				setState(276);
				intexpression(0);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(13)).var; i++) declarations.pop();
				}
				break;
			case 14:
				{
				_localctx = new AcyclicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(280);
				match(T__30);
				setState(281);
				match(T__10);
				setState(282);
				relationId();
				setState(283);
				match(T__11);
				}
				break;
			case 15:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(T__31);
				setState(286);
				match(T__10);
				setState(287);
				((FunctionContext)_localctx).rel = relationId();
				setState(288);
				match(T__5);
				setState(289);
				((FunctionContext)_localctx).domain = expression(0);
				setState(290);
				match(T__32);
				setState(291);
				((FunctionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
					((FunctionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(292);
				((FunctionContext)_localctx).range = expression(0);
				setState(293);
				match(T__11);
				}
				break;
			case 16:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(295);
				match(T__33);
				setState(296);
				match(T__10);
				setState(297);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(298);
				match(T__2);
				setState(299);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(300);
				match(T__2);
				setState(301);
				((TotalOrderContext)_localctx).first = relationId();
				setState(302);
				match(T__2);
				setState(303);
				((TotalOrderContext)_localctx).last = relationId();
				setState(304);
				match(T__11);
				}
				break;
			case 17:
				{
				_localctx = new ForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(13)).var =  0;
				{
				setState(307);
				match(T__42);
				setState(308);
				decls();
				setState(329);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(309);
					match(T__29);
					setState(319);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						setState(310);
						formula(0);
						}
						break;
					case 2:
						{
						setState(311);
						match(T__1);
						setState(315);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(312);
								formula(0);
								}
								} 
							}
							setState(317);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						}
						setState(318);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(321);
					match(T__1);
					setState(325);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(322);
							formula(0);
							}
							} 
						}
						setState(327);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
					}
					setState(328);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(13)).var; i++) declarations.pop();
				}
				break;
			case 18:
				{
				_localctx = new ForSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(13)).var =  0;
				{
				setState(334);
				match(T__19);
				setState(335);
				decls();
				setState(356);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(336);
					match(T__29);
					setState(346);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						setState(337);
						formula(0);
						}
						break;
					case 2:
						{
						setState(338);
						match(T__1);
						setState(342);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(339);
								formula(0);
								}
								} 
							}
							setState(344);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						}
						setState(345);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(348);
					match(T__1);
					setState(352);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(349);
							formula(0);
							}
							} 
						}
						setState(354);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					}
					setState(355);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(13)).var; i++) declarations.pop();
				}
				break;
			case 19:
				{
				_localctx = new ForNoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(13)).var =  0;
				{
				setState(361);
				match(T__16);
				setState(362);
				decls();
				setState(383);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(363);
					match(T__29);
					setState(373);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						setState(364);
						formula(0);
						}
						break;
					case 2:
						{
						setState(365);
						match(T__1);
						setState(369);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(366);
								formula(0);
								}
								} 
							}
							setState(371);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
						}
						setState(372);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(375);
					match(T__1);
					setState(379);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(376);
							formula(0);
							}
							} 
						}
						setState(381);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					}
					setState(382);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(13)).var; i++) declarations.pop();
				}
				break;
			case 20:
				{
				_localctx = new ForOneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(13)).var =  0;
				{
				setState(388);
				match(T__18);
				setState(389);
				decls();
				setState(410);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(390);
					match(T__29);
					setState(400);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						setState(391);
						formula(0);
						}
						break;
					case 2:
						{
						setState(392);
						match(T__1);
						setState(396);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(393);
								formula(0);
								}
								} 
							}
							setState(398);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
						}
						setState(399);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(402);
					match(T__1);
					setState(406);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(403);
							formula(0);
							}
							} 
						}
						setState(408);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
					}
					setState(409);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(13)).var; i++) declarations.pop();
				}
				break;
			case 21:
				{
				_localctx = new ForLoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(13)).var =  0;
				{
				setState(415);
				match(T__17);
				setState(416);
				decls();
				setState(437);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(417);
					match(T__29);
					setState(427);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						setState(418);
						formula(0);
						}
						break;
					case 2:
						{
						setState(419);
						match(T__1);
						setState(423);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(420);
								formula(0);
								}
								} 
							}
							setState(425);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
						}
						setState(426);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(429);
					match(T__1);
					setState(433);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(430);
							formula(0);
							}
							} 
						}
						setState(435);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
					}
					setState(436);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(13)).var; i++) declarations.pop();
				}
				break;
			case 22:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(13)).var =  0;
				{
				setState(442);
				match(T__43);
				setState(443);
				letDecls();
				setState(464);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(444);
					match(T__29);
					setState(454);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						setState(445);
						formula(0);
						}
						break;
					case 2:
						{
						setState(446);
						match(T__1);
						setState(450);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(447);
								formula(0);
								}
								} 
							}
							setState(452);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
						}
						setState(453);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(456);
					match(T__1);
					setState(460);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(457);
							formula(0);
							}
							} 
						}
						setState(462);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
					}
					setState(463);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(13)).var; i++) declarations.pop();
				}
				break;
			case 23:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(468);
				match(T__44);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(469);
				match(T__45);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(470);
				match(T__14);
				setState(471);
				formula(0);
				setState(472);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(490);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(488);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(476);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(477);
						((AndContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
							((AndContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(478);
						((AndContext)_localctx).right = formula(13);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(479);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(480);
						((OrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
							((OrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(481);
						((OrContext)_localctx).right = formula(12);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(482);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(483);
						((ImpliesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__38 || _la==T__39) ) {
							((ImpliesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(484);
						((ImpliesContext)_localctx).right = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(485);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(486);
						((IffContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__40 || _la==T__41) ) {
							((IffContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(487);
						((IffContext)_localctx).right = formula(10);
						}
						break;
					}
					} 
				}
				setState(492);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProductContext extends ExpressionContext {
		public ExpressionContext left;
		public Token leftMult;
		public Token rightMult;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ProductContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends ExpressionContext {
		public VariableIdContext variableId;
		public VariableIdContext variableId() {
			return getRuleContext(VariableIdContext.class,0);
		}
		public VarContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoneContext extends ExpressionContext {
		public NoneContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitNone(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnionContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public UnionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoxjoinContext extends ExpressionContext {
		public ExpressionContext right;
		public ExpressionContext left;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BoxjoinContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterBoxjoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitBoxjoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitBoxjoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComprehensionContext extends ExpressionContext {
		public ComprehensionDeclsContext comprehensionDecls() {
			return getRuleContext(ComprehensionDeclsContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ComprehensionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterComprehension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitComprehension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitComprehension(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnivContext extends ExpressionContext {
		public UnivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterUniv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitUniv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitUniv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReflexiveContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReflexiveContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterReflexive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitReflexive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitReflexive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class E_paranthesisContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public E_paranthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterE_paranthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitE_paranthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitE_paranthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdenContext extends ExpressionContext {
		public IdenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterIden(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitIden(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitIden(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntsContext extends ExpressionContext {
		public IntsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterInts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitInts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitInts(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntersectionContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IntersectionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterIntersection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitIntersection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitIntersection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelContext extends ExpressionContext {
		public RelationIdContext relationId() {
			return getRuleContext(RelationIdContext.class,0);
		}
		public RelContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitRel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitRel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DifferenceContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DifferenceContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitDifference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TransposeContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TransposeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterTranspose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitTranspose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitTranspose(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JoinContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public JoinContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OverrideContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OverrideContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterOverride(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitOverride(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitOverride(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfExpressionContext extends ExpressionContext {
		public Token op;
		public FormulaContext condition;
		public ExpressionContext thenExpr;
		public ExpressionContext elseExpr;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterIfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitIfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitIfExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClosureContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClosureContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterClosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitClosure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitClosure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(494);
				match(T__46);
				setState(495);
				expression(17);
				}
				break;
			case 2:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(496);
				match(T__47);
				setState(497);
				expression(16);
				}
				break;
			case 3:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(498);
				match(T__48);
				setState(499);
				expression(15);
				}
				break;
			case 4:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(500);
				((IfExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__38 || _la==T__39) ) {
					((IfExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(501);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(502);
				match(T__55);
				setState(503);
				((IfExpressionContext)_localctx).thenExpr = expression(0);
				setState(504);
				match(T__56);
				setState(505);
				((IfExpressionContext)_localctx).elseExpr = expression(6);
				}
				break;
			case 5:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(507);
				if (!(!isRelation())) throw new FailedPredicateException(this, "!isRelation()");
				setState(508);
				((VarContext)_localctx).variableId = variableId();

				        System.out.print("variable found: " + (((VarContext)_localctx).variableId!=null?_input.getText(((VarContext)_localctx).variableId.start,((VarContext)_localctx).variableId.stop):null) + "-> ");
				        String s = (((VarContext)_localctx).variableId!=null?_input.getText(((VarContext)_localctx).variableId.start,((VarContext)_localctx).variableId.stop):null);
				        if ( declarations.contains(s) ) {System.out.println("defined");}
				        else {System.err.println("undefined variable found: '"+ s + "' at "+ getLocation());}
				      
				}
				break;
			case 6:
				{
				_localctx = new RelContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(511);
				if (!(isRelation())) throw new FailedPredicateException(this, "isRelation()");
				setState(512);
				relationId();
				}
				break;
			case 7:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(13)).var =  0;
				{
				setState(514);
				match(T__1);
				setState(515);
				comprehensionDecls();
				setState(516);
				match(T__29);
				setState(517);
				formula(0);
				setState(518);
				match(T__3);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(13)).var; i++) declarations.pop();
				}
				break;
			case 8:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(522);
				match(T__57);
				}
				break;
			case 9:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(523);
				match(T__58);
				}
				break;
			case 10:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(524);
				match(T__59);
				}
				break;
			case 11:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(525);
				match(T__60);
				}
				break;
			case 12:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(526);
				match(T__14);
				setState(527);
				expression(0);
				setState(528);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(563);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(561);
					switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(532);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(533);
						match(T__49);
						setState(534);
						((UnionContext)_localctx).right = expression(15);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(535);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(536);
						match(T__50);
						setState(537);
						((IntersectionContext)_localctx).right = expression(14);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(538);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(539);
						match(T__51);
						setState(540);
						((DifferenceContext)_localctx).right = expression(13);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(541);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(542);
						match(T__52);
						setState(543);
						((JoinContext)_localctx).right = expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(544);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(546);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__53))) != 0)) {
							{
							setState(545);
							((ProductContext)_localctx).leftMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__53))) != 0)) ) {
								((ProductContext)_localctx).leftMult = (Token)_errHandler.recoverInline(this);
							} else {
								consume();
							}
							}
						}

						setState(548);
						match(T__32);
						setState(550);
						switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
						case 1:
							{
							setState(549);
							((ProductContext)_localctx).rightMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__53))) != 0)) ) {
								((ProductContext)_localctx).rightMult = (Token)_errHandler.recoverInline(this);
							} else {
								consume();
							}
							}
							break;
						}
						setState(552);
						((ProductContext)_localctx).right = expression(9);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(553);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(554);
						match(T__54);
						setState(555);
						((OverrideContext)_localctx).right = expression(9);
						}
						break;
					case 7:
						{
						_localctx = new BoxjoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxjoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(556);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(557);
						match(T__10);
						setState(558);
						((BoxjoinContext)_localctx).left = expression(0);
						setState(559);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(565);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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

	public static class IntexpressionContext extends ParserRuleContext {
		public IntexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intexpression; }
	 
		public IntexpressionContext() { }
		public void copyFrom(IntexpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MinusContext extends IntexpressionContext {
		public IntexpressionContext left;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public MinusContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntConstantContext extends IntexpressionContext {
		public Token sign;
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public IntConstantContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterIntConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitIntConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitIntConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class I_paranthesisContext extends IntexpressionContext {
		public IntexpressionContext intexpression() {
			return getRuleContext(IntexpressionContext.class,0);
		}
		public I_paranthesisContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterI_paranthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitI_paranthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitI_paranthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfIntExpressionContext extends IntexpressionContext {
		public Token op;
		public FormulaContext condition;
		public IntexpressionContext thenExpr;
		public IntexpressionContext elseExpr;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public IfIntExpressionContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterIfIntExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitIfIntExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitIfIntExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CountContext extends IntexpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CountContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitCount(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitCount(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumContext extends IntexpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SumContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivideContext extends IntexpressionContext {
		public IntexpressionContext left;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public DivideContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyContext extends IntexpressionContext {
		public IntexpressionContext left;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public MultiplyContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModuloContext extends IntexpressionContext {
		public IntexpressionContext left;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public ModuloContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterModulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitModulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitModulo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusContext extends IntexpressionContext {
		public IntexpressionContext left;
		public IntexpressionContext right;
		public List<IntexpressionContext> intexpression() {
			return getRuleContexts(IntexpressionContext.class);
		}
		public IntexpressionContext intexpression(int i) {
			return getRuleContext(IntexpressionContext.class,i);
		}
		public PlusContext(IntexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntexpressionContext intexpression() throws RecognitionException {
		return intexpression(0);
	}

	private IntexpressionContext intexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IntexpressionContext _localctx = new IntexpressionContext(_ctx, _parentState);
		IntexpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_intexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			switch (_input.LA(1)) {
			case T__38:
			case T__39:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(567);
				((IfIntExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__38 || _la==T__39) ) {
					((IfIntExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(568);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(569);
				match(T__55);
				setState(570);
				((IfIntExpressionContext)_localctx).thenExpr = intexpression(0);
				setState(571);
				match(T__56);
				setState(572);
				((IfIntExpressionContext)_localctx).elseExpr = intexpression(10);
				}
				break;
			case T__28:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(574);
				match(T__28);
				setState(575);
				expression(0);
				}
				break;
			case T__61:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(576);
				match(T__61);
				setState(577);
				expression(0);
				}
				break;
			case T__51:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(579);
				_la = _input.LA(1);
				if (_la==T__51) {
					{
					setState(578);
					((IntConstantContext)_localctx).sign = match(T__51);
					}
				}

				setState(581);
				integer();
				}
				break;
			case T__14:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(582);
				match(T__14);
				setState(583);
				intexpression(0);
				setState(584);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(605);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(603);
					switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntexpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(588);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(589);
						_la = _input.LA(1);
						if ( !(_la==T__49 || _la==T__62) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(590);
						((PlusContext)_localctx).right = intexpression(8);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntexpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(591);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(592);
						_la = _input.LA(1);
						if ( !(_la==T__51 || _la==T__63) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(593);
						((MinusContext)_localctx).right = intexpression(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntexpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(594);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(595);
						_la = _input.LA(1);
						if ( !(_la==T__48 || _la==T__64) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(596);
						((MultiplyContext)_localctx).right = intexpression(6);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntexpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(597);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(598);
						_la = _input.LA(1);
						if ( !(_la==T__65 || _la==T__66) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(599);
						((DivideContext)_localctx).right = intexpression(5);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntexpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(600);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(601);
						_la = _input.LA(1);
						if ( !(_la==T__67 || _la==T__68) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(602);
						((ModuloContext)_localctx).right = intexpression(4);
						}
						break;
					}
					} 
				}
				setState(607);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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

	public static class DeclsContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			decl();
			setState(613);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(609);
				match(T__2);
				setState(610);
				decl();
				}
				}
				setState(615);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DeclContext extends ParserRuleContext {
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	 
		public DeclContext() { }
		public void copyFrom(DeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OneOfContext extends DeclContext {
		public Token disj;
		public VariableIdContext variableId;
		public List<VariableIdContext> vars = new ArrayList<VariableIdContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public OneOfContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterOneOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitOneOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitOneOf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomeOfContext extends DeclContext {
		public Token disj;
		public VariableIdContext variableId;
		public List<VariableIdContext> vars = new ArrayList<VariableIdContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public SomeOfContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterSomeOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitSomeOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitSomeOf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoneOfContext extends DeclContext {
		public Token disj;
		public VariableIdContext variableId;
		public List<VariableIdContext> vars = new ArrayList<VariableIdContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public LoneOfContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterLoneOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitLoneOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitLoneOf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetOfContext extends DeclContext {
		public Token disj;
		public VariableIdContext variableId;
		public List<VariableIdContext> vars = new ArrayList<VariableIdContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public SetOfContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterSetOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitSetOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitSetOf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_decl);
		int _la;
		try {
			setState(682);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(617);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(616);
					((OneOfContext)_localctx).disj = match(T__69);
					}
				}

				setState(619);
				((OneOfContext)_localctx).variableId = variableId();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
				setState(624);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(620);
					match(T__2);
					setState(621);
					((OneOfContext)_localctx).variableId = variableId();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
					}
					}
					setState(626);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(627);
				match(T__5);
				setState(629);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(628);
					match(T__18);
					}
					break;
				}
				setState(631);
				expression(0);
				((FormulaContext)getInvokingContext(13)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(13)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(635);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(634);
					((LoneOfContext)_localctx).disj = match(T__69);
					}
				}

				setState(637);
				((LoneOfContext)_localctx).variableId = variableId();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(638);
					match(T__2);
					setState(639);
					((LoneOfContext)_localctx).variableId = variableId();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
					}
					}
					setState(644);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(645);
				match(T__5);
				setState(646);
				match(T__17);
				setState(647);
				expression(0);
				((FormulaContext)getInvokingContext(13)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(13)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(651);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(650);
					((SomeOfContext)_localctx).disj = match(T__69);
					}
				}

				setState(653);
				((SomeOfContext)_localctx).variableId = variableId();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(654);
					match(T__2);
					setState(655);
					((SomeOfContext)_localctx).variableId = variableId();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
					}
					}
					setState(660);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(661);
				match(T__5);
				setState(662);
				match(T__19);
				setState(663);
				expression(0);
				((FormulaContext)getInvokingContext(13)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(13)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(667);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(666);
					((SetOfContext)_localctx).disj = match(T__69);
					}
				}

				setState(669);
				((SetOfContext)_localctx).variableId = variableId();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
				setState(674);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(670);
					match(T__2);
					setState(671);
					((SetOfContext)_localctx).variableId = variableId();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
					}
					}
					setState(676);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(677);
				match(T__5);
				setState(678);
				match(T__53);
				setState(679);
				expression(0);
				((FormulaContext)getInvokingContext(13)).var =  declareVariables(((SetOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(13)).var);
				}
				break;
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

	public static class LetDeclsContext extends ParserRuleContext {
		public List<LetDeclContext> letDecl() {
			return getRuleContexts(LetDeclContext.class);
		}
		public LetDeclContext letDecl(int i) {
			return getRuleContext(LetDeclContext.class,i);
		}
		public LetDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterLetDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitLetDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitLetDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetDeclsContext letDecls() throws RecognitionException {
		LetDeclsContext _localctx = new LetDeclsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_letDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			letDecl();
			setState(689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(685);
				match(T__2);
				setState(686);
				letDecl();
				}
				}
				setState(691);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class LetDeclContext extends ParserRuleContext {
		public VariableIdContext variableId;
		public List<VariableIdContext> vars = new ArrayList<VariableIdContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public LetDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterLetDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitLetDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitLetDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetDeclContext letDecl() throws RecognitionException {
		LetDeclContext _localctx = new LetDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_letDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(692);
			((LetDeclContext)_localctx).variableId = variableId();
			((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(693);
				match(T__2);
				setState(694);
				((LetDeclContext)_localctx).variableId = variableId();
				((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
				}
				}
				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(700);
			match(T__23);
			setState(701);
			expression(0);
			}
			((FormulaContext)getInvokingContext(13)).var =  declareVariables(((LetDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(13)).var);
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

	public static class ComprehensionDeclsContext extends ParserRuleContext {
		public List<ComprehensionDeclContext> comprehensionDecl() {
			return getRuleContexts(ComprehensionDeclContext.class);
		}
		public ComprehensionDeclContext comprehensionDecl(int i) {
			return getRuleContext(ComprehensionDeclContext.class,i);
		}
		public ComprehensionDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comprehensionDecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterComprehensionDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitComprehensionDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitComprehensionDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComprehensionDeclsContext comprehensionDecls() throws RecognitionException {
		ComprehensionDeclsContext _localctx = new ComprehensionDeclsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_comprehensionDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			comprehensionDecl();
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(706);
				match(T__2);
				setState(707);
				comprehensionDecl();
				}
				}
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ComprehensionDeclContext extends ParserRuleContext {
		public Token disj;
		public VariableIdContext variableId;
		public List<VariableIdContext> vars = new ArrayList<VariableIdContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public ComprehensionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comprehensionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterComprehensionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitComprehensionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitComprehensionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComprehensionDeclContext comprehensionDecl() throws RecognitionException {
		ComprehensionDeclContext _localctx = new ComprehensionDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comprehensionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			_la = _input.LA(1);
			if (_la==T__69) {
				{
				setState(713);
				((ComprehensionDeclContext)_localctx).disj = match(T__69);
				}
			}

			{
			setState(716);
			((ComprehensionDeclContext)_localctx).variableId = variableId();
			((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
			setState(721);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(717);
				match(T__2);
				setState(718);
				((ComprehensionDeclContext)_localctx).variableId = variableId();
				((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
				}
				}
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(724);
			match(T__5);
			setState(726);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(725);
				match(T__18);
				}
				break;
			}
			setState(728);
			expression(0);
			}
			((FormulaContext)getInvokingContext(13)).var =  declareVariables(((ComprehensionDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(13)).var);
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
		case 13:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 15:
			return intexpression_sempred((IntexpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return !isRelation();
		case 5:
			return isRelation();
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		case 12:
			return precpred(_ctx, 10);
		}
		return true;
	}
	private boolean intexpression_sempred(IntexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 7);
		case 14:
			return precpred(_ctx, 6);
		case 15:
			return precpred(_ctx, 5);
		case 16:
			return precpred(_ctx, 4);
		case 17:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3O\u02df\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\5\2\60\n\2\3\2"+
		"\3\2\3\2\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4S"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\7\5Z\n\5\f\5\16\5]\13\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5e\n\5\f\5\16\5h\13\5\3\5\3\5\5\5l\n\5\3\5\3\5\3\6\3\6\3\6\7\6s\n"+
		"\6\f\6\16\6v\13\6\3\6\3\6\3\7\3\7\5\7|\n\7\3\7\3\7\5\7\u0080\n\7\3\7\3"+
		"\7\3\7\3\7\5\7\u0086\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u0090\n\b"+
		"\f\b\16\b\u0093\13\b\5\b\u0095\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u009c\n\b\f"+
		"\b\16\b\u009f\13\b\5\b\u00a1\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00b0\n\b\3\t\3\t\3\t\3\t\7\t\u00b6\n\t\f\t\16\t\u00b9"+
		"\13\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00c1\n\t\f\t\16\t\u00c4\13\t\3\t\3"+
		"\t\5\t\u00c8\n\t\3\n\3\n\3\n\5\n\u00cd\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00e4\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00eb\n\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00f2\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00f9\n"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u0100\n\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0107\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u010e\n\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7"+
		"\17\u013c\n\17\f\17\16\17\u013f\13\17\3\17\5\17\u0142\n\17\3\17\3\17\7"+
		"\17\u0146\n\17\f\17\16\17\u0149\13\17\3\17\5\17\u014c\n\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0157\n\17\f\17\16\17\u015a\13"+
		"\17\3\17\5\17\u015d\n\17\3\17\3\17\7\17\u0161\n\17\f\17\16\17\u0164\13"+
		"\17\3\17\5\17\u0167\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u0172\n\17\f\17\16\17\u0175\13\17\3\17\5\17\u0178\n\17\3\17\3\17"+
		"\7\17\u017c\n\17\f\17\16\17\u017f\13\17\3\17\5\17\u0182\n\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u018d\n\17\f\17\16\17\u0190\13"+
		"\17\3\17\5\17\u0193\n\17\3\17\3\17\7\17\u0197\n\17\f\17\16\17\u019a\13"+
		"\17\3\17\5\17\u019d\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u01a8\n\17\f\17\16\17\u01ab\13\17\3\17\5\17\u01ae\n\17\3\17\3\17"+
		"\7\17\u01b2\n\17\f\17\16\17\u01b5\13\17\3\17\5\17\u01b8\n\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u01c3\n\17\f\17\16\17\u01c6\13"+
		"\17\3\17\5\17\u01c9\n\17\3\17\3\17\7\17\u01cd\n\17\f\17\16\17\u01d0\13"+
		"\17\3\17\5\17\u01d3\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u01dd\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u01eb\n\17\f\17\16\17\u01ee\13\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0215\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0225\n\20\3\20\3\20\5\20\u0229\n"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0234\n\20\f\20"+
		"\16\20\u0237\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u0246\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u024d\n\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u025e\n\21\f\21\16\21\u0261\13\21\3\22\3\22\3\22\7\22\u0266"+
		"\n\22\f\22\16\22\u0269\13\22\3\23\5\23\u026c\n\23\3\23\3\23\3\23\7\23"+
		"\u0271\n\23\f\23\16\23\u0274\13\23\3\23\3\23\5\23\u0278\n\23\3\23\3\23"+
		"\3\23\3\23\5\23\u027e\n\23\3\23\3\23\3\23\7\23\u0283\n\23\f\23\16\23\u0286"+
		"\13\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u028e\n\23\3\23\3\23\3\23\7"+
		"\23\u0293\n\23\f\23\16\23\u0296\13\23\3\23\3\23\3\23\3\23\3\23\3\23\5"+
		"\23\u029e\n\23\3\23\3\23\3\23\7\23\u02a3\n\23\f\23\16\23\u02a6\13\23\3"+
		"\23\3\23\3\23\3\23\3\23\5\23\u02ad\n\23\3\24\3\24\3\24\7\24\u02b2\n\24"+
		"\f\24\16\24\u02b5\13\24\3\25\3\25\3\25\7\25\u02ba\n\25\f\25\16\25\u02bd"+
		"\13\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u02c7\n\26\f\26\16"+
		"\26\u02ca\13\26\3\27\5\27\u02cd\n\27\3\27\3\27\3\27\7\27\u02d2\n\27\f"+
		"\27\16\27\u02d5\13\27\3\27\3\27\5\27\u02d9\n\27\3\27\3\27\3\27\3\27\3"+
		"\27\2\5\34\36 \30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\16"+
		"\3\2\27\30\3\2\24\25\3\2%&\3\2\'(\3\2)*\3\2+,\4\2\24\2688\4\2\64\64AA"+
		"\4\2\66\66BB\4\2\63\63CC\3\2DE\3\2FG\u034b\2/\3\2\2\2\4>\3\2\2\2\6R\3"+
		"\2\2\2\bT\3\2\2\2\no\3\2\2\2\fy\3\2\2\2\16\u00af\3\2\2\2\20\u00c7\3\2"+
		"\2\2\22\u00cc\3\2\2\2\24\u00ce\3\2\2\2\26\u00d0\3\2\2\2\30\u00d2\3\2\2"+
		"\2\32\u00d4\3\2\2\2\34\u01dc\3\2\2\2\36\u0214\3\2\2\2 \u024c\3\2\2\2\""+
		"\u0262\3\2\2\2$\u02ac\3\2\2\2&\u02ae\3\2\2\2(\u02b6\3\2\2\2*\u02c3\3\2"+
		"\2\2,\u02cc\3\2\2\2.\60\5\4\3\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61"+
		"\62\5\b\5\2\62\63\b\2\1\2\63\64\5\n\6\2\648\b\2\1\2\65\67\5\34\17\2\66"+
		"\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\b"+
		"\2\1\2<=\b\2\1\2=\3\3\2\2\2>?\7\3\2\2?@\7\4\2\2@A\5\6\4\2AB\7\5\2\2BC"+
		"\5\6\4\2CD\3\2\2\2DE\7\6\2\2E\5\3\2\2\2FG\7\7\2\2GH\7\b\2\2HS\5\30\r\2"+
		"IJ\7\t\2\2JK\7\b\2\2KS\5\30\r\2LM\7\n\2\2MN\7\b\2\2NS\5\30\r\2OP\7\13"+
		"\2\2PQ\7\b\2\2QS\5\30\r\2RF\3\2\2\2RI\3\2\2\2RL\3\2\2\2RO\3\2\2\2S\7\3"+
		"\2\2\2Tk\7\f\2\2UV\7\4\2\2V[\5\22\n\2WX\7\5\2\2XZ\5\22\n\2YW\3\2\2\2Z"+
		"]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7\6\2\2_l\3\2\2"+
		"\2`a\7\r\2\2af\5\22\n\2bc\7\5\2\2ce\5\22\n\2db\3\2\2\2eh\3\2\2\2fd\3\2"+
		"\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7\16\2\2jl\3\2\2\2kU\3\2\2\2k`\3"+
		"\2\2\2lm\3\2\2\2mn\b\5\1\2n\t\3\2\2\2op\7\17\2\2pt\7\4\2\2qs\5\f\7\2r"+
		"q\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\7\6\2\2"+
		"x\13\3\2\2\2y{\5\24\13\2z|\5\32\16\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}\177"+
		"\7\b\2\2~\u0080\5\36\20\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0082\7\r\2\2\u0082\u0085\5\16\b\2\u0083\u0084\7\5\2\2\u0084"+
		"\u0086\5\16\b\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3"+
		"\2\2\2\u0087\u0088\7\16\2\2\u0088\u0089\3\2\2\2\u0089\u008a\b\7\1\2\u008a"+
		"\r\3\2\2\2\u008b\u0094\7\4\2\2\u008c\u0091\5\20\t\2\u008d\u008e\7\5\2"+
		"\2\u008e\u0090\5\20\t\2\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0094\u008c\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u00b0\7\6\2\2\u0097\u00a0\7\r\2\2\u0098\u009d\5\20\t\2\u0099\u009a\7"+
		"\5\2\2\u009a\u009c\5\20\t\2\u009b\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u00a0\u0098\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00b0\7\16\2\2\u00a3\u00a4\7\4\2\2\u00a4\u00a5\5\20\t\2\u00a5\u00a6\7"+
		"\20\2\2\u00a6\u00a7\5\20\t\2\u00a7\u00a8\7\6\2\2\u00a8\u00b0\3\2\2\2\u00a9"+
		"\u00aa\7\r\2\2\u00aa\u00ab\5\20\t\2\u00ab\u00ac\7\20\2\2\u00ac\u00ad\5"+
		"\20\t\2\u00ad\u00ae\7\16\2\2\u00ae\u00b0\3\2\2\2\u00af\u008b\3\2\2\2\u00af"+
		"\u0097\3\2\2\2\u00af\u00a3\3\2\2\2\u00af\u00a9\3\2\2\2\u00b0\17\3\2\2"+
		"\2\u00b1\u00b2\7\21\2\2\u00b2\u00b7\5\22\n\2\u00b3\u00b4\7\5\2\2\u00b4"+
		"\u00b6\5\22\n\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bb\7\22\2\2\u00bb\u00c8\3\2\2\2\u00bc\u00bd\7\r\2\2\u00bd\u00c2\5"+
		"\22\n\2\u00be\u00bf\7\5\2\2\u00bf\u00c1\5\22\n\2\u00c0\u00be\3\2\2\2\u00c1"+
		"\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2"+
		"\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\7\16\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00b1\3\2\2\2\u00c7\u00bc\3\2\2\2\u00c8\21\3\2\2\2\u00c9\u00ca\7J\2\2"+
		"\u00ca\u00cd\b\n\1\2\u00cb\u00cd\7I\2\2\u00cc\u00c9\3\2\2\2\u00cc\u00cb"+
		"\3\2\2\2\u00cd\23\3\2\2\2\u00ce\u00cf\7J\2\2\u00cf\25\3\2\2\2\u00d0\u00d1"+
		"\7J\2\2\u00d1\27\3\2\2\2\u00d2\u00d3\7I\2\2\u00d3\31\3\2\2\2\u00d4\u00d5"+
		"\7I\2\2\u00d5\33\3\2\2\2\u00d6\u00d7\b\17\1\2\u00d7\u00d8\t\2\2\2\u00d8"+
		"\u01dd\5\34\17\20\u00d9\u00da\7\23\2\2\u00da\u01dd\5\36\20\2\u00db\u00dc"+
		"\7\24\2\2\u00dc\u01dd\5\36\20\2\u00dd\u00de\7\25\2\2\u00de\u01dd\5\36"+
		"\20\2\u00df\u00e0\7\26\2\2\u00e0\u01dd\5\36\20\2\u00e1\u00e3\5\36\20\2"+
		"\u00e2\u00e4\t\2\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e6\7\31\2\2\u00e6\u00e7\5\36\20\2\u00e7\u01dd\3\2\2"+
		"\2\u00e8\u00ea\5\36\20\2\u00e9\u00eb\t\2\2\2\u00ea\u00e9\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\7\32\2\2\u00ed\u00ee\5"+
		"\36\20\2\u00ee\u01dd\3\2\2\2\u00ef\u00f1\5 \21\2\u00f0\u00f2\t\2\2\2\u00f1"+
		"\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7\32"+
		"\2\2\u00f4\u00f5\5 \21\2\u00f5\u01dd\3\2\2\2\u00f6\u00f8\5 \21\2\u00f7"+
		"\u00f9\t\2\2\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fb\7\33\2\2\u00fb\u00fc\5 \21\2\u00fc\u01dd\3\2\2\2\u00fd"+
		"\u00ff\5 \21\2\u00fe\u0100\t\2\2\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101\u0102\7\34\2\2\u0102\u0103\5 \21\2\u0103"+
		"\u01dd\3\2\2\2\u0104\u0106\5 \21\2\u0105\u0107\t\2\2\2\u0106\u0105\3\2"+
		"\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7\35\2\2\u0109"+
		"\u010a\5 \21\2\u010a\u01dd\3\2\2\2\u010b\u010d\5 \21\2\u010c\u010e\t\2"+
		"\2\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0110\7\36\2\2\u0110\u0111\5 \21\2\u0111\u01dd\3\2\2\2\u0112\u0113\b"+
		"\17\1\2\u0113\u0114\7\37\2\2\u0114\u0115\5\"\22\2\u0115\u0116\7 \2\2\u0116"+
		"\u0117\5 \21\2\u0117\u0118\3\2\2\2\u0118\u0119\b\17\1\2\u0119\u01dd\3"+
		"\2\2\2\u011a\u011b\7!\2\2\u011b\u011c\7\r\2\2\u011c\u011d\5\24\13\2\u011d"+
		"\u011e\7\16\2\2\u011e\u01dd\3\2\2\2\u011f\u0120\7\"\2\2\u0120\u0121\7"+
		"\r\2\2\u0121\u0122\5\24\13\2\u0122\u0123\7\b\2\2\u0123\u0124\5\36\20\2"+
		"\u0124\u0125\7#\2\2\u0125\u0126\t\3\2\2\u0126\u0127\5\36\20\2\u0127\u0128"+
		"\7\16\2\2\u0128\u01dd\3\2\2\2\u0129\u012a\7$\2\2\u012a\u012b\7\r\2\2\u012b"+
		"\u012c\5\24\13\2\u012c\u012d\7\5\2\2\u012d\u012e\5\24\13\2\u012e\u012f"+
		"\7\5\2\2\u012f\u0130\5\24\13\2\u0130\u0131\7\5\2\2\u0131\u0132\5\24\13"+
		"\2\u0132\u0133\7\16\2\2\u0133\u01dd\3\2\2\2\u0134\u0135\b\17\1\2\u0135"+
		"\u0136\7-\2\2\u0136\u014b\5\"\22\2\u0137\u0141\7 \2\2\u0138\u0142\5\34"+
		"\17\2\u0139\u013d\7\4\2\2\u013a\u013c\5\34\17\2\u013b\u013a\3\2\2\2\u013c"+
		"\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0140\3\2"+
		"\2\2\u013f\u013d\3\2\2\2\u0140\u0142\7\6\2\2\u0141\u0138\3\2\2\2\u0141"+
		"\u0139\3\2\2\2\u0142\u014c\3\2\2\2\u0143\u0147\7\4\2\2\u0144\u0146\5\34"+
		"\17\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014c\7\6"+
		"\2\2\u014b\u0137\3\2\2\2\u014b\u0143\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u014e\b\17\1\2\u014e\u01dd\3\2\2\2\u014f\u0150\b\17\1\2\u0150\u0151\7"+
		"\26\2\2\u0151\u0166\5\"\22\2\u0152\u015c\7 \2\2\u0153\u015d\5\34\17\2"+
		"\u0154\u0158\7\4\2\2\u0155\u0157\5\34\17\2\u0156\u0155\3\2\2\2\u0157\u015a"+
		"\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015b\u015d\7\6\2\2\u015c\u0153\3\2\2\2\u015c\u0154\3\2"+
		"\2\2\u015d\u0167\3\2\2\2\u015e\u0162\7\4\2\2\u015f\u0161\5\34\17\2\u0160"+
		"\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0167\7\6\2\2\u0166"+
		"\u0152\3\2\2\2\u0166\u015e\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\b\17"+
		"\1\2\u0169\u01dd\3\2\2\2\u016a\u016b\b\17\1\2\u016b\u016c\7\23\2\2\u016c"+
		"\u0181\5\"\22\2\u016d\u0177\7 \2\2\u016e\u0178\5\34\17\2\u016f\u0173\7"+
		"\4\2\2\u0170\u0172\5\34\17\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173"+
		"\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0176\3\2\2\2\u0175\u0173\3\2"+
		"\2\2\u0176\u0178\7\6\2\2\u0177\u016e\3\2\2\2\u0177\u016f\3\2\2\2\u0178"+
		"\u0182\3\2\2\2\u0179\u017d\7\4\2\2\u017a\u017c\5\34\17\2\u017b\u017a\3"+
		"\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u0180\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0182\7\6\2\2\u0181\u016d\3\2"+
		"\2\2\u0181\u0179\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0184\b\17\1\2\u0184"+
		"\u01dd\3\2\2\2\u0185\u0186\b\17\1\2\u0186\u0187\7\25\2\2\u0187\u019c\5"+
		"\"\22\2\u0188\u0192\7 \2\2\u0189\u0193\5\34\17\2\u018a\u018e\7\4\2\2\u018b"+
		"\u018d\5\34\17\2\u018c\u018b\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3"+
		"\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190\u018e\3\2\2\2\u0191"+
		"\u0193\7\6\2\2\u0192\u0189\3\2\2\2\u0192\u018a\3\2\2\2\u0193\u019d\3\2"+
		"\2\2\u0194\u0198\7\4\2\2\u0195\u0197\5\34\17\2\u0196\u0195\3\2\2\2\u0197"+
		"\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019b\3\2"+
		"\2\2\u019a\u0198\3\2\2\2\u019b\u019d\7\6\2\2\u019c\u0188\3\2\2\2\u019c"+
		"\u0194\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\b\17\1\2\u019f\u01dd\3"+
		"\2\2\2\u01a0\u01a1\b\17\1\2\u01a1\u01a2\7\24\2\2\u01a2\u01b7\5\"\22\2"+
		"\u01a3\u01ad\7 \2\2\u01a4\u01ae\5\34\17\2\u01a5\u01a9\7\4\2\2\u01a6\u01a8"+
		"\5\34\17\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2"+
		"\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ae"+
		"\7\6\2\2\u01ad\u01a4\3\2\2\2\u01ad\u01a5\3\2\2\2\u01ae\u01b8\3\2\2\2\u01af"+
		"\u01b3\7\4\2\2\u01b0\u01b2\5\34\17\2\u01b1\u01b0\3\2\2\2\u01b2\u01b5\3"+
		"\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5"+
		"\u01b3\3\2\2\2\u01b6\u01b8\7\6\2\2\u01b7\u01a3\3\2\2\2\u01b7\u01af\3\2"+
		"\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\b\17\1\2\u01ba\u01dd\3\2\2\2\u01bb"+
		"\u01bc\b\17\1\2\u01bc\u01bd\7.\2\2\u01bd\u01d2\5&\24\2\u01be\u01c8\7 "+
		"\2\2\u01bf\u01c9\5\34\17\2\u01c0\u01c4\7\4\2\2\u01c1\u01c3\5\34\17\2\u01c2"+
		"\u01c1\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c9\7\6\2\2\u01c8"+
		"\u01bf\3\2\2\2\u01c8\u01c0\3\2\2\2\u01c9\u01d3\3\2\2\2\u01ca\u01ce\7\4"+
		"\2\2\u01cb\u01cd\5\34\17\2\u01cc\u01cb\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce"+
		"\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0\u01ce\3\2"+
		"\2\2\u01d1\u01d3\7\6\2\2\u01d2\u01be\3\2\2\2\u01d2\u01ca\3\2\2\2\u01d3"+
		"\u01d4\3\2\2\2\u01d4\u01d5\b\17\1\2\u01d5\u01dd\3\2\2\2\u01d6\u01dd\7"+
		"/\2\2\u01d7\u01dd\7\60\2\2\u01d8\u01d9\7\21\2\2\u01d9\u01da\5\34\17\2"+
		"\u01da\u01db\7\22\2\2\u01db\u01dd\3\2\2\2\u01dc\u00d6\3\2\2\2\u01dc\u00d9"+
		"\3\2\2\2\u01dc\u00db\3\2\2\2\u01dc\u00dd\3\2\2\2\u01dc\u00df\3\2\2\2\u01dc"+
		"\u00e1\3\2\2\2\u01dc\u00e8\3\2\2\2\u01dc\u00ef\3\2\2\2\u01dc\u00f6\3\2"+
		"\2\2\u01dc\u00fd\3\2\2\2\u01dc\u0104\3\2\2\2\u01dc\u010b\3\2\2\2\u01dc"+
		"\u0112\3\2\2\2\u01dc\u011a\3\2\2\2\u01dc\u011f\3\2\2\2\u01dc\u0129\3\2"+
		"\2\2\u01dc\u0134\3\2\2\2\u01dc\u014f\3\2\2\2\u01dc\u016a\3\2\2\2\u01dc"+
		"\u0185\3\2\2\2\u01dc\u01a0\3\2\2\2\u01dc\u01bb\3\2\2\2\u01dc\u01d6\3\2"+
		"\2\2\u01dc\u01d7\3\2\2\2\u01dc\u01d8\3\2\2\2\u01dd\u01ec\3\2\2\2\u01de"+
		"\u01df\f\17\2\2\u01df\u01e0\t\4\2\2\u01e0\u01eb\5\34\17\17\u01e1\u01e2"+
		"\f\16\2\2\u01e2\u01e3\t\5\2\2\u01e3\u01eb\5\34\17\16\u01e4\u01e5\f\r\2"+
		"\2\u01e5\u01e6\t\6\2\2\u01e6\u01eb\5\34\17\r\u01e7\u01e8\f\f\2\2\u01e8"+
		"\u01e9\t\7\2\2\u01e9\u01eb\5\34\17\f\u01ea\u01de\3\2\2\2\u01ea\u01e1\3"+
		"\2\2\2\u01ea\u01e4\3\2\2\2\u01ea\u01e7\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec"+
		"\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\35\3\2\2\2\u01ee\u01ec\3\2\2"+
		"\2\u01ef\u01f0\b\20\1\2\u01f0\u01f1\7\61\2\2\u01f1\u0215\5\36\20\23\u01f2"+
		"\u01f3\7\62\2\2\u01f3\u0215\5\36\20\22\u01f4\u01f5\7\63\2\2\u01f5\u0215"+
		"\5\36\20\21\u01f6\u01f7\t\6\2\2\u01f7\u01f8\5\34\17\2\u01f8\u01f9\7:\2"+
		"\2\u01f9\u01fa\5\36\20\2\u01fa\u01fb\7;\2\2\u01fb\u01fc\5\36\20\b\u01fc"+
		"\u0215\3\2\2\2\u01fd\u01fe\6\20\6\2\u01fe\u01ff\5\26\f\2\u01ff\u0200\b"+
		"\20\1\2\u0200\u0215\3\2\2\2\u0201\u0202\6\20\7\2\u0202\u0215\5\24\13\2"+
		"\u0203\u0204\b\20\1\2\u0204\u0205\7\4\2\2\u0205\u0206\5*\26\2\u0206\u0207"+
		"\7 \2\2\u0207\u0208\5\34\17\2\u0208\u0209\7\6\2\2\u0209\u020a\3\2\2\2"+
		"\u020a\u020b\b\20\1\2\u020b\u0215\3\2\2\2\u020c\u0215\7<\2\2\u020d\u0215"+
		"\7=\2\2\u020e\u0215\7>\2\2\u020f\u0215\7?\2\2\u0210\u0211\7\21\2\2\u0211"+
		"\u0212\5\36\20\2\u0212\u0213\7\22\2\2\u0213\u0215\3\2\2\2\u0214\u01ef"+
		"\3\2\2\2\u0214\u01f2\3\2\2\2\u0214\u01f4\3\2\2\2\u0214\u01f6\3\2\2\2\u0214"+
		"\u01fd\3\2\2\2\u0214\u0201\3\2\2\2\u0214\u0203\3\2\2\2\u0214\u020c\3\2"+
		"\2\2\u0214\u020d\3\2\2\2\u0214\u020e\3\2\2\2\u0214\u020f\3\2\2\2\u0214"+
		"\u0210\3\2\2\2\u0215\u0235\3\2\2\2\u0216\u0217\f\20\2\2\u0217\u0218\7"+
		"\64\2\2\u0218\u0234\5\36\20\21\u0219\u021a\f\17\2\2\u021a\u021b\7\65\2"+
		"\2\u021b\u0234\5\36\20\20\u021c\u021d\f\16\2\2\u021d\u021e\7\66\2\2\u021e"+
		"\u0234\5\36\20\17\u021f\u0220\f\r\2\2\u0220\u0221\7\67\2\2\u0221\u0234"+
		"\5\36\20\16\u0222\u0224\f\13\2\2\u0223\u0225\t\b\2\2\u0224\u0223\3\2\2"+
		"\2\u0224\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0228\7#\2\2\u0227\u0229"+
		"\t\b\2\2\u0228\u0227\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022a\3\2\2\2\u022a"+
		"\u0234\5\36\20\13\u022b\u022c\f\n\2\2\u022c\u022d\79\2\2\u022d\u0234\5"+
		"\36\20\13\u022e\u022f\f\f\2\2\u022f\u0230\7\r\2\2\u0230\u0231\5\36\20"+
		"\2\u0231\u0232\7\16\2\2\u0232\u0234\3\2\2\2\u0233\u0216\3\2\2\2\u0233"+
		"\u0219\3\2\2\2\u0233\u021c\3\2\2\2\u0233\u021f\3\2\2\2\u0233\u0222\3\2"+
		"\2\2\u0233\u022b\3\2\2\2\u0233\u022e\3\2\2\2\u0234\u0237\3\2\2\2\u0235"+
		"\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236\37\3\2\2\2\u0237\u0235\3\2\2"+
		"\2\u0238\u0239\b\21\1\2\u0239\u023a\t\6\2\2\u023a\u023b\5\34\17\2\u023b"+
		"\u023c\7:\2\2\u023c\u023d\5 \21\2\u023d\u023e\7;\2\2\u023e\u023f\5 \21"+
		"\f\u023f\u024d\3\2\2\2\u0240\u0241\7\37\2\2\u0241\u024d\5\36\20\2\u0242"+
		"\u0243\7@\2\2\u0243\u024d\5\36\20\2\u0244\u0246\7\66\2\2\u0245\u0244\3"+
		"\2\2\2\u0245\u0246\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u024d\5\30\r\2\u0248"+
		"\u0249\7\21\2\2\u0249\u024a\5 \21\2\u024a\u024b\7\22\2\2\u024b\u024d\3"+
		"\2\2\2\u024c\u0238\3\2\2\2\u024c\u0240\3\2\2\2\u024c\u0242\3\2\2\2\u024c"+
		"\u0245\3\2\2\2\u024c\u0248\3\2\2\2\u024d\u025f\3\2\2\2\u024e\u024f\f\t"+
		"\2\2\u024f\u0250\t\t\2\2\u0250\u025e\5 \21\n\u0251\u0252\f\b\2\2\u0252"+
		"\u0253\t\n\2\2\u0253\u025e\5 \21\t\u0254\u0255\f\7\2\2\u0255\u0256\t\13"+
		"\2\2\u0256\u025e\5 \21\b\u0257\u0258\f\6\2\2\u0258\u0259\t\f\2\2\u0259"+
		"\u025e\5 \21\7\u025a\u025b\f\5\2\2\u025b\u025c\t\r\2\2\u025c\u025e\5 "+
		"\21\6\u025d\u024e\3\2\2\2\u025d\u0251\3\2\2\2\u025d\u0254\3\2\2\2\u025d"+
		"\u0257\3\2\2\2\u025d\u025a\3\2\2\2\u025e\u0261\3\2\2\2\u025f\u025d\3\2"+
		"\2\2\u025f\u0260\3\2\2\2\u0260!\3\2\2\2\u0261\u025f\3\2\2\2\u0262\u0267"+
		"\5$\23\2\u0263\u0264\7\5\2\2\u0264\u0266\5$\23\2\u0265\u0263\3\2\2\2\u0266"+
		"\u0269\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268#\3\2\2\2"+
		"\u0269\u0267\3\2\2\2\u026a\u026c\7H\2\2\u026b\u026a\3\2\2\2\u026b\u026c"+
		"\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u0272\5\26\f\2\u026e\u026f\7\5\2\2"+
		"\u026f\u0271\5\26\f\2\u0270\u026e\3\2\2\2\u0271\u0274\3\2\2\2\u0272\u0270"+
		"\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0275\3\2\2\2\u0274\u0272\3\2\2\2\u0275"+
		"\u0277\7\b\2\2\u0276\u0278\7\25\2\2\u0277\u0276\3\2\2\2\u0277\u0278\3"+
		"\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\5\36\20\2\u027a\u027b\b\23\1\2"+
		"\u027b\u02ad\3\2\2\2\u027c\u027e\7H\2\2\u027d\u027c\3\2\2\2\u027d\u027e"+
		"\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0284\5\26\f\2\u0280\u0281\7\5\2\2"+
		"\u0281\u0283\5\26\f\2\u0282\u0280\3\2\2\2\u0283\u0286\3\2\2\2\u0284\u0282"+
		"\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0287\3\2\2\2\u0286\u0284\3\2\2\2\u0287"+
		"\u0288\7\b\2\2\u0288\u0289\7\24\2\2\u0289\u028a\5\36\20\2\u028a\u028b"+
		"\b\23\1\2\u028b\u02ad\3\2\2\2\u028c\u028e\7H\2\2\u028d\u028c\3\2\2\2\u028d"+
		"\u028e\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0294\5\26\f\2\u0290\u0291\7"+
		"\5\2\2\u0291\u0293\5\26\f\2\u0292\u0290\3\2\2\2\u0293\u0296\3\2\2\2\u0294"+
		"\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0297\3\2\2\2\u0296\u0294\3\2"+
		"\2\2\u0297\u0298\7\b\2\2\u0298\u0299\7\26\2\2\u0299\u029a\5\36\20\2\u029a"+
		"\u029b\b\23\1\2\u029b\u02ad\3\2\2\2\u029c\u029e\7H\2\2\u029d\u029c\3\2"+
		"\2\2\u029d\u029e\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a4\5\26\f\2\u02a0"+
		"\u02a1\7\5\2\2\u02a1\u02a3\5\26\f\2\u02a2\u02a0\3\2\2\2\u02a3\u02a6\3"+
		"\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7\3\2\2\2\u02a6"+
		"\u02a4\3\2\2\2\u02a7\u02a8\7\b\2\2\u02a8\u02a9\78\2\2\u02a9\u02aa\5\36"+
		"\20\2\u02aa\u02ab\b\23\1\2\u02ab\u02ad\3\2\2\2\u02ac\u026b\3\2\2\2\u02ac"+
		"\u027d\3\2\2\2\u02ac\u028d\3\2\2\2\u02ac\u029d\3\2\2\2\u02ad%\3\2\2\2"+
		"\u02ae\u02b3\5(\25\2\u02af\u02b0\7\5\2\2\u02b0\u02b2\5(\25\2\u02b1\u02af"+
		"\3\2\2\2\u02b2\u02b5\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4"+
		"\'\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b6\u02bb\5\26\f\2\u02b7\u02b8\7\5\2"+
		"\2\u02b8\u02ba\5\26\f\2\u02b9\u02b7\3\2\2\2\u02ba\u02bd\3\2\2\2\u02bb"+
		"\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02be\3\2\2\2\u02bd\u02bb\3\2"+
		"\2\2\u02be\u02bf\7\32\2\2\u02bf\u02c0\5\36\20\2\u02c0\u02c1\3\2\2\2\u02c1"+
		"\u02c2\b\25\1\2\u02c2)\3\2\2\2\u02c3\u02c8\5,\27\2\u02c4\u02c5\7\5\2\2"+
		"\u02c5\u02c7\5,\27\2\u02c6\u02c4\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8\u02c6"+
		"\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9+\3\2\2\2\u02ca\u02c8\3\2\2\2\u02cb"+
		"\u02cd\7H\2\2\u02cc\u02cb\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02ce\3\2"+
		"\2\2\u02ce\u02d3\5\26\f\2\u02cf\u02d0\7\5\2\2\u02d0\u02d2\5\26\f\2\u02d1"+
		"\u02cf\3\2\2\2\u02d2\u02d5\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2"+
		"\2\2\u02d4\u02d6\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d6\u02d8\7\b\2\2\u02d7"+
		"\u02d9\7\25\2\2\u02d8\u02d7\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\3"+
		"\2\2\2\u02da\u02db\5\36\20\2\u02db\u02dc\3\2\2\2\u02dc\u02dd\b\27\1\2"+
		"\u02dd-\3\2\2\2Q/8R[fkt{\177\u0085\u0091\u0094\u009d\u00a0\u00af\u00b7"+
		"\u00c2\u00c7\u00cc\u00e3\u00ea\u00f1\u00f8\u00ff\u0106\u010d\u013d\u0141"+
		"\u0147\u014b\u0158\u015c\u0162\u0166\u0173\u0177\u017d\u0181\u018e\u0192"+
		"\u0198\u019c\u01a9\u01ad\u01b3\u01b7\u01c4\u01c8\u01ce\u01d2\u01dc\u01ea"+
		"\u01ec\u0214\u0224\u0228\u0233\u0235\u0245\u024c\u025d\u025f\u0267\u026b"+
		"\u0272\u0277\u027d\u0284\u028d\u0294\u029d\u02a4\u02ac\u02b3\u02bb\u02c8"+
		"\u02cc\u02d3\u02d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}