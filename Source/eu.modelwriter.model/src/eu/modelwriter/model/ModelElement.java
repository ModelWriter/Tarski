package eu.modelwriter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ModelElement implements IModelElement {
  public static enum BOUND {
    LOWER_BOUND, UPPER_BOUND, EXACT_BOUND
  }

  private final static String RELATION_SETS = "RELATION_SETS";
  private final static String IDENTIFIER = "ID";
  private final static String LABEL = "LABEL";
  private final static String DATA = "DATA";
  private final static String BOUND = "BOUND";

  private final HashMap<String, Object> attributes = new HashMap<>();

  public ModelElement() {}

  protected ModelElement(final List<RelationSet> relationSets, final String id,
      final Serializable data, final BOUND bound) {
    this.setRelationSets(relationSets);
    this.setID(id);
    this.setData(data);
    this.setBound(bound);
  }

  @Override
  protected Object clone() {
    final ModelElement cloneElement =
        new ModelElement(this.getRelationSets(), this.getID(), this.getData(), this.getBound()) {};
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

  public BOUND getBound() {
    return (BOUND) this.getAttribute(ModelElement.BOUND);
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
  public List<RelationSet> getRelationSets() {
    return (List<RelationSet>) this.getAttribute(ModelElement.RELATION_SETS);
  }

  public List<String> getRelationSetsNames() {
    final List<String> relationSetsNames = new ArrayList<String>();
    for (final RelationSet relationSet : this.getRelationSets()) {
      relationSetsNames.add(relationSet.getName());
    }
    return relationSetsNames;
  }

  @Override
  public int hashCode() {
    return this.getID().hashCode();
  }

  public String relationSetsToString() {
    return String.join(", ", this.getRelationSetsNames());
  }

  @Override
  public void setAttribute(final String key, final Object value) {
    if (key.equals(ModelElement.IDENTIFIER) || key.equals(ModelElement.LABEL)
        || key.equals(ModelElement.DATA) || key.equals(ModelElement.BOUND)
        || key.equals(ModelElement.RELATION_SETS)) {
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

  protected void setBound(final BOUND bound) {
    this.attributes.put(ModelElement.BOUND, bound);
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

  protected void setRelationSets(final List<RelationSet> relationSets) {
    this.attributes.put(ModelElement.RELATION_SETS, relationSets);
  }
}
