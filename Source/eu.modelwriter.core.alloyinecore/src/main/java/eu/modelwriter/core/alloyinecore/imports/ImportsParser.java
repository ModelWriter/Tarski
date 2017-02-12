// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/imports/Imports.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.imports;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedPackage;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedClass;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedInterface;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedDataType;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedEnum;
import eu.modelwriter.core.alloyinecore.structure.model.Import;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImportsParser extends Parser {
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
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, INT=58, IDENTIFIER=59, 
		SINGLE_CHARACTER=60, DOUBLE_QUOTED_STRING=61, SINGLE_QUOTED_STRING=62, 
		ML_SINGLE_QUOTED_STRING=63, MULTILINE_COMMENT=64, SINGLELINE_COMMENT=65, 
		WS=66, ANY=67;
	public static final int
		RULE_importModel = 0, RULE_iPackage = 1, RULE_iClassifier = 2, RULE_iClass = 3, 
		RULE_iDataType = 4, RULE_visibility = 5, RULE_block = 6, RULE_templateSignature = 7, 
		RULE_iTypeParameter = 8, RULE_iGenericType = 9, RULE_iGenericTypeArgument = 10, 
		RULE_iGenericWildcard = 11, RULE_pathName = 12, RULE_segment = 13, RULE_unrestrictedName = 14, 
		RULE_identifier = 15;
	public static final String[] ruleNames = {
		"importModel", "iPackage", "iClassifier", "iClass", "iDataType", "visibility", 
		"block", "templateSignature", "iTypeParameter", "iGenericType", "iGenericTypeArgument", 
		"iGenericWildcard", "pathName", "segment", "unrestrictedName", "identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'package'", "':'", "'='", "'{'", "'}'", "';'", "'abstract'", "'class'", 
		"'interface'", "'extends'", "','", "'datatype'", "'enum'", "'public'", 
		"'protected'", "'private'", "'<'", "'>'", "'&'", "'?'", "'super'", "'.'", 
		"'::'", "'@'", "'attribute'", "'body'", "'callable'", "'composes'", "'definition'", 
		"'derivation'", "'derived'", "'ensure'", "'id'", "'import'", "'initial'", 
		"'key'", "'model'", "'operation'", "'ordered'", "'postcondition'", "'precondition'", 
		"'primitive'", "'property'", "'readonly'", "'reference'", "'require'", 
		"'resolve'", "'static'", "'throws'", "'transient'", "'unique'", "'unsettable'", 
		"'volatile'", "'invariant'", "'literal'", "'serializable'", "'annotation'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "INT", "IDENTIFIER", 
		"SINGLE_CHARACTER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", "ML_SINGLE_QUOTED_STRING", 
		"MULTILINE_COMMENT", "SINGLELINE_COMMENT", "WS", "ANY"
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
	public String getGrammarFileName() { return "Imports.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private Element owningElement;

	public ImportsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ImportModelContext extends ParserRuleContext {
		public Element owner;
		public List<IPackageContext> iPackage() {
			return getRuleContexts(IPackageContext.class);
		}
		public IPackageContext iPackage(int i) {
			return getRuleContext(IPackageContext.class,i);
		}
		public ImportModelContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ImportModelContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_importModel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterImportModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitImportModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitImportModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportModelContext importModel(Element owner) throws RecognitionException {
		ImportModelContext _localctx = new ImportModelContext(_ctx, getState(), owner);
		enterRule(_localctx, 0, RULE_importModel);
		owningElement=owner;
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(32);
					matchWildcard();
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) {
				{
				{
				setState(38);
				iPackage(owningElement);
				}
				}
				setState(43);
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

	public static class IPackageContext extends ParserRuleContext {
		public Element owner;
		public ImportedPackage current;
		public UnrestrictedNameContext name;
		public Token nsURI;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(ImportsParser.SINGLE_QUOTED_STRING, 0); }
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public List<IClassifierContext> iClassifier() {
			return getRuleContexts(IClassifierContext.class);
		}
		public IClassifierContext iClassifier(int i) {
			return getRuleContext(IClassifierContext.class,i);
		}
		public List<IPackageContext> iPackage() {
			return getRuleContexts(IPackageContext.class);
		}
		public IPackageContext iPackage(int i) {
			return getRuleContext(IPackageContext.class,i);
		}
		public IPackageContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IPackageContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_iPackage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterIPackage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitIPackage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitIPackage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IPackageContext iPackage(Element owner) throws RecognitionException {
		IPackageContext _localctx = new IPackageContext(_ctx, getState(), owner);
		enterRule(_localctx, 2, RULE_iPackage);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) {
				{
				setState(44);
				visibility();
				}
			}

			setState(47);
			match(T__0);
			setState(48);
			((IPackageContext)_localctx).name = unrestrictedName();
			((IPackageContext)_localctx).current =  new ImportedPackage(_localctx);
			setState(50);
			match(T__1);
			setState(51);
			identifier();
			setState(52);
			match(T__2);
			setState(53);
			((IPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(54);
				match(T__3);
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						setState(58);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							setState(55);
							iClassifier(_localctx.current);
							}
							break;
						case 2:
							{
							setState(56);
							iPackage(_localctx.current);
							}
							break;
						case 3:
							{
							setState(57);
							matchWildcard();
							}
							break;
						}
						} 
					}
					setState(62);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(63);
				match(T__4);
				}
				break;
			case T__5:
				{
				setState(64);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			if(owner != null) owner.addOwnedElement(_localctx.current); else owningElement= _localctx.current;
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IClassifierContext extends ParserRuleContext {
		public Element owner;
		public IClassContext iClass() {
			return getRuleContext(IClassContext.class,0);
		}
		public IDataTypeContext iDataType() {
			return getRuleContext(IDataTypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IClassifierContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IClassifierContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_iClassifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterIClassifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitIClassifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitIClassifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IClassifierContext iClassifier(Element owner) throws RecognitionException {
		IClassifierContext _localctx = new IClassifierContext(_ctx, getState(), owner);
		enterRule(_localctx, 4, RULE_iClassifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(67);
				iClass(_localctx.owner);
				}
				break;
			case 2:
				{
				setState(68);
				iDataType(_localctx.owner);
				}
				break;
			}
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(71);
				block();
				}
				break;
			case T__5:
				{
				setState(72);
				match(T__5);
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

	public static class IClassContext extends ParserRuleContext {
		public Element owner;
		public ImportedClass current;
		public Token isAbstract;
		public Token isClass;
		public Token isInterface;
		public UnrestrictedNameContext name;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public List<IGenericTypeContext> iGenericType() {
			return getRuleContexts(IGenericTypeContext.class);
		}
		public IGenericTypeContext iGenericType(int i) {
			return getRuleContext(IGenericTypeContext.class,i);
		}
		public IClassContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IClassContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_iClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterIClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitIClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitIClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IClassContext iClass(Element owner) throws RecognitionException {
		IClassContext _localctx = new IClassContext(_ctx, getState(), owner);
		enterRule(_localctx, 6, RULE_iClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) {
				{
				setState(75);
				visibility();
				}
			}

			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
				{
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(78);
					((IClassContext)_localctx).isAbstract = match(T__6);
					}
				}

				setState(81);
				((IClassContext)_localctx).isClass = match(T__7);
				}
				break;
			case T__8:
				{
				setState(82);
				((IClassContext)_localctx).isInterface = match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(85);
			((IClassContext)_localctx).name = unrestrictedName();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(86);
				templateSignature();
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(89);
				match(T__9);
				setState(90);
				iGenericType();
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(91);
					match(T__10);
					setState(92);
					iGenericType();
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			if (((IClassContext)_localctx).isInterface!=null) ((IClassContext)_localctx).current =  new ImportedInterface(_localctx); else ((IClassContext)_localctx).current =  new ImportedClass(_localctx);
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

	public static class IDataTypeContext extends ParserRuleContext {
		public Element owner;
		public ImportedDataType current;
		public Token isDataType;
		public Token isEnum;
		public UnrestrictedNameContext name;
		public Token instanceClassName;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public TemplateSignatureContext templateSignature() {
			return getRuleContext(TemplateSignatureContext.class,0);
		}
		public TerminalNode SINGLE_QUOTED_STRING() { return getToken(ImportsParser.SINGLE_QUOTED_STRING, 0); }
		public IDataTypeContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public IDataTypeContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_iDataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterIDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitIDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitIDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IDataTypeContext iDataType(Element owner) throws RecognitionException {
		IDataTypeContext _localctx = new IDataTypeContext(_ctx, getState(), owner);
		enterRule(_localctx, 8, RULE_iDataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) {
				{
				setState(102);
				visibility();
				}
			}

			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(105);
				((IDataTypeContext)_localctx).isDataType = match(T__11);
				}
				break;
			case T__12:
				{
				setState(106);
				((IDataTypeContext)_localctx).isEnum = match(T__12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(109);
			((IDataTypeContext)_localctx).name = unrestrictedName();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(110);
				templateSignature();
				}
			}

			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(113);
				match(T__1);
				setState(114);
				((IDataTypeContext)_localctx).instanceClassName = match(SINGLE_QUOTED_STRING);
				}
			}

			if (((IDataTypeContext)_localctx).isDataType!=null) ((IDataTypeContext)_localctx).current =  new ImportedDataType(_localctx); else ((IDataTypeContext)_localctx).current =  new ImportedEnum(_localctx);
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

	public static class VisibilityContext extends ParserRuleContext {
		public VisibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibility; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterVisibility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitVisibility(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitVisibility(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisibilityContext visibility() throws RecognitionException {
		VisibilityContext _localctx = new VisibilityContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_visibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
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

	public static class BlockContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__3);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(124);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(122);
						block();
						}
						break;
					case 2:
						{
						setState(123);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(129);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
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
		public List<ITypeParameterContext> iTypeParameter() {
			return getRuleContexts(ITypeParameterContext.class);
		}
		public ITypeParameterContext iTypeParameter(int i) {
			return getRuleContext(ITypeParameterContext.class,i);
		}
		public TemplateSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterTemplateSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitTemplateSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitTemplateSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateSignatureContext templateSignature() throws RecognitionException {
		TemplateSignatureContext _localctx = new TemplateSignatureContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_templateSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__16);
			setState(132);
			iTypeParameter();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(133);
				match(T__10);
				setState(134);
				iTypeParameter();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ITypeParameterContext extends ParserRuleContext {
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public List<IGenericTypeContext> iGenericType() {
			return getRuleContexts(IGenericTypeContext.class);
		}
		public IGenericTypeContext iGenericType(int i) {
			return getRuleContext(IGenericTypeContext.class,i);
		}
		public ITypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iTypeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterITypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitITypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitITypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ITypeParameterContext iTypeParameter() throws RecognitionException {
		ITypeParameterContext _localctx = new ITypeParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_iTypeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			unrestrictedName();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(143);
				match(T__9);
				setState(144);
				iGenericType();
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__18) {
					{
					{
					setState(145);
					match(T__18);
					setState(146);
					iGenericType();
					}
					}
					setState(151);
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

	public static class IGenericTypeContext extends ParserRuleContext {
		public PathNameContext pathName() {
			return getRuleContext(PathNameContext.class,0);
		}
		public List<IGenericTypeArgumentContext> iGenericTypeArgument() {
			return getRuleContexts(IGenericTypeArgumentContext.class);
		}
		public IGenericTypeArgumentContext iGenericTypeArgument(int i) {
			return getRuleContext(IGenericTypeArgumentContext.class,i);
		}
		public IGenericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iGenericType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterIGenericType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitIGenericType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitIGenericType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IGenericTypeContext iGenericType() throws RecognitionException {
		IGenericTypeContext _localctx = new IGenericTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_iGenericType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			pathName();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(155);
				match(T__16);
				setState(156);
				iGenericTypeArgument();
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(157);
					match(T__10);
					setState(158);
					iGenericTypeArgument();
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(164);
				match(T__17);
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

	public static class IGenericTypeArgumentContext extends ParserRuleContext {
		public IGenericTypeContext iGenericType() {
			return getRuleContext(IGenericTypeContext.class,0);
		}
		public IGenericWildcardContext iGenericWildcard() {
			return getRuleContext(IGenericWildcardContext.class,0);
		}
		public IGenericTypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iGenericTypeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterIGenericTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitIGenericTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitIGenericTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IGenericTypeArgumentContext iGenericTypeArgument() throws RecognitionException {
		IGenericTypeArgumentContext _localctx = new IGenericTypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_iGenericTypeArgument);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__11:
			case T__12:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				iGenericType();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				iGenericWildcard();
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

	public static class IGenericWildcardContext extends ParserRuleContext {
		public Token bound;
		public IGenericTypeContext iGenericType() {
			return getRuleContext(IGenericTypeContext.class,0);
		}
		public IGenericWildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iGenericWildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterIGenericWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitIGenericWildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitIGenericWildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IGenericWildcardContext iGenericWildcard() throws RecognitionException {
		IGenericWildcardContext _localctx = new IGenericWildcardContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_iGenericWildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__19);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9 || _la==T__20) {
				{
				setState(173);
				((IGenericWildcardContext)_localctx).bound = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__20) ) {
					((IGenericWildcardContext)_localctx).bound = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(174);
				iGenericType();
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
		public UnrestrictedNameContext firstSegment;
		public Token index;
		public SegmentContext segment;
		public List<SegmentContext> midSegments = new ArrayList<SegmentContext>();
		public SegmentContext lastSegment;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(ImportsParser.INT, 0); }
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
		}
		public PathNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterPathName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitPathName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitPathName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathNameContext pathName() throws RecognitionException {
		PathNameContext _localctx = new PathNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pathName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			((PathNameContext)_localctx).firstSegment = unrestrictedName();
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(178);
				match(T__21);
				setState(179);
				((PathNameContext)_localctx).index = match(INT);
				}
			}

			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(182);
						((PathNameContext)_localctx).segment = segment();
						((PathNameContext)_localctx).midSegments.add(((PathNameContext)_localctx).segment);
						}
						} 
					}
					setState(187);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				setState(188);
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
		public Token index;
		public UnrestrictedNameContext unrestrictedName() {
			return getRuleContext(UnrestrictedNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(ImportsParser.INT, 0); }
		public SegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SegmentContext segment() throws RecognitionException {
		SegmentContext _localctx = new SegmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_segment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__22);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(192);
				match(T__23);
				}
			}

			setState(195);
			((SegmentContext)_localctx).name = unrestrictedName();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(196);
				match(T__21);
				setState(197);
				((SegmentContext)_localctx).index = match(INT);
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
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterUnrestrictedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitUnrestrictedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitUnrestrictedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnrestrictedNameContext unrestrictedName() throws RecognitionException {
		UnrestrictedNameContext _localctx = new UnrestrictedNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unrestrictedName);
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(T__6);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				match(T__24);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				match(T__25);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				match(T__26);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(205);
				match(T__7);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(206);
				match(T__27);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(207);
				match(T__11);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(208);
				match(T__28);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(209);
				match(T__29);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(210);
				match(T__30);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(211);
				match(T__12);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(212);
				match(T__31);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(213);
				match(T__9);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(214);
				match(T__32);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(215);
				match(T__33);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(216);
				match(T__34);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(217);
				match(T__8);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(218);
				match(T__35);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(219);
				match(T__36);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(220);
				match(T__37);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(221);
				match(T__38);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(222);
				match(T__0);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(223);
				match(T__39);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(224);
				match(T__40);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(225);
				match(T__41);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(226);
				match(T__42);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(227);
				match(T__43);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(228);
				match(T__44);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(229);
				match(T__45);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(230);
				match(T__46);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(231);
				match(T__47);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(232);
				match(T__48);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(233);
				match(T__49);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(234);
				match(T__50);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(235);
				match(T__51);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(236);
				match(T__52);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(237);
				match(T__53);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(238);
				match(T__54);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(239);
				match(T__55);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(240);
				match(T__56);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(241);
				match(T__36);
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
		public TerminalNode IDENTIFIER() { return getToken(ImportsParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3E\u00f9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\3\5\3\60\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3=\n\3\f\3\16\3@\13\3\3\3\3\3\5"+
		"\3D\n\3\3\4\3\4\5\4H\n\4\3\4\3\4\5\4L\n\4\3\5\5\5O\n\5\3\5\5\5R\n\5\3"+
		"\5\3\5\5\5V\n\5\3\5\3\5\5\5Z\n\5\3\5\3\5\3\5\3\5\7\5`\n\5\f\5\16\5c\13"+
		"\5\5\5e\n\5\3\5\3\5\3\6\5\6j\n\6\3\6\3\6\5\6n\n\6\3\6\3\6\5\6r\n\6\3\6"+
		"\3\6\5\6v\n\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\7\t\u008a\n\t\f\t\16\t\u008d\13\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\7\n\u0096\n\n\f\n\16\n\u0099\13\n\5\n\u009b\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u00a2\n\13\f\13\16\13\u00a5\13\13\3\13\3\13"+
		"\5\13\u00a9\n\13\3\f\3\f\5\f\u00ad\n\f\3\r\3\r\3\r\5\r\u00b2\n\r\3\16"+
		"\3\16\3\16\5\16\u00b7\n\16\3\16\7\16\u00ba\n\16\f\16\16\16\u00bd\13\16"+
		"\3\16\5\16\u00c0\n\16\3\17\3\17\5\17\u00c4\n\17\3\17\3\17\3\17\5\17\u00c9"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00f5\n\20\3\21\3\21\3\21\5%>\u0080\2\22\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \2\4\3\2\20\22\4\2\f\f\27\27\u0132\2%\3\2\2\2\4"+
		"/\3\2\2\2\6G\3\2\2\2\bN\3\2\2\2\ni\3\2\2\2\fy\3\2\2\2\16{\3\2\2\2\20\u0085"+
		"\3\2\2\2\22\u0090\3\2\2\2\24\u009c\3\2\2\2\26\u00ac\3\2\2\2\30\u00ae\3"+
		"\2\2\2\32\u00b3\3\2\2\2\34\u00c1\3\2\2\2\36\u00f4\3\2\2\2 \u00f6\3\2\2"+
		"\2\"$\13\2\2\2#\"\3\2\2\2$\'\3\2\2\2%&\3\2\2\2%#\3\2\2\2&+\3\2\2\2\'%"+
		"\3\2\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3\3\2\2\2"+
		"-+\3\2\2\2.\60\5\f\7\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\7\3\2"+
		"\2\62\63\5\36\20\2\63\64\b\3\1\2\64\65\7\4\2\2\65\66\5 \21\2\66\67\7\5"+
		"\2\2\67C\7@\2\28>\7\6\2\29=\5\6\4\2:=\5\4\3\2;=\13\2\2\2<9\3\2\2\2<:\3"+
		"\2\2\2<;\3\2\2\2=@\3\2\2\2>?\3\2\2\2><\3\2\2\2?A\3\2\2\2@>\3\2\2\2AD\7"+
		"\7\2\2BD\7\b\2\2C8\3\2\2\2CB\3\2\2\2D\5\3\2\2\2EH\5\b\5\2FH\5\n\6\2GE"+
		"\3\2\2\2GF\3\2\2\2HK\3\2\2\2IL\5\16\b\2JL\7\b\2\2KI\3\2\2\2KJ\3\2\2\2"+
		"L\7\3\2\2\2MO\5\f\7\2NM\3\2\2\2NO\3\2\2\2OU\3\2\2\2PR\7\t\2\2QP\3\2\2"+
		"\2QR\3\2\2\2RS\3\2\2\2SV\7\n\2\2TV\7\13\2\2UQ\3\2\2\2UT\3\2\2\2VW\3\2"+
		"\2\2WY\5\36\20\2XZ\5\20\t\2YX\3\2\2\2YZ\3\2\2\2Zd\3\2\2\2[\\\7\f\2\2\\"+
		"a\5\24\13\2]^\7\r\2\2^`\5\24\13\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2"+
		"\2\2be\3\2\2\2ca\3\2\2\2d[\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\b\5\1\2g\t\3"+
		"\2\2\2hj\5\f\7\2ih\3\2\2\2ij\3\2\2\2jm\3\2\2\2kn\7\16\2\2ln\7\17\2\2m"+
		"k\3\2\2\2ml\3\2\2\2no\3\2\2\2oq\5\36\20\2pr\5\20\t\2qp\3\2\2\2qr\3\2\2"+
		"\2ru\3\2\2\2st\7\4\2\2tv\7@\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\b\6\1"+
		"\2x\13\3\2\2\2yz\t\2\2\2z\r\3\2\2\2{\u0080\7\6\2\2|\177\5\16\b\2}\177"+
		"\13\2\2\2~|\3\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080\u0081\3\2\2\2\u0080"+
		"~\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\7\2\2"+
		"\u0084\17\3\2\2\2\u0085\u0086\7\23\2\2\u0086\u008b\5\22\n\2\u0087\u0088"+
		"\7\r\2\2\u0088\u008a\5\22\n\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2"+
		"\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b"+
		"\3\2\2\2\u008e\u008f\7\24\2\2\u008f\21\3\2\2\2\u0090\u009a\5\36\20\2\u0091"+
		"\u0092\7\f\2\2\u0092\u0097\5\24\13\2\u0093\u0094\7\25\2\2\u0094\u0096"+
		"\5\24\13\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u0091"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\23\3\2\2\2\u009c\u00a8\5\32\16\2\u009d"+
		"\u009e\7\23\2\2\u009e\u00a3\5\26\f\2\u009f\u00a0\7\r\2\2\u00a0\u00a2\5"+
		"\26\f\2\u00a1\u009f\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7\24"+
		"\2\2\u00a7\u00a9\3\2\2\2\u00a8\u009d\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\25\3\2\2\2\u00aa\u00ad\5\24\13\2\u00ab\u00ad\5\30\r\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ab\3\2\2\2\u00ad\27\3\2\2\2\u00ae\u00b1\7\26\2\2\u00af\u00b0"+
		"\t\3\2\2\u00b0\u00b2\5\24\13\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2"+
		"\u00b2\31\3\2\2\2\u00b3\u00b6\5\36\20\2\u00b4\u00b5\7\30\2\2\u00b5\u00b7"+
		"\7<\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00bf\3\2\2\2\u00b8"+
		"\u00ba\5\34\17\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3"+
		"\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c0\5\34\17\2\u00bf\u00bb\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\33\3\2"+
		"\2\2\u00c1\u00c3\7\31\2\2\u00c2\u00c4\7\32\2\2\u00c3\u00c2\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c8\5\36\20\2\u00c6\u00c7\7"+
		"\30\2\2\u00c7\u00c9\7<\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\35\3\2\2\2\u00ca\u00f5\5 \21\2\u00cb\u00f5\7\t\2\2\u00cc\u00f5\7\33\2"+
		"\2\u00cd\u00f5\7\34\2\2\u00ce\u00f5\7\35\2\2\u00cf\u00f5\7\n\2\2\u00d0"+
		"\u00f5\7\36\2\2\u00d1\u00f5\7\16\2\2\u00d2\u00f5\7\37\2\2\u00d3\u00f5"+
		"\7 \2\2\u00d4\u00f5\7!\2\2\u00d5\u00f5\7\17\2\2\u00d6\u00f5\7\"\2\2\u00d7"+
		"\u00f5\7\f\2\2\u00d8\u00f5\7#\2\2\u00d9\u00f5\7$\2\2\u00da\u00f5\7%\2"+
		"\2\u00db\u00f5\7\13\2\2\u00dc\u00f5\7&\2\2\u00dd\u00f5\7\'\2\2\u00de\u00f5"+
		"\7(\2\2\u00df\u00f5\7)\2\2\u00e0\u00f5\7\3\2\2\u00e1\u00f5\7*\2\2\u00e2"+
		"\u00f5\7+\2\2\u00e3\u00f5\7,\2\2\u00e4\u00f5\7-\2\2\u00e5\u00f5\7.\2\2"+
		"\u00e6\u00f5\7/\2\2\u00e7\u00f5\7\60\2\2\u00e8\u00f5\7\61\2\2\u00e9\u00f5"+
		"\7\62\2\2\u00ea\u00f5\7\63\2\2\u00eb\u00f5\7\64\2\2\u00ec\u00f5\7\65\2"+
		"\2\u00ed\u00f5\7\66\2\2\u00ee\u00f5\7\67\2\2\u00ef\u00f5\78\2\2\u00f0"+
		"\u00f5\79\2\2\u00f1\u00f5\7:\2\2\u00f2\u00f5\7;\2\2\u00f3\u00f5\7\'\2"+
		"\2\u00f4\u00ca\3\2\2\2\u00f4\u00cb\3\2\2\2\u00f4\u00cc\3\2\2\2\u00f4\u00cd"+
		"\3\2\2\2\u00f4\u00ce\3\2\2\2\u00f4\u00cf\3\2\2\2\u00f4\u00d0\3\2\2\2\u00f4"+
		"\u00d1\3\2\2\2\u00f4\u00d2\3\2\2\2\u00f4\u00d3\3\2\2\2\u00f4\u00d4\3\2"+
		"\2\2\u00f4\u00d5\3\2\2\2\u00f4\u00d6\3\2\2\2\u00f4\u00d7\3\2\2\2\u00f4"+
		"\u00d8\3\2\2\2\u00f4\u00d9\3\2\2\2\u00f4\u00da\3\2\2\2\u00f4\u00db\3\2"+
		"\2\2\u00f4\u00dc\3\2\2\2\u00f4\u00dd\3\2\2\2\u00f4\u00de\3\2\2\2\u00f4"+
		"\u00df\3\2\2\2\u00f4\u00e0\3\2\2\2\u00f4\u00e1\3\2\2\2\u00f4\u00e2\3\2"+
		"\2\2\u00f4\u00e3\3\2\2\2\u00f4\u00e4\3\2\2\2\u00f4\u00e5\3\2\2\2\u00f4"+
		"\u00e6\3\2\2\2\u00f4\u00e7\3\2\2\2\u00f4\u00e8\3\2\2\2\u00f4\u00e9\3\2"+
		"\2\2\u00f4\u00ea\3\2\2\2\u00f4\u00eb\3\2\2\2\u00f4\u00ec\3\2\2\2\u00f4"+
		"\u00ed\3\2\2\2\u00f4\u00ee\3\2\2\2\u00f4\u00ef\3\2\2\2\u00f4\u00f0\3\2"+
		"\2\2\u00f4\u00f1\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5"+
		"\37\3\2\2\2\u00f6\u00f7\7=\2\2\u00f7!\3\2\2\2#%+/<>CGKNQUYadimqu~\u0080"+
		"\u008b\u0097\u009a\u00a3\u00a8\u00ac\u00b1\u00b6\u00bb\u00bf\u00c3\u00c8"+
		"\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}