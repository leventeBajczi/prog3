grammar TriCheckLitmus	;

litmus		:  preliminary variables threads condition EOF	;

preliminary	:  (NEWLINE | WHITESPACE)* (RICHTEXT (WHITESPACE)*)+ NEWLINE		;

variables	:  (NEWLINE | WHITESPACE)* LCURLY (NEWLINE | WHITESPACE)* (assignment SEMICOLON (NEWLINE | WHITESPACE)*)+ RCURLY ;

threads		: (NEWLINE | WHITESPACE)* (thread (NEWLINE | WHITESPACE)*)*;

condition	: (NEWLINE | WHITESPACE)* EXISTS (NEWLINE | WHITESPACE)* LBRACE (NEWLINE | WHITESPACE)* (RICHER | RICHTEXT | NUMBERS | ASSIGN | WHITESPACE)* RBRACE (NEWLINE | WHITESPACE)* NEWLINE (NEWLINE | WHITESPACE)* ;


assignment 	: LBRACKET (NEWLINE | WHITESPACE)* RICHTEXT (NEWLINE | WHITESPACE)* RBRACKET (WHITESPACE)* '=' (WHITESPACE)* NUMBERS;

thread		: RICHTEXT (NEWLINE | WHITESPACE)* LBRACE ( COMMA? (NEWLINE | WHITESPACE)* RICHTEXT (NEWLINE | WHITESPACE)* RICHTEXT (NEWLINE | WHITESPACE)*)+ RBRACE (NEWLINE | WHITESPACE)* LCURLY (NEWLINE | WHITESPACE)* line+ (NEWLINE | WHITESPACE)* RCURLY ;


line		:  (RICHTEXT | WHITESPACE)* '='? (NEWLINE | WHITESPACE)* (LOAD | STORE) LBRACE RICHTEXT (NEWLINE | WHITESPACE)* (COMMA (NEWLINE | WHITESPACE)* NUMBERS (NEWLINE | WHITESPACE)*)? COMMA (NEWLINE | WHITESPACE)* (RELAXED | RELEASE | ACQUIRE | SEQ_CST) (NEWLINE | WHITESPACE)* RBRACE (NEWLINE|WHITESPACE)* SEMICOLON (NEWLINE | WHITESPACE)* ;


LINE_COMMENT	: '//' ~[\r\n]* -> skip;

fragment LOWERCASE      : [a-z]         ;                            
fragment UPPERCASE      : [A-Z]         ;                            
NUMBERS        : [0-9]         ;
fragment UNDERSCORE     : '_'           ;
fragment TILDE          : '~'           ;                     
fragment SLASH          : '/'           ;              
fragment ASTER   	: '*'           ;                          
fragment MINUS		: '-'		;
fragment COLON		: ':'		;
fragment BACKSLASH	: '\\'		;

COMMA		: ','	;                                                                     
LCURLY         : '{'           ;                            
RCURLY         : '}'           ;                            
LBRACKET	: '['		;
RBRACKET	: ']'		;
LBRACE		: '('		;
RBRACE		: ')'		;                            
SEMICOLON      : ';'           ;
ASSIGN		: '=' 		;

LOAD		: 'atomic_load_explicit' ;
STORE		: 'atomic_store_explicit';
MO		: 'memory_order_';
EXISTS		: 'exists';
RELEASE	: MO 'release';
RELAXED	: MO 'relaxed';
ACQUIRE	: MO 'acquire';
SEQ_CST	: MO 'seq_cst';

RICHTEXT         : (LOWERCASE | UPPERCASE | NUMBERS | UNDERSCORE | TILDE | SLASH | ASTER | MINUS)+; 
RICHER		 : (COLON | BACKSLASH | ASSIGN)+;

WHITESPACE              : (' ' | '\t')+ ;                            
NEWLINE                 : ('\r'? '\n' | '\r')+  ;     

