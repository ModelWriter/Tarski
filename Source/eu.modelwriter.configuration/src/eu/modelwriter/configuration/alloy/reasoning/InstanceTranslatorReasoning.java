package eu.modelwriter.configuration.alloy.reasoning;

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

public class InstanceTranslatorReasoning {

  public static String baseFileDirectory =
      ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/.modelwriter\\reasoning\\";

  public static void main(final String[] args) {
    final InstanceTranslatorReasoning instanceTranslator = new InstanceTranslatorReasoning();

    instanceTranslator.translate();
  }

  private final List<String> reasonRelations = new ArrayList<>();

  private final StringBuilder builder;

  public InstanceTranslatorReasoning() {
    this.builder = new StringBuilder();
  }

  private void createFactPart(final DocumentRoot documentRoot, final List<FieldType> fields) {
    this.builder.append("fact {\n");

    for (final FieldType field : fields) {
      final String fieldName = field.getLabel();
      int tupleCount = 0;

      for (final TupleType tuple : field.getTuple()) {
        tupleCount++;

        final String sigName1 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(0).getLabel()).replace("$", "_");
        final String sigName2 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(1).getLabel()).replace("$", "_");

        this.builder.append(sigName1 + "->" + sigName2);

        if (tupleCount != field.getTuple().size()) {
          this.builder.append(" +\n");
        } else if (!this.reasonRelations.contains(fieldName)) {
          this.builder.append(" = " + fieldName + "\n");
        } else {
          this.builder.append(" in " + fieldName + "\n");
        }

      }

      String parentSigName = AlloyUtilities.getSigTypeById(field.getParentID()).getLabel();
      parentSigName = parentSigName.substring(parentSigName.indexOf("/") + 1);

      if (field.getTuple().size() == 0 && !this.reasonRelations.contains(fieldName)) {
        this.builder.append(parentSigName + "." + fieldName + " = none\n");
      }
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
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return file;
  }

  private int createSigPart(final List<SigType> sigs) {
    int sigCount = 0;

    for (final SigType sig : sigs) {
      final String sigName = sig.getLabel().substring(sig.getLabel().indexOf("/") + 1);
      for (int i = 0; i < sig.getAtom().size(); i++) {
        this.builder.append("one sig " + sigName + "_" + i + " extends " + sigName + "{ } \n");
        sigCount++;
      }
    }
    return sigCount;
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
      final String newFilePath = InstanceTranslatorReasoning.baseFileDirectory + fileName + ".als";

      final String content = this.removeReasoningParts(source.getContent());
      this.writeContentToFile(newFilePath, content);
    }
  }

  public String getBaseFileDirectory() {
    return InstanceTranslatorReasoning.baseFileDirectory;
  }

  public List<String> getReasonRelations() {
    return this.reasonRelations;
  }

  private String removeReasoningParts(final String content) {
    final List<String> lines = Arrays.asList(content.split("\n"));

    for (final String line : lines) {
      if (line.contains("-- Reason@") || line.contains("--Reason@")) {
        this.reasonRelations.add(line.substring(line.lastIndexOf("Reason@") + 7, line.length()));
      }
    }

    return content;
  }

  public void translate() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final AlloyType alloy = documentRoot.getAlloy();

    this.createSourceFiles(alloy.getSource());
    final int sigCount = this.createSigPart(alloy.getInstance().getSig());
    this.createFactPart(documentRoot, alloy.getInstance().getField());

    this.builder.append("pred show{}\n");
    this.builder.append("run show for " + sigCount);

    this.writeContentToFile(InstanceTranslatorReasoning.baseFileDirectory + "reasoning.als",
        this.builder.toString());
  }

  private void writeContentToFile(final String filePath, final String content) {
    try {
      final File file = this.createFile(filePath);
      final FileOutputStream out = new FileOutputStream(file);
      out.write(content.getBytes());
      out.close();
    } catch (final IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
