/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
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

package eu.modelwriter.core.alloyinecore.translator;

import eu.modelwriter.core.alloyinecore.internal.AIEConstants;
import eu.modelwriter.core.alloyinecore.internal.AnnotationSources;
import eu.modelwriter.core.alloyinecore.structure.INamespace;
import eu.modelwriter.core.alloyinecore.structure.Repository;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

public class EcoreTranslator implements AnnotationSources {

    private final Map<String, String> imports = new HashMap<>();
    private final Map<String, String> primitives = new HashMap<>();
    private final STGroup templateGroup;

    private EModelElement root;

    private Repository repository = new Repository();

    public EcoreTranslator() {
        templateGroup = new STGroupFile("AlloyInEcore.stg");
        primitives.put("Ecore::EString", "String");
        primitives.put("Ecore::EBoolean", "Boolean");
        primitives.put("Ecore::EBigDecimal", "Real");
        primitives.put("Ecore::EInt", "Integer");
        primitives.put("Ecore::EBigInteger", "UnlimitedNatural");
    }

    public EcoreTranslator(Repository repository) {
        this();
        this.repository = repository;
    }

    public String translate(String pathToEcore) throws IOException {
        if (repository.loadResource(pathToEcore) != null) {
            Resource resource = repository.loadResource(pathToEcore);
            EObject eObject = resource.getEObject("/");
            if ( eObject instanceof EModelElement)
                return translate((EModelElement)eObject);
        }
        return null;
    }

    public String translate(EModelElement element) {
        if (element.getEAnnotation(AnnotationSources.SOURCE) != null) {
            EAnnotation sourceAnno = element.getEAnnotation(AnnotationSources.SOURCE);
            String source = sourceAnno.getDetails().get(AIEConstants.SOURCE.toString());
            if (source != null)
                return source;
        }
        // If there is no source annotation, translate it.
        imports.clear();
        StringBuilder builder = new StringBuilder();
        if (element != null) {
            root = element;
            collectImports(element);
            builder.append(eObjectToString(element));
            builder.insert(0, importsToString());
            builder.insert(0, moduleToString(element));
        }
        return builder.toString();
    }

    private void collectImports(EModelElement element) {
        AnnotationSources.getImports(element).forEach(anno -> {
            if (!anno.getDetails().isEmpty()) {
                String name = anno.getDetails().get(0).getKey();
                String ns = anno.getDetails().get(0).getValue();
                imports.put(ns, name);
            }
        });
    }

    private String eObjectToString(EObject eObject) {
        if (eObject instanceof EPackage)
            return packageToString((EPackage) eObject);
        if (eObject instanceof EClassifier)
            return classifierToString((EClassifier) eObject);
        if (eObject instanceof EOperation)
            return operationToString((EOperation) eObject);
        if (eObject instanceof EAttribute)
            return attrToString((EAttribute) eObject);
        if (eObject instanceof EReference)
            return referenceToString((EReference) eObject);
        return "";
    }

    private String classifierToString(EClassifier eClassifier) {
        if (eClassifier instanceof EEnum)
            return enumToString((EEnum) eClassifier);
        if (eClassifier instanceof EClass)
            return classToString((EClass) eClassifier);
        if (eClassifier instanceof EDataType)
            return datatypeToString((EDataType) eClassifier);
        return "";
    }

    private String moduleToString(EModelElement element) {
        ST template = templateGroup.getInstanceOf("module");
        EAnnotation options = element.getEAnnotation(AnnotationSources.OPTIONS);
        if (options != null && !options.getDetails().isEmpty()) {
            options.getDetails().forEach(entry -> {
                template.add("option", entry.getKey() + " : " + entry.getValue());
            });
        }
        EAnnotation module = element.getEAnnotation(AnnotationSources.MODULE);
        if (module != null && module.getDetails().get("name") != null) {
            template.add("moduleName", module.getDetails().get("name"));
        }
        return template.render();
    }

