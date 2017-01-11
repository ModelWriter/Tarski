/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

grammar AlloyInEcore;

@parser::header {

import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import java.util.stream.Collectors;

import java.util.*;

}

@parser::members {
public java.util.Stack<String> declarations = new java.util.Stack<String>();
public java.util.List<String> atoms = new java.util.ArrayList<String>();
public java.util.List<kodkod.ast.Formula> formulas = new java.util.ArrayList<kodkod.ast.Formula>();
public java.util.Map<String, kodkod.ast.Relation> relations = new java.util.HashMap<String, kodkod.ast.Relation>();
public kodkod.instance.Universe universe = null;
public kodkod.instance.Bounds bounds = null;

private boolean isRelation() {
//System.out.println("isRelation? " + this.relations.containsKey(getCurrentToken().getText()) + ": " + getCurrentToken().getText());
return this.relations.containsKey(getCurrentToken().getText()); }
private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}
private String context = null;
private int declareVariables(java.util.List<VariableIdContext> vars, int var) {
    //System.out.println("Quantifier context: ");
    for (VariableIdContext vc : vars) {
        String s = vc.getText();
        declarations.add(s);
        var++;
        //System.out.println(s);
    }
    return var;
}
private void printUniverse() {
    //System.out.println(universe);
}
private void printBounds() {
    //System.out.println(bounds);
}

//ECORE BEGINS

public void saveResource(EPackage root){
    ResourceSet metaResourceSet = new ResourceSetImpl();
    metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());
    Resource metaResource = metaResourceSet.createResource(URI.createURI(this.pathName + this.fileName + ".ecore"));
    metaResource.getContents().add(root);
    try {
        metaResource.save(null);
    } catch (java.io.IOException e) {
        e.printStackTrace();
    }
}

public AlloyInEcoreParser(TokenStream input, String filename, String path){
    this(input);
    this.fileName = filename;
    this.pathName = path;
}

private String fileName;
private String pathName;

public final Stack<String> qName = new Stack<>();
public final Stack<String> qPath = new Stack<>();

private EcoreFactory eFactory = EcoreFactory.eINSTANCE;

private String getContextText(ParserRuleContext ctx){
    return getTokenStream().getTokenSource().getInputStream().toString().substring(ctx.start.getStartIndex(),ctx.stop.getStopIndex());
}

}

problem: options? universe {printUniverse();} relations {printBounds();} formulas+=formula* {} {
    //System.out.println("declarations= "+declarations);
    declarations.clear();
};

options: 'options' '{'  option (',' option)* '}';

option: key= 'symmetry_breaking' ':'    value= integer  #symmetryBreaking
    |   key= 'bit_width' ':'            value= integer  #bitWidth
    |   key= 'skolem_depth' ':'         value= integer  #skolemDepth
    |   key= 'sharing' ':'              value= integer  #sharing
;

universe
@init{context="universe";}
:'universe' (('{' (atoms+=atom (',' atoms+=atom)*)'}') | ('[' (atoms+=atom (',' atoms+=atom)*) ']') ){
    //System.out.println("universe:");
    for (AtomContext atom : $atoms) {
        String s = atom.getText();
        //System.out.println(s);
        if (atoms.contains(s)) {
            notifyErrorListeners(atom.getStart(),"duplicated atom found: '"+ s + "'", (RecognitionException)null);
        }
        else {atoms.add(s);}
    }
    this.universe = new kodkod.instance.Universe(this.atoms);
    this.bounds = new kodkod.instance.Bounds(this.universe);
    context = null;
};

relations: 'relations' '{' relation* '}' {}
;

relation @init{context="relations";}
: (name=identifier arity? ':' expression? '[' (lowerBound = tupleSet (',' upperBound = tupleSet)?) ']') {
    String name = $identifier.text;
    //System.out.println("relation " + name);
    if (relations.containsKey(name)) {
        notifyErrorListeners($name.ctx.getStart(), "duplicated relation found: '"+ name + "'", (RecognitionException)null);
    }
    kodkod.ast.Relation relation = null;
    int arity = 0;
    if ($arity.text != null && !$arity.text.isEmpty()) {arity = Integer.parseInt($arity.text);}

    kodkod.instance.TupleSet lowerBound = null;
    java.util.List<kodkod.instance.Tuple> tuplesInLowerBound = new java.util.ArrayList<kodkod.instance.Tuple>();
    if ($lowerBound.ctx != null && !$lowerBound.ctx.tuples.isEmpty()){
        if (arity == 0) {arity = $lowerBound.ctx.tuples.get(0).atoms.size();}
        for (TupleContext tuple : $lowerBound.ctx.tuples) {
            java.util.List<String> atomsInTuple = new java.util.ArrayList<String>();
            for (AtomContext atom : tuple.atoms) {
                if (atom.getText() == null || atom.getText().isEmpty()) continue;
                if (this.atoms.contains(atom.getText())) atomsInTuple.add(atom.getText());
            }
            if (!atomsInTuple.isEmpty() && atomsInTuple.size() == arity) {
                tuplesInLowerBound.add(this.universe.factory().tuple(atomsInTuple));
            }
        }
        lowerBound = this.universe.factory().setOf(tuplesInLowerBound);
        //System.out.println("lb: " +lowerBound);
    }

    kodkod.instance.TupleSet upperBound = null;
    java.util.List<kodkod.instance.Tuple> tuplesInUpperBound = new java.util.ArrayList<kodkod.instance.Tuple>();
    if ($upperBound.ctx != null && !$upperBound.ctx.tuples.isEmpty()){
        if (lowerBound == null && arity == 0) {arity = $upperBound.ctx.tuples.get(0).atoms.size();}
        for (TupleContext tuple : $upperBound.ctx.tuples) {
            java.util.List<String> atomsInTuple = new java.util.ArrayList<String>();
            for (AtomContext atom : tuple.atoms) {
                if (atom.getText() == null || atom.getText().isEmpty()) continue;
                if (this.atoms.contains(atom.getText())) atomsInTuple.add(atom.getText());
            }
            if (!atomsInTuple.isEmpty() && atomsInTuple.size() == arity) {
                tuplesInUpperBound.add(this.universe.factory().tuple(atomsInTuple));
            }
        }
        upperBound = this.universe.factory().setOf(tuplesInUpperBound);
        //System.out.println("up: " +upperBound);
    }

    if (lowerBound == null && upperBound == null && arity == 0) {arity = 1;}

    if (lowerBound == null) {lowerBound = this.universe.factory().noneOf(arity);}

    //System.out.println(arity);
    if (arity == 0) {
        notifyErrorListeners($arity.ctx.getStart(), "0 arity is detected on relation: '"+ name + "'", (RecognitionException)null);
    } else if (arity > 0) {
        relation = kodkod.ast.Relation.nary(name, arity);
    }

    if (upperBound == null) {this.bounds.boundExactly(relation, lowerBound);}
    else {this.bounds.bound(relation, lowerBound, upperBound);}
    this.relations.put(name, relation);
};

