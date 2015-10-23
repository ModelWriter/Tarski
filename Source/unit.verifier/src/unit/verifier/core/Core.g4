grammar Core;

specification: 'Model:' set+ 'Sentences:' sentence+;

set: RELATION_NAME '=' '{' (tuple (',' tuple)*)? '}' ';';
tuple: '(' CONSTANT (',' CONSTANT)* ')';

sentence: (quantification CONSTANT (',' quantification? CONSTANT)* '|')? expr ';' ;

expr:   expr binaryOp expr
    |   unaryOp expr
    |   '(' expr ')'
    |   relation
    ;

relation: RELATION_NAME '(' CONSTANT  (',' CONSTANT)* ')';

quantification: 'all' | 'no' | 'lone' | 'some' | 'one' ;
binaryOp: '||' | 'or' | '&&' | 'and' | '<=>' | 'iff' | '=>' | 'implies' | '=' | 'in';
unaryOp: '!' | 'not' ;


CONSTANT : [a-z0-9]+;
RELATION_NAME  :   [a-zA-Z]+ ;
LINE_COMMENT : '--' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT : '/**' .*? '**/' -> skip;
WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace