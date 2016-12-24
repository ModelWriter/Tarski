package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import eu.modelwriter.core.alloyinecore.ui.cs2as.ImportedModule;

public class CS2ASRepository {
  public static final Map<String, ImportedModule> qname2importedModule = new HashMap<>();
  public static final Map<String, EPackage> qname2ePackage = new HashMap<>();
  public static final Map<String, EClass> qname2eClass = new HashMap<>();
  public static final Map<String, EDataType> qname2eDataType = new HashMap<>();
  public static final Map<String, EEnum> qname2eEnum = new HashMap<>();
  public static final Map<String, EReference> qname2eReference = new HashMap<>();

  public static final EcoreFactory factory = EcoreFactory.eINSTANCE;
  public static EModelElement root;

  public static void clearRepository() {
    CS2ASRepository.qname2importedModule.clear();
    CS2ASRepository.qname2ePackage.clear();
    CS2ASRepository.qname2eClass.clear();
    CS2ASRepository.qname2eDataType.clear();
    CS2ASRepository.qname2eEnum.clear();
    CS2ASRepository.qname2eReference.clear();
    CS2ASRepository.root = null;
  }
}