tupleSet:   '{' (tuples+=tuple (',' tuples+=tuple)*)? '}'
          | '[' (tuples+=tuple (',' tuples+=tuple)*)? ']'
          | '{' left=tuple range='..' right=tuple '}'
          | '[' left=tuple range='..' right=tuple ']'
          ;

tuple:
// The +, -, and & operators denote the union, difference, and intersection of two tuple sets, respectively.
// The -> operator denotes the Cartesian product of two tuple sets. car :2 [ none, { rel1a -> rel1b }  ]
// Tuple sets can be specified exhaustively by listing all their tuples. 'none' is a synonym for '{}'.
// If all the tuples have consecutive indices, the range operator .. can be used. car :2 [ none, {(A1, A2) .. (A3, A4)}  ]
    '(' atoms+=atom (',' atoms+=atom)* ')' | '[' atoms+=atom (',' atoms+=atom)* ']';

// http://help.eclipse.org/neon/topic/org.eclipse.ocl.doc/help/OCLinEcore.html
//optional module declaration
module @init {Document.getInstance().parser = this; }:
    options? {}
    ('module' identifier)? {}
    ownedPackageImport+= packageImport* {}
    ownedPackage= ePackage {Document.getInstance().signalParsingCompletion(); saveResource($ownedPackage.element);}
    ;

//Zero or more external metamodels may be imported.
packageImport:
    ('import') (name= identifier ':')? ownedPathName= SINGLE_QUOTED_STRING ';'
    ;

ePackage returns [EPackage element] locals [int anno=0]
@init {$element = eFactory.createEPackage();} @after {System.out.println(Console.BLUE + qName.peek() + " (Package)" + Console.RESET); qName.pop();}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    'package' name= unrestrictedName {qName.push(qName.empty() ? $name.text : qName.peek() + "." + $name.text ); $element.setName($name.text);}
    (':' nsPrefix= identifier) ('=' nsURI= SINGLE_QUOTED_STRING)  {$element.setNsPrefix($nsPrefix.text); $element.setNsURI($nsURI.text);}
    (('{' (   ownedAnnotations+=eAnnotation [$anno++] {$element.getEAnnotations().add($eAnnotation.element);}
            | eSubPackages+= ePackage {$element.getESubpackages().add($ePackage.element);}
            | eClassifiers+= eClassifier {$element.getEClassifiers().add($eClassifier.element);}
            | eConstraints+= invariant {$element.getEAnnotations().add($invariant.element);}
          )*
      '}') | ';') {Document.getInstance().addNamedElement(qName.peek(), $ctx.element, $ctx, $ctx.name.start);}
    ;

eClassifier returns [EClassifier element]:
      eClass {$element= $eClass.element;}
    | eDataType {$element= $eDataType.element;}
    | eEnum {$element= $eEnum.element;}
    ;

//Once interface is true, abstract is also implicitly true. Interface with abstract modifier is redundant.
eClass returns [EClass element] locals [int anno=0]
@init {$element = eFactory.createEClass();} @after {System.out.println(Console.GREEN + qName.peek() + " (Class)" + Console.RESET); qName.pop();}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (isAbstract= 'abstract'? isClass='class' | isInterface= 'interface') {$element.setAbstract($isAbstract!=null); if ($isInterface!=null) {$element.setInterface(true);$element.setAbstract(true);}}
    name= unrestrictedName? {if ($ctx.name == null) {notifyErrorListeners("missing Class name"); qName.push(qName.peek() + "." + "class0" );} else {$element.setName($name.text); qName.push(qName.peek() + "." + $name.text );}}
    (ownedSignature= templateSignature)? {}
    ('extends' eSuperTypes+= typedRef (',' eSuperTypes+= typedRef)*)? {}
    (':' instanceClassName= SINGLE_QUOTED_STRING)? {if($instanceClassName != null) $element.setInstanceClassName($instanceClassName.getText().replace("'", ""));}
    (('{' (   ownedAnnotations+= eAnnotation [$anno++] {$element.getEAnnotations().add($eAnnotation.element);}
            | eOperations+= eOperation {$element.getEOperations().add($eOperation.element);}
            | eStructuralFeatures+= eStructuralFeature {$element.getEStructuralFeatures().add($eStructuralFeature.element);}
            | eConstraints+= invariant {$element.getEAnnotations().add($invariant.element);}
          )*
      '}') | ';') {Document.getInstance().addNamedElement(qName.peek(), $ctx.element, $ctx, $ctx.name != null ? $ctx.name.start : $ctx.isClass != null ? $ctx.isClass : $ctx.isInterface );}
    ;

