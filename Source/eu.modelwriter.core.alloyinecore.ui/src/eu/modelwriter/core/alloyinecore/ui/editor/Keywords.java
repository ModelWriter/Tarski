package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface Keywords {

  public static final String[] KEYWORDS =
      new String[] {"package", "class", "import", "abstract", "interface", "attribute", "operation",
          "enum", "annotation", "datatype", "reference", "literal", "#", "property"};

  public static final String[] PRIMITIVES =
      new String[] {"Boolean", "Integer", "String", "Real", "UnlimitedNatural"};

  public static final String[] AIE =
      new String[] {"module", "body", "requires", "ensures", "invariant", "ghost", "model"};

  public static final String[] VISIBILITY =
      new String[] {"public", "private", "protected"};

  public static final String[] QUALIFIERS =
      new String[] {"static", "extends", "readonly", "!readonly", "composes", "!composes",
          "nullable", "!nullable", "transient", "!transient", "volatile", "!volatile", "resolve",
          "!resolve", "ordered", "!ordered", "callable", "!callable", "unsettable", "!unsettable",
          "derived", "!derived", "unique", "!unique", "id", "!id", "serializable", "!serializable"};

  public static final Set<String> ALL_BUT_AIE = Keywords.getAll(Keywords.KEYWORDS,
      Keywords.VISIBILITY, Keywords.QUALIFIERS, Keywords.PRIMITIVES);

  public static Set<String> getAll(final String[]... arrays) {
    final Set<String> hashSet = new HashSet<>();
    for (int i = 0; i < arrays.length; i++) {
      hashSet.addAll(Arrays.asList(arrays[i]));
    }
    return hashSet;
  }

}
