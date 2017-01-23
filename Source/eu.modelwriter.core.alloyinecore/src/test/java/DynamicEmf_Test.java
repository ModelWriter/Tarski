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

/**
 * Created by ferhat on 12/20/16.
 */

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class DynamicEmf_Test {

    private static String getQualifiedName(EPackage pkg) {
        return pkg.getESuperPackage() == null ? pkg.getName() : getQualifiedName(pkg.getESuperPackage()) + "." + pkg.getName();
    }

    private static String getQualifiedName(EClassifier cls) {
        return getQualifiedName(cls.getEPackage()) + "." + cls.getName();
    }

    private static String getQualifiedName(EStructuralFeature sf) {
        return getQualifiedName(sf.getEContainingClass()) + "::" + sf.getName();
    }

    public static void main(final String[] args) {
        /*
        * Instantiate EcoreFactory
        */
        EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;

        /*
        * Create EClass instance to model BookStore class
        */
        EClass bookStoreEClass = theCoreFactory.createEClass();
        bookStoreEClass.setName("BookStore");
        bookStoreEClass.setInstanceClassName("instanceClass");

        EAnnotation annotation1 = theCoreFactory.createEAnnotation();
        bookStoreEClass.getEAnnotations().add(annotation1);
        annotation1.setSource("modelwriter/Ferhat");
        annotation1.getDetails().put(null, "value");
        EClass annotationClass = theCoreFactory.createEClass();
        annotationClass.setName("AnnotationClass");
        annotation1.getContents().add(annotationClass);

        /*
        * Create EClass instance to model Book class
        */
        EClass bookEClass = theCoreFactory.createEClass();
        bookEClass.setName("Book");
        bookEClass.setAbstract(false);
        annotation1.getReferences().add(bookEClass);

        /*
        * Instantiate EPackage and provide unique URI
        * to identify this package
        */
        EPackage bookStoreEPackage = theCoreFactory.createEPackage();
        bookStoreEPackage.setName("BookStorePackage");
        bookStoreEPackage.setNsPrefix("bookStore");
        bookStoreEPackage.setNsURI("http:///com.ibm.dynamic.example.bookstore.ecore");


//        EPackage innerEPackage = theCoreFactory.createEPackage();
//        innerEPackage.setName("TypeParameterTest1");
//        innerEPackage.setNsPrefix("Type1");
//        innerEPackage.setNsURI("http:///com.ibm.dynamic.example.bookstore.Type1.ecore");
//        EClass x = theCoreFactory.createEClass();
//        x.setName("XClass");
//        innerEPackage.getEClassifiers().add(x);
//        EClass y = theCoreFactory.createEClass();
//        y.setName("YClass");
//        innerEPackage.getEClassifiers().add(y);
//        EClass z = theCoreFactory.createEClass();
//        z.setName("ZClass");
//        innerEPackage.getEClassifiers().add(z);
//        ETypeParameter t = theCoreFactory.createETypeParameter(); t.setName("T");
//        ETypeParameter k = theCoreFactory.createETypeParameter(); k.setName("K");
//        x.getETypeParameters().add(t);
//        x.getETypeParameters().add(k);
//        EGenericType gt_Y = theCoreFactory.createEGenericType();
//        gt_Y.setEClassifier(y);
//        EGenericType gt_Z = theCoreFactory.createEGenericType();
//        gt_Z.setEClassifier(z);
//        k.getEBounds().add(gt_Y);
//        k.getEBounds().add(gt_Z);

        EPackage innerEPackage = theCoreFactory.createEPackage();
        innerEPackage.setName("TypeParameterTest1");
        innerEPackage.setNsPrefix("Type1");
        innerEPackage.setNsURI("http:///com.ibm.dynamic.example.bookstore.Type1.ecore");
        EClass x = theCoreFactory.createEClass();
        x.setName("XClass");
        innerEPackage.getEClassifiers().add(x);
        EClass y = theCoreFactory.createEClass();
        y.setName("YClass");
        innerEPackage.getEClassifiers().add(y);
        EClass z = theCoreFactory.createEClass();
        z.setName("ZClass");
        innerEPackage.getEClassifiers().add(z);
        ETypeParameter t = theCoreFactory.createETypeParameter(); t.setName("T");
        ETypeParameter k = theCoreFactory.createETypeParameter(); k.setName("K");
        x.getETypeParameters().add(t);
        x.getETypeParameters().add(k);
        EGenericType gt_Y = theCoreFactory.createEGenericType();
        gt_Y.setEClassifier(y);
        EGenericType gt_Z = theCoreFactory.createEGenericType();
        gt_Z.setEClassifier(z);
        k.getEBounds().add(gt_Y);
        k.getEBounds().add(gt_Z);


        EAttribute innerAttribute = theCoreFactory.createEAttribute();
        innerAttribute.setName("owner");
        innerAttribute.setEType(EcorePackage.eINSTANCE.getEString());

        x.getEStructuralFeatures().add(innerAttribute);

        bookStoreEPackage.getESubpackages().add(innerEPackage);

        System.out.println(getQualifiedName(innerEPackage));
        System.out.println(getQualifiedName(innerAttribute));


        /*
        * Instantiate EcorePackage
        */
        EcorePackage theCorePackage = EcorePackage.eINSTANCE;

        /*
        * Create attributes for BookStore class as specified in the model
        */

        EAttribute bookStoreOwner = theCoreFactory.createEAttribute();
        bookStoreOwner.setName("owner");
        bookStoreOwner.setEType(theCorePackage.getEString());
        EAttribute bookStoreLocation = theCoreFactory.createEAttribute();
        bookStoreLocation.setName("location");
        bookStoreLocation.setEType(theCorePackage.getEString());
        EReference bookStore_Books = theCoreFactory.createEReference();
        bookStore_Books.setName("books");
        bookStore_Books.setEType(bookEClass);
        bookStore_Books.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
        bookStore_Books.setContainment(true);

        EOperation op = theCoreFactory.createEOperation();





        /*
        * Create attributes for Book class as defined in the model
        */
        EAttribute bookName = theCoreFactory.createEAttribute();
        bookName.setName("name");
        bookName.setEType(theCorePackage.getEString());
        EAttribute bookISBN = theCoreFactory.createEAttribute();
        bookISBN.setName("isbn");
        bookISBN.setEType(theCorePackage.getEInt());

        /*
        * Add owner, location and books attributes/references
        * to BookStore class
        */
        bookStoreEClass.getEStructuralFeatures().add(bookStoreOwner);
        bookStoreEClass.getEStructuralFeatures().add(bookStoreLocation);
        bookStoreEClass.getEStructuralFeatures().add(bookStore_Books);




        /*
        * Add name and isbn attributes to Book class
        */
        bookEClass.getEStructuralFeatures().add(bookName);
        bookEClass.getEStructuralFeatures().add(bookISBN);

        /*
        * Place BookStore and Book classes in bookStoreEPackage
        */
        bookStoreEPackage.getEClassifiers().add(bookStoreEClass);
        bookStoreEPackage.getEClassifiers().add(bookEClass);

        ResourceSet metaResourceSet = new ResourceSetImpl();

        /*
        * Register XML Factory implementation to handle .ecore files
        */
        metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
                "ecore", new XMLResourceFactoryImpl());

        /*
        * Create empty resource with the given URI
        */
        Resource metaResource = metaResourceSet.createResource(URI.createURI("./src/test/resources/out/bookstore.ecore"));

        /*
        * Add bookStoreEPackage to contents list of the resource
        */
        metaResource.getContents().add(bookStoreEPackage);

        try {
            /*
            * Save the resource
            */
            metaResource.save(null);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
