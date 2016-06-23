package eu.modelwriter.configuration.alloy.discovery;

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

public class InstanceTranslatorDiscovering {

  public static String baseFileDirectory =
      ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/.modelwriter\\discovering\\";

  public static void main(final String[] args) {
    final InstanceTranslatorDiscovering instanceTranslator = new InstanceTranslatorDiscovering();

    instanceTranslator.translate();
  }

  private final Map<String, Integer> sig2oldValue = new HashMap<>();
  private final Map<String, Integer> discoverSig2ExpectValue = new HashMap<>();
  private final Map<String, Integer> ancestorSig2newValue = new HashMap<>();

  private final StringBuilder builder;

  public InstanceTranslatorDiscovering() {
    this.builder = new StringBuilder();
  }

  private void createFactPart(final DocumentRoot documentRoot, final List<FieldType> fields) {
    this.builder.append("fact {\n");

    final List<String> discoverFields = new ArrayList<>();
    for (final FieldType fieldType : fields) {
      for (final TypesType typesType : fieldType.getTypes()) {
        for (final TypeType typeType : typesType.getType()) {
          String label = AlloyUtilities.getSigTypeById(typeType.getID()).getLabel();
          label = label.substring(label.indexOf("/") + 1);
          if (this.discoverSig2ExpectValue.containsKey(label)) {
            discoverFields.add(fieldType.getLabel());
            break;
          }
        }
      }
    }

    for (final FieldType fieldType : fields) {
      final String fieldName = fieldType.getLabel();
      int tupleCount = 0;

      for (final TupleType tuple : fieldType.getTuple()) {
        tupleCount++;

        final String sigName1 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(0).getLabel()).replace("$", "_");
        final String sigName2 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(1).getLabel()).replace("$", "_");

        this.builder.append(sigName1 + "->" + sigName2);

        if (tupleCount != fieldType.getTuple().size()) {
          this.builder.append(" +\n");
        } else if (!discoverFields.contains(fieldName)) {
          this.builder.append(" = " + fieldName + "\n");
        } else {
          this.builder.append(" in " + fieldName + "\n");
        }
      }

      String parentSigName = AlloyUtilities.getSigTypeById(fieldType.getParentID()).getLabel();
      parentSigName = parentSigName.substring(parentSigName.indexOf("/") + 1);

      if (fieldType.getTuple().size() == 0 && !discoverFields.contains(fieldName)) {
        this.builder.append(parentSigName + "." + fieldName + " = none\n");
      }
    }

    for (final Entry<String, Integer> entry : this.discoverSig2ExpectValue.entrySet()) {
      final String discovered = "#" + entry.getKey();
      final int expectValue = entry.getValue();
      final int oldValue = this.sig2oldValue.get(entry.getKey());
      this.builder.append(discovered + " > " + oldValue + "\n");
      this.builder.append(discovered + " < " + (oldValue + expectValue + 1) + "\n");
    }

    this.builder.append("}\n");

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
    // int sigCount = 0;

    for (final SigType sig : sigs) {
      final String sigName = sig.getLabel().substring(sig.getLabel().indexOf("/") + 1);
      if (sig.getID() > 3 && sig.getAbstract() == null) {
        this.sig2oldValue.put(sigName, sig.getAtom().size());
      }
      for (int i = 0; i < sig.getAtom().size(); i++) {
        this.builder.append("one sig " + sigName + "_" + i + " extends " + sigName + "{ } \n");
        // sigCount++;
      }
    }
    // return sigCount;
  }

  private void createSourceFiles(final EList<SourceType> sources) {
    boolean isFirst = false;
    for (final SourceType source : sources) {
      final String sourceFilePath = source.getFilename();
      final String fileName = sourceFilePath.substring(sourceFilePath.lastIndexOf("\\") + 1,
          sourceFilePath.lastIndexOf("."));
      if (!isFirst) {
        this.builder.append("open " + fileName + "\n");
        isFirst = true;
      }
      final String newFilePath =
          InstanceTranslatorDiscovering.baseFileDirectory + fileName + ".als";

      final String content = this.removeDiscoveringParts(source.getContent());
      this.writeContentToFile(newFilePath, content);
    }
  }

  public String getBaseFileDirectory() {
    return InstanceTranslatorDiscovering.baseFileDirectory;
  }

  public Map<String, Integer> getDiscoverSig2ExpectValue() {
    return this.discoverSig2ExpectValue;
  }

  private String removeDiscoveringParts(final String content) {
    final List<String> lines = Arrays.asList(content.split("\n"));

    for (final String line : lines) {
      if (!line.startsWith("//")
          && (line.contains("-- Discover@") || line.contains("--Discover@"))) {
        final String discover = line.substring(line.lastIndexOf("Discover@") + 9, line.length());
        final String[] split = discover.split(" ");
        final String discoverAtom = split[0];
        String expectedNumberInString = split[2].trim();
        final int expectValue = Integer.valueOf(expectedNumberInString);
        this.discoverSig2ExpectValue.put(discoverAtom, expectValue);
        final SigType ancestor =
            AlloyUtilities.getAncestorOfSig(AlloyUtilities.getSigTypeIdByName(discoverAtom));
        final ArrayList<Integer> allChildIds = AlloyUtilities.getAllChildIds(ancestor.getID());

        int total = 0;
        for (final Integer integer : allChildIds) {
          final SigType childSig = AlloyUtilities.getSigTypeById(integer);
          if (childSig.getType().size() == 0) { // for in relation
            total += childSig.getAtom().size();
          }
        }
        String anc_label = ancestor.getLabel();
        anc_label = anc_label.substring(anc_label.indexOf("/") + 1);
        this.ancestorSig2newValue.put(anc_label, total + expectValue);
      }
    }

    return content;
  }

  public void translate() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final AlloyType alloy = documentRoot.getAlloy();

    this.createSourceFiles(alloy.getSource());
    this.createSigPart(alloy.getInstance().getSig());
    this.createFactPart(documentRoot, alloy.getInstance().getField());

    this.builder.append("pred show{}\n");

    // TODO araya virgül atma kodu yapılacak
    this.builder.append("run show for exactly ");
    for (final Entry<String, Integer> ancestor : this.ancestorSig2newValue.entrySet()) {
      this.builder.append(ancestor.getValue() + " " + ancestor.getKey() + ",");
    }
    for (final Entry<String, Integer> oldEntry : this.sig2oldValue.entrySet()) {
      if (!this.discoverSig2ExpectValue.containsKey(oldEntry.getKey())) {
        this.builder.append(oldEntry.getValue() + " " + oldEntry.getKey() + ",");
      }
    }
    this.builder.replace(0, this.builder.length(),
        this.builder.substring(0, this.builder.length() - 1));

    this.writeContentToFile(InstanceTranslatorDiscovering.baseFileDirectory + "discovering.als",
        this.builder.toString());
  }

  private void writeContentToFile(final String filePath, final String content) {
    try {
      final File file = this.createFile(filePath);
      final FileOutputStream out = new FileOutputStream(file);
      out.write(content.getBytes());
      out.close();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
}
