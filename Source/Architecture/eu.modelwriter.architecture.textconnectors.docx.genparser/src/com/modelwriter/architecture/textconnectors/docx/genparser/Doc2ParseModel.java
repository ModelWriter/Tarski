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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.ss.formula.functions.Replace;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNum;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import com.modelwriter.architecture.textconnectors.docx.genparser.notifymanager.MappingManager;

import DocModel.DocModelFactory;
import DocModel.Document;
import DocModel.Node;
import DocModel.Paragraph;
import DocModel.Part;

public class Doc2ParseModel {

	public static MappingManager mappingManager;

	public static RunManipulator runManipulator;

	public static DocModelFactory factory;

	public static Iterator<XWPFParagraph> paraIter; 

	// current paragraph
	private static XWPFParagraph paragraph; 

	// Maps styles and their levels
	private static Map<String,Integer> headingMap;

	private static Document documentObject;

	// Stores levels 
	private static Stack<Paragraph> paragraphStack;

	// Maps requirement level object and their levels
	private static Map<Paragraph,Integer> paragraphLevelMap;

	// Stores tabbed paragraph levels
	private static Stack<Paragraph> plainTextStack;

	private static Map<Paragraph,Integer> plaintTextLevelMap;

	public static boolean isPlainText;

	private static boolean paragraphNotHandled;

	private static int tabCount;

	private static Paragraph lastFullyBoldHeaderInPlainTextHierarchy;

	private static String orderedListItemPattern;	

	private static Pattern pattern;

	private static Matcher matcher; 

	private static XWPFNumbering numbering = null; 

