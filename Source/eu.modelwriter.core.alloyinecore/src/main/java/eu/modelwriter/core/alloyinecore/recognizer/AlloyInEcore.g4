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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
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

import eu.modelwriter.core.alloyinecore.structure.Document;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.structure.ModelElement;
import eu.modelwriter.core.alloyinecore.structure.Annotation;
import eu.modelwriter.core.alloyinecore.structure.AnnotationDetail;
import eu.modelwriter.core.alloyinecore.structure.NamedElement;
import eu.modelwriter.core.alloyinecore.structure.Module;
import eu.modelwriter.core.alloyinecore.structure.Import;
import eu.modelwriter.core.alloyinecore.structure.EcoreImport;
import eu.modelwriter.core.alloyinecore.structure.Package;
import eu.modelwriter.core.alloyinecore.structure.Classifier;
import eu.modelwriter.core.alloyinecore.structure.Class;
import eu.modelwriter.core.alloyinecore.structure.Interface;
import eu.modelwriter.core.alloyinecore.structure.DataType;
import eu.modelwriter.core.alloyinecore.structure.Enum;
import eu.modelwriter.core.alloyinecore.structure.EnumLiteral;
import eu.modelwriter.core.alloyinecore.structure.StructuralFeature;
import eu.modelwriter.core.alloyinecore.structure.Multiplicity;
import eu.modelwriter.core.alloyinecore.structure.Reference;
import eu.modelwriter.core.alloyinecore.structure.Attribute;
import eu.modelwriter.core.alloyinecore.structure.Operation;
import eu.modelwriter.core.alloyinecore.structure.Parameter;
import eu.modelwriter.core.alloyinecore.structure.Exception;
import eu.modelwriter.core.alloyinecore.structure.TypeParameter;
import eu.modelwriter.core.alloyinecore.structure.GenericType;
import eu.modelwriter.core.alloyinecore.structure.WildCardType;
import eu.modelwriter.core.alloyinecore.structure.Invariant;
import eu.modelwriter.core.alloyinecore.structure.Derivation;
import eu.modelwriter.core.alloyinecore.structure.Body;
import eu.modelwriter.core.alloyinecore.structure.PostCondition;
import eu.modelwriter.core.alloyinecore.structure.PreCondition;
import eu.modelwriter.core.alloyinecore.structure.Initial;

import eu.modelwriter.core.alloyinecore.ModelIO;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import java.io.IOException;
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
    module.printTree();
}

private String getContextText(ParserRuleContext ctx){
    return getTokenStream().getTokenSource().getInputStream().toString().substring(ctx.start.getStartIndex(),ctx.stop.getStopIndex());
}

public AlloyInEcoreParser(TokenStream input, String filename, String path){
    this(input);
    this.fileName = filename;
    this.pathName = path;
}

private String fileName;
private String pathName;

public Module module;

Document document = new Document(this);

private EcoreFactory eFactory = EcoreFactory.eINSTANCE;

private void signalParsingCompletion() {

}

private void createEAnnotation(EModelElement owner, final String source) {
    if (owner.getEAnnotation(source) != null)
        return;
    final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
    eAnnotation.setSource(source);
    owner.getEAnnotations().add(eAnnotation);
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

/*http://help.eclipse.org/neon/topic/org.eclipse.ocl.doc/help/OCLinEcore.html*/
/*optional module declaration*/
module locals[EAnnotation element]
@init {module = new Module($ctx); $element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.MODULE);}
@after{signalParsingCompletion(); saveResource($ownedPackage.element);}:
    options? {}
    ('module' name= identifier ';')? {$element.getDetails().put("name", $name.text);}
    (ownedPackageImport+= packageImport[module] )*
    (ownedPackage= ePackage[module] {$ePackage.element.getEAnnotations().add($element);} )
    {for(PackageImportContext ctx: $ctx.ownedPackageImport) {$ePackage.element.getEAnnotations().add(ctx.element);}}
    ;

