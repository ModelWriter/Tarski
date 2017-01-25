// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.recognizer;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
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

import eu.modelwriter.core.alloyinecore.structure.Document;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.structure.ModelElement;
import eu.modelwriter.core.alloyinecore.structure.Annotation;
import eu.modelwriter.core.alloyinecore.structure.AnnotationDetail;
import eu.modelwriter.core.alloyinecore.structure.AnnotationReference;
import eu.modelwriter.core.alloyinecore.structure.NamedElement;
import eu.modelwriter.core.alloyinecore.structure.Module;
import eu.modelwriter.core.alloyinecore.structure.Import;
import eu.modelwriter.core.alloyinecore.structure.EcoreImport;
import eu.modelwriter.core.alloyinecore.structure.Package;
import eu.modelwriter.core.alloyinecore.structure.Classifier;
import eu.modelwriter.core.alloyinecore.structure.Class;
import eu.modelwriter.core.alloyinecore.structure.Interface;
import eu.modelwriter.core.alloyinecore.structure.DataType;
import eu.modelwriter.core.alloyinecore.structure.Enum;
import eu.modelwriter.core.alloyinecore.structure.EnumLiteral;
import eu.modelwriter.core.alloyinecore.structure.StructuralFeature;
import eu.modelwriter.core.alloyinecore.structure.TypedElement;
import eu.modelwriter.core.alloyinecore.structure.Multiplicity;
import eu.modelwriter.core.alloyinecore.structure.Reference;
import eu.modelwriter.core.alloyinecore.structure.Attribute;
import eu.modelwriter.core.alloyinecore.structure.Operation;
import eu.modelwriter.core.alloyinecore.structure.Parameter;
import eu.modelwriter.core.alloyinecore.structure.GenericException;
import eu.modelwriter.core.alloyinecore.structure.TypeParameter;
import eu.modelwriter.core.alloyinecore.structure.GenericType;
import eu.modelwriter.core.alloyinecore.structure.GenericTypeArgument;
import eu.modelwriter.core.alloyinecore.structure.GenericElementType;
import eu.modelwriter.core.alloyinecore.structure.GenericSuperType;
import eu.modelwriter.core.alloyinecore.structure.GenericWildcard;
import eu.modelwriter.core.alloyinecore.structure.PrimitiveType;
import eu.modelwriter.core.alloyinecore.structure.Invariant;
import eu.modelwriter.core.alloyinecore.structure.Derivation;
import eu.modelwriter.core.alloyinecore.structure.Body;
import eu.modelwriter.core.alloyinecore.structure.PostCondition;
import eu.modelwriter.core.alloyinecore.structure.PreCondition;
import eu.modelwriter.core.alloyinecore.structure.Initial;

