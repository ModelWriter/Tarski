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
/**
 * Converts requirement file(.docx) to  EMF model instance
 * 
 * @author furkan.tanriverdi@unitbilisim.com
 */

package eu.modelwriter.architecture.textconnectors.docx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import ReqModel.Definition;
import ReqModel.Priority;
import ReqModel.Product;
import ReqModel.ReqModelFactory;
import ReqModel.Requirement;
import ReqModel.RequirementLevel;
import ReqModel.TextArea;


public class Docx2ReqModelConverter {

	private static Product product;

	// Requirement property keywords
	private final static String REQUIREMENT_NAME = "Name";
	private final static String REQUIREMENT_DESCRIPTION = "Description";
	private final static String REQUIREMENT_REFINE = "Refine";
	private final static String REQUIREMENT_DEPENDENCY_TO = "Dependency to ";
	private final static String REQUIREMENT_PRIORITY = "Priority";
	private final static String REQUIREMENT_PRIORITY_MANDATORY = "Mandatory";

	//private static Map<Requirement,String> requirementsMap;

	// Stores levels 
	private static Stack<RequirementLevel> requirementLevelStack;

	// Maps requirement level object and their levels
	private static Map<RequirementLevel,Integer> requirementLevelMap;

	// Maps styles and their levels
	private static Map<String,Integer> headingMap;

	// Maps source and target requirement's Ids
	public static Map<String, String> dependenceyToMultiMap;

	// Maps source and target requirement's Ids
	public static Map<String, String> refineMultiMap;

	// Maps requirement id and corresponding requirement object
	public static Map<String, Requirement> requirementMultiMap;

	public static List<TextArea> textAreaList;
	public static ReqModelFactory factory;

