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
package eu.modelwriter.architecture.textconnectors.docx.usecase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNum;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import useCase.Activity;
import useCase.Actor;
import useCase.Documentation;
import useCase.EndEvent;
import useCase.Interest;
import useCase.Process;
import useCase.SequenceFlow;
import useCase.Specification;
import useCase.StartEvent;
import useCase.UseCase;
import useCase.UseCaseFactory;


public class UseCase2BusinessProcessModelConverter {


	private final static String PRIMARY_ACTOR = "Primary Actor";
	private final static String STAKEHOLDERS_AND_INTERESTS = "Stakeholders and Interests";
	private final static String PRECONDITION = "Preconditions";
	private final static String SUCCESS_GUARANTEE = "Success Guarantee (Postcondition)";
	//private final static String POSTCONDITION = "Postcondition";
	private final static String MAIN_SUCCESS_SCENARIO = "Main Success Scenario (or Basic Flow)";
	//private final static String BASIC_FLOW = "Basic Flow";
	private final static String EXTENSIONS = "Extensions (or Alternative Flows)";
	//private final static String ALTERNATIVE_FLOWS = "Alternative Flows";


	private final static String filename = "testdata/UseCaseDocumentation.docx"; 

	public static UseCaseFactory factory;

	private static Specification specification;

	public static Iterator<XWPFParagraph> paraIter; 

	public static List<Documentation> documentationList;

	public static boolean keyValue;

	// Maps styles and their levels
	private static Map<String,Integer> headingMap;

	private static XWPFNumbering numbering = null; 

	private static XWPFParagraph handledParagraph = null;

	private static boolean paragraphNotHandled = false;

	private static XWPFParagraph paragraph; 

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		headingMap = new HashMap<String,Integer>();

		initializeHeadingMap();

		File file = null; 
		FileInputStream fis = null; 
		XWPFDocument document = null; 

		XWPFNum num = null; 
		List<XWPFParagraph> paraList = null; 
		BigInteger numID = null; 
		int numberingID = -1;

		file = new File(filename); 
		fis = new FileInputStream(file); 
		document = new XWPFDocument(fis); 
				
		numbering = document.getNumbering();
		
		factory = UseCaseFactory.eINSTANCE;
		specification = factory.createSpecification();
		specification.setName("UseCaseSpecification");

		paraList = document.getParagraphs(); 
		paraIter = paraList.iterator(); 
		String loweredText = "";
		int firstParagraphCounter = 0;
		boolean flag = false;

		
		documentationList = new ArrayList<Documentation>();
		UseCase useCase = null;

		while(paraIter.hasNext()) {


			if(paragraphNotHandled == false){
				paragraph = paraIter.next();
			}

			paragraphNotHandled = false;

			numID = paragraph.getNumID();
			loweredText = paragraph.getText().toLowerCase();

			String style = paragraph.getStyle();
			if(style == null){
				style = "null";
			}
			//firstParagraphCounter++;
			//extractParagraphStyle(paragraph);

			if( paragraph != null && paragraph.getText().trim() != ""){

				// Header of the UseCase
				if(headingMap.get(style) == 1){

					// add last usecase to specification
					if(useCase != null){

						specification.getOwnedUseCase().add(useCase);

					}
					//create new usecase
					useCase = factory.createUseCase();
					useCase.setName(paragraph.getText());

				}else {

					// If the paragraph is a plain text or key-value pair 
					if(paragraph.getStyle() == null && paragraph.getText().trim().length()>0) {

						//Plain text or key-value pair
						//paragraph is in the list
						if(numID != null){

							// List inside list
							if(numID.intValue() != numberingID) { 
								num = numbering.getNum(numID); 
								numberingID = numID.intValue(); 
								//System.out.println("Getting details of the new numbering system " + numberingID); 
								//System.out.println("It's abstract numID is " + num.getCTNum().getAbstractNumId().getVal().intValue()); 

							} 
							else { 

								System.out.println("Iterating through the numbers."); 
							} 


						}else{

							String[] values = paragraph.getText().split(":");
							

							for(XWPFRun run : paragraph.getRuns()){

								String runText = run.getText(0).trim();
								String key = values[0] + ":";

								// key-value 
								if(key.contains(runText) && run.isBold()){

									keyValue = true;
									createKeyValue(useCase);
									break;
								}else{
									keyValue = false;
								}


							}

							// plain text
							if(!isKeyValue()){

								Documentation d = factory.createDocumentation();
								d.setText(paragraph.getText());
								documentationList.add(d);
							}
						}

					}

					// if paragraph.getStyle() == null
					else{

					}
				}


			}



		} 