	public static Resource parse(XWPFDocument d, Resource r, String filename) throws IOException {
		
		
		
		/////////////////////////////////////////////////////////////
		// If filename equals to null, it will be used for testing //
		/////////////////////////////////////////////////////////////
		
		
		String output = "outputs/";
		
		// TEST
		// output file name
		if(filename != null){
			
			String[] v = filename.split("/");
			String[] v2 = v[1].split("\\.");
			output += v2[0] + ".xmi";
			
		}else{
			// try to load the file into resource
			r.load(null);
			documentObject = (Document) r.getContents().get(0);
		}
			
		
		 

		
		
		

		// Write content of resource file
		//resource.save(System.out, Collections.EMPTY_MAP);

		
		initializeStaticVariables();
		initializeHeadingMap();

		File file = null; 
		FileInputStream fis = null; 
		XWPFDocument document = null;
		List<XWPFParagraph> paraList = null;
		if(filename != null){
			file = new File(filename); 
			fis = new FileInputStream(file);
			document = new XWPFDocument(fis);
		}else{
			document = d;

		}
		
	
		mappingManager.setDocument(document);
		
		numbering = document.getNumbering();
		paraList = document.getParagraphs(); 
		paraIter = paraList.iterator(); 

		BigInteger numID = null; 
		//int numberingID = -1;
		String paragraphText = "";
		String paragraphStyle = "";
		//int id = 0;
		boolean firstParagraphFlag = true;

		while(paraIter.hasNext()) {

			if(paragraphNotHandled == false){
				paragraph = paraIter.next();
			}

			paragraphNotHandled = false;

			paragraphText = paragraph.getText();
			paragraphStyle = paragraph.getStyle();
			numID = paragraph.getNumID();

			if(paragraphStyle == null){
				paragraphStyle = "null";
			}
			// heading level
			if(headingMap.get(paragraphStyle) > 0 && headingMap.get(paragraphStyle) < 11){

				//TODO
				//handleHeadingsHierarchy(paragraphStyle,paragraphText,firstParagraphFlag);

				if(!plainTextStack.isEmpty()){
					emptyPlainTextStack();
				}

				Paragraph p = factory.createParagraph();
				p.setId(EcoreUtil.generateUUID());

				p.setName(paragraphText.replaceAll("\t","").trim());
				//p.setParagraph(paragraph);
				p.setRawText(paragraphText);
				mappingManager.mapRuns(p.getId(), paragraph.getRuns());
				mappingManager.mapParagraph(p.getId(), paragraph);
				mappingManager.mapDocModelPara(p.getId(),p);

				// headingten sonra normal paragraflar gelirse o headinge ekle

				if(firstParagraphFlag && headingMap.get(paragraphStyle) == 1){					

					paragraphStack.push(p);
					paragraphLevelMap.put(p, headingMap.get(paragraphStyle));
					firstParagraphFlag = false;
				}

				// If the current paragraph's level is lower than the peek's level 
				else if(headingMap.get(paragraphStyle) > paragraphLevelMap.get(paragraphStack.peek())){

					paragraphStack.push(p);
					paragraphLevelMap.put(p, headingMap.get(paragraphStyle));
				}

				// If the current paragraph's level is equal to the peek's level 
				else if(headingMap.get(paragraphStyle) == paragraphLevelMap.get(paragraphStack.peek())){

					Paragraph poppedParagraph = paragraphStack.pop();

					if(!paragraphStack.isEmpty()){

						paragraphStack.peek().getOwnedNode().add(poppedParagraph);

					}else{

						documentObject.getOwnedParagraph().add(poppedParagraph);
					}

					if(headingMap.get(paragraphStyle) == 1){
						documentObject.getOwnedParagraph().add(p);
					}

					paragraphStack.push(p);
					paragraphLevelMap.put(p, headingMap.get(paragraphStyle));

				}

				// If the current paragraph's level is higher than the peek's level 
				// then pop the requirement level and add it to peek's level is higher than
				// current paragraph's level
				else{											

					while(headingMap.get(paragraphStyle) <= paragraphLevelMap.get(paragraphStack.peek())){

						Paragraph poppedParagraph = paragraphStack.pop();

						// Higher level paragraph must be added to product
						if(paragraphLevelMap.get(poppedParagraph) == 1){

							documentObject.getOwnedParagraph().add(poppedParagraph);
							break;

						}else{

							paragraphStack.peek().getOwnedNode().add(poppedParagraph);		
						}


					}

					if(headingMap.get(paragraphStyle) == 1){
						documentObject.getOwnedParagraph().add(p);
					}

					paragraphStack.push(p);
					paragraphLevelMap.put(p, headingMap.get(paragraphStyle));

				}

			}// end if <heading level>
			// normal paragraph
			else if(headingMap.get(paragraphStyle) == 99){

				isPlainText = true;

				if(!paragraphText.equals("")){

					if(isAllBold()){

						calculateTabCount(paragraphText);
						if(tabCount == 0 && !plainTextStack.isEmpty()){
							emptyPlainTextStack();
						}

						//bold key-value
						if(paragraphText.contains(":")){

							String[] values = paragraphText.split(":");
							handleBoldKeyValuePairs(values,paragraphText);

						}
						//header without heading style 
						//ex. EM-HLR-....
						else{

							handleFullyBoldHeaders(paragraphStyle,paragraphText);

						}

						isPlainText = false;
					}

					// key-value not bold
					// TODO handle numbered list
					// ex. Name: Caise Failure.
					else if(paragraphText.contains(":")){

						String[] values = paragraphText.split(":");
						handleKeyValueProperties(values);
					}
				}

				// plain text
				if(isPlainText && !paragraphText.equals("")){

					matcher = pattern.matcher(paragraphText);

					Paragraph p = factory.createParagraph();
					p.setId(EcoreUtil.generateUUID());
					mappingManager.mapRuns(p.getId(), paragraph.getRuns());
					mappingManager.mapParagraph(p.getId(), paragraph);
					mappingManager.mapDocModelPara(p.getId(),p);

					// eðer bir ordered list item ise isimlendir ve hierarþiye göre 
					// uygun node'a ekle
					if(matcher.matches()){
						String[] values1 = paragraphText.split("\\.");

						calculateTabCount(values1[0]);
						p.setName(values1[0].replaceAll("\t",""));
						p.setRawText(values1[1]);
					}else{

						p.setRawText(paragraphText);
						calculateTabCount(p.getRawText());

					}

					handleTabbedHierarchy(p);

				}
			}

			//isNumbered() or isListed();
			// TODO nested lists
			else if(numID != null){

				handleNumberedParagraphs(numID);
			}

		}

		finilize();

		// Create and save the model instance to xmi file
		Resource resource = createXMIFile(documentObject, output);
		return resource;
		//return documentObject;
	
	}


