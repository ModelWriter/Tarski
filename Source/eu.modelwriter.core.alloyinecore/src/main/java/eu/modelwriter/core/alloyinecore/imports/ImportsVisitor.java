// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/imports/Imports.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.imports;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedPackage;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedClass;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedInterface;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedDataType;
import eu.modelwriter.core.alloyinecore.structure.imports.ImportedEnum;
import eu.modelwriter.core.alloyinecore.structure.model.Import;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ImportsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ImportsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ImportsParser#importModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportModel(ImportsParser.ImportModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#iPackage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIPackage(ImportsParser.IPackageContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#iClassifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIClassifier(ImportsParser.IClassifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#iClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIClass(ImportsParser.IClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#iDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDataType(ImportsParser.IDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#visibility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibility(ImportsParser.VisibilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ImportsParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#templateSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateSignature(ImportsParser.TemplateSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#iTypeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITypeParameter(ImportsParser.ITypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#iGenericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIGenericType(ImportsParser.IGenericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#iGenericTypeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIGenericTypeArgument(ImportsParser.IGenericTypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#iGenericWildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIGenericWildcard(ImportsParser.IGenericWildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#pathName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathName(ImportsParser.PathNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegment(ImportsParser.SegmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#unrestrictedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnrestrictedName(ImportsParser.UnrestrictedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImportsParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ImportsParser.IdentifierContext ctx);
}