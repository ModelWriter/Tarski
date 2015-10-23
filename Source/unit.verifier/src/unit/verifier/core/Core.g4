grammar Core;

specification: models+ sentences+;

declaration: innerDeclaration NEWLINE
			| '(' innerDeclaration ')' (binaryOperation '(' innerDeclaration ')')* NEWLINE;

innerDeclaration: quantification? VAR (',' quantification? VAR)* '|' formula | relation;

formula:   expression ;

expression:   expression binaryOperation expression
		  |   expression binaryOperation innerDeclaration
          |   unaryOperation expression
          |   '(' expression ')'
          |   relation
          ;

/** R (x, y, z)**/
relation: REL arity;
arity: '(' VAR (',' VAR)* ')';

models: MOD_CONST model+;
model: REL '=' '{' arity (',' arity)* '}' NEWLINE;

sentences: SENT_CONST declaration+;
quantification: 'all' | 'no' | 'lone' | 'some' | 'one' ;
binaryOperation: '||' | 'or' | '&&' | 'and' | '<=>' | 'iff' | '=>' | 'implies' | '=' | 'in';
unaryOperation: '!' | 'not' ;

LINE_COMMENT : '--' .*? '\r\n' -> skip;
MULTILINE_COMMENT : '/**' .*? '**/' -> skip;
VAR :   [a-z0-9];
REL  :   [a-zA-Z]+ ;
NEWLINE:';' LINE_COMMENT?;     // return newlines to parser (is end-statement signal)
MOD_CONST: 'Model:\r\n';
SENT_CONST: 'Sentences:\r\n';
WS  :   [ \t\r\n]+ -> skip ; // toss out whitespace