// A StructuralFeature may be an Attribute or a Reference
eStructuralFeature returns [EStructuralFeature element]:
      eAttribute {$element= $eAttribute.element;}
    | eReference {$element= $eReference.element;}
    ;

// OCL and UML support four permutations of ordered/not-ordered, unique/not-unique to give useful Collection behaviors.
// A Parameter may have a variety of qualifiers:
// ordered specifies that the returned elements are ordered (default !ordered)
// unique specifies that there are no duplicate returned elements (default unique)

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

// The defaults for multiplicity lower and upper bound and for ordered and unique correspond to a single element Set
// that is [1] {unique,!ordered}
eAttribute returns [EAttribute element] locals [int anno=0]
@init {$element = eFactory.createEAttribute();} @after {System.out.println(qName.peek() + " (Attribute)"); qName.pop();}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+='static')?
    (qualifier+='model' | qualifier+='ghost')?
    (qualifier+='transient')?
    (qualifier+='volatile')?
    (qualifier+='nullable' | qualifier+='!nullable')?
    (qualifier+='readonly')?
	'attribute' name= unrestrictedName {qName.push(qName.peek() + "::" + $name.text ); $element.setName($name.text);}
	(':' eAttributeType= typedRef (ownedMultiplicity= eMultiplicity[(ETypedElement)$element])?) {}
	('=' defaultValue= SINGLE_QUOTED_STRING )? {if($defaultValue != null) $element.setDefaultValueLiteral($defaultValue.getText().replace("'", ""));}
	('{'((qualifier+='derived' | qualifier+='id' |
		  qualifier+='ordered' | qualifier+='!ordered' | qualifier+='unique'  | qualifier+='!unique'  |
		  qualifier+='unsettable' | qualifier+='!unsettable') ','? )+
	 '}')? {Document.getInstance().setQualifiers($element, $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList()));}
	(('{'(  (ownedAnnotations+= eAnnotation [$anno++] {$element.getEAnnotations().add($eAnnotation.element);} )*
	        (ownedDerivation= derivation {$element.getEAnnotations().add($derivation.element);} | ownedInitial= initial{$element.getEAnnotations().add($initial.element);})?
	        (ownedAnnotations+= eAnnotation [$anno++] {$element.getEAnnotations().add($eAnnotation.element);} )*
	     )
	  '}') | ';') {Document.getInstance().addNamedElement(qName.peek(), $ctx.element, $ctx, $ctx.name.start);}
    ;

    //{$element.getEAnnotations().add($derivation.element);} {$element.getEAnnotations().add($initial.element);}
    //{if ($ctx.eAnnotation() != null) $element.getEAnnotations().add($eAnnotation.element);}

// The defaults for multiplicity lower and upper bound and for ordered and unique correspond to a single element Set
// that is [1] {unique,!ordered}
// Nullable specifies that the elements of reference type are not nullable (default !nullable)
eReference returns [EReference element] locals [int anno=0]
@init {$element = eFactory.createEReference();} @after {System.out.println(qName.peek() + " (Reference)"); qName.pop();}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+='static')?
    (qualifier+='model' | qualifier+='ghost')?
    (qualifier+='transient')?
    (qualifier+='volatile')?
    (qualifier+='nullable' | qualifier+='!nullable')?
    (qualifier+='readonly')?
	'property' name= unrestrictedName {qName.push(qName.peek() + "::" + $name.text ); $element.setName($name.text);}
	('#' eOpposite= unrestrictedName)? {}
	(':' eReferenceType= typedRef (ownedMultiplicity= eMultiplicity[(ETypedElement) $element])? ) {}
	('=' defaultValue= SINGLE_QUOTED_STRING)? {if($defaultValue != null) $element.setDefaultValueLiteral($defaultValue.getText().replace("'", ""));}
	('{'((qualifier+='composes' | qualifier+='derived'  |
		  qualifier+='ordered'  | qualifier+='!ordered' | qualifier+='unique' | qualifier+='!unique' |
		  qualifier+='resolve'  | qualifier+='!resolve' | qualifier+='unsettable' | qualifier+='!unsettable' ) ','? )+
	 '}')? {Document.getInstance().setQualifiers($element, $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList()));}
	(('{' ('key' referredKeys+= unrestrictedName (',' referredKeys+= unrestrictedName)* ';')? //this only lets the attributes of the eReferenceType of this eReference // If both initial and derived constraints are present, the initial constraint is ignored.
          ((ownedAnnotations+= eAnnotation [$anno++] {$element.getEAnnotations().add($eAnnotation.element);} )*
	        (ownedDerivation= derivation {$element.getEAnnotations().add($derivation.element);} | ownedInitial= initial{$element.getEAnnotations().add($initial.element);})?
	        (ownedAnnotations+= eAnnotation [$anno++] {$element.getEAnnotations().add($eAnnotation.element);} )*)
      '}') | ';') {Document.getInstance().addNamedElement(qName.peek(), $ctx.element, $ctx, $ctx.name.start);}
	;

