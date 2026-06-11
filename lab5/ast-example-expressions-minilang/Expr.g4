grammar Expr;

@header { package parser; }

program: statement+ ;

statement: 
    'print' ID                      #PrintStatement 
    | ID ASSIGN expr                #AssignmentStatement
    ; 

expr:   expr op=('*'|'/') expr     # MulDivExpression
    |   expr op=('+'|'-') expr     # AddSubExpression
    |   INT                        # IntLiteral
    |   ID                         # IdExpression
    |   '(' expr ')'               # ParentheticExpression
    ;

MUL :   '*' ;
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
INT :   [0-9]+ ;
WS  :   [ \r\n\t]+ -> skip ;
ID  :  [a-zA-Z] ;
ASSIGN : '=';

OTHER : . ;