package eu.modelwriter.core.alloyinecore.ui.outline;

import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.ui.editor.AlloyInEcoreEditor;

public class AIEContentOutlinePage extends ContentOutlinePage {

  private AlloyInEcoreEditor alloyInEcoreEditor;
  private TreeViewer viewer;
  private StructuredSelection selection;
  private int selectionOffset;
  private ModuleWrapper root = new ModuleWrapper();

  public AIEContentOutlinePage(IDocumentProvider documentProvider,
      AlloyInEcoreEditor alloyInEcoreEditor) {
    this.alloyInEcoreEditor = alloyInEcoreEditor;
  }

  public void refresh(Element<ModuleContext> parsedModule) {
    root.setModule(parsedModule);
    if (viewer != null) {
      viewer.refresh(true);
    }
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
    viewer.setContentProvider(new AIEContentProvider());
    ILabelDecorator labelDecorator =
        PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    viewer.setLabelProvider(new DecoratingAIELabelProvider(new AIELabelProvider(), labelDecorator));
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
    viewer.setAutoExpandLevel(2);
    viewer.setInput(root);
  }

  public class ModuleWrapper {
    Element<ModuleContext> module;

    public ModuleWrapper() {}

    public void setModule(Element<ModuleContext> module) {
      this.module = module;
    }
  }
}