eOperation returns [EOperation element] locals [int anno=0]
@init {$element = eFactory.createEOperation();} @after {System.out.println(qName.peek() + " (Operation)"); qName.pop();}:
	(visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+='static')? 'operation' (ownedSignature= templateSignature)? {}
	name= unrestrictedName {qName.push(qName.peek() + "->" + $name.text ); $element.setName($name.text);}
	'(' (eParameters+= eParameter (',' eParameters+= eParameter)*)? ')' {for (EParameterContext ctx: $eParameters){$element.getEParameters().add(ctx.element);}}
	(':' eReturnType= typedRef (ownedMultiplicity= eMultiplicity[(ETypedElement) $element])? )? { }
	('throws' ownedException+= typedRef (',' ownedException+= typedRef)*)? { }
	('{'((qualifier+='ordered' | qualifier+='!ordered' | //default !ordered
		  qualifier+='unique'  | qualifier+='!unique'    //default unique
		) ','? )+
	'}')? {Document.getInstance().setQualifiers($element, $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList()));}
	(('{' (   ownedAnnotations+= eAnnotation [$anno++] {$element.getEAnnotations().add($eAnnotation.element);}
            | ownedPreconditions+= precondition {$element.getEAnnotations().add($precondition.element);}
            | ownedBodyExpression += body {$element.getEAnnotations().add($body.element);}
            | ownedPostconditions+= postcondition {$element.getEAnnotations().add($postcondition.element);}
           )*
	  '}') | ';') {Document.getInstance().addNamedElement(qName.peek(), $ctx.element, $ctx, $ctx.name.start);}
    ;

// The defaults for multiplicity lower and upper bound and for ordered and unique correspond to a single element Set
// that is [1] {unique,!ordered}
eParameter returns [EParameter element] locals [int anno=0]
@init {$element = eFactory.createEParameter();} @after {System.out.println(qName.peek() + " (Parameter)"); qName.pop();}:
    (qualifier+='nullable' | qualifier+='!nullable')? name= unrestrictedName {qName.push(qName.peek() + "::" + $name.text ); $element.setName($name.text);}
	(':' eParameterType= typedRef (ownedMultiplicity= eMultiplicity[(ETypedElement) $element])? ) { }
	('{'(( qualifier+='ordered' | qualifier+='!ordered' | qualifier+='unique' | qualifier+='!unique') ','?)+
	 '}')? {Document.getInstance().setQualifiers($element, $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList()));}
	('{' ownedAnnotations+= eAnnotation[$anno++]* {$element.getEAnnotations().add($eAnnotation.element);}
	 '}')? {Document.getInstance().addNamedElement(qName.peek(), $ctx.element, $ctx, $ctx.name.start);}
	;

eMultiplicity [ETypedElement element] locals[int l=0, int u=1]
@after{$element.setLowerBound($l); $element.setUpperBound($u);}:
	'[' (lowerBound= lower ('..' upperBound= upper)? | stringBound= ('*'|'+'|'?') ) ('|?' | isNullFree= '|1')? ']'
	{
	if ($ctx.stringBound != null) {
	    switch ($ctx.stringBound.getText()) {
            case "*": $l = 0; $u = -1; break;
            case "+": $l = 1; $u = -1; break;
            case "?": $l = 0; $u =  1; break;
            default: break;
        }
    } else {
        $l = Integer.valueOf($lowerBound.text);
        if ($ctx.upperBound != null) {
            $u = Integer.valueOf($upperBound.text);
        } else { $u = $l;}
    }
	}
	;

// primitive types cannot be qualified by a nullable keyword, only reference types can be nullable.
eDataType returns [EDataType element] locals [int anno=0]
@init {$element = eFactory.createEDataType();} @after {System.out.println(Console.GREEN + qName.peek() + " (Datatype)" + Console.RESET); qName.pop();}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+= 'primitive'  | (qualifier+='nullable' | qualifier+='!nullable') )?
    'datatype' name= unrestrictedName {qName.push(qName.peek() + "." + $name.text ); $element.setName($name.text);}
    (ownedSignature= templateSignature)? { }
    (':' instanceClassName= SINGLE_QUOTED_STRING)? {if($instanceClassName != null) $element.setInstanceClassName($instanceClassName.getText().replace("'", ""));}
    ('{' (qualifier+= 'serializable' | qualifier+= '!serializable')?
     '}')? {Document.getInstance().setQualifiers($element, $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList()));}
    (('{' (   ownedAnnotations+= eAnnotation [$anno++] {$element.getEAnnotations().add($eAnnotation.element);}
            | ownedConstraints+= invariant {$element.getEAnnotations().add($invariant.element);}
          )*
      '}')  | ';') {Document.getInstance().addNamedElement(qName.peek(), $ctx.element, $ctx, $ctx.name.start);}
    ;

// primitive types cannot be qualified by a nullable keyword, only reference types can be nullable.
ePrimitiveType:
      'Boolean'          //EBoolean
    | 'Integer'          //EInt
    | 'String'           //EString
    | 'Real'             //EBigDecimal
    | 'UnlimitedNatural' //EBigInteger
    ;

