package eu.modelwriter.marker.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.mylyn.docs.intent.mapping.MappingPackage;


public class ModelIO<T extends EObject> {
  private ResourceSet resourceSet;

  public ResourceSet getResourceSet() {
    if (resourceSet == null) {
      resourceSet = new ResourceSetImpl();
      registerPackages(resourceSet.getPackageRegistry());
    }

    return resourceSet;
  }

  @SuppressWarnings("unchecked")
  public List<T> read(URI uri) {
    Resource res = getResourceSet().createResource(uri);

    if (res == null) {
      return new ArrayList<T>();
    }
    try {
      res.load(null);
    } catch (IOException e) {
      e.printStackTrace();
    }
    EList<EObject> contents = res.getContents();

    List<T> list = new ArrayList<T>();
    for (EObject content : contents) {

      try {
        list.add((T) content);
      } catch (Exception e) {
        throw new RuntimeException("Unexpected resource type.");
      }
    }

    return list;
  }

  /**
   * ResourceSet'e paket kayit eder.
   *
   * <br>
   * <br>
   * Ornegin; <br>
   * <code>packageRegistry.put(ContentPackage.eNS_URI, ContentPackage.eINSTANCE);</code> <br>
   * <br>
   * Kendi modellerinizi kullanacaksaniz bu methodu gerceklestiriniz ve kendi paket arayuzunuzu
   * kayit ediniz. EMF metamodelleri kullanacaksaniz varsayilan gerceklestirim yeterlidir.
   *
   * @param packageRegistry ResourceSet'a ait paket kayitcisi.
   */
  protected void registerPackages(EPackage.Registry packageRegistry) {
    packageRegistry.put(MappingPackage.eNS_URI, MappingPackage.eINSTANCE);
  }

  public void write(URI uri, T obj) {
    Resource resource = getResourceSet().createResource(uri);

    resource.getContents().add(obj);

    HashMap<Object, Object> options = new HashMap<>();
    try {
      resource.save(options);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
