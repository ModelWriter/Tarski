package eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.rmf.reqif10.AttributeDefinitionString;
import org.eclipse.rmf.reqif10.DatatypeDefinitionString;
import org.eclipse.rmf.reqif10.ReqIF10Factory;
import org.eclipse.rmf.reqif10.ReqIFContent;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecObjectType;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.reqif10.impl.ReqIFImpl;

public class MarkdownToReqifWizard extends Wizard {

  private CreatingReqifSpecPage page;
  private ArrayList<SpecHierarchy> listOfSpecs;
  private ArrayList<SpecObject> listOfObjects;

  public MarkdownToReqifWizard(ArrayList<SpecHierarchy> arrayList, ArrayList<SpecObject> objects) {
    this.listOfSpecs = arrayList;
    this.listOfObjects = objects;
  }

  @Override
  public void addPages() {
    this.page = new CreatingReqifSpecPage();
    super.addPages();
    addPage(this.page);
  }

  @Override
  public String getWindowTitle() {
    return "Creating Reqif Spec";
  }

  @Override
  public boolean performFinish() {
    EObject eObject = (EObject) CreatingReqifSpecPage.markTreeViewer.getCheckedElements()[0];
    if (eObject instanceof SpecHierarchy) {
      SpecHierarchy specHier = (SpecHierarchy) eObject;
      Resource resource = specHier.eResource();
      try {
        resource.load(null);
      } catch (IOException e1) {
        e1.printStackTrace();
      }

      specHier.getChildren().addAll(this.listOfSpecs);
      ReqIFImpl impl = (ReqIFImpl) resource.getContents().get(0);
      ReqIFContent reqIFContent = impl.getCoreContent();
      reqIFContent.getSpecObjects().addAll(this.listOfObjects);

      AttributeDefinitionString attributeDefinitionStringId;

      AttributeDefinitionString attributeDefinitionStringDescription;

      DatatypeDefinitionString id = ReqIF10Factory.eINSTANCE.createDatatypeDefinitionString();
      id.setLongName("T_ID");

      DatatypeDefinitionString description =
          ReqIF10Factory.eINSTANCE.createDatatypeDefinitionString();
      description.setLongName("T_Description");

      reqIFContent.getDatatypes().add(description);
      reqIFContent.getDatatypes().add(id);

      attributeDefinitionStringDescription =
          ReqIF10Factory.eINSTANCE.createAttributeDefinitionString();
      attributeDefinitionStringDescription.setLongName("Description");
      attributeDefinitionStringDescription.setType(description);

      attributeDefinitionStringId = ReqIF10Factory.eINSTANCE.createAttributeDefinitionString();
      attributeDefinitionStringId.setLongName("ID");
      attributeDefinitionStringId.setType(id);

      SpecObjectType specObjectType = ReqIF10Factory.eINSTANCE.createSpecObjectType();
      specObjectType.setIdentifier("id");
      specObjectType.setLongName("Custom Type");
      specObjectType.setDesc("custom");

      specObjectType.getSpecAttributes().add(attributeDefinitionStringDescription);
      specObjectType.getSpecAttributes().add(attributeDefinitionStringId);

      reqIFContent.getSpecTypes().add(specObjectType);

      for (SpecObject specObject : this.listOfObjects) {
        // AttributeValueString attributeValueId =
        // ReqIF10Factory.eINSTANCE.createAttributeValueString();
        // attributeValueId.setDefinition(attributeDefinitionStringId);
        // attributeValueId.setTheValue("");
        //
        // AttributeValueString attributeValueDesc =
        // ReqIF10Factory.eINSTANCE.createAttributeValueString();
        // attributeValueDesc.setDefinition(attributeDefinitionStringDescription);
        // attributeValueDesc.setTheValue("");
        //
        // specObject.getValues().add(attributeValueId);
        // specObject.getValues().add(attributeValueDesc);

        specObject.setType(specObjectType);
      }

      try {
        resource.save(null);
      } catch (IOException e) {
        e.printStackTrace();
      }
      return true;
    } else if (eObject instanceof Specification) {

      return true;
    }
    return false;
  }

}
