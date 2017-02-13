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

import eu.modelwriter.core.alloyinecore.structure.base.INamespace;
import eu.modelwriter.core.alloyinecore.structure.base.Repository;
import eu.modelwriter.core.alloyinecore.structure.base.Element;

import eu.modelwriter.core.alloyinecore.structure.model.ModelElement;
import eu.modelwriter.core.alloyinecore.structure.model.Annotation;
import eu.modelwriter.core.alloyinecore.structure.model.AnnotationDetail;
import eu.modelwriter.core.alloyinecore.structure.model.AnnotationReference;
import eu.modelwriter.core.alloyinecore.structure.model.NamedElement;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.structure.model.EcoreImport;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import eu.modelwriter.core.alloyinecore.structure.model.RootPackage;
import eu.modelwriter.core.alloyinecore.structure.model.Classifier;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Interface;
import eu.modelwriter.core.alloyinecore.structure.model.DataType;
import eu.modelwriter.core.alloyinecore.structure.model.Enum;
import eu.modelwriter.core.alloyinecore.structure.model.EnumLiteral;
import eu.modelwriter.core.alloyinecore.structure.model.StructuralFeature;
import eu.modelwriter.core.alloyinecore.structure.model.TypedElement;
import eu.modelwriter.core.alloyinecore.structure.model.Multiplicity;
import eu.modelwriter.core.alloyinecore.structure.model.Reference;
import eu.modelwriter.core.alloyinecore.structure.model.Attribute;
import eu.modelwriter.core.alloyinecore.structure.model.Operation;
import eu.modelwriter.core.alloyinecore.structure.model.Parameter;
import eu.modelwriter.core.alloyinecore.structure.model.GenericException;
import eu.modelwriter.core.alloyinecore.structure.model.TypeParameter;
import eu.modelwriter.core.alloyinecore.structure.model.GenericType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericTypeArgument;
import eu.modelwriter.core.alloyinecore.structure.model.GenericElementType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericSuperType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericWildcard;
import eu.modelwriter.core.alloyinecore.structure.model.PrimitiveType;
import eu.modelwriter.core.alloyinecore.structure.model.Invariant;
import eu.modelwriter.core.alloyinecore.structure.model.Derivation;
import eu.modelwriter.core.alloyinecore.structure.model.Body;
import eu.modelwriter.core.alloyinecore.structure.model.PostCondition;
import eu.modelwriter.core.alloyinecore.structure.model.PreCondition;
import eu.modelwriter.core.alloyinecore.structure.model.Initial;

import eu.modelwriter.core.alloyinecore.structure.instance.ModelImport;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.instance.Slot;
import eu.modelwriter.core.alloyinecore.structure.instance.ObjectValue;
import eu.modelwriter.core.alloyinecore.structure.instance.EnumValue;
import eu.modelwriter.core.alloyinecore.structure.instance.IntegerValue;
import eu.modelwriter.core.alloyinecore.structure.instance.RealValue;
import eu.modelwriter.core.alloyinecore.structure.instance.BooleanValue;
import eu.modelwriter.core.alloyinecore.structure.instance.StringValue;
import eu.modelwriter.core.alloyinecore.structure.instance.NullValue;
import eu.modelwriter.core.alloyinecore.structure.instance.CharValue;

import eu.modelwriter.core.alloyinecore.structure.constraints.Formula;
import eu.modelwriter.core.alloyinecore.structure.constraints.Expression;
import eu.modelwriter.core.alloyinecore.structure.constraints.IntExpression;
import eu.modelwriter.core.alloyinecore.structure.constraints.QuantifierDeclaration;
import eu.modelwriter.core.alloyinecore.structure.constraints.LetDeclaration;
import eu.modelwriter.core.alloyinecore.structure.constraints.ComprehensionDeclaration;
import eu.modelwriter.core.alloyinecore.structure.constraints.Variable;

import eu.modelwriter.core.alloyinecore.internal.AnnotationSources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import java.io.IOException;
}

