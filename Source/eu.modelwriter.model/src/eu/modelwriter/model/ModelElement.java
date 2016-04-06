package eu.modelwriter.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ModelElement implements IModelElement {
  private final static String IDENTIFIER = "ID";
  private final static String LABEL = "LABEL";
  private final static String DATA = "DATA";
  private final static String SETS = "SETS";

  private final HashMap<String, Object> attributes = new HashMap<>();

  public ModelElement() {}

  public ModelElement(final List<String> sets, final String id, final Serializable data) {
    this.setSets(sets);
    this.setID(id);
    this.setData(data);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    final ModelElement cloneElement =
        new ModelElement(this.getSets(), this.getID(), this.getData()) {};
    cloneElement.setAttributes(this.attributes);
    return cloneElement;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ModelElement)) {
      return false;
    }
    return ((ModelElement) obj).getID().equals(this.getID());
  }

  @Override
  public Object getAttribute(final String key) {
    return this.attributes.get(key);
  }

  @Override
  public HashMap<String, Object> getAttributes() {
    return this.attributes;
  }

  public Serializable getData() {
    return (Serializable) this.getAttribute(ModelElement.DATA);
  }

  public String getID() {
    return (String) this.getAttribute(ModelElement.IDENTIFIER);
  }

  public String getLabel() {
    return (String) this.getAttribute(ModelElement.LABEL);
  }

  @SuppressWarnings("unchecked")
  public List<String> getSets() {
    return (List<String>) this.getAttribute(ModelElement.SETS);
  }

  @Override
  public int hashCode() {
    return this.getID().hashCode();
  }

  @Override
  public void setAttribute(final String key, final Object value) {
    if (key.equals(ModelElement.IDENTIFIER) || key.equals(ModelElement.SETS)
        || key.equals(ModelElement.DATA)) {
      return;
    }
    this.attributes.put(key, value);
  }

  @Override
  public void setAttributes(final HashMap<String, Object> newAttributes) {
    for (final Entry<String, Object> entry : newAttributes.entrySet()) {
      this.setAttribute(entry.getKey(), entry.getValue());
    }
  }

  protected void setData(final Serializable data) {
    this.attributes.put(ModelElement.DATA, data);
  }

  protected void setID(final String id) {
    this.attributes.put(ModelElement.IDENTIFIER, id);
  }

  protected void setLabel(final String label) {
    this.attributes.put(ModelElement.LABEL, label);
  }

  protected void setSets(final List<String> sets) {
    this.attributes.put(ModelElement.SETS, sets);
  }

  public String setToString() {
    return String.join(",", this.getSets());
  }
}
