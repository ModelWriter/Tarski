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
import eu.modelwriter.traceability.core.persistence.TypeType;
import eu.modelwriter.traceability.core.persistence.TypesType;

public class InstanceTranslatorDiscovering {

  // public static void main(final String[] args) {
  // final String txt = "-- Discover@ContractRequirement expect 2";
  //
  // final String re1 = "(-)"; // Any Single Character 1
  // final String re2 = "(-)"; // Any Single Character 2
  // final String re3 = "(\\s*)"; // White Space 1
  // final String re4 = "(Discover|discover)"; // Word 1
  // final String re5 = "(@)"; // Any Single Character 3
  // final String re6 = "((?:[a-z]+))"; // Word 2
  // final String re7 = "(\\s*)"; // White Space 2
  // final String re8 = "(expect|Expect|exactly|Exactly)"; // Word 3
  // final String re9 = "(\\s*)"; // White Space 3
  // final String re10 = "(\\d+)"; // Integer Number 1
  // final String re11 = "(\\s*)"; // White Space 4
  //
  // final Pattern p =
  // Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 +
  // re10 + re11,
  // Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
  // final Matcher m = p.matcher(txt);
  // if (m.find()) {
  // final String c1 = m.group(1);
  // final String c2 = m.group(2);
  // final String ws1 = m.group(3);
  // final String word1 = m.group(4);
  // final String c3 = m.group(5);
  // final String word2 = m.group(6);
  // final String ws2 = m.group(7);
  // final String word3 = m.group(8);
  // final String ws3 = m.group(9);
  // final String int1 = m.group(10);
  // final String ws4 = m.group(11);
  // System.out.print("(" + c1.toString() + ")" + "(" + c2.toString() + ")" +
  // "(" + ws1.toString()
  // + ")" + "(" + word1.toString() + ")" + "(" + c3.toString() + ")" + "(" +
  // word2.toString()
  // + ")" + "(" + ws2.toString() + ")" + "(" + word3.toString() + ")" + "(" +
  // ws3.toString()
  // + ")" + "(" + int1.toString() + ")" + "(" + ws4.toString() + ")" + "\n");
  // }
  // }

  public static String baseFileDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation()
      + " .modelwriter discovering ".replace(" ", System.getProperty("file.separator"));

  private final Map<String, Integer> sig2oldValue = new HashMap<>();
  private final Map<String, Integer> discoverSig2ExpectValue = new HashMap<>();
  private final Map<String, Integer> ancestorSig2newValue = new HashMap<>();
  private final Map<String, String> discoveringBound = new HashMap<>();

  private final StringBuilder builder;

  public InstanceTranslatorDiscovering() {
    this.builder = new StringBuilder();
  }