@parser::members {

public Model model;
public Instance instance;
private boolean resolveImports = true;

Repository repository = new Repository();


URI saveURI;

public AlloyInEcoreParser(TokenStream input, URI saveURI){
    this(input);
    this.saveURI = saveURI;
    repository = new Repository(saveURI);
}

public AlloyInEcoreParser(TokenStream input, URI saveURI, boolean resolveImports){
    this(input, saveURI);
    this.resolveImports = resolveImports;
}


public void saveResource(String filename, String path){
    model.printTree();
    repository.printNamespaces();
    if (model.getOwnedPackage() != null) {
        ResourceSet metaResourceSet = new ResourceSetImpl();
        metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());
        Resource metaResource = metaResourceSet.createResource(URI.createURI(path + filename + ".ecore"));
        metaResource.getContents().add(model.getOwnedPackage().getEObject());
        try {
            metaResource.save(null);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

private String getLocation() { return "["+ getCurrentToken().getLine()+ ","+ getCurrentToken().getCharPositionInLine()+ "]";}

private String getContextText(ParserRuleContext ctx){
    return getTokenStream().getTokenSource().getInputStream().toString().substring(ctx.start.getStartIndex(),ctx.stop.getStopIndex());
}


private EcoreFactory eFactory = EcoreFactory.eINSTANCE;

private void signalParsingCompletion() {
    //restoreReferences();
    //checkConstraints();
}

private void createEAnnotation(EModelElement owner, final String source) {
    if (owner.getEAnnotation(source) != null)
        return;
    final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
    eAnnotation.setSource(source);
    owner.getEAnnotations().add(eAnnotation);
}

//private java.util.Stack<Element> owners = new java.util.Stack<>();

}

options: 'options' '{'  option (',' option)* '}';

option: key= 'symmetry_breaking' ':'    value= INT  #symmetryBreaking
    |   key= 'bit_width' ':'            value= INT  #bitWidth
    |   key= 'skolem_depth' ':'         value= INT  #skolemDepth
    |   key= 'sharing' ':'              value= INT  #sharing
;


/*
Identifying class instance (objects)
=====================================
Since the value of the attribute selected as the identifying attribute is presented in the class instance’s introduction,
its normal representation within the body of the instance’s definition is superfluous, and is thus omitted.

By default, identifying strings (be they arbitrary or the value of an attribute) are required to be unique over the
set of instance of the class, and over all instance of its subtypes.

Attributes whose lower multiplicity bound is 0 may be explicitly unset by assigning them to the ‘null’ keyword.

The association name is optionally displayed before the contained class instance to allow disambiguation for MOF models
that have more than one possible containment association between the container and the contained instance.

Three reserved words: “true” and “false” for representing boolean values, and “null” for unsetting attribute values.

‘+’ and ‘-’ can be used to indicate the positive/negative sign of the value.

*/
instance[Element owner] locals[Instance current]
@init{$current= new Instance($ctx); instance= $current; if (owner!=null) owner.addOwnedElement($current);}
@after{instance.printTree();}:
    ('instance' name= identifier ';')?
    packageImport[$current]* modelImport[$current] (rootObject= eObject[$current] | ';')
    ;

modelImport[Element owner] locals[ModelImport current, EObject object]
@init{$current= new ModelImport($ctx); if (owner!=null) owner.addOwnedElement($current);}
@after{
if ($ownedPathName != null) {
    String path = $ownedPathName.getText().replace("'", "");
    if (path.equals(EcorePackage.eNS_URI)) {
        notifyErrorListeners($ownedPathName, "You cannot create an instance of ECore Model! Instead, create a model in model editor!", null);
    } else {
        Resource resource = repository.loadResource(path);
        if (resource == null) {
            notifyErrorListeners($ownedPathName, "Import could not be resolved!", null);
        }
        else {
            $object = repository.loadResource(path).getContents().get(0);
            if ($object instanceof ENamedElement) {
                $current.setEObject($object);
                repository.name2Import.put($current.getKey(), $current);
                $current.loadNamespace(repository);
            } else {
                notifyErrorListeners($ownedPathName, "This is an instance, cannot be used as a model!", null);
            }
        }
    }
}
}:
    ('model') (name= unrestrictedName ':')? ownedPathName= SINGLE_QUOTED_STRING ';'
    ;

//pathName indicates the class to which this object conforms
eObject[Element owner] locals[Object current]
@init{$current= new Object($ctx); if (owner!=null) owner.addOwnedElement($current);}:
    name= pathName[$current] //must conform to a type in imported model
    {}
    id= literalValue[$owner]? //must conform to the id attribute definition of the type in imported model
    {}
    ('{' slots+= slot[$current] (',' slots+= slot[$current])* '}' | ';') ;

slot[Element owner] locals[Slot current]
@init{$current= new Slot($ctx); if (owner!=null) owner.addOwnedElement($current);}:
    name= unrestrictedName
    {}
    (':' (
           {true}? '{' eObject[$current]* '}' //semantic predicate koymayi unutma!
          | eObjectValue[$current]
          | '[' eObjectValue[$current] (',' eObjectValue[$current] )* ']'
          | dataValue[$current]
          )
    )?;

dataValue[Element owner]
@init{}:
    literalValue[$owner] | multiValueData[$owner];

multiValueData[Element owner]
@init{}:
    '[' dataValue[$owner] (',' dataValue[$owner])* ']' ;

eObjectValue[Element owner] locals[ObjectValue current]
@init{$current= new ObjectValue($ctx); if (owner!=null) owner.addOwnedElement($current);}:
    pathName[$current];

literalValue[Element owner] locals[Element current]
@init{if($ctx.parent instanceof EObjectContext) {} else { $current = $owner;} }:
        enumValue    [$current]
    |   integerValue [$current]
    |   realValue    [$current]
    |   stringValue  [$current]
    |   charValue    [$current]
    |   booleanValue [$current]
    |   nullValue    [$current]
    ;

enumValue[Element owner] locals[EnumValue current]
@init{$current= new EnumValue($ctx); if (owner!=null) $owner.addOwnedElement($current);}
    : identifier;

booleanValue[Element owner] locals[BooleanValue current]
@init{$current= new BooleanValue($ctx); if (owner!=null) $owner.addOwnedElement($current);}
    : 'true' | 'false';

integerValue[Element owner] locals[IntegerValue current]
@init{$current= new IntegerValue($ctx); if (owner!=null) $owner.addOwnedElement($current);}
    : ('+' | '-')? INT;


realValue[Element owner] locals[RealValue current]
@init{$current= new RealValue($ctx); if (owner!=null) $owner.addOwnedElement($current);}
    :('+' | '-')? INT? '.' INT;

stringValue[Element owner] locals[StringValue current]
@init{$current= new StringValue($ctx); if (owner!=null) $owner.addOwnedElement($current);}
    : DOUBLE_QUOTED_STRING;

charValue[Element owner] locals[CharValue current]
@init{$current= new CharValue($ctx); if (owner!=null) $owner.addOwnedElement($current);}
    : SINGLE_CHARACTER;

/*  NullValue is intended to be used to explicitly model the lack of a value */
nullValue[Element owner] locals[NullValue current]
@init{$current= new NullValue($ctx); if (owner!=null) $owner.addOwnedElement($current);}
    : 'null';

/*http://help.eclipse.org/neon/topic/org.eclipse.ocl.doc/help/OCLinEcore.html*/
/*optional model declaration*/
model locals[EAnnotation element]
@init {model = new Model($ctx); $element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.MODULE);}
@after{signalParsingCompletion();}:
    options? {}
    ('model' name= identifier ';')? {$element.getDetails().put("name", $name.text);}
    (ownedPackageImport+= packageImport[model] )*
    (ownedPackage= ePackage[model] {$ePackage.element.getEAnnotations().add($element);} )
    {for(PackageImportContext ctx: $ctx.ownedPackageImport) {$ePackage.element.getEAnnotations().add(ctx.element);}}
    ;

/*Zero or more external metamodels may be imported.*/
packageImport[Element owner] returns [EAnnotation element] locals [EObject object]
@init{$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.IMPORT);}
@after{
if ($ownedPathName != null) {
    String path = $ownedPathName.getText().replace("'", "");
    Import imported = null;
    if (path.equals(EcorePackage.eNS_URI)) {
        $object = EcorePackage.eINSTANCE;
        imported = new EcoreImport($object, $ctx);
        $owner.addOwnedElement(imported);
        repository.name2Import.put(imported.getKey(), imported);
        imported.loadNamespace(repository);
    } else {
        Resource resource = repository.loadResource(path);
        if (resource == null) {
            notifyErrorListeners($ownedPathName, "Import could not be resolved!", null);

        } else {
            $object = repository.loadResource(path).getContents().get(0);
            imported = new Import($object, $ctx);
            $owner.addOwnedElement(imported);
            repository.name2Import.put(imported.getKey(), imported);
            imported.loadNamespace(repository);
        }
    }
}
}:
    ('import') (name= identifier ':')? ownedPathName= SINGLE_QUOTED_STRING ';'
    {$element.getDetails().put($name.text, $ownedPathName != null ? $ownedPathName.getText().replace("'", "") : null);}
    ;

