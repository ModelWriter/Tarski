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
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class TableExtractor {

	private final static String filename = "testdata/table2.docx"; 

	// current paragraph
	private static XWPFParagraph paragraph; 

	public static void main(String[] args) throws IOException {

		File file = null; 
		FileInputStream fis = null; 
		XWPFDocument document = null;
		List<XWPFParagraph> paraList = null; 
		file = new File(filename); 
		fis = new FileInputStream(file); 
		document = new XWPFDocument(fis); 

		Iterator<IBodyElement> bodyElementIterator = document.getBodyElementsIterator();
		while(bodyElementIterator.hasNext()) {
			IBodyElement element = bodyElementIterator.next();

			if("PARAGRAPH".equalsIgnoreCase(element.getElementType().name())){
				
				List<XWPFParagraph> pList = element.getBody().getParagraphs();
				
					for (XWPFParagraph p: pList){
						System.out.println(p.getText());
					}
			}

			else if("TABLE".equalsIgnoreCase(element.getElementType().name())) {
				List<XWPFTable> tableList =  element.getBody().getTables();
				for (XWPFTable table: tableList){
					System.out.println("Total Number of Rows of Table:"+table.getNumberOfRows());
					System.out.println(table.getText());
				}
			}
		}

	}

}
