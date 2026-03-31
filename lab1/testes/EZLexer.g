lexer grammar EZLexer;

WS : [ \t\r\n]+ -> skip ;
COMMENT : '{' ~[{}]* '}' -> skip ;

BEGIN : 'begin' ;
BOOL : 'bool' ;
ELSE : 'else' ;
END : 'end'  ;
FALSE : 'false' ;
IF : 'if' ;
INT : 'int'  ;
PROGRAM : 'program' ;
READ : 'read' ;
REAL : 'real' ;
REPEAT : 'repeat' ;
STRING : 'string' ;
THEN : 'then' ;
TRUE : 'true'  ;
UNTIL : 'until' ;
VAR : 'var' ;
WRITE : 'write' ;

WALRUS : ':=' ;
EQUALS : '=' ;
LESS_THAN : '<' ;
PLUS : '+' ;
MINUS : '-' ;
ASTERISK : '*' ;
SLASH : '/' ;
LEFT_PAR : '(' ;
RIGHT_PAR : ')' ;
SEMICOLON : ';' ;

STRINGS : '"' ~["]* '"' ;
CONSTANT : [0-9]+ ('.' [0-9]+)? ;
IDENTIFIER : [a-zA-Z]+ ;