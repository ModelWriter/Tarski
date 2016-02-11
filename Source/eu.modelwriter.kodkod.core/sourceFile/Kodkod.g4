grammar Kodkod;

@parser::header {}

@parser::members {
    public java.util.Stack<String> declarations = new java.util.Stack<String>();
    public java.util.List<String> atoms = new java.util.ArrayList<String>();
    public java.util.List<kodkod.ast.Formula> formulas = new java.util.ArrayList<kodkod.ast.Formula>();
    public java.util.Map<String, kodkod.ast.Relation> relations = new java.util.HashMap<String, kodkod.ast.Relation>();
    public kodkod.instance.Universe universe = null;
    public kodkod.instance.Bounds bounds = null;

    private boolean isRelation() { return this.relations.containsKey(getCurrentToken().getText()); }
    private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}
    private String context = null;
    private int declareVariables(java.util.List<VariableContext> vars, int var) {
        System.out.println("Quantifier context: ");
        for (VariableContext vc : vars) {
            String s = vc.getText(); declarations.add(s); var++; System.out.println(s);
        }
        return var;
    }
}

problem: options? universe {System.out.println(universe);} relations* {System.out.println(bounds);} formulas+=formula* {} {
    System.out.println("declarations= "+declarations);
    declarations.clear();
};

options: 'options' '{'  option (',' option) '}';

option: 'symmetry_breaking' ':' integer  #symmetryBreaking
    |   'bit_width' ':' integer          #bitWidth
    |   'skolem_depth' ':' integer       #skolemDepth
    |   'sharing' ':' integer            #sharing
;

universe
@init{context="universe";}
:( ('{' (atoms+=atom (',' atoms+=atom)*)'}') | ('[' (atoms+=atom (',' atoms+=atom)*) ']') ){
    System.out.println("universe:");
    for (AtomContext atom : $atoms) {
        String s = atom.getText(); System.out.println(s);
        if (atoms.contains(s)) {System.err.println("duplicated atom found: '"+ s + "' at "+ getLocation());}
        else {atoms.add(s);}
    }
    this.universe = new  kodkod.instance.Universe(this.atoms);
    this.bounds = new  kodkod.instance.Bounds(this.universe);
    context = null;
};

relations
@init{context="relations";}
: (relation arity? ':' type? '[' (lowerBound = tupleSet (',' upperBound = tupleSet)?) ']') {
    String name = $relation.text;
    System.out.println("relation " + name);
    if (relations.containsKey(name)) {System.err.println("duplicated relation found: '"+ name + "' at "+ getLocation());}

    kodkod.ast.Relation relation = null;
    int arity = 0;
    if ($arity.text != null && !$arity.text.isEmpty()) {arity = Integer.parseInt($arity.text);}

    kodkod.instance.TupleSet lowerBound = null;
    java.util.List<kodkod.instance.Tuple> tuplesInLowerBound = new java.util.ArrayList<kodkod.instance.Tuple>();
    if ($lowerBound.ctx != null && !$lowerBound.ctx.tuples.isEmpty()){
        if (arity == 0) {arity = $lowerBound.ctx.tuples.get(0).atoms.size();}
        for (TupleContext tuple : $lowerBound.ctx.tuples) {
            java.util.List<String> atoms = new java.util.ArrayList<String>();
            for (AtomContext atom : tuple.atoms) {
                atoms.add(atom.getText());
            }
            tuplesInLowerBound.add(this.universe.factory().tuple(atoms));
        }
        lowerBound = this.universe.factory().setOf(tuplesInLowerBound);
        System.out.println("lb: " +lowerBound);
    }

    kodkod.instance.TupleSet upperBound = null;
    java.util.List<kodkod.instance.Tuple> tuplesInUpperBound = new java.util.ArrayList<kodkod.instance.Tuple>();
    if ($upperBound.ctx != null && !$upperBound.ctx.tuples.isEmpty()){
        if (lowerBound == null && arity == 0) {arity = $upperBound.ctx.tuples.get(0).atoms.size();}
        for (TupleContext tuple : $upperBound.ctx.tuples) {
            java.util.List<String> atoms = new java.util.ArrayList<String>();
            for (AtomContext atom : tuple.atoms) {
                atoms.add(atom.getText());
            }
            tuplesInUpperBound.add(this.universe.factory().tuple(atoms));
        }
        upperBound = this.universe.factory().setOf(tuplesInUpperBound);
        System.out.println("up: " +upperBound);
    }

    if (lowerBound == null && upperBound == null && arity == 0) {arity = 1;}

    if (lowerBound == null) {lowerBound = this.universe.factory().noneOf(arity);}

    System.out.println(arity);
    if (arity == 0) {
        System.err.println("0 arity is detected on relation: '"+ name + "' at "+ getLocation());
    } else if (arity > 0) {
        relation = kodkod.ast.Relation.nary(name, arity);
    }

    if (upperBound == null) {this.bounds.boundExactly(relation, lowerBound);}
    else {this.bounds.bound(relation, lowerBound, upperBound);}
    this.relations.put(name, relation);
};

