package eu.modelwriter.core.alloyinecore.recognizer;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlloyInEcoreParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlloyInEcoreVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(AlloyInEcoreParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#packageImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageImport(AlloyInEcoreParser.PackageImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#ePackage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEPackage(AlloyInEcoreParser.EPackageContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eClassifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEClassifier(AlloyInEcoreParser.EClassifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEClass(AlloyInEcoreParser.EClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eStructuralFeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEStructuralFeature(AlloyInEcoreParser.EStructuralFeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEAttribute(AlloyInEcoreParser.EAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEReference(AlloyInEcoreParser.EReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEOperation(AlloyInEcoreParser.EOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEParameter(AlloyInEcoreParser.EParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEType(AlloyInEcoreParser.ETypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eMultiplicity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEMultiplicity(AlloyInEcoreParser.EMultiplicityContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEDataType(AlloyInEcoreParser.EDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#ePrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEPrimitiveType(AlloyInEcoreParser.EPrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eEnum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEEnum(AlloyInEcoreParser.EEnumContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eEnumLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEEnumLiteral(AlloyInEcoreParser.EEnumLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#templateSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateSignature(AlloyInEcoreParser.TemplateSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#bodyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyExpression(AlloyInEcoreParser.BodyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#invariantConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariantConstraint(AlloyInEcoreParser.InvariantConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#preconditionConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreconditionConstraint(AlloyInEcoreParser.PreconditionConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#postconditionConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostconditionConstraint(AlloyInEcoreParser.PostconditionConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecification(AlloyInEcoreParser.SpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(AlloyInEcoreParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#visibilityKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibilityKind(AlloyInEcoreParser.VisibilityKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(AlloyInEcoreParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(AlloyInEcoreParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#upper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpper(AlloyInEcoreParser.UpperContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#lower}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLower(AlloyInEcoreParser.LowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#signed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigned(AlloyInEcoreParser.SignedContext ctx);
}