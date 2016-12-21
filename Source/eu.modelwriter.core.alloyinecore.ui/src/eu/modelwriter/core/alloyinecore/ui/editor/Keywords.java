package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface Keywords {

  public static final String[] KEYWORDS = new String[] {"package", "class", "import", "invariant",
      "attribute", "operation", "enum", "annotation", "datatype", "property", "body", "requires",
      "ensures", "reference", "literal"};

  public static final String[] VISIBILITY = new String[] {"package", "public", "private"};

  public static final String[] QUALIFIERS =
      new String[] {"static", "extends", "readonly", "!readonly", "composes", "!composes",
          "nullable", "!nullable", "transient", "!transient", "volatile", "!volatile", "resolve",
          "!resolve", "ordered", "!ordered", "callable", "!callable", "unsettable", "!unsettable",
          "derived", "!derived", "unique", "!unique", "id", "!id"};

  public static final Set<String> ALL = getAll(KEYWORDS, VISIBILITY, QUALIFIERS);

  static Set<String> getAll(String[]... arrays) {
    Set<String> hashSet = new HashSet<>();
    for (int i = 0; i < arrays.length; i++) {
      hashSet.addAll(Arrays.asList(arrays[i]));
    }
    return hashSet;
  }

}
