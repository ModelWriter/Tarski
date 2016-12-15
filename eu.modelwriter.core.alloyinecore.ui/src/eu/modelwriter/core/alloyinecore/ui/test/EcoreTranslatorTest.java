package eu.modelwriter.core.alloyinecore.ui.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.junit.Before;
import org.junit.Test;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.ui.model.EcoreTranslator;

public class EcoreTranslatorTest {

  EPackage testRoot = null;

  @Before
  public void before() {
    try {
      URI fileURI = URI.createFileURI("src/eu/modelwriter/core/alloyinecore/ui/test/Test.ecore");
      testRoot = (EPackage) EcoreUtilities.getRootObject(fileURI);
      assertNotNull(testRoot);
    } catch (IOException e) {
      e.printStackTrace();
      fail();
    }
  }

  @Test
  public void translatorTest() {
    System.out.println(EcoreTranslator.translate(testRoot));
  }
}
