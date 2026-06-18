grammar Expr;

@header { package parser; }

program: statement+ ;

statement: 
    'print' ID                      #PrintStatement 
    | ID ASSIGN expr                #AssignmentStatement
    ; 
    
expr:   expr op=(MUL|DIV) expr     # MulDivExpression
    |   expr op=(ADD|SUB) expr     # AddSubExpression
    |   INT                        # IntLiteral
    |   ID                         # IdExpression
    |   '(' expr ')'               # ParentheticExpression
    ;

ADD : '+';
MUL : '*';
DIV : '/';
SUB : '-';

INT :   [0-9]+ ;
WS  :   [ \r\n\t]+ -> skip ;
ID  :  [a-zA-Z] ;
ASSIGN : '=';

OTHER : . ;