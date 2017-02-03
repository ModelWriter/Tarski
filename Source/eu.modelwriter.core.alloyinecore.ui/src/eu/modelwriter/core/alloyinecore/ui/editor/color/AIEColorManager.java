package eu.modelwriter.core.alloyinecore.ui.editor.color;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class AIEColorManager implements IColorManager, IColorManagerExtension {

  protected Map<String, RGB> fKeyTable = new HashMap<>(10);
  protected Map<Display, Map<RGB, Color>> fDisplayTable = new HashMap<>(2);

  /**
   * Flag which tells if the colors are automatically disposed when the current display gets
   * disposed.
   */
  private final boolean fAutoDisposeOnDisplayDispose;


  /**
   * Creates a new AlloyInEcore color manager which automatically disposes the allocated colors when
   * the current display gets disposed.
   */
  public AIEColorManager() {
    this(true);
    // TODO bind color truly later.
    bindColor(IAIEColorConstants.AIE_MULTI_LINE_COMMENT, new RGB(0, 128, 0));
    bindColor(IAIEColorConstants.AIE_SINGLE_LINE_COMMENT, new RGB(0, 128, 0));
    bindColor(IAIEColorConstants.AIE_STRING, new RGB(0, 0, 128));
    bindColor(IAIEColorConstants.KEYWORD, new RGB(128, 0, 0));
    bindColor(IAIEColorConstants.AIE_DEFAULT, new RGB(0, 0, 0));
    bindColor(IAIEColorConstants.AIE_KEYWORD, new RGB(0, 90, 255));
  }

  /**
   * Creates a new AlloyInEcore color manager.
   *
   * @param autoDisposeOnDisplayDispose if <code>true</code> the color manager automatically
   *        disposes all managed colors when the current display gets disposed and all calls to
   *        {@link org.eclipse.jface.text.source.ISharedTextColors#dispose()} are ignored.
   */
  public AIEColorManager(final boolean autoDisposeOnDisplayDispose) {
    fAutoDisposeOnDisplayDispose = autoDisposeOnDisplayDispose;
  }

  public void dispose(final Display display) {
    final Map<RGB, Color> colorTable = fDisplayTable.get(display);
    if (colorTable != null) {
      final Iterator<Color> e = colorTable.values().iterator();
      while (e.hasNext()) {
        final Color color = e.next();
        if (color != null && !color.isDisposed()) {
          color.dispose();
        }
      }
    }
  }

  /*
   * @see IColorManager#getColor(RGB)
   */
  @Override
  public Color getColor(final RGB rgb) {

    if (rgb == null) {
      return null;
    }

    final Display display = Display.getCurrent();
    Map<RGB, Color> colorTable = fDisplayTable.get(display);
    if (colorTable == null) {
      colorTable = new HashMap<>(10);
      fDisplayTable.put(display, colorTable);
      if (fAutoDisposeOnDisplayDispose) {
        display.disposeExec(new Runnable() {
          @Override
          public void run() {
            dispose(display);
          }
        });
      }
    }

    Color color = colorTable.get(rgb);
    if (color == null) {
      color = new Color(Display.getCurrent(), rgb);
      colorTable.put(rgb, color);
    }

    return color;
  }

  /*
   * @see IColorManager#dispose
   */
  @Override
  public void dispose() {
    if (!fAutoDisposeOnDisplayDispose) {
      dispose(Display.getCurrent());
    }
  }

  /*
   * @see IColorManager#getColor(String)
   */
  @Override
  public Color getColor(final String key) {

    if (key == null) {
      return null;
    }

    final RGB rgb = fKeyTable.get(key);
    return getColor(rgb);
  }

  /*
   * @see IColorManagerExtension#bindColor(String, RGB)
   */
  @Override
  public void bindColor(final String key, final RGB rgb) {
    final Object value = fKeyTable.get(key);
    if (value != null) {
      throw new UnsupportedOperationException();
    }

    fKeyTable.put(key, rgb);
  }

  /*
   * @see IColorManagerExtension#unbindColor(String)
   */
  @Override
  public void unbindColor(final String key) {
    fKeyTable.remove(key);
  }
}
