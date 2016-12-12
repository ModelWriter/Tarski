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
    (visibiliry= visibilityKind)?
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
    (visibiliry= visibilityKind)?
    isAbstract= 'abstract'? 'class' name= identifier ('extends' eSuperTypes+= qualifiedName (',' eSuperTypes+= qualifiedName)*)?
    (':' instanceClassName= SINGLE_QUOTED_STRING)?
    ('{' isInterface= 'interface'? '}')?
    (('{' (eOperations+= eOperation | eStructuralFeatures+= eStructuralFeature | eConstraints+= invariantConstraint)* '}') | ';')
    ;

eStructuralFeature: eAttribute | eReference ;

eAttribute:
    (visibiliry= visibilityKind)?
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
	(visibiliry= visibilityKind)?
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
	(visibiliry= visibilityKind)?
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
	   | ('body' identifier? ':' ownedBodyExpression+= specification? ';')
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
MULTILINE_COMMENT : '/**' .*? '**/' -> skip;
SINGLELINE_COMMENT : '--' .*? '\r'? '\n' -> skip;
WS: [ \t\r\n]+ -> skip ; // toss out whitespace