eEnum returns [EEnum element] locals [int anno=0]
@init {$element = eFactory.createEEnum();} @after {System.out.println(Console.GREEN + qName.peek() + " (Enum)" + Console.RESET); qName.pop();}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    'enum' name= unrestrictedName {qName.push(qName.peek() + "." + $name.text ); $element.setName($name.text);}
    (ownedSignature= templateSignature)? {}
    (':' instanceClassName= SINGLE_QUOTED_STRING)? {if($instanceClassName != null) $element.setInstanceClassName($instanceClassName.getText().replace("'", ""));}
    ('{' (qualifier+='serializable' | qualifier+='!serializable')?
     '}')? {Document.getInstance().setQualifiers($element, $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList()));}
    (('{' (   ownedAnnotations+=eAnnotation [$anno++] {$element.getEAnnotations().add($eAnnotation.element);}
            | ownedLiteral+= eEnumLiteral {$element.getELiterals().add($eEnumLiteral.element);}
            | ownedConstraint+= invariant {$element.getEAnnotations().add($invariant.element);}
          )*
      '}') | ';') {Document.getInstance().addNamedElement(qName.peek(), $ctx.element, $ctx, $ctx.name.start);}
    ;

eEnumLiteral returns [EEnumLiteral element] locals [int anno=0]
@init {$element = eFactory.createEEnumLiteral();} @after {System.out.println(qName.peek() + " (EnumLiteral)"); qName.pop();}:
	(('literal' name= unrestrictedName) | name= unrestrictedName) {qName.push(qName.peek() + "::" + $name.text ); $element.setName($name.text);}
	('=' value= signed)? { }
	((  '{' ownedAnnotations+= eAnnotation [$anno++] * {$element.getEAnnotations().add($eAnnotation.element);}
	    '}') |';') {Document.getInstance().addNamedElement(qName.peek(), $ctx.element, $ctx, $ctx.name.start);}
    ;


eAnnotation[int anno] returns [EAnnotation element] locals [int local=0]
@init {$element = eFactory.createEAnnotation();} @after {System.out.println(Console.YELLOW + qName.peek() + " (Annotation)" + Console.RESET); qName.pop();}:
	'annotation' (source= SINGLE_QUOTED_STRING)? {qName.push(qName.peek() + "@annotation" + $anno ); $element.setSource($source != null ? $source.getText().replace("'", "") : null);}
	('(' ownedDetails+=eDetail (',' ownedDetails+=eDetail)* ')')? {for (EDetailContext ctx: $ownedDetails) $element.getDetails().put(ctx.k, ctx.v);}
	(('{' (   ownedAnnotations+= eAnnotation[$local++] {$element.getEAnnotations().add($eAnnotation.element);}
	        | ownedContents+= eModelElement {$element.getContents().add($eModelElement.element);}
	        | ownedReferences+= eModelElementRef {}
	      )+
	  '}') |';') {Document.getInstance().addModelElement(qName.peek(), $ctx.element, $ctx);}
    ;

eDetail returns [String k, String v]:
	key= SINGLE_QUOTED_STRING? '=' value= (SINGLE_QUOTED_STRING|ML_SINGLE_QUOTED_STRING)?
	{$k = $key != null ? $key.getText().replace("'", "") : null; $v = $value != null ? $value.getText().replace("'", "") : null; }
    ;

eModelElement returns [EModelElement element] locals [int anno=0]:
      eAnnotation [$anno++]{$element= $eAnnotation.element;}
    | eNamedElement {$element= $eNamedElement.element;}
    ;

eNamedElement returns [ENamedElement element]:
      eTypedElement {$element= $eTypedElement.element;}
    | eClassifier {$element= $eClassifier.element;}
    | ePackage {$element= $ePackage.element;}
    | eEnumLiteral {$element= $eEnumLiteral.element;}
    ;

eTypedElement returns [ETypedElement element]:
      eOperation {$element= $eOperation.element;}
    | eParameter {$element= $eParameter.element;}
    | eStructuralFeature {$element= $eStructuralFeature.element;}
    ;

eModelElementRef:
    'reference' ownedPathName= pathName ';'
    ;

// ETypeParameter
templateSignature:
    '<' ownedTypeParameters+= eTypeParameter (',' ownedTypeParameters+= eTypeParameter)* '>'
    ;

eTypeParameter returns [ETypeParameter element]:
	name= unrestrictedName
	('extends' ownedExtends+= typedRef ('&' ownedExtends+= typedRef)*)?
    ;

typeRef:
	typedRef | wildcardTypeRef
    ;

typedRef:
	ePrimitiveType | typedTypeRef
;

typedTypeRef:
	ownedPathName= pathName ('<' ownedBinding= templateBinding '>')?
    ;

wildcardTypeRef:
	'?' (('extends' | 'super') ownedExtends= typedRef)?
    ;

templateBinding:
	ownedSubstitutions+= templateParameterSubstitution (',' ownedSubstitutions+= templateParameterSubstitution)*
    ;

templateParameterSubstitution:
	ownedActualParameter= typeRef
    ;

pathName:
	ownedPathElements+= unrestrictedName ('::' ownedPathElements+= unrestrictedName)*
	;

body returns [EAnnotation element]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.BODY);}:
    'body' name= identifier? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); }
    ((':' ownedExpression= expression? ';') | ';') {if($ctx.ownedExpression!=null) $element.getDetails().put("expression", getContextText($ctx.expression())); }
    ;

// Class-level invariants are conditions that must be true on entry and exit of every method in a class.
invariant returns [EAnnotation element]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.INVARIANT);}:
    (isCallable= 'callable')? {$element.getDetails().put("callable", $isCallable != null ? "true" : "false");}
    'invariant' (name= identifier ('(' message= DOUBLE_QUOTED_STRING ')')? )? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); if($message!=null) $element.getDetails().put("message", $message.text.replace("\"", ""));}
	((':' ownedSpecification= formula? ';') | ';') {if($ctx.ownedSpecification!=null) $element.getDetails().put("formula", getContextText($ctx.formula())); }
    ;

