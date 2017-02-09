// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/main/java/eu/modelwriter/core/alloyinecore/recognizer/AlloyInEcore.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.recognizer;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

import eu.modelwriter.core.alloyinecore.structure.base.INamespace;
import eu.modelwriter.core.alloyinecore.structure.base.Repository;
import eu.modelwriter.core.alloyinecore.structure.base.Element;

import eu.modelwriter.core.alloyinecore.structure.model.ModelElement;
import eu.modelwriter.core.alloyinecore.structure.model.Annotation;
import eu.modelwriter.core.alloyinecore.structure.model.AnnotationDetail;
import eu.modelwriter.core.alloyinecore.structure.model.AnnotationReference;
import eu.modelwriter.core.alloyinecore.structure.model.NamedElement;
import eu.modelwriter.core.alloyinecore.structure.model.Module;
import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.structure.model.EcoreImport;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import eu.modelwriter.core.alloyinecore.structure.model.RootPackage;
import eu.modelwriter.core.alloyinecore.structure.model.Classifier;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Interface;
import eu.modelwriter.core.alloyinecore.structure.model.DataType;
import eu.modelwriter.core.alloyinecore.structure.model.Enum;
import eu.modelwriter.core.alloyinecore.structure.model.EnumLiteral;
import eu.modelwriter.core.alloyinecore.structure.model.StructuralFeature;
import eu.modelwriter.core.alloyinecore.structure.model.TypedElement;
import eu.modelwriter.core.alloyinecore.structure.model.Multiplicity;
import eu.modelwriter.core.alloyinecore.structure.model.Reference;
import eu.modelwriter.core.alloyinecore.structure.model.Attribute;
import eu.modelwriter.core.alloyinecore.structure.model.Operation;
import eu.modelwriter.core.alloyinecore.structure.model.Parameter;
import eu.modelwriter.core.alloyinecore.structure.model.GenericException;
import eu.modelwriter.core.alloyinecore.structure.model.TypeParameter;
import eu.modelwriter.core.alloyinecore.structure.model.GenericType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericTypeArgument;
import eu.modelwriter.core.alloyinecore.structure.model.GenericElementType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericSuperType;
import eu.modelwriter.core.alloyinecore.structure.model.GenericWildcard;
import eu.modelwriter.core.alloyinecore.structure.model.PrimitiveType;
import eu.modelwriter.core.alloyinecore.structure.model.Invariant;
import eu.modelwriter.core.alloyinecore.structure.model.Derivation;
import eu.modelwriter.core.alloyinecore.structure.model.Body;
import eu.modelwriter.core.alloyinecore.structure.model.PostCondition;
import eu.modelwriter.core.alloyinecore.structure.model.PreCondition;
import eu.modelwriter.core.alloyinecore.structure.model.Initial;

import eu.modelwriter.core.alloyinecore.structure.model.Instance;
import eu.modelwriter.core.alloyinecore.structure.model.Object;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.structure.model.Value;

import eu.modelwriter.core.alloyinecore.structure.model.Formula;
import eu.modelwriter.core.alloyinecore.structure.model.Expression;
import eu.modelwriter.core.alloyinecore.structure.model.IntExpression;
import eu.modelwriter.core.alloyinecore.structure.model.QuantifierDeclaration;
import eu.modelwriter.core.alloyinecore.structure.model.LetDeclaration;
import eu.modelwriter.core.alloyinecore.structure.model.ComprehensionDeclaration;
import eu.modelwriter.core.alloyinecore.structure.model.Variable;

import eu.modelwriter.core.alloyinecore.internal.AnnotationSources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import java.io.IOException;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlloyInEcoreParser}.
 */
