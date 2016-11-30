package eu.modelwriter.configuration.alloy.analysis.discovering;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.SourceType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypeType;
import eu.modelwriter.traceability.core.persistence.TypesType;

public class InstanceTranslator4Discovering {
  private final Map<String, Integer> sig2oldValue = new HashMap<>();
  private final Map<String, Integer> discoverSig2ExpectValue = new HashMap<>();
  private final Map<String, Integer> sig2OldDiscoveredValue = new HashMap<>();

  private final StringBuilder builder;
  private final String baseFileDirectory;
  private final String alsPath;

  public InstanceTranslator4Discovering(final String baseFileDirectory, final String alsPath) {
    this.baseFileDirectory = baseFileDirectory;
    this.alsPath = alsPath;
    builder = new StringBuilder();
  }

  private void createFactPart(final DocumentRoot documentRoot, final List<FieldType> fields) {
    builder.append("fact {\n");

    final Map<String, List<String>> discoverFields = new HashMap<>();
    final Map<String, List<String>> allParents = new HashMap<>();

    final Iterator<String> iterator = discoverSig2ExpectValue.keySet().iterator();
    while (iterator.hasNext()) {
      final String sigName = iterator.next();
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
      final String newFilePath = baseFileDirectory + fileName + ".als";

      final String content = removeDiscoveringParts(source.getContent());
      writeContentToFile(newFilePath, content);
    }
  }

  public Map<String, Integer> getDiscoverSig2ExpectValue() {
    return discoverSig2ExpectValue;
  }

  private String removeDiscoveringParts(final String content) {
    final List<String> lines = Arrays.asList(content.split("\n"));

    final Pattern p =
        Pattern.compile("(-)(-)(\\s*)(Discover|discover)(@)((?:[a-z0-9_]+))(\\s*)(\\d+)(\\s*)",
            Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    for (final String line : lines) {
      final Matcher matcher = p.matcher(line);

      if (!matcher.find()) {
        continue;
      } else {
        final String discoveredSig = matcher.group(6); // it gets ((?:[a-z]+)) group
        final int value = Integer.valueOf(matcher.group(8));// it gets (\\d+) group

        discoverSig2ExpectValue.put(discoveredSig, value);
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

    writeContentToFile(alsPath, builder.toString());
  }

  private void createRunPart() {
    builder.append("pred show{}\n");
    builder.append("run show for");

    for (final Entry<String, Integer> oldEntry : sig2oldValue.entrySet()) {
      int oldValue = oldEntry.getValue();
      final String sigName = oldEntry.getKey();

      if (discoverSig2ExpectValue.containsKey(sigName)) {
        final int expectValue = discoverSig2ExpectValue.get(oldEntry.getKey());
        final int oldDiscoveredValue = sig2OldDiscoveredValue.get(sigName);
        if (expectValue >= oldDiscoveredValue) {
          oldValue += expectValue - oldDiscoveredValue;
        }
      }
      builder.append("\n" + "exactly " + oldValue + " " + oldEntry.getKey() + ",");
    }

    builder.replace(0, builder.length(), builder.substring(0, builder.length() - 1)); // to delete
    // last ','
  }

  private void calcOldSigValues(final EList<SigType> sigTypes) {
    for (final SigType sigType : sigTypes) {
      final String sigName = sigType.getLabel().substring(sigType.getLabel().lastIndexOf("/") + 1);
      if (sigType.getID() > 3) {
        sig2oldValue.put(sigName, sigType.getAbstract() != null ? 0 : sigType.getAtom().size());
        int discoveredAtomCount = 0;
        for (final AtomType atomType : sigType.getAtom()) {
          if (atomType.isReasoned()) {
            discoveredAtomCount++;
          }
        }
        sig2OldDiscoveredValue.put(sigName, discoveredAtomCount);
      }
    }
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
}
