package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.Stack;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
import eu.modelwriter.core.alloyinecore.ui.cs2as.ImportedModule;

public class CS2ASInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final CS2ASInitializer instance = new CS2ASInitializer();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  @Override
  public Object visitPackageImport(final PackageImportContext ctx) {
    final String name = ctx.name.getText();
    if (name.equals("ecore")) {
      return null;
    }
    final String path = ctx.ownedPathName.getText().replace("'", "");
    final EObject root = loadResource(path);

    final ImportedModule importedModule =
        ImportedModule.newInstance().setName(name).setPath(path).setRoot(root);
    CS2ASRepository.qname2importedModule.put(name, importedModule);
    return null;
  }

  @Override
  public Object visitEPackage(final EPackageContext ctx) {
    final EPackage ePackage = CS2ASRepository.factory.createEPackage();

    final String name = ctx.name.getText();
    ePackage.setName(name);

    final boolean isRoot = ctx.parent.getChild(0).equals(ctx);
    CS2ASRepository.root = isRoot ? ePackage : CS2ASRepository.root;

    CS2ASInitializer.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", CS2ASInitializer.qualifiedNameStack);
    CS2ASRepository.qname2ePackage.put(qualifiedName, ePackage);

    // CS2ASRepository.qname2ePackage.put(getQualifiedName(ctx), ePackage);

    super.visitEPackage(ctx);

    CS2ASInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEClass(final EClassContext ctx) {
    final EClass eClass = CS2ASRepository.factory.createEClass();

    final String name = ctx.name.getText();
    eClass.setName(name);

    CS2ASInitializer.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", CS2ASInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eClass.put(qualifiedName, eClass);

    // CS2ASRepository.qname2eClass.put(getQualifiedName(ctx), eClass);

    super.visitEClass(ctx);

    CS2ASInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEDataType(final EDataTypeContext ctx) {
    final EDataType eDataType = CS2ASRepository.factory.createEDataType();

    final String name = ctx.name.getText();
    eDataType.setName(name);

    CS2ASInitializer.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", CS2ASInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eDataType.put(qualifiedName, eDataType);

    // CS2ASRepository.qname2eDataType.put(getQualifiedName(ctx), eDataType);

    super.visitEDataType(ctx);

    CS2ASInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEEnum(final EEnumContext ctx) {
    final EEnum eEnum = CS2ASRepository.factory.createEEnum();

    final String name = ctx.name.getText();
    eEnum.setName(name);

    CS2ASInitializer.qualifiedNameStack.push(name);
    final String qualifiedName = String.join("::", CS2ASInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eEnum.put(qualifiedName, eEnum);

    // CS2ASRepository.qname2eEnum.put(getQualifiedName(ctx), eEnum);

    super.visitEEnum(ctx);

    CS2ASInitializer.qualifiedNameStack.pop();
    return null;
  }

  // private String getQualifiedName(final EPackageContext pkg) {
  // return getSuperPackage(pkg) == null ? pkg.name.getText()
  // : getQualifiedName(getSuperPackage(pkg)) + "::" + pkg.name.getText();
  // }

  // private String getQualifiedName(final EClassifierContext ctx) {
  // if (ctx.eClass() != null) {
  // return getQualifiedName(ctx.eClass());
  // } else if (ctx.eDataType() != null) {
  // return getQualifiedName(ctx.eDataType());
  // } else if (ctx.eEnum() != null) {
  // return getQualifiedName(ctx.eEnum());
  // }
  // return null;
  // }

  // private String getQualifiedName(final EClassContext ctx) {
  // return getQualifiedName(getSuperPackage(ctx)) + "::" + ctx.name.getText();
  // }
  //
  // private String getQualifiedName(final EDataTypeContext ctx) {
  // return getQualifiedName(getSuperPackage(ctx)) + "::" + ctx.name.getText();
  // }
  //
  // private String getQualifiedName(final EEnumContext ctx) {
  // return getQualifiedName(getSuperPackage(ctx)) + "::" + ctx.name.getText();
  // }

  // private EPackageContext getSuperPackage(final RuleContext ctx) {
  // if (ctx.parent == null) {
  // return null;
  // }
  // if (!(ctx.parent instanceof EPackageContext)) {
  // return getSuperPackage(ctx.parent);
  // } else {
  // return (EPackageContext) ctx.parent;
  // }
  // }

  // private String getQualifiedName(final EStructuralFeatureContext sf) {
  // return getQualifiedName(getContainingClass(sf)) + "::" + getName(sf);
  // }

  // private EClassifierContext getContainingClass(final RuleContext ctx) {
  // if (ctx.parent == null) {
  // return null;
  // }
  // if (!(ctx.parent instanceof EClassContext)) {
  // return getContainingClass(ctx.parent);
  // } else {
  // return (EClassifierContext) ctx.parent;
  // }
  // }

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
