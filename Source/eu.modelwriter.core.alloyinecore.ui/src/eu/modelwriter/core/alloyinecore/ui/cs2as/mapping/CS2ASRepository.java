package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import eu.modelwriter.core.alloyinecore.ui.cs2as.Module;

public class CS2ASRepository {
  public static final Map<String, Module> name2Module = new HashMap<>();

  public static EPackage root;

  public static final EcoreFactory factory = EcoreFactory.eINSTANCE;

  public static void clearRepository() {
    CS2ASRepository.name2Module.clear();
    CS2ASRepository.root = null;
  }

  public static EObject getEObject(final Stack<String> qualifiedNameStack) {
    final List<String> relativePathFrahments =
        qualifiedNameStack.stream().collect(Collectors.toList());
    relativePathFrahments.remove(0);

    final String moduleName = qualifiedNameStack.get(0);
    final Module module = CS2ASRepository.name2Module.get(moduleName);
    return module.getElement(relativePathFrahments);
  }

  public static EObject getEObject(final String moduleName,
      final List<String> relativePathFragments) {
    final Module module = CS2ASRepository.name2Module.get(moduleName);
    return module.getElement(relativePathFragments);
  }
}
