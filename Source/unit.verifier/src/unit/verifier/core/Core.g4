grammar Core;

specification:'Model:' set+ 'Sentences:' sentence+;

/** R = { (x, y, z), (a,b,c) } **/
set: RELATION_NAME '=' '{' (tuple (',' tuple)*)? '}' ';';
/** (x, y, z) **/
tuple: '(' IDENTIFIER (',' IDENTIFIER)* ')';

//all x,y | Rel(x,y); one x, some y | Rel(x,y);
sentence:  expr ';' ;

expr:   quantification expr         # quantified
    |   expr binaryOperation expr   # binary
    |   unaryOperation expr         # unary
    |   '(' expr ')'                # scope
    |   relation                    # ground
    ;

/** R (x, y, z)**/
relation: RELATION_NAME '(' IDENTIFIER  (',' IDENTIFIER)* ')';

quantification: (quantifier IDENTIFIER (',' quantifier? IDENTIFIER)* '|') ;

quantifier: 'all' | 'no' | 'lone' | 'some' | 'one' ;
binaryOperation: '||' | 'or' | '&&' | 'and' | '<=>' | 'iff' | '=>' | 'implies' | '=' | 'in';
unaryOperation: '!' | 'not' ;

IDENTIFIER : [a-z0-9]+;
RELATION_NAME: [A-Za-z]+ ; //Predicate names always begin with a capital letter
LINE_COMMENT : '--' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT : '/**' .*? '**/' -> skip;
WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace
