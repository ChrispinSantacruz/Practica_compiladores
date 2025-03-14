grammar Calculadora;

prog: stat+;
stat:   assignStmt
     | exprStmt;

assignStmt: ID '=' expr ';' ;
exprStmt: expr ';' ;

expr: expr ('*'|'/') expr 
    | expr ('+'|'-') expr 
    | '(' expr ')'
    | ID
    | INT;

ID: [a-zA-Z]+;
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;
