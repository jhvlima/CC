// Generated from Exemplo03.g by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Exemplo03Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SWITCH=1, CASE=2, DEFAULT=3, BREAK=4, COLON=5, SEMI=6, LBRACE=7, RBRACE=8, 
		INT_VAL=9, ID=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SWITCH", "CASE", "DEFAULT", "BREAK", "COLON", "SEMI", "LBRACE", "RBRACE", 
			"INT_VAL", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'switch'", "'case'", "'default'", "'break'", "':'", "';'", "'{'", 
			"'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SWITCH", "CASE", "DEFAULT", "BREAK", "COLON", "SEMI", "LBRACE", 
			"RBRACE", "INT_VAL", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public Exemplo03Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Exemplo03.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000bJ\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0004\b;\b\b\u000b\b\f\b"+
		"<\u0001\t\u0004\t@\b\t\u000b\t\f\tA\u0001\n\u0004\nE\b\n\u000b\n\f\nF"+
		"\u0001\n\u0001\n\u0000\u0000\u000b\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0001\u0000\u0003\u0001\u000009\u0002\u0000AZaz\u0002\u0000\t\n"+
		"  L\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0003"+
		"\u001e\u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000\u0007+\u0001"+
		"\u0000\u0000\u0000\t1\u0001\u0000\u0000\u0000\u000b3\u0001\u0000\u0000"+
		"\u0000\r5\u0001\u0000\u0000\u0000\u000f7\u0001\u0000\u0000\u0000\u0011"+
		":\u0001\u0000\u0000\u0000\u0013?\u0001\u0000\u0000\u0000\u0015D\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0005s\u0000\u0000\u0018\u0019\u0005w\u0000"+
		"\u0000\u0019\u001a\u0005i\u0000\u0000\u001a\u001b\u0005t\u0000\u0000\u001b"+
		"\u001c\u0005c\u0000\u0000\u001c\u001d\u0005h\u0000\u0000\u001d\u0002\u0001"+
		"\u0000\u0000\u0000\u001e\u001f\u0005c\u0000\u0000\u001f \u0005a\u0000"+
		"\u0000 !\u0005s\u0000\u0000!\"\u0005e\u0000\u0000\"\u0004\u0001\u0000"+
		"\u0000\u0000#$\u0005d\u0000\u0000$%\u0005e\u0000\u0000%&\u0005f\u0000"+
		"\u0000&\'\u0005a\u0000\u0000\'(\u0005u\u0000\u0000()\u0005l\u0000\u0000"+
		")*\u0005t\u0000\u0000*\u0006\u0001\u0000\u0000\u0000+,\u0005b\u0000\u0000"+
		",-\u0005r\u0000\u0000-.\u0005e\u0000\u0000./\u0005a\u0000\u0000/0\u0005"+
		"k\u0000\u00000\b\u0001\u0000\u0000\u000012\u0005:\u0000\u00002\n\u0001"+
		"\u0000\u0000\u000034\u0005;\u0000\u00004\f\u0001\u0000\u0000\u000056\u0005"+
		"{\u0000\u00006\u000e\u0001\u0000\u0000\u000078\u0005}\u0000\u00008\u0010"+
		"\u0001\u0000\u0000\u00009;\u0007\u0000\u0000\u0000:9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=\u0012\u0001\u0000\u0000\u0000>@\u0007\u0001\u0000\u0000"+
		"?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000B\u0014\u0001\u0000\u0000\u0000CE\u0007"+
		"\u0002\u0000\u0000DC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000HI\u0006\n\u0000\u0000I\u0016\u0001\u0000\u0000\u0000\u0004\u0000"+
		"<AF\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}