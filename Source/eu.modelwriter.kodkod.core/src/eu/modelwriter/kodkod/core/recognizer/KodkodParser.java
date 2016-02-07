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
		RULE_relBound = 4, RULE_tupleSet = 5, RULE_tuple = 6, RULE_atom = 7, RULE_relation = 8, 
		RULE_variable = 9, RULE_integer = 10, RULE_arity = 11, RULE_formula = 12, 
		RULE_expression = 13, RULE_intexpression = 14, RULE_decls = 15, RULE_decl = 16, 
		RULE_letDecls = 17, RULE_letDecl = 18, RULE_comprehensionDecls = 19, RULE_comprehensionDecl = 20;
	public static final String[] ruleNames = {
		"problem", "options", "option", "universe", "relBound", "tupleSet", "tuple", 
		"atom", "relation", "variable", "integer", "arity", "formula", "expression", 
		"intexpression", "decls", "decl", "letDecls", "letDecl", "comprehensionDecls", 
		"comprehensionDecl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Relations'", "'{'", "'}'", "'options'", "','", "'symmetry_breaking'", 
		"':'", "'bit_width'", "'skolem_depth'", "'sharing'", "'universe'", "'['", 
		"']'", "'..'", "'('", "')'", "'no'", "'lone'", "'one'", "'some'", "'!'", 
		"'not'", "'in'", "'='", "'<'", "'<='", "'>'", "'>='", "'sum'", "'|'", 
		"'acyclic'", "'function'", "'->'", "'ord'", "'&&'", "'and'", "'||'", "'or'", 
		"'=>'", "'if'", "'<=>'", "'iff'", "'all'", "'let'", "'true'", "'false'", 
		"'~'", "'^'", "'*'", "'+'", "'&'", "'-'", "'.'", "'++'", "'then'", "'else'", 
		"'iden'", "'none'", "'univ'", "'ints'", "'#'", "'plus'", "'minus'", "'mul'", 
		"'/'", "'div'", "'%'", "'modulo'", "'disj'", "'set'", null, null, null, 
		"'''"
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
	    private int declareVariables(java.util.List<VariableContext> vars, int var) {
	        System.out.println("Quantifier context: ");
	        for (VariableContext vc : vars) {
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
		public OptionsContext options() {
			return getRuleContext(OptionsContext.class,0);
		}
		public List<RelBoundContext> relBound() {
			return getRuleContexts(RelBoundContext.class);
		}
		public RelBoundContext relBound(int i) {
			return getRuleContext(RelBoundContext.class,i);
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
			setState(43);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(42);
				options();
				}
			}

			setState(45);
			universe();
			System.out.println(universe);
			setState(47);
			match(T__0);
			setState(48);
			match(T__1);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(49);
				relBound();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(T__2);
			System.out.println(bounds);
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(57);
					((ProblemContext)_localctx).formula = formula(0);
					((ProblemContext)_localctx).formulas.add(((ProblemContext)_localctx).formula);
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
			setState(66);
			match(T__3);
			setState(67);
			match(T__1);
			setState(68);
			option();
			{
			setState(69);
			match(T__4);
			setState(70);
			option();
			}
			setState(72);
			match(T__2);
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
			setState(86);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(T__5);
				setState(75);
				match(T__6);
				setState(76);
				integer();
				}
				break;
			case T__7:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__7);
				setState(78);
				match(T__6);
				setState(79);
				integer();
				}
				break;
			case T__8:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(T__8);
				setState(81);
				match(T__6);
				setState(82);
				integer();
				}
				break;
			case T__9:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				match(T__9);
				setState(84);
				match(T__6);
				setState(85);
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
			setState(111);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(88);
				match(T__10);
				{
				setState(89);
				match(T__1);
				{
				setState(90);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(91);
					match(T__4);
					setState(92);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(98);
				match(T__2);
				}
				}
				break;
			case T__11:
				{
				{
				setState(100);
				match(T__11);
				{
				setState(101);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(102);
					match(T__4);
					setState(103);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(109);
				match(T__12);
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

	public static class RelBoundContext extends ParserRuleContext {
		public RelationContext relation;
		public ArityContext arity;
		public TupleSetContext lowerBound;
		public TupleSetContext upperBound;
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public ArityContext arity() {
			return getRuleContext(ArityContext.class,0);
		}
		public List<TupleSetContext> tupleSet() {
			return getRuleContexts(TupleSetContext.class);
		}
		public TupleSetContext tupleSet(int i) {
			return getRuleContext(TupleSetContext.class,i);
		}
		public RelBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterRelBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitRelBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitRelBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelBoundContext relBound() throws RecognitionException {
		RelBoundContext _localctx = new RelBoundContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_relBound);
		context="relBound";
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(115);
			((RelBoundContext)_localctx).relation = relation();
			setState(116);
			match(T__6);
			setState(118);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(117);
				((RelBoundContext)_localctx).arity = arity();
				}
			}

			setState(120);
			match(T__11);
			{
			setState(121);
			((RelBoundContext)_localctx).lowerBound = tupleSet();
			setState(124);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(122);
				match(T__4);
				setState(123);
				((RelBoundContext)_localctx).upperBound = tupleSet();
				}
			}

			}
			setState(126);
			match(T__12);
			}

			    String name = (((RelBoundContext)_localctx).relation!=null?_input.getText(((RelBoundContext)_localctx).relation.start,((RelBoundContext)_localctx).relation.stop):null);
			    System.out.println("relation " + name);
			    if (relations.containsKey(name)) {System.err.println("duplicated relation found: '"+ name + "' at "+ getLocation());}

			    kodkod.ast.Relation relation = null;
			    int arity = 0;
			    if ((((RelBoundContext)_localctx).arity!=null?_input.getText(((RelBoundContext)_localctx).arity.start,((RelBoundContext)_localctx).arity.stop):null) != null && !(((RelBoundContext)_localctx).arity!=null?_input.getText(((RelBoundContext)_localctx).arity.start,((RelBoundContext)_localctx).arity.stop):null).isEmpty()) {arity = Integer.parseInt((((RelBoundContext)_localctx).arity!=null?_input.getText(((RelBoundContext)_localctx).arity.start,((RelBoundContext)_localctx).arity.stop):null));}

			    kodkod.instance.TupleSet lowerBound = null;
			    java.util.List<kodkod.instance.Tuple> tuplesInLowerBound = new java.util.ArrayList<kodkod.instance.Tuple>();
			    if (((RelBoundContext)_localctx).lowerBound != null && !((RelBoundContext)_localctx).lowerBound.tuples.isEmpty()){
			        if (arity == 0) {arity = ((RelBoundContext)_localctx).lowerBound.tuples.get(0).atoms.size();}
			        for (TupleContext tuple : ((RelBoundContext)_localctx).lowerBound.tuples) {
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
			    if (((RelBoundContext)_localctx).upperBound != null && !((RelBoundContext)_localctx).upperBound.tuples.isEmpty()){
			        if (lowerBound == null && arity == 0) {arity = ((RelBoundContext)_localctx).upperBound.tuples.get(0).atoms.size();}
			        for (TupleContext tuple : ((RelBoundContext)_localctx).upperBound.tuples) {
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
		enterRule(_localctx, 10, RULE_tupleSet);
		int _la;
		try {
			setState(166);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(T__1);
				setState(139);
				_la = _input.LA(1);
				if (_la==T__11 || _la==T__14) {
					{
					setState(131);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(132);
						match(T__4);
						setState(133);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(138);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(141);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(T__11);
				setState(151);
				_la = _input.LA(1);
				if (_la==T__11 || _la==T__14) {
					{
					setState(143);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(144);
						match(T__4);
						setState(145);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(150);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(153);
				match(T__12);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				match(T__1);
				setState(155);
				((TupleSetContext)_localctx).left = tuple();
				setState(156);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(157);
				((TupleSetContext)_localctx).right = tuple();
				setState(158);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				match(T__11);
				setState(161);
				((TupleSetContext)_localctx).left = tuple();
				setState(162);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(163);
				((TupleSetContext)_localctx).right = tuple();
				setState(164);
				match(T__12);
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
		enterRule(_localctx, 12, RULE_tuple);
		int _la;
		try {
			setState(190);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(T__14);
				setState(169);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(170);
					match(T__4);
					setState(171);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(177);
				match(T__15);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(T__11);
				setState(180);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(181);
					match(T__4);
					setState(182);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(188);
				match(T__12);
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
		enterRule(_localctx, 14, RULE_atom);
		try {
			setState(195);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
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
				setState(194);
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

	public static class RelationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(KodkodParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 16, RULE_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(KodkodParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodkodListener ) ((KodkodListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KodkodVisitor ) return ((KodkodVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
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
		enterRule(_localctx, 20, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
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
		enterRule(_localctx, 22, RULE_arity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
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
		public RelationContext rel;
		public ExpressionContext domain;
		public Token op;
		public ExpressionContext range;
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
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
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
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
		public RelationContext rel;
		public RelationContext ordered;
		public RelationContext first;
		public RelationContext last;
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(206);
				((NotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__21) ) {
					((NotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(207);
				formula(14);
				}
				break;
			case 2:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(T__16);
				setState(209);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(T__17);
				setState(211);
				expression(0);
				}
				break;
			case 4:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(T__18);
				setState(213);
				expression(0);
				}
				break;
			case 5:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(T__19);
				setState(215);
				expression(0);
				}
				break;
			case 6:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				((InContext)_localctx).left = expression(0);
				setState(218);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(217);
					((InContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((InContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(220);
				match(T__22);
				setState(221);
				((InContext)_localctx).right = expression(0);
				}
				break;
			case 7:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				((EqualContext)_localctx).left = expression(0);
				setState(225);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(224);
					((EqualContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((EqualContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(227);
				match(T__23);
				setState(228);
				((EqualContext)_localctx).right = expression(0);
				}
				break;
			case 8:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				((EqContext)_localctx).left = intexpression(0);
				setState(232);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(231);
					((EqContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((EqContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(234);
				match(T__23);
				setState(235);
				((EqContext)_localctx).right = intexpression(0);
				}
				break;
			case 9:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				((LtContext)_localctx).left = intexpression(0);
				setState(239);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(238);
					((LtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((LtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(241);
				match(T__24);
				setState(242);
				((LtContext)_localctx).right = intexpression(0);
				}
				break;
			case 10:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				((LteContext)_localctx).left = intexpression(0);
				setState(246);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(245);
					((LteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((LteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(248);
				match(T__25);
				setState(249);
				((LteContext)_localctx).right = intexpression(0);
				}
				break;
			case 11:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				((GtContext)_localctx).left = intexpression(0);
				setState(253);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(252);
					((GtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((GtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(255);
				match(T__26);
				setState(256);
				((GtContext)_localctx).right = intexpression(0);
				}
				break;
			case 12:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				((GteContext)_localctx).left = intexpression(0);
				setState(260);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(259);
					((GteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
						((GteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(262);
				match(T__27);
				setState(263);
				((GteContext)_localctx).right = intexpression(0);
				}
				break;
			case 13:
				{
				_localctx = new SumDeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(12)).var =  0;
				{
				setState(266);
				match(T__28);
				setState(267);
				decls();
				setState(268);
				match(T__29);
				setState(269);
				intexpression(0);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(12)).var; i++) declarations.pop();
				}
				break;
			case 14:
				{
				_localctx = new AcyclicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				match(T__30);
				setState(274);
				match(T__11);
				setState(275);
				relation();
				setState(276);
				match(T__12);
				}
				break;
			case 15:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(T__31);
				setState(279);
				match(T__11);
				setState(280);
				((FunctionContext)_localctx).rel = relation();
				setState(281);
				match(T__6);
				setState(282);
				((FunctionContext)_localctx).domain = expression(0);
				setState(283);
				match(T__32);
				setState(284);
				((FunctionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
					((FunctionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(285);
				((FunctionContext)_localctx).range = expression(0);
				setState(286);
				match(T__12);
				}
				break;
			case 16:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				match(T__33);
				setState(289);
				match(T__11);
				setState(290);
				((TotalOrderContext)_localctx).rel = relation();
				setState(291);
				match(T__4);
				setState(292);
				((TotalOrderContext)_localctx).ordered = relation();
				setState(293);
				match(T__4);
				setState(294);
				((TotalOrderContext)_localctx).first = relation();
				setState(295);
				match(T__4);
				setState(296);
				((TotalOrderContext)_localctx).last = relation();
				setState(297);
				match(T__12);
				}
				break;
			case 17:
				{
				_localctx = new ForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(12)).var =  0;
				{
				setState(300);
				match(T__42);
				setState(301);
				decls();
				setState(322);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(302);
					match(T__29);
					setState(312);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						setState(303);
						formula(0);
						}
						break;
					case 2:
						{
						setState(304);
						match(T__1);
						setState(308);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(305);
								formula(0);
								}
								} 
							}
							setState(310);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						}
						setState(311);
						match(T__2);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(314);
					match(T__1);
					setState(318);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(315);
							formula(0);
							}
							} 
						}
						setState(320);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					}
					setState(321);
					match(T__2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(12)).var; i++) declarations.pop();
				}
				break;
			case 18:
				{
				_localctx = new ForSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(12)).var =  0;
				{
				setState(327);
				match(T__19);
				setState(328);
				decls();
				setState(349);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(329);
					match(T__29);
					setState(339);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						setState(330);
						formula(0);
						}
						break;
					case 2:
						{
						setState(331);
						match(T__1);
						setState(335);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(332);
								formula(0);
								}
								} 
							}
							setState(337);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
						}
						setState(338);
						match(T__2);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(341);
					match(T__1);
					setState(345);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(342);
							formula(0);
							}
							} 
						}
						setState(347);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
					}
					setState(348);
					match(T__2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(12)).var; i++) declarations.pop();
				}
				break;
			case 19:
				{
				_localctx = new ForNoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(12)).var =  0;
				{
				setState(354);
				match(T__16);
				setState(355);
				decls();
				setState(376);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(356);
					match(T__29);
					setState(366);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						setState(357);
						formula(0);
						}
						break;
					case 2:
						{
						setState(358);
						match(T__1);
						setState(362);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(359);
								formula(0);
								}
								} 
							}
							setState(364);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
						}
						setState(365);
						match(T__2);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(368);
					match(T__1);
					setState(372);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(369);
							formula(0);
							}
							} 
						}
						setState(374);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
					}
					setState(375);
					match(T__2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(12)).var; i++) declarations.pop();
				}
				break;
			case 20:
				{
				_localctx = new ForOneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(12)).var =  0;
				{
				setState(381);
				match(T__18);
				setState(382);
				decls();
				setState(403);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(383);
					match(T__29);
					setState(393);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						setState(384);
						formula(0);
						}
						break;
					case 2:
						{
						setState(385);
						match(T__1);
						setState(389);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(386);
								formula(0);
								}
								} 
							}
							setState(391);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
						}
						setState(392);
						match(T__2);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(395);
					match(T__1);
					setState(399);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(396);
							formula(0);
							}
							} 
						}
						setState(401);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
					}
					setState(402);
					match(T__2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(12)).var; i++) declarations.pop();
				}
				break;
			case 21:
				{
				_localctx = new ForLoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(12)).var =  0;
				{
				setState(408);
				match(T__17);
				setState(409);
				decls();
				setState(430);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(410);
					match(T__29);
					setState(420);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						setState(411);
						formula(0);
						}
						break;
					case 2:
						{
						setState(412);
						match(T__1);
						setState(416);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(413);
								formula(0);
								}
								} 
							}
							setState(418);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
						}
						setState(419);
						match(T__2);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(422);
					match(T__1);
					setState(426);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(423);
							formula(0);
							}
							} 
						}
						setState(428);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					}
					setState(429);
					match(T__2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(12)).var; i++) declarations.pop();
				}
				break;
			case 22:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(12)).var =  0;
				{
				setState(435);
				match(T__43);
				setState(436);
				letDecls();
				setState(457);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(437);
					match(T__29);
					setState(447);
					switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
					case 1:
						{
						setState(438);
						formula(0);
						}
						break;
					case 2:
						{
						setState(439);
						match(T__1);
						setState(443);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(440);
								formula(0);
								}
								} 
							}
							setState(445);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
						}
						setState(446);
						match(T__2);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(449);
					match(T__1);
					setState(453);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(450);
							formula(0);
							}
							} 
						}
						setState(455);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
					}
					setState(456);
					match(T__2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(12)).var; i++) declarations.pop();
				}
				break;
			case 23:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(461);
				match(T__44);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(462);
				match(T__45);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(463);
				match(T__14);
				setState(464);
				formula(0);
				setState(465);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(483);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(481);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(469);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(470);
						((AndContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
							((AndContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(471);
						((AndContext)_localctx).right = formula(13);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(472);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(473);
						((OrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
							((OrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(474);
						((OrContext)_localctx).right = formula(12);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(475);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(476);
						((ImpliesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__38 || _la==T__39) ) {
							((ImpliesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(477);
						((ImpliesContext)_localctx).right = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(478);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(479);
						((IffContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__40 || _la==T__41) ) {
							((IffContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(480);
						((IffContext)_localctx).right = formula(10);
						}
						break;
					}
					} 
				}
				setState(485);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
		public VariableContext variable;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(487);
				match(T__46);
				setState(488);
				expression(17);
				}
				break;
			case 2:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(489);
				match(T__47);
				setState(490);
				expression(16);
				}
				break;
			case 3:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(491);
				match(T__48);
				setState(492);
				expression(15);
				}
				break;
			case 4:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(493);
				((IfExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__38 || _la==T__39) ) {
					((IfExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(494);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(495);
				match(T__54);
				setState(496);
				((IfExpressionContext)_localctx).thenExpr = expression(0);
				setState(497);
				match(T__55);
				setState(498);
				((IfExpressionContext)_localctx).elseExpr = expression(6);
				}
				break;
			case 5:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(500);
				if (!(!isRelation())) throw new FailedPredicateException(this, "!isRelation()");
				setState(501);
				((VarContext)_localctx).variable = variable();

				        System.out.print("variable found: " + (((VarContext)_localctx).variable!=null?_input.getText(((VarContext)_localctx).variable.start,((VarContext)_localctx).variable.stop):null) + "-> ");
				        String s = (((VarContext)_localctx).variable!=null?_input.getText(((VarContext)_localctx).variable.start,((VarContext)_localctx).variable.stop):null);
				        if ( declarations.contains(s) ) {System.out.println("defined");}
				        else {System.err.println("undefined variable found: '"+ s + "' at "+ getLocation());}
				      
				}
				break;
			case 6:
				{
				_localctx = new RelContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(504);
				if (!(isRelation())) throw new FailedPredicateException(this, "isRelation()");
				setState(505);
				relation();
				}
				break;
			case 7:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(12)).var =  0;
				{
				setState(507);
				match(T__1);
				setState(508);
				comprehensionDecls();
				setState(509);
				match(T__29);
				setState(510);
				formula(0);
				setState(511);
				match(T__2);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(12)).var; i++) declarations.pop();
				}
				break;
			case 8:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(515);
				match(T__56);
				}
				break;
			case 9:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(516);
				match(T__57);
				}
				break;
			case 10:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(517);
				match(T__58);
				}
				break;
			case 11:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(518);
				match(T__59);
				}
				break;
			case 12:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(519);
				match(T__14);
				setState(520);
				expression(0);
				setState(521);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(550);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(548);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(525);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(526);
						match(T__49);
						setState(527);
						((UnionContext)_localctx).right = expression(15);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(528);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(529);
						match(T__50);
						setState(530);
						((IntersectionContext)_localctx).right = expression(14);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(531);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(532);
						match(T__51);
						setState(533);
						((DifferenceContext)_localctx).right = expression(13);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(534);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(535);
						match(T__52);
						setState(536);
						((JoinContext)_localctx).right = expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(537);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(538);
						match(T__32);
						setState(539);
						((ProductContext)_localctx).right = expression(10);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(540);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(541);
						match(T__53);
						setState(542);
						((OverrideContext)_localctx).right = expression(9);
						}
						break;
					case 7:
						{
						_localctx = new BoxjoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxjoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(543);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(544);
						match(T__11);
						setState(545);
						((BoxjoinContext)_localctx).left = expression(0);
						setState(546);
						match(T__12);
						}
						break;
					}
					} 
				}
				setState(552);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_intexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			switch (_input.LA(1)) {
			case T__38:
			case T__39:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(554);
				((IfIntExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__38 || _la==T__39) ) {
					((IfIntExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(555);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(556);
				match(T__54);
				setState(557);
				((IfIntExpressionContext)_localctx).thenExpr = intexpression(0);
				setState(558);
				match(T__55);
				setState(559);
				((IfIntExpressionContext)_localctx).elseExpr = intexpression(10);
				}
				break;
			case T__28:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(561);
				match(T__28);
				setState(562);
				expression(0);
				}
				break;
			case T__60:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(563);
				match(T__60);
				setState(564);
				expression(0);
				}
				break;
			case T__51:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(566);
				_la = _input.LA(1);
				if (_la==T__51) {
					{
					setState(565);
					((IntConstantContext)_localctx).sign = match(T__51);
					}
				}

				setState(568);
				integer();
				}
				break;
			case T__14:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(569);
				match(T__14);
				setState(570);
				intexpression(0);
				setState(571);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(592);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(590);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntexpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(575);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(576);
						_la = _input.LA(1);
						if ( !(_la==T__49 || _la==T__61) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(577);
						((PlusContext)_localctx).right = intexpression(8);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntexpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(578);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(579);
						_la = _input.LA(1);
						if ( !(_la==T__51 || _la==T__62) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(580);
						((MinusContext)_localctx).right = intexpression(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntexpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(581);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(582);
						_la = _input.LA(1);
						if ( !(_la==T__48 || _la==T__63) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(583);
						((MultiplyContext)_localctx).right = intexpression(6);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntexpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(584);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(585);
						_la = _input.LA(1);
						if ( !(_la==T__64 || _la==T__65) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(586);
						((DivideContext)_localctx).right = intexpression(5);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntexpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(587);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(588);
						_la = _input.LA(1);
						if ( !(_la==T__66 || _la==T__67) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(589);
						((ModuloContext)_localctx).right = intexpression(4);
						}
						break;
					}
					} 
				}
				setState(594);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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
		enterRule(_localctx, 30, RULE_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			decl();
			setState(600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(596);
				match(T__4);
				setState(597);
				decl();
				}
				}
				setState(602);
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
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
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
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
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
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
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
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
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
		enterRule(_localctx, 32, RULE_decl);
		int _la;
		try {
			setState(669);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(604);
				_la = _input.LA(1);
				if (_la==T__68) {
					{
					setState(603);
					((OneOfContext)_localctx).disj = match(T__68);
					}
				}

				setState(606);
				((OneOfContext)_localctx).variable = variable();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
				setState(611);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(607);
					match(T__4);
					setState(608);
					((OneOfContext)_localctx).variable = variable();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
					}
					}
					setState(613);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(614);
				match(T__6);
				setState(616);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(615);
					match(T__18);
					}
					break;
				}
				setState(618);
				expression(0);
				((FormulaContext)getInvokingContext(12)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(12)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(622);
				_la = _input.LA(1);
				if (_la==T__68) {
					{
					setState(621);
					((LoneOfContext)_localctx).disj = match(T__68);
					}
				}

				setState(624);
				((LoneOfContext)_localctx).variable = variable();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
				setState(629);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(625);
					match(T__4);
					setState(626);
					((LoneOfContext)_localctx).variable = variable();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
					}
					}
					setState(631);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(632);
				match(T__6);
				setState(633);
				match(T__17);
				setState(634);
				expression(0);
				((FormulaContext)getInvokingContext(12)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(12)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(638);
				_la = _input.LA(1);
				if (_la==T__68) {
					{
					setState(637);
					((SomeOfContext)_localctx).disj = match(T__68);
					}
				}

				setState(640);
				((SomeOfContext)_localctx).variable = variable();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
				setState(645);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(641);
					match(T__4);
					setState(642);
					((SomeOfContext)_localctx).variable = variable();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
					}
					}
					setState(647);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(648);
				match(T__6);
				setState(649);
				match(T__19);
				setState(650);
				expression(0);
				((FormulaContext)getInvokingContext(12)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(12)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(654);
				_la = _input.LA(1);
				if (_la==T__68) {
					{
					setState(653);
					((SetOfContext)_localctx).disj = match(T__68);
					}
				}

				setState(656);
				((SetOfContext)_localctx).variable = variable();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
				setState(661);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(657);
					match(T__4);
					setState(658);
					((SetOfContext)_localctx).variable = variable();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
					}
					}
					setState(663);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(664);
				match(T__6);
				setState(665);
				match(T__69);
				setState(666);
				expression(0);
				((FormulaContext)getInvokingContext(12)).var =  declareVariables(((SetOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(12)).var);
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
		enterRule(_localctx, 34, RULE_letDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			letDecl();
			setState(676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(672);
				match(T__4);
				setState(673);
				letDecl();
				}
				}
				setState(678);
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
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
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
		enterRule(_localctx, 36, RULE_letDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(679);
			((LetDeclContext)_localctx).variable = variable();
			((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variable);
			setState(684);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(680);
				match(T__4);
				setState(681);
				((LetDeclContext)_localctx).variable = variable();
				((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variable);
				}
				}
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(687);
			match(T__23);
			setState(688);
			expression(0);
			}
			((FormulaContext)getInvokingContext(12)).var =  declareVariables(((LetDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(12)).var);
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
		enterRule(_localctx, 38, RULE_comprehensionDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692);
			comprehensionDecl();
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(693);
				match(T__4);
				setState(694);
				comprehensionDecl();
				}
				}
				setState(699);
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
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
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
		enterRule(_localctx, 40, RULE_comprehensionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(700);
				((ComprehensionDeclContext)_localctx).disj = match(T__68);
				}
			}

			{
			setState(703);
			((ComprehensionDeclContext)_localctx).variable = variable();
			((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variable);
			setState(708);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(704);
				match(T__4);
				setState(705);
				((ComprehensionDeclContext)_localctx).variable = variable();
				((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variable);
				}
				}
				setState(710);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(711);
			match(T__6);
			setState(713);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(712);
				match(T__18);
				}
				break;
			}
			setState(715);
			expression(0);
			}
			((FormulaContext)getInvokingContext(12)).var =  declareVariables(((ComprehensionDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(12)).var);
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
		case 12:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 14:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3O\u02d2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\5\2.\n\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\3\2\3\2\7\2=\n\2\f\2\16\2@\13\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4Y\n\4\3\5\3\5\3\5\3\5\3\5\7\5`\n\5\f\5\16\5c\13"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5k\n\5\f\5\16\5n\13\5\3\5\3\5\5\5r\n\5\3"+
		"\5\3\5\3\6\3\6\3\6\5\6y\n\6\3\6\3\6\3\6\3\6\5\6\177\n\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\7\7\u0089\n\7\f\7\16\7\u008c\13\7\5\7\u008e\n\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7\u0095\n\7\f\7\16\7\u0098\13\7\5\7\u009a\n\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a9\n\7\3\b\3\b\3"+
		"\b\3\b\7\b\u00af\n\b\f\b\16\b\u00b2\13\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00ba"+
		"\n\b\f\b\16\b\u00bd\13\b\3\b\3\b\5\b\u00c1\n\b\3\t\3\t\3\t\5\t\u00c6\n"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00dd\n\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00e4\n\16\3\16\3\16\3\16\3\16\3\16\5\16\u00eb\n\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00f2\n\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f9\n\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u0100\n\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u0107\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u0135\n\16\f\16\16\16\u0138\13\16\3\16\5\16"+
		"\u013b\n\16\3\16\3\16\7\16\u013f\n\16\f\16\16\16\u0142\13\16\3\16\5\16"+
		"\u0145\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0150\n"+
		"\16\f\16\16\16\u0153\13\16\3\16\5\16\u0156\n\16\3\16\3\16\7\16\u015a\n"+
		"\16\f\16\16\16\u015d\13\16\3\16\5\16\u0160\n\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16\u016b\n\16\f\16\16\16\u016e\13\16\3\16\5"+
		"\16\u0171\n\16\3\16\3\16\7\16\u0175\n\16\f\16\16\16\u0178\13\16\3\16\5"+
		"\16\u017b\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0186"+
		"\n\16\f\16\16\16\u0189\13\16\3\16\5\16\u018c\n\16\3\16\3\16\7\16\u0190"+
		"\n\16\f\16\16\16\u0193\13\16\3\16\5\16\u0196\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u01a1\n\16\f\16\16\16\u01a4\13\16\3\16"+
		"\5\16\u01a7\n\16\3\16\3\16\7\16\u01ab\n\16\f\16\16\16\u01ae\13\16\3\16"+
		"\5\16\u01b1\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u01bc"+
		"\n\16\f\16\16\16\u01bf\13\16\3\16\5\16\u01c2\n\16\3\16\3\16\7\16\u01c6"+
		"\n\16\f\16\16\16\u01c9\13\16\3\16\5\16\u01cc\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u01d6\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u01e4\n\16\f\16\16\16\u01e7\13\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u020e\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0227\n\17\f\17\16\17\u022a\13\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u0239\n\20\3\20\3\20\3\20\3\20\3\20\5\20\u0240\n\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0251"+
		"\n\20\f\20\16\20\u0254\13\20\3\21\3\21\3\21\7\21\u0259\n\21\f\21\16\21"+
		"\u025c\13\21\3\22\5\22\u025f\n\22\3\22\3\22\3\22\7\22\u0264\n\22\f\22"+
		"\16\22\u0267\13\22\3\22\3\22\5\22\u026b\n\22\3\22\3\22\3\22\3\22\5\22"+
		"\u0271\n\22\3\22\3\22\3\22\7\22\u0276\n\22\f\22\16\22\u0279\13\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0281\n\22\3\22\3\22\3\22\7\22\u0286\n"+
		"\22\f\22\16\22\u0289\13\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0291\n"+
		"\22\3\22\3\22\3\22\7\22\u0296\n\22\f\22\16\22\u0299\13\22\3\22\3\22\3"+
		"\22\3\22\3\22\5\22\u02a0\n\22\3\23\3\23\3\23\7\23\u02a5\n\23\f\23\16\23"+
		"\u02a8\13\23\3\24\3\24\3\24\7\24\u02ad\n\24\f\24\16\24\u02b0\13\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\7\25\u02ba\n\25\f\25\16\25\u02bd\13"+
		"\25\3\26\5\26\u02c0\n\26\3\26\3\26\3\26\7\26\u02c5\n\26\f\26\16\26\u02c8"+
		"\13\26\3\26\3\26\5\26\u02cc\n\26\3\26\3\26\3\26\3\26\3\26\2\5\32\34\36"+
		"\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\r\3\2\27\30\3\2\24"+
		"\25\3\2%&\3\2\'(\3\2)*\3\2+,\4\2\64\64@@\4\2\66\66AA\4\2\63\63BB\3\2C"+
		"D\3\2EF\u033c\2-\3\2\2\2\4D\3\2\2\2\6X\3\2\2\2\bq\3\2\2\2\nu\3\2\2\2\f"+
		"\u00a8\3\2\2\2\16\u00c0\3\2\2\2\20\u00c5\3\2\2\2\22\u00c7\3\2\2\2\24\u00c9"+
		"\3\2\2\2\26\u00cb\3\2\2\2\30\u00cd\3\2\2\2\32\u01d5\3\2\2\2\34\u020d\3"+
		"\2\2\2\36\u023f\3\2\2\2 \u0255\3\2\2\2\"\u029f\3\2\2\2$\u02a1\3\2\2\2"+
		"&\u02a9\3\2\2\2(\u02b6\3\2\2\2*\u02bf\3\2\2\2,.\5\4\3\2-,\3\2\2\2-.\3"+
		"\2\2\2./\3\2\2\2/\60\5\b\5\2\60\61\b\2\1\2\61\62\7\3\2\2\62\66\7\4\2\2"+
		"\63\65\5\n\6\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67"+
		"9\3\2\2\28\66\3\2\2\29:\7\5\2\2:>\b\2\1\2;=\5\32\16\2<;\3\2\2\2=@\3\2"+
		"\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\b\2\1\2BC\b\2\1\2C\3\3"+
		"\2\2\2DE\7\6\2\2EF\7\4\2\2FG\5\6\4\2GH\7\7\2\2HI\5\6\4\2IJ\3\2\2\2JK\7"+
		"\5\2\2K\5\3\2\2\2LM\7\b\2\2MN\7\t\2\2NY\5\26\f\2OP\7\n\2\2PQ\7\t\2\2Q"+
		"Y\5\26\f\2RS\7\13\2\2ST\7\t\2\2TY\5\26\f\2UV\7\f\2\2VW\7\t\2\2WY\5\26"+
		"\f\2XL\3\2\2\2XO\3\2\2\2XR\3\2\2\2XU\3\2\2\2Y\7\3\2\2\2Z[\7\r\2\2[\\\7"+
		"\4\2\2\\a\5\20\t\2]^\7\7\2\2^`\5\20\t\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2"+
		"ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\7\5\2\2er\3\2\2\2fg\7\16\2\2gl\5\20\t"+
		"\2hi\7\7\2\2ik\5\20\t\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2"+
		"\2\2nl\3\2\2\2op\7\17\2\2pr\3\2\2\2qZ\3\2\2\2qf\3\2\2\2rs\3\2\2\2st\b"+
		"\5\1\2t\t\3\2\2\2uv\5\22\n\2vx\7\t\2\2wy\5\30\r\2xw\3\2\2\2xy\3\2\2\2"+
		"yz\3\2\2\2z{\7\16\2\2{~\5\f\7\2|}\7\7\2\2}\177\5\f\7\2~|\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\17\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\b\6\1\2\u0083\13\3\2\2\2\u0084\u008d\7\4\2\2\u0085\u008a\5\16\b"+
		"\2\u0086\u0087\7\7\2\2\u0087\u0089\5\16\b\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\3\2"+
		"\2\2\u008c\u008a\3\2\2\2\u008d\u0085\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u00a9\7\5\2\2\u0090\u0099\7\16\2\2\u0091\u0096\5"+
		"\16\b\2\u0092\u0093\7\7\2\2\u0093\u0095\5\16\b\2\u0094\u0092\3\2\2\2\u0095"+
		"\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009a\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0099\u0091\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u00a9\7\17\2\2\u009c\u009d\7\4\2\2\u009d\u009e\5"+
		"\16\b\2\u009e\u009f\7\20\2\2\u009f\u00a0\5\16\b\2\u00a0\u00a1\7\5\2\2"+
		"\u00a1\u00a9\3\2\2\2\u00a2\u00a3\7\16\2\2\u00a3\u00a4\5\16\b\2\u00a4\u00a5"+
		"\7\20\2\2\u00a5\u00a6\5\16\b\2\u00a6\u00a7\7\17\2\2\u00a7\u00a9\3\2\2"+
		"\2\u00a8\u0084\3\2\2\2\u00a8\u0090\3\2\2\2\u00a8\u009c\3\2\2\2\u00a8\u00a2"+
		"\3\2\2\2\u00a9\r\3\2\2\2\u00aa\u00ab\7\21\2\2\u00ab\u00b0\5\20\t\2\u00ac"+
		"\u00ad\7\7\2\2\u00ad\u00af\5\20\t\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3"+
		"\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b4\7\22\2\2\u00b4\u00c1\3\2\2\2\u00b5\u00b6\7"+
		"\16\2\2\u00b6\u00bb\5\20\t\2\u00b7\u00b8\7\7\2\2\u00b8\u00ba\5\20\t\2"+
		"\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\17\2\2"+
		"\u00bf\u00c1\3\2\2\2\u00c0\u00aa\3\2\2\2\u00c0\u00b5\3\2\2\2\u00c1\17"+
		"\3\2\2\2\u00c2\u00c3\7J\2\2\u00c3\u00c6\b\t\1\2\u00c4\u00c6\7I\2\2\u00c5"+
		"\u00c2\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\21\3\2\2\2\u00c7\u00c8\7J\2\2"+
		"\u00c8\23\3\2\2\2\u00c9\u00ca\7J\2\2\u00ca\25\3\2\2\2\u00cb\u00cc\7I\2"+
		"\2\u00cc\27\3\2\2\2\u00cd\u00ce\7I\2\2\u00ce\31\3\2\2\2\u00cf\u00d0\b"+
		"\16\1\2\u00d0\u00d1\t\2\2\2\u00d1\u01d6\5\32\16\20\u00d2\u00d3\7\23\2"+
		"\2\u00d3\u01d6\5\34\17\2\u00d4\u00d5\7\24\2\2\u00d5\u01d6\5\34\17\2\u00d6"+
		"\u00d7\7\25\2\2\u00d7\u01d6\5\34\17\2\u00d8\u00d9\7\26\2\2\u00d9\u01d6"+
		"\5\34\17\2\u00da\u00dc\5\34\17\2\u00db\u00dd\t\2\2\2\u00dc\u00db\3\2\2"+
		"\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7\31\2\2\u00df"+
		"\u00e0\5\34\17\2\u00e0\u01d6\3\2\2\2\u00e1\u00e3\5\34\17\2\u00e2\u00e4"+
		"\t\2\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e6\7\32\2\2\u00e6\u00e7\5\34\17\2\u00e7\u01d6\3\2\2\2\u00e8\u00ea"+
		"\5\36\20\2\u00e9\u00eb\t\2\2\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2"+
		"\u00eb\u00ec\3\2\2\2\u00ec\u00ed\7\32\2\2\u00ed\u00ee\5\36\20\2\u00ee"+
		"\u01d6\3\2\2\2\u00ef\u00f1\5\36\20\2\u00f0\u00f2\t\2\2\2\u00f1\u00f0\3"+
		"\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7\33\2\2\u00f4"+
		"\u00f5\5\36\20\2\u00f5\u01d6\3\2\2\2\u00f6\u00f8\5\36\20\2\u00f7\u00f9"+
		"\t\2\2\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\7\34\2\2\u00fb\u00fc\5\36\20\2\u00fc\u01d6\3\2\2\2\u00fd\u00ff"+
		"\5\36\20\2\u00fe\u0100\t\2\2\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2"+
		"\u0100\u0101\3\2\2\2\u0101\u0102\7\35\2\2\u0102\u0103\5\36\20\2\u0103"+
		"\u01d6\3\2\2\2\u0104\u0106\5\36\20\2\u0105\u0107\t\2\2\2\u0106\u0105\3"+
		"\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7\36\2\2\u0109"+
		"\u010a\5\36\20\2\u010a\u01d6\3\2\2\2\u010b\u010c\b\16\1\2\u010c\u010d"+
		"\7\37\2\2\u010d\u010e\5 \21\2\u010e\u010f\7 \2\2\u010f\u0110\5\36\20\2"+
		"\u0110\u0111\3\2\2\2\u0111\u0112\b\16\1\2\u0112\u01d6\3\2\2\2\u0113\u0114"+
		"\7!\2\2\u0114\u0115\7\16\2\2\u0115\u0116\5\22\n\2\u0116\u0117\7\17\2\2"+
		"\u0117\u01d6\3\2\2\2\u0118\u0119\7\"\2\2\u0119\u011a\7\16\2\2\u011a\u011b"+
		"\5\22\n\2\u011b\u011c\7\t\2\2\u011c\u011d\5\34\17\2\u011d\u011e\7#\2\2"+
		"\u011e\u011f\t\3\2\2\u011f\u0120\5\34\17\2\u0120\u0121\7\17\2\2\u0121"+
		"\u01d6\3\2\2\2\u0122\u0123\7$\2\2\u0123\u0124\7\16\2\2\u0124\u0125\5\22"+
		"\n\2\u0125\u0126\7\7\2\2\u0126\u0127\5\22\n\2\u0127\u0128\7\7\2\2\u0128"+
		"\u0129\5\22\n\2\u0129\u012a\7\7\2\2\u012a\u012b\5\22\n\2\u012b\u012c\7"+
		"\17\2\2\u012c\u01d6\3\2\2\2\u012d\u012e\b\16\1\2\u012e\u012f\7-\2\2\u012f"+
		"\u0144\5 \21\2\u0130\u013a\7 \2\2\u0131\u013b\5\32\16\2\u0132\u0136\7"+
		"\4\2\2\u0133\u0135\5\32\16\2\u0134\u0133\3\2\2\2\u0135\u0138\3\2\2\2\u0136"+
		"\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0139\3\2\2\2\u0138\u0136\3\2"+
		"\2\2\u0139\u013b\7\5\2\2\u013a\u0131\3\2\2\2\u013a\u0132\3\2\2\2\u013b"+
		"\u0145\3\2\2\2\u013c\u0140\7\4\2\2\u013d\u013f\5\32\16\2\u013e\u013d\3"+
		"\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0145\7\5\2\2\u0144\u0130\3\2"+
		"\2\2\u0144\u013c\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\b\16\1\2\u0147"+
		"\u01d6\3\2\2\2\u0148\u0149\b\16\1\2\u0149\u014a\7\26\2\2\u014a\u015f\5"+
		" \21\2\u014b\u0155\7 \2\2\u014c\u0156\5\32\16\2\u014d\u0151\7\4\2\2\u014e"+
		"\u0150\5\32\16\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3"+
		"\2\2\2\u0151\u0152\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0156\7\5\2\2\u0155\u014c\3\2\2\2\u0155\u014d\3\2\2\2\u0156\u0160\3\2"+
		"\2\2\u0157\u015b\7\4\2\2\u0158\u015a\5\32\16\2\u0159\u0158\3\2\2\2\u015a"+
		"\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2"+
		"\2\2\u015d\u015b\3\2\2\2\u015e\u0160\7\5\2\2\u015f\u014b\3\2\2\2\u015f"+
		"\u0157\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\b\16\1\2\u0162\u01d6\3"+
		"\2\2\2\u0163\u0164\b\16\1\2\u0164\u0165\7\23\2\2\u0165\u017a\5 \21\2\u0166"+
		"\u0170\7 \2\2\u0167\u0171\5\32\16\2\u0168\u016c\7\4\2\2\u0169\u016b\5"+
		"\32\16\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0171\7\5"+
		"\2\2\u0170\u0167\3\2\2\2\u0170\u0168\3\2\2\2\u0171\u017b\3\2\2\2\u0172"+
		"\u0176\7\4\2\2\u0173\u0175\5\32\16\2\u0174\u0173\3\2\2\2\u0175\u0178\3"+
		"\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178"+
		"\u0176\3\2\2\2\u0179\u017b\7\5\2\2\u017a\u0166\3\2\2\2\u017a\u0172\3\2"+
		"\2\2\u017b\u017c\3\2\2\2\u017c\u017d\b\16\1\2\u017d\u01d6\3\2\2\2\u017e"+
		"\u017f\b\16\1\2\u017f\u0180\7\25\2\2\u0180\u0195\5 \21\2\u0181\u018b\7"+
		" \2\2\u0182\u018c\5\32\16\2\u0183\u0187\7\4\2\2\u0184\u0186\5\32\16\2"+
		"\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188"+
		"\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018c\7\5\2\2\u018b"+
		"\u0182\3\2\2\2\u018b\u0183\3\2\2\2\u018c\u0196\3\2\2\2\u018d\u0191\7\4"+
		"\2\2\u018e\u0190\5\32\16\2\u018f\u018e\3\2\2\2\u0190\u0193\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0194\3\2\2\2\u0193\u0191\3\2"+
		"\2\2\u0194\u0196\7\5\2\2\u0195\u0181\3\2\2\2\u0195\u018d\3\2\2\2\u0196"+
		"\u0197\3\2\2\2\u0197\u0198\b\16\1\2\u0198\u01d6\3\2\2\2\u0199\u019a\b"+
		"\16\1\2\u019a\u019b\7\24\2\2\u019b\u01b0\5 \21\2\u019c\u01a6\7 \2\2\u019d"+
		"\u01a7\5\32\16\2\u019e\u01a2\7\4\2\2\u019f\u01a1\5\32\16\2\u01a0\u019f"+
		"\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a5\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a7\7\5\2\2\u01a6\u019d\3\2"+
		"\2\2\u01a6\u019e\3\2\2\2\u01a7\u01b1\3\2\2\2\u01a8\u01ac\7\4\2\2\u01a9"+
		"\u01ab\5\32\16\2\u01aa\u01a9\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3"+
		"\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af"+
		"\u01b1\7\5\2\2\u01b0\u019c\3\2\2\2\u01b0\u01a8\3\2\2\2\u01b1\u01b2\3\2"+
		"\2\2\u01b2\u01b3\b\16\1\2\u01b3\u01d6\3\2\2\2\u01b4\u01b5\b\16\1\2\u01b5"+
		"\u01b6\7.\2\2\u01b6\u01cb\5$\23\2\u01b7\u01c1\7 \2\2\u01b8\u01c2\5\32"+
		"\16\2\u01b9\u01bd\7\4\2\2\u01ba\u01bc\5\32\16\2\u01bb\u01ba\3\2\2\2\u01bc"+
		"\u01bf\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c0\3\2"+
		"\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01c2\7\5\2\2\u01c1\u01b8\3\2\2\2\u01c1"+
		"\u01b9\3\2\2\2\u01c2\u01cc\3\2\2\2\u01c3\u01c7\7\4\2\2\u01c4\u01c6\5\32"+
		"\16\2\u01c5\u01c4\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c7"+
		"\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c7\3\2\2\2\u01ca\u01cc\7\5"+
		"\2\2\u01cb\u01b7\3\2\2\2\u01cb\u01c3\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd"+
		"\u01ce\b\16\1\2\u01ce\u01d6\3\2\2\2\u01cf\u01d6\7/\2\2\u01d0\u01d6\7\60"+
		"\2\2\u01d1\u01d2\7\21\2\2\u01d2\u01d3\5\32\16\2\u01d3\u01d4\7\22\2\2\u01d4"+
		"\u01d6\3\2\2\2\u01d5\u00cf\3\2\2\2\u01d5\u00d2\3\2\2\2\u01d5\u00d4\3\2"+
		"\2\2\u01d5\u00d6\3\2\2\2\u01d5\u00d8\3\2\2\2\u01d5\u00da\3\2\2\2\u01d5"+
		"\u00e1\3\2\2\2\u01d5\u00e8\3\2\2\2\u01d5\u00ef\3\2\2\2\u01d5\u00f6\3\2"+
		"\2\2\u01d5\u00fd\3\2\2\2\u01d5\u0104\3\2\2\2\u01d5\u010b\3\2\2\2\u01d5"+
		"\u0113\3\2\2\2\u01d5\u0118\3\2\2\2\u01d5\u0122\3\2\2\2\u01d5\u012d\3\2"+
		"\2\2\u01d5\u0148\3\2\2\2\u01d5\u0163\3\2\2\2\u01d5\u017e\3\2\2\2\u01d5"+
		"\u0199\3\2\2\2\u01d5\u01b4\3\2\2\2\u01d5\u01cf\3\2\2\2\u01d5\u01d0\3\2"+
		"\2\2\u01d5\u01d1\3\2\2\2\u01d6\u01e5\3\2\2\2\u01d7\u01d8\f\17\2\2\u01d8"+
		"\u01d9\t\4\2\2\u01d9\u01e4\5\32\16\17\u01da\u01db\f\16\2\2\u01db\u01dc"+
		"\t\5\2\2\u01dc\u01e4\5\32\16\16\u01dd\u01de\f\r\2\2\u01de\u01df\t\6\2"+
		"\2\u01df\u01e4\5\32\16\r\u01e0\u01e1\f\f\2\2\u01e1\u01e2\t\7\2\2\u01e2"+
		"\u01e4\5\32\16\f\u01e3\u01d7\3\2\2\2\u01e3\u01da\3\2\2\2\u01e3\u01dd\3"+
		"\2\2\2\u01e3\u01e0\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5"+
		"\u01e6\3\2\2\2\u01e6\33\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01e9\b\17\1"+
		"\2\u01e9\u01ea\7\61\2\2\u01ea\u020e\5\34\17\23\u01eb\u01ec\7\62\2\2\u01ec"+
		"\u020e\5\34\17\22\u01ed\u01ee\7\63\2\2\u01ee\u020e\5\34\17\21\u01ef\u01f0"+
		"\t\6\2\2\u01f0\u01f1\5\32\16\2\u01f1\u01f2\79\2\2\u01f2\u01f3\5\34\17"+
		"\2\u01f3\u01f4\7:\2\2\u01f4\u01f5\5\34\17\b\u01f5\u020e\3\2\2\2\u01f6"+
		"\u01f7\6\17\6\2\u01f7\u01f8\5\24\13\2\u01f8\u01f9\b\17\1\2\u01f9\u020e"+
		"\3\2\2\2\u01fa\u01fb\6\17\7\2\u01fb\u020e\5\22\n\2\u01fc\u01fd\b\17\1"+
		"\2\u01fd\u01fe\7\4\2\2\u01fe\u01ff\5(\25\2\u01ff\u0200\7 \2\2\u0200\u0201"+
		"\5\32\16\2\u0201\u0202\7\5\2\2\u0202\u0203\3\2\2\2\u0203\u0204\b\17\1"+
		"\2\u0204\u020e\3\2\2\2\u0205\u020e\7;\2\2\u0206\u020e\7<\2\2\u0207\u020e"+
		"\7=\2\2\u0208\u020e\7>\2\2\u0209\u020a\7\21\2\2\u020a\u020b\5\34\17\2"+
		"\u020b\u020c\7\22\2\2\u020c\u020e\3\2\2\2\u020d\u01e8\3\2\2\2\u020d\u01eb"+
		"\3\2\2\2\u020d\u01ed\3\2\2\2\u020d\u01ef\3\2\2\2\u020d\u01f6\3\2\2\2\u020d"+
		"\u01fa\3\2\2\2\u020d\u01fc\3\2\2\2\u020d\u0205\3\2\2\2\u020d\u0206\3\2"+
		"\2\2\u020d\u0207\3\2\2\2\u020d\u0208\3\2\2\2\u020d\u0209\3\2\2\2\u020e"+
		"\u0228\3\2\2\2\u020f\u0210\f\20\2\2\u0210\u0211\7\64\2\2\u0211\u0227\5"+
		"\34\17\21\u0212\u0213\f\17\2\2\u0213\u0214\7\65\2\2\u0214\u0227\5\34\17"+
		"\20\u0215\u0216\f\16\2\2\u0216\u0217\7\66\2\2\u0217\u0227\5\34\17\17\u0218"+
		"\u0219\f\r\2\2\u0219\u021a\7\67\2\2\u021a\u0227\5\34\17\16\u021b\u021c"+
		"\f\13\2\2\u021c\u021d\7#\2\2\u021d\u0227\5\34\17\f\u021e\u021f\f\n\2\2"+
		"\u021f\u0220\78\2\2\u0220\u0227\5\34\17\13\u0221\u0222\f\f\2\2\u0222\u0223"+
		"\7\16\2\2\u0223\u0224\5\34\17\2\u0224\u0225\7\17\2\2\u0225\u0227\3\2\2"+
		"\2\u0226\u020f\3\2\2\2\u0226\u0212\3\2\2\2\u0226\u0215\3\2\2\2\u0226\u0218"+
		"\3\2\2\2\u0226\u021b\3\2\2\2\u0226\u021e\3\2\2\2\u0226\u0221\3\2\2\2\u0227"+
		"\u022a\3\2\2\2\u0228\u0226\3\2\2\2\u0228\u0229\3\2\2\2\u0229\35\3\2\2"+
		"\2\u022a\u0228\3\2\2\2\u022b\u022c\b\20\1\2\u022c\u022d\t\6\2\2\u022d"+
		"\u022e\5\32\16\2\u022e\u022f\79\2\2\u022f\u0230\5\36\20\2\u0230\u0231"+
		"\7:\2\2\u0231\u0232\5\36\20\f\u0232\u0240\3\2\2\2\u0233\u0234\7\37\2\2"+
		"\u0234\u0240\5\34\17\2\u0235\u0236\7?\2\2\u0236\u0240\5\34\17\2\u0237"+
		"\u0239\7\66\2\2\u0238\u0237\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023a\3"+
		"\2\2\2\u023a\u0240\5\26\f\2\u023b\u023c\7\21\2\2\u023c\u023d\5\36\20\2"+
		"\u023d\u023e\7\22\2\2\u023e\u0240\3\2\2\2\u023f\u022b\3\2\2\2\u023f\u0233"+
		"\3\2\2\2\u023f\u0235\3\2\2\2\u023f\u0238\3\2\2\2\u023f\u023b\3\2\2\2\u0240"+
		"\u0252\3\2\2\2\u0241\u0242\f\t\2\2\u0242\u0243\t\b\2\2\u0243\u0251\5\36"+
		"\20\n\u0244\u0245\f\b\2\2\u0245\u0246\t\t\2\2\u0246\u0251\5\36\20\t\u0247"+
		"\u0248\f\7\2\2\u0248\u0249\t\n\2\2\u0249\u0251\5\36\20\b\u024a\u024b\f"+
		"\6\2\2\u024b\u024c\t\13\2\2\u024c\u0251\5\36\20\7\u024d\u024e\f\5\2\2"+
		"\u024e\u024f\t\f\2\2\u024f\u0251\5\36\20\6\u0250\u0241\3\2\2\2\u0250\u0244"+
		"\3\2\2\2\u0250\u0247\3\2\2\2\u0250\u024a\3\2\2\2\u0250\u024d\3\2\2\2\u0251"+
		"\u0254\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\37\3\2\2"+
		"\2\u0254\u0252\3\2\2\2\u0255\u025a\5\"\22\2\u0256\u0257\7\7\2\2\u0257"+
		"\u0259\5\"\22\2\u0258\u0256\3\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3"+
		"\2\2\2\u025a\u025b\3\2\2\2\u025b!\3\2\2\2\u025c\u025a\3\2\2\2\u025d\u025f"+
		"\7G\2\2\u025e\u025d\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u0260\3\2\2\2\u0260"+
		"\u0265\5\24\13\2\u0261\u0262\7\7\2\2\u0262\u0264\5\24\13\2\u0263\u0261"+
		"\3\2\2\2\u0264\u0267\3\2\2\2\u0265\u0263\3\2\2\2\u0265\u0266\3\2\2\2\u0266"+
		"\u0268\3\2\2\2\u0267\u0265\3\2\2\2\u0268\u026a\7\t\2\2\u0269\u026b\7\25"+
		"\2\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026c\3\2\2\2\u026c"+
		"\u026d\5\34\17\2\u026d\u026e\b\22\1\2\u026e\u02a0\3\2\2\2\u026f\u0271"+
		"\7G\2\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272\3\2\2\2\u0272"+
		"\u0277\5\24\13\2\u0273\u0274\7\7\2\2\u0274\u0276\5\24\13\2\u0275\u0273"+
		"\3\2\2\2\u0276\u0279\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278"+
		"\u027a\3\2\2\2\u0279\u0277\3\2\2\2\u027a\u027b\7\t\2\2\u027b\u027c\7\24"+
		"\2\2\u027c\u027d\5\34\17\2\u027d\u027e\b\22\1\2\u027e\u02a0\3\2\2\2\u027f"+
		"\u0281\7G\2\2\u0280\u027f\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282\3\2"+
		"\2\2\u0282\u0287\5\24\13\2\u0283\u0284\7\7\2\2\u0284\u0286\5\24\13\2\u0285"+
		"\u0283\3\2\2\2\u0286\u0289\3\2\2\2\u0287\u0285\3\2\2\2\u0287\u0288\3\2"+
		"\2\2\u0288\u028a\3\2\2\2\u0289\u0287\3\2\2\2\u028a\u028b\7\t\2\2\u028b"+
		"\u028c\7\26\2\2\u028c\u028d\5\34\17\2\u028d\u028e\b\22\1\2\u028e\u02a0"+
		"\3\2\2\2\u028f\u0291\7G\2\2\u0290\u028f\3\2\2\2\u0290\u0291\3\2\2\2\u0291"+
		"\u0292\3\2\2\2\u0292\u0297\5\24\13\2\u0293\u0294\7\7\2\2\u0294\u0296\5"+
		"\24\13\2\u0295\u0293\3\2\2\2\u0296\u0299\3\2\2\2\u0297\u0295\3\2\2\2\u0297"+
		"\u0298\3\2\2\2\u0298\u029a\3\2\2\2\u0299\u0297\3\2\2\2\u029a\u029b\7\t"+
		"\2\2\u029b\u029c\7H\2\2\u029c\u029d\5\34\17\2\u029d\u029e\b\22\1\2\u029e"+
		"\u02a0\3\2\2\2\u029f\u025e\3\2\2\2\u029f\u0270\3\2\2\2\u029f\u0280\3\2"+
		"\2\2\u029f\u0290\3\2\2\2\u02a0#\3\2\2\2\u02a1\u02a6\5&\24\2\u02a2\u02a3"+
		"\7\7\2\2\u02a3\u02a5\5&\24\2\u02a4\u02a2\3\2\2\2\u02a5\u02a8\3\2\2\2\u02a6"+
		"\u02a4\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7%\3\2\2\2\u02a8\u02a6\3\2\2\2"+
		"\u02a9\u02ae\5\24\13\2\u02aa\u02ab\7\7\2\2\u02ab\u02ad\5\24\13\2\u02ac"+
		"\u02aa\3\2\2\2\u02ad\u02b0\3\2\2\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2"+
		"\2\2\u02af\u02b1\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b1\u02b2\7\32\2\2\u02b2"+
		"\u02b3\5\34\17\2\u02b3\u02b4\3\2\2\2\u02b4\u02b5\b\24\1\2\u02b5\'\3\2"+
		"\2\2\u02b6\u02bb\5*\26\2\u02b7\u02b8\7\7\2\2\u02b8\u02ba\5*\26\2\u02b9"+
		"\u02b7\3\2\2\2\u02ba\u02bd\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2"+
		"\2\2\u02bc)\3\2\2\2\u02bd\u02bb\3\2\2\2\u02be\u02c0\7G\2\2\u02bf\u02be"+
		"\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c6\5\24\13\2"+
		"\u02c2\u02c3\7\7\2\2\u02c3\u02c5\5\24\13\2\u02c4\u02c2\3\2\2\2\u02c5\u02c8"+
		"\3\2\2\2\u02c6\u02c4\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c9\3\2\2\2\u02c8"+
		"\u02c6\3\2\2\2\u02c9\u02cb\7\t\2\2\u02ca\u02cc\7\25\2\2\u02cb\u02ca\3"+
		"\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02ce\5\34\17\2\u02ce"+
		"\u02cf\3\2\2\2\u02cf\u02d0\b\26\1\2\u02d0+\3\2\2\2N-\66>Xalqx~\u008a\u008d"+
		"\u0096\u0099\u00a8\u00b0\u00bb\u00c0\u00c5\u00dc\u00e3\u00ea\u00f1\u00f8"+
		"\u00ff\u0106\u0136\u013a\u0140\u0144\u0151\u0155\u015b\u015f\u016c\u0170"+
		"\u0176\u017a\u0187\u018b\u0191\u0195\u01a2\u01a6\u01ac\u01b0\u01bd\u01c1"+
		"\u01c7\u01cb\u01d5\u01e3\u01e5\u020d\u0226\u0228\u0238\u023f\u0250\u0252"+
		"\u025a\u025e\u0265\u026a\u0270\u0277\u0280\u0287\u0290\u0297\u029f\u02a6"+
		"\u02ae\u02bb\u02bf\u02c6\u02cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}