/*Zero or more external metamodels may be imported.*/
packageImport[Module owner] returns [EAnnotation element] locals [EObject object]
@init{$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.IMPORT);}
@after{
if ($ownedPathName != null) {
    if ($ownedPathName.getText().replace("'", "").equals(EcorePackage.eNS_URI)) {
        $object = EcorePackage.eINSTANCE;
        $owner.addOwnedElement(new Import((EPackage)$object, $ctx));
    } else {
        try {$object = ModelIO.getRootObject($ownedPathName.getText().replace("'", ""));}
        catch (final IOException e) { }
        if ($object == null) notifyErrorListeners($ownedPathName, "Import could not be resolved!", null);
        else if ($object instanceof EPackage) $owner.addOwnedElement(new Import((EPackage)$object, $ctx));
        else notifyErrorListeners($ownedPathName, "Import could not be resolved to a EPackage!", null);
    }
}
}:
    ('import') (name= identifier ':')? ownedPathName= SINGLE_QUOTED_STRING ';'
    {$element.getDetails().put($name.text, $ownedPathName != null ? $ownedPathName.getText().replace("'", "") : null);}
    ;

ePackage[Element owner] returns [EPackage element] locals [Package current]
@init {$element = eFactory.createEPackage();}
@after{owner.addOwnedElement($current);}:
    (visibility= visibilityKind)? {if($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    'package' name= unrestrictedName
    {$element.setName($name.text);} {$current = new Package($element, $ctx);}
    (':' nsPrefix= identifier) ('=' nsURI= SINGLE_QUOTED_STRING)  {$element.setNsPrefix($nsPrefix.text); if($nsURI != null) $element.setNsURI($nsURI.getText().replace("'", ""));}
    (('{' (   ownedAnnotations+=eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);}
            | eSubPackages+= ePackage[$current] {$element.getESubpackages().add($ePackage.element);}
            | eClassifiers+= eClassifier[$current] {if ($eClassifier.element != null) $element.getEClassifiers().add($eClassifier.element);}
            | eConstraints+= invariant[$current] {$element.getEAnnotations().add($invariant.element);}
          )*
      '}') | ';')
    ;

eClassifier[Element owner] returns [EClassifier element]:
      eClass[$owner] {$element= $eClass.element;}
    | eDataType[$owner] {$element= $eDataType.element;}
    | eEnum[$owner] {$element= $eEnum.element;}
    ;

/* Once interface is true, abstract is also implicitly true. Interface with abstract modifier is redundant.*/
eClass[Element owner] returns [EClass element] locals [Class current]
@init {$element = eFactory.createEClass();}
@after{owner.addOwnedElement($current);}:
    (visibility= visibilityKind)? {if($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (isAbstract= 'abstract'? isClass='class' | isInterface= 'interface') {$element.setAbstract($isAbstract!=null); if ($isInterface!=null) {$element.setInterface(true);$element.setAbstract(true);}}
    name= unrestrictedName?
    {if ($ctx.name == null) {notifyErrorListeners("missing Class name");} else {$element.setName($name.text);}}
    {if ($isInterface!=null) $current = new Interface($element, $ctx); else $current = new Class($element, $ctx);}
    (ownedSignature= templateSignature[$current])? {if($ctx.templateSignature != null) $element.getETypeParameters().addAll($templateSignature.typeParameters);}
    ('extends' eSuperTypes+= eGenericTypeRef[$current] (',' eSuperTypes+= eGenericTypeRef[$current])*)? {}
    (':' instanceClassName= SINGLE_QUOTED_STRING)? {if($instanceClassName != null) $element.setInstanceClassName($instanceClassName.getText().replace("'", ""));}
    (('{' (   ownedAnnotations+= eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);}
            | eOperations+= eOperation[$current] {$element.getEOperations().add($eOperation.element);}
            | eStructuralFeatures+= eStructuralFeature[$current] {if ($eStructuralFeature.element != null) $element.getEStructuralFeatures().add($eStructuralFeature.element);}
            | eConstraints+= invariant[$current] {$element.getEAnnotations().add($invariant.element);}
          )*
      '}') | ';')
    ;

/* A StructuralFeature may be an Attribute or a Reference */
eStructuralFeature[Element owner] returns [EStructuralFeature element]:
      eAttribute[$owner] {$element= $eAttribute.element;}
    | eReference[$owner] {$element= $eReference.element;}
    ;