    private void addAnnotations(ST template, EModelElement element) {
        AnnotationSources.getAnnotations(element).forEach(anno -> {
            template.add("subElement", annoToString(anno).trim());
        });
    }

    private Object invariantToString(EAnnotation invAnno) {
        ST template = templateGroup.getInstanceOf("inv");
        EMap<String, String> details = invAnno.getDetails();
        template.add("isCallable", Boolean.parseBoolean(AIEConstants.CALLABLE.toString()));
        template.add("name", details.get(AIEConstants.NAME.toString()));
        template.add("message", details.get(AIEConstants.MESSAGE.toString()));
        template.add("formula", details.get(AIEConstants.FORMULA.toString()));
        return template.render().trim();
    }

    private String packageToString(EPackage ePackage) {
        ST template = templateGroup.getInstanceOf("package");
        template.add("visibility", getVisibility(ePackage));
        template.add("name", ePackage.getName());
        template.add("prefix", ePackage.getNsPrefix());
        template.add("namespace", ePackage.getNsURI());
        for (EClassifier eClassifier : ePackage.getEClassifiers()) {
            template.add("subElement", classifierToString(eClassifier));
        }
        for (EPackage subPackage : ePackage.getESubpackages()) {
            template.add("subElement", packageToString(subPackage));
        }
        AnnotationSources.getInvariants(ePackage).forEach(invAnno -> {
            template.add("subElement", invariantToString(invAnno));
        });
        addAnnotations(template, ePackage);
        return template.render().trim();
    }

    private String datatypeToString(EDataType eDataType) {
        ST template = templateGroup.getInstanceOf("datatype");
        template.add("visibility", getVisibility(eDataType));
        template.add("isPrimitive", AnnotationSources.isPrimitive(eDataType));
        // template.add("nullable", AnnotationSources.isNullable(eDataType));
        template.add("name", eDataType.getName());
        for (ETypeParameter typeParameter : eDataType.getETypeParameters()) {
            template.add("typeParameter", typeParameterToString(typeParameter));
        }
        template.add("instanceName", eDataType.getInstanceClassName());
        if (!eDataType.isSerializable())
            template.add("isSerializable", AIEConstants.NOT_SERIALIZABLE.toString());
        AnnotationSources.getInvariants(eDataType).forEach(invAnno -> {
            template.add("subElement", invariantToString(invAnno));
        });
        addAnnotations(template, eDataType);
        return template.render().trim();
    }

    private String enumToString(EEnum eEnum) {
        ST template = templateGroup.getInstanceOf("enum");
        template.add("visibility", getVisibility(eEnum));
        template.add("name", eEnum.getName());
        for (ETypeParameter typeParameter : eEnum.getETypeParameters()) {
            template.add("typeParameter", typeParameterToString(typeParameter));
        }
        template.add("instanceName", eEnum.getInstanceClassName());
        if (!eEnum.isSerializable())
            template.add("isSerializable", AIEConstants.NOT_SERIALIZABLE.toString());
        AnnotationSources.getInvariants(eEnum).forEach(invAnno -> {
            template.add("subElement", invariantToString(invAnno));
        });
        for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {
            template.add("subElement", enumLiteralToString(eEnumLiteral));
        }
        addAnnotations(template, eEnum);
        return template.render().trim();
    }

    private String enumLiteralToString(EEnumLiteral literal) {
        ST template = templateGroup.getInstanceOf("enumLiteral");
        template.add("name", literal.getName());
        template.add("enumValue", literal.getValue());
        addAnnotations(template, literal);
        return template.render().trim();
    }