/*
 Constraints:
 1. WellFormedNsURI
 2. WellFormedNsPrefix
 3. UniqueSubpackageNames
 4. UniqueClassifierNames
 5. UniqueNsURIs
*/
ePackage[Element owner] returns [EPackage element] locals [Package current]
@init {$element = eFactory.createEPackage(); if($ctx.parent instanceof ModelContext) {$current = new RootPackage($element, $ctx);} else {$current = new Package($element, $ctx);}}
@after{owner.addOwnedElement($current);}:
    (visibility= visibilityKind)? {if($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    'package' name= unrestrictedName
    {$element.setName($name.text);}
    {if($ctx.parent instanceof ModelContext) {repository.name2Import.put(((RootPackage)$current).getKey(), (RootPackage)$current);}}
    (':' nsPrefix= identifier) ('=' nsURI= SINGLE_QUOTED_STRING)  {$element.setNsPrefix($nsPrefix.text); if($nsURI != null) $element.setNsURI($nsURI.getText().replace("'", ""));}
    (('{' (   ownedAnnotations+=eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);}
            | eSubPackages+= ePackage[$current] {$element.getESubpackages().add($ePackage.element);}
            | eClassifiers+= eClassifier[$current] {if ($eClassifier.element != null) $element.getEClassifiers().add($eClassifier.element);}
            | eConstraints+= invariant[$current] {$element.getEAnnotations().add($invariant.element);}
          )*
      '}') | ';')
    ;

/*
 Constraints:
 1. WellFormedInstanceTypeName
 2. UniqueTypeParameterNames
*/
eClassifier[Element owner] returns [EClassifier element]:
      eClass[$owner] {$element= $eClass.element;}
    | eDataType[$owner] {$element= $eDataType.element;}
    | eEnum[$owner] {$element= $eEnum.element;}
    ;

/*
 Once interface is true, abstract is also implicitly true. Interface with abstract modifier is redundant.
 Constraints:
 1. InterfaceIsAbstract
 2. AtMostOneID
 3. UniqueFeatureNames
 4. UniqueOperationSignatures
 5. NoCircularSuperTypes
 6. WellFormedMapEntryClass
 7. ConsistentSuperTypes
 8. DisjointFeatureAndOperationSignatures
*/
eClass[Element owner] returns [EClass element] locals [Class current]
@init {$element = eFactory.createEClass(); $current = new Class($element, $ctx); if (owner!=null) owner.addOwnedElement($current); }
@after{}:
    (visibility= visibilityKind)? {if($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (isAbstract= 'abstract'? isClass='class' | isInterface= 'interface') {$element.setAbstract($isAbstract!=null); if ($isInterface!=null) {$element.setInterface(true);$element.setAbstract(true);}}
    name= unrestrictedName?
    {if ($ctx.name == null) {notifyErrorListeners("missing Class name");} else {$element.setName($name.text);}}
    {if ($isInterface!=null) {owner.deleteOwnedElement($current); $current = new Interface($element, $ctx); if (owner!=null) owner.addOwnedElement($current);}}
    (ownedSignature= templateSignature[$current])? {if($ctx.templateSignature != null) $element.getETypeParameters().addAll($templateSignature.typeParameters);}
    ('extends' eSuperTypes+= eGenericSuperType[$current] (',' eSuperTypes+= eGenericSuperType[$current])*)? {}
    (':' instanceClassName= SINGLE_QUOTED_STRING)? {if($instanceClassName != null) $element.setInstanceClassName($instanceClassName.getText().replace("'", ""));}
    (('{' (   ownedAnnotations+= eAnnotation[$current] {if ($eAnnotation.element != null) $element.getEAnnotations().add($eAnnotation.element);}
            | eOperations+= eOperation[$current] {if ($eOperation.element != null) $element.getEOperations().add($eOperation.element);}
            | eStructuralFeatures+= eStructuralFeature[$current] {if ($eStructuralFeature.element != null) $element.getEStructuralFeatures().add($eStructuralFeature.element);}
            | eConstraints+= invariant[$current] {if ($invariant.element != null) $element.getEAnnotations().add($invariant.element);}
          )*
      '}') | ';')
    ;

/*
 A StructuralFeature may be an Attribute or a Reference
 Constraints:
 1. ValidDefaultValueLiteral
*/
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

/*
 Constraints:
 1. ConsistentTransient
*/
eAttribute[Element owner] returns [EAttribute element] locals [Attribute current]
@init {$element = eFactory.createEAttribute(); $current = new Attribute($element, $ctx); if (owner!=null) owner.addOwnedElement($current);}
@after{
if ($ctx.eAttributeType != null) {
    EObject genericElementType = $ctx.eAttributeType.element;
    if (genericElementType instanceof EClassifier) { $element.setEType((EClassifier) genericElementType);}
    else if (genericElementType instanceof EGenericType) { $element.setEGenericType((EGenericType) genericElementType);}
}
}:
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+='static')?
    (qualifier+='model' | qualifier+='ghost')?
    (qualifier+='transient')?
    (qualifier+='volatile')?
    (qualifier+='readonly')?
	'attribute' name= unrestrictedName {$element.setName($name.text);}
	':' eAttributeType= eGenericElementType[$current] (ownedMultiplicity= eMultiplicity[$current, (ETypedElement)$element])? {if($ctx.ownedMultiplicity == null) {$element.setLowerBound(1);} }
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
            case "readonly":   $element.setChangeable(false); break;
            case "derived":    $element.setDerived(true); break;
            case "ordered":    int u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setOrdered(true); break;
            case "!unique":    u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setUnique(false); break;
            case "unsettable": $element.setUnsettable(true); break;
            case "id":         $element.setID(true); break;}}
    };

/*
 The defaults for multiplicity lower and upper bound and for ordered and unique correspond to a single element Set
 that is [1] {unique,!ordered}.

 We can declare that a collection is null-free; i.e. that it contains no null element, which is also the default way.
 ForAll collections are null-free unless explicitly declared to be nullable.
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

/*
 Constraints:
 1. ConsistentOpposite
 2. SingleContainer
 3. ConsistentKeys
 4. ConsistentUnique
 5. ConsistentContainer
*/
eReference[Element owner] returns [EReference element] locals [Reference current]
@init {$element = eFactory.createEReference(); $current = new Reference($element, $ctx); if (owner!=null) owner.addOwnedElement($current);} :
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+='static')?
    (qualifier+='model' | qualifier+='ghost')?
    (qualifier+='transient')?
    (qualifier+='volatile')?
    (qualifier+='readonly')?
	'property' name= unrestrictedName {$element.setName($name.text);}
	('#' eOpposite= unrestrictedName)? {}
	(':' eReferenceType= eGenericElementType[$current] (ownedMultiplicity= eMultiplicity[$current, (ETypedElement) $element])? ) {if ($ctx.ownedMultiplicity == null) {$element.setLowerBound(1);} }
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
            case "readonly":  $element.setChangeable(false); break;
            case "unsettable":$element.setUnsettable(true); break;
            case "derived":   $element.setDerived(true); break;
            case "ordered":   int u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setOrdered(true); break;
            case "!unique":   u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setUnique(false); break;
            case "composes":  $element.setContainment(true); break;
            case "!resolve":  $element.setResolveProxies(false); break;
            default: break;}}
    };

