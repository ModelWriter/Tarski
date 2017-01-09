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
    String string = translator.translate("test/Test.ecore");
    System.out.println("Time ellapsed: " + (System.currentTimeMillis() - millis));
    System.out.println(string);
  }

  @Test
  public void packageTranslate() throws IOException {
    String actual = translator.translate("test/PackageTest.ecore");
    String expected = getString("test/PackageTest.recore");
    assertEquals(expected, actual);
  }

  @Test
  public void classifierTranslate() throws IOException {
    String actual = translator.translate("test/ClassifierTest.ecore");
    String expected = getString("test/ClassifierTest.recore");
    assertEquals(expected, actual);
  }

  @Test
  public void attributeTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/AttrTest.ecore");
    String expected = getString("test/AttrTest.recore");
    assertEquals(expected, actual);
  }

  @Test
  public void referenceTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/ReferenceTest.ecore");
    String expected = getString("test/ReferenceTest.recore");
    assertEquals(expected, actual);
  }

  @Test
  public void operationTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/OperationTest.ecore");
    String expected = getString("test/OperationTest.recore");
    assertEquals(expected, actual);
  }

  @Test
  public void annotationTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/AnnotationTest.ecore");
    String expected = getString("test/AnnotationTest.recore");
    assertEquals(expected, actual);
  }

  private String getString(String fileName) throws IOException {
    return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
  }
}
