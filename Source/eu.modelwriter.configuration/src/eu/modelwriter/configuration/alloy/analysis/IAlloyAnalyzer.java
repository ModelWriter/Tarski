package eu.modelwriter.configuration.alloy.analysis;

import edu.mit.csail.sdg.alloy4.Err;

public interface IAlloyAnalyzer {
  boolean start() throws Err;

  boolean next() throws Err;

  boolean previous() throws Err;

  void finish();

  void setFilterState(boolean isOpen);

  void setNextSolMaxTime(int maxTime);
}
