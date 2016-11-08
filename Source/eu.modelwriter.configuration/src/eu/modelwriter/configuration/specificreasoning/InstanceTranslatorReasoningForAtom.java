package eu.modelwriter.configuration.specificreasoning;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.SourceType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypeType;
import eu.modelwriter.traceability.core.persistence.TypesType;

public class InstanceTranslatorReasoningForAtom {

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
      + " .modelwriter reasoningForAtom ".replace(" ", System.getProperty("file.separator"));

  private final StringBuilder builder;

  final Map<String, List<String>> reasonRelations = new HashMap<>();

  private final Map<String, Integer> sig2oldValue = new HashMap<>();

  private final String atomType;

  public InstanceTranslatorReasoningForAtom(final String atomType) {
    this.atomType = atomType;
    builder = new StringBuilder();
  }

  private void createFactPart(final DocumentRoot documentRoot, final List<FieldType> fields) {
    builder.append("fact {\n");

    final Map<String, List<String>> discoverFields = new HashMap<>();
    final Map<String, List<String>> allParents = new HashMap<>();

    final String sigName = atomType;
    allParents.put(sigName, new ArrayList<>());
    final int id = AlloyUtilities.getSigTypeIdByName(sigName);
    final ArrayList<Integer> allParentIds = AlloyUtilities.getAllParentIds(id);
    for (final Integer parentId : allParentIds) {
      final String parentName = AlloyUtilities.getSigNameById(parentId);
      allParents.get(sigName).add(parentName);
    }

    for (final FieldType fieldType : fields) {
      for (final TypesType typesType : fieldType.getTypes()) {
        for (final TypeType typeType : typesType.getType()) {
          String label = AlloyUtilities.getSigTypeById(typeType.getID()).getLabel();
          label = label.substring(label.lastIndexOf("/") + 1);
          if (label.equals(sigName) || allParents.get(sigName).contains(label)) {
            if (discoverFields.containsKey(sigName)) {
              discoverFields.get(sigName).add(fieldType.getLabel());
            } else {
              discoverFields.put(sigName, new ArrayList<>(Arrays.asList(fieldType.getLabel())));
            }
            break;
          }
        }
      }
    }

    for (final FieldType fieldType : fields) {
      for (final TypesType typesType : fieldType.getTypes()) {
        String sourceLabel =
            AlloyUtilities.getSigTypeById(typesType.getType().get(0).getID()).getLabel();
        sourceLabel = sourceLabel.substring(sourceLabel.lastIndexOf("/") + 1);
        String targetLabel =
            AlloyUtilities.getSigTypeById(typesType.getType().get(1).getID()).getLabel();
        targetLabel = targetLabel.substring(targetLabel.lastIndexOf("/") + 1);

        if (sourceLabel.equals(sigName) || allParents.get(sigName).contains(sourceLabel)
            || targetLabel.equals(sigName) || allParents.get(sigName).contains(targetLabel)) {
          if (reasonRelations.containsKey(sourceLabel)) {
            reasonRelations.get(sourceLabel).add(fieldType.getLabel());
          } else {
            reasonRelations.put(sourceLabel, new ArrayList<>(Arrays.asList(fieldType.getLabel())));
          }
        }
      }
    }

    for (final FieldType fieldType : fields) {
      final String fieldName = fieldType.getLabel();

      final List<String> allSources = new ArrayList<>();
      final List<String> allTargets = new ArrayList<>();
      for (final TypesType typesType : fieldType.getTypes()) {
        final EList<TypeType> typeType = typesType.getType();
        allSources.addAll(AlloyUtilities.getAllChildNames(typeType.get(0).getID()));
        allTargets.addAll(AlloyUtilities.getAllChildNames(typeType.get(1).getID()));
      }

      boolean accept = false;
      for (final Entry<String, List<String>> entry : discoverFields.entrySet()) {
        final String discoverSig = entry.getKey();
        final List<String> discoverFieldsOfSig = entry.getValue();
        if (discoverFieldsOfSig.contains(fieldName)
            && (allSources.contains(discoverSig) || allTargets.contains(discoverSig))) {
          accept = true;
          break;
        }
      }

      String parentSigName = AlloyUtilities.getSigTypeById(fieldType.getParentID()).getLabel();
      parentSigName = parentSigName.substring(parentSigName.lastIndexOf("/") + 1);

      final EList<TupleType> tuples = fieldType.getTuple();
      for (int i = 0; i < tuples.size(); i++) {

        final String sigName1 = AlloyUtilities
            .getAtomNameById(tuples.get(i).getAtom().get(0).getLabel()).replace("$", "_");
        final String sigName2 = AlloyUtilities
            .getAtomNameById(tuples.get(i).getAtom().get(1).getLabel()).replace("$", "_");

        builder.append(sigName1 + "->" + sigName2);

        if (i + 1 != tuples.size()) {
          builder.append(" +\n");
        } else if (accept) {
          builder.append(" in " + parentSigName + "<:" + fieldName + "\n");
        } else {
          builder.append(" = " + parentSigName + "<:" + fieldName + "\n");
        }
      }

      final List<String> allRelations = new ArrayList<>();
      for (final List<String> value : discoverFields.values()) {
        allRelations.addAll(value);
      }

      if (fieldType.getTuple().size() == 0 && !accept) {
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
      final String newFilePath =
          InstanceTranslatorReasoningForAtom.baseFileDirectory + fileName + ".als";

      final String content = source.getContent();
      writeContentToFile(newFilePath, content);
    }
  }

  public String getBaseFileDirectory() {
    return InstanceTranslatorReasoningForAtom.baseFileDirectory;
  }

  public void translate() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final AlloyType alloy = documentRoot.getAlloy();

    calcOldSigValues(alloy.getInstance().getSig());
    createSourceFiles(alloy.getSource());
    createSigPart(alloy.getInstance().getSig());
    createFactPart(documentRoot, alloy.getInstance().getField());
    createRunPart();

    writeContentToFile(
        InstanceTranslatorReasoningForAtom.baseFileDirectory + "reasoningForAtom.als",
        builder.toString());
  }

  private void createRunPart() {
    builder.append("pred show{}\n");
    builder.append("run show for");

    for (final Entry<String, Integer> oldEntry : sig2oldValue.entrySet()) {
      final int value = oldEntry.getValue();
      builder.append("\nexactly " + value + " " + oldEntry.getKey() + ",");
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
      if (sigType.getID() > 3) {
        sig2oldValue.put(sigName, sigType.getAbstract() != null ? 0 : sigType.getAtom().size());
      }
    }
  }

  public Map<String, List<String>> getReasonRelations() {
    return reasonRelations;
  }
}
