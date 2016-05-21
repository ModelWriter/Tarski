package eu.modelwriter.configuration.alloy.validation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.SourceType;
import eu.modelwriter.traceability.core.persistence.TupleType;

public class InstanceTranslator {

  protected String baseFileDirectory =
      "C:\\Users\\3\\runtime-New_configuration22\\" + ".modelwriter\\.validation\\";

  private StringBuilder builder;

  public InstanceTranslator() {
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

    writeContentToFile(baseFileDirectory + "ValidateFile.als", builder.toString());
  }

  private int createSigPart(List<SigType> sigs) {
    int sigCount = 0;

    for (SigType sig : sigs) {
      String sigName = sig.getLabel().substring(sig.getLabel().indexOf("/") + 1);
      for (int i = 0; i < sig.getAtom().size(); i++) {
        builder.append("one sig " + sigName + i + " extends " + sigName + "{ } \n");
        sigCount++;
      }
    }
    return sigCount;
  }


  private void createFactPart(DocumentRoot documentRoot, List<FieldType> fields) {
    builder.append("fact {\n");

    for (FieldType field : fields) {
      String fieldName = field.getLabel();
      Map<String, Integer> fieldCountMap = new HashMap<>();
      for (TupleType tuple : field.getTuple()) {
        String sigName1 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(0).getLabel()).replace("$", "");
        String sigName2 =
            AlloyUtilities.getAtomNameById(tuple.getAtom().get(1).getLabel()).replace("$", "");

        String fieldWithAtom = sigName1 + "." + fieldName;

        if (!fieldCountMap.containsKey(fieldWithAtom))
          fieldCountMap.put(fieldWithAtom, 1);
        else
          fieldCountMap.put(fieldWithAtom, fieldCountMap.get(fieldWithAtom) + 1);

        builder.append(sigName2 + " in " + fieldWithAtom + "\n");
      }

      String parentSigName = AlloyUtilities.getSigTypeById(field.getParentID()).getLabel();
      parentSigName = parentSigName.substring(parentSigName.indexOf("/") + 1);

      builder.append("#" + parentSigName + "." + fieldName + "=" + field.getTuple().size() + "\n");

      Iterator<Entry<String, Integer>> iter = fieldCountMap.entrySet().iterator();

      while (iter.hasNext()) {
        Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iter.next();
        builder.append("#" + entry.getKey() + "=" + entry.getValue() + "\n");
      }
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

      writeContentToFile(newFilePath, source.getContent());
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

  public static void main(String[] args) {
    InstanceTranslator instanceTranslator = new InstanceTranslator();

    instanceTranslator.translate();
  }
}
