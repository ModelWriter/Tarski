package eu.modelwriter.visualization.editor.wizard;

import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class TypeListModel implements ListModel<Object> {

  private final List<Object> types;

  public TypeListModel(final List<Object> list) {
    this.types = list;
  }

  @Override
  public void addListDataListener(final ListDataListener l) {

  }

  @Override
  public Object getElementAt(final int index) {
    return this.types.get(index);
  }

  @Override
  public int getSize() {
    return this.types.size();
  }

  @Override
  public void removeListDataListener(final ListDataListener l) {

  }
}
