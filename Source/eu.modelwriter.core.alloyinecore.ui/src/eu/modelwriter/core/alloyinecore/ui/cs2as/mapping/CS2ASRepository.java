package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import eu.modelwriter.core.alloyinecore.ui.cs2as.Module;

public class CS2ASRepository {
  public static final Map<String, Module> name2Module = new HashMap<>();
  public static final Map<String, EPackage> qname2ePackage = new HashMap<>();
  public static final Map<String, EClass> qname2eClass = new HashMap<>();
  public static final Map<String, EDataType> qname2eDataType = new HashMap<>();
  public static final Map<String, EEnum> qname2eEnum = new HashMap<>();
  public static final Map<String, EReference> qname2eReference = new HashMap<>();

  public static final EcoreFactory factory = EcoreFactory.eINSTANCE;
  public static EPackage root;

  public static void clearRepository() {
    CS2ASRepository.name2Module.clear();
    CS2ASRepository.qname2ePackage.clear();
    CS2ASRepository.qname2eClass.clear();
    CS2ASRepository.qname2eDataType.clear();
    CS2ASRepository.qname2eEnum.clear();
    CS2ASRepository.qname2eReference.clear();
    CS2ASRepository.root = null;
  }
}
