package eu.modelwriter.core.alloyinecore.ui.mapping.test;

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

import eu.modelwriter.core.alloyinecore.ui.mapping.cs2as.CS2ASMapping;
import eu.modelwriter.core.alloyinecore.ui.mapping.cs2as.CS2ASRepository;

public class CS2ASMappingTest {

  private CS2ASMapping mapper;
  private CS2ASRepository repository;

  @Before
  public void before() {
    mapper = new CS2ASMapping();
    repository = new CS2ASRepository();
  }

  @Test
  public void annotationTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/AnnotationTest.recore"),
        URI.createFileURI("testTemp/AnnotationTestTemp.ecore"));
    final EObject generated = loadResource("testTemp/AnnotationTestTemp.ecore");
    final EObject expected = loadResource("test/AnnotationTest.ecore");

    Assert.assertTrue(
        "AnnotationTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void attributeTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/AttrTest.recore"),
        URI.createFileURI("testTemp/AttrTestTemp.ecore"));
    final EObject generated = loadResource("testTemp/AttrTestTemp.ecore");
    final EObject expected = loadResource("test/AttrTest.ecore");

    Assert.assertTrue("AttrTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void classifierTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/ClassifierTest.recore"),
        URI.createFileURI("testTemp/ClassifierTestTemp.ecore"));
    final EObject generated = loadResource("testTemp/ClassifierTestTemp.ecore");
    final EObject expected = loadResource("test/ClassifierTest.ecore");

    Assert.assertTrue(
        "ClassifierTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void operationTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/OperationTest.recore"),
        URI.createFileURI("testTemp/OperationTestTemp.ecore"));
    final EObject generated = loadResource("testTemp/OperationTestTemp.ecore");
    final EObject expected = loadResource("test/OperationTest.ecore");

    Assert.assertTrue(
        "OperationTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void packageTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/PackageTest.recore"),
        URI.createFileURI("testTemp/PackageTestTemp.ecore"));
    final EObject generated = loadResource("testTemp/PackageTestTemp.ecore");
    final EObject expected = loadResource("test/PackageTest.ecore");

    Assert.assertTrue(
        "PackageTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void referenceTest() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/ReferenceTest.recore"),
        URI.createFileURI("testTemp/ReferenceTestTemp.ecore"));
    final EObject generated = loadResource("testTemp/ReferenceTestTemp.ecore");
    final EObject expected = loadResource("test/ReferenceTest.ecore");

    Assert.assertTrue(
        "ReferenceTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void testTest() throws NullPointerException, IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/Test.recore"),
        URI.createFileURI("testTemp/TestTemp.ecore"));
    final EObject generated = loadResource("testTemp/TestTemp.ecore");
    final EObject expected = loadResource("test/Test.ecore");

    Assert.assertTrue("Test.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void genericsTest() throws NullPointerException, IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/GenericsTest.recore"),
        URI.createFileURI("testTemp/GenericsTestTemp.ecore"));
    final EObject generated = loadResource("testTemp/GenericsTestTemp.ecore");
    final EObject expected = loadResource("test/GenericsTest.ecore");

    Assert.assertTrue("Test.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void ecoreTest() throws NullPointerException, IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/Ecore.recore"),
        URI.createFileURI("testTemp/EcoreTemp.ecore"));
    final EObject generated = loadResource("testTemp/EcoreTemp.ecore");
    final EObject expected = loadResource("test/Ecore.ecore");

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
    return repository.loadResource(path).getContents().get(0);
  }
}
