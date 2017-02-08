// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/instance/Instance.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.instance;



import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InstanceParser}.
 */
public interface InstanceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InstanceParser#instance}.
	 * @param ctx the parse tree
	 */
	void enterInstance(InstanceParser.InstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#instance}.
	 * @param ctx the parse tree
	 */
	void exitInstance(InstanceParser.InstanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#packageImport}.
	 * @param ctx the parse tree
	 */
	void enterPackageImport(InstanceParser.PackageImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#packageImport}.
	 * @param ctx the parse tree
	 */
	void exitPackageImport(InstanceParser.PackageImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#modelDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModelDeclaration(InstanceParser.ModelDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#modelDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModelDeclaration(InstanceParser.ModelDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(InstanceParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(InstanceParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(InstanceParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(InstanceParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(InstanceParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(InstanceParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#dataValue}.
	 * @param ctx the parse tree
	 */
	void enterDataValue(InstanceParser.DataValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#dataValue}.
	 * @param ctx the parse tree
	 */
	void exitDataValue(InstanceParser.DataValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#multiValueData}.
	 * @param ctx the parse tree
	 */
	void enterMultiValueData(InstanceParser.MultiValueDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#multiValueData}.
	 * @param ctx the parse tree
	 */
	void exitMultiValueData(InstanceParser.MultiValueDataContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#objectReference}.
	 * @param ctx the parse tree
	 */
	void enterObjectReference(InstanceParser.ObjectReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#objectReference}.
	 * @param ctx the parse tree
	 */
	void exitObjectReference(InstanceParser.ObjectReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#pathName}.
	 * @param ctx the parse tree
	 */
	void enterPathName(InstanceParser.PathNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#pathName}.
	 * @param ctx the parse tree
	 */
	void exitPathName(InstanceParser.PathNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterSegment(InstanceParser.SegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitSegment(InstanceParser.SegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(InstanceParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(InstanceParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#unrestrictedName}.
	 * @param ctx the parse tree
	 */
	void enterUnrestrictedName(InstanceParser.UnrestrictedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#unrestrictedName}.
	 * @param ctx the parse tree
	 */
	void exitUnrestrictedName(InstanceParser.UnrestrictedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(InstanceParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(InstanceParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#numericValue}.
	 * @param ctx the parse tree
	 */
	void enterNumericValue(InstanceParser.NumericValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#numericValue}.
	 * @param ctx the parse tree
	 */
	void exitNumericValue(InstanceParser.NumericValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(InstanceParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(InstanceParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(InstanceParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(InstanceParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#charValue}.
	 * @param ctx the parse tree
	 */
	void enterCharValue(InstanceParser.CharValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#charValue}.
	 * @param ctx the parse tree
	 */
	void exitCharValue(InstanceParser.CharValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link InstanceParser#nullValue}.
	 * @param ctx the parse tree
	 */
	void enterNullValue(InstanceParser.NullValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link InstanceParser#nullValue}.
	 * @param ctx the parse tree
	 */
	void exitNullValue(InstanceParser.NullValueContext ctx);
}