grammar Instance;
//https://github.com/antlr/antlr4/blob/master/doc/wildcard.md

@parser::header {

}

@parser::members {

}

/*
Identifying class instances (objects)
=====================================
Since the value of the attribute selected as the identifying attribute is presented in the class instance’s introduction,
its normal representation within the body of the instance’s definition is superfluous, and is thus omitted.

By default, identifying strings (be they arbitrary or the value of an attribute) are required to be unique over the
set of instances of the class, and over all instances of its subtypes.

Attributes whose lower multiplicity bound is 0 may be explicitly unset by assigning them to the ‘null’ keyword.

The association name is optionally displayed before the contained class instance to allow disambiguation for MOF models
that have more than one possible containment association between the container and the contained instance.

Three reserved words: “true” and “false” for representing boolean values, and “null” for unsetting attribute values.

‘+’ and ‘-’ can be used to indicate the positive/negative sign of the value.

Identifiers:
*/
instance: packageImport* modelDeclaration rootElement= object
    ;

packageImport: ('import') (name= unrestrictedName ':')? ownedPathName= SINGLE_QUOTED_STRING ';'
    ;

modelDeclaration: ('model') (name= unrestrictedName ':')? ownedPathName= SINGLE_QUOTED_STRING
    ;

object: name= className id= value?
    '{'
        content (',' content)*
    '}'
    ;

className: pathName;

content: name= unrestrictedName (':' (dataValue | '{' object* '}' | objectReference))? ;

dataValue: value | multiValueData;

multiValueData: '[' dataValue (',' multiValueData)* ']' ;

objectReference: pathName | ('[' pathName (',' pathName)* ']');

pathName: firstSegment= unrestrictedName ('.' index= INT)? (midSegments+= segment*  lastSegment= segment)? ;

segment:'::' '@'? name= unrestrictedName ('.' index= INT)?;

value:
        identifier
    |   numericValue
    |   stringValue
    |   booleanValue
    |   nullValue
    ;

unrestrictedName:
        identifier
    |   'import'
    |	'model'
;

booleanValue: 'true' | 'false';

numericValue: ('+' | '-')? INT? '.'? INT ;

identifier: IDENTIFIER;

stringValue: DOUBLE_QUOTED_STRING;

nullValue: 'null';

INT :   DIGIT+ ;

IDENTIFIER : (UNDERSCORE | LETTER) (LETTER | APOSTROPHE | DIGIT | UNDERSCORE | DOLLAR)* ;
DOUBLE_QUOTED_STRING: '"' ( ESCAPED_CHARACTER | ~('\\' | '"' ) )* '"'  ;
SINGLE_QUOTED_STRING: '\'' ( ESCAPED_CHARACTER | ~('\'' | '\\') )* '\'' ;

fragment LETTER: [a-zA-Z];
fragment DIGITS : DIGIT+ ;
fragment DIGIT: [0-9];
fragment ESCAPED_CHARACTER: '\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | '\'' | '\\');
fragment UNDERSCORE: '_';
fragment APOSTROPHE: '\'';
fragment DOLLAR: '$';
fragment MINUS: '-';
ML_SINGLE_QUOTED_STRING : '\'' .*? '\'' -> skip;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;
SINGLELINE_COMMENT : '--' .*? '\r'? '\n' -> skip;

WS : [ \r\t\n]+ -> skip ;