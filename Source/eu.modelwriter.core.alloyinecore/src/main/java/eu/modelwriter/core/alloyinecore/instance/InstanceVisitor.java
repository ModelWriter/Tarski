// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/instance/Instance.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.instance;



import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InstanceParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InstanceVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InstanceParser#instance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstance(InstanceParser.InstanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#packageImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageImport(InstanceParser.PackageImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#modelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelDeclaration(InstanceParser.ModelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(InstanceParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(InstanceParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(InstanceParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#dataValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValue(InstanceParser.DataValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#multiValueData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiValueData(InstanceParser.MultiValueDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#objectReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectReference(InstanceParser.ObjectReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#pathName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathName(InstanceParser.PathNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegment(InstanceParser.SegmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(InstanceParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#unrestrictedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnrestrictedName(InstanceParser.UnrestrictedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#booleanValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(InstanceParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#numericValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericValue(InstanceParser.NumericValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(InstanceParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#stringValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(InstanceParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#charValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharValue(InstanceParser.CharValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link InstanceParser#nullValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullValue(InstanceParser.NullValueContext ctx);
}