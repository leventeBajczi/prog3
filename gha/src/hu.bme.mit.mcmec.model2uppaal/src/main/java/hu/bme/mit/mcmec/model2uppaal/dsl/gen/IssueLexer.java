// Generated from Issue.g4 by ANTLR 4.5.3
package hu.bme.mit.mcmec.model2uppaal.dsl.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IssueLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LCURLY=1, RCURLY=2, COLON=3, SEMICOLON=4, ISSUE=5, LOAD=6, STORE=7, RELA=8, 
		ACQ=9, SEQ=10, RELE=11, FENCE=12, NAME=13, WHITESPACE=14, NEWLINE=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LOWERCASE", "UPPERCASE", "NUMBERS", "UNDERSCORE", "TILDE", "SLASH", "ASTER", 
		"MINUS", "LCURLY", "RCURLY", "COLON", "SEMICOLON", "ISSUE", "LOAD", "STORE", 
		"RELA", "ACQ", "SEQ", "RELE", "FENCE", "NAME", "WHITESPACE", "NEWLINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "':'", "';'", "'issue'", "'load'", "'store'", "'relaxed'", 
		"'acquire'", "'seq_cst'", "'release'", "'fence'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LCURLY", "RCURLY", "COLON", "SEMICOLON", "ISSUE", "LOAD", "STORE", 
		"RELA", "ACQ", "SEQ", "RELE", "FENCE", "NAME", "WHITESPACE", "NEWLINE"
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


	public IssueLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Issue.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21\u009a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\6\26\u0089"+
		"\n\26\r\26\16\26\u008a\3\27\6\27\u008e\n\27\r\27\16\27\u008f\3\30\5\30"+
		"\u0093\n\30\3\30\3\30\6\30\u0097\n\30\r\30\16\30\u0098\2\2\31\3\2\5\2"+
		"\7\2\t\2\13\2\r\2\17\2\21\2\23\3\25\4\27\5\31\6\33\7\35\b\37\t!\n#\13"+
		"%\f\'\r)\16+\17-\20/\21\3\2\6\3\2c|\3\2C\\\3\2\62;\4\2\13\13\"\"\u009d"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2\2\2\7"+
		"\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2\2\r;\3\2\2\2\17=\3\2\2\2\21?\3\2\2"+
		"\2\23A\3\2\2\2\25C\3\2\2\2\27E\3\2\2\2\31G\3\2\2\2\33I\3\2\2\2\35O\3\2"+
		"\2\2\37T\3\2\2\2!Z\3\2\2\2#b\3\2\2\2%j\3\2\2\2\'r\3\2\2\2)z\3\2\2\2+\u0088"+
		"\3\2\2\2-\u008d\3\2\2\2/\u0096\3\2\2\2\61\62\t\2\2\2\62\4\3\2\2\2\63\64"+
		"\t\3\2\2\64\6\3\2\2\2\65\66\t\4\2\2\66\b\3\2\2\2\678\7a\2\28\n\3\2\2\2"+
		"9:\7\u0080\2\2:\f\3\2\2\2;<\7\61\2\2<\16\3\2\2\2=>\7,\2\2>\20\3\2\2\2"+
		"?@\7/\2\2@\22\3\2\2\2AB\7}\2\2B\24\3\2\2\2CD\7\177\2\2D\26\3\2\2\2EF\7"+
		"<\2\2F\30\3\2\2\2GH\7=\2\2H\32\3\2\2\2IJ\7k\2\2JK\7u\2\2KL\7u\2\2LM\7"+
		"w\2\2MN\7g\2\2N\34\3\2\2\2OP\7n\2\2PQ\7q\2\2QR\7c\2\2RS\7f\2\2S\36\3\2"+
		"\2\2TU\7u\2\2UV\7v\2\2VW\7q\2\2WX\7t\2\2XY\7g\2\2Y \3\2\2\2Z[\7t\2\2["+
		"\\\7g\2\2\\]\7n\2\2]^\7c\2\2^_\7z\2\2_`\7g\2\2`a\7f\2\2a\"\3\2\2\2bc\7"+
		"c\2\2cd\7e\2\2de\7s\2\2ef\7w\2\2fg\7k\2\2gh\7t\2\2hi\7g\2\2i$\3\2\2\2"+
		"jk\7u\2\2kl\7g\2\2lm\7s\2\2mn\7a\2\2no\7e\2\2op\7u\2\2pq\7v\2\2q&\3\2"+
		"\2\2rs\7t\2\2st\7g\2\2tu\7n\2\2uv\7g\2\2vw\7c\2\2wx\7u\2\2xy\7g\2\2y("+
		"\3\2\2\2z{\7h\2\2{|\7g\2\2|}\7p\2\2}~\7e\2\2~\177\7g\2\2\177*\3\2\2\2"+
		"\u0080\u0089\5\3\2\2\u0081\u0089\5\5\3\2\u0082\u0089\5\7\4\2\u0083\u0089"+
		"\5\t\5\2\u0084\u0089\5\13\6\2\u0085\u0089\5\r\7\2\u0086\u0089\5\17\b\2"+
		"\u0087\u0089\5\21\t\2\u0088\u0080\3\2\2\2\u0088\u0081\3\2\2\2\u0088\u0082"+
		"\3\2\2\2\u0088\u0083\3\2\2\2\u0088\u0084\3\2\2\2\u0088\u0085\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b,\3\2\2\2\u008c\u008e\t\5\2\2\u008d\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		".\3\2\2\2\u0091\u0093\7\17\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2"+
		"\u0093\u0094\3\2\2\2\u0094\u0097\7\f\2\2\u0095\u0097\7\17\2\2\u0096\u0092"+
		"\3\2\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\60\3\2\2\2\t\2\u0088\u008a\u008f\u0092\u0096\u0098"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}