type:       <assoc=right> left=type leftMult=('set' | 'one' | 'lone' | 'some')? '->' rightMult=('set' | 'one' | 'lone' | 'some')? right=type    #cartesianProduct
          | left=type op=('+' | '&' | '-') right=type                                                                                           #setOperationsOnTypes
          | '(' type ')'                                                                                                                        #nestedMultiplicity
          | relation                                                                                                                            #set
;

tupleSet:   '{' (tuples+=tuple (',' tuples+=tuple)*)? '}'
          | '[' (tuples+=tuple (',' tuples+=tuple)*)? ']'
          | '{' left=tuple range='..' right=tuple '}'
          | '[' left=tuple range='..' right=tuple ']'
          | '{' left=relation range='->' right=relation '}'
          | '[' left=relation range='->' right=relation ']'
          ;

tuple: '(' atoms+=atom (',' atoms+=atom)* ')' | '[' atoms+=atom (',' atoms+=atom)* ']';
// The +, -, and & operators denote the union, difference, and intersection of two tuple sets, respectively.
// The -> operator denotes the Cartesian product of two tuple sets. car :2 [ none, { rel1a -> rel1b }  ]
// Tuple sets can be specified exhaustively by listing all their tuples. 'none' is a synonym for '{}'.
// If all the tuples have consecutive indices, the range operator .. can be used. car :2 [ none, {(A1, A2) .. (A3, A4)}  ]

atom: id=IDENTIFIER {
    if (context != null && !context.isEmpty() && !context.equals("universe")) {
        System.out.print("atom found: " + $id.text + "-> ");
        if ( atoms.contains($id.text) ) {System.out.println("defined");}
        else {System.err.println("undefined atom found: '" +$id.text  + "' at " + getLocation());}
    }
} | INT ;
relation: IDENTIFIER;
variable: IDENTIFIER;
integer: INT;
arity: INT; //positive integer

/*
All binary operators associate to the left, with the exception of implication, which associates to the right.
So, for example, p => q => r is parsed as p => (q => r), and a.b.c is parsed as (a.b).c.
*/

