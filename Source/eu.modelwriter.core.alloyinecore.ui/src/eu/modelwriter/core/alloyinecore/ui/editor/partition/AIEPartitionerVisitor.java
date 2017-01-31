package eu.modelwriter.core.alloyinecore.ui.editor.partition;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.TypedPosition;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreBaseVisitor;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.BodyContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.DerivationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAttributeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumLiteralContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericExceptionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericSuperTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericWildcardContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementRefContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPrimitiveTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.FormulaContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InitialContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionsContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PostconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PreconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;

public class AIEPartitionerVisitor extends AlloyInEcoreBaseVisitor<Object> {
  private final ParseTree tree;
  private final List<TypedPosition> positions;

  public AIEPartitionerVisitor(final String documentContent) {
    positions = new ArrayList<>();
    final ANTLRInputStream inputStream = new ANTLRInputStream(documentContent);
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(inputStream);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
    tree = parser.module();
  }

  public List<TypedPosition> computePositions() {
    visit(tree);
    return positions;
  }

  private TypedPosition createPosition(final ParserRuleContext ctx, final String type) {
    return new TypedPosition(ctx.start.getStartIndex(),
        ctx.stop.getStopIndex() - ctx.start.getStartIndex(), type);
  }

  @Override
  public Object visitModule(final ModuleContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_MODULE));
    return super.visitModule(ctx);
  }

  @Override
  public Object visitOptions(final OptionsContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_OPTIONS));
    return super.visitOptions(ctx);
  }

  @Override
  public Object visitPackageImport(final PackageImportContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_IMPORT));
    return super.visitPackageImport(ctx);
  }

  @Override
  public Object visitEPackage(final EPackageContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_PACKAGE));
    return super.visitEPackage(ctx);
  }

  @Override
  public Object visitEClass(final EClassContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_CLASS));
    return super.visitEClass(ctx);
  }

  @Override
  public Object visitEAttribute(final EAttributeContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_ATTRIBUTE));
    return super.visitEAttribute(ctx);
  }

  @Override
  public Object visitEReference(final EReferenceContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_REFERENCE));
    return super.visitEReference(ctx);
  }

  @Override
  public Object visitEOperation(final EOperationContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_OPERATION));
    return super.visitEOperation(ctx);
  }

  @Override
  public Object visitEGenericException(final EGenericExceptionContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_EXCEPTION));
    return super.visitEGenericException(ctx);
  }

  @Override
  public Object visitEGenericSuperType(final EGenericSuperTypeContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_SUPERTYPE));
    return super.visitEGenericSuperType(ctx);
  }

  @Override
  public Object visitEParameter(final EParameterContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_PARAMETER));
    return super.visitEParameter(ctx);
  }

  @Override
  public Object visitEDataType(final EDataTypeContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_DATATYPE));
    return super.visitEDataType(ctx);
  }

  @Override
  public Object visitEEnum(final EEnumContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_ENUM));
    return super.visitEEnum(ctx);
  }

  @Override
  public Object visitEEnumLiteral(final EEnumLiteralContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_ENUM_LITERAL));
    return super.visitEEnumLiteral(ctx);
  }

  @Override
  public Object visitEAnnotation(final EAnnotationContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_ANNOTATION));
    return super.visitEAnnotation(ctx);
  }

  @Override
  public Object visitEModelElementRef(final EModelElementRefContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_MODEL_ELEMENT_REF));
    return super.visitEModelElementRef(ctx);
  }

  @Override
  public Object visitTemplateSignature(final TemplateSignatureContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_TEMPLATE_SIGNATURE));
    return super.visitTemplateSignature(ctx);
  }

  @Override
  public Object visitETypeParameter(final ETypeParameterContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_TYPE_PARAMETER));
    return super.visitETypeParameter(ctx);
  }

  @Override
  public Object visitEGenericType(final EGenericTypeContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_GENERIC_TYPE));
    return super.visitEGenericType(ctx);
  }

  @Override
  public Object visitEGenericWildcard(final EGenericWildcardContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_GENERIC_WILD_CARD));
    return super.visitEGenericWildcard(ctx);
  }

  @Override
  public Object visitEPrimitiveType(final EPrimitiveTypeContext ctx) {

    positions.add(createPosition(ctx, IAIEPartitions.AIE_PRIMITIVE_TYPE));
    return super.visitEPrimitiveType(ctx);
  }

  @Override
  public Object visitBody(final BodyContext ctx) {
    positions.add(createPosition(ctx, IAIEPartitions.AIE_BODY));
    if (ctx.ownedExpression != null) {
      visitExpression(ctx.ownedExpression);
    }
    return super.visitBody(ctx);
  }

  @Override
  public Object visitInvariant(final InvariantContext ctx) {
    positions.add(createPosition(ctx, IAIEPartitions.AIE_INVARIANT));
    if (ctx.ownedSpecification != null) {
      visitFormula(ctx.ownedSpecification);
    }
    return super.visitInvariant(ctx);
  }

  @Override
  public Object visitPrecondition(final PreconditionContext ctx) {
    positions.add(createPosition(ctx, IAIEPartitions.AIE_PRECONDITION));
    if (ctx.ownedSpecification != null) {
      visitFormula(ctx.ownedSpecification);
    }

    positions.add(createPosition(ctx, IAIEPartitions.AIE_PRECONDITION));
    return super.visitPrecondition(ctx);
  }

  @Override
  public Object visitPostcondition(final PostconditionContext ctx) {
    positions.add(createPosition(ctx, IAIEPartitions.AIE_POSTCONDITION));
    if (ctx.ownedSpecification != null) {
      visitFormula(ctx.ownedSpecification);
    }
    return super.visitPostcondition(ctx);
  }

  @Override
  public Object visitInitial(final InitialContext ctx) {
    positions.add(createPosition(ctx, IAIEPartitions.AIE_INITIAL));
    if (ctx.ownedExpression != null) {
      visitExpression(ctx.ownedExpression);
    }
    return super.visitInitial(ctx);
  }

  @Override
  public Object visitDerivation(final DerivationContext ctx) {
    positions.add(createPosition(ctx, IAIEPartitions.AIE_DERIVATION));
    if (ctx.ownedExpression != null) {
      visitExpression(ctx.ownedExpression);
    }
    return super.visitDerivation(ctx);
  }

  public void visitExpression(final ExpressionContext ctx) {
    positions.add(createPosition(ctx, IAIEPartitions.AIE_EXPRESSION));
  }

  public void visitFormula(final FormulaContext ctx) {
    positions.add(createPosition(ctx, IAIEPartitions.AIE_FORMULA));
  }

  private TypedPosition createPosition(final TerminalNode node, final String type) {
    return new TypedPosition(node.getSymbol().getStartIndex(),
        node.getSymbol().getStopIndex() - node.getSymbol().getStartIndex(), type);
  }

  @Override
  public Object visitTerminal(final TerminalNode node) {
    switch (node.getSymbol().getType()) {
      case AlloyInEcoreLexer.DOUBLE_QUOTED_STRING:
        positions.add(createPosition(node, IAIEPartitions.AIE_DOUBLE_QUOTED_STRING));
        break;
      case AlloyInEcoreLexer.ML_SINGLE_QUOTED_STRING:
      case AlloyInEcoreLexer.SINGLE_QUOTED_STRING:
        positions.add(createPosition(node, IAIEPartitions.AIE_SINGLE_QUOTED_STRING));
        break;
      case AlloyInEcoreLexer.MULTILINE_COMMENT:
        positions.add(createPosition(node, IAIEPartitions.AIE_MULTI_LINE_COMMENT));
        break;
      case AlloyInEcoreLexer.SINGLELINE_COMMENT:
        positions.add(createPosition(node, IAIEPartitions.AIE_SINGLE_LINE_COMMENT));
        break;
      default:
        break;
    }
    return super.visitTerminal(node);
  }
}
