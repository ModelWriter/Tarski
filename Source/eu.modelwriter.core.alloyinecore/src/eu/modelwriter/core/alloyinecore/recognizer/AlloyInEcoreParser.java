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
		T__73=74, INT=75, IDENTIFIER=76, DOUBLE_QUOTED_STRING=77, SINGLE_QUOTED_STRING=78, 
		MULTILINE_COMMENT=79, SINGLELINE_COMMENT=80, WS=81;
	public static final int
		RULE_module = 0, RULE_packageImport = 1, RULE_ePackage = 2, RULE_eClassifier = 3, 
		RULE_eClass = 4, RULE_eStructuralFeature = 5, RULE_eAttribute = 6, RULE_eReference = 7, 
		RULE_eOperation = 8, RULE_eParameter = 9, RULE_eType = 10, RULE_eMultiplicity = 11, 
		RULE_eDataType = 12, RULE_ePrimitiveType = 13, RULE_eEnum = 14, RULE_eEnumLiteral = 15, 
		RULE_templateSignature = 16, RULE_body = 17, RULE_invariant = 18, RULE_precondition = 19, 
		RULE_postcondition = 20, RULE_expression = 21, RULE_constraint = 22, RULE_visibilityKind = 23, 
		RULE_qualifiedName = 24, RULE_identifier = 25, RULE_upper = 26, RULE_lower = 27, 
		RULE_signed = 28;
	public static final String[] ruleNames = {
		"module", "packageImport", "ePackage", "eClassifier", "eClass", "eStructuralFeature", 
		"eAttribute", "eReference", "eOperation", "eParameter", "eType", "eMultiplicity", 
		"eDataType", "ePrimitiveType", "eEnum", "eEnumLiteral", "templateSignature", 
		"body", "invariant", "precondition", "postcondition", "expression", "constraint", 
		"visibilityKind", "qualifiedName", "identifier", "upper", "lower", "signed"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'module'", "'import'", "':'", "';'", "'package'", "'='", "'{'", 
		"'}'", "'abstract'", "'class'", "'extends'", "','", "'interface'", "'static'", 
		"'attribute'", "'derived'", "'!derived'", "'id'", "'!id'", "'ordered'", 
		"'!ordered'", "'readonly'", "'!readonly'", "'transient'", "'!transient'", 
		"'unique'", "'!unique'", "'unsettable'", "'!unsettable'", "'volatile'", 
		"'!volatile'", "'initial'", "'derivation'", "'property'", "'#'", "'composes'", 
		"'!composes'", "'resolve'", "'!resolve'", "'key'", "'operation'", "'('", 
		"')'", "'throws'", "'['", "'..'", "'*'", "'+'", "'?'", "']'", "'primitive'", 
		"'datatype'", "'serializable'", "'!serializable'", "'Boolean'", "'Integer'", 
		"'String'", "'Real'", "'UnlimitedNatural'", "'enum'", "'literal'", "'<'", 
		"'>'", "'body'", "'callable'", "'invariant'", "'precondition'", "'postcondition'", 
		"'expr'", "'public'", "'protected'", "'private'", "'::'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", 
		"MULTILINE_COMMENT", "SINGLELINE_COMMENT", "WS"
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


	    public java.util.List<String> ePackageNames = new java.util.ArrayList<String>();
	    public java.util.Map<String, org.eclipse.emf.ecore.EPackage> ePackages = new java.util.HashMap<String, org.eclipse.emf.ecore.EPackage>();
	    public java.util.List<String> eClassNames = new java.util.ArrayList<String>();
	    public java.util.Map<String, org.eclipse.emf.ecore.EClass> eClasses = new java.util.HashMap<String, org.eclipse.emf.ecore.EClass>();
	    org.eclipse.emf.ecore.EcoreFactory _eCoreFactory = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE;
	    org.eclipse.emf.ecore.EcorePackage _eCorePackage = org.eclipse.emf.ecore.EcorePackage.eINSTANCE;

	    private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}

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
			setState(60);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(58);
				match(T__0);
				setState(59);
				identifier();
				}
			}

			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(62);
				((ModuleContext)_localctx).packageImport = packageImport();
				((ModuleContext)_localctx).ownedPackageImport.add(((ModuleContext)_localctx).packageImport);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				{
				setState(68);
				((ModuleContext)_localctx).ePackage = ePackage();
				((ModuleContext)_localctx).ownedPackage.add(((ModuleContext)_localctx).ePackage);
				}
				}
				setState(73);
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
			setState(74);
			match(T__1);
			}
			setState(78);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(75);
				((PackageImportContext)_localctx).name = identifier();
				setState(76);
				match(T__2);
				}
			}

			setState(80);
			((PackageImportContext)_localctx).ownedPathName = match(SINGLE_QUOTED_STRING);
			setState(81);
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
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(83);
				((EPackageContext)_localctx).visibility = visibilityKind();
				}
				break;
			}
			setState(86);
			match(T__4);
			setState(87);
			((EPackageContext)_localctx).name = identifier();
			{
			setState(88);
			match(T__2);
			setState(89);
			((EPackageContext)_localctx).nsPrefix = identifier();
			}
			{
			setState(91);
			match(T__5);
			setState(92);
			((EPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			}
			setState(105);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(94);
				match(T__6);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__50) | (1L << T__51) | (1L << T__59))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__65 - 65)) | (1L << (T__69 - 65)) | (1L << (T__70 - 65)) | (1L << (T__71 - 65)))) != 0)) {
					{
					setState(98);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(95);
						((EPackageContext)_localctx).ePackage = ePackage();
						((EPackageContext)_localctx).eSubPackages.add(((EPackageContext)_localctx).ePackage);
						}
						break;
					case 2:
						{
						setState(96);
						((EPackageContext)_localctx).eClassifier = eClassifier();
						((EPackageContext)_localctx).eClassifiers.add(((EPackageContext)_localctx).eClassifier);
						}
						break;
					case 3:
						{
						setState(97);
						((EPackageContext)_localctx).invariant = invariant();
						((EPackageContext)_localctx).eConstraints.add(((EPackageContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(103);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(104);
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
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				eClass();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				eDataType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
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
			setState(113);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(112);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(116);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(115);
				((EClassContext)_localctx).isAbstract = match(T__8);
				}
			}

			setState(118);
			match(T__9);
			setState(119);
			((EClassContext)_localctx).name = identifier();
			setState(129);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(120);
				match(T__10);
				setState(121);
				((EClassContext)_localctx).qualifiedName = qualifiedName();
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(122);
					match(T__11);
					setState(123);
					((EClassContext)_localctx).qualifiedName = qualifiedName();
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(133);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(131);
				match(T__2);
				setState(132);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(135);
				match(T__6);
				setState(137);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(136);
					((EClassContext)_localctx).isInterface = match(T__12);
					}
				}

				setState(139);
				match(T__7);
				}
				break;
			}
			setState(153);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(142);
				match(T__6);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__13) | (1L << T__14) | (1L << T__33) | (1L << T__40))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__65 - 65)) | (1L << (T__69 - 65)) | (1L << (T__70 - 65)) | (1L << (T__71 - 65)))) != 0)) {
					{
					setState(146);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(143);
						((EClassContext)_localctx).eOperation = eOperation();
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						}
						break;
					case 2:
						{
						setState(144);
						((EClassContext)_localctx).eStructuralFeature = eStructuralFeature();
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						}
						break;
					case 3:
						{
						setState(145);
						((EClassContext)_localctx).invariant = invariant();
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariant);
						}
						break;
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(152);
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
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				eAttribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
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
			setState(160);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(159);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(163);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(162);
				((EAttributeContext)_localctx).s14 = match(T__13);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s14);
				}
			}

			setState(165);
			match(T__14);
			setState(166);
			((EAttributeContext)_localctx).name = identifier();
			setState(169);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(167);
				match(T__5);
				setState(168);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(176);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(171);
				match(T__2);
				setState(172);
				((EAttributeContext)_localctx).eAttributeType = eType();
				setState(174);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(173);
					((EAttributeContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(178);
				match(T__6);
				setState(200); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(195);
					switch (_input.LA(1)) {
					case T__15:
						{
						setState(179);
						((EAttributeContext)_localctx).s16 = match(T__15);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(180);
						((EAttributeContext)_localctx).s17 = match(T__16);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s17);
						}
						break;
					case T__17:
						{
						setState(181);
						((EAttributeContext)_localctx).s18 = match(T__17);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s18);
						}
						break;
					case T__18:
						{
						setState(182);
						((EAttributeContext)_localctx).s19 = match(T__18);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s19);
						}
						break;
					case T__19:
						{
						setState(183);
						((EAttributeContext)_localctx).s20 = match(T__19);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(184);
						((EAttributeContext)_localctx).s21 = match(T__20);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s21);
						}
						break;
					case T__21:
						{
						setState(185);
						((EAttributeContext)_localctx).s22 = match(T__21);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s22);
						}
						break;
					case T__22:
						{
						setState(186);
						((EAttributeContext)_localctx).s23 = match(T__22);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s23);
						}
						break;
					case T__23:
						{
						setState(187);
						((EAttributeContext)_localctx).s24 = match(T__23);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s24);
						}
						break;
					case T__24:
						{
						setState(188);
						((EAttributeContext)_localctx).s25 = match(T__24);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s25);
						}
						break;
					case T__25:
						{
						setState(189);
						((EAttributeContext)_localctx).s26 = match(T__25);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(190);
						((EAttributeContext)_localctx).s27 = match(T__26);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
						}
						break;
					case T__27:
						{
						setState(191);
						((EAttributeContext)_localctx).s28 = match(T__27);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(192);
						((EAttributeContext)_localctx).s29 = match(T__28);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(193);
						((EAttributeContext)_localctx).s30 = match(T__29);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(194);
						((EAttributeContext)_localctx).s31 = match(T__30);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(198);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(197);
						match(T__11);
						}
					}

					}
					}
					setState(202); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0) );
				setState(204);
				match(T__7);
				}
				break;
			}
			setState(233);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(207);
				match(T__6);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__31 || _la==T__32) {
					{
					setState(226);
					switch (_input.LA(1)) {
					case T__31:
						{
						{
						setState(208);
						match(T__31);
						setState(210);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(209);
							identifier();
							}
						}

						setState(212);
						match(T__2);
						setState(214);
						_la = _input.LA(1);
						if (_la==T__68) {
							{
							setState(213);
							((EAttributeContext)_localctx).ownedInitialExpression = expression();
							}
						}

						setState(216);
						match(T__3);
						}
						}
						break;
					case T__32:
						{
						{
						setState(217);
						match(T__32);
						setState(219);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(218);
							identifier();
							}
						}

						setState(221);
						match(T__2);
						setState(223);
						_la = _input.LA(1);
						if (_la==T__68) {
							{
							setState(222);
							((EAttributeContext)_localctx).ownedDerivedExpression = expression();
							}
						}

						setState(225);
						match(T__3);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(231);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(232);
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
			setState(236);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(235);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(239);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(238);
				((EReferenceContext)_localctx).s14 = match(T__13);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s14);
				}
			}

			setState(241);
			match(T__33);
			setState(242);
			((EReferenceContext)_localctx).name = identifier();
			setState(245);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(243);
				match(T__34);
				setState(244);
				((EReferenceContext)_localctx).opposite = identifier();
				}
			}

			setState(252);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(247);
				match(T__2);
				setState(248);
				((EReferenceContext)_localctx).eReferenceType = eType();
				setState(250);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(249);
					((EReferenceContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(256);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(254);
				match(T__5);
				setState(255);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(258);
				match(T__6);
				setState(282); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(277);
					switch (_input.LA(1)) {
					case T__35:
						{
						setState(259);
						((EReferenceContext)_localctx).s36 = match(T__35);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(260);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__15:
						{
						setState(261);
						((EReferenceContext)_localctx).s16 = match(T__15);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(262);
						((EReferenceContext)_localctx).s17 = match(T__16);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s17);
						}
						break;
					case T__19:
						{
						setState(263);
						((EReferenceContext)_localctx).s20 = match(T__19);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(264);
						((EReferenceContext)_localctx).s21 = match(T__20);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s21);
						}
						break;
					case T__21:
						{
						setState(265);
						((EReferenceContext)_localctx).s22 = match(T__21);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s22);
						}
						break;
					case T__22:
						{
						setState(266);
						((EReferenceContext)_localctx).s23 = match(T__22);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s23);
						}
						break;
					case T__37:
						{
						setState(267);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(268);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__23:
						{
						setState(269);
						((EReferenceContext)_localctx).s24 = match(T__23);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s24);
						}
						break;
					case T__24:
						{
						setState(270);
						((EReferenceContext)_localctx).s25 = match(T__24);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s25);
						}
						break;
					case T__25:
						{
						setState(271);
						((EReferenceContext)_localctx).s26 = match(T__25);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(272);
						((EReferenceContext)_localctx).s27 = match(T__26);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
						}
						break;
					case T__27:
						{
						setState(273);
						((EReferenceContext)_localctx).s28 = match(T__27);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(274);
						((EReferenceContext)_localctx).s29 = match(T__28);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(275);
						((EReferenceContext)_localctx).s30 = match(T__29);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(276);
						((EReferenceContext)_localctx).s31 = match(T__30);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(280);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(279);
						match(T__11);
						}
					}

					}
					}
					setState(284); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0) );
				setState(286);
				match(T__7);
				}
				break;
			}
			setState(326);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(289);
				match(T__6);
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__39))) != 0)) {
					{
					setState(319);
					switch (_input.LA(1)) {
					case T__39:
						{
						{
						setState(290);
						match(T__39);
						setState(291);
						((EReferenceContext)_localctx).qualifiedName = qualifiedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
						setState(296);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__11) {
							{
							{
							setState(292);
							match(T__11);
							setState(293);
							((EReferenceContext)_localctx).qualifiedName = qualifiedName();
							((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
							}
							}
							setState(298);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(299);
						match(T__3);
						}
						}
						break;
					case T__31:
						{
						{
						setState(301);
						match(T__31);
						setState(303);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(302);
							identifier();
							}
						}

						setState(305);
						match(T__2);
						setState(307);
						_la = _input.LA(1);
						if (_la==T__68) {
							{
							setState(306);
							((EReferenceContext)_localctx).expression = expression();
							((EReferenceContext)_localctx).ownedInitialExpression.add(((EReferenceContext)_localctx).expression);
							}
						}

						setState(309);
						match(T__3);
						}
						}
						break;
					case T__32:
						{
						{
						setState(310);
						match(T__32);
						setState(312);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(311);
							identifier();
							}
						}

						setState(314);
						match(T__2);
						setState(316);
						_la = _input.LA(1);
						if (_la==T__68) {
							{
							setState(315);
							((EReferenceContext)_localctx).expression = expression();
							((EReferenceContext)_localctx).ownedDerivedExpression.add(((EReferenceContext)_localctx).expression);
							}
						}

						setState(318);
						match(T__3);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(324);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(325);
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
			setState(329);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(328);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(332);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(331);
				((EOperationContext)_localctx).s14 = match(T__13);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s14);
				}
			}

			setState(334);
			match(T__40);
			setState(335);
			((EOperationContext)_localctx).name = identifier();
			setState(336);
			match(T__41);
			setState(345);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(337);
				((EOperationContext)_localctx).eParameter = eParameter();
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(338);
					match(T__11);
					setState(339);
					((EOperationContext)_localctx).eParameter = eParameter();
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(347);
			match(T__42);
			setState(353);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(348);
				match(T__2);
				setState(349);
				((EOperationContext)_localctx).returnType = eType();
				setState(351);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(350);
					((EOperationContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(364);
			_la = _input.LA(1);
			if (_la==T__43) {
				{
				setState(355);
				match(T__43);
				setState(356);
				((EOperationContext)_localctx).identifier = identifier();
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(357);
					match(T__11);
					setState(358);
					((EOperationContext)_localctx).identifier = identifier();
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
					}
					}
					setState(363);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(366);
				match(T__6);
				setState(378); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(373);
					switch (_input.LA(1)) {
					case T__15:
						{
						setState(367);
						((EOperationContext)_localctx).s16 = match(T__15);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(368);
						((EOperationContext)_localctx).s17 = match(T__16);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s17);
						}
						break;
					case T__19:
						{
						setState(369);
						((EOperationContext)_localctx).s20 = match(T__19);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(370);
						((EOperationContext)_localctx).s21 = match(T__20);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s21);
						}
						break;
					case T__25:
						{
						setState(371);
						((EOperationContext)_localctx).s26 = match(T__25);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(372);
						((EOperationContext)_localctx).s27 = match(T__26);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s27);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(376);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(375);
						match(T__11);
						}
					}

					}
					}
					setState(380); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__26))) != 0) );
				setState(382);
				match(T__7);
				}
				break;
			}
			setState(396);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(385);
				match(T__6);
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)))) != 0)) {
					{
					setState(389);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(386);
						((EOperationContext)_localctx).precondition = precondition();
						((EOperationContext)_localctx).ownedPreconditions.add(((EOperationContext)_localctx).precondition);
						}
						break;
					case T__63:
						{
						setState(387);
						((EOperationContext)_localctx).body = body();
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).body);
						}
						break;
					case T__67:
						{
						setState(388);
						((EOperationContext)_localctx).postcondition = postcondition();
						((EOperationContext)_localctx).ownedPostconditions.add(((EOperationContext)_localctx).postcondition);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(393);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(394);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(395);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ETypeContext eType() {
			return getRuleContext(ETypeContext.class,0);
		}
		public EMultiplicityContext eMultiplicity() {
			return getRuleContext(EMultiplicityContext.class,0);
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
			setState(398);
			((EParameterContext)_localctx).name = identifier();
			setState(404);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(399);
				match(T__2);
				setState(400);
				((EParameterContext)_localctx).ownedType = eType();
				setState(402);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(401);
					((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(421);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(406);
				match(T__6);
				setState(416); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(411);
					switch (_input.LA(1)) {
					case T__19:
						{
						setState(407);
						((EParameterContext)_localctx).s20 = match(T__19);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(408);
						((EParameterContext)_localctx).s21 = match(T__20);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s21);
						}
						break;
					case T__25:
						{
						setState(409);
						((EParameterContext)_localctx).s26 = match(T__25);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(410);
						((EParameterContext)_localctx).s27 = match(T__26);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s27);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(414);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(413);
						match(T__11);
						}
					}

					}
					}
					setState(418); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__26))) != 0) );
				setState(420);
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
			setState(425);
			switch (_input.LA(1)) {
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				ePrimitiveType();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
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
			setState(427);
			match(T__44);
			setState(434);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(428);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(431);
				_la = _input.LA(1);
				if (_la==T__45) {
					{
					setState(429);
					match(T__45);
					setState(430);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__46:
			case T__47:
			case T__48:
				{
				setState(433);
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
			setState(436);
			match(T__49);
			}
		}
		catch (RecognitionException re) {
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
		public InvariantContext invariant;
		public List<InvariantContext> ownedConstraints = new ArrayList<InvariantContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
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
			setState(439);
			_la = _input.LA(1);
			if (_la==T__50) {
				{
				setState(438);
				((EDataTypeContext)_localctx).isPrimitive = match(T__50);
				}
			}

			setState(441);
			match(T__51);
			setState(442);
			((EDataTypeContext)_localctx).name = identifier();
			setState(444);
			_la = _input.LA(1);
			if (_la==T__41 || _la==T__61) {
				{
				setState(443);
				((EDataTypeContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(448);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(446);
				match(T__2);
				setState(447);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				{
				setState(450);
				match(T__6);
				setState(453);
				switch (_input.LA(1)) {
				case T__52:
					{
					setState(451);
					((EDataTypeContext)_localctx).isSerializable = match(T__52);
					}
					break;
				case T__53:
					{
					setState(452);
					match(T__53);
					}
					break;
				case T__7:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(455);
				match(T__7);
				}
				break;
			}
			setState(467);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(458);
				match(T__6);
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__64 || _la==T__65) {
					{
					{
					setState(459);
					((EDataTypeContext)_localctx).invariant = invariant();
					((EDataTypeContext)_localctx).ownedConstraints.add(((EDataTypeContext)_localctx).invariant);
					}
					}
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(465);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(466);
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
			setState(469);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0)) ) {
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
			setState(472);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(471);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(474);
			match(T__59);
			setState(475);
			((EEnumContext)_localctx).name = identifier();
			setState(477);
			_la = _input.LA(1);
			if (_la==T__41 || _la==T__61) {
				{
				setState(476);
				((EEnumContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(481);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(479);
				match(T__2);
				setState(480);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(483);
				match(T__6);
				setState(486);
				switch (_input.LA(1)) {
				case T__52:
					{
					setState(484);
					((EEnumContext)_localctx).isSerializable = match(T__52);
					}
					break;
				case T__53:
					{
					setState(485);
					match(T__53);
					}
					break;
				case T__7:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(488);
				match(T__7);
				}
				break;
			}
			setState(501);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(491);
				match(T__6);
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (T__60 - 61)) | (1L << (T__64 - 61)) | (1L << (T__65 - 61)) | (1L << (IDENTIFIER - 61)))) != 0)) {
					{
					setState(494);
					switch (_input.LA(1)) {
					case T__60:
					case IDENTIFIER:
						{
						setState(492);
						((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral();
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						}
						break;
					case T__64:
					case T__65:
						{
						setState(493);
						((EEnumContext)_localctx).invariant = invariant();
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariant);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(498);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(499);
				match(T__7);
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

	public static class EEnumLiteralContext extends ParserRuleContext {
		public IdentifierContext name;
		public SignedContext value;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SignedContext signed() {
			return getRuleContext(SignedContext.class,0);
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
			setState(506);
			switch (_input.LA(1)) {
			case T__60:
				{
				{
				setState(503);
				match(T__60);
				setState(504);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				}
				break;
			case IDENTIFIER:
				{
				setState(505);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(510);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(508);
				match(T__5);
				setState(509);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}

			setState(512);
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
		enterRule(_localctx, 32, RULE_templateSignature);
		int _la;
		try {
			setState(536);
			switch (_input.LA(1)) {
			case T__41:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(514);
				match(T__41);
				setState(515);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(516);
					match(T__11);
					setState(517);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(522);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(523);
				match(T__42);
				}
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(525);
				match(T__61);
				setState(526);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(527);
					match(T__11);
					setState(528);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(533);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(534);
				match(T__62);
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
		enterRule(_localctx, 34, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			((BodyContext)_localctx).stereotype = match(T__63);
			setState(540);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(539);
				((BodyContext)_localctx).name = identifier();
				}
			}

			setState(548);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(542);
				match(T__2);
				setState(544);
				_la = _input.LA(1);
				if (_la==T__68) {
					{
					setState(543);
					((BodyContext)_localctx).ownedExpression = expression();
					}
				}

				setState(546);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(547);
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
		public ConstraintContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
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
		enterRule(_localctx, 36, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			_la = _input.LA(1);
			if (_la==T__64) {
				{
				setState(550);
				((InvariantContext)_localctx).isCallable = match(T__64);
				}
			}

			setState(553);
			((InvariantContext)_localctx).stereotype = match(T__65);
			setState(560);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(554);
				((InvariantContext)_localctx).name = identifier();
				setState(558);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(555);
					match(T__41);
					setState(556);
					((InvariantContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(557);
					match(T__42);
					}
				}

				}
			}

			setState(568);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(562);
				match(T__2);
				setState(564);
				_la = _input.LA(1);
				if (_la==T__68) {
					{
					setState(563);
					((InvariantContext)_localctx).ownedSpecification = constraint();
					}
				}

				setState(566);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(567);
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
		public ConstraintContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
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
		enterRule(_localctx, 38, RULE_precondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			((PreconditionContext)_localctx).stereotype = match(T__66);
			setState(577);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(571);
				((PreconditionContext)_localctx).name = identifier();
				setState(575);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(572);
					match(T__41);
					setState(573);
					((PreconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(574);
					match(T__42);
					}
				}

				}
			}

			setState(585);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(579);
				match(T__2);
				setState(581);
				_la = _input.LA(1);
				if (_la==T__68) {
					{
					setState(580);
					((PreconditionContext)_localctx).ownedSpecification = constraint();
					}
				}

				setState(583);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(584);
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
		public ConstraintContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOUBLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.DOUBLE_QUOTED_STRING, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
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
		enterRule(_localctx, 40, RULE_postcondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			((PostconditionContext)_localctx).stereotype = match(T__67);
			setState(594);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(588);
				((PostconditionContext)_localctx).name = identifier();
				setState(592);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(589);
					match(T__41);
					setState(590);
					((PostconditionContext)_localctx).message = match(DOUBLE_QUOTED_STRING);
					setState(591);
					match(T__42);
					}
				}

				}
			}

			setState(602);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(596);
				match(T__2);
				setState(598);
				_la = _input.LA(1);
				if (_la==T__68) {
					{
					setState(597);
					((PostconditionContext)_localctx).ownedSpecification = constraint();
					}
				}

				setState(600);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(601);
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
		enterRule(_localctx, 42, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			match(T__68);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			match(T__68);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_visibilityKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			_la = _input.LA(1);
			if ( !(_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) ) {
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> firstPart = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> midPart = new ArrayList<IdentifierContext>();
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
		enterRule(_localctx, 48, RULE_qualifiedName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			((QualifiedNameContext)_localctx).identifier = identifier();
			((QualifiedNameContext)_localctx).firstPart.add(((QualifiedNameContext)_localctx).identifier);
			setState(620);
			_la = _input.LA(1);
			if (_la==T__72) {
				{
				setState(615);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(611);
						match(T__72);
						setState(612);
						((QualifiedNameContext)_localctx).identifier = identifier();
						((QualifiedNameContext)_localctx).midPart.add(((QualifiedNameContext)_localctx).identifier);
						}
						} 
					}
					setState(617);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				}
				{
				setState(618);
				match(T__72);
				setState(619);
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
		enterRule(_localctx, 50, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
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
		enterRule(_localctx, 52, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
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
		enterRule(_localctx, 54, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
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
		enterRule(_localctx, 56, RULE_signed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			_la = _input.LA(1);
			if (_la==T__73) {
				{
				setState(628);
				match(T__73);
				}
			}

			setState(631);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3S\u027c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\5\2?\n\2\3"+
		"\2\7\2B\n\2\f\2\16\2E\13\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\3\3\3\3\3\3\3"+
		"\5\3Q\n\3\3\3\3\3\3\3\3\4\5\4W\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4e\n\4\f\4\16\4h\13\4\3\4\3\4\5\4l\n\4\3\5\3\5\3\5\5\5"+
		"q\n\5\3\6\5\6t\n\6\3\6\5\6w\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\177\n\6\f"+
		"\6\16\6\u0082\13\6\5\6\u0084\n\6\3\6\3\6\5\6\u0088\n\6\3\6\3\6\5\6\u008c"+
		"\n\6\3\6\5\6\u008f\n\6\3\6\3\6\3\6\3\6\7\6\u0095\n\6\f\6\16\6\u0098\13"+
		"\6\3\6\3\6\5\6\u009c\n\6\3\7\3\7\5\7\u00a0\n\7\3\b\5\b\u00a3\n\b\3\b\5"+
		"\b\u00a6\n\b\3\b\3\b\3\b\3\b\5\b\u00ac\n\b\3\b\3\b\3\b\5\b\u00b1\n\b\5"+
		"\b\u00b3\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u00c6\n\b\3\b\5\b\u00c9\n\b\6\b\u00cb\n\b\r\b\16\b\u00cc"+
		"\3\b\5\b\u00d0\n\b\3\b\3\b\3\b\5\b\u00d5\n\b\3\b\3\b\5\b\u00d9\n\b\3\b"+
		"\3\b\3\b\5\b\u00de\n\b\3\b\3\b\5\b\u00e2\n\b\3\b\7\b\u00e5\n\b\f\b\16"+
		"\b\u00e8\13\b\3\b\3\b\5\b\u00ec\n\b\3\t\5\t\u00ef\n\t\3\t\5\t\u00f2\n"+
		"\t\3\t\3\t\3\t\3\t\5\t\u00f8\n\t\3\t\3\t\3\t\5\t\u00fd\n\t\5\t\u00ff\n"+
		"\t\3\t\3\t\5\t\u0103\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0118\n\t\3\t\5\t\u011b\n\t\6\t\u011d"+
		"\n\t\r\t\16\t\u011e\3\t\5\t\u0122\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u0129\n"+
		"\t\f\t\16\t\u012c\13\t\3\t\3\t\3\t\3\t\5\t\u0132\n\t\3\t\3\t\5\t\u0136"+
		"\n\t\3\t\3\t\3\t\5\t\u013b\n\t\3\t\3\t\5\t\u013f\n\t\3\t\7\t\u0142\n\t"+
		"\f\t\16\t\u0145\13\t\3\t\3\t\5\t\u0149\n\t\3\n\5\n\u014c\n\n\3\n\5\n\u014f"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0157\n\n\f\n\16\n\u015a\13\n\5\n\u015c"+
		"\n\n\3\n\3\n\3\n\3\n\5\n\u0162\n\n\5\n\u0164\n\n\3\n\3\n\3\n\3\n\7\n\u016a"+
		"\n\n\f\n\16\n\u016d\13\n\5\n\u016f\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u0178\n\n\3\n\5\n\u017b\n\n\6\n\u017d\n\n\r\n\16\n\u017e\3\n\5\n\u0182"+
		"\n\n\3\n\3\n\3\n\3\n\7\n\u0188\n\n\f\n\16\n\u018b\13\n\3\n\3\n\5\n\u018f"+
		"\n\n\3\13\3\13\3\13\3\13\5\13\u0195\n\13\5\13\u0197\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u019e\n\13\3\13\5\13\u01a1\n\13\6\13\u01a3\n\13\r\13\16"+
		"\13\u01a4\3\13\5\13\u01a8\n\13\3\f\3\f\5\f\u01ac\n\f\3\r\3\r\3\r\3\r\5"+
		"\r\u01b2\n\r\3\r\5\r\u01b5\n\r\3\r\3\r\3\16\5\16\u01ba\n\16\3\16\3\16"+
		"\3\16\5\16\u01bf\n\16\3\16\3\16\5\16\u01c3\n\16\3\16\3\16\3\16\5\16\u01c8"+
		"\n\16\3\16\5\16\u01cb\n\16\3\16\3\16\7\16\u01cf\n\16\f\16\16\16\u01d2"+
		"\13\16\3\16\3\16\5\16\u01d6\n\16\3\17\3\17\3\20\5\20\u01db\n\20\3\20\3"+
		"\20\3\20\5\20\u01e0\n\20\3\20\3\20\5\20\u01e4\n\20\3\20\3\20\3\20\5\20"+
		"\u01e9\n\20\3\20\5\20\u01ec\n\20\3\20\3\20\3\20\7\20\u01f1\n\20\f\20\16"+
		"\20\u01f4\13\20\3\20\3\20\5\20\u01f8\n\20\3\21\3\21\3\21\5\21\u01fd\n"+
		"\21\3\21\3\21\5\21\u0201\n\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u0209"+
		"\n\22\f\22\16\22\u020c\13\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0214"+
		"\n\22\f\22\16\22\u0217\13\22\3\22\3\22\5\22\u021b\n\22\3\23\3\23\5\23"+
		"\u021f\n\23\3\23\3\23\5\23\u0223\n\23\3\23\3\23\5\23\u0227\n\23\3\24\5"+
		"\24\u022a\n\24\3\24\3\24\3\24\3\24\3\24\5\24\u0231\n\24\5\24\u0233\n\24"+
		"\3\24\3\24\5\24\u0237\n\24\3\24\3\24\5\24\u023b\n\24\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u0242\n\25\5\25\u0244\n\25\3\25\3\25\5\25\u0248\n\25\3\25"+
		"\3\25\5\25\u024c\n\25\3\26\3\26\3\26\3\26\3\26\5\26\u0253\n\26\5\26\u0255"+
		"\n\26\3\26\3\26\5\26\u0259\n\26\3\26\3\26\5\26\u025d\n\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\32\7\32\u0268\n\32\f\32\16\32\u026b\13"+
		"\32\3\32\3\32\5\32\u026f\n\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\5\36"+
		"\u0278\n\36\3\36\3\36\3\36\2\2\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:\2\6\3\2\61\63\3\29=\4\2\7\7HJ\4\2\61\61MM\u02fe"+
		"\2>\3\2\2\2\4L\3\2\2\2\6V\3\2\2\2\bp\3\2\2\2\ns\3\2\2\2\f\u009f\3\2\2"+
		"\2\16\u00a2\3\2\2\2\20\u00ee\3\2\2\2\22\u014b\3\2\2\2\24\u0190\3\2\2\2"+
		"\26\u01ab\3\2\2\2\30\u01ad\3\2\2\2\32\u01b9\3\2\2\2\34\u01d7\3\2\2\2\36"+
		"\u01da\3\2\2\2 \u01fc\3\2\2\2\"\u021a\3\2\2\2$\u021c\3\2\2\2&\u0229\3"+
		"\2\2\2(\u023c\3\2\2\2*\u024d\3\2\2\2,\u025e\3\2\2\2.\u0260\3\2\2\2\60"+
		"\u0262\3\2\2\2\62\u0264\3\2\2\2\64\u0270\3\2\2\2\66\u0272\3\2\2\28\u0274"+
		"\3\2\2\2:\u0277\3\2\2\2<=\7\3\2\2=?\5\64\33\2><\3\2\2\2>?\3\2\2\2?C\3"+
		"\2\2\2@B\5\4\3\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DI\3\2\2\2EC\3"+
		"\2\2\2FH\5\6\4\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\3\3\2\2\2KI"+
		"\3\2\2\2LP\7\4\2\2MN\5\64\33\2NO\7\5\2\2OQ\3\2\2\2PM\3\2\2\2PQ\3\2\2\2"+
		"QR\3\2\2\2RS\7P\2\2ST\7\6\2\2T\5\3\2\2\2UW\5\60\31\2VU\3\2\2\2VW\3\2\2"+
		"\2WX\3\2\2\2XY\7\7\2\2YZ\5\64\33\2Z[\7\5\2\2[\\\5\64\33\2\\]\3\2\2\2]"+
		"^\7\b\2\2^_\7P\2\2_k\3\2\2\2`f\7\t\2\2ae\5\6\4\2be\5\b\5\2ce\5&\24\2d"+
		"a\3\2\2\2db\3\2\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2"+
		"hf\3\2\2\2il\7\n\2\2jl\7\6\2\2k`\3\2\2\2kj\3\2\2\2l\7\3\2\2\2mq\5\n\6"+
		"\2nq\5\32\16\2oq\5\36\20\2pm\3\2\2\2pn\3\2\2\2po\3\2\2\2q\t\3\2\2\2rt"+
		"\5\60\31\2sr\3\2\2\2st\3\2\2\2tv\3\2\2\2uw\7\13\2\2vu\3\2\2\2vw\3\2\2"+
		"\2wx\3\2\2\2xy\7\f\2\2y\u0083\5\64\33\2z{\7\r\2\2{\u0080\5\62\32\2|}\7"+
		"\16\2\2}\177\5\62\32\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083z\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0086\7\5\2\2\u0086\u0088"+
		"\7P\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008e\3\2\2\2\u0089"+
		"\u008b\7\t\2\2\u008a\u008c\7\17\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\7\n\2\2\u008e\u0089\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u009b\3\2\2\2\u0090\u0096\7\t\2\2\u0091\u0095\5\22"+
		"\n\2\u0092\u0095\5\f\7\2\u0093\u0095\5&\24\2\u0094\u0091\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009c\7\n\2\2\u009a\u009c\7\6\2\2\u009b\u0090\3\2\2\2\u009b\u009a\3\2"+
		"\2\2\u009c\13\3\2\2\2\u009d\u00a0\5\16\b\2\u009e\u00a0\5\20\t\2\u009f"+
		"\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\r\3\2\2\2\u00a1\u00a3\5\60\31"+
		"\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a6"+
		"\7\20\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2"+
		"\u00a7\u00a8\7\21\2\2\u00a8\u00ab\5\64\33\2\u00a9\u00aa\7\b\2\2\u00aa"+
		"\u00ac\7P\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00b2\3\2"+
		"\2\2\u00ad\u00ae\7\5\2\2\u00ae\u00b0\5\26\f\2\u00af\u00b1\5\30\r\2\u00b0"+
		"\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00ad\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00cf\3\2\2\2\u00b4\u00ca\7\t\2\2\u00b5"+
		"\u00c6\7\22\2\2\u00b6\u00c6\7\23\2\2\u00b7\u00c6\7\24\2\2\u00b8\u00c6"+
		"\7\25\2\2\u00b9\u00c6\7\26\2\2\u00ba\u00c6\7\27\2\2\u00bb\u00c6\7\30\2"+
		"\2\u00bc\u00c6\7\31\2\2\u00bd\u00c6\7\32\2\2\u00be\u00c6\7\33\2\2\u00bf"+
		"\u00c6\7\34\2\2\u00c0\u00c6\7\35\2\2\u00c1\u00c6\7\36\2\2\u00c2\u00c6"+
		"\7\37\2\2\u00c3\u00c6\7 \2\2\u00c4\u00c6\7!\2\2\u00c5\u00b5\3\2\2\2\u00c5"+
		"\u00b6\3\2\2\2\u00c5\u00b7\3\2\2\2\u00c5\u00b8\3\2\2\2\u00c5\u00b9\3\2"+
		"\2\2\u00c5\u00ba\3\2\2\2\u00c5\u00bb\3\2\2\2\u00c5\u00bc\3\2\2\2\u00c5"+
		"\u00bd\3\2\2\2\u00c5\u00be\3\2\2\2\u00c5\u00bf\3\2\2\2\u00c5\u00c0\3\2"+
		"\2\2\u00c5\u00c1\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c4\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c9\7\16\2\2\u00c8\u00c7\3"+
		"\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c5\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00d0\7\n\2\2\u00cf\u00b4\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00eb\3\2\2\2\u00d1\u00e6\7\t\2\2\u00d2\u00d4\7\"\2\2\u00d3\u00d5\5\64"+
		"\33\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d8\7\5\2\2\u00d7\u00d9\5,\27\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da\u00e5\7\6\2\2\u00db\u00dd\7#\2\2\u00dc"+
		"\u00de\5\64\33\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3"+
		"\2\2\2\u00df\u00e1\7\5\2\2\u00e0\u00e2\5,\27\2\u00e1\u00e0\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\7\6\2\2\u00e4\u00d2\3\2"+
		"\2\2\u00e4\u00db\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ec\7\n"+
		"\2\2\u00ea\u00ec\7\6\2\2\u00eb\u00d1\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec"+
		"\17\3\2\2\2\u00ed\u00ef\5\60\31\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2"+
		"\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00f2\7\20\2\2\u00f1\u00f0\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7$\2\2\u00f4\u00f7\5\64"+
		"\33\2\u00f5\u00f6\7%\2\2\u00f6\u00f8\5\64\33\2\u00f7\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00fe\3\2\2\2\u00f9\u00fa\7\5\2\2\u00fa\u00fc\5\26"+
		"\f\2\u00fb\u00fd\5\30\r\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00ff\3\2\2\2\u00fe\u00f9\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0102\3\2"+
		"\2\2\u0100\u0101\7\b\2\2\u0101\u0103\7P\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0121\3\2\2\2\u0104\u011c\7\t\2\2\u0105\u0118\7&"+
		"\2\2\u0106\u0118\7\'\2\2\u0107\u0118\7\22\2\2\u0108\u0118\7\23\2\2\u0109"+
		"\u0118\7\26\2\2\u010a\u0118\7\27\2\2\u010b\u0118\7\30\2\2\u010c\u0118"+
		"\7\31\2\2\u010d\u0118\7(\2\2\u010e\u0118\7)\2\2\u010f\u0118\7\32\2\2\u0110"+
		"\u0118\7\33\2\2\u0111\u0118\7\34\2\2\u0112\u0118\7\35\2\2\u0113\u0118"+
		"\7\36\2\2\u0114\u0118\7\37\2\2\u0115\u0118\7 \2\2\u0116\u0118\7!\2\2\u0117"+
		"\u0105\3\2\2\2\u0117\u0106\3\2\2\2\u0117\u0107\3\2\2\2\u0117\u0108\3\2"+
		"\2\2\u0117\u0109\3\2\2\2\u0117\u010a\3\2\2\2\u0117\u010b\3\2\2\2\u0117"+
		"\u010c\3\2\2\2\u0117\u010d\3\2\2\2\u0117\u010e\3\2\2\2\u0117\u010f\3\2"+
		"\2\2\u0117\u0110\3\2\2\2\u0117\u0111\3\2\2\2\u0117\u0112\3\2\2\2\u0117"+
		"\u0113\3\2\2\2\u0117\u0114\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2"+
		"\2\2\u0118\u011a\3\2\2\2\u0119\u011b\7\16\2\2\u011a\u0119\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u0117\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0122\7\n\2\2\u0121\u0104\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0148\3\2"+
		"\2\2\u0123\u0143\7\t\2\2\u0124\u0125\7*\2\2\u0125\u012a\5\62\32\2\u0126"+
		"\u0127\7\16\2\2\u0127\u0129\5\62\32\2\u0128\u0126\3\2\2\2\u0129\u012c"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012d\u012e\7\6\2\2\u012e\u0142\3\2\2\2\u012f\u0131\7\""+
		"\2\2\u0130\u0132\5\64\33\2\u0131\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0135\7\5\2\2\u0134\u0136\5,\27\2\u0135\u0134\3\2"+
		"\2\2\u0135\u0136\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0142\7\6\2\2\u0138"+
		"\u013a\7#\2\2\u0139\u013b\5\64\33\2\u013a\u0139\3\2\2\2\u013a\u013b\3"+
		"\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\7\5\2\2\u013d\u013f\5,\27\2\u013e"+
		"\u013d\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\7\6"+
		"\2\2\u0141\u0124\3\2\2\2\u0141\u012f\3\2\2\2\u0141\u0138\3\2\2\2\u0142"+
		"\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2"+
		"\2\2\u0145\u0143\3\2\2\2\u0146\u0149\7\n\2\2\u0147\u0149\7\6\2\2\u0148"+
		"\u0123\3\2\2\2\u0148\u0147\3\2\2\2\u0149\21\3\2\2\2\u014a\u014c\5\60\31"+
		"\2\u014b\u014a\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014f"+
		"\7\20\2\2\u014e\u014d\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2"+
		"\u0150\u0151\7+\2\2\u0151\u0152\5\64\33\2\u0152\u015b\7,\2\2\u0153\u0158"+
		"\5\24\13\2\u0154\u0155\7\16\2\2\u0155\u0157\5\24\13\2\u0156\u0154\3\2"+
		"\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u0153\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c\u015d\3\2\2\2\u015d\u0163\7-\2\2\u015e\u015f\7\5\2\2\u015f"+
		"\u0161\5\26\f\2\u0160\u0162\5\30\r\2\u0161\u0160\3\2\2\2\u0161\u0162\3"+
		"\2\2\2\u0162\u0164\3\2\2\2\u0163\u015e\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\u016e\3\2\2\2\u0165\u0166\7.\2\2\u0166\u016b\5\64\33\2\u0167\u0168\7"+
		"\16\2\2\u0168\u016a\5\64\33\2\u0169\u0167\3\2\2\2\u016a\u016d\3\2\2\2"+
		"\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b"+
		"\3\2\2\2\u016e\u0165\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0181\3\2\2\2\u0170"+
		"\u017c\7\t\2\2\u0171\u0178\7\22\2\2\u0172\u0178\7\23\2\2\u0173\u0178\7"+
		"\26\2\2\u0174\u0178\7\27\2\2\u0175\u0178\7\34\2\2\u0176\u0178\7\35\2\2"+
		"\u0177\u0171\3\2\2\2\u0177\u0172\3\2\2\2\u0177\u0173\3\2\2\2\u0177\u0174"+
		"\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0176\3\2\2\2\u0178\u017a\3\2\2\2\u0179"+
		"\u017b\7\16\2\2\u017a\u0179\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d\3"+
		"\2\2\2\u017c\u0177\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017c\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182\7\n\2\2\u0181\u0170\3\2"+
		"\2\2\u0181\u0182\3\2\2\2\u0182\u018e\3\2\2\2\u0183\u0189\7\t\2\2\u0184"+
		"\u0188\5(\25\2\u0185\u0188\5$\23\2\u0186\u0188\5*\26\2\u0187\u0184\3\2"+
		"\2\2\u0187\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0188\u018b\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c\3\2\2\2\u018b\u0189\3\2"+
		"\2\2\u018c\u018f\7\n\2\2\u018d\u018f\7\6\2\2\u018e\u0183\3\2\2\2\u018e"+
		"\u018d\3\2\2\2\u018f\23\3\2\2\2\u0190\u0196\5\64\33\2\u0191\u0192\7\5"+
		"\2\2\u0192\u0194\5\26\f\2\u0193\u0195\5\30\r\2\u0194\u0193\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0197\3\2\2\2\u0196\u0191\3\2\2\2\u0196\u0197\3\2"+
		"\2\2\u0197\u01a7\3\2\2\2\u0198\u01a2\7\t\2\2\u0199\u019e\7\26\2\2\u019a"+
		"\u019e\7\27\2\2\u019b\u019e\7\34\2\2\u019c\u019e\7\35\2\2\u019d\u0199"+
		"\3\2\2\2\u019d\u019a\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019c\3\2\2\2\u019e"+
		"\u01a0\3\2\2\2\u019f\u01a1\7\16\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3"+
		"\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u019d\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\7\n"+
		"\2\2\u01a7\u0198\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\25\3\2\2\2\u01a9\u01ac"+
		"\5\34\17\2\u01aa\u01ac\5\62\32\2\u01ab\u01a9\3\2\2\2\u01ab\u01aa\3\2\2"+
		"\2\u01ac\27\3\2\2\2\u01ad\u01b4\7/\2\2\u01ae\u01b1\58\35\2\u01af\u01b0"+
		"\7\60\2\2\u01b0\u01b2\5\66\34\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2"+
		"\2\u01b2\u01b5\3\2\2\2\u01b3\u01b5\t\2\2\2\u01b4\u01ae\3\2\2\2\u01b4\u01b3"+
		"\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\7\64\2\2\u01b7\31\3\2\2\2\u01b8"+
		"\u01ba\7\65\2\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3"+
		"\2\2\2\u01bb\u01bc\7\66\2\2\u01bc\u01be\5\64\33\2\u01bd\u01bf\5\"\22\2"+
		"\u01be\u01bd\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01c1"+
		"\7\5\2\2\u01c1\u01c3\7P\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3"+
		"\u01ca\3\2\2\2\u01c4\u01c7\7\t\2\2\u01c5\u01c8\7\67\2\2\u01c6\u01c8\7"+
		"8\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9\u01cb\7\n\2\2\u01ca\u01c4\3\2\2\2\u01ca\u01cb\3\2"+
		"\2\2\u01cb\u01d5\3\2\2\2\u01cc\u01d0\7\t\2\2\u01cd\u01cf\5&\24\2\u01ce"+
		"\u01cd\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2"+
		"\2\2\u01d1\u01d3\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d6\7\n\2\2\u01d4"+
		"\u01d6\7\6\2\2\u01d5\u01cc\3\2\2\2\u01d5\u01d4\3\2\2\2\u01d6\33\3\2\2"+
		"\2\u01d7\u01d8\t\3\2\2\u01d8\35\3\2\2\2\u01d9\u01db\5\60\31\2\u01da\u01d9"+
		"\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\7>\2\2\u01dd"+
		"\u01df\5\64\33\2\u01de\u01e0\5\"\22\2\u01df\u01de\3\2\2\2\u01df\u01e0"+
		"\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01e2\7\5\2\2\u01e2\u01e4\7P\2\2\u01e3"+
		"\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01eb\3\2\2\2\u01e5\u01e8\7\t"+
		"\2\2\u01e6\u01e9\7\67\2\2\u01e7\u01e9\78\2\2\u01e8\u01e6\3\2\2\2\u01e8"+
		"\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\7\n"+
		"\2\2\u01eb\u01e5\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01f7\3\2\2\2\u01ed"+
		"\u01f2\7\t\2\2\u01ee\u01f1\5 \21\2\u01ef\u01f1\5&\24\2\u01f0\u01ee\3\2"+
		"\2\2\u01f0\u01ef\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u01f5\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f8\7\n"+
		"\2\2\u01f6\u01f8\7\6\2\2\u01f7\u01ed\3\2\2\2\u01f7\u01f6\3\2\2\2\u01f8"+
		"\37\3\2\2\2\u01f9\u01fa\7?\2\2\u01fa\u01fd\5\64\33\2\u01fb\u01fd\5\64"+
		"\33\2\u01fc\u01f9\3\2\2\2\u01fc\u01fb\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe"+
		"\u01ff\7\b\2\2\u01ff\u0201\5:\36\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2"+
		"\2\2\u0201\u0202\3\2\2\2\u0202\u0203\7\6\2\2\u0203!\3\2\2\2\u0204\u0205"+
		"\7,\2\2\u0205\u020a\5\64\33\2\u0206\u0207\7\16\2\2\u0207\u0209\5\64\33"+
		"\2\u0208\u0206\3\2\2\2\u0209\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b"+
		"\3\2\2\2\u020b\u020d\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u020e\7-\2\2\u020e"+
		"\u021b\3\2\2\2\u020f\u0210\7@\2\2\u0210\u0215\5\64\33\2\u0211\u0212\7"+
		"\16\2\2\u0212\u0214\5\64\33\2\u0213\u0211\3\2\2\2\u0214\u0217\3\2\2\2"+
		"\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218\3\2\2\2\u0217\u0215"+
		"\3\2\2\2\u0218\u0219\7A\2\2\u0219\u021b\3\2\2\2\u021a\u0204\3\2\2\2\u021a"+
		"\u020f\3\2\2\2\u021b#\3\2\2\2\u021c\u021e\7B\2\2\u021d\u021f\5\64\33\2"+
		"\u021e\u021d\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0226\3\2\2\2\u0220\u0222"+
		"\7\5\2\2\u0221\u0223\5,\27\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0227\7\6\2\2\u0225\u0227\7\6\2\2\u0226\u0220\3\2"+
		"\2\2\u0226\u0225\3\2\2\2\u0227%\3\2\2\2\u0228\u022a\7C\2\2\u0229\u0228"+
		"\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u0232\7D\2\2\u022c"+
		"\u0230\5\64\33\2\u022d\u022e\7,\2\2\u022e\u022f\7O\2\2\u022f\u0231\7-"+
		"\2\2\u0230\u022d\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0233\3\2\2\2\u0232"+
		"\u022c\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u023a\3\2\2\2\u0234\u0236\7\5"+
		"\2\2\u0235\u0237\5.\30\2\u0236\u0235\3\2\2\2\u0236\u0237\3\2\2\2\u0237"+
		"\u0238\3\2\2\2\u0238\u023b\7\6\2\2\u0239\u023b\7\6\2\2\u023a\u0234\3\2"+
		"\2\2\u023a\u0239\3\2\2\2\u023b\'\3\2\2\2\u023c\u0243\7E\2\2\u023d\u0241"+
		"\5\64\33\2\u023e\u023f\7,\2\2\u023f\u0240\7O\2\2\u0240\u0242\7-\2\2\u0241"+
		"\u023e\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0244\3\2\2\2\u0243\u023d\3\2"+
		"\2\2\u0243\u0244\3\2\2\2\u0244\u024b\3\2\2\2\u0245\u0247\7\5\2\2\u0246"+
		"\u0248\5.\30\2\u0247\u0246\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0249\3\2"+
		"\2\2\u0249\u024c\7\6\2\2\u024a\u024c\7\6\2\2\u024b\u0245\3\2\2\2\u024b"+
		"\u024a\3\2\2\2\u024c)\3\2\2\2\u024d\u0254\7F\2\2\u024e\u0252\5\64\33\2"+
		"\u024f\u0250\7,\2\2\u0250\u0251\7O\2\2\u0251\u0253\7-\2\2\u0252\u024f"+
		"\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0255\3\2\2\2\u0254\u024e\3\2\2\2\u0254"+
		"\u0255\3\2\2\2\u0255\u025c\3\2\2\2\u0256\u0258\7\5\2\2\u0257\u0259\5."+
		"\30\2\u0258\u0257\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025a\3\2\2\2\u025a"+
		"\u025d\7\6\2\2\u025b\u025d\7\6\2\2\u025c\u0256\3\2\2\2\u025c\u025b\3\2"+
		"\2\2\u025d+\3\2\2\2\u025e\u025f\7G\2\2\u025f-\3\2\2\2\u0260\u0261\7G\2"+
		"\2\u0261/\3\2\2\2\u0262\u0263\t\4\2\2\u0263\61\3\2\2\2\u0264\u026e\5\64"+
		"\33\2\u0265\u0266\7K\2\2\u0266\u0268\5\64\33\2\u0267\u0265\3\2\2\2\u0268"+
		"\u026b\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026c\3\2"+
		"\2\2\u026b\u0269\3\2\2\2\u026c\u026d\7K\2\2\u026d\u026f\5\64\33\2\u026e"+
		"\u0269\3\2\2\2\u026e\u026f\3\2\2\2\u026f\63\3\2\2\2\u0270\u0271\7N\2\2"+
		"\u0271\65\3\2\2\2\u0272\u0273\t\5\2\2\u0273\67\3\2\2\2\u0274\u0275\7M"+
		"\2\2\u02759\3\2\2\2\u0276\u0278\7L\2\2\u0277\u0276\3\2\2\2\u0277\u0278"+
		"\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\7M\2\2\u027a;\3\2\2\2w>CIPVd"+
		"fkpsv\u0080\u0083\u0087\u008b\u008e\u0094\u0096\u009b\u009f\u00a2\u00a5"+
		"\u00ab\u00b0\u00b2\u00c5\u00c8\u00cc\u00cf\u00d4\u00d8\u00dd\u00e1\u00e4"+
		"\u00e6\u00eb\u00ee\u00f1\u00f7\u00fc\u00fe\u0102\u0117\u011a\u011e\u0121"+
		"\u012a\u0131\u0135\u013a\u013e\u0141\u0143\u0148\u014b\u014e\u0158\u015b"+
		"\u0161\u0163\u016b\u016e\u0177\u017a\u017e\u0181\u0187\u0189\u018e\u0194"+
		"\u0196\u019d\u01a0\u01a4\u01a7\u01ab\u01b1\u01b4\u01b9\u01be\u01c2\u01c7"+
		"\u01ca\u01d0\u01d5\u01da\u01df\u01e3\u01e8\u01eb\u01f0\u01f2\u01f7\u01fc"+
		"\u0200\u020a\u0215\u021a\u021e\u0222\u0226\u0229\u0230\u0232\u0236\u023a"+
		"\u0241\u0243\u0247\u024b\u0252\u0254\u0258\u025c\u0269\u026e\u0277";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}