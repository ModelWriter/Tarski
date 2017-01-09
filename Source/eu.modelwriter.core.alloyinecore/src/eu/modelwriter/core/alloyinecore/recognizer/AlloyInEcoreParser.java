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
		RULE_pathName = 37, RULE_typedMultiplicityRef = 38, RULE_body = 39, RULE_invariant = 40, 
		RULE_precondition = 41, RULE_postcondition = 42, RULE_initial = 43, RULE_derivation = 44, 
		RULE_visibilityKind = 45, RULE_atom = 46, RULE_arity = 47, RULE_formula = 48, 
		RULE_expression = 49, RULE_intexpression = 50, RULE_decls = 51, RULE_decl = 52, 
		RULE_letDecls = 53, RULE_letDecl = 54, RULE_comprehensionDecls = 55, RULE_comprehensionDecl = 56, 
		RULE_relationId = 57, RULE_variableId = 58, RULE_integer = 59, RULE_unrestrictedName = 60, 
		RULE_identifier = 61, RULE_upper = 62, RULE_lower = 63, RULE_signed = 64;
	public static final String[] ruleNames = {
		"problem", "options", "option", "universe", "relations", "relation", "tupleSet", 
		"tuple", "module", "packageImport", "ePackage", "eClassifier", "eClass", 
		"eStructuralFeature", "eAttribute", "eReference", "eOperation", "eParameter", 
		"eMultiplicity", "eDataType", "ePrimitiveType", "eEnum", "eEnumLiteral", 
		"eAnnotation", "eDetail", "eModelElement", "eNamedElement", "eTypedElement", 
		"eModelElementRef", "templateSignature", "typeParameter", "typeRef", "typedRef", 
		"typedTypeRef", "wildcardTypeRef", "templateBinding", "templateParameterSubstitution", 
		"pathName", "typedMultiplicityRef", "body", "invariant", "precondition", 
		"postcondition", "initial", "derivation", "visibilityKind", "atom", "arity", 
		"formula", "expression", "intexpression", "decls", "decl", "letDecls", 
		"letDecl", "comprehensionDecls", "comprehensionDecl", "relationId", "variableId", 
		"integer", "unrestrictedName", "identifier", "upper", "lower", "signed"
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
	    /*
	    * Register XML Factory implementation to handle .ecore files
	    */
	    metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
	            "ecore", new XMLResourceFactoryImpl());

	    /*
	    * Create empty resource with the given URI
	    */
	    Resource metaResource = metaResourceSet.createResource(URI.createURI(this.pathName + this.fileName + ".ecore"));

	    /*
	    * Add bookStoreEPackage to contents list of the resource
	    */
	    metaResource.getContents().add(root);

	    try {
	        /*
	        * Save the resource
	        */
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
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(130);
				options();
				}
			}

			setState(133);
			universe();
			printUniverse();
			setState(135);
			relations();
			printBounds();
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					((ProblemContext)_localctx).formula = formula(0);
					((ProblemContext)_localctx).formulas.add(((ProblemContext)_localctx).formula);
					}
					} 
				}
				setState(142);
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
			setState(146);
			match(T__0);
			setState(147);
			match(T__1);
			setState(148);
			option();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(149);
				match(T__2);
				setState(150);
				option();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
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
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				((SymmetryBreakingContext)_localctx).key = match(T__4);
				setState(159);
				match(T__5);
				setState(160);
				((SymmetryBreakingContext)_localctx).value = integer();
				}
				break;
			case T__6:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				((BitWidthContext)_localctx).key = match(T__6);
				setState(162);
				match(T__5);
				setState(163);
				((BitWidthContext)_localctx).value = integer();
				}
				break;
			case T__7:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				((SkolemDepthContext)_localctx).key = match(T__7);
				setState(165);
				match(T__5);
				setState(166);
				((SkolemDepthContext)_localctx).value = integer();
				}
				break;
			case T__8:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				((SharingContext)_localctx).key = match(T__8);
				setState(168);
				match(T__5);
				setState(169);
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
			setState(172);
			match(T__9);
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(173);
				match(T__1);
				{
				setState(174);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(175);
					match(T__2);
					setState(176);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(182);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				{
				setState(184);
				match(T__10);
				{
				setState(185);
				((UniverseContext)_localctx).atom = atom();
				((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(186);
					match(T__2);
					setState(187);
					((UniverseContext)_localctx).atom = atom();
					((UniverseContext)_localctx).atoms.add(((UniverseContext)_localctx).atom);
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(193);
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
			setState(199);
			match(T__12);
			setState(200);
			match(T__1);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(201);
				relation();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
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
			setState(210);
			((RelationContext)_localctx).name = ((RelationContext)_localctx).identifier = identifier();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(211);
				((RelationContext)_localctx).arity = arity();
				}
			}

			setState(214);
			match(T__5);
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(215);
				expression(0);
				}
				break;
			}
			setState(218);
			match(T__10);
			{
			setState(219);
			((RelationContext)_localctx).lowerBound = tupleSet();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(220);
				match(T__2);
				setState(221);
				((RelationContext)_localctx).upperBound = tupleSet();
				}
			}

			}
			setState(224);
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
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(T__1);
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10 || _la==T__14) {
					{
					setState(229);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(234);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(230);
						match(T__2);
						setState(231);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(236);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(239);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(T__10);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10 || _la==T__14) {
					{
					setState(241);
					((TupleSetContext)_localctx).tuple = tuple();
					((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(242);
						match(T__2);
						setState(243);
						((TupleSetContext)_localctx).tuple = tuple();
						((TupleSetContext)_localctx).tuples.add(((TupleSetContext)_localctx).tuple);
						}
						}
						setState(248);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(251);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(252);
				match(T__1);
				setState(253);
				((TupleSetContext)_localctx).left = tuple();
				setState(254);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(255);
				((TupleSetContext)_localctx).right = tuple();
				setState(256);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(258);
				match(T__10);
				setState(259);
				((TupleSetContext)_localctx).left = tuple();
				setState(260);
				((TupleSetContext)_localctx).range = match(T__13);
				setState(261);
				((TupleSetContext)_localctx).right = tuple();
				setState(262);
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
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				match(T__14);
				setState(267);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(268);
					match(T__2);
					setState(269);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(275);
				match(T__15);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				match(T__10);
				setState(278);
				((TupleContext)_localctx).atom = atom();
				((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(279);
					match(T__2);
					setState(280);
					((TupleContext)_localctx).atom = atom();
					((TupleContext)_localctx).atoms.add(((TupleContext)_localctx).atom);
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(286);
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
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(290);
				options();
				}
			}

			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(293);
				match(T__16);
				setState(294);
				identifier();
				}
			}

			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(297);
				((ModuleContext)_localctx).packageImport = packageImport();
				((ModuleContext)_localctx).ownedPackageImport.add(((ModuleContext)_localctx).packageImport);
				}
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(303);
			((ModuleContext)_localctx).ownedPackage = ePackage();

			        Document.getInstance().signalParsingCompletion();
			        saveResource(((ModuleContext)_localctx).ownedPackage.element);
			    
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
			setState(306);
			match(T__17);
			}
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(307);
				((PackageImportContext)_localctx).name = identifier();
				setState(308);
				match(T__5);
				}
			}

			setState(312);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(313);
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
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(315);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(318);
			match(T__19);
			setState(319);
			((EPackageContext)_localctx).name = unrestrictedName();
			{
			setState(320);
			match(T__5);
			setState(321);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(323);
			match(T__20);
			setState(324);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}

			    ((EPackageContext)_localctx).element =  eFactory.createEPackage();
			    _localctx.element.setName((((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null));
			    _localctx.element.setNsPrefix((((EPackageContext)_localctx).nsPrefix!=null?_input.getText(((EPackageContext)_localctx).nsPrefix.start,((EPackageContext)_localctx).nsPrefix.stop):null));
			    _localctx.element.setNsURI((((EPackageContext)_localctx).nsURI!=null?((EPackageContext)_localctx).nsURI.getText():null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(347);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(327);
				match(T__1);
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__30) | (1L << T__31) | (1L << T__55) | (1L << T__56))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__66 - 65)) | (1L << (T__74 - 65)) | (1L << (T__75 - 65)) | (1L << (T__82 - 65)) | (1L << (T__83 - 65)) | (1L << (T__84 - 65)))) != 0)) {
					{
					setState(340);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(328);
						((EPackageContext)_localctx).eAnnotation = ((EPackageContext)_localctx).eAnnotation = eAnnotation();
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(331);
						((EPackageContext)_localctx).ePackage = ((EPackageContext)_localctx).ePackage = ePackage();
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						_localctx.element.getESubpackages().add(((EPackageContext)_localctx).ePackage.element);
						}
						break;
					case 3:
						{
						setState(334);
						((EPackageContext)_localctx).eClassifier = ((EPackageContext)_localctx).eClassifier = eClassifier();
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						_localctx.element.getEClassifiers().add(((EPackageContext)_localctx).eClassifier.element);
						}
						break;
					case 4:
						{
						setState(337);
						((EPackageContext)_localctx).invariant = invariant();
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						 
						}
						break;
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(345);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(346);
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
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				((EClassifierContext)_localctx).eClass = eClass();
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eClass.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				((EClassifierContext)_localctx).eDataType = eDataType();
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eDataType.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
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
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(362);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				{
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(365);
					((EClassContext)_localctx).isAbstract = match(T__21);
					}
				}

				setState(368);
				((EClassContext)_localctx).isClass = match(T__22);
				}
				break;
			case T__23:
				{
				setState(369);
				((EClassContext)_localctx).isInterface = match(T__23);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(372);
			((EClassContext)_localctx).name = unrestrictedName();

			    ((EClassContext)_localctx).element =  eFactory.createEClass();
			    _localctx.element.setName((((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(374);
				((EClassContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(377);
				match(T__24);
				setState(378);
				((EClassContext)_localctx).typedRef = typedRef();
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).typedRef);
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(379);
					match(T__2);
					setState(380);
					((EClassContext)_localctx).typedRef = typedRef();
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).typedRef);
					}
					}
					setState(385);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(388);
				match(T__5);
				setState(389);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

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
		public TypedMultiplicityRefContext eAttributeType;
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
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public TypedMultiplicityRefContext typedMultiplicityRef() {
			return getRuleContext(TypedMultiplicityRefContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
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
			    
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(448);
				match(T__5);
				setState(449);
				((EAttributeContext)_localctx).eAttributeType = typedMultiplicityRef();
				}
			}

			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(452);
				match(T__20);
				setState(453);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(456);
				match(T__1);
				setState(470); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(465);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__34:
						{
						setState(457);
						((EAttributeContext)_localctx).s35 = match(T__34);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(458);
						((EAttributeContext)_localctx).s36 = match(T__35);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(459);
						((EAttributeContext)_localctx).s37 = match(T__36);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(460);
						((EAttributeContext)_localctx).s38 = match(T__37);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(461);
						((EAttributeContext)_localctx).s39 = match(T__38);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(462);
						((EAttributeContext)_localctx).s40 = match(T__39);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(463);
						((EAttributeContext)_localctx).s41 = match(T__40);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(464);
						((EAttributeContext)_localctx).s42 = match(T__41);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(468);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(467);
						match(T__2);
						}
					}

					}
					}
					setState(472); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0) );
				setState(474);
				match(T__3);
				}
				break;
			}
			setState(504);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(477);
				match(T__1);
				setState(499);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					{
					setState(481);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(478);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation();
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						}
						}
						setState(483);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(486);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__81:
						{
						setState(484);
						((EAttributeContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__80:
						{
						setState(485);
						((EAttributeContext)_localctx).ownedInitial = initial();
						}
						break;
					case T__3:
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
					}
					break;
				case 2:
					{
					{
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
					case T__66:
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(496);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(493);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation();
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						}
						}
						setState(498);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				}
				_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
				setState(502);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(503);
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
		public TypedMultiplicityRefContext eReferenceType;
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
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public TypedMultiplicityRefContext typedMultiplicityRef() {
			return getRuleContext(TypedMultiplicityRefContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
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
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(506);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(509);
				((EReferenceContext)_localctx).s26 = match(T__25);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
				}
			}

			setState(514);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(512);
				((EReferenceContext)_localctx).s27 = match(T__26);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(513);
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
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(516);
				((EReferenceContext)_localctx).s29 = match(T__28);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
				}
			}

			setState(520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(519);
				((EReferenceContext)_localctx).s30 = match(T__29);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
				}
			}

			setState(524);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(522);
				((EReferenceContext)_localctx).s31 = match(T__30);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(523);
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
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(526);
				((EReferenceContext)_localctx).s33 = match(T__32);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s33);
				}
			}

			setState(529);
			match(T__42);
			setState(530);
			((EReferenceContext)_localctx).name = unrestrictedName();

			    ((EReferenceContext)_localctx).element =  eFactory.createEReference();
			    _localctx.element.setName((((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__43) {
				{
				setState(532);
				match(T__43);
				setState(533);
				((EReferenceContext)_localctx).eOpposite = unrestrictedName();
				}
			}

			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(536);
				match(T__5);
				setState(537);
				((EReferenceContext)_localctx).eReferenceType = typedMultiplicityRef();
				}
			}

			setState(542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(540);
				match(T__20);
				setState(541);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(565);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(544);
				match(T__1);
				setState(560); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(555);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__44:
						{
						setState(545);
						((EReferenceContext)_localctx).s45 = match(T__44);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s45);
						}
						break;
					case T__34:
						{
						setState(546);
						((EReferenceContext)_localctx).s35 = match(T__34);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s35);
						}
						break;
					case T__36:
						{
						setState(547);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(548);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(549);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(550);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					case T__45:
						{
						setState(551);
						((EReferenceContext)_localctx).s46 = match(T__45);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s46);
						}
						break;
					case T__46:
						{
						setState(552);
						((EReferenceContext)_localctx).s47 = match(T__46);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s47);
						}
						break;
					case T__40:
						{
						setState(553);
						((EReferenceContext)_localctx).s41 = match(T__40);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(554);
						((EReferenceContext)_localctx).s42 = match(T__41);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(558);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(557);
						match(T__2);
						}
					}

					}
					}
					setState(562); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0) );
				setState(564);
				match(T__3);
				}
				break;
			}
			setState(605);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(567);
				match(T__1);
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__47) {
					{
					setState(568);
					match(T__47);
					setState(569);
					((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
					setState(574);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(570);
						match(T__2);
						setState(571);
						((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
						}
						}
						setState(576);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(577);
					match(T__18);
					}
				}

				setState(601);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					{
					setState(584);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(581);
						((EReferenceContext)_localctx).eAnnotation = eAnnotation();
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						}
						}
						setState(586);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(589);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__81:
						{
						setState(587);
						((EReferenceContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__80:
						{
						setState(588);
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
					setState(593);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__81:
						{
						setState(591);
						((EReferenceContext)_localctx).ownedDerivation = derivation();
						}
						break;
					case T__80:
						{
						setState(592);
						((EReferenceContext)_localctx).ownedInitial = initial();
						}
						break;
					case T__3:
					case T__66:
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(598);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__66) {
						{
						{
						setState(595);
						((EReferenceContext)_localctx).eAnnotation = eAnnotation();
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						}
						}
						setState(600);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				}
				setState(603);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(604);
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
		public TypedMultiplicityRefContext eReturnType;
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
		public TypedMultiplicityRefContext typedMultiplicityRef() {
			return getRuleContext(TypedMultiplicityRefContext.class,0);
		}
		public List<TypedRefContext> typedRef() {
			return getRuleContexts(TypedRefContext.class);
		}
		public TypedRefContext typedRef(int i) {
			return getRuleContext(TypedRefContext.class,i);
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
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(607);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(611);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(610);
				((EOperationContext)_localctx).s26 = match(T__25);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
				}
			}

			setState(613);
			match(T__48);
			setState(615);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(614);
				((EOperationContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(617);
			((EOperationContext)_localctx).name = unrestrictedName();

			    ((EOperationContext)_localctx).element =  eFactory.createEOperation();
			    _localctx.element.setName((((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(619);
			match(T__14);
			setState(628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__30 - 17)) | (1L << (T__31 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__73 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)) | (1L << (T__76 - 17)) | (1L << (T__78 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__132 - 81)) | (1L << (T__133 - 81)) | (1L << (T__134 - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(620);
				((EOperationContext)_localctx).eParameter = eParameter();
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(621);
					match(T__2);
					setState(622);
					((EOperationContext)_localctx).eParameter = eParameter();
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(627);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(630);
			match(T__15);
			for (EParameterContext ctx: ((EOperationContext)_localctx).eParameters){_localctx.element.getEParameters().add(ctx.element);}
			setState(634);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(632);
				match(T__5);
				setState(633);
				((EOperationContext)_localctx).eReturnType = typedMultiplicityRef();
				}
			}

			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__49) {
				{
				setState(636);
				match(T__49);
				setState(637);
				((EOperationContext)_localctx).typedRef = typedRef();
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).typedRef);
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(638);
					match(T__2);
					setState(639);
					((EOperationContext)_localctx).typedRef = typedRef();
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).typedRef);
					}
					}
					setState(644);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(662);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
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
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(648);
						((EOperationContext)_localctx).s37 = match(T__36);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(649);
						((EOperationContext)_localctx).s38 = match(T__37);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(650);
						((EOperationContext)_localctx).s39 = match(T__38);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(651);
						((EOperationContext)_localctx).s40 = match(T__39);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s40);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(655);
					_errHandler.sync(this);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(661);
				match(T__3);
				}
				break;
			}
			setState(678);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(664);
				match(T__1);
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__73 - 67)) | (1L << (T__76 - 67)) | (1L << (T__77 - 67)) | (1L << (T__78 - 67)) | (1L << (T__79 - 67)))) != 0)) {
					{
					setState(671);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(665);
						((EOperationContext)_localctx).eAnnotation = ((EOperationContext)_localctx).eAnnotation = eAnnotation();
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).eAnnotation.element);
						}
						break;
					case T__76:
					case T__77:
						{
						setState(668);
						((EOperationContext)_localctx).precondition = precondition();
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						}
						break;
					case T__73:
						{
						setState(669);
						((EOperationContext)_localctx).body = body();
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						}
						break;
					case T__78:
					case T__79:
						{
						setState(670);
						((EOperationContext)_localctx).postcondition = postcondition();
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						}
						break;
					default:
						throw new NoViableAltException(this);
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
				break;
			case T__18:
				{
				setState(677);
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
		public TypedMultiplicityRefContext eParameterType;
		public Token s37;
		public Token s38;
		public Token s39;
		public Token s40;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TypedMultiplicityRefContext typedMultiplicityRef() {
			return getRuleContext(TypedMultiplicityRefContext.class,0);
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
			setState(682);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(680);
				((EParameterContext)_localctx).s31 = match(T__30);
				((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(681);
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
			setState(684);
			((EParameterContext)_localctx).name = unrestrictedName();

			    ((EParameterContext)_localctx).element =  eFactory.createEParameter();
			    _localctx.element.setName((((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			{
			setState(686);
			match(T__5);
			setState(688);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				{
				setState(687);
				((EParameterContext)_localctx).eParameterType = typedMultiplicityRef();
				}
				break;
			}
			}
			setState(705);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(690);
				match(T__1);
				setState(700); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(695);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(691);
						((EParameterContext)_localctx).s37 = match(T__36);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(692);
						((EParameterContext)_localctx).s38 = match(T__37);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(693);
						((EParameterContext)_localctx).s39 = match(T__38);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(694);
						((EParameterContext)_localctx).s40 = match(T__39);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s40);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(698);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(697);
						match(T__2);
						}
					}

					}
					}
					setState(702); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(704);
				match(T__3);
				}
				break;
			}
			setState(716);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(707);
				match(T__1);
				setState(711);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(708);
					((EParameterContext)_localctx).eAnnotation = ((EParameterContext)_localctx).eAnnotation = eAnnotation();
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(713);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EParameterContext)_localctx).eAnnotation.element);
				setState(715);
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
			setState(718);
			match(T__10);
			setState(725);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(719);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(722);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(720);
					match(T__13);
					setState(721);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__50:
			case T__51:
			case T__52:
				{
				setState(724);
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
			setState(729);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__53:
				{
				setState(727);
				match(T__53);
				}
				break;
			case T__54:
				{
				setState(728);
				((EMultiplicityContext)_localctx).isNullFree = match(T__54);
				}
				break;
			case T__11:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(731);
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
			setState(734);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(733);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(741);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__55:
				{
				setState(736);
				((EDataTypeContext)_localctx).s56 = match(T__55);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s56);
				}
				break;
			case T__30:
			case T__31:
				{
				setState(739);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__30:
					{
					setState(737);
					((EDataTypeContext)_localctx).s31 = match(T__30);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s31);
					}
					break;
				case T__31:
					{
					setState(738);
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
			setState(743);
			match(T__56);
			setState(744);
			((EDataTypeContext)_localctx).name = unrestrictedName();

			    ((EDataTypeContext)_localctx).element =  eFactory.createEDataType();
			    _localctx.element.setName((((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(747);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(746);
				((EDataTypeContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(749);
				match(T__5);
				setState(750);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(759);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				{
				setState(753);
				match(T__1);
				setState(756);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(754);
					((EDataTypeContext)_localctx).s58 = match(T__57);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s58);
					}
					break;
				case T__58:
					{
					setState(755);
					((EDataTypeContext)_localctx).s59 = match(T__58);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s59);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(758);
				match(T__3);
				}
				break;
			}
			setState(773);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(761);
				match(T__1);
				setState(768);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__74 - 67)) | (1L << (T__75 - 67)))) != 0)) {
					{
					setState(766);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(762);
						((EDataTypeContext)_localctx).eAnnotation = ((EDataTypeContext)_localctx).eAnnotation = eAnnotation();
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).eAnnotation.element);
						}
						break;
					case T__74:
					case T__75:
						{
						setState(765);
						((EDataTypeContext)_localctx).invariant = invariant();
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(770);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(771);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(772);
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
			setState(775);
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
			setState(778);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(777);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(780);
			match(T__64);
			setState(781);
			((EEnumContext)_localctx).name = unrestrictedName();

			    ((EEnumContext)_localctx).element =  eFactory.createEEnum();
			    _localctx.element.setName((((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(784);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(783);
				((EEnumContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(788);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(786);
				match(T__5);
				setState(787);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(796);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				{
				setState(790);
				match(T__1);
				setState(793);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(791);
					((EEnumContext)_localctx).s58 = match(T__57);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s58);
					}
					break;
				case T__58:
					{
					setState(792);
					((EEnumContext)_localctx).s59 = match(T__58);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s59);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(795);
				match(T__3);
				}
				break;
			}
			setState(813);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(798);
				match(T__1);
				setState(808);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__73 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)) | (1L << (T__76 - 17)) | (1L << (T__78 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__132 - 81)) | (1L << (T__133 - 81)) | (1L << (T__134 - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(806);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
					case 1:
						{
						setState(799);
						((EEnumContext)_localctx).eAnnotation = ((EEnumContext)_localctx).eAnnotation = eAnnotation();
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(802);
						((EEnumContext)_localctx).eEnumLiteral = ((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral();
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						_localctx.element.getELiterals().add(((EEnumContext)_localctx).eEnumLiteral.element);
						}
						break;
					case 3:
						{
						setState(805);
						((EEnumContext)_localctx).invariant = invariant();
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(810);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(811);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(812);
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
			setState(818);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				{
				{
				setState(815);
				match(T__65);
				setState(816);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(817);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			setState(822);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(820);
				match(T__20);
				setState(821);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}


			    ((EEnumLiteralContext)_localctx).element =  eFactory.createEEnumLiteral();
			    _localctx.element.setName((((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null));
			    Document.getInstance().addNamedElement(_localctx.element, _localctx, _localctx.name.start);
			    
			setState(835);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(825);
				match(T__1);
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(826);
					((EEnumLiteralContext)_localctx).eAnnotation = ((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation();
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(831);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EEnumLiteralContext)_localctx).eAnnotation.element);
				setState(833);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(834);
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
			setState(837);
			match(T__66);
			setState(839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(838);
				((EAnnotationContext)_localctx).source = match(SINGLE_QUOTED_STRING);
				}
			}


				((EAnnotationContext)_localctx).element =  eFactory.createEAnnotation();
				_localctx.element.setSource((((EAnnotationContext)_localctx).source!=null?((EAnnotationContext)_localctx).source.getText():null).replace("'", "") );
				
			setState(853);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(842);
				match(T__14);
				setState(843);
				((EAnnotationContext)_localctx).eDetail = eDetail();
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(848);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(844);
					match(T__2);
					setState(845);
					((EAnnotationContext)_localctx).eDetail = eDetail();
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(850);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(851);
				match(T__15);
				}
			}

			for (EDetailContext ctx: ((EAnnotationContext)_localctx).ownedDetails){_localctx.element.getDetails().put(ctx.k, ctx.v);}
				
			setState(871);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(856);
				match(T__1);
				setState(864); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(864);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
					case 1:
						{
						setState(857);
						((EAnnotationContext)_localctx).eAnnotation = ((EAnnotationContext)_localctx).eAnnotation = eAnnotation();
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAnnotationContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(860);
						((EAnnotationContext)_localctx).eModelElement = ((EAnnotationContext)_localctx).eModelElement = eModelElement();
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						_localctx.element.getContents().add(((EAnnotationContext)_localctx).eModelElement.element);
						}
						break;
					case 3:
						{
						setState(863);
						((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef();
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						}
						break;
					}
					}
					setState(866); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__26 - 17)) | (1L << (T__27 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__30 - 17)) | (1L << (T__31 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__73 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)) | (1L << (T__76 - 17)) | (1L << (T__78 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)) | (1L << (T__83 - 81)) | (1L << (T__84 - 81)) | (1L << (T__132 - 81)) | (1L << (T__133 - 81)) | (1L << (T__134 - 81)) | (1L << (IDENTIFIER - 81)))) != 0) );
				setState(868);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(870);
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
			setState(874);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(873);
				((EDetailContext)_localctx).key = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(876);
			match(T__20);
			setState(878);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) {
				{
				setState(877);
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
			setState(888);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(882);
				((EModelElementContext)_localctx).eAnnotation = eAnnotation();
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eAnnotation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(885);
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
			setState(902);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(890);
				((ENamedElementContext)_localctx).eTypedElement = eTypedElement();
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eTypedElement.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(893);
				((ENamedElementContext)_localctx).eClassifier = eClassifier();
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eClassifier.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(896);
				((ENamedElementContext)_localctx).ePackage = ePackage();
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).ePackage.element;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(899);
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
			setState(913);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(904);
				((ETypedElementContext)_localctx).eOperation = eOperation();
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eOperation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(907);
				((ETypedElementContext)_localctx).eParameter = eParameter();
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eParameter.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(910);
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
			setState(915);
			match(T__67);
			setState(916);
			((EModelElementRefContext)_localctx).ownedPathName = pathName();
			setState(917);
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
			setState(919);
			match(T__68);
			setState(920);
			((TemplateSignatureContext)_localctx).typeParameter = typeParameter();
			((TemplateSignatureContext)_localctx).ownedParameters.add(((TemplateSignatureContext)_localctx).typeParameter);
			setState(925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(921);
				match(T__2);
				setState(922);
				((TemplateSignatureContext)_localctx).typeParameter = typeParameter();
				((TemplateSignatureContext)_localctx).ownedParameters.add(((TemplateSignatureContext)_localctx).typeParameter);
				}
				}
				setState(927);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(928);
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
			setState(930);
			((TypeParameterContext)_localctx).name = unrestrictedName();
			setState(940);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(931);
				match(T__24);
				setState(932);
				((TypeParameterContext)_localctx).typedRef = typedRef();
				((TypeParameterContext)_localctx).ownedExtends.add(((TypeParameterContext)_localctx).typedRef);
				setState(937);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__70) {
					{
					{
					setState(933);
					match(T__70);
					setState(934);
					((TypeParameterContext)_localctx).typedRef = typedRef();
					((TypeParameterContext)_localctx).ownedExtends.add(((TypeParameterContext)_localctx).typedRef);
					}
					}
					setState(939);
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
			setState(944);
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
				setState(942);
				typedRef();
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 2);
				{
				setState(943);
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
			setState(948);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
				enterOuterAlt(_localctx, 1);
				{
				setState(946);
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
				setState(947);
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
			setState(950);
			((TypedTypeRefContext)_localctx).ownedPathName = pathName();
			setState(955);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(951);
				match(T__68);
				setState(952);
				((TypedTypeRefContext)_localctx).ownedBinding = templateBinding();
				setState(953);
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
			setState(957);
			match(T__52);
			setState(960);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24 || _la==T__71) {
				{
				setState(958);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__71) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(959);
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
			setState(962);
			((TemplateBindingContext)_localctx).templateParameterSubstitution = templateParameterSubstitution();
			((TemplateBindingContext)_localctx).ownedSubstitutions.add(((TemplateBindingContext)_localctx).templateParameterSubstitution);
			setState(967);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(963);
				match(T__2);
				setState(964);
				((TemplateBindingContext)_localctx).templateParameterSubstitution = templateParameterSubstitution();
				((TemplateBindingContext)_localctx).ownedSubstitutions.add(((TemplateBindingContext)_localctx).templateParameterSubstitution);
				}
				}
				setState(969);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(971);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(970);
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
			setState(973);
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
			setState(975);
			((PathNameContext)_localctx).unrestrictedName = unrestrictedName();
			((PathNameContext)_localctx).ownedPathElements.add(((PathNameContext)_localctx).unrestrictedName);
			setState(980);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__72) {
				{
				{
				setState(976);
				match(T__72);
				setState(977);
				((PathNameContext)_localctx).unrestrictedName = unrestrictedName();
				((PathNameContext)_localctx).ownedPathElements.add(((PathNameContext)_localctx).unrestrictedName);
				}
				}
				setState(982);
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

	public static class TypedMultiplicityRefContext extends ParserRuleContext {
		public EMultiplicityContext ownedMultiplicity;
		public TypedRefContext typedRef() {
			return getRuleContext(TypedRefContext.class,0);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
		}
		public TypedMultiplicityRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedMultiplicityRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterTypedMultiplicityRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitTypedMultiplicityRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitTypedMultiplicityRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedMultiplicityRefContext typedMultiplicityRef() throws RecognitionException {
		TypedMultiplicityRefContext _localctx = new TypedMultiplicityRefContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_typedMultiplicityRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(983);
			typedRef();
			setState(985);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(984);
				((TypedMultiplicityRefContext)_localctx).ownedMultiplicity = eMultiplicity();
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
		enterRule(_localctx, 78, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(987);
			match(T__73);
			setState(989);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(988);
				((BodyContext)_localctx).name = identifier();
				}
			}

			setState(997);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(991);
				match(T__5);
				setState(993);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
				case 1:
					{
					setState(992);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(995);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(996);
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
		enterRule(_localctx, 80, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1000);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__74) {
				{
				setState(999);
				((InvariantContext)_localctx).isCallable = match(T__74);
				}
			}

			setState(1002);
			match(T__75);
			setState(1009);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1003);
				((InvariantContext)_localctx).name = identifier();
				setState(1007);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1004);
					match(T__14);
					setState(1005);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1006);
					match(T__15);
					}
				}

				}
			}

			setState(1017);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1011);
				match(T__5);
				setState(1013);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1012);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1015);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1016);
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
		enterRule(_localctx, 82, RULE_precondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1019);
			_la = _input.LA(1);
			if ( !(_la==T__76 || _la==T__77) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1026);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1020);
				((PreconditionContext)_localctx).name = identifier();
				setState(1024);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1021);
					match(T__14);
					setState(1022);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1023);
					match(T__15);
					}
				}

				}
			}

			setState(1034);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1028);
				match(T__5);
				setState(1030);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
				case 1:
					{
					setState(1029);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1032);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1033);
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
		enterRule(_localctx, 84, RULE_postcondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1036);
			_la = _input.LA(1);
			if ( !(_la==T__78 || _la==T__79) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1043);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1037);
				((PostconditionContext)_localctx).name = identifier();
				setState(1041);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1038);
					match(T__14);
					setState(1039);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1040);
					match(T__15);
					}
				}

				}
			}

			setState(1051);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1045);
				match(T__5);
				setState(1047);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
				case 1:
					{
					setState(1046);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1049);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1050);
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
		enterRule(_localctx, 86, RULE_initial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1053);
			match(T__80);
			setState(1055);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1054);
				((InitialContext)_localctx).name = identifier();
				}
			}

			setState(1063);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1057);
				match(T__5);
				setState(1059);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
				case 1:
					{
					setState(1058);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1061);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1062);
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
		enterRule(_localctx, 88, RULE_derivation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1065);
			match(T__81);
			setState(1067);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1066);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			setState(1075);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1069);
				match(T__5);
				setState(1071);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
				case 1:
					{
					setState(1070);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1073);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1074);
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
		enterRule(_localctx, 90, RULE_visibilityKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1077);
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
		enterRule(_localctx, 92, RULE_atom);
		try {
			setState(1082);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1079);
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
				setState(1081);
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
		enterRule(_localctx, 94, RULE_arity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1084);
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
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1087);
				match(T__85);
				setState(1088);
				expression(0);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1089);
				match(T__86);
				setState(1090);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1091);
				match(T__87);
				setState(1092);
				expression(0);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1093);
				match(T__88);
				setState(1094);
				expression(0);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1095);
				((InContext)_localctx).left = expression(0);
				setState(1097);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1096);
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

				setState(1099);
				match(T__91);
				setState(1100);
				((InContext)_localctx).right = expression(0);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1102);
				((EqualContext)_localctx).left = expression(0);
				setState(1104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1103);
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

				setState(1106);
				match(T__20);
				setState(1107);
				((EqualContext)_localctx).right = expression(0);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1109);
				((EqContext)_localctx).ileft = intexpression(0);
				setState(1111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1110);
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

				setState(1113);
				match(T__20);
				setState(1114);
				((EqContext)_localctx).iright = intexpression(0);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1116);
				((LtContext)_localctx).ileft = intexpression(0);
				setState(1118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1117);
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

				setState(1120);
				match(T__68);
				setState(1121);
				((LtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1123);
				((LteContext)_localctx).ileft = intexpression(0);
				setState(1125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1124);
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

				setState(1127);
				match(T__92);
				setState(1128);
				((LteContext)_localctx).iright = intexpression(0);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1130);
				((GtContext)_localctx).ileft = intexpression(0);
				setState(1132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1131);
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

				setState(1134);
				match(T__69);
				setState(1135);
				((GtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1137);
				((GteContext)_localctx).ileft = intexpression(0);
				setState(1139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1138);
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

				setState(1141);
				match(T__93);
				setState(1142);
				((GteContext)_localctx).iright = intexpression(0);
				}
				break;
			case 12:
				{
				_localctx = new SumDeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(48)).var =  0;
				{
				setState(1145);
				match(T__94);
				setState(1146);
				decls();
				setState(1147);
				match(T__95);
				setState(1148);
				intexpression(0);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(48)).var; i++) declarations.pop();
				}
				break;
			case 13:
				{
				_localctx = new AcyclicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1152);
				match(T__96);
				setState(1153);
				match(T__10);
				setState(1154);
				relationId();
				setState(1155);
				match(T__11);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1157);
				match(T__97);
				setState(1158);
				match(T__10);
				setState(1159);
				((FunctionContext)_localctx).rel = relationId();
				setState(1160);
				match(T__5);
				setState(1161);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1162);
				match(T__98);
				setState(1163);
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
				setState(1164);
				((FunctionContext)_localctx).range = expression(0);
				setState(1165);
				match(T__11);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1167);
				match(T__99);
				setState(1168);
				match(T__10);
				setState(1169);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1170);
				match(T__2);
				setState(1171);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1172);
				match(T__2);
				setState(1173);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1174);
				match(T__2);
				setState(1175);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1176);
				match(T__11);
				}
				break;
			case 16:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1178);
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
				setState(1179);
				formula(14);
				}
				break;
			case 17:
				{
				_localctx = new ForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(48)).var =  0;
				{
				setState(1181);
				match(T__108);
				setState(1182);
				decls();
				setState(1203);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1183);
					match(T__95);
					setState(1193);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
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
						_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
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
							_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
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
					_alt = getInterpreter().adaptivePredict(_input,182,_ctx);
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
						_alt = getInterpreter().adaptivePredict(_input,182,_ctx);
					}
					setState(1202);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(48)).var; i++) declarations.pop();
				}
				break;
			case 18:
				{
				_localctx = new ForSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(48)).var =  0;
				{
				setState(1208);
				match(T__88);
				setState(1209);
				decls();
				setState(1230);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1210);
					match(T__95);
					setState(1220);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
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
						_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
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
							_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
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
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
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
						_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
					}
					setState(1229);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(48)).var; i++) declarations.pop();
				}
				break;
			case 19:
				{
				_localctx = new ForNoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(48)).var =  0;
				{
				setState(1235);
				match(T__85);
				setState(1236);
				decls();
				setState(1257);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1237);
					match(T__95);
					setState(1247);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
					case 1:
						{
						setState(1238);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1239);
						match(T__1);
						setState(1243);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1240);
								formula(0);
								}
								} 
							}
							setState(1245);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
						}
						setState(1246);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1249);
					match(T__1);
					setState(1253);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
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
						_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
					}
					setState(1256);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(48)).var; i++) declarations.pop();
				}
				break;
			case 20:
				{
				_localctx = new ForOneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(48)).var =  0;
				{
				setState(1262);
				match(T__87);
				setState(1263);
				decls();
				setState(1284);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1264);
					match(T__95);
					setState(1274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
					case 1:
						{
						setState(1265);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1266);
						match(T__1);
						setState(1270);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,192,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1267);
								formula(0);
								}
								} 
							}
							setState(1272);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,192,_ctx);
						}
						setState(1273);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1276);
					match(T__1);
					setState(1280);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
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
						_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
					}
					setState(1283);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(48)).var; i++) declarations.pop();
				}
				break;
			case 21:
				{
				_localctx = new ForLoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(48)).var =  0;
				{
				setState(1289);
				match(T__86);
				setState(1290);
				decls();
				setState(1311);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1291);
					match(T__95);
					setState(1301);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
					case 1:
						{
						setState(1292);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1293);
						match(T__1);
						setState(1297);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,196,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1294);
								formula(0);
								}
								} 
							}
							setState(1299);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,196,_ctx);
						}
						setState(1300);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1303);
					match(T__1);
					setState(1307);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
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
						_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
					}
					setState(1310);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(48)).var; i++) declarations.pop();
				}
				break;
			case 22:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(48)).var =  0;
				{
				setState(1316);
				match(T__109);
				setState(1317);
				letDecls();
				setState(1338);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1318);
					match(T__95);
					setState(1328);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
					case 1:
						{
						setState(1319);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1320);
						match(T__1);
						setState(1324);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1321);
								formula(0);
								}
								} 
							}
							setState(1326);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
						}
						setState(1327);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1330);
					match(T__1);
					setState(1334);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
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
						_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
					}
					setState(1337);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(48)).var; i++) declarations.pop();
				}
				break;
			case 23:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1342);
				match(T__110);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1343);
				match(T__111);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1344);
				match(T__14);
				setState(1345);
				formula(0);
				setState(1346);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1364);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1362);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1350);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1351);
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
						setState(1352);
						((AndContext)_localctx).fright = formula(13);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1353);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1354);
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
						setState(1355);
						((OrContext)_localctx).fright = formula(12);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1356);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1357);
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
						setState(1358);
						((ImpliesContext)_localctx).fright = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1359);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1360);
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
						setState(1361);
						((IffContext)_localctx).fright = formula(10);
						}
						break;
					}
					} 
				}
				setState(1366);
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
		int _startState = 98;
		enterRecursionRule(_localctx, 98, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
			case 1:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1368);
				match(T__112);
				setState(1369);
				expression(19);
				}
				break;
			case 2:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1370);
				match(T__113);
				setState(1371);
				expression(18);
				}
				break;
			case 3:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1372);
				match(T__50);
				setState(1373);
				expression(17);
				}
				break;
			case 4:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				((FormulaContext)getInvokingContext(48)).var =  0;
				{
				setState(1375);
				match(T__1);
				setState(1376);
				comprehensionDecls();
				setState(1377);
				match(T__95);
				setState(1378);
				formula(0);
				setState(1379);
				match(T__3);
				}
				for (int i = 0; i < ((FormulaContext)getInvokingContext(48)).var; i++) declarations.pop();
				}
				break;
			case 5:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1383);
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
				setState(1384);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1385);
				match(T__118);
				setState(1386);
				((IfExpressionContext)_localctx).thenExpr = expression(0);
				setState(1387);
				match(T__119);
				setState(1388);
				((IfExpressionContext)_localctx).elseExpr = expression(8);
				}
				break;
			case 6:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1390);
				match(T__120);
				}
				break;
			case 7:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1391);
				match(T__121);
				}
				break;
			case 8:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1392);
				match(T__122);
				}
				break;
			case 9:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1393);
				match(T__123);
				}
				break;
			case 10:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1394);
				match(T__14);
				setState(1395);
				expression(0);
				setState(1396);
				match(T__15);
				}
				break;
			case 11:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1398);
				if (!(!isRelation())) throw new FailedPredicateException(this, "!isRelation()");
				setState(1399);
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
				setState(1402);
				if (!(isRelation())) throw new FailedPredicateException(this, "isRelation()");
				setState(1403);
				relationId();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1437);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1435);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1406);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1407);
						match(T__51);
						setState(1408);
						((UnionContext)_localctx).right = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1409);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1410);
						match(T__70);
						setState(1411);
						((IntersectionContext)_localctx).right = expression(16);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1412);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1413);
						match(T__114);
						setState(1414);
						((DifferenceContext)_localctx).right = expression(15);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1415);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1416);
						match(T__115);
						setState(1417);
						((JoinContext)_localctx).right = expression(14);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1418);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1420);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__116 - 87)))) != 0)) {
							{
							setState(1419);
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

						setState(1422);
						match(T__98);
						setState(1424);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
						case 1:
							{
							setState(1423);
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
						setState(1426);
						((ProductContext)_localctx).right = expression(11);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1427);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1428);
						match(T__117);
						setState(1429);
						((OverrideContext)_localctx).right = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BoxjoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxjoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1430);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1431);
						match(T__10);
						setState(1432);
						((BoxjoinContext)_localctx).left = expression(0);
						setState(1433);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(1439);
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
		int _startState = 100;
		enterRecursionRule(_localctx, 100, RULE_intexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__104:
			case T__105:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1441);
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
				setState(1442);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1443);
				match(T__118);
				setState(1444);
				((IfIntExpressionContext)_localctx).thenExpr = intexpression(0);
				setState(1445);
				match(T__119);
				setState(1446);
				((IfIntExpressionContext)_localctx).elseExpr = intexpression(10);
				}
				break;
			case T__94:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1448);
				match(T__94);
				setState(1449);
				expression(0);
				}
				break;
			case T__43:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1450);
				match(T__43);
				setState(1451);
				expression(0);
				}
				break;
			case T__114:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__114) {
					{
					setState(1452);
					((IntConstantContext)_localctx).sign = match(T__114);
					}
				}

				setState(1455);
				integer();
				}
				break;
			case T__14:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1456);
				match(T__14);
				setState(1457);
				intexpression(0);
				setState(1458);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1479);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1477);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntexpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1462);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1463);
						_la = _input.LA(1);
						if ( !(_la==T__51 || _la==T__124) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1464);
						((PlusContext)_localctx).iright = intexpression(8);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntexpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1465);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1466);
						_la = _input.LA(1);
						if ( !(_la==T__114 || _la==T__125) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1467);
						((MinusContext)_localctx).iright = intexpression(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntexpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1468);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1469);
						_la = _input.LA(1);
						if ( !(_la==T__50 || _la==T__126) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1470);
						((MultiplyContext)_localctx).iright = intexpression(6);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntexpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1471);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1472);
						_la = _input.LA(1);
						if ( !(_la==T__127 || _la==T__128) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1473);
						((DivideContext)_localctx).iright = intexpression(5);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntexpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1474);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1475);
						_la = _input.LA(1);
						if ( !(_la==T__129 || _la==T__130) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1476);
						((ModuloContext)_localctx).iright = intexpression(4);
						}
						break;
					}
					} 
				}
				setState(1481);
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
		enterRule(_localctx, 102, RULE_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1482);
			decl();
			setState(1487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1483);
				match(T__2);
				setState(1484);
				decl();
				}
				}
				setState(1489);
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
		enterRule(_localctx, 104, RULE_decl);
		int _la;
		try {
			setState(1556);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,226,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1490);
					((OneOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1493);
				((OneOfContext)_localctx).variableId = variableId();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
				setState(1498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1494);
					match(T__2);
					setState(1495);
					((OneOfContext)_localctx).variableId = variableId();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
					}
					}
					setState(1500);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1501);
				match(T__5);
				setState(1503);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
				case 1:
					{
					setState(1502);
					match(T__87);
					}
					break;
				}
				setState(1505);
				expression(0);
				((FormulaContext)getInvokingContext(48)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(48)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1509);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1508);
					((LoneOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1511);
				((LoneOfContext)_localctx).variableId = variableId();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
				setState(1516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1512);
					match(T__2);
					setState(1513);
					((LoneOfContext)_localctx).variableId = variableId();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
					}
					}
					setState(1518);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1519);
				match(T__5);
				setState(1520);
				match(T__86);
				setState(1521);
				expression(0);
				((FormulaContext)getInvokingContext(48)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(48)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1525);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1524);
					((SomeOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1527);
				((SomeOfContext)_localctx).variableId = variableId();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
				setState(1532);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1528);
					match(T__2);
					setState(1529);
					((SomeOfContext)_localctx).variableId = variableId();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
					}
					}
					setState(1534);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1535);
				match(T__5);
				setState(1536);
				match(T__88);
				setState(1537);
				expression(0);
				((FormulaContext)getInvokingContext(48)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(48)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1541);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1540);
					((SetOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1543);
				((SetOfContext)_localctx).variableId = variableId();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
				setState(1548);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1544);
					match(T__2);
					setState(1545);
					((SetOfContext)_localctx).variableId = variableId();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
					}
					}
					setState(1550);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1551);
				match(T__5);
				setState(1552);
				match(T__116);
				setState(1553);
				expression(0);
				((FormulaContext)getInvokingContext(48)).var =  declareVariables(((SetOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(48)).var);
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
		enterRule(_localctx, 106, RULE_letDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1558);
			letDecl();
			setState(1563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1559);
				match(T__2);
				setState(1560);
				letDecl();
				}
				}
				setState(1565);
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
		enterRule(_localctx, 108, RULE_letDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1566);
			((LetDeclContext)_localctx).variableId = variableId();
			((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
			setState(1571);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1567);
				match(T__2);
				setState(1568);
				((LetDeclContext)_localctx).variableId = variableId();
				((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
				}
				}
				setState(1573);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1574);
			match(T__20);
			setState(1575);
			expression(0);
			}
			((FormulaContext)getInvokingContext(48)).var =  declareVariables(((LetDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(48)).var);
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
		enterRule(_localctx, 110, RULE_comprehensionDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1579);
			comprehensionDecl();
			setState(1584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1580);
				match(T__2);
				setState(1581);
				comprehensionDecl();
				}
				}
				setState(1586);
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
		enterRule(_localctx, 112, RULE_comprehensionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1588);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__131) {
				{
				setState(1587);
				((ComprehensionDeclContext)_localctx).disj = match(T__131);
				}
			}

			{
			setState(1590);
			((ComprehensionDeclContext)_localctx).variableId = variableId();
			((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
			setState(1595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1591);
				match(T__2);
				setState(1592);
				((ComprehensionDeclContext)_localctx).variableId = variableId();
				((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
				}
				}
				setState(1597);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1598);
			match(T__5);
			setState(1600);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
			case 1:
				{
				setState(1599);
				match(T__87);
				}
				break;
			}
			setState(1602);
			expression(0);
			}
			((FormulaContext)getInvokingContext(48)).var =  declareVariables(((ComprehensionDeclContext)_localctx).vars, ((FormulaContext)getInvokingContext(48)).var);
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
		enterRule(_localctx, 114, RULE_relationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1606);
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
		enterRule(_localctx, 116, RULE_variableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1608);
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
		enterRule(_localctx, 118, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1610);
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
		enterRule(_localctx, 120, RULE_unrestrictedName);
		try {
			setState(1653);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1612);
				identifier();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(1613);
				match(T__21);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 3);
				{
				setState(1614);
				match(T__33);
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 4);
				{
				setState(1615);
				match(T__73);
				}
				break;
			case T__74:
				enterOuterAlt(_localctx, 5);
				{
				setState(1616);
				match(T__74);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 6);
				{
				setState(1617);
				match(T__22);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 7);
				{
				setState(1618);
				match(T__44);
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 8);
				{
				setState(1619);
				match(T__56);
				}
				break;
			case T__132:
				enterOuterAlt(_localctx, 9);
				{
				setState(1620);
				match(T__132);
				}
				break;
			case T__81:
				enterOuterAlt(_localctx, 10);
				{
				setState(1621);
				match(T__81);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 11);
				{
				setState(1622);
				match(T__34);
				}
				break;
			case T__64:
				enterOuterAlt(_localctx, 12);
				{
				setState(1623);
				match(T__64);
				}
				break;
			case T__133:
				enterOuterAlt(_localctx, 13);
				{
				setState(1624);
				match(T__133);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 14);
				{
				setState(1625);
				match(T__24);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 15);
				{
				setState(1626);
				match(T__35);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 16);
				{
				setState(1627);
				match(T__17);
				}
				break;
			case T__80:
				enterOuterAlt(_localctx, 17);
				{
				setState(1628);
				match(T__80);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 18);
				{
				setState(1629);
				match(T__23);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 19);
				{
				setState(1630);
				match(T__47);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 20);
				{
				setState(1631);
				match(T__16);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 21);
				{
				setState(1632);
				match(T__48);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 22);
				{
				setState(1633);
				match(T__36);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 23);
				{
				setState(1634);
				match(T__19);
				}
				break;
			case T__78:
				enterOuterAlt(_localctx, 24);
				{
				setState(1635);
				match(T__78);
				}
				break;
			case T__76:
				enterOuterAlt(_localctx, 25);
				{
				setState(1636);
				match(T__76);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 26);
				{
				setState(1637);
				match(T__55);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 27);
				{
				setState(1638);
				match(T__42);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 28);
				{
				setState(1639);
				match(T__32);
				}
				break;
			case T__67:
				enterOuterAlt(_localctx, 29);
				{
				setState(1640);
				match(T__67);
				}
				break;
			case T__134:
				enterOuterAlt(_localctx, 30);
				{
				setState(1641);
				match(T__134);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 31);
				{
				setState(1642);
				match(T__45);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 32);
				{
				setState(1643);
				match(T__25);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 33);
				{
				setState(1644);
				match(T__49);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 34);
				{
				setState(1645);
				match(T__28);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 35);
				{
				setState(1646);
				match(T__38);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 36);
				{
				setState(1647);
				match(T__40);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 37);
				{
				setState(1648);
				match(T__29);
				}
				break;
			case T__75:
				enterOuterAlt(_localctx, 38);
				{
				setState(1649);
				match(T__75);
				}
				break;
			case T__65:
				enterOuterAlt(_localctx, 39);
				{
				setState(1650);
				match(T__65);
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 40);
				{
				setState(1651);
				match(T__57);
				}
				break;
			case T__66:
				enterOuterAlt(_localctx, 41);
				{
				setState(1652);
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
		enterRule(_localctx, 122, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1655);
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
		enterRule(_localctx, 124, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1657);
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
		enterRule(_localctx, 126, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1659);
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
		enterRule(_localctx, 128, RULE_signed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1662);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__114) {
				{
				setState(1661);
				match(T__114);
				}
			}

			setState(1664);
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
		case 48:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 49:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 50:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0091\u0685\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\5\2\u0086\n\2\3\2\3\2\3\2\3\2\3\2\7"+
		"\2\u008d\n\2\f\2\16\2\u0090\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\u009a"+
		"\n\3\f\3\16\3\u009d\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4\u00ad\n\4\3\5\3\5\3\5\3\5\3\5\7\5\u00b4\n\5\f\5\16\5\u00b7"+
		"\13\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00bf\n\5\f\5\16\5\u00c2\13\5\3\5\3"+
		"\5\5\5\u00c6\n\5\3\5\3\5\3\6\3\6\3\6\7\6\u00cd\n\6\f\6\16\6\u00d0\13\6"+
		"\3\6\3\6\3\6\3\7\3\7\5\7\u00d7\n\7\3\7\3\7\5\7\u00db\n\7\3\7\3\7\3\7\3"+
		"\7\5\7\u00e1\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00eb\n\b\f\b\16"+
		"\b\u00ee\13\b\5\b\u00f0\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u00f7\n\b\f\b\16\b"+
		"\u00fa\13\b\5\b\u00fc\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\b\u010b\n\b\3\t\3\t\3\t\3\t\7\t\u0111\n\t\f\t\16\t\u0114\13"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u011c\n\t\f\t\16\t\u011f\13\t\3\t\3\t\5"+
		"\t\u0123\n\t\3\n\5\n\u0126\n\n\3\n\3\n\5\n\u012a\n\n\3\n\7\n\u012d\n\n"+
		"\f\n\16\n\u0130\13\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u0139\n\13\3"+
		"\13\3\13\3\13\3\f\5\f\u013f\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0157\n\f\f\f\16"+
		"\f\u015a\13\f\3\f\3\f\5\f\u015e\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u016b\n\r\3\16\5\16\u016e\n\16\3\16\5\16\u0171\n\16\3\16"+
		"\3\16\5\16\u0175\n\16\3\16\3\16\3\16\5\16\u017a\n\16\3\16\3\16\3\16\3"+
		"\16\7\16\u0180\n\16\f\16\16\16\u0183\13\16\5\16\u0185\n\16\3\16\3\16\5"+
		"\16\u0189\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u0196\n\16\f\16\16\16\u0199\13\16\3\16\3\16\5\16\u019d\n\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u01a7\n\17\3\20\5\20\u01aa\n"+
		"\20\3\20\5\20\u01ad\n\20\3\20\3\20\5\20\u01b1\n\20\3\20\5\20\u01b4\n\20"+
		"\3\20\5\20\u01b7\n\20\3\20\3\20\5\20\u01bb\n\20\3\20\5\20\u01be\n\20\3"+
		"\20\3\20\3\20\3\20\3\20\5\20\u01c5\n\20\3\20\3\20\5\20\u01c9\n\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01d4\n\20\3\20\5\20\u01d7"+
		"\n\20\6\20\u01d9\n\20\r\20\16\20\u01da\3\20\5\20\u01de\n\20\3\20\3\20"+
		"\7\20\u01e2\n\20\f\20\16\20\u01e5\13\20\3\20\3\20\5\20\u01e9\n\20\3\20"+
		"\3\20\3\20\5\20\u01ee\n\20\3\20\7\20\u01f1\n\20\f\20\16\20\u01f4\13\20"+
		"\5\20\u01f6\n\20\3\20\3\20\3\20\5\20\u01fb\n\20\3\21\5\21\u01fe\n\21\3"+
		"\21\5\21\u0201\n\21\3\21\3\21\5\21\u0205\n\21\3\21\5\21\u0208\n\21\3\21"+
		"\5\21\u020b\n\21\3\21\3\21\5\21\u020f\n\21\3\21\5\21\u0212\n\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u0219\n\21\3\21\3\21\5\21\u021d\n\21\3\21\3\21"+
		"\5\21\u0221\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u022e\n\21\3\21\5\21\u0231\n\21\6\21\u0233\n\21\r\21\16\21\u0234"+
		"\3\21\5\21\u0238\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u023f\n\21\f\21\16"+
		"\21\u0242\13\21\3\21\3\21\5\21\u0246\n\21\3\21\7\21\u0249\n\21\f\21\16"+
		"\21\u024c\13\21\3\21\3\21\5\21\u0250\n\21\3\21\3\21\5\21\u0254\n\21\3"+
		"\21\7\21\u0257\n\21\f\21\16\21\u025a\13\21\5\21\u025c\n\21\3\21\3\21\5"+
		"\21\u0260\n\21\3\22\5\22\u0263\n\22\3\22\5\22\u0266\n\22\3\22\3\22\5\22"+
		"\u026a\n\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0272\n\22\f\22\16\22\u0275"+
		"\13\22\5\22\u0277\n\22\3\22\3\22\3\22\3\22\5\22\u027d\n\22\3\22\3\22\3"+
		"\22\3\22\7\22\u0283\n\22\f\22\16\22\u0286\13\22\5\22\u0288\n\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u028f\n\22\3\22\5\22\u0292\n\22\6\22\u0294\n\22"+
		"\r\22\16\22\u0295\3\22\5\22\u0299\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\7\22\u02a2\n\22\f\22\16\22\u02a5\13\22\3\22\3\22\5\22\u02a9\n\22\3"+
		"\23\3\23\5\23\u02ad\n\23\3\23\3\23\3\23\3\23\5\23\u02b3\n\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u02ba\n\23\3\23\5\23\u02bd\n\23\6\23\u02bf\n\23\r"+
		"\23\16\23\u02c0\3\23\5\23\u02c4\n\23\3\23\3\23\7\23\u02c8\n\23\f\23\16"+
		"\23\u02cb\13\23\3\23\3\23\5\23\u02cf\n\23\3\24\3\24\3\24\3\24\5\24\u02d5"+
		"\n\24\3\24\5\24\u02d8\n\24\3\24\3\24\5\24\u02dc\n\24\3\24\3\24\3\25\5"+
		"\25\u02e1\n\25\3\25\3\25\3\25\5\25\u02e6\n\25\5\25\u02e8\n\25\3\25\3\25"+
		"\3\25\3\25\5\25\u02ee\n\25\3\25\3\25\5\25\u02f2\n\25\3\25\3\25\3\25\5"+
		"\25\u02f7\n\25\3\25\5\25\u02fa\n\25\3\25\3\25\3\25\3\25\3\25\7\25\u0301"+
		"\n\25\f\25\16\25\u0304\13\25\3\25\3\25\5\25\u0308\n\25\3\26\3\26\3\27"+
		"\5\27\u030d\n\27\3\27\3\27\3\27\3\27\5\27\u0313\n\27\3\27\3\27\5\27\u0317"+
		"\n\27\3\27\3\27\3\27\5\27\u031c\n\27\3\27\5\27\u031f\n\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\7\27\u0329\n\27\f\27\16\27\u032c\13\27\3"+
		"\27\3\27\5\27\u0330\n\27\3\30\3\30\3\30\5\30\u0335\n\30\3\30\3\30\5\30"+
		"\u0339\n\30\3\30\3\30\3\30\7\30\u033e\n\30\f\30\16\30\u0341\13\30\3\30"+
		"\3\30\3\30\5\30\u0346\n\30\3\31\3\31\5\31\u034a\n\31\3\31\3\31\3\31\3"+
		"\31\3\31\7\31\u0351\n\31\f\31\16\31\u0354\13\31\3\31\3\31\5\31\u0358\n"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\6\31\u0363\n\31\r\31"+
		"\16\31\u0364\3\31\3\31\3\31\5\31\u036a\n\31\3\32\5\32\u036d\n\32\3\32"+
		"\3\32\5\32\u0371\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u037b"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u0389\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0394\n"+
		"\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u039e\n\37\f\37\16\37"+
		"\u03a1\13\37\3\37\3\37\3 \3 \3 \3 \3 \7 \u03aa\n \f \16 \u03ad\13 \5 "+
		"\u03af\n \3!\3!\5!\u03b3\n!\3\"\3\"\5\"\u03b7\n\"\3#\3#\3#\3#\3#\5#\u03be"+
		"\n#\3$\3$\3$\5$\u03c3\n$\3%\3%\3%\7%\u03c8\n%\f%\16%\u03cb\13%\3%\5%\u03ce"+
		"\n%\3&\3&\3\'\3\'\3\'\7\'\u03d5\n\'\f\'\16\'\u03d8\13\'\3(\3(\5(\u03dc"+
		"\n(\3)\3)\5)\u03e0\n)\3)\3)\5)\u03e4\n)\3)\3)\5)\u03e8\n)\3*\5*\u03eb"+
		"\n*\3*\3*\3*\3*\3*\5*\u03f2\n*\5*\u03f4\n*\3*\3*\5*\u03f8\n*\3*\3*\5*"+
		"\u03fc\n*\3+\3+\3+\3+\3+\5+\u0403\n+\5+\u0405\n+\3+\3+\5+\u0409\n+\3+"+
		"\3+\5+\u040d\n+\3,\3,\3,\3,\3,\5,\u0414\n,\5,\u0416\n,\3,\3,\5,\u041a"+
		"\n,\3,\3,\5,\u041e\n,\3-\3-\5-\u0422\n-\3-\3-\5-\u0426\n-\3-\3-\5-\u042a"+
		"\n-\3.\3.\5.\u042e\n.\3.\3.\5.\u0432\n.\3.\3.\5.\u0436\n.\3/\3/\3\60\3"+
		"\60\3\60\5\60\u043d\n\60\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u044c\n\62\3\62\3\62\3\62\3\62\3\62\5\62\u0453"+
		"\n\62\3\62\3\62\3\62\3\62\3\62\5\62\u045a\n\62\3\62\3\62\3\62\3\62\3\62"+
		"\5\62\u0461\n\62\3\62\3\62\3\62\3\62\3\62\5\62\u0468\n\62\3\62\3\62\3"+
		"\62\3\62\3\62\5\62\u046f\n\62\3\62\3\62\3\62\3\62\3\62\5\62\u0476\n\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\7\62\u04a6\n\62\f\62\16\62\u04a9\13\62\3\62\5\62"+
		"\u04ac\n\62\3\62\3\62\7\62\u04b0\n\62\f\62\16\62\u04b3\13\62\3\62\5\62"+
		"\u04b6\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u04c1\n"+
		"\62\f\62\16\62\u04c4\13\62\3\62\5\62\u04c7\n\62\3\62\3\62\7\62\u04cb\n"+
		"\62\f\62\16\62\u04ce\13\62\3\62\5\62\u04d1\n\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\7\62\u04dc\n\62\f\62\16\62\u04df\13\62\3\62\5"+
		"\62\u04e2\n\62\3\62\3\62\7\62\u04e6\n\62\f\62\16\62\u04e9\13\62\3\62\5"+
		"\62\u04ec\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u04f7"+
		"\n\62\f\62\16\62\u04fa\13\62\3\62\5\62\u04fd\n\62\3\62\3\62\7\62\u0501"+
		"\n\62\f\62\16\62\u0504\13\62\3\62\5\62\u0507\n\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\7\62\u0512\n\62\f\62\16\62\u0515\13\62\3\62"+
		"\5\62\u0518\n\62\3\62\3\62\7\62\u051c\n\62\f\62\16\62\u051f\13\62\3\62"+
		"\5\62\u0522\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u052d"+
		"\n\62\f\62\16\62\u0530\13\62\3\62\5\62\u0533\n\62\3\62\3\62\7\62\u0537"+
		"\n\62\f\62\16\62\u053a\13\62\3\62\5\62\u053d\n\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u0547\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\7\62\u0555\n\62\f\62\16\62\u0558\13\62\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u057f\n\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u058f\n\63"+
		"\3\63\3\63\5\63\u0593\n\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\7\63\u059e\n\63\f\63\16\63\u05a1\13\63\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u05b0\n\64\3\64\3\64\3\64\3\64"+
		"\3\64\5\64\u05b7\n\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\7\64\u05c8\n\64\f\64\16\64\u05cb\13\64\3\65"+
		"\3\65\3\65\7\65\u05d0\n\65\f\65\16\65\u05d3\13\65\3\66\5\66\u05d6\n\66"+
		"\3\66\3\66\3\66\7\66\u05db\n\66\f\66\16\66\u05de\13\66\3\66\3\66\5\66"+
		"\u05e2\n\66\3\66\3\66\3\66\3\66\5\66\u05e8\n\66\3\66\3\66\3\66\7\66\u05ed"+
		"\n\66\f\66\16\66\u05f0\13\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u05f8"+
		"\n\66\3\66\3\66\3\66\7\66\u05fd\n\66\f\66\16\66\u0600\13\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\5\66\u0608\n\66\3\66\3\66\3\66\7\66\u060d\n\66\f"+
		"\66\16\66\u0610\13\66\3\66\3\66\3\66\3\66\3\66\5\66\u0617\n\66\3\67\3"+
		"\67\3\67\7\67\u061c\n\67\f\67\16\67\u061f\13\67\38\38\38\78\u0624\n8\f"+
		"8\168\u0627\138\38\38\38\38\38\39\39\39\79\u0631\n9\f9\169\u0634\139\3"+
		":\5:\u0637\n:\3:\3:\3:\7:\u063c\n:\f:\16:\u063f\13:\3:\3:\5:\u0643\n:"+
		"\3:\3:\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\5>\u0678\n>\3?\3?\3@\3@\3A\3A\3B\5B\u0681\nB\3B\3B\3B"+
		"\2\5bdfC\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\2\26\3\2\65\67\3\2>B"+
		"\3\2\u008d\u008e\4\2\33\33JJ\3\2OP\3\2QR\3\2UW\3\2\\]\3\2YZ\3\2gh\3\2"+
		"ij\3\2kl\3\2mn\4\2Y[ww\4\2\66\66\177\177\4\2uu\u0080\u0080\4\2\65\65\u0081"+
		"\u0081\3\2\u0082\u0083\3\2\u0084\u0085\4\2\65\65\u008a\u008a\u07b4\2\u0085"+
		"\3\2\2\2\4\u0094\3\2\2\2\6\u00ac\3\2\2\2\b\u00ae\3\2\2\2\n\u00c9\3\2\2"+
		"\2\f\u00d4\3\2\2\2\16\u010a\3\2\2\2\20\u0122\3\2\2\2\22\u0125\3\2\2\2"+
		"\24\u0134\3\2\2\2\26\u013e\3\2\2\2\30\u016a\3\2\2\2\32\u016d\3\2\2\2\34"+
		"\u01a6\3\2\2\2\36\u01a9\3\2\2\2 \u01fd\3\2\2\2\"\u0262\3\2\2\2$\u02ac"+
		"\3\2\2\2&\u02d0\3\2\2\2(\u02e0\3\2\2\2*\u0309\3\2\2\2,\u030c\3\2\2\2."+
		"\u0334\3\2\2\2\60\u0347\3\2\2\2\62\u036c\3\2\2\2\64\u037a\3\2\2\2\66\u0388"+
		"\3\2\2\28\u0393\3\2\2\2:\u0395\3\2\2\2<\u0399\3\2\2\2>\u03a4\3\2\2\2@"+
		"\u03b2\3\2\2\2B\u03b6\3\2\2\2D\u03b8\3\2\2\2F\u03bf\3\2\2\2H\u03c4\3\2"+
		"\2\2J\u03cf\3\2\2\2L\u03d1\3\2\2\2N\u03d9\3\2\2\2P\u03dd\3\2\2\2R\u03ea"+
		"\3\2\2\2T\u03fd\3\2\2\2V\u040e\3\2\2\2X\u041f\3\2\2\2Z\u042b\3\2\2\2\\"+
		"\u0437\3\2\2\2^\u043c\3\2\2\2`\u043e\3\2\2\2b\u0546\3\2\2\2d\u057e\3\2"+
		"\2\2f\u05b6\3\2\2\2h\u05cc\3\2\2\2j\u0616\3\2\2\2l\u0618\3\2\2\2n\u0620"+
		"\3\2\2\2p\u062d\3\2\2\2r\u0636\3\2\2\2t\u0648\3\2\2\2v\u064a\3\2\2\2x"+
		"\u064c\3\2\2\2z\u0677\3\2\2\2|\u0679\3\2\2\2~\u067b\3\2\2\2\u0080\u067d"+
		"\3\2\2\2\u0082\u0680\3\2\2\2\u0084\u0086\5\4\3\2\u0085\u0084\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\5\b\5\2\u0088\u0089\b\2"+
		"\1\2\u0089\u008a\5\n\6\2\u008a\u008e\b\2\1\2\u008b\u008d\5b\62\2\u008c"+
		"\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\b\2\1\2\u0092"+
		"\u0093\b\2\1\2\u0093\3\3\2\2\2\u0094\u0095\7\3\2\2\u0095\u0096\7\4\2\2"+
		"\u0096\u009b\5\6\4\2\u0097\u0098\7\5\2\2\u0098\u009a\5\6\4\2\u0099\u0097"+
		"\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\6\2\2\u009f\5\3\2\2\2"+
		"\u00a0\u00a1\7\7\2\2\u00a1\u00a2\7\b\2\2\u00a2\u00ad\5x=\2\u00a3\u00a4"+
		"\7\t\2\2\u00a4\u00a5\7\b\2\2\u00a5\u00ad\5x=\2\u00a6\u00a7\7\n\2\2\u00a7"+
		"\u00a8\7\b\2\2\u00a8\u00ad\5x=\2\u00a9\u00aa\7\13\2\2\u00aa\u00ab\7\b"+
		"\2\2\u00ab\u00ad\5x=\2\u00ac\u00a0\3\2\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00a6"+
		"\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad\7\3\2\2\2\u00ae\u00c5\7\f\2\2\u00af"+
		"\u00b0\7\4\2\2\u00b0\u00b5\5^\60\2\u00b1\u00b2\7\5\2\2\u00b2\u00b4\5^"+
		"\60\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\6"+
		"\2\2\u00b9\u00c6\3\2\2\2\u00ba\u00bb\7\r\2\2\u00bb\u00c0\5^\60\2\u00bc"+
		"\u00bd\7\5\2\2\u00bd\u00bf\5^\60\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c4\7\16\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00af\3"+
		"\2\2\2\u00c5\u00ba\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\5\1\2\u00c8"+
		"\t\3\2\2\2\u00c9\u00ca\7\17\2\2\u00ca\u00ce\7\4\2\2\u00cb\u00cd\5\f\7"+
		"\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7\6\2\2\u00d2"+
		"\u00d3\b\6\1\2\u00d3\13\3\2\2\2\u00d4\u00d6\5|?\2\u00d5\u00d7\5`\61\2"+
		"\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da"+
		"\7\b\2\2\u00d9\u00db\5d\63\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00dd\7\r\2\2\u00dd\u00e0\5\16\b\2\u00de\u00df\7"+
		"\5\2\2\u00df\u00e1\5\16\b\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e3\7\16\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\b"+
		"\7\1\2\u00e5\r\3\2\2\2\u00e6\u00ef\7\4\2\2\u00e7\u00ec\5\20\t\2\u00e8"+
		"\u00e9\7\5\2\2\u00e9\u00eb\5\20\t\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3"+
		"\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u010b\7\6\2\2\u00f2\u00fb\7\r\2\2\u00f3\u00f8\5\20\t\2\u00f4"+
		"\u00f5\7\5\2\2\u00f5\u00f7\5\20\t\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa\3"+
		"\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fb\u00f3\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u010b\7\16\2\2\u00fe\u00ff\7\4\2\2\u00ff\u0100\5\20\t\2\u0100"+
		"\u0101\7\20\2\2\u0101\u0102\5\20\t\2\u0102\u0103\7\6\2\2\u0103\u010b\3"+
		"\2\2\2\u0104\u0105\7\r\2\2\u0105\u0106\5\20\t\2\u0106\u0107\7\20\2\2\u0107"+
		"\u0108\5\20\t\2\u0108\u0109\7\16\2\2\u0109\u010b\3\2\2\2\u010a\u00e6\3"+
		"\2\2\2\u010a\u00f2\3\2\2\2\u010a\u00fe\3\2\2\2\u010a\u0104\3\2\2\2\u010b"+
		"\17\3\2\2\2\u010c\u010d\7\21\2\2\u010d\u0112\5^\60\2\u010e\u010f\7\5\2"+
		"\2\u010f\u0111\5^\60\2\u0110\u010e\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115"+
		"\u0116\7\22\2\2\u0116\u0123\3\2\2\2\u0117\u0118\7\r\2\2\u0118\u011d\5"+
		"^\60\2\u0119\u011a\7\5\2\2\u011a\u011c\5^\60\2\u011b\u0119\3\2\2\2\u011c"+
		"\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2"+
		"\2\2\u011f\u011d\3\2\2\2\u0120\u0121\7\16\2\2\u0121\u0123\3\2\2\2\u0122"+
		"\u010c\3\2\2\2\u0122\u0117\3\2\2\2\u0123\21\3\2\2\2\u0124\u0126\5\4\3"+
		"\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0128"+
		"\7\23\2\2\u0128\u012a\5|?\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012e\3\2\2\2\u012b\u012d\5\24\13\2\u012c\u012b\3\2\2\2\u012d\u0130\3"+
		"\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0131\u0132\5\26\f\2\u0132\u0133\b\n\1\2\u0133\23\3\2\2"+
		"\2\u0134\u0138\7\24\2\2\u0135\u0136\5|?\2\u0136\u0137\7\b\2\2\u0137\u0139"+
		"\3\2\2\2\u0138\u0135\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u013b\7\u008d\2\2\u013b\u013c\7\25\2\2\u013c\25\3\2\2\2\u013d\u013f\5"+
		"\\/\2\u013e\u013d\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"\u0141\7\26\2\2\u0141\u0142\5z>\2\u0142\u0143\7\b\2\2\u0143\u0144\5|?"+
		"\2\u0144\u0145\3\2\2\2\u0145\u0146\7\27\2\2\u0146\u0147\7\u008d\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u015d\b\f\1\2\u0149\u0158\7\4\2\2\u014a\u014b\5\60"+
		"\31\2\u014b\u014c\b\f\1\2\u014c\u0157\3\2\2\2\u014d\u014e\5\26\f\2\u014e"+
		"\u014f\b\f\1\2\u014f\u0157\3\2\2\2\u0150\u0151\5\30\r\2\u0151\u0152\b"+
		"\f\1\2\u0152\u0157\3\2\2\2\u0153\u0154\5R*\2\u0154\u0155\b\f\1\2\u0155"+
		"\u0157\3\2\2\2\u0156\u014a\3\2\2\2\u0156\u014d\3\2\2\2\u0156\u0150\3\2"+
		"\2\2\u0156\u0153\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015e\7\6"+
		"\2\2\u015c\u015e\7\25\2\2\u015d\u0149\3\2\2\2\u015d\u015c\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0160\b\f\1\2\u0160\27\3\2\2\2\u0161\u0162\5\32\16"+
		"\2\u0162\u0163\b\r\1\2\u0163\u016b\3\2\2\2\u0164\u0165\5(\25\2\u0165\u0166"+
		"\b\r\1\2\u0166\u016b\3\2\2\2\u0167\u0168\5,\27\2\u0168\u0169\b\r\1\2\u0169"+
		"\u016b\3\2\2\2\u016a\u0161\3\2\2\2\u016a\u0164\3\2\2\2\u016a\u0167\3\2"+
		"\2\2\u016b\31\3\2\2\2\u016c\u016e\5\\/\2\u016d\u016c\3\2\2\2\u016d\u016e"+
		"\3\2\2\2\u016e\u0174\3\2\2\2\u016f\u0171\7\30\2\2\u0170\u016f\3\2\2\2"+
		"\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0175\7\31\2\2\u0173\u0175"+
		"\7\32\2\2\u0174\u0170\3\2\2\2\u0174\u0173\3\2\2\2\u0175\u0176\3\2\2\2"+
		"\u0176\u0177\5z>\2\u0177\u0179\b\16\1\2\u0178\u017a\5<\37\2\u0179\u0178"+
		"\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u0184\3\2\2\2\u017b\u017c\7\33\2\2"+
		"\u017c\u0181\5B\"\2\u017d\u017e\7\5\2\2\u017e\u0180\5B\"\2\u017f\u017d"+
		"\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182"+
		"\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u017b\3\2\2\2\u0184\u0185\3\2"+
		"\2\2\u0185\u0188\3\2\2\2\u0186\u0187\7\b\2\2\u0187\u0189\7\u008d\2\2\u0188"+
		"\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u019c\3\2\2\2\u018a\u0197\7\4"+
		"\2\2\u018b\u018c\5\60\31\2\u018c\u018d\b\16\1\2\u018d\u0196\3\2\2\2\u018e"+
		"\u018f\5\"\22\2\u018f\u0190\b\16\1\2\u0190\u0196\3\2\2\2\u0191\u0192\5"+
		"\34\17\2\u0192\u0193\b\16\1\2\u0193\u0196\3\2\2\2\u0194\u0196\5R*\2\u0195"+
		"\u018b\3\2\2\2\u0195\u018e\3\2\2\2\u0195\u0191\3\2\2\2\u0195\u0194\3\2"+
		"\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019d\7\6\2\2\u019b\u019d\7\25"+
		"\2\2\u019c\u018a\3\2\2\2\u019c\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u019f\b\16\1\2\u019f\33\3\2\2\2\u01a0\u01a1\5\36\20\2\u01a1\u01a2\b\17"+
		"\1\2\u01a2\u01a7\3\2\2\2\u01a3\u01a4\5 \21\2\u01a4\u01a5\b\17\1\2\u01a5"+
		"\u01a7\3\2\2\2\u01a6\u01a0\3\2\2\2\u01a6\u01a3\3\2\2\2\u01a7\35\3\2\2"+
		"\2\u01a8\u01aa\5\\/\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac"+
		"\3\2\2\2\u01ab\u01ad\7\34\2\2\u01ac\u01ab\3\2\2\2\u01ac\u01ad\3\2\2\2"+
		"\u01ad\u01b0\3\2\2\2\u01ae\u01b1\7\35\2\2\u01af\u01b1\7\36\2\2\u01b0\u01ae"+
		"\3\2\2\2\u01b0\u01af\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2"+
		"\u01b4\7\37\2\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3"+
		"\2\2\2\u01b5\u01b7\7 \2\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01ba\3\2\2\2\u01b8\u01bb\7!\2\2\u01b9\u01bb\7\"\2\2\u01ba\u01b8\3\2"+
		"\2\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc"+
		"\u01be\7#\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\3\2"+
		"\2\2\u01bf\u01c0\7$\2\2\u01c0\u01c1\5z>\2\u01c1\u01c4\b\20\1\2\u01c2\u01c3"+
		"\7\b\2\2\u01c3\u01c5\5N(\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\u01c8\3\2\2\2\u01c6\u01c7\7\27\2\2\u01c7\u01c9\7\u008d\2\2\u01c8\u01c6"+
		"\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01dd\3\2\2\2\u01ca\u01d8\7\4\2\2\u01cb"+
		"\u01d4\7%\2\2\u01cc\u01d4\7&\2\2\u01cd\u01d4\7\'\2\2\u01ce\u01d4\7(\2"+
		"\2\u01cf\u01d4\7)\2\2\u01d0\u01d4\7*\2\2\u01d1\u01d4\7+\2\2\u01d2\u01d4"+
		"\7,\2\2\u01d3\u01cb\3\2\2\2\u01d3\u01cc\3\2\2\2\u01d3\u01cd\3\2\2\2\u01d3"+
		"\u01ce\3\2\2\2\u01d3\u01cf\3\2\2\2\u01d3\u01d0\3\2\2\2\u01d3\u01d1\3\2"+
		"\2\2\u01d3\u01d2\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d7\7\5\2\2\u01d6"+
		"\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d3\3\2"+
		"\2\2\u01d9\u01da\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01de\7\6\2\2\u01dd\u01ca\3\2\2\2\u01dd\u01de\3\2"+
		"\2\2\u01de\u01fa\3\2\2\2\u01df\u01f5\7\4\2\2\u01e0\u01e2\5\60\31\2\u01e1"+
		"\u01e0\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2"+
		"\2\2\u01e4\u01e8\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e9\5Z.\2\u01e7\u01e9"+
		"\5X-\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01f6\b\20\1\2\u01eb\u01ee\5Z.\2\u01ec\u01ee\5X-"+
		"\2\u01ed\u01eb\3\2\2\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01f2"+
		"\3\2\2\2\u01ef\u01f1\5\60\31\2\u01f0\u01ef\3\2\2\2\u01f1\u01f4\3\2\2\2"+
		"\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2"+
		"\3\2\2\2\u01f5\u01e3\3\2\2\2\u01f5\u01ed\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u01f8\b\20\1\2\u01f8\u01fb\7\6\2\2\u01f9\u01fb\7\25\2\2\u01fa\u01df\3"+
		"\2\2\2\u01fa\u01f9\3\2\2\2\u01fb\37\3\2\2\2\u01fc\u01fe\5\\/\2\u01fd\u01fc"+
		"\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200\3\2\2\2\u01ff\u0201\7\34\2\2"+
		"\u0200\u01ff\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0205"+
		"\7\35\2\2\u0203\u0205\7\36\2\2\u0204\u0202\3\2\2\2\u0204\u0203\3\2\2\2"+
		"\u0204\u0205\3\2\2\2\u0205\u0207\3\2\2\2\u0206\u0208\7\37\2\2\u0207\u0206"+
		"\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209\u020b\7 \2\2\u020a"+
		"\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020f\7!"+
		"\2\2\u020d\u020f\7\"\2\2\u020e\u020c\3\2\2\2\u020e\u020d\3\2\2\2\u020e"+
		"\u020f\3\2\2\2\u020f\u0211\3\2\2\2\u0210\u0212\7#\2\2\u0211\u0210\3\2"+
		"\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\7-\2\2\u0214"+
		"\u0215\5z>\2\u0215\u0218\b\21\1\2\u0216\u0217\7.\2\2\u0217\u0219\5z>\2"+
		"\u0218\u0216\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021c\3\2\2\2\u021a\u021b"+
		"\7\b\2\2\u021b\u021d\5N(\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d"+
		"\u0220\3\2\2\2\u021e\u021f\7\27\2\2\u021f\u0221\7\u008d\2\2\u0220\u021e"+
		"\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0237\3\2\2\2\u0222\u0232\7\4\2\2\u0223"+
		"\u022e\7/\2\2\u0224\u022e\7%\2\2\u0225\u022e\7\'\2\2\u0226\u022e\7(\2"+
		"\2\u0227\u022e\7)\2\2\u0228\u022e\7*\2\2\u0229\u022e\7\60\2\2\u022a\u022e"+
		"\7\61\2\2\u022b\u022e\7+\2\2\u022c\u022e\7,\2\2\u022d\u0223\3\2\2\2\u022d"+
		"\u0224\3\2\2\2\u022d\u0225\3\2\2\2\u022d\u0226\3\2\2\2\u022d\u0227\3\2"+
		"\2\2\u022d\u0228\3\2\2\2\u022d\u0229\3\2\2\2\u022d\u022a\3\2\2\2\u022d"+
		"\u022b\3\2\2\2\u022d\u022c\3\2\2\2\u022e\u0230\3\2\2\2\u022f\u0231\7\5"+
		"\2\2\u0230\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0233\3\2\2\2\u0232"+
		"\u022d\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2"+
		"\2\2\u0235\u0236\3\2\2\2\u0236\u0238\7\6\2\2\u0237\u0222\3\2\2\2\u0237"+
		"\u0238\3\2\2\2\u0238\u025f\3\2\2\2\u0239\u0245\7\4\2\2\u023a\u023b\7\62"+
		"\2\2\u023b\u0240\5z>\2\u023c\u023d\7\5\2\2\u023d\u023f\5z>\2\u023e\u023c"+
		"\3\2\2\2\u023f\u0242\3\2\2\2\u0240\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241"+
		"\u0243\3\2\2\2\u0242\u0240\3\2\2\2\u0243\u0244\7\25\2\2\u0244\u0246\3"+
		"\2\2\2\u0245\u023a\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u025b\3\2\2\2\u0247"+
		"\u0249\5\60\31\2\u0248\u0247\3\2\2\2\u0249\u024c\3\2\2\2\u024a\u0248\3"+
		"\2\2\2\u024a\u024b\3\2\2\2\u024b\u024f\3\2\2\2\u024c\u024a\3\2\2\2\u024d"+
		"\u0250\5Z.\2\u024e\u0250\5X-\2\u024f\u024d\3\2\2\2\u024f\u024e\3\2\2\2"+
		"\u024f\u0250\3\2\2\2\u0250\u025c\3\2\2\2\u0251\u0254\5Z.\2\u0252\u0254"+
		"\5X-\2\u0253\u0251\3\2\2\2\u0253\u0252\3\2\2\2\u0253\u0254\3\2\2\2\u0254"+
		"\u0258\3\2\2\2\u0255\u0257\5\60\31\2\u0256\u0255\3\2\2\2\u0257\u025a\3"+
		"\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025c\3\2\2\2\u025a"+
		"\u0258\3\2\2\2\u025b\u024a\3\2\2\2\u025b\u0253\3\2\2\2\u025c\u025d\3\2"+
		"\2\2\u025d\u0260\7\6\2\2\u025e\u0260\7\25\2\2\u025f\u0239\3\2\2\2\u025f"+
		"\u025e\3\2\2\2\u0260!\3\2\2\2\u0261\u0263\5\\/\2\u0262\u0261\3\2\2\2\u0262"+
		"\u0263\3\2\2\2\u0263\u0265\3\2\2\2\u0264\u0266\7\34\2\2\u0265\u0264\3"+
		"\2\2\2\u0265\u0266\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0269\7\63\2\2\u0268"+
		"\u026a\5<\37\2\u0269\u0268\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026b\3\2"+
		"\2\2\u026b\u026c\5z>\2\u026c\u026d\b\22\1\2\u026d\u0276\7\21\2\2\u026e"+
		"\u0273\5$\23\2\u026f\u0270\7\5\2\2\u0270\u0272\5$\23\2\u0271\u026f\3\2"+
		"\2\2\u0272\u0275\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274"+
		"\u0277\3\2\2\2\u0275\u0273\3\2\2\2\u0276\u026e\3\2\2\2\u0276\u0277\3\2"+
		"\2\2\u0277\u0278\3\2\2\2\u0278\u0279\7\22\2\2\u0279\u027c\b\22\1\2\u027a"+
		"\u027b\7\b\2\2\u027b\u027d\5N(\2\u027c\u027a\3\2\2\2\u027c\u027d\3\2\2"+
		"\2\u027d\u0287\3\2\2\2\u027e\u027f\7\64\2\2\u027f\u0284\5B\"\2\u0280\u0281"+
		"\7\5\2\2\u0281\u0283\5B\"\2\u0282\u0280\3\2\2\2\u0283\u0286\3\2\2\2\u0284"+
		"\u0282\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0288\3\2\2\2\u0286\u0284\3\2"+
		"\2\2\u0287\u027e\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0298\3\2\2\2\u0289"+
		"\u0293\7\4\2\2\u028a\u028f\7\'\2\2\u028b\u028f\7(\2\2\u028c\u028f\7)\2"+
		"\2\u028d\u028f\7*\2\2\u028e\u028a\3\2\2\2\u028e\u028b\3\2\2\2\u028e\u028c"+
		"\3\2\2\2\u028e\u028d\3\2\2\2\u028f\u0291\3\2\2\2\u0290\u0292\7\5\2\2\u0291"+
		"\u0290\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0294\3\2\2\2\u0293\u028e\3\2"+
		"\2\2\u0294\u0295\3\2\2\2\u0295\u0293\3\2\2\2\u0295\u0296\3\2\2\2\u0296"+
		"\u0297\3\2\2\2\u0297\u0299\7\6\2\2\u0298\u0289\3\2\2\2\u0298\u0299\3\2"+
		"\2\2\u0299\u02a8\3\2\2\2\u029a\u02a3\7\4\2\2\u029b\u029c\5\60\31\2\u029c"+
		"\u029d\b\22\1\2\u029d\u02a2\3\2\2\2\u029e\u02a2\5T+\2\u029f\u02a2\5P)"+
		"\2\u02a0\u02a2\5V,\2\u02a1\u029b\3\2\2\2\u02a1\u029e\3\2\2\2\u02a1\u029f"+
		"\3\2\2\2\u02a1\u02a0\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a3"+
		"\u02a4\3\2\2\2\u02a4\u02a6\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a6\u02a9\7\6"+
		"\2\2\u02a7\u02a9\7\25\2\2\u02a8\u029a\3\2\2\2\u02a8\u02a7\3\2\2\2\u02a9"+
		"#\3\2\2\2\u02aa\u02ad\7!\2\2\u02ab\u02ad\7\"\2\2\u02ac\u02aa\3\2\2\2\u02ac"+
		"\u02ab\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02af\5z"+
		">\2\u02af\u02b0\b\23\1\2\u02b0\u02b2\7\b\2\2\u02b1\u02b3\5N(\2\u02b2\u02b1"+
		"\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02c3\3\2\2\2\u02b4\u02be\7\4\2\2\u02b5"+
		"\u02ba\7\'\2\2\u02b6\u02ba\7(\2\2\u02b7\u02ba\7)\2\2\u02b8\u02ba\7*\2"+
		"\2\u02b9\u02b5\3\2\2\2\u02b9\u02b6\3\2\2\2\u02b9\u02b7\3\2\2\2\u02b9\u02b8"+
		"\3\2\2\2\u02ba\u02bc\3\2\2\2\u02bb\u02bd\7\5\2\2\u02bc\u02bb\3\2\2\2\u02bc"+
		"\u02bd\3\2\2\2\u02bd\u02bf\3\2\2\2\u02be\u02b9\3\2\2\2\u02bf\u02c0\3\2"+
		"\2\2\u02c0\u02be\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2"+
		"\u02c4\7\6\2\2\u02c3\u02b4\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02ce\3\2"+
		"\2\2\u02c5\u02c9\7\4\2\2\u02c6\u02c8\5\60\31\2\u02c7\u02c6\3\2\2\2\u02c8"+
		"\u02cb\3\2\2\2\u02c9\u02c7\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cc\3\2"+
		"\2\2\u02cb\u02c9\3\2\2\2\u02cc\u02cd\b\23\1\2\u02cd\u02cf\7\6\2\2\u02ce"+
		"\u02c5\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf%\3\2\2\2\u02d0\u02d7\7\r\2\2"+
		"\u02d1\u02d4\5\u0080A\2\u02d2\u02d3\7\20\2\2\u02d3\u02d5\5~@\2\u02d4\u02d2"+
		"\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d8\3\2\2\2\u02d6\u02d8\t\2\2\2\u02d7"+
		"\u02d1\3\2\2\2\u02d7\u02d6\3\2\2\2\u02d8\u02db\3\2\2\2\u02d9\u02dc\78"+
		"\2\2\u02da\u02dc\79\2\2\u02db\u02d9\3\2\2\2\u02db\u02da\3\2\2\2\u02db"+
		"\u02dc\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02de\7\16\2\2\u02de\'\3\2\2"+
		"\2\u02df\u02e1\5\\/\2\u02e0\u02df\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e7"+
		"\3\2\2\2\u02e2\u02e8\7:\2\2\u02e3\u02e6\7!\2\2\u02e4\u02e6\7\"\2\2\u02e5"+
		"\u02e3\3\2\2\2\u02e5\u02e4\3\2\2\2\u02e6\u02e8\3\2\2\2\u02e7\u02e2\3\2"+
		"\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9"+
		"\u02ea\7;\2\2\u02ea\u02eb\5z>\2\u02eb\u02ed\b\25\1\2\u02ec\u02ee\5<\37"+
		"\2\u02ed\u02ec\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02f1\3\2\2\2\u02ef\u02f0"+
		"\7\b\2\2\u02f0\u02f2\7\u008d\2\2\u02f1\u02ef\3\2\2\2\u02f1\u02f2\3\2\2"+
		"\2\u02f2\u02f9\3\2\2\2\u02f3\u02f6\7\4\2\2\u02f4\u02f7\7<\2\2\u02f5\u02f7"+
		"\7=\2\2\u02f6\u02f4\3\2\2\2\u02f6\u02f5\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7"+
		"\u02f8\3\2\2\2\u02f8\u02fa\7\6\2\2\u02f9\u02f3\3\2\2\2\u02f9\u02fa\3\2"+
		"\2\2\u02fa\u0307\3\2\2\2\u02fb\u0302\7\4\2\2\u02fc\u02fd\5\60\31\2\u02fd"+
		"\u02fe\b\25\1\2\u02fe\u0301\3\2\2\2\u02ff\u0301\5R*\2\u0300\u02fc\3\2"+
		"\2\2\u0300\u02ff\3\2\2\2\u0301\u0304\3\2\2\2\u0302\u0300\3\2\2\2\u0302"+
		"\u0303\3\2\2\2\u0303\u0305\3\2\2\2\u0304\u0302\3\2\2\2\u0305\u0308\7\6"+
		"\2\2\u0306\u0308\7\25\2\2\u0307\u02fb\3\2\2\2\u0307\u0306\3\2\2\2\u0308"+
		")\3\2\2\2\u0309\u030a\t\3\2\2\u030a+\3\2\2\2\u030b\u030d\5\\/\2\u030c"+
		"\u030b\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030f\7C"+
		"\2\2\u030f\u0310\5z>\2\u0310\u0312\b\27\1\2\u0311\u0313\5<\37\2\u0312"+
		"\u0311\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0316\3\2\2\2\u0314\u0315\7\b"+
		"\2\2\u0315\u0317\7\u008d\2\2\u0316\u0314\3\2\2\2\u0316\u0317\3\2\2\2\u0317"+
		"\u031e\3\2\2\2\u0318\u031b\7\4\2\2\u0319\u031c\7<\2\2\u031a\u031c\7=\2"+
		"\2\u031b\u0319\3\2\2\2\u031b\u031a\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031d"+
		"\3\2\2\2\u031d\u031f\7\6\2\2\u031e\u0318\3\2\2\2\u031e\u031f\3\2\2\2\u031f"+
		"\u032f\3\2\2\2\u0320\u032a\7\4\2\2\u0321\u0322\5\60\31\2\u0322\u0323\b"+
		"\27\1\2\u0323\u0329\3\2\2\2\u0324\u0325\5.\30\2\u0325\u0326\b\27\1\2\u0326"+
		"\u0329\3\2\2\2\u0327\u0329\5R*\2\u0328\u0321\3\2\2\2\u0328\u0324\3\2\2"+
		"\2\u0328\u0327\3\2\2\2\u0329\u032c\3\2\2\2\u032a\u0328\3\2\2\2\u032a\u032b"+
		"\3\2\2\2\u032b\u032d\3\2\2\2\u032c\u032a\3\2\2\2\u032d\u0330\7\6\2\2\u032e"+
		"\u0330\7\25\2\2\u032f\u0320\3\2\2\2\u032f\u032e\3\2\2\2\u0330-\3\2\2\2"+
		"\u0331\u0332\7D\2\2\u0332\u0335\5z>\2\u0333\u0335\5z>\2\u0334\u0331\3"+
		"\2\2\2\u0334\u0333\3\2\2\2\u0335\u0338\3\2\2\2\u0336\u0337\7\27\2\2\u0337"+
		"\u0339\5\u0082B\2\u0338\u0336\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u033a"+
		"\3\2\2\2\u033a\u0345\b\30\1\2\u033b\u033f\7\4\2\2\u033c\u033e\5\60\31"+
		"\2\u033d\u033c\3\2\2\2\u033e\u0341\3\2\2\2\u033f\u033d\3\2\2\2\u033f\u0340"+
		"\3\2\2\2\u0340\u0342\3\2\2\2\u0341\u033f\3\2\2\2\u0342\u0343\b\30\1\2"+
		"\u0343\u0346\7\6\2\2\u0344\u0346\7\25\2\2\u0345\u033b\3\2\2\2\u0345\u0344"+
		"\3\2\2\2\u0346/\3\2\2\2\u0347\u0349\7E\2\2\u0348\u034a\7\u008d\2\2\u0349"+
		"\u0348\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u0357\b\31"+
		"\1\2\u034c\u034d\7\21\2\2\u034d\u0352\5\62\32\2\u034e\u034f\7\5\2\2\u034f"+
		"\u0351\5\62\32\2\u0350\u034e\3\2\2\2\u0351\u0354\3\2\2\2\u0352\u0350\3"+
		"\2\2\2\u0352\u0353\3\2\2\2\u0353\u0355\3\2\2\2\u0354\u0352\3\2\2\2\u0355"+
		"\u0356\7\22\2\2\u0356\u0358\3\2\2\2\u0357\u034c\3\2\2\2\u0357\u0358\3"+
		"\2\2\2\u0358\u0359\3\2\2\2\u0359\u0369\b\31\1\2\u035a\u0362\7\4\2\2\u035b"+
		"\u035c\5\60\31\2\u035c\u035d\b\31\1\2\u035d\u0363\3\2\2\2\u035e\u035f"+
		"\5\64\33\2\u035f\u0360\b\31\1\2\u0360\u0363\3\2\2\2\u0361\u0363\5:\36"+
		"\2\u0362\u035b\3\2\2\2\u0362\u035e\3\2\2\2\u0362\u0361\3\2\2\2\u0363\u0364"+
		"\3\2\2\2\u0364\u0362\3\2\2\2\u0364\u0365\3\2\2\2\u0365\u0366\3\2\2\2\u0366"+
		"\u0367\7\6\2\2\u0367\u036a\3\2\2\2\u0368\u036a\7\25\2\2\u0369\u035a\3"+
		"\2\2\2\u0369\u0368\3\2\2\2\u036a\61\3\2\2\2\u036b\u036d\7\u008d\2\2\u036c"+
		"\u036b\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u0370\7\27"+
		"\2\2\u036f\u0371\t\4\2\2\u0370\u036f\3\2\2\2\u0370\u0371\3\2\2\2\u0371"+
		"\u0372\3\2\2\2\u0372\u0373\b\32\1\2\u0373\63\3\2\2\2\u0374\u0375\5\60"+
		"\31\2\u0375\u0376\b\33\1\2\u0376\u037b\3\2\2\2\u0377\u0378\5\66\34\2\u0378"+
		"\u0379\b\33\1\2\u0379\u037b\3\2\2\2\u037a\u0374\3\2\2\2\u037a\u0377\3"+
		"\2\2\2\u037b\65\3\2\2\2\u037c\u037d\58\35\2\u037d\u037e\b\34\1\2\u037e"+
		"\u0389\3\2\2\2\u037f\u0380\5\30\r\2\u0380\u0381\b\34\1\2\u0381\u0389\3"+
		"\2\2\2\u0382\u0383\5\26\f\2\u0383\u0384\b\34\1\2\u0384\u0389\3\2\2\2\u0385"+
		"\u0386\5.\30\2\u0386\u0387\b\34\1\2\u0387\u0389\3\2\2\2\u0388\u037c\3"+
		"\2\2\2\u0388\u037f\3\2\2\2\u0388\u0382\3\2\2\2\u0388\u0385\3\2\2\2\u0389"+
		"\67\3\2\2\2\u038a\u038b\5\"\22\2\u038b\u038c\b\35\1\2\u038c\u0394\3\2"+
		"\2\2\u038d\u038e\5$\23\2\u038e\u038f\b\35\1\2\u038f\u0394\3\2\2\2\u0390"+
		"\u0391\5\34\17\2\u0391\u0392\b\35\1\2\u0392\u0394\3\2\2\2\u0393\u038a"+
		"\3\2\2\2\u0393\u038d\3\2\2\2\u0393\u0390\3\2\2\2\u03949\3\2\2\2\u0395"+
		"\u0396\7F\2\2\u0396\u0397\5L\'\2\u0397\u0398\7\25\2\2\u0398;\3\2\2\2\u0399"+
		"\u039a\7G\2\2\u039a\u039f\5> \2\u039b\u039c\7\5\2\2\u039c\u039e\5> \2"+
		"\u039d\u039b\3\2\2\2\u039e\u03a1\3\2\2\2\u039f\u039d\3\2\2\2\u039f\u03a0"+
		"\3\2\2\2\u03a0\u03a2\3\2\2\2\u03a1\u039f\3\2\2\2\u03a2\u03a3\7H\2\2\u03a3"+
		"=\3\2\2\2\u03a4\u03ae\5z>\2\u03a5\u03a6\7\33\2\2\u03a6\u03ab\5B\"\2\u03a7"+
		"\u03a8\7I\2\2\u03a8\u03aa\5B\"\2\u03a9\u03a7\3\2\2\2\u03aa\u03ad\3\2\2"+
		"\2\u03ab\u03a9\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03af\3\2\2\2\u03ad\u03ab"+
		"\3\2\2\2\u03ae\u03a5\3\2\2\2\u03ae\u03af\3\2\2\2\u03af?\3\2\2\2\u03b0"+
		"\u03b3\5B\"\2\u03b1\u03b3\5F$\2\u03b2\u03b0\3\2\2\2\u03b2\u03b1\3\2\2"+
		"\2\u03b3A\3\2\2\2\u03b4\u03b7\5*\26\2\u03b5\u03b7\5D#\2\u03b6\u03b4\3"+
		"\2\2\2\u03b6\u03b5\3\2\2\2\u03b7C\3\2\2\2\u03b8\u03bd\5L\'\2\u03b9\u03ba"+
		"\7G\2\2\u03ba\u03bb\5H%\2\u03bb\u03bc\7H\2\2\u03bc\u03be\3\2\2\2\u03bd"+
		"\u03b9\3\2\2\2\u03bd\u03be\3\2\2\2\u03beE\3\2\2\2\u03bf\u03c2\7\67\2\2"+
		"\u03c0\u03c1\t\5\2\2\u03c1\u03c3\5B\"\2\u03c2\u03c0\3\2\2\2\u03c2\u03c3"+
		"\3\2\2\2\u03c3G\3\2\2\2\u03c4\u03c9\5J&\2\u03c5\u03c6\7\5\2\2\u03c6\u03c8"+
		"\5J&\2\u03c7\u03c5\3\2\2\2\u03c8\u03cb\3\2\2\2\u03c9\u03c7\3\2\2\2\u03c9"+
		"\u03ca\3\2\2\2\u03ca\u03cd\3\2\2\2\u03cb\u03c9\3\2\2\2\u03cc\u03ce\5&"+
		"\24\2\u03cd\u03cc\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ceI\3\2\2\2\u03cf\u03d0"+
		"\5@!\2\u03d0K\3\2\2\2\u03d1\u03d6\5z>\2\u03d2\u03d3\7K\2\2\u03d3\u03d5"+
		"\5z>\2\u03d4\u03d2\3\2\2\2\u03d5\u03d8\3\2\2\2\u03d6\u03d4\3\2\2\2\u03d6"+
		"\u03d7\3\2\2\2\u03d7M\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d9\u03db\5B\"\2\u03da"+
		"\u03dc\5&\24\2\u03db\u03da\3\2\2\2\u03db\u03dc\3\2\2\2\u03dcO\3\2\2\2"+
		"\u03dd\u03df\7L\2\2\u03de\u03e0\5|?\2\u03df\u03de\3\2\2\2\u03df\u03e0"+
		"\3\2\2\2\u03e0\u03e7\3\2\2\2\u03e1\u03e3\7\b\2\2\u03e2\u03e4\5d\63\2\u03e3"+
		"\u03e2\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5\u03e8\7\25"+
		"\2\2\u03e6\u03e8\7\25\2\2\u03e7\u03e1\3\2\2\2\u03e7\u03e6\3\2\2\2\u03e8"+
		"Q\3\2\2\2\u03e9\u03eb\7M\2\2\u03ea\u03e9\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb"+
		"\u03ec\3\2\2\2\u03ec\u03f3\7N\2\2\u03ed\u03f1\5|?\2\u03ee\u03ef\7\21\2"+
		"\2\u03ef\u03f0\7\u008c\2\2\u03f0\u03f2\7\22\2\2\u03f1\u03ee\3\2\2\2\u03f1"+
		"\u03f2\3\2\2\2\u03f2\u03f4\3\2\2\2\u03f3\u03ed\3\2\2\2\u03f3\u03f4\3\2"+
		"\2\2\u03f4\u03fb\3\2\2\2\u03f5\u03f7\7\b\2\2\u03f6\u03f8\5b\62\2\u03f7"+
		"\u03f6\3\2\2\2\u03f7\u03f8\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9\u03fc\7\25"+
		"\2\2\u03fa\u03fc\7\25\2\2\u03fb\u03f5\3\2\2\2\u03fb\u03fa\3\2\2\2\u03fc"+
		"S\3\2\2\2\u03fd\u0404\t\6\2\2\u03fe\u0402\5|?\2\u03ff\u0400\7\21\2\2\u0400"+
		"\u0401\7\u008c\2\2\u0401\u0403\7\22\2\2\u0402\u03ff\3\2\2\2\u0402\u0403"+
		"\3\2\2\2\u0403\u0405\3\2\2\2\u0404\u03fe\3\2\2\2\u0404\u0405\3\2\2\2\u0405"+
		"\u040c\3\2\2\2\u0406\u0408\7\b\2\2\u0407\u0409\5b\62\2\u0408\u0407\3\2"+
		"\2\2\u0408\u0409\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u040d\7\25\2\2\u040b"+
		"\u040d\7\25\2\2\u040c\u0406\3\2\2\2\u040c\u040b\3\2\2\2\u040dU\3\2\2\2"+
		"\u040e\u0415\t\7\2\2\u040f\u0413\5|?\2\u0410\u0411\7\21\2\2\u0411\u0412"+
		"\7\u008c\2\2\u0412\u0414\7\22\2\2\u0413\u0410\3\2\2\2\u0413\u0414\3\2"+
		"\2\2\u0414\u0416\3\2\2\2\u0415\u040f\3\2\2\2\u0415\u0416\3\2\2\2\u0416"+
		"\u041d\3\2\2\2\u0417\u0419\7\b\2\2\u0418\u041a\5b\62\2\u0419\u0418\3\2"+
		"\2\2\u0419\u041a\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041e\7\25\2\2\u041c"+
		"\u041e\7\25\2\2\u041d\u0417\3\2\2\2\u041d\u041c\3\2\2\2\u041eW\3\2\2\2"+
		"\u041f\u0421\7S\2\2\u0420\u0422\5|?\2\u0421\u0420\3\2\2\2\u0421\u0422"+
		"\3\2\2\2\u0422\u0429\3\2\2\2\u0423\u0425\7\b\2\2\u0424\u0426\5d\63\2\u0425"+
		"\u0424\3\2\2\2\u0425\u0426\3\2\2\2\u0426\u0427\3\2\2\2\u0427\u042a\7\25"+
		"\2\2\u0428\u042a\7\25\2\2\u0429\u0423\3\2\2\2\u0429\u0428\3\2\2\2\u042a"+
		"Y\3\2\2\2\u042b\u042d\7T\2\2\u042c\u042e\5|?\2\u042d\u042c\3\2\2\2\u042d"+
		"\u042e\3\2\2\2\u042e\u0435\3\2\2\2\u042f\u0431\7\b\2\2\u0430\u0432\5d"+
		"\63\2\u0431\u0430\3\2\2\2\u0431\u0432\3\2\2\2\u0432\u0433\3\2\2\2\u0433"+
		"\u0436\7\25\2\2\u0434\u0436\7\25\2\2\u0435\u042f\3\2\2\2\u0435\u0434\3"+
		"\2\2\2\u0436[\3\2\2\2\u0437\u0438\t\b\2\2\u0438]\3\2\2\2\u0439\u043a\7"+
		"\u008b\2\2\u043a\u043d\b\60\1\2\u043b\u043d\7\u008a\2\2\u043c\u0439\3"+
		"\2\2\2\u043c\u043b\3\2\2\2\u043d_\3\2\2\2\u043e\u043f\7\u008a\2\2\u043f"+
		"a\3\2\2\2\u0440\u0441\b\62\1\2\u0441\u0442\7X\2\2\u0442\u0547\5d\63\2"+
		"\u0443\u0444\7Y\2\2\u0444\u0547\5d\63\2\u0445\u0446\7Z\2\2\u0446\u0547"+
		"\5d\63\2\u0447\u0448\7[\2\2\u0448\u0547\5d\63\2\u0449\u044b\5d\63\2\u044a"+
		"\u044c\t\t\2\2\u044b\u044a\3\2\2\2\u044b\u044c\3\2\2\2\u044c\u044d\3\2"+
		"\2\2\u044d\u044e\7^\2\2\u044e\u044f\5d\63\2\u044f\u0547\3\2\2\2\u0450"+
		"\u0452\5d\63\2\u0451\u0453\t\t\2\2\u0452\u0451\3\2\2\2\u0452\u0453\3\2"+
		"\2\2\u0453\u0454\3\2\2\2\u0454\u0455\7\27\2\2\u0455\u0456\5d\63\2\u0456"+
		"\u0547\3\2\2\2\u0457\u0459\5f\64\2\u0458\u045a\t\t\2\2\u0459\u0458\3\2"+
		"\2\2\u0459\u045a\3\2\2\2\u045a\u045b\3\2\2\2\u045b\u045c\7\27\2\2\u045c"+
		"\u045d\5f\64\2\u045d\u0547\3\2\2\2\u045e\u0460\5f\64\2\u045f\u0461\t\t"+
		"\2\2\u0460\u045f\3\2\2\2\u0460\u0461\3\2\2\2\u0461\u0462\3\2\2\2\u0462"+
		"\u0463\7G\2\2\u0463\u0464\5f\64\2\u0464\u0547\3\2\2\2\u0465\u0467\5f\64"+
		"\2\u0466\u0468\t\t\2\2\u0467\u0466\3\2\2\2\u0467\u0468\3\2\2\2\u0468\u0469"+
		"\3\2\2\2\u0469\u046a\7_\2\2\u046a\u046b\5f\64\2\u046b\u0547\3\2\2\2\u046c"+
		"\u046e\5f\64\2\u046d\u046f\t\t\2\2\u046e\u046d\3\2\2\2\u046e\u046f\3\2"+
		"\2\2\u046f\u0470\3\2\2\2\u0470\u0471\7H\2\2\u0471\u0472\5f\64\2\u0472"+
		"\u0547\3\2\2\2\u0473\u0475\5f\64\2\u0474\u0476\t\t\2\2\u0475\u0474\3\2"+
		"\2\2\u0475\u0476\3\2\2\2\u0476\u0477\3\2\2\2\u0477\u0478\7`\2\2\u0478"+
		"\u0479\5f\64\2\u0479\u0547\3\2\2\2\u047a\u047b\b\62\1\2\u047b\u047c\7"+
		"a\2\2\u047c\u047d\5h\65\2\u047d\u047e\7b\2\2\u047e\u047f\5f\64\2\u047f"+
		"\u0480\3\2\2\2\u0480\u0481\b\62\1\2\u0481\u0547\3\2\2\2\u0482\u0483\7"+
		"c\2\2\u0483\u0484\7\r\2\2\u0484\u0485\5t;\2\u0485\u0486\7\16\2\2\u0486"+
		"\u0547\3\2\2\2\u0487\u0488\7d\2\2\u0488\u0489\7\r\2\2\u0489\u048a\5t;"+
		"\2\u048a\u048b\7\b\2\2\u048b\u048c\5d\63\2\u048c\u048d\7e\2\2\u048d\u048e"+
		"\t\n\2\2\u048e\u048f\5d\63\2\u048f\u0490\7\16\2\2\u0490\u0547\3\2\2\2"+
		"\u0491\u0492\7f\2\2\u0492\u0493\7\r\2\2\u0493\u0494\5t;\2\u0494\u0495"+
		"\7\5\2\2\u0495\u0496\5t;\2\u0496\u0497\7\5\2\2\u0497\u0498\5t;\2\u0498"+
		"\u0499\7\5\2\2\u0499\u049a\5t;\2\u049a\u049b\7\16\2\2\u049b\u0547\3\2"+
		"\2\2\u049c\u049d\t\t\2\2\u049d\u0547\5b\62\20\u049e\u049f\b\62\1\2\u049f"+
		"\u04a0\7o\2\2\u04a0\u04b5\5h\65\2\u04a1\u04ab\7b\2\2\u04a2\u04ac\5b\62"+
		"\2\u04a3\u04a7\7\4\2\2\u04a4\u04a6\5b\62\2\u04a5\u04a4\3\2\2\2\u04a6\u04a9"+
		"\3\2\2\2\u04a7\u04a5\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u04aa\3\2\2\2\u04a9"+
		"\u04a7\3\2\2\2\u04aa\u04ac\7\6\2\2\u04ab\u04a2\3\2\2\2\u04ab\u04a3\3\2"+
		"\2\2\u04ac\u04b6\3\2\2\2\u04ad\u04b1\7\4\2\2\u04ae\u04b0\5b\62\2\u04af"+
		"\u04ae\3\2\2\2\u04b0\u04b3\3\2\2\2\u04b1\u04af\3\2\2\2\u04b1\u04b2\3\2"+
		"\2\2\u04b2\u04b4\3\2\2\2\u04b3\u04b1\3\2\2\2\u04b4\u04b6\7\6\2\2\u04b5"+
		"\u04a1\3\2\2\2\u04b5\u04ad\3\2\2\2\u04b6\u04b7\3\2\2\2\u04b7\u04b8\b\62"+
		"\1\2\u04b8\u0547\3\2\2\2\u04b9\u04ba\b\62\1\2\u04ba\u04bb\7[\2\2\u04bb"+
		"\u04d0\5h\65\2\u04bc\u04c6\7b\2\2\u04bd\u04c7\5b\62\2\u04be\u04c2\7\4"+
		"\2\2\u04bf\u04c1\5b\62\2\u04c0\u04bf\3\2\2\2\u04c1\u04c4\3\2\2\2\u04c2"+
		"\u04c0\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3\u04c5\3\2\2\2\u04c4\u04c2\3\2"+
		"\2\2\u04c5\u04c7\7\6\2\2\u04c6\u04bd\3\2\2\2\u04c6\u04be\3\2\2\2\u04c7"+
		"\u04d1\3\2\2\2\u04c8\u04cc\7\4\2\2\u04c9\u04cb\5b\62\2\u04ca\u04c9\3\2"+
		"\2\2\u04cb\u04ce\3\2\2\2\u04cc\u04ca\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd"+
		"\u04cf\3\2\2\2\u04ce\u04cc\3\2\2\2\u04cf\u04d1\7\6\2\2\u04d0\u04bc\3\2"+
		"\2\2\u04d0\u04c8\3\2\2\2\u04d1\u04d2\3\2\2\2\u04d2\u04d3\b\62\1\2\u04d3"+
		"\u0547\3\2\2\2\u04d4\u04d5\b\62\1\2\u04d5\u04d6\7X\2\2\u04d6\u04eb\5h"+
		"\65\2\u04d7\u04e1\7b\2\2\u04d8\u04e2\5b\62\2\u04d9\u04dd\7\4\2\2\u04da"+
		"\u04dc\5b\62\2\u04db\u04da\3\2\2\2\u04dc\u04df\3\2\2\2\u04dd\u04db\3\2"+
		"\2\2\u04dd\u04de\3\2\2\2\u04de\u04e0\3\2\2\2\u04df\u04dd\3\2\2\2\u04e0"+
		"\u04e2\7\6\2\2\u04e1\u04d8\3\2\2\2\u04e1\u04d9\3\2\2\2\u04e2\u04ec\3\2"+
		"\2\2\u04e3\u04e7\7\4\2\2\u04e4\u04e6\5b\62\2\u04e5\u04e4\3\2\2\2\u04e6"+
		"\u04e9\3\2\2\2\u04e7\u04e5\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8\u04ea\3\2"+
		"\2\2\u04e9\u04e7\3\2\2\2\u04ea\u04ec\7\6\2\2\u04eb\u04d7\3\2\2\2\u04eb"+
		"\u04e3\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed\u04ee\b\62\1\2\u04ee\u0547\3"+
		"\2\2\2\u04ef\u04f0\b\62\1\2\u04f0\u04f1\7Z\2\2\u04f1\u0506\5h\65\2\u04f2"+
		"\u04fc\7b\2\2\u04f3\u04fd\5b\62\2\u04f4\u04f8\7\4\2\2\u04f5\u04f7\5b\62"+
		"\2\u04f6\u04f5\3\2\2\2\u04f7\u04fa\3\2\2\2\u04f8\u04f6\3\2\2\2\u04f8\u04f9"+
		"\3\2\2\2\u04f9\u04fb\3\2\2\2\u04fa\u04f8\3\2\2\2\u04fb\u04fd\7\6\2\2\u04fc"+
		"\u04f3\3\2\2\2\u04fc\u04f4\3\2\2\2\u04fd\u0507\3\2\2\2\u04fe\u0502\7\4"+
		"\2\2\u04ff\u0501\5b\62\2\u0500\u04ff\3\2\2\2\u0501\u0504\3\2\2\2\u0502"+
		"\u0500\3\2\2\2\u0502\u0503\3\2\2\2\u0503\u0505\3\2\2\2\u0504\u0502\3\2"+
		"\2\2\u0505\u0507\7\6\2\2\u0506\u04f2\3\2\2\2\u0506\u04fe\3\2\2\2\u0507"+
		"\u0508\3\2\2\2\u0508\u0509\b\62\1\2\u0509\u0547\3\2\2\2\u050a\u050b\b"+
		"\62\1\2\u050b\u050c\7Y\2\2\u050c\u0521\5h\65\2\u050d\u0517\7b\2\2\u050e"+
		"\u0518\5b\62\2\u050f\u0513\7\4\2\2\u0510\u0512\5b\62\2\u0511\u0510\3\2"+
		"\2\2\u0512\u0515\3\2\2\2\u0513\u0511\3\2\2\2\u0513\u0514\3\2\2\2\u0514"+
		"\u0516\3\2\2\2\u0515\u0513\3\2\2\2\u0516\u0518\7\6\2\2\u0517\u050e\3\2"+
		"\2\2\u0517\u050f\3\2\2\2\u0518\u0522\3\2\2\2\u0519\u051d\7\4\2\2\u051a"+
		"\u051c\5b\62\2\u051b\u051a\3\2\2\2\u051c\u051f\3\2\2\2\u051d\u051b\3\2"+
		"\2\2\u051d\u051e\3\2\2\2\u051e\u0520\3\2\2\2\u051f\u051d\3\2\2\2\u0520"+
		"\u0522\7\6\2\2\u0521\u050d\3\2\2\2\u0521\u0519\3\2\2\2\u0522\u0523\3\2"+
		"\2\2\u0523\u0524\b\62\1\2\u0524\u0547\3\2\2\2\u0525\u0526\b\62\1\2\u0526"+
		"\u0527\7p\2\2\u0527\u053c\5l\67\2\u0528\u0532\7b\2\2\u0529\u0533\5b\62"+
		"\2\u052a\u052e\7\4\2\2\u052b\u052d\5b\62\2\u052c\u052b\3\2\2\2\u052d\u0530"+
		"\3\2\2\2\u052e\u052c\3\2\2\2\u052e\u052f\3\2\2\2\u052f\u0531\3\2\2\2\u0530"+
		"\u052e\3\2\2\2\u0531\u0533\7\6\2\2\u0532\u0529\3\2\2\2\u0532\u052a\3\2"+
		"\2\2\u0533\u053d\3\2\2\2\u0534\u0538\7\4\2\2\u0535\u0537\5b\62\2\u0536"+
		"\u0535\3\2\2\2\u0537\u053a\3\2\2\2\u0538\u0536\3\2\2\2\u0538\u0539\3\2"+
		"\2\2\u0539\u053b\3\2\2\2\u053a\u0538\3\2\2\2\u053b\u053d\7\6\2\2\u053c"+
		"\u0528\3\2\2\2\u053c\u0534\3\2\2\2\u053d\u053e\3\2\2\2\u053e\u053f\b\62"+
		"\1\2\u053f\u0547\3\2\2\2\u0540\u0547\7q\2\2\u0541\u0547\7r\2\2\u0542\u0543"+
		"\7\21\2\2\u0543\u0544\5b\62\2\u0544\u0545\7\22\2\2\u0545\u0547\3\2\2\2"+
		"\u0546\u0440\3\2\2\2\u0546\u0443\3\2\2\2\u0546\u0445\3\2\2\2\u0546\u0447"+
		"\3\2\2\2\u0546\u0449\3\2\2\2\u0546\u0450\3\2\2\2\u0546\u0457\3\2\2\2\u0546"+
		"\u045e\3\2\2\2\u0546\u0465\3\2\2\2\u0546\u046c\3\2\2\2\u0546\u0473\3\2"+
		"\2\2\u0546\u047a\3\2\2\2\u0546\u0482\3\2\2\2\u0546\u0487\3\2\2\2\u0546"+
		"\u0491\3\2\2\2\u0546\u049c\3\2\2\2\u0546\u049e\3\2\2\2\u0546\u04b9\3\2"+
		"\2\2\u0546\u04d4\3\2\2\2\u0546\u04ef\3\2\2\2\u0546\u050a\3\2\2\2\u0546"+
		"\u0525\3\2\2\2\u0546\u0540\3\2\2\2\u0546\u0541\3\2\2\2\u0546\u0542\3\2"+
		"\2\2\u0547\u0556\3\2\2\2\u0548\u0549\f\17\2\2\u0549\u054a\t\13\2\2\u054a"+
		"\u0555\5b\62\17\u054b\u054c\f\16\2\2\u054c\u054d\t\f\2\2\u054d\u0555\5"+
		"b\62\16\u054e\u054f\f\r\2\2\u054f\u0550\t\r\2\2\u0550\u0555\5b\62\r\u0551"+
		"\u0552\f\f\2\2\u0552\u0553\t\16\2\2\u0553\u0555\5b\62\f\u0554\u0548\3"+
		"\2\2\2\u0554\u054b\3\2\2\2\u0554\u054e\3\2\2\2\u0554\u0551\3\2\2\2\u0555"+
		"\u0558\3\2\2\2\u0556\u0554\3\2\2\2\u0556\u0557\3\2\2\2\u0557c\3\2\2\2"+
		"\u0558\u0556\3\2\2\2\u0559\u055a\b\63\1\2\u055a\u055b\7s\2\2\u055b\u057f"+
		"\5d\63\25\u055c\u055d\7t\2\2\u055d\u057f\5d\63\24\u055e\u055f\7\65\2\2"+
		"\u055f\u057f\5d\63\23\u0560\u0561\b\63\1\2\u0561\u0562\7\4\2\2\u0562\u0563"+
		"\5p9\2\u0563\u0564\7b\2\2\u0564\u0565\5b\62\2\u0565\u0566\7\6\2\2\u0566"+
		"\u0567\3\2\2\2\u0567\u0568\b\63\1\2\u0568\u057f\3\2\2\2\u0569\u056a\t"+
		"\r\2\2\u056a\u056b\5b\62\2\u056b\u056c\7y\2\2\u056c\u056d\5d\63\2\u056d"+
		"\u056e\7z\2\2\u056e\u056f\5d\63\n\u056f\u057f\3\2\2\2\u0570\u057f\7{\2"+
		"\2\u0571\u057f\7|\2\2\u0572\u057f\7}\2\2\u0573\u057f\7~\2\2\u0574\u0575"+
		"\7\21\2\2\u0575\u0576\5d\63\2\u0576\u0577\7\22\2\2\u0577\u057f\3\2\2\2"+
		"\u0578\u0579\6\63\6\2\u0579\u057a\5v<\2\u057a\u057b\b\63\1\2\u057b\u057f"+
		"\3\2\2\2\u057c\u057d\6\63\7\2\u057d\u057f\5t;\2\u057e\u0559\3\2\2\2\u057e"+
		"\u055c\3\2\2\2\u057e\u055e\3\2\2\2\u057e\u0560\3\2\2\2\u057e\u0569\3\2"+
		"\2\2\u057e\u0570\3\2\2\2\u057e\u0571\3\2\2\2\u057e\u0572\3\2\2\2\u057e"+
		"\u0573\3\2\2\2\u057e\u0574\3\2\2\2\u057e\u0578\3\2\2\2\u057e\u057c\3\2"+
		"\2\2\u057f\u059f\3\2\2\2\u0580\u0581\f\22\2\2\u0581\u0582\7\66\2\2\u0582"+
		"\u059e\5d\63\23\u0583\u0584\f\21\2\2\u0584\u0585\7I\2\2\u0585\u059e\5"+
		"d\63\22\u0586\u0587\f\20\2\2\u0587\u0588\7u\2\2\u0588\u059e\5d\63\21\u0589"+
		"\u058a\f\17\2\2\u058a\u058b\7v\2\2\u058b\u059e\5d\63\20\u058c\u058e\f"+
		"\r\2\2\u058d\u058f\t\17\2\2\u058e\u058d\3\2\2\2\u058e\u058f\3\2\2\2\u058f"+
		"\u0590\3\2\2\2\u0590\u0592\7e\2\2\u0591\u0593\t\17\2\2\u0592\u0591\3\2"+
		"\2\2\u0592\u0593\3\2\2\2\u0593\u0594\3\2\2\2\u0594\u059e\5d\63\r\u0595"+
		"\u0596\f\f\2\2\u0596\u0597\7x\2\2\u0597\u059e\5d\63\r\u0598\u0599\f\16"+
		"\2\2\u0599\u059a\7\r\2\2\u059a\u059b\5d\63\2\u059b\u059c\7\16\2\2\u059c"+
		"\u059e\3\2\2\2\u059d\u0580\3\2\2\2\u059d\u0583\3\2\2\2\u059d\u0586\3\2"+
		"\2\2\u059d\u0589\3\2\2\2\u059d\u058c\3\2\2\2\u059d\u0595\3\2\2\2\u059d"+
		"\u0598\3\2\2\2\u059e\u05a1\3\2\2\2\u059f\u059d\3\2\2\2\u059f\u05a0\3\2"+
		"\2\2\u05a0e\3\2\2\2\u05a1\u059f\3\2\2\2\u05a2\u05a3\b\64\1\2\u05a3\u05a4"+
		"\t\r\2\2\u05a4\u05a5\5b\62\2\u05a5\u05a6\7y\2\2\u05a6\u05a7\5f\64\2\u05a7"+
		"\u05a8\7z\2\2\u05a8\u05a9\5f\64\f\u05a9\u05b7\3\2\2\2\u05aa\u05ab\7a\2"+
		"\2\u05ab\u05b7\5d\63\2\u05ac\u05ad\7.\2\2\u05ad\u05b7\5d\63\2\u05ae\u05b0"+
		"\7u\2\2\u05af\u05ae\3\2\2\2\u05af\u05b0\3\2\2\2\u05b0\u05b1\3\2\2\2\u05b1"+
		"\u05b7\5x=\2\u05b2\u05b3\7\21\2\2\u05b3\u05b4\5f\64\2\u05b4\u05b5\7\22"+
		"\2\2\u05b5\u05b7\3\2\2\2\u05b6\u05a2\3\2\2\2\u05b6\u05aa\3\2\2\2\u05b6"+
		"\u05ac\3\2\2\2\u05b6\u05af\3\2\2\2\u05b6\u05b2\3\2\2\2\u05b7\u05c9\3\2"+
		"\2\2\u05b8\u05b9\f\t\2\2\u05b9\u05ba\t\20\2\2\u05ba\u05c8\5f\64\n\u05bb"+
		"\u05bc\f\b\2\2\u05bc\u05bd\t\21\2\2\u05bd\u05c8\5f\64\t\u05be\u05bf\f"+
		"\7\2\2\u05bf\u05c0\t\22\2\2\u05c0\u05c8\5f\64\b\u05c1\u05c2\f\6\2\2\u05c2"+
		"\u05c3\t\23\2\2\u05c3\u05c8\5f\64\7\u05c4\u05c5\f\5\2\2\u05c5\u05c6\t"+
		"\24\2\2\u05c6\u05c8\5f\64\6\u05c7\u05b8\3\2\2\2\u05c7\u05bb\3\2\2\2\u05c7"+
		"\u05be\3\2\2\2\u05c7\u05c1\3\2\2\2\u05c7\u05c4\3\2\2\2\u05c8\u05cb\3\2"+
		"\2\2\u05c9\u05c7\3\2\2\2\u05c9\u05ca\3\2\2\2\u05cag\3\2\2\2\u05cb\u05c9"+
		"\3\2\2\2\u05cc\u05d1\5j\66\2\u05cd\u05ce\7\5\2\2\u05ce\u05d0\5j\66\2\u05cf"+
		"\u05cd\3\2\2\2\u05d0\u05d3\3\2\2\2\u05d1\u05cf\3\2\2\2\u05d1\u05d2\3\2"+
		"\2\2\u05d2i\3\2\2\2\u05d3\u05d1\3\2\2\2\u05d4\u05d6\7\u0086\2\2\u05d5"+
		"\u05d4\3\2\2\2\u05d5\u05d6\3\2\2\2\u05d6\u05d7\3\2\2\2\u05d7\u05dc\5v"+
		"<\2\u05d8\u05d9\7\5\2\2\u05d9\u05db\5v<\2\u05da\u05d8\3\2\2\2\u05db\u05de"+
		"\3\2\2\2\u05dc\u05da\3\2\2\2\u05dc\u05dd\3\2\2\2\u05dd\u05df\3\2\2\2\u05de"+
		"\u05dc\3\2\2\2\u05df\u05e1\7\b\2\2\u05e0\u05e2\7Z\2\2\u05e1\u05e0\3\2"+
		"\2\2\u05e1\u05e2\3\2\2\2\u05e2\u05e3\3\2\2\2\u05e3\u05e4\5d\63\2\u05e4"+
		"\u05e5\b\66\1\2\u05e5\u0617\3\2\2\2\u05e6\u05e8\7\u0086\2\2\u05e7\u05e6"+
		"\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8\u05e9\3\2\2\2\u05e9\u05ee\5v<\2\u05ea"+
		"\u05eb\7\5\2\2\u05eb\u05ed\5v<\2\u05ec\u05ea\3\2\2\2\u05ed\u05f0\3\2\2"+
		"\2\u05ee\u05ec\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef\u05f1\3\2\2\2\u05f0\u05ee"+
		"\3\2\2\2\u05f1\u05f2\7\b\2\2\u05f2\u05f3\7Y\2\2\u05f3\u05f4\5d\63\2\u05f4"+
		"\u05f5\b\66\1\2\u05f5\u0617\3\2\2\2\u05f6\u05f8\7\u0086\2\2\u05f7\u05f6"+
		"\3\2\2\2\u05f7\u05f8\3\2\2\2\u05f8\u05f9\3\2\2\2\u05f9\u05fe\5v<\2\u05fa"+
		"\u05fb\7\5\2\2\u05fb\u05fd\5v<\2\u05fc\u05fa\3\2\2\2\u05fd\u0600\3\2\2"+
		"\2\u05fe\u05fc\3\2\2\2\u05fe\u05ff\3\2\2\2\u05ff\u0601\3\2\2\2\u0600\u05fe"+
		"\3\2\2\2\u0601\u0602\7\b\2\2\u0602\u0603\7[\2\2\u0603\u0604\5d\63\2\u0604"+
		"\u0605\b\66\1\2\u0605\u0617\3\2\2\2\u0606\u0608\7\u0086\2\2\u0607\u0606"+
		"\3\2\2\2\u0607\u0608\3\2\2\2\u0608\u0609\3\2\2\2\u0609\u060e\5v<\2\u060a"+
		"\u060b\7\5\2\2\u060b\u060d\5v<\2\u060c\u060a\3\2\2\2\u060d\u0610\3\2\2"+
		"\2\u060e\u060c\3\2\2\2\u060e\u060f\3\2\2\2\u060f\u0611\3\2\2\2\u0610\u060e"+
		"\3\2\2\2\u0611\u0612\7\b\2\2\u0612\u0613\7w\2\2\u0613\u0614\5d\63\2\u0614"+
		"\u0615\b\66\1\2\u0615\u0617\3\2\2\2\u0616\u05d5\3\2\2\2\u0616\u05e7\3"+
		"\2\2\2\u0616\u05f7\3\2\2\2\u0616\u0607\3\2\2\2\u0617k\3\2\2\2\u0618\u061d"+
		"\5n8\2\u0619\u061a\7\5\2\2\u061a\u061c\5n8\2\u061b\u0619\3\2\2\2\u061c"+
		"\u061f\3\2\2\2\u061d\u061b\3\2\2\2\u061d\u061e\3\2\2\2\u061em\3\2\2\2"+
		"\u061f\u061d\3\2\2\2\u0620\u0625\5v<\2\u0621\u0622\7\5\2\2\u0622\u0624"+
		"\5v<\2\u0623\u0621\3\2\2\2\u0624\u0627\3\2\2\2\u0625\u0623\3\2\2\2\u0625"+
		"\u0626\3\2\2\2\u0626\u0628\3\2\2\2\u0627\u0625\3\2\2\2\u0628\u0629\7\27"+
		"\2\2\u0629\u062a\5d\63\2\u062a\u062b\3\2\2\2\u062b\u062c\b8\1\2\u062c"+
		"o\3\2\2\2\u062d\u0632\5r:\2\u062e\u062f\7\5\2\2\u062f\u0631\5r:\2\u0630"+
		"\u062e\3\2\2\2\u0631\u0634\3\2\2\2\u0632\u0630\3\2\2\2\u0632\u0633\3\2"+
		"\2\2\u0633q\3\2\2\2\u0634\u0632\3\2\2\2\u0635\u0637\7\u0086\2\2\u0636"+
		"\u0635\3\2\2\2\u0636\u0637\3\2\2\2\u0637\u0638\3\2\2\2\u0638\u063d\5v"+
		"<\2\u0639\u063a\7\5\2\2\u063a\u063c\5v<\2\u063b\u0639\3\2\2\2\u063c\u063f"+
		"\3\2\2\2\u063d\u063b\3\2\2\2\u063d\u063e\3\2\2\2\u063e\u0640\3\2\2\2\u063f"+
		"\u063d\3\2\2\2\u0640\u0642\7\b\2\2\u0641\u0643\7Z\2\2\u0642\u0641\3\2"+
		"\2\2\u0642\u0643\3\2\2\2\u0643\u0644\3\2\2\2\u0644\u0645\5d\63\2\u0645"+
		"\u0646\3\2\2\2\u0646\u0647\b:\1\2\u0647s\3\2\2\2\u0648\u0649\7\u008b\2"+
		"\2\u0649u\3\2\2\2\u064a\u064b\7\u008b\2\2\u064bw\3\2\2\2\u064c\u064d\7"+
		"\u008a\2\2\u064dy\3\2\2\2\u064e\u0678\5|?\2\u064f\u0678\7\30\2\2\u0650"+
		"\u0678\7$\2\2\u0651\u0678\7L\2\2\u0652\u0678\7M\2\2\u0653\u0678\7\31\2"+
		"\2\u0654\u0678\7/\2\2\u0655\u0678\7;\2\2\u0656\u0678\7\u0087\2\2\u0657"+
		"\u0678\7T\2\2\u0658\u0678\7%\2\2\u0659\u0678\7C\2\2\u065a\u0678\7\u0088"+
		"\2\2\u065b\u0678\7\33\2\2\u065c\u0678\7&\2\2\u065d\u0678\7\24\2\2\u065e"+
		"\u0678\7S\2\2\u065f\u0678\7\32\2\2\u0660\u0678\7\62\2\2\u0661\u0678\7"+
		"\23\2\2\u0662\u0678\7\63\2\2\u0663\u0678\7\'\2\2\u0664\u0678\7\26\2\2"+
		"\u0665\u0678\7Q\2\2\u0666\u0678\7O\2\2\u0667\u0678\7:\2\2\u0668\u0678"+
		"\7-\2\2\u0669\u0678\7#\2\2\u066a\u0678\7F\2\2\u066b\u0678\7\u0089\2\2"+
		"\u066c\u0678\7\60\2\2\u066d\u0678\7\34\2\2\u066e\u0678\7\64\2\2\u066f"+
		"\u0678\7\37\2\2\u0670\u0678\7)\2\2\u0671\u0678\7+\2\2\u0672\u0678\7 \2"+
		"\2\u0673\u0678\7N\2\2\u0674\u0678\7D\2\2\u0675\u0678\7<\2\2\u0676\u0678"+
		"\7E\2\2\u0677\u064e\3\2\2\2\u0677\u064f\3\2\2\2\u0677\u0650\3\2\2\2\u0677"+
		"\u0651\3\2\2\2\u0677\u0652\3\2\2\2\u0677\u0653\3\2\2\2\u0677\u0654\3\2"+
		"\2\2\u0677\u0655\3\2\2\2\u0677\u0656\3\2\2\2\u0677\u0657\3\2\2\2\u0677"+
		"\u0658\3\2\2\2\u0677\u0659\3\2\2\2\u0677\u065a\3\2\2\2\u0677\u065b\3\2"+
		"\2\2\u0677\u065c\3\2\2\2\u0677\u065d\3\2\2\2\u0677\u065e\3\2\2\2\u0677"+
		"\u065f\3\2\2\2\u0677\u0660\3\2\2\2\u0677\u0661\3\2\2\2\u0677\u0662\3\2"+
		"\2\2\u0677\u0663\3\2\2\2\u0677\u0664\3\2\2\2\u0677\u0665\3\2\2\2\u0677"+
		"\u0666\3\2\2\2\u0677\u0667\3\2\2\2\u0677\u0668\3\2\2\2\u0677\u0669\3\2"+
		"\2\2\u0677\u066a\3\2\2\2\u0677\u066b\3\2\2\2\u0677\u066c\3\2\2\2\u0677"+
		"\u066d\3\2\2\2\u0677\u066e\3\2\2\2\u0677\u066f\3\2\2\2\u0677\u0670\3\2"+
		"\2\2\u0677\u0671\3\2\2\2\u0677\u0672\3\2\2\2\u0677\u0673\3\2\2\2\u0677"+
		"\u0674\3\2\2\2\u0677\u0675\3\2\2\2\u0677\u0676\3\2\2\2\u0678{\3\2\2\2"+
		"\u0679\u067a\7\u008b\2\2\u067a}\3\2\2\2\u067b\u067c\t\25\2\2\u067c\177"+
		"\3\2\2\2\u067d\u067e\7\u008a\2\2\u067e\u0081\3\2\2\2\u067f\u0681\7u\2"+
		"\2\u0680\u067f\3\2\2\2\u0680\u0681\3\2\2\2\u0681\u0682\3\2\2\2\u0682\u0683"+
		"\7\u008a\2\2\u0683\u0083\3\2\2\2\u00ed\u0085\u008e\u009b\u00ac\u00b5\u00c0"+
		"\u00c5\u00ce\u00d6\u00da\u00e0\u00ec\u00ef\u00f8\u00fb\u010a\u0112\u011d"+
		"\u0122\u0125\u0129\u012e\u0138\u013e\u0156\u0158\u015d\u016a\u016d\u0170"+
		"\u0174\u0179\u0181\u0184\u0188\u0195\u0197\u019c\u01a6\u01a9\u01ac\u01b0"+
		"\u01b3\u01b6\u01ba\u01bd\u01c4\u01c8\u01d3\u01d6\u01da\u01dd\u01e3\u01e8"+
		"\u01ed\u01f2\u01f5\u01fa\u01fd\u0200\u0204\u0207\u020a\u020e\u0211\u0218"+
		"\u021c\u0220\u022d\u0230\u0234\u0237\u0240\u0245\u024a\u024f\u0253\u0258"+
		"\u025b\u025f\u0262\u0265\u0269\u0273\u0276\u027c\u0284\u0287\u028e\u0291"+
		"\u0295\u0298\u02a1\u02a3\u02a8\u02ac\u02b2\u02b9\u02bc\u02c0\u02c3\u02c9"+
		"\u02ce\u02d4\u02d7\u02db\u02e0\u02e5\u02e7\u02ed\u02f1\u02f6\u02f9\u0300"+
		"\u0302\u0307\u030c\u0312\u0316\u031b\u031e\u0328\u032a\u032f\u0334\u0338"+
		"\u033f\u0345\u0349\u0352\u0357\u0362\u0364\u0369\u036c\u0370\u037a\u0388"+
		"\u0393\u039f\u03ab\u03ae\u03b2\u03b6\u03bd\u03c2\u03c9\u03cd\u03d6\u03db"+
		"\u03df\u03e3\u03e7\u03ea\u03f1\u03f3\u03f7\u03fb\u0402\u0404\u0408\u040c"+
		"\u0413\u0415\u0419\u041d\u0421\u0425\u0429\u042d\u0431\u0435\u043c\u044b"+
		"\u0452\u0459\u0460\u0467\u046e\u0475\u04a7\u04ab\u04b1\u04b5\u04c2\u04c6"+
		"\u04cc\u04d0\u04dd\u04e1\u04e7\u04eb\u04f8\u04fc\u0502\u0506\u0513\u0517"+
		"\u051d\u0521\u052e\u0532\u0538\u053c\u0546\u0554\u0556\u057e\u058e\u0592"+
		"\u059d\u059f\u05af\u05b6\u05c7\u05c9\u05d1\u05d5\u05dc\u05e1\u05e7\u05ee"+
		"\u05f7\u05fe\u0607\u060e\u0616\u061d\u0625\u0632\u0636\u063d\u0642\u0677"+
		"\u0680";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}