 **Reasoning about Domain Specific Languages In Model-driven Architecture**
 *  AlloyInECore Objectives
    * Alloy-like syntax
    * Formal Language tailored to _EMF semantics_.
        * Object Oriented features (EMOF)
    * _Formal Semantics_ is _First-order Relational Logic_
    * _Formal Verification_ by transforming to verification tools
    * Able to transform specifications to OCL?, JML?, Viper??, Spec#??
    * KodKod back-end for _model-finding_, instance generation, model completion
    * _Runtime checking_ of executable DSLs.

 * Safe Navigations
 	* Declaring Null-free Collections in Ecore
    * [http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.ocl.doc%2Fhelp%2FSafeNavigationTutorial.html]
 * Java Method Calls for string and integers
 * KodKod TotalOrder Relation can be a remedy for ordered sets in ECore
 
 
 * (Set{1, 4, 7, 10}->symmetricDifference(Set{4, 5, 7})) = Set{1, 5, 10}
 * ((Set{1, 4, 7, 10}) - Set{4, 7}) = Set{1, 10}
 
 * ((OrderedSet{12, 9, 6, 3}) - Set{1, 3, 2}) = OrderedSet{12, 9, 6}
 * (OrderedSet{'a', 'b', 'c', 'd'}->insertAt(3, 'X')) = OrderedSet{'a', 'b', 'X', 'c', 'd'}
 * (OrderedSet{'a', 'b', 'c', 'd'}->subOrderedSet(2, 3)) = OrderedSet{'b', 'c'}
 
 * (Sequence{'a', 'b', 'c', 'c', 'd', 'e'}->prepend('X')) = Sequence{'X', 'a', 'b', 'c', 'c', 'd', 'e'}
 * (Sequence{'a', 'b', 'c', 'c', 'd', 'e'}->append('X')) = Sequence{'a', 'b', 'c', 'c', 'd', 'e', 'X'}
 * (Sequence{'a', 'b', 'c', 'c', 'd', 'e'}->subSequence(3, 5)) = Sequence{'c', 'c', 'd'}
 * (Sequence{'a', 'b', 'c', 'c', 'd', 'e'}->indexOf('c')) = 3

 * `nullable` quantifier for eReferences, eAttribute 
    * inspired from this http://www.eecs.ucf.edu/~leavens/JML//refman/jmlrefman.pdf
    * default is `non-null, !nullable` [Page 18]
 * modifiers such as ghost??, `model`, instance??
 * `\old()` in  `\result` postconditions
 * contains and length for collections???
 * Object `Invariant`
 * `invariant` must be:
    * True at end of constructor.
    * _Preserved by each method._
 * `requires` clause:
    * Precondition.
    * Obligation on callers, after parameter passing
    * Assumed by implementor.
 * `ensures` clause:
    * Postcondition.
    * Obligation on implementor, at return.
    * Assumed by caller.
 * `assignable`, `modifies`, `modifiable`
    * Frame axiom.
    * _Locations (fields) in pre-state_
    * New object fields not covered.
    * Mostly checked statically.
    * Assignable is a Shorthand
    * `assignable gender; ensures gender.equals(g);`
    * `ensures \only_assigned(gender) && gender.equals(g);`
    * `assignable \nothing` = `pure`
 * `pure`
    * _No side effects._
    * Implies `assignable \nothing`
    * _Allows method’s use in specifications._
 * Defaults:
    * `invariant true;`
    * `requires true;`
    * `assignable \everything;`
    * `ensures true;`
 * Model Fields
    * Just for specification
    * Abstraction of Java Fields
    * Value from `represents`
    
    

 * Field Specification
 * Method Specification with `requires` and `ensures`
 * inclusion of `assignable`
    * `\nothing`
    
 * keyword `pure`
 
 
 * Type System, adapted from ... Fig.3 in 'Featherweight OCL: A Proposal for a Machine-Checked Formal Semantics for OCL 2.5'
 
  
 