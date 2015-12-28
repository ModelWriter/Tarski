package eu.modelwriter.visualization.test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TestObject implements Serializable {

  String name;

  public TestObject(String name) {
    this.name = name;
  }

}
