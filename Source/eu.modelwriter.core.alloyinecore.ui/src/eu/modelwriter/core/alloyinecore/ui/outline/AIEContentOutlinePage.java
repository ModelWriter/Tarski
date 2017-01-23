package eu.modelwriter.core.alloyinecore.ui.outline;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.structure.Multiplicity;
import eu.modelwriter.core.alloyinecore.ui.Activator;
import eu.modelwriter.core.alloyinecore.ui.editor.AlloyInEcoreEditor;

public class AIEContentOutlinePage extends ContentOutlinePage {

  private AlloyInEcoreEditor alloyInEcoreEditor;
  private AIEContentProvider contentProvider;
  private TreeViewer viewer;
  private Element<ModuleContext> parsedModule;
  private StructuredSelection selection;
  protected int selectionOffset;

  public AIEContentOutlinePage(IDocumentProvider documentProvider,
      AlloyInEcoreEditor alloyInEcoreEditor) {
    this.alloyInEcoreEditor = alloyInEcoreEditor;
  }

  public void setInput(Element<ModuleContext> parsedModule) {
    this.parsedModule = parsedModule;
    if (viewer != null && parsedModule != null)
      viewer.setInput(new ModuleWrapper(parsedModule));
  }

  @SuppressWarnings("rawtypes")
  public void selectElement(Element selectedElement) {
    selection = new StructuredSelection(selectedElement);
    viewer.setSelection(selection, true);
  }

  public int getSelectionOffset() {
    return selectionOffset;
  }

  @Override
  public void createControl(Composite parent) {
    super.createControl(parent);

    viewer = getTreeViewer();
    contentProvider = new AIEContentProvider();
    viewer.setContentProvider(contentProvider);
    ILabelDecorator labelDecorator =
        PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    viewer.setLabelProvider(new DecoratingLabelProvider(new AIELabelProvider(), labelDecorator));
    viewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @SuppressWarnings("rawtypes")
      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        if (!event.getSelectionProvider().getSelection().equals(selection)) {
          ISelection selection = viewer.getSelection();
          if (selection instanceof IStructuredSelection) {
            Object item = ((IStructuredSelection) selection).getFirstElement();
            if (item instanceof Element) {
              final Element element = (Element) item;
              selectionOffset = element.getStart() + (element.getStop() - element.getStart() + 1);
              alloyInEcoreEditor.getSelectionProvider().setSelection(new TextSelection(
                  element.getStart(), element.getStop() - element.getStart() + 1));
            }
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
      if (parsedModule == null)
        return null;
      if (inputElement instanceof Multiplicity)
        return null;

      return getChildren(inputElement);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public Object[] getChildren(Object parentElement) {
      if (parentElement instanceof ModuleWrapper)
        return new Object[] {((ModuleWrapper) parentElement).module};
      else if (parentElement != null) {
        Element parent = (Element) parentElement;
        List<Element> children = (List<Element>) parent.getOwnedElements().stream()
            .filter(p -> !(p instanceof Multiplicity)).collect(Collectors.toList());
        return children.toArray();
      }
      return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object getParent(Object element) {
      if (element != null && !(element instanceof Multiplicity))
        return ((Element) element).getOwner();
      return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean hasChildren(Object element) {
      if (element instanceof ModuleWrapper)
        return true;
      return element != null && ((Element) element).hasOwnedElements();
    }
  }

  private class AIELabelProvider extends LabelProvider implements IFontProvider {

    @Override
    public Image getImage(Object element) {
      return Activator.getDefault().getImageRegistry().get(element.getClass().getSimpleName());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String getText(Object element) {
      return ((Element) element).getLabel();
    }

    @Override
    public Font getFont(Object element) {
      if (element instanceof eu.modelwriter.core.alloyinecore.structure.Class
          && ((eu.modelwriter.core.alloyinecore.structure.Class) element).isAbstract()) {
        return JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
      }
      return JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT);
    }
  }

}
