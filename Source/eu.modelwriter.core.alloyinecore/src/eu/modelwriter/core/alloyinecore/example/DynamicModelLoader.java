package eu.modelwriter.core.alloyinecore.example;

/**
 * This class provides methods to deserialize/load the serialized instances of 
 * Ecore-based model.
 * 
 * @author Nidhi Singh, Rohit Babbar
 */

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class DynamicModelLoader {

	private static final String BOOKSTORE_CLASS_IDENTIFIER = "BookStore";
	private static final String BOOK_CLASS_IDENTIFIER = "Book";

	private EObject BookStoreEObject;
	private EClass BookStoreEClass, BookEClass;
	private EList lstBookStoreAttributes, lstBookStoreReferences;
	private EAttribute bookStore_Attribute;
	private EReference bookStore_Reference;
	private EAttribute book_Attribute;
	private EList lstBookEObjects, lstBookAttributes;

	public void loadModelInstance() {

		ResourceSet load_resourceSet = new ResourceSetImpl();

		// Register XML Factory implementation to handle files with any
		// extension
		load_resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap().put("*",
						new XMLResourceFactoryImpl());

		// Create empty resource with the given URI
		Resource load_resource = load_resourceSet.getResource(URI
				.createURI("./bookStore.xml"), true);

		BookStoreEObject = load_resource.getContents().get(0);
		BookStoreEClass = BookStoreEObject.eClass();

		if (BookStoreEClass.getName().equals(BOOKSTORE_CLASS_IDENTIFIER)) {
			System.out.println("*******The BookStore Model********");
			// Get the values of attributes of serialized BookStore instance
			getBookStore_Attributes();
			// Get the values of references of serialized BookStore instance
			getBookStore_References();
			System.out.println("*********************************");
		}
	}

	public void getBookStore_Attributes() {
		lstBookStoreAttributes = BookStoreEClass.getEAttributes();
		for (int iBookStoreAttr = 0; iBookStoreAttr < lstBookStoreAttributes
				.size(); iBookStoreAttr++) {
			bookStore_Attribute = ((EAttribute) lstBookStoreAttributes
					.get(iBookStoreAttr));
			System.out.println(bookStore_Attribute.getName() + ": "
					+ BookStoreEObject.eGet(bookStore_Attribute));
		}
	}

	public void getBookStore_References() {
		// Get all EReferences of BookStore class
		lstBookStoreReferences = BookStoreEClass.getEReferences();
		for (int iBookStoreRef = 0; iBookStoreRef < lstBookStoreReferences
				.size(); iBookStoreRef++) {
			bookStore_Reference = ((EReference) lstBookStoreReferences
					.get(iBookStoreRef));
			System.out.println(bookStore_Reference.getName() + ":");

			// If the reference is of type Book, then get the serialized
			// instances of Book class
			if (bookStore_Reference.getEReferenceType().getName().equals(
					BOOK_CLASS_IDENTIFIER)) {
				lstBookEObjects = (EList) BookStoreEObject
						.eGet(bookStore_Reference);
				BookEClass = bookStore_Reference.getEReferenceType();

				// Get the values of attributes of each serialized Book instance
				lstBookAttributes = BookEClass.getEAttributes();
				for (int iBookObj = 0; iBookObj < lstBookEObjects.size(); iBookObj++) {
					for (int iBookAttr = 0; iBookAttr < lstBookAttributes
							.size(); iBookAttr++) {
						book_Attribute = ((EAttribute) lstBookAttributes
								.get(iBookAttr));
						System.out.println("\t"
								+ book_Attribute.getName()
								+ ": "
								+ ((EObject) (lstBookEObjects.get(iBookObj)))
										.eGet(book_Attribute));
					}
				}
			}
		}
	}

}
