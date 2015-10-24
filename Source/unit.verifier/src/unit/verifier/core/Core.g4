grammar Core;

specification:  'Model:' set+ 'Sentences:' sentence+;

set:    RELATION_NAME '=' '{' (tuple (',' tuple)*)? '}' ';';
tuple:  '(' IDENTIFIER (',' IDENTIFIER)* ')';

sentence:  expr ';' ;

quantification: (quantifier IDENTIFIER (',' quantifier? IDENTIFIER)* '|') ;

expr:   quantification expr
    |   expr binaryOp expr
    |   unaryOp expr
    |   '(' expr ')'
    |   relation
    ;

relation:   RELATION_NAME tuple;

quantifier: 'all' | 'no' | 'lone' | 'some' | 'one' ;
binaryOp:   '||' | 'or' | '&&' | 'and' | '<=>' | 'iff' | '=>' | 'implies' | '=' | 'in';
unaryOp:    '!' | 'not' ;

IDENTIFIER:   [a-z0-9]+;
RELATION_NAME:  [a-zA-Z]+;
LINE_COMMENT:   '--' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT:  '/**' .*? '**/' -> skip;
WS: [ \t\r\n]+ -> skip ; // toss out whitespace