model test/crocopat

sig Domain {
	function: set Range,
}

sig Range {}

pred isFunction {	
	all disj a1, a2 :Domain | a1.function != a2.function 
	all d : Domain | one d.function
	all r : Range  | one r.~function
}

run isFunction for  exactly 4 Domain, exactly 4 Range
