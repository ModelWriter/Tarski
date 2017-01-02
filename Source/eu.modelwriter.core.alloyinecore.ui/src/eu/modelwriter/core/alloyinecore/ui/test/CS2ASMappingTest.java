package eu.modelwriter.core.alloyinecore.ui.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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
  public void translatorTest() throws NullPointerException, IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/Test.txt"), "test/TestTemp.ecore");
    final EObject generated = loadResource("test/TestTemp.ecore");
    final EObject expected = loadResource("test/Test.ecore");

    Assert.assertTrue("Test.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void packageTranslate() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/PackageTest.txt"), "test/PackageTestTemp.ecore");
    final EObject generated = loadResource("test/PackageTestTemp.ecore");
    final EObject expected = loadResource("test/PackageTest.ecore");

    Assert.assertTrue(
        "PackageTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
        EcoreUtil.equals(generated, expected));
  }

  @Test
  public void classifierTranslate() throws IOException {
    final long millis = System.currentTimeMillis();

    mapper.parseAndSave(getString("test/ClassifierTest.txt"), "test/ClassifierTestTemp.ecore");
    final EObject generated = loadResource("test/ClassifierTestTemp.ecore");
    final EObject expected = loadResource("test/ClassifierTest.ecore");

    Assert.assertTrue(
        "ClassifierTest.ecore is not OK: " + (System.currentTimeMillis() - millis) + "ms.",
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