  private void createFactPart(final DocumentRoot documentRoot, final List<FieldType> fields) {
    this.builder.append("fact {\n");

    final Map<String, List<String>> discoverFields = new HashMap<>();
    for (final FieldType fieldType : fields) {
      for (final TypesType typesType : fieldType.getTypes()) {
        for (final TypeType typeType : typesType.getType()) {
          String label = AlloyUtilities.getSigTypeById(typeType.getID()).getLabel();
          label = label.substring(label.indexOf("/") + 1);
          if (this.discoverSig2ExpectValue.containsKey(label)) {
            if (discoverFields.containsKey(label)) {
              discoverFields.get(label).add(fieldType.getLabel());
            } else {
              discoverFields.put(label, new ArrayList<>(Arrays.asList(fieldType.getLabel())));
            }
            break;
          }
        }
      }
    }

    for (final FieldType fieldType : fields) {
      final String fieldName = fieldType.getLabel();

      final EList<TupleType> tuples = fieldType.getTuple();
      for (int i = 0; i < tuples.size(); i++) {
        // if (tuples.get(i).getAtom().get(0).isReasoned()
        // || tuples.get(i).getAtom().get(1).isReasoned()) {
        // continue;
        // }
        //
        // if (i != 0 && !tuples.get(i - 1).getAtom().get(0).isReasoned()
        // && !tuples.get(i - 1).getAtom().get(1).isReasoned()) {
        // this.builder.append(" +\n");
        // }

        final String sigName1 =
            AlloyUtilities.getAtomNameById(tuples.get(i).getAtom().get(0).getLabel()).replace("$",
                "_");
        final String sigName2 =
            AlloyUtilities.getAtomNameById(tuples.get(i).getAtom().get(1).getLabel()).replace("$",
                "_");

        this.builder.append(sigName1 + "->" + sigName2);

        final String sig1 = sigName1.substring(0, sigName1.indexOf("_"));
        final String sig2 = sigName2.substring(0, sigName2.indexOf("_"));
        if (i + 1 != tuples.size()) {
          this.builder.append(" +\n");
        } else if (discoverFields.containsKey(sig1) && discoverFields.get(sig1).contains(fieldName)
            || discoverFields.containsKey(sig2) && discoverFields.get(sig2).contains(fieldName)) {
          this.builder.append(" in " + fieldName + "\n");
        } else {
          this.builder.append(" = " + fieldName + "\n");
        }
      }

      String parentSigName = AlloyUtilities.getSigTypeById(fieldType.getParentID()).getLabel();
      parentSigName = parentSigName.substring(parentSigName.indexOf("/") + 1);

      final List<String> allRelations = new ArrayList<>();
      for (final List<String> value : discoverFields.values()) {
        allRelations.addAll(value);
      }

      if (fieldType.getTuple().size() == 0 && !allRelations.contains(fieldName)) {
        this.builder.append(parentSigName + "." + fieldName + " = none\n");
      }
    }

    // for (final Entry<String, Integer> entry : this.discoverSig2ExpectValue.entrySet()) {
    // final String discovered = "#" + entry.getKey();
    // final int expectValue = entry.getValue();
    // final int oldValue = this.sig2oldValue.get(entry.getKey());
    // if (this.discoveringBound.get(entry.getKey()).equals("expect")) {
    // this.builder.append(discovered + " >= " + oldValue + "\n");
    // this.builder.append(discovered + " <= " + (oldValue + expectValue) + "\n");
    // } else
    // if (this.discoveringBound.get(entry.getKey()).equals("exactly")) {
    // this.builder.append(discovered + " = " + (oldValue + expectValue) + "\n");
    // }
    // }

    // for (final Entry<String, Integer> oldEntry : this.sig2oldValue.entrySet()) {
    // if (!this.discoverSig2ExpectValue.containsKey(oldEntry.getKey())) {
    // final String discovered = "#" + oldEntry.getKey();
    // final int oldValue = oldEntry.getValue();
    // this.builder.append(discovered + " = " + oldValue + "\n");
    // }
    // }

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
    for (final SigType sig : sigs) {
      final String sigName = sig.getLabel().substring(sig.getLabel().indexOf("/") + 1);
      for (int i = 0; i < sig.getAtom().size(); i++) {
        // if (sig.getAtom().get(i).isReasoned()) {
        // continue;
        // }
        this.builder.append("one sig " + sigName + "_" + i + " extends " + sigName + "{ } \n");
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

    final Pattern p = Pattern.compile(
        "(-)(-)(\\s*)(Discover|discover)(@)((?:[a-z]+))(\\s*)(expect|Expect|exactly|Exactly)(\\s*)(\\d+)(\\s*)",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    for (final String line : lines) {
      final Matcher matcher = p.matcher(line);

      if (!matcher.find()) {
        continue;
      } else {
        final String discoveredSig = matcher.group(6); // it gets ((?:[a-z]+)) group
        final int value = Integer.valueOf(matcher.group(10));// it gets (\\d+) group
        final String bound = matcher.group(8);

        final SigType ancestor =
            AlloyUtilities.getAncestorOfSig(AlloyUtilities.getSigTypeIdByName(discoveredSig));
        final ArrayList<Integer> allChildIds = AlloyUtilities.getAllChildIds(ancestor.getID());

        int childrenCount = 0;
        for (final Integer childId : allChildIds) {
          final SigType childSig = AlloyUtilities.getSigTypeById(childId);
          if (childSig.getType().size() == 0) { // for in relation
            childrenCount += childSig.getAtom().size();
          }
        }

        final int oldValue = this.sig2oldValue.get(discoveredSig);
        int expectValue = 0;
        if (bound.toLowerCase().equals("expect")) {
          expectValue = value;
          this.discoverSig2ExpectValue.put(discoveredSig, expectValue);
        } else if (bound.toLowerCase().equals("exactly")) {
          if (value >= oldValue) {
            expectValue = value - oldValue;
            this.discoverSig2ExpectValue.put(discoveredSig, expectValue);
          }
        }
        this.discoveringBound.put(discoveredSig, bound);

        String anc_label = ancestor.getLabel();
        anc_label = anc_label.substring(anc_label.indexOf("/") + 1);
        if (this.ancestorSig2newValue.get(anc_label) == null) {
          this.ancestorSig2newValue.put(anc_label, childrenCount + expectValue);
        } else {
          final int oldAnchestorValue = this.ancestorSig2newValue.get(anc_label);
          this.ancestorSig2newValue.put(anc_label, oldAnchestorValue + expectValue);
        }
      }
    }

    return content;
  }

  public void translate() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final AlloyType alloy = documentRoot.getAlloy();

    this.calcOldSigValues(alloy.getInstance().getSig());
    this.createSourceFiles(alloy.getSource());
    this.createSigPart(alloy.getInstance().getSig());
    this.createFactPart(documentRoot, alloy.getInstance().getField());
    this.createRunPart();

    this.builder.replace(0, this.builder.length(),
        this.builder.substring(0, this.builder.length() - 1)); // to delete last ','

    this.writeContentToFile(InstanceTranslatorDiscovering.baseFileDirectory + "discovering.als",
        this.builder.toString());
  }

  private void createRunPart() {
    this.builder.append("pred show{}\n");

    // TODO araya virgul atma kodu yapilacak
    this.builder.append("run show for ");
    // for (final Entry<String, Integer> ancestor : this.ancestorSig2newValue.entrySet()) {
    // this.builder.append(ancestor.getValue() + " " + ancestor.getKey() + ",");
    // }

    for (final Entry<String, Integer> oldEntry : this.sig2oldValue.entrySet()) {
      int value = oldEntry.getValue();
      String boundString = "";

      if (this.discoverSig2ExpectValue.containsKey(oldEntry.getKey())) {
        if (this.discoveringBound.get(oldEntry.getKey()).equals("exactly")) {
          final int discoverSigExpectValue = this.discoverSig2ExpectValue.get(oldEntry.getKey());
          value += discoverSigExpectValue;
          boundString = " exactly ";
        } else if (this.discoveringBound.get(oldEntry.getKey()).equals("expect")) {
          final int discoverSigExpectValue = this.discoverSig2ExpectValue.get(oldEntry.getKey());
          value += discoverSigExpectValue;
        }
      }
      this.builder.append(boundString + value + " " + oldEntry.getKey() + ",");
    }

    // int totalValue = 0;
    // for (final Entry<String, Integer> oldEntry : this.sig2oldValue.entrySet()) {
    // totalValue += oldEntry.getValue();
    // if (this.discoverSig2ExpectValue.containsKey(oldEntry.getKey())) {
    // totalValue += this.discoverSig2ExpectValue.get(oldEntry.getKey());
    // }
    // }
    // this.builder.append("run show for " + totalValue);
  }

  private void calcOldSigValues(final EList<SigType> sigTypes) {
    for (final SigType sigType : sigTypes) {
      final String sigName = sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1);
      if (sigType.getID() > 3 && sigType.getAbstract() == null) {
        // int value = 0;
        // for (final AtomType atomType : sigType.getAtom()) {
        // if (!atomType.isReasoned()) {
        // value++;
        // }
        // }
        // this.sig2oldValue.put(sigName, value);
        this.sig2oldValue.put(sigName, sigType.getAtom().size());
      }
    }
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
