// Generated from Issue.g4 by ANTLR 4.5.3
package hu.bme.mit.mcmec.model2uppaal.dsl.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IssueParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LCURLY=1, RCURLY=2, COLON=3, SEMICOLON=4, ISSUE=5, LOAD=6, STORE=7, RELA=8, 
		ACQ=9, SEQ=10, RELE=11, FENCE=12, NAME=13, WHITESPACE=14, NEWLINE=15;
	public static final int
		RULE_issues = 0, RULE_issue = 1, RULE_threads = 2, RULE_thread = 3, RULE_io = 4;
	public static final String[] ruleNames = {
		"issues", "issue", "threads", "thread", "io"
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

	@Override
	public String getGrammarFileName() { return "Issue.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IssueParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class IssuesContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(IssueParser.EOF, 0); }
		public List<IssueContext> issue() {
			return getRuleContexts(IssueContext.class);
		}
		public IssueContext issue(int i) {
			return getRuleContext(IssueContext.class,i);
		}
		public IssuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_issues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).enterIssues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).exitIssues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IssueVisitor ) return ((IssueVisitor<? extends T>)visitor).visitIssues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IssuesContext issues() throws RecognitionException {
		IssuesContext _localctx = new IssuesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_issues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				issue();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ISSUE );
			setState(15);
			match(EOF);
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

	public static class IssueContext extends ParserRuleContext {
		public TerminalNode ISSUE() { return getToken(IssueParser.ISSUE, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(IssueParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(IssueParser.WHITESPACE, i);
		}
		public TerminalNode NAME() { return getToken(IssueParser.NAME, 0); }
		public TerminalNode LCURLY() { return getToken(IssueParser.LCURLY, 0); }
		public ThreadsContext threads() {
			return getRuleContext(ThreadsContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(IssueParser.RCURLY, 0); }
		public TerminalNode NEWLINE() { return getToken(IssueParser.NEWLINE, 0); }
		public IssueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_issue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).enterIssue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).exitIssue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IssueVisitor ) return ((IssueVisitor<? extends T>)visitor).visitIssue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IssueContext issue() throws RecognitionException {
		IssueContext _localctx = new IssueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_issue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			match(ISSUE);
			setState(18);
			match(WHITESPACE);
			setState(19);
			match(NAME);
			setState(21);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(20);
				match(WHITESPACE);
				}
			}

			setState(23);
			match(LCURLY);
			setState(25);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(24);
				match(WHITESPACE);
				}
			}

			setState(27);
			threads();
			setState(29);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(28);
				match(WHITESPACE);
				}
			}

			setState(31);
			match(RCURLY);
			setState(33);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(32);
				match(WHITESPACE);
				}
			}

			setState(35);
			match(NEWLINE);
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

	public static class ThreadsContext extends ParserRuleContext {
		public List<ThreadContext> thread() {
			return getRuleContexts(ThreadContext.class);
		}
		public ThreadContext thread(int i) {
			return getRuleContext(ThreadContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(IssueParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(IssueParser.WHITESPACE, i);
		}
		public List<TerminalNode> COLON() { return getTokens(IssueParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(IssueParser.COLON, i);
		}
		public ThreadsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_threads; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).enterThreads(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).exitThreads(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IssueVisitor ) return ((IssueVisitor<? extends T>)visitor).visitThreads(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThreadsContext threads() throws RecognitionException {
		ThreadsContext _localctx = new ThreadsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_threads);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			thread();
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(38);
				match(WHITESPACE);
				}
				break;
			}
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COLON) {
				{
				{
				setState(41);
				match(COLON);
				setState(43);
				_la = _input.LA(1);
				if (_la==WHITESPACE) {
					{
					setState(42);
					match(WHITESPACE);
					}
				}

				setState(45);
				thread();
				}
				}
				setState(50);
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

	public static class ThreadContext extends ParserRuleContext {
		public List<IoContext> io() {
			return getRuleContexts(IoContext.class);
		}
		public IoContext io(int i) {
			return getRuleContext(IoContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(IssueParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(IssueParser.WHITESPACE, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(IssueParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(IssueParser.SEMICOLON, i);
		}
		public ThreadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thread; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).enterThread(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).exitThread(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IssueVisitor ) return ((IssueVisitor<? extends T>)visitor).visitThread(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThreadContext thread() throws RecognitionException {
		ThreadContext _localctx = new ThreadContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_thread);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			io();
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(52);
				match(WHITESPACE);
				}
				break;
			}
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(56);
					_la = _input.LA(1);
					if (_la==WHITESPACE) {
						{
						setState(55);
						match(WHITESPACE);
						}
					}

					setState(58);
					match(SEMICOLON);
					setState(60);
					_la = _input.LA(1);
					if (_la==WHITESPACE) {
						{
						setState(59);
						match(WHITESPACE);
						}
					}

					setState(62);
					io();
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class IoContext extends ParserRuleContext {
		public TerminalNode WHITESPACE() { return getToken(IssueParser.WHITESPACE, 0); }
		public TerminalNode STORE() { return getToken(IssueParser.STORE, 0); }
		public TerminalNode RELA() { return getToken(IssueParser.RELA, 0); }
		public TerminalNode RELE() { return getToken(IssueParser.RELE, 0); }
		public TerminalNode SEQ() { return getToken(IssueParser.SEQ, 0); }
		public TerminalNode LOAD() { return getToken(IssueParser.LOAD, 0); }
		public TerminalNode ACQ() { return getToken(IssueParser.ACQ, 0); }
		public IoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_io; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).enterIo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IssueListener ) ((IssueListener)listener).exitIo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IssueVisitor ) return ((IssueVisitor<? extends T>)visitor).visitIo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IoContext io() throws RecognitionException {
		IoContext _localctx = new IoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_io);
		int _la;
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(68);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RELA) | (1L << SEQ) | (1L << RELE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(69);
				match(WHITESPACE);
				setState(70);
				match(STORE);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(71);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RELA) | (1L << ACQ) | (1L << SEQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(72);
				match(WHITESPACE);
				setState(73);
				match(LOAD);
				}
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21O\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\5\3\30\n\3\3\3\3\3\5\3\34\n\3\3\3\3\3\5\3 \n\3\3\3\3\3\5\3$\n"+
		"\3\3\3\3\3\3\4\3\4\5\4*\n\4\3\4\3\4\5\4.\n\4\3\4\7\4\61\n\4\f\4\16\4\64"+
		"\13\4\3\5\3\5\5\58\n\5\3\5\5\5;\n\5\3\5\3\5\5\5?\n\5\3\5\7\5B\n\5\f\5"+
		"\16\5E\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6M\n\6\3\6\2\2\7\2\4\6\b\n\2\4\4"+
		"\2\n\n\f\r\3\2\n\fV\2\r\3\2\2\2\4\23\3\2\2\2\6\'\3\2\2\2\b\65\3\2\2\2"+
		"\nL\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20"+
		"\3\2\2\2\20\21\3\2\2\2\21\22\7\2\2\3\22\3\3\2\2\2\23\24\7\7\2\2\24\25"+
		"\7\20\2\2\25\27\7\17\2\2\26\30\7\20\2\2\27\26\3\2\2\2\27\30\3\2\2\2\30"+
		"\31\3\2\2\2\31\33\7\3\2\2\32\34\7\20\2\2\33\32\3\2\2\2\33\34\3\2\2\2\34"+
		"\35\3\2\2\2\35\37\5\6\4\2\36 \7\20\2\2\37\36\3\2\2\2\37 \3\2\2\2 !\3\2"+
		"\2\2!#\7\4\2\2\"$\7\20\2\2#\"\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\7\21\2\2&"+
		"\5\3\2\2\2\')\5\b\5\2(*\7\20\2\2)(\3\2\2\2)*\3\2\2\2*\62\3\2\2\2+-\7\5"+
		"\2\2,.\7\20\2\2-,\3\2\2\2-.\3\2\2\2./\3\2\2\2/\61\5\b\5\2\60+\3\2\2\2"+
		"\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\7\3\2\2\2\64\62\3\2\2\2"+
		"\65\67\5\n\6\2\668\7\20\2\2\67\66\3\2\2\2\678\3\2\2\28C\3\2\2\29;\7\20"+
		"\2\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<>\7\6\2\2=?\7\20\2\2>=\3\2\2\2>?\3"+
		"\2\2\2?@\3\2\2\2@B\5\n\6\2A:\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\t"+
		"\3\2\2\2EC\3\2\2\2FG\t\2\2\2GH\7\20\2\2HM\7\t\2\2IJ\t\3\2\2JK\7\20\2\2"+
		"KM\7\b\2\2LF\3\2\2\2LI\3\2\2\2M\13\3\2\2\2\17\17\27\33\37#)-\62\67:>C"+
		"L";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}