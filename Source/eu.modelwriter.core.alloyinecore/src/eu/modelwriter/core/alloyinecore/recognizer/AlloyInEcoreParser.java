/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016, Ferhat Erata <ferhat@computer.org>
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

// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.5.3
package eu.modelwriter.core.alloyinecore.recognizer;
 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlloyInEcoreParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

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
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, T__92=93, T__93=94, 
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, T__100=101, 
		T__101=102, T__102=103, T__103=104, T__104=105, T__105=106, T__106=107, 
		T__107=108, T__108=109, T__109=110, T__110=111, T__111=112, T__112=113, 
		T__113=114, T__114=115, T__115=116, T__116=117, T__117=118, T__118=119, 
		T__119=120, T__120=121, T__121=122, T__122=123, T__123=124, T__124=125, 
		T__125=126, T__126=127, T__127=128, T__128=129, T__129=130, T__130=131, 
		T__131=132, T__132=133, T__133=134, INT=135, IDENTIFIER=136, DOUBLE_QUOTED_STRING=137, 
		SINGLE_QUOTED_STRING=138, ML_SINGLE_QUOTED_STRING=139, MULTILINE_COMMENT=140, 
		SINGLELINE_COMMENT=141, WS=142;
	public static final int
		RULE_problem = 0, RULE_options = 1, RULE_option = 2, RULE_universe = 3, 
		RULE_relations = 4, RULE_relation = 5, RULE_tupleSet = 6, RULE_tuple = 7, 
		RULE_module = 8, RULE_packageImport = 9, RULE_ePackage = 10, RULE_eClassifier = 11, 
		RULE_eClass = 12, RULE_eStructuralFeature = 13, RULE_eAttribute = 14, 
		RULE_eReference = 15, RULE_eOperation = 16, RULE_eParameter = 17, RULE_eType = 18, 
		RULE_eMultiplicity = 19, RULE_eDataType = 20, RULE_ePrimitiveType = 21, 
		RULE_eEnum = 22, RULE_eEnumLiteral = 23, RULE_eAnnotation = 24, RULE_eDetail = 25, 
		RULE_eModelElement = 26, RULE_eNamedElement = 27, RULE_eTypedElement = 28, 
		RULE_eModelElementRef = 29, RULE_templateSignature = 30, RULE_body = 31, 
		RULE_invariant = 32, RULE_precondition = 33, RULE_postcondition = 34, 
		RULE_visibilityKind = 35, RULE_atom = 36, RULE_arity = 37, RULE_formula = 38, 
		RULE_expression = 39, RULE_intexpression = 40, RULE_decls = 41, RULE_decl = 42, 
		RULE_letDecls = 43, RULE_letDecl = 44, RULE_comprehensionDecls = 45, RULE_comprehensionDecl = 46, 
		RULE_relationId = 47, RULE_variableId = 48, RULE_integer = 49, RULE_qualifiedName = 50, 
		RULE_identifier = 51, RULE_upper = 52, RULE_lower = 53, RULE_signed = 54;
	public static final String[] ruleNames = {
		"problem", "options", "option", "universe", "relations", "relation", "tupleSet", 
		"tuple", "module", "packageImport", "ePackage", "eClassifier", "eClass", 
		"eStructuralFeature", "eAttribute", "eReference", "eOperation", "eParameter", 
		"eType", "eMultiplicity", "eDataType", "ePrimitiveType", "eEnum", "eEnumLiteral", 
		"eAnnotation", "eDetail", "eModelElement", "eNamedElement", "eTypedElement", 
		"eModelElementRef", "templateSignature", "body", "invariant", "precondition", 
		"postcondition", "visibilityKind", "atom", "arity", "formula", "expression", 
		"intexpression", "decls", "decl", "letDecls", "letDecl", "comprehensionDecls", 
		"comprehensionDecl", "relationId", "variableId", "integer", "qualifiedName", 
		"identifier", "upper", "lower", "signed"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'options'", "'{'", "','", "'}'", "'symmetry_breaking'", "':'", 
		"'bit_width'", "'skolem_depth'", "'sharing'", "'universe'", "'['", "']'", 
		"'relations'", "'..'", "'('", "')'", "'module'", "'import'", "';'", "'package'", 
		"'='", "'abstract'", "'class'", "'extends'", "'interface'", "'static'", 
		"'model'", "'ghost'", "'transient'", "'volatile'", "'nullable'", "'!nullable'", 
		"'readonly'", "'attribute'", "'derived'", "'!derived'", "'id'", "'!id'", 
		"'ordered'", "'!ordered'", "'unique'", "'!unique'", "'unsettable'", "'!unsettable'", 
		"'initial'", "'derivation'", "'property'", "'#'", "'composes'", "'!composes'", 
		"'resolve'", "'!resolve'", "'key'", "'operation'", "'throws'", "'*'", 
		"'+'", "'?'", "'|?'", "'|1'", "'primitive'", "'datatype'", "'serializable'", 
		"'!serializable'", "'Boolean'", "'Integer'", "'String'", "'Real'", "'UnlimitedNatural'", 
		"'enum'", "'literal'", "'annotation'", "'reference'", "'<'", "'>'", "'body'", 
		"'callable'", "'invariant'", "'precondition'", "'requires'", "'postcondition'", 
		"'ensures'", "'public'", "'protected'", "'private'", "'no'", "'lone'", 
		"'one'", "'some'", "'!'", "'not'", "'in'", "'<='", "'>='", "'sum'", "'|'", 
		"'acyclic'", "'function'", "'->'", "'ord'", "'&&'", "'and'", "'||'", "'or'", 
		"'=>'", "'if'", "'<=>'", "'iff'", "'all'", "'let'", "'true'", "'false'", 
		"'~'", "'^'", "'&'", "'-'", "'.'", "'set'", "'++'", "'then'", "'else'", 
		"'iden'", "'none'", "'univ'", "'ints'", "'plus'", "'minus'", "'mul'", 
		"'/'", "'div'", "'%'", "'modulo'", "'disj'", "'::'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", 
		"ML_SINGLE_QUOTED_STRING", "MULTILINE_COMMENT", "SINGLELINE_COMMENT", 
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
	public String getGrammarFileName() { return "AlloyInEcore.g4"; }

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

	    private boolean isRelation() { System.out.println("isRelation? " + this.relations.containsKey(getCurrentToken().getText()) +
	        ": " + getCurrentToken().getText());
	    return this.relations.containsKey(getCurrentToken().getText()); }
	    private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}
	    private String context = null;
	    private int declareVariables(java.util.List<VariableIdContext> vars, int var) {
	        System.out.println("Quantifier context: ");
	        for (VariableIdContext vc : vars) {
	            String s = vc.getText(); declarations.add(s); var++; System.out.println(s);
	        }
	        return var;
	    }

	public AlloyInEcoreParser(TokenStream input) {
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterProblem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitProblem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitProblem(this);
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
			setState(111);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(110);
				options();
				}
			}

			setState(113);
			universe();
			System.out.println(universe);
			setState(115);
			relations();
			System.out.println(bounds);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(117);
					((ProblemContext)_localctx).formula = formula(0);
					((ProblemContext)_localctx).formulas.add(((ProblemContext)_localctx).formula);
					}
					} 
				}
				setState(122);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionsContext options() throws RecognitionException {
		OptionsContext _localctx = new OptionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_options);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__0);
			setState(127);
			match(T__1);
			setState(128);
			option();
			{
			setState(129);
			match(T__2);
			setState(130);
			option();
			}
			setState(132);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSymmetryBreaking(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSymmetryBreaking(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSymmetryBreaking(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBitWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBitWidth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBitWidth(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSkolemDepth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSkolemDepth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSkolemDepth(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSharing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSharing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSharing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_option);
		try {
			setState(146);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(T__4);
				setState(135);
				match(T__5);
				setState(136);
				integer();
				}
				break;
			case T__6:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(T__6);
				setState(138);
				match(T__5);
				setState(139);
				integer();
				}
				break;
			case T__7:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(T__7);
				setState(141);
				match(T__5);
				setState(142);
				integer();
				}
				break;
			case T__8:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(T__8);
				setState(144);
				match(T__5);
				setState(145);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterUniverse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitUniverse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUniverse(this);
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
			setState(148);
			match(T__9);
			setState(171);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(149);
				match(T__1);
				{
				setState(150);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(151);
					match(T__2);
					setState(152);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(158);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				{
				setState(160);
				match(T__10);
				{
				setState(161);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(162);
					match(T__2);
					setState(163);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(169);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterRelations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitRelations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitRelations(this);
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
			setState(175);
			match(T__12);
			setState(176);
			match(T__1);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(177);
				relation();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
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
		public IdentifierContext identifier;
		public ArityContext arity;
		public TupleSetContext lowerBound;
		public TupleSetContext upperBound;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitRelation(this);
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
			setState(185);
			((RelationContext)_localctx).identifier = identifier();
			setState(187);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(186);
				((RelationContext)_localctx).arity = arity();
				}
			}

			setState(189);
			match(T__5);
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(190);
				expression(0);
				}
				break;
			}
			setState(193);
			match(T__10);
			{
			setState(194);
			((RelationContext)_localctx).lowerBound = tupleSet();
			setState(197);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(195);
				match(T__2);
				setState(196);
				((RelationContext)_localctx).upperBound = tupleSet();
				}
			}

			}
			setState(199);
			match(T__11);
			}

			    String name = (((RelationContext)_localctx).identifier!=null?_input.getText(((RelationContext)_localctx).identifier.start,((RelationContext)_localctx).identifier.stop):null);
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
			                if (atom.getText() == null || atom.getText().isEmpty()) continue;
			                atoms.add(atom.getText());
			            }
			            if (!atoms.isEmpty()) tuplesInLowerBound.add(this.universe.factory().tuple(atoms));
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
			                if (atom.getText() == null || atom.getText().isEmpty()) continue;
			                atoms.add(atom.getText());
			            }
			            if (!atoms.isEmpty()) tuplesInUpperBound.add(this.universe.factory().tuple(atoms));
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTupleSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTupleSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTupleSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleSetContext tupleSet() throws RecognitionException {
		TupleSetContext _localctx = new TupleSetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tupleSet);
		int _la;
		try {
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(T__1);
				setState(212);
				_la = _input.LA(1);
				if (_la==T__10 || _la==T__14) {
					{
					setState(204);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(205);
						match(T__2);
						setState(206);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(211);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(214);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(T__10);
				setState(224);
				_la = _input.LA(1);
				if (_la==T__10 || _la==T__14) {
					{
					setState(216);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(217);
						match(T__2);
						setState(218);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(223);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(226);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(T__1);
				setState(228);
				((TupleSetContext)_localctx).left = tuple();
				setState(229);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(230);
				((TupleSetContext)_localctx).right = tuple();
				setState(231);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				match(T__10);
				setState(234);
				((TupleSetContext)_localctx).left = tuple();
				setState(235);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(236);
				((TupleSetContext)_localctx).right = tuple();
				setState(237);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tuple);
		int _la;
		try {
			setState(263);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(T__14);
				setState(242);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(243);
					match(T__2);
					setState(244);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250);
				match(T__15);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				match(T__10);
				setState(253);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(254);
					match(T__2);
					setState(255);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261);
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

	public static class ModuleContext extends ParserRuleContext {
		public PackageImportContext packageImport;
		public List<PackageImportContext> ownedPackageImport = new ArrayList<PackageImportContext>();
		public EPackageContext ePackage;
		public List<EPackageContext> ownedPackage = new ArrayList<EPackageContext>();
		public OptionsContext options() {
			return getRuleContext(OptionsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<PackageImportContext> packageImport() {
			return getRuleContexts(PackageImportContext.class);
		}
		public PackageImportContext packageImport(int i) {
			return getRuleContext(PackageImportContext.class,i);
		}
		public List<EPackageContext> ePackage() {
			return getRuleContexts(EPackageContext.class);
		}
		public EPackageContext ePackage(int i) {
			return getRuleContext(EPackageContext.class,i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitModule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(265);
				options();
				}
			}

			setState(270);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(268);
				match(T__16);
				setState(269);
				identifier();
				}
			}

			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(272);
				((ModuleContext)_localctx).packageImport = packageImport();
				((ModuleContext)_localctx).ownedPackageImport.add(((ModuleContext)_localctx).packageImport);
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19 || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				{
				setState(278);
				((ModuleContext)_localctx).ePackage = ePackage();
				((ModuleContext)_localctx).ownedPackage.add(((ModuleContext)_localctx).ePackage);
				}
				}
				setState(283);
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

	public static class PackageImportContext extends ParserRuleContext {
		public IdentifierContext name;
		public Token ownedPathName;
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PackageImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPackageImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPackageImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPackageImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageImportContext packageImport() throws RecognitionException {
		PackageImportContext _localctx = new PackageImportContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_packageImport);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(284);
			match(T__17);
			}
			setState(288);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(285);
				((PackageImportContext)_localctx).name = identifier();
				setState(286);
				match(T__5);
				}
			}

			setState(290);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(291);
			match(T__18);
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

	public static class EPackageContext extends ParserRuleContext {
		public VisibilityKindContext visibility;
		public IdentifierContext name;
		public IdentifierContext nsPrefix;
		public Token nsURI;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EPackageContext ePackage;
		public List<EPackageContext> eSubPackages = new ArrayList<EPackageContext>();
		public EClassifierContext eClassifier;
		public List<EClassifierContext> eClassifiers = new ArrayList<EClassifierContext>();
		public InvariantContext invariant;
		public List<InvariantContext> eConstraints = new ArrayList<InvariantContext>();
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<EPackageContext> ePackage() {
			return getRuleContexts(EPackageContext.class);
		}
		public EPackageContext ePackage(int i) {
			return getRuleContext(EPackageContext.class,i);
		}
		public List<EClassifierContext> eClassifier() {
			return getRuleContexts(EClassifierContext.class);
		}
		public EClassifierContext eClassifier(int i) {
			return getRuleContext(EClassifierContext.class,i);
		}
		public List<InvariantContext> invariant() {
			return getRuleContexts(InvariantContext.class);
		}
		public InvariantContext invariant(int i) {
			return getRuleContext(InvariantContext.class,i);
		}
		public EPackageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ePackage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEPackage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEPackage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEPackage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EPackageContext ePackage() throws RecognitionException {
		EPackageContext _localctx = new EPackageContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ePackage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(293);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
				break;
			}
			setState(296);
			match(T__19);
			setState(297);
			((EPackageContext)_localctx).name = identifier();
			{
			setState(298);
			match(T__5);
			setState(299);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(301);
			match(T__20);
			setState(302);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			setState(316);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(304);
				match(T__1);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__30) | (1L << T__31) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__71 - 70)) | (1L << (T__76 - 70)) | (1L << (T__77 - 70)) | (1L << (T__82 - 70)) | (1L << (T__83 - 70)) | (1L << (T__84 - 70)))) != 0)) {
					{
					setState(309);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(305);
						((EPackageContext)_localctx).eAnnotation = eAnnotation();
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						}
						break;
					case 2:
						{
						setState(306);
						((EPackageContext)_localctx).ePackage = ePackage();
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						}
						break;
					case 3:
						{
						setState(307);
						((EPackageContext)_localctx).eClassifier = eClassifier();
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						}
						break;
					case 4:
						{
						setState(308);
						((EPackageContext)_localctx).invariant = invariant();
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(314);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(315);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EClassifierContext extends ParserRuleContext {
		public EClassContext eClass() {
			return getRuleContext(EClassContext.class,0);
		}
		public EDataTypeContext eDataType() {
			return getRuleContext(EDataTypeContext.class,0);
		}
		public EEnumContext eEnum() {
			return getRuleContext(EEnumContext.class,0);
		}
		public EClassifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eClassifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEClassifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEClassifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEClassifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EClassifierContext eClassifier() throws RecognitionException {
		EClassifierContext _localctx = new EClassifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_eClassifier);
		try {
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				eClass();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				eDataType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				eEnum();
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

	public static class EClassContext extends ParserRuleContext {
		public VisibilityKindContext visibility;
		public Token isAbstract;
		public IdentifierContext name;
		public QualifiedNameContext qualifiedName;
		public List<QualifiedNameContext> eSuperTypes = new ArrayList<QualifiedNameContext>();
		public Token instanceClassName;
		public Token isInterface;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EOperationContext eOperation;
		public List<EOperationContext> eOperations = new ArrayList<EOperationContext>();
		public EStructuralFeatureContext eStructuralFeature;
		public List<EStructuralFeatureContext> eStructuralFeatures = new ArrayList<EStructuralFeatureContext>();
		public InvariantContext invariant;
		public List<InvariantContext> eConstraints = new ArrayList<InvariantContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<EOperationContext> eOperation() {
			return getRuleContexts(EOperationContext.class);
		}
		public EOperationContext eOperation(int i) {
			return getRuleContext(EOperationContext.class,i);
		}
		public List<EStructuralFeatureContext> eStructuralFeature() {
			return getRuleContexts(EStructuralFeatureContext.class);
		}
		public EStructuralFeatureContext eStructuralFeature(int i) {
			return getRuleContext(EStructuralFeatureContext.class,i);
		}
		public List<InvariantContext> invariant() {
			return getRuleContexts(InvariantContext.class);
		}
		public InvariantContext invariant(int i) {
			return getRuleContext(InvariantContext.class,i);
		}
		public EClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EClassContext eClass() throws RecognitionException {
		EClassContext _localctx = new EClassContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_eClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_la = _input.LA(1);
			if (_la==T__19 || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(323);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(327);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(326);
				((EClassContext)_localctx).isAbstract = match(T__21);
				}
			}

			setState(329);
			match(T__22);
			setState(330);
			((EClassContext)_localctx).name = identifier();
			setState(340);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(331);
				match(T__23);
				setState(332);
				((EClassContext)_localctx).qualifiedName = qualifiedName();
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(333);
					match(T__2);
					setState(334);
					((EClassContext)_localctx).qualifiedName = qualifiedName();
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
					}
					}
					setState(339);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(344);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(342);
				match(T__5);
				setState(343);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(346);
				match(T__1);
				setState(348);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(347);
					((EClassContext)_localctx).isInterface = match(T__24);
					}
				}

				setState(350);
				match(T__3);
				}
				break;
			}
			setState(365);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(353);
				match(T__1);
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__46) | (1L << T__53))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__76 - 72)) | (1L << (T__77 - 72)) | (1L << (T__82 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)))) != 0)) {
					{
					setState(358);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						setState(354);
						((EClassContext)_localctx).eAnnotation = eAnnotation();
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						}
						break;
					case 2:
						{
						setState(355);
						((EClassContext)_localctx).eOperation = eOperation();
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						}
						break;
					case 3:
						{
						setState(356);
						((EClassContext)_localctx).eStructuralFeature = eStructuralFeature();
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						}
						break;
					case 4:
						{
						setState(357);
						((EClassContext)_localctx).invariant = invariant();
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(362);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(363);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(364);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EStructuralFeatureContext extends ParserRuleContext {
		public EAttributeContext eAttribute() {
			return getRuleContext(EAttributeContext.class,0);
		}
		public EReferenceContext eReference() {
			return getRuleContext(EReferenceContext.class,0);
		}
		public EStructuralFeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eStructuralFeature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEStructuralFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEStructuralFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEStructuralFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EStructuralFeatureContext eStructuralFeature() throws RecognitionException {
		EStructuralFeatureContext _localctx = new EStructuralFeatureContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_eStructuralFeature);
		try {
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				eAttribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				eReference();
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

	public static class EAttributeContext extends ParserRuleContext {
		public VisibilityKindContext visibility;
		public Token s26;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s27;
		public Token s28;
		public Token s29;
		public Token s30;
		public Token s31;
		public Token s32;
		public Token s33;
		public IdentifierContext name;
		public Token defaultValue;
		public ETypeContext eAttributeType;
		public EMultiplicityContext multiplicity;
		public Token s35;
		public Token s36;
		public Token s37;
		public Token s38;
		public Token s39;
		public Token s40;
		public Token s41;
		public Token s42;
		public Token s43;
		public Token s44;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public ExpressionContext ownedInitialExpression;
		public ExpressionContext ownedDerivedExpression;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public ETypeContext eType() {
			return getRuleContext(ETypeContext.class,0);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EAttributeContext eAttribute() throws RecognitionException {
		EAttributeContext _localctx = new EAttributeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_eAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_la = _input.LA(1);
			if (_la==T__19 || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(371);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(375);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(374);
				((EAttributeContext)_localctx).s26 = match(T__25);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
				}
			}

			setState(379);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(377);
				((EAttributeContext)_localctx).s27 = match(T__26);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(378);
				((EAttributeContext)_localctx).s28 = match(T__27);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s28);
				}
				break;
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(382);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(381);
				((EAttributeContext)_localctx).s29 = match(T__28);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
				}
			}

			setState(385);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(384);
				((EAttributeContext)_localctx).s30 = match(T__29);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
				}
			}

			setState(389);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(387);
				((EAttributeContext)_localctx).s31 = match(T__30);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(388);
				((EAttributeContext)_localctx).s32 = match(T__31);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s32);
				}
				break;
			case T__32:
			case T__33:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(392);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(391);
				((EAttributeContext)_localctx).s33 = match(T__32);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s33);
				}
			}

			setState(394);
			match(T__33);
			setState(395);
			((EAttributeContext)_localctx).name = identifier();
			setState(398);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(396);
				match(T__20);
				setState(397);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(405);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(400);
				match(T__5);
				setState(401);
				((EAttributeContext)_localctx).eAttributeType = eType();
				setState(403);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(402);
					((EAttributeContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(407);
				match(T__1);
				setState(423); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(418);
					switch (_input.LA(1)) {
					case T__34:
						{
						setState(408);
						((EAttributeContext)_localctx).s35 = match(T__34);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(409);
						((EAttributeContext)_localctx).s36 = match(T__35);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(410);
						((EAttributeContext)_localctx).s37 = match(T__36);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(411);
						((EAttributeContext)_localctx).s38 = match(T__37);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(412);
						((EAttributeContext)_localctx).s39 = match(T__38);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(413);
						((EAttributeContext)_localctx).s40 = match(T__39);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(414);
						((EAttributeContext)_localctx).s41 = match(T__40);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(415);
						((EAttributeContext)_localctx).s42 = match(T__41);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s42);
						}
						break;
					case T__42:
						{
						setState(416);
						((EAttributeContext)_localctx).s43 = match(T__42);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(417);
						((EAttributeContext)_localctx).s44 = match(T__43);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s44);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(421);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(420);
						match(T__2);
						}
					}

					}
					}
					setState(425); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0) );
				setState(427);
				match(T__3);
				}
				break;
			}
			setState(457);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(430);
				match(T__1);
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (T__44 - 45)) | (1L << (T__45 - 45)) | (1L << (T__71 - 45)))) != 0)) {
					{
					setState(450);
					switch (_input.LA(1)) {
					case T__71:
						{
						setState(431);
						((EAttributeContext)_localctx).eAnnotation = eAnnotation();
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						}
						break;
					case T__44:
						{
						{
						setState(432);
						match(T__44);
						setState(434);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(433);
							identifier();
							}
						}

						setState(436);
						match(T__5);
						setState(438);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
						case 1:
							{
							setState(437);
							((EAttributeContext)_localctx).ownedInitialExpression = expression(0);
							}
							break;
						}
						setState(440);
						match(T__18);
						}
						}
						break;
					case T__45:
						{
						{
						setState(441);
						match(T__45);
						setState(443);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(442);
							identifier();
							}
						}

						setState(445);
						match(T__5);
						setState(447);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
						case 1:
							{
							setState(446);
							((EAttributeContext)_localctx).ownedDerivedExpression = expression(0);
							}
							break;
						}
						setState(449);
						match(T__18);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(454);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(455);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(456);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EReferenceContext extends ParserRuleContext {
		public VisibilityKindContext visibility;
		public Token s26;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s27;
		public Token s28;
		public Token s29;
		public Token s30;
		public Token s31;
		public Token s32;
		public Token s33;
		public IdentifierContext name;
		public IdentifierContext opposite;
		public ETypeContext eReferenceType;
		public EMultiplicityContext multiplicity;
		public Token defaultValue;
		public Token s49;
		public Token s50;
		public Token s35;
		public Token s36;
		public Token s39;
		public Token s40;
		public Token s41;
		public Token s42;
		public Token s51;
		public Token s52;
		public Token s43;
		public Token s44;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public QualifiedNameContext qualifiedName;
		public List<QualifiedNameContext> referredKeys = new ArrayList<QualifiedNameContext>();
		public ExpressionContext expression;
		public List<ExpressionContext> ownedInitialExpression = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> ownedDerivedExpression = new ArrayList<ExpressionContext>();
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public ETypeContext eType() {
			return getRuleContext(ETypeContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EReferenceContext eReference() throws RecognitionException {
		EReferenceContext _localctx = new EReferenceContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_eReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			_la = _input.LA(1);
			if (_la==T__19 || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(459);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(463);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(462);
				((EReferenceContext)_localctx).s26 = match(T__25);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
				}
			}

			setState(467);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(465);
				((EReferenceContext)_localctx).s27 = match(T__26);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(466);
				((EReferenceContext)_localctx).s28 = match(T__27);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s28);
				}
				break;
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__46:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(470);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(469);
				((EReferenceContext)_localctx).s29 = match(T__28);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
				}
			}

			setState(473);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(472);
				((EReferenceContext)_localctx).s30 = match(T__29);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
				}
			}

			setState(477);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(475);
				((EReferenceContext)_localctx).s31 = match(T__30);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(476);
				((EReferenceContext)_localctx).s32 = match(T__31);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s32);
				}
				break;
			case T__32:
			case T__46:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(480);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(479);
				((EReferenceContext)_localctx).s33 = match(T__32);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s33);
				}
			}

			setState(482);
			match(T__46);
			setState(483);
			((EReferenceContext)_localctx).name = identifier();
			setState(486);
			_la = _input.LA(1);
			if (_la==T__47) {
				{
				setState(484);
				match(T__47);
				setState(485);
				((EReferenceContext)_localctx).opposite = identifier();
				}
			}

			setState(493);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(488);
				match(T__5);
				setState(489);
				((EReferenceContext)_localctx).eReferenceType = eType();
				setState(491);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(490);
					((EReferenceContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(497);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(495);
				match(T__20);
				setState(496);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(499);
				match(T__1);
				setState(517); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(512);
					switch (_input.LA(1)) {
					case T__48:
						{
						setState(500);
						((EReferenceContext)_localctx).s49 = match(T__48);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s49);
						}
						break;
					case T__49:
						{
						setState(501);
						((EReferenceContext)_localctx).s50 = match(T__49);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s50);
						}
						break;
					case T__34:
						{
						setState(502);
						((EReferenceContext)_localctx).s35 = match(T__34);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(503);
						((EReferenceContext)_localctx).s36 = match(T__35);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s36);
						}
						break;
					case T__38:
						{
						setState(504);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(505);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(506);
						((EReferenceContext)_localctx).s41 = match(T__40);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(507);
						((EReferenceContext)_localctx).s42 = match(T__41);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s42);
						}
						break;
					case T__50:
						{
						setState(508);
						((EReferenceContext)_localctx).s51 = match(T__50);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s51);
						}
						break;
					case T__51:
						{
						setState(509);
						((EReferenceContext)_localctx).s52 = match(T__51);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s52);
						}
						break;
					case T__42:
						{
						setState(510);
						((EReferenceContext)_localctx).s43 = match(T__42);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s43);
						}
						break;
					case T__43:
						{
						setState(511);
						((EReferenceContext)_localctx).s44 = match(T__43);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s44);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(515);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(514);
						match(T__2);
						}
					}

					}
					}
					setState(519); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) );
				setState(521);
				match(T__3);
				}
				break;
			}
			setState(562);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(524);
				match(T__1);
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (T__44 - 45)) | (1L << (T__45 - 45)) | (1L << (T__52 - 45)) | (1L << (T__71 - 45)))) != 0)) {
					{
					setState(555);
					switch (_input.LA(1)) {
					case T__71:
						{
						setState(525);
						((EReferenceContext)_localctx).eAnnotation = eAnnotation();
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						}
						break;
					case T__52:
						{
						{
						setState(526);
						match(T__52);
						setState(527);
						((EReferenceContext)_localctx).qualifiedName = qualifiedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
						setState(532);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(528);
							match(T__2);
							setState(529);
							((EReferenceContext)_localctx).qualifiedName = qualifiedName();
							((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
							}
							}
							setState(534);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(535);
						match(T__18);
						}
						}
						break;
					case T__44:
						{
						{
						setState(537);
						match(T__44);
						setState(539);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(538);
							identifier();
							}
						}

						setState(541);
						match(T__5);
						setState(543);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
						case 1:
							{
							setState(542);
							((EReferenceContext)_localctx).expression = expression(0);
							((EReferenceContext)_localctx).ownedInitialExpression.add(((EReferenceContext)_localctx).expression);
							}
							break;
						}
						setState(545);
						match(T__18);
						}
						}
						break;
					case T__45:
						{
						{
						setState(546);
						match(T__45);
						setState(548);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(547);
							identifier();
							}
						}

						setState(550);
						match(T__5);
						setState(552);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
						case 1:
							{
							setState(551);
							((EReferenceContext)_localctx).expression = expression(0);
							((EReferenceContext)_localctx).ownedDerivedExpression.add(((EReferenceContext)_localctx).expression);
							}
							break;
						}
						setState(554);
						match(T__18);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(559);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(560);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(561);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EOperationContext extends ParserRuleContext {
		public VisibilityKindContext visibility;
		public Token s26;
		public List<Token> qualifier = new ArrayList<Token>();
		public IdentifierContext name;
		public EParameterContext eParameter;
		public List<EParameterContext> eParameters = new ArrayList<EParameterContext>();
		public ETypeContext returnType;
		public EMultiplicityContext multiplicity;
		public IdentifierContext identifier;
		public List<IdentifierContext> ownedException = new ArrayList<IdentifierContext>();
		public Token s35;
		public Token s36;
		public Token s39;
		public Token s40;
		public Token s41;
		public Token s42;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public PreconditionContext precondition;
		public List<PreconditionContext> ownedPreconditions = new ArrayList<PreconditionContext>();
		public BodyContext body;
		public List<BodyContext> ownedBodyExpression = new ArrayList<BodyContext>();
		public PostconditionContext postcondition;
		public List<PostconditionContext> ownedPostconditions = new ArrayList<PostconditionContext>();
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public List<EParameterContext> eParameter() {
			return getRuleContexts(EParameterContext.class);
		}
		public EParameterContext eParameter(int i) {
			return getRuleContext(EParameterContext.class,i);
		}
		public ETypeContext eType() {
			return getRuleContext(ETypeContext.class,0);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<PreconditionContext> precondition() {
			return getRuleContexts(PreconditionContext.class);
		}
		public PreconditionContext precondition(int i) {
			return getRuleContext(PreconditionContext.class,i);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public List<PostconditionContext> postcondition() {
			return getRuleContexts(PostconditionContext.class);
		}
		public PostconditionContext postcondition(int i) {
			return getRuleContext(PostconditionContext.class,i);
		}
		public EOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EOperationContext eOperation() throws RecognitionException {
		EOperationContext _localctx = new EOperationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_eOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			_la = _input.LA(1);
			if (_la==T__19 || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(564);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(568);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(567);
				((EOperationContext)_localctx).s26 = match(T__25);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
				}
			}

			setState(570);
			match(T__53);
			setState(571);
			((EOperationContext)_localctx).name = identifier();
			setState(572);
			match(T__14);
			setState(581);
			_la = _input.LA(1);
			if (_la==T__30 || _la==T__31 || _la==IDENTIFIER) {
				{
				setState(573);
				((EOperationContext)_localctx).eParameter = eParameter();
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(574);
					match(T__2);
					setState(575);
					((EOperationContext)_localctx).eParameter = eParameter();
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(580);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(583);
			match(T__15);
			setState(589);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(584);
				match(T__5);
				setState(585);
				((EOperationContext)_localctx).returnType = eType();
				setState(587);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(586);
					((EOperationContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(600);
			_la = _input.LA(1);
			if (_la==T__54) {
				{
				setState(591);
				match(T__54);
				setState(592);
				((EOperationContext)_localctx).identifier = identifier();
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
				setState(597);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(593);
					match(T__2);
					setState(594);
					((EOperationContext)_localctx).identifier = identifier();
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
					}
					}
					setState(599);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(619);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(602);
				match(T__1);
				setState(614); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(609);
					switch (_input.LA(1)) {
					case T__34:
						{
						setState(603);
						((EOperationContext)_localctx).s35 = match(T__34);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(604);
						((EOperationContext)_localctx).s36 = match(T__35);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s36);
						}
						break;
					case T__38:
						{
						setState(605);
						((EOperationContext)_localctx).s39 = match(T__38);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(606);
						((EOperationContext)_localctx).s40 = match(T__39);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(607);
						((EOperationContext)_localctx).s41 = match(T__40);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(608);
						((EOperationContext)_localctx).s42 = match(T__41);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(612);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(611);
						match(T__2);
						}
					}

					}
					}
					setState(616); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0) );
				setState(618);
				match(T__3);
				}
				break;
			}
			setState(633);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(621);
				match(T__1);
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__75 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__80 - 72)) | (1L << (T__81 - 72)))) != 0)) {
					{
					setState(626);
					switch (_input.LA(1)) {
					case T__71:
						{
						setState(622);
						((EOperationContext)_localctx).eAnnotation = eAnnotation();
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						}
						break;
					case T__78:
					case T__79:
						{
						setState(623);
						((EOperationContext)_localctx).precondition = precondition();
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						}
						break;
					case T__75:
						{
						setState(624);
						((EOperationContext)_localctx).body = body();
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						}
						break;
					case T__80:
					case T__81:
						{
						setState(625);
						((EOperationContext)_localctx).postcondition = postcondition();
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(630);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(631);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(632);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EParameterContext extends ParserRuleContext {
		public Token s31;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s32;
		public IdentifierContext name;
		public ETypeContext ownedType;
		public EMultiplicityContext ownedMultiplicity;
		public Token s39;
		public Token s40;
		public Token s41;
		public Token s42;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ETypeContext eType() {
			return getRuleContext(ETypeContext.class,0);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public EParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EParameterContext eParameter() throws RecognitionException {
		EParameterContext _localctx = new EParameterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_eParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(635);
				((EParameterContext)_localctx).s31 = match(T__30);
				((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(636);
				((EParameterContext)_localctx).s32 = match(T__31);
				((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s32);
				}
				break;
			case IDENTIFIER:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(639);
			((EParameterContext)_localctx).name = identifier();
			setState(645);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(640);
				match(T__5);
				setState(641);
				((EParameterContext)_localctx).ownedType = eType();
				setState(643);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(642);
					((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(662);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(647);
				match(T__1);
				setState(657); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(652);
					switch (_input.LA(1)) {
					case T__38:
						{
						setState(648);
						((EParameterContext)_localctx).s39 = match(T__38);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(649);
						((EParameterContext)_localctx).s40 = match(T__39);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(650);
						((EParameterContext)_localctx).s41 = match(T__40);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(651);
						((EParameterContext)_localctx).s42 = match(T__41);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(655);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(654);
						match(T__2);
						}
					}

					}
					}
					setState(659); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0) );
				setState(661);
				match(T__3);
				}
				break;
			}
			setState(672);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(664);
				match(T__1);
				setState(668);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__71) {
					{
					{
					setState(665);
					((EParameterContext)_localctx).eAnnotation = eAnnotation();
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(670);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(671);
				match(T__3);
				}
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

	public static class ETypeContext extends ParserRuleContext {
		public EPrimitiveTypeContext ePrimitiveType() {
			return getRuleContext(EPrimitiveTypeContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ETypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ETypeContext eType() throws RecognitionException {
		ETypeContext _localctx = new ETypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_eType);
		try {
			setState(676);
			switch (_input.LA(1)) {
			case T__64:
			case T__65:
			case T__66:
			case T__67:
			case T__68:
				enterOuterAlt(_localctx, 1);
				{
				setState(674);
				ePrimitiveType();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(675);
				qualifiedName();
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

	public static class EMultiplicityContext extends ParserRuleContext {
		public LowerContext lowerBound;
		public UpperContext upperBound;
		public Token stringBounds;
		public Token isNullFree;
		public LowerContext lower() {
			return getRuleContext(LowerContext.class,0);
		}
		public UpperContext upper() {
			return getRuleContext(UpperContext.class,0);
		}
		public EMultiplicityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eMultiplicity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEMultiplicity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEMultiplicity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEMultiplicity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EMultiplicityContext eMultiplicity() throws RecognitionException {
		EMultiplicityContext _localctx = new EMultiplicityContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_eMultiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678);
			match(T__10);
			setState(685);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(679);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(682);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(680);
					match(T__13);
					setState(681);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__55:
			case T__56:
			case T__57:
				{
				setState(684);
				((EMultiplicityContext)_localctx).stringBounds = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__55) | (1L << T__56) | (1L << T__57))) != 0)) ) {
					((EMultiplicityContext)_localctx).stringBounds = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(689);
			switch (_input.LA(1)) {
			case T__58:
				{
				setState(687);
				match(T__58);
				}
				break;
			case T__59:
				{
				setState(688);
				((EMultiplicityContext)_localctx).isNullFree = match(T__59);
				}
				break;
			case T__11:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(691);
			match(T__11);
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

	public static class EDataTypeContext extends ParserRuleContext {
		public Token isPrimitive;
		public Token s31;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s32;
		public IdentifierContext name;
		public TemplateSignatureContext ownedSignature;
		public Token instanceClassName;
		public Token isSerializable;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public InvariantContext invariant;
		public List<InvariantContext> ownedConstraints = new ArrayList<InvariantContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public EAnnotationContext eAnnotation() {
			return getRuleContext(EAnnotationContext.class,0);
		}
		public List<InvariantContext> invariant() {
			return getRuleContexts(InvariantContext.class);
		}
		public InvariantContext invariant(int i) {
			return getRuleContext(InvariantContext.class,i);
		}
		public EDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eDataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EDataTypeContext eDataType() throws RecognitionException {
		EDataTypeContext _localctx = new EDataTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_eDataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			_la = _input.LA(1);
			if (_la==T__60) {
				{
				setState(693);
				((EDataTypeContext)_localctx).isPrimitive = match(T__60);
				}
			}

			setState(698);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(696);
				((EDataTypeContext)_localctx).s31 = match(T__30);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(697);
				((EDataTypeContext)_localctx).s32 = match(T__31);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s32);
				}
				break;
			case T__61:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(700);
			match(T__61);
			setState(701);
			((EDataTypeContext)_localctx).name = identifier();
			setState(703);
			_la = _input.LA(1);
			if (_la==T__14 || _la==T__73) {
				{
				setState(702);
				((EDataTypeContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(707);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(705);
				match(T__5);
				setState(706);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(715);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				{
				setState(709);
				match(T__1);
				setState(712);
				switch (_input.LA(1)) {
				case T__62:
					{
					setState(710);
					((EDataTypeContext)_localctx).isSerializable = match(T__62);
					}
					break;
				case T__63:
					{
					setState(711);
					match(T__63);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(714);
				match(T__3);
				}
				break;
			}
			setState(729);
			switch (_input.LA(1)) {
			case T__1:
			case T__3:
			case T__76:
			case T__77:
				{
				setState(726);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(717);
					match(T__1);
					setState(718);
					((EDataTypeContext)_localctx).eAnnotation = eAnnotation();
					((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
					}
					break;
				case T__3:
				case T__76:
				case T__77:
					{
					setState(722);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__76 || _la==T__77) {
						{
						{
						setState(719);
						((EDataTypeContext)_localctx).invariant = invariant();
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						}
						}
						setState(724);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(725);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__18:
				{
				setState(728);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EPrimitiveTypeContext extends ParserRuleContext {
		public EPrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ePrimitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EPrimitiveTypeContext ePrimitiveType() throws RecognitionException {
		EPrimitiveTypeContext _localctx = new EPrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_ePrimitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			_la = _input.LA(1);
			if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__65 - 65)) | (1L << (T__66 - 65)) | (1L << (T__67 - 65)) | (1L << (T__68 - 65)))) != 0)) ) {
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

	public static class EEnumContext extends ParserRuleContext {
		public VisibilityKindContext visibility;
		public IdentifierContext name;
		public TemplateSignatureContext ownedSignature;
		public Token instanceClassName;
		public Token isSerializable;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EEnumLiteralContext eEnumLiteral;
		public List<EEnumLiteralContext> ownedLiteral = new ArrayList<EEnumLiteralContext>();
		public InvariantContext invariant;
		public List<InvariantContext> ownedConstraint = new ArrayList<InvariantContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<EEnumLiteralContext> eEnumLiteral() {
			return getRuleContexts(EEnumLiteralContext.class);
		}
		public EEnumLiteralContext eEnumLiteral(int i) {
			return getRuleContext(EEnumLiteralContext.class,i);
		}
		public List<InvariantContext> invariant() {
			return getRuleContexts(InvariantContext.class);
		}
		public InvariantContext invariant(int i) {
			return getRuleContext(InvariantContext.class,i);
		}
		public EEnumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eEnum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEEnum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEEnum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEEnum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EEnumContext eEnum() throws RecognitionException {
		EEnumContext _localctx = new EEnumContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_eEnum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(734);
			_la = _input.LA(1);
			if (_la==T__19 || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(733);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(736);
			match(T__69);
			setState(737);
			((EEnumContext)_localctx).name = identifier();
			setState(739);
			_la = _input.LA(1);
			if (_la==T__14 || _la==T__73) {
				{
				setState(738);
				((EEnumContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(743);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(741);
				match(T__5);
				setState(742);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(751);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				{
				setState(745);
				match(T__1);
				setState(748);
				switch (_input.LA(1)) {
				case T__62:
					{
					setState(746);
					((EEnumContext)_localctx).isSerializable = match(T__62);
					}
					break;
				case T__63:
					{
					setState(747);
					match(T__63);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(750);
				match(T__3);
				}
				break;
			}
			setState(764);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(753);
				match(T__1);
				setState(759);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__76 - 71)) | (1L << (T__77 - 71)))) != 0) || _la==IDENTIFIER) {
					{
					setState(757);
					switch (_input.LA(1)) {
					case T__71:
						{
						setState(754);
						((EEnumContext)_localctx).eAnnotation = eAnnotation();
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						}
						break;
					case T__70:
					case IDENTIFIER:
						{
						setState(755);
						((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral();
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						}
						break;
					case T__76:
					case T__77:
						{
						setState(756);
						((EEnumContext)_localctx).invariant = invariant();
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(761);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(762);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(763);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EEnumLiteralContext extends ParserRuleContext {
		public IdentifierContext name;
		public SignedContext value;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SignedContext signed() {
			return getRuleContext(SignedContext.class,0);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public EEnumLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eEnumLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEEnumLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEEnumLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEEnumLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EEnumLiteralContext eEnumLiteral() throws RecognitionException {
		EEnumLiteralContext _localctx = new EEnumLiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_eEnumLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			switch (_input.LA(1)) {
			case T__70:
				{
				{
				setState(766);
				match(T__70);
				setState(767);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				}
				break;
			case IDENTIFIER:
				{
				setState(768);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(773);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(771);
				match(T__20);
				setState(772);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}

			setState(784);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(775);
				match(T__1);
				setState(779);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__71) {
					{
					{
					setState(776);
					((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation();
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(781);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(782);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(783);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EAnnotationContext extends ParserRuleContext {
		public Token name;
		public EDetailContext eDetail;
		public List<EDetailContext> ownedDetails = new ArrayList<EDetailContext>();
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EModelElementContext eModelElement;
		public List<EModelElementContext> ownedContents = new ArrayList<EModelElementContext>();
		public EModelElementRefContext eModelElementRef;
		public List<EModelElementRefContext> ownedReferences = new ArrayList<EModelElementRefContext>();
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public List<EDetailContext> eDetail() {
			return getRuleContexts(EDetailContext.class);
		}
		public EDetailContext eDetail(int i) {
			return getRuleContext(EDetailContext.class,i);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public List<EModelElementContext> eModelElement() {
			return getRuleContexts(EModelElementContext.class);
		}
		public EModelElementContext eModelElement(int i) {
			return getRuleContext(EModelElementContext.class,i);
		}
		public List<EModelElementRefContext> eModelElementRef() {
			return getRuleContexts(EModelElementRefContext.class);
		}
		public EModelElementRefContext eModelElementRef(int i) {
			return getRuleContext(EModelElementRefContext.class,i);
		}
		public EAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EAnnotationContext eAnnotation() throws RecognitionException {
		EAnnotationContext _localctx = new EAnnotationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_eAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(786);
			match(T__71);
			setState(788);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(787);
				((EAnnotationContext)_localctx).name = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(801);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(790);
				match(T__14);
				setState(791);
				((EAnnotationContext)_localctx).eDetail = eDetail();
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(796);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(792);
					match(T__2);
					setState(793);
					((EAnnotationContext)_localctx).eDetail = eDetail();
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(798);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(799);
				match(T__15);
				}
			}

			setState(814);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(803);
				match(T__1);
				setState(807); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(807);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
					case 1:
						{
						setState(804);
						((EAnnotationContext)_localctx).eAnnotation = eAnnotation();
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						}
						break;
					case 2:
						{
						setState(805);
						((EAnnotationContext)_localctx).eModelElement = eModelElement();
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						}
						break;
					case 3:
						{
						setState(806);
						((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef();
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						}
						break;
					}
					}
					setState(809); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (T__19 - 20)) | (1L << (T__21 - 20)) | (1L << (T__22 - 20)) | (1L << (T__25 - 20)) | (1L << (T__26 - 20)) | (1L << (T__27 - 20)) | (1L << (T__28 - 20)) | (1L << (T__29 - 20)) | (1L << (T__30 - 20)) | (1L << (T__31 - 20)) | (1L << (T__32 - 20)) | (1L << (T__33 - 20)) | (1L << (T__46 - 20)) | (1L << (T__53 - 20)) | (1L << (T__60 - 20)) | (1L << (T__61 - 20)) | (1L << (T__69 - 20)) | (1L << (T__70 - 20)) | (1L << (T__71 - 20)) | (1L << (T__72 - 20)) | (1L << (T__82 - 20)))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (T__83 - 84)) | (1L << (T__84 - 84)) | (1L << (IDENTIFIER - 84)))) != 0) );
				setState(811);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(813);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EDetailContext extends ParserRuleContext {
		public Token name;
		public Token value;
		public List<TerminalNode> SINGLE_QUOTED_STRING() { return getTokens(AlloyInEcoreParser.SINGLE_QUOTED_STRING); }
		public TerminalNode SINGLE_QUOTED_STRING(int i) {
			return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, i);
		}
		public TerminalNode ML_SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.ML_SINGLE_QUOTED_STRING, 0); }
		public EDetailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eDetail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEDetail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEDetail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEDetail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EDetailContext eDetail() throws RecognitionException {
		EDetailContext _localctx = new EDetailContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_eDetail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816);
			((EDetailContext)_localctx).name = match(SINGLE_QUOTED_STRING);
			setState(817);
			match(T__20);
			setState(818);
			((EDetailContext)_localctx).value = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) ) {
				((EDetailContext)_localctx).value = (Token)_errHandler.recoverInline(this);
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

	public static class EModelElementContext extends ParserRuleContext {
		public EAnnotationContext eAnnotation() {
			return getRuleContext(EAnnotationContext.class,0);
		}
		public ENamedElementContext eNamedElement() {
			return getRuleContext(ENamedElementContext.class,0);
		}
		public EModelElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eModelElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEModelElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEModelElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEModelElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EModelElementContext eModelElement() throws RecognitionException {
		EModelElementContext _localctx = new EModelElementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_eModelElement);
		try {
			setState(822);
			switch (_input.LA(1)) {
			case T__71:
				enterOuterAlt(_localctx, 1);
				{
				setState(820);
				eAnnotation();
				}
				break;
			case T__19:
			case T__21:
			case T__22:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__46:
			case T__53:
			case T__60:
			case T__61:
			case T__69:
			case T__70:
			case T__82:
			case T__83:
			case T__84:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(821);
				eNamedElement();
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

	public static class ENamedElementContext extends ParserRuleContext {
		public ETypedElementContext eTypedElement() {
			return getRuleContext(ETypedElementContext.class,0);
		}
		public EClassifierContext eClassifier() {
			return getRuleContext(EClassifierContext.class,0);
		}
		public EPackageContext ePackage() {
			return getRuleContext(EPackageContext.class,0);
		}
		public EEnumLiteralContext eEnumLiteral() {
			return getRuleContext(EEnumLiteralContext.class,0);
		}
		public ENamedElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eNamedElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterENamedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitENamedElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitENamedElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ENamedElementContext eNamedElement() throws RecognitionException {
		ENamedElementContext _localctx = new ENamedElementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_eNamedElement);
		try {
			setState(828);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(824);
				eTypedElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(825);
				eClassifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(826);
				ePackage();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(827);
				eEnumLiteral();
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

	public static class ETypedElementContext extends ParserRuleContext {
		public EOperationContext eOperation() {
			return getRuleContext(EOperationContext.class,0);
		}
		public EParameterContext eParameter() {
			return getRuleContext(EParameterContext.class,0);
		}
		public EStructuralFeatureContext eStructuralFeature() {
			return getRuleContext(EStructuralFeatureContext.class,0);
		}
		public ETypedElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eTypedElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterETypedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitETypedElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitETypedElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ETypedElementContext eTypedElement() throws RecognitionException {
		ETypedElementContext _localctx = new ETypedElementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_eTypedElement);
		try {
			setState(833);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(830);
				eOperation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(831);
				eParameter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(832);
				eStructuralFeature();
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

	public static class EModelElementRefContext extends ParserRuleContext {
		public QualifiedNameContext ownedPathName;
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public EModelElementRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eModelElementRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEModelElementRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEModelElementRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEModelElementRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EModelElementRefContext eModelElementRef() throws RecognitionException {
		EModelElementRefContext _localctx = new EModelElementRefContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_eModelElementRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(835);
			match(T__72);
			setState(836);
			((EModelElementRefContext)_localctx).ownedPathName = qualifiedName();
			setState(837);
			match(T__18);
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

	public static class TemplateSignatureContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> ownedParameter = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TemplateSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTemplateSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTemplateSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTemplateSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateSignatureContext templateSignature() throws RecognitionException {
		TemplateSignatureContext _localctx = new TemplateSignatureContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_templateSignature);
		int _la;
		try {
			setState(861);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(839);
				match(T__14);
				setState(840);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(845);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(841);
					match(T__2);
					setState(842);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(847);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(848);
				match(T__15);
				}
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(850);
				match(T__73);
				setState(851);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(856);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(852);
					match(T__2);
					setState(853);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(858);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(859);
				match(T__74);
				}
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

	public static class BodyContext extends ParserRuleContext {
		public IdentifierContext name;
		public ExpressionContext ownedExpression;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			match(T__75);
			setState(865);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(864);
				((BodyContext)_localctx).name = identifier();
				}
			}

			setState(873);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(867);
				match(T__5);
				setState(869);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
				case 1:
					{
					setState(868);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(871);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(872);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class InvariantContext extends ParserRuleContext {
		public Token isCallable;
		public IdentifierContext name;
		public Token message;
		public FormulaContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public InvariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInvariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInvariant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInvariant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvariantContext invariant() throws RecognitionException {
		InvariantContext _localctx = new InvariantContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(876);
			_la = _input.LA(1);
			if (_la==T__76) {
				{
				setState(875);
				((InvariantContext)_localctx).isCallable = match(T__76);
				}
			}

			setState(878);
			match(T__77);
			setState(885);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(879);
				((InvariantContext)_localctx).name = identifier();
				setState(883);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(880);
					match(T__14);
					setState(881);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(882);
					match(T__15);
					}
				}

				}
			}

			setState(893);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(887);
				match(T__5);
				setState(889);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
				case 1:
					{
					setState(888);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(891);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(892);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PreconditionContext extends ParserRuleContext {
		public IdentifierContext name;
		public Token message;
		public FormulaContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public PreconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPrecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPrecondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPrecondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreconditionContext precondition() throws RecognitionException {
		PreconditionContext _localctx = new PreconditionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_precondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(895);
			_la = _input.LA(1);
			if ( !(_la==T__78 || _la==T__79) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(902);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(896);
				((PreconditionContext)_localctx).name = identifier();
				setState(900);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(897);
					match(T__14);
					setState(898);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(899);
					match(T__15);
					}
				}

				}
			}

			setState(910);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(904);
				match(T__5);
				setState(906);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
				case 1:
					{
					setState(905);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(908);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(909);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PostconditionContext extends ParserRuleContext {
		public IdentifierContext name;
		public Token message;
		public FormulaContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public PostconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPostcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPostcondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPostcondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostconditionContext postcondition() throws RecognitionException {
		PostconditionContext _localctx = new PostconditionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_postcondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(912);
			_la = _input.LA(1);
			if ( !(_la==T__80 || _la==T__81) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(919);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(913);
				((PostconditionContext)_localctx).name = identifier();
				setState(917);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(914);
					match(T__14);
					setState(915);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(916);
					match(T__15);
					}
				}

				}
			}

			setState(927);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(921);
				match(T__5);
				setState(923);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
				case 1:
					{
					setState(922);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(925);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(926);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class VisibilityKindContext extends ParserRuleContext {
		public VisibilityKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibilityKind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterVisibilityKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitVisibilityKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitVisibilityKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisibilityKindContext visibilityKind() throws RecognitionException {
		VisibilityKindContext _localctx = new VisibilityKindContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_visibilityKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(929);
			_la = _input.LA(1);
			if ( !(_la==T__19 || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) ) {
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

	public static class AtomContext extends ParserRuleContext {
		public Token id;
		public TerminalNode IDENTIFIER() { return getToken(AlloyInEcoreParser.IDENTIFIER, 0); }
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_atom);
		try {
			setState(934);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(931);
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
				setState(933);
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

	public static class ArityContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public ArityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterArity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitArity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitArity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArityContext arity() throws RecognitionException {
		ArityContext _localctx = new ArityContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_arity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterNo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitNo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitNo(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSome(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForOne(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSumDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSumDeclaration(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForAll(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLone(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLt(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForSome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForSome(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitNot(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterF_paranthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitF_paranthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitF_paranthesis(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitAnd(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitFunction(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterGte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitGte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitGte(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterAcyclic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitAcyclic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitAcyclic(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLet(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLte(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOr(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIn(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOne(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends FormulaContext {
		public FalseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitFalse(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIff(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEq(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitGt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitGt(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEqual(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForLone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForLone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForLone(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTotalOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTotalOrder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTotalOrder(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends FormulaContext {
		public TrueContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTrue(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterForNo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitForNo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitForNo(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitImplies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitImplies(this);
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
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(939);
				match(T__85);
				setState(940);
				expression(0);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(941);
				match(T__86);
				setState(942);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(943);
				match(T__87);
				setState(944);
				expression(0);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(945);
				match(T__88);
				setState(946);
				expression(0);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(947);
				((InContext)_localctx).left = expression(0);
				setState(949);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(948);
					((InContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((InContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(951);
				match(T__91);
				setState(952);
				((InContext)_localctx).right = expression(0);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(954);
				((EqualContext)_localctx).left = expression(0);
				setState(956);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(955);
					((EqualContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((EqualContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(958);
				match(T__20);
				setState(959);
				((EqualContext)_localctx).right = expression(0);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(961);
				((EqContext)_localctx).left = intexpression(0);
				setState(963);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(962);
					((EqContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((EqContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(965);
				match(T__20);
				setState(966);
				((EqContext)_localctx).right = intexpression(0);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(968);
				((LtContext)_localctx).left = intexpression(0);
				setState(970);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(969);
					((LtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((LtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(972);
				match(T__73);
				setState(973);
				((LtContext)_localctx).right = intexpression(0);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(975);
				((LteContext)_localctx).left = intexpression(0);
				setState(977);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(976);
					((LteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((LteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(979);
				match(T__92);
				setState(980);
				((LteContext)_localctx).right = intexpression(0);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(982);
				((GtContext)_localctx).left = intexpression(0);
				setState(984);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(983);
					((GtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((GtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(986);
				match(T__74);
				setState(987);
				((GtContext)_localctx).right = intexpression(0);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(989);
				((GteContext)_localctx).left = intexpression(0);
				setState(991);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(990);
					((GteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((GteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
				}

				setState(993);
				match(T__93);
				setState(994);
				((GteContext)_localctx).right = intexpression(0);
				}
				break;
			case 12:
				{
				_localctx = new SumDeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(38)).var =  0;
				{
				setState(997);
				match(T__94);
				setState(998);
				decls();
				setState(999);
				match(T__95);
				setState(1000);
				intexpression(0);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(38)).var; i++) declarations.pop();
				}
				break;
			case 13:
				{
				_localctx = new AcyclicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1004);
				match(T__96);
				setState(1005);
				match(T__10);
				setState(1006);
				relationId();
				setState(1007);
				match(T__11);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1009);
				match(T__97);
				setState(1010);
				match(T__10);
				setState(1011);
				((FunctionContext)_localctx).rel = relationId();
				setState(1012);
				match(T__5);
				setState(1013);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1014);
				match(T__98);
				setState(1015);
				((FunctionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__86 || _la==T__87) ) {
					((FunctionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1016);
				((FunctionContext)_localctx).range = expression(0);
				setState(1017);
				match(T__11);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1019);
				match(T__99);
				setState(1020);
				match(T__10);
				setState(1021);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1022);
				match(T__2);
				setState(1023);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1024);
				match(T__2);
				setState(1025);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1026);
				match(T__2);
				setState(1027);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1028);
				match(T__11);
				}
				break;
			case 16:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1030);
				((NotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__89 || _la==T__90) ) {
					((NotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1031);
				formula(14);
				}
				break;
			case 17:
				{
				_localctx = new ForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(38)).var =  0;
				{
				setState(1033);
				match(T__108);
				setState(1034);
				decls();
				setState(1055);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1035);
					match(T__95);
					setState(1045);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
					case 1:
						{
						setState(1036);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1037);
						match(T__1);
						setState(1041);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1038);
								formula(0);
								}
								} 
							}
							setState(1043);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
						}
						setState(1044);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1047);
					match(T__1);
					setState(1051);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,170,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1048);
							formula(0);
							}
							} 
						}
						setState(1053);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,170,_ctx);
					}
					setState(1054);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(38)).var; i++) declarations.pop();
				}
				break;
			case 18:
				{
				_localctx = new ForSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(38)).var =  0;
				{
				setState(1060);
				match(T__88);
				setState(1061);
				decls();
				setState(1082);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1062);
					match(T__95);
					setState(1072);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
					case 1:
						{
						setState(1063);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1064);
						match(T__1);
						setState(1068);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,172,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1065);
								formula(0);
								}
								} 
							}
							setState(1070);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,172,_ctx);
						}
						setState(1071);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1074);
					match(T__1);
					setState(1078);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1075);
							formula(0);
							}
							} 
						}
						setState(1080);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
					}
					setState(1081);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(38)).var; i++) declarations.pop();
				}
				break;
			case 19:
				{
				_localctx = new ForNoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(38)).var =  0;
				{
				setState(1087);
				match(T__85);
				setState(1088);
				decls();
				setState(1109);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1089);
					match(T__95);
					setState(1099);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
					case 1:
						{
						setState(1090);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1091);
						match(T__1);
						setState(1095);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1092);
								formula(0);
								}
								} 
							}
							setState(1097);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
						}
						setState(1098);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1101);
					match(T__1);
					setState(1105);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1102);
							formula(0);
							}
							} 
						}
						setState(1107);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
					}
					setState(1108);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(38)).var; i++) declarations.pop();
				}
				break;
			case 20:
				{
				_localctx = new ForOneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(38)).var =  0;
				{
				setState(1114);
				match(T__87);
				setState(1115);
				decls();
				setState(1136);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1116);
					match(T__95);
					setState(1126);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
					case 1:
						{
						setState(1117);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1118);
						match(T__1);
						setState(1122);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1119);
								formula(0);
								}
								} 
							}
							setState(1124);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
						}
						setState(1125);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1128);
					match(T__1);
					setState(1132);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,182,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1129);
							formula(0);
							}
							} 
						}
						setState(1134);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,182,_ctx);
					}
					setState(1135);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(38)).var; i++) declarations.pop();
				}
				break;
			case 21:
				{
				_localctx = new ForLoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(38)).var =  0;
				{
				setState(1141);
				match(T__86);
				setState(1142);
				decls();
				setState(1163);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1143);
					match(T__95);
					setState(1153);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
					case 1:
						{
						setState(1144);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1145);
						match(T__1);
						setState(1149);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1146);
								formula(0);
								}
								} 
							}
							setState(1151);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
						}
						setState(1152);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1155);
					match(T__1);
					setState(1159);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1156);
							formula(0);
							}
							} 
						}
						setState(1161);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
					}
					setState(1162);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(38)).var; i++) declarations.pop();
				}
				break;
			case 22:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(38)).var =  0;
				{
				setState(1168);
				match(T__109);
				setState(1169);
				letDecls();
				setState(1190);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1170);
					match(T__95);
					setState(1180);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
					case 1:
						{
						setState(1171);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1172);
						match(T__1);
						setState(1176);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1173);
								formula(0);
								}
								} 
							}
							setState(1178);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
						}
						setState(1179);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1182);
					match(T__1);
					setState(1186);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1183);
							formula(0);
							}
							} 
						}
						setState(1188);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
					}
					setState(1189);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(38)).var; i++) declarations.pop();
				}
				break;
			case 23:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1194);
				match(T__110);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1195);
				match(T__111);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1196);
				match(T__14);
				setState(1197);
				formula(0);
				setState(1198);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1202);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1203);
						((AndContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__100 || _la==T__101) ) {
							((AndContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1204);
						((AndContext)_localctx).right = formula(13);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1205);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1206);
						((OrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__102 || _la==T__103) ) {
							((OrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1207);
						((OrContext)_localctx).right = formula(12);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1208);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1209);
						((ImpliesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__104 || _la==T__105) ) {
							((ImpliesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1210);
						((ImpliesContext)_localctx).right = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1211);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1212);
						((IffContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__106 || _la==T__107) ) {
							((IffContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1213);
						((IffContext)_localctx).right = formula(10);
						}
						break;
					}
					} 
				}
				setState(1218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitProduct(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoneContext extends ExpressionContext {
		public NoneContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitNone(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUnion(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBoxjoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBoxjoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBoxjoin(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterComprehension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitComprehension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitComprehension(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnivContext extends ExpressionContext {
		public UnivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterUniv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitUniv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUniv(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterReflexive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitReflexive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitReflexive(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterE_paranthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitE_paranthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitE_paranthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdenContext extends ExpressionContext {
		public IdenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIden(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIden(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIden(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntsContext extends ExpressionContext {
		public IntsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInts(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIntersection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIntersection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIntersection(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitRel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitRel(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDifference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDifference(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTranspose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTranspose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTranspose(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitJoin(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOverride(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOverride(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOverride(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIfExpression(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterClosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitClosure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitClosure(this);
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
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1220);
				match(T__112);
				setState(1221);
				expression(19);
				}
				break;
			case 2:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1222);
				match(T__113);
				setState(1223);
				expression(18);
				}
				break;
			case 3:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1224);
				match(T__55);
				setState(1225);
				expression(17);
				}
				break;
			case 4:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(38)).var =  0;
				{
				setState(1227);
				match(T__1);
				setState(1228);
				comprehensionDecls();
				setState(1229);
				match(T__95);
				setState(1230);
				formula(0);
				setState(1231);
				match(T__3);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(38)).var; i++) declarations.pop();
				}
				break;
			case 5:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1235);
				((IfExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__104 || _la==T__105) ) {
					((IfExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1236);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1237);
				match(T__119);
				setState(1238);
				((IfExpressionContext)_localctx).thenExpr = expression(0);
				setState(1239);
				match(T__120);
				setState(1240);
				((IfExpressionContext)_localctx).elseExpr = expression(8);
				}
				break;
			case 6:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1242);
				match(T__121);
				}
				break;
			case 7:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1243);
				match(T__122);
				}
				break;
			case 8:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1244);
				match(T__123);
				}
				break;
			case 9:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1245);
				match(T__124);
				}
				break;
			case 10:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1246);
				match(T__14);
				setState(1247);
				expression(0);
				setState(1248);
				match(T__15);
				}
				break;
			case 11:
				{
				_localctx = new RelContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1250);
				if (!(isRelation())) throw new FailedPredicateException(this, "isRelation()");
				setState(1251);
				relationId();
				}
				break;
			case 12:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1252);
				if (!(!isRelation())) throw new FailedPredicateException(this, "!isRelation()");
				setState(1253);
				((VarContext)_localctx).variableId = variableId();

				            System.out.print("variable found: " + (((VarContext)_localctx).variableId!=null?_input.getText(((VarContext)_localctx).variableId.start,((VarContext)_localctx).variableId.stop):null) + "-> ");
				            String s = (((VarContext)_localctx).variableId!=null?_input.getText(((VarContext)_localctx).variableId.start,((VarContext)_localctx).variableId.stop):null);
				            if ( declarations.contains(s) ) {System.out.println("defined");}
				            else {System.err.println("undefined variable found: '"+ s + "' at "+ getLocation());}
				      
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1287);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1258);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1259);
						match(T__56);
						setState(1260);
						((UnionContext)_localctx).right = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1261);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1262);
						match(T__114);
						setState(1263);
						((IntersectionContext)_localctx).right = expression(16);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1264);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1265);
						match(T__115);
						setState(1266);
						((DifferenceContext)_localctx).right = expression(15);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1267);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1268);
						match(T__116);
						setState(1269);
						((JoinContext)_localctx).right = expression(14);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1270);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1272);
						_la = _input.LA(1);
						if (((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__117 - 87)))) != 0)) {
							{
							setState(1271);
							((ProductContext)_localctx).leftMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__117 - 87)))) != 0)) ) {
								((ProductContext)_localctx).leftMult = (Token)_errHandler.recoverInline(this);
							} else {
								consume();
							}
							}
						}

						setState(1274);
						match(T__98);
						setState(1276);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
						case 1:
							{
							setState(1275);
							((ProductContext)_localctx).rightMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__117 - 87)))) != 0)) ) {
								((ProductContext)_localctx).rightMult = (Token)_errHandler.recoverInline(this);
							} else {
								consume();
							}
							}
							break;
						}
						setState(1278);
						((ProductContext)_localctx).right = expression(11);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1279);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1280);
						match(T__118);
						setState(1281);
						((OverrideContext)_localctx).right = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BoxjoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxjoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1282);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1283);
						match(T__10);
						setState(1284);
						((BoxjoinContext)_localctx).left = expression(0);
						setState(1285);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(1291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitMinus(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIntConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIntConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIntConstant(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterI_paranthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitI_paranthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitI_paranthesis(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIfIntExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIfIntExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIfIntExpression(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitCount(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitCount(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSum(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDivide(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitMultiply(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterModulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitModulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitModulo(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPlus(this);
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
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_intexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1312);
			switch (_input.LA(1)) {
			case T__104:
			case T__105:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1293);
				((IfIntExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__104 || _la==T__105) ) {
					((IfIntExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1294);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1295);
				match(T__119);
				setState(1296);
				((IfIntExpressionContext)_localctx).thenExpr = intexpression(0);
				setState(1297);
				match(T__120);
				setState(1298);
				((IfIntExpressionContext)_localctx).elseExpr = intexpression(10);
				}
				break;
			case T__94:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1300);
				match(T__94);
				setState(1301);
				expression(0);
				}
				break;
			case T__47:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1302);
				match(T__47);
				setState(1303);
				expression(0);
				}
				break;
			case T__115:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1305);
				_la = _input.LA(1);
				if (_la==T__115) {
					{
					setState(1304);
					((IntConstantContext)_localctx).sign = match(T__115);
					}
				}

				setState(1307);
				integer();
				}
				break;
			case T__14:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1308);
				match(T__14);
				setState(1309);
				intexpression(0);
				setState(1310);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1331);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1329);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntexpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1314);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1315);
						_la = _input.LA(1);
						if ( !(_la==T__56 || _la==T__125) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1316);
						((PlusContext)_localctx).right = intexpression(8);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntexpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1317);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1318);
						_la = _input.LA(1);
						if ( !(_la==T__115 || _la==T__126) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1319);
						((MinusContext)_localctx).right = intexpression(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntexpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1320);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1321);
						_la = _input.LA(1);
						if ( !(_la==T__55 || _la==T__127) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1322);
						((MultiplyContext)_localctx).right = intexpression(6);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntexpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1323);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1324);
						_la = _input.LA(1);
						if ( !(_la==T__128 || _la==T__129) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1325);
						((DivideContext)_localctx).right = intexpression(5);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntexpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1326);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1327);
						_la = _input.LA(1);
						if ( !(_la==T__130 || _la==T__131) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1328);
						((ModuloContext)_localctx).right = intexpression(4);
						}
						break;
					}
					} 
				}
				setState(1333);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1334);
			decl();
			setState(1339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1335);
				match(T__2);
				setState(1336);
				decl();
				}
				}
				setState(1341);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterOneOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitOneOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitOneOf(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSomeOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSomeOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSomeOf(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLoneOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLoneOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLoneOf(this);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSetOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSetOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSetOf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_decl);
		int _la;
		try {
			setState(1408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1343);
				_la = _input.LA(1);
				if (_la==T__132) {
					{
					setState(1342);
					((OneOfContext)_localctx).disj = match(T__132);
					}
				}

				setState(1345);
				((OneOfContext)_localctx).variableId = variableId();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
				setState(1350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1346);
					match(T__2);
					setState(1347);
					((OneOfContext)_localctx).variableId = variableId();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
					}
					}
					setState(1352);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1353);
				match(T__5);
				setState(1355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
				case 1:
					{
					setState(1354);
					match(T__87);
					}
					break;
				}
				setState(1357);
				expression(0);
				((FormulaContext)getInvokingContext(38)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(38)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1361);
				_la = _input.LA(1);
				if (_la==T__132) {
					{
					setState(1360);
					((LoneOfContext)_localctx).disj = match(T__132);
					}
				}

				setState(1363);
				((LoneOfContext)_localctx).variableId = variableId();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
				setState(1368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1364);
					match(T__2);
					setState(1365);
					((LoneOfContext)_localctx).variableId = variableId();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
					}
					}
					setState(1370);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1371);
				match(T__5);
				setState(1372);
				match(T__86);
				setState(1373);
				expression(0);
				((FormulaContext)getInvokingContext(38)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(38)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1377);
				_la = _input.LA(1);
				if (_la==T__132) {
					{
					setState(1376);
					((SomeOfContext)_localctx).disj = match(T__132);
					}
				}

				setState(1379);
				((SomeOfContext)_localctx).variableId = variableId();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
				setState(1384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1380);
					match(T__2);
					setState(1381);
					((SomeOfContext)_localctx).variableId = variableId();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
					}
					}
					setState(1386);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1387);
				match(T__5);
				setState(1388);
				match(T__88);
				setState(1389);
				expression(0);
				((FormulaContext)getInvokingContext(38)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(38)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1393);
				_la = _input.LA(1);
				if (_la==T__132) {
					{
					setState(1392);
					((SetOfContext)_localctx).disj = match(T__132);
					}
				}

				setState(1395);
				((SetOfContext)_localctx).variableId = variableId();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
				setState(1400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1396);
					match(T__2);
					setState(1397);
					((SetOfContext)_localctx).variableId = variableId();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
					}
					}
					setState(1402);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1403);
				match(T__5);
				setState(1404);
				match(T__117);
				setState(1405);
				expression(0);
				((FormulaContext)getInvokingContext(38)).var =  declareVariables(((SetOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(38)).var);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLetDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLetDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLetDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetDeclsContext letDecls() throws RecognitionException {
		LetDeclsContext _localctx = new LetDeclsContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_letDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1410);
			letDecl();
			setState(1415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1411);
				match(T__2);
				setState(1412);
				letDecl();
				}
				}
				setState(1417);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLetDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLetDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLetDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetDeclContext letDecl() throws RecognitionException {
		LetDeclContext _localctx = new LetDeclContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_letDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1418);
			((LetDeclContext)_localctx).variableId = variableId();
			((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
			setState(1423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1419);
				match(T__2);
				setState(1420);
				((LetDeclContext)_localctx).variableId = variableId();
				((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
				}
				}
				setState(1425);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1426);
			match(T__20);
			setState(1427);
			expression(0);
			}
			((FormulaContext)getInvokingContext(38)).var =  declareVariables(((LetDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(38)).var);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterComprehensionDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitComprehensionDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitComprehensionDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComprehensionDeclsContext comprehensionDecls() throws RecognitionException {
		ComprehensionDeclsContext _localctx = new ComprehensionDeclsContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_comprehensionDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1431);
			comprehensionDecl();
			setState(1436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1432);
				match(T__2);
				setState(1433);
				comprehensionDecl();
				}
				}
				setState(1438);
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
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterComprehensionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitComprehensionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitComprehensionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComprehensionDeclContext comprehensionDecl() throws RecognitionException {
		ComprehensionDeclContext _localctx = new ComprehensionDeclContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_comprehensionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1440);
			_la = _input.LA(1);
			if (_la==T__132) {
				{
				setState(1439);
				((ComprehensionDeclContext)_localctx).disj = match(T__132);
				}
			}

			{
			setState(1442);
			((ComprehensionDeclContext)_localctx).variableId = variableId();
			((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
			setState(1447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1443);
				match(T__2);
				setState(1444);
				((ComprehensionDeclContext)_localctx).variableId = variableId();
				((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
				}
				}
				setState(1449);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1450);
			match(T__5);
			setState(1452);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
			case 1:
				{
				setState(1451);
				match(T__87);
				}
				break;
			}
			setState(1454);
			expression(0);
			}
			((FormulaContext)getInvokingContext(38)).var =  declareVariables(((ComprehensionDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(38)).var);
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
		public TerminalNode IDENTIFIER() { return getToken(AlloyInEcoreParser.IDENTIFIER, 0); }
		public RelationIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterRelationId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitRelationId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitRelationId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationIdContext relationId() throws RecognitionException {
		RelationIdContext _localctx = new RelationIdContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_relationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1458);
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
		public TerminalNode IDENTIFIER() { return getToken(AlloyInEcoreParser.IDENTIFIER, 0); }
		public VariableIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterVariableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitVariableId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitVariableId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableIdContext variableId() throws RecognitionException {
		VariableIdContext _localctx = new VariableIdContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_variableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1460);
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
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1462);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> firstPart = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> midParts = new ArrayList<IdentifierContext>();
		public IdentifierContext lastPart;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_qualifiedName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1464);
			((QualifiedNameContext)_localctx).identifier = identifier();
			((QualifiedNameContext)_localctx).firstPart.add(((QualifiedNameContext)_localctx).identifier);
			setState(1474);
			_la = _input.LA(1);
			if (_la==T__133) {
				{
				setState(1469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,221,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1465);
						match(T__133);
						setState(1466);
						((QualifiedNameContext)_localctx).identifier = identifier();
						((QualifiedNameContext)_localctx).midParts.add(((QualifiedNameContext)_localctx).identifier);
						}
						} 
					}
					setState(1471);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,221,_ctx);
				}
				{
				setState(1472);
				match(T__133);
				setState(1473);
				((QualifiedNameContext)_localctx).lastPart = identifier();
				}
				}
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AlloyInEcoreParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1476);
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

	public static class UpperContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public UpperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterUpper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitUpper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUpper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpperContext upper() throws RecognitionException {
		UpperContext _localctx = new UpperContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478);
			_la = _input.LA(1);
			if ( !(_la==T__55 || _la==INT) ) {
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

	public static class LowerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public LowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lower; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerContext lower() throws RecognitionException {
		LowerContext _localctx = new LowerContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1480);
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

	public static class SignedContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public SignedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSigned(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSigned(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSigned(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignedContext signed() throws RecognitionException {
		SignedContext _localctx = new SignedContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_signed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1483);
			_la = _input.LA(1);
			if (_la==T__115) {
				{
				setState(1482);
				match(T__115);
				}
			}

			setState(1485);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 38:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 39:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 40:
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
			return isRelation();
		case 5:
			return !isRelation();
		case 6:
			return precpred(_ctx, 16);
		case 7:
			return precpred(_ctx, 15);
		case 8:
			return precpred(_ctx, 14);
		case 9:
			return precpred(_ctx, 13);
		case 10:
			return precpred(_ctx, 11);
		case 11:
			return precpred(_ctx, 10);
		case 12:
			return precpred(_ctx, 12);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0090\u05d2\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\5\2r\n\2\3\2\3\2\3\2\3\2\3"+
		"\2\7\2y\n\2\f\2\16\2|\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0095\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\7\5\u009c\n\5\f\5\16\5\u009f\13\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5\u00a7\n\5\f\5\16\5\u00aa\13\5\3\5\3\5\5\5\u00ae\n\5\3\5\3\5\3\6\3"+
		"\6\3\6\7\6\u00b5\n\6\f\6\16\6\u00b8\13\6\3\6\3\6\3\7\3\7\5\7\u00be\n\7"+
		"\3\7\3\7\5\7\u00c2\n\7\3\7\3\7\3\7\3\7\5\7\u00c8\n\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\7\b\u00d2\n\b\f\b\16\b\u00d5\13\b\5\b\u00d7\n\b\3\b\3\b"+
		"\3\b\3\b\3\b\7\b\u00de\n\b\f\b\16\b\u00e1\13\b\5\b\u00e3\n\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00f2\n\b\3\t\3\t\3\t\3"+
		"\t\7\t\u00f8\n\t\f\t\16\t\u00fb\13\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0103"+
		"\n\t\f\t\16\t\u0106\13\t\3\t\3\t\5\t\u010a\n\t\3\n\5\n\u010d\n\n\3\n\3"+
		"\n\5\n\u0111\n\n\3\n\7\n\u0114\n\n\f\n\16\n\u0117\13\n\3\n\7\n\u011a\n"+
		"\n\f\n\16\n\u011d\13\n\3\13\3\13\3\13\3\13\5\13\u0123\n\13\3\13\3\13\3"+
		"\13\3\f\5\f\u0129\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\7\f\u0138\n\f\f\f\16\f\u013b\13\f\3\f\3\f\5\f\u013f\n\f\3\r\3\r\3"+
		"\r\5\r\u0144\n\r\3\16\5\16\u0147\n\16\3\16\5\16\u014a\n\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\7\16\u0152\n\16\f\16\16\16\u0155\13\16\5\16\u0157\n"+
		"\16\3\16\3\16\5\16\u015b\n\16\3\16\3\16\5\16\u015f\n\16\3\16\5\16\u0162"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\7\16\u0169\n\16\f\16\16\16\u016c\13\16"+
		"\3\16\3\16\5\16\u0170\n\16\3\17\3\17\5\17\u0174\n\17\3\20\5\20\u0177\n"+
		"\20\3\20\5\20\u017a\n\20\3\20\3\20\5\20\u017e\n\20\3\20\5\20\u0181\n\20"+
		"\3\20\5\20\u0184\n\20\3\20\3\20\5\20\u0188\n\20\3\20\5\20\u018b\n\20\3"+
		"\20\3\20\3\20\3\20\5\20\u0191\n\20\3\20\3\20\3\20\5\20\u0196\n\20\5\20"+
		"\u0198\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u01a5\n\20\3\20\5\20\u01a8\n\20\6\20\u01aa\n\20\r\20\16\20\u01ab\3\20"+
		"\5\20\u01af\n\20\3\20\3\20\3\20\3\20\5\20\u01b5\n\20\3\20\3\20\5\20\u01b9"+
		"\n\20\3\20\3\20\3\20\5\20\u01be\n\20\3\20\3\20\5\20\u01c2\n\20\3\20\7"+
		"\20\u01c5\n\20\f\20\16\20\u01c8\13\20\3\20\3\20\5\20\u01cc\n\20\3\21\5"+
		"\21\u01cf\n\21\3\21\5\21\u01d2\n\21\3\21\3\21\5\21\u01d6\n\21\3\21\5\21"+
		"\u01d9\n\21\3\21\5\21\u01dc\n\21\3\21\3\21\5\21\u01e0\n\21\3\21\5\21\u01e3"+
		"\n\21\3\21\3\21\3\21\3\21\5\21\u01e9\n\21\3\21\3\21\3\21\5\21\u01ee\n"+
		"\21\5\21\u01f0\n\21\3\21\3\21\5\21\u01f4\n\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0203\n\21\3\21\5\21\u0206"+
		"\n\21\6\21\u0208\n\21\r\21\16\21\u0209\3\21\5\21\u020d\n\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\7\21\u0215\n\21\f\21\16\21\u0218\13\21\3\21\3\21"+
		"\3\21\3\21\5\21\u021e\n\21\3\21\3\21\5\21\u0222\n\21\3\21\3\21\3\21\5"+
		"\21\u0227\n\21\3\21\3\21\5\21\u022b\n\21\3\21\7\21\u022e\n\21\f\21\16"+
		"\21\u0231\13\21\3\21\3\21\5\21\u0235\n\21\3\22\5\22\u0238\n\22\3\22\5"+
		"\22\u023b\n\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0243\n\22\f\22\16\22"+
		"\u0246\13\22\5\22\u0248\n\22\3\22\3\22\3\22\3\22\5\22\u024e\n\22\5\22"+
		"\u0250\n\22\3\22\3\22\3\22\3\22\7\22\u0256\n\22\f\22\16\22\u0259\13\22"+
		"\5\22\u025b\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0264\n\22\3"+
		"\22\5\22\u0267\n\22\6\22\u0269\n\22\r\22\16\22\u026a\3\22\5\22\u026e\n"+
		"\22\3\22\3\22\3\22\3\22\3\22\7\22\u0275\n\22\f\22\16\22\u0278\13\22\3"+
		"\22\3\22\5\22\u027c\n\22\3\23\3\23\5\23\u0280\n\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0286\n\23\5\23\u0288\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u028f\n"+
		"\23\3\23\5\23\u0292\n\23\6\23\u0294\n\23\r\23\16\23\u0295\3\23\5\23\u0299"+
		"\n\23\3\23\3\23\7\23\u029d\n\23\f\23\16\23\u02a0\13\23\3\23\5\23\u02a3"+
		"\n\23\3\24\3\24\5\24\u02a7\n\24\3\25\3\25\3\25\3\25\5\25\u02ad\n\25\3"+
		"\25\5\25\u02b0\n\25\3\25\3\25\5\25\u02b4\n\25\3\25\3\25\3\26\5\26\u02b9"+
		"\n\26\3\26\3\26\5\26\u02bd\n\26\3\26\3\26\3\26\5\26\u02c2\n\26\3\26\3"+
		"\26\5\26\u02c6\n\26\3\26\3\26\3\26\5\26\u02cb\n\26\3\26\5\26\u02ce\n\26"+
		"\3\26\3\26\3\26\7\26\u02d3\n\26\f\26\16\26\u02d6\13\26\3\26\5\26\u02d9"+
		"\n\26\3\26\5\26\u02dc\n\26\3\27\3\27\3\30\5\30\u02e1\n\30\3\30\3\30\3"+
		"\30\5\30\u02e6\n\30\3\30\3\30\5\30\u02ea\n\30\3\30\3\30\3\30\5\30\u02ef"+
		"\n\30\3\30\5\30\u02f2\n\30\3\30\3\30\3\30\3\30\7\30\u02f8\n\30\f\30\16"+
		"\30\u02fb\13\30\3\30\3\30\5\30\u02ff\n\30\3\31\3\31\3\31\5\31\u0304\n"+
		"\31\3\31\3\31\5\31\u0308\n\31\3\31\3\31\7\31\u030c\n\31\f\31\16\31\u030f"+
		"\13\31\3\31\3\31\5\31\u0313\n\31\3\32\3\32\5\32\u0317\n\32\3\32\3\32\3"+
		"\32\3\32\7\32\u031d\n\32\f\32\16\32\u0320\13\32\3\32\3\32\5\32\u0324\n"+
		"\32\3\32\3\32\3\32\3\32\6\32\u032a\n\32\r\32\16\32\u032b\3\32\3\32\3\32"+
		"\5\32\u0331\n\32\3\33\3\33\3\33\3\33\3\34\3\34\5\34\u0339\n\34\3\35\3"+
		"\35\3\35\3\35\5\35\u033f\n\35\3\36\3\36\3\36\5\36\u0344\n\36\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \7 \u034e\n \f \16 \u0351\13 \3 \3 \3 \3 \3 \3 "+
		"\7 \u0359\n \f \16 \u035c\13 \3 \3 \5 \u0360\n \3!\3!\5!\u0364\n!\3!\3"+
		"!\5!\u0368\n!\3!\3!\5!\u036c\n!\3\"\5\"\u036f\n\"\3\"\3\"\3\"\3\"\3\""+
		"\5\"\u0376\n\"\5\"\u0378\n\"\3\"\3\"\5\"\u037c\n\"\3\"\3\"\5\"\u0380\n"+
		"\"\3#\3#\3#\3#\3#\5#\u0387\n#\5#\u0389\n#\3#\3#\5#\u038d\n#\3#\3#\5#\u0391"+
		"\n#\3$\3$\3$\3$\3$\5$\u0398\n$\5$\u039a\n$\3$\3$\5$\u039e\n$\3$\3$\5$"+
		"\u03a2\n$\3%\3%\3&\3&\3&\5&\u03a9\n&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\5(\u03b8\n(\3(\3(\3(\3(\3(\5(\u03bf\n(\3(\3(\3(\3(\3(\5(\u03c6"+
		"\n(\3(\3(\3(\3(\3(\5(\u03cd\n(\3(\3(\3(\3(\3(\5(\u03d4\n(\3(\3(\3(\3("+
		"\3(\5(\u03db\n(\3(\3(\3(\3(\3(\5(\u03e2\n(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u0412\n(\f(\16(\u0415\13"+
		"(\3(\5(\u0418\n(\3(\3(\7(\u041c\n(\f(\16(\u041f\13(\3(\5(\u0422\n(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\7(\u042d\n(\f(\16(\u0430\13(\3(\5(\u0433\n(\3"+
		"(\3(\7(\u0437\n(\f(\16(\u043a\13(\3(\5(\u043d\n(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\7(\u0448\n(\f(\16(\u044b\13(\3(\5(\u044e\n(\3(\3(\7(\u0452\n(\f"+
		"(\16(\u0455\13(\3(\5(\u0458\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u0463\n("+
		"\f(\16(\u0466\13(\3(\5(\u0469\n(\3(\3(\7(\u046d\n(\f(\16(\u0470\13(\3"+
		"(\5(\u0473\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u047e\n(\f(\16(\u0481\13("+
		"\3(\5(\u0484\n(\3(\3(\7(\u0488\n(\f(\16(\u048b\13(\3(\5(\u048e\n(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\7(\u0499\n(\f(\16(\u049c\13(\3(\5(\u049f\n(\3("+
		"\3(\7(\u04a3\n(\f(\16(\u04a6\13(\3(\5(\u04a9\n(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\5(\u04b3\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u04c1\n(\f(\16(\u04c4"+
		"\13(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u04eb\n)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u04fb\n)\3)\3)\5)\u04ff\n)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\7)\u050a\n)\f)\16)\u050d\13)\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\5*\u051c\n*\3*\3*\3*\3*\3*\5*\u0523\n*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u0534\n*\f*\16*\u0537\13*\3+\3+\3"+
		"+\7+\u053c\n+\f+\16+\u053f\13+\3,\5,\u0542\n,\3,\3,\3,\7,\u0547\n,\f,"+
		"\16,\u054a\13,\3,\3,\5,\u054e\n,\3,\3,\3,\3,\5,\u0554\n,\3,\3,\3,\7,\u0559"+
		"\n,\f,\16,\u055c\13,\3,\3,\3,\3,\3,\3,\5,\u0564\n,\3,\3,\3,\7,\u0569\n"+
		",\f,\16,\u056c\13,\3,\3,\3,\3,\3,\3,\5,\u0574\n,\3,\3,\3,\7,\u0579\n,"+
		"\f,\16,\u057c\13,\3,\3,\3,\3,\3,\5,\u0583\n,\3-\3-\3-\7-\u0588\n-\f-\16"+
		"-\u058b\13-\3.\3.\3.\7.\u0590\n.\f.\16.\u0593\13.\3.\3.\3.\3.\3.\3/\3"+
		"/\3/\7/\u059d\n/\f/\16/\u05a0\13/\3\60\5\60\u05a3\n\60\3\60\3\60\3\60"+
		"\7\60\u05a8\n\60\f\60\16\60\u05ab\13\60\3\60\3\60\5\60\u05af\n\60\3\60"+
		"\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\7\64\u05be"+
		"\n\64\f\64\16\64\u05c1\13\64\3\64\3\64\5\64\u05c5\n\64\3\65\3\65\3\66"+
		"\3\66\3\67\3\67\38\58\u05ce\n8\38\38\38\2\5NPR9\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjln\2\25"+
		"\3\2:<\3\2CG\3\2\u008c\u008d\3\2QR\3\2ST\4\2\26\26UW\3\2\\]\3\2YZ\3\2"+
		"gh\3\2ij\3\2kl\3\2mn\4\2Y[xx\4\2;;\u0080\u0080\4\2vv\u0081\u0081\4\2:"+
		":\u0082\u0082\3\2\u0083\u0084\3\2\u0085\u0086\4\2::\u0089\u0089\u06de"+
		"\2q\3\2\2\2\4\u0080\3\2\2\2\6\u0094\3\2\2\2\b\u0096\3\2\2\2\n\u00b1\3"+
		"\2\2\2\f\u00bb\3\2\2\2\16\u00f1\3\2\2\2\20\u0109\3\2\2\2\22\u010c\3\2"+
		"\2\2\24\u011e\3\2\2\2\26\u0128\3\2\2\2\30\u0143\3\2\2\2\32\u0146\3\2\2"+
		"\2\34\u0173\3\2\2\2\36\u0176\3\2\2\2 \u01ce\3\2\2\2\"\u0237\3\2\2\2$\u027f"+
		"\3\2\2\2&\u02a6\3\2\2\2(\u02a8\3\2\2\2*\u02b8\3\2\2\2,\u02dd\3\2\2\2."+
		"\u02e0\3\2\2\2\60\u0303\3\2\2\2\62\u0314\3\2\2\2\64\u0332\3\2\2\2\66\u0338"+
		"\3\2\2\28\u033e\3\2\2\2:\u0343\3\2\2\2<\u0345\3\2\2\2>\u035f\3\2\2\2@"+
		"\u0361\3\2\2\2B\u036e\3\2\2\2D\u0381\3\2\2\2F\u0392\3\2\2\2H\u03a3\3\2"+
		"\2\2J\u03a8\3\2\2\2L\u03aa\3\2\2\2N\u04b2\3\2\2\2P\u04ea\3\2\2\2R\u0522"+
		"\3\2\2\2T\u0538\3\2\2\2V\u0582\3\2\2\2X\u0584\3\2\2\2Z\u058c\3\2\2\2\\"+
		"\u0599\3\2\2\2^\u05a2\3\2\2\2`\u05b4\3\2\2\2b\u05b6\3\2\2\2d\u05b8\3\2"+
		"\2\2f\u05ba\3\2\2\2h\u05c6\3\2\2\2j\u05c8\3\2\2\2l\u05ca\3\2\2\2n\u05cd"+
		"\3\2\2\2pr\5\4\3\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\5\b\5\2tu\b\2\1\2u"+
		"v\5\n\6\2vz\b\2\1\2wy\5N(\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}"+
		"\3\2\2\2|z\3\2\2\2}~\b\2\1\2~\177\b\2\1\2\177\3\3\2\2\2\u0080\u0081\7"+
		"\3\2\2\u0081\u0082\7\4\2\2\u0082\u0083\5\6\4\2\u0083\u0084\7\5\2\2\u0084"+
		"\u0085\5\6\4\2\u0085\u0086\3\2\2\2\u0086\u0087\7\6\2\2\u0087\5\3\2\2\2"+
		"\u0088\u0089\7\7\2\2\u0089\u008a\7\b\2\2\u008a\u0095\5d\63\2\u008b\u008c"+
		"\7\t\2\2\u008c\u008d\7\b\2\2\u008d\u0095\5d\63\2\u008e\u008f\7\n\2\2\u008f"+
		"\u0090\7\b\2\2\u0090\u0095\5d\63\2\u0091\u0092\7\13\2\2\u0092\u0093\7"+
		"\b\2\2\u0093\u0095\5d\63\2\u0094\u0088\3\2\2\2\u0094\u008b\3\2\2\2\u0094"+
		"\u008e\3\2\2\2\u0094\u0091\3\2\2\2\u0095\7\3\2\2\2\u0096\u00ad\7\f\2\2"+
		"\u0097\u0098\7\4\2\2\u0098\u009d\5J&\2\u0099\u009a\7\5\2\2\u009a\u009c"+
		"\5J&\2\u009b\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\6"+
		"\2\2\u00a1\u00ae\3\2\2\2\u00a2\u00a3\7\r\2\2\u00a3\u00a8\5J&\2\u00a4\u00a5"+
		"\7\5\2\2\u00a5\u00a7\5J&\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00ab\u00ac\7\16\2\2\u00ac\u00ae\3\2\2\2\u00ad\u0097\3\2\2\2\u00ad"+
		"\u00a2\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\5\1\2\u00b0\t\3\2\2\2"+
		"\u00b1\u00b2\7\17\2\2\u00b2\u00b6\7\4\2\2\u00b3\u00b5\5\f\7\2\u00b4\u00b3"+
		"\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\6\2\2\u00ba\13\3\2\2"+
		"\2\u00bb\u00bd\5h\65\2\u00bc\u00be\5L\'\2\u00bd\u00bc\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\7\b\2\2\u00c0\u00c2\5P)\2\u00c1"+
		"\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\r"+
		"\2\2\u00c4\u00c7\5\16\b\2\u00c5\u00c6\7\5\2\2\u00c6\u00c8\5\16\b\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7\16"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b\7\1\2\u00cc\r\3\2\2\2\u00cd\u00d6"+
		"\7\4\2\2\u00ce\u00d3\5\20\t\2\u00cf\u00d0\7\5\2\2\u00d0\u00d2\5\20\t\2"+
		"\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00ce\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00f2\7\6\2\2\u00d9\u00e2\7\r"+
		"\2\2\u00da\u00df\5\20\t\2\u00db\u00dc\7\5\2\2\u00dc\u00de\5\20\t\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00da\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00f2\7\16\2\2\u00e5\u00e6\7"+
		"\4\2\2\u00e6\u00e7\5\20\t\2\u00e7\u00e8\7\20\2\2\u00e8\u00e9\5\20\t\2"+
		"\u00e9\u00ea\7\6\2\2\u00ea\u00f2\3\2\2\2\u00eb\u00ec\7\r\2\2\u00ec\u00ed"+
		"\5\20\t\2\u00ed\u00ee\7\20\2\2\u00ee\u00ef\5\20\t\2\u00ef\u00f0\7\16\2"+
		"\2\u00f0\u00f2\3\2\2\2\u00f1\u00cd\3\2\2\2\u00f1\u00d9\3\2\2\2\u00f1\u00e5"+
		"\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f2\17\3\2\2\2\u00f3\u00f4\7\21\2\2\u00f4"+
		"\u00f9\5J&\2\u00f5\u00f6\7\5\2\2\u00f6\u00f8\5J&\2\u00f7\u00f5\3\2\2\2"+
		"\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\7\22\2\2\u00fd\u010a\3\2\2\2"+
		"\u00fe\u00ff\7\r\2\2\u00ff\u0104\5J&\2\u0100\u0101\7\5\2\2\u0101\u0103"+
		"\5J&\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\7\16"+
		"\2\2\u0108\u010a\3\2\2\2\u0109\u00f3\3\2\2\2\u0109\u00fe\3\2\2\2\u010a"+
		"\21\3\2\2\2\u010b\u010d\5\4\3\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2"+
		"\2\u010d\u0110\3\2\2\2\u010e\u010f\7\23\2\2\u010f\u0111\5h\65\2\u0110"+
		"\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0115\3\2\2\2\u0112\u0114\5\24"+
		"\13\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u011b\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011a\5\26"+
		"\f\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\23\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u0122\7\24\2"+
		"\2\u011f\u0120\5h\65\2\u0120\u0121\7\b\2\2\u0121\u0123\3\2\2\2\u0122\u011f"+
		"\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\7\u008c\2"+
		"\2\u0125\u0126\7\25\2\2\u0126\25\3\2\2\2\u0127\u0129\5H%\2\u0128\u0127"+
		"\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7\26\2\2"+
		"\u012b\u012c\5h\65\2\u012c\u012d\7\b\2\2\u012d\u012e\5h\65\2\u012e\u012f"+
		"\3\2\2\2\u012f\u0130\7\27\2\2\u0130\u0131\7\u008c\2\2\u0131\u013e\3\2"+
		"\2\2\u0132\u0139\7\4\2\2\u0133\u0138\5\62\32\2\u0134\u0138\5\26\f\2\u0135"+
		"\u0138\5\30\r\2\u0136\u0138\5B\"\2\u0137\u0133\3\2\2\2\u0137\u0134\3\2"+
		"\2\2\u0137\u0135\3\2\2\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013c\u013f\7\6\2\2\u013d\u013f\7\25\2\2\u013e\u0132\3\2\2\2\u013e"+
		"\u013d\3\2\2\2\u013f\27\3\2\2\2\u0140\u0144\5\32\16\2\u0141\u0144\5*\26"+
		"\2\u0142\u0144\5.\30\2\u0143\u0140\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0142"+
		"\3\2\2\2\u0144\31\3\2\2\2\u0145\u0147\5H%\2\u0146\u0145\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u014a\7\30\2\2\u0149\u0148\3"+
		"\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\7\31\2\2\u014c"+
		"\u0156\5h\65\2\u014d\u014e\7\32\2\2\u014e\u0153\5f\64\2\u014f\u0150\7"+
		"\5\2\2\u0150\u0152\5f\64\2\u0151\u014f\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0156\u014d\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u015a\3\2\2\2\u0158"+
		"\u0159\7\b\2\2\u0159\u015b\7\u008c\2\2\u015a\u0158\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\u0161\3\2\2\2\u015c\u015e\7\4\2\2\u015d\u015f\7\33\2\2"+
		"\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162"+
		"\7\6\2\2\u0161\u015c\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u016f\3\2\2\2\u0163"+
		"\u016a\7\4\2\2\u0164\u0169\5\62\32\2\u0165\u0169\5\"\22\2\u0166\u0169"+
		"\5\34\17\2\u0167\u0169\5B\"\2\u0168\u0164\3\2\2\2\u0168\u0165\3\2\2\2"+
		"\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168"+
		"\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d"+
		"\u0170\7\6\2\2\u016e\u0170\7\25\2\2\u016f\u0163\3\2\2\2\u016f\u016e\3"+
		"\2\2\2\u0170\33\3\2\2\2\u0171\u0174\5\36\20\2\u0172\u0174\5 \21\2\u0173"+
		"\u0171\3\2\2\2\u0173\u0172\3\2\2\2\u0174\35\3\2\2\2\u0175\u0177\5H%\2"+
		"\u0176\u0175\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u017a"+
		"\7\34\2\2\u0179\u0178\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017d\3\2\2\2"+
		"\u017b\u017e\7\35\2\2\u017c\u017e\7\36\2\2\u017d\u017b\3\2\2\2\u017d\u017c"+
		"\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0180\3\2\2\2\u017f\u0181\7\37\2\2"+
		"\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0184"+
		"\7 \2\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0187\3\2\2\2\u0185"+
		"\u0188\7!\2\2\u0186\u0188\7\"\2\2\u0187\u0185\3\2\2\2\u0187\u0186\3\2"+
		"\2\2\u0187\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u018b\7#\2\2\u018a"+
		"\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\7$"+
		"\2\2\u018d\u0190\5h\65\2\u018e\u018f\7\27\2\2\u018f\u0191\7\u008c\2\2"+
		"\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0197\3\2\2\2\u0192\u0193"+
		"\7\b\2\2\u0193\u0195\5&\24\2\u0194\u0196\5(\25\2\u0195\u0194\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u0192\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u01ae\3\2\2\2\u0199\u01a9\7\4\2\2\u019a\u01a5\7%\2\2\u019b"+
		"\u01a5\7&\2\2\u019c\u01a5\7\'\2\2\u019d\u01a5\7(\2\2\u019e\u01a5\7)\2"+
		"\2\u019f\u01a5\7*\2\2\u01a0\u01a5\7+\2\2\u01a1\u01a5\7,\2\2\u01a2\u01a5"+
		"\7-\2\2\u01a3\u01a5\7.\2\2\u01a4\u019a\3\2\2\2\u01a4\u019b\3\2\2\2\u01a4"+
		"\u019c\3\2\2\2\u01a4\u019d\3\2\2\2\u01a4\u019e\3\2\2\2\u01a4\u019f\3\2"+
		"\2\2\u01a4\u01a0\3\2\2\2\u01a4\u01a1\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4"+
		"\u01a3\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a8\7\5\2\2\u01a7\u01a6\3\2"+
		"\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2\2\2\u01a9\u01a4\3\2\2\2\u01aa"+
		"\u01ab\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ad\3\2"+
		"\2\2\u01ad\u01af\7\6\2\2\u01ae\u0199\3\2\2\2\u01ae\u01af\3\2\2\2\u01af"+
		"\u01cb\3\2\2\2\u01b0\u01c6\7\4\2\2\u01b1\u01c5\5\62\32\2\u01b2\u01b4\7"+
		"/\2\2\u01b3\u01b5\5h\65\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6\u01b8\7\b\2\2\u01b7\u01b9\5P)\2\u01b8\u01b7\3\2\2"+
		"\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01c5\7\25\2\2\u01bb"+
		"\u01bd\7\60\2\2\u01bc\u01be\5h\65\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3"+
		"\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c1\7\b\2\2\u01c0\u01c2\5P)\2\u01c1"+
		"\u01c0\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\7\25"+
		"\2\2\u01c4\u01b1\3\2\2\2\u01c4\u01b2\3\2\2\2\u01c4\u01bb\3\2\2\2\u01c5"+
		"\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c9\3\2"+
		"\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01cc\7\6\2\2\u01ca\u01cc\7\25\2\2\u01cb"+
		"\u01b0\3\2\2\2\u01cb\u01ca\3\2\2\2\u01cc\37\3\2\2\2\u01cd\u01cf\5H%\2"+
		"\u01ce\u01cd\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0\u01d2"+
		"\7\34\2\2\u01d1\u01d0\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d5\3\2\2\2"+
		"\u01d3\u01d6\7\35\2\2\u01d4\u01d6\7\36\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d4"+
		"\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d9\7\37\2\2"+
		"\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01dc"+
		"\7 \2\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd"+
		"\u01e0\7!\2\2\u01de\u01e0\7\"\2\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2"+
		"\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2\3\2\2\2\u01e1\u01e3\7#\2\2\u01e2"+
		"\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\7\61"+
		"\2\2\u01e5\u01e8\5h\65\2\u01e6\u01e7\7\62\2\2\u01e7\u01e9\5h\65\2\u01e8"+
		"\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ef\3\2\2\2\u01ea\u01eb\7\b"+
		"\2\2\u01eb\u01ed\5&\24\2\u01ec\u01ee\5(\25\2\u01ed\u01ec\3\2\2\2\u01ed"+
		"\u01ee\3\2\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01ea\3\2\2\2\u01ef\u01f0\3\2"+
		"\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01f2\7\27\2\2\u01f2\u01f4\7\u008c\2\2"+
		"\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u020c\3\2\2\2\u01f5\u0207"+
		"\7\4\2\2\u01f6\u0203\7\63\2\2\u01f7\u0203\7\64\2\2\u01f8\u0203\7%\2\2"+
		"\u01f9\u0203\7&\2\2\u01fa\u0203\7)\2\2\u01fb\u0203\7*\2\2\u01fc\u0203"+
		"\7+\2\2\u01fd\u0203\7,\2\2\u01fe\u0203\7\65\2\2\u01ff\u0203\7\66\2\2\u0200"+
		"\u0203\7-\2\2\u0201\u0203\7.\2\2\u0202\u01f6\3\2\2\2\u0202\u01f7\3\2\2"+
		"\2\u0202\u01f8\3\2\2\2\u0202\u01f9\3\2\2\2\u0202\u01fa\3\2\2\2\u0202\u01fb"+
		"\3\2\2\2\u0202\u01fc\3\2\2\2\u0202\u01fd\3\2\2\2\u0202\u01fe\3\2\2\2\u0202"+
		"\u01ff\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0201\3\2\2\2\u0203\u0205\3\2"+
		"\2\2\u0204\u0206\7\5\2\2\u0205\u0204\3\2\2\2\u0205\u0206\3\2\2\2\u0206"+
		"\u0208\3\2\2\2\u0207\u0202\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u0207\3\2"+
		"\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\7\6\2\2\u020c"+
		"\u01f5\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u0234\3\2\2\2\u020e\u022f\7\4"+
		"\2\2\u020f\u022e\5\62\32\2\u0210\u0211\7\67\2\2\u0211\u0216\5f\64\2\u0212"+
		"\u0213\7\5\2\2\u0213\u0215\5f\64\2\u0214\u0212\3\2\2\2\u0215\u0218\3\2"+
		"\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0219\3\2\2\2\u0218"+
		"\u0216\3\2\2\2\u0219\u021a\7\25\2\2\u021a\u022e\3\2\2\2\u021b\u021d\7"+
		"/\2\2\u021c\u021e\5h\65\2\u021d\u021c\3\2\2\2\u021d\u021e\3\2\2\2\u021e"+
		"\u021f\3\2\2\2\u021f\u0221\7\b\2\2\u0220\u0222\5P)\2\u0221\u0220\3\2\2"+
		"\2\u0221\u0222\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u022e\7\25\2\2\u0224"+
		"\u0226\7\60\2\2\u0225\u0227\5h\65\2\u0226\u0225\3\2\2\2\u0226\u0227\3"+
		"\2\2\2\u0227\u0228\3\2\2\2\u0228\u022a\7\b\2\2\u0229\u022b\5P)\2\u022a"+
		"\u0229\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022e\7\25"+
		"\2\2\u022d\u020f\3\2\2\2\u022d\u0210\3\2\2\2\u022d\u021b\3\2\2\2\u022d"+
		"\u0224\3\2\2\2\u022e\u0231\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230\3\2"+
		"\2\2\u0230\u0232\3\2\2\2\u0231\u022f\3\2\2\2\u0232\u0235\7\6\2\2\u0233"+
		"\u0235\7\25\2\2\u0234\u020e\3\2\2\2\u0234\u0233\3\2\2\2\u0235!\3\2\2\2"+
		"\u0236\u0238\5H%\2\u0237\u0236\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u023a"+
		"\3\2\2\2\u0239\u023b\7\34\2\2\u023a\u0239\3\2\2\2\u023a\u023b\3\2\2\2"+
		"\u023b\u023c\3\2\2\2\u023c\u023d\78\2\2\u023d\u023e\5h\65\2\u023e\u0247"+
		"\7\21\2\2\u023f\u0244\5$\23\2\u0240\u0241\7\5\2\2\u0241\u0243\5$\23\2"+
		"\u0242\u0240\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244\u0245"+
		"\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u023f\3\2\2\2\u0247"+
		"\u0248\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024f\7\22\2\2\u024a\u024b\7"+
		"\b\2\2\u024b\u024d\5&\24\2\u024c\u024e\5(\25\2\u024d\u024c\3\2\2\2\u024d"+
		"\u024e\3\2\2\2\u024e\u0250\3\2\2\2\u024f\u024a\3\2\2\2\u024f\u0250\3\2"+
		"\2\2\u0250\u025a\3\2\2\2\u0251\u0252\79\2\2\u0252\u0257\5h\65\2\u0253"+
		"\u0254\7\5\2\2\u0254\u0256\5h\65\2\u0255\u0253\3\2\2\2\u0256\u0259\3\2"+
		"\2\2\u0257\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u025b\3\2\2\2\u0259"+
		"\u0257\3\2\2\2\u025a\u0251\3\2\2\2\u025a\u025b\3\2\2\2\u025b\u026d\3\2"+
		"\2\2\u025c\u0268\7\4\2\2\u025d\u0264\7%\2\2\u025e\u0264\7&\2\2\u025f\u0264"+
		"\7)\2\2\u0260\u0264\7*\2\2\u0261\u0264\7+\2\2\u0262\u0264\7,\2\2\u0263"+
		"\u025d\3\2\2\2\u0263\u025e\3\2\2\2\u0263\u025f\3\2\2\2\u0263\u0260\3\2"+
		"\2\2\u0263\u0261\3\2\2\2\u0263\u0262\3\2\2\2\u0264\u0266\3\2\2\2\u0265"+
		"\u0267\7\5\2\2\u0266\u0265\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2"+
		"\2\2\u0268\u0263\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u0268\3\2\2\2\u026a"+
		"\u026b\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026e\7\6\2\2\u026d\u025c\3\2"+
		"\2\2\u026d\u026e\3\2\2\2\u026e\u027b\3\2\2\2\u026f\u0276\7\4\2\2\u0270"+
		"\u0275\5\62\32\2\u0271\u0275\5D#\2\u0272\u0275\5@!\2\u0273\u0275\5F$\2"+
		"\u0274\u0270\3\2\2\2\u0274\u0271\3\2\2\2\u0274\u0272\3\2\2\2\u0274\u0273"+
		"\3\2\2\2\u0275\u0278\3\2\2\2\u0276\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277"+
		"\u0279\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u027c\7\6\2\2\u027a\u027c\7\25"+
		"\2\2\u027b\u026f\3\2\2\2\u027b\u027a\3\2\2\2\u027c#\3\2\2\2\u027d\u0280"+
		"\7!\2\2\u027e\u0280\7\"\2\2\u027f\u027d\3\2\2\2\u027f\u027e\3\2\2\2\u027f"+
		"\u0280\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0287\5h\65\2\u0282\u0283\7\b"+
		"\2\2\u0283\u0285\5&\24\2\u0284\u0286\5(\25\2\u0285\u0284\3\2\2\2\u0285"+
		"\u0286\3\2\2\2\u0286\u0288\3\2\2\2\u0287\u0282\3\2\2\2\u0287\u0288\3\2"+
		"\2\2\u0288\u0298\3\2\2\2\u0289\u0293\7\4\2\2\u028a\u028f\7)\2\2\u028b"+
		"\u028f\7*\2\2\u028c\u028f\7+\2\2\u028d\u028f\7,\2\2\u028e\u028a\3\2\2"+
		"\2\u028e\u028b\3\2\2\2\u028e\u028c\3\2\2\2\u028e\u028d\3\2\2\2\u028f\u0291"+
		"\3\2\2\2\u0290\u0292\7\5\2\2\u0291\u0290\3\2\2\2\u0291\u0292\3\2\2\2\u0292"+
		"\u0294\3\2\2\2\u0293\u028e\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0293\3\2"+
		"\2\2\u0295\u0296\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0299\7\6\2\2\u0298"+
		"\u0289\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u02a2\3\2\2\2\u029a\u029e\7\4"+
		"\2\2\u029b\u029d\5\62\32\2\u029c\u029b\3\2\2\2\u029d\u02a0\3\2\2\2\u029e"+
		"\u029c\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a1\3\2\2\2\u02a0\u029e\3\2"+
		"\2\2\u02a1\u02a3\7\6\2\2\u02a2\u029a\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3"+
		"%\3\2\2\2\u02a4\u02a7\5,\27\2\u02a5\u02a7\5f\64\2\u02a6\u02a4\3\2\2\2"+
		"\u02a6\u02a5\3\2\2\2\u02a7\'\3\2\2\2\u02a8\u02af\7\r\2\2\u02a9\u02ac\5"+
		"l\67\2\u02aa\u02ab\7\20\2\2\u02ab\u02ad\5j\66\2\u02ac\u02aa\3\2\2\2\u02ac"+
		"\u02ad\3\2\2\2\u02ad\u02b0\3\2\2\2\u02ae\u02b0\t\2\2\2\u02af\u02a9\3\2"+
		"\2\2\u02af\u02ae\3\2\2\2\u02b0\u02b3\3\2\2\2\u02b1\u02b4\7=\2\2\u02b2"+
		"\u02b4\7>\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b2\3\2\2\2\u02b3\u02b4\3\2"+
		"\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b6\7\16\2\2\u02b6)\3\2\2\2\u02b7\u02b9"+
		"\7?\2\2\u02b8\u02b7\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02bc\3\2\2\2\u02ba"+
		"\u02bd\7!\2\2\u02bb\u02bd\7\"\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bb\3\2"+
		"\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02bf\7@\2\2\u02bf"+
		"\u02c1\5h\65\2\u02c0\u02c2\5> \2\u02c1\u02c0\3\2\2\2\u02c1\u02c2\3\2\2"+
		"\2\u02c2\u02c5\3\2\2\2\u02c3\u02c4\7\b\2\2\u02c4\u02c6\7\u008c\2\2\u02c5"+
		"\u02c3\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02cd\3\2\2\2\u02c7\u02ca\7\4"+
		"\2\2\u02c8\u02cb\7A\2\2\u02c9\u02cb\7B\2\2\u02ca\u02c8\3\2\2\2\u02ca\u02c9"+
		"\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02ce\7\6\2\2\u02cd"+
		"\u02c7\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02db\3\2\2\2\u02cf\u02d0\7\4"+
		"\2\2\u02d0\u02d9\5\62\32\2\u02d1\u02d3\5B\"\2\u02d2\u02d1\3\2\2\2\u02d3"+
		"\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d7\3\2"+
		"\2\2\u02d6\u02d4\3\2\2\2\u02d7\u02d9\7\6\2\2\u02d8\u02cf\3\2\2\2\u02d8"+
		"\u02d4\3\2\2\2\u02d9\u02dc\3\2\2\2\u02da\u02dc\7\25\2\2\u02db\u02d8\3"+
		"\2\2\2\u02db\u02da\3\2\2\2\u02dc+\3\2\2\2\u02dd\u02de\t\3\2\2\u02de-\3"+
		"\2\2\2\u02df\u02e1\5H%\2\u02e0\u02df\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1"+
		"\u02e2\3\2\2\2\u02e2\u02e3\7H\2\2\u02e3\u02e5\5h\65\2\u02e4\u02e6\5> "+
		"\2\u02e5\u02e4\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02e8"+
		"\7\b\2\2\u02e8\u02ea\7\u008c\2\2\u02e9\u02e7\3\2\2\2\u02e9\u02ea\3\2\2"+
		"\2\u02ea\u02f1\3\2\2\2\u02eb\u02ee\7\4\2\2\u02ec\u02ef\7A\2\2\u02ed\u02ef"+
		"\7B\2\2\u02ee\u02ec\3\2\2\2\u02ee\u02ed\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef"+
		"\u02f0\3\2\2\2\u02f0\u02f2\7\6\2\2\u02f1\u02eb\3\2\2\2\u02f1\u02f2\3\2"+
		"\2\2\u02f2\u02fe\3\2\2\2\u02f3\u02f9\7\4\2\2\u02f4\u02f8\5\62\32\2\u02f5"+
		"\u02f8\5\60\31\2\u02f6\u02f8\5B\"\2\u02f7\u02f4\3\2\2\2\u02f7\u02f5\3"+
		"\2\2\2\u02f7\u02f6\3\2\2\2\u02f8\u02fb\3\2\2\2\u02f9\u02f7\3\2\2\2\u02f9"+
		"\u02fa\3\2\2\2\u02fa\u02fc\3\2\2\2\u02fb\u02f9\3\2\2\2\u02fc\u02ff\7\6"+
		"\2\2\u02fd\u02ff\7\25\2\2\u02fe\u02f3\3\2\2\2\u02fe\u02fd\3\2\2\2\u02ff"+
		"/\3\2\2\2\u0300\u0301\7I\2\2\u0301\u0304\5h\65\2\u0302\u0304\5h\65\2\u0303"+
		"\u0300\3\2\2\2\u0303\u0302\3\2\2\2\u0304\u0307\3\2\2\2\u0305\u0306\7\27"+
		"\2\2\u0306\u0308\5n8\2\u0307\u0305\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0312"+
		"\3\2\2\2\u0309\u030d\7\4\2\2\u030a\u030c\5\62\32\2\u030b\u030a\3\2\2\2"+
		"\u030c\u030f\3\2\2\2\u030d\u030b\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u0310"+
		"\3\2\2\2\u030f\u030d\3\2\2\2\u0310\u0313\7\6\2\2\u0311\u0313\7\25\2\2"+
		"\u0312\u0309\3\2\2\2\u0312\u0311\3\2\2\2\u0313\61\3\2\2\2\u0314\u0316"+
		"\7J\2\2\u0315\u0317\7\u008c\2\2\u0316\u0315\3\2\2\2\u0316\u0317\3\2\2"+
		"\2\u0317\u0323\3\2\2\2\u0318\u0319\7\21\2\2\u0319\u031e\5\64\33\2\u031a"+
		"\u031b\7\5\2\2\u031b\u031d\5\64\33\2\u031c\u031a\3\2\2\2\u031d\u0320\3"+
		"\2\2\2\u031e\u031c\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0321\3\2\2\2\u0320"+
		"\u031e\3\2\2\2\u0321\u0322\7\22\2\2\u0322\u0324\3\2\2\2\u0323\u0318\3"+
		"\2\2\2\u0323\u0324\3\2\2\2\u0324\u0330\3\2\2\2\u0325\u0329\7\4\2\2\u0326"+
		"\u032a\5\62\32\2\u0327\u032a\5\66\34\2\u0328\u032a\5<\37\2\u0329\u0326"+
		"\3\2\2\2\u0329\u0327\3\2\2\2\u0329\u0328\3\2\2\2\u032a\u032b\3\2\2\2\u032b"+
		"\u0329\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u032e\7\6"+
		"\2\2\u032e\u0331\3\2\2\2\u032f\u0331\7\25\2\2\u0330\u0325\3\2\2\2\u0330"+
		"\u032f\3\2\2\2\u0331\63\3\2\2\2\u0332\u0333\7\u008c\2\2\u0333\u0334\7"+
		"\27\2\2\u0334\u0335\t\4\2\2\u0335\65\3\2\2\2\u0336\u0339\5\62\32\2\u0337"+
		"\u0339\58\35\2\u0338\u0336\3\2\2\2\u0338\u0337\3\2\2\2\u0339\67\3\2\2"+
		"\2\u033a\u033f\5:\36\2\u033b\u033f\5\30\r\2\u033c\u033f\5\26\f\2\u033d"+
		"\u033f\5\60\31\2\u033e\u033a\3\2\2\2\u033e\u033b\3\2\2\2\u033e\u033c\3"+
		"\2\2\2\u033e\u033d\3\2\2\2\u033f9\3\2\2\2\u0340\u0344\5\"\22\2\u0341\u0344"+
		"\5$\23\2\u0342\u0344\5\34\17\2\u0343\u0340\3\2\2\2\u0343\u0341\3\2\2\2"+
		"\u0343\u0342\3\2\2\2\u0344;\3\2\2\2\u0345\u0346\7K\2\2\u0346\u0347\5f"+
		"\64\2\u0347\u0348\7\25\2\2\u0348=\3\2\2\2\u0349\u034a\7\21\2\2\u034a\u034f"+
		"\5h\65\2\u034b\u034c\7\5\2\2\u034c\u034e\5h\65\2\u034d\u034b\3\2\2\2\u034e"+
		"\u0351\3\2\2\2\u034f\u034d\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u0352\3\2"+
		"\2\2\u0351\u034f\3\2\2\2\u0352\u0353\7\22\2\2\u0353\u0360\3\2\2\2\u0354"+
		"\u0355\7L\2\2\u0355\u035a\5h\65\2\u0356\u0357\7\5\2\2\u0357\u0359\5h\65"+
		"\2\u0358\u0356\3\2\2\2\u0359\u035c\3\2\2\2\u035a\u0358\3\2\2\2\u035a\u035b"+
		"\3\2\2\2\u035b\u035d\3\2\2\2\u035c\u035a\3\2\2\2\u035d\u035e\7M\2\2\u035e"+
		"\u0360\3\2\2\2\u035f\u0349\3\2\2\2\u035f\u0354\3\2\2\2\u0360?\3\2\2\2"+
		"\u0361\u0363\7N\2\2\u0362\u0364\5h\65\2\u0363\u0362\3\2\2\2\u0363\u0364"+
		"\3\2\2\2\u0364\u036b\3\2\2\2\u0365\u0367\7\b\2\2\u0366\u0368\5P)\2\u0367"+
		"\u0366\3\2\2\2\u0367\u0368\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036c\7\25"+
		"\2\2\u036a\u036c\7\25\2\2\u036b\u0365\3\2\2\2\u036b\u036a\3\2\2\2\u036c"+
		"A\3\2\2\2\u036d\u036f\7O\2\2\u036e\u036d\3\2\2\2\u036e\u036f\3\2\2\2\u036f"+
		"\u0370\3\2\2\2\u0370\u0377\7P\2\2\u0371\u0375\5h\65\2\u0372\u0373\7\21"+
		"\2\2\u0373\u0374\7\u008b\2\2\u0374\u0376\7\22\2\2\u0375\u0372\3\2\2\2"+
		"\u0375\u0376\3\2\2\2\u0376\u0378\3\2\2\2\u0377\u0371\3\2\2\2\u0377\u0378"+
		"\3\2\2\2\u0378\u037f\3\2\2\2\u0379\u037b\7\b\2\2\u037a\u037c\5N(\2\u037b"+
		"\u037a\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u0380\7\25"+
		"\2\2\u037e\u0380\7\25\2\2\u037f\u0379\3\2\2\2\u037f\u037e\3\2\2\2\u0380"+
		"C\3\2\2\2\u0381\u0388\t\5\2\2\u0382\u0386\5h\65\2\u0383\u0384\7\21\2\2"+
		"\u0384\u0385\7\u008b\2\2\u0385\u0387\7\22\2\2\u0386\u0383\3\2\2\2\u0386"+
		"\u0387\3\2\2\2\u0387\u0389\3\2\2\2\u0388\u0382\3\2\2\2\u0388\u0389\3\2"+
		"\2\2\u0389\u0390\3\2\2\2\u038a\u038c\7\b\2\2\u038b\u038d\5N(\2\u038c\u038b"+
		"\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u038e\3\2\2\2\u038e\u0391\7\25\2\2"+
		"\u038f\u0391\7\25\2\2\u0390\u038a\3\2\2\2\u0390\u038f\3\2\2\2\u0391E\3"+
		"\2\2\2\u0392\u0399\t\6\2\2\u0393\u0397\5h\65\2\u0394\u0395\7\21\2\2\u0395"+
		"\u0396\7\u008b\2\2\u0396\u0398\7\22\2\2\u0397\u0394\3\2\2\2\u0397\u0398"+
		"\3\2\2\2\u0398\u039a\3\2\2\2\u0399\u0393\3\2\2\2\u0399\u039a\3\2\2\2\u039a"+
		"\u03a1\3\2\2\2\u039b\u039d\7\b\2\2\u039c\u039e\5N(\2\u039d\u039c\3\2\2"+
		"\2\u039d\u039e\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u03a2\7\25\2\2\u03a0"+
		"\u03a2\7\25\2\2\u03a1\u039b\3\2\2\2\u03a1\u03a0\3\2\2\2\u03a2G\3\2\2\2"+
		"\u03a3\u03a4\t\7\2\2\u03a4I\3\2\2\2\u03a5\u03a6\7\u008a\2\2\u03a6\u03a9"+
		"\b&\1\2\u03a7\u03a9\7\u0089\2\2\u03a8\u03a5\3\2\2\2\u03a8\u03a7\3\2\2"+
		"\2\u03a9K\3\2\2\2\u03aa\u03ab\7\u0089\2\2\u03abM\3\2\2\2\u03ac\u03ad\b"+
		"(\1\2\u03ad\u03ae\7X\2\2\u03ae\u04b3\5P)\2\u03af\u03b0\7Y\2\2\u03b0\u04b3"+
		"\5P)\2\u03b1\u03b2\7Z\2\2\u03b2\u04b3\5P)\2\u03b3\u03b4\7[\2\2\u03b4\u04b3"+
		"\5P)\2\u03b5\u03b7\5P)\2\u03b6\u03b8\t\b\2\2\u03b7\u03b6\3\2\2\2\u03b7"+
		"\u03b8\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03ba\7^\2\2\u03ba\u03bb\5P)"+
		"\2\u03bb\u04b3\3\2\2\2\u03bc\u03be\5P)\2\u03bd\u03bf\t\b\2\2\u03be\u03bd"+
		"\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c1\7\27\2\2"+
		"\u03c1\u03c2\5P)\2\u03c2\u04b3\3\2\2\2\u03c3\u03c5\5R*\2\u03c4\u03c6\t"+
		"\b\2\2\u03c5\u03c4\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7"+
		"\u03c8\7\27\2\2\u03c8\u03c9\5R*\2\u03c9\u04b3\3\2\2\2\u03ca\u03cc\5R*"+
		"\2\u03cb\u03cd\t\b\2\2\u03cc\u03cb\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03ce"+
		"\3\2\2\2\u03ce\u03cf\7L\2\2\u03cf\u03d0\5R*\2\u03d0\u04b3\3\2\2\2\u03d1"+
		"\u03d3\5R*\2\u03d2\u03d4\t\b\2\2\u03d3\u03d2\3\2\2\2\u03d3\u03d4\3\2\2"+
		"\2\u03d4\u03d5\3\2\2\2\u03d5\u03d6\7_\2\2\u03d6\u03d7\5R*\2\u03d7\u04b3"+
		"\3\2\2\2\u03d8\u03da\5R*\2\u03d9\u03db\t\b\2\2\u03da\u03d9\3\2\2\2\u03da"+
		"\u03db\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc\u03dd\7M\2\2\u03dd\u03de\5R*"+
		"\2\u03de\u04b3\3\2\2\2\u03df\u03e1\5R*\2\u03e0\u03e2\t\b\2\2\u03e1\u03e0"+
		"\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3\u03e4\7`\2\2\u03e4"+
		"\u03e5\5R*\2\u03e5\u04b3\3\2\2\2\u03e6\u03e7\b(\1\2\u03e7\u03e8\7a\2\2"+
		"\u03e8\u03e9\5T+\2\u03e9\u03ea\7b\2\2\u03ea\u03eb\5R*\2\u03eb\u03ec\3"+
		"\2\2\2\u03ec\u03ed\b(\1\2\u03ed\u04b3\3\2\2\2\u03ee\u03ef\7c\2\2\u03ef"+
		"\u03f0\7\r\2\2\u03f0\u03f1\5`\61\2\u03f1\u03f2\7\16\2\2\u03f2\u04b3\3"+
		"\2\2\2\u03f3\u03f4\7d\2\2\u03f4\u03f5\7\r\2\2\u03f5\u03f6\5`\61\2\u03f6"+
		"\u03f7\7\b\2\2\u03f7\u03f8\5P)\2\u03f8\u03f9\7e\2\2\u03f9\u03fa\t\t\2"+
		"\2\u03fa\u03fb\5P)\2\u03fb\u03fc\7\16\2\2\u03fc\u04b3\3\2\2\2\u03fd\u03fe"+
		"\7f\2\2\u03fe\u03ff\7\r\2\2\u03ff\u0400\5`\61\2\u0400\u0401\7\5\2\2\u0401"+
		"\u0402\5`\61\2\u0402\u0403\7\5\2\2\u0403\u0404\5`\61\2\u0404\u0405\7\5"+
		"\2\2\u0405\u0406\5`\61\2\u0406\u0407\7\16\2\2\u0407\u04b3\3\2\2\2\u0408"+
		"\u0409\t\b\2\2\u0409\u04b3\5N(\20\u040a\u040b\b(\1\2\u040b\u040c\7o\2"+
		"\2\u040c\u0421\5T+\2\u040d\u0417\7b\2\2\u040e\u0418\5N(\2\u040f\u0413"+
		"\7\4\2\2\u0410\u0412\5N(\2\u0411\u0410\3\2\2\2\u0412\u0415\3\2\2\2\u0413"+
		"\u0411\3\2\2\2\u0413\u0414\3\2\2\2\u0414\u0416\3\2\2\2\u0415\u0413\3\2"+
		"\2\2\u0416\u0418\7\6\2\2\u0417\u040e\3\2\2\2\u0417\u040f\3\2\2\2\u0418"+
		"\u0422\3\2\2\2\u0419\u041d\7\4\2\2\u041a\u041c\5N(\2\u041b\u041a\3\2\2"+
		"\2\u041c\u041f\3\2\2\2\u041d\u041b\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u0420"+
		"\3\2\2\2\u041f\u041d\3\2\2\2\u0420\u0422\7\6\2\2\u0421\u040d\3\2\2\2\u0421"+
		"\u0419\3\2\2\2\u0422\u0423\3\2\2\2\u0423\u0424\b(\1\2\u0424\u04b3\3\2"+
		"\2\2\u0425\u0426\b(\1\2\u0426\u0427\7[\2\2\u0427\u043c\5T+\2\u0428\u0432"+
		"\7b\2\2\u0429\u0433\5N(\2\u042a\u042e\7\4\2\2\u042b\u042d\5N(\2\u042c"+
		"\u042b\3\2\2\2\u042d\u0430\3\2\2\2\u042e\u042c\3\2\2\2\u042e\u042f\3\2"+
		"\2\2\u042f\u0431\3\2\2\2\u0430\u042e\3\2\2\2\u0431\u0433\7\6\2\2\u0432"+
		"\u0429\3\2\2\2\u0432\u042a\3\2\2\2\u0433\u043d\3\2\2\2\u0434\u0438\7\4"+
		"\2\2\u0435\u0437\5N(\2\u0436\u0435\3\2\2\2\u0437\u043a\3\2\2\2\u0438\u0436"+
		"\3\2\2\2\u0438\u0439\3\2\2\2\u0439\u043b\3\2\2\2\u043a\u0438\3\2\2\2\u043b"+
		"\u043d\7\6\2\2\u043c\u0428\3\2\2\2\u043c\u0434\3\2\2\2\u043d\u043e\3\2"+
		"\2\2\u043e\u043f\b(\1\2\u043f\u04b3\3\2\2\2\u0440\u0441\b(\1\2\u0441\u0442"+
		"\7X\2\2\u0442\u0457\5T+\2\u0443\u044d\7b\2\2\u0444\u044e\5N(\2\u0445\u0449"+
		"\7\4\2\2\u0446\u0448\5N(\2\u0447\u0446\3\2\2\2\u0448\u044b\3\2\2\2\u0449"+
		"\u0447\3\2\2\2\u0449\u044a\3\2\2\2\u044a\u044c\3\2\2\2\u044b\u0449\3\2"+
		"\2\2\u044c\u044e\7\6\2\2\u044d\u0444\3\2\2\2\u044d\u0445\3\2\2\2\u044e"+
		"\u0458\3\2\2\2\u044f\u0453\7\4\2\2\u0450\u0452\5N(\2\u0451\u0450\3\2\2"+
		"\2\u0452\u0455\3\2\2\2\u0453\u0451\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0456"+
		"\3\2\2\2\u0455\u0453\3\2\2\2\u0456\u0458\7\6\2\2\u0457\u0443\3\2\2\2\u0457"+
		"\u044f\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u045a\b(\1\2\u045a\u04b3\3\2"+
		"\2\2\u045b\u045c\b(\1\2\u045c\u045d\7Z\2\2\u045d\u0472\5T+\2\u045e\u0468"+
		"\7b\2\2\u045f\u0469\5N(\2\u0460\u0464\7\4\2\2\u0461\u0463\5N(\2\u0462"+
		"\u0461\3\2\2\2\u0463\u0466\3\2\2\2\u0464\u0462\3\2\2\2\u0464\u0465\3\2"+
		"\2\2\u0465\u0467\3\2\2\2\u0466\u0464\3\2\2\2\u0467\u0469\7\6\2\2\u0468"+
		"\u045f\3\2\2\2\u0468\u0460\3\2\2\2\u0469\u0473\3\2\2\2\u046a\u046e\7\4"+
		"\2\2\u046b\u046d\5N(\2\u046c\u046b\3\2\2\2\u046d\u0470\3\2\2\2\u046e\u046c"+
		"\3\2\2\2\u046e\u046f\3\2\2\2\u046f\u0471\3\2\2\2\u0470\u046e\3\2\2\2\u0471"+
		"\u0473\7\6\2\2\u0472\u045e\3\2\2\2\u0472\u046a\3\2\2\2\u0473\u0474\3\2"+
		"\2\2\u0474\u0475\b(\1\2\u0475\u04b3\3\2\2\2\u0476\u0477\b(\1\2\u0477\u0478"+
		"\7Y\2\2\u0478\u048d\5T+\2\u0479\u0483\7b\2\2\u047a\u0484\5N(\2\u047b\u047f"+
		"\7\4\2\2\u047c\u047e\5N(\2\u047d\u047c\3\2\2\2\u047e\u0481\3\2\2\2\u047f"+
		"\u047d\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0482\3\2\2\2\u0481\u047f\3\2"+
		"\2\2\u0482\u0484\7\6\2\2\u0483\u047a\3\2\2\2\u0483\u047b\3\2\2\2\u0484"+
		"\u048e\3\2\2\2\u0485\u0489\7\4\2\2\u0486\u0488\5N(\2\u0487\u0486\3\2\2"+
		"\2\u0488\u048b\3\2\2\2\u0489\u0487\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u048c"+
		"\3\2\2\2\u048b\u0489\3\2\2\2\u048c\u048e\7\6\2\2\u048d\u0479\3\2\2\2\u048d"+
		"\u0485\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0490\b(\1\2\u0490\u04b3\3\2"+
		"\2\2\u0491\u0492\b(\1\2\u0492\u0493\7p\2\2\u0493\u04a8\5X-\2\u0494\u049e"+
		"\7b\2\2\u0495\u049f\5N(\2\u0496\u049a\7\4\2\2\u0497\u0499\5N(\2\u0498"+
		"\u0497\3\2\2\2\u0499\u049c\3\2\2\2\u049a\u0498\3\2\2\2\u049a\u049b\3\2"+
		"\2\2\u049b\u049d\3\2\2\2\u049c\u049a\3\2\2\2\u049d\u049f\7\6\2\2\u049e"+
		"\u0495\3\2\2\2\u049e\u0496\3\2\2\2\u049f\u04a9\3\2\2\2\u04a0\u04a4\7\4"+
		"\2\2\u04a1\u04a3\5N(\2\u04a2\u04a1\3\2\2\2\u04a3\u04a6\3\2\2\2\u04a4\u04a2"+
		"\3\2\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04a7\3\2\2\2\u04a6\u04a4\3\2\2\2\u04a7"+
		"\u04a9\7\6\2\2\u04a8\u0494\3\2\2\2\u04a8\u04a0\3\2\2\2\u04a9\u04aa\3\2"+
		"\2\2\u04aa\u04ab\b(\1\2\u04ab\u04b3\3\2\2\2\u04ac\u04b3\7q\2\2\u04ad\u04b3"+
		"\7r\2\2\u04ae\u04af\7\21\2\2\u04af\u04b0\5N(\2\u04b0\u04b1\7\22\2\2\u04b1"+
		"\u04b3\3\2\2\2\u04b2\u03ac\3\2\2\2\u04b2\u03af\3\2\2\2\u04b2\u03b1\3\2"+
		"\2\2\u04b2\u03b3\3\2\2\2\u04b2\u03b5\3\2\2\2\u04b2\u03bc\3\2\2\2\u04b2"+
		"\u03c3\3\2\2\2\u04b2\u03ca\3\2\2\2\u04b2\u03d1\3\2\2\2\u04b2\u03d8\3\2"+
		"\2\2\u04b2\u03df\3\2\2\2\u04b2\u03e6\3\2\2\2\u04b2\u03ee\3\2\2\2\u04b2"+
		"\u03f3\3\2\2\2\u04b2\u03fd\3\2\2\2\u04b2\u0408\3\2\2\2\u04b2\u040a\3\2"+
		"\2\2\u04b2\u0425\3\2\2\2\u04b2\u0440\3\2\2\2\u04b2\u045b\3\2\2\2\u04b2"+
		"\u0476\3\2\2\2\u04b2\u0491\3\2\2\2\u04b2\u04ac\3\2\2\2\u04b2\u04ad\3\2"+
		"\2\2\u04b2\u04ae\3\2\2\2\u04b3\u04c2\3\2\2\2\u04b4\u04b5\f\17\2\2\u04b5"+
		"\u04b6\t\n\2\2\u04b6\u04c1\5N(\17\u04b7\u04b8\f\16\2\2\u04b8\u04b9\t\13"+
		"\2\2\u04b9\u04c1\5N(\16\u04ba\u04bb\f\r\2\2\u04bb\u04bc\t\f\2\2\u04bc"+
		"\u04c1\5N(\r\u04bd\u04be\f\f\2\2\u04be\u04bf\t\r\2\2\u04bf\u04c1\5N(\f"+
		"\u04c0\u04b4\3\2\2\2\u04c0\u04b7\3\2\2\2\u04c0\u04ba\3\2\2\2\u04c0\u04bd"+
		"\3\2\2\2\u04c1\u04c4\3\2\2\2\u04c2\u04c0\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3"+
		"O\3\2\2\2\u04c4\u04c2\3\2\2\2\u04c5\u04c6\b)\1\2\u04c6\u04c7\7s\2\2\u04c7"+
		"\u04eb\5P)\25\u04c8\u04c9\7t\2\2\u04c9\u04eb\5P)\24\u04ca\u04cb\7:\2\2"+
		"\u04cb\u04eb\5P)\23\u04cc\u04cd\b)\1\2\u04cd\u04ce\7\4\2\2\u04ce\u04cf"+
		"\5\\/\2\u04cf\u04d0\7b\2\2\u04d0\u04d1\5N(\2\u04d1\u04d2\7\6\2\2\u04d2"+
		"\u04d3\3\2\2\2\u04d3\u04d4\b)\1\2\u04d4\u04eb\3\2\2\2\u04d5\u04d6\t\f"+
		"\2\2\u04d6\u04d7\5N(\2\u04d7\u04d8\7z\2\2\u04d8\u04d9\5P)\2\u04d9\u04da"+
		"\7{\2\2\u04da\u04db\5P)\n\u04db\u04eb\3\2\2\2\u04dc\u04eb\7|\2\2\u04dd"+
		"\u04eb\7}\2\2\u04de\u04eb\7~\2\2\u04df\u04eb\7\177\2\2\u04e0\u04e1\7\21"+
		"\2\2\u04e1\u04e2\5P)\2\u04e2\u04e3\7\22\2\2\u04e3\u04eb\3\2\2\2\u04e4"+
		"\u04e5\6)\6\2\u04e5\u04eb\5`\61\2\u04e6\u04e7\6)\7\2\u04e7\u04e8\5b\62"+
		"\2\u04e8\u04e9\b)\1\2\u04e9\u04eb\3\2\2\2\u04ea\u04c5\3\2\2\2\u04ea\u04c8"+
		"\3\2\2\2\u04ea\u04ca\3\2\2\2\u04ea\u04cc\3\2\2\2\u04ea\u04d5\3\2\2\2\u04ea"+
		"\u04dc\3\2\2\2\u04ea\u04dd\3\2\2\2\u04ea\u04de\3\2\2\2\u04ea\u04df\3\2"+
		"\2\2\u04ea\u04e0\3\2\2\2\u04ea\u04e4\3\2\2\2\u04ea\u04e6\3\2\2\2\u04eb"+
		"\u050b\3\2\2\2\u04ec\u04ed\f\22\2\2\u04ed\u04ee\7;\2\2\u04ee\u050a\5P"+
		")\23\u04ef\u04f0\f\21\2\2\u04f0\u04f1\7u\2\2\u04f1\u050a\5P)\22\u04f2"+
		"\u04f3\f\20\2\2\u04f3\u04f4\7v\2\2\u04f4\u050a\5P)\21\u04f5\u04f6\f\17"+
		"\2\2\u04f6\u04f7\7w\2\2\u04f7\u050a\5P)\20\u04f8\u04fa\f\r\2\2\u04f9\u04fb"+
		"\t\16\2\2\u04fa\u04f9\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb\u04fc\3\2\2\2"+
		"\u04fc\u04fe\7e\2\2\u04fd\u04ff\t\16\2\2\u04fe\u04fd\3\2\2\2\u04fe\u04ff"+
		"\3\2\2\2\u04ff\u0500\3\2\2\2\u0500\u050a\5P)\r\u0501\u0502\f\f\2\2\u0502"+
		"\u0503\7y\2\2\u0503\u050a\5P)\r\u0504\u0505\f\16\2\2\u0505\u0506\7\r\2"+
		"\2\u0506\u0507\5P)\2\u0507\u0508\7\16\2\2\u0508\u050a\3\2\2\2\u0509\u04ec"+
		"\3\2\2\2\u0509\u04ef\3\2\2\2\u0509\u04f2\3\2\2\2\u0509\u04f5\3\2\2\2\u0509"+
		"\u04f8\3\2\2\2\u0509\u0501\3\2\2\2\u0509\u0504\3\2\2\2\u050a\u050d\3\2"+
		"\2\2\u050b\u0509\3\2\2\2\u050b\u050c\3\2\2\2\u050cQ\3\2\2\2\u050d\u050b"+
		"\3\2\2\2\u050e\u050f\b*\1\2\u050f\u0510\t\f\2\2\u0510\u0511\5N(\2\u0511"+
		"\u0512\7z\2\2\u0512\u0513\5R*\2\u0513\u0514\7{\2\2\u0514\u0515\5R*\f\u0515"+
		"\u0523\3\2\2\2\u0516\u0517\7a\2\2\u0517\u0523\5P)\2\u0518\u0519\7\62\2"+
		"\2\u0519\u0523\5P)\2\u051a\u051c\7v\2\2\u051b\u051a\3\2\2\2\u051b\u051c"+
		"\3\2\2\2\u051c\u051d\3\2\2\2\u051d\u0523\5d\63\2\u051e\u051f\7\21\2\2"+
		"\u051f\u0520\5R*\2\u0520\u0521\7\22\2\2\u0521\u0523\3\2\2\2\u0522\u050e"+
		"\3\2\2\2\u0522\u0516\3\2\2\2\u0522\u0518\3\2\2\2\u0522\u051b\3\2\2\2\u0522"+
		"\u051e\3\2\2\2\u0523\u0535\3\2\2\2\u0524\u0525\f\t\2\2\u0525\u0526\t\17"+
		"\2\2\u0526\u0534\5R*\n\u0527\u0528\f\b\2\2\u0528\u0529\t\20\2\2\u0529"+
		"\u0534\5R*\t\u052a\u052b\f\7\2\2\u052b\u052c\t\21\2\2\u052c\u0534\5R*"+
		"\b\u052d\u052e\f\6\2\2\u052e\u052f\t\22\2\2\u052f\u0534\5R*\7\u0530\u0531"+
		"\f\5\2\2\u0531\u0532\t\23\2\2\u0532\u0534\5R*\6\u0533\u0524\3\2\2\2\u0533"+
		"\u0527\3\2\2\2\u0533\u052a\3\2\2\2\u0533\u052d\3\2\2\2\u0533\u0530\3\2"+
		"\2\2\u0534\u0537\3\2\2\2\u0535\u0533\3\2\2\2\u0535\u0536\3\2\2\2\u0536"+
		"S\3\2\2\2\u0537\u0535\3\2\2\2\u0538\u053d\5V,\2\u0539\u053a\7\5\2\2\u053a"+
		"\u053c\5V,\2\u053b\u0539\3\2\2\2\u053c\u053f\3\2\2\2\u053d\u053b\3\2\2"+
		"\2\u053d\u053e\3\2\2\2\u053eU\3\2\2\2\u053f\u053d\3\2\2\2\u0540\u0542"+
		"\7\u0087\2\2\u0541\u0540\3\2\2\2\u0541\u0542\3\2\2\2\u0542\u0543\3\2\2"+
		"\2\u0543\u0548\5b\62\2\u0544\u0545\7\5\2\2\u0545\u0547\5b\62\2\u0546\u0544"+
		"\3\2\2\2\u0547\u054a\3\2\2\2\u0548\u0546\3\2\2\2\u0548\u0549\3\2\2\2\u0549"+
		"\u054b\3\2\2\2\u054a\u0548\3\2\2\2\u054b\u054d\7\b\2\2\u054c\u054e\7Z"+
		"\2\2\u054d\u054c\3\2\2\2\u054d\u054e\3\2\2\2\u054e\u054f\3\2\2\2\u054f"+
		"\u0550\5P)\2\u0550\u0551\b,\1\2\u0551\u0583\3\2\2\2\u0552\u0554\7\u0087"+
		"\2\2\u0553\u0552\3\2\2\2\u0553\u0554\3\2\2\2\u0554\u0555\3\2\2\2\u0555"+
		"\u055a\5b\62\2\u0556\u0557\7\5\2\2\u0557\u0559\5b\62\2\u0558\u0556\3\2"+
		"\2\2\u0559\u055c\3\2\2\2\u055a\u0558\3\2\2\2\u055a\u055b\3\2\2\2\u055b"+
		"\u055d\3\2\2\2\u055c\u055a\3\2\2\2\u055d\u055e\7\b\2\2\u055e\u055f\7Y"+
		"\2\2\u055f\u0560\5P)\2\u0560\u0561\b,\1\2\u0561\u0583\3\2\2\2\u0562\u0564"+
		"\7\u0087\2\2\u0563\u0562\3\2\2\2\u0563\u0564\3\2\2\2\u0564\u0565\3\2\2"+
		"\2\u0565\u056a\5b\62\2\u0566\u0567\7\5\2\2\u0567\u0569\5b\62\2\u0568\u0566"+
		"\3\2\2\2\u0569\u056c\3\2\2\2\u056a\u0568\3\2\2\2\u056a\u056b\3\2\2\2\u056b"+
		"\u056d\3\2\2\2\u056c\u056a\3\2\2\2\u056d\u056e\7\b\2\2\u056e\u056f\7["+
		"\2\2\u056f\u0570\5P)\2\u0570\u0571\b,\1\2\u0571\u0583\3\2\2\2\u0572\u0574"+
		"\7\u0087\2\2\u0573\u0572\3\2\2\2\u0573\u0574\3\2\2\2\u0574\u0575\3\2\2"+
		"\2\u0575\u057a\5b\62\2\u0576\u0577\7\5\2\2\u0577\u0579\5b\62\2\u0578\u0576"+
		"\3\2\2\2\u0579\u057c\3\2\2\2\u057a\u0578\3\2\2\2\u057a\u057b\3\2\2\2\u057b"+
		"\u057d\3\2\2\2\u057c\u057a\3\2\2\2\u057d\u057e\7\b\2\2\u057e\u057f\7x"+
		"\2\2\u057f\u0580\5P)\2\u0580\u0581\b,\1\2\u0581\u0583\3\2\2\2\u0582\u0541"+
		"\3\2\2\2\u0582\u0553\3\2\2\2\u0582\u0563\3\2\2\2\u0582\u0573\3\2\2\2\u0583"+
		"W\3\2\2\2\u0584\u0589\5Z.\2\u0585\u0586\7\5\2\2\u0586\u0588\5Z.\2\u0587"+
		"\u0585\3\2\2\2\u0588\u058b\3\2\2\2\u0589\u0587\3\2\2\2\u0589\u058a\3\2"+
		"\2\2\u058aY\3\2\2\2\u058b\u0589\3\2\2\2\u058c\u0591\5b\62\2\u058d\u058e"+
		"\7\5\2\2\u058e\u0590\5b\62\2\u058f\u058d\3\2\2\2\u0590\u0593\3\2\2\2\u0591"+
		"\u058f\3\2\2\2\u0591\u0592\3\2\2\2\u0592\u0594\3\2\2\2\u0593\u0591\3\2"+
		"\2\2\u0594\u0595\7\27\2\2\u0595\u0596\5P)\2\u0596\u0597\3\2\2\2\u0597"+
		"\u0598\b.\1\2\u0598[\3\2\2\2\u0599\u059e\5^\60\2\u059a\u059b\7\5\2\2\u059b"+
		"\u059d\5^\60\2\u059c\u059a\3\2\2\2\u059d\u05a0\3\2\2\2\u059e\u059c\3\2"+
		"\2\2\u059e\u059f\3\2\2\2\u059f]\3\2\2\2\u05a0\u059e\3\2\2\2\u05a1\u05a3"+
		"\7\u0087\2\2\u05a2\u05a1\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3\u05a4\3\2\2"+
		"\2\u05a4\u05a9\5b\62\2\u05a5\u05a6\7\5\2\2\u05a6\u05a8\5b\62\2\u05a7\u05a5"+
		"\3\2\2\2\u05a8\u05ab\3\2\2\2\u05a9\u05a7\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa"+
		"\u05ac\3\2\2\2\u05ab\u05a9\3\2\2\2\u05ac\u05ae\7\b\2\2\u05ad\u05af\7Z"+
		"\2\2\u05ae\u05ad\3\2\2\2\u05ae\u05af\3\2\2\2\u05af\u05b0\3\2\2\2\u05b0"+
		"\u05b1\5P)\2\u05b1\u05b2\3\2\2\2\u05b2\u05b3\b\60\1\2\u05b3_\3\2\2\2\u05b4"+
		"\u05b5\7\u008a\2\2\u05b5a\3\2\2\2\u05b6\u05b7\7\u008a\2\2\u05b7c\3\2\2"+
		"\2\u05b8\u05b9\7\u0089\2\2\u05b9e\3\2\2\2\u05ba\u05c4\5h\65\2\u05bb\u05bc"+
		"\7\u0088\2\2\u05bc\u05be\5h\65\2\u05bd\u05bb\3\2\2\2\u05be\u05c1\3\2\2"+
		"\2\u05bf\u05bd\3\2\2\2\u05bf\u05c0\3\2\2\2\u05c0\u05c2\3\2\2\2\u05c1\u05bf"+
		"\3\2\2\2\u05c2\u05c3\7\u0088\2\2\u05c3\u05c5\5h\65\2\u05c4\u05bf\3\2\2"+
		"\2\u05c4\u05c5\3\2\2\2\u05c5g\3\2\2\2\u05c6\u05c7\7\u008a\2\2\u05c7i\3"+
		"\2\2\2\u05c8\u05c9\t\24\2\2\u05c9k\3\2\2\2\u05ca\u05cb\7\u0089\2\2\u05cb"+
		"m\3\2\2\2\u05cc\u05ce\7v\2\2\u05cd\u05cc\3\2\2\2\u05cd\u05ce\3\2\2\2\u05ce"+
		"\u05cf\3\2\2\2\u05cf\u05d0\7\u0089\2\2\u05d0o\3\2\2\2\u00e2qz\u0094\u009d"+
		"\u00a8\u00ad\u00b6\u00bd\u00c1\u00c7\u00d3\u00d6\u00df\u00e2\u00f1\u00f9"+
		"\u0104\u0109\u010c\u0110\u0115\u011b\u0122\u0128\u0137\u0139\u013e\u0143"+
		"\u0146\u0149\u0153\u0156\u015a\u015e\u0161\u0168\u016a\u016f\u0173\u0176"+
		"\u0179\u017d\u0180\u0183\u0187\u018a\u0190\u0195\u0197\u01a4\u01a7\u01ab"+
		"\u01ae\u01b4\u01b8\u01bd\u01c1\u01c4\u01c6\u01cb\u01ce\u01d1\u01d5\u01d8"+
		"\u01db\u01df\u01e2\u01e8\u01ed\u01ef\u01f3\u0202\u0205\u0209\u020c\u0216"+
		"\u021d\u0221\u0226\u022a\u022d\u022f\u0234\u0237\u023a\u0244\u0247\u024d"+
		"\u024f\u0257\u025a\u0263\u0266\u026a\u026d\u0274\u0276\u027b\u027f\u0285"+
		"\u0287\u028e\u0291\u0295\u0298\u029e\u02a2\u02a6\u02ac\u02af\u02b3\u02b8"+
		"\u02bc\u02c1\u02c5\u02ca\u02cd\u02d4\u02d8\u02db\u02e0\u02e5\u02e9\u02ee"+
		"\u02f1\u02f7\u02f9\u02fe\u0303\u0307\u030d\u0312\u0316\u031e\u0323\u0329"+
		"\u032b\u0330\u0338\u033e\u0343\u034f\u035a\u035f\u0363\u0367\u036b\u036e"+
		"\u0375\u0377\u037b\u037f\u0386\u0388\u038c\u0390\u0397\u0399\u039d\u03a1"+
		"\u03a8\u03b7\u03be\u03c5\u03cc\u03d3\u03da\u03e1\u0413\u0417\u041d\u0421"+
		"\u042e\u0432\u0438\u043c\u0449\u044d\u0453\u0457\u0464\u0468\u046e\u0472"+
		"\u047f\u0483\u0489\u048d\u049a\u049e\u04a4\u04a8\u04b2\u04c0\u04c2\u04ea"+
		"\u04fa\u04fe\u0509\u050b\u051b\u0522\u0533\u0535\u053d\u0541\u0548\u054d"+
		"\u0553\u055a\u0563\u056a\u0573\u057a\u0582\u0589\u0591\u059e\u05a2\u05a9"+
		"\u05ae\u05bf\u05c4\u05cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}