	public static Product Convert(XWPFDocument doc) throws Exception 
	{
		//requirementsMap = new HashMap<Requirement,String>();
		requirementLevelStack = new Stack<RequirementLevel>();

		requirementLevelMap = new HashMap<RequirementLevel, Integer>();
		headingMap = new HashMap<String,Integer>();

		dependenceyToMultiMap = new HashMap<String, String>();
		refineMultiMap = new HashMap<String, String>();
		requirementMultiMap = new HashMap<String, Requirement>();

		// higher level is Heading1 in a word file
		//headingMap.put("NoSpacing", 0);	
		headingMap.put("Heading1", 1);
		headingMap.put("Heading2", 2);
		headingMap.put("Heading3", 3);
		headingMap.put("Heading4", 4);
		headingMap.put("Heading5", 5);
		headingMap.put("Heading6", 6);
		headingMap.put("Heading7", 7);
		headingMap.put("Heading8", 8);
		headingMap.put("Heading9", 9);

		XWPFDocument docx = doc;

		//XWPFWordExtractor we = new XWPFWordExtractor(docx);

		//XWPFStyles styles = docx.getStyles();

		List<XWPFParagraph> paragraphList = docx.getParagraphs();

		factory = ReqModelFactory.eINSTANCE;

		//int currentIndex = 0;
		int firstParagraphCounter = 0;
		product = factory.createProduct();

		Requirement requirement = null;
		Requirement previousRequirement = null;

		// Regular expression for requirement id
		String pattern = "(EM-HLR-F-REQ-[0-9]{3})";
		Pattern p = Pattern.compile(pattern);
		boolean reqFlag = false;
		boolean textInside = false;
		//int textCounter = 0;
		textAreaList = new ArrayList<TextArea>();
		//List<Requirement> list = new ArrayList<Requirement>();

		for(XWPFParagraph paragraph : paragraphList){

			firstParagraphCounter++;

			// For debug
			String paragraphText = paragraph.getText().trim();
			// String s = paragraph.getStyle();

			if( paragraph != null && paragraph.getText().trim() != ""){

				// first paragraph element
				if(firstParagraphCounter == 1){

					// Create a new RequirementLevel
					RequirementLevel requirementLevel = factory.createRequirementLevel();

					// Set requirement name as paragraph name
					requirementLevel.setName(paragraph.getText());

					// Only biggest headers(Heading 1) should be added Product
					if(headingMap.get(paragraph.getStyle()) == 1){
						product.getOwnedDefinition().add(requirementLevel);
					}

					requirementLevelStack.push(requirementLevel);
					requirementLevelMap.put(requirementLevel, headingMap.get(paragraph.getStyle()));					
				}				

				else {

					// If the paragraph is on the lowest level
					// This paragraph is about one of requirements' properties

					if(paragraph.getStyle() == null){

						Matcher matcher = p.matcher(paragraph.getText());

						// If there is no corresponding requirement object
						if(matcher.matches()){

							if(!textAreaList.isEmpty()){

								concatTextAreas();
							}

							previousRequirement = requirement;
							if(previousRequirement != null){

								requirementLevelStack.peek().getOwnedDefinition().add(previousRequirement);
								requirementMultiMap.put(previousRequirement.getId().trim(), previousRequirement);

							}

							requirement = factory.createRequirement();
							//requirement.setName(requirementLevelStack.peek().getName());
							requirement.setId(paragraph.getText().trim());
							reqFlag = true;
							textInside = false;
							//textCounter = 0;


						}else{

							reqFlag = false;
						}

						// Split the propertie name and the value of it
						String[] values = paragraph.getText().split(":");

						// Set requirement's name
						if(values[0].trim().equals(REQUIREMENT_NAME)){

							requirement.setName(values[1]);
						}

						// Set requirement's description
						else if(values[0].trim().equals(REQUIREMENT_DESCRIPTION)){

							requirement.setDescription(values[1]);

							// Concat the paragraphs inside the name 						
						}

						// Set requirement's dependency
						else if(values[0].equals(REQUIREMENT_DEPENDENCY_TO)){

							dependenceyToMultiMap.put(requirement.getId(), values[1].trim());

						}

						// Set requirement's priority
						else if(values[0].trim().equals(REQUIREMENT_PRIORITY)){

							if(values[1].trim().equals(REQUIREMENT_PRIORITY_MANDATORY)){

								requirement.setPriorityType(Priority.MANDATORY);	

							}else{

								requirement.setPriorityType(Priority.OPTIONAL);
							}

							// Concat the paragraphs inside the description

							if(textInside == true && !textAreaList.isEmpty()){
								concatDescription(requirement);
								//Definition definition = requirementLevelStack.peek().getOwnedDefinition().remove(0);						
								textInside = false;					

							}

						}

						// Set requirement's refine
						else if(values[0].trim().equals(REQUIREMENT_REFINE)){

							refineMultiMap.put(requirement.getId(), values[1].trim());
						}

						// This paragraph is a text
						else {

							if(reqFlag != true){


								TextArea textArea = factory.createTextArea();
								textArea.setText(paragraph.getText());
								textInside = true;
								//textCounter++;

								if(requirement != null && !requirementLevelStack.peek().getOwnedDefinition().contains(requirement) ){

									requirementLevelStack.peek().getOwnedDefinition().add(requirement);
									requirementMultiMap.put(requirement.getId().trim(), requirement);

								}

								//requirementLevelStack.peek().getOwnedDefinition().add(textArea);
								textAreaList.add(textArea);
							}


						}


					}else{

						// The current paragraph is on different level
						// so add requirement to peek requirement level object
						if(requirement != null){

							/*
									RequirementLevel poppedRequirementLevel = requirementLevelStack.pop();
									poppedRequirementLevel.getOwnedRequirement().add(requirement);
									requirementLevelStack.peek().getOwnedLevel().add(poppedRequirementLevel);
							 */
							requirementLevelStack.peek().getOwnedDefinition().add(requirement);
							requirementMultiMap.put(requirement.getId(), requirement);
							requirement = null;


						}

						// If the current paragraph's level is lower than the peek's level 
						if(headingMap.get(paragraph.getStyle()) > requirementLevelMap.get(requirementLevelStack.peek())){

							if(!textAreaList.isEmpty()){
								concatTextAreas();
							}

							RequirementLevel newRequirementLevel = factory.createRequirementLevel();
							newRequirementLevel.setName(paragraph.getText());

							/*
									if(headingMap.get(paragraph.getStyle()) == 1){
										product.getOwnedRequirementLevel().add(newRequirementLevel);
									}*/

							requirementLevelStack.push(newRequirementLevel);
							requirementLevelMap.put(newRequirementLevel, headingMap.get(paragraph.getStyle()));
						}

						// If the current paragraph's level is equal to the peek's level 
						else if(firstParagraphCounter > 1 && (headingMap.get(paragraph.getStyle()) == requirementLevelMap.get(requirementLevelStack.peek()))){

							if(!textAreaList.isEmpty()){
								concatTextAreas();
							}

							RequirementLevel poppedRequirementLevel = requirementLevelStack.pop();

							if(!requirementLevelStack.isEmpty()){

								requirementLevelStack.peek().getOwnedDefinition().add(poppedRequirementLevel);
							}else{

								product.getOwnedDefinition().add(poppedRequirementLevel);
							}

							RequirementLevel newRequirementLevel = factory.createRequirementLevel();
							newRequirementLevel.setName(paragraph.getText());

							if(headingMap.get(paragraph.getStyle()) == 1){
								product.getOwnedDefinition().add(newRequirementLevel);
							}

							requirementLevelStack.push(newRequirementLevel);
							requirementLevelMap.put(newRequirementLevel, headingMap.get(paragraph.getStyle()));
						}


						// If the current paragraph's level is higher than the peek's level 
						// then pop the requirement level and add it to peek's level is higher than
						// current paragraph's level
						else{											

							while(headingMap.get(paragraph.getStyle()) <= requirementLevelMap.get(requirementLevelStack.peek())){

								if(!textAreaList.isEmpty()){

									concatTextAreas();
								}


								RequirementLevel poppedRequirementLevel = requirementLevelStack.pop();

								// Higher level paragraph must be added to product
								if(requirementLevelMap.get(poppedRequirementLevel) == 1){

									product.getOwnedDefinition().add(poppedRequirementLevel);
									break;

								}else{

									requirementLevelStack.peek().getOwnedDefinition().add(poppedRequirementLevel);			
								}


							}

							RequirementLevel newRequirementLevel = factory.createRequirementLevel();
							newRequirementLevel.setName(paragraph.getText());

							if(headingMap.get(paragraph.getStyle()) == 1){
								product.getOwnedDefinition().add(newRequirementLevel);
							}

							requirementLevelStack.push(newRequirementLevel);
							requirementLevelMap.put(newRequirementLevel, headingMap.get(paragraph.getStyle()));

						}
					}



				}

			}

		}

		// If the last requirement of document could not added to the corresponding requirement level
		if(requirement != null){

			requirementLevelStack.peek().getOwnedDefinition().add(requirement);
			requirementMultiMap.put(requirement.getId(), requirement);
		}

		// son level altýndaki paragraflar
		if(!textAreaList.isEmpty()){
			concatTextAreas();
		}

		// Assign Refine attribute
		handleRefine();

		// Assign Dependency To attribute
		handleDependencyTo();

		// At last, stack must be emptied
		emptyStack();

		// Create and save the model instance to xmi file
		//createXMIFile(product);

		return product;

	}

