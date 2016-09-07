package eu.modelwriter.configuration.alloy.reasoning;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.SourceType;
import eu.modelwriter.traceability.core.persistence.TupleType;

public class InstanceTranslatorReasoning {

  // public static void main(final String[] args) {
  // final String txt = "--Reason@contents.ad";
  //
  // final String re1 = "(-)"; // Any Single Character 1
  // final String re2 = "(-)"; // Any Single Character 2
  // final String re3 = "(\\s*)"; // White Space 1
  // final String re4 = "(Reason|reason)"; // Word 1
  // final String re5 = "(@)"; // Any Single Character 3
  // final String re6 = "((?:[a-z0-9_]+))"; // Word 2
  // final String re7 = "(\\.)";
  // final String re8 = "((?:[a-z0-9_]+))"; // Word 2
  // final String re9 = "(\\s*)"; // White Space 2
  //
  // final Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7
  // + re8 + re9,
  // Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
  // final Matcher m = p.matcher(txt);
  // if (m.find()) {
  // final String c1 = m.group(1);
  // final String c2 = m.group(2);
  // final String ws1 = m.group(3);
  // final String word1 = m.group(4);
  // final String c3 = m.group(5);
  // final String word2 = m.group(6);
  // final String dot1 = m.group(7);
  // final String word3 = m.group(8);
  // final String ws2 = m.group(9);
  // System.out.print("(" + c1.toString() + ")" + "(" + c2.toString() + ")" +
  // "(" + ws1.toString()
  // + ")" + "(" + word1.toString() + ")" + "(" + c3.toString() + ")" + "(" +
  // word2.toString()
  // + ")" + "(" + dot1.toString() + ")" + "(" + word3.toString() + ")" + "("
  // + ws2.toString()
  // + ")" + "\n");
  // }
  // }

  public static String baseFileDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation()
      + " .modelwriter reasoning ".replace(" ", System.getProperty("file.separator"));

  private final Map<String, List<String>> reasonRelations = new HashMap<>();

  private final StringBuilder builder;

  private final Map<String, Integer> sig2oldValue = new HashMap<>();

  public InstanceTranslatorReasoning() {
    builder = new StringBuilder();
  }

  private void createFactPart(final DocumentRoot documentRoot, final List<FieldType> fields) {
    builder.append("fact {\n");

    for (final FieldType field : fields) {
      final String fieldName = field.getLabel();
      int tupleCount = 0;

      for (final TupleType tuple : field.getTuple()) {
        tupleCount++;

        final String sigName1 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(0).getLabel()).replace("$", "_");
        final String sigName2 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(1).getLabel()).replace("$", "_");

        builder.append(sigName1 + "->" + sigName2);

        final String sigName = sigName1.substring(0, sigName1.lastIndexOf("_"));
        if (tupleCount != field.getTuple().size()) {
          builder.append(" +\n");
        } else if (reasonRelations.containsKey(sigName)
            && reasonRelations.get(sigName).contains(fieldName)) {
          builder.append(" in " + fieldName + "\n");
        } else {
          builder.append(" = " + fieldName + "\n");
        }

      }

      String parentSigName = AlloyUtilities.getSigTypeById(field.getParentID()).getLabel();
      parentSigName = parentSigName.substring(parentSigName.lastIndexOf("/") + 1);

      final List<String> allRelations = new ArrayList<>();
      for (final List<String> value : reasonRelations.values()) {
        allRelations.addAll(value);
      }

      if (field.getTuple().size() == 0 && !allRelations.contains(fieldName)) {
        builder.append(parentSigName + "." + fieldName + " = none\n");
      }
    }

    builder.append("}\n");
  }

  private File createFile(final String filePath) {
    File file = null;
    try {
      file = new File(filePath);

      if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs();
      }
      // if file doesn't exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return file;
  }

  private void createSigPart(final List<SigType> sigs) {
    for (final SigType sig : sigs) {
      final String sigName = sig.getLabel().substring(sig.getLabel().lastIndexOf("/") + 1);
      for (int i = 0; i < sig.getAtom().size(); i++) {
        builder.append("one sig " + sigName + "_" + i + " extends " + sigName + "{ } \n");
      }
    }
  }

  private void createSourceFiles(final EList<SourceType> sources) {
    boolean isFirst = false;
    for (final SourceType source : sources) {
      final String sourceFilePath = source.getFilename();
      final String fileName = sourceFilePath.substring(
          sourceFilePath.lastIndexOf(System.getProperty("file.separator")) + 1,
          sourceFilePath.lastIndexOf("."));
      if (!isFirst) {
        builder.append("open " + fileName + "\n");
        isFirst = true;
      }
      final String newFilePath = InstanceTranslatorReasoning.baseFileDirectory + fileName + ".als";

      final String content = removeReasoningParts(source.getContent());
      writeContentToFile(newFilePath, content);
    }
  }

  public String getBaseFileDirectory() {
    return InstanceTranslatorReasoning.baseFileDirectory;
  }

  public Map<String, List<String>> getReasonRelations() {
    return reasonRelations;
  }

  private String removeReasoningParts(final String content) {
    final List<String> lines = Arrays.asList(content.split("\n"));

    final Pattern p =
        Pattern.compile("(-)(-)(\\s*)(Reason|reason)(@)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\s*)",
            Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    for (final String line : lines) {
      final Matcher matcher = p.matcher(line);

      if (!matcher.find()) {
        continue;
      } else {
        final String sig = matcher.group(6); // it gets ((?:[a-z]+))
        // group
        final String relation = matcher.group(8);
        if (reasonRelations.containsKey(sig)) {
          if (!reasonRelations.get(sig).contains(relation)) {
            reasonRelations.get(sig).add(relation);
          }
        } else {
          reasonRelations.put(sig, new ArrayList<>(Arrays.asList(relation)));
        }
      }
    }

    return content;
  }

  public void translate() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final AlloyType alloy = documentRoot.getAlloy();

    calcOldSigValues(alloy.getInstance().getSig());
    createSourceFiles(alloy.getSource());
    createSigPart(alloy.getInstance().getSig());
    createFactPart(documentRoot, alloy.getInstance().getField());
    createRunPart();

    writeContentToFile(InstanceTranslatorReasoning.baseFileDirectory + "reasoning.als",
        builder.toString());
  }

  private void createRunPart() {
    builder.append("pred show{}\n");
    builder.append("run show for ");

    for (final Entry<String, Integer> oldEntry : sig2oldValue.entrySet()) {
      final int value = oldEntry.getValue();
      builder.append(" exactly " + value + " " + oldEntry.getKey() + ",");
    }

    builder.replace(0, builder.length(), builder.substring(0, builder.length() - 1)); // to delete
    // last ','
  }

  private void writeContentToFile(final String filePath, final String content) {
    try {
      final File file = createFile(filePath);
      final FileOutputStream out = new FileOutputStream(file);
      out.write(content.getBytes());
      out.close();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  private void calcOldSigValues(final EList<SigType> sigTypes) {
    for (final SigType sigType : sigTypes) {
      final String sigName = sigType.getLabel().substring(sigType.getLabel().lastIndexOf("/") + 1);
      if (sigType.getID() > 3 && sigType.getAbstract() == null) {
        sig2oldValue.put(sigName, sigType.getAtom().size());
      }
    }
  }
}