    private String classToString(EClass eClass) {
        ST template = templateGroup.getInstanceOf("class");
        template.add("visibility", getVisibility(eClass));
        template.add("isAbstract", eClass.isAbstract());
        template.add("isInterface", eClass.isInterface());
        template.add("name", eClass.getName());
        for (ETypeParameter typeParameter : eClass.getETypeParameters()) {
            template.add("typeParameter", typeParameterToString(typeParameter));
        }
        template.add("instanceName", eClass.getInstanceClassName());
        for (EGenericType genericSuperClass : eClass.getEGenericSuperTypes()) {
            template.add("superClass", genericTypeToString(genericSuperClass));
        }
        eClass.getEAttributes().forEach(attr -> {
            template.add("subElement", attrToString(attr));
        });
        eClass.getEOperations().forEach(op -> {
            template.add("subElement", operationToString(op));
        });
        eClass.getEReferences().forEach(eRef -> {
            template.add("subElement", referenceToString(eRef));
        });
        AnnotationSources.getInvariants(eClass).forEach(invAnno -> {
            template.add("subElement", invariantToString(invAnno));
        });
        addAnnotations(template, eClass);
        return template.render().trim();
    }

    private Object typeParameterToString(ETypeParameter typeParameter) {
        ST template = templateGroup.getInstanceOf("typeParameter");
        template.add("name", typeParameter.getName());
        for (EGenericType genericType : typeParameter.getEBounds()) {
            template.add("eBound", genericTypeToString(genericType));
        }
        return template.render().trim();
    }

    private String genericTypeToString(EGenericType genericType) {
        ST template = templateGroup.getInstanceOf("genericType");

        if (genericType.getEClassifier() != null) {
            template.add("classifier", getTypeName(genericType, genericType.getEClassifier()));
        } else if (genericType.getETypeParameter() != null) {
            template.add("typeParameter", genericType.getETypeParameter().getName());
        } else {
            if (genericType.getEUpperBound() != null) {
                template.add("upperBound", genericTypeToString(genericType.getEUpperBound()));
            } else if (genericType.getELowerBound() != null) {
                template.add("lowerBound", genericTypeToString(genericType.getELowerBound()));
            }
        }
        for (EGenericType eTypeArgument : genericType.getETypeArguments()) {
            template.add("typeArgument", genericTypeToString(eTypeArgument));
        }

        return template.render().trim();
    }

    private String operationToString(EOperation op) {
        ST template = templateGroup.getInstanceOf("op");
        template.add("visibility", getVisibility(op));
        template.add("isStatic", AnnotationSources.isStatic(op));
        // template.add("nullable", AnnotationSources.isNullable(op));
        for (ETypeParameter typeParameter : op.getETypeParameters()) {
            template.add("typeParameter", typeParameterToString(typeParameter));
        }
        template.add("name", op.getName());
        if (op.getEGenericType() != null) {
            template.add("type", genericTypeToString(op.getEGenericType()));
            template.add("multiplicity", getMultiplicity(op));
            template.add("qualifier", getQualifiers(op));
        }
        op.getEGenericExceptions().forEach(eGenericException -> {
            template.add("throws", genericTypeToString(eGenericException));
        });
        op.getEParameters().forEach(param -> {
            template.add("params", paramToString(param));
        });

        AnnotationSources.getPreconditions(op).forEach(anno -> {
            template.add("subElement", preconditionToString(anno));
        });
        AnnotationSources.getBodyExpressions(op).forEach(anno -> {
            template.add("subElement", bodyToString(anno));
        });
        AnnotationSources.getPostconditions(op).forEach(anno -> {
            template.add("subElement", postconditionToString(anno));
        });

        addAnnotations(template, op);
        return template.render().trim();
    }

    private String paramToString(EParameter param) {
        ST template = templateGroup.getInstanceOf("opParameter");
        // template.add("nullable", AnnotationSources.isNullable(param));
        template.add("name", param.getName());
        if (param.getEGenericType() != null) {
            template.add("type", genericTypeToString(param.getEGenericType()));
            template.add("multiplicity", getMultiplicity(param));
        }
        template.add("qualifier", getQualifiers(param));
        addAnnotations(template, param);
        return template.render();
    }

    private String postconditionToString(EAnnotation eAnnotation) {
        ST template = templateGroup.getInstanceOf("postcondition");
        EMap<String, String> details = eAnnotation.getDetails();
        template.add("name", details.get(AIEConstants.NAME.toString()));
        template.add("message", details.get(AIEConstants.MESSAGE.toString()));
        template.add("formula", details.get(AIEConstants.FORMULA.toString()));
        return template.render().trim();
    }

