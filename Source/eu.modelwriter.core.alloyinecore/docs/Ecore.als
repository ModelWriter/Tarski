module eu_modelwriter_transformation_models/Ecore

open eu_modelwriter_transformation/Type
open eu_modelwriter_transformation/Helper

/* Source: ECore Metamodel*/
abstract sig EModelElement extends Element {}

abstract sig EDataType extends EModelElement {}
lone sig EString, EBoolean, EInt extends EDataType {}

abstract sig ENamedElement extends EModelElement {name: one string }

one sig ECoreModel extends EModelElement { ePackages: some EPackage}

abstract sig EPackage extends ENamedElement {
	eClassifiers: set EClassifier,
	eSubPackages: set EPackage,
--	eSuperPackage: lone EPackage,
}
--{ all p: EPackage | lone p.~eSubPackages}

abstract sig EClassifier extends ENamedElement { ePackage: one EPackage }

abstract sig EClass extends EClassifier {
	eAttributes: set EAttribute,
	eReferences: set EReference,
	eSuperTypes: set EClass,
	isAbstract: one boolean
}

abstract sig EAttribute extends ENamedElement {
	eContainingClass: one EClass,
	eType: one (EDataType + EEnum)
}

abstract sig EReference extends ENamedElement {
--	eContainingClass: one EClass,
	eReferenceType: one EClass,
	containment: one boolean
}

abstract sig EEnum extends EClassifier {
	eLiterals: set EEnumLiteral,
}

abstract sig EEnumLiteral extends ENamedElement{
	eEnum: one EEnum,
}

/* Well-formedness rules of ECore Metamodel*/

fact containmentRelationshipsOfECoreElements{
	all m: ECoreModel, e1: EPackage, e2: EPackage |  e1 in m.ePackages => e1 !in e2.eSubPackages
--	eSubPackages = ~eSuperPackage
	--
	all e: EPackage, c: e.eClassifiers | c.ePackage = e
	eClassifiers = ~ePackage
	--
	all c: EClass, a: c.eAttributes | a.eContainingClass = c
	eAttributes = ~eContainingClass 
	-- 
	all c: EClass, r: c.eReferences | r.eContainingClass= c
	eReferences = ~eContainingClass
	-- 
	all e: EEnum, l: e.eLiterals | l.eEnum = e
	eLiterals = ~eEnum
}

fact uniqueNameConstraintsOfECoreElements{
	--names of EClasses are unique
	all c1: EClass, c2: EClass | c1.name = c2.name => c1 = c2
	--names of EAttributes are unique
	all e1: EAttribute, e2: EAttribute | e1.name = e2.name => e1 = e2
	--names of EReferences are unique 
	all r1: EReference, r2: EReference | r1.name = r2.name => r1 = r2
	--names of EEnums are unique
	all e1: EEnum, e2: EEnum | e1.name = e2.name => e1 = e2
	--name
	all c: EClass, a: EAttribute, r: EReference | (c -> a in eAttributes && c -> r in eReferences) => a.name != r.name
}

fact realismConstraint {some EClassifier}

fact inheritance { acyclic [EClass, eSuperTypes] }
fact package { acyclic [EPackage, eSubPackages] }

/* Counterexample Finding */
assert noContainment {some r: EReference, f: false  | r.containment in f}
check noContainment for 10 Element

assert noSelfParent{one p: EClass | p in p.eSuperTypes }
check noSelfParent

/* Instance Finding / Instance Completion*/
pred example {#EPackage >1 and #EClass > 2 and #EAttribute > 2 and #EReference >2 and  #eSuperTypes >2 
			and #isAbstract > 2 and #EEnum = 2 and #EEnumLiteral > 1 and #eSubPackages >=2}
run example for exactly 25 Element
//run example for exactly 15 ECoreElement



