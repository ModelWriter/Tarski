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
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


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
		RULE_eTypeParameter = 30, RULE_typeRef = 31, RULE_typedRef = 32, RULE_typedTypeRef = 33, 
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
		"eModelElementRef", "templateSignature", "eTypeParameter", "typeRef", 
		"typedRef", "typedTypeRef", "wildcardTypeRef", "templateBinding", "templateParameterSubstitution", 
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

	public void saveResource(EPackage root){
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

	protected EPackage root;

	private final Stack<String> qName = new Stack<>();
	private final Stack<String> qPath = new Stack<>();

	private EcoreFactory eFactory = EcoreFactory.eINSTANCE;

	private String getContextText(ParserRuleContext ctx){
	    return getTokenStream().getTokenSource().getInputStream().toString().substring(ctx.start.getStartIndex(),ctx.stop.getStopIndex());
	}

	protected final Map<String, Element> qPathStore = new HashMap<>();
	protected final Map<String, String> qPathQNamePairs = new HashMap<>();

	protected void addNamedElement(String qualifiedName, String qualifiedPath, ENamedElement element, ParserRuleContext context, Token nameToken){
	    Element<ENamedElement> e = new Element<>(qualifiedName, qualifiedPath, element, context, nameToken);
	    qPathStore.put(qualifiedName, e);
	}

	protected Element getElementByQPath(String qualifiedPath){
	    return qPathStore.get(qualifiedPath);
	}

	protected Element getElementByQName(String qualifiedName){
	    String qPath = qPathQNamePairs.get(qualifiedName);
	    if (qPath == null) return null;
	    else return qPathStore.get(qPath);
	}

	protected void addModelElement(String qualifiedName, String qualifiedPath, EModelElement element, ParserRuleContext context){
	    Element<EModelElement> e = new Element<>(qualifiedName, qualifiedPath, element, context, context.start);
	    qPathStore.put(qualifiedName, e);
	}

	public class Element<E extends EModelElement>
	{
	    final E element;
	    final ParserRuleContext context;
	    final Token token;
	    final String qPath;
	    final String qName;

	    protected Element(String qPath, String qName, E element, ParserRuleContext context, Token nameToken) {
	        this.element = element;
	        this.context = context;
	        this.token = nameToken;
	        this.qPath = qPath;
	        this.qName = qName;
	        qPathQNamePairs.put(qPath, qName);
	    }
	}

	private void signalParsingCompletion() {
	    System.out.println("[NamedElement]");
	    System.out.println("Root Package is " + root);
	    //qPathStore.values().stream().filter(element -> element.element instanceof EPackage || element.element instanceof EClass).forEach(element -> parser.notifyErrorListeners(element.token, element.qName, null));
	    //qPathStore.values().forEach(element -> parser.notifyErrorListeners(element.token, element.qName, null));
	    //qPathQNamePairs.forEach((s1, s2) -> {System.out.println(s1); System.out.println(s2);} );
	    //importEcoreDataTypes();
	    //generateReferences();
	    qPathStore.values().forEach(element ->{
	        System.out.println("qPath\t[" + element.qPath + "]");
	        System.out.println("qName\t[" + element.qName + "]");
	        System.out.println("URI\t\t[" + EcoreUtil.getURI(element.element) + "]");
	        System.out.println();
	    });
	}

	private EAnnotation createEAnnotation(EModelElement owner, final String source) {
	    final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
	    eAnnotation.setSource(source);
	    owner.getEAnnotations().add(eAnnotation);
	    return eAnnotation;
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
		public EPackageContext ePackage;
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


			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(292);
				match(T__16);
				setState(293);
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

			setState(304);
			((ModuleContext)_localctx).ownedPackage = ((ModuleContext)_localctx).ePackage = ePackage(0);
			root=((ModuleContext)_localctx).ePackage.element; signalParsingCompletion(); saveResource(((ModuleContext)_localctx).ownedPackage.element);
			}
			_ctx.stop = _input.LT(-1);
		}
		catch (RecognitionException re) {
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
			setState(307);
			match(T__17);
			}
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(308);
				((PackageImportContext)_localctx).name = identifier();
				setState(309);
				match(T__5);
				}
			}

			setState(313);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(314);
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
		public int path;
		public EPackage element;
		public int anno = 0;
		public int pack = 0;
		public int clas;
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
		public EPackageContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EPackageContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EPackageContext ePackage(int path) throws RecognitionException {
		EPackageContext _localctx = new EPackageContext(_ctx, getState(), path);
		enterRule(_localctx, 20, RULE_ePackage);
		((EPackageContext)_localctx).element =  eFactory.createEPackage();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(316);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EPackageContext)_localctx).visibility.element);
			setState(320);
			match(T__19);
			setState(321);
			((EPackageContext)_localctx).name = unrestrictedName();
			qName.push(qName.empty() ? (((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null) : qName.peek() + "." + (((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null) ); _localctx.element.setName((((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null));
			qPath.push(qPath.empty() ? ("/package." + _localctx.path) : (qPath.peek() + "/package." + _localctx.path) );
			{
			setState(324);
			match(T__5);
			setState(325);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(327);
			match(T__20);
			setState(328);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			_localctx.element.setNsPrefix((((EPackageContext)_localctx).nsPrefix!=null?_input.getText(((EPackageContext)_localctx).nsPrefix.start,((EPackageContext)_localctx).nsPrefix.stop):null)); _localctx.element.setNsURI((((EPackageContext)_localctx).nsURI!=null?((EPackageContext)_localctx).nsURI.getText():null));
			setState(351);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(331);
				match(T__1);
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__30) | (1L << T__31) | (1L << T__55) | (1L << T__56))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__66 - 65)) | (1L << (T__74 - 65)) | (1L << (T__75 - 65)) | (1L << (T__82 - 65)) | (1L << (T__83 - 65)) | (1L << (T__84 - 65)))) != 0)) {
					{
					setState(344);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(332);
						((EPackageContext)_localctx).eAnnotation = ((EPackageContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(335);
						((EPackageContext)_localctx).ePackage = ((EPackageContext)_localctx).ePackage = ePackage(_localctx.pack++);
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						_localctx.element.getESubpackages().add(((EPackageContext)_localctx).ePackage.element);
						}
						break;
					case 3:
						{
						setState(338);
						((EPackageContext)_localctx).eClassifier = ((EPackageContext)_localctx).eClassifier = eClassifier(_localctx.clas);
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						_localctx.element.getEClassifiers().add(((EPackageContext)_localctx).eClassifier.element);
						}
						break;
					case 4:
						{
						setState(341);
						((EPackageContext)_localctx).invariant = ((EPackageContext)_localctx).invariant = invariant();
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(348);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(349);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(350);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			addNamedElement(qPath.peek(), qName.peek(), _localctx.element, _localctx, _localctx.name.start);
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(Console.BLUE + qName.peek() + " (Package)" + Console.RESET); qName.pop();System.out.println(Console.BLUE + qPath.peek() + " (Package)" + Console.RESET); qPath.pop();
		}
		catch (RecognitionException re) {
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
		public int path;
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
		public EClassifierContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EClassifierContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EClassifierContext eClassifier(int path) throws RecognitionException {
		EClassifierContext _localctx = new EClassifierContext(_ctx, getState(), path);
		enterRule(_localctx, 22, RULE_eClassifier);
		try {
			setState(364);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				((EClassifierContext)_localctx).eClass = eClass(_localctx.path);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eClass.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(358);
				((EClassifierContext)_localctx).eDataType = eDataType(_localctx.path);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eDataType.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(361);
				((EClassifierContext)_localctx).eEnum = eEnum(_localctx.path);
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
		public int path;
		public EClass element;
		public int anno = 0;
		public int feat = 0;
		public int oper = 0;
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
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
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
		public EClassContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EClassContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EClassContext eClass(int path) throws RecognitionException {
		EClassContext _localctx = new EClassContext(_ctx, getState(), path);
		enterRule(_localctx, 24, RULE_eClass);
		((EClassContext)_localctx).element =  eFactory.createEClass();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(366);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).visibility.element);
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				{
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(370);
					((EClassContext)_localctx).isAbstract = match(T__21);
					}
				}

				setState(373);
				((EClassContext)_localctx).isClass = match(T__22);
				}
				break;
			case T__23:
				{
				setState(374);
				((EClassContext)_localctx).isInterface = match(T__23);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.element.setAbstract(((EClassContext)_localctx).isAbstract!=null); if (((EClassContext)_localctx).isInterface!=null) {_localctx.element.setInterface(true);_localctx.element.setAbstract(true);}
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(378);
				((EClassContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			if (_localctx.name == null) {notifyErrorListeners("missing Class name"); qName.push(qName.peek() + "." + "class" + _localctx.path );} else {_localctx.element.setName((((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null)); qName.push(qName.peek() + "." + (((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null) );}
			qPath.push(qPath.peek() + "/classifier." + _localctx.path);
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(383);
				((EClassContext)_localctx).ownedSignature = templateSignature();
				}
			}


			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(387);
				match(T__24);
				setState(388);
				((EClassContext)_localctx).typedRef = typedRef();
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).typedRef);
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(389);
					match(T__2);
					setState(390);
					((EClassContext)_localctx).typedRef = typedRef();
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).typedRef);
					}
					}
					setState(395);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(399);
				match(T__5);
				setState(400);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EClassContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EClassContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(424);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(404);
				match(T__1);
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & ((1L << (T__25 - 26)) | (1L << (T__26 - 26)) | (1L << (T__27 - 26)) | (1L << (T__28 - 26)) | (1L << (T__29 - 26)) | (1L << (T__30 - 26)) | (1L << (T__31 - 26)) | (1L << (T__32 - 26)) | (1L << (T__33 - 26)) | (1L << (T__42 - 26)) | (1L << (T__48 - 26)) | (1L << (T__66 - 26)) | (1L << (T__74 - 26)) | (1L << (T__75 - 26)) | (1L << (T__82 - 26)) | (1L << (T__83 - 26)) | (1L << (T__84 - 26)))) != 0)) {
					{
					setState(417);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						setState(405);
						((EClassContext)_localctx).eAnnotation = ((EClassContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(408);
						((EClassContext)_localctx).eOperation = ((EClassContext)_localctx).eOperation = eOperation(_localctx.oper++);
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						_localctx.element.getEOperations().add(((EClassContext)_localctx).eOperation.element);
						}
						break;
					case 3:
						{
						setState(411);
						((EClassContext)_localctx).eStructuralFeature = ((EClassContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.feat++);
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						_localctx.element.getEStructuralFeatures().add(((EClassContext)_localctx).eStructuralFeature.element);
						}
						break;
					case 4:
						{
						setState(414);
						((EClassContext)_localctx).invariant = ((EClassContext)_localctx).invariant = invariant();
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(421);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(422);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(423);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			addNamedElement(qPath.peek(), qName.peek(), _localctx.element, _localctx, _localctx.name != null ? _localctx.name.start : _localctx.isClass != null ? _localctx.isClass : _localctx.isInterface );
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(Console.GREEN + qName.peek() + " (Class)" + Console.RESET); qName.pop();System.out.println(Console.GREEN + qPath.peek() + " (Class)" + Console.RESET); qPath.pop();
		}
		catch (RecognitionException re) {
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
		public int path;
		public EStructuralFeature element;
		public EAttributeContext eAttribute;
		public EReferenceContext eReference;
		public EAttributeContext eAttribute() {
			return getRuleContext(EAttributeContext.class,0);
		}
		public EReferenceContext eReference() {
			return getRuleContext(EReferenceContext.class,0);
		}
		public EStructuralFeatureContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EStructuralFeatureContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EStructuralFeatureContext eStructuralFeature(int path) throws RecognitionException {
		EStructuralFeatureContext _localctx = new EStructuralFeatureContext(_ctx, getState(), path);
		enterRule(_localctx, 26, RULE_eStructuralFeature);
		try {
			setState(434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				((EStructuralFeatureContext)_localctx).eAttribute = eAttribute(_localctx.path);
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eAttribute.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				((EStructuralFeatureContext)_localctx).eReference = eReference(_localctx.path);
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
		public int path;
		public EAttribute element;
		public int anno = 0;
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
		public DerivationContext derivation;
		public InitialContext ownedInitial;
		public InitialContext initial;
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
		public EAttributeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EAttributeContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EAttributeContext eAttribute(int path) throws RecognitionException {
		EAttributeContext _localctx = new EAttributeContext(_ctx, getState(), path);
		enterRule(_localctx, 28, RULE_eAttribute);
		((EAttributeContext)_localctx).element =  eFactory.createEAttribute();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(436);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).visibility.element);
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(440);
				((EAttributeContext)_localctx).s26 = match(T__25);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
				}
			}

			setState(445);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(443);
				((EAttributeContext)_localctx).s27 = match(T__26);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(444);
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
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(447);
				((EAttributeContext)_localctx).s29 = match(T__28);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
				}
			}

			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(450);
				((EAttributeContext)_localctx).s30 = match(T__29);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
				}
			}

			setState(455);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(453);
				((EAttributeContext)_localctx).s31 = match(T__30);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(454);
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
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(457);
				((EAttributeContext)_localctx).s33 = match(T__32);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s33);
				}
			}

			setState(460);
			match(T__33);
			setState(461);
			((EAttributeContext)_localctx).name = unrestrictedName();
			qName.push(qName.peek() + "::" + (((EAttributeContext)_localctx).name!=null?_input.getText(((EAttributeContext)_localctx).name.start,((EAttributeContext)_localctx).name.stop):null) ); _localctx.element.setName((((EAttributeContext)_localctx).name!=null?_input.getText(((EAttributeContext)_localctx).name.start,((EAttributeContext)_localctx).name.stop):null));
			qPath.push(qPath.peek() + "/feature." + _localctx.path);
			{
			setState(464);
			match(T__5);
			setState(465);
			((EAttributeContext)_localctx).eAttributeType = typedRef();
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(466);
				((EAttributeContext)_localctx).ownedMultiplicity = eMultiplicity((ETypedElement)_localctx.element);
				}
			}

			}

			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(470);
				match(T__20);
				setState(471);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EAttributeContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EAttributeContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(494);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(475);
				match(T__1);
				setState(489); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(484);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__34:
						{
						setState(476);
						((EAttributeContext)_localctx).s35 = match(T__34);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(477);
						((EAttributeContext)_localctx).s36 = match(T__35);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(478);
						((EAttributeContext)_localctx).s37 = match(T__36);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(479);
						((EAttributeContext)_localctx).s38 = match(T__37);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(480);
						((EAttributeContext)_localctx).s39 = match(T__38);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(481);
						((EAttributeContext)_localctx).s40 = match(T__39);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(482);
						((EAttributeContext)_localctx).s41 = match(T__40);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(483);
						((EAttributeContext)_localctx).s42 = match(T__41);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(487);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(486);
						match(T__2);
						}
					}

					}
					}
					setState(491); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0) );
				setState(493);
				match(T__3);
				}
				break;
			}
			setState(523);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(496);
				match(T__1);
				{
				setState(502);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(497);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(504);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				}
				setState(511);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__81:
					{
					setState(505);
					((EAttributeContext)_localctx).ownedDerivation = ((EAttributeContext)_localctx).derivation = derivation();
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).derivation.element);
					}
					break;
				case T__80:
					{
					setState(508);
					((EAttributeContext)_localctx).ownedInitial = ((EAttributeContext)_localctx).initial = initial();
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__66:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(518);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(513);
					((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
					((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
					}
					}
					setState(520);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(521);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(522);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			addNamedElement(qPath.peek(), qName.peek(), _localctx.element, _localctx, _localctx.name.start);
			for(String s: ((EAttributeContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "static":     createEAnnotation(_localctx.element, AnnotationSources.STATIC); break;
			            case "model":      createEAnnotation(_localctx.element, AnnotationSources.MODEL); break;
			            case "ghost":      createEAnnotation(_localctx.element, AnnotationSources.GHOST); break;
			            case "transient":  _localctx.element.setTransient(true); break;
			            case "volatile":   _localctx.element.setVolatile(true); break;
			            case "nullable":   createEAnnotation(_localctx.element, AnnotationSources.NULLABLE); break;
			            case "readonly":   _localctx.element.setChangeable(true); break;
			            case "derived":    _localctx.element.setDerived(true); break;
			            case "ordered":    _localctx.element.setOrdered(true); break;
			            case "!unique":    _localctx.element.setUnique(false); break;
			            case "unsettable": _localctx.element.setUnsettable(true); break;
			            case "id":         _localctx.element.setID(true); break;}}
			    
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(qName.peek() + " (Attribute)"); qName.pop();System.out.println(qPath.peek() + " (Attribute)"); qPath.pop();
		}
		catch (RecognitionException re) {
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
		public int path;
		public EReference element;
		public int anno = 0;
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
		public DerivationContext derivation;
		public InitialContext ownedInitial;
		public InitialContext initial;
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
		public EReferenceContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EReferenceContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EReferenceContext eReference(int path) throws RecognitionException {
		EReferenceContext _localctx = new EReferenceContext(_ctx, getState(), path);
		enterRule(_localctx, 30, RULE_eReference);
		((EReferenceContext)_localctx).element =  eFactory.createEReference();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(528);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).visibility.element);
			setState(533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(532);
				((EReferenceContext)_localctx).s26 = match(T__25);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
				}
			}

			setState(537);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(535);
				((EReferenceContext)_localctx).s27 = match(T__26);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(536);
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
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(539);
				((EReferenceContext)_localctx).s29 = match(T__28);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
				}
			}

			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(542);
				((EReferenceContext)_localctx).s30 = match(T__29);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
				}
			}

			setState(547);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(545);
				((EReferenceContext)_localctx).s31 = match(T__30);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(546);
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
			setState(550);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(549);
				((EReferenceContext)_localctx).s33 = match(T__32);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s33);
				}
			}

			setState(552);
			match(T__42);
			setState(553);
			((EReferenceContext)_localctx).name = unrestrictedName();
			qName.push(qName.peek() + "::" + (((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null) ); _localctx.element.setName((((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null));
			qPath.push(qPath.peek() + "/feature." + _localctx.path);
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__43) {
				{
				setState(556);
				match(T__43);
				setState(557);
				((EReferenceContext)_localctx).eOpposite = unrestrictedName();
				}
			}


			{
			setState(561);
			match(T__5);
			setState(562);
			((EReferenceContext)_localctx).eReferenceType = typedRef();
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(563);
				((EReferenceContext)_localctx).ownedMultiplicity = eMultiplicity((ETypedElement) _localctx.element);
				}
			}

			}

			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(567);
				match(T__20);
				setState(568);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EReferenceContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EReferenceContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(593);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(572);
				match(T__1);
				setState(588); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(583);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__44:
						{
						setState(573);
						((EReferenceContext)_localctx).s45 = match(T__44);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s45);
						}
						break;
					case T__34:
						{
						setState(574);
						((EReferenceContext)_localctx).s35 = match(T__34);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s35);
						}
						break;
					case T__36:
						{
						setState(575);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(576);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(577);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(578);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					case T__45:
						{
						setState(579);
						((EReferenceContext)_localctx).s46 = match(T__45);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s46);
						}
						break;
					case T__46:
						{
						setState(580);
						((EReferenceContext)_localctx).s47 = match(T__46);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s47);
						}
						break;
					case T__40:
						{
						setState(581);
						((EReferenceContext)_localctx).s41 = match(T__40);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s41);
						}
						break;
					case T__41:
						{
						setState(582);
						((EReferenceContext)_localctx).s42 = match(T__41);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s42);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(586);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(585);
						match(T__2);
						}
					}

					}
					}
					setState(590); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0) );
				setState(592);
				match(T__3);
				}
				break;
			}
			setState(635);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(595);
				match(T__1);
				setState(607);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__47) {
					{
					setState(596);
					match(T__47);
					setState(597);
					((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
					setState(602);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(598);
						match(T__2);
						setState(599);
						((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
						}
						}
						setState(604);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(605);
					match(T__18);
					}
				}

				{
				setState(614);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(609);
						((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(616);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
				}
				setState(623);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__81:
					{
					setState(617);
					((EReferenceContext)_localctx).ownedDerivation = ((EReferenceContext)_localctx).derivation = derivation();
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).derivation.element);
					}
					break;
				case T__80:
					{
					setState(620);
					((EReferenceContext)_localctx).ownedInitial = ((EReferenceContext)_localctx).initial = initial();
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__66:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(625);
					((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
					((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
					}
					}
					setState(632);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(633);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(634);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			addNamedElement(qPath.peek(), qName.peek(), _localctx.element, _localctx, _localctx.name.start);
			for(String s: ((EReferenceContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "static":    createEAnnotation(_localctx.element, AnnotationSources.STATIC); break;
			            case "model":     createEAnnotation(_localctx.element, AnnotationSources.MODEL); break;
			            case "ghost":     createEAnnotation(_localctx.element, AnnotationSources.GHOST); break;
			            case "transient": _localctx.element.setTransient(true); break;
			            case "volatile":  _localctx.element.setVolatile(true); break;
			            case "nullable":  createEAnnotation(_localctx.element, AnnotationSources.NULLABLE); break;
			            case "readonly":  _localctx.element.setChangeable(true); break;
			            case "derived":   _localctx.element.setDerived(true); break;
			            case "ordered":   _localctx.element.setOrdered(true); break;
			            case "!unique":   _localctx.element.setUnique(false); break;
			            case "composes":  _localctx.element.setContainment(true); break;
			            case "resolve":   _localctx.element.setResolveProxies(true); break;}}
			    
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(qName.peek() + " (Reference)"); qName.pop();System.out.println(qPath.peek() + " (Reference)"); qPath.pop();
		}
		catch (RecognitionException re) {
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
		public int path;
		public EOperation element;
		public int anno = 0;
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
		public EOperationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EOperationContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EOperationContext eOperation(int path) throws RecognitionException {
		EOperationContext _localctx = new EOperationContext(_ctx, getState(), path);
		enterRule(_localctx, 32, RULE_eOperation);
		((EOperationContext)_localctx).element =  eFactory.createEOperation();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(640);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EOperationContext)_localctx).visibility.element);
			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(644);
				((EOperationContext)_localctx).s26 = match(T__25);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
				}
			}

			setState(647);
			match(T__48);
			setState(649);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(648);
				((EOperationContext)_localctx).ownedSignature = templateSignature();
				}
			}


			setState(652);
			((EOperationContext)_localctx).name = unrestrictedName();
			qName.push(qName.peek() + "->" + (((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null) ); _localctx.element.setName((((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null));
			qPath.push(qPath.peek() + "/operation." + _localctx.path);
			setState(655);
			match(T__14);
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__26 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__30 - 17)) | (1L << (T__31 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__73 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)) | (1L << (T__76 - 17)) | (1L << (T__78 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__132 - 81)) | (1L << (T__133 - 81)) | (1L << (T__134 - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
				{
				setState(656);
				((EOperationContext)_localctx).eParameter = eParameter(path++);
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(661);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(657);
					match(T__2);
					setState(658);
					((EOperationContext)_localctx).eParameter = eParameter(path++);
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(663);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(666);
			match(T__15);
			for (EParameterContext ctx: ((EOperationContext)_localctx).eParameters){_localctx.element.getEParameters().add(ctx.element);}
			setState(673);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(668);
				match(T__5);
				setState(669);
				((EOperationContext)_localctx).eReturnType = typedRef();
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(670);
					((EOperationContext)_localctx).ownedMultiplicity = eMultiplicity((ETypedElement) _localctx.element);
					}
				}

				}
			}

			 
			setState(685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__49) {
				{
				setState(676);
				match(T__49);
				setState(677);
				((EOperationContext)_localctx).typedRef = typedRef();
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).typedRef);
				setState(682);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(678);
					match(T__2);
					setState(679);
					((EOperationContext)_localctx).typedRef = typedRef();
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).typedRef);
					}
					}
					setState(684);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 
			setState(703);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(688);
				match(T__1);
				setState(698); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(693);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(689);
						((EOperationContext)_localctx).s37 = match(T__36);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(690);
						((EOperationContext)_localctx).s38 = match(T__37);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(691);
						((EOperationContext)_localctx).s39 = match(T__38);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(692);
						((EOperationContext)_localctx).s40 = match(T__39);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s40);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(696);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(695);
						match(T__2);
						}
					}

					}
					}
					setState(700); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(702);
				match(T__3);
				}
				break;
			}
			setState(725);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(705);
				match(T__1);
				setState(720);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__73 - 67)) | (1L << (T__76 - 67)) | (1L << (T__77 - 67)) | (1L << (T__78 - 67)) | (1L << (T__79 - 67)))) != 0)) {
					{
					setState(718);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(706);
						((EOperationContext)_localctx).eAnnotation = ((EOperationContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).eAnnotation.element);
						}
						break;
					case T__76:
					case T__77:
						{
						setState(709);
						((EOperationContext)_localctx).precondition = ((EOperationContext)_localctx).precondition = precondition();
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).precondition.element);
						}
						break;
					case T__73:
						{
						setState(712);
						((EOperationContext)_localctx).body = ((EOperationContext)_localctx).body = body();
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).body.element);
						}
						break;
					case T__78:
					case T__79:
						{
						setState(715);
						((EOperationContext)_localctx).postcondition = ((EOperationContext)_localctx).postcondition = postcondition();
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).postcondition.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(722);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(723);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(724);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			addNamedElement(qPath.peek(), qName.peek(), _localctx.element, _localctx, _localctx.name.start);
			for(String s: ((EOperationContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "static":   createEAnnotation(_localctx.element, AnnotationSources.STATIC); break;
			            case "nullable": createEAnnotation(_localctx.element, AnnotationSources.NULLABLE); break;
			            case "ordered":  _localctx.element.setOrdered(true); break;
			            case "!unique":  _localctx.element.setUnique(false); break;}}
			    
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(qName.peek() + " (Operation)"); qName.pop();System.out.println(qPath.peek() + " (Operation)"); qPath.pop();
		}
		catch (RecognitionException re) {
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
		public int path;
		public EParameter element;
		public int anno = 0;
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
		public EParameterContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EParameterContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EParameterContext eParameter(int path) throws RecognitionException {
		EParameterContext _localctx = new EParameterContext(_ctx, getState(), path);
		enterRule(_localctx, 34, RULE_eParameter);
		((EParameterContext)_localctx).element =  eFactory.createEParameter();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(730);
				((EParameterContext)_localctx).s31 = match(T__30);
				((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s31);
				}
				break;
			case T__31:
				{
				setState(731);
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
			case T__26:
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
			setState(734);
			((EParameterContext)_localctx).name = unrestrictedName();
			qName.push(qName.peek() + "::" + (((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null) ); _localctx.element.setName((((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null));
			qPath.push(qPath.peek() + "/parameter." + _localctx.path);
			{
			setState(737);
			match(T__5);
			setState(738);
			((EParameterContext)_localctx).eParameterType = typedRef();
			setState(740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(739);
				((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity((ETypedElement) _localctx.element);
				}
			}

			}
			 
			setState(758);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				{
				setState(743);
				match(T__1);
				setState(753); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(748);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(744);
						((EParameterContext)_localctx).s37 = match(T__36);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(745);
						((EParameterContext)_localctx).s38 = match(T__37);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(746);
						((EParameterContext)_localctx).s39 = match(T__38);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(747);
						((EParameterContext)_localctx).s40 = match(T__39);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s40);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(751);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(750);
						match(T__2);
						}
					}

					}
					}
					setState(755); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(757);
				match(T__3);
				}
				break;
			}
			setState(769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(760);
				match(T__1);
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(761);
					((EParameterContext)_localctx).eAnnotation = ((EParameterContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(766);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EParameterContext)_localctx).eAnnotation.element);
				setState(768);
				match(T__3);
				}
			}

			addNamedElement(qPath.peek(), qName.peek(), _localctx.element, _localctx, _localctx.name.start);
			for(String s: ((EParameterContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "nullable": createEAnnotation(_localctx.element, AnnotationSources.NULLABLE);break;
			            case "ordered":  _localctx.element.setOrdered(true);break;
			            case "!unique":  _localctx.element.setUnique(false);break;}}
				
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(qName.peek() + " (Parameter)"); qName.pop(); System.out.println(qPath.peek() + " (Parameter)"); qPath.pop();
		}
		catch (RecognitionException re) {
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
		public ETypedElement element;
		public int l = 0;
		public int u = 1;
		public LowerContext lowerBound;
		public UpperContext upperBound;
		public Token stringBound;
		public Token isNullFree;
		public LowerContext lower() {
			return getRuleContext(LowerContext.class,0);
		}
		public UpperContext upper() {
			return getRuleContext(UpperContext.class,0);
		}
		public EMultiplicityContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EMultiplicityContext(ParserRuleContext parent, int invokingState, ETypedElement element) {
			super(parent, invokingState);
			this.element = element;
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

	public final EMultiplicityContext eMultiplicity(ETypedElement element) throws RecognitionException {
		EMultiplicityContext _localctx = new EMultiplicityContext(_ctx, getState(), element);
		enterRule(_localctx, 36, RULE_eMultiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
			match(T__10);
			setState(781);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(775);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(776);
					match(T__13);
					setState(777);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__50:
			case T__51:
			case T__52:
				{
				setState(780);
				((EMultiplicityContext)_localctx).stringBound = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__50) | (1L << T__51) | (1L << T__52))) != 0)) ) {
					((EMultiplicityContext)_localctx).stringBound = (Token)_errHandler.recoverInline(this);
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
			setState(785);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__53:
				{
				setState(783);
				match(T__53);
				}
				break;
			case T__54:
				{
				setState(784);
				((EMultiplicityContext)_localctx).isNullFree = match(T__54);
				}
				break;
			case T__11:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(787);
			match(T__11);

				if (_localctx.stringBound != null) {
				    switch (_localctx.stringBound.getText()) {
			            case "*": ((EMultiplicityContext)_localctx).l =  0; ((EMultiplicityContext)_localctx).u =  -1; break;
			            case "+": ((EMultiplicityContext)_localctx).l =  1; ((EMultiplicityContext)_localctx).u =  -1; break;
			            case "?": ((EMultiplicityContext)_localctx).l =  0; ((EMultiplicityContext)_localctx).u =   1; break;
			            default: break;
			        }
			    } else {
			        ((EMultiplicityContext)_localctx).l =  Integer.valueOf((((EMultiplicityContext)_localctx).lowerBound!=null?_input.getText(((EMultiplicityContext)_localctx).lowerBound.start,((EMultiplicityContext)_localctx).lowerBound.stop):null));
			        if (_localctx.upperBound != null) {
			            ((EMultiplicityContext)_localctx).u =  Integer.valueOf((((EMultiplicityContext)_localctx).upperBound!=null?_input.getText(((EMultiplicityContext)_localctx).upperBound.start,((EMultiplicityContext)_localctx).upperBound.stop):null));
			        } else { ((EMultiplicityContext)_localctx).u =  _localctx.l;}
			    }
				
			}
			_ctx.stop = _input.LT(-1);
			_localctx.element.setLowerBound(_localctx.l); _localctx.element.setUpperBound(_localctx.u);
		}
		catch (RecognitionException re) {
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
		public int path;
		public EDataType element;
		public int anno = 0;
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
		public EDataTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EDataTypeContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EDataTypeContext eDataType(int path) throws RecognitionException {
		EDataTypeContext _localctx = new EDataTypeContext(_ctx, getState(), path);
		enterRule(_localctx, 38, RULE_eDataType);
		((EDataTypeContext)_localctx).element =  eFactory.createEDataType();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(790);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).visibility.element);
			setState(799);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__55:
				{
				setState(794);
				((EDataTypeContext)_localctx).s56 = match(T__55);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s56);
				}
				break;
			case T__30:
			case T__31:
				{
				setState(797);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__30:
					{
					setState(795);
					((EDataTypeContext)_localctx).s31 = match(T__30);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s31);
					}
					break;
				case T__31:
					{
					setState(796);
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
			setState(801);
			match(T__56);
			setState(802);
			((EDataTypeContext)_localctx).name = unrestrictedName();
			qName.push(qName.peek() + "." + (((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null) ); _localctx.element.setName((((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null));
			qPath.push(qPath.peek() + "/classifier." + _localctx.path);
			setState(806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(805);
				((EDataTypeContext)_localctx).ownedSignature = templateSignature();
				}
			}

			 
			setState(811);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(809);
				match(T__5);
				setState(810);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EDataTypeContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EDataTypeContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(820);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				setState(814);
				match(T__1);
				setState(817);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(815);
					((EDataTypeContext)_localctx).s58 = match(T__57);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s58);
					}
					break;
				case T__58:
					{
					setState(816);
					((EDataTypeContext)_localctx).s59 = match(T__58);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s59);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(819);
				match(T__3);
				}
				break;
			}
			setState(836);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(822);
				match(T__1);
				setState(831);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__74 - 67)) | (1L << (T__75 - 67)))) != 0)) {
					{
					setState(829);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(823);
						((EDataTypeContext)_localctx).eAnnotation = ((EDataTypeContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).eAnnotation.element);
						}
						break;
					case T__74:
					case T__75:
						{
						setState(826);
						((EDataTypeContext)_localctx).invariant = ((EDataTypeContext)_localctx).invariant = invariant();
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).invariant.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(833);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(834);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(835);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			addNamedElement(qPath.peek(), qName.peek(), _localctx.element, _localctx, _localctx.name.start);
			for(String s: ((EDataTypeContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "primitive":     createEAnnotation(_localctx.element, AnnotationSources.DATATYPE_PRIMITIVE);break;
			            case "nullable":      createEAnnotation(_localctx.element, AnnotationSources.NULLABLE); break;
			            case "!serializable": _localctx.element.setSerializable(false); break; }}
			    
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(Console.GREEN + qName.peek() + " (Datatype)" + Console.RESET); qName.pop(); System.out.println(Console.GREEN + qPath.peek() + " (Datatype)" + Console.RESET); qPath.pop();
		}
		catch (RecognitionException re) {
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
			setState(841);
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
		public int path;
		public EEnum element;
		public int anno = 0;
		public int lite = 0;
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
		public EEnumContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EEnumContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EEnumContext eEnum(int path) throws RecognitionException {
		EEnumContext _localctx = new EEnumContext(_ctx, getState(), path);
		enterRule(_localctx, 42, RULE_eEnum);
		((EEnumContext)_localctx).element =  eFactory.createEEnum();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(843);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EEnumContext)_localctx).visibility.element);
			setState(847);
			match(T__64);
			setState(848);
			((EEnumContext)_localctx).name = unrestrictedName();
			qName.push(qName.peek() + "." + (((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null) ); _localctx.element.setName((((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null));
			qPath.push(qPath.peek() + "/classifier." + _localctx.path);
			setState(852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(851);
				((EEnumContext)_localctx).ownedSignature = templateSignature();
				}
			}


			setState(857);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(855);
				match(T__5);
				setState(856);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EEnumContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EEnumContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(866);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				{
				setState(860);
				match(T__1);
				setState(863);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(861);
					((EEnumContext)_localctx).s58 = match(T__57);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s58);
					}
					break;
				case T__58:
					{
					setState(862);
					((EEnumContext)_localctx).s59 = match(T__58);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s59);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(865);
				match(T__3);
				}
				break;
			}
			setState(885);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(868);
				match(T__1);
				setState(880);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__26 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__73 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)) | (1L << (T__76 - 17)) | (1L << (T__78 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__132 - 81)) | (1L << (T__133 - 81)) | (1L << (T__134 - 81)) | (1L << (IDENTIFIER - 81)))) != 0)) {
					{
					setState(878);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
					case 1:
						{
						setState(869);
						((EEnumContext)_localctx).eAnnotation = ((EEnumContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(872);
						((EEnumContext)_localctx).eEnumLiteral = ((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.lite++);
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						_localctx.element.getELiterals().add(((EEnumContext)_localctx).eEnumLiteral.element);
						}
						break;
					case 3:
						{
						setState(875);
						((EEnumContext)_localctx).invariant = ((EEnumContext)_localctx).invariant = invariant();
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(882);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(883);
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
			addNamedElement(qPath.peek(), qName.peek(), _localctx.element, _localctx, _localctx.name.start);
			for(String s: ((EEnumContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "!serializable": _localctx.element.setSerializable(false); break;}}
			    
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(Console.GREEN + qName.peek() + " (Enum)" + Console.RESET); qName.pop(); System.out.println(Console.GREEN + qPath.peek() + " (Enum)" + Console.RESET); qPath.pop();
		}
		catch (RecognitionException re) {
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
		public int path;
		public EEnumLiteral element;
		public int anno = 0;
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
		public EEnumLiteralContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EEnumLiteralContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EEnumLiteralContext eEnumLiteral(int path) throws RecognitionException {
		EEnumLiteralContext _localctx = new EEnumLiteralContext(_ctx, getState(), path);
		enterRule(_localctx, 44, RULE_eEnumLiteral);
		((EEnumLiteralContext)_localctx).element =  eFactory.createEEnumLiteral();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(893);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				{
				{
				setState(890);
				match(T__65);
				setState(891);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(892);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			qName.push(qName.peek() + "::" + (((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null) ); _localctx.element.setName((((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null));
			qPath.push(qPath.peek() + "/literal." + _localctx.path);
			setState(899);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(897);
				match(T__20);
				setState(898);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}

			 
			setState(912);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(902);
				match(T__1);
				setState(906);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(903);
					((EEnumLiteralContext)_localctx).eAnnotation = ((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(908);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EEnumLiteralContext)_localctx).eAnnotation.element);
				setState(910);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(911);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			addNamedElement(qPath.peek(), qName.peek(), _localctx.element, _localctx, _localctx.name.start);
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(qName.peek() + " (EnumLiteral)"); qName.pop(); System.out.println(qPath.peek() + " (EnumLiteral)"); qPath.pop();
		}
		catch (RecognitionException re) {
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
		public int path;
		public EAnnotation element;
		public int lanno = 0;
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
		public EAnnotationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EAnnotationContext(ParserRuleContext parent, int invokingState, int path) {
			super(parent, invokingState);
			this.path = path;
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

	public final EAnnotationContext eAnnotation(int path) throws RecognitionException {
		EAnnotationContext _localctx = new EAnnotationContext(_ctx, getState(), path);
		enterRule(_localctx, 46, RULE_eAnnotation);
		((EAnnotationContext)_localctx).element =  eFactory.createEAnnotation();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(916);
			match(T__66);
			setState(918);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(917);
				((EAnnotationContext)_localctx).source = match(SINGLE_QUOTED_STRING);
				}
			}

			qName.push(qName.peek() + "@annotation" + _localctx.path ); _localctx.element.setSource(((EAnnotationContext)_localctx).source != null ? ((EAnnotationContext)_localctx).source.getText().replace("'", "") : null);
			qPath.push(qPath.peek() + "/annotation." + _localctx.path);
			setState(933);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(922);
				match(T__14);
				setState(923);
				((EAnnotationContext)_localctx).eDetail = eDetail();
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(928);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(924);
					match(T__2);
					setState(925);
					((EAnnotationContext)_localctx).eDetail = eDetail();
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(930);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(931);
				match(T__15);
				}
			}

			for (EDetailContext ctx: ((EAnnotationContext)_localctx).ownedDetails) _localctx.element.getDetails().put(ctx.k, ctx.v);
			setState(953);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(936);
				match(T__1);
				setState(946); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(946);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
					case 1:
						{
						setState(937);
						((EAnnotationContext)_localctx).eAnnotation = ((EAnnotationContext)_localctx).eAnnotation = eAnnotation(_localctx.lanno++);
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAnnotationContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(940);
						((EAnnotationContext)_localctx).eModelElement = ((EAnnotationContext)_localctx).eModelElement = eModelElement();
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						_localctx.element.getContents().add(((EAnnotationContext)_localctx).eModelElement.element);
						}
						break;
					case 3:
						{
						setState(943);
						((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef();
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);

						}
						break;
					}
					}
					setState(948); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & ((1L << (T__16 - 17)) | (1L << (T__17 - 17)) | (1L << (T__19 - 17)) | (1L << (T__21 - 17)) | (1L << (T__22 - 17)) | (1L << (T__23 - 17)) | (1L << (T__24 - 17)) | (1L << (T__25 - 17)) | (1L << (T__26 - 17)) | (1L << (T__27 - 17)) | (1L << (T__28 - 17)) | (1L << (T__29 - 17)) | (1L << (T__30 - 17)) | (1L << (T__31 - 17)) | (1L << (T__32 - 17)) | (1L << (T__33 - 17)) | (1L << (T__34 - 17)) | (1L << (T__35 - 17)) | (1L << (T__36 - 17)) | (1L << (T__38 - 17)) | (1L << (T__40 - 17)) | (1L << (T__42 - 17)) | (1L << (T__44 - 17)) | (1L << (T__45 - 17)) | (1L << (T__47 - 17)) | (1L << (T__48 - 17)) | (1L << (T__49 - 17)) | (1L << (T__55 - 17)) | (1L << (T__56 - 17)) | (1L << (T__57 - 17)) | (1L << (T__64 - 17)) | (1L << (T__65 - 17)) | (1L << (T__66 - 17)) | (1L << (T__67 - 17)) | (1L << (T__73 - 17)) | (1L << (T__74 - 17)) | (1L << (T__75 - 17)) | (1L << (T__76 - 17)) | (1L << (T__78 - 17)))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)) | (1L << (T__83 - 81)) | (1L << (T__84 - 81)) | (1L << (T__132 - 81)) | (1L << (T__133 - 81)) | (1L << (T__134 - 81)) | (1L << (IDENTIFIER - 81)))) != 0) );
				setState(950);
				match(T__3);
				}
				}
				break;
			case T__18:
				{
				setState(952);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			addModelElement(qPath.peek(), qName.peek(), _localctx.element, _localctx);
			}
			_ctx.stop = _input.LT(-1);
			System.out.println(Console.YELLOW + qName.peek() + " (Annotation)" + Console.RESET); qName.pop(); System.out.println(Console.YELLOW + qPath.peek() + " (Annotation)" + Console.RESET); qPath.pop();
		}
		catch (RecognitionException re) {
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
			setState(958);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(957);
				((EDetailContext)_localctx).key = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(960);
			match(T__20);
			setState(962);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) {
				{
				setState(961);
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
		public int anno = 0;
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
			setState(972);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(966);
				((EModelElementContext)_localctx).eAnnotation = eAnnotation(_localctx.anno++);
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eAnnotation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(969);
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
		public int pack = 0;
		public int clas = 0;
		public int lite = 0;
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
			setState(986);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(974);
				((ENamedElementContext)_localctx).eTypedElement = eTypedElement();
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eTypedElement.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(977);
				((ENamedElementContext)_localctx).eClassifier = eClassifier(_localctx.clas++);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eClassifier.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(980);
				((ENamedElementContext)_localctx).ePackage = ePackage(_localctx.pack++);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).ePackage.element;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(983);
				((ENamedElementContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.lite++);
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
		public int pack = 0;
		public int clas = 0;
		public int feat;
		public int oper;
		public int path;
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
			setState(997);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(988);
				((ETypedElementContext)_localctx).eOperation = eOperation(_localctx.oper++);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eOperation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(991);
				((ETypedElementContext)_localctx).eParameter = eParameter(_localctx.path++);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eParameter.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(994);
				((ETypedElementContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.feat++);
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
			setState(999);
			match(T__67);
			setState(1000);
			((EModelElementRefContext)_localctx).ownedPathName = pathName();
			setState(1001);
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
		public ETypeParameterContext eTypeParameter;
		public List<ETypeParameterContext> ownedTypeParameters = new ArrayList<ETypeParameterContext>();
		public List<ETypeParameterContext> eTypeParameter() {
			return getRuleContexts(ETypeParameterContext.class);
		}
		public ETypeParameterContext eTypeParameter(int i) {
			return getRuleContext(ETypeParameterContext.class,i);
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
			setState(1003);
			match(T__68);
			setState(1004);
			((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter();
			((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
			setState(1009);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1005);
				match(T__2);
				setState(1006);
				((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter();
				((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
				}
				}
				setState(1011);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1012);
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

	public static class ETypeParameterContext extends ParserRuleContext {
		public ETypeParameter element;
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
		public ETypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eTypeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterETypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitETypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitETypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ETypeParameterContext eTypeParameter() throws RecognitionException {
		ETypeParameterContext _localctx = new ETypeParameterContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_eTypeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1014);
			((ETypeParameterContext)_localctx).name = unrestrictedName();
			setState(1024);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(1015);
				match(T__24);
				setState(1016);
				((ETypeParameterContext)_localctx).typedRef = typedRef();
				((ETypeParameterContext)_localctx).ownedExtends.add(((ETypeParameterContext)_localctx).typedRef);
				setState(1021);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__70) {
					{
					{
					setState(1017);
					match(T__70);
					setState(1018);
					((ETypeParameterContext)_localctx).typedRef = typedRef();
					((ETypeParameterContext)_localctx).ownedExtends.add(((ETypeParameterContext)_localctx).typedRef);
					}
					}
					setState(1023);
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
			setState(1028);
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
			case T__26:
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
				setState(1026);
				typedRef();
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 2);
				{
				setState(1027);
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
			setState(1032);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
				enterOuterAlt(_localctx, 1);
				{
				setState(1030);
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
			case T__26:
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
				setState(1031);
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
			setState(1034);
			((TypedTypeRefContext)_localctx).ownedPathName = pathName();
			setState(1039);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(1035);
				match(T__68);
				setState(1036);
				((TypedTypeRefContext)_localctx).ownedBinding = templateBinding();
				setState(1037);
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
			setState(1041);
			match(T__52);
			setState(1044);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24 || _la==T__71) {
				{
				setState(1042);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__71) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1043);
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
		public List<TemplateParameterSubstitutionContext> templateParameterSubstitution() {
			return getRuleContexts(TemplateParameterSubstitutionContext.class);
		}
		public TemplateParameterSubstitutionContext templateParameterSubstitution(int i) {
			return getRuleContext(TemplateParameterSubstitutionContext.class,i);
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
			setState(1046);
			((TemplateBindingContext)_localctx).templateParameterSubstitution = templateParameterSubstitution();
			((TemplateBindingContext)_localctx).ownedSubstitutions.add(((TemplateBindingContext)_localctx).templateParameterSubstitution);
			setState(1051);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1047);
				match(T__2);
				setState(1048);
				((TemplateBindingContext)_localctx).templateParameterSubstitution = templateParameterSubstitution();
				((TemplateBindingContext)_localctx).ownedSubstitutions.add(((TemplateBindingContext)_localctx).templateParameterSubstitution);
				}
				}
				setState(1053);
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
			setState(1054);
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
			setState(1056);
			((PathNameContext)_localctx).unrestrictedName = unrestrictedName();
			((PathNameContext)_localctx).ownedPathElements.add(((PathNameContext)_localctx).unrestrictedName);
			setState(1061);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__72) {
				{
				{
				setState(1057);
				match(T__72);
				setState(1058);
				((PathNameContext)_localctx).unrestrictedName = unrestrictedName();
				((PathNameContext)_localctx).ownedPathElements.add(((PathNameContext)_localctx).unrestrictedName);
				}
				}
				setState(1063);
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
		public EAnnotation element;
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
		((BodyContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.BODY);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1064);
			match(T__73);
			setState(1066);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1065);
				((BodyContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((BodyContext)_localctx).name!=null?_input.getText(((BodyContext)_localctx).name.start,((BodyContext)_localctx).name.stop):null)); 
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
				switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
				case 1:
					{
					setState(1070);
					((BodyContext)_localctx).ownedExpression = expression(0);
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
			if(_localctx.ownedExpression!=null) _localctx.element.getDetails().put("expression", getContextText(_localctx.expression())); 
			}
		}
		catch (RecognitionException re) {
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
		public EAnnotation element;
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
		((InvariantContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INVARIANT);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1080);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__74) {
				{
				setState(1079);
				((InvariantContext)_localctx).isCallable = match(T__74);
				}
			}

			_localctx.element.getDetails().put("callable", ((InvariantContext)_localctx).isCallable != null ? "true" : "false");
			setState(1083);
			match(T__75);
			setState(1090);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1084);
				((InvariantContext)_localctx).name = identifier();
				setState(1088);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1085);
					match(T__14);
					setState(1086);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1087);
					match(T__15);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InvariantContext)_localctx).name!=null?_input.getText(((InvariantContext)_localctx).name.start,((InvariantContext)_localctx).name.stop):null)); if(((InvariantContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((InvariantContext)_localctx).message!=null?((InvariantContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1099);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1093);
				match(T__5);
				setState(1095);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
				case 1:
					{
					setState(1094);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1097);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1098);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedSpecification!=null) _localctx.element.getDetails().put("formula", getContextText(_localctx.formula())); 
			}
		}
		catch (RecognitionException re) {
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
		public EAnnotation element;
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
		((PreconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.PRECONDITION);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1103);
			_la = _input.LA(1);
			if ( !(_la==T__76 || _la==T__77) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1104);
				((PreconditionContext)_localctx).name = identifier();
				setState(1108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1105);
					match(T__14);
					setState(1106);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1107);
					match(T__15);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PreconditionContext)_localctx).name!=null?_input.getText(((PreconditionContext)_localctx).name.start,((PreconditionContext)_localctx).name.stop):null)); if(((PreconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PreconditionContext)_localctx).message!=null?((PreconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1113);
				match(T__5);
				setState(1115);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1114);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1117);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1118);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedSpecification!=null) _localctx.element.getDetails().put("formula", getContextText(_localctx.formula())); 
			}
		}
		catch (RecognitionException re) {
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
		public EAnnotation element;
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
		((PostconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.POSTCONDITION);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1123);
			_la = _input.LA(1);
			if ( !(_la==T__78 || _la==T__79) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1124);
				((PostconditionContext)_localctx).name = identifier();
				setState(1128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1125);
					match(T__14);
					setState(1126);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1127);
					match(T__15);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PostconditionContext)_localctx).name!=null?_input.getText(((PostconditionContext)_localctx).name.start,((PostconditionContext)_localctx).name.stop):null)); if(((PostconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PostconditionContext)_localctx).message!=null?((PostconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1133);
				match(T__5);
				setState(1135);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
				case 1:
					{
					setState(1134);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1137);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1138);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedSpecification!=null) _localctx.element.getDetails().put("formula", getContextText(_localctx.formula())); 
			}
		}
		catch (RecognitionException re) {
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
		public EAnnotation element;
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
		((InitialContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INITIAL);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1143);
			match(T__80);
			setState(1145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1144);
				((InitialContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InitialContext)_localctx).name!=null?_input.getText(((InitialContext)_localctx).name.start,((InitialContext)_localctx).name.stop):null));
			setState(1154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1148);
				match(T__5);
				setState(1150);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
				case 1:
					{
					setState(1149);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1152);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1153);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedExpression!=null) _localctx.element.getDetails().put("expression", getContextText(_localctx.expression())); 
			}
		}
		catch (RecognitionException re) {
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
		public EAnnotation element;
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
		((DerivationContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.DERIVATION);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1158);
			match(T__81);
			setState(1160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1159);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((DerivationContext)_localctx).name!=null?_input.getText(((DerivationContext)_localctx).name.start,((DerivationContext)_localctx).name.stop):null));
			setState(1169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1163);
				match(T__5);
				setState(1165);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
				case 1:
					{
					setState(1164);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1167);
				match(T__18);
				}
				}
				break;
			case T__18:
				{
				setState(1168);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedExpression!=null) _localctx.element.getDetails().put("expression", getContextText(_localctx.expression())); 
			}
		}
		catch (RecognitionException re) {
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
		public EAnnotation element;
		public Token qualifier;
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
		((VisibilityKindContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.VISIBILITY);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__82:
				{
				setState(1173);
				((VisibilityKindContext)_localctx).qualifier = match(T__82);
				}
				break;
			case T__83:
				{
				setState(1174);
				((VisibilityKindContext)_localctx).qualifier = match(T__83);
				}
				break;
			case T__84:
				{
				setState(1175);
				((VisibilityKindContext)_localctx).qualifier = match(T__84);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.element.getDetails().put("visibility", (((VisibilityKindContext)_localctx).qualifier!=null?((VisibilityKindContext)_localctx).qualifier.getText():null));
			}
		}
		catch (RecognitionException re) {
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
			setState(1183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1180);
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
				setState(1182);
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
			setState(1185);
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
			setState(1449);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1188);
				match(T__85);
				setState(1189);
				expression(0);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1190);
				match(T__86);
				setState(1191);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1192);
				match(T__87);
				setState(1193);
				expression(0);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1194);
				match(T__88);
				setState(1195);
				expression(0);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1196);
				((InContext)_localctx).left = expression(0);
				setState(1198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1197);
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

				setState(1200);
				match(T__91);
				setState(1201);
				((InContext)_localctx).right = expression(0);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1203);
				((EqualContext)_localctx).left = expression(0);
				setState(1205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1204);
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

				setState(1207);
				match(T__20);
				setState(1208);
				((EqualContext)_localctx).right = expression(0);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1210);
				((EqContext)_localctx).ileft = intexpression(0);
				setState(1212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1211);
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

				setState(1214);
				match(T__20);
				setState(1215);
				((EqContext)_localctx).iright = intexpression(0);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1217);
				((LtContext)_localctx).ileft = intexpression(0);
				setState(1219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1218);
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

				setState(1221);
				match(T__68);
				setState(1222);
				((LtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1224);
				((LteContext)_localctx).ileft = intexpression(0);
				setState(1226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1225);
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

				setState(1228);
				match(T__92);
				setState(1229);
				((LteContext)_localctx).iright = intexpression(0);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1231);
				((GtContext)_localctx).ileft = intexpression(0);
				setState(1233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1232);
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

				setState(1235);
				match(T__69);
				setState(1236);
				((GtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1238);
				((GteContext)_localctx).ileft = intexpression(0);
				setState(1240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1239);
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

				setState(1242);
				match(T__93);
				setState(1243);
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
				setState(1246);
				match(T__94);
				setState(1247);
				decls();
				setState(1248);
				match(T__95);
				setState(1249);
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
				setState(1253);
				match(T__96);
				setState(1254);
				match(T__10);
				setState(1255);
				relationId();
				setState(1256);
				match(T__11);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1258);
				match(T__97);
				setState(1259);
				match(T__10);
				setState(1260);
				((FunctionContext)_localctx).rel = relationId();
				setState(1261);
				match(T__5);
				setState(1262);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1263);
				match(T__98);
				setState(1264);
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
				setState(1265);
				((FunctionContext)_localctx).range = expression(0);
				setState(1266);
				match(T__11);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1268);
				match(T__99);
				setState(1269);
				match(T__10);
				setState(1270);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1271);
				match(T__2);
				setState(1272);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1273);
				match(T__2);
				setState(1274);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1275);
				match(T__2);
				setState(1276);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1277);
				match(T__11);
				}
				break;
			case 16:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1279);
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
				setState(1280);
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
				setState(1282);
				match(T__108);
				setState(1283);
				decls();
				setState(1304);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1284);
					match(T__95);
					setState(1294);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
					case 1:
						{
						setState(1285);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1286);
						match(T__1);
						setState(1290);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
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
							_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
						}
						setState(1293);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1296);
					match(T__1);
					setState(1300);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1297);
							formula(0);
							}
							} 
						}
						setState(1302);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
					}
					setState(1303);
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
				setState(1309);
				match(T__88);
				setState(1310);
				decls();
				setState(1331);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1311);
					match(T__95);
					setState(1321);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
					case 1:
						{
						setState(1312);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1313);
						match(T__1);
						setState(1317);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
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
							_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
						}
						setState(1320);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1323);
					match(T__1);
					setState(1327);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1324);
							formula(0);
							}
							} 
						}
						setState(1329);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
					}
					setState(1330);
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
				setState(1336);
				match(T__85);
				setState(1337);
				decls();
				setState(1358);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1338);
					match(T__95);
					setState(1348);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
					case 1:
						{
						setState(1339);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1340);
						match(T__1);
						setState(1344);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
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
							_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
						}
						setState(1347);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1350);
					match(T__1);
					setState(1354);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1351);
							formula(0);
							}
							} 
						}
						setState(1356);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
					}
					setState(1357);
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
				setState(1363);
				match(T__87);
				setState(1364);
				decls();
				setState(1385);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1365);
					match(T__95);
					setState(1375);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
					case 1:
						{
						setState(1366);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1367);
						match(T__1);
						setState(1371);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1368);
								formula(0);
								}
								} 
							}
							setState(1373);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
						}
						setState(1374);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1377);
					match(T__1);
					setState(1381);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1378);
							formula(0);
							}
							} 
						}
						setState(1383);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
					}
					setState(1384);
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
				setState(1390);
				match(T__86);
				setState(1391);
				decls();
				setState(1412);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1392);
					match(T__95);
					setState(1402);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
					case 1:
						{
						setState(1393);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1394);
						match(T__1);
						setState(1398);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1395);
								formula(0);
								}
								} 
							}
							setState(1400);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
						}
						setState(1401);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1404);
					match(T__1);
					setState(1408);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1405);
							formula(0);
							}
							} 
						}
						setState(1410);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
					}
					setState(1411);
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
				setState(1417);
				match(T__109);
				setState(1418);
				letDecls();
				setState(1439);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1419);
					match(T__95);
					setState(1429);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
					case 1:
						{
						setState(1420);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1421);
						match(T__1);
						setState(1425);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1422);
								formula(0);
								}
								} 
							}
							setState(1427);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
						}
						setState(1428);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1431);
					match(T__1);
					setState(1435);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1432);
							formula(0);
							}
							} 
						}
						setState(1437);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
					}
					setState(1438);
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
				setState(1443);
				match(T__110);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1444);
				match(T__111);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1445);
				match(T__14);
				setState(1446);
				formula(0);
				setState(1447);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1465);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1463);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1451);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1452);
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
						setState(1453);
						((AndContext)_localctx).fright = formula(13);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1454);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1455);
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
						setState(1456);
						((OrContext)_localctx).fright = formula(12);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1457);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1458);
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
						setState(1459);
						((ImpliesContext)_localctx).fright = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1460);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1461);
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
						setState(1462);
						((IffContext)_localctx).fright = formula(10);
						}
						break;
					}
					} 
				}
				setState(1467);
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
			setState(1505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1469);
				match(T__112);
				setState(1470);
				expression(19);
				}
				break;
			case 2:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1471);
				match(T__113);
				setState(1472);
				expression(18);
				}
				break;
			case 3:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1473);
				match(T__50);
				setState(1474);
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
				setState(1476);
				match(T__1);
				setState(1477);
				comprehensionDecls();
				setState(1478);
				match(T__95);
				setState(1479);
				formula(0);
				setState(1480);
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
				setState(1484);
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
				setState(1485);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1486);
				match(T__118);
				setState(1487);
				((IfExpressionContext)_localctx).thenExpr = expression(0);
				setState(1488);
				match(T__119);
				setState(1489);
				((IfExpressionContext)_localctx).elseExpr = expression(8);
				}
				break;
			case 6:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1491);
				match(T__120);
				}
				break;
			case 7:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1492);
				match(T__121);
				}
				break;
			case 8:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1493);
				match(T__122);
				}
				break;
			case 9:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1494);
				match(T__123);
				}
				break;
			case 10:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1495);
				match(T__14);
				setState(1496);
				expression(0);
				setState(1497);
				match(T__15);
				}
				break;
			case 11:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1499);
				if (!(!isRelation())) throw new FailedPredicateException(this, "!isRelation()");
				setState(1500);
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
				setState(1503);
				if (!(isRelation())) throw new FailedPredicateException(this, "isRelation()");
				setState(1504);
				relationId();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1538);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,208,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1536);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1507);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1508);
						match(T__51);
						setState(1509);
						((UnionContext)_localctx).right = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1510);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1511);
						match(T__70);
						setState(1512);
						((IntersectionContext)_localctx).right = expression(16);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1513);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1514);
						match(T__114);
						setState(1515);
						((DifferenceContext)_localctx).right = expression(15);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1516);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1517);
						match(T__115);
						setState(1518);
						((JoinContext)_localctx).right = expression(14);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1519);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1521);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__116 - 87)))) != 0)) {
							{
							setState(1520);
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

						setState(1523);
						match(T__98);
						setState(1525);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
						case 1:
							{
							setState(1524);
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
						setState(1527);
						((ProductContext)_localctx).right = expression(11);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1528);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1529);
						match(T__117);
						setState(1530);
						((OverrideContext)_localctx).right = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BoxjoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxjoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1531);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1532);
						match(T__10);
						setState(1533);
						((BoxjoinContext)_localctx).left = expression(0);
						setState(1534);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(1540);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,208,_ctx);
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
			setState(1561);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__104:
			case T__105:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1542);
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
				setState(1543);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1544);
				match(T__118);
				setState(1545);
				((IfIntExpressionContext)_localctx).thenExpr = intexpression(0);
				setState(1546);
				match(T__119);
				setState(1547);
				((IfIntExpressionContext)_localctx).elseExpr = intexpression(10);
				}
				break;
			case T__94:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1549);
				match(T__94);
				setState(1550);
				expression(0);
				}
				break;
			case T__43:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1551);
				match(T__43);
				setState(1552);
				expression(0);
				}
				break;
			case T__114:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__114) {
					{
					setState(1553);
					((IntConstantContext)_localctx).sign = match(T__114);
					}
				}

				setState(1556);
				integer();
				}
				break;
			case T__14:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1557);
				match(T__14);
				setState(1558);
				intexpression(0);
				setState(1559);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1580);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,212,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1578);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntexpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1563);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1564);
						_la = _input.LA(1);
						if ( !(_la==T__51 || _la==T__124) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1565);
						((PlusContext)_localctx).iright = intexpression(8);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntexpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1566);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1567);
						_la = _input.LA(1);
						if ( !(_la==T__114 || _la==T__125) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1568);
						((MinusContext)_localctx).iright = intexpression(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntexpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1569);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1570);
						_la = _input.LA(1);
						if ( !(_la==T__50 || _la==T__126) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1571);
						((MultiplyContext)_localctx).iright = intexpression(6);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntexpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1572);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1573);
						_la = _input.LA(1);
						if ( !(_la==T__127 || _la==T__128) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1574);
						((DivideContext)_localctx).iright = intexpression(5);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntexpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1575);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1576);
						_la = _input.LA(1);
						if ( !(_la==T__129 || _la==T__130) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1577);
						((ModuloContext)_localctx).iright = intexpression(4);
						}
						break;
					}
					} 
				}
				setState(1582);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,212,_ctx);
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
			setState(1583);
			decl();
			setState(1588);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1584);
				match(T__2);
				setState(1585);
				decl();
				}
				}
				setState(1590);
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
			setState(1657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1591);
					((OneOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1594);
				((OneOfContext)_localctx).variableId = variableId();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
				setState(1599);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1595);
					match(T__2);
					setState(1596);
					((OneOfContext)_localctx).variableId = variableId();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
					}
					}
					setState(1601);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1602);
				match(T__5);
				setState(1604);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
				case 1:
					{
					setState(1603);
					match(T__87);
					}
					break;
				}
				setState(1606);
				expression(0);
				((FormulaContext)getInvokingContext(47)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(47)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1610);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1609);
					((LoneOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1612);
				((LoneOfContext)_localctx).variableId = variableId();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
				setState(1617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1613);
					match(T__2);
					setState(1614);
					((LoneOfContext)_localctx).variableId = variableId();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
					}
					}
					setState(1619);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1620);
				match(T__5);
				setState(1621);
				match(T__86);
				setState(1622);
				expression(0);
				((FormulaContext)getInvokingContext(47)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(47)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1626);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1625);
					((SomeOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1628);
				((SomeOfContext)_localctx).variableId = variableId();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
				setState(1633);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1629);
					match(T__2);
					setState(1630);
					((SomeOfContext)_localctx).variableId = variableId();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
					}
					}
					setState(1635);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1636);
				match(T__5);
				setState(1637);
				match(T__88);
				setState(1638);
				expression(0);
				((FormulaContext)getInvokingContext(47)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(47)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1641);
					((SetOfContext)_localctx).disj = match(T__131);
					}
				}

				setState(1644);
				((SetOfContext)_localctx).variableId = variableId();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
				setState(1649);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1645);
					match(T__2);
					setState(1646);
					((SetOfContext)_localctx).variableId = variableId();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
					}
					}
					setState(1651);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1652);
				match(T__5);
				setState(1653);
				match(T__116);
				setState(1654);
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
			setState(1659);
			letDecl();
			setState(1664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1660);
				match(T__2);
				setState(1661);
				letDecl();
				}
				}
				setState(1666);
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
			setState(1667);
			((LetDeclContext)_localctx).variableId = variableId();
			((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
			setState(1672);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1668);
				match(T__2);
				setState(1669);
				((LetDeclContext)_localctx).variableId = variableId();
				((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
				}
				}
				setState(1674);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1675);
			match(T__20);
			setState(1676);
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
			setState(1680);
			comprehensionDecl();
			setState(1685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1681);
				match(T__2);
				setState(1682);
				comprehensionDecl();
				}
				}
				setState(1687);
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
			setState(1689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__131) {
				{
				setState(1688);
				((ComprehensionDeclContext)_localctx).disj = match(T__131);
				}
			}

			{
			setState(1691);
			((ComprehensionDeclContext)_localctx).variableId = variableId();
			((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
			setState(1696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1692);
				match(T__2);
				setState(1693);
				((ComprehensionDeclContext)_localctx).variableId = variableId();
				((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
				}
				}
				setState(1698);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1699);
			match(T__5);
			setState(1701);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
			case 1:
				{
				setState(1700);
				match(T__87);
				}
				break;
			}
			setState(1703);
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
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
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
			setState(1707);
			unrestrictedName();
			}
		}
		catch (RecognitionException re) {
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
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
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
			setState(1709);
			unrestrictedName();
			}
		}
		catch (RecognitionException re) {
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
			setState(1711);
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
			setState(1755);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(1713);
				match(T__21);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(1714);
				match(T__33);
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 3);
				{
				setState(1715);
				match(T__73);
				}
				break;
			case T__74:
				enterOuterAlt(_localctx, 4);
				{
				setState(1716);
				match(T__74);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 5);
				{
				setState(1717);
				match(T__22);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 6);
				{
				setState(1718);
				match(T__44);
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 7);
				{
				setState(1719);
				match(T__56);
				}
				break;
			case T__132:
				enterOuterAlt(_localctx, 8);
				{
				setState(1720);
				match(T__132);
				}
				break;
			case T__81:
				enterOuterAlt(_localctx, 9);
				{
				setState(1721);
				match(T__81);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 10);
				{
				setState(1722);
				match(T__34);
				}
				break;
			case T__64:
				enterOuterAlt(_localctx, 11);
				{
				setState(1723);
				match(T__64);
				}
				break;
			case T__133:
				enterOuterAlt(_localctx, 12);
				{
				setState(1724);
				match(T__133);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 13);
				{
				setState(1725);
				match(T__24);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 14);
				{
				setState(1726);
				match(T__35);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 15);
				{
				setState(1727);
				match(T__17);
				}
				break;
			case T__80:
				enterOuterAlt(_localctx, 16);
				{
				setState(1728);
				match(T__80);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 17);
				{
				setState(1729);
				match(T__23);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 18);
				{
				setState(1730);
				match(T__47);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 19);
				{
				setState(1731);
				match(T__16);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 20);
				{
				setState(1732);
				match(T__48);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 21);
				{
				setState(1733);
				match(T__36);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 22);
				{
				setState(1734);
				match(T__19);
				}
				break;
			case T__78:
				enterOuterAlt(_localctx, 23);
				{
				setState(1735);
				match(T__78);
				}
				break;
			case T__76:
				enterOuterAlt(_localctx, 24);
				{
				setState(1736);
				match(T__76);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 25);
				{
				setState(1737);
				match(T__55);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 26);
				{
				setState(1738);
				match(T__42);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 27);
				{
				setState(1739);
				match(T__32);
				}
				break;
			case T__67:
				enterOuterAlt(_localctx, 28);
				{
				setState(1740);
				match(T__67);
				}
				break;
			case T__134:
				enterOuterAlt(_localctx, 29);
				{
				setState(1741);
				match(T__134);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 30);
				{
				setState(1742);
				match(T__45);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 31);
				{
				setState(1743);
				match(T__25);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 32);
				{
				setState(1744);
				match(T__49);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 33);
				{
				setState(1745);
				match(T__28);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 34);
				{
				setState(1746);
				match(T__38);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 35);
				{
				setState(1747);
				match(T__40);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 36);
				{
				setState(1748);
				match(T__29);
				}
				break;
			case T__75:
				enterOuterAlt(_localctx, 37);
				{
				setState(1749);
				match(T__75);
				}
				break;
			case T__65:
				enterOuterAlt(_localctx, 38);
				{
				setState(1750);
				match(T__65);
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 39);
				{
				setState(1751);
				match(T__57);
				}
				break;
			case T__66:
				enterOuterAlt(_localctx, 40);
				{
				setState(1752);
				match(T__66);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 41);
				{
				setState(1753);
				match(T__26);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 42);
				{
				setState(1754);
				identifier();
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
			setState(1757);
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
			setState(1759);
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
			setState(1761);
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
			setState(1764);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__114) {
				{
				setState(1763);
				match(T__114);
				}
			}

			setState(1766);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0091\u06eb\4\2\t"+
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
		"\t\u0121\n\t\3\n\5\n\u0124\n\n\3\n\3\n\3\n\5\n\u0129\n\n\3\n\3\n\7\n\u012d"+
		"\n\n\f\n\16\n\u0130\13\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u013a"+
		"\n\13\3\13\3\13\3\13\3\f\5\f\u0140\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u015b\n\f\f\f\16\f\u015e\13\f\3\f\3\f\5\f\u0162\n\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u016f\n\r\3\16\5\16\u0172\n\16\3\16\3"+
		"\16\5\16\u0176\n\16\3\16\3\16\5\16\u017a\n\16\3\16\3\16\5\16\u017e\n\16"+
		"\3\16\3\16\3\16\5\16\u0183\n\16\3\16\3\16\3\16\3\16\3\16\7\16\u018a\n"+
		"\16\f\16\16\16\u018d\13\16\5\16\u018f\n\16\3\16\3\16\3\16\5\16\u0194\n"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\7\16\u01a4\n\16\f\16\16\16\u01a7\13\16\3\16\3\16\5\16\u01ab\n\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u01b5\n\17\3\20\5\20\u01b8"+
		"\n\20\3\20\3\20\5\20\u01bc\n\20\3\20\3\20\5\20\u01c0\n\20\3\20\5\20\u01c3"+
		"\n\20\3\20\5\20\u01c6\n\20\3\20\3\20\5\20\u01ca\n\20\3\20\5\20\u01cd\n"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01d6\n\20\3\20\3\20\3\20"+
		"\5\20\u01db\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u01e7\n\20\3\20\5\20\u01ea\n\20\6\20\u01ec\n\20\r\20\16\20\u01ed\3\20"+
		"\5\20\u01f1\n\20\3\20\3\20\3\20\3\20\7\20\u01f7\n\20\f\20\16\20\u01fa"+
		"\13\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0202\n\20\3\20\3\20\3\20\7"+
		"\20\u0207\n\20\f\20\16\20\u020a\13\20\3\20\3\20\5\20\u020e\n\20\3\20\3"+
		"\20\3\20\3\21\5\21\u0214\n\21\3\21\3\21\5\21\u0218\n\21\3\21\3\21\5\21"+
		"\u021c\n\21\3\21\5\21\u021f\n\21\3\21\5\21\u0222\n\21\3\21\3\21\5\21\u0226"+
		"\n\21\3\21\5\21\u0229\n\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0231\n"+
		"\21\3\21\3\21\3\21\3\21\5\21\u0237\n\21\3\21\3\21\3\21\5\21\u023c\n\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u024a"+
		"\n\21\3\21\5\21\u024d\n\21\6\21\u024f\n\21\r\21\16\21\u0250\3\21\5\21"+
		"\u0254\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u025b\n\21\f\21\16\21\u025e"+
		"\13\21\3\21\3\21\5\21\u0262\n\21\3\21\3\21\3\21\7\21\u0267\n\21\f\21\16"+
		"\21\u026a\13\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0272\n\21\3\21\3\21"+
		"\3\21\7\21\u0277\n\21\f\21\16\21\u027a\13\21\3\21\3\21\5\21\u027e\n\21"+
		"\3\21\3\21\3\21\3\22\5\22\u0284\n\22\3\22\3\22\5\22\u0288\n\22\3\22\3"+
		"\22\5\22\u028c\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0296"+
		"\n\22\f\22\16\22\u0299\13\22\5\22\u029b\n\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u02a2\n\22\5\22\u02a4\n\22\3\22\3\22\3\22\3\22\3\22\7\22\u02ab\n"+
		"\22\f\22\16\22\u02ae\13\22\5\22\u02b0\n\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\5\22\u02b8\n\22\3\22\5\22\u02bb\n\22\6\22\u02bd\n\22\r\22\16\22\u02be"+
		"\3\22\5\22\u02c2\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\7\22\u02d1\n\22\f\22\16\22\u02d4\13\22\3\22\3\22\5\22"+
		"\u02d8\n\22\3\22\3\22\3\22\3\23\3\23\5\23\u02df\n\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\5\23\u02e7\n\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u02ef"+
		"\n\23\3\23\5\23\u02f2\n\23\6\23\u02f4\n\23\r\23\16\23\u02f5\3\23\5\23"+
		"\u02f9\n\23\3\23\3\23\7\23\u02fd\n\23\f\23\16\23\u0300\13\23\3\23\3\23"+
		"\5\23\u0304\n\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u030d\n\24\3"+
		"\24\5\24\u0310\n\24\3\24\3\24\5\24\u0314\n\24\3\24\3\24\3\24\3\25\5\25"+
		"\u031a\n\25\3\25\3\25\3\25\3\25\5\25\u0320\n\25\5\25\u0322\n\25\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u0329\n\25\3\25\3\25\3\25\5\25\u032e\n\25\3\25"+
		"\3\25\3\25\3\25\5\25\u0334\n\25\3\25\5\25\u0337\n\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\7\25\u0340\n\25\f\25\16\25\u0343\13\25\3\25\3\25\5"+
		"\25\u0347\n\25\3\25\3\25\3\25\3\26\3\26\3\27\5\27\u034f\n\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u0357\n\27\3\27\3\27\3\27\5\27\u035c\n\27\3"+
		"\27\3\27\3\27\3\27\5\27\u0362\n\27\3\27\5\27\u0365\n\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0371\n\27\f\27\16\27\u0374\13"+
		"\27\3\27\3\27\5\27\u0378\n\27\3\27\3\27\3\27\3\30\3\30\3\30\5\30\u0380"+
		"\n\30\3\30\3\30\3\30\3\30\5\30\u0386\n\30\3\30\3\30\3\30\7\30\u038b\n"+
		"\30\f\30\16\30\u038e\13\30\3\30\3\30\3\30\5\30\u0393\n\30\3\30\3\30\3"+
		"\31\3\31\5\31\u0399\n\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u03a1\n\31"+
		"\f\31\16\31\u03a4\13\31\3\31\3\31\5\31\u03a8\n\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\6\31\u03b5\n\31\r\31\16\31\u03b6\3"+
		"\31\3\31\3\31\5\31\u03bc\n\31\3\31\3\31\3\32\5\32\u03c1\n\32\3\32\3\32"+
		"\5\32\u03c5\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u03cf\n"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u03dd"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u03e8\n\35\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u03f2\n\37\f\37\16\37\u03f5\13"+
		"\37\3\37\3\37\3 \3 \3 \3 \3 \7 \u03fe\n \f \16 \u0401\13 \5 \u0403\n "+
		"\3!\3!\5!\u0407\n!\3\"\3\"\5\"\u040b\n\"\3#\3#\3#\3#\3#\5#\u0412\n#\3"+
		"$\3$\3$\5$\u0417\n$\3%\3%\3%\7%\u041c\n%\f%\16%\u041f\13%\3&\3&\3\'\3"+
		"\'\3\'\7\'\u0426\n\'\f\'\16\'\u0429\13\'\3(\3(\5(\u042d\n(\3(\3(\3(\5"+
		"(\u0432\n(\3(\3(\5(\u0436\n(\3(\3(\3)\5)\u043b\n)\3)\3)\3)\3)\3)\3)\5"+
		")\u0443\n)\5)\u0445\n)\3)\3)\3)\5)\u044a\n)\3)\3)\5)\u044e\n)\3)\3)\3"+
		"*\3*\3*\3*\3*\5*\u0457\n*\5*\u0459\n*\3*\3*\3*\5*\u045e\n*\3*\3*\5*\u0462"+
		"\n*\3*\3*\3+\3+\3+\3+\3+\5+\u046b\n+\5+\u046d\n+\3+\3+\3+\5+\u0472\n+"+
		"\3+\3+\5+\u0476\n+\3+\3+\3,\3,\5,\u047c\n,\3,\3,\3,\5,\u0481\n,\3,\3,"+
		"\5,\u0485\n,\3,\3,\3-\3-\5-\u048b\n-\3-\3-\3-\5-\u0490\n-\3-\3-\5-\u0494"+
		"\n-\3-\3-\3.\3.\3.\5.\u049b\n.\3.\3.\3/\3/\3/\5/\u04a2\n/\3\60\3\60\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u04b1\n\61"+
		"\3\61\3\61\3\61\3\61\3\61\5\61\u04b8\n\61\3\61\3\61\3\61\3\61\3\61\5\61"+
		"\u04bf\n\61\3\61\3\61\3\61\3\61\3\61\5\61\u04c6\n\61\3\61\3\61\3\61\3"+
		"\61\3\61\5\61\u04cd\n\61\3\61\3\61\3\61\3\61\3\61\5\61\u04d4\n\61\3\61"+
		"\3\61\3\61\3\61\3\61\5\61\u04db\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u050b\n\61"+
		"\f\61\16\61\u050e\13\61\3\61\5\61\u0511\n\61\3\61\3\61\7\61\u0515\n\61"+
		"\f\61\16\61\u0518\13\61\3\61\5\61\u051b\n\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\7\61\u0526\n\61\f\61\16\61\u0529\13\61\3\61\5\61"+
		"\u052c\n\61\3\61\3\61\7\61\u0530\n\61\f\61\16\61\u0533\13\61\3\61\5\61"+
		"\u0536\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u0541\n"+
		"\61\f\61\16\61\u0544\13\61\3\61\5\61\u0547\n\61\3\61\3\61\7\61\u054b\n"+
		"\61\f\61\16\61\u054e\13\61\3\61\5\61\u0551\n\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\7\61\u055c\n\61\f\61\16\61\u055f\13\61\3\61\5"+
		"\61\u0562\n\61\3\61\3\61\7\61\u0566\n\61\f\61\16\61\u0569\13\61\3\61\5"+
		"\61\u056c\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u0577"+
		"\n\61\f\61\16\61\u057a\13\61\3\61\5\61\u057d\n\61\3\61\3\61\7\61\u0581"+
		"\n\61\f\61\16\61\u0584\13\61\3\61\5\61\u0587\n\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\7\61\u0592\n\61\f\61\16\61\u0595\13\61\3\61"+
		"\5\61\u0598\n\61\3\61\3\61\7\61\u059c\n\61\f\61\16\61\u059f\13\61\3\61"+
		"\5\61\u05a2\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u05ac\n"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u05ba"+
		"\n\61\f\61\16\61\u05bd\13\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\5\62\u05e4\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u05f4\n\62\3\62\3\62\5\62\u05f8\n\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u0603\n\62\f\62\16\62\u0606"+
		"\13\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\5\63\u0615\n\63\3\63\3\63\3\63\3\63\3\63\5\63\u061c\n\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\7\63\u062d"+
		"\n\63\f\63\16\63\u0630\13\63\3\64\3\64\3\64\7\64\u0635\n\64\f\64\16\64"+
		"\u0638\13\64\3\65\5\65\u063b\n\65\3\65\3\65\3\65\7\65\u0640\n\65\f\65"+
		"\16\65\u0643\13\65\3\65\3\65\5\65\u0647\n\65\3\65\3\65\3\65\3\65\5\65"+
		"\u064d\n\65\3\65\3\65\3\65\7\65\u0652\n\65\f\65\16\65\u0655\13\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\5\65\u065d\n\65\3\65\3\65\3\65\7\65\u0662\n"+
		"\65\f\65\16\65\u0665\13\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u066d\n"+
		"\65\3\65\3\65\3\65\7\65\u0672\n\65\f\65\16\65\u0675\13\65\3\65\3\65\3"+
		"\65\3\65\3\65\5\65\u067c\n\65\3\66\3\66\3\66\7\66\u0681\n\66\f\66\16\66"+
		"\u0684\13\66\3\67\3\67\3\67\7\67\u0689\n\67\f\67\16\67\u068c\13\67\3\67"+
		"\3\67\3\67\3\67\3\67\38\38\38\78\u0696\n8\f8\168\u0699\138\39\59\u069c"+
		"\n9\39\39\39\79\u06a1\n9\f9\169\u06a4\139\39\39\59\u06a8\n9\39\39\39\3"+
		"9\3:\3:\3;\3;\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3"+
		"=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3"+
		"=\3=\3=\5=\u06de\n=\3>\3>\3?\3?\3@\3@\3A\5A\u06e7\nA\3A\3A\3A\2\5`bdB"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH"+
		"JLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\2\25\3\2\65\67\3\2>B\3\2\u008d\u008e"+
		"\4\2\33\33JJ\3\2OP\3\2QR\3\2\\]\3\2YZ\3\2gh\3\2ij\3\2kl\3\2mn\4\2Y[ww"+
		"\4\2\66\66\177\177\4\2uu\u0080\u0080\4\2\65\65\u0081\u0081\3\2\u0082\u0083"+
		"\3\2\u0084\u0085\4\2\65\65\u008a\u008a\u0818\2\u0083\3\2\2\2\4\u0092\3"+
		"\2\2\2\6\u00aa\3\2\2\2\b\u00ac\3\2\2\2\n\u00c7\3\2\2\2\f\u00d2\3\2\2\2"+
		"\16\u0108\3\2\2\2\20\u0120\3\2\2\2\22\u0123\3\2\2\2\24\u0135\3\2\2\2\26"+
		"\u013f\3\2\2\2\30\u016e\3\2\2\2\32\u0171\3\2\2\2\34\u01b4\3\2\2\2\36\u01b7"+
		"\3\2\2\2 \u0213\3\2\2\2\"\u0283\3\2\2\2$\u02de\3\2\2\2&\u0308\3\2\2\2"+
		"(\u0319\3\2\2\2*\u034b\3\2\2\2,\u034e\3\2\2\2.\u037f\3\2\2\2\60\u0396"+
		"\3\2\2\2\62\u03c0\3\2\2\2\64\u03ce\3\2\2\2\66\u03dc\3\2\2\28\u03e7\3\2"+
		"\2\2:\u03e9\3\2\2\2<\u03ed\3\2\2\2>\u03f8\3\2\2\2@\u0406\3\2\2\2B\u040a"+
		"\3\2\2\2D\u040c\3\2\2\2F\u0413\3\2\2\2H\u0418\3\2\2\2J\u0420\3\2\2\2L"+
		"\u0422\3\2\2\2N\u042a\3\2\2\2P\u043a\3\2\2\2R\u0451\3\2\2\2T\u0465\3\2"+
		"\2\2V\u0479\3\2\2\2X\u0488\3\2\2\2Z\u049a\3\2\2\2\\\u04a1\3\2\2\2^\u04a3"+
		"\3\2\2\2`\u05ab\3\2\2\2b\u05e3\3\2\2\2d\u061b\3\2\2\2f\u0631\3\2\2\2h"+
		"\u067b\3\2\2\2j\u067d\3\2\2\2l\u0685\3\2\2\2n\u0692\3\2\2\2p\u069b\3\2"+
		"\2\2r\u06ad\3\2\2\2t\u06af\3\2\2\2v\u06b1\3\2\2\2x\u06dd\3\2\2\2z\u06df"+
		"\3\2\2\2|\u06e1\3\2\2\2~\u06e3\3\2\2\2\u0080\u06e6\3\2\2\2\u0082\u0084"+
		"\5\4\3\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\5\b\5\2\u0086\u0087\b\2\1\2\u0087\u0088\5\n\6\2\u0088\u008c\b\2"+
		"\1\2\u0089\u008b\5`\61\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008f\u0090\b\2\1\2\u0090\u0091\b\2\1\2\u0091\3\3\2\2\2\u0092\u0093"+
		"\7\3\2\2\u0093\u0094\7\4\2\2\u0094\u0099\5\6\4\2\u0095\u0096\7\5\2\2\u0096"+
		"\u0098\5\6\4\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009d\7\6\2\2\u009d\5\3\2\2\2\u009e\u009f\7\7\2\2\u009f\u00a0\7\b\2\2"+
		"\u00a0\u00ab\5v<\2\u00a1\u00a2\7\t\2\2\u00a2\u00a3\7\b\2\2\u00a3\u00ab"+
		"\5v<\2\u00a4\u00a5\7\n\2\2\u00a5\u00a6\7\b\2\2\u00a6\u00ab\5v<\2\u00a7"+
		"\u00a8\7\13\2\2\u00a8\u00a9\7\b\2\2\u00a9\u00ab\5v<\2\u00aa\u009e\3\2"+
		"\2\2\u00aa\u00a1\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab"+
		"\7\3\2\2\2\u00ac\u00c3\7\f\2\2\u00ad\u00ae\7\4\2\2\u00ae\u00b3\5\\/\2"+
		"\u00af\u00b0\7\5\2\2\u00b0\u00b2\5\\/\2\u00b1\u00af\3\2\2\2\u00b2\u00b5"+
		"\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b6\u00b7\7\6\2\2\u00b7\u00c4\3\2\2\2\u00b8\u00b9\7\r"+
		"\2\2\u00b9\u00be\5\\/\2\u00ba\u00bb\7\5\2\2\u00bb\u00bd\5\\/\2\u00bc\u00ba"+
		"\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7\16\2\2\u00c2\u00c4\3"+
		"\2\2\2\u00c3\u00ad\3\2\2\2\u00c3\u00b8\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\b\5\1\2\u00c6\t\3\2\2\2\u00c7\u00c8\7\17\2\2\u00c8\u00cc\7\4\2"+
		"\2\u00c9\u00cb\5\f\7\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca"+
		"\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf"+
		"\u00d0\7\6\2\2\u00d0\u00d1\b\6\1\2\u00d1\13\3\2\2\2\u00d2\u00d4\5z>\2"+
		"\u00d3\u00d5\5^\60\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00d8\7\b\2\2\u00d7\u00d9\5b\62\2\u00d8\u00d7\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\7\r\2\2\u00db\u00de\5\16"+
		"\b\2\u00dc\u00dd\7\5\2\2\u00dd\u00df\5\16\b\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\7\16\2\2\u00e1\u00e2\3"+
		"\2\2\2\u00e2\u00e3\b\7\1\2\u00e3\r\3\2\2\2\u00e4\u00ed\7\4\2\2\u00e5\u00ea"+
		"\5\20\t\2\u00e6\u00e7\7\5\2\2\u00e7\u00e9\5\20\t\2\u00e8\u00e6\3\2\2\2"+
		"\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ee"+
		"\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00e5\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u0109\7\6\2\2\u00f0\u00f9\7\r\2\2\u00f1\u00f6\5\20"+
		"\t\2\u00f2\u00f3\7\5\2\2\u00f3\u00f5\5\20\t\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fa\3\2"+
		"\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00f1\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u0109\7\16\2\2\u00fc\u00fd\7\4\2\2\u00fd\u00fe\5"+
		"\20\t\2\u00fe\u00ff\7\20\2\2\u00ff\u0100\5\20\t\2\u0100\u0101\7\6\2\2"+
		"\u0101\u0109\3\2\2\2\u0102\u0103\7\r\2\2\u0103\u0104\5\20\t\2\u0104\u0105"+
		"\7\20\2\2\u0105\u0106\5\20\t\2\u0106\u0107\7\16\2\2\u0107\u0109\3\2\2"+
		"\2\u0108\u00e4\3\2\2\2\u0108\u00f0\3\2\2\2\u0108\u00fc\3\2\2\2\u0108\u0102"+
		"\3\2\2\2\u0109\17\3\2\2\2\u010a\u010b\7\21\2\2\u010b\u0110\5\\/\2\u010c"+
		"\u010d\7\5\2\2\u010d\u010f\5\\/\2\u010e\u010c\3\2\2\2\u010f\u0112\3\2"+
		"\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0113\u0114\7\22\2\2\u0114\u0121\3\2\2\2\u0115\u0116\7"+
		"\r\2\2\u0116\u011b\5\\/\2\u0117\u0118\7\5\2\2\u0118\u011a\5\\/\2\u0119"+
		"\u0117\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\7\16\2\2\u011f"+
		"\u0121\3\2\2\2\u0120\u010a\3\2\2\2\u0120\u0115\3\2\2\2\u0121\21\3\2\2"+
		"\2\u0122\u0124\5\4\3\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0128\b\n\1\2\u0126\u0127\7\23\2\2\u0127\u0129\5z>\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012e\b\n"+
		"\1\2\u012b\u012d\5\24\13\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2"+
		"\2\2\u0131\u0132\b\n\1\2\u0132\u0133\5\26\f\2\u0133\u0134\b\n\1\2\u0134"+
		"\23\3\2\2\2\u0135\u0139\7\24\2\2\u0136\u0137\5z>\2\u0137\u0138\7\b\2\2"+
		"\u0138\u013a\3\2\2\2\u0139\u0136\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b"+
		"\3\2\2\2\u013b\u013c\7\u008d\2\2\u013c\u013d\7\25\2\2\u013d\25\3\2\2\2"+
		"\u013e\u0140\5Z.\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141"+
		"\3\2\2\2\u0141\u0142\b\f\1\2\u0142\u0143\7\26\2\2\u0143\u0144\5x=\2\u0144"+
		"\u0145\b\f\1\2\u0145\u0146\b\f\1\2\u0146\u0147\7\b\2\2\u0147\u0148\5z"+
		">\2\u0148\u0149\3\2\2\2\u0149\u014a\7\27\2\2\u014a\u014b\7\u008d\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u0161\b\f\1\2\u014d\u015c\7\4\2\2\u014e\u014f\5\60"+
		"\31\2\u014f\u0150\b\f\1\2\u0150\u015b\3\2\2\2\u0151\u0152\5\26\f\2\u0152"+
		"\u0153\b\f\1\2\u0153\u015b\3\2\2\2\u0154\u0155\5\30\r\2\u0155\u0156\b"+
		"\f\1\2\u0156\u015b\3\2\2\2\u0157\u0158\5P)\2\u0158\u0159\b\f\1\2\u0159"+
		"\u015b\3\2\2\2\u015a\u014e\3\2\2\2\u015a\u0151\3\2\2\2\u015a\u0154\3\2"+
		"\2\2\u015a\u0157\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0162\7\6"+
		"\2\2\u0160\u0162\7\25\2\2\u0161\u014d\3\2\2\2\u0161\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0164\b\f\1\2\u0164\27\3\2\2\2\u0165\u0166\5\32\16"+
		"\2\u0166\u0167\b\r\1\2\u0167\u016f\3\2\2\2\u0168\u0169\5(\25\2\u0169\u016a"+
		"\b\r\1\2\u016a\u016f\3\2\2\2\u016b\u016c\5,\27\2\u016c\u016d\b\r\1\2\u016d"+
		"\u016f\3\2\2\2\u016e\u0165\3\2\2\2\u016e\u0168\3\2\2\2\u016e\u016b\3\2"+
		"\2\2\u016f\31\3\2\2\2\u0170\u0172\5Z.\2\u0171\u0170\3\2\2\2\u0171\u0172"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0179\b\16\1\2\u0174\u0176\7\30\2\2"+
		"\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u017a"+
		"\7\31\2\2\u0178\u017a\7\32\2\2\u0179\u0175\3\2\2\2\u0179\u0178\3\2\2\2"+
		"\u017a\u017b\3\2\2\2\u017b\u017d\b\16\1\2\u017c\u017e\5x=\2\u017d\u017c"+
		"\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\b\16\1\2"+
		"\u0180\u0182\b\16\1\2\u0181\u0183\5<\37\2\u0182\u0181\3\2\2\2\u0182\u0183"+
		"\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u018e\b\16\1\2\u0185\u0186\7\33\2\2"+
		"\u0186\u018b\5B\"\2\u0187\u0188\7\5\2\2\u0188\u018a\5B\"\2\u0189\u0187"+
		"\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u0185\3\2\2\2\u018e\u018f\3\2"+
		"\2\2\u018f\u0190\3\2\2\2\u0190\u0193\b\16\1\2\u0191\u0192\7\b\2\2\u0192"+
		"\u0194\7\u008d\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195"+
		"\3\2\2\2\u0195\u01aa\b\16\1\2\u0196\u01a5\7\4\2\2\u0197\u0198\5\60\31"+
		"\2\u0198\u0199\b\16\1\2\u0199\u01a4\3\2\2\2\u019a\u019b\5\"\22\2\u019b"+
		"\u019c\b\16\1\2\u019c\u01a4\3\2\2\2\u019d\u019e\5\34\17\2\u019e\u019f"+
		"\b\16\1\2\u019f\u01a4\3\2\2\2\u01a0\u01a1\5P)\2\u01a1\u01a2\b\16\1\2\u01a2"+
		"\u01a4\3\2\2\2\u01a3\u0197\3\2\2\2\u01a3\u019a\3\2\2\2\u01a3\u019d\3\2"+
		"\2\2\u01a3\u01a0\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5"+
		"\u01a6\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01ab\7\6"+
		"\2\2\u01a9\u01ab\7\25\2\2\u01aa\u0196\3\2\2\2\u01aa\u01a9\3\2\2\2\u01ab"+
		"\u01ac\3\2\2\2\u01ac\u01ad\b\16\1\2\u01ad\33\3\2\2\2\u01ae\u01af\5\36"+
		"\20\2\u01af\u01b0\b\17\1\2\u01b0\u01b5\3\2\2\2\u01b1\u01b2\5 \21\2\u01b2"+
		"\u01b3\b\17\1\2\u01b3\u01b5\3\2\2\2\u01b4\u01ae\3\2\2\2\u01b4\u01b1\3"+
		"\2\2\2\u01b5\35\3\2\2\2\u01b6\u01b8\5Z.\2\u01b7\u01b6\3\2\2\2\u01b7\u01b8"+
		"\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bb\b\20\1\2\u01ba\u01bc\7\34\2\2"+
		"\u01bb\u01ba\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01c0"+
		"\7\35\2\2\u01be\u01c0\7\36\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01be\3\2\2\2"+
		"\u01bf\u01c0\3\2\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01c3\7\37\2\2\u01c2\u01c1"+
		"\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c6\7 \2\2\u01c5"+
		"\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01ca\7!"+
		"\2\2\u01c8\u01ca\7\"\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01c8\3\2\2\2\u01c9"+
		"\u01ca\3\2\2\2\u01ca\u01cc\3\2\2\2\u01cb\u01cd\7#\2\2\u01cc\u01cb\3\2"+
		"\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\7$\2\2\u01cf"+
		"\u01d0\5x=\2\u01d0\u01d1\b\20\1\2\u01d1\u01d2\b\20\1\2\u01d2\u01d3\7\b"+
		"\2\2\u01d3\u01d5\5B\"\2\u01d4\u01d6\5&\24\2\u01d5\u01d4\3\2\2\2\u01d5"+
		"\u01d6\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01da\b\20\1\2\u01d8\u01d9\7"+
		"\27\2\2\u01d9\u01db\7\u008d\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2"+
		"\2\u01db\u01dc\3\2\2\2\u01dc\u01f0\b\20\1\2\u01dd\u01eb\7\4\2\2\u01de"+
		"\u01e7\7%\2\2\u01df\u01e7\7&\2\2\u01e0\u01e7\7\'\2\2\u01e1\u01e7\7(\2"+
		"\2\u01e2\u01e7\7)\2\2\u01e3\u01e7\7*\2\2\u01e4\u01e7\7+\2\2\u01e5\u01e7"+
		"\7,\2\2\u01e6\u01de\3\2\2\2\u01e6\u01df\3\2\2\2\u01e6\u01e0\3\2\2\2\u01e6"+
		"\u01e1\3\2\2\2\u01e6\u01e2\3\2\2\2\u01e6\u01e3\3\2\2\2\u01e6\u01e4\3\2"+
		"\2\2\u01e6\u01e5\3\2\2\2\u01e7\u01e9\3\2\2\2\u01e8\u01ea\7\5\2\2\u01e9"+
		"\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\3\2\2\2\u01eb\u01e6\3\2"+
		"\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee"+
		"\u01ef\3\2\2\2\u01ef\u01f1\7\6\2\2\u01f0\u01dd\3\2\2\2\u01f0\u01f1\3\2"+
		"\2\2\u01f1\u020d\3\2\2\2\u01f2\u01f8\7\4\2\2\u01f3\u01f4\5\60\31\2\u01f4"+
		"\u01f5\b\20\1\2\u01f5\u01f7\3\2\2\2\u01f6\u01f3\3\2\2\2\u01f7\u01fa\3"+
		"\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u0201\3\2\2\2\u01fa"+
		"\u01f8\3\2\2\2\u01fb\u01fc\5X-\2\u01fc\u01fd\b\20\1\2\u01fd\u0202\3\2"+
		"\2\2\u01fe\u01ff\5V,\2\u01ff\u0200\b\20\1\2\u0200\u0202\3\2\2\2\u0201"+
		"\u01fb\3\2\2\2\u0201\u01fe\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0208\3\2"+
		"\2\2\u0203\u0204\5\60\31\2\u0204\u0205\b\20\1\2\u0205\u0207\3\2\2\2\u0206"+
		"\u0203\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2"+
		"\2\2\u0209\u020b\3\2\2\2\u020a\u0208\3\2\2\2\u020b\u020e\7\6\2\2\u020c"+
		"\u020e\7\25\2\2\u020d\u01f2\3\2\2\2\u020d\u020c\3\2\2\2\u020e\u020f\3"+
		"\2\2\2\u020f\u0210\b\20\1\2\u0210\u0211\b\20\1\2\u0211\37\3\2\2\2\u0212"+
		"\u0214\5Z.\2\u0213\u0212\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2"+
		"\2\u0215\u0217\b\21\1\2\u0216\u0218\7\34\2\2\u0217\u0216\3\2\2\2\u0217"+
		"\u0218\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u021c\7\35\2\2\u021a\u021c\7"+
		"\36\2\2\u021b\u0219\3\2\2\2\u021b\u021a\3\2\2\2\u021b\u021c\3\2\2\2\u021c"+
		"\u021e\3\2\2\2\u021d\u021f\7\37\2\2\u021e\u021d\3\2\2\2\u021e\u021f\3"+
		"\2\2\2\u021f\u0221\3\2\2\2\u0220\u0222\7 \2\2\u0221\u0220\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0226\7!\2\2\u0224\u0226\7\""+
		"\2\2\u0225\u0223\3\2\2\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226"+
		"\u0228\3\2\2\2\u0227\u0229\7#\2\2\u0228\u0227\3\2\2\2\u0228\u0229\3\2"+
		"\2\2\u0229\u022a\3\2\2\2\u022a\u022b\7-\2\2\u022b\u022c\5x=\2\u022c\u022d"+
		"\b\21\1\2\u022d\u0230\b\21\1\2\u022e\u022f\7.\2\2\u022f\u0231\5x=\2\u0230"+
		"\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\b\21"+
		"\1\2\u0233\u0234\7\b\2\2\u0234\u0236\5B\"\2\u0235\u0237\5&\24\2\u0236"+
		"\u0235\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u023b\b\21"+
		"\1\2\u0239\u023a\7\27\2\2\u023a\u023c\7\u008d\2\2\u023b\u0239\3\2\2\2"+
		"\u023b\u023c\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u0253\b\21\1\2\u023e\u024e"+
		"\7\4\2\2\u023f\u024a\7/\2\2\u0240\u024a\7%\2\2\u0241\u024a\7\'\2\2\u0242"+
		"\u024a\7(\2\2\u0243\u024a\7)\2\2\u0244\u024a\7*\2\2\u0245\u024a\7\60\2"+
		"\2\u0246\u024a\7\61\2\2\u0247\u024a\7+\2\2\u0248\u024a\7,\2\2\u0249\u023f"+
		"\3\2\2\2\u0249\u0240\3\2\2\2\u0249\u0241\3\2\2\2\u0249\u0242\3\2\2\2\u0249"+
		"\u0243\3\2\2\2\u0249\u0244\3\2\2\2\u0249\u0245\3\2\2\2\u0249\u0246\3\2"+
		"\2\2\u0249\u0247\3\2\2\2\u0249\u0248\3\2\2\2\u024a\u024c\3\2\2\2\u024b"+
		"\u024d\7\5\2\2\u024c\u024b\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024f\3\2"+
		"\2\2\u024e\u0249\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u024e\3\2\2\2\u0250"+
		"\u0251\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0254\7\6\2\2\u0253\u023e\3\2"+
		"\2\2\u0253\u0254\3\2\2\2\u0254\u027d\3\2\2\2\u0255\u0261\7\4\2\2\u0256"+
		"\u0257\7\62\2\2\u0257\u025c\5x=\2\u0258\u0259\7\5\2\2\u0259\u025b\5x="+
		"\2\u025a\u0258\3\2\2\2\u025b\u025e\3\2\2\2\u025c\u025a\3\2\2\2\u025c\u025d"+
		"\3\2\2\2\u025d\u025f\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0260\7\25\2\2"+
		"\u0260\u0262\3\2\2\2\u0261\u0256\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0268"+
		"\3\2\2\2\u0263\u0264\5\60\31\2\u0264\u0265\b\21\1\2\u0265\u0267\3\2\2"+
		"\2\u0266\u0263\3\2\2\2\u0267\u026a\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269"+
		"\3\2\2\2\u0269\u0271\3\2\2\2\u026a\u0268\3\2\2\2\u026b\u026c\5X-\2\u026c"+
		"\u026d\b\21\1\2\u026d\u0272\3\2\2\2\u026e\u026f\5V,\2\u026f\u0270\b\21"+
		"\1\2\u0270\u0272\3\2\2\2\u0271\u026b\3\2\2\2\u0271\u026e\3\2\2\2\u0271"+
		"\u0272\3\2\2\2\u0272\u0278\3\2\2\2\u0273\u0274\5\60\31\2\u0274\u0275\b"+
		"\21\1\2\u0275\u0277\3\2\2\2\u0276\u0273\3\2\2\2\u0277\u027a\3\2\2\2\u0278"+
		"\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027b\3\2\2\2\u027a\u0278\3\2"+
		"\2\2\u027b\u027e\7\6\2\2\u027c\u027e\7\25\2\2\u027d\u0255\3\2\2\2\u027d"+
		"\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0280\b\21\1\2\u0280\u0281\b"+
		"\21\1\2\u0281!\3\2\2\2\u0282\u0284\5Z.\2\u0283\u0282\3\2\2\2\u0283\u0284"+
		"\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0287\b\22\1\2\u0286\u0288\7\34\2\2"+
		"\u0287\u0286\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028b"+
		"\7\63\2\2\u028a\u028c\5<\37\2\u028b\u028a\3\2\2\2\u028b\u028c\3\2\2\2"+
		"\u028c\u028d\3\2\2\2\u028d\u028e\b\22\1\2\u028e\u028f\5x=\2\u028f\u0290"+
		"\b\22\1\2\u0290\u0291\b\22\1\2\u0291\u029a\7\21\2\2\u0292\u0297\5$\23"+
		"\2\u0293\u0294\7\5\2\2\u0294\u0296\5$\23\2\u0295\u0293\3\2\2\2\u0296\u0299"+
		"\3\2\2\2\u0297\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u029b\3\2\2\2\u0299"+
		"\u0297\3\2\2\2\u029a\u0292\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029c\3\2"+
		"\2\2\u029c\u029d\7\22\2\2\u029d\u02a3\b\22\1\2\u029e\u029f\7\b\2\2\u029f"+
		"\u02a1\5B\"\2\u02a0\u02a2\5&\24\2\u02a1\u02a0\3\2\2\2\u02a1\u02a2\3\2"+
		"\2\2\u02a2\u02a4\3\2\2\2\u02a3\u029e\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4"+
		"\u02a5\3\2\2\2\u02a5\u02af\b\22\1\2\u02a6\u02a7\7\64\2\2\u02a7\u02ac\5"+
		"B\"\2\u02a8\u02a9\7\5\2\2\u02a9\u02ab\5B\"\2\u02aa\u02a8\3\2\2\2\u02ab"+
		"\u02ae\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02b0\3\2"+
		"\2\2\u02ae\u02ac\3\2\2\2\u02af\u02a6\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0"+
		"\u02b1\3\2\2\2\u02b1\u02c1\b\22\1\2\u02b2\u02bc\7\4\2\2\u02b3\u02b8\7"+
		"\'\2\2\u02b4\u02b8\7(\2\2\u02b5\u02b8\7)\2\2\u02b6\u02b8\7*\2\2\u02b7"+
		"\u02b3\3\2\2\2\u02b7\u02b4\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b7\u02b6\3\2"+
		"\2\2\u02b8\u02ba\3\2\2\2\u02b9\u02bb\7\5\2\2\u02ba\u02b9\3\2\2\2\u02ba"+
		"\u02bb\3\2\2\2\u02bb\u02bd\3\2\2\2\u02bc\u02b7\3\2\2\2\u02bd\u02be\3\2"+
		"\2\2\u02be\u02bc\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0"+
		"\u02c2\7\6\2\2\u02c1\u02b2\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02d7\3\2"+
		"\2\2\u02c3\u02d2\7\4\2\2\u02c4\u02c5\5\60\31\2\u02c5\u02c6\b\22\1\2\u02c6"+
		"\u02d1\3\2\2\2\u02c7\u02c8\5R*\2\u02c8\u02c9\b\22\1\2\u02c9\u02d1\3\2"+
		"\2\2\u02ca\u02cb\5N(\2\u02cb\u02cc\b\22\1\2\u02cc\u02d1\3\2\2\2\u02cd"+
		"\u02ce\5T+\2\u02ce\u02cf\b\22\1\2\u02cf\u02d1\3\2\2\2\u02d0\u02c4\3\2"+
		"\2\2\u02d0\u02c7\3\2\2\2\u02d0\u02ca\3\2\2\2\u02d0\u02cd\3\2\2\2\u02d1"+
		"\u02d4\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d5\3\2"+
		"\2\2\u02d4\u02d2\3\2\2\2\u02d5\u02d8\7\6\2\2\u02d6\u02d8\7\25\2\2\u02d7"+
		"\u02c3\3\2\2\2\u02d7\u02d6\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\b\22"+
		"\1\2\u02da\u02db\b\22\1\2\u02db#\3\2\2\2\u02dc\u02df\7!\2\2\u02dd\u02df"+
		"\7\"\2\2\u02de\u02dc\3\2\2\2\u02de\u02dd\3\2\2\2\u02de\u02df\3\2\2\2\u02df"+
		"\u02e0\3\2\2\2\u02e0\u02e1\5x=\2\u02e1\u02e2\b\23\1\2\u02e2\u02e3\b\23"+
		"\1\2\u02e3\u02e4\7\b\2\2\u02e4\u02e6\5B\"\2\u02e5\u02e7\5&\24\2\u02e6"+
		"\u02e5\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02f8\b\23"+
		"\1\2\u02e9\u02f3\7\4\2\2\u02ea\u02ef\7\'\2\2\u02eb\u02ef\7(\2\2\u02ec"+
		"\u02ef\7)\2\2\u02ed\u02ef\7*\2\2\u02ee\u02ea\3\2\2\2\u02ee\u02eb\3\2\2"+
		"\2\u02ee\u02ec\3\2\2\2\u02ee\u02ed\3\2\2\2\u02ef\u02f1\3\2\2\2\u02f0\u02f2"+
		"\7\5\2\2\u02f1\u02f0\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f4\3\2\2\2\u02f3"+
		"\u02ee\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f5\u02f6\3\2"+
		"\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f9\7\6\2\2\u02f8\u02e9\3\2\2\2\u02f8"+
		"\u02f9\3\2\2\2\u02f9\u0303\3\2\2\2\u02fa\u02fe\7\4\2\2\u02fb\u02fd\5\60"+
		"\31\2\u02fc\u02fb\3\2\2\2\u02fd\u0300\3\2\2\2\u02fe\u02fc\3\2\2\2\u02fe"+
		"\u02ff\3\2\2\2\u02ff\u0301\3\2\2\2\u0300\u02fe\3\2\2\2\u0301\u0302\b\23"+
		"\1\2\u0302\u0304\7\6\2\2\u0303\u02fa\3\2\2\2\u0303\u0304\3\2\2\2\u0304"+
		"\u0305\3\2\2\2\u0305\u0306\b\23\1\2\u0306\u0307\b\23\1\2\u0307%\3\2\2"+
		"\2\u0308\u030f\7\r\2\2\u0309\u030c\5~@\2\u030a\u030b\7\20\2\2\u030b\u030d"+
		"\5|?\2\u030c\u030a\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u0310\3\2\2\2\u030e"+
		"\u0310\t\2\2\2\u030f\u0309\3\2\2\2\u030f\u030e\3\2\2\2\u0310\u0313\3\2"+
		"\2\2\u0311\u0314\78\2\2\u0312\u0314\79\2\2\u0313\u0311\3\2\2\2\u0313\u0312"+
		"\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0316\7\16\2\2"+
		"\u0316\u0317\b\24\1\2\u0317\'\3\2\2\2\u0318\u031a\5Z.\2\u0319\u0318\3"+
		"\2\2\2\u0319\u031a\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u0321\b\25\1\2\u031c"+
		"\u0322\7:\2\2\u031d\u0320\7!\2\2\u031e\u0320\7\"\2\2\u031f\u031d\3\2\2"+
		"\2\u031f\u031e\3\2\2\2\u0320\u0322\3\2\2\2\u0321\u031c\3\2\2\2\u0321\u031f"+
		"\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0324\7;\2\2\u0324"+
		"\u0325\5x=\2\u0325\u0326\b\25\1\2\u0326\u0328\b\25\1\2\u0327\u0329\5<"+
		"\37\2\u0328\u0327\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032a\3\2\2\2\u032a"+
		"\u032d\b\25\1\2\u032b\u032c\7\b\2\2\u032c\u032e\7\u008d\2\2\u032d\u032b"+
		"\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0336\b\25\1\2"+
		"\u0330\u0333\7\4\2\2\u0331\u0334\7<\2\2\u0332\u0334\7=\2\2\u0333\u0331"+
		"\3\2\2\2\u0333\u0332\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u0335\3\2\2\2\u0335"+
		"\u0337\7\6\2\2\u0336\u0330\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u0346\3\2"+
		"\2\2\u0338\u0341\7\4\2\2\u0339\u033a\5\60\31\2\u033a\u033b\b\25\1\2\u033b"+
		"\u0340\3\2\2\2\u033c\u033d\5P)\2\u033d\u033e\b\25\1\2\u033e\u0340\3\2"+
		"\2\2\u033f\u0339\3\2\2\2\u033f\u033c\3\2\2\2\u0340\u0343\3\2\2\2\u0341"+
		"\u033f\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0344\3\2\2\2\u0343\u0341\3\2"+
		"\2\2\u0344\u0347\7\6\2\2\u0345\u0347\7\25\2\2\u0346\u0338\3\2\2\2\u0346"+
		"\u0345\3\2\2\2\u0347\u0348\3\2\2\2\u0348\u0349\b\25\1\2\u0349\u034a\b"+
		"\25\1\2\u034a)\3\2\2\2\u034b\u034c\t\3\2\2\u034c+\3\2\2\2\u034d\u034f"+
		"\5Z.\2\u034e\u034d\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0350\3\2\2\2\u0350"+
		"\u0351\b\27\1\2\u0351\u0352\7C\2\2\u0352\u0353\5x=\2\u0353\u0354\b\27"+
		"\1\2\u0354\u0356\b\27\1\2\u0355\u0357\5<\37\2\u0356\u0355\3\2\2\2\u0356"+
		"\u0357\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035b\b\27\1\2\u0359\u035a\7"+
		"\b\2\2\u035a\u035c\7\u008d\2\2\u035b\u0359\3\2\2\2\u035b\u035c\3\2\2\2"+
		"\u035c\u035d\3\2\2\2\u035d\u0364\b\27\1\2\u035e\u0361\7\4\2\2\u035f\u0362"+
		"\7<\2\2\u0360\u0362\7=\2\2\u0361\u035f\3\2\2\2\u0361\u0360\3\2\2\2\u0361"+
		"\u0362\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0365\7\6\2\2\u0364\u035e\3\2"+
		"\2\2\u0364\u0365\3\2\2\2\u0365\u0377\3\2\2\2\u0366\u0372\7\4\2\2\u0367"+
		"\u0368\5\60\31\2\u0368\u0369\b\27\1\2\u0369\u0371\3\2\2\2\u036a\u036b"+
		"\5.\30\2\u036b\u036c\b\27\1\2\u036c\u0371\3\2\2\2\u036d\u036e\5P)\2\u036e"+
		"\u036f\b\27\1\2\u036f\u0371\3\2\2\2\u0370\u0367\3\2\2\2\u0370\u036a\3"+
		"\2\2\2\u0370\u036d\3\2\2\2\u0371\u0374\3\2\2\2\u0372\u0370\3\2\2\2\u0372"+
		"\u0373\3\2\2\2\u0373\u0375\3\2\2\2\u0374\u0372\3\2\2\2\u0375\u0378\7\6"+
		"\2\2\u0376\u0378\7\25\2\2\u0377\u0366\3\2\2\2\u0377\u0376\3\2\2\2\u0378"+
		"\u0379\3\2\2\2\u0379\u037a\b\27\1\2\u037a\u037b\b\27\1\2\u037b-\3\2\2"+
		"\2\u037c\u037d\7D\2\2\u037d\u0380\5x=\2\u037e\u0380\5x=\2\u037f\u037c"+
		"\3\2\2\2\u037f\u037e\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0382\b\30\1\2"+
		"\u0382\u0385\b\30\1\2\u0383\u0384\7\27\2\2\u0384\u0386\5\u0080A\2\u0385"+
		"\u0383\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0387\3\2\2\2\u0387\u0392\b\30"+
		"\1\2\u0388\u038c\7\4\2\2\u0389\u038b\5\60\31\2\u038a\u0389\3\2\2\2\u038b"+
		"\u038e\3\2\2\2\u038c\u038a\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u038f\3\2"+
		"\2\2\u038e\u038c\3\2\2\2\u038f\u0390\b\30\1\2\u0390\u0393\7\6\2\2\u0391"+
		"\u0393\7\25\2\2\u0392\u0388\3\2\2\2\u0392\u0391\3\2\2\2\u0393\u0394\3"+
		"\2\2\2\u0394\u0395\b\30\1\2\u0395/\3\2\2\2\u0396\u0398\7E\2\2\u0397\u0399"+
		"\7\u008d\2\2\u0398\u0397\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u039a\3\2\2"+
		"\2\u039a\u039b\b\31\1\2\u039b\u03a7\b\31\1\2\u039c\u039d\7\21\2\2\u039d"+
		"\u03a2\5\62\32\2\u039e\u039f\7\5\2\2\u039f\u03a1\5\62\32\2\u03a0\u039e"+
		"\3\2\2\2\u03a1\u03a4\3\2\2\2\u03a2\u03a0\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3"+
		"\u03a5\3\2\2\2\u03a4\u03a2\3\2\2\2\u03a5\u03a6\7\22\2\2\u03a6\u03a8\3"+
		"\2\2\2\u03a7\u039c\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9"+
		"\u03bb\b\31\1\2\u03aa\u03b4\7\4\2\2\u03ab\u03ac\5\60\31\2\u03ac\u03ad"+
		"\b\31\1\2\u03ad\u03b5\3\2\2\2\u03ae\u03af\5\64\33\2\u03af\u03b0\b\31\1"+
		"\2\u03b0\u03b5\3\2\2\2\u03b1\u03b2\5:\36\2\u03b2\u03b3\b\31\1\2\u03b3"+
		"\u03b5\3\2\2\2\u03b4\u03ab\3\2\2\2\u03b4\u03ae\3\2\2\2\u03b4\u03b1\3\2"+
		"\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03b4\3\2\2\2\u03b6\u03b7\3\2\2\2\u03b7"+
		"\u03b8\3\2\2\2\u03b8\u03b9\7\6\2\2\u03b9\u03bc\3\2\2\2\u03ba\u03bc\7\25"+
		"\2\2\u03bb\u03aa\3\2\2\2\u03bb\u03ba\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd"+
		"\u03be\b\31\1\2\u03be\61\3\2\2\2\u03bf\u03c1\7\u008d\2\2\u03c0\u03bf\3"+
		"\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c4\7\27\2\2\u03c3"+
		"\u03c5\t\4\2\2\u03c4\u03c3\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u03c6\3\2"+
		"\2\2\u03c6\u03c7\b\32\1\2\u03c7\63\3\2\2\2\u03c8\u03c9\5\60\31\2\u03c9"+
		"\u03ca\b\33\1\2\u03ca\u03cf\3\2\2\2\u03cb\u03cc\5\66\34\2\u03cc\u03cd"+
		"\b\33\1\2\u03cd\u03cf\3\2\2\2\u03ce\u03c8\3\2\2\2\u03ce\u03cb\3\2\2\2"+
		"\u03cf\65\3\2\2\2\u03d0\u03d1\58\35\2\u03d1\u03d2\b\34\1\2\u03d2\u03dd"+
		"\3\2\2\2\u03d3\u03d4\5\30\r\2\u03d4\u03d5\b\34\1\2\u03d5\u03dd\3\2\2\2"+
		"\u03d6\u03d7\5\26\f\2\u03d7\u03d8\b\34\1\2\u03d8\u03dd\3\2\2\2\u03d9\u03da"+
		"\5.\30\2\u03da\u03db\b\34\1\2\u03db\u03dd\3\2\2\2\u03dc\u03d0\3\2\2\2"+
		"\u03dc\u03d3\3\2\2\2\u03dc\u03d6\3\2\2\2\u03dc\u03d9\3\2\2\2\u03dd\67"+
		"\3\2\2\2\u03de\u03df\5\"\22\2\u03df\u03e0\b\35\1\2\u03e0\u03e8\3\2\2\2"+
		"\u03e1\u03e2\5$\23\2\u03e2\u03e3\b\35\1\2\u03e3\u03e8\3\2\2\2\u03e4\u03e5"+
		"\5\34\17\2\u03e5\u03e6\b\35\1\2\u03e6\u03e8\3\2\2\2\u03e7\u03de\3\2\2"+
		"\2\u03e7\u03e1\3\2\2\2\u03e7\u03e4\3\2\2\2\u03e89\3\2\2\2\u03e9\u03ea"+
		"\7F\2\2\u03ea\u03eb\5L\'\2\u03eb\u03ec\7\25\2\2\u03ec;\3\2\2\2\u03ed\u03ee"+
		"\7G\2\2\u03ee\u03f3\5> \2\u03ef\u03f0\7\5\2\2\u03f0\u03f2\5> \2\u03f1"+
		"\u03ef\3\2\2\2\u03f2\u03f5\3\2\2\2\u03f3\u03f1\3\2\2\2\u03f3\u03f4\3\2"+
		"\2\2\u03f4\u03f6\3\2\2\2\u03f5\u03f3\3\2\2\2\u03f6\u03f7\7H\2\2\u03f7"+
		"=\3\2\2\2\u03f8\u0402\5x=\2\u03f9\u03fa\7\33\2\2\u03fa\u03ff\5B\"\2\u03fb"+
		"\u03fc\7I\2\2\u03fc\u03fe\5B\"\2\u03fd\u03fb\3\2\2\2\u03fe\u0401\3\2\2"+
		"\2\u03ff\u03fd\3\2\2\2\u03ff\u0400\3\2\2\2\u0400\u0403\3\2\2\2\u0401\u03ff"+
		"\3\2\2\2\u0402\u03f9\3\2\2\2\u0402\u0403\3\2\2\2\u0403?\3\2\2\2\u0404"+
		"\u0407\5B\"\2\u0405\u0407\5F$\2\u0406\u0404\3\2\2\2\u0406\u0405\3\2\2"+
		"\2\u0407A\3\2\2\2\u0408\u040b\5*\26\2\u0409\u040b\5D#\2\u040a\u0408\3"+
		"\2\2\2\u040a\u0409\3\2\2\2\u040bC\3\2\2\2\u040c\u0411\5L\'\2\u040d\u040e"+
		"\7G\2\2\u040e\u040f\5H%\2\u040f\u0410\7H\2\2\u0410\u0412\3\2\2\2\u0411"+
		"\u040d\3\2\2\2\u0411\u0412\3\2\2\2\u0412E\3\2\2\2\u0413\u0416\7\67\2\2"+
		"\u0414\u0415\t\5\2\2\u0415\u0417\5B\"\2\u0416\u0414\3\2\2\2\u0416\u0417"+
		"\3\2\2\2\u0417G\3\2\2\2\u0418\u041d\5J&\2\u0419\u041a\7\5\2\2\u041a\u041c"+
		"\5J&\2\u041b\u0419\3\2\2\2\u041c\u041f\3\2\2\2\u041d\u041b\3\2\2\2\u041d"+
		"\u041e\3\2\2\2\u041eI\3\2\2\2\u041f\u041d\3\2\2\2\u0420\u0421\5@!\2\u0421"+
		"K\3\2\2\2\u0422\u0427\5x=\2\u0423\u0424\7K\2\2\u0424\u0426\5x=\2\u0425"+
		"\u0423\3\2\2\2\u0426\u0429\3\2\2\2\u0427\u0425\3\2\2\2\u0427\u0428\3\2"+
		"\2\2\u0428M\3\2\2\2\u0429\u0427\3\2\2\2\u042a\u042c\7L\2\2\u042b\u042d"+
		"\5z>\2\u042c\u042b\3\2\2\2\u042c\u042d\3\2\2\2\u042d\u042e\3\2\2\2\u042e"+
		"\u0435\b(\1\2\u042f\u0431\7\b\2\2\u0430\u0432\5b\62\2\u0431\u0430\3\2"+
		"\2\2\u0431\u0432\3\2\2\2\u0432\u0433\3\2\2\2\u0433\u0436\7\25\2\2\u0434"+
		"\u0436\7\25\2\2\u0435\u042f\3\2\2\2\u0435\u0434\3\2\2\2\u0436\u0437\3"+
		"\2\2\2\u0437\u0438\b(\1\2\u0438O\3\2\2\2\u0439\u043b\7M\2\2\u043a\u0439"+
		"\3\2\2\2\u043a\u043b\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u043d\b)\1\2\u043d"+
		"\u0444\7N\2\2\u043e\u0442\5z>\2\u043f\u0440\7\21\2\2\u0440\u0441\7\u008c"+
		"\2\2\u0441\u0443\7\22\2\2\u0442\u043f\3\2\2\2\u0442\u0443\3\2\2\2\u0443"+
		"\u0445\3\2\2\2\u0444\u043e\3\2\2\2\u0444\u0445\3\2\2\2\u0445\u0446\3\2"+
		"\2\2\u0446\u044d\b)\1\2\u0447\u0449\7\b\2\2\u0448\u044a\5`\61\2\u0449"+
		"\u0448\3\2\2\2\u0449\u044a\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u044e\7\25"+
		"\2\2\u044c\u044e\7\25\2\2\u044d\u0447\3\2\2\2\u044d\u044c\3\2\2\2\u044e"+
		"\u044f\3\2\2\2\u044f\u0450\b)\1\2\u0450Q\3\2\2\2\u0451\u0458\t\6\2\2\u0452"+
		"\u0456\5z>\2\u0453\u0454\7\21\2\2\u0454\u0455\7\u008c\2\2\u0455\u0457"+
		"\7\22\2\2\u0456\u0453\3\2\2\2\u0456\u0457\3\2\2\2\u0457\u0459\3\2\2\2"+
		"\u0458\u0452\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u045a\3\2\2\2\u045a\u0461"+
		"\b*\1\2\u045b\u045d\7\b\2\2\u045c\u045e\5`\61\2\u045d\u045c\3\2\2\2\u045d"+
		"\u045e\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0462\7\25\2\2\u0460\u0462\7"+
		"\25\2\2\u0461\u045b\3\2\2\2\u0461\u0460\3\2\2\2\u0462\u0463\3\2\2\2\u0463"+
		"\u0464\b*\1\2\u0464S\3\2\2\2\u0465\u046c\t\7\2\2\u0466\u046a\5z>\2\u0467"+
		"\u0468\7\21\2\2\u0468\u0469\7\u008c\2\2\u0469\u046b\7\22\2\2\u046a\u0467"+
		"\3\2\2\2\u046a\u046b\3\2\2\2\u046b\u046d\3\2\2\2\u046c\u0466\3\2\2\2\u046c"+
		"\u046d\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u0475\b+\1\2\u046f\u0471\7\b"+
		"\2\2\u0470\u0472\5`\61\2\u0471\u0470\3\2\2\2\u0471\u0472\3\2\2\2\u0472"+
		"\u0473\3\2\2\2\u0473\u0476\7\25\2\2\u0474\u0476\7\25\2\2\u0475\u046f\3"+
		"\2\2\2\u0475\u0474\3\2\2\2\u0476\u0477\3\2\2\2\u0477\u0478\b+\1\2\u0478"+
		"U\3\2\2\2\u0479\u047b\7S\2\2\u047a\u047c\5z>\2\u047b\u047a\3\2\2\2\u047b"+
		"\u047c\3\2\2\2\u047c\u047d\3\2\2\2\u047d\u0484\b,\1\2\u047e\u0480\7\b"+
		"\2\2\u047f\u0481\5b\62\2\u0480\u047f\3\2\2\2\u0480\u0481\3\2\2\2\u0481"+
		"\u0482\3\2\2\2\u0482\u0485\7\25\2\2\u0483\u0485\7\25\2\2\u0484\u047e\3"+
		"\2\2\2\u0484\u0483\3\2\2\2\u0485\u0486\3\2\2\2\u0486\u0487\b,\1\2\u0487"+
		"W\3\2\2\2\u0488\u048a\7T\2\2\u0489\u048b\5z>\2\u048a\u0489\3\2\2\2\u048a"+
		"\u048b\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u0493\b-\1\2\u048d\u048f\7\b"+
		"\2\2\u048e\u0490\5b\62\2\u048f\u048e\3\2\2\2\u048f\u0490\3\2\2\2\u0490"+
		"\u0491\3\2\2\2\u0491\u0494\7\25\2\2\u0492\u0494\7\25\2\2\u0493\u048d\3"+
		"\2\2\2\u0493\u0492\3\2\2\2\u0494\u0495\3\2\2\2\u0495\u0496\b-\1\2\u0496"+
		"Y\3\2\2\2\u0497\u049b\7U\2\2\u0498\u049b\7V\2\2\u0499\u049b\7W\2\2\u049a"+
		"\u0497\3\2\2\2\u049a\u0498\3\2\2\2\u049a\u0499\3\2\2\2\u049b\u049c\3\2"+
		"\2\2\u049c\u049d\b.\1\2\u049d[\3\2\2\2\u049e\u049f\7\u008b\2\2\u049f\u04a2"+
		"\b/\1\2\u04a0\u04a2\7\u008a\2\2\u04a1\u049e\3\2\2\2\u04a1\u04a0\3\2\2"+
		"\2\u04a2]\3\2\2\2\u04a3\u04a4\7\u008a\2\2\u04a4_\3\2\2\2\u04a5\u04a6\b"+
		"\61\1\2\u04a6\u04a7\7X\2\2\u04a7\u05ac\5b\62\2\u04a8\u04a9\7Y\2\2\u04a9"+
		"\u05ac\5b\62\2\u04aa\u04ab\7Z\2\2\u04ab\u05ac\5b\62\2\u04ac\u04ad\7[\2"+
		"\2\u04ad\u05ac\5b\62\2\u04ae\u04b0\5b\62\2\u04af\u04b1\t\b\2\2\u04b0\u04af"+
		"\3\2\2\2\u04b0\u04b1\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u04b3\7^\2\2\u04b3"+
		"\u04b4\5b\62\2\u04b4\u05ac\3\2\2\2\u04b5\u04b7\5b\62\2\u04b6\u04b8\t\b"+
		"\2\2\u04b7\u04b6\3\2\2\2\u04b7\u04b8\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9"+
		"\u04ba\7\27\2\2\u04ba\u04bb\5b\62\2\u04bb\u05ac\3\2\2\2\u04bc\u04be\5"+
		"d\63\2\u04bd\u04bf\t\b\2\2\u04be\u04bd\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf"+
		"\u04c0\3\2\2\2\u04c0\u04c1\7\27\2\2\u04c1\u04c2\5d\63\2\u04c2\u05ac\3"+
		"\2\2\2\u04c3\u04c5\5d\63\2\u04c4\u04c6\t\b\2\2\u04c5\u04c4\3\2\2\2\u04c5"+
		"\u04c6\3\2\2\2\u04c6\u04c7\3\2\2\2\u04c7\u04c8\7G\2\2\u04c8\u04c9\5d\63"+
		"\2\u04c9\u05ac\3\2\2\2\u04ca\u04cc\5d\63\2\u04cb\u04cd\t\b\2\2\u04cc\u04cb"+
		"\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04ce\3\2\2\2\u04ce\u04cf\7_\2\2\u04cf"+
		"\u04d0\5d\63\2\u04d0\u05ac\3\2\2\2\u04d1\u04d3\5d\63\2\u04d2\u04d4\t\b"+
		"\2\2\u04d3\u04d2\3\2\2\2\u04d3\u04d4\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5"+
		"\u04d6\7H\2\2\u04d6\u04d7\5d\63\2\u04d7\u05ac\3\2\2\2\u04d8\u04da\5d\63"+
		"\2\u04d9\u04db\t\b\2\2\u04da\u04d9\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u04dc"+
		"\3\2\2\2\u04dc\u04dd\7`\2\2\u04dd\u04de\5d\63\2\u04de\u05ac\3\2\2\2\u04df"+
		"\u04e0\b\61\1\2\u04e0\u04e1\7a\2\2\u04e1\u04e2\5f\64\2\u04e2\u04e3\7b"+
		"\2\2\u04e3\u04e4\5d\63\2\u04e4\u04e5\3\2\2\2\u04e5\u04e6\b\61\1\2\u04e6"+
		"\u05ac\3\2\2\2\u04e7\u04e8\7c\2\2\u04e8\u04e9\7\r\2\2\u04e9\u04ea\5r:"+
		"\2\u04ea\u04eb\7\16\2\2\u04eb\u05ac\3\2\2\2\u04ec\u04ed\7d\2\2\u04ed\u04ee"+
		"\7\r\2\2\u04ee\u04ef\5r:\2\u04ef\u04f0\7\b\2\2\u04f0\u04f1\5b\62\2\u04f1"+
		"\u04f2\7e\2\2\u04f2\u04f3\t\t\2\2\u04f3\u04f4\5b\62\2\u04f4\u04f5\7\16"+
		"\2\2\u04f5\u05ac\3\2\2\2\u04f6\u04f7\7f\2\2\u04f7\u04f8\7\r\2\2\u04f8"+
		"\u04f9\5r:\2\u04f9\u04fa\7\5\2\2\u04fa\u04fb\5r:\2\u04fb\u04fc\7\5\2\2"+
		"\u04fc\u04fd\5r:\2\u04fd\u04fe\7\5\2\2\u04fe\u04ff\5r:\2\u04ff\u0500\7"+
		"\16\2\2\u0500\u05ac\3\2\2\2\u0501\u0502\t\b\2\2\u0502\u05ac\5`\61\20\u0503"+
		"\u0504\b\61\1\2\u0504\u0505\7o\2\2\u0505\u051a\5f\64\2\u0506\u0510\7b"+
		"\2\2\u0507\u0511\5`\61\2\u0508\u050c\7\4\2\2\u0509\u050b\5`\61\2\u050a"+
		"\u0509\3\2\2\2\u050b\u050e\3\2\2\2\u050c\u050a\3\2\2\2\u050c\u050d\3\2"+
		"\2\2\u050d\u050f\3\2\2\2\u050e\u050c\3\2\2\2\u050f\u0511\7\6\2\2\u0510"+
		"\u0507\3\2\2\2\u0510\u0508\3\2\2\2\u0511\u051b\3\2\2\2\u0512\u0516\7\4"+
		"\2\2\u0513\u0515\5`\61\2\u0514\u0513\3\2\2\2\u0515\u0518\3\2\2\2\u0516"+
		"\u0514\3\2\2\2\u0516\u0517\3\2\2\2\u0517\u0519\3\2\2\2\u0518\u0516\3\2"+
		"\2\2\u0519\u051b\7\6\2\2\u051a\u0506\3\2\2\2\u051a\u0512\3\2\2\2\u051b"+
		"\u051c\3\2\2\2\u051c\u051d\b\61\1\2\u051d\u05ac\3\2\2\2\u051e\u051f\b"+
		"\61\1\2\u051f\u0520\7[\2\2\u0520\u0535\5f\64\2\u0521\u052b\7b\2\2\u0522"+
		"\u052c\5`\61\2\u0523\u0527\7\4\2\2\u0524\u0526\5`\61\2\u0525\u0524\3\2"+
		"\2\2\u0526\u0529\3\2\2\2\u0527\u0525\3\2\2\2\u0527\u0528\3\2\2\2\u0528"+
		"\u052a\3\2\2\2\u0529\u0527\3\2\2\2\u052a\u052c\7\6\2\2\u052b\u0522\3\2"+
		"\2\2\u052b\u0523\3\2\2\2\u052c\u0536\3\2\2\2\u052d\u0531\7\4\2\2\u052e"+
		"\u0530\5`\61\2\u052f\u052e\3\2\2\2\u0530\u0533\3\2\2\2\u0531\u052f\3\2"+
		"\2\2\u0531\u0532\3\2\2\2\u0532\u0534\3\2\2\2\u0533\u0531\3\2\2\2\u0534"+
		"\u0536\7\6\2\2\u0535\u0521\3\2\2\2\u0535\u052d\3\2\2\2\u0536\u0537\3\2"+
		"\2\2\u0537\u0538\b\61\1\2\u0538\u05ac\3\2\2\2\u0539\u053a\b\61\1\2\u053a"+
		"\u053b\7X\2\2\u053b\u0550\5f\64\2\u053c\u0546\7b\2\2\u053d\u0547\5`\61"+
		"\2\u053e\u0542\7\4\2\2\u053f\u0541\5`\61\2\u0540\u053f\3\2\2\2\u0541\u0544"+
		"\3\2\2\2\u0542\u0540\3\2\2\2\u0542\u0543\3\2\2\2\u0543\u0545\3\2\2\2\u0544"+
		"\u0542\3\2\2\2\u0545\u0547\7\6\2\2\u0546\u053d\3\2\2\2\u0546\u053e\3\2"+
		"\2\2\u0547\u0551\3\2\2\2\u0548\u054c\7\4\2\2\u0549\u054b\5`\61\2\u054a"+
		"\u0549\3\2\2\2\u054b\u054e\3\2\2\2\u054c\u054a\3\2\2\2\u054c\u054d\3\2"+
		"\2\2\u054d\u054f\3\2\2\2\u054e\u054c\3\2\2\2\u054f\u0551\7\6\2\2\u0550"+
		"\u053c\3\2\2\2\u0550\u0548\3\2\2\2\u0551\u0552\3\2\2\2\u0552\u0553\b\61"+
		"\1\2\u0553\u05ac\3\2\2\2\u0554\u0555\b\61\1\2\u0555\u0556\7Z\2\2\u0556"+
		"\u056b\5f\64\2\u0557\u0561\7b\2\2\u0558\u0562\5`\61\2\u0559\u055d\7\4"+
		"\2\2\u055a\u055c\5`\61\2\u055b\u055a\3\2\2\2\u055c\u055f\3\2\2\2\u055d"+
		"\u055b\3\2\2\2\u055d\u055e\3\2\2\2\u055e\u0560\3\2\2\2\u055f\u055d\3\2"+
		"\2\2\u0560\u0562\7\6\2\2\u0561\u0558\3\2\2\2\u0561\u0559\3\2\2\2\u0562"+
		"\u056c\3\2\2\2\u0563\u0567\7\4\2\2\u0564\u0566\5`\61\2\u0565\u0564\3\2"+
		"\2\2\u0566\u0569\3\2\2\2\u0567\u0565\3\2\2\2\u0567\u0568\3\2\2\2\u0568"+
		"\u056a\3\2\2\2\u0569\u0567\3\2\2\2\u056a\u056c\7\6\2\2\u056b\u0557\3\2"+
		"\2\2\u056b\u0563\3\2\2\2\u056c\u056d\3\2\2\2\u056d\u056e\b\61\1\2\u056e"+
		"\u05ac\3\2\2\2\u056f\u0570\b\61\1\2\u0570\u0571\7Y\2\2\u0571\u0586\5f"+
		"\64\2\u0572\u057c\7b\2\2\u0573\u057d\5`\61\2\u0574\u0578\7\4\2\2\u0575"+
		"\u0577\5`\61\2\u0576\u0575\3\2\2\2\u0577\u057a\3\2\2\2\u0578\u0576\3\2"+
		"\2\2\u0578\u0579\3\2\2\2\u0579\u057b\3\2\2\2\u057a\u0578\3\2\2\2\u057b"+
		"\u057d\7\6\2\2\u057c\u0573\3\2\2\2\u057c\u0574\3\2\2\2\u057d\u0587\3\2"+
		"\2\2\u057e\u0582\7\4\2\2\u057f\u0581\5`\61\2\u0580\u057f\3\2\2\2\u0581"+
		"\u0584\3\2\2\2\u0582\u0580\3\2\2\2\u0582\u0583\3\2\2\2\u0583\u0585\3\2"+
		"\2\2\u0584\u0582\3\2\2\2\u0585\u0587\7\6\2\2\u0586\u0572\3\2\2\2\u0586"+
		"\u057e\3\2\2\2\u0587\u0588\3\2\2\2\u0588\u0589\b\61\1\2\u0589\u05ac\3"+
		"\2\2\2\u058a\u058b\b\61\1\2\u058b\u058c\7p\2\2\u058c\u05a1\5j\66\2\u058d"+
		"\u0597\7b\2\2\u058e\u0598\5`\61\2\u058f\u0593\7\4\2\2\u0590\u0592\5`\61"+
		"\2\u0591\u0590\3\2\2\2\u0592\u0595\3\2\2\2\u0593\u0591\3\2\2\2\u0593\u0594"+
		"\3\2\2\2\u0594\u0596\3\2\2\2\u0595\u0593\3\2\2\2\u0596\u0598\7\6\2\2\u0597"+
		"\u058e\3\2\2\2\u0597\u058f\3\2\2\2\u0598\u05a2\3\2\2\2\u0599\u059d\7\4"+
		"\2\2\u059a\u059c\5`\61\2\u059b\u059a\3\2\2\2\u059c\u059f\3\2\2\2\u059d"+
		"\u059b\3\2\2\2\u059d\u059e\3\2\2\2\u059e\u05a0\3\2\2\2\u059f\u059d\3\2"+
		"\2\2\u05a0\u05a2\7\6\2\2\u05a1\u058d\3\2\2\2\u05a1\u0599\3\2\2\2\u05a2"+
		"\u05a3\3\2\2\2\u05a3\u05a4\b\61\1\2\u05a4\u05ac\3\2\2\2\u05a5\u05ac\7"+
		"q\2\2\u05a6\u05ac\7r\2\2\u05a7\u05a8\7\21\2\2\u05a8\u05a9\5`\61\2\u05a9"+
		"\u05aa\7\22\2\2\u05aa\u05ac\3\2\2\2\u05ab\u04a5\3\2\2\2\u05ab\u04a8\3"+
		"\2\2\2\u05ab\u04aa\3\2\2\2\u05ab\u04ac\3\2\2\2\u05ab\u04ae\3\2\2\2\u05ab"+
		"\u04b5\3\2\2\2\u05ab\u04bc\3\2\2\2\u05ab\u04c3\3\2\2\2\u05ab\u04ca\3\2"+
		"\2\2\u05ab\u04d1\3\2\2\2\u05ab\u04d8\3\2\2\2\u05ab\u04df\3\2\2\2\u05ab"+
		"\u04e7\3\2\2\2\u05ab\u04ec\3\2\2\2\u05ab\u04f6\3\2\2\2\u05ab\u0501\3\2"+
		"\2\2\u05ab\u0503\3\2\2\2\u05ab\u051e\3\2\2\2\u05ab\u0539\3\2\2\2\u05ab"+
		"\u0554\3\2\2\2\u05ab\u056f\3\2\2\2\u05ab\u058a\3\2\2\2\u05ab\u05a5\3\2"+
		"\2\2\u05ab\u05a6\3\2\2\2\u05ab\u05a7\3\2\2\2\u05ac\u05bb\3\2\2\2\u05ad"+
		"\u05ae\f\17\2\2\u05ae\u05af\t\n\2\2\u05af\u05ba\5`\61\17\u05b0\u05b1\f"+
		"\16\2\2\u05b1\u05b2\t\13\2\2\u05b2\u05ba\5`\61\16\u05b3\u05b4\f\r\2\2"+
		"\u05b4\u05b5\t\f\2\2\u05b5\u05ba\5`\61\r\u05b6\u05b7\f\f\2\2\u05b7\u05b8"+
		"\t\r\2\2\u05b8\u05ba\5`\61\f\u05b9\u05ad\3\2\2\2\u05b9\u05b0\3\2\2\2\u05b9"+
		"\u05b3\3\2\2\2\u05b9\u05b6\3\2\2\2\u05ba\u05bd\3\2\2\2\u05bb\u05b9\3\2"+
		"\2\2\u05bb\u05bc\3\2\2\2\u05bca\3\2\2\2\u05bd\u05bb\3\2\2\2\u05be\u05bf"+
		"\b\62\1\2\u05bf\u05c0\7s\2\2\u05c0\u05e4\5b\62\25\u05c1\u05c2\7t\2\2\u05c2"+
		"\u05e4\5b\62\24\u05c3\u05c4\7\65\2\2\u05c4\u05e4\5b\62\23\u05c5\u05c6"+
		"\b\62\1\2\u05c6\u05c7\7\4\2\2\u05c7\u05c8\5n8\2\u05c8\u05c9\7b\2\2\u05c9"+
		"\u05ca\5`\61\2\u05ca\u05cb\7\6\2\2\u05cb\u05cc\3\2\2\2\u05cc\u05cd\b\62"+
		"\1\2\u05cd\u05e4\3\2\2\2\u05ce\u05cf\t\f\2\2\u05cf\u05d0\5`\61\2\u05d0"+
		"\u05d1\7y\2\2\u05d1\u05d2\5b\62\2\u05d2\u05d3\7z\2\2\u05d3\u05d4\5b\62"+
		"\n\u05d4\u05e4\3\2\2\2\u05d5\u05e4\7{\2\2\u05d6\u05e4\7|\2\2\u05d7\u05e4"+
		"\7}\2\2\u05d8\u05e4\7~\2\2\u05d9\u05da\7\21\2\2\u05da\u05db\5b\62\2\u05db"+
		"\u05dc\7\22\2\2\u05dc\u05e4\3\2\2\2\u05dd\u05de\6\62\6\2\u05de\u05df\5"+
		"t;\2\u05df\u05e0\b\62\1\2\u05e0\u05e4\3\2\2\2\u05e1\u05e2\6\62\7\2\u05e2"+
		"\u05e4\5r:\2\u05e3\u05be\3\2\2\2\u05e3\u05c1\3\2\2\2\u05e3\u05c3\3\2\2"+
		"\2\u05e3\u05c5\3\2\2\2\u05e3\u05ce\3\2\2\2\u05e3\u05d5\3\2\2\2\u05e3\u05d6"+
		"\3\2\2\2\u05e3\u05d7\3\2\2\2\u05e3\u05d8\3\2\2\2\u05e3\u05d9\3\2\2\2\u05e3"+
		"\u05dd\3\2\2\2\u05e3\u05e1\3\2\2\2\u05e4\u0604\3\2\2\2\u05e5\u05e6\f\22"+
		"\2\2\u05e6\u05e7\7\66\2\2\u05e7\u0603\5b\62\23\u05e8\u05e9\f\21\2\2\u05e9"+
		"\u05ea\7I\2\2\u05ea\u0603\5b\62\22\u05eb\u05ec\f\20\2\2\u05ec\u05ed\7"+
		"u\2\2\u05ed\u0603\5b\62\21\u05ee\u05ef\f\17\2\2\u05ef\u05f0\7v\2\2\u05f0"+
		"\u0603\5b\62\20\u05f1\u05f3\f\r\2\2\u05f2\u05f4\t\16\2\2\u05f3\u05f2\3"+
		"\2\2\2\u05f3\u05f4\3\2\2\2\u05f4\u05f5\3\2\2\2\u05f5\u05f7\7e\2\2\u05f6"+
		"\u05f8\t\16\2\2\u05f7\u05f6\3\2\2\2\u05f7\u05f8\3\2\2\2\u05f8\u05f9\3"+
		"\2\2\2\u05f9\u0603\5b\62\r\u05fa\u05fb\f\f\2\2\u05fb\u05fc\7x\2\2\u05fc"+
		"\u0603\5b\62\r\u05fd\u05fe\f\16\2\2\u05fe\u05ff\7\r\2\2\u05ff\u0600\5"+
		"b\62\2\u0600\u0601\7\16\2\2\u0601\u0603\3\2\2\2\u0602\u05e5\3\2\2\2\u0602"+
		"\u05e8\3\2\2\2\u0602\u05eb\3\2\2\2\u0602\u05ee\3\2\2\2\u0602\u05f1\3\2"+
		"\2\2\u0602\u05fa\3\2\2\2\u0602\u05fd\3\2\2\2\u0603\u0606\3\2\2\2\u0604"+
		"\u0602\3\2\2\2\u0604\u0605\3\2\2\2\u0605c\3\2\2\2\u0606\u0604\3\2\2\2"+
		"\u0607\u0608\b\63\1\2\u0608\u0609\t\f\2\2\u0609\u060a\5`\61\2\u060a\u060b"+
		"\7y\2\2\u060b\u060c\5d\63\2\u060c\u060d\7z\2\2\u060d\u060e\5d\63\f\u060e"+
		"\u061c\3\2\2\2\u060f\u0610\7a\2\2\u0610\u061c\5b\62\2\u0611\u0612\7.\2"+
		"\2\u0612\u061c\5b\62\2\u0613\u0615\7u\2\2\u0614\u0613\3\2\2\2\u0614\u0615"+
		"\3\2\2\2\u0615\u0616\3\2\2\2\u0616\u061c\5v<\2\u0617\u0618\7\21\2\2\u0618"+
		"\u0619\5d\63\2\u0619\u061a\7\22\2\2\u061a\u061c\3\2\2\2\u061b\u0607\3"+
		"\2\2\2\u061b\u060f\3\2\2\2\u061b\u0611\3\2\2\2\u061b\u0614\3\2\2\2\u061b"+
		"\u0617\3\2\2\2\u061c\u062e\3\2\2\2\u061d\u061e\f\t\2\2\u061e\u061f\t\17"+
		"\2\2\u061f\u062d\5d\63\n\u0620\u0621\f\b\2\2\u0621\u0622\t\20\2\2\u0622"+
		"\u062d\5d\63\t\u0623\u0624\f\7\2\2\u0624\u0625\t\21\2\2\u0625\u062d\5"+
		"d\63\b\u0626\u0627\f\6\2\2\u0627\u0628\t\22\2\2\u0628\u062d\5d\63\7\u0629"+
		"\u062a\f\5\2\2\u062a\u062b\t\23\2\2\u062b\u062d\5d\63\6\u062c\u061d\3"+
		"\2\2\2\u062c\u0620\3\2\2\2\u062c\u0623\3\2\2\2\u062c\u0626\3\2\2\2\u062c"+
		"\u0629\3\2\2\2\u062d\u0630\3\2\2\2\u062e\u062c\3\2\2\2\u062e\u062f\3\2"+
		"\2\2\u062fe\3\2\2\2\u0630\u062e\3\2\2\2\u0631\u0636\5h\65\2\u0632\u0633"+
		"\7\5\2\2\u0633\u0635\5h\65\2\u0634\u0632\3\2\2\2\u0635\u0638\3\2\2\2\u0636"+
		"\u0634\3\2\2\2\u0636\u0637\3\2\2\2\u0637g\3\2\2\2\u0638\u0636\3\2\2\2"+
		"\u0639\u063b\7\u0086\2\2\u063a\u0639\3\2\2\2\u063a\u063b\3\2\2\2\u063b"+
		"\u063c\3\2\2\2\u063c\u0641\5t;\2\u063d\u063e\7\5\2\2\u063e\u0640\5t;\2"+
		"\u063f\u063d\3\2\2\2\u0640\u0643\3\2\2\2\u0641\u063f\3\2\2\2\u0641\u0642"+
		"\3\2\2\2\u0642\u0644\3\2\2\2\u0643\u0641\3\2\2\2\u0644\u0646\7\b\2\2\u0645"+
		"\u0647\7Z\2\2\u0646\u0645\3\2\2\2\u0646\u0647\3\2\2\2\u0647\u0648\3\2"+
		"\2\2\u0648\u0649\5b\62\2\u0649\u064a\b\65\1\2\u064a\u067c\3\2\2\2\u064b"+
		"\u064d\7\u0086\2\2\u064c\u064b\3\2\2\2\u064c\u064d\3\2\2\2\u064d\u064e"+
		"\3\2\2\2\u064e\u0653\5t;\2\u064f\u0650\7\5\2\2\u0650\u0652\5t;\2\u0651"+
		"\u064f\3\2\2\2\u0652\u0655\3\2\2\2\u0653\u0651\3\2\2\2\u0653\u0654\3\2"+
		"\2\2\u0654\u0656\3\2\2\2\u0655\u0653\3\2\2\2\u0656\u0657\7\b\2\2\u0657"+
		"\u0658\7Y\2\2\u0658\u0659\5b\62\2\u0659\u065a\b\65\1\2\u065a\u067c\3\2"+
		"\2\2\u065b\u065d\7\u0086\2\2\u065c\u065b\3\2\2\2\u065c\u065d\3\2\2\2\u065d"+
		"\u065e\3\2\2\2\u065e\u0663\5t;\2\u065f\u0660\7\5\2\2\u0660\u0662\5t;\2"+
		"\u0661\u065f\3\2\2\2\u0662\u0665\3\2\2\2\u0663\u0661\3\2\2\2\u0663\u0664"+
		"\3\2\2\2\u0664\u0666\3\2\2\2\u0665\u0663\3\2\2\2\u0666\u0667\7\b\2\2\u0667"+
		"\u0668\7[\2\2\u0668\u0669\5b\62\2\u0669\u066a\b\65\1\2\u066a\u067c\3\2"+
		"\2\2\u066b\u066d\7\u0086\2\2\u066c\u066b\3\2\2\2\u066c\u066d\3\2\2\2\u066d"+
		"\u066e\3\2\2\2\u066e\u0673\5t;\2\u066f\u0670\7\5\2\2\u0670\u0672\5t;\2"+
		"\u0671\u066f\3\2\2\2\u0672\u0675\3\2\2\2\u0673\u0671\3\2\2\2\u0673\u0674"+
		"\3\2\2\2\u0674\u0676\3\2\2\2\u0675\u0673\3\2\2\2\u0676\u0677\7\b\2\2\u0677"+
		"\u0678\7w\2\2\u0678\u0679\5b\62\2\u0679\u067a\b\65\1\2\u067a\u067c\3\2"+
		"\2\2\u067b\u063a\3\2\2\2\u067b\u064c\3\2\2\2\u067b\u065c\3\2\2\2\u067b"+
		"\u066c\3\2\2\2\u067ci\3\2\2\2\u067d\u0682\5l\67\2\u067e\u067f\7\5\2\2"+
		"\u067f\u0681\5l\67\2\u0680\u067e\3\2\2\2\u0681\u0684\3\2\2\2\u0682\u0680"+
		"\3\2\2\2\u0682\u0683\3\2\2\2\u0683k\3\2\2\2\u0684\u0682\3\2\2\2\u0685"+
		"\u068a\5t;\2\u0686\u0687\7\5\2\2\u0687\u0689\5t;\2\u0688\u0686\3\2\2\2"+
		"\u0689\u068c\3\2\2\2\u068a\u0688\3\2\2\2\u068a\u068b\3\2\2\2\u068b\u068d"+
		"\3\2\2\2\u068c\u068a\3\2\2\2\u068d\u068e\7\27\2\2\u068e\u068f\5b\62\2"+
		"\u068f\u0690\3\2\2\2\u0690\u0691\b\67\1\2\u0691m\3\2\2\2\u0692\u0697\5"+
		"p9\2\u0693\u0694\7\5\2\2\u0694\u0696\5p9\2\u0695\u0693\3\2\2\2\u0696\u0699"+
		"\3\2\2\2\u0697\u0695\3\2\2\2\u0697\u0698\3\2\2\2\u0698o\3\2\2\2\u0699"+
		"\u0697\3\2\2\2\u069a\u069c\7\u0086\2\2\u069b\u069a\3\2\2\2\u069b\u069c"+
		"\3\2\2\2\u069c\u069d\3\2\2\2\u069d\u06a2\5t;\2\u069e\u069f\7\5\2\2\u069f"+
		"\u06a1\5t;\2\u06a0\u069e\3\2\2\2\u06a1\u06a4\3\2\2\2\u06a2\u06a0\3\2\2"+
		"\2\u06a2\u06a3\3\2\2\2\u06a3\u06a5\3\2\2\2\u06a4\u06a2\3\2\2\2\u06a5\u06a7"+
		"\7\b\2\2\u06a6\u06a8\7Z\2\2\u06a7\u06a6\3\2\2\2\u06a7\u06a8\3\2\2\2\u06a8"+
		"\u06a9\3\2\2\2\u06a9\u06aa\5b\62\2\u06aa\u06ab\3\2\2\2\u06ab\u06ac\b9"+
		"\1\2\u06acq\3\2\2\2\u06ad\u06ae\5x=\2\u06aes\3\2\2\2\u06af\u06b0\5x=\2"+
		"\u06b0u\3\2\2\2\u06b1\u06b2\7\u008a\2\2\u06b2w\3\2\2\2\u06b3\u06de\7\30"+
		"\2\2\u06b4\u06de\7$\2\2\u06b5\u06de\7L\2\2\u06b6\u06de\7M\2\2\u06b7\u06de"+
		"\7\31\2\2\u06b8\u06de\7/\2\2\u06b9\u06de\7;\2\2\u06ba\u06de\7\u0087\2"+
		"\2\u06bb\u06de\7T\2\2\u06bc\u06de\7%\2\2\u06bd\u06de\7C\2\2\u06be\u06de"+
		"\7\u0088\2\2\u06bf\u06de\7\33\2\2\u06c0\u06de\7&\2\2\u06c1\u06de\7\24"+
		"\2\2\u06c2\u06de\7S\2\2\u06c3\u06de\7\32\2\2\u06c4\u06de\7\62\2\2\u06c5"+
		"\u06de\7\23\2\2\u06c6\u06de\7\63\2\2\u06c7\u06de\7\'\2\2\u06c8\u06de\7"+
		"\26\2\2\u06c9\u06de\7Q\2\2\u06ca\u06de\7O\2\2\u06cb\u06de\7:\2\2\u06cc"+
		"\u06de\7-\2\2\u06cd\u06de\7#\2\2\u06ce\u06de\7F\2\2\u06cf\u06de\7\u0089"+
		"\2\2\u06d0\u06de\7\60\2\2\u06d1\u06de\7\34\2\2\u06d2\u06de\7\64\2\2\u06d3"+
		"\u06de\7\37\2\2\u06d4\u06de\7)\2\2\u06d5\u06de\7+\2\2\u06d6\u06de\7 \2"+
		"\2\u06d7\u06de\7N\2\2\u06d8\u06de\7D\2\2\u06d9\u06de\7<\2\2\u06da\u06de"+
		"\7E\2\2\u06db\u06de\7\35\2\2\u06dc\u06de\5z>\2\u06dd\u06b3\3\2\2\2\u06dd"+
		"\u06b4\3\2\2\2\u06dd\u06b5\3\2\2\2\u06dd\u06b6\3\2\2\2\u06dd\u06b7\3\2"+
		"\2\2\u06dd\u06b8\3\2\2\2\u06dd\u06b9\3\2\2\2\u06dd\u06ba\3\2\2\2\u06dd"+
		"\u06bb\3\2\2\2\u06dd\u06bc\3\2\2\2\u06dd\u06bd\3\2\2\2\u06dd\u06be\3\2"+
		"\2\2\u06dd\u06bf\3\2\2\2\u06dd\u06c0\3\2\2\2\u06dd\u06c1\3\2\2\2\u06dd"+
		"\u06c2\3\2\2\2\u06dd\u06c3\3\2\2\2\u06dd\u06c4\3\2\2\2\u06dd\u06c5\3\2"+
		"\2\2\u06dd\u06c6\3\2\2\2\u06dd\u06c7\3\2\2\2\u06dd\u06c8\3\2\2\2\u06dd"+
		"\u06c9\3\2\2\2\u06dd\u06ca\3\2\2\2\u06dd\u06cb\3\2\2\2\u06dd\u06cc\3\2"+
		"\2\2\u06dd\u06cd\3\2\2\2\u06dd\u06ce\3\2\2\2\u06dd\u06cf\3\2\2\2\u06dd"+
		"\u06d0\3\2\2\2\u06dd\u06d1\3\2\2\2\u06dd\u06d2\3\2\2\2\u06dd\u06d3\3\2"+
		"\2\2\u06dd\u06d4\3\2\2\2\u06dd\u06d5\3\2\2\2\u06dd\u06d6\3\2\2\2\u06dd"+
		"\u06d7\3\2\2\2\u06dd\u06d8\3\2\2\2\u06dd\u06d9\3\2\2\2\u06dd\u06da\3\2"+
		"\2\2\u06dd\u06db\3\2\2\2\u06dd\u06dc\3\2\2\2\u06dey\3\2\2\2\u06df\u06e0"+
		"\7\u008b\2\2\u06e0{\3\2\2\2\u06e1\u06e2\t\24\2\2\u06e2}\3\2\2\2\u06e3"+
		"\u06e4\7\u008a\2\2\u06e4\177\3\2\2\2\u06e5\u06e7\7u\2\2\u06e6\u06e5\3"+
		"\2\2\2\u06e6\u06e7\3\2\2\2\u06e7\u06e8\3\2\2\2\u06e8\u06e9\7\u008a\2\2"+
		"\u06e9\u0081\3\2\2\2\u00ea\u0083\u008c\u0099\u00aa\u00b3\u00be\u00c3\u00cc"+
		"\u00d4\u00d8\u00de\u00ea\u00ed\u00f6\u00f9\u0108\u0110\u011b\u0120\u0123"+
		"\u0128\u012e\u0139\u013f\u015a\u015c\u0161\u016e\u0171\u0175\u0179\u017d"+
		"\u0182\u018b\u018e\u0193\u01a3\u01a5\u01aa\u01b4\u01b7\u01bb\u01bf\u01c2"+
		"\u01c5\u01c9\u01cc\u01d5\u01da\u01e6\u01e9\u01ed\u01f0\u01f8\u0201\u0208"+
		"\u020d\u0213\u0217\u021b\u021e\u0221\u0225\u0228\u0230\u0236\u023b\u0249"+
		"\u024c\u0250\u0253\u025c\u0261\u0268\u0271\u0278\u027d\u0283\u0287\u028b"+
		"\u0297\u029a\u02a1\u02a3\u02ac\u02af\u02b7\u02ba\u02be\u02c1\u02d0\u02d2"+
		"\u02d7\u02de\u02e6\u02ee\u02f1\u02f5\u02f8\u02fe\u0303\u030c\u030f\u0313"+
		"\u0319\u031f\u0321\u0328\u032d\u0333\u0336\u033f\u0341\u0346\u034e\u0356"+
		"\u035b\u0361\u0364\u0370\u0372\u0377\u037f\u0385\u038c\u0392\u0398\u03a2"+
		"\u03a7\u03b4\u03b6\u03bb\u03c0\u03c4\u03ce\u03dc\u03e7\u03f3\u03ff\u0402"+
		"\u0406\u040a\u0411\u0416\u041d\u0427\u042c\u0431\u0435\u043a\u0442\u0444"+
		"\u0449\u044d\u0456\u0458\u045d\u0461\u046a\u046c\u0471\u0475\u047b\u0480"+
		"\u0484\u048a\u048f\u0493\u049a\u04a1\u04b0\u04b7\u04be\u04c5\u04cc\u04d3"+
		"\u04da\u050c\u0510\u0516\u051a\u0527\u052b\u0531\u0535\u0542\u0546\u054c"+
		"\u0550\u055d\u0561\u0567\u056b\u0578\u057c\u0582\u0586\u0593\u0597\u059d"+
		"\u05a1\u05ab\u05b9\u05bb\u05e3\u05f3\u05f7\u0602\u0604\u0614\u061b\u062c"+
		"\u062e\u0636\u063a\u0641\u0646\u064c\u0653\u065c\u0663\u066c\u0673\u067b"+
		"\u0682\u068a\u0697\u069b\u06a2\u06a7\u06dd\u06e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}