    private Object bodyToString(EAnnotation eAnnotation) {
        ST template = templateGroup.getInstanceOf("body");
        EMap<String, String> details = eAnnotation.getDetails();
        template.add("name", details.get(AIEConstants.NAME.toString()));
        template.add("expression", details.get(AIEConstants.EXPRESSION.toString()));
        return template.render().replace("  ", "");
    }

    private String preconditionToString(EAnnotation invAnno) {
        ST template = templateGroup.getInstanceOf("precondition");
        EMap<String, String> details = invAnno.getDetails();
        template.add("name", details.get(AIEConstants.NAME.toString()));
        template.add("message", details.get(AIEConstants.MESSAGE.toString()));
        template.add("formula", details.get(AIEConstants.FORMULA.toString()));
        return template.render().trim();
    }

    private String referenceToString(EReference eRef) {
        ST template = templateGroup.getInstanceOf("ref");
        template.add("visibility", getVisibility(eRef));
        template.add("isStatic", AnnotationSources.isStatic(eRef));
        template.add("transient", eRef.isTransient());
        template.add("volatile", eRef.isVolatile());
        template.add("model", eRef.getEAnnotation(AnnotationSources.MODEL) != null);
        template.add("ghost", eRef.getEAnnotation(AnnotationSources.GHOST) != null);
        // template.add("nullable", AnnotationSources.isNullable(eRef));
        template.add("readonly", !eRef.isChangeable());
        template.add("name", eRef.getName());
        if (eRef.getEOpposite() != null)
            template.add("opposite", eRef.getEOpposite().getName());
        template.add("defaultValue", eRef.getDefaultValueLiteral());
        if (eRef.getEGenericType() != null) {
            template.add("type", genericTypeToString(eRef.getEGenericType()));
            template.add("multiplicity", getMultiplicity(eRef));
        }
        template.add("qualifier", getQualifiers(eRef));
        addAnnotations(template, eRef);
        addReferenceKeys(template, eRef);
        addSFExpressions(template, eRef);
        return template.render().trim();
    }

    private void addReferenceKeys(ST refTemplate, EReference eRef) {
        if (eRef.getEKeys().isEmpty())
            return;
        ST template = templateGroup.getInstanceOf("referenceKey");
        eRef.getEKeys().forEach(attr -> {
            template.add("referredKeys", attr.getName());
        });
        refTemplate.add("subElement", template.render());
    }

    private void addSFExpressions(ST template, EStructuralFeature sf) {
        EAnnotation derivationAnno = sf.getEAnnotation(AnnotationSources.DERIVATION);
        if (derivationAnno != null && !derivationAnno.getDetails().isEmpty())
            template.add("subElement", derivationToString(derivationAnno));
        else {
            EAnnotation initialAnno = sf.getEAnnotation(AnnotationSources.INITIAL);
            if (initialAnno != null && !initialAnno.getDetails().isEmpty())
                template.add("subElement", initialToString(initialAnno));
        }
    }

    private Object initialToString(EAnnotation eAnnotation) {
        ST template = templateGroup.getInstanceOf("initial");
        template.add("name", eAnnotation.getDetails().get("name"));
        template.add("expression", eAnnotation.getDetails().get("expression"));
        return template.render();
    }

    private String derivationToString(EAnnotation eAnnotation) {
        ST template = templateGroup.getInstanceOf("derivation");
        template.add("name", eAnnotation.getDetails().get("name"));
        template.add("expression", eAnnotation.getDetails().get("expression"));
        return template.render();
    }