//Decls, Expression, Formula, IntExpression: kodkod.ast.Node
formula locals [int var = 0;]:
      'no'   expression                                                                                 #no             //Formula f = expr.no()   --Returns the formula 'no expr'.
    | 'lone' expression                                                                                 #lone           //Formula f = expr.lone() --Returns the formula 'lone expr'.
    | 'one'  expression                                                                                 #one            //Formula f = expr.one()  --Returns the formula 'one expr'.
    | 'some' expression                                                                                 #some           //Formula f = expr.some() --Returns the formula 'some expr'.

    //Set Operators: These operators can be applied to any pair of relations so long as they have the same arity.
    | left=expression not=('!' | 'not')? 'in' right=expression                                          #in             //Formula f = left.in(right) --Returns the formula 'left in right' (subset).
    | left=expression not=('!' | 'not')? '='  right=expression                                          #equal          //Formula f = left.eq(right) --Returns the formula 'left = right' (equal).

    //Integer Comparison Operators
    | left=intexpression not=('!' | 'not')? '='  right=intexpression                                    #eq             //Formula f= left.eq(right) --Returns a formula stating that the given int expression and left have the same value.
    | left=intexpression not=('!' | 'not')? '<'  right=intexpression                                    #lt             //Formula f= left.lt(right) --Returns a formula stating that the value of this int expression is less than the value of the given int expression.
    | left=intexpression not=('!' | 'not')? '<=' right=intexpression                                    #lte            //Formula f= left.lte(right)--Returns a formula stating that the value of this int expression is less than or equal to the value of the given int expression.
    | left=intexpression not=('!' | 'not')? '>'  right=intexpression                                    #gt             //Formula f= left.qt(right) --Returns a formula stating that the value of this int expression is greater than the value of the given int expression.
    | left=intexpression not=('!' | 'not')? '>=' right=intexpression                                    #gte            //Formula f= left.qte(right)--Returns a formula stating that the value of this int expression is greater than or equal to the value of the given int expression

    | {$formula::var = 0;}('sum' decls '|' intexpression)
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #sumDeclaration //IntExpression iexpr = sum(Decls decls);

    | 'acyclic' '[' relation ']'                                                                        #acyclic        //
    | 'function' '[' rel=relation ':' domain=expression '->' op=('one' | 'lone') range=expression ']'   #function       //Relation rel; Formula f = rel.function(domain, range); Formula f = rel.partialFunction(domain, range); --Returns a formula stating that this relation is a total function or partial function with the specified domain and range.
    | 'ord' '[' rel=relation ',' ordered=relation ',' first=relation ',' last=relation ']'              #totalOrder     //Relation rel; Formula f = rel.totalOrder(Relation ordered, Relation first, Relation last) --Returns a formula stating that this relation imposes a total ordering over the atoms in the set ordered, and that thet first and last elements in the ordering are given by the relations first and last.

    //Logical Operators
    //NotFormula
    | op=('!' | 'not') formula                                                                          #not            //Formula f = formula.not() --Returns the negation of this formula.

    //BinaryFormula (AND, IFF, IMPLIES, OR)
    | <assoc=right> left=formula op=('&&' | 'and' ) right=formula                                       #and            //Formula f = left.and(right)     --Returns the conjunction of left and the specified formula.
    | <assoc=right> left=formula op=('||' | 'or'  ) right=formula                                       #or             //Formula f = left.or(right)      --Returns the disjunction of left and the specified formula
    | <assoc=right> left=formula op=('=>' | 'if'  ) right=formula                                       #implies        //Formula f = left.implies(right) --Returns the implication of the specified formula by left.
    | <assoc=right> left=formula op=('<=>' | 'iff') right=formula                                       #iff            //Formula f = left.iff(right)      --Returns a formula that equates left and the specified formula.

    | {$formula::var = 0;}('all'  decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forAll         //Formula f = formula.forAll(decls)  --Returns a formula that represents a universal quantification of this formula over the given declarations
    | {$formula::var = 0;}('some' decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forSome        //Formula f = formula.forSome(decls) --Returns a formula that represents an existential quantification of this formula over the given declarations.
    | {$formula::var = 0;}('no'   decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forNo          //no x: e | F is true when F is true for no bindings of the variable x.
    | {$formula::var = 0;}('one'  decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forOne         //one x: e | F is true when F is true for exactly one binding of the variable x. (unique existential quantification)
    | {$formula::var = 0;}('lone' decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forLone        //lone x: e | F is true when F is true for at most one binding of the variable x.

    | {$formula::var = 0;}('let' letDecls ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #let

    //Constant Formulas
    | 'true'                                                                                            #true           //Formula f = Formula.FALSE --Constant formula false
    | 'false'                                                                                           #false          //Formula f  = Formula.TRUE --Constant formula true

    | '(' formula ')'                                                                                   #f_paranthesis
;

/*
**For the set theoretic operations (union, difference, and intersection) and for relational override,
the arguments are required to have the same arity.
*/
expression:
      {!isRelation()}? variable {
        System.out.print("variable found: " + $variable.text + "-> ");
        String s = $variable.text;
        if ( declarations.contains(s) ) {System.out.println("defined");}
        else {System.err.println("undefined variable found: '"+ s + "' at "+ getLocation());}
      }                                                                                                 #var            //ConstantExpression, Relation, Variable
    | {isRelation()}?  relation                                                                         #rel


    // Relational Operators
    // **These expressions are required to be binary
    | '~' expression                                                                                    #transpose      //Expression: expr.transpose() --Returns the transpose of expr.
    | '^' expression                                                                                    #closure        //Expression: expr.closure() --Returns the transitive closure of expr.
    | '*' expression                                                                                    #reflexive      //Expression: expr.reflexiveClosure()--Returns the reflexive transitive closure of expr.

    // Set theoretic operations:
    // **These operators can be applied to any pair of relations so long as they have the same arity.
    | left=expression '+' right=expression                                                              #union          //Expression: left.union(right) --Returns the union of left and the specified expression.
    | left=expression '&' right=expression                                                              #intersection   //Expression: left.intersection(right) --Returns the intersection of left and the specified expression.
    | left=expression '-' right=expression                                                              #difference     //Expression: left.difference(right) --Returns the difference of left and the specified expression.

    //Relational Operators
    | <assoc=left> left=expression '.' right=expression                                                 #join           //Expression expr = left.join(right) --Returns the join of left and the specified expression.
    | <assoc=left> right=expression '[' left=expression ']'                                             #boxjoin        //Expression expr = left.join(right) --e1[e2] = e2.e1 --
    | left=expression '->' right=expression                                                             #product        //Expression expr = left.product(right) --Returns the product of left and the specified expression
    | left=expression '++' right=expression                                                             #override       //Expression expr = left.override(right) --Returns the relational override of left with the specified expression.

    //A comprehension expression, e.g. { a: A, b: B | a.r = b }
    //Comprehensions make relations from properties
    //{x1: e1, x2: e2, … | F} The relation obtained by taking all tuples x1 -> x2 -> …
    // in which x1 is drawn from the set e1, x2 is drawn from the set e2, and so on,
    // and for which the constraint F holds. The expressions e1, e2, and so on, must be unary,
    // and may not be prefixed by (or contain) multiplicity keywords
    //all d: decls.decls[int] | decl.variable.arity = 1 and decl.multiplicity = ONE
    | {$formula::var = 0;}('{' comprehensionDecls '|' formula '}')
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #comprehension  //Expression f = formula.comprehension(Decls decls) //Returns the comprehension expression constructed from this formula and the given declarations.

    | op=('=>' | 'if') condition=formula 'then' thenExpr=expression 'else' elseExpr=expression          #ifExpression

    //Constants
    | 'iden'                                                                                            #iden           //Expression expr = Expression.IDEN --The identity relation: maps all atoms in a universe of discourse to themselves.
    | 'none'                                                                                            #none           //Expression expr = Expression.NONE --The empty relation: contains no atoms.
    | 'univ'                                                                                            #univ           //Expression expr = Expression.UNIV --The universal relation: contains all atoms in a universe of discourse.
    | 'ints'                                                                                            #ints           //Expression expr = Expression.INTS --The integer relation: contains all atoms bound to integers

    | '(' expression ')'                                                                                #e_paranthesis
;

intexpression:
      op=('=>' | 'if') condition=formula 'then' thenExpr=intexpression 'else' elseExpr=intexpression    #ifIntExpression
    | 'sum' expression                                                                                  #sum            //IntExpression iexpr = exp.sum();            --Returns the sum of the integer atoms in this expression.
    | '#'   expression                                                                                  #count          //IntExpression iexpr = exp.count();          --Returns the cardinality(the number of elements in the set) of this expression
    | <assoc=left> left=intexpression ('+' | 'plus')   right=intexpression                              #plus           //IntExpression iexpr = this.plus(intExpr);   --Returns an IntExpression that represents the sum of this and the given int node
    | <assoc=left> left=intexpression ('-' | 'minus')  right=intexpression                              #minus          //IntExpression iexpr = this.minus(intExpr);  --Returns an IntExpression that represents the difference between this and the given int node.
    | <assoc=left> left=intexpression ('*' | 'mul')    right=intexpression                              #multiply       //IntExpression iexpr = this.minus(intExpr);  --Returns an IntExpression that represents the product of this and the given int node.
    | <assoc=left> left=intexpression ('/' | 'div')    right=intexpression                              #divide         //IntExpression iexpr = this.divide(intExpr); --Returns an IntExpression that represents the quotient of the division between this and the given int node.
    | <assoc=left> left=intexpression ('%' | 'modulo') right=intexpression                              #modulo         //IntExpression iexpr = this.modulo(intExpr); --Returns an IntExpression that represents the remainder of the division between this and the given int node.
    | sign='-'? integer                                                                                 #intConstant
    | '(' intexpression ')'                                                                             #i_paranthesis
 ;

//A variable declaration, such as 'x : lone X'. Declarations are used with quantified formulas and comprehension expressions.
decls: decl (',' decl)*;

decl: disj='disj'? vars+=variable (',' vars+=variable)* ':' 'one'? expression
      {$formula::var = declareVariables($vars, $formula::var);}                                         #oneOf          //Decl d = var.oneOf(expression)
    | disj='disj'? vars+=variable (',' vars+=variable)* ':' 'lone' expression
      {$formula::var = declareVariables($vars, $formula::var);}                                         #loneOf         //Decl d = var.loneOf(expression)
    | disj='disj'? vars+=variable (',' vars+=variable)* ':' 'some' expression
      {$formula::var = declareVariables($vars, $formula::var);}                                         #someOf         //Decl d = var.someOf(expression)
    | disj='disj'? vars+=variable (',' vars+=variable)* ':' 'set'  expression
      {$formula::var = declareVariables($vars, $formula::var);}                                         #setOf          //Decl d = var.setOf(expression)
;

letDecls: letDecl (',' letDecl)*;

letDecl: (vars+=variable (',' vars+=variable)* '=' expression)
      {$formula::var = declareVariables($vars, $formula::var);} ;

comprehensionDecls: comprehensionDecl (',' comprehensionDecl)*;

comprehensionDecl:  disj='disj'? (vars+=variable (',' vars+=variable)* ':' 'one'? expression)
      {$formula::var = declareVariables($vars, $formula::var);}
;

INT :   DIGIT+ ;
IDENTIFIER : LETTER (LETTER | APOSTROPHE | DIGIT)* ;
fragment
LETTER: [a-zA-Z];
DIGIT: [0-9];
APOSTROPHE: '\'';
MULTILINE_COMMENT : '/**' .*? '**/' -> skip;
SINGLELINE_COMMENT : '--' .*? '\r'? '\n' -> skip;
WS: [ \t\r\n]+ -> skip ; // toss out whitespace
