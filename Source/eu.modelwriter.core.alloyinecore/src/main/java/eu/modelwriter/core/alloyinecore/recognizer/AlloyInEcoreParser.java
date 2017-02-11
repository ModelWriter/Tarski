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

import eu.modelwriter.core.alloyinecore.structure.instance.ModelImport;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.instance.Slot;
import eu.modelwriter.core.alloyinecore.structure.instance.ObjectValue;
import eu.modelwriter.core.alloyinecore.structure.instance.EnumValue;
import eu.modelwriter.core.alloyinecore.structure.instance.IntegerValue;
import eu.modelwriter.core.alloyinecore.structure.instance.RealValue;
import eu.modelwriter.core.alloyinecore.structure.instance.BooleanValue;
import eu.modelwriter.core.alloyinecore.structure.instance.StringValue;
import eu.modelwriter.core.alloyinecore.structure.instance.NullValue;
import eu.modelwriter.core.alloyinecore.structure.instance.CharValue;

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
		RULE_eObjectValue = 8, RULE_literalValue = 9, RULE_enumValue = 10, RULE_booleanValue = 11, 
		RULE_integerValue = 12, RULE_realValue = 13, RULE_stringValue = 14, RULE_charValue = 15, 
		RULE_nullValue = 16, RULE_model = 17, RULE_packageImport = 18, RULE_ePackage = 19, 
		RULE_eClassifier = 20, RULE_eClass = 21, RULE_eStructuralFeature = 22, 
		RULE_eAttribute = 23, RULE_eReference = 24, RULE_eOperation = 25, RULE_eGenericException = 26, 
		RULE_eGenericSuperType = 27, RULE_eParameter = 28, RULE_eMultiplicity = 29, 
		RULE_eDataType = 30, RULE_eEnum = 31, RULE_eEnumLiteral = 32, RULE_eAnnotation = 33, 
		RULE_eDetail = 34, RULE_eModelElement = 35, RULE_eNamedElement = 36, RULE_eTypedElement = 37, 
		RULE_eModelElementRef = 38, RULE_templateSignature = 39, RULE_eTypeParameter = 40, 
		RULE_eGenericTypeArgument = 41, RULE_eGenericType = 42, RULE_eGenericElementType = 43, 
		RULE_eGenericWildcard = 44, RULE_pathName = 45, RULE_segment = 46, RULE_ePrimitiveType = 47, 
		RULE_body = 48, RULE_invariant = 49, RULE_precondition = 50, RULE_postcondition = 51, 
		RULE_initial = 52, RULE_derivation = 53, RULE_visibilityKind = 54, RULE_formula = 55, 
		RULE_expression = 56, RULE_intExpression = 57, RULE_quantifierDeclarations = 58, 
		RULE_quantifierDeclaration = 59, RULE_letDeclarations = 60, RULE_letDeclaration = 61, 
		RULE_comprehensionDeclarations = 62, RULE_comprehensionDeclaration = 63, 
		RULE_relationId = 64, RULE_variable = 65, RULE_mult = 66, RULE_unrestrictedName = 67, 
		RULE_identifier = 68, RULE_upper = 69, RULE_lower = 70;
	public static final String[] ruleNames = {
		"options", "option", "instance", "modelImport", "eObject", "slot", "dataValue", 
		"multiValueData", "eObjectValue", "literalValue", "enumValue", "booleanValue", 
		"integerValue", "realValue", "stringValue", "charValue", "nullValue", 
		"model", "packageImport", "ePackage", "eClassifier", "eClass", "eStructuralFeature", 
		"eAttribute", "eReference", "eOperation", "eGenericException", "eGenericSuperType", 
		"eParameter", "eMultiplicity", "eDataType", "eEnum", "eEnumLiteral", "eAnnotation", 
		"eDetail", "eModelElement", "eNamedElement", "eTypedElement", "eModelElementRef", 
		"templateSignature", "eTypeParameter", "eGenericTypeArgument", "eGenericType", 
		"eGenericElementType", "eGenericWildcard", "pathName", "segment", "ePrimitiveType", 
		"body", "invariant", "precondition", "postcondition", "initial", "derivation", 
		"visibilityKind", "formula", "expression", "intExpression", "quantifierDeclarations", 
		"quantifierDeclaration", "letDeclarations", "letDeclaration", "comprehensionDeclarations", 
		"comprehensionDeclaration", "relationId", "variable", "mult", "unrestrictedName", 
		"identifier", "upper", "lower"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'options'", "'{'", "','", "'}'", "'symmetry_breaking'", "':'", 
		"'bit_width'", "'skolem_depth'", "'sharing'", "'instance'", "';'", "'model'", 
		"'['", "']'", "'true'", "'false'", "'+'", "'-'", "'.'", "'null'", "'import'", 
		"'package'", "'='", "'abstract'", "'class'", "'interface'", "'extends'", 
		"'static'", "'ghost'", "'transient'", "'volatile'", "'readonly'", "'attribute'", 
		"'derived'", "'id'", "'ordered'", "'!ordered'", "'unique'", "'!unique'", 
		"'unsettable'", "'!unsettable'", "'property'", "'#'", "'composes'", "'resolve'", 
		"'!resolve'", "'key'", "'operation'", "'('", "')'", "'throws'", "'..'", 
		"'*'", "'?'", "'|?'", "'|1'", "'primitive'", "'datatype'", "'serializable'", 
		"'!serializable'", "'enum'", "'literal'", "'annotation'", "'reference'", 
		"'<'", "'>'", "'&'", "'super'", "'::'", "'@'", "'Boolean'", "'Integer'", 
		"'String'", "'Real'", "'UnlimitedNatural'", "'body'", "'callable'", "'invariant'", 
		"'precondition'", "'requires'", "'postcondition'", "'ensures'", "'initial'", 
		"'derivation'", "'public'", "'protected'", "'private'", "'no'", "'lone'", 
		"'one'", "'some'", "'!'", "'not'", "'in'", "'<='", "'>='", "'sum'", "'|'", 
		"'acyclic'", "'function'", "'->'", "'ord'", "'&&'", "'and'", "'||'", "'or'", 
		"'=>'", "'if'", "'implies'", "'<=>'", "'iff'", "'all'", "'let'", "'~'", 
		"'^'", "'++'", "'then'", "'else'", "'iden'", "'none'", "'univ'", "'ints'", 
		"'plus'", "'minus'", "'mul'", "'/'", "'div'", "'%'", "'modulo'", "'disj'", 
		"'set'", "'definition'", "'ensure'", "'require'"
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
			setState(142);
			match(T__0);
			setState(143);
			match(T__1);
			setState(144);
			option();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(145);
				match(T__2);
				setState(146);
				option();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
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
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new SymmetryBreakingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				((SymmetryBreakingContext)_localctx).key = match(T__4);
				setState(155);
				match(T__5);
				setState(156);
				((SymmetryBreakingContext)_localctx).value = match(INT);
				}
				break;
			case T__6:
				_localctx = new BitWidthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				((BitWidthContext)_localctx).key = match(T__6);
				setState(158);
				match(T__5);
				setState(159);
				((BitWidthContext)_localctx).value = match(INT);
				}
				break;
			case T__7:
				_localctx = new SkolemDepthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				((SkolemDepthContext)_localctx).key = match(T__7);
				setState(161);
				match(T__5);
				setState(162);
				((SkolemDepthContext)_localctx).value = match(INT);
				}
				break;
			case T__8:
				_localctx = new SharingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				((SharingContext)_localctx).key = match(T__8);
				setState(164);
				match(T__5);
				setState(165);
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
		public IdentifierContext name;
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(168);
				match(T__9);
				setState(169);
				((InstanceContext)_localctx).name = identifier();
				setState(170);
				match(T__10);
				}
			}

			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(174);
				packageImport(_localctx.current);
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
			modelImport(_localctx.current);
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__37:
			case T__39:
			case T__41:
			case T__43:
			case T__44:
			case T__46:
			case T__47:
			case T__50:
			case T__56:
			case T__57:
			case T__58:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__75:
			case T__76:
			case T__77:
			case T__78:
			case T__80:
			case T__82:
			case T__83:
			case T__131:
			case T__132:
			case T__133:
			case IDENTIFIER:
				{
				setState(181);
				((InstanceContext)_localctx).rootObject = eObject(_localctx.current);
				}
				break;
			case T__10:
				{
				setState(182);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			instance.printTree();
		}
		catch (RecognitionException re) {
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
		((ModelImportContext)_localctx).current =  new ModelImport(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(185);
			match(T__11);
			}
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__20 - 12)) | (1L << (T__21 - 12)) | (1L << (T__23 - 12)) | (1L << (T__24 - 12)) | (1L << (T__25 - 12)) | (1L << (T__26 - 12)) | (1L << (T__27 - 12)) | (1L << (T__29 - 12)) | (1L << (T__30 - 12)) | (1L << (T__31 - 12)) | (1L << (T__32 - 12)) | (1L << (T__33 - 12)) | (1L << (T__34 - 12)) | (1L << (T__35 - 12)) | (1L << (T__37 - 12)) | (1L << (T__39 - 12)) | (1L << (T__41 - 12)) | (1L << (T__43 - 12)) | (1L << (T__44 - 12)) | (1L << (T__46 - 12)) | (1L << (T__47 - 12)) | (1L << (T__50 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__58 - 12)) | (1L << (T__60 - 12)) | (1L << (T__61 - 12)) | (1L << (T__62 - 12)) | (1L << (T__63 - 12)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
				{
				setState(186);
				((ModelImportContext)_localctx).name = unrestrictedName();
				setState(187);
				match(T__5);
				}
			}

			setState(191);
			((ModelImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(192);
			match(T__10);
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
		((EObjectContext)_localctx).current =  new Object(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			((EObjectContext)_localctx).name = pathName(_localctx.current);

			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (INT - 135)) | (1L << (IDENTIFIER - 135)) | (1L << (SINGLE_CHARACTER - 135)) | (1L << (DOUBLE_QUOTED_STRING - 135)))) != 0)) {
				{
				setState(196);
				((EObjectContext)_localctx).id = literalValue(_localctx.owner);
				}
			}


			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(200);
				match(T__1);
				setState(201);
				((EObjectContext)_localctx).slot = slot(_localctx.current);
				((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(202);
					match(T__2);
					setState(203);
					((EObjectContext)_localctx).slot = slot(_localctx.current);
					((EObjectContext)_localctx).slots.add(((EObjectContext)_localctx).slot);
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(209);
				match(T__3);
				}
				break;
			case T__10:
				{
				setState(211);
				match(T__10);
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
		public Slot current;
		public UnrestrictedNameContext name;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public List<EObjectValueContext> eObjectValue() {
			return getRuleContexts(EObjectValueContext.class);
		}
		public EObjectValueContext eObjectValue(int i) {
			return getRuleContext(EObjectValueContext.class,i);
		}
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
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
		((SlotContext)_localctx).current =  new Slot(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			((SlotContext)_localctx).name = unrestrictedName();

			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(216);
				match(T__5);
				setState(239);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(217);
					if (!(true)) throw new FailedPredicateException(this, "true");
					setState(218);
					match(T__1);
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__20 - 12)) | (1L << (T__21 - 12)) | (1L << (T__23 - 12)) | (1L << (T__24 - 12)) | (1L << (T__25 - 12)) | (1L << (T__26 - 12)) | (1L << (T__27 - 12)) | (1L << (T__29 - 12)) | (1L << (T__30 - 12)) | (1L << (T__31 - 12)) | (1L << (T__32 - 12)) | (1L << (T__33 - 12)) | (1L << (T__34 - 12)) | (1L << (T__35 - 12)) | (1L << (T__37 - 12)) | (1L << (T__39 - 12)) | (1L << (T__41 - 12)) | (1L << (T__43 - 12)) | (1L << (T__44 - 12)) | (1L << (T__46 - 12)) | (1L << (T__47 - 12)) | (1L << (T__50 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__58 - 12)) | (1L << (T__60 - 12)) | (1L << (T__61 - 12)) | (1L << (T__62 - 12)) | (1L << (T__63 - 12)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
						{
						{
						setState(219);
						eObject(_localctx.current);
						}
						}
						setState(224);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(225);
					match(T__3);
					}
					break;
				case 2:
					{
					setState(226);
					eObjectValue(_localctx.current);
					}
					break;
				case 3:
					{
					setState(227);
					match(T__12);
					setState(228);
					eObjectValue(_localctx.current);
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(229);
						match(T__2);
						setState(230);
						eObjectValue(_localctx.current);
						}
						}
						setState(235);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(236);
					match(T__13);
					}
					break;
				case 4:
					{
					setState(238);
					dataValue(_localctx.current);
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
		public Element owner;
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public MultiValueDataContext multiValueData() {
			return getRuleContext(MultiValueDataContext.class,0);
		}
		public DataValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public DataValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final DataValueContext dataValue(Element owner) throws RecognitionException {
		DataValueContext _localctx = new DataValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 12, RULE_dataValue);
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case INT:
			case IDENTIFIER:
			case SINGLE_CHARACTER:
			case DOUBLE_QUOTED_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				literalValue(_localctx.owner);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				multiValueData(_localctx.owner);
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
		public Element owner;
		public List<DataValueContext> dataValue() {
			return getRuleContexts(DataValueContext.class);
		}
		public DataValueContext dataValue(int i) {
			return getRuleContext(DataValueContext.class,i);
		}
		public MultiValueDataContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public MultiValueDataContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final MultiValueDataContext multiValueData(Element owner) throws RecognitionException {
		MultiValueDataContext _localctx = new MultiValueDataContext(_ctx, getState(), owner);
		enterRule(_localctx, 14, RULE_multiValueData);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__12);
			setState(248);
			dataValue(_localctx.owner);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(249);
				match(T__2);
				setState(250);
				dataValue(_localctx.owner);
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
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
		public ObjectValue current;
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
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
		((EObjectValueContext)_localctx).current =  new ObjectValue(_localctx); if (owner!=null) owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			pathName(_localctx.current);
			}
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public Element current;
		public EnumValueContext enumValue() {
			return getRuleContext(EnumValueContext.class,0);
		}
		public IntegerValueContext integerValue() {
			return getRuleContext(IntegerValueContext.class,0);
		}
		public RealValueContext realValue() {
			return getRuleContext(RealValueContext.class,0);
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
		public LiteralValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public LiteralValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final LiteralValueContext literalValue(Element owner) throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 18, RULE_literalValue);
		if(_localctx.parent instanceof EObjectContext) {} else { ((LiteralValueContext)_localctx).current =  _localctx.owner;} 
		try {
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				enumValue(_localctx.current);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				integerValue(_localctx.current);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				realValue(_localctx.current);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(263);
				stringValue(_localctx.current);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(264);
				charValue(_localctx.current);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(265);
				booleanValue(_localctx.current);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(266);
				nullValue(_localctx.current);
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

	public static class EnumValueContext extends ParserRuleContext {
		public Element owner;
		public EnumValue current;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EnumValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_enumValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterEnumValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitEnumValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEnumValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumValueContext enumValue(Element owner) throws RecognitionException {
		EnumValueContext _localctx = new EnumValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 20, RULE_enumValue);
		((EnumValueContext)_localctx).current =  new EnumValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			identifier();
			}
		}
		catch (RecognitionException re) {
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
		public Element owner;
		public BooleanValue current;
		public BooleanValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final BooleanValueContext booleanValue(Element owner) throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 22, RULE_booleanValue);
		((BooleanValueContext)_localctx).current =  new BooleanValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
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

	public static class IntegerValueContext extends ParserRuleContext {
		public Element owner;
		public IntegerValue current;
		public TerminalNode INT() { return getToken(AlloyInEcoreParser.INT, 0); }
		public IntegerValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IntegerValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_integerValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterIntegerValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitIntegerValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIntegerValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerValueContext integerValue(Element owner) throws RecognitionException {
		IntegerValueContext _localctx = new IntegerValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 24, RULE_integerValue);
		((IntegerValueContext)_localctx).current =  new IntegerValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16 || _la==T__17) {
				{
				setState(273);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(276);
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

	public static class RealValueContext extends ParserRuleContext {
		public Element owner;
		public RealValue current;
		public List<TerminalNode> INT() { return getTokens(AlloyInEcoreParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(AlloyInEcoreParser.INT, i);
		}
		public RealValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RealValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_realValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterRealValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitRealValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitRealValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealValueContext realValue(Element owner) throws RecognitionException {
		RealValueContext _localctx = new RealValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 26, RULE_realValue);
		((RealValueContext)_localctx).current =  new RealValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16 || _la==T__17) {
				{
				setState(278);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(281);
				match(INT);
				}
			}

			setState(284);
			match(T__18);
			setState(285);
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
		public Element owner;
		public StringValue current;
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public StringValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StringValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final StringValueContext stringValue(Element owner) throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 28, RULE_stringValue);
		((StringValueContext)_localctx).current =  new StringValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
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
		public Element owner;
		public CharValue current;
		public TerminalNode SINGLE_CHARACTER() { return getToken(AlloyInEcoreParser.SINGLE_CHARACTER, 0); }
		public CharValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CharValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final CharValueContext charValue(Element owner) throws RecognitionException {
		CharValueContext _localctx = new CharValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 30, RULE_charValue);
		((CharValueContext)_localctx).current =  new CharValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
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
		public Element owner;
		public NullValue current;
		public NullValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public NullValueContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
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

	public final NullValueContext nullValue(Element owner) throws RecognitionException {
		NullValueContext _localctx = new NullValueContext(_ctx, getState(), owner);
		enterRule(_localctx, 32, RULE_nullValue);
		((NullValueContext)_localctx).current =  new NullValue(_localctx); if (owner!=null) _localctx.owner.addOwnedElement(_localctx.current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(T__19);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 34, RULE_model);
		model = new Model(_localctx); ((ModelContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.MODULE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(293);
				options();
				}
			}


			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(297);
				match(T__11);
				setState(298);
				((ModelContext)_localctx).name = identifier();
				setState(299);
				match(T__10);
				}
			}

			_localctx.element.getDetails().put("name", (((ModelContext)_localctx).name!=null?_input.getText(((ModelContext)_localctx).name.start,((ModelContext)_localctx).name.stop):null));
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(304);
				((ModelContext)_localctx).packageImport = packageImport(model);
				((ModelContext)_localctx).ownedPackageImport.add(((ModelContext)_localctx).packageImport);
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(310);
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
		enterRule(_localctx, 36, RULE_packageImport);
		((PackageImportContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.IMPORT);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(315);
			match(T__20);
			}
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(316);
				((PackageImportContext)_localctx).name = identifier();
				setState(317);
				match(T__5);
				}
			}

			setState(321);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(322);
			match(T__10);
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
		enterRule(_localctx, 38, RULE_ePackage);
		((EPackageContext)_localctx).element =  eFactory.createEPackage();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) {
				{
				setState(325);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EPackageContext)_localctx).visibility.element);
			setState(329);
			match(T__21);
			setState(330);
			((EPackageContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EPackageContext)_localctx).name!=null?_input.getText(((EPackageContext)_localctx).name.start,((EPackageContext)_localctx).name.stop):null));
			if(_localctx.parent instanceof ModelContext) {((EPackageContext)_localctx).current =  new RootPackage(_localctx.element, _localctx); repository.name2Import.put(((RootPackage)_localctx.current).getKey(), (RootPackage)_localctx.current);}
			     else {((EPackageContext)_localctx).current =  new Package(_localctx.element, _localctx);}
			{
			setState(333);
			match(T__5);
			setState(334);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(336);
			match(T__22);
			setState(337);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			_localctx.element.setNsPrefix((((EPackageContext)_localctx).nsPrefix!=null?_input.getText(((EPackageContext)_localctx).nsPrefix.start,((EPackageContext)_localctx).nsPrefix.stop):null)); if(((EPackageContext)_localctx).nsURI != null) _localctx.element.setNsURI(((EPackageContext)_localctx).nsURI.getText().replace("'", ""));
			setState(360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(340);
				match(T__1);
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__56) | (1L << T__57) | (1L << T__60) | (1L << T__62))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (T__76 - 77)) | (1L << (T__77 - 77)) | (1L << (T__84 - 77)) | (1L << (T__85 - 77)) | (1L << (T__86 - 77)))) != 0)) {
					{
					setState(353);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(341);
						((EPackageContext)_localctx).eAnnotation = ((EPackageContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(344);
						((EPackageContext)_localctx).ePackage = ((EPackageContext)_localctx).ePackage = ePackage(_localctx.current);
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						_localctx.element.getESubpackages().add(((EPackageContext)_localctx).ePackage.element);
						}
						break;
					case 3:
						{
						setState(347);
						((EPackageContext)_localctx).eClassifier = ((EPackageContext)_localctx).eClassifier = eClassifier(_localctx.current);
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						if (((EPackageContext)_localctx).eClassifier.element != null) _localctx.element.getEClassifiers().add(((EPackageContext)_localctx).eClassifier.element);
						}
						break;
					case 4:
						{
						setState(350);
						((EPackageContext)_localctx).invariant = ((EPackageContext)_localctx).invariant = invariant(_localctx.current);
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EPackageContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(357);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(358);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(359);
				match(T__10);
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
		enterRule(_localctx, 40, RULE_eClassifier);
		try {
			setState(371);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				((EClassifierContext)_localctx).eClass = eClass(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eClass.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				((EClassifierContext)_localctx).eDataType = eDataType(_localctx.owner);
				((EClassifierContext)_localctx).element =  ((EClassifierContext)_localctx).eDataType.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(368);
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
		enterRule(_localctx, 42, RULE_eClass);
		((EClassContext)_localctx).element =  eFactory.createEClass();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) {
				{
				setState(373);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			if(_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EClassContext)_localctx).visibility.element);
			setState(382);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
				{
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(377);
					((EClassContext)_localctx).isAbstract = match(T__23);
					}
				}

				setState(380);
				((EClassContext)_localctx).isClass = match(T__24);
				}
				break;
			case T__25:
				{
				setState(381);
				((EClassContext)_localctx).isInterface = match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_localctx.element.setAbstract(((EClassContext)_localctx).isAbstract!=null); if (((EClassContext)_localctx).isInterface!=null) {_localctx.element.setInterface(true);_localctx.element.setAbstract(true);}
			setState(386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(385);
				((EClassContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			if (_localctx.name == null) {notifyErrorListeners("missing Class name");} else {_localctx.element.setName((((EClassContext)_localctx).name!=null?_input.getText(((EClassContext)_localctx).name.start,((EClassContext)_localctx).name.stop):null));}
			if (((EClassContext)_localctx).isInterface!=null) ((EClassContext)_localctx).current =  new Interface(_localctx.element, _localctx); else ((EClassContext)_localctx).current =  new Class(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__64) {
				{
				setState(390);
				((EClassContext)_localctx).ownedSignature = ((EClassContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EClassContext)_localctx).templateSignature.typeParameters);
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(394);
				match(T__26);
				setState(395);
				((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(396);
					match(T__2);
					setState(397);
					((EClassContext)_localctx).eGenericSuperType = eGenericSuperType(_localctx.current);
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).eGenericSuperType);
					}
					}
					setState(402);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}


			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(406);
				match(T__5);
				setState(407);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EClassContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EClassContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(431);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(411);
				match(T__1);
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__41) | (1L << T__47) | (1L << T__62))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (T__76 - 77)) | (1L << (T__77 - 77)) | (1L << (T__84 - 77)) | (1L << (T__85 - 77)) | (1L << (T__86 - 77)))) != 0)) {
					{
					setState(424);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						setState(412);
						((EClassContext)_localctx).eAnnotation = ((EClassContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(415);
						((EClassContext)_localctx).eOperation = ((EClassContext)_localctx).eOperation = eOperation(_localctx.current);
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						_localctx.element.getEOperations().add(((EClassContext)_localctx).eOperation.element);
						}
						break;
					case 3:
						{
						setState(418);
						((EClassContext)_localctx).eStructuralFeature = ((EClassContext)_localctx).eStructuralFeature = eStructuralFeature(_localctx.current);
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						if (((EClassContext)_localctx).eStructuralFeature.element != null) _localctx.element.getEStructuralFeatures().add(((EClassContext)_localctx).eStructuralFeature.element);
						}
						break;
					case 4:
						{
						setState(421);
						((EClassContext)_localctx).invariant = ((EClassContext)_localctx).invariant = invariant(_localctx.current);
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EClassContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(428);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(429);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(430);
				match(T__10);
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
		enterRule(_localctx, 44, RULE_eStructuralFeature);
		try {
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				((EStructuralFeatureContext)_localctx).eAttribute = eAttribute(_localctx.owner);
				((EStructuralFeatureContext)_localctx).element =  ((EStructuralFeatureContext)_localctx).eAttribute.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
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
		public Token s28;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s12;
		public Token s29;
		public Token s30;
		public Token s31;
		public Token s32;
		public UnrestrictedNameContext name;
		public EGenericElementTypeContext eAttributeType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s34;
		public Token s35;
		public Token s36;
		public Token s37;
		public Token s38;
		public Token s39;
		public Token s40;
		public Token s41;
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
		enterRule(_localctx, 46, RULE_eAttribute);
		((EAttributeContext)_localctx).element =  eFactory.createEAttribute();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) {
				{
				setState(441);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).visibility.element);
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(445);
				((EAttributeContext)_localctx).s28 = match(T__27);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s28);
				}
			}

			setState(450);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(448);
				((EAttributeContext)_localctx).s12 = match(T__11);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s12);
				}
				break;
			case T__28:
				{
				setState(449);
				((EAttributeContext)_localctx).s29 = match(T__28);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
				}
				break;
			case T__29:
			case T__30:
			case T__31:
			case T__32:
				break;
			default:
				throw new NoViableAltException(this);
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

			setState(459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(458);
				((EAttributeContext)_localctx).s32 = match(T__31);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s32);
				}
			}

			setState(461);
			match(T__32);
			setState(462);
			((EAttributeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EAttributeContext)_localctx).name!=null?_input.getText(((EAttributeContext)_localctx).name.start,((EAttributeContext)_localctx).name.stop):null));
			((EAttributeContext)_localctx).current =  new Attribute(_localctx.element, _localctx);
			setState(465);
			match(T__5);
			setState(466);
			((EAttributeContext)_localctx).eAttributeType = eGenericElementType(_localctx.current);
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(467);
				((EAttributeContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement)_localctx.element);
				}
			}

			if(_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(471);
				match(T__22);
				setState(472);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EAttributeContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EAttributeContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(476);
				match(T__1);
				setState(490); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(485);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__33:
						{
						setState(477);
						((EAttributeContext)_localctx).s34 = match(T__33);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s34);
						}
						break;
					case T__34:
						{
						setState(478);
						((EAttributeContext)_localctx).s35 = match(T__34);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s35);
						}
						break;
					case T__35:
						{
						setState(479);
						((EAttributeContext)_localctx).s36 = match(T__35);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(480);
						((EAttributeContext)_localctx).s37 = match(T__36);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(481);
						((EAttributeContext)_localctx).s38 = match(T__37);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(482);
						((EAttributeContext)_localctx).s39 = match(T__38);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s39);
						}
						break;
					case T__39:
						{
						setState(483);
						((EAttributeContext)_localctx).s40 = match(T__39);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(484);
						((EAttributeContext)_localctx).s41 = match(T__40);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s41);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(488);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(487);
						match(T__2);
						}
					}

					}
					}
					setState(492); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40))) != 0) );
				setState(494);
				match(T__3);
				}
				break;
			}
			setState(524);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(497);
				match(T__1);
				{
				setState(503);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(498);
						((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(505);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				}
				setState(512);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__83:
					{
					setState(506);
					((EAttributeContext)_localctx).ownedDerivation = ((EAttributeContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).derivation.element);
					}
					break;
				case T__82:
					{
					setState(509);
					((EAttributeContext)_localctx).ownedInitial = ((EAttributeContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__62:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__62) {
					{
					{
					setState(514);
					((EAttributeContext)_localctx).eAnnotation = ((EAttributeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EAttributeContext)_localctx).eAnnotation.element);
					}
					}
					setState(521);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(522);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(523);
				match(T__10);
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
		public Token s28;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s12;
		public Token s29;
		public Token s30;
		public Token s31;
		public Token s32;
		public UnrestrictedNameContext name;
		public UnrestrictedNameContext eOpposite;
		public EGenericElementTypeContext eReferenceType;
		public EMultiplicityContext ownedMultiplicity;
		public Token defaultValue;
		public Token s44;
		public Token s34;
		public Token s36;
		public Token s37;
		public Token s38;
		public Token s39;
		public Token s45;
		public Token s46;
		public Token s40;
		public Token s41;
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
		enterRule(_localctx, 48, RULE_eReference);
		((EReferenceContext)_localctx).element =  eFactory.createEReference();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) {
				{
				setState(528);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).visibility.element);
			setState(533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(532);
				((EReferenceContext)_localctx).s28 = match(T__27);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s28);
				}
			}

			setState(537);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(535);
				((EReferenceContext)_localctx).s12 = match(T__11);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s12);
				}
				break;
			case T__28:
				{
				setState(536);
				((EReferenceContext)_localctx).s29 = match(T__28);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
				}
				break;
			case T__29:
			case T__30:
			case T__31:
			case T__41:
				break;
			default:
				throw new NoViableAltException(this);
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

			setState(546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(545);
				((EReferenceContext)_localctx).s32 = match(T__31);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s32);
				}
			}

			setState(548);
			match(T__41);
			setState(549);
			((EReferenceContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EReferenceContext)_localctx).name!=null?_input.getText(((EReferenceContext)_localctx).name.start,((EReferenceContext)_localctx).name.stop):null));
			((EReferenceContext)_localctx).current =  new Reference(_localctx.element, _localctx);
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__42) {
				{
				setState(552);
				match(T__42);
				setState(553);
				((EReferenceContext)_localctx).eOpposite = unrestrictedName();
				}
			}


			{
			setState(557);
			match(T__5);
			setState(558);
			((EReferenceContext)_localctx).eReferenceType = eGenericElementType(_localctx.current);
			setState(560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(559);
				((EReferenceContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			}
			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(563);
				match(T__22);
				setState(564);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EReferenceContext)_localctx).defaultValue != null) _localctx.element.setDefaultValueLiteral(((EReferenceContext)_localctx).defaultValue.getText().replace("'", ""));
			setState(589);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(568);
				match(T__1);
				setState(584); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(579);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__43:
						{
						setState(569);
						((EReferenceContext)_localctx).s44 = match(T__43);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s44);
						}
						break;
					case T__33:
						{
						setState(570);
						((EReferenceContext)_localctx).s34 = match(T__33);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s34);
						}
						break;
					case T__35:
						{
						setState(571);
						((EReferenceContext)_localctx).s36 = match(T__35);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(572);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(573);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(574);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__44:
						{
						setState(575);
						((EReferenceContext)_localctx).s45 = match(T__44);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s45);
						}
						break;
					case T__45:
						{
						setState(576);
						((EReferenceContext)_localctx).s46 = match(T__45);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s46);
						}
						break;
					case T__39:
						{
						setState(577);
						((EReferenceContext)_localctx).s40 = match(T__39);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s40);
						}
						break;
					case T__40:
						{
						setState(578);
						((EReferenceContext)_localctx).s41 = match(T__40);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s41);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(581);
						match(T__2);
						}
					}

					}
					}
					setState(586); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0) );
				setState(588);
				match(T__3);
				}
				break;
			}
			setState(631);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(591);
				match(T__1);
				setState(603);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__46) {
					{
					setState(592);
					match(T__46);
					setState(593);
					((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
					((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
					setState(598);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(594);
						match(T__2);
						setState(595);
						((EReferenceContext)_localctx).unrestrictedName = unrestrictedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).unrestrictedName);
						}
						}
						setState(600);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(601);
					match(T__10);
					}
				}

				{
				setState(610);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(605);
						((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
						}
						} 
					}
					setState(612);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				}
				setState(619);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__83:
					{
					setState(613);
					((EReferenceContext)_localctx).ownedDerivation = ((EReferenceContext)_localctx).derivation = derivation(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).derivation.element);
					}
					break;
				case T__82:
					{
					setState(616);
					((EReferenceContext)_localctx).ownedInitial = ((EReferenceContext)_localctx).initial = initial(_localctx.current);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).initial.element);
					}
					break;
				case T__3:
				case T__62:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(626);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__62) {
					{
					{
					setState(621);
					((EReferenceContext)_localctx).eAnnotation = ((EReferenceContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
					_localctx.element.getEAnnotations().add(((EReferenceContext)_localctx).eAnnotation.element);
					}
					}
					setState(628);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(629);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(630);
				match(T__10);
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
		public Token s28;
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
		public Token s36;
		public Token s37;
		public Token s38;
		public Token s39;
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
		enterRule(_localctx, 50, RULE_eOperation);
		((EOperationContext)_localctx).element =  eFactory.createEOperation(); ((EOperationContext)_localctx).current =  new Operation(_localctx.element, _localctx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) {
				{
				setState(635);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EOperationContext)_localctx).visibility.element);
			setState(640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(639);
				((EOperationContext)_localctx).s28 = match(T__27);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s28);
				}
			}

			setState(642);
			match(T__47);
			setState(644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__64) {
				{
				setState(643);
				((EOperationContext)_localctx).ownedSignature = ((EOperationContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EOperationContext)_localctx).templateSignature.typeParameters);
			setState(647);
			((EOperationContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EOperationContext)_localctx).name!=null?_input.getText(((EOperationContext)_localctx).name.start,((EOperationContext)_localctx).name.stop):null));
			{
			setState(649);
			match(T__48);
			setState(658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__20 - 12)) | (1L << (T__21 - 12)) | (1L << (T__23 - 12)) | (1L << (T__24 - 12)) | (1L << (T__25 - 12)) | (1L << (T__26 - 12)) | (1L << (T__27 - 12)) | (1L << (T__29 - 12)) | (1L << (T__30 - 12)) | (1L << (T__31 - 12)) | (1L << (T__32 - 12)) | (1L << (T__33 - 12)) | (1L << (T__34 - 12)) | (1L << (T__35 - 12)) | (1L << (T__37 - 12)) | (1L << (T__39 - 12)) | (1L << (T__41 - 12)) | (1L << (T__43 - 12)) | (1L << (T__44 - 12)) | (1L << (T__46 - 12)) | (1L << (T__47 - 12)) | (1L << (T__50 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__58 - 12)) | (1L << (T__60 - 12)) | (1L << (T__61 - 12)) | (1L << (T__62 - 12)) | (1L << (T__63 - 12)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
				{
				setState(650);
				((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(651);
					match(T__2);
					setState(652);
					((EOperationContext)_localctx).eParameter = eParameter(_localctx.current);
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(660);
			match(T__49);
			}
			for (EParameterContext ctx: ((EOperationContext)_localctx).eParameters){_localctx.element.getEParameters().add(ctx.element);}
			setState(668);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(663);
				match(T__5);
				setState(664);
				((EOperationContext)_localctx).eReturnType = ((EOperationContext)_localctx).eGenericElementType = eGenericElementType(_localctx.current);
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(665);
					((EOperationContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
					}
				}

				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			 if (_localctx.eReturnType != null) _localctx.element.setEGenericType(((EOperationContext)_localctx).eGenericElementType.element);
			setState(681);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__50) {
				{
				setState(672);
				match(T__50);
				setState(673);
				((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
				setState(678);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(674);
					match(T__2);
					setState(675);
					((EOperationContext)_localctx).eGenericException = eGenericException(_localctx.current);
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).eGenericException);
					}
					}
					setState(680);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 for(EGenericExceptionContext e: ((EOperationContext)_localctx).ownedException) _localctx.element.getEGenericExceptions().add(e.element);
			setState(699);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(684);
				match(T__1);
				setState(694); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(689);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__35:
						{
						setState(685);
						((EOperationContext)_localctx).s36 = match(T__35);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(686);
						((EOperationContext)_localctx).s37 = match(T__36);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(687);
						((EOperationContext)_localctx).s38 = match(T__37);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(688);
						((EOperationContext)_localctx).s39 = match(T__38);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s39);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(692);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(691);
						match(T__2);
						}
					}

					}
					}
					setState(696); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0) );
				setState(698);
				match(T__3);
				}
				break;
			}
			setState(721);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(701);
				match(T__1);
				setState(716);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (T__62 - 63)) | (1L << (T__75 - 63)) | (1L << (T__78 - 63)) | (1L << (T__79 - 63)) | (1L << (T__80 - 63)) | (1L << (T__81 - 63)))) != 0)) {
					{
					setState(714);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__62:
						{
						setState(702);
						((EOperationContext)_localctx).eAnnotation = ((EOperationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).eAnnotation.element);
						}
						break;
					case T__78:
					case T__79:
						{
						setState(705);
						((EOperationContext)_localctx).precondition = ((EOperationContext)_localctx).precondition = precondition(_localctx.current);
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).precondition.element);
						}
						break;
					case T__75:
						{
						setState(708);
						((EOperationContext)_localctx).body = ((EOperationContext)_localctx).body = body(_localctx.current);
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).body.element);
						}
						break;
					case T__80:
					case T__81:
						{
						setState(711);
						((EOperationContext)_localctx).postcondition = ((EOperationContext)_localctx).postcondition = postcondition(_localctx.current);
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						_localctx.element.getEAnnotations().add(((EOperationContext)_localctx).postcondition.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(718);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(719);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(720);
				match(T__10);
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
		enterRule(_localctx, 52, RULE_eGenericException);
		((EGenericExceptionContext)_localctx).current =  new GenericException(_localctx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
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
		enterRule(_localctx, 54, RULE_eGenericSuperType);
		((EGenericSuperTypeContext)_localctx).current =  new GenericSuperType(_localctx.element, _localctx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
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
		public Token s36;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s37;
		public Token s38;
		public Token s39;
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
		enterRule(_localctx, 56, RULE_eParameter);
		((EParameterContext)_localctx).element =  eFactory.createEParameter();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			((EParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EParameterContext)_localctx).name!=null?_input.getText(((EParameterContext)_localctx).name.start,((EParameterContext)_localctx).name.stop):null));
			((EParameterContext)_localctx).current =  new Parameter(_localctx.element, _localctx);
			setState(734);
			match(T__5);
			setState(735);
			((EParameterContext)_localctx).eParameterType = eGenericElementType(_localctx.current);
			setState(737);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(736);
				((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity(_localctx.current, (ETypedElement) _localctx.element);
				}
			}

			if (_localctx.ownedMultiplicity == null) {_localctx.element.setLowerBound(1);} 
			setState(755);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				{
				setState(740);
				match(T__1);
				setState(750); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(745);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__35:
						{
						setState(741);
						((EParameterContext)_localctx).s36 = match(T__35);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(742);
						((EParameterContext)_localctx).s37 = match(T__36);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s37);
						}
						break;
					case T__37:
						{
						setState(743);
						((EParameterContext)_localctx).s38 = match(T__37);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(744);
						((EParameterContext)_localctx).s39 = match(T__38);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s39);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(748);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(747);
						match(T__2);
						}
					}

					}
					}
					setState(752); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0) );
				setState(754);
				match(T__3);
				}
				break;
			}
			setState(766);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(757);
				match(T__1);
				setState(761);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__62) {
					{
					{
					setState(758);
					((EParameterContext)_localctx).eAnnotation = ((EParameterContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(763);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EParameterContext)_localctx).eAnnotation.element);
				setState(765);
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
		enterRule(_localctx, 58, RULE_eMultiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770);
			match(T__12);
			setState(777);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(771);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(774);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__51) {
					{
					setState(772);
					match(T__51);
					setState(773);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__16:
			case T__52:
			case T__53:
				{
				setState(776);
				((EMultiplicityContext)_localctx).stringBound = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__52) | (1L << T__53))) != 0)) ) {
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
			setState(781);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__54:
				{
				setState(779);
				((EMultiplicityContext)_localctx).nullable = match(T__54);
				}
				break;
			case T__55:
				{
				setState(780);
				match(T__55);
				}
				break;
			case T__13:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(783);
			match(T__13);

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
		public Token s57;
		public List<Token> qualifier = new ArrayList<Token>();
		public UnrestrictedNameContext name;
		public TemplateSignatureContext ownedSignature;
		public TemplateSignatureContext templateSignature;
		public Token instanceClassName;
		public Token s59;
		public Token s60;
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
		enterRule(_localctx, 60, RULE_eDataType);
		((EDataTypeContext)_localctx).element =  eFactory.createEDataType();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) {
				{
				setState(786);
				((EDataTypeContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).visibility.element);
			setState(791);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__56) {
				{
				setState(790);
				((EDataTypeContext)_localctx).s57 = match(T__56);
				((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s57);
				}
			}

			setState(793);
			match(T__57);
			setState(794);
			((EDataTypeContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EDataTypeContext)_localctx).name!=null?_input.getText(((EDataTypeContext)_localctx).name.start,((EDataTypeContext)_localctx).name.stop):null));
			((EDataTypeContext)_localctx).current =  new DataType(_localctx.element, _localctx);
			setState(798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__64) {
				{
				setState(797);
				((EDataTypeContext)_localctx).ownedSignature = ((EDataTypeContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EDataTypeContext)_localctx).templateSignature.typeParameters);
			setState(803);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(801);
				match(T__5);
				setState(802);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EDataTypeContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EDataTypeContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(812);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				{
				setState(806);
				match(T__1);
				setState(809);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__58:
					{
					setState(807);
					((EDataTypeContext)_localctx).s59 = match(T__58);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s59);
					}
					break;
				case T__59:
					{
					setState(808);
					((EDataTypeContext)_localctx).s60 = match(T__59);
					((EDataTypeContext)_localctx).qualifier.add(((EDataTypeContext)_localctx).s60);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(811);
				match(T__3);
				}
				break;
			}
			setState(828);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(814);
				match(T__1);
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (T__62 - 63)) | (1L << (T__76 - 63)) | (1L << (T__77 - 63)))) != 0)) {
					{
					setState(821);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__62:
						{
						setState(815);
						((EDataTypeContext)_localctx).eAnnotation = ((EDataTypeContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).eAnnotation.element);
						}
						break;
					case T__76:
					case T__77:
						{
						setState(818);
						((EDataTypeContext)_localctx).invariant = ((EDataTypeContext)_localctx).invariant = invariant(_localctx.current);
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EDataTypeContext)_localctx).invariant.element);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(825);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(826);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(827);
				match(T__10);
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
		public Token s59;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s60;
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
		enterRule(_localctx, 62, RULE_eEnum);
		((EEnumContext)_localctx).element =  eFactory.createEEnum();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(833);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) {
				{
				setState(832);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			if (_localctx.visibility != null) _localctx.element.getEAnnotations().add(((EEnumContext)_localctx).visibility.element);
			setState(836);
			match(T__60);
			setState(837);
			((EEnumContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((EEnumContext)_localctx).name!=null?_input.getText(((EEnumContext)_localctx).name.start,((EEnumContext)_localctx).name.stop):null));
			((EEnumContext)_localctx).current =  new Enum(_localctx.element, _localctx);
			setState(841);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__64) {
				{
				setState(840);
				((EEnumContext)_localctx).ownedSignature = ((EEnumContext)_localctx).templateSignature = templateSignature(_localctx.current);
				}
			}

			if(_localctx.templateSignature != null) _localctx.element.getETypeParameters().addAll(((EEnumContext)_localctx).templateSignature.typeParameters);
			setState(846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(844);
				match(T__5);
				setState(845);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if(((EEnumContext)_localctx).instanceClassName != null) _localctx.element.setInstanceClassName(((EEnumContext)_localctx).instanceClassName.getText().replace("'", ""));
			setState(855);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(849);
				match(T__1);
				setState(852);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__58:
					{
					setState(850);
					((EEnumContext)_localctx).s59 = match(T__58);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s59);
					}
					break;
				case T__59:
					{
					setState(851);
					((EEnumContext)_localctx).s60 = match(T__59);
					((EEnumContext)_localctx).qualifier.add(((EEnumContext)_localctx).s60);
					}
					break;
				case T__3:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(854);
				match(T__3);
				}
				break;
			}
			setState(874);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(857);
				match(T__1);
				setState(869);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__20 - 12)) | (1L << (T__21 - 12)) | (1L << (T__23 - 12)) | (1L << (T__24 - 12)) | (1L << (T__25 - 12)) | (1L << (T__26 - 12)) | (1L << (T__27 - 12)) | (1L << (T__29 - 12)) | (1L << (T__30 - 12)) | (1L << (T__31 - 12)) | (1L << (T__32 - 12)) | (1L << (T__33 - 12)) | (1L << (T__34 - 12)) | (1L << (T__35 - 12)) | (1L << (T__37 - 12)) | (1L << (T__39 - 12)) | (1L << (T__41 - 12)) | (1L << (T__43 - 12)) | (1L << (T__44 - 12)) | (1L << (T__46 - 12)) | (1L << (T__47 - 12)) | (1L << (T__50 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__58 - 12)) | (1L << (T__60 - 12)) | (1L << (T__61 - 12)) | (1L << (T__62 - 12)) | (1L << (T__63 - 12)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
					{
					setState(867);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
					case 1:
						{
						setState(858);
						((EEnumContext)_localctx).eAnnotation = ((EEnumContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(861);
						((EEnumContext)_localctx).eEnumLiteral = ((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral(_localctx.current);
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						_localctx.element.getELiterals().add(((EEnumContext)_localctx).eEnumLiteral.element);
						}
						break;
					case 3:
						{
						setState(864);
						((EEnumContext)_localctx).invariant = ((EEnumContext)_localctx).invariant = invariant(_localctx.current);
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						_localctx.element.getEAnnotations().add(((EEnumContext)_localctx).invariant.element);
						}
						break;
					}
					}
					setState(871);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(872);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(873);
				match(T__10);
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
		enterRule(_localctx, 64, RULE_eEnumLiteral);
		((EEnumLiteralContext)_localctx).element =  eFactory.createEEnumLiteral();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				{
				{
				setState(878);
				match(T__61);
				setState(879);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				}
				break;
			case 2:
				{
				setState(880);
				((EEnumLiteralContext)_localctx).name = unrestrictedName();
				}
				break;
			}
			_localctx.element.setName((((EEnumLiteralContext)_localctx).name!=null?_input.getText(((EEnumLiteralContext)_localctx).name.start,((EEnumLiteralContext)_localctx).name.stop):null));
			((EEnumLiteralContext)_localctx).current =  new EnumLiteral(_localctx.element, _localctx);
			setState(887);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(885);
				match(T__22);
				setState(886);
				((EEnumLiteralContext)_localctx).value = match(INT);
				}
			}

			 
			setState(900);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(890);
				match(T__1);
				setState(894);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__62) {
					{
					{
					setState(891);
					((EEnumLiteralContext)_localctx).eAnnotation = ((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(896);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				_localctx.element.getEAnnotations().add(((EEnumLiteralContext)_localctx).eAnnotation.element);
				setState(898);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(899);
				match(T__10);
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
		enterRule(_localctx, 66, RULE_eAnnotation);
		((EAnnotationContext)_localctx).element =  eFactory.createEAnnotation();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(902);
			match(T__62);
			setState(904);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(903);
				((EAnnotationContext)_localctx).source = match(SINGLE_QUOTED_STRING);
				}
			}

			_localctx.element.setSource(((EAnnotationContext)_localctx).source != null ? ((EAnnotationContext)_localctx).source.getText().replace("'", "") : null);
			((EAnnotationContext)_localctx).current =  new Annotation(_localctx.element, _localctx);
			setState(919);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__48) {
				{
				setState(908);
				match(T__48);
				setState(909);
				((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(914);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(910);
					match(T__2);
					setState(911);
					((EAnnotationContext)_localctx).eDetail = eDetail(_localctx.current);
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(916);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(917);
				match(T__49);
				}
			}

			for (EDetailContext ctx: ((EAnnotationContext)_localctx).ownedDetails) _localctx.element.getDetails().put(ctx.k, ctx.v);
			setState(939);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(922);
				match(T__1);
				setState(932); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(932);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
					case 1:
						{
						setState(923);
						((EAnnotationContext)_localctx).eAnnotation = ((EAnnotationContext)_localctx).eAnnotation = eAnnotation(_localctx.current);
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						if(((EAnnotationContext)_localctx).eAnnotation.element != null) _localctx.element.getEAnnotations().add(((EAnnotationContext)_localctx).eAnnotation.element);
						}
						break;
					case 2:
						{
						setState(926);
						((EAnnotationContext)_localctx).eModelElement = ((EAnnotationContext)_localctx).eModelElement = eModelElement(_localctx.current);
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						if(((EAnnotationContext)_localctx).eModelElement.element != null) _localctx.element.getContents().add(((EAnnotationContext)_localctx).eModelElement.element);
						}
						break;
					case 3:
						{
						setState(929);
						((EAnnotationContext)_localctx).eModelElementRef = ((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef(_localctx.current);
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						if(((EAnnotationContext)_localctx).eModelElementRef.element != null) _localctx.element.getReferences().add(((EAnnotationContext)_localctx).eModelElementRef.element);
						}
						break;
					}
					}
					setState(934); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__20 - 12)) | (1L << (T__21 - 12)) | (1L << (T__23 - 12)) | (1L << (T__24 - 12)) | (1L << (T__25 - 12)) | (1L << (T__26 - 12)) | (1L << (T__27 - 12)) | (1L << (T__28 - 12)) | (1L << (T__29 - 12)) | (1L << (T__30 - 12)) | (1L << (T__31 - 12)) | (1L << (T__32 - 12)) | (1L << (T__33 - 12)) | (1L << (T__34 - 12)) | (1L << (T__35 - 12)) | (1L << (T__37 - 12)) | (1L << (T__39 - 12)) | (1L << (T__41 - 12)) | (1L << (T__43 - 12)) | (1L << (T__44 - 12)) | (1L << (T__46 - 12)) | (1L << (T__47 - 12)) | (1L << (T__50 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__58 - 12)) | (1L << (T__60 - 12)) | (1L << (T__61 - 12)) | (1L << (T__62 - 12)) | (1L << (T__63 - 12)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__84 - 76)) | (1L << (T__85 - 76)) | (1L << (T__86 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (IDENTIFIER - 76)))) != 0) );
				setState(936);
				match(T__3);
				}
				}
				break;
			case T__10:
				{
				setState(938);
				match(T__10);
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
		enterRule(_localctx, 68, RULE_eDetail);
		((EDetailContext)_localctx).current =  new AnnotationDetail(_localctx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(942);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(941);
				((EDetailContext)_localctx).key = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(944);
			match(T__22);
			setState(946);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING || _la==ML_SINGLE_QUOTED_STRING) {
				{
				setState(945);
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
		enterRule(_localctx, 70, RULE_eModelElement);
		try {
			setState(956);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(950);
				((EModelElementContext)_localctx).eAnnotation = eAnnotation(_localctx.owner);
				((EModelElementContext)_localctx).element =  ((EModelElementContext)_localctx).eAnnotation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(953);
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
		enterRule(_localctx, 72, RULE_eNamedElement);
		try {
			setState(970);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(958);
				((ENamedElementContext)_localctx).eTypedElement = eTypedElement(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eTypedElement.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(961);
				((ENamedElementContext)_localctx).eClassifier = eClassifier(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).eClassifier.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(964);
				((ENamedElementContext)_localctx).ePackage = ePackage(_localctx.owner);
				((ENamedElementContext)_localctx).element =  ((ENamedElementContext)_localctx).ePackage.element;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(967);
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
		enterRule(_localctx, 74, RULE_eTypedElement);
		try {
			setState(981);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(972);
				((ETypedElementContext)_localctx).eOperation = eOperation(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eOperation.element;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(975);
				((ETypedElementContext)_localctx).eParameter = eParameter(_localctx.owner);
				((ETypedElementContext)_localctx).element =  ((ETypedElementContext)_localctx).eParameter.element;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(978);
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
		enterRule(_localctx, 76, RULE_eModelElementRef);
		((EModelElementRefContext)_localctx).current =  new AnnotationReference(_localctx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(983);
			match(T__63);
			setState(984);
			((EModelElementRefContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(985);
			match(T__10);
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
		enterRule(_localctx, 78, RULE_templateSignature);
		((TemplateSignatureContext)_localctx).typeParameters =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(987);
			match(T__64);
			setState(988);
			((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
			((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
			setState(993);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(989);
				match(T__2);
				setState(990);
				((TemplateSignatureContext)_localctx).eTypeParameter = eTypeParameter(_localctx.owner);
				((TemplateSignatureContext)_localctx).ownedTypeParameters.add(((TemplateSignatureContext)_localctx).eTypeParameter);
				}
				}
				setState(995);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(996);
			match(T__65);
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
		enterRule(_localctx, 80, RULE_eTypeParameter);
		((ETypeParameterContext)_localctx).element =  eFactory.createETypeParameter();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(998);
			((ETypeParameterContext)_localctx).name = unrestrictedName();
			_localctx.element.setName((((ETypeParameterContext)_localctx).name!=null?_input.getText(((ETypeParameterContext)_localctx).name.start,((ETypeParameterContext)_localctx).name.stop):null));
			((ETypeParameterContext)_localctx).current =  new TypeParameter(_localctx.element, _localctx);
			setState(1010);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(1001);
				match(T__26);
				setState(1002);
				((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
				setState(1007);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__66) {
					{
					{
					setState(1003);
					match(T__66);
					setState(1004);
					((ETypeParameterContext)_localctx).eGenericType = eGenericType(_localctx.current);
					((ETypeParameterContext)_localctx).ownedEBounds.add(((ETypeParameterContext)_localctx).eGenericType);
					}
					}
					setState(1009);
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
		enterRule(_localctx, 82, RULE_eGenericTypeArgument);
		((EGenericTypeArgumentContext)_localctx).current =  new GenericTypeArgument(_localctx);
		try {
			setState(1020);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__37:
			case T__39:
			case T__41:
			case T__43:
			case T__44:
			case T__46:
			case T__47:
			case T__50:
			case T__56:
			case T__57:
			case T__58:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__75:
			case T__76:
			case T__77:
			case T__78:
			case T__80:
			case T__82:
			case T__83:
			case T__131:
			case T__132:
			case T__133:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1014);
				((EGenericTypeArgumentContext)_localctx).eGenericType = eGenericType(_localctx.current);
				((EGenericTypeArgumentContext)_localctx).element =  ((EGenericTypeArgumentContext)_localctx).eGenericType.element;
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 2);
				{
				setState(1017);
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
		enterRule(_localctx, 84, RULE_eGenericType);
		((EGenericTypeContext)_localctx).element =  eFactory.createEGenericType(); if (_localctx.parent instanceof ETypeParameterContext) ((EGenericTypeContext)_localctx).current =  new GenericType(_localctx.element, _localctx); else ((EGenericTypeContext)_localctx).current =  _localctx.owner;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1022);
			((EGenericTypeContext)_localctx).ownedPathName = pathName(_localctx.current);
			setState(1034);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__64) {
				{
				setState(1023);
				match(T__64);
				setState(1024);
				((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
				((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
				setState(1029);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1025);
					match(T__2);
					setState(1026);
					((EGenericTypeContext)_localctx).eGenericTypeArgument = eGenericTypeArgument(_localctx.current);
					((EGenericTypeContext)_localctx).ownedETypeArguments.add(((EGenericTypeContext)_localctx).eGenericTypeArgument);
					}
					}
					setState(1031);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1032);
				match(T__65);
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
		enterRule(_localctx, 86, RULE_eGenericElementType);
		((EGenericElementTypeContext)_localctx).current =  new GenericElementType(_localctx);
		try {
			setState(1042);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__70:
			case T__71:
			case T__72:
			case T__73:
			case T__74:
				enterOuterAlt(_localctx, 1);
				{
				setState(1036);
				((EGenericElementTypeContext)_localctx).ePrimitiveType = ePrimitiveType(_localctx.current);
				((EGenericElementTypeContext)_localctx).element =  ((EGenericElementTypeContext)_localctx).ePrimitiveType.element;
				}
				break;
			case T__11:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__37:
			case T__39:
			case T__41:
			case T__43:
			case T__44:
			case T__46:
			case T__47:
			case T__50:
			case T__56:
			case T__57:
			case T__58:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__75:
			case T__76:
			case T__77:
			case T__78:
			case T__80:
			case T__82:
			case T__83:
			case T__131:
			case T__132:
			case T__133:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1039);
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
		enterRule(_localctx, 88, RULE_eGenericWildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1044);
			match(T__53);
			((EGenericWildcardContext)_localctx).element =  eFactory.createEGenericType();
			setState(1051);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26 || _la==T__67) {
				{
				setState(1046);
				((EGenericWildcardContext)_localctx).bound = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__67) ) {
					((EGenericWildcardContext)_localctx).bound = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((EGenericWildcardContext)_localctx).current =  new GenericWildcard(_localctx.element, _localctx); owner.addOwnedElement(_localctx.current);
				setState(1048);
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
		enterRule(_localctx, 90, RULE_pathName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1053);
			((PathNameContext)_localctx).firstSegment = unrestrictedName();
			setState(1056);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				{
				setState(1054);
				match(T__18);
				setState(1055);
				((PathNameContext)_localctx).index = match(INT);
				}
				break;
			}
			setState(1065);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				{
				setState(1061);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1058);
						((PathNameContext)_localctx).segment = segment();
						((PathNameContext)_localctx).midSegments.add(((PathNameContext)_localctx).segment);
						}
						} 
					}
					setState(1063);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
				}
				setState(1064);
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
		enterRule(_localctx, 92, RULE_segment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1067);
			match(T__68);
			setState(1069);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__69) {
				{
				setState(1068);
				match(T__69);
				}
			}

			setState(1071);
			((SegmentContext)_localctx).name = unrestrictedName();
			setState(1074);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
			case 1:
				{
				setState(1072);
				match(T__18);
				setState(1073);
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
		enterRule(_localctx, 94, RULE_ePrimitiveType);
		try {
			setState(1086);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__70:
				enterOuterAlt(_localctx, 1);
				{
				setState(1076);
				match(T__70);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBoolean());
				}
				break;
			case T__71:
				enterOuterAlt(_localctx, 2);
				{
				setState(1078);
				match(T__71);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEInt());
				}
				break;
			case T__72:
				enterOuterAlt(_localctx, 3);
				{
				setState(1080);
				match(T__72);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEString());
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 4);
				{
				setState(1082);
				match(T__73);
				((EPrimitiveTypeContext)_localctx).element =  eFactory.createEGenericType(); _localctx.element.setEClassifier(EcorePackage.eINSTANCE.getEBigDecimal());
				}
				break;
			case T__74:
				enterOuterAlt(_localctx, 5);
				{
				setState(1084);
				match(T__74);
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
		enterRule(_localctx, 96, RULE_body);
		((BodyContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.BODY); ((BodyContext)_localctx).current =  new Body(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1088);
			match(T__75);
			setState(1090);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1089);
				((BodyContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((BodyContext)_localctx).name!=null?_input.getText(((BodyContext)_localctx).name.start,((BodyContext)_localctx).name.stop):null)); 
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
				_la = _input.LA(1);
				if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
					{
					setState(1094);
					((BodyContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1097);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1098);
				match(T__10);
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
		enterRule(_localctx, 98, RULE_invariant);
		((InvariantContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INVARIANT); ((InvariantContext)_localctx).current =  new Invariant(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__76) {
				{
				setState(1103);
				((InvariantContext)_localctx).isCallable = match(T__76);
				}
			}

			_localctx.element.getDetails().put("callable", ((InvariantContext)_localctx).isCallable != null ? "true" : "false");
			setState(1107);
			match(T__77);
			setState(1114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1108);
				((InvariantContext)_localctx).name = identifier();
				setState(1112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__48) {
					{
					setState(1109);
					match(T__48);
					setState(1110);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1111);
					match(T__49);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InvariantContext)_localctx).name!=null?_input.getText(((InvariantContext)_localctx).name.start,((InvariantContext)_localctx).name.stop):null)); if(((InvariantContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((InvariantContext)_localctx).message!=null?((InvariantContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1117);
				match(T__5);
				setState(1119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
					{
					setState(1118);
					((InvariantContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1121);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1122);
				match(T__10);
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
		enterRule(_localctx, 100, RULE_precondition);
		((PreconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.PRECONDITION); ((PreconditionContext)_localctx).current =  new PreCondition(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1127);
			_la = _input.LA(1);
			if ( !(_la==T__78 || _la==T__79) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1128);
				((PreconditionContext)_localctx).name = identifier();
				setState(1132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__48) {
					{
					setState(1129);
					match(T__48);
					setState(1130);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1131);
					match(T__49);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PreconditionContext)_localctx).name!=null?_input.getText(((PreconditionContext)_localctx).name.start,((PreconditionContext)_localctx).name.stop):null)); if(((PreconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PreconditionContext)_localctx).message!=null?((PreconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1137);
				match(T__5);
				setState(1139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
					{
					setState(1138);
					((PreconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1141);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1142);
				match(T__10);
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
		enterRule(_localctx, 102, RULE_postcondition);
		((PostconditionContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.POSTCONDITION); ((PostconditionContext)_localctx).current =  new PostCondition(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1147);
			_la = _input.LA(1);
			if ( !(_la==T__80 || _la==T__81) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1148);
				((PostconditionContext)_localctx).name = identifier();
				setState(1152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__48) {
					{
					setState(1149);
					match(T__48);
					setState(1150);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(1151);
					match(T__49);
					}
				}

				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((PostconditionContext)_localctx).name!=null?_input.getText(((PostconditionContext)_localctx).name.start,((PostconditionContext)_localctx).name.stop):null)); if(((PostconditionContext)_localctx).message!=null) _localctx.element.getDetails().put("message", (((PostconditionContext)_localctx).message!=null?((PostconditionContext)_localctx).message.getText():null).replace("\"", ""));
			setState(1163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1157);
				match(T__5);
				setState(1159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
					{
					setState(1158);
					((PostconditionContext)_localctx).ownedSpecification = formula(0);
					}
				}

				setState(1161);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1162);
				match(T__10);
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
		enterRule(_localctx, 104, RULE_initial);
		((InitialContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.INITIAL); ((InitialContext)_localctx).current =  new Initial(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1167);
			match(T__82);
			setState(1169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1168);
				((InitialContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((InitialContext)_localctx).name!=null?_input.getText(((InitialContext)_localctx).name.start,((InitialContext)_localctx).name.stop):null));
			setState(1178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1172);
				match(T__5);
				setState(1174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
					{
					setState(1173);
					((InitialContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1176);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1177);
				match(T__10);
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
		enterRule(_localctx, 106, RULE_derivation);
		((DerivationContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.DERIVATION); ((DerivationContext)_localctx).current =  new Derivation(_localctx); _localctx.owner.addOwnedElement(_localctx.current);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1182);
			match(T__83);
			setState(1184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(1183);
				((DerivationContext)_localctx).name = identifier();
				}
			}

			if(_localctx.name!=null) _localctx.element.getDetails().put("name", (((DerivationContext)_localctx).name!=null?_input.getText(((DerivationContext)_localctx).name.start,((DerivationContext)_localctx).name.stop):null));
			setState(1193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				{
				setState(1187);
				match(T__5);
				setState(1189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
					{
					setState(1188);
					((DerivationContext)_localctx).ownedExpression = expression(0);
					}
				}

				setState(1191);
				match(T__10);
				}
				}
				break;
			case T__10:
				{
				setState(1192);
				match(T__10);
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
		enterRule(_localctx, 108, RULE_visibilityKind);
		((VisibilityKindContext)_localctx).element =  eFactory.createEAnnotation(); _localctx.element.setSource(AnnotationSources.VISIBILITY);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__84:
				{
				setState(1197);
				((VisibilityKindContext)_localctx).qualifier = match(T__84);
				}
				break;
			case T__85:
				{
				setState(1198);
				((VisibilityKindContext)_localctx).qualifier = match(T__85);
				}
				break;
			case T__86:
				{
				setState(1199);
				((VisibilityKindContext)_localctx).qualifier = match(T__86);
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
		int _startState = 110;
		enterRecursionRule(_localctx, 110, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1487);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
			case 1:
				{
				_localctx = new NoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1205);
				match(T__87);
				setState(1206);
				expression(0);
				((NoContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 2:
				{
				_localctx = new LoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1209);
				match(T__88);
				setState(1210);
				expression(0);
				((LoneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 3:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1213);
				match(T__89);
				setState(1214);
				expression(0);
				((OneContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 4:
				{
				_localctx = new SomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1217);
				match(T__90);
				setState(1218);
				expression(0);
				((SomeContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 5:
				{
				_localctx = new InContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1221);
				((InContext)_localctx).left = expression(0);
				setState(1223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__91 || _la==T__92) {
					{
					setState(1222);
					((InContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__91 || _la==T__92) ) {
						((InContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1225);
				match(T__93);
				setState(1226);
				((InContext)_localctx).right = expression(0);
				((InContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 6:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1229);
				((EqualContext)_localctx).left = expression(0);
				setState(1231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__91 || _la==T__92) {
					{
					setState(1230);
					((EqualContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__91 || _la==T__92) ) {
						((EqualContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1233);
				match(T__22);
				setState(1234);
				((EqualContext)_localctx).right = expression(0);
				((EqualContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 7:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1237);
				((EqContext)_localctx).ileft = intExpression(0);
				setState(1239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__91 || _la==T__92) {
					{
					setState(1238);
					((EqContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__91 || _la==T__92) ) {
						((EqContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1241);
				match(T__22);
				setState(1242);
				((EqContext)_localctx).iright = intExpression(0);
				((EqContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 8:
				{
				_localctx = new LtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1245);
				((LtContext)_localctx).ileft = intExpression(0);
				setState(1247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__91 || _la==T__92) {
					{
					setState(1246);
					((LtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__91 || _la==T__92) ) {
						((LtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1249);
				match(T__64);
				setState(1250);
				((LtContext)_localctx).iright = intExpression(0);
				((LtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 9:
				{
				_localctx = new LteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1253);
				((LteContext)_localctx).ileft = intExpression(0);
				setState(1255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__91 || _la==T__92) {
					{
					setState(1254);
					((LteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__91 || _la==T__92) ) {
						((LteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1257);
				match(T__94);
				setState(1258);
				((LteContext)_localctx).iright = intExpression(0);
				((LteContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 10:
				{
				_localctx = new GtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1261);
				((GtContext)_localctx).ileft = intExpression(0);
				setState(1263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__91 || _la==T__92) {
					{
					setState(1262);
					((GtContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__91 || _la==T__92) ) {
						((GtContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1265);
				match(T__65);
				setState(1266);
				((GtContext)_localctx).iright = intExpression(0);
				((GtContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 11:
				{
				_localctx = new GteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1269);
				((GteContext)_localctx).ileft = intExpression(0);
				setState(1271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__91 || _la==T__92) {
					{
					setState(1270);
					((GteContext)_localctx).not = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__91 || _la==T__92) ) {
						((GteContext)_localctx).not = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1273);
				match(T__95);
				setState(1274);
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
				setState(1277);
				match(T__96);
				setState(1278);
				quantifierDeclarations();
				setState(1279);
				match(T__97);
				setState(1280);
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
				setState(1284);
				match(T__98);
				setState(1285);
				match(T__12);
				setState(1286);
				relationId();
				setState(1287);
				match(T__13);
				((AcyclicContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 14:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1290);
				match(T__99);
				setState(1291);
				match(T__12);
				setState(1292);
				((FunctionContext)_localctx).rel = relationId();
				setState(1293);
				match(T__5);
				setState(1294);
				((FunctionContext)_localctx).domain = expression(0);
				setState(1295);
				match(T__100);
				setState(1300);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__11:
				case T__20:
				case T__21:
				case T__23:
				case T__24:
				case T__25:
				case T__26:
				case T__27:
				case T__29:
				case T__30:
				case T__31:
				case T__32:
				case T__33:
				case T__34:
				case T__35:
				case T__37:
				case T__39:
				case T__41:
				case T__43:
				case T__44:
				case T__46:
				case T__47:
				case T__48:
				case T__50:
				case T__52:
				case T__56:
				case T__57:
				case T__58:
				case T__60:
				case T__61:
				case T__62:
				case T__63:
				case T__75:
				case T__76:
				case T__77:
				case T__78:
				case T__80:
				case T__82:
				case T__83:
				case T__89:
				case T__106:
				case T__107:
				case T__113:
				case T__114:
				case T__118:
				case T__119:
				case T__120:
				case T__121:
				case T__131:
				case T__132:
				case T__133:
				case IDENTIFIER:
					{
					setState(1297);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__89) {
						{
						setState(1296);
						match(T__89);
						}
					}

					}
					break;
				case T__88:
					{
					setState(1299);
					((FunctionContext)_localctx).partial = match(T__88);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1302);
				((FunctionContext)_localctx).range = expression(0);
				setState(1303);
				match(T__13);
				((FunctionContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 15:
				{
				_localctx = new TotalOrderContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1306);
				match(T__101);
				setState(1307);
				match(T__12);
				setState(1308);
				((TotalOrderContext)_localctx).rel = relationId();
				setState(1309);
				match(T__2);
				setState(1310);
				((TotalOrderContext)_localctx).ordered = relationId();
				setState(1311);
				match(T__2);
				setState(1312);
				((TotalOrderContext)_localctx).first = relationId();
				setState(1313);
				match(T__2);
				setState(1314);
				((TotalOrderContext)_localctx).last = relationId();
				setState(1315);
				match(T__13);
				((TotalOrderContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 16:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1318);
				((NotContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__91 || _la==T__92) ) {
					((NotContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1319);
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
				setState(1322);
				match(T__111);
				setState(1323);
				quantifierDeclarations();
				setState(1344);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__97:
					{
					setState(1324);
					match(T__97);
					setState(1334);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
					case 1:
						{
						setState(1325);
						((ForAllContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1326);
						match(T__1);
						setState(1330);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
							{
							{
							setState(1327);
							((ForAllContext)_localctx).formula = formula(0);
							}
							}
							setState(1332);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1333);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1336);
					match(T__1);
					setState(1340);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
						{
						{
						setState(1337);
						((ForAllContext)_localctx).formula = formula(0);
						}
						}
						setState(1342);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1343);
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
				setState(1348);
				match(T__90);
				setState(1349);
				quantifierDeclarations();
				setState(1370);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__97:
					{
					setState(1350);
					match(T__97);
					setState(1360);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
					case 1:
						{
						setState(1351);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1352);
						match(T__1);
						setState(1356);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
							{
							{
							setState(1353);
							((ForSomeContext)_localctx).formula = formula(0);
							}
							}
							setState(1358);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1359);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1362);
					match(T__1);
					setState(1366);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
						{
						{
						setState(1363);
						((ForSomeContext)_localctx).formula = formula(0);
						}
						}
						setState(1368);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1369);
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
				setState(1374);
				match(T__87);
				setState(1375);
				quantifierDeclarations();
				setState(1396);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__97:
					{
					setState(1376);
					match(T__97);
					setState(1386);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
					case 1:
						{
						setState(1377);
						((ForNoContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1378);
						match(T__1);
						setState(1382);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
							{
							{
							setState(1379);
							((ForNoContext)_localctx).formula = formula(0);
							}
							}
							setState(1384);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1385);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1388);
					match(T__1);
					setState(1392);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
						{
						{
						setState(1389);
						((ForNoContext)_localctx).formula = formula(0);
						}
						}
						setState(1394);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1395);
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
				setState(1400);
				match(T__89);
				setState(1401);
				quantifierDeclarations();
				setState(1422);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__97:
					{
					setState(1402);
					match(T__97);
					setState(1412);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
					case 1:
						{
						setState(1403);
						((ForOneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1404);
						match(T__1);
						setState(1408);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
							{
							{
							setState(1405);
							((ForOneContext)_localctx).formula = formula(0);
							}
							}
							setState(1410);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1411);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1414);
					match(T__1);
					setState(1418);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
						{
						{
						setState(1415);
						((ForOneContext)_localctx).formula = formula(0);
						}
						}
						setState(1420);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1421);
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
				setState(1426);
				match(T__88);
				setState(1427);
				quantifierDeclarations();
				setState(1448);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__97:
					{
					setState(1428);
					match(T__97);
					setState(1438);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
					case 1:
						{
						setState(1429);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1430);
						match(T__1);
						setState(1434);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
							{
							{
							setState(1431);
							((ForLoneContext)_localctx).formula = formula(0);
							}
							}
							setState(1436);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1437);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1440);
					match(T__1);
					setState(1444);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
						{
						{
						setState(1441);
						((ForLoneContext)_localctx).formula = formula(0);
						}
						}
						setState(1446);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1447);
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
				setState(1452);
				match(T__112);
				setState(1453);
				letDeclarations();
				setState(1474);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__97:
					{
					setState(1454);
					match(T__97);
					setState(1464);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
					case 1:
						{
						setState(1455);
						((LetContext)_localctx).formula = formula(0);
						}
						break;
					case 2:
						{
						setState(1456);
						match(T__1);
						setState(1460);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
							{
							{
							setState(1457);
							((LetContext)_localctx).formula = formula(0);
							}
							}
							setState(1462);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1463);
						match(T__3);
						}
						break;
					}
					}
					break;
				case T__1:
					{
					setState(1466);
					match(T__1);
					setState(1470);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (T__1 - 2)) | (1L << (T__11 - 2)) | (1L << (T__14 - 2)) | (1L << (T__15 - 2)) | (1L << (T__17 - 2)) | (1L << (T__20 - 2)) | (1L << (T__21 - 2)) | (1L << (T__23 - 2)) | (1L << (T__24 - 2)) | (1L << (T__25 - 2)) | (1L << (T__26 - 2)) | (1L << (T__27 - 2)) | (1L << (T__29 - 2)) | (1L << (T__30 - 2)) | (1L << (T__31 - 2)) | (1L << (T__32 - 2)) | (1L << (T__33 - 2)) | (1L << (T__34 - 2)) | (1L << (T__35 - 2)) | (1L << (T__37 - 2)) | (1L << (T__39 - 2)) | (1L << (T__41 - 2)) | (1L << (T__42 - 2)) | (1L << (T__43 - 2)) | (1L << (T__44 - 2)) | (1L << (T__46 - 2)) | (1L << (T__47 - 2)) | (1L << (T__48 - 2)) | (1L << (T__50 - 2)) | (1L << (T__52 - 2)) | (1L << (T__56 - 2)) | (1L << (T__57 - 2)) | (1L << (T__58 - 2)) | (1L << (T__60 - 2)) | (1L << (T__61 - 2)) | (1L << (T__62 - 2)) | (1L << (T__63 - 2)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (T__75 - 76)) | (1L << (T__76 - 76)) | (1L << (T__77 - 76)) | (1L << (T__78 - 76)) | (1L << (T__80 - 76)) | (1L << (T__82 - 76)) | (1L << (T__83 - 76)) | (1L << (T__87 - 76)) | (1L << (T__88 - 76)) | (1L << (T__89 - 76)) | (1L << (T__90 - 76)) | (1L << (T__91 - 76)) | (1L << (T__92 - 76)) | (1L << (T__96 - 76)) | (1L << (T__98 - 76)) | (1L << (T__99 - 76)) | (1L << (T__101 - 76)) | (1L << (T__106 - 76)) | (1L << (T__107 - 76)) | (1L << (T__111 - 76)) | (1L << (T__112 - 76)) | (1L << (T__113 - 76)) | (1L << (T__114 - 76)) | (1L << (T__118 - 76)) | (1L << (T__119 - 76)) | (1L << (T__120 - 76)) | (1L << (T__121 - 76)) | (1L << (T__131 - 76)) | (1L << (T__132 - 76)) | (1L << (T__133 - 76)) | (1L << (INT - 76)) | (1L << (IDENTIFIER - 76)))) != 0)) {
						{
						{
						setState(1467);
						((LetContext)_localctx).formula = formula(0);
						}
						}
						setState(1472);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1473);
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
				setState(1478);
				match(T__14);
				((TrueContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 24:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1480);
				match(T__15);
				((FalseContext)_localctx).element =  Formula.create(_localctx);
				}
				break;
			case 25:
				{
				_localctx = new F_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1482);
				match(T__48);
				setState(1483);
				((F_paranthesisContext)_localctx).formula = formula(0);
				setState(1484);
				match(T__49);
				((F_paranthesisContext)_localctx).element =  ((F_paranthesisContext)_localctx).formula.element;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1511);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,205,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1509);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FormulaContext(_parentctx, _parentState));
						((AndContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1489);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1490);
						((AndContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__102 || _la==T__103) ) {
							((AndContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1491);
						((AndContext)_localctx).fright = ((AndContext)_localctx).formula = formula(14);
						((AndContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FormulaContext(_parentctx, _parentState));
						((OrContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1494);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1495);
						((OrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__104 || _la==T__105) ) {
							((OrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1496);
						((OrContext)_localctx).fright = ((OrContext)_localctx).formula = formula(13);
						((OrContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new ImpliesContext(new FormulaContext(_parentctx, _parentState));
						((ImpliesContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1499);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1500);
						((ImpliesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (T__106 - 107)) | (1L << (T__107 - 107)) | (1L << (T__108 - 107)))) != 0)) ) {
							((ImpliesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1501);
						((ImpliesContext)_localctx).fright = ((ImpliesContext)_localctx).formula = formula(11);
						((ImpliesContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new IffContext(new FormulaContext(_parentctx, _parentState));
						((IffContext)_localctx).fleft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(1504);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1505);
						((IffContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__109 || _la==T__110) ) {
							((IffContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1506);
						((IffContext)_localctx).fright = ((IffContext)_localctx).formula = formula(10);
						((IffContext)_localctx).element =  Formula.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1513);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,205,_ctx);
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
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1558);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__113:
				{
				_localctx = new TransposeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1515);
				match(T__113);
				setState(1516);
				((TransposeContext)_localctx).expression = expression(18);
				((TransposeContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__114:
				{
				_localctx = new ClosureContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1519);
				match(T__114);
				setState(1520);
				((ClosureContext)_localctx).expression = expression(17);
				((ClosureContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__52:
				{
				_localctx = new ReflexiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1523);
				match(T__52);
				setState(1524);
				((ReflexiveContext)_localctx).expression = expression(16);
				((ReflexiveContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__1:
				{
				_localctx = new ComprehensionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1527);
				match(T__1);
				setState(1528);
				comprehensionDeclarations();
				setState(1529);
				match(T__97);
				setState(1530);
				formula(0);
				setState(1531);
				match(T__3);
				((ComprehensionContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__106:
			case T__107:
				{
				_localctx = new IfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1534);
				((IfExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__106 || _la==T__107) ) {
					((IfExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1535);
				((IfExpressionContext)_localctx).condition = formula(0);
				setState(1536);
				match(T__116);
				setState(1537);
				((IfExpressionContext)_localctx).thenExpr = ((IfExpressionContext)_localctx).expression = expression(0);
				setState(1538);
				match(T__117);
				setState(1539);
				((IfExpressionContext)_localctx).elseExpr = ((IfExpressionContext)_localctx).expression = expression(7);
				((IfExpressionContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__118:
				{
				_localctx = new IdenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1542);
				match(T__118);
				((IdenContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__119:
				{
				_localctx = new NoneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1544);
				match(T__119);
				((NoneContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__120:
				{
				_localctx = new UnivContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1546);
				match(T__120);
				((UnivContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__121:
				{
				_localctx = new IntsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1548);
				match(T__121);
				((IntsContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			case T__48:
				{
				_localctx = new E_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1550);
				match(T__48);
				setState(1551);
				((E_paranthesisContext)_localctx).expression = expression(0);
				setState(1552);
				match(T__49);
				((E_paranthesisContext)_localctx).element =  ((E_paranthesisContext)_localctx).expression.element;
				}
				break;
			case T__11:
			case T__20:
			case T__21:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__37:
			case T__39:
			case T__41:
			case T__43:
			case T__44:
			case T__46:
			case T__47:
			case T__50:
			case T__56:
			case T__57:
			case T__58:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__75:
			case T__76:
			case T__77:
			case T__78:
			case T__80:
			case T__82:
			case T__83:
			case T__131:
			case T__132:
			case T__133:
			case IDENTIFIER:
				{
				_localctx = new TypeRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1555);
				pathName(_localctx.element);
				((TypeRefContext)_localctx).element =  Expression.create(_localctx);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1604);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,210,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1602);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExpressionContext(_parentctx, _parentState));
						((UnionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1560);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1561);
						match(T__16);
						setState(1562);
						((UnionContext)_localctx).right = ((UnionContext)_localctx).expression = expression(16);
						((UnionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new IntersectionContext(new ExpressionContext(_parentctx, _parentState));
						((IntersectionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1565);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1566);
						match(T__66);
						setState(1567);
						((IntersectionContext)_localctx).right = ((IntersectionContext)_localctx).expression = expression(15);
						((IntersectionContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExpressionContext(_parentctx, _parentState));
						((DifferenceContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1570);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1571);
						match(T__17);
						setState(1572);
						((DifferenceContext)_localctx).right = ((DifferenceContext)_localctx).expression = expression(14);
						((DifferenceContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new JoinContext(new ExpressionContext(_parentctx, _parentState));
						((JoinContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1575);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1576);
						match(T__18);
						setState(1577);
						((JoinContext)_localctx).right = ((JoinContext)_localctx).expression = expression(13);
						((JoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new ProductContext(new ExpressionContext(_parentctx, _parentState));
						((ProductContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1580);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1582);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)) | (1L << (T__130 - 89)))) != 0)) {
							{
							setState(1581);
							((ProductContext)_localctx).leftMult = mult();
							}
						}

						setState(1584);
						match(T__100);
						setState(1586);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)) | (1L << (T__130 - 89)))) != 0)) {
							{
							setState(1585);
							((ProductContext)_localctx).rightMult = mult();
							}
						}

						setState(1588);
						((ProductContext)_localctx).right = ((ProductContext)_localctx).expression = expression(10);
						((ProductContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 6:
						{
						_localctx = new OverrideContext(new ExpressionContext(_parentctx, _parentState));
						((OverrideContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1591);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1592);
						match(T__115);
						setState(1593);
						((OverrideContext)_localctx).right = ((OverrideContext)_localctx).expression = expression(10);
						((OverrideContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					case 7:
						{
						_localctx = new BoxJoinContext(new ExpressionContext(_parentctx, _parentState));
						((BoxJoinContext)_localctx).right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1596);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1597);
						match(T__12);
						setState(1598);
						((BoxJoinContext)_localctx).left = ((BoxJoinContext)_localctx).expression = expression(0);
						setState(1599);
						match(T__13);
						((BoxJoinContext)_localctx).element =  Expression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1606);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,210,_ctx);
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
		int _startState = 114;
		enterRecursionRule(_localctx, 114, RULE_intExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1634);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__106:
			case T__107:
				{
				_localctx = new IfIntExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1608);
				((IfIntExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__106 || _la==T__107) ) {
					((IfIntExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1609);
				((IfIntExpressionContext)_localctx).condition = formula(0);
				setState(1610);
				match(T__116);
				setState(1611);
				((IfIntExpressionContext)_localctx).thenExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(0);
				setState(1612);
				match(T__117);
				setState(1613);
				((IfIntExpressionContext)_localctx).elseExpr = ((IfIntExpressionContext)_localctx).intExpression = intExpression(10);
				((IfIntExpressionContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__96:
				{
				_localctx = new SumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1616);
				match(T__96);
				setState(1617);
				expression(0);
				((SumContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__42:
				{
				_localctx = new CountContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1620);
				match(T__42);
				setState(1621);
				expression(0);
				((CountContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__17:
			case INT:
				{
				_localctx = new IntConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1625);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(1624);
					((IntConstantContext)_localctx).sign = match(T__17);
					}
				}

				setState(1627);
				match(INT);
				((IntConstantContext)_localctx).element =  IntExpression.create(_localctx);
				}
				break;
			case T__48:
				{
				_localctx = new I_paranthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1629);
				match(T__48);
				setState(1630);
				((I_paranthesisContext)_localctx).intExpression = intExpression(0);
				setState(1631);
				match(T__49);
				((I_paranthesisContext)_localctx).element =  ((I_paranthesisContext)_localctx).intExpression.element;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1663);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1661);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new IntExpressionContext(_parentctx, _parentState));
						((PlusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1636);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1637);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__122) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1638);
						((PlusContext)_localctx).iright = ((PlusContext)_localctx).intExpression = intExpression(8);
						((PlusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new IntExpressionContext(_parentctx, _parentState));
						((MinusContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1641);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1642);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__123) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1643);
						((MinusContext)_localctx).iright = ((MinusContext)_localctx).intExpression = intExpression(7);
						((MinusContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 3:
						{
						_localctx = new MultiplyContext(new IntExpressionContext(_parentctx, _parentState));
						((MultiplyContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1646);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1647);
						_la = _input.LA(1);
						if ( !(_la==T__52 || _la==T__124) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1648);
						((MultiplyContext)_localctx).iright = ((MultiplyContext)_localctx).intExpression = intExpression(6);
						((MultiplyContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 4:
						{
						_localctx = new DivideContext(new IntExpressionContext(_parentctx, _parentState));
						((DivideContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1651);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1652);
						_la = _input.LA(1);
						if ( !(_la==T__125 || _la==T__126) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1653);
						((DivideContext)_localctx).iright = ((DivideContext)_localctx).intExpression = intExpression(5);
						((DivideContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new IntExpressionContext(_parentctx, _parentState));
						((ModuloContext)_localctx).ileft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
						setState(1656);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1657);
						_la = _input.LA(1);
						if ( !(_la==T__127 || _la==T__128) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1658);
						((ModuloContext)_localctx).iright = ((ModuloContext)_localctx).intExpression = intExpression(4);
						((ModuloContext)_localctx).element =  IntExpression.create(_localctx);
						}
						break;
					}
					} 
				}
				setState(1665);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
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
		enterRule(_localctx, 116, RULE_quantifierDeclarations);
		((QuantifierDeclarationsContext)_localctx).elements =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1666);
			quantifierDeclaration();
			setState(1671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1667);
				match(T__2);
				setState(1668);
				quantifierDeclaration();
				}
				}
				setState(1673);
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
		enterRule(_localctx, 118, RULE_quantifierDeclaration);
		int _la;
		try {
			setState(1740);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
			case 1:
				_localctx = new OneOfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1675);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__129) {
					{
					setState(1674);
					((OneOfContext)_localctx).disj = match(T__129);
					}
				}

				setState(1677);
				((OneOfContext)_localctx).variable = variable();
				((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
				setState(1682);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1678);
					match(T__2);
					setState(1679);
					((OneOfContext)_localctx).variable = variable();
					((OneOfContext)_localctx).vars.add(((OneOfContext)_localctx).variable);
					}
					}
					setState(1684);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1685);
				match(T__5);
				setState(1687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__89) {
					{
					setState(1686);
					match(T__89);
					}
				}

				setState(1689);
				expression(0);
				((OneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
				}
				break;
			case 2:
				_localctx = new LoneOfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1693);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__129) {
					{
					setState(1692);
					((LoneOfContext)_localctx).disj = match(T__129);
					}
				}

				setState(1695);
				((LoneOfContext)_localctx).variable = variable();
				((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
				setState(1700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1696);
					match(T__2);
					setState(1697);
					((LoneOfContext)_localctx).variable = variable();
					((LoneOfContext)_localctx).vars.add(((LoneOfContext)_localctx).variable);
					}
					}
					setState(1702);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1703);
				match(T__5);
				setState(1704);
				match(T__88);
				setState(1705);
				expression(0);
				((LoneOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
				}
				break;
			case 3:
				_localctx = new SomeOfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1709);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__129) {
					{
					setState(1708);
					((SomeOfContext)_localctx).disj = match(T__129);
					}
				}

				setState(1711);
				((SomeOfContext)_localctx).variable = variable();
				((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
				setState(1716);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1712);
					match(T__2);
					setState(1713);
					((SomeOfContext)_localctx).variable = variable();
					((SomeOfContext)_localctx).vars.add(((SomeOfContext)_localctx).variable);
					}
					}
					setState(1718);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1719);
				match(T__5);
				setState(1720);
				match(T__90);
				setState(1721);
				expression(0);
				((SomeOfContext)_localctx).element =  QuantifierDeclaration.create(_localctx);
				}
				break;
			case 4:
				_localctx = new SetOfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1725);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__129) {
					{
					setState(1724);
					((SetOfContext)_localctx).disj = match(T__129);
					}
				}

				setState(1727);
				((SetOfContext)_localctx).variable = variable();
				((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
				setState(1732);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1728);
					match(T__2);
					setState(1729);
					((SetOfContext)_localctx).variable = variable();
					((SetOfContext)_localctx).vars.add(((SetOfContext)_localctx).variable);
					}
					}
					setState(1734);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1735);
				match(T__5);
				setState(1736);
				match(T__130);
				setState(1737);
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
		enterRule(_localctx, 120, RULE_letDeclarations);
		((LetDeclarationsContext)_localctx).elements =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1742);
			letDeclaration();
			setState(1747);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1743);
				match(T__2);
				setState(1744);
				letDeclaration();
				}
				}
				setState(1749);
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
		enterRule(_localctx, 122, RULE_letDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1750);
			((LetDeclarationContext)_localctx).variable = variable();
			((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
			setState(1755);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1751);
				match(T__2);
				setState(1752);
				((LetDeclarationContext)_localctx).variable = variable();
				((LetDeclarationContext)_localctx).vars.add(((LetDeclarationContext)_localctx).variable);
				}
				}
				setState(1757);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1758);
			match(T__22);
			setState(1759);
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
		enterRule(_localctx, 124, RULE_comprehensionDeclarations);
		((ComprehensionDeclarationsContext)_localctx).elements =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1762);
			comprehensionDeclaration();
			setState(1767);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1763);
				match(T__2);
				setState(1764);
				comprehensionDeclaration();
				}
				}
				setState(1769);
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
		enterRule(_localctx, 126, RULE_comprehensionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1771);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__129) {
				{
				setState(1770);
				((ComprehensionDeclarationContext)_localctx).disj = match(T__129);
				}
			}

			{
			setState(1773);
			((ComprehensionDeclarationContext)_localctx).variable = variable();
			((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
			setState(1778);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1774);
				match(T__2);
				setState(1775);
				((ComprehensionDeclarationContext)_localctx).variable = variable();
				((ComprehensionDeclarationContext)_localctx).vars.add(((ComprehensionDeclarationContext)_localctx).variable);
				}
				}
				setState(1780);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1781);
			match(T__5);
			setState(1783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__89) {
				{
				setState(1782);
				match(T__89);
				}
			}

			setState(1785);
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
		enterRule(_localctx, 128, RULE_relationId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1789);
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
		enterRule(_localctx, 130, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1791);
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
		enterRule(_localctx, 132, RULE_mult);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1794);
			_la = _input.LA(1);
			if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)) | (1L << (T__130 - 89)))) != 0)) ) {
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
		enterRule(_localctx, 134, RULE_unrestrictedName);
		try {
			setState(1838);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1796);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1797);
				match(T__23);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1798);
				match(T__32);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1799);
				match(T__75);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1800);
				match(T__76);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1801);
				match(T__24);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1802);
				match(T__43);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1803);
				match(T__57);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1804);
				match(T__131);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1805);
				match(T__83);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1806);
				match(T__33);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1807);
				match(T__60);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1808);
				match(T__132);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1809);
				match(T__26);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1810);
				match(T__34);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1811);
				match(T__20);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1812);
				match(T__82);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1813);
				match(T__25);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1814);
				match(T__46);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(1815);
				match(T__11);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(1816);
				match(T__47);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(1817);
				match(T__35);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(1818);
				match(T__21);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(1819);
				match(T__80);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(1820);
				match(T__78);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(1821);
				match(T__56);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(1822);
				match(T__41);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(1823);
				match(T__31);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(1824);
				match(T__63);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(1825);
				match(T__133);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(1826);
				match(T__44);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(1827);
				match(T__27);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(1828);
				match(T__50);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(1829);
				match(T__29);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(1830);
				match(T__37);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(1831);
				match(T__39);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(1832);
				match(T__30);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(1833);
				match(T__77);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(1834);
				match(T__61);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(1835);
				match(T__58);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(1836);
				match(T__62);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(1837);
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
		enterRule(_localctx, 136, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1840);
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
		enterRule(_localctx, 138, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1842);
			_la = _input.LA(1);
			if ( !(_la==T__52 || _la==INT) ) {
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
		enterRule(_localctx, 140, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1844);
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
		case 5:
			return slot_sempred((SlotContext)_localctx, predIndex);
		case 55:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 56:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 57:
			return intExpression_sempred((IntExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean slot_sempred(SlotContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return true;
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 10);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 11);
		}
		return true;
	}
	private boolean intExpression_sempred(IntExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 7);
		case 13:
			return precpred(_ctx, 6);
		case 14:
			return precpred(_ctx, 5);
		case 15:
			return precpred(_ctx, 4);
		case 16:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0091\u0739\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2"+
		"\3\2\3\2\3\2\3\2\7\2\u0096\n\2\f\2\16\2\u0099\13\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00a9\n\3\3\4\3\4\3\4\3\4\5\4"+
		"\u00af\n\4\3\4\7\4\u00b2\n\4\f\4\16\4\u00b5\13\4\3\4\3\4\3\4\5\4\u00ba"+
		"\n\4\3\5\3\5\3\5\3\5\5\5\u00c0\n\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6\u00c8\n"+
		"\6\3\6\3\6\3\6\3\6\3\6\7\6\u00cf\n\6\f\6\16\6\u00d2\13\6\3\6\3\6\3\6\5"+
		"\6\u00d7\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00df\n\7\f\7\16\7\u00e2\13\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00ea\n\7\f\7\16\7\u00ed\13\7\3\7\3\7\3\7"+
		"\5\7\u00f2\n\7\5\7\u00f4\n\7\3\b\3\b\5\b\u00f8\n\b\3\t\3\t\3\t\3\t\7\t"+
		"\u00fe\n\t\f\t\16\t\u0101\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u010e\n\13\3\f\3\f\3\r\3\r\3\16\5\16\u0115\n\16\3\16\3"+
		"\16\3\17\5\17\u011a\n\17\3\17\5\17\u011d\n\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\5\23\u0129\n\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u0130\n\23\3\23\3\23\7\23\u0134\n\23\f\23\16\23\u0137\13\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u0142\n\24\3\24\3\24\3\24\3\24"+
		"\3\25\5\25\u0149\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\7\25\u0164\n\25\f\25\16\25\u0167\13\25\3\25\3\25\5\25\u016b\n\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0176\n\26\3\27\5\27"+
		"\u0179\n\27\3\27\3\27\5\27\u017d\n\27\3\27\3\27\5\27\u0181\n\27\3\27\3"+
		"\27\5\27\u0185\n\27\3\27\3\27\3\27\5\27\u018a\n\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u0191\n\27\f\27\16\27\u0194\13\27\5\27\u0196\n\27\3\27\3\27"+
		"\3\27\5\27\u019b\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\7\27\u01ab\n\27\f\27\16\27\u01ae\13\27\3\27\3\27"+
		"\5\27\u01b2\n\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01ba\n\30\3\31\5"+
		"\31\u01bd\n\31\3\31\3\31\5\31\u01c1\n\31\3\31\3\31\5\31\u01c5\n\31\3\31"+
		"\5\31\u01c8\n\31\3\31\5\31\u01cb\n\31\3\31\5\31\u01ce\n\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\5\31\u01d7\n\31\3\31\3\31\3\31\5\31\u01dc\n\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01e8\n\31\3\31"+
		"\5\31\u01eb\n\31\6\31\u01ed\n\31\r\31\16\31\u01ee\3\31\5\31\u01f2\n\31"+
		"\3\31\3\31\3\31\3\31\7\31\u01f8\n\31\f\31\16\31\u01fb\13\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u0203\n\31\3\31\3\31\3\31\7\31\u0208\n\31\f"+
		"\31\16\31\u020b\13\31\3\31\3\31\5\31\u020f\n\31\3\31\3\31\3\32\5\32\u0214"+
		"\n\32\3\32\3\32\5\32\u0218\n\32\3\32\3\32\5\32\u021c\n\32\3\32\5\32\u021f"+
		"\n\32\3\32\5\32\u0222\n\32\3\32\5\32\u0225\n\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\5\32\u022d\n\32\3\32\3\32\3\32\3\32\5\32\u0233\n\32\3\32\3\32"+
		"\3\32\5\32\u0238\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u0246\n\32\3\32\5\32\u0249\n\32\6\32\u024b\n\32\r\32\16"+
		"\32\u024c\3\32\5\32\u0250\n\32\3\32\3\32\3\32\3\32\3\32\7\32\u0257\n\32"+
		"\f\32\16\32\u025a\13\32\3\32\3\32\5\32\u025e\n\32\3\32\3\32\3\32\7\32"+
		"\u0263\n\32\f\32\16\32\u0266\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u026e\n\32\3\32\3\32\3\32\7\32\u0273\n\32\f\32\16\32\u0276\13\32\3\32"+
		"\3\32\5\32\u027a\n\32\3\32\3\32\3\33\5\33\u027f\n\33\3\33\3\33\5\33\u0283"+
		"\n\33\3\33\3\33\5\33\u0287\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33"+
		"\u0290\n\33\f\33\16\33\u0293\13\33\5\33\u0295\n\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\5\33\u029d\n\33\5\33\u029f\n\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\7\33\u02a7\n\33\f\33\16\33\u02aa\13\33\5\33\u02ac\n\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\5\33\u02b4\n\33\3\33\5\33\u02b7\n\33\6\33\u02b9\n\33"+
		"\r\33\16\33\u02ba\3\33\5\33\u02be\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u02cd\n\33\f\33\16\33\u02d0\13"+
		"\33\3\33\3\33\5\33\u02d4\n\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u02e4\n\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u02ec\n\36\3\36\5\36\u02ef\n\36\6\36\u02f1\n\36\r\36\16\36"+
		"\u02f2\3\36\5\36\u02f6\n\36\3\36\3\36\7\36\u02fa\n\36\f\36\16\36\u02fd"+
		"\13\36\3\36\3\36\5\36\u0301\n\36\3\36\3\36\3\37\3\37\3\37\3\37\5\37\u0309"+
		"\n\37\3\37\5\37\u030c\n\37\3\37\3\37\5\37\u0310\n\37\3\37\3\37\3\37\3"+
		" \5 \u0316\n \3 \3 \5 \u031a\n \3 \3 \3 \3 \3 \5 \u0321\n \3 \3 \3 \5"+
		" \u0326\n \3 \3 \3 \3 \5 \u032c\n \3 \5 \u032f\n \3 \3 \3 \3 \3 \3 \3"+
		" \7 \u0338\n \f \16 \u033b\13 \3 \3 \5 \u033f\n \3 \3 \3!\5!\u0344\n!"+
		"\3!\3!\3!\3!\3!\3!\5!\u034c\n!\3!\3!\3!\5!\u0351\n!\3!\3!\3!\3!\5!\u0357"+
		"\n!\3!\5!\u035a\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0366\n!\f!\16!\u0369"+
		"\13!\3!\3!\5!\u036d\n!\3!\3!\3\"\3\"\3\"\5\"\u0374\n\"\3\"\3\"\3\"\3\""+
		"\5\"\u037a\n\"\3\"\3\"\3\"\7\"\u037f\n\"\f\"\16\"\u0382\13\"\3\"\3\"\3"+
		"\"\5\"\u0387\n\"\3#\3#\5#\u038b\n#\3#\3#\3#\3#\3#\3#\7#\u0393\n#\f#\16"+
		"#\u0396\13#\3#\3#\5#\u039a\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\6#\u03a7"+
		"\n#\r#\16#\u03a8\3#\3#\3#\5#\u03ae\n#\3$\5$\u03b1\n$\3$\3$\5$\u03b5\n"+
		"$\3$\3$\3%\3%\3%\3%\3%\3%\5%\u03bf\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\5&\u03cd\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u03d8\n\'\3("+
		"\3(\3(\3(\3)\3)\3)\3)\7)\u03e2\n)\f)\16)\u03e5\13)\3)\3)\3*\3*\3*\3*\3"+
		"*\3*\3*\7*\u03f0\n*\f*\16*\u03f3\13*\5*\u03f5\n*\3*\3*\3+\3+\3+\3+\3+"+
		"\3+\5+\u03ff\n+\3,\3,\3,\3,\3,\7,\u0406\n,\f,\16,\u0409\13,\3,\3,\5,\u040d"+
		"\n,\3-\3-\3-\3-\3-\3-\5-\u0415\n-\3.\3.\3.\3.\3.\3.\3.\5.\u041e\n.\3/"+
		"\3/\3/\5/\u0423\n/\3/\7/\u0426\n/\f/\16/\u0429\13/\3/\5/\u042c\n/\3\60"+
		"\3\60\5\60\u0430\n\60\3\60\3\60\3\60\5\60\u0435\n\60\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0441\n\61\3\62\3\62\5\62\u0445"+
		"\n\62\3\62\3\62\3\62\5\62\u044a\n\62\3\62\3\62\5\62\u044e\n\62\3\62\3"+
		"\62\3\63\5\63\u0453\n\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u045b\n\63"+
		"\5\63\u045d\n\63\3\63\3\63\3\63\5\63\u0462\n\63\3\63\3\63\5\63\u0466\n"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\5\64\u046f\n\64\5\64\u0471\n\64"+
		"\3\64\3\64\3\64\5\64\u0476\n\64\3\64\3\64\5\64\u047a\n\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\65\3\65\5\65\u0483\n\65\5\65\u0485\n\65\3\65\3\65\3\65"+
		"\5\65\u048a\n\65\3\65\3\65\5\65\u048e\n\65\3\65\3\65\3\66\3\66\5\66\u0494"+
		"\n\66\3\66\3\66\3\66\5\66\u0499\n\66\3\66\3\66\5\66\u049d\n\66\3\66\3"+
		"\66\3\67\3\67\5\67\u04a3\n\67\3\67\3\67\3\67\5\67\u04a8\n\67\3\67\3\67"+
		"\5\67\u04ac\n\67\3\67\3\67\38\38\38\58\u04b3\n8\38\38\39\39\39\39\39\3"+
		"9\39\39\39\39\39\39\39\39\39\39\39\39\39\59\u04ca\n9\39\39\39\39\39\3"+
		"9\59\u04d2\n9\39\39\39\39\39\39\59\u04da\n9\39\39\39\39\39\39\59\u04e2"+
		"\n9\39\39\39\39\39\39\59\u04ea\n9\39\39\39\39\39\39\59\u04f2\n9\39\39"+
		"\39\39\39\39\59\u04fa\n9\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\59\u0514\n9\39\59\u0517\n9\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\79\u0533"+
		"\n9\f9\169\u0536\139\39\59\u0539\n9\39\39\79\u053d\n9\f9\169\u0540\13"+
		"9\39\59\u0543\n9\39\39\39\39\39\39\39\39\79\u054d\n9\f9\169\u0550\139"+
		"\39\59\u0553\n9\39\39\79\u0557\n9\f9\169\u055a\139\39\59\u055d\n9\39\3"+
		"9\39\39\39\39\39\39\79\u0567\n9\f9\169\u056a\139\39\59\u056d\n9\39\39"+
		"\79\u0571\n9\f9\169\u0574\139\39\59\u0577\n9\39\39\39\39\39\39\39\39\7"+
		"9\u0581\n9\f9\169\u0584\139\39\59\u0587\n9\39\39\79\u058b\n9\f9\169\u058e"+
		"\139\39\59\u0591\n9\39\39\39\39\39\39\39\39\79\u059b\n9\f9\169\u059e\13"+
		"9\39\59\u05a1\n9\39\39\79\u05a5\n9\f9\169\u05a8\139\39\59\u05ab\n9\39"+
		"\39\39\39\39\39\39\39\79\u05b5\n9\f9\169\u05b8\139\39\59\u05bb\n9\39\3"+
		"9\79\u05bf\n9\f9\169\u05c2\139\39\59\u05c5\n9\39\39\39\39\39\39\39\39"+
		"\39\39\39\59\u05d2\n9\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\79\u05e8\n9\f9\169\u05eb\139\3:\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u0619\n:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u0631\n:\3:\3:\5:\u0635"+
		"\n:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\7:\u0645\n:\f:\16:\u0648"+
		"\13:\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u065c\n"+
		";\3;\3;\3;\3;\3;\3;\3;\5;\u0665\n;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3"+
		";\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\7;\u0680\n;\f;\16;\u0683\13;"+
		"\3<\3<\3<\7<\u0688\n<\f<\16<\u068b\13<\3=\5=\u068e\n=\3=\3=\3=\7=\u0693"+
		"\n=\f=\16=\u0696\13=\3=\3=\5=\u069a\n=\3=\3=\3=\3=\5=\u06a0\n=\3=\3=\3"+
		"=\7=\u06a5\n=\f=\16=\u06a8\13=\3=\3=\3=\3=\3=\3=\5=\u06b0\n=\3=\3=\3="+
		"\7=\u06b5\n=\f=\16=\u06b8\13=\3=\3=\3=\3=\3=\3=\5=\u06c0\n=\3=\3=\3=\7"+
		"=\u06c5\n=\f=\16=\u06c8\13=\3=\3=\3=\3=\3=\5=\u06cf\n=\3>\3>\3>\7>\u06d4"+
		"\n>\f>\16>\u06d7\13>\3?\3?\3?\7?\u06dc\n?\f?\16?\u06df\13?\3?\3?\3?\3"+
		"?\3@\3@\3@\7@\u06e8\n@\f@\16@\u06eb\13@\3A\5A\u06ee\nA\3A\3A\3A\7A\u06f3"+
		"\nA\fA\16A\u06f6\13A\3A\3A\5A\u06fa\nA\3A\3A\3A\3A\3B\3B\3C\3C\3C\3D\3"+
		"D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\5E\u0731\n"+
		"E\3F\3F\3G\3G\3H\3H\3H\2\5prtI\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\2\26\3\2\21\22\3\2\23\24\4\2\23\23"+
		"\678\3\2\u008d\u008e\4\2\35\35FF\3\2QR\3\2ST\3\2^_\3\2ij\3\2kl\3\2mo\3"+
		"\2pq\3\2mn\4\2\23\23}}\4\2\24\24~~\4\2\67\67\177\177\3\2\u0080\u0081\3"+
		"\2\u0082\u0083\4\2[]\u0085\u0085\4\2\67\67\u0089\u0089\u0863\2\u0090\3"+
		"\2\2\2\4\u00a8\3\2\2\2\6\u00ae\3\2\2\2\b\u00bb\3\2\2\2\n\u00c4\3\2\2\2"+
		"\f\u00d8\3\2\2\2\16\u00f7\3\2\2\2\20\u00f9\3\2\2\2\22\u0104\3\2\2\2\24"+
		"\u010d\3\2\2\2\26\u010f\3\2\2\2\30\u0111\3\2\2\2\32\u0114\3\2\2\2\34\u0119"+
		"\3\2\2\2\36\u0121\3\2\2\2 \u0123\3\2\2\2\"\u0125\3\2\2\2$\u0128\3\2\2"+
		"\2&\u013d\3\2\2\2(\u0148\3\2\2\2*\u0175\3\2\2\2,\u0178\3\2\2\2.\u01b9"+
		"\3\2\2\2\60\u01bc\3\2\2\2\62\u0213\3\2\2\2\64\u027e\3\2\2\2\66\u02d7\3"+
		"\2\2\28\u02da\3\2\2\2:\u02dd\3\2\2\2<\u0304\3\2\2\2>\u0315\3\2\2\2@\u0343"+
		"\3\2\2\2B\u0373\3\2\2\2D\u0388\3\2\2\2F\u03b0\3\2\2\2H\u03be\3\2\2\2J"+
		"\u03cc\3\2\2\2L\u03d7\3\2\2\2N\u03d9\3\2\2\2P\u03dd\3\2\2\2R\u03e8\3\2"+
		"\2\2T\u03fe\3\2\2\2V\u0400\3\2\2\2X\u0414\3\2\2\2Z\u0416\3\2\2\2\\\u041f"+
		"\3\2\2\2^\u042d\3\2\2\2`\u0440\3\2\2\2b\u0442\3\2\2\2d\u0452\3\2\2\2f"+
		"\u0469\3\2\2\2h\u047d\3\2\2\2j\u0491\3\2\2\2l\u04a0\3\2\2\2n\u04b2\3\2"+
		"\2\2p\u05d1\3\2\2\2r\u0618\3\2\2\2t\u0664\3\2\2\2v\u0684\3\2\2\2x\u06ce"+
		"\3\2\2\2z\u06d0\3\2\2\2|\u06d8\3\2\2\2~\u06e4\3\2\2\2\u0080\u06ed\3\2"+
		"\2\2\u0082\u06ff\3\2\2\2\u0084\u0701\3\2\2\2\u0086\u0704\3\2\2\2\u0088"+
		"\u0730\3\2\2\2\u008a\u0732\3\2\2\2\u008c\u0734\3\2\2\2\u008e\u0736\3\2"+
		"\2\2\u0090\u0091\7\3\2\2\u0091\u0092\7\4\2\2\u0092\u0097\5\4\3\2\u0093"+
		"\u0094\7\5\2\2\u0094\u0096\5\4\3\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009b\7\6\2\2\u009b\3\3\2\2\2\u009c\u009d\7\7\2\2"+
		"\u009d\u009e\7\b\2\2\u009e\u00a9\7\u0089\2\2\u009f\u00a0\7\t\2\2\u00a0"+
		"\u00a1\7\b\2\2\u00a1\u00a9\7\u0089\2\2\u00a2\u00a3\7\n\2\2\u00a3\u00a4"+
		"\7\b\2\2\u00a4\u00a9\7\u0089\2\2\u00a5\u00a6\7\13\2\2\u00a6\u00a7\7\b"+
		"\2\2\u00a7\u00a9\7\u0089\2\2\u00a8\u009c\3\2\2\2\u00a8\u009f\3\2\2\2\u00a8"+
		"\u00a2\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a9\5\3\2\2\2\u00aa\u00ab\7\f\2\2"+
		"\u00ab\u00ac\5\u008aF\2\u00ac\u00ad\7\r\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00aa\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b3\3\2\2\2\u00b0\u00b2\5&"+
		"\24\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\5\b"+
		"\5\2\u00b7\u00ba\5\n\6\2\u00b8\u00ba\7\r\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00b8\3\2\2\2\u00ba\7\3\2\2\2\u00bb\u00bf\7\16\2\2\u00bc\u00bd\5\u0088"+
		"E\2\u00bd\u00be\7\b\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\u008d\2\2\u00c2\u00c3"+
		"\7\r\2\2\u00c3\t\3\2\2\2\u00c4\u00c5\5\\/\2\u00c5\u00c7\b\6\1\2\u00c6"+
		"\u00c8\5\24\13\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3"+
		"\2\2\2\u00c9\u00d6\b\6\1\2\u00ca\u00cb\7\4\2\2\u00cb\u00d0\5\f\7\2\u00cc"+
		"\u00cd\7\5\2\2\u00cd\u00cf\5\f\7\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d4\7\6\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d7\7\r"+
		"\2\2\u00d6\u00ca\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\13\3\2\2\2\u00d8\u00d9"+
		"\5\u0088E\2\u00d9\u00f3\b\7\1\2\u00da\u00f1\7\b\2\2\u00db\u00dc\6\7\2"+
		"\2\u00dc\u00e0\7\4\2\2\u00dd\u00df\5\n\6\2\u00de\u00dd\3\2\2\2\u00df\u00e2"+
		"\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00f2\7\6\2\2\u00e4\u00f2\5\22\n\2\u00e5\u00e6\7"+
		"\17\2\2\u00e6\u00eb\5\22\n\2\u00e7\u00e8\7\5\2\2\u00e8\u00ea\5\22\n\2"+
		"\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7\20\2\2"+
		"\u00ef\u00f2\3\2\2\2\u00f0\u00f2\5\16\b\2\u00f1\u00db\3\2\2\2\u00f1\u00e4"+
		"\3\2\2\2\u00f1\u00e5\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3"+
		"\u00da\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\r\3\2\2\2\u00f5\u00f8\5\24\13"+
		"\2\u00f6\u00f8\5\20\t\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8"+
		"\17\3\2\2\2\u00f9\u00fa\7\17\2\2\u00fa\u00ff\5\16\b\2\u00fb\u00fc\7\5"+
		"\2\2\u00fc\u00fe\5\16\b\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0102\u0103\7\20\2\2\u0103\21\3\2\2\2\u0104\u0105\5\\/\2\u0105\23"+
		"\3\2\2\2\u0106\u010e\5\26\f\2\u0107\u010e\5\32\16\2\u0108\u010e\5\34\17"+
		"\2\u0109\u010e\5\36\20\2\u010a\u010e\5 \21\2\u010b\u010e\5\30\r\2\u010c"+
		"\u010e\5\"\22\2\u010d\u0106\3\2\2\2\u010d\u0107\3\2\2\2\u010d\u0108\3"+
		"\2\2\2\u010d\u0109\3\2\2\2\u010d\u010a\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010c\3\2\2\2\u010e\25\3\2\2\2\u010f\u0110\5\u008aF\2\u0110\27\3\2\2"+
		"\2\u0111\u0112\t\2\2\2\u0112\31\3\2\2\2\u0113\u0115\t\3\2\2\u0114\u0113"+
		"\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\u0089\2"+
		"\2\u0117\33\3\2\2\2\u0118\u011a\t\3\2\2\u0119\u0118\3\2\2\2\u0119\u011a"+
		"\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u011d\7\u0089\2\2\u011c\u011b\3\2\2"+
		"\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7\25\2\2\u011f"+
		"\u0120\7\u0089\2\2\u0120\35\3\2\2\2\u0121\u0122\7\u008c\2\2\u0122\37\3"+
		"\2\2\2\u0123\u0124\7\u008b\2\2\u0124!\3\2\2\2\u0125\u0126\7\26\2\2\u0126"+
		"#\3\2\2\2\u0127\u0129\5\2\2\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2"+
		"\u0129\u012a\3\2\2\2\u012a\u012f\b\23\1\2\u012b\u012c\7\16\2\2\u012c\u012d"+
		"\5\u008aF\2\u012d\u012e\7\r\2\2\u012e\u0130\3\2\2\2\u012f\u012b\3\2\2"+
		"\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0135\b\23\1\2\u0132"+
		"\u0134\5&\24\2\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2"+
		"\2\2\u0135\u0136\3\2\2\2\u0136\u0138\3\2\2\2\u0137\u0135\3\2\2\2\u0138"+
		"\u0139\5(\25\2\u0139\u013a\b\23\1\2\u013a\u013b\3\2\2\2\u013b\u013c\b"+
		"\23\1\2\u013c%\3\2\2\2\u013d\u0141\7\27\2\2\u013e\u013f\5\u008aF\2\u013f"+
		"\u0140\7\b\2\2\u0140\u0142\3\2\2\2\u0141\u013e\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143\u0144\7\u008d\2\2\u0144\u0145\7\r\2\2\u0145"+
		"\u0146\b\24\1\2\u0146\'\3\2\2\2\u0147\u0149\5n8\2\u0148\u0147\3\2\2\2"+
		"\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\b\25\1\2\u014b\u014c"+
		"\7\30\2\2\u014c\u014d\5\u0088E\2\u014d\u014e\b\25\1\2\u014e\u014f\b\25"+
		"\1\2\u014f\u0150\7\b\2\2\u0150\u0151\5\u008aF\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0153\7\31\2\2\u0153\u0154\7\u008d\2\2\u0154\u0155\3\2\2\2\u0155\u016a"+
		"\b\25\1\2\u0156\u0165\7\4\2\2\u0157\u0158\5D#\2\u0158\u0159\b\25\1\2\u0159"+
		"\u0164\3\2\2\2\u015a\u015b\5(\25\2\u015b\u015c\b\25\1\2\u015c\u0164\3"+
		"\2\2\2\u015d\u015e\5*\26\2\u015e\u015f\b\25\1\2\u015f\u0164\3\2\2\2\u0160"+
		"\u0161\5d\63\2\u0161\u0162\b\25\1\2\u0162\u0164\3\2\2\2\u0163\u0157\3"+
		"\2\2\2\u0163\u015a\3\2\2\2\u0163\u015d\3\2\2\2\u0163\u0160\3\2\2\2\u0164"+
		"\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2"+
		"\2\2\u0167\u0165\3\2\2\2\u0168\u016b\7\6\2\2\u0169\u016b\7\r\2\2\u016a"+
		"\u0156\3\2\2\2\u016a\u0169\3\2\2\2\u016b)\3\2\2\2\u016c\u016d\5,\27\2"+
		"\u016d\u016e\b\26\1\2\u016e\u0176\3\2\2\2\u016f\u0170\5> \2\u0170\u0171"+
		"\b\26\1\2\u0171\u0176\3\2\2\2\u0172\u0173\5@!\2\u0173\u0174\b\26\1\2\u0174"+
		"\u0176\3\2\2\2\u0175\u016c\3\2\2\2\u0175\u016f\3\2\2\2\u0175\u0172\3\2"+
		"\2\2\u0176+\3\2\2\2\u0177\u0179\5n8\2\u0178\u0177\3\2\2\2\u0178\u0179"+
		"\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u0180\b\27\1\2\u017b\u017d\7\32\2\2"+
		"\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0181"+
		"\7\33\2\2\u017f\u0181\7\34\2\2\u0180\u017c\3\2\2\2\u0180\u017f\3\2\2\2"+
		"\u0181\u0182\3\2\2\2\u0182\u0184\b\27\1\2\u0183\u0185\5\u0088E\2\u0184"+
		"\u0183\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\b\27"+
		"\1\2\u0187\u0189\b\27\1\2\u0188\u018a\5P)\2\u0189\u0188\3\2\2\2\u0189"+
		"\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u0195\b\27\1\2\u018c\u018d\7"+
		"\35\2\2\u018d\u0192\58\35\2\u018e\u018f\7\5\2\2\u018f\u0191\58\35\2\u0190"+
		"\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2"+
		"\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u018c\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u019a\b\27\1\2\u0198\u0199\7"+
		"\b\2\2\u0199\u019b\7\u008d\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2"+
		"\u019b\u019c\3\2\2\2\u019c\u01b1\b\27\1\2\u019d\u01ac\7\4\2\2\u019e\u019f"+
		"\5D#\2\u019f\u01a0\b\27\1\2\u01a0\u01ab\3\2\2\2\u01a1\u01a2\5\64\33\2"+
		"\u01a2\u01a3\b\27\1\2\u01a3\u01ab\3\2\2\2\u01a4\u01a5\5.\30\2\u01a5\u01a6"+
		"\b\27\1\2\u01a6\u01ab\3\2\2\2\u01a7\u01a8\5d\63\2\u01a8\u01a9\b\27\1\2"+
		"\u01a9\u01ab\3\2\2\2\u01aa\u019e\3\2\2\2\u01aa\u01a1\3\2\2\2\u01aa\u01a4"+
		"\3\2\2\2\u01aa\u01a7\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b2\7\6"+
		"\2\2\u01b0\u01b2\7\r\2\2\u01b1\u019d\3\2\2\2\u01b1\u01b0\3\2\2\2\u01b2"+
		"-\3\2\2\2\u01b3\u01b4\5\60\31\2\u01b4\u01b5\b\30\1\2\u01b5\u01ba\3\2\2"+
		"\2\u01b6\u01b7\5\62\32\2\u01b7\u01b8\b\30\1\2\u01b8\u01ba\3\2\2\2\u01b9"+
		"\u01b3\3\2\2\2\u01b9\u01b6\3\2\2\2\u01ba/\3\2\2\2\u01bb\u01bd\5n8\2\u01bc"+
		"\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c0\b\31"+
		"\1\2\u01bf\u01c1\7\36\2\2\u01c0\u01bf\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1"+
		"\u01c4\3\2\2\2\u01c2\u01c5\7\16\2\2\u01c3\u01c5\7\37\2\2\u01c4\u01c2\3"+
		"\2\2\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6"+
		"\u01c8\7 \2\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2"+
		"\2\2\u01c9\u01cb\7!\2\2\u01ca\u01c9\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb"+
		"\u01cd\3\2\2\2\u01cc\u01ce\7\"\2\2\u01cd\u01cc\3\2\2\2\u01cd\u01ce\3\2"+
		"\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\7#\2\2\u01d0\u01d1\5\u0088E\2\u01d1"+
		"\u01d2\b\31\1\2\u01d2\u01d3\b\31\1\2\u01d3\u01d4\7\b\2\2\u01d4\u01d6\5"+
		"X-\2\u01d5\u01d7\5<\37\2\u01d6\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7"+
		"\u01d8\3\2\2\2\u01d8\u01db\b\31\1\2\u01d9\u01da\7\31\2\2\u01da\u01dc\7"+
		"\u008d\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\3\2\2\2"+
		"\u01dd\u01f1\b\31\1\2\u01de\u01ec\7\4\2\2\u01df\u01e8\7$\2\2\u01e0\u01e8"+
		"\7%\2\2\u01e1\u01e8\7&\2\2\u01e2\u01e8\7\'\2\2\u01e3\u01e8\7(\2\2\u01e4"+
		"\u01e8\7)\2\2\u01e5\u01e8\7*\2\2\u01e6\u01e8\7+\2\2\u01e7\u01df\3\2\2"+
		"\2\u01e7\u01e0\3\2\2\2\u01e7\u01e1\3\2\2\2\u01e7\u01e2\3\2\2\2\u01e7\u01e3"+
		"\3\2\2\2\u01e7\u01e4\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e6\3\2\2\2\u01e8"+
		"\u01ea\3\2\2\2\u01e9\u01eb\7\5\2\2\u01ea\u01e9\3\2\2\2\u01ea\u01eb\3\2"+
		"\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01e7\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee"+
		"\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f2\7\6"+
		"\2\2\u01f1\u01de\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u020e\3\2\2\2\u01f3"+
		"\u01f9\7\4\2\2\u01f4\u01f5\5D#\2\u01f5\u01f6\b\31\1\2\u01f6\u01f8\3\2"+
		"\2\2\u01f7\u01f4\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9"+
		"\u01fa\3\2\2\2\u01fa\u0202\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fc\u01fd\5l"+
		"\67\2\u01fd\u01fe\b\31\1\2\u01fe\u0203\3\2\2\2\u01ff\u0200\5j\66\2\u0200"+
		"\u0201\b\31\1\2\u0201\u0203\3\2\2\2\u0202\u01fc\3\2\2\2\u0202\u01ff\3"+
		"\2\2\2\u0202\u0203\3\2\2\2\u0203\u0209\3\2\2\2\u0204\u0205\5D#\2\u0205"+
		"\u0206\b\31\1\2\u0206\u0208\3\2\2\2\u0207\u0204\3\2\2\2\u0208\u020b\3"+
		"\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020c\3\2\2\2\u020b"+
		"\u0209\3\2\2\2\u020c\u020f\7\6\2\2\u020d\u020f\7\r\2\2\u020e\u01f3\3\2"+
		"\2\2\u020e\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\b\31\1\2\u0211"+
		"\61\3\2\2\2\u0212\u0214\5n8\2\u0213\u0212\3\2\2\2\u0213\u0214\3\2\2\2"+
		"\u0214\u0215\3\2\2\2\u0215\u0217\b\32\1\2\u0216\u0218\7\36\2\2\u0217\u0216"+
		"\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u021c\7\16\2\2"+
		"\u021a\u021c\7\37\2\2\u021b\u0219\3\2\2\2\u021b\u021a\3\2\2\2\u021b\u021c"+
		"\3\2\2\2\u021c\u021e\3\2\2\2\u021d\u021f\7 \2\2\u021e\u021d\3\2\2\2\u021e"+
		"\u021f\3\2\2\2\u021f\u0221\3\2\2\2\u0220\u0222\7!\2\2\u0221\u0220\3\2"+
		"\2\2\u0221\u0222\3\2\2\2\u0222\u0224\3\2\2\2\u0223\u0225\7\"\2\2\u0224"+
		"\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\7,"+
		"\2\2\u0227\u0228\5\u0088E\2\u0228\u0229\b\32\1\2\u0229\u022c\b\32\1\2"+
		"\u022a\u022b\7-\2\2\u022b\u022d\5\u0088E\2\u022c\u022a\3\2\2\2\u022c\u022d"+
		"\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f\b\32\1\2\u022f\u0230\7\b\2\2"+
		"\u0230\u0232\5X-\2\u0231\u0233\5<\37\2\u0232\u0231\3\2\2\2\u0232\u0233"+
		"\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0237\b\32\1\2\u0235\u0236\7\31\2\2"+
		"\u0236\u0238\7\u008d\2\2\u0237\u0235\3\2\2\2\u0237\u0238\3\2\2\2\u0238"+
		"\u0239\3\2\2\2\u0239\u024f\b\32\1\2\u023a\u024a\7\4\2\2\u023b\u0246\7"+
		".\2\2\u023c\u0246\7$\2\2\u023d\u0246\7&\2\2\u023e\u0246\7\'\2\2\u023f"+
		"\u0246\7(\2\2\u0240\u0246\7)\2\2\u0241\u0246\7/\2\2\u0242\u0246\7\60\2"+
		"\2\u0243\u0246\7*\2\2\u0244\u0246\7+\2\2\u0245\u023b\3\2\2\2\u0245\u023c"+
		"\3\2\2\2\u0245\u023d\3\2\2\2\u0245\u023e\3\2\2\2\u0245\u023f\3\2\2\2\u0245"+
		"\u0240\3\2\2\2\u0245\u0241\3\2\2\2\u0245\u0242\3\2\2\2\u0245\u0243\3\2"+
		"\2\2\u0245\u0244\3\2\2\2\u0246\u0248\3\2\2\2\u0247\u0249\7\5\2\2\u0248"+
		"\u0247\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024b\3\2\2\2\u024a\u0245\3\2"+
		"\2\2\u024b\u024c\3\2\2\2\u024c\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024d"+
		"\u024e\3\2\2\2\u024e\u0250\7\6\2\2\u024f\u023a\3\2\2\2\u024f\u0250\3\2"+
		"\2\2\u0250\u0279\3\2\2\2\u0251\u025d\7\4\2\2\u0252\u0253\7\61\2\2\u0253"+
		"\u0258\5\u0088E\2\u0254\u0255\7\5\2\2\u0255\u0257\5\u0088E\2\u0256\u0254"+
		"\3\2\2\2\u0257\u025a\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2\2\2\u0259"+
		"\u025b\3\2\2\2\u025a\u0258\3\2\2\2\u025b\u025c\7\r\2\2\u025c\u025e\3\2"+
		"\2\2\u025d\u0252\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u0264\3\2\2\2\u025f"+
		"\u0260\5D#\2\u0260\u0261\b\32\1\2\u0261\u0263\3\2\2\2\u0262\u025f\3\2"+
		"\2\2\u0263\u0266\3\2\2\2\u0264\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265"+
		"\u026d\3\2\2\2\u0266\u0264\3\2\2\2\u0267\u0268\5l\67\2\u0268\u0269\b\32"+
		"\1\2\u0269\u026e\3\2\2\2\u026a\u026b\5j\66\2\u026b\u026c\b\32\1\2\u026c"+
		"\u026e\3\2\2\2\u026d\u0267\3\2\2\2\u026d\u026a\3\2\2\2\u026d\u026e\3\2"+
		"\2\2\u026e\u0274\3\2\2\2\u026f\u0270\5D#\2\u0270\u0271\b\32\1\2\u0271"+
		"\u0273\3\2\2\2\u0272\u026f\3\2\2\2\u0273\u0276\3\2\2\2\u0274\u0272\3\2"+
		"\2\2\u0274\u0275\3\2\2\2\u0275\u0277\3\2\2\2\u0276\u0274\3\2\2\2\u0277"+
		"\u027a\7\6\2\2\u0278\u027a\7\r\2\2\u0279\u0251\3\2\2\2\u0279\u0278\3\2"+
		"\2\2\u027a\u027b\3\2\2\2\u027b\u027c\b\32\1\2\u027c\63\3\2\2\2\u027d\u027f"+
		"\5n8\2\u027e\u027d\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0280\3\2\2\2\u0280"+
		"\u0282\b\33\1\2\u0281\u0283\7\36\2\2\u0282\u0281\3\2\2\2\u0282\u0283\3"+
		"\2\2\2\u0283\u0284\3\2\2\2\u0284\u0286\7\62\2\2\u0285\u0287\5P)\2\u0286"+
		"\u0285\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0289\b\33"+
		"\1\2\u0289\u028a\5\u0088E\2\u028a\u028b\b\33\1\2\u028b\u0294\7\63\2\2"+
		"\u028c\u0291\5:\36\2\u028d\u028e\7\5\2\2\u028e\u0290\5:\36\2\u028f\u028d"+
		"\3\2\2\2\u0290\u0293\3\2\2\2\u0291\u028f\3\2\2\2\u0291\u0292\3\2\2\2\u0292"+
		"\u0295\3\2\2\2\u0293\u0291\3\2\2\2\u0294\u028c\3\2\2\2\u0294\u0295\3\2"+
		"\2\2\u0295\u0296\3\2\2\2\u0296\u0297\7\64\2\2\u0297\u0298\3\2\2\2\u0298"+
		"\u029e\b\33\1\2\u0299\u029a\7\b\2\2\u029a\u029c\5X-\2\u029b\u029d\5<\37"+
		"\2\u029c\u029b\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029f\3\2\2\2\u029e\u0299"+
		"\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u02a1\b\33\1\2"+
		"\u02a1\u02ab\b\33\1\2\u02a2\u02a3\7\65\2\2\u02a3\u02a8\5\66\34\2\u02a4"+
		"\u02a5\7\5\2\2\u02a5\u02a7\5\66\34\2\u02a6\u02a4\3\2\2\2\u02a7\u02aa\3"+
		"\2\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02ac\3\2\2\2\u02aa"+
		"\u02a8\3\2\2\2\u02ab\u02a2\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\3\2"+
		"\2\2\u02ad\u02bd\b\33\1\2\u02ae\u02b8\7\4\2\2\u02af\u02b4\7&\2\2\u02b0"+
		"\u02b4\7\'\2\2\u02b1\u02b4\7(\2\2\u02b2\u02b4\7)\2\2\u02b3\u02af\3\2\2"+
		"\2\u02b3\u02b0\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b2\3\2\2\2\u02b4\u02b6"+
		"\3\2\2\2\u02b5\u02b7\7\5\2\2\u02b6\u02b5\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7"+
		"\u02b9\3\2\2\2\u02b8\u02b3\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02b8\3\2"+
		"\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02be\7\6\2\2\u02bd"+
		"\u02ae\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02d3\3\2\2\2\u02bf\u02ce\7\4"+
		"\2\2\u02c0\u02c1\5D#\2\u02c1\u02c2\b\33\1\2\u02c2\u02cd\3\2\2\2\u02c3"+
		"\u02c4\5f\64\2\u02c4\u02c5\b\33\1\2\u02c5\u02cd\3\2\2\2\u02c6\u02c7\5"+
		"b\62\2\u02c7\u02c8\b\33\1\2\u02c8\u02cd\3\2\2\2\u02c9\u02ca\5h\65\2\u02ca"+
		"\u02cb\b\33\1\2\u02cb\u02cd\3\2\2\2\u02cc\u02c0\3\2\2\2\u02cc\u02c3\3"+
		"\2\2\2\u02cc\u02c6\3\2\2\2\u02cc\u02c9\3\2\2\2\u02cd\u02d0\3\2\2\2\u02ce"+
		"\u02cc\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d1\3\2\2\2\u02d0\u02ce\3\2"+
		"\2\2\u02d1\u02d4\7\6\2\2\u02d2\u02d4\7\r\2\2\u02d3\u02bf\3\2\2\2\u02d3"+
		"\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d6\b\33\1\2\u02d6\65\3\2\2"+
		"\2\u02d7\u02d8\5V,\2\u02d8\u02d9\b\34\1\2\u02d9\67\3\2\2\2\u02da\u02db"+
		"\5V,\2\u02db\u02dc\b\35\1\2\u02dc9\3\2\2\2\u02dd\u02de\5\u0088E\2\u02de"+
		"\u02df\b\36\1\2\u02df\u02e0\b\36\1\2\u02e0\u02e1\7\b\2\2\u02e1\u02e3\5"+
		"X-\2\u02e2\u02e4\5<\37\2\u02e3\u02e2\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4"+
		"\u02e5\3\2\2\2\u02e5\u02f5\b\36\1\2\u02e6\u02f0\7\4\2\2\u02e7\u02ec\7"+
		"&\2\2\u02e8\u02ec\7\'\2\2\u02e9\u02ec\7(\2\2\u02ea\u02ec\7)\2\2\u02eb"+
		"\u02e7\3\2\2\2\u02eb\u02e8\3\2\2\2\u02eb\u02e9\3\2\2\2\u02eb\u02ea\3\2"+
		"\2\2\u02ec\u02ee\3\2\2\2\u02ed\u02ef\7\5\2\2\u02ee\u02ed\3\2\2\2\u02ee"+
		"\u02ef\3\2\2\2\u02ef\u02f1\3\2\2\2\u02f0\u02eb\3\2\2\2\u02f1\u02f2\3\2"+
		"\2\2\u02f2\u02f0\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4"+
		"\u02f6\7\6\2\2\u02f5\u02e6\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u0300\3\2"+
		"\2\2\u02f7\u02fb\7\4\2\2\u02f8\u02fa\5D#\2\u02f9\u02f8\3\2\2\2\u02fa\u02fd"+
		"\3\2\2\2\u02fb\u02f9\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fe\3\2\2\2\u02fd"+
		"\u02fb\3\2\2\2\u02fe\u02ff\b\36\1\2\u02ff\u0301\7\6\2\2\u0300\u02f7\3"+
		"\2\2\2\u0300\u0301\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0303\b\36\1\2\u0303"+
		";\3\2\2\2\u0304\u030b\7\17\2\2\u0305\u0308\5\u008eH\2\u0306\u0307\7\66"+
		"\2\2\u0307\u0309\5\u008cG\2\u0308\u0306\3\2\2\2\u0308\u0309\3\2\2\2\u0309"+
		"\u030c\3\2\2\2\u030a\u030c\t\4\2\2\u030b\u0305\3\2\2\2\u030b\u030a\3\2"+
		"\2\2\u030c\u030f\3\2\2\2\u030d\u0310\79\2\2\u030e\u0310\7:\2\2\u030f\u030d"+
		"\3\2\2\2\u030f\u030e\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0311\3\2\2\2\u0311"+
		"\u0312\7\20\2\2\u0312\u0313\b\37\1\2\u0313=\3\2\2\2\u0314\u0316\5n8\2"+
		"\u0315\u0314\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0319"+
		"\b \1\2\u0318\u031a\7;\2\2\u0319\u0318\3\2\2\2\u0319\u031a\3\2\2\2\u031a"+
		"\u031b\3\2\2\2\u031b\u031c\7<\2\2\u031c\u031d\5\u0088E\2\u031d\u031e\b"+
		" \1\2\u031e\u0320\b \1\2\u031f\u0321\5P)\2\u0320\u031f\3\2\2\2\u0320\u0321"+
		"\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0325\b \1\2\u0323\u0324\7\b\2\2\u0324"+
		"\u0326\7\u008d\2\2\u0325\u0323\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0327"+
		"\3\2\2\2\u0327\u032e\b \1\2\u0328\u032b\7\4\2\2\u0329\u032c\7=\2\2\u032a"+
		"\u032c\7>\2\2\u032b\u0329\3\2\2\2\u032b\u032a\3\2\2\2\u032b\u032c\3\2"+
		"\2\2\u032c\u032d\3\2\2\2\u032d\u032f\7\6\2\2\u032e\u0328\3\2\2\2\u032e"+
		"\u032f\3\2\2\2\u032f\u033e\3\2\2\2\u0330\u0339\7\4\2\2\u0331\u0332\5D"+
		"#\2\u0332\u0333\b \1\2\u0333\u0338\3\2\2\2\u0334\u0335\5d\63\2\u0335\u0336"+
		"\b \1\2\u0336\u0338\3\2\2\2\u0337\u0331\3\2\2\2\u0337\u0334\3\2\2\2\u0338"+
		"\u033b\3\2\2\2\u0339\u0337\3\2\2\2\u0339\u033a\3\2\2\2\u033a\u033c\3\2"+
		"\2\2\u033b\u0339\3\2\2\2\u033c\u033f\7\6\2\2\u033d\u033f\7\r\2\2\u033e"+
		"\u0330\3\2\2\2\u033e\u033d\3\2\2\2\u033f\u0340\3\2\2\2\u0340\u0341\b "+
		"\1\2\u0341?\3\2\2\2\u0342\u0344\5n8\2\u0343\u0342\3\2\2\2\u0343\u0344"+
		"\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0346\b!\1\2\u0346\u0347\7?\2\2\u0347"+
		"\u0348\5\u0088E\2\u0348\u0349\b!\1\2\u0349\u034b\b!\1\2\u034a\u034c\5"+
		"P)\2\u034b\u034a\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034d\3\2\2\2\u034d"+
		"\u0350\b!\1\2\u034e\u034f\7\b\2\2\u034f\u0351\7\u008d\2\2\u0350\u034e"+
		"\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0359\b!\1\2\u0353"+
		"\u0356\7\4\2\2\u0354\u0357\7=\2\2\u0355\u0357\7>\2\2\u0356\u0354\3\2\2"+
		"\2\u0356\u0355\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035a"+
		"\7\6\2\2\u0359\u0353\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u036c\3\2\2\2\u035b"+
		"\u0367\7\4\2\2\u035c\u035d\5D#\2\u035d\u035e\b!\1\2\u035e\u0366\3\2\2"+
		"\2\u035f\u0360\5B\"\2\u0360\u0361\b!\1\2\u0361\u0366\3\2\2\2\u0362\u0363"+
		"\5d\63\2\u0363\u0364\b!\1\2\u0364\u0366\3\2\2\2\u0365\u035c\3\2\2\2\u0365"+
		"\u035f\3\2\2\2\u0365\u0362\3\2\2\2\u0366\u0369\3\2\2\2\u0367\u0365\3\2"+
		"\2\2\u0367\u0368\3\2\2\2\u0368\u036a\3\2\2\2\u0369\u0367\3\2\2\2\u036a"+
		"\u036d\7\6\2\2\u036b\u036d\7\r\2\2\u036c\u035b\3\2\2\2\u036c\u036b\3\2"+
		"\2\2\u036d\u036e\3\2\2\2\u036e\u036f\b!\1\2\u036fA\3\2\2\2\u0370\u0371"+
		"\7@\2\2\u0371\u0374\5\u0088E\2\u0372\u0374\5\u0088E\2\u0373\u0370\3\2"+
		"\2\2\u0373\u0372\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0376\b\"\1\2\u0376"+
		"\u0379\b\"\1\2\u0377\u0378\7\31\2\2\u0378\u037a\7\u0089\2\2\u0379\u0377"+
		"\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u0386\b\"\1\2\u037c"+
		"\u0380\7\4\2\2\u037d\u037f\5D#\2\u037e\u037d\3\2\2\2\u037f\u0382\3\2\2"+
		"\2\u0380\u037e\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0383\3\2\2\2\u0382\u0380"+
		"\3\2\2\2\u0383\u0384\b\"\1\2\u0384\u0387\7\6\2\2\u0385\u0387\7\r\2\2\u0386"+
		"\u037c\3\2\2\2\u0386\u0385\3\2\2\2\u0387C\3\2\2\2\u0388\u038a\7A\2\2\u0389"+
		"\u038b\7\u008d\2\2\u038a\u0389\3\2\2\2\u038a\u038b\3\2\2\2\u038b\u038c"+
		"\3\2\2\2\u038c\u038d\b#\1\2\u038d\u0399\b#\1\2\u038e\u038f\7\63\2\2\u038f"+
		"\u0394\5F$\2\u0390\u0391\7\5\2\2\u0391\u0393\5F$\2\u0392\u0390\3\2\2\2"+
		"\u0393\u0396\3\2\2\2\u0394\u0392\3\2\2\2\u0394\u0395\3\2\2\2\u0395\u0397"+
		"\3\2\2\2\u0396\u0394\3\2\2\2\u0397\u0398\7\64\2\2\u0398\u039a\3\2\2\2"+
		"\u0399\u038e\3\2\2\2\u0399\u039a\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u03ad"+
		"\b#\1\2\u039c\u03a6\7\4\2\2\u039d\u039e\5D#\2\u039e\u039f\b#\1\2\u039f"+
		"\u03a7\3\2\2\2\u03a0\u03a1\5H%\2\u03a1\u03a2\b#\1\2\u03a2\u03a7\3\2\2"+
		"\2\u03a3\u03a4\5N(\2\u03a4\u03a5\b#\1\2\u03a5\u03a7\3\2\2\2\u03a6\u039d"+
		"\3\2\2\2\u03a6\u03a0\3\2\2\2\u03a6\u03a3\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8"+
		"\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ab\7\6"+
		"\2\2\u03ab\u03ae\3\2\2\2\u03ac\u03ae\7\r\2\2\u03ad\u039c\3\2\2\2\u03ad"+
		"\u03ac\3\2\2\2\u03aeE\3\2\2\2\u03af\u03b1\7\u008d\2\2\u03b0\u03af\3\2"+
		"\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2\u03b4\7\31\2\2\u03b3"+
		"\u03b5\t\5\2\2\u03b4\u03b3\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5\u03b6\3\2"+
		"\2\2\u03b6\u03b7\b$\1\2\u03b7G\3\2\2\2\u03b8\u03b9\5D#\2\u03b9\u03ba\b"+
		"%\1\2\u03ba\u03bf\3\2\2\2\u03bb\u03bc\5J&\2\u03bc\u03bd\b%\1\2\u03bd\u03bf"+
		"\3\2\2\2\u03be\u03b8\3\2\2\2\u03be\u03bb\3\2\2\2\u03bfI\3\2\2\2\u03c0"+
		"\u03c1\5L\'\2\u03c1\u03c2\b&\1\2\u03c2\u03cd\3\2\2\2\u03c3\u03c4\5*\26"+
		"\2\u03c4\u03c5\b&\1\2\u03c5\u03cd\3\2\2\2\u03c6\u03c7\5(\25\2\u03c7\u03c8"+
		"\b&\1\2\u03c8\u03cd\3\2\2\2\u03c9\u03ca\5B\"\2\u03ca\u03cb\b&\1\2\u03cb"+
		"\u03cd\3\2\2\2\u03cc\u03c0\3\2\2\2\u03cc\u03c3\3\2\2\2\u03cc\u03c6\3\2"+
		"\2\2\u03cc\u03c9\3\2\2\2\u03cdK\3\2\2\2\u03ce\u03cf\5\64\33\2\u03cf\u03d0"+
		"\b\'\1\2\u03d0\u03d8\3\2\2\2\u03d1\u03d2\5:\36\2\u03d2\u03d3\b\'\1\2\u03d3"+
		"\u03d8\3\2\2\2\u03d4\u03d5\5.\30\2\u03d5\u03d6\b\'\1\2\u03d6\u03d8\3\2"+
		"\2\2\u03d7\u03ce\3\2\2\2\u03d7\u03d1\3\2\2\2\u03d7\u03d4\3\2\2\2\u03d8"+
		"M\3\2\2\2\u03d9\u03da\7B\2\2\u03da\u03db\5\\/\2\u03db\u03dc\7\r\2\2\u03dc"+
		"O\3\2\2\2\u03dd\u03de\7C\2\2\u03de\u03e3\5R*\2\u03df\u03e0\7\5\2\2\u03e0"+
		"\u03e2\5R*\2\u03e1\u03df\3\2\2\2\u03e2\u03e5\3\2\2\2\u03e3\u03e1\3\2\2"+
		"\2\u03e3\u03e4\3\2\2\2\u03e4\u03e6\3\2\2\2\u03e5\u03e3\3\2\2\2\u03e6\u03e7"+
		"\7D\2\2\u03e7Q\3\2\2\2\u03e8\u03e9\5\u0088E\2\u03e9\u03ea\b*\1\2\u03ea"+
		"\u03f4\b*\1\2\u03eb\u03ec\7\35\2\2\u03ec\u03f1\5V,\2\u03ed\u03ee\7E\2"+
		"\2\u03ee\u03f0\5V,\2\u03ef\u03ed\3\2\2\2\u03f0\u03f3\3\2\2\2\u03f1\u03ef"+
		"\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f5\3\2\2\2\u03f3\u03f1\3\2\2\2\u03f4"+
		"\u03eb\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6\u03f7\b*"+
		"\1\2\u03f7S\3\2\2\2\u03f8\u03f9\5V,\2\u03f9\u03fa\b+\1\2\u03fa\u03ff\3"+
		"\2\2\2\u03fb\u03fc\5Z.\2\u03fc\u03fd\b+\1\2\u03fd\u03ff\3\2\2\2\u03fe"+
		"\u03f8\3\2\2\2\u03fe\u03fb\3\2\2\2\u03ffU\3\2\2\2\u0400\u040c\5\\/\2\u0401"+
		"\u0402\7C\2\2\u0402\u0407\5T+\2\u0403\u0404\7\5\2\2\u0404\u0406\5T+\2"+
		"\u0405\u0403\3\2\2\2\u0406\u0409\3\2\2\2\u0407\u0405\3\2\2\2\u0407\u0408"+
		"\3\2\2\2\u0408\u040a\3\2\2\2\u0409\u0407\3\2\2\2\u040a\u040b\7D\2\2\u040b"+
		"\u040d\3\2\2\2\u040c\u0401\3\2\2\2\u040c\u040d\3\2\2\2\u040dW\3\2\2\2"+
		"\u040e\u040f\5`\61\2\u040f\u0410\b-\1\2\u0410\u0415\3\2\2\2\u0411\u0412"+
		"\5V,\2\u0412\u0413\b-\1\2\u0413\u0415\3\2\2\2\u0414\u040e\3\2\2\2\u0414"+
		"\u0411\3\2\2\2\u0415Y\3\2\2\2\u0416\u0417\78\2\2\u0417\u041d\b.\1\2\u0418"+
		"\u0419\t\6\2\2\u0419\u041a\b.\1\2\u041a\u041b\5V,\2\u041b\u041c\b.\1\2"+
		"\u041c\u041e\3\2\2\2\u041d\u0418\3\2\2\2\u041d\u041e\3\2\2\2\u041e[\3"+
		"\2\2\2\u041f\u0422\5\u0088E\2\u0420\u0421\7\25\2\2\u0421\u0423\7\u0089"+
		"\2\2\u0422\u0420\3\2\2\2\u0422\u0423\3\2\2\2\u0423\u042b\3\2\2\2\u0424"+
		"\u0426\5^\60\2\u0425\u0424\3\2\2\2\u0426\u0429\3\2\2\2\u0427\u0425\3\2"+
		"\2\2\u0427\u0428\3\2\2\2\u0428\u042a\3\2\2\2\u0429\u0427\3\2\2\2\u042a"+
		"\u042c\5^\60\2\u042b\u0427\3\2\2\2\u042b\u042c\3\2\2\2\u042c]\3\2\2\2"+
		"\u042d\u042f\7G\2\2\u042e\u0430\7H\2\2\u042f\u042e\3\2\2\2\u042f\u0430"+
		"\3\2\2\2\u0430\u0431\3\2\2\2\u0431\u0434\5\u0088E\2\u0432\u0433\7\25\2"+
		"\2\u0433\u0435\7\u0089\2\2\u0434\u0432\3\2\2\2\u0434\u0435\3\2\2\2\u0435"+
		"_\3\2\2\2\u0436\u0437\7I\2\2\u0437\u0441\b\61\1\2\u0438\u0439\7J\2\2\u0439"+
		"\u0441\b\61\1\2\u043a\u043b\7K\2\2\u043b\u0441\b\61\1\2\u043c\u043d\7"+
		"L\2\2\u043d\u0441\b\61\1\2\u043e\u043f\7M\2\2\u043f\u0441\b\61\1\2\u0440"+
		"\u0436\3\2\2\2\u0440\u0438\3\2\2\2\u0440\u043a\3\2\2\2\u0440\u043c\3\2"+
		"\2\2\u0440\u043e\3\2\2\2\u0441a\3\2\2\2\u0442\u0444\7N\2\2\u0443\u0445"+
		"\5\u008aF\2\u0444\u0443\3\2\2\2\u0444\u0445\3\2\2\2\u0445\u0446\3\2\2"+
		"\2\u0446\u044d\b\62\1\2\u0447\u0449\7\b\2\2\u0448\u044a\5r:\2\u0449\u0448"+
		"\3\2\2\2\u0449\u044a\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u044e\7\r\2\2\u044c"+
		"\u044e\7\r\2\2\u044d\u0447\3\2\2\2\u044d\u044c\3\2\2\2\u044e\u044f\3\2"+
		"\2\2\u044f\u0450\b\62\1\2\u0450c\3\2\2\2\u0451\u0453\7O\2\2\u0452\u0451"+
		"\3\2\2\2\u0452\u0453\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0455\b\63\1\2"+
		"\u0455\u045c\7P\2\2\u0456\u045a\5\u008aF\2\u0457\u0458\7\63\2\2\u0458"+
		"\u0459\7\u008c\2\2\u0459\u045b\7\64\2\2\u045a\u0457\3\2\2\2\u045a\u045b"+
		"\3\2\2\2\u045b\u045d\3\2\2\2\u045c\u0456\3\2\2\2\u045c\u045d\3\2\2\2\u045d"+
		"\u045e\3\2\2\2\u045e\u0465\b\63\1\2\u045f\u0461\7\b\2\2\u0460\u0462\5"+
		"p9\2\u0461\u0460\3\2\2\2\u0461\u0462\3\2\2\2\u0462\u0463\3\2\2\2\u0463"+
		"\u0466\7\r\2\2\u0464\u0466\7\r\2\2\u0465\u045f\3\2\2\2\u0465\u0464\3\2"+
		"\2\2\u0466\u0467\3\2\2\2\u0467\u0468\b\63\1\2\u0468e\3\2\2\2\u0469\u0470"+
		"\t\7\2\2\u046a\u046e\5\u008aF\2\u046b\u046c\7\63\2\2\u046c\u046d\7\u008c"+
		"\2\2\u046d\u046f\7\64\2\2\u046e\u046b\3\2\2\2\u046e\u046f\3\2\2\2\u046f"+
		"\u0471\3\2\2\2\u0470\u046a\3\2\2\2\u0470\u0471\3\2\2\2\u0471\u0472\3\2"+
		"\2\2\u0472\u0479\b\64\1\2\u0473\u0475\7\b\2\2\u0474\u0476\5p9\2\u0475"+
		"\u0474\3\2\2\2\u0475\u0476\3\2\2\2\u0476\u0477\3\2\2\2\u0477\u047a\7\r"+
		"\2\2\u0478\u047a\7\r\2\2\u0479\u0473\3\2\2\2\u0479\u0478\3\2\2\2\u047a"+
		"\u047b\3\2\2\2\u047b\u047c\b\64\1\2\u047cg\3\2\2\2\u047d\u0484\t\b\2\2"+
		"\u047e\u0482\5\u008aF\2\u047f\u0480\7\63\2\2\u0480\u0481\7\u008c\2\2\u0481"+
		"\u0483\7\64\2\2\u0482\u047f\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u0485\3"+
		"\2\2\2\u0484\u047e\3\2\2\2\u0484\u0485\3\2\2\2\u0485\u0486\3\2\2\2\u0486"+
		"\u048d\b\65\1\2\u0487\u0489\7\b\2\2\u0488\u048a\5p9\2\u0489\u0488\3\2"+
		"\2\2\u0489\u048a\3\2\2\2\u048a\u048b\3\2\2\2\u048b\u048e\7\r\2\2\u048c"+
		"\u048e\7\r\2\2\u048d\u0487\3\2\2\2\u048d\u048c\3\2\2\2\u048e\u048f\3\2"+
		"\2\2\u048f\u0490\b\65\1\2\u0490i\3\2\2\2\u0491\u0493\7U\2\2\u0492\u0494"+
		"\5\u008aF\2\u0493\u0492\3\2\2\2\u0493\u0494\3\2\2\2\u0494\u0495\3\2\2"+
		"\2\u0495\u049c\b\66\1\2\u0496\u0498\7\b\2\2\u0497\u0499\5r:\2\u0498\u0497"+
		"\3\2\2\2\u0498\u0499\3\2\2\2\u0499\u049a\3\2\2\2\u049a\u049d\7\r\2\2\u049b"+
		"\u049d\7\r\2\2\u049c\u0496\3\2\2\2\u049c\u049b\3\2\2\2\u049d\u049e\3\2"+
		"\2\2\u049e\u049f\b\66\1\2\u049fk\3\2\2\2\u04a0\u04a2\7V\2\2\u04a1\u04a3"+
		"\5\u008aF\2\u04a2\u04a1\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a4\3\2\2"+
		"\2\u04a4\u04ab\b\67\1\2\u04a5\u04a7\7\b\2\2\u04a6\u04a8\5r:\2\u04a7\u04a6"+
		"\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u04a9\3\2\2\2\u04a9\u04ac\7\r\2\2\u04aa"+
		"\u04ac\7\r\2\2\u04ab\u04a5\3\2\2\2\u04ab\u04aa\3\2\2\2\u04ac\u04ad\3\2"+
		"\2\2\u04ad\u04ae\b\67\1\2\u04aem\3\2\2\2\u04af\u04b3\7W\2\2\u04b0\u04b3"+
		"\7X\2\2\u04b1\u04b3\7Y\2\2\u04b2\u04af\3\2\2\2\u04b2\u04b0\3\2\2\2\u04b2"+
		"\u04b1\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b5\b8\1\2\u04b5o\3\2\2\2\u04b6"+
		"\u04b7\b9\1\2\u04b7\u04b8\7Z\2\2\u04b8\u04b9\5r:\2\u04b9\u04ba\b9\1\2"+
		"\u04ba\u05d2\3\2\2\2\u04bb\u04bc\7[\2\2\u04bc\u04bd\5r:\2\u04bd\u04be"+
		"\b9\1\2\u04be\u05d2\3\2\2\2\u04bf\u04c0\7\\\2\2\u04c0\u04c1\5r:\2\u04c1"+
		"\u04c2\b9\1\2\u04c2\u05d2\3\2\2\2\u04c3\u04c4\7]\2\2\u04c4\u04c5\5r:\2"+
		"\u04c5\u04c6\b9\1\2\u04c6\u05d2\3\2\2\2\u04c7\u04c9\5r:\2\u04c8\u04ca"+
		"\t\t\2\2\u04c9\u04c8\3\2\2\2\u04c9\u04ca\3\2\2\2\u04ca\u04cb\3\2\2\2\u04cb"+
		"\u04cc\7`\2\2\u04cc\u04cd\5r:\2\u04cd\u04ce\b9\1\2\u04ce\u05d2\3\2\2\2"+
		"\u04cf\u04d1\5r:\2\u04d0\u04d2\t\t\2\2\u04d1\u04d0\3\2\2\2\u04d1\u04d2"+
		"\3\2\2\2\u04d2\u04d3\3\2\2\2\u04d3\u04d4\7\31\2\2\u04d4\u04d5\5r:\2\u04d5"+
		"\u04d6\b9\1\2\u04d6\u05d2\3\2\2\2\u04d7\u04d9\5t;\2\u04d8\u04da\t\t\2"+
		"\2\u04d9\u04d8\3\2\2\2\u04d9\u04da\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u04dc"+
		"\7\31\2\2\u04dc\u04dd\5t;\2\u04dd\u04de\b9\1\2\u04de\u05d2\3\2\2\2\u04df"+
		"\u04e1\5t;\2\u04e0\u04e2\t\t\2\2\u04e1\u04e0\3\2\2\2\u04e1\u04e2\3\2\2"+
		"\2\u04e2\u04e3\3\2\2\2\u04e3\u04e4\7C\2\2\u04e4\u04e5\5t;\2\u04e5\u04e6"+
		"\b9\1\2\u04e6\u05d2\3\2\2\2\u04e7\u04e9\5t;\2\u04e8\u04ea\t\t\2\2\u04e9"+
		"\u04e8\3\2\2\2\u04e9\u04ea\3\2\2\2\u04ea\u04eb\3\2\2\2\u04eb\u04ec\7a"+
		"\2\2\u04ec\u04ed\5t;\2\u04ed\u04ee\b9\1\2\u04ee\u05d2\3\2\2\2\u04ef\u04f1"+
		"\5t;\2\u04f0\u04f2\t\t\2\2\u04f1\u04f0\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2"+
		"\u04f3\3\2\2\2\u04f3\u04f4\7D\2\2\u04f4\u04f5\5t;\2\u04f5\u04f6\b9\1\2"+
		"\u04f6\u05d2\3\2\2\2\u04f7\u04f9\5t;\2\u04f8\u04fa\t\t\2\2\u04f9\u04f8"+
		"\3\2\2\2\u04f9\u04fa\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb\u04fc\7b\2\2\u04fc"+
		"\u04fd\5t;\2\u04fd\u04fe\b9\1\2\u04fe\u05d2\3\2\2\2\u04ff\u0500\7c\2\2"+
		"\u0500\u0501\5v<\2\u0501\u0502\7d\2\2\u0502\u0503\5t;\2\u0503\u0504\3"+
		"\2\2\2\u0504\u0505\b9\1\2\u0505\u05d2\3\2\2\2\u0506\u0507\7e\2\2\u0507"+
		"\u0508\7\17\2\2\u0508\u0509\5\u0082B\2\u0509\u050a\7\20\2\2\u050a\u050b"+
		"\b9\1\2\u050b\u05d2\3\2\2\2\u050c\u050d\7f\2\2\u050d\u050e\7\17\2\2\u050e"+
		"\u050f\5\u0082B\2\u050f\u0510\7\b\2\2\u0510\u0511\5r:\2\u0511\u0516\7"+
		"g\2\2\u0512\u0514\7\\\2\2\u0513\u0512\3\2\2\2\u0513\u0514\3\2\2\2\u0514"+
		"\u0517\3\2\2\2\u0515\u0517\7[\2\2\u0516\u0513\3\2\2\2\u0516\u0515\3\2"+
		"\2\2\u0517\u0518\3\2\2\2\u0518\u0519\5r:\2\u0519\u051a\7\20\2\2\u051a"+
		"\u051b\b9\1\2\u051b\u05d2\3\2\2\2\u051c\u051d\7h\2\2\u051d\u051e\7\17"+
		"\2\2\u051e\u051f\5\u0082B\2\u051f\u0520\7\5\2\2\u0520\u0521\5\u0082B\2"+
		"\u0521\u0522\7\5\2\2\u0522\u0523\5\u0082B\2\u0523\u0524\7\5\2\2\u0524"+
		"\u0525\5\u0082B\2\u0525\u0526\7\20\2\2\u0526\u0527\b9\1\2\u0527\u05d2"+
		"\3\2\2\2\u0528\u0529\t\t\2\2\u0529\u052a\5p9\20\u052a\u052b\b9\1\2\u052b"+
		"\u05d2\3\2\2\2\u052c\u052d\7r\2\2\u052d\u0542\5v<\2\u052e\u0538\7d\2\2"+
		"\u052f\u0539\5p9\2\u0530\u0534\7\4\2\2\u0531\u0533\5p9\2\u0532\u0531\3"+
		"\2\2\2\u0533\u0536\3\2\2\2\u0534\u0532\3\2\2\2\u0534\u0535\3\2\2\2\u0535"+
		"\u0537\3\2\2\2\u0536\u0534\3\2\2\2\u0537\u0539\7\6\2\2\u0538\u052f\3\2"+
		"\2\2\u0538\u0530\3\2\2\2\u0539\u0543\3\2\2\2\u053a\u053e\7\4\2\2\u053b"+
		"\u053d\5p9\2\u053c\u053b\3\2\2\2\u053d\u0540\3\2\2\2\u053e\u053c\3\2\2"+
		"\2\u053e\u053f\3\2\2\2\u053f\u0541\3\2\2\2\u0540\u053e\3\2\2\2\u0541\u0543"+
		"\7\6\2\2\u0542\u052e\3\2\2\2\u0542\u053a\3\2\2\2\u0543\u0544\3\2\2\2\u0544"+
		"\u0545\b9\1\2\u0545\u05d2\3\2\2\2\u0546\u0547\7]\2\2\u0547\u055c\5v<\2"+
		"\u0548\u0552\7d\2\2\u0549\u0553\5p9\2\u054a\u054e\7\4\2\2\u054b\u054d"+
		"\5p9\2\u054c\u054b\3\2\2\2\u054d\u0550\3\2\2\2\u054e\u054c\3\2\2\2\u054e"+
		"\u054f\3\2\2\2\u054f\u0551\3\2\2\2\u0550\u054e\3\2\2\2\u0551\u0553\7\6"+
		"\2\2\u0552\u0549\3\2\2\2\u0552\u054a\3\2\2\2\u0553\u055d\3\2\2\2\u0554"+
		"\u0558\7\4\2\2\u0555\u0557\5p9\2\u0556\u0555\3\2\2\2\u0557\u055a\3\2\2"+
		"\2\u0558\u0556\3\2\2\2\u0558\u0559\3\2\2\2\u0559\u055b\3\2\2\2\u055a\u0558"+
		"\3\2\2\2\u055b\u055d\7\6\2\2\u055c\u0548\3\2\2\2\u055c\u0554\3\2\2\2\u055d"+
		"\u055e\3\2\2\2\u055e\u055f\b9\1\2\u055f\u05d2\3\2\2\2\u0560\u0561\7Z\2"+
		"\2\u0561\u0576\5v<\2\u0562\u056c\7d\2\2\u0563\u056d\5p9\2\u0564\u0568"+
		"\7\4\2\2\u0565\u0567\5p9\2\u0566\u0565\3\2\2\2\u0567\u056a\3\2\2\2\u0568"+
		"\u0566\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u056b\3\2\2\2\u056a\u0568\3\2"+
		"\2\2\u056b\u056d\7\6\2\2\u056c\u0563\3\2\2\2\u056c\u0564\3\2\2\2\u056d"+
		"\u0577\3\2\2\2\u056e\u0572\7\4\2\2\u056f\u0571\5p9\2\u0570\u056f\3\2\2"+
		"\2\u0571\u0574\3\2\2\2\u0572\u0570\3\2\2\2\u0572\u0573\3\2\2\2\u0573\u0575"+
		"\3\2\2\2\u0574\u0572\3\2\2\2\u0575\u0577\7\6\2\2\u0576\u0562\3\2\2\2\u0576"+
		"\u056e\3\2\2\2\u0577\u0578\3\2\2\2\u0578\u0579\b9\1\2\u0579\u05d2\3\2"+
		"\2\2\u057a\u057b\7\\\2\2\u057b\u0590\5v<\2\u057c\u0586\7d\2\2\u057d\u0587"+
		"\5p9\2\u057e\u0582\7\4\2\2\u057f\u0581\5p9\2\u0580\u057f\3\2\2\2\u0581"+
		"\u0584\3\2\2\2\u0582\u0580\3\2\2\2\u0582\u0583\3\2\2\2\u0583\u0585\3\2"+
		"\2\2\u0584\u0582\3\2\2\2\u0585\u0587\7\6\2\2\u0586\u057d\3\2\2\2\u0586"+
		"\u057e\3\2\2\2\u0587\u0591\3\2\2\2\u0588\u058c\7\4\2\2\u0589\u058b\5p"+
		"9\2\u058a\u0589\3\2\2\2\u058b\u058e\3\2\2\2\u058c\u058a\3\2\2\2\u058c"+
		"\u058d\3\2\2\2\u058d\u058f\3\2\2\2\u058e\u058c\3\2\2\2\u058f\u0591\7\6"+
		"\2\2\u0590\u057c\3\2\2\2\u0590\u0588\3\2\2\2\u0591\u0592\3\2\2\2\u0592"+
		"\u0593\b9\1\2\u0593\u05d2\3\2\2\2\u0594\u0595\7[\2\2\u0595\u05aa\5v<\2"+
		"\u0596\u05a0\7d\2\2\u0597\u05a1\5p9\2\u0598\u059c\7\4\2\2\u0599\u059b"+
		"\5p9\2\u059a\u0599\3\2\2\2\u059b\u059e\3\2\2\2\u059c\u059a\3\2\2\2\u059c"+
		"\u059d\3\2\2\2\u059d\u059f\3\2\2\2\u059e\u059c\3\2\2\2\u059f\u05a1\7\6"+
		"\2\2\u05a0\u0597\3\2\2\2\u05a0\u0598\3\2\2\2\u05a1\u05ab\3\2\2\2\u05a2"+
		"\u05a6\7\4\2\2\u05a3\u05a5\5p9\2\u05a4\u05a3\3\2\2\2\u05a5\u05a8\3\2\2"+
		"\2\u05a6\u05a4\3\2\2\2\u05a6\u05a7\3\2\2\2\u05a7\u05a9\3\2\2\2\u05a8\u05a6"+
		"\3\2\2\2\u05a9\u05ab\7\6\2\2\u05aa\u0596\3\2\2\2\u05aa\u05a2\3\2\2\2\u05ab"+
		"\u05ac\3\2\2\2\u05ac\u05ad\b9\1\2\u05ad\u05d2\3\2\2\2\u05ae\u05af\7s\2"+
		"\2\u05af\u05c4\5z>\2\u05b0\u05ba\7d\2\2\u05b1\u05bb\5p9\2\u05b2\u05b6"+
		"\7\4\2\2\u05b3\u05b5\5p9\2\u05b4\u05b3\3\2\2\2\u05b5\u05b8\3\2\2\2\u05b6"+
		"\u05b4\3\2\2\2\u05b6\u05b7\3\2\2\2\u05b7\u05b9\3\2\2\2\u05b8\u05b6\3\2"+
		"\2\2\u05b9\u05bb\7\6\2\2\u05ba\u05b1\3\2\2\2\u05ba\u05b2\3\2\2\2\u05bb"+
		"\u05c5\3\2\2\2\u05bc\u05c0\7\4\2\2\u05bd\u05bf\5p9\2\u05be\u05bd\3\2\2"+
		"\2\u05bf\u05c2\3\2\2\2\u05c0\u05be\3\2\2\2\u05c0\u05c1\3\2\2\2\u05c1\u05c3"+
		"\3\2\2\2\u05c2\u05c0\3\2\2\2\u05c3\u05c5\7\6\2\2\u05c4\u05b0\3\2\2\2\u05c4"+
		"\u05bc\3\2\2\2\u05c5\u05c6\3\2\2\2\u05c6\u05c7\b9\1\2\u05c7\u05d2\3\2"+
		"\2\2\u05c8\u05c9\7\21\2\2\u05c9\u05d2\b9\1\2\u05ca\u05cb\7\22\2\2\u05cb"+
		"\u05d2\b9\1\2\u05cc\u05cd\7\63\2\2\u05cd\u05ce\5p9\2\u05ce\u05cf\7\64"+
		"\2\2\u05cf\u05d0\b9\1\2\u05d0\u05d2\3\2\2\2\u05d1\u04b6\3\2\2\2\u05d1"+
		"\u04bb\3\2\2\2\u05d1\u04bf\3\2\2\2\u05d1\u04c3\3\2\2\2\u05d1\u04c7\3\2"+
		"\2\2\u05d1\u04cf\3\2\2\2\u05d1\u04d7\3\2\2\2\u05d1\u04df\3\2\2\2\u05d1"+
		"\u04e7\3\2\2\2\u05d1\u04ef\3\2\2\2\u05d1\u04f7\3\2\2\2\u05d1\u04ff\3\2"+
		"\2\2\u05d1\u0506\3\2\2\2\u05d1\u050c\3\2\2\2\u05d1\u051c\3\2\2\2\u05d1"+
		"\u0528\3\2\2\2\u05d1\u052c\3\2\2\2\u05d1\u0546\3\2\2\2\u05d1\u0560\3\2"+
		"\2\2\u05d1\u057a\3\2\2\2\u05d1\u0594\3\2\2\2\u05d1\u05ae\3\2\2\2\u05d1"+
		"\u05c8\3\2\2\2\u05d1\u05ca\3\2\2\2\u05d1\u05cc\3\2\2\2\u05d2\u05e9\3\2"+
		"\2\2\u05d3\u05d4\f\17\2\2\u05d4\u05d5\t\n\2\2\u05d5\u05d6\5p9\20\u05d6"+
		"\u05d7\b9\1\2\u05d7\u05e8\3\2\2\2\u05d8\u05d9\f\16\2\2\u05d9\u05da\t\13"+
		"\2\2\u05da\u05db\5p9\17\u05db\u05dc\b9\1\2\u05dc\u05e8\3\2\2\2\u05dd\u05de"+
		"\f\r\2\2\u05de\u05df\t\f\2\2\u05df\u05e0\5p9\r\u05e0\u05e1\b9\1\2\u05e1"+
		"\u05e8\3\2\2\2\u05e2\u05e3\f\f\2\2\u05e3\u05e4\t\r\2\2\u05e4\u05e5\5p"+
		"9\f\u05e5\u05e6\b9\1\2\u05e6\u05e8\3\2\2\2\u05e7\u05d3\3\2\2\2\u05e7\u05d8"+
		"\3\2\2\2\u05e7\u05dd\3\2\2\2\u05e7\u05e2\3\2\2\2\u05e8\u05eb\3\2\2\2\u05e9"+
		"\u05e7\3\2\2\2\u05e9\u05ea\3\2\2\2\u05eaq\3\2\2\2\u05eb\u05e9\3\2\2\2"+
		"\u05ec\u05ed\b:\1\2\u05ed\u05ee\7t\2\2\u05ee\u05ef\5r:\24\u05ef\u05f0"+
		"\b:\1\2\u05f0\u0619\3\2\2\2\u05f1\u05f2\7u\2\2\u05f2\u05f3\5r:\23\u05f3"+
		"\u05f4\b:\1\2\u05f4\u0619\3\2\2\2\u05f5\u05f6\7\67\2\2\u05f6\u05f7\5r"+
		":\22\u05f7\u05f8\b:\1\2\u05f8\u0619\3\2\2\2\u05f9\u05fa\7\4\2\2\u05fa"+
		"\u05fb\5~@\2\u05fb\u05fc\7d\2\2\u05fc\u05fd\5p9\2\u05fd\u05fe\7\6\2\2"+
		"\u05fe\u05ff\b:\1\2\u05ff\u0619\3\2\2\2\u0600\u0601\t\16\2\2\u0601\u0602"+
		"\5p9\2\u0602\u0603\7w\2\2\u0603\u0604\5r:\2\u0604\u0605\7x\2\2\u0605\u0606"+
		"\5r:\t\u0606\u0607\b:\1\2\u0607\u0619\3\2\2\2\u0608\u0609\7y\2\2\u0609"+
		"\u0619\b:\1\2\u060a\u060b\7z\2\2\u060b\u0619\b:\1\2\u060c\u060d\7{\2\2"+
		"\u060d\u0619\b:\1\2\u060e\u060f\7|\2\2\u060f\u0619\b:\1\2\u0610\u0611"+
		"\7\63\2\2\u0611\u0612\5r:\2\u0612\u0613\7\64\2\2\u0613\u0614\b:\1\2\u0614"+
		"\u0619\3\2\2\2\u0615\u0616\5\\/\2\u0616\u0617\b:\1\2\u0617\u0619\3\2\2"+
		"\2\u0618\u05ec\3\2\2\2\u0618\u05f1\3\2\2\2\u0618\u05f5\3\2\2\2\u0618\u05f9"+
		"\3\2\2\2\u0618\u0600\3\2\2\2\u0618\u0608\3\2\2\2\u0618\u060a\3\2\2\2\u0618"+
		"\u060c\3\2\2\2\u0618\u060e\3\2\2\2\u0618\u0610\3\2\2\2\u0618\u0615\3\2"+
		"\2\2\u0619\u0646\3\2\2\2\u061a\u061b\f\21\2\2\u061b\u061c\7\23\2\2\u061c"+
		"\u061d\5r:\22\u061d\u061e\b:\1\2\u061e\u0645\3\2\2\2\u061f\u0620\f\20"+
		"\2\2\u0620\u0621\7E\2\2\u0621\u0622\5r:\21\u0622\u0623\b:\1\2\u0623\u0645"+
		"\3\2\2\2\u0624\u0625\f\17\2\2\u0625\u0626\7\24\2\2\u0626\u0627\5r:\20"+
		"\u0627\u0628\b:\1\2\u0628\u0645\3\2\2\2\u0629\u062a\f\16\2\2\u062a\u062b"+
		"\7\25\2\2\u062b\u062c\5r:\17\u062c\u062d\b:\1\2\u062d\u0645\3\2\2\2\u062e"+
		"\u0630\f\f\2\2\u062f\u0631\5\u0086D\2\u0630\u062f\3\2\2\2\u0630\u0631"+
		"\3\2\2\2\u0631\u0632\3\2\2\2\u0632\u0634\7g\2\2\u0633\u0635\5\u0086D\2"+
		"\u0634\u0633\3\2\2\2\u0634\u0635\3\2\2\2\u0635\u0636\3\2\2\2\u0636\u0637"+
		"\5r:\f\u0637\u0638\b:\1\2\u0638\u0645\3\2\2\2\u0639\u063a\f\13\2\2\u063a"+
		"\u063b\7v\2\2\u063b\u063c\5r:\f\u063c\u063d\b:\1\2\u063d\u0645\3\2\2\2"+
		"\u063e\u063f\f\r\2\2\u063f\u0640\7\17\2\2\u0640\u0641\5r:\2\u0641\u0642"+
		"\7\20\2\2\u0642\u0643\b:\1\2\u0643\u0645\3\2\2\2\u0644\u061a\3\2\2\2\u0644"+
		"\u061f\3\2\2\2\u0644\u0624\3\2\2\2\u0644\u0629\3\2\2\2\u0644\u062e\3\2"+
		"\2\2\u0644\u0639\3\2\2\2\u0644\u063e\3\2\2\2\u0645\u0648\3\2\2\2\u0646"+
		"\u0644\3\2\2\2\u0646\u0647\3\2\2\2\u0647s\3\2\2\2\u0648\u0646\3\2\2\2"+
		"\u0649\u064a\b;\1\2\u064a\u064b\t\16\2\2\u064b\u064c\5p9\2\u064c\u064d"+
		"\7w\2\2\u064d\u064e\5t;\2\u064e\u064f\7x\2\2\u064f\u0650\5t;\f\u0650\u0651"+
		"\b;\1\2\u0651\u0665\3\2\2\2\u0652\u0653\7c\2\2\u0653\u0654\5r:\2\u0654"+
		"\u0655\b;\1\2\u0655\u0665\3\2\2\2\u0656\u0657\7-\2\2\u0657\u0658\5r:\2"+
		"\u0658\u0659\b;\1\2\u0659\u0665\3\2\2\2\u065a\u065c\7\24\2\2\u065b\u065a"+
		"\3\2\2\2\u065b\u065c\3\2\2\2\u065c\u065d\3\2\2\2\u065d\u065e\7\u0089\2"+
		"\2\u065e\u0665\b;\1\2\u065f\u0660\7\63\2\2\u0660\u0661\5t;\2\u0661\u0662"+
		"\7\64\2\2\u0662\u0663\b;\1\2\u0663\u0665\3\2\2\2\u0664\u0649\3\2\2\2\u0664"+
		"\u0652\3\2\2\2\u0664\u0656\3\2\2\2\u0664\u065b\3\2\2\2\u0664\u065f\3\2"+
		"\2\2\u0665\u0681\3\2\2\2\u0666\u0667\f\t\2\2\u0667\u0668\t\17\2\2\u0668"+
		"\u0669\5t;\n\u0669\u066a\b;\1\2\u066a\u0680\3\2\2\2\u066b\u066c\f\b\2"+
		"\2\u066c\u066d\t\20\2\2\u066d\u066e\5t;\t\u066e\u066f\b;\1\2\u066f\u0680"+
		"\3\2\2\2\u0670\u0671\f\7\2\2\u0671\u0672\t\21\2\2\u0672\u0673\5t;\b\u0673"+
		"\u0674\b;\1\2\u0674\u0680\3\2\2\2\u0675\u0676\f\6\2\2\u0676\u0677\t\22"+
		"\2\2\u0677\u0678\5t;\7\u0678\u0679\b;\1\2\u0679\u0680\3\2\2\2\u067a\u067b"+
		"\f\5\2\2\u067b\u067c\t\23\2\2\u067c\u067d\5t;\6\u067d\u067e\b;\1\2\u067e"+
		"\u0680\3\2\2\2\u067f\u0666\3\2\2\2\u067f\u066b\3\2\2\2\u067f\u0670\3\2"+
		"\2\2\u067f\u0675\3\2\2\2\u067f\u067a\3\2\2\2\u0680\u0683\3\2\2\2\u0681"+
		"\u067f\3\2\2\2\u0681\u0682\3\2\2\2\u0682u\3\2\2\2\u0683\u0681\3\2\2\2"+
		"\u0684\u0689\5x=\2\u0685\u0686\7\5\2\2\u0686\u0688\5x=\2\u0687\u0685\3"+
		"\2\2\2\u0688\u068b\3\2\2\2\u0689\u0687\3\2\2\2\u0689\u068a\3\2\2\2\u068a"+
		"w\3\2\2\2\u068b\u0689\3\2\2\2\u068c\u068e\7\u0084\2\2\u068d\u068c\3\2"+
		"\2\2\u068d\u068e\3\2\2\2\u068e\u068f\3\2\2\2\u068f\u0694\5\u0084C\2\u0690"+
		"\u0691\7\5\2\2\u0691\u0693\5\u0084C\2\u0692\u0690\3\2\2\2\u0693\u0696"+
		"\3\2\2\2\u0694\u0692\3\2\2\2\u0694\u0695\3\2\2\2\u0695\u0697\3\2\2\2\u0696"+
		"\u0694\3\2\2\2\u0697\u0699\7\b\2\2\u0698\u069a\7\\\2\2\u0699\u0698\3\2"+
		"\2\2\u0699\u069a\3\2\2\2\u069a\u069b\3\2\2\2\u069b\u069c\5r:\2\u069c\u069d"+
		"\b=\1\2\u069d\u06cf\3\2\2\2\u069e\u06a0\7\u0084\2\2\u069f\u069e\3\2\2"+
		"\2\u069f\u06a0\3\2\2\2\u06a0\u06a1\3\2\2\2\u06a1\u06a6\5\u0084C\2\u06a2"+
		"\u06a3\7\5\2\2\u06a3\u06a5\5\u0084C\2\u06a4\u06a2\3\2\2\2\u06a5\u06a8"+
		"\3\2\2\2\u06a6\u06a4\3\2\2\2\u06a6\u06a7\3\2\2\2\u06a7\u06a9\3\2\2\2\u06a8"+
		"\u06a6\3\2\2\2\u06a9\u06aa\7\b\2\2\u06aa\u06ab\7[\2\2\u06ab\u06ac\5r:"+
		"\2\u06ac\u06ad\b=\1\2\u06ad\u06cf\3\2\2\2\u06ae\u06b0\7\u0084\2\2\u06af"+
		"\u06ae\3\2\2\2\u06af\u06b0\3\2\2\2\u06b0\u06b1\3\2\2\2\u06b1\u06b6\5\u0084"+
		"C\2\u06b2\u06b3\7\5\2\2\u06b3\u06b5\5\u0084C\2\u06b4\u06b2\3\2\2\2\u06b5"+
		"\u06b8\3\2\2\2\u06b6\u06b4\3\2\2\2\u06b6\u06b7\3\2\2\2\u06b7\u06b9\3\2"+
		"\2\2\u06b8\u06b6\3\2\2\2\u06b9\u06ba\7\b\2\2\u06ba\u06bb\7]\2\2\u06bb"+
		"\u06bc\5r:\2\u06bc\u06bd\b=\1\2\u06bd\u06cf\3\2\2\2\u06be\u06c0\7\u0084"+
		"\2\2\u06bf\u06be\3\2\2\2\u06bf\u06c0\3\2\2\2\u06c0\u06c1\3\2\2\2\u06c1"+
		"\u06c6\5\u0084C\2\u06c2\u06c3\7\5\2\2\u06c3\u06c5\5\u0084C\2\u06c4\u06c2"+
		"\3\2\2\2\u06c5\u06c8\3\2\2\2\u06c6\u06c4\3\2\2\2\u06c6\u06c7\3\2\2\2\u06c7"+
		"\u06c9\3\2\2\2\u06c8\u06c6\3\2\2\2\u06c9\u06ca\7\b\2\2\u06ca\u06cb\7\u0085"+
		"\2\2\u06cb\u06cc\5r:\2\u06cc\u06cd\b=\1\2\u06cd\u06cf\3\2\2\2\u06ce\u068d"+
		"\3\2\2\2\u06ce\u069f\3\2\2\2\u06ce\u06af\3\2\2\2\u06ce\u06bf\3\2\2\2\u06cf"+
		"y\3\2\2\2\u06d0\u06d5\5|?\2\u06d1\u06d2\7\5\2\2\u06d2\u06d4\5|?\2\u06d3"+
		"\u06d1\3\2\2\2\u06d4\u06d7\3\2\2\2\u06d5\u06d3\3\2\2\2\u06d5\u06d6\3\2"+
		"\2\2\u06d6{\3\2\2\2\u06d7\u06d5\3\2\2\2\u06d8\u06dd\5\u0084C\2\u06d9\u06da"+
		"\7\5\2\2\u06da\u06dc\5\u0084C\2\u06db\u06d9\3\2\2\2\u06dc\u06df\3\2\2"+
		"\2\u06dd\u06db\3\2\2\2\u06dd\u06de\3\2\2\2\u06de\u06e0\3\2\2\2\u06df\u06dd"+
		"\3\2\2\2\u06e0\u06e1\7\31\2\2\u06e1\u06e2\5r:\2\u06e2\u06e3\b?\1\2\u06e3"+
		"}\3\2\2\2\u06e4\u06e9\5\u0080A\2\u06e5\u06e6\7\5\2\2\u06e6\u06e8\5\u0080"+
		"A\2\u06e7\u06e5\3\2\2\2\u06e8\u06eb\3\2\2\2\u06e9\u06e7\3\2\2\2\u06e9"+
		"\u06ea\3\2\2\2\u06ea\177\3\2\2\2\u06eb\u06e9\3\2\2\2\u06ec\u06ee\7\u0084"+
		"\2\2\u06ed\u06ec\3\2\2\2\u06ed\u06ee\3\2\2\2\u06ee\u06ef\3\2\2\2\u06ef"+
		"\u06f4\5\u0084C\2\u06f0\u06f1\7\5\2\2\u06f1\u06f3\5\u0084C\2\u06f2\u06f0"+
		"\3\2\2\2\u06f3\u06f6\3\2\2\2\u06f4\u06f2\3\2\2\2\u06f4\u06f5\3\2\2\2\u06f5"+
		"\u06f7\3\2\2\2\u06f6\u06f4\3\2\2\2\u06f7\u06f9\7\b\2\2\u06f8\u06fa\7\\"+
		"\2\2\u06f9\u06f8\3\2\2\2\u06f9\u06fa\3\2\2\2\u06fa\u06fb\3\2\2\2\u06fb"+
		"\u06fc\5r:\2\u06fc\u06fd\3\2\2\2\u06fd\u06fe\bA\1\2\u06fe\u0081\3\2\2"+
		"\2\u06ff\u0700\5\u0088E\2\u0700\u0083\3\2\2\2\u0701\u0702\5\u0088E\2\u0702"+
		"\u0703\bC\1\2\u0703\u0085\3\2\2\2\u0704\u0705\t\24\2\2\u0705\u0087\3\2"+
		"\2\2\u0706\u0731\5\u008aF\2\u0707\u0731\7\32\2\2\u0708\u0731\7#\2\2\u0709"+
		"\u0731\7N\2\2\u070a\u0731\7O\2\2\u070b\u0731\7\33\2\2\u070c\u0731\7.\2"+
		"\2\u070d\u0731\7<\2\2\u070e\u0731\7\u0086\2\2\u070f\u0731\7V\2\2\u0710"+
		"\u0731\7$\2\2\u0711\u0731\7?\2\2\u0712\u0731\7\u0087\2\2\u0713\u0731\7"+
		"\35\2\2\u0714\u0731\7%\2\2\u0715\u0731\7\27\2\2\u0716\u0731\7U\2\2\u0717"+
		"\u0731\7\34\2\2\u0718\u0731\7\61\2\2\u0719\u0731\7\16\2\2\u071a\u0731"+
		"\7\62\2\2\u071b\u0731\7&\2\2\u071c\u0731\7\30\2\2\u071d\u0731\7S\2\2\u071e"+
		"\u0731\7Q\2\2\u071f\u0731\7;\2\2\u0720\u0731\7,\2\2\u0721\u0731\7\"\2"+
		"\2\u0722\u0731\7B\2\2\u0723\u0731\7\u0088\2\2\u0724\u0731\7/\2\2\u0725"+
		"\u0731\7\36\2\2\u0726\u0731\7\65\2\2\u0727\u0731\7 \2\2\u0728\u0731\7"+
		"(\2\2\u0729\u0731\7*\2\2\u072a\u0731\7!\2\2\u072b\u0731\7P\2\2\u072c\u0731"+
		"\7@\2\2\u072d\u0731\7=\2\2\u072e\u0731\7A\2\2\u072f\u0731\7\16\2\2\u0730"+
		"\u0706\3\2\2\2\u0730\u0707\3\2\2\2\u0730\u0708\3\2\2\2\u0730\u0709\3\2"+
		"\2\2\u0730\u070a\3\2\2\2\u0730\u070b\3\2\2\2\u0730\u070c\3\2\2\2\u0730"+
		"\u070d\3\2\2\2\u0730\u070e\3\2\2\2\u0730\u070f\3\2\2\2\u0730\u0710\3\2"+
		"\2\2\u0730\u0711\3\2\2\2\u0730\u0712\3\2\2\2\u0730\u0713\3\2\2\2\u0730"+
		"\u0714\3\2\2\2\u0730\u0715\3\2\2\2\u0730\u0716\3\2\2\2\u0730\u0717\3\2"+
		"\2\2\u0730\u0718\3\2\2\2\u0730\u0719\3\2\2\2\u0730\u071a\3\2\2\2\u0730"+
		"\u071b\3\2\2\2\u0730\u071c\3\2\2\2\u0730\u071d\3\2\2\2\u0730\u071e\3\2"+
		"\2\2\u0730\u071f\3\2\2\2\u0730\u0720\3\2\2\2\u0730\u0721\3\2\2\2\u0730"+
		"\u0722\3\2\2\2\u0730\u0723\3\2\2\2\u0730\u0724\3\2\2\2\u0730\u0725\3\2"+
		"\2\2\u0730\u0726\3\2\2\2\u0730\u0727\3\2\2\2\u0730\u0728\3\2\2\2\u0730"+
		"\u0729\3\2\2\2\u0730\u072a\3\2\2\2\u0730\u072b\3\2\2\2\u0730\u072c\3\2"+
		"\2\2\u0730\u072d\3\2\2\2\u0730\u072e\3\2\2\2\u0730\u072f\3\2\2\2\u0731"+
		"\u0089\3\2\2\2\u0732\u0733\7\u008a\2\2\u0733\u008b\3\2\2\2\u0734\u0735"+
		"\t\25\2\2\u0735\u008d\3\2\2\2\u0736\u0737\7\u0089\2\2\u0737\u008f\3\2"+
		"\2\2\u00eb\u0097\u00a8\u00ae\u00b3\u00b9\u00bf\u00c7\u00d0\u00d6\u00e0"+
		"\u00eb\u00f1\u00f3\u00f7\u00ff\u010d\u0114\u0119\u011c\u0128\u012f\u0135"+
		"\u0141\u0148\u0163\u0165\u016a\u0175\u0178\u017c\u0180\u0184\u0189\u0192"+
		"\u0195\u019a\u01aa\u01ac\u01b1\u01b9\u01bc\u01c0\u01c4\u01c7\u01ca\u01cd"+
		"\u01d6\u01db\u01e7\u01ea\u01ee\u01f1\u01f9\u0202\u0209\u020e\u0213\u0217"+
		"\u021b\u021e\u0221\u0224\u022c\u0232\u0237\u0245\u0248\u024c\u024f\u0258"+
		"\u025d\u0264\u026d\u0274\u0279\u027e\u0282\u0286\u0291\u0294\u029c\u029e"+
		"\u02a8\u02ab\u02b3\u02b6\u02ba\u02bd\u02cc\u02ce\u02d3\u02e3\u02eb\u02ee"+
		"\u02f2\u02f5\u02fb\u0300\u0308\u030b\u030f\u0315\u0319\u0320\u0325\u032b"+
		"\u032e\u0337\u0339\u033e\u0343\u034b\u0350\u0356\u0359\u0365\u0367\u036c"+
		"\u0373\u0379\u0380\u0386\u038a\u0394\u0399\u03a6\u03a8\u03ad\u03b0\u03b4"+
		"\u03be\u03cc\u03d7\u03e3\u03f1\u03f4\u03fe\u0407\u040c\u0414\u041d\u0422"+
		"\u0427\u042b\u042f\u0434\u0440\u0444\u0449\u044d\u0452\u045a\u045c\u0461"+
		"\u0465\u046e\u0470\u0475\u0479\u0482\u0484\u0489\u048d\u0493\u0498\u049c"+
		"\u04a2\u04a7\u04ab\u04b2\u04c9\u04d1\u04d9\u04e1\u04e9\u04f1\u04f9\u0513"+
		"\u0516\u0534\u0538\u053e\u0542\u054e\u0552\u0558\u055c\u0568\u056c\u0572"+
		"\u0576\u0582\u0586\u058c\u0590\u059c\u05a0\u05a6\u05aa\u05b6\u05ba\u05c0"+
		"\u05c4\u05d1\u05e7\u05e9\u0618\u0630\u0634\u0644\u0646\u065b\u0664\u067f"+
		"\u0681\u0689\u068d\u0694\u0699\u069f\u06a6\u06af\u06b6\u06bf\u06c6\u06ce"+
		"\u06d5\u06dd\u06e9\u06ed\u06f4\u06f9\u0730";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}