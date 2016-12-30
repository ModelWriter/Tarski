package eu.modelwriter.core.alloyinecore.ui.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import eu.modelwriter.core.alloyinecore.ui.model.EcoreTranslator;

public class EcoreTranslatorTest {

  private EcoreTranslator translator;

  @Before
  public void before() {
    translator = new EcoreTranslator();
  }

  @Test
  public void translatorTest() throws NullPointerException, IOException {
    long millis = System.currentTimeMillis();
    String string = translator.translate("src/eu/modelwriter/core/alloyinecore/ui/test/Test.ecore");
    System.out.println("Time ellapsed: " + (System.currentTimeMillis() - millis));
    System.out.println(string);
  }

  public static void main(String[] args) {
    String asd = "//falan/filan/whoo";
    System.out.println(asd);
    asd = asd.replaceAll("/([^/]*)$", "---" + "$1");
    System.out.println(asd);
  }

}