    private String attrToString(EAttribute eAttr) {
        ST template = templateGroup.getInstanceOf("attr");
        template.add("visibility", getVisibility(eAttr));
        template.add("isStatic", AnnotationSources.isStatic(eAttr));
        template.add("transient", eAttr.isTransient());
        template.add("volatile", eAttr.isVolatile());
        template.add("model", eAttr.getEAnnotation(AnnotationSources.MODEL) != null);
        template.add("ghost", eAttr.getEAnnotation(AnnotationSources.GHOST) != null);
        // template.add("nullable", AnnotationSources.isNullable(eAttr));
        template.add("readonly", !eAttr.isChangeable());
        template.add("name", eAttr.getName());
        if (eAttr.getEGenericType() != null) {
            template.add("type", genericTypeToString(eAttr.getEGenericType()));
            template.add("multiplicity", getMultiplicity(eAttr));
            template.add("defaultValue", eAttr.getDefaultValueLiteral());
        }
        template.add("qualifier", getQualifiers(eAttr));
        addAnnotations(template, eAttr);
        addSFExpressions(template, eAttr);
        return template.render().trim();
    }

    private String annoToString(EAnnotation eAnnotation) {
        ST template = templateGroup.getInstanceOf("anno");
        template.add("name", eAnnotation.getSource());
        eAnnotation.getDetails().forEach(entry -> {
            template.add("detail", edetailToString(entry.getKey(), entry.getValue()));
        });
        eAnnotation.getReferences().forEach(ref -> {
            if (!(ref instanceof EAnnotation))
                template.add("subElement", "reference " + getQualifiedName(eAnnotation, ref) + ";");
        });
        eAnnotation.getContents().forEach(eObject -> {
            String subElement = eObjectToString(eObject);
            template.add("subElement", subElement);
        });
        addAnnotations(template, eAnnotation);
        return template.render().trim();
    }


    private String edetailToString(String name, String value) {
        ST template = templateGroup.getInstanceOf("edetail");
        template.add("name", name);
        template.add("val", value);
        return template.render();
    }

    private String importsToString() {
        StringBuilder importsBuilder = new StringBuilder();
        imports.entrySet().forEach(entry -> {
            ST template = templateGroup.getInstanceOf("load");
            template.add("namespace", entry.getKey());
            template.add("name", entry.getValue());
            importsBuilder.append(template.render().trim());
            importsBuilder.append("\n");
        });
        if (importsBuilder.length() > 0)
            importsBuilder.append("\n");
        return importsBuilder.toString();
    }

    private boolean isInSamePackage(EObject obj1, EObject obj2) {
        EPackage pac1 = getContainerPackage(obj1);
        EPackage pac2 = getContainerPackage(obj2);
        return pac1 != null && pac2 != null && pac1.equals(pac2);
    }

    private EPackage getContainerPackage(EObject obj) {
        try {
            EObject container = obj;
            while (container.eContainer() != null && !(container instanceof EPackage)) {
                container = container.eContainer();
            }
            return (EPackage) container;
        } catch (ClassCastException e) {
            return null;
        }
    }

    private String getQualifiedName(EObject rel, EObject eObject) {
        if (eObject == null && !(eObject instanceof ENamedElement)) // No annotation allowed
            return "";

        if (!root.equals(EcoreUtil.getRootContainer(eObject, true)))
            return getImportedQualifiedName(eObject);

        // Annotation references must be fully qualified
        boolean relative = isInSamePackage(rel, eObject) && !(rel instanceof EAnnotation);
        ENamedElement element = (ENamedElement) eObject;
        EPackage relPackage = getContainerPackage(rel);

        String qualifiedName = "";
        ENamedElement container = (ENamedElement) eObject.eContainer();
        List<String> containerNames = new ArrayList<>();

        while (container != null) {
            if (relative && container.equals(relPackage))
                break;
            containerNames.add(container.getName());
            container = (ENamedElement) container.eContainer();
        }

        Collections.reverse(containerNames);
        qualifiedName = String.join(AIEConstants.SEPARATOR, containerNames);

        String lastSeperator = getSeperator(eObject);
        qualifiedName +=
                qualifiedName.isEmpty() ? element.getName() : lastSeperator + element.getName();

        return qualifiedName;
    }