/*
 Constraints:
 1. UniqueParameterNames
 2. UniqueTypeParameterNames
 3. NoRepeatingVoid
*/
eOperation[Element owner] returns [EOperation element] locals [Operation current]
@init {$element = eFactory.createEOperation(); $current = new Operation($element, $ctx); if (owner!=null) owner.addOwnedElement($current);} :
	(visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+='static')?
    'operation' (ownedSignature= templateSignature[$current])? {if($ctx.templateSignature != null) $element.getETypeParameters().addAll($templateSignature.typeParameters);}
	name= unrestrictedName {$element.setName($name.text);}
	('(' (eParameters+= eParameter[$current] (',' eParameters+= eParameter[$current])*)? ')') {for (EParameterContext ctx: $eParameters){$element.getEParameters().add(ctx.element);}}
	(':' eReturnType= eGenericElementType[$current] (ownedMultiplicity= eMultiplicity[$current, (ETypedElement) $element])? )? {if ($ctx.ownedMultiplicity == null) {$element.setLowerBound(1);} }
	{ if ($ctx.eReturnType != null) $element.setEGenericType($eGenericElementType.element);}
	('throws' ownedException+= eGenericException[$current] (',' ownedException+= eGenericException[$current])*)?
	{ for(EGenericExceptionContext e: $ownedException) $element.getEGenericExceptions().add(e.element);}
	('{'((qualifier+='ordered' | qualifier+='!ordered' | qualifier+='unique'  | qualifier+='!unique'  ) ','? )+ '}')?
   (('{'(   ownedAnnotations+= eAnnotation[$current] {$element.getEAnnotations().add($eAnnotation.element);}
          | ownedPreconditions+= precondition[$current] {$element.getEAnnotations().add($precondition.element);}
          | ownedBodyExpression += body[$current] {$element.getEAnnotations().add($body.element);}
          | ownedPostconditions+= postcondition[$current] {$element.getEAnnotations().add($postcondition.element);} )*
	 '}') | ';')
    {for(String s: $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
        switch (s) {
            case "static":   createEAnnotation($element, AnnotationSources.STATIC); break;
            case "ordered":  int u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setOrdered(true); break;
            case "!unique":  u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setUnique(false); break;}}
    }
    ;

eGenericException [Element owner] returns [EGenericType element] locals [GenericException current]
@init {$current = new GenericException($ctx); if (owner!=null) $owner.addOwnedElement($current);} :
    eGenericType[$current] {$element = $eGenericType.element; $current.setEObject($element);}
;

eGenericSuperType [Element owner] returns [EGenericType element] locals [GenericSuperType current]
@init {$current = new GenericSuperType($ctx); if (owner!=null) $owner.addOwnedElement($current);} :
    eGenericType[$current] {$element = $eGenericType.element; $current.setEObject($element);}
;

