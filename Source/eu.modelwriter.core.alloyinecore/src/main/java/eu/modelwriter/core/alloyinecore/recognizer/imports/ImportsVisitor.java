/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/recognizer/imports/Imports.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.recognizer.imports;

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