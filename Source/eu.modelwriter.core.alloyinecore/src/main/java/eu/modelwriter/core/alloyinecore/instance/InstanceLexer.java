// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/instance/Instance.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.instance;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InstanceLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		INT=18, IDENTIFIER=19, DOUBLE_QUOTED_STRING=20, SINGLE_QUOTED_STRING=21, 
		ML_SINGLE_QUOTED_STRING=22, MULTILINE_COMMENT=23, SINGLELINE_COMMENT=24, 
		WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", "LETTER", 
		"DIGITS", "DIGIT", "ESCAPED_CHARACTER", "UNDERSCORE", "APOSTROPHE", "DOLLAR", 
		"MINUS", "ML_SINGLE_QUOTED_STRING", "MULTILINE_COMMENT", "SINGLELINE_COMMENT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'import'", "':'", "';'", "'model'", "'{'", "','", "'}'", "'['", 
		"']'", "'.'", "'::'", "'@'", "'true'", "'false'", "'+'", "'-'", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", 
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


	public InstanceLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Instance.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00e6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\6\23}\n\23\r\23\16"+
		"\23~\3\24\3\24\5\24\u0083\n\24\3\24\3\24\3\24\3\24\3\24\7\24\u008a\n\24"+
		"\f\24\16\24\u008d\13\24\3\25\3\25\3\25\7\25\u0092\n\25\f\25\16\25\u0095"+
		"\13\25\3\25\3\25\3\26\3\26\3\26\7\26\u009c\n\26\f\26\16\26\u009f\13\26"+
		"\3\26\3\26\3\27\3\27\3\30\6\30\u00a6\n\30\r\30\16\30\u00a7\3\31\3\31\3"+
		"\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\7\37\u00b9"+
		"\n\37\f\37\16\37\u00bc\13\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \7 \u00c6"+
		"\n \f \16 \u00c9\13 \3 \3 \3 \3 \3 \3!\3!\3!\3!\7!\u00d4\n!\f!\16!\u00d7"+
		"\13!\3!\5!\u00da\n!\3!\3!\3!\3!\3\"\6\"\u00e1\n\"\r\"\16\"\u00e2\3\"\3"+
		"\"\5\u00ba\u00c7\u00d5\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\2/\2\61\2\63"+
		"\2\65\2\67\29\2;\2=\30?\31A\32C\33\3\2\b\4\2$$^^\4\2))^^\4\2C\\c|\3\2"+
		"\62;\n\2$$))^^ddhhppttvw\5\2\13\f\17\17\"\"\u00ee\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\3E\3\2\2\2\5L\3\2\2\2\7N\3\2\2\2\tP\3\2\2\2\13V\3\2\2\2\rX\3\2\2\2"+
		"\17Z\3\2\2\2\21\\\3\2\2\2\23^\3\2\2\2\25`\3\2\2\2\27b\3\2\2\2\31e\3\2"+
		"\2\2\33g\3\2\2\2\35l\3\2\2\2\37r\3\2\2\2!t\3\2\2\2#v\3\2\2\2%|\3\2\2\2"+
		"\'\u0082\3\2\2\2)\u008e\3\2\2\2+\u0098\3\2\2\2-\u00a2\3\2\2\2/\u00a5\3"+
		"\2\2\2\61\u00a9\3\2\2\2\63\u00ab\3\2\2\2\65\u00ae\3\2\2\2\67\u00b0\3\2"+
		"\2\29\u00b2\3\2\2\2;\u00b4\3\2\2\2=\u00b6\3\2\2\2?\u00c1\3\2\2\2A\u00cf"+
		"\3\2\2\2C\u00e0\3\2\2\2EF\7k\2\2FG\7o\2\2GH\7r\2\2HI\7q\2\2IJ\7t\2\2J"+
		"K\7v\2\2K\4\3\2\2\2LM\7<\2\2M\6\3\2\2\2NO\7=\2\2O\b\3\2\2\2PQ\7o\2\2Q"+
		"R\7q\2\2RS\7f\2\2ST\7g\2\2TU\7n\2\2U\n\3\2\2\2VW\7}\2\2W\f\3\2\2\2XY\7"+
		".\2\2Y\16\3\2\2\2Z[\7\177\2\2[\20\3\2\2\2\\]\7]\2\2]\22\3\2\2\2^_\7_\2"+
		"\2_\24\3\2\2\2`a\7\60\2\2a\26\3\2\2\2bc\7<\2\2cd\7<\2\2d\30\3\2\2\2ef"+
		"\7B\2\2f\32\3\2\2\2gh\7v\2\2hi\7t\2\2ij\7w\2\2jk\7g\2\2k\34\3\2\2\2lm"+
		"\7h\2\2mn\7c\2\2no\7n\2\2op\7u\2\2pq\7g\2\2q\36\3\2\2\2rs\7-\2\2s \3\2"+
		"\2\2tu\7/\2\2u\"\3\2\2\2vw\7p\2\2wx\7w\2\2xy\7n\2\2yz\7n\2\2z$\3\2\2\2"+
		"{}\5\61\31\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177&\3\2\2\2\u0080"+
		"\u0083\5\65\33\2\u0081\u0083\5-\27\2\u0082\u0080\3\2\2\2\u0082\u0081\3"+
		"\2\2\2\u0083\u008b\3\2\2\2\u0084\u008a\5-\27\2\u0085\u008a\5\67\34\2\u0086"+
		"\u008a\5\61\31\2\u0087\u008a\5\65\33\2\u0088\u008a\59\35\2\u0089\u0084"+
		"\3\2\2\2\u0089\u0085\3\2\2\2\u0089\u0086\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c(\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0093\7$\2\2\u008f\u0092"+
		"\5\63\32\2\u0090\u0092\n\2\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2"+
		"\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7$\2\2\u0097*\3\2\2\2\u0098\u009d"+
		"\7)\2\2\u0099\u009c\5\63\32\2\u009a\u009c\n\3\2\2\u009b\u0099\3\2\2\2"+
		"\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7)\2\2\u00a1"+
		",\3\2\2\2\u00a2\u00a3\t\4\2\2\u00a3.\3\2\2\2\u00a4\u00a6\5\61\31\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\60\3\2\2\2\u00a9\u00aa\t\5\2\2\u00aa\62\3\2\2\2\u00ab\u00ac"+
		"\7^\2\2\u00ac\u00ad\t\6\2\2\u00ad\64\3\2\2\2\u00ae\u00af\7a\2\2\u00af"+
		"\66\3\2\2\2\u00b0\u00b1\7)\2\2\u00b18\3\2\2\2\u00b2\u00b3\7&\2\2\u00b3"+
		":\3\2\2\2\u00b4\u00b5\7/\2\2\u00b5<\3\2\2\2\u00b6\u00ba\7)\2\2\u00b7\u00b9"+
		"\13\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00bb\3\2\2\2"+
		"\u00ba\u00b8\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be"+
		"\7)\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\b\37\2\2\u00c0>\3\2\2\2\u00c1"+
		"\u00c2\7\61\2\2\u00c2\u00c3\7,\2\2\u00c3\u00c7\3\2\2\2\u00c4\u00c6\13"+
		"\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7,"+
		"\2\2\u00cb\u00cc\7\61\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b \2\2\u00ce"+
		"@\3\2\2\2\u00cf\u00d0\7/\2\2\u00d0\u00d1\7/\2\2\u00d1\u00d5\3\2\2\2\u00d2"+
		"\u00d4\13\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d6\3"+
		"\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8"+
		"\u00da\7\17\2\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3"+
		"\2\2\2\u00db\u00dc\7\f\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\b!\2\2\u00de"+
		"B\3\2\2\2\u00df\u00e1\t\7\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2"+
		"\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5"+
		"\b\"\2\2\u00e5D\3\2\2\2\21\2~\u0082\u0089\u008b\u0091\u0093\u009b\u009d"+
		"\u00a7\u00ba\u00c7\u00d5\u00d9\u00e2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}