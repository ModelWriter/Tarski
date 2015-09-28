package eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.reqif10.impl.ReqIFImpl;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class MarkdownToReqifContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {}

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

  @Override
  public Object[] getElements(Object inputElement) {
    if (inputElement instanceof Object[]) {
      return (Object[]) inputElement;
    } else {
      return new Object[0];
    }
  }

  @Override
  public Object[] getChildren(Object parentElement) {

    if (parentElement instanceof IProject) {
      try {
        return ((IProject) parentElement).members();
      } catch (CoreException e) {
        e.printStackTrace();
      }

    } else if (parentElement instanceof IFolder) {
      try {
        return ((IFolder) parentElement).members();
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (parentElement instanceof IFile) {
      IFile file = (IFile) parentElement;
      try {
        IEditorPart part =
            IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
                file, "org.eclipse.emf.ecore.presentation.ReflectiveEditorID");
        if (part instanceof EcoreEditor) {
          ResourceSet load = new ResourceSetImpl();
          Resource res = load.getResource(
              URI.createURI(
                  "/org.eclipse.rmf.docs.requirements/RMF_CustomerRequirementsSpecification.reqif"),
              true);
          EList<EObject> list = res.getContents();
          for (EObject eObject : list) {
            if (eObject instanceof ReqIFImpl) {
              ReqIFImpl content = (ReqIFImpl) eObject;
              return content.getCoreContent().getSpecifications().toArray();
            }
          }
        }
      } catch (PartInitException e) {
        e.printStackTrace();
      }
    } else if (parentElement instanceof Specification) {
      Specification spec = (Specification) parentElement;
      return spec.getChildren().toArray();
    } else if (parentElement instanceof SpecHierarchy) {
      SpecHierarchy specHier = (SpecHierarchy) parentElement;
      return specHier.getChildren().toArray();
    }
    return null;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {

    if (element instanceof IProject) {
      try {
        if (((IProject) element).members().length != 0)
          return true;
        else
          return false;
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (element instanceof IFolder) {
      try {
        if (((IFolder) element).members().length != 0)
          return true;
        else
          return false;
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (element instanceof IFile) {
      IFile file = (IFile) element;
      if (file.getFileExtension() != null && file.getFileExtension().equals("reqif")) {
        try {
          IEditorPart part =
              IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
                  file, "org.eclipse.emf.ecore.presentation.ReflectiveEditorID");
          if (part instanceof EcoreEditor) {
            ResourceSet load = new ResourceSetImpl();
            Resource res = load.getResource(
                URI.createURI(
                    "/org.eclipse.rmf.docs.requirements/RMF_CustomerRequirementsSpecification.reqif"),
                true);
            EList<EObject> list = res.getContents();
            for (EObject eObject : list) {
              if (eObject instanceof ReqIFImpl) {
                ReqIFImpl content = (ReqIFImpl) eObject;
                return !content.getCoreContent().getSpecifications().isEmpty();
              }
            }
          }
        } catch (PartInitException e) {
          e.printStackTrace();
        }
      }
    } else if (element instanceof Specification) {
      Specification spec = (Specification) element;
      return !spec.getChildren().isEmpty();
    } else if (element instanceof SpecHierarchy) {
      SpecHierarchy specHier = (SpecHierarchy) element;
      return !specHier.getChildren().isEmpty();
    }
    return false;
  }
}
