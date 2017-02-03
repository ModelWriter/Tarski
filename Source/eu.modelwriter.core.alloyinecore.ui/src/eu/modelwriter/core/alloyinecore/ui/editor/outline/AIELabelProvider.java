package eu.modelwriter.core.alloyinecore.ui.editor.outline;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.ui.Activator;

public class AIELabelProvider extends LabelProvider implements IFontProvider, IStyledLabelProvider {

  @Override
  public Image getImage(final Object element) {
    return Activator.getDefault().getImageRegistry().get(element.getClass().getSimpleName());
  }

  @SuppressWarnings("rawtypes")
  @Override
  public String getText(final Object element) {
    return ((Element) element).getLabel();
  }

  @Override
  public Font getFont(final Object element) {
    if (element instanceof eu.modelwriter.core.alloyinecore.structure.Class
        && ((eu.modelwriter.core.alloyinecore.structure.Class) element).isAbstract()) {
      return JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
    }
    return JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public StyledString getStyledText(final Object element) {
    final StyledString styledString = new StyledString(getText(element));
    styledString.append(" " + ((Element) element).getSuffix(), StyledString.DECORATIONS_STYLER);
    return styledString;
  }
}
