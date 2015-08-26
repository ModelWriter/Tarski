/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
package com.modelwriter.architecture.textconnectors.docx.genparser;

import java.util.List;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.CompareUI;
import org.eclipse.compare.internal.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.domain.impl.EMFCompareEditingDomain;
import org.eclipse.emf.compare.ide.ui.internal.configuration.EMFCompareConfiguration;
import org.eclipse.emf.compare.ide.ui.internal.editor.ComparisonEditorInput;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

import DocModel.DocModelFactory;

public class ModelComparator {

	public static DocModelFactory factory;

	public static ResourceSet resourceSet1 = new ResourceSetImpl();
	public static ResourceSet resourceSet2 = new ResourceSetImpl();

	public static void main(String[] args) {
		//Paragraph p = factory.createParagraph();
		Comparison comparison = compare();
		List<Diff> differences = comparison.getDifferences();

		/*
		 * ICompareEditingDomain editingDomain = EMFCompareEditingDomain.create(resourceSet1, resourceSet2, null);
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		CompareEditorInput input = new ComparisonEditorInput((EMFCompareConfiguration) new CompareConfiguration(), comparison, editingDomain, adapterFactory);

		CompareUI.openCompareDialog(input); // or CompareUI.openCompareEditor(input);
		 */

		if(differences.size() > 0){
			for(Diff d: differences)
			{
				System.err.println("d.getKind(): "+d.getKind());
				System.err.println("d.getMatch(): " + d.getMatch());
				System.err.println("State: " + d.getState());
			}
		}else{

			System.out.println("No differences found!");
		}

	}

	public static Comparison compare(){

		//Loading models
		//ResourceSet resourceSet1 = new ResourceSetImpl();
		//ResourceSeresourceSet2 = new ResourceSetImpl();
		String xmi1 = "emftestcases/left/SampleRequirementDocument.xmi";
		String xmi2 = "emftestcases/right/SampleRequirementDocument.xmi";
		//File file1 = new File(xmi1);
		//String absolutePath = file1.getAbsolutePath();
		load(xmi1 ,resourceSet1);
		load(xmi2 ,resourceSet2);

		//Creating the comparison scope
		IComparisonScope scope = EMFCompare.createDefaultScope(resourceSet1, resourceSet2);

		//Configuring the comparison
		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();

		// Compare the two models
		return comparator.compare(scope);
	}

	public static void load(String absolutePath, ResourceSet resourceSet) {
		URI uri = URI.createFileURI(absolutePath);

		//resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		// register UML
		Map packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(DocModel.DocModelPackage.eNS_URI, DocModel.DocModelPackage.eINSTANCE);

		// Register XML resource as UMLResource.Factory.Instance
		Map extensionFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionFactoryMap.put("xmi", new XMIResourceFactoryImpl());
		// Resource will be loaded within the resource set
		resourceSet.getResource(uri, true);
	}
}