// A precondition is a condition that must be satisfied before calling a method
precondition returns [EAnnotation element]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.PRECONDITION);}:
	('precondition' | 'requires') (name= identifier ('(' message= DOUBLE_QUOTED_STRING ')')? )? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); if($message!=null) $element.getDetails().put("message", $message.text.replace("\"", ""));}
	((':' ownedSpecification= formula? ';') | ';') {if($ctx.ownedSpecification!=null) $element.getDetails().put("formula", getContextText($ctx.formula())); }
    ;

// The postcondition of a method specifies the responsibilities of the method; that is, when the
// method returns, the postcondition should be true
postcondition returns [EAnnotation element]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.POSTCONDITION);}:
	('postcondition' | 'ensures') (name= identifier ('(' message= DOUBLE_QUOTED_STRING ')')? )? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); if($message!=null) $element.getDetails().put("message", $message.text.replace("\"", ""));}
	((':' ownedSpecification= formula? ';') | ';') {if($ctx.ownedSpecification!=null) $element.getDetails().put("formula", getContextText($ctx.formula())); }
    ;

initial returns [EAnnotation element]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.INITIAL);}:
    'initial' name= identifier? {if($ctx.name!=null) $element.getDetails().put("name", $name.text);}
    ((':' ownedExpression= expression? ';') | ';') {if($ctx.ownedExpression!=null) $element.getDetails().put("expression", getContextText($ctx.expression())); }
    ;

derivation returns [EAnnotation element]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.DERIVATION);}:
    'derivation' name= identifier? {if($ctx.name!=null) $element.getDetails().put("name", $name.text);}
    ((':' ownedExpression= expression? ';') | ';') {if($ctx.ownedExpression!=null) $element.getDetails().put("expression", getContextText($ctx.expression())); }
    ;

//Package-private is default as in Java
visibilityKind returns [EAnnotation element]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.VISIBILITY);}:
    (qualifier= 'public' | qualifier= 'protected'| qualifier= 'private') {$element.getDetails().put("visibility", $qualifier.text);}
    ;

atom: id=IDENTIFIER {
    if (context != null && !context.isEmpty() && !context.equals("universe")) {
        //System.out.print("atom found: " + $id.text + "-> ");
        if ( atoms.contains($id.text) ) {
            //System.out.println("defined");
        } else {
            notifyErrorListeners($ctx.getStart(), "undefined atom found: '" + $id.text + "'", (RecognitionException)null);
        }
    }
} | INT ;

arity: INT; //positive integer

/*
All binary operators associate to the left, with the exception of implication, which associates to the right.
So, for example, p => q => r is parsed as p => (q => r), and a.b.c is parsed as (a.b).c.
*/

