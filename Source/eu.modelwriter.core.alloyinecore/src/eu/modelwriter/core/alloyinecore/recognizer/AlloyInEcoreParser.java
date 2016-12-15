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
		RULE_templateSignature = 16, RULE_bodyExpression = 17, RULE_invariantConstraint = 18, 
		RULE_preconditionConstraint = 19, RULE_postconditionConstraint = 20, RULE_specification = 21, 
		RULE_expression = 22, RULE_visibilityKind = 23, RULE_qualifiedName = 24, 
		RULE_identifier = 25, RULE_upper = 26, RULE_lower = 27, RULE_signed = 28;
	public static final String[] ruleNames = {
		"module", "packageImport", "ePackage", "eClassifier", "eClass", "eStructuralFeature", 
		"eAttribute", "eReference", "eOperation", "eParameter", "eType", "eMultiplicity", 
		"eDataType", "ePrimitiveType", "eEnum", "eEnumLiteral", "templateSignature", 
		"bodyExpression", "invariantConstraint", "preconditionConstraint", "postconditionConstraint", 
		"specification", "expression", "visibilityKind", "qualifiedName", "identifier", 
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
			setState(104);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(94);
				match(T__6);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__50) | (1L << T__51) | (1L << T__59))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
					{
					setState(97);
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
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(103);
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
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				eClass();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				eDataType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
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
		public InvariantConstraintContext invariantConstraint;
		public List<InvariantConstraintContext> eConstraints = new ArrayList<InvariantConstraintContext>();
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
		public List<InvariantConstraintContext> invariantConstraint() {
			return getRuleContexts(InvariantConstraintContext.class);
		}
		public InvariantConstraintContext invariantConstraint(int i) {
			return getRuleContext(InvariantConstraintContext.class,i);
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
			setState(112);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(111);
				((EClassContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(115);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(114);
				((EClassContext)_localctx).isAbstract = match(T__8);
				}
			}

			setState(117);
			match(T__9);
			setState(118);
			((EClassContext)_localctx).name = identifier();
			setState(128);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(119);
				match(T__10);
				setState(120);
				((EClassContext)_localctx).qualifiedName = qualifiedName();
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(121);
					match(T__11);
					setState(122);
					((EClassContext)_localctx).qualifiedName = qualifiedName();
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(132);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(130);
				match(T__2);
				setState(131);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(134);
				match(T__6);
				setState(136);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(135);
					((EClassContext)_localctx).isInterface = match(T__12);
					}
				}

				setState(138);
				match(T__7);
				}
				break;
			}
			setState(152);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(141);
				match(T__6);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__13) | (1L << T__14) | (1L << T__33) | (1L << T__40))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__65 - 65)) | (1L << (T__69 - 65)) | (1L << (T__70 - 65)) | (1L << (T__71 - 65)))) != 0)) {
					{
					setState(145);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(142);
						((EClassContext)_localctx).eOperation = eOperation();
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						}
						break;
					case 2:
						{
						setState(143);
						((EClassContext)_localctx).eStructuralFeature = eStructuralFeature();
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						}
						break;
					case 3:
						{
						setState(144);
						((EClassContext)_localctx).invariantConstraint = invariantConstraint();
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariantConstraint);
						}
						break;
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(151);
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
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				eAttribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
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
		public SpecificationContext specification;
		public List<SpecificationContext> ownedDefaultExpression = new ArrayList<SpecificationContext>();
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
		public List<SpecificationContext> specification() {
			return getRuleContexts(SpecificationContext.class);
		}
		public SpecificationContext specification(int i) {
			return getRuleContext(SpecificationContext.class,i);
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
			setState(159);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(158);
				((EAttributeContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(162);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(161);
				((EAttributeContext)_localctx).s14 = match(T__13);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s14);
				}
			}

			setState(164);
			match(T__14);
			setState(165);
			((EAttributeContext)_localctx).name = identifier();
			setState(168);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(166);
				match(T__5);
				setState(167);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(175);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(170);
				match(T__2);
				setState(171);
				((EAttributeContext)_localctx).eAttributeType = eType();
				setState(173);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(172);
					((EAttributeContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(177);
				match(T__6);
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(194);
					switch (_input.LA(1)) {
					case T__15:
						{
						setState(178);
						((EAttributeContext)_localctx).s16 = match(T__15);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(179);
						((EAttributeContext)_localctx).s17 = match(T__16);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s17);
						}
						break;
					case T__17:
						{
						setState(180);
						((EAttributeContext)_localctx).s18 = match(T__17);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s18);
						}
						break;
					case T__18:
						{
						setState(181);
						((EAttributeContext)_localctx).s19 = match(T__18);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s19);
						}
						break;
					case T__19:
						{
						setState(182);
						((EAttributeContext)_localctx).s20 = match(T__19);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(183);
						((EAttributeContext)_localctx).s21 = match(T__20);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s21);
						}
						break;
					case T__21:
						{
						setState(184);
						((EAttributeContext)_localctx).s22 = match(T__21);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s22);
						}
						break;
					case T__22:
						{
						setState(185);
						((EAttributeContext)_localctx).s23 = match(T__22);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s23);
						}
						break;
					case T__23:
						{
						setState(186);
						((EAttributeContext)_localctx).s24 = match(T__23);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s24);
						}
						break;
					case T__24:
						{
						setState(187);
						((EAttributeContext)_localctx).s25 = match(T__24);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s25);
						}
						break;
					case T__25:
						{
						setState(188);
						((EAttributeContext)_localctx).s26 = match(T__25);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(189);
						((EAttributeContext)_localctx).s27 = match(T__26);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
						}
						break;
					case T__27:
						{
						setState(190);
						((EAttributeContext)_localctx).s28 = match(T__27);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(191);
						((EAttributeContext)_localctx).s29 = match(T__28);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(192);
						((EAttributeContext)_localctx).s30 = match(T__29);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(193);
						((EAttributeContext)_localctx).s31 = match(T__30);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(197);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(196);
						match(T__11);
						}
					}

					}
					}
					setState(201); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0) );
				setState(203);
				match(T__7);
				}
				break;
			}
			setState(232);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(206);
				match(T__6);
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__31 || _la==T__32) {
					{
					setState(225);
					switch (_input.LA(1)) {
					case T__31:
						{
						{
						setState(207);
						match(T__31);
						setState(209);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(208);
							identifier();
							}
						}

						setState(211);
						match(T__2);
						setState(213);
						_la = _input.LA(1);
						if (_la==T__68) {
							{
							setState(212);
							((EAttributeContext)_localctx).specification = specification();
							((EAttributeContext)_localctx).ownedDefaultExpression.add(((EAttributeContext)_localctx).specification);
							}
						}

						setState(215);
						match(T__3);
						}
						}
						break;
					case T__32:
						{
						{
						setState(216);
						match(T__32);
						setState(218);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(217);
							identifier();
							}
						}

						setState(220);
						match(T__2);
						setState(222);
						_la = _input.LA(1);
						if (_la==T__68) {
							{
							setState(221);
							((EAttributeContext)_localctx).specification = specification();
							((EAttributeContext)_localctx).ownedDefaultExpression.add(((EAttributeContext)_localctx).specification);
							}
						}

						setState(224);
						match(T__3);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(229);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(230);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(231);
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
		public SpecificationContext specification;
		public List<SpecificationContext> ownedDefaultExpressions = new ArrayList<SpecificationContext>();
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
		public List<SpecificationContext> specification() {
			return getRuleContexts(SpecificationContext.class);
		}
		public SpecificationContext specification(int i) {
			return getRuleContext(SpecificationContext.class,i);
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
			setState(235);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(234);
				((EReferenceContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(238);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(237);
				((EReferenceContext)_localctx).s14 = match(T__13);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s14);
				}
			}

			setState(240);
			match(T__33);
			setState(241);
			((EReferenceContext)_localctx).name = identifier();
			setState(244);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(242);
				match(T__34);
				setState(243);
				((EReferenceContext)_localctx).opposite = identifier();
				}
			}

			setState(251);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(246);
				match(T__2);
				setState(247);
				((EReferenceContext)_localctx).eReferenceType = eType();
				setState(249);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(248);
					((EReferenceContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(255);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(253);
				match(T__5);
				setState(254);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(257);
				match(T__6);
				setState(281); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(276);
					switch (_input.LA(1)) {
					case T__35:
						{
						setState(258);
						((EReferenceContext)_localctx).s36 = match(T__35);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(259);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__15:
						{
						setState(260);
						((EReferenceContext)_localctx).s16 = match(T__15);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(261);
						((EReferenceContext)_localctx).s17 = match(T__16);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s17);
						}
						break;
					case T__19:
						{
						setState(262);
						((EReferenceContext)_localctx).s20 = match(T__19);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(263);
						((EReferenceContext)_localctx).s21 = match(T__20);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s21);
						}
						break;
					case T__21:
						{
						setState(264);
						((EReferenceContext)_localctx).s22 = match(T__21);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s22);
						}
						break;
					case T__22:
						{
						setState(265);
						((EReferenceContext)_localctx).s23 = match(T__22);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s23);
						}
						break;
					case T__37:
						{
						setState(266);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(267);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__23:
						{
						setState(268);
						((EReferenceContext)_localctx).s24 = match(T__23);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s24);
						}
						break;
					case T__24:
						{
						setState(269);
						((EReferenceContext)_localctx).s25 = match(T__24);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s25);
						}
						break;
					case T__25:
						{
						setState(270);
						((EReferenceContext)_localctx).s26 = match(T__25);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(271);
						((EReferenceContext)_localctx).s27 = match(T__26);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
						}
						break;
					case T__27:
						{
						setState(272);
						((EReferenceContext)_localctx).s28 = match(T__27);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(273);
						((EReferenceContext)_localctx).s29 = match(T__28);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(274);
						((EReferenceContext)_localctx).s30 = match(T__29);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(275);
						((EReferenceContext)_localctx).s31 = match(T__30);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(279);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(278);
						match(T__11);
						}
					}

					}
					}
					setState(283); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0) );
				setState(285);
				match(T__7);
				}
				break;
			}
			setState(325);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(288);
				match(T__6);
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__39))) != 0)) {
					{
					setState(318);
					switch (_input.LA(1)) {
					case T__39:
						{
						{
						setState(289);
						match(T__39);
						setState(290);
						((EReferenceContext)_localctx).qualifiedName = qualifiedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
						setState(295);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__11) {
							{
							{
							setState(291);
							match(T__11);
							setState(292);
							((EReferenceContext)_localctx).qualifiedName = qualifiedName();
							((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
							}
							}
							setState(297);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(298);
						match(T__3);
						}
						}
						break;
					case T__31:
						{
						{
						setState(300);
						match(T__31);
						setState(302);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(301);
							identifier();
							}
						}

						setState(304);
						match(T__2);
						setState(306);
						_la = _input.LA(1);
						if (_la==T__68) {
							{
							setState(305);
							((EReferenceContext)_localctx).specification = specification();
							((EReferenceContext)_localctx).ownedDefaultExpressions.add(((EReferenceContext)_localctx).specification);
							}
						}

						setState(308);
						match(T__3);
						}
						}
						break;
					case T__32:
						{
						{
						setState(309);
						match(T__32);
						setState(311);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(310);
							identifier();
							}
						}

						setState(313);
						match(T__2);
						setState(315);
						_la = _input.LA(1);
						if (_la==T__68) {
							{
							setState(314);
							((EReferenceContext)_localctx).specification = specification();
							((EReferenceContext)_localctx).ownedDefaultExpressions.add(((EReferenceContext)_localctx).specification);
							}
						}

						setState(317);
						match(T__3);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(322);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(323);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(324);
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
		public PreconditionConstraintContext preconditionConstraint;
		public List<PreconditionConstraintContext> ownedPrecondition = new ArrayList<PreconditionConstraintContext>();
		public BodyExpressionContext bodyExpression;
		public List<BodyExpressionContext> ownedBodyExpression = new ArrayList<BodyExpressionContext>();
		public PostconditionConstraintContext postconditionConstraint;
		public List<PostconditionConstraintContext> ownedPostcondition = new ArrayList<PostconditionConstraintContext>();
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
		public List<PreconditionConstraintContext> preconditionConstraint() {
			return getRuleContexts(PreconditionConstraintContext.class);
		}
		public PreconditionConstraintContext preconditionConstraint(int i) {
			return getRuleContext(PreconditionConstraintContext.class,i);
		}
		public List<BodyExpressionContext> bodyExpression() {
			return getRuleContexts(BodyExpressionContext.class);
		}
		public BodyExpressionContext bodyExpression(int i) {
			return getRuleContext(BodyExpressionContext.class,i);
		}
		public List<PostconditionConstraintContext> postconditionConstraint() {
			return getRuleContexts(PostconditionConstraintContext.class);
		}
		public PostconditionConstraintContext postconditionConstraint(int i) {
			return getRuleContext(PostconditionConstraintContext.class,i);
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
			setState(328);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(327);
				((EOperationContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(331);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(330);
				((EOperationContext)_localctx).s14 = match(T__13);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s14);
				}
			}

			setState(333);
			match(T__40);
			setState(334);
			((EOperationContext)_localctx).name = identifier();
			setState(335);
			match(T__41);
			setState(344);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(336);
				((EOperationContext)_localctx).eParameter = eParameter();
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(337);
					match(T__11);
					setState(338);
					((EOperationContext)_localctx).eParameter = eParameter();
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(343);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(346);
			match(T__42);
			setState(352);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(347);
				match(T__2);
				setState(348);
				((EOperationContext)_localctx).returnType = eType();
				setState(350);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(349);
					((EOperationContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(363);
			_la = _input.LA(1);
			if (_la==T__43) {
				{
				setState(354);
				match(T__43);
				setState(355);
				((EOperationContext)_localctx).identifier = identifier();
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(356);
					match(T__11);
					setState(357);
					((EOperationContext)_localctx).identifier = identifier();
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
					}
					}
					setState(362);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(365);
				match(T__6);
				setState(377); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(372);
					switch (_input.LA(1)) {
					case T__15:
						{
						setState(366);
						((EOperationContext)_localctx).s16 = match(T__15);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(367);
						((EOperationContext)_localctx).s17 = match(T__16);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s17);
						}
						break;
					case T__19:
						{
						setState(368);
						((EOperationContext)_localctx).s20 = match(T__19);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(369);
						((EOperationContext)_localctx).s21 = match(T__20);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s21);
						}
						break;
					case T__25:
						{
						setState(370);
						((EOperationContext)_localctx).s26 = match(T__25);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(371);
						((EOperationContext)_localctx).s27 = match(T__26);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s27);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(375);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(374);
						match(T__11);
						}
					}

					}
					}
					setState(379); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__26))) != 0) );
				setState(381);
				match(T__7);
				}
				break;
			}
			setState(395);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(384);
				match(T__6);
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)))) != 0)) {
					{
					setState(388);
					switch (_input.LA(1)) {
					case T__66:
						{
						setState(385);
						((EOperationContext)_localctx).preconditionConstraint = preconditionConstraint();
						((EOperationContext)_localctx).ownedPrecondition.add(((EOperationContext)_localctx).preconditionConstraint);
						}
						break;
					case T__63:
						{
						setState(386);
						((EOperationContext)_localctx).bodyExpression = bodyExpression();
						((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).bodyExpression);
						}
						break;
					case T__67:
						{
						setState(387);
						((EOperationContext)_localctx).postconditionConstraint = postconditionConstraint();
						((EOperationContext)_localctx).ownedPostcondition.add(((EOperationContext)_localctx).postconditionConstraint);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(392);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(393);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(394);
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
			setState(397);
			((EParameterContext)_localctx).name = identifier();
			setState(403);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(398);
				match(T__2);
				setState(399);
				((EParameterContext)_localctx).ownedType = eType();
				setState(401);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(400);
					((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(420);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(405);
				match(T__6);
				setState(415); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(410);
					switch (_input.LA(1)) {
					case T__19:
						{
						setState(406);
						((EParameterContext)_localctx).s20 = match(T__19);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(407);
						((EParameterContext)_localctx).s21 = match(T__20);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s21);
						}
						break;
					case T__25:
						{
						setState(408);
						((EParameterContext)_localctx).s26 = match(T__25);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(409);
						((EParameterContext)_localctx).s27 = match(T__26);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s27);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(413);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(412);
						match(T__11);
						}
					}

					}
					}
					setState(417); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__26))) != 0) );
				setState(419);
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
			setState(424);
			switch (_input.LA(1)) {
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				ePrimitiveType();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
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
			setState(426);
			match(T__44);
			setState(433);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(427);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(430);
				_la = _input.LA(1);
				if (_la==T__45) {
					{
					setState(428);
					match(T__45);
					setState(429);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__46:
			case T__47:
			case T__48:
				{
				setState(432);
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
			setState(435);
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
		public InvariantConstraintContext invariantConstraint;
		public List<InvariantConstraintContext> ownedConstraint = new ArrayList<InvariantConstraintContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(AlloyInEcoreParser.SINGLE_QUOTED_STRING, 0); }
		public List<InvariantConstraintContext> invariantConstraint() {
			return getRuleContexts(InvariantConstraintContext.class);
		}
		public InvariantConstraintContext invariantConstraint(int i) {
			return getRuleContext(InvariantConstraintContext.class,i);
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
			setState(438);
			_la = _input.LA(1);
			if (_la==T__50) {
				{
				setState(437);
				((EDataTypeContext)_localctx).isPrimitive = match(T__50);
				}
			}

			setState(440);
			match(T__51);
			setState(441);
			((EDataTypeContext)_localctx).name = identifier();
			setState(443);
			_la = _input.LA(1);
			if (_la==T__41 || _la==T__61) {
				{
				setState(442);
				((EDataTypeContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(447);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(445);
				match(T__2);
				setState(446);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				{
				setState(449);
				match(T__6);
				setState(452);
				switch (_input.LA(1)) {
				case T__52:
					{
					setState(450);
					((EDataTypeContext)_localctx).isSerializable = match(T__52);
					}
					break;
				case T__53:
					{
					setState(451);
					match(T__53);
					}
					break;
				case T__7:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(454);
				match(T__7);
				}
				break;
			}
			setState(466);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(457);
				match(T__6);
				setState(461);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__64 || _la==T__65) {
					{
					{
					setState(458);
					((EDataTypeContext)_localctx).invariantConstraint = invariantConstraint();
					((EDataTypeContext)_localctx).ownedConstraint.add(((EDataTypeContext)_localctx).invariantConstraint);
					}
					}
					setState(463);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(464);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(465);
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
			setState(468);
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
		public InvariantConstraintContext invariantConstraint;
		public List<InvariantConstraintContext> ownedConstraint = new ArrayList<InvariantConstraintContext>();
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
		public List<InvariantConstraintContext> invariantConstraint() {
			return getRuleContexts(InvariantConstraintContext.class);
		}
		public InvariantConstraintContext invariantConstraint(int i) {
			return getRuleContext(InvariantConstraintContext.class,i);
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
			setState(471);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)))) != 0)) {
				{
				setState(470);
				((EEnumContext)_localctx).visibility = visibilityKind();
				}
			}

			setState(473);
			match(T__59);
			setState(474);
			((EEnumContext)_localctx).name = identifier();
			setState(476);
			_la = _input.LA(1);
			if (_la==T__41 || _la==T__61) {
				{
				setState(475);
				((EEnumContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(480);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(478);
				match(T__2);
				setState(479);
				((EEnumContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(482);
				match(T__6);
				setState(485);
				switch (_input.LA(1)) {
				case T__52:
					{
					setState(483);
					((EEnumContext)_localctx).isSerializable = match(T__52);
					}
					break;
				case T__53:
					{
					setState(484);
					match(T__53);
					}
					break;
				case T__7:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(487);
				match(T__7);
				}
				break;
			}
			setState(500);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(490);
				match(T__6);
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (T__60 - 61)) | (1L << (T__64 - 61)) | (1L << (T__65 - 61)) | (1L << (IDENTIFIER - 61)))) != 0)) {
					{
					setState(493);
					switch (_input.LA(1)) {
					case T__60:
					case IDENTIFIER:
						{
						setState(491);
						((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral();
						((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
						}
						break;
					case T__64:
					case T__65:
						{
						setState(492);
						((EEnumContext)_localctx).invariantConstraint = invariantConstraint();
						((EEnumContext)_localctx).ownedConstraint.add(((EEnumContext)_localctx).invariantConstraint);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(497);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(498);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(499);
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
			setState(505);
			switch (_input.LA(1)) {
			case T__60:
				{
				{
				setState(502);
				match(T__60);
				setState(503);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				}
				break;
			case IDENTIFIER:
				{
				setState(504);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(509);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(507);
				match(T__5);
				setState(508);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}

			setState(511);
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
			setState(535);
			switch (_input.LA(1)) {
			case T__41:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(513);
				match(T__41);
				setState(514);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(515);
					match(T__11);
					setState(516);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(521);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(522);
				match(T__42);
				}
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(524);
				match(T__61);
				setState(525);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(526);
					match(T__11);
					setState(527);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(532);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(533);
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

	public static class BodyExpressionContext extends ParserRuleContext {
		public SpecificationContext specification;
		public List<SpecificationContext> ownedBodyExpression = new ArrayList<SpecificationContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SpecificationContext specification() {
			return getRuleContext(SpecificationContext.class,0);
		}
		public BodyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterBodyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitBodyExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitBodyExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyExpressionContext bodyExpression() throws RecognitionException {
		BodyExpressionContext _localctx = new BodyExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_bodyExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(537);
			match(T__63);
			setState(539);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(538);
				identifier();
				}
			}

			setState(541);
			match(T__2);
			setState(543);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(542);
				((BodyExpressionContext)_localctx).specification = specification();
				((BodyExpressionContext)_localctx).ownedBodyExpression.add(((BodyExpressionContext)_localctx).specification);
				}
			}

			setState(545);
			match(T__3);
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

	public static class InvariantConstraintContext extends ParserRuleContext {
		public Token isCallable;
		public Token stereotype;
		public IdentifierContext name;
		public SpecificationContext ownedMessageSpecification;
		public SpecificationContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<SpecificationContext> specification() {
			return getRuleContexts(SpecificationContext.class);
		}
		public SpecificationContext specification(int i) {
			return getRuleContext(SpecificationContext.class,i);
		}
		public InvariantConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariantConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterInvariantConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitInvariantConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInvariantConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvariantConstraintContext invariantConstraint() throws RecognitionException {
		InvariantConstraintContext _localctx = new InvariantConstraintContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_invariantConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_la = _input.LA(1);
			if (_la==T__64) {
				{
				setState(547);
				((InvariantConstraintContext)_localctx).isCallable = match(T__64);
				}
			}

			setState(550);
			((InvariantConstraintContext)_localctx).stereotype = match(T__65);
			setState(558);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(551);
				((InvariantConstraintContext)_localctx).name = identifier();
				setState(556);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(552);
					match(T__41);
					setState(553);
					((InvariantConstraintContext)_localctx).ownedMessageSpecification = specification();
					setState(554);
					match(T__42);
					}
				}

				}
			}

			setState(566);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(560);
				match(T__2);
				setState(562);
				_la = _input.LA(1);
				if (_la==T__68) {
					{
					setState(561);
					((InvariantConstraintContext)_localctx).ownedSpecification = specification();
					}
				}

				setState(564);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(565);
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

	public static class PreconditionConstraintContext extends ParserRuleContext {
		public Token stereotype;
		public IdentifierContext name;
		public SpecificationContext ownedMessageSpecification;
		public SpecificationContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<SpecificationContext> specification() {
			return getRuleContexts(SpecificationContext.class);
		}
		public SpecificationContext specification(int i) {
			return getRuleContext(SpecificationContext.class,i);
		}
		public PreconditionConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preconditionConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPreconditionConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPreconditionConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPreconditionConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreconditionConstraintContext preconditionConstraint() throws RecognitionException {
		PreconditionConstraintContext _localctx = new PreconditionConstraintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_preconditionConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			((PreconditionConstraintContext)_localctx).stereotype = match(T__66);
			setState(576);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(569);
				((PreconditionConstraintContext)_localctx).name = identifier();
				setState(574);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(570);
					match(T__41);
					setState(571);
					((PreconditionConstraintContext)_localctx).ownedMessageSpecification = specification();
					setState(572);
					match(T__42);
					}
				}

				}
			}

			setState(578);
			match(T__2);
			setState(580);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(579);
				((PreconditionConstraintContext)_localctx).ownedSpecification = specification();
				}
			}

			setState(582);
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

	public static class PostconditionConstraintContext extends ParserRuleContext {
		public Token stereotype;
		public IdentifierContext name;
		public SpecificationContext ownedMessageSpecification;
		public SpecificationContext ownedSpecification;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<SpecificationContext> specification() {
			return getRuleContexts(SpecificationContext.class);
		}
		public SpecificationContext specification(int i) {
			return getRuleContext(SpecificationContext.class,i);
		}
		public PostconditionConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postconditionConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterPostconditionConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitPostconditionConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPostconditionConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostconditionConstraintContext postconditionConstraint() throws RecognitionException {
		PostconditionConstraintContext _localctx = new PostconditionConstraintContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_postconditionConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			((PostconditionConstraintContext)_localctx).stereotype = match(T__67);
			setState(592);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(585);
				((PostconditionConstraintContext)_localctx).name = identifier();
				setState(590);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(586);
					match(T__41);
					setState(587);
					((PostconditionConstraintContext)_localctx).ownedMessageSpecification = specification();
					setState(588);
					match(T__42);
					}
				}

				}
			}

			setState(594);
			match(T__2);
			setState(596);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(595);
				((PostconditionConstraintContext)_localctx).ownedSpecification = specification();
				}
			}

			setState(598);
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

	public static class SpecificationContext extends ParserRuleContext {
		public ExpressionContext ownedExpression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).enterSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlloyInEcoreListener ) ((AlloyInEcoreListener)listener).exitSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			((SpecificationContext)_localctx).ownedExpression = expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 44, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
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
			setState(604);
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
			setState(606);
			((QualifiedNameContext)_localctx).identifier = identifier();
			((QualifiedNameContext)_localctx).firstPart.add(((QualifiedNameContext)_localctx).identifier);
			setState(616);
			_la = _input.LA(1);
			if (_la==T__72) {
				{
				setState(611);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(607);
						match(T__72);
						setState(608);
						((QualifiedNameContext)_localctx).identifier = identifier();
						((QualifiedNameContext)_localctx).midPart.add(((QualifiedNameContext)_localctx).identifier);
						}
						} 
					}
					setState(613);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
				}
				{
				setState(614);
				match(T__72);
				setState(615);
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
			setState(618);
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
			setState(620);
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
			setState(622);
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
			setState(625);
			_la = _input.LA(1);
			if (_la==T__73) {
				{
				setState(624);
				match(T__73);
				}
			}

			setState(627);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3S\u0278\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\5\2?\n\2\3"+
		"\2\7\2B\n\2\f\2\16\2E\13\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\3\3\3\3\3\3\3"+
		"\5\3Q\n\3\3\3\3\3\3\3\3\4\5\4W\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4d\n\4\f\4\16\4g\13\4\3\4\3\4\5\4k\n\4\3\5\3\5\3\5\5\5p\n\5"+
		"\3\6\5\6s\n\6\3\6\5\6v\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6~\n\6\f\6\16\6\u0081"+
		"\13\6\5\6\u0083\n\6\3\6\3\6\5\6\u0087\n\6\3\6\3\6\5\6\u008b\n\6\3\6\5"+
		"\6\u008e\n\6\3\6\3\6\3\6\3\6\7\6\u0094\n\6\f\6\16\6\u0097\13\6\3\6\3\6"+
		"\5\6\u009b\n\6\3\7\3\7\5\7\u009f\n\7\3\b\5\b\u00a2\n\b\3\b\5\b\u00a5\n"+
		"\b\3\b\3\b\3\b\3\b\5\b\u00ab\n\b\3\b\3\b\3\b\5\b\u00b0\n\b\5\b\u00b2\n"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\b\u00c5\n\b\3\b\5\b\u00c8\n\b\6\b\u00ca\n\b\r\b\16\b\u00cb\3\b\5\b"+
		"\u00cf\n\b\3\b\3\b\3\b\5\b\u00d4\n\b\3\b\3\b\5\b\u00d8\n\b\3\b\3\b\3\b"+
		"\5\b\u00dd\n\b\3\b\3\b\5\b\u00e1\n\b\3\b\7\b\u00e4\n\b\f\b\16\b\u00e7"+
		"\13\b\3\b\3\b\5\b\u00eb\n\b\3\t\5\t\u00ee\n\t\3\t\5\t\u00f1\n\t\3\t\3"+
		"\t\3\t\3\t\5\t\u00f7\n\t\3\t\3\t\3\t\5\t\u00fc\n\t\5\t\u00fe\n\t\3\t\3"+
		"\t\5\t\u0102\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u0117\n\t\3\t\5\t\u011a\n\t\6\t\u011c\n\t\r"+
		"\t\16\t\u011d\3\t\5\t\u0121\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u0128\n\t\f\t"+
		"\16\t\u012b\13\t\3\t\3\t\3\t\3\t\5\t\u0131\n\t\3\t\3\t\5\t\u0135\n\t\3"+
		"\t\3\t\3\t\5\t\u013a\n\t\3\t\3\t\5\t\u013e\n\t\3\t\7\t\u0141\n\t\f\t\16"+
		"\t\u0144\13\t\3\t\3\t\5\t\u0148\n\t\3\n\5\n\u014b\n\n\3\n\5\n\u014e\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0156\n\n\f\n\16\n\u0159\13\n\5\n\u015b"+
		"\n\n\3\n\3\n\3\n\3\n\5\n\u0161\n\n\5\n\u0163\n\n\3\n\3\n\3\n\3\n\7\n\u0169"+
		"\n\n\f\n\16\n\u016c\13\n\5\n\u016e\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u0177\n\n\3\n\5\n\u017a\n\n\6\n\u017c\n\n\r\n\16\n\u017d\3\n\5\n\u0181"+
		"\n\n\3\n\3\n\3\n\3\n\7\n\u0187\n\n\f\n\16\n\u018a\13\n\3\n\3\n\5\n\u018e"+
		"\n\n\3\13\3\13\3\13\3\13\5\13\u0194\n\13\5\13\u0196\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u019d\n\13\3\13\5\13\u01a0\n\13\6\13\u01a2\n\13\r\13\16"+
		"\13\u01a3\3\13\5\13\u01a7\n\13\3\f\3\f\5\f\u01ab\n\f\3\r\3\r\3\r\3\r\5"+
		"\r\u01b1\n\r\3\r\5\r\u01b4\n\r\3\r\3\r\3\16\5\16\u01b9\n\16\3\16\3\16"+
		"\3\16\5\16\u01be\n\16\3\16\3\16\5\16\u01c2\n\16\3\16\3\16\3\16\5\16\u01c7"+
		"\n\16\3\16\5\16\u01ca\n\16\3\16\3\16\7\16\u01ce\n\16\f\16\16\16\u01d1"+
		"\13\16\3\16\3\16\5\16\u01d5\n\16\3\17\3\17\3\20\5\20\u01da\n\20\3\20\3"+
		"\20\3\20\5\20\u01df\n\20\3\20\3\20\5\20\u01e3\n\20\3\20\3\20\3\20\5\20"+
		"\u01e8\n\20\3\20\5\20\u01eb\n\20\3\20\3\20\3\20\7\20\u01f0\n\20\f\20\16"+
		"\20\u01f3\13\20\3\20\3\20\5\20\u01f7\n\20\3\21\3\21\3\21\5\21\u01fc\n"+
		"\21\3\21\3\21\5\21\u0200\n\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u0208"+
		"\n\22\f\22\16\22\u020b\13\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0213"+
		"\n\22\f\22\16\22\u0216\13\22\3\22\3\22\5\22\u021a\n\22\3\23\3\23\5\23"+
		"\u021e\n\23\3\23\3\23\5\23\u0222\n\23\3\23\3\23\3\24\5\24\u0227\n\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\5\24\u022f\n\24\5\24\u0231\n\24\3\24\3\24"+
		"\5\24\u0235\n\24\3\24\3\24\5\24\u0239\n\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\5\25\u0241\n\25\5\25\u0243\n\25\3\25\3\25\5\25\u0247\n\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0251\n\26\5\26\u0253\n\26\3\26\3"+
		"\26\5\26\u0257\n\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\32\7\32\u0264\n\32\f\32\16\32\u0267\13\32\3\32\3\32\5\32\u026b\n\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\5\36\u0274\n\36\3\36\3\36\3\36\2\2"+
		"\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\6"+
		"\3\2\61\63\3\29=\4\2\7\7HJ\4\2\61\61MM\u02f6\2>\3\2\2\2\4L\3\2\2\2\6V"+
		"\3\2\2\2\bo\3\2\2\2\nr\3\2\2\2\f\u009e\3\2\2\2\16\u00a1\3\2\2\2\20\u00ed"+
		"\3\2\2\2\22\u014a\3\2\2\2\24\u018f\3\2\2\2\26\u01aa\3\2\2\2\30\u01ac\3"+
		"\2\2\2\32\u01b8\3\2\2\2\34\u01d6\3\2\2\2\36\u01d9\3\2\2\2 \u01fb\3\2\2"+
		"\2\"\u0219\3\2\2\2$\u021b\3\2\2\2&\u0226\3\2\2\2(\u023a\3\2\2\2*\u024a"+
		"\3\2\2\2,\u025a\3\2\2\2.\u025c\3\2\2\2\60\u025e\3\2\2\2\62\u0260\3\2\2"+
		"\2\64\u026c\3\2\2\2\66\u026e\3\2\2\28\u0270\3\2\2\2:\u0273\3\2\2\2<=\7"+
		"\3\2\2=?\5\64\33\2><\3\2\2\2>?\3\2\2\2?C\3\2\2\2@B\5\4\3\2A@\3\2\2\2B"+
		"E\3\2\2\2CA\3\2\2\2CD\3\2\2\2DI\3\2\2\2EC\3\2\2\2FH\5\6\4\2GF\3\2\2\2"+
		"HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\3\3\2\2\2KI\3\2\2\2LP\7\4\2\2MN\5\64\33"+
		"\2NO\7\5\2\2OQ\3\2\2\2PM\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\7P\2\2ST\7\6\2"+
		"\2T\5\3\2\2\2UW\5\60\31\2VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\7\7\2\2YZ\5"+
		"\64\33\2Z[\7\5\2\2[\\\5\64\33\2\\]\3\2\2\2]^\7\b\2\2^_\7P\2\2_j\3\2\2"+
		"\2`e\7\t\2\2ad\5\6\4\2bd\5\b\5\2ca\3\2\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2"+
		"\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hk\7\n\2\2ik\7\6\2\2j`\3\2\2\2ji\3\2\2"+
		"\2k\7\3\2\2\2lp\5\n\6\2mp\5\32\16\2np\5\36\20\2ol\3\2\2\2om\3\2\2\2on"+
		"\3\2\2\2p\t\3\2\2\2qs\5\60\31\2rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tv\7\13\2"+
		"\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\7\f\2\2x\u0082\5\64\33\2yz\7\r\2\2"+
		"z\177\5\62\32\2{|\7\16\2\2|~\5\62\32\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3"+
		"\2\2\2\177\u0080\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0082y"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0085\7\5\2\2\u0085"+
		"\u0087\7P\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008d\3\2"+
		"\2\2\u0088\u008a\7\t\2\2\u0089\u008b\7\17\2\2\u008a\u0089\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\7\n\2\2\u008d\u0088\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u009a\3\2\2\2\u008f\u0095\7\t\2\2\u0090"+
		"\u0094\5\22\n\2\u0091\u0094\5\f\7\2\u0092\u0094\5&\24\2\u0093\u0090\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0098\u009b\7\n\2\2\u0099\u009b\7\6\2\2\u009a\u008f\3\2\2\2\u009a"+
		"\u0099\3\2\2\2\u009b\13\3\2\2\2\u009c\u009f\5\16\b\2\u009d\u009f\5\20"+
		"\t\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\r\3\2\2\2\u00a0\u00a2"+
		"\5\60\31\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2"+
		"\u00a3\u00a5\7\20\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a7\7\21\2\2\u00a7\u00aa\5\64\33\2\u00a8\u00a9\7\b\2"+
		"\2\u00a9\u00ab\7P\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00b1"+
		"\3\2\2\2\u00ac\u00ad\7\5\2\2\u00ad\u00af\5\26\f\2\u00ae\u00b0\5\30\r\2"+
		"\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00ac"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00ce\3\2\2\2\u00b3\u00c9\7\t\2\2\u00b4"+
		"\u00c5\7\22\2\2\u00b5\u00c5\7\23\2\2\u00b6\u00c5\7\24\2\2\u00b7\u00c5"+
		"\7\25\2\2\u00b8\u00c5\7\26\2\2\u00b9\u00c5\7\27\2\2\u00ba\u00c5\7\30\2"+
		"\2\u00bb\u00c5\7\31\2\2\u00bc\u00c5\7\32\2\2\u00bd\u00c5\7\33\2\2\u00be"+
		"\u00c5\7\34\2\2\u00bf\u00c5\7\35\2\2\u00c0\u00c5\7\36\2\2\u00c1\u00c5"+
		"\7\37\2\2\u00c2\u00c5\7 \2\2\u00c3\u00c5\7!\2\2\u00c4\u00b4\3\2\2\2\u00c4"+
		"\u00b5\3\2\2\2\u00c4\u00b6\3\2\2\2\u00c4\u00b7\3\2\2\2\u00c4\u00b8\3\2"+
		"\2\2\u00c4\u00b9\3\2\2\2\u00c4\u00ba\3\2\2\2\u00c4\u00bb\3\2\2\2\u00c4"+
		"\u00bc\3\2\2\2\u00c4\u00bd\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4\u00bf\3\2"+
		"\2\2\u00c4\u00c0\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c8\7\16\2\2\u00c7\u00c6\3"+
		"\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c4\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00cf\7\n\2\2\u00ce\u00b3\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00ea\3\2\2\2\u00d0\u00e5\7\t\2\2\u00d1\u00d3\7\"\2\2\u00d2\u00d4\5\64"+
		"\33\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d7\7\5\2\2\u00d6\u00d8\5,\27\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00e4\7\6\2\2\u00da\u00dc\7#\2\2\u00db"+
		"\u00dd\5\64\33\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3"+
		"\2\2\2\u00de\u00e0\7\5\2\2\u00df\u00e1\5,\27\2\u00e0\u00df\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\7\6\2\2\u00e3\u00d1\3\2"+
		"\2\2\u00e3\u00da\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\7\n"+
		"\2\2\u00e9\u00eb\7\6\2\2\u00ea\u00d0\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb"+
		"\17\3\2\2\2\u00ec\u00ee\5\60\31\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00f1\7\20\2\2\u00f0\u00ef\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\7$\2\2\u00f3\u00f6\5\64"+
		"\33\2\u00f4\u00f5\7%\2\2\u00f5\u00f7\5\64\33\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00fd\3\2\2\2\u00f8\u00f9\7\5\2\2\u00f9\u00fb\5\26"+
		"\f\2\u00fa\u00fc\5\30\r\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fe\3\2\2\2\u00fd\u00f8\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0101\3\2"+
		"\2\2\u00ff\u0100\7\b\2\2\u0100\u0102\7P\2\2\u0101\u00ff\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0120\3\2\2\2\u0103\u011b\7\t\2\2\u0104\u0117\7&"+
		"\2\2\u0105\u0117\7\'\2\2\u0106\u0117\7\22\2\2\u0107\u0117\7\23\2\2\u0108"+
		"\u0117\7\26\2\2\u0109\u0117\7\27\2\2\u010a\u0117\7\30\2\2\u010b\u0117"+
		"\7\31\2\2\u010c\u0117\7(\2\2\u010d\u0117\7)\2\2\u010e\u0117\7\32\2\2\u010f"+
		"\u0117\7\33\2\2\u0110\u0117\7\34\2\2\u0111\u0117\7\35\2\2\u0112\u0117"+
		"\7\36\2\2\u0113\u0117\7\37\2\2\u0114\u0117\7 \2\2\u0115\u0117\7!\2\2\u0116"+
		"\u0104\3\2\2\2\u0116\u0105\3\2\2\2\u0116\u0106\3\2\2\2\u0116\u0107\3\2"+
		"\2\2\u0116\u0108\3\2\2\2\u0116\u0109\3\2\2\2\u0116\u010a\3\2\2\2\u0116"+
		"\u010b\3\2\2\2\u0116\u010c\3\2\2\2\u0116\u010d\3\2\2\2\u0116\u010e\3\2"+
		"\2\2\u0116\u010f\3\2\2\2\u0116\u0110\3\2\2\2\u0116\u0111\3\2\2\2\u0116"+
		"\u0112\3\2\2\2\u0116\u0113\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0115\3\2"+
		"\2\2\u0117\u0119\3\2\2\2\u0118\u011a\7\16\2\2\u0119\u0118\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0116\3\2\2\2\u011c\u011d\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0121\7\n\2\2\u0120\u0103\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0147\3\2"+
		"\2\2\u0122\u0142\7\t\2\2\u0123\u0124\7*\2\2\u0124\u0129\5\62\32\2\u0125"+
		"\u0126\7\16\2\2\u0126\u0128\5\62\32\2\u0127\u0125\3\2\2\2\u0128\u012b"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012c\u012d\7\6\2\2\u012d\u0141\3\2\2\2\u012e\u0130\7\""+
		"\2\2\u012f\u0131\5\64\33\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0134\7\5\2\2\u0133\u0135\5,\27\2\u0134\u0133\3\2"+
		"\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0141\7\6\2\2\u0137"+
		"\u0139\7#\2\2\u0138\u013a\5\64\33\2\u0139\u0138\3\2\2\2\u0139\u013a\3"+
		"\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\7\5\2\2\u013c\u013e\5,\27\2\u013d"+
		"\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141\7\6"+
		"\2\2\u0140\u0123\3\2\2\2\u0140\u012e\3\2\2\2\u0140\u0137\3\2\2\2\u0141"+
		"\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2"+
		"\2\2\u0144\u0142\3\2\2\2\u0145\u0148\7\n\2\2\u0146\u0148\7\6\2\2\u0147"+
		"\u0122\3\2\2\2\u0147\u0146\3\2\2\2\u0148\21\3\2\2\2\u0149\u014b\5\60\31"+
		"\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014d\3\2\2\2\u014c\u014e"+
		"\7\20\2\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2\2\2"+
		"\u014f\u0150\7+\2\2\u0150\u0151\5\64\33\2\u0151\u015a\7,\2\2\u0152\u0157"+
		"\5\24\13\2\u0153\u0154\7\16\2\2\u0154\u0156\5\24\13\2\u0155\u0153\3\2"+
		"\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u0152\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c\u0162\7-\2\2\u015d\u015e\7\5\2\2\u015e"+
		"\u0160\5\26\f\2\u015f\u0161\5\30\r\2\u0160\u015f\3\2\2\2\u0160\u0161\3"+
		"\2\2\2\u0161\u0163\3\2\2\2\u0162\u015d\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u016d\3\2\2\2\u0164\u0165\7.\2\2\u0165\u016a\5\64\33\2\u0166\u0167\7"+
		"\16\2\2\u0167\u0169\5\64\33\2\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2"+
		"\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a"+
		"\3\2\2\2\u016d\u0164\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0180\3\2\2\2\u016f"+
		"\u017b\7\t\2\2\u0170\u0177\7\22\2\2\u0171\u0177\7\23\2\2\u0172\u0177\7"+
		"\26\2\2\u0173\u0177\7\27\2\2\u0174\u0177\7\34\2\2\u0175\u0177\7\35\2\2"+
		"\u0176\u0170\3\2\2\2\u0176\u0171\3\2\2\2\u0176\u0172\3\2\2\2\u0176\u0173"+
		"\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0175\3\2\2\2\u0177\u0179\3\2\2\2\u0178"+
		"\u017a\7\16\2\2\u0179\u0178\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c\3"+
		"\2\2\2\u017b\u0176\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017b\3\2\2\2\u017d"+
		"\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\7\n\2\2\u0180\u016f\3\2"+
		"\2\2\u0180\u0181\3\2\2\2\u0181\u018d\3\2\2\2\u0182\u0188\7\t\2\2\u0183"+
		"\u0187\5(\25\2\u0184\u0187\5$\23\2\u0185\u0187\5*\26\2\u0186\u0183\3\2"+
		"\2\2\u0186\u0184\3\2\2\2\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018b\3\2\2\2\u018a\u0188\3\2"+
		"\2\2\u018b\u018e\7\n\2\2\u018c\u018e\7\6\2\2\u018d\u0182\3\2\2\2\u018d"+
		"\u018c\3\2\2\2\u018e\23\3\2\2\2\u018f\u0195\5\64\33\2\u0190\u0191\7\5"+
		"\2\2\u0191\u0193\5\26\f\2\u0192\u0194\5\30\r\2\u0193\u0192\3\2\2\2\u0193"+
		"\u0194\3\2\2\2\u0194\u0196\3\2\2\2\u0195\u0190\3\2\2\2\u0195\u0196\3\2"+
		"\2\2\u0196\u01a6\3\2\2\2\u0197\u01a1\7\t\2\2\u0198\u019d\7\26\2\2\u0199"+
		"\u019d\7\27\2\2\u019a\u019d\7\34\2\2\u019b\u019d\7\35\2\2\u019c\u0198"+
		"\3\2\2\2\u019c\u0199\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019b\3\2\2\2\u019d"+
		"\u019f\3\2\2\2\u019e\u01a0\7\16\2\2\u019f\u019e\3\2\2\2\u019f\u01a0\3"+
		"\2\2\2\u01a0\u01a2\3\2\2\2\u01a1\u019c\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a7\7\n"+
		"\2\2\u01a6\u0197\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\25\3\2\2\2\u01a8\u01ab"+
		"\5\34\17\2\u01a9\u01ab\5\62\32\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2\2"+
		"\2\u01ab\27\3\2\2\2\u01ac\u01b3\7/\2\2\u01ad\u01b0\58\35\2\u01ae\u01af"+
		"\7\60\2\2\u01af\u01b1\5\66\34\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2"+
		"\2\u01b1\u01b4\3\2\2\2\u01b2\u01b4\t\2\2\2\u01b3\u01ad\3\2\2\2\u01b3\u01b2"+
		"\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\7\64\2\2\u01b6\31\3\2\2\2\u01b7"+
		"\u01b9\7\65\2\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3"+
		"\2\2\2\u01ba\u01bb\7\66\2\2\u01bb\u01bd\5\64\33\2\u01bc\u01be\5\"\22\2"+
		"\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01c0"+
		"\7\5\2\2\u01c0\u01c2\7P\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\u01c9\3\2\2\2\u01c3\u01c6\7\t\2\2\u01c4\u01c7\7\67\2\2\u01c5\u01c7\7"+
		"8\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"\u01c8\3\2\2\2\u01c8\u01ca\7\n\2\2\u01c9\u01c3\3\2\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca\u01d4\3\2\2\2\u01cb\u01cf\7\t\2\2\u01cc\u01ce\5&\24\2\u01cd"+
		"\u01cc\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0\3\2"+
		"\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2\u01d5\7\n\2\2\u01d3"+
		"\u01d5\7\6\2\2\u01d4\u01cb\3\2\2\2\u01d4\u01d3\3\2\2\2\u01d5\33\3\2\2"+
		"\2\u01d6\u01d7\t\3\2\2\u01d7\35\3\2\2\2\u01d8\u01da\5\60\31\2\u01d9\u01d8"+
		"\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\7>\2\2\u01dc"+
		"\u01de\5\64\33\2\u01dd\u01df\5\"\22\2\u01de\u01dd\3\2\2\2\u01de\u01df"+
		"\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01e1\7\5\2\2\u01e1\u01e3\7P\2\2\u01e2"+
		"\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01ea\3\2\2\2\u01e4\u01e7\7\t"+
		"\2\2\u01e5\u01e8\7\67\2\2\u01e6\u01e8\78\2\2\u01e7\u01e5\3\2\2\2\u01e7"+
		"\u01e6\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\7\n"+
		"\2\2\u01ea\u01e4\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01f6\3\2\2\2\u01ec"+
		"\u01f1\7\t\2\2\u01ed\u01f0\5 \21\2\u01ee\u01f0\5&\24\2\u01ef\u01ed\3\2"+
		"\2\2\u01ef\u01ee\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1"+
		"\u01f2\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\u01f7\7\n"+
		"\2\2\u01f5\u01f7\7\6\2\2\u01f6\u01ec\3\2\2\2\u01f6\u01f5\3\2\2\2\u01f7"+
		"\37\3\2\2\2\u01f8\u01f9\7?\2\2\u01f9\u01fc\5\64\33\2\u01fa\u01fc\5\64"+
		"\33\2\u01fb\u01f8\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd"+
		"\u01fe\7\b\2\2\u01fe\u0200\5:\36\2\u01ff\u01fd\3\2\2\2\u01ff\u0200\3\2"+
		"\2\2\u0200\u0201\3\2\2\2\u0201\u0202\7\6\2\2\u0202!\3\2\2\2\u0203\u0204"+
		"\7,\2\2\u0204\u0209\5\64\33\2\u0205\u0206\7\16\2\2\u0206\u0208\5\64\33"+
		"\2\u0207\u0205\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a"+
		"\3\2\2\2\u020a\u020c\3\2\2\2\u020b\u0209\3\2\2\2\u020c\u020d\7-\2\2\u020d"+
		"\u021a\3\2\2\2\u020e\u020f\7@\2\2\u020f\u0214\5\64\33\2\u0210\u0211\7"+
		"\16\2\2\u0211\u0213\5\64\33\2\u0212\u0210\3\2\2\2\u0213\u0216\3\2\2\2"+
		"\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0217\3\2\2\2\u0216\u0214"+
		"\3\2\2\2\u0217\u0218\7A\2\2\u0218\u021a\3\2\2\2\u0219\u0203\3\2\2\2\u0219"+
		"\u020e\3\2\2\2\u021a#\3\2\2\2\u021b\u021d\7B\2\2\u021c\u021e\5\64\33\2"+
		"\u021d\u021c\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0221"+
		"\7\5\2\2\u0220\u0222\5,\27\2\u0221\u0220\3\2\2\2\u0221\u0222\3\2\2\2\u0222"+
		"\u0223\3\2\2\2\u0223\u0224\7\6\2\2\u0224%\3\2\2\2\u0225\u0227\7C\2\2\u0226"+
		"\u0225\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u0230\7D"+
		"\2\2\u0229\u022e\5\64\33\2\u022a\u022b\7,\2\2\u022b\u022c\5,\27\2\u022c"+
		"\u022d\7-\2\2\u022d\u022f\3\2\2\2\u022e\u022a\3\2\2\2\u022e\u022f\3\2"+
		"\2\2\u022f\u0231\3\2\2\2\u0230\u0229\3\2\2\2\u0230\u0231\3\2\2\2\u0231"+
		"\u0238\3\2\2\2\u0232\u0234\7\5\2\2\u0233\u0235\5,\27\2\u0234\u0233\3\2"+
		"\2\2\u0234\u0235\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0239\7\6\2\2\u0237"+
		"\u0239\7\6\2\2\u0238\u0232\3\2\2\2\u0238\u0237\3\2\2\2\u0239\'\3\2\2\2"+
		"\u023a\u0242\7E\2\2\u023b\u0240\5\64\33\2\u023c\u023d\7,\2\2\u023d\u023e"+
		"\5,\27\2\u023e\u023f\7-\2\2\u023f\u0241\3\2\2\2\u0240\u023c\3\2\2\2\u0240"+
		"\u0241\3\2\2\2\u0241\u0243\3\2\2\2\u0242\u023b\3\2\2\2\u0242\u0243\3\2"+
		"\2\2\u0243\u0244\3\2\2\2\u0244\u0246\7\5\2\2\u0245\u0247\5,\27\2\u0246"+
		"\u0245\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0249\7\6"+
		"\2\2\u0249)\3\2\2\2\u024a\u0252\7F\2\2\u024b\u0250\5\64\33\2\u024c\u024d"+
		"\7,\2\2\u024d\u024e\5,\27\2\u024e\u024f\7-\2\2\u024f\u0251\3\2\2\2\u0250"+
		"\u024c\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0253\3\2\2\2\u0252\u024b\3\2"+
		"\2\2\u0252\u0253\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0256\7\5\2\2\u0255"+
		"\u0257\5,\27\2\u0256\u0255\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258\3\2"+
		"\2\2\u0258\u0259\7\6\2\2\u0259+\3\2\2\2\u025a\u025b\5.\30\2\u025b-\3\2"+
		"\2\2\u025c\u025d\7G\2\2\u025d/\3\2\2\2\u025e\u025f\t\4\2\2\u025f\61\3"+
		"\2\2\2\u0260\u026a\5\64\33\2\u0261\u0262\7K\2\2\u0262\u0264\5\64\33\2"+
		"\u0263\u0261\3\2\2\2\u0264\u0267\3\2\2\2\u0265\u0263\3\2\2\2\u0265\u0266"+
		"\3\2\2\2\u0266\u0268\3\2\2\2\u0267\u0265\3\2\2\2\u0268\u0269\7K\2\2\u0269"+
		"\u026b\5\64\33\2\u026a\u0265\3\2\2\2\u026a\u026b\3\2\2\2\u026b\63\3\2"+
		"\2\2\u026c\u026d\7N\2\2\u026d\65\3\2\2\2\u026e\u026f\t\5\2\2\u026f\67"+
		"\3\2\2\2\u0270\u0271\7M\2\2\u02719\3\2\2\2\u0272\u0274\7L\2\2\u0273\u0272"+
		"\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0276\7M\2\2\u0276"+
		";\3\2\2\2t>CIPVcejoru\177\u0082\u0086\u008a\u008d\u0093\u0095\u009a\u009e"+
		"\u00a1\u00a4\u00aa\u00af\u00b1\u00c4\u00c7\u00cb\u00ce\u00d3\u00d7\u00dc"+
		"\u00e0\u00e3\u00e5\u00ea\u00ed\u00f0\u00f6\u00fb\u00fd\u0101\u0116\u0119"+
		"\u011d\u0120\u0129\u0130\u0134\u0139\u013d\u0140\u0142\u0147\u014a\u014d"+
		"\u0157\u015a\u0160\u0162\u016a\u016d\u0176\u0179\u017d\u0180\u0186\u0188"+
		"\u018d\u0193\u0195\u019c\u019f\u01a3\u01a6\u01aa\u01b0\u01b3\u01b8\u01bd"+
		"\u01c1\u01c6\u01c9\u01cf\u01d4\u01d9\u01de\u01e2\u01e7\u01ea\u01ef\u01f1"+
		"\u01f6\u01fb\u01ff\u0209\u0214\u0219\u021d\u0221\u0226\u022e\u0230\u0234"+
		"\u0238\u0240\u0242\u0246\u0250\u0252\u0256\u0265\u026a\u0273";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}