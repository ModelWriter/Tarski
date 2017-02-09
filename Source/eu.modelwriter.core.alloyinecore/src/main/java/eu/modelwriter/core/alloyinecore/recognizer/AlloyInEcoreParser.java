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

import eu.modelwriter.core.alloyinecore.structure.base.INamespace;
import eu.modelwriter.core.alloyinecore.structure.base.Repository;
import eu.modelwriter.core.alloyinecore.structure.base.Element;

import eu.modelwriter.core.alloyinecore.structure.model.ModelElement;
import eu.modelwriter.core.alloyinecore.structure.model.Annotation;
import eu.modelwriter.core.alloyinecore.structure.model.AnnotationDetail;
import eu.modelwriter.core.alloyinecore.structure.model.AnnotationReference;
import eu.modelwriter.core.alloyinecore.structure.model.NamedElement;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.structure.model.EcoreImport;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import eu.modelwriter.core.alloyinecore.structure.model.RootPackage;
import eu.modelwriter.core.alloyinecore.structure.model.Classifier;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Interface;
import eu.modelwriter.core.alloyinecore.structure.model.DataType;
import eu.modelwriter.core.alloyinecore.structure.model.Enum;
import eu.modelwriter.core.alloyinecore.structure.model.EnumLiteral;
import eu.modelwriter.core.alloyinecore.structure.model.StructuralFeature;
import eu.modelwriter.core.alloyinecore.structure.model.TypedElement;
import eu.modelwriter.core.alloyinecore.structure.model.Multiplicity;
import eu.modelwriter.core.alloyinecore.structure.model.Reference;
import eu.modelwriter.core.alloyinecore.structure.model.Attribute;
import eu.modelwriter.core.alloyinecore.structure.model.Operation;
import eu.modelwriter.core.alloyinecore.structure.model.Parameter;
import eu.modelwriter.core.alloyinecore.structure.model.GenericException;
import eu.modelwriter.core.alloyinecore.structure.model.TypeParameter;
import eu.modelwriter.core.alloyinecore.structure.model.GenericType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericTypeArgument;
import eu.modelwriter.core.alloyinecore.structure.model.GenericElementType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericSuperType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericWildcard;
import eu.modelwriter.core.alloyinecore.structure.model.PrimitiveType;
import eu.modelwriter.core.alloyinecore.structure.model.Invariant;
import eu.modelwriter.core.alloyinecore.structure.model.Derivation;
import eu.modelwriter.core.alloyinecore.structure.model.Body;
import eu.modelwriter.core.alloyinecore.structure.model.PostCondition;
import eu.modelwriter.core.alloyinecore.structure.model.PreCondition;
import eu.modelwriter.core.alloyinecore.structure.model.Initial;

import eu.modelwriter.core.alloyinecore.structure.model.Instance;
import eu.modelwriter.core.alloyinecore.structure.model.Object;
import eu.modelwriter.core.alloyinecore.structure.model.ModelImport;
import eu.modelwriter.core.alloyinecore.structure.model.Value;

import eu.modelwriter.core.alloyinecore.structure.model.Formula;
import eu.modelwriter.core.alloyinecore.structure.model.Expression;
import eu.modelwriter.core.alloyinecore.structure.model.IntExpression;
import eu.modelwriter.core.alloyinecore.structure.model.QuantifierDeclaration;
import eu.modelwriter.core.alloyinecore.structure.model.LetDeclaration;
import eu.modelwriter.core.alloyinecore.structure.model.ComprehensionDeclaration;
import eu.modelwriter.core.alloyinecore.structure.model.Variable;

