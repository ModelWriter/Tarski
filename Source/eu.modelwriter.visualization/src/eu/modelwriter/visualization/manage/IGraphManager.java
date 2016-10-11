package eu.modelwriter.visualization.manage;

public interface IGraphManager {
  Object createVertex(Object data);

  Object createEdge(Object data);

  Object removeVertex(Object data);

  Object removeEdge(Object data);
}
