package eu.modelwriter.configuration.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class EcoreUtilities {

  public static final String EOBJECT_URI = "relative_eobject_uri";
  public static final String ROOT_URI = "relative_ecore_root_uri";

  public static XMLSave.XMLTypeInfo noTypeInfo;

  static {
    noTypeInfo = new XMLSave.XMLTypeInfo() {

      @Override
      public boolean shouldSaveType(EClass objectType, EClass featureType,
          EStructuralFeature feature) {
        return false;
      }

      @Override
      public boolean shouldSaveType(EClass objectType, EClassifier featureType,
          EStructuralFeature feature) {
        return false;
      }
    };
  }

  /**
   * Gets root EObject of given xmi file path
   * 
   * @param xmiFileFullPath file path of xmi file
   * @return root @EObject
   * @throws IOException
   */
  public static EObject getRootObject(final String xmiFileFullPath) throws IOException {
    return getRootObject(URI.createPlatformResourceURI(xmiFileFullPath, true));
  }

  /**
   * Gets root EObject of given xmi file path
   * 
   * @param xmiFileFullPath file path of xmi file
   * @return root @EObject
   * @throws IOException
   */
  public static EObject getRootObject(URI uri) throws IOException {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list;

    list = modelIO.read(uri);

    if (list.isEmpty()) {
      return null;
    }
    final EObject rootObject = (EObject) list.get(0);
    return rootObject;
  }

  /**
   * Gets root EObject of given xmi file path
   * 
   * @param xmiFileFullPath file path of xmi file
   * @return root @EObject
   * @throws IOException
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static Resource loadInstanceRoot(final String xmiFileFullPath) throws IOException {
    Map options = new HashMap();
    options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

    ResourceSetImpl resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    Resource resource =
        resourceSet.getResource(URI.createPlatformResourceURI(xmiFileFullPath, true), true);
    resource.load(options);
    if (resource.isLoaded()) {
      return resource;
    }
    return null;
  }

  /**
   * 
   * @param eObject possibly the package to find all @EClass's under it
   * @return @List of @EClass names
   */
  public static List<String> getAllEClassNames(EObject eObject) {
    List<EClass> classes = new ArrayList<>();
    recursiveGetEClasses(eObject, classes);
    List<String> classNames = new ArrayList<>();
    for (EClass eClass : classes) {
      classNames.add(eClass.getName());
    }
    return classNames;
  }

  /**
   * 
   * @param eObject possibly the package to find all @EClass under it
   * @return @List of all @EClass
   */
  public static List<EClass> getAllEClass(EObject eObject) {
    List<EClass> classes = new ArrayList<>();
    recursiveGetEClasses(eObject, classes);
    return classes;
  }

  private static void recursiveGetEClasses(EObject object, List<EClass> classes) {
    for (EObject eObject : object.eContents()) {
      if (eObject instanceof EClass)
        classes.add((EClass) eObject);
      else if (eObject instanceof EPackage)
        recursiveGetEClasses(eObject, classes);
    }
  }

  /**
   * 
   * @param @EObject object to be set
   * @param name reference name
   * @param newVal new value
   */
  public static void eSetAttributeByName(EObject eObject, String name, Object newVal) {
    for (EAttribute eAttribute : eObject.eClass().getEAllAttributes()) {
      if (eAttribute.getName().equals(name)) {
        eObject.eSet(eAttribute, newVal);
        break;
      }
    }
  }

  /**
   * 
   * @param @EObject object to be set
   * @param name reference name
   * @param newVal new value
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void eSetReferenceByName(EObject eObject, String name, Object newVal) {
    for (EReference eReference : eObject.eClass().getEAllReferences()) {
      if (eReference.getName().equals(name)) {
        if (eReference.isMany()) {
          ((List) eObject.eGet(eReference)).add(newVal);
        } else {
          eObject.eSet(eReference, newVal);
        }
        break;
      }
    }
  }

  /**
   * 
   * @param root @EObject
   * @param className class name to be find
   * @return
   */
  public static EClass findEClass(EObject root, String className) {
    List<EClass> allEClass = getAllEClass(root);
    return allEClass.stream().filter(c -> c.getName().equals(className)).findFirst().orElse(null);
  }

  /**
   * 
   * @param container
   * @param eObject
   * @return
   */
  public static EReference getContainmentEReference(EObject container, EObject eObject) {
    for (EReference eReference : container.eClass().getEAllReferences()) {
      if ((eObject.eClass().getName().equals(eReference.getEReferenceType().getName())
          || eObject.eClass().getEAllSuperTypes().stream()
              .anyMatch(s -> s.getName().equals(eReference.getEReferenceType().getName())))
          && eReference.isContainment())
        return eReference;
    }
    return null;
  }

  /**
   * Puts given dynamic EObject to container
   * 
   * @param container
   * @param eObject
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void putIntoContainer(EObject container, EObject eObject) {
    EReference eReference = getContainmentEReference(container, eObject);
    if (eReference != null) {
      if (eReference.isMany())
        ((List) container.eGet(eReference)).add(eObject);
      else
        container.eSet(eReference, eObject);
    }
  }

  /**
   * Saves given @EObject to given file path
   * 
   * @param root @EObject to be saved
   * @param savePath file location
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void saveResource(EObject root, String savePath) {
    ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",
        new XMLResourceFactoryImpl());
    Resource resource = resourceSet.createResource(URI.createFileURI(savePath));
    resource.getContents().add(root);

    Map options = new HashMap();
    options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
    // options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, noTypeInfo);
    try {
      resource.save(options);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  /**
   * Saves given @EObject to its resource.
   * 
   * @param root @EObject
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void saveResource(EObject root) {
    Map options = new HashMap();
    options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
    // options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, noTypeInfo);

    try {
      root.eResource().save(options);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static EClass findEClass(List<EClass> allEClasses, String className) {
    return allEClasses.stream().filter(c -> c.getName().equals(className)).findFirst().orElse(null);
  }
}
