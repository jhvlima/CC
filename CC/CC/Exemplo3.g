lexer grammar Exemplo3;
WS : [ \t\n]+ -> skip ;
IF : 'if' ;
ELSE : 'else' ;
TRUE : 'true' ;
ASSIGN : '=' ;
STRING : '"' ~["]* '"' ;
ID : [a-zA-Z]+ ;