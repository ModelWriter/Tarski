package eu.modelwriter.configuration.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
   * @return list of EClass names from given emf model via alias
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

}
