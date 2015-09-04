/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
/**
 */
package Marker.tests;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import Marker.MarkElement;
import Marker.MarkElementCollection;
import Marker.MarkerFactory;

/**
 * <!-- begin-user-doc --> A sample utility for the '<em><b>Marker</b></em>' package. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class MarkerExample {
  /**
   * <!-- begin-user-doc --> Load all the argument file paths or URIs as instances of the model.
   * <!-- end-user-doc -->
   * 
   * @param args the file paths or URIs.
   * @generated
   */
  public static void main(String[] args) {


    MarkerFactory factory = MarkerFactory.eINSTANCE;

    MarkElement markElement1 = factory.createMarkElement();
    MarkElement markElement2 = factory.createMarkElement();
    MarkElement markElement3 = factory.createMarkElement();
    MarkElement markElement4 = factory.createMarkElement();

    markElement1.setId("123");
    markElement2.setId("124");
    markElement3.setId("125");
    markElement4.setId("126");



    // Create a resource set.
    ResourceSet resourceSet = new ResourceSetImpl();
    // Register the default resource factory -- only needed for stand-alone!
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    // Get the URI of the model file.
    URI fileURI = URI.createFileURI(new File("./markelements.xmi").getAbsolutePath());
    // Create a resource for this file.
    Resource resource = resourceSet.createResource(fileURI);
    // Add the book and writer objects to the contents.

    /*
     * Create empty resource with the given URI
     */
    MarkElementCollection res = factory.createMarkElementCollection();

    markElement1.getTarget().add(markElement3);
    markElement1.getTarget().add(markElement4);

    res.getMarkElements().add(markElement1);
    res.getMarkElements().add(markElement2);
    res.getMarkElements().add(markElement3);
    res.getMarkElements().add(markElement4);

    resource.getContents().add(res);

    HashMap<String, Object> options = new HashMap<String, Object>();

    options.put(XMIResource.OPTION_SCHEMA_LOCATION, true);


    // Save the contents of the resource to the file system.
    try {
      resource.save(options);
    } catch (IOException e) {
    }

    deSerialization();



    // // Create a resource set to hold the resources.
    // //
    // ResourceSet resourceSet = new ResourceSetImpl();
    //
    // // Register the appropriate resource factory to handle all file extensions.
    // //
    // resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
    // (Resource.Factory.Registry.DEFAULT_EXTENSION,
    // new XMIResourceFactoryImpl());
    //
    // // Register the package to ensure it is available during loading.
    // //
    // resourceSet.getPackageRegistry().put
    // (MarkerPackage.eNS_URI,
    // MarkerPackage.eINSTANCE);
    //
    // // If there are no arguments, emit an appropriate usage message.
    // //
    // if (args.length == 0) {
    // System.out.println("Enter a list of file paths or URIs that have content like this:");
    // try {
    // Resource resource = resourceSet.createResource(URI.createURI("http:///My.marker"));
    // MarkElement root = MarkerFactory.eINSTANCE.createMarkElement();
    // resource.getContents().add(root);
    // resource.save(System.out, null);
    // }
    // catch (IOException exception) {
    // exception.printStackTrace();
    // }
    // }
    // else {
    // // Iterate over all the arguments.
    // //
    // for (int i = 0; i < args.length; ++i) {
    // // Construct the URI for the instance file.
    // // The argument is treated as a file path only if it denotes an existing file.
    // // Otherwise, it's directly treated as a URL.
    // //
    // File file = new File(args[i]);
    // URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()): URI.createURI(args[i]);
    //
    // try {
    // // Demand load resource for this file.
    // //
    // Resource resource = resourceSet.getResource(uri, true);
    // System.out.println("Loaded " + uri);
    //
    // // Validate the contents of the loaded resource.
    // //
    // for (EObject eObject : resource.getContents()) {
    // Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
    // if (diagnostic.getSeverity() != Diagnostic.OK) {
    // printDiagnostic(diagnostic, "");
    // }
    // }
    // }
    // catch (RuntimeException exception) {
    // System.out.println("Problem loading " + uri);
    // exception.printStackTrace();
    // }
    // }
    // }
  }

  protected static void deSerialization() {
    // Create a resource set.
    ResourceSet resourceSet = new ResourceSetImpl();
    // Register the default resource factory -- only needed for stand-alone!
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    // Get the URI of the model file.
    URI fileURI = URI.createFileURI(new File("./markelements.xmi").getAbsolutePath());
    // Demand load the resource for this file.
    Resource resource = resourceSet.getResource(fileURI, true);

    MarkElementCollection collection = (MarkElementCollection) resource.getContents().get(0);

    collection.getMarkElements().get(0).setMessage("DENEME");

    // Print the contents of the resource to System.out.
    try {
      resource.save(System.out, Collections.EMPTY_MAP);
    } catch (IOException e) {
    }
  }



  /**
   * <!-- begin-user-doc --> Prints diagnostics with indentation. <!-- end-user-doc -->
   * 
   * @param diagnostic the diagnostic to print.
   * @param indent the indentation for printing.
   * @generated
   */
  protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
    System.out.print(indent);
    System.out.println(diagnostic.getMessage());
    for (Diagnostic child : diagnostic.getChildren()) {
      printDiagnostic(child, indent + "  ");
    }
  }

} // MarkerExample
