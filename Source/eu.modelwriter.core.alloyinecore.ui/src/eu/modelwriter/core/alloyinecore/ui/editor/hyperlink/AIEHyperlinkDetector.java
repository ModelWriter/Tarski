package eu.modelwriter.core.alloyinecore.ui.editor.hyperlink;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.source.ISourceViewer;

import eu.modelwriter.core.alloyinecore.structure.Class;
import eu.modelwriter.core.alloyinecore.structure.GenericElementType;
import eu.modelwriter.core.alloyinecore.structure.GenericSuperType;
import eu.modelwriter.core.alloyinecore.structure.GenericType;
import eu.modelwriter.core.alloyinecore.structure.GenericWildcard;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;

public class AIEHyperlinkDetector implements IHyperlinkDetector {

  @SuppressWarnings("unused")
  private ISourceViewer sourceViewer;
  public AIEEditor editor;
  private List<IHyperlink> hyperlinks = null;

  public AIEHyperlinkDetector(ISourceViewer sourceViewer, AIEEditor fTextEditor) {
    this.sourceViewer = sourceViewer;
    editor = fTextEditor;
  }

  private void loadLinks() {
    TypeVisitor typeVisitor = new TypeVisitor(editor);
    typeVisitor.visit(editor.getParsedModule());
    hyperlinks = typeVisitor.getLinks();
  }

  @Override
  public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region,
      boolean canShowMultipleHyperlinks) {
    if (hyperlinks == null)
      loadLinks();

    List<IHyperlink> result = new ArrayList<>();
    for (IHyperlink iHyperlink : hyperlinks) {
      if (overlaps(iHyperlink.getHyperlinkRegion(), region))
        result.add(iHyperlink);
      if (result.size() == 1 && !canShowMultipleHyperlinks)
        break;
    }
    return result.toArray(new IHyperlink[0]);
  }

  private boolean overlaps(IRegion r1, IRegion r2) {
    int r1End = r1.getOffset() + r1.getLength();
    int r2End = r2.getOffset() + r2.getLength();
    return r2.getOffset() >= r1.getOffset() && r2End <= r1End;
  }

  private static class TypeVisitor extends BaseVisitorImpl<Object> {

    private List<IHyperlink> links = new ArrayList<>();
    private AIEEditor editor;

    public TypeVisitor(AIEEditor fTextEditor) {
      editor = fTextEditor;
    }

    public List<IHyperlink> getLinks() {
      return links;
    }

    @Override
    public Object visitClass(Class _class) {
      EObjectHyperlink oHyperlink =
          new EObjectHyperlink(_class.getStart(), _class.getStop(), _class.getEObject(), editor);
      links.add(oHyperlink);
      return super.visitClass(_class);
    }

    @Override
    public Object visitGenericElementType(GenericElementType genericElementType) {
      addToLinks(genericElementType);
      return super.visitGenericElementType(genericElementType);
    }

    @Override
    public Object visitGenericSuperType(GenericSuperType genericSuperType) {
      addToLinks(genericSuperType);
      return super.visitGenericSuperType(genericSuperType);
    }

    @Override
    public Object visitGenericWildcard(GenericWildcard genericWildcard) {
      addToLinks(genericWildcard);
      return super.visitGenericWildcard(genericWildcard);
    }

    @Override
    public Object visitGenericType(GenericType genericType) {
      addToLinks(genericType);
      return super.visitGenericType(genericType);
    }

    @SuppressWarnings("rawtypes")
    private void addToLinks(eu.modelwriter.core.alloyinecore.structure.Object element) {
      AIEHyperlink aieHyperlink = new AIEHyperlink(element.getStart(), element.getStop());
      EObjectHyperlink oHyperlink =
          new EObjectHyperlink(element.getStart(), element.getStop(), element.getEObject(), editor);
      links.add(aieHyperlink);
      links.add(oHyperlink);
    }
  }

}