	private static boolean isAllBold() {

		int nonBoldRunCounter = 0;

		String text = paragraph.getText();
		if(text.contains(":")){

			String[] values = text.split(":");
			String key = values[0]; // + ":"

			for(XWPFRun run : paragraph.getRuns()){

				if(run.getText(0) == null){
					continue;
				}else{
					String runText = run.getText(0).trim();
					// key runtext yer deðiþtirildi
					// key -> key.replaceAll()
					if((runText.contains(key.replaceAll("\t", "")) || key.replaceAll("\t", "").contains(runText)) 
							&& run.isBold()){
						return true;
					}else{
						nonBoldRunCounter++;
					}
				}

			}
		}
		else{

			for(XWPFRun run : paragraph.getRuns()){

				if(!run.isBold()){
					nonBoldRunCounter++;
				}

			}


		}

		if(nonBoldRunCounter > 0){
			return false;
		}else{
			return true;
		}

	}


	private static void initializeStaticVariables() {

		runManipulator = new RunManipulator();
		mappingManager = MappingManager.getInstance();

		paragraphStack = new Stack<Paragraph>();
		paragraphLevelMap = new HashMap<Paragraph,Integer>();
		plainTextStack = new Stack<Paragraph>();
		plaintTextLevelMap = new HashMap<Paragraph,Integer>();
		headingMap = new HashMap<String,Integer>();
		factory = DocModelFactory.eINSTANCE;
		documentObject = factory.createDocument();
		paragraphNotHandled = false;
		lastFullyBoldHeaderInPlainTextHierarchy = null;
		paragraph = null;
		orderedListItemPattern = "((((\t)*[1-9]|[*])[a-z]?[.][ ]?)[A-Z].*)";
		pattern = Pattern.compile(orderedListItemPattern);

	}


	private static void calculateTabCount(String text) {

		text = trimEndingWhiteSpacesAndTabs(text);
		tabCount = text.length() - text.replaceAll("\t", "").length();

	}


	// Trims white spaces and tab characters at the end of the paragraph.
	private static String trimEndingWhiteSpacesAndTabs(String temp) {

		while(temp.substring(temp.length() - 1).equals("\t") || temp.substring(temp.length() - 1).equals(" ")){

			if(temp.substring(temp.length() - 1).equals(" ")){
				temp = temp.substring(0, temp.length()-1);
			}

			temp = temp.replaceAll("\t$", "");
		}
		return temp;
	}

	private static void finilize() {

		// if there is any plain text in stack which they have not beed added
		// to their parent paragraph
		emptyPlainTextStack();

		// if there is any heading in stack which they have not beed added
		// to model
		emptyStack();

	}

	private static void handleKeyValueProperties(String[] values) {

		/*
		if(!plainTextStack.isEmpty()){
			emptyPlainTextStack();
		}*/

		isPlainText = false;

		calculateTabCount(values[0]);

		Paragraph keyValueParagraph = factory.createParagraph();
		keyValueParagraph.setId(EcoreUtil.generateUUID());
		mappingManager.mapRuns(keyValueParagraph.getId(), paragraph.getRuns());
		mappingManager.mapParagraph(keyValueParagraph.getId(), paragraph);
		mappingManager.mapDocModelPara(keyValueParagraph.getId(),keyValueParagraph);

		// TODO ismi ayarla ordered list item için
		if((matcher = pattern.matcher(values[0])).matches()){

			String[] v = values[0].split("\\.");
			keyValueParagraph.setName(v[0].replaceAll("\t","").trim());
			keyValueParagraph.setRawText(v[1]);
		}else{

			keyValueParagraph.setName(values[0].replaceAll("\t","").trim());
		}

		handleTabbedHierarchy(keyValueParagraph);

		if(values.length < 2 || (values.length > 1 && 
				values[1].replaceAll(" ", "").equals(""))){

			handleNumberedList(keyValueParagraph);
			emptyOnlyOrderedListItems();
		}
		// ex. Primary Actor: Student.
		else{

			keyValueParagraph.setRawText(values[1]);
		}


		/*
		//determine heading level or subheader
		if(isThereNamedParagraph()){

			int lastParagraphIndex = paragraphStack.peek().getOwnedNode().size() - 1;
			Paragraph lastParagraph = paragraphStack.peek().getOwnedNode().get(lastParagraphIndex);
			//XWPFParagraph p = lastParagraph.getParagraph();
			String name = lastParagraph.getName();

				lastParagraph.getOwnedNode().add(keyValueParagraph);
		}
		else{

			paragraphStack.peek().getOwnedNode().add(keyValueParagraph);		

		}*/

	}


