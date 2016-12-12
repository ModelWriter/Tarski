// Generated from /home/ferhat/IdeaProjects/Test/src/AlloyInEcore.g4 by ANTLR 4.5.3
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
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, INT=73, IDENTIFIER=74, 
		DOUBLE_QUOTED_STRING=75, SINGLE_QUOTED_STRING=76, MULTILINE_COMMENT=77, 
		SINGLELINE_COMMENT=78, WS=79;
	public static final int
		RULE_module = 0, RULE_packageImport = 1, RULE_ePackage = 2, RULE_eClassifier = 3, 
		RULE_eClass = 4, RULE_eStructuralFeature = 5, RULE_eAttribute = 6, RULE_eReference = 7, 
		RULE_eOperation = 8, RULE_eParameter = 9, RULE_eType = 10, RULE_eMultiplicity = 11, 
		RULE_eDataType = 12, RULE_ePrimitiveType = 13, RULE_eEnum = 14, RULE_eEnumLiteral = 15, 
		RULE_templateSignature = 16, RULE_invariantConstraint = 17, RULE_preconditionConstraint = 18, 
		RULE_postconditionConstraint = 19, RULE_specification = 20, RULE_expression = 21, 
		RULE_visibilityKind = 22, RULE_qualifiedName = 23, RULE_identifier = 24, 
		RULE_upper = 25, RULE_lower = 26, RULE_signed = 27;
	public static final String[] ruleNames = {
		"module", "packageImport", "ePackage", "eClassifier", "eClass", "eStructuralFeature", 
		"eAttribute", "eReference", "eOperation", "eParameter", "eType", "eMultiplicity", 
		"eDataType", "ePrimitiveType", "eEnum", "eEnumLiteral", "templateSignature", 
		"invariantConstraint", "preconditionConstraint", "postconditionConstraint", 
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
		"')'", "'throws'", "'body'", "'['", "'..'", "'*'", "'+'", "'?'", "']'", 
		"'primitive'", "'datatype'", "'serializable'", "'!serializable'", "'Boolean'", 
		"'Integer'", "'String'", "'enum'", "'literal'", "'<'", "'>'", "'callable'", 
		"'invariant'", "'precondition'", "'postcondition'", "'expr'", "'public'", 
		"'protected'", "'private'", "'::'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", 
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
			setState(58);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(56);
				match(T__0);
				setState(57);
				identifier();
				}
			}

			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(60);
				((ModuleContext)_localctx).packageImport = packageImport();
				((ModuleContext)_localctx).ownedPackageImport.add(((ModuleContext)_localctx).packageImport);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__68 - 68)) | (1L << (T__69 - 68)))) != 0)) {
				{
				{
				setState(66);
				((ModuleContext)_localctx).ePackage = ePackage();
				((ModuleContext)_localctx).ownedPackage.add(((ModuleContext)_localctx).ePackage);
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        for (EPackageContext ePackageCtx : ((ModuleContext)_localctx).ownedPackage) {
			            String name = ePackageCtx.name.getText();
			          	System.out.println("ePackage: " + name);
			            org.eclipse.emf.ecore.EPackage ePackage = _eCoreFactory.createEPackage();
			            ePackage.setName(name);
			            ePackage.setNsPrefix(ePackageCtx.nsPrefix.getText());
			            ePackage.setNsURI(ePackageCtx.nsURI.getText());
			            //ePackageNames.add(ePackage);
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
		public VisibilityKindContext visibiliry;
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
				((EPackageContext)_localctx).visibiliry = visibilityKind();
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__51) | (1L << T__52) | (1L << T__58))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__68 - 68)) | (1L << (T__69 - 68)))) != 0)) {
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

			        for (EPackageContext ePackageCtx : ((EPackageContext)_localctx).eSubPackages) {
			            String name = ePackageCtx.name.getText();
			          	System.out.println("ePackage: " + name);
			            org.eclipse.emf.ecore.EPackage ePackage = _eCoreFactory.createEPackage();
			            ePackage.setName(name);
			            ePackage.setNsPrefix(ePackageCtx.nsPrefix.getText());
			            ePackage.setNsURI(ePackageCtx.nsURI.getText());
			//          ePackageNames.add(ePackage.getName());
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEClassifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EClassifierContext eClassifier() throws RecognitionException {
		EClassifierContext _localctx = new EClassifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_eClassifier);
		try {
			setState(111);
			switch (_input.LA(1)) {
			case T__4:
			case T__8:
			case T__9:
			case T__67:
			case T__68:
			case T__69:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				eClass();
				}
				break;
			case T__51:
			case T__52:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				eDataType();
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				eEnum();
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

	public static class EClassContext extends ParserRuleContext {
		public VisibilityKindContext visibiliry;
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
			setState(114);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__68 - 68)) | (1L << (T__69 - 68)))) != 0)) {
				{
				setState(113);
				((EClassContext)_localctx).visibiliry = visibilityKind();
				}
			}

			setState(117);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(116);
				((EClassContext)_localctx).isAbstract = match(T__8);
				}
			}

			setState(119);
			match(T__9);
			setState(120);
			((EClassContext)_localctx).name = identifier();
			setState(130);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(121);
				match(T__10);
				setState(122);
				((EClassContext)_localctx).qualifiedName = qualifiedName();
				((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(123);
					match(T__11);
					setState(124);
					((EClassContext)_localctx).qualifiedName = qualifiedName();
					((EClassContext)_localctx).eSuperTypes.add(((EClassContext)_localctx).qualifiedName);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(134);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(132);
				match(T__2);
				setState(133);
				((EClassContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(136);
				match(T__6);
				setState(138);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(137);
					((EClassContext)_localctx).isInterface = match(T__12);
					}
				}

				setState(140);
				match(T__7);
				}
				break;
			}
			setState(154);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(143);
				match(T__6);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__13) | (1L << T__14) | (1L << T__33) | (1L << T__40) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)))) != 0)) {
					{
					setState(147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(144);
						((EClassContext)_localctx).eOperation = eOperation();
						((EClassContext)_localctx).eOperations.add(((EClassContext)_localctx).eOperation);
						}
						break;
					case 2:
						{
						setState(145);
						((EClassContext)_localctx).eStructuralFeature = eStructuralFeature();
						((EClassContext)_localctx).eStructuralFeatures.add(((EClassContext)_localctx).eStructuralFeature);
						}
						break;
					case 3:
						{
						setState(146);
						((EClassContext)_localctx).invariantConstraint = invariantConstraint();
						((EClassContext)_localctx).eConstraints.add(((EClassContext)_localctx).invariantConstraint);
						}
						break;
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(153);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEStructuralFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EStructuralFeatureContext eStructuralFeature() throws RecognitionException {
		EStructuralFeatureContext _localctx = new EStructuralFeatureContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_eStructuralFeature);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				eAttribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
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
		public VisibilityKindContext visibiliry;
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
			setState(161);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__68 - 68)) | (1L << (T__69 - 68)))) != 0)) {
				{
				setState(160);
				((EAttributeContext)_localctx).visibiliry = visibilityKind();
				}
			}

			setState(164);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(163);
				((EAttributeContext)_localctx).s14 = match(T__13);
				((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s14);
				}
			}

			setState(166);
			match(T__14);
			setState(167);
			((EAttributeContext)_localctx).name = identifier();
			setState(170);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(168);
				match(T__5);
				setState(169);
				((EAttributeContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(177);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(172);
				match(T__2);
				setState(173);
				((EAttributeContext)_localctx).eAttributeType = eType();
				setState(175);
				_la = _input.LA(1);
				if (_la==T__45) {
					{
					setState(174);
					((EAttributeContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(179);
				match(T__6);
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(196);
					switch (_input.LA(1)) {
					case T__15:
						{
						setState(180);
						((EAttributeContext)_localctx).s16 = match(T__15);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(181);
						((EAttributeContext)_localctx).s17 = match(T__16);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s17);
						}
						break;
					case T__17:
						{
						setState(182);
						((EAttributeContext)_localctx).s18 = match(T__17);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s18);
						}
						break;
					case T__18:
						{
						setState(183);
						((EAttributeContext)_localctx).s19 = match(T__18);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s19);
						}
						break;
					case T__19:
						{
						setState(184);
						((EAttributeContext)_localctx).s20 = match(T__19);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(185);
						((EAttributeContext)_localctx).s21 = match(T__20);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s21);
						}
						break;
					case T__21:
						{
						setState(186);
						((EAttributeContext)_localctx).s22 = match(T__21);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s22);
						}
						break;
					case T__22:
						{
						setState(187);
						((EAttributeContext)_localctx).s23 = match(T__22);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s23);
						}
						break;
					case T__23:
						{
						setState(188);
						((EAttributeContext)_localctx).s24 = match(T__23);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s24);
						}
						break;
					case T__24:
						{
						setState(189);
						((EAttributeContext)_localctx).s25 = match(T__24);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s25);
						}
						break;
					case T__25:
						{
						setState(190);
						((EAttributeContext)_localctx).s26 = match(T__25);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(191);
						((EAttributeContext)_localctx).s27 = match(T__26);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s27);
						}
						break;
					case T__27:
						{
						setState(192);
						((EAttributeContext)_localctx).s28 = match(T__27);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(193);
						((EAttributeContext)_localctx).s29 = match(T__28);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(194);
						((EAttributeContext)_localctx).s30 = match(T__29);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(195);
						((EAttributeContext)_localctx).s31 = match(T__30);
						((EAttributeContext)_localctx).qualifier.add(((EAttributeContext)_localctx).s31);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(199);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(198);
						match(T__11);
						}
					}

					}
					}
					setState(203); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0) );
				setState(205);
				match(T__7);
				}
				break;
			}
			setState(234);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(208);
				match(T__6);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__31 || _la==T__32) {
					{
					setState(227);
					switch (_input.LA(1)) {
					case T__31:
						{
						{
						setState(209);
						match(T__31);
						setState(211);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(210);
							identifier();
							}
						}

						setState(213);
						match(T__2);
						setState(215);
						_la = _input.LA(1);
						if (_la==T__66) {
							{
							setState(214);
							((EAttributeContext)_localctx).specification = specification();
							((EAttributeContext)_localctx).ownedDefaultExpression.add(((EAttributeContext)_localctx).specification);
							}
						}

						setState(217);
						match(T__3);
						}
						}
						break;
					case T__32:
						{
						{
						setState(218);
						match(T__32);
						setState(220);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(219);
							identifier();
							}
						}

						setState(222);
						match(T__2);
						setState(224);
						_la = _input.LA(1);
						if (_la==T__66) {
							{
							setState(223);
							((EAttributeContext)_localctx).specification = specification();
							((EAttributeContext)_localctx).ownedDefaultExpression.add(((EAttributeContext)_localctx).specification);
							}
						}

						setState(226);
						match(T__3);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(232);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(233);
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
		public VisibilityKindContext visibiliry;
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
			setState(237);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__68 - 68)) | (1L << (T__69 - 68)))) != 0)) {
				{
				setState(236);
				((EReferenceContext)_localctx).visibiliry = visibilityKind();
				}
			}

			setState(240);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(239);
				((EReferenceContext)_localctx).s14 = match(T__13);
				((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s14);
				}
			}

			setState(242);
			match(T__33);
			setState(243);
			((EReferenceContext)_localctx).name = identifier();
			setState(246);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(244);
				match(T__34);
				setState(245);
				((EReferenceContext)_localctx).opposite = identifier();
				}
			}

			setState(253);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(248);
				match(T__2);
				setState(249);
				((EReferenceContext)_localctx).eReferenceType = eType();
				setState(251);
				_la = _input.LA(1);
				if (_la==T__45) {
					{
					setState(250);
					((EReferenceContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(257);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(255);
				match(T__5);
				setState(256);
				((EReferenceContext)_localctx).defaultValue = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(259);
				match(T__6);
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(278);
					switch (_input.LA(1)) {
					case T__35:
						{
						setState(260);
						((EReferenceContext)_localctx).s36 = match(T__35);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s36);
						}
						break;
					case T__36:
						{
						setState(261);
						((EReferenceContext)_localctx).s37 = match(T__36);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s37);
						}
						break;
					case T__15:
						{
						setState(262);
						((EReferenceContext)_localctx).s16 = match(T__15);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(263);
						((EReferenceContext)_localctx).s17 = match(T__16);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s17);
						}
						break;
					case T__19:
						{
						setState(264);
						((EReferenceContext)_localctx).s20 = match(T__19);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(265);
						((EReferenceContext)_localctx).s21 = match(T__20);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s21);
						}
						break;
					case T__21:
						{
						setState(266);
						((EReferenceContext)_localctx).s22 = match(T__21);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s22);
						}
						break;
					case T__22:
						{
						setState(267);
						((EReferenceContext)_localctx).s23 = match(T__22);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s23);
						}
						break;
					case T__37:
						{
						setState(268);
						((EReferenceContext)_localctx).s38 = match(T__37);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s38);
						}
						break;
					case T__38:
						{
						setState(269);
						((EReferenceContext)_localctx).s39 = match(T__38);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s39);
						}
						break;
					case T__23:
						{
						setState(270);
						((EReferenceContext)_localctx).s24 = match(T__23);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s24);
						}
						break;
					case T__24:
						{
						setState(271);
						((EReferenceContext)_localctx).s25 = match(T__24);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s25);
						}
						break;
					case T__25:
						{
						setState(272);
						((EReferenceContext)_localctx).s26 = match(T__25);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(273);
						((EReferenceContext)_localctx).s27 = match(T__26);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s27);
						}
						break;
					case T__27:
						{
						setState(274);
						((EReferenceContext)_localctx).s28 = match(T__27);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s28);
						}
						break;
					case T__28:
						{
						setState(275);
						((EReferenceContext)_localctx).s29 = match(T__28);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s29);
						}
						break;
					case T__29:
						{
						setState(276);
						((EReferenceContext)_localctx).s30 = match(T__29);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s30);
						}
						break;
					case T__30:
						{
						setState(277);
						((EReferenceContext)_localctx).s31 = match(T__30);
						((EReferenceContext)_localctx).qualifier.add(((EReferenceContext)_localctx).s31);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(281);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(280);
						match(T__11);
						}
					}

					}
					}
					setState(285); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0) );
				setState(287);
				match(T__7);
				}
				break;
			}
			setState(327);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(290);
				match(T__6);
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__39))) != 0)) {
					{
					setState(320);
					switch (_input.LA(1)) {
					case T__39:
						{
						{
						setState(291);
						match(T__39);
						setState(292);
						((EReferenceContext)_localctx).qualifiedName = qualifiedName();
						((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
						setState(297);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__11) {
							{
							{
							setState(293);
							match(T__11);
							setState(294);
							((EReferenceContext)_localctx).qualifiedName = qualifiedName();
							((EReferenceContext)_localctx).referredKeys.add(((EReferenceContext)_localctx).qualifiedName);
							}
							}
							setState(299);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(300);
						match(T__3);
						}
						}
						break;
					case T__31:
						{
						{
						setState(302);
						match(T__31);
						setState(304);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(303);
							identifier();
							}
						}

						setState(306);
						match(T__2);
						setState(308);
						_la = _input.LA(1);
						if (_la==T__66) {
							{
							setState(307);
							((EReferenceContext)_localctx).specification = specification();
							((EReferenceContext)_localctx).ownedDefaultExpressions.add(((EReferenceContext)_localctx).specification);
							}
						}

						setState(310);
						match(T__3);
						}
						}
						break;
					case T__32:
						{
						{
						setState(311);
						match(T__32);
						setState(313);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(312);
							identifier();
							}
						}

						setState(315);
						match(T__2);
						setState(317);
						_la = _input.LA(1);
						if (_la==T__66) {
							{
							setState(316);
							((EReferenceContext)_localctx).specification = specification();
							((EReferenceContext)_localctx).ownedDefaultExpressions.add(((EReferenceContext)_localctx).specification);
							}
						}

						setState(319);
						match(T__3);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(324);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(325);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(326);
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
		public VisibilityKindContext visibiliry;
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
		public SpecificationContext specification;
		public List<SpecificationContext> ownedBodyExpression = new ArrayList<SpecificationContext>();
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
		public List<PostconditionConstraintContext> postconditionConstraint() {
			return getRuleContexts(PostconditionConstraintContext.class);
		}
		public PostconditionConstraintContext postconditionConstraint(int i) {
			return getRuleContext(PostconditionConstraintContext.class,i);
		}
		public List<SpecificationContext> specification() {
			return getRuleContexts(SpecificationContext.class);
		}
		public SpecificationContext specification(int i) {
			return getRuleContext(SpecificationContext.class,i);
		}
		public EOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eOperation; }
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
			setState(330);
			_la = _input.LA(1);
			if (_la==T__4 || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__68 - 68)) | (1L << (T__69 - 68)))) != 0)) {
				{
				setState(329);
				((EOperationContext)_localctx).visibiliry = visibilityKind();
				}
			}

			setState(333);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(332);
				((EOperationContext)_localctx).s14 = match(T__13);
				((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s14);
				}
			}

			setState(335);
			match(T__40);
			setState(336);
			((EOperationContext)_localctx).name = identifier();
			setState(337);
			match(T__41);
			setState(346);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(338);
				((EOperationContext)_localctx).eParameter = eParameter();
				((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(339);
					match(T__11);
					setState(340);
					((EOperationContext)_localctx).eParameter = eParameter();
					((EOperationContext)_localctx).eParameters.add(((EOperationContext)_localctx).eParameter);
					}
					}
					setState(345);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(348);
			match(T__42);
			setState(354);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(349);
				match(T__2);
				setState(350);
				((EOperationContext)_localctx).returnType = eType();
				setState(352);
				_la = _input.LA(1);
				if (_la==T__45) {
					{
					setState(351);
					((EOperationContext)_localctx).multiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(365);
			_la = _input.LA(1);
			if (_la==T__43) {
				{
				setState(356);
				match(T__43);
				setState(357);
				((EOperationContext)_localctx).identifier = identifier();
				((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(358);
					match(T__11);
					setState(359);
					((EOperationContext)_localctx).identifier = identifier();
					((EOperationContext)_localctx).ownedException.add(((EOperationContext)_localctx).identifier);
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(384);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(367);
				match(T__6);
				setState(379); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(374);
					switch (_input.LA(1)) {
					case T__15:
						{
						setState(368);
						((EOperationContext)_localctx).s16 = match(T__15);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s16);
						}
						break;
					case T__16:
						{
						setState(369);
						((EOperationContext)_localctx).s17 = match(T__16);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s17);
						}
						break;
					case T__19:
						{
						setState(370);
						((EOperationContext)_localctx).s20 = match(T__19);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(371);
						((EOperationContext)_localctx).s21 = match(T__20);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s21);
						}
						break;
					case T__25:
						{
						setState(372);
						((EOperationContext)_localctx).s26 = match(T__25);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(373);
						((EOperationContext)_localctx).s27 = match(T__26);
						((EOperationContext)_localctx).qualifier.add(((EOperationContext)_localctx).s27);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(377);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(376);
						match(T__11);
						}
					}

					}
					}
					setState(381); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__26))) != 0) );
				setState(383);
				match(T__7);
				}
				break;
			}
			setState(405);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(386);
				match(T__6);
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (T__44 - 45)) | (1L << (T__64 - 45)) | (1L << (T__65 - 45)))) != 0)) {
					{
					setState(398);
					switch (_input.LA(1)) {
					case T__64:
						{
						setState(387);
						((EOperationContext)_localctx).preconditionConstraint = preconditionConstraint();
						((EOperationContext)_localctx).ownedPrecondition.add(((EOperationContext)_localctx).preconditionConstraint);
						}
						break;
					case T__44:
						{
						{
						setState(388);
						match(T__44);
						setState(390);
						_la = _input.LA(1);
						if (_la==IDENTIFIER) {
							{
							setState(389);
							identifier();
							}
						}

						setState(392);
						match(T__2);
						setState(394);
						_la = _input.LA(1);
						if (_la==T__66) {
							{
							setState(393);
							((EOperationContext)_localctx).specification = specification();
							((EOperationContext)_localctx).ownedBodyExpression.add(((EOperationContext)_localctx).specification);
							}
						}

						setState(396);
						match(T__3);
						}
						}
						break;
					case T__65:
						{
						setState(397);
						((EOperationContext)_localctx).postconditionConstraint = postconditionConstraint();
						((EOperationContext)_localctx).ownedPostcondition.add(((EOperationContext)_localctx).postconditionConstraint);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(402);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(403);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(404);
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
			setState(407);
			((EParameterContext)_localctx).name = identifier();
			setState(413);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(408);
				match(T__2);
				setState(409);
				((EParameterContext)_localctx).ownedType = eType();
				setState(411);
				_la = _input.LA(1);
				if (_la==T__45) {
					{
					setState(410);
					((EParameterContext)_localctx).ownedMultiplicity = eMultiplicity();
					}
				}

				}
			}

			setState(430);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(415);
				match(T__6);
				setState(425); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(420);
					switch (_input.LA(1)) {
					case T__19:
						{
						setState(416);
						((EParameterContext)_localctx).s20 = match(T__19);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s20);
						}
						break;
					case T__20:
						{
						setState(417);
						((EParameterContext)_localctx).s21 = match(T__20);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s21);
						}
						break;
					case T__25:
						{
						setState(418);
						((EParameterContext)_localctx).s26 = match(T__25);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s26);
						}
						break;
					case T__26:
						{
						setState(419);
						((EParameterContext)_localctx).s27 = match(T__26);
						((EParameterContext)_localctx).qualifier.add(((EParameterContext)_localctx).s27);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(423);
					_la = _input.LA(1);
					if (_la==T__11) {
						{
						setState(422);
						match(T__11);
						}
					}

					}
					}
					setState(427); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__26))) != 0) );
				setState(429);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitEType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ETypeContext eType() throws RecognitionException {
		ETypeContext _localctx = new ETypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_eType);
		try {
			setState(434);
			switch (_input.LA(1)) {
			case T__55:
			case T__56:
			case T__57:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				ePrimitiveType();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
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
			setState(436);
			match(T__45);
			setState(443);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(437);
				((EMultiplicityContext)_localctx).lowerBound = lower();
				setState(440);
				_la = _input.LA(1);
				if (_la==T__46) {
					{
					setState(438);
					match(T__46);
					setState(439);
					((EMultiplicityContext)_localctx).upperBound = upper();
					}
				}

				}
				break;
			case T__47:
			case T__48:
			case T__49:
				{
				setState(442);
				((EMultiplicityContext)_localctx).stringBounds = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
					((EMultiplicityContext)_localctx).stringBounds = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(445);
			match(T__50);
			}
		}
		catch (RecognitionException re) {
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
			setState(448);
			_la = _input.LA(1);
			if (_la==T__51) {
				{
				setState(447);
				((EDataTypeContext)_localctx).isPrimitive = match(T__51);
				}
			}

			setState(450);
			match(T__52);
			setState(451);
			((EDataTypeContext)_localctx).name = identifier();
			setState(453);
			_la = _input.LA(1);
			if (_la==T__41 || _la==T__60) {
				{
				setState(452);
				((EDataTypeContext)_localctx).ownedSignature = templateSignature();
				}
			}

			setState(457);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(455);
				match(T__2);
				setState(456);
				((EDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			setState(465);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(459);
				match(T__6);
				setState(462);
				switch (_input.LA(1)) {
				case T__53:
					{
					setState(460);
					((EDataTypeContext)_localctx).isSerializable = match(T__53);
					}
					break;
				case T__54:
					{
					setState(461);
					match(T__54);
					}
					break;
				case T__7:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(464);
				match(T__7);
				}
				break;
			}
			setState(476);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(467);
				match(T__6);
				setState(471);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__62 || _la==T__63) {
					{
					{
					setState(468);
					((EDataTypeContext)_localctx).invariantConstraint = invariantConstraint();
					((EDataTypeContext)_localctx).ownedConstraint.add(((EDataTypeContext)_localctx).invariantConstraint);
					}
					}
					setState(473);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(474);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(475);
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
			setState(478);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__55) | (1L << T__56) | (1L << T__57))) != 0)) ) {
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
		public IdentifierContext name;
		public Token isSerializable;
		public EEnumLiteralContext eEnumLiteral;
		public List<EEnumLiteralContext> ownedLiteral = new ArrayList<EEnumLiteralContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<EEnumLiteralContext> eEnumLiteral() {
			return getRuleContexts(EEnumLiteralContext.class);
		}
		public EEnumLiteralContext eEnumLiteral(int i) {
			return getRuleContext(EEnumLiteralContext.class,i);
		}
		public EEnumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eEnum; }
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
			setState(480);
			match(T__58);
			setState(481);
			((EEnumContext)_localctx).name = identifier();
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				setState(482);
				match(T__6);
				setState(485);
				switch (_input.LA(1)) {
				case T__53:
					{
					setState(483);
					((EEnumContext)_localctx).isSerializable = match(T__53);
					}
					break;
				case T__54:
					{
					setState(484);
					match(T__54);
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
			setState(499);
			switch (_input.LA(1)) {
			case T__6:
				{
				{
				setState(490);
				match(T__6);
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__59 || _la==IDENTIFIER) {
					{
					{
					setState(491);
					((EEnumContext)_localctx).eEnumLiteral = eEnumLiteral();
					((EEnumContext)_localctx).ownedLiteral.add(((EEnumContext)_localctx).eEnumLiteral);
					}
					}
					setState(496);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(497);
				match(T__7);
				}
				}
				break;
			case T__3:
				{
				setState(498);
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
			setState(504);
			switch (_input.LA(1)) {
			case T__59:
				{
				{
				setState(501);
				match(T__59);
				setState(502);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				}
				break;
			case IDENTIFIER:
				{
				setState(503);
				((EEnumLiteralContext)_localctx).name = identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(508);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(506);
				match(T__5);
				setState(507);
				((EEnumLiteralContext)_localctx).value = signed();
				}
			}

			setState(510);
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
			setState(534);
			switch (_input.LA(1)) {
			case T__41:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(512);
				match(T__41);
				setState(513);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(518);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(514);
					match(T__11);
					setState(515);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(520);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(521);
				match(T__42);
				}
				}
				break;
			case T__60:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(523);
				match(T__60);
				setState(524);
				((TemplateSignatureContext)_localctx).identifier = identifier();
				((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(525);
					match(T__11);
					setState(526);
					((TemplateSignatureContext)_localctx).identifier = identifier();
					((TemplateSignatureContext)_localctx).ownedParameter.add(((TemplateSignatureContext)_localctx).identifier);
					}
					}
					setState(531);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(532);
				match(T__61);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitInvariantConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvariantConstraintContext invariantConstraint() throws RecognitionException {
		InvariantConstraintContext _localctx = new InvariantConstraintContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_invariantConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			_la = _input.LA(1);
			if (_la==T__62) {
				{
				setState(536);
				((InvariantConstraintContext)_localctx).isCallable = match(T__62);
				}
			}

			setState(539);
			((InvariantConstraintContext)_localctx).stereotype = match(T__63);
			setState(547);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(540);
				((InvariantConstraintContext)_localctx).name = identifier();
				setState(545);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(541);
					match(T__41);
					setState(542);
					((InvariantConstraintContext)_localctx).ownedMessageSpecification = specification();
					setState(543);
					match(T__42);
					}
				}

				}
			}

			setState(555);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(549);
				match(T__2);
				setState(551);
				_la = _input.LA(1);
				if (_la==T__66) {
					{
					setState(550);
					((InvariantConstraintContext)_localctx).ownedSpecification = specification();
					}
				}

				setState(553);
				match(T__3);
				}
				}
				break;
			case T__3:
				{
				setState(554);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPreconditionConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreconditionConstraintContext preconditionConstraint() throws RecognitionException {
		PreconditionConstraintContext _localctx = new PreconditionConstraintContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_preconditionConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			((PreconditionConstraintContext)_localctx).stereotype = match(T__64);
			setState(565);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(558);
				((PreconditionConstraintContext)_localctx).name = identifier();
				setState(563);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(559);
					match(T__41);
					setState(560);
					((PreconditionConstraintContext)_localctx).ownedMessageSpecification = specification();
					setState(561);
					match(T__42);
					}
				}

				}
			}

			setState(567);
			match(T__2);
			setState(569);
			_la = _input.LA(1);
			if (_la==T__66) {
				{
				setState(568);
				((PreconditionConstraintContext)_localctx).ownedSpecification = specification();
				}
			}

			setState(571);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitPostconditionConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostconditionConstraintContext postconditionConstraint() throws RecognitionException {
		PostconditionConstraintContext _localctx = new PostconditionConstraintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_postconditionConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			((PostconditionConstraintContext)_localctx).stereotype = match(T__65);
			setState(581);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(574);
				((PostconditionConstraintContext)_localctx).name = identifier();
				setState(579);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(575);
					match(T__41);
					setState(576);
					((PostconditionConstraintContext)_localctx).ownedMessageSpecification = specification();
					setState(577);
					match(T__42);
					}
				}

				}
			}

			setState(583);
			match(T__2);
			setState(585);
			_la = _input.LA(1);
			if (_la==T__66) {
				{
				setState(584);
				((PostconditionConstraintContext)_localctx).ownedSpecification = specification();
				}
			}

			setState(587);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
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
			setState(591);
			match(T__66);
			}
		}
		catch (RecognitionException re) {
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitVisibilityKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisibilityKindContext visibilityKind() throws RecognitionException {
		VisibilityKindContext _localctx = new VisibilityKindContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_visibilityKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			_la = _input.LA(1);
			if ( !(_la==T__4 || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__68 - 68)) | (1L << (T__69 - 68)))) != 0)) ) {
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_qualifiedName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			((QualifiedNameContext)_localctx).identifier = identifier();
			((QualifiedNameContext)_localctx).firstPart.add(((QualifiedNameContext)_localctx).identifier);
			setState(605);
			_la = _input.LA(1);
			if (_la==T__70) {
				{
				setState(600);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(596);
						match(T__70);
						setState(597);
						((QualifiedNameContext)_localctx).identifier = identifier();
						((QualifiedNameContext)_localctx).midPart.add(((QualifiedNameContext)_localctx).identifier);
						}
						} 
					}
					setState(602);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				}
				{
				setState(603);
				match(T__70);
				setState(604);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitUpper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpperContext upper() throws RecognitionException {
		UpperContext _localctx = new UpperContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_upper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			_la = _input.LA(1);
			if ( !(_la==T__47 || _la==INT) ) {
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerContext lower() throws RecognitionException {
		LowerContext _localctx = new LowerContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_lower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlloyInEcoreVisitor ) return ((AlloyInEcoreVisitor<? extends T>)visitor).visitSigned(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignedContext signed() throws RecognitionException {
		SignedContext _localctx = new SignedContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_signed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_la = _input.LA(1);
			if (_la==T__71) {
				{
				setState(613);
				match(T__71);
				}
			}

			setState(616);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Q\u026d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\5\2=\n\2\3\2\7\2@\n\2"+
		"\f\2\16\2C\13\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5"+
		"\3Q\n\3\3\3\3\3\3\3\3\4\5\4W\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\4d\n\4\f\4\16\4g\13\4\3\4\3\4\5\4k\n\4\3\4\3\4\3\5\3\5\3\5\5"+
		"\5r\n\5\3\6\5\6u\n\6\3\6\5\6x\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0080\n"+
		"\6\f\6\16\6\u0083\13\6\5\6\u0085\n\6\3\6\3\6\5\6\u0089\n\6\3\6\3\6\5\6"+
		"\u008d\n\6\3\6\5\6\u0090\n\6\3\6\3\6\3\6\3\6\7\6\u0096\n\6\f\6\16\6\u0099"+
		"\13\6\3\6\3\6\5\6\u009d\n\6\3\7\3\7\5\7\u00a1\n\7\3\b\5\b\u00a4\n\b\3"+
		"\b\5\b\u00a7\n\b\3\b\3\b\3\b\3\b\5\b\u00ad\n\b\3\b\3\b\3\b\5\b\u00b2\n"+
		"\b\5\b\u00b4\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00c7\n\b\3\b\5\b\u00ca\n\b\6\b\u00cc\n\b\r\b\16\b"+
		"\u00cd\3\b\5\b\u00d1\n\b\3\b\3\b\3\b\5\b\u00d6\n\b\3\b\3\b\5\b\u00da\n"+
		"\b\3\b\3\b\3\b\5\b\u00df\n\b\3\b\3\b\5\b\u00e3\n\b\3\b\7\b\u00e6\n\b\f"+
		"\b\16\b\u00e9\13\b\3\b\3\b\5\b\u00ed\n\b\3\t\5\t\u00f0\n\t\3\t\5\t\u00f3"+
		"\n\t\3\t\3\t\3\t\3\t\5\t\u00f9\n\t\3\t\3\t\3\t\5\t\u00fe\n\t\5\t\u0100"+
		"\n\t\3\t\3\t\5\t\u0104\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0119\n\t\3\t\5\t\u011c\n\t\6\t\u011e"+
		"\n\t\r\t\16\t\u011f\3\t\5\t\u0123\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u012a\n"+
		"\t\f\t\16\t\u012d\13\t\3\t\3\t\3\t\3\t\5\t\u0133\n\t\3\t\3\t\5\t\u0137"+
		"\n\t\3\t\3\t\3\t\5\t\u013c\n\t\3\t\3\t\5\t\u0140\n\t\3\t\7\t\u0143\n\t"+
		"\f\t\16\t\u0146\13\t\3\t\3\t\5\t\u014a\n\t\3\n\5\n\u014d\n\n\3\n\5\n\u0150"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0158\n\n\f\n\16\n\u015b\13\n\5\n\u015d"+
		"\n\n\3\n\3\n\3\n\3\n\5\n\u0163\n\n\5\n\u0165\n\n\3\n\3\n\3\n\3\n\7\n\u016b"+
		"\n\n\f\n\16\n\u016e\13\n\5\n\u0170\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u0179\n\n\3\n\5\n\u017c\n\n\6\n\u017e\n\n\r\n\16\n\u017f\3\n\5\n\u0183"+
		"\n\n\3\n\3\n\3\n\3\n\5\n\u0189\n\n\3\n\3\n\5\n\u018d\n\n\3\n\3\n\7\n\u0191"+
		"\n\n\f\n\16\n\u0194\13\n\3\n\3\n\5\n\u0198\n\n\3\13\3\13\3\13\3\13\5\13"+
		"\u019e\n\13\5\13\u01a0\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u01a7\n\13\3"+
		"\13\5\13\u01aa\n\13\6\13\u01ac\n\13\r\13\16\13\u01ad\3\13\5\13\u01b1\n"+
		"\13\3\f\3\f\5\f\u01b5\n\f\3\r\3\r\3\r\3\r\5\r\u01bb\n\r\3\r\5\r\u01be"+
		"\n\r\3\r\3\r\3\16\5\16\u01c3\n\16\3\16\3\16\3\16\5\16\u01c8\n\16\3\16"+
		"\3\16\5\16\u01cc\n\16\3\16\3\16\3\16\5\16\u01d1\n\16\3\16\5\16\u01d4\n"+
		"\16\3\16\3\16\7\16\u01d8\n\16\f\16\16\16\u01db\13\16\3\16\3\16\5\16\u01df"+
		"\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u01e8\n\20\3\20\5\20\u01eb"+
		"\n\20\3\20\3\20\7\20\u01ef\n\20\f\20\16\20\u01f2\13\20\3\20\3\20\5\20"+
		"\u01f6\n\20\3\21\3\21\3\21\5\21\u01fb\n\21\3\21\3\21\5\21\u01ff\n\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\7\22\u0207\n\22\f\22\16\22\u020a\13\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\7\22\u0212\n\22\f\22\16\22\u0215\13\22\3"+
		"\22\3\22\5\22\u0219\n\22\3\23\5\23\u021c\n\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0224\n\23\5\23\u0226\n\23\3\23\3\23\5\23\u022a\n\23\3\23\3"+
		"\23\5\23\u022e\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0236\n\24\5\24"+
		"\u0238\n\24\3\24\3\24\5\24\u023c\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u0246\n\25\5\25\u0248\n\25\3\25\3\25\5\25\u024c\n\25\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\7\31\u0259\n\31\f\31"+
		"\16\31\u025c\13\31\3\31\3\31\5\31\u0260\n\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\5\35\u0269\n\35\3\35\3\35\3\35\2\2\36\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\6\3\2\62\64\3\2:<\4\2\7\7F"+
		"H\4\2\62\62KK\u02e8\2<\3\2\2\2\4L\3\2\2\2\6V\3\2\2\2\bq\3\2\2\2\nt\3\2"+
		"\2\2\f\u00a0\3\2\2\2\16\u00a3\3\2\2\2\20\u00ef\3\2\2\2\22\u014c\3\2\2"+
		"\2\24\u0199\3\2\2\2\26\u01b4\3\2\2\2\30\u01b6\3\2\2\2\32\u01c2\3\2\2\2"+
		"\34\u01e0\3\2\2\2\36\u01e2\3\2\2\2 \u01fa\3\2\2\2\"\u0218\3\2\2\2$\u021b"+
		"\3\2\2\2&\u022f\3\2\2\2(\u023f\3\2\2\2*\u024f\3\2\2\2,\u0251\3\2\2\2."+
		"\u0253\3\2\2\2\60\u0255\3\2\2\2\62\u0261\3\2\2\2\64\u0263\3\2\2\2\66\u0265"+
		"\3\2\2\28\u0268\3\2\2\2:;\7\3\2\2;=\5\62\32\2<:\3\2\2\2<=\3\2\2\2=A\3"+
		"\2\2\2>@\5\4\3\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BG\3\2\2\2CA\3"+
		"\2\2\2DF\5\6\4\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3"+
		"\2\2\2JK\b\2\1\2K\3\3\2\2\2LP\7\4\2\2MN\5\62\32\2NO\7\5\2\2OQ\3\2\2\2"+
		"PM\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\7N\2\2ST\7\6\2\2T\5\3\2\2\2UW\5.\30\2"+
		"VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\7\7\2\2YZ\5\62\32\2Z[\7\5\2\2[\\\5\62"+
		"\32\2\\]\3\2\2\2]^\7\b\2\2^_\7N\2\2_j\3\2\2\2`e\7\t\2\2ad\5\6\4\2bd\5"+
		"\b\5\2ca\3\2\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3"+
		"\2\2\2hk\7\n\2\2ik\7\6\2\2j`\3\2\2\2ji\3\2\2\2kl\3\2\2\2lm\b\4\1\2m\7"+
		"\3\2\2\2nr\5\n\6\2or\5\32\16\2pr\5\36\20\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2"+
		"\2r\t\3\2\2\2su\5.\30\2ts\3\2\2\2tu\3\2\2\2uw\3\2\2\2vx\7\13\2\2wv\3\2"+
		"\2\2wx\3\2\2\2xy\3\2\2\2yz\7\f\2\2z\u0084\5\62\32\2{|\7\r\2\2|\u0081\5"+
		"\60\31\2}~\7\16\2\2~\u0080\5\60\31\2\177}\3\2\2\2\u0080\u0083\3\2\2\2"+
		"\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084{\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0087\7\5\2\2\u0087\u0089\7N\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008f\3\2\2\2\u008a\u008c\7\t\2\2\u008b\u008d\7\17\2\2\u008c"+
		"\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\7\n"+
		"\2\2\u008f\u008a\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u009c\3\2\2\2\u0091"+
		"\u0097\7\t\2\2\u0092\u0096\5\22\n\2\u0093\u0096\5\f\7\2\u0094\u0096\5"+
		"$\23\2\u0095\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u009a\u009d\7\n\2\2\u009b\u009d\7\6\2\2\u009c"+
		"\u0091\3\2\2\2\u009c\u009b\3\2\2\2\u009d\13\3\2\2\2\u009e\u00a1\5\16\b"+
		"\2\u009f\u00a1\5\20\t\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\r\3\2\2\2\u00a2\u00a4\5.\30\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2"+
		"\u00a4\u00a6\3\2\2\2\u00a5\u00a7\7\20\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\7\21\2\2\u00a9\u00ac\5\62\32"+
		"\2\u00aa\u00ab\7\b\2\2\u00ab\u00ad\7N\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00b3\3\2\2\2\u00ae\u00af\7\5\2\2\u00af\u00b1\5\26\f\2"+
		"\u00b0\u00b2\5\30\r\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4"+
		"\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00d0\3\2\2\2\u00b5"+
		"\u00cb\7\t\2\2\u00b6\u00c7\7\22\2\2\u00b7\u00c7\7\23\2\2\u00b8\u00c7\7"+
		"\24\2\2\u00b9\u00c7\7\25\2\2\u00ba\u00c7\7\26\2\2\u00bb\u00c7\7\27\2\2"+
		"\u00bc\u00c7\7\30\2\2\u00bd\u00c7\7\31\2\2\u00be\u00c7\7\32\2\2\u00bf"+
		"\u00c7\7\33\2\2\u00c0\u00c7\7\34\2\2\u00c1\u00c7\7\35\2\2\u00c2\u00c7"+
		"\7\36\2\2\u00c3\u00c7\7\37\2\2\u00c4\u00c7\7 \2\2\u00c5\u00c7\7!\2\2\u00c6"+
		"\u00b6\3\2\2\2\u00c6\u00b7\3\2\2\2\u00c6\u00b8\3\2\2\2\u00c6\u00b9\3\2"+
		"\2\2\u00c6\u00ba\3\2\2\2\u00c6\u00bb\3\2\2\2\u00c6\u00bc\3\2\2\2\u00c6"+
		"\u00bd\3\2\2\2\u00c6\u00be\3\2\2\2\u00c6\u00bf\3\2\2\2\u00c6\u00c0\3\2"+
		"\2\2\u00c6\u00c1\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00ca\7\16"+
		"\2\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb"+
		"\u00c6\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\7\n\2\2\u00d0\u00b5\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00ec\3\2\2\2\u00d2\u00e7\7\t\2\2\u00d3\u00d5\7\""+
		"\2\2\u00d4\u00d6\5\62\32\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d9\7\5\2\2\u00d8\u00da\5*\26\2\u00d9\u00d8\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00e6\7\6\2\2\u00dc"+
		"\u00de\7#\2\2\u00dd\u00df\5\62\32\2\u00de\u00dd\3\2\2\2\u00de\u00df\3"+
		"\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\7\5\2\2\u00e1\u00e3\5*\26\2\u00e2"+
		"\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\7\6"+
		"\2\2\u00e5\u00d3\3\2\2\2\u00e5\u00dc\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00ea\u00ed\7\n\2\2\u00eb\u00ed\7\6\2\2\u00ec\u00d2\3\2\2\2\u00ec"+
		"\u00eb\3\2\2\2\u00ed\17\3\2\2\2\u00ee\u00f0\5.\30\2\u00ef\u00ee\3\2\2"+
		"\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00f3\7\20\2\2\u00f2"+
		"\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7$"+
		"\2\2\u00f5\u00f8\5\62\32\2\u00f6\u00f7\7%\2\2\u00f7\u00f9\5\62\32\2\u00f8"+
		"\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00ff\3\2\2\2\u00fa\u00fb\7\5"+
		"\2\2\u00fb\u00fd\5\26\f\2\u00fc\u00fe\5\30\r\2\u00fd\u00fc\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fa\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0103\3\2\2\2\u0101\u0102\7\b\2\2\u0102\u0104\7N\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0122\3\2\2\2\u0105\u011d\7\t"+
		"\2\2\u0106\u0119\7&\2\2\u0107\u0119\7\'\2\2\u0108\u0119\7\22\2\2\u0109"+
		"\u0119\7\23\2\2\u010a\u0119\7\26\2\2\u010b\u0119\7\27\2\2\u010c\u0119"+
		"\7\30\2\2\u010d\u0119\7\31\2\2\u010e\u0119\7(\2\2\u010f\u0119\7)\2\2\u0110"+
		"\u0119\7\32\2\2\u0111\u0119\7\33\2\2\u0112\u0119\7\34\2\2\u0113\u0119"+
		"\7\35\2\2\u0114\u0119\7\36\2\2\u0115\u0119\7\37\2\2\u0116\u0119\7 \2\2"+
		"\u0117\u0119\7!\2\2\u0118\u0106\3\2\2\2\u0118\u0107\3\2\2\2\u0118\u0108"+
		"\3\2\2\2\u0118\u0109\3\2\2\2\u0118\u010a\3\2\2\2\u0118\u010b\3\2\2\2\u0118"+
		"\u010c\3\2\2\2\u0118\u010d\3\2\2\2\u0118\u010e\3\2\2\2\u0118\u010f\3\2"+
		"\2\2\u0118\u0110\3\2\2\2\u0118\u0111\3\2\2\2\u0118\u0112\3\2\2\2\u0118"+
		"\u0113\3\2\2\2\u0118\u0114\3\2\2\2\u0118\u0115\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0117\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u011c\7\16\2\2\u011b"+
		"\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u0118\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0123\7\n\2\2\u0122\u0105\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0149\3\2\2\2\u0124\u0144\7\t\2\2\u0125\u0126\7*\2\2\u0126"+
		"\u012b\5\60\31\2\u0127\u0128\7\16\2\2\u0128\u012a\5\60\31\2\u0129\u0127"+
		"\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7\6\2\2\u012f\u0143\3\2"+
		"\2\2\u0130\u0132\7\"\2\2\u0131\u0133\5\62\32\2\u0132\u0131\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0136\7\5\2\2\u0135\u0137\5*"+
		"\26\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u0143\7\6\2\2\u0139\u013b\7#\2\2\u013a\u013c\5\62\32\2\u013b\u013a\3"+
		"\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\7\5\2\2\u013e"+
		"\u0140\5*\26\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\3\2"+
		"\2\2\u0141\u0143\7\6\2\2\u0142\u0125\3\2\2\2\u0142\u0130\3\2\2\2\u0142"+
		"\u0139\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u014a\7\n\2\2\u0148"+
		"\u014a\7\6\2\2\u0149\u0124\3\2\2\2\u0149\u0148\3\2\2\2\u014a\21\3\2\2"+
		"\2\u014b\u014d\5.\30\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f"+
		"\3\2\2\2\u014e\u0150\7\20\2\2\u014f\u014e\3\2\2\2\u014f\u0150\3\2\2\2"+
		"\u0150\u0151\3\2\2\2\u0151\u0152\7+\2\2\u0152\u0153\5\62\32\2\u0153\u015c"+
		"\7,\2\2\u0154\u0159\5\24\13\2\u0155\u0156\7\16\2\2\u0156\u0158\5\24\13"+
		"\2\u0157\u0155\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u0154\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0164\7-\2\2\u015f\u0160\7\5"+
		"\2\2\u0160\u0162\5\26\f\2\u0161\u0163\5\30\r\2\u0162\u0161\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u015f\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165\u016f\3\2\2\2\u0166\u0167\7.\2\2\u0167\u016c\5\62\32\2\u0168"+
		"\u0169\7\16\2\2\u0169\u016b\5\62\32\2\u016a\u0168\3\2\2\2\u016b\u016e"+
		"\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016f\u0166\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0182\3\2"+
		"\2\2\u0171\u017d\7\t\2\2\u0172\u0179\7\22\2\2\u0173\u0179\7\23\2\2\u0174"+
		"\u0179\7\26\2\2\u0175\u0179\7\27\2\2\u0176\u0179\7\34\2\2\u0177\u0179"+
		"\7\35\2\2\u0178\u0172\3\2\2\2\u0178\u0173\3\2\2\2\u0178\u0174\3\2\2\2"+
		"\u0178\u0175\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0177\3\2\2\2\u0179\u017b"+
		"\3\2\2\2\u017a\u017c\7\16\2\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2"+
		"\u017c\u017e\3\2\2\2\u017d\u0178\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u017d"+
		"\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\7\n\2\2\u0182"+
		"\u0171\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0197\3\2\2\2\u0184\u0192\7\t"+
		"\2\2\u0185\u0191\5&\24\2\u0186\u0188\7/\2\2\u0187\u0189\5\62\32\2\u0188"+
		"\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c\7\5"+
		"\2\2\u018b\u018d\5*\26\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d"+
		"\u018e\3\2\2\2\u018e\u0191\7\6\2\2\u018f\u0191\5(\25\2\u0190\u0185\3\2"+
		"\2\2\u0190\u0186\3\2\2\2\u0190\u018f\3\2\2\2\u0191\u0194\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0192\3\2"+
		"\2\2\u0195\u0198\7\n\2\2\u0196\u0198\7\6\2\2\u0197\u0184\3\2\2\2\u0197"+
		"\u0196\3\2\2\2\u0198\23\3\2\2\2\u0199\u019f\5\62\32\2\u019a\u019b\7\5"+
		"\2\2\u019b\u019d\5\26\f\2\u019c\u019e\5\30\r\2\u019d\u019c\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u01a0\3\2\2\2\u019f\u019a\3\2\2\2\u019f\u01a0\3\2"+
		"\2\2\u01a0\u01b0\3\2\2\2\u01a1\u01ab\7\t\2\2\u01a2\u01a7\7\26\2\2\u01a3"+
		"\u01a7\7\27\2\2\u01a4\u01a7\7\34\2\2\u01a5\u01a7\7\35\2\2\u01a6\u01a2"+
		"\3\2\2\2\u01a6\u01a3\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7"+
		"\u01a9\3\2\2\2\u01a8\u01aa\7\16\2\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3"+
		"\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a6\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b1\7\n"+
		"\2\2\u01b0\u01a1\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\25\3\2\2\2\u01b2\u01b5"+
		"\5\34\17\2\u01b3\u01b5\5\60\31\2\u01b4\u01b2\3\2\2\2\u01b4\u01b3\3\2\2"+
		"\2\u01b5\27\3\2\2\2\u01b6\u01bd\7\60\2\2\u01b7\u01ba\5\66\34\2\u01b8\u01b9"+
		"\7\61\2\2\u01b9\u01bb\5\64\33\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2"+
		"\2\u01bb\u01be\3\2\2\2\u01bc\u01be\t\2\2\2\u01bd\u01b7\3\2\2\2\u01bd\u01bc"+
		"\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\7\65\2\2\u01c0\31\3\2\2\2\u01c1"+
		"\u01c3\7\66\2\2\u01c2\u01c1\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\3"+
		"\2\2\2\u01c4\u01c5\7\67\2\2\u01c5\u01c7\5\62\32\2\u01c6\u01c8\5\"\22\2"+
		"\u01c7\u01c6\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01cb\3\2\2\2\u01c9\u01ca"+
		"\7\5\2\2\u01ca\u01cc\7N\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc"+
		"\u01d3\3\2\2\2\u01cd\u01d0\7\t\2\2\u01ce\u01d1\78\2\2\u01cf\u01d1\79\2"+
		"\2\u01d0\u01ce\3\2\2\2\u01d0\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2"+
		"\3\2\2\2\u01d2\u01d4\7\n\2\2\u01d3\u01cd\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4"+
		"\u01de\3\2\2\2\u01d5\u01d9\7\t\2\2\u01d6\u01d8\5$\23\2\u01d7\u01d6\3\2"+
		"\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"\u01dc\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01df\7\n\2\2\u01dd\u01df\7\6"+
		"\2\2\u01de\u01d5\3\2\2\2\u01de\u01dd\3\2\2\2\u01df\33\3\2\2\2\u01e0\u01e1"+
		"\t\3\2\2\u01e1\35\3\2\2\2\u01e2\u01e3\7=\2\2\u01e3\u01ea\5\62\32\2\u01e4"+
		"\u01e7\7\t\2\2\u01e5\u01e8\78\2\2\u01e6\u01e8\79\2\2\u01e7\u01e5\3\2\2"+
		"\2\u01e7\u01e6\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb"+
		"\7\n\2\2\u01ea\u01e4\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01f5\3\2\2\2\u01ec"+
		"\u01f0\7\t\2\2\u01ed\u01ef\5 \21\2\u01ee\u01ed\3\2\2\2\u01ef\u01f2\3\2"+
		"\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2"+
		"\u01f0\3\2\2\2\u01f3\u01f6\7\n\2\2\u01f4\u01f6\7\6\2\2\u01f5\u01ec\3\2"+
		"\2\2\u01f5\u01f4\3\2\2\2\u01f6\37\3\2\2\2\u01f7\u01f8\7>\2\2\u01f8\u01fb"+
		"\5\62\32\2\u01f9\u01fb\5\62\32\2\u01fa\u01f7\3\2\2\2\u01fa\u01f9\3\2\2"+
		"\2\u01fb\u01fe\3\2\2\2\u01fc\u01fd\7\b\2\2\u01fd\u01ff\58\35\2\u01fe\u01fc"+
		"\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\7\6\2\2\u0201"+
		"!\3\2\2\2\u0202\u0203\7,\2\2\u0203\u0208\5\62\32\2\u0204\u0205\7\16\2"+
		"\2\u0205\u0207\5\62\32\2\u0206\u0204\3\2\2\2\u0207\u020a\3\2\2\2\u0208"+
		"\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020b\3\2\2\2\u020a\u0208\3\2"+
		"\2\2\u020b\u020c\7-\2\2\u020c\u0219\3\2\2\2\u020d\u020e\7?\2\2\u020e\u0213"+
		"\5\62\32\2\u020f\u0210\7\16\2\2\u0210\u0212\5\62\32\2\u0211\u020f\3\2"+
		"\2\2\u0212\u0215\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214"+
		"\u0216\3\2\2\2\u0215\u0213\3\2\2\2\u0216\u0217\7@\2\2\u0217\u0219\3\2"+
		"\2\2\u0218\u0202\3\2\2\2\u0218\u020d\3\2\2\2\u0219#\3\2\2\2\u021a\u021c"+
		"\7A\2\2\u021b\u021a\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021d\3\2\2\2\u021d"+
		"\u0225\7B\2\2\u021e\u0223\5\62\32\2\u021f\u0220\7,\2\2\u0220\u0221\5*"+
		"\26\2\u0221\u0222\7-\2\2\u0222\u0224\3\2\2\2\u0223\u021f\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0226\3\2\2\2\u0225\u021e\3\2\2\2\u0225\u0226\3\2"+
		"\2\2\u0226\u022d\3\2\2\2\u0227\u0229\7\5\2\2\u0228\u022a\5*\26\2\u0229"+
		"\u0228\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022e\7\6"+
		"\2\2\u022c\u022e\7\6\2\2\u022d\u0227\3\2\2\2\u022d\u022c\3\2\2\2\u022e"+
		"%\3\2\2\2\u022f\u0237\7C\2\2\u0230\u0235\5\62\32\2\u0231\u0232\7,\2\2"+
		"\u0232\u0233\5*\26\2\u0233\u0234\7-\2\2\u0234\u0236\3\2\2\2\u0235\u0231"+
		"\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0238\3\2\2\2\u0237\u0230\3\2\2\2\u0237"+
		"\u0238\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023b\7\5\2\2\u023a\u023c\5*"+
		"\26\2\u023b\u023a\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\3\2\2\2\u023d"+
		"\u023e\7\6\2\2\u023e\'\3\2\2\2\u023f\u0247\7D\2\2\u0240\u0245\5\62\32"+
		"\2\u0241\u0242\7,\2\2\u0242\u0243\5*\26\2\u0243\u0244\7-\2\2\u0244\u0246"+
		"\3\2\2\2\u0245\u0241\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0248\3\2\2\2\u0247"+
		"\u0240\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024b\7\5"+
		"\2\2\u024a\u024c\5*\26\2\u024b\u024a\3\2\2\2\u024b\u024c\3\2\2\2\u024c"+
		"\u024d\3\2\2\2\u024d\u024e\7\6\2\2\u024e)\3\2\2\2\u024f\u0250\5,\27\2"+
		"\u0250+\3\2\2\2\u0251\u0252\7E\2\2\u0252-\3\2\2\2\u0253\u0254\t\4\2\2"+
		"\u0254/\3\2\2\2\u0255\u025f\5\62\32\2\u0256\u0257\7I\2\2\u0257\u0259\5"+
		"\62\32\2\u0258\u0256\3\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a"+
		"\u025b\3\2\2\2\u025b\u025d\3\2\2\2\u025c\u025a\3\2\2\2\u025d\u025e\7I"+
		"\2\2\u025e\u0260\5\62\32\2\u025f\u025a\3\2\2\2\u025f\u0260\3\2\2\2\u0260"+
		"\61\3\2\2\2\u0261\u0262\7L\2\2\u0262\63\3\2\2\2\u0263\u0264\t\5\2\2\u0264"+
		"\65\3\2\2\2\u0265\u0266\7K\2\2\u0266\67\3\2\2\2\u0267\u0269\7J\2\2\u0268"+
		"\u0267\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026b\7K"+
		"\2\2\u026b9\3\2\2\2p<AGPVcejqtw\u0081\u0084\u0088\u008c\u008f\u0095\u0097"+
		"\u009c\u00a0\u00a3\u00a6\u00ac\u00b1\u00b3\u00c6\u00c9\u00cd\u00d0\u00d5"+
		"\u00d9\u00de\u00e2\u00e5\u00e7\u00ec\u00ef\u00f2\u00f8\u00fd\u00ff\u0103"+
		"\u0118\u011b\u011f\u0122\u012b\u0132\u0136\u013b\u013f\u0142\u0144\u0149"+
		"\u014c\u014f\u0159\u015c\u0162\u0164\u016c\u016f\u0178\u017b\u017f\u0182"+
		"\u0188\u018c\u0190\u0192\u0197\u019d\u019f\u01a6\u01a9\u01ad\u01b0\u01b4"+
		"\u01ba\u01bd\u01c2\u01c7\u01cb\u01d0\u01d3\u01d9\u01de\u01e7\u01ea\u01f0"+
		"\u01f5\u01fa\u01fe\u0208\u0213\u0218\u021b\u0223\u0225\u0229\u022d\u0235"+
		"\u0237\u023b\u0245\u0247\u024b\u025a\u025f\u0268";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}