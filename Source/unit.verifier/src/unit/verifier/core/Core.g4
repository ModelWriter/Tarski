grammar Core;

<<<<<<< HEAD
specification:  'Model:' set+ 'Sentences:' sentence+;
=======
specification: 'Model:' set+ 'Sentences:' sentence+;
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
/** R = { (x, y, z), (a,b,c) } **/
set:    RELATION_NAME '=' '{' (tuple (',' tuple)*)? '}' ';';
/** (x, y, z) **/
tuple:  '(' CONSTANT (',' CONSTANT)* ')';
=======
set: RELATION_NAME '=' '{' (tuple (',' tuple)*)? '}' ';';
tuple: '(' CONSTANT (',' CONSTANT)* ')';
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
sentence:   (quantification CONSTANT (',' quantification? CONSTANT)* '|')? expr ';' ;
=======
sentence: (quantification CONSTANT (',' quantification? CONSTANT)* '|')? expr ';' ;
>>>>>>> refs/remotes/origin/master

expr:   expr binaryOp expr
    |   unaryOp expr
    |   '(' expr ')'
    |   relation
    ;
<<<<<<< HEAD
=======

relation: RELATION_NAME '(' CONSTANT  (',' CONSTANT)* ')';
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
/** R (x, y, z)**/
relation:   RELATION_NAME tuple;

=======
>>>>>>> refs/remotes/origin/master
quantification: 'all' | 'no' | 'lone' | 'some' | 'one' ;
<<<<<<< HEAD
binaryOp:   '||' | 'or' | '&&' | 'and' | '<=>' | 'iff' | '=>' | 'implies' | '=' | 'in';
unaryOp:    '!' | 'not' ;
=======
binaryOp: '||' | 'or' | '&&' | 'and' | '<=>' | 'iff' | '=>' | 'implies' | '=' | 'in';
unaryOp: '!' | 'not' ;
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
CONSTANT:   [a-z0-9]+;
RELATION_NAME:  [a-zA-Z]+;
LINE_COMMENT:   '--' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT:  '/**' .*? '**/' -> skip;
WS: [ \t\r\n]+ -> skip ; // toss out whitespace
=======

CONSTANT : [a-z0-9]+;
RELATION_NAME  :   [a-zA-Z]+ ;
LINE_COMMENT : '--' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT : '/**' .*? '**/' -> skip;
WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace
>>>>>>> refs/remotes/origin/master
