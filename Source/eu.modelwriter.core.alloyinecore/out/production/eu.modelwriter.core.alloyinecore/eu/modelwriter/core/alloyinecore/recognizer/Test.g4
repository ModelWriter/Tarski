grammar Test;

module: formula* ;

formula:
     left=expression not=('!' | 'not')? 'in' right=expression  #in
    | left=expression not=('!' | 'not')? '='  right=expression  #equal
    | lefts=formula op=('&&' | 'and' ) rights=formula             #and
    | '(' formula ')'                                           #paranthesis
    ;

expression:
    left=expression '+' right=expression                         #union
    | '(' expression ')'                                        #pexpression
    ;