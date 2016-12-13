grammar AlloyInEcore;

@parser::header { }

@parser::members {
    public java.util.List<String> ePackageNames = new java.util.ArrayList<String>();
    public java.util.Map<String, org.eclipse.emf.ecore.EPackage> ePackages = new java.util.HashMap<String, org.eclipse.emf.ecore.EPackage>();
    public java.util.List<String> eClassNames = new java.util.ArrayList<String>();
    public java.util.Map<String, org.eclipse.emf.ecore.EClass> eClasses = new java.util.HashMap<String, org.eclipse.emf.ecore.EClass>();
    org.eclipse.emf.ecore.EcoreFactory _eCoreFactory = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE;
    org.eclipse.emf.ecore.EcorePackage _eCorePackage = org.eclipse.emf.ecore.EcorePackage.eINSTANCE;

    private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}
}

// http://help.eclipse.org/neon/topic/org.eclipse.ocl.doc/help/OCLinEcore.html
module:
    ('module' identifier)? //optional module declaration
    ownedPackageImport+= packageImport*
    ownedPackage+= ePackage* {
        for (EPackageContext ePackageCtx : $ownedPackage) {
            String name = ePackageCtx.name.getText();
          	System.out.println("ePackage: " + name);
            org.eclipse.emf.ecore.EPackage ePackage = _eCoreFactory.createEPackage();
            ePackage.setName(name);
            ePackage.setNsPrefix(ePackageCtx.nsPrefix.getText());
            ePackage.setNsURI(ePackageCtx.nsURI.getText());
            ePackageNames.add(ePackage);
        }
};

//Zero or more external metamodels may be imported.
packageImport:
    ('import') (name= identifier ':')? ownedPathName= SINGLE_QUOTED_STRING ';'
    ;

ePackage:
    (visibility= visibilityKind)?
    'package' name= identifier (':' nsPrefix= identifier) ('=' nsURI= SINGLE_QUOTED_STRING)
    (('{' (eSubPackages+= ePackage | eClassifiers+= eClassifier)* '}') | ';'){
        for (EPackageContext ePackageCtx : $eSubPackages) {
            String name = ePackageCtx.name.getText();
          	System.out.println("ePackage: " + name);
            org.eclipse.emf.ecore.EPackage ePackage = _eCoreFactory.createEPackage();
            ePackage.setName(name);
            ePackage.setNsPrefix(ePackageCtx.nsPrefix.getText());
            ePackage.setNsURI(ePackageCtx.nsURI.getText());
//          ePackageNames.add(ePackage.getName());
        }
};

eClassifier: eClass | eDataType | eEnum ;

eClass:
    (visibility= visibilityKind)?
    isAbstract= 'abstract'? 'class' name= identifier ('extends' eSuperTypes+= qualifiedName (',' eSuperTypes+= qualifiedName)*)?
    (':' instanceClassName= SINGLE_QUOTED_STRING)?
    ('{' isInterface= 'interface'? '}')?
    (('{' (eOperations+= eOperation | eStructuralFeatures+= eStructuralFeature | eConstraints+= invariantConstraint)* '}') | ';')
    ;

eStructuralFeature: eAttribute | eReference ;

// OCL and UML support four permutations of ordered/not-ordered, unique/not-unique to give useful Collection behaviors.
// A Parameter may have a variety of qualifiers:
//  ordered specifies that the returned elements are ordered (default !ordered)
//  unique specifies that there are no duplicate returned elements (default unique)

// The defaults for multiplicity lower and upper bound and for ordered and unique follow the UML specification and so
// corresponds to a single element Set that is [1] {unique,!ordered}. Note that UML defaults differ from the Ecore
// defaults which correspond to an optional element OrderedSet, that is [?] {ordered,unique}.

// An Attribute may a simple initializer and a variety of qualifiers:
//  derived specifies a derived attribute (default !derived)
//  id specifies that the attribute provides the identifier if its class (default !id)
//  ordered specifies that the attribute elements are ordered (default !ordered)
//  readonly specifies that the attribute elements are readonly (not changeable) (default !readonly)
//  transient specifies that the attribute elements are computed on the fly (default !transient)
//  unique specifies that there are no duplicate attribute elements (default unique)
//  unsettable specifies that attribute element may have no value (default !unsettable)
//  volatile specifies that the attribute elements are not persisted (default !volatile)

eAttribute:
    (visibility= visibilityKind)?
    (qualifier+='static')?
	'attribute' name= identifier ('=' defaultValue= SINGLE_QUOTED_STRING)?
	(':' eAttributeType= eType multiplicity= eMultiplicity? )?
	('{'((qualifier+='derived' | qualifier+='!derived' | qualifier+='id' | qualifier+='!id' |
		  qualifier+='ordered' | qualifier+='!ordered' | qualifier+='readonly' | qualifier+='!readonly' |
		  qualifier+='transient' | qualifier+='!transient' | qualifier+='unique' | qualifier+='!unique' |
		  qualifier+='unsettable' | qualifier+='!unsettable' | qualifier+='volatile' | qualifier+='!volatile') ','? )+ '}')?
	(	('{' (('initial' identifier? ':' ownedDefaultExpression += specification? ';')
	      |   ('derivation' identifier? ':' ownedDefaultExpression += specification? ';') )*
	     '}')
	|	 ';'
	)
	;

