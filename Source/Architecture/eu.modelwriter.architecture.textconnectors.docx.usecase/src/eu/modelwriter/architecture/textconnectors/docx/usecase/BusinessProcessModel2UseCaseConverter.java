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
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.Document;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.xmlbeans.XmlException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

import useCase.Actor;
import useCase.Documentation;
import useCase.EndEvent;
import useCase.FlowElement;
import useCase.FlowNode;
import useCase.Interest;
import useCase.SequenceFlow;
import useCase.Specification;
import useCase.StartEvent;
import useCase.UseCase;
import useCase.Process;

public class BusinessProcessModel2UseCaseConverter {

	private final static String PRIMARY_ACTOR = "Primary Actor";
	private final static String STAKEHOLDERS_AND_INTERESTS = "Stakeholders and Interests";
	private final static String PRECONDITION = "Preconditions";
	private final static String SUCCESS_GUARANTEE = "Success Guarantee (Postcondition)";
	//private final static String POSTCONDITION = "Postcondition";
	private final static String MAIN_SUCCESS_SCENARIO = "Main Success Scenario (or Basic Flow)";
	//private final static String BASIC_FLOW = "Basic Flow";
	private final static String EXTENSIONS = "Extensions (or Alternative Flows)";
	//private final static String ALTERNATIVE_FLOWS = "Alternative Flows";

	private static int headerCounter = 0;
	private static Resource resource;
	private static XWPFDocument document;

	public static void main(String[] args) throws IOException, XmlException {

		// Get template document which includes heading styles
		/*
		 * URL url = new URL("platform:/plugin/eu.modelwriter.architecture.textconnectors.docx.usecase/templates/template.docx");   
		XWPFDocument template = new XWPFDocument(url.openConnection().getInputStream());

		 */
		XWPFDocument template = new XWPFDocument(new FileInputStream("templates/template.docx"));

		document = new XWPFDocument(); 
		

		XWPFStyles newStyles = document.createStyles();
		newStyles.setStyles(template.getStyle());
		//XWPFNumbering numbering = document.createNumbering();
		

		FileOutputStream out = new FileOutputStream(new File("model/Test UceCase.docx"));

		try {

			URI uri = URI.createURI("model/TestDocument.xmi");

			ResourceSet resourceSet = new ResourceSetImpl();

			// register UML
			Map packageRegistry = resourceSet.getPackageRegistry();
			packageRegistry.put(useCase.UseCasePackage.eNS_URI, useCase.UseCasePackage.eINSTANCE);

			// Register XML resource as UMLResource.Factory.Instance
			Map extensionFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
			extensionFactoryMap.put("xmi", new XMIResourceFactoryImpl());

			// Get the resource
			resource = (Resource)resourceSet.createResource(uri);
			// try to load the file into resource
			resource.load(null);

			// Write content of resource file
			//resource.save(System.out, Collections.EMPTY_MAP);

			Iterator<EObject> resourceObjects = resource.getAllContents();	

			while (resourceObjects.hasNext()) {
				Object o = resourceObjects.next();

				//System.out.println(o.toString());

				// Traversing Product's children
				if(o instanceof Specification){

					for(UseCase useCase : ((Specification)o).getOwnedUseCase()){

						writeUseCase(useCase);
					}
				}



			}

			document.write(out);
			out.close();

			final JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Docx file created successfully!");

		}// end of try
		catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}


