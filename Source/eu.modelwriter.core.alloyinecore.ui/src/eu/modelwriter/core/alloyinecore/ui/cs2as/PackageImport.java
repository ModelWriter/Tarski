package eu.modelwriter.core.alloyinecore.ui.cs2as;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class PackageImport {
  private String name;
  private String path;
  private EObject root;

  public static PackageImport newInstance() {
    return new PackageImport();
  }

  public String getName() {
    return name;
  }

  public PackageImport setName(final String name) {
    this.name = name;
    return this;
  }

  public String getPath() {
    return path;
  }

  public PackageImport setPath(final String path) {
    this.path = path;
    return this;
  }

  public EObject getRoot() {
    return root;
  }

  public PackageImport setRoot(final EObject root) {
    this.root = root;
    return this;
  }

  public URI getURI() {
    return EcoreUtil.getURI(root);
  }

  public EObject getElement(final String relativeFragmentPath){
    return EcoreUtil.getEObject(root, relativeFragmentPath);
  }
}