public interface AlloyInEcoreListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#options}.
	 * @param ctx the parse tree
	 */
	void enterOptions(AlloyInEcoreParser.OptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#options}.
	 * @param ctx the parse tree
	 */
	void exitOptions(AlloyInEcoreParser.OptionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code symmetryBreaking}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 */
	void enterSymmetryBreaking(AlloyInEcoreParser.SymmetryBreakingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code symmetryBreaking}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 */
	void exitSymmetryBreaking(AlloyInEcoreParser.SymmetryBreakingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitWidth}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 */
	void enterBitWidth(AlloyInEcoreParser.BitWidthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitWidth}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 */
	void exitBitWidth(AlloyInEcoreParser.BitWidthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code skolemDepth}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 */
	void enterSkolemDepth(AlloyInEcoreParser.SkolemDepthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code skolemDepth}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 */
	void exitSkolemDepth(AlloyInEcoreParser.SkolemDepthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sharing}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 */
	void enterSharing(AlloyInEcoreParser.SharingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sharing}
	 * labeled alternative in {@link AlloyInEcoreParser#option}.
	 * @param ctx the parse tree
	 */
	void exitSharing(AlloyInEcoreParser.SharingContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#instance}.
	 * @param ctx the parse tree
	 */
	void enterInstance(AlloyInEcoreParser.InstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#instance}.
	 * @param ctx the parse tree
	 */
	void exitInstance(AlloyInEcoreParser.InstanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#modelImport}.
	 * @param ctx the parse tree
	 */
	void enterModelImport(AlloyInEcoreParser.ModelImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#modelImport}.
	 * @param ctx the parse tree
	 */
	void exitModelImport(AlloyInEcoreParser.ModelImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eObject}.
	 * @param ctx the parse tree
	 */
	void enterEObject(AlloyInEcoreParser.EObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eObject}.
	 * @param ctx the parse tree
	 */
	void exitEObject(AlloyInEcoreParser.EObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#slot}.
	 * @param ctx the parse tree
	 */
	void enterSlot(AlloyInEcoreParser.SlotContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#slot}.
	 * @param ctx the parse tree
	 */
	void exitSlot(AlloyInEcoreParser.SlotContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#dataValue}.
	 * @param ctx the parse tree
	 */
	void enterDataValue(AlloyInEcoreParser.DataValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#dataValue}.
	 * @param ctx the parse tree
	 */
	void exitDataValue(AlloyInEcoreParser.DataValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#multiValueData}.
	 * @param ctx the parse tree
	 */
	void enterMultiValueData(AlloyInEcoreParser.MultiValueDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#multiValueData}.
	 * @param ctx the parse tree
	 */
	void exitMultiValueData(AlloyInEcoreParser.MultiValueDataContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eObjectValue}.
	 * @param ctx the parse tree
	 */
	void enterEObjectValue(AlloyInEcoreParser.EObjectValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eObjectValue}.
	 * @param ctx the parse tree
	 */
	void exitEObjectValue(AlloyInEcoreParser.EObjectValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void enterLiteralValue(AlloyInEcoreParser.LiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void exitLiteralValue(AlloyInEcoreParser.LiteralValueContext ctx);
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
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eGenericException}.
	 * @param ctx the parse tree
	 */
	void enterEGenericException(AlloyInEcoreParser.EGenericExceptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eGenericException}.
	 * @param ctx the parse tree
	 */
	void exitEGenericException(AlloyInEcoreParser.EGenericExceptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eGenericSuperType}.
	 * @param ctx the parse tree
	 */
	void enterEGenericSuperType(AlloyInEcoreParser.EGenericSuperTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eGenericSuperType}.
	 * @param ctx the parse tree
	 */
	void exitEGenericSuperType(AlloyInEcoreParser.EGenericSuperTypeContext ctx);
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
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterEAnnotation(AlloyInEcoreParser.EAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitEAnnotation(AlloyInEcoreParser.EAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eDetail}.
	 * @param ctx the parse tree
	 */
	void enterEDetail(AlloyInEcoreParser.EDetailContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eDetail}.
	 * @param ctx the parse tree
	 */
	void exitEDetail(AlloyInEcoreParser.EDetailContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eModelElement}.
	 * @param ctx the parse tree
	 */
	void enterEModelElement(AlloyInEcoreParser.EModelElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eModelElement}.
	 * @param ctx the parse tree
	 */
	void exitEModelElement(AlloyInEcoreParser.EModelElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eNamedElement}.
	 * @param ctx the parse tree
	 */
	void enterENamedElement(AlloyInEcoreParser.ENamedElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eNamedElement}.
	 * @param ctx the parse tree
	 */
	void exitENamedElement(AlloyInEcoreParser.ENamedElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eTypedElement}.
	 * @param ctx the parse tree
	 */
	void enterETypedElement(AlloyInEcoreParser.ETypedElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eTypedElement}.
	 * @param ctx the parse tree
	 */
	void exitETypedElement(AlloyInEcoreParser.ETypedElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eModelElementRef}.
	 * @param ctx the parse tree
	 */
	void enterEModelElementRef(AlloyInEcoreParser.EModelElementRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eModelElementRef}.
	 * @param ctx the parse tree
	 */
	void exitEModelElementRef(AlloyInEcoreParser.EModelElementRefContext ctx);
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
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eTypeParameter}.
	 * @param ctx the parse tree
	 */
	void enterETypeParameter(AlloyInEcoreParser.ETypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eTypeParameter}.
	 * @param ctx the parse tree
	 */
	void exitETypeParameter(AlloyInEcoreParser.ETypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eGenericTypeArgument}.
	 * @param ctx the parse tree
	 */
	void enterEGenericTypeArgument(AlloyInEcoreParser.EGenericTypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eGenericTypeArgument}.
	 * @param ctx the parse tree
	 */
	void exitEGenericTypeArgument(AlloyInEcoreParser.EGenericTypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eGenericType}.
	 * @param ctx the parse tree
	 */
	void enterEGenericType(AlloyInEcoreParser.EGenericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eGenericType}.
	 * @param ctx the parse tree
	 */
	void exitEGenericType(AlloyInEcoreParser.EGenericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eGenericElementType}.
	 * @param ctx the parse tree
	 */
	void enterEGenericElementType(AlloyInEcoreParser.EGenericElementTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eGenericElementType}.
	 * @param ctx the parse tree
	 */
	void exitEGenericElementType(AlloyInEcoreParser.EGenericElementTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#eGenericWildcard}.
	 * @param ctx the parse tree
	 */
	void enterEGenericWildcard(AlloyInEcoreParser.EGenericWildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#eGenericWildcard}.
	 * @param ctx the parse tree
	 */
	void exitEGenericWildcard(AlloyInEcoreParser.EGenericWildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#pathName}.
	 * @param ctx the parse tree
	 */
	void enterPathName(AlloyInEcoreParser.PathNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#pathName}.
	 * @param ctx the parse tree
	 */
	void exitPathName(AlloyInEcoreParser.PathNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterSegment(AlloyInEcoreParser.SegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitSegment(AlloyInEcoreParser.SegmentContext ctx);
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
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(AlloyInEcoreParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(AlloyInEcoreParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#invariant}.
	 * @param ctx the parse tree
	 */
	void enterInvariant(AlloyInEcoreParser.InvariantContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#invariant}.
	 * @param ctx the parse tree
	 */
	void exitInvariant(AlloyInEcoreParser.InvariantContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#precondition}.
	 * @param ctx the parse tree
	 */
	void enterPrecondition(AlloyInEcoreParser.PreconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#precondition}.
	 * @param ctx the parse tree
	 */
	void exitPrecondition(AlloyInEcoreParser.PreconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void enterPostcondition(AlloyInEcoreParser.PostconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void exitPostcondition(AlloyInEcoreParser.PostconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#initial}.
	 * @param ctx the parse tree
	 */
	void enterInitial(AlloyInEcoreParser.InitialContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#initial}.
	 * @param ctx the parse tree
	 */
	void exitInitial(AlloyInEcoreParser.InitialContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#derivation}.
	 * @param ctx the parse tree
	 */
	void enterDerivation(AlloyInEcoreParser.DerivationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#derivation}.
	 * @param ctx the parse tree
	 */
	void exitDerivation(AlloyInEcoreParser.DerivationContext ctx);
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
	 * Enter a parse tree produced by the {@code no}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNo(AlloyInEcoreParser.NoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code no}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNo(AlloyInEcoreParser.NoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code some}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterSome(AlloyInEcoreParser.SomeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code some}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitSome(AlloyInEcoreParser.SomeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forOne}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForOne(AlloyInEcoreParser.ForOneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forOne}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForOne(AlloyInEcoreParser.ForOneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sumDeclaration}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterSumDeclaration(AlloyInEcoreParser.SumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sumDeclaration}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitSumDeclaration(AlloyInEcoreParser.SumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forAll}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAll(AlloyInEcoreParser.ForAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forAll}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAll(AlloyInEcoreParser.ForAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lone}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLone(AlloyInEcoreParser.LoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lone}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLone(AlloyInEcoreParser.LoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lt}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLt(AlloyInEcoreParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lt}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLt(AlloyInEcoreParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forSome}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForSome(AlloyInEcoreParser.ForSomeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forSome}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForSome(AlloyInEcoreParser.ForSomeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNot(AlloyInEcoreParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNot(AlloyInEcoreParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterF_paranthesis(AlloyInEcoreParser.F_paranthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitF_paranthesis(AlloyInEcoreParser.F_paranthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnd(AlloyInEcoreParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnd(AlloyInEcoreParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code function}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFunction(AlloyInEcoreParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code function}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFunction(AlloyInEcoreParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gte}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterGte(AlloyInEcoreParser.GteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gte}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitGte(AlloyInEcoreParser.GteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code acyclic}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAcyclic(AlloyInEcoreParser.AcyclicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code acyclic}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAcyclic(AlloyInEcoreParser.AcyclicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code let}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLet(AlloyInEcoreParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code let}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLet(AlloyInEcoreParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lte}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLte(AlloyInEcoreParser.LteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lte}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLte(AlloyInEcoreParser.LteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterOr(AlloyInEcoreParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitOr(AlloyInEcoreParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code in}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterIn(AlloyInEcoreParser.InContext ctx);
	/**
	 * Exit a parse tree produced by the {@code in}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitIn(AlloyInEcoreParser.InContext ctx);
	/**
	 * Enter a parse tree produced by the {@code one}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterOne(AlloyInEcoreParser.OneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code one}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitOne(AlloyInEcoreParser.OneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code false}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFalse(AlloyInEcoreParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code false}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFalse(AlloyInEcoreParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iff}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterIff(AlloyInEcoreParser.IffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iff}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitIff(AlloyInEcoreParser.IffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eq}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEq(AlloyInEcoreParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eq}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEq(AlloyInEcoreParser.EqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gt}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterGt(AlloyInEcoreParser.GtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gt}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitGt(AlloyInEcoreParser.GtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEqual(AlloyInEcoreParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEqual(AlloyInEcoreParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forLone}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForLone(AlloyInEcoreParser.ForLoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forLone}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForLone(AlloyInEcoreParser.ForLoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code totalOrder}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterTotalOrder(AlloyInEcoreParser.TotalOrderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code totalOrder}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitTotalOrder(AlloyInEcoreParser.TotalOrderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterTrue(AlloyInEcoreParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitTrue(AlloyInEcoreParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forNo}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForNo(AlloyInEcoreParser.ForNoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forNo}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForNo(AlloyInEcoreParser.ForNoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code implies}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterImplies(AlloyInEcoreParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code implies}
	 * labeled alternative in {@link AlloyInEcoreParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitImplies(AlloyInEcoreParser.ImpliesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code product}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterProduct(AlloyInEcoreParser.ProductContext ctx);
	/**
	 * Exit a parse tree produced by the {@code product}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitProduct(AlloyInEcoreParser.ProductContext ctx);
	/**
	 * Enter a parse tree produced by the {@code none}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNone(AlloyInEcoreParser.NoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code none}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNone(AlloyInEcoreParser.NoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code union}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnion(AlloyInEcoreParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code union}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnion(AlloyInEcoreParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comprehension}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComprehension(AlloyInEcoreParser.ComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comprehension}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComprehension(AlloyInEcoreParser.ComprehensionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code univ}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUniv(AlloyInEcoreParser.UnivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code univ}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUniv(AlloyInEcoreParser.UnivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code reflexive}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReflexive(AlloyInEcoreParser.ReflexiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code reflexive}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReflexive(AlloyInEcoreParser.ReflexiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code e_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterE_paranthesis(AlloyInEcoreParser.E_paranthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code e_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitE_paranthesis(AlloyInEcoreParser.E_paranthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iden}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIden(AlloyInEcoreParser.IdenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iden}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIden(AlloyInEcoreParser.IdenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ints}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInts(AlloyInEcoreParser.IntsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ints}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInts(AlloyInEcoreParser.IntsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntersection(AlloyInEcoreParser.IntersectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntersection(AlloyInEcoreParser.IntersectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code difference}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDifference(AlloyInEcoreParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code difference}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDifference(AlloyInEcoreParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transpose}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTranspose(AlloyInEcoreParser.TransposeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transpose}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTranspose(AlloyInEcoreParser.TransposeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code join}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterJoin(AlloyInEcoreParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code join}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitJoin(AlloyInEcoreParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code override}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOverride(AlloyInEcoreParser.OverrideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code override}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOverride(AlloyInEcoreParser.OverrideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifExpression}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(AlloyInEcoreParser.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifExpression}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(AlloyInEcoreParser.IfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code closure}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterClosure(AlloyInEcoreParser.ClosureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code closure}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitClosure(AlloyInEcoreParser.ClosureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeRef}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTypeRef(AlloyInEcoreParser.TypeRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeRef}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTypeRef(AlloyInEcoreParser.TypeRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boxJoin}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoxJoin(AlloyInEcoreParser.BoxJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boxJoin}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoxJoin(AlloyInEcoreParser.BoxJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minus}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(AlloyInEcoreParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(AlloyInEcoreParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntConstant(AlloyInEcoreParser.IntConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntConstant(AlloyInEcoreParser.IntConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code i_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterI_paranthesis(AlloyInEcoreParser.I_paranthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code i_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitI_paranthesis(AlloyInEcoreParser.I_paranthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifIntExpression}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfIntExpression(AlloyInEcoreParser.IfIntExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifIntExpression}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfIntExpression(AlloyInEcoreParser.IfIntExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code count}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterCount(AlloyInEcoreParser.CountContext ctx);
	/**
	 * Exit a parse tree produced by the {@code count}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitCount(AlloyInEcoreParser.CountContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sum}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterSum(AlloyInEcoreParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitSum(AlloyInEcoreParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divide}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterDivide(AlloyInEcoreParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divide}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitDivide(AlloyInEcoreParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(AlloyInEcoreParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(AlloyInEcoreParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterModulo(AlloyInEcoreParser.ModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitModulo(AlloyInEcoreParser.ModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void enterPlus(AlloyInEcoreParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 */
	void exitPlus(AlloyInEcoreParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#quantifierDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterQuantifierDeclarations(AlloyInEcoreParser.QuantifierDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#quantifierDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitQuantifierDeclarations(AlloyInEcoreParser.QuantifierDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oneOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterOneOf(AlloyInEcoreParser.OneOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oneOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitOneOf(AlloyInEcoreParser.OneOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loneOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLoneOf(AlloyInEcoreParser.LoneOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loneOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLoneOf(AlloyInEcoreParser.LoneOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code someOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSomeOf(AlloyInEcoreParser.SomeOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code someOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSomeOf(AlloyInEcoreParser.SomeOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSetOf(AlloyInEcoreParser.SetOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSetOf(AlloyInEcoreParser.SetOfContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#letDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterLetDeclarations(AlloyInEcoreParser.LetDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#letDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitLetDeclarations(AlloyInEcoreParser.LetDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#letDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLetDeclaration(AlloyInEcoreParser.LetDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#letDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLetDeclaration(AlloyInEcoreParser.LetDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#comprehensionDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterComprehensionDeclarations(AlloyInEcoreParser.ComprehensionDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#comprehensionDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitComprehensionDeclarations(AlloyInEcoreParser.ComprehensionDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#comprehensionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterComprehensionDeclaration(AlloyInEcoreParser.ComprehensionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#comprehensionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitComprehensionDeclaration(AlloyInEcoreParser.ComprehensionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#relationId}.
	 * @param ctx the parse tree
	 */
	void enterRelationId(AlloyInEcoreParser.RelationIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#relationId}.
	 * @param ctx the parse tree
	 */
	void exitRelationId(AlloyInEcoreParser.RelationIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(AlloyInEcoreParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(AlloyInEcoreParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMult(AlloyInEcoreParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMult(AlloyInEcoreParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#unrestrictedName}.
	 * @param ctx the parse tree
	 */
	void enterUnrestrictedName(AlloyInEcoreParser.UnrestrictedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#unrestrictedName}.
	 * @param ctx the parse tree
	 */
	void exitUnrestrictedName(AlloyInEcoreParser.UnrestrictedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(AlloyInEcoreParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(AlloyInEcoreParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#numericValue}.
	 * @param ctx the parse tree
	 */
	void enterNumericValue(AlloyInEcoreParser.NumericValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#numericValue}.
	 * @param ctx the parse tree
	 */
	void exitNumericValue(AlloyInEcoreParser.NumericValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(AlloyInEcoreParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(AlloyInEcoreParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#charValue}.
	 * @param ctx the parse tree
	 */
	void enterCharValue(AlloyInEcoreParser.CharValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#charValue}.
	 * @param ctx the parse tree
	 */
	void exitCharValue(AlloyInEcoreParser.CharValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlloyInEcoreParser#nullValue}.
	 * @param ctx the parse tree
	 */
	void enterNullValue(AlloyInEcoreParser.NullValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlloyInEcoreParser#nullValue}.
	 * @param ctx the parse tree
	 */
	void exitNullValue(AlloyInEcoreParser.NullValueContext ctx);
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
}