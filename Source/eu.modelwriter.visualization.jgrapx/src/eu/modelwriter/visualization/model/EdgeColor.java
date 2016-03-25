package eu.modelwriter.visualization.model;

import java.awt.Color;
import java.util.Random;

public enum EdgeColor {
  INSTANCE(true), PALEVIOLETRED(false), RED(false), SALMON(false), MAGENTA(false), LIMEGREEN(
      false), GREEN2(false), DARKOLIVEGREEN2(false), CHARTREUSE2(false), GOLD(
          false), YELLOW(false), LIGHTGOLDENROD(
              false), CORNFLOWERBLUE(false), BLUE(false), CADETBLUE(false), CYAN(false);

  private boolean isUsed;

  EdgeColor(final boolean isUsed) {
    this.setUsed(isUsed);
  }

  public void clear() {
    for (final EdgeColor color : EdgeColor.values()) {
      color.setUsed(false);
    }
  }

  public Color getColor() {
    Color ans = null;
    if (this.equals(PALEVIOLETRED)) {
      ans = new Color(222, 113, 148);
    } else if (this.equals(RED)) {
      ans = new Color(255, 0, 0);
    } else if (this.equals(SALMON)) {
      ans = new Color(255, 130, 115);
    } else if (this.equals(MAGENTA)) {
      ans = new Color(255, 0, 255);
    } else if (this.equals(LIMEGREEN)) {
      ans = new Color(49, 207, 49);
    } else if (this.equals(GREEN2)) {
      ans = new Color(0, 239, 0);
    } else if (this.equals(DARKOLIVEGREEN2)) {
      ans = new Color(189, 239, 107);
    } else if (this.equals(CHARTREUSE2)) {
      ans = new Color(115, 239, 0);
    } else if (this.equals(GOLD)) {
      ans = new Color(255, 215, 0);
    } else if (this.equals(YELLOW)) {
      ans = new Color(255, 255, 0);
    } else if (this.equals(LIGHTGOLDENROD)) {
      ans = new Color(239, 223, 132);
    } else if (this.equals(CORNFLOWERBLUE)) {
      ans = new Color(99, 150, 239);
    } else if (this.equals(BLUE)) {
      ans = new Color(0, 0, 255);
    } else if (this.equals(CADETBLUE)) {
      ans = new Color(90, 158, 165);
    } else if (this.equals(CYAN)) {
      ans = new Color(0, 255, 255);
    } else {
      ans = Color.BLACK;
    }
    return ans;
  }

  public Color randomUniqueColor() {
    final Random rand = new Random();
    EdgeColor value;

    do {
      final int nextInt = rand.nextInt(EdgeColor.values().length);
      value = EdgeColor.values()[nextInt];
    } while (value.isUsed);

    value.setUsed(true);
    return value.getColor();
  }

  private void setUsed(final boolean isUsed) {
    this.isUsed = isUsed;
  }
}
