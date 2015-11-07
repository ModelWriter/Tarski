package eu.modelwriter.traceability.validation.core.fol.typechecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Vocabulary {
  private final Map<String, Integer> relationArityMap = new HashMap<String, Integer>();
  private final ArrayList<String> atomList = new ArrayList<String>();

  public ArrayList<String> getAtomList() {
    return atomList;
  }

  public Map<String, Integer> getRelationArityMap() {
    return relationArityMap;
  }
}
