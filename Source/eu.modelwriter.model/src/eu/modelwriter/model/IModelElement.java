package eu.modelwriter.model;

import java.util.HashMap;

public interface IModelElement {
  public Object getAttribute(final String key);

  public HashMap<String, Object> getAttributes();

  public void setAttribute(final String key, final Object value);

  public void setAttributes(final HashMap<String, Object> newAttributes);
}
