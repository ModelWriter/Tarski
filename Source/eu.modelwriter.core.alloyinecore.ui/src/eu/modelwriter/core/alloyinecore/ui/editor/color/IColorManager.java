package eu.modelwriter.core.alloyinecore.ui.editor.color;

import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.swt.graphics.Color;


public interface IColorManager extends ISharedTextColors {

	/**
   * Returns a color object for the given key. The color objects are remembered internally; the same
   * color object is returned for equal keys.
   *
   * @param key the color key
   * @return the color object for the given key
   */
  Color getColor(String key);
}
