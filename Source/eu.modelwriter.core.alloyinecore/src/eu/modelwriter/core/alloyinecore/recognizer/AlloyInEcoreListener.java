// Generated from C:/Users/Mete/IdeaProjects/TestJavaProject/src/kodkod\AlloyInEcore.g4 by ANTLR 4.5.1
package eu.modelwriter.core.alloyinecore.recognizer;
 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlloyInEcoreParser}.
 */
public interface AlloyInEcoreListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(AlloyInEcoreParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(AlloyInEcoreParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#packageImport}.
	 * @param ctx the parse tree
	 */
	void enterPackageImport(AlloyInEcoreParser.PackageImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#packageImport}.
	 * @param ctx the parse tree
	 */
	void exitPackageImport(AlloyInEcoreParser.PackageImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#ePackage}.
	 * @param ctx the parse tree
	 */
	void enterEPackage(AlloyInEcoreParser.EPackageContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#ePackage}.
	 * @param ctx the parse tree
	 */
	void exitEPackage(AlloyInEcoreParser.EPackageContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eClassifier}.
	 * @param ctx the parse tree
	 */
	void enterEClassifier(AlloyInEcoreParser.EClassifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eClassifier}.
	 * @param ctx the parse tree
	 */
	void exitEClassifier(AlloyInEcoreParser.EClassifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eClass}.
	 * @param ctx the parse tree
	 */
	void enterEClass(AlloyInEcoreParser.EClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eClass}.
	 * @param ctx the parse tree
	 */
	void exitEClass(AlloyInEcoreParser.EClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eStructuralFeature}.
	 * @param ctx the parse tree
	 */
	void enterEStructuralFeature(AlloyInEcoreParser.EStructuralFeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eStructuralFeature}.
	 * @param ctx the parse tree
	 */
	void exitEStructuralFeature(AlloyInEcoreParser.EStructuralFeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eAttribute}.
	 * @param ctx the parse tree
	 */
	void enterEAttribute(AlloyInEcoreParser.EAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eAttribute}.
	 * @param ctx the parse tree
	 */
	void exitEAttribute(AlloyInEcoreParser.EAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eReference}.
	 * @param ctx the parse tree
	 */
	void enterEReference(AlloyInEcoreParser.EReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eReference}.
	 * @param ctx the parse tree
	 */
	void exitEReference(AlloyInEcoreParser.EReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eOperation}.
	 * @param ctx the parse tree
	 */
	void enterEOperation(AlloyInEcoreParser.EOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eOperation}.
	 * @param ctx the parse tree
	 */
	void exitEOperation(AlloyInEcoreParser.EOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eParameter}.
	 * @param ctx the parse tree
	 */
	void enterEParameter(AlloyInEcoreParser.EParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eParameter}.
	 * @param ctx the parse tree
	 */
	void exitEParameter(AlloyInEcoreParser.EParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eType}.
	 * @param ctx the parse tree
	 */
	void enterEType(AlloyInEcoreParser.ETypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eType}.
	 * @param ctx the parse tree
	 */
	void exitEType(AlloyInEcoreParser.ETypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eMultiplicity}.
	 * @param ctx the parse tree
	 */
	void enterEMultiplicity(AlloyInEcoreParser.EMultiplicityContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eMultiplicity}.
	 * @param ctx the parse tree
	 */
	void exitEMultiplicity(AlloyInEcoreParser.EMultiplicityContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eDataType}.
	 * @param ctx the parse tree
	 */
	void enterEDataType(AlloyInEcoreParser.EDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eDataType}.
	 * @param ctx the parse tree
	 */
	void exitEDataType(AlloyInEcoreParser.EDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#ePrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterEPrimitiveType(AlloyInEcoreParser.EPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#ePrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitEPrimitiveType(AlloyInEcoreParser.EPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eEnum}.
	 * @param ctx the parse tree
	 */
	void enterEEnum(AlloyInEcoreParser.EEnumContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eEnum}.
	 * @param ctx the parse tree
	 */
	void exitEEnum(AlloyInEcoreParser.EEnumContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eEnumLiteral}.
	 * @param ctx the parse tree
	 */
	void enterEEnumLiteral(AlloyInEcoreParser.EEnumLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eEnumLiteral}.
	 * @param ctx the parse tree
	 */
	void exitEEnumLiteral(AlloyInEcoreParser.EEnumLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#templateSignature}.
	 * @param ctx the parse tree
	 */
	void enterTemplateSignature(AlloyInEcoreParser.TemplateSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#templateSignature}.
	 * @param ctx the parse tree
	 */
	void exitTemplateSignature(AlloyInEcoreParser.TemplateSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#invariantConstraint}.
	 * @param ctx the parse tree
	 */
	void enterInvariantConstraint(AlloyInEcoreParser.InvariantConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#invariantConstraint}.
	 * @param ctx the parse tree
	 */
	void exitInvariantConstraint(AlloyInEcoreParser.InvariantConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#preconditionConstraint}.
	 * @param ctx the parse tree
	 */
	void enterPreconditionConstraint(AlloyInEcoreParser.PreconditionConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#preconditionConstraint}.
	 * @param ctx the parse tree
	 */
	void exitPreconditionConstraint(AlloyInEcoreParser.PreconditionConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#postconditionConstraint}.
	 * @param ctx the parse tree
	 */
	void enterPostconditionConstraint(AlloyInEcoreParser.PostconditionConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#postconditionConstraint}.
	 * @param ctx the parse tree
	 */
	void exitPostconditionConstraint(AlloyInEcoreParser.PostconditionConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterSpecification(AlloyInEcoreParser.SpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitSpecification(AlloyInEcoreParser.SpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(AlloyInEcoreParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(AlloyInEcoreParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#visibilityKind}.
	 * @param ctx the parse tree
	 */
	void enterVisibilityKind(AlloyInEcoreParser.VisibilityKindContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#visibilityKind}.
	 * @param ctx the parse tree
	 */
	void exitVisibilityKind(AlloyInEcoreParser.VisibilityKindContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(AlloyInEcoreParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(AlloyInEcoreParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(AlloyInEcoreParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(AlloyInEcoreParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#upper}.
	 * @param ctx the parse tree
	 */
	void enterUpper(AlloyInEcoreParser.UpperContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#upper}.
	 * @param ctx the parse tree
	 */
	void exitUpper(AlloyInEcoreParser.UpperContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#lower}.
	 * @param ctx the parse tree
	 */
	void enterLower(AlloyInEcoreParser.LowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#lower}.
	 * @param ctx the parse tree
	 */
	void exitLower(AlloyInEcoreParser.LowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#signed}.
	 * @param ctx the parse tree
	 */
	void enterSigned(AlloyInEcoreParser.SignedContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#signed}.
	 * @param ctx the parse tree
	 */
	void exitSigned(AlloyInEcoreParser.SignedContext ctx);
}