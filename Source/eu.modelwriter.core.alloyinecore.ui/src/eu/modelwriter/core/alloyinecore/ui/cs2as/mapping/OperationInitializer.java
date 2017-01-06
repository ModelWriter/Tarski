package eu.modelwriter.core.alloyinecore.ui.cs2as.mapping;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;

public class OperationInitializer extends AlloyInEcoreBaseVisitor<Object> {
  public static final OperationInitializer instance = new OperationInitializer();

  private static final Stack<String> qualifiedNameStack = new Stack<>();

  @Override
  public Object visitEPackage(final EPackageContext ctx) {
    final String name = ctx.name.getText();
    OperationInitializer.qualifiedNameStack.push(name);
    super.visitEPackage(ctx);
    OperationInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public Object visitEClass(final EClassContext ctx) {
    final String name = ctx.name.getText();
    OperationInitializer.qualifiedNameStack.push(name);
    final EClass eClass =
        (EClass) CS2ASRepository.getEObject(OperationInitializer.qualifiedNameStack);

    ctx.eOperations.forEach(eo -> {
      final EOperation eOperation = visitEOperation(eo);
      eClass.getEOperations().add(eOperation);
    });
    super.visitEClass(ctx);
    
    OperationInitializer.qualifiedNameStack.pop();
    return null;
  }

  @Override
  public EOperation visitEOperation(final EOperationContext ctx) {
    final EOperation eOperation = CS2ASRepository.factory.createEOperation();

    final String name = ctx.name.getText();
    eOperation.setName(name);

    // TODO if there is any annotation which has OwnedContent (EModelElement), it need to be
    // initialized with super.visitEOperation and need to has a (complex) qualified name

    return eOperation;
  }

  public void clear() {
    OperationInitializer.qualifiedNameStack.clear();
  }
}
