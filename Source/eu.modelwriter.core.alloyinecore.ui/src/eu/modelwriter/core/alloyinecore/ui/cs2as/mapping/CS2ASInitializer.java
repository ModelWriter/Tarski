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

		final ImportedModule importedModule = ImportedModule.newInstance().setName(name).setPath(path).setRoot(root);
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

		qualifiedNameStack.push(name);
		String qualifiedName = String.join("::", qualifiedNameStack);
		CS2ASRepository.qname2ePackage.put(qualifiedName, ePackage);

		super.visitEPackage(ctx);
		
		qualifiedNameStack.pop();
		return null;
	}

	@Override
	public Object visitEClass(final EClassContext ctx) {
		final EClass eClass = CS2ASRepository.factory.createEClass();

		final String name = ctx.name.getText();
		eClass.setName(name);

		qualifiedNameStack.push(name);
		String qualifiedName = String.join("::", qualifiedNameStack);
		CS2ASRepository.qname2eClass.put(qualifiedName, eClass);
		
		super.visitEClass(ctx);

		qualifiedNameStack.pop();
		return null;
	}

	@Override
	public Object visitEDataType(final EDataTypeContext ctx) {
		final EDataType eDataType = CS2ASRepository.factory.createEDataType();

		final String name = ctx.name.getText();
		eDataType.setName(name);

		qualifiedNameStack.push(name);
		String qualifiedName = String.join("::", qualifiedNameStack);
		CS2ASRepository.qname2eDataType.put(qualifiedName, eDataType);
		
		super.visitEDataType(ctx);
		
		qualifiedNameStack.pop();
		return null;
	}

	@Override
	public Object visitEEnum(final EEnumContext ctx) {
		final EEnum eEnum = CS2ASRepository.factory.createEEnum();

		final String name = ctx.name.getText();
		eEnum.setName(name);

		qualifiedNameStack.push(name);
		String qualifiedName = String.join("::", qualifiedNameStack);
		CS2ASRepository.qname2eEnum.put(qualifiedName, eEnum);
		
		super.visitEEnum(ctx);
		
		qualifiedNameStack.pop();
		return null;
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
		final Resource metaResource = metaResourceSet.getResource(URI.createPlatformResourceURI(path, true), true);

		/*
		 * Get root element of resource
		 */
		final EObject root = metaResource.getContents().get(0);

		return root;
	}
}
