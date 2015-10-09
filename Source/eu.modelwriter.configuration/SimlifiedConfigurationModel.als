module Haveksan/Requirement

abstract sig Requirement {}

sig Task {
	precede: lone Task,
}{ all t: Task | one t.~task}

one sig Project extends Requirement {
	requirement: some ContractRequirement }

sig ContractRequirement extends Requirement {
	system: set SystemRequirement,
	relate: set ContractRequirement
}{all c: ContractRequirement | one c.~requirement}

--@name: "System Requirement"
sig SystemRequirement extends Requirement { 
	child: some Implementation
}{ all s: SystemRequirement | one s.~system}

abstract sig Implementation extends Requirement {
	task: set Task
}{ all i: Implementation | one i.~child}

--@context.editor: "ReqIFEditor"
sig SoftwareRequirement extends Implementation {
	test: some TestCase
}

sig HardwareRequirement extends Implementation {}

sig TestCase { }{ all t:TestCase  | one t.~test}


fact noSelfRelation{
	no c: ContractRequirement | c in c.relate
	no t: Task | t in t.precede }

fact noCycles{no t:Task | t in t.^precede}

fact realismConstraint {
	some ContractRequirement 
	some HardwareRequirement 
	some SoftwareRequirement
	some precede}

/* Counterexample Finding */


/* Instance Finding */
pred example {
	#ContractRequirement >1 and #SystemRequirement >2  and 
	#SoftwareRequirement >1 and #HardwareRequirement >1 and
	#precede >1 and #task >1
}
run example for 10

