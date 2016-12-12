package eu.modelwriter.core.alloyinecore.example;

/**
 * This class provides methods for building an in-memory representation of the 
 * Ecore-based model dynamically.
 * 
 * @author Nidhi Singh, Rohit Babbar
 */

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class DynamicModelingEngine {

	EcoreFactory _coreFactory;
	EcorePackage _corePackage;
	EPackage _bookStoreEPackage;
	EClass _bookStoreEClass, _bookEClass;
	EAttribute _bookStoreOwner, _bookStoreLocation;
	EAttribute _bookName, _bookISBN;
	EReference _bookStore_Books;
	EObject _bookEObject, _bookStoreEObject;

	
	public DynamicModelingEngine() {
		// Instantiate EcoreFactory and EcorePackage
		_coreFactory = EcoreFactory.eINSTANCE;
		_corePackage = EcorePackage.eINSTANCE;
	}

	
	public void buildBookStoreModel() {
		createDynamicEClass();
		createDynamicEPackage();
		createDynamicEAttributes();
		// Place BookStore class and Book class in BookStorePackage
		_bookStoreEPackage.getEClassifiers().add(_bookStoreEClass);
		_bookStoreEPackage.getEClassifiers().add(_bookEClass);
		createDynamicInstances();
		setDynamicInstanceAttr();
		getDynamicInstanceAttr();
	}

	
	public void createDynamicEClass() {
		// Create EClass instance to model BookShop class
		_bookStoreEClass = _coreFactory.createEClass();
		_bookStoreEClass.setName("BookStore");
		// Create EClass instance to model Book class
		_bookEClass = _coreFactory.createEClass();
		_bookEClass.setName("Book");

	}

	
	public void createDynamicEAttributes() {
		// Create attributes for BookStore class
		_bookStoreOwner = _coreFactory.createEAttribute();
		_bookStoreOwner.setName("owner");
		_bookStoreOwner.setEType(_corePackage.getEString());
		_bookStoreLocation = _coreFactory.createEAttribute();
		_bookStoreLocation.setName("location");
		_bookStoreLocation.setEType(_corePackage.getEString());
		_bookStore_Books = _coreFactory.createEReference();
		_bookStore_Books.setName("books");
		_bookStore_Books.setEType(_bookEClass);
		_bookStore_Books
				.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		_bookStore_Books.setContainment(true);

		// Create attributes for Book class as defined in the model
		_bookName = _coreFactory.createEAttribute();
		_bookName.setName("name");
		_bookName.setEType(_corePackage.getEString());
		_bookISBN = _coreFactory.createEAttribute();
		_bookISBN.setName("isbn");
		_bookISBN.setEType(_corePackage.getEInt());

		// Associate owner, location and books attributes/references 
		// with BookStore class
		_bookStoreEClass.getEStructuralFeatures().add(_bookStoreOwner);
		_bookStoreEClass.getEStructuralFeatures().add(_bookStoreLocation);
		_bookStoreEClass.getEStructuralFeatures().add(_bookStore_Books);

		// Associate name and isbn attributes with Book class
		_bookEClass.getEStructuralFeatures().add(_bookName);
		_bookEClass.getEStructuralFeatures().add(_bookISBN);
	}

	
	public void createDynamicEPackage() {
		// Instantiate EPackage and provide unique URI to identify the package
		// instance
		_bookStoreEPackage = _coreFactory.createEPackage();
		_bookStoreEPackage.setName("BookStorePackage");
		_bookStoreEPackage.setNsPrefix("bookStore");
		_bookStoreEPackage
				.setNsURI("http:///com.ibm.dynamic.example.bookStore.ecore");
	}

	
	public void createDynamicInstances() {
		// Obtain factory instance from BookStorePackage
		EFactory bookFactoryInstance = _bookStoreEPackage.getEFactoryInstance();
		// Create dynamic instances of BookStore/Book class
		_bookEObject = bookFactoryInstance.create(_bookEClass);
		_bookStoreEObject = bookFactoryInstance.create(_bookStoreEClass);
	}

	
	public void setDynamicInstanceAttr() {
		// Set the values of BookStore instance attributes
		_bookStoreEObject.eSet(_bookStoreOwner, "David Brown");
		_bookStoreEObject.eSet(_bookStoreLocation, "Street#12, Top Town, NY");
		((List) _bookStoreEObject.eGet(_bookStore_Books)).add(_bookEObject);
		// Set the values of Book instance attributes
		_bookEObject.eSet(_bookName, "Harry Potter and the Deathly Hallows");
		_bookEObject.eSet(_bookISBN, 157221);
	}

	
	public void getDynamicInstanceAttr() {
		// Get the values of BookStore instance attributes
		String strOwner = (String) _bookStoreEObject.eGet(_bookStoreOwner);
		String strLocation = (String) _bookStoreEObject
				.eGet(_bookStoreLocation);
		// Get the values of Book instance attributes
		String strName = (String) _bookEObject.eGet(_bookName);
		Object iISBN = _bookEObject.eGet(_bookISBN);
	}

	
	public void loadModelInstance() {
		EList lstBookEObjects = null;
		EObject read_bookEObject = null;
		ResourceSet load_resourceSet = new ResourceSetImpl();

		// Register XML Factory implementation to handle .xml files
		load_resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap().put("xml",
						new XMLResourceFactoryImpl());

		// Add booksEPackage to package registry
		load_resourceSet.getPackageRegistry().put(
				"http:///com.ibm.dynamic.example.bookStore.ecore",
				_bookStoreEPackage);

		// Load the resource using the URI
		Resource load_resource = load_resourceSet.getResource(URI
				.createURI("./bookStore.xml"), true);

		// Read back the serialized instances of dynamic classes stored in the
		// resource
		EObject read_bookStoreEObject = (EObject) load_resource.getContents()
				.get(0);
		System.out.println("*******The BookStore Model********");
		System.out.println("Owner: "
				+ read_bookStoreEObject.eGet(_bookStoreOwner) + "\nLocation: "
				+ read_bookStoreEObject.eGet(_bookStoreLocation) + "\nBook:");

		lstBookEObjects = (EList) (read_bookStoreEObject.eGet(_bookStore_Books));
		for (int iBookObj = 0; iBookObj < lstBookEObjects.size(); iBookObj++) {
			read_bookEObject = (EObject) lstBookEObjects.get(iBookObj);
			System.out.println("    name: " + read_bookEObject.eGet(_bookName)
					+ "\n    isbn: " + read_bookEObject.eGet(_bookISBN));
		}
		System.out.println("*********************************");
	}

	
	public static void main(String[] args) {
		DynamicModelingEngine theModelingEngine = new DynamicModelingEngine();
		DynamicModelSerializer theModelSerializer = new DynamicModelSerializer();
		boolean isSchemaLocationPresent;
		theModelingEngine.buildBookStoreModel();

		/*
		 * If serialize and deserialize operations to be performed within this
		 * program, then invoke the following methods
		 */
		isSchemaLocationPresent = false;
		theModelSerializer.serializeModelInstance(
				theModelingEngine._bookStoreEObject, isSchemaLocationPresent);

		theModelingEngine.loadModelInstance();

		/*
		 * If serialize and deserialize operations to be performed in different
		 * program, then invoke the following methods
		 */

		isSchemaLocationPresent = true;
		theModelSerializer
				.serializeMetaModel(theModelingEngine._bookStoreEPackage);
		theModelSerializer.serializeModelInstance(
				theModelingEngine._bookStoreEObject, isSchemaLocationPresent);
		DynamicModelLoader theModelLoader = new DynamicModelLoader();
		theModelLoader.loadModelInstance();
	}

}
