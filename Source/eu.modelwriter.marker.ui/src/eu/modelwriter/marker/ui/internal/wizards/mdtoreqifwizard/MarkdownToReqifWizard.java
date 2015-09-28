package eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.reqif10.impl.ReqIFImpl;

import eu.modelwriter.marker.ui.Activator;

public class MarkdownToReqifWizard extends Wizard {

  private CreatingReqifSpecPage page;
  private ArrayList<SpecHierarchy> listOfSpecs;

  public MarkdownToReqifWizard(ArrayList<SpecHierarchy> arrayList) {
    this.listOfSpecs = arrayList;
  }

  @Override
  public void addPages() {
    page = new CreatingReqifSpecPage();
    super.addPages();
    this.addPage(page);
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
      // specHier.getChildren().add(listOfSpecs.get(0));

      Resource resource = specHier.eResource();
      ReqIFImpl impl = (ReqIFImpl) resource.getContents().get(0);
      EList<Specification> specs = impl.getCoreContent().getSpecifications();
      for (Specification specification : specs) {
        EList<SpecHierarchy> hiers = specification.getChildren();
        for (SpecHierarchy specHierarchy : hiers) {
          specHierarchy.getObject();
          if (specHierarchy.getIdentifier().equals(specHier.getIdentifier())) {
            specHierarchy.getChildren().addAll(listOfSpecs);
            break;
          }
        }
      }
      // try {
      // resource.save(null);
      // } catch (IOException e) {
      // e.printStackTrace();
      // }

      System.out.println("");
      // resource.getAllContents()

      // EcoreEditor eEditor = (EcoreEditor) Activator.getEditor();
      // Resource myResource =
      // eEditor.getEditingDomain().loadResource(EcoreUtil.getURI(eObject).toString());
      // EList<EObject> list = myResource.getContents();
      // if (list.get(0) instanceof ReqIFImpl) {
      // ReqIFImpl reqIFimpl = (ReqIFImpl) list.get(0);
      // EList<Specification> listOfSpecsFake = reqIFimpl.getCoreContent().getSpecifications();
      // for (Specification specification : listOfSpecsFake) {
      // EList<SpecHierarchy> listOfSpecHier = specification.getChildren();
      // for (SpecHierarchy specHierarchy : listOfSpecHier) {
      // if (specHierarchy.getIdentifier().equals(specHier.getIdentifier())) {
      // specHierarchy.getChildren().addAll(listOfSpecs);
      // break;
      // }
      // }
      // }
      // }
      // try {
      // myResource.save(null);
      // } catch (IOException e) {
      // e.printStackTrace();
      // }
      // EcoreEditor editor = (EcoreEditor) Activator.getEditor();
      // editor.doSave(null);
      // Command com = AddCommand.create(editor.getEditingDomain(), specHier, null, listOfSpecs);
      // editor.getEditingDomain().getCommandStack().execute(com);

      return true;
    } else if (eObject instanceof Specification) {
      Specification spec = (Specification) eObject;
      spec.getChildren().addAll(listOfSpecs);
      System.out.println("");
      EcoreEditor editor = (EcoreEditor) Activator.getEditor();
      editor.doSave(null);

      return true;
    }
    return false;
  }

}
