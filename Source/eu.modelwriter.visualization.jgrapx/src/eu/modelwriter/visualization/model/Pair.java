package eu.modelwriter.visualization.model;

import com.mxgraph.model.mxCell;

public class Pair {

  private mxCell edge;

  private int order;

  public Pair(final mxCell edge, final int order) {
    this.edge = edge;
    this.order = order;
  }

  public mxCell getEdge() {
    return this.edge;
  }

  public int getOrder() {
    return this.order;
  }

  public void setEdge(final mxCell edge) {
    this.edge = edge;
  }

  public void setOrder(final int order) {
    this.order = order;
  }
}
