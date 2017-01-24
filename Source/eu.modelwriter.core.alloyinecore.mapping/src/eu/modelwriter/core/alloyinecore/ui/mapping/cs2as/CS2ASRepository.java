package eu.modelwriter.core.alloyinecore.ui.mapping.cs2as;

import java.io.IOException;
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
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import eu.modelwriter.core.alloyinecore.ui.mapping.AIEImport;

public class CS2ASRepository {
  public final static Map<String, AIEImport> name2Import = new HashMap<>();
  public static ResourceSetImpl resourceSet;
  public static Resource aieResource;
  public final static EcoreFactory factory = EcoreFactory.eINSTANCE;

  public static void clear() {
    CS2ASRepository.name2Import.clear();
    CS2ASRepository.resourceSet = new ResourceSetImpl();
    CS2ASRepository.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
    .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new EcoreResourceFactoryImpl());
    CS2ASRepository.aieResource = null;
  }

  public static Resource loadAIEResource(final URI uri) {
    CS2ASRepository.aieResource = CS2ASRepository.resourceSet.createResource(uri);
    try {
      CS2ASRepository.aieResource.load(null);
      CS2ASRepository.aieResource.getContents().clear();
    } catch (final IOException e) {
      return null;
    }
    return CS2ASRepository.aieResource;
  }

  public static Resource loadResource(final String path) {
    Resource resource;
    try {
      resource = CS2ASRepository.resourceSet.getResource(URI.createURI(path, true), true);
      return resource;
    } catch (final Exception e1) {
      try {
        resource = CS2ASRepository.resourceSet
            .getResource(URI.createPlatformResourceURI(path, true), true);
        return resource;
      } catch (final Exception e2) {
        try {
          resource = CS2ASRepository.resourceSet
              .getResource(URI.createPlatformPluginURI(path, true), true);
          return resource;
        } catch (final Exception e3) {
          try {
            resource = CS2ASRepository.resourceSet.getResource(URI.createFileURI(path), true);
            return resource;
          } catch (final Exception e) {
            return null;
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
