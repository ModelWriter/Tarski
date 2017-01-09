// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore.new/src/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.recognizer;


import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import java.util.stream.Collectors;

import java.util.*;


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
		T__131=132, T__132=133, T__133=134, T__134=135, INT=136, IDENTIFIER=137, 
		DOUBLE_QUOTED_STRING=138, SINGLE_QUOTED_STRING=139, ML_SINGLE_QUOTED_STRING=140, 
		MULTILINE_COMMENT=141, SINGLELINE_COMMENT=142, WS=143;
	public static final int
		RULE_problem = 0, RULE_options = 1, RULE_option = 2, RULE_universe = 3, 
		RULE_relations = 4, RULE_relation = 5, RULE_tupleSet = 6, RULE_tuple = 7, 
		RULE_module = 8, RULE_packageImport = 9, RULE_ePackage = 10, RULE_eClassifier = 11, 
		RULE_eClass = 12, RULE_eStructuralFeature = 13, RULE_eAttribute = 14, 
		RULE_eReference = 15, RULE_eOperation = 16, RULE_eParameter = 17, RULE_eMultiplicity = 18, 
		RULE_eDataType = 19, RULE_ePrimitiveType = 20, RULE_eEnum = 21, RULE_eEnumLiteral = 22, 
		RULE_eAnnotation = 23, RULE_eDetail = 24, RULE_eModelElement = 25, RULE_eNamedElement = 26, 
		RULE_eTypedElement = 27, RULE_eModelElementRef = 28, RULE_templateSignature = 29, 
		RULE_typeParameter = 30, RULE_typeRef = 31, RULE_typedRef = 32, RULE_typedTypeRef = 33, 
		RULE_wildcardTypeRef = 34, RULE_templateBinding = 35, RULE_templateParameterSubstitution = 36, 
		RULE_pathName = 37, RULE_body = 38, RULE_invariant = 39, RULE_precondition = 40, 
		RULE_postcondition = 41, RULE_initial = 42, RULE_derivation = 43, RULE_visibilityKind = 44, 
		RULE_atom = 45, RULE_arity = 46, RULE_formula = 47, RULE_expression = 48, 
		RULE_intexpression = 49, RULE_decls = 50, RULE_decl = 51, RULE_letDecls = 52, 
		RULE_letDecl = 53, RULE_comprehensionDecls = 54, RULE_comprehensionDecl = 55, 
		RULE_relationId = 56, RULE_variableId = 57, RULE_integer = 58, RULE_unrestrictedName = 59, 
		RULE_identifier = 60, RULE_upper = 61, RULE_lower = 62, RULE_signed = 63;
	public static final String[] ruleNames = {
		"problem", "options", "option", "universe", "relations", "relation", "tupleSet", 
		"tuple", "module", "packageImport", "ePackage", "eClassifier", "eClass", 
		"eStructuralFeature", "eAttribute", "eReference", "eOperation", "eParameter", 
		"eMultiplicity", "eDataType", "ePrimitiveType", "eEnum", "eEnumLiteral", 
		"eAnnotation", "eDetail", "eModelElement", "eNamedElement", "eTypedElement", 
		"eModelElementRef", "templateSignature", "typeParameter", "typeRef", "typedRef", 
		"typedTypeRef", "wildcardTypeRef", "templateBinding", "templateParameterSubstitution", 
		"pathName", "body", "invariant", "precondition", "postcondition", "initial", 
		"derivation", "visibilityKind", "atom", "arity", "formula", "expression", 
		"intexpression", "decls", "decl", "letDecls", "letDecl", "comprehensionDecls", 
		"comprehensionDecl", "relationId", "variableId", "integer", "unrestrictedName", 
		"identifier", "upper", "lower", "signed"
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
		"'reference'", "'<'", "'>'", "'&'", "'super'", "'::'", "'body'", "'callable'", 
		"'invariant'", "'precondition'", "'requires'", "'postcondition'", "'ensures'", 
		"'initial'", "'derivation'", "'public'", "'protected'", "'private'", "'no'", 
		"'lone'", "'one'", "'some'", "'!'", "'not'", "'in'", "'<='", "'>='", "'sum'", 
		"'|'", "'acyclic'", "'function'", "'->'", "'ord'", "'&&'", "'and'", "'||'", 
		"'or'", "'=>'", "'if'", "'<=>'", "'iff'", "'all'", "'let'", "'true'", 
		"'false'", "'~'", "'^'", "'-'", "'.'", "'set'", "'++'", "'then'", "'else'", 
		"'iden'", "'none'", "'univ'", "'ints'", "'plus'", "'minus'", "'mul'", 
		"'/'", "'div'", "'%'", "'modulo'", "'disj'", "'definition'", "'ensure'", 
		"'require'"
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
		null, null, null, null, "INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", 
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

	//ECORE BEGINS

	private void saveResource(EPackage root){
	    ResourceSet metaResourceSet = new ResourceSetImpl();
	    metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());
	    Resource metaResource = metaResourceSet.createResource(URI.createURI(this.pathName + this.fileName + ".ecore"));
	    metaResource.getContents().add(root);
	    try {
	        metaResource.save(null);
	    } catch (java.io.IOException e) {
	        e.printStackTrace();
	    }
	}

	public AlloyInEcoreParser(TokenStream input, String filename, String path){
	    this(input);
	    this.fileName = filename;
	    this.pathName = path;
	}

	private String fileName;
	private String pathName;

	private EcoreFactory eFactory = EcoreFactory.eINSTANCE;


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
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(128);
				options();
				}
			}

			setState(131);
			universe();
			printUniverse();
			setState(133);
			relations();
			printBounds();
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(135);
					((ProblemContext)_localctx).formula = formula(0);
					((ProblemContext)_localctx).formulas.add(((ProblemContext)_localctx).formula);
					}
					} 
				}
				setState(140);
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
			setState(144);
			match(T__0);
			setState(145);
			match(T__1);
			setState(146);
			option();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(147);
				match(T__2);
				setState(148);
				option();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
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
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				((SymmetryBreakingContext)_localctx).key = match(T__4);
				setState(157);
				match(T__5);
				setState(158);
				((SymmetryBreakingContext)_localctx).value = integer();
				}
				break;
			case T__6:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				((BitWidthContext)_localctx).key = match(T__6);
				setState(160);
				match(T__5);
				setState(161);
				((BitWidthContext)_localctx).value = integer();
				}
				break;
			case T__7:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				((SkolemDepthContext)_localctx).key = match(T__7);
				setState(163);
				match(T__5);
				setState(164);
				((SkolemDepthContext)_localctx).value = integer();
				}
				break;
			case T__8:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				((SharingContext)_localctx).key = match(T__8);
				setState(166);
				match(T__5);
				setState(167);
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
			setState(170);
			match(T__9);
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(171);
				match(T__1);
				{
				setState(172);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(173);
					match(T__2);
					setState(174);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(180);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				{
				setState(182);
				match(T__10);
				{
				setState(183);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(184);
					match(T__2);
					setState(185);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(191);
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
			setState(197);
			match(T__12);
			setState(198);
			match(T__1);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(199);
				relation();
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
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
			setState(208);
			((RelationContext)_localctx).name = ((RelationContext)_localctx).identifier = identifier();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(209);
				((RelationContext)_localctx).arity = arity();
				}
			}

			setState(212);
			match(T__5);
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(213);
				expression(0);
				}
				break;
			}
			setState(216);
			match(T__10);
			{
			setState(217);
			((RelationContext)_localctx).lowerBound = tupleSet();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(218);
				match(T__2);
				setState(219);
				((RelationContext)_localctx).upperBound = tupleSet();
				}
			}

			}
			setState(222);
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
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				match(T__1);
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
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(T__10);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10 || _la==T__14) {
					{
					setState(239);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(240);
						match(T__2);
						setState(241);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(246);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(249);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				match(T__1);
				setState(251);
				((TupleSetContext)_localctx).left = tuple();
				setState(252);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(253);
				((TupleSetContext)_localctx).right = tuple();
				setState(254);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
				match(T__10);
				setState(257);
				((TupleSetContext)_localctx).left = tuple();
				setState(258);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(259);
				((TupleSetContext)_localctx).right = tuple();
				setState(260);
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
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(T__14);
				setState(265);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(266);
					match(T__2);
					setState(267);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(273);
				match(T__15);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				match(T__10);
				setState(276);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(277);
					match(T__2);
					setState(278);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(284);
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
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(288);
				options();
				}
			}

			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(291);
				match(T__16);
				setState(292);
				identifier();
				}
			}

			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(295);
				((ModuleContext)_localctx).packageImport = packageImport();
				((ModuleContext)_localctx).ownedPackageImport.add(((ModuleContext)_localctx).packageImport);
				}
				}
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(301);
			((ModuleContext)_localctx).ownedPackage = ePackage();
			Document.getInstance().signalParsingCompletion(); saveResource(((ModuleContext)_localctx).ownedPackage.element);
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
			setState(304);
			match(T__17);
			}
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(305);
				((PackageImportContext)_localctx).name = identifier();
				setState(306);
				match(T__5);
				}
			}

			setState(310);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(311);
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
		public EPackage element;
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
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(313);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(316);
			match(T__19);
			setState(317);
			((EPackageContext)_localctx).name = unrestrictedName();
			{
			setState(318);
			match(T__5);
			setState(319);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(321);
			match(T__20);
			setState(322);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}

			    ((EPackageContext)_localctx).element =  eFactory.createEPackage();
			    _localctx.element.setName((((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null));
			    _localctx.element.setNsPrefix((((EPackageContext)_localctx).nsPrefix!=null?_input.getText(((EPackageContext)_localctx).nsPrefix.start,((EPackageContext)_localctx).nsPrefix.stop):null));
			    _localctx.element.setNsURI((((EPackageContext)_localctx).nsURI!=null?((EPackageContext)_localctx).nsURI.getText():null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(325);
				match(T__1);
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__30) | (1L << T__31) | (1L << T__55) | (1L << T__56))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__66 - 65)) | (1L << (T__74 - 65)) | (1L << (T__75 - 65)) | (1L << (T__82 - 65)) | (1L << (T__83 - 65)) | (1L << (T__84 - 65)))) != 0)) {
					{
					setState(338);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(326);
						((EPackageContext)_localctx).eAnnotation = ((EPackageContext)_localctx).eAnnotation = eAnnotation();
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(329);
						((EPackageContext)_localctx).ePackage = ((EPackageContext)_localctx).ePackage = ePackage();
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						_localctx.element.getESubpackages().add(((EPackageContext)_localctx).ePackage.element);
						}
						break;
					case 3:
						{
						setState(332);
						((EPackageContext)_localctx).eClassifier = ((EPackageContext)_localctx).eClassifier = eClassifier();
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						_localctx.element.getEClassifiers().add(((EPackageContext)_localctx).eClassifier.element);
						}
						break;
					case 4:
						{
						setState(335);
						((EPackageContext)_localctx).invariant = invariant();
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						 
						}
						break;
					}
					}
					setState(342);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(343);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(344);
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
		public EClassifier element;
		public EClassContext eClass;
		public EDataTypeContext eDataType;
		public EEnumContext eEnum;
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
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				((EClassifierContext)_localctx).eClass = eClass();
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eClass.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				((EClassifierContext)_localctx).eDataType = eDataType();
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eDataType.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(355);
				((EClassifierContext)_localctx).eEnum = eEnum();
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eEnum.element;
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
		public EClass element;
		public VisibilityKindContext visibility;
		public Token isAbstract;
		public Token isClass;
		public Token isInterface;
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TypedRefContext typedRef;
		public List<TypedRefContext> eSuperTypes = new ArrayList<TypedRefContext>();
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
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public List<TypedRefContext> typedRef() {
			return getRuleContexts(TypedRefContext.class);
		}
		public TypedRefContext typedRef(int i) {
			return getRuleContext(TypedRefContext.class,i);
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
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(360);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(368);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				{
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(363);
					((EClassContext)_localctx).isAbstract = match(T__21);
					}
				}

				setState(366);
				((EClassContext)_localctx).isClass = match(T__22);
				}
				break;
			case T__23:
				{
				setState(367);
				((EClassContext)_localctx).isInterface = match(T__23);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(370);
			((EClassContext)_localctx).name = unrestrictedName();

			    ((EClassContext)_localctx).element =  eFactory.createEClass();
			    _localctx.element.setName((((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(372);
				((EClassContext)_localctx).ownedSignature = templateSignature();
				}
			}


			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(376);
				match(T__24);
				setState(377);
				((EClassContext)_localctx).typedRef = typedRef();
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).typedRef);
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(378);
					match(T__2);
					setState(379);
					((EClassContext)_localctx).typedRef = typedRef();
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).typedRef);
					}
					}
					setState(384);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(387);
				match(T__5);
				setState(388);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			_localctx.element.setInstanceClassName((((EClassContext)_localctx).instanceClassName!=null?((EClassContext)_localctx).instanceClassName.getText():null));
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(392);
				match(T__1);
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & ((1L << (T__25 - 26)) | (1L << (T__26 - 26)) | (1L << (T__27 - 26)) | (1L << (T__28 - 26)) | (1L << (T__29 - 26)) | (1L << (T__30 - 26)) | (1L << (T__31 - 26)) | (1L << (T__32 - 26)) | (1L << (T__33 - 26)) | (1L << (T__42 - 26)) | (1L << (T__48 - 26)) | (1L << (T__66 - 26)) | (1L << (T__74 - 26)) | (1L << (T__75 - 26)) | (1L << (T__82 - 26)) | (1L << (T__83 - 26)) | (1L << (T__84 - 26)))) != 0)) {
					{
					setState(403);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						setState(393);
						((EClassContext)_localctx).eAnnotation = ((EClassContext)_localctx).eAnnotation = eAnnotation();
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(396);
						((EClassContext)_localctx).eOperation = ((EClassContext)_localctx).eOperation = eOperation();
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						_localctx.element.getEOperations().add(((EClassContext)_localctx).eOperation.element);
						}
						break;
					case 3:
						{
						setState(399);
						((EClassContext)_localctx).eStructuralFeature = ((EClassContext)_localctx).eStructuralFeature = eStructuralFeature();
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						_localctx.element.getEStructuralFeatures().add(((EClassContext)_localctx).eStructuralFeature.element);
						}
						break;
					case 4:
						{
						setState(402);
						((EClassContext)_localctx).invariant = invariant();
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(407);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(408);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(409);
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
		public EStructuralFeature element;
		public EAttributeContext eAttribute;
		public EReferenceContext eReference;
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
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(414);
				((EStructuralFeatureContext)_localctx).eAttribute = eAttribute();
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eAttribute.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(417);
				((EStructuralFeatureContext)_localctx).eReference = eReference();
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eReference.element;
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
		public EAttribute element;
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
		public TypedRefContext eAttributeType;
		public EMultiplicityContext ownedMultiplicity;
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
		public TypedRefContext typedRef() {
			return getRuleContext(TypedRefContext.class,0);
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
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(422);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(425);
				((EAttributeContext)_localctx).s26 = match(T__25);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
				}
			}

			setState(430);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(428);
				((EAttributeContext)_localctx).s27 = match(T__26);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(429);
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
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(432);
				((EAttributeContext)_localctx).s29 = match(T__28);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
				}
			}

			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(435);
				((EAttributeContext)_localctx).s30 = match(T__29);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
				}
			}

			setState(440);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(438);
				((EAttributeContext)_localctx).s31 = match(T__30);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(439);
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
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(442);
				((EAttributeContext)_localctx).s33 = match(T__32);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s33);
				}
			}

			setState(445);
			match(T__33);
			setState(446);
			((EAttributeContext)_localctx).name = unrestrictedName();

			    ((EAttributeContext)_localctx).element =  eFactory.createEAttribute();
			    _localctx.element.setName((((EAttributeContext)_localctx).name!=null?_input.getText(((EAttributeContext)_localctx).name.start,((EAttributeContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			{
			setState(448);
			match(T__5);
			setState(449);
			((EAttributeContext)_localctx).eAttributeType = typedRef();
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(450);
				((EAttributeContext)_localctx).ownedMultiplicity = eMultiplicity();
				}
			}

			}
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(453);
				match(T__20);
				setState(454);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				_localctx.element.setDefaultValueLiteral(((EAttributeContext)_localctx).defaultValue.getText().replace("'", ""));
				}
			}

			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(458);
				match(T__1);
				setState(472); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(467);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__34:
						{
						setState(459);
						((EAttributeContext)_localctx).s35 = match(T__34);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(460);
						((EAttributeContext)_localctx).s36 = match(T__35);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(461);
						((EAttributeContext)_localctx).s37 = match(T__36);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(462);
						((EAttributeContext)_localctx).s38 = match(T__37);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(463);
						((EAttributeContext)_localctx).s39 = match(T__38);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(464);
						((EAttributeContext)_localctx).s40 = match(T__39);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(465);
						((EAttributeContext)_localctx).s41 = match(T__40);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(466);
						((EAttributeContext)_localctx).s42 = match(T__41);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(470);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(469);
						match(T__2);
						}
					}

					}
					}
					setState(474); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0) );
				setState(476);
				match(T__3);
				}
				break;
			}
			Document.getInstance().setQualifiers(_localctx.element, ((EAttributeContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList()));
			setState(509);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(480);
				match(T__1);
				setState(505);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					{
					setState(486);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(481);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation();
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
						}
						}
						setState(488);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(491);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__81:
						{
						setState(489);
						((EAttributeContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__80:
						{
						setState(490);
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
					setState(495);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__81:
						{
						setState(493);
						((EAttributeContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__80:
						{
						setState(494);
						((EAttributeContext)_localctx).ownedInitial = initial();
						}
						break;
					case T__3:
					case T__66:
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(502);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(497);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation();
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
						}
						}
						setState(504);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				}
				setState(507);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(508);
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
		public EReference element;
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
		public UnrestrictedNameContext eOpposite;
		public TypedRefContext eReferenceType;
		public EMultiplicityContext ownedMultiplicity;
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
		public UnrestrictedNameContext unrestrictedName;
		public List<UnrestrictedNameContext> referredKeys = new ArrayList<UnrestrictedNameContext>();
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public DerivationContext ownedDerivation;
		public InitialContext ownedInitial;
		public List<UnrestrictedNameContext> unrestrictedName() {
			return getRuleContexts(UnrestrictedNameContext.class);
		}
		public UnrestrictedNameContext unrestrictedName(int i) {
			return getRuleContext(UnrestrictedNameContext.class,i);
		}
		public TypedRefContext typedRef() {
			return getRuleContext(TypedRefContext.class,0);
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
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(511);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(514);
				((EReferenceContext)_localctx).s26 = match(T__25);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
				}
			}

			setState(519);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(517);
				((EReferenceContext)_localctx).s27 = match(T__26);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(518);
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
			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(521);
				((EReferenceContext)_localctx).s29 = match(T__28);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
				}
			}

			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(524);
				((EReferenceContext)_localctx).s30 = match(T__29);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
				}
			}

			setState(529);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(527);
				((EReferenceContext)_localctx).s31 = match(T__30);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(528);
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
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(531);
				((EReferenceContext)_localctx).s33 = match(T__32);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s33);
				}
			}

			setState(534);
			match(T__42);
			setState(535);
			((EReferenceContext)_localctx).name = unrestrictedName();

			    ((EReferenceContext)_localctx).element =  eFactory.createEReference();
			    _localctx.element.setName((((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__43) {
				{
				setState(537);
				match(T__43);
				setState(538);
				((EReferenceContext)_localctx).eOpposite = unrestrictedName();
				}
			}

			{
			setState(541);
			match(T__5);
			setState(542);
			((EReferenceContext)_localctx).eReferenceType = typedRef();
			setState(544);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(543);
				((EReferenceContext)_localctx).ownedMultiplicity = eMultiplicity();
				}
			}

			}
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(546);
				match(T__20);
				setState(547);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				_localctx.element.setDefaultValueLiteral(((EReferenceContext)_localctx).defaultValue.getText().replace("'", ""));
				}
			}

			setState(572);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(551);
				match(T__1);
				setState(567); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(562);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__44:
						{
						setState(552);
						((EReferenceContext)_localctx).s45 = match(T__44);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s45);
						}
						break;
					case T__34:
						{
						setState(553);
						((EReferenceContext)_localctx).s35 = match(T__34);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s35);
						}
						break;
					case T__36:
						{
						setState(554);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(555);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(556);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(557);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					case T__45:
						{
						setState(558);
						((EReferenceContext)_localctx).s46 = match(T__45);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s46);
						}
						break;
					case T__46:
						{
						setState(559);
						((EReferenceContext)_localctx).s47 = match(T__46);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s47);
						}
						break;
					case T__40:
						{
						setState(560);
						((EReferenceContext)_localctx).s41 = match(T__40);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(561);
						((EReferenceContext)_localctx).s42 = match(T__41);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(565);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(564);
						match(T__2);
						}
					}

					}
					}
					setState(569); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0) );
				setState(571);
				match(T__3);
				}
				break;
			}
			Document.getInstance().setQualifiers(_localctx.element, ((EReferenceContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList()));
			setState(613);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(575);
				match(T__1);
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__47) {
					{
					setState(576);
					match(T__47);
					setState(577);
					((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(578);
						match(T__2);
						setState(579);
						((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
						}
						}
						setState(584);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(585);
					match(T__18);
					}
				}

				setState(609);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					{
					setState(592);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(589);
						((EReferenceContext)_localctx).eAnnotation = eAnnotation();
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						}
						}
						setState(594);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(597);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__81:
						{
						setState(595);
						((EReferenceContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__80:
						{
						setState(596);
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
					setState(601);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__81:
						{
						setState(599);
						((EReferenceContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__80:
						{
						setState(600);
						((EReferenceContext)_localctx).ownedInitial = initial();
						}
						break;
					case T__3:
					case T__66:
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(606);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(603);
						((EReferenceContext)_localctx).eAnnotation = eAnnotation();
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						}
						}
						setState(608);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				}
				setState(611);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(612);
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
		public EOperation element;
		public VisibilityKindContext visibility;
		public Token s26;
		public List<Token> qualifier = new ArrayList<Token>();
		public TemplateSignatureContext ownedSignature;
		public UnrestrictedNameContext name;
		public EParameterContext eParameter;
		public List<EParameterContext> eParameters = new ArrayList<EParameterContext>();
		public TypedRefContext eReturnType;
		public EMultiplicityContext ownedMultiplicity;
		public TypedRefContext typedRef;
		public List<TypedRefContext> ownedException = new ArrayList<TypedRefContext>();
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
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public List<EParameterContext> eParameter() {
			return getRuleContexts(EParameterContext.class);
		}
		public EParameterContext eParameter(int i) {
			return getRuleContext(EParameterContext.class,i);
		}
		public List<TypedRefContext> typedRef() {
			return getRuleContexts(TypedRefContext.class);
		}
		public TypedRefContext typedRef(int i) {
			return getRuleContext(TypedRefContext.class,i);
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
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(615);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(618);
				((EOperationContext)_localctx).s26 = match(T__25);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
				}
			}

			setState(621);
			match(T__48);
			setState(623);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(622);
				((EOperationContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(625);
			((EOperationContext)_localctx).name = unrestrictedName();

			    ((EOperationContext)_localctx).element =  eFactory.createEOperation();
			    _localctx.element.setName((((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(627);
			match(T__14);
			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__30 - 17)) | (1L << (T__31 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__73 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)) | (1L << (T__76 - 17)) | (1L << (T__78 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__132 - 81)) | (1L << (T__133 - 81)) | (1L << (T__134 - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(628);
				((EOperationContext)_localctx).eParameter = eParameter();
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(633);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(629);
					match(T__2);
					setState(630);
					((EOperationContext)_localctx).eParameter = eParameter();
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(635);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(638);
			match(T__15);
			for (EParameterContext ctx: ((EOperationContext)_localctx).eParameters){_localctx.element.getEParameters().add(ctx.element);}
			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(640);
				match(T__5);
				setState(641);
				((EOperationContext)_localctx).eReturnType = typedRef();
				setState(643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(642);
					((EOperationContext)_localctx).ownedMultiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__49) {
				{
				setState(647);
				match(T__49);
				setState(648);
				((EOperationContext)_localctx).typedRef = typedRef();
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).typedRef);
				setState(653);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(649);
					match(T__2);
					setState(650);
					((EOperationContext)_localctx).typedRef = typedRef();
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).typedRef);
					}
					}
					setState(655);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(673);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(658);
				match(T__1);
				setState(668); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(663);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(659);
						((EOperationContext)_localctx).s37 = match(T__36);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(660);
						((EOperationContext)_localctx).s38 = match(T__37);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(661);
						((EOperationContext)_localctx).s39 = match(T__38);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(662);
						((EOperationContext)_localctx).s40 = match(T__39);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s40);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(666);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(665);
						match(T__2);
						}
					}

					}
					}
					setState(670); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(672);
				match(T__3);
				}
				break;
			}
			setState(689);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(675);
				match(T__1);
				setState(684);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__73 - 67)) | (1L << (T__76 - 67)) | (1L << (T__77 - 67)) | (1L << (T__78 - 67)) | (1L << (T__79 - 67)))) != 0)) {
					{
					setState(682);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(676);
						((EOperationContext)_localctx).eAnnotation = ((EOperationContext)_localctx).eAnnotation = eAnnotation();
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).eAnnotation.element);
						}
						break;
					case T__76:
					case T__77:
						{
						setState(679);
						((EOperationContext)_localctx).precondition = precondition();
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						}
						break;
					case T__73:
						{
						setState(680);
						((EOperationContext)_localctx).body = body();
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						}
						break;
					case T__78:
					case T__79:
						{
						setState(681);
						((EOperationContext)_localctx).postcondition = postcondition();
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(686);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(687);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(688);
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
		public EParameter element;
		public Token s31;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s32;
		public UnrestrictedNameContext name;
		public TypedRefContext eParameterType;
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
		public TypedRefContext typedRef() {
			return getRuleContext(TypedRefContext.class,0);
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
			setState(693);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(691);
				((EParameterContext)_localctx).s31 = match(T__30);
				((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(692);
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
			case T__73:
			case T__74:
			case T__75:
			case T__76:
			case T__78:
			case T__80:
			case T__81:
			case T__132:
			case T__133:
			case T__134:
			case IDENTIFIER:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(695);
			((EParameterContext)_localctx).name = unrestrictedName();

			    ((EParameterContext)_localctx).element =  eFactory.createEParameter();
			    _localctx.element.setName((((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			{
			setState(697);
			match(T__5);
			setState(698);
			((EParameterContext)_localctx).eParameterType = typedRef();
			setState(700);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(699);
				((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity();
				}
			}

			}
			setState(717);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				{
				setState(702);
				match(T__1);
				setState(712); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(707);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(703);
						((EParameterContext)_localctx).s37 = match(T__36);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(704);
						((EParameterContext)_localctx).s38 = match(T__37);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(705);
						((EParameterContext)_localctx).s39 = match(T__38);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(706);
						((EParameterContext)_localctx).s40 = match(T__39);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s40);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(710);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(709);
						match(T__2);
						}
					}

					}
					}
					setState(714); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(716);
				match(T__3);
				}
				break;
			}
			setState(728);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(719);
				match(T__1);
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(720);
					((EParameterContext)_localctx).eAnnotation = ((EParameterContext)_localctx).eAnnotation = eAnnotation();
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(725);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EParameterContext)_localctx).eAnnotation.element);
				setState(727);
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
		enterRule(_localctx, 36, RULE_eMultiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			match(T__10);
			setState(737);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(731);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(734);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(732);
					match(T__13);
					setState(733);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__50:
			case T__51:
			case T__52:
				{
				setState(736);
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
			setState(741);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__53:
				{
				setState(739);
				match(T__53);
				}
				break;
			case T__54:
				{
				setState(740);
				((EMultiplicityContext)_localctx).isNullFree = match(T__54);
				}
				break;
			case T__11:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(743);
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
		public EDataType element;
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
		enterRule(_localctx, 38, RULE_eDataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(745);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(753);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__55:
				{
				setState(748);
				((EDataTypeContext)_localctx).s56 = match(T__55);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s56);
				}
				break;
			case T__30:
			case T__31:
				{
				setState(751);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__30:
					{
					setState(749);
					((EDataTypeContext)_localctx).s31 = match(T__30);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s31);
					}
					break;
				case T__31:
					{
					setState(750);
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
			setState(755);
			match(T__56);
			setState(756);
			((EDataTypeContext)_localctx).name = unrestrictedName();

			    ((EDataTypeContext)_localctx).element =  eFactory.createEDataType();
			    _localctx.element.setName((((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(759);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(758);
				((EDataTypeContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(761);
				match(T__5);
				setState(762);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(771);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				setState(765);
				match(T__1);
				setState(768);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(766);
					((EDataTypeContext)_localctx).s58 = match(T__57);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s58);
					}
					break;
				case T__58:
					{
					setState(767);
					((EDataTypeContext)_localctx).s59 = match(T__58);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s59);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(770);
				match(T__3);
				}
				break;
			}
			setState(785);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(773);
				match(T__1);
				setState(780);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__74 - 67)) | (1L << (T__75 - 67)))) != 0)) {
					{
					setState(778);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(774);
						((EDataTypeContext)_localctx).eAnnotation = ((EDataTypeContext)_localctx).eAnnotation = eAnnotation();
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).eAnnotation.element);
						}
						break;
					case T__74:
					case T__75:
						{
						setState(777);
						((EDataTypeContext)_localctx).invariant = invariant();
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(782);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(783);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(784);
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
		enterRule(_localctx, 40, RULE_ePrimitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
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
		public EEnum element;
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
		enterRule(_localctx, 42, RULE_eEnum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(789);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(792);
			match(T__64);
			setState(793);
			((EEnumContext)_localctx).name = unrestrictedName();

			    ((EEnumContext)_localctx).element =  eFactory.createEEnum();
			    _localctx.element.setName((((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(795);
				((EEnumContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(798);
				match(T__5);
				setState(799);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(808);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				{
				setState(802);
				match(T__1);
				setState(805);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(803);
					((EEnumContext)_localctx).s58 = match(T__57);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s58);
					}
					break;
				case T__58:
					{
					setState(804);
					((EEnumContext)_localctx).s59 = match(T__58);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s59);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(807);
				match(T__3);
				}
				break;
			}
			setState(825);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(810);
				match(T__1);
				setState(820);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__73 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)) | (1L << (T__76 - 17)) | (1L << (T__78 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__132 - 81)) | (1L << (T__133 - 81)) | (1L << (T__134 - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(818);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
					case 1:
						{
						setState(811);
						((EEnumContext)_localctx).eAnnotation = ((EEnumContext)_localctx).eAnnotation = eAnnotation();
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(814);
						((EEnumContext)_localctx).eEnumLiteral = ((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral();
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						_localctx.element.getELiterals().add(((EEnumContext)_localctx).eEnumLiteral.element);
						}
						break;
					case 3:
						{
						setState(817);
						((EEnumContext)_localctx).invariant = invariant();
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(822);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(823);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(824);
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
		public EEnumLiteral element;
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
		enterRule(_localctx, 44, RULE_eEnumLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(830);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				{
				{
				setState(827);
				match(T__65);
				setState(828);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(829);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			setState(834);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(832);
				match(T__20);
				setState(833);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}


			    ((EEnumLiteralContext)_localctx).element =  eFactory.createEEnumLiteral();
			    _localctx.element.setName((((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(847);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(837);
				match(T__1);
				setState(841);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(838);
					((EEnumLiteralContext)_localctx).eAnnotation = ((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation();
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(843);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EEnumLiteralContext)_localctx).eAnnotation.element);
				setState(845);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(846);
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
		public EAnnotation element;
		public Token source;
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
		enterRule(_localctx, 46, RULE_eAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			match(T__66);
			setState(851);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(850);
				((EAnnotationContext)_localctx).source = match(SINGLE_QUOTED_STRING);
				}
			}


				((EAnnotationContext)_localctx).element =  eFactory.createEAnnotation();
				_localctx.element.setSource((((EAnnotationContext)_localctx).source!=null?((EAnnotationContext)_localctx).source.getText():null).replace("'", "") );
				
			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(854);
				match(T__14);
				setState(855);
				((EAnnotationContext)_localctx).eDetail = eDetail();
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(860);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(856);
					match(T__2);
					setState(857);
					((EAnnotationContext)_localctx).eDetail = eDetail();
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(862);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(863);
				match(T__15);
				}
			}

			for (EDetailContext ctx: ((EAnnotationContext)_localctx).ownedDetails){_localctx.element.getDetails().put(ctx.k, ctx.v);}
				
			setState(885);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(868);
				match(T__1);
				setState(878); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(878);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
					case 1:
						{
						setState(869);
						((EAnnotationContext)_localctx).eAnnotation = ((EAnnotationContext)_localctx).eAnnotation = eAnnotation();
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAnnotationContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(872);
						((EAnnotationContext)_localctx).eModelElement = ((EAnnotationContext)_localctx).eModelElement = eModelElement();
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						_localctx.element.getContents().add(((EAnnotationContext)_localctx).eModelElement.element);
						}
						break;
					case 3:
						{
						setState(875);
						((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef();
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);

						}
						break;
					}
					}
					setState(880); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__26 - 17)) | (1L << (T__27 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__30 - 17)) | (1L << (T__31 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__73 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)) | (1L << (T__76 - 17)) | (1L << (T__78 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)) | (1L << (T__83 - 81)) | (1L << (T__84 - 81)) | (1L << (T__132 - 81)) | (1L << (T__133 - 81)) | (1L << (T__134 - 81)) | (1L << (IDENTIFIER - 81)))) != 0) );
				setState(882);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(884);
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
		public String k;
		public String v;
		public Token key;
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
		enterRule(_localctx, 48, RULE_eDetail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(888);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(887);
				((EDetailContext)_localctx).key = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(890);
			match(T__20);
			setState(892);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) {
				{
				setState(891);
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

			((EDetailContext)_localctx).k =  ((EDetailContext)_localctx).key != null ? ((EDetailContext)_localctx).key.getText().replace("'", "") : null; ((EDetailContext)_localctx).v =  ((EDetailContext)_localctx).value != null ? ((EDetailContext)_localctx).value.getText().replace("'", "") : null; 
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
		public EModelElement element;
		public EAnnotationContext eAnnotation;
		public ENamedElementContext eNamedElement;
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
		enterRule(_localctx, 50, RULE_eModelElement);
		try {
			setState(902);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(896);
				((EModelElementContext)_localctx).eAnnotation = eAnnotation();
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eAnnotation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(899);
				((EModelElementContext)_localctx).eNamedElement = eNamedElement();
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eNamedElement.element;
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
		public ENamedElement element;
		public ETypedElementContext eTypedElement;
		public EClassifierContext eClassifier;
		public EPackageContext ePackage;
		public EEnumLiteralContext eEnumLiteral;
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
		enterRule(_localctx, 52, RULE_eNamedElement);
		try {
			setState(916);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(904);
				((ENamedElementContext)_localctx).eTypedElement = eTypedElement();
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eTypedElement.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(907);
				((ENamedElementContext)_localctx).eClassifier = eClassifier();
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eClassifier.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(910);
				((ENamedElementContext)_localctx).ePackage = ePackage();
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).ePackage.element;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(913);
				((ENamedElementContext)_localctx).eEnumLiteral = eEnumLiteral();
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eEnumLiteral.element;
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
		public ETypedElement element;
		public EOperationContext eOperation;
		public EParameterContext eParameter;
		public EStructuralFeatureContext eStructuralFeature;
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
		enterRule(_localctx, 54, RULE_eTypedElement);
		try {
			setState(927);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(918);
				((ETypedElementContext)_localctx).eOperation = eOperation();
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eOperation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(921);
				((ETypedElementContext)_localctx).eParameter = eParameter();
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eParameter.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(924);
				((ETypedElementContext)_localctx).eStructuralFeature = eStructuralFeature();
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eStructuralFeature.element;
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
		public PathNameContext ownedPathName;
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
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
		enterRule(_localctx, 56, RULE_eModelElementRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(929);
			match(T__67);
			setState(930);
			((EModelElementRefContext)_localctx).ownedPathName = pathName();
			setState(931);
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
		public TypeParameterContext typeParameter;
		public List<TypeParameterContext> ownedParameters = new ArrayList<TypeParameterContext>();
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
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
		enterRule(_localctx, 58, RULE_templateSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(933);
			match(T__68);
			setState(934);
			((TemplateSignatureContext)_localctx).typeParameter = typeParameter();
			((TemplateSignatureContext)_localctx).ownedParameters.add(((TemplateSignatureContext)_localctx).typeParameter);
			setState(939);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(935);
				match(T__2);
				setState(936);
				((TemplateSignatureContext)_localctx).typeParameter = typeParameter();
				((TemplateSignatureContext)_localctx).ownedParameters.add(((TemplateSignatureContext)_localctx).typeParameter);
				}
				}
				setState(941);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(942);
			match(T__69);
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

	public static class TypeParameterContext extends ParserRuleContext {
		public UnrestrictedNameContext name;
		public TypedRefContext typedRef;
		public List<TypedRefContext> ownedExtends = new ArrayList<TypedRefContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public List<TypedRefContext> typedRef() {
			return getRuleContexts(TypedRefContext.class);
		}
		public TypedRefContext typedRef(int i) {
			return getRuleContext(TypedRefContext.class,i);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(944);
			((TypeParameterContext)_localctx).name = unrestrictedName();
			setState(954);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(945);
				match(T__24);
				setState(946);
				((TypeParameterContext)_localctx).typedRef = typedRef();
				((TypeParameterContext)_localctx).ownedExtends.add(((TypeParameterContext)_localctx).typedRef);
				setState(951);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__70) {
					{
					{
					setState(947);
					match(T__70);
					setState(948);
					((TypeParameterContext)_localctx).typedRef = typedRef();
					((TypeParameterContext)_localctx).ownedExtends.add(((TypeParameterContext)_localctx).typedRef);
					}
					}
					setState(953);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class TypeRefContext extends ParserRuleContext {
		public TypedRefContext typedRef() {
			return getRuleContext(TypedRefContext.class,0);
		}
		public WildcardTypeRefContext wildcardTypeRef() {
			return getRuleContext(WildcardTypeRefContext.class,0);
		}
		public TypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTypeRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRefContext typeRef() throws RecognitionException {
		TypeRefContext _localctx = new TypeRefContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_typeRef);
		try {
			setState(958);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
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
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__64:
			case T__65:
			case T__66:
			case T__67:
			case T__73:
			case T__74:
			case T__75:
			case T__76:
			case T__78:
			case T__80:
			case T__81:
			case T__132:
			case T__133:
			case T__134:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(956);
				typedRef();
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 2);
				{
				setState(957);
				wildcardTypeRef();
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

	public static class TypedRefContext extends ParserRuleContext {
		public EPrimitiveTypeContext ePrimitiveType() {
			return getRuleContext(EPrimitiveTypeContext.class,0);
		}
		public TypedTypeRefContext typedTypeRef() {
			return getRuleContext(TypedTypeRefContext.class,0);
		}
		public TypedRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTypedRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTypedRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTypedRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedRefContext typedRef() throws RecognitionException {
		TypedRefContext _localctx = new TypedRefContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_typedRef);
		try {
			setState(962);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
				enterOuterAlt(_localctx, 1);
				{
				setState(960);
				ePrimitiveType();
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
			case T__73:
			case T__74:
			case T__75:
			case T__76:
			case T__78:
			case T__80:
			case T__81:
			case T__132:
			case T__133:
			case T__134:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(961);
				typedTypeRef();
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

	public static class TypedTypeRefContext extends ParserRuleContext {
		public PathNameContext ownedPathName;
		public TemplateBindingContext ownedBinding;
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public TemplateBindingContext templateBinding() {
			return getRuleContext(TemplateBindingContext.class,0);
		}
		public TypedTypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedTypeRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTypedTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTypedTypeRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTypedTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedTypeRefContext typedTypeRef() throws RecognitionException {
		TypedTypeRefContext _localctx = new TypedTypeRefContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_typedTypeRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(964);
			((TypedTypeRefContext)_localctx).ownedPathName = pathName();
			setState(969);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(965);
				match(T__68);
				setState(966);
				((TypedTypeRefContext)_localctx).ownedBinding = templateBinding();
				setState(967);
				match(T__69);
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

	public static class WildcardTypeRefContext extends ParserRuleContext {
		public TypedRefContext ownedExtends;
		public TypedRefContext typedRef() {
			return getRuleContext(TypedRefContext.class,0);
		}
		public WildcardTypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardTypeRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterWildcardTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitWildcardTypeRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitWildcardTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildcardTypeRefContext wildcardTypeRef() throws RecognitionException {
		WildcardTypeRefContext _localctx = new WildcardTypeRefContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_wildcardTypeRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(971);
			match(T__52);
			setState(974);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24 || _la==T__71) {
				{
				setState(972);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__71) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(973);
				((WildcardTypeRefContext)_localctx).ownedExtends = typedRef();
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

	public static class TemplateBindingContext extends ParserRuleContext {
		public TemplateParameterSubstitutionContext templateParameterSubstitution;
		public List<TemplateParameterSubstitutionContext> ownedSubstitutions = new ArrayList<TemplateParameterSubstitutionContext>();
		public EMultiplicityContext ownedMultiplicity;
		public List<TemplateParameterSubstitutionContext> templateParameterSubstitution() {
			return getRuleContexts(TemplateParameterSubstitutionContext.class);
		}
		public TemplateParameterSubstitutionContext templateParameterSubstitution(int i) {
			return getRuleContext(TemplateParameterSubstitutionContext.class,i);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public TemplateBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTemplateBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTemplateBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTemplateBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateBindingContext templateBinding() throws RecognitionException {
		TemplateBindingContext _localctx = new TemplateBindingContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_templateBinding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(976);
			((TemplateBindingContext)_localctx).templateParameterSubstitution = templateParameterSubstitution();
			((TemplateBindingContext)_localctx).ownedSubstitutions.add(((TemplateBindingContext)_localctx).templateParameterSubstitution);
			setState(981);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(977);
				match(T__2);
				setState(978);
				((TemplateBindingContext)_localctx).templateParameterSubstitution = templateParameterSubstitution();
				((TemplateBindingContext)_localctx).ownedSubstitutions.add(((TemplateBindingContext)_localctx).templateParameterSubstitution);
				}
				}
				setState(983);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(985);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(984);
				((TemplateBindingContext)_localctx).ownedMultiplicity = eMultiplicity();
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

	public static class TemplateParameterSubstitutionContext extends ParserRuleContext {
		public TypeRefContext ownedActualParameter;
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public TemplateParameterSubstitutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateParameterSubstitution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTemplateParameterSubstitution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTemplateParameterSubstitution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTemplateParameterSubstitution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateParameterSubstitutionContext templateParameterSubstitution() throws RecognitionException {
		TemplateParameterSubstitutionContext _localctx = new TemplateParameterSubstitutionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_templateParameterSubstitution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(987);
			((TemplateParameterSubstitutionContext)_localctx).ownedActualParameter = typeRef();
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

	public static class PathNameContext extends ParserRuleContext {
		public UnrestrictedNameContext unrestrictedName;
		public List<UnrestrictedNameContext> ownedPathElements = new ArrayList<UnrestrictedNameContext>();
		public List<UnrestrictedNameContext> unrestrictedName() {
			return getRuleContexts(UnrestrictedNameContext.class);
		}
		public UnrestrictedNameContext unrestrictedName(int i) {
			return getRuleContext(UnrestrictedNameContext.class,i);
		}
		public PathNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPathName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPathName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPathName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathNameContext pathName() throws RecognitionException {
		PathNameContext _localctx = new PathNameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_pathName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(989);
			((PathNameContext)_localctx).unrestrictedName = unrestrictedName();
			((PathNameContext)_localctx).ownedPathElements.add(((PathNameContext)_localctx).unrestrictedName);
			setState(994);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__72) {
				{
				{
				setState(990);
				match(T__72);
				setState(991);
				((PathNameContext)_localctx).unrestrictedName = unrestrictedName();
				((PathNameContext)_localctx).ownedPathElements.add(((PathNameContext)_localctx).unrestrictedName);
				}
				}
				setState(996);
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
		enterRule(_localctx, 76, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(997);
			match(T__73);
			setState(999);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(998);
				((BodyContext)_localctx).name = identifier();
				}
			}

			setState(1007);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1001);
				match(T__5);
				setState(1003);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
				case 1:
					{
					setState(1002);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1005);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1006);
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
		enterRule(_localctx, 78, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1010);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__74) {
				{
				setState(1009);
				((InvariantContext)_localctx).isCallable = match(T__74);
				}
			}

			setState(1012);
			match(T__75);
			setState(1019);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1013);
				((InvariantContext)_localctx).name = identifier();
				setState(1017);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1014);
					match(T__14);
					setState(1015);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1016);
					match(T__15);
					}
				}

				}
			}

			setState(1027);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1021);
				match(T__5);
				setState(1023);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1022);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1025);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1026);
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
		enterRule(_localctx, 80, RULE_precondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			_la = _input.LA(1);
			if ( !(_la==T__76 || _la==T__77) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1036);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1030);
				((PreconditionContext)_localctx).name = identifier();
				setState(1034);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1031);
					match(T__14);
					setState(1032);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1033);
					match(T__15);
					}
				}

				}
			}

			setState(1044);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1038);
				match(T__5);
				setState(1040);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
				case 1:
					{
					setState(1039);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1042);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1043);
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
		enterRule(_localctx, 82, RULE_postcondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1046);
			_la = _input.LA(1);
			if ( !(_la==T__78 || _la==T__79) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1053);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1047);
				((PostconditionContext)_localctx).name = identifier();
				setState(1051);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1048);
					match(T__14);
					setState(1049);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1050);
					match(T__15);
					}
				}

				}
			}

			setState(1061);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1055);
				match(T__5);
				setState(1057);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
				case 1:
					{
					setState(1056);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1059);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1060);
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
		enterRule(_localctx, 84, RULE_initial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1063);
			match(T__80);
			setState(1065);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1064);
				((InitialContext)_localctx).name = identifier();
				}
			}

			setState(1073);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1067);
				match(T__5);
				setState(1069);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
				case 1:
					{
					setState(1068);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1071);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1072);
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
		enterRule(_localctx, 86, RULE_derivation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1075);
			match(T__81);
			setState(1077);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1076);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			setState(1085);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1079);
				match(T__5);
				setState(1081);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
				case 1:
					{
					setState(1080);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1083);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1084);
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
		enterRule(_localctx, 88, RULE_visibilityKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1087);
			_la = _input.LA(1);
			if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) ) {
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
		enterRule(_localctx, 90, RULE_atom);
		try {
			setState(1092);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1089);
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
				setState(1091);
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
		enterRule(_localctx, 92, RULE_arity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1094);
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
		int _startState = 94;
		enterRecursionRule(_localctx, 94, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1097);
				match(T__85);
				setState(1098);
				expression(0);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1099);
				match(T__86);
				setState(1100);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1101);
				match(T__87);
				setState(1102);
				expression(0);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1103);
				match(T__88);
				setState(1104);
				expression(0);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1105);
				((InContext)_localctx).left = expression(0);
				setState(1107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1106);
					((InContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((InContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1109);
				match(T__91);
				setState(1110);
				((InContext)_localctx).right = expression(0);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1112);
				((EqualContext)_localctx).left = expression(0);
				setState(1114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1113);
					((EqualContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((EqualContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1116);
				match(T__20);
				setState(1117);
				((EqualContext)_localctx).right = expression(0);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1119);
				((EqContext)_localctx).ileft = intexpression(0);
				setState(1121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1120);
					((EqContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((EqContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1123);
				match(T__20);
				setState(1124);
				((EqContext)_localctx).iright = intexpression(0);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1126);
				((LtContext)_localctx).ileft = intexpression(0);
				setState(1128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1127);
					((LtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((LtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1130);
				match(T__68);
				setState(1131);
				((LtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1133);
				((LteContext)_localctx).ileft = intexpression(0);
				setState(1135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1134);
					((LteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((LteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1137);
				match(T__92);
				setState(1138);
				((LteContext)_localctx).iright = intexpression(0);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1140);
				((GtContext)_localctx).ileft = intexpression(0);
				setState(1142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1141);
					((GtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((GtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1144);
				match(T__69);
				setState(1145);
				((GtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1147);
				((GteContext)_localctx).ileft = intexpression(0);
				setState(1149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1148);
					((GteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__89 || _la==T__90) ) {
						((GteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1151);
				match(T__93);
				setState(1152);
				((GteContext)_localctx).iright = intexpression(0);
				}
				break;
			case 12:
				{
				_localctx = new SumDeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(47)).var =  0;
				{
				setState(1155);
				match(T__94);
				setState(1156);
				decls();
				setState(1157);
				match(T__95);
				setState(1158);
				intexpression(0);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(47)).var; i++) declarations.pop();
				}
				break;
			case 13:
				{
				_localctx = new AcyclicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1162);
				match(T__96);
				setState(1163);
				match(T__10);
				setState(1164);
				relationId();
				setState(1165);
				match(T__11);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1167);
				match(T__97);
				setState(1168);
				match(T__10);
				setState(1169);
				((FunctionContext)_localctx).rel = relationId();
				setState(1170);
				match(T__5);
				setState(1171);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1172);
				match(T__98);
				setState(1173);
				((FunctionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__86 || _la==T__87) ) {
					((FunctionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1174);
				((FunctionContext)_localctx).range = expression(0);
				setState(1175);
				match(T__11);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1177);
				match(T__99);
				setState(1178);
				match(T__10);
				setState(1179);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1180);
				match(T__2);
				setState(1181);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1182);
				match(T__2);
				setState(1183);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1184);
				match(T__2);
				setState(1185);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1186);
				match(T__11);
				}
				break;
			case 16:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1188);
				((NotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__89 || _la==T__90) ) {
					((NotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1189);
				formula(14);
				}
				break;
			case 17:
				{
				_localctx = new ForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(47)).var =  0;
				{
				setState(1191);
				match(T__108);
				setState(1192);
				decls();
				setState(1213);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1193);
					match(T__95);
					setState(1203);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
					case 1:
						{
						setState(1194);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1195);
						match(T__1);
						setState(1199);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
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
							_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
						}
						setState(1202);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1205);
					match(T__1);
					setState(1209);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,182,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1206);
							formula(0);
							}
							} 
						}
						setState(1211);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,182,_ctx);
					}
					setState(1212);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(47)).var; i++) declarations.pop();
				}
				break;
			case 18:
				{
				_localctx = new ForSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(47)).var =  0;
				{
				setState(1218);
				match(T__88);
				setState(1219);
				decls();
				setState(1240);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1220);
					match(T__95);
					setState(1230);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
					case 1:
						{
						setState(1221);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1222);
						match(T__1);
						setState(1226);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
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
							_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
						}
						setState(1229);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1232);
					match(T__1);
					setState(1236);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1233);
							formula(0);
							}
							} 
						}
						setState(1238);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
					}
					setState(1239);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(47)).var; i++) declarations.pop();
				}
				break;
			case 19:
				{
				_localctx = new ForNoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(47)).var =  0;
				{
				setState(1245);
				match(T__85);
				setState(1246);
				decls();
				setState(1267);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1247);
					match(T__95);
					setState(1257);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
					case 1:
						{
						setState(1248);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1249);
						match(T__1);
						setState(1253);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1250);
								formula(0);
								}
								} 
							}
							setState(1255);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
						}
						setState(1256);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1259);
					match(T__1);
					setState(1263);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1260);
							formula(0);
							}
							} 
						}
						setState(1265);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
					}
					setState(1266);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(47)).var; i++) declarations.pop();
				}
				break;
			case 20:
				{
				_localctx = new ForOneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(47)).var =  0;
				{
				setState(1272);
				match(T__87);
				setState(1273);
				decls();
				setState(1294);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1274);
					match(T__95);
					setState(1284);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
					case 1:
						{
						setState(1275);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1276);
						match(T__1);
						setState(1280);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,192,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1277);
								formula(0);
								}
								} 
							}
							setState(1282);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,192,_ctx);
						}
						setState(1283);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1286);
					match(T__1);
					setState(1290);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1287);
							formula(0);
							}
							} 
						}
						setState(1292);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
					}
					setState(1293);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(47)).var; i++) declarations.pop();
				}
				break;
			case 21:
				{
				_localctx = new ForLoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(47)).var =  0;
				{
				setState(1299);
				match(T__86);
				setState(1300);
				decls();
				setState(1321);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1301);
					match(T__95);
					setState(1311);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
					case 1:
						{
						setState(1302);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1303);
						match(T__1);
						setState(1307);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,196,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1304);
								formula(0);
								}
								} 
							}
							setState(1309);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,196,_ctx);
						}
						setState(1310);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1313);
					match(T__1);
					setState(1317);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1314);
							formula(0);
							}
							} 
						}
						setState(1319);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
					}
					setState(1320);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(47)).var; i++) declarations.pop();
				}
				break;
			case 22:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(47)).var =  0;
				{
				setState(1326);
				match(T__109);
				setState(1327);
				letDecls();
				setState(1348);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1328);
					match(T__95);
					setState(1338);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
					case 1:
						{
						setState(1329);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1330);
						match(T__1);
						setState(1334);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1331);
								formula(0);
								}
								} 
							}
							setState(1336);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
						}
						setState(1337);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1340);
					match(T__1);
					setState(1344);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1341);
							formula(0);
							}
							} 
						}
						setState(1346);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
					}
					setState(1347);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(47)).var; i++) declarations.pop();
				}
				break;
			case 23:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1352);
				match(T__110);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1353);
				match(T__111);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1354);
				match(T__14);
				setState(1355);
				formula(0);
				setState(1356);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1374);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1372);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1360);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1361);
						((AndContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__100 || _la==T__101) ) {
							((AndContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1362);
						((AndContext)_localctx).fright = formula(13);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1363);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1364);
						((OrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__102 || _la==T__103) ) {
							((OrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1365);
						((OrContext)_localctx).fright = formula(12);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1366);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1367);
						((ImpliesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__104 || _la==T__105) ) {
							((ImpliesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1368);
						((ImpliesContext)_localctx).fright = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1369);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1370);
						((IffContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__106 || _la==T__107) ) {
							((IffContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1371);
						((IffContext)_localctx).fright = formula(10);
						}
						break;
					}
					} 
				}
				setState(1376);
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
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
			case 1:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1378);
				match(T__112);
				setState(1379);
				expression(19);
				}
				break;
			case 2:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1380);
				match(T__113);
				setState(1381);
				expression(18);
				}
				break;
			case 3:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1382);
				match(T__50);
				setState(1383);
				expression(17);
				}
				break;
			case 4:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(47)).var =  0;
				{
				setState(1385);
				match(T__1);
				setState(1386);
				comprehensionDecls();
				setState(1387);
				match(T__95);
				setState(1388);
				formula(0);
				setState(1389);
				match(T__3);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(47)).var; i++) declarations.pop();
				}
				break;
			case 5:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1393);
				((IfExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__104 || _la==T__105) ) {
					((IfExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1394);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1395);
				match(T__118);
				setState(1396);
				((IfExpressionContext)_localctx).thenExpr = expression(0);
				setState(1397);
				match(T__119);
				setState(1398);
				((IfExpressionContext)_localctx).elseExpr = expression(8);
				}
				break;
			case 6:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1400);
				match(T__120);
				}
				break;
			case 7:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1401);
				match(T__121);
				}
				break;
			case 8:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1402);
				match(T__122);
				}
				break;
			case 9:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1403);
				match(T__123);
				}
				break;
			case 10:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1404);
				match(T__14);
				setState(1405);
				expression(0);
				setState(1406);
				match(T__15);
				}
				break;
			case 11:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1408);
				if (!(!isRelation())) throw new FailedPredicateException(this, "!isRelation()");
				setState(1409);
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
				setState(1412);
				if (!(isRelation())) throw new FailedPredicateException(this, "isRelation()");
				setState(1413);
				relationId();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1447);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1445);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1416);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1417);
						match(T__51);
						setState(1418);
						((UnionContext)_localctx).right = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1419);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1420);
						match(T__70);
						setState(1421);
						((IntersectionContext)_localctx).right = expression(16);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1422);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1423);
						match(T__114);
						setState(1424);
						((DifferenceContext)_localctx).right = expression(15);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1425);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1426);
						match(T__115);
						setState(1427);
						((JoinContext)_localctx).right = expression(14);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1428);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1430);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__116 - 87)))) != 0)) {
							{
							setState(1429);
							((ProductContext)_localctx).leftMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__116 - 87)))) != 0)) ) {
								((ProductContext)_localctx).leftMult = (Token)_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
						}

						setState(1432);
						match(T__98);
						setState(1434);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
						case 1:
							{
							setState(1433);
							((ProductContext)_localctx).rightMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__116 - 87)))) != 0)) ) {
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
						setState(1436);
						((ProductContext)_localctx).right = expression(11);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1437);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1438);
						match(T__117);
						setState(1439);
						((OverrideContext)_localctx).right = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BoxjoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxjoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1440);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1441);
						match(T__10);
						setState(1442);
						((BoxjoinContext)_localctx).left = expression(0);
						setState(1443);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(1449);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
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
		int _startState = 98;
		enterRecursionRule(_localctx, 98, RULE_intexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1470);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__104:
			case T__105:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1451);
				((IfIntExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__104 || _la==T__105) ) {
					((IfIntExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1452);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1453);
				match(T__118);
				setState(1454);
				((IfIntExpressionContext)_localctx).thenExpr = intexpression(0);
				setState(1455);
				match(T__119);
				setState(1456);
				((IfIntExpressionContext)_localctx).elseExpr = intexpression(10);
				}
				break;
			case T__94:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1458);
				match(T__94);
				setState(1459);
				expression(0);
				}
				break;
			case T__43:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1460);
				match(T__43);
				setState(1461);
				expression(0);
				}
				break;
			case T__114:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__114) {
					{
					setState(1462);
					((IntConstantContext)_localctx).sign = match(T__114);
					}
				}

				setState(1465);
				integer();
				}
				break;
			case T__14:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1466);
				match(T__14);
				setState(1467);
				intexpression(0);
				setState(1468);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1489);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1487);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntexpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1472);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1473);
						_la = _input.LA(1);
						if ( !(_la==T__51 || _la==T__124) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1474);
						((PlusContext)_localctx).iright = intexpression(8);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntexpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1475);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1476);
						_la = _input.LA(1);
						if ( !(_la==T__114 || _la==T__125) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1477);
						((MinusContext)_localctx).iright = intexpression(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntexpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1478);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1479);
						_la = _input.LA(1);
						if ( !(_la==T__50 || _la==T__126) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1480);
						((MultiplyContext)_localctx).iright = intexpression(6);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntexpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1481);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1482);
						_la = _input.LA(1);
						if ( !(_la==T__127 || _la==T__128) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1483);
						((DivideContext)_localctx).iright = intexpression(5);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntexpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1484);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1485);
						_la = _input.LA(1);
						if ( !(_la==T__129 || _la==T__130) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1486);
						((ModuloContext)_localctx).iright = intexpression(4);
						}
						break;
					}
					} 
				}
				setState(1491);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
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
		enterRule(_localctx, 100, RULE_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1492);
			decl();
			setState(1497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1493);
				match(T__2);
				setState(1494);
				decl();
				}
				}
				setState(1499);
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
		enterRule(_localctx, 102, RULE_decl);
		int _la;
		try {
			setState(1566);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,226,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1501);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1500);
					((OneOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1503);
				((OneOfContext)_localctx).variableId = variableId();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
				setState(1508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1504);
					match(T__2);
					setState(1505);
					((OneOfContext)_localctx).variableId = variableId();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
					}
					}
					setState(1510);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1511);
				match(T__5);
				setState(1513);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
				case 1:
					{
					setState(1512);
					match(T__87);
					}
					break;
				}
				setState(1515);
				expression(0);
				((FormulaContext)getInvokingContext(47)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(47)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1518);
					((LoneOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1521);
				((LoneOfContext)_localctx).variableId = variableId();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
				setState(1526);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1522);
					match(T__2);
					setState(1523);
					((LoneOfContext)_localctx).variableId = variableId();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
					}
					}
					setState(1528);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1529);
				match(T__5);
				setState(1530);
				match(T__86);
				setState(1531);
				expression(0);
				((FormulaContext)getInvokingContext(47)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(47)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1535);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1534);
					((SomeOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1537);
				((SomeOfContext)_localctx).variableId = variableId();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
				setState(1542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1538);
					match(T__2);
					setState(1539);
					((SomeOfContext)_localctx).variableId = variableId();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
					}
					}
					setState(1544);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1545);
				match(T__5);
				setState(1546);
				match(T__88);
				setState(1547);
				expression(0);
				((FormulaContext)getInvokingContext(47)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(47)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1551);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1550);
					((SetOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1553);
				((SetOfContext)_localctx).variableId = variableId();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
				setState(1558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1554);
					match(T__2);
					setState(1555);
					((SetOfContext)_localctx).variableId = variableId();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
					}
					}
					setState(1560);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1561);
				match(T__5);
				setState(1562);
				match(T__116);
				setState(1563);
				expression(0);
				((FormulaContext)getInvokingContext(47)).var =  declareVariables(((SetOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(47)).var);
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
		enterRule(_localctx, 104, RULE_letDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1568);
			letDecl();
			setState(1573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1569);
				match(T__2);
				setState(1570);
				letDecl();
				}
				}
				setState(1575);
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
		enterRule(_localctx, 106, RULE_letDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1576);
			((LetDeclContext)_localctx).variableId = variableId();
			((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
			setState(1581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1577);
				match(T__2);
				setState(1578);
				((LetDeclContext)_localctx).variableId = variableId();
				((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
				}
				}
				setState(1583);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1584);
			match(T__20);
			setState(1585);
			expression(0);
			}
			((FormulaContext)getInvokingContext(47)).var =  declareVariables(((LetDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(47)).var);
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
		enterRule(_localctx, 108, RULE_comprehensionDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1589);
			comprehensionDecl();
			setState(1594);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1590);
				match(T__2);
				setState(1591);
				comprehensionDecl();
				}
				}
				setState(1596);
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
		enterRule(_localctx, 110, RULE_comprehensionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1598);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__131) {
				{
				setState(1597);
				((ComprehensionDeclContext)_localctx).disj = match(T__131);
				}
			}

			{
			setState(1600);
			((ComprehensionDeclContext)_localctx).variableId = variableId();
			((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
			setState(1605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1601);
				match(T__2);
				setState(1602);
				((ComprehensionDeclContext)_localctx).variableId = variableId();
				((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
				}
				}
				setState(1607);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1608);
			match(T__5);
			setState(1610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
			case 1:
				{
				setState(1609);
				match(T__87);
				}
				break;
			}
			setState(1612);
			expression(0);
			}
			((FormulaContext)getInvokingContext(47)).var =  declareVariables(((ComprehensionDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(47)).var);
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
		enterRule(_localctx, 112, RULE_relationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1616);
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
		enterRule(_localctx, 114, RULE_variableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1618);
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
		enterRule(_localctx, 116, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1620);
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
		enterRule(_localctx, 118, RULE_unrestrictedName);
		try {
			setState(1663);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1622);
				identifier();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(1623);
				match(T__21);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 3);
				{
				setState(1624);
				match(T__33);
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 4);
				{
				setState(1625);
				match(T__73);
				}
				break;
			case T__74:
				enterOuterAlt(_localctx, 5);
				{
				setState(1626);
				match(T__74);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 6);
				{
				setState(1627);
				match(T__22);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 7);
				{
				setState(1628);
				match(T__44);
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 8);
				{
				setState(1629);
				match(T__56);
				}
				break;
			case T__132:
				enterOuterAlt(_localctx, 9);
				{
				setState(1630);
				match(T__132);
				}
				break;
			case T__81:
				enterOuterAlt(_localctx, 10);
				{
				setState(1631);
				match(T__81);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 11);
				{
				setState(1632);
				match(T__34);
				}
				break;
			case T__64:
				enterOuterAlt(_localctx, 12);
				{
				setState(1633);
				match(T__64);
				}
				break;
			case T__133:
				enterOuterAlt(_localctx, 13);
				{
				setState(1634);
				match(T__133);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 14);
				{
				setState(1635);
				match(T__24);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 15);
				{
				setState(1636);
				match(T__35);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 16);
				{
				setState(1637);
				match(T__17);
				}
				break;
			case T__80:
				enterOuterAlt(_localctx, 17);
				{
				setState(1638);
				match(T__80);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 18);
				{
				setState(1639);
				match(T__23);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 19);
				{
				setState(1640);
				match(T__47);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 20);
				{
				setState(1641);
				match(T__16);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 21);
				{
				setState(1642);
				match(T__48);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 22);
				{
				setState(1643);
				match(T__36);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 23);
				{
				setState(1644);
				match(T__19);
				}
				break;
			case T__78:
				enterOuterAlt(_localctx, 24);
				{
				setState(1645);
				match(T__78);
				}
				break;
			case T__76:
				enterOuterAlt(_localctx, 25);
				{
				setState(1646);
				match(T__76);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 26);
				{
				setState(1647);
				match(T__55);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 27);
				{
				setState(1648);
				match(T__42);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 28);
				{
				setState(1649);
				match(T__32);
				}
				break;
			case T__67:
				enterOuterAlt(_localctx, 29);
				{
				setState(1650);
				match(T__67);
				}
				break;
			case T__134:
				enterOuterAlt(_localctx, 30);
				{
				setState(1651);
				match(T__134);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 31);
				{
				setState(1652);
				match(T__45);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 32);
				{
				setState(1653);
				match(T__25);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 33);
				{
				setState(1654);
				match(T__49);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 34);
				{
				setState(1655);
				match(T__28);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 35);
				{
				setState(1656);
				match(T__38);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 36);
				{
				setState(1657);
				match(T__40);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 37);
				{
				setState(1658);
				match(T__29);
				}
				break;
			case T__75:
				enterOuterAlt(_localctx, 38);
				{
				setState(1659);
				match(T__75);
				}
				break;
			case T__65:
				enterOuterAlt(_localctx, 39);
				{
				setState(1660);
				match(T__65);
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 40);
				{
				setState(1661);
				match(T__57);
				}
				break;
			case T__66:
				enterOuterAlt(_localctx, 41);
				{
				setState(1662);
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
		enterRule(_localctx, 120, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1665);
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
		enterRule(_localctx, 122, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1667);
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
		enterRule(_localctx, 124, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1669);
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
		enterRule(_localctx, 126, RULE_signed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1672);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__114) {
				{
				setState(1671);
				match(T__114);
				}
			}

			setState(1674);
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
		case 47:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 48:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 49:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0091\u068f\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\5\2\u0084\n\2\3\2\3\2\3\2\3\2\3\2\7\2\u008b"+
		"\n\2\f\2\16\2\u008e\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\u0098\n\3"+
		"\f\3\16\3\u009b\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\u00ab\n\4\3\5\3\5\3\5\3\5\3\5\7\5\u00b2\n\5\f\5\16\5\u00b5"+
		"\13\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00bd\n\5\f\5\16\5\u00c0\13\5\3\5\3"+
		"\5\5\5\u00c4\n\5\3\5\3\5\3\6\3\6\3\6\7\6\u00cb\n\6\f\6\16\6\u00ce\13\6"+
		"\3\6\3\6\3\6\3\7\3\7\5\7\u00d5\n\7\3\7\3\7\5\7\u00d9\n\7\3\7\3\7\3\7\3"+
		"\7\5\7\u00df\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00e9\n\b\f\b\16"+
		"\b\u00ec\13\b\5\b\u00ee\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u00f5\n\b\f\b\16\b"+
		"\u00f8\13\b\5\b\u00fa\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\b\u0109\n\b\3\t\3\t\3\t\3\t\7\t\u010f\n\t\f\t\16\t\u0112\13"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u011a\n\t\f\t\16\t\u011d\13\t\3\t\3\t\5"+
		"\t\u0121\n\t\3\n\5\n\u0124\n\n\3\n\3\n\5\n\u0128\n\n\3\n\7\n\u012b\n\n"+
		"\f\n\16\n\u012e\13\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u0137\n\13\3"+
		"\13\3\13\3\13\3\f\5\f\u013d\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0155\n\f\f\f\16"+
		"\f\u0158\13\f\3\f\3\f\5\f\u015c\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u0169\n\r\3\16\5\16\u016c\n\16\3\16\5\16\u016f\n\16\3\16"+
		"\3\16\5\16\u0173\n\16\3\16\3\16\3\16\5\16\u0178\n\16\3\16\3\16\3\16\3"+
		"\16\3\16\7\16\u017f\n\16\f\16\16\16\u0182\13\16\5\16\u0184\n\16\3\16\3"+
		"\16\5\16\u0188\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u0196\n\16\f\16\16\16\u0199\13\16\3\16\3\16\5\16\u019d"+
		"\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u01a7\n\17\3\20\5\20"+
		"\u01aa\n\20\3\20\5\20\u01ad\n\20\3\20\3\20\5\20\u01b1\n\20\3\20\5\20\u01b4"+
		"\n\20\3\20\5\20\u01b7\n\20\3\20\3\20\5\20\u01bb\n\20\3\20\5\20\u01be\n"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01c6\n\20\3\20\3\20\3\20\5\20"+
		"\u01cb\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01d6\n"+
		"\20\3\20\5\20\u01d9\n\20\6\20\u01db\n\20\r\20\16\20\u01dc\3\20\5\20\u01e0"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\7\20\u01e7\n\20\f\20\16\20\u01ea\13\20"+
		"\3\20\3\20\5\20\u01ee\n\20\3\20\3\20\5\20\u01f2\n\20\3\20\3\20\3\20\7"+
		"\20\u01f7\n\20\f\20\16\20\u01fa\13\20\5\20\u01fc\n\20\3\20\3\20\5\20\u0200"+
		"\n\20\3\21\5\21\u0203\n\21\3\21\5\21\u0206\n\21\3\21\3\21\5\21\u020a\n"+
		"\21\3\21\5\21\u020d\n\21\3\21\5\21\u0210\n\21\3\21\3\21\5\21\u0214\n\21"+
		"\3\21\5\21\u0217\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u021e\n\21\3\21\3"+
		"\21\3\21\5\21\u0223\n\21\3\21\3\21\3\21\5\21\u0228\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0235\n\21\3\21\5\21\u0238"+
		"\n\21\6\21\u023a\n\21\r\21\16\21\u023b\3\21\5\21\u023f\n\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\7\21\u0247\n\21\f\21\16\21\u024a\13\21\3\21\3\21"+
		"\5\21\u024e\n\21\3\21\7\21\u0251\n\21\f\21\16\21\u0254\13\21\3\21\3\21"+
		"\5\21\u0258\n\21\3\21\3\21\5\21\u025c\n\21\3\21\7\21\u025f\n\21\f\21\16"+
		"\21\u0262\13\21\5\21\u0264\n\21\3\21\3\21\5\21\u0268\n\21\3\22\5\22\u026b"+
		"\n\22\3\22\5\22\u026e\n\22\3\22\3\22\5\22\u0272\n\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\7\22\u027a\n\22\f\22\16\22\u027d\13\22\5\22\u027f\n\22\3"+
		"\22\3\22\3\22\3\22\3\22\5\22\u0286\n\22\5\22\u0288\n\22\3\22\3\22\3\22"+
		"\3\22\7\22\u028e\n\22\f\22\16\22\u0291\13\22\5\22\u0293\n\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u029a\n\22\3\22\5\22\u029d\n\22\6\22\u029f\n\22\r"+
		"\22\16\22\u02a0\3\22\5\22\u02a4\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\7\22\u02ad\n\22\f\22\16\22\u02b0\13\22\3\22\3\22\5\22\u02b4\n\22\3\23"+
		"\3\23\5\23\u02b8\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u02bf\n\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u02c6\n\23\3\23\5\23\u02c9\n\23\6\23\u02cb\n\23"+
		"\r\23\16\23\u02cc\3\23\5\23\u02d0\n\23\3\23\3\23\7\23\u02d4\n\23\f\23"+
		"\16\23\u02d7\13\23\3\23\3\23\5\23\u02db\n\23\3\24\3\24\3\24\3\24\5\24"+
		"\u02e1\n\24\3\24\5\24\u02e4\n\24\3\24\3\24\5\24\u02e8\n\24\3\24\3\24\3"+
		"\25\5\25\u02ed\n\25\3\25\3\25\3\25\5\25\u02f2\n\25\5\25\u02f4\n\25\3\25"+
		"\3\25\3\25\3\25\5\25\u02fa\n\25\3\25\3\25\5\25\u02fe\n\25\3\25\3\25\3"+
		"\25\5\25\u0303\n\25\3\25\5\25\u0306\n\25\3\25\3\25\3\25\3\25\3\25\7\25"+
		"\u030d\n\25\f\25\16\25\u0310\13\25\3\25\3\25\5\25\u0314\n\25\3\26\3\26"+
		"\3\27\5\27\u0319\n\27\3\27\3\27\3\27\3\27\5\27\u031f\n\27\3\27\3\27\5"+
		"\27\u0323\n\27\3\27\3\27\3\27\5\27\u0328\n\27\3\27\5\27\u032b\n\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0335\n\27\f\27\16\27\u0338\13"+
		"\27\3\27\3\27\5\27\u033c\n\27\3\30\3\30\3\30\5\30\u0341\n\30\3\30\3\30"+
		"\5\30\u0345\n\30\3\30\3\30\3\30\7\30\u034a\n\30\f\30\16\30\u034d\13\30"+
		"\3\30\3\30\3\30\5\30\u0352\n\30\3\31\3\31\5\31\u0356\n\31\3\31\3\31\3"+
		"\31\3\31\3\31\7\31\u035d\n\31\f\31\16\31\u0360\13\31\3\31\3\31\5\31\u0364"+
		"\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\6\31\u0371"+
		"\n\31\r\31\16\31\u0372\3\31\3\31\3\31\5\31\u0378\n\31\3\32\5\32\u037b"+
		"\n\32\3\32\3\32\5\32\u037f\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\5\33\u0389\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u0397\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u03a2\n\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u03ac\n\37\f"+
		"\37\16\37\u03af\13\37\3\37\3\37\3 \3 \3 \3 \3 \7 \u03b8\n \f \16 \u03bb"+
		"\13 \5 \u03bd\n \3!\3!\5!\u03c1\n!\3\"\3\"\5\"\u03c5\n\"\3#\3#\3#\3#\3"+
		"#\5#\u03cc\n#\3$\3$\3$\5$\u03d1\n$\3%\3%\3%\7%\u03d6\n%\f%\16%\u03d9\13"+
		"%\3%\5%\u03dc\n%\3&\3&\3\'\3\'\3\'\7\'\u03e3\n\'\f\'\16\'\u03e6\13\'\3"+
		"(\3(\5(\u03ea\n(\3(\3(\5(\u03ee\n(\3(\3(\5(\u03f2\n(\3)\5)\u03f5\n)\3"+
		")\3)\3)\3)\3)\5)\u03fc\n)\5)\u03fe\n)\3)\3)\5)\u0402\n)\3)\3)\5)\u0406"+
		"\n)\3*\3*\3*\3*\3*\5*\u040d\n*\5*\u040f\n*\3*\3*\5*\u0413\n*\3*\3*\5*"+
		"\u0417\n*\3+\3+\3+\3+\3+\5+\u041e\n+\5+\u0420\n+\3+\3+\5+\u0424\n+\3+"+
		"\3+\5+\u0428\n+\3,\3,\5,\u042c\n,\3,\3,\5,\u0430\n,\3,\3,\5,\u0434\n,"+
		"\3-\3-\5-\u0438\n-\3-\3-\5-\u043c\n-\3-\3-\5-\u0440\n-\3.\3.\3/\3/\3/"+
		"\5/\u0447\n/\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\5\61\u0456\n\61\3\61\3\61\3\61\3\61\3\61\5\61\u045d\n\61\3\61"+
		"\3\61\3\61\3\61\3\61\5\61\u0464\n\61\3\61\3\61\3\61\3\61\3\61\5\61\u046b"+
		"\n\61\3\61\3\61\3\61\3\61\3\61\5\61\u0472\n\61\3\61\3\61\3\61\3\61\3\61"+
		"\5\61\u0479\n\61\3\61\3\61\3\61\3\61\3\61\5\61\u0480\n\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\7\61\u04b0\n\61\f\61\16\61\u04b3\13\61\3\61\5\61\u04b6\n\61\3"+
		"\61\3\61\7\61\u04ba\n\61\f\61\16\61\u04bd\13\61\3\61\5\61\u04c0\n\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u04cb\n\61\f\61\16\61"+
		"\u04ce\13\61\3\61\5\61\u04d1\n\61\3\61\3\61\7\61\u04d5\n\61\f\61\16\61"+
		"\u04d8\13\61\3\61\5\61\u04db\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\7\61\u04e6\n\61\f\61\16\61\u04e9\13\61\3\61\5\61\u04ec\n\61\3"+
		"\61\3\61\7\61\u04f0\n\61\f\61\16\61\u04f3\13\61\3\61\5\61\u04f6\n\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u0501\n\61\f\61\16\61"+
		"\u0504\13\61\3\61\5\61\u0507\n\61\3\61\3\61\7\61\u050b\n\61\f\61\16\61"+
		"\u050e\13\61\3\61\5\61\u0511\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\7\61\u051c\n\61\f\61\16\61\u051f\13\61\3\61\5\61\u0522\n\61\3"+
		"\61\3\61\7\61\u0526\n\61\f\61\16\61\u0529\13\61\3\61\5\61\u052c\n\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u0537\n\61\f\61\16\61"+
		"\u053a\13\61\3\61\5\61\u053d\n\61\3\61\3\61\7\61\u0541\n\61\f\61\16\61"+
		"\u0544\13\61\3\61\5\61\u0547\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\5\61\u0551\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\7\61\u055f\n\61\f\61\16\61\u0562\13\61\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\5\62\u0589\n\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0599\n\62\3\62\3\62\5\62"+
		"\u059d\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u05a8\n"+
		"\62\f\62\16\62\u05ab\13\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\5\63\u05ba\n\63\3\63\3\63\3\63\3\63\3\63\5\63\u05c1"+
		"\n\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\7\63\u05d2\n\63\f\63\16\63\u05d5\13\63\3\64\3\64\3\64\7\64"+
		"\u05da\n\64\f\64\16\64\u05dd\13\64\3\65\5\65\u05e0\n\65\3\65\3\65\3\65"+
		"\7\65\u05e5\n\65\f\65\16\65\u05e8\13\65\3\65\3\65\5\65\u05ec\n\65\3\65"+
		"\3\65\3\65\3\65\5\65\u05f2\n\65\3\65\3\65\3\65\7\65\u05f7\n\65\f\65\16"+
		"\65\u05fa\13\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u0602\n\65\3\65\3\65"+
		"\3\65\7\65\u0607\n\65\f\65\16\65\u060a\13\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\5\65\u0612\n\65\3\65\3\65\3\65\7\65\u0617\n\65\f\65\16\65\u061a"+
		"\13\65\3\65\3\65\3\65\3\65\3\65\5\65\u0621\n\65\3\66\3\66\3\66\7\66\u0626"+
		"\n\66\f\66\16\66\u0629\13\66\3\67\3\67\3\67\7\67\u062e\n\67\f\67\16\67"+
		"\u0631\13\67\3\67\3\67\3\67\3\67\3\67\38\38\38\78\u063b\n8\f8\168\u063e"+
		"\138\39\59\u0641\n9\39\39\39\79\u0646\n9\f9\169\u0649\139\39\39\59\u064d"+
		"\n9\39\39\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3="+
		"\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3="+
		"\3=\3=\3=\3=\3=\3=\5=\u0682\n=\3>\3>\3?\3?\3@\3@\3A\5A\u068b\nA\3A\3A"+
		"\3A\2\5`bdB\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\2\26\3\2\65\67\3\2>B\3\2\u008d"+
		"\u008e\4\2\33\33JJ\3\2OP\3\2QR\3\2UW\3\2\\]\3\2YZ\3\2gh\3\2ij\3\2kl\3"+
		"\2mn\4\2Y[ww\4\2\66\66\177\177\4\2uu\u0080\u0080\4\2\65\65\u0081\u0081"+
		"\3\2\u0082\u0083\3\2\u0084\u0085\4\2\65\65\u008a\u008a\u07bf\2\u0083\3"+
		"\2\2\2\4\u0092\3\2\2\2\6\u00aa\3\2\2\2\b\u00ac\3\2\2\2\n\u00c7\3\2\2\2"+
		"\f\u00d2\3\2\2\2\16\u0108\3\2\2\2\20\u0120\3\2\2\2\22\u0123\3\2\2\2\24"+
		"\u0132\3\2\2\2\26\u013c\3\2\2\2\30\u0168\3\2\2\2\32\u016b\3\2\2\2\34\u01a6"+
		"\3\2\2\2\36\u01a9\3\2\2\2 \u0202\3\2\2\2\"\u026a\3\2\2\2$\u02b7\3\2\2"+
		"\2&\u02dc\3\2\2\2(\u02ec\3\2\2\2*\u0315\3\2\2\2,\u0318\3\2\2\2.\u0340"+
		"\3\2\2\2\60\u0353\3\2\2\2\62\u037a\3\2\2\2\64\u0388\3\2\2\2\66\u0396\3"+
		"\2\2\28\u03a1\3\2\2\2:\u03a3\3\2\2\2<\u03a7\3\2\2\2>\u03b2\3\2\2\2@\u03c0"+
		"\3\2\2\2B\u03c4\3\2\2\2D\u03c6\3\2\2\2F\u03cd\3\2\2\2H\u03d2\3\2\2\2J"+
		"\u03dd\3\2\2\2L\u03df\3\2\2\2N\u03e7\3\2\2\2P\u03f4\3\2\2\2R\u0407\3\2"+
		"\2\2T\u0418\3\2\2\2V\u0429\3\2\2\2X\u0435\3\2\2\2Z\u0441\3\2\2\2\\\u0446"+
		"\3\2\2\2^\u0448\3\2\2\2`\u0550\3\2\2\2b\u0588\3\2\2\2d\u05c0\3\2\2\2f"+
		"\u05d6\3\2\2\2h\u0620\3\2\2\2j\u0622\3\2\2\2l\u062a\3\2\2\2n\u0637\3\2"+
		"\2\2p\u0640\3\2\2\2r\u0652\3\2\2\2t\u0654\3\2\2\2v\u0656\3\2\2\2x\u0681"+
		"\3\2\2\2z\u0683\3\2\2\2|\u0685\3\2\2\2~\u0687\3\2\2\2\u0080\u068a\3\2"+
		"\2\2\u0082\u0084\5\4\3\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\5\b\5\2\u0086\u0087\b\2\1\2\u0087\u0088\5\n"+
		"\6\2\u0088\u008c\b\2\1\2\u0089\u008b\5`\61\2\u008a\u0089\3\2\2\2\u008b"+
		"\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2"+
		"\2\2\u008e\u008c\3\2\2\2\u008f\u0090\b\2\1\2\u0090\u0091\b\2\1\2\u0091"+
		"\3\3\2\2\2\u0092\u0093\7\3\2\2\u0093\u0094\7\4\2\2\u0094\u0099\5\6\4\2"+
		"\u0095\u0096\7\5\2\2\u0096\u0098\5\6\4\2\u0097\u0095\3\2\2\2\u0098\u009b"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009d\7\6\2\2\u009d\5\3\2\2\2\u009e\u009f\7\7\2\2"+
		"\u009f\u00a0\7\b\2\2\u00a0\u00ab\5v<\2\u00a1\u00a2\7\t\2\2\u00a2\u00a3"+
		"\7\b\2\2\u00a3\u00ab\5v<\2\u00a4\u00a5\7\n\2\2\u00a5\u00a6\7\b\2\2\u00a6"+
		"\u00ab\5v<\2\u00a7\u00a8\7\13\2\2\u00a8\u00a9\7\b\2\2\u00a9\u00ab\5v<"+
		"\2\u00aa\u009e\3\2\2\2\u00aa\u00a1\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a7"+
		"\3\2\2\2\u00ab\7\3\2\2\2\u00ac\u00c3\7\f\2\2\u00ad\u00ae\7\4\2\2\u00ae"+
		"\u00b3\5\\/\2\u00af\u00b0\7\5\2\2\u00b0\u00b2\5\\/\2\u00b1\u00af\3\2\2"+
		"\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\7\6\2\2\u00b7\u00c4\3\2\2\2\u00b8"+
		"\u00b9\7\r\2\2\u00b9\u00be\5\\/\2\u00ba\u00bb\7\5\2\2\u00bb\u00bd\5\\"+
		"/\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7\16"+
		"\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00ad\3\2\2\2\u00c3\u00b8\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\b\5\1\2\u00c6\t\3\2\2\2\u00c7\u00c8\7\17\2"+
		"\2\u00c8\u00cc\7\4\2\2\u00c9\u00cb\5\f\7\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00d0\7\6\2\2\u00d0\u00d1\b\6\1\2\u00d1\13\3\2\2"+
		"\2\u00d2\u00d4\5z>\2\u00d3\u00d5\5^\60\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\7\b\2\2\u00d7\u00d9\5b\62\2\u00d8"+
		"\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\7\r"+
		"\2\2\u00db\u00de\5\16\b\2\u00dc\u00dd\7\5\2\2\u00dd\u00df\5\16\b\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\7\16"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\7\1\2\u00e3\r\3\2\2\2\u00e4\u00ed"+
		"\7\4\2\2\u00e5\u00ea\5\20\t\2\u00e6\u00e7\7\5\2\2\u00e7\u00e9\5\20\t\2"+
		"\u00e8\u00e6\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00e5\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u0109\7\6\2\2\u00f0\u00f9\7\r"+
		"\2\2\u00f1\u00f6\5\20\t\2\u00f2\u00f3\7\5\2\2\u00f3\u00f5\5\20\t\2\u00f4"+
		"\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00f1\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u0109\7\16\2\2\u00fc\u00fd\7"+
		"\4\2\2\u00fd\u00fe\5\20\t\2\u00fe\u00ff\7\20\2\2\u00ff\u0100\5\20\t\2"+
		"\u0100\u0101\7\6\2\2\u0101\u0109\3\2\2\2\u0102\u0103\7\r\2\2\u0103\u0104"+
		"\5\20\t\2\u0104\u0105\7\20\2\2\u0105\u0106\5\20\t\2\u0106\u0107\7\16\2"+
		"\2\u0107\u0109\3\2\2\2\u0108\u00e4\3\2\2\2\u0108\u00f0\3\2\2\2\u0108\u00fc"+
		"\3\2\2\2\u0108\u0102\3\2\2\2\u0109\17\3\2\2\2\u010a\u010b\7\21\2\2\u010b"+
		"\u0110\5\\/\2\u010c\u010d\7\5\2\2\u010d\u010f\5\\/\2\u010e\u010c\3\2\2"+
		"\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113"+
		"\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0114\7\22\2\2\u0114\u0121\3\2\2\2"+
		"\u0115\u0116\7\r\2\2\u0116\u011b\5\\/\2\u0117\u0118\7\5\2\2\u0118\u011a"+
		"\5\\/\2\u0119\u0117\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\7\16"+
		"\2\2\u011f\u0121\3\2\2\2\u0120\u010a\3\2\2\2\u0120\u0115\3\2\2\2\u0121"+
		"\21\3\2\2\2\u0122\u0124\5\4\3\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2"+
		"\2\u0124\u0127\3\2\2\2\u0125\u0126\7\23\2\2\u0126\u0128\5z>\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012c\3\2\2\2\u0129\u012b\5\24\13\2"+
		"\u012a\u0129\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d"+
		"\3\2\2\2\u012d\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0130\5\26\f\2"+
		"\u0130\u0131\b\n\1\2\u0131\23\3\2\2\2\u0132\u0136\7\24\2\2\u0133\u0134"+
		"\5z>\2\u0134\u0135\7\b\2\2\u0135\u0137\3\2\2\2\u0136\u0133\3\2\2\2\u0136"+
		"\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\7\u008d\2\2\u0139\u013a"+
		"\7\25\2\2\u013a\25\3\2\2\2\u013b\u013d\5Z.\2\u013c\u013b\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\7\26\2\2\u013f\u0140\5"+
		"x=\2\u0140\u0141\7\b\2\2\u0141\u0142\5z>\2\u0142\u0143\3\2\2\2\u0143\u0144"+
		"\7\27\2\2\u0144\u0145\7\u008d\2\2\u0145\u0146\3\2\2\2\u0146\u015b\b\f"+
		"\1\2\u0147\u0156\7\4\2\2\u0148\u0149\5\60\31\2\u0149\u014a\b\f\1\2\u014a"+
		"\u0155\3\2\2\2\u014b\u014c\5\26\f\2\u014c\u014d\b\f\1\2\u014d\u0155\3"+
		"\2\2\2\u014e\u014f\5\30\r\2\u014f\u0150\b\f\1\2\u0150\u0155\3\2\2\2\u0151"+
		"\u0152\5P)\2\u0152\u0153\b\f\1\2\u0153\u0155\3\2\2\2\u0154\u0148\3\2\2"+
		"\2\u0154\u014b\3\2\2\2\u0154\u014e\3\2\2\2\u0154\u0151\3\2\2\2\u0155\u0158"+
		"\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158"+
		"\u0156\3\2\2\2\u0159\u015c\7\6\2\2\u015a\u015c\7\25\2\2\u015b\u0147\3"+
		"\2\2\2\u015b\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\b\f\1\2\u015e"+
		"\27\3\2\2\2\u015f\u0160\5\32\16\2\u0160\u0161\b\r\1\2\u0161\u0169\3\2"+
		"\2\2\u0162\u0163\5(\25\2\u0163\u0164\b\r\1\2\u0164\u0169\3\2\2\2\u0165"+
		"\u0166\5,\27\2\u0166\u0167\b\r\1\2\u0167\u0169\3\2\2\2\u0168\u015f\3\2"+
		"\2\2\u0168\u0162\3\2\2\2\u0168\u0165\3\2\2\2\u0169\31\3\2\2\2\u016a\u016c"+
		"\5Z.\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u0172\3\2\2\2\u016d"+
		"\u016f\7\30\2\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3"+
		"\2\2\2\u0170\u0173\7\31\2\2\u0171\u0173\7\32\2\2\u0172\u016e\3\2\2\2\u0172"+
		"\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\5x=\2\u0175\u0177\b\16"+
		"\1\2\u0176\u0178\5<\37\2\u0177\u0176\3\2\2\2\u0177\u0178\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u0183\b\16\1\2\u017a\u017b\7\33\2\2\u017b\u0180\5"+
		"B\"\2\u017c\u017d\7\5\2\2\u017d\u017f\5B\"\2\u017e\u017c\3\2\2\2\u017f"+
		"\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0184\3\2"+
		"\2\2\u0182\u0180\3\2\2\2\u0183\u017a\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"\u0187\3\2\2\2\u0185\u0186\7\b\2\2\u0186\u0188\7\u008d\2\2\u0187\u0185"+
		"\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u019c\b\16\1\2"+
		"\u018a\u0197\7\4\2\2\u018b\u018c\5\60\31\2\u018c\u018d\b\16\1\2\u018d"+
		"\u0196\3\2\2\2\u018e\u018f\5\"\22\2\u018f\u0190\b\16\1\2\u0190\u0196\3"+
		"\2\2\2\u0191\u0192\5\34\17\2\u0192\u0193\b\16\1\2\u0193\u0196\3\2\2\2"+
		"\u0194\u0196\5P)\2\u0195\u018b\3\2\2\2\u0195\u018e\3\2\2\2\u0195\u0191"+
		"\3\2\2\2\u0195\u0194\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197"+
		"\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019d\7\6"+
		"\2\2\u019b\u019d\7\25\2\2\u019c\u018a\3\2\2\2\u019c\u019b\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u019f\b\16\1\2\u019f\33\3\2\2\2\u01a0\u01a1\5\36"+
		"\20\2\u01a1\u01a2\b\17\1\2\u01a2\u01a7\3\2\2\2\u01a3\u01a4\5 \21\2\u01a4"+
		"\u01a5\b\17\1\2\u01a5\u01a7\3\2\2\2\u01a6\u01a0\3\2\2\2\u01a6\u01a3\3"+
		"\2\2\2\u01a7\35\3\2\2\2\u01a8\u01aa\5Z.\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa"+
		"\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01ad\7\34\2\2\u01ac\u01ab\3\2\2\2"+
		"\u01ac\u01ad\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae\u01b1\7\35\2\2\u01af\u01b1"+
		"\7\36\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01af\3\2\2\2\u01b0\u01b1\3\2\2\2"+
		"\u01b1\u01b3\3\2\2\2\u01b2\u01b4\7\37\2\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4"+
		"\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b7\7 \2\2\u01b6\u01b5\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01bb\7!\2\2\u01b9\u01bb\7\""+
		"\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01bd\3\2\2\2\u01bc\u01be\7#\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2"+
		"\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\7$\2\2\u01c0\u01c1\5x=\2\u01c1\u01c2"+
		"\b\20\1\2\u01c2\u01c3\7\b\2\2\u01c3\u01c5\5B\"\2\u01c4\u01c6\5&\24\2\u01c5"+
		"\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01ca\3\2\2\2\u01c7\u01c8\7\27"+
		"\2\2\u01c8\u01c9\7\u008d\2\2\u01c9\u01cb\b\20\1\2\u01ca\u01c7\3\2\2\2"+
		"\u01ca\u01cb\3\2\2\2\u01cb\u01df\3\2\2\2\u01cc\u01da\7\4\2\2\u01cd\u01d6"+
		"\7%\2\2\u01ce\u01d6\7&\2\2\u01cf\u01d6\7\'\2\2\u01d0\u01d6\7(\2\2\u01d1"+
		"\u01d6\7)\2\2\u01d2\u01d6\7*\2\2\u01d3\u01d6\7+\2\2\u01d4\u01d6\7,\2\2"+
		"\u01d5\u01cd\3\2\2\2\u01d5\u01ce\3\2\2\2\u01d5\u01cf\3\2\2\2\u01d5\u01d0"+
		"\3\2\2\2\u01d5\u01d1\3\2\2\2\u01d5\u01d2\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5"+
		"\u01d4\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d9\7\5\2\2\u01d8\u01d7\3\2"+
		"\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01d5\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2"+
		"\2\2\u01de\u01e0\7\6\2\2\u01df\u01cc\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"\u01e1\3\2\2\2\u01e1\u01ff\b\20\1\2\u01e2\u01fb\7\4\2\2\u01e3\u01e4\5"+
		"\60\31\2\u01e4\u01e5\b\20\1\2\u01e5\u01e7\3\2\2\2\u01e6\u01e3\3\2\2\2"+
		"\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ed"+
		"\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ee\5X-\2\u01ec\u01ee\5V,\2\u01ed"+
		"\u01eb\3\2\2\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01fc\3\2"+
		"\2\2\u01ef\u01f2\5X-\2\u01f0\u01f2\5V,\2\u01f1\u01ef\3\2\2\2\u01f1\u01f0"+
		"\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f8\3\2\2\2\u01f3\u01f4\5\60\31\2"+
		"\u01f4\u01f5\b\20\1\2\u01f5\u01f7\3\2\2\2\u01f6\u01f3\3\2\2\2\u01f7\u01fa"+
		"\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa"+
		"\u01f8\3\2\2\2\u01fb\u01e8\3\2\2\2\u01fb\u01f1\3\2\2\2\u01fc\u01fd\3\2"+
		"\2\2\u01fd\u0200\7\6\2\2\u01fe\u0200\7\25\2\2\u01ff\u01e2\3\2\2\2\u01ff"+
		"\u01fe\3\2\2\2\u0200\37\3\2\2\2\u0201\u0203\5Z.\2\u0202\u0201\3\2\2\2"+
		"\u0202\u0203\3\2\2\2\u0203\u0205\3\2\2\2\u0204\u0206\7\34\2\2\u0205\u0204"+
		"\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0209\3\2\2\2\u0207\u020a\7\35\2\2"+
		"\u0208\u020a\7\36\2\2\u0209\u0207\3\2\2\2\u0209\u0208\3\2\2\2\u0209\u020a"+
		"\3\2\2\2\u020a\u020c\3\2\2\2\u020b\u020d\7\37\2\2\u020c\u020b\3\2\2\2"+
		"\u020c\u020d\3\2\2\2\u020d\u020f\3\2\2\2\u020e\u0210\7 \2\2\u020f\u020e"+
		"\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0213\3\2\2\2\u0211\u0214\7!\2\2\u0212"+
		"\u0214\7\"\2\2\u0213\u0211\3\2\2\2\u0213\u0212\3\2\2\2\u0213\u0214\3\2"+
		"\2\2\u0214\u0216\3\2\2\2\u0215\u0217\7#\2\2\u0216\u0215\3\2\2\2\u0216"+
		"\u0217\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\7-\2\2\u0219\u021a\5x="+
		"\2\u021a\u021d\b\21\1\2\u021b\u021c\7.\2\2\u021c\u021e\5x=\2\u021d\u021b"+
		"\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0220\7\b\2\2\u0220"+
		"\u0222\5B\"\2\u0221\u0223\5&\24\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2"+
		"\2\2\u0223\u0227\3\2\2\2\u0224\u0225\7\27\2\2\u0225\u0226\7\u008d\2\2"+
		"\u0226\u0228\b\21\1\2\u0227\u0224\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u023e"+
		"\3\2\2\2\u0229\u0239\7\4\2\2\u022a\u0235\7/\2\2\u022b\u0235\7%\2\2\u022c"+
		"\u0235\7\'\2\2\u022d\u0235\7(\2\2\u022e\u0235\7)\2\2\u022f\u0235\7*\2"+
		"\2\u0230\u0235\7\60\2\2\u0231\u0235\7\61\2\2\u0232\u0235\7+\2\2\u0233"+
		"\u0235\7,\2\2\u0234\u022a\3\2\2\2\u0234\u022b\3\2\2\2\u0234\u022c\3\2"+
		"\2\2\u0234\u022d\3\2\2\2\u0234\u022e\3\2\2\2\u0234\u022f\3\2\2\2\u0234"+
		"\u0230\3\2\2\2\u0234\u0231\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0233\3\2"+
		"\2\2\u0235\u0237\3\2\2\2\u0236\u0238\7\5\2\2\u0237\u0236\3\2\2\2\u0237"+
		"\u0238\3\2\2\2\u0238\u023a\3\2\2\2\u0239\u0234\3\2\2\2\u023a\u023b\3\2"+
		"\2\2\u023b\u0239\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\3\2\2\2\u023d"+
		"\u023f\7\6\2\2\u023e\u0229\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0240\3\2"+
		"\2\2\u0240\u0267\b\21\1\2\u0241\u024d\7\4\2\2\u0242\u0243\7\62\2\2\u0243"+
		"\u0248\5x=\2\u0244\u0245\7\5\2\2\u0245\u0247\5x=\2\u0246\u0244\3\2\2\2"+
		"\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024b"+
		"\3\2\2\2\u024a\u0248\3\2\2\2\u024b\u024c\7\25\2\2\u024c\u024e\3\2\2\2"+
		"\u024d\u0242\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0263\3\2\2\2\u024f\u0251"+
		"\5\60\31\2\u0250\u024f\3\2\2\2\u0251\u0254\3\2\2\2\u0252\u0250\3\2\2\2"+
		"\u0252\u0253\3\2\2\2\u0253\u0257\3\2\2\2\u0254\u0252\3\2\2\2\u0255\u0258"+
		"\5X-\2\u0256\u0258\5V,\2\u0257\u0255\3\2\2\2\u0257\u0256\3\2\2\2\u0257"+
		"\u0258\3\2\2\2\u0258\u0264\3\2\2\2\u0259\u025c\5X-\2\u025a\u025c\5V,\2"+
		"\u025b\u0259\3\2\2\2\u025b\u025a\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u0260"+
		"\3\2\2\2\u025d\u025f\5\60\31\2\u025e\u025d\3\2\2\2\u025f\u0262\3\2\2\2"+
		"\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0264\3\2\2\2\u0262\u0260"+
		"\3\2\2\2\u0263\u0252\3\2\2\2\u0263\u025b\3\2\2\2\u0264\u0265\3\2\2\2\u0265"+
		"\u0268\7\6\2\2\u0266\u0268\7\25\2\2\u0267\u0241\3\2\2\2\u0267\u0266\3"+
		"\2\2\2\u0268!\3\2\2\2\u0269\u026b\5Z.\2\u026a\u0269\3\2\2\2\u026a\u026b"+
		"\3\2\2\2\u026b\u026d\3\2\2\2\u026c\u026e\7\34\2\2\u026d\u026c\3\2\2\2"+
		"\u026d\u026e\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\7\63\2\2\u0270\u0272"+
		"\5<\37\2\u0271\u0270\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\3\2\2\2\u0273"+
		"\u0274\5x=\2\u0274\u0275\b\22\1\2\u0275\u027e\7\21\2\2\u0276\u027b\5$"+
		"\23\2\u0277\u0278\7\5\2\2\u0278\u027a\5$\23\2\u0279\u0277\3\2\2\2\u027a"+
		"\u027d\3\2\2\2\u027b\u0279\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027f\3\2"+
		"\2\2\u027d\u027b\3\2\2\2\u027e\u0276\3\2\2\2\u027e\u027f\3\2\2\2\u027f"+
		"\u0280\3\2\2\2\u0280\u0281\7\22\2\2\u0281\u0287\b\22\1\2\u0282\u0283\7"+
		"\b\2\2\u0283\u0285\5B\"\2\u0284\u0286\5&\24\2\u0285\u0284\3\2\2\2\u0285"+
		"\u0286\3\2\2\2\u0286\u0288\3\2\2\2\u0287\u0282\3\2\2\2\u0287\u0288\3\2"+
		"\2\2\u0288\u0292\3\2\2\2\u0289\u028a\7\64\2\2\u028a\u028f\5B\"\2\u028b"+
		"\u028c\7\5\2\2\u028c\u028e\5B\"\2\u028d\u028b\3\2\2\2\u028e\u0291\3\2"+
		"\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0293\3\2\2\2\u0291"+
		"\u028f\3\2\2\2\u0292\u0289\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u02a3\3\2"+
		"\2\2\u0294\u029e\7\4\2\2\u0295\u029a\7\'\2\2\u0296\u029a\7(\2\2\u0297"+
		"\u029a\7)\2\2\u0298\u029a\7*\2\2\u0299\u0295\3\2\2\2\u0299\u0296\3\2\2"+
		"\2\u0299\u0297\3\2\2\2\u0299\u0298\3\2\2\2\u029a\u029c\3\2\2\2\u029b\u029d"+
		"\7\5\2\2\u029c\u029b\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029f\3\2\2\2\u029e"+
		"\u0299\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u029e\3\2\2\2\u02a0\u02a1\3\2"+
		"\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a4\7\6\2\2\u02a3\u0294\3\2\2\2\u02a3"+
		"\u02a4\3\2\2\2\u02a4\u02b3\3\2\2\2\u02a5\u02ae\7\4\2\2\u02a6\u02a7\5\60"+
		"\31\2\u02a7\u02a8\b\22\1\2\u02a8\u02ad\3\2\2\2\u02a9\u02ad\5R*\2\u02aa"+
		"\u02ad\5N(\2\u02ab\u02ad\5T+\2\u02ac\u02a6\3\2\2\2\u02ac\u02a9\3\2\2\2"+
		"\u02ac\u02aa\3\2\2\2\u02ac\u02ab\3\2\2\2\u02ad\u02b0\3\2\2\2\u02ae\u02ac"+
		"\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b1\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b1"+
		"\u02b4\7\6\2\2\u02b2\u02b4\7\25\2\2\u02b3\u02a5\3\2\2\2\u02b3\u02b2\3"+
		"\2\2\2\u02b4#\3\2\2\2\u02b5\u02b8\7!\2\2\u02b6\u02b8\7\"\2\2\u02b7\u02b5"+
		"\3\2\2\2\u02b7\u02b6\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9"+
		"\u02ba\5x=\2\u02ba\u02bb\b\23\1\2\u02bb\u02bc\7\b\2\2\u02bc\u02be\5B\""+
		"\2\u02bd\u02bf\5&\24\2\u02be\u02bd\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\u02cf"+
		"\3\2\2\2\u02c0\u02ca\7\4\2\2\u02c1\u02c6\7\'\2\2\u02c2\u02c6\7(\2\2\u02c3"+
		"\u02c6\7)\2\2\u02c4\u02c6\7*\2\2\u02c5\u02c1\3\2\2\2\u02c5\u02c2\3\2\2"+
		"\2\u02c5\u02c3\3\2\2\2\u02c5\u02c4\3\2\2\2\u02c6\u02c8\3\2\2\2\u02c7\u02c9"+
		"\7\5\2\2\u02c8\u02c7\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02cb\3\2\2\2\u02ca"+
		"\u02c5\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cc\u02cd\3\2"+
		"\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02d0\7\6\2\2\u02cf\u02c0\3\2\2\2\u02cf"+
		"\u02d0\3\2\2\2\u02d0\u02da\3\2\2\2\u02d1\u02d5\7\4\2\2\u02d2\u02d4\5\60"+
		"\31\2\u02d3\u02d2\3\2\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d5"+
		"\u02d6\3\2\2\2\u02d6\u02d8\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d8\u02d9\b\23"+
		"\1\2\u02d9\u02db\7\6\2\2\u02da\u02d1\3\2\2\2\u02da\u02db\3\2\2\2\u02db"+
		"%\3\2\2\2\u02dc\u02e3\7\r\2\2\u02dd\u02e0\5~@\2\u02de\u02df\7\20\2\2\u02df"+
		"\u02e1\5|?\2\u02e0\u02de\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e4\3\2\2"+
		"\2\u02e2\u02e4\t\2\2\2\u02e3\u02dd\3\2\2\2\u02e3\u02e2\3\2\2\2\u02e4\u02e7"+
		"\3\2\2\2\u02e5\u02e8\78\2\2\u02e6\u02e8\79\2\2\u02e7\u02e5\3\2\2\2\u02e7"+
		"\u02e6\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02ea\7\16"+
		"\2\2\u02ea\'\3\2\2\2\u02eb\u02ed\5Z.\2\u02ec\u02eb\3\2\2\2\u02ec\u02ed"+
		"\3\2\2\2\u02ed\u02f3\3\2\2\2\u02ee\u02f4\7:\2\2\u02ef\u02f2\7!\2\2\u02f0"+
		"\u02f2\7\"\2\2\u02f1\u02ef\3\2\2\2\u02f1\u02f0\3\2\2\2\u02f2\u02f4\3\2"+
		"\2\2\u02f3\u02ee\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4"+
		"\u02f5\3\2\2\2\u02f5\u02f6\7;\2\2\u02f6\u02f7\5x=\2\u02f7\u02f9\b\25\1"+
		"\2\u02f8\u02fa\5<\37\2\u02f9\u02f8\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fd"+
		"\3\2\2\2\u02fb\u02fc\7\b\2\2\u02fc\u02fe\7\u008d\2\2\u02fd\u02fb\3\2\2"+
		"\2\u02fd\u02fe\3\2\2\2\u02fe\u0305\3\2\2\2\u02ff\u0302\7\4\2\2\u0300\u0303"+
		"\7<\2\2\u0301\u0303\7=\2\2\u0302\u0300\3\2\2\2\u0302\u0301\3\2\2\2\u0302"+
		"\u0303\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0306\7\6\2\2\u0305\u02ff\3\2"+
		"\2\2\u0305\u0306\3\2\2\2\u0306\u0313\3\2\2\2\u0307\u030e\7\4\2\2\u0308"+
		"\u0309\5\60\31\2\u0309\u030a\b\25\1\2\u030a\u030d\3\2\2\2\u030b\u030d"+
		"\5P)\2\u030c\u0308\3\2\2\2\u030c\u030b\3\2\2\2\u030d\u0310\3\2\2\2\u030e"+
		"\u030c\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0311\3\2\2\2\u0310\u030e\3\2"+
		"\2\2\u0311\u0314\7\6\2\2\u0312\u0314\7\25\2\2\u0313\u0307\3\2\2\2\u0313"+
		"\u0312\3\2\2\2\u0314)\3\2\2\2\u0315\u0316\t\3\2\2\u0316+\3\2\2\2\u0317"+
		"\u0319\5Z.\2\u0318\u0317\3\2\2\2\u0318\u0319\3\2\2\2\u0319\u031a\3\2\2"+
		"\2\u031a\u031b\7C\2\2\u031b\u031c\5x=\2\u031c\u031e\b\27\1\2\u031d\u031f"+
		"\5<\37\2\u031e\u031d\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0322\3\2\2\2\u0320"+
		"\u0321\7\b\2\2\u0321\u0323\7\u008d\2\2\u0322\u0320\3\2\2\2\u0322\u0323"+
		"\3\2\2\2\u0323\u032a\3\2\2\2\u0324\u0327\7\4\2\2\u0325\u0328\7<\2\2\u0326"+
		"\u0328\7=\2\2\u0327\u0325\3\2\2\2\u0327\u0326\3\2\2\2\u0327\u0328\3\2"+
		"\2\2\u0328\u0329\3\2\2\2\u0329\u032b\7\6\2\2\u032a\u0324\3\2\2\2\u032a"+
		"\u032b\3\2\2\2\u032b\u033b\3\2\2\2\u032c\u0336\7\4\2\2\u032d\u032e\5\60"+
		"\31\2\u032e\u032f\b\27\1\2\u032f\u0335\3\2\2\2\u0330\u0331\5.\30\2\u0331"+
		"\u0332\b\27\1\2\u0332\u0335\3\2\2\2\u0333\u0335\5P)\2\u0334\u032d\3\2"+
		"\2\2\u0334\u0330\3\2\2\2\u0334\u0333\3\2\2\2\u0335\u0338\3\2\2\2\u0336"+
		"\u0334\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u0339\3\2\2\2\u0338\u0336\3\2"+
		"\2\2\u0339\u033c\7\6\2\2\u033a\u033c\7\25\2\2\u033b\u032c\3\2\2\2\u033b"+
		"\u033a\3\2\2\2\u033c-\3\2\2\2\u033d\u033e\7D\2\2\u033e\u0341\5x=\2\u033f"+
		"\u0341\5x=\2\u0340\u033d\3\2\2\2\u0340\u033f\3\2\2\2\u0341\u0344\3\2\2"+
		"\2\u0342\u0343\7\27\2\2\u0343\u0345\5\u0080A\2\u0344\u0342\3\2\2\2\u0344"+
		"\u0345\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0351\b\30\1\2\u0347\u034b\7"+
		"\4\2\2\u0348\u034a\5\60\31\2\u0349\u0348\3\2\2\2\u034a\u034d\3\2\2\2\u034b"+
		"\u0349\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034e\3\2\2\2\u034d\u034b\3\2"+
		"\2\2\u034e\u034f\b\30\1\2\u034f\u0352\7\6\2\2\u0350\u0352\7\25\2\2\u0351"+
		"\u0347\3\2\2\2\u0351\u0350\3\2\2\2\u0352/\3\2\2\2\u0353\u0355\7E\2\2\u0354"+
		"\u0356\7\u008d\2\2\u0355\u0354\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u0357"+
		"\3\2\2\2\u0357\u0363\b\31\1\2\u0358\u0359\7\21\2\2\u0359\u035e\5\62\32"+
		"\2\u035a\u035b\7\5\2\2\u035b\u035d\5\62\32\2\u035c\u035a\3\2\2\2\u035d"+
		"\u0360\3\2\2\2\u035e\u035c\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u0361\3\2"+
		"\2\2\u0360\u035e\3\2\2\2\u0361\u0362\7\22\2\2\u0362\u0364\3\2\2\2\u0363"+
		"\u0358\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u0365\3\2\2\2\u0365\u0377\b\31"+
		"\1\2\u0366\u0370\7\4\2\2\u0367\u0368\5\60\31\2\u0368\u0369\b\31\1\2\u0369"+
		"\u0371\3\2\2\2\u036a\u036b\5\64\33\2\u036b\u036c\b\31\1\2\u036c\u0371"+
		"\3\2\2\2\u036d\u036e\5:\36\2\u036e\u036f\b\31\1\2\u036f\u0371\3\2\2\2"+
		"\u0370\u0367\3\2\2\2\u0370\u036a\3\2\2\2\u0370\u036d\3\2\2\2\u0371\u0372"+
		"\3\2\2\2\u0372\u0370\3\2\2\2\u0372\u0373\3\2\2\2\u0373\u0374\3\2\2\2\u0374"+
		"\u0375\7\6\2\2\u0375\u0378\3\2\2\2\u0376\u0378\7\25\2\2\u0377\u0366\3"+
		"\2\2\2\u0377\u0376\3\2\2\2\u0378\61\3\2\2\2\u0379\u037b\7\u008d\2\2\u037a"+
		"\u0379\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u037e\7\27"+
		"\2\2\u037d\u037f\t\4\2\2\u037e\u037d\3\2\2\2\u037e\u037f\3\2\2\2\u037f"+
		"\u0380\3\2\2\2\u0380\u0381\b\32\1\2\u0381\63\3\2\2\2\u0382\u0383\5\60"+
		"\31\2\u0383\u0384\b\33\1\2\u0384\u0389\3\2\2\2\u0385\u0386\5\66\34\2\u0386"+
		"\u0387\b\33\1\2\u0387\u0389\3\2\2\2\u0388\u0382\3\2\2\2\u0388\u0385\3"+
		"\2\2\2\u0389\65\3\2\2\2\u038a\u038b\58\35\2\u038b\u038c\b\34\1\2\u038c"+
		"\u0397\3\2\2\2\u038d\u038e\5\30\r\2\u038e\u038f\b\34\1\2\u038f\u0397\3"+
		"\2\2\2\u0390\u0391\5\26\f\2\u0391\u0392\b\34\1\2\u0392\u0397\3\2\2\2\u0393"+
		"\u0394\5.\30\2\u0394\u0395\b\34\1\2\u0395\u0397\3\2\2\2\u0396\u038a\3"+
		"\2\2\2\u0396\u038d\3\2\2\2\u0396\u0390\3\2\2\2\u0396\u0393\3\2\2\2\u0397"+
		"\67\3\2\2\2\u0398\u0399\5\"\22\2\u0399\u039a\b\35\1\2\u039a\u03a2\3\2"+
		"\2\2\u039b\u039c\5$\23\2\u039c\u039d\b\35\1\2\u039d\u03a2\3\2\2\2\u039e"+
		"\u039f\5\34\17\2\u039f\u03a0\b\35\1\2\u03a0\u03a2\3\2\2\2\u03a1\u0398"+
		"\3\2\2\2\u03a1\u039b\3\2\2\2\u03a1\u039e\3\2\2\2\u03a29\3\2\2\2\u03a3"+
		"\u03a4\7F\2\2\u03a4\u03a5\5L\'\2\u03a5\u03a6\7\25\2\2\u03a6;\3\2\2\2\u03a7"+
		"\u03a8\7G\2\2\u03a8\u03ad\5> \2\u03a9\u03aa\7\5\2\2\u03aa\u03ac\5> \2"+
		"\u03ab\u03a9\3\2\2\2\u03ac\u03af\3\2\2\2\u03ad\u03ab\3\2\2\2\u03ad\u03ae"+
		"\3\2\2\2\u03ae\u03b0\3\2\2\2\u03af\u03ad\3\2\2\2\u03b0\u03b1\7H\2\2\u03b1"+
		"=\3\2\2\2\u03b2\u03bc\5x=\2\u03b3\u03b4\7\33\2\2\u03b4\u03b9\5B\"\2\u03b5"+
		"\u03b6\7I\2\2\u03b6\u03b8\5B\"\2\u03b7\u03b5\3\2\2\2\u03b8\u03bb\3\2\2"+
		"\2\u03b9\u03b7\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba\u03bd\3\2\2\2\u03bb\u03b9"+
		"\3\2\2\2\u03bc\u03b3\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd?\3\2\2\2\u03be"+
		"\u03c1\5B\"\2\u03bf\u03c1\5F$\2\u03c0\u03be\3\2\2\2\u03c0\u03bf\3\2\2"+
		"\2\u03c1A\3\2\2\2\u03c2\u03c5\5*\26\2\u03c3\u03c5\5D#\2\u03c4\u03c2\3"+
		"\2\2\2\u03c4\u03c3\3\2\2\2\u03c5C\3\2\2\2\u03c6\u03cb\5L\'\2\u03c7\u03c8"+
		"\7G\2\2\u03c8\u03c9\5H%\2\u03c9\u03ca\7H\2\2\u03ca\u03cc\3\2\2\2\u03cb"+
		"\u03c7\3\2\2\2\u03cb\u03cc\3\2\2\2\u03ccE\3\2\2\2\u03cd\u03d0\7\67\2\2"+
		"\u03ce\u03cf\t\5\2\2\u03cf\u03d1\5B\"\2\u03d0\u03ce\3\2\2\2\u03d0\u03d1"+
		"\3\2\2\2\u03d1G\3\2\2\2\u03d2\u03d7\5J&\2\u03d3\u03d4\7\5\2\2\u03d4\u03d6"+
		"\5J&\2\u03d5\u03d3\3\2\2\2\u03d6\u03d9\3\2\2\2\u03d7\u03d5\3\2\2\2\u03d7"+
		"\u03d8\3\2\2\2\u03d8\u03db\3\2\2\2\u03d9\u03d7\3\2\2\2\u03da\u03dc\5&"+
		"\24\2\u03db\u03da\3\2\2\2\u03db\u03dc\3\2\2\2\u03dcI\3\2\2\2\u03dd\u03de"+
		"\5@!\2\u03deK\3\2\2\2\u03df\u03e4\5x=\2\u03e0\u03e1\7K\2\2\u03e1\u03e3"+
		"\5x=\2\u03e2\u03e0\3\2\2\2\u03e3\u03e6\3\2\2\2\u03e4\u03e2\3\2\2\2\u03e4"+
		"\u03e5\3\2\2\2\u03e5M\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e7\u03e9\7L\2\2\u03e8"+
		"\u03ea\5z>\2\u03e9\u03e8\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea\u03f1\3\2\2"+
		"\2\u03eb\u03ed\7\b\2\2\u03ec\u03ee\5b\62\2\u03ed\u03ec\3\2\2\2\u03ed\u03ee"+
		"\3\2\2\2\u03ee\u03ef\3\2\2\2\u03ef\u03f2\7\25\2\2\u03f0\u03f2\7\25\2\2"+
		"\u03f1\u03eb\3\2\2\2\u03f1\u03f0\3\2\2\2\u03f2O\3\2\2\2\u03f3\u03f5\7"+
		"M\2\2\u03f4\u03f3\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6"+
		"\u03fd\7N\2\2\u03f7\u03fb\5z>\2\u03f8\u03f9\7\21\2\2\u03f9\u03fa\7\u008c"+
		"\2\2\u03fa\u03fc\7\22\2\2\u03fb\u03f8\3\2\2\2\u03fb\u03fc\3\2\2\2\u03fc"+
		"\u03fe\3\2\2\2\u03fd\u03f7\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe\u0405\3\2"+
		"\2\2\u03ff\u0401\7\b\2\2\u0400\u0402\5`\61\2\u0401\u0400\3\2\2\2\u0401"+
		"\u0402\3\2\2\2\u0402\u0403\3\2\2\2\u0403\u0406\7\25\2\2\u0404\u0406\7"+
		"\25\2\2\u0405\u03ff\3\2\2\2\u0405\u0404\3\2\2\2\u0406Q\3\2\2\2\u0407\u040e"+
		"\t\6\2\2\u0408\u040c\5z>\2\u0409\u040a\7\21\2\2\u040a\u040b\7\u008c\2"+
		"\2\u040b\u040d\7\22\2\2\u040c\u0409\3\2\2\2\u040c\u040d\3\2\2\2\u040d"+
		"\u040f\3\2\2\2\u040e\u0408\3\2\2\2\u040e\u040f\3\2\2\2\u040f\u0416\3\2"+
		"\2\2\u0410\u0412\7\b\2\2\u0411\u0413\5`\61\2\u0412\u0411\3\2\2\2\u0412"+
		"\u0413\3\2\2\2\u0413\u0414\3\2\2\2\u0414\u0417\7\25\2\2\u0415\u0417\7"+
		"\25\2\2\u0416\u0410\3\2\2\2\u0416\u0415\3\2\2\2\u0417S\3\2\2\2\u0418\u041f"+
		"\t\7\2\2\u0419\u041d\5z>\2\u041a\u041b\7\21\2\2\u041b\u041c\7\u008c\2"+
		"\2\u041c\u041e\7\22\2\2\u041d\u041a\3\2\2\2\u041d\u041e\3\2\2\2\u041e"+
		"\u0420\3\2\2\2\u041f\u0419\3\2\2\2\u041f\u0420\3\2\2\2\u0420\u0427\3\2"+
		"\2\2\u0421\u0423\7\b\2\2\u0422\u0424\5`\61\2\u0423\u0422\3\2\2\2\u0423"+
		"\u0424\3\2\2\2\u0424\u0425\3\2\2\2\u0425\u0428\7\25\2\2\u0426\u0428\7"+
		"\25\2\2\u0427\u0421\3\2\2\2\u0427\u0426\3\2\2\2\u0428U\3\2\2\2\u0429\u042b"+
		"\7S\2\2\u042a\u042c\5z>\2\u042b\u042a\3\2\2\2\u042b\u042c\3\2\2\2\u042c"+
		"\u0433\3\2\2\2\u042d\u042f\7\b\2\2\u042e\u0430\5b\62\2\u042f\u042e\3\2"+
		"\2\2\u042f\u0430\3\2\2\2\u0430\u0431\3\2\2\2\u0431\u0434\7\25\2\2\u0432"+
		"\u0434\7\25\2\2\u0433\u042d\3\2\2\2\u0433\u0432\3\2\2\2\u0434W\3\2\2\2"+
		"\u0435\u0437\7T\2\2\u0436\u0438\5z>\2\u0437\u0436\3\2\2\2\u0437\u0438"+
		"\3\2\2\2\u0438\u043f\3\2\2\2\u0439\u043b\7\b\2\2\u043a\u043c\5b\62\2\u043b"+
		"\u043a\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u043d\3\2\2\2\u043d\u0440\7\25"+
		"\2\2\u043e\u0440\7\25\2\2\u043f\u0439\3\2\2\2\u043f\u043e\3\2\2\2\u0440"+
		"Y\3\2\2\2\u0441\u0442\t\b\2\2\u0442[\3\2\2\2\u0443\u0444\7\u008b\2\2\u0444"+
		"\u0447\b/\1\2\u0445\u0447\7\u008a\2\2\u0446\u0443\3\2\2\2\u0446\u0445"+
		"\3\2\2\2\u0447]\3\2\2\2\u0448\u0449\7\u008a\2\2\u0449_\3\2\2\2\u044a\u044b"+
		"\b\61\1\2\u044b\u044c\7X\2\2\u044c\u0551\5b\62\2\u044d\u044e\7Y\2\2\u044e"+
		"\u0551\5b\62\2\u044f\u0450\7Z\2\2\u0450\u0551\5b\62\2\u0451\u0452\7[\2"+
		"\2\u0452\u0551\5b\62\2\u0453\u0455\5b\62\2\u0454\u0456\t\t\2\2\u0455\u0454"+
		"\3\2\2\2\u0455\u0456\3\2\2\2\u0456\u0457\3\2\2\2\u0457\u0458\7^\2\2\u0458"+
		"\u0459\5b\62\2\u0459\u0551\3\2\2\2\u045a\u045c\5b\62\2\u045b\u045d\t\t"+
		"\2\2\u045c\u045b\3\2\2\2\u045c\u045d\3\2\2\2\u045d\u045e\3\2\2\2\u045e"+
		"\u045f\7\27\2\2\u045f\u0460\5b\62\2\u0460\u0551\3\2\2\2\u0461\u0463\5"+
		"d\63\2\u0462\u0464\t\t\2\2\u0463\u0462\3\2\2\2\u0463\u0464\3\2\2\2\u0464"+
		"\u0465\3\2\2\2\u0465\u0466\7\27\2\2\u0466\u0467\5d\63\2\u0467\u0551\3"+
		"\2\2\2\u0468\u046a\5d\63\2\u0469\u046b\t\t\2\2\u046a\u0469\3\2\2\2\u046a"+
		"\u046b\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u046d\7G\2\2\u046d\u046e\5d\63"+
		"\2\u046e\u0551\3\2\2\2\u046f\u0471\5d\63\2\u0470\u0472\t\t\2\2\u0471\u0470"+
		"\3\2\2\2\u0471\u0472\3\2\2\2\u0472\u0473\3\2\2\2\u0473\u0474\7_\2\2\u0474"+
		"\u0475\5d\63\2\u0475\u0551\3\2\2\2\u0476\u0478\5d\63\2\u0477\u0479\t\t"+
		"\2\2\u0478\u0477\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u047a\3\2\2\2\u047a"+
		"\u047b\7H\2\2\u047b\u047c\5d\63\2\u047c\u0551\3\2\2\2\u047d\u047f\5d\63"+
		"\2\u047e\u0480\t\t\2\2\u047f\u047e\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0481"+
		"\3\2\2\2\u0481\u0482\7`\2\2\u0482\u0483\5d\63\2\u0483\u0551\3\2\2\2\u0484"+
		"\u0485\b\61\1\2\u0485\u0486\7a\2\2\u0486\u0487\5f\64\2\u0487\u0488\7b"+
		"\2\2\u0488\u0489\5d\63\2\u0489\u048a\3\2\2\2\u048a\u048b\b\61\1\2\u048b"+
		"\u0551\3\2\2\2\u048c\u048d\7c\2\2\u048d\u048e\7\r\2\2\u048e\u048f\5r:"+
		"\2\u048f\u0490\7\16\2\2\u0490\u0551\3\2\2\2\u0491\u0492\7d\2\2\u0492\u0493"+
		"\7\r\2\2\u0493\u0494\5r:\2\u0494\u0495\7\b\2\2\u0495\u0496\5b\62\2\u0496"+
		"\u0497\7e\2\2\u0497\u0498\t\n\2\2\u0498\u0499\5b\62\2\u0499\u049a\7\16"+
		"\2\2\u049a\u0551\3\2\2\2\u049b\u049c\7f\2\2\u049c\u049d\7\r\2\2\u049d"+
		"\u049e\5r:\2\u049e\u049f\7\5\2\2\u049f\u04a0\5r:\2\u04a0\u04a1\7\5\2\2"+
		"\u04a1\u04a2\5r:\2\u04a2\u04a3\7\5\2\2\u04a3\u04a4\5r:\2\u04a4\u04a5\7"+
		"\16\2\2\u04a5\u0551\3\2\2\2\u04a6\u04a7\t\t\2\2\u04a7\u0551\5`\61\20\u04a8"+
		"\u04a9\b\61\1\2\u04a9\u04aa\7o\2\2\u04aa\u04bf\5f\64\2\u04ab\u04b5\7b"+
		"\2\2\u04ac\u04b6\5`\61\2\u04ad\u04b1\7\4\2\2\u04ae\u04b0\5`\61\2\u04af"+
		"\u04ae\3\2\2\2\u04b0\u04b3\3\2\2\2\u04b1\u04af\3\2\2\2\u04b1\u04b2\3\2"+
		"\2\2\u04b2\u04b4\3\2\2\2\u04b3\u04b1\3\2\2\2\u04b4\u04b6\7\6\2\2\u04b5"+
		"\u04ac\3\2\2\2\u04b5\u04ad\3\2\2\2\u04b6\u04c0\3\2\2\2\u04b7\u04bb\7\4"+
		"\2\2\u04b8\u04ba\5`\61\2\u04b9\u04b8\3\2\2\2\u04ba\u04bd\3\2\2\2\u04bb"+
		"\u04b9\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04be\3\2\2\2\u04bd\u04bb\3\2"+
		"\2\2\u04be\u04c0\7\6\2\2\u04bf\u04ab\3\2\2\2\u04bf\u04b7\3\2\2\2\u04c0"+
		"\u04c1\3\2\2\2\u04c1\u04c2\b\61\1\2\u04c2\u0551\3\2\2\2\u04c3\u04c4\b"+
		"\61\1\2\u04c4\u04c5\7[\2\2\u04c5\u04da\5f\64\2\u04c6\u04d0\7b\2\2\u04c7"+
		"\u04d1\5`\61\2\u04c8\u04cc\7\4\2\2\u04c9\u04cb\5`\61\2\u04ca\u04c9\3\2"+
		"\2\2\u04cb\u04ce\3\2\2\2\u04cc\u04ca\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd"+
		"\u04cf\3\2\2\2\u04ce\u04cc\3\2\2\2\u04cf\u04d1\7\6\2\2\u04d0\u04c7\3\2"+
		"\2\2\u04d0\u04c8\3\2\2\2\u04d1\u04db\3\2\2\2\u04d2\u04d6\7\4\2\2\u04d3"+
		"\u04d5\5`\61\2\u04d4\u04d3\3\2\2\2\u04d5\u04d8\3\2\2\2\u04d6\u04d4\3\2"+
		"\2\2\u04d6\u04d7\3\2\2\2\u04d7\u04d9\3\2\2\2\u04d8\u04d6\3\2\2\2\u04d9"+
		"\u04db\7\6\2\2\u04da\u04c6\3\2\2\2\u04da\u04d2\3\2\2\2\u04db\u04dc\3\2"+
		"\2\2\u04dc\u04dd\b\61\1\2\u04dd\u0551\3\2\2\2\u04de\u04df\b\61\1\2\u04df"+
		"\u04e0\7X\2\2\u04e0\u04f5\5f\64\2\u04e1\u04eb\7b\2\2\u04e2\u04ec\5`\61"+
		"\2\u04e3\u04e7\7\4\2\2\u04e4\u04e6\5`\61\2\u04e5\u04e4\3\2\2\2\u04e6\u04e9"+
		"\3\2\2\2\u04e7\u04e5\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8\u04ea\3\2\2\2\u04e9"+
		"\u04e7\3\2\2\2\u04ea\u04ec\7\6\2\2\u04eb\u04e2\3\2\2\2\u04eb\u04e3\3\2"+
		"\2\2\u04ec\u04f6\3\2\2\2\u04ed\u04f1\7\4\2\2\u04ee\u04f0\5`\61\2\u04ef"+
		"\u04ee\3\2\2\2\u04f0\u04f3\3\2\2\2\u04f1\u04ef\3\2\2\2\u04f1\u04f2\3\2"+
		"\2\2\u04f2\u04f4\3\2\2\2\u04f3\u04f1\3\2\2\2\u04f4\u04f6\7\6\2\2\u04f5"+
		"\u04e1\3\2\2\2\u04f5\u04ed\3\2\2\2\u04f6\u04f7\3\2\2\2\u04f7\u04f8\b\61"+
		"\1\2\u04f8\u0551\3\2\2\2\u04f9\u04fa\b\61\1\2\u04fa\u04fb\7Z\2\2\u04fb"+
		"\u0510\5f\64\2\u04fc\u0506\7b\2\2\u04fd\u0507\5`\61\2\u04fe\u0502\7\4"+
		"\2\2\u04ff\u0501\5`\61\2\u0500\u04ff\3\2\2\2\u0501\u0504\3\2\2\2\u0502"+
		"\u0500\3\2\2\2\u0502\u0503\3\2\2\2\u0503\u0505\3\2\2\2\u0504\u0502\3\2"+
		"\2\2\u0505\u0507\7\6\2\2\u0506\u04fd\3\2\2\2\u0506\u04fe\3\2\2\2\u0507"+
		"\u0511\3\2\2\2\u0508\u050c\7\4\2\2\u0509\u050b\5`\61\2\u050a\u0509\3\2"+
		"\2\2\u050b\u050e\3\2\2\2\u050c\u050a\3\2\2\2\u050c\u050d\3\2\2\2\u050d"+
		"\u050f\3\2\2\2\u050e\u050c\3\2\2\2\u050f\u0511\7\6\2\2\u0510\u04fc\3\2"+
		"\2\2\u0510\u0508\3\2\2\2\u0511\u0512\3\2\2\2\u0512\u0513\b\61\1\2\u0513"+
		"\u0551\3\2\2\2\u0514\u0515\b\61\1\2\u0515\u0516\7Y\2\2\u0516\u052b\5f"+
		"\64\2\u0517\u0521\7b\2\2\u0518\u0522\5`\61\2\u0519\u051d\7\4\2\2\u051a"+
		"\u051c\5`\61\2\u051b\u051a\3\2\2\2\u051c\u051f\3\2\2\2\u051d\u051b\3\2"+
		"\2\2\u051d\u051e\3\2\2\2\u051e\u0520\3\2\2\2\u051f\u051d\3\2\2\2\u0520"+
		"\u0522\7\6\2\2\u0521\u0518\3\2\2\2\u0521\u0519\3\2\2\2\u0522\u052c\3\2"+
		"\2\2\u0523\u0527\7\4\2\2\u0524\u0526\5`\61\2\u0525\u0524\3\2\2\2\u0526"+
		"\u0529\3\2\2\2\u0527\u0525\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u052a\3\2"+
		"\2\2\u0529\u0527\3\2\2\2\u052a\u052c\7\6\2\2\u052b\u0517\3\2\2\2\u052b"+
		"\u0523\3\2\2\2\u052c\u052d\3\2\2\2\u052d\u052e\b\61\1\2\u052e\u0551\3"+
		"\2\2\2\u052f\u0530\b\61\1\2\u0530\u0531\7p\2\2\u0531\u0546\5j\66\2\u0532"+
		"\u053c\7b\2\2\u0533\u053d\5`\61\2\u0534\u0538\7\4\2\2\u0535\u0537\5`\61"+
		"\2\u0536\u0535\3\2\2\2\u0537\u053a\3\2\2\2\u0538\u0536\3\2\2\2\u0538\u0539"+
		"\3\2\2\2\u0539\u053b\3\2\2\2\u053a\u0538\3\2\2\2\u053b\u053d\7\6\2\2\u053c"+
		"\u0533\3\2\2\2\u053c\u0534\3\2\2\2\u053d\u0547\3\2\2\2\u053e\u0542\7\4"+
		"\2\2\u053f\u0541\5`\61\2\u0540\u053f\3\2\2\2\u0541\u0544\3\2\2\2\u0542"+
		"\u0540\3\2\2\2\u0542\u0543\3\2\2\2\u0543\u0545\3\2\2\2\u0544\u0542\3\2"+
		"\2\2\u0545\u0547\7\6\2\2\u0546\u0532\3\2\2\2\u0546\u053e\3\2\2\2\u0547"+
		"\u0548\3\2\2\2\u0548\u0549\b\61\1\2\u0549\u0551\3\2\2\2\u054a\u0551\7"+
		"q\2\2\u054b\u0551\7r\2\2\u054c\u054d\7\21\2\2\u054d\u054e\5`\61\2\u054e"+
		"\u054f\7\22\2\2\u054f\u0551\3\2\2\2\u0550\u044a\3\2\2\2\u0550\u044d\3"+
		"\2\2\2\u0550\u044f\3\2\2\2\u0550\u0451\3\2\2\2\u0550\u0453\3\2\2\2\u0550"+
		"\u045a\3\2\2\2\u0550\u0461\3\2\2\2\u0550\u0468\3\2\2\2\u0550\u046f\3\2"+
		"\2\2\u0550\u0476\3\2\2\2\u0550\u047d\3\2\2\2\u0550\u0484\3\2\2\2\u0550"+
		"\u048c\3\2\2\2\u0550\u0491\3\2\2\2\u0550\u049b\3\2\2\2\u0550\u04a6\3\2"+
		"\2\2\u0550\u04a8\3\2\2\2\u0550\u04c3\3\2\2\2\u0550\u04de\3\2\2\2\u0550"+
		"\u04f9\3\2\2\2\u0550\u0514\3\2\2\2\u0550\u052f\3\2\2\2\u0550\u054a\3\2"+
		"\2\2\u0550\u054b\3\2\2\2\u0550\u054c\3\2\2\2\u0551\u0560\3\2\2\2\u0552"+
		"\u0553\f\17\2\2\u0553\u0554\t\13\2\2\u0554\u055f\5`\61\17\u0555\u0556"+
		"\f\16\2\2\u0556\u0557\t\f\2\2\u0557\u055f\5`\61\16\u0558\u0559\f\r\2\2"+
		"\u0559\u055a\t\r\2\2\u055a\u055f\5`\61\r\u055b\u055c\f\f\2\2\u055c\u055d"+
		"\t\16\2\2\u055d\u055f\5`\61\f\u055e\u0552\3\2\2\2\u055e\u0555\3\2\2\2"+
		"\u055e\u0558\3\2\2\2\u055e\u055b\3\2\2\2\u055f\u0562\3\2\2\2\u0560\u055e"+
		"\3\2\2\2\u0560\u0561\3\2\2\2\u0561a\3\2\2\2\u0562\u0560\3\2\2\2\u0563"+
		"\u0564\b\62\1\2\u0564\u0565\7s\2\2\u0565\u0589\5b\62\25\u0566\u0567\7"+
		"t\2\2\u0567\u0589\5b\62\24\u0568\u0569\7\65\2\2\u0569\u0589\5b\62\23\u056a"+
		"\u056b\b\62\1\2\u056b\u056c\7\4\2\2\u056c\u056d\5n8\2\u056d\u056e\7b\2"+
		"\2\u056e\u056f\5`\61\2\u056f\u0570\7\6\2\2\u0570\u0571\3\2\2\2\u0571\u0572"+
		"\b\62\1\2\u0572\u0589\3\2\2\2\u0573\u0574\t\r\2\2\u0574\u0575\5`\61\2"+
		"\u0575\u0576\7y\2\2\u0576\u0577\5b\62\2\u0577\u0578\7z\2\2\u0578\u0579"+
		"\5b\62\n\u0579\u0589\3\2\2\2\u057a\u0589\7{\2\2\u057b\u0589\7|\2\2\u057c"+
		"\u0589\7}\2\2\u057d\u0589\7~\2\2\u057e\u057f\7\21\2\2\u057f\u0580\5b\62"+
		"\2\u0580\u0581\7\22\2\2\u0581\u0589\3\2\2\2\u0582\u0583\6\62\6\2\u0583"+
		"\u0584\5t;\2\u0584\u0585\b\62\1\2\u0585\u0589\3\2\2\2\u0586\u0587\6\62"+
		"\7\2\u0587\u0589\5r:\2\u0588\u0563\3\2\2\2\u0588\u0566\3\2\2\2\u0588\u0568"+
		"\3\2\2\2\u0588\u056a\3\2\2\2\u0588\u0573\3\2\2\2\u0588\u057a\3\2\2\2\u0588"+
		"\u057b\3\2\2\2\u0588\u057c\3\2\2\2\u0588\u057d\3\2\2\2\u0588\u057e\3\2"+
		"\2\2\u0588\u0582\3\2\2\2\u0588\u0586\3\2\2\2\u0589\u05a9\3\2\2\2\u058a"+
		"\u058b\f\22\2\2\u058b\u058c\7\66\2\2\u058c\u05a8\5b\62\23\u058d\u058e"+
		"\f\21\2\2\u058e\u058f\7I\2\2\u058f\u05a8\5b\62\22\u0590\u0591\f\20\2\2"+
		"\u0591\u0592\7u\2\2\u0592\u05a8\5b\62\21\u0593\u0594\f\17\2\2\u0594\u0595"+
		"\7v\2\2\u0595\u05a8\5b\62\20\u0596\u0598\f\r\2\2\u0597\u0599\t\17\2\2"+
		"\u0598\u0597\3\2\2\2\u0598\u0599\3\2\2\2\u0599\u059a\3\2\2\2\u059a\u059c"+
		"\7e\2\2\u059b\u059d\t\17\2\2\u059c\u059b\3\2\2\2\u059c\u059d\3\2\2\2\u059d"+
		"\u059e\3\2\2\2\u059e\u05a8\5b\62\r\u059f\u05a0\f\f\2\2\u05a0\u05a1\7x"+
		"\2\2\u05a1\u05a8\5b\62\r\u05a2\u05a3\f\16\2\2\u05a3\u05a4\7\r\2\2\u05a4"+
		"\u05a5\5b\62\2\u05a5\u05a6\7\16\2\2\u05a6\u05a8\3\2\2\2\u05a7\u058a\3"+
		"\2\2\2\u05a7\u058d\3\2\2\2\u05a7\u0590\3\2\2\2\u05a7\u0593\3\2\2\2\u05a7"+
		"\u0596\3\2\2\2\u05a7\u059f\3\2\2\2\u05a7\u05a2\3\2\2\2\u05a8\u05ab\3\2"+
		"\2\2\u05a9\u05a7\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aac\3\2\2\2\u05ab\u05a9"+
		"\3\2\2\2\u05ac\u05ad\b\63\1\2\u05ad\u05ae\t\r\2\2\u05ae\u05af\5`\61\2"+
		"\u05af\u05b0\7y\2\2\u05b0\u05b1\5d\63\2\u05b1\u05b2\7z\2\2\u05b2\u05b3"+
		"\5d\63\f\u05b3\u05c1\3\2\2\2\u05b4\u05b5\7a\2\2\u05b5\u05c1\5b\62\2\u05b6"+
		"\u05b7\7.\2\2\u05b7\u05c1\5b\62\2\u05b8\u05ba\7u\2\2\u05b9\u05b8\3\2\2"+
		"\2\u05b9\u05ba\3\2\2\2\u05ba\u05bb\3\2\2\2\u05bb\u05c1\5v<\2\u05bc\u05bd"+
		"\7\21\2\2\u05bd\u05be\5d\63\2\u05be\u05bf\7\22\2\2\u05bf\u05c1\3\2\2\2"+
		"\u05c0\u05ac\3\2\2\2\u05c0\u05b4\3\2\2\2\u05c0\u05b6\3\2\2\2\u05c0\u05b9"+
		"\3\2\2\2\u05c0\u05bc\3\2\2\2\u05c1\u05d3\3\2\2\2\u05c2\u05c3\f\t\2\2\u05c3"+
		"\u05c4\t\20\2\2\u05c4\u05d2\5d\63\n\u05c5\u05c6\f\b\2\2\u05c6\u05c7\t"+
		"\21\2\2\u05c7\u05d2\5d\63\t\u05c8\u05c9\f\7\2\2\u05c9\u05ca\t\22\2\2\u05ca"+
		"\u05d2\5d\63\b\u05cb\u05cc\f\6\2\2\u05cc\u05cd\t\23\2\2\u05cd\u05d2\5"+
		"d\63\7\u05ce\u05cf\f\5\2\2\u05cf\u05d0\t\24\2\2\u05d0\u05d2\5d\63\6\u05d1"+
		"\u05c2\3\2\2\2\u05d1\u05c5\3\2\2\2\u05d1\u05c8\3\2\2\2\u05d1\u05cb\3\2"+
		"\2\2\u05d1\u05ce\3\2\2\2\u05d2\u05d5\3\2\2\2\u05d3\u05d1\3\2\2\2\u05d3"+
		"\u05d4\3\2\2\2\u05d4e\3\2\2\2\u05d5\u05d3\3\2\2\2\u05d6\u05db\5h\65\2"+
		"\u05d7\u05d8\7\5\2\2\u05d8\u05da\5h\65\2\u05d9\u05d7\3\2\2\2\u05da\u05dd"+
		"\3\2\2\2\u05db\u05d9\3\2\2\2\u05db\u05dc\3\2\2\2\u05dcg\3\2\2\2\u05dd"+
		"\u05db\3\2\2\2\u05de\u05e0\7\u0086\2\2\u05df\u05de\3\2\2\2\u05df\u05e0"+
		"\3\2\2\2\u05e0\u05e1\3\2\2\2\u05e1\u05e6\5t;\2\u05e2\u05e3\7\5\2\2\u05e3"+
		"\u05e5\5t;\2\u05e4\u05e2\3\2\2\2\u05e5\u05e8\3\2\2\2\u05e6\u05e4\3\2\2"+
		"\2\u05e6\u05e7\3\2\2\2\u05e7\u05e9\3\2\2\2\u05e8\u05e6\3\2\2\2\u05e9\u05eb"+
		"\7\b\2\2\u05ea\u05ec\7Z\2\2\u05eb\u05ea\3\2\2\2\u05eb\u05ec\3\2\2\2\u05ec"+
		"\u05ed\3\2\2\2\u05ed\u05ee\5b\62\2\u05ee\u05ef\b\65\1\2\u05ef\u0621\3"+
		"\2\2\2\u05f0\u05f2\7\u0086\2\2\u05f1\u05f0\3\2\2\2\u05f1\u05f2\3\2\2\2"+
		"\u05f2\u05f3\3\2\2\2\u05f3\u05f8\5t;\2\u05f4\u05f5\7\5\2\2\u05f5\u05f7"+
		"\5t;\2\u05f6\u05f4\3\2\2\2\u05f7\u05fa\3\2\2\2\u05f8\u05f6\3\2\2\2\u05f8"+
		"\u05f9\3\2\2\2\u05f9\u05fb\3\2\2\2\u05fa\u05f8\3\2\2\2\u05fb\u05fc\7\b"+
		"\2\2\u05fc\u05fd\7Y\2\2\u05fd\u05fe\5b\62\2\u05fe\u05ff\b\65\1\2\u05ff"+
		"\u0621\3\2\2\2\u0600\u0602\7\u0086\2\2\u0601\u0600\3\2\2\2\u0601\u0602"+
		"\3\2\2\2\u0602\u0603\3\2\2\2\u0603\u0608\5t;\2\u0604\u0605\7\5\2\2\u0605"+
		"\u0607\5t;\2\u0606\u0604\3\2\2\2\u0607\u060a\3\2\2\2\u0608\u0606\3\2\2"+
		"\2\u0608\u0609\3\2\2\2\u0609\u060b\3\2\2\2\u060a\u0608\3\2\2\2\u060b\u060c"+
		"\7\b\2\2\u060c\u060d\7[\2\2\u060d\u060e\5b\62\2\u060e\u060f\b\65\1\2\u060f"+
		"\u0621\3\2\2\2\u0610\u0612\7\u0086\2\2\u0611\u0610\3\2\2\2\u0611\u0612"+
		"\3\2\2\2\u0612\u0613\3\2\2\2\u0613\u0618\5t;\2\u0614\u0615\7\5\2\2\u0615"+
		"\u0617\5t;\2\u0616\u0614\3\2\2\2\u0617\u061a\3\2\2\2\u0618\u0616\3\2\2"+
		"\2\u0618\u0619\3\2\2\2\u0619\u061b\3\2\2\2\u061a\u0618\3\2\2\2\u061b\u061c"+
		"\7\b\2\2\u061c\u061d\7w\2\2\u061d\u061e\5b\62\2\u061e\u061f\b\65\1\2\u061f"+
		"\u0621\3\2\2\2\u0620\u05df\3\2\2\2\u0620\u05f1\3\2\2\2\u0620\u0601\3\2"+
		"\2\2\u0620\u0611\3\2\2\2\u0621i\3\2\2\2\u0622\u0627\5l\67\2\u0623\u0624"+
		"\7\5\2\2\u0624\u0626\5l\67\2\u0625\u0623\3\2\2\2\u0626\u0629\3\2\2\2\u0627"+
		"\u0625\3\2\2\2\u0627\u0628\3\2\2\2\u0628k\3\2\2\2\u0629\u0627\3\2\2\2"+
		"\u062a\u062f\5t;\2\u062b\u062c\7\5\2\2\u062c\u062e\5t;\2\u062d\u062b\3"+
		"\2\2\2\u062e\u0631\3\2\2\2\u062f\u062d\3\2\2\2\u062f\u0630\3\2\2\2\u0630"+
		"\u0632\3\2\2\2\u0631\u062f\3\2\2\2\u0632\u0633\7\27\2\2\u0633\u0634\5"+
		"b\62\2\u0634\u0635\3\2\2\2\u0635\u0636\b\67\1\2\u0636m\3\2\2\2\u0637\u063c"+
		"\5p9\2\u0638\u0639\7\5\2\2\u0639\u063b\5p9\2\u063a\u0638\3\2\2\2\u063b"+
		"\u063e\3\2\2\2\u063c\u063a\3\2\2\2\u063c\u063d\3\2\2\2\u063do\3\2\2\2"+
		"\u063e\u063c\3\2\2\2\u063f\u0641\7\u0086\2\2\u0640\u063f\3\2\2\2\u0640"+
		"\u0641\3\2\2\2\u0641\u0642\3\2\2\2\u0642\u0647\5t;\2\u0643\u0644\7\5\2"+
		"\2\u0644\u0646\5t;\2\u0645\u0643\3\2\2\2\u0646\u0649\3\2\2\2\u0647\u0645"+
		"\3\2\2\2\u0647\u0648\3\2\2\2\u0648\u064a\3\2\2\2\u0649\u0647\3\2\2\2\u064a"+
		"\u064c\7\b\2\2\u064b\u064d\7Z\2\2\u064c\u064b\3\2\2\2\u064c\u064d\3\2"+
		"\2\2\u064d\u064e\3\2\2\2\u064e\u064f\5b\62\2\u064f\u0650\3\2\2\2\u0650"+
		"\u0651\b9\1\2\u0651q\3\2\2\2\u0652\u0653\7\u008b\2\2\u0653s\3\2\2\2\u0654"+
		"\u0655\7\u008b\2\2\u0655u\3\2\2\2\u0656\u0657\7\u008a\2\2\u0657w\3\2\2"+
		"\2\u0658\u0682\5z>\2\u0659\u0682\7\30\2\2\u065a\u0682\7$\2\2\u065b\u0682"+
		"\7L\2\2\u065c\u0682\7M\2\2\u065d\u0682\7\31\2\2\u065e\u0682\7/\2\2\u065f"+
		"\u0682\7;\2\2\u0660\u0682\7\u0087\2\2\u0661\u0682\7T\2\2\u0662\u0682\7"+
		"%\2\2\u0663\u0682\7C\2\2\u0664\u0682\7\u0088\2\2\u0665\u0682\7\33\2\2"+
		"\u0666\u0682\7&\2\2\u0667\u0682\7\24\2\2\u0668\u0682\7S\2\2\u0669\u0682"+
		"\7\32\2\2\u066a\u0682\7\62\2\2\u066b\u0682\7\23\2\2\u066c\u0682\7\63\2"+
		"\2\u066d\u0682\7\'\2\2\u066e\u0682\7\26\2\2\u066f\u0682\7Q\2\2\u0670\u0682"+
		"\7O\2\2\u0671\u0682\7:\2\2\u0672\u0682\7-\2\2\u0673\u0682\7#\2\2\u0674"+
		"\u0682\7F\2\2\u0675\u0682\7\u0089\2\2\u0676\u0682\7\60\2\2\u0677\u0682"+
		"\7\34\2\2\u0678\u0682\7\64\2\2\u0679\u0682\7\37\2\2\u067a\u0682\7)\2\2"+
		"\u067b\u0682\7+\2\2\u067c\u0682\7 \2\2\u067d\u0682\7N\2\2\u067e\u0682"+
		"\7D\2\2\u067f\u0682\7<\2\2\u0680\u0682\7E\2\2\u0681\u0658\3\2\2\2\u0681"+
		"\u0659\3\2\2\2\u0681\u065a\3\2\2\2\u0681\u065b\3\2\2\2\u0681\u065c\3\2"+
		"\2\2\u0681\u065d\3\2\2\2\u0681\u065e\3\2\2\2\u0681\u065f\3\2\2\2\u0681"+
		"\u0660\3\2\2\2\u0681\u0661\3\2\2\2\u0681\u0662\3\2\2\2\u0681\u0663\3\2"+
		"\2\2\u0681\u0664\3\2\2\2\u0681\u0665\3\2\2\2\u0681\u0666\3\2\2\2\u0681"+
		"\u0667\3\2\2\2\u0681\u0668\3\2\2\2\u0681\u0669\3\2\2\2\u0681\u066a\3\2"+
		"\2\2\u0681\u066b\3\2\2\2\u0681\u066c\3\2\2\2\u0681\u066d\3\2\2\2\u0681"+
		"\u066e\3\2\2\2\u0681\u066f\3\2\2\2\u0681\u0670\3\2\2\2\u0681\u0671\3\2"+
		"\2\2\u0681\u0672\3\2\2\2\u0681\u0673\3\2\2\2\u0681\u0674\3\2\2\2\u0681"+
		"\u0675\3\2\2\2\u0681\u0676\3\2\2\2\u0681\u0677\3\2\2\2\u0681\u0678\3\2"+
		"\2\2\u0681\u0679\3\2\2\2\u0681\u067a\3\2\2\2\u0681\u067b\3\2\2\2\u0681"+
		"\u067c\3\2\2\2\u0681\u067d\3\2\2\2\u0681\u067e\3\2\2\2\u0681\u067f\3\2"+
		"\2\2\u0681\u0680\3\2\2\2\u0682y\3\2\2\2\u0683\u0684\7\u008b\2\2\u0684"+
		"{\3\2\2\2\u0685\u0686\t\25\2\2\u0686}\3\2\2\2\u0687\u0688\7\u008a\2\2"+
		"\u0688\177\3\2\2\2\u0689\u068b\7u\2\2\u068a\u0689\3\2\2\2\u068a\u068b"+
		"\3\2\2\2\u068b\u068c\3\2\2\2\u068c\u068d\7\u008a\2\2\u068d\u0081\3\2\2"+
		"\2\u00ed\u0083\u008c\u0099\u00aa\u00b3\u00be\u00c3\u00cc\u00d4\u00d8\u00de"+
		"\u00ea\u00ed\u00f6\u00f9\u0108\u0110\u011b\u0120\u0123\u0127\u012c\u0136"+
		"\u013c\u0154\u0156\u015b\u0168\u016b\u016e\u0172\u0177\u0180\u0183\u0187"+
		"\u0195\u0197\u019c\u01a6\u01a9\u01ac\u01b0\u01b3\u01b6\u01ba\u01bd\u01c5"+
		"\u01ca\u01d5\u01d8\u01dc\u01df\u01e8\u01ed\u01f1\u01f8\u01fb\u01ff\u0202"+
		"\u0205\u0209\u020c\u020f\u0213\u0216\u021d\u0222\u0227\u0234\u0237\u023b"+
		"\u023e\u0248\u024d\u0252\u0257\u025b\u0260\u0263\u0267\u026a\u026d\u0271"+
		"\u027b\u027e\u0285\u0287\u028f\u0292\u0299\u029c\u02a0\u02a3\u02ac\u02ae"+
		"\u02b3\u02b7\u02be\u02c5\u02c8\u02cc\u02cf\u02d5\u02da\u02e0\u02e3\u02e7"+
		"\u02ec\u02f1\u02f3\u02f9\u02fd\u0302\u0305\u030c\u030e\u0313\u0318\u031e"+
		"\u0322\u0327\u032a\u0334\u0336\u033b\u0340\u0344\u034b\u0351\u0355\u035e"+
		"\u0363\u0370\u0372\u0377\u037a\u037e\u0388\u0396\u03a1\u03ad\u03b9\u03bc"+
		"\u03c0\u03c4\u03cb\u03d0\u03d7\u03db\u03e4\u03e9\u03ed\u03f1\u03f4\u03fb"+
		"\u03fd\u0401\u0405\u040c\u040e\u0412\u0416\u041d\u041f\u0423\u0427\u042b"+
		"\u042f\u0433\u0437\u043b\u043f\u0446\u0455\u045c\u0463\u046a\u0471\u0478"+
		"\u047f\u04b1\u04b5\u04bb\u04bf\u04cc\u04d0\u04d6\u04da\u04e7\u04eb\u04f1"+
		"\u04f5\u0502\u0506\u050c\u0510\u051d\u0521\u0527\u052b\u0538\u053c\u0542"+
		"\u0546\u0550\u055e\u0560\u0588\u0598\u059c\u05a7\u05a9\u05b9\u05c0\u05d1"+
		"\u05d3\u05db\u05df\u05e6\u05eb\u05f1\u05f8\u0601\u0608\u0611\u0618\u0620"+
		"\u0627\u062f\u063c\u0640\u0647\u064c\u0681\u068a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}