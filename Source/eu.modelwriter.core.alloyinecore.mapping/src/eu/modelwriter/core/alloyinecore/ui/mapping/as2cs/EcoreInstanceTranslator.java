package eu.modelwriter.core.alloyinecore.ui.mapping.as2cs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import eu.modelwriter.core.alloyinecore.structure.base.Repository;

public class EcoreInstanceTranslator {

  private STGroupFile templateGroup;
  private final Map<String, String> imports = new HashMap<>();
  private EObject root;

  public EcoreInstanceTranslator() {
    templateGroup = new STGroupFile("stringtemplate/EcoreInstance.stg");
  }

  public String translate(String pathToFile) throws IOException {
    Repository repository = new Repository();
    Resource resource = repository.loadResource(pathToFile);
    if (resource != null && !resource.getContents().isEmpty())
      return translate(resource.getContents().get(0));
    return "";
  }

  public String translate(EObject root) {
    this.root = root;
    StringBuilder builder = new StringBuilder();
    builder.append(getModelToString(root));
    builder.append(eObjectToString(root));
    builder.insert(0, importsToString());
    return builder.toString();
  }

  private String importsToString() {
    StringBuilder importsBuilder = new StringBuilder();
    imports.entrySet().forEach(entry -> {
      ST template = templateGroup.getInstanceOf("load");
      template.add("name", entry.getValue());
      template.add("path", entry.getKey());
      importsBuilder.append(template.render().trim());
      importsBuilder.append("\n");
    });
    if (importsBuilder.length() > 0)
      importsBuilder.append("\n");
    return importsBuilder.toString();
  }

  private String getModelToString(EObject eObject) {
    ST template = templateGroup.getInstanceOf("model");
    EPackageImpl eContainer = (EPackageImpl) eObject.eClass().eContainer();
    template.add("name", eContainer.getName());
    template.add("nsPrefix", eContainer.getNsPrefix());
    template.add("nsURI", eContainer.getNsURI());
    template.add("path", getLocation(eContainer.eResource().getURI()));
    return template.render();
  }

  private String eObjectToString(EObject eObject) {
    ST template = templateGroup.getInstanceOf("eObject");
    template.add("className", getClassName(eObject));
    EClass eClass = eObject.eClass();
    EAttribute idAttr = eClass.getEIDAttribute();
    if (idAttr != null) {
      Object eGet = eObject.eGet(idAttr);
      template.add("id", objectToString(eGet));
    }
    // Append Attributes
    for (EAttribute eAttribute : eClass.getEAllAttributes()) {
      Object value = eObject.eGet(eAttribute);
      if (value != null && !eAttribute.isID())
        template.add("content", attrToString(eAttribute, value));
    }
    // Append References
    for (EReference eReference : eClass.getEAllReferences()) {
      Object value = eObject.eGet(eReference);
      if (value != null) {
        template.add("content", eReference.isContainment() ? conRefToString(eReference, value)
            : refToString(eReference, value));
      }
    }
    return template.render();
  }

  /**
   * Converts containment reference to string
   * 
   * @param eReference
   * @param value
   * @return
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  private String conRefToString(EReference eReference, Object value) {
    if (value instanceof EList && ((EList) value).isEmpty())
      return null;
    ST template = templateGroup.getInstanceOf("containmentRef");
    template.add("name", eReference.getName());
    if (value instanceof EList) {
      EList<EObject> list = (EList) value;
      list.forEach(eObj -> {
        template.add("content", eObjectToString(eObj));
      });
    } else if (value instanceof EObject) {
      template.add("content", eObjectToString((EObject) value));
    }
    return template.render();
  }

  @SuppressWarnings("rawtypes")
  private String attrToString(EAttribute attr, Object value) {
    if (value instanceof EList && ((EList) value).isEmpty())
      return null;
    return attr.getName() + ": " + objectToString(value);
  }

  /**
   * Converts non-containment reference to string
   * 
   * @param eReference
   * @param value
   * @return
   */
  @SuppressWarnings("rawtypes")
  private String refToString(EReference ref, Object value) {
    if (value instanceof EList && ((EList) value).isEmpty())
      return null;
    return ref.getName() + ": " + objectToString(value);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  private String objectToString(Object obj) {
    if (obj instanceof EList) {
      EList<Object> list = (EList) obj;
      StringBuilder builder = new StringBuilder();
      if (list.size() > 1)
        builder.append("[");
      for (Object eObj : list) {
        builder.append(objectToString(eObj));
        builder.append(", ");
      }
      if (builder.length() > 1)
        builder.delete(builder.length() - 2, builder.length());
      if (list.size() > 1)
        builder.append("]");
      return builder.toString();
    }
    if (obj instanceof Number || obj instanceof Boolean || obj instanceof EEnumLiteral)
      return obj.toString();

    if (obj instanceof Character)
      return "\'" + obj.toString() + "\'";

    if (obj instanceof EObject) {
      return getEObjectRefString((EObject) obj);
    }
    // Return as string
    return "\"" + obj.toString().replaceAll("\"", "\\\\\"").replaceAll("\'", "\\\\\'") + "\"";
  }

  /**
   * Get DynamicEObjectImpl's EClass name with package information
   * 
   * @param eObject
   * @return
   */
  private String getClassName(EObject eObject) {
    return getPackageName(root.eClass(), eObject.eClass()) + getURIString(eObject.eClass());
  }

  /**
   * Get an EObject's path with package information
   * 
   * @param eObject
   * @return
   */
  private String getEObjectRefString(EObject eObject) {
    return getPackageName(root, eObject) + getURIString(eObject);
  }

  private String getURIString(EObject eObject) {
    return EcoreUtil.getURI(eObject).fragment().replaceAll("//", "").replaceAll("@", "")
        .replaceAll("/", "::");
  }

  /**
   * Returns root package name of given EObject. If EObject directly inside of root returns empty
   * string. Also if given EObject is part of another EMF file imports that file and returns
   * import's name.
   * 
   * @param root
   * @param eObject
   * @return
   */
  private String getPackageName(EObject root, EObject eObject) {
    URI eObjectURI = EcoreUtil.getURI(eObject);
    URI rootURI = EcoreUtil.getURI(root);

    if (!rootURI.trimFragment().equals(eObjectURI.trimFragment())) {
      String fileLocation = getLocation(eObject);
      // Check if its already imported
      String importName = imports.get(fileLocation);
      if (importName == null) {
        importName = handleImportName(eObjectURI.trimFileExtension().lastSegment());
        imports.put(fileLocation, importName);
      }
      return importName + "::";
    }
    return "";

  }

  /**
   * Configures import names. If given name already in imports map, adds numbers as suffix until the
   * name becomes unique
   * 
   * @param baseName
   * @return
   */
  private String handleImportName(String baseName) {
    if (imports.values().contains(baseName)) {
      // Gotta find new name for this
      int suffix = 1;
      while (imports.get(baseName + ++suffix) != null);
      return baseName + suffix;
    }
    return baseName;
  }

  /**
   * Get EObject's file location relative to root object.
   * 
   * @param eObject
   * @return
   */
  private String getLocation(EObject eObject) {
    return getLocation(EcoreUtil.getURI(eObject));
  }

  /**
   * Get EObject's file location relative to root object.
   * 
   * @param eObject
   * @return
   */
  private String getLocation(URI uri) {
    URI rootURI = EcoreUtil.getURI(root).trimFragment();
    URI deresolvedUri = uri.trimFragment().deresolve(rootURI, true, true, true);
    if (deresolvedUri.isFile())
      return deresolvedUri.toFileString();
    else
      return deresolvedUri.toString();
  }
}