//Decls, Expression, Formula, IntExpression: kodkod.ast.Node
formula locals[int var = 0;]:
      'no'   expression                                                                                 #no             //Formula f = expr.no()   --Returns the formula 'no expr'.
    | 'lone' expression                                                                                 #lone           //Formula f = expr.lone() --Returns the formula 'lone expr'.
    | 'one'  expression                                                                                 #one            //Formula f = expr.one()  --Returns the formula 'one expr'.
    | 'some' expression                                                                                 #some           //Formula f = expr.some() --Returns the formula 'some expr'.

    //Set Operators: These operators can be applied to any pair of relations so long as they have the same arity.
    | left=expression not=('!' | 'not')? 'in' right=expression                                          #in             //Formula f = left.in(right) --Returns the formula 'left in right' (subset).
    | left=expression not=('!' | 'not')? '='  right=expression                                          #equal          //Formula f = left.eq(right) --Returns the formula 'left = right' (equal).

    //Integer Comparison Operators
    | ileft=intexpression not=('!' | 'not')? '='  iright=intexpression                                  #eq             //Formula f= left.eq(right) --Returns a formula stating that the given int expression and left have the same value.
    | ileft=intexpression not=('!' | 'not')? '<'  iright=intexpression                                  #lt             //Formula f= left.lt(right) --Returns a formula stating that the value of this int expression is less than the value of the given int expression.
    | ileft=intexpression not=('!' | 'not')? '<=' iright=intexpression                                  #lte            //Formula f= left.lte(right)--Returns a formula stating that the value of this int expression is less than or equal to the value of the given int expression.
    | ileft=intexpression not=('!' | 'not')? '>'  iright=intexpression                                  #gt             //Formula f= left.qt(right) --Returns a formula stating that the value of this int expression is greater than the value of the given int expression.
    | ileft=intexpression not=('!' | 'not')? '>=' iright=intexpression                                  #gte            //Formula f= left.qte(right)--Returns a formula stating that the value of this int expression is greater than or equal to the value of the given int expression

    | {$formula::var = 0;}('sum' decls '|' intexpression)
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #sumDeclaration //IntExpression iexpr = sum(Decls decls);

    | 'acyclic' '[' relationId ']'                                                                      #acyclic        //
    | 'function' '[' rel=relationId ':' domain=expression '->' op=('one' | 'lone') range=expression ']' #function       //Relation rel; Formula f = rel.function(domain, range); Formula f = rel.partialFunction(domain, range); --Returns a formula stating that this relation is a total function or partial function with the specified domain and range.
    | 'ord' '[' rel=relationId ',' ordered=relationId ',' first=relationId ',' last=relationId ']'      #totalOrder     //Relation rel; Formula f = rel.totalOrder(Relation ordered, Relation first, Relation last) --Returns a formula stating that this relation imposes a total ordering over the atoms in the set ordered, and that thet first and last elements in the ordering are given by the relations first and last.

    //Logical Operators
    //NotFormula
    | op=('!' | 'not') formula                                                                          #not            //Formula f = formula.not() --Returns the negation of this formula.

    //BinaryFormula (AND, IFF, IMPLIES, OR)
    | <assoc=right> fleft=formula op=('&&' | 'and' ) fright=formula                                     #and            //Formula f = left.and(right)     --Returns the conjunction of left and the specified formula.
    | <assoc=right> fleft=formula op=('||' | 'or'  ) fright=formula                                     #or             //Formula f = left.or(right)      --Returns the disjunction of left and the specified formula. x => y is true if (and only if) either y is true or x is false
    | <assoc=right> fleft=formula op=('=>' | 'if'  ) fright=formula                                     #implies        //Formula f = left.implies(right) --Returns the implication of the specified formula by left.
    | <assoc=right> fleft=formula op=('<=>' | 'iff') fright=formula                                     #iff            //Formula f = left.iff(right)     --Returns a formula that equates left and the specified formula.

    | {$formula::var = 0;}('all'  decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forAll         //Formula f = formula.forAll(decls)  --Returns a formula that represents a universal quantification of this formula over the given declarations
    | {$formula::var = 0;}('some' decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forSome        //Formula f = formula.forSome(decls) --Returns a formula that represents an existential quantification of this formula over the given declarations.
    | {$formula::var = 0;}('no'   decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forNo          //no x: e | F is true when F is true for no bindings of the variable x.
    | {$formula::var = 0;}('one'  decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forOne         //one x: e | F is true when F is true for exactly one binding of the variable x. (unique existential quantification)
    | {$formula::var = 0;}('lone' decls  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #forLone        //lone x: e | F is true when F is true for at most one binding of the variable x.

    | {$formula::var = 0;}('let' letDecls ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #let

    //Constant Formulas
    | 'true'                                                                                            #true           //Formula f = Formula.FALSE --Constant formula false
    | 'false'                                                                                           #false          //Formula f  = Formula.TRUE --Constant formula true

    | '(' formula ')'                                                                                   #f_paranthesis
    ;


/*
**For the set theoretic operations (union, difference, and intersection) and for relational override,
the arguments are required to have the same arity.
*/
expression:
    // Relational Operators
    // **These expressions are required to be binary
      '~' expression                                                                                    #transpose      //Expression: expr.transpose() --Returns the transpose of expr.
    | '^' expression                                                                                    #closure        //Expression: expr.closure() --Returns the transitive closure of expr.
    | '*' expression                                                                                    #reflexive      //Expression: expr.reflexiveClosure()--Returns the reflexive transitive closure of expr.

    // Set theoretic operations:
    // **These operators can be applied to any pair of relations so long as they have the same arity.
    | left=expression '+' right=expression                                                              #union          //Expression: left.union(right) --Returns the union of left and the specified expression.
    | left=expression '&' right=expression                                                              #intersection   //Expression: left.intersection(right) --Returns the intersection of left and the specified expression.
    | left=expression '-' right=expression                                                              #difference     //Expression: left.difference(right) --Returns the difference of left and the specified expression.

    //Relational Operators
    | <assoc=left> left=expression '.' right=expression                                                 #join           //Expression expr = left.join(right) --Returns the join of left and the specified expression.
    | <assoc=left> right=expression '[' left=expression ']'                                             #boxjoin        //Expression expr = left.join(right) --e1[e2] = e2.e1 --
    | <assoc=right> left=expression leftMult=('set' | 'one' | 'lone' | 'some')? '->' rightMult=('set' | 'one' | 'lone' | 'some')? right=expression  #product        //Expression expr = left.product(right) --Returns the product of left and the specified expression
    | left=expression '++' right=expression                                                             #override       //Expression expr = left.override(right) --Returns the relational override of left with the specified expression.

    //A comprehension expression, e.g. { a: A, b: B | a.r = b }
    //Comprehensions make relations from properties
    //{x1: e1, x2: e2, … | F} The relation obtained by taking all tuples x1 -> x2 -> …
    // in which x1 is drawn from the set e1, x2 is drawn from the set e2, and so on,
    // and for which the constraint F holds. The expressions e1, e2, and so on, must be unary,
    // and may not be prefixed by (or contain) multiplicity keywords
    //all d: decls.decls[int] | decl.variable.arity = 1 and decl.multiplicity = ONE
    | {$formula::var = 0;}('{' comprehensionDecls '|' formula '}')
      {for (int i = 0; i < $formula::var; i++) declarations.pop();}                                     #comprehension  //Expression f = formula.comprehension(Decls decls) //Returns the comprehension expression constructed from this formula and the given declarations.

    | op=('=>' | 'if') condition=formula 'then' thenExpr=expression 'else' elseExpr=expression          #ifExpression

    //Constants
    | 'iden'                                                                                            #iden           //Expression expr = Expression.IDEN --The identity relation: maps all atoms in a universe of discourse to themselves.
    | 'none'                                                                                            #none           //Expression expr = Expression.NONE --The empty relation: contains no atoms.
    | 'univ'                                                                                            #univ           //Expression expr = Expression.UNIV --The universal relation: contains all atoms in a universe of discourse.
    | 'ints'                                                                                            #ints           //Expression expr = Expression.INTS --The integer relation: contains all atoms bound to integers

    | '(' expression ')'                                                                                #e_paranthesis

    | {!isRelation()}? variableId {
        //System.out.print("variable found: " + $variableId.text + "-> ");
        String s = $variableId.text;
        if ( declarations.contains(s) ) {
            //System.out.println("defined");
        } else {
            notifyErrorListeners($ctx.getStart(), "undefined variable found: '"+ s + "'", (RecognitionException)null);
        }
      }                                                                                                 #var            //ConstantExpression, Relation, Variable
    | {isRelation()}? relationId                                                                        #rel
    ;

intexpression:
      op=('=>' | 'if') condition=formula 'then' thenExpr=intexpression 'else' elseExpr=intexpression    #ifIntExpression
    | 'sum' expression                                                                                  #sum            //IntExpression iexpr = exp.sum();            --Returns the sum of the integer atoms in this expression.
    | '#'   expression                                                                                  #count          //IntExpression iexpr = exp.count();          --Returns the cardinality(the number of elements in the set) of this expression
    | <assoc=left> ileft=intexpression ('+' | 'plus')   iright=intexpression                            #plus           //IntExpression iexpr = this.plus(intExpr);   --Returns an IntExpression that represents the sum of this and the given int node
    | <assoc=left> ileft=intexpression ('-' | 'minus')  iright=intexpression                            #minus          //IntExpression iexpr = this.minus(intExpr);  --Returns an IntExpression that represents the difference between this and the given int node.
    | <assoc=left> ileft=intexpression ('*' | 'mul')    iright=intexpression                            #multiply       //IntExpression iexpr = this.minus(intExpr);  --Returns an IntExpression that represents the product of this and the given int node.
    | <assoc=left> ileft=intexpression ('/' | 'div')    iright=intexpression                            #divide         //IntExpression iexpr = this.divide(intExpr); --Returns an IntExpression that represents the quotient of the division between this and the given int node.
    | <assoc=left> ileft=intexpression ('%' | 'modulo') iright=intexpression                            #modulo         //IntExpression iexpr = this.modulo(intExpr); --Returns an IntExpression that represents the remainder of the division between this and the given int node.
    | sign='-'? integer                                                                                 #intConstant
    | '(' intexpression ')'                                                                             #i_paranthesis
    ;

//A variable declaration, such as 'x : lone X'. Declarations are used with quantified formulas and comprehension expressions.
decls: decl (',' decl)*;

decl: disj='disj'? vars+=variableId (',' vars+=variableId)* ':' 'one'? expression
      {$formula::var = declareVariables($vars, $formula::var);}                                         #oneOf          //Decl d = var.oneOf(expression)
    | disj='disj'? vars+=variableId (',' vars+=variableId)* ':' 'lone' expression
      {$formula::var = declareVariables($vars, $formula::var);}                                         #loneOf         //Decl d = var.loneOf(expression)
    | disj='disj'? vars+=variableId (',' vars+=variableId)* ':' 'some' expression
      {$formula::var = declareVariables($vars, $formula::var);}                                         #someOf         //Decl d = var.someOf(expression)
    | disj='disj'? vars+=variableId (',' vars+=variableId)* ':' 'set'  expression
      {$formula::var = declareVariables($vars, $formula::var);}                                         #setOf          //Decl d = var.setOf(expression)
    ;

letDecls: letDecl (',' letDecl)*;

letDecl: (vars+=variableId (',' vars+=variableId)* '=' expression)
      {$formula::var = declareVariables($vars, $formula::var);} ;

comprehensionDecls: comprehensionDecl (',' comprehensionDecl)*;

comprehensionDecl:  disj='disj'? (vars+=variableId (',' vars+=variableId)* ':' 'one'? expression)
      {$formula::var = declareVariables($vars, $formula::var);} ;

relationId: unrestrictedName;
variableId: unrestrictedName;
integer: INT;

unrestrictedName:
    	'abstract'
    |	'attribute'
    |	'body'
    |	'callable'
    |	'class'
    |	'composes'
    |	'datatype'
    |	'definition'
    |	'derivation'
    |	'derived'
    |	'enum'
    |   'ensure'
    |	'extends'
    |	'id'
    |	'import'
    |	'initial'
    |	'interface'
    |	'key'
    |	'module'
    |	'operation'
    |	'ordered'
    |	'package'
    |	'postcondition'
    |	'precondition'
    |	'primitive'
    |	'property'
    |	'readonly'
    |	'reference'
    |   'require'
    |	'resolve'
    |	'static'
    |	'throws'
    |	'transient'
    |	'unique'
    |	'unsettable'
    |	'volatile'
    |	'invariant'
    |	'literal'
    |	'serializable'
    |	'annotation'
    |	'model'
    |   identifier
;

//qualifiedName: firstPart= identifier ( ('.' midParts+= identifier)* ('.' classifier= identifier | '::' structuralFeature= identifier | '->' operation= identifier) )?;
identifier: IDENTIFIER;
upper: INT | '*';
lower: INT;
signed: '-'? INT;



INT :   DIGIT+ ;
IDENTIFIER : (UNDERSCORE | LETTER) (LETTER | APOSTROPHE | DIGIT | UNDERSCORE | DOLLAR)* ;
DOUBLE_QUOTED_STRING: '"' ( ESCAPED_CHARACTER | ~('\\' | '"' ) )* '"'  ;
SINGLE_QUOTED_STRING: '\'' ( ESCAPED_CHARACTER | ~('\'' | '\\') )* '\'' ;
fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment ESCAPED_CHARACTER: '\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | '\'' | '\\');
fragment UNDERSCORE: '_';
fragment APOSTROPHE: '\'';
fragment DOLLAR: '$';
ML_SINGLE_QUOTED_STRING : '\'' .*? '\'' -> skip;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;
SINGLELINE_COMMENT : '--' .*? '\r'? '\n' -> skip;
WS: [ \r\n]+ -> skip ; // toss out whitespace
// \t checkout toss out this character
