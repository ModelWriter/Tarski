 Reasoning about Domain Specific Languages In Model-driven Architecture
 ======================================================================
 *  AlloyInECore Objectives
    * Alloy and Java-like syntax
    * Formal Language tailored to _EMF semantics_.
        * Object Oriented features (OMG EMOF-based)
    * _Formal Semantics_ is _First-order Relational Logic_
    * _Formal Verification_ by transforming to verification tools
        *  Able to transform specifications to OCL?, JML?, Viper??, Spec#??
    * KodKod back-end for _model-finding_, _instance generation_, and _model completion_ (repairing abstract data types in runtime)
    * _Runtime checking_ of executable DSLs.
    * Persistance of all language extensions into EAnnotations in XMI file in order to maintain portability.
        * In the same file, OCLInEcore and AlloyInEcore can be transferred.

 Experiments
 ===========
 * Harel State Charts
 * Choose a largest and most influential modeling language such as a language from UML or SysML
 
 
 * Type System, adapted from ... Fig.3 in 'Featherweight OCL: A Proposal for a Machine-Checked Formal Semantics for OCL 2.5'
 
 EMF Semantic Errors
 ===================
 1. Name Collisions of EClassifiers in EPackages. (ok)
 2. Name Collisions of EStructuralFeatures in Classes. (ok)
 3. Name Collisions of EStructuralFeatures after extending EClass.
 4. Circular Inheritance
 5. EType (in EAttribute, EReference, EOperation, EParameter) referenced to a missing EClassifiers and EReference (ok)
    * Checking existence of qualified names which is used as a target in ETypes
 6. Conformance of EOpposites in two EReferences
    * A.a = B  &&  B.b = A
    * check multiplicities as well???
 7. Referenced Element but not Imported Package
 8. Collision of Root Package Name and Imported Package.
 9. Visibility Control in everywhere
 10. Type checking using Java compiler
 
 Editor Features
 ===============
 
 Eclipse
 -------
 1. Syntax Highlighting with different colors for EMF keywords and AlloyInECore keywords
 2. Semantic Code Completion
 3. Error Annotations
 4. Serialization as EAnnotations in ECore file.
 5. Deserialization from ECore file
 6. Outline.
 7. Folding/Unfolding.
 
 Intellij
 --------
 1. Syntax Highlighting
 2. Semantic Code Completion
 3. Error Annotations
 4. Serialization as EAnnotations in ECore file.
 5. Deserialization from ECore file
 6. Structure
 
 If referenced element is in the same package, use relative path, do not use qualified name.
 When annotation references, always use qualified name.
 When editor is opened, at the background create "aie program file" for each imported ecore file.
 If a package and a class are in the same package and if they have the same

 * Safe Navigations
 	* Declaring Null-free Collections in Ecore
    * [http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.ocl.doc%2Fhelp%2FSafeNavigationTutorial.html]
 * Java Method Calls for string and integers
 * KodKod TotalOrder Relation can be a remedy for ordered sets in ECore
 
 * [EMF Generics Semantics][http://www.eclipse.org/articles/article.php?file=Article-Defining-Generics-with-UML-Templates/index.html] 
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
