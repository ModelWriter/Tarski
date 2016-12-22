package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface Keywords {

  public static final String[] KEYWORDS =
      new String[] {"package", "class", "import", "abstract", "interface", "invariant", "attribute",
          "operation", "enum", "annotation", "datatype", "property", "body", "requires", "ensures",
          "reference", "literal", "#", "String", "Integer", "UnlimitedNatural", "Boolean", "Real"};

  public static final String[] PRIMITIVES =
      new String[] {"Boolean", "Integer", "String", "Real", "UnlimitedNatural"};

  public static final String[] VISIBILITY = new String[] {"package", "public", "private"};

  public static final String[] QUALIFIERS =
      new String[] {"static", "extends", "readonly", "!readonly", "composes", "!composes",
          "nullable", "!nullable", "transient", "!transient", "volatile", "!volatile", "resolve",
          "!resolve", "ordered", "!ordered", "callable", "!callable", "unsettable", "!unsettable",
          "derived", "!derived", "unique", "!unique", "id", "!id"};

  public static final Set<String> ALL = Keywords.getAll(Keywords.KEYWORDS, Keywords.VISIBILITY,
      Keywords.QUALIFIERS, Keywords.PRIMITIVES);

  static Set<String> getAll(final String[]... arrays) {
    final Set<String> hashSet = new HashSet<>();
    for (int i = 0; i < arrays.length; i++) {
      hashSet.addAll(Arrays.asList(arrays[i]));
    }
    return hashSet;
  }

}
