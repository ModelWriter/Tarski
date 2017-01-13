package eu.modelwriter.core.alloyinecore.ui.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import eu.modelwriter.configuration.internal.Utilities;
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
    String actual = translator.translate("test/Test.ecore");
    writeString("testTemp/TestTemp.recore", actual);
    String expected = getString("test/Test.recore");
    assertEquals(Utilities.removeAllWhiteSpaces(expected), Utilities.removeAllWhiteSpaces(actual));
    System.out.println("Time ellapsed: " + (System.currentTimeMillis() - millis));
    System.out.println(actual);
  }

  @Test
  public void packageTranslate() throws IOException {
    String actual = translator.translate("test/PackageTest.ecore");
    writeString("testTemp/PackageTestTemp.recore", actual);
    String expected = getString("test/PackageTest.recore");
    assertEquals(Utilities.removeAllWhiteSpaces(expected), Utilities.removeAllWhiteSpaces(actual));
  }

  @Test
  public void classifierTranslate() throws IOException {
    String actual = translator.translate("test/ClassifierTest.ecore");
    writeString("testTemp/ClassifierTestTemp.recore", actual);
    String expected = getString("test/ClassifierTest.recore");
    assertEquals(Utilities.removeAllWhiteSpaces(expected), Utilities.removeAllWhiteSpaces(actual));
  }

  @Test
  public void attributeTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/AttrTest.ecore");
    writeString("testTemp/AttrTestTemp.recore", actual);
    String expected = getString("test/AttrTest.recore");
    assertEquals(Utilities.removeAllWhiteSpaces(expected), Utilities.removeAllWhiteSpaces(actual));
  }

  @Test
  public void referenceTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/ReferenceTest.ecore");
    writeString("testTemp/ReferenceTestTemp.recore", actual);
    String expected = getString("test/ReferenceTest.recore");
    assertEquals(Utilities.removeAllWhiteSpaces(expected), Utilities.removeAllWhiteSpaces(actual));
  }

  @Test
  public void operationTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/OperationTest.ecore");
    writeString("testTemp/OperationTestTemp.recore", actual);
    String expected = getString("test/OperationTest.recore");
    assertEquals(Utilities.removeAllWhiteSpaces(expected), Utilities.removeAllWhiteSpaces(actual));
  }

  @Test
  public void annotationTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/AnnotationTest.ecore");
    writeString("testTemp/AnnotationTestTemp.recore", actual);
    String expected = getString("test/AnnotationTest.recore");
    assertEquals(Utilities.removeAllWhiteSpaces(expected), Utilities.removeAllWhiteSpaces(actual));
  }

  @Test
  public void genericsTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/GenericsTest.ecore");
    writeString("testTemp/GenericsTestTemp.recore", actual);
    String expected = getString("test/GenericsTest.recore");
    assertEquals(Utilities.removeAllWhiteSpaces(expected), Utilities.removeAllWhiteSpaces(actual));
  }

  @Test
  public void ecoreTranslate() throws IOException {
    // TODO cover all cases
    String actual = translator.translate("test/Ecore.ecore");
    writeString("testTemp/EcoreTemp.recore", actual);
    String expected = getString("test/Ecore.recore");
    assertEquals(Utilities.removeAllWhiteSpaces(expected), Utilities.removeAllWhiteSpaces(actual));
  }

  private String getString(String fileName) throws IOException {
    return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
  }
  
  private void writeString(String fileName, String content) {
    Utilities.writeToFile(fileName, new StringBuilder(content));
  }
}
