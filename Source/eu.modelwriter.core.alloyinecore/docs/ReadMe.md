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

 * nullable quantifier for eReferences, inspired from this http://www.eecs.ucf.edu/~leavens/JML//refman/jmlrefman.pdf
 * default is non-null
 * modifiers such as ghost, model, instance
 
 For a field whose type is an array of reference types, such as a field of type Object[],
 both the field that refers to the array and the elements of the array are non_null by default.
 If a field whose type is an array of reference types is declared as nullable, then both the
 reference to the array and all of its elements may potentially be null. To specify that the
 field is not null but the elements may be null, use an invariant to state that the field cannot
 contain null, as follows. [Page 18]