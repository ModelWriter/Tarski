package eu.modelwriter.core.alloyinecore.ui.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    String string =
        translator.translate("src/eu/modelwriter/core/alloyinecore/ui/test/ecores/Test.ecore");
    System.out.println("Time ellapsed: " + (System.currentTimeMillis() - millis));
    System.out.println(string);
  }

  @Test
  public void packageTranslate() throws IOException {
    String actual = translator
        .translate("src/eu/modelwriter/core/alloyinecore/ui/test/ecores/PackageTest.ecore");
    String expected =
        getString("src/eu/modelwriter/core/alloyinecore/ui/test/ecores/PackageTest.txt");
    assertEquals(expected, actual);
  }

  private String getString(String fileName) throws IOException {
    return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
  }
}
