// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\Core.g4 by ANTLR 4.5.1
package eu.modelwriter.traceability.validation.core.fol.generated;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoreLexer extends Lexer {
  static {
    RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7,
      T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15,
      T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, ALL = 21, NO = 22, LONE = 23,
      SOME = 24, ONE = 25, IDENTIFIER = 26, RELATION_NAME = 27, SINGLELINE_COMMENT = 28,
      MULTILINE_COMMENT = 29, WS = 30;
  public static String[] modeNames = {"DEFAULT_MODE"};

  public static final String[] ruleNames = {"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6",
      "T__7", "T__8", "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
      "T__17", "T__18", "T__19", "ALL", "NO", "LONE", "SOME", "ONE", "IDENTIFIER", "RELATION_NAME",
      "SINGLELINE_COMMENT", "MULTILINE_COMMENT", "WS"};

  private static final String[] _LITERAL_NAMES = {null, "'Model:'", "'Sentences:'", "'='", "'{'",
      "','", "'}'", "';'", "'('", "')'", "'!'", "'not'", "'&&'", "'and'", "'||'", "'or'",
      "'implies'", "'->'", "'<->'", "'iff'", "'|'", "'all'", "'no'", "'lone'", "'some'", "'one'"};
  private static final String[] _SYMBOLIC_NAMES =
      {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
          null, null, null, null, null, null, "ALL", "NO", "LONE", "SOME", "ONE", "IDENTIFIER",
          "RELATION_NAME", "SINGLELINE_COMMENT", "MULTILINE_COMMENT", "WS"};
  public static final Vocabulary VOCABULARY =
      new VocabularyImpl(CoreLexer._LITERAL_NAMES, CoreLexer._SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;

  static {
    tokenNames = new String[CoreLexer._SYMBOLIC_NAMES.length];
    for (int i = 0; i < CoreLexer.tokenNames.length; i++) {
      CoreLexer.tokenNames[i] = CoreLexer.VOCABULARY.getLiteralName(i);
      if (CoreLexer.tokenNames[i] == null) {
        CoreLexer.tokenNames[i] = CoreLexer.VOCABULARY.getSymbolicName(i);
      }

      if (CoreLexer.tokenNames[i] == null) {
        CoreLexer.tokenNames[i] = "<INVALID>";
      }
    }
  }

  public static final String _serializedATN =
      "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u00cd\b\1\4\2\t"
          + "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
          + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
          + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
          + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"
          + "\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"
          + "\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f"
          + "\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"
          + "\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23"
          + "\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30"
          + "\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33"
          + "\6\33\u009e\n\33\r\33\16\33\u009f\3\34\6\34\u00a3\n\34\r\34\16\34\u00a4"
          + "\3\35\3\35\3\35\3\35\7\35\u00ab\n\35\f\35\16\35\u00ae\13\35\3\35\5\35"
          + "\u00b1\n\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\7\36\u00bc\n"
          + "\36\f\36\16\36\u00bf\13\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\6\37\u00c8"
          + "\n\37\r\37\16\37\u00c9\3\37\3\37\4\u00ac\u00bd\2 \3\3\5\4\7\5\t\6\13\7"
          + "\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"
          + ")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= \3\2\5\4\2\62;c|\4\2"
          + "C\\c|\5\2\13\f\17\17\"\"\u00d2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"
          + "\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"
          + "\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"
          + "\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"
          + "+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"
          + "\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5F\3\2\2\2\7"
          + "Q\3\2\2\2\tS\3\2\2\2\13U\3\2\2\2\rW\3\2\2\2\17Y\3\2\2\2\21[\3\2\2\2\23"
          + "]\3\2\2\2\25_\3\2\2\2\27a\3\2\2\2\31e\3\2\2\2\33h\3\2\2\2\35l\3\2\2\2"
          + "\37o\3\2\2\2!r\3\2\2\2#z\3\2\2\2%}\3\2\2\2\'\u0081\3\2\2\2)\u0085\3\2"
          + "\2\2+\u0087\3\2\2\2-\u008b\3\2\2\2/\u008e\3\2\2\2\61\u0093\3\2\2\2\63"
          + "\u0098\3\2\2\2\65\u009d\3\2\2\2\67\u00a2\3\2\2\29\u00a6\3\2\2\2;\u00b6"
          + "\3\2\2\2=\u00c7\3\2\2\2?@\7O\2\2@A\7q\2\2AB\7f\2\2BC\7g\2\2CD\7n\2\2D"
          + "E\7<\2\2E\4\3\2\2\2FG\7U\2\2GH\7g\2\2HI\7p\2\2IJ\7v\2\2JK\7g\2\2KL\7p"
          + "\2\2LM\7e\2\2MN\7g\2\2NO\7u\2\2OP\7<\2\2P\6\3\2\2\2QR\7?\2\2R\b\3\2\2"
          + "\2ST\7}\2\2T\n\3\2\2\2UV\7.\2\2V\f\3\2\2\2WX\7\177\2\2X\16\3\2\2\2YZ\7"
          + "=\2\2Z\20\3\2\2\2[\\\7*\2\2\\\22\3\2\2\2]^\7+\2\2^\24\3\2\2\2_`\7#\2\2"
          + "`\26\3\2\2\2ab\7p\2\2bc\7q\2\2cd\7v\2\2d\30\3\2\2\2ef\7(\2\2fg\7(\2\2"
          + "g\32\3\2\2\2hi\7c\2\2ij\7p\2\2jk\7f\2\2k\34\3\2\2\2lm\7~\2\2mn\7~\2\2"
          + "n\36\3\2\2\2op\7q\2\2pq\7t\2\2q \3\2\2\2rs\7k\2\2st\7o\2\2tu\7r\2\2uv"
          + "\7n\2\2vw\7k\2\2wx\7g\2\2xy\7u\2\2y\"\3\2\2\2z{\7/\2\2{|\7@\2\2|$\3\2"
          + "\2\2}~\7>\2\2~\177\7/\2\2\177\u0080\7@\2\2\u0080&\3\2\2\2\u0081\u0082"
          + "\7k\2\2\u0082\u0083\7h\2\2\u0083\u0084\7h\2\2\u0084(\3\2\2\2\u0085\u0086"
          + "\7~\2\2\u0086*\3\2\2\2\u0087\u0088\7c\2\2\u0088\u0089\7n\2\2\u0089\u008a"
          + "\7n\2\2\u008a,\3\2\2\2\u008b\u008c\7p\2\2\u008c\u008d\7q\2\2\u008d.\3"
          + "\2\2\2\u008e\u008f\7n\2\2\u008f\u0090\7q\2\2\u0090\u0091\7p\2\2\u0091"
          + "\u0092\7g\2\2\u0092\60\3\2\2\2\u0093\u0094\7u\2\2\u0094\u0095\7q\2\2\u0095"
          + "\u0096\7o\2\2\u0096\u0097\7g\2\2\u0097\62\3\2\2\2\u0098\u0099\7q\2\2\u0099"
          + "\u009a\7p\2\2\u009a\u009b\7g\2\2\u009b\64\3\2\2\2\u009c\u009e\t\2\2\2"
          + "\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"
          + "\3\2\2\2\u00a0\66\3\2\2\2\u00a1\u00a3\t\3\2\2\u00a2\u00a1\3\2\2\2\u00a3"
          + "\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a58\3\2\2\2"
          + "\u00a6\u00a7\7/\2\2\u00a7\u00a8\7/\2\2\u00a8\u00ac\3\2\2\2\u00a9\u00ab"
          + "\13\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00ad\3\2\2\2"
          + "\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1"
          + "\7\17\2\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2"
          + "\u00b2\u00b3\7\f\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\35\2\2\u00b5:\3"
          + "\2\2\2\u00b6\u00b7\7\61\2\2\u00b7\u00b8\7,\2\2\u00b8\u00b9\7,\2\2\u00b9"
          + "\u00bd\3\2\2\2\u00ba\u00bc\13\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3"
          + "\2\2\2\u00bd\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf"
          + "\u00bd\3\2\2\2\u00c0\u00c1\7,\2\2\u00c1\u00c2\7,\2\2\u00c2\u00c3\7\61"
          + "\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\36\2\2\u00c5<\3\2\2\2\u00c6\u00c8"
          + "\t\4\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"
          + "\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b\37\2\2\u00cc>\3\2\2\2"
          + "\t\2\u009f\u00a4\u00ac\u00b0\u00bd\u00c9\3\b\2\2";

  public static final ATN _ATN =
      new ATNDeserializer().deserialize(CoreLexer._serializedATN.toCharArray());


  static {
    _decisionToDFA = new DFA[CoreLexer._ATN.getNumberOfDecisions()];
    for (int i = 0; i < CoreLexer._ATN.getNumberOfDecisions(); i++) {
      CoreLexer._decisionToDFA[i] = new DFA(CoreLexer._ATN.getDecisionState(i), i);
    }
  }

  public CoreLexer(CharStream input) {
    super(input);
    this._interp = new LexerATNSimulator(this, CoreLexer._ATN, CoreLexer._decisionToDFA,
        CoreLexer._sharedContextCache);
  }

  @Override
  public ATN getATN() {
    return CoreLexer._ATN;
  }

  @Override
  public String getGrammarFileName() {
    return "Core.g4";
  }

  @Override
  public String[] getModeNames() {
    return CoreLexer.modeNames;
  }

  @Override
  public String[] getRuleNames() {
    return CoreLexer.ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return CoreLexer._serializedATN;
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return CoreLexer.tokenNames;
  }

  @Override

  public Vocabulary getVocabulary() {
    return CoreLexer.VOCABULARY;
  }
}