/*
 OCL and UML support four permutations of ordered/not-ordered, unique/not-unique to give useful Collection behaviors.
 A Parameter may have a variety of qualifiers:
 ordered specifies that the returned elements are ordered (default !ordered)
 unique specifies that there are no duplicate returned elements (default unique)

 The defaults for multiplicity lower and upper bound and for ordered and unique follow the UML specification and so
 corresponds to a single element Set that is [1] {unique,!ordered}. Note that UML defaults differ from the Ecore
 defaults which correspond to an optional element OrderedSet, that is [?] {ordered,unique}.

 An Attribute may a simple initializer and a variety of qualifiers:
  derived specifies a derived attribute (default !derived)
  id specifies that the attribute provides the identifier if its class (default !id)
  ordered specifies that the attribute elements are ordered (default !ordered)
  readonly specifies that the attribute elements are readonly (not changeable) (default !readonly)
  transient specifies that the attribute elements are computed on the fly (default !transient)
  unique specifies that there are no duplicate attribute elements (default unique)
  unsettable specifies that attribute element may have no value (default !unsettable)
  volatile specifies that the attribute elements are not persisted (default !volatile)
*/

/*
 The defaults for multiplicity lower and upper bound and for ordered and unique correspond to a single element Set
 that is [1] {unique,!ordered}

 __Object Declarations__
 mandatoryName : aDataType     --[1] indicates that a DataType value is required; a null value is prohibited. (default)
 mandatoryName : aDataType[1]  --[1] indicates that a DataType value is required; a null value is prohibited.
 __Collection Declarations__
 optionalName : aDataType[?]   --[?] indicates that a DataType value is optional; a null value is permitted. {nullable}
 optionalName : aDataType[*]   --[*] represents an array of dataytype such as String[] or Boolean[]. {!nullable}
 optionalName : aDataType[+]   --[+] represents an array of dataytype such as String[] or Boolean[]. {!nullable}
*/
eAttribute[Element owner] returns [EAttribute element] locals [Attribute current]
@init {$element = eFactory.createEAttribute();}
@after{owner.addOwnedElement($current);}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+='static')?
    (qualifier+='model' | qualifier+='ghost')?
    (qualifier+='transient')?
    (qualifier+='volatile')?
    (qualifier+='nullable' | qualifier+='!nullable')?
    (qualifier+='readonly')?
	'attribute' name= unrestrictedName
	{$element.setName($name.text);}
	{$current = new Attribute($element, $ctx);}
	':' eAttributeType= eTypeRef[$current] (ownedMultiplicity= eMultiplicity[$current, (ETypedElement)$element])? {if($ctx.ownedMultiplicity == null) {$element.setLowerBound(1);} }
	('=' defaultValue= SINGLE_QUOTED_STRING )? {if($defaultValue != null) $element.setDefaultValueLiteral($defaultValue.getText().replace("'", ""));}
	('{'((qualifier+='derived' | qualifier+='id' |
		  qualifier+='ordered' | qualifier+='!ordered' | qualifier+='unique'  | qualifier+='!unique'  |
		  qualifier+='unsettable' | qualifier+='!unsettable') ','? )+
	 '}')?
   (('{'( (ownedAnnotations+= eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);} )*
	      (ownedDerivation= derivation[$current] {$element.getEAnnotations().add($derivation.element);} | ownedInitial= initial[$current] {$element.getEAnnotations().add($initial.element);})?
	      (ownedAnnotations+= eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);} )* )
     '}') | ';')
    {for(String s: $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
        switch (s) {
            case "static":     createEAnnotation($element, AnnotationSources.STATIC); break;
            case "model":      createEAnnotation($element, AnnotationSources.MODEL); break;
            case "ghost":      createEAnnotation($element, AnnotationSources.GHOST); break;
            case "transient":  $element.setTransient(true); break;
            case "volatile":   $element.setVolatile(true); break;
            case "nullable":   int u = $element.getUpperBound(); if (u > 1 || u == -1) createEAnnotation($element, AnnotationSources.NULLABLE); break;
            case "readonly":   $element.setChangeable(false); break;
            case "derived":    $element.setDerived(true); break;
            case "ordered":    u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setOrdered(true); break;
            case "!unique":    u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setUnique(false); break;
            case "unsettable": $element.setUnsettable(true); break;
            case "id":         $element.setID(true); break;}}
    };

