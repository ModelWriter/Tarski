package eu.modelwriter.traceability.validation.editor.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class ColorManager {

  @SuppressWarnings("rawtypes")
  protected Map fColorTable = new HashMap(10);

  public void dispose() {
    @SuppressWarnings("rawtypes")
    final Iterator e = this.fColorTable.values().iterator();
    while (e.hasNext()) {
      ((Color) e.next()).dispose();
    }
  }

  @SuppressWarnings("unchecked")
  public Color getColor(final RGB rgb) {
    Color color = (Color) this.fColorTable.get(rgb);
    if (color == null) {
      color = new Color(Display.getCurrent(), rgb);
      this.fColorTable.put(rgb, color);
    }
    return color;
  }
}
