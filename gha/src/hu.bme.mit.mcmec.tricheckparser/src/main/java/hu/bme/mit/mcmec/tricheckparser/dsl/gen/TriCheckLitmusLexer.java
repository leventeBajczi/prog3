// Generated from TriCheckLitmus.g4 by ANTLR 4.5.3
package hu.bme.mit.mcmec.tricheckparser.dsl.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TriCheckLitmusLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, NUMBERS=2, COMMA=3, LCURLY=4, RCURLY=5, LBRACKET=6, RBRACKET=7, 
		LBRACE=8, RBRACE=9, SEMICOLON=10, ASSIGN=11, LOAD=12, STORE=13, MO=14, 
		EXISTS=15, RELEASE=16, RELAXED=17, ACQUIRE=18, SEQ_CST=19, RICHTEXT=20, 
		RICHER=21, WHITESPACE=22, NEWLINE=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LINE_COMMENT", "LOWERCASE", "UPPERCASE", "NUMBERS", "UNDERSCORE", "TILDE", 
		"SLASH", "ASTER", "MINUS", "COLON", "BACKSLASH", "COMMA", "LCURLY", "RCURLY", 
		"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "SEMICOLON", "ASSIGN", "LOAD", 
		"STORE", "MO", "EXISTS", "RELEASE", "RELAXED", "ACQUIRE", "SEQ_CST", "RICHTEXT", 
		"RICHER", "WHITESPACE", "NEWLINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "','", "'{'", "'}'", "'['", "']'", "'('", "')'", "';'", 
		"'='", "'atomic_load_explicit'", "'atomic_store_explicit'", "'memory_order_'", 
		"'exists'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LINE_COMMENT", "NUMBERS", "COMMA", "LCURLY", "RCURLY", "LBRACKET", 
		"RBRACKET", "LBRACE", "RBRACE", "SEMICOLON", "ASSIGN", "LOAD", "STORE", 
		"MO", "EXISTS", "RELEASE", "RELAXED", "ACQUIRE", "SEQ_CST", "RICHTEXT", 
		"RICHER", "WHITESPACE", "NEWLINE"
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


	public TriCheckLitmusLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TriCheckLitmus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00f9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\6\36"+
		"\u00e1\n\36\r\36\16\36\u00e2\3\37\3\37\3\37\6\37\u00e8\n\37\r\37\16\37"+
		"\u00e9\3 \6 \u00ed\n \r \16 \u00ee\3!\5!\u00f2\n!\3!\3!\6!\u00f6\n!\r"+
		"!\16!\u00f7\2\2\"\3\3\5\2\7\2\t\4\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31"+
		"\5\33\6\35\7\37\b!\t#\n%\13\'\f)\r+\16-\17/\20\61\21\63\22\65\23\67\24"+
		"9\25;\26=\27?\30A\31\3\2\7\4\2\f\f\17\17\3\2c|\3\2C\\\3\2\62;\4\2\13\13"+
		"\"\"\u00ff\2\3\3\2\2\2\2\t\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\3C\3\2\2\2\5N\3\2\2\2\7P\3\2\2\2\tR\3\2\2\2\13T\3\2\2\2\rV\3\2\2"+
		"\2\17X\3\2\2\2\21Z\3\2\2\2\23\\\3\2\2\2\25^\3\2\2\2\27`\3\2\2\2\31b\3"+
		"\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37h\3\2\2\2!j\3\2\2\2#l\3\2\2\2%n\3\2\2"+
		"\2\'p\3\2\2\2)r\3\2\2\2+t\3\2\2\2-\u0089\3\2\2\2/\u009f\3\2\2\2\61\u00ad"+
		"\3\2\2\2\63\u00b4\3\2\2\2\65\u00bd\3\2\2\2\67\u00c6\3\2\2\29\u00cf\3\2"+
		"\2\2;\u00e0\3\2\2\2=\u00e7\3\2\2\2?\u00ec\3\2\2\2A\u00f5\3\2\2\2CD\7\61"+
		"\2\2DE\7\61\2\2EI\3\2\2\2FH\n\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3"+
		"\2\2\2JL\3\2\2\2KI\3\2\2\2LM\b\2\2\2M\4\3\2\2\2NO\t\3\2\2O\6\3\2\2\2P"+
		"Q\t\4\2\2Q\b\3\2\2\2RS\t\5\2\2S\n\3\2\2\2TU\7a\2\2U\f\3\2\2\2VW\7\u0080"+
		"\2\2W\16\3\2\2\2XY\7\61\2\2Y\20\3\2\2\2Z[\7,\2\2[\22\3\2\2\2\\]\7/\2\2"+
		"]\24\3\2\2\2^_\7<\2\2_\26\3\2\2\2`a\7^\2\2a\30\3\2\2\2bc\7.\2\2c\32\3"+
		"\2\2\2de\7}\2\2e\34\3\2\2\2fg\7\177\2\2g\36\3\2\2\2hi\7]\2\2i \3\2\2\2"+
		"jk\7_\2\2k\"\3\2\2\2lm\7*\2\2m$\3\2\2\2no\7+\2\2o&\3\2\2\2pq\7=\2\2q("+
		"\3\2\2\2rs\7?\2\2s*\3\2\2\2tu\7c\2\2uv\7v\2\2vw\7q\2\2wx\7o\2\2xy\7k\2"+
		"\2yz\7e\2\2z{\7a\2\2{|\7n\2\2|}\7q\2\2}~\7c\2\2~\177\7f\2\2\177\u0080"+
		"\7a\2\2\u0080\u0081\7g\2\2\u0081\u0082\7z\2\2\u0082\u0083\7r\2\2\u0083"+
		"\u0084\7n\2\2\u0084\u0085\7k\2\2\u0085\u0086\7e\2\2\u0086\u0087\7k\2\2"+
		"\u0087\u0088\7v\2\2\u0088,\3\2\2\2\u0089\u008a\7c\2\2\u008a\u008b\7v\2"+
		"\2\u008b\u008c\7q\2\2\u008c\u008d\7o\2\2\u008d\u008e\7k\2\2\u008e\u008f"+
		"\7e\2\2\u008f\u0090\7a\2\2\u0090\u0091\7u\2\2\u0091\u0092\7v\2\2\u0092"+
		"\u0093\7q\2\2\u0093\u0094\7t\2\2\u0094\u0095\7g\2\2\u0095\u0096\7a\2\2"+
		"\u0096\u0097\7g\2\2\u0097\u0098\7z\2\2\u0098\u0099\7r\2\2\u0099\u009a"+
		"\7n\2\2\u009a\u009b\7k\2\2\u009b\u009c\7e\2\2\u009c\u009d\7k\2\2\u009d"+
		"\u009e\7v\2\2\u009e.\3\2\2\2\u009f\u00a0\7o\2\2\u00a0\u00a1\7g\2\2\u00a1"+
		"\u00a2\7o\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7{\2\2"+
		"\u00a5\u00a6\7a\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9"+
		"\7f\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7a\2\2\u00ac"+
		"\60\3\2\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7z\2\2\u00af\u00b0\7k\2\2\u00b0"+
		"\u00b1\7u\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7u\2\2\u00b3\62\3\2\2\2\u00b4"+
		"\u00b5\5/\30\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7n\2"+
		"\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc"+
		"\7g\2\2\u00bc\64\3\2\2\2\u00bd\u00be\5/\30\2\u00be\u00bf\7t\2\2\u00bf"+
		"\u00c0\7g\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7z\2\2"+
		"\u00c3\u00c4\7g\2\2\u00c4\u00c5\7f\2\2\u00c5\66\3\2\2\2\u00c6\u00c7\5"+
		"/\30\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7e\2\2\u00c9\u00ca\7s\2\2\u00ca"+
		"\u00cb\7w\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7g\2\2"+
		"\u00ce8\3\2\2\2\u00cf\u00d0\5/\30\2\u00d0\u00d1\7u\2\2\u00d1\u00d2\7g"+
		"\2\2\u00d2\u00d3\7s\2\2\u00d3\u00d4\7a\2\2\u00d4\u00d5\7e\2\2\u00d5\u00d6"+
		"\7u\2\2\u00d6\u00d7\7v\2\2\u00d7:\3\2\2\2\u00d8\u00e1\5\5\3\2\u00d9\u00e1"+
		"\5\7\4\2\u00da\u00e1\5\t\5\2\u00db\u00e1\5\13\6\2\u00dc\u00e1\5\r\7\2"+
		"\u00dd\u00e1\5\17\b\2\u00de\u00e1\5\21\t\2\u00df\u00e1\5\23\n\2\u00e0"+
		"\u00d8\3\2\2\2\u00e0\u00d9\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00db\3\2"+
		"\2\2\u00e0\u00dc\3\2\2\2\u00e0\u00dd\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3<\3\2\2\2\u00e4\u00e8\5\25\13\2\u00e5\u00e8\5\27\f\2\u00e6\u00e8"+
		"\5)\25\2\u00e7\u00e4\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea>\3\2\2\2"+
		"\u00eb\u00ed\t\6\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec"+
		"\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef@\3\2\2\2\u00f0\u00f2\7\17\2\2\u00f1"+
		"\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f6\7\f"+
		"\2\2\u00f4\u00f6\7\17\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8B\3\2\2\2"+
		"\f\2I\u00e0\u00e2\u00e7\u00e9\u00ee\u00f1\u00f5\u00f7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}