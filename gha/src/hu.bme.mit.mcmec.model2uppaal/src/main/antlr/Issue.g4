grammar Issue ;

// Parser rules

issues			: issue+ EOF							;

issue			: ISSUE WHITESPACE NAME WHITESPACE? LCURLY WHITESPACE? threads WHITESPACE? RCURLY WHITESPACE? NEWLINE	;

threads			: thread WHITESPACE? (COLON WHITESPACE? thread)*		;

thread			: io WHITESPACE? (WHITESPACE? SEMICOLON WHITESPACE? io)*	;

io			: ( (RELA | RELE | SEQ) WHITESPACE STORE)
			| ( (RELA | ACQ  | SEQ) WHITESPACE LOAD)			; 

// Lexer rules
fragment LOWERCASE  	: [a-z] 	;
fragment UPPERCASE  	: [A-Z] 	;
fragment NUMBERS	: [0-9]		;
fragment UNDERSCORE 	: '_' 		;
fragment TILDE		: '~'		;
fragment SLASH		: '/'		;
fragment ASTER		: '*'		;
fragment MINUS		: '-'		;

LCURLY			: '{'		;
RCURLY			: '}'		;
COLON			: ':'		;
SEMICOLON		: ';'		;


ISSUE			: 'issue'	;
LOAD			: 'load'	;
STORE			: 'store'	;

RELA			: 'relaxed'	;
ACQ			: 'acquire'	;
SEQ			: 'seq_cst'	;
RELE			: 'release'	;

FENCE			: 'fence'	;

NAME			: (LOWERCASE | UPPERCASE | NUMBERS | UNDERSCORE | TILDE | SLASH | ASTER | MINUS)+;
WHITESPACE          	: (' ' | '\t')+ ;
NEWLINE             	: ('\r'? '\n' | '\r')+  ;
