package eu.modelwriter.core.alloyinecore.ui.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.ui.cs2as.mapping.CS2ASMapping;

public class CS2ASMappingTest {

  private CS2ASMapping mapper;

  @Before
  public void before() {
    mapper = CS2ASMapping.getInstance();
  }

  @Test
  public void annotationTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/AnnotationTest.txt"),
        URI.createFileURI("test/AnnotationTestTemp.ecore"));
    final EObject generated = loadResource("test/AnnotationTestTemp.ecore");
    final EObject expected = loadResource("test/AnnotationTest.ecore");

    Assert.assertTrue(
        "AnnotationTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void attributeTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/AttrTest.txt"),
        URI.createFileURI("test/AttrTestTemp.ecore"));
    final EObject generated = loadResource("test/AttrTestTemp.ecore");
    final EObject expected = loadResource("test/AttrTest.ecore");

    Assert.assertTrue("AttrTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void classifierTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/ClassifierTest.txt"),
        URI.createFileURI("test/ClassifierTestTemp.ecore"));
    final EObject generated = loadResource("test/ClassifierTestTemp.ecore");
    final EObject expected = loadResource("test/ClassifierTest.ecore");

    Assert.assertTrue(
        "ClassifierTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void operationTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/OperationTest.txt"),
        URI.createFileURI("test/OperationTestTemp.ecore"));
    final EObject generated = loadResource("test/OperationTestTemp.ecore");
    final EObject expected = loadResource("test/OperationTest.ecore");

    Assert.assertTrue(
        "OperationTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void packageTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/PackageTest.txt"),
        URI.createFileURI("test/PackageTestTemp.ecore"));
    final EObject generated = loadResource("test/PackageTestTemp.ecore");
    final EObject expected = loadResource("test/PackageTest.ecore");

    Assert.assertTrue(
        "PackageTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void referenceTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/ReferenceTest.txt"),
        URI.createFileURI("test/ReferenceTestTemp.ecore"));
    final EObject generated = loadResource("test/ReferenceTestTemp.ecore");
    final EObject expected = loadResource("test/ReferenceTest.ecore");

    Assert.assertTrue(
        "ReferenceTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void testTest() throws NullPointerException, IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/Test.txt"), URI.createFileURI("test/TestTemp.ecore"));
    final EObject generated = loadResource("test/TestTemp.ecore");
    final EObject expected = loadResource("test/Test.ecore");

    Assert.assertTrue("Test.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void genericsTest() throws NullPointerException, IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/GenericsTest.recore"),
        URI.createFileURI("test/GenericsTestTemp.ecore"));
    final EObject generated = loadResource("test/GenericsTestTemp.ecore");
    final EObject expected = loadResource("test/GenericsTest.ecore");

    Assert.assertTrue("Test.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }


  private String getString(final String fileName) throws IOException {
    return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
  }

  /**
   * @param path
   * @return
   *
   */
  private EObject loadResource(final String path) {
    try {
      final EObject root = EcoreUtilities.getRootObject(path);
      return root;
    } catch (final IOException e) {
      return null;
    }
  }
}