/*
 The defaults for multiplicity lower and upper bound and for ordered and unique correspond to a single element Set
 that is [1] {unique,!ordered}.

 We can declare that a collection is null-free; i.e. that it contains no null element, which is also the default way.
 All collections are null-free unless explicitly declared to be nullable.
 !Nullable specifies a collection of null-free collection declaration. (default {!nullable})
 A reference (field) whose type in an array of reference types such as Object[], both
 the field (i.e. [1..*]) that refers to the array and the elements of the array are non-null {!nullable} by default

 __Object Declarations__
 mandatoryRefName : eClassifier                --[1..1] indicates that a classifier reference is required; a null value is prohibited. (default)
 mandatoryRefName : eClassifier[1]             --[1..1] indicates that a classifier reference is required; a null value is prohibited.
 optionalRefName : eClassifier[?]              --[0..1] indicates that a String reference is optional; a null value is permitted.
 __Collection Declarations__
 collectionRefName : eClassifier[*]            --[0..*] Reference may be null, but the elements of the array is {!nullable} which is by default.
 collectionRefName : eClassifier[*] {nullable} --[0..*] Reference may be null, and the elements of the array is {nullable}.
 collectionRefName : eClassifier[+] {nullable} --[1..*] Reference is required, and the elements of the array is {nullable}.
*/
eReference[Element owner] returns [EReference element] locals [Reference current]
@init {$element = eFactory.createEReference();}
@after{owner.addOwnedElement($current);}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+='static')?
    (qualifier+='model' | qualifier+='ghost')?
    (qualifier+='transient')?
    (qualifier+='volatile')?
    (qualifier+='nullable' | qualifier+='!nullable')?
    (qualifier+='readonly')?
	'property' name= unrestrictedName
	{$element.setName($name.text);}
	{$current = new Reference($element, $ctx);}
	('#' eOpposite= unrestrictedName)? {}
	(':' eReferenceType= eGenericTypeRef[$current] (ownedMultiplicity= eMultiplicity[$current, (ETypedElement) $element])? ) {if ($ctx.ownedMultiplicity == null) {$element.setLowerBound(1);} }
	('=' defaultValue= SINGLE_QUOTED_STRING)? {if($defaultValue != null) $element.setDefaultValueLiteral($defaultValue.getText().replace("'", ""));}
	('{'((qualifier+='composes' | qualifier+='derived'  |
		  qualifier+='ordered'  | qualifier+='!ordered' | qualifier+='unique' | qualifier+='!unique' |
		  qualifier+='resolve'  | qualifier+='!resolve' | qualifier+='unsettable' | qualifier+='!unsettable' ) ','? )+
	 '}')?
   (('{'  ('key' referredKeys+= unrestrictedName (',' referredKeys+= unrestrictedName)* ';')? //this only lets the attributes of the eReferenceType of this eReference // If both initial and derived constraints are present, the initial constraint is ignored.
        ( (ownedAnnotations+= eAnnotation [$current] {$element.getEAnnotations().add($eAnnotation.element);} )*
          (ownedDerivation= derivation[$current] {$element.getEAnnotations().add($derivation.element);} | ownedInitial= initial[$current] {$element.getEAnnotations().add($initial.element);})?
          (ownedAnnotations+= eAnnotation [$current] {$element.getEAnnotations().add($eAnnotation.element);} )* )
     '}') | ';')
    {for(String s: $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
        switch (s) {
            case "static":    createEAnnotation($element, AnnotationSources.STATIC); break;
            case "model":     createEAnnotation($element, AnnotationSources.MODEL); break;
            case "ghost":     createEAnnotation($element, AnnotationSources.GHOST); break;
            case "transient": $element.setTransient(true); break;
            case "volatile":  $element.setVolatile(true); break;
            case "nullable":  int u = $element.getUpperBound(); if (u > 1 || u == -1) createEAnnotation($element, AnnotationSources.NULLABLE); break;
            case "readonly":  $element.setChangeable(false); break;
            case "unsettable":$element.setUnsettable(true); break;
            case "derived":   $element.setDerived(true); break;
            case "ordered":   u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setOrdered(true); break;
            case "!unique":   u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setUnique(false); break;
            case "composes":  $element.setContainment(true); break;
            case "!resolve":  $element.setResolveProxies(false); break;
            default: break;}}
    };

