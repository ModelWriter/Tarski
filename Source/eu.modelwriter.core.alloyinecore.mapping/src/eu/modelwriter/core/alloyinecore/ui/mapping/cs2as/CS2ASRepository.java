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
  public final static Map<String, AIEImport> name2Import = new HashMap<>();
  public static ResourceSetImpl resourceSet;
  public static Resource aieResource;
  public final static EcoreFactory factory = EcoreFactory.eINSTANCE;

  /**
   * folder path segments of {@link CS2ASRepository.aieResource}
   */
  private static List<String> relativeComplementerSegments;

  public static void clear() {
    CS2ASRepository.name2Import.clear();
    CS2ASRepository.resourceSet = new ResourceSetImpl();
    CS2ASRepository.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
    .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    CS2ASRepository.aieResource = null;
    CS2ASRepository.relativeComplementerSegments = null;
  }

  public static Resource loadAIEResource(final URI uri) {
    // try to get folder path of aieResource
    CS2ASRepository.relativeComplementerSegments = new ArrayList<String>(uri.segmentsList());
    CS2ASRepository.relativeComplementerSegments
    .remove(CS2ASRepository.relativeComplementerSegments.size() - 1);
    if (uri.scheme() != null && uri.scheme().equals("platform")) {
      CS2ASRepository.relativeComplementerSegments.remove(0);
    }

    CS2ASRepository.aieResource = CS2ASRepository.resourceSet.createResource(uri);
    try {
      CS2ASRepository.aieResource.load(null);
      CS2ASRepository.aieResource.getContents().clear();
    } catch (final IOException e) {
      return null;
    }
    return CS2ASRepository.aieResource;
  }

  /**
   * if load resource is called recursively to try to complete relative path, it is true. else it is
   * false. see {@link CS2ASRepository.loadResource(String path)}
   * 
   */
  private static boolean isRelativePass = false;

  public static Resource loadResource(String path) {
    while (path.startsWith("../") && CS2ASRepository.relativeComplementerSegments.size() > 0) {
      // remove from path if starts with '../', and go up one directory
      path = path.substring(3, path.length());
      CS2ASRepository.relativeComplementerSegments
      .remove(CS2ASRepository.relativeComplementerSegments.size() - 1);
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
      resource = CS2ASRepository.resourceSet.getResource(URI.createURI(path, true), true);
      if (resource.getContents().isEmpty()) {
        throw new Exception();
      }
      return resource;
    } catch (final Exception e1) {
      try {
        // try to load with platform resource URI
        resource = CS2ASRepository.resourceSet
            .getResource(URI.createPlatformResourceURI(path, true), true);
        if (resource.getContents().isEmpty()) {
          throw new Exception();
        }
        return resource;
      } catch (final Exception e2) {
        try {
          // try to load with platform plugin URI
          resource = CS2ASRepository.resourceSet
              .getResource(URI.createPlatformPluginURI(path, true), true);
          if (resource.getContents().isEmpty()) {
            throw new Exception();
          }
          return resource;
        } catch (final Exception e3) {
          try {
            // try to load with file URI
            resource = CS2ASRepository.resourceSet.getResource(URI.createFileURI(path), true);
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
                  new ArrayList<String>(CS2ASRepository.relativeComplementerSegments);
              completedRelativePath.add(path);
              // now we have full 'path'
              // we can try to load resource again.
              if (!CS2ASRepository.isRelativePass) {
                CS2ASRepository.isRelativePass = true;
                resource = CS2ASRepository.loadResource(String.join("/", completedRelativePath));
                if (resource.getContents().isEmpty()) {
                  throw new Exception();
                }
                CS2ASRepository.isRelativePass = false;
                return resource;
              } else {
                CS2ASRepository.isRelativePass = false;
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

  public static void saveResource(final URI saveURI) {
    final Resource resource = CS2ASRepository.resourceSet.getResource(saveURI, true);

    try {
      resource.save(null);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  public static EObject getEObject(final Stack<String> qualifiedNameStack) {
    final List<String> relativePathFragments =
        qualifiedNameStack.stream().collect(Collectors.toList());
    relativePathFragments.remove(0);

    final String importName = qualifiedNameStack.get(0);
    final AIEImport aIEImport = CS2ASRepository.name2Import.get(importName);
    return aIEImport.getElement(relativePathFragments);
  }

  public static EObject getEObject(final String importName,
      final List<String> relativePathFragments) {
    final AIEImport aIEImport = CS2ASRepository.name2Import.get(importName);
    return aIEImport.getElement(relativePathFragments);
  }

  public static EPackage getRootPackage() {
    return (EPackage) CS2ASRepository.aieResource.getContents().get(0);
  }
}