/*
 The defaults for multiplicity lower and upper bound and for ordered and unique correspond to a single element Set
 that is [1] {unique,!ordered}
*/
eParameter[Element owner] returns [EParameter element] locals [Parameter current]
@init {$element = eFactory.createEParameter(); $current = new Parameter($element, $ctx); if (owner!=null) owner.addOwnedElement($current);} :
    name= unrestrictedName {$element.setName($name.text);}
	':' eParameterType= eGenericElementType[$current] (ownedMultiplicity= eMultiplicity[$current, (ETypedElement) $element])? {if ($ctx.ownedMultiplicity == null) {$element.setLowerBound(1);} }
	('{'(( qualifier+='ordered' | qualifier+='!ordered' | qualifier+='unique' | qualifier+='!unique') ','?)+ '}')?
	('{' ownedAnnotations+= eAnnotation[$current]* {$element.getEAnnotations().add($eAnnotation.element);} '}')?
    {for(String s: $qualifier.stream().map(Token::getText).distinct().collect(Collectors.toList())){
        switch (s) {
            case "ordered":  int u = $element.getUpperBound(); if (u > 1 || u == -1) $element.setOrdered(true);break;
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
@after{$element.setLowerBound($l); $element.setUpperBound($u); if (owner!=null) $owner.addOwnedElement(new Multiplicity($ctx));}:
	'[' (lowerBound= lower ('..' upperBound= upper)? | stringBound= ('*'|'+'|'?') ) (nullable='|?' | '|1')? ']'
	{
	if ($ctx.stringBound != null) {
	    switch ($ctx.stringBound.getText()) {
            case "*": $l = 0; $u = -1; break;
            case "+": $l = 1; $u = -1; break;
            case "?": $l = 0; $u =  1; break;
            default: break;
        }
    } else {
        try { $l = Integer.valueOf($lowerBound.text); } catch (NumberFormatException ex) {System.out.println(Arrays.toString(ex.getStackTrace()));}
        if ($ctx.upperBound != null) {
            if ($ctx.upperBound.getText().equals("*")) $u = -1;
            else try {$u = Integer.valueOf($upperBound.text);} catch (NumberFormatException ex){System.out.println(Arrays.toString(ex.getStackTrace()));}
        } else { $u = $l;}
    }
    if (($u > 1 || $u == -1) && $ctx.nullable != null) createEAnnotation($element, AnnotationSources.NULLABLE);
	};

/* primitive types cannot be qualified by a nullable keyword, only reference types can be nullable. */
eDataType[Element owner] returns [EDataType element] locals [DataType current]
@init {$element = eFactory.createEDataType(); $current = new DataType($element, $ctx); if (owner!=null) owner.addOwnedElement($current);} :
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    (qualifier+= 'primitive')?
    'datatype' name= unrestrictedName {$element.setName($name.text);}
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

/*
 Constraints:
 1. UniqueEnumeratorNames
 2. UniqueEnumeratorLiterals
*/
eEnum[Element owner] returns [EEnum element] locals [Enum current]
@init {$element = eFactory.createEEnum(); $current = new Enum($element, $ctx); if (owner!=null) owner.addOwnedElement($current);} :
    (visibility= visibilityKind)? {if ($ctx.visibility != null) $element.getEAnnotations().add($visibility.element);}
    'enum' name= unrestrictedName {$element.setName($name.text);}
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
@init {$element = eFactory.createEEnumLiteral(); $current = new EnumLiteral($element, $ctx); if (owner!=null) owner.addOwnedElement($current);} :
	(('literal' name= unrestrictedName) | name= unrestrictedName) {$element.setName($name.text);}
	('=' value= INT)? { }
	(( '{'
	        ownedAnnotations+= eAnnotation[$current]* {$element.getEAnnotations().add($eAnnotation.element);}
	   '}') |';')
    ;

eAnnotation[Element owner] returns [EAnnotation element] locals [Annotation current]
@init {$element = eFactory.createEAnnotation(); $current = new Annotation($element, $ctx); if (owner!=null) owner.addOwnedElement($current);} :
	'annotation' (source= SINGLE_QUOTED_STRING)? {$element.setSource($source != null ? $source.getText().replace("'", "") : null);}
	('(' ownedDetails+=eDetail[$current] (',' ownedDetails+=eDetail[$current])* ')')?
	{for (EDetailContext ctx: $ownedDetails) $element.getDetails().put(ctx.k, ctx.v);}
	(('{' (   ownedAnnotations+= eAnnotation[$current] {if($eAnnotation.element != null) $element.getEAnnotations().add($eAnnotation.element);}
	        | ownedContents+= eModelElement[$current] {if($eModelElement.element != null) $element.getContents().add($eModelElement.element);}
	        | ownedReferences+= eModelElementRef[$current] {if($eModelElementRef.element != null) $element.getReferences().add($eModelElementRef.element);}
	      )+
	  '}') |';')
    ;

eDetail[Element owner] returns [String k, String v] locals [AnnotationDetail current]
@init{$current = new AnnotationDetail($ctx); if (owner!=null) owner.addOwnedElement($current);} :
	key= SINGLE_QUOTED_STRING? '=' value= (SINGLE_QUOTED_STRING|ML_SINGLE_QUOTED_STRING)?
	{$k = $key != null ? $key.getText().replace("'", "") : null; $v = $value != null ? $value.getText().replace("'", "") : null; }
    ;

eModelElement[Element owner] returns [EModelElement element]:
      eAnnotation [$owner]{$element= $eAnnotation.element;}
    | eNamedElement [$owner] {$element= $eNamedElement.element;}
    ;

/*
 Constraints:
 1. WellFormedName
*/
eNamedElement[Element owner] returns [ENamedElement element] :
      eTypedElement[$owner] {$element= $eTypedElement.element;}
    | eClassifier[$owner] {$element= $eClassifier.element;}
    | ePackage[$owner] {$element= $ePackage.element;}
    | eEnumLiteral[$owner] {$element= $eEnumLiteral.element;}
    ;

/*
 Constraints:
 1. ValidLowerBound
 2. ValidUpperBound
 3. ConsistentBounds
 4. ValidType
*/
eTypedElement[Element owner] returns [ETypedElement element]:
      eOperation[$owner] {$element= $eOperation.element;}
    | eParameter[$owner] {$element= $eParameter.element;}
    | eStructuralFeature[$owner] {$element= $eStructuralFeature.element;}
    ;

eModelElementRef[Element owner] returns [EObject element] locals [AnnotationReference current]
@init{$current = new AnnotationReference($ctx); if (owner!=null) owner.addOwnedElement($current);} :
    'reference' ownedPathName= pathName[$current] {if ($ownedPathName.element != null) $current.setEObject($element = $ownedPathName.element);} ';'
    ;

templateSignature[Element owner] returns [List<ETypeParameter> typeParameters]
@init {$typeParameters = new ArrayList<>();}
@after{for(ETypeParameterContext ctx: $ownedTypeParameters) $typeParameters.add(ctx.element);}:
    '<'  ownedTypeParameters+= eTypeParameter[$owner] (',' ownedTypeParameters+= eTypeParameter[$owner])* '>'
    ;

eTypeParameter[Element owner] returns [ETypeParameter element] locals[TypeParameter current]
@init {$element = eFactory.createETypeParameter(); $current = new TypeParameter($element, $ctx); if (owner!=null) owner.addOwnedElement($current);} :
	name= unrestrictedName {$element.setName($name.text);}
	('extends' ownedEBounds+= eGenericType[$current] ('&' ownedEBounds+= eGenericType[$current])*)?
	{for(EGenericTypeContext ctx: $ownedEBounds) $element.getEBounds().add(ctx.element);}
    ;

eGenericTypeArgument[Element owner] returns [EGenericType element] locals[GenericTypeArgument current]
@init {$current = new GenericTypeArgument($ctx); if (owner!=null) $owner.addOwnedElement($current);} :
	  eGenericType[$current] {$element= $eGenericType.element; $current.setEObject($element);}
	| eGenericWildcard[$current] {$element= $eGenericWildcard.element; $current.setEObject($element);}
    ;

/*
 Constraints:
 1. ConsistentType
 2. ConsistentBounds
 3. ConsistentArguments
*/
eGenericType[Element owner] returns [EGenericType element] locals[Element current]
@init {
$element = eFactory.createEGenericType();
if ($ctx.parent instanceof ETypeParameterContext) {$current = new GenericType($element, $ctx); owner.addOwnedElement($current);}
else {$current = $owner;}
}:
    ownedPathName= pathName[$current] ('<' ownedETypeArguments+= eGenericTypeArgument[$current] (',' ownedETypeArguments+= eGenericTypeArgument[$current])* '>')?
    ;

eGenericElementType[Element owner] returns [EGenericType element] locals[GenericElementType current]
@init {$current = new GenericElementType($ctx); if (owner!=null) $owner.addOwnedElement($current);} :
      ePrimitiveType[$current] {$element= $ePrimitiveType.element; $current.setEObject($element);}
    | eGenericType[$current] {$element= $eGenericType.element; $current.setEObject($element);}
    ;

eGenericWildcard[Element owner] returns [EGenericType element] locals[GenericWildcard current]:
	'?' {$element = eFactory.createEGenericType();}
	(bound=('extends' | 'super') {$current = new GenericWildcard($element, $ctx); if (owner!=null) owner.addOwnedElement($current);}
	 ownedExtend= eGenericType[$current] {if ($bound.equals("extends")) $element.setEUpperBound($eGenericType.element); else $element.setELowerBound($eGenericType.element);})?
    ;

pathName[Element owner] returns [EObject element]
@init{}:
	firstSegment= unrestrictedName ('.' index= INT)? (midSegments+= segment*  lastSegment= segment)?
	;

segment:
    '::' '@'? name= unrestrictedName ('.' index= INT)?
    ;

/* primitive types cannot be qualified by a nullable keyword, only reference types can be nullable.*/
ePrimitiveType[Element owner] returns [EGenericType element] locals[PrimitiveType current]
@after{$current = new PrimitiveType($element, $ctx); if (owner!=null) owner.addOwnedElement($current);}:
      'Boolean' {$element = eFactory.createEGenericType(); $element.setEClassifier(EcorePackage.eINSTANCE.getEBoolean());}
    | 'Integer' {$element = eFactory.createEGenericType(); $element.setEClassifier(EcorePackage.eINSTANCE.getEInt());}
    | 'String'  {$element = eFactory.createEGenericType(); $element.setEClassifier(EcorePackage.eINSTANCE.getEString());}
    | 'Real'    {$element = eFactory.createEGenericType(); $element.setEClassifier(EcorePackage.eINSTANCE.getEBigDecimal());}
    | 'UnlimitedNatural' {$element = eFactory.createEGenericType(); $element.setEClassifier(EcorePackage.eINSTANCE.getEBigInteger());}
    ;

body[Element owner]  returns [EAnnotation element] locals[Body current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.BODY); $current = new Body($ctx); if (owner!=null) $owner.addOwnedElement($current);}:
    'body' name= identifier? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); }
    ((':' ownedExpression= expression? ';') | ';') {if($ctx.ownedExpression!=null) {$element.getDetails().put("expression", getContextText($ctx.expression())); $current.addOwnedElement($ownedExpression.element);}}
    ;