import eu.modelwriter.core.alloyinecore.Internal.ModelIO;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import java.io.IOException;

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
		T__131=132, T__132=133, T__133=134, INT=135, IDENTIFIER=136, DOUBLE_QUOTED_STRING=137, 
		SINGLE_QUOTED_STRING=138, ML_SINGLE_QUOTED_STRING=139, MULTILINE_COMMENT=140, 
		SINGLELINE_COMMENT=141, WS=142;
	public static final int
		RULE_problem = 0, RULE_options = 1, RULE_option = 2, RULE_universe = 3, 
		RULE_relations = 4, RULE_relation = 5, RULE_tupleSet = 6, RULE_tuple = 7, 
		RULE_module = 8, RULE_packageImport = 9, RULE_ePackage = 10, RULE_eClassifier = 11, 
		RULE_eClass = 12, RULE_eStructuralFeature = 13, RULE_eAttribute = 14, 
		RULE_eReference = 15, RULE_eOperation = 16, RULE_eGenericException = 17, 
		RULE_eGenericSuperType = 18, RULE_eParameter = 19, RULE_eMultiplicity = 20, 
		RULE_eDataType = 21, RULE_eEnum = 22, RULE_eEnumLiteral = 23, RULE_eAnnotation = 24, 
		RULE_eDetail = 25, RULE_eModelElement = 26, RULE_eNamedElement = 27, RULE_eTypedElement = 28, 
		RULE_eModelElementRef = 29, RULE_templateSignature = 30, RULE_eTypeParameter = 31, 
		RULE_eGenericTypeArgument = 32, RULE_eGenericType = 33, RULE_eGenericElementType = 34, 
		RULE_eGenericWildcard = 35, RULE_pathName = 36, RULE_segment = 37, RULE_ePrimitiveType = 38, 
		RULE_body = 39, RULE_invariant = 40, RULE_precondition = 41, RULE_postcondition = 42, 
		RULE_initial = 43, RULE_derivation = 44, RULE_visibilityKind = 45, RULE_atom = 46, 
		RULE_arity = 47, RULE_formula = 48, RULE_expression = 49, RULE_intexpression = 50, 
		RULE_decls = 51, RULE_decl = 52, RULE_letDecls = 53, RULE_letDecl = 54, 
		RULE_comprehensionDecls = 55, RULE_comprehensionDecl = 56, RULE_relationId = 57, 
		RULE_variableId = 58, RULE_integer = 59, RULE_unrestrictedName = 60, RULE_identifier = 61, 
		RULE_upper = 62, RULE_lower = 63, RULE_signed = 64;
	public static final String[] ruleNames = {
		"problem", "options", "option", "universe", "relations", "relation", "tupleSet", 
		"tuple", "module", "packageImport", "ePackage", "eClassifier", "eClass", 
		"eStructuralFeature", "eAttribute", "eReference", "eOperation", "eGenericException", 
		"eGenericSuperType", "eParameter", "eMultiplicity", "eDataType", "eEnum", 
		"eEnumLiteral", "eAnnotation", "eDetail", "eModelElement", "eNamedElement", 
		"eTypedElement", "eModelElementRef", "templateSignature", "eTypeParameter", 
		"eGenericTypeArgument", "eGenericType", "eGenericElementType", "eGenericWildcard", 
		"pathName", "segment", "ePrimitiveType", "body", "invariant", "precondition", 
		"postcondition", "initial", "derivation", "visibilityKind", "atom", "arity", 
		"formula", "expression", "intexpression", "decls", "decl", "letDecls", 
		"letDecl", "comprehensionDecls", "comprehensionDecl", "relationId", "variableId", 
		"integer", "unrestrictedName", "identifier", "upper", "lower", "signed"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'options'", "'{'", "','", "'}'", "'symmetry_breaking'", "':'", 
		"'bit_width'", "'skolem_depth'", "'sharing'", "'universe'", "'['", "']'", 
		"'relations'", "'..'", "'('", "')'", "'module'", "';'", "'import'", "'package'", 
		"'='", "'abstract'", "'class'", "'interface'", "'extends'", "'static'", 
		"'model'", "'ghost'", "'transient'", "'volatile'", "'readonly'", "'attribute'", 
		"'derived'", "'id'", "'ordered'", "'!ordered'", "'unique'", "'!unique'", 
		"'unsettable'", "'!unsettable'", "'property'", "'#'", "'composes'", "'resolve'", 
		"'!resolve'", "'key'", "'operation'", "'throws'", "'*'", "'+'", "'?'", 
		"'|?'", "'|1'", "'primitive'", "'datatype'", "'serializable'", "'!serializable'", 
		"'enum'", "'literal'", "'annotation'", "'reference'", "'<'", "'>'", "'&'", 
		"'super'", "'::'", "'@'", "'.'", "'Boolean'", "'Integer'", "'String'", 
		"'Real'", "'UnlimitedNatural'", "'body'", "'callable'", "'invariant'", 
		"'precondition'", "'requires'", "'postcondition'", "'ensures'", "'initial'", 
		"'derivation'", "'public'", "'protected'", "'private'", "'no'", "'lone'", 
		"'one'", "'some'", "'!'", "'not'", "'in'", "'<='", "'>='", "'sum'", "'|'", 
		"'acyclic'", "'function'", "'->'", "'ord'", "'&&'", "'and'", "'||'", "'or'", 
		"'=>'", "'if'", "'<=>'", "'iff'", "'all'", "'let'", "'true'", "'false'", 
		"'~'", "'^'", "'-'", "'set'", "'++'", "'then'", "'else'", "'iden'", "'none'", 
		"'univ'", "'ints'", "'plus'", "'minus'", "'mul'", "'/'", "'div'", "'%'", 
		"'modulo'", "'disj'", "'definition'", "'ensure'", "'require'"
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
	    module.printTree();
	}

	private String getContextText(ParserRuleContext ctx){
	    return getTokenStream().getTokenSource().getInputStream().toString().substring(ctx.start.getStartIndex(),ctx.stop.getStopIndex());
	}

	public AlloyInEcoreParser(TokenStream input, String filename, String path){
	    this(input);
	    this.fileName = filename;
	    this.pathName = path;
	}

	private String fileName;
	private String pathName;

	public Module module;

	Document document = new Document(this);

	private EcoreFactory eFactory = EcoreFactory.eINSTANCE;

	private void signalParsingCompletion() {
	    document.checkConstraints();
	}

	private void createEAnnotation(EModelElement owner, final String source) {
	    if (owner.getEAnnotation(source) != null)
	        return;
	    final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
	    eAnnotation.setSource(source);
	    owner.getEAnnotations().add(eAnnotation);
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
		public EAnnotation element;
		public IdentifierContext name;
		public PackageImportContext packageImport;
		public List<PackageImportContext> ownedPackageImport = new ArrayList<PackageImportContext>();
		public EPackageContext ownedPackage;
		public EPackageContext ePackage;
		public OptionsContext options() {
			return getRuleContext(OptionsContext.class,0);
		}
		public EPackageContext ePackage() {
			return getRuleContext(EPackageContext.class,0);
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
		module = new Module(_localctx); ((ModuleContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.MODULE);
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


			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(294);
				match(T__16);
				setState(295);
				((ModuleContext)_localctx).name = identifier();
				setState(296);
				match(T__17);
				}
			}

			_localctx.element.getDetails().put("name", (((ModuleContext)_localctx).name!=null?_input.getText(((ModuleContext)_localctx).name.start,((ModuleContext)_localctx).name.stop):null));
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(301);
				((ModuleContext)_localctx).packageImport = packageImport(module);
				((ModuleContext)_localctx).ownedPackageImport.add(((ModuleContext)_localctx).packageImport);
				}
				}
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(307);
			((ModuleContext)_localctx).ownedPackage = ((ModuleContext)_localctx).ePackage = ePackage(module);
			((ModuleContext)_localctx).ePackage.element.getEAnnotations().add(_localctx.element);
			}
			for(PackageImportContext ctx: _localctx.ownedPackageImport) {((ModuleContext)_localctx).ePackage.element.getEAnnotations().add(ctx.element);}
			}
			_ctx.stop = _input.LT(-1);
			signalParsingCompletion(); saveResource(((ModuleContext)_localctx).ownedPackage.element);
		}
		catch (RecognitionException re) {
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
		public Module owner;
		public EAnnotation element;
		public EObject object;
		public IdentifierContext name;
		public Token ownedPathName;
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PackageImportContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PackageImportContext(ParserRuleContext parent, int invokingState, Module owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final PackageImportContext packageImport(Module owner) throws RecognitionException {
		PackageImportContext _localctx = new PackageImportContext(_ctx, getState(), owner);
		enterRule(_localctx, 18, RULE_packageImport);
		((PackageImportContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.IMPORT);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(312);
			match(T__18);
			}
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(313);
				((PackageImportContext)_localctx).name = identifier();
				setState(314);
				match(T__5);
				}
			}

			setState(318);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(319);
			match(T__17);
			_localctx.element.getDetails().put((((PackageImportContext)_localctx).name!=null?_input.getText(((PackageImportContext)_localctx).name.start,((PackageImportContext)_localctx).name.stop):null), ((PackageImportContext)_localctx).ownedPathName != null ? ((PackageImportContext)_localctx).ownedPathName.getText().replace("'", "") : null);
			}
			_ctx.stop = _input.LT(-1);

			if (((PackageImportContext)_localctx).ownedPathName != null) {
			    if (((PackageImportContext)_localctx).ownedPathName.getText().replace("'", "").equals(EcorePackage.eNS_URI)) {
			        ((PackageImportContext)_localctx).object =  EcorePackage.eINSTANCE;
			        _localctx.owner.addOwnedElement(new EcoreImport(_localctx.object, _localctx));
			    } else {
			        try {((PackageImportContext)_localctx).object =  ModelIO.getRootObject(((PackageImportContext)_localctx).ownedPathName.getText().replace("'", ""));}
			        catch (final IOException e) { }
			        if (_localctx.object == null) notifyErrorListeners(((PackageImportContext)_localctx).ownedPathName, "Import could not be resolved!", null);
			        else _localctx.owner.addOwnedElement(new Import(_localctx.object, _localctx));
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

	public static class EPackageContext extends ParserRuleContext {
		public Element owner;
		public EPackage element;
		public Package current;
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
		public EPackageContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EPackageContext ePackage(Element owner) throws RecognitionException {
		EPackageContext _localctx = new EPackageContext(_ctx, getState(), owner);
		enterRule(_localctx, 20, RULE_ePackage);
		((EPackageContext)_localctx).element =  eFactory.createEPackage();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(322);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EPackageContext)_localctx).visibility.element);
			setState(326);
			match(T__19);
			setState(327);
			((EPackageContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null));
			((EPackageContext)_localctx).current =  new Package(_localctx.element, _localctx);
			{
			setState(330);
			match(T__5);
			setState(331);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(333);
			match(T__20);
			setState(334);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			_localctx.element.setNsPrefix((((EPackageContext)_localctx).nsPrefix!=null?_input.getText(((EPackageContext)_localctx).nsPrefix.start,((EPackageContext)_localctx).nsPrefix.stop):null)); if(((EPackageContext)_localctx).nsURI != null) _localctx.element.setNsURI(((EPackageContext)_localctx).nsURI.getText().replace("'", ""));
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(337);
				match(T__1);
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__53) | (1L << T__54) | (1L << T__57) | (1L << T__59))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__74 - 75)) | (1L << (T__75 - 75)) | (1L << (T__82 - 75)) | (1L << (T__83 - 75)) | (1L << (T__84 - 75)))) != 0)) {
					{
					setState(350);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(338);
						((EPackageContext)_localctx).eAnnotation = ((EPackageContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(341);
						((EPackageContext)_localctx).ePackage = ((EPackageContext)_localctx).ePackage = ePackage(_localctx.current);
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						_localctx.element.getESubpackages().add(((EPackageContext)_localctx).ePackage.element);
						}
						break;
					case 3:
						{
						setState(344);
						((EPackageContext)_localctx).eClassifier = ((EPackageContext)_localctx).eClassifier = eClassifier(_localctx.current);
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						if (((EPackageContext)_localctx).eClassifier.element != null) _localctx.element.getEClassifiers().add(((EPackageContext)_localctx).eClassifier.element);
						}
						break;
					case 4:
						{
						setState(347);
						((EPackageContext)_localctx).invariant = ((EPackageContext)_localctx).invariant = invariant(_localctx.current);
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(354);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(355);
				match(T__3);
				}
				}
				break;
			case T__17:
				{
				setState(356);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
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
		public EClassifierContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EClassifierContext eClassifier(Element owner) throws RecognitionException {
		EClassifierContext _localctx = new EClassifierContext(_ctx, getState(), owner);
		enterRule(_localctx, 22, RULE_eClassifier);
		try {
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				((EClassifierContext)_localctx).eClass = eClass(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eClass.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				((EClassifierContext)_localctx).eDataType = eDataType(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eDataType.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(365);
				((EClassifierContext)_localctx).eEnum = eEnum(_localctx.owner);
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
		public Element owner;
		public EClass element;
		public Class current;
		public VisibilityKindContext visibility;
		public Token isAbstract;
		public Token isClass;
		public Token isInterface;
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public EGenericSuperTypeContext eGenericSuperType;
		public List<EGenericSuperTypeContext> eSuperTypes = new ArrayList<EGenericSuperTypeContext>();
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
		public List<EGenericSuperTypeContext> eGenericSuperType() {
			return getRuleContexts(EGenericSuperTypeContext.class);
		}
		public EGenericSuperTypeContext eGenericSuperType(int i) {
			return getRuleContext(EGenericSuperTypeContext.class,i);
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
		public EClassContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EClassContext eClass(Element owner) throws RecognitionException {
		EClassContext _localctx = new EClassContext(_ctx, getState(), owner);
		enterRule(_localctx, 24, RULE_eClass);
		((EClassContext)_localctx).element =  eFactory.createEClass();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(370);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).visibility.element);
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				{
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(374);
					((EClassContext)_localctx).isAbstract = match(T__21);
					}
				}

				setState(377);
				((EClassContext)_localctx).isClass = match(T__22);
				}
				break;
			case T__23:
				{
				setState(378);
				((EClassContext)_localctx).isInterface = match(T__23);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.element.setAbstract(((EClassContext)_localctx).isAbstract!=null); if (((EClassContext)_localctx).isInterface!=null) {_localctx.element.setInterface(true);_localctx.element.setAbstract(true);}
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(382);
				((EClassContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			if (_localctx.name == null) {notifyErrorListeners("missing Class name");} else {_localctx.element.setName((((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null));}
			if (((EClassContext)_localctx).isInterface!=null) ((EClassContext)_localctx).current =  new Interface(_localctx.element, _localctx); else ((EClassContext)_localctx).current =  new Class(_localctx.element, _localctx);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__61) {
				{
				setState(387);
				((EClassContext)_localctx).ownedSignature = ((EClassContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EClassContext)_localctx).templateSignature.typeParameters);
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(391);
				match(T__24);
				setState(392);
				((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(393);
					match(T__2);
					setState(394);
					((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
					}
					}
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(403);
				match(T__5);
				setState(404);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EClassContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EClassContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(428);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(408);
				match(T__1);
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & ((1L << (T__25 - 26)) | (1L << (T__26 - 26)) | (1L << (T__27 - 26)) | (1L << (T__28 - 26)) | (1L << (T__29 - 26)) | (1L << (T__30 - 26)) | (1L << (T__31 - 26)) | (1L << (T__40 - 26)) | (1L << (T__46 - 26)) | (1L << (T__59 - 26)) | (1L << (T__74 - 26)) | (1L << (T__75 - 26)) | (1L << (T__82 - 26)) | (1L << (T__83 - 26)) | (1L << (T__84 - 26)))) != 0)) {
					{
					setState(421);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						setState(409);
						((EClassContext)_localctx).eAnnotation = ((EClassContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(412);
						((EClassContext)_localctx).eOperation = ((EClassContext)_localctx).eOperation = eOperation(_localctx.current);
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						_localctx.element.getEOperations().add(((EClassContext)_localctx).eOperation.element);
						}
						break;
					case 3:
						{
						setState(415);
						((EClassContext)_localctx).eStructuralFeature = ((EClassContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.current);
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						if (((EClassContext)_localctx).eStructuralFeature.element != null) _localctx.element.getEStructuralFeatures().add(((EClassContext)_localctx).eStructuralFeature.element);
						}
						break;
					case 4:
						{
						setState(418);
						((EClassContext)_localctx).invariant = ((EClassContext)_localctx).invariant = invariant(_localctx.current);
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(425);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(426);
				match(T__3);
				}
				}
				break;
			case T__17:
				{
				setState(427);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
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
		public EStructuralFeatureContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EStructuralFeatureContext eStructuralFeature(Element owner) throws RecognitionException {
		EStructuralFeatureContext _localctx = new EStructuralFeatureContext(_ctx, getState(), owner);
		enterRule(_localctx, 26, RULE_eStructuralFeature);
		try {
			setState(436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				((EStructuralFeatureContext)_localctx).eAttribute = eAttribute(_localctx.owner);
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eAttribute.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
				((EStructuralFeatureContext)_localctx).eReference = eReference(_localctx.owner);
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
		public Element owner;
		public EAttribute element;
		public Attribute current;
		public VisibilityKindContext visibility;
		public Token s26;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s27;
		public Token s28;
		public Token s29;
		public Token s30;
		public Token s31;
		public UnrestrictedNameContext name;
		public EGenericElementTypeContext eAttributeType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s33;
		public Token s34;
		public Token s35;
		public Token s36;
		public Token s37;
		public Token s38;
		public Token s39;
		public Token s40;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public DerivationContext ownedDerivation;
		public DerivationContext derivation;
		public InitialContext ownedInitial;
		public InitialContext initial;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public EGenericElementTypeContext eGenericElementType() {
			return getRuleContext(EGenericElementTypeContext.class,0);
		}
		public VisibilityKindContext visibilityKind() {
			return getRuleContext(VisibilityKindContext.class,0);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
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
		public EAttributeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EAttributeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EAttributeContext eAttribute(Element owner) throws RecognitionException {
		EAttributeContext _localctx = new EAttributeContext(_ctx, getState(), owner);
		enterRule(_localctx, 28, RULE_eAttribute);
		((EAttributeContext)_localctx).element =  eFactory.createEAttribute();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(438);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).visibility.element);
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(442);
				((EAttributeContext)_localctx).s26 = match(T__25);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
				}
			}

			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(445);
				((EAttributeContext)_localctx).s27 = match(T__26);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(446);
				((EAttributeContext)_localctx).s28 = match(T__27);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s28);
				}
				break;
			case T__28:
			case T__29:
			case T__30:
			case T__31:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(449);
				((EAttributeContext)_localctx).s29 = match(T__28);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
				}
			}

			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(452);
				((EAttributeContext)_localctx).s30 = match(T__29);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
				}
			}

			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(455);
				((EAttributeContext)_localctx).s31 = match(T__30);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
				}
			}

			setState(458);
			match(T__31);
			setState(459);
			((EAttributeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EAttributeContext)_localctx).name!=null?_input.getText(((EAttributeContext)_localctx).name.start,((EAttributeContext)_localctx).name.stop):null));
			((EAttributeContext)_localctx).current =  new Attribute(_localctx.element, _localctx);
			setState(462);
			match(T__5);
			setState(463);
			((EAttributeContext)_localctx).eAttributeType = eGenericElementType(_localctx.current);
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(464);
				((EAttributeContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement)_localctx.element);
				}
			}

			if(_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(468);
				match(T__20);
				setState(469);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EAttributeContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EAttributeContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(473);
				match(T__1);
				setState(487); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(482);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__32:
						{
						setState(474);
						((EAttributeContext)_localctx).s33 = match(T__32);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s33);
						}
						break;
					case T__33:
						{
						setState(475);
						((EAttributeContext)_localctx).s34 = match(T__33);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s34);
						}
						break;
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
					default:
						throw new NoViableAltException(this);
					}
					setState(485);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(484);
						match(T__2);
						}
					}

					}
					}
					setState(489); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(491);
				match(T__3);
				}
				break;
			}
			setState(521);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(494);
				match(T__1);
				{
				setState(500);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(495);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(502);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				}
				setState(509);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__81:
					{
					setState(503);
					((EAttributeContext)_localctx).ownedDerivation = ((EAttributeContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).derivation.element);
					}
					break;
				case T__80:
					{
					setState(506);
					((EAttributeContext)_localctx).ownedInitial = ((EAttributeContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__59:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__59) {
					{
					{
					setState(511);
					((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
					}
					}
					setState(518);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(519);
				match(T__3);
				}
				}
				break;
			case T__17:
				{
				setState(520);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EAttributeContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "static":     createEAnnotation(_localctx.element, AnnotationSources.STATIC); break;
			            case "model":      createEAnnotation(_localctx.element, AnnotationSources.MODEL); break;
			            case "ghost":      createEAnnotation(_localctx.element, AnnotationSources.GHOST); break;
			            case "transient":  _localctx.element.setTransient(true); break;
			            case "volatile":   _localctx.element.setVolatile(true); break;
			            case "readonly":   _localctx.element.setChangeable(false); break;
			            case "derived":    _localctx.element.setDerived(true); break;
			            case "ordered":    int u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setOrdered(true); break;
			            case "!unique":    u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setUnique(false); break;
			            case "unsettable": _localctx.element.setUnsettable(true); break;
			            case "id":         _localctx.element.setID(true); break;}}
			    
			}
			_ctx.stop = _input.LT(-1);

			owner.addOwnedElement(_localctx.current);
			if (_localctx.eAttributeType != null) {
			    EObject genericElementType = _localctx.eAttributeType.element;
			    if (genericElementType instanceof EClassifier) { _localctx.element.setEType((EClassifier) genericElementType);}
			    else if (genericElementType instanceof EGenericType) { _localctx.element.setEGenericType((EGenericType) genericElementType);}
			}

		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EReference element;
		public Reference current;
		public VisibilityKindContext visibility;
		public Token s26;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s27;
		public Token s28;
		public Token s29;
		public Token s30;
		public Token s31;
		public UnrestrictedNameContext name;
		public UnrestrictedNameContext eOpposite;
		public EGenericElementTypeContext eReferenceType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s43;
		public Token s33;
		public Token s35;
		public Token s36;
		public Token s37;
		public Token s38;
		public Token s44;
		public Token s45;
		public Token s39;
		public Token s40;
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
		public EGenericElementTypeContext eGenericElementType() {
			return getRuleContext(EGenericElementTypeContext.class,0);
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
		public EReferenceContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EReferenceContext eReference(Element owner) throws RecognitionException {
		EReferenceContext _localctx = new EReferenceContext(_ctx, getState(), owner);
		enterRule(_localctx, 30, RULE_eReference);
		((EReferenceContext)_localctx).element =  eFactory.createEReference();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(525);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).visibility.element);
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(529);
				((EReferenceContext)_localctx).s26 = match(T__25);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
				}
			}

			setState(534);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(532);
				((EReferenceContext)_localctx).s27 = match(T__26);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
				}
				break;
			case T__27:
				{
				setState(533);
				((EReferenceContext)_localctx).s28 = match(T__27);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s28);
				}
				break;
			case T__28:
			case T__29:
			case T__30:
			case T__40:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(536);
				((EReferenceContext)_localctx).s29 = match(T__28);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
				}
			}

			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(539);
				((EReferenceContext)_localctx).s30 = match(T__29);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
				}
			}

			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(542);
				((EReferenceContext)_localctx).s31 = match(T__30);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
				}
			}

			setState(545);
			match(T__40);
			setState(546);
			((EReferenceContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null));
			((EReferenceContext)_localctx).current =  new Reference(_localctx.element, _localctx);
			setState(551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(549);
				match(T__41);
				setState(550);
				((EReferenceContext)_localctx).eOpposite = unrestrictedName();
				}
			}


			{
			setState(554);
			match(T__5);
			setState(555);
			((EReferenceContext)_localctx).eReferenceType = eGenericElementType(_localctx.current);
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(556);
				((EReferenceContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			}
			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(560);
				match(T__20);
				setState(561);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EReferenceContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EReferenceContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(586);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(565);
				match(T__1);
				setState(581); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(576);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__42:
						{
						setState(566);
						((EReferenceContext)_localctx).s43 = match(T__42);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s43);
						}
						break;
					case T__32:
						{
						setState(567);
						((EReferenceContext)_localctx).s33 = match(T__32);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s33);
						}
						break;
					case T__34:
						{
						setState(568);
						((EReferenceContext)_localctx).s35 = match(T__34);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(569);
						((EReferenceContext)_localctx).s36 = match(T__35);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(570);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(571);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__43:
						{
						setState(572);
						((EReferenceContext)_localctx).s44 = match(T__43);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s44);
						}
						break;
					case T__44:
						{
						setState(573);
						((EReferenceContext)_localctx).s45 = match(T__44);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s45);
						}
						break;
					case T__38:
						{
						setState(574);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(575);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(579);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(578);
						match(T__2);
						}
					}

					}
					}
					setState(583); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) );
				setState(585);
				match(T__3);
				}
				break;
			}
			setState(628);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(588);
				match(T__1);
				setState(600);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__45) {
					{
					setState(589);
					match(T__45);
					setState(590);
					((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
					setState(595);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(591);
						match(T__2);
						setState(592);
						((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
						}
						}
						setState(597);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(598);
					match(T__17);
					}
				}

				{
				setState(607);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(602);
						((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(609);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				}
				setState(616);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__81:
					{
					setState(610);
					((EReferenceContext)_localctx).ownedDerivation = ((EReferenceContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).derivation.element);
					}
					break;
				case T__80:
					{
					setState(613);
					((EReferenceContext)_localctx).ownedInitial = ((EReferenceContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__59:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(623);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__59) {
					{
					{
					setState(618);
					((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
					}
					}
					setState(625);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(626);
				match(T__3);
				}
				}
				break;
			case T__17:
				{
				setState(627);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EReferenceContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "static":    createEAnnotation(_localctx.element, AnnotationSources.STATIC); break;
			            case "model":     createEAnnotation(_localctx.element, AnnotationSources.MODEL); break;
			            case "ghost":     createEAnnotation(_localctx.element, AnnotationSources.GHOST); break;
			            case "transient": _localctx.element.setTransient(true); break;
			            case "volatile":  _localctx.element.setVolatile(true); break;
			            case "readonly":  _localctx.element.setChangeable(false); break;
			            case "unsettable":_localctx.element.setUnsettable(true); break;
			            case "derived":   _localctx.element.setDerived(true); break;
			            case "ordered":   int u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setOrdered(true); break;
			            case "!unique":   u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setUnique(false); break;
			            case "composes":  _localctx.element.setContainment(true); break;
			            case "!resolve":  _localctx.element.setResolveProxies(false); break;
			            default: break;}}
			    
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EOperation element;
		public Operation current;
		public VisibilityKindContext visibility;
		public Token s26;
		public List<Token> qualifier = new ArrayList<Token>();
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public UnrestrictedNameContext name;
		public EParameterContext eParameter;
		public List<EParameterContext> eParameters = new ArrayList<EParameterContext>();
		public EGenericElementTypeContext eReturnType;
		public EGenericElementTypeContext eGenericElementType;
		public EMultiplicityContext ownedMultiplicity;
		public EGenericExceptionContext eGenericException;
		public List<EGenericExceptionContext> ownedException = new ArrayList<EGenericExceptionContext>();
		public Token s35;
		public Token s36;
		public Token s37;
		public Token s38;
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
		public EGenericElementTypeContext eGenericElementType() {
			return getRuleContext(EGenericElementTypeContext.class,0);
		}
		public List<EGenericExceptionContext> eGenericException() {
			return getRuleContexts(EGenericExceptionContext.class);
		}
		public EGenericExceptionContext eGenericException(int i) {
			return getRuleContext(EGenericExceptionContext.class,i);
		}
		public List<EParameterContext> eParameter() {
			return getRuleContexts(EParameterContext.class);
		}
		public EParameterContext eParameter(int i) {
			return getRuleContext(EParameterContext.class,i);
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
		public EOperationContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EOperationContext eOperation(Element owner) throws RecognitionException {
		EOperationContext _localctx = new EOperationContext(_ctx, getState(), owner);
		enterRule(_localctx, 32, RULE_eOperation);
		((EOperationContext)_localctx).element =  eFactory.createEOperation(); ((EOperationContext)_localctx).current =  new Operation(_localctx.element, _localctx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(632);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EOperationContext)_localctx).visibility.element);
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(636);
				((EOperationContext)_localctx).s26 = match(T__25);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
				}
			}

			setState(639);
			match(T__46);
			setState(641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__61) {
				{
				setState(640);
				((EOperationContext)_localctx).ownedSignature = ((EOperationContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EOperationContext)_localctx).templateSignature.typeParameters);
			setState(644);
			((EOperationContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null));
			{
			setState(646);
			match(T__14);
			setState(655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (T__73 - 74)) | (1L << (T__74 - 74)) | (1L << (T__75 - 74)) | (1L << (T__76 - 74)) | (1L << (T__78 - 74)) | (1L << (T__80 - 74)) | (1L << (T__81 - 74)) | (1L << (T__131 - 74)) | (1L << (T__132 - 74)) | (1L << (T__133 - 74)) | (1L << (IDENTIFIER - 74)))) != 0)) {
				{
				setState(647);
				((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(652);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(648);
					match(T__2);
					setState(649);
					((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(654);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(657);
			match(T__15);
			}
			for (EParameterContext ctx: ((EOperationContext)_localctx).eParameters){_localctx.element.getEParameters().add(ctx.element);}
			setState(665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(660);
				match(T__5);
				setState(661);
				((EOperationContext)_localctx).eReturnType = ((EOperationContext)_localctx).eGenericElementType = eGenericElementType(_localctx.current);
				setState(663);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(662);
					((EOperationContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
					}
				}

				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			 if (_localctx.eReturnType != null) _localctx.element.setEGenericType(((EOperationContext)_localctx).eGenericElementType.element);
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__47) {
				{
				setState(669);
				match(T__47);
				setState(670);
				((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
				setState(675);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(671);
					match(T__2);
					setState(672);
					((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
					}
					}
					setState(677);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 for(EGenericExceptionContext e: ((EOperationContext)_localctx).ownedException) _localctx.element.getEGenericExceptions().add(e.element);
			setState(696);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(681);
				match(T__1);
				setState(691); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(686);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__34:
						{
						setState(682);
						((EOperationContext)_localctx).s35 = match(T__34);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(683);
						((EOperationContext)_localctx).s36 = match(T__35);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(684);
						((EOperationContext)_localctx).s37 = match(T__36);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(685);
						((EOperationContext)_localctx).s38 = match(T__37);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s38);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(689);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(688);
						match(T__2);
						}
					}

					}
					}
					setState(693); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0) );
				setState(695);
				match(T__3);
				}
				break;
			}
			setState(718);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(698);
				match(T__1);
				setState(713);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & ((1L << (T__59 - 60)) | (1L << (T__73 - 60)) | (1L << (T__76 - 60)) | (1L << (T__77 - 60)) | (1L << (T__78 - 60)) | (1L << (T__79 - 60)))) != 0)) {
					{
					setState(711);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__59:
						{
						setState(699);
						((EOperationContext)_localctx).eAnnotation = ((EOperationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).eAnnotation.element);
						}
						break;
					case T__76:
					case T__77:
						{
						setState(702);
						((EOperationContext)_localctx).precondition = ((EOperationContext)_localctx).precondition = precondition(_localctx.current);
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).precondition.element);
						}
						break;
					case T__73:
						{
						setState(705);
						((EOperationContext)_localctx).body = ((EOperationContext)_localctx).body = body(_localctx.current);
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).body.element);
						}
						break;
					case T__78:
					case T__79:
						{
						setState(708);
						((EOperationContext)_localctx).postcondition = ((EOperationContext)_localctx).postcondition = postcondition(_localctx.current);
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).postcondition.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(715);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(716);
				match(T__3);
				}
				}
				break;
			case T__17:
				{
				setState(717);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EOperationContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "static":   createEAnnotation(_localctx.element, AnnotationSources.STATIC); break;
			            case "ordered":  int u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setOrdered(true); break;
			            case "!unique":  u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setUnique(false); break;}}
			    
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericExceptionContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericException current;
		public EGenericTypeContext eGenericType;
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericExceptionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericExceptionContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericException; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericException(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericException(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericException(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericExceptionContext eGenericException(Element owner) throws RecognitionException {
		EGenericExceptionContext _localctx = new EGenericExceptionContext(_ctx, getState(), owner);
		enterRule(_localctx, 34, RULE_eGenericException);
		((EGenericExceptionContext)_localctx).current =  new GenericException(_localctx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(722);
			((EGenericExceptionContext)_localctx).eGenericType = eGenericType(_localctx.current);
			((EGenericExceptionContext)_localctx).element =  ((EGenericExceptionContext)_localctx).eGenericType.element;
			}
			_ctx.stop = _input.LT(-1);
			_localctx.current.setEObject(_localctx.element); _localctx.owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericSuperTypeContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericSuperType current;
		public EGenericTypeContext eGenericType;
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericSuperTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericSuperTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericSuperType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericSuperType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericSuperType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericSuperType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericSuperTypeContext eGenericSuperType(Element owner) throws RecognitionException {
		EGenericSuperTypeContext _localctx = new EGenericSuperTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 36, RULE_eGenericSuperType);
		((EGenericSuperTypeContext)_localctx).current =  new GenericSuperType(_localctx.element, _localctx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			((EGenericSuperTypeContext)_localctx).eGenericType = eGenericType(_localctx.current);
			((EGenericSuperTypeContext)_localctx).element =  ((EGenericSuperTypeContext)_localctx).eGenericType.element;
			}
			_ctx.stop = _input.LT(-1);
			_localctx.current.setEObject(_localctx.element); _localctx.owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EParameter element;
		public Parameter current;
		public UnrestrictedNameContext name;
		public EGenericElementTypeContext eParameterType;
		public EMultiplicityContext ownedMultiplicity;
		public Token s35;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s36;
		public Token s37;
		public Token s38;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public EGenericElementTypeContext eGenericElementType() {
			return getRuleContext(EGenericElementTypeContext.class,0);
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
		public EParameterContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EParameterContext eParameter(Element owner) throws RecognitionException {
		EParameterContext _localctx = new EParameterContext(_ctx, getState(), owner);
		enterRule(_localctx, 38, RULE_eParameter);
		((EParameterContext)_localctx).element =  eFactory.createEParameter();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
			((EParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null));
			((EParameterContext)_localctx).current =  new Parameter(_localctx.element, _localctx);
			setState(731);
			match(T__5);
			setState(732);
			((EParameterContext)_localctx).eParameterType = eGenericElementType(_localctx.current);
			setState(734);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(733);
				((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(752);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				{
				setState(737);
				match(T__1);
				setState(747); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(742);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__34:
						{
						setState(738);
						((EParameterContext)_localctx).s35 = match(T__34);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(739);
						((EParameterContext)_localctx).s36 = match(T__35);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(740);
						((EParameterContext)_localctx).s37 = match(T__36);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(741);
						((EParameterContext)_localctx).s38 = match(T__37);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s38);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(745);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(744);
						match(T__2);
						}
					}

					}
					}
					setState(749); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0) );
				setState(751);
				match(T__3);
				}
				break;
			}
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(754);
				match(T__1);
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__59) {
					{
					{
					setState(755);
					((EParameterContext)_localctx).eAnnotation = ((EParameterContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(760);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EParameterContext)_localctx).eAnnotation.element);
				setState(762);
				match(T__3);
				}
			}

			for(String s: ((EParameterContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "ordered":  int u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setOrdered(true);break;
			            case "!unique":  u = _localctx.element.getUpperBound(); if (u > 1 || u == -1) _localctx.element.setUnique(false);break;}}
				
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public ETypedElement element;
		public int l = 1;
		public int u = 1;
		public LowerContext lowerBound;
		public UpperContext upperBound;
		public Token stringBound;
		public Token nullable;
		public LowerContext lower() {
			return getRuleContext(LowerContext.class,0);
		}
		public UpperContext upper() {
			return getRuleContext(UpperContext.class,0);
		}
		public EMultiplicityContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EMultiplicityContext(ParserRuleContext parent, int invokingState, Element owner, ETypedElement element) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EMultiplicityContext eMultiplicity(Element owner,ETypedElement element) throws RecognitionException {
		EMultiplicityContext _localctx = new EMultiplicityContext(_ctx, getState(), owner, element);
		enterRule(_localctx, 40, RULE_eMultiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(T__10);
			setState(774);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(768);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(769);
					match(T__13);
					setState(770);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__48:
			case T__49:
			case T__50:
				{
				setState(773);
				((EMultiplicityContext)_localctx).stringBound = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__48) | (1L << T__49) | (1L << T__50))) != 0)) ) {
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
			setState(778);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__51:
				{
				setState(776);
				((EMultiplicityContext)_localctx).nullable = match(T__51);
				}
				break;
			case T__52:
				{
				setState(777);
				match(T__52);
				}
				break;
			case T__11:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(780);
			match(T__11);

				if (_localctx.stringBound != null) {
				    switch (_localctx.stringBound.getText()) {
			            case "*": ((EMultiplicityContext)_localctx).l =  0; ((EMultiplicityContext)_localctx).u =  -1; break;
			            case "+": ((EMultiplicityContext)_localctx).l =  1; ((EMultiplicityContext)_localctx).u =  -1; break;
			            case "?": ((EMultiplicityContext)_localctx).l =  0; ((EMultiplicityContext)_localctx).u =   1; break;
			            default: break;
			        }
			    } else {
			        try { ((EMultiplicityContext)_localctx).l =  Integer.valueOf((((EMultiplicityContext)_localctx).lowerBound!=null?_input.getText(((EMultiplicityContext)_localctx).lowerBound.start,((EMultiplicityContext)_localctx).lowerBound.stop):null)); } catch (NumberFormatException ex) {System.out.println(Arrays.toString(ex.getStackTrace()));}
			        if (_localctx.upperBound != null) {
			            if (_localctx.upperBound.getText().equals("*")) ((EMultiplicityContext)_localctx).u =  -1;
			            else try {((EMultiplicityContext)_localctx).u =  Integer.valueOf((((EMultiplicityContext)_localctx).upperBound!=null?_input.getText(((EMultiplicityContext)_localctx).upperBound.start,((EMultiplicityContext)_localctx).upperBound.stop):null));} catch (NumberFormatException ex){System.out.println(Arrays.toString(ex.getStackTrace()));}
			        } else { ((EMultiplicityContext)_localctx).u =  _localctx.l;}
			    }
			    if ((_localctx.u > 1 || _localctx.u == -1) && _localctx.nullable != null) createEAnnotation(_localctx.element, AnnotationSources.NULLABLE);
				
			}
			_ctx.stop = _input.LT(-1);
			_localctx.element.setLowerBound(_localctx.l); _localctx.element.setUpperBound(_localctx.u); _localctx.owner.addOwnedElement(new Multiplicity(_localctx));
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EDataType element;
		public DataType current;
		public VisibilityKindContext visibility;
		public Token s54;
		public List<Token> qualifier = new ArrayList<Token>();
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public Token instanceClassName;
		public Token s56;
		public Token s57;
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
		public EDataTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EDataTypeContext eDataType(Element owner) throws RecognitionException {
		EDataTypeContext _localctx = new EDataTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 42, RULE_eDataType);
		((EDataTypeContext)_localctx).element =  eFactory.createEDataType();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(783);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).visibility.element);
			setState(788);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__53) {
				{
				setState(787);
				((EDataTypeContext)_localctx).s54 = match(T__53);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s54);
				}
			}

			setState(790);
			match(T__54);
			setState(791);
			((EDataTypeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null));
			((EDataTypeContext)_localctx).current =  new DataType(_localctx.element, _localctx);
			setState(795);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__61) {
				{
				setState(794);
				((EDataTypeContext)_localctx).ownedSignature = ((EDataTypeContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EDataTypeContext)_localctx).templateSignature.typeParameters);
			setState(800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(798);
				match(T__5);
				setState(799);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EDataTypeContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EDataTypeContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(809);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				{
				setState(803);
				match(T__1);
				setState(806);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__55:
					{
					setState(804);
					((EDataTypeContext)_localctx).s56 = match(T__55);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s56);
					}
					break;
				case T__56:
					{
					setState(805);
					((EDataTypeContext)_localctx).s57 = match(T__56);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s57);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(808);
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
				setState(811);
				match(T__1);
				setState(820);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & ((1L << (T__59 - 60)) | (1L << (T__74 - 60)) | (1L << (T__75 - 60)))) != 0)) {
					{
					setState(818);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__59:
						{
						setState(812);
						((EDataTypeContext)_localctx).eAnnotation = ((EDataTypeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).eAnnotation.element);
						}
						break;
					case T__74:
					case T__75:
						{
						setState(815);
						((EDataTypeContext)_localctx).invariant = ((EDataTypeContext)_localctx).invariant = invariant(_localctx.current);
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).invariant.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
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
			case T__17:
				{
				setState(824);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EDataTypeContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "primitive":     createEAnnotation(_localctx.element, AnnotationSources.DATATYPE_PRIMITIVE);break;
			            case "!serializable": _localctx.element.setSerializable(false); break; }}
			    
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EEnum element;
		public Enum current;
		public VisibilityKindContext visibility;
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public Token instanceClassName;
		public Token s56;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s57;
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
		public EEnumContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EEnumContext eEnum(Element owner) throws RecognitionException {
		EEnumContext _localctx = new EEnumContext(_ctx, getState(), owner);
		enterRule(_localctx, 44, RULE_eEnum);
		((EEnumContext)_localctx).element =  eFactory.createEEnum();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(830);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) {
				{
				setState(829);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EEnumContext)_localctx).visibility.element);
			setState(833);
			match(T__57);
			setState(834);
			((EEnumContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null));
			((EEnumContext)_localctx).current =  new Enum(_localctx.element, _localctx);
			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__61) {
				{
				setState(837);
				((EEnumContext)_localctx).ownedSignature = ((EEnumContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EEnumContext)_localctx).templateSignature.typeParameters);
			setState(843);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(841);
				match(T__5);
				setState(842);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EEnumContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EEnumContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(852);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(846);
				match(T__1);
				setState(849);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__55:
					{
					setState(847);
					((EEnumContext)_localctx).s56 = match(T__55);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s56);
					}
					break;
				case T__56:
					{
					setState(848);
					((EEnumContext)_localctx).s57 = match(T__56);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s57);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(851);
				match(T__3);
				}
				break;
			}
			setState(871);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(854);
				match(T__1);
				setState(866);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (T__73 - 74)) | (1L << (T__74 - 74)) | (1L << (T__75 - 74)) | (1L << (T__76 - 74)) | (1L << (T__78 - 74)) | (1L << (T__80 - 74)) | (1L << (T__81 - 74)) | (1L << (T__131 - 74)) | (1L << (T__132 - 74)) | (1L << (T__133 - 74)) | (1L << (IDENTIFIER - 74)))) != 0)) {
					{
					setState(864);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
					case 1:
						{
						setState(855);
						((EEnumContext)_localctx).eAnnotation = ((EEnumContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(858);
						((EEnumContext)_localctx).eEnumLiteral = ((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.current);
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						_localctx.element.getELiterals().add(((EEnumContext)_localctx).eEnumLiteral.element);
						}
						break;
					case 3:
						{
						setState(861);
						((EEnumContext)_localctx).invariant = ((EEnumContext)_localctx).invariant = invariant(_localctx.current);
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(868);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(869);
				match(T__3);
				}
				}
				break;
			case T__17:
				{
				setState(870);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			for(String s: ((EEnumContext)_localctx).qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
			        switch (s) {
			            case "!serializable": _localctx.element.setSerializable(false); break;}}
			    
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EEnumLiteral element;
		public EnumLiteral current;
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
		public EEnumLiteralContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EEnumLiteralContext eEnumLiteral(Element owner) throws RecognitionException {
		EEnumLiteralContext _localctx = new EEnumLiteralContext(_ctx, getState(), owner);
		enterRule(_localctx, 46, RULE_eEnumLiteral);
		((EEnumLiteralContext)_localctx).element =  eFactory.createEEnumLiteral();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(878);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				{
				{
				setState(875);
				match(T__58);
				setState(876);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(877);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			_localctx.element.setName((((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null));
			((EEnumLiteralContext)_localctx).current =  new EnumLiteral(_localctx.element, _localctx);
			setState(884);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(882);
				match(T__20);
				setState(883);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}

			 
			setState(897);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(887);
				match(T__1);
				setState(891);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__59) {
					{
					{
					setState(888);
					((EEnumLiteralContext)_localctx).eAnnotation = ((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(893);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EEnumLiteralContext)_localctx).eAnnotation.element);
				setState(895);
				match(T__3);
				}
				}
				break;
			case T__17:
				{
				setState(896);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EAnnotation element;
		public Annotation current;
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
		public EAnnotationContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EAnnotationContext eAnnotation(Element owner) throws RecognitionException {
		EAnnotationContext _localctx = new EAnnotationContext(_ctx, getState(), owner);
		enterRule(_localctx, 48, RULE_eAnnotation);
		((EAnnotationContext)_localctx).element =  eFactory.createEAnnotation();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(899);
			match(T__59);
			setState(901);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(900);
				((EAnnotationContext)_localctx).source = match(SINGLE_QUOTED_STRING);
				}
			}

			_localctx.element.setSource(((EAnnotationContext)_localctx).source != null ? ((EAnnotationContext)_localctx).source.getText().replace("'", "") : null);
			((EAnnotationContext)_localctx).current =  new Annotation(_localctx.element, _localctx);
			setState(916);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(905);
				match(T__14);
				setState(906);
				((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(911);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(907);
					match(T__2);
					setState(908);
					((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(913);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(914);
				match(T__15);
				}
			}

			for (EDetailContext ctx: ((EAnnotationContext)_localctx).ownedDetails) _localctx.element.getDetails().put(ctx.k, ctx.v);
			setState(936);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(919);
				match(T__1);
				setState(929); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(929);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
					case 1:
						{
						setState(920);
						((EAnnotationContext)_localctx).eAnnotation = ((EAnnotationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						if(((EAnnotationContext)_localctx).eAnnotation.element != null) _localctx.element.getEAnnotations().add(((EAnnotationContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(923);
						((EAnnotationContext)_localctx).eModelElement = ((EAnnotationContext)_localctx).eModelElement = eModelElement(_localctx.current);
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						if(((EAnnotationContext)_localctx).eModelElement.element != null) _localctx.element.getContents().add(((EAnnotationContext)_localctx).eModelElement.element);
						}
						break;
					case 3:
						{
						setState(926);
						((EAnnotationContext)_localctx).eModelElementRef = ((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef(_localctx.current);
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						if(((EAnnotationContext)_localctx).eModelElementRef.element != null) _localctx.element.getReferences().add(((EAnnotationContext)_localctx).eModelElementRef.element);
						}
						break;
					}
					}
					setState(931); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (T__73 - 74)) | (1L << (T__74 - 74)) | (1L << (T__75 - 74)) | (1L << (T__76 - 74)) | (1L << (T__78 - 74)) | (1L << (T__80 - 74)) | (1L << (T__81 - 74)) | (1L << (T__82 - 74)) | (1L << (T__83 - 74)) | (1L << (T__84 - 74)) | (1L << (T__131 - 74)) | (1L << (T__132 - 74)) | (1L << (T__133 - 74)) | (1L << (IDENTIFIER - 74)))) != 0) );
				setState(933);
				match(T__3);
				}
				}
				break;
			case T__17:
				{
				setState(935);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public String k;
		public String v;
		public AnnotationDetail current;
		public Token key;
		public Token value;
		public List<TerminalNode> SINGLE_QUOTED_STRING() { return getTokens(AlloyInEcoreParser.SINGLE_QUOTED_STRING); }
		public TerminalNode SINGLE_QUOTED_STRING(int i) {
			return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, i);
		}
		public TerminalNode ML_SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.ML_SINGLE_QUOTED_STRING, 0); }
		public EDetailContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EDetailContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EDetailContext eDetail(Element owner) throws RecognitionException {
		EDetailContext _localctx = new EDetailContext(_ctx, getState(), owner);
		enterRule(_localctx, 50, RULE_eDetail);
		((EDetailContext)_localctx).current =  new AnnotationDetail(_localctx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(938);
				((EDetailContext)_localctx).key = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(941);
			match(T__20);
			setState(943);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) {
				{
				setState(942);
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
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EModelElement element;
		public EAnnotationContext eAnnotation;
		public ENamedElementContext eNamedElement;
		public EAnnotationContext eAnnotation() {
			return getRuleContext(EAnnotationContext.class,0);
		}
		public ENamedElementContext eNamedElement() {
			return getRuleContext(ENamedElementContext.class,0);
		}
		public EModelElementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EModelElementContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EModelElementContext eModelElement(Element owner) throws RecognitionException {
		EModelElementContext _localctx = new EModelElementContext(_ctx, getState(), owner);
		enterRule(_localctx, 52, RULE_eModelElement);
		try {
			setState(953);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(947);
				((EModelElementContext)_localctx).eAnnotation = eAnnotation(_localctx.owner);
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eAnnotation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(950);
				((EModelElementContext)_localctx).eNamedElement = eNamedElement(_localctx.owner);
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
		public Element owner;
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
		public ENamedElementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ENamedElementContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final ENamedElementContext eNamedElement(Element owner) throws RecognitionException {
		ENamedElementContext _localctx = new ENamedElementContext(_ctx, getState(), owner);
		enterRule(_localctx, 54, RULE_eNamedElement);
		try {
			setState(967);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(955);
				((ENamedElementContext)_localctx).eTypedElement = eTypedElement(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eTypedElement.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(958);
				((ENamedElementContext)_localctx).eClassifier = eClassifier(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eClassifier.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(961);
				((ENamedElementContext)_localctx).ePackage = ePackage(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).ePackage.element;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(964);
				((ENamedElementContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.owner);
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
		public Element owner;
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
		public ETypedElementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ETypedElementContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final ETypedElementContext eTypedElement(Element owner) throws RecognitionException {
		ETypedElementContext _localctx = new ETypedElementContext(_ctx, getState(), owner);
		enterRule(_localctx, 56, RULE_eTypedElement);
		try {
			setState(978);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(969);
				((ETypedElementContext)_localctx).eOperation = eOperation(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eOperation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(972);
				((ETypedElementContext)_localctx).eParameter = eParameter(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eParameter.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(975);
				((ETypedElementContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.owner);
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
		public Element owner;
		public EObject element;
		public AnnotationReference current;
		public PathNameContext ownedPathName;
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public EModelElementRefContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EModelElementRefContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EModelElementRefContext eModelElementRef(Element owner) throws RecognitionException {
		EModelElementRefContext _localctx = new EModelElementRefContext(_ctx, getState(), owner);
		enterRule(_localctx, 58, RULE_eModelElementRef);
		((EModelElementRefContext)_localctx).current =  new AnnotationReference(_localctx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(980);
			match(T__60);
			setState(981);
			((EModelElementRefContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(982);
			match(T__17);
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current); if (((EModelElementRefContext)_localctx).ownedPathName.element != null) _localctx.current.setEObject(((EModelElementRefContext)_localctx).element =  ((EModelElementRefContext)_localctx).ownedPathName.element);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public List<ETypeParameter> typeParameters;
		public ETypeParameterContext eTypeParameter;
		public List<ETypeParameterContext> ownedTypeParameters = new ArrayList<ETypeParameterContext>();
		public List<ETypeParameterContext> eTypeParameter() {
			return getRuleContexts(ETypeParameterContext.class);
		}
		public ETypeParameterContext eTypeParameter(int i) {
			return getRuleContext(ETypeParameterContext.class,i);
		}
		public TemplateSignatureContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TemplateSignatureContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final TemplateSignatureContext templateSignature(Element owner) throws RecognitionException {
		TemplateSignatureContext _localctx = new TemplateSignatureContext(_ctx, getState(), owner);
		enterRule(_localctx, 60, RULE_templateSignature);
		((TemplateSignatureContext)_localctx).typeParameters =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(984);
			match(T__61);
			setState(985);
			((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
			((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
			setState(990);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(986);
				match(T__2);
				setState(987);
				((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
				((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
				}
				}
				setState(992);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(993);
			match(T__62);
			}
			_ctx.stop = _input.LT(-1);
			for(ETypeParameterContext ctx: ((TemplateSignatureContext)_localctx).ownedTypeParameters) _localctx.typeParameters.add(ctx.element);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public ETypeParameter element;
		public TypeParameter current;
		public UnrestrictedNameContext name;
		public EGenericTypeContext eGenericType;
		public List<EGenericTypeContext> ownedEBounds = new ArrayList<EGenericTypeContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public List<EGenericTypeContext> eGenericType() {
			return getRuleContexts(EGenericTypeContext.class);
		}
		public EGenericTypeContext eGenericType(int i) {
			return getRuleContext(EGenericTypeContext.class,i);
		}
		public ETypeParameterContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ETypeParameterContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final ETypeParameterContext eTypeParameter(Element owner) throws RecognitionException {
		ETypeParameterContext _localctx = new ETypeParameterContext(_ctx, getState(), owner);
		enterRule(_localctx, 62, RULE_eTypeParameter);
		((ETypeParameterContext)_localctx).element =  eFactory.createETypeParameter();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(995);
			((ETypeParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((ETypeParameterContext)_localctx).name!=null?_input.getText(((ETypeParameterContext)_localctx).name.start,((ETypeParameterContext)_localctx).name.stop):null));
			((ETypeParameterContext)_localctx).current =  new TypeParameter(_localctx.element, _localctx);
			setState(1007);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(998);
				match(T__24);
				setState(999);
				((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
				setState(1004);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__63) {
					{
					{
					setState(1000);
					match(T__63);
					setState(1001);
					((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
					((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
					}
					}
					setState(1006);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			for(EGenericTypeContext ctx: ((ETypeParameterContext)_localctx).ownedEBounds) _localctx.element.getEBounds().add(ctx.element);
			}
			_ctx.stop = _input.LT(-1);
			owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericTypeArgumentContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericTypeArgument current;
		public EGenericTypeContext eGenericType;
		public EGenericWildcardContext eGenericWildcard;
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericWildcardContext eGenericWildcard() {
			return getRuleContext(EGenericWildcardContext.class,0);
		}
		public EGenericTypeArgumentContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericTypeArgumentContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericTypeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericTypeArgumentContext eGenericTypeArgument(Element owner) throws RecognitionException {
		EGenericTypeArgumentContext _localctx = new EGenericTypeArgumentContext(_ctx, getState(), owner);
		enterRule(_localctx, 64, RULE_eGenericTypeArgument);
		((EGenericTypeArgumentContext)_localctx).current =  new GenericTypeArgument(_localctx);
		try {
			setState(1017);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
			case T__18:
			case T__19:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__36:
			case T__38:
			case T__40:
			case T__42:
			case T__43:
			case T__45:
			case T__46:
			case T__47:
			case T__53:
			case T__54:
			case T__55:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__73:
			case T__74:
			case T__75:
			case T__76:
			case T__78:
			case T__80:
			case T__81:
			case T__131:
			case T__132:
			case T__133:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1011);
				((EGenericTypeArgumentContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((EGenericTypeArgumentContext)_localctx).element =  ((EGenericTypeArgumentContext)_localctx).eGenericType.element;
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 2);
				{
				setState(1014);
				((EGenericTypeArgumentContext)_localctx).eGenericWildcard = eGenericWildcard(_localctx.current);
				((EGenericTypeArgumentContext)_localctx).element =  ((EGenericTypeArgumentContext)_localctx).eGenericWildcard.element;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			_localctx.current.setEObject(_localctx.element); _localctx.owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericTypeContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public Element current;
		public PathNameContext ownedPathName;
		public EGenericTypeArgumentContext eGenericTypeArgument;
		public List<EGenericTypeArgumentContext> ownedETypeArguments = new ArrayList<EGenericTypeArgumentContext>();
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public List<EGenericTypeArgumentContext> eGenericTypeArgument() {
			return getRuleContexts(EGenericTypeArgumentContext.class);
		}
		public EGenericTypeArgumentContext eGenericTypeArgument(int i) {
			return getRuleContext(EGenericTypeArgumentContext.class,i);
		}
		public EGenericTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericTypeContext eGenericType(Element owner) throws RecognitionException {
		EGenericTypeContext _localctx = new EGenericTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 66, RULE_eGenericType);
		((EGenericTypeContext)_localctx).element =  eFactory.createEGenericType(); if (_localctx.parent instanceof ETypeParameterContext) ((EGenericTypeContext)_localctx).current =  new GenericType(_localctx.element, _localctx); else ((EGenericTypeContext)_localctx).current =  _localctx.owner;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1019);
			((EGenericTypeContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(1031);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__61) {
				{
				setState(1020);
				match(T__61);
				setState(1021);
				((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
				((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
				setState(1026);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1022);
					match(T__2);
					setState(1023);
					((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
					((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
					}
					}
					setState(1028);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1029);
				match(T__62);
				}
			}

			}
			_ctx.stop = _input.LT(-1);
			if (_localctx.parent instanceof ETypeParameterContext)  owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericElementTypeContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericElementType current;
		public EPrimitiveTypeContext ePrimitiveType;
		public EGenericTypeContext eGenericType;
		public EPrimitiveTypeContext ePrimitiveType() {
			return getRuleContext(EPrimitiveTypeContext.class,0);
		}
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericElementTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericElementTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericElementType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericElementType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericElementType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericElementType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericElementTypeContext eGenericElementType(Element owner) throws RecognitionException {
		EGenericElementTypeContext _localctx = new EGenericElementTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 68, RULE_eGenericElementType);
		((EGenericElementTypeContext)_localctx).current =  new GenericElementType(_localctx);
		try {
			setState(1039);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__68:
			case T__69:
			case T__70:
			case T__71:
			case T__72:
				enterOuterAlt(_localctx, 1);
				{
				setState(1033);
				((EGenericElementTypeContext)_localctx).ePrimitiveType = ePrimitiveType(_localctx.current);
				((EGenericElementTypeContext)_localctx).element =  ((EGenericElementTypeContext)_localctx).ePrimitiveType.element;
				}
				break;
			case T__16:
			case T__18:
			case T__19:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__36:
			case T__38:
			case T__40:
			case T__42:
			case T__43:
			case T__45:
			case T__46:
			case T__47:
			case T__53:
			case T__54:
			case T__55:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__73:
			case T__74:
			case T__75:
			case T__76:
			case T__78:
			case T__80:
			case T__81:
			case T__131:
			case T__132:
			case T__133:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1036);
				((EGenericElementTypeContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((EGenericElementTypeContext)_localctx).element =  ((EGenericElementTypeContext)_localctx).eGenericType.element;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			_localctx.current.setEObject(_localctx.element); _localctx.owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EGenericWildcardContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public GenericWildcard current;
		public Token bound;
		public EGenericTypeContext ownedExtend;
		public EGenericTypeContext eGenericType;
		public EGenericTypeContext eGenericType() {
			return getRuleContext(EGenericTypeContext.class,0);
		}
		public EGenericWildcardContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EGenericWildcardContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eGenericWildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEGenericWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEGenericWildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEGenericWildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EGenericWildcardContext eGenericWildcard(Element owner) throws RecognitionException {
		EGenericWildcardContext _localctx = new EGenericWildcardContext(_ctx, getState(), owner);
		enterRule(_localctx, 70, RULE_eGenericWildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1041);
			match(T__50);
			((EGenericWildcardContext)_localctx).element =  eFactory.createEGenericType(); ((EGenericWildcardContext)_localctx).current =  new GenericWildcard(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);
			setState(1047);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24 || _la==T__64) {
				{
				setState(1043);
				((EGenericWildcardContext)_localctx).bound = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__64) ) {
					((EGenericWildcardContext)_localctx).bound = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1044);
				((EGenericWildcardContext)_localctx).ownedExtend = ((EGenericWildcardContext)_localctx).eGenericType = eGenericType(_localctx.current);
				if (((EGenericWildcardContext)_localctx).bound.equals("extends")) _localctx.element.setEUpperBound(((EGenericWildcardContext)_localctx).eGenericType.element); else _localctx.element.setELowerBound(((EGenericWildcardContext)_localctx).eGenericType.element);
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

	public static class PathNameContext extends ParserRuleContext {
		public Element owner;
		public EObject element;
		public UnrestrictedNameContext firstSegment;
		public SegmentContext segment;
		public List<SegmentContext> midSegments = new ArrayList<SegmentContext>();
		public SegmentContext lastSegment;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public PathNameContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PathNameContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final PathNameContext pathName(Element owner) throws RecognitionException {
		PathNameContext _localctx = new PathNameContext(_ctx, getState(), owner);
		enterRule(_localctx, 72, RULE_pathName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1049);
			((PathNameContext)_localctx).firstSegment = unrestrictedName();
			setState(1057);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__65) {
				{
				setState(1053);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1050);
						((PathNameContext)_localctx).segment = segment();
						((PathNameContext)_localctx).midSegments.add(((PathNameContext)_localctx).segment);
						}
						} 
					}
					setState(1055);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
				}
				setState(1056);
				((PathNameContext)_localctx).lastSegment = segment();
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

	public static class SegmentContext extends ParserRuleContext {
		public UnrestrictedNameContext name;
		public IntegerContext index;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public SegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SegmentContext segment() throws RecognitionException {
		SegmentContext _localctx = new SegmentContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_segment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059);
			match(T__65);
			setState(1061);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__66) {
				{
				setState(1060);
				match(T__66);
				}
			}

			setState(1063);
			((SegmentContext)_localctx).name = unrestrictedName();
			setState(1066);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__67) {
				{
				setState(1064);
				match(T__67);
				setState(1065);
				((SegmentContext)_localctx).index = integer();
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

	public static class EPrimitiveTypeContext extends ParserRuleContext {
		public Element owner;
		public EGenericType element;
		public PrimitiveType current;
		public EPrimitiveTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EPrimitiveTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final EPrimitiveTypeContext ePrimitiveType(Element owner) throws RecognitionException {
		EPrimitiveTypeContext _localctx = new EPrimitiveTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 76, RULE_ePrimitiveType);
		try {
			setState(1078);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__68:
				enterOuterAlt(_localctx, 1);
				{
				setState(1068);
				match(T__68);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBoolean());
				}
				break;
			case T__69:
				enterOuterAlt(_localctx, 2);
				{
				setState(1070);
				match(T__69);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEInt());
				}
				break;
			case T__70:
				enterOuterAlt(_localctx, 3);
				{
				setState(1072);
				match(T__70);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEString());
				}
				break;
			case T__71:
				enterOuterAlt(_localctx, 4);
				{
				setState(1074);
				match(T__71);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBigDecimal());
				}
				break;
			case T__72:
				enterOuterAlt(_localctx, 5);
				{
				setState(1076);
				match(T__72);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBigInteger());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			((EPrimitiveTypeContext)_localctx).current =  new PrimitiveType(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EAnnotation element;
		public Body current;
		public IdentifierContext name;
		public ExpressionContext ownedExpression;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BodyContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final BodyContext body(Element owner) throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState(), owner);
		enterRule(_localctx, 78, RULE_body);
		((BodyContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.BODY); ((BodyContext)_localctx).current =  new Body(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1080);
			match(T__73);
			setState(1082);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1081);
				((BodyContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((BodyContext)_localctx).name!=null?_input.getText(((BodyContext)_localctx).name.start,((BodyContext)_localctx).name.stop):null)); 
			setState(1091);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1085);
				match(T__5);
				setState(1087);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
				case 1:
					{
					setState(1086);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1089);
				match(T__17);
				}
				}
				break;
			case T__17:
				{
				setState(1090);
				match(T__17);
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
		public Element owner;
		public EAnnotation element;
		public Invariant current;
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
		public InvariantContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InvariantContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final InvariantContext invariant(Element owner) throws RecognitionException {
		InvariantContext _localctx = new InvariantContext(_ctx, getState(), owner);
		enterRule(_localctx, 80, RULE_invariant);
		((InvariantContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INVARIANT); ((InvariantContext)_localctx).current =  new Invariant(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1096);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__74) {
				{
				setState(1095);
				((InvariantContext)_localctx).isCallable = match(T__74);
				}
			}

			_localctx.element.getDetails().put("callable", ((InvariantContext)_localctx).isCallable != null ? "true" : "false");
			setState(1099);
			match(T__75);
			setState(1106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1100);
				((InvariantContext)_localctx).name = identifier();
				setState(1104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1101);
					match(T__14);
					setState(1102);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1103);
					match(T__15);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InvariantContext)_localctx).name!=null?_input.getText(((InvariantContext)_localctx).name.start,((InvariantContext)_localctx).name.stop):null)); if(((InvariantContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((InvariantContext)_localctx).message!=null?((InvariantContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1109);
				match(T__5);
				setState(1111);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
				case 1:
					{
					setState(1110);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1113);
				match(T__17);
				}
				}
				break;
			case T__17:
				{
				setState(1114);
				match(T__17);
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
		public Element owner;
		public EAnnotation element;
		public PreCondition current;
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
		public PreconditionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PreconditionContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final PreconditionContext precondition(Element owner) throws RecognitionException {
		PreconditionContext _localctx = new PreconditionContext(_ctx, getState(), owner);
		enterRule(_localctx, 82, RULE_precondition);
		((PreconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.PRECONDITION); ((PreconditionContext)_localctx).current =  new PreCondition(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119);
			_la = _input.LA(1);
			if ( !(_la==T__76 || _la==T__77) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1120);
				((PreconditionContext)_localctx).name = identifier();
				setState(1124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1121);
					match(T__14);
					setState(1122);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1123);
					match(T__15);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PreconditionContext)_localctx).name!=null?_input.getText(((PreconditionContext)_localctx).name.start,((PreconditionContext)_localctx).name.stop):null)); if(((PreconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PreconditionContext)_localctx).message!=null?((PreconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1129);
				match(T__5);
				setState(1131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1130);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1133);
				match(T__17);
				}
				}
				break;
			case T__17:
				{
				setState(1134);
				match(T__17);
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
		public Element owner;
		public EAnnotation element;
		public PostCondition current;
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
		public PostconditionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PostconditionContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final PostconditionContext postcondition(Element owner) throws RecognitionException {
		PostconditionContext _localctx = new PostconditionContext(_ctx, getState(), owner);
		enterRule(_localctx, 84, RULE_postcondition);
		((PostconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.POSTCONDITION); ((PostconditionContext)_localctx).current =  new PostCondition(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1139);
			_la = _input.LA(1);
			if ( !(_la==T__78 || _la==T__79) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1140);
				((PostconditionContext)_localctx).name = identifier();
				setState(1144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(1141);
					match(T__14);
					setState(1142);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1143);
					match(T__15);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PostconditionContext)_localctx).name!=null?_input.getText(((PostconditionContext)_localctx).name.start,((PostconditionContext)_localctx).name.stop):null)); if(((PostconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PostconditionContext)_localctx).message!=null?((PostconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1149);
				match(T__5);
				setState(1151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
				case 1:
					{
					setState(1150);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
					break;
				}
				setState(1153);
				match(T__17);
				}
				}
				break;
			case T__17:
				{
				setState(1154);
				match(T__17);
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
		public Element owner;
		public EAnnotation element;
		public Initial current;
		public IdentifierContext name;
		public ExpressionContext ownedExpression;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitialContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InitialContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final InitialContext initial(Element owner) throws RecognitionException {
		InitialContext _localctx = new InitialContext(_ctx, getState(), owner);
		enterRule(_localctx, 86, RULE_initial);
		((InitialContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INITIAL); ((InitialContext)_localctx).current =  new Initial(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1159);
			match(T__80);
			setState(1161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1160);
				((InitialContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InitialContext)_localctx).name!=null?_input.getText(((InitialContext)_localctx).name.start,((InitialContext)_localctx).name.stop):null));
			setState(1170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1164);
				match(T__5);
				setState(1166);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
				case 1:
					{
					setState(1165);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1168);
				match(T__17);
				}
				}
				break;
			case T__17:
				{
				setState(1169);
				match(T__17);
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
		public Element owner;
		public EAnnotation element;
		public Derivation current;
		public IdentifierContext name;
		public ExpressionContext ownedExpression;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DerivationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public DerivationContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final DerivationContext derivation(Element owner) throws RecognitionException {
		DerivationContext _localctx = new DerivationContext(_ctx, getState(), owner);
		enterRule(_localctx, 88, RULE_derivation);
		((DerivationContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.DERIVATION); ((DerivationContext)_localctx).current =  new Derivation(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1174);
			match(T__81);
			setState(1176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1175);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((DerivationContext)_localctx).name!=null?_input.getText(((DerivationContext)_localctx).name.start,((DerivationContext)_localctx).name.stop):null));
			setState(1185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1179);
				match(T__5);
				setState(1181);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
				case 1:
					{
					setState(1180);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
					break;
				}
				setState(1183);
				match(T__17);
				}
				}
				break;
			case T__17:
				{
				setState(1184);
				match(T__17);
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
		enterRule(_localctx, 90, RULE_visibilityKind);
		((VisibilityKindContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.VISIBILITY);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__82:
				{
				setState(1189);
				((VisibilityKindContext)_localctx).qualifier = match(T__82);
				}
				break;
			case T__83:
				{
				setState(1190);
				((VisibilityKindContext)_localctx).qualifier = match(T__83);
				}
				break;
			case T__84:
				{
				setState(1191);
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
		enterRule(_localctx, 92, RULE_atom);
		try {
			setState(1199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1196);
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
				setState(1198);
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
			setState(1201);
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
			setState(1465);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1204);
				match(T__85);
				setState(1205);
				expression(0);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1206);
				match(T__86);
				setState(1207);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1208);
				match(T__87);
				setState(1209);
				expression(0);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1210);
				match(T__88);
				setState(1211);
				expression(0);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1212);
				((InContext)_localctx).left = expression(0);
				setState(1214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1213);
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

				setState(1216);
				match(T__91);
				setState(1217);
				((InContext)_localctx).right = expression(0);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1219);
				((EqualContext)_localctx).left = expression(0);
				setState(1221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1220);
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

				setState(1223);
				match(T__20);
				setState(1224);
				((EqualContext)_localctx).right = expression(0);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1226);
				((EqContext)_localctx).ileft = intexpression(0);
				setState(1228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1227);
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

				setState(1230);
				match(T__20);
				setState(1231);
				((EqContext)_localctx).iright = intexpression(0);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1233);
				((LtContext)_localctx).ileft = intexpression(0);
				setState(1235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1234);
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

				setState(1237);
				match(T__61);
				setState(1238);
				((LtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1240);
				((LteContext)_localctx).ileft = intexpression(0);
				setState(1242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1241);
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

				setState(1244);
				match(T__92);
				setState(1245);
				((LteContext)_localctx).iright = intexpression(0);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1247);
				((GtContext)_localctx).ileft = intexpression(0);
				setState(1249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1248);
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

				setState(1251);
				match(T__62);
				setState(1252);
				((GtContext)_localctx).iright = intexpression(0);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1254);
				((GteContext)_localctx).ileft = intexpression(0);
				setState(1256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89 || _la==T__90) {
					{
					setState(1255);
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

				setState(1258);
				match(T__93);
				setState(1259);
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
				setState(1262);
				match(T__94);
				setState(1263);
				decls();
				setState(1264);
				match(T__95);
				setState(1265);
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
				setState(1269);
				match(T__96);
				setState(1270);
				match(T__10);
				setState(1271);
				relationId();
				setState(1272);
				match(T__11);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1274);
				match(T__97);
				setState(1275);
				match(T__10);
				setState(1276);
				((FunctionContext)_localctx).rel = relationId();
				setState(1277);
				match(T__5);
				setState(1278);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1279);
				match(T__98);
				setState(1280);
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
				setState(1281);
				((FunctionContext)_localctx).range = expression(0);
				setState(1282);
				match(T__11);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1284);
				match(T__99);
				setState(1285);
				match(T__10);
				setState(1286);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1287);
				match(T__2);
				setState(1288);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1289);
				match(T__2);
				setState(1290);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1291);
				match(T__2);
				setState(1292);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1293);
				match(T__11);
				}
				break;
			case 16:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1295);
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
				setState(1296);
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
				setState(1298);
				match(T__108);
				setState(1299);
				decls();
				setState(1320);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1300);
					match(T__95);
					setState(1310);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
					case 1:
						{
						setState(1301);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1302);
						match(T__1);
						setState(1306);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1303);
								formula(0);
								}
								} 
							}
							setState(1308);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
						}
						setState(1309);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1312);
					match(T__1);
					setState(1316);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1313);
							formula(0);
							}
							} 
						}
						setState(1318);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
					}
					setState(1319);
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
				setState(1325);
				match(T__88);
				setState(1326);
				decls();
				setState(1347);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1327);
					match(T__95);
					setState(1337);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
					case 1:
						{
						setState(1328);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1329);
						match(T__1);
						setState(1333);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1330);
								formula(0);
								}
								} 
							}
							setState(1335);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
						}
						setState(1336);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1339);
					match(T__1);
					setState(1343);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1340);
							formula(0);
							}
							} 
						}
						setState(1345);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
					}
					setState(1346);
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
				setState(1352);
				match(T__85);
				setState(1353);
				decls();
				setState(1374);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1354);
					match(T__95);
					setState(1364);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
					case 1:
						{
						setState(1355);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1356);
						match(T__1);
						setState(1360);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1357);
								formula(0);
								}
								} 
							}
							setState(1362);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
						}
						setState(1363);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1366);
					match(T__1);
					setState(1370);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1367);
							formula(0);
							}
							} 
						}
						setState(1372);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
					}
					setState(1373);
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
				setState(1379);
				match(T__87);
				setState(1380);
				decls();
				setState(1401);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1381);
					match(T__95);
					setState(1391);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
					case 1:
						{
						setState(1382);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1383);
						match(T__1);
						setState(1387);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1384);
								formula(0);
								}
								} 
							}
							setState(1389);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
						}
						setState(1390);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1393);
					match(T__1);
					setState(1397);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1394);
							formula(0);
							}
							} 
						}
						setState(1399);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
					}
					setState(1400);
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
				setState(1406);
				match(T__86);
				setState(1407);
				decls();
				setState(1428);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1408);
					match(T__95);
					setState(1418);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
					case 1:
						{
						setState(1409);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1410);
						match(T__1);
						setState(1414);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1411);
								formula(0);
								}
								} 
							}
							setState(1416);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
						}
						setState(1417);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1420);
					match(T__1);
					setState(1424);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1421);
							formula(0);
							}
							} 
						}
						setState(1426);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
					}
					setState(1427);
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
				setState(1433);
				match(T__109);
				setState(1434);
				letDecls();
				setState(1455);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__95:
					{
					setState(1435);
					match(T__95);
					setState(1445);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
					case 1:
						{
						setState(1436);
						formula(0);
						}
						break;
					case 2:
						{
						setState(1437);
						match(T__1);
						setState(1441);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1438);
								formula(0);
								}
								} 
							}
							setState(1443);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
						}
						setState(1444);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1447);
					match(T__1);
					setState(1451);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1448);
							formula(0);
							}
							} 
						}
						setState(1453);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
					}
					setState(1454);
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
				setState(1459);
				match(T__110);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1460);
				match(T__111);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1461);
				match(T__14);
				setState(1462);
				formula(0);
				setState(1463);
				match(T__15);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1481);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1479);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1467);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1468);
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
						setState(1469);
						((AndContext)_localctx).fright = formula(13);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1470);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1471);
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
						setState(1472);
						((OrContext)_localctx).fright = formula(12);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1473);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1474);
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
						setState(1475);
						((ImpliesContext)_localctx).fright = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1476);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1477);
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
						setState(1478);
						((IffContext)_localctx).fright = formula(10);
						}
						break;
					}
					} 
				}
				setState(1483);
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
		int _startState = 98;
		enterRecursionRule(_localctx, 98, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1521);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1485);
				match(T__112);
				setState(1486);
				expression(19);
				}
				break;
			case 2:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1487);
				match(T__113);
				setState(1488);
				expression(18);
				}
				break;
			case 3:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1489);
				match(T__48);
				setState(1490);
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
				setState(1492);
				match(T__1);
				setState(1493);
				comprehensionDecls();
				setState(1494);
				match(T__95);
				setState(1495);
				formula(0);
				setState(1496);
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
				setState(1500);
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
				setState(1501);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1502);
				match(T__117);
				setState(1503);
				((IfExpressionContext)_localctx).thenExpr = expression(0);
				setState(1504);
				match(T__118);
				setState(1505);
				((IfExpressionContext)_localctx).elseExpr = expression(8);
				}
				break;
			case 6:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1507);
				match(T__119);
				}
				break;
			case 7:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1508);
				match(T__120);
				}
				break;
			case 8:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1509);
				match(T__121);
				}
				break;
			case 9:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1510);
				match(T__122);
				}
				break;
			case 10:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1511);
				match(T__14);
				setState(1512);
				expression(0);
				setState(1513);
				match(T__15);
				}
				break;
			case 11:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1515);
				if (!(!isRelation())) throw new FailedPredicateException(this, "!isRelation()");
				setState(1516);
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
				setState(1519);
				if (!(isRelation())) throw new FailedPredicateException(this, "isRelation()");
				setState(1520);
				relationId();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1554);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,208,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1552);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1523);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1524);
						match(T__49);
						setState(1525);
						((UnionContext)_localctx).right = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1526);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1527);
						match(T__63);
						setState(1528);
						((IntersectionContext)_localctx).right = expression(16);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1529);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1530);
						match(T__114);
						setState(1531);
						((DifferenceContext)_localctx).right = expression(15);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1532);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1533);
						match(T__67);
						setState(1534);
						((JoinContext)_localctx).right = expression(14);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1535);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1537);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__115 - 87)))) != 0)) {
							{
							setState(1536);
							((ProductContext)_localctx).leftMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__115 - 87)))) != 0)) ) {
								((ProductContext)_localctx).leftMult = (Token)_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
						}

						setState(1539);
						match(T__98);
						setState(1541);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
						case 1:
							{
							setState(1540);
							((ProductContext)_localctx).rightMult = _input.LT(1);
							_la = _input.LA(1);
							if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__115 - 87)))) != 0)) ) {
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
						setState(1543);
						((ProductContext)_localctx).right = expression(11);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1544);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1545);
						match(T__116);
						setState(1546);
						((OverrideContext)_localctx).right = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BoxjoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxjoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1547);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1548);
						match(T__10);
						setState(1549);
						((BoxjoinContext)_localctx).left = expression(0);
						setState(1550);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(1556);
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
		int _startState = 100;
		enterRecursionRule(_localctx, 100, RULE_intexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1577);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__104:
			case T__105:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1558);
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
				setState(1559);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1560);
				match(T__117);
				setState(1561);
				((IfIntExpressionContext)_localctx).thenExpr = intexpression(0);
				setState(1562);
				match(T__118);
				setState(1563);
				((IfIntExpressionContext)_localctx).elseExpr = intexpression(10);
				}
				break;
			case T__94:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1565);
				match(T__94);
				setState(1566);
				expression(0);
				}
				break;
			case T__41:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1567);
				match(T__41);
				setState(1568);
				expression(0);
				}
				break;
			case T__114:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1570);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__114) {
					{
					setState(1569);
					((IntConstantContext)_localctx).sign = match(T__114);
					}
				}

				setState(1572);
				integer();
				}
				break;
			case T__14:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1573);
				match(T__14);
				setState(1574);
				intexpression(0);
				setState(1575);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1596);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,212,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1594);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntexpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1579);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1580);
						_la = _input.LA(1);
						if ( !(_la==T__49 || _la==T__123) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1581);
						((PlusContext)_localctx).iright = intexpression(8);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntexpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1582);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1583);
						_la = _input.LA(1);
						if ( !(_la==T__114 || _la==T__124) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1584);
						((MinusContext)_localctx).iright = intexpression(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntexpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1585);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1586);
						_la = _input.LA(1);
						if ( !(_la==T__48 || _la==T__125) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1587);
						((MultiplyContext)_localctx).iright = intexpression(6);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntexpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1588);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1589);
						_la = _input.LA(1);
						if ( !(_la==T__126 || _la==T__127) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1590);
						((DivideContext)_localctx).iright = intexpression(5);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntexpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intexpression);
						setState(1591);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1592);
						_la = _input.LA(1);
						if ( !(_la==T__128 || _la==T__129) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1593);
						((ModuloContext)_localctx).iright = intexpression(4);
						}
						break;
					}
					} 
				}
				setState(1598);
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
		enterRule(_localctx, 102, RULE_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1599);
			decl();
			setState(1604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1600);
				match(T__2);
				setState(1601);
				decl();
				}
				}
				setState(1606);
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
			setState(1673);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1608);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__130) {
					{
					setState(1607);
					((OneOfContext)_localctx).disj = match(T__130);
					}
				}

				setState(1610);
				((OneOfContext)_localctx).variableId = variableId();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
				setState(1615);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1611);
					match(T__2);
					setState(1612);
					((OneOfContext)_localctx).variableId = variableId();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variableId);
					}
					}
					setState(1617);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1618);
				match(T__5);
				setState(1620);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
				case 1:
					{
					setState(1619);
					match(T__87);
					}
					break;
				}
				setState(1622);
				expression(0);
				((FormulaContext)getInvokingContext(48)).var =  declareVariables(((OneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(48)).var);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1626);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__130) {
					{
					setState(1625);
					((LoneOfContext)_localctx).disj = match(T__130);
					}
				}

				setState(1628);
				((LoneOfContext)_localctx).variableId = variableId();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
				setState(1633);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1629);
					match(T__2);
					setState(1630);
					((LoneOfContext)_localctx).variableId = variableId();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variableId);
					}
					}
					setState(1635);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1636);
				match(T__5);
				setState(1637);
				match(T__86);
				setState(1638);
				expression(0);
				((FormulaContext)getInvokingContext(48)).var =  declareVariables(((LoneOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(48)).var);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__130) {
					{
					setState(1641);
					((SomeOfContext)_localctx).disj = match(T__130);
					}
				}

				setState(1644);
				((SomeOfContext)_localctx).variableId = variableId();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
				setState(1649);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1645);
					match(T__2);
					setState(1646);
					((SomeOfContext)_localctx).variableId = variableId();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variableId);
					}
					}
					setState(1651);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1652);
				match(T__5);
				setState(1653);
				match(T__88);
				setState(1654);
				expression(0);
				((FormulaContext)getInvokingContext(48)).var =  declareVariables(((SomeOfContext)_localctx).vars, ((FormulaContext)getInvokingContext(48)).var);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__130) {
					{
					setState(1657);
					((SetOfContext)_localctx).disj = match(T__130);
					}
				}

				setState(1660);
				((SetOfContext)_localctx).variableId = variableId();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
				setState(1665);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1661);
					match(T__2);
					setState(1662);
					((SetOfContext)_localctx).variableId = variableId();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variableId);
					}
					}
					setState(1667);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1668);
				match(T__5);
				setState(1669);
				match(T__115);
				setState(1670);
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
			setState(1675);
			letDecl();
			setState(1680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1676);
				match(T__2);
				setState(1677);
				letDecl();
				}
				}
				setState(1682);
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
			setState(1683);
			((LetDeclContext)_localctx).variableId = variableId();
			((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
			setState(1688);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1684);
				match(T__2);
				setState(1685);
				((LetDeclContext)_localctx).variableId = variableId();
				((LetDeclContext)_localctx).vars.add(((LetDeclContext)_localctx).variableId);
				}
				}
				setState(1690);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1691);
			match(T__20);
			setState(1692);
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
			setState(1696);
			comprehensionDecl();
			setState(1701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1697);
				match(T__2);
				setState(1698);
				comprehensionDecl();
				}
				}
				setState(1703);
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
			setState(1705);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__130) {
				{
				setState(1704);
				((ComprehensionDeclContext)_localctx).disj = match(T__130);
				}
			}

			{
			setState(1707);
			((ComprehensionDeclContext)_localctx).variableId = variableId();
			((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
			setState(1712);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1708);
				match(T__2);
				setState(1709);
				((ComprehensionDeclContext)_localctx).variableId = variableId();
				((ComprehensionDeclContext)_localctx).vars.add(((ComprehensionDeclContext)_localctx).variableId);
				}
				}
				setState(1714);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1715);
			match(T__5);
			setState(1717);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
			case 1:
				{
				setState(1716);
				match(T__87);
				}
				break;
			}
			setState(1719);
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
		enterRule(_localctx, 114, RULE_relationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1723);
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
		enterRule(_localctx, 116, RULE_variableId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1725);
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
		enterRule(_localctx, 118, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1727);
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
			setState(1771);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1729);
				identifier();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(1730);
				match(T__21);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 3);
				{
				setState(1731);
				match(T__31);
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 4);
				{
				setState(1732);
				match(T__73);
				}
				break;
			case T__74:
				enterOuterAlt(_localctx, 5);
				{
				setState(1733);
				match(T__74);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 6);
				{
				setState(1734);
				match(T__22);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 7);
				{
				setState(1735);
				match(T__42);
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 8);
				{
				setState(1736);
				match(T__54);
				}
				break;
			case T__131:
				enterOuterAlt(_localctx, 9);
				{
				setState(1737);
				match(T__131);
				}
				break;
			case T__81:
				enterOuterAlt(_localctx, 10);
				{
				setState(1738);
				match(T__81);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 11);
				{
				setState(1739);
				match(T__32);
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 12);
				{
				setState(1740);
				match(T__57);
				}
				break;
			case T__132:
				enterOuterAlt(_localctx, 13);
				{
				setState(1741);
				match(T__132);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 14);
				{
				setState(1742);
				match(T__24);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 15);
				{
				setState(1743);
				match(T__33);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 16);
				{
				setState(1744);
				match(T__18);
				}
				break;
			case T__80:
				enterOuterAlt(_localctx, 17);
				{
				setState(1745);
				match(T__80);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 18);
				{
				setState(1746);
				match(T__23);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 19);
				{
				setState(1747);
				match(T__45);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 20);
				{
				setState(1748);
				match(T__16);
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 21);
				{
				setState(1749);
				match(T__46);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 22);
				{
				setState(1750);
				match(T__34);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 23);
				{
				setState(1751);
				match(T__19);
				}
				break;
			case T__78:
				enterOuterAlt(_localctx, 24);
				{
				setState(1752);
				match(T__78);
				}
				break;
			case T__76:
				enterOuterAlt(_localctx, 25);
				{
				setState(1753);
				match(T__76);
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 26);
				{
				setState(1754);
				match(T__53);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 27);
				{
				setState(1755);
				match(T__40);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 28);
				{
				setState(1756);
				match(T__30);
				}
				break;
			case T__60:
				enterOuterAlt(_localctx, 29);
				{
				setState(1757);
				match(T__60);
				}
				break;
			case T__133:
				enterOuterAlt(_localctx, 30);
				{
				setState(1758);
				match(T__133);
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 31);
				{
				setState(1759);
				match(T__43);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 32);
				{
				setState(1760);
				match(T__25);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 33);
				{
				setState(1761);
				match(T__47);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 34);
				{
				setState(1762);
				match(T__28);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 35);
				{
				setState(1763);
				match(T__36);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 36);
				{
				setState(1764);
				match(T__38);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 37);
				{
				setState(1765);
				match(T__29);
				}
				break;
			case T__75:
				enterOuterAlt(_localctx, 38);
				{
				setState(1766);
				match(T__75);
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 39);
				{
				setState(1767);
				match(T__58);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 40);
				{
				setState(1768);
				match(T__55);
				}
				break;
			case T__59:
				enterOuterAlt(_localctx, 41);
				{
				setState(1769);
				match(T__59);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 42);
				{
				setState(1770);
				match(T__26);
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
			setState(1773);
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
			setState(1775);
			_la = _input.LA(1);
			if ( !(_la==T__48 || _la==INT) ) {
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
			setState(1777);
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
			setState(1780);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__114) {
				{
				setState(1779);
				match(T__114);
				}
			}

			setState(1782);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0090\u06fb\4\2\t"+
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
		"\t\u0123\n\t\3\n\5\n\u0126\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u012d\n\n\3\n\3"+
		"\n\7\n\u0131\n\n\f\n\16\n\u0134\13\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\5\13\u013f\n\13\3\13\3\13\3\13\3\13\3\f\5\f\u0146\n\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u0161\n\f\f\f\16\f\u0164\13\f\3\f\3\f\5\f\u0168"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0173\n\r\3\16\5\16\u0176"+
		"\n\16\3\16\3\16\5\16\u017a\n\16\3\16\3\16\5\16\u017e\n\16\3\16\3\16\5"+
		"\16\u0182\n\16\3\16\3\16\3\16\5\16\u0187\n\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u018e\n\16\f\16\16\16\u0191\13\16\5\16\u0193\n\16\3\16\3\16\3\16"+
		"\5\16\u0198\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u01a8\n\16\f\16\16\16\u01ab\13\16\3\16\3\16\5\16"+
		"\u01af\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u01b7\n\17\3\20\5\20\u01ba"+
		"\n\20\3\20\3\20\5\20\u01be\n\20\3\20\3\20\5\20\u01c2\n\20\3\20\5\20\u01c5"+
		"\n\20\3\20\5\20\u01c8\n\20\3\20\5\20\u01cb\n\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u01d4\n\20\3\20\3\20\3\20\5\20\u01d9\n\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01e5\n\20\3\20\5\20\u01e8"+
		"\n\20\6\20\u01ea\n\20\r\20\16\20\u01eb\3\20\5\20\u01ef\n\20\3\20\3\20"+
		"\3\20\3\20\7\20\u01f5\n\20\f\20\16\20\u01f8\13\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u0200\n\20\3\20\3\20\3\20\7\20\u0205\n\20\f\20\16\20\u0208"+
		"\13\20\3\20\3\20\5\20\u020c\n\20\3\20\3\20\3\21\5\21\u0211\n\21\3\21\3"+
		"\21\5\21\u0215\n\21\3\21\3\21\5\21\u0219\n\21\3\21\5\21\u021c\n\21\3\21"+
		"\5\21\u021f\n\21\3\21\5\21\u0222\n\21\3\21\3\21\3\21\3\21\3\21\3\21\5"+
		"\21\u022a\n\21\3\21\3\21\3\21\3\21\5\21\u0230\n\21\3\21\3\21\3\21\5\21"+
		"\u0235\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u0243\n\21\3\21\5\21\u0246\n\21\6\21\u0248\n\21\r\21\16\21\u0249"+
		"\3\21\5\21\u024d\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u0254\n\21\f\21\16"+
		"\21\u0257\13\21\3\21\3\21\5\21\u025b\n\21\3\21\3\21\3\21\7\21\u0260\n"+
		"\21\f\21\16\21\u0263\13\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u026b\n"+
		"\21\3\21\3\21\3\21\7\21\u0270\n\21\f\21\16\21\u0273\13\21\3\21\3\21\5"+
		"\21\u0277\n\21\3\21\3\21\3\22\5\22\u027c\n\22\3\22\3\22\5\22\u0280\n\22"+
		"\3\22\3\22\5\22\u0284\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u028d"+
		"\n\22\f\22\16\22\u0290\13\22\5\22\u0292\n\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u029a\n\22\5\22\u029c\n\22\3\22\3\22\3\22\3\22\3\22\3\22\7"+
		"\22\u02a4\n\22\f\22\16\22\u02a7\13\22\5\22\u02a9\n\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\5\22\u02b1\n\22\3\22\5\22\u02b4\n\22\6\22\u02b6\n\22\r\22"+
		"\16\22\u02b7\3\22\5\22\u02bb\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\7\22\u02ca\n\22\f\22\16\22\u02cd\13\22\3"+
		"\22\3\22\5\22\u02d1\n\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u02e1\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u02e9\n\25\3\25\5\25\u02ec\n\25\6\25\u02ee\n\25\r\25\16\25\u02ef"+
		"\3\25\5\25\u02f3\n\25\3\25\3\25\7\25\u02f7\n\25\f\25\16\25\u02fa\13\25"+
		"\3\25\3\25\5\25\u02fe\n\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u0306\n"+
		"\26\3\26\5\26\u0309\n\26\3\26\3\26\5\26\u030d\n\26\3\26\3\26\3\26\3\27"+
		"\5\27\u0313\n\27\3\27\3\27\5\27\u0317\n\27\3\27\3\27\3\27\3\27\3\27\5"+
		"\27\u031e\n\27\3\27\3\27\3\27\5\27\u0323\n\27\3\27\3\27\3\27\3\27\5\27"+
		"\u0329\n\27\3\27\5\27\u032c\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7"+
		"\27\u0335\n\27\f\27\16\27\u0338\13\27\3\27\3\27\5\27\u033c\n\27\3\27\3"+
		"\27\3\30\5\30\u0341\n\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0349\n\30"+
		"\3\30\3\30\3\30\5\30\u034e\n\30\3\30\3\30\3\30\3\30\5\30\u0354\n\30\3"+
		"\30\5\30\u0357\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\7\30\u0363\n\30\f\30\16\30\u0366\13\30\3\30\3\30\5\30\u036a\n\30\3\30"+
		"\3\30\3\31\3\31\3\31\5\31\u0371\n\31\3\31\3\31\3\31\3\31\5\31\u0377\n"+
		"\31\3\31\3\31\3\31\7\31\u037c\n\31\f\31\16\31\u037f\13\31\3\31\3\31\3"+
		"\31\5\31\u0384\n\31\3\32\3\32\5\32\u0388\n\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\7\32\u0390\n\32\f\32\16\32\u0393\13\32\3\32\3\32\5\32\u0397\n\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\6\32\u03a4\n\32"+
		"\r\32\16\32\u03a5\3\32\3\32\3\32\5\32\u03ab\n\32\3\33\5\33\u03ae\n\33"+
		"\3\33\3\33\5\33\u03b2\n\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u03bc\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u03ca\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u03d5"+
		"\n\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \7 \u03df\n \f \16 \u03e2\13 \3 "+
		"\3 \3!\3!\3!\3!\3!\3!\3!\7!\u03ed\n!\f!\16!\u03f0\13!\5!\u03f2\n!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u03fc\n\"\3#\3#\3#\3#\3#\7#\u0403\n#\f#"+
		"\16#\u0406\13#\3#\3#\5#\u040a\n#\3$\3$\3$\3$\3$\3$\5$\u0412\n$\3%\3%\3"+
		"%\3%\3%\3%\5%\u041a\n%\3&\3&\7&\u041e\n&\f&\16&\u0421\13&\3&\5&\u0424"+
		"\n&\3\'\3\'\5\'\u0428\n\'\3\'\3\'\3\'\5\'\u042d\n\'\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\5(\u0439\n(\3)\3)\5)\u043d\n)\3)\3)\3)\5)\u0442\n)\3)\3)"+
		"\5)\u0446\n)\3)\3)\3*\5*\u044b\n*\3*\3*\3*\3*\3*\3*\5*\u0453\n*\5*\u0455"+
		"\n*\3*\3*\3*\5*\u045a\n*\3*\3*\5*\u045e\n*\3*\3*\3+\3+\3+\3+\3+\5+\u0467"+
		"\n+\5+\u0469\n+\3+\3+\3+\5+\u046e\n+\3+\3+\5+\u0472\n+\3+\3+\3,\3,\3,"+
		"\3,\3,\5,\u047b\n,\5,\u047d\n,\3,\3,\3,\5,\u0482\n,\3,\3,\5,\u0486\n,"+
		"\3,\3,\3-\3-\5-\u048c\n-\3-\3-\3-\5-\u0491\n-\3-\3-\5-\u0495\n-\3-\3-"+
		"\3.\3.\5.\u049b\n.\3.\3.\3.\5.\u04a0\n.\3.\3.\5.\u04a4\n.\3.\3.\3/\3/"+
		"\3/\5/\u04ab\n/\3/\3/\3\60\3\60\3\60\5\60\u04b2\n\60\3\61\3\61\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u04c1\n\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u04c8\n\62\3\62\3\62\3\62\3\62\3\62\5\62\u04cf"+
		"\n\62\3\62\3\62\3\62\3\62\3\62\5\62\u04d6\n\62\3\62\3\62\3\62\3\62\3\62"+
		"\5\62\u04dd\n\62\3\62\3\62\3\62\3\62\3\62\5\62\u04e4\n\62\3\62\3\62\3"+
		"\62\3\62\3\62\5\62\u04eb\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u051b\n\62\f\62"+
		"\16\62\u051e\13\62\3\62\5\62\u0521\n\62\3\62\3\62\7\62\u0525\n\62\f\62"+
		"\16\62\u0528\13\62\3\62\5\62\u052b\n\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\7\62\u0536\n\62\f\62\16\62\u0539\13\62\3\62\5\62\u053c"+
		"\n\62\3\62\3\62\7\62\u0540\n\62\f\62\16\62\u0543\13\62\3\62\5\62\u0546"+
		"\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u0551\n\62\f\62"+
		"\16\62\u0554\13\62\3\62\5\62\u0557\n\62\3\62\3\62\7\62\u055b\n\62\f\62"+
		"\16\62\u055e\13\62\3\62\5\62\u0561\n\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\7\62\u056c\n\62\f\62\16\62\u056f\13\62\3\62\5\62\u0572"+
		"\n\62\3\62\3\62\7\62\u0576\n\62\f\62\16\62\u0579\13\62\3\62\5\62\u057c"+
		"\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u0587\n\62\f\62"+
		"\16\62\u058a\13\62\3\62\5\62\u058d\n\62\3\62\3\62\7\62\u0591\n\62\f\62"+
		"\16\62\u0594\13\62\3\62\5\62\u0597\n\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\7\62\u05a2\n\62\f\62\16\62\u05a5\13\62\3\62\5\62\u05a8"+
		"\n\62\3\62\3\62\7\62\u05ac\n\62\f\62\16\62\u05af\13\62\3\62\5\62\u05b2"+
		"\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u05bc\n\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u05ca\n\62\f\62"+
		"\16\62\u05cd\13\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u05f4"+
		"\n\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\5\63\u0604\n\63\3\63\3\63\5\63\u0608\n\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\7\63\u0613\n\63\f\63\16\63\u0616\13\63\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0625"+
		"\n\64\3\64\3\64\3\64\3\64\3\64\5\64\u062c\n\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\7\64\u063d\n\64\f\64"+
		"\16\64\u0640\13\64\3\65\3\65\3\65\7\65\u0645\n\65\f\65\16\65\u0648\13"+
		"\65\3\66\5\66\u064b\n\66\3\66\3\66\3\66\7\66\u0650\n\66\f\66\16\66\u0653"+
		"\13\66\3\66\3\66\5\66\u0657\n\66\3\66\3\66\3\66\3\66\5\66\u065d\n\66\3"+
		"\66\3\66\3\66\7\66\u0662\n\66\f\66\16\66\u0665\13\66\3\66\3\66\3\66\3"+
		"\66\3\66\3\66\5\66\u066d\n\66\3\66\3\66\3\66\7\66\u0672\n\66\f\66\16\66"+
		"\u0675\13\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u067d\n\66\3\66\3\66\3"+
		"\66\7\66\u0682\n\66\f\66\16\66\u0685\13\66\3\66\3\66\3\66\3\66\3\66\5"+
		"\66\u068c\n\66\3\67\3\67\3\67\7\67\u0691\n\67\f\67\16\67\u0694\13\67\3"+
		"8\38\38\78\u0699\n8\f8\168\u069c\138\38\38\38\38\38\39\39\39\79\u06a6"+
		"\n9\f9\169\u06a9\139\3:\5:\u06ac\n:\3:\3:\3:\7:\u06b1\n:\f:\16:\u06b4"+
		"\13:\3:\3:\5:\u06b8\n:\3:\3:\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u06ee\n>\3?\3?\3@\3@\3A\3"+
		"A\3B\5B\u06f7\nB\3B\3B\3B\2\5bdfC\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\2\24\3\2\63\65\3\2\u008c\u008d\4\2\33\33CC\3\2OP\3\2QR\3\2\\]\3\2YZ\3"+
		"\2gh\3\2ij\3\2kl\3\2mn\4\2Y[vv\4\2\64\64~~\4\2uu\177\177\4\2\63\63\u0080"+
		"\u0080\3\2\u0081\u0082\3\2\u0083\u0084\4\2\63\63\u0089\u0089\u0826\2\u0085"+
		"\3\2\2\2\4\u0094\3\2\2\2\6\u00ac\3\2\2\2\b\u00ae\3\2\2\2\n\u00c9\3\2\2"+
		"\2\f\u00d4\3\2\2\2\16\u010a\3\2\2\2\20\u0122\3\2\2\2\22\u0125\3\2\2\2"+
		"\24\u013a\3\2\2\2\26\u0145\3\2\2\2\30\u0172\3\2\2\2\32\u0175\3\2\2\2\34"+
		"\u01b6\3\2\2\2\36\u01b9\3\2\2\2 \u0210\3\2\2\2\"\u027b\3\2\2\2$\u02d4"+
		"\3\2\2\2&\u02d7\3\2\2\2(\u02da\3\2\2\2*\u0301\3\2\2\2,\u0312\3\2\2\2."+
		"\u0340\3\2\2\2\60\u0370\3\2\2\2\62\u0385\3\2\2\2\64\u03ad\3\2\2\2\66\u03bb"+
		"\3\2\2\28\u03c9\3\2\2\2:\u03d4\3\2\2\2<\u03d6\3\2\2\2>\u03da\3\2\2\2@"+
		"\u03e5\3\2\2\2B\u03fb\3\2\2\2D\u03fd\3\2\2\2F\u0411\3\2\2\2H\u0413\3\2"+
		"\2\2J\u041b\3\2\2\2L\u0425\3\2\2\2N\u0438\3\2\2\2P\u043a\3\2\2\2R\u044a"+
		"\3\2\2\2T\u0461\3\2\2\2V\u0475\3\2\2\2X\u0489\3\2\2\2Z\u0498\3\2\2\2\\"+
		"\u04aa\3\2\2\2^\u04b1\3\2\2\2`\u04b3\3\2\2\2b\u05bb\3\2\2\2d\u05f3\3\2"+
		"\2\2f\u062b\3\2\2\2h\u0641\3\2\2\2j\u068b\3\2\2\2l\u068d\3\2\2\2n\u0695"+
		"\3\2\2\2p\u06a2\3\2\2\2r\u06ab\3\2\2\2t\u06bd\3\2\2\2v\u06bf\3\2\2\2x"+
		"\u06c1\3\2\2\2z\u06ed\3\2\2\2|\u06ef\3\2\2\2~\u06f1\3\2\2\2\u0080\u06f3"+
		"\3\2\2\2\u0082\u06f6\3\2\2\2\u0084\u0086\5\4\3\2\u0085\u0084\3\2\2\2\u0085"+
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
		"\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u012c"+
		"\b\n\1\2\u0128\u0129\7\23\2\2\u0129\u012a\5|?\2\u012a\u012b\7\24\2\2\u012b"+
		"\u012d\3\2\2\2\u012c\u0128\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u0132\b\n\1\2\u012f\u0131\5\24\13\2\u0130\u012f\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u0132\3\2\2\2\u0135\u0136\5\26\f\2\u0136\u0137\b\n\1\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\b\n\1\2\u0139\23\3\2\2\2\u013a\u013e\7\25\2"+
		"\2\u013b\u013c\5|?\2\u013c\u013d\7\b\2\2\u013d\u013f\3\2\2\2\u013e\u013b"+
		"\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\7\u008c\2"+
		"\2\u0141\u0142\7\24\2\2\u0142\u0143\b\13\1\2\u0143\25\3\2\2\2\u0144\u0146"+
		"\5\\/\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u0148\b\f\1\2\u0148\u0149\7\26\2\2\u0149\u014a\5z>\2\u014a\u014b\b\f"+
		"\1\2\u014b\u014c\b\f\1\2\u014c\u014d\7\b\2\2\u014d\u014e\5|?\2\u014e\u014f"+
		"\3\2\2\2\u014f\u0150\7\27\2\2\u0150\u0151\7\u008c\2\2\u0151\u0152\3\2"+
		"\2\2\u0152\u0167\b\f\1\2\u0153\u0162\7\4\2\2\u0154\u0155\5\62\32\2\u0155"+
		"\u0156\b\f\1\2\u0156\u0161\3\2\2\2\u0157\u0158\5\26\f\2\u0158\u0159\b"+
		"\f\1\2\u0159\u0161\3\2\2\2\u015a\u015b\5\30\r\2\u015b\u015c\b\f\1\2\u015c"+
		"\u0161\3\2\2\2\u015d\u015e\5R*\2\u015e\u015f\b\f\1\2\u015f\u0161\3\2\2"+
		"\2\u0160\u0154\3\2\2\2\u0160\u0157\3\2\2\2\u0160\u015a\3\2\2\2\u0160\u015d"+
		"\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0168\7\6\2\2\u0166\u0168\7\24"+
		"\2\2\u0167\u0153\3\2\2\2\u0167\u0166\3\2\2\2\u0168\27\3\2\2\2\u0169\u016a"+
		"\5\32\16\2\u016a\u016b\b\r\1\2\u016b\u0173\3\2\2\2\u016c\u016d\5,\27\2"+
		"\u016d\u016e\b\r\1\2\u016e\u0173\3\2\2\2\u016f\u0170\5.\30\2\u0170\u0171"+
		"\b\r\1\2\u0171\u0173\3\2\2\2\u0172\u0169\3\2\2\2\u0172\u016c\3\2\2\2\u0172"+
		"\u016f\3\2\2\2\u0173\31\3\2\2\2\u0174\u0176\5\\/\2\u0175\u0174\3\2\2\2"+
		"\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u017d\b\16\1\2\u0178\u017a"+
		"\7\30\2\2\u0179\u0178\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\3\2\2\2"+
		"\u017b\u017e\7\31\2\2\u017c\u017e\7\32\2\2\u017d\u0179\3\2\2\2\u017d\u017c"+
		"\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\b\16\1\2\u0180\u0182\5z>\2\u0181"+
		"\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0184\b\16"+
		"\1\2\u0184\u0186\b\16\1\2\u0185\u0187\5> \2\u0186\u0185\3\2\2\2\u0186"+
		"\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0192\b\16\1\2\u0189\u018a\7"+
		"\33\2\2\u018a\u018f\5&\24\2\u018b\u018c\7\5\2\2\u018c\u018e\5&\24\2\u018d"+
		"\u018b\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2"+
		"\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0189\3\2\2\2\u0192"+
		"\u0193\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0197\b\16\1\2\u0195\u0196\7"+
		"\b\2\2\u0196\u0198\7\u008c\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2"+
		"\u0198\u0199\3\2\2\2\u0199\u01ae\b\16\1\2\u019a\u01a9\7\4\2\2\u019b\u019c"+
		"\5\62\32\2\u019c\u019d\b\16\1\2\u019d\u01a8\3\2\2\2\u019e\u019f\5\"\22"+
		"\2\u019f\u01a0\b\16\1\2\u01a0\u01a8\3\2\2\2\u01a1\u01a2\5\34\17\2\u01a2"+
		"\u01a3\b\16\1\2\u01a3\u01a8\3\2\2\2\u01a4\u01a5\5R*\2\u01a5\u01a6\b\16"+
		"\1\2\u01a6\u01a8\3\2\2\2\u01a7\u019b\3\2\2\2\u01a7\u019e\3\2\2\2\u01a7"+
		"\u01a1\3\2\2\2\u01a7\u01a4\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2"+
		"\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac"+
		"\u01af\7\6\2\2\u01ad\u01af\7\24\2\2\u01ae\u019a\3\2\2\2\u01ae\u01ad\3"+
		"\2\2\2\u01af\33\3\2\2\2\u01b0\u01b1\5\36\20\2\u01b1\u01b2\b\17\1\2\u01b2"+
		"\u01b7\3\2\2\2\u01b3\u01b4\5 \21\2\u01b4\u01b5\b\17\1\2\u01b5\u01b7\3"+
		"\2\2\2\u01b6\u01b0\3\2\2\2\u01b6\u01b3\3\2\2\2\u01b7\35\3\2\2\2\u01b8"+
		"\u01ba\5\\/\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2"+
		"\2\2\u01bb\u01bd\b\20\1\2\u01bc\u01be\7\34\2\2\u01bd\u01bc\3\2\2\2\u01bd"+
		"\u01be\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01c2\7\35\2\2\u01c0\u01c2\7"+
		"\36\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\u01c4\3\2\2\2\u01c3\u01c5\7\37\2\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3"+
		"\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c8\7 \2\2\u01c7\u01c6\3\2\2\2\u01c7"+
		"\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01cb\7!\2\2\u01ca\u01c9\3\2"+
		"\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\7\"\2\2\u01cd"+
		"\u01ce\5z>\2\u01ce\u01cf\b\20\1\2\u01cf\u01d0\b\20\1\2\u01d0\u01d1\7\b"+
		"\2\2\u01d1\u01d3\5F$\2\u01d2\u01d4\5*\26\2\u01d3\u01d2\3\2\2\2\u01d3\u01d4"+
		"\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d8\b\20\1\2\u01d6\u01d7\7\27\2\2"+
		"\u01d7\u01d9\7\u008c\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\3\2\2\2\u01da\u01ee\b\20\1\2\u01db\u01e9\7\4\2\2\u01dc\u01e5\7"+
		"#\2\2\u01dd\u01e5\7$\2\2\u01de\u01e5\7%\2\2\u01df\u01e5\7&\2\2\u01e0\u01e5"+
		"\7\'\2\2\u01e1\u01e5\7(\2\2\u01e2\u01e5\7)\2\2\u01e3\u01e5\7*\2\2\u01e4"+
		"\u01dc\3\2\2\2\u01e4\u01dd\3\2\2\2\u01e4\u01de\3\2\2\2\u01e4\u01df\3\2"+
		"\2\2\u01e4\u01e0\3\2\2\2\u01e4\u01e1\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4"+
		"\u01e3\3\2\2\2\u01e5\u01e7\3\2\2\2\u01e6\u01e8\7\5\2\2\u01e7\u01e6\3\2"+
		"\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01e4\3\2\2\2\u01ea"+
		"\u01eb\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\3\2"+
		"\2\2\u01ed\u01ef\7\6\2\2\u01ee\u01db\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"\u020b\3\2\2\2\u01f0\u01f6\7\4\2\2\u01f1\u01f2\5\62\32\2\u01f2\u01f3\b"+
		"\20\1\2\u01f3\u01f5\3\2\2\2\u01f4\u01f1\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6"+
		"\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01ff\3\2\2\2\u01f8\u01f6\3\2"+
		"\2\2\u01f9\u01fa\5Z.\2\u01fa\u01fb\b\20\1\2\u01fb\u0200\3\2\2\2\u01fc"+
		"\u01fd\5X-\2\u01fd\u01fe\b\20\1\2\u01fe\u0200\3\2\2\2\u01ff\u01f9\3\2"+
		"\2\2\u01ff\u01fc\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0206\3\2\2\2\u0201"+
		"\u0202\5\62\32\2\u0202\u0203\b\20\1\2\u0203\u0205\3\2\2\2\u0204\u0201"+
		"\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"\u0209\3\2\2\2\u0208\u0206\3\2\2\2\u0209\u020c\7\6\2\2\u020a\u020c\7\24"+
		"\2\2\u020b\u01f0\3\2\2\2\u020b\u020a\3\2\2\2\u020c\u020d\3\2\2\2\u020d"+
		"\u020e\b\20\1\2\u020e\37\3\2\2\2\u020f\u0211\5\\/\2\u0210\u020f\3\2\2"+
		"\2\u0210\u0211\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0214\b\21\1\2\u0213"+
		"\u0215\7\34\2\2\u0214\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0218\3"+
		"\2\2\2\u0216\u0219\7\35\2\2\u0217\u0219\7\36\2\2\u0218\u0216\3\2\2\2\u0218"+
		"\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021b\3\2\2\2\u021a\u021c\7\37"+
		"\2\2\u021b\u021a\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021e\3\2\2\2\u021d"+
		"\u021f\7 \2\2\u021e\u021d\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0221\3\2"+
		"\2\2\u0220\u0222\7!\2\2\u0221\u0220\3\2\2\2\u0221\u0222\3\2\2\2\u0222"+
		"\u0223\3\2\2\2\u0223\u0224\7+\2\2\u0224\u0225\5z>\2\u0225\u0226\b\21\1"+
		"\2\u0226\u0229\b\21\1\2\u0227\u0228\7,\2\2\u0228\u022a\5z>\2\u0229\u0227"+
		"\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022c\b\21\1\2"+
		"\u022c\u022d\7\b\2\2\u022d\u022f\5F$\2\u022e\u0230\5*\26\2\u022f\u022e"+
		"\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0234\b\21\1\2"+
		"\u0232\u0233\7\27\2\2\u0233\u0235\7\u008c\2\2\u0234\u0232\3\2\2\2\u0234"+
		"\u0235\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u024c\b\21\1\2\u0237\u0247\7"+
		"\4\2\2\u0238\u0243\7-\2\2\u0239\u0243\7#\2\2\u023a\u0243\7%\2\2\u023b"+
		"\u0243\7&\2\2\u023c\u0243\7\'\2\2\u023d\u0243\7(\2\2\u023e\u0243\7.\2"+
		"\2\u023f\u0243\7/\2\2\u0240\u0243\7)\2\2\u0241\u0243\7*\2\2\u0242\u0238"+
		"\3\2\2\2\u0242\u0239\3\2\2\2\u0242\u023a\3\2\2\2\u0242\u023b\3\2\2\2\u0242"+
		"\u023c\3\2\2\2\u0242\u023d\3\2\2\2\u0242\u023e\3\2\2\2\u0242\u023f\3\2"+
		"\2\2\u0242\u0240\3\2\2\2\u0242\u0241\3\2\2\2\u0243\u0245\3\2\2\2\u0244"+
		"\u0246\7\5\2\2\u0245\u0244\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0248\3\2"+
		"\2\2\u0247\u0242\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u0247\3\2\2\2\u0249"+
		"\u024a\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024d\7\6\2\2\u024c\u0237\3\2"+
		"\2\2\u024c\u024d\3\2\2\2\u024d\u0276\3\2\2\2\u024e\u025a\7\4\2\2\u024f"+
		"\u0250\7\60\2\2\u0250\u0255\5z>\2\u0251\u0252\7\5\2\2\u0252\u0254\5z>"+
		"\2\u0253\u0251\3\2\2\2\u0254\u0257\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0256"+
		"\3\2\2\2\u0256\u0258\3\2\2\2\u0257\u0255\3\2\2\2\u0258\u0259\7\24\2\2"+
		"\u0259\u025b\3\2\2\2\u025a\u024f\3\2\2\2\u025a\u025b\3\2\2\2\u025b\u0261"+
		"\3\2\2\2\u025c\u025d\5\62\32\2\u025d\u025e\b\21\1\2\u025e\u0260\3\2\2"+
		"\2\u025f\u025c\3\2\2\2\u0260\u0263\3\2\2\2\u0261\u025f\3\2\2\2\u0261\u0262"+
		"\3\2\2\2\u0262\u026a\3\2\2\2\u0263\u0261\3\2\2\2\u0264\u0265\5Z.\2\u0265"+
		"\u0266\b\21\1\2\u0266\u026b\3\2\2\2\u0267\u0268\5X-\2\u0268\u0269\b\21"+
		"\1\2\u0269\u026b\3\2\2\2\u026a\u0264\3\2\2\2\u026a\u0267\3\2\2\2\u026a"+
		"\u026b\3\2\2\2\u026b\u0271\3\2\2\2\u026c\u026d\5\62\32\2\u026d\u026e\b"+
		"\21\1\2\u026e\u0270\3\2\2\2\u026f\u026c\3\2\2\2\u0270\u0273\3\2\2\2\u0271"+
		"\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0274\3\2\2\2\u0273\u0271\3\2"+
		"\2\2\u0274\u0277\7\6\2\2\u0275\u0277\7\24\2\2\u0276\u024e\3\2\2\2\u0276"+
		"\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\b\21\1\2\u0279!\3\2\2\2"+
		"\u027a\u027c\5\\/\2\u027b\u027a\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027d"+
		"\3\2\2\2\u027d\u027f\b\22\1\2\u027e\u0280\7\34\2\2\u027f\u027e\3\2\2\2"+
		"\u027f\u0280\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0283\7\61\2\2\u0282\u0284"+
		"\5> \2\u0283\u0282\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285\3\2\2\2\u0285"+
		"\u0286\b\22\1\2\u0286\u0287\5z>\2\u0287\u0288\b\22\1\2\u0288\u0291\7\21"+
		"\2\2\u0289\u028e\5(\25\2\u028a\u028b\7\5\2\2\u028b\u028d\5(\25\2\u028c"+
		"\u028a\3\2\2\2\u028d\u0290\3\2\2\2\u028e\u028c\3\2\2\2\u028e\u028f\3\2"+
		"\2\2\u028f\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0291\u0289\3\2\2\2\u0291"+
		"\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294\7\22\2\2\u0294\u0295\3"+
		"\2\2\2\u0295\u029b\b\22\1\2\u0296\u0297\7\b\2\2\u0297\u0299\5F$\2\u0298"+
		"\u029a\5*\26\2\u0299\u0298\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u029c\3\2"+
		"\2\2\u029b\u0296\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\3\2\2\2\u029d"+
		"\u029e\b\22\1\2\u029e\u02a8\b\22\1\2\u029f\u02a0\7\62\2\2\u02a0\u02a5"+
		"\5$\23\2\u02a1\u02a2\7\5\2\2\u02a2\u02a4\5$\23\2\u02a3\u02a1\3\2\2\2\u02a4"+
		"\u02a7\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a9\3\2"+
		"\2\2\u02a7\u02a5\3\2\2\2\u02a8\u029f\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9"+
		"\u02aa\3\2\2\2\u02aa\u02ba\b\22\1\2\u02ab\u02b5\7\4\2\2\u02ac\u02b1\7"+
		"%\2\2\u02ad\u02b1\7&\2\2\u02ae\u02b1\7\'\2\2\u02af\u02b1\7(\2\2\u02b0"+
		"\u02ac\3\2\2\2\u02b0\u02ad\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02af\3\2"+
		"\2\2\u02b1\u02b3\3\2\2\2\u02b2\u02b4\7\5\2\2\u02b3\u02b2\3\2\2\2\u02b3"+
		"\u02b4\3\2\2\2\u02b4\u02b6\3\2\2\2\u02b5\u02b0\3\2\2\2\u02b6\u02b7\3\2"+
		"\2\2\u02b7\u02b5\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9"+
		"\u02bb\7\6\2\2\u02ba\u02ab\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02d0\3\2"+
		"\2\2\u02bc\u02cb\7\4\2\2\u02bd\u02be\5\62\32\2\u02be\u02bf\b\22\1\2\u02bf"+
		"\u02ca\3\2\2\2\u02c0\u02c1\5T+\2\u02c1\u02c2\b\22\1\2\u02c2\u02ca\3\2"+
		"\2\2\u02c3\u02c4\5P)\2\u02c4\u02c5\b\22\1\2\u02c5\u02ca\3\2\2\2\u02c6"+
		"\u02c7\5V,\2\u02c7\u02c8\b\22\1\2\u02c8\u02ca\3\2\2\2\u02c9\u02bd\3\2"+
		"\2\2\u02c9\u02c0\3\2\2\2\u02c9\u02c3\3\2\2\2\u02c9\u02c6\3\2\2\2\u02ca"+
		"\u02cd\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02ce\3\2"+
		"\2\2\u02cd\u02cb\3\2\2\2\u02ce\u02d1\7\6\2\2\u02cf\u02d1\7\24\2\2\u02d0"+
		"\u02bc\3\2\2\2\u02d0\u02cf\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d3\b\22"+
		"\1\2\u02d3#\3\2\2\2\u02d4\u02d5\5D#\2\u02d5\u02d6\b\23\1\2\u02d6%\3\2"+
		"\2\2\u02d7\u02d8\5D#\2\u02d8\u02d9\b\24\1\2\u02d9\'\3\2\2\2\u02da\u02db"+
		"\5z>\2\u02db\u02dc\b\25\1\2\u02dc\u02dd\b\25\1\2\u02dd\u02de\7\b\2\2\u02de"+
		"\u02e0\5F$\2\u02df\u02e1\5*\26\2\u02e0\u02df\3\2\2\2\u02e0\u02e1\3\2\2"+
		"\2\u02e1\u02e2\3\2\2\2\u02e2\u02f2\b\25\1\2\u02e3\u02ed\7\4\2\2\u02e4"+
		"\u02e9\7%\2\2\u02e5\u02e9\7&\2\2\u02e6\u02e9\7\'\2\2\u02e7\u02e9\7(\2"+
		"\2\u02e8\u02e4\3\2\2\2\u02e8\u02e5\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e7"+
		"\3\2\2\2\u02e9\u02eb\3\2\2\2\u02ea\u02ec\7\5\2\2\u02eb\u02ea\3\2\2\2\u02eb"+
		"\u02ec\3\2\2\2\u02ec\u02ee\3\2\2\2\u02ed\u02e8\3\2\2\2\u02ee\u02ef\3\2"+
		"\2\2\u02ef\u02ed\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1"+
		"\u02f3\7\6\2\2\u02f2\u02e3\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02fd\3\2"+
		"\2\2\u02f4\u02f8\7\4\2\2\u02f5\u02f7\5\62\32\2\u02f6\u02f5\3\2\2\2\u02f7"+
		"\u02fa\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fb\3\2"+
		"\2\2\u02fa\u02f8\3\2\2\2\u02fb\u02fc\b\25\1\2\u02fc\u02fe\7\6\2\2\u02fd"+
		"\u02f4\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0300\b\25"+
		"\1\2\u0300)\3\2\2\2\u0301\u0308\7\r\2\2\u0302\u0305\5\u0080A\2\u0303\u0304"+
		"\7\20\2\2\u0304\u0306\5~@\2\u0305\u0303\3\2\2\2\u0305\u0306\3\2\2\2\u0306"+
		"\u0309\3\2\2\2\u0307\u0309\t\2\2\2\u0308\u0302\3\2\2\2\u0308\u0307\3\2"+
		"\2\2\u0309\u030c\3\2\2\2\u030a\u030d\7\66\2\2\u030b\u030d\7\67\2\2\u030c"+
		"\u030a\3\2\2\2\u030c\u030b\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u030e\3\2"+
		"\2\2\u030e\u030f\7\16\2\2\u030f\u0310\b\26\1\2\u0310+\3\2\2\2\u0311\u0313"+
		"\5\\/\2\u0312\u0311\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0314\3\2\2\2\u0314"+
		"\u0316\b\27\1\2\u0315\u0317\78\2\2\u0316\u0315\3\2\2\2\u0316\u0317\3\2"+
		"\2\2\u0317\u0318\3\2\2\2\u0318\u0319\79\2\2\u0319\u031a\5z>\2\u031a\u031b"+
		"\b\27\1\2\u031b\u031d\b\27\1\2\u031c\u031e\5> \2\u031d\u031c\3\2\2\2\u031d"+
		"\u031e\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0322\b\27\1\2\u0320\u0321\7"+
		"\b\2\2\u0321\u0323\7\u008c\2\2\u0322\u0320\3\2\2\2\u0322\u0323\3\2\2\2"+
		"\u0323\u0324\3\2\2\2\u0324\u032b\b\27\1\2\u0325\u0328\7\4\2\2\u0326\u0329"+
		"\7:\2\2\u0327\u0329\7;\2\2\u0328\u0326\3\2\2\2\u0328\u0327\3\2\2\2\u0328"+
		"\u0329\3\2\2\2\u0329\u032a\3\2\2\2\u032a\u032c\7\6\2\2\u032b\u0325\3\2"+
		"\2\2\u032b\u032c\3\2\2\2\u032c\u033b\3\2\2\2\u032d\u0336\7\4\2\2\u032e"+
		"\u032f\5\62\32\2\u032f\u0330\b\27\1\2\u0330\u0335\3\2\2\2\u0331\u0332"+
		"\5R*\2\u0332\u0333\b\27\1\2\u0333\u0335\3\2\2\2\u0334\u032e\3\2\2\2\u0334"+
		"\u0331\3\2\2\2\u0335\u0338\3\2\2\2\u0336\u0334\3\2\2\2\u0336\u0337\3\2"+
		"\2\2\u0337\u0339\3\2\2\2\u0338\u0336\3\2\2\2\u0339\u033c\7\6\2\2\u033a"+
		"\u033c\7\24\2\2\u033b\u032d\3\2\2\2\u033b\u033a\3\2\2\2\u033c\u033d\3"+
		"\2\2\2\u033d\u033e\b\27\1\2\u033e-\3\2\2\2\u033f\u0341\5\\/\2\u0340\u033f"+
		"\3\2\2\2\u0340\u0341\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0343\b\30\1\2"+
		"\u0343\u0344\7<\2\2\u0344\u0345\5z>\2\u0345\u0346\b\30\1\2\u0346\u0348"+
		"\b\30\1\2\u0347\u0349\5> \2\u0348\u0347\3\2\2\2\u0348\u0349\3\2\2\2\u0349"+
		"\u034a\3\2\2\2\u034a\u034d\b\30\1\2\u034b\u034c\7\b\2\2\u034c\u034e\7"+
		"\u008c\2\2\u034d\u034b\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u034f\3\2\2\2"+
		"\u034f\u0356\b\30\1\2\u0350\u0353\7\4\2\2\u0351\u0354\7:\2\2\u0352\u0354"+
		"\7;\2\2\u0353\u0351\3\2\2\2\u0353\u0352\3\2\2\2\u0353\u0354\3\2\2\2\u0354"+
		"\u0355\3\2\2\2\u0355\u0357\7\6\2\2\u0356\u0350\3\2\2\2\u0356\u0357\3\2"+
		"\2\2\u0357\u0369\3\2\2\2\u0358\u0364\7\4\2\2\u0359\u035a\5\62\32\2\u035a"+
		"\u035b\b\30\1\2\u035b\u0363\3\2\2\2\u035c\u035d\5\60\31\2\u035d\u035e"+
		"\b\30\1\2\u035e\u0363\3\2\2\2\u035f\u0360\5R*\2\u0360\u0361\b\30\1\2\u0361"+
		"\u0363\3\2\2\2\u0362\u0359\3\2\2\2\u0362\u035c\3\2\2\2\u0362\u035f\3\2"+
		"\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2\2\2\u0364\u0365\3\2\2\2\u0365"+
		"\u0367\3\2\2\2\u0366\u0364\3\2\2\2\u0367\u036a\7\6\2\2\u0368\u036a\7\24"+
		"\2\2\u0369\u0358\3\2\2\2\u0369\u0368\3\2\2\2\u036a\u036b\3\2\2\2\u036b"+
		"\u036c\b\30\1\2\u036c/\3\2\2\2\u036d\u036e\7=\2\2\u036e\u0371\5z>\2\u036f"+
		"\u0371\5z>\2\u0370\u036d\3\2\2\2\u0370\u036f\3\2\2\2\u0371\u0372\3\2\2"+
		"\2\u0372\u0373\b\31\1\2\u0373\u0376\b\31\1\2\u0374\u0375\7\27\2\2\u0375"+
		"\u0377\5\u0082B\2\u0376\u0374\3\2\2\2\u0376\u0377\3\2\2\2\u0377\u0378"+
		"\3\2\2\2\u0378\u0383\b\31\1\2\u0379\u037d\7\4\2\2\u037a\u037c\5\62\32"+
		"\2\u037b\u037a\3\2\2\2\u037c\u037f\3\2\2\2\u037d\u037b\3\2\2\2\u037d\u037e"+
		"\3\2\2\2\u037e\u0380\3\2\2\2\u037f\u037d\3\2\2\2\u0380\u0381\b\31\1\2"+
		"\u0381\u0384\7\6\2\2\u0382\u0384\7\24\2\2\u0383\u0379\3\2\2\2\u0383\u0382"+
		"\3\2\2\2\u0384\61\3\2\2\2\u0385\u0387\7>\2\2\u0386\u0388\7\u008c\2\2\u0387"+
		"\u0386\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038a\b\32"+
		"\1\2\u038a\u0396\b\32\1\2\u038b\u038c\7\21\2\2\u038c\u0391\5\64\33\2\u038d"+
		"\u038e\7\5\2\2\u038e\u0390\5\64\33\2\u038f\u038d\3\2\2\2\u0390\u0393\3"+
		"\2\2\2\u0391\u038f\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u0394\3\2\2\2\u0393"+
		"\u0391\3\2\2\2\u0394\u0395\7\22\2\2\u0395\u0397\3\2\2\2\u0396\u038b\3"+
		"\2\2\2\u0396\u0397\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u03aa\b\32\1\2\u0399"+
		"\u03a3\7\4\2\2\u039a\u039b\5\62\32\2\u039b\u039c\b\32\1\2\u039c\u03a4"+
		"\3\2\2\2\u039d\u039e\5\66\34\2\u039e\u039f\b\32\1\2\u039f\u03a4\3\2\2"+
		"\2\u03a0\u03a1\5<\37\2\u03a1\u03a2\b\32\1\2\u03a2\u03a4\3\2\2\2\u03a3"+
		"\u039a\3\2\2\2\u03a3\u039d\3\2\2\2\u03a3\u03a0\3\2\2\2\u03a4\u03a5\3\2"+
		"\2\2\u03a5\u03a3\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a7\3\2\2\2\u03a7"+
		"\u03a8\7\6\2\2\u03a8\u03ab\3\2\2\2\u03a9\u03ab\7\24\2\2\u03aa\u0399\3"+
		"\2\2\2\u03aa\u03a9\3\2\2\2\u03ab\63\3\2\2\2\u03ac\u03ae\7\u008c\2\2\u03ad"+
		"\u03ac\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03b1\7\27"+
		"\2\2\u03b0\u03b2\t\3\2\2\u03b1\u03b0\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2"+
		"\u03b3\3\2\2\2\u03b3\u03b4\b\33\1\2\u03b4\65\3\2\2\2\u03b5\u03b6\5\62"+
		"\32\2\u03b6\u03b7\b\34\1\2\u03b7\u03bc\3\2\2\2\u03b8\u03b9\58\35\2\u03b9"+
		"\u03ba\b\34\1\2\u03ba\u03bc\3\2\2\2\u03bb\u03b5\3\2\2\2\u03bb\u03b8\3"+
		"\2\2\2\u03bc\67\3\2\2\2\u03bd\u03be\5:\36\2\u03be\u03bf\b\35\1\2\u03bf"+
		"\u03ca\3\2\2\2\u03c0\u03c1\5\30\r\2\u03c1\u03c2\b\35\1\2\u03c2\u03ca\3"+
		"\2\2\2\u03c3\u03c4\5\26\f\2\u03c4\u03c5\b\35\1\2\u03c5\u03ca\3\2\2\2\u03c6"+
		"\u03c7\5\60\31\2\u03c7\u03c8\b\35\1\2\u03c8\u03ca\3\2\2\2\u03c9\u03bd"+
		"\3\2\2\2\u03c9\u03c0\3\2\2\2\u03c9\u03c3\3\2\2\2\u03c9\u03c6\3\2\2\2\u03ca"+
		"9\3\2\2\2\u03cb\u03cc\5\"\22\2\u03cc\u03cd\b\36\1\2\u03cd\u03d5\3\2\2"+
		"\2\u03ce\u03cf\5(\25\2\u03cf\u03d0\b\36\1\2\u03d0\u03d5\3\2\2\2\u03d1"+
		"\u03d2\5\34\17\2\u03d2\u03d3\b\36\1\2\u03d3\u03d5\3\2\2\2\u03d4\u03cb"+
		"\3\2\2\2\u03d4\u03ce\3\2\2\2\u03d4\u03d1\3\2\2\2\u03d5;\3\2\2\2\u03d6"+
		"\u03d7\7?\2\2\u03d7\u03d8\5J&\2\u03d8\u03d9\7\24\2\2\u03d9=\3\2\2\2\u03da"+
		"\u03db\7@\2\2\u03db\u03e0\5@!\2\u03dc\u03dd\7\5\2\2\u03dd\u03df\5@!\2"+
		"\u03de\u03dc\3\2\2\2\u03df\u03e2\3\2\2\2\u03e0\u03de\3\2\2\2\u03e0\u03e1"+
		"\3\2\2\2\u03e1\u03e3\3\2\2\2\u03e2\u03e0\3\2\2\2\u03e3\u03e4\7A\2\2\u03e4"+
		"?\3\2\2\2\u03e5\u03e6\5z>\2\u03e6\u03e7\b!\1\2\u03e7\u03f1\b!\1\2\u03e8"+
		"\u03e9\7\33\2\2\u03e9\u03ee\5D#\2\u03ea\u03eb\7B\2\2\u03eb\u03ed\5D#\2"+
		"\u03ec\u03ea\3\2\2\2\u03ed\u03f0\3\2\2\2\u03ee\u03ec\3\2\2\2\u03ee\u03ef"+
		"\3\2\2\2\u03ef\u03f2\3\2\2\2\u03f0\u03ee\3\2\2\2\u03f1\u03e8\3\2\2\2\u03f1"+
		"\u03f2\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f4\b!\1\2\u03f4A\3\2\2\2\u03f5"+
		"\u03f6\5D#\2\u03f6\u03f7\b\"\1\2\u03f7\u03fc\3\2\2\2\u03f8\u03f9\5H%\2"+
		"\u03f9\u03fa\b\"\1\2\u03fa\u03fc\3\2\2\2\u03fb\u03f5\3\2\2\2\u03fb\u03f8"+
		"\3\2\2\2\u03fcC\3\2\2\2\u03fd\u0409\5J&\2\u03fe\u03ff\7@\2\2\u03ff\u0404"+
		"\5B\"\2\u0400\u0401\7\5\2\2\u0401\u0403\5B\"\2\u0402\u0400\3\2\2\2\u0403"+
		"\u0406\3\2\2\2\u0404\u0402\3\2\2\2\u0404\u0405\3\2\2\2\u0405\u0407\3\2"+
		"\2\2\u0406\u0404\3\2\2\2\u0407\u0408\7A\2\2\u0408\u040a\3\2\2\2\u0409"+
		"\u03fe\3\2\2\2\u0409\u040a\3\2\2\2\u040aE\3\2\2\2\u040b\u040c\5N(\2\u040c"+
		"\u040d\b$\1\2\u040d\u0412\3\2\2\2\u040e\u040f\5D#\2\u040f\u0410\b$\1\2"+
		"\u0410\u0412\3\2\2\2\u0411\u040b\3\2\2\2\u0411\u040e\3\2\2\2\u0412G\3"+
		"\2\2\2\u0413\u0414\7\65\2\2\u0414\u0419\b%\1\2\u0415\u0416\t\4\2\2\u0416"+
		"\u0417\5D#\2\u0417\u0418\b%\1\2\u0418\u041a\3\2\2\2\u0419\u0415\3\2\2"+
		"\2\u0419\u041a\3\2\2\2\u041aI\3\2\2\2\u041b\u0423\5z>\2\u041c\u041e\5"+
		"L\'\2\u041d\u041c\3\2\2\2\u041e\u0421\3\2\2\2\u041f\u041d\3\2\2\2\u041f"+
		"\u0420\3\2\2\2\u0420\u0422\3\2\2\2\u0421\u041f\3\2\2\2\u0422\u0424\5L"+
		"\'\2\u0423\u041f\3\2\2\2\u0423\u0424\3\2\2\2\u0424K\3\2\2\2\u0425\u0427"+
		"\7D\2\2\u0426\u0428\7E\2\2\u0427\u0426\3\2\2\2\u0427\u0428\3\2\2\2\u0428"+
		"\u0429\3\2\2\2\u0429\u042c\5z>\2\u042a\u042b\7F\2\2\u042b\u042d\5x=\2"+
		"\u042c\u042a\3\2\2\2\u042c\u042d\3\2\2\2\u042dM\3\2\2\2\u042e\u042f\7"+
		"G\2\2\u042f\u0439\b(\1\2\u0430\u0431\7H\2\2\u0431\u0439\b(\1\2\u0432\u0433"+
		"\7I\2\2\u0433\u0439\b(\1\2\u0434\u0435\7J\2\2\u0435\u0439\b(\1\2\u0436"+
		"\u0437\7K\2\2\u0437\u0439\b(\1\2\u0438\u042e\3\2\2\2\u0438\u0430\3\2\2"+
		"\2\u0438\u0432\3\2\2\2\u0438\u0434\3\2\2\2\u0438\u0436\3\2\2\2\u0439O"+
		"\3\2\2\2\u043a\u043c\7L\2\2\u043b\u043d\5|?\2\u043c\u043b\3\2\2\2\u043c"+
		"\u043d\3\2\2\2\u043d\u043e\3\2\2\2\u043e\u0445\b)\1\2\u043f\u0441\7\b"+
		"\2\2\u0440\u0442\5d\63\2\u0441\u0440\3\2\2\2\u0441\u0442\3\2\2\2\u0442"+
		"\u0443\3\2\2\2\u0443\u0446\7\24\2\2\u0444\u0446\7\24\2\2\u0445\u043f\3"+
		"\2\2\2\u0445\u0444\3\2\2\2\u0446\u0447\3\2\2\2\u0447\u0448\b)\1\2\u0448"+
		"Q\3\2\2\2\u0449\u044b\7M\2\2\u044a\u0449\3\2\2\2\u044a\u044b\3\2\2\2\u044b"+
		"\u044c\3\2\2\2\u044c\u044d\b*\1\2\u044d\u0454\7N\2\2\u044e\u0452\5|?\2"+
		"\u044f\u0450\7\21\2\2\u0450\u0451\7\u008b\2\2\u0451\u0453\7\22\2\2\u0452"+
		"\u044f\3\2\2\2\u0452\u0453\3\2\2\2\u0453\u0455\3\2\2\2\u0454\u044e\3\2"+
		"\2\2\u0454\u0455\3\2\2\2\u0455\u0456\3\2\2\2\u0456\u045d\b*\1\2\u0457"+
		"\u0459\7\b\2\2\u0458\u045a\5b\62\2\u0459\u0458\3\2\2\2\u0459\u045a\3\2"+
		"\2\2\u045a\u045b\3\2\2\2\u045b\u045e\7\24\2\2\u045c\u045e\7\24\2\2\u045d"+
		"\u0457\3\2\2\2\u045d\u045c\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0460\b*"+
		"\1\2\u0460S\3\2\2\2\u0461\u0468\t\5\2\2\u0462\u0466\5|?\2\u0463\u0464"+
		"\7\21\2\2\u0464\u0465\7\u008b\2\2\u0465\u0467\7\22\2\2\u0466\u0463\3\2"+
		"\2\2\u0466\u0467\3\2\2\2\u0467\u0469\3\2\2\2\u0468\u0462\3\2\2\2\u0468"+
		"\u0469\3\2\2\2\u0469\u046a\3\2\2\2\u046a\u0471\b+\1\2\u046b\u046d\7\b"+
		"\2\2\u046c\u046e\5b\62\2\u046d\u046c\3\2\2\2\u046d\u046e\3\2\2\2\u046e"+
		"\u046f\3\2\2\2\u046f\u0472\7\24\2\2\u0470\u0472\7\24\2\2\u0471\u046b\3"+
		"\2\2\2\u0471\u0470\3\2\2\2\u0472\u0473\3\2\2\2\u0473\u0474\b+\1\2\u0474"+
		"U\3\2\2\2\u0475\u047c\t\6\2\2\u0476\u047a\5|?\2\u0477\u0478\7\21\2\2\u0478"+
		"\u0479\7\u008b\2\2\u0479\u047b\7\22\2\2\u047a\u0477\3\2\2\2\u047a\u047b"+
		"\3\2\2\2\u047b\u047d\3\2\2\2\u047c\u0476\3\2\2\2\u047c\u047d\3\2\2\2\u047d"+
		"\u047e\3\2\2\2\u047e\u0485\b,\1\2\u047f\u0481\7\b\2\2\u0480\u0482\5b\62"+
		"\2\u0481\u0480\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u0486"+
		"\7\24\2\2\u0484\u0486\7\24\2\2\u0485\u047f\3\2\2\2\u0485\u0484\3\2\2\2"+
		"\u0486\u0487\3\2\2\2\u0487\u0488\b,\1\2\u0488W\3\2\2\2\u0489\u048b\7S"+
		"\2\2\u048a\u048c\5|?\2\u048b\u048a\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u048d"+
		"\3\2\2\2\u048d\u0494\b-\1\2\u048e\u0490\7\b\2\2\u048f\u0491\5d\63\2\u0490"+
		"\u048f\3\2\2\2\u0490\u0491\3\2\2\2\u0491\u0492\3\2\2\2\u0492\u0495\7\24"+
		"\2\2\u0493\u0495\7\24\2\2\u0494\u048e\3\2\2\2\u0494\u0493\3\2\2\2\u0495"+
		"\u0496\3\2\2\2\u0496\u0497\b-\1\2\u0497Y\3\2\2\2\u0498\u049a\7T\2\2\u0499"+
		"\u049b\5|?\2\u049a\u0499\3\2\2\2\u049a\u049b\3\2\2\2\u049b\u049c\3\2\2"+
		"\2\u049c\u04a3\b.\1\2\u049d\u049f\7\b\2\2\u049e\u04a0\5d\63\2\u049f\u049e"+
		"\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04a1\3\2\2\2\u04a1\u04a4\7\24\2\2"+
		"\u04a2\u04a4\7\24\2\2\u04a3\u049d\3\2\2\2\u04a3\u04a2\3\2\2\2\u04a4\u04a5"+
		"\3\2\2\2\u04a5\u04a6\b.\1\2\u04a6[\3\2\2\2\u04a7\u04ab\7U\2\2\u04a8\u04ab"+
		"\7V\2\2\u04a9\u04ab\7W\2\2\u04aa\u04a7\3\2\2\2\u04aa\u04a8\3\2\2\2\u04aa"+
		"\u04a9\3\2\2\2\u04ab\u04ac\3\2\2\2\u04ac\u04ad\b/\1\2\u04ad]\3\2\2\2\u04ae"+
		"\u04af\7\u008a\2\2\u04af\u04b2\b\60\1\2\u04b0\u04b2\7\u0089\2\2\u04b1"+
		"\u04ae\3\2\2\2\u04b1\u04b0\3\2\2\2\u04b2_\3\2\2\2\u04b3\u04b4\7\u0089"+
		"\2\2\u04b4a\3\2\2\2\u04b5\u04b6\b\62\1\2\u04b6\u04b7\7X\2\2\u04b7\u05bc"+
		"\5d\63\2\u04b8\u04b9\7Y\2\2\u04b9\u05bc\5d\63\2\u04ba\u04bb\7Z\2\2\u04bb"+
		"\u05bc\5d\63\2\u04bc\u04bd\7[\2\2\u04bd\u05bc\5d\63\2\u04be\u04c0\5d\63"+
		"\2\u04bf\u04c1\t\7\2\2\u04c0\u04bf\3\2\2\2\u04c0\u04c1\3\2\2\2\u04c1\u04c2"+
		"\3\2\2\2\u04c2\u04c3\7^\2\2\u04c3\u04c4\5d\63\2\u04c4\u05bc\3\2\2\2\u04c5"+
		"\u04c7\5d\63\2\u04c6\u04c8\t\7\2\2\u04c7\u04c6\3\2\2\2\u04c7\u04c8\3\2"+
		"\2\2\u04c8\u04c9\3\2\2\2\u04c9\u04ca\7\27\2\2\u04ca\u04cb\5d\63\2\u04cb"+
		"\u05bc\3\2\2\2\u04cc\u04ce\5f\64\2\u04cd\u04cf\t\7\2\2\u04ce\u04cd\3\2"+
		"\2\2\u04ce\u04cf\3\2\2\2\u04cf\u04d0\3\2\2\2\u04d0\u04d1\7\27\2\2\u04d1"+
		"\u04d2\5f\64\2\u04d2\u05bc\3\2\2\2\u04d3\u04d5\5f\64\2\u04d4\u04d6\t\7"+
		"\2\2\u04d5\u04d4\3\2\2\2\u04d5\u04d6\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7"+
		"\u04d8\7@\2\2\u04d8\u04d9\5f\64\2\u04d9\u05bc\3\2\2\2\u04da\u04dc\5f\64"+
		"\2\u04db\u04dd\t\7\2\2\u04dc\u04db\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd\u04de"+
		"\3\2\2\2\u04de\u04df\7_\2\2\u04df\u04e0\5f\64\2\u04e0\u05bc\3\2\2\2\u04e1"+
		"\u04e3\5f\64\2\u04e2\u04e4\t\7\2\2\u04e3\u04e2\3\2\2\2\u04e3\u04e4\3\2"+
		"\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04e6\7A\2\2\u04e6\u04e7\5f\64\2\u04e7"+
		"\u05bc\3\2\2\2\u04e8\u04ea\5f\64\2\u04e9\u04eb\t\7\2\2\u04ea\u04e9\3\2"+
		"\2\2\u04ea\u04eb\3\2\2\2\u04eb\u04ec\3\2\2\2\u04ec\u04ed\7`\2\2\u04ed"+
		"\u04ee\5f\64\2\u04ee\u05bc\3\2\2\2\u04ef\u04f0\b\62\1\2\u04f0\u04f1\7"+
		"a\2\2\u04f1\u04f2\5h\65\2\u04f2\u04f3\7b\2\2\u04f3\u04f4\5f\64\2\u04f4"+
		"\u04f5\3\2\2\2\u04f5\u04f6\b\62\1\2\u04f6\u05bc\3\2\2\2\u04f7\u04f8\7"+
		"c\2\2\u04f8\u04f9\7\r\2\2\u04f9\u04fa\5t;\2\u04fa\u04fb\7\16\2\2\u04fb"+
		"\u05bc\3\2\2\2\u04fc\u04fd\7d\2\2\u04fd\u04fe\7\r\2\2\u04fe\u04ff\5t;"+
		"\2\u04ff\u0500\7\b\2\2\u0500\u0501\5d\63\2\u0501\u0502\7e\2\2\u0502\u0503"+
		"\t\b\2\2\u0503\u0504\5d\63\2\u0504\u0505\7\16\2\2\u0505\u05bc\3\2\2\2"+
		"\u0506\u0507\7f\2\2\u0507\u0508\7\r\2\2\u0508\u0509\5t;\2\u0509\u050a"+
		"\7\5\2\2\u050a\u050b\5t;\2\u050b\u050c\7\5\2\2\u050c\u050d\5t;\2\u050d"+
		"\u050e\7\5\2\2\u050e\u050f\5t;\2\u050f\u0510\7\16\2\2\u0510\u05bc\3\2"+
		"\2\2\u0511\u0512\t\7\2\2\u0512\u05bc\5b\62\20\u0513\u0514\b\62\1\2\u0514"+
		"\u0515\7o\2\2\u0515\u052a\5h\65\2\u0516\u0520\7b\2\2\u0517\u0521\5b\62"+
		"\2\u0518\u051c\7\4\2\2\u0519\u051b\5b\62\2\u051a\u0519\3\2\2\2\u051b\u051e"+
		"\3\2\2\2\u051c\u051a\3\2\2\2\u051c\u051d\3\2\2\2\u051d\u051f\3\2\2\2\u051e"+
		"\u051c\3\2\2\2\u051f\u0521\7\6\2\2\u0520\u0517\3\2\2\2\u0520\u0518\3\2"+
		"\2\2\u0521\u052b\3\2\2\2\u0522\u0526\7\4\2\2\u0523\u0525\5b\62\2\u0524"+
		"\u0523\3\2\2\2\u0525\u0528\3\2\2\2\u0526\u0524\3\2\2\2\u0526\u0527\3\2"+
		"\2\2\u0527\u0529\3\2\2\2\u0528\u0526\3\2\2\2\u0529\u052b\7\6\2\2\u052a"+
		"\u0516\3\2\2\2\u052a\u0522\3\2\2\2\u052b\u052c\3\2\2\2\u052c\u052d\b\62"+
		"\1\2\u052d\u05bc\3\2\2\2\u052e\u052f\b\62\1\2\u052f\u0530\7[\2\2\u0530"+
		"\u0545\5h\65\2\u0531\u053b\7b\2\2\u0532\u053c\5b\62\2\u0533\u0537\7\4"+
		"\2\2\u0534\u0536\5b\62\2\u0535\u0534\3\2\2\2\u0536\u0539\3\2\2\2\u0537"+
		"\u0535\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u053a\3\2\2\2\u0539\u0537\3\2"+
		"\2\2\u053a\u053c\7\6\2\2\u053b\u0532\3\2\2\2\u053b\u0533\3\2\2\2\u053c"+
		"\u0546\3\2\2\2\u053d\u0541\7\4\2\2\u053e\u0540\5b\62\2\u053f\u053e\3\2"+
		"\2\2\u0540\u0543\3\2\2\2\u0541\u053f\3\2\2\2\u0541\u0542\3\2\2\2\u0542"+
		"\u0544\3\2\2\2\u0543\u0541\3\2\2\2\u0544\u0546\7\6\2\2\u0545\u0531\3\2"+
		"\2\2\u0545\u053d\3\2\2\2\u0546\u0547\3\2\2\2\u0547\u0548\b\62\1\2\u0548"+
		"\u05bc\3\2\2\2\u0549\u054a\b\62\1\2\u054a\u054b\7X\2\2\u054b\u0560\5h"+
		"\65\2\u054c\u0556\7b\2\2\u054d\u0557\5b\62\2\u054e\u0552\7\4\2\2\u054f"+
		"\u0551\5b\62\2\u0550\u054f\3\2\2\2\u0551\u0554\3\2\2\2\u0552\u0550\3\2"+
		"\2\2\u0552\u0553\3\2\2\2\u0553\u0555\3\2\2\2\u0554\u0552\3\2\2\2\u0555"+
		"\u0557\7\6\2\2\u0556\u054d\3\2\2\2\u0556\u054e\3\2\2\2\u0557\u0561\3\2"+
		"\2\2\u0558\u055c\7\4\2\2\u0559\u055b\5b\62\2\u055a\u0559\3\2\2\2\u055b"+
		"\u055e\3\2\2\2\u055c\u055a\3\2\2\2\u055c\u055d\3\2\2\2\u055d\u055f\3\2"+
		"\2\2\u055e\u055c\3\2\2\2\u055f\u0561\7\6\2\2\u0560\u054c\3\2\2\2\u0560"+
		"\u0558\3\2\2\2\u0561\u0562\3\2\2\2\u0562\u0563\b\62\1\2\u0563\u05bc\3"+
		"\2\2\2\u0564\u0565\b\62\1\2\u0565\u0566\7Z\2\2\u0566\u057b\5h\65\2\u0567"+
		"\u0571\7b\2\2\u0568\u0572\5b\62\2\u0569\u056d\7\4\2\2\u056a\u056c\5b\62"+
		"\2\u056b\u056a\3\2\2\2\u056c\u056f\3\2\2\2\u056d\u056b\3\2\2\2\u056d\u056e"+
		"\3\2\2\2\u056e\u0570\3\2\2\2\u056f\u056d\3\2\2\2\u0570\u0572\7\6\2\2\u0571"+
		"\u0568\3\2\2\2\u0571\u0569\3\2\2\2\u0572\u057c\3\2\2\2\u0573\u0577\7\4"+
		"\2\2\u0574\u0576\5b\62\2\u0575\u0574\3\2\2\2\u0576\u0579\3\2\2\2\u0577"+
		"\u0575\3\2\2\2\u0577\u0578\3\2\2\2\u0578\u057a\3\2\2\2\u0579\u0577\3\2"+
		"\2\2\u057a\u057c\7\6\2\2\u057b\u0567\3\2\2\2\u057b\u0573\3\2\2\2\u057c"+
		"\u057d\3\2\2\2\u057d\u057e\b\62\1\2\u057e\u05bc\3\2\2\2\u057f\u0580\b"+
		"\62\1\2\u0580\u0581\7Y\2\2\u0581\u0596\5h\65\2\u0582\u058c\7b\2\2\u0583"+
		"\u058d\5b\62\2\u0584\u0588\7\4\2\2\u0585\u0587\5b\62\2\u0586\u0585\3\2"+
		"\2\2\u0587\u058a\3\2\2\2\u0588\u0586\3\2\2\2\u0588\u0589\3\2\2\2\u0589"+
		"\u058b\3\2\2\2\u058a\u0588\3\2\2\2\u058b\u058d\7\6\2\2\u058c\u0583\3\2"+
		"\2\2\u058c\u0584\3\2\2\2\u058d\u0597\3\2\2\2\u058e\u0592\7\4\2\2\u058f"+
		"\u0591\5b\62\2\u0590\u058f\3\2\2\2\u0591\u0594\3\2\2\2\u0592\u0590\3\2"+
		"\2\2\u0592\u0593\3\2\2\2\u0593\u0595\3\2\2\2\u0594\u0592\3\2\2\2\u0595"+
		"\u0597\7\6\2\2\u0596\u0582\3\2\2\2\u0596\u058e\3\2\2\2\u0597\u0598\3\2"+
		"\2\2\u0598\u0599\b\62\1\2\u0599\u05bc\3\2\2\2\u059a\u059b\b\62\1\2\u059b"+
		"\u059c\7p\2\2\u059c\u05b1\5l\67\2\u059d\u05a7\7b\2\2\u059e\u05a8\5b\62"+
		"\2\u059f\u05a3\7\4\2\2\u05a0\u05a2\5b\62\2\u05a1\u05a0\3\2\2\2\u05a2\u05a5"+
		"\3\2\2\2\u05a3\u05a1\3\2\2\2\u05a3\u05a4\3\2\2\2\u05a4\u05a6\3\2\2\2\u05a5"+
		"\u05a3\3\2\2\2\u05a6\u05a8\7\6\2\2\u05a7\u059e\3\2\2\2\u05a7\u059f\3\2"+
		"\2\2\u05a8\u05b2\3\2\2\2\u05a9\u05ad\7\4\2\2\u05aa\u05ac\5b\62\2\u05ab"+
		"\u05aa\3\2\2\2\u05ac\u05af\3\2\2\2\u05ad\u05ab\3\2\2\2\u05ad\u05ae\3\2"+
		"\2\2\u05ae\u05b0\3\2\2\2\u05af\u05ad\3\2\2\2\u05b0\u05b2\7\6\2\2\u05b1"+
		"\u059d\3\2\2\2\u05b1\u05a9\3\2\2\2\u05b2\u05b3\3\2\2\2\u05b3\u05b4\b\62"+
		"\1\2\u05b4\u05bc\3\2\2\2\u05b5\u05bc\7q\2\2\u05b6\u05bc\7r\2\2\u05b7\u05b8"+
		"\7\21\2\2\u05b8\u05b9\5b\62\2\u05b9\u05ba\7\22\2\2\u05ba\u05bc\3\2\2\2"+
		"\u05bb\u04b5\3\2\2\2\u05bb\u04b8\3\2\2\2\u05bb\u04ba\3\2\2\2\u05bb\u04bc"+
		"\3\2\2\2\u05bb\u04be\3\2\2\2\u05bb\u04c5\3\2\2\2\u05bb\u04cc\3\2\2\2\u05bb"+
		"\u04d3\3\2\2\2\u05bb\u04da\3\2\2\2\u05bb\u04e1\3\2\2\2\u05bb\u04e8\3\2"+
		"\2\2\u05bb\u04ef\3\2\2\2\u05bb\u04f7\3\2\2\2\u05bb\u04fc\3\2\2\2\u05bb"+
		"\u0506\3\2\2\2\u05bb\u0511\3\2\2\2\u05bb\u0513\3\2\2\2\u05bb\u052e\3\2"+
		"\2\2\u05bb\u0549\3\2\2\2\u05bb\u0564\3\2\2\2\u05bb\u057f\3\2\2\2\u05bb"+
		"\u059a\3\2\2\2\u05bb\u05b5\3\2\2\2\u05bb\u05b6\3\2\2\2\u05bb\u05b7\3\2"+
		"\2\2\u05bc\u05cb\3\2\2\2\u05bd\u05be\f\17\2\2\u05be\u05bf\t\t\2\2\u05bf"+
		"\u05ca\5b\62\17\u05c0\u05c1\f\16\2\2\u05c1\u05c2\t\n\2\2\u05c2\u05ca\5"+
		"b\62\16\u05c3\u05c4\f\r\2\2\u05c4\u05c5\t\13\2\2\u05c5\u05ca\5b\62\r\u05c6"+
		"\u05c7\f\f\2\2\u05c7\u05c8\t\f\2\2\u05c8\u05ca\5b\62\f\u05c9\u05bd\3\2"+
		"\2\2\u05c9\u05c0\3\2\2\2\u05c9\u05c3\3\2\2\2\u05c9\u05c6\3\2\2\2\u05ca"+
		"\u05cd\3\2\2\2\u05cb\u05c9\3\2\2\2\u05cb\u05cc\3\2\2\2\u05ccc\3\2\2\2"+
		"\u05cd\u05cb\3\2\2\2\u05ce\u05cf\b\63\1\2\u05cf\u05d0\7s\2\2\u05d0\u05f4"+
		"\5d\63\25\u05d1\u05d2\7t\2\2\u05d2\u05f4\5d\63\24\u05d3\u05d4\7\63\2\2"+
		"\u05d4\u05f4\5d\63\23\u05d5\u05d6\b\63\1\2\u05d6\u05d7\7\4\2\2\u05d7\u05d8"+
		"\5p9\2\u05d8\u05d9\7b\2\2\u05d9\u05da\5b\62\2\u05da\u05db\7\6\2\2\u05db"+
		"\u05dc\3\2\2\2\u05dc\u05dd\b\63\1\2\u05dd\u05f4\3\2\2\2\u05de\u05df\t"+
		"\13\2\2\u05df\u05e0\5b\62\2\u05e0\u05e1\7x\2\2\u05e1\u05e2\5d\63\2\u05e2"+
		"\u05e3\7y\2\2\u05e3\u05e4\5d\63\n\u05e4\u05f4\3\2\2\2\u05e5\u05f4\7z\2"+
		"\2\u05e6\u05f4\7{\2\2\u05e7\u05f4\7|\2\2\u05e8\u05f4\7}\2\2\u05e9\u05ea"+
		"\7\21\2\2\u05ea\u05eb\5d\63\2\u05eb\u05ec\7\22\2\2\u05ec\u05f4\3\2\2\2"+
		"\u05ed\u05ee\6\63\6\2\u05ee\u05ef\5v<\2\u05ef\u05f0\b\63\1\2\u05f0\u05f4"+
		"\3\2\2\2\u05f1\u05f2\6\63\7\2\u05f2\u05f4\5t;\2\u05f3\u05ce\3\2\2\2\u05f3"+
		"\u05d1\3\2\2\2\u05f3\u05d3\3\2\2\2\u05f3\u05d5\3\2\2\2\u05f3\u05de\3\2"+
		"\2\2\u05f3\u05e5\3\2\2\2\u05f3\u05e6\3\2\2\2\u05f3\u05e7\3\2\2\2\u05f3"+
		"\u05e8\3\2\2\2\u05f3\u05e9\3\2\2\2\u05f3\u05ed\3\2\2\2\u05f3\u05f1\3\2"+
		"\2\2\u05f4\u0614\3\2\2\2\u05f5\u05f6\f\22\2\2\u05f6\u05f7\7\64\2\2\u05f7"+
		"\u0613\5d\63\23\u05f8\u05f9\f\21\2\2\u05f9\u05fa\7B\2\2\u05fa\u0613\5"+
		"d\63\22\u05fb\u05fc\f\20\2\2\u05fc\u05fd\7u\2\2\u05fd\u0613\5d\63\21\u05fe"+
		"\u05ff\f\17\2\2\u05ff\u0600\7F\2\2\u0600\u0613\5d\63\20\u0601\u0603\f"+
		"\r\2\2\u0602\u0604\t\r\2\2\u0603\u0602\3\2\2\2\u0603\u0604\3\2\2\2\u0604"+
		"\u0605\3\2\2\2\u0605\u0607\7e\2\2\u0606\u0608\t\r\2\2\u0607\u0606\3\2"+
		"\2\2\u0607\u0608\3\2\2\2\u0608\u0609\3\2\2\2\u0609\u0613\5d\63\r\u060a"+
		"\u060b\f\f\2\2\u060b\u060c\7w\2\2\u060c\u0613\5d\63\r\u060d\u060e\f\16"+
		"\2\2\u060e\u060f\7\r\2\2\u060f\u0610\5d\63\2\u0610\u0611\7\16\2\2\u0611"+
		"\u0613\3\2\2\2\u0612\u05f5\3\2\2\2\u0612\u05f8\3\2\2\2\u0612\u05fb\3\2"+
		"\2\2\u0612\u05fe\3\2\2\2\u0612\u0601\3\2\2\2\u0612\u060a\3\2\2\2\u0612"+
		"\u060d\3\2\2\2\u0613\u0616\3\2\2\2\u0614\u0612\3\2\2\2\u0614\u0615\3\2"+
		"\2\2\u0615e\3\2\2\2\u0616\u0614\3\2\2\2\u0617\u0618\b\64\1\2\u0618\u0619"+
		"\t\13\2\2\u0619\u061a\5b\62\2\u061a\u061b\7x\2\2\u061b\u061c\5f\64\2\u061c"+
		"\u061d\7y\2\2\u061d\u061e\5f\64\f\u061e\u062c\3\2\2\2\u061f\u0620\7a\2"+
		"\2\u0620\u062c\5d\63\2\u0621\u0622\7,\2\2\u0622\u062c\5d\63\2\u0623\u0625"+
		"\7u\2\2\u0624\u0623\3\2\2\2\u0624\u0625\3\2\2\2\u0625\u0626\3\2\2\2\u0626"+
		"\u062c\5x=\2\u0627\u0628\7\21\2\2\u0628\u0629\5f\64\2\u0629\u062a\7\22"+
		"\2\2\u062a\u062c\3\2\2\2\u062b\u0617\3\2\2\2\u062b\u061f\3\2\2\2\u062b"+
		"\u0621\3\2\2\2\u062b\u0624\3\2\2\2\u062b\u0627\3\2\2\2\u062c\u063e\3\2"+
		"\2\2\u062d\u062e\f\t\2\2\u062e\u062f\t\16\2\2\u062f\u063d\5f\64\n\u0630"+
		"\u0631\f\b\2\2\u0631\u0632\t\17\2\2\u0632\u063d\5f\64\t\u0633\u0634\f"+
		"\7\2\2\u0634\u0635\t\20\2\2\u0635\u063d\5f\64\b\u0636\u0637\f\6\2\2\u0637"+
		"\u0638\t\21\2\2\u0638\u063d\5f\64\7\u0639\u063a\f\5\2\2\u063a\u063b\t"+
		"\22\2\2\u063b\u063d\5f\64\6\u063c\u062d\3\2\2\2\u063c\u0630\3\2\2\2\u063c"+
		"\u0633\3\2\2\2\u063c\u0636\3\2\2\2\u063c\u0639\3\2\2\2\u063d\u0640\3\2"+
		"\2\2\u063e\u063c\3\2\2\2\u063e\u063f\3\2\2\2\u063fg\3\2\2\2\u0640\u063e"+
		"\3\2\2\2\u0641\u0646\5j\66\2\u0642\u0643\7\5\2\2\u0643\u0645\5j\66\2\u0644"+
		"\u0642\3\2\2\2\u0645\u0648\3\2\2\2\u0646\u0644\3\2\2\2\u0646\u0647\3\2"+
		"\2\2\u0647i\3\2\2\2\u0648\u0646\3\2\2\2\u0649\u064b\7\u0085\2\2\u064a"+
		"\u0649\3\2\2\2\u064a\u064b\3\2\2\2\u064b\u064c\3\2\2\2\u064c\u0651\5v"+
		"<\2\u064d\u064e\7\5\2\2\u064e\u0650\5v<\2\u064f\u064d\3\2\2\2\u0650\u0653"+
		"\3\2\2\2\u0651\u064f\3\2\2\2\u0651\u0652\3\2\2\2\u0652\u0654\3\2\2\2\u0653"+
		"\u0651\3\2\2\2\u0654\u0656\7\b\2\2\u0655\u0657\7Z\2\2\u0656\u0655\3\2"+
		"\2\2\u0656\u0657\3\2\2\2\u0657\u0658\3\2\2\2\u0658\u0659\5d\63\2\u0659"+
		"\u065a\b\66\1\2\u065a\u068c\3\2\2\2\u065b\u065d\7\u0085\2\2\u065c\u065b"+
		"\3\2\2\2\u065c\u065d\3\2\2\2\u065d\u065e\3\2\2\2\u065e\u0663\5v<\2\u065f"+
		"\u0660\7\5\2\2\u0660\u0662\5v<\2\u0661\u065f\3\2\2\2\u0662\u0665\3\2\2"+
		"\2\u0663\u0661\3\2\2\2\u0663\u0664\3\2\2\2\u0664\u0666\3\2\2\2\u0665\u0663"+
		"\3\2\2\2\u0666\u0667\7\b\2\2\u0667\u0668\7Y\2\2\u0668\u0669\5d\63\2\u0669"+
		"\u066a\b\66\1\2\u066a\u068c\3\2\2\2\u066b\u066d\7\u0085\2\2\u066c\u066b"+
		"\3\2\2\2\u066c\u066d\3\2\2\2\u066d\u066e\3\2\2\2\u066e\u0673\5v<\2\u066f"+
		"\u0670\7\5\2\2\u0670\u0672\5v<\2\u0671\u066f\3\2\2\2\u0672\u0675\3\2\2"+
		"\2\u0673\u0671\3\2\2\2\u0673\u0674\3\2\2\2\u0674\u0676\3\2\2\2\u0675\u0673"+
		"\3\2\2\2\u0676\u0677\7\b\2\2\u0677\u0678\7[\2\2\u0678\u0679\5d\63\2\u0679"+
		"\u067a\b\66\1\2\u067a\u068c\3\2\2\2\u067b\u067d\7\u0085\2\2\u067c\u067b"+
		"\3\2\2\2\u067c\u067d\3\2\2\2\u067d\u067e\3\2\2\2\u067e\u0683\5v<\2\u067f"+
		"\u0680\7\5\2\2\u0680\u0682\5v<\2\u0681\u067f\3\2\2\2\u0682\u0685\3\2\2"+
		"\2\u0683\u0681\3\2\2\2\u0683\u0684\3\2\2\2\u0684\u0686\3\2\2\2\u0685\u0683"+
		"\3\2\2\2\u0686\u0687\7\b\2\2\u0687\u0688\7v\2\2\u0688\u0689\5d\63\2\u0689"+
		"\u068a\b\66\1\2\u068a\u068c\3\2\2\2\u068b\u064a\3\2\2\2\u068b\u065c\3"+
		"\2\2\2\u068b\u066c\3\2\2\2\u068b\u067c\3\2\2\2\u068ck\3\2\2\2\u068d\u0692"+
		"\5n8\2\u068e\u068f\7\5\2\2\u068f\u0691\5n8\2\u0690\u068e\3\2\2\2\u0691"+
		"\u0694\3\2\2\2\u0692\u0690\3\2\2\2\u0692\u0693\3\2\2\2\u0693m\3\2\2\2"+
		"\u0694\u0692\3\2\2\2\u0695\u069a\5v<\2\u0696\u0697\7\5\2\2\u0697\u0699"+
		"\5v<\2\u0698\u0696\3\2\2\2\u0699\u069c\3\2\2\2\u069a\u0698\3\2\2\2\u069a"+
		"\u069b\3\2\2\2\u069b\u069d\3\2\2\2\u069c\u069a\3\2\2\2\u069d\u069e\7\27"+
		"\2\2\u069e\u069f\5d\63\2\u069f\u06a0\3\2\2\2\u06a0\u06a1\b8\1\2\u06a1"+
		"o\3\2\2\2\u06a2\u06a7\5r:\2\u06a3\u06a4\7\5\2\2\u06a4\u06a6\5r:\2\u06a5"+
		"\u06a3\3\2\2\2\u06a6\u06a9\3\2\2\2\u06a7\u06a5\3\2\2\2\u06a7\u06a8\3\2"+
		"\2\2\u06a8q\3\2\2\2\u06a9\u06a7\3\2\2\2\u06aa\u06ac\7\u0085\2\2\u06ab"+
		"\u06aa\3\2\2\2\u06ab\u06ac\3\2\2\2\u06ac\u06ad\3\2\2\2\u06ad\u06b2\5v"+
		"<\2\u06ae\u06af\7\5\2\2\u06af\u06b1\5v<\2\u06b0\u06ae\3\2\2\2\u06b1\u06b4"+
		"\3\2\2\2\u06b2\u06b0\3\2\2\2\u06b2\u06b3\3\2\2\2\u06b3\u06b5\3\2\2\2\u06b4"+
		"\u06b2\3\2\2\2\u06b5\u06b7\7\b\2\2\u06b6\u06b8\7Z\2\2\u06b7\u06b6\3\2"+
		"\2\2\u06b7\u06b8\3\2\2\2\u06b8\u06b9\3\2\2\2\u06b9\u06ba\5d\63\2\u06ba"+
		"\u06bb\3\2\2\2\u06bb\u06bc\b:\1\2\u06bcs\3\2\2\2\u06bd\u06be\5z>\2\u06be"+
		"u\3\2\2\2\u06bf\u06c0\5z>\2\u06c0w\3\2\2\2\u06c1\u06c2\7\u0089\2\2\u06c2"+
		"y\3\2\2\2\u06c3\u06ee\5|?\2\u06c4\u06ee\7\30\2\2\u06c5\u06ee\7\"\2\2\u06c6"+
		"\u06ee\7L\2\2\u06c7\u06ee\7M\2\2\u06c8\u06ee\7\31\2\2\u06c9\u06ee\7-\2"+
		"\2\u06ca\u06ee\79\2\2\u06cb\u06ee\7\u0086\2\2\u06cc\u06ee\7T\2\2\u06cd"+
		"\u06ee\7#\2\2\u06ce\u06ee\7<\2\2\u06cf\u06ee\7\u0087\2\2\u06d0\u06ee\7"+
		"\33\2\2\u06d1\u06ee\7$\2\2\u06d2\u06ee\7\25\2\2\u06d3\u06ee\7S\2\2\u06d4"+
		"\u06ee\7\32\2\2\u06d5\u06ee\7\60\2\2\u06d6\u06ee\7\23\2\2\u06d7\u06ee"+
		"\7\61\2\2\u06d8\u06ee\7%\2\2\u06d9\u06ee\7\26\2\2\u06da\u06ee\7Q\2\2\u06db"+
		"\u06ee\7O\2\2\u06dc\u06ee\78\2\2\u06dd\u06ee\7+\2\2\u06de\u06ee\7!\2\2"+
		"\u06df\u06ee\7?\2\2\u06e0\u06ee\7\u0088\2\2\u06e1\u06ee\7.\2\2\u06e2\u06ee"+
		"\7\34\2\2\u06e3\u06ee\7\62\2\2\u06e4\u06ee\7\37\2\2\u06e5\u06ee\7\'\2"+
		"\2\u06e6\u06ee\7)\2\2\u06e7\u06ee\7 \2\2\u06e8\u06ee\7N\2\2\u06e9\u06ee"+
		"\7=\2\2\u06ea\u06ee\7:\2\2\u06eb\u06ee\7>\2\2\u06ec\u06ee\7\35\2\2\u06ed"+
		"\u06c3\3\2\2\2\u06ed\u06c4\3\2\2\2\u06ed\u06c5\3\2\2\2\u06ed\u06c6\3\2"+
		"\2\2\u06ed\u06c7\3\2\2\2\u06ed\u06c8\3\2\2\2\u06ed\u06c9\3\2\2\2\u06ed"+
		"\u06ca\3\2\2\2\u06ed\u06cb\3\2\2\2\u06ed\u06cc\3\2\2\2\u06ed\u06cd\3\2"+
		"\2\2\u06ed\u06ce\3\2\2\2\u06ed\u06cf\3\2\2\2\u06ed\u06d0\3\2\2\2\u06ed"+
		"\u06d1\3\2\2\2\u06ed\u06d2\3\2\2\2\u06ed\u06d3\3\2\2\2\u06ed\u06d4\3\2"+
		"\2\2\u06ed\u06d5\3\2\2\2\u06ed\u06d6\3\2\2\2\u06ed\u06d7\3\2\2\2\u06ed"+
		"\u06d8\3\2\2\2\u06ed\u06d9\3\2\2\2\u06ed\u06da\3\2\2\2\u06ed\u06db\3\2"+
		"\2\2\u06ed\u06dc\3\2\2\2\u06ed\u06dd\3\2\2\2\u06ed\u06de\3\2\2\2\u06ed"+
		"\u06df\3\2\2\2\u06ed\u06e0\3\2\2\2\u06ed\u06e1\3\2\2\2\u06ed\u06e2\3\2"+
		"\2\2\u06ed\u06e3\3\2\2\2\u06ed\u06e4\3\2\2\2\u06ed\u06e5\3\2\2\2\u06ed"+
		"\u06e6\3\2\2\2\u06ed\u06e7\3\2\2\2\u06ed\u06e8\3\2\2\2\u06ed\u06e9\3\2"+
		"\2\2\u06ed\u06ea\3\2\2\2\u06ed\u06eb\3\2\2\2\u06ed\u06ec\3\2\2\2\u06ee"+
		"{\3\2\2\2\u06ef\u06f0\7\u008a\2\2\u06f0}\3\2\2\2\u06f1\u06f2\t\23\2\2"+
		"\u06f2\177\3\2\2\2\u06f3\u06f4\7\u0089\2\2\u06f4\u0081\3\2\2\2\u06f5\u06f7"+
		"\7u\2\2\u06f6\u06f5\3\2\2\2\u06f6\u06f7\3\2\2\2\u06f7\u06f8\3\2\2\2\u06f8"+
		"\u06f9\7\u0089\2\2\u06f9\u0083\3\2\2\2\u00ea\u0085\u008e\u009b\u00ac\u00b5"+
		"\u00c0\u00c5\u00ce\u00d6\u00da\u00e0\u00ec\u00ef\u00f8\u00fb\u010a\u0112"+
		"\u011d\u0122\u0125\u012c\u0132\u013e\u0145\u0160\u0162\u0167\u0172\u0175"+
		"\u0179\u017d\u0181\u0186\u018f\u0192\u0197\u01a7\u01a9\u01ae\u01b6\u01b9"+
		"\u01bd\u01c1\u01c4\u01c7\u01ca\u01d3\u01d8\u01e4\u01e7\u01eb\u01ee\u01f6"+
		"\u01ff\u0206\u020b\u0210\u0214\u0218\u021b\u021e\u0221\u0229\u022f\u0234"+
		"\u0242\u0245\u0249\u024c\u0255\u025a\u0261\u026a\u0271\u0276\u027b\u027f"+
		"\u0283\u028e\u0291\u0299\u029b\u02a5\u02a8\u02b0\u02b3\u02b7\u02ba\u02c9"+
		"\u02cb\u02d0\u02e0\u02e8\u02eb\u02ef\u02f2\u02f8\u02fd\u0305\u0308\u030c"+
		"\u0312\u0316\u031d\u0322\u0328\u032b\u0334\u0336\u033b\u0340\u0348\u034d"+
		"\u0353\u0356\u0362\u0364\u0369\u0370\u0376\u037d\u0383\u0387\u0391\u0396"+
		"\u03a3\u03a5\u03aa\u03ad\u03b1\u03bb\u03c9\u03d4\u03e0\u03ee\u03f1\u03fb"+
		"\u0404\u0409\u0411\u0419\u041f\u0423\u0427\u042c\u0438\u043c\u0441\u0445"+
		"\u044a\u0452\u0454\u0459\u045d\u0466\u0468\u046d\u0471\u047a\u047c\u0481"+
		"\u0485\u048b\u0490\u0494\u049a\u049f\u04a3\u04aa\u04b1\u04c0\u04c7\u04ce"+
		"\u04d5\u04dc\u04e3\u04ea\u051c\u0520\u0526\u052a\u0537\u053b\u0541\u0545"+
		"\u0552\u0556\u055c\u0560\u056d\u0571\u0577\u057b\u0588\u058c\u0592\u0596"+
		"\u05a3\u05a7\u05ad\u05b1\u05bb\u05c9\u05cb\u05f3\u0603\u0607\u0612\u0614"+
		"\u0624\u062b\u063c\u063e\u0646\u064a\u0651\u0656\u065c\u0663\u066c\u0673"+
		"\u067c\u0683\u068b\u0692\u069a\u06a7\u06ab\u06b2\u06b7\u06ed\u06f6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}