eReference:
	(visibility= visibilityKind)?
    (qualifier+='static')?
	'property' name= identifier
	('#' opposite= identifier)? (':' eReferenceType= eType multiplicity= eMultiplicity? )? ('=' defaultValue= SINGLE_QUOTED_STRING)?
	('{'((qualifier+='composes' | qualifier+='!composes' | qualifier+='derived' | qualifier+='!derived' |
		  qualifier+='ordered' | qualifier+='!ordered' | qualifier+='readonly' | qualifier+='!readonly' |
		  qualifier+='resolve' | qualifier+='!resolve' | qualifier+='transient' | qualifier+='!transient' |
		  qualifier+='unique' | qualifier+='!unique' | qualifier+='unsettable' | qualifier+='!unsettable' |
		  qualifier+='volatile' | qualifier+='!volatile' ) ','? )+
	'}')?
	(   ('{' (('key' referredKeys+= qualifiedName (',' referredKeys+= qualifiedName)* ';') //this only lets the attributes of the eReferenceType of this eReference
	      |   ('initial' identifier? ':' ownedDefaultExpressions+= specification? ';')
	      |   ('derivation' identifier? ':' ownedDefaultExpressions+= specification? ';') )*
	     '}')
	|    ';'
	)
    ;

eOperation:
	(visibility= visibilityKind)?
    (qualifier+='static')?
	'operation' name= identifier
	'(' (eParameters+= eParameter (',' eParameters+= eParameter)*)? ')'
	(':' returnType= eType multiplicity= eMultiplicity? )?
	('throws' ownedException+= identifier (',' ownedException+= identifier)*)?
	('{'((qualifier+='derived' | qualifier+='!derived' |
		  qualifier+='ordered' | qualifier+='!ordered' |
		  qualifier+='unique'  | qualifier+='!unique'
		) ','? )+
	'}')?
	(('{'
	     (ownedPrecondition+= preconditionConstraint
	   | ownedBodyExpression+= bodyExpression
	   | ownedPostcondition+= postconditionConstraint)*
	  '}') | ';')
;


eParameter:
	name= identifier
	(':' ownedType= eType ownedMultiplicity= eMultiplicity?)?
	('{'(( qualifier+='ordered' | qualifier+='!ordered' | qualifier+='unique' | qualifier+='!unique') ','?)+
	 '}')?
;

eType:
    ePrimitiveType | qualifiedName
;

eMultiplicity:
	'[' (lowerBound= lower ('..' upperBound= upper)? | stringBounds= ('*'|'+'|'?') ) ']';

eDataType:
    isPrimitive= 'primitive'? 'datatype' name= identifier
    (ownedSignature= templateSignature)?
    (':' instanceClassName= SINGLE_QUOTED_STRING)?
    ('{' (isSerializable= 'serializable' | '!serializable')? '}')?
    (('{' ownedConstraint+= invariantConstraint*  '}')  | ';')

;

ePrimitiveType:
      'Boolean'
    | 'Integer'
    | 'String'
    | 'Real'
    | 'UnlimitedNatural'
;

eEnum:
    'enum' name= identifier
    ('{' (isSerializable= 'serializable' | '!serializable')? '}')?
    (('{' ownedLiteral+= eEnumLiteral* '}') | ';')
    ;

eEnumLiteral:
	(('literal' name= identifier) | name= identifier) ('=' value= signed)? ';'
	;

//Bu kısım eksik çünkü hiç örneğini göremedim devamının
templateSignature:
      ('(' ownedParameter+= identifier (',' ownedParameter += identifier)* ')')
    | ('<' ownedParameter+= identifier (',' ownedParameter += identifier)* '>')
    ;



bodyExpression:
    ('body' identifier? ':' ownedBodyExpression+= specification? ';')
    ;

invariantConstraint:
    (isCallable= 'callable')? stereotype= 'invariant' (name= identifier ('(' ownedMessageSpecification= specification ')')? )?
	((':' ownedSpecification= specification? ';') | ';')
    ;

preconditionConstraint:
	stereotype= 'precondition' (name= identifier ('(' ownedMessageSpecification= specification ')')?)? ':' ownedSpecification= specification? ';'
    ;

postconditionConstraint:
	stereotype= 'postcondition' (name= identifier ('(' ownedMessageSpecification= specification ')')?)? ':' ownedSpecification= specification? ';'
    ;

specification:
    ownedExpression= expression
    ;

expression: 'expr' ;

visibilityKind:
      'public'
    | 'protected'
    | 'private'
    | 'package'
    ;

qualifiedName: firstPart+= identifier (('::' midPart+= identifier)* ('::' lastPart= identifier))?;
identifier: IDENTIFIER;
upper: INT | '*';
lower: INT;
signed: '-'? INT;

INT :   DIGIT+ ;
IDENTIFIER : LETTER (LETTER | APOSTROPHE | DIGIT | UNDERSCORE)* ;
DOUBLE_QUOTED_STRING : '"' ( ESCAPED_CHARACTER | ~('\\' | '"' ) )* '"'  ;
SINGLE_QUOTED_STRING: '\'' ( ESCAPED_CHARACTER | ~('\'' | '\\') )* '\'' ;
fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment ESCAPED_CHARACTER: '\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | '\'' | '\\');
fragment UNDERSCORE: '_';
fragment APOSTROPHE: '\'';
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;
SINGLELINE_COMMENT : '--' .*? '\r'? '\n' -> skip;
WS: [ \t\r\n]+ -> skip ; // toss out whitespace
