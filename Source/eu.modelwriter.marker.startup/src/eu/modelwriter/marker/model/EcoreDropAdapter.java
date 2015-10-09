package eu.modelwriter.marker.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.markdown.core.MarkdownLanguage;
import org.eclipse.rmf.reqif10.AttributeDefinitionString;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.DatatypeDefinitionString;
import org.eclipse.rmf.reqif10.ReqIF10Factory;
import org.eclipse.rmf.reqif10.ReqIFContent;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecObjectType;
import org.eclipse.rmf.reqif10.impl.ReqIFImpl;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.internal.MarkdownToReqIfDocumentBuilder;
import eu.modelwriter.marker.internal.MarkerFactory;

public class EcoreDropAdapter extends EditingDomainViewerDropAdapter {

  ArrayList<SpecObject> listOfObjects;
  ArrayList<SpecHierarchy> listOfSpecs;
  EcoreEditor eEditor;

  public EcoreDropAdapter(EcoreEditor eEditor) {
    super(eEditor.getEditingDomain(), eEditor.getViewer());
    this.eEditor = eEditor;
    this.listOfObjects = new ArrayList<SpecObject>();
    this.listOfSpecs = new ArrayList<SpecHierarchy>();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  private void convertToReqif(DropTargetEvent event) {
    if (event.item.getData() instanceof SpecHierarchy) {

      SpecHierarchy specHier = (SpecHierarchy) event.item.getData();
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

      SpecObjectType specObjectType = ReqIF10Factory.eINSTANCE.createSpecObjectType();
      specObjectType.setIdentifier("id");
      specObjectType.setLongName("Custom Type");

      specObjectType.getSpecAttributes().add(attributeDefinitionStringDescription);

      reqIFContent.getSpecTypes().add(specObjectType);

      for (SpecObject specObject : this.listOfObjects) {
        ((AttributeValueString) specObject.getValues().get(0))
            .setDefinition(attributeDefinitionStringDescription);
        specObject.setType(specObjectType);
      }

      try {
        resource.save(null);
        IWorkbenchPage iwp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        iwp.closeEditor(this.eEditor, true);
      } catch (IOException e) {
        e.printStackTrace();
      }

      MarkerFactory.refreshProjectExp();
    }
  }

  @Override
  public void dragEnter(DropTargetEvent event) {
    super.dragEnter(event);
  }

  @Override
  public void dragLeave(DropTargetEvent event) {
    super.dragLeave(event);
  }

  @Override
  public void dragOperationChanged(DropTargetEvent event) {
    super.dragOperationChanged(event);
  }

  @Override
  public void dragOver(DropTargetEvent event) {
    super.dragOver(event);
  }

  @Override
  public void drop(DropTargetEvent event) {
    super.drop(event);

    if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {

      this.parseMd(event);
      this.convertToReqif(event);
    }
  }

  @Override
  public void dropAccept(DropTargetEvent event) {
    super.dropAccept(event);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  protected Collection<?> extractDragSource(Object object) {
    return super.extractDragSource(object);
  }

  @Override
  protected Object extractDropTarget(Widget item) {
    return super.extractDropTarget(item);
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }

  @Override
  protected int getAutoFeedback() {
    return super.getAutoFeedback();
  }

  @Override
  protected Collection<?> getDragSource(DropTargetEvent event) {
    return super.getDragSource(event);
  }

  @Override
  protected float getLocation(DropTargetEvent event) {
    return super.getLocation(event);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  protected void helper(DropTargetEvent event) {
    super.helper(event);
  }

  private void parseMd(DropTargetEvent event) {
    MarkdownToReqIfDocumentBuilder builder = new MarkdownToReqIfDocumentBuilder();
    MarkupParser markupParser = new MarkupParser(new MarkdownLanguage());
    markupParser.setBuilder(builder);
    markupParser.parse(event.data.toString());
    this.listOfObjects = builder.getNewlySpecObjects();
    this.listOfSpecs = builder.getRootSet();
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
