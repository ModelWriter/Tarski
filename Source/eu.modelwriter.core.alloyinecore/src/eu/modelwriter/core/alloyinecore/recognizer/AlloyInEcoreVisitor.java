// Generated from /home/emrekirmizi/Documents/projects/git/WP3/Source/eu.modelwriter.core.alloyinecore/bin/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.5.3
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
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEAnnotation(AlloyInEcoreParser.EAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eDetail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEDetail(AlloyInEcoreParser.EDetailContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eModelElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEModelElement(AlloyInEcoreParser.EModelElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eNamedElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitENamedElement(AlloyInEcoreParser.ENamedElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eTypedElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitETypedElement(AlloyInEcoreParser.ETypedElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eModelElementRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEModelElementRef(AlloyInEcoreParser.EModelElementRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#templateSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateSignature(AlloyInEcoreParser.TemplateSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(AlloyInEcoreParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#invariant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariant(AlloyInEcoreParser.InvariantContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#precondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecondition(AlloyInEcoreParser.PreconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#postcondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostcondition(AlloyInEcoreParser.PostconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#visibilityKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibilityKind(AlloyInEcoreParser.VisibilityKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(AlloyInEcoreParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(AlloyInEcoreParser.FormulaContext ctx);
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