eOperation[Element owner] returns [EOperation element] locals [Operation current]
@init {$element = eFactory.createEOperation();$current = new Operation($element, $ctx);}
@after{owner.addOwnedElement($current);}:
	(visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+='static')?
    (qualifier+='nullable' | qualifier+='!nullable')?
    'operation' (ownedSignature= templateSignature[$current])? {if($ctx.templateSignature != null) $element.getETypeParameters().addAll($templateSignature.typeParameters);}
	name= unrestrictedName
	{$element.setName($name.text);}
	('(' (eParameters+= eParameter[$current] (',' eParameters+= eParameter[$current])*)? ')') {for (EParameterContext ctx: $eParameters){$element.getEParameters().add(ctx.element);}}
	(':' eReturnType= eTypeRef[$current] (ownedMultiplicity= eMultiplicity[$current, (ETypedElement) $element])? )? {if ($ctx.ownedMultiplicity == null) {$element.setLowerBound(1);} }
	('throws' ownedException+= eException[$current] (',' ownedException+= eException[$current])*)? { }
	('{'((qualifier+='ordered' | qualifier+='!ordered' | qualifier+='unique'  | qualifier+='!unique'  ) ','? )+ '}')?
   (('{'(   ownedAnnotations+= eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);}
          | ownedPreconditions+= precondition[$current] {$element.getEAnnotations().add($precondition.element);}
          | ownedBodyExpression += body[$current] {$element.getEAnnotations().add($body.element);}
          | ownedPostconditions+= postcondition[$current] {$element.getEAnnotations().add($postcondition.element);} )*
	 '}') | ';')
    {for(String s: $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
        switch (s) {
            case "static":   createEAnnotation($element, AnnotationSources.STATIC); break;
            case "nullable": int u = $element.getUpperBound(); if (u > 1 || u == -1) createEAnnotation($element, AnnotationSources.NULLABLE); break;
            case "ordered":  u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setOrdered(true); break;
            case "!unique":  u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setUnique(false); break;}}
    }
    ;

eException [Element owner] locals [Exception current]
@init{$current = new Exception($ctx);}
@after{$owner.addOwnedElement($current);}:
    eGenericTypeRef[$current]
;
/*
 The defaults for multiplicity lower and upper bound and for ordered and unique correspond to a single element Set
 that is [1] {unique,!ordered}
*/
eParameter[Element owner] returns [EParameter element] locals [Parameter current]
@init {$element = eFactory.createEParameter();}
@after{owner.addOwnedElement($current);}:
    (qualifier+='nullable' | qualifier+='!nullable')?
    name= unrestrictedName
    {$element.setName($name.text);}
    {$current = new Parameter($element, $ctx);}
	':' eParameterType= eTypeRef[$current] (ownedMultiplicity= eMultiplicity[$current, (ETypedElement) $element])? {if ($ctx.ownedMultiplicity == null) {$element.setLowerBound(1);} }
	('{'(( qualifier+='ordered' | qualifier+='!ordered' | qualifier+='unique' | qualifier+='!unique') ','?)+ '}')?
	('{' ownedAnnotations+= eAnnotation[$current]* {$element.getEAnnotations().add($eAnnotation.element);} '}')?
    {for(String s: $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
        switch (s) {
            case "nullable": int u = $element.getUpperBound(); if (u > 1 || u == -1) createEAnnotation($element, AnnotationSources.NULLABLE); break;
            case "ordered":  u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setOrdered(true);break;
            case "!unique":  u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setUnique(false);break;}}
	};

