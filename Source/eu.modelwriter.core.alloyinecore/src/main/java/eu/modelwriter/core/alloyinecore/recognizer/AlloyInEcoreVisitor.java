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
import eu.modelwriter.core.alloyinecore.structure.model.Model;
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

import eu.modelwriter.core.alloyinecore.structure.instance.ModelImport;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.instance.Slot;
import eu.modelwriter.core.alloyinecore.structure.instance.ObjectValue;
import eu.modelwriter.core.alloyinecore.structure.instance.EnumValue;
import eu.modelwriter.core.alloyinecore.structure.instance.IntegerValue;
import eu.modelwriter.core.alloyinecore.structure.instance.RealValue;
import eu.modelwriter.core.alloyinecore.structure.instance.BooleanValue;
import eu.modelwriter.core.alloyinecore.structure.instance.StringValue;
import eu.modelwriter.core.alloyinecore.structure.instance.NullValue;
import eu.modelwriter.core.alloyinecore.structure.instance.CharValue;

import eu.modelwriter.core.alloyinecore.structure.constraints.Formula;
import eu.modelwriter.core.alloyinecore.structure.constraints.Expression;
import eu.modelwriter.core.alloyinecore.structure.constraints.IntExpression;
import eu.modelwriter.core.alloyinecore.structure.constraints.QuantifierDeclaration;
import eu.modelwriter.core.alloyinecore.structure.constraints.LetDeclaration;
import eu.modelwriter.core.alloyinecore.structure.constraints.ComprehensionDeclaration;
import eu.modelwriter.core.alloyinecore.structure.constraints.Variable;

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
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#instance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstance(AlloyInEcoreParser.InstanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#modelImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelImport(AlloyInEcoreParser.ModelImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEObject(AlloyInEcoreParser.EObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#slot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlot(AlloyInEcoreParser.SlotContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#dataValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValue(AlloyInEcoreParser.DataValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#multiValueData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiValueData(AlloyInEcoreParser.MultiValueDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eObjectValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEObjectValue(AlloyInEcoreParser.EObjectValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#literalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralValue(AlloyInEcoreParser.LiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#enumValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumValue(AlloyInEcoreParser.EnumValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#booleanValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(AlloyInEcoreParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#integerValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerValue(AlloyInEcoreParser.IntegerValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#realValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealValue(AlloyInEcoreParser.RealValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#stringValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(AlloyInEcoreParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#charValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharValue(AlloyInEcoreParser.CharValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#nullValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullValue(AlloyInEcoreParser.NullValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(AlloyInEcoreParser.ModelContext ctx);
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
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eGenericException}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEGenericException(AlloyInEcoreParser.EGenericExceptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eGenericSuperType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEGenericSuperType(AlloyInEcoreParser.EGenericSuperTypeContext ctx);
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
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eTypeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitETypeParameter(AlloyInEcoreParser.ETypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eGenericTypeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEGenericTypeArgument(AlloyInEcoreParser.EGenericTypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eGenericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEGenericType(AlloyInEcoreParser.EGenericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eGenericElementType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEGenericElementType(AlloyInEcoreParser.EGenericElementTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#eGenericWildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEGenericWildcard(AlloyInEcoreParser.EGenericWildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#pathName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathName(AlloyInEcoreParser.PathNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegment(AlloyInEcoreParser.SegmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#ePrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEPrimitiveType(AlloyInEcoreParser.EPrimitiveTypeContext ctx);
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
	 * Visit a parse tree produced by the {@code typeRef}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRef(AlloyInEcoreParser.TypeRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boxJoin}
	 * labeled alternative in {@link AlloyInEcoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoxJoin(AlloyInEcoreParser.BoxJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(AlloyInEcoreParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConstant(AlloyInEcoreParser.IntConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code i_paranthesis}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI_paranthesis(AlloyInEcoreParser.I_paranthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifIntExpression}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfIntExpression(AlloyInEcoreParser.IfIntExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code count}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCount(AlloyInEcoreParser.CountContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(AlloyInEcoreParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divide}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(AlloyInEcoreParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(AlloyInEcoreParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(AlloyInEcoreParser.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link AlloyInEcoreParser#intExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(AlloyInEcoreParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#quantifierDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifierDeclarations(AlloyInEcoreParser.QuantifierDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneOf(AlloyInEcoreParser.OneOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loneOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoneOf(AlloyInEcoreParser.LoneOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeOf(AlloyInEcoreParser.SomeOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setOf}
	 * labeled alternative in {@link AlloyInEcoreParser#quantifierDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetOf(AlloyInEcoreParser.SetOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#letDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetDeclarations(AlloyInEcoreParser.LetDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#letDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetDeclaration(AlloyInEcoreParser.LetDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#comprehensionDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComprehensionDeclarations(AlloyInEcoreParser.ComprehensionDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#comprehensionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComprehensionDeclaration(AlloyInEcoreParser.ComprehensionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#relationId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationId(AlloyInEcoreParser.RelationIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(AlloyInEcoreParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlloyInEcoreParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(AlloyInEcoreParser.MultContext ctx);
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
}