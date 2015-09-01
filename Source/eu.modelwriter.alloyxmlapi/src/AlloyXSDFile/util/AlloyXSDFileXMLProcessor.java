/**
 */
package AlloyXSDFile.util;

import AlloyXSDFile.AlloyXSDFilePackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AlloyXSDFileXMLProcessor extends XMLProcessor {

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlloyXSDFileXMLProcessor() {
    super(new EPackageRegistryImpl(EPackage.Registry.INSTANCE));
    extendedMetaData.putPackage(null, AlloyXSDFilePackage.eINSTANCE);
  }
  
  /**
   * Register for "*" and "xml" file extensions the AlloyXSDFileResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations() {
    if (registrations == null) {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new AlloyXSDFileResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new AlloyXSDFileResourceFactoryImpl());
    }
    return registrations;
  }

} //AlloyXSDFileXMLProcessor
