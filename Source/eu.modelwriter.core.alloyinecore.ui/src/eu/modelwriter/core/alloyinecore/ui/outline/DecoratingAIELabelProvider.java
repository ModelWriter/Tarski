package eu.modelwriter.core.alloyinecore.ui.outline;

import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;

public class DecoratingAIELabelProvider extends DecoratingStyledCellLabelProvider
    implements ILabelProvider {

  private IStyledLabelProvider labelProvider;
  private ILabelDecorator decorator;
  private IDecorationContext decorationContext;


  public DecoratingAIELabelProvider(IStyledLabelProvider labelProvider) {
    this(labelProvider, null, null);
  }

  public DecoratingAIELabelProvider(IStyledLabelProvider labelProvider, ILabelDecorator decorator,
      IDecorationContext decorationContext) {
    super(labelProvider, decorator, decorationContext);
    this.labelProvider = labelProvider;
    this.decorator = decorator;
    this.decorationContext = decorationContext;
  }

  public DecoratingAIELabelProvider(IStyledLabelProvider labelProvider,
      ILabelDecorator labelDecorator) {
    this(labelProvider, labelDecorator, null);
  }

  @Override
  public String getText(Object element) {
    return labelProvider.getStyledText(element).getString();
  }

}
