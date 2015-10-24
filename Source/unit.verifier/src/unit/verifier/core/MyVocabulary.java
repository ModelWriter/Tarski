package unit.verifier.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.Token;

public final class MyVocabulary {
  private Map<Token, Integer> relationArityMap = new HashMap<Token, Integer>();
  private ArrayList<String> atomList = new ArrayList<String>();

  public ArrayList<String> getAtomList() {
    return this.atomList;
  }

  public Map<Token, Integer> getRelationArityMap() {
    return this.relationArityMap;
  }
}
