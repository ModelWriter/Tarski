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

  private List<String> reasonRelations = new ArrayList<>();

  private StringBuilder builder;

  public InstanceTranslatorReasoning() {
    builder = new StringBuilder();
  }

  public String getBaseFileDirectory() {
    return baseFileDirectory;
  }

  public void translate() {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    AlloyType alloy = documentRoot.getAlloy();

    createSourceFiles(alloy.getSource());
    int sigCount = createSigPart(alloy.getInstance().getSig());
    createFactPart(documentRoot, alloy.getInstance().getField());

    builder.append("pred show{}\n");
    builder.append("run show for " + sigCount);

    writeContentToFile(baseFileDirectory + "reasoning.als", builder.toString());
  }

  private int createSigPart(List<SigType> sigs) {
    int sigCount = 0;

    for (SigType sig : sigs) {
      String sigName = sig.getLabel().substring(sig.getLabel().indexOf("/") + 1);
      for (int i = 0; i < sig.getAtom().size(); i++) {
        builder.append("one sig " + sigName + "_" + i + " extends " + sigName + "{ } \n");
        sigCount++;
      }
    }
    return sigCount;
  }

  private void createFactPart(DocumentRoot documentRoot, List<FieldType> fields) {
    builder.append("fact {\n");

    for (FieldType field : fields) {
      String fieldName = field.getLabel();
      int tupleCount = 0;

      for (TupleType tuple : field.getTuple()) {
        tupleCount++;

        String sigName1 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(0).getLabel()).replace("$", "_");
        String sigName2 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(1).getLabel()).replace("$", "_");

        builder.append(sigName1 + "->" + sigName2);

        if (tupleCount != field.getTuple().size())
          builder.append(" +\n");
        else if (!reasonRelations.contains(fieldName))
          builder.append(" = " + fieldName + "\n");
        else
          builder.append(" in " + fieldName + "\n");

      }

      String parentSigName = AlloyUtilities.getSigTypeById(field.getParentID()).getLabel();
      parentSigName = parentSigName.substring(parentSigName.indexOf("/") + 1);

      if (field.getTuple().size() == 0 && !reasonRelations.contains(fieldName))
        builder.append(parentSigName + "." + fieldName + " = none\n");
    }

    builder.append("}\n");
  }

  private void createSourceFiles(EList<SourceType> sources) {
    boolean isFirst = false;
    for (SourceType source : sources) {
      String sourceFilePath = source.getFilename();
      String fileName = sourceFilePath.substring(sourceFilePath.lastIndexOf("\\") + 1,
          sourceFilePath.lastIndexOf("."));
      if (!isFirst) {
        builder.append("open " + fileName + "\n");
        isFirst = true;
      }
      String newFilePath = baseFileDirectory + fileName + ".als";

      String content = removeReasoningParts(source.getContent());
      writeContentToFile(newFilePath, content);
    }
  }

  private File createFile(String filePath) {
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
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return file;
  }

  private void writeContentToFile(String filePath, String content) {
    try {
      File file = createFile(filePath);
      FileOutputStream out = new FileOutputStream(file);
      out.write(content.getBytes());
      out.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private String removeReasoningParts(String content) {
    List<String> lines = Arrays.asList(content.split("\n"));

    for (String line : lines) {
      if (line.contains("-- Reason@") || line.contains("--Reason@")) {
        reasonRelations.add(line.substring(line.lastIndexOf("Reason@") + 7, line.length()));
      }
    }

    return content;
  }

  public static void main(String[] args) {
    InstanceTranslatorReasoning instanceTranslator = new InstanceTranslatorReasoning();

    instanceTranslator.translate();
  }
}
