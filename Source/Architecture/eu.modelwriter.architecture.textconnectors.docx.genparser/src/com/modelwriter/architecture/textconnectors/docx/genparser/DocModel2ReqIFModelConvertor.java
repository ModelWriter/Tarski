/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
package com.modelwriter.architecture.textconnectors.docx.genparser;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
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
import org.eclipse.rmf.reqif10.pror.configuration.ConfigurationFactory;
import org.eclipse.rmf.reqif10.pror.configuration.ProrToolExtension;

import DocModel.Document;
import DocModel.Paragraph;
import DocModel.Part;


public class DocModel2ReqIFModelConvertor {

  public static ReqIF10Factory factory = ReqIF10Factory.eINSTANCE;

  private static Resource resource;

  private static AttributeDefinitionString attributeDefinitionStringPrimaryActor;

  private static AttributeDefinitionString attributeDefinitionStringId;

  private static AttributeDefinitionString attributeDefinitionStringDescription;

  private static SpecObjectType specObjectType;

  private static Specification specification;

  private static ReqIFContent reqifContent;

  public static ReqIF convert(Resource r) {

    ReqIF reqif = factory.createReqIF();
    reqifContent = factory.createReqIFContent();
    specification = factory.createSpecification();
    specObjectType = factory.createSpecObjectType();
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
    ProrToolExtension prorExtension = null;

    prorExtension = ConfigurationFactory.eINSTANCE.createProrToolExtension();

    SpecView view = new SpecView();

    com.modelwriter.architecture.textconnectors.docx.genparser.Column columnId =
        new com.modelwriter.architecture.textconnectors.docx.genparser.Column();
    columnId.setLabel("ID");
    columnId.setWidth(250);

    com.modelwriter.architecture.textconnectors.docx.genparser.Column columnDecsription =
        new com.modelwriter.architecture.textconnectors.docx.genparser.Column();
    columnDecsription.setLabel("Description");
    columnDecsription.setWidth(250);

    // com.modelwriter.architecture.textconnectors.docx.genparser.Column columnPrimaryActor =
    // new com.modelwriter.architecture.textconnectors.docx.genparser.Column();
    // columnPrimaryActor.setLabel("Primary Actor");
    // columnPrimaryActor.setWidth(150);

    view.getColumns().add(columnId);
    view.getColumns().add(columnDecsription);
    // view.getColumns().add(columnPrimaryActor);

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


    attributeDefinitionStringDescription = factory.createAttributeDefinitionString();
    attributeDefinitionStringDescription.setLongName("Description");
    attributeDefinitionStringDescription.setType(description);

    attributeDefinitionStringId = factory.createAttributeDefinitionString();
    attributeDefinitionStringId.setLongName("ID");
    attributeDefinitionStringId.setType(id);

    // attributeDefinitionStringPrimaryActor = factory.createAttributeDefinitionString();
    // attributeDefinitionStringPrimaryActor.setLongName("Primary Actor");
    // attributeDefinitionStringPrimaryActor.setType(primaryActor);

    // specObjectType
    specObjectType.setIdentifier("id");
    specObjectType.setLongName("Requirement Type");
    specObjectType.setDesc("requirement");

    specObjectType.getSpecAttributes().add(attributeDefinitionStringDescription);
    specObjectType.getSpecAttributes().add(attributeDefinitionStringId);
    // specObjectType.getSpecAttributes().add(attributeDefinitionStringPrimaryActor);

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

        if (o instanceof Document) {
          Document d = (Document) o;

          createReqIFFromDocModel(d.getOwnedParagraph(), null, 0);

          // for (Paragraph useCaseParagraph : d.getOwnedParagraph()) {
          //
          // String[] values = useCaseParagraph.getName().split(":");
          //
          // SpecHierarchy sh = factory.createSpecHierarchy();
          //
          // AttributeValueString attributeValueId = factory.createAttributeValueString();
          // attributeValueId.setDefinition(attributeDefinitionStringId);
          // attributeValueId.setTheValue(useCaseParagraph.getId());
          //
          // AttributeValueString attributeValueDesc = factory.createAttributeValueString();
          // attributeValueDesc.setDefinition(attributeDefinitionStringDescription);
          // attributeValueDesc.setTheValue(values[1]);
          //
          // AttributeValueString attributeValuePrimaryActor = factory.createAttributeValueString();
          // attributeValuePrimaryActor.setDefinition(attributeDefinitionStringPrimaryActor);
          // attributeValuePrimaryActor.setTheValue(getPrimaryActor(useCaseParagraph));
          //
          // SpecObject so = factory.createSpecObject();
          // so.setLongName(values[0]);
          // so.getValues().add(attributeValueId);
          // so.getValues().add(attributeValueDesc);
          // so.getValues().add(attributeValuePrimaryActor);
          // so.setType(specObjectType);
          //
          // sh.setEditable(false);
          // sh.setObject(so);
          //
          // specification.getChildren().add(sh);
          // reqifContent.getSpecObjects().add(so);
          //
          // }

        }
      }

    } // end of try
    catch (NullPointerException | IOException e) {
      e.printStackTrace();
    }

    view.setSpecification(specification);
    reqif.setCoreContent(reqifContent);

    return reqif;
  }

  private static void createReqIFFromDocModel(EList<Paragraph> p, SpecHierarchy specHierarchy,
      int level) {
    level++;
    if (p == null)
      return;
    int hierarchy = 1;
    for (Paragraph useCaseParagraph : p) {
      if (useCaseParagraph == null || useCaseParagraph.getName() == null
          || (useCaseParagraph.getName().isEmpty() && useCaseParagraph.getRawText().isEmpty()))
        return;
      boolean flag = false;
      String[] values = useCaseParagraph.getName().split(":");



      SpecHierarchy sh = factory.createSpecHierarchy();

      AttributeValueString attributeValueId = factory.createAttributeValueString();
      attributeValueId.setDefinition(attributeDefinitionStringId);
      if (level == 1)
        attributeValueId.setTheValue(String.valueOf(hierarchy));
      else
        attributeValueId.setTheValue(
            ((AttributeValueString) specHierarchy.getObject().getValues().get(0)).getTheValue()
                + "." + String.valueOf(hierarchy));

      hierarchy++;

      AttributeValueString attributeValueDesc = factory.createAttributeValueString();
      attributeValueDesc.setDefinition(attributeDefinitionStringDescription);


      // AttributeValueString attributeValuePrimaryActor = factory.createAttributeValueString();
      // attributeValuePrimaryActor.setDefinition(attributeDefinitionStringPrimaryActor);

      if (useCaseParagraph.getRawText() != null && !useCaseParagraph.getRawText().isEmpty()
          && useCaseParagraph.getName().length() != 0
          && useCaseParagraph.getName().charAt(0) == '*') {
        attributeValueDesc.setTheValue(useCaseParagraph.getRawText());
        // attributeValuePrimaryActor.setTheValue("");
      } else {
        try {
          if (useCaseParagraph.getName().length() == 0)
            throw new NumberFormatException();
          Integer.parseInt(String.valueOf(useCaseParagraph.getName().charAt(0)));
          if (useCaseParagraph.getRawText() != null && !useCaseParagraph.getRawText().isEmpty())
            attributeValueDesc.setTheValue(useCaseParagraph.getRawText());
          else {
            if (!useCaseParagraph.getOwnedNode().isEmpty()) {
              createReqIFFromDocModel(useCaseParagraph.getOwnedNode(), specHierarchy, level);
              continue;
            } else
              continue;
          }

          // attributeValuePrimaryActor.setTheValue("");
        } catch (NumberFormatException e) {
          attributeValueDesc.setTheValue(useCaseParagraph.getName());
          if (!useCaseParagraph.getName().equals(useCaseParagraph.getRawText())) {
            // attributeValuePrimaryActor.setTheValue(useCaseParagraph.getRawText());
            flag = true;
          } else {
            // attributeValuePrimaryActor.setTheValue("");
          }

        }
      }



      SpecObject so = factory.createSpecObject();
      so.setLongName(values[0]);
      so.getValues().add(attributeValueId);
      so.getValues().add(attributeValueDesc);
      // so.getValues().add(attributeValuePrimaryActor);
      so.setType(specObjectType);

      sh.setEditable(false);
      sh.setObject(so);

      if (useCaseParagraph.getName().equals("Primary Actor")) {
        // attributeValuePrimaryActor
        // .setTheValue(getPrimaryActor((Paragraph) useCaseParagraph.eContainer()));
        addNewSpecHierarchy(sh, getPrimaryActor((Paragraph) useCaseParagraph.eContainer()),
            useCaseParagraph.getId());
      }
      if (flag)
        addNewSpecHierarchy(sh, useCaseParagraph.getRawText(), useCaseParagraph.getId());

      if (specHierarchy != null)
        specHierarchy.getChildren().add(sh);
      if (level == 1)
        specification.getChildren().add(sh);

      reqifContent.getSpecObjects().add(so);

      if (!useCaseParagraph.getOwnedNode().isEmpty())
        createReqIFFromDocModel(useCaseParagraph.getOwnedNode(), sh, level);
    }


  }

  private static void addNewSpecHierarchy(SpecHierarchy specHierarchy, String string,
      String paragraphId) {
    int hierarchy = 1;
    if (specHierarchy.getObject().getLongName().equals("Primary Actor")) {
      String[] values = string.split(",");
      for (String string2 : values) {
        SpecHierarchy sh = factory.createSpecHierarchy();

        AttributeValueString attributeValueId = factory.createAttributeValueString();
        attributeValueId.setDefinition(attributeDefinitionStringId);
        attributeValueId.setTheValue(
            ((AttributeValueString) specHierarchy.getObject().getValues().get(0)).getTheValue()
                + "." + String.valueOf(hierarchy));

        hierarchy++;

        AttributeValueString attributeValueDesc = factory.createAttributeValueString();
        attributeValueDesc.setDefinition(attributeDefinitionStringDescription);
        attributeValueDesc.setTheValue(string2);

        AttributeValueString attributeValuePrimaryActor = factory.createAttributeValueString();
        attributeValuePrimaryActor.setDefinition(attributeDefinitionStringPrimaryActor);
        attributeValuePrimaryActor.setTheValue("");

        SpecObject so = factory.createSpecObject();
        so.setLongName(string2);
        so.getValues().add(attributeValueId);
        so.getValues().add(attributeValueDesc);
        so.getValues().add(attributeValuePrimaryActor);
        so.setType(specObjectType);

        sh.setEditable(false);
        sh.setObject(so);
        specHierarchy.getChildren().add(sh);
        reqifContent.getSpecObjects().add(so);
      }
    } else {
      SpecHierarchy sh = factory.createSpecHierarchy();

      AttributeValueString attributeValueId = factory.createAttributeValueString();
      attributeValueId.setDefinition(attributeDefinitionStringId);
      attributeValueId.setTheValue(
          ((AttributeValueString) specHierarchy.getObject().getValues().get(0)).getTheValue() + "."
              + String.valueOf(hierarchy));

      AttributeValueString attributeValueDesc = factory.createAttributeValueString();
      attributeValueDesc.setDefinition(attributeDefinitionStringDescription);
      attributeValueDesc.setTheValue(string);

      AttributeValueString attributeValuePrimaryActor = factory.createAttributeValueString();
      attributeValuePrimaryActor.setDefinition(attributeDefinitionStringPrimaryActor);
      attributeValuePrimaryActor.setTheValue("");

      SpecObject so = factory.createSpecObject();
      so.setLongName(string);
      so.getValues().add(attributeValueId);
      so.getValues().add(attributeValueDesc);
      so.getValues().add(attributeValuePrimaryActor);
      so.setType(specObjectType);

      sh.setEditable(false);
      sh.setObject(so);
      specHierarchy.getChildren().add(sh);
      reqifContent.getSpecObjects().add(so);

    }

  }

  /*
   * Returns the concatenation of actors of the usecase
   */
  private static String getPrimaryActor(Paragraph useCaseParagraph) {

    String actors = "";

    for (Paragraph p : useCaseParagraph.getOwnedNode()) {

      if (p.getName() != null && p.getName().toLowerCase().contains("actor")) {

        if (p.getOwnedPart().size() != 0) {
          int counter = 0;

          for (Part part : p.getOwnedPart()) {
            counter++;
            if (counter > 1) {
              actors += "," + part.getName();
            } else {
              actors += part.getName();
            }
          }
        }
      }
    }

    return actors;
  }

}
