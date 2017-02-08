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
		SINGLE_CHARACTER=22, ML_SINGLE_QUOTED_STRING=23, MULTILINE_COMMENT=24, 
		SINGLELINE_COMMENT=25, WS=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", "SINGLE_CHARACTER", 
		"LETTER", "DIGITS", "DIGIT", "ESCAPED_CHARACTER", "UNDERSCORE", "APOSTROPHE", 
		"DOLLAR", "MINUS", "ML_SINGLE_QUOTED_STRING", "MULTILINE_COMMENT", "SINGLELINE_COMMENT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'import'", "':'", "'model'", "'{'", "','", "'}'", "'['", 
		"']'", "'.'", "'::'", "'@'", "'true'", "'false'", "'+'", "'-'", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "INT", "IDENTIFIER", "DOUBLE_QUOTED_STRING", 
		"SINGLE_QUOTED_STRING", "SINGLE_CHARACTER", "ML_SINGLE_QUOTED_STRING", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00ec\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\6\23\177\n\23"+
		"\r\23\16\23\u0080\3\24\3\24\5\24\u0085\n\24\3\24\3\24\3\24\3\24\3\24\7"+
		"\24\u008c\n\24\f\24\16\24\u008f\13\24\3\25\3\25\3\25\7\25\u0094\n\25\f"+
		"\25\16\25\u0097\13\25\3\25\3\25\3\26\3\26\3\26\7\26\u009e\n\26\f\26\16"+
		"\26\u00a1\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\6\31\u00ac"+
		"\n\31\r\31\16\31\u00ad\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3 \3 \7 \u00bf\n \f \16 \u00c2\13 \3 \3 \3 \3 \3!\3"+
		"!\3!\3!\7!\u00cc\n!\f!\16!\u00cf\13!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\7"+
		"\"\u00da\n\"\f\"\16\"\u00dd\13\"\3\"\5\"\u00e0\n\"\3\"\3\"\3\"\3\"\3#"+
		"\6#\u00e7\n#\r#\16#\u00e8\3#\3#\5\u00c0\u00cd\u00db\2$\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\2\61\2\63\2\65\2\67\29\2;\2=\2?\31A\32C\33E\34\3\2"+
		"\b\4\2$$^^\4\2))^^\4\2C\\c|\3\2\62;\n\2$$))^^ddhhppttvw\5\2\13\f\17\17"+
		"\"\"\u00f4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5I\3\2\2\2\7P"+
		"\3\2\2\2\tR\3\2\2\2\13X\3\2\2\2\rZ\3\2\2\2\17\\\3\2\2\2\21^\3\2\2\2\23"+
		"`\3\2\2\2\25b\3\2\2\2\27d\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2\35n\3\2\2\2"+
		"\37t\3\2\2\2!v\3\2\2\2#x\3\2\2\2%~\3\2\2\2\'\u0084\3\2\2\2)\u0090\3\2"+
		"\2\2+\u009a\3\2\2\2-\u00a4\3\2\2\2/\u00a8\3\2\2\2\61\u00ab\3\2\2\2\63"+
		"\u00af\3\2\2\2\65\u00b1\3\2\2\2\67\u00b4\3\2\2\29\u00b6\3\2\2\2;\u00b8"+
		"\3\2\2\2=\u00ba\3\2\2\2?\u00bc\3\2\2\2A\u00c7\3\2\2\2C\u00d5\3\2\2\2E"+
		"\u00e6\3\2\2\2GH\7=\2\2H\4\3\2\2\2IJ\7k\2\2JK\7o\2\2KL\7r\2\2LM\7q\2\2"+
		"MN\7t\2\2NO\7v\2\2O\6\3\2\2\2PQ\7<\2\2Q\b\3\2\2\2RS\7o\2\2ST\7q\2\2TU"+
		"\7f\2\2UV\7g\2\2VW\7n\2\2W\n\3\2\2\2XY\7}\2\2Y\f\3\2\2\2Z[\7.\2\2[\16"+
		"\3\2\2\2\\]\7\177\2\2]\20\3\2\2\2^_\7]\2\2_\22\3\2\2\2`a\7_\2\2a\24\3"+
		"\2\2\2bc\7\60\2\2c\26\3\2\2\2de\7<\2\2ef\7<\2\2f\30\3\2\2\2gh\7B\2\2h"+
		"\32\3\2\2\2ij\7v\2\2jk\7t\2\2kl\7w\2\2lm\7g\2\2m\34\3\2\2\2no\7h\2\2o"+
		"p\7c\2\2pq\7n\2\2qr\7u\2\2rs\7g\2\2s\36\3\2\2\2tu\7-\2\2u \3\2\2\2vw\7"+
		"/\2\2w\"\3\2\2\2xy\7p\2\2yz\7w\2\2z{\7n\2\2{|\7n\2\2|$\3\2\2\2}\177\5"+
		"\63\32\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081&\3\2\2\2\u0082\u0085\5\67\34\2\u0083\u0085\5/\30\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u008d\3\2\2\2\u0086\u008c\5/\30\2\u0087"+
		"\u008c\59\35\2\u0088\u008c\5\63\32\2\u0089\u008c\5\67\34\2\u008a\u008c"+
		"\5;\36\2\u008b\u0086\3\2\2\2\u008b\u0087\3\2\2\2\u008b\u0088\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e(\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0095"+
		"\7$\2\2\u0091\u0094\5\65\33\2\u0092\u0094\n\2\2\2\u0093\u0091\3\2\2\2"+
		"\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7$\2\2\u0099"+
		"*\3\2\2\2\u009a\u009f\7)\2\2\u009b\u009e\5\65\33\2\u009c\u009e\n\3\2\2"+
		"\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u00a3\7)\2\2\u00a3,\3\2\2\2\u00a4\u00a5\7)\2\2\u00a5\u00a6\n\3\2\2\u00a6"+
		"\u00a7\7)\2\2\u00a7.\3\2\2\2\u00a8\u00a9\t\4\2\2\u00a9\60\3\2\2\2\u00aa"+
		"\u00ac\5\63\32\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3"+
		"\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\62\3\2\2\2\u00af\u00b0\t\5\2\2\u00b0"+
		"\64\3\2\2\2\u00b1\u00b2\7^\2\2\u00b2\u00b3\t\6\2\2\u00b3\66\3\2\2\2\u00b4"+
		"\u00b5\7a\2\2\u00b58\3\2\2\2\u00b6\u00b7\7)\2\2\u00b7:\3\2\2\2\u00b8\u00b9"+
		"\7&\2\2\u00b9<\3\2\2\2\u00ba\u00bb\7/\2\2\u00bb>\3\2\2\2\u00bc\u00c0\7"+
		")\2\2\u00bd\u00bf\13\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c3\u00c4\7)\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\b \2\2\u00c6@"+
		"\3\2\2\2\u00c7\u00c8\7\61\2\2\u00c8\u00c9\7,\2\2\u00c9\u00cd\3\2\2\2\u00ca"+
		"\u00cc\13\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00ce\3"+
		"\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d1\7,\2\2\u00d1\u00d2\7\61\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b!"+
		"\2\2\u00d4B\3\2\2\2\u00d5\u00d6\7/\2\2\u00d6\u00d7\7/\2\2\u00d7\u00db"+
		"\3\2\2\2\u00d8\u00da\13\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2"+
		"\u00db\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db"+
		"\3\2\2\2\u00de\u00e0\7\17\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2"+
		"\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7\f\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4"+
		"\b\"\2\2\u00e4D\3\2\2\2\u00e5\u00e7\t\7\2\2\u00e6\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00eb\b#\2\2\u00ebF\3\2\2\2\21\2\u0080\u0084\u008b\u008d\u0093"+
		"\u0095\u009d\u009f\u00ad\u00c0\u00cd\u00db\u00df\u00e8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}