package eu.modelwriter.core.alloyinecore.ui.editor.outline;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.viewers.ITreeContentProvider;

import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.structure.Multiplicity;
import eu.modelwriter.core.alloyinecore.ui.editor.outline.AIEContentOutlinePage.ModuleWrapper;

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
    if (parentElement instanceof ModuleWrapper) {
      if (((ModuleWrapper) parentElement).module == null) {
        return new Object[0];
      }
      return new Object[] {((ModuleWrapper) parentElement).module};
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
    if (element instanceof ModuleWrapper) {
      return true;
    }
    return element != null && ((Element) element).hasOwnedElements();
  }
}
