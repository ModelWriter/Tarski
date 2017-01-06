// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.recognizer;

//import eu.modelwriter.core.alloyinecore.structure.*;
//import eu.modelwriter.core.alloyinecore.structure.Package;
//import eu.modelwriter.core.alloyinecore.structure.Class;
//import eu.modelwriter.core.alloyinecore.structure.Reference;
//import eu.modelwriter.core.alloyinecore.structure.Attribute;
//import eu.modelwriter.core.alloyinecore.structure.Operation;
//import eu.modelwriter.core.alloyinecore.structure.Enum;
//import eu.modelwriter.core.alloyinecore.structure.Parameter;
//import eu.modelwriter.core.alloyinecore.structure.EnumLiteral;

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
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#problem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProblem(AlloyInEcoreParser.ProblemContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptions(AlloyInEcoreParser.OptionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code symmetryBreaking}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymmetryBreaking(AlloyInEcoreParser.SymmetryBreakingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitWidth}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitWidth(AlloyInEcoreParser.BitWidthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code skolemDepth}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkolemDepth(AlloyInEcoreParser.SkolemDepthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sharing}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSharing(AlloyInEcoreParser.SharingContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#universe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniverse(AlloyInEcoreParser.UniverseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#relations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelations(AlloyInEcoreParser.RelationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(AlloyInEcoreParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#tupleSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleSet(AlloyInEcoreParser.TupleSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(AlloyInEcoreParser.TupleContext ctx);
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
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(AlloyInEcoreParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRef(AlloyInEcoreParser.TypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#typedRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedRef(AlloyInEcoreParser.TypedRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#typedTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedTypeRef(AlloyInEcoreParser.TypedTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#wildcardTypeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardTypeRef(AlloyInEcoreParser.WildcardTypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#templateBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateBinding(AlloyInEcoreParser.TemplateBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#templateParameterSubstitution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateParameterSubstitution(AlloyInEcoreParser.TemplateParameterSubstitutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#pathName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathName(AlloyInEcoreParser.PathNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#typedMultiplicityRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedMultiplicityRef(AlloyInEcoreParser.TypedMultiplicityRefContext ctx);
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
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#initial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial(AlloyInEcoreParser.InitialContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#derivation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDerivation(AlloyInEcoreParser.DerivationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#visibilityKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibilityKind(AlloyInEcoreParser.VisibilityKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(AlloyInEcoreParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#arity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArity(AlloyInEcoreParser.ArityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code no}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNo(AlloyInEcoreParser.NoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code some}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSome(AlloyInEcoreParser.SomeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forOne}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForOne(AlloyInEcoreParser.ForOneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumDeclaration}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumDeclaration(AlloyInEcoreParser.SumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forAll}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAll(AlloyInEcoreParser.ForAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lone}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLone(AlloyInEcoreParser.LoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lt}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLt(AlloyInEcoreParser.LtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forSome}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForSome(AlloyInEcoreParser.ForSomeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(AlloyInEcoreParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_paranthesis(AlloyInEcoreParser.F_paranthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(AlloyInEcoreParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(AlloyInEcoreParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gte}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGte(AlloyInEcoreParser.GteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code acyclic}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcyclic(AlloyInEcoreParser.AcyclicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code let}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(AlloyInEcoreParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lte}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLte(AlloyInEcoreParser.LteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(AlloyInEcoreParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code in}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(AlloyInEcoreParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code one}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOne(AlloyInEcoreParser.OneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(AlloyInEcoreParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iff}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIff(AlloyInEcoreParser.IffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eq}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(AlloyInEcoreParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gt}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGt(AlloyInEcoreParser.GtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(AlloyInEcoreParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLone}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLone(AlloyInEcoreParser.ForLoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code totalOrder}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTotalOrder(AlloyInEcoreParser.TotalOrderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(AlloyInEcoreParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forNo}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForNo(AlloyInEcoreParser.ForNoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code implies}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(AlloyInEcoreParser.ImpliesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code product}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(AlloyInEcoreParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(AlloyInEcoreParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code none}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNone(AlloyInEcoreParser.NoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code union}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(AlloyInEcoreParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boxjoin}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoxjoin(AlloyInEcoreParser.BoxjoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comprehension}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComprehension(AlloyInEcoreParser.ComprehensionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code univ}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniv(AlloyInEcoreParser.UnivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reflexive}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReflexive(AlloyInEcoreParser.ReflexiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code e_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE_paranthesis(AlloyInEcoreParser.E_paranthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iden}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIden(AlloyInEcoreParser.IdenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ints}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInts(AlloyInEcoreParser.IntsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntersection(AlloyInEcoreParser.IntersectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rel}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel(AlloyInEcoreParser.RelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code difference}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(AlloyInEcoreParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code transpose}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranspose(AlloyInEcoreParser.TransposeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code join}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin(AlloyInEcoreParser.JoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code override}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverride(AlloyInEcoreParser.OverrideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExpression}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(AlloyInEcoreParser.IfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code closure}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosure(AlloyInEcoreParser.ClosureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(AlloyInEcoreParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConstant(AlloyInEcoreParser.IntConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code i_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_paranthesis(AlloyInEcoreParser.I_paranthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifIntExpression}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfIntExpression(AlloyInEcoreParser.IfIntExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code count}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCount(AlloyInEcoreParser.CountContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(AlloyInEcoreParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divide}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(AlloyInEcoreParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(AlloyInEcoreParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(AlloyInEcoreParser.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link AlloyInEcoreParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(AlloyInEcoreParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#decls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(AlloyInEcoreParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneOf}
	 * labeled alternative in {@link AlloyInEcoreParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneOf(AlloyInEcoreParser.OneOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loneOf}
	 * labeled alternative in {@link AlloyInEcoreParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoneOf(AlloyInEcoreParser.LoneOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someOf}
	 * labeled alternative in {@link AlloyInEcoreParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeOf(AlloyInEcoreParser.SomeOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setOf}
	 * labeled alternative in {@link AlloyInEcoreParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetOf(AlloyInEcoreParser.SetOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#letDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetDecls(AlloyInEcoreParser.LetDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#letDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetDecl(AlloyInEcoreParser.LetDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#comprehensionDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComprehensionDecls(AlloyInEcoreParser.ComprehensionDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#comprehensionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComprehensionDecl(AlloyInEcoreParser.ComprehensionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#relationId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationId(AlloyInEcoreParser.RelationIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#variableId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableId(AlloyInEcoreParser.VariableIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(AlloyInEcoreParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#unrestrictedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnrestrictedName(AlloyInEcoreParser.UnrestrictedNameContext ctx);
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