/* Class-level invariants are conditions that must be true on entry and exit of every method in a class. */
invariant[Element owner] returns [EAnnotation element] locals[Invariant current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.INVARIANT); $current = new Invariant($ctx); $owner.addOwnedElement($current);}:
    (isCallable= 'callable')? {$element.getDetails().put("callable", $isCallable != null ? "true" : "false");}
    'invariant' (name= identifier ('(' message= DOUBLE_QUOTED_STRING ')')? )? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); if($message!=null) $element.getDetails().put("message", $message.text.replace("\"", ""));}
	((':' ownedSpecification= formula? ';') | ';') {if($ctx.ownedSpecification!=null) {$element.getDetails().put("formula", getContextText($ctx.formula())); $current.addOwnedElement($ownedSpecification.element);}}
    ;

/* A precondition is a condition that must be satisfied before calling a method */
precondition[Element owner]  returns [EAnnotation element] locals[PreCondition current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.PRECONDITION); $current = new PreCondition($ctx); $owner.addOwnedElement($current);}:
	('precondition' | 'requires') (name= identifier ('(' message= DOUBLE_QUOTED_STRING ')')? )? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); if($message!=null) $element.getDetails().put("message", $message.text.replace("\"", ""));}
	((':' ownedSpecification= formula? ';') | ';') {if($ctx.ownedSpecification!=null) $element.getDetails().put("formula", getContextText($ctx.formula())); $current.addOwnedElement($ownedSpecification.element);}
    ;

/*
 The postcondition of a method specifies the responsibilities of the method; that is, when the
 method returns, the postcondition should be true
*/
postcondition[Element owner]  returns [EAnnotation element] locals[PostCondition current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.POSTCONDITION); $current = new PostCondition($ctx); $owner.addOwnedElement($current);}:
	('postcondition' | 'ensures') (name= identifier ('(' message= DOUBLE_QUOTED_STRING ')')? )? {if($ctx.name!=null) $element.getDetails().put("name", $name.text); if($message!=null) $element.getDetails().put("message", $message.text.replace("\"", ""));}
	((':' ownedSpecification= formula? ';') | ';') {if($ctx.ownedSpecification!=null) $element.getDetails().put("formula", getContextText($ctx.formula())); $current.addOwnedElement($ownedSpecification.element);}
    ;

initial[Element owner]  returns [EAnnotation element] locals[Initial current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.INITIAL); $current = new Initial($ctx); $owner.addOwnedElement($current);}:
    'initial' name= identifier? {if($ctx.name!=null) $element.getDetails().put("name", $name.text);}
    ((':' ownedExpression= expression? ';') | ';') {if($ctx.ownedExpression!=null) {$element.getDetails().put("expression", getContextText($ctx.expression())); $current.addOwnedElement($ownedExpression.element);} }
    ;

derivation[Element owner]  returns [EAnnotation element] locals[Derivation current]
@init {$element = eFactory.createEAnnotation(); $element.setSource(AnnotationSources.DERIVATION); $current = new Derivation($ctx); $owner.addOwnedElement($current);}:
    'derivation' name= identifier? {if($ctx.name!=null) $element.getDetails().put("name", $name.text);}
    ((':' ownedExpression= expression? ';') | ';') {if($ctx.ownedExpression!=null) {$element.getDetails().put("expression", getContextText($ctx.expression())); $current.addOwnedElement($ownedExpression.element);} }
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

/*
ForAll binary operators associate to the left, with the exception of implication, which associates to the right.
So, for example, p => q => r is parsed as p => (q => r), and a.b.c is parsed as (a.b).c.
*/

