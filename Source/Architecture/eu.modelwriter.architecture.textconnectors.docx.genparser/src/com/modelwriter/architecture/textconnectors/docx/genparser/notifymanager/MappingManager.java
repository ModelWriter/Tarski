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
package com.modelwriter.architecture.textconnectors.docx.genparser.notifymanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.eclipse.emf.ecore.EObject;

import DocModel.Paragraph;
import DocModel.Part;


public class MappingManager {
	
	private static Map<String, List<XWPFRun>> map = new HashMap<String, List<XWPFRun>>();

	private static Map<String, XWPFParagraph> objectMap = new HashMap<String, XWPFParagraph>();
	
	private static Map<String, Paragraph> modelMap = new HashMap<String, Paragraph>();
			
	private static String documentPath = "";
	// Singleton
	private static MappingManager instance = null;
	private static XWPFDocument docInstance = null;
	
	public void setDocument(XWPFDocument d){
		
		docInstance = d;
	}
	
	public static XWPFDocument getXWPFDocInstance(){

	      return docInstance;
	}
	
	public static MappingManager getInstance() {
	      if(instance == null) {
	         instance = new MappingManager();
	      }
	      return instance;
	   }
	
	public void mapRuns(String paragraphId, List<XWPFRun> runList){
			map.put(paragraphId, runList);
	}
	
	public void printMap(){
		
		for (Map.Entry <String, List<XWPFRun>> entry : map.entrySet()) {
			
			System.out.println(entry.getKey() + "---------------");
			
			for(XWPFRun run : entry.getValue()){
				
				System.out.println("Run : " + run.toString());
			}
		}
	}

	/*
	 * public void changePartName(String id, String newOne) {
		
		int i = 0;
		String s = "";
		
	}
	 */

	public void changeParagraphName(String id, String newOne) {
		
		
	}

	public void mapParagraph(String id, XWPFParagraph p) {
		
		objectMap.put(id, p);
	}

	/*
	 * public void mapPart(String id, Part part) {
		
		objectMap.put(id, part);
	}

	 */
	public void removeParagraph(String id) {
		
		
		//docInstance.removeBodyElement(docInstance.getPosOfParagraph((XWPFParagraph) objectMap.get(id)));
		/*
		 * XWPFParagraph p = objectMap.get(id);
		docInstance.getParagraphs().remove(p);
		 */
		XWPFParagraph p = objectMap.get(id);
		Paragraph paragraph = modelMap.get(id);
		
		if(paragraph.getOwnedNode().size()>0){
			deleteContainments(paragraph);
		}
		
		int position = docInstance.getPosOfParagraph(p);
		docInstance.removeBodyElement( position );
		map.remove(id);
		objectMap.remove(id);	
		modelMap.remove(id);

	}

	private void deleteContainments(Paragraph paragraph) {
		
		
		
		if(paragraph.getOwnedNode().size() > 0){
			for(Paragraph para : paragraph.getOwnedNode()){

				deleteContainments(para);
			}
		}
		
		delete(paragraph.getId());

	}

	private void delete(String id) {
		
		XWPFParagraph p = objectMap.get(id);
		int position = docInstance.getPosOfParagraph(p);
		docInstance.removeBodyElement( position );
		map.remove(id);
		objectMap.remove(id);	
		modelMap.remove(id);
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		MappingManager.documentPath = documentPath;
	}

	public void mapDocModelPara(String id, Paragraph paragraph) {
		
		modelMap.put(id, paragraph);
	}

	
	
	
}
