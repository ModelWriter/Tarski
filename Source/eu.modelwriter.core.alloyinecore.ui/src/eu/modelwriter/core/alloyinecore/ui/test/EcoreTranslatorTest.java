package eu.modelwriter.core.alloyinecore.ui.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.junit.Before;
import org.junit.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.ui.model.EcoreTranslator;

public class EcoreTranslatorTest {

  private EPackage testRoot = null;
  private STGroup group;
  private EPackage testRoot2;

  @Before
  public void before() {
    try {
      group = new STGroupFile("stringtemplate/AlloyInEcore.stg");
      URI fileURI2 = URI.createFileURI("mappingTest/tutorialExtended.ecore");
      URI fileURI = URI.createFileURI("src/eu/modelwriter/core/alloyinecore/ui/test/Test.ecore");
      testRoot2 = (EPackage) EcoreUtilities.getRootObject(fileURI2);
      testRoot = (EPackage) EcoreUtilities.getRootObject(fileURI);
      assertNotNull(testRoot);
    } catch (IOException e) {
      e.printStackTrace();
      fail();
    }
  }

  @Test
  public void translatorTest2() {
    long millis = System.currentTimeMillis();
    String string = EcoreTranslator.translate(testRoot2);
    System.out.println("2-Time ellapsed: " + (System.currentTimeMillis() - millis));
    System.out.println(string);
  }

  @Test
  public void translatorTest() {
    long millis = System.currentTimeMillis();
    String string = EcoreTranslator.translate(testRoot);
    System.out.println("Time ellapsed: " + (System.currentTimeMillis() - millis));
    System.out.println(string);
  }

  @Test
  public void templateClassTest() {
    String result = classTemplate();
    System.out.println("---- templateClassTest");
    System.out.println(result);
  }

  private String classTemplate() {
    ST st = group.getInstanceOf("class");
    st.add("visibility", "public");
    st.add("name", "Library");
    st.add("isAbstract", "abstract");
    st.add("instanceName", "Lib");
    st.add("superClass", "SuperLib");
    st.add("superClass", "SuperLib2");
    st.add("isInterface", false);
    String result = st.render().replaceAll("  ", " ");
    return result;
  }

  @Test
  public void templatePackageTest() {
    String result = packageTemplate();
    System.out.println("---- templatePackageTest");
    System.out.println(result);
  }

  private String packageTemplate() {
    ST st = group.getInstanceOf("package");
    st.add("visibility", "public");
    st.add("name", "Package1");
    st.add("prefix", "p1");
    st.add("namespace", "modelwriter");
    st.add("subElement", classTemplate());
    String result = st.render().replaceAll("  ", " ");
    return result;
  }
}
