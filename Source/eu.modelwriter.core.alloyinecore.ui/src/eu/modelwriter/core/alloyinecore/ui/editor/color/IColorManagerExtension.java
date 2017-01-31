package eu.modelwriter.core.alloyinecore.ui.editor.color;

import org.eclipse.swt.graphics.RGB;


/**
 * Extends {@link eu.modelwriter.core.alloyinecore.ui.editor.color.IColorManager} with the ability to bind
 * and un-bind colors.
 */
public interface IColorManagerExtension {

  /**
   * Remembers the given color specification under the given key.
   *
   * @param key the color key
   * @param rgb the color specification
   */
  void bindColor(String key, RGB rgb);


  /**
   * Forgets the color specification remembered under the given key.
   *
   * @param key the color key
   */
  void unbindColor(String key);
}
