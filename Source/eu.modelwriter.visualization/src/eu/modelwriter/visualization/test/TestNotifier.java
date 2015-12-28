package eu.modelwriter.visualization.test;

import java.io.Serializable;

import eu.modelwriter.visualization.Notifier;

public class TestNotifier implements Notifier {

  @Override
  public void notify(Serializable data) {
    TestObject testObject = (TestObject) data;

    System.out.println(testObject.name);
  }

}
