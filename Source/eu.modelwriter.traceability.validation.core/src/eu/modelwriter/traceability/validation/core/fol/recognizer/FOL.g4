grammar FOL;

specification:'Model:' set+ 'Sentences:' sentence+;

/** R = { (x, y, z), (a,b,c) } **/
set: RELATION_NAME '=' '{' (tuple (',' tuple)*)? '}' ';';
/** (x, y, z) **/
tuple: '(' IDENTIFIER (',' IDENTIFIER)* ')';

//all x,y | Rel(x,y); one x, some y | Rel(x,y);
sentence:  expr ';' ;

// operator precedence: When an operand is surrounded by operators of equal precedence, the operand associates to the right
// p -> q -> r = p -> (q -> r)
expr:   op=('!' | 'not') expr                                           # negation
    |   left=expr op=('&&' | 'and' ) right=expr                         # conjunction
    |   left=expr op=('||' | 'or'  ) right=expr                         # disjunction
    |   <assoc=right> left=expr op=('implies' | '->') right=expr        # implication
    |   <assoc=right> left=expr op=('<->' | 'iff') right=expr           # equivalence
    |   quantifier '|' scope=expr                                       # quantification
    |   '(' expr ')'                                                    # parentheses
    |   RELATION_NAME '(' (IDENTIFIER (',' IDENTIFIER)*)? ')'           # relation
    ;

//one x, all y, some z | K(x,y,z); some x, y, z | R(x, z) -> K (x, y, z);
quantifier: op=('all' | 'no' | 'lone' | 'some' | 'one') IDENTIFIER (',' IDENTIFIER)*;

ALL: 'all';
NO: 'no';
LONE: 'lone';
SOME: 'some';
ONE: 'one';
LP: '(';
RP: ')';
NOT: 'not';

IDENTIFIER : [a-z0-9]+;
RELATION_NAME: [A-Za-z]+ ; //Predicate names always begin with a capital letter
SINGLELINE_COMMENT : '--' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT : '/**' .*? '**/' -> skip;
WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace