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

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.acceleo.profiler.ProfileResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.rmf.reqif10.AttributeDefinitionString;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.DatatypeDefinitionString;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.ReqIF10Factory;
import org.eclipse.rmf.reqif10.ReqIFContent;
import org.eclipse.rmf.reqif10.ReqIFHeader;
import org.eclipse.rmf.reqif10.ReqIFToolExtension;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecObjectType;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.reqif10.SpecificationType;
import org.eclipse.rmf.reqif10.pror.configuration.Column;
import org.eclipse.rmf.reqif10.pror.configuration.ProrPresentationConfiguration;
import org.eclipse.rmf.reqif10.pror.configuration.ProrSpecViewConfiguration;
import org.eclipse.rmf.reqif10.pror.configuration.ProrToolExtension;
import org.eclipse.rmf.reqif10.pror.configuration.impl.ColumnImpl;
import org.eclipse.rmf.reqif10.pror.configuration.impl.ProrSpecViewConfigurationImpl;
import org.eclipse.rmf.reqif10.pror.configuration.impl.ProrToolExtensionImpl;

import DocModel.Document;
import DocModel.Paragraph;
import DocModel.Part;


public class DocModel2ReqIFModelConvertor {

	public static ReqIF10Factory factory = ReqIF10Factory.eINSTANCE;
	
	private static Resource resource;

	public static ReqIF convert(Resource r) {
		
		ReqIF reqif = factory.createReqIF();
		ReqIFContent reqifContent = factory.createReqIFContent();
		Specification specification = factory.createSpecification();
		SpecObjectType specObjectType = factory.createSpecObjectType();
		SpecificationType specificationType = factory.createSpecificationType();
		
		// Header
		ReqIFHeader header = factory.createReqIFHeader();
		header.setComment("Created by: furkan.tanriverdi");
		header.setReqIFVersion("1.0.1");
		header.setReqIFToolId("ProR (http://pror.org)");
		header.setSourceToolId("ProR (http://pror.org)");
		reqif.setTheHeader(header);
		
		// setting the view
		ReqIFToolExtension reqifTool = factory.createReqIFToolExtension();
		ProrToolExtension prorExtension = new ProrToolExtensionImpl();
		SpecView view = new SpecView();
		
		com.modelwriter.architecture.textconnectors.docx.genparser.Column columnId 
		= new com.modelwriter.architecture.textconnectors.docx.genparser.Column();
		columnId.setLabel("ID");
		columnId.setWidth(250);
		
		com.modelwriter.architecture.textconnectors.docx.genparser.Column columnDecsription 
		= new com.modelwriter.architecture.textconnectors.docx.genparser.Column();
		columnDecsription.setLabel("Description");
		columnDecsription.setWidth(250);
		
		com.modelwriter.architecture.textconnectors.docx.genparser.Column columnPrimaryActor
		= new com.modelwriter.architecture.textconnectors.docx.genparser.Column();
		columnPrimaryActor.setLabel("Primary Actor");
		columnPrimaryActor.setWidth(150);
		
		view.getColumns().add(columnId);
		view.getColumns().add(columnDecsription);
		view.getColumns().add(columnPrimaryActor);
		
		prorExtension.getSpecViewConfigurations().add(view);
		reqifTool.getExtensions().add(prorExtension);
		reqif.getToolExtensions().add(reqifTool);
		
		// Data type definitions
		DatatypeDefinitionString id = factory.createDatatypeDefinitionString();
		id.setLongName("T_ID");
		
		DatatypeDefinitionString description = factory.createDatatypeDefinitionString();
		description.setLongName("T_Description");
		
		DatatypeDefinitionString primaryActor = factory.createDatatypeDefinitionString();
		primaryActor.setLongName("T_PrimaryActor");
		
		reqifContent.getDatatypes().add(description);
		reqifContent.getDatatypes().add(id);
		reqifContent.getDatatypes().add(primaryActor);
		
		// ATTRIBUTE DEFINITION
		AttributeDefinitionString attributeDefinitionStringId = 
				factory.createAttributeDefinitionString();
		attributeDefinitionStringId.setLongName("ID");
		attributeDefinitionStringId.setType(id);
		
		AttributeDefinitionString attributeDefinitionStringDescription = 
				factory.createAttributeDefinitionString();
		attributeDefinitionStringDescription.setLongName("Description");
		attributeDefinitionStringDescription.setType(description);
		
		AttributeDefinitionString attributeDefinitionStringPrimaryActor = 
				factory.createAttributeDefinitionString();
		attributeDefinitionStringPrimaryActor.setLongName("Primary Actor");
		attributeDefinitionStringPrimaryActor.setType(primaryActor);
		
		// specObjectType
		specObjectType.setIdentifier("id");
		specObjectType.setLongName("Requirement Type");
		specObjectType.setDesc("requirement");
		
		specObjectType.getSpecAttributes().add(attributeDefinitionStringDescription);
		specObjectType.getSpecAttributes().add(attributeDefinitionStringId);
		specObjectType.getSpecAttributes().add(attributeDefinitionStringPrimaryActor);
		
		// Specification Type
		specificationType.setLongName("Specification Type");
		specificationType.setDesc("Use Case Document");

		reqifContent.getSpecTypes().add(specificationType);
		reqifContent.getSpecTypes().add(specObjectType);
		
		specification.setIdentifier("id");
		specification.setLongName("Document");	
		specification.setDesc("Use Cases");
		specification.setType(specificationType);
						
		reqifContent.getSpecifications().add(specification);
		
		try {

			// Get the resource
			resource = r;
			// try to load the file into resource
			resource.load(null);

			Iterator<EObject> resourceObjects = resource.getAllContents();	

			while (resourceObjects.hasNext()) {
				Object o = resourceObjects.next();
				
				if(o instanceof Document){
					Document d = (Document)o;
						
					for (Paragraph useCaseParagraph : d.getOwnedParagraph()) {
						
						String[] values = useCaseParagraph.getName().split(":");
						
						SpecHierarchy sh = factory.createSpecHierarchy();
						
						AttributeValueString attributeValueId = 
								factory.createAttributeValueString();
						attributeValueId.setDefinition(attributeDefinitionStringId);
						attributeValueId.setTheValue(useCaseParagraph.getId());
						
						AttributeValueString attributeValueDesc = 
								factory.createAttributeValueString();
						attributeValueDesc.setDefinition(attributeDefinitionStringDescription);
						attributeValueDesc.setTheValue(values[1]);						
								
						AttributeValueString attributeValuePrimaryActor = 
								factory.createAttributeValueString();
						attributeValuePrimaryActor.setDefinition(attributeDefinitionStringPrimaryActor);
						attributeValuePrimaryActor.setTheValue(getPrimaryActor(useCaseParagraph));	
						
						SpecObject so = factory.createSpecObject();
						so.setLongName(values[0]);
						so.getValues().add(attributeValueId);
						so.getValues().add(attributeValueDesc);
						so.getValues().add(attributeValuePrimaryActor);
						so.setType(specObjectType);
						
						sh.setEditable(false);
						sh.setObject(so);
						
						specification.getChildren().add(sh);
						reqifContent.getSpecObjects().add(so);
						
					}
					
				}	
			}

		}// end of try
		catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}
		
		view.setSpecification(specification);	
		reqif.setCoreContent(reqifContent);
	
		return reqif;
	}

	/*
	 * Returns the concatenation of actors of the usecase
	 */
	private static String getPrimaryActor(Paragraph useCaseParagraph) {
		
		String actors = "";
		
		for (Paragraph p : useCaseParagraph.getOwnedNode()) {
			
			if(p.getName() != null && p.getName().toLowerCase().contains("actor")){
				
				if(p.getOwnedPart().size() != 0){
					int counter = 0;
					
					for (Part part : p.getOwnedPart()) {
						counter++;
						if(counter > 1){
							actors += "," + part.getName();
						}else{
							actors += part.getName();
						}
					}
				}
			}
		}
		
		return actors;
	}

}