	private static void emptyOnlyOrderedListItems() {

		String mainFlowActivityPattern = "(([1-9]|[*])[a-z]?)";	
		Pattern pattern = Pattern.compile(mainFlowActivityPattern);
		Matcher matcher;

		Paragraph poppedParagraph = plainTextStack.pop();
		matcher = pattern.matcher(poppedParagraph.getName());
		do{

			if(plaintTextLevelMap.get(poppedParagraph) == 0){

				if(isThereNamedParagraph()){

					int lastParagraphIndex = paragraphStack.peek().getOwnedNode().size() - 1;
					paragraphStack.peek().getOwnedNode().get(lastParagraphIndex)
					.getOwnedNode().add(poppedParagraph);
				}else{
					paragraphStack.peek().getOwnedNode().add(poppedParagraph);
				}
			}else{

				plainTextStack.peek().getOwnedNode().add(poppedParagraph);			
			}

			if((matcher = pattern.matcher(plainTextStack.peek().getName())).matches()){

				poppedParagraph = plainTextStack.pop();
				matcher = pattern.matcher(poppedParagraph.getName());
			}

		}while(matcher.matches());
	}


	private static void handleBoldKeyValuePairs(String[] values, String paragraphText) {

		// has ordered list?
		if(values.length < 2 || (values.length > 1 && 
				values[1].replaceAll(" ", "").equals(""))){

			Paragraph keyValueParagraph = factory.createParagraph();
			keyValueParagraph.setId(EcoreUtil.generateUUID());
			keyValueParagraph.setName(values[0].replaceAll("\t","").trim());
			keyValueParagraph.setRawText(values[0]);
			mappingManager.mapRuns(keyValueParagraph.getId(), paragraph.getRuns());
			mappingManager.mapParagraph(keyValueParagraph.getId(), paragraph);
			mappingManager.mapDocModelPara(keyValueParagraph.getId(),keyValueParagraph);

			calculateTabCount(keyValueParagraph.getRawText());

			if(tabCount > 1){

				handleTabbedHierarchy(keyValueParagraph);

			}else{
				paragraphStack.peek().getOwnedNode().add(keyValueParagraph);		
			}

			handleNumberedList(keyValueParagraph);

		}
		// separated with commas ?
		else{

			
			boolean firstPartFlag = true;
			Map<String, List<XWPFRun>> partAndRun = null;
			List<Part> tempList = new ArrayList<Part>();
			Paragraph keyValueParagraph = null;

			calculateTabCount(values[0]);

			try {
				partAndRun = RunManipulator.maipulateRuns(paragraph);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (String key : partAndRun.keySet()) {

				if(values[0].contains(key)){
					keyValueParagraph = factory.createParagraph();
					keyValueParagraph.setId(EcoreUtil.generateUUID());
					keyValueParagraph.setName(key);
					keyValueParagraph.setRawText(key);
					mappingManager.mapRuns(keyValueParagraph.getId(), partAndRun.get(key));
					mappingManager.mapParagraph(keyValueParagraph.getId(), paragraph);
					mappingManager.mapDocModelPara(keyValueParagraph.getId(),keyValueParagraph);

					firstPartFlag = false;
					
					if(tabCount > 1){

						handleTabbedHierarchy(keyValueParagraph);

					}else{
						paragraphStack.peek().getOwnedNode().add(keyValueParagraph);		
					}


				}else{

					Part part = factory.createPart();
					part.setId(EcoreUtil.generateUUID());
					part.setName(key.trim());
					part.setRawText(key);
					tempList.add(part);
					//keyValueParagraph.getOwnedPart().add(part);
					mappingManager.mapRuns(part.getId(), partAndRun.get(key));
					//mappingManager.mapPart(part.getId(), part);
				}

			}
			
			emptyParts(tempList,keyValueParagraph);
		}

	}


	private static void emptyParts(List<Part> tempList,
			Paragraph keyValueParagraph) {
		
		for (Part part : tempList) {
			keyValueParagraph.getOwnedPart().add(part);
		}
		
	}


	private static void handleNumberedParagraphs(BigInteger numID) {

		int counter = 0;
		String text = paragraph.getText();

		if(!plainTextStack.isEmpty() && lastFullyBoldHeaderInPlainTextHierarchy == null){
			emptyPlainTextStack();
		}

		while(numID != null){
			counter++;
			Paragraph numberedParagraph = factory.createParagraph();
			numberedParagraph.setId(EcoreUtil.generateUUID());
			numberedParagraph.setName("" + counter);
			numberedParagraph.setRawText(text);
			mappingManager.mapRuns(numberedParagraph.getId(), paragraph.getRuns());
			mappingManager.mapParagraph(numberedParagraph.getId(), paragraph);
			mappingManager.mapDocModelPara(numberedParagraph.getId(),numberedParagraph);
			if(text.contains(":")){

				keyValueInOrderedList(text,numberedParagraph);
			}

			if(lastFullyBoldHeaderInPlainTextHierarchy != null){

				lastFullyBoldHeaderInPlainTextHierarchy.getOwnedNode().add(numberedParagraph);
			}
			else if(isThereNamedParagraph()){

				int lastNamedParagraphIndex = paragraphStack.peek().getOwnedNode().size() - 1;
				paragraphStack.peek().getOwnedNode().get(lastNamedParagraphIndex)
				.getOwnedNode().add(numberedParagraph);

			}else{

				paragraphStack.peek().getOwnedNode().add(numberedParagraph);	
			}

			if(paraIter.hasNext()){
				paragraph = paraIter.next();
				text = paragraph.getText();
				numID = paragraph.getNumID();
				paragraphNotHandled = true;
			}else{
				break;
			}
		}

	}


	private static void handleFullyBoldHeaders(String paragraphStyle, String paragraphText) {

		Paragraph headerParagraph = factory.createParagraph();
		headerParagraph.setId(EcoreUtil.generateUUID());
		headerParagraph.setName(paragraphText.replaceAll("\t","").trim());
		headerParagraph.setRawText(paragraphText);
		paragraphStyle = "SubHeader";
		mappingManager.mapRuns(headerParagraph.getId(), paragraph.getRuns());
		mappingManager.mapParagraph(headerParagraph.getId(), paragraph);
		mappingManager.mapDocModelPara(headerParagraph.getId(),headerParagraph);

		calculateTabCount(headerParagraph.getRawText());
		if(tabCount > 1){

			lastFullyBoldHeaderInPlainTextHierarchy = headerParagraph;
			handleTabbedHierarchy(headerParagraph);

		}else{
			lastFullyBoldHeaderInPlainTextHierarchy = null;
			paragraphStack.peek().getOwnedNode().add(headerParagraph);
			//headerParagraph.setParentNode(paragraphStack.peek());
		}
		// bundan sonra aralýksýz gelen paragraflarý buna ekle

	}


	private static void handleTabbedHierarchy(Paragraph p) {

		String mainFlowActivityPattern = "(([1-9]|[*])[a-z]?)";	
		Pattern pattern = Pattern.compile(mainFlowActivityPattern);
		Matcher matcher;

		// Boþsa ekle
		if(plainTextStack.isEmpty()){

			plainTextStack.push(p);
			plaintTextLevelMap.put(p, tabCount);

		}
		// yýðýtýn tepesindekinden daha içerdeyse
		else if(plaintTextLevelMap.get(plainTextStack.peek()) < tabCount){

			plainTextStack.push(p);
			plaintTextLevelMap.put(p, tabCount);
		}
		// eþitse
		else if(plaintTextLevelMap.get(plainTextStack.peek()) == tabCount){


			// fully bold header altýnda onunla ayný seviyedeki bir paragraf ise
			// ayrýca named paragraf ama ordered list elemaný deðil ise ekle
			if(plainTextStack.peek().getName() != null &&
					(!(matcher = pattern.matcher(plainTextStack.peek().getName())).matches())
					){

				plainTextStack.peek().getOwnedNode().add(p);

			}
			else{
				Paragraph poppedParagraph = plainTextStack.pop();

				if(!plainTextStack.isEmpty()){

					plainTextStack.peek().getOwnedNode().add(poppedParagraph);

				}else{

					if(!isThereNamedParagraph()){
						paragraphStack.peek().getOwnedNode().add(p);

					}else{

						int lastParagraphIndex = paragraphStack.peek().getOwnedNode().size() - 1;
						paragraphStack.peek().getOwnedNode().get(lastParagraphIndex).getOwnedNode().add(poppedParagraph);
					}
				}

			}

			plainTextStack.push(p);
			plaintTextLevelMap.put(p, tabCount);
		}
		// daha az indented para geldiyse
		else{
			boolean isAdded = false;
			while(tabCount <= plaintTextLevelMap.get(plainTextStack.peek())){


				Paragraph poppedParagraph = plainTextStack.pop();

				// indent sayýsý ayný olsa da eðer çýkarýlan paragraph fully bold ise
				// onun childýne ekle
				// ayrýca ordered list item olmamalý
				if(plaintTextLevelMap.get(poppedParagraph) == tabCount && poppedParagraph.getName()!= null &&
						(!(matcher = pattern.matcher(poppedParagraph.getName())).matches())){

					poppedParagraph.getOwnedNode().add(p);
					plainTextStack.peek().getOwnedNode().add(poppedParagraph);		
					isAdded = true;
				}
				else{
					// Higher level paragraph must be added to product
					if(plaintTextLevelMap.get(poppedParagraph) == 0){

						if(!isThereNamedParagraph()){
							paragraphStack.peek().getOwnedNode().add(poppedParagraph);

						}else{

							int lastParagraphIndex = paragraphStack.peek().getOwnedNode().size() - 1;
							paragraphStack.peek().getOwnedNode().get(lastParagraphIndex).getOwnedNode().add(poppedParagraph);
						}
						break;

					}else{

						plainTextStack.peek().getOwnedNode().add(poppedParagraph);		
					}
				}

			}

			if(!isAdded){
				plainTextStack.push(p);
				plaintTextLevelMap.put(p, tabCount);
			}

		}

	}


	private static void emptyPlainTextStack() {

		while(!plainTextStack.isEmpty()){

			Paragraph poppedParagraph = plainTextStack.pop();	

			if(plaintTextLevelMap.get(poppedParagraph) == 0){

				if(isThereNamedParagraph()){

					int lastParagraphIndex = paragraphStack.peek().getOwnedNode().size() - 1;
					paragraphStack.peek().getOwnedNode().get(lastParagraphIndex)
					.getOwnedNode().add(poppedParagraph);
				}else{
					paragraphStack.peek().getOwnedNode().add(poppedParagraph);
				}
			}else{

				plainTextStack.peek().getOwnedNode().add(poppedParagraph);			
			}


		}

	}

	private static boolean isThereNamedParagraphUnderPlainText(){

		if(!plainTextStack.isEmpty() && tabCount > 1){

			int lastParagraphIndex = plainTextStack.peek().getOwnedNode().size() - 1;
			Paragraph lastParagraph = paragraphStack.peek().getOwnedNode().get(lastParagraphIndex);

			if(lastParagraph.getName() != null){
				return true;
			}

		}else{
			return false;
		}

		return false;
	}

	private static boolean isThereNamedParagraph() {

		String mainFlowActivityPattern = "(([1-9]|[*])[a-z]?)";	
		Pattern pattern = Pattern.compile(mainFlowActivityPattern);
		Matcher matcher;

		if(paragraphStack.peek().getOwnedNode().size() > 0){
			int lastParagraphIndex = paragraphStack.peek().getOwnedNode().size() - 1;
			Paragraph lastParagraph = paragraphStack.peek().getOwnedNode().get(lastParagraphIndex);


			if(lastParagraph.getName() != null &&
					(!(matcher = pattern.matcher(lastParagraph.getName())).matches())){

				return true;
			}

		}else{
			return false;
		}

		return false;
	}


	private static void handleNumberedList(Paragraph keyValueParagraph) {

		BigInteger numID = null;
		paragraph = paraIter.next();
		String text = paragraph.getText();
		numID = paragraph.getNumID();
		XWPFNum num = null; 
		int numberingID = -1; 

		/** Activity must start with a positive integer and continue with dot('.')
		 * and there might be a whitespace(only one)
		 */
		// TODO senaryo oluþtur listeler için
		//String mainFlowActivityPattern = ".*([(]*([0-9]|[a-zA-Z])+.*[)]*[ ]+[a-zA-Z].*)";
		matcher = pattern.matcher(text);

		// ordered list
		if(numID != null){
			int activityCounter = 0;

			// TODO nested list
			while(numID != null){

				//new numbering system
				if(numID.intValue() != numberingID) { 
					num = numbering.getNum(numID); 
					numberingID = numID.intValue(); 
					activityCounter = 0;
					/*
					 *  System.out.println("Getting details of the new numbering system " + numberingID); 
                    System.out.println("It's abstract numID is " + num.getCTNum().getAbstractNumId().getVal().intValue()); 
					 */
				} 
				/*
				 * else { 
                    System.out.println("Iterating through the numbers.");

                } 
				 */
				activityCounter++;
				Paragraph p = factory.createParagraph();
				p.setId(EcoreUtil.generateUUID());
				p.setName("" + activityCounter);
				p.setRawText(text);
				mappingManager.mapRuns(p.getId(), paragraph.getRuns());
				mappingManager.mapParagraph(p.getId(), paragraph);
				mappingManager.mapDocModelPara(p.getId(),p);

				if(text.contains(":")){

					keyValueInOrderedList(text,p);
				}


				keyValueParagraph.getOwnedNode().add(p);

				//p.setParentNode(keyValueParagraph);

				paragraph = paraIter.next();
				text = paragraph.getText();
				numID = paragraph.getNumID();
			}
		}
		else if(matcher.matches()){

			// Iterating through the numbers			
			while(matcher.matches() && paragraph != null){

				// TODO tabbed list
				// uygun yerden bölmemiz gerekli
				//String[] v = cutString(text);
				String[] v = text.split("\\.");

				Paragraph p = factory.createParagraph();
				calculateTabCount(v[0]);
				p.setId(EcoreUtil.generateUUID());
				p.setName(v[0].replaceAll("\t",""));
				p.setRawText(v[1]);
				mappingManager.mapRuns(p.getId(), paragraph.getRuns());
				mappingManager.mapParagraph(p.getId(), paragraph);
				mappingManager.mapDocModelPara(p.getId(),p);


				if(text.contains(":")){

					keyValueInOrderedList(text,p);
				}

				handleTabbedHierarchy(p);
				//keyValueParagraph.getOwnedNode().add(p);
				//p.setParentNode(keyValueParagraph);

				if(paraIter.hasNext()){
					paragraph = paraIter.next();
					text = paragraph.getText();
					matcher = pattern.matcher(paragraph.getText());

				}else{
					break;
				}


			}// end while

		}

		paragraphNotHandled = true;

	}

	private static void keyValueInOrderedList(String text, Paragraph p) {

		String[] v = text.split(":");
		Paragraph keyValueParagraph = factory.createParagraph();
		keyValueParagraph.setId(EcoreUtil.generateUUID());
		keyValueParagraph.setName(v[0]);
		mappingManager.mapRuns(keyValueParagraph.getId(), paragraph.getRuns());
		mappingManager.mapParagraph(keyValueParagraph.getId(), paragraph);
		mappingManager.mapDocModelPara(keyValueParagraph.getId(),keyValueParagraph);

		if(v.length > 1 && v[1].trim().length() > 0){

			keyValueParagraph.setRawText(v[1]);
		}else{
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Missing Line at the paragraph '" 
					+ keyValueParagraph.getName() + "'","Error", JOptionPane.ERROR_MESSAGE, null);
		}


		p.getOwnedNode().add(keyValueParagraph);
		p.setRawText(null);

	}



