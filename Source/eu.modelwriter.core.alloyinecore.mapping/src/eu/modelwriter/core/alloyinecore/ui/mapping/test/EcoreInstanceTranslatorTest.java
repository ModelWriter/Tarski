package eu.modelwriter.core.alloyinecore.ui.mapping.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import eu.modelwriter.core.alloyinecore.ui.mapping.as2cs.EcoreInstanceTranslator;

public class EcoreInstanceTranslatorTest {
  private EcoreInstanceTranslator translator;

  @Before
  public void before() {
    translator = new EcoreInstanceTranslator();
  }

  @Test
  public void translatorTest() throws IOException {
    long millis = System.currentTimeMillis();
    // String actual = translator.translate("Model.xmi");
    // String actual = translator.translate("Tutorial.xmi");
    String actual = translator.translate("Instance.requirements");
    System.out.println("Time ellapsed: " + (System.currentTimeMillis() - millis));
    System.out.println(actual);
  }

}
