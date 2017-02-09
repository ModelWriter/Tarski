// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/packageimport/Imports.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.packageimport;

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
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, INT=59, IDENTIFIER=60, 
		DOUBLE_QUOTED_STRING=61, SINGLE_QUOTED_STRING=62, ML_SINGLE_QUOTED_STRING=63, 
		MULTILINE_COMMENT=64, SINGLELINE_COMMENT=65, WS=66, ANY=67;
	public static final int
		RULE_importedFile = 0, RULE_iPackage = 1, RULE_iClassifier = 2, RULE_iClass = 3, 
		RULE_iDataType = 4, RULE_visibility = 5, RULE_block = 6, RULE_templateSignature = 7, 
		RULE_iTypeParameter = 8, RULE_iGenericType = 9, RULE_iGenericTypeArgument = 10, 
		RULE_iGenericWildcard = 11, RULE_pathName = 12, RULE_segment = 13, RULE_integer = 14, 
		RULE_unrestrictedName = 15, RULE_identifier = 16;
	public static final String[] ruleNames = {
		"importedFile", "iPackage", "iClassifier", "iClass", "iDataType", "visibility", 
		"block", "templateSignature", "iTypeParameter", "iGenericType", "iGenericTypeArgument", 
		"iGenericWildcard", "pathName", "segment", "integer", "unrestrictedName", 
		"identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'package'", "':'", "'='", "'{'", "'}'", "';'", "'abstract'", "'class'", 
		"'interface'", "'extends'", "','", "'datatype'", "'enum'", "'public'", 
		"'protected'", "'private'", "'<'", "'>'", "'&'", "'?'", "'super'", "'::'", 
		"'@'", "'.'", "'attribute'", "'body'", "'callable'", "'composes'", "'definition'", 
		"'derivation'", "'derived'", "'ensure'", "'id'", "'import'", "'initial'", 
		"'key'", "'module'", "'operation'", "'ordered'", "'postcondition'", "'precondition'", 
		"'primitive'", "'property'", "'readonly'", "'reference'", "'require'", 
		"'resolve'", "'static'", "'throws'", "'transient'", "'unique'", "'unsettable'", 
		"'volatile'", "'invariant'", "'literal'", "'serializable'", "'annotation'", 
		"'model'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "INT", 
		"IDENTIFIER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", "ML_SINGLE_QUOTED_STRING", 
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
	public static class ImportedFileContext extends ParserRuleContext {
		public Element owner;
		public List<IPackageContext> iPackage() {
			return getRuleContexts(IPackageContext.class);
		}
		public IPackageContext iPackage(int i) {
			return getRuleContext(IPackageContext.class,i);
		}
		public ImportedFileContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ImportedFileContext(ParserRuleContext parent, int invokingState, Element owner) {
			super(parent, invokingState);
			this.owner = owner;
		}
		@Override public int getRuleIndex() { return RULE_importedFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterImportedFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitImportedFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitImportedFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportedFileContext importedFile(Element owner) throws RecognitionException {
		ImportedFileContext _localctx = new ImportedFileContext(_ctx, getState(), owner);
		enterRule(_localctx, 0, RULE_importedFile);
		owningElement=owner;
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(34);
					matchWildcard();
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) {
				{
				{
				setState(40);
				iPackage(owningElement);
				}
				}
				setState(45);
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
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) {
				{
				setState(46);
				visibility();
				}
			}

			setState(49);
			match(T__0);
			setState(50);
			((IPackageContext)_localctx).name = unrestrictedName();
			((IPackageContext)_localctx).current =  new ImportedPackage(_localctx);
			setState(52);
			match(T__1);
			setState(53);
			identifier();
			setState(54);
			match(T__2);
			setState(55);
			((IPackageContext)_localctx).nsURI = match(SINGLE_QUOTED_STRING);
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(56);
				match(T__3);
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						setState(60);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							setState(57);
							iClassifier(_localctx.current);
							}
							break;
						case 2:
							{
							setState(58);
							iPackage(_localctx.current);
							}
							break;
						case 3:
							{
							setState(59);
							matchWildcard();
							}
							break;
						}
						} 
					}
					setState(64);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(65);
				match(T__4);
				}
				break;
			case T__5:
				{
				setState(66);
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
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(69);
				iClass(_localctx.owner);
				}
				break;
			case 2:
				{
				setState(70);
				iDataType(_localctx.owner);
				}
				break;
			}
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(73);
				block();
				}
				break;
			case T__5:
				{
				setState(74);
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
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) {
				{
				setState(77);
				visibility();
				}
			}

			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
				{
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(80);
					((IClassContext)_localctx).isAbstract = match(T__6);
					}
				}

				setState(83);
				((IClassContext)_localctx).isClass = match(T__7);
				}
				break;
			case T__8:
				{
				setState(84);
				((IClassContext)_localctx).isInterface = match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(87);
			((IClassContext)_localctx).name = unrestrictedName();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(88);
				templateSignature();
				}
			}

			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(91);
				match(T__9);
				setState(92);
				iGenericType();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(93);
					match(T__10);
					setState(94);
					iGenericType();
					}
					}
					setState(99);
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
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) {
				{
				setState(104);
				visibility();
				}
			}

			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(107);
				((IDataTypeContext)_localctx).isDataType = match(T__11);
				}
				break;
			case T__12:
				{
				setState(108);
				((IDataTypeContext)_localctx).isEnum = match(T__12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(111);
			((IDataTypeContext)_localctx).name = unrestrictedName();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(112);
				templateSignature();
				}
			}

			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(115);
				match(T__1);
				setState(116);
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
			setState(121);
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
			setState(123);
			match(T__3);
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(126);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(124);
						block();
						}
						break;
					case 2:
						{
						setState(125);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(131);
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
			setState(133);
			match(T__16);
			setState(134);
			iTypeParameter();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(135);
				match(T__10);
				setState(136);
				iTypeParameter();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
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
			setState(144);
			unrestrictedName();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(145);
				match(T__9);
				setState(146);
				iGenericType();
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__18) {
					{
					{
					setState(147);
					match(T__18);
					setState(148);
					iGenericType();
					}
					}
					setState(153);
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
			setState(156);
			pathName();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(157);
				match(T__16);
				setState(158);
				iGenericTypeArgument();
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(159);
					match(T__10);
					setState(160);
					iGenericTypeArgument();
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(166);
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
			setState(172);
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
			case T__57:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				iGenericType();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
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
			setState(174);
			match(T__19);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9 || _la==T__20) {
				{
				setState(175);
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
				setState(176);
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
			setState(179);
			((PathNameContext)_localctx).firstSegment = unrestrictedName();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(180);
						((PathNameContext)_localctx).segment = segment();
						((PathNameContext)_localctx).midSegments.add(((PathNameContext)_localctx).segment);
						}
						} 
					}
					setState(185);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(186);
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
			setState(189);
			match(T__21);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(190);
				match(T__22);
				}
			}

			setState(193);
			((SegmentContext)_localctx).name = unrestrictedName();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(194);
				match(T__23);
				setState(195);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ImportsParser.INT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImportsListener ) ((ImportsListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImportsVisitor ) return ((ImportsVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
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
		enterRule(_localctx, 30, RULE_unrestrictedName);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				identifier();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(T__6);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				match(T__24);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				match(T__25);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				match(T__26);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(205);
				match(T__7);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 7);
				{
				setState(206);
				match(T__27);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 8);
				{
				setState(207);
				match(T__11);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 9);
				{
				setState(208);
				match(T__28);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 10);
				{
				setState(209);
				match(T__29);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 11);
				{
				setState(210);
				match(T__30);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 12);
				{
				setState(211);
				match(T__12);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 13);
				{
				setState(212);
				match(T__31);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 14);
				{
				setState(213);
				match(T__9);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 15);
				{
				setState(214);
				match(T__32);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 16);
				{
				setState(215);
				match(T__33);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 17);
				{
				setState(216);
				match(T__34);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 18);
				{
				setState(217);
				match(T__8);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 19);
				{
				setState(218);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 20);
				{
				setState(219);
				match(T__36);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 21);
				{
				setState(220);
				match(T__37);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 22);
				{
				setState(221);
				match(T__38);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 23);
				{
				setState(222);
				match(T__0);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 24);
				{
				setState(223);
				match(T__39);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 25);
				{
				setState(224);
				match(T__40);
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 26);
				{
				setState(225);
				match(T__41);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 27);
				{
				setState(226);
				match(T__42);
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 28);
				{
				setState(227);
				match(T__43);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 29);
				{
				setState(228);
				match(T__44);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 30);
				{
				setState(229);
				match(T__45);
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 31);
				{
				setState(230);
				match(T__46);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 32);
				{
				setState(231);
				match(T__47);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 33);
				{
				setState(232);
				match(T__48);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 34);
				{
				setState(233);
				match(T__49);
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 35);
				{
				setState(234);
				match(T__50);
				}
				break;
			case T__51:
				enterOuterAlt(_localctx, 36);
				{
				setState(235);
				match(T__51);
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 37);
				{
				setState(236);
				match(T__52);
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 38);
				{
				setState(237);
				match(T__53);
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 39);
				{
				setState(238);
				match(T__54);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 40);
				{
				setState(239);
				match(T__55);
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 41);
				{
				setState(240);
				match(T__56);
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 42);
				{
				setState(241);
				match(T__57);
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
		enterRule(_localctx, 32, RULE_identifier);
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
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\3\5\3\62\n"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B\13\3"+
		"\3\3\3\3\5\3F\n\3\3\4\3\4\5\4J\n\4\3\4\3\4\5\4N\n\4\3\5\5\5Q\n\5\3\5\5"+
		"\5T\n\5\3\5\3\5\5\5X\n\5\3\5\3\5\5\5\\\n\5\3\5\3\5\3\5\3\5\7\5b\n\5\f"+
		"\5\16\5e\13\5\5\5g\n\5\3\5\3\5\3\6\5\6l\n\6\3\6\3\6\5\6p\n\6\3\6\3\6\5"+
		"\6t\n\6\3\6\3\6\5\6x\n\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7\b\u0081\n\b\f\b"+
		"\16\b\u0084\13\b\3\b\3\b\3\t\3\t\3\t\3\t\7\t\u008c\n\t\f\t\16\t\u008f"+
		"\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n\u0098\n\n\f\n\16\n\u009b\13\n\5"+
		"\n\u009d\n\n\3\13\3\13\3\13\3\13\3\13\7\13\u00a4\n\13\f\13\16\13\u00a7"+
		"\13\13\3\13\3\13\5\13\u00ab\n\13\3\f\3\f\5\f\u00af\n\f\3\r\3\r\3\r\5\r"+
		"\u00b4\n\r\3\16\3\16\7\16\u00b8\n\16\f\16\16\16\u00bb\13\16\3\16\5\16"+
		"\u00be\n\16\3\17\3\17\5\17\u00c2\n\17\3\17\3\17\3\17\5\17\u00c7\n\17\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\5\21\u00f5\n\21\3\22\3\22\3\22\5\'@\u0082\2\23\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"\2\4\3\2\20\22\4\2\f\f\27\27\u0130\2\'\3\2"+
		"\2\2\4\61\3\2\2\2\6I\3\2\2\2\bP\3\2\2\2\nk\3\2\2\2\f{\3\2\2\2\16}\3\2"+
		"\2\2\20\u0087\3\2\2\2\22\u0092\3\2\2\2\24\u009e\3\2\2\2\26\u00ae\3\2\2"+
		"\2\30\u00b0\3\2\2\2\32\u00b5\3\2\2\2\34\u00bf\3\2\2\2\36\u00c8\3\2\2\2"+
		" \u00f4\3\2\2\2\"\u00f6\3\2\2\2$&\13\2\2\2%$\3\2\2\2&)\3\2\2\2\'(\3\2"+
		"\2\2\'%\3\2\2\2(-\3\2\2\2)\'\3\2\2\2*,\5\4\3\2+*\3\2\2\2,/\3\2\2\2-+\3"+
		"\2\2\2-.\3\2\2\2.\3\3\2\2\2/-\3\2\2\2\60\62\5\f\7\2\61\60\3\2\2\2\61\62"+
		"\3\2\2\2\62\63\3\2\2\2\63\64\7\3\2\2\64\65\5 \21\2\65\66\b\3\1\2\66\67"+
		"\7\4\2\2\678\5\"\22\289\7\5\2\29E\7@\2\2:@\7\6\2\2;?\5\6\4\2<?\5\4\3\2"+
		"=?\13\2\2\2>;\3\2\2\2><\3\2\2\2>=\3\2\2\2?B\3\2\2\2@A\3\2\2\2@>\3\2\2"+
		"\2AC\3\2\2\2B@\3\2\2\2CF\7\7\2\2DF\7\b\2\2E:\3\2\2\2ED\3\2\2\2F\5\3\2"+
		"\2\2GJ\5\b\5\2HJ\5\n\6\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KN\5\16\b\2LN\7"+
		"\b\2\2MK\3\2\2\2ML\3\2\2\2N\7\3\2\2\2OQ\5\f\7\2PO\3\2\2\2PQ\3\2\2\2QW"+
		"\3\2\2\2RT\7\t\2\2SR\3\2\2\2ST\3\2\2\2TU\3\2\2\2UX\7\n\2\2VX\7\13\2\2"+
		"WS\3\2\2\2WV\3\2\2\2XY\3\2\2\2Y[\5 \21\2Z\\\5\20\t\2[Z\3\2\2\2[\\\3\2"+
		"\2\2\\f\3\2\2\2]^\7\f\2\2^c\5\24\13\2_`\7\r\2\2`b\5\24\13\2a_\3\2\2\2"+
		"be\3\2\2\2ca\3\2\2\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f]\3\2\2\2fg\3\2\2\2"+
		"gh\3\2\2\2hi\b\5\1\2i\t\3\2\2\2jl\5\f\7\2kj\3\2\2\2kl\3\2\2\2lo\3\2\2"+
		"\2mp\7\16\2\2np\7\17\2\2om\3\2\2\2on\3\2\2\2pq\3\2\2\2qs\5 \21\2rt\5\20"+
		"\t\2sr\3\2\2\2st\3\2\2\2tw\3\2\2\2uv\7\4\2\2vx\7@\2\2wu\3\2\2\2wx\3\2"+
		"\2\2xy\3\2\2\2yz\b\6\1\2z\13\3\2\2\2{|\t\2\2\2|\r\3\2\2\2}\u0082\7\6\2"+
		"\2~\u0081\5\16\b\2\177\u0081\13\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2"+
		"\u0081\u0084\3\2\2\2\u0082\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\7\2\2\u0086\17\3\2\2\2\u0087"+
		"\u0088\7\23\2\2\u0088\u008d\5\22\n\2\u0089\u008a\7\r\2\2\u008a\u008c\5"+
		"\22\n\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\24"+
		"\2\2\u0091\21\3\2\2\2\u0092\u009c\5 \21\2\u0093\u0094\7\f\2\2\u0094\u0099"+
		"\5\24\13\2\u0095\u0096\7\25\2\2\u0096\u0098\5\24\13\2\u0097\u0095\3\2"+
		"\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u0093\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\23\3\2\2\2\u009e\u00aa\5\32\16\2\u009f\u00a0\7\23\2\2\u00a0"+
		"\u00a5\5\26\f\2\u00a1\u00a2\7\r\2\2\u00a2\u00a4\5\26\f\2\u00a3\u00a1\3"+
		"\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\24\2\2\u00a9\u00ab\3"+
		"\2\2\2\u00aa\u009f\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\25\3\2\2\2\u00ac"+
		"\u00af\5\24\13\2\u00ad\u00af\5\30\r\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad"+
		"\3\2\2\2\u00af\27\3\2\2\2\u00b0\u00b3\7\26\2\2\u00b1\u00b2\t\3\2\2\u00b2"+
		"\u00b4\5\24\13\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\31\3\2"+
		"\2\2\u00b5\u00bd\5 \21\2\u00b6\u00b8\5\34\17\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\5\34\17\2\u00bd\u00b9\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\33\3\2\2\2\u00bf\u00c1\7\30\2\2\u00c0\u00c2\7\31"+
		"\2\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c6\5 \21\2\u00c4\u00c5\7\32\2\2\u00c5\u00c7\5\36\20\2\u00c6\u00c4"+
		"\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\35\3\2\2\2\u00c8\u00c9\7=\2\2\u00c9"+
		"\37\3\2\2\2\u00ca\u00f5\5\"\22\2\u00cb\u00f5\7\t\2\2\u00cc\u00f5\7\33"+
		"\2\2\u00cd\u00f5\7\34\2\2\u00ce\u00f5\7\35\2\2\u00cf\u00f5\7\n\2\2\u00d0"+
		"\u00f5\7\36\2\2\u00d1\u00f5\7\16\2\2\u00d2\u00f5\7\37\2\2\u00d3\u00f5"+
		"\7 \2\2\u00d4\u00f5\7!\2\2\u00d5\u00f5\7\17\2\2\u00d6\u00f5\7\"\2\2\u00d7"+
		"\u00f5\7\f\2\2\u00d8\u00f5\7#\2\2\u00d9\u00f5\7$\2\2\u00da\u00f5\7%\2"+
		"\2\u00db\u00f5\7\13\2\2\u00dc\u00f5\7&\2\2\u00dd\u00f5\7\'\2\2\u00de\u00f5"+
		"\7(\2\2\u00df\u00f5\7)\2\2\u00e0\u00f5\7\3\2\2\u00e1\u00f5\7*\2\2\u00e2"+
		"\u00f5\7+\2\2\u00e3\u00f5\7,\2\2\u00e4\u00f5\7-\2\2\u00e5\u00f5\7.\2\2"+
		"\u00e6\u00f5\7/\2\2\u00e7\u00f5\7\60\2\2\u00e8\u00f5\7\61\2\2\u00e9\u00f5"+
		"\7\62\2\2\u00ea\u00f5\7\63\2\2\u00eb\u00f5\7\64\2\2\u00ec\u00f5\7\65\2"+
		"\2\u00ed\u00f5\7\66\2\2\u00ee\u00f5\7\67\2\2\u00ef\u00f5\78\2\2\u00f0"+
		"\u00f5\79\2\2\u00f1\u00f5\7:\2\2\u00f2\u00f5\7;\2\2\u00f3\u00f5\7<\2\2"+
		"\u00f4\u00ca\3\2\2\2\u00f4\u00cb\3\2\2\2\u00f4\u00cc\3\2\2\2\u00f4\u00cd"+
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
		"!\3\2\2\2\u00f6\u00f7\7>\2\2\u00f7#\3\2\2\2\"\'-\61>@EIMPSW[cfkosw\u0080"+
		"\u0082\u008d\u0099\u009c\u00a5\u00aa\u00ae\u00b3\u00b9\u00bd\u00c1\u00c6"+
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