	/**
	 * Requirement Levels left at stack must be removed and 
	 * added corresponding levels
	 */
	private static void emptyStack() {

		while(!paragraphStack.isEmpty()){

			Paragraph poppedParagraph = paragraphStack.pop();	

			if(paragraphLevelMap.get(poppedParagraph) == 1){

				documentObject.getOwnedParagraph().add(poppedParagraph);
			}else{

				paragraphStack.peek().getOwnedNode().add(poppedParagraph);			
			}


		}
	}

	/**
	 * Saves the model instance and writes it to xmi file
	 * @param output 
	 * 
	 * @param product
	 */
	private static Resource createXMIFile(Document document, String output) {

		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML Factory implementation using xmi extension
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"xmi", new  XMLResourceFactoryImpl());


		// Create empty resource with the given URI
		Resource resource = resourceSet.createResource(URI.createURI(output));

		// Add Product to contents list of the resource 

		resource.getContents().add(document);

		try{

			// Save the resource
			//resource.save(System.out, Collections.EMPTY_MAP); 
			resource.save(null);
			//final JFrame frame = new JFrame();
			//JOptionPane.showMessageDialog(frame, "Model created successfully!");
			return resource;


		}catch (IOException e) {

			e.printStackTrace();
		}

		return null;
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
		headingMap.put("SubHeader", 11);
		headingMap.put("ListParagraph", 12);


	}

}
