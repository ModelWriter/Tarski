module ferhat/FileSystem

abstract sig Object {}
sig Directory extends Object { contents: set Object}
one sig Root extends Directory { }
sig File extends Object { }
sig Alias extends Object { refs: set Word }
sig Word extends File { }

fact {
	no d:Directory | d in d.^contents --no directory cycles
	Object 	in Root.*contents --each object is reacble from the root
	all o: Object | lone o.~contents --each object has at most one parent
	no disj a, a': Alias | some a.refs & a'.refs --no overlapping references to objects, 
						 --each references maps each Alias to different objects
}



pred example {#Alias >2 #refs> 2 #Directory >2}
run example for exactly 10 Object