		//FileOutputStream out = new FileOutputStream(new File("C:/Users/2/Desktop/Test UceCase.docx"));
		//document.write(out);
		specification.getOwnedUseCase().add(useCase);
		fis.close(); 
		fis = null; 
		createXMIFile();

	} 

	private static void initializeHeadingMap() {
		
		headingMap.put("null",99);
		headingMap.put("NoSpacing", 0);
		headingMap.put("Heading1", 1);
		headingMap.put("Heading2", 2);
		headingMap.put("Heading3", 3);
		headingMap.put("Heading4", 4);
		headingMap.put("Heading5", 5);
		headingMap.put("Heading6", 6);
		headingMap.put("Heading7", 7);
		headingMap.put("Heading8", 8);
		headingMap.put("Heading9", 9);
		headingMap.put("ListParagraph", 99);
		
	}
	

	/*
	 * 
	private static void swapNodes(NamedNode nn) {
		// TODO Auto-generated method stub
		previousNode = currentNode;
		currentNode = nn;
	}
	 */


	private static boolean isKeyValue() {
		return keyValue;
	}


	/*
	 * private static void concatDocumentations() {

		//Definition definition = requirementLevelStack.peek().getOwnedDefinition().remove(0);
		Documentation documentation = documentationList.remove(0);
		String text = ((Documentation)documentation).getText();

		while(!documentationList.isEmpty()){

			documentation = documentationList.remove(0);
			text += ((Documentation)documentation).getText();
			if(!text.equals("")){
				text += "\n";
			}

		}

		Documentation newDocumentation = factory.createDocumentation();
		newDocumentation.setText(text);
		nodeHiararchyStack.peek().getDocumentation().add(newDocumentation);
		//textCounter = 0;

	}

	 */


	private static void createKeyValue(UseCase useCase) {
		// TODO Auto-generated method stub

		String[] values = paragraph.getText().split(":");
		//BigInteger numID = null;
		//int numberingID = -1;
		//XWPFNum num = null;

		switch(values[0]){
		
		case PRIMARY_ACTOR : 
			
			handlePrimaryActor(useCase);
			break;

		case STAKEHOLDERS_AND_INTERESTS : 

			handleStakeholdersAndInterest(useCase);
			break;

		case PRECONDITION :

			handlePreconditions(useCase);
			break;

		case SUCCESS_GUARANTEE :

			handlePostconditions(useCase);
			break;
			
		case EXTENSIONS :
			
			handleAlternativeFlows(useCase);		
			break;
			

		case MAIN_SUCCESS_SCENARIO :

			handleMainFlow(useCase);
			break;
			
		default: 

			paragraphNotHandled = false; 
			break;

		}

	}


	private static void handleMainFlow(UseCase useCase) {
		
		BigInteger numID = null;

		paragraph = paraIter.next();
		numID = paragraph.getNumID();
		Activity previousActivity = null;
		
		
		if(numID != null){
			
			Documentation doc = factory.createDocumentation();
			doc.setText(MAIN_SUCCESS_SCENARIO);
			doc.setTextFormat(paragraph.getStyle());
			useCase.getDocumentation().add(doc);
		}
		/** Activity must start with a positive integer and continue with dot('.')
		 * and there might be a whitespace(only one)
		 */
		String mainFlowActivityPattern = "(([1-9][0-9]*[.][ ]?)[A-Z].*)";
		Pattern pattern = Pattern.compile(mainFlowActivityPattern);
		Matcher matcher = pattern.matcher(paragraph.getText());

		int activityCounter = 0;

		Process process = factory.createProcess();
		//process.setDefinedAt(useCase);
		process.setName(MAIN_SUCCESS_SCENARIO);


		StartEvent startEvent = factory.createStartEvent();
		process.getOwnedFlowElements().add(startEvent);
		
		if(matcher.matches()){

			// Iterating through the numbers			
			while(matcher.matches() && paragraph != null){

				activityCounter++;
				// to-do
				SequenceFlow sequenceFlow = factory.createSequenceFlow();
				Activity activity = factory.createActivity();

				String[] v = paragraph.getText().split("\\.");
				activity.setLabel(v[0]);
				

				Documentation doc = factory.createDocumentation();
				
				// if there is more than one sentence
				if(v.length > 2){
					
					String content = "";
					for(int i = 1 ; i < v.length ; i++){
					
						content += v[i] + ".";
					}
					doc.setText(content);
					
				}else{
					doc.setText(v[1] + ".");
				}
				
				activity.getDocumentation().add(doc);

				if(activityCounter == 1){

					sequenceFlow.setSource(startEvent);
				}else{
					sequenceFlow.setSource(previousActivity);
				}

				sequenceFlow.setTarget(activity);

				previousActivity = activity;

				process.getOwnedFlowElements().add(sequenceFlow);
				process.getOwnedFlowElements().add(activity);							

				if(paraIter.hasNext()){
					paragraph = paraIter.next();
					matcher = pattern.matcher(paragraph.getText());
					numID = paragraph.getNumID();
				}else{
					break;
				}
					

			}// end while
		
		}
		
		// ordered list
		else{
				
			while(numID != null){
				
				activityCounter++;
				// to-do
				SequenceFlow sequenceFlow = factory.createSequenceFlow();
				Activity activity = factory.createActivity();

				activity.setLabel("" + activityCounter);

				Documentation doc = factory.createDocumentation();
				doc.setText(paragraph.getText());
				activity.getDocumentation().add(doc);

				if(activityCounter == 1){

					sequenceFlow.setSource(startEvent);
				}else{
					sequenceFlow.setSource(previousActivity);
				}

				sequenceFlow.setTarget(activity);

				previousActivity = activity;

				process.getOwnedFlowElements().add(sequenceFlow);
				process.getOwnedFlowElements().add(activity);	
				
				paragraph = paraIter.next();
				numID = paragraph.getNumID();
			}
		}
		
		EndEvent endEvent = factory.createEndEvent();
		SequenceFlow sequenceFlow = factory.createSequenceFlow();
		sequenceFlow.setSource(previousActivity);
		sequenceFlow.setTarget(endEvent);
		
		process.getOwnedFlowElements().add(previousActivity);
		process.getOwnedFlowElements().add(sequenceFlow);
		process.getOwnedFlowElements().add(endEvent);
		
		useCase.setOwnedMainFlow(process);
		//specification.getOwnedProcess().add(process);

		paragraphNotHandled = true;
		
		
	}

	private static void handleAlternativeFlows(UseCase useCase) {
		
		BigInteger numID = null;
		paragraph = paraIter.next();
		//NumID = paragraph.getNumID();
		String s = paragraph.getText();
		Activity previousExtensionActivity = null;
		Process previousExtensionProcess = null;
		// Get the TAB count '\t'
		int tabCount = 0;
		int extensionActivityCounter = 0;
		
		String extensionActivityPattern = "((((\t)*[1-9]|[*])[a-z]?[.][ ]?)[A-Z].*)";
		Pattern extensionPattern = Pattern.compile(extensionActivityPattern);
		Matcher extensionMatcher = extensionPattern.matcher(paragraph.getText());
		
		Process extensionProcess = null; 
		//extensionProcess.setName(EXTENSIONS);
		if(extensionMatcher.matches()){
			
			StartEvent extensionStartEvent = factory.createStartEvent();
					
			while(paragraph != null && paragraph.getText().trim().length()>0 && extensionMatcher.matches()){

				extensionActivityCounter++;
				
				SequenceFlow extensionSequenceFlow = factory.createSequenceFlow();
				Activity extensionActivity = factory.createActivity();

				// get the TAB('\t') count
				tabCount = s.length() - s.replaceAll("\t", "").length();
				
				// new process
				if(tabCount == 0){
					
					if(extensionProcess != null){
						previousExtensionProcess = extensionProcess;
						useCase.getOwnedAlternativeFlow().add(previousExtensionProcess);
						
					}
					
					extensionProcess = factory.createProcess();
					extensionProcess.setName(EXTENSIONS);
					//extensionProcess.setDefinedAt(useCase);
					
					// first process of the extensions part
					if(extensionActivityCounter == 1){
						
						extensionProcess.getOwnedFlowElements().add(extensionStartEvent);
					}
				}
				
				String[] v = paragraph.getText().split("\\.");

				extensionActivity.setLabel(v[0].substring(tabCount));

				Documentation doc = factory.createDocumentation();
				
				// if there is more than one sentence
				if(v.length > 2){
					
					String content = "";
					for(int i = 1 ; i < v.length ; i++){
					
						if(v[i].trim().equals("")){
							continue;
						}
						else if(!v[i].contains(":")){
							content += v[i] + ".";
						}else{
							content += v[i];
						}
					}
					doc.setText(content);
					
				}else{
					if(!v[1].contains(":")){
						
						doc.setText(v[1] + ".");
					}else {
						
						String[] v2 = v[1].split(":");
						
						String concat = v2[0] + ":";
						
						if(v2.length > 1 || (v2.length > 2 && !v2[1].trim().equals(""))){
						
							concat += v2[1] + ".";
							doc.setText(concat);
						}
						
						doc.setText(concat);
					}
				}
				doc.setTextFormat("tab count:"+tabCount);
				extensionActivity.getDocumentation().add(doc);

				if(extensionActivityCounter == 1){

					extensionSequenceFlow.setSource(extensionStartEvent);
					extensionSequenceFlow.setTarget(extensionActivity);
				}else if(tabCount != 0){
					extensionSequenceFlow.setSource(previousExtensionActivity);
					extensionSequenceFlow.setTarget(extensionActivity);
				}
				

				previousExtensionActivity = extensionActivity;

				if(extensionSequenceFlow.getSource() != null){
					extensionProcess.getOwnedFlowElements().add(extensionSequenceFlow);
				}
				extensionProcess.getOwnedFlowElements().add(extensionActivity);	
				
				if(paraIter.hasNext()){
					
					paragraph = paraIter.next();
					s = paragraph.getText();
					
					while(paraIter.hasNext() && s.equals("")){
						
						paragraph = paraIter.next();
						s = paragraph.getText();
					}
					
					extensionMatcher = extensionPattern.matcher(paragraph.getText());
					numID = paragraph.getNumID();
					
				}else{
					break;
				}
				
			}// end while
			
			EndEvent extensionEndEvent = factory.createEndEvent();
			SequenceFlow extensionSequenceFlow = factory.createSequenceFlow();
			extensionSequenceFlow.setSource(previousExtensionActivity);
			extensionSequenceFlow.setTarget(extensionEndEvent);
			
			extensionProcess.getOwnedFlowElements().add(previousExtensionActivity);
			extensionProcess.getOwnedFlowElements().add(extensionSequenceFlow);
			extensionProcess.getOwnedFlowElements().add(extensionEndEvent);

			//useCase.setMainFlow(extensionProcess);
			previousExtensionProcess = null;
			useCase.getOwnedAlternativeFlow().add(extensionProcess);

			paragraphNotHandled = true;
		}
		
	}


	private static void handlePostconditions(UseCase useCase) {

		String[] values = paragraph.getText().split(":");
		BigInteger numID = null;
		
		if(values.length < 2 || (values.length > 1 && values[1].replaceAll(" ", "").equals(""))){

			paragraph = paraIter.next();
			numID = paragraph.getNumID();

			Process process = factory.createProcess();
			process.setName(SUCCESS_GUARANTEE);
			
			if(numID != null){

				// Iterating through the numbers
				while(numID != null && paraIter.hasNext()){

					EndEvent endEvent = factory.createEndEvent();
					Documentation doc = factory.createDocumentation();
					doc.setText(paragraph.getText());

					endEvent.getDocumentation().add(doc);
					process.getOwnedFlowElements().add(endEvent);
					
					// TODO postcondition için bir taným
					useCase.getOwnedAlternativeFlow().add(process);
					
					paragraphNotHandled = true;
					paragraph = paraIter.next();
					numID = paragraph.getNumID();

				}// end while
			}//end if
			
			

		}else{
			
			Process process = factory.createProcess();
			process.setName(SUCCESS_GUARANTEE);
			
			EndEvent endEvent = factory.createEndEvent();
			Documentation doc = factory.createDocumentation();
			doc.setText(values[1]);

			endEvent.getDocumentation().add(doc);
			process.getOwnedFlowElements().add(endEvent);
			
			// TODO postcondition için bir taným
			useCase.getOwnedAlternativeFlow().add(process);
		}
		
	}

	private static void handlePreconditions(UseCase useCase) {
		
		String[] values = paragraph.getText().split(":");
		BigInteger numID = null;
		
		if(values.length < 2 || (values.length > 1 && values[1].replaceAll(" ", "").equals(""))){

			paragraph = paraIter.next();
			numID = paragraph.getNumID();

			if(numID != null){

				Process process = factory.createProcess();
				process.setName(PRECONDITION);
				
				// Iterating through the numbers
				while(numID != null && paraIter.hasNext()){

					StartEvent startEvent = factory.createStartEvent();
					Documentation doc = factory.createDocumentation();
					doc.setText(paragraph.getText());
					
					startEvent.getDocumentation().add(doc);
					process.getOwnedFlowElements().add(startEvent);

					// TODO precondition için bir taným
					useCase.getOwnedAlternativeFlow().add(process);
					
					paragraphNotHandled = true;
					paragraph = paraIter.next();
					numID = paragraph.getNumID();

				}// end while
			}//end if

		}else{
			
			Process process = factory.createProcess();
			process.setName(PRECONDITION);
			
			StartEvent startEvent = factory.createStartEvent();
			Documentation doc = factory.createDocumentation();
			doc.setText(values[1]);
			
			startEvent.getDocumentation().add(doc);
			process.getOwnedFlowElements().add(startEvent);

			// TODO precondition için bir taným
			useCase.getOwnedAlternativeFlow().add(process);
		}
		
	}

	private static void handleStakeholdersAndInterest(UseCase useCase) {
		
		String[] values = paragraph.getText().split(":");
		BigInteger numID = null;
		
		if(values.length < 2 || (values.length > 1 && values[1].replaceAll(" ", "").equals(""))){

			paragraph = paraIter.next();
			numID = paragraph.getNumID();
			//int id = numID.intValue();
			// numbering
			if(numID != null){

				// Iterating through the numbers
				while(numID != null && paraIter.hasNext()){

					String[] v = paragraph.getText().split(":");

					Interest interest = factory.createInterest();

					Actor interestActor = factory.createActor();

					Documentation doc = factory.createDocumentation();
					doc.setText(v[1]);
					
					interest.getDocumentation().add(doc);					
					
					String actorName = v[0];
					
					if(isNewActor(actorName)){
						
						interestActor = factory.createActor();
						interestActor.setName(actorName);
						specification.getOwnedActor().add(interestActor);
						interest.getActor().add(interestActor);
					}else{
						
						interest.getActor().add(specification.getActorByName(actorName));
					}
					
					useCase.getOwnedStakeholderInterest().add(interest);

					paragraphNotHandled = true;
					paragraph = paraIter.next();
					numID = paragraph.getNumID();
				}// end while
			}//end if

		}// end if
		
	}
	
	

	private static void handlePrimaryActor(UseCase useCase) {
		
		String[] values = paragraph.getText().split(":");
		Actor actor = null;
		BigInteger numID = null; 
		
		if(values[1].replaceAll(" ", "").equals("")){
			
			paragraph = paraIter.next();
			numID = paragraph.getNumID();
			
			while(numID != null && paraIter.hasNext()){
				
				String actorName = paragraph.getText().trim();
				
				if(isNewActor(actorName)){
					
					actor = factory.createActor();
					actor.setName(paragraph.getText().trim());
					specification.getOwnedActor().add(actor);
					useCase.getPrimaryActor().add(actor);
				}else{
					
					useCase.getPrimaryActor().add(specification.getActorByName(actorName));
				}
							
				paragraph = paraIter.next();
				numID = paragraph.getNumID();
				paragraphNotHandled = true;
			}
		}else{
			
			String[] actors = values[1].split(",");
			
			if(actors.length > 1){
			 
				for(int i = 0; i < actors.length;i++){
					
					
					String actorName = actors[i].trim();
					if(isNewActor(actorName)){
						
						actor = factory.createActor();
						actor.setName(actorName);
						specification.getOwnedActor().add(actor);
						useCase.getPrimaryActor().add(actor);
					}else{
						
						useCase.getPrimaryActor().add(specification.getActorByName(actorName));
					}
				}

			}else{
				
				String actorName = actors[0].trim();
				if(isNewActor(actorName)){
					
					actor = factory.createActor();
					actor.setName(actorName);
					specification.getOwnedActor().add(actor);
					useCase.getPrimaryActor().add(actor);
				}else{
					
					useCase.getPrimaryActor().add(specification.getActorByName(actorName));
				}
			}
			
		}
		
	
			
	}
	
	private static boolean isNewActor(String actorName){
		
		for (Actor actor : specification.getOwnedActor()) {
			
			if(actor.getName().toLowerCase().equals(actorName.toLowerCase())){
				
				return false;
			}
		}
		
		return true;
	}
	/**
	 * This extracts a paragraph style.
	 * 
	 * @param paragraph
	 *            the concerned paragraph.
	 */
	/*
	 * private static void extractParagraphStyle(XWPFParagraph paragraph) {
		// handle this paragraph runs contents
		pPr = paragraph.getCTP().getPPr();
		for (XWPFRun run : paragraph.getRuns()) {
			rPr = run.getCTR().getRPr();
			break;
		}
	}
	 */


	/**
	 * Saves the model instance and writes it to xmi file
	 * 
	 * @param product
	 */
	private static void createXMIFile() {

		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML Factory implementation using xmi extension
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"xmi", new  XMLResourceFactoryImpl());


		// Create empty resource with the given URI
		Resource resource = resourceSet.createResource(URI.createURI("model/TestDocument.xmi"));


		// Add Product to contents list of the resource 

		resource.getContents().add(specification);

		try{

			// Save the resource
			//resource.save(System.out, Collections.EMPTY_MAP); 
			resource.save(null);
			final JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Model created successfully!");

		}catch (IOException e) {

			e.printStackTrace();
		}

	}


}