/*
 ==MultiplicityElement==
 [?] is the default for the OCL declarations even though [1] is the default for UML declarations. We should also choose
 [1] for default multiplicity for ETypedElement's declarations.

 If a MultiplicityElement specifies a multivalued multiplicity, then an instantiation of this element has a set of values. The
 multiplicity is a constraint on the number of values that may validly occur in that set.

 If the MultiplicityElement is specified as ordered (i.e., isOrdered is true), then the set of values in an instantiation of this
 element is ordered. This ordering implies that there is a mapping from positive integers to the elements of the set of
 values. If a MultiplicityElement is not multivalued, then the value for isOrdered has no semantic effect.

 If the MultiplicityElement is specified as unique (i.e., isUnique is true), then the set of values in an instantiation of this
 element must be unique. If a MultiplicityElement is not multivalued, then the value for isUnique has no semantic effect.

 * lower: Specifies the lower bound of the multiplicity interval. Default is one.

 * upper: Specifies the upper bound of the multiplicity interval. Default is one.

 * isOrdered: For a multivalued multiplicity, this attribute specifies whether the values in an instantiation of this element are
            sequentially ordered. Default is false.
 * isUnique: For a multivalued multiplicity, this attributes specifies whether the values in an instantiation of this element
           are unique. Default is true.

 * The lower bound must be a non-negative integer literal.
  `lowerBound()->notEmpty() implies lowerBound() >= 0`

 * The upper bound must be greater than or equal to the lower bound.
  `(upperBound()->notEmpty() and lowerBound()->notEmpty()) implies upperBound() >= lowerBound()`

 * The query isCollection() checks whether this multiplicity has an upper bound greater than one.
   MultiplicityElement::isCollection() : Boolean;

*/
eMultiplicity[Element owner, ETypedElement element] locals[int l=1, int u=1]
@after{$element.setLowerBound($l); $element.setUpperBound($u); if (($u > 1 || $u == -1) && $ctx.isNullFree != null) createEAnnotation($element, AnnotationSources.NULLABLE);
$owner.addOwnedElement(new Multiplicity($ctx));}:
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
	};

/* primitive types cannot be qualified by a nullable keyword, only reference types can be nullable. */
eDataType[Element owner] returns [EDataType element] locals [DataType current]
@init {$element = eFactory.createEDataType();}
@after{owner.addOwnedElement($current);}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+= 'primitive')?
    'datatype' name= unrestrictedName
    {$element.setName($name.text);}
    {$current = new DataType($element, $ctx);}
    (ownedSignature= templateSignature[$current])? {if($ctx.templateSignature != null) $element.getETypeParameters().addAll($templateSignature.typeParameters);}
    (':' instanceClassName= SINGLE_QUOTED_STRING)? {if($instanceClassName != null) $element.setInstanceClassName($instanceClassName.getText().replace("'", ""));}
    ('{' (qualifier+= 'serializable' | qualifier+= '!serializable')? '}')?
   (('{'(   ownedAnnotations+= eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);}
          | ownedConstraints+= invariant[$current] {$element.getEAnnotations().add($invariant.element);} )*
     '}') | ';')
    {for(String s: $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
        switch (s) {
            case "primitive":     createEAnnotation($element, AnnotationSources.DATATYPE_PRIMITIVE);break;
            case "!serializable": $element.setSerializable(false); break; }}
    }
    ;

eEnum[Element owner] returns [EEnum element] locals [Enum current]
@init {$element = eFactory.createEEnum();}
@after{owner.addOwnedElement($current);}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    'enum' name= unrestrictedName {$element.setName($name.text);} {$current = new Enum($element, $ctx);}
    (ownedSignature= templateSignature[$current])? {if($ctx.templateSignature != null) $element.getETypeParameters().addAll($templateSignature.typeParameters);}
    (':' instanceClassName= SINGLE_QUOTED_STRING)? {if($instanceClassName != null) $element.setInstanceClassName($instanceClassName.getText().replace("'", ""));}
    ('{' (qualifier+='serializable' | qualifier+='!serializable')? '}')?
   (('{'(   ownedAnnotations+=eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);}
          | ownedLiteral+= eEnumLiteral[$current] {$element.getELiterals().add($eEnumLiteral.element);}
          | ownedConstraint+= invariant[$current] {$element.getEAnnotations().add($invariant.element);} )*
     '}') | ';')
    {for(String s: $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
        switch (s) {
            case "!serializable": $element.setSerializable(false); break;}}
    };

eEnumLiteral[Element owner] returns [EEnumLiteral element] locals [EnumLiteral current]
@init {$element = eFactory.createEEnumLiteral();}
@after{owner.addOwnedElement($current);}:
	(('literal' name= unrestrictedName) | name= unrestrictedName)
	{$element.setName($name.text);}
	{$current = new EnumLiteral($element, $ctx);}
	('=' value= signed)? { }
	(( '{'
	        ownedAnnotations+= eAnnotation[$current]* {$element.getEAnnotations().add($eAnnotation.element);}
	   '}') |';')
    ;

