package eu.modelwriter.core.alloyinecore.ui.mapping;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class Module {
  public static final String Ecore = "http://www.eclipse.org/emf/2002/Ecore";
  private String name;
  private String path;
  private EObject root;

  public static Module newInstance() {
    return new Module();
  }

  public String getName() {
    return name;
  }

  public Module setName(final String name) {
    this.name = name;
    return this;
  }

  public String getPath() {
    return path;
  }

  public Module setPath(final String path) {
    this.path = path;
    return this;
  }

  public EObject getRoot() {
    return root;
  }

  public Module setRoot(final EObject root) {
    this.root = root;
    return this;
  }

  public URI getURI() {
    return EcoreUtil.getURI(root);
  }

  /**
   *
   * @param relativePathFragments !!! we have root element, so we don't need root name.
   * @return
   */
  public EObject getElement(final List<String> relativePathFragments) {
    return relativePathFragments.size() == 0 ? root
        : EcoreUtil.getEObject(root, String.join("/", relativePathFragments));
  }
}