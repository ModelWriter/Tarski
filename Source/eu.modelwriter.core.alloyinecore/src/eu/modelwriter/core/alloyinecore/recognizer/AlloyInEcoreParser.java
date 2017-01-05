// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.recognizer;

import eu.modelwriter.core.alloyinecore.structure.*;
import eu.modelwriter.core.alloyinecore.structure.Package;
import eu.modelwriter.core.alloyinecore.structure.Class;
import eu.modelwriter.core.alloyinecore.structure.Reference;
import eu.modelwriter.core.alloyinecore.structure.Attribute;
import eu.modelwriter.core.alloyinecore.structure.Operation;
import eu.modelwriter.core.alloyinecore.structure.Enum;
import eu.modelwriter.core.alloyinecore.structure.Parameter;
import eu.modelwriter.core.alloyinecore.structure.EnumLiteral;

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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

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
		T__131=132, INT=133, IDENTIFIER=134, DOUBLE_QUOTED_STRING=135, SINGLE_QUOTED_STRING=136, 
		ML_SINGLE_QUOTED_STRING=137, MULTILINE_COMMENT=138, SINGLELINE_COMMENT=139, 
		WS=140;
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
		RULE_initial = 35, RULE_derivation = 36, RULE_visibilityKind = 37, RULE_atom = 38, 
		RULE_arity = 39, RULE_formula = 40, RULE_expression = 41, RULE_intexpression = 42, 
		RULE_decls = 43, RULE_decl = 44, RULE_letDecls = 45, RULE_letDecl = 46, 
		RULE_comprehensionDecls = 47, RULE_comprehensionDecl = 48, RULE_relationId = 49, 
		RULE_variableId = 50, RULE_integer = 51, RULE_unrestrictedName = 52, RULE_qualifiedName = 53, 
		RULE_identifier = 54, RULE_upper = 55, RULE_lower = 56, RULE_signed = 57;
	public static final String[] ruleNames = {
		"problem", "options", "option", "universe", "relations", "relation", "tupleSet", 
		"tuple", "module", "packageImport", "ePackage", "eClassifier", "eClass", 
		"eStructuralFeature", "eAttribute", "eReference", "eOperation", "eParameter", 
		"eType", "eMultiplicity", "eDataType", "ePrimitiveType", "eEnum", "eEnumLiteral", 
		"eAnnotation", "eDetail", "eModelElement", "eNamedElement", "eTypedElement", 
		"eModelElementRef", "templateSignature", "body", "invariant", "precondition", 
		"postcondition", "initial", "derivation", "visibilityKind", "atom", "arity", 
		"formula", "expression", "intexpression", "decls", "decl", "letDecls", 
		"letDecl", "comprehensionDecls", "comprehensionDecl", "relationId", "variableId", 
		"integer", "unrestrictedName", "qualifiedName", "identifier", "upper", 
		"lower", "signed"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'options'", "'{'", "','", "'}'", "'symmetry_breaking'", "':'", 
		"'bit_width'", "'skolem_depth'", "'sharing'", "'universe'", "'['", "']'", 
		"'relations'", "'..'", "'('", "')'", "'module'", "'import'", "';'", "'package'", 
		"'='", "'abstract'", "'class'", "'interface'", "'extends'", "'static'", 
		"'model'", "'ghost'", "'transient'", "'volatile'", "'nullable'", "'!nullable'", 
		"'readonly'", "'attribute'", "'derived'", "'id'", "'ordered'", "'!ordered'", 
		"'unique'", "'!unique'", "'unsettable'", "'!unsettable'", "'property'", 
		"'#'", "'composes'", "'resolve'", "'!resolve'", "'key'", "'operation'", 
		"'throws'", "'*'", "'+'", "'?'", "'|?'", "'|1'", "'primitive'", "'datatype'", 
		"'serializable'", "'!serializable'", "'Boolean'", "'Integer'", "'String'", 
		"'Real'", "'UnlimitedNatural'", "'enum'", "'literal'", "'annotation'", 
		"'reference'", "'<'", "'>'", "'body'", "'callable'", "'invariant'", "'precondition'", 
		"'requires'", "'postcondition'", "'ensures'", "'initial'", "'derivation'", 
		"'public'", "'protected'", "'private'", "'no'", "'lone'", "'one'", "'some'", 
		"'!'", "'not'", "'in'", "'<='", "'>='", "'sum'", "'|'", "'acyclic'", "'function'", 
		"'->'", "'ord'", "'&&'", "'and'", "'||'", "'or'", "'=>'", "'if'", "'<=>'", 
		"'iff'", "'all'", "'let'", "'true'", "'false'", "'~'", "'^'", "'&'", "'-'", 
		"'.'", "'set'", "'++'", "'then'", "'else'", "'iden'", "'none'", "'univ'", 
		"'ints'", "'plus'", "'minus'", "'mul'", "'/'", "'div'", "'%'", "'modulo'", 
		"'disj'", "'definition'", "'::'"
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
		null, "INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", 
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

	private boolean isRelation() {
	//System.out.println("isRelation? " + this.relations.containsKey(getCurrentToken().getText()) + ": " + getCurrentToken().getText());
	return this.relations.containsKey(getCurrentToken().getText()); }
	private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}
	private String context = null;
	private int declareVariables(java.util.List<VariableIdContext> vars, int var) {
	    //System.out.println("Quantifier context: ");
	    for (VariableIdContext vc : vars) {
	        String s = vc.getText();
	        declarations.add(s);
	        var++;
	        //System.out.println(s);
	    }
	    return var;
	}
	private void printUniverse() {
	    //System.out.println(universe);
	}
	private void printBounds() {
	    //System.out.println(bounds);
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
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(116);
				options();
				}
			}

			setState(119);
			universe();
			printUniverse();
			setState(121);
			relations();
			printBounds();
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					((ProblemContext)_localctx).formula = formula(0);
					((ProblemContext)_localctx).formulas.add(((ProblemContext)_localctx).formula);
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}


			    //System.out.println("declarations= "+declarations);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__0);
			setState(133);
			match(T__1);
			setState(134);
			option();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(135);
				match(T__2);
				setState(136);
				option();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
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
		public Token key;
		public IntegerContext value;
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
		public Token key;
		public IntegerContext value;
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
		public Token key;
		public IntegerContext value;
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
		public Token key;
		public IntegerContext value;
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
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				((SymmetryBreakingContext)_localctx).key = match(T__4);
				setState(145);
				match(T__5);
				setState(146);
				((SymmetryBreakingContext)_localctx).value = integer();
				}
				break;
			case T__6:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				((BitWidthContext)_localctx).key = match(T__6);
				setState(148);
				match(T__5);
				setState(149);
				((BitWidthContext)_localctx).value = integer();
				}
				break;
			case T__7:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				((SkolemDepthContext)_localctx).key = match(T__7);
				setState(151);
				match(T__5);
				setState(152);
				((SkolemDepthContext)_localctx).value = integer();
				}
				break;
			case T__8:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				((SharingContext)_localctx).key = match(T__8);
				setState(154);
				match(T__5);
				setState(155);
				((SharingContext)_localctx).value = integer();
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
			setState(158);
			match(T__9);
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(159);
				match(T__1);
				{
				setState(160);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(161);
					match(T__2);
					setState(162);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(168);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				{
				setState(170);
				match(T__10);
				{
				setState(171);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(172);
					match(T__2);
					setState(173);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(179);
				match(T__11);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			    //System.out.println("universe:");
			    for (AtomContext atom : ((UniverseContext)_localctx).atoms) {
			        String s = atom.getText();
			        //System.out.println(s);
			        if (atoms.contains(s)) {
			            notifyErrorListeners(atom.getStart(),"duplicated atom found: '"+ s + "'", (RecognitionException)null);
			        }
			        else {atoms.add(s);}
			    }
			    this.universe = new kodkod.instance.Universe(this.atoms);
			    this.bounds = new kodkod.instance.Bounds(this.universe);
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
			setState(185);
			match(T__12);
			setState(186);
			match(T__1);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(187);
				relation();
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
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
		public IdentifierContext name;
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
			setState(196);
			((RelationContext)_localctx).name = ((RelationContext)_localctx).identifier = identifier();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(197);
				((RelationContext)_localctx).arity = arity();
				}
			}

			setState(200);
			match(T__5);
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(201);
				expression(0);
				}
				break;
			}
			setState(204);
			match(T__10);
			{
			setState(205);
			((RelationContext)_localctx).lowerBound = tupleSet();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(206);
				match(T__2);
				setState(207);
				((RelationContext)_localctx).upperBound = tupleSet();
				}
			}

			}
			setState(210);
			match(T__11);
			}

			    String name = (((RelationContext)_localctx).identifier!=null?_input.getText(((RelationContext)_localctx).identifier.start,((RelationContext)_localctx).identifier.stop):null);
			    //System.out.println("relation " + name);
			    if (relations.containsKey(name)) {
			        notifyErrorListeners(((RelationContext)_localctx).name.getStart(), "duplicated relation found: '"+ name + "'", (RecognitionException)null);
			    }
			    kodkod.ast.Relation relation = null;
			    int arity = 0;
			    if ((((RelationContext)_localctx).arity!=null?_input.getText(((RelationContext)_localctx).arity.start,((RelationContext)_localctx).arity.stop):null) != null && !(((RelationContext)_localctx).arity!=null?_input.getText(((RelationContext)_localctx).arity.start,((RelationContext)_localctx).arity.stop):null).isEmpty()) {arity = Integer.parseInt((((RelationContext)_localctx).arity!=null?_input.getText(((RelationContext)_localctx).arity.start,((RelationContext)_localctx).arity.stop):null));}

			    kodkod.instance.TupleSet lowerBound = null;
			    java.util.List<kodkod.instance.Tuple> tuplesInLowerBound = new java.util.ArrayList<kodkod.instance.Tuple>();
			    if (((RelationContext)_localctx).lowerBound != null && !((RelationContext)_localctx).lowerBound.tuples.isEmpty()){
			        if (arity == 0) {arity = ((RelationContext)_localctx).lowerBound.tuples.get(0).atoms.size();}
			        for (TupleContext tuple : ((RelationContext)_localctx).lowerBound.tuples) {
			            java.util.List<String> atomsInTuple = new java.util.ArrayList<String>();
			            for (AtomContext atom : tuple.atoms) {
			                if (atom.getText() == null || atom.getText().isEmpty()) continue;
			                if (this.atoms.contains(atom.getText())) atomsInTuple.add(atom.getText());
			            }
			            if (!atomsInTuple.isEmpty() && atomsInTuple.size() == arity) {
			                tuplesInLowerBound.add(this.universe.factory().tuple(atomsInTuple));
			            }
			        }
			        lowerBound = this.universe.factory().setOf(tuplesInLowerBound);
			        //System.out.println("lb: " +lowerBound);
			    }

			    kodkod.instance.TupleSet upperBound = null;
			    java.util.List<kodkod.instance.Tuple> tuplesInUpperBound = new java.util.ArrayList<kodkod.instance.Tuple>();
			    if (((RelationContext)_localctx).upperBound != null && !((RelationContext)_localctx).upperBound.tuples.isEmpty()){
			        if (lowerBound == null && arity == 0) {arity = ((RelationContext)_localctx).upperBound.tuples.get(0).atoms.size();}
			        for (TupleContext tuple : ((RelationContext)_localctx).upperBound.tuples) {
			            java.util.List<String> atomsInTuple = new java.util.ArrayList<String>();
			            for (AtomContext atom : tuple.atoms) {
			                if (atom.getText() == null || atom.getText().isEmpty()) continue;
			                if (this.atoms.contains(atom.getText())) atomsInTuple.add(atom.getText());
			            }
			            if (!atomsInTuple.isEmpty() && atomsInTuple.size() == arity) {
			                tuplesInUpperBound.add(this.universe.factory().tuple(atomsInTuple));
			            }
			        }
			        upperBound = this.universe.factory().setOf(tuplesInUpperBound);
			        //System.out.println("up: " +upperBound);
			    }

			    if (lowerBound == null && upperBound == null && arity == 0) {arity = 1;}

			    if (lowerBound == null) {lowerBound = this.universe.factory().noneOf(arity);}

			    //System.out.println(arity);
			    if (arity == 0) {
			        notifyErrorListeners(((RelationContext)_localctx).arity.getStart(), "0 arity is detected on relation: '"+ name + "'", (RecognitionException)null);
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
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(T__1);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10 || _la==T__14) {
					{
					setState(215);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(216);
						match(T__2);
						setState(217);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(222);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(225);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(T__10);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10 || _la==T__14) {
					{
					setState(227);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(228);
						match(T__2);
						setState(229);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(234);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(237);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				match(T__1);
				setState(239);
				((TupleSetContext)_localctx).left = tuple();
				setState(240);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(241);
				((TupleSetContext)_localctx).right = tuple();
				setState(242);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				match(T__10);
				setState(245);
				((TupleSetContext)_localctx).left = tuple();
				setState(246);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(247);
				((TupleSetContext)_localctx).right = tuple();
				setState(248);
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
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				match(T__14);
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
				match(T__15);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				match(T__10);
				setState(264);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(265);
					match(T__2);
					setState(266);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(272);
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
		public EPackageContext ownedPackage;
		public EPackageContext ePackage() {
			return getRuleContext(EPackageContext.class,0);
		}
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
		  Document.getInstance().parser = this;  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(276);
				options();
				}
			}

			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(279);
				match(T__16);
				setState(280);
				identifier();
				}
			}

			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(283);
				((ModuleContext)_localctx).packageImport = packageImport();
				((ModuleContext)_localctx).ownedPackageImport.add(((ModuleContext)_localctx).packageImport);
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(289);
			((ModuleContext)_localctx).ownedPackage = ePackage();
			Document.getInstance().signalParsingCompletion();
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
			setState(292);
			match(T__17);
			}
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(293);
				((PackageImportContext)_localctx).name = identifier();
				setState(294);
				match(T__5);
				}
			}

			setState(298);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(299);
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
		public UnrestrictedNameContext name;
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
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(301);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(304);
			match(T__19);
			setState(305);
			((EPackageContext)_localctx).name = unrestrictedName();
			{
			setState(306);
			match(T__5);
			setState(307);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(309);
			match(T__20);
			setState(310);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}

			        Package p = Document.getInstance().create(_localctx);
			        Document.getInstance().ownershipStack.push(p);
			    
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(313);
				match(T__1);
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (T__19 - 20)) | (1L << (T__21 - 20)) | (1L << (T__22 - 20)) | (1L << (T__23 - 20)) | (1L << (T__30 - 20)) | (1L << (T__31 - 20)) | (1L << (T__55 - 20)) | (1L << (T__56 - 20)) | (1L << (T__64 - 20)) | (1L << (T__66 - 20)) | (1L << (T__71 - 20)) | (1L << (T__72 - 20)) | (1L << (T__79 - 20)) | (1L << (T__80 - 20)) | (1L << (T__81 - 20)))) != 0)) {
					{
					setState(318);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(314);
						((EPackageContext)_localctx).eAnnotation = eAnnotation();
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						}
						break;
					case 2:
						{
						setState(315);
						((EPackageContext)_localctx).ePackage = ePackage();
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						}
						break;
					case 3:
						{
						setState(316);
						((EPackageContext)_localctx).eClassifier = eClassifier();
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						}
						break;
					case 4:
						{
						setState(317);
						((EPackageContext)_localctx).invariant = invariant();
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(322);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(323);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(324);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        notifyErrorListeners(Document.getInstance().ownershipStack.peek().getToken(), "Package detected: '" + Document.getInstance().ownershipStack.peek().qualifiedName + "'", (RecognitionException)null);
			        Document.getInstance().ownershipStack.pop();
			    
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
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				eClass();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(330);
				eDataType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(331);
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
		public Token isClass;
		public Token isInterface;
		public UnrestrictedNameContext name;
		public ETypeContext eType;
		public List<ETypeContext> eSuperTypes = new ArrayList<ETypeContext>();
		public Token instanceClassName;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EOperationContext eOperation;
		public List<EOperationContext> eOperations = new ArrayList<EOperationContext>();
		public EStructuralFeatureContext eStructuralFeature;
		public List<EStructuralFeatureContext> eStructuralFeatures = new ArrayList<EStructuralFeatureContext>();
		public InvariantContext invariant;
		public List<InvariantContext> eConstraints = new ArrayList<InvariantContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public List<ETypeContext> eType() {
			return getRuleContexts(ETypeContext.class);
		}
		public ETypeContext eType(int i) {
			return getRuleContext(ETypeContext.class,i);
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
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(334);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				{
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(337);
					((EClassContext)_localctx).isAbstract = match(T__21);
					}
				}

				setState(340);
				((EClassContext)_localctx).isClass = match(T__22);
				}
				break;
			case T__23:
				{
				setState(341);
				((EClassContext)_localctx).isInterface = match(T__23);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(344);
			((EClassContext)_localctx).name = unrestrictedName();
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(345);
				match(T__24);
				setState(346);
				((EClassContext)_localctx).eType = eType();
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eType);
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(347);
					match(T__2);
					setState(348);
					((EClassContext)_localctx).eType = eType();
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eType);
					}
					}
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(356);
				match(T__5);
				setState(357);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}


			        Class c = Document.getInstance().create(_localctx);
			        Document.getInstance().ownershipStack.push(c);
			    
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(361);
				match(T__1);
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & ((1L << (T__25 - 26)) | (1L << (T__26 - 26)) | (1L << (T__27 - 26)) | (1L << (T__28 - 26)) | (1L << (T__29 - 26)) | (1L << (T__30 - 26)) | (1L << (T__31 - 26)) | (1L << (T__32 - 26)) | (1L << (T__33 - 26)) | (1L << (T__42 - 26)) | (1L << (T__48 - 26)) | (1L << (T__66 - 26)) | (1L << (T__71 - 26)) | (1L << (T__72 - 26)) | (1L << (T__79 - 26)) | (1L << (T__80 - 26)) | (1L << (T__81 - 26)))) != 0)) {
					{
					setState(366);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						setState(362);
						((EClassContext)_localctx).eAnnotation = eAnnotation();
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						}
						break;
					case 2:
						{
						setState(363);
						((EClassContext)_localctx).eOperation = eOperation();
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						}
						break;
					case 3:
						{
						setState(364);
						((EClassContext)_localctx).eStructuralFeature = eStructuralFeature();
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						}
						break;
					case 4:
						{
						setState(365);
						((EClassContext)_localctx).invariant = invariant();
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(370);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(371);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(372);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        notifyErrorListeners(Document.getInstance().ownershipStack.peek().getToken(), "Class detected: '" + Document.getInstance().ownershipStack.peek().qualifiedName + "'", (RecognitionException)null);
			        Document.getInstance().ownershipStack.pop();
			    
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
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				eAttribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(378);
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
		public UnrestrictedNameContext name;
		public ETypeContext eAttributeType;
		public EMultiplicityContext multiplicity;
		public Token defaultValue;
		public Token s35;
		public Token s36;
		public Token s37;
		public Token s38;
		public Token s39;
		public Token s40;
		public Token s41;
		public Token s42;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public DerivationContext ownedDerivation;
		public InitialContext ownedInitial;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public ETypeContext eType() {
			return getRuleContext(ETypeContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
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
		public DerivationContext derivation() {
			return getRuleContext(DerivationContext.class,0);
		}
		public InitialContext initial() {
			return getRuleContext(InitialContext.class,0);
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
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(381);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(384);
				((EAttributeContext)_localctx).s26 = match(T__25);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
				}
			}

			setState(389);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(387);
				((EAttributeContext)_localctx).s27 = match(T__26);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(388);
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
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(391);
				((EAttributeContext)_localctx).s29 = match(T__28);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
				}
			}

			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(394);
				((EAttributeContext)_localctx).s30 = match(T__29);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
				}
			}

			setState(399);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(397);
				((EAttributeContext)_localctx).s31 = match(T__30);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(398);
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
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(401);
				((EAttributeContext)_localctx).s33 = match(T__32);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s33);
				}
			}

			setState(404);
			match(T__33);
			setState(405);
			((EAttributeContext)_localctx).name = unrestrictedName();
			{
			setState(406);
			match(T__5);
			setState(407);
			((EAttributeContext)_localctx).eAttributeType = eType();
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(408);
				((EAttributeContext)_localctx).multiplicity = eMultiplicity();
				}
			}

			}
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(411);
				match(T__20);
				setState(412);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(415);
				match(T__1);
				setState(429); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(424);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__34:
						{
						setState(416);
						((EAttributeContext)_localctx).s35 = match(T__34);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(417);
						((EAttributeContext)_localctx).s36 = match(T__35);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(418);
						((EAttributeContext)_localctx).s37 = match(T__36);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(419);
						((EAttributeContext)_localctx).s38 = match(T__37);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(420);
						((EAttributeContext)_localctx).s39 = match(T__38);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(421);
						((EAttributeContext)_localctx).s40 = match(T__39);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(422);
						((EAttributeContext)_localctx).s41 = match(T__40);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(423);
						((EAttributeContext)_localctx).s42 = match(T__41);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(427);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(426);
						match(T__2);
						}
					}

					}
					}
					setState(431); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0) );
				setState(433);
				match(T__3);
				}
				break;
			}
			setState(461);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(436);
				match(T__1);
				setState(457);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					{
					setState(440);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(437);
						((EAttributeContext)_localctx).eAnnotation = eAnnotation();
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						}
						}
						setState(442);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(445);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__78:
						{
						setState(443);
						((EAttributeContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__77:
						{
						setState(444);
						((EAttributeContext)_localctx).ownedInitial = initial();
						}
						break;
					case T__3:
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					break;
				case 2:
					{
					{
					setState(449);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__78:
						{
						setState(447);
						((EAttributeContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__77:
						{
						setState(448);
						((EAttributeContext)_localctx).ownedInitial = initial();
						}
						break;
					case T__3:
					case T__66:
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(454);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(451);
						((EAttributeContext)_localctx).eAnnotation = eAnnotation();
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						}
						}
						setState(456);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				}
				setState(459);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(460);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        Attribute a = Document.getInstance().create(_localctx);
			        notifyErrorListeners((((EAttributeContext)_localctx).name!=null?(((EAttributeContext)_localctx).name.start):null), "Attribute detected: '" + a.qualifiedName + "'", (RecognitionException)null);
			    
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
		public UnrestrictedNameContext name;
		public ETypeContext eOpposite;
		public ETypeContext eReferenceType;
		public EMultiplicityContext multiplicity;
		public Token defaultValue;
		public Token s45;
		public Token s35;
		public Token s37;
		public Token s38;
		public Token s39;
		public Token s40;
		public Token s46;
		public Token s47;
		public Token s41;
		public Token s42;
		public QualifiedNameContext qualifiedName;
		public List<QualifiedNameContext> referredKeys = new ArrayList<QualifiedNameContext>();
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public DerivationContext ownedDerivation;
		public InitialContext ownedInitial;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public List<ETypeContext> eType() {
			return getRuleContexts(ETypeContext.class);
		}
		public ETypeContext eType(int i) {
			return getRuleContext(ETypeContext.class,i);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<EAnnotationContext> eAnnotation() {
			return getRuleContexts(EAnnotationContext.class);
		}
		public EAnnotationContext eAnnotation(int i) {
			return getRuleContext(EAnnotationContext.class,i);
		}
		public DerivationContext derivation() {
			return getRuleContext(DerivationContext.class,0);
		}
		public InitialContext initial() {
			return getRuleContext(InitialContext.class,0);
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
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(465);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(468);
				((EReferenceContext)_localctx).s26 = match(T__25);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
				}
			}

			setState(473);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(471);
				((EReferenceContext)_localctx).s27 = match(T__26);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(472);
				((EReferenceContext)_localctx).s28 = match(T__27);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s28);
				}
				break;
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__42:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(475);
				((EReferenceContext)_localctx).s29 = match(T__28);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
				}
			}

			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(478);
				((EReferenceContext)_localctx).s30 = match(T__29);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
				}
			}

			setState(483);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(481);
				((EReferenceContext)_localctx).s31 = match(T__30);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(482);
				((EReferenceContext)_localctx).s32 = match(T__31);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s32);
				}
				break;
			case T__32:
			case T__42:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(485);
				((EReferenceContext)_localctx).s33 = match(T__32);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s33);
				}
			}

			setState(488);
			match(T__42);
			setState(489);
			((EReferenceContext)_localctx).name = unrestrictedName();
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__43) {
				{
				setState(490);
				match(T__43);
				setState(491);
				((EReferenceContext)_localctx).eOpposite = eType();
				}
			}

			{
			setState(494);
			match(T__5);
			setState(495);
			((EReferenceContext)_localctx).eReferenceType = eType();
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(496);
				((EReferenceContext)_localctx).multiplicity = eMultiplicity();
				}
			}

			}
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(499);
				match(T__20);
				setState(500);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(524);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(503);
				match(T__1);
				setState(519); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(514);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__44:
						{
						setState(504);
						((EReferenceContext)_localctx).s45 = match(T__44);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s45);
						}
						break;
					case T__34:
						{
						setState(505);
						((EReferenceContext)_localctx).s35 = match(T__34);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s35);
						}
						break;
					case T__36:
						{
						setState(506);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(507);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(508);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(509);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					case T__45:
						{
						setState(510);
						((EReferenceContext)_localctx).s46 = match(T__45);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s46);
						}
						break;
					case T__46:
						{
						setState(511);
						((EReferenceContext)_localctx).s47 = match(T__46);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s47);
						}
						break;
					case T__40:
						{
						setState(512);
						((EReferenceContext)_localctx).s41 = match(T__40);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(513);
						((EReferenceContext)_localctx).s42 = match(T__41);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(517);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(516);
						match(T__2);
						}
					}

					}
					}
					setState(521); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0) );
				setState(523);
				match(T__3);
				}
				break;
			}
			setState(564);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(526);
				match(T__1);
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__47) {
					{
					setState(527);
					match(T__47);
					setState(528);
					((EReferenceContext)_localctx).qualifiedName = qualifiedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
					setState(533);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(529);
						match(T__2);
						setState(530);
						((EReferenceContext)_localctx).qualifiedName = qualifiedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
						}
						}
						setState(535);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(536);
					match(T__18);
					}
				}

				setState(560);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					{
					setState(543);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(540);
						((EReferenceContext)_localctx).eAnnotation = eAnnotation();
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						}
						}
						setState(545);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(548);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__78:
						{
						setState(546);
						((EReferenceContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__77:
						{
						setState(547);
						((EReferenceContext)_localctx).ownedInitial = initial();
						}
						break;
					case T__3:
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					break;
				case 2:
					{
					{
					setState(552);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__78:
						{
						setState(550);
						((EReferenceContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__77:
						{
						setState(551);
						((EReferenceContext)_localctx).ownedInitial = initial();
						}
						break;
					case T__3:
					case T__66:
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(557);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(554);
						((EReferenceContext)_localctx).eAnnotation = eAnnotation();
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						}
						}
						setState(559);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				}
				setState(562);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(563);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

				    Reference r = Document.getInstance().create(_localctx);
			        notifyErrorListeners((((EReferenceContext)_localctx).name!=null?(((EReferenceContext)_localctx).name.start):null), "Reference detected: '" + r.qualifiedName + "'", (RecognitionException)null);
				
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
		public UnrestrictedNameContext name;
		public EParameterContext eParameter;
		public List<EParameterContext> eParameters = new ArrayList<EParameterContext>();
		public ETypeContext eReturnType;
		public EMultiplicityContext multiplicity;
		public IdentifierContext identifier;
		public List<IdentifierContext> ownedException = new ArrayList<IdentifierContext>();
		public Token s37;
		public Token s38;
		public Token s39;
		public Token s40;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public PreconditionContext precondition;
		public List<PreconditionContext> ownedPreconditions = new ArrayList<PreconditionContext>();
		public BodyContext body;
		public List<BodyContext> ownedBodyExpression = new ArrayList<BodyContext>();
		public PostconditionContext postcondition;
		public List<PostconditionContext> ownedPostconditions = new ArrayList<PostconditionContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
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
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
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
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(568);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(571);
				((EOperationContext)_localctx).s26 = match(T__25);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
				}
			}

			setState(574);
			match(T__48);
			setState(575);
			((EOperationContext)_localctx).name = unrestrictedName();

			        Operation o = Document.getInstance().create(_localctx);
			        Document.getInstance().ownershipStack.push(o);
			    
			setState(577);
			match(T__14);
			setState(586);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__30 - 17)) | (1L << (T__31 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__70 - 17)) | (1L << (T__71 - 17)) | (1L << (T__72 - 17)) | (1L << (T__73 - 17)) | (1L << (T__75 - 17)) | (1L << (T__77 - 17)) | (1L << (T__78 - 17)))) != 0) || _la==T__130 || _la==IDENTIFIER) {
				{
				setState(578);
				((EOperationContext)_localctx).eParameter = eParameter();
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(579);
					match(T__2);
					setState(580);
					((EOperationContext)_localctx).eParameter = eParameter();
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(585);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(588);
			match(T__15);
			setState(594);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(589);
				match(T__5);
				setState(590);
				((EOperationContext)_localctx).eReturnType = eType();
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(591);
					((EOperationContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__49) {
				{
				setState(596);
				match(T__49);
				setState(597);
				((EOperationContext)_localctx).identifier = identifier();
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
				setState(602);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(598);
					match(T__2);
					setState(599);
					((EOperationContext)_localctx).identifier = identifier();
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
					}
					}
					setState(604);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(622);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				{
				setState(607);
				match(T__1);
				setState(617); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(612);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(608);
						((EOperationContext)_localctx).s37 = match(T__36);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(609);
						((EOperationContext)_localctx).s38 = match(T__37);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(610);
						((EOperationContext)_localctx).s39 = match(T__38);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(611);
						((EOperationContext)_localctx).s40 = match(T__39);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s40);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(615);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(614);
						match(T__2);
						}
					}

					}
					}
					setState(619); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(621);
				match(T__3);
				}
				break;
			}
			setState(636);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(624);
				match(T__1);
				setState(631);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__70 - 67)) | (1L << (T__73 - 67)) | (1L << (T__74 - 67)) | (1L << (T__75 - 67)) | (1L << (T__76 - 67)))) != 0)) {
					{
					setState(629);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(625);
						((EOperationContext)_localctx).eAnnotation = eAnnotation();
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						}
						break;
					case T__73:
					case T__74:
						{
						setState(626);
						((EOperationContext)_localctx).precondition = precondition();
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						}
						break;
					case T__70:
						{
						setState(627);
						((EOperationContext)_localctx).body = body();
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						}
						break;
					case T__75:
					case T__76:
						{
						setState(628);
						((EOperationContext)_localctx).postcondition = postcondition();
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(633);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(634);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(635);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        notifyErrorListeners(Document.getInstance().ownershipStack.peek().getToken(), "Operation detected: '" + Document.getInstance().ownershipStack.peek().qualifiedName + "'", (RecognitionException)null);
			        Document.getInstance().ownershipStack.pop();
			    
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
		public UnrestrictedNameContext name;
		public ETypeContext eParameterType;
		public EMultiplicityContext ownedMultiplicity;
		public Token s37;
		public Token s38;
		public Token s39;
		public Token s40;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
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
			setState(642);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(640);
				((EParameterContext)_localctx).s31 = match(T__30);
				((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(641);
				((EParameterContext)_localctx).s32 = match(T__31);
				((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s32);
				}
				break;
			case T__16:
			case T__17:
			case T__19:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__28:
			case T__29:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__38:
			case T__40:
			case T__42:
			case T__44:
			case T__45:
			case T__47:
			case T__48:
			case T__49:
			case T__55:
			case T__56:
			case T__57:
			case T__64:
			case T__65:
			case T__66:
			case T__67:
			case T__70:
			case T__71:
			case T__72:
			case T__73:
			case T__75:
			case T__77:
			case T__78:
			case T__130:
			case IDENTIFIER:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(644);
			((EParameterContext)_localctx).name = unrestrictedName();
			setState(650);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(645);
				match(T__5);
				setState(646);
				((EParameterContext)_localctx).eParameterType = eType();
				setState(648);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(647);
					((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(667);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(652);
				match(T__1);
				setState(662); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(657);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(653);
						((EParameterContext)_localctx).s37 = match(T__36);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(654);
						((EParameterContext)_localctx).s38 = match(T__37);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(655);
						((EParameterContext)_localctx).s39 = match(T__38);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(656);
						((EParameterContext)_localctx).s40 = match(T__39);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s40);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(660);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(659);
						match(T__2);
						}
					}

					}
					}
					setState(664); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(666);
				match(T__3);
				}
				break;
			}
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(669);
				match(T__1);
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(670);
					((EParameterContext)_localctx).eAnnotation = eAnnotation();
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(675);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(676);
				match(T__3);
				}
			}


				    Parameter p = Document.getInstance().create(_localctx);
			        notifyErrorListeners((((EParameterContext)_localctx).name!=null?(((EParameterContext)_localctx).name.start):null), "Parameter detected: '" + p.qualifiedName + "'", (RecognitionException)null);
				
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
			setState(683);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
				enterOuterAlt(_localctx, 1);
				{
				setState(681);
				ePrimitiveType();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(682);
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
			setState(685);
			match(T__10);
			setState(692);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(686);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(689);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(687);
					match(T__13);
					setState(688);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__50:
			case T__51:
			case T__52:
				{
				setState(691);
				((EMultiplicityContext)_localctx).stringBounds = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__50) | (1L << T__51) | (1L << T__52))) != 0)) ) {
					((EMultiplicityContext)_localctx).stringBounds = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(696);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__53:
				{
				setState(694);
				match(T__53);
				}
				break;
			case T__54:
				{
				setState(695);
				((EMultiplicityContext)_localctx).isNullFree = match(T__54);
				}
				break;
			case T__11:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(698);
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
		public VisibilityKindContext visibility;
		public Token s56;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s31;
		public Token s32;
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public Token instanceClassName;
		public Token s58;
		public Token s59;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public InvariantContext invariant;
		public List<InvariantContext> ownedConstraints = new ArrayList<InvariantContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
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
			setState(701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(700);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(708);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__55:
				{
				setState(703);
				((EDataTypeContext)_localctx).s56 = match(T__55);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s56);
				}
				break;
			case T__30:
			case T__31:
				{
				setState(706);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__30:
					{
					setState(704);
					((EDataTypeContext)_localctx).s31 = match(T__30);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s31);
					}
					break;
				case T__31:
					{
					setState(705);
					((EDataTypeContext)_localctx).s32 = match(T__31);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s32);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__56:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(710);
			match(T__56);
			setState(711);
			((EDataTypeContext)_localctx).name = unrestrictedName();
			setState(713);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14 || _la==T__68) {
				{
				setState(712);
				((EDataTypeContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(717);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(715);
				match(T__5);
				setState(716);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(725);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				setState(719);
				match(T__1);
				setState(722);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(720);
					((EDataTypeContext)_localctx).s58 = match(T__57);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s58);
					}
					break;
				case T__58:
					{
					setState(721);
					((EDataTypeContext)_localctx).s59 = match(T__58);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s59);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(724);
				match(T__3);
				}
				break;
			}

			        DataType t = Document.getInstance().create(_localctx);
			        Document.getInstance().ownershipStack.push(t);
			    
			setState(738);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(728);
				match(T__1);
				setState(733);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__71 - 67)) | (1L << (T__72 - 67)))) != 0)) {
					{
					setState(731);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(729);
						((EDataTypeContext)_localctx).eAnnotation = eAnnotation();
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						}
						break;
					case T__71:
					case T__72:
						{
						setState(730);
						((EDataTypeContext)_localctx).invariant = invariant();
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(735);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(736);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(737);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        notifyErrorListeners(Document.getInstance().ownershipStack.peek().getToken(), "DataType detected: '" + Document.getInstance().ownershipStack.peek().qualifiedName + "'", (RecognitionException)null);
			        Document.getInstance().ownershipStack.pop();
			    
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
			setState(742);
			_la = _input.LA(1);
			if ( !(((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & ((1L << (T__59 - 60)) | (1L << (T__60 - 60)) | (1L << (T__61 - 60)) | (1L << (T__62 - 60)) | (1L << (T__63 - 60)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public Token instanceClassName;
		public Token s58;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s59;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public EEnumLiteralContext eEnumLiteral;
		public List<EEnumLiteralContext> ownedLiteral = new ArrayList<EEnumLiteralContext>();
		public InvariantContext invariant;
		public List<InvariantContext> ownedConstraint = new ArrayList<InvariantContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
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
			setState(745);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(744);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(747);
			match(T__64);
			setState(748);
			((EEnumContext)_localctx).name = unrestrictedName();
			setState(750);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14 || _la==T__68) {
				{
				setState(749);
				((EEnumContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(754);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(752);
				match(T__5);
				setState(753);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(762);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				{
				setState(756);
				match(T__1);
				setState(759);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(757);
					((EEnumContext)_localctx).s58 = match(T__57);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s58);
					}
					break;
				case T__58:
					{
					setState(758);
					((EEnumContext)_localctx).s59 = match(T__58);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s59);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(761);
				match(T__3);
				}
				break;
			}

			        Enum e = Document.getInstance().create(_localctx);
			        Document.getInstance().ownershipStack.push(e);
			    
			setState(776);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(765);
				match(T__1);
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__70 - 17)) | (1L << (T__71 - 17)) | (1L << (T__72 - 17)) | (1L << (T__73 - 17)) | (1L << (T__75 - 17)) | (1L << (T__77 - 17)) | (1L << (T__78 - 17)))) != 0) || _la==T__130 || _la==IDENTIFIER) {
					{
					setState(769);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
					case 1:
						{
						setState(766);
						((EEnumContext)_localctx).eAnnotation = eAnnotation();
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						}
						break;
					case 2:
						{
						setState(767);
						((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral();
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						}
						break;
					case 3:
						{
						setState(768);
						((EEnumContext)_localctx).invariant = invariant();
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(773);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(774);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(775);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        notifyErrorListeners(Document.getInstance().ownershipStack.peek().getToken(), "Enum detected: '" + Document.getInstance().ownershipStack.peek().qualifiedName + "'", (RecognitionException)null);
			        Document.getInstance().ownershipStack.pop();
			    
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
		public UnrestrictedNameContext name;
		public SignedContext value;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
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
			setState(783);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				{
				{
				setState(780);
				match(T__65);
				setState(781);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(782);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			setState(787);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(785);
				match(T__20);
				setState(786);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}

			setState(798);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(789);
				match(T__1);
				setState(793);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(790);
					((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation();
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(795);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(796);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(797);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        EnumLiteral e = Document.getInstance().create(_localctx);
			        notifyErrorListeners((((EEnumLiteralContext)_localctx).name!=null?(((EEnumLiteralContext)_localctx).name.start):null), "EnumLiteral detected: '" + e.qualifiedName + "'", (RecognitionException)null);
			    
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
			setState(802);
			match(T__66);
			setState(804);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(803);
				((EAnnotationContext)_localctx).name = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(806);
				match(T__14);
				setState(807);
				((EAnnotationContext)_localctx).eDetail = eDetail();
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(812);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(808);
					match(T__2);
					setState(809);
					((EAnnotationContext)_localctx).eDetail = eDetail();
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(814);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(815);
				match(T__15);
				}
			}

			setState(830);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(819);
				match(T__1);
				setState(823); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(823);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
					case 1:
						{
						setState(820);
						((EAnnotationContext)_localctx).eAnnotation = eAnnotation();
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						}
						break;
					case 2:
						{
						setState(821);
						((EAnnotationContext)_localctx).eModelElement = eModelElement();
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						}
						break;
					case 3:
						{
						setState(822);
						((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef();
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						}
						break;
					}
					}
					setState(825); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__26 - 17)) | (1L << (T__27 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__30 - 17)) | (1L << (T__31 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__70 - 17)) | (1L << (T__71 - 17)) | (1L << (T__72 - 17)) | (1L << (T__73 - 17)) | (1L << (T__75 - 17)) | (1L << (T__77 - 17)) | (1L << (T__78 - 17)) | (1L << (T__79 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__130 - 81)) | (1L << (IDENTIFIER - 81)))) != 0) );
				setState(827);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(829);
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
			setState(832);
			((EDetailContext)_localctx).name = match(SINGLE_QUOTED_STRING);
			setState(833);
			match(T__20);
			setState(834);
			((EDetailContext)_localctx).value = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) ) {
				((EDetailContext)_localctx).value = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
			setState(838);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(836);
				eAnnotation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(837);
				eNamedElement();
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
			setState(844);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(840);
				eTypedElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(841);
				eClassifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(842);
				ePackage();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(843);
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
			setState(849);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(846);
				eOperation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(847);
				eParameter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(848);
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
			setState(851);
			match(T__67);
			setState(852);
			((EModelElementRefContext)_localctx).ownedPathName = qualifiedName();
			setState(853);
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
			setState(877);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(855);
				match(T__14);
				setState(856);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(861);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(857);
					match(T__2);
					setState(858);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(863);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(864);
				match(T__15);
				}
				}
				break;
			case T__68:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(866);
				match(T__68);
				setState(867);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(872);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(868);
					match(T__2);
					setState(869);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(874);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(875);
				match(T__69);
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
			setState(879);
			match(T__70);
			setState(881);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(880);
				((BodyContext)_localctx).name = identifier();
				}
			}

			setState(889);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(883);
				match(T__5);
				setState(885);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
				case 1:
					{
					setState(884);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(887);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(888);
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
			setState(892);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__71) {
				{
				setState(891);
				((InvariantContext)_localctx).isCallable = match(T__71);
				}
			}

			setState(894);
			match(T__72);
			setState(901);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(895);
				((InvariantContext)_localctx).name = identifier();
				setState(899);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(896);
					match(T__14);
					setState(897);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(898);
					match(T__15);
					}
				}

				}
			}

			setState(909);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(903);
				match(T__5);
				setState(905);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
				case 1:
					{
					setState(904);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(907);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(908);
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
			setState(911);
			_la = _input.LA(1);
			if ( !(_la==T__73 || _la==T__74) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(918);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(912);
				((PreconditionContext)_localctx).name = identifier();
				setState(916);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(913);
					match(T__14);
					setState(914);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(915);
					match(T__15);
					}
				}

				}
			}

			setState(926);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(920);
				match(T__5);
				setState(922);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
				case 1:
					{
					setState(921);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(924);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(925);
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
			setState(928);
			_la = _input.LA(1);
			if ( !(_la==T__75 || _la==T__76) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(935);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(929);
				((PostconditionContext)_localctx).name = identifier();
				setState(933);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(930);
					match(T__14);
					setState(931);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(932);
					match(T__15);
					}
				}

				}
			}

			setState(943);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(937);
				match(T__5);
				setState(939);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
				case 1:
					{
					setState(938);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(941);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(942);
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

	public static class InitialContext extends ParserRuleContext {
		public IdentifierContext name;
		public ExpressionContext ownedExpression;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInitial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInitial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInitial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialContext initial() throws RecognitionException {
		InitialContext _localctx = new InitialContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_initial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(945);
			match(T__77);
			setState(947);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(946);
				((InitialContext)_localctx).name = identifier();
				}
			}

			setState(955);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(949);
				match(T__5);
				setState(951);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
				case 1:
					{
					setState(950);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(953);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(954);
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

	public static class DerivationContext extends ParserRuleContext {
		public IdentifierContext name;
		public ExpressionContext ownedExpression;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DerivationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derivation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDerivation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDerivation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDerivation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DerivationContext derivation() throws RecognitionException {
		DerivationContext _localctx = new DerivationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_derivation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(957);
			match(T__78);
			setState(959);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(958);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			setState(967);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(961);
				match(T__5);
				setState(963);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
				case 1:
					{
					setState(962);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(965);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(966);
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
		enterRule(_localctx, 74, RULE_visibilityKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
		enterRule(_localctx, 76, RULE_atom);
		try {
			setState(974);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(971);
				((AtomContext)_localctx).id = match(IDENTIFIER);

				    if (context != null && !context.isEmpty() && !context.equals("universe")) {
				        //System.out.print("atom found: " + (((AtomContext)_localctx).id!=null?((AtomContext)_localctx).id.getText():null) + "-> ");
				        if ( atoms.contains((((AtomContext)_localctx).id!=null?((AtomContext)_localctx).id.getText():null)) ) {
				            //System.out.println("defined");
				        } else {
				            notifyErrorListeners(_localctx.getStart(), "undefined atom found: '" + (((AtomContext)_localctx).id!=null?((AtomContext)_localctx).id.getText():null) + "'", (RecognitionException)null);
				        }
				    }

				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(973);
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
		enterRule(_localctx, 78, RULE_arity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(976);
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
		public int var = 0;;
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
		public IntexpressionContext ileft;
		public Token not;
		public IntexpressionContext iright;
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
		public FormulaContext fleft;
		public Token op;
		public FormulaContext fright;
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
		public IntexpressionContext ileft;
		public Token not;
		public IntexpressionContext iright;
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
		public IntexpressionContext ileft;
		public Token not;
		public IntexpressionContext iright;
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
		public FormulaContext fleft;
		public Token op;
		public FormulaContext fright;
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
		public FormulaContext fleft;
		public Token op;
		public FormulaContext fright;
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
		public IntexpressionContext ileft;
		public Token not;
		public IntexpressionContext iright;
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
		public IntexpressionContext ileft;
		public Token not;
		public IntexpressionContext iright;
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
		public FormulaContext fleft;
		public Token op;
		public FormulaContext fright;
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
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(979);
				match(T__82);
				setState(980);
				expression(0);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(981);
				match(T__83);
				setState(982);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(983);
				match(T__84);
				setState(984);
				expression(0);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(985);
				match(T__85);
				setState(986);
				expression(0);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(987);
				((InContext)_localctx).left = expression(0);
				setState(989);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(988);
					((InContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__86 || _la==T__87) ) {
						((InContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(991);
				match(T__88);
				setState(992);
				((InContext)_localctx).right = expression(0);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(994);
				((EqualContext)_localctx).left = expression(0);
				setState(996);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(995);
					((EqualContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__86 || _la==T__87) ) {
						((EqualContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(998);
				match(T__20);
				setState(999);
				((EqualContext)_localctx).right = expression(0);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1001);
				((EqContext)_localctx).ileft = intexpression(0);
				setState(1003);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1002);
					((EqContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__86 || _la==T__87) ) {
						((EqContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1005);
				match(T__20);
				setState(1006);
				((EqContext)_localctx).iright = intexpression(0);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1008);
				((LtContext)_localctx).ileft = intexpression(0);
				setState(1010);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1009);
					((LtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__86 || _la==T__87) ) {
						((LtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1012);
				match(T__68);
				setState(1013);
				((LtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1015);
				((LteContext)_localctx).ileft = intexpression(0);
				setState(1017);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1016);
					((LteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__86 || _la==T__87) ) {
						((LteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1019);
				match(T__89);
				setState(1020);
				((LteContext)_localctx).iright = intexpression(0);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1022);
				((GtContext)_localctx).ileft = intexpression(0);
				setState(1024);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1023);
					((GtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__86 || _la==T__87) ) {
						((GtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1026);
				match(T__69);
				setState(1027);
				((GtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1029);
				((GteContext)_localctx).ileft = intexpression(0);
				setState(1031);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1030);
					((GteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__86 || _la==T__87) ) {
						((GteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1033);
				match(T__90);
				setState(1034);
				((GteContext)_localctx).iright = intexpression(0);
				}
				break;
			case 12:
				{
				_localctx = new SumDeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(40)).var =  0;
				{
				setState(1037);
				match(T__91);
				setState(1038);
				decls();
				setState(1039);
				match(T__92);
				setState(1040);
				intexpression(0);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(40)).var; i++) declarations.pop();
				}
				break;
			case 13:
				{
				_localctx = new AcyclicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1044);
				match(T__93);
				setState(1045);
				match(T__10);
				setState(1046);
				relationId();
				setState(1047);
				match(T__11);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1049);
				match(T__94);
				setState(1050);
				match(T__10);
				setState(1051);
				((FunctionContext)_localctx).rel = relationId();
				setState(1052);
				match(T__5);
				setState(1053);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1054);
				match(T__95);
				setState(1055);
				((FunctionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__83 || _la==T__84) ) {
					((FunctionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1056);
				((FunctionContext)_localctx).range = expression(0);
				setState(1057);
				match(T__11);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1059);
				match(T__96);
				setState(1060);
				match(T__10);
				setState(1061);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1062);
				match(T__2);
				setState(1063);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1064);
				match(T__2);
				setState(1065);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1066);
				match(T__2);
				setState(1067);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1068);
				match(T__11);
				}
				break;
			case 16:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1070);
				((NotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__86 || _la==T__87) ) {
					((NotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1071);
				formula(14);
				}
				break;
			case 17:
				{
				_localctx = new ForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(40)).var =  0;
				{
				setState(1073);
				match(T__105);
				setState(1074);
				decls();
				setState(1095);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1075);
					match(T__92);
					setState(1085);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
					case 1:
						{
						setState(1076);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1077);
						match(T__1);
						setState(1081);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1078);
								formula(0);
								}
								} 
							}
							setState(1083);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
						}
						setState(1084);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1087);
					match(T__1);
					setState(1091);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,173,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1088);
							formula(0);
							}
							} 
						}
						setState(1093);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,173,_ctx);
					}
					setState(1094);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(40)).var; i++) declarations.pop();
				}
				break;
			case 18:
				{
				_localctx = new ForSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(40)).var =  0;
				{
				setState(1100);
				match(T__85);
				setState(1101);
				decls();
				setState(1122);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1102);
					match(T__92);
					setState(1112);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
					case 1:
						{
						setState(1103);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1104);
						match(T__1);
						setState(1108);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1105);
								formula(0);
								}
								} 
							}
							setState(1110);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
						}
						setState(1111);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1114);
					match(T__1);
					setState(1118);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1115);
							formula(0);
							}
							} 
						}
						setState(1120);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
					}
					setState(1121);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(40)).var; i++) declarations.pop();
				}
				break;
			case 19:
				{
				_localctx = new ForNoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(40)).var =  0;
				{
				setState(1127);
				match(T__82);
				setState(1128);
				decls();
				setState(1149);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1129);
					match(T__92);
					setState(1139);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
					case 1:
						{
						setState(1130);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1131);
						match(T__1);
						setState(1135);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1132);
								formula(0);
								}
								} 
							}
							setState(1137);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
						}
						setState(1138);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1141);
					match(T__1);
					setState(1145);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1142);
							formula(0);
							}
							} 
						}
						setState(1147);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
					}
					setState(1148);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(40)).var; i++) declarations.pop();
				}
				break;
			case 20:
				{
				_localctx = new ForOneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(40)).var =  0;
				{
				setState(1154);
				match(T__84);
				setState(1155);
				decls();
				setState(1176);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1156);
					match(T__92);
					setState(1166);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
					case 1:
						{
						setState(1157);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1158);
						match(T__1);
						setState(1162);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1159);
								formula(0);
								}
								} 
							}
							setState(1164);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
						}
						setState(1165);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1168);
					match(T__1);
					setState(1172);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1169);
							formula(0);
							}
							} 
						}
						setState(1174);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
					}
					setState(1175);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(40)).var; i++) declarations.pop();
				}
				break;
			case 21:
				{
				_localctx = new ForLoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(40)).var =  0;
				{
				setState(1181);
				match(T__83);
				setState(1182);
				decls();
				setState(1203);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1183);
					match(T__92);
					setState(1193);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
					case 1:
						{
						setState(1184);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1185);
						match(T__1);
						setState(1189);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1186);
								formula(0);
								}
								} 
							}
							setState(1191);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
						}
						setState(1192);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1195);
					match(T__1);
					setState(1199);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1196);
							formula(0);
							}
							} 
						}
						setState(1201);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
					}
					setState(1202);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(40)).var; i++) declarations.pop();
				}
				break;
			case 22:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(40)).var =  0;
				{
				setState(1208);
				match(T__106);
				setState(1209);
				letDecls();
				setState(1230);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1210);
					match(T__92);
					setState(1220);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
					case 1:
						{
						setState(1211);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1212);
						match(T__1);
						setState(1216);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1213);
								formula(0);
								}
								} 
							}
							setState(1218);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
						}
						setState(1219);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1222);
					match(T__1);
					setState(1226);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1223);
							formula(0);
							}
							} 
						}
						setState(1228);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
					}
					setState(1229);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(40)).var; i++) declarations.pop();
				}
				break;
			case 23:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1234);
				match(T__107);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1235);
				match(T__108);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1236);
				match(T__14);
				setState(1237);
				formula(0);
				setState(1238);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1254);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1242);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1243);
						((AndContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__97 || _la==T__98) ) {
							((AndContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1244);
						((AndContext)_localctx).fright = formula(13);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1245);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1246);
						((OrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__99 || _la==T__100) ) {
							((OrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1247);
						((OrContext)_localctx).fright = formula(12);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1248);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1249);
						((ImpliesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__101 || _la==T__102) ) {
							((ImpliesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1250);
						((ImpliesContext)_localctx).fright = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1251);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1252);
						((IffContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__103 || _la==T__104) ) {
							((IffContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1253);
						((IffContext)_localctx).fright = formula(10);
						}
						break;
					}
					} 
				}
				setState(1258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
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
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1260);
				match(T__109);
				setState(1261);
				expression(19);
				}
				break;
			case 2:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1262);
				match(T__110);
				setState(1263);
				expression(18);
				}
				break;
			case 3:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1264);
				match(T__50);
				setState(1265);
				expression(17);
				}
				break;
			case 4:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(40)).var =  0;
				{
				setState(1267);
				match(T__1);
				setState(1268);
				comprehensionDecls();
				setState(1269);
				match(T__92);
				setState(1270);
				formula(0);
				setState(1271);
				match(T__3);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(40)).var; i++) declarations.pop();
				}
				break;
			case 5:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1275);
				((IfExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__101 || _la==T__102) ) {
					((IfExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1276);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1277);
				match(T__116);
				setState(1278);
				((IfExpressionContext)_localctx).thenExpr = expression(0);
				setState(1279);
				match(T__117);
				setState(1280);
				((IfExpressionContext)_localctx).elseExpr = expression(8);
				}
				break;
			case 6:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1282);
				match(T__118);
				}
				break;
			case 7:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1283);
				match(T__119);
				}
				break;
			case 8:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1284);
				match(T__120);
				}
				break;
			case 9:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1285);
				match(T__121);
				}
				break;
			case 10:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1286);
				match(T__14);
				setState(1287);
				expression(0);
				setState(1288);
				match(T__15);
				}
				break;
			case 11:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1290);
				if (!(!isRelation())) throw new FailedPredicateException(this, "!isRelation()");
				setState(1291);
				((VarContext)_localctx).variableId = variableId();

				        //System.out.print("variable found: " + (((VarContext)_localctx).variableId!=null?_input.getText(((VarContext)_localctx).variableId.start,((VarContext)_localctx).variableId.stop):null) + "-> ");
				        String s = (((VarContext)_localctx).variableId!=null?_input.getText(((VarContext)_localctx).variableId.start,((VarContext)_localctx).variableId.stop):null);
				        if ( declarations.contains(s) ) {
				            //System.out.println("defined");
				        } else {
				            notifyErrorListeners(_localctx.getStart(), "undefined variable found: '"+ s + "'", (RecognitionException)null);
				        }
				      
				}
				break;
			case 12:
				{
				_localctx = new RelContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1294);
				if (!(isRelation())) throw new FailedPredicateException(this, "isRelation()");
				setState(1295);
				relationId();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1329);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1327);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1298);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1299);
						match(T__51);
						setState(1300);
						((UnionContext)_localctx).right = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1301);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1302);
						match(T__111);
						setState(1303);
						((IntersectionContext)_localctx).right = expression(16);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1304);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1305);
						match(T__112);
						setState(1306);
						((DifferenceContext)_localctx).right = expression(15);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1307);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1308);
						match(T__113);
						setState(1309);
						((JoinContext)_localctx).right = expression(14);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1310);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1312);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (T__83 - 84)) | (1L << (T__84 - 84)) | (1L << (T__85 - 84)) | (1L << (T__114 - 84)))) != 0)) {
							{
							setState(1311);
							((ProductContext)_localctx).leftMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (T__83 - 84)) | (1L << (T__84 - 84)) | (1L << (T__85 - 84)) | (1L << (T__114 - 84)))) != 0)) ) {
								((ProductContext)_localctx).leftMult = (Token)_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
						}

						setState(1314);
						match(T__95);
						setState(1316);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
						case 1:
							{
							setState(1315);
							((ProductContext)_localctx).rightMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (T__83 - 84)) | (1L << (T__84 - 84)) | (1L << (T__85 - 84)) | (1L << (T__114 - 84)))) != 0)) ) {
								((ProductContext)_localctx).rightMult = (Token)_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
							break;
						}
						setState(1318);
						((ProductContext)_localctx).right = expression(11);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1319);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1320);
						match(T__115);
						setState(1321);
						((OverrideContext)_localctx).right = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BoxjoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxjoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1322);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1323);
						match(T__10);
						setState(1324);
						((BoxjoinContext)_localctx).left = expression(0);
						setState(1325);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(1331);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
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
		public IntexpressionContext ileft;
		public IntexpressionContext iright;
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
		public IntexpressionContext ileft;
		public IntexpressionContext iright;
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
		public IntexpressionContext ileft;
		public IntexpressionContext iright;
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
		public IntexpressionContext ileft;
		public IntexpressionContext iright;
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
		public IntexpressionContext ileft;
		public IntexpressionContext iright;
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
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_intexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__101:
			case T__102:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1333);
				((IfIntExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__101 || _la==T__102) ) {
					((IfIntExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1334);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1335);
				match(T__116);
				setState(1336);
				((IfIntExpressionContext)_localctx).thenExpr = intexpression(0);
				setState(1337);
				match(T__117);
				setState(1338);
				((IfIntExpressionContext)_localctx).elseExpr = intexpression(10);
				}
				break;
			case T__91:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1340);
				match(T__91);
				setState(1341);
				expression(0);
				}
				break;
			case T__43:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1342);
				match(T__43);
				setState(1343);
				expression(0);
				}
				break;
			case T__112:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__112) {
					{
					setState(1344);
					((IntConstantContext)_localctx).sign = match(T__112);
					}
				}

				setState(1347);
				integer();
				}
				break;
			case T__14:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1348);
				match(T__14);
				setState(1349);
				intexpression(0);
				setState(1350);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1371);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1369);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntexpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1354);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1355);
						_la = _input.LA(1);
						if ( !(_la==T__51 || _la==T__122) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1356);
						((PlusContext)_localctx).iright = intexpression(8);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntexpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1357);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1358);
						_la = _input.LA(1);
						if ( !(_la==T__112 || _la==T__123) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1359);
						((MinusContext)_localctx).iright = intexpression(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntexpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1360);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1361);
						_la = _input.LA(1);
						if ( !(_la==T__50 || _la==T__124) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1362);
						((MultiplyContext)_localctx).iright = intexpression(6);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntexpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1363);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1364);
						_la = _input.LA(1);
						if ( !(_la==T__125 || _la==T__126) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1365);
						((DivideContext)_localctx).iright = intexpression(5);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntexpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1366);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1367);
						_la = _input.LA(1);
						if ( !(_la==T__127 || _la==T__128) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1368);
						((ModuloContext)_localctx).iright = intexpression(4);
						}
						break;
					}
					} 
				}
				setState(1373);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
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
		enterRule(_localctx, 86, RULE_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1374);
			decl();
			setState(1379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1375);
				match(T__2);
				setState(1376);
				decl();
				}
				}
				setState(1381);
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
		enterRule(_localctx, 88, RULE_decl);
		int _la;
		try {
			setState(1448);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__129) {
					{
					setState(1382);
					((OneOfContext)_localctx).disj = match(T__129);
					}
				}

				setState(1385);
				((OneOfContext)_localctx).variableId = variableId();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
				setState(1390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1386);
					match(T__2);
					setState(1387);
					((OneOfContext)_localctx).variableId = variableId();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
					}
					}
					setState(1392);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1393);
				match(T__5);
				setState(1395);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
				case 1:
					{
					setState(1394);
					match(T__84);
					}
					break;
				}
				setState(1397);
				expression(0);
				((FormulaContext)getInvokingContext(40)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(40)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1401);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__129) {
					{
					setState(1400);
					((LoneOfContext)_localctx).disj = match(T__129);
					}
				}

				setState(1403);
				((LoneOfContext)_localctx).variableId = variableId();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
				setState(1408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1404);
					match(T__2);
					setState(1405);
					((LoneOfContext)_localctx).variableId = variableId();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
					}
					}
					setState(1410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1411);
				match(T__5);
				setState(1412);
				match(T__83);
				setState(1413);
				expression(0);
				((FormulaContext)getInvokingContext(40)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(40)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__129) {
					{
					setState(1416);
					((SomeOfContext)_localctx).disj = match(T__129);
					}
				}

				setState(1419);
				((SomeOfContext)_localctx).variableId = variableId();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
				setState(1424);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1420);
					match(T__2);
					setState(1421);
					((SomeOfContext)_localctx).variableId = variableId();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
					}
					}
					setState(1426);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1427);
				match(T__5);
				setState(1428);
				match(T__85);
				setState(1429);
				expression(0);
				((FormulaContext)getInvokingContext(40)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(40)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__129) {
					{
					setState(1432);
					((SetOfContext)_localctx).disj = match(T__129);
					}
				}

				setState(1435);
				((SetOfContext)_localctx).variableId = variableId();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
				setState(1440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1436);
					match(T__2);
					setState(1437);
					((SetOfContext)_localctx).variableId = variableId();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
					}
					}
					setState(1442);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1443);
				match(T__5);
				setState(1444);
				match(T__114);
				setState(1445);
				expression(0);
				((FormulaContext)getInvokingContext(40)).var =  declareVariables(((SetOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(40)).var);
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
		enterRule(_localctx, 90, RULE_letDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1450);
			letDecl();
			setState(1455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1451);
				match(T__2);
				setState(1452);
				letDecl();
				}
				}
				setState(1457);
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
		enterRule(_localctx, 92, RULE_letDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1458);
			((LetDeclContext)_localctx).variableId = variableId();
			((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
			setState(1463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1459);
				match(T__2);
				setState(1460);
				((LetDeclContext)_localctx).variableId = variableId();
				((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
				}
				}
				setState(1465);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1466);
			match(T__20);
			setState(1467);
			expression(0);
			}
			((FormulaContext)getInvokingContext(40)).var =  declareVariables(((LetDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(40)).var);
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
		enterRule(_localctx, 94, RULE_comprehensionDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1471);
			comprehensionDecl();
			setState(1476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1472);
				match(T__2);
				setState(1473);
				comprehensionDecl();
				}
				}
				setState(1478);
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
		enterRule(_localctx, 96, RULE_comprehensionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__129) {
				{
				setState(1479);
				((ComprehensionDeclContext)_localctx).disj = match(T__129);
				}
			}

			{
			setState(1482);
			((ComprehensionDeclContext)_localctx).variableId = variableId();
			((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
			setState(1487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1483);
				match(T__2);
				setState(1484);
				((ComprehensionDeclContext)_localctx).variableId = variableId();
				((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
				}
				}
				setState(1489);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1490);
			match(T__5);
			setState(1492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				{
				setState(1491);
				match(T__84);
				}
				break;
			}
			setState(1494);
			expression(0);
			}
			((FormulaContext)getInvokingContext(40)).var =  declareVariables(((ComprehensionDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(40)).var);
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
		enterRule(_localctx, 98, RULE_relationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1498);
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
		enterRule(_localctx, 100, RULE_variableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1500);
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
		enterRule(_localctx, 102, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1502);
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

	public static class UnrestrictedNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UnrestrictedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unrestrictedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterUnrestrictedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitUnrestrictedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUnrestrictedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnrestrictedNameContext unrestrictedName() throws RecognitionException {
		UnrestrictedNameContext _localctx = new UnrestrictedNameContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_unrestrictedName);
		try {
			setState(1543);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1504);
				identifier();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(1505);
				match(T__21);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 3);
				{
				setState(1506);
				match(T__33);
				}
				break;
			case T__70:
				enterOuterAlt(_localctx, 4);
				{
				setState(1507);
				match(T__70);
				}
				break;
			case T__71:
				enterOuterAlt(_localctx, 5);
				{
				setState(1508);
				match(T__71);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 6);
				{
				setState(1509);
				match(T__22);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 7);
				{
				setState(1510);
				match(T__44);
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 8);
				{
				setState(1511);
				match(T__56);
				}
				break;
			case T__130:
				enterOuterAlt(_localctx, 9);
				{
				setState(1512);
				match(T__130);
				}
				break;
			case T__78:
				enterOuterAlt(_localctx, 10);
				{
				setState(1513);
				match(T__78);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 11);
				{
				setState(1514);
				match(T__34);
				}
				break;
			case T__64:
				enterOuterAlt(_localctx, 12);
				{
				setState(1515);
				match(T__64);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 13);
				{
				setState(1516);
				match(T__24);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 14);
				{
				setState(1517);
				match(T__35);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 15);
				{
				setState(1518);
				match(T__17);
				}
				break;
			case T__77:
				enterOuterAlt(_localctx, 16);
				{
				setState(1519);
				match(T__77);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 17);
				{
				setState(1520);
				match(T__23);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 18);
				{
				setState(1521);
				match(T__47);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 19);
				{
				setState(1522);
				match(T__16);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 20);
				{
				setState(1523);
				match(T__48);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 21);
				{
				setState(1524);
				match(T__36);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 22);
				{
				setState(1525);
				match(T__19);
				}
				break;
			case T__75:
				enterOuterAlt(_localctx, 23);
				{
				setState(1526);
				match(T__75);
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 24);
				{
				setState(1527);
				match(T__73);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 25);
				{
				setState(1528);
				match(T__55);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 26);
				{
				setState(1529);
				match(T__42);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 27);
				{
				setState(1530);
				match(T__32);
				}
				break;
			case T__67:
				enterOuterAlt(_localctx, 28);
				{
				setState(1531);
				match(T__67);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 29);
				{
				setState(1532);
				match(T__45);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 30);
				{
				setState(1533);
				match(T__25);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 31);
				{
				setState(1534);
				match(T__49);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 32);
				{
				setState(1535);
				match(T__28);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 33);
				{
				setState(1536);
				match(T__38);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 34);
				{
				setState(1537);
				match(T__40);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 35);
				{
				setState(1538);
				match(T__29);
				}
				break;
			case T__72:
				enterOuterAlt(_localctx, 36);
				{
				setState(1539);
				match(T__72);
				}
				break;
			case T__65:
				enterOuterAlt(_localctx, 37);
				{
				setState(1540);
				match(T__65);
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 38);
				{
				setState(1541);
				match(T__57);
				}
				break;
			case T__66:
				enterOuterAlt(_localctx, 39);
				{
				setState(1542);
				match(T__66);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public IdentifierContext firstPart;
		public IdentifierContext identifier;
		public List<IdentifierContext> midParts = new ArrayList<IdentifierContext>();
		public IdentifierContext classifier;
		public IdentifierContext structuralFeature;
		public IdentifierContext operation;
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
		enterRule(_localctx, 106, RULE_qualifiedName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1545);
			((QualifiedNameContext)_localctx).firstPart = identifier();
			setState(1561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (T__95 - 96)) | (1L << (T__113 - 96)) | (1L << (T__131 - 96)))) != 0)) {
				{
				setState(1550);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1546);
						match(T__113);
						setState(1547);
						((QualifiedNameContext)_localctx).identifier = identifier();
						((QualifiedNameContext)_localctx).midParts.add(((QualifiedNameContext)_localctx).identifier);
						}
						} 
					}
					setState(1552);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
				}
				setState(1559);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__113:
					{
					setState(1553);
					match(T__113);
					setState(1554);
					((QualifiedNameContext)_localctx).classifier = identifier();
					}
					break;
				case T__131:
					{
					setState(1555);
					match(T__131);
					setState(1556);
					((QualifiedNameContext)_localctx).structuralFeature = identifier();
					}
					break;
				case T__95:
					{
					setState(1557);
					match(T__95);
					setState(1558);
					((QualifiedNameContext)_localctx).operation = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
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
		enterRule(_localctx, 108, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1563);
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
		enterRule(_localctx, 110, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1565);
			_la = _input.LA(1);
			if ( !(_la==T__50 || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
		enterRule(_localctx, 112, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1567);
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
		enterRule(_localctx, 114, RULE_signed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1570);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__112) {
				{
				setState(1569);
				match(T__112);
				}
			}

			setState(1572);
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
		case 40:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 41:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 42:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u008e\u0629\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\5\2x\n\2"+
		"\3\2\3\2\3\2\3\2\3\2\7\2\177\n\2\f\2\16\2\u0082\13\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\7\3\u008c\n\3\f\3\16\3\u008f\13\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u009f\n\4\3\5\3\5\3\5\3\5\3\5\7"+
		"\5\u00a6\n\5\f\5\16\5\u00a9\13\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00b1\n\5"+
		"\f\5\16\5\u00b4\13\5\3\5\3\5\5\5\u00b8\n\5\3\5\3\5\3\6\3\6\3\6\7\6\u00bf"+
		"\n\6\f\6\16\6\u00c2\13\6\3\6\3\6\3\6\3\7\3\7\5\7\u00c9\n\7\3\7\3\7\5\7"+
		"\u00cd\n\7\3\7\3\7\3\7\3\7\5\7\u00d3\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\7\b\u00dd\n\b\f\b\16\b\u00e0\13\b\5\b\u00e2\n\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\b\u00e9\n\b\f\b\16\b\u00ec\13\b\5\b\u00ee\n\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00fd\n\b\3\t\3\t\3\t\3\t\7\t\u0103"+
		"\n\t\f\t\16\t\u0106\13\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u010e\n\t\f\t\16"+
		"\t\u0111\13\t\3\t\3\t\5\t\u0115\n\t\3\n\5\n\u0118\n\n\3\n\3\n\5\n\u011c"+
		"\n\n\3\n\7\n\u011f\n\n\f\n\16\n\u0122\13\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\5\13\u012b\n\13\3\13\3\13\3\13\3\f\5\f\u0131\n\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0141\n\f\f\f\16\f\u0144"+
		"\13\f\3\f\3\f\5\f\u0148\n\f\3\f\3\f\3\r\3\r\3\r\5\r\u014f\n\r\3\16\5\16"+
		"\u0152\n\16\3\16\5\16\u0155\n\16\3\16\3\16\5\16\u0159\n\16\3\16\3\16\3"+
		"\16\3\16\3\16\7\16\u0160\n\16\f\16\16\16\u0163\13\16\5\16\u0165\n\16\3"+
		"\16\3\16\5\16\u0169\n\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0171\n\16"+
		"\f\16\16\16\u0174\13\16\3\16\3\16\5\16\u0178\n\16\3\16\3\16\3\17\3\17"+
		"\5\17\u017e\n\17\3\20\5\20\u0181\n\20\3\20\5\20\u0184\n\20\3\20\3\20\5"+
		"\20\u0188\n\20\3\20\5\20\u018b\n\20\3\20\5\20\u018e\n\20\3\20\3\20\5\20"+
		"\u0192\n\20\3\20\5\20\u0195\n\20\3\20\3\20\3\20\3\20\3\20\5\20\u019c\n"+
		"\20\3\20\3\20\5\20\u01a0\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u01ab\n\20\3\20\5\20\u01ae\n\20\6\20\u01b0\n\20\r\20\16\20"+
		"\u01b1\3\20\5\20\u01b5\n\20\3\20\3\20\7\20\u01b9\n\20\f\20\16\20\u01bc"+
		"\13\20\3\20\3\20\5\20\u01c0\n\20\3\20\3\20\5\20\u01c4\n\20\3\20\7\20\u01c7"+
		"\n\20\f\20\16\20\u01ca\13\20\5\20\u01cc\n\20\3\20\3\20\5\20\u01d0\n\20"+
		"\3\20\3\20\3\21\5\21\u01d5\n\21\3\21\5\21\u01d8\n\21\3\21\3\21\5\21\u01dc"+
		"\n\21\3\21\5\21\u01df\n\21\3\21\5\21\u01e2\n\21\3\21\3\21\5\21\u01e6\n"+
		"\21\3\21\5\21\u01e9\n\21\3\21\3\21\3\21\3\21\5\21\u01ef\n\21\3\21\3\21"+
		"\3\21\5\21\u01f4\n\21\3\21\3\21\5\21\u01f8\n\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0205\n\21\3\21\5\21\u0208\n\21"+
		"\6\21\u020a\n\21\r\21\16\21\u020b\3\21\5\21\u020f\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\7\21\u0216\n\21\f\21\16\21\u0219\13\21\3\21\3\21\5\21\u021d"+
		"\n\21\3\21\7\21\u0220\n\21\f\21\16\21\u0223\13\21\3\21\3\21\5\21\u0227"+
		"\n\21\3\21\3\21\5\21\u022b\n\21\3\21\7\21\u022e\n\21\f\21\16\21\u0231"+
		"\13\21\5\21\u0233\n\21\3\21\3\21\5\21\u0237\n\21\3\21\3\21\3\22\5\22\u023c"+
		"\n\22\3\22\5\22\u023f\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0248"+
		"\n\22\f\22\16\22\u024b\13\22\5\22\u024d\n\22\3\22\3\22\3\22\3\22\5\22"+
		"\u0253\n\22\5\22\u0255\n\22\3\22\3\22\3\22\3\22\7\22\u025b\n\22\f\22\16"+
		"\22\u025e\13\22\5\22\u0260\n\22\3\22\3\22\3\22\3\22\3\22\5\22\u0267\n"+
		"\22\3\22\5\22\u026a\n\22\6\22\u026c\n\22\r\22\16\22\u026d\3\22\5\22\u0271"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\7\22\u0278\n\22\f\22\16\22\u027b\13\22"+
		"\3\22\3\22\5\22\u027f\n\22\3\22\3\22\3\23\3\23\5\23\u0285\n\23\3\23\3"+
		"\23\3\23\3\23\5\23\u028b\n\23\5\23\u028d\n\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0294\n\23\3\23\5\23\u0297\n\23\6\23\u0299\n\23\r\23\16\23\u029a"+
		"\3\23\5\23\u029e\n\23\3\23\3\23\7\23\u02a2\n\23\f\23\16\23\u02a5\13\23"+
		"\3\23\5\23\u02a8\n\23\3\23\3\23\3\24\3\24\5\24\u02ae\n\24\3\25\3\25\3"+
		"\25\3\25\5\25\u02b4\n\25\3\25\5\25\u02b7\n\25\3\25\3\25\5\25\u02bb\n\25"+
		"\3\25\3\25\3\26\5\26\u02c0\n\26\3\26\3\26\3\26\5\26\u02c5\n\26\5\26\u02c7"+
		"\n\26\3\26\3\26\3\26\5\26\u02cc\n\26\3\26\3\26\5\26\u02d0\n\26\3\26\3"+
		"\26\3\26\5\26\u02d5\n\26\3\26\5\26\u02d8\n\26\3\26\3\26\3\26\3\26\7\26"+
		"\u02de\n\26\f\26\16\26\u02e1\13\26\3\26\3\26\5\26\u02e5\n\26\3\26\3\26"+
		"\3\27\3\27\3\30\5\30\u02ec\n\30\3\30\3\30\3\30\5\30\u02f1\n\30\3\30\3"+
		"\30\5\30\u02f5\n\30\3\30\3\30\3\30\5\30\u02fa\n\30\3\30\5\30\u02fd\n\30"+
		"\3\30\3\30\3\30\3\30\3\30\7\30\u0304\n\30\f\30\16\30\u0307\13\30\3\30"+
		"\3\30\5\30\u030b\n\30\3\30\3\30\3\31\3\31\3\31\5\31\u0312\n\31\3\31\3"+
		"\31\5\31\u0316\n\31\3\31\3\31\7\31\u031a\n\31\f\31\16\31\u031d\13\31\3"+
		"\31\3\31\5\31\u0321\n\31\3\31\3\31\3\32\3\32\5\32\u0327\n\32\3\32\3\32"+
		"\3\32\3\32\7\32\u032d\n\32\f\32\16\32\u0330\13\32\3\32\3\32\5\32\u0334"+
		"\n\32\3\32\3\32\3\32\3\32\6\32\u033a\n\32\r\32\16\32\u033b\3\32\3\32\3"+
		"\32\5\32\u0341\n\32\3\33\3\33\3\33\3\33\3\34\3\34\5\34\u0349\n\34\3\35"+
		"\3\35\3\35\3\35\5\35\u034f\n\35\3\36\3\36\3\36\5\36\u0354\n\36\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3 \7 \u035e\n \f \16 \u0361\13 \3 \3 \3 \3 \3 "+
		"\3 \7 \u0369\n \f \16 \u036c\13 \3 \3 \5 \u0370\n \3!\3!\5!\u0374\n!\3"+
		"!\3!\5!\u0378\n!\3!\3!\5!\u037c\n!\3\"\5\"\u037f\n\"\3\"\3\"\3\"\3\"\3"+
		"\"\5\"\u0386\n\"\5\"\u0388\n\"\3\"\3\"\5\"\u038c\n\"\3\"\3\"\5\"\u0390"+
		"\n\"\3#\3#\3#\3#\3#\5#\u0397\n#\5#\u0399\n#\3#\3#\5#\u039d\n#\3#\3#\5"+
		"#\u03a1\n#\3$\3$\3$\3$\3$\5$\u03a8\n$\5$\u03aa\n$\3$\3$\5$\u03ae\n$\3"+
		"$\3$\5$\u03b2\n$\3%\3%\5%\u03b6\n%\3%\3%\5%\u03ba\n%\3%\3%\5%\u03be\n"+
		"%\3&\3&\5&\u03c2\n&\3&\3&\5&\u03c6\n&\3&\3&\5&\u03ca\n&\3\'\3\'\3(\3("+
		"\3(\5(\u03d1\n(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u03e0\n*\3*"+
		"\3*\3*\3*\3*\5*\u03e7\n*\3*\3*\3*\3*\3*\5*\u03ee\n*\3*\3*\3*\3*\3*\5*"+
		"\u03f5\n*\3*\3*\3*\3*\3*\5*\u03fc\n*\3*\3*\3*\3*\3*\5*\u0403\n*\3*\3*"+
		"\3*\3*\3*\5*\u040a\n*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\7*\u043a\n*\f*\16*\u043d\13*\3*\5*\u0440\n*\3*\3"+
		"*\7*\u0444\n*\f*\16*\u0447\13*\3*\5*\u044a\n*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\7*\u0455\n*\f*\16*\u0458\13*\3*\5*\u045b\n*\3*\3*\7*\u045f\n*\f*\16"+
		"*\u0462\13*\3*\5*\u0465\n*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u0470\n*\f*\16"+
		"*\u0473\13*\3*\5*\u0476\n*\3*\3*\7*\u047a\n*\f*\16*\u047d\13*\3*\5*\u0480"+
		"\n*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u048b\n*\f*\16*\u048e\13*\3*\5*\u0491"+
		"\n*\3*\3*\7*\u0495\n*\f*\16*\u0498\13*\3*\5*\u049b\n*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\7*\u04a6\n*\f*\16*\u04a9\13*\3*\5*\u04ac\n*\3*\3*\7*\u04b0"+
		"\n*\f*\16*\u04b3\13*\3*\5*\u04b6\n*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u04c1"+
		"\n*\f*\16*\u04c4\13*\3*\5*\u04c7\n*\3*\3*\7*\u04cb\n*\f*\16*\u04ce\13"+
		"*\3*\5*\u04d1\n*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u04db\n*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\7*\u04e9\n*\f*\16*\u04ec\13*\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\5+\u0513\n+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\5+\u0523\n+\3+\3+\5+\u0527\n+\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u0532"+
		"\n+\f+\16+\u0535\13+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0544\n"+
		",\3,\3,\3,\3,\3,\5,\u054b\n,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\7,\u055c\n,\f,\16,\u055f\13,\3-\3-\3-\7-\u0564\n-\f-\16-\u0567\13"+
		"-\3.\5.\u056a\n.\3.\3.\3.\7.\u056f\n.\f.\16.\u0572\13.\3.\3.\5.\u0576"+
		"\n.\3.\3.\3.\3.\5.\u057c\n.\3.\3.\3.\7.\u0581\n.\f.\16.\u0584\13.\3.\3"+
		".\3.\3.\3.\3.\5.\u058c\n.\3.\3.\3.\7.\u0591\n.\f.\16.\u0594\13.\3.\3."+
		"\3.\3.\3.\3.\5.\u059c\n.\3.\3.\3.\7.\u05a1\n.\f.\16.\u05a4\13.\3.\3.\3"+
		".\3.\3.\5.\u05ab\n.\3/\3/\3/\7/\u05b0\n/\f/\16/\u05b3\13/\3\60\3\60\3"+
		"\60\7\60\u05b8\n\60\f\60\16\60\u05bb\13\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\61\3\61\3\61\7\61\u05c5\n\61\f\61\16\61\u05c8\13\61\3\62\5\62\u05cb\n"+
		"\62\3\62\3\62\3\62\7\62\u05d0\n\62\f\62\16\62\u05d3\13\62\3\62\3\62\5"+
		"\62\u05d7\n\62\3\62\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u060a\n\66\3\67"+
		"\3\67\3\67\7\67\u060f\n\67\f\67\16\67\u0612\13\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\5\67\u061a\n\67\5\67\u061c\n\67\38\38\39\39\3:\3:\3;\5;\u0625"+
		"\n;\3;\3;\3;\2\5RTV<\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt\2\25\3\2\65\67\3\2>B\3\2\u008a"+
		"\u008b\3\2LM\3\2NO\3\2RT\3\2YZ\3\2VW\3\2de\3\2fg\3\2hi\3\2jk\4\2VXuu\4"+
		"\2\66\66}}\4\2ss~~\4\2\65\65\177\177\3\2\u0080\u0081\3\2\u0082\u0083\4"+
		"\2\65\65\u0087\u0087\u0758\2w\3\2\2\2\4\u0086\3\2\2\2\6\u009e\3\2\2\2"+
		"\b\u00a0\3\2\2\2\n\u00bb\3\2\2\2\f\u00c6\3\2\2\2\16\u00fc\3\2\2\2\20\u0114"+
		"\3\2\2\2\22\u0117\3\2\2\2\24\u0126\3\2\2\2\26\u0130\3\2\2\2\30\u014e\3"+
		"\2\2\2\32\u0151\3\2\2\2\34\u017d\3\2\2\2\36\u0180\3\2\2\2 \u01d4\3\2\2"+
		"\2\"\u023b\3\2\2\2$\u0284\3\2\2\2&\u02ad\3\2\2\2(\u02af\3\2\2\2*\u02bf"+
		"\3\2\2\2,\u02e8\3\2\2\2.\u02eb\3\2\2\2\60\u0311\3\2\2\2\62\u0324\3\2\2"+
		"\2\64\u0342\3\2\2\2\66\u0348\3\2\2\28\u034e\3\2\2\2:\u0353\3\2\2\2<\u0355"+
		"\3\2\2\2>\u036f\3\2\2\2@\u0371\3\2\2\2B\u037e\3\2\2\2D\u0391\3\2\2\2F"+
		"\u03a2\3\2\2\2H\u03b3\3\2\2\2J\u03bf\3\2\2\2L\u03cb\3\2\2\2N\u03d0\3\2"+
		"\2\2P\u03d2\3\2\2\2R\u04da\3\2\2\2T\u0512\3\2\2\2V\u054a\3\2\2\2X\u0560"+
		"\3\2\2\2Z\u05aa\3\2\2\2\\\u05ac\3\2\2\2^\u05b4\3\2\2\2`\u05c1\3\2\2\2"+
		"b\u05ca\3\2\2\2d\u05dc\3\2\2\2f\u05de\3\2\2\2h\u05e0\3\2\2\2j\u0609\3"+
		"\2\2\2l\u060b\3\2\2\2n\u061d\3\2\2\2p\u061f\3\2\2\2r\u0621\3\2\2\2t\u0624"+
		"\3\2\2\2vx\5\4\3\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\5\b\5\2z{\b\2\1\2{"+
		"|\5\n\6\2|\u0080\b\2\1\2}\177\5R*\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2"+
		"\u0083\u0084\b\2\1\2\u0084\u0085\b\2\1\2\u0085\3\3\2\2\2\u0086\u0087\7"+
		"\3\2\2\u0087\u0088\7\4\2\2\u0088\u008d\5\6\4\2\u0089\u008a\7\5\2\2\u008a"+
		"\u008c\5\6\4\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0091\7\6\2\2\u0091\5\3\2\2\2\u0092\u0093\7\7\2\2\u0093\u0094\7\b\2\2"+
		"\u0094\u009f\5h\65\2\u0095\u0096\7\t\2\2\u0096\u0097\7\b\2\2\u0097\u009f"+
		"\5h\65\2\u0098\u0099\7\n\2\2\u0099\u009a\7\b\2\2\u009a\u009f\5h\65\2\u009b"+
		"\u009c\7\13\2\2\u009c\u009d\7\b\2\2\u009d\u009f\5h\65\2\u009e\u0092\3"+
		"\2\2\2\u009e\u0095\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009b\3\2\2\2\u009f"+
		"\7\3\2\2\2\u00a0\u00b7\7\f\2\2\u00a1\u00a2\7\4\2\2\u00a2\u00a7\5N(\2\u00a3"+
		"\u00a4\7\5\2\2\u00a4\u00a6\5N(\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2"+
		"\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00aa\u00ab\7\6\2\2\u00ab\u00b8\3\2\2\2\u00ac\u00ad\7\r\2\2\u00ad"+
		"\u00b2\5N(\2\u00ae\u00af\7\5\2\2\u00af\u00b1\5N(\2\u00b0\u00ae\3\2\2\2"+
		"\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5"+
		"\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\16\2\2\u00b6\u00b8\3\2\2\2"+
		"\u00b7\u00a1\3\2\2\2\u00b7\u00ac\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba"+
		"\b\5\1\2\u00ba\t\3\2\2\2\u00bb\u00bc\7\17\2\2\u00bc\u00c0\7\4\2\2\u00bd"+
		"\u00bf\5\f\7\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3"+
		"\u00c4\7\6\2\2\u00c4\u00c5\b\6\1\2\u00c5\13\3\2\2\2\u00c6\u00c8\5n8\2"+
		"\u00c7\u00c9\5P)\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00cc\7\b\2\2\u00cb\u00cd\5T+\2\u00cc\u00cb\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\7\r\2\2\u00cf\u00d2\5\16"+
		"\b\2\u00d0\u00d1\7\5\2\2\u00d1\u00d3\5\16\b\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\16\2\2\u00d5\u00d6\3"+
		"\2\2\2\u00d6\u00d7\b\7\1\2\u00d7\r\3\2\2\2\u00d8\u00e1\7\4\2\2\u00d9\u00de"+
		"\5\20\t\2\u00da\u00db\7\5\2\2\u00db\u00dd\5\20\t\2\u00dc\u00da\3\2\2\2"+
		"\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2"+
		"\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00fd\7\6\2\2\u00e4\u00ed\7\r\2\2\u00e5\u00ea\5\20"+
		"\t\2\u00e6\u00e7\7\5\2\2\u00e7\u00e9\5\20\t\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ee\3\2"+
		"\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00e5\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00fd\7\16\2\2\u00f0\u00f1\7\4\2\2\u00f1\u00f2\5"+
		"\20\t\2\u00f2\u00f3\7\20\2\2\u00f3\u00f4\5\20\t\2\u00f4\u00f5\7\6\2\2"+
		"\u00f5\u00fd\3\2\2\2\u00f6\u00f7\7\r\2\2\u00f7\u00f8\5\20\t\2\u00f8\u00f9"+
		"\7\20\2\2\u00f9\u00fa\5\20\t\2\u00fa\u00fb\7\16\2\2\u00fb\u00fd\3\2\2"+
		"\2\u00fc\u00d8\3\2\2\2\u00fc\u00e4\3\2\2\2\u00fc\u00f0\3\2\2\2\u00fc\u00f6"+
		"\3\2\2\2\u00fd\17\3\2\2\2\u00fe\u00ff\7\21\2\2\u00ff\u0104\5N(\2\u0100"+
		"\u0101\7\5\2\2\u0101\u0103\5N(\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2"+
		"\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0107\u0108\7\22\2\2\u0108\u0115\3\2\2\2\u0109\u010a\7\r\2\2"+
		"\u010a\u010f\5N(\2\u010b\u010c\7\5\2\2\u010c\u010e\5N(\2\u010d\u010b\3"+
		"\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7\16\2\2\u0113\u0115\3"+
		"\2\2\2\u0114\u00fe\3\2\2\2\u0114\u0109\3\2\2\2\u0115\21\3\2\2\2\u0116"+
		"\u0118\5\4\3\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011b\3\2"+
		"\2\2\u0119\u011a\7\23\2\2\u011a\u011c\5n8\2\u011b\u0119\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u0120\3\2\2\2\u011d\u011f\5\24\13\2\u011e\u011d\3"+
		"\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0123\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\5\26\f\2\u0124\u0125\b"+
		"\n\1\2\u0125\23\3\2\2\2\u0126\u012a\7\24\2\2\u0127\u0128\5n8\2\u0128\u0129"+
		"\7\b\2\2\u0129\u012b\3\2\2\2\u012a\u0127\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012d\7\u008a\2\2\u012d\u012e\7\25\2\2\u012e\25\3"+
		"\2\2\2\u012f\u0131\5L\'\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0133\7\26\2\2\u0133\u0134\5j\66\2\u0134\u0135\7"+
		"\b\2\2\u0135\u0136\5n8\2\u0136\u0137\3\2\2\2\u0137\u0138\7\27\2\2\u0138"+
		"\u0139\7\u008a\2\2\u0139\u013a\3\2\2\2\u013a\u0147\b\f\1\2\u013b\u0142"+
		"\7\4\2\2\u013c\u0141\5\62\32\2\u013d\u0141\5\26\f\2\u013e\u0141\5\30\r"+
		"\2\u013f\u0141\5B\"\2\u0140\u013c\3\2\2\2\u0140\u013d\3\2\2\2\u0140\u013e"+
		"\3\2\2\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0148\7\6"+
		"\2\2\u0146\u0148\7\25\2\2\u0147\u013b\3\2\2\2\u0147\u0146\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014a\b\f\1\2\u014a\27\3\2\2\2\u014b\u014f\5\32\16"+
		"\2\u014c\u014f\5*\26\2\u014d\u014f\5.\30\2\u014e\u014b\3\2\2\2\u014e\u014c"+
		"\3\2\2\2\u014e\u014d\3\2\2\2\u014f\31\3\2\2\2\u0150\u0152\5L\'\2\u0151"+
		"\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0158\3\2\2\2\u0153\u0155\7\30"+
		"\2\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"\u0159\7\31\2\2\u0157\u0159\7\32\2\2\u0158\u0154\3\2\2\2\u0158\u0157\3"+
		"\2\2\2\u0159\u015a\3\2\2\2\u015a\u0164\5j\66\2\u015b\u015c\7\33\2\2\u015c"+
		"\u0161\5&\24\2\u015d\u015e\7\5\2\2\u015e\u0160\5&\24\2\u015f\u015d\3\2"+
		"\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\u0165\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u015b\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165\u0168\3\2\2\2\u0166\u0167\7\b\2\2\u0167\u0169\7\u008a\2\2\u0168"+
		"\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u0177\b\16"+
		"\1\2\u016b\u0172\7\4\2\2\u016c\u0171\5\62\32\2\u016d\u0171\5\"\22\2\u016e"+
		"\u0171\5\34\17\2\u016f\u0171\5B\"\2\u0170\u016c\3\2\2\2\u0170\u016d\3"+
		"\2\2\2\u0170\u016e\3\2\2\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0175\u0178\7\6\2\2\u0176\u0178\7\25\2\2\u0177\u016b\3\2\2\2\u0177"+
		"\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\b\16\1\2\u017a\33\3\2\2"+
		"\2\u017b\u017e\5\36\20\2\u017c\u017e\5 \21\2\u017d\u017b\3\2\2\2\u017d"+
		"\u017c\3\2\2\2\u017e\35\3\2\2\2\u017f\u0181\5L\'\2\u0180\u017f\3\2\2\2"+
		"\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0184\7\34\2\2\u0183\u0182"+
		"\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0188\7\35\2\2"+
		"\u0186\u0188\7\36\2\2\u0187\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0187\u0188"+
		"\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u018b\7\37\2\2\u018a\u0189\3\2\2\2"+
		"\u018a\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u018e\7 \2\2\u018d\u018c"+
		"\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u0192\7!\2\2\u0190"+
		"\u0192\7\"\2\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2\2\2\u0191\u0192\3\2"+
		"\2\2\u0192\u0194\3\2\2\2\u0193\u0195\7#\2\2\u0194\u0193\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\7$\2\2\u0197\u0198\5j\66"+
		"\2\u0198\u0199\7\b\2\2\u0199\u019b\5&\24\2\u019a\u019c\5(\25\2\u019b\u019a"+
		"\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019e\7\27\2\2"+
		"\u019e\u01a0\7\u008a\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01b4\3\2\2\2\u01a1\u01af\7\4\2\2\u01a2\u01ab\7%\2\2\u01a3\u01ab\7&\2"+
		"\2\u01a4\u01ab\7\'\2\2\u01a5\u01ab\7(\2\2\u01a6\u01ab\7)\2\2\u01a7\u01ab"+
		"\7*\2\2\u01a8\u01ab\7+\2\2\u01a9\u01ab\7,\2\2\u01aa\u01a2\3\2\2\2\u01aa"+
		"\u01a3\3\2\2\2\u01aa\u01a4\3\2\2\2\u01aa\u01a5\3\2\2\2\u01aa\u01a6\3\2"+
		"\2\2\u01aa\u01a7\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2\2\2\u01ab"+
		"\u01ad\3\2\2\2\u01ac\u01ae\7\5\2\2\u01ad\u01ac\3\2\2\2\u01ad\u01ae\3\2"+
		"\2\2\u01ae\u01b0\3\2\2\2\u01af\u01aa\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1"+
		"\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\7\6"+
		"\2\2\u01b4\u01a1\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01cf\3\2\2\2\u01b6"+
		"\u01cb\7\4\2\2\u01b7\u01b9\5\62\32\2\u01b8\u01b7\3\2\2\2\u01b9\u01bc\3"+
		"\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bf\3\2\2\2\u01bc"+
		"\u01ba\3\2\2\2\u01bd\u01c0\5J&\2\u01be\u01c0\5H%\2\u01bf\u01bd\3\2\2\2"+
		"\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01cc\3\2\2\2\u01c1\u01c4"+
		"\5J&\2\u01c2\u01c4\5H%\2\u01c3\u01c1\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c3"+
		"\u01c4\3\2\2\2\u01c4\u01c8\3\2\2\2\u01c5\u01c7\5\62\32\2\u01c6\u01c5\3"+
		"\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01ba\3\2\2\2\u01cb\u01c3\3\2"+
		"\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d0\7\6\2\2\u01ce\u01d0\7\25\2\2\u01cf"+
		"\u01b6\3\2\2\2\u01cf\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\b\20"+
		"\1\2\u01d2\37\3\2\2\2\u01d3\u01d5\5L\'\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5"+
		"\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d8\7\34\2\2\u01d7\u01d6\3\2\2\2"+
		"\u01d7\u01d8\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01dc\7\35\2\2\u01da\u01dc"+
		"\7\36\2\2\u01db\u01d9\3\2\2\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2"+
		"\u01dc\u01de\3\2\2\2\u01dd\u01df\7\37\2\2\u01de\u01dd\3\2\2\2\u01de\u01df"+
		"\3\2\2\2\u01df\u01e1\3\2\2\2\u01e0\u01e2\7 \2\2\u01e1\u01e0\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e6\7!\2\2\u01e4\u01e6\7\""+
		"\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e8\3\2\2\2\u01e7\u01e9\7#\2\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9\3\2"+
		"\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\7-\2\2\u01eb\u01ee\5j\66\2\u01ec"+
		"\u01ed\7.\2\2\u01ed\u01ef\5&\24\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2"+
		"\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\7\b\2\2\u01f1\u01f3\5&\24\2\u01f2"+
		"\u01f4\5(\25\2\u01f3\u01f2\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f7\3\2"+
		"\2\2\u01f5\u01f6\7\27\2\2\u01f6\u01f8\7\u008a\2\2\u01f7\u01f5\3\2\2\2"+
		"\u01f7\u01f8\3\2\2\2\u01f8\u020e\3\2\2\2\u01f9\u0209\7\4\2\2\u01fa\u0205"+
		"\7/\2\2\u01fb\u0205\7%\2\2\u01fc\u0205\7\'\2\2\u01fd\u0205\7(\2\2\u01fe"+
		"\u0205\7)\2\2\u01ff\u0205\7*\2\2\u0200\u0205\7\60\2\2\u0201\u0205\7\61"+
		"\2\2\u0202\u0205\7+\2\2\u0203\u0205\7,\2\2\u0204\u01fa\3\2\2\2\u0204\u01fb"+
		"\3\2\2\2\u0204\u01fc\3\2\2\2\u0204\u01fd\3\2\2\2\u0204\u01fe\3\2\2\2\u0204"+
		"\u01ff\3\2\2\2\u0204\u0200\3\2\2\2\u0204\u0201\3\2\2\2\u0204\u0202\3\2"+
		"\2\2\u0204\u0203\3\2\2\2\u0205\u0207\3\2\2\2\u0206\u0208\7\5\2\2\u0207"+
		"\u0206\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209\u0204\3\2"+
		"\2\2\u020a\u020b\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c"+
		"\u020d\3\2\2\2\u020d\u020f\7\6\2\2\u020e\u01f9\3\2\2\2\u020e\u020f\3\2"+
		"\2\2\u020f\u0236\3\2\2\2\u0210\u021c\7\4\2\2\u0211\u0212\7\62\2\2\u0212"+
		"\u0217\5l\67\2\u0213\u0214\7\5\2\2\u0214\u0216\5l\67\2\u0215\u0213\3\2"+
		"\2\2\u0216\u0219\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218"+
		"\u021a\3\2\2\2\u0219\u0217\3\2\2\2\u021a\u021b\7\25\2\2\u021b\u021d\3"+
		"\2\2\2\u021c\u0211\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0232\3\2\2\2\u021e"+
		"\u0220\5\62\32\2\u021f\u021e\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3"+
		"\2\2\2\u0221\u0222\3\2\2\2\u0222\u0226\3\2\2\2\u0223\u0221\3\2\2\2\u0224"+
		"\u0227\5J&\2\u0225\u0227\5H%\2\u0226\u0224\3\2\2\2\u0226\u0225\3\2\2\2"+
		"\u0226\u0227\3\2\2\2\u0227\u0233\3\2\2\2\u0228\u022b\5J&\2\u0229\u022b"+
		"\5H%\2\u022a\u0228\3\2\2\2\u022a\u0229\3\2\2\2\u022a\u022b\3\2\2\2\u022b"+
		"\u022f\3\2\2\2\u022c\u022e\5\62\32\2\u022d\u022c\3\2\2\2\u022e\u0231\3"+
		"\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0233\3\2\2\2\u0231"+
		"\u022f\3\2\2\2\u0232\u0221\3\2\2\2\u0232\u022a\3\2\2\2\u0233\u0234\3\2"+
		"\2\2\u0234\u0237\7\6\2\2\u0235\u0237\7\25\2\2\u0236\u0210\3\2\2\2\u0236"+
		"\u0235\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u0239\b\21\1\2\u0239!\3\2\2\2"+
		"\u023a\u023c\5L\'\2\u023b\u023a\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023e"+
		"\3\2\2\2\u023d\u023f\7\34\2\2\u023e\u023d\3\2\2\2\u023e\u023f\3\2\2\2"+
		"\u023f\u0240\3\2\2\2\u0240\u0241\7\63\2\2\u0241\u0242\5j\66\2\u0242\u0243"+
		"\b\22\1\2\u0243\u024c\7\21\2\2\u0244\u0249\5$\23\2\u0245\u0246\7\5\2\2"+
		"\u0246\u0248\5$\23\2\u0247\u0245\3\2\2\2\u0248\u024b\3\2\2\2\u0249\u0247"+
		"\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2\2\2\u024c"+
		"\u0244\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0254\7\22"+
		"\2\2\u024f\u0250\7\b\2\2\u0250\u0252\5&\24\2\u0251\u0253\5(\25\2\u0252"+
		"\u0251\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0255\3\2\2\2\u0254\u024f\3\2"+
		"\2\2\u0254\u0255\3\2\2\2\u0255\u025f\3\2\2\2\u0256\u0257\7\64\2\2\u0257"+
		"\u025c\5n8\2\u0258\u0259\7\5\2\2\u0259\u025b\5n8\2\u025a\u0258\3\2\2\2"+
		"\u025b\u025e\3\2\2\2\u025c\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u0260"+
		"\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0256\3\2\2\2\u025f\u0260\3\2\2\2\u0260"+
		"\u0270\3\2\2\2\u0261\u026b\7\4\2\2\u0262\u0267\7\'\2\2\u0263\u0267\7("+
		"\2\2\u0264\u0267\7)\2\2\u0265\u0267\7*\2\2\u0266\u0262\3\2\2\2\u0266\u0263"+
		"\3\2\2\2\u0266\u0264\3\2\2\2\u0266\u0265\3\2\2\2\u0267\u0269\3\2\2\2\u0268"+
		"\u026a\7\5\2\2\u0269\u0268\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026c\3\2"+
		"\2\2\u026b\u0266\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026b\3\2\2\2\u026d"+
		"\u026e\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\7\6\2\2\u0270\u0261\3\2"+
		"\2\2\u0270\u0271\3\2\2\2\u0271\u027e\3\2\2\2\u0272\u0279\7\4\2\2\u0273"+
		"\u0278\5\62\32\2\u0274\u0278\5D#\2\u0275\u0278\5@!\2\u0276\u0278\5F$\2"+
		"\u0277\u0273\3\2\2\2\u0277\u0274\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0276"+
		"\3\2\2\2\u0278\u027b\3\2\2\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a"+
		"\u027c\3\2\2\2\u027b\u0279\3\2\2\2\u027c\u027f\7\6\2\2\u027d\u027f\7\25"+
		"\2\2\u027e\u0272\3\2\2\2\u027e\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280"+
		"\u0281\b\22\1\2\u0281#\3\2\2\2\u0282\u0285\7!\2\2\u0283\u0285\7\"\2\2"+
		"\u0284\u0282\3\2\2\2\u0284\u0283\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286"+
		"\3\2\2\2\u0286\u028c\5j\66\2\u0287\u0288\7\b\2\2\u0288\u028a\5&\24\2\u0289"+
		"\u028b\5(\25\2\u028a\u0289\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028d\3\2"+
		"\2\2\u028c\u0287\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u029d\3\2\2\2\u028e"+
		"\u0298\7\4\2\2\u028f\u0294\7\'\2\2\u0290\u0294\7(\2\2\u0291\u0294\7)\2"+
		"\2\u0292\u0294\7*\2\2\u0293\u028f\3\2\2\2\u0293\u0290\3\2\2\2\u0293\u0291"+
		"\3\2\2\2\u0293\u0292\3\2\2\2\u0294\u0296\3\2\2\2\u0295\u0297\7\5\2\2\u0296"+
		"\u0295\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0299\3\2\2\2\u0298\u0293\3\2"+
		"\2\2\u0299\u029a\3\2\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b"+
		"\u029c\3\2\2\2\u029c\u029e\7\6\2\2\u029d\u028e\3\2\2\2\u029d\u029e\3\2"+
		"\2\2\u029e\u02a7\3\2\2\2\u029f\u02a3\7\4\2\2\u02a0\u02a2\5\62\32\2\u02a1"+
		"\u02a0\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a3\u02a4\3\2"+
		"\2\2\u02a4\u02a6\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a6\u02a8\7\6\2\2\u02a7"+
		"\u029f\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02aa\b\23"+
		"\1\2\u02aa%\3\2\2\2\u02ab\u02ae\5,\27\2\u02ac\u02ae\5l\67\2\u02ad\u02ab"+
		"\3\2\2\2\u02ad\u02ac\3\2\2\2\u02ae\'\3\2\2\2\u02af\u02b6\7\r\2\2\u02b0"+
		"\u02b3\5r:\2\u02b1\u02b2\7\20\2\2\u02b2\u02b4\5p9\2\u02b3\u02b1\3\2\2"+
		"\2\u02b3\u02b4\3\2\2\2\u02b4\u02b7\3\2\2\2\u02b5\u02b7\t\2\2\2\u02b6\u02b0"+
		"\3\2\2\2\u02b6\u02b5\3\2\2\2\u02b7\u02ba\3\2\2\2\u02b8\u02bb\78\2\2\u02b9"+
		"\u02bb\79\2\2\u02ba\u02b8\3\2\2\2\u02ba\u02b9\3\2\2\2\u02ba\u02bb\3\2"+
		"\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\7\16\2\2\u02bd)\3\2\2\2\u02be\u02c0"+
		"\5L\'\2\u02bf\u02be\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c6\3\2\2\2\u02c1"+
		"\u02c7\7:\2\2\u02c2\u02c5\7!\2\2\u02c3\u02c5\7\"\2\2\u02c4\u02c2\3\2\2"+
		"\2\u02c4\u02c3\3\2\2\2\u02c5\u02c7\3\2\2\2\u02c6\u02c1\3\2\2\2\u02c6\u02c4"+
		"\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02c9\7;\2\2\u02c9"+
		"\u02cb\5j\66\2\u02ca\u02cc\5> \2\u02cb\u02ca\3\2\2\2\u02cb\u02cc\3\2\2"+
		"\2\u02cc\u02cf\3\2\2\2\u02cd\u02ce\7\b\2\2\u02ce\u02d0\7\u008a\2\2\u02cf"+
		"\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d7\3\2\2\2\u02d1\u02d4\7\4"+
		"\2\2\u02d2\u02d5\7<\2\2\u02d3\u02d5\7=\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d3"+
		"\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d8\7\6\2\2\u02d7"+
		"\u02d1\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02e4\b\26"+
		"\1\2\u02da\u02df\7\4\2\2\u02db\u02de\5\62\32\2\u02dc\u02de\5B\"\2\u02dd"+
		"\u02db\3\2\2\2\u02dd\u02dc\3\2\2\2\u02de\u02e1\3\2\2\2\u02df\u02dd\3\2"+
		"\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e2\3\2\2\2\u02e1\u02df\3\2\2\2\u02e2"+
		"\u02e5\7\6\2\2\u02e3\u02e5\7\25\2\2\u02e4\u02da\3\2\2\2\u02e4\u02e3\3"+
		"\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e7\b\26\1\2\u02e7+\3\2\2\2\u02e8\u02e9"+
		"\t\3\2\2\u02e9-\3\2\2\2\u02ea\u02ec\5L\'\2\u02eb\u02ea\3\2\2\2\u02eb\u02ec"+
		"\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02ee\7C\2\2\u02ee\u02f0\5j\66\2\u02ef"+
		"\u02f1\5> \2\u02f0\u02ef\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f4\3\2\2"+
		"\2\u02f2\u02f3\7\b\2\2\u02f3\u02f5\7\u008a\2\2\u02f4\u02f2\3\2\2\2\u02f4"+
		"\u02f5\3\2\2\2\u02f5\u02fc\3\2\2\2\u02f6\u02f9\7\4\2\2\u02f7\u02fa\7<"+
		"\2\2\u02f8\u02fa\7=\2\2\u02f9\u02f7\3\2\2\2\u02f9\u02f8\3\2\2\2\u02f9"+
		"\u02fa\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fd\7\6\2\2\u02fc\u02f6\3\2"+
		"\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u030a\b\30\1\2\u02ff"+
		"\u0305\7\4\2\2\u0300\u0304\5\62\32\2\u0301\u0304\5\60\31\2\u0302\u0304"+
		"\5B\"\2\u0303\u0300\3\2\2\2\u0303\u0301\3\2\2\2\u0303\u0302\3\2\2\2\u0304"+
		"\u0307\3\2\2\2\u0305\u0303\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0308\3\2"+
		"\2\2\u0307\u0305\3\2\2\2\u0308\u030b\7\6\2\2\u0309\u030b\7\25\2\2\u030a"+
		"\u02ff\3\2\2\2\u030a\u0309\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u030d\b\30"+
		"\1\2\u030d/\3\2\2\2\u030e\u030f\7D\2\2\u030f\u0312\5j\66\2\u0310\u0312"+
		"\5j\66\2\u0311\u030e\3\2\2\2\u0311\u0310\3\2\2\2\u0312\u0315\3\2\2\2\u0313"+
		"\u0314\7\27\2\2\u0314\u0316\5t;\2\u0315\u0313\3\2\2\2\u0315\u0316\3\2"+
		"\2\2\u0316\u0320\3\2\2\2\u0317\u031b\7\4\2\2\u0318\u031a\5\62\32\2\u0319"+
		"\u0318\3\2\2\2\u031a\u031d\3\2\2\2\u031b\u0319\3\2\2\2\u031b\u031c\3\2"+
		"\2\2\u031c\u031e\3\2\2\2\u031d\u031b\3\2\2\2\u031e\u0321\7\6\2\2\u031f"+
		"\u0321\7\25\2\2\u0320\u0317\3\2\2\2\u0320\u031f\3\2\2\2\u0321\u0322\3"+
		"\2\2\2\u0322\u0323\b\31\1\2\u0323\61\3\2\2\2\u0324\u0326\7E\2\2\u0325"+
		"\u0327\7\u008a\2\2\u0326\u0325\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0333"+
		"\3\2\2\2\u0328\u0329\7\21\2\2\u0329\u032e\5\64\33\2\u032a\u032b\7\5\2"+
		"\2\u032b\u032d\5\64\33\2\u032c\u032a\3\2\2\2\u032d\u0330\3\2\2\2\u032e"+
		"\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0331\3\2\2\2\u0330\u032e\3\2"+
		"\2\2\u0331\u0332\7\22\2\2\u0332\u0334\3\2\2\2\u0333\u0328\3\2\2\2\u0333"+
		"\u0334\3\2\2\2\u0334\u0340\3\2\2\2\u0335\u0339\7\4\2\2\u0336\u033a\5\62"+
		"\32\2\u0337\u033a\5\66\34\2\u0338\u033a\5<\37\2\u0339\u0336\3\2\2\2\u0339"+
		"\u0337\3\2\2\2\u0339\u0338\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u0339\3\2"+
		"\2\2\u033b\u033c\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033e\7\6\2\2\u033e"+
		"\u0341\3\2\2\2\u033f\u0341\7\25\2\2\u0340\u0335\3\2\2\2\u0340\u033f\3"+
		"\2\2\2\u0341\63\3\2\2\2\u0342\u0343\7\u008a\2\2\u0343\u0344\7\27\2\2\u0344"+
		"\u0345\t\4\2\2\u0345\65\3\2\2\2\u0346\u0349\5\62\32\2\u0347\u0349\58\35"+
		"\2\u0348\u0346\3\2\2\2\u0348\u0347\3\2\2\2\u0349\67\3\2\2\2\u034a\u034f"+
		"\5:\36\2\u034b\u034f\5\30\r\2\u034c\u034f\5\26\f\2\u034d\u034f\5\60\31"+
		"\2\u034e\u034a\3\2\2\2\u034e\u034b\3\2\2\2\u034e\u034c\3\2\2\2\u034e\u034d"+
		"\3\2\2\2\u034f9\3\2\2\2\u0350\u0354\5\"\22\2\u0351\u0354\5$\23\2\u0352"+
		"\u0354\5\34\17\2\u0353\u0350\3\2\2\2\u0353\u0351\3\2\2\2\u0353\u0352\3"+
		"\2\2\2\u0354;\3\2\2\2\u0355\u0356\7F\2\2\u0356\u0357\5l\67\2\u0357\u0358"+
		"\7\25\2\2\u0358=\3\2\2\2\u0359\u035a\7\21\2\2\u035a\u035f\5n8\2\u035b"+
		"\u035c\7\5\2\2\u035c\u035e\5n8\2\u035d\u035b\3\2\2\2\u035e\u0361\3\2\2"+
		"\2\u035f\u035d\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0362\3\2\2\2\u0361\u035f"+
		"\3\2\2\2\u0362\u0363\7\22\2\2\u0363\u0370\3\2\2\2\u0364\u0365\7G\2\2\u0365"+
		"\u036a\5n8\2\u0366\u0367\7\5\2\2\u0367\u0369\5n8\2\u0368\u0366\3\2\2\2"+
		"\u0369\u036c\3\2\2\2\u036a\u0368\3\2\2\2\u036a\u036b\3\2\2\2\u036b\u036d"+
		"\3\2\2\2\u036c\u036a\3\2\2\2\u036d\u036e\7H\2\2\u036e\u0370\3\2\2\2\u036f"+
		"\u0359\3\2\2\2\u036f\u0364\3\2\2\2\u0370?\3\2\2\2\u0371\u0373\7I\2\2\u0372"+
		"\u0374\5n8\2\u0373\u0372\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u037b\3\2\2"+
		"\2\u0375\u0377\7\b\2\2\u0376\u0378\5T+\2\u0377\u0376\3\2\2\2\u0377\u0378"+
		"\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037c\7\25\2\2\u037a\u037c\7\25\2\2"+
		"\u037b\u0375\3\2\2\2\u037b\u037a\3\2\2\2\u037cA\3\2\2\2\u037d\u037f\7"+
		"J\2\2\u037e\u037d\3\2\2\2\u037e\u037f\3\2\2\2\u037f\u0380\3\2\2\2\u0380"+
		"\u0387\7K\2\2\u0381\u0385\5n8\2\u0382\u0383\7\21\2\2\u0383\u0384\7\u0089"+
		"\2\2\u0384\u0386\7\22\2\2\u0385\u0382\3\2\2\2\u0385\u0386\3\2\2\2\u0386"+
		"\u0388\3\2\2\2\u0387\u0381\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u038f\3\2"+
		"\2\2\u0389\u038b\7\b\2\2\u038a\u038c\5R*\2\u038b\u038a\3\2\2\2\u038b\u038c"+
		"\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u0390\7\25\2\2\u038e\u0390\7\25\2\2"+
		"\u038f\u0389\3\2\2\2\u038f\u038e\3\2\2\2\u0390C\3\2\2\2\u0391\u0398\t"+
		"\5\2\2\u0392\u0396\5n8\2\u0393\u0394\7\21\2\2\u0394\u0395\7\u0089\2\2"+
		"\u0395\u0397\7\22\2\2\u0396\u0393\3\2\2\2\u0396\u0397\3\2\2\2\u0397\u0399"+
		"\3\2\2\2\u0398\u0392\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u03a0\3\2\2\2\u039a"+
		"\u039c\7\b\2\2\u039b\u039d\5R*\2\u039c\u039b\3\2\2\2\u039c\u039d\3\2\2"+
		"\2\u039d\u039e\3\2\2\2\u039e\u03a1\7\25\2\2\u039f\u03a1\7\25\2\2\u03a0"+
		"\u039a\3\2\2\2\u03a0\u039f\3\2\2\2\u03a1E\3\2\2\2\u03a2\u03a9\t\6\2\2"+
		"\u03a3\u03a7\5n8\2\u03a4\u03a5\7\21\2\2\u03a5\u03a6\7\u0089\2\2\u03a6"+
		"\u03a8\7\22\2\2\u03a7\u03a4\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03aa\3"+
		"\2\2\2\u03a9\u03a3\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03b1\3\2\2\2\u03ab"+
		"\u03ad\7\b\2\2\u03ac\u03ae\5R*\2\u03ad\u03ac\3\2\2\2\u03ad\u03ae\3\2\2"+
		"\2\u03ae\u03af\3\2\2\2\u03af\u03b2\7\25\2\2\u03b0\u03b2\7\25\2\2\u03b1"+
		"\u03ab\3\2\2\2\u03b1\u03b0\3\2\2\2\u03b2G\3\2\2\2\u03b3\u03b5\7P\2\2\u03b4"+
		"\u03b6\5n8\2\u03b5\u03b4\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03bd\3\2\2"+
		"\2\u03b7\u03b9\7\b\2\2\u03b8\u03ba\5T+\2\u03b9\u03b8\3\2\2\2\u03b9\u03ba"+
		"\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03be\7\25\2\2\u03bc\u03be\7\25\2\2"+
		"\u03bd\u03b7\3\2\2\2\u03bd\u03bc\3\2\2\2\u03beI\3\2\2\2\u03bf\u03c1\7"+
		"Q\2\2\u03c0\u03c2\5n8\2\u03c1\u03c0\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2"+
		"\u03c9\3\2\2\2\u03c3\u03c5\7\b\2\2\u03c4\u03c6\5T+\2\u03c5\u03c4\3\2\2"+
		"\2\u03c5\u03c6\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03ca\7\25\2\2\u03c8"+
		"\u03ca\7\25\2\2\u03c9\u03c3\3\2\2\2\u03c9\u03c8\3\2\2\2\u03caK\3\2\2\2"+
		"\u03cb\u03cc\t\7\2\2\u03ccM\3\2\2\2\u03cd\u03ce\7\u0088\2\2\u03ce\u03d1"+
		"\b(\1\2\u03cf\u03d1\7\u0087\2\2\u03d0\u03cd\3\2\2\2\u03d0\u03cf\3\2\2"+
		"\2\u03d1O\3\2\2\2\u03d2\u03d3\7\u0087\2\2\u03d3Q\3\2\2\2\u03d4\u03d5\b"+
		"*\1\2\u03d5\u03d6\7U\2\2\u03d6\u04db\5T+\2\u03d7\u03d8\7V\2\2\u03d8\u04db"+
		"\5T+\2\u03d9\u03da\7W\2\2\u03da\u04db\5T+\2\u03db\u03dc\7X\2\2\u03dc\u04db"+
		"\5T+\2\u03dd\u03df\5T+\2\u03de\u03e0\t\b\2\2\u03df\u03de\3\2\2\2\u03df"+
		"\u03e0\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u03e2\7[\2\2\u03e2\u03e3\5T+"+
		"\2\u03e3\u04db\3\2\2\2\u03e4\u03e6\5T+\2\u03e5\u03e7\t\b\2\2\u03e6\u03e5"+
		"\3\2\2\2\u03e6\u03e7\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8\u03e9\7\27\2\2"+
		"\u03e9\u03ea\5T+\2\u03ea\u04db\3\2\2\2\u03eb\u03ed\5V,\2\u03ec\u03ee\t"+
		"\b\2\2\u03ed\u03ec\3\2\2\2\u03ed\u03ee\3\2\2\2\u03ee\u03ef\3\2\2\2\u03ef"+
		"\u03f0\7\27\2\2\u03f0\u03f1\5V,\2\u03f1\u04db\3\2\2\2\u03f2\u03f4\5V,"+
		"\2\u03f3\u03f5\t\b\2\2\u03f4\u03f3\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f6"+
		"\3\2\2\2\u03f6\u03f7\7G\2\2\u03f7\u03f8\5V,\2\u03f8\u04db\3\2\2\2\u03f9"+
		"\u03fb\5V,\2\u03fa\u03fc\t\b\2\2\u03fb\u03fa\3\2\2\2\u03fb\u03fc\3\2\2"+
		"\2\u03fc\u03fd\3\2\2\2\u03fd\u03fe\7\\\2\2\u03fe\u03ff\5V,\2\u03ff\u04db"+
		"\3\2\2\2\u0400\u0402\5V,\2\u0401\u0403\t\b\2\2\u0402\u0401\3\2\2\2\u0402"+
		"\u0403\3\2\2\2\u0403\u0404\3\2\2\2\u0404\u0405\7H\2\2\u0405\u0406\5V,"+
		"\2\u0406\u04db\3\2\2\2\u0407\u0409\5V,\2\u0408\u040a\t\b\2\2\u0409\u0408"+
		"\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u040c\7]\2\2\u040c"+
		"\u040d\5V,\2\u040d\u04db\3\2\2\2\u040e\u040f\b*\1\2\u040f\u0410\7^\2\2"+
		"\u0410\u0411\5X-\2\u0411\u0412\7_\2\2\u0412\u0413\5V,\2\u0413\u0414\3"+
		"\2\2\2\u0414\u0415\b*\1\2\u0415\u04db\3\2\2\2\u0416\u0417\7`\2\2\u0417"+
		"\u0418\7\r\2\2\u0418\u0419\5d\63\2\u0419\u041a\7\16\2\2\u041a\u04db\3"+
		"\2\2\2\u041b\u041c\7a\2\2\u041c\u041d\7\r\2\2\u041d\u041e\5d\63\2\u041e"+
		"\u041f\7\b\2\2\u041f\u0420\5T+\2\u0420\u0421\7b\2\2\u0421\u0422\t\t\2"+
		"\2\u0422\u0423\5T+\2\u0423\u0424\7\16\2\2\u0424\u04db\3\2\2\2\u0425\u0426"+
		"\7c\2\2\u0426\u0427\7\r\2\2\u0427\u0428\5d\63\2\u0428\u0429\7\5\2\2\u0429"+
		"\u042a\5d\63\2\u042a\u042b\7\5\2\2\u042b\u042c\5d\63\2\u042c\u042d\7\5"+
		"\2\2\u042d\u042e\5d\63\2\u042e\u042f\7\16\2\2\u042f\u04db\3\2\2\2\u0430"+
		"\u0431\t\b\2\2\u0431\u04db\5R*\20\u0432\u0433\b*\1\2\u0433\u0434\7l\2"+
		"\2\u0434\u0449\5X-\2\u0435\u043f\7_\2\2\u0436\u0440\5R*\2\u0437\u043b"+
		"\7\4\2\2\u0438\u043a\5R*\2\u0439\u0438\3\2\2\2\u043a\u043d\3\2\2\2\u043b"+
		"\u0439\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u043e\3\2\2\2\u043d\u043b\3\2"+
		"\2\2\u043e\u0440\7\6\2\2\u043f\u0436\3\2\2\2\u043f\u0437\3\2\2\2\u0440"+
		"\u044a\3\2\2\2\u0441\u0445\7\4\2\2\u0442\u0444\5R*\2\u0443\u0442\3\2\2"+
		"\2\u0444\u0447\3\2\2\2\u0445\u0443\3\2\2\2\u0445\u0446\3\2\2\2\u0446\u0448"+
		"\3\2\2\2\u0447\u0445\3\2\2\2\u0448\u044a\7\6\2\2\u0449\u0435\3\2\2\2\u0449"+
		"\u0441\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u044c\b*\1\2\u044c\u04db\3\2"+
		"\2\2\u044d\u044e\b*\1\2\u044e\u044f\7X\2\2\u044f\u0464\5X-\2\u0450\u045a"+
		"\7_\2\2\u0451\u045b\5R*\2\u0452\u0456\7\4\2\2\u0453\u0455\5R*\2\u0454"+
		"\u0453\3\2\2\2\u0455\u0458\3\2\2\2\u0456\u0454\3\2\2\2\u0456\u0457\3\2"+
		"\2\2\u0457\u0459\3\2\2\2\u0458\u0456\3\2\2\2\u0459\u045b\7\6\2\2\u045a"+
		"\u0451\3\2\2\2\u045a\u0452\3\2\2\2\u045b\u0465\3\2\2\2\u045c\u0460\7\4"+
		"\2\2\u045d\u045f\5R*\2\u045e\u045d\3\2\2\2\u045f\u0462\3\2\2\2\u0460\u045e"+
		"\3\2\2\2\u0460\u0461\3\2\2\2\u0461\u0463\3\2\2\2\u0462\u0460\3\2\2\2\u0463"+
		"\u0465\7\6\2\2\u0464\u0450\3\2\2\2\u0464\u045c\3\2\2\2\u0465\u0466\3\2"+
		"\2\2\u0466\u0467\b*\1\2\u0467\u04db\3\2\2\2\u0468\u0469\b*\1\2\u0469\u046a"+
		"\7U\2\2\u046a\u047f\5X-\2\u046b\u0475\7_\2\2\u046c\u0476\5R*\2\u046d\u0471"+
		"\7\4\2\2\u046e\u0470\5R*\2\u046f\u046e\3\2\2\2\u0470\u0473\3\2\2\2\u0471"+
		"\u046f\3\2\2\2\u0471\u0472\3\2\2\2\u0472\u0474\3\2\2\2\u0473\u0471\3\2"+
		"\2\2\u0474\u0476\7\6\2\2\u0475\u046c\3\2\2\2\u0475\u046d\3\2\2\2\u0476"+
		"\u0480\3\2\2\2\u0477\u047b\7\4\2\2\u0478\u047a\5R*\2\u0479\u0478\3\2\2"+
		"\2\u047a\u047d\3\2\2\2\u047b\u0479\3\2\2\2\u047b\u047c\3\2\2\2\u047c\u047e"+
		"\3\2\2\2\u047d\u047b\3\2\2\2\u047e\u0480\7\6\2\2\u047f\u046b\3\2\2\2\u047f"+
		"\u0477\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u0482\b*\1\2\u0482\u04db\3\2"+
		"\2\2\u0483\u0484\b*\1\2\u0484\u0485\7W\2\2\u0485\u049a\5X-\2\u0486\u0490"+
		"\7_\2\2\u0487\u0491\5R*\2\u0488\u048c\7\4\2\2\u0489\u048b\5R*\2\u048a"+
		"\u0489\3\2\2\2\u048b\u048e\3\2\2\2\u048c\u048a\3\2\2\2\u048c\u048d\3\2"+
		"\2\2\u048d\u048f\3\2\2\2\u048e\u048c\3\2\2\2\u048f\u0491\7\6\2\2\u0490"+
		"\u0487\3\2\2\2\u0490\u0488\3\2\2\2\u0491\u049b\3\2\2\2\u0492\u0496\7\4"+
		"\2\2\u0493\u0495\5R*\2\u0494\u0493\3\2\2\2\u0495\u0498\3\2\2\2\u0496\u0494"+
		"\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u0499\3\2\2\2\u0498\u0496\3\2\2\2\u0499"+
		"\u049b\7\6\2\2\u049a\u0486\3\2\2\2\u049a\u0492\3\2\2\2\u049b\u049c\3\2"+
		"\2\2\u049c\u049d\b*\1\2\u049d\u04db\3\2\2\2\u049e\u049f\b*\1\2\u049f\u04a0"+
		"\7V\2\2\u04a0\u04b5\5X-\2\u04a1\u04ab\7_\2\2\u04a2\u04ac\5R*\2\u04a3\u04a7"+
		"\7\4\2\2\u04a4\u04a6\5R*\2\u04a5\u04a4\3\2\2\2\u04a6\u04a9\3\2\2\2\u04a7"+
		"\u04a5\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u04aa\3\2\2\2\u04a9\u04a7\3\2"+
		"\2\2\u04aa\u04ac\7\6\2\2\u04ab\u04a2\3\2\2\2\u04ab\u04a3\3\2\2\2\u04ac"+
		"\u04b6\3\2\2\2\u04ad\u04b1\7\4\2\2\u04ae\u04b0\5R*\2\u04af\u04ae\3\2\2"+
		"\2\u04b0\u04b3\3\2\2\2\u04b1\u04af\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u04b4"+
		"\3\2\2\2\u04b3\u04b1\3\2\2\2\u04b4\u04b6\7\6\2\2\u04b5\u04a1\3\2\2\2\u04b5"+
		"\u04ad\3\2\2\2\u04b6\u04b7\3\2\2\2\u04b7\u04b8\b*\1\2\u04b8\u04db\3\2"+
		"\2\2\u04b9\u04ba\b*\1\2\u04ba\u04bb\7m\2\2\u04bb\u04d0\5\\/\2\u04bc\u04c6"+
		"\7_\2\2\u04bd\u04c7\5R*\2\u04be\u04c2\7\4\2\2\u04bf\u04c1\5R*\2\u04c0"+
		"\u04bf\3\2\2\2\u04c1\u04c4\3\2\2\2\u04c2\u04c0\3\2\2\2\u04c2\u04c3\3\2"+
		"\2\2\u04c3\u04c5\3\2\2\2\u04c4\u04c2\3\2\2\2\u04c5\u04c7\7\6\2\2\u04c6"+
		"\u04bd\3\2\2\2\u04c6\u04be\3\2\2\2\u04c7\u04d1\3\2\2\2\u04c8\u04cc\7\4"+
		"\2\2\u04c9\u04cb\5R*\2\u04ca\u04c9\3\2\2\2\u04cb\u04ce\3\2\2\2\u04cc\u04ca"+
		"\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04cf\3\2\2\2\u04ce\u04cc\3\2\2\2\u04cf"+
		"\u04d1\7\6\2\2\u04d0\u04bc\3\2\2\2\u04d0\u04c8\3\2\2\2\u04d1\u04d2\3\2"+
		"\2\2\u04d2\u04d3\b*\1\2\u04d3\u04db\3\2\2\2\u04d4\u04db\7n\2\2\u04d5\u04db"+
		"\7o\2\2\u04d6\u04d7\7\21\2\2\u04d7\u04d8\5R*\2\u04d8\u04d9\7\22\2\2\u04d9"+
		"\u04db\3\2\2\2\u04da\u03d4\3\2\2\2\u04da\u03d7\3\2\2\2\u04da\u03d9\3\2"+
		"\2\2\u04da\u03db\3\2\2\2\u04da\u03dd\3\2\2\2\u04da\u03e4\3\2\2\2\u04da"+
		"\u03eb\3\2\2\2\u04da\u03f2\3\2\2\2\u04da\u03f9\3\2\2\2\u04da\u0400\3\2"+
		"\2\2\u04da\u0407\3\2\2\2\u04da\u040e\3\2\2\2\u04da\u0416\3\2\2\2\u04da"+
		"\u041b\3\2\2\2\u04da\u0425\3\2\2\2\u04da\u0430\3\2\2\2\u04da\u0432\3\2"+
		"\2\2\u04da\u044d\3\2\2\2\u04da\u0468\3\2\2\2\u04da\u0483\3\2\2\2\u04da"+
		"\u049e\3\2\2\2\u04da\u04b9\3\2\2\2\u04da\u04d4\3\2\2\2\u04da\u04d5\3\2"+
		"\2\2\u04da\u04d6\3\2\2\2\u04db\u04ea\3\2\2\2\u04dc\u04dd\f\17\2\2\u04dd"+
		"\u04de\t\n\2\2\u04de\u04e9\5R*\17\u04df\u04e0\f\16\2\2\u04e0\u04e1\t\13"+
		"\2\2\u04e1\u04e9\5R*\16\u04e2\u04e3\f\r\2\2\u04e3\u04e4\t\f\2\2\u04e4"+
		"\u04e9\5R*\r\u04e5\u04e6\f\f\2\2\u04e6\u04e7\t\r\2\2\u04e7\u04e9\5R*\f"+
		"\u04e8\u04dc\3\2\2\2\u04e8\u04df\3\2\2\2\u04e8\u04e2\3\2\2\2\u04e8\u04e5"+
		"\3\2\2\2\u04e9\u04ec\3\2\2\2\u04ea\u04e8\3\2\2\2\u04ea\u04eb\3\2\2\2\u04eb"+
		"S\3\2\2\2\u04ec\u04ea\3\2\2\2\u04ed\u04ee\b+\1\2\u04ee\u04ef\7p\2\2\u04ef"+
		"\u0513\5T+\25\u04f0\u04f1\7q\2\2\u04f1\u0513\5T+\24\u04f2\u04f3\7\65\2"+
		"\2\u04f3\u0513\5T+\23\u04f4\u04f5\b+\1\2\u04f5\u04f6\7\4\2\2\u04f6\u04f7"+
		"\5`\61\2\u04f7\u04f8\7_\2\2\u04f8\u04f9\5R*\2\u04f9\u04fa\7\6\2\2\u04fa"+
		"\u04fb\3\2\2\2\u04fb\u04fc\b+\1\2\u04fc\u0513\3\2\2\2\u04fd\u04fe\t\f"+
		"\2\2\u04fe\u04ff\5R*\2\u04ff\u0500\7w\2\2\u0500\u0501\5T+\2\u0501\u0502"+
		"\7x\2\2\u0502\u0503\5T+\n\u0503\u0513\3\2\2\2\u0504\u0513\7y\2\2\u0505"+
		"\u0513\7z\2\2\u0506\u0513\7{\2\2\u0507\u0513\7|\2\2\u0508\u0509\7\21\2"+
		"\2\u0509\u050a\5T+\2\u050a\u050b\7\22\2\2\u050b\u0513\3\2\2\2\u050c\u050d"+
		"\6+\6\2\u050d\u050e\5f\64\2\u050e\u050f\b+\1\2\u050f\u0513\3\2\2\2\u0510"+
		"\u0511\6+\7\2\u0511\u0513\5d\63\2\u0512\u04ed\3\2\2\2\u0512\u04f0\3\2"+
		"\2\2\u0512\u04f2\3\2\2\2\u0512\u04f4\3\2\2\2\u0512\u04fd\3\2\2\2\u0512"+
		"\u0504\3\2\2\2\u0512\u0505\3\2\2\2\u0512\u0506\3\2\2\2\u0512\u0507\3\2"+
		"\2\2\u0512\u0508\3\2\2\2\u0512\u050c\3\2\2\2\u0512\u0510\3\2\2\2\u0513"+
		"\u0533\3\2\2\2\u0514\u0515\f\22\2\2\u0515\u0516\7\66\2\2\u0516\u0532\5"+
		"T+\23\u0517\u0518\f\21\2\2\u0518\u0519\7r\2\2\u0519\u0532\5T+\22\u051a"+
		"\u051b\f\20\2\2\u051b\u051c\7s\2\2\u051c\u0532\5T+\21\u051d\u051e\f\17"+
		"\2\2\u051e\u051f\7t\2\2\u051f\u0532\5T+\20\u0520\u0522\f\r\2\2\u0521\u0523"+
		"\t\16\2\2\u0522\u0521\3\2\2\2\u0522\u0523\3\2\2\2\u0523\u0524\3\2\2\2"+
		"\u0524\u0526\7b\2\2\u0525\u0527\t\16\2\2\u0526\u0525\3\2\2\2\u0526\u0527"+
		"\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u0532\5T+\r\u0529\u052a\f\f\2\2\u052a"+
		"\u052b\7v\2\2\u052b\u0532\5T+\r\u052c\u052d\f\16\2\2\u052d\u052e\7\r\2"+
		"\2\u052e\u052f\5T+\2\u052f\u0530\7\16\2\2\u0530\u0532\3\2\2\2\u0531\u0514"+
		"\3\2\2\2\u0531\u0517\3\2\2\2\u0531\u051a\3\2\2\2\u0531\u051d\3\2\2\2\u0531"+
		"\u0520\3\2\2\2\u0531\u0529\3\2\2\2\u0531\u052c\3\2\2\2\u0532\u0535\3\2"+
		"\2\2\u0533\u0531\3\2\2\2\u0533\u0534\3\2\2\2\u0534U\3\2\2\2\u0535\u0533"+
		"\3\2\2\2\u0536\u0537\b,\1\2\u0537\u0538\t\f\2\2\u0538\u0539\5R*\2\u0539"+
		"\u053a\7w\2\2\u053a\u053b\5V,\2\u053b\u053c\7x\2\2\u053c\u053d\5V,\f\u053d"+
		"\u054b\3\2\2\2\u053e\u053f\7^\2\2\u053f\u054b\5T+\2\u0540\u0541\7.\2\2"+
		"\u0541\u054b\5T+\2\u0542\u0544\7s\2\2\u0543\u0542\3\2\2\2\u0543\u0544"+
		"\3\2\2\2\u0544\u0545\3\2\2\2\u0545\u054b\5h\65\2\u0546\u0547\7\21\2\2"+
		"\u0547\u0548\5V,\2\u0548\u0549\7\22\2\2\u0549\u054b\3\2\2\2\u054a\u0536"+
		"\3\2\2\2\u054a\u053e\3\2\2\2\u054a\u0540\3\2\2\2\u054a\u0543\3\2\2\2\u054a"+
		"\u0546\3\2\2\2\u054b\u055d\3\2\2\2\u054c\u054d\f\t\2\2\u054d\u054e\t\17"+
		"\2\2\u054e\u055c\5V,\n\u054f\u0550\f\b\2\2\u0550\u0551\t\20\2\2\u0551"+
		"\u055c\5V,\t\u0552\u0553\f\7\2\2\u0553\u0554\t\21\2\2\u0554\u055c\5V,"+
		"\b\u0555\u0556\f\6\2\2\u0556\u0557\t\22\2\2\u0557\u055c\5V,\7\u0558\u0559"+
		"\f\5\2\2\u0559\u055a\t\23\2\2\u055a\u055c\5V,\6\u055b\u054c\3\2\2\2\u055b"+
		"\u054f\3\2\2\2\u055b\u0552\3\2\2\2\u055b\u0555\3\2\2\2\u055b\u0558\3\2"+
		"\2\2\u055c\u055f\3\2\2\2\u055d\u055b\3\2\2\2\u055d\u055e\3\2\2\2\u055e"+
		"W\3\2\2\2\u055f\u055d\3\2\2\2\u0560\u0565\5Z.\2\u0561\u0562\7\5\2\2\u0562"+
		"\u0564\5Z.\2\u0563\u0561\3\2\2\2\u0564\u0567\3\2\2\2\u0565\u0563\3\2\2"+
		"\2\u0565\u0566\3\2\2\2\u0566Y\3\2\2\2\u0567\u0565\3\2\2\2\u0568\u056a"+
		"\7\u0084\2\2\u0569\u0568\3\2\2\2\u0569\u056a\3\2\2\2\u056a\u056b\3\2\2"+
		"\2\u056b\u0570\5f\64\2\u056c\u056d\7\5\2\2\u056d\u056f\5f\64\2\u056e\u056c"+
		"\3\2\2\2\u056f\u0572\3\2\2\2\u0570\u056e\3\2\2\2\u0570\u0571\3\2\2\2\u0571"+
		"\u0573\3\2\2\2\u0572\u0570\3\2\2\2\u0573\u0575\7\b\2\2\u0574\u0576\7W"+
		"\2\2\u0575\u0574\3\2\2\2\u0575\u0576\3\2\2\2\u0576\u0577\3\2\2\2\u0577"+
		"\u0578\5T+\2\u0578\u0579\b.\1\2\u0579\u05ab\3\2\2\2\u057a\u057c\7\u0084"+
		"\2\2\u057b\u057a\3\2\2\2\u057b\u057c\3\2\2\2\u057c\u057d\3\2\2\2\u057d"+
		"\u0582\5f\64\2\u057e\u057f\7\5\2\2\u057f\u0581\5f\64\2\u0580\u057e\3\2"+
		"\2\2\u0581\u0584\3\2\2\2\u0582\u0580\3\2\2\2\u0582\u0583\3\2\2\2\u0583"+
		"\u0585\3\2\2\2\u0584\u0582\3\2\2\2\u0585\u0586\7\b\2\2\u0586\u0587\7V"+
		"\2\2\u0587\u0588\5T+\2\u0588\u0589\b.\1\2\u0589\u05ab\3\2\2\2\u058a\u058c"+
		"\7\u0084\2\2\u058b\u058a\3\2\2\2\u058b\u058c\3\2\2\2\u058c\u058d\3\2\2"+
		"\2\u058d\u0592\5f\64\2\u058e\u058f\7\5\2\2\u058f\u0591\5f\64\2\u0590\u058e"+
		"\3\2\2\2\u0591\u0594\3\2\2\2\u0592\u0590\3\2\2\2\u0592\u0593\3\2\2\2\u0593"+
		"\u0595\3\2\2\2\u0594\u0592\3\2\2\2\u0595\u0596\7\b\2\2\u0596\u0597\7X"+
		"\2\2\u0597\u0598\5T+\2\u0598\u0599\b.\1\2\u0599\u05ab\3\2\2\2\u059a\u059c"+
		"\7\u0084\2\2\u059b\u059a\3\2\2\2\u059b\u059c\3\2\2\2\u059c\u059d\3\2\2"+
		"\2\u059d\u05a2\5f\64\2\u059e\u059f\7\5\2\2\u059f\u05a1\5f\64\2\u05a0\u059e"+
		"\3\2\2\2\u05a1\u05a4\3\2\2\2\u05a2\u05a0\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3"+
		"\u05a5\3\2\2\2\u05a4\u05a2\3\2\2\2\u05a5\u05a6\7\b\2\2\u05a6\u05a7\7u"+
		"\2\2\u05a7\u05a8\5T+\2\u05a8\u05a9\b.\1\2\u05a9\u05ab\3\2\2\2\u05aa\u0569"+
		"\3\2\2\2\u05aa\u057b\3\2\2\2\u05aa\u058b\3\2\2\2\u05aa\u059b\3\2\2\2\u05ab"+
		"[\3\2\2\2\u05ac\u05b1\5^\60\2\u05ad\u05ae\7\5\2\2\u05ae\u05b0\5^\60\2"+
		"\u05af\u05ad\3\2\2\2\u05b0\u05b3\3\2\2\2\u05b1\u05af\3\2\2\2\u05b1\u05b2"+
		"\3\2\2\2\u05b2]\3\2\2\2\u05b3\u05b1\3\2\2\2\u05b4\u05b9\5f\64\2\u05b5"+
		"\u05b6\7\5\2\2\u05b6\u05b8\5f\64\2\u05b7\u05b5\3\2\2\2\u05b8\u05bb\3\2"+
		"\2\2\u05b9\u05b7\3\2\2\2\u05b9\u05ba\3\2\2\2\u05ba\u05bc\3\2\2\2\u05bb"+
		"\u05b9\3\2\2\2\u05bc\u05bd\7\27\2\2\u05bd\u05be\5T+\2\u05be\u05bf\3\2"+
		"\2\2\u05bf\u05c0\b\60\1\2\u05c0_\3\2\2\2\u05c1\u05c6\5b\62\2\u05c2\u05c3"+
		"\7\5\2\2\u05c3\u05c5\5b\62\2\u05c4\u05c2\3\2\2\2\u05c5\u05c8\3\2\2\2\u05c6"+
		"\u05c4\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7a\3\2\2\2\u05c8\u05c6\3\2\2\2"+
		"\u05c9\u05cb\7\u0084\2\2\u05ca\u05c9\3\2\2\2\u05ca\u05cb\3\2\2\2\u05cb"+
		"\u05cc\3\2\2\2\u05cc\u05d1\5f\64\2\u05cd\u05ce\7\5\2\2\u05ce\u05d0\5f"+
		"\64\2\u05cf\u05cd\3\2\2\2\u05d0\u05d3\3\2\2\2\u05d1\u05cf\3\2\2\2\u05d1"+
		"\u05d2\3\2\2\2\u05d2\u05d4\3\2\2\2\u05d3\u05d1\3\2\2\2\u05d4\u05d6\7\b"+
		"\2\2\u05d5\u05d7\7W\2\2\u05d6\u05d5\3\2\2\2\u05d6\u05d7\3\2\2\2\u05d7"+
		"\u05d8\3\2\2\2\u05d8\u05d9\5T+\2\u05d9\u05da\3\2\2\2\u05da\u05db\b\62"+
		"\1\2\u05dbc\3\2\2\2\u05dc\u05dd\7\u0088\2\2\u05dde\3\2\2\2\u05de\u05df"+
		"\7\u0088\2\2\u05dfg\3\2\2\2\u05e0\u05e1\7\u0087\2\2\u05e1i\3\2\2\2\u05e2"+
		"\u060a\5n8\2\u05e3\u060a\7\30\2\2\u05e4\u060a\7$\2\2\u05e5\u060a\7I\2"+
		"\2\u05e6\u060a\7J\2\2\u05e7\u060a\7\31\2\2\u05e8\u060a\7/\2\2\u05e9\u060a"+
		"\7;\2\2\u05ea\u060a\7\u0085\2\2\u05eb\u060a\7Q\2\2\u05ec\u060a\7%\2\2"+
		"\u05ed\u060a\7C\2\2\u05ee\u060a\7\33\2\2\u05ef\u060a\7&\2\2\u05f0\u060a"+
		"\7\24\2\2\u05f1\u060a\7P\2\2\u05f2\u060a\7\32\2\2\u05f3\u060a\7\62\2\2"+
		"\u05f4\u060a\7\23\2\2\u05f5\u060a\7\63\2\2\u05f6\u060a\7\'\2\2\u05f7\u060a"+
		"\7\26\2\2\u05f8\u060a\7N\2\2\u05f9\u060a\7L\2\2\u05fa\u060a\7:\2\2\u05fb"+
		"\u060a\7-\2\2\u05fc\u060a\7#\2\2\u05fd\u060a\7F\2\2\u05fe\u060a\7\60\2"+
		"\2\u05ff\u060a\7\34\2\2\u0600\u060a\7\64\2\2\u0601\u060a\7\37\2\2\u0602"+
		"\u060a\7)\2\2\u0603\u060a\7+\2\2\u0604\u060a\7 \2\2\u0605\u060a\7K\2\2"+
		"\u0606\u060a\7D\2\2\u0607\u060a\7<\2\2\u0608\u060a\7E\2\2\u0609\u05e2"+
		"\3\2\2\2\u0609\u05e3\3\2\2\2\u0609\u05e4\3\2\2\2\u0609\u05e5\3\2\2\2\u0609"+
		"\u05e6\3\2\2\2\u0609\u05e7\3\2\2\2\u0609\u05e8\3\2\2\2\u0609\u05e9\3\2"+
		"\2\2\u0609\u05ea\3\2\2\2\u0609\u05eb\3\2\2\2\u0609\u05ec\3\2\2\2\u0609"+
		"\u05ed\3\2\2\2\u0609\u05ee\3\2\2\2\u0609\u05ef\3\2\2\2\u0609\u05f0\3\2"+
		"\2\2\u0609\u05f1\3\2\2\2\u0609\u05f2\3\2\2\2\u0609\u05f3\3\2\2\2\u0609"+
		"\u05f4\3\2\2\2\u0609\u05f5\3\2\2\2\u0609\u05f6\3\2\2\2\u0609\u05f7\3\2"+
		"\2\2\u0609\u05f8\3\2\2\2\u0609\u05f9\3\2\2\2\u0609\u05fa\3\2\2\2\u0609"+
		"\u05fb\3\2\2\2\u0609\u05fc\3\2\2\2\u0609\u05fd\3\2\2\2\u0609\u05fe\3\2"+
		"\2\2\u0609\u05ff\3\2\2\2\u0609\u0600\3\2\2\2\u0609\u0601\3\2\2\2\u0609"+
		"\u0602\3\2\2\2\u0609\u0603\3\2\2\2\u0609\u0604\3\2\2\2\u0609\u0605\3\2"+
		"\2\2\u0609\u0606\3\2\2\2\u0609\u0607\3\2\2\2\u0609\u0608\3\2\2\2\u060a"+
		"k\3\2\2\2\u060b\u061b\5n8\2\u060c\u060d\7t\2\2\u060d\u060f\5n8\2\u060e"+
		"\u060c\3\2\2\2\u060f\u0612\3\2\2\2\u0610\u060e\3\2\2\2\u0610\u0611\3\2"+
		"\2\2\u0611\u0619\3\2\2\2\u0612\u0610\3\2\2\2\u0613\u0614\7t\2\2\u0614"+
		"\u061a\5n8\2\u0615\u0616\7\u0086\2\2\u0616\u061a\5n8\2\u0617\u0618\7b"+
		"\2\2\u0618\u061a\5n8\2\u0619\u0613\3\2\2\2\u0619\u0615\3\2\2\2\u0619\u0617"+
		"\3\2\2\2\u061a\u061c\3\2\2\2\u061b\u0610\3\2\2\2\u061b\u061c\3\2\2\2\u061c"+
		"m\3\2\2\2\u061d\u061e\7\u0088\2\2\u061eo\3\2\2\2\u061f\u0620\t\24\2\2"+
		"\u0620q\3\2\2\2\u0621\u0622\7\u0087\2\2\u0622s\3\2\2\2\u0623\u0625\7s"+
		"\2\2\u0624\u0623\3\2\2\2\u0624\u0625\3\2\2\2\u0625\u0626\3\2\2\2\u0626"+
		"\u0627\7\u0087\2\2\u0627u\3\2\2\2\u00e7w\u0080\u008d\u009e\u00a7\u00b2"+
		"\u00b7\u00c0\u00c8\u00cc\u00d2\u00de\u00e1\u00ea\u00ed\u00fc\u0104\u010f"+
		"\u0114\u0117\u011b\u0120\u012a\u0130\u0140\u0142\u0147\u014e\u0151\u0154"+
		"\u0158\u0161\u0164\u0168\u0170\u0172\u0177\u017d\u0180\u0183\u0187\u018a"+
		"\u018d\u0191\u0194\u019b\u019f\u01aa\u01ad\u01b1\u01b4\u01ba\u01bf\u01c3"+
		"\u01c8\u01cb\u01cf\u01d4\u01d7\u01db\u01de\u01e1\u01e5\u01e8\u01ee\u01f3"+
		"\u01f7\u0204\u0207\u020b\u020e\u0217\u021c\u0221\u0226\u022a\u022f\u0232"+
		"\u0236\u023b\u023e\u0249\u024c\u0252\u0254\u025c\u025f\u0266\u0269\u026d"+
		"\u0270\u0277\u0279\u027e\u0284\u028a\u028c\u0293\u0296\u029a\u029d\u02a3"+
		"\u02a7\u02ad\u02b3\u02b6\u02ba\u02bf\u02c4\u02c6\u02cb\u02cf\u02d4\u02d7"+
		"\u02dd\u02df\u02e4\u02eb\u02f0\u02f4\u02f9\u02fc\u0303\u0305\u030a\u0311"+
		"\u0315\u031b\u0320\u0326\u032e\u0333\u0339\u033b\u0340\u0348\u034e\u0353"+
		"\u035f\u036a\u036f\u0373\u0377\u037b\u037e\u0385\u0387\u038b\u038f\u0396"+
		"\u0398\u039c\u03a0\u03a7\u03a9\u03ad\u03b1\u03b5\u03b9\u03bd\u03c1\u03c5"+
		"\u03c9\u03d0\u03df\u03e6\u03ed\u03f4\u03fb\u0402\u0409\u043b\u043f\u0445"+
		"\u0449\u0456\u045a\u0460\u0464\u0471\u0475\u047b\u047f\u048c\u0490\u0496"+
		"\u049a\u04a7\u04ab\u04b1\u04b5\u04c2\u04c6\u04cc\u04d0\u04da\u04e8\u04ea"+
		"\u0512\u0522\u0526\u0531\u0533\u0543\u054a\u055b\u055d\u0565\u0569\u0570"+
		"\u0575\u057b\u0582\u058b\u0592\u059b\u05a2\u05aa\u05b1\u05b9\u05c6\u05ca"+
		"\u05d1\u05d6\u0609\u0610\u0619\u061b\u0624";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}