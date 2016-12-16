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

 * 