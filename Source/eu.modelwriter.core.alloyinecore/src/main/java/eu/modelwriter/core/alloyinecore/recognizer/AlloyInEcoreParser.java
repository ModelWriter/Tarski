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
import eu.modelwriter.core.alloyinecore.structure.model.Module;
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
import eu.modelwriter.core.alloyinecore.structure.model.Model;
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
		T__131=132, T__132=133, T__133=134, INT=135, IDENTIFIER=136, SINGLE_CHARACTER=137, 
		DOUBLE_QUOTED_STRING=138, SINGLE_QUOTED_STRING=139, ML_SINGLE_QUOTED_STRING=140, 
		MULTILINE_COMMENT=141, SINGLELINE_COMMENT=142, WS=143;
	public static final int
		RULE_options = 0, RULE_option = 1, RULE_instance = 2, RULE_modelImport = 3, 
		RULE_eObject = 4, RULE_slot = 5, RULE_dataValue = 6, RULE_multiValueData = 7, 
		RULE_eObjectValue = 8, RULE_literalValue = 9, RULE_module = 10, RULE_packageImport = 11, 
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
		"multiValueData", "eObjectValue", "literalValue", "module", "packageImport", 
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
		"']'", "'module'", "'import'", "'package'", "'='", "'abstract'", "'class'", 
		"'interface'", "'extends'", "'static'", "'ghost'", "'transient'", "'volatile'", 
		"'readonly'", "'attribute'", "'derived'", "'id'", "'ordered'", "'!ordered'", 
		"'unique'", "'!unique'", "'unsettable'", "'!unsettable'", "'property'", 
		"'#'", "'composes'", "'resolve'", "'!resolve'", "'key'", "'operation'", 
		"'('", "')'", "'throws'", "'..'", "'*'", "'+'", "'?'", "'|?'", "'|1'", 
		"'primitive'", "'datatype'", "'serializable'", "'!serializable'", "'enum'", 
		"'literal'", "'annotation'", "'reference'", "'<'", "'>'", "'&'", "'super'", 
		"'.'", "'::'", "'@'", "'Boolean'", "'Integer'", "'String'", "'Real'", 
		"'UnlimitedNatural'", "'body'", "'callable'", "'invariant'", "'precondition'", 
		"'requires'", "'postcondition'", "'ensures'", "'initial'", "'derivation'", 
		"'public'", "'protected'", "'private'", "'no'", "'lone'", "'one'", "'some'", 
		"'!'", "'not'", "'in'", "'<='", "'>='", "'sum'", "'|'", "'acyclic'", "'function'", 
		"'->'", "'ord'", "'&&'", "'and'", "'||'", "'or'", "'=>'", "'if'", "'implies'", 
		"'<=>'", "'iff'", "'all'", "'let'", "'true'", "'false'", "'~'", "'^'", 
		"'-'", "'++'", "'then'", "'else'", "'iden'", "'none'", "'univ'", "'ints'", 
		"'plus'", "'minus'", "'mul'", "'/'", "'div'", "'%'", "'modulo'", "'disj'", 
		"'set'", "'definition'", "'ensure'", "'require'", "'null'"
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
		null, null, null, "INT", "IDENTIFIER", "SINGLE_CHARACTER", "DOUBLE_QUOTED_STRING", 
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



	public Module module;
	public Instance instance;

	Repository repository = new Repository();

	URI saveURI;

	public AlloyInEcoreParser(TokenStream input, URI saveURI){
	    this(input);
	    this.saveURI = saveURI;
	    repository = new Repository(saveURI);
	}


	public void saveResource(String filename, String path){
	    module.printTree();
	    repository.printNamespaces();
	    if (module.getOwnedPackage() != null) {
	        ResourceSet metaResourceSet = new ResourceSetImpl();
	        metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());
	        Resource metaResource = metaResourceSet.createResource(URI.createURI(path + filename + ".ecore"));
	        metaResource.getContents().add(module.getOwnedPackage().getEObject());
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
			while (_la==T__14) {
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
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__31:
			case T__33:
			case T__35:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__44:
			case T__51:
			case T__52:
			case T__53:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__71:
			case T__72:
			case T__73:
			case T__74:
			case T__76:
			case T__78:
			case T__79:
			case T__130:
			case T__131:
			case T__132:
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
		public Model current;
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
			if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__15 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__21 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__29 - 11)) | (1L << (T__31 - 11)) | (1L << (T__33 - 11)) | (1L << (T__35 - 11)) | (1L << (T__37 - 11)) | (1L << (T__38 - 11)) | (1L << (T__40 - 11)) | (1L << (T__41 - 11)) | (1L << (T__44 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__53 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__58 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__74 - 75)) | (1L << (T__76 - 75)) | (1L << (T__78 - 75)) | (1L << (T__79 - 75)) | (1L << (T__130 - 75)) | (1L << (T__131 - 75)) | (1L << (T__132 - 75)) | (1L << (IDENTIFIER - 75)))) != 0)) {
				{
				setState(176);
				((ModelImportContext)_localctx).name = unrestrictedName();
				setState(177);
				match(T__5);
				}
			}

			setState(181);
			((ModelImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			}
		}
		catch (RecognitionException re) {
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
			setState(183);
			((EObjectContext)_localctx).name = pathName(_localctx.current);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 48)) & ~0x3f) == 0 && ((1L << (_la - 48)) & ((1L << (T__47 - 48)) | (1L << (T__63 - 48)) | (1L << (T__109 - 48)) | (1L << (T__110 - 48)))) != 0) || ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (T__113 - 114)) | (1L << (T__133 - 114)) | (1L << (INT - 114)) | (1L << (IDENTIFIER - 114)) | (1L << (SINGLE_CHARACTER - 114)) | (1L << (DOUBLE_QUOTED_STRING - 114)))) != 0)) {
				{
				setState(184);
				((EObjectContext)_localctx).id = literalValue();
				}
			}

			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(187);
				match(T__1);
				setState(188);
				((EObjectContext)_localctx).slot = slot(_localctx.current);
				((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(189);
					match(T__2);
					setState(190);
					((EObjectContext)_localctx).slot = slot(_localctx.current);
					((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196);
				match(T__3);
				}
				break;
			case T__9:
				{
				setState(198);
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
			setState(201);
			((SlotContext)_localctx).name = unrestrictedName();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(202);
				match(T__5);
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(203);
					dataValue();
					}
					break;
				case 2:
					{
					setState(204);
					match(T__1);
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__15 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__21 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__29 - 11)) | (1L << (T__31 - 11)) | (1L << (T__33 - 11)) | (1L << (T__35 - 11)) | (1L << (T__37 - 11)) | (1L << (T__38 - 11)) | (1L << (T__40 - 11)) | (1L << (T__41 - 11)) | (1L << (T__44 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__53 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__58 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__74 - 75)) | (1L << (T__76 - 75)) | (1L << (T__78 - 75)) | (1L << (T__79 - 75)) | (1L << (T__130 - 75)) | (1L << (T__131 - 75)) | (1L << (T__132 - 75)) | (1L << (IDENTIFIER - 75)))) != 0)) {
						{
						{
						setState(205);
						eObject(_localctx.current);
						}
						}
						setState(210);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(211);
					match(T__3);
					}
					break;
				case 3:
					{
					setState(212);
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
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__47:
			case T__63:
			case T__109:
			case T__110:
			case T__113:
			case T__133:
			case INT:
			case IDENTIFIER:
			case SINGLE_CHARACTER:
			case DOUBLE_QUOTED_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				literalValue();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
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
			setState(221);
			match(T__11);
			setState(222);
			dataValue();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(223);
				match(T__2);
				setState(224);
				dataValue();
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
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
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__31:
			case T__33:
			case T__35:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__44:
			case T__51:
			case T__52:
			case T__53:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__71:
			case T__72:
			case T__73:
			case T__74:
			case T__76:
			case T__78:
			case T__79:
			case T__130:
			case T__131:
			case T__132:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				pathName(_localctx.current);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(233);
				match(T__11);
				setState(234);
				pathName(_localctx.current);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(235);
					match(T__2);
					setState(236);
					pathName(_localctx.current);
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(242);
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
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				identifier();
				}
				break;
			case T__47:
			case T__63:
			case T__113:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				numericValue();
				}
				break;
			case DOUBLE_QUOTED_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				stringValue();
				}
				break;
			case SINGLE_CHARACTER:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				charValue();
				}
				break;
			case T__109:
			case T__110:
				enterOuterAlt(_localctx, 5);
				{
				setState(250);
				booleanValue();
				}
				break;
			case T__133:
				enterOuterAlt(_localctx, 6);
				{
				setState(251);
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
		enterRule(_localctx, 20, RULE_module);
		module = new Module(_localctx); ((ModuleContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.MODULE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(254);
				options();
				}
			}


			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(258);
				match(T__13);
				setState(259);
				((ModuleContext)_localctx).name = identifier();
				setState(260);
				match(T__9);
				}
			}

			_localctx.element.getDetails().put("name", (((ModuleContext)_localctx).name!=null?_input.getText(((ModuleContext)_localctx).name.start,((ModuleContext)_localctx).name.stop):null));
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(265);
				((ModuleContext)_localctx).packageImport = packageImport(module);
				((ModuleContext)_localctx).ownedPackageImport.add(((ModuleContext)_localctx).packageImport);
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(271);
			((ModuleContext)_localctx).ownedPackage = ((ModuleContext)_localctx).ePackage = ePackage(module);
			((ModuleContext)_localctx).ePackage.element.getEAnnotations().add(_localctx.element);
			}
			for(PackageImportContext ctx: _localctx.ownedPackageImport) {((ModuleContext)_localctx).ePackage.element.getEAnnotations().add(ctx.element);}
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
			setState(276);
			match(T__14);
			}
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(277);
				((PackageImportContext)_localctx).name = identifier();
				setState(278);
				match(T__5);
				}
			}

			setState(282);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(283);
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
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)))) != 0)) {
				{
				setState(286);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EPackageContext)_localctx).visibility.element);
			setState(290);
			match(T__15);
			setState(291);
			((EPackageContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null));
			if(_localctx.parent instanceof ModuleContext) {((EPackageContext)_localctx).current =  new RootPackage(_localctx.element, _localctx); repository.name2Import.put(((RootPackage)_localctx.current).getKey(), (RootPackage)_localctx.current);}
			     else {((EPackageContext)_localctx).current =  new Package(_localctx.element, _localctx);}
			{
			setState(294);
			match(T__5);
			setState(295);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(297);
			match(T__16);
			setState(298);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			_localctx.element.setNsPrefix((((EPackageContext)_localctx).nsPrefix!=null?_input.getText(((EPackageContext)_localctx).nsPrefix.start,((EPackageContext)_localctx).nsPrefix.stop):null)); if(((EPackageContext)_localctx).nsURI != null) _localctx.element.setNsURI(((EPackageContext)_localctx).nsURI.getText().replace("'", ""));
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(301);
				match(T__1);
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__51) | (1L << T__52) | (1L << T__55) | (1L << T__57))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__80 - 73)) | (1L << (T__81 - 73)) | (1L << (T__82 - 73)))) != 0)) {
					{
					setState(314);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						setState(302);
						((EPackageContext)_localctx).eAnnotation = ((EPackageContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(305);
						((EPackageContext)_localctx).ePackage = ((EPackageContext)_localctx).ePackage = ePackage(_localctx.current);
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						_localctx.element.getESubpackages().add(((EPackageContext)_localctx).ePackage.element);
						}
						break;
					case 3:
						{
						setState(308);
						((EPackageContext)_localctx).eClassifier = ((EPackageContext)_localctx).eClassifier = eClassifier(_localctx.current);
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						if (((EPackageContext)_localctx).eClassifier.element != null) _localctx.element.getEClassifiers().add(((EPackageContext)_localctx).eClassifier.element);
						}
						break;
					case 4:
						{
						setState(311);
						((EPackageContext)_localctx).invariant = ((EPackageContext)_localctx).invariant = invariant(_localctx.current);
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(319);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(320);
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
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				((EClassifierContext)_localctx).eClass = eClass(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eClass.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				((EClassifierContext)_localctx).eDataType = eDataType(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eDataType.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
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
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)))) != 0)) {
				{
				setState(334);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).visibility.element);
			setState(343);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__18:
				{
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(338);
					((EClassContext)_localctx).isAbstract = match(T__17);
					}
				}

				setState(341);
				((EClassContext)_localctx).isClass = match(T__18);
				}
				break;
			case T__19:
				{
				setState(342);
				((EClassContext)_localctx).isInterface = match(T__19);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.element.setAbstract(((EClassContext)_localctx).isAbstract!=null); if (((EClassContext)_localctx).isInterface!=null) {_localctx.element.setInterface(true);_localctx.element.setAbstract(true);}
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(346);
				((EClassContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			if (_localctx.name == null) {notifyErrorListeners("missing Class name");} else {_localctx.element.setName((((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null));}
			if (((EClassContext)_localctx).isInterface!=null) ((EClassContext)_localctx).current =  new Interface(_localctx.element, _localctx); else ((EClassContext)_localctx).current =  new Class(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__59) {
				{
				setState(351);
				((EClassContext)_localctx).ownedSignature = ((EClassContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EClassContext)_localctx).templateSignature.typeParameters);
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(355);
				match(T__20);
				setState(356);
				((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(357);
					match(T__2);
					setState(358);
					((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
					}
					}
					setState(363);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(367);
				match(T__5);
				setState(368);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EClassContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EClassContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(372);
				match(T__1);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__35) | (1L << T__41) | (1L << T__57))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__80 - 73)) | (1L << (T__81 - 73)) | (1L << (T__82 - 73)))) != 0)) {
					{
					setState(385);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(373);
						((EClassContext)_localctx).eAnnotation = ((EClassContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(376);
						((EClassContext)_localctx).eOperation = ((EClassContext)_localctx).eOperation = eOperation(_localctx.current);
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						_localctx.element.getEOperations().add(((EClassContext)_localctx).eOperation.element);
						}
						break;
					case 3:
						{
						setState(379);
						((EClassContext)_localctx).eStructuralFeature = ((EClassContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.current);
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						if (((EClassContext)_localctx).eStructuralFeature.element != null) _localctx.element.getEStructuralFeatures().add(((EClassContext)_localctx).eStructuralFeature.element);
						}
						break;
					case 4:
						{
						setState(382);
						((EClassContext)_localctx).invariant = ((EClassContext)_localctx).invariant = invariant(_localctx.current);
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(389);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(390);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(391);
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
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				((EStructuralFeatureContext)_localctx).eAttribute = eAttribute(_localctx.owner);
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eAttribute.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
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
		public Token s22;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s11;
		public Token s23;
		public Token s24;
		public Token s25;
		public Token s26;
		public UnrestrictedNameContext name;
		public EGenericElementTypeContext eAttributeType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s28;
		public Token s29;
		public Token s30;
		public Token s31;
		public Token s32;
		public Token s33;
		public Token s34;
		public Token s35;
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
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)))) != 0)) {
				{
				setState(402);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).visibility.element);
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(406);
				((EAttributeContext)_localctx).s22 = match(T__21);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s22);
				}
			}

			setState(411);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(409);
				((EAttributeContext)_localctx).s11 = match(T__10);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s11);
				}
				break;
			case T__22:
				{
				setState(410);
				((EAttributeContext)_localctx).s23 = match(T__22);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s23);
				}
				break;
			case T__23:
			case T__24:
			case T__25:
			case T__26:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(413);
				((EAttributeContext)_localctx).s24 = match(T__23);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s24);
				}
			}

			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(416);
				((EAttributeContext)_localctx).s25 = match(T__24);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s25);
				}
			}

			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(419);
				((EAttributeContext)_localctx).s26 = match(T__25);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
				}
			}

			setState(422);
			match(T__26);
			setState(423);
			((EAttributeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EAttributeContext)_localctx).name!=null?_input.getText(((EAttributeContext)_localctx).name.start,((EAttributeContext)_localctx).name.stop):null));
			((EAttributeContext)_localctx).current =  new Attribute(_localctx.element, _localctx);
			setState(426);
			match(T__5);
			setState(427);
			((EAttributeContext)_localctx).eAttributeType = eGenericElementType(_localctx.current);
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(428);
				((EAttributeContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement)_localctx.element);
				}
			}

			if(_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(432);
				match(T__16);
				setState(433);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EAttributeContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EAttributeContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(437);
				match(T__1);
				setState(451); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(446);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__27:
						{
						setState(438);
						((EAttributeContext)_localctx).s28 = match(T__27);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(439);
						((EAttributeContext)_localctx).s29 = match(T__28);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(440);
						((EAttributeContext)_localctx).s30 = match(T__29);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(441);
						((EAttributeContext)_localctx).s31 = match(T__30);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
						}
						break;
					case T__31:
						{
						setState(442);
						((EAttributeContext)_localctx).s32 = match(T__31);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s32);
						}
						break;
					case T__32:
						{
						setState(443);
						((EAttributeContext)_localctx).s33 = match(T__32);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s33);
						}
						break;
					case T__33:
						{
						setState(444);
						((EAttributeContext)_localctx).s34 = match(T__33);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s34);
						}
						break;
					case T__34:
						{
						setState(445);
						((EAttributeContext)_localctx).s35 = match(T__34);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s35);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(449);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(448);
						match(T__2);
						}
					}

					}
					}
					setState(453); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0) );
				setState(455);
				match(T__3);
				}
				break;
			}
			setState(485);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(458);
				match(T__1);
				{
				setState(464);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(459);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(466);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				}
				setState(473);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__79:
					{
					setState(467);
					((EAttributeContext)_localctx).ownedDerivation = ((EAttributeContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).derivation.element);
					}
					break;
				case T__78:
					{
					setState(470);
					((EAttributeContext)_localctx).ownedInitial = ((EAttributeContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__57:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(475);
					((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
					}
					}
					setState(482);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(483);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(484);
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
		public Token s22;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s11;
		public Token s23;
		public Token s24;
		public Token s25;
		public Token s26;
		public UnrestrictedNameContext name;
		public UnrestrictedNameContext eOpposite;
		public EGenericElementTypeContext eReferenceType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s38;
		public Token s28;
		public Token s30;
		public Token s31;
		public Token s32;
		public Token s33;
		public Token s39;
		public Token s40;
		public Token s34;
		public Token s35;
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
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)))) != 0)) {
				{
				setState(489);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).visibility.element);
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(493);
				((EReferenceContext)_localctx).s22 = match(T__21);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s22);
				}
			}

			setState(498);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(496);
				((EReferenceContext)_localctx).s11 = match(T__10);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s11);
				}
				break;
			case T__22:
				{
				setState(497);
				((EReferenceContext)_localctx).s23 = match(T__22);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s23);
				}
				break;
			case T__23:
			case T__24:
			case T__25:
			case T__35:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(500);
				((EReferenceContext)_localctx).s24 = match(T__23);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s24);
				}
			}

			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(503);
				((EReferenceContext)_localctx).s25 = match(T__24);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s25);
				}
			}

			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(506);
				((EReferenceContext)_localctx).s26 = match(T__25);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
				}
			}

			setState(509);
			match(T__35);
			setState(510);
			((EReferenceContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null));
			((EReferenceContext)_localctx).current =  new Reference(_localctx.element, _localctx);
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(513);
				match(T__36);
				setState(514);
				((EReferenceContext)_localctx).eOpposite = unrestrictedName();
				}
			}


			{
			setState(518);
			match(T__5);
			setState(519);
			((EReferenceContext)_localctx).eReferenceType = eGenericElementType(_localctx.current);
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(520);
				((EReferenceContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			}
			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(524);
				match(T__16);
				setState(525);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EReferenceContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EReferenceContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(550);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(529);
				match(T__1);
				setState(545); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(540);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__37:
						{
						setState(530);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__27:
						{
						setState(531);
						((EReferenceContext)_localctx).s28 = match(T__27);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s28);
						}
						break;
					case T__29:
						{
						setState(532);
						((EReferenceContext)_localctx).s30 = match(T__29);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(533);
						((EReferenceContext)_localctx).s31 = match(T__30);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
						}
						break;
					case T__31:
						{
						setState(534);
						((EReferenceContext)_localctx).s32 = match(T__31);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s32);
						}
						break;
					case T__32:
						{
						setState(535);
						((EReferenceContext)_localctx).s33 = match(T__32);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s33);
						}
						break;
					case T__38:
						{
						setState(536);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(537);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					case T__33:
						{
						setState(538);
						((EReferenceContext)_localctx).s34 = match(T__33);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s34);
						}
						break;
					case T__34:
						{
						setState(539);
						((EReferenceContext)_localctx).s35 = match(T__34);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s35);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(543);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(542);
						match(T__2);
						}
					}

					}
					}
					setState(547); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0) );
				setState(549);
				match(T__3);
				}
				break;
			}
			setState(592);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(552);
				match(T__1);
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__40) {
					{
					setState(553);
					match(T__40);
					setState(554);
					((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
					setState(559);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(555);
						match(T__2);
						setState(556);
						((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
						}
						}
						setState(561);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(562);
					match(T__9);
					}
				}

				{
				setState(571);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(566);
						((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(573);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				}
				setState(580);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__79:
					{
					setState(574);
					((EReferenceContext)_localctx).ownedDerivation = ((EReferenceContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).derivation.element);
					}
					break;
				case T__78:
					{
					setState(577);
					((EReferenceContext)_localctx).ownedInitial = ((EReferenceContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__57:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(582);
					((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
					}
					}
					setState(589);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(590);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(591);
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
		public Token s22;
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
		public Token s30;
		public Token s31;
		public Token s32;
		public Token s33;
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
			setState(597);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)))) != 0)) {
				{
				setState(596);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EOperationContext)_localctx).visibility.element);
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(600);
				((EOperationContext)_localctx).s22 = match(T__21);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s22);
				}
			}

			setState(603);
			match(T__41);
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__59) {
				{
				setState(604);
				((EOperationContext)_localctx).ownedSignature = ((EOperationContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EOperationContext)_localctx).templateSignature.typeParameters);
			setState(608);
			((EOperationContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null));
			{
			setState(610);
			match(T__42);
			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__15 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__21 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__29 - 11)) | (1L << (T__31 - 11)) | (1L << (T__33 - 11)) | (1L << (T__35 - 11)) | (1L << (T__37 - 11)) | (1L << (T__38 - 11)) | (1L << (T__40 - 11)) | (1L << (T__41 - 11)) | (1L << (T__44 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__53 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__58 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__74 - 75)) | (1L << (T__76 - 75)) | (1L << (T__78 - 75)) | (1L << (T__79 - 75)) | (1L << (T__130 - 75)) | (1L << (T__131 - 75)) | (1L << (T__132 - 75)) | (1L << (IDENTIFIER - 75)))) != 0)) {
				{
				setState(611);
				((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(612);
					match(T__2);
					setState(613);
					((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(618);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(621);
			match(T__43);
			}
			for (EParameterContext ctx: ((EOperationContext)_localctx).eParameters){_localctx.element.getEParameters().add(ctx.element);}
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(624);
				match(T__5);
				setState(625);
				((EOperationContext)_localctx).eReturnType = ((EOperationContext)_localctx).eGenericElementType = eGenericElementType(_localctx.current);
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(626);
					((EOperationContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
					}
				}

				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			 if (_localctx.eReturnType != null) _localctx.element.setEGenericType(((EOperationContext)_localctx).eGenericElementType.element);
			setState(642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(633);
				match(T__44);
				setState(634);
				((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(635);
					match(T__2);
					setState(636);
					((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
					}
					}
					setState(641);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 for(EGenericExceptionContext e: ((EOperationContext)_localctx).ownedException) _localctx.element.getEGenericExceptions().add(e.element);
			setState(660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(645);
				match(T__1);
				setState(655); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(650);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__29:
						{
						setState(646);
						((EOperationContext)_localctx).s30 = match(T__29);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(647);
						((EOperationContext)_localctx).s31 = match(T__30);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s31);
						}
						break;
					case T__31:
						{
						setState(648);
						((EOperationContext)_localctx).s32 = match(T__31);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s32);
						}
						break;
					case T__32:
						{
						setState(649);
						((EOperationContext)_localctx).s33 = match(T__32);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s33);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(653);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(652);
						match(T__2);
						}
					}

					}
					}
					setState(657); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0) );
				setState(659);
				match(T__3);
				}
				break;
			}
			setState(682);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(662);
				match(T__1);
				setState(677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & ((1L << (T__57 - 58)) | (1L << (T__71 - 58)) | (1L << (T__74 - 58)) | (1L << (T__75 - 58)) | (1L << (T__76 - 58)) | (1L << (T__77 - 58)))) != 0)) {
					{
					setState(675);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__57:
						{
						setState(663);
						((EOperationContext)_localctx).eAnnotation = ((EOperationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).eAnnotation.element);
						}
						break;
					case T__74:
					case T__75:
						{
						setState(666);
						((EOperationContext)_localctx).precondition = ((EOperationContext)_localctx).precondition = precondition(_localctx.current);
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).precondition.element);
						}
						break;
					case T__71:
						{
						setState(669);
						((EOperationContext)_localctx).body = ((EOperationContext)_localctx).body = body(_localctx.current);
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).body.element);
						}
						break;
					case T__76:
					case T__77:
						{
						setState(672);
						((EOperationContext)_localctx).postcondition = ((EOperationContext)_localctx).postcondition = postcondition(_localctx.current);
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).postcondition.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(679);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(680);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(681);
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
			setState(686);
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
			setState(689);
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
		public Token s30;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s31;
		public Token s32;
		public Token s33;
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
			setState(692);
			((EParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null));
			((EParameterContext)_localctx).current =  new Parameter(_localctx.element, _localctx);
			setState(695);
			match(T__5);
			setState(696);
			((EParameterContext)_localctx).eParameterType = eGenericElementType(_localctx.current);
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(697);
				((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(716);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(701);
				match(T__1);
				setState(711); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(706);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__29:
						{
						setState(702);
						((EParameterContext)_localctx).s30 = match(T__29);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(703);
						((EParameterContext)_localctx).s31 = match(T__30);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s31);
						}
						break;
					case T__31:
						{
						setState(704);
						((EParameterContext)_localctx).s32 = match(T__31);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s32);
						}
						break;
					case T__32:
						{
						setState(705);
						((EParameterContext)_localctx).s33 = match(T__32);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s33);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(709);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(708);
						match(T__2);
						}
					}

					}
					}
					setState(713); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0) );
				setState(715);
				match(T__3);
				}
				break;
			}
			setState(727);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(718);
				match(T__1);
				setState(722);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(719);
					((EParameterContext)_localctx).eAnnotation = ((EParameterContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(724);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EParameterContext)_localctx).eAnnotation.element);
				setState(726);
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
			setState(731);
			match(T__11);
			setState(738);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(732);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__45) {
					{
					setState(733);
					match(T__45);
					setState(734);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__46:
			case T__47:
			case T__48:
				{
				setState(737);
				((EMultiplicityContext)_localctx).stringBound = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48))) != 0)) ) {
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
			setState(742);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__49:
				{
				setState(740);
				((EMultiplicityContext)_localctx).nullable = match(T__49);
				}
				break;
			case T__50:
				{
				setState(741);
				match(T__50);
				}
				break;
			case T__12:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(744);
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
		public Token s52;
		public List<Token> qualifier = new ArrayList<Token>();
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public Token instanceClassName;
		public Token s54;
		public Token s55;
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
			setState(748);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)))) != 0)) {
				{
				setState(747);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).visibility.element);
			setState(752);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__51) {
				{
				setState(751);
				((EDataTypeContext)_localctx).s52 = match(T__51);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s52);
				}
			}

			setState(754);
			match(T__52);
			setState(755);
			((EDataTypeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null));
			((EDataTypeContext)_localctx).current =  new DataType(_localctx.element, _localctx);
			setState(759);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__59) {
				{
				setState(758);
				((EDataTypeContext)_localctx).ownedSignature = ((EDataTypeContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EDataTypeContext)_localctx).templateSignature.typeParameters);
			setState(764);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(762);
				match(T__5);
				setState(763);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EDataTypeContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EDataTypeContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(773);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(767);
				match(T__1);
				setState(770);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__53:
					{
					setState(768);
					((EDataTypeContext)_localctx).s54 = match(T__53);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s54);
					}
					break;
				case T__54:
					{
					setState(769);
					((EDataTypeContext)_localctx).s55 = match(T__54);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s55);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(772);
				match(T__3);
				}
				break;
			}
			setState(789);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(775);
				match(T__1);
				setState(784);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & ((1L << (T__57 - 58)) | (1L << (T__72 - 58)) | (1L << (T__73 - 58)))) != 0)) {
					{
					setState(782);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__57:
						{
						setState(776);
						((EDataTypeContext)_localctx).eAnnotation = ((EDataTypeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).eAnnotation.element);
						}
						break;
					case T__72:
					case T__73:
						{
						setState(779);
						((EDataTypeContext)_localctx).invariant = ((EDataTypeContext)_localctx).invariant = invariant(_localctx.current);
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).invariant.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(786);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(787);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(788);
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
		public Token s54;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s55;
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
			setState(794);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (T__80 - 81)) | (1L << (T__81 - 81)) | (1L << (T__82 - 81)))) != 0)) {
				{
				setState(793);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EEnumContext)_localctx).visibility.element);
			setState(797);
			match(T__55);
			setState(798);
			((EEnumContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null));
			((EEnumContext)_localctx).current =  new Enum(_localctx.element, _localctx);
			setState(802);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__59) {
				{
				setState(801);
				((EEnumContext)_localctx).ownedSignature = ((EEnumContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EEnumContext)_localctx).templateSignature.typeParameters);
			setState(807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(805);
				match(T__5);
				setState(806);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EEnumContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EEnumContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(816);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				{
				setState(810);
				match(T__1);
				setState(813);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__53:
					{
					setState(811);
					((EEnumContext)_localctx).s54 = match(T__53);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s54);
					}
					break;
				case T__54:
					{
					setState(812);
					((EEnumContext)_localctx).s55 = match(T__54);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s55);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(815);
				match(T__3);
				}
				break;
			}
			setState(835);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(818);
				match(T__1);
				setState(830);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__15 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__21 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__29 - 11)) | (1L << (T__31 - 11)) | (1L << (T__33 - 11)) | (1L << (T__35 - 11)) | (1L << (T__37 - 11)) | (1L << (T__38 - 11)) | (1L << (T__40 - 11)) | (1L << (T__41 - 11)) | (1L << (T__44 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__53 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__58 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__74 - 75)) | (1L << (T__76 - 75)) | (1L << (T__78 - 75)) | (1L << (T__79 - 75)) | (1L << (T__130 - 75)) | (1L << (T__131 - 75)) | (1L << (T__132 - 75)) | (1L << (IDENTIFIER - 75)))) != 0)) {
					{
					setState(828);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
					case 1:
						{
						setState(819);
						((EEnumContext)_localctx).eAnnotation = ((EEnumContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(822);
						((EEnumContext)_localctx).eEnumLiteral = ((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.current);
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						_localctx.element.getELiterals().add(((EEnumContext)_localctx).eEnumLiteral.element);
						}
						break;
					case 3:
						{
						setState(825);
						((EEnumContext)_localctx).invariant = ((EEnumContext)_localctx).invariant = invariant(_localctx.current);
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(832);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(833);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(834);
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
			setState(842);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				{
				setState(839);
				match(T__56);
				setState(840);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(841);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			_localctx.element.setName((((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null));
			((EEnumLiteralContext)_localctx).current =  new EnumLiteral(_localctx.element, _localctx);
			setState(848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(846);
				match(T__16);
				setState(847);
				((EEnumLiteralContext)_localctx).value = match(INT);
				}
			}

			 
			setState(861);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(851);
				match(T__1);
				setState(855);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(852);
					((EEnumLiteralContext)_localctx).eAnnotation = ((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(857);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EEnumLiteralContext)_localctx).eAnnotation.element);
				setState(859);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(860);
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
			setState(863);
			match(T__57);
			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(864);
				((EAnnotationContext)_localctx).source = match(SINGLE_QUOTED_STRING);
				}
			}

			_localctx.element.setSource(((EAnnotationContext)_localctx).source != null ? ((EAnnotationContext)_localctx).source.getText().replace("'", "") : null);
			((EAnnotationContext)_localctx).current =  new Annotation(_localctx.element, _localctx);
			setState(880);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__42) {
				{
				setState(869);
				match(T__42);
				setState(870);
				((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(875);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(871);
					match(T__2);
					setState(872);
					((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(877);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(878);
				match(T__43);
				}
			}

			for (EDetailContext ctx: ((EAnnotationContext)_localctx).ownedDetails) _localctx.element.getDetails().put(ctx.k, ctx.v);
			setState(900);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(883);
				match(T__1);
				setState(893); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(893);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
					case 1:
						{
						setState(884);
						((EAnnotationContext)_localctx).eAnnotation = ((EAnnotationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						if(((EAnnotationContext)_localctx).eAnnotation.element != null) _localctx.element.getEAnnotations().add(((EAnnotationContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(887);
						((EAnnotationContext)_localctx).eModelElement = ((EAnnotationContext)_localctx).eModelElement = eModelElement(_localctx.current);
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						if(((EAnnotationContext)_localctx).eModelElement.element != null) _localctx.element.getContents().add(((EAnnotationContext)_localctx).eModelElement.element);
						}
						break;
					case 3:
						{
						setState(890);
						((EAnnotationContext)_localctx).eModelElementRef = ((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef(_localctx.current);
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						if(((EAnnotationContext)_localctx).eModelElementRef.element != null) _localctx.element.getReferences().add(((EAnnotationContext)_localctx).eModelElementRef.element);
						}
						break;
					}
					}
					setState(895); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (T__10 - 11)) | (1L << (T__13 - 11)) | (1L << (T__14 - 11)) | (1L << (T__15 - 11)) | (1L << (T__17 - 11)) | (1L << (T__18 - 11)) | (1L << (T__19 - 11)) | (1L << (T__20 - 11)) | (1L << (T__21 - 11)) | (1L << (T__22 - 11)) | (1L << (T__23 - 11)) | (1L << (T__24 - 11)) | (1L << (T__25 - 11)) | (1L << (T__26 - 11)) | (1L << (T__27 - 11)) | (1L << (T__28 - 11)) | (1L << (T__29 - 11)) | (1L << (T__31 - 11)) | (1L << (T__33 - 11)) | (1L << (T__35 - 11)) | (1L << (T__37 - 11)) | (1L << (T__38 - 11)) | (1L << (T__40 - 11)) | (1L << (T__41 - 11)) | (1L << (T__44 - 11)) | (1L << (T__51 - 11)) | (1L << (T__52 - 11)) | (1L << (T__53 - 11)) | (1L << (T__55 - 11)) | (1L << (T__56 - 11)) | (1L << (T__57 - 11)) | (1L << (T__58 - 11)) | (1L << (T__71 - 11)) | (1L << (T__72 - 11)) | (1L << (T__73 - 11)))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__74 - 75)) | (1L << (T__76 - 75)) | (1L << (T__78 - 75)) | (1L << (T__79 - 75)) | (1L << (T__80 - 75)) | (1L << (T__81 - 75)) | (1L << (T__82 - 75)) | (1L << (T__130 - 75)) | (1L << (T__131 - 75)) | (1L << (T__132 - 75)) | (1L << (IDENTIFIER - 75)))) != 0) );
				setState(897);
				match(T__3);
				}
				}
				break;
			case T__9:
				{
				setState(899);
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
			setState(903);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(902);
				((EDetailContext)_localctx).key = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(905);
			match(T__16);
			setState(907);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) {
				{
				setState(906);
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
			setState(917);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(911);
				((EModelElementContext)_localctx).eAnnotation = eAnnotation(_localctx.owner);
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eAnnotation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(914);
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
			setState(931);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(919);
				((ENamedElementContext)_localctx).eTypedElement = eTypedElement(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eTypedElement.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(922);
				((ENamedElementContext)_localctx).eClassifier = eClassifier(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eClassifier.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(925);
				((ENamedElementContext)_localctx).ePackage = ePackage(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).ePackage.element;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(928);
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
			setState(942);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(933);
				((ETypedElementContext)_localctx).eOperation = eOperation(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eOperation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(936);
				((ETypedElementContext)_localctx).eParameter = eParameter(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eParameter.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(939);
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
			setState(944);
			match(T__58);
			setState(945);
			((EModelElementRefContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(946);
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
			setState(948);
			match(T__59);
			setState(949);
			((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
			((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
			setState(954);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(950);
				match(T__2);
				setState(951);
				((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
				((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
				}
				}
				setState(956);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(957);
			match(T__60);
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
			setState(959);
			((ETypeParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((ETypeParameterContext)_localctx).name!=null?_input.getText(((ETypeParameterContext)_localctx).name.start,((ETypeParameterContext)_localctx).name.stop):null));
			((ETypeParameterContext)_localctx).current =  new TypeParameter(_localctx.element, _localctx);
			setState(971);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(962);
				match(T__20);
				setState(963);
				((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
				setState(968);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__61) {
					{
					{
					setState(964);
					match(T__61);
					setState(965);
					((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
					((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
					}
					}
					setState(970);
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
			setState(981);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__31:
			case T__33:
			case T__35:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__44:
			case T__51:
			case T__52:
			case T__53:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__71:
			case T__72:
			case T__73:
			case T__74:
			case T__76:
			case T__78:
			case T__79:
			case T__130:
			case T__131:
			case T__132:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(975);
				((EGenericTypeArgumentContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((EGenericTypeArgumentContext)_localctx).element =  ((EGenericTypeArgumentContext)_localctx).eGenericType.element;
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 2);
				{
				setState(978);
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
			setState(983);
			((EGenericTypeContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(995);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__59) {
				{
				setState(984);
				match(T__59);
				setState(985);
				((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
				((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
				setState(990);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(986);
					match(T__2);
					setState(987);
					((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
					((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
					}
					}
					setState(992);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(993);
				match(T__60);
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
			setState(1003);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__66:
			case T__67:
			case T__68:
			case T__69:
			case T__70:
				enterOuterAlt(_localctx, 1);
				{
				setState(997);
				((EGenericElementTypeContext)_localctx).ePrimitiveType = ePrimitiveType(_localctx.current);
				((EGenericElementTypeContext)_localctx).element =  ((EGenericElementTypeContext)_localctx).ePrimitiveType.element;
				}
				break;
			case T__10:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__31:
			case T__33:
			case T__35:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__44:
			case T__51:
			case T__52:
			case T__53:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__71:
			case T__72:
			case T__73:
			case T__74:
			case T__76:
			case T__78:
			case T__79:
			case T__130:
			case T__131:
			case T__132:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1000);
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
			setState(1005);
			match(T__48);
			((EGenericWildcardContext)_localctx).element =  eFactory.createEGenericType();
			setState(1012);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20 || _la==T__62) {
				{
				setState(1007);
				((EGenericWildcardContext)_localctx).bound = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__62) ) {
					((EGenericWildcardContext)_localctx).bound = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((EGenericWildcardContext)_localctx).current =  new GenericWildcard(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);
				setState(1009);
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
			setState(1014);
			((PathNameContext)_localctx).firstSegment = unrestrictedName();
			setState(1017);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1015);
				match(T__63);
				setState(1016);
				((PathNameContext)_localctx).index = match(INT);
				}
				break;
			}
			setState(1026);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				{
				setState(1022);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1019);
						((PathNameContext)_localctx).segment = segment();
						((PathNameContext)_localctx).midSegments.add(((PathNameContext)_localctx).segment);
						}
						} 
					}
					setState(1024);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
				}
				setState(1025);
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
			setState(1028);
			match(T__64);
			setState(1030);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__65) {
				{
				setState(1029);
				match(T__65);
				}
			}

			setState(1032);
			((SegmentContext)_localctx).name = unrestrictedName();
			setState(1035);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
			case 1:
				{
				setState(1033);
				match(T__63);
				setState(1034);
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
			setState(1047);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__66:
				enterOuterAlt(_localctx, 1);
				{
				setState(1037);
				match(T__66);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBoolean());
				}
				break;
			case T__67:
				enterOuterAlt(_localctx, 2);
				{
				setState(1039);
				match(T__67);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEInt());
				}
				break;
			case T__68:
				enterOuterAlt(_localctx, 3);
				{
				setState(1041);
				match(T__68);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEString());
				}
				break;
			case T__69:
				enterOuterAlt(_localctx, 4);
				{
				setState(1043);
				match(T__69);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBigDecimal());
				}
				break;
			case T__70:
				enterOuterAlt(_localctx, 5);
				{
				setState(1045);
				match(T__70);
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
			setState(1049);
			match(T__71);
			setState(1051);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1050);
				((BodyContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((BodyContext)_localctx).name!=null?_input.getText(((BodyContext)_localctx).name.start,((BodyContext)_localctx).name.stop):null)); 
			setState(1060);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1054);
				match(T__5);
				setState(1056);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1055);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1058);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1059);
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
			setState(1065);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__72) {
				{
				setState(1064);
				((InvariantContext)_localctx).isCallable = match(T__72);
				}
			}

			_localctx.element.getDetails().put("callable", ((InvariantContext)_localctx).isCallable != null ? "true" : "false");
			setState(1068);
			match(T__73);
			setState(1075);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1069);
				((InvariantContext)_localctx).name = identifier();
				setState(1073);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__42) {
					{
					setState(1070);
					match(T__42);
					setState(1071);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1072);
					match(T__43);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InvariantContext)_localctx).name!=null?_input.getText(((InvariantContext)_localctx).name.start,((InvariantContext)_localctx).name.stop):null)); if(((InvariantContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((InvariantContext)_localctx).message!=null?((InvariantContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1084);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1078);
				match(T__5);
				setState(1080);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1079);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1082);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1083);
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
			setState(1088);
			_la = _input.LA(1);
			if ( !(_la==T__74 || _la==T__75) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1095);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1089);
				((PreconditionContext)_localctx).name = identifier();
				setState(1093);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__42) {
					{
					setState(1090);
					match(T__42);
					setState(1091);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1092);
					match(T__43);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PreconditionContext)_localctx).name!=null?_input.getText(((PreconditionContext)_localctx).name.start,((PreconditionContext)_localctx).name.stop):null)); if(((PreconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PreconditionContext)_localctx).message!=null?((PreconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1098);
				match(T__5);
				setState(1100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1099);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1102);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1103);
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
			setState(1108);
			_la = _input.LA(1);
			if ( !(_la==T__76 || _la==T__77) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1109);
				((PostconditionContext)_localctx).name = identifier();
				setState(1113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__42) {
					{
					setState(1110);
					match(T__42);
					setState(1111);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1112);
					match(T__43);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PostconditionContext)_localctx).name!=null?_input.getText(((PostconditionContext)_localctx).name.start,((PostconditionContext)_localctx).name.stop):null)); if(((PostconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PostconditionContext)_localctx).message!=null?((PostconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1118);
				match(T__5);
				setState(1120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1119);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1122);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1123);
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
			setState(1128);
			match(T__78);
			setState(1130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1129);
				((InitialContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InitialContext)_localctx).name!=null?_input.getText(((InitialContext)_localctx).name.start,((InitialContext)_localctx).name.stop):null));
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
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1134);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1137);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1138);
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
			setState(1143);
			match(T__79);
			setState(1145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1144);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((DerivationContext)_localctx).name!=null?_input.getText(((DerivationContext)_localctx).name.start,((DerivationContext)_localctx).name.stop):null));
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
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)))) != 0) || _la==IDENTIFIER) {
					{
					setState(1149);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1152);
				match(T__9);
				}
				}
				break;
			case T__9:
				{
				setState(1153);
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
			setState(1161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__80:
				{
				setState(1158);
				((VisibilityKindContext)_localctx).qualifier = match(T__80);
				}
				break;
			case T__81:
				{
				setState(1159);
				((VisibilityKindContext)_localctx).qualifier = match(T__81);
				}
				break;
			case T__82:
				{
				setState(1160);
				((VisibilityKindContext)_localctx).qualifier = match(T__82);
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
			setState(1448);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1166);
				match(T__83);
				setState(1167);
				expression(0);
				((NoContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1170);
				match(T__84);
				setState(1171);
				expression(0);
				((LoneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1174);
				match(T__85);
				setState(1175);
				expression(0);
				((OneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1178);
				match(T__86);
				setState(1179);
				expression(0);
				((SomeContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1182);
				((InContext)_localctx).left = expression(0);
				setState(1184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__87 || _la==T__88) {
					{
					setState(1183);
					((InContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__87 || _la==T__88) ) {
						((InContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1186);
				match(T__89);
				setState(1187);
				((InContext)_localctx).right = expression(0);
				((InContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1190);
				((EqualContext)_localctx).left = expression(0);
				setState(1192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__87 || _la==T__88) {
					{
					setState(1191);
					((EqualContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__87 || _la==T__88) ) {
						((EqualContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1194);
				match(T__16);
				setState(1195);
				((EqualContext)_localctx).right = expression(0);
				((EqualContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1198);
				((EqContext)_localctx).ileft = intExpression(0);
				setState(1200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__87 || _la==T__88) {
					{
					setState(1199);
					((EqContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__87 || _la==T__88) ) {
						((EqContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1202);
				match(T__16);
				setState(1203);
				((EqContext)_localctx).iright = intExpression(0);
				((EqContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1206);
				((LtContext)_localctx).ileft = intExpression(0);
				setState(1208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__87 || _la==T__88) {
					{
					setState(1207);
					((LtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__87 || _la==T__88) ) {
						((LtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1210);
				match(T__59);
				setState(1211);
				((LtContext)_localctx).iright = intExpression(0);
				((LtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1214);
				((LteContext)_localctx).ileft = intExpression(0);
				setState(1216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__87 || _la==T__88) {
					{
					setState(1215);
					((LteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__87 || _la==T__88) ) {
						((LteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1218);
				match(T__90);
				setState(1219);
				((LteContext)_localctx).iright = intExpression(0);
				((LteContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1222);
				((GtContext)_localctx).ileft = intExpression(0);
				setState(1224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__87 || _la==T__88) {
					{
					setState(1223);
					((GtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__87 || _la==T__88) ) {
						((GtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1226);
				match(T__60);
				setState(1227);
				((GtContext)_localctx).iright = intExpression(0);
				((GtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1230);
				((GteContext)_localctx).ileft = intExpression(0);
				setState(1232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__87 || _la==T__88) {
					{
					setState(1231);
					((GteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__87 || _la==T__88) ) {
						((GteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1234);
				match(T__91);
				setState(1235);
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
				setState(1238);
				match(T__92);
				setState(1239);
				quantifierDeclarations();
				setState(1240);
				match(T__93);
				setState(1241);
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
				setState(1245);
				match(T__94);
				setState(1246);
				match(T__11);
				setState(1247);
				relationId();
				setState(1248);
				match(T__12);
				((AcyclicContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1251);
				match(T__95);
				setState(1252);
				match(T__11);
				setState(1253);
				((FunctionContext)_localctx).rel = relationId();
				setState(1254);
				match(T__5);
				setState(1255);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1256);
				match(T__96);
				setState(1261);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__10:
				case T__13:
				case T__14:
				case T__15:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__21:
				case T__23:
				case T__24:
				case T__25:
				case T__26:
				case T__27:
				case T__28:
				case T__29:
				case T__31:
				case T__33:
				case T__35:
				case T__37:
				case T__38:
				case T__40:
				case T__41:
				case T__42:
				case T__44:
				case T__46:
				case T__51:
				case T__52:
				case T__53:
				case T__55:
				case T__56:
				case T__57:
				case T__58:
				case T__71:
				case T__72:
				case T__73:
				case T__74:
				case T__76:
				case T__78:
				case T__79:
				case T__85:
				case T__102:
				case T__103:
				case T__111:
				case T__112:
				case T__117:
				case T__118:
				case T__119:
				case T__120:
				case T__130:
				case T__131:
				case T__132:
				case IDENTIFIER:
					{
					setState(1258);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__85) {
						{
						setState(1257);
						match(T__85);
						}
					}

					}
					break;
				case T__84:
					{
					setState(1260);
					((FunctionContext)_localctx).partial = match(T__84);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1263);
				((FunctionContext)_localctx).range = expression(0);
				setState(1264);
				match(T__12);
				((FunctionContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1267);
				match(T__97);
				setState(1268);
				match(T__11);
				setState(1269);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1270);
				match(T__2);
				setState(1271);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1272);
				match(T__2);
				setState(1273);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1274);
				match(T__2);
				setState(1275);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1276);
				match(T__12);
				((TotalOrderContext)_localctx).element =  Formula.create(_localctx);
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
				if ( !(_la==T__87 || _la==T__88) ) {
					((NotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1280);
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
				setState(1283);
				match(T__107);
				setState(1284);
				quantifierDeclarations();
				setState(1305);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__93:
					{
					setState(1285);
					match(T__93);
					setState(1295);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
					case 1:
						{
						setState(1286);
						((ForAllContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1287);
						match(T__1);
						setState(1291);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1288);
							((ForAllContext)_localctx).formula = formula(0);
							}
							}
							setState(1293);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1294);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1297);
					match(T__1);
					setState(1301);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1298);
						((ForAllContext)_localctx).formula = formula(0);
						}
						}
						setState(1303);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1304);
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
				setState(1309);
				match(T__86);
				setState(1310);
				quantifierDeclarations();
				setState(1331);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__93:
					{
					setState(1311);
					match(T__93);
					setState(1321);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
					case 1:
						{
						setState(1312);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1313);
						match(T__1);
						setState(1317);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1314);
							((ForSomeContext)_localctx).formula = formula(0);
							}
							}
							setState(1319);
							_errHandler.sync(this);
							_la = _input.LA(1);
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
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1324);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						}
						setState(1329);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1330);
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
				setState(1335);
				match(T__83);
				setState(1336);
				quantifierDeclarations();
				setState(1357);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__93:
					{
					setState(1337);
					match(T__93);
					setState(1347);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
					case 1:
						{
						setState(1338);
						((ForNoContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1339);
						match(T__1);
						setState(1343);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1340);
							((ForNoContext)_localctx).formula = formula(0);
							}
							}
							setState(1345);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1346);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1349);
					match(T__1);
					setState(1353);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1350);
						((ForNoContext)_localctx).formula = formula(0);
						}
						}
						setState(1355);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1356);
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
				setState(1361);
				match(T__85);
				setState(1362);
				quantifierDeclarations();
				setState(1383);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__93:
					{
					setState(1363);
					match(T__93);
					setState(1373);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
					case 1:
						{
						setState(1364);
						((ForOneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1365);
						match(T__1);
						setState(1369);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1366);
							((ForOneContext)_localctx).formula = formula(0);
							}
							}
							setState(1371);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1372);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1375);
					match(T__1);
					setState(1379);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1376);
						((ForOneContext)_localctx).formula = formula(0);
						}
						}
						setState(1381);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1382);
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
				setState(1387);
				match(T__84);
				setState(1388);
				quantifierDeclarations();
				setState(1409);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__93:
					{
					setState(1389);
					match(T__93);
					setState(1399);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
					case 1:
						{
						setState(1390);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1391);
						match(T__1);
						setState(1395);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1392);
							((ForLoneContext)_localctx).formula = formula(0);
							}
							}
							setState(1397);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1398);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1401);
					match(T__1);
					setState(1405);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1402);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						}
						setState(1407);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1408);
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
				setState(1413);
				match(T__108);
				setState(1414);
				letDeclarations();
				setState(1435);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__93:
					{
					setState(1415);
					match(T__93);
					setState(1425);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
					case 1:
						{
						setState(1416);
						((LetContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1417);
						match(T__1);
						setState(1421);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
							{
							{
							setState(1418);
							((LetContext)_localctx).formula = formula(0);
							}
							}
							setState(1423);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1424);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1427);
					match(T__1);
					setState(1431);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__44) | (1L << T__46) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__71 - 72)) | (1L << (T__72 - 72)) | (1L << (T__73 - 72)) | (1L << (T__74 - 72)) | (1L << (T__76 - 72)) | (1L << (T__78 - 72)) | (1L << (T__79 - 72)) | (1L << (T__83 - 72)) | (1L << (T__84 - 72)) | (1L << (T__85 - 72)) | (1L << (T__86 - 72)) | (1L << (T__87 - 72)) | (1L << (T__88 - 72)) | (1L << (T__92 - 72)) | (1L << (T__94 - 72)) | (1L << (T__95 - 72)) | (1L << (T__97 - 72)) | (1L << (T__102 - 72)) | (1L << (T__103 - 72)) | (1L << (T__107 - 72)) | (1L << (T__108 - 72)) | (1L << (T__109 - 72)) | (1L << (T__110 - 72)) | (1L << (T__111 - 72)) | (1L << (T__112 - 72)) | (1L << (T__113 - 72)) | (1L << (T__117 - 72)) | (1L << (T__118 - 72)) | (1L << (T__119 - 72)) | (1L << (T__120 - 72)) | (1L << (T__130 - 72)) | (1L << (T__131 - 72)) | (1L << (T__132 - 72)) | (1L << (INT - 72)))) != 0) || _la==IDENTIFIER) {
						{
						{
						setState(1428);
						((LetContext)_localctx).formula = formula(0);
						}
						}
						setState(1433);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1434);
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
				setState(1439);
				match(T__109);
				((TrueContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1441);
				match(T__110);
				((FalseContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1443);
				match(T__42);
				setState(1444);
				((F_paranthesisContext)_localctx).formula = formula(0);
				setState(1445);
				match(T__43);
				((F_paranthesisContext)_localctx).element =  ((F_paranthesisContext)_localctx).formula.element;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1472);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1470);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1450);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1451);
						((AndContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__98 || _la==T__99) ) {
							((AndContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1452);
						((AndContext)_localctx).fright = ((AndContext)_localctx).formula = formula(14);
						((AndContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1455);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1456);
						((OrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__100 || _la==T__101) ) {
							((OrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1457);
						((OrContext)_localctx).fright = ((OrContext)_localctx).formula = formula(13);
						((OrContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1460);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1461);
						((ImpliesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (T__102 - 103)) | (1L << (T__103 - 103)) | (1L << (T__104 - 103)))) != 0)) ) {
							((ImpliesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1462);
						((ImpliesContext)_localctx).fright = ((ImpliesContext)_localctx).formula = formula(11);
						((ImpliesContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1465);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1466);
						((IffContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__105 || _la==T__106) ) {
							((IffContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1467);
						((IffContext)_localctx).fright = ((IffContext)_localctx).formula = formula(10);
						((IffContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1474);
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
			setState(1519);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__111:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1476);
				match(T__111);
				setState(1477);
				((TransposeContext)_localctx).expression = expression(18);
				((TransposeContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__112:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1480);
				match(T__112);
				setState(1481);
				((ClosureContext)_localctx).expression = expression(17);
				((ClosureContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__46:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1484);
				match(T__46);
				setState(1485);
				((ReflexiveContext)_localctx).expression = expression(16);
				((ReflexiveContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__1:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1488);
				match(T__1);
				setState(1489);
				comprehensionDeclarations();
				setState(1490);
				match(T__93);
				setState(1491);
				formula(0);
				setState(1492);
				match(T__3);
				((ComprehensionContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__102:
			case T__103:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1495);
				((IfExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__102 || _la==T__103) ) {
					((IfExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1496);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1497);
				match(T__115);
				setState(1498);
				((IfExpressionContext)_localctx).thenExpr = ((IfExpressionContext)_localctx).expression = expression(0);
				setState(1499);
				match(T__116);
				setState(1500);
				((IfExpressionContext)_localctx).elseExpr = ((IfExpressionContext)_localctx).expression = expression(7);
				((IfExpressionContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__117:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1503);
				match(T__117);
				((IdenContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__118:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1505);
				match(T__118);
				((NoneContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__119:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1507);
				match(T__119);
				((UnivContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__120:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1509);
				match(T__120);
				((IntsContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__42:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1511);
				match(T__42);
				setState(1512);
				((E_paranthesisContext)_localctx).expression = expression(0);
				setState(1513);
				match(T__43);
				((E_paranthesisContext)_localctx).element =  ((E_paranthesisContext)_localctx).expression.element;
				}
				break;
			case T__10:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__31:
			case T__33:
			case T__35:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__44:
			case T__51:
			case T__52:
			case T__53:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__71:
			case T__72:
			case T__73:
			case T__74:
			case T__76:
			case T__78:
			case T__79:
			case T__130:
			case T__131:
			case T__132:
			case IDENTIFIER:
				{
				_localctx = new TypeRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1516);
				pathName(_localctx.element);
				((TypeRefContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1565);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,207,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1563);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1521);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1522);
						match(T__47);
						setState(1523);
						((UnionContext)_localctx).right = ((UnionContext)_localctx).expression = expression(16);
						((UnionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1526);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1527);
						match(T__61);
						setState(1528);
						((IntersectionContext)_localctx).right = ((IntersectionContext)_localctx).expression = expression(15);
						((IntersectionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1531);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1532);
						match(T__113);
						setState(1533);
						((DifferenceContext)_localctx).right = ((DifferenceContext)_localctx).expression = expression(14);
						((DifferenceContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1536);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1537);
						match(T__63);
						setState(1538);
						((JoinContext)_localctx).right = ((JoinContext)_localctx).expression = expression(13);
						((JoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1541);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1543);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)) | (1L << (T__129 - 85)))) != 0)) {
							{
							setState(1542);
							((ProductContext)_localctx).leftMult = mult();
							}
						}

						setState(1545);
						match(T__96);
						setState(1547);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)) | (1L << (T__129 - 85)))) != 0)) {
							{
							setState(1546);
							((ProductContext)_localctx).rightMult = mult();
							}
						}

						setState(1549);
						((ProductContext)_localctx).right = ((ProductContext)_localctx).expression = expression(10);
						((ProductContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1552);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1553);
						match(T__114);
						setState(1554);
						((OverrideContext)_localctx).right = ((OverrideContext)_localctx).expression = expression(10);
						((OverrideContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 7:
						{
						_localctx = new BoxJoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxJoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1557);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1558);
						match(T__11);
						setState(1559);
						((BoxJoinContext)_localctx).left = ((BoxJoinContext)_localctx).expression = expression(0);
						setState(1560);
						match(T__12);
						((BoxJoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1567);
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
			setState(1595);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__102:
			case T__103:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1569);
				((IfIntExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__102 || _la==T__103) ) {
					((IfIntExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1570);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1571);
				match(T__115);
				setState(1572);
				((IfIntExpressionContext)_localctx).thenExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(0);
				setState(1573);
				match(T__116);
				setState(1574);
				((IfIntExpressionContext)_localctx).elseExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(10);
				((IfIntExpressionContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__92:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1577);
				match(T__92);
				setState(1578);
				expression(0);
				((SumContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__36:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1581);
				match(T__36);
				setState(1582);
				expression(0);
				((CountContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__113:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1586);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__113) {
					{
					setState(1585);
					((IntConstantContext)_localctx).sign = match(T__113);
					}
				}

				setState(1588);
				match(INT);
				((IntConstantContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__42:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1590);
				match(T__42);
				setState(1591);
				((I_paranthesisContext)_localctx).intExpression = intExpression(0);
				setState(1592);
				match(T__43);
				((I_paranthesisContext)_localctx).element =  ((I_paranthesisContext)_localctx).intExpression.element;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1624);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1622);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntExpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1597);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1598);
						_la = _input.LA(1);
						if ( !(_la==T__47 || _la==T__121) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1599);
						((PlusContext)_localctx).iright = ((PlusContext)_localctx).intExpression = intExpression(8);
						((PlusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntExpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1602);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1603);
						_la = _input.LA(1);
						if ( !(_la==T__113 || _la==T__122) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1604);
						((MinusContext)_localctx).iright = ((MinusContext)_localctx).intExpression = intExpression(7);
						((MinusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntExpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1607);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1608);
						_la = _input.LA(1);
						if ( !(_la==T__46 || _la==T__123) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1609);
						((MultiplyContext)_localctx).iright = ((MultiplyContext)_localctx).intExpression = intExpression(6);
						((MultiplyContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntExpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1612);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1613);
						_la = _input.LA(1);
						if ( !(_la==T__124 || _la==T__125) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1614);
						((DivideContext)_localctx).iright = ((DivideContext)_localctx).intExpression = intExpression(5);
						((DivideContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntExpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1617);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1618);
						_la = _input.LA(1);
						if ( !(_la==T__126 || _la==T__127) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1619);
						((ModuloContext)_localctx).iright = ((ModuloContext)_localctx).intExpression = intExpression(4);
						((ModuloContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1626);
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
			setState(1627);
			quantifierDeclaration();
			setState(1632);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1628);
				match(T__2);
				setState(1629);
				quantifierDeclaration();
				}
				}
				setState(1634);
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
			setState(1701);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1636);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__128) {
					{
					setState(1635);
					((OneOfContext)_localctx).disj = match(T__128);
					}
				}

				setState(1638);
				((OneOfContext)_localctx).variable = variable();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
				setState(1643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1639);
					match(T__2);
					setState(1640);
					((OneOfContext)_localctx).variable = variable();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
					}
					}
					setState(1645);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1646);
				match(T__5);
				setState(1648);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__85) {
					{
					setState(1647);
					match(T__85);
					}
				}

				setState(1650);
				expression(0);
				((OneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1654);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__128) {
					{
					setState(1653);
					((LoneOfContext)_localctx).disj = match(T__128);
					}
				}

				setState(1656);
				((LoneOfContext)_localctx).variable = variable();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
				setState(1661);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1657);
					match(T__2);
					setState(1658);
					((LoneOfContext)_localctx).variable = variable();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
					}
					}
					setState(1663);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1664);
				match(T__5);
				setState(1665);
				match(T__84);
				setState(1666);
				expression(0);
				((LoneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__128) {
					{
					setState(1669);
					((SomeOfContext)_localctx).disj = match(T__128);
					}
				}

				setState(1672);
				((SomeOfContext)_localctx).variable = variable();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
				setState(1677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1673);
					match(T__2);
					setState(1674);
					((SomeOfContext)_localctx).variable = variable();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
					}
					}
					setState(1679);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1680);
				match(T__5);
				setState(1681);
				match(T__86);
				setState(1682);
				expression(0);
				((SomeOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__128) {
					{
					setState(1685);
					((SetOfContext)_localctx).disj = match(T__128);
					}
				}

				setState(1688);
				((SetOfContext)_localctx).variable = variable();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
				setState(1693);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1689);
					match(T__2);
					setState(1690);
					((SetOfContext)_localctx).variable = variable();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
					}
					}
					setState(1695);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1696);
				match(T__5);
				setState(1697);
				match(T__129);
				setState(1698);
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
			setState(1703);
			letDeclaration();
			setState(1708);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1704);
				match(T__2);
				setState(1705);
				letDeclaration();
				}
				}
				setState(1710);
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
			setState(1711);
			((LetDeclarationContext)_localctx).variable = variable();
			((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
			setState(1716);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1712);
				match(T__2);
				setState(1713);
				((LetDeclarationContext)_localctx).variable = variable();
				((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
				}
				}
				setState(1718);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1719);
			match(T__16);
			setState(1720);
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
			setState(1723);
			comprehensionDeclaration();
			setState(1728);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1724);
				match(T__2);
				setState(1725);
				comprehensionDeclaration();
				}
				}
				setState(1730);
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
			setState(1732);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__128) {
				{
				setState(1731);
				((ComprehensionDeclarationContext)_localctx).disj = match(T__128);
				}
			}

			{
			setState(1734);
			((ComprehensionDeclarationContext)_localctx).variable = variable();
			((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
			setState(1739);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1735);
				match(T__2);
				setState(1736);
				((ComprehensionDeclarationContext)_localctx).variable = variable();
				((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
				}
				}
				setState(1741);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1742);
			match(T__5);
			setState(1744);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__85) {
				{
				setState(1743);
				match(T__85);
				}
			}

			setState(1746);
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
			setState(1750);
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
			setState(1752);
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
			setState(1755);
			_la = _input.LA(1);
			if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)) | (1L << (T__129 - 85)))) != 0)) ) {
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
			setState(1799);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1757);
				identifier();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(1758);
				match(T__17);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(1759);
				match(T__26);
				}
				break;
			case T__71:
				enterOuterAlt(_localctx, 4);
				{
				setState(1760);
				match(T__71);
				}
				break;
			case T__72:
				enterOuterAlt(_localctx, 5);
				{
				setState(1761);
				match(T__72);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 6);
				{
				setState(1762);
				match(T__18);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 7);
				{
				setState(1763);
				match(T__37);
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 8);
				{
				setState(1764);
				match(T__52);
				}
				break;
			case T__130:
				enterOuterAlt(_localctx, 9);
				{
				setState(1765);
				match(T__130);
				}
				break;
			case T__79:
				enterOuterAlt(_localctx, 10);
				{
				setState(1766);
				match(T__79);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 11);
				{
				setState(1767);
				match(T__27);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 12);
				{
				setState(1768);
				match(T__55);
				}
				break;
			case T__131:
				enterOuterAlt(_localctx, 13);
				{
				setState(1769);
				match(T__131);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 14);
				{
				setState(1770);
				match(T__20);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 15);
				{
				setState(1771);
				match(T__28);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 16);
				{
				setState(1772);
				match(T__14);
				}
				break;
			case T__78:
				enterOuterAlt(_localctx, 17);
				{
				setState(1773);
				match(T__78);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 18);
				{
				setState(1774);
				match(T__19);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 19);
				{
				setState(1775);
				match(T__40);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 20);
				{
				setState(1776);
				match(T__13);
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 21);
				{
				setState(1777);
				match(T__41);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 22);
				{
				setState(1778);
				match(T__29);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 23);
				{
				setState(1779);
				match(T__15);
				}
				break;
			case T__76:
				enterOuterAlt(_localctx, 24);
				{
				setState(1780);
				match(T__76);
				}
				break;
			case T__74:
				enterOuterAlt(_localctx, 25);
				{
				setState(1781);
				match(T__74);
				}
				break;
			case T__51:
				enterOuterAlt(_localctx, 26);
				{
				setState(1782);
				match(T__51);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 27);
				{
				setState(1783);
				match(T__35);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 28);
				{
				setState(1784);
				match(T__25);
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 29);
				{
				setState(1785);
				match(T__58);
				}
				break;
			case T__132:
				enterOuterAlt(_localctx, 30);
				{
				setState(1786);
				match(T__132);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 31);
				{
				setState(1787);
				match(T__38);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 32);
				{
				setState(1788);
				match(T__21);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 33);
				{
				setState(1789);
				match(T__44);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 34);
				{
				setState(1790);
				match(T__23);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 35);
				{
				setState(1791);
				match(T__31);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 36);
				{
				setState(1792);
				match(T__33);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 37);
				{
				setState(1793);
				match(T__24);
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 38);
				{
				setState(1794);
				match(T__73);
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 39);
				{
				setState(1795);
				match(T__56);
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 40);
				{
				setState(1796);
				match(T__53);
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 41);
				{
				setState(1797);
				match(T__57);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 42);
				{
				setState(1798);
				match(T__10);
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
			setState(1801);
			_la = _input.LA(1);
			if ( !(_la==T__109 || _la==T__110) ) {
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
			setState(1804);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__47 || _la==T__113) {
				{
				setState(1803);
				_la = _input.LA(1);
				if ( !(_la==T__47 || _la==T__113) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(1807);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
			case 1:
				{
				setState(1806);
				match(INT);
				}
				break;
			}
			setState(1810);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__63) {
				{
				setState(1809);
				match(T__63);
				}
			}

			setState(1812);
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
			setState(1814);
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
			setState(1816);
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
			setState(1818);
			match(T__133);
			}
		}
		catch (RecognitionException re) {
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
			setState(1820);
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
			setState(1822);
			_la = _input.LA(1);
			if ( !(_la==T__46 || _la==INT) ) {
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
			setState(1824);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0091\u0725\4\2\t"+
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
		"\3\6\3\6\5\6\u00bc\n\6\3\6\3\6\3\6\3\6\7\6\u00c2\n\6\f\6\16\6\u00c5\13"+
		"\6\3\6\3\6\3\6\5\6\u00ca\n\6\3\7\3\7\3\7\3\7\3\7\7\7\u00d1\n\7\f\7\16"+
		"\7\u00d4\13\7\3\7\3\7\5\7\u00d8\n\7\5\7\u00da\n\7\3\b\3\b\5\b\u00de\n"+
		"\b\3\t\3\t\3\t\3\t\7\t\u00e4\n\t\f\t\16\t\u00e7\13\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\7\n\u00f0\n\n\f\n\16\n\u00f3\13\n\3\n\3\n\5\n\u00f7\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00ff\n\13\3\f\5\f\u0102\n\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u0109\n\f\3\f\3\f\7\f\u010d\n\f\f\f\16\f\u0110\13\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u011b\n\r\3\r\3\r\3\r\3\r\3\16\5"+
		"\16\u0122\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u013d\n\16\f\16\16\16\u0140\13\16\3\16\3\16\5\16\u0144\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u014f\n\17\3\20\5\20\u0152"+
		"\n\20\3\20\3\20\5\20\u0156\n\20\3\20\3\20\5\20\u015a\n\20\3\20\3\20\5"+
		"\20\u015e\n\20\3\20\3\20\3\20\5\20\u0163\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\7\20\u016a\n\20\f\20\16\20\u016d\13\20\5\20\u016f\n\20\3\20\3\20\3\20"+
		"\5\20\u0174\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u0184\n\20\f\20\16\20\u0187\13\20\3\20\3\20\5\20"+
		"\u018b\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0193\n\21\3\22\5\22\u0196"+
		"\n\22\3\22\3\22\5\22\u019a\n\22\3\22\3\22\5\22\u019e\n\22\3\22\5\22\u01a1"+
		"\n\22\3\22\5\22\u01a4\n\22\3\22\5\22\u01a7\n\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\5\22\u01b0\n\22\3\22\3\22\3\22\5\22\u01b5\n\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u01c1\n\22\3\22\5\22\u01c4"+
		"\n\22\6\22\u01c6\n\22\r\22\16\22\u01c7\3\22\5\22\u01cb\n\22\3\22\3\22"+
		"\3\22\3\22\7\22\u01d1\n\22\f\22\16\22\u01d4\13\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u01dc\n\22\3\22\3\22\3\22\7\22\u01e1\n\22\f\22\16\22\u01e4"+
		"\13\22\3\22\3\22\5\22\u01e8\n\22\3\22\3\22\3\23\5\23\u01ed\n\23\3\23\3"+
		"\23\5\23\u01f1\n\23\3\23\3\23\5\23\u01f5\n\23\3\23\5\23\u01f8\n\23\3\23"+
		"\5\23\u01fb\n\23\3\23\5\23\u01fe\n\23\3\23\3\23\3\23\3\23\3\23\3\23\5"+
		"\23\u0206\n\23\3\23\3\23\3\23\3\23\5\23\u020c\n\23\3\23\3\23\3\23\5\23"+
		"\u0211\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u021f\n\23\3\23\5\23\u0222\n\23\6\23\u0224\n\23\r\23\16\23\u0225"+
		"\3\23\5\23\u0229\n\23\3\23\3\23\3\23\3\23\3\23\7\23\u0230\n\23\f\23\16"+
		"\23\u0233\13\23\3\23\3\23\5\23\u0237\n\23\3\23\3\23\3\23\7\23\u023c\n"+
		"\23\f\23\16\23\u023f\13\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0247\n"+
		"\23\3\23\3\23\3\23\7\23\u024c\n\23\f\23\16\23\u024f\13\23\3\23\3\23\5"+
		"\23\u0253\n\23\3\23\3\23\3\24\5\24\u0258\n\24\3\24\3\24\5\24\u025c\n\24"+
		"\3\24\3\24\5\24\u0260\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0269"+
		"\n\24\f\24\16\24\u026c\13\24\5\24\u026e\n\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0276\n\24\5\24\u0278\n\24\3\24\3\24\3\24\3\24\3\24\3\24\7"+
		"\24\u0280\n\24\f\24\16\24\u0283\13\24\5\24\u0285\n\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\5\24\u028d\n\24\3\24\5\24\u0290\n\24\6\24\u0292\n\24\r\24"+
		"\16\24\u0293\3\24\5\24\u0297\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\7\24\u02a6\n\24\f\24\16\24\u02a9\13\24\3"+
		"\24\3\24\5\24\u02ad\n\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u02bd\n\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u02c5\n\27\3\27\5\27\u02c8\n\27\6\27\u02ca\n\27\r\27\16\27\u02cb"+
		"\3\27\5\27\u02cf\n\27\3\27\3\27\7\27\u02d3\n\27\f\27\16\27\u02d6\13\27"+
		"\3\27\3\27\5\27\u02da\n\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u02e2\n"+
		"\30\3\30\5\30\u02e5\n\30\3\30\3\30\5\30\u02e9\n\30\3\30\3\30\3\30\3\31"+
		"\5\31\u02ef\n\31\3\31\3\31\5\31\u02f3\n\31\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u02fa\n\31\3\31\3\31\3\31\5\31\u02ff\n\31\3\31\3\31\3\31\3\31\5\31"+
		"\u0305\n\31\3\31\5\31\u0308\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7"+
		"\31\u0311\n\31\f\31\16\31\u0314\13\31\3\31\3\31\5\31\u0318\n\31\3\31\3"+
		"\31\3\32\5\32\u031d\n\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0325\n\32"+
		"\3\32\3\32\3\32\5\32\u032a\n\32\3\32\3\32\3\32\3\32\5\32\u0330\n\32\3"+
		"\32\5\32\u0333\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u033f\n\32\f\32\16\32\u0342\13\32\3\32\3\32\5\32\u0346\n\32\3\32"+
		"\3\32\3\33\3\33\3\33\5\33\u034d\n\33\3\33\3\33\3\33\3\33\5\33\u0353\n"+
		"\33\3\33\3\33\3\33\7\33\u0358\n\33\f\33\16\33\u035b\13\33\3\33\3\33\3"+
		"\33\5\33\u0360\n\33\3\34\3\34\5\34\u0364\n\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\7\34\u036c\n\34\f\34\16\34\u036f\13\34\3\34\3\34\5\34\u0373\n\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\6\34\u0380\n\34"+
		"\r\34\16\34\u0381\3\34\3\34\3\34\5\34\u0387\n\34\3\35\5\35\u038a\n\35"+
		"\3\35\3\35\5\35\u038e\n\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u0398\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\5\37\u03a6\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u03b1\n \3!\3!\3!\3!\3"+
		"\"\3\"\3\"\3\"\7\"\u03bb\n\"\f\"\16\"\u03be\13\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3#\3#\7#\u03c9\n#\f#\16#\u03cc\13#\5#\u03ce\n#\3#\3#\3$\3$\3$\3$\3$"+
		"\3$\5$\u03d8\n$\3%\3%\3%\3%\3%\7%\u03df\n%\f%\16%\u03e2\13%\3%\3%\5%\u03e6"+
		"\n%\3&\3&\3&\3&\3&\3&\5&\u03ee\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u03f7"+
		"\n\'\3(\3(\3(\5(\u03fc\n(\3(\7(\u03ff\n(\f(\16(\u0402\13(\3(\5(\u0405"+
		"\n(\3)\3)\5)\u0409\n)\3)\3)\3)\5)\u040e\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\5*\u041a\n*\3+\3+\5+\u041e\n+\3+\3+\3+\5+\u0423\n+\3+\3+\5+\u0427"+
		"\n+\3+\3+\3,\5,\u042c\n,\3,\3,\3,\3,\3,\3,\5,\u0434\n,\5,\u0436\n,\3,"+
		"\3,\3,\5,\u043b\n,\3,\3,\5,\u043f\n,\3,\3,\3-\3-\3-\3-\3-\5-\u0448\n-"+
		"\5-\u044a\n-\3-\3-\3-\5-\u044f\n-\3-\3-\5-\u0453\n-\3-\3-\3.\3.\3.\3."+
		"\3.\5.\u045c\n.\5.\u045e\n.\3.\3.\3.\5.\u0463\n.\3.\3.\5.\u0467\n.\3."+
		"\3.\3/\3/\5/\u046d\n/\3/\3/\3/\5/\u0472\n/\3/\3/\5/\u0476\n/\3/\3/\3\60"+
		"\3\60\5\60\u047c\n\60\3\60\3\60\3\60\5\60\u0481\n\60\3\60\3\60\5\60\u0485"+
		"\n\60\3\60\3\60\3\61\3\61\3\61\5\61\u048c\n\61\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\5\62\u04a3\n\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u04ab\n"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u04b3\n\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\5\62\u04bb\n\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u04c3\n"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u04cb\n\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\5\62\u04d3\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\5\62\u04ed\n\62\3\62\5\62\u04f0\n\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u050c\n\62\f\62\16\62\u050f\13"+
		"\62\3\62\5\62\u0512\n\62\3\62\3\62\7\62\u0516\n\62\f\62\16\62\u0519\13"+
		"\62\3\62\5\62\u051c\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62"+
		"\u0526\n\62\f\62\16\62\u0529\13\62\3\62\5\62\u052c\n\62\3\62\3\62\7\62"+
		"\u0530\n\62\f\62\16\62\u0533\13\62\3\62\5\62\u0536\n\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\7\62\u0540\n\62\f\62\16\62\u0543\13\62\3\62"+
		"\5\62\u0546\n\62\3\62\3\62\7\62\u054a\n\62\f\62\16\62\u054d\13\62\3\62"+
		"\5\62\u0550\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u055a\n"+
		"\62\f\62\16\62\u055d\13\62\3\62\5\62\u0560\n\62\3\62\3\62\7\62\u0564\n"+
		"\62\f\62\16\62\u0567\13\62\3\62\5\62\u056a\n\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\7\62\u0574\n\62\f\62\16\62\u0577\13\62\3\62\5\62\u057a"+
		"\n\62\3\62\3\62\7\62\u057e\n\62\f\62\16\62\u0581\13\62\3\62\5\62\u0584"+
		"\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u058e\n\62\f\62\16"+
		"\62\u0591\13\62\3\62\5\62\u0594\n\62\3\62\3\62\7\62\u0598\n\62\f\62\16"+
		"\62\u059b\13\62\3\62\5\62\u059e\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u05ab\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62"+
		"\u05c1\n\62\f\62\16\62\u05c4\13\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u05f2\n\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u060a\n\63\3\63\3\63\5\63\u060e\n"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\7\63\u061e\n\63\f\63\16\63\u0621\13\63\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0635"+
		"\n\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u063e\n\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\7\64\u0659\n\64\f\64\16\64\u065c"+
		"\13\64\3\65\3\65\3\65\7\65\u0661\n\65\f\65\16\65\u0664\13\65\3\66\5\66"+
		"\u0667\n\66\3\66\3\66\3\66\7\66\u066c\n\66\f\66\16\66\u066f\13\66\3\66"+
		"\3\66\5\66\u0673\n\66\3\66\3\66\3\66\3\66\5\66\u0679\n\66\3\66\3\66\3"+
		"\66\7\66\u067e\n\66\f\66\16\66\u0681\13\66\3\66\3\66\3\66\3\66\3\66\3"+
		"\66\5\66\u0689\n\66\3\66\3\66\3\66\7\66\u068e\n\66\f\66\16\66\u0691\13"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0699\n\66\3\66\3\66\3\66\7\66"+
		"\u069e\n\66\f\66\16\66\u06a1\13\66\3\66\3\66\3\66\3\66\3\66\5\66\u06a8"+
		"\n\66\3\67\3\67\3\67\7\67\u06ad\n\67\f\67\16\67\u06b0\13\67\38\38\38\7"+
		"8\u06b5\n8\f8\168\u06b8\138\38\38\38\38\39\39\39\79\u06c1\n9\f9\169\u06c4"+
		"\139\3:\5:\u06c7\n:\3:\3:\3:\7:\u06cc\n:\f:\16:\u06cf\13:\3:\3:\5:\u06d3"+
		"\n:\3:\3:\3:\3:\3;\3;\3<\3<\3<\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\3>\5>\u070a\n>\3?\3?\3@\5@\u070f\n@\3@\5@\u0712"+
		"\n@\3@\5@\u0715\n@\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3F\2\5bd"+
		"fG\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD"+
		"FHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\2\26"+
		"\3\2\61\63\3\2\u008d\u008e\4\2\27\27AA\3\2MN\3\2OP\3\2Z[\3\2ef\3\2gh\3"+
		"\2ik\3\2lm\3\2ij\4\2\62\62||\4\2tt}}\4\2\61\61~~\3\2\177\u0080\3\2\u0081"+
		"\u0082\4\2WY\u0084\u0084\3\2pq\4\2\62\62tt\4\2\61\61\u0089\u0089\u084f"+
		"\2\u008c\3\2\2\2\4\u00a4\3\2\2\2\6\u00a9\3\2\2\2\b\u00b1\3\2\2\2\n\u00b9"+
		"\3\2\2\2\f\u00cb\3\2\2\2\16\u00dd\3\2\2\2\20\u00df\3\2\2\2\22\u00f6\3"+
		"\2\2\2\24\u00fe\3\2\2\2\26\u0101\3\2\2\2\30\u0116\3\2\2\2\32\u0121\3\2"+
		"\2\2\34\u014e\3\2\2\2\36\u0151\3\2\2\2 \u0192\3\2\2\2\"\u0195\3\2\2\2"+
		"$\u01ec\3\2\2\2&\u0257\3\2\2\2(\u02b0\3\2\2\2*\u02b3\3\2\2\2,\u02b6\3"+
		"\2\2\2.\u02dd\3\2\2\2\60\u02ee\3\2\2\2\62\u031c\3\2\2\2\64\u034c\3\2\2"+
		"\2\66\u0361\3\2\2\28\u0389\3\2\2\2:\u0397\3\2\2\2<\u03a5\3\2\2\2>\u03b0"+
		"\3\2\2\2@\u03b2\3\2\2\2B\u03b6\3\2\2\2D\u03c1\3\2\2\2F\u03d7\3\2\2\2H"+
		"\u03d9\3\2\2\2J\u03ed\3\2\2\2L\u03ef\3\2\2\2N\u03f8\3\2\2\2P\u0406\3\2"+
		"\2\2R\u0419\3\2\2\2T\u041b\3\2\2\2V\u042b\3\2\2\2X\u0442\3\2\2\2Z\u0456"+
		"\3\2\2\2\\\u046a\3\2\2\2^\u0479\3\2\2\2`\u048b\3\2\2\2b\u05aa\3\2\2\2"+
		"d\u05f1\3\2\2\2f\u063d\3\2\2\2h\u065d\3\2\2\2j\u06a7\3\2\2\2l\u06a9\3"+
		"\2\2\2n\u06b1\3\2\2\2p\u06bd\3\2\2\2r\u06c6\3\2\2\2t\u06d8\3\2\2\2v\u06da"+
		"\3\2\2\2x\u06dd\3\2\2\2z\u0709\3\2\2\2|\u070b\3\2\2\2~\u070e\3\2\2\2\u0080"+
		"\u0718\3\2\2\2\u0082\u071a\3\2\2\2\u0084\u071c\3\2\2\2\u0086\u071e\3\2"+
		"\2\2\u0088\u0720\3\2\2\2\u008a\u0722\3\2\2\2\u008c\u008d\7\3\2\2\u008d"+
		"\u008e\7\4\2\2\u008e\u0093\5\4\3\2\u008f\u0090\7\5\2\2\u0090\u0092\5\4"+
		"\3\2\u0091\u008f\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\6"+
		"\2\2\u0097\3\3\2\2\2\u0098\u0099\7\7\2\2\u0099\u009a\7\b\2\2\u009a\u00a5"+
		"\7\u0089\2\2\u009b\u009c\7\t\2\2\u009c\u009d\7\b\2\2\u009d\u00a5\7\u0089"+
		"\2\2\u009e\u009f\7\n\2\2\u009f\u00a0\7\b\2\2\u00a0\u00a5\7\u0089\2\2\u00a1"+
		"\u00a2\7\13\2\2\u00a2\u00a3\7\b\2\2\u00a3\u00a5\7\u0089\2\2\u00a4\u0098"+
		"\3\2\2\2\u00a4\u009b\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a5"+
		"\5\3\2\2\2\u00a6\u00a8\5\30\r\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2"+
		"\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00af\5\b\5\2\u00ad\u00b0\5\n\6\2\u00ae\u00b0\7\f\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\7\3\2\2\2\u00b1\u00b5\7\r\2\2"+
		"\u00b2\u00b3\5z>\2\u00b3\u00b4\7\b\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b2"+
		"\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7\u008d\2"+
		"\2\u00b8\t\3\2\2\2\u00b9\u00bb\5N(\2\u00ba\u00bc\5\24\13\2\u00bb\u00ba"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00c9\3\2\2\2\u00bd\u00be\7\4\2\2\u00be"+
		"\u00c3\5\f\7\2\u00bf\u00c0\7\5\2\2\u00c0\u00c2\5\f\7\2\u00c1\u00bf\3\2"+
		"\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7\6\2\2\u00c7\u00ca\3\2"+
		"\2\2\u00c8\u00ca\7\f\2\2\u00c9\u00bd\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca"+
		"\13\3\2\2\2\u00cb\u00d9\5z>\2\u00cc\u00d7\7\b\2\2\u00cd\u00d8\5\16\b\2"+
		"\u00ce\u00d2\7\4\2\2\u00cf\u00d1\5\n\6\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4"+
		"\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00d8\7\6\2\2\u00d6\u00d8\5\22\n\2\u00d7\u00cd\3"+
		"\2\2\2\u00d7\u00ce\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9"+
		"\u00cc\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\r\3\2\2\2\u00db\u00de\5\24\13"+
		"\2\u00dc\u00de\5\20\t\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de"+
		"\17\3\2\2\2\u00df\u00e0\7\16\2\2\u00e0\u00e5\5\16\b\2\u00e1\u00e2\7\5"+
		"\2\2\u00e2\u00e4\5\16\b\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2"+
		"\2\2\u00e8\u00e9\7\17\2\2\u00e9\21\3\2\2\2\u00ea\u00f7\5N(\2\u00eb\u00ec"+
		"\7\16\2\2\u00ec\u00f1\5N(\2\u00ed\u00ee\7\5\2\2\u00ee\u00f0\5N(\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7\17\2\2\u00f5"+
		"\u00f7\3\2\2\2\u00f6\u00ea\3\2\2\2\u00f6\u00eb\3\2\2\2\u00f7\23\3\2\2"+
		"\2\u00f8\u00ff\5\u0086D\2\u00f9\u00ff\5~@\2\u00fa\u00ff\5\u0080A\2\u00fb"+
		"\u00ff\5\u0082B\2\u00fc\u00ff\5|?\2\u00fd\u00ff\5\u0084C\2\u00fe\u00f8"+
		"\3\2\2\2\u00fe\u00f9\3\2\2\2\u00fe\u00fa\3\2\2\2\u00fe\u00fb\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\25\3\2\2\2\u0100\u0102\5\2\2"+
		"\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0108"+
		"\b\f\1\2\u0104\u0105\7\20\2\2\u0105\u0106\5\u0086D\2\u0106\u0107\7\f\2"+
		"\2\u0107\u0109\3\2\2\2\u0108\u0104\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u010e\b\f\1\2\u010b\u010d\5\30\r\2\u010c\u010b\3\2\2\2"+
		"\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\5\32\16\2\u0112\u0113\b\f\1\2"+
		"\u0113\u0114\3\2\2\2\u0114\u0115\b\f\1\2\u0115\27\3\2\2\2\u0116\u011a"+
		"\7\21\2\2\u0117\u0118\5\u0086D\2\u0118\u0119\7\b\2\2\u0119\u011b\3\2\2"+
		"\2\u011a\u0117\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d"+
		"\7\u008d\2\2\u011d\u011e\7\f\2\2\u011e\u011f\b\r\1\2\u011f\31\3\2\2\2"+
		"\u0120\u0122\5`\61\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123\u0124\b\16\1\2\u0124\u0125\7\22\2\2\u0125\u0126\5z>\2\u0126"+
		"\u0127\b\16\1\2\u0127\u0128\b\16\1\2\u0128\u0129\7\b\2\2\u0129\u012a\5"+
		"\u0086D\2\u012a\u012b\3\2\2\2\u012b\u012c\7\23\2\2\u012c\u012d\7\u008d"+
		"\2\2\u012d\u012e\3\2\2\2\u012e\u0143\b\16\1\2\u012f\u013e\7\4\2\2\u0130"+
		"\u0131\5\66\34\2\u0131\u0132\b\16\1\2\u0132\u013d\3\2\2\2\u0133\u0134"+
		"\5\32\16\2\u0134\u0135\b\16\1\2\u0135\u013d\3\2\2\2\u0136\u0137\5\34\17"+
		"\2\u0137\u0138\b\16\1\2\u0138\u013d\3\2\2\2\u0139\u013a\5V,\2\u013a\u013b"+
		"\b\16\1\2\u013b\u013d\3\2\2\2\u013c\u0130\3\2\2\2\u013c\u0133\3\2\2\2"+
		"\u013c\u0136\3\2\2\2\u013c\u0139\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c"+
		"\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u013e\3\2\2\2\u0141"+
		"\u0144\7\6\2\2\u0142\u0144\7\f\2\2\u0143\u012f\3\2\2\2\u0143\u0142\3\2"+
		"\2\2\u0144\33\3\2\2\2\u0145\u0146\5\36\20\2\u0146\u0147\b\17\1\2\u0147"+
		"\u014f\3\2\2\2\u0148\u0149\5\60\31\2\u0149\u014a\b\17\1\2\u014a\u014f"+
		"\3\2\2\2\u014b\u014c\5\62\32\2\u014c\u014d\b\17\1\2\u014d\u014f\3\2\2"+
		"\2\u014e\u0145\3\2\2\2\u014e\u0148\3\2\2\2\u014e\u014b\3\2\2\2\u014f\35"+
		"\3\2\2\2\u0150\u0152\5`\61\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0159\b\20\1\2\u0154\u0156\7\24\2\2\u0155\u0154\3"+
		"\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u015a\7\25\2\2\u0158"+
		"\u015a\7\26\2\2\u0159\u0155\3\2\2\2\u0159\u0158\3\2\2\2\u015a\u015b\3"+
		"\2\2\2\u015b\u015d\b\20\1\2\u015c\u015e\5z>\2\u015d\u015c\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\b\20\1\2\u0160\u0162\b"+
		"\20\1\2\u0161\u0163\5B\"\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164\u016e\b\20\1\2\u0165\u0166\7\27\2\2\u0166\u016b\5"+
		"*\26\2\u0167\u0168\7\5\2\2\u0168\u016a\5*\26\2\u0169\u0167\3\2\2\2\u016a"+
		"\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016f\3\2"+
		"\2\2\u016d\u016b\3\2\2\2\u016e\u0165\3\2\2\2\u016e\u016f\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0173\b\20\1\2\u0171\u0172\7\b\2\2\u0172\u0174\7"+
		"\u008d\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2\2\2"+
		"\u0175\u018a\b\20\1\2\u0176\u0185\7\4\2\2\u0177\u0178\5\66\34\2\u0178"+
		"\u0179\b\20\1\2\u0179\u0184\3\2\2\2\u017a\u017b\5&\24\2\u017b\u017c\b"+
		"\20\1\2\u017c\u0184\3\2\2\2\u017d\u017e\5 \21\2\u017e\u017f\b\20\1\2\u017f"+
		"\u0184\3\2\2\2\u0180\u0181\5V,\2\u0181\u0182\b\20\1\2\u0182\u0184\3\2"+
		"\2\2\u0183\u0177\3\2\2\2\u0183\u017a\3\2\2\2\u0183\u017d\3\2\2\2\u0183"+
		"\u0180\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2"+
		"\2\2\u0186\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u018b\7\6\2\2\u0189"+
		"\u018b\7\f\2\2\u018a\u0176\3\2\2\2\u018a\u0189\3\2\2\2\u018b\37\3\2\2"+
		"\2\u018c\u018d\5\"\22\2\u018d\u018e\b\21\1\2\u018e\u0193\3\2\2\2\u018f"+
		"\u0190\5$\23\2\u0190\u0191\b\21\1\2\u0191\u0193\3\2\2\2\u0192\u018c\3"+
		"\2\2\2\u0192\u018f\3\2\2\2\u0193!\3\2\2\2\u0194\u0196\5`\61\2\u0195\u0194"+
		"\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0199\b\22\1\2"+
		"\u0198\u019a\7\30\2\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019d"+
		"\3\2\2\2\u019b\u019e\7\r\2\2\u019c\u019e\7\31\2\2\u019d\u019b\3\2\2\2"+
		"\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\3\2\2\2\u019f\u01a1"+
		"\7\32\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a3\3\2\2\2"+
		"\u01a2\u01a4\7\33\2\2\u01a3\u01a2\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6"+
		"\3\2\2\2\u01a5\u01a7\7\34\2\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2"+
		"\u01a7\u01a8\3\2\2\2\u01a8\u01a9\7\35\2\2\u01a9\u01aa\5z>\2\u01aa\u01ab"+
		"\b\22\1\2\u01ab\u01ac\b\22\1\2\u01ac\u01ad\7\b\2\2\u01ad\u01af\5J&\2\u01ae"+
		"\u01b0\5.\30\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\3\2"+
		"\2\2\u01b1\u01b4\b\22\1\2\u01b2\u01b3\7\23\2\2\u01b3\u01b5\7\u008d\2\2"+
		"\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01ca"+
		"\b\22\1\2\u01b7\u01c5\7\4\2\2\u01b8\u01c1\7\36\2\2\u01b9\u01c1\7\37\2"+
		"\2\u01ba\u01c1\7 \2\2\u01bb\u01c1\7!\2\2\u01bc\u01c1\7\"\2\2\u01bd\u01c1"+
		"\7#\2\2\u01be\u01c1\7$\2\2\u01bf\u01c1\7%\2\2\u01c0\u01b8\3\2\2\2\u01c0"+
		"\u01b9\3\2\2\2\u01c0\u01ba\3\2\2\2\u01c0\u01bb\3\2\2\2\u01c0\u01bc\3\2"+
		"\2\2\u01c0\u01bd\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1"+
		"\u01c3\3\2\2\2\u01c2\u01c4\7\5\2\2\u01c3\u01c2\3\2\2\2\u01c3\u01c4\3\2"+
		"\2\2\u01c4\u01c6\3\2\2\2\u01c5\u01c0\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01cb\7\6"+
		"\2\2\u01ca\u01b7\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01e7\3\2\2\2\u01cc"+
		"\u01d2\7\4\2\2\u01cd\u01ce\5\66\34\2\u01ce\u01cf\b\22\1\2\u01cf\u01d1"+
		"\3\2\2\2\u01d0\u01cd\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d3\3\2\2\2\u01d3\u01db\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d6\5^"+
		"\60\2\u01d6\u01d7\b\22\1\2\u01d7\u01dc\3\2\2\2\u01d8\u01d9\5\\/\2\u01d9"+
		"\u01da\b\22\1\2\u01da\u01dc\3\2\2\2\u01db\u01d5\3\2\2\2\u01db\u01d8\3"+
		"\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01e2\3\2\2\2\u01dd\u01de\5\66\34\2\u01de"+
		"\u01df\b\22\1\2\u01df\u01e1\3\2\2\2\u01e0\u01dd\3\2\2\2\u01e1\u01e4\3"+
		"\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e5\u01e8\7\6\2\2\u01e6\u01e8\7\f\2\2\u01e7\u01cc\3\2"+
		"\2\2\u01e7\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\b\22\1\2\u01ea"+
		"#\3\2\2\2\u01eb\u01ed\5`\61\2\u01ec\u01eb\3\2\2\2\u01ec\u01ed\3\2\2\2"+
		"\u01ed\u01ee\3\2\2\2\u01ee\u01f0\b\23\1\2\u01ef\u01f1\7\30\2\2\u01f0\u01ef"+
		"\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f5\7\r\2\2\u01f3"+
		"\u01f5\7\31\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f3\3\2\2\2\u01f4\u01f5\3"+
		"\2\2\2\u01f5\u01f7\3\2\2\2\u01f6\u01f8\7\32\2\2\u01f7\u01f6\3\2\2\2\u01f7"+
		"\u01f8\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01fb\7\33\2\2\u01fa\u01f9\3"+
		"\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01fe\7\34\2\2\u01fd"+
		"\u01fc\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\7&"+
		"\2\2\u0200\u0201\5z>\2\u0201\u0202\b\23\1\2\u0202\u0205\b\23\1\2\u0203"+
		"\u0204\7\'\2\2\u0204\u0206\5z>\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2"+
		"\2\u0206\u0207\3\2\2\2\u0207\u0208\b\23\1\2\u0208\u0209\7\b\2\2\u0209"+
		"\u020b\5J&\2\u020a\u020c\5.\30\2\u020b\u020a\3\2\2\2\u020b\u020c\3\2\2"+
		"\2\u020c\u020d\3\2\2\2\u020d\u0210\b\23\1\2\u020e\u020f\7\23\2\2\u020f"+
		"\u0211\7\u008d\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212"+
		"\3\2\2\2\u0212\u0228\b\23\1\2\u0213\u0223\7\4\2\2\u0214\u021f\7(\2\2\u0215"+
		"\u021f\7\36\2\2\u0216\u021f\7 \2\2\u0217\u021f\7!\2\2\u0218\u021f\7\""+
		"\2\2\u0219\u021f\7#\2\2\u021a\u021f\7)\2\2\u021b\u021f\7*\2\2\u021c\u021f"+
		"\7$\2\2\u021d\u021f\7%\2\2\u021e\u0214\3\2\2\2\u021e\u0215\3\2\2\2\u021e"+
		"\u0216\3\2\2\2\u021e\u0217\3\2\2\2\u021e\u0218\3\2\2\2\u021e\u0219\3\2"+
		"\2\2\u021e\u021a\3\2\2\2\u021e\u021b\3\2\2\2\u021e\u021c\3\2\2\2\u021e"+
		"\u021d\3\2\2\2\u021f\u0221\3\2\2\2\u0220\u0222\7\5\2\2\u0221\u0220\3\2"+
		"\2\2\u0221\u0222\3\2\2\2\u0222\u0224\3\2\2\2\u0223\u021e\3\2\2\2\u0224"+
		"\u0225\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2"+
		"\2\2\u0227\u0229\7\6\2\2\u0228\u0213\3\2\2\2\u0228\u0229\3\2\2\2\u0229"+
		"\u0252\3\2\2\2\u022a\u0236\7\4\2\2\u022b\u022c\7+\2\2\u022c\u0231\5z>"+
		"\2\u022d\u022e\7\5\2\2\u022e\u0230\5z>\2\u022f\u022d\3\2\2\2\u0230\u0233"+
		"\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0234\3\2\2\2\u0233"+
		"\u0231\3\2\2\2\u0234\u0235\7\f\2\2\u0235\u0237\3\2\2\2\u0236\u022b\3\2"+
		"\2\2\u0236\u0237\3\2\2\2\u0237\u023d\3\2\2\2\u0238\u0239\5\66\34\2\u0239"+
		"\u023a\b\23\1\2\u023a\u023c\3\2\2\2\u023b\u0238\3\2\2\2\u023c\u023f\3"+
		"\2\2\2\u023d\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0246\3\2\2\2\u023f"+
		"\u023d\3\2\2\2\u0240\u0241\5^\60\2\u0241\u0242\b\23\1\2\u0242\u0247\3"+
		"\2\2\2\u0243\u0244\5\\/\2\u0244\u0245\b\23\1\2\u0245\u0247\3\2\2\2\u0246"+
		"\u0240\3\2\2\2\u0246\u0243\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u024d\3\2"+
		"\2\2\u0248\u0249\5\66\34\2\u0249\u024a\b\23\1\2\u024a\u024c\3\2\2\2\u024b"+
		"\u0248\3\2\2\2\u024c\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2"+
		"\2\2\u024e\u0250\3\2\2\2\u024f\u024d\3\2\2\2\u0250\u0253\7\6\2\2\u0251"+
		"\u0253\7\f\2\2\u0252\u022a\3\2\2\2\u0252\u0251\3\2\2\2\u0253\u0254\3\2"+
		"\2\2\u0254\u0255\b\23\1\2\u0255%\3\2\2\2\u0256\u0258\5`\61\2\u0257\u0256"+
		"\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025b\b\24\1\2"+
		"\u025a\u025c\7\30\2\2\u025b\u025a\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025d"+
		"\3\2\2\2\u025d\u025f\7,\2\2\u025e\u0260\5B\"\2\u025f\u025e\3\2\2\2\u025f"+
		"\u0260\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0262\b\24\1\2\u0262\u0263\5"+
		"z>\2\u0263\u0264\b\24\1\2\u0264\u026d\7-\2\2\u0265\u026a\5,\27\2\u0266"+
		"\u0267\7\5\2\2\u0267\u0269\5,\27\2\u0268\u0266\3\2\2\2\u0269\u026c\3\2"+
		"\2\2\u026a\u0268\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026e\3\2\2\2\u026c"+
		"\u026a\3\2\2\2\u026d\u0265\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u026f\3\2"+
		"\2\2\u026f\u0270\7.\2\2\u0270\u0271\3\2\2\2\u0271\u0277\b\24\1\2\u0272"+
		"\u0273\7\b\2\2\u0273\u0275\5J&\2\u0274\u0276\5.\30\2\u0275\u0274\3\2\2"+
		"\2\u0275\u0276\3\2\2\2\u0276\u0278\3\2\2\2\u0277\u0272\3\2\2\2\u0277\u0278"+
		"\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\b\24\1\2\u027a\u0284\b\24\1\2"+
		"\u027b\u027c\7/\2\2\u027c\u0281\5(\25\2\u027d\u027e\7\5\2\2\u027e\u0280"+
		"\5(\25\2\u027f\u027d\3\2\2\2\u0280\u0283\3\2\2\2\u0281\u027f\3\2\2\2\u0281"+
		"\u0282\3\2\2\2\u0282\u0285\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u027b\3\2"+
		"\2\2\u0284\u0285\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0296\b\24\1\2\u0287"+
		"\u0291\7\4\2\2\u0288\u028d\7 \2\2\u0289\u028d\7!\2\2\u028a\u028d\7\"\2"+
		"\2\u028b\u028d\7#\2\2\u028c\u0288\3\2\2\2\u028c\u0289\3\2\2\2\u028c\u028a"+
		"\3\2\2\2\u028c\u028b\3\2\2\2\u028d\u028f\3\2\2\2\u028e\u0290\7\5\2\2\u028f"+
		"\u028e\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0292\3\2\2\2\u0291\u028c\3\2"+
		"\2\2\u0292\u0293\3\2\2\2\u0293\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294"+
		"\u0295\3\2\2\2\u0295\u0297\7\6\2\2\u0296\u0287\3\2\2\2\u0296\u0297\3\2"+
		"\2\2\u0297\u02ac\3\2\2\2\u0298\u02a7\7\4\2\2\u0299\u029a\5\66\34\2\u029a"+
		"\u029b\b\24\1\2\u029b\u02a6\3\2\2\2\u029c\u029d\5X-\2\u029d\u029e\b\24"+
		"\1\2\u029e\u02a6\3\2\2\2\u029f\u02a0\5T+\2\u02a0\u02a1\b\24\1\2\u02a1"+
		"\u02a6\3\2\2\2\u02a2\u02a3\5Z.\2\u02a3\u02a4\b\24\1\2\u02a4\u02a6\3\2"+
		"\2\2\u02a5\u0299\3\2\2\2\u02a5\u029c\3\2\2\2\u02a5\u029f\3\2\2\2\u02a5"+
		"\u02a2\3\2\2\2\u02a6\u02a9\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2"+
		"\2\2\u02a8\u02aa\3\2\2\2\u02a9\u02a7\3\2\2\2\u02aa\u02ad\7\6\2\2\u02ab"+
		"\u02ad\7\f\2\2\u02ac\u0298\3\2\2\2\u02ac\u02ab\3\2\2\2\u02ad\u02ae\3\2"+
		"\2\2\u02ae\u02af\b\24\1\2\u02af\'\3\2\2\2\u02b0\u02b1\5H%\2\u02b1\u02b2"+
		"\b\25\1\2\u02b2)\3\2\2\2\u02b3\u02b4\5H%\2\u02b4\u02b5\b\26\1\2\u02b5"+
		"+\3\2\2\2\u02b6\u02b7\5z>\2\u02b7\u02b8\b\27\1\2\u02b8\u02b9\b\27\1\2"+
		"\u02b9\u02ba\7\b\2\2\u02ba\u02bc\5J&\2\u02bb\u02bd\5.\30\2\u02bc\u02bb"+
		"\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02ce\b\27\1\2"+
		"\u02bf\u02c9\7\4\2\2\u02c0\u02c5\7 \2\2\u02c1\u02c5\7!\2\2\u02c2\u02c5"+
		"\7\"\2\2\u02c3\u02c5\7#\2\2\u02c4\u02c0\3\2\2\2\u02c4\u02c1\3\2\2\2\u02c4"+
		"\u02c2\3\2\2\2\u02c4\u02c3\3\2\2\2\u02c5\u02c7\3\2\2\2\u02c6\u02c8\7\5"+
		"\2\2\u02c7\u02c6\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02ca\3\2\2\2\u02c9"+
		"\u02c4\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2"+
		"\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cf\7\6\2\2\u02ce\u02bf\3\2\2\2\u02ce"+
		"\u02cf\3\2\2\2\u02cf\u02d9\3\2\2\2\u02d0\u02d4\7\4\2\2\u02d1\u02d3\5\66"+
		"\34\2\u02d2\u02d1\3\2\2\2\u02d3\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d4"+
		"\u02d5\3\2\2\2\u02d5\u02d7\3\2\2\2\u02d6\u02d4\3\2\2\2\u02d7\u02d8\b\27"+
		"\1\2\u02d8\u02da\7\6\2\2\u02d9\u02d0\3\2\2\2\u02d9\u02da\3\2\2\2\u02da"+
		"\u02db\3\2\2\2\u02db\u02dc\b\27\1\2\u02dc-\3\2\2\2\u02dd\u02e4\7\16\2"+
		"\2\u02de\u02e1\5\u008aF\2\u02df\u02e0\7\60\2\2\u02e0\u02e2\5\u0088E\2"+
		"\u02e1\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e5\3\2\2\2\u02e3\u02e5"+
		"\t\2\2\2\u02e4\u02de\3\2\2\2\u02e4\u02e3\3\2\2\2\u02e5\u02e8\3\2\2\2\u02e6"+
		"\u02e9\7\64\2\2\u02e7\u02e9\7\65\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e7\3"+
		"\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\7\17\2\2\u02eb"+
		"\u02ec\b\30\1\2\u02ec/\3\2\2\2\u02ed\u02ef\5`\61\2\u02ee\u02ed\3\2\2\2"+
		"\u02ee\u02ef\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02f2\b\31\1\2\u02f1\u02f3"+
		"\7\66\2\2\u02f2\u02f1\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f4\3\2\2\2"+
		"\u02f4\u02f5\7\67\2\2\u02f5\u02f6\5z>\2\u02f6\u02f7\b\31\1\2\u02f7\u02f9"+
		"\b\31\1\2\u02f8\u02fa\5B\"\2\u02f9\u02f8\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa"+
		"\u02fb\3\2\2\2\u02fb\u02fe\b\31\1\2\u02fc\u02fd\7\b\2\2\u02fd\u02ff\7"+
		"\u008d\2\2\u02fe\u02fc\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0300\3\2\2\2"+
		"\u0300\u0307\b\31\1\2\u0301\u0304\7\4\2\2\u0302\u0305\78\2\2\u0303\u0305"+
		"\79\2\2\u0304\u0302\3\2\2\2\u0304\u0303\3\2\2\2\u0304\u0305\3\2\2\2\u0305"+
		"\u0306\3\2\2\2\u0306\u0308\7\6\2\2\u0307\u0301\3\2\2\2\u0307\u0308\3\2"+
		"\2\2\u0308\u0317\3\2\2\2\u0309\u0312\7\4\2\2\u030a\u030b\5\66\34\2\u030b"+
		"\u030c\b\31\1\2\u030c\u0311\3\2\2\2\u030d\u030e\5V,\2\u030e\u030f\b\31"+
		"\1\2\u030f\u0311\3\2\2\2\u0310\u030a\3\2\2\2\u0310\u030d\3\2\2\2\u0311"+
		"\u0314\3\2\2\2\u0312\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0315\3\2"+
		"\2\2\u0314\u0312\3\2\2\2\u0315\u0318\7\6\2\2\u0316\u0318\7\f\2\2\u0317"+
		"\u0309\3\2\2\2\u0317\u0316\3\2\2\2\u0318\u0319\3\2\2\2\u0319\u031a\b\31"+
		"\1\2\u031a\61\3\2\2\2\u031b\u031d\5`\61\2\u031c\u031b\3\2\2\2\u031c\u031d"+
		"\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u031f\b\32\1\2\u031f\u0320\7:\2\2\u0320"+
		"\u0321\5z>\2\u0321\u0322\b\32\1\2\u0322\u0324\b\32\1\2\u0323\u0325\5B"+
		"\"\2\u0324\u0323\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0326\3\2\2\2\u0326"+
		"\u0329\b\32\1\2\u0327\u0328\7\b\2\2\u0328\u032a\7\u008d\2\2\u0329\u0327"+
		"\3\2\2\2\u0329\u032a\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u0332\b\32\1\2"+
		"\u032c\u032f\7\4\2\2\u032d\u0330\78\2\2\u032e\u0330\79\2\2\u032f\u032d"+
		"\3\2\2\2\u032f\u032e\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u0331\3\2\2\2\u0331"+
		"\u0333\7\6\2\2\u0332\u032c\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0345\3\2"+
		"\2\2\u0334\u0340\7\4\2\2\u0335\u0336\5\66\34\2\u0336\u0337\b\32\1\2\u0337"+
		"\u033f\3\2\2\2\u0338\u0339\5\64\33\2\u0339\u033a\b\32\1\2\u033a\u033f"+
		"\3\2\2\2\u033b\u033c\5V,\2\u033c\u033d\b\32\1\2\u033d\u033f\3\2\2\2\u033e"+
		"\u0335\3\2\2\2\u033e\u0338\3\2\2\2\u033e\u033b\3\2\2\2\u033f\u0342\3\2"+
		"\2\2\u0340\u033e\3\2\2\2\u0340\u0341\3\2\2\2\u0341\u0343\3\2\2\2\u0342"+
		"\u0340\3\2\2\2\u0343\u0346\7\6\2\2\u0344\u0346\7\f\2\2\u0345\u0334\3\2"+
		"\2\2\u0345\u0344\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0348\b\32\1\2\u0348"+
		"\63\3\2\2\2\u0349\u034a\7;\2\2\u034a\u034d\5z>\2\u034b\u034d\5z>\2\u034c"+
		"\u0349\3\2\2\2\u034c\u034b\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u034f\b\33"+
		"\1\2\u034f\u0352\b\33\1\2\u0350\u0351\7\23\2\2\u0351\u0353\7\u0089\2\2"+
		"\u0352\u0350\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u035f"+
		"\b\33\1\2\u0355\u0359\7\4\2\2\u0356\u0358\5\66\34\2\u0357\u0356\3\2\2"+
		"\2\u0358\u035b\3\2\2\2\u0359\u0357\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035c"+
		"\3\2\2\2\u035b\u0359\3\2\2\2\u035c\u035d\b\33\1\2\u035d\u0360\7\6\2\2"+
		"\u035e\u0360\7\f\2\2\u035f\u0355\3\2\2\2\u035f\u035e\3\2\2\2\u0360\65"+
		"\3\2\2\2\u0361\u0363\7<\2\2\u0362\u0364\7\u008d\2\2\u0363\u0362\3\2\2"+
		"\2\u0363\u0364\3\2\2\2\u0364\u0365\3\2\2\2\u0365\u0366\b\34\1\2\u0366"+
		"\u0372\b\34\1\2\u0367\u0368\7-\2\2\u0368\u036d\58\35\2\u0369\u036a\7\5"+
		"\2\2\u036a\u036c\58\35\2\u036b\u0369\3\2\2\2\u036c\u036f\3\2\2\2\u036d"+
		"\u036b\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u0370\3\2\2\2\u036f\u036d\3\2"+
		"\2\2\u0370\u0371\7.\2\2\u0371\u0373\3\2\2\2\u0372\u0367\3\2\2\2\u0372"+
		"\u0373\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u0386\b\34\1\2\u0375\u037f\7"+
		"\4\2\2\u0376\u0377\5\66\34\2\u0377\u0378\b\34\1\2\u0378\u0380\3\2\2\2"+
		"\u0379\u037a\5:\36\2\u037a\u037b\b\34\1\2\u037b\u0380\3\2\2\2\u037c\u037d"+
		"\5@!\2\u037d\u037e\b\34\1\2\u037e\u0380\3\2\2\2\u037f\u0376\3\2\2\2\u037f"+
		"\u0379\3\2\2\2\u037f\u037c\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u037f\3\2"+
		"\2\2\u0381\u0382\3\2\2\2\u0382\u0383\3\2\2\2\u0383\u0384\7\6\2\2\u0384"+
		"\u0387\3\2\2\2\u0385\u0387\7\f\2\2\u0386\u0375\3\2\2\2\u0386\u0385\3\2"+
		"\2\2\u0387\67\3\2\2\2\u0388\u038a\7\u008d\2\2\u0389\u0388\3\2\2\2\u0389"+
		"\u038a\3\2\2\2\u038a\u038b\3\2\2\2\u038b\u038d\7\23\2\2\u038c\u038e\t"+
		"\3\2\2\u038d\u038c\3\2\2\2\u038d\u038e\3\2\2\2\u038e\u038f\3\2\2\2\u038f"+
		"\u0390\b\35\1\2\u03909\3\2\2\2\u0391\u0392\5\66\34\2\u0392\u0393\b\36"+
		"\1\2\u0393\u0398\3\2\2\2\u0394\u0395\5<\37\2\u0395\u0396\b\36\1\2\u0396"+
		"\u0398\3\2\2\2\u0397\u0391\3\2\2\2\u0397\u0394\3\2\2\2\u0398;\3\2\2\2"+
		"\u0399\u039a\5> \2\u039a\u039b\b\37\1\2\u039b\u03a6\3\2\2\2\u039c\u039d"+
		"\5\34\17\2\u039d\u039e\b\37\1\2\u039e\u03a6\3\2\2\2\u039f\u03a0\5\32\16"+
		"\2\u03a0\u03a1\b\37\1\2\u03a1\u03a6\3\2\2\2\u03a2\u03a3\5\64\33\2\u03a3"+
		"\u03a4\b\37\1\2\u03a4\u03a6\3\2\2\2\u03a5\u0399\3\2\2\2\u03a5\u039c\3"+
		"\2\2\2\u03a5\u039f\3\2\2\2\u03a5\u03a2\3\2\2\2\u03a6=\3\2\2\2\u03a7\u03a8"+
		"\5&\24\2\u03a8\u03a9\b \1\2\u03a9\u03b1\3\2\2\2\u03aa\u03ab\5,\27\2\u03ab"+
		"\u03ac\b \1\2\u03ac\u03b1\3\2\2\2\u03ad\u03ae\5 \21\2\u03ae\u03af\b \1"+
		"\2\u03af\u03b1\3\2\2\2\u03b0\u03a7\3\2\2\2\u03b0\u03aa\3\2\2\2\u03b0\u03ad"+
		"\3\2\2\2\u03b1?\3\2\2\2\u03b2\u03b3\7=\2\2\u03b3\u03b4\5N(\2\u03b4\u03b5"+
		"\7\f\2\2\u03b5A\3\2\2\2\u03b6\u03b7\7>\2\2\u03b7\u03bc\5D#\2\u03b8\u03b9"+
		"\7\5\2\2\u03b9\u03bb\5D#\2\u03ba\u03b8\3\2\2\2\u03bb\u03be\3\2\2\2\u03bc"+
		"\u03ba\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd\u03bf\3\2\2\2\u03be\u03bc\3\2"+
		"\2\2\u03bf\u03c0\7?\2\2\u03c0C\3\2\2\2\u03c1\u03c2\5z>\2\u03c2\u03c3\b"+
		"#\1\2\u03c3\u03cd\b#\1\2\u03c4\u03c5\7\27\2\2\u03c5\u03ca\5H%\2\u03c6"+
		"\u03c7\7@\2\2\u03c7\u03c9\5H%\2\u03c8\u03c6\3\2\2\2\u03c9\u03cc\3\2\2"+
		"\2\u03ca\u03c8\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb\u03ce\3\2\2\2\u03cc\u03ca"+
		"\3\2\2\2\u03cd\u03c4\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf"+
		"\u03d0\b#\1\2\u03d0E\3\2\2\2\u03d1\u03d2\5H%\2\u03d2\u03d3\b$\1\2\u03d3"+
		"\u03d8\3\2\2\2\u03d4\u03d5\5L\'\2\u03d5\u03d6\b$\1\2\u03d6\u03d8\3\2\2"+
		"\2\u03d7\u03d1\3\2\2\2\u03d7\u03d4\3\2\2\2\u03d8G\3\2\2\2\u03d9\u03e5"+
		"\5N(\2\u03da\u03db\7>\2\2\u03db\u03e0\5F$\2\u03dc\u03dd\7\5\2\2\u03dd"+
		"\u03df\5F$\2\u03de\u03dc\3\2\2\2\u03df\u03e2\3\2\2\2\u03e0\u03de\3\2\2"+
		"\2\u03e0\u03e1\3\2\2\2\u03e1\u03e3\3\2\2\2\u03e2\u03e0\3\2\2\2\u03e3\u03e4"+
		"\7?\2\2\u03e4\u03e6\3\2\2\2\u03e5\u03da\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6"+
		"I\3\2\2\2\u03e7\u03e8\5R*\2\u03e8\u03e9\b&\1\2\u03e9\u03ee\3\2\2\2\u03ea"+
		"\u03eb\5H%\2\u03eb\u03ec\b&\1\2\u03ec\u03ee\3\2\2\2\u03ed\u03e7\3\2\2"+
		"\2\u03ed\u03ea\3\2\2\2\u03eeK\3\2\2\2\u03ef\u03f0\7\63\2\2\u03f0\u03f6"+
		"\b\'\1\2\u03f1\u03f2\t\4\2\2\u03f2\u03f3\b\'\1\2\u03f3\u03f4\5H%\2\u03f4"+
		"\u03f5\b\'\1\2\u03f5\u03f7\3\2\2\2\u03f6\u03f1\3\2\2\2\u03f6\u03f7\3\2"+
		"\2\2\u03f7M\3\2\2\2\u03f8\u03fb\5z>\2\u03f9\u03fa\7B\2\2\u03fa\u03fc\7"+
		"\u0089\2\2\u03fb\u03f9\3\2\2\2\u03fb\u03fc\3\2\2\2\u03fc\u0404\3\2\2\2"+
		"\u03fd\u03ff\5P)\2\u03fe\u03fd\3\2\2\2\u03ff\u0402\3\2\2\2\u0400\u03fe"+
		"\3\2\2\2\u0400\u0401\3\2\2\2\u0401\u0403\3\2\2\2\u0402\u0400\3\2\2\2\u0403"+
		"\u0405\5P)\2\u0404\u0400\3\2\2\2\u0404\u0405\3\2\2\2\u0405O\3\2\2\2\u0406"+
		"\u0408\7C\2\2\u0407\u0409\7D\2\2\u0408\u0407\3\2\2\2\u0408\u0409\3\2\2"+
		"\2\u0409\u040a\3\2\2\2\u040a\u040d\5z>\2\u040b\u040c\7B\2\2\u040c\u040e"+
		"\7\u0089\2\2\u040d\u040b\3\2\2\2\u040d\u040e\3\2\2\2\u040eQ\3\2\2\2\u040f"+
		"\u0410\7E\2\2\u0410\u041a\b*\1\2\u0411\u0412\7F\2\2\u0412\u041a\b*\1\2"+
		"\u0413\u0414\7G\2\2\u0414\u041a\b*\1\2\u0415\u0416\7H\2\2\u0416\u041a"+
		"\b*\1\2\u0417\u0418\7I\2\2\u0418\u041a\b*\1\2\u0419\u040f\3\2\2\2\u0419"+
		"\u0411\3\2\2\2\u0419\u0413\3\2\2\2\u0419\u0415\3\2\2\2\u0419\u0417\3\2"+
		"\2\2\u041aS\3\2\2\2\u041b\u041d\7J\2\2\u041c\u041e\5\u0086D\2\u041d\u041c"+
		"\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u041f\3\2\2\2\u041f\u0426\b+\1\2\u0420"+
		"\u0422\7\b\2\2\u0421\u0423\5d\63\2\u0422\u0421\3\2\2\2\u0422\u0423\3\2"+
		"\2\2\u0423\u0424\3\2\2\2\u0424\u0427\7\f\2\2\u0425\u0427\7\f\2\2\u0426"+
		"\u0420\3\2\2\2\u0426\u0425\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0429\b+"+
		"\1\2\u0429U\3\2\2\2\u042a\u042c\7K\2\2\u042b\u042a\3\2\2\2\u042b\u042c"+
		"\3\2\2\2\u042c\u042d\3\2\2\2\u042d\u042e\b,\1\2\u042e\u0435\7L\2\2\u042f"+
		"\u0433\5\u0086D\2\u0430\u0431\7-\2\2\u0431\u0432\7\u008c\2\2\u0432\u0434"+
		"\7.\2\2\u0433\u0430\3\2\2\2\u0433\u0434\3\2\2\2\u0434\u0436\3\2\2\2\u0435"+
		"\u042f\3\2\2\2\u0435\u0436\3\2\2\2\u0436\u0437\3\2\2\2\u0437\u043e\b,"+
		"\1\2\u0438\u043a\7\b\2\2\u0439\u043b\5b\62\2\u043a\u0439\3\2\2\2\u043a"+
		"\u043b\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u043f\7\f\2\2\u043d\u043f\7\f"+
		"\2\2\u043e\u0438\3\2\2\2\u043e\u043d\3\2\2\2\u043f\u0440\3\2\2\2\u0440"+
		"\u0441\b,\1\2\u0441W\3\2\2\2\u0442\u0449\t\5\2\2\u0443\u0447\5\u0086D"+
		"\2\u0444\u0445\7-\2\2\u0445\u0446\7\u008c\2\2\u0446\u0448\7.\2\2\u0447"+
		"\u0444\3\2\2\2\u0447\u0448\3\2\2\2\u0448\u044a\3\2\2\2\u0449\u0443\3\2"+
		"\2\2\u0449\u044a\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u0452\b-\1\2\u044c"+
		"\u044e\7\b\2\2\u044d\u044f\5b\62\2\u044e\u044d\3\2\2\2\u044e\u044f\3\2"+
		"\2\2\u044f\u0450\3\2\2\2\u0450\u0453\7\f\2\2\u0451\u0453\7\f\2\2\u0452"+
		"\u044c\3\2\2\2\u0452\u0451\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0455\b-"+
		"\1\2\u0455Y\3\2\2\2\u0456\u045d\t\6\2\2\u0457\u045b\5\u0086D\2\u0458\u0459"+
		"\7-\2\2\u0459\u045a\7\u008c\2\2\u045a\u045c\7.\2\2\u045b\u0458\3\2\2\2"+
		"\u045b\u045c\3\2\2\2\u045c\u045e\3\2\2\2\u045d\u0457\3\2\2\2\u045d\u045e"+
		"\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0466\b.\1\2\u0460\u0462\7\b\2\2\u0461"+
		"\u0463\5b\62\2\u0462\u0461\3\2\2\2\u0462\u0463\3\2\2\2\u0463\u0464\3\2"+
		"\2\2\u0464\u0467\7\f\2\2\u0465\u0467\7\f\2\2\u0466\u0460\3\2\2\2\u0466"+
		"\u0465\3\2\2\2\u0467\u0468\3\2\2\2\u0468\u0469\b.\1\2\u0469[\3\2\2\2\u046a"+
		"\u046c\7Q\2\2\u046b\u046d\5\u0086D\2\u046c\u046b\3\2\2\2\u046c\u046d\3"+
		"\2\2\2\u046d\u046e\3\2\2\2\u046e\u0475\b/\1\2\u046f\u0471\7\b\2\2\u0470"+
		"\u0472\5d\63\2\u0471\u0470\3\2\2\2\u0471\u0472\3\2\2\2\u0472\u0473\3\2"+
		"\2\2\u0473\u0476\7\f\2\2\u0474\u0476\7\f\2\2\u0475\u046f\3\2\2\2\u0475"+
		"\u0474\3\2\2\2\u0476\u0477\3\2\2\2\u0477\u0478\b/\1\2\u0478]\3\2\2\2\u0479"+
		"\u047b\7R\2\2\u047a\u047c\5\u0086D\2\u047b\u047a\3\2\2\2\u047b\u047c\3"+
		"\2\2\2\u047c\u047d\3\2\2\2\u047d\u0484\b\60\1\2\u047e\u0480\7\b\2\2\u047f"+
		"\u0481\5d\63\2\u0480\u047f\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u0482\3\2"+
		"\2\2\u0482\u0485\7\f\2\2\u0483\u0485\7\f\2\2\u0484\u047e\3\2\2\2\u0484"+
		"\u0483\3\2\2\2\u0485\u0486\3\2\2\2\u0486\u0487\b\60\1\2\u0487_\3\2\2\2"+
		"\u0488\u048c\7S\2\2\u0489\u048c\7T\2\2\u048a\u048c\7U\2\2\u048b\u0488"+
		"\3\2\2\2\u048b\u0489\3\2\2\2\u048b\u048a\3\2\2\2\u048c\u048d\3\2\2\2\u048d"+
		"\u048e\b\61\1\2\u048ea\3\2\2\2\u048f\u0490\b\62\1\2\u0490\u0491\7V\2\2"+
		"\u0491\u0492\5d\63\2\u0492\u0493\b\62\1\2\u0493\u05ab\3\2\2\2\u0494\u0495"+
		"\7W\2\2\u0495\u0496\5d\63\2\u0496\u0497\b\62\1\2\u0497\u05ab\3\2\2\2\u0498"+
		"\u0499\7X\2\2\u0499\u049a\5d\63\2\u049a\u049b\b\62\1\2\u049b\u05ab\3\2"+
		"\2\2\u049c\u049d\7Y\2\2\u049d\u049e\5d\63\2\u049e\u049f\b\62\1\2\u049f"+
		"\u05ab\3\2\2\2\u04a0\u04a2\5d\63\2\u04a1\u04a3\t\7\2\2\u04a2\u04a1\3\2"+
		"\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4\u04a5\7\\\2\2\u04a5"+
		"\u04a6\5d\63\2\u04a6\u04a7\b\62\1\2\u04a7\u05ab\3\2\2\2\u04a8\u04aa\5"+
		"d\63\2\u04a9\u04ab\t\7\2\2\u04aa\u04a9\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab"+
		"\u04ac\3\2\2\2\u04ac\u04ad\7\23\2\2\u04ad\u04ae\5d\63\2\u04ae\u04af\b"+
		"\62\1\2\u04af\u05ab\3\2\2\2\u04b0\u04b2\5f\64\2\u04b1\u04b3\t\7\2\2\u04b2"+
		"\u04b1\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b5\7\23"+
		"\2\2\u04b5\u04b6\5f\64\2\u04b6\u04b7\b\62\1\2\u04b7\u05ab\3\2\2\2\u04b8"+
		"\u04ba\5f\64\2\u04b9\u04bb\t\7\2\2\u04ba\u04b9\3\2\2\2\u04ba\u04bb\3\2"+
		"\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04bd\7>\2\2\u04bd\u04be\5f\64\2\u04be"+
		"\u04bf\b\62\1\2\u04bf\u05ab\3\2\2\2\u04c0\u04c2\5f\64\2\u04c1\u04c3\t"+
		"\7\2\2\u04c2\u04c1\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3\u04c4\3\2\2\2\u04c4"+
		"\u04c5\7]\2\2\u04c5\u04c6\5f\64\2\u04c6\u04c7\b\62\1\2\u04c7\u05ab\3\2"+
		"\2\2\u04c8\u04ca\5f\64\2\u04c9\u04cb\t\7\2\2\u04ca\u04c9\3\2\2\2\u04ca"+
		"\u04cb\3\2\2\2\u04cb\u04cc\3\2\2\2\u04cc\u04cd\7?\2\2\u04cd\u04ce\5f\64"+
		"\2\u04ce\u04cf\b\62\1\2\u04cf\u05ab\3\2\2\2\u04d0\u04d2\5f\64\2\u04d1"+
		"\u04d3\t\7\2\2\u04d2\u04d1\3\2\2\2\u04d2\u04d3\3\2\2\2\u04d3\u04d4\3\2"+
		"\2\2\u04d4\u04d5\7^\2\2\u04d5\u04d6\5f\64\2\u04d6\u04d7\b\62\1\2\u04d7"+
		"\u05ab\3\2\2\2\u04d8\u04d9\7_\2\2\u04d9\u04da\5h\65\2\u04da\u04db\7`\2"+
		"\2\u04db\u04dc\5f\64\2\u04dc\u04dd\3\2\2\2\u04dd\u04de\b\62\1\2\u04de"+
		"\u05ab\3\2\2\2\u04df\u04e0\7a\2\2\u04e0\u04e1\7\16\2\2\u04e1\u04e2\5t"+
		";\2\u04e2\u04e3\7\17\2\2\u04e3\u04e4\b\62\1\2\u04e4\u05ab\3\2\2\2\u04e5"+
		"\u04e6\7b\2\2\u04e6\u04e7\7\16\2\2\u04e7\u04e8\5t;\2\u04e8\u04e9\7\b\2"+
		"\2\u04e9\u04ea\5d\63\2\u04ea\u04ef\7c\2\2\u04eb\u04ed\7X\2\2\u04ec\u04eb"+
		"\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed\u04f0\3\2\2\2\u04ee\u04f0\7W\2\2\u04ef"+
		"\u04ec\3\2\2\2\u04ef\u04ee\3\2\2\2\u04f0\u04f1\3\2\2\2\u04f1\u04f2\5d"+
		"\63\2\u04f2\u04f3\7\17\2\2\u04f3\u04f4\b\62\1\2\u04f4\u05ab\3\2\2\2\u04f5"+
		"\u04f6\7d\2\2\u04f6\u04f7\7\16\2\2\u04f7\u04f8\5t;\2\u04f8\u04f9\7\5\2"+
		"\2\u04f9\u04fa\5t;\2\u04fa\u04fb\7\5\2\2\u04fb\u04fc\5t;\2\u04fc\u04fd"+
		"\7\5\2\2\u04fd\u04fe\5t;\2\u04fe\u04ff\7\17\2\2\u04ff\u0500\b\62\1\2\u0500"+
		"\u05ab\3\2\2\2\u0501\u0502\t\7\2\2\u0502\u0503\5b\62\20\u0503\u0504\b"+
		"\62\1\2\u0504\u05ab\3\2\2\2\u0505\u0506\7n\2\2\u0506\u051b\5h\65\2\u0507"+
		"\u0511\7`\2\2\u0508\u0512\5b\62\2\u0509\u050d\7\4\2\2\u050a\u050c\5b\62"+
		"\2\u050b\u050a\3\2\2\2\u050c\u050f\3\2\2\2\u050d\u050b\3\2\2\2\u050d\u050e"+
		"\3\2\2\2\u050e\u0510\3\2\2\2\u050f\u050d\3\2\2\2\u0510\u0512\7\6\2\2\u0511"+
		"\u0508\3\2\2\2\u0511\u0509\3\2\2\2\u0512\u051c\3\2\2\2\u0513\u0517\7\4"+
		"\2\2\u0514\u0516\5b\62\2\u0515\u0514\3\2\2\2\u0516\u0519\3\2\2\2\u0517"+
		"\u0515\3\2\2\2\u0517\u0518\3\2\2\2\u0518\u051a\3\2\2\2\u0519\u0517\3\2"+
		"\2\2\u051a\u051c\7\6\2\2\u051b\u0507\3\2\2\2\u051b\u0513\3\2\2\2\u051c"+
		"\u051d\3\2\2\2\u051d\u051e\b\62\1\2\u051e\u05ab\3\2\2\2\u051f\u0520\7"+
		"Y\2\2\u0520\u0535\5h\65\2\u0521\u052b\7`\2\2\u0522\u052c\5b\62\2\u0523"+
		"\u0527\7\4\2\2\u0524\u0526\5b\62\2\u0525\u0524\3\2\2\2\u0526\u0529\3\2"+
		"\2\2\u0527\u0525\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u052a\3\2\2\2\u0529"+
		"\u0527\3\2\2\2\u052a\u052c\7\6\2\2\u052b\u0522\3\2\2\2\u052b\u0523\3\2"+
		"\2\2\u052c\u0536\3\2\2\2\u052d\u0531\7\4\2\2\u052e\u0530\5b\62\2\u052f"+
		"\u052e\3\2\2\2\u0530\u0533\3\2\2\2\u0531\u052f\3\2\2\2\u0531\u0532\3\2"+
		"\2\2\u0532\u0534\3\2\2\2\u0533\u0531\3\2\2\2\u0534\u0536\7\6\2\2\u0535"+
		"\u0521\3\2\2\2\u0535\u052d\3\2\2\2\u0536\u0537\3\2\2\2\u0537\u0538\b\62"+
		"\1\2\u0538\u05ab\3\2\2\2\u0539\u053a\7V\2\2\u053a\u054f\5h\65\2\u053b"+
		"\u0545\7`\2\2\u053c\u0546\5b\62\2\u053d\u0541\7\4\2\2\u053e\u0540\5b\62"+
		"\2\u053f\u053e\3\2\2\2\u0540\u0543\3\2\2\2\u0541\u053f\3\2\2\2\u0541\u0542"+
		"\3\2\2\2\u0542\u0544\3\2\2\2\u0543\u0541\3\2\2\2\u0544\u0546\7\6\2\2\u0545"+
		"\u053c\3\2\2\2\u0545\u053d\3\2\2\2\u0546\u0550\3\2\2\2\u0547\u054b\7\4"+
		"\2\2\u0548\u054a\5b\62\2\u0549\u0548\3\2\2\2\u054a\u054d\3\2\2\2\u054b"+
		"\u0549\3\2\2\2\u054b\u054c\3\2\2\2\u054c\u054e\3\2\2\2\u054d\u054b\3\2"+
		"\2\2\u054e\u0550\7\6\2\2\u054f\u053b\3\2\2\2\u054f\u0547\3\2\2\2\u0550"+
		"\u0551\3\2\2\2\u0551\u0552\b\62\1\2\u0552\u05ab\3\2\2\2\u0553\u0554\7"+
		"X\2\2\u0554\u0569\5h\65\2\u0555\u055f\7`\2\2\u0556\u0560\5b\62\2\u0557"+
		"\u055b\7\4\2\2\u0558\u055a\5b\62\2\u0559\u0558\3\2\2\2\u055a\u055d\3\2"+
		"\2\2\u055b\u0559\3\2\2\2\u055b\u055c\3\2\2\2\u055c\u055e\3\2\2\2\u055d"+
		"\u055b\3\2\2\2\u055e\u0560\7\6\2\2\u055f\u0556\3\2\2\2\u055f\u0557\3\2"+
		"\2\2\u0560\u056a\3\2\2\2\u0561\u0565\7\4\2\2\u0562\u0564\5b\62\2\u0563"+
		"\u0562\3\2\2\2\u0564\u0567\3\2\2\2\u0565\u0563\3\2\2\2\u0565\u0566\3\2"+
		"\2\2\u0566\u0568\3\2\2\2\u0567\u0565\3\2\2\2\u0568\u056a\7\6\2\2\u0569"+
		"\u0555\3\2\2\2\u0569\u0561\3\2\2\2\u056a\u056b\3\2\2\2\u056b\u056c\b\62"+
		"\1\2\u056c\u05ab\3\2\2\2\u056d\u056e\7W\2\2\u056e\u0583\5h\65\2\u056f"+
		"\u0579\7`\2\2\u0570\u057a\5b\62\2\u0571\u0575\7\4\2\2\u0572\u0574\5b\62"+
		"\2\u0573\u0572\3\2\2\2\u0574\u0577\3\2\2\2\u0575\u0573\3\2\2\2\u0575\u0576"+
		"\3\2\2\2\u0576\u0578\3\2\2\2\u0577\u0575\3\2\2\2\u0578\u057a\7\6\2\2\u0579"+
		"\u0570\3\2\2\2\u0579\u0571\3\2\2\2\u057a\u0584\3\2\2\2\u057b\u057f\7\4"+
		"\2\2\u057c\u057e\5b\62\2\u057d\u057c\3\2\2\2\u057e\u0581\3\2\2\2\u057f"+
		"\u057d\3\2\2\2\u057f\u0580\3\2\2\2\u0580\u0582\3\2\2\2\u0581\u057f\3\2"+
		"\2\2\u0582\u0584\7\6\2\2\u0583\u056f\3\2\2\2\u0583\u057b\3\2\2\2\u0584"+
		"\u0585\3\2\2\2\u0585\u0586\b\62\1\2\u0586\u05ab\3\2\2\2\u0587\u0588\7"+
		"o\2\2\u0588\u059d\5l\67\2\u0589\u0593\7`\2\2\u058a\u0594\5b\62\2\u058b"+
		"\u058f\7\4\2\2\u058c\u058e\5b\62\2\u058d\u058c\3\2\2\2\u058e\u0591\3\2"+
		"\2\2\u058f\u058d\3\2\2\2\u058f\u0590\3\2\2\2\u0590\u0592\3\2\2\2\u0591"+
		"\u058f\3\2\2\2\u0592\u0594\7\6\2\2\u0593\u058a\3\2\2\2\u0593\u058b\3\2"+
		"\2\2\u0594\u059e\3\2\2\2\u0595\u0599\7\4\2\2\u0596\u0598\5b\62\2\u0597"+
		"\u0596\3\2\2\2\u0598\u059b\3\2\2\2\u0599\u0597\3\2\2\2\u0599\u059a\3\2"+
		"\2\2\u059a\u059c\3\2\2\2\u059b\u0599\3\2\2\2\u059c\u059e\7\6\2\2\u059d"+
		"\u0589\3\2\2\2\u059d\u0595\3\2\2\2\u059e\u059f\3\2\2\2\u059f\u05a0\b\62"+
		"\1\2\u05a0\u05ab\3\2\2\2\u05a1\u05a2\7p\2\2\u05a2\u05ab\b\62\1\2\u05a3"+
		"\u05a4\7q\2\2\u05a4\u05ab\b\62\1\2\u05a5\u05a6\7-\2\2\u05a6\u05a7\5b\62"+
		"\2\u05a7\u05a8\7.\2\2\u05a8\u05a9\b\62\1\2\u05a9\u05ab\3\2\2\2\u05aa\u048f"+
		"\3\2\2\2\u05aa\u0494\3\2\2\2\u05aa\u0498\3\2\2\2\u05aa\u049c\3\2\2\2\u05aa"+
		"\u04a0\3\2\2\2\u05aa\u04a8\3\2\2\2\u05aa\u04b0\3\2\2\2\u05aa\u04b8\3\2"+
		"\2\2\u05aa\u04c0\3\2\2\2\u05aa\u04c8\3\2\2\2\u05aa\u04d0\3\2\2\2\u05aa"+
		"\u04d8\3\2\2\2\u05aa\u04df\3\2\2\2\u05aa\u04e5\3\2\2\2\u05aa\u04f5\3\2"+
		"\2\2\u05aa\u0501\3\2\2\2\u05aa\u0505\3\2\2\2\u05aa\u051f\3\2\2\2\u05aa"+
		"\u0539\3\2\2\2\u05aa\u0553\3\2\2\2\u05aa\u056d\3\2\2\2\u05aa\u0587\3\2"+
		"\2\2\u05aa\u05a1\3\2\2\2\u05aa\u05a3\3\2\2\2\u05aa\u05a5\3\2\2\2\u05ab"+
		"\u05c2\3\2\2\2\u05ac\u05ad\f\17\2\2\u05ad\u05ae\t\b\2\2\u05ae\u05af\5"+
		"b\62\20\u05af\u05b0\b\62\1\2\u05b0\u05c1\3\2\2\2\u05b1\u05b2\f\16\2\2"+
		"\u05b2\u05b3\t\t\2\2\u05b3\u05b4\5b\62\17\u05b4\u05b5\b\62\1\2\u05b5\u05c1"+
		"\3\2\2\2\u05b6\u05b7\f\r\2\2\u05b7\u05b8\t\n\2\2\u05b8\u05b9\5b\62\r\u05b9"+
		"\u05ba\b\62\1\2\u05ba\u05c1\3\2\2\2\u05bb\u05bc\f\f\2\2\u05bc\u05bd\t"+
		"\13\2\2\u05bd\u05be\5b\62\f\u05be\u05bf\b\62\1\2\u05bf\u05c1\3\2\2\2\u05c0"+
		"\u05ac\3\2\2\2\u05c0\u05b1\3\2\2\2\u05c0\u05b6\3\2\2\2\u05c0\u05bb\3\2"+
		"\2\2\u05c1\u05c4\3\2\2\2\u05c2\u05c0\3\2\2\2\u05c2\u05c3\3\2\2\2\u05c3"+
		"c\3\2\2\2\u05c4\u05c2\3\2\2\2\u05c5\u05c6\b\63\1\2\u05c6\u05c7\7r\2\2"+
		"\u05c7\u05c8\5d\63\24\u05c8\u05c9\b\63\1\2\u05c9\u05f2\3\2\2\2\u05ca\u05cb"+
		"\7s\2\2\u05cb\u05cc\5d\63\23\u05cc\u05cd\b\63\1\2\u05cd\u05f2\3\2\2\2"+
		"\u05ce\u05cf\7\61\2\2\u05cf\u05d0\5d\63\22\u05d0\u05d1\b\63\1\2\u05d1"+
		"\u05f2\3\2\2\2\u05d2\u05d3\7\4\2\2\u05d3\u05d4\5p9\2\u05d4\u05d5\7`\2"+
		"\2\u05d5\u05d6\5b\62\2\u05d6\u05d7\7\6\2\2\u05d7\u05d8\b\63\1\2\u05d8"+
		"\u05f2\3\2\2\2\u05d9\u05da\t\f\2\2\u05da\u05db\5b\62\2\u05db\u05dc\7v"+
		"\2\2\u05dc\u05dd\5d\63\2\u05dd\u05de\7w\2\2\u05de\u05df\5d\63\t\u05df"+
		"\u05e0\b\63\1\2\u05e0\u05f2\3\2\2\2\u05e1\u05e2\7x\2\2\u05e2\u05f2\b\63"+
		"\1\2\u05e3\u05e4\7y\2\2\u05e4\u05f2\b\63\1\2\u05e5\u05e6\7z\2\2\u05e6"+
		"\u05f2\b\63\1\2\u05e7\u05e8\7{\2\2\u05e8\u05f2\b\63\1\2\u05e9\u05ea\7"+
		"-\2\2\u05ea\u05eb\5d\63\2\u05eb\u05ec\7.\2\2\u05ec\u05ed\b\63\1\2\u05ed"+
		"\u05f2\3\2\2\2\u05ee\u05ef\5N(\2\u05ef\u05f0\b\63\1\2\u05f0\u05f2\3\2"+
		"\2\2\u05f1\u05c5\3\2\2\2\u05f1\u05ca\3\2\2\2\u05f1\u05ce\3\2\2\2\u05f1"+
		"\u05d2\3\2\2\2\u05f1\u05d9\3\2\2\2\u05f1\u05e1\3\2\2\2\u05f1\u05e3\3\2"+
		"\2\2\u05f1\u05e5\3\2\2\2\u05f1\u05e7\3\2\2\2\u05f1\u05e9\3\2\2\2\u05f1"+
		"\u05ee\3\2\2\2\u05f2\u061f\3\2\2\2\u05f3\u05f4\f\21\2\2\u05f4\u05f5\7"+
		"\62\2\2\u05f5\u05f6\5d\63\22\u05f6\u05f7\b\63\1\2\u05f7\u061e\3\2\2\2"+
		"\u05f8\u05f9\f\20\2\2\u05f9\u05fa\7@\2\2\u05fa\u05fb\5d\63\21\u05fb\u05fc"+
		"\b\63\1\2\u05fc\u061e\3\2\2\2\u05fd\u05fe\f\17\2\2\u05fe\u05ff\7t\2\2"+
		"\u05ff\u0600\5d\63\20\u0600\u0601\b\63\1\2\u0601\u061e\3\2\2\2\u0602\u0603"+
		"\f\16\2\2\u0603\u0604\7B\2\2\u0604\u0605\5d\63\17\u0605\u0606\b\63\1\2"+
		"\u0606\u061e\3\2\2\2\u0607\u0609\f\f\2\2\u0608\u060a\5x=\2\u0609\u0608"+
		"\3\2\2\2\u0609\u060a\3\2\2\2\u060a\u060b\3\2\2\2\u060b\u060d\7c\2\2\u060c"+
		"\u060e\5x=\2\u060d\u060c\3\2\2\2\u060d\u060e\3\2\2\2\u060e\u060f\3\2\2"+
		"\2\u060f\u0610\5d\63\f\u0610\u0611\b\63\1\2\u0611\u061e\3\2\2\2\u0612"+
		"\u0613\f\13\2\2\u0613\u0614\7u\2\2\u0614\u0615\5d\63\f\u0615\u0616\b\63"+
		"\1\2\u0616\u061e\3\2\2\2\u0617\u0618\f\r\2\2\u0618\u0619\7\16\2\2\u0619"+
		"\u061a\5d\63\2\u061a\u061b\7\17\2\2\u061b\u061c\b\63\1\2\u061c\u061e\3"+
		"\2\2\2\u061d\u05f3\3\2\2\2\u061d\u05f8\3\2\2\2\u061d\u05fd\3\2\2\2\u061d"+
		"\u0602\3\2\2\2\u061d\u0607\3\2\2\2\u061d\u0612\3\2\2\2\u061d\u0617\3\2"+
		"\2\2\u061e\u0621\3\2\2\2\u061f\u061d\3\2\2\2\u061f\u0620\3\2\2\2\u0620"+
		"e\3\2\2\2\u0621\u061f\3\2\2\2\u0622\u0623\b\64\1\2\u0623\u0624\t\f\2\2"+
		"\u0624\u0625\5b\62\2\u0625\u0626\7v\2\2\u0626\u0627\5f\64\2\u0627\u0628"+
		"\7w\2\2\u0628\u0629\5f\64\f\u0629\u062a\b\64\1\2\u062a\u063e\3\2\2\2\u062b"+
		"\u062c\7_\2\2\u062c\u062d\5d\63\2\u062d\u062e\b\64\1\2\u062e\u063e\3\2"+
		"\2\2\u062f\u0630\7\'\2\2\u0630\u0631\5d\63\2\u0631\u0632\b\64\1\2\u0632"+
		"\u063e\3\2\2\2\u0633\u0635\7t\2\2\u0634\u0633\3\2\2\2\u0634\u0635\3\2"+
		"\2\2\u0635\u0636\3\2\2\2\u0636\u0637\7\u0089\2\2\u0637\u063e\b\64\1\2"+
		"\u0638\u0639\7-\2\2\u0639\u063a\5f\64\2\u063a\u063b\7.\2\2\u063b\u063c"+
		"\b\64\1\2\u063c\u063e\3\2\2\2\u063d\u0622\3\2\2\2\u063d\u062b\3\2\2\2"+
		"\u063d\u062f\3\2\2\2\u063d\u0634\3\2\2\2\u063d\u0638\3\2\2\2\u063e\u065a"+
		"\3\2\2\2\u063f\u0640\f\t\2\2\u0640\u0641\t\r\2\2\u0641\u0642\5f\64\n\u0642"+
		"\u0643\b\64\1\2\u0643\u0659\3\2\2\2\u0644\u0645\f\b\2\2\u0645\u0646\t"+
		"\16\2\2\u0646\u0647\5f\64\t\u0647\u0648\b\64\1\2\u0648\u0659\3\2\2\2\u0649"+
		"\u064a\f\7\2\2\u064a\u064b\t\17\2\2\u064b\u064c\5f\64\b\u064c\u064d\b"+
		"\64\1\2\u064d\u0659\3\2\2\2\u064e\u064f\f\6\2\2\u064f\u0650\t\20\2\2\u0650"+
		"\u0651\5f\64\7\u0651\u0652\b\64\1\2\u0652\u0659\3\2\2\2\u0653\u0654\f"+
		"\5\2\2\u0654\u0655\t\21\2\2\u0655\u0656\5f\64\6\u0656\u0657\b\64\1\2\u0657"+
		"\u0659\3\2\2\2\u0658\u063f\3\2\2\2\u0658\u0644\3\2\2\2\u0658\u0649\3\2"+
		"\2\2\u0658\u064e\3\2\2\2\u0658\u0653\3\2\2\2\u0659\u065c\3\2\2\2\u065a"+
		"\u0658\3\2\2\2\u065a\u065b\3\2\2\2\u065bg\3\2\2\2\u065c\u065a\3\2\2\2"+
		"\u065d\u0662\5j\66\2\u065e\u065f\7\5\2\2\u065f\u0661\5j\66\2\u0660\u065e"+
		"\3\2\2\2\u0661\u0664\3\2\2\2\u0662\u0660\3\2\2\2\u0662\u0663\3\2\2\2\u0663"+
		"i\3\2\2\2\u0664\u0662\3\2\2\2\u0665\u0667\7\u0083\2\2\u0666\u0665\3\2"+
		"\2\2\u0666\u0667\3\2\2\2\u0667\u0668\3\2\2\2\u0668\u066d\5v<\2\u0669\u066a"+
		"\7\5\2\2\u066a\u066c\5v<\2\u066b\u0669\3\2\2\2\u066c\u066f\3\2\2\2\u066d"+
		"\u066b\3\2\2\2\u066d\u066e\3\2\2\2\u066e\u0670\3\2\2\2\u066f\u066d\3\2"+
		"\2\2\u0670\u0672\7\b\2\2\u0671\u0673\7X\2\2\u0672\u0671\3\2\2\2\u0672"+
		"\u0673\3\2\2\2\u0673\u0674\3\2\2\2\u0674\u0675\5d\63\2\u0675\u0676\b\66"+
		"\1\2\u0676\u06a8\3\2\2\2\u0677\u0679\7\u0083\2\2\u0678\u0677\3\2\2\2\u0678"+
		"\u0679\3\2\2\2\u0679\u067a\3\2\2\2\u067a\u067f\5v<\2\u067b\u067c\7\5\2"+
		"\2\u067c\u067e\5v<\2\u067d\u067b\3\2\2\2\u067e\u0681\3\2\2\2\u067f\u067d"+
		"\3\2\2\2\u067f\u0680\3\2\2\2\u0680\u0682\3\2\2\2\u0681\u067f\3\2\2\2\u0682"+
		"\u0683\7\b\2\2\u0683\u0684\7W\2\2\u0684\u0685\5d\63\2\u0685\u0686\b\66"+
		"\1\2\u0686\u06a8\3\2\2\2\u0687\u0689\7\u0083\2\2\u0688\u0687\3\2\2\2\u0688"+
		"\u0689\3\2\2\2\u0689\u068a\3\2\2\2\u068a\u068f\5v<\2\u068b\u068c\7\5\2"+
		"\2\u068c\u068e\5v<\2\u068d\u068b\3\2\2\2\u068e\u0691\3\2\2\2\u068f\u068d"+
		"\3\2\2\2\u068f\u0690\3\2\2\2\u0690\u0692\3\2\2\2\u0691\u068f\3\2\2\2\u0692"+
		"\u0693\7\b\2\2\u0693\u0694\7Y\2\2\u0694\u0695\5d\63\2\u0695\u0696\b\66"+
		"\1\2\u0696\u06a8\3\2\2\2\u0697\u0699\7\u0083\2\2\u0698\u0697\3\2\2\2\u0698"+
		"\u0699\3\2\2\2\u0699\u069a\3\2\2\2\u069a\u069f\5v<\2\u069b\u069c\7\5\2"+
		"\2\u069c\u069e\5v<\2\u069d\u069b\3\2\2\2\u069e\u06a1\3\2\2\2\u069f\u069d"+
		"\3\2\2\2\u069f\u06a0\3\2\2\2\u06a0\u06a2\3\2\2\2\u06a1\u069f\3\2\2\2\u06a2"+
		"\u06a3\7\b\2\2\u06a3\u06a4\7\u0084\2\2\u06a4\u06a5\5d\63\2\u06a5\u06a6"+
		"\b\66\1\2\u06a6\u06a8\3\2\2\2\u06a7\u0666\3\2\2\2\u06a7\u0678\3\2\2\2"+
		"\u06a7\u0688\3\2\2\2\u06a7\u0698\3\2\2\2\u06a8k\3\2\2\2\u06a9\u06ae\5"+
		"n8\2\u06aa\u06ab\7\5\2\2\u06ab\u06ad\5n8\2\u06ac\u06aa\3\2\2\2\u06ad\u06b0"+
		"\3\2\2\2\u06ae\u06ac\3\2\2\2\u06ae\u06af\3\2\2\2\u06afm\3\2\2\2\u06b0"+
		"\u06ae\3\2\2\2\u06b1\u06b6\5v<\2\u06b2\u06b3\7\5\2\2\u06b3\u06b5\5v<\2"+
		"\u06b4\u06b2\3\2\2\2\u06b5\u06b8\3\2\2\2\u06b6\u06b4\3\2\2\2\u06b6\u06b7"+
		"\3\2\2\2\u06b7\u06b9\3\2\2\2\u06b8\u06b6\3\2\2\2\u06b9\u06ba\7\23\2\2"+
		"\u06ba\u06bb\5d\63\2\u06bb\u06bc\b8\1\2\u06bco\3\2\2\2\u06bd\u06c2\5r"+
		":\2\u06be\u06bf\7\5\2\2\u06bf\u06c1\5r:\2\u06c0\u06be\3\2\2\2\u06c1\u06c4"+
		"\3\2\2\2\u06c2\u06c0\3\2\2\2\u06c2\u06c3\3\2\2\2\u06c3q\3\2\2\2\u06c4"+
		"\u06c2\3\2\2\2\u06c5\u06c7\7\u0083\2\2\u06c6\u06c5\3\2\2\2\u06c6\u06c7"+
		"\3\2\2\2\u06c7\u06c8\3\2\2\2\u06c8\u06cd\5v<\2\u06c9\u06ca\7\5\2\2\u06ca"+
		"\u06cc\5v<\2\u06cb\u06c9\3\2\2\2\u06cc\u06cf\3\2\2\2\u06cd\u06cb\3\2\2"+
		"\2\u06cd\u06ce\3\2\2\2\u06ce\u06d0\3\2\2\2\u06cf\u06cd\3\2\2\2\u06d0\u06d2"+
		"\7\b\2\2\u06d1\u06d3\7X\2\2\u06d2\u06d1\3\2\2\2\u06d2\u06d3\3\2\2\2\u06d3"+
		"\u06d4\3\2\2\2\u06d4\u06d5\5d\63\2\u06d5\u06d6\3\2\2\2\u06d6\u06d7\b:"+
		"\1\2\u06d7s\3\2\2\2\u06d8\u06d9\5z>\2\u06d9u\3\2\2\2\u06da\u06db\5z>\2"+
		"\u06db\u06dc\b<\1\2\u06dcw\3\2\2\2\u06dd\u06de\t\22\2\2\u06dey\3\2\2\2"+
		"\u06df\u070a\5\u0086D\2\u06e0\u070a\7\24\2\2\u06e1\u070a\7\35\2\2\u06e2"+
		"\u070a\7J\2\2\u06e3\u070a\7K\2\2\u06e4\u070a\7\25\2\2\u06e5\u070a\7(\2"+
		"\2\u06e6\u070a\7\67\2\2\u06e7\u070a\7\u0085\2\2\u06e8\u070a\7R\2\2\u06e9"+
		"\u070a\7\36\2\2\u06ea\u070a\7:\2\2\u06eb\u070a\7\u0086\2\2\u06ec\u070a"+
		"\7\27\2\2\u06ed\u070a\7\37\2\2\u06ee\u070a\7\21\2\2\u06ef\u070a\7Q\2\2"+
		"\u06f0\u070a\7\26\2\2\u06f1\u070a\7+\2\2\u06f2\u070a\7\20\2\2\u06f3\u070a"+
		"\7,\2\2\u06f4\u070a\7 \2\2\u06f5\u070a\7\22\2\2\u06f6\u070a\7O\2\2\u06f7"+
		"\u070a\7M\2\2\u06f8\u070a\7\66\2\2\u06f9\u070a\7&\2\2\u06fa\u070a\7\34"+
		"\2\2\u06fb\u070a\7=\2\2\u06fc\u070a\7\u0087\2\2\u06fd\u070a\7)\2\2\u06fe"+
		"\u070a\7\30\2\2\u06ff\u070a\7/\2\2\u0700\u070a\7\32\2\2\u0701\u070a\7"+
		"\"\2\2\u0702\u070a\7$\2\2\u0703\u070a\7\33\2\2\u0704\u070a\7L\2\2\u0705"+
		"\u070a\7;\2\2\u0706\u070a\78\2\2\u0707\u070a\7<\2\2\u0708\u070a\7\r\2"+
		"\2\u0709\u06df\3\2\2\2\u0709\u06e0\3\2\2\2\u0709\u06e1\3\2\2\2\u0709\u06e2"+
		"\3\2\2\2\u0709\u06e3\3\2\2\2\u0709\u06e4\3\2\2\2\u0709\u06e5\3\2\2\2\u0709"+
		"\u06e6\3\2\2\2\u0709\u06e7\3\2\2\2\u0709\u06e8\3\2\2\2\u0709\u06e9\3\2"+
		"\2\2\u0709\u06ea\3\2\2\2\u0709\u06eb\3\2\2\2\u0709\u06ec\3\2\2\2\u0709"+
		"\u06ed\3\2\2\2\u0709\u06ee\3\2\2\2\u0709\u06ef\3\2\2\2\u0709\u06f0\3\2"+
		"\2\2\u0709\u06f1\3\2\2\2\u0709\u06f2\3\2\2\2\u0709\u06f3\3\2\2\2\u0709"+
		"\u06f4\3\2\2\2\u0709\u06f5\3\2\2\2\u0709\u06f6\3\2\2\2\u0709\u06f7\3\2"+
		"\2\2\u0709\u06f8\3\2\2\2\u0709\u06f9\3\2\2\2\u0709\u06fa\3\2\2\2\u0709"+
		"\u06fb\3\2\2\2\u0709\u06fc\3\2\2\2\u0709\u06fd\3\2\2\2\u0709\u06fe\3\2"+
		"\2\2\u0709\u06ff\3\2\2\2\u0709\u0700\3\2\2\2\u0709\u0701\3\2\2\2\u0709"+
		"\u0702\3\2\2\2\u0709\u0703\3\2\2\2\u0709\u0704\3\2\2\2\u0709\u0705\3\2"+
		"\2\2\u0709\u0706\3\2\2\2\u0709\u0707\3\2\2\2\u0709\u0708\3\2\2\2\u070a"+
		"{\3\2\2\2\u070b\u070c\t\23\2\2\u070c}\3\2\2\2\u070d\u070f\t\24\2\2\u070e"+
		"\u070d\3\2\2\2\u070e\u070f\3\2\2\2\u070f\u0711\3\2\2\2\u0710\u0712\7\u0089"+
		"\2\2\u0711\u0710\3\2\2\2\u0711\u0712\3\2\2\2\u0712\u0714\3\2\2\2\u0713"+
		"\u0715\7B\2\2\u0714\u0713\3\2\2\2\u0714\u0715\3\2\2\2\u0715\u0716\3\2"+
		"\2\2\u0716\u0717\7\u0089\2\2\u0717\177\3\2\2\2\u0718\u0719\7\u008c\2\2"+
		"\u0719\u0081\3\2\2\2\u071a\u071b\7\u008b\2\2\u071b\u0083\3\2\2\2\u071c"+
		"\u071d\7\u0088\2\2\u071d\u0085\3\2\2\2\u071e\u071f\7\u008a\2\2\u071f\u0087"+
		"\3\2\2\2\u0720\u0721\t\25\2\2\u0721\u0089\3\2\2\2\u0722\u0723\7\u0089"+
		"\2\2\u0723\u008b\3\2\2\2\u00eb\u0093\u00a4\u00a9\u00af\u00b5\u00bb\u00c3"+
		"\u00c9\u00d2\u00d7\u00d9\u00dd\u00e5\u00f1\u00f6\u00fe\u0101\u0108\u010e"+
		"\u011a\u0121\u013c\u013e\u0143\u014e\u0151\u0155\u0159\u015d\u0162\u016b"+
		"\u016e\u0173\u0183\u0185\u018a\u0192\u0195\u0199\u019d\u01a0\u01a3\u01a6"+
		"\u01af\u01b4\u01c0\u01c3\u01c7\u01ca\u01d2\u01db\u01e2\u01e7\u01ec\u01f0"+
		"\u01f4\u01f7\u01fa\u01fd\u0205\u020b\u0210\u021e\u0221\u0225\u0228\u0231"+
		"\u0236\u023d\u0246\u024d\u0252\u0257\u025b\u025f\u026a\u026d\u0275\u0277"+
		"\u0281\u0284\u028c\u028f\u0293\u0296\u02a5\u02a7\u02ac\u02bc\u02c4\u02c7"+
		"\u02cb\u02ce\u02d4\u02d9\u02e1\u02e4\u02e8\u02ee\u02f2\u02f9\u02fe\u0304"+
		"\u0307\u0310\u0312\u0317\u031c\u0324\u0329\u032f\u0332\u033e\u0340\u0345"+
		"\u034c\u0352\u0359\u035f\u0363\u036d\u0372\u037f\u0381\u0386\u0389\u038d"+
		"\u0397\u03a5\u03b0\u03bc\u03ca\u03cd\u03d7\u03e0\u03e5\u03ed\u03f6\u03fb"+
		"\u0400\u0404\u0408\u040d\u0419\u041d\u0422\u0426\u042b\u0433\u0435\u043a"+
		"\u043e\u0447\u0449\u044e\u0452\u045b\u045d\u0462\u0466\u046c\u0471\u0475"+
		"\u047b\u0480\u0484\u048b\u04a2\u04aa\u04b2\u04ba\u04c2\u04ca\u04d2\u04ec"+
		"\u04ef\u050d\u0511\u0517\u051b\u0527\u052b\u0531\u0535\u0541\u0545\u054b"+
		"\u054f\u055b\u055f\u0565\u0569\u0575\u0579\u057f\u0583\u058f\u0593\u0599"+
		"\u059d\u05aa\u05c0\u05c2\u05f1\u0609\u060d\u061d\u061f\u0634\u063d\u0658"+
		"\u065a\u0662\u0666\u066d\u0672\u0678\u067f\u0688\u068f\u0698\u069f\u06a7"+
		"\u06ae\u06b6\u06c2\u06c6\u06cd\u06d2\u0709\u070e\u0711\u0714";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}