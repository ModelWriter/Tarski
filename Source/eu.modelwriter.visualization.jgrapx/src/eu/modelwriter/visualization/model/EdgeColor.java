package eu.modelwriter.visualization.model;

import java.awt.Color;
import java.util.Random;

public enum EdgeColor {
  BLACK(false, Color.BLACK), PALEVIOLETRED(false, new Color(222, 113, 148)), RED(false,
      Color.RED), SALMON(false, new Color(255, 130, 115)), MAGENTA(false, Color.MAGENTA), LIMEGREEN(
          false, new Color(49, 207, 49)), GREEN2(false, new Color(0, 239, 0)), DARKOLIVEGREEN2(
              false, new Color(189, 239, 107)), CHARTREUSE2(false, new Color(115, 239, 0)), GOLD(
                  false, new Color(255, 215, 0)), YELLOW(false, Color.YELLOW), LIGHTGOLDENROD(false,
                      new Color(239, 223, 132)), CORNFLOWERBLUE(false,
                          new Color(99, 150, 239)), BLUE(false, Color.BLUE), CADETBLUE(false,
                              new Color(90, 158, 165)), CYAN(false, Color.CYAN);

  public static void clear() {
    for (final EdgeColor color : EdgeColor.values()) {
      color.isUsed = false;
    }
  }

  public static EdgeColor get(final Color color) {
    for (final EdgeColor edgeColor : EdgeColor.values()) {
      if (edgeColor.getColor().equals(color)) {
        return edgeColor;
      }
    }
    return BLACK;
  }

  public static Color randomUniqueColor() {
    final Random rand = new Random();
    EdgeColor value;

    do {
      final int nextInt = rand.nextInt(EdgeColor.values().length);
      value = EdgeColor.values()[nextInt];
    } while (value.isUsed);

    value.isUsed = true;
    return value.getColor();
  }

  public boolean isUsed;

  public Color color;

  EdgeColor(final boolean isUsed, final Color color) {
    this.isUsed = isUsed;
    this.color = color;
  }

  public Color getColor() {
    return this.color;
  }
}
