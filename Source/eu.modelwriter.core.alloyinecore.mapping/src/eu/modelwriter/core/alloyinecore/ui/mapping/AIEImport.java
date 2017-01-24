package eu.modelwriter.core.alloyinecore.ui.mapping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class AIEImport {
  public static final String Ecore = "http://www.eclipse.org/emf/2002/Ecore";
  private String name;
  private String path;
  private Resource resource;

  public static AIEImport newInstance() {
    return new AIEImport();
  }

  public String getName() {
    return name;
  }

  public AIEImport setName(final String name) {
    this.name = name;
    return this;
  }

  public String getPath() {
    return path;
  }

  public AIEImport setPath(final String path) {
    this.path = path;
    return this;
  }

  public Resource getResource() {
    return resource;
  }

  public AIEImport setResource(final Resource resource) {
    this.resource = resource;
    return this;
  }

  public EObject getRootObject() {
    return resource.getContents().get(0);
  }

  /**
   *
   * @param relativePathFragments !!! we have root element, so we don't need root name.
   * @return
   */
  public EObject getElement(final List<String> relativePathFragments) {
    EObject result = null;
    try {
      final String rootFragment = resource.getURIFragment(getRootObject());
      relativePathFragments.add(0, rootFragment);
      result = resource.getEObject(String.join("/", relativePathFragments));
      if (result == null) {
        throw new Exception();
      }
    } catch (final Exception e) {
      relativePathFragments.remove(0);
      result = resource.getEObject(String.join("/", relativePathFragments));
    }
    return result;
  }
}
