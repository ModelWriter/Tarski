grammar test2;

example:
    left=example '*' right=example   #integerExample
  | left=inner   '+' right=inner     #stringExample
  ;

inner: integer | string;

integer: INTEGER;
string: STRING;

STRING: [a-zA-Z];
INTEGER: [a-zA-Z];