//Decls, Expression, Formula, IntExpression: kodkod.ast.Node
formula returns [Formula element] locals[int var=0]
@init {}
@after{}:

      'no'   expression  {$element = Formula.create($ctx);}                                                                                         #no             //Formula f = expr.no()   --Returns the formula 'no expr'.
    | 'lone' expression  {$element = Formula.create($ctx);}                                                                                         #lone           //Formula f = expr.lone() --Returns the formula 'lone expr'.
    | 'one'  expression  {$element = Formula.create($ctx);}                                                                                         #one            //Formula f = expr.one()  --Returns the formula 'one expr'.
    | 'some' expression  {$element = Formula.create($ctx);}                                                                                         #some           //Formula f = expr.some() --Returns the formula 'some expr'.

    //Set Operators: These operators can be applied to any pair of relations so long as they have the same arity.
    | left=expression not=('!' | 'not')? 'in' right=expression  {$element = Formula.create($ctx);}                                                  #in             //Formula f = left.in(right) --Returns the formula 'left in right' (subset).
    | left=expression not=('!' | 'not')? '='  right=expression  {$element = Formula.create($ctx);}                                                  #equal          //Formula f = left.eq(right) --Returns the formula 'left = right' (equal).

    //Integer Comparison Operators
    | ileft=intExpression not=('!' | 'not')? '='  iright=intExpression  {$element = Formula.create($ctx);}                                          #eq             //Formula f= left.eq(right) --Returns a formula stating that the given int expression and left have the same value.
    | ileft=intExpression not=('!' | 'not')? '<'  iright=intExpression  {$element = Formula.create($ctx);}                                          #lt             //Formula f= left.lt(right) --Returns a formula stating that the value of this int expression is less than the value of the given int expression.
    | ileft=intExpression not=('!' | 'not')? '<=' iright=intExpression  {$element = Formula.create($ctx);}                                          #lte            //Formula f= left.lte(right)--Returns a formula stating that the value of this int expression is less than or equal to the value of the given int expression.
    | ileft=intExpression not=('!' | 'not')? '>'  iright=intExpression  {$element = Formula.create($ctx);}                                          #gt             //Formula f= left.qt(right) --Returns a formula stating that the value of this int expression is greater than the value of the given int expression.
    | ileft=intExpression not=('!' | 'not')? '>=' iright=intExpression  {$element = Formula.create($ctx);}                                          #gte            //Formula f= left.qte(right)--Returns a formula stating that the value of this int expression is greater than or equal to the value of the given int expression

    | ('sum' quantifierDeclarations '|' intExpression) {$element = Formula.create($ctx);}                                                           #sumDeclaration //IntExpression iexpr = sum(Decls decls);

    | 'acyclic' '[' relationId ']' {$element = Formula.create($ctx);}                                                                               #acyclic        //
    | 'function' '[' rel=relationId ':' domain=expression '->' ('one'? | partial='lone') range=expression ']' {$element = Formula.create($ctx);}    #function       //Relation rel; Formula f = rel.function(domain, range); Formula f = rel.partialFunction(domain, range); --Returns a formula stating that this relation is a total function or partial function with the specified domain and range.
    | 'ord' '[' rel=relationId ',' ordered=relationId ',' first=relationId ',' last=relationId ']' {$element = Formula.create($ctx);}               #totalOrder     //Relation rel; Formula f = rel.totalOrder(Relation ordered, Relation first, Relation last) --Returns a formula stating that this relation imposes a total ordering over the atoms in the set ordered, and that thet first and last elements in the ordering are given by the relations first and last.

    //Logical Operators
    //NotFormula
    | op=('!' | 'not') formula  {$element = Formula.create($ctx);}                                                                                  #not            //Formula f = formula.not() --Returns the negation of this formula.

    //BinaryFormula (AND, IFF, IMPLIES, OR)
    | fleft=formula op=('&&' | 'and' ) fright=formula                         {$element = Formula.create($ctx);}                                    #and            //Formula f = left.and(right)     --Returns the conjunction of left and the specified formula.
    | fleft=formula op=('||' | 'or'  ) fright=formula                         {$element = Formula.create($ctx);}                                    #or             //Formula f = left.or(right)      --Returns the disjunction of left and the specified formula. x => y is true if (and only if) either y is true or x is false
    | <assoc=right> fleft=formula op=('=>' | 'if' | 'implies') fright=formula {$element = Formula.create($ctx);}                                    #implies        //Formula f = left.implies(right) --Returns the implication of the specified formula by left.
    | <assoc=right> fleft=formula op=('<=>' | 'iff') fright=formula           {$element = Formula.create($ctx);}                                    #iff            //Formula f = left.iff(right)     --Returns a formula that equates left and the specified formula.

    | ('all'  quantifierDeclarations  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))  {$element = Formula.create($ctx);}                   #forAll         //Formula f = formula.forAll(decls)  --Returns a formula that represents a universal quantification of this formula over the given declarations
    | ('some' quantifierDeclarations  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))  {$element = Formula.create($ctx);}                   #forSome        //Formula f = formula.forSome(decls) --Returns a formula that represents an existential quantification of this formula over the given declarations.
    | ('no'   quantifierDeclarations  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))  {$element = Formula.create($ctx);}                   #forNo          //no x: e | F is true when F is true for no bindings of the variable x.
    | ('one'  quantifierDeclarations  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))  {$element = Formula.create($ctx);}                   #forOne         //one x: e | F is true when F is true for exactly one binding of the variable x. (unique existential quantification)
    | ('lone' quantifierDeclarations  ('|' (formula | '{' formula* '}' ) | '{' formula* '}'))  {$element = Formula.create($ctx);}                   #forLone        //lone x: e | F is true when F is true for at most one binding of the variable x.

    | ('let' letDeclarations ('|' (formula | '{' formula* '}' ) | '{' formula* '}')) {$element = Formula.create($ctx);}                             #let

    //Constant Formulas
    | 'true'   {$element = Formula.create($ctx);}                                                                                                   #true           //Formula f = Formula.FALSE --Constant formula false
    | 'false'  {$element = Formula.create($ctx);}                                                                                                   #false          //Formula f  = Formula.TRUE --Constant formula true

    | '(' formula ')' {$element = $formula.element;}                                                                                                #f_paranthesis
    ;


/*
For the set theoretic operations (union, difference, and intersection) and for relational override,
the arguments are required to have the same arity.
*/
expression returns [Expression element]
@init {}
@after{}:
    // Relational Operators: These expressions are required to be unary
      '~' expression  {$element = Expression.create($ctx);}                                                                                         #transpose      //Expression: expr.transpose() --Returns the transpose of expr.
    | '^' expression  {$element = Expression.create($ctx);}                                                                                         #closure        //Expression: expr.closure() --Returns the transitive closure of expr.
    | '*' expression  {$element = Expression.create($ctx);}                                                                                         #reflexive      //Expression: expr.reflexiveClosure()--Returns the reflexive transitive closure of expr.

    // Set theoretic operations: These operators can be applied to any pair of relations so long as they have the same arity.
    | left=expression '+' right=expression {$element = Expression.create($ctx);}                                                                    #union          //Expression: left.union(right) --Returns the union of left and the specified expression.
    | left=expression '&' right=expression {$element = Expression.create($ctx);}                                                                    #intersection   //Expression: left.intersection(right) --Returns the intersection of left and the specified expression.
    | left=expression '-' right=expression {$element = Expression.create($ctx);}                                                                    #difference     //Expression: left.difference(right) --Returns the difference of left and the specified expression.

    //Relational Operators: These expressions are required to be binary
    | left=expression '.' right=expression     {$element = Expression.create($ctx);}                                                                #join           //Expression expr = left.join(right) --Returns the join of left and the specified expression.
    | right=expression '[' left=expression ']' {$element = Expression.create($ctx);}                                                                #boxJoin        //Expression expr = left.join(right) --e1[e2] = e2.e1 --
    | <assoc=right> left=expression leftMult= mult? '->' rightMult=mult? right=expression {$element = Expression.create($ctx);}                     #product        //Expression expr = left.product(right) --Returns the product of left and the specified expression
    | left=expression '++' right=expression   {$element = Expression.create($ctx);}                                                                                                         #override       //Expression expr = left.override(right) --Returns the relational override of left with the specified expression.

    //A comprehension expression, e.g. { a: A, b: B | a.r = b }
    //Comprehensions make relations from properties
    //{x1: e1, x2: e2, … | F} The relation obtained by taking all tuples x1 -> x2 -> …
    // in which x1 is drawn from the set e1, x2 is drawn from the set e2, and so on,
    // and for which the constraint F holds. The expressions e1, e2, and so on, must be unary,
    // and may not be prefixed by (or contain) multiplicity keywords
    //all d: decls.decls[int] | decl.variable.arity = 1 and decl.multiplicity = ONE
    | '{' comprehensionDeclarations '|' formula '}' {$element = Expression.create($ctx);}                                                           #comprehension  //Expression f = formula.comprehension(Decls decls) //Returns the comprehension expression constructed from this formula and the given declarations.

    | op=('=>' | 'if') condition=formula 'then' thenExpr=expression 'else' elseExpr=expression  {$element = Expression.create($ctx);}               #ifExpression

    //Constants
    | 'iden'  {$element = Expression.create($ctx);}                                                                                                 #iden           //Expression expr = Expression.IDEN --The identity relation: maps all atoms in a universe of discourse to themselves.
    | 'none'  {$element = Expression.create($ctx);}                                                                                                 #none           //Expression expr = Expression.NONE --The empty relation: contains no atoms.
    | 'univ'  {$element = Expression.create($ctx);}                                                                                                 #univ           //Expression expr = Expression.UNIV --The universal relation: contains all atoms in a universe of discourse.
    | 'ints'  {$element = Expression.create($ctx);}                                                                                                 #ints           //Expression expr = Expression.INTS --The integer relation: contains all atoms bound to integers

    | '(' expression ')' {$element = $expression.element;}                                                                                          #e_paranthesis

    | pathName[$element] {$element = Expression.create($ctx);}                                                                                      #typeRef        //ConstantExpression, Relation, Variable
    ;

