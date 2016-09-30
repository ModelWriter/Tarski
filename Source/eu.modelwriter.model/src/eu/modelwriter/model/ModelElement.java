package eu.modelwriter.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

public class ModelElement implements IModelElement {
  public static enum BOUND {
    LOWER_BOUND, UPPER_BOUND, EXACT_BOUND
  }

  private final HashMap<String, Object> attributes = new HashMap<>();

  private final static String BOUND = "BOUND";
  private final static String IDENTIFIER = "ID";
  private final static String LABEL = "LABEL";
  private final static String DATA = "DATA";

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ModelElement)) {
      return false;
    }
    return ((ModelElement) obj).getID().equals(getID());
  }


  public ModelElement() {
    super();
  }

  protected ModelElement(final String id, final String label, final Serializable data,
      final BOUND bound) {
    setLabel(label);
    setID(id);
    setData(data);
    setBound(bound);
  }

  @Override
  protected ModelElement clone() {
    final ModelElement cloneElement = new ModelElement() {};
    cloneElement.setAttributes(getAttributes());
    return cloneElement;
  }


  @Override
  public int hashCode() {
    return getID().hashCode();
  }

  @Override
  public void setAttribute(final String key, final Object value) {
    if (key.equals(ModelElement.IDENTIFIER) || key.equals(ModelElement.LABEL)
        || key.equals(ModelElement.DATA) || key.equals(ModelElement.BOUND)) {
      return;
    }
    attributes.put(key, value);
  }

  @Override
  public void setAttributes(final HashMap<String, Object> newAttributes) {
    for (final Entry<String, Object> entry : newAttributes.entrySet()) {
      setAttribute(entry.getKey(), entry.getValue());
    }
  }

  protected void setData(final Serializable data) {
    attributes.put(ModelElement.DATA, data);
  }

  protected void setID(final String id) {
    attributes.put(ModelElement.IDENTIFIER, id);
  }

  protected void setLabel(final String label) {
    attributes.put(ModelElement.LABEL, label);
  }

  protected void setBound(final BOUND bound) {
    attributes.put(ModelElement.BOUND, bound);
  }

  @Override
  public Object getAttribute(final String key) {
    return attributes.get(key);
  }

  @Override
  public HashMap<String, Object> getAttributes() {
    return attributes;
  }

  public Serializable getData() {
    return (Serializable) getAttribute(ModelElement.DATA);
  }

  public String getID() {
    return (String) getAttribute(ModelElement.IDENTIFIER);
  }

  public String getLabel() {
    return (String) getAttribute(ModelElement.LABEL);
  }

  public BOUND getBound() {
    return (BOUND) getAttribute(ModelElement.BOUND);
  }
}
