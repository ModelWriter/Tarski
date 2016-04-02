package eu.modelwriter.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

public class ModelElement implements IModelElement {
  private final static String IDENTIFIER = "ID";
  private final static String DATA = "DATA";
  private final static String SET = "SET";
  private final HashMap<String, Object> attributes = new HashMap<>();

  public ModelElement() {}

  public ModelElement(final String set, final String id, final Serializable data) {
    this.setSet(set);
    this.setID(id);
    this.setData(data);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    final ModelElement cloneElement =
        new ModelElement(this.getSet(), this.getID(), this.getData()) {};
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

  public String getSet() {
    return (String) this.getAttribute(ModelElement.SET);
  }

  @Override
  public int hashCode() {
    return this.getID().hashCode();
  }

  @Override
  public void setAttribute(final String key, final Object value) {
    if (key.equals(ModelElement.IDENTIFIER) || key.equals(ModelElement.SET)
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

  protected void setSet(final String set) {
    this.attributes.put(ModelElement.SET, set);
  }
}
