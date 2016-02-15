// Generated from C:/Users/anil.ozturk/IdeaProjects/untitled1/src\Kodkod.g4 by ANTLR 4.5.1
package eu.modelwriter.kodkod.core.recognizer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KodkodParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KodkodVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KodkodParser#tree}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProblem(KodkodParser.ProblemContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptions(KodkodParser.OptionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code symmetryBreaking}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymmetryBreaking(KodkodParser.SymmetryBreakingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitWidth}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitWidth(KodkodParser.BitWidthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code skolemDepth}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkolemDepth(KodkodParser.SkolemDepthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sharing}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSharing(KodkodParser.SharingContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#universe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniverse(KodkodParser.UniverseContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#relations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelations(KodkodParser.RelationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#tupleSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleSet(KodkodParser.TupleSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(KodkodParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(KodkodParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(KodkodParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(KodkodParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(KodkodParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#arity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArity(KodkodParser.ArityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code no}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNo(KodkodParser.NoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code some}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSome(KodkodParser.SomeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forOne}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForOne(KodkodParser.ForOneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumDeclaration}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumDeclaration(KodkodParser.SumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forAll}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAll(KodkodParser.ForAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lone}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLone(KodkodParser.LoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lt}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLt(KodkodParser.LtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forSome}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForSome(KodkodParser.ForSomeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(KodkodParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f_paranthesis}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_paranthesis(KodkodParser.F_paranthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(KodkodParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(KodkodParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gte}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGte(KodkodParser.GteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code acyclic}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcyclic(KodkodParser.AcyclicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code let}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(KodkodParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lte}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLte(KodkodParser.LteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(KodkodParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code in}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(KodkodParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code one}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOne(KodkodParser.OneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(KodkodParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iff}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIff(KodkodParser.IffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eq}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(KodkodParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gt}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGt(KodkodParser.GtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(KodkodParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLone}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLone(KodkodParser.ForLoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code totalOrder}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTotalOrder(KodkodParser.TotalOrderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(KodkodParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forNo}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForNo(KodkodParser.ForNoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code implies}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(KodkodParser.ImpliesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code product}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(KodkodParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(KodkodParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code none}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNone(KodkodParser.NoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code union}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(KodkodParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boxjoin}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoxjoin(KodkodParser.BoxjoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comprehension}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComprehension(KodkodParser.ComprehensionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code univ}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniv(KodkodParser.UnivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reflexive}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReflexive(KodkodParser.ReflexiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code e_paranthesis}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE_paranthesis(KodkodParser.E_paranthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iden}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIden(KodkodParser.IdenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ints}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInts(KodkodParser.IntsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntersection(KodkodParser.IntersectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rel}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel(KodkodParser.RelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code difference}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(KodkodParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code transpose}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranspose(KodkodParser.TransposeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code join}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin(KodkodParser.JoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code override}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverride(KodkodParser.OverrideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExpression}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(KodkodParser.IfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code closure}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosure(KodkodParser.ClosureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(KodkodParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConstant(KodkodParser.IntConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code i_paranthesis}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_paranthesis(KodkodParser.I_paranthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifIntExpression}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfIntExpression(KodkodParser.IfIntExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code count}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCount(KodkodParser.CountContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(KodkodParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divide}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(KodkodParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(KodkodParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(KodkodParser.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(KodkodParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#decls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(KodkodParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneOf(KodkodParser.OneOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loneOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoneOf(KodkodParser.LoneOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeOf(KodkodParser.SomeOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetOf(KodkodParser.SetOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#letDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetDecls(KodkodParser.LetDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#letDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetDecl(KodkodParser.LetDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#comprehensionDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComprehensionDecls(KodkodParser.ComprehensionDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KodkodParser#comprehensionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComprehensionDecl(KodkodParser.ComprehensionDeclContext ctx);
}