package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.expressions.PropertyTester;

import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolution;

public class VizToolbarPropertyTester extends PropertyTester {

  public VizToolbarPropertyTester() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
    // if (VizConstant.PROPERTY.equals(property))
    // return true;

    if ("reason".equals(property) && AlloyNextSolution.getInstance().getAns() == null)
      return true;
    else if ("reason".equals(property) && AlloyNextSolution.getInstance().getAns() != null)
      return false;
    else if ("stop".equals(property) && AlloyNextSolution.getInstance().getAns() != null)
      return true;
    else if ("stop".equals(property) && AlloyNextSolution.getInstance().getAns() == null)
      return false;

    return false;
  }

}
