package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.IFontDecorator;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.structure.IVisibility;
import eu.modelwriter.core.alloyinecore.ui.Activator;

public class AIEContentOutlinePage extends ContentOutlinePage {

  private AlloyInEcoreEditor alloyInEcoreEditor;
  private AIEContentProvider contentProvider;
  private TreeViewer viewer;
  private Element<ModuleContext> parsedModule;

  public AIEContentOutlinePage(IDocumentProvider documentProvider,
      AlloyInEcoreEditor alloyInEcoreEditor) {
    this.alloyInEcoreEditor = alloyInEcoreEditor;
  }

  public void setInput(Element<ModuleContext> parsedModule) {
    this.parsedModule = parsedModule;
    if (viewer != null && parsedModule != null)
      viewer.setInput(new ModuleWrapper(parsedModule));
  }

  @Override
  public void createControl(Composite parent) {
    super.createControl(parent);

    viewer = getTreeViewer();
    contentProvider = new AIEContentProvider();
    viewer.setContentProvider(contentProvider);
    viewer.setLabelProvider(
        new DecoratingLabelProvider(new AIELabelProvider(), new AIELabelDecorator()));
    viewer.addSelectionChangedListener(this);

    viewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @SuppressWarnings("rawtypes")
      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        ISelection selection = viewer.getSelection();
        if (selection instanceof IStructuredSelection) {
          Object item = ((IStructuredSelection) selection).getFirstElement();
          if (item instanceof Element) {
            final Element element = (Element) item;
            alloyInEcoreEditor.getSelectionProvider()
                .setSelection(new TextSelection(element.getStart(),
                    element.getStop() - element.getStart() + 1));
          }
        }
      }
    });
  }

  private class ModuleWrapper {
    Element<ModuleContext> module;

    public ModuleWrapper(Element<ModuleContext> module) {
      this.module = module;
    }
  }

  private class AIEContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {
      if (parsedModule == null) {
        return null;
      }
      return getChildren(inputElement);
    }

    @SuppressWarnings({"rawtypes"})
    @Override
    public Object[] getChildren(Object parentElement) {
      if (parentElement instanceof ModuleWrapper)
        return new Object[] {((ModuleWrapper) parentElement).module};
      else if (parentElement != null) {
        Element parent = (Element) parentElement;
        return parent.getOwnedElements().toArray();
      }
      return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object getParent(Object element) {
      if (element != null)
        return ((Element) element).getOwner();
      return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean hasChildren(Object element) {
      if (element instanceof ModuleWrapper)
        return true;
      return element != null && !((Element) element).getOwnedElements().isEmpty();
    }
  }

  private class AIELabelDecorator
      implements ILightweightLabelDecorator, ILabelDecorator, IFontDecorator {

    @Override
    public void addListener(ILabelProviderListener listener) {}

    @Override
    public void dispose() {}

    @Override
    public boolean isLabelProperty(Object element, String property) {
      return false;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {}

    @Override
    public Font decorateFont(Object element) {
      if (element instanceof eu.modelwriter.core.alloyinecore.structure.Class
          && ((eu.modelwriter.core.alloyinecore.structure.Class) element).isAbstract()) {
        return JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
      }
      return JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT);
    }

    @Override
    public Image decorateImage(Image image, Object element) {
      return image;
    }

    @Override
    public String decorateText(String text, Object element) {
      return text;
    }

    @Override
    public void decorate(Object element, IDecoration decoration) {
      if (element instanceof IVisibility) {
        eu.modelwriter.core.alloyinecore.structure.Visibility visibility =
            ((IVisibility) element).getVisibility();
        String overlayName = visibility.toString();
        ImageDescriptor overlayDesc =
            Activator.getDefault().getImageRegistry().getDescriptor(overlayName);
        if (overlayDesc != null)
          decoration.addOverlay(overlayDesc);
      }
    }
  }

  private class AIELabelProvider extends LabelProvider {

    @Override
    public Image getImage(Object element) {
      return Activator.getDefault().getImageRegistry().get(element.getClass().getSimpleName());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String getText(Object element) {
      return ((Element) element).getLabel();
    }
  }
}
