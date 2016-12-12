module eu_modelwriter_transformation_models/ECoreSimplified

/* Source: ECore Simplified Metamodel*/

one sig ECoreModel extends EModelElement { classes: set EClass }

abstract sig EModelElement {}

sig string extends EModelElement {}
abstract sig boolean extends EModelElement {}
sig integer extends EModelElement {}
one sig false,true extends boolean {}

abstract sig EDataType extends EModelElement {}
one sig EString, EBoolean, EInt extends EDataType {}

abstract sig ENamedElement extends EModelElement {name: one string }

abstract sig EClass extends ENamedElement {
	attrs: set EAttribute,
	refs: set EReference,
	cbelongs: one ECoreModel,
	parents: set EClass,
	isAbstract: one boolean
}

abstract sig EAttribute extends ENamedElement {
	abelongs: one EClass,
	type: one EDataType
}

abstract sig EReference extends ENamedElement {
	rbelongs: one EClass,
	type: one EClass
}

/* Well-formedness rules of ECore Metamodel*/

fact {
	
	all m: ECoreModel, c: m.classes | c.cbelongs = m
	classes = ~cbelongs

	all c: EClass, a: c.attrs | a.abelongs = c
	attrs = ~abelongs

	all c: EClass, r: c.refs | r.rbelongs = c
	refs = ~rbelongs

	all c1: EClass, c2: EClass | c1.name = c2.name => c1 = c2
	all e1: EAttribute, e2: EAttribute | e1.name = e2.name => e1 = e2
	all r1: EReference, r2: EReference | r1.name = r2.name => r1 = r2
	
	all a: EAttribute, c: EClass, r: EReference | (c -> a in attrs && c -> r in refs) => a.name != r.name
	
	--no self parent class
	no p: EClass | p in p.parents
	--no parent one another 
	no c1: EClass, c2: EClass |  c1.parents = c2 and c2.parents = c1
}

/* test */
pred example {#EClass > 2 and #EAttribute > 2 and #EReference >2 and  #parents >2}
run example for exactly 18 EModelElement
//run example for exactly 15 ECoreElement



