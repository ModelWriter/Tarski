package eu.modelwriter.core.alloyinecore.ui.editor.outline;

import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;

public class DecoratingAIELabelProvider extends DecoratingStyledCellLabelProvider
implements ILabelProvider {

  private final IStyledLabelProvider labelProvider;
  private final ILabelDecorator decorator;
  private final IDecorationContext decorationContext;


  public DecoratingAIELabelProvider(final IStyledLabelProvider labelProvider) {
    this(labelProvider, null, null);
  }

  public DecoratingAIELabelProvider(final IStyledLabelProvider labelProvider,
      final ILabelDecorator decorator, final IDecorationContext decorationContext) {
    super(labelProvider, decorator, decorationContext);
    this.labelProvider = labelProvider;
    this.decorator = decorator;
    this.decorationContext = decorationContext;
  }

  public DecoratingAIELabelProvider(final IStyledLabelProvider labelProvider,
      final ILabelDecorator labelDecorator) {
    this(labelProvider, labelDecorator, null);
  }

  @Override
  public String getText(final Object element) {
    return labelProvider.getStyledText(element).getString();
  }
}
