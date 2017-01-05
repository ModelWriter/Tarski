package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.ui.cs2as.AIEConstants;

public class ClassifierInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final ClassifierInitializer instance = new ClassifierInitializer();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  @Override
  public EPackage visitEPackage(final EPackageContext ctx) {
    final String name = ctx.name.getText();
    ClassifierInitializer.qualifiedNameStack.push(name);
    final String qualifiedName =
        String.join(AIEConstants.SEPARATOR_PACKAGE, ClassifierInitializer.qualifiedNameStack);
    final EPackage ePackage = CS2ASRepository.qname2ePackage.get(qualifiedName);

    ctx.eSubPackages.forEach(sp -> {
      visitEPackage(sp);
    });

    ctx.eClassifiers.forEach(c -> {
      final EClassifier classifier = visitEClassifier(c);
      ePackage.getEClassifiers().add(classifier);
    });

    ClassifierInitializer.qualifiedNameStack.pop();
    return ePackage;
  }

  @Override
  public EClassifier visitEClassifier(final EClassifierContext ctx) {
    return (EClassifier) super.visitEClassifier(ctx);
  }

  @Override
  public EClass visitEClass(final EClassContext ctx) {
    final EClass eClass = CS2ASRepository.factory.createEClass();

    final String name = ctx.name.getText();
    eClass.setName(name);

    ClassifierInitializer.qualifiedNameStack.push(name);
    final String qualifiedName =
        String.join(AIEConstants.SEPARATOR_CLASSIFIER, ClassifierInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eClass.put(qualifiedName, eClass);

    ClassifierInitializer.qualifiedNameStack.pop();

    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEClass and need to has a (complex) qualified name

    return eClass;
  }

  @Override
  public EDataType visitEDataType(final EDataTypeContext ctx) {
    final EDataType eDataType = CS2ASRepository.factory.createEDataType();

    final String name = ctx.name.getText();
    eDataType.setName(name);

    ClassifierInitializer.qualifiedNameStack.push(name);
    final String qualifiedName =
        String.join(AIEConstants.SEPARATOR_CLASSIFIER, ClassifierInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eDataType.put(qualifiedName, eDataType);

    ClassifierInitializer.qualifiedNameStack.pop();

    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEDataType and need to has a (complex) qualified name

    return eDataType;
  }

  @Override
  public EEnum visitEEnum(final EEnumContext ctx) {
    final EEnum eEnum = CS2ASRepository.factory.createEEnum();

    final String name = ctx.name.getText();
    eEnum.setName(name);

    ClassifierInitializer.qualifiedNameStack.push(name);
    final String qualifiedName =
        String.join(AIEConstants.SEPARATOR_CLASSIFIER, ClassifierInitializer.qualifiedNameStack);
    CS2ASRepository.qname2eEnum.put(qualifiedName, eEnum);

    ClassifierInitializer.qualifiedNameStack.pop();

    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEEnum and need to has a (complex) qualified name

    return eEnum;
  }

  public void clear() {
    ClassifierInitializer.qualifiedNameStack.clear();
  }
}
