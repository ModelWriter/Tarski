package eu.modelwriter.core.alloyinecore.ui.editor.outline;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.viewers.ITreeContentProvider;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.model.Multiplicity;
import eu.modelwriter.core.alloyinecore.ui.editor.outline.AIEContentOutlinePage.RootWrapper;

public class AIEContentProvider implements ITreeContentProvider {

  @Override
  public Object[] getElements(final Object inputElement) {
    if (inputElement instanceof Multiplicity) {
      return new Object[0];
    }

    return getChildren(inputElement);
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public Object[] getChildren(final Object parentElement) {
    if (parentElement instanceof RootWrapper) {
      if (((RootWrapper) parentElement).root == null) {
        return new Object[0];
      }
      return new Object[] {((RootWrapper) parentElement).root};
    } else if (parentElement != null) {
      final Element parent = (Element) parentElement;
      final List<Element> children = (List<Element>) parent.getOwnedElements().stream()
          .filter(p -> !(p instanceof Multiplicity)).collect(Collectors.toList());
      return children.toArray();
    }
    return null;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public Object getParent(final Object element) {
    if (element != null && !(element instanceof Multiplicity)) {
      return ((Element) element).getOwner();
    }
    return null;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean hasChildren(final Object element) {
    if (element instanceof RootWrapper) {
      return true;
    }
    return element != null && ((Element) element).hasOwnedElements();
  }
}
