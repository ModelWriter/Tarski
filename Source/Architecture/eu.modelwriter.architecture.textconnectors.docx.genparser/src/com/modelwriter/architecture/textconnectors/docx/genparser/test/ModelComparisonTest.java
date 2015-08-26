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
package com.modelwriter.architecture.textconnectors.docx.genparser.test;

import static org.junit.Assert.assertSame;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
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
import org.junit.BeforeClass;
import org.junit.Test;

import com.modelwriter.architecture.textconnectors.docx.genparser.Doc2ParseModel;

public class ModelComparisonTest {

	private static String REQ2 = "testdata/REQ-2.docx";

	private static String REQ4 = "testdata/REQ-4.docx";

	private static String REQ5 = "testdata/REQ-5.docx";

	private static String REQ6 = "testdata/REQ-6.docx";

	private static String REQ7 = "testdata/REQ-7.docx";

	private static String REQ8 = "testdata/REQ-8.docx";

	private static String REQ9 = "testdata/REQ-9.docx";

	private static String REQ11 = "testdata/REQ-11.docx";
	
	private static String REQ13 = "testdata/REQ-13.docx";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/*
	 * @Test
	public void testReadyModelsWithoutIds(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();

		String xmi1 = "comparetest/left/left.xmi";
		String xmi2 = "comparetest/right/right.xmi";

		load(xmi1, resourceSet1);
		load(xmi2, resourceSet2);

		Comparison comparison = compare(resourceSet1, resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------");
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
			System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
			System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
			System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
			counter++;
			}
		}

		assertSame(Integer.valueOf(0), Integer.valueOf(differences.size()));
	}

	 */
	//Headers with heading styles(headings) must be organized hierarchically.
	@Test
	public void testCompareREQ2(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();
		// Load ready model
		String xmi = "testmodels/REQ-2.xmi";
		load(xmi ,resourceSet1);

		//parse and load
		resourceSet2 = load(REQ2);

		Comparison comparison = compare(resourceSet1, resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------" + xmi);
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
				System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
				System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
				System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
				counter++;
			}
		}