intExpression returns [IntExpression element]:
      op=('=>' | 'if') condition=formula 'then' thenExpr=intExpression 'else' elseExpr=intExpression {$element = IntExpression.create($ctx);}       #ifIntExpression
    | 'sum' expression      {$element = IntExpression.create($ctx);}                                                                                #sum            //IntExpression iexpr = exp.sum();            --Returns the sum of the integer atoms in this expression.
    | '#'   expression      {$element = IntExpression.create($ctx);}                                                                                #count          //IntExpression iexpr = exp.count();          --Returns the cardinality(the number of elements in the set) of this expression
    | ileft=intExpression ('+' | 'plus')   iright=intExpression {$element = IntExpression.create($ctx);}                                            #plus           //IntExpression iexpr = this.plus(intExpr);   --Returns an IntExpression that represents the sum of this and the given int node
    | ileft=intExpression ('-' | 'minus')  iright=intExpression {$element = IntExpression.create($ctx);}                                            #minus          //IntExpression iexpr = this.minus(intExpr);  --Returns an IntExpression that represents the difference between this and the given int node.
    | ileft=intExpression ('*' | 'mul')    iright=intExpression {$element = IntExpression.create($ctx);}                                            #multiply       //IntExpression iexpr = this.minus(intExpr);  --Returns an IntExpression that represents the product of this and the given int node.
    | ileft=intExpression ('/' | 'div')    iright=intExpression {$element = IntExpression.create($ctx);}                                            #divide         //IntExpression iexpr = this.divide(intExpr); --Returns an IntExpression that represents the quotient of the division between this and the given int node.
    | ileft=intExpression ('%' | 'modulo') iright=intExpression {$element = IntExpression.create($ctx);}                                            #modulo         //IntExpression iexpr = this.modulo(intExpr); --Returns an IntExpression that represents the remainder of the division between this and the given int node.
    | sign='-'? INT     {$element = IntExpression.create($ctx);}                                                                                #intConstant
    | '(' intExpression ')' {$element = $intExpression.element;}                                                                                    #i_paranthesis
    ;

//A variable declaration, such as 'x : lone X'. Declarations are used with quantified formulas and comprehension expressions.
quantifierDeclarations returns [List<QuantifierDeclaration> elements]
@init {$elements = new ArrayList<>();}
@after{for(QuantifierDeclarationContext ctx: $ctx.quantifierDeclaration()) $elements.add(ctx.element);}:
    quantifierDeclaration (',' quantifierDeclaration)*;

quantifierDeclaration returns [QuantifierDeclaration element]:
      disj='disj'? vars+=variable (',' vars+=variable)* ':' 'one'? expression {$element = QuantifierDeclaration.create($ctx);}                      #oneOf          //Decl d = var.oneOf(expression)
    | disj='disj'? vars+=variable (',' vars+=variable)* ':' 'lone' expression {$element = QuantifierDeclaration.create($ctx);}                      #loneOf         //Decl d = var.loneOf(expression)
    | disj='disj'? vars+=variable (',' vars+=variable)* ':' 'some' expression {$element = QuantifierDeclaration.create($ctx);}                      #someOf         //Decl d = var.someOf(expression)
    | disj='disj'? vars+=variable (',' vars+=variable)* ':' 'set'  expression {$element = QuantifierDeclaration.create($ctx);}                      #setOf          //Decl d = var.setOf(expression)
    ;

letDeclarations returns [List<LetDeclaration> elements]
@init {$elements = new ArrayList<>();}
@after {for(LetDeclarationContext ctx: $ctx.letDeclaration()) $elements.add(ctx.element);}:
    letDeclaration (',' letDeclaration)*;

letDeclaration returns [LetDeclaration element]:
    vars+= variable (',' vars+= variable)* '=' expression
    {$element = new LetDeclaration($ctx);  for(VariableContext ctx: $ctx.variable()) $element.addOwnedElements(ctx.element);  $element.addOwnedElements($expression.element);};

comprehensionDeclarations returns [List<ComprehensionDeclaration> elements]
@init {$elements = new ArrayList<>();}
@after {for(ComprehensionDeclarationContext ctx: $ctx.comprehensionDeclaration()) $elements.add(ctx.element);}:
    comprehensionDeclaration (',' comprehensionDeclaration)*;

comprehensionDeclaration returns [ComprehensionDeclaration element]:
    disj='disj'? (vars+=variable (',' vars+=variable)* ':' 'one'? expression)
    {$element = new ComprehensionDeclaration($ctx); for(VariableContext ctx: $ctx.variable()) $element.addOwnedElements(ctx.element); $element.addOwnedElements($expression.element);};

relationId: unrestrictedName;
variable returns [Variable element]: unrestrictedName {$element = new Variable($ctx);};

/* Default multiplicity constraint is set*/
mult: 'set' | 'one' | 'lone' | 'some';

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
    |	'model'
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

INT :   DIGIT+ ;
IDENTIFIER : (UNDERSCORE | LETTER) (LETTER | APOSTROPHE | DIGIT | UNDERSCORE | DOLLAR)* ;
SINGLE_CHARACTER: '\'' ~['\\] '\'';
DOUBLE_QUOTED_STRING: '"' ( ESCAPED_CHARACTER | ~('\\' | '"' ) )* '"'  ;
SINGLE_QUOTED_STRING: '\'' ( ESCAPED_CHARACTER | ~('\'' | '\\') )* '\'' ;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment ESCAPED_CHARACTER: '\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | '\'' | '\\');
fragment UNDERSCORE: '_';
fragment APOSTROPHE: '\'';
fragment DOLLAR: '$';
fragment EXCLAMINATION_MARK: '!';
fragment MINUS: '-';
ML_SINGLE_QUOTED_STRING : '\'' .*? '\'' -> skip;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;
SINGLELINE_COMMENT : ('--' | '//') .*? '\r'? '\n' -> skip;
WS: [ \t\r\n]+ -> skip ; // toss out whitespace