	private static void concatDescription(Requirement requirement) {
		// TODO Auto-generated method stub
		Definition definition = textAreaList.remove(0);
		String text = requirement.getDescription() + "\n" + ((TextArea)definition).getText();

		while(!textAreaList.isEmpty()){

			definition = textAreaList.remove(0);
			text += ((TextArea)definition).getText();
			if(!text.equals("")){
				text += "\n";
			}

		}

		TextArea newText = factory.createTextArea();
		newText.setText(text);
		requirement.setDescription(newText.getText());
		//textCounter = 0;
	}

	private static void concatTextAreas() {
		// TODO Auto-generated method stub


		//Definition definition = requirementLevelStack.peek().getOwnedDefinition().remove(0);
		Definition definition = textAreaList.remove(0);
		String text = ((TextArea)definition).getText();

		while(!textAreaList.isEmpty()){

			definition = textAreaList.remove(0);
			text += ((TextArea)definition).getText();
			if(!text.equals("")){
				text += "\n";
			}

		}

		TextArea newText = factory.createTextArea();
		newText.setText(text);
		requirementLevelStack.peek().getOwnedDefinition().add(newText);
		//textCounter = 0;

	}

	/**
	 * Requirement Levels left at stack must be removed and 
	 * added corresponding levels
	 */
	private static void emptyStack() {
		// TODO Auto-generated method stub

		while(!requirementLevelStack.isEmpty()){

			RequirementLevel poppedRequirementLevel = requirementLevelStack.pop();	

			if(requirementLevelMap.get(poppedRequirementLevel) == 1){

				product.getOwnedDefinition().add(poppedRequirementLevel);
			}else{

				requirementLevelStack.peek().getOwnedDefinition().add(poppedRequirementLevel);			
			}


		}
	}

	/**
	 * Assigns Dependency To requirements to requirement
	 */
	private static void handleDependencyTo() {
		// TODO Auto-generated method stub

		try {
			for(Map.Entry<String, String> e : dependenceyToMultiMap.entrySet()){

				String key = e.getKey();
				String value = e.getValue();

				Requirement source = requirementMultiMap.get(key);
				Requirement target = requirementMultiMap.get(value);

				source.setDependencyTo(target);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-Dependency To- requirement not defined!");
		}

	}

	/**
	 * Assigns refine requirements to requirement
	 */
	private static void handleRefine() {
		// TODO Auto-generated method stub

		try {
			for(Map.Entry<String, String> e : refineMultiMap.entrySet()){

				String key = e.getKey();
				String value = e.getValue();

				Requirement source = requirementMultiMap.get(key);
				Requirement target = requirementMultiMap.get(value);

				source.setRefine(target);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-Refine requirement- not defined!");
		}
	}

	/**
	 * Saves the model instance and writes it to xmi file
	 * 
	 * @param product
	 */
	private static void createXMIFile(Product product) {

		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML Factory implementation using xmi extension
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"xmi", new  XMLResourceFactoryImpl());


		// Create empty resource with the given URI
		Resource resource = resourceSet.createResource(URI.createURI("model/SimpleRequirementMM.xmi"));

		// Add Product to contents list of the resource 

		resource.getContents().add(product);

		try{

			// Save the resource
			//resource.save(System.out, Collections.EMPTY_MAP); 
			resource.save(null);

		}catch (IOException e) {

			e.printStackTrace();
		}
	}
}
