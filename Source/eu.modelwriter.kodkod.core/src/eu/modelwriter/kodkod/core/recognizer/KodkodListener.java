// Generated from C:/Users/anil.ozturk/IdeaProjects/untitled1/src\Kodkod.g4 by ANTLR 4.5.1
package eu.modelwriter.kodkod.core.recognizer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KodkodParser}.
 */
public interface KodkodListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KodkodParser#problem}.
	 * @param ctx the parse tree
	 */
	void enterProblem(KodkodParser.ProblemContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#problem}.
	 * @param ctx the parse tree
	 */
	void exitProblem(KodkodParser.ProblemContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#options}.
	 * @param ctx the parse tree
	 */
	void enterOptions(KodkodParser.OptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#options}.
	 * @param ctx the parse tree
	 */
	void exitOptions(KodkodParser.OptionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code symmetryBreaking}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 */
	void enterSymmetryBreaking(KodkodParser.SymmetryBreakingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code symmetryBreaking}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 */
	void exitSymmetryBreaking(KodkodParser.SymmetryBreakingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitWidth}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 */
	void enterBitWidth(KodkodParser.BitWidthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitWidth}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 */
	void exitBitWidth(KodkodParser.BitWidthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code skolemDepth}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 */
	void enterSkolemDepth(KodkodParser.SkolemDepthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code skolemDepth}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 */
	void exitSkolemDepth(KodkodParser.SkolemDepthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sharing}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 */
	void enterSharing(KodkodParser.SharingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sharing}
	 * labeled alternative in {@link KodkodParser#option}.
	 * @param ctx the parse tree
	 */
	void exitSharing(KodkodParser.SharingContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#universe}.
	 * @param ctx the parse tree
	 */
	void enterUniverse(KodkodParser.UniverseContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#universe}.
	 * @param ctx the parse tree
	 */
	void exitUniverse(KodkodParser.UniverseContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#relBound}.
	 * @param ctx the parse tree
	 */
	void enterRelBound(KodkodParser.RelBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#relBound}.
	 * @param ctx the parse tree
	 */
	void exitRelBound(KodkodParser.RelBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#tupleSet}.
	 * @param ctx the parse tree
	 */
	void enterTupleSet(KodkodParser.TupleSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#tupleSet}.
	 * @param ctx the parse tree
	 */
	void exitTupleSet(KodkodParser.TupleSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(KodkodParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(KodkodParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(KodkodParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(KodkodParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(KodkodParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(KodkodParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(KodkodParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(KodkodParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(KodkodParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(KodkodParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#arity}.
	 * @param ctx the parse tree
	 */
	void enterArity(KodkodParser.ArityContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#arity}.
	 * @param ctx the parse tree
	 */
	void exitArity(KodkodParser.ArityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code no}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNo(KodkodParser.NoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code no}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNo(KodkodParser.NoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code some}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterSome(KodkodParser.SomeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code some}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitSome(KodkodParser.SomeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forOne}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForOne(KodkodParser.ForOneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forOne}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForOne(KodkodParser.ForOneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sumDeclaration}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterSumDeclaration(KodkodParser.SumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sumDeclaration}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitSumDeclaration(KodkodParser.SumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forAll}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAll(KodkodParser.ForAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forAll}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAll(KodkodParser.ForAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lone}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLone(KodkodParser.LoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lone}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLone(KodkodParser.LoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lt}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLt(KodkodParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lt}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLt(KodkodParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forSome}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForSome(KodkodParser.ForSomeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forSome}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForSome(KodkodParser.ForSomeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNot(KodkodParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNot(KodkodParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f_paranthesis}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterF_paranthesis(KodkodParser.F_paranthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f_paranthesis}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitF_paranthesis(KodkodParser.F_paranthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnd(KodkodParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnd(KodkodParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code function}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFunction(KodkodParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code function}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFunction(KodkodParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gte}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterGte(KodkodParser.GteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gte}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitGte(KodkodParser.GteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code acyclic}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAcyclic(KodkodParser.AcyclicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code acyclic}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAcyclic(KodkodParser.AcyclicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code let}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLet(KodkodParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code let}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLet(KodkodParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lte}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLte(KodkodParser.LteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lte}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLte(KodkodParser.LteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterOr(KodkodParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitOr(KodkodParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code in}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterIn(KodkodParser.InContext ctx);
	/**
	 * Exit a parse tree produced by the {@code in}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitIn(KodkodParser.InContext ctx);
	/**
	 * Enter a parse tree produced by the {@code one}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterOne(KodkodParser.OneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code one}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitOne(KodkodParser.OneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code false}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFalse(KodkodParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code false}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFalse(KodkodParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iff}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterIff(KodkodParser.IffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iff}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitIff(KodkodParser.IffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eq}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEq(KodkodParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eq}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEq(KodkodParser.EqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gt}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterGt(KodkodParser.GtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gt}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitGt(KodkodParser.GtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEqual(KodkodParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEqual(KodkodParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forLone}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForLone(KodkodParser.ForLoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forLone}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForLone(KodkodParser.ForLoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code totalOrder}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterTotalOrder(KodkodParser.TotalOrderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code totalOrder}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitTotalOrder(KodkodParser.TotalOrderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterTrue(KodkodParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitTrue(KodkodParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forNo}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForNo(KodkodParser.ForNoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forNo}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForNo(KodkodParser.ForNoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code implies}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterImplies(KodkodParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code implies}
	 * labeled alternative in {@link KodkodParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitImplies(KodkodParser.ImpliesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code product}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterProduct(KodkodParser.ProductContext ctx);
	/**
	 * Exit a parse tree produced by the {@code product}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitProduct(KodkodParser.ProductContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar(KodkodParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar(KodkodParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code none}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNone(KodkodParser.NoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code none}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNone(KodkodParser.NoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code union}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnion(KodkodParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code union}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnion(KodkodParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boxjoin}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoxjoin(KodkodParser.BoxjoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boxjoin}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoxjoin(KodkodParser.BoxjoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comprehension}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComprehension(KodkodParser.ComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comprehension}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComprehension(KodkodParser.ComprehensionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code univ}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUniv(KodkodParser.UnivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code univ}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUniv(KodkodParser.UnivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code reflexive}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReflexive(KodkodParser.ReflexiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code reflexive}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReflexive(KodkodParser.ReflexiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code e_paranthesis}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterE_paranthesis(KodkodParser.E_paranthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code e_paranthesis}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitE_paranthesis(KodkodParser.E_paranthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iden}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIden(KodkodParser.IdenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iden}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIden(KodkodParser.IdenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ints}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInts(KodkodParser.IntsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ints}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInts(KodkodParser.IntsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntersection(KodkodParser.IntersectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntersection(KodkodParser.IntersectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rel}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRel(KodkodParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rel}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRel(KodkodParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code difference}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDifference(KodkodParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code difference}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDifference(KodkodParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transpose}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTranspose(KodkodParser.TransposeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transpose}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTranspose(KodkodParser.TransposeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code join}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterJoin(KodkodParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code join}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitJoin(KodkodParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code override}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOverride(KodkodParser.OverrideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code override}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOverride(KodkodParser.OverrideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifExpression}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(KodkodParser.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifExpression}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(KodkodParser.IfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code closure}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterClosure(KodkodParser.ClosureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code closure}
	 * labeled alternative in {@link KodkodParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitClosure(KodkodParser.ClosureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minus}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(KodkodParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(KodkodParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterIntConstant(KodkodParser.IntConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitIntConstant(KodkodParser.IntConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code i_paranthesis}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterI_paranthesis(KodkodParser.I_paranthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code i_paranthesis}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitI_paranthesis(KodkodParser.I_paranthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifIntExpression}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterIfIntExpression(KodkodParser.IfIntExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifIntExpression}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitIfIntExpression(KodkodParser.IfIntExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code count}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterCount(KodkodParser.CountContext ctx);
	/**
	 * Exit a parse tree produced by the {@code count}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitCount(KodkodParser.CountContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sum}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterSum(KodkodParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitSum(KodkodParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divide}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterDivide(KodkodParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divide}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitDivide(KodkodParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(KodkodParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(KodkodParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterModulo(KodkodParser.ModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitModulo(KodkodParser.ModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void enterPlus(KodkodParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link KodkodParser#intexpression}.
	 * @param ctx the parse tree
	 */
	void exitPlus(KodkodParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(KodkodParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(KodkodParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oneOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterOneOf(KodkodParser.OneOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oneOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitOneOf(KodkodParser.OneOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loneOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterLoneOf(KodkodParser.LoneOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loneOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitLoneOf(KodkodParser.LoneOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code someOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterSomeOf(KodkodParser.SomeOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code someOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitSomeOf(KodkodParser.SomeOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterSetOf(KodkodParser.SetOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setOf}
	 * labeled alternative in {@link KodkodParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitSetOf(KodkodParser.SetOfContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#letDecls}.
	 * @param ctx the parse tree
	 */
	void enterLetDecls(KodkodParser.LetDeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#letDecls}.
	 * @param ctx the parse tree
	 */
	void exitLetDecls(KodkodParser.LetDeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#letDecl}.
	 * @param ctx the parse tree
	 */
	void enterLetDecl(KodkodParser.LetDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#letDecl}.
	 * @param ctx the parse tree
	 */
	void exitLetDecl(KodkodParser.LetDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#comprehensionDecls}.
	 * @param ctx the parse tree
	 */
	void enterComprehensionDecls(KodkodParser.ComprehensionDeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#comprehensionDecls}.
	 * @param ctx the parse tree
	 */
	void exitComprehensionDecls(KodkodParser.ComprehensionDeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KodkodParser#comprehensionDecl}.
	 * @param ctx the parse tree
	 */
	void enterComprehensionDecl(KodkodParser.ComprehensionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KodkodParser#comprehensionDecl}.
	 * @param ctx the parse tree
	 */
	void exitComprehensionDecl(KodkodParser.ComprehensionDeclContext ctx);
}