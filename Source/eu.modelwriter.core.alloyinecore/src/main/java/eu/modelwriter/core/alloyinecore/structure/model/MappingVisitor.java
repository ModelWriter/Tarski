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

package eu.modelwriter.core.alloyinecore.structure.model;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Repository;
import org.eclipse.emf.ecore.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MappingVisitor extends AlloyInEcoreBaseVisitor<EObject>{

    final Repository repository;
    public MappingVisitor(Repository repository){
        this.repository = repository;
    }

    @Override
    public EClass visitEClass(AlloyInEcoreParser.EClassContext ctx) {
        final EClass eClass = ctx.element;
        if (ctx.eSuperTypes != null) {
            ctx.eSuperTypes.forEach(est -> {
                final EGenericType superType = visitEGenericSuperType(est);
                if (superType != null) {
                    eClass.getEGenericSuperTypes().add(superType);
                }
            });
        }
        return eClass;
    }

    @Override
    public EObject visitEAttribute(AlloyInEcoreParser.EAttributeContext ctx) {
        return super.visitEAttribute(ctx);
    }

    @Override
    public EObject visitEReference(AlloyInEcoreParser.EReferenceContext ctx) {
        return super.visitEReference(ctx);
    }

    @Override
    public EObject visitEOperation(AlloyInEcoreParser.EOperationContext ctx) {
        return super.visitEOperation(ctx);
    }

    @Override
    public EObject visitEGenericException(AlloyInEcoreParser.EGenericExceptionContext ctx) {
        return super.visitEGenericException(ctx);
    }

    @Override
    public EGenericType visitEGenericSuperType(AlloyInEcoreParser.EGenericSuperTypeContext ctx) {
        if (ctx.eGenericType != null) {
            return visitEGenericType(ctx.eGenericType);
        }
        return null;
    }

    @Override
    public EObject visitTemplateSignature(AlloyInEcoreParser.TemplateSignatureContext ctx) {
        return super.visitTemplateSignature(ctx);
    }

    @Override
    public EObject visitETypeParameter(AlloyInEcoreParser.ETypeParameterContext ctx) {
        return super.visitETypeParameter(ctx);
    }

    @Override
    public EGenericType visitEGenericTypeArgument(AlloyInEcoreParser.EGenericTypeArgumentContext ctx) {
        if (ctx.eGenericType != null) {
            return visitEGenericType(ctx.eGenericType);
        }
        if (ctx.eGenericWildcard != null) {
            return visitEGenericWildcard(ctx.eGenericWildcard);
        }
        return null;
    }

    @Override
    public EGenericType visitEGenericType(AlloyInEcoreParser.EGenericTypeContext ctx) {
        final EGenericType eGenericType = ctx.element;

        if (ctx.ownedPathName == null) {
            return null;
        }

        final EObject object = visitPathName(ctx.ownedPathName);
        if (object instanceof EClassifier) {
            eGenericType.setEClassifier((EClassifier) object);
        } else if (object instanceof ETypeParameter) {
            eGenericType.setETypeParameter((ETypeParameter) object);
        } else {
            return null;
        }

        if (ctx.ownedETypeArguments != null) {
            if (object instanceof EClassifier) {
                ctx.ownedETypeArguments.forEach(eta -> {
                    final EGenericType eGenericTypeArgument = visitEGenericTypeArgument(eta);
                    if (eGenericTypeArgument != null) {
                        eGenericType.getETypeArguments().add(eGenericTypeArgument);
                    }
                });
            }
        }

        return eGenericType;
    }

    @Override
    public EGenericType visitEGenericWildcard(AlloyInEcoreParser.EGenericWildcardContext ctx) {
        final EGenericType eGenericType = ctx.element;

        if (ctx.ownedExtend != null) {
            final EGenericType boundType = visitEGenericType(ctx.ownedExtend);
            if (boundType != null) {
                if (ctx.bound != null) {
                    if (ctx.bound.getText().equals("extends")) {
                        eGenericType.setEUpperBound(boundType);
                    } else if (ctx.bound.getText().equals("super")) {
                        eGenericType.setELowerBound(boundType);
                    }
                }
            }
        }

        return eGenericType;
    }

    @Override
    public EObject visitPathName(AlloyInEcoreParser.PathNameContext ctx) {
        String rootElementName;
        final List<String> relativePathFragments =
                new ArrayList<>(Arrays.asList(ctx.getText().split("::")));

        if (repository.name2Import.containsKey(ctx.firstSegment.getText())) { // full path
            rootElementName = ctx.firstSegment.getText();
            relativePathFragments.remove(0); // root is unnecessary.

            return repository.getEObject(rootElementName, relativePathFragments);
        } else { // relative path
            rootElementName = repository.getRootPackage().getName();

            //TODO buradan emin degilim
            final List<String> complementPathFragments = new ArrayList<>(Arrays.asList(ctx.owner.getUniqueName().split("::")));
                    //qualifiedNameStack.stream().collect(Collectors.toList());
            complementPathFragments.remove(0); // root is unnecessary.

            // 1. trying to find inner reference (like reference to TypeParameter):
            final List<String> tempFragments = new ArrayList<>(relativePathFragments);
            tempFragments.addAll(0, complementPathFragments);
            final EObject result = repository.getEObject(rootElementName, tempFragments);
            if (result != null) {
                return result;
            }

            // 2. trying to find outer reference (like reference to sibling et cetera.)
            complementPathFragments.remove(complementPathFragments.size() - 1);
            // first remove reference holder (last item of qualified name stack.).
            relativePathFragments.addAll(0, complementPathFragments);
            return repository.getEObject(rootElementName, relativePathFragments);
        }
    }

    @Override
    public EObject visitSegment(AlloyInEcoreParser.SegmentContext ctx) {
        return super.visitSegment(ctx);
    }

    @Override
    public EObject visitEPrimitiveType(AlloyInEcoreParser.EPrimitiveTypeContext ctx) {
        return super.visitEPrimitiveType(ctx);
    }
}
