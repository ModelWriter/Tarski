// Generated from /home/emrekirmizi/Documents/projects/git/WP3/Source/eu.modelwriter.core.alloyinecore/bin/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.5.3
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
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, INT=79, IDENTIFIER=80, 
		DOUBLE_QUOTED_STRING=81, SINGLE_QUOTED_STRING=82, ML_SINGLE_QUOTED_STRING=83, 
		MULTILINE_COMMENT=84, SINGLELINE_COMMENT=85, WS=86;
	public static final int
		RULE_module = 0, RULE_packageImport = 1, RULE_ePackage = 2, RULE_eClassifier = 3, 
		RULE_eClass = 4, RULE_eStructuralFeature = 5, RULE_eAttribute = 6, RULE_eReference = 7, 
		RULE_eOperation = 8, RULE_eParameter = 9, RULE_eType = 10, RULE_eMultiplicity = 11, 
		RULE_eDataType = 12, RULE_ePrimitiveType = 13, RULE_eEnum = 14, RULE_eEnumLiteral = 15, 
		RULE_eAnnotation = 16, RULE_eDetail = 17, RULE_eModelElement = 18, RULE_eNamedElement = 19, 
		RULE_eTypedElement = 20, RULE_eModelElementRef = 21, RULE_templateSignature = 22, 
		RULE_body = 23, RULE_invariant = 24, RULE_precondition = 25, RULE_postcondition = 26, 
		RULE_visibilityKind = 27, RULE_expression = 28, RULE_formula = 29, RULE_qualifiedName = 30, 
		RULE_identifier = 31, RULE_upper = 32, RULE_lower = 33, RULE_signed = 34;
	public static final String[] ruleNames = {
		"module", "packageImport", "ePackage", "eClassifier", "eClass", "eStructuralFeature", 
		"eAttribute", "eReference", "eOperation", "eParameter", "eType", "eMultiplicity", 
		"eDataType", "ePrimitiveType", "eEnum", "eEnumLiteral", "eAnnotation", 
		"eDetail", "eModelElement", "eNamedElement", "eTypedElement", "eModelElementRef", 
		"templateSignature", "body", "invariant", "precondition", "postcondition", 
		"visibilityKind", "expression", "formula", "qualifiedName", "identifier", 
		"upper", "lower", "signed"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'module'", "'import'", "':'", "';'", "'package'", "'='", "'{'", 
		"'}'", "'abstract'", "'class'", "'extends'", "','", "'interface'", "'static'", 
		"'attribute'", "'derived'", "'!derived'", "'id'", "'!id'", "'ordered'", 
		"'!ordered'", "'readonly'", "'!readonly'", "'transient'", "'!transient'", 
		"'unique'", "'!unique'", "'unsettable'", "'!unsettable'", "'volatile'", 
		"'!volatile'", "'initial'", "'derivation'", "'property'", "'#'", "'composes'", 
		"'!composes'", "'resolve'", "'!resolve'", "'key'", "'operation'", "'('", 
		"')'", "'throws'", "'['", "'..'", "'*'", "'+'", "'?'", "'|?'", "'|1'", 
		"']'", "'primitive'", "'datatype'", "'serializable'", "'!serializable'", 
		"'Boolean'", "'Integer'", "'String'", "'Real'", "'UnlimitedNatural'", 
		"'enum'", "'literal'", "'annotation'", "'reference'", "'<'", "'>'", "'body'", 
		"'callable'", "'invariant'", "'precondition'", "'postcondition'", "'public'", 
		"'protected'", "'private'", "'expr'", "'::'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", 
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




	public AlloyInEcoreParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModuleContext extends ParserRuleContext {
		public PackageImportContext packageImport;
		public List<PackageImportContext> ownedPackageImport = new ArrayList<PackageImportContext>();
		public EPackageContext ePackage;
		public List<EPackageContext> ownedPackage = new ArrayList<EPackageContext>();
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
		enterRule(_localctx, 0, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(70);
				match(T__0);
				setState(71);
				identifier();
				}
			}

			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(74);
				((ModuleContext)_localctx).packageImport = packageImport();
				((ModuleContext)_localctx).ownedPackageImport.add(((ModuleContext)_localctx).packageImport);
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)))) != 0)) {
				{
				{
				setState(80);
				((ModuleContext)_localctx).ePackage = ePackage();
				((ModuleContext)_localctx).ownedPackage.add(((ModuleContext)_localctx).ePackage);
				}
				}
				setState(85);
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
		enterRule(_localctx, 2, RULE_packageImport);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(86);
			match(T__1);
			}
			setState(90);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(87);
				((PackageImportContext)_localctx).name = identifier();
				setState(88);
				match(T__2);
				}
			}

			setState(92);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(93);
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
		enterRule(_localctx, 4, RULE_ePackage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(95);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
				break;
			}
			setState(98);
			match(T__4);
			setState(99);
			((EPackageContext)_localctx).name = identifier();
			{
			setState(100);
			match(T__2);
			setState(101);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(103);
			match(T__5);
			setState(104);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			setState(118);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(106);
				match(T__6);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__52) | (1L << T__53) | (1L << T__61))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (T__74 - 64)))) != 0)) {
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(107);
						((EPackageContext)_localctx).eAnnotation = eAnnotation();
						((EPackageContext)_localctx).ownedAnnotations.add(((EPackageContext)_localctx).eAnnotation);
						}
						break;
					case 2:
						{
						setState(108);
						((EPackageContext)_localctx).ePackage = ePackage();
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						}
						break;
					case 3:
						{
						setState(109);
						((EPackageContext)_localctx).eClassifier = eClassifier();
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						}
						break;
					case 4:
						{
						setState(110);
						((EPackageContext)_localctx).invariant = invariant();
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(116);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(117);
				match(T__3);
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
		enterRule(_localctx, 6, RULE_eClassifier);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				eClass();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				eDataType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
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
		enterRule(_localctx, 8, RULE_eClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)))) != 0)) {
				{
				setState(125);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(129);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(128);
				((EClassContext)_localctx).isAbstract = match(T__8);
				}
			}

			setState(131);
			match(T__9);
			setState(132);
			((EClassContext)_localctx).name = identifier();
			setState(142);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(133);
				match(T__10);
				setState(134);
				((EClassContext)_localctx).qualifiedName = qualifiedName();
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(135);
					match(T__11);
					setState(136);
					((EClassContext)_localctx).qualifiedName = qualifiedName();
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(146);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(144);
				match(T__2);
				setState(145);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(148);
				match(T__6);
				setState(150);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(149);
					((EClassContext)_localctx).isInterface = match(T__12);
					}
				}

				setState(152);
				match(T__7);
				}
				break;
			}
			setState(167);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(155);
				match(T__6);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__13) | (1L << T__14) | (1L << T__33) | (1L << T__40))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (T__74 - 64)))) != 0)) {
					{
					setState(160);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(156);
						((EClassContext)_localctx).eAnnotation = eAnnotation();
						((EClassContext)_localctx).ownedAnnotations.add(((EClassContext)_localctx).eAnnotation);
						}
						break;
					case 2:
						{
						setState(157);
						((EClassContext)_localctx).eOperation = eOperation();
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						}
						break;
					case 3:
						{
						setState(158);
						((EClassContext)_localctx).eStructuralFeature = eStructuralFeature();
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						}
						break;
					case 4:
						{
						setState(159);
						((EClassContext)_localctx).invariant = invariant();
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(165);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(166);
				match(T__3);
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
		enterRule(_localctx, 10, RULE_eStructuralFeature);
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				eAttribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
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
		public Token s14;
		public List<Token> qualifier = new ArrayList<Token>();
		public IdentifierContext name;
		public Token defaultValue;
		public ETypeContext eAttributeType;
		public EMultiplicityContext multiplicity;
		public Token s16;
		public Token s17;
		public Token s18;
		public Token s19;
		public Token s20;
		public Token s21;
		public Token s22;
		public Token s23;
		public Token s24;
		public Token s25;
		public Token s26;
		public Token s27;
		public Token s28;
		public Token s29;
		public Token s30;
		public Token s31;
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
		enterRule(_localctx, 12, RULE_eAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)))) != 0)) {
				{
				setState(173);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(177);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(176);
				((EAttributeContext)_localctx).s14 = match(T__13);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s14);
				}
			}

			setState(179);
			match(T__14);
			setState(180);
			((EAttributeContext)_localctx).name = identifier();
			setState(183);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(181);
				match(T__5);
				setState(182);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(190);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(185);
				match(T__2);
				setState(186);
				((EAttributeContext)_localctx).eAttributeType = eType();
				setState(188);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(187);
					((EAttributeContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(192);
				match(T__6);
				setState(214); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(209);
					switch (_input.LA(1)) {
					case T__15:
						{
						setState(193);
						((EAttributeContext)_localctx).s16 = match(T__15);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(194);
						((EAttributeContext)_localctx).s17 = match(T__16);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s17);
						}
						break;
					case T__17:
						{
						setState(195);
						((EAttributeContext)_localctx).s18 = match(T__17);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s18);
						}
						break;
					case T__18:
						{
						setState(196);
						((EAttributeContext)_localctx).s19 = match(T__18);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s19);
						}
						break;
					case T__19:
						{
						setState(197);
						((EAttributeContext)_localctx).s20 = match(T__19);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(198);
						((EAttributeContext)_localctx).s21 = match(T__20);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s21);
						}
						break;
					case T__21:
						{
						setState(199);
						((EAttributeContext)_localctx).s22 = match(T__21);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s22);
						}
						break;
					case T__22:
						{
						setState(200);
						((EAttributeContext)_localctx).s23 = match(T__22);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s23);
						}
						break;
					case T__23:
						{
						setState(201);
						((EAttributeContext)_localctx).s24 = match(T__23);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s24);
						}
						break;
					case T__24:
						{
						setState(202);
						((EAttributeContext)_localctx).s25 = match(T__24);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s25);
						}
						break;
					case T__25:
						{
						setState(203);
						((EAttributeContext)_localctx).s26 = match(T__25);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(204);
						((EAttributeContext)_localctx).s27 = match(T__26);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
						}
						break;
					case T__27:
						{
						setState(205);
						((EAttributeContext)_localctx).s28 = match(T__27);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(206);
						((EAttributeContext)_localctx).s29 = match(T__28);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(207);
						((EAttributeContext)_localctx).s30 = match(T__29);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(208);
						((EAttributeContext)_localctx).s31 = match(T__30);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(212);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(211);
						match(T__11);
						}
					}

					}
					}
					setState(216); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0) );
				setState(218);
				match(T__7);
				}
				break;
			}
			setState(248);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(221);
				match(T__6);
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & ((1L << (T__31 - 32)) | (1L << (T__32 - 32)) | (1L << (T__63 - 32)))) != 0)) {
					{
					setState(241);
					switch (_input.LA(1)) {
					case T__63:
						{
						setState(222);
						((EAttributeContext)_localctx).eAnnotation = eAnnotation();
						((EAttributeContext)_localctx).ownedAnnotations.add(((EAttributeContext)_localctx).eAnnotation);
						}
						break;
					case T__31:
						{
						{
						setState(223);
						match(T__31);
						setState(225);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(224);
							identifier();
							}
						}

						setState(227);
						match(T__2);
						setState(229);
						_la = _input.LA(1);
						if (_la==T__75) {
							{
							setState(228);
							((EAttributeContext)_localctx).ownedInitialExpression = expression();
							}
						}

						setState(231);
						match(T__3);
						}
						}
						break;
					case T__32:
						{
						{
						setState(232);
						match(T__32);
						setState(234);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(233);
							identifier();
							}
						}

						setState(236);
						match(T__2);
						setState(238);
						_la = _input.LA(1);
						if (_la==T__75) {
							{
							setState(237);
							((EAttributeContext)_localctx).ownedDerivedExpression = expression();
							}
						}

						setState(240);
						match(T__3);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(246);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(247);
				match(T__3);
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
		public Token s14;
		public List<Token> qualifier = new ArrayList<Token>();
		public IdentifierContext name;
		public IdentifierContext opposite;
		public ETypeContext eReferenceType;
		public EMultiplicityContext multiplicity;
		public Token defaultValue;
		public Token s36;
		public Token s37;
		public Token s16;
		public Token s17;
		public Token s20;
		public Token s21;
		public Token s22;
		public Token s23;
		public Token s38;
		public Token s39;
		public Token s24;
		public Token s25;
		public Token s26;
		public Token s27;
		public Token s28;
		public Token s29;
		public Token s30;
		public Token s31;
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
		enterRule(_localctx, 14, RULE_eReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)))) != 0)) {
				{
				setState(250);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(254);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(253);
				((EReferenceContext)_localctx).s14 = match(T__13);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s14);
				}
			}

			setState(256);
			match(T__33);
			setState(257);
			((EReferenceContext)_localctx).name = identifier();
			setState(260);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(258);
				match(T__34);
				setState(259);
				((EReferenceContext)_localctx).opposite = identifier();
				}
			}

			setState(267);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(262);
				match(T__2);
				setState(263);
				((EReferenceContext)_localctx).eReferenceType = eType();
				setState(265);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(264);
					((EReferenceContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(271);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(269);
				match(T__5);
				setState(270);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(273);
				match(T__6);
				setState(297); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(292);
					switch (_input.LA(1)) {
					case T__35:
						{
						setState(274);
						((EReferenceContext)_localctx).s36 = match(T__35);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(275);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__15:
						{
						setState(276);
						((EReferenceContext)_localctx).s16 = match(T__15);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(277);
						((EReferenceContext)_localctx).s17 = match(T__16);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s17);
						}
						break;
					case T__19:
						{
						setState(278);
						((EReferenceContext)_localctx).s20 = match(T__19);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(279);
						((EReferenceContext)_localctx).s21 = match(T__20);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s21);
						}
						break;
					case T__21:
						{
						setState(280);
						((EReferenceContext)_localctx).s22 = match(T__21);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s22);
						}
						break;
					case T__22:
						{
						setState(281);
						((EReferenceContext)_localctx).s23 = match(T__22);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s23);
						}
						break;
					case T__37:
						{
						setState(282);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(283);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__23:
						{
						setState(284);
						((EReferenceContext)_localctx).s24 = match(T__23);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s24);
						}
						break;
					case T__24:
						{
						setState(285);
						((EReferenceContext)_localctx).s25 = match(T__24);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s25);
						}
						break;
					case T__25:
						{
						setState(286);
						((EReferenceContext)_localctx).s26 = match(T__25);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(287);
						((EReferenceContext)_localctx).s27 = match(T__26);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
						}
						break;
					case T__27:
						{
						setState(288);
						((EReferenceContext)_localctx).s28 = match(T__27);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(289);
						((EReferenceContext)_localctx).s29 = match(T__28);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(290);
						((EReferenceContext)_localctx).s30 = match(T__29);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(291);
						((EReferenceContext)_localctx).s31 = match(T__30);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(295);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(294);
						match(T__11);
						}
					}

					}
					}
					setState(299); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0) );
				setState(301);
				match(T__7);
				}
				break;
			}
			setState(342);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(304);
				match(T__6);
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & ((1L << (T__31 - 32)) | (1L << (T__32 - 32)) | (1L << (T__39 - 32)) | (1L << (T__63 - 32)))) != 0)) {
					{
					setState(335);
					switch (_input.LA(1)) {
					case T__63:
						{
						setState(305);
						((EReferenceContext)_localctx).eAnnotation = eAnnotation();
						((EReferenceContext)_localctx).ownedAnnotations.add(((EReferenceContext)_localctx).eAnnotation);
						}
						break;
					case T__39:
						{
						{
						setState(306);
						match(T__39);
						setState(307);
						((EReferenceContext)_localctx).qualifiedName = qualifiedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
						setState(312);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__11) {
							{
							{
							setState(308);
							match(T__11);
							setState(309);
							((EReferenceContext)_localctx).qualifiedName = qualifiedName();
							((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
							}
							}
							setState(314);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(315);
						match(T__3);
						}
						}
						break;
					case T__31:
						{
						{
						setState(317);
						match(T__31);
						setState(319);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(318);
							identifier();
							}
						}

						setState(321);
						match(T__2);
						setState(323);
						_la = _input.LA(1);
						if (_la==T__75) {
							{
							setState(322);
							((EReferenceContext)_localctx).expression = expression();
							((EReferenceContext)_localctx).ownedInitialExpression.add(((EReferenceContext)_localctx).expression);
							}
						}

						setState(325);
						match(T__3);
						}
						}
						break;
					case T__32:
						{
						{
						setState(326);
						match(T__32);
						setState(328);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(327);
							identifier();
							}
						}

						setState(330);
						match(T__2);
						setState(332);
						_la = _input.LA(1);
						if (_la==T__75) {
							{
							setState(331);
							((EReferenceContext)_localctx).expression = expression();
							((EReferenceContext)_localctx).ownedDerivedExpression.add(((EReferenceContext)_localctx).expression);
							}
						}

						setState(334);
						match(T__3);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(339);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(340);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(341);
				match(T__3);
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
		public Token s14;
		public List<Token> qualifier = new ArrayList<Token>();
		public IdentifierContext name;
		public EParameterContext eParameter;
		public List<EParameterContext> eParameters = new ArrayList<EParameterContext>();
		public ETypeContext returnType;
		public EMultiplicityContext multiplicity;
		public IdentifierContext identifier;
		public List<IdentifierContext> ownedException = new ArrayList<IdentifierContext>();
		public Token s16;
		public Token s17;
		public Token s20;
		public Token s21;
		public Token s26;
		public Token s27;
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
		enterRule(_localctx, 16, RULE_eOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)))) != 0)) {
				{
				setState(344);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(348);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(347);
				((EOperationContext)_localctx).s14 = match(T__13);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s14);
				}
			}

			setState(350);
			match(T__40);
			setState(351);
			((EOperationContext)_localctx).name = identifier();
			setState(352);
			match(T__41);
			setState(361);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(353);
				((EOperationContext)_localctx).eParameter = eParameter();
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(354);
					match(T__11);
					setState(355);
					((EOperationContext)_localctx).eParameter = eParameter();
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(363);
			match(T__42);
			setState(369);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(364);
				match(T__2);
				setState(365);
				((EOperationContext)_localctx).returnType = eType();
				setState(367);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(366);
					((EOperationContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(380);
			_la = _input.LA(1);
			if (_la==T__43) {
				{
				setState(371);
				match(T__43);
				setState(372);
				((EOperationContext)_localctx).identifier = identifier();
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(373);
					match(T__11);
					setState(374);
					((EOperationContext)_localctx).identifier = identifier();
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
					}
					}
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(382);
				match(T__6);
				setState(394); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(389);
					switch (_input.LA(1)) {
					case T__15:
						{
						setState(383);
						((EOperationContext)_localctx).s16 = match(T__15);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(384);
						((EOperationContext)_localctx).s17 = match(T__16);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s17);
						}
						break;
					case T__19:
						{
						setState(385);
						((EOperationContext)_localctx).s20 = match(T__19);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(386);
						((EOperationContext)_localctx).s21 = match(T__20);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s21);
						}
						break;
					case T__25:
						{
						setState(387);
						((EOperationContext)_localctx).s26 = match(T__25);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(388);
						((EOperationContext)_localctx).s27 = match(T__26);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s27);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(392);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(391);
						match(T__11);
						}
					}

					}
					}
					setState(396); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__26))) != 0) );
				setState(398);
				match(T__7);
				}
				break;
			}
			setState(413);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(401);
				match(T__6);
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__67 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)))) != 0)) {
					{
					setState(406);
					switch (_input.LA(1)) {
					case T__63:
						{
						setState(402);
						((EOperationContext)_localctx).eAnnotation = eAnnotation();
						((EOperationContext)_localctx).ownedAnnotations.add(((EOperationContext)_localctx).eAnnotation);
						}
						break;
					case T__70:
						{
						setState(403);
						((EOperationContext)_localctx).precondition = precondition();
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						}
						break;
					case T__67:
						{
						setState(404);
						((EOperationContext)_localctx).body = body();
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						}
						break;
					case T__71:
						{
						setState(405);
						((EOperationContext)_localctx).postcondition = postcondition();
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(411);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(412);
				match(T__3);
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
		public IdentifierContext name;
		public ETypeContext ownedType;
		public EMultiplicityContext ownedMultiplicity;
		public Token s20;
		public List<Token> qualifier = new ArrayList<Token>();
		public Token s21;
		public Token s26;
		public Token s27;
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
		enterRule(_localctx, 18, RULE_eParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			((EParameterContext)_localctx).name = identifier();
			setState(421);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(416);
				match(T__2);
				setState(417);
				((EParameterContext)_localctx).ownedType = eType();
				setState(419);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(418);
					((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(423);
				match(T__6);
				setState(433); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(428);
					switch (_input.LA(1)) {
					case T__19:
						{
						setState(424);
						((EParameterContext)_localctx).s20 = match(T__19);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(425);
						((EParameterContext)_localctx).s21 = match(T__20);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s21);
						}
						break;
					case T__25:
						{
						setState(426);
						((EParameterContext)_localctx).s26 = match(T__25);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(427);
						((EParameterContext)_localctx).s27 = match(T__26);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s27);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(431);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(430);
						match(T__11);
						}
					}

					}
					}
					setState(435); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__26))) != 0) );
				setState(437);
				match(T__7);
				}
				break;
			}
			setState(448);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(440);
				match(T__6);
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__63) {
					{
					{
					setState(441);
					((EParameterContext)_localctx).eAnnotation = eAnnotation();
					((EParameterContext)_localctx).ownedAnnotations.add(((EParameterContext)_localctx).eAnnotation);
					}
					}
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(447);
				match(T__7);
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
		enterRule(_localctx, 20, RULE_eType);
		try {
			setState(452);
			switch (_input.LA(1)) {
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
				enterOuterAlt(_localctx, 1);
				{
				setState(450);
				ePrimitiveType();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(451);
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
		enterRule(_localctx, 22, RULE_eMultiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(T__44);
			setState(461);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(455);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(458);
				_la = _input.LA(1);
				if (_la==T__45) {
					{
					setState(456);
					match(T__45);
					setState(457);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__46:
			case T__47:
			case T__48:
				{
				setState(460);
				((EMultiplicityContext)_localctx).stringBounds = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48))) != 0)) ) {
					((EMultiplicityContext)_localctx).stringBounds = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(465);
			switch (_input.LA(1)) {
			case T__49:
				{
				setState(463);
				match(T__49);
				}
				break;
			case T__50:
				{
				setState(464);
				((EMultiplicityContext)_localctx).isNullFree = match(T__50);
				}
				break;
			case T__51:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(467);
			match(T__51);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 24, RULE_eDataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			_la = _input.LA(1);
			if (_la==T__52) {
				{
				setState(469);
				((EDataTypeContext)_localctx).isPrimitive = match(T__52);
				}
			}

			setState(472);
			match(T__53);
			setState(473);
			((EDataTypeContext)_localctx).name = identifier();
			setState(475);
			_la = _input.LA(1);
			if (_la==T__41 || _la==T__65) {
				{
				setState(474);
				((EDataTypeContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(479);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(477);
				match(T__2);
				setState(478);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(487);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				{
				setState(481);
				match(T__6);
				setState(484);
				switch (_input.LA(1)) {
				case T__54:
					{
					setState(482);
					((EDataTypeContext)_localctx).isSerializable = match(T__54);
					}
					break;
				case T__55:
					{
					setState(483);
					match(T__55);
					}
					break;
				case T__7:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(486);
				match(T__7);
				}
				break;
			}
			setState(501);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__68:
			case T__69:
				{
				setState(498);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(489);
					match(T__6);
					setState(490);
					((EDataTypeContext)_localctx).eAnnotation = eAnnotation();
					((EDataTypeContext)_localctx).ownedAnnotations.add(((EDataTypeContext)_localctx).eAnnotation);
					}
					break;
				case T__7:
				case T__68:
				case T__69:
					{
					setState(494);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__68 || _la==T__69) {
						{
						{
						setState(491);
						((EDataTypeContext)_localctx).invariant = invariant();
						((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
						}
						}
						setState(496);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(497);
					match(T__7);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__3:
				{
				setState(500);
				match(T__3);
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
		enterRule(_localctx, 26, RULE_ePrimitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0)) ) {
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
		enterRule(_localctx, 28, RULE_eEnum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)))) != 0)) {
				{
				setState(505);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(508);
			match(T__61);
			setState(509);
			((EEnumContext)_localctx).name = identifier();
			setState(511);
			_la = _input.LA(1);
			if (_la==T__41 || _la==T__65) {
				{
				setState(510);
				((EEnumContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(515);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(513);
				match(T__2);
				setState(514);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(523);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				{
				setState(517);
				match(T__6);
				setState(520);
				switch (_input.LA(1)) {
				case T__54:
					{
					setState(518);
					((EEnumContext)_localctx).isSerializable = match(T__54);
					}
					break;
				case T__55:
					{
					setState(519);
					match(T__55);
					}
					break;
				case T__7:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(522);
				match(T__7);
				}
				break;
			}
			setState(536);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(525);
				match(T__6);
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (T__62 - 63)) | (1L << (T__63 - 63)) | (1L << (T__68 - 63)) | (1L << (T__69 - 63)) | (1L << (IDENTIFIER - 63)))) != 0)) {
					{
					setState(529);
					switch (_input.LA(1)) {
					case T__63:
						{
						setState(526);
						((EEnumContext)_localctx).eAnnotation = eAnnotation();
						((EEnumContext)_localctx).ownedAnnotations.add(((EEnumContext)_localctx).eAnnotation);
						}
						break;
					case T__62:
					case IDENTIFIER:
						{
						setState(527);
						((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral();
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						}
						break;
					case T__68:
					case T__69:
						{
						setState(528);
						((EEnumContext)_localctx).invariant = invariant();
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(533);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(534);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(535);
				match(T__3);
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
		enterRule(_localctx, 30, RULE_eEnumLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			switch (_input.LA(1)) {
			case T__62:
				{
				{
				setState(538);
				match(T__62);
				setState(539);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				}
				break;
			case IDENTIFIER:
				{
				setState(540);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(545);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(543);
				match(T__5);
				setState(544);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}

			setState(556);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(547);
				match(T__6);
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__63) {
					{
					{
					setState(548);
					((EEnumLiteralContext)_localctx).eAnnotation = eAnnotation();
					((EEnumLiteralContext)_localctx).ownedAnnotations.add(((EEnumLiteralContext)_localctx).eAnnotation);
					}
					}
					setState(553);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(554);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(555);
				match(T__3);
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
		enterRule(_localctx, 32, RULE_eAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			match(T__63);
			setState(560);
			_la = _input.LA(1);
			if (_la==SINGLE_QUOTED_STRING) {
				{
				setState(559);
				((EAnnotationContext)_localctx).name = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(573);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(562);
				match(T__41);
				setState(563);
				((EAnnotationContext)_localctx).eDetail = eDetail();
				((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
				setState(568);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(564);
					match(T__11);
					setState(565);
					((EAnnotationContext)_localctx).eDetail = eDetail();
					((EAnnotationContext)_localctx).ownedDetails.add(((EAnnotationContext)_localctx).eDetail);
					}
					}
					setState(570);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(571);
				match(T__42);
				}
			}

			setState(586);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(575);
				match(T__6);
				setState(579); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(579);
					switch (_input.LA(1)) {
					case T__63:
						{
						setState(576);
						((EAnnotationContext)_localctx).eAnnotation = eAnnotation();
						((EAnnotationContext)_localctx).ownedAnnotations.add(((EAnnotationContext)_localctx).eAnnotation);
						}
						break;
					case T__4:
					case T__8:
					case T__9:
					case T__13:
					case T__14:
					case T__33:
					case T__40:
					case T__52:
					case T__53:
					case T__61:
					case T__62:
					case T__72:
					case T__73:
					case T__74:
					case IDENTIFIER:
						{
						setState(577);
						((EAnnotationContext)_localctx).eModelElement = eModelElement();
						((EAnnotationContext)_localctx).ownedContents.add(((EAnnotationContext)_localctx).eModelElement);
						}
						break;
					case T__64:
						{
						setState(578);
						((EAnnotationContext)_localctx).eModelElementRef = eModelElementRef();
						((EAnnotationContext)_localctx).ownedReferences.add(((EAnnotationContext)_localctx).eModelElementRef);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(581); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__13) | (1L << T__14) | (1L << T__33) | (1L << T__40) | (1L << T__52) | (1L << T__53) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (T__74 - 64)) | (1L << (IDENTIFIER - 64)))) != 0) );
				setState(583);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(585);
				match(T__3);
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
		enterRule(_localctx, 34, RULE_eDetail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			((EDetailContext)_localctx).name = match(SINGLE_QUOTED_STRING);
			setState(589);
			match(T__5);
			setState(590);
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
		public EClassifierContext eClassifier() {
			return getRuleContext(EClassifierContext.class,0);
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
		enterRule(_localctx, 36, RULE_eModelElement);
		try {
			setState(594);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(592);
				eClassifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
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
		enterRule(_localctx, 38, RULE_eNamedElement);
		try {
			setState(598);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(596);
				eTypedElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(597);
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
		enterRule(_localctx, 40, RULE_eTypedElement);
		try {
			setState(603);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(600);
				eOperation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(601);
				eParameter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(602);
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
		enterRule(_localctx, 42, RULE_eModelElementRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			match(T__64);
			setState(606);
			((EModelElementRefContext)_localctx).ownedPathName = qualifiedName();
			setState(607);
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
		enterRule(_localctx, 44, RULE_templateSignature);
		int _la;
		try {
			setState(631);
			switch (_input.LA(1)) {
			case T__41:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(609);
				match(T__41);
				setState(610);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(615);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(611);
					match(T__11);
					setState(612);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(617);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(618);
				match(T__42);
				}
				}
				break;
			case T__65:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(620);
				match(T__65);
				setState(621);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(626);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(622);
					match(T__11);
					setState(623);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(628);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(629);
				match(T__66);
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
		public Token stereotype;
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
		enterRule(_localctx, 46, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			((BodyContext)_localctx).stereotype = match(T__67);
			setState(635);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(634);
				((BodyContext)_localctx).name = identifier();
				}
			}

			setState(643);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(637);
				match(T__2);
				setState(639);
				_la = _input.LA(1);
				if (_la==T__75) {
					{
					setState(638);
					((BodyContext)_localctx).ownedExpression = expression();
					}
				}

				setState(641);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(642);
				match(T__3);
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
		public Token stereotype;
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
		enterRule(_localctx, 48, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(645);
				((InvariantContext)_localctx).isCallable = match(T__68);
				}
			}

			setState(648);
			((InvariantContext)_localctx).stereotype = match(T__69);
			setState(655);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(649);
				((InvariantContext)_localctx).name = identifier();
				setState(653);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(650);
					match(T__41);
					setState(651);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(652);
					match(T__42);
					}
				}

				}
			}

			setState(663);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(657);
				match(T__2);
				setState(659);
				_la = _input.LA(1);
				if (_la==T__75) {
					{
					setState(658);
					((InvariantContext)_localctx).ownedSpecification = formula();
					}
				}

				setState(661);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(662);
				match(T__3);
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
		public Token stereotype;
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
		enterRule(_localctx, 50, RULE_precondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			((PreconditionContext)_localctx).stereotype = match(T__70);
			setState(672);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(666);
				((PreconditionContext)_localctx).name = identifier();
				setState(670);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(667);
					match(T__41);
					setState(668);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(669);
					match(T__42);
					}
				}

				}
			}

			setState(680);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(674);
				match(T__2);
				setState(676);
				_la = _input.LA(1);
				if (_la==T__75) {
					{
					setState(675);
					((PreconditionContext)_localctx).ownedSpecification = formula();
					}
				}

				setState(678);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(679);
				match(T__3);
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
		public Token stereotype;
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
		enterRule(_localctx, 52, RULE_postcondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			((PostconditionContext)_localctx).stereotype = match(T__71);
			setState(689);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(683);
				((PostconditionContext)_localctx).name = identifier();
				setState(687);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(684);
					match(T__41);
					setState(685);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(686);
					match(T__42);
					}
				}

				}
			}

			setState(697);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(691);
				match(T__2);
				setState(693);
				_la = _input.LA(1);
				if (_la==T__75) {
					{
					setState(692);
					((PostconditionContext)_localctx).ownedSpecification = formula();
					}
				}

				setState(695);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(696);
				match(T__3);
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
		enterRule(_localctx, 54, RULE_visibilityKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			_la = _input.LA(1);
			if ( !(_la==T__4 || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)))) != 0)) ) {
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			match(T__75);
			}
		}
		catch (RecognitionException re) {
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
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703);
			match(T__75);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 60, RULE_qualifiedName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			((QualifiedNameContext)_localctx).identifier = identifier();
			((QualifiedNameContext)_localctx).firstPart.add(((QualifiedNameContext)_localctx).identifier);
			setState(715);
			_la = _input.LA(1);
			if (_la==T__76) {
				{
				setState(710);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(706);
						match(T__76);
						setState(707);
						((QualifiedNameContext)_localctx).identifier = identifier();
						((QualifiedNameContext)_localctx).midParts.add(((QualifiedNameContext)_localctx).identifier);
						}
						} 
					}
					setState(712);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
				}
				{
				setState(713);
				match(T__76);
				setState(714);
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
		enterRule(_localctx, 62, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
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
		enterRule(_localctx, 64, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			_la = _input.LA(1);
			if ( !(_la==T__46 || _la==INT) ) {
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
		enterRule(_localctx, 66, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
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
		enterRule(_localctx, 68, RULE_signed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724);
			_la = _input.LA(1);
			if (_la==T__77) {
				{
				setState(723);
				match(T__77);
				}
			}

			setState(726);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3X\u02db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\5\2K\n\2\3\2\7\2N\n\2\f\2\16\2Q\13\2\3"+
		"\2\7\2T\n\2\f\2\16\2W\13\2\3\3\3\3\3\3\3\3\5\3]\n\3\3\3\3\3\3\3\3\4\5"+
		"\4c\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4r\n\4\f"+
		"\4\16\4u\13\4\3\4\3\4\5\4y\n\4\3\5\3\5\3\5\5\5~\n\5\3\6\5\6\u0081\n\6"+
		"\3\6\5\6\u0084\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f"+
		"\13\6\5\6\u0091\n\6\3\6\3\6\5\6\u0095\n\6\3\6\3\6\5\6\u0099\n\6\3\6\5"+
		"\6\u009c\n\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a3\n\6\f\6\16\6\u00a6\13\6\3\6"+
		"\3\6\5\6\u00aa\n\6\3\7\3\7\5\7\u00ae\n\7\3\b\5\b\u00b1\n\b\3\b\5\b\u00b4"+
		"\n\b\3\b\3\b\3\b\3\b\5\b\u00ba\n\b\3\b\3\b\3\b\5\b\u00bf\n\b\5\b\u00c1"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u00d4\n\b\3\b\5\b\u00d7\n\b\6\b\u00d9\n\b\r\b\16\b\u00da\3\b\5"+
		"\b\u00de\n\b\3\b\3\b\3\b\3\b\5\b\u00e4\n\b\3\b\3\b\5\b\u00e8\n\b\3\b\3"+
		"\b\3\b\5\b\u00ed\n\b\3\b\3\b\5\b\u00f1\n\b\3\b\7\b\u00f4\n\b\f\b\16\b"+
		"\u00f7\13\b\3\b\3\b\5\b\u00fb\n\b\3\t\5\t\u00fe\n\t\3\t\5\t\u0101\n\t"+
		"\3\t\3\t\3\t\3\t\5\t\u0107\n\t\3\t\3\t\3\t\5\t\u010c\n\t\5\t\u010e\n\t"+
		"\3\t\3\t\5\t\u0112\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0127\n\t\3\t\5\t\u012a\n\t\6\t\u012c"+
		"\n\t\r\t\16\t\u012d\3\t\5\t\u0131\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0139"+
		"\n\t\f\t\16\t\u013c\13\t\3\t\3\t\3\t\3\t\5\t\u0142\n\t\3\t\3\t\5\t\u0146"+
		"\n\t\3\t\3\t\3\t\5\t\u014b\n\t\3\t\3\t\5\t\u014f\n\t\3\t\7\t\u0152\n\t"+
		"\f\t\16\t\u0155\13\t\3\t\3\t\5\t\u0159\n\t\3\n\5\n\u015c\n\n\3\n\5\n\u015f"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0167\n\n\f\n\16\n\u016a\13\n\5\n\u016c"+
		"\n\n\3\n\3\n\3\n\3\n\5\n\u0172\n\n\5\n\u0174\n\n\3\n\3\n\3\n\3\n\7\n\u017a"+
		"\n\n\f\n\16\n\u017d\13\n\5\n\u017f\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u0188\n\n\3\n\5\n\u018b\n\n\6\n\u018d\n\n\r\n\16\n\u018e\3\n\5\n\u0192"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\7\n\u0199\n\n\f\n\16\n\u019c\13\n\3\n\3\n\5\n"+
		"\u01a0\n\n\3\13\3\13\3\13\3\13\5\13\u01a6\n\13\5\13\u01a8\n\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u01af\n\13\3\13\5\13\u01b2\n\13\6\13\u01b4\n\13"+
		"\r\13\16\13\u01b5\3\13\5\13\u01b9\n\13\3\13\3\13\7\13\u01bd\n\13\f\13"+
		"\16\13\u01c0\13\13\3\13\5\13\u01c3\n\13\3\f\3\f\5\f\u01c7\n\f\3\r\3\r"+
		"\3\r\3\r\5\r\u01cd\n\r\3\r\5\r\u01d0\n\r\3\r\3\r\5\r\u01d4\n\r\3\r\3\r"+
		"\3\16\5\16\u01d9\n\16\3\16\3\16\3\16\5\16\u01de\n\16\3\16\3\16\5\16\u01e2"+
		"\n\16\3\16\3\16\3\16\5\16\u01e7\n\16\3\16\5\16\u01ea\n\16\3\16\3\16\3"+
		"\16\7\16\u01ef\n\16\f\16\16\16\u01f2\13\16\3\16\5\16\u01f5\n\16\3\16\5"+
		"\16\u01f8\n\16\3\17\3\17\3\20\5\20\u01fd\n\20\3\20\3\20\3\20\5\20\u0202"+
		"\n\20\3\20\3\20\5\20\u0206\n\20\3\20\3\20\3\20\5\20\u020b\n\20\3\20\5"+
		"\20\u020e\n\20\3\20\3\20\3\20\3\20\7\20\u0214\n\20\f\20\16\20\u0217\13"+
		"\20\3\20\3\20\5\20\u021b\n\20\3\21\3\21\3\21\5\21\u0220\n\21\3\21\3\21"+
		"\5\21\u0224\n\21\3\21\3\21\7\21\u0228\n\21\f\21\16\21\u022b\13\21\3\21"+
		"\3\21\5\21\u022f\n\21\3\22\3\22\5\22\u0233\n\22\3\22\3\22\3\22\3\22\7"+
		"\22\u0239\n\22\f\22\16\22\u023c\13\22\3\22\3\22\5\22\u0240\n\22\3\22\3"+
		"\22\3\22\3\22\6\22\u0246\n\22\r\22\16\22\u0247\3\22\3\22\3\22\5\22\u024d"+
		"\n\22\3\23\3\23\3\23\3\23\3\24\3\24\5\24\u0255\n\24\3\25\3\25\5\25\u0259"+
		"\n\25\3\26\3\26\3\26\5\26\u025e\n\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\7\30\u0268\n\30\f\30\16\30\u026b\13\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\7\30\u0273\n\30\f\30\16\30\u0276\13\30\3\30\3\30\5\30\u027a\n\30"+
		"\3\31\3\31\5\31\u027e\n\31\3\31\3\31\5\31\u0282\n\31\3\31\3\31\5\31\u0286"+
		"\n\31\3\32\5\32\u0289\n\32\3\32\3\32\3\32\3\32\3\32\5\32\u0290\n\32\5"+
		"\32\u0292\n\32\3\32\3\32\5\32\u0296\n\32\3\32\3\32\5\32\u029a\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u02a1\n\33\5\33\u02a3\n\33\3\33\3\33\5\33\u02a7"+
		"\n\33\3\33\3\33\5\33\u02ab\n\33\3\34\3\34\3\34\3\34\3\34\5\34\u02b2\n"+
		"\34\5\34\u02b4\n\34\3\34\3\34\5\34\u02b8\n\34\3\34\3\34\5\34\u02bc\n\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \7 \u02c7\n \f \16 \u02ca\13 \3"+
		" \3 \5 \u02ce\n \3!\3!\3\"\3\"\3#\3#\3$\5$\u02d7\n$\3$\3$\3$\2\2%\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\7\3"+
		"\2\61\63\3\2;?\3\2TU\4\2\7\7KM\4\2\61\61QQ\u036f\2J\3\2\2\2\4X\3\2\2\2"+
		"\6b\3\2\2\2\b}\3\2\2\2\n\u0080\3\2\2\2\f\u00ad\3\2\2\2\16\u00b0\3\2\2"+
		"\2\20\u00fd\3\2\2\2\22\u015b\3\2\2\2\24\u01a1\3\2\2\2\26\u01c6\3\2\2\2"+
		"\30\u01c8\3\2\2\2\32\u01d8\3\2\2\2\34\u01f9\3\2\2\2\36\u01fc\3\2\2\2 "+
		"\u021f\3\2\2\2\"\u0230\3\2\2\2$\u024e\3\2\2\2&\u0254\3\2\2\2(\u0258\3"+
		"\2\2\2*\u025d\3\2\2\2,\u025f\3\2\2\2.\u0279\3\2\2\2\60\u027b\3\2\2\2\62"+
		"\u0288\3\2\2\2\64\u029b\3\2\2\2\66\u02ac\3\2\2\28\u02bd\3\2\2\2:\u02bf"+
		"\3\2\2\2<\u02c1\3\2\2\2>\u02c3\3\2\2\2@\u02cf\3\2\2\2B\u02d1\3\2\2\2D"+
		"\u02d3\3\2\2\2F\u02d6\3\2\2\2HI\7\3\2\2IK\5@!\2JH\3\2\2\2JK\3\2\2\2KO"+
		"\3\2\2\2LN\5\4\3\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PU\3\2\2\2Q"+
		"O\3\2\2\2RT\5\6\4\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\3\3\2\2\2"+
		"WU\3\2\2\2X\\\7\4\2\2YZ\5@!\2Z[\7\5\2\2[]\3\2\2\2\\Y\3\2\2\2\\]\3\2\2"+
		"\2]^\3\2\2\2^_\7T\2\2_`\7\6\2\2`\5\3\2\2\2ac\58\35\2ba\3\2\2\2bc\3\2\2"+
		"\2cd\3\2\2\2de\7\7\2\2ef\5@!\2fg\7\5\2\2gh\5@!\2hi\3\2\2\2ij\7\b\2\2j"+
		"k\7T\2\2kx\3\2\2\2ls\7\t\2\2mr\5\"\22\2nr\5\6\4\2or\5\b\5\2pr\5\62\32"+
		"\2qm\3\2\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2"+
		"\2tv\3\2\2\2us\3\2\2\2vy\7\n\2\2wy\7\6\2\2xl\3\2\2\2xw\3\2\2\2y\7\3\2"+
		"\2\2z~\5\n\6\2{~\5\32\16\2|~\5\36\20\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~"+
		"\t\3\2\2\2\177\u0081\58\35\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0083\3\2\2\2\u0082\u0084\7\13\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3"+
		"\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\7\f\2\2\u0086\u0090\5@!\2\u0087"+
		"\u0088\7\r\2\2\u0088\u008d\5> \2\u0089\u008a\7\16\2\2\u008a\u008c\5> "+
		"\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0087\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0093\7\5\2\2\u0093\u0095\7T"+
		"\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u009b\3\2\2\2\u0096"+
		"\u0098\7\t\2\2\u0097\u0099\7\17\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3"+
		"\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\7\n\2\2\u009b\u0096\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u00a9\3\2\2\2\u009d\u00a4\7\t\2\2\u009e\u00a3\5\""+
		"\22\2\u009f\u00a3\5\22\n\2\u00a0\u00a3\5\f\7\2\u00a1\u00a3\5\62\32\2\u00a2"+
		"\u009e\3\2\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2"+
		"\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\7\n\2\2\u00a8\u00aa\7\6"+
		"\2\2\u00a9\u009d\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\13\3\2\2\2\u00ab\u00ae"+
		"\5\16\b\2\u00ac\u00ae\5\20\t\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2"+
		"\u00ae\r\3\2\2\2\u00af\u00b1\58\35\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3"+
		"\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b4\7\20\2\2\u00b3\u00b2\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7\21\2\2\u00b6\u00b9\5"+
		"@!\2\u00b7\u00b8\7\b\2\2\u00b8\u00ba\7T\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00c0\3\2\2\2\u00bb\u00bc\7\5\2\2\u00bc\u00be\5\26"+
		"\f\2\u00bd\u00bf\5\30\r\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c1\3\2\2\2\u00c0\u00bb\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00dd\3\2"+
		"\2\2\u00c2\u00d8\7\t\2\2\u00c3\u00d4\7\22\2\2\u00c4\u00d4\7\23\2\2\u00c5"+
		"\u00d4\7\24\2\2\u00c6\u00d4\7\25\2\2\u00c7\u00d4\7\26\2\2\u00c8\u00d4"+
		"\7\27\2\2\u00c9\u00d4\7\30\2\2\u00ca\u00d4\7\31\2\2\u00cb\u00d4\7\32\2"+
		"\2\u00cc\u00d4\7\33\2\2\u00cd\u00d4\7\34\2\2\u00ce\u00d4\7\35\2\2\u00cf"+
		"\u00d4\7\36\2\2\u00d0\u00d4\7\37\2\2\u00d1\u00d4\7 \2\2\u00d2\u00d4\7"+
		"!\2\2\u00d3\u00c3\3\2\2\2\u00d3\u00c4\3\2\2\2\u00d3\u00c5\3\2\2\2\u00d3"+
		"\u00c6\3\2\2\2\u00d3\u00c7\3\2\2\2\u00d3\u00c8\3\2\2\2\u00d3\u00c9\3\2"+
		"\2\2\u00d3\u00ca\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3\u00cc\3\2\2\2\u00d3"+
		"\u00cd\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d3\u00d0\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5"+
		"\u00d7\7\16\2\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3"+
		"\2\2\2\u00d8\u00d3\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\7\n\2\2\u00dd\u00c2\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\u00fa\3\2\2\2\u00df\u00f5\7\t\2\2\u00e0"+
		"\u00f4\5\"\22\2\u00e1\u00e3\7\"\2\2\u00e2\u00e4\5@!\2\u00e3\u00e2\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\7\5\2\2\u00e6"+
		"\u00e8\5:\36\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2"+
		"\2\2\u00e9\u00f4\7\6\2\2\u00ea\u00ec\7#\2\2\u00eb\u00ed\5@!\2\u00ec\u00eb"+
		"\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\7\5\2\2\u00ef"+
		"\u00f1\5:\36\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f4\7\6\2\2\u00f3\u00e0\3\2\2\2\u00f3\u00e1\3\2\2\2\u00f3"+
		"\u00ea\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\7\n\2\2\u00f9"+
		"\u00fb\7\6\2\2\u00fa\u00df\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\17\3\2\2"+
		"\2\u00fc\u00fe\58\35\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100"+
		"\3\2\2\2\u00ff\u0101\7\20\2\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2\2\2"+
		"\u0101\u0102\3\2\2\2\u0102\u0103\7$\2\2\u0103\u0106\5@!\2\u0104\u0105"+
		"\7%\2\2\u0105\u0107\5@!\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u010d\3\2\2\2\u0108\u0109\7\5\2\2\u0109\u010b\5\26\f\2\u010a\u010c\5"+
		"\30\r\2\u010b\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d"+
		"\u0108\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u0110\7\b"+
		"\2\2\u0110\u0112\7T\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0130\3\2\2\2\u0113\u012b\7\t\2\2\u0114\u0127\7&\2\2\u0115\u0127\7\'"+
		"\2\2\u0116\u0127\7\22\2\2\u0117\u0127\7\23\2\2\u0118\u0127\7\26\2\2\u0119"+
		"\u0127\7\27\2\2\u011a\u0127\7\30\2\2\u011b\u0127\7\31\2\2\u011c\u0127"+
		"\7(\2\2\u011d\u0127\7)\2\2\u011e\u0127\7\32\2\2\u011f\u0127\7\33\2\2\u0120"+
		"\u0127\7\34\2\2\u0121\u0127\7\35\2\2\u0122\u0127\7\36\2\2\u0123\u0127"+
		"\7\37\2\2\u0124\u0127\7 \2\2\u0125\u0127\7!\2\2\u0126\u0114\3\2\2\2\u0126"+
		"\u0115\3\2\2\2\u0126\u0116\3\2\2\2\u0126\u0117\3\2\2\2\u0126\u0118\3\2"+
		"\2\2\u0126\u0119\3\2\2\2\u0126\u011a\3\2\2\2\u0126\u011b\3\2\2\2\u0126"+
		"\u011c\3\2\2\2\u0126\u011d\3\2\2\2\u0126\u011e\3\2\2\2\u0126\u011f\3\2"+
		"\2\2\u0126\u0120\3\2\2\2\u0126\u0121\3\2\2\2\u0126\u0122\3\2\2\2\u0126"+
		"\u0123\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127\u0129\3\2"+
		"\2\2\u0128\u012a\7\16\2\2\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012c\3\2\2\2\u012b\u0126\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012b\3\2"+
		"\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\7\n\2\2\u0130"+
		"\u0113\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0158\3\2\2\2\u0132\u0153\7\t"+
		"\2\2\u0133\u0152\5\"\22\2\u0134\u0135\7*\2\2\u0135\u013a\5> \2\u0136\u0137"+
		"\7\16\2\2\u0137\u0139\5> \2\u0138\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013d\u013e\7\6\2\2\u013e\u0152\3\2\2\2\u013f\u0141\7\"\2\2\u0140"+
		"\u0142\5@!\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2"+
		"\2\u0143\u0145\7\5\2\2\u0144\u0146\5:\36\2\u0145\u0144\3\2\2\2\u0145\u0146"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0152\7\6\2\2\u0148\u014a\7#\2\2\u0149"+
		"\u014b\5@!\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\3\2\2"+
		"\2\u014c\u014e\7\5\2\2\u014d\u014f\5:\36\2\u014e\u014d\3\2\2\2\u014e\u014f"+
		"\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\7\6\2\2\u0151\u0133\3\2\2\2\u0151"+
		"\u0134\3\2\2\2\u0151\u013f\3\2\2\2\u0151\u0148\3\2\2\2\u0152\u0155\3\2"+
		"\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0156\3\2\2\2\u0155"+
		"\u0153\3\2\2\2\u0156\u0159\7\n\2\2\u0157\u0159\7\6\2\2\u0158\u0132\3\2"+
		"\2\2\u0158\u0157\3\2\2\2\u0159\21\3\2\2\2\u015a\u015c\58\35\2\u015b\u015a"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015f\7\20\2\2"+
		"\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161"+
		"\7+\2\2\u0161\u0162\5@!\2\u0162\u016b\7,\2\2\u0163\u0168\5\24\13\2\u0164"+
		"\u0165\7\16\2\2\u0165\u0167\5\24\13\2\u0166\u0164\3\2\2\2\u0167\u016a"+
		"\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016c\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016b\u0163\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2"+
		"\2\2\u016d\u0173\7-\2\2\u016e\u016f\7\5\2\2\u016f\u0171\5\26\f\2\u0170"+
		"\u0172\5\30\r\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3"+
		"\2\2\2\u0173\u016e\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u017e\3\2\2\2\u0175"+
		"\u0176\7.\2\2\u0176\u017b\5@!\2\u0177\u0178\7\16\2\2\u0178\u017a\5@!\2"+
		"\u0179\u0177\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c"+
		"\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u0175\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0191\3\2\2\2\u0180\u018c\7\t\2\2\u0181\u0188\7\22"+
		"\2\2\u0182\u0188\7\23\2\2\u0183\u0188\7\26\2\2\u0184\u0188\7\27\2\2\u0185"+
		"\u0188\7\34\2\2\u0186\u0188\7\35\2\2\u0187\u0181\3\2\2\2\u0187\u0182\3"+
		"\2\2\2\u0187\u0183\3\2\2\2\u0187\u0184\3\2\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0186\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u018b\7\16\2\2\u018a\u0189\3"+
		"\2\2\2\u018a\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u0187\3\2\2\2\u018d"+
		"\u018e\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2"+
		"\2\2\u0190\u0192\7\n\2\2\u0191\u0180\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u019f\3\2\2\2\u0193\u019a\7\t\2\2\u0194\u0199\5\"\22\2\u0195\u0199\5"+
		"\64\33\2\u0196\u0199\5\60\31\2\u0197\u0199\5\66\34\2\u0198\u0194\3\2\2"+
		"\2\u0198\u0195\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0197\3\2\2\2\u0199\u019c"+
		"\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c"+
		"\u019a\3\2\2\2\u019d\u01a0\7\n\2\2\u019e\u01a0\7\6\2\2\u019f\u0193\3\2"+
		"\2\2\u019f\u019e\3\2\2\2\u01a0\23\3\2\2\2\u01a1\u01a7\5@!\2\u01a2\u01a3"+
		"\7\5\2\2\u01a3\u01a5\5\26\f\2\u01a4\u01a6\5\30\r\2\u01a5\u01a4\3\2\2\2"+
		"\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a2\3\2\2\2\u01a7\u01a8"+
		"\3\2\2\2\u01a8\u01b8\3\2\2\2\u01a9\u01b3\7\t\2\2\u01aa\u01af\7\26\2\2"+
		"\u01ab\u01af\7\27\2\2\u01ac\u01af\7\34\2\2\u01ad\u01af\7\35\2\2\u01ae"+
		"\u01aa\3\2\2\2\u01ae\u01ab\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01ad\3\2"+
		"\2\2\u01af\u01b1\3\2\2\2\u01b0\u01b2\7\16\2\2\u01b1\u01b0\3\2\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01ae\3\2\2\2\u01b4\u01b5\3\2"+
		"\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01b9\7\n\2\2\u01b8\u01a9\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01c2\3\2"+
		"\2\2\u01ba\u01be\7\t\2\2\u01bb\u01bd\5\"\22\2\u01bc\u01bb\3\2\2\2\u01bd"+
		"\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c1\3\2"+
		"\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c3\7\n\2\2\u01c2\u01ba\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\25\3\2\2\2\u01c4\u01c7\5\34\17\2\u01c5\u01c7\5> "+
		"\2\u01c6\u01c4\3\2\2\2\u01c6\u01c5\3\2\2\2\u01c7\27\3\2\2\2\u01c8\u01cf"+
		"\7/\2\2\u01c9\u01cc\5D#\2\u01ca\u01cb\7\60\2\2\u01cb\u01cd\5B\"\2\u01cc"+
		"\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01d0\t\2"+
		"\2\2\u01cf\u01c9\3\2\2\2\u01cf\u01ce\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1"+
		"\u01d4\7\64\2\2\u01d2\u01d4\7\65\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d2\3"+
		"\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\7\66\2\2\u01d6"+
		"\31\3\2\2\2\u01d7\u01d9\7\67\2\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2"+
		"\2\u01d9\u01da\3\2\2\2\u01da\u01db\78\2\2\u01db\u01dd\5@!\2\u01dc\u01de"+
		"\5.\30\2\u01dd\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e1\3\2\2\2\u01df"+
		"\u01e0\7\5\2\2\u01e0\u01e2\7T\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2"+
		"\2\2\u01e2\u01e9\3\2\2\2\u01e3\u01e6\7\t\2\2\u01e4\u01e7\79\2\2\u01e5"+
		"\u01e7\7:\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3\2"+
		"\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\7\n\2\2\u01e9\u01e3\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01f7\3\2\2\2\u01eb\u01ec\7\t\2\2\u01ec\u01f5\5\""+
		"\22\2\u01ed\u01ef\5\62\32\2\u01ee\u01ed\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0"+
		"\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2\u01f0\3\2"+
		"\2\2\u01f3\u01f5\7\n\2\2\u01f4\u01eb\3\2\2\2\u01f4\u01f0\3\2\2\2\u01f5"+
		"\u01f8\3\2\2\2\u01f6\u01f8\7\6\2\2\u01f7\u01f4\3\2\2\2\u01f7\u01f6\3\2"+
		"\2\2\u01f8\33\3\2\2\2\u01f9\u01fa\t\3\2\2\u01fa\35\3\2\2\2\u01fb\u01fd"+
		"\58\35\2\u01fc\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe"+
		"\u01ff\7@\2\2\u01ff\u0201\5@!\2\u0200\u0202\5.\30\2\u0201\u0200\3\2\2"+
		"\2\u0201\u0202\3\2\2\2\u0202\u0205\3\2\2\2\u0203\u0204\7\5\2\2\u0204\u0206"+
		"\7T\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u020d\3\2\2\2\u0207"+
		"\u020a\7\t\2\2\u0208\u020b\79\2\2\u0209\u020b\7:\2\2\u020a\u0208\3\2\2"+
		"\2\u020a\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020e"+
		"\7\n\2\2\u020d\u0207\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u021a\3\2\2\2\u020f"+
		"\u0215\7\t\2\2\u0210\u0214\5\"\22\2\u0211\u0214\5 \21\2\u0212\u0214\5"+
		"\62\32\2\u0213\u0210\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0212\3\2\2\2\u0214"+
		"\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218\3\2"+
		"\2\2\u0217\u0215\3\2\2\2\u0218\u021b\7\n\2\2\u0219\u021b\7\6\2\2\u021a"+
		"\u020f\3\2\2\2\u021a\u0219\3\2\2\2\u021b\37\3\2\2\2\u021c\u021d\7A\2\2"+
		"\u021d\u0220\5@!\2\u021e\u0220\5@!\2\u021f\u021c\3\2\2\2\u021f\u021e\3"+
		"\2\2\2\u0220\u0223\3\2\2\2\u0221\u0222\7\b\2\2\u0222\u0224\5F$\2\u0223"+
		"\u0221\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u022e\3\2\2\2\u0225\u0229\7\t"+
		"\2\2\u0226\u0228\5\"\22\2\u0227\u0226\3\2\2\2\u0228\u022b\3\2\2\2\u0229"+
		"\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022c\3\2\2\2\u022b\u0229\3\2"+
		"\2\2\u022c\u022f\7\n\2\2\u022d\u022f\7\6\2\2\u022e\u0225\3\2\2\2\u022e"+
		"\u022d\3\2\2\2\u022f!\3\2\2\2\u0230\u0232\7B\2\2\u0231\u0233\7T\2\2\u0232"+
		"\u0231\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u023f\3\2\2\2\u0234\u0235\7,"+
		"\2\2\u0235\u023a\5$\23\2\u0236\u0237\7\16\2\2\u0237\u0239\5$\23\2\u0238"+
		"\u0236\3\2\2\2\u0239\u023c\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2"+
		"\2\2\u023b\u023d\3\2\2\2\u023c\u023a\3\2\2\2\u023d\u023e\7-\2\2\u023e"+
		"\u0240\3\2\2\2\u023f\u0234\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u024c\3\2"+
		"\2\2\u0241\u0245\7\t\2\2\u0242\u0246\5\"\22\2\u0243\u0246\5&\24\2\u0244"+
		"\u0246\5,\27\2\u0245\u0242\3\2\2\2\u0245\u0243\3\2\2\2\u0245\u0244\3\2"+
		"\2\2\u0246\u0247\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2\2\2\u0248"+
		"\u0249\3\2\2\2\u0249\u024a\7\n\2\2\u024a\u024d\3\2\2\2\u024b\u024d\7\6"+
		"\2\2\u024c\u0241\3\2\2\2\u024c\u024b\3\2\2\2\u024d#\3\2\2\2\u024e\u024f"+
		"\7T\2\2\u024f\u0250\7\b\2\2\u0250\u0251\t\4\2\2\u0251%\3\2\2\2\u0252\u0255"+
		"\5\b\5\2\u0253\u0255\5(\25\2\u0254\u0252\3\2\2\2\u0254\u0253\3\2\2\2\u0255"+
		"\'\3\2\2\2\u0256\u0259\5*\26\2\u0257\u0259\5 \21\2\u0258\u0256\3\2\2\2"+
		"\u0258\u0257\3\2\2\2\u0259)\3\2\2\2\u025a\u025e\5\22\n\2\u025b\u025e\5"+
		"\24\13\2\u025c\u025e\5\f\7\2\u025d\u025a\3\2\2\2\u025d\u025b\3\2\2\2\u025d"+
		"\u025c\3\2\2\2\u025e+\3\2\2\2\u025f\u0260\7C\2\2\u0260\u0261\5> \2\u0261"+
		"\u0262\7\6\2\2\u0262-\3\2\2\2\u0263\u0264\7,\2\2\u0264\u0269\5@!\2\u0265"+
		"\u0266\7\16\2\2\u0266\u0268\5@!\2\u0267\u0265\3\2\2\2\u0268\u026b\3\2"+
		"\2\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026c\3\2\2\2\u026b"+
		"\u0269\3\2\2\2\u026c\u026d\7-\2\2\u026d\u027a\3\2\2\2\u026e\u026f\7D\2"+
		"\2\u026f\u0274\5@!\2\u0270\u0271\7\16\2\2\u0271\u0273\5@!\2\u0272\u0270"+
		"\3\2\2\2\u0273\u0276\3\2\2\2\u0274\u0272\3\2\2\2\u0274\u0275\3\2\2\2\u0275"+
		"\u0277\3\2\2\2\u0276\u0274\3\2\2\2\u0277\u0278\7E\2\2\u0278\u027a\3\2"+
		"\2\2\u0279\u0263\3\2\2\2\u0279\u026e\3\2\2\2\u027a/\3\2\2\2\u027b\u027d"+
		"\7F\2\2\u027c\u027e\5@!\2\u027d\u027c\3\2\2\2\u027d\u027e\3\2\2\2\u027e"+
		"\u0285\3\2\2\2\u027f\u0281\7\5\2\2\u0280\u0282\5:\36\2\u0281\u0280\3\2"+
		"\2\2\u0281\u0282\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0286\7\6\2\2\u0284"+
		"\u0286\7\6\2\2\u0285\u027f\3\2\2\2\u0285\u0284\3\2\2\2\u0286\61\3\2\2"+
		"\2\u0287\u0289\7G\2\2\u0288\u0287\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a"+
		"\3\2\2\2\u028a\u0291\7H\2\2\u028b\u028f\5@!\2\u028c\u028d\7,\2\2\u028d"+
		"\u028e\7S\2\2\u028e\u0290\7-\2\2\u028f\u028c\3\2\2\2\u028f\u0290\3\2\2"+
		"\2\u0290\u0292\3\2\2\2\u0291\u028b\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0299"+
		"\3\2\2\2\u0293\u0295\7\5\2\2\u0294\u0296\5<\37\2\u0295\u0294\3\2\2\2\u0295"+
		"\u0296\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u029a\7\6\2\2\u0298\u029a\7\6"+
		"\2\2\u0299\u0293\3\2\2\2\u0299\u0298\3\2\2\2\u029a\63\3\2\2\2\u029b\u02a2"+
		"\7I\2\2\u029c\u02a0\5@!\2\u029d\u029e\7,\2\2\u029e\u029f\7S\2\2\u029f"+
		"\u02a1\7-\2\2\u02a0\u029d\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a3\3\2"+
		"\2\2\u02a2\u029c\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02aa\3\2\2\2\u02a4"+
		"\u02a6\7\5\2\2\u02a5\u02a7\5<\37\2\u02a6\u02a5\3\2\2\2\u02a6\u02a7\3\2"+
		"\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02ab\7\6\2\2\u02a9\u02ab\7\6\2\2\u02aa"+
		"\u02a4\3\2\2\2\u02aa\u02a9\3\2\2\2\u02ab\65\3\2\2\2\u02ac\u02b3\7J\2\2"+
		"\u02ad\u02b1\5@!\2\u02ae\u02af\7,\2\2\u02af\u02b0\7S\2\2\u02b0\u02b2\7"+
		"-\2\2\u02b1\u02ae\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b4\3\2\2\2\u02b3"+
		"\u02ad\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02bb\3\2\2\2\u02b5\u02b7\7\5"+
		"\2\2\u02b6\u02b8\5<\37\2\u02b7\u02b6\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8"+
		"\u02b9\3\2\2\2\u02b9\u02bc\7\6\2\2\u02ba\u02bc\7\6\2\2\u02bb\u02b5\3\2"+
		"\2\2\u02bb\u02ba\3\2\2\2\u02bc\67\3\2\2\2\u02bd\u02be\t\5\2\2\u02be9\3"+
		"\2\2\2\u02bf\u02c0\7N\2\2\u02c0;\3\2\2\2\u02c1\u02c2\7N\2\2\u02c2=\3\2"+
		"\2\2\u02c3\u02cd\5@!\2\u02c4\u02c5\7O\2\2\u02c5\u02c7\5@!\2\u02c6\u02c4"+
		"\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9"+
		"\u02cb\3\2\2\2\u02ca\u02c8\3\2\2\2\u02cb\u02cc\7O\2\2\u02cc\u02ce\5@!"+
		"\2\u02cd\u02c8\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce?\3\2\2\2\u02cf\u02d0"+
		"\7R\2\2\u02d0A\3\2\2\2\u02d1\u02d2\t\6\2\2\u02d2C\3\2\2\2\u02d3\u02d4"+
		"\7Q\2\2\u02d4E\3\2\2\2\u02d5\u02d7\7P\2\2\u02d6\u02d5\3\2\2\2\u02d6\u02d7"+
		"\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d9\7Q\2\2\u02d9G\3\2\2\2\u0086J"+
		"OU\\bqsx}\u0080\u0083\u008d\u0090\u0094\u0098\u009b\u00a2\u00a4\u00a9"+
		"\u00ad\u00b0\u00b3\u00b9\u00be\u00c0\u00d3\u00d6\u00da\u00dd\u00e3\u00e7"+
		"\u00ec\u00f0\u00f3\u00f5\u00fa\u00fd\u0100\u0106\u010b\u010d\u0111\u0126"+
		"\u0129\u012d\u0130\u013a\u0141\u0145\u014a\u014e\u0151\u0153\u0158\u015b"+
		"\u015e\u0168\u016b\u0171\u0173\u017b\u017e\u0187\u018a\u018e\u0191\u0198"+
		"\u019a\u019f\u01a5\u01a7\u01ae\u01b1\u01b5\u01b8\u01be\u01c2\u01c6\u01cc"+
		"\u01cf\u01d3\u01d8\u01dd\u01e1\u01e6\u01e9\u01f0\u01f4\u01f7\u01fc\u0201"+
		"\u0205\u020a\u020d\u0213\u0215\u021a\u021f\u0223\u0229\u022e\u0232\u023a"+
		"\u023f\u0245\u0247\u024c\u0254\u0258\u025d\u0269\u0274\u0279\u027d\u0281"+
		"\u0285\u0288\u028f\u0291\u0295\u0299\u02a0\u02a2\u02a6\u02aa\u02b1\u02b3"+
		"\u02b7\u02bb\u02c8\u02cd\u02d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}