eAnnotation[Element owner] returns [EAnnotation element] locals [Annotation current]
@init {$element = eFactory.createEAnnotation();}
@after{owner.addOwnedElement($current);}:
	'annotation' (source= SINGLE_QUOTED_STRING)?
	{$element.setSource($source != null ? $source.getText().replace("'", "") : null);}
	{$current = new Annotation($element, $ctx);}
	('(' ownedDetails+=eDetail (',' ownedDetails+=eDetail)* ')')?
	{for (EDetailContext ctx: $ownedDetails) {
	    $element.getDetails().put(ctx.k, ctx.v);
	    $current.addOwnedElement(new AnnotationDetail(ctx));
	 }
	}
	(('{' (   ownedAnnotations+= eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);}
	        | ownedContents+= eModelElement[$current] {$element.getContents().add($eModelElement.element);}
	        | ownedReferences+= eModelElementRef {}
	      )+
	  '}') |';')
    ;

eDetail returns [String k, String v]:
	key= SINGLE_QUOTED_STRING? '=' value= (SINGLE_QUOTED_STRING|ML_SINGLE_QUOTED_STRING)?
	{$k = $key != null ? $key.getText().replace("'", "") : null; $v = $value != null ? $value.getText().replace("'", "") : null; }
    ;

eModelElement[Element owner] returns [EModelElement element]:
      eAnnotation [$owner]{$element= $eAnnotation.element;}
    | eNamedElement [$owner] {$element= $eNamedElement.element;}
    ;

eNamedElement[Element owner] returns [ENamedElement element] :
      eTypedElement[$owner] {$element= $eTypedElement.element;}
    | eClassifier[$owner] {$element= $eClassifier.element;}
    | ePackage[$owner] {$element= $ePackage.element;}
    | eEnumLiteral[$owner] {$element= $eEnumLiteral.element;}
    ;

eTypedElement[Element owner] returns [ETypedElement element]:
      eOperation[$owner] {$element= $eOperation.element;}
    | eParameter[$owner] {$element= $eParameter.element;}
    | eStructuralFeature[$owner] {$element= $eStructuralFeature.element;}
    ;

eModelElementRef:
    'reference' ownedPathName= pathName ';'
    ;

templateSignature[Element owner] returns [List<ETypeParameter> typeParameters]
@init {$typeParameters = new ArrayList<>();}
@after {for(ETypeParameterContext ctx: $ownedTypeParameters) $typeParameters.add(ctx.element);}:
    '<'  ownedTypeParameters+= eTypeParameter[$owner] (',' ownedTypeParameters+= eTypeParameter[$owner])* '>'
    ;

eTypeParameter[Element owner] returns [ETypeParameter element] locals[TypeParameter current]
@init {$element = eFactory.createETypeParameter();}
@after{for(EGenericTypeRefContext ctx: $ownedEBounds) $element.getEBounds().add(ctx.element); owner.addOwnedElement($current);}:
	name= unrestrictedName {$element.setName($name.text);} {$current = new TypeParameter($element, $ctx);}
	('extends' ownedEBounds+= eGenericTypeRef[$current] ('&' ownedEBounds+= eGenericTypeRef[$current])*)?
    ;

eGenericTypeArgument[Element owner] returns [EGenericType element]:
	eGenericTypeRef[$owner] {$element= $eGenericTypeRef.element;} | wildcardTypeRef[$owner] {$element= $wildcardTypeRef.element;}
    ;

eGenericTypeRef[Element owner] returns [EGenericType element] locals[GenericType current]
@init {$element = eFactory.createEGenericType(); $current = new GenericType($ctx);}
@after{for(EGenericTypeArgumentContext ctx: $ownedETypeArguments) $element.getETypeArguments().add(ctx.element);
       owner.addOwnedElement($current);}:
    ownedPathName= pathName ('<' ownedETypeArguments+= eGenericTypeArgument[$current] (',' ownedETypeArguments+= eGenericTypeArgument[$current])* '>')?
    ;

eTypeRef[Element owner]:
    ePrimitiveType | eGenericTypeRef[$owner]
    ;

wildcardTypeRef[Element owner] returns [EGenericType element] locals[WildCardType current]:
	'?' {$element = eFactory.createEGenericType(); $current = new WildCardType($ctx); owner.addOwnedElement($current);}
	(bound=('extends' | 'super') ownedExtends= eGenericTypeRef[$current] {if ($bound.equals("extends")) $element.setEUpperBound($eGenericTypeRef.element); else $element.setELowerBound($eGenericTypeRef.element);})?
    ;

