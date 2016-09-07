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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class EcoreUtilities {

  /**
   * Gets root EObject of given xmi file path
   * 
   * @param xmiFileFullPath
   * @return
   * @throws IOException
   */
  public static EObject getRootObject(final String xmiFileFullPath) throws IOException {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list;

    list = modelIO.read(URI.createPlatformResourceURI(xmiFileFullPath, true));

    if (list.isEmpty()) {
      return null;
    }
    final EObject rootObject = (EObject) list.get(0);
    return rootObject;
  }

  /**
   * 
   * @param alias to find emf model
   * @return list of @EClass names from given emf model via alias
   */
  public static List<String> getEMFClassesFromEObject(EObject object) {
    List<String> classes = new ArrayList<>();
    EObject root = object;
    for (EObject eObject : root.eContents()) {
      if (eObject instanceof EClass)
        classes.add(((EClass) eObject).getName());
    }
    return classes;
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
    for (EObject object : root.eContents()) {
      if (object instanceof EClass && ((EClass) object).getName().equals(className)) {
        return (EClass) object;
      }
    }
    return null;
  }

  /**
   * 
   * @param eObject @EObject to be saved
   * @param savePath file location
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void saveResource(EObject eObject, String savePath) {
    ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",
        new XMLResourceFactoryImpl());
    Resource resource = resourceSet.createResource(URI.createFileURI(savePath));
    resource.getContents().add(eObject);

    XMLSave.XMLTypeInfo typeInfo = new XMLSave.XMLTypeInfo() {

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

    Map options = new HashMap();
    options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
    options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, typeInfo);
    try {
      resource.save(options);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