    private String getImportedQualifiedName(EObject eObject) {
        String packageName = imports.get(getLocation(eObject));
        if (packageName == null) {
            // Use file name
            packageName = EcoreUtil.getURI(eObject).trimFileExtension().lastSegment();
            imports.put(getLocation(eObject), packageName);
        }
        return packageName + AIEConstants.SEPARATOR
                + EcoreUtil.getURI(eObject).fragment().replace("//", "")
                .replaceAll("/([^/]*)$", getSeperator(eObject) + "$1")
                .replaceAll("/", AIEConstants.SEPARATOR);
    }

    private String getSeperator(EObject eObject) {
        // if (eObject instanceof EStructuralFeature)
        // return AIEConstants.SEPARATOR;
        // if (eObject instanceof EOperation)
        // return AIEConstants.SEPARATOR;
        // if (eObject instanceof EClassifier)
        // return AIEConstants.SEPARATOR;
        return AIEConstants.SEPARATOR;
    }

    private String getLocation(EObject eObject) {
        URI rootURI = EcoreUtil.getURI(root).trimFragment();
        URI uri = EcoreUtil.getURI(eObject).trimFragment().deresolve(rootURI, true, true, true);
        if (uri.isFile())
            return uri.toFileString();
        else
            return uri.toString();
    }

    private String getTypeName(EObject rel, EClassifier eClassifier) {
        String type = getQualifiedName(rel, eClassifier);
        if (type != null) {
            for (Entry<String, String> e : primitives.entrySet()) {
                if (type.equals(e.getKey())) {
                    return e.getValue();
                }
            }
        }
        return type;
    }

    private String getMultiplicity(ETypedElement eTypedElement) {
        int l = eTypedElement.getLowerBound();
        int u = eTypedElement.getUpperBound();
        String mul = null;
        if (l == 0 && u == 1)
            mul = "?";
        else if (l == 0 && u == -1)
            mul = "*";
        else if (l == 1 && u == -1)
            mul = "+";
        else if (l == u && l != 1)
            mul = l + "";
        else if (!(l == 1 && u == 1))
            mul = l + ".." + u;

        if (mul != null && AnnotationSources.isNullable(eTypedElement))
            mul += "|?";

        return mul != null ? mul.replace("-1", "*") : mul;
    }

    private String getVisibility(ENamedElement element) {
        String visibility = "";
        EAnnotation visibilityAnno = element.getEAnnotation(VISIBILITY);
        if (visibilityAnno != null && !visibilityAnno.getDetails().isEmpty())
            visibility = visibilityAnno.getDetails().get(AIEConstants.VISIBILITY.toString());
        return visibility;
    }

    private String getQualifiers(ETypedElement element) {
        StringBuilder builder = new StringBuilder();
        if (!element.isUnique() && (element.getUpperBound() > 1 || element.getUpperBound() == -1))
            builder.append(AIEConstants.NOT_UNIQUE + " ");
        if (element.isOrdered() && (element.getUpperBound() > 1 || element.getUpperBound() == -1))
            builder.append(AIEConstants.ORDERED + " ");

        if (element instanceof EStructuralFeature)
            appendSFQualifiers(builder, (EStructuralFeature) element);

        // Wrap with curly bracket
        if (builder.length() > 0) {
            builder.insert(0, " { ");
            builder.append("}");
        }
        return builder.toString();
    }

    private void appendSFQualifiers(StringBuilder builder, EStructuralFeature eStructuralFeature) {
        if (eStructuralFeature.isDerived())
            builder.append(AIEConstants.DERIVED + " ");
        if (eStructuralFeature.isUnsettable())
            builder.append(AIEConstants.UNSETTABLE + " ");

        if (eStructuralFeature instanceof EAttribute && ((EAttribute) eStructuralFeature).isID())
            builder.append(AIEConstants.ID + " ");

        if (eStructuralFeature instanceof EReference) {
            if (!((EReference) eStructuralFeature).isResolveProxies())
                builder.append(AIEConstants.NOT_RESOLVE + " ");
            if (((EReference) eStructuralFeature).isContainment())
                builder.append(AIEConstants.COMPOSES + " ");
        }
    }

}
