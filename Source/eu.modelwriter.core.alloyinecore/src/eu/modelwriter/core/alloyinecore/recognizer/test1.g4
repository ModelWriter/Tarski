grammar test1;

example:
    left=integer '*' right=integer  #integerExample
  | left=string  '+' right=string   #stringExample
  ;

integer: IDENTIFIER;
string: INTEGER;

STRING: [a-zA-Z];
INTEGER: [a-zA-Z];