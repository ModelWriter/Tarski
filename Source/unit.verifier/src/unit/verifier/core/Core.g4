grammar Core;

specification:  'Model:' set+ 'Sentences:' sentence+;

/** R = { (x, y, z), (a,b,c) } **/
set:    RELATION_NAME '=' '{' (tuple (',' tuple)*)? '}' ';';
/** (x, y, z) **/
tuple:  '(' CONSTANT (',' CONSTANT)* ')';

sentence:   (quantification CONSTANT (',' quantification? CONSTANT)* '|')? expr ';' ;

expr:   expr binaryOp expr
    |   unaryOp expr
    |   '(' expr ')'
    |   relation
    ;

/** R (x, y, z)**/
relation:   RELATION_NAME tuple;

quantification: 'all' | 'no' | 'lone' | 'some' | 'one' ;
binaryOp:   '||' | 'or' | '&&' | 'and' | '<=>' | 'iff' | '=>' | 'implies' | '=' | 'in';
unaryOp:    '!' | 'not' ;

CONSTANT:   [a-z0-9]+;
RELATION_NAME:  [a-zA-Z]+;
LINE_COMMENT:   '--' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT:  '/**' .*? '**/' -> skip;
WS: [ \t\r\n]+ -> skip ; // toss out whitespace