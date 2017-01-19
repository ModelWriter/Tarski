package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IFontDecorator;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.BodyContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAttributeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDetailContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumLiteralContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EStructuralFeatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeRefContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PostconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PreconditionContext;
import eu.modelwriter.core.alloyinecore.ui.Activator;

public class AIEContentOutlinePage extends ContentOutlinePage {

  private AlloyInEcoreEditor alloyInEcoreEditor;
  private AIEContentProvider contentProvider;
  private TreeViewer viewer;
  private ParseTree parseTree;

  public AIEContentOutlinePage(IDocumentProvider documentProvider,
      AlloyInEcoreEditor alloyInEcoreEditor) {
    this.alloyInEcoreEditor = alloyInEcoreEditor;
  }

  public void setInput(ParseTree parsedModule) {
    parseTree = parsedModule;
    if (viewer != null && parseTree != null)
      viewer.setInput(parseTree);
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

    if (viewer != null && parseTree != null)
      viewer.setInput(parseTree);

    viewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick(DoubleClickEvent event) {
        ISelection selection = viewer.getSelection();
        if (selection instanceof IStructuredSelection) {
          Object item = ((IStructuredSelection) selection).getFirstElement();
          if (item instanceof ParserRuleContext) {
            alloyInEcoreEditor.setHighlightRange(((ParserRuleContext) item).start.getStartIndex(),
                0, true);
          }
        }
      }
    });
  }

  private class AIEContentProvider implements ITreeContentProvider {

    @SuppressWarnings("rawtypes")
    List<Class> containerFilter = new ArrayList<>();
    @SuppressWarnings("rawtypes")
    List<Class> filter = new ArrayList<>();

    public AIEContentProvider() {
      containerFilter.add(EClassifierContext.class);
      containerFilter.add(EStructuralFeatureContext.class);

      filter.add(PackageImportContext.class);
      filter.add(EPackageContext.class);
      filter.add(EClassContext.class);
      filter.add(EEnumContext.class);
      filter.add(EEnumLiteralContext.class);
      filter.add(EDataTypeContext.class);
      filter.add(EOperationContext.class);
      filter.add(EReferenceContext.class);
      filter.add(EParameterContext.class);
      filter.add(EAttributeContext.class);
      filter.add(EAnnotationContext.class);
      filter.add(PreconditionContext.class);
      filter.add(PostconditionContext.class);
      filter.add(InvariantContext.class);
      filter.add(BodyContext.class);
      filter.add(EParameterContext.class);
      filter.add(EDetailContext.class);
      filter.add(ETypeRefContext.class);
    }

    @Override
    public Object[] getElements(Object inputElement) {
      if (parseTree == null) {
        return new Object[] {"Parser error."};
      }
      return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
      if (parentElement != null && parentElement instanceof ParseTree) {
        ParseTree parent = ((ParseTree) parentElement);
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < parent.getChildCount(); i++) {
          ParseTree currentChild = parent.getChild(i);
          if (containerFilter.contains(currentChild.getClass())) {
            result.addAll(getContainerChildren(currentChild));
          } else if (filter.contains(currentChild.getClass()))
            result.add(currentChild);
        }
        return result.toArray();
      }
      return null;
    }

    public List<Object> getContainerChildren(ParseTree element) {
      List<Object> result = new ArrayList<>();
      for (int i = 0; i < element.getChildCount(); i++) {
        result.add(element.getChild(i));
      }
      return result;
    }

    @Override
    public Object getParent(Object element) {
      if (element != null && element instanceof ParseTree)
        return ((ParseTree) element).getParent();
      return null;
    }

    @Override
    public boolean hasChildren(Object element) {
      if (element != null && element instanceof ParseTree)
        return ((ParseTree) element).getChildCount() > 0;
      return false;
    }
  }

  private class AIELabelDecorator implements ILabelDecorator, IFontDecorator {

    public AIELabelDecorator() {
      // FontData fontData = viewer.getControl().getFont().getFontData()[0];
      // italicFont = new Font(Display.getDefault(),
      // new FontData(fontData.getName(), fontData.getHeight(), SWT.ITALIC));
      // normalFont = new Font(Display.getDefault(),
      // new FontData(fontData.getName(), fontData.getHeight(), SWT.NONE));
    }

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
  }

  private class AIELabelProvider extends LabelProvider {

    @Override
    public Image getImage(Object element) {
      return Activator.getDefault().getImageRegistry().get(element.getClass().getSimpleName());
    }

    @Override
    public String getText(Object element) {
      if (element instanceof PackageImportContext)
        return ((PackageImportContext) element).name.getText();

      if (element instanceof EPackageContext)
        return ((EPackageContext) element).element.getName() + " : "
            + ((EPackageContext) element).element.getNsPrefix();
      if (element instanceof EClassContext)
        return ((EClassContext) element).element.getName();
      if (element instanceof EEnumContext)
        return ((EEnumContext) element).element.getName();
      if (element instanceof EEnumLiteralContext)
        return ((EEnumLiteralContext) element).element.getName() + " = "
            + ((EEnumLiteralContext) element).value.getText();
      if (element instanceof EDataTypeContext)
        return ((EDataTypeContext) element).element.getName();

      if (element instanceof EOperationContext)
        return ((EOperationContext) element).name.getText() + " : "
            + (((EOperationContext) element).eReturnType != null
                ? ((EOperationContext) element).eReturnType.getText() : "");
      if (element instanceof EReferenceContext)
        return ((EReferenceContext) element).element.getName() + " : "
            + ((EReferenceContext) element).eReferenceType != null
                ? ((EReferenceContext) element).eReferenceType.getText() : "";
      if (element instanceof EParameterContext)
        return ((EParameterContext) element).element.getName() + " : "
            + ((EParameterContext) element).eParameterType != null
                ? ((EParameterContext) element).eParameterType.getText() : "";
      if (element instanceof EAttributeContext)
        return ((EAttributeContext) element).element.getName() + " : "
            + ((EAttributeContext) element).eAttributeType != null
                ? ((EAttributeContext) element).eAttributeType.getText() : "";

      if (element instanceof PreconditionContext)
        return ((PreconditionContext) element).name != null
            ? ((PreconditionContext) element).name.getText() : "ensures";
      if (element instanceof PostconditionContext)
        return ((PostconditionContext) element).name != null
            ? ((PostconditionContext) element).name.getText() : "ensures";
      if (element instanceof InvariantContext)
        return ((InvariantContext) element).name != null
            ? ((InvariantContext) element).name.getText() : "invariant";
      if (element instanceof BodyContext)
        return ((BodyContext) element).name != null ? ((BodyContext) element).name.getText()
            : "body";

      if (element instanceof EAnnotationContext)
        return ((EAnnotationContext) element).element.getSource();
      if (element instanceof EDetailContext)
        return ((EDetailContext) element).k + " : " + ((EDetailContext) element).v;
      return element.toString();
    }
  }
}
