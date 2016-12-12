package eu.modelwriter.core.alloyinecore.example;

/**
 * This class provides methods to serialize the Ecore-based model and 
 * the model instance.
 * 
 * @author Nidhi Singh, Rohit Babbar
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class DynamicModelSerializer {

	public void serializeModelInstance(EObject bookStoreEObject,
			boolean isSchemaLocationPresent) {

		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML Factory implementation to handle .xml files
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xml", new XMLResourceFactoryImpl());

		// Create empty resource with the given URI
		Resource resource = resourceSet.createResource(URI
				.createURI("./bookStore.xml"));

		// Add bookStoreObject to contents list of the resource
		resource.getContents().add(bookStoreEObject);
		Map options = new HashMap();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

		try {
			// Save the resource
			if (isSchemaLocationPresent == true)
				resource.save(options);
			else
				resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void serializeMetaModel(EPackage bookStoreEPackage) {

		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML Factory implementation to handle .ecore files
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("ecore", new XMLResourceFactoryImpl());

		// Create empty resource with the given URI
		Resource resource = resourceSet.createResource(URI
				.createURI("./bookStore.ecore"));

		// Add bookStoreEPackage to contents list of the resource
		resource.getContents().add(bookStoreEPackage);

		try {
			// Save the resource
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
