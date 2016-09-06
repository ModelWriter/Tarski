package eu.modelwriter.configuration.alloy.validation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.SourceType;
import eu.modelwriter.traceability.core.persistence.TupleType;

public class InstanceTranslator {

  public static String baseFileDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation()
      + " .modelwriter validation ".replace(" ", System.getProperty("file.separator"));

  public static void main(final String[] args) {
    final InstanceTranslator instanceTranslator = new InstanceTranslator();

    instanceTranslator.translate();
  }

  private final List<String> reasonRelations = new ArrayList<>();

  private final StringBuilder builder;

  public InstanceTranslator() {
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
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(0).getLabel()).replace("$", "");
        final String sigName2 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(1).getLabel()).replace("$", "");

        builder.append(sigName1 + "->" + sigName2);

        if (tupleCount != field.getTuple().size()) {
          builder.append(" +\n");
        } else {
          builder.append(" = " + fieldName + "\n");
        }
      }

      String parentSigName = AlloyUtilities.getSigTypeById(field.getParentID()).getLabel();
      parentSigName = parentSigName.substring(parentSigName.indexOf("/") + 1);

      if (field.getTuple().size() == 0) {
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

  private int createSigPart(final List<SigType> sigs) {
    int sigCount = 0;

    for (final SigType sig : sigs) {
      final String sigName = sig.getLabel().substring(sig.getLabel().indexOf("/") + 1);
      for (int i = 0; i < sig.getAtom().size(); i++) {
        builder.append("one sig " + sigName + i + " extends " + sigName + "{ } \n");
        sigCount++;
      }
    }
    return sigCount;
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
      final String newFilePath = InstanceTranslator.baseFileDirectory + fileName + ".als";

      final String content = this.removeReasoningParts(source.getContent());
      this.writeContentToFile(newFilePath, content);
    }
  }

  public String getBaseFileDirectory() {
    return InstanceTranslator.baseFileDirectory;
  }

  private String removeReasoningParts(final String content) {
    String newContent = "";
    final List<String> lines = Arrays.asList(content.split("\n"));

    boolean isRemoveFact = false;
    for (final String line : lines) {
      if (line.contains("-- Reason@") || line.contains("--Reason@")) {
        this.reasonRelations.add(line.substring(line.lastIndexOf("Reason@") + 7, line.length()));
        isRemoveFact = true;
      } else if (!isRemoveFact) {
        newContent += line + "\n";
      } else {
        if (line.contains("}")) {
          isRemoveFact = false;
        }
      }
    }

    return newContent;
  }

  public void translate() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final AlloyType alloy = documentRoot.getAlloy();

    createSourceFiles(alloy.getSource());
    final int sigCount = createSigPart(alloy.getInstance().getSig());
    createFactPart(documentRoot, alloy.getInstance().getField());
    createRunPart(sigCount);

    writeContentToFile(InstanceTranslator.baseFileDirectory + "validation.als", builder.toString());
  }

  private void createRunPart(final int sigCount) {
    builder.append("pred show{}\n");
    builder.append("run show for " + sigCount);
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
