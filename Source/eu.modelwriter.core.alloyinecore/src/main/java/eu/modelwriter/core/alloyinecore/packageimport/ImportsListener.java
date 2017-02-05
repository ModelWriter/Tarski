// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/packageimport/Imports.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.packageimport;

import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.structure.ImportedPackage;
import eu.modelwriter.core.alloyinecore.structure.ImportedClass;
import eu.modelwriter.core.alloyinecore.structure.ImportedInterface;
import eu.modelwriter.core.alloyinecore.structure.ImportedDataType;
import eu.modelwriter.core.alloyinecore.structure.ImportedEnum;
import eu.modelwriter.core.alloyinecore.structure.Import;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImportsParser}.
 */
public interface ImportsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImportsParser#importedFile}.
	 * @param ctx the parse tree
	 */
	void enterImportedFile(ImportsParser.ImportedFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#importedFile}.
	 * @param ctx the parse tree
	 */
	void exitImportedFile(ImportsParser.ImportedFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#iPackage}.
	 * @param ctx the parse tree
	 */
	void enterIPackage(ImportsParser.IPackageContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#iPackage}.
	 * @param ctx the parse tree
	 */
	void exitIPackage(ImportsParser.IPackageContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#iClassifier}.
	 * @param ctx the parse tree
	 */
	void enterIClassifier(ImportsParser.IClassifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#iClassifier}.
	 * @param ctx the parse tree
	 */
	void exitIClassifier(ImportsParser.IClassifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#iClass}.
	 * @param ctx the parse tree
	 */
	void enterIClass(ImportsParser.IClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#iClass}.
	 * @param ctx the parse tree
	 */
	void exitIClass(ImportsParser.IClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#iDataType}.
	 * @param ctx the parse tree
	 */
	void enterIDataType(ImportsParser.IDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#iDataType}.
	 * @param ctx the parse tree
	 */
	void exitIDataType(ImportsParser.IDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#visibility}.
	 * @param ctx the parse tree
	 */
	void enterVisibility(ImportsParser.VisibilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#visibility}.
	 * @param ctx the parse tree
	 */
	void exitVisibility(ImportsParser.VisibilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ImportsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ImportsParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#templateSignature}.
	 * @param ctx the parse tree
	 */
	void enterTemplateSignature(ImportsParser.TemplateSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#templateSignature}.
	 * @param ctx the parse tree
	 */
	void exitTemplateSignature(ImportsParser.TemplateSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#iTypeParameter}.
	 * @param ctx the parse tree
	 */
	void enterITypeParameter(ImportsParser.ITypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#iTypeParameter}.
	 * @param ctx the parse tree
	 */
	void exitITypeParameter(ImportsParser.ITypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#iGenericType}.
	 * @param ctx the parse tree
	 */
	void enterIGenericType(ImportsParser.IGenericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#iGenericType}.
	 * @param ctx the parse tree
	 */
	void exitIGenericType(ImportsParser.IGenericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#iGenericTypeArgument}.
	 * @param ctx the parse tree
	 */
	void enterIGenericTypeArgument(ImportsParser.IGenericTypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#iGenericTypeArgument}.
	 * @param ctx the parse tree
	 */
	void exitIGenericTypeArgument(ImportsParser.IGenericTypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#iGenericWildcard}.
	 * @param ctx the parse tree
	 */
	void enterIGenericWildcard(ImportsParser.IGenericWildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#iGenericWildcard}.
	 * @param ctx the parse tree
	 */
	void exitIGenericWildcard(ImportsParser.IGenericWildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#pathName}.
	 * @param ctx the parse tree
	 */
	void enterPathName(ImportsParser.PathNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#pathName}.
	 * @param ctx the parse tree
	 */
	void exitPathName(ImportsParser.PathNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterSegment(ImportsParser.SegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitSegment(ImportsParser.SegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(ImportsParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(ImportsParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#unrestrictedName}.
	 * @param ctx the parse tree
	 */
	void enterUnrestrictedName(ImportsParser.UnrestrictedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#unrestrictedName}.
	 * @param ctx the parse tree
	 */
	void exitUnrestrictedName(ImportsParser.UnrestrictedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImportsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ImportsParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImportsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ImportsParser.IdentifierContext ctx);
}