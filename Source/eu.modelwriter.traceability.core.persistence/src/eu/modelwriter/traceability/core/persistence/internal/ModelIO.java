package eu.modelwriter.traceability.core.persistence.internal;

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

import eu.modelwriter.traceability.core.persistence.persistencePackage;
import eu.modelwriter.traceability.core.persistence.util.persistenceResourceFactoryImpl;

public class ModelIO<T extends EObject> {
  private ResourceSet resourceSet;

  public ResourceSet getResourceSet() {
    if (resourceSet == null) {
      resourceSet = new ResourceSetImpl();
      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
          .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new persistenceResourceFactoryImpl());
      registerPackages(resourceSet.getPackageRegistry());
      resourceSet.getPackageRegistry().put(persistencePackage.eNS_URI,
          persistencePackage.eINSTANCE);
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
  protected void registerPackages(EPackage.Registry packageRegistry) {}

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
