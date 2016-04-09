package eu.modelwriter.visualization.model;

import java.awt.Color;
import java.util.Random;

/**
 * It is used for generate unique color.
 */
public enum UniqueColor {
  BLACK(false, Color.BLACK), PALEVIOLETRED(false, new Color(222, 113, 148)), RED(false,
      Color.RED), SALMON(false, new Color(255, 130, 115)), MAGENTA(false, Color.MAGENTA), LIMEGREEN(
          false, new Color(49, 207, 49)), GREEN2(false, new Color(0, 239, 0)), DARKOLIVEGREEN2(
              false, new Color(189, 239, 107)), CHARTREUSE2(false, new Color(115, 239, 0)), GOLD(
                  false, new Color(255, 215, 0)), YELLOW(false, Color.YELLOW), LIGHTGOLDENROD(false,
                      new Color(239, 223, 132)), CORNFLOWERBLUE(false,
                          new Color(99, 150, 239)), BLUE(false, Color.BLUE), CADETBLUE(false,
                              new Color(90, 158, 165)), CYAN(false, Color.CYAN);

  /**
   * Sets all UniqueColors as not used.
   */
  public static void clear() {
    for (final UniqueColor color : UniqueColor.values()) {
      color.isUsed = false;
    }
  }

  /**
   * @param color
   * @return the referred UniqueColor
   */
  public static UniqueColor get(final Color color) {
    for (final UniqueColor UniqueColor : UniqueColor.values()) {
      if (UniqueColor.getColor().equals(color)) {
        return UniqueColor;
      }
    }
    return BLACK;
  }

  /**
   * finds random and non-used UniqueColor
   *
   * @return random unique {@linkplain Color}
   */
  public static Color randomColor() {
    final Random rand = new Random();
    UniqueColor value;

    do {
      final int nextInt = rand.nextInt(UniqueColor.values().length);
      value = UniqueColor.values()[nextInt];
    } while (value.isUsed);

    value.isUsed = true;
    return value.getColor();
  }

  private boolean isUsed;

  private Color color;

  UniqueColor(final boolean isUsed, final Color color) {
    this.isUsed = isUsed;
    this.color = color;
  }

  /**
   * @return the referred {@linkplain Color}
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Sets the color as it is used or not.
   *
   * @param isUsed
   */
  public void setUsed(final boolean isUsed) {
    this.isUsed = isUsed;
  }
}
