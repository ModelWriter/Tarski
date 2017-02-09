grammar Test;

model: formula* ;

formula:
      left=expression 'in'  right=expression    #in
    | left=formula    'and' right=formula       #and
    ;

expression:
      left=expression '+' right=expression      #union
    | variable                                  #var
    ;

variable: IDENTIFIER;

IDENTIFIER : [a-zA-Z];