import eu.modelwriter.core.alloyinecore.internal.AnnotationSources;

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
		T__131=132, T__132=133, INT=134, IDENTIFIER=135, SINGLE_CHARACTER=136, 
		DOUBLE_QUOTED_STRING=137, SINGLE_QUOTED_STRING=138, ML_SINGLE_QUOTED_STRING=139, 
		MULTILINE_COMMENT=140, SINGLELINE_COMMENT=141, WS=142;
	public static final int
		RULE_options = 0, RULE_option = 1, RULE_instance = 2, RULE_modelImport = 3, 
		RULE_eObject = 4, RULE_slot = 5, RULE_dataValue = 6, RULE_multiValueData = 7, 
		RULE_eObjectValue = 8, RULE_literalValue = 9, RULE_model = 10, RULE_packageImport = 11, 
		RULE_ePackage = 12, RULE_eClassifier = 13, RULE_eClass = 14, RULE_eStructuralFeature = 15, 
		RULE_eAttribute = 16, RULE_eReference = 17, RULE_eOperation = 18, RULE_eGenericException = 19, 
		RULE_eGenericSuperType = 20, RULE_eParameter = 21, RULE_eMultiplicity = 22, 
		RULE_eDataType = 23, RULE_eEnum = 24, RULE_eEnumLiteral = 25, RULE_eAnnotation = 26, 
		RULE_eDetail = 27, RULE_eModelElement = 28, RULE_eNamedElement = 29, RULE_eTypedElement = 30, 
		RULE_eModelElementRef = 31, RULE_templateSignature = 32, RULE_eTypeParameter = 33, 
		RULE_eGenericTypeArgument = 34, RULE_eGenericType = 35, RULE_eGenericElementType = 36, 
		RULE_eGenericWildcard = 37, RULE_pathName = 38, RULE_segment = 39, RULE_ePrimitiveType = 40, 
		RULE_body = 41, RULE_invariant = 42, RULE_precondition = 43, RULE_postcondition = 44, 
		RULE_initial = 45, RULE_derivation = 46, RULE_visibilityKind = 47, RULE_formula = 48, 
		RULE_expression = 49, RULE_intExpression = 50, RULE_quantifierDeclarations = 51, 
		RULE_quantifierDeclaration = 52, RULE_letDeclarations = 53, RULE_letDeclaration = 54, 
		RULE_comprehensionDeclarations = 55, RULE_comprehensionDeclaration = 56, 
		RULE_relationId = 57, RULE_variable = 58, RULE_mult = 59, RULE_unrestrictedName = 60, 
		RULE_booleanValue = 61, RULE_numericValue = 62, RULE_stringValue = 63, 
		RULE_charValue = 64, RULE_nullValue = 65, RULE_identifier = 66, RULE_upper = 67, 
		RULE_lower = 68;
	public static final String[] ruleNames = {
		"options", "option", "instance", "modelImport", "eObject", "slot", "dataValue", 
		"multiValueData", "eObjectValue", "literalValue", "model", "packageImport", 
		"ePackage", "eClassifier", "eClass", "eStructuralFeature", "eAttribute", 
		"eReference", "eOperation", "eGenericException", "eGenericSuperType", 
		"eParameter", "eMultiplicity", "eDataType", "eEnum", "eEnumLiteral", "eAnnotation", 
		"eDetail", "eModelElement", "eNamedElement", "eTypedElement", "eModelElementRef", 
		"templateSignature", "eTypeParameter", "eGenericTypeArgument", "eGenericType", 
		"eGenericElementType", "eGenericWildcard", "pathName", "segment", "ePrimitiveType", 
		"body", "invariant", "precondition", "postcondition", "initial", "derivation", 
		"visibilityKind", "formula", "expression", "intExpression", "quantifierDeclarations", 
		"quantifierDeclaration", "letDeclarations", "letDeclaration", "comprehensionDeclarations", 
		"comprehensionDeclaration", "relationId", "variable", "mult", "unrestrictedName", 
		"booleanValue", "numericValue", "stringValue", "charValue", "nullValue", 
		"identifier", "upper", "lower"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'options'", "'{'", "','", "'}'", "'symmetry_breaking'", "':'", 
		"'bit_width'", "'skolem_depth'", "'sharing'", "';'", "'model'", "'['", 
		"']'", "'import'", "'package'", "'='", "'abstract'", "'class'", "'interface'", 
		"'extends'", "'static'", "'ghost'", "'transient'", "'volatile'", "'readonly'", 
		"'attribute'", "'derived'", "'id'", "'ordered'", "'!ordered'", "'unique'", 
		"'!unique'", "'unsettable'", "'!unsettable'", "'property'", "'#'", "'composes'", 
		"'resolve'", "'!resolve'", "'key'", "'operation'", "'('", "')'", "'throws'", 
		"'..'", "'*'", "'+'", "'?'", "'|?'", "'|1'", "'primitive'", "'datatype'", 
		"'serializable'", "'!serializable'", "'enum'", "'literal'", "'annotation'", 
		"'reference'", "'<'", "'>'", "'&'", "'super'", "'.'", "'::'", "'@'", "'Boolean'", 
		"'Integer'", "'String'", "'Real'", "'UnlimitedNatural'", "'body'", "'callable'", 
		"'invariant'", "'precondition'", "'requires'", "'postcondition'", "'ensures'", 
		"'initial'", "'derivation'", "'public'", "'protected'", "'private'", "'no'", 
		"'lone'", "'one'", "'some'", "'!'", "'not'", "'in'", "'<='", "'>='", "'sum'", 
		"'|'", "'acyclic'", "'function'", "'->'", "'ord'", "'&&'", "'and'", "'||'", 
		"'or'", "'=>'", "'if'", "'implies'", "'<=>'", "'iff'", "'all'", "'let'", 
		"'true'", "'false'", "'~'", "'^'", "'-'", "'++'", "'then'", "'else'", 
		"'iden'", "'none'", "'univ'", "'ints'", "'plus'", "'minus'", "'mul'", 
		"'/'", "'div'", "'%'", "'modulo'", "'disj'", "'set'", "'definition'", 
		"'ensure'", "'require'", "'null'"
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
		null, null, "INT", "IDENTIFIER", "SINGLE_CHARACTER", "DOUBLE_QUOTED_STRING", 
		"SINGLE_QUOTED_STRING", "ML_SINGLE_QUOTED_STRING", "MULTILINE_COMMENT", 
		"SINGLELINE_COMMENT", "WS"
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



	public Model model;
	public Instance instance;

	Repository repository = new Repository();

	URI saveURI;

	public AlloyInEcoreParser(TokenStream input, URI saveURI){
	    this(input);
	    this.saveURI = saveURI;
	    repository = new Repository(saveURI);
	}


	public void saveResource(String filename, String path){
	    model.printTree();
	    repository.printNamespaces();
	    if (model.getOwnedPackage() != null) {
	        ResourceSet metaResourceSet = new ResourceSetImpl();
	        metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());
	        Resource metaResource = metaResourceSet.createResource(URI.createURI(path + filename + ".ecore"));
	        metaResource.getContents().add(model.getOwnedPackage().getEObject());
	        try {
	            metaResource.save(null);
	        } catch (java.io.IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}

	private String getContextText(ParserRuleContext ctx){
	    return getTokenStream().getTokenSource().getInputStream().toString().substring(ctx.start.getStartIndex(),ctx.stop.getStopIndex());
	}


	private EcoreFactory eFactory = EcoreFactory.eINSTANCE;

	private void signalParsingCompletion() {
	    //restoreReferences();
	    //checkConstraints();
	}

	private void createEAnnotation(EModelElement owner, final String source) {
	    if (owner.getEAnnotation(source) != null)
	        return;
	    final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
	    eAnnotation.setSource(source);
	    owner.getEAnnotations().add(eAnnotation);
	}

	//private java.util.Stack<Element> owners = new java.util.Stack<>();


	public AlloyInEcoreParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
		enterRule(_localctx, 0, RULE_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__0);
			setState(139);
			match(T__1);
			setState(140);
			option();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(141);
				match(T__2);
				setState(142);
				option();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
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
		public Token value;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
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
		public Token value;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
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
		public Token value;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
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
		public Token value;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
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
		enterRule(_localctx, 2, RULE_option);
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				((SymmetryBreakingContext)_localctx).key = match(T__4);
				setState(151);
				match(T__5);
				setState(152);
				((SymmetryBreakingContext)_localctx).value = match(INT);
				}
				break;
			case T__6:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				((BitWidthContext)_localctx).key = match(T__6);
				setState(154);
				match(T__5);
				setState(155);
				((BitWidthContext)_localctx).value = match(INT);
				}
				break;
			case T__7:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				((SkolemDepthContext)_localctx).key = match(T__7);
				setState(157);
				match(T__5);
				setState(158);
				((SkolemDepthContext)_localctx).value = match(INT);
				}
				break;
			case T__8:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(159);
				((SharingContext)_localctx).key = match(T__8);
				setState(160);
				match(T__5);
				setState(161);
				((SharingContext)_localctx).value = match(INT);
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

	public static class InstanceContext extends ParserRuleContext {
		public Element owner;
		public Instance current;
		public EObjectContext rootObject;
		public ModelImportContext modelImport() {
			return getRuleContext(ModelImportContext.class,0);
		}
		public List<PackageImportContext> packageImport() {
			return getRuleContexts(PackageImportContext.class);
		}
		public PackageImportContext packageImport(int i) {
			return getRuleContext(PackageImportContext.class,i);
		}
		public EObjectContext eObject() {
			return getRuleContext(EObjectContext.class,0);
		}
		public InstanceContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InstanceContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_instance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInstance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstanceContext instance(Element owner) throws RecognitionException {
		InstanceContext _localctx = new InstanceContext(_ctx, getState(), owner);
		enterRule(_localctx, 4, RULE_instance);
		((InstanceContext)_localctx).current =  new Instance(_localctx); instance= _localctx.current; if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(164);
				packageImport(_localctx.current);
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			modelImport(_localctx.current);
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__13:
			case T__14:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__32:
			case T__34:
			case T__36:
			case T__37:
			case T__39:
			case T__40:
			case T__43:
			case T__50:
			case T__51:
			case T__52:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__70:
			case T__71:
			case T__72:
			case T__73:
			case T__75:
			case T__77:
			case T__78:
			case T__129:
			case T__130:
			case T__131:
			case IDENTIFIER:
				{
				setState(171);
				((InstanceContext)_localctx).rootObject = eObject(_localctx.current);
				}
				break;
			case T__9:
				{
				setState(172);
				match(T__9);
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

	public static class ModelImportContext extends ParserRuleContext {
		public Element owner;
		public ModelImport current;
		public UnrestrictedNameContext name;
		public Token ownedPathName;
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public ModelImportContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ModelImportContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_modelImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterModelImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitModelImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitModelImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelImportContext modelImport(Element owner) throws RecognitionException {
		ModelImportContext _localctx = new ModelImportContext(_ctx, getState(), owner);
		enterRule(_localctx, 6, RULE_modelImport);
		((ModelImportContext)_localctx).current =  new ModelImport(_localctx); owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(175);
			match(T__10);
			}
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__16 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__22 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__30 - 11)) | (1L << (T__32 - 11)) | (1L << (T__34 - 11)) | (1L << (T__36 - 11)) | (1L << (T__37 - 11)) | (1L << (T__39 - 11)) | (1L << (T__40 - 11)) | (1L << (T__43 - 11)) | (1L << (T__50 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__54 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__70 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__129 - 76)) | (1L << (T__130 - 76)) | (1L << (T__131 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
				{
				setState(176);
				((ModelImportContext)_localctx).name = unrestrictedName();
				setState(177);
				match(T__5);
				}
			}

			setState(181);
			((ModelImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(182);
			match(T__9);
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

	public static class EObjectContext extends ParserRuleContext {
		public Element owner;
		public Object current;
		public PathNameContext name;
		public LiteralValueContext id;
		public SlotContext slot;
		public List<SlotContext> slots = new ArrayList<SlotContext>();
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public List<SlotContext> slot() {
			return getRuleContexts(SlotContext.class);
		}
		public SlotContext slot(int i) {
			return getRuleContext(SlotContext.class,i);
		}
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public EObjectContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EObjectContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EObjectContext eObject(Element owner) throws RecognitionException {
		EObjectContext _localctx = new EObjectContext(_ctx, getState(), owner);
		enterRule(_localctx, 8, RULE_eObject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			((EObjectContext)_localctx).name = pathName(_localctx.current);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46 || _la==T__62 || ((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & ((1L << (T__108 - 109)) | (1L << (T__109 - 109)) | (1L << (T__112 - 109)) | (1L << (T__132 - 109)) | (1L << (INT - 109)) | (1L << (IDENTIFIER - 109)) | (1L << (SINGLE_CHARACTER - 109)) | (1L << (DOUBLE_QUOTED_STRING - 109)))) != 0)) {
				{
				setState(185);
				((EObjectContext)_localctx).id = literalValue();
				}
			}

			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(188);
				match(T__1);
				setState(189);
				((EObjectContext)_localctx).slot = slot(_localctx.current);
				((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(190);
					match(T__2);
					setState(191);
					((EObjectContext)_localctx).slot = slot(_localctx.current);
					((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(197);
				match(T__3);
				}
				break;
			case T__9:
				{
				setState(199);
				match(T__9);
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

	public static class SlotContext extends ParserRuleContext {
		public Element owner;
		public Object current;
		public UnrestrictedNameContext name;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
		}
		public EObjectValueContext eObjectValue() {
			return getRuleContext(EObjectValueContext.class,0);
		}
		public List<EObjectContext> eObject() {
			return getRuleContexts(EObjectContext.class);
		}
		public EObjectContext eObject(int i) {
			return getRuleContext(EObjectContext.class,i);
		}
		public SlotContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SlotContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_slot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSlot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSlot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSlot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotContext slot(Element owner) throws RecognitionException {
		SlotContext _localctx = new SlotContext(_ctx, getState(), owner);
		enterRule(_localctx, 10, RULE_slot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			((SlotContext)_localctx).name = unrestrictedName();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(203);
				match(T__5);
				setState(214);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(204);
					dataValue();
					}
					break;
				case 2:
					{
					setState(205);
					match(T__1);
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__16 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__22 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__30 - 11)) | (1L << (T__32 - 11)) | (1L << (T__34 - 11)) | (1L << (T__36 - 11)) | (1L << (T__37 - 11)) | (1L << (T__39 - 11)) | (1L << (T__40 - 11)) | (1L << (T__43 - 11)) | (1L << (T__50 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__54 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__70 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__129 - 76)) | (1L << (T__130 - 76)) | (1L << (T__131 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
						{
						{
						setState(206);
						eObject(_localctx.current);
						}
						}
						setState(211);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(212);
					match(T__3);
					}
					break;
				case 3:
					{
					setState(213);
					eObjectValue(_localctx.current);
					}
					break;
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

	public static class DataValueContext extends ParserRuleContext {
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public MultiValueDataContext multiValueData() {
			return getRuleContext(MultiValueDataContext.class,0);
		}
		public DataValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterDataValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitDataValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitDataValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataValueContext dataValue() throws RecognitionException {
		DataValueContext _localctx = new DataValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dataValue);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
			case T__62:
			case T__108:
			case T__109:
			case T__112:
			case T__132:
			case INT:
			case IDENTIFIER:
			case SINGLE_CHARACTER:
			case DOUBLE_QUOTED_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				literalValue();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				multiValueData();
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

	public static class MultiValueDataContext extends ParserRuleContext {
		public List<DataValueContext> dataValue() {
			return getRuleContexts(DataValueContext.class);
		}
		public DataValueContext dataValue(int i) {
			return getRuleContext(DataValueContext.class,i);
		}
		public MultiValueDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiValueData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterMultiValueData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitMultiValueData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitMultiValueData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiValueDataContext multiValueData() throws RecognitionException {
		MultiValueDataContext _localctx = new MultiValueDataContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multiValueData);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__11);
			setState(223);
			dataValue();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(224);
				match(T__2);
				setState(225);
				dataValue();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EObjectValueContext extends ParserRuleContext {
		public Element owner;
		public Object current;
		public List<PathNameContext> pathName() {
			return getRuleContexts(PathNameContext.class);
		}
		public PathNameContext pathName(int i) {
			return getRuleContext(PathNameContext.class,i);
		}
		public EObjectValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EObjectValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_eObjectValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEObjectValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEObjectValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEObjectValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EObjectValueContext eObjectValue(Element owner) throws RecognitionException {
		EObjectValueContext _localctx = new EObjectValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 16, RULE_eObjectValue);
		int _la;
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__13:
			case T__14:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__32:
			case T__34:
			case T__36:
			case T__37:
			case T__39:
			case T__40:
			case T__43:
			case T__50:
			case T__51:
			case T__52:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__70:
			case T__71:
			case T__72:
			case T__73:
			case T__75:
			case T__77:
			case T__78:
			case T__129:
			case T__130:
			case T__131:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				pathName(_localctx.current);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(234);
				match(T__11);
				setState(235);
				pathName(_localctx.current);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(236);
					match(T__2);
					setState(237);
					pathName(_localctx.current);
					}
					}
					setState(242);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(243);
				match(T__12);
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

	public static class LiteralValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public NumericValueContext numericValue() {
			return getRuleContext(NumericValueContext.class,0);
		}
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public CharValueContext charValue() {
			return getRuleContext(CharValueContext.class,0);
		}
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public NullValueContext nullValue() {
			return getRuleContext(NullValueContext.class,0);
		}
		public LiteralValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralValueContext literalValue() throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_literalValue);
		try {
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				identifier();
				}
				break;
			case T__46:
			case T__62:
			case T__112:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				numericValue();
				}
				break;
			case DOUBLE_QUOTED_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				stringValue();
				}
				break;
			case SINGLE_CHARACTER:
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				charValue();
				}
				break;
			case T__108:
			case T__109:
				enterOuterAlt(_localctx, 5);
				{
				setState(251);
				booleanValue();
				}
				break;
			case T__132:
				enterOuterAlt(_localctx, 6);
				{
				setState(252);
				nullValue();
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

	public static class ModelContext extends ParserRuleContext {
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
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_model);
		model = new Model(_localctx); ((ModelContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.MODULE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(255);
				options();
				}
			}


			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(259);
				match(T__10);
				setState(260);
				((ModelContext)_localctx).name = identifier();
				setState(261);
				match(T__9);
				}
			}

			_localctx.element.getDetails().put("name", (((ModelContext)_localctx).name!=null?_input.getText(((ModelContext)_localctx).name.start,((ModelContext)_localctx).name.stop):null));
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(266);
				((ModelContext)_localctx).packageImport = packageImport(model);
				((ModelContext)_localctx).ownedPackageImport.add(((ModelContext)_localctx).packageImport);
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(272);
			((ModelContext)_localctx).ownedPackage = ((ModelContext)_localctx).ePackage = ePackage(model);
			((ModelContext)_localctx).ePackage.element.getEAnnotations().add(_localctx.element);
			}
			for(PackageImportContext ctx: _localctx.ownedPackageImport) {((ModelContext)_localctx).ePackage.element.getEAnnotations().add(ctx.element);}
			}
			_ctx.stop = _input.LT(-1);
			signalParsingCompletion();
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public EAnnotation element;
		public EObject object;
		public IdentifierContext name;
		public Token ownedPathName;
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PackageImportContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PackageImportContext(ParserRuleContext parent, int invokingState, Element owner) {
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

	public final PackageImportContext packageImport(Element owner) throws RecognitionException {
		PackageImportContext _localctx = new PackageImportContext(_ctx, getState(), owner);
		enterRule(_localctx, 22, RULE_packageImport);
		((PackageImportContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.IMPORT);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(277);
			match(T__13);
			}
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(278);
				((PackageImportContext)_localctx).name = identifier();
				setState(279);
				match(T__5);
				}
			}

			setState(283);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(284);
			match(T__9);
			_localctx.element.getDetails().put((((PackageImportContext)_localctx).name!=null?_input.getText(((PackageImportContext)_localctx).name.start,((PackageImportContext)_localctx).name.stop):null), ((PackageImportContext)_localctx).ownedPathName != null ? ((PackageImportContext)_localctx).ownedPathName.getText().replace("'", "") : null);
			}
			_ctx.stop = _input.LT(-1);

			if (((PackageImportContext)_localctx).ownedPathName != null) {
			    String path = ((PackageImportContext)_localctx).ownedPathName.getText().replace("'", "");
			    Import imported = null;
			    if (path.equals(EcorePackage.eNS_URI)) {
			        ((PackageImportContext)_localctx).object =  EcorePackage.eINSTANCE;
			        imported = new EcoreImport(_localctx.object, _localctx);
			        _localctx.owner.addOwnedElement(imported);
			        repository.name2Import.put(imported.getKey(), imported);
			        imported.loadNamespace(repository);
			    } else {
			        Resource resource = repository.loadResource(path);
			        if (resource == null) {
			            notifyErrorListeners(((PackageImportContext)_localctx).ownedPathName, "Import could not be resolved!", null);

			        }
			        else {
			            ((PackageImportContext)_localctx).object =  repository.loadResource(path).getContents().get(0);
			            imported = new Import(_localctx.object, _localctx);
			            _localctx.owner.addOwnedElement(imported);
			            repository.name2Import.put(imported.getKey(), imported);
			            imported.loadNamespace(repository);
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
		enterRule(_localctx, 24, RULE_ePackage);
		((EPackageContext)_localctx).element =  eFactory.createEPackage();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(287);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EPackageContext)_localctx).visibility.element);
			setState(291);
			match(T__14);
			setState(292);
			((EPackageContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null));
			if(_localctx.parent instanceof ModelContext) {((EPackageContext)_localctx).current =  new RootPackage(_localctx.element, _localctx); repository.name2Import.put(((RootPackage)_localctx.current).getKey(), (RootPackage)_localctx.current);}
			     else {((EPackageContext)_localctx).current =  new Package(_localctx.element, _localctx);}
			{
			setState(295);
			match(T__5);
			setState(296);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(298);
			match(T__15);
			setState(299);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			_localctx.element.setNsPrefix((((EPackageContext)_localctx).nsPrefix!=null?_input.getText(((EPackageContext)_localctx).nsPrefix.start,((EPackageContext)_localctx).nsPrefix.stop):null)); if(((EPackageContext)_localctx).nsURI != null) _localctx.element.setNsURI(((EPackageContext)_localctx).nsURI.getText().replace("'", ""));
			setState(322);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(302);
				match(T__1);
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__50) | (1L << T__51) | (1L << T__54) | (1L << T__56))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__79 - 72)) | (1L << (T__80 - 72)) | (1L << (T__81 - 72)))) != 0)) {
					{
					setState(315);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						setState(303);
						((EPackageContext)_localctx).eAnnotation = ((EPackageContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(306);
						((EPackageContext)_localctx).ePackage = ((EPackageContext)_localctx).ePackage = ePackage(_localctx.current);
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						_localctx.element.getESubpackages().add(((EPackageContext)_localctx).ePackage.element);
						}
						break;
					case 3:
						{
						setState(309);
						((EPackageContext)_localctx).eClassifier = ((EPackageContext)_localctx).eClassifier = eClassifier(_localctx.current);
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						if (((EPackageContext)_localctx).eClassifier.element != null) _localctx.element.getEClassifiers().add(((EPackageContext)_localctx).eClassifier.element);
						}
						break;
					case 4:
						{
						setState(312);
						((EPackageContext)_localctx).invariant = ((EPackageContext)_localctx).invariant = invariant(_localctx.current);
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(319);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(320);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(321);
				match(T__9);
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
		enterRule(_localctx, 26, RULE_eClassifier);
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				((EClassifierContext)_localctx).eClass = eClass(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eClass.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				((EClassifierContext)_localctx).eDataType = eDataType(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eDataType.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
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
		enterRule(_localctx, 28, RULE_eClass);
		((EClassContext)_localctx).element =  eFactory.createEClass();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(335);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).visibility.element);
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
			case T__17:
				{
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(339);
					((EClassContext)_localctx).isAbstract = match(T__16);
					}
				}

				setState(342);
				((EClassContext)_localctx).isClass = match(T__17);
				}
				break;
			case T__18:
				{
				setState(343);
				((EClassContext)_localctx).isInterface = match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.element.setAbstract(((EClassContext)_localctx).isAbstract!=null); if (((EClassContext)_localctx).isInterface!=null) {_localctx.element.setInterface(true);_localctx.element.setAbstract(true);}
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(347);
				((EClassContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			if (_localctx.name == null) {notifyErrorListeners("missing Class name");} else {_localctx.element.setName((((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null));}
			if (((EClassContext)_localctx).isInterface!=null) ((EClassContext)_localctx).current =  new Interface(_localctx.element, _localctx); else ((EClassContext)_localctx).current =  new Class(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__58) {
				{
				setState(352);
				((EClassContext)_localctx).ownedSignature = ((EClassContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EClassContext)_localctx).templateSignature.typeParameters);
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(356);
				match(T__19);
				setState(357);
				((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(358);
					match(T__2);
					setState(359);
					((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(368);
				match(T__5);
				setState(369);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EClassContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EClassContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(393);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(373);
				match(T__1);
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__34) | (1L << T__40) | (1L << T__56))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__79 - 72)) | (1L << (T__80 - 72)) | (1L << (T__81 - 72)))) != 0)) {
					{
					setState(386);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(374);
						((EClassContext)_localctx).eAnnotation = ((EClassContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(377);
						((EClassContext)_localctx).eOperation = ((EClassContext)_localctx).eOperation = eOperation(_localctx.current);
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						_localctx.element.getEOperations().add(((EClassContext)_localctx).eOperation.element);
						}
						break;
					case 3:
						{
						setState(380);
						((EClassContext)_localctx).eStructuralFeature = ((EClassContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.current);
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						if (((EClassContext)_localctx).eStructuralFeature.element != null) _localctx.element.getEStructuralFeatures().add(((EClassContext)_localctx).eStructuralFeature.element);
						}
						break;
					case 4:
						{
						setState(383);
						((EClassContext)_localctx).invariant = ((EClassContext)_localctx).invariant = invariant(_localctx.current);
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(390);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(391);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(392);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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
		enterRule(_localctx, 30, RULE_eStructuralFeature);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(395);
				((EStructuralFeatureContext)_localctx).eAttribute = eAttribute(_localctx.owner);
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eAttribute.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
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
		public Token s21;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s11;
		public Token s22;
		public Token s23;
		public Token s24;
		public Token s25;
		public UnrestrictedNameContext name;
		public EGenericElementTypeContext eAttributeType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s27;
		public Token s28;
		public Token s29;
		public Token s30;
		public Token s31;
		public Token s32;
		public Token s33;
		public Token s34;
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
		enterRule(_localctx, 32, RULE_eAttribute);
		((EAttributeContext)_localctx).element =  eFactory.createEAttribute();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(403);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).visibility.element);
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(407);
				((EAttributeContext)_localctx).s21 = match(T__20);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s21);
				}
			}

			setState(412);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(410);
				((EAttributeContext)_localctx).s11 = match(T__10);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s11);
				}
				break;
			case T__21:
				{
				setState(411);
				((EAttributeContext)_localctx).s22 = match(T__21);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s22);
				}
				break;
			case T__22:
			case T__23:
			case T__24:
			case T__25:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(414);
				((EAttributeContext)_localctx).s23 = match(T__22);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s23);
				}
			}

			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(417);
				((EAttributeContext)_localctx).s24 = match(T__23);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s24);
				}
			}

			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(420);
				((EAttributeContext)_localctx).s25 = match(T__24);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s25);
				}
			}

			setState(423);
			match(T__25);
			setState(424);
			((EAttributeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EAttributeContext)_localctx).name!=null?_input.getText(((EAttributeContext)_localctx).name.start,((EAttributeContext)_localctx).name.stop):null));
			((EAttributeContext)_localctx).current =  new Attribute(_localctx.element, _localctx);
			setState(427);
			match(T__5);
			setState(428);
			((EAttributeContext)_localctx).eAttributeType = eGenericElementType(_localctx.current);
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(429);
				((EAttributeContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement)_localctx.element);
				}
			}

			if(_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(433);
				match(T__15);
				setState(434);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EAttributeContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EAttributeContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(457);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(438);
				match(T__1);
				setState(452); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(447);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__26:
						{
						setState(439);
						((EAttributeContext)_localctx).s27 = match(T__26);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
						}
						break;
					case T__27:
						{
						setState(440);
						((EAttributeContext)_localctx).s28 = match(T__27);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(441);
						((EAttributeContext)_localctx).s29 = match(T__28);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(442);
						((EAttributeContext)_localctx).s30 = match(T__29);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(443);
						((EAttributeContext)_localctx).s31 = match(T__30);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
						}
						break;
					case T__31:
						{
						setState(444);
						((EAttributeContext)_localctx).s32 = match(T__31);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s32);
						}
						break;
					case T__32:
						{
						setState(445);
						((EAttributeContext)_localctx).s33 = match(T__32);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s33);
						}
						break;
					case T__33:
						{
						setState(446);
						((EAttributeContext)_localctx).s34 = match(T__33);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s34);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(450);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(449);
						match(T__2);
						}
					}

					}
					}
					setState(454); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0) );
				setState(456);
				match(T__3);
				}
				break;
			}
			setState(486);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(459);
				match(T__1);
				{
				setState(465);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(460);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(467);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				}
				setState(474);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__78:
					{
					setState(468);
					((EAttributeContext)_localctx).ownedDerivation = ((EAttributeContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).derivation.element);
					}
					break;
				case T__77:
					{
					setState(471);
					((EAttributeContext)_localctx).ownedInitial = ((EAttributeContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__56:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__56) {
					{
					{
					setState(476);
					((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
					}
					}
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(484);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(485);
				match(T__9);
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
		public Token s21;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s11;
		public Token s22;
		public Token s23;
		public Token s24;
		public Token s25;
		public UnrestrictedNameContext name;
		public UnrestrictedNameContext eOpposite;
		public EGenericElementTypeContext eReferenceType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s37;
		public Token s27;
		public Token s29;
		public Token s30;
		public Token s31;
		public Token s32;
		public Token s38;
		public Token s39;
		public Token s33;
		public Token s34;
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
		enterRule(_localctx, 34, RULE_eReference);
		((EReferenceContext)_localctx).element =  eFactory.createEReference();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(490);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).visibility.element);
			setState(495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(494);
				((EReferenceContext)_localctx).s21 = match(T__20);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s21);
				}
			}

			setState(499);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(497);
				((EReferenceContext)_localctx).s11 = match(T__10);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s11);
				}
				break;
			case T__21:
				{
				setState(498);
				((EReferenceContext)_localctx).s22 = match(T__21);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s22);
				}
				break;
			case T__22:
			case T__23:
			case T__24:
			case T__34:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(501);
				((EReferenceContext)_localctx).s23 = match(T__22);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s23);
				}
			}

			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(504);
				((EReferenceContext)_localctx).s24 = match(T__23);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s24);
				}
			}

			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(507);
				((EReferenceContext)_localctx).s25 = match(T__24);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s25);
				}
			}

			setState(510);
			match(T__34);
			setState(511);
			((EReferenceContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null));
			((EReferenceContext)_localctx).current =  new Reference(_localctx.element, _localctx);
			setState(516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(514);
				match(T__35);
				setState(515);
				((EReferenceContext)_localctx).eOpposite = unrestrictedName();
				}
			}


			{
			setState(519);
			match(T__5);
			setState(520);
			((EReferenceContext)_localctx).eReferenceType = eGenericElementType(_localctx.current);
			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(521);
				((EReferenceContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			}
			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(525);
				match(T__15);
				setState(526);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EReferenceContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EReferenceContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(551);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(530);
				match(T__1);
				setState(546); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(541);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__36:
						{
						setState(531);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__26:
						{
						setState(532);
						((EReferenceContext)_localctx).s27 = match(T__26);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
						}
						break;
					case T__28:
						{
						setState(533);
						((EReferenceContext)_localctx).s29 = match(T__28);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(534);
						((EReferenceContext)_localctx).s30 = match(T__29);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(535);
						((EReferenceContext)_localctx).s31 = match(T__30);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
						}
						break;
					case T__31:
						{
						setState(536);
						((EReferenceContext)_localctx).s32 = match(T__31);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s32);
						}
						break;
					case T__37:
						{
						setState(537);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(538);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__32:
						{
						setState(539);
						((EReferenceContext)_localctx).s33 = match(T__32);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s33);
						}
						break;
					case T__33:
						{
						setState(540);
						((EReferenceContext)_localctx).s34 = match(T__33);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s34);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(544);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(543);
						match(T__2);
						}
					}

					}
					}
					setState(548); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0) );
				setState(550);
				match(T__3);
				}
				break;
			}
			setState(593);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(553);
				match(T__1);
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__39) {
					{
					setState(554);
					match(T__39);
					setState(555);
					((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
					setState(560);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(556);
						match(T__2);
						setState(557);
						((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
						}
						}
						setState(562);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(563);
					match(T__9);
					}
				}

				{
				setState(572);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(567);
						((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(574);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				}
				setState(581);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__78:
					{
					setState(575);
					((EReferenceContext)_localctx).ownedDerivation = ((EReferenceContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).derivation.element);
					}
					break;
				case T__77:
					{
					setState(578);
					((EReferenceContext)_localctx).ownedInitial = ((EReferenceContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__56:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__56) {
					{
					{
					setState(583);
					((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
					}
					}
					setState(590);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(591);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(592);
				match(T__9);
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
		public Token s21;
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
		public Token s29;
		public Token s30;
		public Token s31;
		public Token s32;
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
		enterRule(_localctx, 36, RULE_eOperation);
		((EOperationContext)_localctx).element =  eFactory.createEOperation(); ((EOperationContext)_localctx).current =  new Operation(_localctx.element, _localctx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(597);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EOperationContext)_localctx).visibility.element);
			setState(602);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(601);
				((EOperationContext)_localctx).s21 = match(T__20);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s21);
				}
			}

			setState(604);
			match(T__40);
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__58) {
				{
				setState(605);
				((EOperationContext)_localctx).ownedSignature = ((EOperationContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EOperationContext)_localctx).templateSignature.typeParameters);
			setState(609);
			((EOperationContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null));
			{
			setState(611);
			match(T__41);
			setState(620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__16 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__22 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__30 - 11)) | (1L << (T__32 - 11)) | (1L << (T__34 - 11)) | (1L << (T__36 - 11)) | (1L << (T__37 - 11)) | (1L << (T__39 - 11)) | (1L << (T__40 - 11)) | (1L << (T__43 - 11)) | (1L << (T__50 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__54 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__70 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__129 - 76)) | (1L << (T__130 - 76)) | (1L << (T__131 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
				{
				setState(612);
				((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(613);
					match(T__2);
					setState(614);
					((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(619);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(622);
			match(T__42);
			}
			for (EParameterContext ctx: ((EOperationContext)_localctx).eParameters){_localctx.element.getEParameters().add(ctx.element);}
			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(625);
				match(T__5);
				setState(626);
				((EOperationContext)_localctx).eReturnType = ((EOperationContext)_localctx).eGenericElementType = eGenericElementType(_localctx.current);
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(627);
					((EOperationContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
					}
				}

				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			 if (_localctx.eReturnType != null) _localctx.element.setEGenericType(((EOperationContext)_localctx).eGenericElementType.element);
			setState(643);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__43) {
				{
				setState(634);
				match(T__43);
				setState(635);
				((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
				setState(640);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(636);
					match(T__2);
					setState(637);
					((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
					}
					}
					setState(642);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 for(EGenericExceptionContext e: ((EOperationContext)_localctx).ownedException) _localctx.element.getEGenericExceptions().add(e.element);
			setState(661);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(646);
				match(T__1);
				setState(656); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(651);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__28:
						{
						setState(647);
						((EOperationContext)_localctx).s29 = match(T__28);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(648);
						((EOperationContext)_localctx).s30 = match(T__29);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(649);
						((EOperationContext)_localctx).s31 = match(T__30);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s31);
						}
						break;
					case T__31:
						{
						setState(650);
						((EOperationContext)_localctx).s32 = match(T__31);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s32);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(654);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(653);
						match(T__2);
						}
					}

					}
					}
					setState(658); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0) );
				setState(660);
				match(T__3);
				}
				break;
			}
			setState(683);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(663);
				match(T__1);
				setState(678);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (T__56 - 57)) | (1L << (T__70 - 57)) | (1L << (T__73 - 57)) | (1L << (T__74 - 57)) | (1L << (T__75 - 57)) | (1L << (T__76 - 57)))) != 0)) {
					{
					setState(676);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__56:
						{
						setState(664);
						((EOperationContext)_localctx).eAnnotation = ((EOperationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).eAnnotation.element);
						}
						break;
					case T__73:
					case T__74:
						{
						setState(667);
						((EOperationContext)_localctx).precondition = ((EOperationContext)_localctx).precondition = precondition(_localctx.current);
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).precondition.element);
						}
						break;
					case T__70:
						{
						setState(670);
						((EOperationContext)_localctx).body = ((EOperationContext)_localctx).body = body(_localctx.current);
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).body.element);
						}
						break;
					case T__75:
					case T__76:
						{
						setState(673);
						((EOperationContext)_localctx).postcondition = ((EOperationContext)_localctx).postcondition = postcondition(_localctx.current);
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).postcondition.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(680);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(681);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(682);
				match(T__9);
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
		enterRule(_localctx, 38, RULE_eGenericException);
		((EGenericExceptionContext)_localctx).current =  new GenericException(_localctx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
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
		enterRule(_localctx, 40, RULE_eGenericSuperType);
		((EGenericSuperTypeContext)_localctx).current =  new GenericSuperType(_localctx.element, _localctx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
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
		public Token s29;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s30;
		public Token s31;
		public Token s32;
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
		enterRule(_localctx, 42, RULE_eParameter);
		((EParameterContext)_localctx).element =  eFactory.createEParameter();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			((EParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null));
			((EParameterContext)_localctx).current =  new Parameter(_localctx.element, _localctx);
			setState(696);
			match(T__5);
			setState(697);
			((EParameterContext)_localctx).eParameterType = eGenericElementType(_localctx.current);
			setState(699);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(698);
				((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(717);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
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
					case T__28:
						{
						setState(703);
						((EParameterContext)_localctx).s29 = match(T__28);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(704);
						((EParameterContext)_localctx).s30 = match(T__29);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(705);
						((EParameterContext)_localctx).s31 = match(T__30);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s31);
						}
						break;
					case T__31:
						{
						setState(706);
						((EParameterContext)_localctx).s32 = match(T__31);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s32);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0) );
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
				while (_la==T__56) {
					{
					{
					setState(720);
					((EParameterContext)_localctx).eAnnotation = ((EParameterContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
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
		enterRule(_localctx, 44, RULE_eMultiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(T__11);
			setState(739);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(733);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(736);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(734);
					match(T__44);
					setState(735);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__45:
			case T__46:
			case T__47:
				{
				setState(738);
				((EMultiplicityContext)_localctx).stringBound = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__45) | (1L << T__46) | (1L << T__47))) != 0)) ) {
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
			setState(743);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__48:
				{
				setState(741);
				((EMultiplicityContext)_localctx).nullable = match(T__48);
				}
				break;
			case T__49:
				{
				setState(742);
				match(T__49);
				}
				break;
			case T__12:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(745);
			match(T__12);

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
		public Token s51;
		public List<Token> qualifier = new ArrayList<Token>();
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public Token instanceClassName;
		public Token s53;
		public Token s54;
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
		enterRule(_localctx, 46, RULE_eDataType);
		((EDataTypeContext)_localctx).element =  eFactory.createEDataType();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(748);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).visibility.element);
			setState(753);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__50) {
				{
				setState(752);
				((EDataTypeContext)_localctx).s51 = match(T__50);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s51);
				}
			}

			setState(755);
			match(T__51);
			setState(756);
			((EDataTypeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null));
			((EDataTypeContext)_localctx).current =  new DataType(_localctx.element, _localctx);
			setState(760);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__58) {
				{
				setState(759);
				((EDataTypeContext)_localctx).ownedSignature = ((EDataTypeContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EDataTypeContext)_localctx).templateSignature.typeParameters);
			setState(765);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(763);
				match(T__5);
				setState(764);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EDataTypeContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EDataTypeContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(774);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(768);
				match(T__1);
				setState(771);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__52:
					{
					setState(769);
					((EDataTypeContext)_localctx).s53 = match(T__52);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s53);
					}
					break;
				case T__53:
					{
					setState(770);
					((EDataTypeContext)_localctx).s54 = match(T__53);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s54);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(773);
				match(T__3);
				}
				break;
			}
			setState(790);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(776);
				match(T__1);
				setState(785);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (T__56 - 57)) | (1L << (T__71 - 57)) | (1L << (T__72 - 57)))) != 0)) {
					{
					setState(783);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__56:
						{
						setState(777);
						((EDataTypeContext)_localctx).eAnnotation = ((EDataTypeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).eAnnotation.element);
						}
						break;
					case T__71:
					case T__72:
						{
						setState(780);
						((EDataTypeContext)_localctx).invariant = ((EDataTypeContext)_localctx).invariant = invariant(_localctx.current);
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).invariant.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(787);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(788);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(789);
				match(T__9);
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
		public Token s53;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s54;
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
		enterRule(_localctx, 48, RULE_eEnum);
		((EEnumContext)_localctx).element =  eFactory.createEEnum();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) {
				{
				setState(794);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EEnumContext)_localctx).visibility.element);
			setState(798);
			match(T__54);
			setState(799);
			((EEnumContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null));
			((EEnumContext)_localctx).current =  new Enum(_localctx.element, _localctx);
			setState(803);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__58) {
				{
				setState(802);
				((EEnumContext)_localctx).ownedSignature = ((EEnumContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EEnumContext)_localctx).templateSignature.typeParameters);
			setState(808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(806);
				match(T__5);
				setState(807);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EEnumContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EEnumContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(817);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				{
				setState(811);
				match(T__1);
				setState(814);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__52:
					{
					setState(812);
					((EEnumContext)_localctx).s53 = match(T__52);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s53);
					}
					break;
				case T__53:
					{
					setState(813);
					((EEnumContext)_localctx).s54 = match(T__53);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s54);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(816);
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
				setState(819);
				match(T__1);
				setState(831);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__16 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__22 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__30 - 11)) | (1L << (T__32 - 11)) | (1L << (T__34 - 11)) | (1L << (T__36 - 11)) | (1L << (T__37 - 11)) | (1L << (T__39 - 11)) | (1L << (T__40 - 11)) | (1L << (T__43 - 11)) | (1L << (T__50 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__54 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__70 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__129 - 76)) | (1L << (T__130 - 76)) | (1L << (T__131 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
					{
					setState(829);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
					case 1:
						{
						setState(820);
						((EEnumContext)_localctx).eAnnotation = ((EEnumContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(823);
						((EEnumContext)_localctx).eEnumLiteral = ((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.current);
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						_localctx.element.getELiterals().add(((EEnumContext)_localctx).eEnumLiteral.element);
						}
						break;
					case 3:
						{
						setState(826);
						((EEnumContext)_localctx).invariant = ((EEnumContext)_localctx).invariant = invariant(_localctx.current);
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).invariant.element);
						}
						break;
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
			case T__9:
				{
				setState(835);
				match(T__9);
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
		public Token value;
		public EAnnotationContext eAnnotation;
		public List<EAnnotationContext> ownedAnnotations = new ArrayList<EAnnotationContext>();
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
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
		enterRule(_localctx, 50, RULE_eEnumLiteral);
		((EEnumLiteralContext)_localctx).element =  eFactory.createEEnumLiteral();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				{
				setState(840);
				match(T__55);
				setState(841);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(842);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			_localctx.element.setName((((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null));
			((EEnumLiteralContext)_localctx).current =  new EnumLiteral(_localctx.element, _localctx);
			setState(849);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(847);
				match(T__15);
				setState(848);
				((EEnumLiteralContext)_localctx).value = match(INT);
				}
			}

			 
			setState(862);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(852);
				match(T__1);
				setState(856);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__56) {
					{
					{
					setState(853);
					((EEnumLiteralContext)_localctx).eAnnotation = ((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(858);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EEnumLiteralContext)_localctx).eAnnotation.element);
				setState(860);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(861);
				match(T__9);
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
		enterRule(_localctx, 52, RULE_eAnnotation);
		((EAnnotationContext)_localctx).element =  eFactory.createEAnnotation();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864);
			match(T__56);
			setState(866);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(865);
				((EAnnotationContext)_localctx).source = match(SINGLE_QUOTED_STRING);
				}
			}

			_localctx.element.setSource(((EAnnotationContext)_localctx).source != null ? ((EAnnotationContext)_localctx).source.getText().replace("'", "") : null);
			((EAnnotationContext)_localctx).current =  new Annotation(_localctx.element, _localctx);
			setState(881);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(870);
				match(T__41);
				setState(871);
				((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(876);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(872);
					match(T__2);
					setState(873);
					((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(878);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(879);
				match(T__42);
				}
			}

			for (EDetailContext ctx: ((EAnnotationContext)_localctx).ownedDetails) _localctx.element.getDetails().put(ctx.k, ctx.v);
			setState(901);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(884);
				match(T__1);
				setState(894); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(894);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
					case 1:
						{
						setState(885);
						((EAnnotationContext)_localctx).eAnnotation = ((EAnnotationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						if(((EAnnotationContext)_localctx).eAnnotation.element != null) _localctx.element.getEAnnotations().add(((EAnnotationContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(888);
						((EAnnotationContext)_localctx).eModelElement = ((EAnnotationContext)_localctx).eModelElement = eModelElement(_localctx.current);
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						if(((EAnnotationContext)_localctx).eModelElement.element != null) _localctx.element.getContents().add(((EAnnotationContext)_localctx).eModelElement.element);
						}
						break;
					case 3:
						{
						setState(891);
						((EAnnotationContext)_localctx).eModelElementRef = ((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef(_localctx.current);
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						if(((EAnnotationContext)_localctx).eModelElementRef.element != null) _localctx.element.getReferences().add(((EAnnotationContext)_localctx).eModelElementRef.element);
						}
						break;
					}
					}
					setState(896); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__16 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__21 - 11)) | (1L << (T__22 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__30 - 11)) | (1L << (T__32 - 11)) | (1L << (T__34 - 11)) | (1L << (T__36 - 11)) | (1L << (T__37 - 11)) | (1L << (T__39 - 11)) | (1L << (T__40 - 11)) | (1L << (T__43 - 11)) | (1L << (T__50 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__54 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__70 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__79 - 76)) | (1L << (T__80 - 76)) | (1L << (T__81 - 76)) | (1L << (T__129 - 76)) | (1L << (T__130 - 76)) | (1L << (T__131 - 76)) | (1L << (IDENTIFIER - 76)))) != 0) );
				setState(898);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(900);
				match(T__9);
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
		enterRule(_localctx, 54, RULE_eDetail);
		((EDetailContext)_localctx).current =  new AnnotationDetail(_localctx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(903);
				((EDetailContext)_localctx).key = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(906);
			match(T__15);
			setState(908);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) {
				{
				setState(907);
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
		enterRule(_localctx, 56, RULE_eModelElement);
		try {
			setState(918);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(912);
				((EModelElementContext)_localctx).eAnnotation = eAnnotation(_localctx.owner);
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eAnnotation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(915);
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
		enterRule(_localctx, 58, RULE_eNamedElement);
		try {
			setState(932);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(920);
				((ENamedElementContext)_localctx).eTypedElement = eTypedElement(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eTypedElement.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(923);
				((ENamedElementContext)_localctx).eClassifier = eClassifier(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eClassifier.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(926);
				((ENamedElementContext)_localctx).ePackage = ePackage(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).ePackage.element;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(929);
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
		enterRule(_localctx, 60, RULE_eTypedElement);
		try {
			setState(943);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(934);
				((ETypedElementContext)_localctx).eOperation = eOperation(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eOperation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(937);
				((ETypedElementContext)_localctx).eParameter = eParameter(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eParameter.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(940);
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
		enterRule(_localctx, 62, RULE_eModelElementRef);
		((EModelElementRefContext)_localctx).current =  new AnnotationReference(_localctx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(945);
			match(T__57);
			setState(946);
			((EModelElementRefContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(947);
			match(T__9);
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
		enterRule(_localctx, 64, RULE_templateSignature);
		((TemplateSignatureContext)_localctx).typeParameters =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949);
			match(T__58);
			setState(950);
			((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
			((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
			setState(955);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(951);
				match(T__2);
				setState(952);
				((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
				((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
				}
				}
				setState(957);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(958);
			match(T__59);
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
		enterRule(_localctx, 66, RULE_eTypeParameter);
		((ETypeParameterContext)_localctx).element =  eFactory.createETypeParameter();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(960);
			((ETypeParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((ETypeParameterContext)_localctx).name!=null?_input.getText(((ETypeParameterContext)_localctx).name.start,((ETypeParameterContext)_localctx).name.stop):null));
			((ETypeParameterContext)_localctx).current =  new TypeParameter(_localctx.element, _localctx);
			setState(972);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(963);
				match(T__19);
				setState(964);
				((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
				setState(969);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__60) {
					{
					{
					setState(965);
					match(T__60);
					setState(966);
					((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
					((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
					}
					}
					setState(971);
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
		enterRule(_localctx, 68, RULE_eGenericTypeArgument);
		((EGenericTypeArgumentContext)_localctx).current =  new GenericTypeArgument(_localctx);
		try {
			setState(982);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__13:
			case T__14:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__32:
			case T__34:
			case T__36:
			case T__37:
			case T__39:
			case T__40:
			case T__43:
			case T__50:
			case T__51:
			case T__52:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__70:
			case T__71:
			case T__72:
			case T__73:
			case T__75:
			case T__77:
			case T__78:
			case T__129:
			case T__130:
			case T__131:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(976);
				((EGenericTypeArgumentContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((EGenericTypeArgumentContext)_localctx).element =  ((EGenericTypeArgumentContext)_localctx).eGenericType.element;
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 2);
				{
				setState(979);
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
		enterRule(_localctx, 70, RULE_eGenericType);
		((EGenericTypeContext)_localctx).element =  eFactory.createEGenericType(); if (_localctx.parent instanceof ETypeParameterContext) ((EGenericTypeContext)_localctx).current =  new GenericType(_localctx.element, _localctx); else ((EGenericTypeContext)_localctx).current =  _localctx.owner;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(984);
			((EGenericTypeContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(996);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__58) {
				{
				setState(985);
				match(T__58);
				setState(986);
				((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
				((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(987);
					match(T__2);
					setState(988);
					((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
					((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
					}
					}
					setState(993);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(994);
				match(T__59);
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
		enterRule(_localctx, 72, RULE_eGenericElementType);
		((EGenericElementTypeContext)_localctx).current =  new GenericElementType(_localctx);
		try {
			setState(1004);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__65:
			case T__66:
			case T__67:
			case T__68:
			case T__69:
				enterOuterAlt(_localctx, 1);
				{
				setState(998);
				((EGenericElementTypeContext)_localctx).ePrimitiveType = ePrimitiveType(_localctx.current);
				((EGenericElementTypeContext)_localctx).element =  ((EGenericElementTypeContext)_localctx).ePrimitiveType.element;
				}
				break;
			case T__10:
			case T__13:
			case T__14:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__32:
			case T__34:
			case T__36:
			case T__37:
			case T__39:
			case T__40:
			case T__43:
			case T__50:
			case T__51:
			case T__52:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__70:
			case T__71:
			case T__72:
			case T__73:
			case T__75:
			case T__77:
			case T__78:
			case T__129:
			case T__130:
			case T__131:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1001);
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
		enterRule(_localctx, 74, RULE_eGenericWildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			match(T__47);
			((EGenericWildcardContext)_localctx).element =  eFactory.createEGenericType();
			setState(1013);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19 || _la==T__61) {
				{
				setState(1008);
				((EGenericWildcardContext)_localctx).bound = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__61) ) {
					((EGenericWildcardContext)_localctx).bound = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((EGenericWildcardContext)_localctx).current =  new GenericWildcard(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);
				setState(1010);
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
		public Token index;
		public SegmentContext segment;
		public List<SegmentContext> midSegments = new ArrayList<SegmentContext>();
		public SegmentContext lastSegment;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
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
		enterRule(_localctx, 76, RULE_pathName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1015);
			((PathNameContext)_localctx).firstSegment = unrestrictedName();
			setState(1018);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1016);
				match(T__62);
				setState(1017);
				((PathNameContext)_localctx).index = match(INT);
				}
				break;
			}
			setState(1027);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				{
				setState(1023);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1020);
						((PathNameContext)_localctx).segment = segment();
						((PathNameContext)_localctx).midSegments.add(((PathNameContext)_localctx).segment);
						}
						} 
					}
					setState(1025);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
				}
				setState(1026);
				((PathNameContext)_localctx).lastSegment = segment();
				}
				break;
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
		public Token index;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
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
		enterRule(_localctx, 78, RULE_segment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			match(T__63);
			setState(1031);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__64) {
				{
				setState(1030);
				match(T__64);
				}
			}

			setState(1033);
			((SegmentContext)_localctx).name = unrestrictedName();
			setState(1036);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
			case 1:
				{
				setState(1034);
				match(T__62);
				setState(1035);
				((SegmentContext)_localctx).index = match(INT);
				}
				break;
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
		enterRule(_localctx, 80, RULE_ePrimitiveType);
		try {
			setState(1048);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__65:
				enterOuterAlt(_localctx, 1);
				{
				setState(1038);
				match(T__65);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBoolean());
				}
				break;
			case T__66:
				enterOuterAlt(_localctx, 2);
				{
				setState(1040);
				match(T__66);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEInt());
				}
				break;
			case T__67:
				enterOuterAlt(_localctx, 3);
				{
				setState(1042);
				match(T__67);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEString());
				}
				break;
			case T__68:
				enterOuterAlt(_localctx, 4);
				{
				setState(1044);
				match(T__68);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBigDecimal());
				}
				break;
			case T__69:
				enterOuterAlt(_localctx, 5);
				{
				setState(1046);
				match(T__69);
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
		enterRule(_localctx, 82, RULE_body);
		((BodyContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.BODY); ((BodyContext)_localctx).current =  new Body(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1050);
			match(T__70);
			setState(1052);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1051);
				((BodyContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((BodyContext)_localctx).name!=null?_input.getText(((BodyContext)_localctx).name.start,((BodyContext)_localctx).name.stop):null)); 
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
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1056);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1059);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1060);
				match(T__9);
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
		enterRule(_localctx, 84, RULE_invariant);
		((InvariantContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INVARIANT); ((InvariantContext)_localctx).current =  new Invariant(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1066);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__71) {
				{
				setState(1065);
				((InvariantContext)_localctx).isCallable = match(T__71);
				}
			}

			_localctx.element.getDetails().put("callable", ((InvariantContext)_localctx).isCallable != null ? "true" : "false");
			setState(1069);
			match(T__72);
			setState(1076);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1070);
				((InvariantContext)_localctx).name = identifier();
				setState(1074);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(1071);
					match(T__41);
					setState(1072);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1073);
					match(T__42);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InvariantContext)_localctx).name!=null?_input.getText(((InvariantContext)_localctx).name.start,((InvariantContext)_localctx).name.stop):null)); if(((InvariantContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((InvariantContext)_localctx).message!=null?((InvariantContext)_localctx).message.getText():null).replace("\"", ""));
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
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1080);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1083);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1084);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			if(_localctx.ownedSpecification!=null) {_localctx.element.getDetails().put("formula", getContextText(_localctx.formula())); _localctx.current.addOwnedElement(((InvariantContext)_localctx).ownedSpecification.element);}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_precondition);
		((PreconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.PRECONDITION); ((PreconditionContext)_localctx).current =  new PreCondition(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1089);
			_la = _input.LA(1);
			if ( !(_la==T__73 || _la==T__74) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1096);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1090);
				((PreconditionContext)_localctx).name = identifier();
				setState(1094);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(1091);
					match(T__41);
					setState(1092);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1093);
					match(T__42);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PreconditionContext)_localctx).name!=null?_input.getText(((PreconditionContext)_localctx).name.start,((PreconditionContext)_localctx).name.stop):null)); if(((PreconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PreconditionContext)_localctx).message!=null?((PreconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1099);
				match(T__5);
				setState(1101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1100);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1103);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1104);
				match(T__9);
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
		enterRule(_localctx, 88, RULE_postcondition);
		((PostconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.POSTCONDITION); ((PostconditionContext)_localctx).current =  new PostCondition(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1109);
			_la = _input.LA(1);
			if ( !(_la==T__75 || _la==T__76) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1110);
				((PostconditionContext)_localctx).name = identifier();
				setState(1114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(1111);
					match(T__41);
					setState(1112);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1113);
					match(T__42);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PostconditionContext)_localctx).name!=null?_input.getText(((PostconditionContext)_localctx).name.start,((PostconditionContext)_localctx).name.stop):null)); if(((PostconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PostconditionContext)_localctx).message!=null?((PostconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1119);
				match(T__5);
				setState(1121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1120);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1123);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1124);
				match(T__9);
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
		enterRule(_localctx, 90, RULE_initial);
		((InitialContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INITIAL); ((InitialContext)_localctx).current =  new Initial(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1129);
			match(T__77);
			setState(1131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1130);
				((InitialContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InitialContext)_localctx).name!=null?_input.getText(((InitialContext)_localctx).name.start,((InitialContext)_localctx).name.stop):null));
			setState(1140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1134);
				match(T__5);
				setState(1136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1135);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1138);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1139);
				match(T__9);
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
		enterRule(_localctx, 92, RULE_derivation);
		((DerivationContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.DERIVATION); ((DerivationContext)_localctx).current =  new Derivation(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1144);
			match(T__78);
			setState(1146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1145);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((DerivationContext)_localctx).name!=null?_input.getText(((DerivationContext)_localctx).name.start,((DerivationContext)_localctx).name.stop):null));
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
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1150);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1153);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1154);
				match(T__9);
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
		enterRule(_localctx, 94, RULE_visibilityKind);
		((VisibilityKindContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.VISIBILITY);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__79:
				{
				setState(1159);
				((VisibilityKindContext)_localctx).qualifier = match(T__79);
				}
				break;
			case T__80:
				{
				setState(1160);
				((VisibilityKindContext)_localctx).qualifier = match(T__80);
				}
				break;
			case T__81:
				{
				setState(1161);
				((VisibilityKindContext)_localctx).qualifier = match(T__81);
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

	public static class FormulaContext extends ParserRuleContext {
		public Formula element;
		public int var = 0;
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
			this.element = ctx.element;
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
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
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
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
		}
		public IntExpressionContext intExpression() {
			return getRuleContext(IntExpressionContext.class,0);
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
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
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
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
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
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
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
		public FormulaContext formula;
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
		public FormulaContext formula;
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
		public FormulaContext formula;
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
		public Token partial;
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
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
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
		public FormulaContext formula;
		public LetDeclarationsContext letDeclarations() {
			return getRuleContext(LetDeclarationsContext.class,0);
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
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
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
		public FormulaContext formula;
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
		public FormulaContext formula;
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
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
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
		public IntExpressionContext ileft;
		public Token not;
		public IntExpressionContext iright;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
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
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
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
		public FormulaContext formula;
		public QuantifierDeclarationsContext quantifierDeclarations() {
			return getRuleContext(QuantifierDeclarationsContext.class,0);
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
		public FormulaContext formula;
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
			setState(1449);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1167);
				match(T__82);
				setState(1168);
				expression(0);
				((NoContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1171);
				match(T__83);
				setState(1172);
				expression(0);
				((LoneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1175);
				match(T__84);
				setState(1176);
				expression(0);
				((OneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1179);
				match(T__85);
				setState(1180);
				expression(0);
				((SomeContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1183);
				((InContext)_localctx).left = expression(0);
				setState(1185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1184);
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

				setState(1187);
				match(T__88);
				setState(1188);
				((InContext)_localctx).right = expression(0);
				((InContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1191);
				((EqualContext)_localctx).left = expression(0);
				setState(1193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1192);
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

				setState(1195);
				match(T__15);
				setState(1196);
				((EqualContext)_localctx).right = expression(0);
				((EqualContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1199);
				((EqContext)_localctx).ileft = intExpression(0);
				setState(1201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1200);
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

				setState(1203);
				match(T__15);
				setState(1204);
				((EqContext)_localctx).iright = intExpression(0);
				((EqContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1207);
				((LtContext)_localctx).ileft = intExpression(0);
				setState(1209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1208);
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

				setState(1211);
				match(T__58);
				setState(1212);
				((LtContext)_localctx).iright = intExpression(0);
				((LtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1215);
				((LteContext)_localctx).ileft = intExpression(0);
				setState(1217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1216);
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

				setState(1219);
				match(T__89);
				setState(1220);
				((LteContext)_localctx).iright = intExpression(0);
				((LteContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1223);
				((GtContext)_localctx).ileft = intExpression(0);
				setState(1225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1224);
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

				setState(1227);
				match(T__59);
				setState(1228);
				((GtContext)_localctx).iright = intExpression(0);
				((GtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1231);
				((GteContext)_localctx).ileft = intExpression(0);
				setState(1233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__86 || _la==T__87) {
					{
					setState(1232);
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

				setState(1235);
				match(T__90);
				setState(1236);
				((GteContext)_localctx).iright = intExpression(0);
				((GteContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 12:
				{
				_localctx = new SumDeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(1239);
				match(T__91);
				setState(1240);
				quantifierDeclarations();
				setState(1241);
				match(T__92);
				setState(1242);
				intExpression(0);
				}
				((SumDeclarationContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 13:
				{
				_localctx = new AcyclicContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1246);
				match(T__93);
				setState(1247);
				match(T__11);
				setState(1248);
				relationId();
				setState(1249);
				match(T__12);
				((AcyclicContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1252);
				match(T__94);
				setState(1253);
				match(T__11);
				setState(1254);
				((FunctionContext)_localctx).rel = relationId();
				setState(1255);
				match(T__5);
				setState(1256);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1257);
				match(T__95);
				setState(1262);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__10:
				case T__13:
				case T__14:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
				case T__26:
				case T__27:
				case T__28:
				case T__30:
				case T__32:
				case T__34:
				case T__36:
				case T__37:
				case T__39:
				case T__40:
				case T__41:
				case T__43:
				case T__45:
				case T__50:
				case T__51:
				case T__52:
				case T__54:
				case T__55:
				case T__56:
				case T__57:
				case T__70:
				case T__71:
				case T__72:
				case T__73:
				case T__75:
				case T__77:
				case T__78:
				case T__84:
				case T__101:
				case T__102:
				case T__110:
				case T__111:
				case T__116:
				case T__117:
				case T__118:
				case T__119:
				case T__129:
				case T__130:
				case T__131:
				case IDENTIFIER:
					{
					setState(1259);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__84) {
						{
						setState(1258);
						match(T__84);
						}
					}

					}
					break;
				case T__83:
					{
					setState(1261);
					((FunctionContext)_localctx).partial = match(T__83);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1264);
				((FunctionContext)_localctx).range = expression(0);
				setState(1265);
				match(T__12);
				((FunctionContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1268);
				match(T__96);
				setState(1269);
				match(T__11);
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
				match(T__12);
				((TotalOrderContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 16:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1280);
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
				setState(1281);
				((NotContext)_localctx).formula = formula(14);
				((NotContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 17:
				{
				_localctx = new ForAllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(1284);
				match(T__106);
				setState(1285);
				quantifierDeclarations();
				setState(1306);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1286);
					match(T__92);
					setState(1296);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
					case 1:
						{
						setState(1287);
						((ForAllContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1288);
						match(T__1);
						setState(1292);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1289);
							((ForAllContext)_localctx).formula = formula(0);
							}
							}
							setState(1294);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1295);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1298);
					match(T__1);
					setState(1302);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1299);
						((ForAllContext)_localctx).formula = formula(0);
						}
						}
						setState(1304);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1305);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForAllContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 18:
				{
				_localctx = new ForSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(1310);
				match(T__85);
				setState(1311);
				quantifierDeclarations();
				setState(1332);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1312);
					match(T__92);
					setState(1322);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
					case 1:
						{
						setState(1313);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1314);
						match(T__1);
						setState(1318);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1315);
							((ForSomeContext)_localctx).formula = formula(0);
							}
							}
							setState(1320);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1321);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1324);
					match(T__1);
					setState(1328);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1325);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						}
						setState(1330);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1331);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForSomeContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 19:
				{
				_localctx = new ForNoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(1336);
				match(T__82);
				setState(1337);
				quantifierDeclarations();
				setState(1358);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1338);
					match(T__92);
					setState(1348);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
					case 1:
						{
						setState(1339);
						((ForNoContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1340);
						match(T__1);
						setState(1344);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1341);
							((ForNoContext)_localctx).formula = formula(0);
							}
							}
							setState(1346);
							_errHandler.sync(this);
							_la = _input.LA(1);
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
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1351);
						((ForNoContext)_localctx).formula = formula(0);
						}
						}
						setState(1356);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1357);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForNoContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 20:
				{
				_localctx = new ForOneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(1362);
				match(T__84);
				setState(1363);
				quantifierDeclarations();
				setState(1384);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1364);
					match(T__92);
					setState(1374);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
					case 1:
						{
						setState(1365);
						((ForOneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1366);
						match(T__1);
						setState(1370);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1367);
							((ForOneContext)_localctx).formula = formula(0);
							}
							}
							setState(1372);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1373);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1376);
					match(T__1);
					setState(1380);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1377);
						((ForOneContext)_localctx).formula = formula(0);
						}
						}
						setState(1382);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1383);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForOneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 21:
				{
				_localctx = new ForLoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(1388);
				match(T__83);
				setState(1389);
				quantifierDeclarations();
				setState(1410);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1390);
					match(T__92);
					setState(1400);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
					case 1:
						{
						setState(1391);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1392);
						match(T__1);
						setState(1396);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1393);
							((ForLoneContext)_localctx).formula = formula(0);
							}
							}
							setState(1398);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1399);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1402);
					match(T__1);
					setState(1406);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1403);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						}
						setState(1408);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1409);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((ForLoneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 22:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(1414);
				match(T__107);
				setState(1415);
				letDeclarations();
				setState(1436);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__92:
					{
					setState(1416);
					match(T__92);
					setState(1426);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
					case 1:
						{
						setState(1417);
						((LetContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1418);
						match(T__1);
						setState(1422);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1419);
							((LetContext)_localctx).formula = formula(0);
							}
							}
							setState(1424);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1425);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1428);
					match(T__1);
					setState(1432);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__43) | (1L << T__45) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)) | (1L << (T__73 - 71)) | (1L << (T__75 - 71)) | (1L << (T__77 - 71)) | (1L << (T__78 - 71)) | (1L << (T__82 - 71)) | (1L << (T__83 - 71)) | (1L << (T__84 - 71)) | (1L << (T__85 - 71)) | (1L << (T__86 - 71)) | (1L << (T__87 - 71)) | (1L << (T__91 - 71)) | (1L << (T__93 - 71)) | (1L << (T__94 - 71)) | (1L << (T__96 - 71)) | (1L << (T__101 - 71)) | (1L << (T__102 - 71)) | (1L << (T__106 - 71)) | (1L << (T__107 - 71)) | (1L << (T__108 - 71)) | (1L << (T__109 - 71)) | (1L << (T__110 - 71)) | (1L << (T__111 - 71)) | (1L << (T__112 - 71)) | (1L << (T__116 - 71)) | (1L << (T__117 - 71)) | (1L << (T__118 - 71)) | (1L << (T__119 - 71)) | (1L << (T__129 - 71)) | (1L << (T__130 - 71)) | (1L << (T__131 - 71)) | (1L << (INT - 71)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1429);
						((LetContext)_localctx).formula = formula(0);
						}
						}
						setState(1434);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1435);
					match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				((LetContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 23:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1440);
				match(T__108);
				((TrueContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1442);
				match(T__109);
				((FalseContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1444);
				match(T__41);
				setState(1445);
				((F_paranthesisContext)_localctx).formula = formula(0);
				setState(1446);
				match(T__42);
				((F_paranthesisContext)_localctx).element =  ((F_paranthesisContext)_localctx).formula.element;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1473);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1471);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
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
						if ( !(_la==T__97 || _la==T__98) ) {
							((AndContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1453);
						((AndContext)_localctx).fright = ((AndContext)_localctx).formula = formula(14);
						((AndContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1456);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1457);
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
						setState(1458);
						((OrContext)_localctx).fright = ((OrContext)_localctx).formula = formula(13);
						((OrContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1461);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1462);
						((ImpliesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (T__101 - 102)) | (1L << (T__102 - 102)) | (1L << (T__103 - 102)))) != 0)) ) {
							((ImpliesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1463);
						((ImpliesContext)_localctx).fright = ((ImpliesContext)_localctx).formula = formula(11);
						((ImpliesContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1466);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1467);
						((IffContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__104 || _la==T__105) ) {
							((IffContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1468);
						((IffContext)_localctx).fright = ((IffContext)_localctx).formula = formula(10);
						((IffContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1475);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
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
		public Expression element;
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this.element = ctx.element;
		}
	}
	public static class ProductContext extends ExpressionContext {
		public ExpressionContext left;
		public MultContext leftMult;
		public MultContext rightMult;
		public ExpressionContext right;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<MultContext> mult() {
			return getRuleContexts(MultContext.class);
		}
		public MultContext mult(int i) {
			return getRuleContext(MultContext.class,i);
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
		public ExpressionContext expression;
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
	public static class ComprehensionContext extends ExpressionContext {
		public ComprehensionDeclarationsContext comprehensionDeclarations() {
			return getRuleContext(ComprehensionDeclarationsContext.class,0);
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
		public ExpressionContext expression;
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
		public ExpressionContext expression;
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
		public ExpressionContext expression;
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
	public static class DifferenceContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext expression;
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
		public ExpressionContext expression;
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
		public ExpressionContext expression;
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
		public ExpressionContext expression;
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
		public ExpressionContext expression;
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
		public ExpressionContext expression;
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
	public static class TypeRefContext extends ExpressionContext {
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public TypeRefContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class BoxJoinContext extends ExpressionContext {
		public ExpressionContext right;
		public ExpressionContext left;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BoxJoinContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBoxJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBoxJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBoxJoin(this);
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
			setState(1520);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__110:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1477);
				match(T__110);
				setState(1478);
				((TransposeContext)_localctx).expression = expression(18);
				((TransposeContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__111:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1481);
				match(T__111);
				setState(1482);
				((ClosureContext)_localctx).expression = expression(17);
				((ClosureContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__45:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1485);
				match(T__45);
				setState(1486);
				((ReflexiveContext)_localctx).expression = expression(16);
				((ReflexiveContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__1:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1489);
				match(T__1);
				setState(1490);
				comprehensionDeclarations();
				setState(1491);
				match(T__92);
				setState(1492);
				formula(0);
				setState(1493);
				match(T__3);
				((ComprehensionContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__101:
			case T__102:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1496);
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
				setState(1497);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1498);
				match(T__114);
				setState(1499);
				((IfExpressionContext)_localctx).thenExpr = ((IfExpressionContext)_localctx).expression = expression(0);
				setState(1500);
				match(T__115);
				setState(1501);
				((IfExpressionContext)_localctx).elseExpr = ((IfExpressionContext)_localctx).expression = expression(7);
				((IfExpressionContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__116:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1504);
				match(T__116);
				((IdenContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__117:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1506);
				match(T__117);
				((NoneContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__118:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1508);
				match(T__118);
				((UnivContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__119:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1510);
				match(T__119);
				((IntsContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__41:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1512);
				match(T__41);
				setState(1513);
				((E_paranthesisContext)_localctx).expression = expression(0);
				setState(1514);
				match(T__42);
				((E_paranthesisContext)_localctx).element =  ((E_paranthesisContext)_localctx).expression.element;
				}
				break;
			case T__10:
			case T__13:
			case T__14:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__32:
			case T__34:
			case T__36:
			case T__37:
			case T__39:
			case T__40:
			case T__43:
			case T__50:
			case T__51:
			case T__52:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__70:
			case T__71:
			case T__72:
			case T__73:
			case T__75:
			case T__77:
			case T__78:
			case T__129:
			case T__130:
			case T__131:
			case IDENTIFIER:
				{
				_localctx = new TypeRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1517);
				pathName(_localctx.element);
				((TypeRefContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1566);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,207,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1564);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1522);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1523);
						match(T__46);
						setState(1524);
						((UnionContext)_localctx).right = ((UnionContext)_localctx).expression = expression(16);
						((UnionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1527);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1528);
						match(T__60);
						setState(1529);
						((IntersectionContext)_localctx).right = ((IntersectionContext)_localctx).expression = expression(15);
						((IntersectionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1532);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1533);
						match(T__112);
						setState(1534);
						((DifferenceContext)_localctx).right = ((DifferenceContext)_localctx).expression = expression(14);
						((DifferenceContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1537);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1538);
						match(T__62);
						setState(1539);
						((JoinContext)_localctx).right = ((JoinContext)_localctx).expression = expression(13);
						((JoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1542);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1544);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (T__83 - 84)) | (1L << (T__84 - 84)) | (1L << (T__85 - 84)) | (1L << (T__128 - 84)))) != 0)) {
							{
							setState(1543);
							((ProductContext)_localctx).leftMult = mult();
							}
						}

						setState(1546);
						match(T__95);
						setState(1548);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (T__83 - 84)) | (1L << (T__84 - 84)) | (1L << (T__85 - 84)) | (1L << (T__128 - 84)))) != 0)) {
							{
							setState(1547);
							((ProductContext)_localctx).rightMult = mult();
							}
						}

						setState(1550);
						((ProductContext)_localctx).right = ((ProductContext)_localctx).expression = expression(10);
						((ProductContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1553);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1554);
						match(T__113);
						setState(1555);
						((OverrideContext)_localctx).right = ((OverrideContext)_localctx).expression = expression(10);
						((OverrideContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 7:
						{
						_localctx = new BoxJoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxJoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1558);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1559);
						match(T__11);
						setState(1560);
						((BoxJoinContext)_localctx).left = ((BoxJoinContext)_localctx).expression = expression(0);
						setState(1561);
						match(T__12);
						((BoxJoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1568);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,207,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
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

	public static class IntExpressionContext extends ParserRuleContext {
		public IntExpression element;
		public IntExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intExpression; }
	 
		public IntExpressionContext() { }
		public void copyFrom(IntExpressionContext ctx) {
			super.copyFrom(ctx);
			this.element = ctx.element;
		}
	}
	public static class MinusContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public MinusContext(IntExpressionContext ctx) { copyFrom(ctx); }
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
	public static class IntConstantContext extends IntExpressionContext {
		public Token sign;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public IntConstantContext(IntExpressionContext ctx) { copyFrom(ctx); }
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
	public static class I_paranthesisContext extends IntExpressionContext {
		public IntExpressionContext intExpression;
		public IntExpressionContext intExpression() {
			return getRuleContext(IntExpressionContext.class,0);
		}
		public I_paranthesisContext(IntExpressionContext ctx) { copyFrom(ctx); }
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
	public static class IfIntExpressionContext extends IntExpressionContext {
		public Token op;
		public FormulaContext condition;
		public IntExpressionContext thenExpr;
		public IntExpressionContext intExpression;
		public IntExpressionContext elseExpr;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public IfIntExpressionContext(IntExpressionContext ctx) { copyFrom(ctx); }
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
	public static class CountContext extends IntExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CountContext(IntExpressionContext ctx) { copyFrom(ctx); }
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
	public static class SumContext extends IntExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SumContext(IntExpressionContext ctx) { copyFrom(ctx); }
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
	public static class DivideContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public DivideContext(IntExpressionContext ctx) { copyFrom(ctx); }
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
	public static class MultiplyContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public MultiplyContext(IntExpressionContext ctx) { copyFrom(ctx); }
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
	public static class ModuloContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public ModuloContext(IntExpressionContext ctx) { copyFrom(ctx); }
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
	public static class PlusContext extends IntExpressionContext {
		public IntExpressionContext ileft;
		public IntExpressionContext iright;
		public IntExpressionContext intExpression;
		public List<IntExpressionContext> intExpression() {
			return getRuleContexts(IntExpressionContext.class);
		}
		public IntExpressionContext intExpression(int i) {
			return getRuleContext(IntExpressionContext.class,i);
		}
		public PlusContext(IntExpressionContext ctx) { copyFrom(ctx); }
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

	public final IntExpressionContext intExpression() throws RecognitionException {
		return intExpression(0);
	}

	private IntExpressionContext intExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IntExpressionContext _localctx = new IntExpressionContext(_ctx, _parentState);
		IntExpressionContext _prevctx = _localctx;
		int _startState = 100;
		enterRecursionRule(_localctx, 100, RULE_intExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1596);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__101:
			case T__102:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1570);
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
				setState(1571);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1572);
				match(T__114);
				setState(1573);
				((IfIntExpressionContext)_localctx).thenExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(0);
				setState(1574);
				match(T__115);
				setState(1575);
				((IfIntExpressionContext)_localctx).elseExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(10);
				((IfIntExpressionContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__91:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1578);
				match(T__91);
				setState(1579);
				expression(0);
				((SumContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__35:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1582);
				match(T__35);
				setState(1583);
				expression(0);
				((CountContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__112:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__112) {
					{
					setState(1586);
					((IntConstantContext)_localctx).sign = match(T__112);
					}
				}

				setState(1589);
				match(INT);
				((IntConstantContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__41:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1591);
				match(T__41);
				setState(1592);
				((I_paranthesisContext)_localctx).intExpression = intExpression(0);
				setState(1593);
				match(T__42);
				((I_paranthesisContext)_localctx).element =  ((I_paranthesisContext)_localctx).intExpression.element;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1625);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1623);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntExpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1598);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1599);
						_la = _input.LA(1);
						if ( !(_la==T__46 || _la==T__120) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1600);
						((PlusContext)_localctx).iright = ((PlusContext)_localctx).intExpression = intExpression(8);
						((PlusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntExpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1603);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1604);
						_la = _input.LA(1);
						if ( !(_la==T__112 || _la==T__121) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1605);
						((MinusContext)_localctx).iright = ((MinusContext)_localctx).intExpression = intExpression(7);
						((MinusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntExpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1608);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1609);
						_la = _input.LA(1);
						if ( !(_la==T__45 || _la==T__122) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1610);
						((MultiplyContext)_localctx).iright = ((MultiplyContext)_localctx).intExpression = intExpression(6);
						((MultiplyContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntExpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1613);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1614);
						_la = _input.LA(1);
						if ( !(_la==T__123 || _la==T__124) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1615);
						((DivideContext)_localctx).iright = ((DivideContext)_localctx).intExpression = intExpression(5);
						((DivideContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntExpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1618);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1619);
						_la = _input.LA(1);
						if ( !(_la==T__125 || _la==T__126) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1620);
						((ModuloContext)_localctx).iright = ((ModuloContext)_localctx).intExpression = intExpression(4);
						((ModuloContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1627);
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

	public static class QuantifierDeclarationsContext extends ParserRuleContext {
		public List<QuantifierDeclaration> elements;
		public List<QuantifierDeclarationContext> quantifierDeclaration() {
			return getRuleContexts(QuantifierDeclarationContext.class);
		}
		public QuantifierDeclarationContext quantifierDeclaration(int i) {
			return getRuleContext(QuantifierDeclarationContext.class,i);
		}
		public QuantifierDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifierDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterQuantifierDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitQuantifierDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitQuantifierDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierDeclarationsContext quantifierDeclarations() throws RecognitionException {
		QuantifierDeclarationsContext _localctx = new QuantifierDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_quantifierDeclarations);
		((QuantifierDeclarationsContext)_localctx).elements =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1628);
			quantifierDeclaration();
			setState(1633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1629);
				match(T__2);
				setState(1630);
				quantifierDeclaration();
				}
				}
				setState(1635);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);
			for(QuantifierDeclarationContext ctx: _localctx.quantifierDeclaration()) _localctx.elements.add(ctx.element);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierDeclarationContext extends ParserRuleContext {
		public QuantifierDeclaration element;
		public QuantifierDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifierDeclaration; }
	 
		public QuantifierDeclarationContext() { }
		public void copyFrom(QuantifierDeclarationContext ctx) {
			super.copyFrom(ctx);
			this.element = ctx.element;
		}
	}
	public static class OneOfContext extends QuantifierDeclarationContext {
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
		public OneOfContext(QuantifierDeclarationContext ctx) { copyFrom(ctx); }
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
	public static class SomeOfContext extends QuantifierDeclarationContext {
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
		public SomeOfContext(QuantifierDeclarationContext ctx) { copyFrom(ctx); }
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
	public static class LoneOfContext extends QuantifierDeclarationContext {
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
		public LoneOfContext(QuantifierDeclarationContext ctx) { copyFrom(ctx); }
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
	public static class SetOfContext extends QuantifierDeclarationContext {
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
		public SetOfContext(QuantifierDeclarationContext ctx) { copyFrom(ctx); }
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

	public final QuantifierDeclarationContext quantifierDeclaration() throws RecognitionException {
		QuantifierDeclarationContext _localctx = new QuantifierDeclarationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_quantifierDeclaration);
		int _la;
		try {
			setState(1702);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1637);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__127) {
					{
					setState(1636);
					((OneOfContext)_localctx).disj = match(T__127);
					}
				}

				setState(1639);
				((OneOfContext)_localctx).variable = variable();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
				setState(1644);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1640);
					match(T__2);
					setState(1641);
					((OneOfContext)_localctx).variable = variable();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
					}
					}
					setState(1646);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1647);
				match(T__5);
				setState(1649);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__84) {
					{
					setState(1648);
					match(T__84);
					}
				}

				setState(1651);
				expression(0);
				((OneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__127) {
					{
					setState(1654);
					((LoneOfContext)_localctx).disj = match(T__127);
					}
				}

				setState(1657);
				((LoneOfContext)_localctx).variable = variable();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
				setState(1662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1658);
					match(T__2);
					setState(1659);
					((LoneOfContext)_localctx).variable = variable();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
					}
					}
					setState(1664);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1665);
				match(T__5);
				setState(1666);
				match(T__83);
				setState(1667);
				expression(0);
				((LoneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__127) {
					{
					setState(1670);
					((SomeOfContext)_localctx).disj = match(T__127);
					}
				}

				setState(1673);
				((SomeOfContext)_localctx).variable = variable();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
				setState(1678);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1674);
					match(T__2);
					setState(1675);
					((SomeOfContext)_localctx).variable = variable();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
					}
					}
					setState(1680);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1681);
				match(T__5);
				setState(1682);
				match(T__85);
				setState(1683);
				expression(0);
				((SomeOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__127) {
					{
					setState(1686);
					((SetOfContext)_localctx).disj = match(T__127);
					}
				}

				setState(1689);
				((SetOfContext)_localctx).variable = variable();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
				setState(1694);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1690);
					match(T__2);
					setState(1691);
					((SetOfContext)_localctx).variable = variable();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
					}
					}
					setState(1696);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1697);
				match(T__5);
				setState(1698);
				match(T__128);
				setState(1699);
				expression(0);
				((SetOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
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

	public static class LetDeclarationsContext extends ParserRuleContext {
		public List<LetDeclaration> elements;
		public List<LetDeclarationContext> letDeclaration() {
			return getRuleContexts(LetDeclarationContext.class);
		}
		public LetDeclarationContext letDeclaration(int i) {
			return getRuleContext(LetDeclarationContext.class,i);
		}
		public LetDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLetDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLetDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLetDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetDeclarationsContext letDeclarations() throws RecognitionException {
		LetDeclarationsContext _localctx = new LetDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_letDeclarations);
		((LetDeclarationsContext)_localctx).elements =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1704);
			letDeclaration();
			setState(1709);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1705);
				match(T__2);
				setState(1706);
				letDeclaration();
				}
				}
				setState(1711);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);
			for(LetDeclarationContext ctx: _localctx.letDeclaration()) _localctx.elements.add(ctx.element);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetDeclarationContext extends ParserRuleContext {
		public LetDeclaration element;
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public LetDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterLetDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitLetDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLetDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetDeclarationContext letDeclaration() throws RecognitionException {
		LetDeclarationContext _localctx = new LetDeclarationContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_letDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1712);
			((LetDeclarationContext)_localctx).variable = variable();
			((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
			setState(1717);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1713);
				match(T__2);
				setState(1714);
				((LetDeclarationContext)_localctx).variable = variable();
				((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
				}
				}
				setState(1719);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1720);
			match(T__15);
			setState(1721);
			((LetDeclarationContext)_localctx).expression = expression(0);
			((LetDeclarationContext)_localctx).element =  new LetDeclaration(_localctx);  for(VariableContext ctx: _localctx.variable()) _localctx.element.addOwnedElements(ctx.element);  _localctx.element.addOwnedElements(((LetDeclarationContext)_localctx).expression.element);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComprehensionDeclarationsContext extends ParserRuleContext {
		public List<ComprehensionDeclaration> elements;
		public List<ComprehensionDeclarationContext> comprehensionDeclaration() {
			return getRuleContexts(ComprehensionDeclarationContext.class);
		}
		public ComprehensionDeclarationContext comprehensionDeclaration(int i) {
			return getRuleContext(ComprehensionDeclarationContext.class,i);
		}
		public ComprehensionDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comprehensionDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterComprehensionDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitComprehensionDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitComprehensionDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComprehensionDeclarationsContext comprehensionDeclarations() throws RecognitionException {
		ComprehensionDeclarationsContext _localctx = new ComprehensionDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_comprehensionDeclarations);
		((ComprehensionDeclarationsContext)_localctx).elements =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1724);
			comprehensionDeclaration();
			setState(1729);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1725);
				match(T__2);
				setState(1726);
				comprehensionDeclaration();
				}
				}
				setState(1731);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);
			for(ComprehensionDeclarationContext ctx: _localctx.comprehensionDeclaration()) _localctx.elements.add(ctx.element);
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComprehensionDeclarationContext extends ParserRuleContext {
		public ComprehensionDeclaration element;
		public Token disj;
		public VariableContext variable;
		public List<VariableContext> vars = new ArrayList<VariableContext>();
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ComprehensionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comprehensionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterComprehensionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitComprehensionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitComprehensionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComprehensionDeclarationContext comprehensionDeclaration() throws RecognitionException {
		ComprehensionDeclarationContext _localctx = new ComprehensionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_comprehensionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1733);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__127) {
				{
				setState(1732);
				((ComprehensionDeclarationContext)_localctx).disj = match(T__127);
				}
			}

			{
			setState(1735);
			((ComprehensionDeclarationContext)_localctx).variable = variable();
			((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
			setState(1740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1736);
				match(T__2);
				setState(1737);
				((ComprehensionDeclarationContext)_localctx).variable = variable();
				((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
				}
				}
				setState(1742);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1743);
			match(T__5);
			setState(1745);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__84) {
				{
				setState(1744);
				match(T__84);
				}
			}

			setState(1747);
			((ComprehensionDeclarationContext)_localctx).expression = expression(0);
			}
			((ComprehensionDeclarationContext)_localctx).element =  new ComprehensionDeclaration(_localctx); for(VariableContext ctx: _localctx.variable()) _localctx.element.addOwnedElements(ctx.element); _localctx.element.addOwnedElements(((ComprehensionDeclarationContext)_localctx).expression.element);
			}
		}
		catch (RecognitionException re) {
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
			setState(1751);
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

	public static class VariableContext extends ParserRuleContext {
		public Variable element;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1753);
			unrestrictedName();
			((VariableContext)_localctx).element =  new Variable(_localctx);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultContext extends ParserRuleContext {
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_mult);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1756);
			_la = _input.LA(1);
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (T__83 - 84)) | (1L << (T__84 - 84)) | (1L << (T__85 - 84)) | (1L << (T__128 - 84)))) != 0)) ) {
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
			setState(1800);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1758);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1759);
				match(T__16);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1760);
				match(T__25);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1761);
				match(T__70);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1762);
				match(T__71);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1763);
				match(T__17);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1764);
				match(T__36);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1765);
				match(T__51);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1766);
				match(T__129);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1767);
				match(T__78);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1768);
				match(T__26);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1769);
				match(T__54);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1770);
				match(T__130);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1771);
				match(T__19);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1772);
				match(T__27);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1773);
				match(T__13);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1774);
				match(T__77);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1775);
				match(T__18);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1776);
				match(T__39);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(1777);
				match(T__10);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(1778);
				match(T__40);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(1779);
				match(T__28);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(1780);
				match(T__14);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(1781);
				match(T__75);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(1782);
				match(T__73);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(1783);
				match(T__50);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(1784);
				match(T__34);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(1785);
				match(T__24);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(1786);
				match(T__57);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(1787);
				match(T__131);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(1788);
				match(T__37);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(1789);
				match(T__20);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(1790);
				match(T__43);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(1791);
				match(T__22);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(1792);
				match(T__30);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(1793);
				match(T__32);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(1794);
				match(T__23);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(1795);
				match(T__72);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(1796);
				match(T__55);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(1797);
				match(T__52);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(1798);
				match(T__56);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(1799);
				match(T__10);
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

	public static class BooleanValueContext extends ParserRuleContext {
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_booleanValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1802);
			_la = _input.LA(1);
			if ( !(_la==T__108 || _la==T__109) ) {
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

	public static class NumericValueContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(AlloyInEcoreParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(AlloyInEcoreParser.INT, i);
		}
		public NumericValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterNumericValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitNumericValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitNumericValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericValueContext numericValue() throws RecognitionException {
		NumericValueContext _localctx = new NumericValueContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_numericValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1805);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46 || _la==T__112) {
				{
				setState(1804);
				_la = _input.LA(1);
				if ( !(_la==T__46 || _la==T__112) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(1808);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
			case 1:
				{
				setState(1807);
				match(INT);
				}
				break;
			}
			setState(1811);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__62) {
				{
				setState(1810);
				match(T__62);
				}
			}

			setState(1813);
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

	public static class StringValueContext extends ParserRuleContext {
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public StringValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringValueContext stringValue() throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_stringValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1815);
			match(DOUBLE_QUOTED_STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CharValueContext extends ParserRuleContext {
		public TerminalNode SINGLE_CHARACTER() { return getToken(AlloyInEcoreParser.SINGLE_CHARACTER, 0); }
		public CharValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterCharValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitCharValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitCharValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharValueContext charValue() throws RecognitionException {
		CharValueContext _localctx = new CharValueContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_charValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1817);
			match(SINGLE_CHARACTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullValueContext extends ParserRuleContext {
		public NullValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterNullValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitNullValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitNullValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullValueContext nullValue() throws RecognitionException {
		NullValueContext _localctx = new NullValueContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_nullValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1819);
			match(T__132);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 132, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1821);
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
		enterRule(_localctx, 134, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1823);
			_la = _input.LA(1);
			if ( !(_la==T__45 || _la==INT) ) {
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
		enterRule(_localctx, 136, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1825);
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
			return intExpression_sempred((IntExpressionContext)_localctx, predIndex);
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
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 11);
		}
		return true;
	}
	private boolean intExpression_sempred(IntExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 7);
		case 12:
			return precpred(_ctx, 6);
		case 13:
			return precpred(_ctx, 5);
		case 14:
			return precpred(_ctx, 4);
		case 15:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0090\u0726\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\u0092\n\2\f\2\16\2\u0095\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00a5\n\3\3\4\7\4\u00a8\n\4\f\4\16\4\u00ab"+
		"\13\4\3\4\3\4\3\4\5\4\u00b0\n\4\3\5\3\5\3\5\3\5\5\5\u00b6\n\5\3\5\3\5"+
		"\3\5\3\6\3\6\5\6\u00bd\n\6\3\6\3\6\3\6\3\6\7\6\u00c3\n\6\f\6\16\6\u00c6"+
		"\13\6\3\6\3\6\3\6\5\6\u00cb\n\6\3\7\3\7\3\7\3\7\3\7\7\7\u00d2\n\7\f\7"+
		"\16\7\u00d5\13\7\3\7\3\7\5\7\u00d9\n\7\5\7\u00db\n\7\3\b\3\b\5\b\u00df"+
		"\n\b\3\t\3\t\3\t\3\t\7\t\u00e5\n\t\f\t\16\t\u00e8\13\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\u00f1\n\n\f\n\16\n\u00f4\13\n\3\n\3\n\5\n\u00f8\n\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u0100\n\13\3\f\5\f\u0103\n\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u010a\n\f\3\f\3\f\7\f\u010e\n\f\f\f\16\f\u0111\13\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u011c\n\r\3\r\3\r\3\r\3\r\3\16"+
		"\5\16\u0123\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u013e\n\16\f\16\16\16\u0141\13\16\3\16\3\16\5\16\u0145\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0150\n\17\3\20\5\20\u0153"+
		"\n\20\3\20\3\20\5\20\u0157\n\20\3\20\3\20\5\20\u015b\n\20\3\20\3\20\5"+
		"\20\u015f\n\20\3\20\3\20\3\20\5\20\u0164\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\7\20\u016b\n\20\f\20\16\20\u016e\13\20\5\20\u0170\n\20\3\20\3\20\3\20"+
		"\5\20\u0175\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u0185\n\20\f\20\16\20\u0188\13\20\3\20\3\20\5\20"+
		"\u018c\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0194\n\21\3\22\5\22\u0197"+
		"\n\22\3\22\3\22\5\22\u019b\n\22\3\22\3\22\5\22\u019f\n\22\3\22\5\22\u01a2"+
		"\n\22\3\22\5\22\u01a5\n\22\3\22\5\22\u01a8\n\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\5\22\u01b1\n\22\3\22\3\22\3\22\5\22\u01b6\n\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u01c2\n\22\3\22\5\22\u01c5"+
		"\n\22\6\22\u01c7\n\22\r\22\16\22\u01c8\3\22\5\22\u01cc\n\22\3\22\3\22"+
		"\3\22\3\22\7\22\u01d2\n\22\f\22\16\22\u01d5\13\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u01dd\n\22\3\22\3\22\3\22\7\22\u01e2\n\22\f\22\16\22\u01e5"+
		"\13\22\3\22\3\22\5\22\u01e9\n\22\3\22\3\22\3\23\5\23\u01ee\n\23\3\23\3"+
		"\23\5\23\u01f2\n\23\3\23\3\23\5\23\u01f6\n\23\3\23\5\23\u01f9\n\23\3\23"+
		"\5\23\u01fc\n\23\3\23\5\23\u01ff\n\23\3\23\3\23\3\23\3\23\3\23\3\23\5"+
		"\23\u0207\n\23\3\23\3\23\3\23\3\23\5\23\u020d\n\23\3\23\3\23\3\23\5\23"+
		"\u0212\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0220\n\23\3\23\5\23\u0223\n\23\6\23\u0225\n\23\r\23\16\23\u0226"+
		"\3\23\5\23\u022a\n\23\3\23\3\23\3\23\3\23\3\23\7\23\u0231\n\23\f\23\16"+
		"\23\u0234\13\23\3\23\3\23\5\23\u0238\n\23\3\23\3\23\3\23\7\23\u023d\n"+
		"\23\f\23\16\23\u0240\13\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0248\n"+
		"\23\3\23\3\23\3\23\7\23\u024d\n\23\f\23\16\23\u0250\13\23\3\23\3\23\5"+
		"\23\u0254\n\23\3\23\3\23\3\24\5\24\u0259\n\24\3\24\3\24\5\24\u025d\n\24"+
		"\3\24\3\24\5\24\u0261\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u026a"+
		"\n\24\f\24\16\24\u026d\13\24\5\24\u026f\n\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0277\n\24\5\24\u0279\n\24\3\24\3\24\3\24\3\24\3\24\3\24\7"+
		"\24\u0281\n\24\f\24\16\24\u0284\13\24\5\24\u0286\n\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\5\24\u028e\n\24\3\24\5\24\u0291\n\24\6\24\u0293\n\24\r\24"+
		"\16\24\u0294\3\24\5\24\u0298\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\7\24\u02a7\n\24\f\24\16\24\u02aa\13\24\3"+
		"\24\3\24\5\24\u02ae\n\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u02be\n\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u02c6\n\27\3\27\5\27\u02c9\n\27\6\27\u02cb\n\27\r\27\16\27\u02cc"+
		"\3\27\5\27\u02d0\n\27\3\27\3\27\7\27\u02d4\n\27\f\27\16\27\u02d7\13\27"+
		"\3\27\3\27\5\27\u02db\n\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u02e3\n"+
		"\30\3\30\5\30\u02e6\n\30\3\30\3\30\5\30\u02ea\n\30\3\30\3\30\3\30\3\31"+
		"\5\31\u02f0\n\31\3\31\3\31\5\31\u02f4\n\31\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u02fb\n\31\3\31\3\31\3\31\5\31\u0300\n\31\3\31\3\31\3\31\3\31\5\31"+
		"\u0306\n\31\3\31\5\31\u0309\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7"+
		"\31\u0312\n\31\f\31\16\31\u0315\13\31\3\31\3\31\5\31\u0319\n\31\3\31\3"+
		"\31\3\32\5\32\u031e\n\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0326\n\32"+
		"\3\32\3\32\3\32\5\32\u032b\n\32\3\32\3\32\3\32\3\32\5\32\u0331\n\32\3"+
		"\32\5\32\u0334\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u0340\n\32\f\32\16\32\u0343\13\32\3\32\3\32\5\32\u0347\n\32\3\32"+
		"\3\32\3\33\3\33\3\33\5\33\u034e\n\33\3\33\3\33\3\33\3\33\5\33\u0354\n"+
		"\33\3\33\3\33\3\33\7\33\u0359\n\33\f\33\16\33\u035c\13\33\3\33\3\33\3"+
		"\33\5\33\u0361\n\33\3\34\3\34\5\34\u0365\n\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\7\34\u036d\n\34\f\34\16\34\u0370\13\34\3\34\3\34\5\34\u0374\n\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\6\34\u0381\n\34"+
		"\r\34\16\34\u0382\3\34\3\34\3\34\5\34\u0388\n\34\3\35\5\35\u038b\n\35"+
		"\3\35\3\35\5\35\u038f\n\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u0399\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\5\37\u03a7\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u03b2\n \3!\3!\3!\3!\3"+
		"\"\3\"\3\"\3\"\7\"\u03bc\n\"\f\"\16\"\u03bf\13\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3#\3#\7#\u03ca\n#\f#\16#\u03cd\13#\5#\u03cf\n#\3#\3#\3$\3$\3$\3$\3$"+
		"\3$\5$\u03d9\n$\3%\3%\3%\3%\3%\7%\u03e0\n%\f%\16%\u03e3\13%\3%\3%\5%\u03e7"+
		"\n%\3&\3&\3&\3&\3&\3&\5&\u03ef\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u03f8"+
		"\n\'\3(\3(\3(\5(\u03fd\n(\3(\7(\u0400\n(\f(\16(\u0403\13(\3(\5(\u0406"+
		"\n(\3)\3)\5)\u040a\n)\3)\3)\3)\5)\u040f\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\5*\u041b\n*\3+\3+\5+\u041f\n+\3+\3+\3+\5+\u0424\n+\3+\3+\5+\u0428"+
		"\n+\3+\3+\3,\5,\u042d\n,\3,\3,\3,\3,\3,\3,\5,\u0435\n,\5,\u0437\n,\3,"+
		"\3,\3,\5,\u043c\n,\3,\3,\5,\u0440\n,\3,\3,\3-\3-\3-\3-\3-\5-\u0449\n-"+
		"\5-\u044b\n-\3-\3-\3-\5-\u0450\n-\3-\3-\5-\u0454\n-\3-\3-\3.\3.\3.\3."+
		"\3.\5.\u045d\n.\5.\u045f\n.\3.\3.\3.\5.\u0464\n.\3.\3.\5.\u0468\n.\3."+
		"\3.\3/\3/\5/\u046e\n/\3/\3/\3/\5/\u0473\n/\3/\3/\5/\u0477\n/\3/\3/\3\60"+
		"\3\60\5\60\u047d\n\60\3\60\3\60\3\60\5\60\u0482\n\60\3\60\3\60\5\60\u0486"+
		"\n\60\3\60\3\60\3\61\3\61\3\61\5\61\u048d\n\61\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\5\62\u04a4\n\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u04ac\n"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u04b4\n\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\5\62\u04bc\n\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u04c4\n"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u04cc\n\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\5\62\u04d4\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\5\62\u04ee\n\62\3\62\5\62\u04f1\n\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u050d\n\62\f\62\16\62\u0510\13"+
		"\62\3\62\5\62\u0513\n\62\3\62\3\62\7\62\u0517\n\62\f\62\16\62\u051a\13"+
		"\62\3\62\5\62\u051d\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62"+
		"\u0527\n\62\f\62\16\62\u052a\13\62\3\62\5\62\u052d\n\62\3\62\3\62\7\62"+
		"\u0531\n\62\f\62\16\62\u0534\13\62\3\62\5\62\u0537\n\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\7\62\u0541\n\62\f\62\16\62\u0544\13\62\3\62"+
		"\5\62\u0547\n\62\3\62\3\62\7\62\u054b\n\62\f\62\16\62\u054e\13\62\3\62"+
		"\5\62\u0551\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u055b\n"+
		"\62\f\62\16\62\u055e\13\62\3\62\5\62\u0561\n\62\3\62\3\62\7\62\u0565\n"+
		"\62\f\62\16\62\u0568\13\62\3\62\5\62\u056b\n\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\7\62\u0575\n\62\f\62\16\62\u0578\13\62\3\62\5\62\u057b"+
		"\n\62\3\62\3\62\7\62\u057f\n\62\f\62\16\62\u0582\13\62\3\62\5\62\u0585"+
		"\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u058f\n\62\f\62\16"+
		"\62\u0592\13\62\3\62\5\62\u0595\n\62\3\62\3\62\7\62\u0599\n\62\f\62\16"+
		"\62\u059c\13\62\3\62\5\62\u059f\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u05ac\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62"+
		"\u05c2\n\62\f\62\16\62\u05c5\13\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u05f3\n\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u060b\n\63\3\63\3\63\5\63\u060f\n"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\7\63\u061f\n\63\f\63\16\63\u0622\13\63\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0636"+
		"\n\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u063f\n\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\7\64\u065a\n\64\f\64\16\64\u065d"+
		"\13\64\3\65\3\65\3\65\7\65\u0662\n\65\f\65\16\65\u0665\13\65\3\66\5\66"+
		"\u0668\n\66\3\66\3\66\3\66\7\66\u066d\n\66\f\66\16\66\u0670\13\66\3\66"+
		"\3\66\5\66\u0674\n\66\3\66\3\66\3\66\3\66\5\66\u067a\n\66\3\66\3\66\3"+
		"\66\7\66\u067f\n\66\f\66\16\66\u0682\13\66\3\66\3\66\3\66\3\66\3\66\3"+
		"\66\5\66\u068a\n\66\3\66\3\66\3\66\7\66\u068f\n\66\f\66\16\66\u0692\13"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u069a\n\66\3\66\3\66\3\66\7\66"+
		"\u069f\n\66\f\66\16\66\u06a2\13\66\3\66\3\66\3\66\3\66\3\66\5\66\u06a9"+
		"\n\66\3\67\3\67\3\67\7\67\u06ae\n\67\f\67\16\67\u06b1\13\67\38\38\38\7"+
		"8\u06b6\n8\f8\168\u06b9\138\38\38\38\38\39\39\39\79\u06c2\n9\f9\169\u06c5"+
		"\139\3:\5:\u06c8\n:\3:\3:\3:\7:\u06cd\n:\f:\16:\u06d0\13:\3:\3:\5:\u06d4"+
		"\n:\3:\3:\3:\3:\3;\3;\3<\3<\3<\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\3>\5>\u070b\n>\3?\3?\3@\5@\u0710\n@\3@\5@\u0713"+
		"\n@\3@\5@\u0716\n@\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3F\2\5bd"+
		"fG\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD"+
		"FHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\2\26"+
		"\3\2\60\62\3\2\u008c\u008d\4\2\26\26@@\3\2LM\3\2NO\3\2YZ\3\2de\3\2fg\3"+
		"\2hj\3\2kl\3\2hi\4\2\61\61{{\4\2ss||\4\2\60\60}}\3\2~\177\3\2\u0080\u0081"+
		"\4\2VX\u0083\u0083\3\2op\4\2\61\61ss\4\2\60\60\u0088\u0088\u0850\2\u008c"+
		"\3\2\2\2\4\u00a4\3\2\2\2\6\u00a9\3\2\2\2\b\u00b1\3\2\2\2\n\u00ba\3\2\2"+
		"\2\f\u00cc\3\2\2\2\16\u00de\3\2\2\2\20\u00e0\3\2\2\2\22\u00f7\3\2\2\2"+
		"\24\u00ff\3\2\2\2\26\u0102\3\2\2\2\30\u0117\3\2\2\2\32\u0122\3\2\2\2\34"+
		"\u014f\3\2\2\2\36\u0152\3\2\2\2 \u0193\3\2\2\2\"\u0196\3\2\2\2$\u01ed"+
		"\3\2\2\2&\u0258\3\2\2\2(\u02b1\3\2\2\2*\u02b4\3\2\2\2,\u02b7\3\2\2\2."+
		"\u02de\3\2\2\2\60\u02ef\3\2\2\2\62\u031d\3\2\2\2\64\u034d\3\2\2\2\66\u0362"+
		"\3\2\2\28\u038a\3\2\2\2:\u0398\3\2\2\2<\u03a6\3\2\2\2>\u03b1\3\2\2\2@"+
		"\u03b3\3\2\2\2B\u03b7\3\2\2\2D\u03c2\3\2\2\2F\u03d8\3\2\2\2H\u03da\3\2"+
		"\2\2J\u03ee\3\2\2\2L\u03f0\3\2\2\2N\u03f9\3\2\2\2P\u0407\3\2\2\2R\u041a"+
		"\3\2\2\2T\u041c\3\2\2\2V\u042c\3\2\2\2X\u0443\3\2\2\2Z\u0457\3\2\2\2\\"+
		"\u046b\3\2\2\2^\u047a\3\2\2\2`\u048c\3\2\2\2b\u05ab\3\2\2\2d\u05f2\3\2"+
		"\2\2f\u063e\3\2\2\2h\u065e\3\2\2\2j\u06a8\3\2\2\2l\u06aa\3\2\2\2n\u06b2"+
		"\3\2\2\2p\u06be\3\2\2\2r\u06c7\3\2\2\2t\u06d9\3\2\2\2v\u06db\3\2\2\2x"+
		"\u06de\3\2\2\2z\u070a\3\2\2\2|\u070c\3\2\2\2~\u070f\3\2\2\2\u0080\u0719"+
		"\3\2\2\2\u0082\u071b\3\2\2\2\u0084\u071d\3\2\2\2\u0086\u071f\3\2\2\2\u0088"+
		"\u0721\3\2\2\2\u008a\u0723\3\2\2\2\u008c\u008d\7\3\2\2\u008d\u008e\7\4"+
		"\2\2\u008e\u0093\5\4\3\2\u008f\u0090\7\5\2\2\u0090\u0092\5\4\3\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\6\2\2\u0097"+
		"\3\3\2\2\2\u0098\u0099\7\7\2\2\u0099\u009a\7\b\2\2\u009a\u00a5\7\u0088"+
		"\2\2\u009b\u009c\7\t\2\2\u009c\u009d\7\b\2\2\u009d\u00a5\7\u0088\2\2\u009e"+
		"\u009f\7\n\2\2\u009f\u00a0\7\b\2\2\u00a0\u00a5\7\u0088\2\2\u00a1\u00a2"+
		"\7\13\2\2\u00a2\u00a3\7\b\2\2\u00a3\u00a5\7\u0088\2\2\u00a4\u0098\3\2"+
		"\2\2\u00a4\u009b\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a5"+
		"\5\3\2\2\2\u00a6\u00a8\5\30\r\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2"+
		"\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00af\5\b\5\2\u00ad\u00b0\5\n\6\2\u00ae\u00b0\7\f\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\7\3\2\2\2\u00b1\u00b5\7\r\2\2"+
		"\u00b2\u00b3\5z>\2\u00b3\u00b4\7\b\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b2"+
		"\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7\u008c\2"+
		"\2\u00b8\u00b9\7\f\2\2\u00b9\t\3\2\2\2\u00ba\u00bc\5N(\2\u00bb\u00bd\5"+
		"\24\13\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00ca\3\2\2\2\u00be"+
		"\u00bf\7\4\2\2\u00bf\u00c4\5\f\7\2\u00c0\u00c1\7\5\2\2\u00c1\u00c3\5\f"+
		"\7\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7\6"+
		"\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00cb\7\f\2\2\u00ca\u00be\3\2\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\13\3\2\2\2\u00cc\u00da\5z>\2\u00cd\u00d8\7\b\2\2"+
		"\u00ce\u00d9\5\16\b\2\u00cf\u00d3\7\4\2\2\u00d0\u00d2\5\n\6\2\u00d1\u00d0"+
		"\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\7\6\2\2\u00d7\u00d9\5\22"+
		"\n\2\u00d8\u00ce\3\2\2\2\u00d8\u00cf\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9"+
		"\u00db\3\2\2\2\u00da\u00cd\3\2\2\2\u00da\u00db\3\2\2\2\u00db\r\3\2\2\2"+
		"\u00dc\u00df\5\24\13\2\u00dd\u00df\5\20\t\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00dd\3\2\2\2\u00df\17\3\2\2\2\u00e0\u00e1\7\16\2\2\u00e1\u00e6\5\16"+
		"\b\2\u00e2\u00e3\7\5\2\2\u00e3\u00e5\5\16\b\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2"+
		"\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7\17\2\2\u00ea\21\3\2\2\2\u00eb\u00f8"+
		"\5N(\2\u00ec\u00ed\7\16\2\2\u00ed\u00f2\5N(\2\u00ee\u00ef\7\5\2\2\u00ef"+
		"\u00f1\5N(\2\u00f0\u00ee\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2"+
		"\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6"+
		"\7\17\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00eb\3\2\2\2\u00f7\u00ec\3\2\2\2"+
		"\u00f8\23\3\2\2\2\u00f9\u0100\5\u0086D\2\u00fa\u0100\5~@\2\u00fb\u0100"+
		"\5\u0080A\2\u00fc\u0100\5\u0082B\2\u00fd\u0100\5|?\2\u00fe\u0100\5\u0084"+
		"C\2\u00ff\u00f9\3\2\2\2\u00ff\u00fa\3\2\2\2\u00ff\u00fb\3\2\2\2\u00ff"+
		"\u00fc\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100\25\3\2\2"+
		"\2\u0101\u0103\5\2\2\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104"+
		"\3\2\2\2\u0104\u0109\b\f\1\2\u0105\u0106\7\r\2\2\u0106\u0107\5\u0086D"+
		"\2\u0107\u0108\7\f\2\2\u0108\u010a\3\2\2\2\u0109\u0105\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010f\b\f\1\2\u010c\u010e\5\30\r\2"+
		"\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110"+
		"\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\5\32\16\2"+
		"\u0113\u0114\b\f\1\2\u0114\u0115\3\2\2\2\u0115\u0116\b\f\1\2\u0116\27"+
		"\3\2\2\2\u0117\u011b\7\20\2\2\u0118\u0119\5\u0086D\2\u0119\u011a\7\b\2"+
		"\2\u011a\u011c\3\2\2\2\u011b\u0118\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011d\u011e\7\u008c\2\2\u011e\u011f\7\f\2\2\u011f\u0120\b\r\1"+
		"\2\u0120\31\3\2\2\2\u0121\u0123\5`\61\2\u0122\u0121\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\b\16\1\2\u0125\u0126\7\21\2\2"+
		"\u0126\u0127\5z>\2\u0127\u0128\b\16\1\2\u0128\u0129\b\16\1\2\u0129\u012a"+
		"\7\b\2\2\u012a\u012b\5\u0086D\2\u012b\u012c\3\2\2\2\u012c\u012d\7\22\2"+
		"\2\u012d\u012e\7\u008c\2\2\u012e\u012f\3\2\2\2\u012f\u0144\b\16\1\2\u0130"+
		"\u013f\7\4\2\2\u0131\u0132\5\66\34\2\u0132\u0133\b\16\1\2\u0133\u013e"+
		"\3\2\2\2\u0134\u0135\5\32\16\2\u0135\u0136\b\16\1\2\u0136\u013e\3\2\2"+
		"\2\u0137\u0138\5\34\17\2\u0138\u0139\b\16\1\2\u0139\u013e\3\2\2\2\u013a"+
		"\u013b\5V,\2\u013b\u013c\b\16\1\2\u013c\u013e\3\2\2\2\u013d\u0131\3\2"+
		"\2\2\u013d\u0134\3\2\2\2\u013d\u0137\3\2\2\2\u013d\u013a\3\2\2\2\u013e"+
		"\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2"+
		"\2\2\u0141\u013f\3\2\2\2\u0142\u0145\7\6\2\2\u0143\u0145\7\f\2\2\u0144"+
		"\u0130\3\2\2\2\u0144\u0143\3\2\2\2\u0145\33\3\2\2\2\u0146\u0147\5\36\20"+
		"\2\u0147\u0148\b\17\1\2\u0148\u0150\3\2\2\2\u0149\u014a\5\60\31\2\u014a"+
		"\u014b\b\17\1\2\u014b\u0150\3\2\2\2\u014c\u014d\5\62\32\2\u014d\u014e"+
		"\b\17\1\2\u014e\u0150\3\2\2\2\u014f\u0146\3\2\2\2\u014f\u0149\3\2\2\2"+
		"\u014f\u014c\3\2\2\2\u0150\35\3\2\2\2\u0151\u0153\5`\61\2\u0152\u0151"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u015a\b\20\1\2"+
		"\u0155\u0157\7\23\2\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158"+
		"\3\2\2\2\u0158\u015b\7\24\2\2\u0159\u015b\7\25\2\2\u015a\u0156\3\2\2\2"+
		"\u015a\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\b\20\1\2\u015d\u015f"+
		"\5z>\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u0161\b\20\1\2\u0161\u0163\b\20\1\2\u0162\u0164\5B\"\2\u0163\u0162\3"+
		"\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u016f\b\20\1\2\u0166"+
		"\u0167\7\26\2\2\u0167\u016c\5*\26\2\u0168\u0169\7\5\2\2\u0169\u016b\5"+
		"*\26\2\u016a\u0168\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0166\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0174\b\20\1\2\u0172"+
		"\u0173\7\b\2\2\u0173\u0175\7\u008c\2\2\u0174\u0172\3\2\2\2\u0174\u0175"+
		"\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u018b\b\20\1\2\u0177\u0186\7\4\2\2"+
		"\u0178\u0179\5\66\34\2\u0179\u017a\b\20\1\2\u017a\u0185\3\2\2\2\u017b"+
		"\u017c\5&\24\2\u017c\u017d\b\20\1\2\u017d\u0185\3\2\2\2\u017e\u017f\5"+
		" \21\2\u017f\u0180\b\20\1\2\u0180\u0185\3\2\2\2\u0181\u0182\5V,\2\u0182"+
		"\u0183\b\20\1\2\u0183\u0185\3\2\2\2\u0184\u0178\3\2\2\2\u0184\u017b\3"+
		"\2\2\2\u0184\u017e\3\2\2\2\u0184\u0181\3\2\2\2\u0185\u0188\3\2\2\2\u0186"+
		"\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u0186\3\2"+
		"\2\2\u0189\u018c\7\6\2\2\u018a\u018c\7\f\2\2\u018b\u0177\3\2\2\2\u018b"+
		"\u018a\3\2\2\2\u018c\37\3\2\2\2\u018d\u018e\5\"\22\2\u018e\u018f\b\21"+
		"\1\2\u018f\u0194\3\2\2\2\u0190\u0191\5$\23\2\u0191\u0192\b\21\1\2\u0192"+
		"\u0194\3\2\2\2\u0193\u018d\3\2\2\2\u0193\u0190\3\2\2\2\u0194!\3\2\2\2"+
		"\u0195\u0197\5`\61\2\u0196\u0195\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198"+
		"\3\2\2\2\u0198\u019a\b\22\1\2\u0199\u019b\7\27\2\2\u019a\u0199\3\2\2\2"+
		"\u019a\u019b\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019f\7\r\2\2\u019d\u019f"+
		"\7\30\2\2\u019e\u019c\3\2\2\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2"+
		"\u019f\u01a1\3\2\2\2\u01a0\u01a2\7\31\2\2\u01a1\u01a0\3\2\2\2\u01a1\u01a2"+
		"\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a5\7\32\2\2\u01a4\u01a3\3\2\2\2"+
		"\u01a4\u01a5\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a8\7\33\2\2\u01a7\u01a6"+
		"\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\7\34\2\2"+
		"\u01aa\u01ab\5z>\2\u01ab\u01ac\b\22\1\2\u01ac\u01ad\b\22\1\2\u01ad\u01ae"+
		"\7\b\2\2\u01ae\u01b0\5J&\2\u01af\u01b1\5.\30\2\u01b0\u01af\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b5\b\22\1\2\u01b3\u01b4\7"+
		"\22\2\2\u01b4\u01b6\7\u008c\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2"+
		"\2\u01b6\u01b7\3\2\2\2\u01b7\u01cb\b\22\1\2\u01b8\u01c6\7\4\2\2\u01b9"+
		"\u01c2\7\35\2\2\u01ba\u01c2\7\36\2\2\u01bb\u01c2\7\37\2\2\u01bc\u01c2"+
		"\7 \2\2\u01bd\u01c2\7!\2\2\u01be\u01c2\7\"\2\2\u01bf\u01c2\7#\2\2\u01c0"+
		"\u01c2\7$\2\2\u01c1\u01b9\3\2\2\2\u01c1\u01ba\3\2\2\2\u01c1\u01bb\3\2"+
		"\2\2\u01c1\u01bc\3\2\2\2\u01c1\u01bd\3\2\2\2\u01c1\u01be\3\2\2\2\u01c1"+
		"\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01c4\3\2\2\2\u01c3\u01c5\7\5"+
		"\2\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6"+
		"\u01c1\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2"+
		"\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\7\6\2\2\u01cb\u01b8\3\2\2\2\u01cb"+
		"\u01cc\3\2\2\2\u01cc\u01e8\3\2\2\2\u01cd\u01d3\7\4\2\2\u01ce\u01cf\5\66"+
		"\34\2\u01cf\u01d0\b\22\1\2\u01d0\u01d2\3\2\2\2\u01d1\u01ce\3\2\2\2\u01d2"+
		"\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01dc\3\2"+
		"\2\2\u01d5\u01d3\3\2\2\2\u01d6\u01d7\5^\60\2\u01d7\u01d8\b\22\1\2\u01d8"+
		"\u01dd\3\2\2\2\u01d9\u01da\5\\/\2\u01da\u01db\b\22\1\2\u01db\u01dd\3\2"+
		"\2\2\u01dc\u01d6\3\2\2\2\u01dc\u01d9\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd"+
		"\u01e3\3\2\2\2\u01de\u01df\5\66\34\2\u01df\u01e0\b\22\1\2\u01e0\u01e2"+
		"\3\2\2\2\u01e1\u01de\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\u01e6\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e9\7\6"+
		"\2\2\u01e7\u01e9\7\f\2\2\u01e8\u01cd\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01eb\b\22\1\2\u01eb#\3\2\2\2\u01ec\u01ee\5`\61\2"+
		"\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f1"+
		"\b\23\1\2\u01f0\u01f2\7\27\2\2\u01f1\u01f0\3\2\2\2\u01f1\u01f2\3\2\2\2"+
		"\u01f2\u01f5\3\2\2\2\u01f3\u01f6\7\r\2\2\u01f4\u01f6\7\30\2\2\u01f5\u01f3"+
		"\3\2\2\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8\3\2\2\2\u01f7"+
		"\u01f9\7\31\2\2\u01f8\u01f7\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\3"+
		"\2\2\2\u01fa\u01fc\7\32\2\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc"+
		"\u01fe\3\2\2\2\u01fd\u01ff\7\33\2\2\u01fe\u01fd\3\2\2\2\u01fe\u01ff\3"+
		"\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\7%\2\2\u0201\u0202\5z>\2\u0202"+
		"\u0203\b\23\1\2\u0203\u0206\b\23\1\2\u0204\u0205\7&\2\2\u0205\u0207\5"+
		"z>\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\3\2\2\2\u0208"+
		"\u0209\b\23\1\2\u0209\u020a\7\b\2\2\u020a\u020c\5J&\2\u020b\u020d\5.\30"+
		"\2\u020c\u020b\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0211"+
		"\b\23\1\2\u020f\u0210\7\22\2\2\u0210\u0212\7\u008c\2\2\u0211\u020f\3\2"+
		"\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0229\b\23\1\2\u0214"+
		"\u0224\7\4\2\2\u0215\u0220\7\'\2\2\u0216\u0220\7\35\2\2\u0217\u0220\7"+
		"\37\2\2\u0218\u0220\7 \2\2\u0219\u0220\7!\2\2\u021a\u0220\7\"\2\2\u021b"+
		"\u0220\7(\2\2\u021c\u0220\7)\2\2\u021d\u0220\7#\2\2\u021e\u0220\7$\2\2"+
		"\u021f\u0215\3\2\2\2\u021f\u0216\3\2\2\2\u021f\u0217\3\2\2\2\u021f\u0218"+
		"\3\2\2\2\u021f\u0219\3\2\2\2\u021f\u021a\3\2\2\2\u021f\u021b\3\2\2\2\u021f"+
		"\u021c\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u021e\3\2\2\2\u0220\u0222\3\2"+
		"\2\2\u0221\u0223\7\5\2\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2\2\2\u0223"+
		"\u0225\3\2\2\2\u0224\u021f\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0224\3\2"+
		"\2\2\u0226\u0227\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u022a\7\6\2\2\u0229"+
		"\u0214\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u0253\3\2\2\2\u022b\u0237\7\4"+
		"\2\2\u022c\u022d\7*\2\2\u022d\u0232\5z>\2\u022e\u022f\7\5\2\2\u022f\u0231"+
		"\5z>\2\u0230\u022e\3\2\2\2\u0231\u0234\3\2\2\2\u0232\u0230\3\2\2\2\u0232"+
		"\u0233\3\2\2\2\u0233\u0235\3\2\2\2\u0234\u0232\3\2\2\2\u0235\u0236\7\f"+
		"\2\2\u0236\u0238\3\2\2\2\u0237\u022c\3\2\2\2\u0237\u0238\3\2\2\2\u0238"+
		"\u023e\3\2\2\2\u0239\u023a\5\66\34\2\u023a\u023b\b\23\1\2\u023b\u023d"+
		"\3\2\2\2\u023c\u0239\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2\2\u023e"+
		"\u023f\3\2\2\2\u023f\u0247\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0242\5^"+
		"\60\2\u0242\u0243\b\23\1\2\u0243\u0248\3\2\2\2\u0244\u0245\5\\/\2\u0245"+
		"\u0246\b\23\1\2\u0246\u0248\3\2\2\2\u0247\u0241\3\2\2\2\u0247\u0244\3"+
		"\2\2\2\u0247\u0248\3\2\2\2\u0248\u024e\3\2\2\2\u0249\u024a\5\66\34\2\u024a"+
		"\u024b\b\23\1\2\u024b\u024d\3\2\2\2\u024c\u0249\3\2\2\2\u024d\u0250\3"+
		"\2\2\2\u024e\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0251\3\2\2\2\u0250"+
		"\u024e\3\2\2\2\u0251\u0254\7\6\2\2\u0252\u0254\7\f\2\2\u0253\u022b\3\2"+
		"\2\2\u0253\u0252\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0256\b\23\1\2\u0256"+
		"%\3\2\2\2\u0257\u0259\5`\61\2\u0258\u0257\3\2\2\2\u0258\u0259\3\2\2\2"+
		"\u0259\u025a\3\2\2\2\u025a\u025c\b\24\1\2\u025b\u025d\7\27\2\2\u025c\u025b"+
		"\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u0260\7+\2\2\u025f"+
		"\u0261\5B\"\2\u0260\u025f\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0262\3\2"+
		"\2\2\u0262\u0263\b\24\1\2\u0263\u0264\5z>\2\u0264\u0265\b\24\1\2\u0265"+
		"\u026e\7,\2\2\u0266\u026b\5,\27\2\u0267\u0268\7\5\2\2\u0268\u026a\5,\27"+
		"\2\u0269\u0267\3\2\2\2\u026a\u026d\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026c"+
		"\3\2\2\2\u026c\u026f\3\2\2\2\u026d\u026b\3\2\2\2\u026e\u0266\3\2\2\2\u026e"+
		"\u026f\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u0271\7-\2\2\u0271\u0272\3\2"+
		"\2\2\u0272\u0278\b\24\1\2\u0273\u0274\7\b\2\2\u0274\u0276\5J&\2\u0275"+
		"\u0277\5.\30\2\u0276\u0275\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0279\3\2"+
		"\2\2\u0278\u0273\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\3\2\2\2\u027a"+
		"\u027b\b\24\1\2\u027b\u0285\b\24\1\2\u027c\u027d\7.\2\2\u027d\u0282\5"+
		"(\25\2\u027e\u027f\7\5\2\2\u027f\u0281\5(\25\2\u0280\u027e\3\2\2\2\u0281"+
		"\u0284\3\2\2\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0286\3\2"+
		"\2\2\u0284\u0282\3\2\2\2\u0285\u027c\3\2\2\2\u0285\u0286\3\2\2\2\u0286"+
		"\u0287\3\2\2\2\u0287\u0297\b\24\1\2\u0288\u0292\7\4\2\2\u0289\u028e\7"+
		"\37\2\2\u028a\u028e\7 \2\2\u028b\u028e\7!\2\2\u028c\u028e\7\"\2\2\u028d"+
		"\u0289\3\2\2\2\u028d\u028a\3\2\2\2\u028d\u028b\3\2\2\2\u028d\u028c\3\2"+
		"\2\2\u028e\u0290\3\2\2\2\u028f\u0291\7\5\2\2\u0290\u028f\3\2\2\2\u0290"+
		"\u0291\3\2\2\2\u0291\u0293\3\2\2\2\u0292\u028d\3\2\2\2\u0293\u0294\3\2"+
		"\2\2\u0294\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0296\3\2\2\2\u0296"+
		"\u0298\7\6\2\2\u0297\u0288\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u02ad\3\2"+
		"\2\2\u0299\u02a8\7\4\2\2\u029a\u029b\5\66\34\2\u029b\u029c\b\24\1\2\u029c"+
		"\u02a7\3\2\2\2\u029d\u029e\5X-\2\u029e\u029f\b\24\1\2\u029f\u02a7\3\2"+
		"\2\2\u02a0\u02a1\5T+\2\u02a1\u02a2\b\24\1\2\u02a2\u02a7\3\2\2\2\u02a3"+
		"\u02a4\5Z.\2\u02a4\u02a5\b\24\1\2\u02a5\u02a7\3\2\2\2\u02a6\u029a\3\2"+
		"\2\2\u02a6\u029d\3\2\2\2\u02a6\u02a0\3\2\2\2\u02a6\u02a3\3\2\2\2\u02a7"+
		"\u02aa\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02ab\3\2"+
		"\2\2\u02aa\u02a8\3\2\2\2\u02ab\u02ae\7\6\2\2\u02ac\u02ae\7\f\2\2\u02ad"+
		"\u0299\3\2\2\2\u02ad\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b0\b\24"+
		"\1\2\u02b0\'\3\2\2\2\u02b1\u02b2\5H%\2\u02b2\u02b3\b\25\1\2\u02b3)\3\2"+
		"\2\2\u02b4\u02b5\5H%\2\u02b5\u02b6\b\26\1\2\u02b6+\3\2\2\2\u02b7\u02b8"+
		"\5z>\2\u02b8\u02b9\b\27\1\2\u02b9\u02ba\b\27\1\2\u02ba\u02bb\7\b\2\2\u02bb"+
		"\u02bd\5J&\2\u02bc\u02be\5.\30\2\u02bd\u02bc\3\2\2\2\u02bd\u02be\3\2\2"+
		"\2\u02be\u02bf\3\2\2\2\u02bf\u02cf\b\27\1\2\u02c0\u02ca\7\4\2\2\u02c1"+
		"\u02c6\7\37\2\2\u02c2\u02c6\7 \2\2\u02c3\u02c6\7!\2\2\u02c4\u02c6\7\""+
		"\2\2\u02c5\u02c1\3\2\2\2\u02c5\u02c2\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c5"+
		"\u02c4\3\2\2\2\u02c6\u02c8\3\2\2\2\u02c7\u02c9\7\5\2\2\u02c8\u02c7\3\2"+
		"\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02cb\3\2\2\2\u02ca\u02c5\3\2\2\2\u02cb"+
		"\u02cc\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02ce\3\2"+
		"\2\2\u02ce\u02d0\7\6\2\2\u02cf\u02c0\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0"+
		"\u02da\3\2\2\2\u02d1\u02d5\7\4\2\2\u02d2\u02d4\5\66\34\2\u02d3\u02d2\3"+
		"\2\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6"+
		"\u02d8\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d8\u02d9\b\27\1\2\u02d9\u02db\7"+
		"\6\2\2\u02da\u02d1\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc"+
		"\u02dd\b\27\1\2\u02dd-\3\2\2\2\u02de\u02e5\7\16\2\2\u02df\u02e2\5\u008a"+
		"F\2\u02e0\u02e1\7/\2\2\u02e1\u02e3\5\u0088E\2\u02e2\u02e0\3\2\2\2\u02e2"+
		"\u02e3\3\2\2\2\u02e3\u02e6\3\2\2\2\u02e4\u02e6\t\2\2\2\u02e5\u02df\3\2"+
		"\2\2\u02e5\u02e4\3\2\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02ea\7\63\2\2\u02e8"+
		"\u02ea\7\64\2\2\u02e9\u02e7\3\2\2\2\u02e9\u02e8\3\2\2\2\u02e9\u02ea\3"+
		"\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\7\17\2\2\u02ec\u02ed\b\30\1\2\u02ed"+
		"/\3\2\2\2\u02ee\u02f0\5`\61\2\u02ef\u02ee\3\2\2\2\u02ef\u02f0\3\2\2\2"+
		"\u02f0\u02f1\3\2\2\2\u02f1\u02f3\b\31\1\2\u02f2\u02f4\7\65\2\2\u02f3\u02f2"+
		"\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f6\7\66\2\2"+
		"\u02f6\u02f7\5z>\2\u02f7\u02f8\b\31\1\2\u02f8\u02fa\b\31\1\2\u02f9\u02fb"+
		"\5B\"\2\u02fa\u02f9\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc"+
		"\u02ff\b\31\1\2\u02fd\u02fe\7\b\2\2\u02fe\u0300\7\u008c\2\2\u02ff\u02fd"+
		"\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0308\b\31\1\2"+
		"\u0302\u0305\7\4\2\2\u0303\u0306\7\67\2\2\u0304\u0306\78\2\2\u0305\u0303"+
		"\3\2\2\2\u0305\u0304\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0307\3\2\2\2\u0307"+
		"\u0309\7\6\2\2\u0308\u0302\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u0318\3\2"+
		"\2\2\u030a\u0313\7\4\2\2\u030b\u030c\5\66\34\2\u030c\u030d\b\31\1\2\u030d"+
		"\u0312\3\2\2\2\u030e\u030f\5V,\2\u030f\u0310\b\31\1\2\u0310\u0312\3\2"+
		"\2\2\u0311\u030b\3\2\2\2\u0311\u030e\3\2\2\2\u0312\u0315\3\2\2\2\u0313"+
		"\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0316\3\2\2\2\u0315\u0313\3\2"+
		"\2\2\u0316\u0319\7\6\2\2\u0317\u0319\7\f\2\2\u0318\u030a\3\2\2\2\u0318"+
		"\u0317\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u031b\b\31\1\2\u031b\61\3\2\2"+
		"\2\u031c\u031e\5`\61\2\u031d\u031c\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u031f"+
		"\3\2\2\2\u031f\u0320\b\32\1\2\u0320\u0321\79\2\2\u0321\u0322\5z>\2\u0322"+
		"\u0323\b\32\1\2\u0323\u0325\b\32\1\2\u0324\u0326\5B\"\2\u0325\u0324\3"+
		"\2\2\2\u0325\u0326\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u032a\b\32\1\2\u0328"+
		"\u0329\7\b\2\2\u0329\u032b\7\u008c\2\2\u032a\u0328\3\2\2\2\u032a\u032b"+
		"\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u0333\b\32\1\2\u032d\u0330\7\4\2\2"+
		"\u032e\u0331\7\67\2\2\u032f\u0331\78\2\2\u0330\u032e\3\2\2\2\u0330\u032f"+
		"\3\2\2\2\u0330\u0331\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0334\7\6\2\2\u0333"+
		"\u032d\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u0346\3\2\2\2\u0335\u0341\7\4"+
		"\2\2\u0336\u0337\5\66\34\2\u0337\u0338\b\32\1\2\u0338\u0340\3\2\2\2\u0339"+
		"\u033a\5\64\33\2\u033a\u033b\b\32\1\2\u033b\u0340\3\2\2\2\u033c\u033d"+
		"\5V,\2\u033d\u033e\b\32\1\2\u033e\u0340\3\2\2\2\u033f\u0336\3\2\2\2\u033f"+
		"\u0339\3\2\2\2\u033f\u033c\3\2\2\2\u0340\u0343\3\2\2\2\u0341\u033f\3\2"+
		"\2\2\u0341\u0342\3\2\2\2\u0342\u0344\3\2\2\2\u0343\u0341\3\2\2\2\u0344"+
		"\u0347\7\6\2\2\u0345\u0347\7\f\2\2\u0346\u0335\3\2\2\2\u0346\u0345\3\2"+
		"\2\2\u0347\u0348\3\2\2\2\u0348\u0349\b\32\1\2\u0349\63\3\2\2\2\u034a\u034b"+
		"\7:\2\2\u034b\u034e\5z>\2\u034c\u034e\5z>\2\u034d\u034a\3\2\2\2\u034d"+
		"\u034c\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0350\b\33\1\2\u0350\u0353\b"+
		"\33\1\2\u0351\u0352\7\22\2\2\u0352\u0354\7\u0088\2\2\u0353\u0351\3\2\2"+
		"\2\u0353\u0354\3\2\2\2\u0354\u0355\3\2\2\2\u0355\u0360\b\33\1\2\u0356"+
		"\u035a\7\4\2\2\u0357\u0359\5\66\34\2\u0358\u0357\3\2\2\2\u0359\u035c\3"+
		"\2\2\2\u035a\u0358\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035d\3\2\2\2\u035c"+
		"\u035a\3\2\2\2\u035d\u035e\b\33\1\2\u035e\u0361\7\6\2\2\u035f\u0361\7"+
		"\f\2\2\u0360\u0356\3\2\2\2\u0360\u035f\3\2\2\2\u0361\65\3\2\2\2\u0362"+
		"\u0364\7;\2\2\u0363\u0365\7\u008c\2\2\u0364\u0363\3\2\2\2\u0364\u0365"+
		"\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0367\b\34\1\2\u0367\u0373\b\34\1\2"+
		"\u0368\u0369\7,\2\2\u0369\u036e\58\35\2\u036a\u036b\7\5\2\2\u036b\u036d"+
		"\58\35\2\u036c\u036a\3\2\2\2\u036d\u0370\3\2\2\2\u036e\u036c\3\2\2\2\u036e"+
		"\u036f\3\2\2\2\u036f\u0371\3\2\2\2\u0370\u036e\3\2\2\2\u0371\u0372\7-"+
		"\2\2\u0372\u0374\3\2\2\2\u0373\u0368\3\2\2\2\u0373\u0374\3\2\2\2\u0374"+
		"\u0375\3\2\2\2\u0375\u0387\b\34\1\2\u0376\u0380\7\4\2\2\u0377\u0378\5"+
		"\66\34\2\u0378\u0379\b\34\1\2\u0379\u0381\3\2\2\2\u037a\u037b\5:\36\2"+
		"\u037b\u037c\b\34\1\2\u037c\u0381\3\2\2\2\u037d\u037e\5@!\2\u037e\u037f"+
		"\b\34\1\2\u037f\u0381\3\2\2\2\u0380\u0377\3\2\2\2\u0380\u037a\3\2\2\2"+
		"\u0380\u037d\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u0380\3\2\2\2\u0382\u0383"+
		"\3\2\2\2\u0383\u0384\3\2\2\2\u0384\u0385\7\6\2\2\u0385\u0388\3\2\2\2\u0386"+
		"\u0388\7\f\2\2\u0387\u0376\3\2\2\2\u0387\u0386\3\2\2\2\u0388\67\3\2\2"+
		"\2\u0389\u038b\7\u008c\2\2\u038a\u0389\3\2\2\2\u038a\u038b\3\2\2\2\u038b"+
		"\u038c\3\2\2\2\u038c\u038e\7\22\2\2\u038d\u038f\t\3\2\2\u038e\u038d\3"+
		"\2\2\2\u038e\u038f\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u0391\b\35\1\2\u0391"+
		"9\3\2\2\2\u0392\u0393\5\66\34\2\u0393\u0394\b\36\1\2\u0394\u0399\3\2\2"+
		"\2\u0395\u0396\5<\37\2\u0396\u0397\b\36\1\2\u0397\u0399\3\2\2\2\u0398"+
		"\u0392\3\2\2\2\u0398\u0395\3\2\2\2\u0399;\3\2\2\2\u039a\u039b\5> \2\u039b"+
		"\u039c\b\37\1\2\u039c\u03a7\3\2\2\2\u039d\u039e\5\34\17\2\u039e\u039f"+
		"\b\37\1\2\u039f\u03a7\3\2\2\2\u03a0\u03a1\5\32\16\2\u03a1\u03a2\b\37\1"+
		"\2\u03a2\u03a7\3\2\2\2\u03a3\u03a4\5\64\33\2\u03a4\u03a5\b\37\1\2\u03a5"+
		"\u03a7\3\2\2\2\u03a6\u039a\3\2\2\2\u03a6\u039d\3\2\2\2\u03a6\u03a0\3\2"+
		"\2\2\u03a6\u03a3\3\2\2\2\u03a7=\3\2\2\2\u03a8\u03a9\5&\24\2\u03a9\u03aa"+
		"\b \1\2\u03aa\u03b2\3\2\2\2\u03ab\u03ac\5,\27\2\u03ac\u03ad\b \1\2\u03ad"+
		"\u03b2\3\2\2\2\u03ae\u03af\5 \21\2\u03af\u03b0\b \1\2\u03b0\u03b2\3\2"+
		"\2\2\u03b1\u03a8\3\2\2\2\u03b1\u03ab\3\2\2\2\u03b1\u03ae\3\2\2\2\u03b2"+
		"?\3\2\2\2\u03b3\u03b4\7<\2\2\u03b4\u03b5\5N(\2\u03b5\u03b6\7\f\2\2\u03b6"+
		"A\3\2\2\2\u03b7\u03b8\7=\2\2\u03b8\u03bd\5D#\2\u03b9\u03ba\7\5\2\2\u03ba"+
		"\u03bc\5D#\2\u03bb\u03b9\3\2\2\2\u03bc\u03bf\3\2\2\2\u03bd\u03bb\3\2\2"+
		"\2\u03bd\u03be\3\2\2\2\u03be\u03c0\3\2\2\2\u03bf\u03bd\3\2\2\2\u03c0\u03c1"+
		"\7>\2\2\u03c1C\3\2\2\2\u03c2\u03c3\5z>\2\u03c3\u03c4\b#\1\2\u03c4\u03ce"+
		"\b#\1\2\u03c5\u03c6\7\26\2\2\u03c6\u03cb\5H%\2\u03c7\u03c8\7?\2\2\u03c8"+
		"\u03ca\5H%\2\u03c9\u03c7\3\2\2\2\u03ca\u03cd\3\2\2\2\u03cb\u03c9\3\2\2"+
		"\2\u03cb\u03cc\3\2\2\2\u03cc\u03cf\3\2\2\2\u03cd\u03cb\3\2\2\2\u03ce\u03c5"+
		"\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03d1\b#\1\2\u03d1"+
		"E\3\2\2\2\u03d2\u03d3\5H%\2\u03d3\u03d4\b$\1\2\u03d4\u03d9\3\2\2\2\u03d5"+
		"\u03d6\5L\'\2\u03d6\u03d7\b$\1\2\u03d7\u03d9\3\2\2\2\u03d8\u03d2\3\2\2"+
		"\2\u03d8\u03d5\3\2\2\2\u03d9G\3\2\2\2\u03da\u03e6\5N(\2\u03db\u03dc\7"+
		"=\2\2\u03dc\u03e1\5F$\2\u03dd\u03de\7\5\2\2\u03de\u03e0\5F$\2\u03df\u03dd"+
		"\3\2\2\2\u03e0\u03e3\3\2\2\2\u03e1\u03df\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2"+
		"\u03e4\3\2\2\2\u03e3\u03e1\3\2\2\2\u03e4\u03e5\7>\2\2\u03e5\u03e7\3\2"+
		"\2\2\u03e6\u03db\3\2\2\2\u03e6\u03e7\3\2\2\2\u03e7I\3\2\2\2\u03e8\u03e9"+
		"\5R*\2\u03e9\u03ea\b&\1\2\u03ea\u03ef\3\2\2\2\u03eb\u03ec\5H%\2\u03ec"+
		"\u03ed\b&\1\2\u03ed\u03ef\3\2\2\2\u03ee\u03e8\3\2\2\2\u03ee\u03eb\3\2"+
		"\2\2\u03efK\3\2\2\2\u03f0\u03f1\7\62\2\2\u03f1\u03f7\b\'\1\2\u03f2\u03f3"+
		"\t\4\2\2\u03f3\u03f4\b\'\1\2\u03f4\u03f5\5H%\2\u03f5\u03f6\b\'\1\2\u03f6"+
		"\u03f8\3\2\2\2\u03f7\u03f2\3\2\2\2\u03f7\u03f8\3\2\2\2\u03f8M\3\2\2\2"+
		"\u03f9\u03fc\5z>\2\u03fa\u03fb\7A\2\2\u03fb\u03fd\7\u0088\2\2\u03fc\u03fa"+
		"\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd\u0405\3\2\2\2\u03fe\u0400\5P)\2\u03ff"+
		"\u03fe\3\2\2\2\u0400\u0403\3\2\2\2\u0401\u03ff\3\2\2\2\u0401\u0402\3\2"+
		"\2\2\u0402\u0404\3\2\2\2\u0403\u0401\3\2\2\2\u0404\u0406\5P)\2\u0405\u0401"+
		"\3\2\2\2\u0405\u0406\3\2\2\2\u0406O\3\2\2\2\u0407\u0409\7B\2\2\u0408\u040a"+
		"\7C\2\2\u0409\u0408\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u040b\3\2\2\2\u040b"+
		"\u040e\5z>\2\u040c\u040d\7A\2\2\u040d\u040f\7\u0088\2\2\u040e\u040c\3"+
		"\2\2\2\u040e\u040f\3\2\2\2\u040fQ\3\2\2\2\u0410\u0411\7D\2\2\u0411\u041b"+
		"\b*\1\2\u0412\u0413\7E\2\2\u0413\u041b\b*\1\2\u0414\u0415\7F\2\2\u0415"+
		"\u041b\b*\1\2\u0416\u0417\7G\2\2\u0417\u041b\b*\1\2\u0418\u0419\7H\2\2"+
		"\u0419\u041b\b*\1\2\u041a\u0410\3\2\2\2\u041a\u0412\3\2\2\2\u041a\u0414"+
		"\3\2\2\2\u041a\u0416\3\2\2\2\u041a\u0418\3\2\2\2\u041bS\3\2\2\2\u041c"+
		"\u041e\7I\2\2\u041d\u041f\5\u0086D\2\u041e\u041d\3\2\2\2\u041e\u041f\3"+
		"\2\2\2\u041f\u0420\3\2\2\2\u0420\u0427\b+\1\2\u0421\u0423\7\b\2\2\u0422"+
		"\u0424\5d\63\2\u0423\u0422\3\2\2\2\u0423\u0424\3\2\2\2\u0424\u0425\3\2"+
		"\2\2\u0425\u0428\7\f\2\2\u0426\u0428\7\f\2\2\u0427\u0421\3\2\2\2\u0427"+
		"\u0426\3\2\2\2\u0428\u0429\3\2\2\2\u0429\u042a\b+\1\2\u042aU\3\2\2\2\u042b"+
		"\u042d\7J\2\2\u042c\u042b\3\2\2\2\u042c\u042d\3\2\2\2\u042d\u042e\3\2"+
		"\2\2\u042e\u042f\b,\1\2\u042f\u0436\7K\2\2\u0430\u0434\5\u0086D\2\u0431"+
		"\u0432\7,\2\2\u0432\u0433\7\u008b\2\2\u0433\u0435\7-\2\2\u0434\u0431\3"+
		"\2\2\2\u0434\u0435\3\2\2\2\u0435\u0437\3\2\2\2\u0436\u0430\3\2\2\2\u0436"+
		"\u0437\3\2\2\2\u0437\u0438\3\2\2\2\u0438\u043f\b,\1\2\u0439\u043b\7\b"+
		"\2\2\u043a\u043c\5b\62\2\u043b\u043a\3\2\2\2\u043b\u043c\3\2\2\2\u043c"+
		"\u043d\3\2\2\2\u043d\u0440\7\f\2\2\u043e\u0440\7\f\2\2\u043f\u0439\3\2"+
		"\2\2\u043f\u043e\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u0442\b,\1\2\u0442"+
		"W\3\2\2\2\u0443\u044a\t\5\2\2\u0444\u0448\5\u0086D\2\u0445\u0446\7,\2"+
		"\2\u0446\u0447\7\u008b\2\2\u0447\u0449\7-\2\2\u0448\u0445\3\2\2\2\u0448"+
		"\u0449\3\2\2\2\u0449\u044b\3\2\2\2\u044a\u0444\3\2\2\2\u044a\u044b\3\2"+
		"\2\2\u044b\u044c\3\2\2\2\u044c\u0453\b-\1\2\u044d\u044f\7\b\2\2\u044e"+
		"\u0450\5b\62\2\u044f\u044e\3\2\2\2\u044f\u0450\3\2\2\2\u0450\u0451\3\2"+
		"\2\2\u0451\u0454\7\f\2\2\u0452\u0454\7\f\2\2\u0453\u044d\3\2\2\2\u0453"+
		"\u0452\3\2\2\2\u0454\u0455\3\2\2\2\u0455\u0456\b-\1\2\u0456Y\3\2\2\2\u0457"+
		"\u045e\t\6\2\2\u0458\u045c\5\u0086D\2\u0459\u045a\7,\2\2\u045a\u045b\7"+
		"\u008b\2\2\u045b\u045d\7-\2\2\u045c\u0459\3\2\2\2\u045c\u045d\3\2\2\2"+
		"\u045d\u045f\3\2\2\2\u045e\u0458\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0460"+
		"\3\2\2\2\u0460\u0467\b.\1\2\u0461\u0463\7\b\2\2\u0462\u0464\5b\62\2\u0463"+
		"\u0462\3\2\2\2\u0463\u0464\3\2\2\2\u0464\u0465\3\2\2\2\u0465\u0468\7\f"+
		"\2\2\u0466\u0468\7\f\2\2\u0467\u0461\3\2\2\2\u0467\u0466\3\2\2\2\u0468"+
		"\u0469\3\2\2\2\u0469\u046a\b.\1\2\u046a[\3\2\2\2\u046b\u046d\7P\2\2\u046c"+
		"\u046e\5\u0086D\2\u046d\u046c\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u046f"+
		"\3\2\2\2\u046f\u0476\b/\1\2\u0470\u0472\7\b\2\2\u0471\u0473\5d\63\2\u0472"+
		"\u0471\3\2\2\2\u0472\u0473\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u0477\7\f"+
		"\2\2\u0475\u0477\7\f\2\2\u0476\u0470\3\2\2\2\u0476\u0475\3\2\2\2\u0477"+
		"\u0478\3\2\2\2\u0478\u0479\b/\1\2\u0479]\3\2\2\2\u047a\u047c\7Q\2\2\u047b"+
		"\u047d\5\u0086D\2\u047c\u047b\3\2\2\2\u047c\u047d\3\2\2\2\u047d\u047e"+
		"\3\2\2\2\u047e\u0485\b\60\1\2\u047f\u0481\7\b\2\2\u0480\u0482\5d\63\2"+
		"\u0481\u0480\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u0486"+
		"\7\f\2\2\u0484\u0486\7\f\2\2\u0485\u047f\3\2\2\2\u0485\u0484\3\2\2\2\u0486"+
		"\u0487\3\2\2\2\u0487\u0488\b\60\1\2\u0488_\3\2\2\2\u0489\u048d\7R\2\2"+
		"\u048a\u048d\7S\2\2\u048b\u048d\7T\2\2\u048c\u0489\3\2\2\2\u048c\u048a"+
		"\3\2\2\2\u048c\u048b\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u048f\b\61\1\2"+
		"\u048fa\3\2\2\2\u0490\u0491\b\62\1\2\u0491\u0492\7U\2\2\u0492\u0493\5"+
		"d\63\2\u0493\u0494\b\62\1\2\u0494\u05ac\3\2\2\2\u0495\u0496\7V\2\2\u0496"+
		"\u0497\5d\63\2\u0497\u0498\b\62\1\2\u0498\u05ac\3\2\2\2\u0499\u049a\7"+
		"W\2\2\u049a\u049b\5d\63\2\u049b\u049c\b\62\1\2\u049c\u05ac\3\2\2\2\u049d"+
		"\u049e\7X\2\2\u049e\u049f\5d\63\2\u049f\u04a0\b\62\1\2\u04a0\u05ac\3\2"+
		"\2\2\u04a1\u04a3\5d\63\2\u04a2\u04a4\t\7\2\2\u04a3\u04a2\3\2\2\2\u04a3"+
		"\u04a4\3\2\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04a6\7[\2\2\u04a6\u04a7\5d\63"+
		"\2\u04a7\u04a8\b\62\1\2\u04a8\u05ac\3\2\2\2\u04a9\u04ab\5d\63\2\u04aa"+
		"\u04ac\t\7\2\2\u04ab\u04aa\3\2\2\2\u04ab\u04ac\3\2\2\2\u04ac\u04ad\3\2"+
		"\2\2\u04ad\u04ae\7\22\2\2\u04ae\u04af\5d\63\2\u04af\u04b0\b\62\1\2\u04b0"+
		"\u05ac\3\2\2\2\u04b1\u04b3\5f\64\2\u04b2\u04b4\t\7\2\2\u04b3\u04b2\3\2"+
		"\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5\u04b6\7\22\2\2\u04b6"+
		"\u04b7\5f\64\2\u04b7\u04b8\b\62\1\2\u04b8\u05ac\3\2\2\2\u04b9\u04bb\5"+
		"f\64\2\u04ba\u04bc\t\7\2\2\u04bb\u04ba\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc"+
		"\u04bd\3\2\2\2\u04bd\u04be\7=\2\2\u04be\u04bf\5f\64\2\u04bf\u04c0\b\62"+
		"\1\2\u04c0\u05ac\3\2\2\2\u04c1\u04c3\5f\64\2\u04c2\u04c4\t\7\2\2\u04c3"+
		"\u04c2\3\2\2\2\u04c3\u04c4\3\2\2\2\u04c4\u04c5\3\2\2\2\u04c5\u04c6\7\\"+
		"\2\2\u04c6\u04c7\5f\64\2\u04c7\u04c8\b\62\1\2\u04c8\u05ac\3\2\2\2\u04c9"+
		"\u04cb\5f\64\2\u04ca\u04cc\t\7\2\2\u04cb\u04ca\3\2\2\2\u04cb\u04cc\3\2"+
		"\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04ce\7>\2\2\u04ce\u04cf\5f\64\2\u04cf"+
		"\u04d0\b\62\1\2\u04d0\u05ac\3\2\2\2\u04d1\u04d3\5f\64\2\u04d2\u04d4\t"+
		"\7\2\2\u04d3\u04d2\3\2\2\2\u04d3\u04d4\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5"+
		"\u04d6\7]\2\2\u04d6\u04d7\5f\64\2\u04d7\u04d8\b\62\1\2\u04d8\u05ac\3\2"+
		"\2\2\u04d9\u04da\7^\2\2\u04da\u04db\5h\65\2\u04db\u04dc\7_\2\2\u04dc\u04dd"+
		"\5f\64\2\u04dd\u04de\3\2\2\2\u04de\u04df\b\62\1\2\u04df\u05ac\3\2\2\2"+
		"\u04e0\u04e1\7`\2\2\u04e1\u04e2\7\16\2\2\u04e2\u04e3\5t;\2\u04e3\u04e4"+
		"\7\17\2\2\u04e4\u04e5\b\62\1\2\u04e5\u05ac\3\2\2\2\u04e6\u04e7\7a\2\2"+
		"\u04e7\u04e8\7\16\2\2\u04e8\u04e9\5t;\2\u04e9\u04ea\7\b\2\2\u04ea\u04eb"+
		"\5d\63\2\u04eb\u04f0\7b\2\2\u04ec\u04ee\7W\2\2\u04ed\u04ec\3\2\2\2\u04ed"+
		"\u04ee\3\2\2\2\u04ee\u04f1\3\2\2\2\u04ef\u04f1\7V\2\2\u04f0\u04ed\3\2"+
		"\2\2\u04f0\u04ef\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2\u04f3\5d\63\2\u04f3"+
		"\u04f4\7\17\2\2\u04f4\u04f5\b\62\1\2\u04f5\u05ac\3\2\2\2\u04f6\u04f7\7"+
		"c\2\2\u04f7\u04f8\7\16\2\2\u04f8\u04f9\5t;\2\u04f9\u04fa\7\5\2\2\u04fa"+
		"\u04fb\5t;\2\u04fb\u04fc\7\5\2\2\u04fc\u04fd\5t;\2\u04fd\u04fe\7\5\2\2"+
		"\u04fe\u04ff\5t;\2\u04ff\u0500\7\17\2\2\u0500\u0501\b\62\1\2\u0501\u05ac"+
		"\3\2\2\2\u0502\u0503\t\7\2\2\u0503\u0504\5b\62\20\u0504\u0505\b\62\1\2"+
		"\u0505\u05ac\3\2\2\2\u0506\u0507\7m\2\2\u0507\u051c\5h\65\2\u0508\u0512"+
		"\7_\2\2\u0509\u0513\5b\62\2\u050a\u050e\7\4\2\2\u050b\u050d\5b\62\2\u050c"+
		"\u050b\3\2\2\2\u050d\u0510\3\2\2\2\u050e\u050c\3\2\2\2\u050e\u050f\3\2"+
		"\2\2\u050f\u0511\3\2\2\2\u0510\u050e\3\2\2\2\u0511\u0513\7\6\2\2\u0512"+
		"\u0509\3\2\2\2\u0512\u050a\3\2\2\2\u0513\u051d\3\2\2\2\u0514\u0518\7\4"+
		"\2\2\u0515\u0517\5b\62\2\u0516\u0515\3\2\2\2\u0517\u051a\3\2\2\2\u0518"+
		"\u0516\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u051b\3\2\2\2\u051a\u0518\3\2"+
		"\2\2\u051b\u051d\7\6\2\2\u051c\u0508\3\2\2\2\u051c\u0514\3\2\2\2\u051d"+
		"\u051e\3\2\2\2\u051e\u051f\b\62\1\2\u051f\u05ac\3\2\2\2\u0520\u0521\7"+
		"X\2\2\u0521\u0536\5h\65\2\u0522\u052c\7_\2\2\u0523\u052d\5b\62\2\u0524"+
		"\u0528\7\4\2\2\u0525\u0527\5b\62\2\u0526\u0525\3\2\2\2\u0527\u052a\3\2"+
		"\2\2\u0528\u0526\3\2\2\2\u0528\u0529\3\2\2\2\u0529\u052b\3\2\2\2\u052a"+
		"\u0528\3\2\2\2\u052b\u052d\7\6\2\2\u052c\u0523\3\2\2\2\u052c\u0524\3\2"+
		"\2\2\u052d\u0537\3\2\2\2\u052e\u0532\7\4\2\2\u052f\u0531\5b\62\2\u0530"+
		"\u052f\3\2\2\2\u0531\u0534\3\2\2\2\u0532\u0530\3\2\2\2\u0532\u0533\3\2"+
		"\2\2\u0533\u0535\3\2\2\2\u0534\u0532\3\2\2\2\u0535\u0537\7\6\2\2\u0536"+
		"\u0522\3\2\2\2\u0536\u052e\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u0539\b\62"+
		"\1\2\u0539\u05ac\3\2\2\2\u053a\u053b\7U\2\2\u053b\u0550\5h\65\2\u053c"+
		"\u0546\7_\2\2\u053d\u0547\5b\62\2\u053e\u0542\7\4\2\2\u053f\u0541\5b\62"+
		"\2\u0540\u053f\3\2\2\2\u0541\u0544\3\2\2\2\u0542\u0540\3\2\2\2\u0542\u0543"+
		"\3\2\2\2\u0543\u0545\3\2\2\2\u0544\u0542\3\2\2\2\u0545\u0547\7\6\2\2\u0546"+
		"\u053d\3\2\2\2\u0546\u053e\3\2\2\2\u0547\u0551\3\2\2\2\u0548\u054c\7\4"+
		"\2\2\u0549\u054b\5b\62\2\u054a\u0549\3\2\2\2\u054b\u054e\3\2\2\2\u054c"+
		"\u054a\3\2\2\2\u054c\u054d\3\2\2\2\u054d\u054f\3\2\2\2\u054e\u054c\3\2"+
		"\2\2\u054f\u0551\7\6\2\2\u0550\u053c\3\2\2\2\u0550\u0548\3\2\2\2\u0551"+
		"\u0552\3\2\2\2\u0552\u0553\b\62\1\2\u0553\u05ac\3\2\2\2\u0554\u0555\7"+
		"W\2\2\u0555\u056a\5h\65\2\u0556\u0560\7_\2\2\u0557\u0561\5b\62\2\u0558"+
		"\u055c\7\4\2\2\u0559\u055b\5b\62\2\u055a\u0559\3\2\2\2\u055b\u055e\3\2"+
		"\2\2\u055c\u055a\3\2\2\2\u055c\u055d\3\2\2\2\u055d\u055f\3\2\2\2\u055e"+
		"\u055c\3\2\2\2\u055f\u0561\7\6\2\2\u0560\u0557\3\2\2\2\u0560\u0558\3\2"+
		"\2\2\u0561\u056b\3\2\2\2\u0562\u0566\7\4\2\2\u0563\u0565\5b\62\2\u0564"+
		"\u0563\3\2\2\2\u0565\u0568\3\2\2\2\u0566\u0564\3\2\2\2\u0566\u0567\3\2"+
		"\2\2\u0567\u0569\3\2\2\2\u0568\u0566\3\2\2\2\u0569\u056b\7\6\2\2\u056a"+
		"\u0556\3\2\2\2\u056a\u0562\3\2\2\2\u056b\u056c\3\2\2\2\u056c\u056d\b\62"+
		"\1\2\u056d\u05ac\3\2\2\2\u056e\u056f\7V\2\2\u056f\u0584\5h\65\2\u0570"+
		"\u057a\7_\2\2\u0571\u057b\5b\62\2\u0572\u0576\7\4\2\2\u0573\u0575\5b\62"+
		"\2\u0574\u0573\3\2\2\2\u0575\u0578\3\2\2\2\u0576\u0574\3\2\2\2\u0576\u0577"+
		"\3\2\2\2\u0577\u0579\3\2\2\2\u0578\u0576\3\2\2\2\u0579\u057b\7\6\2\2\u057a"+
		"\u0571\3\2\2\2\u057a\u0572\3\2\2\2\u057b\u0585\3\2\2\2\u057c\u0580\7\4"+
		"\2\2\u057d\u057f\5b\62\2\u057e\u057d\3\2\2\2\u057f\u0582\3\2\2\2\u0580"+
		"\u057e\3\2\2\2\u0580\u0581\3\2\2\2\u0581\u0583\3\2\2\2\u0582\u0580\3\2"+
		"\2\2\u0583\u0585\7\6\2\2\u0584\u0570\3\2\2\2\u0584\u057c\3\2\2\2\u0585"+
		"\u0586\3\2\2\2\u0586\u0587\b\62\1\2\u0587\u05ac\3\2\2\2\u0588\u0589\7"+
		"n\2\2\u0589\u059e\5l\67\2\u058a\u0594\7_\2\2\u058b\u0595\5b\62\2\u058c"+
		"\u0590\7\4\2\2\u058d\u058f\5b\62\2\u058e\u058d\3\2\2\2\u058f\u0592\3\2"+
		"\2\2\u0590\u058e\3\2\2\2\u0590\u0591\3\2\2\2\u0591\u0593\3\2\2\2\u0592"+
		"\u0590\3\2\2\2\u0593\u0595\7\6\2\2\u0594\u058b\3\2\2\2\u0594\u058c\3\2"+
		"\2\2\u0595\u059f\3\2\2\2\u0596\u059a\7\4\2\2\u0597\u0599\5b\62\2\u0598"+
		"\u0597\3\2\2\2\u0599\u059c\3\2\2\2\u059a\u0598\3\2\2\2\u059a\u059b\3\2"+
		"\2\2\u059b\u059d\3\2\2\2\u059c\u059a\3\2\2\2\u059d\u059f\7\6\2\2\u059e"+
		"\u058a\3\2\2\2\u059e\u0596\3\2\2\2\u059f\u05a0\3\2\2\2\u05a0\u05a1\b\62"+
		"\1\2\u05a1\u05ac\3\2\2\2\u05a2\u05a3\7o\2\2\u05a3\u05ac\b\62\1\2\u05a4"+
		"\u05a5\7p\2\2\u05a5\u05ac\b\62\1\2\u05a6\u05a7\7,\2\2\u05a7\u05a8\5b\62"+
		"\2\u05a8\u05a9\7-\2\2\u05a9\u05aa\b\62\1\2\u05aa\u05ac\3\2\2\2\u05ab\u0490"+
		"\3\2\2\2\u05ab\u0495\3\2\2\2\u05ab\u0499\3\2\2\2\u05ab\u049d\3\2\2\2\u05ab"+
		"\u04a1\3\2\2\2\u05ab\u04a9\3\2\2\2\u05ab\u04b1\3\2\2\2\u05ab\u04b9\3\2"+
		"\2\2\u05ab\u04c1\3\2\2\2\u05ab\u04c9\3\2\2\2\u05ab\u04d1\3\2\2\2\u05ab"+
		"\u04d9\3\2\2\2\u05ab\u04e0\3\2\2\2\u05ab\u04e6\3\2\2\2\u05ab\u04f6\3\2"+
		"\2\2\u05ab\u0502\3\2\2\2\u05ab\u0506\3\2\2\2\u05ab\u0520\3\2\2\2\u05ab"+
		"\u053a\3\2\2\2\u05ab\u0554\3\2\2\2\u05ab\u056e\3\2\2\2\u05ab\u0588\3\2"+
		"\2\2\u05ab\u05a2\3\2\2\2\u05ab\u05a4\3\2\2\2\u05ab\u05a6\3\2\2\2\u05ac"+
		"\u05c3\3\2\2\2\u05ad\u05ae\f\17\2\2\u05ae\u05af\t\b\2\2\u05af\u05b0\5"+
		"b\62\20\u05b0\u05b1\b\62\1\2\u05b1\u05c2\3\2\2\2\u05b2\u05b3\f\16\2\2"+
		"\u05b3\u05b4\t\t\2\2\u05b4\u05b5\5b\62\17\u05b5\u05b6\b\62\1\2\u05b6\u05c2"+
		"\3\2\2\2\u05b7\u05b8\f\r\2\2\u05b8\u05b9\t\n\2\2\u05b9\u05ba\5b\62\r\u05ba"+
		"\u05bb\b\62\1\2\u05bb\u05c2\3\2\2\2\u05bc\u05bd\f\f\2\2\u05bd\u05be\t"+
		"\13\2\2\u05be\u05bf\5b\62\f\u05bf\u05c0\b\62\1\2\u05c0\u05c2\3\2\2\2\u05c1"+
		"\u05ad\3\2\2\2\u05c1\u05b2\3\2\2\2\u05c1\u05b7\3\2\2\2\u05c1\u05bc\3\2"+
		"\2\2\u05c2\u05c5\3\2\2\2\u05c3\u05c1\3\2\2\2\u05c3\u05c4\3\2\2\2\u05c4"+
		"c\3\2\2\2\u05c5\u05c3\3\2\2\2\u05c6\u05c7\b\63\1\2\u05c7\u05c8\7q\2\2"+
		"\u05c8\u05c9\5d\63\24\u05c9\u05ca\b\63\1\2\u05ca\u05f3\3\2\2\2\u05cb\u05cc"+
		"\7r\2\2\u05cc\u05cd\5d\63\23\u05cd\u05ce\b\63\1\2\u05ce\u05f3\3\2\2\2"+
		"\u05cf\u05d0\7\60\2\2\u05d0\u05d1\5d\63\22\u05d1\u05d2\b\63\1\2\u05d2"+
		"\u05f3\3\2\2\2\u05d3\u05d4\7\4\2\2\u05d4\u05d5\5p9\2\u05d5\u05d6\7_\2"+
		"\2\u05d6\u05d7\5b\62\2\u05d7\u05d8\7\6\2\2\u05d8\u05d9\b\63\1\2\u05d9"+
		"\u05f3\3\2\2\2\u05da\u05db\t\f\2\2\u05db\u05dc\5b\62\2\u05dc\u05dd\7u"+
		"\2\2\u05dd\u05de\5d\63\2\u05de\u05df\7v\2\2\u05df\u05e0\5d\63\t\u05e0"+
		"\u05e1\b\63\1\2\u05e1\u05f3\3\2\2\2\u05e2\u05e3\7w\2\2\u05e3\u05f3\b\63"+
		"\1\2\u05e4\u05e5\7x\2\2\u05e5\u05f3\b\63\1\2\u05e6\u05e7\7y\2\2\u05e7"+
		"\u05f3\b\63\1\2\u05e8\u05e9\7z\2\2\u05e9\u05f3\b\63\1\2\u05ea\u05eb\7"+
		",\2\2\u05eb\u05ec\5d\63\2\u05ec\u05ed\7-\2\2\u05ed\u05ee\b\63\1\2\u05ee"+
		"\u05f3\3\2\2\2\u05ef\u05f0\5N(\2\u05f0\u05f1\b\63\1\2\u05f1\u05f3\3\2"+
		"\2\2\u05f2\u05c6\3\2\2\2\u05f2\u05cb\3\2\2\2\u05f2\u05cf\3\2\2\2\u05f2"+
		"\u05d3\3\2\2\2\u05f2\u05da\3\2\2\2\u05f2\u05e2\3\2\2\2\u05f2\u05e4\3\2"+
		"\2\2\u05f2\u05e6\3\2\2\2\u05f2\u05e8\3\2\2\2\u05f2\u05ea\3\2\2\2\u05f2"+
		"\u05ef\3\2\2\2\u05f3\u0620\3\2\2\2\u05f4\u05f5\f\21\2\2\u05f5\u05f6\7"+
		"\61\2\2\u05f6\u05f7\5d\63\22\u05f7\u05f8\b\63\1\2\u05f8\u061f\3\2\2\2"+
		"\u05f9\u05fa\f\20\2\2\u05fa\u05fb\7?\2\2\u05fb\u05fc\5d\63\21\u05fc\u05fd"+
		"\b\63\1\2\u05fd\u061f\3\2\2\2\u05fe\u05ff\f\17\2\2\u05ff\u0600\7s\2\2"+
		"\u0600\u0601\5d\63\20\u0601\u0602\b\63\1\2\u0602\u061f\3\2\2\2\u0603\u0604"+
		"\f\16\2\2\u0604\u0605\7A\2\2\u0605\u0606\5d\63\17\u0606\u0607\b\63\1\2"+
		"\u0607\u061f\3\2\2\2\u0608\u060a\f\f\2\2\u0609\u060b\5x=\2\u060a\u0609"+
		"\3\2\2\2\u060a\u060b\3\2\2\2\u060b\u060c\3\2\2\2\u060c\u060e\7b\2\2\u060d"+
		"\u060f\5x=\2\u060e\u060d\3\2\2\2\u060e\u060f\3\2\2\2\u060f\u0610\3\2\2"+
		"\2\u0610\u0611\5d\63\f\u0611\u0612\b\63\1\2\u0612\u061f\3\2\2\2\u0613"+
		"\u0614\f\13\2\2\u0614\u0615\7t\2\2\u0615\u0616\5d\63\f\u0616\u0617\b\63"+
		"\1\2\u0617\u061f\3\2\2\2\u0618\u0619\f\r\2\2\u0619\u061a\7\16\2\2\u061a"+
		"\u061b\5d\63\2\u061b\u061c\7\17\2\2\u061c\u061d\b\63\1\2\u061d\u061f\3"+
		"\2\2\2\u061e\u05f4\3\2\2\2\u061e\u05f9\3\2\2\2\u061e\u05fe\3\2\2\2\u061e"+
		"\u0603\3\2\2\2\u061e\u0608\3\2\2\2\u061e\u0613\3\2\2\2\u061e\u0618\3\2"+
		"\2\2\u061f\u0622\3\2\2\2\u0620\u061e\3\2\2\2\u0620\u0621\3\2\2\2\u0621"+
		"e\3\2\2\2\u0622\u0620\3\2\2\2\u0623\u0624\b\64\1\2\u0624\u0625\t\f\2\2"+
		"\u0625\u0626\5b\62\2\u0626\u0627\7u\2\2\u0627\u0628\5f\64\2\u0628\u0629"+
		"\7v\2\2\u0629\u062a\5f\64\f\u062a\u062b\b\64\1\2\u062b\u063f\3\2\2\2\u062c"+
		"\u062d\7^\2\2\u062d\u062e\5d\63\2\u062e\u062f\b\64\1\2\u062f\u063f\3\2"+
		"\2\2\u0630\u0631\7&\2\2\u0631\u0632\5d\63\2\u0632\u0633\b\64\1\2\u0633"+
		"\u063f\3\2\2\2\u0634\u0636\7s\2\2\u0635\u0634\3\2\2\2\u0635\u0636\3\2"+
		"\2\2\u0636\u0637\3\2\2\2\u0637\u0638\7\u0088\2\2\u0638\u063f\b\64\1\2"+
		"\u0639\u063a\7,\2\2\u063a\u063b\5f\64\2\u063b\u063c\7-\2\2\u063c\u063d"+
		"\b\64\1\2\u063d\u063f\3\2\2\2\u063e\u0623\3\2\2\2\u063e\u062c\3\2\2\2"+
		"\u063e\u0630\3\2\2\2\u063e\u0635\3\2\2\2\u063e\u0639\3\2\2\2\u063f\u065b"+
		"\3\2\2\2\u0640\u0641\f\t\2\2\u0641\u0642\t\r\2\2\u0642\u0643\5f\64\n\u0643"+
		"\u0644\b\64\1\2\u0644\u065a\3\2\2\2\u0645\u0646\f\b\2\2\u0646\u0647\t"+
		"\16\2\2\u0647\u0648\5f\64\t\u0648\u0649\b\64\1\2\u0649\u065a\3\2\2\2\u064a"+
		"\u064b\f\7\2\2\u064b\u064c\t\17\2\2\u064c\u064d\5f\64\b\u064d\u064e\b"+
		"\64\1\2\u064e\u065a\3\2\2\2\u064f\u0650\f\6\2\2\u0650\u0651\t\20\2\2\u0651"+
		"\u0652\5f\64\7\u0652\u0653\b\64\1\2\u0653\u065a\3\2\2\2\u0654\u0655\f"+
		"\5\2\2\u0655\u0656\t\21\2\2\u0656\u0657\5f\64\6\u0657\u0658\b\64\1\2\u0658"+
		"\u065a\3\2\2\2\u0659\u0640\3\2\2\2\u0659\u0645\3\2\2\2\u0659\u064a\3\2"+
		"\2\2\u0659\u064f\3\2\2\2\u0659\u0654\3\2\2\2\u065a\u065d\3\2\2\2\u065b"+
		"\u0659\3\2\2\2\u065b\u065c\3\2\2\2\u065cg\3\2\2\2\u065d\u065b\3\2\2\2"+
		"\u065e\u0663\5j\66\2\u065f\u0660\7\5\2\2\u0660\u0662\5j\66\2\u0661\u065f"+
		"\3\2\2\2\u0662\u0665\3\2\2\2\u0663\u0661\3\2\2\2\u0663\u0664\3\2\2\2\u0664"+
		"i\3\2\2\2\u0665\u0663\3\2\2\2\u0666\u0668\7\u0082\2\2\u0667\u0666\3\2"+
		"\2\2\u0667\u0668\3\2\2\2\u0668\u0669\3\2\2\2\u0669\u066e\5v<\2\u066a\u066b"+
		"\7\5\2\2\u066b\u066d\5v<\2\u066c\u066a\3\2\2\2\u066d\u0670\3\2\2\2\u066e"+
		"\u066c\3\2\2\2\u066e\u066f\3\2\2\2\u066f\u0671\3\2\2\2\u0670\u066e\3\2"+
		"\2\2\u0671\u0673\7\b\2\2\u0672\u0674\7W\2\2\u0673\u0672\3\2\2\2\u0673"+
		"\u0674\3\2\2\2\u0674\u0675\3\2\2\2\u0675\u0676\5d\63\2\u0676\u0677\b\66"+
		"\1\2\u0677\u06a9\3\2\2\2\u0678\u067a\7\u0082\2\2\u0679\u0678\3\2\2\2\u0679"+
		"\u067a\3\2\2\2\u067a\u067b\3\2\2\2\u067b\u0680\5v<\2\u067c\u067d\7\5\2"+
		"\2\u067d\u067f\5v<\2\u067e\u067c\3\2\2\2\u067f\u0682\3\2\2\2\u0680\u067e"+
		"\3\2\2\2\u0680\u0681\3\2\2\2\u0681\u0683\3\2\2\2\u0682\u0680\3\2\2\2\u0683"+
		"\u0684\7\b\2\2\u0684\u0685\7V\2\2\u0685\u0686\5d\63\2\u0686\u0687\b\66"+
		"\1\2\u0687\u06a9\3\2\2\2\u0688\u068a\7\u0082\2\2\u0689\u0688\3\2\2\2\u0689"+
		"\u068a\3\2\2\2\u068a\u068b\3\2\2\2\u068b\u0690\5v<\2\u068c\u068d\7\5\2"+
		"\2\u068d\u068f\5v<\2\u068e\u068c\3\2\2\2\u068f\u0692\3\2\2\2\u0690\u068e"+
		"\3\2\2\2\u0690\u0691\3\2\2\2\u0691\u0693\3\2\2\2\u0692\u0690\3\2\2\2\u0693"+
		"\u0694\7\b\2\2\u0694\u0695\7X\2\2\u0695\u0696\5d\63\2\u0696\u0697\b\66"+
		"\1\2\u0697\u06a9\3\2\2\2\u0698\u069a\7\u0082\2\2\u0699\u0698\3\2\2\2\u0699"+
		"\u069a\3\2\2\2\u069a\u069b\3\2\2\2\u069b\u06a0\5v<\2\u069c\u069d\7\5\2"+
		"\2\u069d\u069f\5v<\2\u069e\u069c\3\2\2\2\u069f\u06a2\3\2\2\2\u06a0\u069e"+
		"\3\2\2\2\u06a0\u06a1\3\2\2\2\u06a1\u06a3\3\2\2\2\u06a2\u06a0\3\2\2\2\u06a3"+
		"\u06a4\7\b\2\2\u06a4\u06a5\7\u0083\2\2\u06a5\u06a6\5d\63\2\u06a6\u06a7"+
		"\b\66\1\2\u06a7\u06a9\3\2\2\2\u06a8\u0667\3\2\2\2\u06a8\u0679\3\2\2\2"+
		"\u06a8\u0689\3\2\2\2\u06a8\u0699\3\2\2\2\u06a9k\3\2\2\2\u06aa\u06af\5"+
		"n8\2\u06ab\u06ac\7\5\2\2\u06ac\u06ae\5n8\2\u06ad\u06ab\3\2\2\2\u06ae\u06b1"+
		"\3\2\2\2\u06af\u06ad\3\2\2\2\u06af\u06b0\3\2\2\2\u06b0m\3\2\2\2\u06b1"+
		"\u06af\3\2\2\2\u06b2\u06b7\5v<\2\u06b3\u06b4\7\5\2\2\u06b4\u06b6\5v<\2"+
		"\u06b5\u06b3\3\2\2\2\u06b6\u06b9\3\2\2\2\u06b7\u06b5\3\2\2\2\u06b7\u06b8"+
		"\3\2\2\2\u06b8\u06ba\3\2\2\2\u06b9\u06b7\3\2\2\2\u06ba\u06bb\7\22\2\2"+
		"\u06bb\u06bc\5d\63\2\u06bc\u06bd\b8\1\2\u06bdo\3\2\2\2\u06be\u06c3\5r"+
		":\2\u06bf\u06c0\7\5\2\2\u06c0\u06c2\5r:\2\u06c1\u06bf\3\2\2\2\u06c2\u06c5"+
		"\3\2\2\2\u06c3\u06c1\3\2\2\2\u06c3\u06c4\3\2\2\2\u06c4q\3\2\2\2\u06c5"+
		"\u06c3\3\2\2\2\u06c6\u06c8\7\u0082\2\2\u06c7\u06c6\3\2\2\2\u06c7\u06c8"+
		"\3\2\2\2\u06c8\u06c9\3\2\2\2\u06c9\u06ce\5v<\2\u06ca\u06cb\7\5\2\2\u06cb"+
		"\u06cd\5v<\2\u06cc\u06ca\3\2\2\2\u06cd\u06d0\3\2\2\2\u06ce\u06cc\3\2\2"+
		"\2\u06ce\u06cf\3\2\2\2\u06cf\u06d1\3\2\2\2\u06d0\u06ce\3\2\2\2\u06d1\u06d3"+
		"\7\b\2\2\u06d2\u06d4\7W\2\2\u06d3\u06d2\3\2\2\2\u06d3\u06d4\3\2\2\2\u06d4"+
		"\u06d5\3\2\2\2\u06d5\u06d6\5d\63\2\u06d6\u06d7\3\2\2\2\u06d7\u06d8\b:"+
		"\1\2\u06d8s\3\2\2\2\u06d9\u06da\5z>\2\u06dau\3\2\2\2\u06db\u06dc\5z>\2"+
		"\u06dc\u06dd\b<\1\2\u06ddw\3\2\2\2\u06de\u06df\t\22\2\2\u06dfy\3\2\2\2"+
		"\u06e0\u070b\5\u0086D\2\u06e1\u070b\7\23\2\2\u06e2\u070b\7\34\2\2\u06e3"+
		"\u070b\7I\2\2\u06e4\u070b\7J\2\2\u06e5\u070b\7\24\2\2\u06e6\u070b\7\'"+
		"\2\2\u06e7\u070b\7\66\2\2\u06e8\u070b\7\u0084\2\2\u06e9\u070b\7Q\2\2\u06ea"+
		"\u070b\7\35\2\2\u06eb\u070b\79\2\2\u06ec\u070b\7\u0085\2\2\u06ed\u070b"+
		"\7\26\2\2\u06ee\u070b\7\36\2\2\u06ef\u070b\7\20\2\2\u06f0\u070b\7P\2\2"+
		"\u06f1\u070b\7\25\2\2\u06f2\u070b\7*\2\2\u06f3\u070b\7\r\2\2\u06f4\u070b"+
		"\7+\2\2\u06f5\u070b\7\37\2\2\u06f6\u070b\7\21\2\2\u06f7\u070b\7N\2\2\u06f8"+
		"\u070b\7L\2\2\u06f9\u070b\7\65\2\2\u06fa\u070b\7%\2\2\u06fb\u070b\7\33"+
		"\2\2\u06fc\u070b\7<\2\2\u06fd\u070b\7\u0086\2\2\u06fe\u070b\7(\2\2\u06ff"+
		"\u070b\7\27\2\2\u0700\u070b\7.\2\2\u0701\u070b\7\31\2\2\u0702\u070b\7"+
		"!\2\2\u0703\u070b\7#\2\2\u0704\u070b\7\32\2\2\u0705\u070b\7K\2\2\u0706"+
		"\u070b\7:\2\2\u0707\u070b\7\67\2\2\u0708\u070b\7;\2\2\u0709\u070b\7\r"+
		"\2\2\u070a\u06e0\3\2\2\2\u070a\u06e1\3\2\2\2\u070a\u06e2\3\2\2\2\u070a"+
		"\u06e3\3\2\2\2\u070a\u06e4\3\2\2\2\u070a\u06e5\3\2\2\2\u070a\u06e6\3\2"+
		"\2\2\u070a\u06e7\3\2\2\2\u070a\u06e8\3\2\2\2\u070a\u06e9\3\2\2\2\u070a"+
		"\u06ea\3\2\2\2\u070a\u06eb\3\2\2\2\u070a\u06ec\3\2\2\2\u070a\u06ed\3\2"+
		"\2\2\u070a\u06ee\3\2\2\2\u070a\u06ef\3\2\2\2\u070a\u06f0\3\2\2\2\u070a"+
		"\u06f1\3\2\2\2\u070a\u06f2\3\2\2\2\u070a\u06f3\3\2\2\2\u070a\u06f4\3\2"+
		"\2\2\u070a\u06f5\3\2\2\2\u070a\u06f6\3\2\2\2\u070a\u06f7\3\2\2\2\u070a"+
		"\u06f8\3\2\2\2\u070a\u06f9\3\2\2\2\u070a\u06fa\3\2\2\2\u070a\u06fb\3\2"+
		"\2\2\u070a\u06fc\3\2\2\2\u070a\u06fd\3\2\2\2\u070a\u06fe\3\2\2\2\u070a"+
		"\u06ff\3\2\2\2\u070a\u0700\3\2\2\2\u070a\u0701\3\2\2\2\u070a\u0702\3\2"+
		"\2\2\u070a\u0703\3\2\2\2\u070a\u0704\3\2\2\2\u070a\u0705\3\2\2\2\u070a"+
		"\u0706\3\2\2\2\u070a\u0707\3\2\2\2\u070a\u0708\3\2\2\2\u070a\u0709\3\2"+
		"\2\2\u070b{\3\2\2\2\u070c\u070d\t\23\2\2\u070d}\3\2\2\2\u070e\u0710\t"+
		"\24\2\2\u070f\u070e\3\2\2\2\u070f\u0710\3\2\2\2\u0710\u0712\3\2\2\2\u0711"+
		"\u0713\7\u0088\2\2\u0712\u0711\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0715"+
		"\3\2\2\2\u0714\u0716\7A\2\2\u0715\u0714\3\2\2\2\u0715\u0716\3\2\2\2\u0716"+
		"\u0717\3\2\2\2\u0717\u0718\7\u0088\2\2\u0718\177\3\2\2\2\u0719\u071a\7"+
		"\u008b\2\2\u071a\u0081\3\2\2\2\u071b\u071c\7\u008a\2\2\u071c\u0083\3\2"+
		"\2\2\u071d\u071e\7\u0087\2\2\u071e\u0085\3\2\2\2\u071f\u0720\7\u0089\2"+
		"\2\u0720\u0087\3\2\2\2\u0721\u0722\t\25\2\2\u0722\u0089\3\2\2\2\u0723"+
		"\u0724\7\u0088\2\2\u0724\u008b\3\2\2\2\u00eb\u0093\u00a4\u00a9\u00af\u00b5"+
		"\u00bc\u00c4\u00ca\u00d3\u00d8\u00da\u00de\u00e6\u00f2\u00f7\u00ff\u0102"+
		"\u0109\u010f\u011b\u0122\u013d\u013f\u0144\u014f\u0152\u0156\u015a\u015e"+
		"\u0163\u016c\u016f\u0174\u0184\u0186\u018b\u0193\u0196\u019a\u019e\u01a1"+
		"\u01a4\u01a7\u01b0\u01b5\u01c1\u01c4\u01c8\u01cb\u01d3\u01dc\u01e3\u01e8"+
		"\u01ed\u01f1\u01f5\u01f8\u01fb\u01fe\u0206\u020c\u0211\u021f\u0222\u0226"+
		"\u0229\u0232\u0237\u023e\u0247\u024e\u0253\u0258\u025c\u0260\u026b\u026e"+
		"\u0276\u0278\u0282\u0285\u028d\u0290\u0294\u0297\u02a6\u02a8\u02ad\u02bd"+
		"\u02c5\u02c8\u02cc\u02cf\u02d5\u02da\u02e2\u02e5\u02e9\u02ef\u02f3\u02fa"+
		"\u02ff\u0305\u0308\u0311\u0313\u0318\u031d\u0325\u032a\u0330\u0333\u033f"+
		"\u0341\u0346\u034d\u0353\u035a\u0360\u0364\u036e\u0373\u0380\u0382\u0387"+
		"\u038a\u038e\u0398\u03a6\u03b1\u03bd\u03cb\u03ce\u03d8\u03e1\u03e6\u03ee"+
		"\u03f7\u03fc\u0401\u0405\u0409\u040e\u041a\u041e\u0423\u0427\u042c\u0434"+
		"\u0436\u043b\u043f\u0448\u044a\u044f\u0453\u045c\u045e\u0463\u0467\u046d"+
		"\u0472\u0476\u047c\u0481\u0485\u048c\u04a3\u04ab\u04b3\u04bb\u04c3\u04cb"+
		"\u04d3\u04ed\u04f0\u050e\u0512\u0518\u051c\u0528\u052c\u0532\u0536\u0542"+
		"\u0546\u054c\u0550\u055c\u0560\u0566\u056a\u0576\u057a\u0580\u0584\u0590"+
		"\u0594\u059a\u059e\u05ab\u05c1\u05c3\u05f2\u060a\u060e\u061e\u0620\u0635"+
		"\u063e\u0659\u065b\u0663\u0667\u066e\u0673\u0679\u0680\u0689\u0690\u0699"+
		"\u06a0\u06a8\u06af\u06b7\u06c3\u06c7\u06ce\u06d3\u070a\u070f\u0712\u0715";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}