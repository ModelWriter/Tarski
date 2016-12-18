package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.ui.cs2as.PackageImport;

public class CS2ASInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final CS2ASInitializer instance = new CS2ASInitializer();

  private final EcoreFactory factory = EcoreFactory.eINSTANCE;

  private final Map<String, PackageImport> name2packageImport = new HashMap<>();
  private final Map<String, EPackage> name2ePackage = new HashMap<>();
  private final Map<String, EClass> name2eClass = new HashMap<>();
  private final Map<String, EDataType> name2eDataType = new HashMap<>();
  private final Map<String, EEnum> name2eEnum = new HashMap<>();

  // private Package currentPackage;

  @Override
  public Object visitPackageImport(final PackageImportContext ctx) {
    final String name = ctx.name.getText();
    if (name.equals("ecore")) {
      return null;
    }
    final String path = ctx.ownedPathName.getText().replace("'", "");
    final EObject root = loadResource(path);

    final PackageImport packageImport =
        PackageImport.newInstance().setName(name).setPath(path).setRoot(root);
    getName2packageImport().put(name, packageImport);
    return null;
  }

  @Override
  public Object visitEPackage(final EPackageContext ctx) {
    final EPackage ePackage = factory.createEPackage();

    final String name = ctx.name.getText();
    ePackage.setName(name);
    // currentPackage = Package.newInstance().setName(name).setePackage(ePackage);

    name2ePackage.put(name, ePackage);
    return super.visitEPackage(ctx);
  }

  @Override
  public Object visitEClass(final EClassContext ctx) {
    final EClass eClass = factory.createEClass();

    final String name = ctx.name.getText();
    eClass.setName(name);

    // final Class clazz = (Class) Class.newInstance().setName(name).setPackageIn(currentPackage);

    name2eClass.put(name, eClass);
    return super.visitEClass(ctx);
  }

  @Override
  public Object visitEDataType(final EDataTypeContext ctx) {
    final EDataType eDataType = factory.createEDataType();

    final String name = ctx.name.getText();
    eDataType.setName(name);

    // final DataType dataType =
    // (DataType) DataType.newInstance().setName(name).setPackageIn(currentPackage);

    name2eDataType.put(name, eDataType);
    return super.visitEDataType(ctx);
  }

  @Override
  public Object visitEEnum(final EEnumContext ctx) {
    final EEnum eEnum = factory.createEEnum();

    final String name = ctx.name.getText();
    eEnum.setName(name);

    // final Enum enumm = (Enum) Enum.newInstance().setName(name).setPackageIn(currentPackage);

    name2eEnum.put(name, eEnum);
    return super.visitEEnum(ctx);
  }

  public Map<String, PackageImport> getName2packageImport() {
    return name2packageImport;
  }

  public Map<String, EPackage> getName2epackage() {
    return name2ePackage;
  }

  public Map<String, EClass> getName2eclass() {
    return name2eClass;
  }

  public Map<String, EDataType> getName2edatatype() {
    return name2eDataType;
  }

  public Map<String, EEnum> getName2eenum() {
    return name2eEnum;
  }

  /**
   * @param path
   * @return
   *
   */
  private EObject loadResource(final String path) {
    final ResourceSet metaResourceSet = new ResourceSetImpl();

    /*
     * Register XML Factory implementation to handle .ecore files
     */
    metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
        new XMLResourceFactoryImpl());

    /*
     * Create empty resource with the given URI
     */
    final Resource metaResource =
        metaResourceSet.getResource(URI.createPlatformResourceURI(path, true), true);

    /*
     * Get root element of resource
     */
    final EObject root = metaResource.getContents().get(0);

    return root;
  }
}