		assertSame(Integer.valueOf(0), Integer.valueOf(counter));
	}


	// Fully bold headers which have not heading styles must be handled
	// as a child of last heading.
	@Test
	public void testCompareREQ4(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();
		// Load ready model
		String xmi = "testmodels/REQ-4.xmi";
		load(xmi ,resourceSet1);

		//parse and load
		resourceSet2 = load(REQ4);

		Comparison comparison = compare(resourceSet1, resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------" + xmi);
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
				System.out.println("Left object: " + d.getMatch().getLeft().toString());
				System.out.println("Right object: " + d.getMatch().getRight().toString());
				System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
				System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
				System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
				counter++;
			}

		}



		assertSame(Integer.valueOf(0), Integer.valueOf(counter));
	}




	// Listed paragraphs must be handled as a child of last styled paragraph.
	@Test
	public void testCompareREQ5(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();

		// Load ready model
		String xmi = "testmodels/REQ-5.xmi";
		load(xmi ,resourceSet1);

		//parse and load
		resourceSet2 = load(REQ5);

		Comparison comparison = compare(resourceSet1,resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------" + xmi);
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
				System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
				System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
				System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
				counter++;
			}
		}

		assertSame(Integer.valueOf(0), Integer.valueOf(counter));
	}

	// Tabbed hierarchy for only not styled paragraphs must be handled.
	@Test
	public void testCompareREQ6(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();
		// Load ready model
		String xmi = "testmodels/REQ-6.xmi";
		load(xmi ,resourceSet1);

		//parse and load
		resourceSet2 = load(REQ6);

		Comparison comparison = compare(resourceSet1,resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------" + xmi);
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
				System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
				System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
				System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
				counter++;
			}
		}

		assertSame(Integer.valueOf(0), Integer.valueOf(counter));
	}

	// Tabbed hierarchy for paragraphs included both styled and 
	// not styled must be handled.
	@Test
	public void testCompareREQ7(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();
		// Load ready model
		String xmi = "testmodels/REQ-7.xmi";
		load(xmi ,resourceSet1);

		//parse and load
		resourceSet2 = load(REQ7);

		Comparison comparison = compare(resourceSet1, resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------" + xmi);
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
				System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
				System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
				System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
				counter++;
			}
		}

		assertSame(Integer.valueOf(0), Integer.valueOf(counter));
	}

	// If there is a bold key-value pair, every paragraphs until a new fully bold, 
	// styled with headings or bold key-value paragraph become.
	@Test
	public void testCompareREQ8(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();

		// Load ready model
		String xmi = "testmodels/REQ-8.xmi";
		load(xmi ,resourceSet1);

		//parse and load
		resourceSet2 = load(REQ8);

		Comparison comparison = compare(resourceSet1, resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------" + xmi);
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
				System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
				System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
				System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
				counter++;
			}
		}

		assertSame(Integer.valueOf(0), Integer.valueOf(counter));
	}

	// If there is a non-bold key-value pair, paragraph must be moved 
	// under previous styled paragraph.
	@Test
	public void testCompareREQ9(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();

		// Load ready model
		String xmi = "testmodels/REQ-9.xmi";
		load(xmi ,resourceSet1);

		//parse and load
		resourceSet2 = load(REQ9);

		Comparison comparison = compare(resourceSet1, resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------" + xmi);
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
				System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
				System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
				System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
				counter++;
			}
		}

		assertSame(Integer.valueOf(0), Integer.valueOf(counter));
	}

	// Fully bold paragraphs, bold key-value paragraphs and paragraphs with heading styles 
	//must be considered as hierarchic levels.
	@Test
	public void testCompareREQ11(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();

		// Load ready model
		String xmi = "testmodels/REQ-11.xmi";
		load(xmi ,resourceSet1);

		//parse and load
		resourceSet2 = load(REQ11);

		Comparison comparison = compare(resourceSet1,resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------" + xmi);
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
				System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
				System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
				System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
				counter++;
			}
		}

		assertSame(Integer.valueOf(0), Integer.valueOf(counter));
	}

	//If not bold and it is in ordered list item, 
	//paragraph must be handled as a child of that ordered list item 
	@Test
	public void testCompareREQ13(){

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();

		// Load ready model
		String xmi = "testmodels/REQ-13.xmi";
		load(xmi ,resourceSet1);

		//parse and load
		resourceSet2 = load(REQ13);

		Comparison comparison = compare(resourceSet1,resourceSet2);
		EList<org.eclipse.emf.compare.Diff> differences = comparison.getDifferences();

		int counter = 0;
		System.out.println("----------------" + xmi);
		for(org.eclipse.emf.compare.Diff d: differences)
		{
			if(!d.getKind().toString().equals("CHANGE")){
				System.err.println("d.getKind(): "+((org.eclipse.emf.compare.Diff) d).getKind());
				System.err.println("d.getMatch(): " + ((org.eclipse.emf.compare.Diff) d).getMatch());
				System.err.println("State: " + ((org.eclipse.emf.compare.Diff) d).getState());
				counter++;
			}
		}
		
		// just 1 id is different
		assertSame(Integer.valueOf(0), Integer.valueOf(counter));
	}

	// TODO REQ-12 is missing
	private ResourceSet load(String req) {

		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet = Doc2ParseModel.parse(null,null,req).getResourceSet();
			return resourceSet;
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		return null;
	}

	@SuppressWarnings("deprecation")
	public Comparison compare(ResourceSet resourceSet1, ResourceSet resourceSet2)
	{

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
	
		
		
		/*
		IDiffProcessor customDiffProcessor = new DiffBuilder() {
			@Override
			public void attributeChange(Match match, EAttribute attribute, Object value, DifferenceKind kind, DifferenceSource source) {
				if (attribute != DocModel.DocModelPackage.Literals.ELEMENT__ID) {
					super.attributeChange(match, attribute, value, kind, source);
				}
			}
		};

		IDiffEngine diffEngine = new DefaultDiffEngine(customDiffProcessor);
		return EMFCompare.builder().setDiffEngine(diffEngine).build().compare(scope);
		*/
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void load(String absolutePath, ResourceSet resourceSet) {

		URI uri = URI.createFileURI(absolutePath);

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