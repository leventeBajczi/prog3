// Generated from TriCheckLitmus.g4 by ANTLR 4.5.3
package hu.bme.mit.mcmec.tricheckparser.dsl.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TriCheckLitmusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, NUMBERS=2, COMMA=3, LCURLY=4, RCURLY=5, LBRACKET=6, RBRACKET=7, 
		LBRACE=8, RBRACE=9, SEMICOLON=10, ASSIGN=11, LOAD=12, STORE=13, MO=14, 
		EXISTS=15, RELEASE=16, RELAXED=17, ACQUIRE=18, SEQ_CST=19, RICHTEXT=20, 
		RICHER=21, WHITESPACE=22, NEWLINE=23;
	public static final int
		RULE_litmus = 0, RULE_preliminary = 1, RULE_variables = 2, RULE_threads = 3, 
		RULE_condition = 4, RULE_assignment = 5, RULE_thread = 6, RULE_line = 7;
	public static final String[] ruleNames = {
		"litmus", "preliminary", "variables", "threads", "condition", "assignment", 
		"thread", "line"
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

	@Override
	public String getGrammarFileName() { return "TriCheckLitmus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TriCheckLitmusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LitmusContext extends ParserRuleContext {
		public PreliminaryContext preliminary() {
			return getRuleContext(PreliminaryContext.class,0);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public ThreadsContext threads() {
			return getRuleContext(ThreadsContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TriCheckLitmusParser.EOF, 0); }
		public LitmusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_litmus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).enterLitmus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).exitLitmus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TriCheckLitmusVisitor ) return ((TriCheckLitmusVisitor<? extends T>)visitor).visitLitmus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LitmusContext litmus() throws RecognitionException {
		LitmusContext _localctx = new LitmusContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_litmus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			preliminary();
			setState(17);
			variables();
			setState(18);
			threads();
			setState(19);
			condition();
			setState(20);
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

	public static class PreliminaryContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(TriCheckLitmusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TriCheckLitmusParser.NEWLINE, i);
		}
		public List<TerminalNode> RICHTEXT() { return getTokens(TriCheckLitmusParser.RICHTEXT); }
		public TerminalNode RICHTEXT(int i) {
			return getToken(TriCheckLitmusParser.RICHTEXT, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(TriCheckLitmusParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TriCheckLitmusParser.WHITESPACE, i);
		}
		public PreliminaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preliminary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).enterPreliminary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).exitPreliminary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TriCheckLitmusVisitor ) return ((TriCheckLitmusVisitor<? extends T>)visitor).visitPreliminary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreliminaryContext preliminary() throws RecognitionException {
		PreliminaryContext _localctx = new PreliminaryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_preliminary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(22);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				match(RICHTEXT);
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(29);
					match(WHITESPACE);
					}
					}
					setState(34);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RICHTEXT );
			setState(39);
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

	public static class VariablesContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(TriCheckLitmusParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(TriCheckLitmusParser.RCURLY, 0); }
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(TriCheckLitmusParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(TriCheckLitmusParser.SEMICOLON, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TriCheckLitmusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TriCheckLitmusParser.NEWLINE, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(TriCheckLitmusParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TriCheckLitmusParser.WHITESPACE, i);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).exitVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TriCheckLitmusVisitor ) return ((TriCheckLitmusVisitor<? extends T>)visitor).visitVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(41);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
			match(LCURLY);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(48);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				assignment();
				setState(55);
				match(SEMICOLON);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE || _la==NEWLINE) {
					{
					{
					setState(56);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBRACKET );
			setState(66);
			match(RCURLY);
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
		public List<TerminalNode> NEWLINE() { return getTokens(TriCheckLitmusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TriCheckLitmusParser.NEWLINE, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(TriCheckLitmusParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TriCheckLitmusParser.WHITESPACE, i);
		}
		public ThreadsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_threads; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).enterThreads(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).exitThreads(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TriCheckLitmusVisitor ) return ((TriCheckLitmusVisitor<? extends T>)visitor).visitThreads(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThreadsContext threads() throws RecognitionException {
		ThreadsContext _localctx = new ThreadsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_threads);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(68);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RICHTEXT) {
				{
				{
				setState(74);
				thread();
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(75);
						_la = _input.LA(1);
						if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						} 
					}
					setState(80);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				}
				}
				setState(85);
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(TriCheckLitmusParser.EXISTS, 0); }
		public TerminalNode LBRACE() { return getToken(TriCheckLitmusParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(TriCheckLitmusParser.RBRACE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(TriCheckLitmusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TriCheckLitmusParser.NEWLINE, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(TriCheckLitmusParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TriCheckLitmusParser.WHITESPACE, i);
		}
		public List<TerminalNode> RICHER() { return getTokens(TriCheckLitmusParser.RICHER); }
		public TerminalNode RICHER(int i) {
			return getToken(TriCheckLitmusParser.RICHER, i);
		}
		public List<TerminalNode> RICHTEXT() { return getTokens(TriCheckLitmusParser.RICHTEXT); }
		public TerminalNode RICHTEXT(int i) {
			return getToken(TriCheckLitmusParser.RICHTEXT, i);
		}
		public List<TerminalNode> NUMBERS() { return getTokens(TriCheckLitmusParser.NUMBERS); }
		public TerminalNode NUMBERS(int i) {
			return getToken(TriCheckLitmusParser.NUMBERS, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(TriCheckLitmusParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(TriCheckLitmusParser.ASSIGN, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TriCheckLitmusVisitor ) return ((TriCheckLitmusVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_condition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(86);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(EXISTS);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(93);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(LBRACE);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(100);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBERS) | (1L << ASSIGN) | (1L << RICHTEXT) | (1L << RICHER) | (1L << WHITESPACE))) != 0)) {
				{
				{
				setState(106);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBERS) | (1L << ASSIGN) | (1L << RICHTEXT) | (1L << RICHER) | (1L << WHITESPACE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			match(RBRACE);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(113);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(119);
			match(NEWLINE);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(120);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(125);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(TriCheckLitmusParser.LBRACKET, 0); }
		public TerminalNode RICHTEXT() { return getToken(TriCheckLitmusParser.RICHTEXT, 0); }
		public TerminalNode RBRACKET() { return getToken(TriCheckLitmusParser.RBRACKET, 0); }
		public TerminalNode NUMBERS() { return getToken(TriCheckLitmusParser.NUMBERS, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TriCheckLitmusParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TriCheckLitmusParser.WHITESPACE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TriCheckLitmusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TriCheckLitmusParser.NEWLINE, i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TriCheckLitmusVisitor ) return ((TriCheckLitmusVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(LBRACKET);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(127);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(RICHTEXT);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(134);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			match(RBRACKET);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(141);
				match(WHITESPACE);
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
			match(ASSIGN);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(148);
				match(WHITESPACE);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			match(NUMBERS);
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
		public List<TerminalNode> RICHTEXT() { return getTokens(TriCheckLitmusParser.RICHTEXT); }
		public TerminalNode RICHTEXT(int i) {
			return getToken(TriCheckLitmusParser.RICHTEXT, i);
		}
		public TerminalNode LBRACE() { return getToken(TriCheckLitmusParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(TriCheckLitmusParser.RBRACE, 0); }
		public TerminalNode LCURLY() { return getToken(TriCheckLitmusParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(TriCheckLitmusParser.RCURLY, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TriCheckLitmusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TriCheckLitmusParser.NEWLINE, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(TriCheckLitmusParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TriCheckLitmusParser.WHITESPACE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TriCheckLitmusParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TriCheckLitmusParser.COMMA, i);
		}
		public ThreadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thread; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).enterThread(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).exitThread(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TriCheckLitmusVisitor ) return ((TriCheckLitmusVisitor<? extends T>)visitor).visitThread(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThreadContext thread() throws RecognitionException {
		ThreadContext _localctx = new ThreadContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_thread);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(RICHTEXT);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(157);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
			match(LBRACE);
			setState(187); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(165);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(164);
					match(COMMA);
					}
				}

				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE || _la==NEWLINE) {
					{
					{
					setState(167);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(RICHTEXT);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE || _la==NEWLINE) {
					{
					{
					setState(174);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(180);
				match(RICHTEXT);
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(181);
						_la = _input.LA(1);
						if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						} 
					}
					setState(186);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				}
				}
				setState(189); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMA) | (1L << RICHTEXT) | (1L << WHITESPACE) | (1L << NEWLINE))) != 0) );
			setState(191);
			match(RBRACE);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(192);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
			match(LCURLY);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(199);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(206); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(205);
					line();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(208); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(210);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
			match(RCURLY);
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

	public static class LineContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(TriCheckLitmusParser.LBRACE, 0); }
		public List<TerminalNode> RICHTEXT() { return getTokens(TriCheckLitmusParser.RICHTEXT); }
		public TerminalNode RICHTEXT(int i) {
			return getToken(TriCheckLitmusParser.RICHTEXT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TriCheckLitmusParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TriCheckLitmusParser.COMMA, i);
		}
		public TerminalNode RBRACE() { return getToken(TriCheckLitmusParser.RBRACE, 0); }
		public TerminalNode SEMICOLON() { return getToken(TriCheckLitmusParser.SEMICOLON, 0); }
		public TerminalNode LOAD() { return getToken(TriCheckLitmusParser.LOAD, 0); }
		public TerminalNode STORE() { return getToken(TriCheckLitmusParser.STORE, 0); }
		public TerminalNode RELAXED() { return getToken(TriCheckLitmusParser.RELAXED, 0); }
		public TerminalNode RELEASE() { return getToken(TriCheckLitmusParser.RELEASE, 0); }
		public TerminalNode ACQUIRE() { return getToken(TriCheckLitmusParser.ACQUIRE, 0); }
		public TerminalNode SEQ_CST() { return getToken(TriCheckLitmusParser.SEQ_CST, 0); }
		public TerminalNode NUMBERS() { return getToken(TriCheckLitmusParser.NUMBERS, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TriCheckLitmusParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TriCheckLitmusParser.WHITESPACE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TriCheckLitmusParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TriCheckLitmusParser.NEWLINE, i);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TriCheckLitmusListener ) ((TriCheckLitmusListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TriCheckLitmusVisitor ) return ((TriCheckLitmusVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_line);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(218);
					_la = _input.LA(1);
					if ( !(_la==RICHTEXT || _la==WHITESPACE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(225);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(224);
				match(ASSIGN);
				}
			}

			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(227);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(233);
			_la = _input.LA(1);
			if ( !(_la==LOAD || _la==STORE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(234);
			match(LBRACE);
			setState(235);
			match(RICHTEXT);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(236);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(242);
				match(COMMA);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE || _la==NEWLINE) {
					{
					{
					setState(243);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(249);
				match(NUMBERS);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE || _la==NEWLINE) {
					{
					{
					setState(250);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(258);
			match(COMMA);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(259);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RELEASE) | (1L << RELAXED) | (1L << ACQUIRE) | (1L << SEQ_CST))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(266);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
			match(RBRACE);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE || _la==NEWLINE) {
				{
				{
				setState(273);
				_la = _input.LA(1);
				if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(279);
			match(SEMICOLON);
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(280);
					_la = _input.LA(1);
					if ( !(_la==WHITESPACE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u0121\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\3\3\3\7\3!\n\3\f\3\16\3$"+
		"\13\3\6\3&\n\3\r\3\16\3\'\3\3\3\3\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\4\3"+
		"\4\7\4\64\n\4\f\4\16\4\67\13\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\6\4"+
		"A\n\4\r\4\16\4B\3\4\3\4\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\7\5O\n\5\f"+
		"\5\16\5R\13\5\7\5T\n\5\f\5\16\5W\13\5\3\6\7\6Z\n\6\f\6\16\6]\13\6\3\6"+
		"\3\6\7\6a\n\6\f\6\16\6d\13\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\3\6\7\6n"+
		"\n\6\f\6\16\6q\13\6\3\6\3\6\7\6u\n\6\f\6\16\6x\13\6\3\6\3\6\7\6|\n\6\f"+
		"\6\16\6\177\13\6\3\7\3\7\7\7\u0083\n\7\f\7\16\7\u0086\13\7\3\7\3\7\7\7"+
		"\u008a\n\7\f\7\16\7\u008d\13\7\3\7\3\7\7\7\u0091\n\7\f\7\16\7\u0094\13"+
		"\7\3\7\3\7\7\7\u0098\n\7\f\7\16\7\u009b\13\7\3\7\3\7\3\b\3\b\7\b\u00a1"+
		"\n\b\f\b\16\b\u00a4\13\b\3\b\3\b\5\b\u00a8\n\b\3\b\7\b\u00ab\n\b\f\b\16"+
		"\b\u00ae\13\b\3\b\3\b\7\b\u00b2\n\b\f\b\16\b\u00b5\13\b\3\b\3\b\7\b\u00b9"+
		"\n\b\f\b\16\b\u00bc\13\b\6\b\u00be\n\b\r\b\16\b\u00bf\3\b\3\b\7\b\u00c4"+
		"\n\b\f\b\16\b\u00c7\13\b\3\b\3\b\7\b\u00cb\n\b\f\b\16\b\u00ce\13\b\3\b"+
		"\6\b\u00d1\n\b\r\b\16\b\u00d2\3\b\7\b\u00d6\n\b\f\b\16\b\u00d9\13\b\3"+
		"\b\3\b\3\t\7\t\u00de\n\t\f\t\16\t\u00e1\13\t\3\t\5\t\u00e4\n\t\3\t\7\t"+
		"\u00e7\n\t\f\t\16\t\u00ea\13\t\3\t\3\t\3\t\3\t\7\t\u00f0\n\t\f\t\16\t"+
		"\u00f3\13\t\3\t\3\t\7\t\u00f7\n\t\f\t\16\t\u00fa\13\t\3\t\3\t\7\t\u00fe"+
		"\n\t\f\t\16\t\u0101\13\t\5\t\u0103\n\t\3\t\3\t\7\t\u0107\n\t\f\t\16\t"+
		"\u010a\13\t\3\t\3\t\7\t\u010e\n\t\f\t\16\t\u0111\13\t\3\t\3\t\7\t\u0115"+
		"\n\t\f\t\16\t\u0118\13\t\3\t\3\t\7\t\u011c\n\t\f\t\16\t\u011f\13\t\3\t"+
		"\2\2\n\2\4\6\b\n\f\16\20\2\7\3\2\30\31\5\2\4\4\r\r\26\30\4\2\26\26\30"+
		"\30\3\2\16\17\3\2\22\25\u0141\2\22\3\2\2\2\4\33\3\2\2\2\6.\3\2\2\2\bI"+
		"\3\2\2\2\n[\3\2\2\2\f\u0080\3\2\2\2\16\u009e\3\2\2\2\20\u00df\3\2\2\2"+
		"\22\23\5\4\3\2\23\24\5\6\4\2\24\25\5\b\5\2\25\26\5\n\6\2\26\27\7\2\2\3"+
		"\27\3\3\2\2\2\30\32\t\2\2\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2"+
		"\33\34\3\2\2\2\34%\3\2\2\2\35\33\3\2\2\2\36\"\7\26\2\2\37!\7\30\2\2 \37"+
		"\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#&\3\2\2\2$\"\3\2\2\2%\36\3\2"+
		"\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\31\2\2*\5\3\2\2\2"+
		"+-\t\2\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3"+
		"\2\2\2\61\65\7\6\2\2\62\64\t\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3"+
		"\2\2\2\65\66\3\2\2\2\66@\3\2\2\2\67\65\3\2\2\289\5\f\7\29=\7\f\2\2:<\t"+
		"\2\2\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>A\3\2\2\2?=\3\2\2\2@8\3"+
		"\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\7\7\2\2E\7\3\2\2\2FH"+
		"\t\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JU\3\2\2\2KI\3\2\2\2L"+
		"P\5\16\b\2MO\t\2\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QT\3\2\2\2"+
		"RP\3\2\2\2SL\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\t\3\2\2\2WU\3\2\2"+
		"\2XZ\t\2\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2"+
		"\2\2^b\7\21\2\2_a\t\2\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3"+
		"\2\2\2db\3\2\2\2ei\7\n\2\2fh\t\2\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3"+
		"\2\2\2jo\3\2\2\2ki\3\2\2\2ln\t\3\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3"+
		"\2\2\2pr\3\2\2\2qo\3\2\2\2rv\7\13\2\2su\t\2\2\2ts\3\2\2\2ux\3\2\2\2vt"+
		"\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2y}\7\31\2\2z|\t\2\2\2{z\3\2\2\2"+
		"|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\13\3\2\2\2\177}\3\2\2\2\u0080\u0084"+
		"\7\b\2\2\u0081\u0083\t\2\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0087\u008b\7\26\2\2\u0088\u008a\t\2\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008e\u0092\7\t\2\2\u008f\u0091\7\30\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0099\7\r\2\2\u0096"+
		"\u0098\7\30\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3"+
		"\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009d\7\4\2\2\u009d\r\3\2\2\2\u009e\u00a2\7\26\2\2\u009f\u00a1\t\2\2"+
		"\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00bd\7\n\2\2\u00a6"+
		"\u00a8\7\5\2\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ac\3\2"+
		"\2\2\u00a9\u00ab\t\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00af\u00b3\7\26\2\2\u00b0\u00b2\t\2\2\2\u00b1\u00b0\3\2\2\2\u00b2"+
		"\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00ba\7\26\2\2\u00b7\u00b9\t\2\2\2\u00b8"+
		"\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00a7\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c5\7\13\2\2\u00c2\u00c4\t\2\2\2\u00c3\u00c2\3\2\2\2\u00c4"+
		"\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2"+
		"\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00cc\7\6\2\2\u00c9\u00cb\t\2\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\5\20\t\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d7\3\2\2\2\u00d4\u00d6\t\2\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2"+
		"\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7\7\2\2\u00db\17\3\2\2\2\u00dc\u00de"+
		"\t\4\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\7\r"+
		"\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e8\3\2\2\2\u00e5"+
		"\u00e7\t\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ec\t\5\2\2\u00ec\u00ed\7\n\2\2\u00ed\u00f1\7\26\2\2\u00ee\u00f0\t"+
		"\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u0102\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f8\7\5"+
		"\2\2\u00f5\u00f7\t\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f8\3\2"+
		"\2\2\u00fb\u00ff\7\4\2\2\u00fc\u00fe\t\2\2\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0103\3\2"+
		"\2\2\u0101\u00ff\3\2\2\2\u0102\u00f4\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0108\7\5\2\2\u0105\u0107\t\2\2\2\u0106\u0105\3\2"+
		"\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010f\t\6\2\2\u010c\u010e\t\2"+
		"\2\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0116\7\13"+
		"\2\2\u0113\u0115\t\2\2\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0119\u011d\7\f\2\2\u011a\u011c\t\2\2\2\u011b\u011a\3\2\2\2\u011c"+
		"\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\21\3\2\2"+
		"\2\u011f\u011d\3\2\2\2+\33\"\'.\65=BIPU[biov}\u0084\u008b\u0092\u0099"+
		"\u00a2\u00a7\u00ac\u00b3\u00ba\u00bf\u00c5\u00cc\u00d2\u00d7\u00df\u00e3"+
		"\u00e8\u00f1\u00f8\u00ff\u0102\u0108\u010f\u0116\u011d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}