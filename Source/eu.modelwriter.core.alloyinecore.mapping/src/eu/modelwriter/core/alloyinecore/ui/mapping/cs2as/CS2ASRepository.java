package eu.modelwriter.core.alloyinecore.ui.mapping.cs2as;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import eu.modelwriter.core.alloyinecore.ui.mapping.AIEImport;

public class CS2ASRepository {
  public final Map<String, AIEImport> name2Import;
  public final EcoreFactory factory;
  public ResourceSetImpl resourceSet;
  public Resource aieResource;

  /**
   * folder path segments of {@link aieResource}
   */
  private List<String> relativeComplementerSegments;

  public CS2ASRepository() {
    name2Import = new HashMap<>();
    factory = EcoreFactory.eINSTANCE;
    resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
  }

  public Resource loadAIEResource(final URI uri) {
    // try to get folder path of aieResource
    relativeComplementerSegments = new ArrayList<String>(uri.segmentsList());
    relativeComplementerSegments.remove(relativeComplementerSegments.size() - 1);
    if (uri.scheme() != null && uri.scheme().equals("platform")) {
      relativeComplementerSegments.remove(0);
    }

    aieResource = resourceSet.createResource(uri);
    try {
      aieResource.load(null);
      aieResource.getContents().clear();
    } catch (final IOException e) {
      return null;
    }
    return aieResource;
  }

  /**
   * if load resource is called recursively to try to complete relative path, it is true. else it is
   * false. see {@link loadResource(String path)}
   * 
   */
  private boolean isRelativePass = false;

  public Resource loadResource(String path) {
    while (path.startsWith("../") && relativeComplementerSegments.size() > 0) {
      // remove from path if starts with '../', and go up one directory
      path = path.substring(3, path.length());
      relativeComplementerSegments.remove(relativeComplementerSegments.size() - 1);
    }
    while (path.startsWith("./")) {
      // remove from path if starts with './'
      path = path.substring(2, path.length());
    }
    while (path.startsWith("/")) {
      // remove from path if starts with '/'
      path = path.substring(1, path.length());
    }

    Resource resource;
    try {
      // try to load with default URI
      resource = resourceSet.getResource(URI.createURI(path, true), true);
      if (resource.getContents().isEmpty()) {
        throw new Exception();
      }
      return resource;
    } catch (final Exception e1) {
      try {
        // try to load with platform resource URI
        resource = resourceSet.getResource(URI.createPlatformResourceURI(path, true), true);
        if (resource.getContents().isEmpty()) {
          throw new Exception();
        }
        return resource;
      } catch (final Exception e2) {
        try {
          // try to load with platform plugin URI
          resource = resourceSet.getResource(URI.createPlatformPluginURI(path, true), true);
          if (resource.getContents().isEmpty()) {
            throw new Exception();
          }
          return resource;
        } catch (final Exception e3) {
          try {
            // try to load with file URI
            resource = resourceSet.getResource(URI.createFileURI(path), true);
            if (resource.getContents().isEmpty()) {
              throw new Exception();
            }
            return resource;
          } catch (final Exception e4) {
            try {
              // if any URI that created from path couldn't be loaded
              // then we could think that is it relative path?
              // so, add 'folder path of aieResource' to beginning of the 'path'
              // and complete relative 'path' to full 'path'
              final List<String> completedRelativePath =
                  new ArrayList<String>(relativeComplementerSegments);
              completedRelativePath.add(path);
              // now we have full 'path'
              // we can try to load resource again.
              if (!isRelativePass) {
                isRelativePass = true;
                resource = loadResource(String.join("/", completedRelativePath));
                if (resource.getContents().isEmpty()) {
                  throw new Exception();
                }
                isRelativePass = false;
                return resource;
              } else {
                isRelativePass = false;
                throw new Exception();
              }
            } catch (final Exception e5) {
              // path could not be loaded anyway.
              return null;
            }
          }
        }
      }
    }
  }

  public void saveResource(final URI saveURI) {
    final Resource resource = resourceSet.getResource(saveURI, true);

    try {
      resource.save(null);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  public EObject getEObject(final Stack<String> qualifiedNameStack) {
    final List<String> relativePathFragments =
        qualifiedNameStack.stream().collect(Collectors.toList());
    relativePathFragments.remove(0);

    final String importName = qualifiedNameStack.get(0);
    final AIEImport aIEImport = name2Import.get(importName);
    return aIEImport.getElement(relativePathFragments);
  }

  public EObject getEObject(final String importName, final List<String> relativePathFragments) {
    final AIEImport aIEImport = name2Import.get(importName);
    return aIEImport.getElement(relativePathFragments);
  }

  public EPackage getRootPackage() {
    return (EPackage) aieResource.getContents().get(0);
  }
}