pathName:
	ownedPathElements+= unrestrictedName ('::' ownedPathElements+= unrestrictedName)* ('.' lastPath= integer)?
	;

/* primitive types cannot be qualified by a nullable keyword, only reference types can be nullable.*/
ePrimitiveType returns [EDataType element]:
      'Boolean' {$element = EcorePackage.eINSTANCE.getEBoolean();}
    | 'Integer' {$element = EcorePackage.eINSTANCE.getEInt();}
    | 'String'  {$element = EcorePackage.eINSTANCE.getEString();}
    | 'Real'    {$element = EcorePackage.eINSTANCE.getEBigDecimal();}
    | 'UnlimitedNatural' {$element = EcorePackage.eINSTANCE.getEBigInteger();}
    ;

body[Element owner]  returns [EAnnotation element] locals[Body current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.BODY); $current = new Body($ctx); $owner.addOwnedElement($current);}:
    'body' name= identifier? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); }
    ((':' ownedExpression= expression? ';') | ';') {if($ctx.ownedExpression!=null) $element.getDetails().put("expression", getContextText($ctx.expression())); }
    ;

/* Class-level invariants are conditions that must be true on entry and exit of every method in a class. */
invariant[Element owner] returns [EAnnotation element] locals[Invariant current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.INVARIANT); $current = new Invariant($ctx); $owner.addOwnedElement($current);}:
    (isCallable= 'callable')? {$element.getDetails().put("callable", $isCallable != null ? "true" : "false");}
    'invariant' (name= identifier ('(' message= DOUBLE_QUOTED_STRING ')')? )? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); if($message!=null) $element.getDetails().put("message", $message.text.replace("\"", ""));}
	((':' ownedSpecification= formula? ';') | ';') {if($ctx.ownedSpecification!=null) $element.getDetails().put("formula", getContextText($ctx.formula())); }
    ;

/* A precondition is a condition that must be satisfied before calling a method */
precondition[Element owner]  returns [EAnnotation element] locals[PreCondition current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.PRECONDITION); $current = new PreCondition($ctx); $owner.addOwnedElement($current);}:
	('precondition' | 'requires') (name= identifier ('(' message= DOUBLE_QUOTED_STRING ')')? )? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); if($message!=null) $element.getDetails().put("message", $message.text.replace("\"", ""));}
	((':' ownedSpecification= formula? ';') | ';') {if($ctx.ownedSpecification!=null) $element.getDetails().put("formula", getContextText($ctx.formula())); }
    ;

/*
 The postcondition of a method specifies the responsibilities of the method; that is, when the
 method returns, the postcondition should be true
*/
postcondition[Element owner]  returns [EAnnotation element] locals[PostCondition current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.POSTCONDITION); $current = new PostCondition($ctx); $owner.addOwnedElement($current);}:
	('postcondition' | 'ensures') (name= identifier ('(' message= DOUBLE_QUOTED_STRING ')')? )? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); if($message!=null) $element.getDetails().put("message", $message.text.replace("\"", ""));}
	((':' ownedSpecification= formula? ';') | ';') {if($ctx.ownedSpecification!=null) $element.getDetails().put("formula", getContextText($ctx.formula())); }
    ;

initial[Element owner]  returns [EAnnotation element] locals[Initial current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.INITIAL); $current = new Initial($ctx); $owner.addOwnedElement($current);}:
    'initial' name= identifier? {if($ctx.name!=null) $element.getDetails().put("name", $name.text);}
    ((':' ownedExpression= expression? ';') | ';') {if($ctx.ownedExpression!=null) $element.getDetails().put("expression", getContextText($ctx.expression())); }
    ;

derivation[Element owner]  returns [EAnnotation element] locals[Derivation current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.DERIVATION); $current = new Derivation($ctx); $owner.addOwnedElement($current);}:
    'derivation' name= identifier? {if($ctx.name!=null) $element.getDetails().put("name", $name.text);}
    ((':' ownedExpression= expression? ';') | ';') {if($ctx.ownedExpression!=null) $element.getDetails().put("expression", getContextText($ctx.expression())); }
    ;

/*
Package-private is default as in Java
“+” public
“-“ private
“#”  protected
“~” package
*/
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
        identifier
    |	'abstract'
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

;

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
WS: [ \t\r\n]+ -> skip ; // toss out whitespace
// \t checkout toss out this character