		// return document

	}

	private static void writeUseCase(UseCase useCase) {

		writeHeader(useCase.getName());
		writePrimaryActor(useCase.getPrimaryActor());
		writeStakeholdersAndInterests(useCase.getOwnedStakeholderInterest());
		writePreconditions(useCase.getOwnedAlternativeFlow());
		writePostconditions(useCase.getOwnedAlternativeFlow());
		writeMainFlow(useCase);
		writeExtensions(useCase);

	}

	private static void writePostconditions(EList<Process> ownedAlternativeFlow) {

		for(Process process : ownedAlternativeFlow){

			if(process.getName().equals(SUCCESS_GUARANTEE)){

				XWPFParagraph paragraph = document.createParagraph();
				XWPFRun run = paragraph.createRun();

				paragraph.setAlignment(ParagraphAlignment.LEFT);

				run.setText(SUCCESS_GUARANTEE + ":");
				run.setBold(true);
				//run.addBreak();

				for(FlowElement flowElement : process.getOwnedFlowElements()){

					if(flowElement instanceof EndEvent){

						paragraph = document.createParagraph();
						//paragraph.setStyle("ListParagraph");
						//paragraph.setNumID(BigInteger.valueOf(1));
						run = paragraph.createRun();
						run.setText(flowElement.getDocumentation().get(0).getText());
						
						
					}
				}
			}
		}

	}

	private static void writePreconditions(EList<Process> ownedAlternativeFlow) {

		for(Process process : ownedAlternativeFlow){

			if(process.getName().equals(PRECONDITION)){

				XWPFParagraph paragraph = document.createParagraph();
				XWPFRun run = paragraph.createRun();

				paragraph.setAlignment(ParagraphAlignment.LEFT);

				run.setText(PRECONDITION + ":");
				run.setBold(true);
				//run.addBreak();

				for(FlowElement flowElement : process.getOwnedFlowElements()){

					if(flowElement instanceof StartEvent){

						paragraph = document.createParagraph();
						//paragraph.setStyle("List Paragraph");
						//paragraph.setNumID(BigInteger.valueOf(2));
						run = paragraph.createRun();
						run.setText(flowElement.getDocumentation().get(0).getText());
					}
				}
			}
		}

	}

	private static void writeExtensions(UseCase useCase) {

		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();

		paragraph.setAlignment(ParagraphAlignment.LEFT);

		run.setText(EXTENSIONS + ":");
		run.setBold(true);
		//run.addBreak();

		SequenceFlow sequenceFlow = null;
		int tabCount = 0;
		FlowNode previousController = null;

		boolean flag = false;

		for(Process process : useCase.getOwnedAlternativeFlow()){

			if(!(process.getName().equals(PRECONDITION)) && !(process.getName().equals(SUCCESS_GUARANTEE))){

				for(FlowElement flowElement : process.getOwnedFlowElements()){

					if(flowElement instanceof SequenceFlow){

						sequenceFlow = (SequenceFlow)flowElement;

						FlowNode sourceNode = (FlowNode)sequenceFlow.getSource();
						FlowNode targetNode = (FlowNode)sequenceFlow.getTarget();


						if(!(sourceNode instanceof StartEvent) && sourceNode != previousController){

							paragraph = document.createParagraph();
							run = paragraph.createRun();

							if(sourceNode.getDocumentation().get(0).getTextFormat() != null){

								String[] v = sourceNode.getDocumentation().get(0).getTextFormat()
										.split(":");
								tabCount = Integer.parseInt(v[1]);
							}						

							if(tabCount > 0){
								CTR ctr = run.getCTR();
								
								for(int i = 0; i < tabCount; i++){

									
									ctr.addNewTab();
								}
							}
							

							run.setText(sourceNode.getLabel() + ". " + 
									sourceNode.getDocumentation().get(0).getText() + ".");
						}


						if(!(targetNode instanceof EndEvent)){

							paragraph = document.createParagraph();
							run = paragraph.createRun();

							if(targetNode.getDocumentation().get(0).getTextFormat() != null){

								String[] v = targetNode.getDocumentation().get(0).getTextFormat()
										.split(":");
								tabCount = Integer.parseInt(v[1]);
							}

							if(tabCount > 0){
								CTR ctr = run.getCTR();
								
								for(int i = 0; i < tabCount; i++){

									
									ctr.addNewTab();
								}
							}

							run.setText(targetNode.getLabel() + ". " + 
									targetNode.getDocumentation().get(0).getText() + ".");

						}

						previousController = targetNode;

					}

				}

			}
		}
	}

	private static void writeMainFlow(UseCase useCase) {

		List<Documentation> docList = useCase.getDocumentation();
		boolean isNumbered = false;
		
		for (Documentation documentation : docList) {
			
			if(documentation.getTextFormat().equals("ListParagraph")){
				isNumbered = true;
			}
		}
		
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();

		paragraph.setAlignment(ParagraphAlignment.LEFT);

		run.setText("Main Success Scenario (or Basic Flow):");
		run.setBold(true);
		//run.addBreak();

		SequenceFlow sequenceFlow = null;
		FlowNode previousController = null;

		for(FlowElement flowElement : useCase.getOwnedMainFlow().getOwnedFlowElements()){

			if(flowElement instanceof SequenceFlow){

				sequenceFlow = (SequenceFlow)flowElement;

				FlowNode sourceNode = (FlowNode)sequenceFlow.getSource();
				FlowNode targetNode = (FlowNode)sequenceFlow.getTarget();

				
				//run = paragraph.createRun();
				String runText = "";
				
				if(!(sourceNode instanceof StartEvent) && sourceNode != previousController){

					paragraph = document.createParagraph();

					if(isNumbered){
						paragraph.setStyle("ListParagraph");
						paragraph.setNumID(BigInteger.valueOf(1));
					}
					run = paragraph.createRun();
					
					if(!isNumbered){
						runText += sourceNode.getLabel() + ". " ;
					}
					runText += sourceNode.getDocumentation().get(0).getText();
					
					run.setText(runText);

				}

				if(!(targetNode instanceof EndEvent)){

					paragraph = document.createParagraph();
					run = paragraph.createRun();

					if(isNumbered){
						paragraph.setStyle("ListParagraph");
						paragraph.setNumID(BigInteger.valueOf(1));
					}
					
					if(!isNumbered){
						runText += targetNode.getLabel() + ". " ;
					}
					runText += targetNode.getDocumentation().get(0).getText();
					
					run.setText(runText);

				}

				previousController = targetNode;

			}

		}

	}

	private static void writeStakeholdersAndInterests(
			EList<Interest> ownedStakeholderInterest) {

		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();

		paragraph.setAlignment(ParagraphAlignment.LEFT);
		run.setText("Stakeholders and Interests:");
		run.setBold(true);
		//run.addBreak();

		for(Interest interest : ownedStakeholderInterest){

			paragraph = document.createParagraph();
			//paragraph.setStyle("ListParagraph");	
			//paragraph.setNumID(BigInteger.valueOf(2));
			run = paragraph.createRun();

			for(Actor interestActor : interest.getActor()){

				run.setText(interestActor.getName() + " : " + 
						interest.getDocumentation().get(interest.getActor().indexOf(interestActor)).getText());
			}

			//run.addBreak();
		}

	}

	private static void writePrimaryActor(EList<Actor> eList) {

		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();

		paragraph.setAlignment(ParagraphAlignment.LEFT);

		run.setText("Primary Actor : ");
		run.setFontFamily("Calibri");
		run.setBold(true);

		String actors = "";

		for(Actor actor : eList){

			run = paragraph.createRun();
			actors += actor.getName() + " ";
		}

		run.setText(actors.trim().replaceAll(" ", ", "));

		//run2.addBreak();
	}

	private static void writeHeader(String name) {

		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();

		paragraph.setStyle("Heading1");
		paragraph.setNumID(BigInteger.valueOf(2));
		paragraph.setAlignment(ParagraphAlignment.LEFT);
		headerCounter++;

		run.setText(name);
		run.setFontFamily("Calibri Light");
		run.setBold(true);
		// TODO alt çizgi eklenicek
		//run.setUnderline(UnderlinePatterns.SINGLE);
		paragraph.setBorderBottom(Borders.BASIC_THIN_LINES);	

		run.setColor("000000");
		//run.addBreak();

	}



}
